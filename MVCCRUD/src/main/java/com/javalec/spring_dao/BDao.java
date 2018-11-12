package com.javalec.spring_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.spring_dto.BDto;

public class BDao {

	DataSource ds = null;

	public BDao() {

		try {
			Context con = new InitialContext();
			ds = (DataSource) con.lookup("java:comp/env/jdbc/myoracle");

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}

	public ArrayList<BDto> list() {
		// TODO Auto-generated method stub

		Connection myconn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<BDto> dtos = new ArrayList<BDto>();

		try {

			myconn = ds.getConnection();
			String query = "select * from mvc_board order by bGroup desc, bStep asc";
			pst = myconn.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {

				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		try {
			if (myconn != null) {
				myconn.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dtos;

	}

	public void write(String bName, String bTitle, String bContent) {
		// TODO Auto-generated method stub

		PreparedStatement pst = null;
		Connection myconn = null;

		try {
			myconn = ds.getConnection();
			String query = "insert into mvc_board (bId,bName,bTitle,bContent,bHit,bGroup,bStep,bIndent) values (mvc_board_seq.nextval,?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
			pst = myconn.prepareStatement(query);
			pst.setString(1, bName);
			pst.setString(2, bTitle);
			pst.setString(3, bContent);
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		try {
			if (pst != null) {
				pst.close();
			}
			if (myconn != null) {
				myconn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public BDto content_view(String strbId) {
		// TODO Auto-generated method stub

		upHit(strbId);

		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection myconn = null;
		BDto dto = null;

		try {

			myconn = ds.getConnection();
			String query = "select * from mvc_board where bId=?";
			pst = myconn.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(strbId));
			rs = pst.executeQuery();
			if (rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (myconn != null) {
				myconn.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return dto;

	}

	private void upHit(String strbId) {
		// TODO Auto-generated method stub

		PreparedStatement pst = null;
		Connection myconn = null;

		try {

			myconn = ds.getConnection();
			String query = "update mvc_board set bHit = bHit + 1 where bId=?";
			pst = myconn.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(strbId));
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		try {
			if (pst != null) {
				pst.close();
			}
			if (myconn != null) {
				myconn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public BDto modify_view(String sbId) {
		// TODO Auto-generated method stub
		
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection myconn = null;
		BDto dto = null;
		
		try {
			
			myconn = ds.getConnection();
			String query = "select * from mvc_board where bId=?";
			pst = myconn.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(sbId));
			rs= pst.executeQuery();
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
			    Timestamp bDate = rs.getTimestamp("bDate");
			    int bHit = rs.getInt("bHit");
			    int bGroup = rs.getInt("bGroup");
			    int bStep = rs.getInt("bStep");
			    int bIndent = rs.getInt("bIndent");
			   
			    dto = new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}try {
			if(pst!=null) {pst.close();}
			if(myconn!=null) {myconn.close();}
			if(rs!=null) {rs.close();}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst = null;
		Connection myconn = null;
		
		try {
			
			myconn = ds.getConnection();
			String query = "update mvc_board set bName=?, bTitle=?, bContent=? where bId=?";
			pst = myconn.prepareStatement(query);
			pst.setString(1, bName);
			pst.setString(2, bTitle);
			pst.setString(3, bContent);
			pst.setInt(4, Integer.parseInt(bId));
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}try {
			if(pst!=null) {pst.close();}
			if(myconn!=null) {myconn.close();}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	public void delete(String bId) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst = null;
		Connection myconn = null;
		
		try {
			
			myconn = ds.getConnection();
			String query = "delete mvc_board where bId=?";
			pst = myconn.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(bId));
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}try {
			if(pst!=null) {pst.close();}
			if(myconn!=null) {myconn.close();}
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		
	}
	
	public BDto reply_view(String sbId) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection myconn = null;
		BDto dto = null;
		
		try {
			
			myconn = ds.getConnection();
			String query = "select * from mvc_board where bId = ?";
			pst = myconn.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(sbId));
			rs = pst.executeQuery();
			while(rs.next()) {
			  
				int bId = rs.getInt("bId");
			    String bName = rs.getString("bName");
			    String bTitle = rs.getString("bTitle");
			    String bContent = rs.getString("bContent");
			    Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}try {
			if(pst!=null) {pst.close();}
			if(myconn!=null) {myconn.close();}
			if(rs!=null) {rs.close();}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dto;
		
	}

	
	

	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		// TODO Auto-generated method stub
		
		
		replyCount(bGroup, bStep);
		
		
		PreparedStatement pst = null;
		Connection myconn = null;
		
		try {
			
			myconn = ds.getConnection();
			String query = "insert into mvc_board (bId,bName,bTitle,bContent,bGroup,bStep,bIndent) values (mvc_board_seq.nextval,?,?,?,?,?,?)";
			pst = myconn.prepareStatement(query);
			pst.setString(1, bName);
			pst.setString(2, bTitle);
			pst.setString(3, bContent);
			pst.setInt(4, Integer.parseInt(bGroup));
			pst.setInt(5, Integer.parseInt(bStep) + 1);
			pst.setInt(6, Integer.parseInt(bIndent) + 1 );
			
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}try {
			if(pst!=null) {pst.close();}
			if(myconn!=null) {myconn.close();}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	private void replyCount(String bGroup, String bStep) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst = null;
		Connection myconn = null;
		
		try {
			
			myconn = ds.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 bGroup = ? and bStep > ?";
			pst = myconn.prepareStatement(query);
			pst.setInt(1, Integer.parseInt(bGroup));
			pst.setInt(2, Integer.parseInt(bStep));
			pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}try {
			if(pst!=null) {pst.close();}
			if(myconn!=null) {myconn.close();}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

 



}
