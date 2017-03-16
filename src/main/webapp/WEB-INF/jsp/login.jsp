<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include  file="./layout/web-header.jsp"%>
<%@ include  file="./layout/header.jsp"%>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>Log in.</h1>
    <h4>Use a local account to log in.</h4>
    <hr>
    <div class="row">
        <form id="login-form" class="form-horizontal col-md-6" action="${pageContext.request.contextPath}/login.action" method="post">
            <input type="hidden" name="token" value="${sessionScope.token}">
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="email" name="email" value="${user.email}" placeholder="Email">
                    <span class="text-danger">${errors.email}</span>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    <span class="text-danger">${errors.password}</span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="remember" value="${user.remember}"> Remember me?
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Log in</button>
                    <span class="text-danger">${errormsg}</span><br>
                </div>
            </div>
        </form>
    </div>
    <a href="${pageContext.request.contextPath}/register.action">Register as a new user?</a><br>
    <a href="${pageContext.request.contextPath}/forgot.action">Forgot your password?</a>
    <hr> &copy;2017 - ZKH
</div>
<%@ include  file="./layout/javascript.jsp"%>
<script src="${pageContext.request.contextPath }/js/jquery.md5.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/form-validate.js"></script>
<%@ include  file="./layout/web-footer.jsp"%>