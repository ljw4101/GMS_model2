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
import javax.servlet.http.HttpSession;

import com.gms.web.command.Command;
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
		Map<?,?> map = new HashMap<>();
		
		PageProxy pxy = new PageProxy(request);
		Command cmd = new Command();
		pxy.setPageSize(5);
		pxy.setBlockSize(5);
		
		System.out.println("MemberController 진입");
		System.out.println(request.getParameter(Action.CMD));
		
		switch(request.getParameter(Action.CMD)){
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.INSERT:
			System.out.println("=== join 진입 ===");	
			map=ParamsIterator.execute(request); //ParamsIterator 호출
			
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
			
			Separator.cmd.setDir("common");
			Separator.cmd.process();
			
			DispatcherServlet.send(request, response);
			break;
		case Action.LIST:
			System.out.println("===Member List IN===");	
			//cmd.setColumn(String.valueOf(map.get("column")));
			//cmd.setSearch(String.valueOf(map.get("search")));
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));
			pxy.setPageNumber(Integer.parseInt(request.getParameter("pageNumber"))); //선택한 페이지
			pxy.execute(BlockHandler.attr(pxy), service.getMembers(PageHandler.attr(pxy)));
			
			DispatcherServlet.send(request, response);
			break;
		case Action.SEARCH:
			System.out.println("=== Search IN===");
			map=ParamsIterator.execute(request);
			cmd = PageHandler.attr(pxy);
			cmd.setPageNumber(request.getParameter("pageNumber"));
			cmd.setColumn("name");
			cmd.setSearch(String.valueOf(map.get("search")));
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd))); //검색한 결과의 count가 필요
			cmd.setStartRow(PageHandler.attr(pxy).getStartRow());
			cmd.setEndRow(PageHandler.attr(pxy).getEndRow());
			pxy.setPageNumber(Integer.parseInt(cmd.getPageNumber())); //선택한 페이지
			pxy.execute(BlockHandler.attr(pxy), service.findByName(cmd));
			
			DispatcherServlet.send(request, response);
			break;
		case Action.UPDATE:
			System.out.println("=== UPDATE 진입 ===");
			cmd.setSearch(request.getParameter("id"));
			//service.modifyPw(service.findByID(cmd));
			
			DispatcherServlet.send(request, response);
			break;
		case Action.DELETE:
			System.out.println("=== DELETE 진입 ===");
			cmd.setSearch(request.getParameter("id"));
			service.removeMember(cmd);
			
			String path = request.getContextPath();
			response.sendRedirect(path+"/member.do?action=list&page=member_list&pageNumber=1");
			break;
		case Action.DETAIL:
			System.out.println("=== DETAIL 진입 ===");
			cmd.setSearch(request.getParameter("id"));
			request.setAttribute("stud", service.findByID(cmd));
			
			DispatcherServlet.send(request, response);
			break;
		default:
			System.out.println("MemberController FAIL...");
			break;
		}
	}
}
