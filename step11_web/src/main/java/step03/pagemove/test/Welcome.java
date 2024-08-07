package step03.pagemove.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//http://ip:port/context/html/login.html
//http://ip:port/context/loginTest
//http://ip:port/context/view/welcome

@WebServlet("/view/welcome")
public class Welcome extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome doPost()");
		process(request, response);
	}
	
	//공통 로직으로 분히된 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//step01 - cookie 정보 client 브라우저로부터 획득해서 출력
		//해당 Domain의 쿠키 정보만 획득
//		Cookie[] all = request.getCookies();
//		
//		for(Cookie c:all) {
//			if(c.getName().equals("msg1")) { //쿠키 key값 뽑고 비교
//				out.println(c.getValue() + "<br>"); //해당 쿠키 value값 뽑고 출력
//			}
//		}
		
		//step02 - HttpSession 생성 및 데이터 저장
		HttpSession session = request.getSession(); //client만의 고유한 요청 객체로부터 획득
		System.out.println(session.getId()); //컨테이너가 구분하기 위해 부여한 id
		
		//데이터 저장
		out.println(session.getAttribute("key1"));
		out.println("<hr>");
		
		//로그아웃 클릭시에 쿠키 정보 삭제하고 login.html로 이동되는 servlet으로 이동
		/* login.html -> LoginCheck -> welcome : 쿠키데이터 확인 및 로그아웃
		 * -> Logout : 로그아웃 -> login.html
		 */
		//url 표기로 /로 시작할 경우 http://ip:port를 의미
		out.println("<a href='/step11_web/logout'>");		
		out.println("logout</a>");
		out.close();
		out=null;
	}
	
	

}
