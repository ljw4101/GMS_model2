package com.gms.web.service;

import java.util.*;
import com.gms.web.domain.MemberBean;

public interface MemberService {
	//setter void-> String : 사용자에게 결과후 성공여부 message 반환
	public String addMember(Map<String, Object> map);
	public String modifyPw(MemberBean member);
	public String removeMember(String id);
	//getter
	public List<?> getMembers(Object o);	//목록(list): MemberBean을 배열로 담음
	public String countMembers();
	public MemberBean findByID(String id);
	public List<?> findByName(String name);
	
	public Map<String, Object> login(MemberBean member); //(패스워드)은닉화를 위해 bean으로 담음
}
