<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>

<div style="text-align: center; margin-top: 50px;">
	<c:forEach items="${quotes}" var="quote">
		<blockquote>
			<p>
				${quote.text}
			</p>
			<footer>
				${quote.author}
			</footer>
		</blockquote>
	</c:forEach>
</div>