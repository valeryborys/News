<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>News Portal</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="resources.lang" var="locale" />
<fmt:message bundle="${locale}" key="news" var="listHead" />
<fmt:message bundle="${locale}" key="title" var="title" />
<fmt:message bundle="${locale}" key="brief" var="brief" />
<fmt:message bundle="${locale}" key="content" var="content" />
<fmt:message bundle="${locale}" key="lang.english" var="english" />
<fmt:message bundle="${locale}" key="lang.russian" var="russian" />
<fmt:message bundle="${locale}" key="list.newsList" var="newsList" />
<fmt:message bundle="${locale}" key="list.addNews" var="addList" />
<fmt:message bundle="${locale}" key="newsBlock.latestNews"
	var="latestNews" />
<fmt:message bundle="${locale}" key="newsBlock.editButton"
	var="editButton" />
<fmt:message bundle="${locale}" key="newsBlock.viewButton"
	var="viewButton" />
<fmt:message bundle="${locale}" key="newsBlock.deleteButton"
	var="deleteButton" />
<fmt:message bundle="${locale}" key="newsBlock.cancelButton"
	var="cancelButton" />
<fmt:message bundle="${locale}" key="warning.title"
	var="titleWarningMessage" />
<fmt:message bundle="${locale}" key="warning.brief"
	var="briefWarningMessage" />
<fmt:message bundle="${locale}" key="warning.content"
	var="contentWarningMessage" />
</head>
<body>
	<header class="header-block">
		<p class="logo">News management</p>
		<div align="right" class="bottom-margin">
			<form class="lang" action="controller?command=localeChange"
				method="post">
				<input type="hidden" name="locale" value="en"> <input
					type="submit" value="${english}" />
			</form>

			<form class="lang" action="controller?command=localeChange"
				method="post">
				<input type="hidden" name="locale" value="ru"> <input
					type="submit" value="${russian}" />
			</form>
		</div>
	</header>
	<main>
		<aside class="management-block">
			<p align="center">
				<c:out value="${listHead}:" />
			</p>
			<ul>
				<li><a href="controller?command=main"><c:out
							value="${newsList}" /></a></li>
				<li><a href="controller?command=addPage"><c:out
							value="${addList}" /></a></li>
			</ul>
		</aside>
		<form method="post" action="controller?command=addNews"
			class="news-block">
			<p>
				<label><c:out value="${title}:" /> </label><input type="text"
					name="title" placeholder="${title }" value="${certainNews.title}" />
			</p>
			<c:if test="${titleWarning > 0}">
				<p align="center" class="warning">
					<c:out value="${titleWarningMessage}" />
				</p>
			</c:if>
			<p>
				<label><c:out value="${brief}:" /></label>
				<textarea name="brief" placeholder="${brief }"><c:out
						value="${certainNews.brief}" /></textarea>
			</p>
			<c:if test="${briefWarning > 0}">
				<p align="center" class="warning">
					<c:out value="${briefWarningMessage}" />
				</p>
			</c:if>
			<p>
				<label><c:out value="${content}:" /> </label>
				<textarea class="content-input" name="content"
					placeholder="${content}"><c:out
						value="${certainNews.content}" /></textarea>
			</p>
			<c:if test="${contentWarning > 0}">
				<p align="center" class="warning">
					<c:out value="${contentWarningMessage}" />
				</p>
			</c:if>
			<div class="bottom-margin" align="center">
				<button type="submit">
					<c:out value="${addList}" />
				</button>
				<input type="button" value="${cancelButton}"
					onclick='location.href="controller?command=main"'>
			</div>

		</form>
	</main>
</body>
</html>