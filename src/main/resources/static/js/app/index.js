var index = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });
        $('#btn-update').on('click', function () { // GD
            _this.update();
        });
        $('#btn-delete').on('click', function () { // GD
            _this.delete();
        });
    },
    save : function() {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };
        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            datatype : 'json',
            contentType : 'application/json; charset=utf8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    //PostsAp Controller 에 있는 API 에서 이미 @PutMapping 으로 선언했기 때문에
    //PUT을 사용해야합니다 잠고로 이는 REST 규약에 맞게 설정된 것입니다
    update : function() {
            var data = {
                title : $('#title').val(),
                content : $('#content').val()
         };

        var id = $('#id').val();
        $.ajax({
            type : 'PUT',
            url : '/api/v1/posts/'+id,
            datatype : 'json',
            contentType : 'application/json; charset=utf8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });

    },

    delete : function() {
            var id = $('#id').val();
            $.ajax({
                type : 'DELETE',
                url : '/api/v1/posts/'+id,
                datatype : 'json',
                contentType : 'application/json; charset=utf8',
            }).done(function() {
                alert('글이 삭제되었습니다.');
                window.location.href = '/';
            }).fail(function(error) {
                alert(JSON.stringify(error));
            });

        }

};

index.init();