/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0814.js
*@FileTitle : Outbound Container Movement Status by Yard Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.09.10 김기종
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
     */

    /**
     * @extends 
     * @class ESM_BKG_0814 : ESM_BKG_0814 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0814() {
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

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch (srcName) {
	
			case "btn_Close":
				window.close();
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
        frm = document.form;    
    	//RD
    	rdOpen();
    	
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
    		//var rv = "/rv " + frm.rv.value;
    		var rv = "/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]" + frm.rv.value;
    		param = param + " " + rv;
    	}
        
    	if (frm.rpost.value != "") {
    		var rpost = "/rpost " + frm.rpost.value;
    		param = param + " " + rpost;
    	}
    	
    	viewer.openFile(RD_path + frm.mrd.value, param, {timeout:1800});	
    }

	

	/* 개발자 작업  끝 */