package com.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// form 전송 시 클라이언트측의 요청을 서블릿이 듣는다
// method = "get" 이면 doGet 호출
// method = "post" 이면 doPost 호출
// 자바가 서블릿이 되기 위한 조건은 반드시 HttpServlet 상속
// 상속 받으면 doGet, doPost 오버라이딩 가능
// 이 함수의 파라미터를 통해서 request 요청 객체와 response 응답 객체 주입 받음
// 주입해 주는 주체는 톰캣 서버
// 웹 서비스를 위해서는 URL 등록 필수적 ; 브라우저가 실행 주체이기 때문
// 프로젝트에 필요한 URL 등록은 annotation과 web.xml 문서를 통해 가능
// annotation은 자동이고 편리하지만 수동처리와 비교해 추가 작업이 불가능한 단점
// xml 문서를 통해 객체 등록하고 주입 받음
// 그 이유는 spring 사용 시 메이븐 레포를 이용한 프로젝트 생성하는 경우에 xml문서로 환경 설정
// 클래스 사이의 객체 주입 관계도 xml문서로 처리 가능
public class HelloServlet extends HttpServlet {
	Logger logger = Logger.getLogger(HelloServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		System.out.println("doGet 호출 성공");
		String mem_id = req.getParameter("mem_id");
		logger.info("사용자가 입력한 ID : " + mem_id + "입니다");
		logger.info("doGet 호출 성공");
	      res.setContentType("text/html;charset=UTF-8");
	      // 인스턴스화에서 메서드를 사용하는 경우의 다른점 ?? A a = new A()
	      PrintWriter out = res.getWriter();
	      String msg = "카리나는 신이에요";
	      // 브라우저에서 요청(GET방식) 시 응답으로 나가는 문자열
	      // 문자열 1. 텍스트 파일 : 숫자의 경우 문자로 변환 후 사용 2. 바이너리 파일 : 데이터를 있는 그대로 읽고 사용
	      // text 메인 타입 html 서브 타입 - 브라우저 번역(:태그는 없고 내용만 출력)
	      out.print("<font size = 28px color= orange>" + msg + "</font>"); // 리소스
	      //BookDao bDao = new BookDao();
	      //logger.info(bDao.testDate());

	} // 단위 테스트가 불가 (Postman 사용하면 가능)
	// post 방식은 브라우저를 통해 테스트 불가
	
	@Override
	   public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws ServletException, IOException {
	      logger.info("doPost 호출 성공");
	      res.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = res.getWriter();
	      out.print("<h3>doPost</h3>호출");

	   }
	}
/*
웹 서비스(:요청하고 응답 받기) 제공을 위한 언어
요청을 어디에서 ??
; 브라우저에 URL로 요청
http(hyper text transfer profocol) ; 텍스트 전송하는 프로토콜
https : http + TLS(암호화)
요청의 방식은 몇 가지 ??
요청을 위해서 준비해야 할 것 ??

GET: 클라이언트가 서버에게 URL에 해당하는 자료의 전송을 요청한다.
HEAD: GET 요청으로 반환될 데이터 중 헤더 부분에 해당하는 데이터만 요청한다.
POST: 클라이언트가 서버에서 처리할 수 있는 자료를 보낸다. 예를 들어, 게시판에 글을 쓸 때 클라이언트의 문서가 서버로 전송되어야 한다. 멱등성을 보장하지 않는다.
PATCH: 클라이언트가 서버에게 지정한 URL의 데이터를 부분적으로 수정할 것을 요청한다.
PUT: 클라이언트가 서버에게 지정한 URL에 지정한 데이터를 저장할 것을 요청한다.
DELETE: 클라이언트가 서버에게 지정한 URL의 정보를 제거할 것을 요청한다.
TRACE: 클라이언트가 서버에게 송신한 요청의 내용을 반환해 줄 것을 요청한다.- log4j.properties문서 mybatis sql문 출력
CONNECT: 클라이언트가 특정 종류의 프록시 서버에게 연결을 요청한다.
OPTIONS: 해당 URL에서 지원하는 요청 메세지의 목록을 요청한다.

Get 방식
; 서버측의 리소스(html, css, js)를 가져오기 위해서 사용
쿼리스트링 전송(소용량)
노출 < ?
서로간의 공유가 편리 ; ex) 쿠팡도메인?=상품아이디
검색 시 주로 사용


Post 방식
; 서버에 데이터를 올리기 위해 설계
전송 데이터 크기에 제한이 없음(대용량)
보안에 유리하지만 공유에는 불리
데이터 메시지의 body에 담아 전송
글쓰기, 로그인, 회원가입 시 주로 사용하는 방식
 */
