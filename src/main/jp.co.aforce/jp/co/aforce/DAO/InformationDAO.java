package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.been.MemberInformation;

public class InformationDAO extends DAO{
	
	public List<MemberInformation> search(String keyword) throws Exception{
		List<MemberInformation> list=new ArrayList<>();
		
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"select * from member where MEMBER_ID = ?");
		st.setString(1, keyword);
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			MemberInformation p = new MemberInformation();
			p.setId(rs.getString("MEMBER_ID"));
			p.setLname(rs.getString("LAST_NAME"));
			p.setFname(rs.getString("FARST_NAME"));
			p.setSex(rs.getString("SEX"));
			p.setByear(rs.getInt("BIRTH_YEAR"));
			p.setBmonth(rs.getInt("BIRTH_MONTH"));
			p.setBday(rs.getInt("BIRTH_DAY"));
			p.setPnumber(rs.getString("PHONE_NUMBER"));
			p.setMail(rs.getString("MAIL_ADDRESS"));
			p.setJob(rs.getString("JOB"));
		}
		
		st.close();
		con.close();
		
		return list;
		}
	public int insert(MemberInformation MemberInformation) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
			"insert into member values(?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, MemberInformation.getId());
		st.setString(2, MemberInformation.getLname());
		st.setString(3, MemberInformation.getFname());
		st.setString(4, MemberInformation.getSex());
		st.setInt(5, MemberInformation.getByear());
		st.setInt(6, MemberInformation.getBmonth());
		st.setInt(7, MemberInformation.getBday());
		st.setString(8, MemberInformation.getPnumber());
		st.setString(9, MemberInformation.getMail());
		st.setString(10, MemberInformation.getJob());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	public int update(MemberInformation MemberInformation) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"UPDATE member SET LAST_NAME=?,FARST_NAME=?,SEX=?,BIRTH_YEAR=?,"
				+ "BIRTH_MONTH=?,BIRTH_DAY=?,PHONE_NUMBER=?,MAIL_ADDRESS=?,JOB=? WHERE MEMBER_ID=?");
		st.setString(1, MemberInformation.getLname());
		st.setString(2, MemberInformation.getFname());
		st.setString(3, MemberInformation.getSex());
		st.setInt(4, MemberInformation.getByear());
		st.setInt(5, MemberInformation.getBmonth());
		st.setInt(6, MemberInformation.getBday());
		st.setString(7, MemberInformation.getPnumber());
		st.setString(8, MemberInformation.getMail());
		st.setString(9, MemberInformation.getJob());
		st.setString(10, MemberInformation.getId());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	public int delete(MemberInformation MemberInformation) throws Exception{
		Connection con=getConnection();
		
		PreparedStatement st=con.prepareStatement(
				"DELETE FROM member WHERE MEMEBR_ID = ?");
		st.setString(1, MemberInformation.getId());
		int line=st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}
	}


