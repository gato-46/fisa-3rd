package step01;

import java.io.IOException;

import org.apache.log4j.Logger;

//tomcat9 버전부터 packeage명 java -> jakarta 로 변경
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//web.xml
// http://ip:port/step11_web/fisa
// http://127.0.0.1:8080/step11_web/fisa

public class FristServlet extends HttpServlet {
	//실행되는 현 클래스 로그 기록 적용
	Logger logger = Logger.getLogger(getClass());
	
    public FristServlet() {
    	logger.debug("FristServlet debug() ***");
    	logger.info("FristServlet info() ***");
    	logger.warn("FristServlet warn() ***");
    	logger.error("FristServlet error() ***");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("FristServlet doGet debug() ***");
    	logger.info("FristServlet doGet info() ***");
    	logger.warn("FristServlet doGet warn() ***");
    	logger.error("FristServlet doGet error() ***");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("FristServlet doPost debug() ***");
    	logger.info("FristServlet doPost info() ***");
    	logger.warn("FristServlet doPost warn() ***");
    	logger.error("FristServlet doPost error() ***");
	}

}
