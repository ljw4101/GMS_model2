package com.gms.web.util;

import javax.servlet.http.HttpServletRequest;
import com.gms.web.command.Command;
import com.gms.web.factory.CommandFactory;

public class Separator {
	public static Command cmd = new Command();
	
	public static void init(HttpServletRequest request){
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		
		String servletPath = request.getServletPath(); //request가 건너온 경로
		String dir = servletPath.substring(1, servletPath.indexOf("."));
		
		cmd = CommandFactory.createCommand(dir, action, page);
	}
}
