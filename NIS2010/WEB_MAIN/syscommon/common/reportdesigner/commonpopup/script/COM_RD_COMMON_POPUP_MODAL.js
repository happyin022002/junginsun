/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : COM_RD_COMMON_POPUP.js
 *@FileTitle : COM_RD_COMMON_POPUP
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.14
 *@LastModifier : 김정훈
 *@LastVersion : 1.0
 * 2009.08.14 김정훈
 * 1.0 Creation
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class COM_RD_COMMON_POPUP : COM_RD_COMMON_POPUP 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function COM_RD_COMMON_POPUP() {
	this.rdOpen = rdOpen;
	this.setModalValues = setModalValues;
}

/**
 * 
 * @return
 */
function rdOpen() {
	var rdObj = document.form.Rdviewer;
	
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
	if(document.getElementById("com_mrdPrintPaperSize") != null){
		var mrdPrintPaperSize = document.getElementById("com_mrdPrintPaperSize").value;
		if(mrdPrintPaperSize != "null" && mrdPrintPaperSize != "" && mrdPrintPaperSize != " " && mrdPrintPaperSize != "undefined" && mrdPrintPaperSize != undefined){
			rdObj.SetPrint2(mrdPrintPaperSize,1,1,100);
		}
 	}
	rdObj.SetAppendReport(1);
	var mrdPaths = document.getElementById("com_mrdPath").value;
	var mrdParameters = document.getElementById("com_mrdArguments").value;
	var arrMrdPaths = mrdPaths.split(";");
	var arrMrdParameters = mrdParameters.split(";");
	
	for (i = 0; i < arrMrdPaths.length; i++) {
		var arrMrdParameter = "";
		if(arrMrdParameters[i] != null){
			arrMrdParameter = arrMrdParameters[i];
		}
		arrMrdParameter = arrMrdParameter + " /rprndlgtype [2]";
		if(arrMrdPaths[i] != "" &&  arrMrdPaths[i] != " "){
			if (arrMrdParameters[i].indexOf("/rfn") != -1 || arrMrdParameters[i].indexOf("/rf") != -1) {
				rdObj.FileOpen(RD_path + mrdPaths[i], arrMrdParameter);
			} else {
				var batchFlag = document.getElementById("com_isBatch").value;
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
	if(win.document.getElementsByName("com_mrdTitle") != null){
		if(win.document.getElementsByName("com_mrdTitle")[0] != null){
			document.title = win.document.getElementsByName("com_mrdTitle")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdBodyTitle") != null){
		if(win.document.getElementsByName("com_mrdBodyTitle")[0] != null){
			document.getElementById("com_mrdBodyTitle").innerHTML = win.document.getElementsByName("com_mrdBodyTitle")[0].value;
		}
	}
	if(win.document.getElementsByName("com_zoomIn") != null){
		if(win.document.getElementsByName("com_zoomIn")[0] != null){
			document.getElementById("com_zoomIn").value = win.document.getElementsByName("com_zoomIn")[0].value;
		}
	}
	if(win.document.getElementsByName("com_isBatch") != null){
		if(win.document.getElementsByName("com_isBatch")[0] != null){
			document.getElementById("com_isBatch").value = win.document.getElementsByName("com_isBatch")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogDir") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogDir")[0] != null){
			document.getElementById("com_mrdSaveDialogDir").value = win.document.getElementsByName("com_mrdSaveDialogDir")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogFileName") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogFileName")[0] != null){
			document.getElementById("com_mrdSaveDialogFileName").value = win.document.getElementsByName("com_mrdSaveDialogFileName")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogFileExt") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogFileExt")[0] != null){
			document.getElementById("com_mrdSaveDialogFileExt").value = win.document.getElementsByName("com_mrdSaveDialogFileExt")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdSaveDialogFileExtLimit") != null){
		if(win.document.getElementsByName("com_mrdSaveDialogFileExtLimit")[0] != null){
			document.getElementById("com_mrdSaveDialogFileExtLimit").value = win.document.getElementsByName("com_mrdSaveDialogFileExtLimit")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdDisableToolbar") != null){
		if(win.document.getElementsByName("com_mrdDisableToolbar")[0] != null){
			document.getElementById("com_mrdDisableToolbar").value = win.document.getElementsByName("com_mrdDisableToolbar")[0].value;
		}
	}
	if(win.document.getElementsByName("com_mrdPrintPaperSize") != null){
		if(win.document.getElementsByName("com_mrdPrintPaperSize")[0] != null){
			document.getElementById("com_mrdPrintPaperSize").value = win.document.getElementsByName("com_mrdPrintPaperSize")[0].value;
		}
	}
	var mrdPaths = win.document.getElementsByName("com_mrdPath");
	var mrdArguments = win.document.getElementsByName("com_mrdArguments");
	var docMrdPaths = "";
	var docMrdArguments = "";
	for(i = 0;i < mrdPaths.length;i++){
		docMrdPaths = docMrdPaths+mrdPaths[i].value+";";
		docMrdArguments = docMrdArguments+mrdArguments[i].value+";";
	}
	document.getElementById("com_mrdPath").value = docMrdPaths;
	document.getElementById("com_mrdArguments").value = docMrdArguments;
}
/* 개발자 작업  끝 */