package com.gms.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gms.web.command.Command;
import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.dao.MemberDAO;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudBean;
import com.gms.web.factory.DatabaseFactory;

import java.sql.*; //0

public class MemberDAOImpl implements MemberDAO{
	
	//public static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}
	
	Connection conn;
	private MemberDAOImpl(){ //생성자를 private로 설정하면 다른곳에서 호출 못함
		conn=null;
	}	
	
	@Override
	public String insert(Map<?, ?> map) {
		String rs = "";
		MemberBean member = (MemberBean)map.get("member");
		@SuppressWarnings("unchecked")
		List<MajorBean> list = (List<MajorBean>)map.get("major");
		PreparedStatement pstmt=null;
		
		//2개 테이블을 넣을 땐 다음과 같이 분리하여야 한다.
		try {		
			conn = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			conn.setAutoCommit(false); //transaction

			//member table
			pstmt = conn.prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getBirthday());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, "profile.jpg");
			System.out.println("*** "+SQL.MEMBER_INSERT);
			pstmt.executeUpdate();	
			
			//major table
			for(int i=0; i<list.size(); i++){
				pstmt = conn.prepareStatement(SQL.MAJOR_INSERT);
				pstmt.setString(1, list.get(i).getMajorId());
				pstmt.setString(2, list.get(i).getTitle());
				pstmt.setString(3, list.get(i).getMemId());
				pstmt.setString(4, list.get(i).getSubjId());
				rs = String.valueOf(pstmt.executeUpdate());
				System.out.println("*** "+SQL.MAJOR_INSERT);
				System.out.println("***** "+rs);
			}

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn != null){
				try{ 
					conn.rollback();
				}catch(SQLException ex){
					e.printStackTrace();
				}
			}
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public String update(MemberBean member) {
		String rs = "";	
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPw());
			pstmt.setString(4, member.getId());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(Command cmd) {
		String rs = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, cmd.getSearch());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<?> selectAll(Command cmd) {
		List<StudBean> list = new ArrayList<>();	
		
		try {
			conn = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SQL.STUD_LIST);
			pstmt.setString(1, cmd.getStartRow());
			pstmt.setString(2, cmd.getEndRow());
			ResultSet rs = pstmt.executeQuery();
			
			StudBean bean = null;
			while(rs.next()){
				bean = new StudBean(); //new StudBean(); heap에 넣어지는 주소지가 됨
				bean.setNum(rs.getString(DB.NUM));
				bean.setId(rs.getString(DB.ID));
				bean.setName(rs.getString(DB.NAME));
				bean.setSsn(rs.getString(DB.SSN));
				bean.setPhone(rs.getString(DB.PHONE));
				bean.setEmail(rs.getString(DB.EMAIL));
				bean.setTitle(rs.getString(DB.TITLE));
				//bean.setProfile(rs.getString(DB.MEM_PROFILE));
				bean.setRegdate(rs.getString(DB.REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String count(Command cmd) {
		System.out.println("count= "+cmd.getColumn());
		System.out.println("count= "+cmd.getSearch());
		String cnt="";

		try {
			conn = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			PreparedStatement pstmt = null;
			
			if(cmd.getSearch()==null){
				System.out.println("cmd.getSearch() is null");
				pstmt = conn.prepareStatement(SQL.STUD_COUNT);
				pstmt.setString(1, "%");
			}else{
				System.out.println("cmd.getSearch() is not null");
				pstmt = conn.prepareStatement(SQL.STUD_COUNT);
				pstmt.setString(1, "%"+cmd.getSearch()+"%");
			}
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				cnt = rs.getString("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public StudBean selectByID(Command cmd) {
		StudBean bean = null;
		
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUD_FINDBYID);
			pstmt.setString(1, cmd.getSearch());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){	//return값이 한개이므로 if사용
				bean = new StudBean(); //new StudBean(); heap에 넣어지는 주소지가 됨
				bean.setNum(rs.getString(DB.NUM));
				bean.setId(rs.getString(DB.ID));
				bean.setName(rs.getString(DB.NAME));
				bean.setSsn(rs.getString(DB.SSN));
				bean.setPhone(rs.getString(DB.PHONE));
				bean.setEmail(rs.getString(DB.EMAIL));
				bean.setTitle(rs.getString(DB.TITLE));
				//bean.setProfile(rs.getString(DB.MEM_PROFILE));
				bean.setRegdate(rs.getString(DB.REGDATE));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<?> selectByName(Command cmd) {
		System.out.println("selectByName: "+cmd.getSearch());
		System.out.println("selectByName: "+cmd.getColumn());
		List<StudBean> list = new ArrayList<>();	
		StudBean stubean = null;
		
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUD_FINDBYNAME);
			pstmt.setString(1, "%"+cmd.getSearch()+"%");  
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("selectName: select t.num, t.id, t.name, t.ssn, t.phone, t.email, t.title, t.regdate from (select rownum rnum, s.* from v_stud s where name like "+"'%"+cmd.getSearch()+"%'"+")t where t.rnum between "+cmd.getStartRow()+" and "+cmd.getEndRow());
			
			while(rs.next()){
				stubean = new StudBean(); //new StudBean(); heap에 넣어지는 주소지가 됨
				stubean.setNum(rs.getString(DB.NUM));
				stubean.setId(rs.getString(DB.ID));
				stubean.setName(rs.getString(DB.NAME));
				stubean.setSsn(rs.getString(DB.SSN));
				stubean.setPhone(rs.getString(DB.PHONE));
				stubean.setEmail(rs.getString(DB.EMAIL));
				stubean.setTitle(rs.getString(DB.TITLE));
				//bean.setProfile(rs.getString(DB.MEM_PROFILE));
				stubean.setRegdate(rs.getString(DB.REGDATE));
				list.add(stubean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberBean login(Command cmd) {
		MemberBean bean = null;
		
		try {
			PreparedStatement pstmt = DatabaseFactory.createDataBase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, cmd.getSearch());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){	//return값이 한개이므로 if사용
				bean = new MemberBean();
				bean.setId(rs.getString(DB.MEM_ID));
				bean.setName(rs.getString(DB.NAME));
				bean.setPw(rs.getString(DB.MEM_PW));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
}
