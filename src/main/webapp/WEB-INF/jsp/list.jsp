<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("title","电影"); %>
<%@ include  file="./modules/web-header.jsp"%>
<%@ include  file="./modules/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>List</h1>
    <a href="${pageContext.request.contextPath}/movie/create">Creat New</a>
    <table class="table table-hover">
        <thead>
            <th>Id</th>
            <th>Title</th>
            <th>Director</th>
            <th>Genre</th>
            <th>Language</th>
            <th></th>
        </thead>
        <tbody>
        <c:forEach items="${model.data}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.director}</td>
                <td>${movie.genre}</td>
                <td>${movie.language}</td>
                <th><a href="${pageContext.request.contextPath}/movie/details/${movie.id}">Details</a> | <a href="${pageContext.request.contextPath}/movie/update/${movie.id}">Edit</a> | <a href="${pageContext.request.contextPath}/movie/delete/${movie.id}">Delete</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@ include  file="./modules/page-toolkit.jsp"%>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./modules/javascript.jsp"%>
<%@ include  file="./modules/web-footer.jsp"%>