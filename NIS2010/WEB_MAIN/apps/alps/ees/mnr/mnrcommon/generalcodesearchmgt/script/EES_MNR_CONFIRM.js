/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_CONFIRM.js
*@FileTitle : EES_MNR_CONFIRM
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 박명신
*@LastVersion : 1.0 
* 2009.09.04 박명신  
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
     * @extends Mnr   
     * @class ees_mnr_confirm : ees_mnr_confirm 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */ 
    function ees_mnr_confirm() {    
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
	var returnval = "";
	  
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	 
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Row0":
					returnval = "0"; 
					comPopupOK(formObject);
					window.close();
				break;  
				 
				case "btn_Row1":
					returnval = "1"; 
	    			comPopupOK(formObject);
					window.close();
				break;
				
				case "btn_Row2": 
					returnval = "2";   
					comPopupOK(formObject);
					window.close();
				break;
				
				case "btn_Row3":  
					returnval = "3";
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row4":  
					returnval = "4";
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row5": 
					returnval = "5"; 
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row6":  
				    returnval = "6";
					comPopupOK(formObject); 
					window.close();
				break;
				
				case "btn_Row7":
					returnval = "7";
					comPopupOK(formObject);   
					window.close();
				break;	
				
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e); 
			} else {
				ComFuncErrMsg(e); 
			}	
		}
	}
	
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {	 
					  
	}
		
	function comPopupOK(formObject) {  
		opener.getMnr_Confirm(returnval);  //호출하는 부모js에 getMnr_Multi 붙여넣으면됩니다.
		window.close();	 	                 
	}   
	/* 개발자 작업  끝 */ 
