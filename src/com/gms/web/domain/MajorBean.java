package com.gms.web.domain;

import java.io.Serializable;

public class MajorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String majorId, title, memId, subjId;

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getSubjId() {
		return subjId;
	}

	public void setSubjId(String subjId) {
		this.subjId = subjId;
	}
	
	@Override
	public String toString() {
		return "MajorBean [majorId=" + majorId + ", title=" + title + ", memId=" + memId + ", subjId=" + subjId + "]";
	}
}
