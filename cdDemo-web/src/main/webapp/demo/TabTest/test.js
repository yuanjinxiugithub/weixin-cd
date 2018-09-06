
var Test={
		currentItem:null,
		
		loadTable:function(){//加载主页面的table
			var columns=[
				  {
		    		 "data": null,
		    		 "createdCell": function (nTd, sData, oData, iRow, iCol) {
		    		 var startnum = this.api().page() * (this.api().page.info().length);
		    		 $(nTd).html(iRow + 1 + startnum); //分页行号累加：$(nTd).html(iRow+1);
		    		 }},//自动递增
		    		 {
		    			    'data':'id',
				            "render": function(data,type,full) {
				            	//console.log(data);
				            	var actions = "<input type='radio' name='checkList' value='"+data+"'>";
				            	 return actions;
				            }
				   }, 
				  {'data':'appId'},  
				  {'data':'appName'},
				  {'data':'appVersion'},  
				  {'data':'appDesc'},  
				  {'data':'isUpdate'},  
				  {'data':'downloadNum'},  
				  {'data':'createUser'},  
				  {'data':'createTime'}
			];  
			var table =  $('#sysTable');//定义获取的table对象	
			var url = "/mes-demo/sys/findpage.do";//定义请求的地址
			var datas =  $("#sysForm").serializeObject();//form 表单对象序列化 $.param(
			datatable = DataTablePack.serverTable(table,url,datas,columns,[],[]); //datatables 加载数据
		},
		del:function(){
			//  var id = $('input[name="checkList"]:checked').val();
			 Test.currentItem =  $('input[name="checkList"]:checked').val();
	       	  var url = "/sys/delete.do";
	         	  var datas={id:Test.currentItem};
	       	  if(Test.currentItem == null){
	       		  sysAlert("请选择一条数据");
	       	  }
	       	  else{
	       		  
	       		  sysConfirm('确定删除该条记录？', function () {
	           		  Mes.loadJson(url,$.param(datas),function(results){
	           			  if(results.succ){
	           		    		sysAlert("删除记录成功！",function(){
	           		    			 closeAlert();
	           		    			// SysManage.reloadTable();//重新加载table
	           		    		});
	           		    	}else{
	           		    		sysAlert("删除记录失败！");
	           		    	}
	           		  })
	           		 });
	       	  }
		},
		editInit:function(){
			 Test.currentItem =  $('input[name="checkList"]:checked').val();
	    	 if(Test.currentItem == null)
	    	 {
	    		  sysAlert("请选择一条数据");
	    	 }else
	    	 {
	    		 $('#editModal').modal('show');
	    		  var url="/sys/get.do";
		    	  var datas = {};
		    	  datas.id= Test.currentItem;
		    	  $("#id").val(datas.id);
		    	  Mes.loadJson(url,$.param(datas),Test.loadEditCallback);
	    	 }
		},
		editExect:function(){
			var url="/sys/update.do";
    		var datas = $("#updateForm").serializeObject();
			  sysConfirm('确定提交表单？', function () {
		    		Mes.loadJson(url,$.param(datas), Test.saveEditCallback);
			    });
		},
		saveEditCallback:function(result){//编辑成功回调
			 if(result.succ){
				  sysAlert(result.msg,function(){
					  closeAlert();
					  $('#editModal').modal('hide');//隐藏modal
				  });
			  }else{
				  sysAlert(result.msg,function(){
					  closeAlert();
				  });
			  }
		},
		loadEditCallback:function(result){//编辑-ajax回调函数 填充表单
			$("#createTime").val(result.createTime);
			$("#updateForm").setForm(result);//设置表单
		},
	
			
		
};
