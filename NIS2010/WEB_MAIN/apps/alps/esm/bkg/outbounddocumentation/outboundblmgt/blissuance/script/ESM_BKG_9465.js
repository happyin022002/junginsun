/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_9465.js
 *@FileTitle : B/L Certificate Preview
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.06.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.08.14 
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
function esm_bkg_9465() {
	this.processButtonClick		= tprocessButtonClick;
	this.rdOpen = rdOpen;
	this.doActionIBSheet 		= doActionIBSheet;
}

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
var ret = 1;
if(!opener) opener = window.dialogArguments;
if(!opener){
		mainFormObj = window.dialogArguments.document.form;	  
} else {
try {	  
		mainFormObj = opener.document.form;   
	}catch(e) {
		ComShowCodeMessage("COM12111");
	}		 		        	  
	}
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick()
 {
    var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) 
		{
		
			
			case "btn_reject":
				var stsCd = opener.sheetObjects[0].CellValue(mainFormObj.selectRow.value,"bl_certi_sts_cd");
				
				if(stsCd == "A"){
					ComShowCodeMessage("BKG95084","Certificate","approved");
					return false;
				}else if(stsCd == "X"){
					ComShowCodeMessage("BKG95084","Certificate","rejected");
					return false;
				}
//				funcSetRemark("");
				var paramVal = "?sheet_name=R&pgmNo=ESM_BKG_9459";
	            ComOpenWindowCenter('/hanjin/ESM_BKG_9459.do' + paramVal, 'win4', 600, 270, true);

				break;
				
				
			case "btn_approval":
				var stsCd = opener.sheetObjects[0].CellValue(mainFormObj.selectRow.value,"bl_certi_sts_cd");
				
				if(stsCd == "A"){
					ComShowCodeMessage("BKG95084","Certificate","approved");
					return false;
				}else if(stsCd == "X"){
					ComShowCodeMessage("BKG95084","Certificate","rejected");
					return false;
				}
				doActionIBSheet(opener.sheetObjects[0],mainFormObj, COMMAND01,srcName);
				break;
				
			case "btn_Print":
				document.form.Rdviewer.PrintDialog();
			break;
			
			case "btn_Close":
				if(mainFormObj.ui_id.value=="ESM_BKG_9466"){
					opener.doActionIBSheet(opener.sheetObjects[0],mainFormObj,SEARCH01);
				}else{
					opener.doActionIBSheet(opener.sheetObjects[0],mainFormObj,IBSEARCH,"","");
				}
				
				window.close();
			break;

			
			case "btn_Next":
				var rdObj = document.form.Rdviewer;
				ret = rdObj.NextPage(); //다음 페이지로 이동
//				ret = ret + 1;
				setNextPrev();
//				alert(ret);alert(rdObj.GetTotalPageNo());
//				if(ret == rdObj.GetTotalPageNo()){
//					ComBtnDisable("btn_Next");
//				}
//				if(ret > 1){
//					ComBtnEnable("btn_Previous");
//				}

			break;
			
			case "btn_Previous":
				var rdObj = document.form.Rdviewer;
				ret = rdObj.PrevPage(); //이전 페이지로 이동
//				ret = ret + 1;
				setNextPrev();
//				if(ret == rdObj.GetTotalPageNo()){
//					ComBtnDisable("btn_Next");
//				}
//				if(rdObj.GetTotalPageNo()>1){
//					ComBtnEnable("btn_Next");
//				}else{
//					ComBtnDisable("btn_Next");
//				}PrevPage
//				ComBtnDisable("btn_Previous");

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
//	rdObj.DisableToolbar (1);
	rdObj.SetRData("");
	if(document.getElementById("com_mrdPrintPaperSize") != null){
		var mrdPrintPaperSize = document.getElementById("com_mrdPrintPaperSize").value;
		if(mrdPrintPaperSize != "null" && mrdPrintPaperSize != "" && mrdPrintPaperSize != " " && mrdPrintPaperSize != "undefined" && mrdPrintPaperSize != undefined){
			rdObj.SetPrint2(mrdPrintPaperSize,1,1,100);
		}
 	}

	var mrdPaths = document.getElementsByName("com_mrdPath");
	var mrdParameters = document.getElementsByName("com_mrdArguments");
	var blNoList = document.getElementsByName("blNoList");
	var blNoList = blNoList[0].value.split(",");
	var seqList = document.getElementsByName("seqList");
	var seqList = seqList[0].value.split(",");

	var formObject = document.form;
	for(var i = 0; i <blNoList.length -1; i++){
		rdObj.SetAppendReport(1);
		var rdParam = "";
		rdParam =  " /rv";
		rdParam += " bl_no"+"["+blNoList[i]+"]";
		rdParam += " bl_certi_seq"+"["+seqList[i]+"]";
		rdParam += " /rp [] /riprnmargin";

		rdObj.FileOpen(RD_path + mrdPaths[0].value, RDServer + rdParam);
	}
	rdObj.SetAppendReport(0);
	
	for(var i = 0; i <blNoList.length -1; i++){
		rdObj.SetAppendReport(1);
		var rdParam = "";
		rdParam =  " /rv";
		rdParam += " bl_no"+"["+blNoList[i]+"]";
		rdParam += " bl_certi_seq"+"["+seqList[i]+"]";
		rdParam += " total_page"+"["+rdObj.GetTotalPageNo()+"]";
		rdParam += " /rp [] /riprnmargin";

		rdObj.FileOpen(RD_path + mrdPaths[0].value, RDServer + rdParam);
	}
	rdObj.SetAppendReport(0);
	
	
	
	if(mainFormObj.divFlg.value=="Y"){
		var stsCd = opener.sheetObjects[0].CellValue(mainFormObj.selectRow.value,"bl_certi_sts_cd");
		if(stsCd=="I"||stsCd=="C"){
			ComBtnDisable("btn_approval");
			ComBtnDisable("btn_reject");
		}
		if(stsCd == "X"){
			rdObj.LastPage();
		}
	}

	setNextPrev();

}



