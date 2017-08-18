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
			@SuppressWarnings("unchecked")
			List<StudBean> mList = (List<StudBean>)service.getMembers(); 
			System.out.println("List<StudBean>: "+mList);
			
			request.setAttribute("pageNumber",request.getParameter("pageNum"));
			request.setAttribute("prevBlock", "0");
			request.setAttribute("startPage", "1");

			//5:한 페이지에서 보여주는 회원 수
			int theNumberOfPages = (mList.size()%5!=0)?mList.size()/5+1:mList.size()/5;
			request.setAttribute("theNumberOfPages", theNumberOfPages);
			request.setAttribute("endPage", String.valueOf(theNumberOfPages));
			
			System.out.println("DB에서 가져온 MemberList");
			request.setAttribute("list", mList);
			
			DispatcherServlet.send(request, response);
			break;
		case Action.UPDATE:
			break;
		case Action.DELETE:
			break;
		default:
			System.out.println("FAIL...");
			break;
		}
	}


}
