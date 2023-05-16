//클래스생성(X)
//Servlet 생성
package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * localhost:8080(테스트서버)/pro06(프로젝트명) ->시작페이지
 * localhost:8080/pro06/접속명
 */
@WebServlet("/calc") //접속명과 일치하게
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //전역변수 선언, 메소드, 클래스-일반 자바프로그램 동일
	//나라별 환율 정의
	private static float USD_RATE = 1124.70F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 163.30F;
	private static float GBP_RATE = 1444.35F;
	private static float EUR_RATE = 1295.77F;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //일반적인 접속은 main()과 동일하게 처리되는 메소드가 doGet
    //전달크기가 8~16kb 제약, 자료는 공개형
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request : 브라우저에서 보내온 변수(값)을 받는 역할
		//response: 자바에서 결과를 브라우저에 보내는 역할
		//System.out.println()-톰캣의 콘솔에 출력(관리자)
		//out.write(), out.print()-브라우저에 출력(요청자에게)
		//웹은 전달시 반드시 문자셋 설정
		request.setCharacterEncoding("utf-8"); //전달받은 값은 utf-8로 변환
		//브라우저에 전달할 내용은 html형식이고, 문자는 utf-8로 구성
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		//1.request로부터 받은 값을 저장
		//localhost:8080/pro06/Calc?command=내용&won=내용&operator=내용
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		//2.작업(유효성검사, 원한느 결과 계산, 데이터베이스)
		//command에 내용이 있으면서 내용이 calculate면 참
		//처리결과를 출력할 부분
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html>");
			pw.print("<font size=10>변환결과 : </font>");
			pw.print("<font size=10>"+result+"</font><br>");
			pw.print("<a href='/pro06/calc'>환율계산기</a>");
			pw.print("</html>");
			return;
		}
		
		//입력부분
		pw.print("<html>");
		pw.print("<title>환율계산기</title>");
		pw.print("<font size=5>환율계산기</font><br>");
		pw.print("<form method='get' action='/pro06/calc'>"); //입력폼 form
		pw.print("원화 : <input type='text' name='won' size=10>");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안화</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'>");
		pw.print("<input type='submit' value='변환'>");
		pw.print("</form>");
		pw.print("</html>");
		pw.close(); //전송끝
	}
	//화폐별 환율계산기
	private String calculate(float won, String operator) {
		String result = null; //변수 선언
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won/USD_RATE);
		} else if(operator.equals("en")) {
			result = String.format("%.6f", won/JPY_RATE);
		} else if(operator.equals("wian")) {
			result = String.format("%.6f", won/CNY_RATE);
		} else if(operator.equals("pound")) {
			result = String.format("%.6f", won/GBP_RATE);
		} else if(operator.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		return result;

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//대용량 처리, 자료는 비공개형, Form접속시 사용
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
