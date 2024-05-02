/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0278.js
 *@FileTitle : Hanjin Shipping Draft B/L Copies
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.12
 *@LastModifier : 나상보
 *@LastVersion : 1.0
 * 2009.08.14 나상보
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
function esm_bkg_1145() {
	this.processButtonClick		= tprocessButtonClick;
	this.rdOpen = rdOpen;
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick()
 {
    var formObject = document.form;
 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) 
		{
			case "btn_Close":
				window.close();
			break;

			} // end switch
 	}catch(e) {
 		if( e == "[object Error]") 
 		{
 			ComShowMessage(OBJECT_ERROR);
 		} else {
 			alert(e);
 		}
 	}
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

	var mrdPaths = document.getElementsByName("com_mrdPath");
	var mrdParameters = document.getElementsByName("com_mrdArguments");
	var bkgNoList = document.getElementsByName("bkgNoList");
	
	var bkgNoList = bkgNoList[0].value.split(",");
	var formObject = document.form;
	for(var i = 0; i <bkgNoList.length -1; i++){
		rdObj.SetAppendReport(1);
		var rdParam = "";
		rdParam =  " /rv";
		rdParam += " form_bkgNo"+"["+bkgNoList[i]+"]";
		rdParam += " form_type[2]";
		rdParam += " form_dataOnly[N]";
		rdParam += " form_manifest[X]";
		rdParam += " form_usrId["+formObject.strUsr_id.value+"]";
		rdParam += " form_hiddeData[N]";
		rdParam += " form_level[(6)]";
		rdParam += " form_remark[]";
		rdParam += " form_Cntr[1]";
		rdParam += " form_mainOnly[N]";
		rdParam += " form_CorrNo[]";
		rdParam += " form_his_cntr[BKG_CONTAINER]";
		rdParam += " form_his_bkg[BKG_BOOKING]";
		rdParam += " form_his_mkd[BKG_BL_MK_DESC]";
		rdParam += " form_his_xpt[BKG_XPT_IMP_LIC]";
		rdParam += " form_his_bl[BKG_BL_DOC]";
		rdParam += " /rp [] /riprnmargin /rwait";
		rdParam += " /rprndlgtype [2]";
		rdObj.FileOpen(RD_path + mrdPaths[0].value, RDServer + rdParam);
	}
	rdObj.SetAppendReport(0);
}
/* 개발자 작업  끝 */