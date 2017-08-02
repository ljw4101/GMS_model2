package com.gms.web.constant;

public class DB {
	public static final String ORACLE_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String DB2_DRIVER="";
	public static final String DB2_URL="";
	public static final String MYSQL_DRIVER="";
	public static final String MYSQL_URL="";
	public static final String MSSQL_DRIVER="";
	public static final String MSSQL_URL="";
	public static final String MARIADB_DRIVER="";
	public static final String MARIADB_URL="";
	
	public static final String USERNAME="hanbit";
	public static final String PASSWORD="hanbit";
	
	//테이블명 및 컬럼명 수정시 여기만 바꾸면 된다.
	//코딩시 상수풀을 검색할 필요가 없으니 빨라짐.
	//오타, 실수 예방
	public static final String TABLE_MEMBER="member";
	public static final String MEM_ID="id";
	public static final String MEM_NAME="name";
	public static final String MEM_PW="pw";
	public static final String MEM_SSN="ssn";
	public static final String MEM_REGDATE="regdate";
	
	public static final String TABLE_BOARD="board";
	public static final String BO_SEQ="article_seq";
	public static final String BO_ID="id";
	public static final String BO_TITLE="title";
	public static final String BO_CONTENT="content";
	public static final String BO_HITCOUNT="hitcount";
	public static final String BO_REGDATE="regdate";
}
