package com.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class MemberDao {
	// log4j 모듈 활용하여 로그 출력 - 날짜, 시간, 클래스명, 라인 번호, 링크
	// System.out.print() 대신하여 사용
	Logger logger = Logger.getLogger(MemberDao.class);
	// Dao 클래스와 오라클 서버 사이에 MyBatis Layer에 필요한 설정 내용 담기
	// member.xml의 물리적인 위치와 오라클 서버의 정보가 담긴 MyBatisConfig.xml의 정보를 IO로 읽어오는 코드 포함
	// MyBatis는 쿼리문을 xml 문서에 따로 관리
	// ; 자바로 관리하는 것보다 컴파일을 하지 않아도 되고 버전 관리에도 효과적인 장점
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();

	public Map<String, Object> login(Map<String, Object> pMap) {
		Map<String, Object> rmap = null;
		// MyBatisConfig.xml 문서를 통해 스캔한 오라클 서버 정보로 연결 통로 확보
		SqlSessionFactory sqlSessionFactory = null;
		// SqlSessionFactory 생성되면 쿼리문을 요청하는 selectOne 메서드 필요
		// 그 메서드를 제공하는 클래스 및 commit, rollback 지원
		SqlSession sqlSession = null;
		try {
			// 공통 코드에서 연결 통로 확보
			sqlSessionFactory = mcf.getSqlSessionFactory();
			// 연결 통로 확보로 생성된 객체로 sqlSession 로딩
			sqlSession = sqlSessionFactory.openSession();
			//pMap = new HashMap<>(); // test를 위함
			//pMap.put("mem_id", "karina");
			//pMap.put("mem_pw", "123");
			rmap = sqlSession.selectOne("login", pMap); // selectOne = 클래스
			logger.info(rmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rmap;
	}
	public static void main(String args[]) {
		MemberDao mDao = new MemberDao();
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("mem_id", "karina");
		pMap.put("mem_pw", "123");
		Map<String, Object> rMap = mDao.login(pMap);
		System.out.println(rMap);
	}
}
