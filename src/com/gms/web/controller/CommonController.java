package com.gms.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gms.web.constant.Action;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;


@WebServlet("/common.do")
public class CommonController extends HttpServlet {	//지시전달(메뉴얼대로 움직임)
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CommonController get 진입");
		Separator.init(request);
		
		switch(request.getParameter(Action.CMD)){
		case Action.MOVE:
			DispatcherServlet.send(request, response);	//2
			break;
		case Action.LOGIN:
			MemberBean bean = new MemberBean();
			bean.setId(request.getParameter("id"));
			bean.setPw(request.getParameter("pw"));
			String result = MemberServiceImpl.getInstance().login(bean);
			
			Separator.cmd.setPage(result);
			Separator.cmd.process();
			
			DispatcherServlet.send(request, response);
			break;
		case "update":
			break;
		case "delete":
			break;
		default:
			DispatcherServlet.send(request, response);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
