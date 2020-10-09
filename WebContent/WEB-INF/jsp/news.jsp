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
<fmt:message bundle="${locale}" key="newsBlock.latestNews"
	var="latestNews" />
<fmt:message bundle="${locale}" key="newsBlock.editButton"
	var="editButton" />
<fmt:message bundle="${locale}" key="newsBlock.viewButton"
	var="viewButton" />
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
		<form method="post" action="controller?command=deleteChosen"
			class="news-block">
			<p class="title">
				<c:out value="${latestNews}:" />
			</p>
			<c:forEach items="${allNews}" var="news">
				<p>
					<span class="title"><a
						href="controller?command=show&id=${news.id}">${news.title}</a></span>
					<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${news.datetime}"
						var="time" />
					<i class="time">${time}</i>
				</p>
				<p class="brief">${news.brief}</p>
				<div class="bottom-margin">
					<input class="management-buttons" type="checkbox"
						name="deleteCheckbox" value="${news.id}"> <input
						class="management-buttons" type="button" value="${editButton}"
						onclick='location.href="controller?command=editPage&id=${news.id}"'>
					<input class="management-buttons" type="button"
						value="${viewButton}"
						onclick='location.href="controller?command=show&id=${news.id}"'></br>
					</br>
				</div>

			</c:forEach>
			<div class="management-buttons bottom-margin">
				<button type="submit">
					<c:out value="${deleteButton}" />
				</button>
			</div>
		</form>
	</main>
</body>
</html>