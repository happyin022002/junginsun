/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_RD_COMMON_POPUP.jsp
*@FileTitle  : COM_RD_COMMON_POPUP
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
function rdOpen() {
//	var rdObj = document.form.Rdviewer;
	var rdObj=document.getElementById('Rdviewer');
	rdObj.AutoAdjust=0;
	rdObj.ZoomRatio=90;
	rdObj.SetBackgroundColor(255, 255, 255);
	rdObj.ApplyLicense("0.0.0.0");
	rdObj.SetPageScroll(0);
	if (mrdDisableToolbar != "" && mrdDisableToolbar != " " && mrdDisableToolbar != "undefined" && mrdDisableToolbar != "null") {
		for (i=0; i < document.getElementById("com_zoomIn").value; i++) {
			rdObj.ZoomIn();
		}
	}
	var mrdSaveDialogDir=document.getElementById("com_mrdSaveDialogDir").value;
	if (mrdSaveDialogDir == undefined || mrdSaveDialogDir == null || mrdSaveDialogDir == "" || mrdSaveDialogDir == " ") {
		mrdSaveDialogDir="C:\\";
	}
	var mrdSaveDialogFileName=document.getElementById("com_mrdSaveDialogFileName").value;
	if (mrdSaveDialogFileName == "undefined" || mrdSaveDialogFileName == "null" || mrdSaveDialogFileName == "" || mrdSaveDialogFileName == " ") {
		mrdSaveDialogFileName="default";
	}
	var mrdSaveDialogFileExt=document.getElementById("com_mrdSaveDialogFileExt").value;
	var mrdSaveDialogFileExtLimit=document.getElementById("com_mrdSaveDialogFileExtLimit").value;
	rdObj.SetSaveDialogEx(mrdSaveDialogDir, mrdSaveDialogFileName, mrdSaveDialogFileExtLimit, mrdSaveDialogFileExt);
	var mrdDisableToolbar=document.getElementById("com_mrdDisableToolbar").value;
	if (mrdDisableToolbar != "" && mrdDisableToolbar != " " && mrdDisableToolbar != "undefined" && mrdDisableToolbar != "null") {
		var splitMrdDisableToolbar=mrdDisableToolbar.split(";");
		for (i=0; i < splitMrdDisableToolbar.length; i++) {
			rdObj.DisableToolbar(parseInt(splitMrdDisableToolbar[i]));
		}
	}
	rdObj.SetRData("");
	if(document.getElementById("com_mrdPrintPaperSize") != null){
		var mrdPrintPaperSize=document.getElementById("com_mrdPrintPaperSize").value;
		if(mrdPrintPaperSize != "null" && mrdPrintPaperSize != "" && mrdPrintPaperSize != " " && mrdPrintPaperSize != "undefined" && mrdPrintPaperSize != undefined){
			rdObj.SetPrint2(mrdPrintPaperSize,1,1,100);
		}
 	}
	rdObj.SetAppendReport(1);
	var mrdPaths=document.getElementById("com_mrdPath").value;
	var mrdParameters=document.getElementById("com_mrdArguments").value;
	var arrMrdPaths=mrdPaths.split(";");
	var arrMrdParameters=mrdParameters.split(";");
	for (i=0; i < arrMrdPaths.length; i++) {
		var arrMrdParameter="";
		if(arrMrdParameters[i] != null){
			arrMrdParameter=arrMrdParameters[i];
		}
		arrMrdParameter=arrMrdParameter + " /rprndlgtype [2]";
		if(arrMrdPaths[i] != "" &&  arrMrdPaths[i] != " "){
			if (arrMrdParameters[i].indexOf("/rfn") != -1 || arrMrdParameters[i].indexOf("/rf") != -1) {
				rdObj.FileOpen(RD_path + mrdPaths[i], arrMrdParameter);
			} else {
				var batchFlag=document.getElementById("com_isBatch").value;
				if (batchFlag == "Y") {
					rdObj.FileOpen(RD_path + arrMrdPaths[i], RDServerBAT + " " + arrMrdParameter);
				} else {
					rdObj.FileOpen(RD_path + arrMrdPaths[i], RDServer + " " + arrMrdParameter);
				}
			}
		}
	}
	rdObj.SetAppendReport(0);
}
/**
 * 
 * @return
 */
function setModalValues() {
	var win = window.dialogArguments;
	if (!win) win = window.opener;  //이 코드 추가할것
	if (!win) win = parent; //이 코드 추가할것
	if(win.document.getElementsByName("com_mrdTitle") != null){
		if(win.document.getElementsByName("com_mrdTitle")[0] != null){
			document.title=win.document.getElementsByName("com_mrdTitle")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdBodyTitle") != null){
		if(win.document.getElementsByName("com_mrdBodyTitle")[0] != null){
			document.getElementById("com_mrdBodyTitle").innerHTML=win.document.getElementsByName("com_mrdBodyTitle")[0].value;
		}
	}
	if(win.document.getElementsByName("com_zoomIn") != null){
		if(win.document.getElementsByName("com_zoomIn")[0] != null){
			document.getElementById("com_zoomIn").value=win.document.getElementsByName("com_zoomIn")[0].value;
		}
	}
	if(win.document.getElementsByName("com_isBatch") != null){
		if(win.document.getElementsByName("com_isBatch")[0] != null){
			document.getElementById("com_isBatch").value=win.document.getElementsByName("com_isBatch")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogDir") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogDir")[0] != null){
			document.getElementById("com_mrdSaveDialogDir").value=win.document.getElementsByName("com_mrdSaveDialogDir")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogFileName") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogFileName")[0] != null){
			document.getElementById("com_mrdSaveDialogFileName").value=win.document.getElementsByName("com_mrdSaveDialogFileName")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogFileExt") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogFileExt")[0] != null){
			document.getElementById("com_mrdSaveDialogFileExt").value=win.document.getElementsByName("com_mrdSaveDialogFileExt")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogFileExtLimit") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogFileExtLimit")[0] != null){
			document.getElementById("com_mrdSaveDialogFileExtLimit").value=win.document.getElementsByName("com_mrdSaveDialogFileExtLimit")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdDisableToolbar") != null){
		if(win.document.getElementsByName("com_mrdDisableToolbar")[0] != null){
			document.getElementById("com_mrdDisableToolbar").value=win.document.getElementsByName("com_mrdDisableToolbar")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdPrintPaperSize") != null){
		if(win.document.getElementsByName("com_mrdPrintPaperSize")[0] != null){
			document.getElementById("com_mrdPrintPaperSize").value=win.document.getElementsByName("com_mrdPrintPaperSize")[0].value;
		}
	}
	var mrdPaths=win.document.getElementsByName("com_mrdPath");
	var mrdArguments=win.document.getElementsByName("com_mrdArguments");
	var docMrdPaths="";
	var docMrdArguments="";
	for(i=0;i < mrdPaths.length;i++){
		docMrdPaths=docMrdPaths+mrdPaths[i].value+";";
		docMrdArguments=docMrdArguments+mrdArguments[i].value+";";
	}
	document.getElementById("com_mrdPath").value=docMrdPaths;
	document.getElementById("com_mrdArguments").value=docMrdArguments;
}
/* 개발자 작업  끝 */
