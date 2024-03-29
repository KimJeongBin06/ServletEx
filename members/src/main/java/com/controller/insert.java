package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.vo.member;
/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see 브라우저 /list에서 등록을 클릭했을 때
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용준비
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		//작업
				
		//페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);//rd.include()
	}

	/**
	 * 회원등록 폼에서 회원등록 버튼을 눌렀을 때 요청을 처리하는 부분
	 * 회원정보를 데이터베이스에 저장하고, 목록으로 다시 이동
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용준비
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
				
		//작업(데이터베이스에 연결해서 members 테이블에 레코드를 조회)
		//결과값들을 vo에 저장
		//1.데이터베이스 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null; //삽입, 수정, 삭제에서는 제외
		String sql = null;
		
		//2. 데이터베이스 연결
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet",
					"sample",
					"1234"
					); //주소:포트/데이터베이스명, 아이디, 비밀번호
			//3. 데이터베이스 작업
			sql = "INSERT INTO members(mname, mail, pwd) VALUES (?,?,?)"; //추가
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, (String)request.getParameter("mname"));
			stmt.setString(2, (String)request.getParameter("mail"));
			stmt.setString(3, (String)request.getParameter("pwd"));
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//try {rs.close();} catch(Exception e){};
			try {stmt.close();} catch(Exception e){};
			try {conn.close();} catch(Exception e){};
		}
				
		//페이지 이동
		response.sendRedirect("list");
	}

}
