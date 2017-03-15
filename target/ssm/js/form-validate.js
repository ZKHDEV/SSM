$(function() {
    // 添加、修改电影表单验证
    $('#movie-create-form').validate({
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

    $('#movie-edit-form').validate({
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
});