package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.BoardVO;
import com.example.util.JDBCUtil;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into BOARD (title, writer, content, contact, email, age, nation, relationship, birthdate) values (?,?,?,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? ,contact=?, email=?,nation=?,relationship=?,birthdate=?,where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.setString(4,vo.getContact());
			stmt.setString(5,vo.getEmail());
			stmt.setString(6,vo.getAge());
			stmt.setString(7,vo.getNation());
			stmt.setString(8,vo.getRelationship());
			stmt.setString(9,vo.getBirthdate());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.setString(4,vo.getContact());
			stmt.setString(5,vo.getEmail());
			stmt.setString(6,vo.getAge());
			stmt.setString(7,vo.getNation());
			stmt.setString(8,vo.getRelationship());
			stmt.setString(9,vo.getBirthdate());
			stmt.setInt(10, vo.getSeq());


			System.out.println(vo.getTitle() + "-" + vo.getWriter() + "-" + vo.getContent() + "-" + vo.getContact() +"-" + vo.getEmail() + "-" + vo.getAge() + "-" + vo.getNation() + "-" + vo.getRelationship() + "-" + vo.getBirthdate() + "-"  + vo.getSeq());
			stmt.executeUpdate();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setContact(rs.getString("contact"));
				one.setEmail(rs.getString("email"));
				one.setAge(rs.getString("age"));
				one.setNation(rs.getString("nation"));
				one.setRelationship(rs.getString("relationship"));
				one.setBirthdate(rs.getString("birthdate"));
				one.setCnt(rs.getInt("cnt"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}

	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("seq"));
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setContact(rs.getString("contact"));
				one.setEmail(rs.getString("email"));
				one.setAge(rs.getString("age"));
				one.setNation(rs.getString("nation"));
				one.setRelationship(rs.getString("relationship"));
				one.setBirthdate(rs.getString("birthdate"));
				one.setRegdate(rs.getDate("regdate"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}