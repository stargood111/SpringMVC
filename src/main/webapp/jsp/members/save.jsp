<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="hello.servlet.domain.member.Member"%>
<%@ page import="hello.servlet.domain.member.MemberRepository"%>
<%	
	//request, response ��� ����
	MemberRepository memberRepository = MemberRepository.getInstance();
	System.out.println("MmeberSaveServlet.service");
	String username = request.getParameter("username");
	int age = Integer.parseInt(request.getParameter("age"));
	
	Member member = new Member(username, age);
	memberRepository.save(member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	����
	<ul>
		<li>id=<%= member.getId() %></li>
        <li>name=<%= member.getUsername() %></li>
        <li>age=<%= member.getAge() %></li>
	</ul>
	<a href ="/index.html">����</a>
</body>
</html>