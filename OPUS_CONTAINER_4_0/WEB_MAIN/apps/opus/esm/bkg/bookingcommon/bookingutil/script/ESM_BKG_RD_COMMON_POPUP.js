/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_RD_COMMON_POPUP.js
*@FileTitle  : ESM_BKG_RD_COMMON_POPUP
*@author     : CLT
*@version    : 1.0
*@since      : 2016/07/01
=========================================================*/
function rdOpen() {
	var mrdDisableToolbar = document.getElementById("com_mrdDisableToolbar").value;
	
	var mrdPaths = document.getElementsByName("bkg_mrdPath");
	var mrdParameters = document.getElementsByName("bkg_mrdArguments");
	var count = document.getElementById("bkg_mrdCount").value;
	
	var appendReport = [];
	
	if (mrdDisableToolbar !== "" && mrdDisableToolbar !== " " && mrdDisableToolbar !== "undefined" && mrdDisableToolbar !== "null") {
		var arrMrdHideToolbar = mrdDisableToolbar.split(";");
		viewer.hideToolbarItem(arrMrdHideToolbar);
	}
	for (i=0; i < count; i++) {
		appendReport.push({mrdPath:mrdPaths[i].value, mrdParam: mrdParameters[i].value});
	}
	viewer.openFile(appendReport, {timeout:1800});
}