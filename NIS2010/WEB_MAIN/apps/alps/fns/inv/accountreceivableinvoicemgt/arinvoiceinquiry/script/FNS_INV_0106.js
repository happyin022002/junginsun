	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : FNS_INV_0106.js
	 *@FileTitle : Invoice Search
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.08.10
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.08.10 정휘택
	 * 1.0 Creation
* -------------------------------------------------------- 
 * History
 * 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
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
	 * FNS_INV_0106 : FNS_INV_0106 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     FNS_INV_0106()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function FNS_INV_0106() {
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
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObject = document.form;
	
		var cal = new ComCalendar();
	
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
	
			case "btn_add":
				sheetObject.DataInsert(-1);
				break;							
	
			case "btn_delete":
				sheetObject.RowDelete();
				break;							
	
			case "btn_downexcel":
				sheetObject.Down2Excel();
				break;
	
			case "btn_save":
				alert(srcName);
				break; 
	
			case "btn_print":
				alert(srcName);
				break;
	
			case "btns_calendar1":
				cal.setDisplayType('date');
				cal.select(formObject.iss_fm_dt, 'yyyy-MM-dd');
				break;
	
			case "btns_calendar2":
				cal.setDisplayType('date');
				cal.select(formObject.iss_to_dt, 'yyyy-MM-dd');
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
	 *     setSheetObject(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function setSheetObject(sheetObj){
	
		sheetObjects[sheetCnt++] = sheetObj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		initControl();

		if (document.form.sel_option.value == "M") {
			ComBtnDisable("btn_apply");    
		}        
	
	}
	
	/**
	 * New 버튼 클릭시 화면 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initField()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function initField() {
	
		var formObj = document.form;
		with(formObj){
			iss_fm_dt.value = "";
			iss_to_dt.value = "";
			bl_src_no.value = "";
			cust_cnt_cd.value = "";
			cust_seq.value = "";
			cust_nm.value = "";
			usr_id.value = "";
			vvd.value = "";
			scope.value = "";
			port.value = "";
			bound.value = "";
		}        	
	
	}
	
	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 Catch <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    initControl()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function initControl() {
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)
		axon_event.addListenerFormat ('keypress', 'objKeypress', document.form);
		axon_event.addListenerFormat ('beforeactivate', 'objActivate', document.form);
		axon_event.addListenerForm ('beforedeactivate', 'objDeactivate', document.form);
		axon_event.addListenerForm ('keyup', 'objKeyup', document.form); 
	
	}
	
	/**
	 * 업무 자바스크립트 OnKeyUp 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeyup()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
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
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeypress()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objKeypress() {
		switch(event.srcElement.dataformat){
		case "float":
			// 숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, "."); break;
	
		case "int":
			// 숫자만 입력하기
			ComKeyOnlyNumber(event.srcElement); break;
	
		case "engup":
	
			switch(event.srcElement.name){
			case "cust_cnt_cd":	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('upper'); break;
			/*
	        case "cust_seq":	    	        	
	        	// 숫자만입력하기
    	        ComKeyOnlyNumber(event.srcElement);
			*/
			case "bl_src_no":
				//영문대문자+숫자입력하기
				ComKeyOnlyAlphabet('uppernum'); break;
	
			case "giro_no":
				//영문대문자+숫자입력하기
				ComKeyOnlyAlphabet('uppernum'); break;
	
			case "vvd":
				//영문대문자+숫자입력하기
				ComKeyOnlyAlphabet('uppernum'); break;
	
			case "scope":
				//영문대문자만입력하기
				ComKeyOnlyAlphabet('upper'); break;
	
			case "port":
				//영문대문자만입력하기
				ComKeyOnlyAlphabet('uppernum'); break;
	
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
	
		default:
			// 숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
		}
	}
	
	/**
	 * 업무 자바스크립트 OnBeforeActivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objActivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objActivate() {
		// 마스크 구분자 없애기
		ComClearSeparator (event.srcElement);
	}
	
	/**
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objDeactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
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
			if (formObject.cust_cnt_cd.value != '' && formObject.cust_seq.value != '') {
				var valueCustSeq = formObject.cust_seq.value;
				formObject.cust_seq.value = ComLpad(valueCustSeq,6,"0");
	
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);
			}
			else {
				formObject.cust_cnt_cd.value = '';
				formObject.cust_seq.value = '';
				formObject.cust_nm.value = '';
			}      		            
	
			break;     
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			ComChkObjValid(event.srcElement);
		}
	
	}   
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br> 
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj, 0)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 정휘택
	 * @version 2009.10.20     
	 */   
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) {
	
			// 높이 설정
			style.height = 242;
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
	
			var HeadTitle = "Sel.|B/L No.|Invoice No.|VVD|S/A Date|Actual Cust.|Issue Date|Local Amount|User ID";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtCheckBox,  40,   daCenter,  true,    "SelChk",          false,        "");
			InitDataProperty(0, cnt++ , dtData,      90,   daCenter,  true,    "bl_src_no",       false,		"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,      110,   daCenter,  true,    "inv_no",          false,		"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    "vvd",             false,		"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    "sail_arr_dt",     false,		"",	dfDateYmd,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    "cust_cd",         false,		"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    "iss_dt",          false,		"",	dfDateYmd,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,      120,  daRight,   true,    "local_total",     false,		"",	dfNone,	0,	false,		false);
			InitDataProperty(0, cnt++ , dtData,      80,   daCenter,  true,    "cre_usr_id1",     false,		"",	dfNone,	0,	false,		false);
	
		}
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
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {

			if(formObj.office.value == "SAOSC" && formObj.split_flg.value == "S") {
				formObj.f_cmd.value = SEARCH01;
			} else {
				formObj.f_cmd.value = SEARCH;	
			}
			
			sheetObj.DoSearch("FNS_INV_0106GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(""));
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
	
		case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction))
		break;
	
		case IBINSERT:      // 입력
		break;
	
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     validateForm(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return boolean
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(bl_src_no.value == "" && vvd.value == "") {
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
	
	/* 개발자 작업  끝 */