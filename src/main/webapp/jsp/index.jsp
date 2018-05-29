<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="XXXX系统">
    <meta name="author" content="luhao">
    <title>值守管理系统</title>
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/sb-admin-2.css"/>
    <!-- Custom Fonts -->
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <!--zzm-->
    <link rel="stylesheet" href="css/zzmcss.css">
    <!--luhao-->
    <link rel="stylesheet" href="css/lu.css"/>

<body>
    <div id="wrapper">
        <!-- 头部导航栏 -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" id="header">
            <div class="navbar-header" id="group2-title">
                <a class="navbar-brand" href="index.jsp">值守管理系统</a>
            </div>
          
		      
            <ul class="nav navbar-top-links navbar-right" id="hover-color">
                <!--个人信息按钮-->
                <li class="dropdown">
                    <a class="dropdown-toggle tip" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw write-title"></i>  <i class="fa fa-caret-down write-title"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="javascript:ck()">  <i class="fa fa-user fa-fw"></i> 交接班</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                       
                        </li>
                        <li class="divider"></li>
                        <li><a href="javascript:login_out()"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                </li>
                <!-- /.个人信息按钮结束 -->
            </ul>
            <!-- /.头部结束 -->
                <div class="navbar-header navbar-right" id="group2-title">
               <span class="navbar-brand" style="color:white">欢迎： ${session_user.userRname}</span>
               </div>
            <!--左边导航栏-->
            <div class="navbar-default sidebar" role="navigation" id="left_nav">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <!--搜索框-->
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="搜索...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>
                        <!-- /搜索框结束 -->
                        <!--资料管理-->
                        <li>
                            <a href="javascript:void(0)" id="addreport"><i class="fa fa-dashboard fa-fw"></i>添加事件</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" id="role"><i class="fa fa-wrench fa-fw"></i>待处理事件</a>
                        </li>                       
                        <li>
                            <a href="javascript:void(0)" id="myreport"><i class="fa fa-bar-chart-o fa-fw"></i> 我的事件</a>
                        </li>
                        <li>
                            <a href="javascript:void(0)" id="rota"><i class="fa fa-sitemap fa-fw"></i> 值班日志</a>
                        </li>  
                      
                        <li>
                            <a href="javascript:void(0)" id="role_manager"><i class="fa fa-dashboard fa-fw"></i> 交班日志</a>
                        </li>                       
                        <li>
                            <a href="javascript:void(0)"><i class="fa fa-wrench fa-fw"></i> 人员管理</a>
                        </li>
                       
                    </ul>
                </div>
            </div>
            <!--左边导航栏结束-->
        </nav>
        <div class="modal fade small_font" id="myMo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">交班</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="add_role_name" class="col-sm-3 col-xs-3 control-label">用户名</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="usern" placeholder="请输入" name="userName">
                                                </div>
                                            </div>
                                            <div class="form-group div2">
                                                <label for="add_role_desc" class="col-sm-3 col-xs-3 control-label">密码</label>
                                                <div class="col-sm-9">
                                                    <input type="password" class="form-control" id="pwd" placeholder="请输入" name="password">
                                                </div>
                                            </div>
                                         
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="add_dlog_submit">确认</button>
                            </div>
                        </div>
                    </div>
                </div>
        <!--导航栏结束-->
        <!--内容部分-->
        <div id="page-wrapper" class="bgchange1">
        </div>
                 <!-- 提醒弹出框  -->
	    <div class="modal fade" id="myModal_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" style="width:200px;">
		    <div class="modal-content">
		      <div class="modal-body">
		        <p></p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div>
        <!--内容部分结束-->
        <!--尾部-->
        <div class="footer">
            <div class="footer_content">
                <p>
                    &nbsp;&copy;2018-2018 AUTHOR：<a href="#">J153二组</a>
                </p>
                <p>
                    组长：<a href="#">路昊</a><span>|</span>
                    资料管理：<a href="#">柯强林</a><span>|</span>
                    灾情防治：<a href="#">路昊</a><span>|</span>
                    专家会商：<a href="#">赵子墨</a><span>|</span>
                    药剂器械出库管理：<a href="#">伍辰汉</a><span>|</span>
                    系统信息：<a href="#">陈韵蕊</a><span>|</span>
                </p>
                <p>
                    蜀ICP备8888-6666号-1<span>|</span>
                    增值电信业务经营许可证蜀C-20180302<span>|</span>
                    蜀公网安备 86861234567号
                </p>
            </div>
        </div>
        <!--尾部结束-->
    </div>
<!-- jQuery -->
<script src="js/jQuery-2.2.2-min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/sb-admin-2.js"></script>

<script src="js/checkInfo.js"></script>

<script src="js/group2-commoms.js"></script>

<script>
		
		$("#add_dlog_submit").click(function() {
			var userName=$("#usern").val();
			var password = $("#pwd").val();
			$.ajax({
				data:{"userName":userName,"password":password},
				url:"/ZSGLXT/shiftController/addShift.do",
				success:function(msg){
					console.info(msg);
					checkSuccess(msg,$("#myModal_alert"),"交班",$("#myMo"));
					location.reload();
					
				}
			});
			
		})



	//提示权限不足的tooltips
	$(function () { $("[data-toggfffggle='tooltip']").tooltip(); });
    var content = $("#page-wrapper");
    content.load("/ZSGLXT/jsp/addReport.jsp");
    
    
    
    //值班日志
    $("#rota").click(function(){
        content.load("/ZSGLXT/jsp/rota.jsp");
    });
    //待处理事件
    $("#role").click(function(){
        content.load("/ZSGLXT/jsp/report.jsp");
    });
    
    //我的事件
    $("#myreport").click(function(){
        content.load("/ZSGLXT/jsp/myReport.jsp");
    });
    
    //添加界面
    $("#role_manager").click(function(){
        content.load("/ZSGLXT/jsp/shift.jsp");
    });
    
    //角色管理
    $("#addreport").click(function(){
        content.load("/ZSGLXT/jsp/addReport.jsp");
    });
    //退出
    function login_out(){
    	window.location.href="/ZSGLXT/XXXXX";
    }
    //切换背景
    function bgchange(){
    	$("#page-wrapper").removeClass("bgchange1");
    	$("#page-wrapper").addClass("bgchange2");
    	
    }
    function ck() {
    	
		$("#myMo").modal();
	}
</script>
</body>

</html>
