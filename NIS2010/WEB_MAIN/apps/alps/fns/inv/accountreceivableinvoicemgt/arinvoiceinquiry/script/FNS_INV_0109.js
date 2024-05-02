/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0109.js
*@FileTitle : Invoice Search (Pop-Up) _Vietnam
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.27 박정진
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
	 * @class FNS_INV_0109 : FNS_INV_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function FNS_INV_0109() {
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
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
				case "btn_new":
					initField();
					sheetObject.RemoveAll();
				break;
				
				case "btn_apply":
					callParent();
				break;
				
				case "btn_close":
					window.close();
				break;
				
				case "btns_calendar1":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.iss_fm_dt, 'yyyy-MM-dd');
				break;
				
				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.setDisplayType('date');
	             	cal.select(formObject.iss_to_dt, 'yyyy-MM-dd');
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
	 * @version 2009.10.19
	 */
	function setSheetObject(sheetObj){
		sheetObjects[sheetCnt++] = sheetObj;
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
	 * @version 2009.10.19
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
	 * @version 2009.10.19
	 */
	function loadPage() {
		var formObj = document.form;
		
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
		
		initControl();
		
		formObj.iss_fm_dt.focus();
		
		if (document.form.sel_option.value == "M") {
        	ComBtnDisable("btn_apply");    
        } 
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
	 * @version 2009.10.19
	 */
	function initField() {
		var formObj = document.form;
		
		with(formObj){
			iss_fm_dt.value = "";
			iss_to_dt.value = "";
			cust_cnt_cd.value = "";
			cust_seq.value = "";
			cust_nm.value = "";
			usr_id.value = "";
			bl_src_no.value = "";
			inv_no.value = "";
			act_inv_no.value = "";
			
			inv_type.Code = " ";
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
	 * @version 2009.10.19
	 */
	function initControl() {
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'objKeypress', document.form);
		axon_event.addListenerFormat ('beforeactivate', 'objActivate', document.form);
		axon_event.addListenerForm ('beforedeactivate', 'objDeactivate', document.form);
		axon_event.addListenerForm ('keyup', 'objKeyup', document.form);
	}

	/** 
	 * 업무 자바스크립트 OnKeUp 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function objKeyup() {
		var formObject = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		if (srcName == "cust_cnt_cd" ) {
			var v_cust_cnt_cd = formObject.cust_cnt_cd.value
			if (v_cust_cnt_cd.length == 2) {
				formObject.cust_seq.focus();
			}
		}
		if (srcName == "iss_fm_dt" ) {
			var v_iss_fm_dt = formObject.iss_fm_dt.value
			if (v_iss_fm_dt.length == 8) {
				formObject.iss_to_dt.focus();
			}
		}
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
	 * @version 2009.10.19
	 */
	function objKeypress() {
		switch(event.srcElement.dataformat){
			case "float":
				// 숫자+"."입력하기
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;
		
			case "int":
				// 숫자만 입력하기
				ComKeyOnlyNumber(event.srcElement); 
			break;
		
			case "engup":
				switch(event.srcElement.name){
					case "bl_src_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					case "inv_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					case "act_inv_no":
						//영문대문자+숫자입력하기
						ComKeyOnlyAlphabet('uppernum');
					break;
					case "cust_cnt_cd":
						//영문대문자만입력하기
						ComKeyOnlyAlphabet('upper');
					break;
				}
			break;
			
			case "eng":
				switch(event.srcElement.name){
					case "usr_id":
						//영문+숫자입력하기
						ComKeyOnlyAlphabet('num');
					break;
				}
			break;
			
	        case "num":
	        	//숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber('num');
            break;
			
			default:
				// 숫자만입력하기
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
	 * @version 2009.10.19
	 */
	function objActivate() {
		// 마스크 구분자 없애기
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
	 * @version 2009.10.19
	 */
	function objDeactivate(){
		var formObject = document.form;
		var sheetObject = sheetObjects[0];
		switch(event.srcElement.name){
			case "iss_fm_dt":
				// 입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
		
			case "iss_to_dt":
				// 입력Validation 확인 및 마스킹 처리
				ComChkObjValid(event.srcElement);
			break;
		
			case "cust_seq":
				if (formObject.cust_seq.value != '') {
					var valueCustSeq = formObject.cust_seq.value;
					formObject.cust_seq.value = ComLpad(valueCustSeq,6,"0");
				}
				
				if (formObject.cust_cnt_cd.value != '' && formObject.cust_seq.value != '') {
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
				}
				else {
					formObject.cust_nm.value = '';
				}
			break;
		
			default:
				//Validation 전체 체크(길이,format,최대,최소 등등)
				ComChkObjValid(event.srcElement);
			break;
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
	 * @version 2009.10.19
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
	
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 160;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
				
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
				
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
				
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
				
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(9, 0, 0, true);
				
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);
				
					var HeadTitle = "Sel.|B/L No.|INV No.|Act. Inv No|Inv Type|Actual Cust.|Issue Date|Local Amount|User ID";
					
				
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				
					//데이터속성         [ROW,    COL,  		DATATYPE,     WIDTH, 	DATAALIGN, COLMERGE, 	SAVENAME,  	  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,		cnt++,		dtCheckBox,		40,		daCenter,	true,		"SelChk",		false,		"");
					InitDataProperty(0,		cnt++,		dtData,			95,		daCenter,	true,		"bl_src_no",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			90,		daCenter,	true,		"inv_no",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			85,		daCenter,	true,		"act_inv_no",	false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			70,		daCenter,	true,		"inv_type",		false,		"",		dfNone,			0,		false,		false);
					
					InitDataProperty(0,		cnt++,		dtData,			85,		daCenter,	true,		"customer",		false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			80,		daCenter,	true,		"iss_dt",		false,		"",		dfDateYmd,		0,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			110,	daRight,	true,		"lcl_amt",		false,		"",		dfNullFloat,	2,		false,		false);
					InitDataProperty(0,		cnt++,		dtData,			65,		daCenter,	true,		"cre_usr_id",	false,		"",		dfNone,			0,		false,		false);
				}
			break;
		}
	}
	
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.10.19
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
			case "inv_type":		//업체명 
				with (comboObj) {
					InsertItem(0, "ALL",	" ");
					InsertItem(1, "FRT",	"F");
		            InsertItem(2, "THC",	"T");
		            InsertItem(3, "DHF",	"H");
		            InsertItem(4, "DMR",	"D");
		            InsertItem(5, "M&R",	"R");
		            InsertItem(6, "MRI",	"M");
		            InsertItem(7, "SLF",	"S");
		            InsertItem(8, "CLN",	"C");
		            
		    		MultiSelect = true;
		    		UseCode = true;

		    		SetColAlign("left");
		    		MultiSeparator = ",";
		    		DropHeight = 190;
		    		CheckCode("") = true;
		    		
		    		comboObj.text = "ALL";
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
	 * @version 2009.10.19
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("FNS_INV_0109GS.do", FormQueryString(formObj));
				}
			break;
		
			case IBSEARCH_ASYNC20: // customer name 조회
				if (formObj.cust_cnt_cd.value != "" && formObj.cust_seq.value != ""){
					formObj.f_cmd.value = SEARCH03;
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
				
					var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");
					if (cust_nm != undefined) {
						formObj.cust_nm.value = cust_nm;
					} else {
						formObj.cust_nm.value = "";
					}
				}
			break;
		}
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
	 * @version 2009.10.19
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(bl_src_no.value == "") {
				if(iss_fm_dt.value == "" || iss_to_dt.value == "") {
					ComShowCodeMessage("INV00004");
					if(iss_fm_dt.value == "") {
						iss_fm_dt.focus();
					}
					else {
						iss_to_dt.focus();
					}
				
					return false;
				}
				else {
					if (ComGetDaysBetween(iss_fm_dt.value,iss_to_dt.value) < 0) {
						ComShowCodeMessage("INV00043");
						iss_to_dt.focus();
						return false;
					}
					else {
						//조회기간 입력값 체크(1달)
						var nextDate = ComGetDateAdd(iss_fm_dt.value, "M", 1);
					
						if (iss_to_dt.value >= nextDate) {
							ComShowCodeMessage("INV00043");
							iss_to_dt.focus();
							return false;
						}
					}
				}
			}
		}
	
		return true;
	}
	
	/** 
	 * rev_src_cd 콤보박스의 값이 변경된 경우 선택된 값을 변경한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {IBMultiCombo} comboObj
	 * @param {object} s_index
	 * @param {object} s_code
	 * @return 없음
	 * @see #
	 * @author 박정진
	 * @version 2009.12.01
	 */
	function inv_type_OnCheckClick(comboObj, s_index, s_code) {
		//alert(comboObj+":"+s_index+":"+s_code);
		if(s_code == " "){
			if(comboObj.CheckCode(" ") == true){
				comboObj.CheckCode("F") = false;
		        comboObj.CheckCode("T") = false;
		        comboObj.CheckCode("H") = false;
		        comboObj.CheckCode("D") = false;
		        comboObj.CheckCode("R") = false;
		        comboObj.CheckCode("M") = false;
		        comboObj.CheckCode("S") = false;
		        comboObj.CheckCode("C") = false;
			}
		}else{
			comboObj.CheckCode(" ") = false;
		}
	}
	
	/* 개발자 작업  끝 */