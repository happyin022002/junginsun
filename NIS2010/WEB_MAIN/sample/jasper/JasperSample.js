searchAJAX = function() {
	jq('#main-grid').trigger('reloadGrid');
	jq("#main-grid").jqGrid({
		url:'/hanjin/JasperSampleGS.do',
		datatype: 'json',
		mtype:'POST',
		postData:{
			f_cmd:SEARCH,
			pgm_no:function() {
				var pgmNo = document.getElementById('pgm_no').value;
				if (pgmNo == null) {
					pgmNo = '';
				}
				return pgmNo;
			}
		},
		colNames:['Pgm. No.', 'Name', 'URL'],
		colModel:[
			    {name:'pgmNo',index:'pgmNo', width:30, editable:false,editoptions:{readonly:true,size:10}},
				{name:'pgmNm',index:'pgmNm', width:70, editable:false,editoptions:{readonly:true,size:10}},
				{name:'pgmUrl',index:'pgmUrl', width:200, editable:false,editoptions:{readonly:true,size:10}}
			],
		rowNum: 20,
		autowidth: true,
		height: 500,
		rowList: [10, 20, 50, 100],
		pager: '#pager',
		viewrecords: true,
		loadonce: false,
		jsonReader: {
			root: "rows",
			page: "currentPage",
			total: "totalPage",
			records: "count",
			repeatitems: false,
			id: "pgmNo"
		},
		caption:"Batch Programs",
		emptyrecords: "Empty Records"
	});
	jq("#grid").jqGrid('navGrid','#pager',
		{edit:false,add:false,del:false,search:false,refresh:true},
			{ },
			{ },
			{ },
			{ }
	);
}

function searchXML() {
	document.form.action = "/hanjin/JasperSampleGS.do";  
	document.form.f_cmd.value = SEARCH;
	document.form.target = "jaspergrid";
	document.form.submit();
}

function searchJSON() {
	document.form.action = "/hanjin/JasperSampleGS_JSON.do";  
	document.form.f_cmd.value = SEARCH;
	document.form.target = "jaspergrid";
	document.form.submit();
}
		
function exportVOS() {
	document.form.action = "/hanjin/JasperExportGS.do";
	document.form.f_cmd.value = COMMAND01;
	document.form.submit();
}
		
function exportRowset() {
	document.form.action = "/hanjin/JasperExportGS.do";
	document.form.f_cmd.value = COMMAND02;
	document.form.submit();
}

