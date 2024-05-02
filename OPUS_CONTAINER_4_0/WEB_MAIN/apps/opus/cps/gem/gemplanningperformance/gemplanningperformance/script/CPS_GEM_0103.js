/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_GEM_0103.js
 *@FileTitle : [CPS_GEM_0103] Report Print
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 *  [CPS_GEM_0103] Report Print
 * @extends
 * @class report Print생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_GEM_0103() {
    this.loadPage = loadPage;

}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
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
// 전역변수 추상함수
// ===================================================================================

var rdObjects = new Array();
var rdCnt = 0;
var rd1 = null;
// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 **/
function loadPage() {
    //전역 변수 설정 
    frm = document.form;        
    rd1 = rdObjects[0];
	//RD
	initRdConfig(rd1);
	rdOpen();

}


function initRdConfig(rdObject){
    var Rdviewer = rdObject ;    
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.SetBackgroundColor(128,128,128);
	Rdviewer.SetPageLineColor(128,128,128);
}


function rdOpen(){
	var param = "";
	if (frm.rfn.value != "") {
		var rfn = "/rfn ["+RDServerIP + frm.rfn.value+"]";
		param = rfn;
	}
	
	
	if (frm.rp.value != "") {
		var rp = "/rp " + frm.rp.value;
		param = param + " " + rp;
	}
	
	if (frm.rv.value != "") {
		var rv = "/rv " + frm.rv.value;
		param = param + " " + rv;
	}
    
	if (frm.rpost.value != "") {
		var rpost = "/rpost " + frm.rpost.value;
		param = param + " " + rpost;
	}
	
	rd1.FileOpen(RD_path + frm.mrd.value, param);	
}




