	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0084.js
	 *@FileTitle : (Thailand) Freight and Charge List
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.09
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.06.09 정휘택
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
	 * fns_inv_0084 : fns_inv_0084 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0084()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0084() {
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
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_retrive":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
	
			case "btn_new":
				formObject.vvd.value = "";
				formObject.vsl_eng_nm.value = "";
				sheetObject.RemoveAll();      
				break;
	
			case "btn_downExcel":
				sheetObject.SpeedDown2Excel(-1);
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
	 * Vessel 명 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getVslNm()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getVslNm() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		if (formObject.vvd.value != "") {
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC10);	 	
		} else {
			formObject.vsl_eng_nm.value = "";
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
		axon_event.addListenerFormat ('keypress', 'objKeypress', form);
		axon_event.addListenerFormat ('beforeactivate', 'objActivate', form);
		axon_event.addListenerForm ('beforedeactivate', 'objDeactivate', form);
	
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
			case "vvd":	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;
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
	
		switch(event.srcElement.name){
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			ComChkObjValid(event.srcElement);
		}
	
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
		document.form.vvd.focus();
	
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
			style.height = 465;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			//MergeSheet = msHeaderOnly;
			MergeSheet = 7;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 3, 100);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(12, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
	
			var HeadTitle  = "B/L No|Prepaid|Prepaid|Prepaid|Prepaid|Prepaid|Collect|Collect|Collect|Collect|Collect|Ex. Rate";
			var HeadTitle1 = "B/L No|USD AMT|EQV AMT|THB AMT|OTH CURR|OTH AMT|USD AMT|EQV AMT|THB AMT|OTH CURR|OTH AMT|Ex. Rate";
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle1, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData,     95,    daCenter, true,     "bl_no",         false,          "",      dfNone );
			InitDataProperty(0, cnt++ , dtData,     80,    daRight,  false,    "p_usd_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     80,    daRight,  false,    "p_eqv_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     80,    daRight,  false,    "p_thb_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     65,    daCenter, false,    "p_oth_curr",    false,          "",      dfNone );
	
			InitDataProperty(0, cnt++ , dtData,     80,    daRight,  false,    "p_oth_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     80,    daRight,  false,    "c_usd_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     80,    daRight,  false,    "c_eqv_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     65,    daRight,  false,    "c_thb_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     80,    daCenter, false,    "c_oth_curr",    false,          "",      dfNone );
	
			InitDataProperty(0, cnt++ , dtData,     80,    daRight,  false,    "c_oth_amt",     false,          "",      dfFloat,     2 );
			InitDataProperty(0, cnt++ , dtData,     65,    daRight,  true,     "ex_rate",       false,          "",      dfFloat,     2 );
	
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
	
		case IBSEARCH_ASYNC10: // vsl name 조회
	
		formObj.f_cmd.value = SEARCH06;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	
	
		var vsl_eng_nm = ComGetEtcData(sXml,"vsl_eng_nm");    
		if (vsl_eng_nm != undefined) {
			formObj.vsl_eng_nm.value = vsl_eng_nm;
		} else {
			formObj.vsl_eng_nm.value = "";
		}			
	
		break;
	
		case IBSEARCH:      //조회
	
		if(validateForm(sheetObj,formObj,sAction)) {
	
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_INV_0084GS.do", FormQueryString(formObj));
	
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
			var v_vvd = vvd.value;
			if(v_vvd.length != 9) {          		 
				ComShowCodeMessage("COM12114", "VVD");
				vvd.focus();
				return false;
			}
		}
	
		return true;
	}
	
	/* 개발자 작업  끝 */