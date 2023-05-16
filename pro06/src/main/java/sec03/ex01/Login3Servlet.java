package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login3Servlet
 */
@WebServlet("/login3") //외부와 연결을 위한 가장 중요한 역할
public class Login3Servlet extends HttpServlet { //클래스명은 중요하지 않다.
	private static final long serialVersionUID = 1L;
       
    public Login3Servlet() { //생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * method="get" 선언되었을 때
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request를 통해서 user_id, user_pw 전달
		request.setCharacterEncoding("utf-8");
		//html에서 전달되는 값은 기본이 모두 문자열

		//login.html?user_id=xxx&user_pw=xxx
		System.out.println("Get 전송");
		doHandle(request, response);
	}

	/**
	 * method="post" 선언되었을 때
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//html에서 전달되는 값은 기본이 모두 문자열
		
		System.out.println("Post 전송");
		doHandle(request, response); //doHandle메소드에 ㅔ받아온 request, 보낼 response 정보 전달

	}
	//doGet과 doPost에서 공통적으로 작업을 할 때
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		//톰캣의 콘솔에 출력
		System.out.println("아이디 : "+user_id); //톰캣의 콘솔에 출력
		System.out.println("비밀번호: "+user_pw);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<title>결과</title>");
		pw.print("아이디 : "+user_id+"<br>");
		pw.print("비밀번호 : "+user_pw);
		pw.print("</html>");
	}
}
