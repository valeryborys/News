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
		<div class="news-block">
			<p>
				<span class="title"><c:out value="${certainNews.title}" /></span>
				<fmt:formatDate pattern="dd-MM-yyyy HH:mm"
					value="${certainNews.datetime}" var="time" />
				<i class="time">${time}</i>
			</p>
			<p class="brief">
				<c:out value="${certainNews.brief}" />
			</p>
			<div class="content" >
				<c:out value="${certainNews.content}" />
			</div>
			<div class="lang bottom-margin">
				<span class="lang"><a
					href="controller?command=delete&id=${certainNews.id}"><button>Delete</button></a></span>
				<span class="lang"><a
					href="controller?command=editPage&id=${certainNews.id}"><button>Edit</button></a></span>
			</div>

		</div>
	</main>
</body>
</html>