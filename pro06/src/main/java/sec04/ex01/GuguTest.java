package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuguTest
 */
@WebServlet("/guguTest")
public class GuguTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.문자셋
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//2.데이터값을 저장
		//문자열->숫자 변환 Integer.parseInt(문자열)
		String dan = request.getParameter("dan");
		int idan = Integer.parseInt(dan); //문자열을 정수로 변환
		//|---------------------|
		//|		  6단		  |
		//|---------------------|
		//|6*1	   |	  6   |
		//표를 선두께 1로 생성, 내용은 가운데 정렬->줄->칸
		out.print("<table border=1 align=center>");
		out.print("<tr>"); //1줄
		out.print("<td colspan=2>"+dan+"단 출력</td>");
		out.print("</tr>");
		for(int i=1; i<10; i++) {
			out.print("<tr>"); //2줄
			out.print("<td width=400>"+dan+"x"+i+"</td>");
			out.print("<td width=400>"+idan*i+"</td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
		
	}

	
}
