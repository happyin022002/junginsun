<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		loadPage();		
	}
	
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	document.onclick = processButtonClick;
	
	function processButtonClick(){
	    var formObject = document.form;
	    var rdObject = rdObjects[0];
	}
	
	function loadPage() {
		//RD
		initRdConfig(rdObjects[0]);
		rdOpen(rdObjects[0], document.form);
	}
	
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	
		Rdviewer.AutoAdjust = true;
		//Rdviewer.HideToolbar();
	//	Rdviewer.HideStatusbar();
		Rdviewer.ViewShowMode(0);
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	function rdOpen(rdObject,formObject){
		var rdObj = rdObject ;
		var rdParam = "";
	
		
	    rdObj.AutoAdjust = false;
		rdObj.ZoomRatio = 90;
		rdObj.setbackgroundcolor(255, 255, 255);
		rdObj.setPageScroll(0);
		if (mrdDisableToolbar != "" && mrdDisableToolbar != " " && mrdDisableToolbar != "undefined" && mrdDisableToolbar != "null") {
			for (i = 0; i < document.getElementById("com_zoomIn").value; i++) {
				rdObj.ZoomIn();
			}
		}
	
		var mrdSaveDialogDir = document.getElementById("com_mrdSaveDialogDir").value;
		if (mrdSaveDialogDir == undefined || mrdSaveDialogDir == null || mrdSaveDialogDir == "" || mrdSaveDialogDir == " ") {
			mrdSaveDialogDir = "C:\\";
		}
	
		var mrdSaveDialogFileName = document.getElementById("com_mrdSaveDialogFileName").value;
		if (mrdSaveDialogFileName == "undefined" || mrdSaveDialogFileName == "null" || mrdSaveDialogFileName == "" || mrdSaveDialogFileName == " ") {
			mrdSaveDialogFileName = "default";
		}
	
		var mrdSaveDialogFileExt = document.getElementById("com_mrdSaveDialogFileExt").value;
		var mrdSaveDialogFileExtLimit = document.getElementById("com_mrdSaveDialogFileExtLimit").value;
	
		rdObj.SetSaveDialogEx(mrdSaveDialogDir, mrdSaveDialogFileName, mrdSaveDialogFileExtLimit, mrdSaveDialogFileExt);
	
		var mrdDisableToolbar = document.getElementById("com_mrdDisableToolbar").value;
		if (mrdDisableToolbar != "" && mrdDisableToolbar != " " && mrdDisableToolbar != "undefined" && mrdDisableToolbar != "null") {
			var splitMrdDisableToolbar = mrdDisableToolbar.split(";");
			for (i = 0; i < splitMrdDisableToolbar.length; i++) {
				rdObj.DisableToolbar(splitMrdDisableToolbar[i]);
			}
		}
	
		rdObj.SetRData("");
		rdObj.SetAppendReport(1);
		var mrdPaths = document.getElementsByName("com_mrdPath");
		var mrdParameters = document.getElementsByName("com_mrdArguments");
		
		rdObj.FileOpen(RD_path + formObject.com_mrdPath.value, RDServer + formObject.com_mrdArguments.value);
	
	
	
	   // Rdviewer.FileOpen(RD_path+'sample/rd/usingrdagent/Sample.mrd', RDServer + rdParam);
	}
		
</script>

<html>
<head>
<title><%=request.getParameter("com_mrdTitle") %></title>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	onload="javascript:setupPage();">
<form name="form">
	<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" value="<%=request.getParameter("com_mrdArguments")%>"></input> 
	<input type="hidden" name="com_mrdPath" id="com_mrdPath" value="<%=request.getParameter("com_mrdPath")%>"></input>
	<input type="hidden" id="com_mrdSaveDialogDir" value="<%=request.getParameter("com_mrdSaveDialogDir")%>" />
	<input type="hidden" id="com_mrdSaveDialogFileName" value="<%=request.getParameter("com_mrdSaveDialogFileName")%>" />
	<input type="hidden" id="com_mrdSaveDialogFileExt" value="<%=request.getParameter("com_mrdSaveDialogFileExt")%>" />
	<input type="hidden" id="com_mrdSaveDialogFileExtLimit" value="<%=request.getParameter("com_mrdSaveDialogFileExtLimit")%>" />
	<input type="hidden" id="com_mrdDisableToolbar" value="<%=request.getParameter("com_mrdDisableToolbar")%>" />
	<input type="hidden" id="com_zoomIn" value="<%=request.getParameter("com_zoomIn")%>" />
	<input type="hidden" id="com_isBatch" value="<%=request.getParameter("com_isBatch")%>" />
</form>
<script language="javascript">comRdObject('TestRd');</script>
</body>
</html>