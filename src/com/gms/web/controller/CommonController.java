package com.gms.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.web.constant.Action;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;


@WebServlet({"/home.do", "/common.do"})
public class CommonController extends HttpServlet {	//지시전달(메뉴얼대로 움직임)
	private static final long serialVersionUID = 1L;
       
	//doGet, doPost 상관없이 동시에 처리함
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberBean bean = new MemberBean();
		Separator.init(request);
		
		System.out.println("CommonController 진입");
		System.out.println("action: "+Separator.cmd.getAction());
		
		switch(Separator.cmd.getAction()){
		case Action.MOVE:
			DispatcherServlet.send(request, response);	//2
			break;
		case Action.LOGIN:
			bean.setId(request.getParameter("id"));
			bean.setPw(request.getParameter("pw"));
			
			Map<String, Object> map = MemberServiceImpl.getInstance().login(bean);
			
			if(map.get("page").equals("main")){ //******
				session.setAttribute("user", map.get("user"));
			}
			
			Separator.cmd.setPage(String.valueOf(map.get("page")));
			Separator.cmd.process();
			
			DispatcherServlet.send(request, response);
			break;
		case Action.LOGOUT:
			session.invalidate();
			
			DispatcherServlet.send(request, response);
			break;
		default:
			DispatcherServlet.send(request, response);
			break;
		}
	}
}
