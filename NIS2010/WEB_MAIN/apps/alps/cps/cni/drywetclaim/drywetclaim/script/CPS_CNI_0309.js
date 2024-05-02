/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0309.js
*@FileTitle : Case Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.12 윤세영
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
     * @class CPS_CNI_0309 : CPS_CNI_0309 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function CPS_CNI_0309() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initControl            = initControl;
    }
    
   	/* 개발자 작업	*/


	// 공통전역변수 
	var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

		/*******************************************************/
		var formObject = document.form;
		try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Print":
					//RD Open
					var Rdviewer = rdObjects[0] ;
			
					var rdParam = "/rv form_dw_clm_no[" + formObject.dw_clm_no.value + "]";
			
					var rdFile = 'CPS_CNI_0304.mrd';
			
					// 열고자 하는 RD 파일을 지정한다.
				    Rdviewer.FileOpen(RD_path+'apps/alps/cps/cni/drywetclaim/drywetclaim/report/'+rdFile, RDServer + rdParam);
                    break; 

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. If the problem persists, please contact your system administrator.");
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

        //html컨트롤 이벤트초기화
        initControl();

		//RD
		initRdConfig(rdObjects[0]);
		
		if (form.dw_clm_no.value != '') {
    		var obj = document.getElementById("btn_Print");
    		if (obj) obj.fireEvent("onclick");
		}

    }
	
	/**
     * 페이지에 있는 RD Object를 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
     * @param {rdObject} rdObject    RD Object
     **/
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.style.height = 505;
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}

	/**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl() {
    	
        //Axon 이벤트 처리1. 이벤트catch
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form); 							//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form); 				//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
        
        axon_event.addListener  ('keypress', 'obj_keypress' , form);							//- form 전체 컨트롤 중 keypress 이벤트 발생시
        axon_event.addListener  ('keyup', 'obj_keyup' , "dw_clm_no");							//- Case No.가 모두 입력됐을때 keyup 이벤트 발생시

    }

 	//focus in
 	function obj_activate(){
 		obj = event.srcElement;
 		//readonly 일때 데이터 포맷 변경되는 것  방지
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 

    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){

        ComChkObjValid(event.srcElement);
    	
    }
    
    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){

    	switch(event.srcElement.name){
	        case "dw_clm_no":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }
    
    /**
     * HTML Control의 Case No.가 모두 입력됐을때 조회한다. <br>
     **/
    function obj_keyup(){

    	switch(event.srcElement.name){
	        case "dw_clm_no":
	        	var keyValue = event.keyCode;
	        	//대문자와 숫자인 경우만 실행
	        	if ((keyValue >= 65 && keyValue <= 90) || (keyValue >= 48 && keyValue <= 57) || (keyValue >= 96 && keyValue <= 105)) {
		        	if (event.srcElement.value.trim().length == 11) {
			    		var obj = document.getElementById("btn_Print");
			    		if (obj) obj.fireEvent("onclick");
		        	} 
	        	}
	            break;
    	}
    }

	/* 개발자 작업  끝 */