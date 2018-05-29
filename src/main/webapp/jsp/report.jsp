<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>待处理事件</title>
<style type="text/css">
	body{
		 padding-right: 0px !important; 
	}
	span{
		font-size: 12px;
	}
</style>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">待处理事件</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <span class="navbar-brand">条件查询</span>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                         <div class="form-group">
                                <label>事件名称：</label>
                                <input type="text" class="form-control" placeholder="请输入" name="rName"/>
                                <label>开始时间：</label>
                                <input type="date" class="form-control" name="startTime"/>
                                <label>结束时间：</label>
                                <input type="date" class="form-control" name="endTime"/>
                            </div>
                            <br/><br/>
                                <label>事件类型:</label>
                                <select id="role_select.type" class="form-control" style="margin-left: 10px" name="rType">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.RWLX }" var="item">
									<option value="${item.value}">${item.value }</option>
									</c:forEach>
		                        </select>
                                <label style="margin-left: 65px">事件等级:</label>
                                <select id="role_select.grade" class="form-control" style="margin-left: 10px" name="rGrade">
									<option value="">请选择</option>
									<c:forEach items="${DataMap.RWDJ }" var="item">
									<option value="${item.value }">${item.value }</option>
									</c:forEach>
		                        </select>
		                        <label style="margin-left: 35px">事件状态:</label>
                                <select id="role_select.status" class="form-control" style="margin-left: 10px" name="rStatus">
									<option value="">请选择</option>
									<option value="未上报">未上报</option>
									<option value="已上报">已上报</option>
		                        </select>
                            <button type="button" class="btn btn-default" id="query-btn" style="margin-left: 40px">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table">
                    <thead>
                    <tr>
                        <th>事件名称</th>
                        <th>事件类型</th>
                        <th>发生时间</th>
                        <th>事件等级</th>
                        <th>事件状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    	<tr></tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="add_role">修改事件</button>
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal5"  id="update_role_user">删除事件</button>
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal2" id="update_role_power">查看详情</button>
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal3" id="update_role_report">事件上报</button>
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal4" id="update_role_resubmit">事件续报</button>
	                
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
                                <h4 class="modal-title" id="myModalLabel">修改事件</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="row">
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">事件类型</label>
												<div class="col-sm-8">
													<span id="ssType"></span>
												</div>
											</div>
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">发生位置 </label>
												<div class="col-sm-8">
													<select class="form-control" id="ssRegion">
														<option value="">请选择</option>
														<c:forEach items="${DataMap.QY }" var="item">
															<option value="${item.value }">${item.value }</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
								
										<div class="row">
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">事件名称</label>
												<div class="col-sm-8">
													<span id="ssName"></span>
												</div>
											</div>
								
											
										</div>
								
										<div class="row">
											<div class="col-sm-12 form-group">
												<label class="col-sm-2 control-label text-center">详细地址</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="ssAddress">
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">事件等级</label>
												<div class="col-sm-8">
													<select class="form-control" id="ssGrade">
														<option value="">请选择</option>
														<c:forEach items="${DataMap.RWDJ }" var="item">
															<option value="${item.value }">${item.value }</option>
														</c:forEach>
													</select>
												</div>
											</div>
											
											<div class="col-sm-4 form-group">
												<label class="col-sm-6 control-label text-center">发生时间</label>
												<div class="col-sm-6" style="padding-top:5px">
													<span id="ssDate"></span>
												</div>
											</div>
											
										</div>
										
										<div class="row">
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">报案人</label>
												<div class="col-sm-8">
													<span id="ssInfo"></span>
												</div>
											</div>
								
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">联系电话</label>
												<div class="col-sm-8">
													<span id="ssTel"></span>
												</div>
											</div>
											
										</div>
										
										
										<div class="row">
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">伤亡人数</label>
												<div class="col-sm-8">
													<input type="text" class="form-control" id="ssNum">
												</div>
											</div>
								
											<div class="col-sm-6 form-group" id="areaSS">
												<label class="col-sm-4 control-label text-center">影响面积</label>
												<div class="col-sm-8">
													<input type="text" class="form-control" id="ssArea">
												</div>
											</div>
											
										</div>
										
										<div class="row">
											<div class="col-sm-12 form-group">
												<label class="col-sm-2 control-label text-center">描述</label>
												<div class="col-sm-10">
													<textarea class="form-control" id="ssDesc">  </textarea>
												</div>
											</div>
										</div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="add_dlog_submit1">确认修改</button>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <!-- 添加续报 -->
                <div class="modal fade small_font" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">续报事件</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form" id="resubmit">
                                        <div class="row">
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">事件名称</label>
												<div class="col-sm-8">
													<span id="sssName"></span>
												</div>
											</div>
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">事件等级</label>
												<div class="col-sm-8">
													<select id="sssGrade" class="form-control" name="rsType">
														<option value="">请选择</option>
														<c:forEach items="${DataMap.RWDJ }" var="item">
															<option>${item.value }</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-sm-6 form-group">
												<label class="col-sm-4 control-label text-center">续报伤亡</label>
												<div class="col-sm-8">
													<input type="text" class="form-control" required name="rsNum">
												</div>
											</div>
								
											<div class="col-sm-6 form-group" id="areaRS">
												<label class="col-sm-4 control-label text-center">续报面积</label>
												<div class="col-sm-8">
													<input type="text" class="form-control" required name="rsArea">
												</div>
											</div>
											
										</div>
								
										<div class="row">
											<div class="col-sm-12 form-group">
												<label class="col-sm-2 control-label text-center">续报原因</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" required name="rsAddress">
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-sm-12 form-group">
												<label class="col-sm-2 control-label text-center">描述</label>
												<div class="col-sm-10">
													<textarea class="form-control" required name="rsDesc">  </textarea>
												</div>
											</div>
										</div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary add-btn" id="add_dlog_resubmit">确认续报</button>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                 <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					 <div class="modal-dialog">
			                        <div class="modal-content">
			                         <div class="modal-header">
			                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
			                                <h4 class="modal-title" id="myModalLabel">确认上报</h4>
			                            </div>
			                            <div class="modal-body">
			                            	<p style="text-align: center;font-size: 20px">确认要上报选中项吗？</p>
			                            </div>
			                            <div class="modal-footer">
			                                 <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
			                                <button type="button" class="btn btn-primary add-btn" id="add_report">确定</button>
			                            </div>
			                        </div>
			                    </div>
			                </div>
		
		
		 <div class="modal fade small_font" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                         <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">确认删除</h4>
                            </div>
                            <div class="modal-body">
                            	<p style="text-align: center;font-size: 20px">确认要删除选中项吗？</p>
                            </div>
                            <div class="modal-footer">
                                 <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="delete_report">删除</button>
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
                                <h4 class="modal-title" id="myModalLabel">查看详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-6">
                                            <div class="form-group div1">
                                                <label for="show_dlog_name" class="col-sm-3 col-xs-3 control-label">事件名称</label>
                                                <div class="col-sm-9">
                                                    <span id="sName"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div2">
                                                <label for="show_dlog_date" class="col-sm-3 col-xs-3 control-label">发生时间</label>
                                                <div class="col-sm-9">
                                                    <span id="sDate"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="show_dlog_stage" class="col-sm-3 col-xs-3 control-label">事件类型</label>
                                                <div class="col-sm-9">
                                                   <span id="sType"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="show_dlog_desc" class="col-sm-3 col-xs-3 control-label">事件描述</label>
                                                <div class="col-sm-9">
                                                    <textarea id="sDesc" style="font-size: 12px;height: 80px;resize:none" disabled></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group div5">
                                                <label for="show_area_id" class="col-sm-3 col-xs-3 control-label">发生区域</label>
                                                <div class="col-sm-9">
													<span id="sRegion"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div6">
                                                <label for="show_dlog_loss" class="col-sm-3 col-xs-3 control-label">报案人</label>
                                                <div class="col-sm-9">
                                                    <span id="sInfo"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div7">
                                                <label for="show_dlog_plan" class="col-sm-3 col-xs-3 control-label">伤亡人数</label>
                                                <div class="col-sm-9">
                                                    <span id="sNum"></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group div8">
                                                <label for="show_dlog_pic" class="col-sm-3 col-xs-3 control-label">事件图片</label>
                                                <div class="col-sm-9">
                                                    <img alt="图片" src="" id="show_dlog_pic" width="150" height="150"/>
                                                </div>
                                            </div>
                                            <div class="form-group div9">
                                                <label for="show_dlog_type" class="col-sm-3 col-xs-3 control-label">事件等级</label>
                                                <div class="col-sm-9">
                                                    <span id="sGrade"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div10">
                                                <label for="show_dlog_found" class="col-sm-3 col-xs-3 control-label">详细地址</label>
                                                <div class="col-sm-9">
                                                        <span id="sAddress"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div11">
                                                <label for="show_class_id" class="col-sm-3 col-xs-3 control-label">联系电话</label>
                                                <div class="col-sm-9">
                                                    <span id="sTel"></span>
                                                </div>
                                            </div>
                                            <div class="form-group div12" id="areaS">
                                                <label for="show_dlog_influence" class="col-sm-3 col-xs-3 control-label">影响面积</label>
                                                <div class="col-sm-9">
                                                    <span id="sArea"></span>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
			                        <div class="col-sm-12">
			                            <table class="table table-bordered table-hover table-striped" style="font-size: 12px" id="rs_table">
			                                <tr>
			                                    <th>续报时间</th>
			                                    <th>续报人</th>
			                                    <th>续报等级</th>
			                                    <th>续报伤亡</th>
			                                    <th id="rsTr">续报面积</th>
			                                    <th>续报描述</th>
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
	</div>
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    
    //显示所有员工分页信息
	function show_list(pageNo,rName,startTime,endTime,rType,rGrade,rStatus){
    $("#add_role").attr("disabled",true);
	$("#update_role_user").attr("disabled",true);
	$("#update_role_power").attr("disabled",true);
	$("#update_role_report").attr("disabled",true);
	$("#update_role_resubmit").attr("disabled",true);
    	
    	
    	
    	var rName = $("[name='rName']").val();
    	var startTime = $("[name='startTime']").val();
    	var endTime = $("[name='endTime']").val();
    	var rType = $("[name='rType']").val();
    	var rGrade = $("[name='rGrade']").val();
    	var rStatus = $("[name='rStatus']").val();
		$.ajax({
			data:{"pageNo":pageNo,"rName":rName,"startTime":startTime,"endTime":endTime,"rType":rType,"rGrade":rGrade,"rStatus":rStatus},
			url:"/ZSGLXT/reportController/reportMain.do",
			success:function(msg){
				json_to_table(msg,"my_table",["rid","rname","rtype","rdate","rgrade","rstatus"]);
				$("#my_table tbody tr").click(function () {
					$("#my_table tbody tr").removeClass("as");
					$(this).addClass("as");
					
					$("#hid").val($(this).attr("index"));
					if($("#hid").val()==0){
			    		$("#add_role").attr("disabled",true);
			    		$("#update_role_user").attr("disabled",true);
			    		$("#update_role_power").attr("disabled",true);
			    		$("#update_role_report").attr("disabled",true);
			    		$("#update_role_resubmit").attr("disabled",true);
			    	}else{
			    		$.ajax({
			    			data:{"rId":$("#hid").val()},
			    			url:"/ZSGLXT/reportController/findReportById.do",
			    			success:function(msg){
			    				console.info(msg);
			    				if(msg.rstatus=="已上报"){
			    					$("#add_role").attr("disabled",true);
			    		    		$("#update_role_user").attr("disabled",true);
			    		    		$("#update_role_power").attr("disabled",false);
			    		    		$("#update_role_report").attr("disabled",true);
			    		    		$("#update_role_resubmit").attr("disabled",false);
			    				}else{
			    					$("#add_role").attr("disabled",false);
			    		    		$("#update_role_user").attr("disabled",false);
			    		    		$("#update_role_power").attr("disabled",false);
			    		    		$("#update_role_report").attr("disabled",false);
			    		    		$("#update_role_resubmit").attr("disabled",true);
			    				}
			    			}
			    		});
			    	}
				});
				$("#hid").val("0");
			}
		});
		
	}
    //调用
	show_list(1,"","","","","","");
    
    $("#query-btn").click(function() {
    	var rName = $("[name='rName']").val();
    	var startTime = $("[name='startTime']").val();
    	var endTime = $("[name='endTime']").val();
    	var rType = $("[name='rType'] option:selected").val();
    	var rGrade = $("[name='rGrade']").val();
    	var rStatus = $("[name='rStatus']").val();
    	show_list(1,rName,startTime,endTime,rType,rGrade,rStatus);
	});
    
    $("#update_role_power").click(function() {
	    	$.ajax({
				data:{"rId":$("#hid").val()},
				url:"/ZSGLXT/reportController/findReportById.do",
				success:function(msg){
					console.info(msg);
					$("#sName").html(msg.rname);
					$("#sDate").html(msg.rdate);
					$("#sType").html(msg.rtype);
					$("#sDesc").val(msg.rdesc);
					$("#sInfo").html(msg.rinformant);
					$("#sGrade").html(msg.rgrade);
					$("#sAddress").html(msg.raddress);
					$("#sTel").html(msg.rtel);
					$("#show_dlog_pic").attr("src","http://192.168.1.67:8080/img/"+msg.rimage);
					if(msg.rarea==null || msg.rarea==""){
						$("#areaS").css("display","none");
					}else{
						$("#areaS").css("display","block");
						$("#sArea").html(msg.rarea);
					}
					$("#sNum").html(msg.rnum);
					$("#sRegion").html(msg.rregion);
					
					var set = msg.tresubmits;
					
					var str = "";
					for (var resubmit of set) {
						if(resubmit.rsArea==null||resubmit.rsArea==""){
							$("#rsTr").css("display","none");
							str += "<tr>"
								+"<td>"+resubmit.rsDate+"</td>"
								+"<td>"+resubmit.tuser.userName+"</td>"
								+"<td>"+resubmit.rsType+"</td>"
								+"<td>"+resubmit.rsNum+"</td>"
								+"<td>"+resubmit.rsDesc+"</td>"
								+"</tr>";
						}else{
							$("#rsTr").css("display","block");
							str += "<tr>"
							+"<td>"+resubmit.rsDate+"</td>"
							+"<td>"+resubmit.tuser.userName+"</td>"
							+"<td>"+resubmit.rsType+"</td>"
							+"<td>"+resubmit.rsNum+"</td>"
							+"<td>"+resubmit.rsArea+"</td>"
							+"<td>"+resubmit.rsDesc+"</td>"
							+"</tr>";
						}
						
					}
					$("#dlog_clog_tbody").html(str);
				}
			});
   		 
	});
    
    $("#add_role").click(function() {
    	
    	$.ajax({
			data:{"rId":$("#hid").val()},
			url:"/ZSGLXT/reportController/findReportById.do",
			success:function(msg){
				console.info(msg);
				$("#ssName").html(msg.rname);
				$("#ssDate").html(msg.rdate);
				$("#ssType").html(msg.rtype);
				$("#ssDesc").val(msg.rdesc);
				$("#ssInfo").html(msg.rinformant);
				$("#ssGrade option[value='"+msg.rgrade+"']").attr("selected", true);
				$("#ssAddress").val(msg.raddress);
				$("#ssTel").html(msg.rtel);
				
				if(msg.rarea==null || msg.rarea==""){
					$("#areaSS").css("display","none");
				}else{
					$("#areaSS").css("display","inline-block");
					$("#ssArea").val(msg.rarea);
				}
				$("#ssNum").val(msg.rnum);
				$("#ssRegion option[value='"+msg.rregion+"']").attr("selected", true);
			}
		});
	});
    
    
    $("#add_dlog_submit1").click(function() {
    	var region = $("#ssRegion").val();
		var address = $("#ssAddress").val();
		var grade = $("#ssGrade").val();
		var num = $("#ssNum").val();
		var area = $("#ssArea").val();
    	var desc = $("#ssDesc").val();
    	$.ajax({
			data:{"rId":$("#hid").val(),"region":region,"address":address,"grade":grade,"num":num,"area":area,"desc":desc},
			url:"/ZSGLXT/reportController/updateReport.do",
			success:function(msg){
				checkSuccess(msg,$("#myModal_alert"),"修改",$("#myModal"));
			    show_list(1,"","","","","","");
			    $("#hid").val("0");
			}
		});
	});
    
    
    $("#delete_report").click(function() {
    	$.ajax({
			data:{"rId":$("#hid").val()},
			url:"/ZSGLXT/reportController/deleteReport.do",
			success:function(msg){
				checkSuccess(msg,$("#myModal_alert"),"删除",$("#myModal5"));
			    show_list(1,"","","","","","");
			    $("#hid").val("0");
			}
		});
	});
    
    $("#add_report").click(function() {
    	$.ajax({
			data:{"rId":$("#hid").val()},
			url:"/ZSGLXT/reportController/updateReportStatus.do",
			success:function(msg){
				checkSuccess(msg,$("#myModal_alert"),"上报",$("#myModal3"));
			    show_list(1,"","","","","","");
			    $("#hid").val("0");
			}
		});
	});
    
    $("#update_role_resubmit").click(function() {
    	
    	$("[name='rsNum']").val("");
    	$("[name='rsArea']").val("");
    	$("[name='rsDesc']").val("");
    	$("[name='rsAddress']").val("");
    	$.ajax({
			data:{"rId":$("#hid").val()},
			url:"/ZSGLXT/reportController/findReportById.do",
			success:function(msg){
				console.info(msg);
				$("#sssName").html(msg.rname);
				$("#sssGrade").val(msg.rgrade);
				if(msg.rarea==null||msg.rarea==""){
					$("#areaRS").css("display","none");
				}else{
					$("#areaRS").css("display","inline-block");
				}
			}
		});
	});
    
    $("#add_dlog_resubmit").click(function() {
    	if($("[name='rsNum']").val()==""||$("[name='rsNum']").val()==null||$("[name='rsAddress']").val()==""||$("[name='rsAddress']").val()==null||$("[name='rsDesc']").val()==""||$("[name='rsDesc']").val()==null){
    		alertAiv($("#myModal_alert"),"请完善续报");
    	}else{
    		
	    	$.ajax({
				data:$.param({"rId":$("#hid").val()})+'&'+$('#resubmit').serialize(),
				url:"/ZSGLXT/resubmitController/addResubmit.do",
				success:function(msg){
					checkSuccess(msg,$("#myModal_alert"),"续报",$("#myModal4"));
				    show_list(1,"","","","","","");
				    cleanInput($("#div1"));
				    $("#hid").val("0");
				}
			});
    	}
	});
    
    
    </script>
</body>
</html>