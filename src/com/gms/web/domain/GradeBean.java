package com.gms.web.domain;

import java.io.Serializable;
import lombok.Getter;

public class GradeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mem_id, exam_date, score;
	private int gradeSeq;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getExam_date() {
		return exam_date;
	}
	public void setExam_date(String exam_date) {
		this.exam_date = exam_date;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public int getGradeSeq() {
		return gradeSeq;
	}
	public void setGradeSeq(int gradeSeq) {
		this.gradeSeq = gradeSeq;
	}
	
	public String toString(){
		return String.format("%d %s %s %s %s %d\n", gradeSeq, mem_id, exam_date, score);
	}
}
