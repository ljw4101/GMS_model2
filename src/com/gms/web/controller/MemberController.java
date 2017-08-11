package com.gms.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.web.constant.Action;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request);
		
		System.out.println("MemberController 진입");
		System.out.println(request.getParameter(Action.CMD));
		
		switch(request.getParameter(Action.CMD)){
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;
		case Action.INSERT:
			break;
		case Action.UPDATE:
			break;
		case Action.DELETE:
			break;
		default:
			DispatcherServlet.send(request, response);
			break;
		}
	}


}