//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction,srcName) {
    // sheetObj.ShowDebugMsg = 1;
    switch(sAction) {
  	
	    case COMMAND01: // 입력        
	    	var beforeValue = sheetObj.CellValue(formObj.selectRow.value,"bl_certi_sts_cd");
			if(srcName=="btn_approval"){
				sheetObj.CellValue(formObj.selectRow.value,"bl_certi_sts_cd") = "A";
			}else{
				sheetObj.CellValue(formObj.selectRow.value,"bl_certi_sts_cd") = "X";
			}
			
			var sParam 	= "f_cmd=" + COMMAND01 
			+ "&bl_no=" + sheetObj.CellValue(formObj.selectRow.value,"bl_no")
			+ "&bl_certi_seq=" + sheetObj.CellValue(formObj.selectRow.value,"bl_certi_seq")
			+ "&bl_certi_sts_cd=" + sheetObj.CellValue(formObj.selectRow.value,"bl_certi_sts_cd")
			+ "&rjct_rsn_rmk=" + document.form.rjct_rsn_rmk.value;
			var sXml = sheetObj.GetSaveXml("ESM_BKG_9464GS.do", sParam);
		      // 3.저장후 결과처리
		      var State = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		      if(State == null){
		    	  sheetObj.CellValue(formObj.selectRow.value,"bl_certi_sts_cd") = beforeValue;
		          fnExceptionMessage(sXml);
		      }else{
		    	  if(srcName=="btn_approval"){
		    		  ComShowMessage("Approved successfully.");
		    	  }else{
		    		  ComShowMessage("Rejected successfully.");
		    		  rdOpen();
		    		  
		    	  }
		    	 
		      }
		      break; 

    }
}

function funcSetRemark(remark){
	document.form.rjct_rsn_rmk.value = remark.substring(0,1000);
	doActionIBSheet(opener.sheetObjects[0],mainFormObj, COMMAND01,"btn_reject");
}


function funcPrint(){
	if(mainFormObj.ui_id.value=="ESM_BKG_9466"){
		opener.doActionIBSheet(opener.sheetObjects[0],mainFormObj, COMMAND01);
		ComShowMessage("Printed successfully.");
//		opener.doActionIBSheet(opener.sheetObjects[0],mainFormObj, IBSEARCH);
	}

}

function setNextPrev(){
    
	var rdObj = document.form.Rdviewer;
	var ret = rdObj.CurrentPageNo;
	if(rdObj.GetTotalPageNo()==1){
		ComBtnDisable("btn_Previous");
		ComBtnDisable("btn_Next");

	}else{
		if(rdObj.GetTotalPageNo() == ret){
			ComBtnDisable("btn_Next");
			ComBtnEnable("btn_Previous");
		}else{
			ComBtnEnable("btn_Next");
			if(1 == ret){
				ComBtnDisable("btn_Previous");
			}else{
				ComBtnEnable("btn_Previous");
			}
		}
		
	}

}



/* 개발자 작업  끝 */