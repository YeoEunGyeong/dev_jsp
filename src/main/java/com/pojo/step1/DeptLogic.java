package com.pojo.step1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class DeptLogic {
	Logger logger = Logger.getLogger(DeptLogic.class);
	public List<Map<String, Object>> getDeptList() {
		logger.info("getDeptList 호출");
		List<Map<String, Object>> deptList = new ArrayList<>();
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("deptno", 10);
		rmap.put("dname", "구부");
		rmap.put("loc", "홍대입구");
		deptList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("deptno", 20);
		rmap.put("dname", "칠부");
		rmap.put("loc", "합정");
		deptList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("deptno", 30);
		rmap.put("dname", "오부");
		rmap.put("loc", "당산");
		deptList.add(rmap);
		Gson g = new Gson();
		String temp = g.toJson(deptList);
		return deptList;
	}
	
	public String jsonDeptList() {
		logger.info("jsonDeptList 호출");
		List<Map<String, Object>> deptList = new ArrayList<>();
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("deptno", 10);
		rmap.put("dname", "구부");
		rmap.put("loc", "홍대입구");
		deptList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("deptno", 20);
		rmap.put("dname", "칠부");
		rmap.put("loc", "합정");
		deptList.add(rmap);
		rmap = new HashMap<>();
		rmap.put("deptno", 30);
		rmap.put("dname", "오부");
		rmap.put("loc", "당산");
		deptList.add(rmap);
		Gson g = new Gson();
		String temp = g.toJson(deptList);
		return temp; // JSON 포맷으로 전달 -> 리액트에서 조회 시 사용
	}

	public int deptInsert() {
		logger.info("deptInsert 호출");
		return 0;
	}

	public int deptUpdate() {
		logger.info("deptUpdate 호출");
		return 0;
	}

	public int deptDelete() {
		logger.info("deptDelete 호출");
		return 0;
	}

}
