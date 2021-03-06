package com.gms.web.dao;

import java.util.List;

import com.gms.web.domain.ArticleBean;

public interface ArticleDAO {
	//setter void -> int 이유 : setter후 성공여부 반환: 오라클에서 숫자값으로 return함
	public String insert(ArticleBean bean);
	public String update(ArticleBean bean);
	public String delete(int seq);
	//getter
	public List<ArticleBean> selectAll();
	public String count();
	public ArticleBean selectBySeq(int seq); //primary key 리턴타입은 Bean이다.
	public List<ArticleBean> selectById(String id);
}
