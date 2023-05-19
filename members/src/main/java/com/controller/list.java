package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vo.member; //패키지명.클래스명(파일명)
//해당 페이지와 결과 페이지가 연결되도록 doGet, doPost에 연

@WebServlet("/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * 브라우저 /list로 요청했을 때 처리하는 부분
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용준비
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//작업(데이터베이스에 연결해서 members 테이블에 레코드를 조회)
		//결과값들을 vo에 저장
		//1.데이터베이스 준비
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; //삽입, 수정, 삭제에서는 제외
		String sql = null;
		
		//2. 데이터베이스 연결
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet",
					"sample",
					"1234"
					); //주소:포트/데이터베이스명, 아이디, 비밀번호
			
			//3. 데이터베이스 조작(회원 테이블의 자료를 읽어온다.)
			sql = "SELECT mno, mname, mail FROM members";
			stmt = conn.createStatement(); //질의어 생성
			rs = stmt.executeQuery(sql); //조회는 executeQuery, 삽입/수정/삭제 executeUpdate
			
			//4. 데이터베이스 조작 후 처리 결과
			//vo변수들을 배열화 시켜서 처리결과를 저장
			ArrayList<member> members = new ArrayList<member>();
			while(rs.next()) { //읽어온 레코드를 순차적으로 작업
				//결과물을 vo에 저장
				member temp = new member();
				temp.setMno(rs.getInt("mno"));
				temp.setMname(rs.getString("mname"));
				temp.setMail(rs.getString("mail"));
				members.add(temp);
			}
			//6. 페이지 이동 전에 전달할 변수를 저장
			//이름은 선언된 arraylist 이름으로 값은 arraylist의 이름으로
			request.setAttribute("members", members);
			System.out.println("데이터베이스 처리 성공");
			//7. view에 데이터 출력되게 수정
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {rs.close();} catch(Exception e){};
			try {stmt.close();} catch(Exception e){};
			try {conn.close();} catch(Exception e){};
		}
		
		
		
		
		//페이지 이동
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);//rd.include()
	}

	/**
	 * 목록은 post작업이 없다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
