package com.gms.web.dao;

import java.util.List;

import com.gms.web.domain.GradeBean;

public interface GradeDAO {
	//setter void -> int 이유 : setter후 성공여부 반환: 오라클에서 숫자값으로 return함
	public String insert(GradeBean bean);
	public String update(GradeBean bean);
	public String delete(int seq);
	//getter
	public List<GradeBean> selectAll();
	public String count();
	public GradeBean selectBySeq(int seq); //primary key 리턴타입은 Bean이다.
	public List<GradeBean> selectById(String id);
}
