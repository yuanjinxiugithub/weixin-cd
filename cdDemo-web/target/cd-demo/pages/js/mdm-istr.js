const controller = "/cd-demo/mdmIstr";

var Istr = {
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
			  {'data':'createUser'},
			  {'data':'createTime'},
			  {'data':'id',
				  'render':function(data,type,full){ 
			        	 var actions = "<a href='javascript:Istr.updateInfo(\"" + data + "\");'>修改</a>&nbsp;&nbsp;<a href='javascript:Istr.deleteItem(\"" + data + "\");'>删除</a>&nbsp;&nbsp;"
		                       return actions;
			           }   
				  
			  }
           ];  
		 var table =  $('#istrTable');//定义获取的table对象	
		 var url =controller+"/findByMap.do";//定义请求的地址
		 var datas = $("#searchForm").serializeObject();
			 datatable = DataTablePack.serverTable(table,url,datas,columns,[]);
	},
	
	 reloadTab:function(){
		 var table = $('#istrTable').DataTable();
		    table.destroy();
		    Istr.loadTab();
	 },
	 
	 searchTab:function() {
		    Istr.reloadTab();
	 },
	 
	 addForm:function(){
		 var datas = $("#addForm").serializeObject();
		 var url = "/mdmIstr/add.do";
		 Mes.loadJson(url, $.param(datas), function(results) {
				sysAlert(results.msg, function() {
					closeAlert();
					$('#addModal').modal('hide');// 隐藏modal
					Istr.reloadTab();// 重新加载tab
				});
			});
	 },
	 
	deleteItem:function(id){
		 var datas = {id:id};
		 var url = "/mdmIstr/delete.do";
		 sysConfirm('确定删除该条记录？', function() {
			 Mes.loadJson(url, $.param(datas), function(results) {
				 sysAlert(results.msg,function(){
					 closeAlert();
					 Istr.reloadTab();// 重新加载tab
				 });
			 }); 
		 });
	},
	
	updateInfo:function(id){
		var datas = {id:id};
		 var url = "/mdmIstr/get.do";
		 Mes.loadJson(url, $.param(datas), function(results) {
			 $("#updateForm").setForm(results);
			 $("#createTime").val(results.createTime);
		 });
		 $('#updateModal').modal('show');
	},
	
	
	updateForm:function(){
		 var datas = $("#updateForm").serializeObject();
		 var url = "/mdmIstr/update.do";
		 Mes.loadJson(url, $.param(datas), function(results) {
			 sysAlert(results.msg,function() {
					closeAlert();
					$('#updateModal').modal('hide');// 隐藏modal
					Istr.reloadTab();// 重新加载tab
				});
		 });
	},
};