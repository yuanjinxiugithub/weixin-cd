/** 
 *处理DataTable的数据 
 *公共部分 
 */

	/** 公开调用方法 **/
	var DataTablePack = {
		/* 处理处理静态数据  */
		baseTable : function(table) {
			var oTable = table
					.dataTable({
						'language' : language,//汉化工具条  
						'lengthMenu' : [ 10, 20, 30, 50, 100 ],//显示每页大小的下拉框中的选项  
						'dom' : "<'row' <'col-md-12'T>><'row'<'col-md-6 col-sm-12'f><'col-md-6 col-sm-12'l>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // horizobtal scrollable datatable  
						'pagingType' : 'full_numbers',//分页样式  
						'columnDefs' : [ {
							'targets' : [ 0, 1,2 ],
							'orderable' : false
						} ],//默认列参数  
						"order" : [ [ 2, "asc" ] ]
					//默认排序的列  
					});

			checkAll(table);//全选功能  
			return oTable;
		},
		/* 即时后台获取数据*/
		serverTable : function(table, url, reqData, columns, startNum) {
			//alert(url);  
			var oTable = table.dataTable({
						'ajax' : {
							type : 'POST',//更改Ajax的请求方式   
							data : function ( d ) {
							         return $.extend( {}, d, reqData);//添加额外的参数发送到服务器 查询条件
							    },
							url : url,//从一个ajax数据源读取数据给表格内容  
							error : function(resp) {
								//alert(JSON.stringify(resp));
							}
						},
						'serverSide' : true,//是否开启服务器模式  
						'stateSave' : true,//保存状态 - 在页面重新加载的时候恢复状态（页码等内容）  
						//'processing' :  "<span style='color:#ff0000;'><img src='/mes-demo/static/bmsmart/images/loading.gif'></span>",//当表格处在处理过程（例如排序）中时，启用或者禁止 'processing'指示器的显示。  
						//'displayStart' : startNum,//初始化显示的时候从第几条数据开始显示(一开始显示第几页)  
						'columns' : columns,
						'language' : DataTablePaging.language.zh_cn,//汉化工具条  
						'lengthMenu' : [ 10, 20, 30, 50, 100 ],//显示每页大小的下拉框中的选项  
						'dom' : 't<"bottom"lip><"clear">', // horizobtal scrollable datatable  
						'sPaginationType' : 'full_numbers',//分页显示所有按钮  
						"searching": false,//不显示查询框  yjx
						 "scrollX":true,//添加侧滑
						"bLengthChange": false,//是否开启分页功能,即使设置为false,仍然会有一个默认的<前进,后退>分页组件  yjx
						'columnDefs' : [ {
							'targets' : [ 0,2],
							'orderable' : false
						} ],//默认列参数  
						"order" : [ [ 1, "asc" ] ]
					//默认排序的列  
					});
		//	checkAll(table);//全选功能  
			return oTable;
		}
	
	};





var DataTablePaging = {
	    language : {
	        zh_cn : {
	            processing : "数据正在加载中...",
	            search : "查询:",
	            lengthMenu : "每页显示 _MENU_ 条记录",
	            info : "从 _START_ 到 _END_ /共 _TOTAL_ 条记录",
	            infoEmpty : "从 0 到  0  共 0  条记录",
	            infoFiltered : "(从 _MAX_ 条数据中检索)",
	            infoPostFix : "",
	            thousands : ",",
	            loadingRecords : "数据加载中...",
	            zeroRecords : "没有检索到数据",
	            emptyTable : "没有数据",
	            paginate : {
	                first : "首页",
	                previous : "前一页",
	                next : "后一页",
	                last : "尾页"
	            },
	            aria : {
	                sortAscending : ": 升序",
	                sortDescending : ": 降序"
	            }
	        }
	    },
	    /**
	     * 获取ajax分页options设置
	     */
	    getAjaxPagingOptions : function(settings) {
	        var options = {
	            ajax : {
	                url : settings.ajaxUrl,
	                type : "post",
	                data: settings.data //传入组装的参数
	            },
	            serverSide : true,
	            destroy : true,
	            processing : true,
	            ordering : true,
	            searching : false,
	            paging : true,
	            pagingType : "full_numbers",
	            lengthMenu : [ 10, 20, 50, 100 ],
	            pageLength : 20,
	            order : settings.order,// [index,'asc|desc']
	            language : DataTablePaging.language.zh_cn,
	            columns : settings.colums,
	            columnDefs : settings.columsdefs
	        };
	        return options;
	    },
	    /**
	     * 获取ajax不分页options设置
	     */
	    getOptions : function(settings) {
	        var options = {
	            ajax : {
	                url : settings.ajaxUrl,
	                type : "post"
	            },
	            serverSide : false,
	            destroy : true,
	            processing : true,
	            ordering : true,
	            searching : false,
	            pagingType : "full_numbers",
	            lengthMenu : [ 10, 20, 50, 100 ],
	            pageLength : 20,
	            language : DataTablePaging.language.zh_cn,
	            columns : settings.colums,
	            columnDefs : settings.columsdefs,
	        };
	        return options;
	    },
	    /**
	     * 获取非ajax分页options设置
	     */
	    getNotAjaxPagingOptions : function(settings) {
	        var options = {
	            serverSide : false,
	            destroy : true,
	            processing : true,
	            ordering : false,
	            searching : false,
	            paging : true,
	            pagingType : "full_numbers",
	            lengthChange : false,
	            pageLength : settings.pageLength,
	            info : false,
	            language : DataTablePaging.language.zh_cn,
	            columns : settings.colums,
	            columnDefs : settings.columsdefs
	        };
	        return options;
	    },
	    /**
	     * 获取非ajax不分页options设置
	     */
	    getNotAjaxOptions : function(settings) {
	        var options = {
	            serverSide : false,
	            destroy : true,
	            processing : true,
	            ordering : false,
	            searching : false,
	            paging : false,
	            scrollX : true,
	            info : false,
	            language : DataTablePaging.language.zh_cn,
	            columns : settings.colums,
	            columnDefs : settings.columsdefs
	        };
	        return options;
	    }
	};