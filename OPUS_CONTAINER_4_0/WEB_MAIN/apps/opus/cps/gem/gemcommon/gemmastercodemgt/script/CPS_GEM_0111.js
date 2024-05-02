/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0111.jsp
 *@FileTitle : [CPS_GAE-0111] Monthly Accounting Rate Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
=========================================================*/


/**
 * [CPS_GEM_0111] Monthly Accounting Rate Interface
 * @extends
 * @class Foreign Exchange Rate Maintenance생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0111() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
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

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var curMonth = "";
// html form
var frm = null;


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
 * @param {string} month 현재년월
 **/
function loadPage(month) {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {        
        initSheet(sheetObjects[i],i+1);                      
    }
    
          
    //현재년도 설정    
    var acct_xch_rt_yrmon = frm.acct_xch_rt_yrmon;    
    if (acct_xch_rt_yrmon.value == "") {
        acct_xch_rt_yrmon.value = month;
    }  
    
    curMonth = month;
    
    //Form 이벤트 등록
    initControl();
  
}



/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1":
            if (location.hostname != "") {
            	InitHostInfo(location.hostname, location.port, page_path);
            }
			break;
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================
 /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
 function validateForm(sheetObj,formObj,sAction){
     return true;
 }


// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {	
	case "btn1_Confirm":		
		//GEM00014	ENG	I	Do you want to execute?
		ComShowCodeMessage("GEM00014");
		doActionIBSheet(IBINSERT);		
		break;
	case "btn1_Reset":
		frm.acct_xch_rt_yrmon.value = curMonth;
		break;
	case "btn1_Close":		
		self.close();	
		break;
	case "btns_calendar":
		var cal = new ComCalendar();
		cal.setDisplayType('month');
		cal.select(frm.acct_xch_rt_yrmon, 'yyyy-MM');
		break;
	}

}


/**
 * Form 이벤트 등록
 */
function initControl() {
    //keypress
    axon_event.addListenerForm('keypress', 'obj_keypress', frm);
    // focus in
    axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
    // focus out
    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}

/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
    switch (event.srcElement.name) {    
    case "acct_xch_rt_yrmon":
		ComKeyOnlyNumber(event.srcElement);
		break;    
	}
}

 
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {
	var frm = document.form;
	switch (event.srcElement.name) {
	case "acct_xch_rt_yrmon":
		ComChkObjValid(event.srcElement);
		break;
	}
}


/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}


// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {	
	if (sAction == IBINSERT) {	
		frm.f_cmd.value = ADD;		
		if(ComChkValid(frm)) {
			sheet1.WaitImageVisible = false; 
			ComOpenWait(true);			
			var sXml = sheet1.GetSearchXml("CPS_GEM_0111GS.do", FormQueryString(frm));
			sheet1.LoadSearchXml(sXml);
			ComOpenWait(false);
			
		}
	}  
 
}

