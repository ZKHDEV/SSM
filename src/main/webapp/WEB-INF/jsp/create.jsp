<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("title","添加电影"); %>
<%@ include  file="./modules/web-header.jsp"%>
<%@ include  file="./modules/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>Create</h1>
    <h4>Movie</h4>
    <hr>
    <div class="row">
        <form id="movie-create-form" class="form-horizontal col-md-6" action="${pageContext.request.contextPath}/movie/create" method="post">
            <div class="form-group">
                <label for="Title" class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="title" value="${model.title}" placeholder="Title">
                    <span class="text-danger">${errors.title}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="Director" class="col-sm-2 control-label">Director</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="director" name="director" value="${model.director}" placeholder="Director">
                    <span class="text-danger">${errors.director}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="Genre" class="col-sm-2 control-label">Genre</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="genre" name="genre" value="${model.genre}" placeholder="Genre">
                    <span class="text-danger">${errors.genre}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="Language" class="col-sm-2 control-label">Language</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="language" name="language" value="${model.language}" placeholder="Language">
                    <span class="text-danger">${errors.language}</span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Create</button>
                </div>
            </div>
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/movie/list">Back to List</a>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./modules/javascript.jsp"%>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/form-validate.js"></script>
<%@ include  file="./modules/web-footer.jsp"%>
