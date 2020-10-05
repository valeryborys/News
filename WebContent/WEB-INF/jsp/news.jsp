<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li><a href="">Add News</a></li>
			</ul>
		</aside>
		<div class="news-block">
			<p class="title">List of News:</p>
			<c:forEach items="${allNews}" var="news">
				<p>
					<span class="title"><a
						href="controller?command=show&id=${news.id}">${news.title}</a></span> <i
						class="time">${news.datetime}</i>
				</p>
				<p class="brief">${news.brief}</p>
				<p>	
					<input class="lang"  type="checkbox" name="a">		
					<span class="lang"><button><a href="">Edit</a></button></span>
					<span class="lang"><button><a href="controller?command=show&id=${news.id}">View</a></button></span></br>
				</p>
			
			</c:forEach>
		</div>
	</main>
</body>
</html>