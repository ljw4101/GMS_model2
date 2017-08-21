package com.gms.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	//public static MemberServiceImpl instance = new MemberServiceImpl();	
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl(){}
	
	@Override
	public String addMember(Map<String, Object> map) {
		System.out.println("member service 진입");
		MemberBean m=(MemberBean)map.get("member");
		
		System.out.println("넘어온 회원 정보:"+m.toString());
		@SuppressWarnings("unchecked")
		
		List<MajorBean>list=(List<MajorBean>)map.get("major");
		System.out.println("넘어온 수강과목:"+list);
		MemberDAOImpl.getInstance().insert(map);
		
		return null;
	}

	@Override
	public List<?> getMembers(Object o) {
		return MemberDAOImpl.getInstance().selectAll(o);
	}

	@Override
	public String countMembers() {
		return MemberDAOImpl.getInstance().count();
	}

	@Override
	public MemberBean findByID(String id) {
		MemberBean member = new MemberBean();
		member = MemberDAOImpl.getInstance().selectByID(id);
		
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public String modifyPw(MemberBean bean) {

		String msg="";
		MemberBean member = new MemberBean();
		String rs = MemberDAOImpl.getInstance().update(bean);
		msg = (rs.equals("1"))?"update 성공":"update 실패";
		
		return msg;
	}

	@Override
	public String removeMember(String id) {
		String msg="";
		String rs = MemberDAOImpl.getInstance().delete(id);
		msg = (rs.equals("1"))?"delete 성공":"delete 실패";
		
		return msg;
	}
	@Override
	public Map<String, Object> login(MemberBean member) {	
		Map<String, Object> map = new HashMap<>();
		MemberBean m = findByID(member.getId());
		
		String page = (m!=null)?(m.getPw().equals(member.getPw()))?"main":"login_fail":"join";
		
		map.put("page", page);
		map.put("user", m);
		
		return map;
	}
}
