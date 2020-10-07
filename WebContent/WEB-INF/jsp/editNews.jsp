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
				<li><a href="controller?command=addPage">Add News</a></li>
			</ul>
		</aside>
		<form method="post" action="controller?command=edit&id=${certainNews.id}" class="news-block">
		<input name="id" value="${certainNews.id}" type="hidden">
			<p>
				<label>Title: </label><textarea name="title" placeholder="News title" ><c:out value="${certainNews.title}"/></textarea>
			</p>
			<p>
				<label>Brief: </label>
				<textarea name="brief" placeholder="Brief"><c:out value="${certainNews.brief}"/></textarea>
			</p>
			<div>
				<label>Content: </label>
				<textarea class="content-input" name="content"
					placeholder="News content" ><c:out value="${certainNews.content}"/></textarea>
			</div>
			<div class="bottom-margin" align="center">
				<button type="submit">Confirm</button>   
				<input  type="button" value="Cancel" onclick='location.href="controller?command=show&id=${certainNews.id}"'>
			</div>

		</form>
	</main>
	<!-- 	<footer>This is footer</footer> -->
</body>
</html>