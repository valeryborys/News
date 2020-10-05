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
						<p><span class="title"><c:out value="${certainNews.title}"/></span>
						<i class="time"><c:out value="${certainNews.datetime}"/></i></p> 
						<p class="brief"><c:out value="${certainNews.brief}"/></p>
						<p class="content"><c:out value="${certainNews.content}"/></p>
						<span class="lang"><button>Delete</button></span>
						<span class="lang"><button>Edit</button></span>
						
		</div>
	</main>
<!-- 	<footer>This is footer</footer> -->
</body>
</html>