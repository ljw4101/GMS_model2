package com.gms.web.service;

import java.util.List;
import com.gms.web.domain.MemberBean;

public interface MemberService {
	//setter void-> String : 사용자에게 결과후 성공여부 message 반환
	public String addMember(MemberBean member);
	public String modifyPw(MemberBean member);
	public String removeMember(String id);
	//getter
	public List<MemberBean> getMembers();	//목록: MemberBean을 배열로 담음
	public String countMembers();
	public MemberBean findByID(String id);
	public List<MemberBean> findByName(String name);
	
	public String login(MemberBean member); //(패스워드)은닉화를 위해 bean으로 담음
}
