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
		<form method="post" action="controller?command=addNews"
			class="news-block">
			<p>
				<label>Title: </label><input type="text" name="title"
					placeholder="News Title" value="${certainNews.title}" />
			</p>
			<p align="center" class="warning">${titleWarning}</p>
			<p>
				<label>Brief: </label>
				<textarea name="brief" placeholder="Brief"><c:out
						value="${certainNews.brief}" /></textarea>
			</p>
			<p align="center" class="warning">${briefWarning}</p>
			<p>
				<label>Content: </label>
				<textarea class="content-input" name="content"
					placeholder="News content"><c:out
						value="${certainNews.content}" /></textarea>
			</p>
			<p align="center" class="warning">${contentWarning}</p>
			<div class="bottom-margin" align="center">
				<button type="submit">Add news</button>
				<input type="button" value="Cancel"
					onclick='location.href="controller?command=main"'>
			</div>

		</form>
	</main>
</body>
</html>