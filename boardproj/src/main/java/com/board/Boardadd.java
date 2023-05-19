package com.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Boardadd
 */
@WebServlet("/add")
public class Boardadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boardadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>게시판 작성</title></head>");
		out.println("<body>");
		out.print("<form method='post' action='add'>");
		out.print("<body>");
		out.print("<table border=1>");
		out.print("<h3>게시물 작성</h3>");
		out.print("<tr>");
		out.print("<td width=100>제목</td>");
		out.print("<td width=200><input type='text' name='tsubject'></td>");		
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td width=100>내용</td>");
		out.print("<td width=200><textarea name='tcontent' cols='50' rows='5'></textarea></td>");		
		out.print("</tr>");
		out.print("<tr><td colspan='2'>");
		out.print("<input type='submit' value='등록'>");
		out.print("<input type='reset' value='지우기'>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement stmt = null;
		//ResultSet rs = null;
		String sql = null;
		
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/servlet",
					"sample", "1234"
					);
			//stmt = conn.createStatement();
			sql = "INSERT INTO board(tsubject, tcontent) VALUES(?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("tsubject"));
			stmt.setString(2, request.getParameter("tcontent"));
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 연결 오류");
		} finally {
			//try {rs.close();}catch(Exception e) {};
			try {stmt.close();}catch(Exception e) {};
			try {conn.close();}catch(Exception e) {};
			
			
			
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>게시판 목록</title></head>");
		out.println("<body>");
		out.println("<h3>게시글을 등록하였습니다</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
