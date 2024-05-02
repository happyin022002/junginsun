/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4109.js
*@FileTitle : Check the payer Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.31
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2011.03.31 김태균 [CHM-201109784-01] [DMT] Invoice Creation & Issue의 Payer 정보 확인 절차 추가
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
     * @class EES_DMT_4109 : EES_DMT_4109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_DMT_4109() {    
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
	  
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
	
		/*******************************************************/
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Right": 
					document.form.checkValue.value = "R";
					window.close();
				break;  
				 	
				case "btn_Wrong":
					document.form.checkValue.value = "W";
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
        initControl();
	}
	
	/*
	 * 초기화
	 */
	function initControl(){
		var formObj = document.form;
		var opener = window.dialogArguments;

		formObj.payerCode.value = opener.document.form.h_payer_cd.value;
		formObj.payerName.value = opener.document.form.h_payer_nm.value;

		//&nbsp;&nbsp;&nbsp;Payer  :   US123456  -  ABC  Overseas Trading
		document.getElementById('payer').innerHTML 
    		= "&nbsp;&nbsp;&nbsp;Payer : "+formObj.payerCode.value + " - " + formObj.payerName.value;
		
	}
	
    function unLoadPage() {
    	var checkValue = document.form.checkValue.value;
    	if(checkValue == null || checkValue == "")
    	{
    		checkValue = "W";
    	}
		window.returnValue=checkValue;
    }
	
	/* 개발자 작업  끝 */ 
