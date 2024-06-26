/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_9999.jsp
*@FileTitle  : [CPS_CNI_9999] Rd View 공통 파일
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
/**
 *  [CPS_CNI_9999] Report Print
 * @extends
 * @class report Print생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // initializing       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// common global variables
// ===================================================================================
var rdObjects=new Array();
var rdCnt=0;
var rd1=null;
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
    rd1=rdObjects[0];
	//RD
	initRdConfig(rd1);
	rdOpen();
}
//Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {
		case "btn_Close":
			ComClosePopup(); 
			break;
	}
} 
function initRdConfig(rdObject){
//    var Rdviewer=rdObject ;    
//	Rdviewer.AutoAdjust=true;
//	Rdviewer.ViewShowMode(0);
//	Rdviewer.SetBackgroundColor(128,128,128);
//	Rdviewer.SetPageLineColor(128,128,128);
//	Rdviewer.ApplyLicense("0.0.0.0");	
}
function rdOpen(){
	//riprnmargin 프린트 마진을 자동 조정
	var param=frm.param.value + " /riprnmargin" ;
	viewer.openFile(RD_path + frm.mrd.value, param, {timeout:1800});	
}
