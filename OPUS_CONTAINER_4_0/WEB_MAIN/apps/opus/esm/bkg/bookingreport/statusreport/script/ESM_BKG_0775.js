/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0775.js
*@FileTitle :  Booking Status Report Result Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.21 김경섭
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
     * @author CLT
     * @extends 
     * @class esm_bkg_0775  생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0775() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    /* 개발자 작업	*/

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
//                         IBROWSEARCH    = 10; // Row 조회     
//                         IBCREATE       = 11; // Create       
//                         IBRESET        = 12; // Reset        
//                         IBBATCH        = 13; // Batch        
 // =============================================================

 // ===================================================================================
 // 전역변수 추상함수
 // ===================================================================================

 var rdObjects = new Array();
 var rdCnt = 0;
 document.onclick=processButtonClick;
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        //전역 변수 설정 
        frm = document.form;    
    	//RD
    	rdOpen();

    	
    }

    function processButtonClick() {
    	var srcName=ComGetEvent("name");
    	switch (srcName) {
    		case "btn_Close":
    			ComClosePopup(); 
    			break;
    	}
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
    		var rv = "/rv " + " NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"] "+ frm.rv.value;
    		param = param + " " + rv;
    	}
        
    	if (frm.rpost.value != "") {
    		var rpost = "/rpost " + frm.rpost.value;
    		param = param + " " + rpost;
    	}
    	
    	viewer.openFile(RD_path + frm.mrd.value, param, {timeout:1800});

    	if(frm.print_type.value == "PRINT"){
    		viewer.print({isServerSide:true});
    	}
    	
    	
    }

	

	/* 개발자 작업  끝 */