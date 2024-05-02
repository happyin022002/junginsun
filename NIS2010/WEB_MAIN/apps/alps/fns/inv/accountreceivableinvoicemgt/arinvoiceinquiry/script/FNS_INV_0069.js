/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0069.js
*@FileTitle : (India)Inquiry for GST Collected in Other Offices
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.08.10 박정진
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
	 * @class FNS_INV_0069 : FNS_INV_0069 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0069() {
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
	//IBMultiCombo
	var comboObjects = new Array();
	var combo1 = null;
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/** 
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var cal = new ComCalendar();
			
			switch(srcName) {
				case "btns_calendar1": //달력버튼
					cal.setDisplayType('date');
					cal.select(formObject.from_date, 'yyyy-MM-dd');
					break;
				
				case "btns_calendar2": //달력버튼
					cal.setDisplayType('date');
					cal.select(formObject.to_date, 'yyyy-MM-dd');
					break;
					
				case "btn_retrive":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
					
				case "btn_new":
					removeAll(formObject);
					break;
					
				case "btn_downExcel":
					//sheetObject.Down2Excel();
					sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "ibflag");
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
	 * IBSheet Object를 sheetObjects 배열로 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param  {IBSheet} sheetObj IBSheet Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
    /** 
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * <br><b>Example :</b>
	 * <pre>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function loadPage() {
		sheet1 = sheetObjects[0];
		sheetCnt = sheetObjects.length ;
		
		// combo
		combo1 = comboObjects[1];
		comboCnt = comboObjects.length;
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
	}

	/** 
	 * 시트 초기설정값, 헤더 정의<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * </pre>
	 * @param sheetObj 시트오브젝트
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 380;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "|RHQ|Office|CUST Code|Cust Name|B/L No.|BKG No.|VVD|Good Date|S/A Date|IF Date|IF No.|POL|POD|SRC CUR|SRC AMT|USD AMT|INR AMT";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false,false)
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					var rowCnt = 0;
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(rowCnt, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
					InitDataProperty(rowCnt, cnt++ , dtData,    		60,		daCenter,	true,		"ar_hd_qtr_ofc_cd",	false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,    		60,		daCenter,	true,		"ar_ofc_cd",		false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			80,		daCenter,	true,		"cust_code",		false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			260,	daLeft,		true,		"cust_lgl_eng_nm",	false,          "",      dfNone);
					
					InitDataProperty(rowCnt, cnt++ , dtData,			95,		daCenter,	true,		"bl_src_no",		false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			95,		daCenter,	true,		"bkg_no",			false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			75,		daCenter,	true,		"vvd",				false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			70,		daCenter,	true,		"bl_inv_cfm_dt",			false,          "",      dfDateYmd);
					InitDataProperty(rowCnt, cnt++ , dtData,			70,		daCenter,	true,		"sail_arr_dt",		false,          "",      dfDateYmd);
					InitDataProperty(rowCnt, cnt++ , dtData,			70,		daCenter,	true,		"bl_inv_if_dt",		false,          "",      dfDateYmd);
					
					InitDataProperty(rowCnt, cnt++ , dtData,			85,		daCenter,	true,		"ar_if_no",			false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			60,		daCenter,	true,		"pol_cd",			false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			60,		daCenter,	true,		"pod_cd",			false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			65,		daCenter,	true,		"curr_cd",			false,          "",      dfNone);
					InitDataProperty(rowCnt, cnt++ , dtData,			120,	daRight,	true,		"chg_amt",			false,          "",      dfFloat,         2);
					
					InitDataProperty(rowCnt, cnt++ , dtData,			120,	daRight,	true,		"usd_amt",			false,          "",      dfFloat,         2);
					InitDataProperty(rowCnt, cnt++ , dtData,			120,	daRight,	true,		"inr_amt",			false,          "",      dfFloat,         2);
				}
				break;
		}
	}
	
	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
  	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "ar_hd_qtr_ofc_cd":
				with (comboObj) {
					SetColAlign("left");
	                SetColWidth("50");
	                //SetTitle("Office Code");
					MultiSelect = false;
					UseAutoComplete = true;
					DropHeight = 200;
					ValidChar(2,1);
					MaxLength = 6;
				}
				break;
		}
  	}

	/** 
	 * onLoad 이벤트핸들러시 호출 오브젝트에 대한 이벤트<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function initControl() {
		var formObj = document.form;
		//Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'obj_keypress', formObj);
		axon_event.addListenerFormat ('beforeactivate', 'obj_activate', formObj);
		axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate', formObj);
		axon_event.addListenerForm ('focusout', 'obj_focusout', formObj);
		axon_event.addListenerForm ('keyup', 'obj_keyup', formObj);
	}

	/** 
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 (키보드가 눌릴 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function obj_keypress() {
		switch(event.srcElement.dataformat){
			case "float":
				//숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;
			case "int":
				//숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "engup":
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('upper'); 
			break;              
			default:
				//숫자만입력하기
				ComKeyOnlyNumber(event.srcElement);
			break;
		}
	}

	/** 
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 (포커스가 들어갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function obj_activate() {
		//마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
		event.srcElement.select();
	}

	/** 
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function obj_deactivate(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "from_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			case "to_date":
				//입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
		}
	}
	
	/** 
	 * 업무 자바스크립트 OnFocusOut 이벤트 처리 (포커스가 나갈 때)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function obj_focusout() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		switch(event.srcElement.name){
			case "to_date":
				//조회기간 입력값 체크(1달)
				var nextDate = ComGetDateAdd(formObject.from_date.value, "M", 1);
				
				if (ComReplaceStr(formObject.to_date.value,"-","") >= ComReplaceStr(nextDate,"-","")) {
					ComShowCodeMessage("INV00043");
					formObject.to_date.focus();
				}		
			break;
	    }
	}

	/** 
	 * HTML Control KeyUp 이벤트 호출<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function obj_keyup() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "from_date":
				var fromDt = ComReplaceStr(event.srcElement.value,"-","");
				
				if (fromDt.length == 8) {
					formObject.to_date.focus();
				}
	 		break;
	 	}
	}
  	
	/** 
	 * 조회 저장등 서버 기능을 호출하는 doActionIBSheet<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @param  {int} Row : sheet에서 현재 마우스로 선택되어 있는 Row
	 * @param  {int} Col : sheet에서 현재 마우스로 선택되어 있는 Col
	 * @param  {String}Val : sheet에서 현재 마우스로 선택되어 있는 Row,Col 의 value값
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function doActionIBSheet(sheetObj,formObj,sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;

					var arrStr2 = formObj.ar_hd_qtr_ofc_cd.Code;
	     			formObj.rhq.value = arrStr2;
	     			
                    formObj.usd_total.value = "";
                    formObj.inr_total.value = "";
	     			
	     			sheetObj.DoSearch("FNS_INV_0069GS.do", FormQueryString(formObj));
				}
			break;
			
			case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
				formObj.f_cmd.value = SEARCH01;
 				var sXml = sheetObj.GetSearchXml("FNS_INV_0069GS.do", FormQueryString(formObj));
		
 				var sStr = ComGetEtcData(sXml,"ar_hd_qtr_ofc_cd");
 				var arrStr = sStr.split("|");
		
 				MakeComboObject(formObj.ar_hd_qtr_ofc_cd, arrStr);
 			break;
 			
		}
	}

    /** 
	 * OnLoadFinish 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object        
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.08.10
     */  	
	function sheet_OnLoadFinish(sheetObj){
		var formObj = document.form;
		
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC10);
		
		initControl();
		
		formObj.from_date.focus();
	}
	
	/**
	 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @see #
     * @author 박정진
     * @version 2009.08.10
	 */
	function sheet_OnSearchEnd(sheetObj, errMsg){
		var formObject = document.form;
		var usdTotal = 0;
		var inrTotal = 0;
		
		if(sheetObj.RowCount > 0) {
			var sSaveName = "";
			for(i = 1 ; i < sheetObj.Rows; i++){
				usdTotal = parseFloat(usdTotal) + parseFloat(sheetObj.CellValue(i, "usd_amt"));
				inrTotal = parseFloat(inrTotal) + parseFloat(sheetObj.CellValue(i, "inr_amt"));
			}
		}
		
		formObject.usd_total.value = ComAddComma(ComRound(usdTotal,2));
		formObject.inr_total.value = ComAddComma(ComRound(inrTotal,2));
	}
	
	/** 
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} sheetObj : 시트오브젝트  
	 * @param  {object} formObj : 폼 오브젝트
	 * @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
	 * @return true, false
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function validateForm(sheetObj,formObj,sAction){
		 with(formObj){
			 if((from_date.value == "") && (to_date.value == "")) {          		 
				 ComShowCodeMessage("INV00004");
				 from_date.focus();
				 return false;
			 }
			 var nextDate = ComGetDateAdd(from_date.value, "M", 1);
			 if (to_date.value >= nextDate) {
				 ComShowCodeMessage("INV00043");
				 to_date.focus();
				 return false;
			 }
		 }
		 return true;
	}

	/** 
	 * 화면 초기화<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {object} formObj  
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function removeAll(formObj) {
		formObj.reset();
		
		sheetObjects[0].RemoveAll();
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC10);
		
		formObj.from_date.focus();
	}
	
	/** 
	 * office code select box <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj  
	 * @param  {Array} arrStr
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.08.10
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		
		for (var i = 1; i < arrStr.length;i++ ) {
			var ar_hd_qtr_ofc_cd = '';
			if (arrStr[i] != '') {
				ar_hd_qtr_ofc_cd = arrStr[i];
			}
			cmbObj.InsertItem(i-1, ar_hd_qtr_ofc_cd, ar_hd_qtr_ofc_cd);
		}
		
		cmbObj.Code = arrStr[1];
		cmbObj.BackColor = "#CCFFFD";
	}


	/* 개발자 작업  끝 */