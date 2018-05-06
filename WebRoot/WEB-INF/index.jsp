<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图片上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="resources/css/syntax.css" rel="stylesheet" type="text/css">
    <link href="resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="resources/css/webuploader.css" rel="stylesheet" type="text/css">
    <link href="resources/css/demo.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        // 添加全局站点信息
        var BASE_URL = '/webuploader';
    </script>

    <script src="resources/js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="resources/js/global.js" type="text/javascript"></script>
    <script src="resources/js/webuploader.js" type="text/javascript"></script>
    <script src="resources/js/demo.js" type="text/javascript"></script>
    <meta name="GENERATOR" content="MSHTML 11.00.9600.17239">
  </head>
  <body>
 <div id="wrapper">
        <!-- /.navbar -->
        <div class="page-body">
            <div class="container" id="post-container">
                <div class="page-container">
<!--                     <h1 id="demo">百度多文件上传组件webUploader Demo</h1> -->
<!--                     <p>您可以尝试文件拖拽，使用QQ截屏工具，然后激活窗口后粘贴，或者点击添加图片按钮，来体验此demo.</p> -->
                    <div class="wu-example" id="uploader">
                        <div class="queueList">
                            <div class="placeholder" id="dndArea">
                                <div id="filePicker"></div>
                                <p>或将照片拖到这里，单次最多可选300张</p>
                            </div>
                        </div>
                        <div class="statusBar" style="display: none;">
                            <div class="progress">
                                <span class="text">0%</span><span class="percentage"></span>
                            </div>
                            <div class="info"></div>
                            <div class="btns">
                                <div id="filePicker2"></div>
                                <div class="uploadBtn">开始上传</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </body>
</html>
