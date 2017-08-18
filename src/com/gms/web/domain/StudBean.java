package com.gms.web.domain;

import lombok.Data;

@Data //getter, setter 기능을 대신함
public class StudBean {
	private String num, id, name, ssn, phone, email, title, regdate, profile;
}
