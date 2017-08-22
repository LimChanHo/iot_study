<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<title>Insert title here</title>
</head>
<style>
#dropzone {
    background: #ccccc;
    width: 150px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    font-weight: bold;
}
#dropzone.in {
    width: 600px;
    height: 200px;
    line-height: 200px;
    font-size: larger;
}
#dropzone.hover {
    background: lawngreen;
}
#dropzone.fade {
    -webkit-transition: all 0.3s ease-out;
    -moz-transition: all 0.3s ease-out;
    -ms-transition: all 0.3s ease-out;
    -o-transition: all 0.3s ease-out;
    transition: all 0.3s ease-out;
    opacity: 1;
}
</style>
<body>
 
    <h1 style="text-align:center">Servlet jQuery File Upload<br></h1> 
 
    <!-- user twitter -->
    <div id="user_twitter">
    <span>Your Twitter</span>
        <div class="input-prepend">
            <span class="add-on">@</span>
            <input class="span2" id="twitter" name="twitter" type="text" placeholder="Username">
        </div>
    </div>
<div style="width:700px;padding:20px;S">
 
    <input id="fileupload" type="file" name="files[]" data-url="upload" multiple>
 
    <div id="dropzone" class="fade well">Drop files here</div>
 
    <div id="progress" class="progress">
        <div class="bar" style="width: 0%;"></div>
    </div>
    <h5 style="text-align:center"><i style="color:#ccc"><small>Max File Size: 2 Mb - Display last 20 files</small></i></h5>
 
    <table id="uploaded-files" class="table">
        <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
            <th>Uploaded By</th>
        </tr>
    </table>
</div>
</body> 
<script>
$(function () {
	 
    $('#fileupload').fileupload({
 
        dataType: 'json',
 
        done: function (e, data) {
            $("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
 
                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').text(file.fileName))
                        .append($('<td/>').text(file.fileSize))
                        .append($('<td/>').text(file.fileType))
                        .append($('<td/>').html("<a href='upload?f="+index+"'>Click</a>"))
                        .append($('<td/>').text("@"+file.twitter))
 
                        )//end $("#uploaded-files").append()
            }); 
        },
 
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        },
 
        dropZone: $('#dropzone')
    }).bind('fileuploadsubmit', function (e, data) {
        // The example input, doesn't have to be part of the upload form:
        var twitter = $('#twitter');
        data.formData = {twitter: twitter.val()};        
    });
 
});
</script>
</html>