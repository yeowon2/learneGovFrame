<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="ko">
<title>CRUD TEST 게시판</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<style>
table{border-collapse : collapse;}
th{font-weight:bold;}
th, td{padding:5px;border:1px solid #000;}
</style>
</head>
<body>
접속 계정 : <c:out value="${USER_INFO.id}"/>
<hr>
<div class="total">
	총 게시물
	<strong><c:out value="${paginationInfo.totalRecordCount}"/></strong>건
	현재페이지<strong><c:out value="${paginationInfo.currentPageNo}"/></strong> 
	<c:out value="${paginationInfo.totalPageCount}"/>
	</div>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>수정일</th>
				<th>관리</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}">
				<tr>
					<td><c:out value="${result.testId}"/></td>
					<td>
						<c:url var="viewUrl" value="/crudtest/select.do">
							<c:param name="testId" value="${result.testId}"/>
						</c:url>
						<a href="${viewUrl}"><c:out value="${result.sj}"/></a>
					</td>
					<td><c:out value="${result.userNm}"/></td>
					<td><c:out value="${result.frstRegistPnttm}"/></td>
					<td><c:out value="${result.lastUpdtPnttm}"/></td>
					<td>
						<c:url var="delUrl" value="/crudtest/delete.do">
							<c:param name="testId" value="${result.testId}"/>
						</c:url>
						<a href="${delUrl}" class="btn-del">삭제</a>
					</td>
				</tr>
			</c:forEach>	
		</tbody>		
	</table>
	
	<div id="paging_div">
		<ul class="paging_align">
			<c:url var="pageUrl" value="/crudtest/selectList.do?"/>
			<c:set var="pagingParam"><c:out value="${pageUrl}"/></c:set>
			<ul:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="${pagingParam}"/>
		</ul>
	</div>
	
	<button type="button" id="btn-reg" data-href="/crudtest/crudtestRegist.do">등록하기</button>
	
<script>
$(document).ready(function(){
	$("#btn-reg").click(function(){
		location.href = $(this).data("href");
	});
		
		$("#btn-del").click(function(){
			if(!confirm("삭제하시겠습니까?")){
				return false;
			}
		});
	});	
	

<c:if test="${not empty message}">
	alert("${message}");
</c:if>

</script>

</body>
</html>