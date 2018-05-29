<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加事件</title>
<style type="text/css">
label {
	padding-top: 4px;
	font-size: 18px
}
</style>
</head>
<body>
	<div class="container-fluid" id="wrap">
            <h2 class="text-center">添加事件</h2>
		
		<form  action="/ZSGLXT/reportController/addReport.do"  method="post" enctype="multipart/form-data" id="form1">
		
		<div id="div1">
		<div class="row">
			<div class="col-sm-6 form-group">
			
				<label class="col-sm-4 control-label text-center">事件类型</label>
				<div class="col-sm-8">
					<select id="s1" class="form-control" name="RType">
						<option value="0" >请选择</option>
						<c:forEach items="${DataMap.RWLX }" var="item">
							<option value="${item.value }">${item.value }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="col-sm-6 form-group">
				<label class="col-sm-4 control-label text-center">发生位置 </label>
				<div class="col-sm-8">
					<select id="role_select" class="form-control" name="RRegion">
						<option value="0">请选择</option>
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
					<input type="text" class="form-control " name="RName">
				</div>
			</div>

			<div class="col-sm-4 form-group">
				<label class="col-sm-6 control-label text-center">事件图片</label>
				<div class="col-sm-6">
					<input type="file" name="img" id="pic">
				</div>
			</div>
			
		</div>

		<div class="row">
			<div class="col-sm-12 form-group">
				<label class="col-sm-2 control-label text-center">详细地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="RAddress">
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6 form-group">
				<label class="col-sm-4 control-label text-center">事件等级</label>
				<div class="col-sm-8">
					<select class="form-control" name="RGrade">
						<option value="0">请选择</option>
						<c:forEach items="${DataMap.RWDJ }" var="item">
							<option value="${item.value }">${item.value }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="col-sm-4 form-group">
				<label class="col-sm-6 control-label text-center">发生时间</label>
				<div class="col-sm-6" style="padding-top:5px">
					<input id="date" type="date" class="form-control" name="RDate">
				</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="col-sm-6 form-group">
				<label class="col-sm-4 control-label text-center">报案人</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="RInformant">
				</div>
			</div>

			<div class="col-sm-6 form-group">
				<label class="col-sm-4 control-label text-center">联系电话</label>
				<div class="col-sm-8">
					<input id="tl" type="text" class="form-control" name="RTel">
				</div>
			</div>
			
		</div>
		
		
		<div class="row">
			<div class="col-sm-6 form-group">
				<label class="col-sm-4 control-label text-center">伤亡人数</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="RNum">
				</div>
			</div>

			<div id="mj" class="col-sm-6 form-group" style="display:none" >
				<label class="col-sm-4 control-label text-center">影响面积</label>
				<div class="col-sm-8">
					<input id="mj2" type="text" class="form-control" name="RArea">
				</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="col-sm-12 form-group">
				<label class="col-sm-2 control-label text-center">描述</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="RDesc">  </textarea>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6 form-group">
				<label class="col-sm-6 control-label text-center"></label>
				<div class="col-sm-6">
				<button type="button" id="btn3" class="btn btn-default close-btn" style="width:80px" >清空</button>
				</div>
			</div>

			<div class="col-sm-6 form-group">
					<button type="submit" class="btn btn-default close-btn" style="width:80px" id="btn2" >提交</button>
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
		<input type="hidden" value="未上报" name="RStatus">
	</form>
</div>
		<script>
	
	    function yz(str) {  
            var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;  
            if (!myreg.test(str)) {  
                return false;  
            } else {  
                return true;  
            }  
        }  
	    
	    $("#s1").change(function() {
	    	var str= $(this).val();
			
	    	if(str=="火灾"){
	    		$("#mj").css("display","inline");
	    		$("#mj2").val("")
	    	}else{
	    		$("#mj").css("display","none");
	    		$("#mj2").val("无")
	    	}
	    	
		})
	    
		
		$("#form1").on("submit",function(event) {
        	if(!checkImage($("#pic").val())) {
        		return false;
        	}
        	var boo = true;
			$("#div1 input[type='text']").each(function() {
				var v = $(this).val();
				if ("" == v) {
				
					boo=false;
				}
			});
			$('select :selected').each(function() {
				var r = $(this).val();
				if (r == "0") {
					boo=false;
				}
			});
			var tl=$("#tl").val();
			if(tl != ""){
				if(!yz(tl)){
					
					alertAiv($("#myModal_alert"),"请输入有效电话号码");
					return false;
				}
				
			}
			
			var d1 = $("#date").val();
			var d2 = '2018-05-23';
			var t1 = new Date(d1);
			var t2 = new Date(d2);
			
			if(""==d1||(t1-t2>0)){
				alertAiv($("#myModal_alert"),"请输入正确的时间");
					return false;
			}
			
			
			if(!boo) {
				alertAiv($("#myModal_alert"),"请完善内容");
				return false;
			}
			var form = this;
			var formData = new FormData(form);
			$.ajax({
				url:this.action,
				type:"post",
				data:formData,
				dataType:"JSON",
				async:true,
				processData:false,
				contentType:false,
				success:function(value) {
					if(value) {
						alertAiv($("#myModal_alert"),"添加成功");
					} else {
						alertAiv($("#myModal_alert"),"添加失败");
					}
					cleanInput($("#div1"));
				}
			});
			$(".modal").modal('hide');
			return false;
		});
		
		$("#btn3").click(function() {
			cleanInput($("#div1"));
		})
		
		
		</script>
</body>
</html>