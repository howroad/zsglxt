<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>值班日志</title>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">值班日志</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">条件查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>值班人员：</label>
                                <input type="text" class="form-control" placeholder="请输入" name="uName"/>
                                <label>开始时间：</label>
                                <input type="date" class="form-control" name="startTime"/>
                                <label>结束时间：</label>
                                <input type="date" class="form-control" name="endTime"/>
                            </div>
                            <button type="button" class="btn btn-default" id="query-btn">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table">
                    <thead>
                    <tr>
                        <th>值班人员</th>
                        <th>值班时间</th>
                        <th>是否发生事件</th>
                        <th>描述</th>
                    </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${pageBean.list }" var="rota">
                    		<tr>
                    		<td>${rota.TUser.userName }</td>
                    		<td>${rota.rotaDate }</td>
                    		<td>${rota.rotaEvent }</td>
                    		<td>${rota.rotaDesc }</td>
                    		</tr>
                    	</c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="add_role1">添加值班日志</button>
	            </div>
	        </div>
	        <div class="col-xm-6 col-md-6 col-sm-6 text-right pull-right">
	        	<!-- 分页开始 -->
				<nav class="text-center">
				 	<ul class="pagination" id="page_nav"></ul>
				</nav>
				<!-- 分页结束 -->
	        </div>
	    </div>
        
        <div class="row">
        <!-- 模态框 -->
            <div class="col-xs-6 col-md-6">
            	<!-- 添加角色 -->
                <div class="modal fade small_font" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">添加值班日志</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="add_role_name" class="col-sm-3 col-xs-3 control-label">值班人</label>
                                                <div class="col-sm-9">
                                                 	<span> ${session_user.userRname }</span>
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="add_role_event" class="col-sm-3 col-xs-3 control-label">是否发生事件</label>
                                                <div class="col-sm-9">
                                                    <select name="rotaEvent" id="add_role_powers" class="form-control">
                                                        <option value="未选择">请选择</option>
                                                        <option value="是">是</option>
                                                        <option value="否">否</option>
                                                    </select>
                                                </div>
                                                <br/><br/><br/>
                                            <div class="form-group div4">
                                                <label for="rotaDesc" class="col-sm-3 col-xs-3 control-label">值班描述</label>
                                                <div class="col-sm-9">
                                                    <textarea class="form-control" id="add_role_desc" name="rotaDesc" ></textarea>
                                                </div>
                                            </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="add_dlog_submit2">确认添加</button>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
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
    </div>
    
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    //显示所有员工分页信息
	function show_list(pageNo,userName,startTime,endTime){
		var uName = $("[name='uName']").val();
	    var startTime = $("[name='startTime']").val();
	    var endTime = $("[name='endTime']").val();
		$.ajax({
			data:{"pageNo":pageNo,"uName":uName,"startTime":startTime,"endTime":endTime},
			url:"/ZSGLXT/rotaController/rotaMain.do",
			success:function(msg){
				json_to_table(msg,"my_table",["rotaId","tuser.userRname","rotaDate","rotaEvent","rotaDesc"]);
				$("#hid").val("0");
			}
		});
	}
    //调用
	show_list(1,"","","");
    
    $("#query-btn").click(function() {
	    var uName = $("[name='uName']").val();
	    var startTime = $("[name='startTime']").val();
	    var endTime = $("[name='endTime']").val();
    	show_list(1,uName,startTime,endTime);
	});
    
    $("#add_dlog_submit2").click(function() {
    	var userName = $("[name='userName']").val();
    	var rotaEvent = $("[name='rotaEvent']").val();
    	var rotaDesc = $("[name='rotaDesc']").val();
    	
    	if($("[name='rotaDesc']").val()==""||$("[name='rotaDesc']").val()==null||$("[name='rotaEvent']").val()=="未选择"){
    		alertAiv($("#myModal_alert"),"请完善信息");
    	}else{
	    	$.ajax({
				data:{"userName":userName,"rotaEvent":rotaEvent,"rotaDesc":rotaDesc},
				url:"/ZSGLXT/rotaController/addRota.do",
				success:function(msg){
					checkSuccess(msg,$("#myModal_alert"),"添加",$("#myModal"));
				    show_list(1,"","","");
				}
			});
    	}
	});
    
    
    
    </script>
</body>
</html>