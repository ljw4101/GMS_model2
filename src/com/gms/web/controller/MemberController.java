package com.gms.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.Separator;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController get 진입");
		
		switch(request.getParameter("action")){
		case "move":
			DispatcherServlet.send(request, response);
			break;
		case "insert":
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
		System.out.println("Do Post 진입");
	}

}
