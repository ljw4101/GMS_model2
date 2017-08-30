package com.gms.web.service;

import java.util.*;

import com.gms.web.command.Command;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudBean;

public interface MemberService {
	//setter void-> String : 사용자에게 결과후 성공여부 message 반환
	public String addMember(Map<String, Object> map);
	public String modifyPw(MemberBean member);
	public String removeMember(Command cmd);
	//getter
	public List<?> getMembers(Command cmd);	//목록(list): MemberBean을 배열로 담음
	public List<?> findByName(Command cmd);
	public StudBean findByID(Command cmd);
	public String countMembers(Command cmd);
	
	public Map<String, Object> login(MemberBean member); //(패스워드)은닉화를 위해 bean으로 담음
}
