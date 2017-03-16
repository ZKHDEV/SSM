$(function() {
    $.validator.addMethod("username", function(value, element) {
        var uname = /^[a-zA-Z0-9\_\-]{5,30}$/;
        return this.optional(element) || (uname.test(value));
    }, "");
    $.validator.addMethod("userpwd", function(value, element) {
        var upwd = /^[A-Za-z0-9\!\#\$\%\^\&\*\.\~]{5,30}$/;
        return this.optional(element) || (upwd.test(value));
    }, "");
    $.validator.addMethod("mobile", function(value, element) {
        var length = value.length;
        var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "");

    // 添加、修改电影表单验证
    $('#movie-create-form,#movie-edit-form').validate({
        rules: {
            title: {required: true},
            director: {required: true},
            genre: {required: true},
            language: {required: true}
        },
        messages: {
            title: {required: 'Title不能为空。'},
            director: {required: 'Director不能为空。'},
            genre: {required: 'Genre不能为空。'},
            language: {required: 'Language不能为空。'}
        },
        errorPlacement: function (error, element) {
            error.appendTo(element.next());
        }
    });

    $('#login-form').validate({
        rules: {
            email: {required: true},
            password: {required: true}
        },
        messages: {
            email: {required: 'Email不能为空。'},
            password: {required: 'Password不能为空。'}
        },
        errorPlacement: function (error, element) {
            error.appendTo(element.next());
        },
        submitHandler: function(form) {
            $('#password').val($.md5($('#password').val()));
            $(form).ajaxSubmit();
        }
    });
});