package com.gms.web.dao;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberDAO {
	//setter void -> int 이유 : setter후 성공여부 반환: 오라클에서 숫자값으로 return함
	public String insert(Map<?, ?> map);
	public String update(MemberBean member);	//pw
	public String delete(String id);			//id
	//getter
	public List<?> selectAll(Object o);
	public String count();
	public MemberBean selectByID(String id);
	public List<?> selectByName(String name);
}
