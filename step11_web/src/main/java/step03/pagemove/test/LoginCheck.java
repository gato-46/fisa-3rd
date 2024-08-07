package step03.pagemove.test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//http://ip:port/context/html/login.html
//http://ip:port/context/loginTest
//http://localhost:8080/step11_web/loginTest

@WebServlet("/loginTest")
public class LoginCheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginCheck doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginChech doPost()");
		process(request, response);
	}

	// 공통 로직으로 분히된 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step01 - 쿠기 생성
		// Cookie 기술로 데이터 두가지 저장
		// 실행 후 브라우저 쿠키 메모리 확인
		Cookie msg1 = new Cookie("msg1", "hi");
		Cookie msg2 = new Cookie("msg2", "fisa");

		msg1.setMaxAge(60 * 60 * 24); // 초 단위 설정
		msg2.setMaxAge(60 * 60 * 24 * 365); // 초 단위 설정

		response.addCookie(msg1);
		response.addCookie(msg2);

		// step02 - HttpSession 생성 및 데이터 저장
		/*
		 * 생성은 코드로 개발자가, 데이터 저장도 개발자가 단 생성된 객체 관리는 컨테이너 내부 로직
		 * 
		 * request.getSession() : 없을 경우 생성, 이미 존재할 경우 제공
		 */
		HttpSession session = request.getSession(); // client만의 고유한 요청 객체로부터 획득
		System.out.println(session.getId()); // 컨테이너가 구분ㄹ하기 위해 부여한 id
		// 데이터 저장
		session.setAttribute("key1", "문자 데이터");
		session.setAttribute("key2", 10); // new Interger(10)으로 변환
		
		//html, jsp는 url에 확장자 표현 필수
		//servlet은 확장자 없이 url mapping 값으 
		// redirect 로 이동
		response.sendRedirect("jsp/welcome.jsp");

		// forward로 이동
		// request.getRequestDispatcher("view/welcome").forward(request, response);
	}

}
