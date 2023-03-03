package com.pojo.step1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//SELECT deptno, dname, loc, FROM dept
public class DeptController implements Action {
	Logger logger = Logger.getLogger(DeptController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ActionForward af = new ActionForward();
		// FrontMVC1클래스에서 requset 객체에 저장된 배열 꺼냄
		String upmu[] = (String[])req.getAttribute("upmu");
		DeptLogic deptLogic = new DeptLogic();
		String path = null;
		boolean isRedirect = false;
		// 부서 목록 조회 ??
		if ("getDeptList".equals(upmu[1])) {
			List<Map<String, Object>> deptList = deptLogic.getDeptList();
			req.setAttribute("deptList", deptList);
			// 응답 페이지 이름 결정
			path = "getDeptList.jsp";
			// redirect로 할지 forward로 할지 결정
			isRedirect = false; // false 이면 forward ; 요청 유지, 주소창은 그대로지만 페이지는 변경됨
			// 인스턴스화 ?? -> execute() 호출하기 위해
		}
		else if ("jsonDeptList".equals(upmu[1])) { // jsonDeptList 호출
			String jsonDoc = deptLogic.jsonDeptList();
			req.setAttribute("jsonDoc", jsonDoc);
			path = "jsonDeptList.jsp";
			isRedirect = false;
		}
		// 부서 등록 ???
		else if ("deptInsert".equals(upmu[1])) {
			// insert into dept(deptno, dname, loc) valuse(?, ?, ?)
			int result = deptLogic.deptInsert();
		}
		// 부서 정보 수정 ??
		else if ("deptUpdate".equals(upmu[1])) {
			int result = deptLogic.deptUpdate();
			
		}
		// 부서 삭제 ??
		else if ("deptDelete".equals(upmu[1])) {
			int result = deptLogic.deptDelete();
			
		}
		af.setPath(path);
		af.setRedirect(isRedirect); 
		return af;
	}
	public ActionForward getDeptList() {
		//res가 없으면 res.sendRedirect()가 없음 ; 응답 받지 못함
	    //web.xml에 *st1이 있음 - 확장자가 있어야함 - 경유
		return null;
	}
}
