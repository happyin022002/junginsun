	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0004.js
	 *@FileTitle : Bank Code Entry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.06
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.05.06 정휘택
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
	 * fns_inv_0004 : fns_inv_0004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0004()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0004() {
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
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
	
			case "btn_new":
				formObject.ar_ofc_cd.text = formObject.login_ofc_cd.value;
				formObject.ofc_cd.value = "";
				sheetObject.RemoveAll();
				break;
	
			case "btn_add":		
				/*
			        	if((formObject.ofc_cd.value == "")) {   		        	      		 
			          	    ComShowCodeMessage("COM12114", "Sales Office");
			          	    formObject.ofc_cd.focus();
			          	    break;		          		
			          	}
				 */		        	
				sheetObject.DataInsert(-1);
				break;							
	
			case "btn_delete":
				ComRowHideDelete(sheetObject, "DelChk");
				break;							
	
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);  
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
	
		case "engup":
	
			switch(event.srcElement.name){
			case "ofc_cd":	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('upper'); break;
	
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
	 *    objDeactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objActivate() {
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
	 * Sales Office 체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    chkOfcCd()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function chkOfcCd() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		//if (formObject.ofc_cd.value != "") {
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);	    	
		//}   	
	
	}
	
	/**
	 * 업무 자바스크립트 sheet1_OnChange 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet1_OnChange(sheetObj,Row,Col,Value)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} IBSheet의 OnChange 이벤트 발생 Row
	 * @param {int} IBSheet의 OnChange 이벤트 발생 Col
	 * @param {String} IBSheet의 OnChange 이벤트 발생 Value
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value){
		if (sheetObj.ColSaveName(Col) == "ofc_cd") {
	
			document.form.ofc_cd2.value = sheetObj.CellValue(sheetObj.SelectRow, 2); 		
			if (document.form.ofc_cd2.value != "") {
				chkOfcCd();	
			}			
	
		}
	
	}
	
	/**
	 * Office Combo 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     MakeComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param {ibCombo} cmbObj 필수 IBCombo Object
	 * @param {String} 콤보 리스트 스트링
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll();
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
		cmbObj.DropHeight = 190;
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
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC10);
		initControl();
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
			style.height = 400;
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
			InitColumnInfo(8, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);
	
			var HeadTitle = "|Sel|Sales OFC|Bank Account|Curr|Bank Name|Bank Address|Remark";
	
			//UseUTF8 = true;
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++ , dtHiddenStatus,  40,    daCenter,  true,    "HidStatus");
			InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,   "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40,daCenter, false, "DelChk");
	
			//InitDataProperty(0, cnt++ , dtData,     	  55,    daCenter,  true,    "ar_ofc_cd",     	false,    "",      dfNone,		0,	false,		false,	6);
			InitDataProperty(0, cnt++ , dtData,     	  85,    daCenter,  true,    "ofc_cd",    	true,    "",      dfNone,		0,	true,		true,	6);
			InitDataProperty(0, cnt++ , dtData,     	  120,   daCenter,  true,    "bank_acct_no",     true,    "",      dfNone,		0,	true,		true,	30);
			InitDataProperty(0, cnt++ , dtData,     	  45,    daCenter,  true,    "bank_acct_curr_cd",     	false,    "",      dfNone,		0,	true,		true,	3);
	
			InitDataProperty(0, cnt++ , dtData,     	  280,   daLeft,	true,    "bank_nm",    true,    "",      dfNone,		0,	true,		true,	50);
			InitDataProperty(0, cnt++ , dtData,     	  300,   daLeft,  	true,    "bank_addr",     false,    "",      dfNone,		0,	true,		true,	200);
			InitDataProperty(0, cnt++ , dtData,     	  50,    daCenter,  true,    "bank_acct_rmk",    	false,    "",      dfNone,		0,	true,		true,	20);
	
			InitDataValid(0,    "ofc_cd",   vtEngUpOnly);
			InitDataValid(0,    "bank_acct_curr_cd",   vtEngUpOnly);
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
	
		case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
	
		var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
		var arrStr = sStr.split("|");
		MakeComboObject(formObj.ar_ofc_cd, arrStr);
	
		var arrStr2 = arrStr[1].split("^");
		var ar_ofc_cd = arrStr2[3];
		formObj.ar_ofc_cd.text = ar_ofc_cd;
	
		break;
	
		case IBSEARCH_ASYNC20: // Sales Office 체크
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		formObj.ar_ofc_cd2.value = arrStr2[1];
	
		formObj.f_cmd.value = SEARCH03;
	
		var sXml = sheetObj.GetSearchXml("FNS_INV_0004GS.do", FormQueryString(formObj));				
	
		var sStr = ComGetEtcData(sXml,"ofc_chk");
	
		if (sStr == "N") {
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, 2) = ""; 
		}
	
		break;
	
		case IBSEARCH:      //조회
	
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		formObj.ar_ofc_cd2.value = arrStr2[1];
	
		if(validateForm(sheetObj,formObj,sAction)) {
			if(sheetObj.id == "sheet1") {
				//sheetObj.DoSearch("UI_INV_0004_DATA.html");
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("FNS_INV_0004GS.do", FormQueryString(formObj));
			}
		}			
	
		break;
	
		case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction)){
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("FNS_INV_0004GS.do", FormQueryString(formObj)); 					
		} else {
			return;
		}
	
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
	
		}
		return true;
	}
	
	/* 개발자 작업  끝 */