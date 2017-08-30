package com.gms.web.dao;

import java.util.List;
import java.util.Map;

import com.gms.web.command.Command;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudBean;

public interface MemberDAO {
	//setter void -> int 이유 : setter후 성공여부 반환: 오라클에서 숫자값으로 return함
	public String insert(Map<?, ?> map);
	public String update(MemberBean member);	//pw
	public String delete(Command cmd);			//id
	//getter
	public List<?> selectAll(Command cmd);
	public String count(Command cmd);
	public StudBean selectByID(Command cmd);
	public List<?> selectByName(Command cmd);
	
	//login용 selectByID
	public MemberBean login(Command cmd);
}
