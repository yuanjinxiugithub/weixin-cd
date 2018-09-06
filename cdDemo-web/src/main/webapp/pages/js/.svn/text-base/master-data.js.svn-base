var setting = {
		view: {
			dblClickExpand: false,
			showLine: false,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				if (treeNode.isParent) {
					zTree.expandNode(treeNode);
					return false;
				} else {
					demoIframe.attr("src",treeNode.file + ".html");
					return true;
				}
			}
		}
	};
	
	var zNodes =[
		{ id:1, pId:0, name:"武汉纺织大学", open:true},
		{ id:101, pId:1, name:"学院分类",open:true},
		{ id:10101, pId:101, name:"学院档案",file:"master-data/istr"},
		{ id:102, pId:1, name:"班级分类"},
		{ id:10201, pId:102, name:"班级档案",file:"master-data/class"},
		{ id:103, pId:1, name:"教师分类"},
		{ id:10301, pId:103, name:"教师档案",file:"master-data/teacher"},
		{ id:104, pId:1, name:"学生分类"},
		{ id:10401, pId:104, name:"学生档案",file:"master-data/student"},
		{ id:105, pId:1, name:"课程分类"},
		{ id:10501, pId:105, name:"必修课档案",file:"master-data/course"},
		{ id:10503, pId:105, name:"教学时间段",file:"master-data/courseTime"},
		{ id:10502, pId:105, name:"排课表",file:"master-data/timeTable"},
		{ id:106, pId:1, name:"教室分类"},
		{ id:10601, pId:106, name:"教室档案",file:"master-data/classroom"},
	];
			
	var code;
			
	$(document).ready(function(){
		var t = $("#treeDemo");
		t = $.fn.zTree.init(t, setting, zNodes);
		demoIframe = $("#testIframe");
		var zTree = $.fn.zTree.getZTreeObj("tree");
	});