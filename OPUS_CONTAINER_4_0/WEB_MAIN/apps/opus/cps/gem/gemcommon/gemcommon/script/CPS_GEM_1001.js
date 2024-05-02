/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_GEM_0101.js
 *@FileTitle : [CPS_GEM_0101] Authorized Expense Code
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM_0101] Note Popup
 * @extends
 * @class Note Popup생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_GEM_0102() {
    this.processButtonClick = processButtonClick;
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

// html form
var frm = null;
var frm2 = null;
//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}


// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 **/
function loadPage(mode) {

    //전역 변수 설정 
    frm = document.form;
    frm2= document.form2;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;   
    
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
    initControl();
}


/**
* 시트 초기설정값, 헤더 정의
* @param {ibsheet} sheetObj  sheet
* @param {int} sheetNo 시트번호
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
    	    //Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		          break;		
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================


// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

 function initControl() {
 	var formObject = document.form;
     //Axon 이벤트 처리1. 이벤트catch(개발자변경)
     axon_event.addListenerFormat('keypress', 'keypressFormat', formObject);    
 }

//업무 자바스크립트 OnKeyPress 이벤트 처리
 function keypressFormat() {
 	obj = event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus = obj.dataformat;
    switch(ComGetEvent("name")) {
        case "rslt_yrmon":
        	ComKeyOnlyNumber(obj);
        	break;
        case "from_ofc_cd":        	
        case "to_ofc_cd":
        case "gen_expn_cd":
        	//ComKeyOnlyAlphabet('uppernum');
            break;            
    }
 }
     
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
		case "btn1_Save01":			
			//if (ComChkValid(frm)) {				
				doActionIBSheet(MULTI01);
			//}
			break;
		case "btn1_Save02":		
			doActionIBSheet(MULTI02);
			break;
	} 
}

/**
* 업무 처리 이벤트
* @param {string} sAction 액션타입 
*/
function doActionIBSheet(sAction) {	
	if (sAction == MULTI01) {
		frm.f_cmd.value = MULTI01;		
		var sXml = sheet1.GetSearchXml("CPS_GEM_1001GS.do", FormQueryString(frm));
		var cnt = ComGetEtcData(sXml ,"cnt");
		alert("실행건수:" + cnt );
	} else if (sAction == MULTI02) {
		frm2.f_cmd.value = MULTI02;		
		alert(FormQueryString(frm2));
		var sXml = sheet1.GetSearchXml("CPS_GEM_1001GS.do", FormQueryString(frm2));
		var cnt = ComGetEtcData(sXml ,"cnt");
		alert("실행건수:" + cnt );		
	}
}

