<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%!
	int x = 1; // 전변 선언
	public String newsItem(String[] news) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < news.length; i++) {
			if (i == (x-1)) {
		sb.append("<table width = '500px' border ='1px'>");
		sb.append("<tr><td>" + news[i] + "</td></tr>");
		sb.append("</table>");
			} // end if
		} // end newsItem
		String choice = sb.toString();
		return choice;
	}
	%>
<%
// 스크립틀릿
String news[] = { "'도이치모터스 주가조작' 권오수 집유·벌금 3억원"
		, "[튀르키예 강진] 끝모를 사망자수…야외 주차장이 시신 안치소로"
		,"K팝 시장 '메가톤급 폭풍'…하이브·SM 시너지 기대 속 우려"
		, "정부, 사이버분야 첫 대북 독자제재…개인 4명·기관 7곳 지정"
		,"尹대통령 지지율 32%…두 달 만에 30%대 초반으로 하락[한국갤럽]"};
String data = "";
switch(x) {
case 1 :
	data = newsItem(news);
	x++;
	break;
case 2 :
	data = newsItem(news);
	x++;
	break;
case 3 :
	data = newsItem(news);
	x++;
	break;
case 4 :
	data = newsItem(news);
	x++;
	break;
case 5 :
	data = newsItem(news);
	x = 1;
	break;
} // end switch
out.clear(); // 기존에 읽어온 기사 정보 지움
out.print(data);
%>