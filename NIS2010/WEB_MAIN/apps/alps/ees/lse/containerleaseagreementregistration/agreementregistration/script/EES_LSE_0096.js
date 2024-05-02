/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0096.js
*@FileTitle : Lease Agreement Version Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.02 노정용
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
     * @author 노정용
     */

    /**
     * @extends 
     * @class ees_lse_0096 : ees_lse_0096 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	function ees_lse_0096() {
    	this.processButtonClick		= processButtonClick;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    	this.obj_keypress           = obj_keypress;
    	this.obj_blur           	= obj_blur;
    	this.obj_focus				= obj_focus;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
	// 공통전역변수
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

        var formObj = document.form;

        try {
        	var srcName = window.event.srcElement.getAttribute("name");

        	switch(srcName) {
        		case "btns_calendar1":
        			var cal = new ComCalendar();
	                cal.select(formObj.new_exp_dt, 'yyyy-MM-dd');
        			break;
        	
        		case "btn_OK":
        			if ( validateForm(formObj) ) {
        				window.returnValue = ComGetObjValue(formObj.new_eff_dt) + "|" + ComGetObjValue(formObj.new_exp_dt)
        				window.close();
        			}
        			break;

        		case "btn_Close":
        			window.close();
        			break;
        	} // end switch
        } catch(e) {
        	if( e == "[object Error]") {
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
		/* Axon Control Setting*/
		initControl();
		
		ComAddSeparator(form.eff_dt, "ymd");
		ComAddSeparator(form.exp_dt, "ymd");
		ComAddSeparator(form.new_eff_dt, "ymd");

		ComSetFocus(document.form.new_exp_dt);
	 }

	//Axon 이벤트 처리1. 이벤트catch
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키보드 입력할때
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	 * 키보드가 눌릴 때
	 **/
	function obj_keypress() {
		var obj = event.srcElement;
		
		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	        	if ( obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet('num');
	        	} else {
	        		ComKeyOnlyAlphabet(); 
	        	}
	            break;
	        case "engup":
	        	ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
	}
	
	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur(){
	    switch(event.srcElement.name){
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(event.srcElement);
	    }
	}
	
	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 **/
	function obj_focus(){
		var obj = event.srcElement;

		if( obj.readOnly ) {
		  	ComSetNextFocus(obj);
		} else {
			//마스크구분자 없애기
			ComClearSeparator(obj);
		}
	}
	//Axon 이벤트 처리2. 이벤트처리함수 --- End

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(formObj) {
		// Effective Date Validation(eff_dt < exp_dt)
		var vEffDt = ComReplaceStr(ComGetObjValue(formObj.new_eff_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.new_exp_dt),"-","");
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01051");
			ComSetObjValue(formObj.new_exp_dt,"");
			ComSetFocus(formObj.new_exp_dt);
			return false;
		}
		
		return true;
	}
	/* 개발자 작업  끝 */