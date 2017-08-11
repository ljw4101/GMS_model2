package com.gms.web.factory;

import com.gms.web.command.*;
import com.gms.web.constant.Action;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;

//CommonController 관계: 명렁어 생성(메뉴얼 작성자) / MoveCommand 관계: 생산자
public class CommandFactory {
	public static Command createCommand(String dir, String action, String page){
		Command cmd=null; //sub객체를 인스턴스화하기 위해 생성
		
		switch(action){
		case Action.MOVE:
		case Action.LOGIN:
		case Action.LOGOUT:
			cmd = new MoveCommand(dir, action, page); //다형성
			break;
		default:
			System.out.println("Commad Fail");
			break;
		}
		return cmd;
	}
}
