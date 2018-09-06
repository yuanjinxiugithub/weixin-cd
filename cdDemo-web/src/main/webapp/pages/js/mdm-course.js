const controller = "/cd-demo/mdmCourse";

var Course = {
	loadTab :function(){
		 var columns=[
			  {
	    	 	 "data": null,
	    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
	    		 var startnum = this.api().page() * (this.api().page.info().length);
	    		 $(nTd).html(iRow + 1 + startnum); 
	             }
			  },
			  {'data':'code'},
			  {'data':'name'},
			  {'data':'teacherCode'},
			  {'data':'teacherName'},
			  {'data':'classCode'},
			  {'data':'id',
				  'render':function(data,type,full){ 
					  return "必修";
				  }
			  },
			  {'data':'status',
				  'render':function(data,type,full){ 
					  var actions = "";
					if(data == "1"){
							actions= "开课中";
					}else{
						actions = "待开课"
					}
					return actions;
				  }
			  },
			  {'data':'createUser'},
			  {'data':'createTime'},
			  {'data':'id',
				  'render':function(data,type,full){ 
			        	 var actions = "<a href='javascript:Course.updateInfo(\"" + data + "\");'>修改</a>&nbsp;&nbsp;<a href='javascript:Course.deleteItem(\"" + data + "\");'>删除</a>&nbsp;&nbsp;"
		                       return actions;
			           }   
				  
			  }
           ];  
		 var table =  $('#dataTable');//定义获取的table对象	
		 var url =controller+"/findByMap.do";//定义请求的地址
		 var datas = $("#searchForm").serializeObject();
			 datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
	},
	
	reloadTab:function(){
		 var table = $('#dataTable').DataTable();
		    table.destroy();
		    Course.loadTab();
	 },
	 
	 searchTab:function() {
		 Course.reloadTab();
	 },
	
	 addForm:function(){
		 $("#teacherName").val($('#teacherCode option:selected').text());
		 var datas = $("#addForm").serializeObject();
		 var url = "/mdmCourse/add.do";
		 Mes.loadJson(url, $.param(datas), function(results) {
				sysAlert(results.msg, function() {
					$("#addForm")[0].reset();
					closeAlert();
					$('#addModal').modal('hide');// 隐藏modal
					Course.reloadTab();// 重新加载tab
				});
			});
	 },
	 
	deleteItem:function(id){
		 var datas = {id:id};
		 var url = "/mdmCourse/delete.do";
		 sysConfirm('确定删除该条记录？', function() {
			 Mes.loadJson(url, $.param(datas), function(results) {
				 sysAlert(results.msg,function(){
					 closeAlert();
					 Course.reloadTab();// 重新加载tab
				 });
			 }); 
		 });
	},
	
	updateInfo:function(id){
		var datas = {id:id};
		 var url = "/mdmCourse/get.do";
		 Mes.loadJson(url, $.param(datas), function(results) {
			 $("#updateForm").setForm(results);
			 $("#createTime").val(results.createTime);
		 });
		 $('#updateModal').modal('show');
	},
	
	
	updateForm:function(){
		 var datas = $("#updateForm").serializeObject();
		 console.log(datas);
		 var url = "/mdmCourse/update.do";
		 Mes.loadJson(url, $.param(datas), function(results) {
			 console.log(results);
			 sysAlert(results.msg,function() {
					closeAlert();
					$('#updateModal').modal('hide');// 隐藏modal
					Course.reloadTab();// 重新加载tab
				});
		 });
	},
};