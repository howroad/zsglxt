<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>交接班管理</title>
</head>
<body>
		<div class="container-fluid" id="wrap">
		   <div class="row">
            <h2 class="text-center">交接班管理</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-2"><span class="navbar-brand">条件查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                 <label>用户名:</label>
			                      <input type="text" class="form-control" id="user"  name="userName">
			                       <label>上班时间:</label>
			                  <input type="date" class="form-control" id="starttime"  name="SStarttime"> 
			                   <label>下班时间:</label>
			                     <input type="date" class="form-control" id="endtime"  name="SEndtime">	
                            </div>
                            <button type="button" class="btn btn-default" id="btn">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table" >
                    <thead>
                    <tr>
                        <th>值班人员</th>
                        <th>上班时间</th>
                        <th>下班时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
               
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
	  <input type="hidden" id="hid" value="0"/> 
	  
	  
	  	<script>
	  	
	  		$("#btn").click(function(){
	  			show_list(1);
			})
	  	
			function show_list(pageNo){
				var userName = $("#user").val();
				var SStarttime = $("#starttime").val();
				var SEndtime = $("#endtime").val();
				$.ajax({
					data:{"pageNo":pageNo,"userName":userName,"SStarttime":SStarttime,"SEndtime":SEndtime},
					url:"/ZSGLXT/shiftController/findAllShift.do",
					success:function(msg){
						json_to_table(msg,"my_table",["sid","tuser.userRname","sstarttime","sendtime"]);
						$("#hid").val("0");
					}
				});
			}
		    //调用
			show_list(1);
			</script>
</body>
		
</html>