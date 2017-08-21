package com.gms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.constant.Action;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudBean;
import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request);
		MemberBean member = new MemberBean();
		MemberService service = MemberServiceImpl.getInstance(); //singleton
		
		System.out.println("MemberController 진입");
		System.out.println(request.getParameter(Action.CMD));
		
		switch(request.getParameter(Action.CMD)){
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.INSERT:
			System.out.println("=== join 진입 ===");	
			Map<?,?> map=ParamsIterator.execute(request); //ParamsIterator 호출
			
			member.setId((String)map.get("id"));
			member.setPw((String)map.get("pw"));
			member.setName((String)map.get("name"));
			member.setBirthday((String)map.get("birth"));
			member.setGender((String)map.get("gender"));
			member.setEmail((String)map.get("email"));
			member.setPhone((String)map.get("phone"));
			member.setMajor((String)map.get("major"));
			member.setProfile("profile.jpg");
			
			String[] subjects=((String)map.get("subject")).split(","); //subject 분리하여 db입력 위함
			List<MajorBean> list=new ArrayList<>();
			MajorBean major=null;
			for(int i=0;i<subjects.length;i++){
				major=new MajorBean();
				major.setMajorId(String.valueOf((int)((Math.random() * 9999) + 1000)));
				major.setMemId((String)map.get("id"));
				major.setTitle((String)map.get("name"));
				major.setSubjId(subjects[i]);
				list.add(major);
			}
			Map<String,Object>tempMap=new HashMap<>();
			tempMap.put("member", member);
			tempMap.put("major", list);
			service.addMember(tempMap);
			
			Separator.cmd.setDirectory("common");
			Separator.cmd.process();
			
			DispatcherServlet.send(request, response);
			break;
		case Action.LIST:
			System.out.println("===Member List IN===");
			PageProxy pxy = new PageProxy(request);
			pxy.setPageSize(5);
			pxy.setBlockSize(5);
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers()));
			pxy.setPageNumber(Integer.parseInt(request.getParameter("pageNumber"))); //선택한 페이지
			int[] arr = PageHandler.attr(pxy);
			int[] arr2 = BlockHandler.attr(pxy);
			pxy.execute(arr2, service.getMembers(arr));
			
			DispatcherServlet.send(request, response);
			break;
		case Action.UPDATE:
			System.out.println("=== UPDATE 진입 ===");
			service.modifyPw(service.findByID(request.getParameter("id")));
			
			DispatcherServlet.send(request, response);
			break;
		case Action.DELETE:
			System.out.println("=== DELETE 진입 ===");
			service.removeMember(request.getParameter("id"));
			String path = request.getContextPath();
			response.sendRedirect(path+"/member.do?action=list&page=member_list&pageNumber=1");
			break;
		case Action.DETAIL:
			System.out.println("=== DETAIL 진입 ===");
			request.setAttribute("stud", service.findByID(request.getParameter("id")));
			
			DispatcherServlet.send(request, response);
			break;
		default:
			System.out.println("FAIL...");
			break;
		}
	}


}
