package com.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

// 서블릿은 java인데 브라우저에 출력 가능 ; 화면 그리는데 서블릿 사용 (mime 타입이 가능하게 해 줌)
@WebServlet("/json.do") // 웹에서 접근 가능한 맵핑 주소 설정
public class MimeJSONServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		res.setContentType("application/json;charset=UTF-8");
		// 메서드를 통해서 객체 생성하는 코드
		PrintWriter out = res.getWriter();
		List<Map<String, Object>> mList = new ArrayList<>();
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", "karina");
		rmap.put("mem_pw", "111");
		rmap.put("mem_name", "유지민");
		mList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("mem_id", "winter");
		rmap.put("mem_pw", "222");
		rmap.put("mem_name", "김민정");
		mList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("mem_id", "taeyeon");
		rmap.put("mem_pw", "333");
		rmap.put("mem_name", "김태연");
		mList.add(rmap);
		// key와 value가 대입 연산자로 표기 JSON은 ; 사용 
		// Gson 값과 맞지 않기 때문에 코드 추가 필요
        Gson g = new Gson();
        String temp = g.toJson(mList);
        out.print(temp);

	}
}
