package com.gms.web.service;

import java.util.List;
import com.gms.web.domain.ArticleBean;
import com.gms.web.domain.MemberBean;

public interface ArticleService {
	//setter : 사용자에게 결과후 성공여부 message 반환
	public String write(ArticleBean bean);
	public String modify(ArticleBean bean);
	public String remove(int seq);
	//getter
	public List<ArticleBean> list();
	public String countArticles();
	public ArticleBean findBySeq(int seq);
	public List<ArticleBean> findById(String id);	
}
