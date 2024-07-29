/* 현업 구조 변환
 * 1. db의 접속 설정 정보를 자바소스에서 분리
 * 2. 형식
 * 		url/id/pw 등의 구분을 위한 고유한 별칭
 * 		key와 value 구조
 * 		properties라는 확장자 파일로 주로 관리
 * 
 * 		spring에서도 설정에 대한 모든 내용이 properties 파일로 분리되는 근원
 * 3. 개발
 * 	1단계: properties 파일로 분리
 * 	2단계: 자바 소스에서 해당 파일을 read하는 코드로 파일 인식
 * 	3단계: properties의 key로 선별해서 매핑된 데이터 read 후 사용
 * 
 * 4. io 관련 API
 * 	1. 데이터 제공 근원지 (파일)
 * 		1. 1byte 단위 read api
 * 			- FileInputStream
 * 		2. 2byte 단위 read api
 * 			- FrilReader
 * 
 * 	2. property 파일로 부터 key로 분리해서 read하는 주요 API
 * 		- Map 스펙 하위 클래스
 * 		- java.util.Peoperties 로 key로 데이터 구분하면서 read
 * 
 * 5. 개발 고려사항
 * 	1. 파일이 존재?
 * 		- 파일이 없을 경우 - 비정상 종료 발생 가능성이 있음, 해소 해야 함
 * 					  - 예외처리를 사전에 적용
 * 		- 파일 존재할 경우 - 정상	
 *  2. 파일은 인식 단, 내용물 key value 구조가 적합?
 * 	3. 코드상에서 정확히 key 사용?
 * 	...
 * 
 */

/* 요청사항
 * - 최적화, db.properties 사용 코드로 리펙토링
 *
 */
package step01.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionProperty {

	private static Properties p = new Properties();

	// byte code인 실행 파일이 로딩시 단 한번만 실행
	// db연동 driver는 24시간 365일 구동되는 서버에 단 한번만 실행 권장
	static {
		try {
			// new FileInputStream("db.properties") 파일로 부터 1byte 씩 read 가능
			p.load(new FileInputStream("db.properties"));
			Class.forName(p.getProperty("jdbc.driver"));
		} catch (Exception e) {
			System.out.println("IO문제 발생");
			e.printStackTrace();
		}
	}

	@Test
	public void Connect() {

		String url = p.getProperty("jdbc.url");
		String user = p.getProperty("jdbc.id"); // Oracle 사용자 이름
		String password = p.getProperty("jdbc.pw"); // Oracle 비밀번호

		try {
			// 데이터베이스 연결 - Connection 객체 절대 공유, 오픈 하면 안됨
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스에 성공적으로 연결되었습니다.");

			// 연결 해제
			conn.close();
			System.out.println("연결이 성공적으로 해제되었습니다.");

		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 중 오류가 발생했습니다.");
			e.printStackTrace();
		}

		System.out.println("예외 처리로 인해 정상, 비정상 이어도 실행되는 영역");

	}

}