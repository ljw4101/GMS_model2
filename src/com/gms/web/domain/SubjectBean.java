package com.gms.web.domain;

import java.io.Serializable;

public class SubjectBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String subjId, title;

	public String getSubjId() {
		return subjId;
	}

	public void setSubjId(String subjId) {
		this.subjId = subjId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "SubjectBean [subjId=" + subjId + ", title=" + title + "]";
	}
}
