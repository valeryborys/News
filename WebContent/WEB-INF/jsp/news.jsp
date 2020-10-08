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

</head>
<body>
	<header class="header-block">
		<div class="logo">News management</div>
		<ol>
			<li class="lang"><a href="">English</a></li>
			<li class="lang"><a href="">Русский</a></li>
		</ol>
	</header>
	<main>
		<aside class="management-block">
			<p align="center">News:</p>
			<ul>
				<li><a href="controller?command=main">News List</a></li>
				<li><a href="controller?command=addPage">Add News</a></li>
			</ul>
		</aside>
		<form method="post" action="controller?command=deleteChosen"
			class="news-block">
			<p class="title">Latest news:</p>
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
					<input class="lang" type="checkbox" name="deleteCheckbox"
						value="${news.id}"> <input class="lang" type="button"
						value="Edit"
						onclick='location.href="controller?command=editPage&id=${news.id}"'>
					<input class="lang" type="button" value="View"
						onclick='location.href="controller?command=show&id=${news.id}"'></br>
				</div>

			</c:forEach>
			<div class="lang bottom-margin">
				<button type="submit">Delete</button>
			</div>
		</form>
	</main>
</body>
</html>