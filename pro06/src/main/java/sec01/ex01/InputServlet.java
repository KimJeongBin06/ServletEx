package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Form에서 action이름을 선언 후 바로 생성
 * WebServlet에 action이름으로 변경
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 웹과 자바의 연결확인 후 
	 * method에 해당하는 메소드에서 작업을 진행
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request 자료를 받기
		request.setCharacterEncoding("UTF-8");
		//2) request로 전달받은 변수의 값을 모두 저장(서로 동일한 변수명)
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		//동일한 변수명으로 값이 여러개 있을 때
		String[] subject = request.getParameterValues("subject");
		
		
		//2. 원하는 작업을 진행
		System.out.println("아이디 :" + user_id); //전달받은 id 출력
		System.out.println("비밀번호 : " + user_pw);
		
		for(String str:subject) {
			System.out.println("선택한 과목 : " + str);
		}
		//3. response로 자료를 전달(다른 메소드로 연결)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
