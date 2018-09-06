const controller = "/cd-demo/sysUser";

var UserList = {
		loadTab :function(){
			 var columns=[
				  {
		    	 	 "data": null,
		    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
		    		 var startnum = this.api().page() * (this.api().page.info().length);
		    		 $(nTd).html(iRow + 1 + startnum); 
		             }
				  },
				  {'data':'userId'},
				  {'data':'name'},
				  {'data':'beloyClassName'},
				  {'data':'tel'},
				  {'data':'email'},
				  {'data':'createTime'},
				  {'data':'userType',
				   'render':function(data,type,full){ 
			        	 var actions = "";
			        	 if(data=="0"){
			        		 actions="系统管理员";
			        	 } if(data=="1"){
			        		 actions="学生";
			        	 }
			        	 if(data=="2"){
			        		 actions="教师";
			        	 }
		                       return actions;
			           }   
				  },
				  {'data':'id',
					  'render':function(data,type,full){ 
				        	 var actions = "<a href='javascript:UserList.updateItem(\"" + data + "\");'>修改</a>&nbsp;&nbsp;&nbsp;" +
				        	 		"<a href='javascript:UserList.deleteItem(\"" + data + "\");'>删除</a>"
			                       return actions;
				           }   
				  }
	           ];  
			 var table =  $('#dataTable');//定义获取的table对象	
			 var url =controller+"/findByMap.do";//定义请求的地址
				 datatable = DataTablePack.serverTable(table,url,{},columns,[]);
			
		},
		
		 reloadTab:function(){
			 var table = $('#dataTable').DataTable();
			    table.destroy();
			    UserList.loadTab();
		 },
		 
		 
		 updateItem:function(id){//编辑model
			 var datas = {id:id};
			 var url = "/sysUser/get.do";
			 Mes.loadJson(url, $.param(datas), function(results) {
				 $("#updateForm").setForm(results);
				 $("#createTime").val(results.createTime);
			 });
			 $('#updateModal').modal('show');
		},
		
		 updateForm:function(){//编辑表单提交
			 var datas = $("#updateForm").serializeObject();
			 var url = "/sysUser/updateInfo.do";
			 Mes.loadJson(url, $.param(datas), function(results) {
				 sysAlert(results.msg,function() {
						closeAlert();
						$('#updateModal').modal('hide');// 隐藏modal
						UserList.loadTab();// 重新加载tab
					});
			 });
		 },
		
		deleteItem:function(id){
			 var datas = {id:id};
			 var url = "/sysUser/delete.do";
			 sysConfirm('确定删除该条记录？', function() {
				 Mes.loadJson(url, $.param(datas), function(results) {
					 sysAlert(results.msg,function(){
						 closeAlert();
						 UserList.reloadTab();// 重新加载tab
					 });
				 }); 
			 });
		},
		
		getCurrentInfo:function(){ //h获取当前登录的用户信息
			var url = "/sysUser/getByUserId.do";
			var datas = {userid :"1001"};
			Mes.loadJson(url, $.param(datas), function(results) {
				 $("#lookForm").setForm(results);
			 }); 
			
		},
		
		saveUpdate:function(){//更新用户信息
			 var url="/sysUser/updateInfo.do";
	    	 var datas = $("#lookForm").serializeObject();
			 sysConfirm('确定用户信息吗？', function () {
		    		Mes.loadJson(url,$.param(datas), function(results){
		    			 if(results.succ){
           		    		 sysAlert("更新信息成功！",function(){
           		    			 closeAlert();
           		    			location.reload();
           		    		 });
           		    	}else{
           		    		  sysAlert("更新信息失败！");
           		    	}
		    		});
			    });
		},
				
		checkMdm:function(){//判断主数据是否存在这样的工号
		    var userType =  $("#userType option:selected").val();
		    var userId = $("#addUserId").val(); 
			var url = "";
			var data = {code:userId};
			if(userType=="1"){ //学生
				url="/mdmStudent/get.do";
				Mes.loadJson(url, $.param(data), function(results) {
					console.log(results);
					if(results.id=="" || results.id==null){
						 sysAlert("主数据中不存在该学生的学号！");
					}else{
						$("#addName").val(results.name);
						$("#beloyClass").val(results.classCode);
						$("#beloyClassName").val(results.className);
						 UserList.checkUserId();
					} });
			}else if(userType=="2"){ //教师
				url = "/mdmTeacher/get.do";
				Mes.loadJson(url, $.param(data), function(results) {
					console.log(results);
					if(results.id=="" || results.id==null){//不存在
						sysAlert("主数据中不存在该教师的工号！");
					}else{
						$("#addName").val(results.name);
						$("#beloyClass").val(results.parentCode);
						$("#beloyClassName").val(results.parentName);
						UserList.checkUserId();
					} });
			}
		},
		
		checkUserId:function(){//验证用户userId 是否存在
			var url = "/sysUser/getByUserId.do";
			var datas = {userid :$("#addUserId").val()};
			Mes.loadJson(url, $.param(datas), function(results) {
				console.log(results);
				if(results.id==""||results.id==null){//账号不存在，可以创建
					UserList.addUserExet();
				}
				else{//账号存在
					 sysAlert("新增失败,该工号/学号已存在！");
				}
			 }); 
		},
		
		addUserExet:function(){
			 var url="/sysUser/add.do";
    		 var datas = $("#addForm").serializeObject();
    		 Mes.loadJson(url,$.param(datas), function(results){
 				if(results.succ){
 		    		 sysAlert("新增信息成功！",function(){
 		    			 closeAlert();
 		    			location.reload();
 		    		 });
 		    	}else{
 		    		  sysAlert("新增信息失败！");
 		    	}
 			});
		},
};