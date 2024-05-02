/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_4022.js
*@FileTitle : Sales Rep Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
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
     * @class ESM_PRI_4022 : ESM_PRI_4022 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_4022() {
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
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1; 
	
    var sheetObjects = new Array();
    var sheetCnt = 0;
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
	
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
	
    	/*******************************************************/
    	var formObject = document.form;
	
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
	
    		switch(srcName) {
	
    			case "btn_retrieve":
    				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    				break;
    				
    			case "btn_downexcel":
					sheetObjects[0].Down2Excel();
                    break;
	                         
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
	
    /**
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function loadPage() {
    	for (i = 0; i < sheetObjects.length; i++) {
 			// khlee-시작 환경 설정 함수 이름 변경
 			ComConfigSheet(sheetObjects[i]);
 	
 			initSheet(sheetObjects[i], i + 1);
 			// khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}
    	
    	pageOnLoadFinish();
    }
	
 	/**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function pageOnLoadFinish() {
    	initControl();
    }
    
    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function initSheet(sheetObj,sheetNo) {
    	
    	var cnt = 0;
    	var sheetId = sheetObj.id;
    	
    	switch(sheetId) {
    	
    		case "sheet1":
    			with (sheetObj) {
    				// 높이 설정
    				style.height = 462;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
	
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;
	
    				//전체Edit 허용 여부 [선택, Default false]
    				Editable = false;
	
    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo(1, 1, 15, 100);
	
    				var HeadTitle1 = "Seq.|Code|Description|Office|Phone|Email";
	
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(6, 0, 0, true);
	
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false, false)
	
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle1, true);
	
    				//데이터속성    [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtSeq,	100,daCenter,	true,	"seq",		false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,	150,daCenter,	true,	"srep_cd",	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,	300,daLeft,		true,	"srep_nm",	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"ofc_cd",	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,	100,	daCenter,	true,	"mphn_no",	false,	"",	dfNone);
    				InitDataProperty(0, cnt++ , dtData,	200,	daCenter,	true,	"srep_eml",	false,	"",	dfNone);

    				AutoRowHeight = false;
    				WaitImageVisible = false;
    			}
	 			break;
    	}
    }
     
    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.08.18
	 **/
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "/";

 		axon_event.addListenerForm('keypress', 'obj_keypress', form);
 		axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
 	}
 	
 	/**
     * OnKeyPress시 호출되는 function <br>
     * HTML Control의 onkeypress 이벤트에서 해당 key만 입력되게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
 	function obj_keypress() {
 		 switch (event.srcElement.name) {
 		 
 			case "srep_cd":
 				ComKeyOnlyAlphabet('uppernum');
 				break;
 			
 			case "ofc_cd":
 				ComKeyOnlyAlphabet('upper');
 				break;
 		}
 	}
 	 
 	/**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 김재연
     * @version 2009.08.18
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    	
    		case IBSEARCH:      //조회
    			ComOpenWait(true);
    			if (!validateForm(sheetObj, formObj, sAction)) {
    				ComOpenWait(false);
    				return false;
	      		}
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_4022GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 김재연
     * @version 2009.08.18
     */
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
 	 		case IBSEARCH:
 	 			if(!ComIsNull(formObj.srep_cd.value) && formObj.srep_cd.value.length < 2) {
 	 				ComShowCodeMessage('PRI04004', 'Sales Rep. Code', '2', '5');
 	 				formObj.srep_cd.focus();
 	 				return false;
 	 			}
 	 			
 	 			if(!ComIsNull(formObj.ofc_cd.value) && formObj.ofc_cd.value.length < 2) {
 	 				ComShowCodeMessage('PRI04004', 'Office Code', '2', '5');
 	 				formObj.ofc_cd.focus();
 	 				return false;
 	 			}
 	 			return true;
 	 		break;
 	 }
     return true;
    }
	/* 개발자 작업  끝 */