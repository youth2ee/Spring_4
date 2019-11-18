<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <c:forEach items="${list}" var="vo">
 <ul class="list-group list-group-flush" style="width: 400px;">
 	<li  class="list-group-item"><a href="./notice/noticeSelect?num=${vo.num}">${vo.title}</a></li>
 	<li  class="list-group-item">${vo.reg_date}</li>
 </ul>
 
 </c:forEach>
 
 