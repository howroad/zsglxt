<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的事件</title>
</head>
<body>
		<div class="container-fluid" id="wrap">
		   <div class="row">
            <h2 class="text-center">我的事件</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">条件查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                 <label>事件名称</label>
			                      <input type="text" class="form-control" id="user"  name="RName">
			                       <label>开始时间</label>
			                  <input type="date" class="form-control" id="starttime"  name="SStarttime"> 
			                   <label>结束时间</label>
			                     <input type="date" class="form-control" id="endtime"  name="SEndtime">	
                            </div>
                            <button type="button" class="btn btn-default" id="btn">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table" >
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
                    </tbody>
                </table>
               
         <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal2" id="update_role_power">查看详情</button>
	             
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
               
               
               
            	
			
        </div>
     </div>
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
	  <input type="hidden" id="hid" value="0"/> 
	  
	  
	  	<script>
	  	 $("#update_role_power").click(function() {
		    	$.ajax({
					data:{"rId":$("#hid").val()},
					url:"/ZSGLXT/reportController/findReportById.do",
					success:function(msg){
						
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
	  	
	  	
	  	
	  	
	  		$("#btn").click(function(){
	  			show_list(1);
			})
	  	
			function show_list(pageNo){
	  			$("#update_role_power").attr("disabled",true);
				var RName = $("#user").val();
				var SStarttime = $("#starttime").val();
				var SEndtime = $("#endtime").val();
				$.ajax({
					data:{"pageNo":pageNo,"RName":RName,"SStarttime":SStarttime,"SEndtime":SEndtime},
					url:"/ZSGLXT/reportController/fingAllMyReport.do",
					success:function(msg){
						json_to_table(msg,"my_table",["rid","rname","rtype","rdate","rgrade","rstatus"]);
						$("#my_table tbody tr").click(function () {
							$("#my_table tbody tr").removeClass("as");
							$(this).addClass("as");
							
							$("#hid").val($(this).attr("index"));
							
							if($("#hid").val()==0){
								$("#update_role_power").attr("disabled",true);
							}else{
								$("#update_role_power").attr("disabled",false);
							}
						});
						
						$("#hid").val("0");
					}
				});
			}
		    //调用
			show_list(1);
			</script>
</body>
		
</html>