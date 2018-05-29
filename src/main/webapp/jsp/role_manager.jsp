<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色管理</title>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">角色管理</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">按照角色查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>角色用户列表 </label>
                                <select id="role_select." class="form-control">
									<option value="0">员工</option>
									<option value="1">部门管理员</option>
									<option value="2">值班人员</option>
		                        </select>
                            </div>
                            <button type="button" class="btn btn-default" id="query-btn">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>账号</th>
                        <th>电话</th>
                        <th>家庭住址</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="add_role">添加角色</button>
	                <button type="button" class="btn btn-default" id="update_role_user">修改角色用户</button>
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal2" id="update_role_power">修改角色权限</button>
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
                                <h4 class="modal-title" id="myModalLabel">添加角色</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="add_role_name" class="col-sm-3 col-xs-3 control-label">角色名称</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_role_name" placeholder="请输入" name="not-none-check">
                                                </div>
                                            </div>
                                            <div class="form-group div2">
                                                <label for="add_role_desc" class="col-sm-3 col-xs-3 control-label">角色描述</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_role_desc" placeholder="请输入" name="not-none-check">
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="add_role_powers" class="col-sm-3 col-xs-3 control-label">选择权限</label>
                                                <div class="col-sm-9">
                                                    <select name="disaster_situation" id="add_role_powers" class="form-control">
                                                        <option value="0">请选择</option>
                                                        <option value="1">资源总览</option>
                                                        <option value="2">任务总览</option>
                                                        <option value="3">...</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="add_dlog_submit">确认添加</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 修改角色权限 -->
                <div class="modal fade small_font" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">修改角色权限</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-6">
                                            <div class="form-group div1">
                                                <label for="show_dlog_name" class="col-sm-3 col-xs-3 control-label">事件名称</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="show_dlog_name" placeholder="请输入" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group div2">
                                                <label for="show_dlog_date" class="col-sm-3 col-xs-3 control-label">时间</label>
                                                <div class="col-sm-9">
                                                    <input type="date" class="form-control" id="show_dlog_date" placeholder="请输入" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="show_dlog_stage" class="col-sm-3 col-xs-3 control-label">灾情状况</label>
                                                <div class="col-sm-9">
                                                    <select name="disaster_situation" id="show_dlog_stage" class="form-control" disabled>
                                                        <option value="0">请选择</option>
                                                        <option value="1">已得到控制</option>
                                                        <option value="2">防治中</option>
                                                        <option value="3">无法解决，申请专家会商</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="show_dlog_desc" class="col-sm-3 col-xs-3 control-label">灾情描述</label>
                                                <div class="col-sm-9">
                                                    <textarea name="disaster_des" id="show_dlog_desc" class="form-control" disabled></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group div5">
                                                <label for="show_area_id" class="col-sm-3 col-xs-3 control-label">发生位置</label>
                                                <div class="col-sm-9">
													<input type="text" class="form-control" id="show_area_id" placeholder="请输入" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group div6">
                                                <label for="show_dlog_loss" class="col-sm-3 col-xs-3 control-label">初步损失</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="show_dlog_loss" placeholder="请输入" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group div7">
                                                <label for="show_dlog_plan" class="col-sm-3 col-xs-3 control-label">防治方案</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="show_dlog_plan" placeholder="请输入" disabled>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group div8">
                                                <label for="show_dlog_pic" class="col-sm-3 col-xs-3 control-label">灾区图片</label>
                                                <div class="col-sm-9">
                                                    <img alt="图片" src="" id="show_dlog_pic" width="150" height="150"/>
                                                </div>
                                            </div>
                                            <div class="form-group div9">
                                                <label for="show_dlog_type" class="col-sm-3 col-xs-3 control-label">灾害类型</label>
                                                <div class="col-sm-9">
                                                    <select name="disaster_type" id="show_dlog_type" class="form-control" disabled>
                                                        <option value="0">请选择</option>
                                                        <option value="1">虫害</option>
                                                        <option value="2">鼠害</option>
                                                        <option value="3">病害</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group div10">
                                                <label for="show_dlog_found" class="col-sm-3 col-xs-3 control-label">发现途径</label>
                                                <div class="col-sm-9">
                                                    <select name="find_ways" id="show_dlog_found" class="form-control" disabled>
                                                        <option value="0">请选择</option>
                                                        <option value="1">小班巡查发现</option>
                                                        <option value="2">公众发现</option>
                                                        <option value="3">上级部门通报</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group div11">
                                                <label for="show_class_id" class="col-sm-3 col-xs-3 control-label">所在小班</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="show_class_id" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div12">
                                                <label for="show_dlog_influence" class="col-sm-3 col-xs-3 control-label">影响面积</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="show_dlog_influence" placeholder="请输入" disabled>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
			                        <div class="col-sm-12">
			                            <table class="table table-bordered table-hover table-striped">
			                                <tr>
			                                    <th>日期</th>
			                                    <th>会商人员</th>
			                                    <th>会商结果</th>
			                                </tr>
			                                <tbody id="dlog_clog_tbody">
			                                </tbody>
			                            </table>
										<nav class="text-center">
										 	<ul class="pagination" id="page_nav2"></ul>
										</nav>
			                        </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    //显示所有员工分页信息
	function show_list(pageNo){
		$.ajax({
			date:{"pageNo":1},
			url:"/YJBZXT/roleManager",
			success:function(msg){
				json_to_table(msg,"my_table",["userId","userRname","userGender","userName","userTel","userAddress"]);
				$("#hid").val("0");
			}
		});
	}
    //调用
	show_list(1);
    </script>
</body>
</html>