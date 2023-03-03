package com.pojo.step3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HandlerMapping {
	static Logger logger = Logger.getLogger(HandlerMapping.class);
	/********************************************************************************
	 * @param upmu[](upmu[0]:업무명, 폴더명 upmu[1]:메소드명, 기능명, 페이지 이름)
	 * @param request 1-1, 1-2와 다르게 인터페이스를 implements 하지 않음
	 * @param response
	 * 질문 ? 어디서 받아와 ?
	 * @return Object
	 *********************************************************************************/
	public static Object getController(String[] upmu, HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info(upmu[0] + ", " + upmu[1]);
		Controller3 controller = null;
		String path = null;
		ModelAndView mav = null;
		return null;
	}
	
}
