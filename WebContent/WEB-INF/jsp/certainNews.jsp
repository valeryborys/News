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
<fmt:message bundle="${locale}" key="lang.english" var="english" />
<fmt:message bundle="${locale}" key="lang.russian" var="russian" />
<fmt:message bundle="${locale}" key="list.newsList" var="newsList" />
<fmt:message bundle="${locale}" key="list.addNews" var="addList" />
<fmt:message bundle="${locale}" key="newsBlock.editButton"
	var="editButton" />
<fmt:message bundle="${locale}" key="newsBlock.deleteButton"
	var="deleteButton" />
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
		<div class="news-block">
			<p>
				<span class="title"><c:out value="${certainNews.title}" /></span>
				<c:set var="loc" value="${sessionScope.locale}" />
				<c:set var="ru_loc" value="ru" />
				<c:set var="en_loc" value="en" />
				<c:if test="${loc==ru_loc}">
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm"
						value="${certainNews.datetime}" var="ru_time" />
					<i class="time">${ru_time}</i>
				</c:if>
				<c:if test="${loc==en_loc}">
					<fmt:formatDate pattern="MM/dd/yy HH:mm"
						value="${certainNews.datetime}" var="en_time" />
					<i class="time">${en_time}</i>
				</c:if>

			</p>
			<p class="brief">
				<c:out value="${certainNews.brief}" />
			</p>
			<div class="content">
				<c:out value="${certainNews.content}" />
			</div>
			<div class="management-buttons bottom-margin">
				<span class="management-buttons"><a
					href="controller?command=delete&id=${certainNews.id}"><button>
							<c:out value="${deleteButton}" />
						</button></a></span> <span class="management-buttons"><a
					href="controller?command=editPage&id=${certainNews.id}"><button>
							<c:out value="${editButton}" />
						</button></a></span>
			</div>

		</div>
	</main>
</body>
</html>