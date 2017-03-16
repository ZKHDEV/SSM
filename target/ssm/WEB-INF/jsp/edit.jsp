<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include  file="./layout/web-header.jsp"%>
<%@ include  file="./layout/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>Edit</h1>
    <h4>Movie</h4>
    <hr>
    <div class="row">
        <form id="movie-edit-form" class="form-horizontal col-md-6" action="${pageContext.request.contextPath}/update.action" method="post">
            <input type="hidden" name="token" value="${sessionScope.token}">
            <input type="hidden" name="id" value="${movie.id}">
            <div class="form-group">
                <label for="Title" class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="title" value="${movie.title}" placeholder="Title">
                    <span class="text-danger">${errors.title}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="Director" class="col-sm-2 control-label">Director</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="director" name="director" value="${movie.director}" placeholder="Director">
                    <span class="text-danger">${errors.director}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="Genre" class="col-sm-2 control-label">Genre</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="genre" name="genre" value="${movie.genre}" placeholder="Genre">
                    <span class="text-danger">${errors.genre}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="Language" class="col-sm-2 control-label">Language</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="language" name="language" value="${movie.language}" placeholder="Language">
                    <span class="text-danger">${errors.language}</span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Edit</button>
                </div>
            </div>
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/list.action">Back to List</a>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./layout/javascript.jsp"%>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/form-validate.js"></script>
<%@ include  file="./layout/web-footer.jsp"%>