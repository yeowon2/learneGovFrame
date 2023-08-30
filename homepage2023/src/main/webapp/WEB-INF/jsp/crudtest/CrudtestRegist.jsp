<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>등록하기 TEST</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>
table{border-collapse : collapse;}
th{font-weight:bold;}
th, td{padding:5px;border:1px solid #000;}
</style>
</head>
<body>

<c:choose>
	<c:when test="${not empty result.testId}">
		<c:set var="actionUrl" value="/crudtest/update.do"/>
	</c:when>
	<c:otherwise>
		<c:set var="actionUrl" value="/crudtest/insert.do"/>
	</c:otherwise>
</c:choose>

<h2>게시글 등록하기</h2>
<form action="${actionUrl}" method="post" name="crudtestVO">
	<input type="hidden" name="testId" value="${result.testId}"/>
	<label for="sj">제목</label>
	<input type="text" name="sj" value="${result.sj}" placeholder="제목을 입력하세요."/>
	<br/>
	<label for="userNm">작성자</label>
	<input type="text" name="userNm" value="${result.userNm}" placeholder="작성자를 입력하세요."/>
	<br/>
	<label for="cn">내용</label>
	<textarea id="cn" name="cn" placeholder="내용을 입력하세요." rows="10" cols="100"><c:out value="${result.cn}"/></textarea>
	<br/>
	<c:choose>
		<c:when test="${not empty result.testId}">
			<button type="submit">수정</button>
		</c:when>
		<c:otherwise>
			<button type="submit">등록</button>
		</c:otherwise>	
	</c:choose>
	<a href="/crudtest/selectList.do">목록</a>
</form>
</body>
</html>