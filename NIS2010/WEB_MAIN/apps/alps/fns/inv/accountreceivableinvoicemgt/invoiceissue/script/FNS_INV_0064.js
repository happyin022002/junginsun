	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0064.js
	 *@FileTitle : (Korea) Terminal GIRO Inquiry
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.04.27
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.04.27 정휘택
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
	 * fns_inv_0064 : fns_inv_0064 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0064()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0064() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업 */
	
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1; 
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
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
		if (srcName == "iss_dt1" ) {
			var v_iss_dt1 = formObject.iss_dt1.value
			if (v_iss_dt1.length == 8) {
				formObject.iss_dt2.focus();
	
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
		case "iss_dt1":
			// 입력Validation 확인 및 마스킹 처리
			ComChkObjValid(event.srcElement);
			break;
	
		case "iss_dt2":
			// 입력Validation 확인 및 마스킹 처리
			ComChkObjValid(event.srcElement);
			break;
	
		case "cust_seq":	        	
			//자리수 채우기	            
			var formObject = document.form;	 
			var v_tmp = "";
			if (formObject.cust_seq.value.length != 0 && formObject.cust_seq.value.length < 6) {
				for(i = 0; i < 6 - formObject.cust_seq.value.length; i++){
					v_tmp = v_tmp + "0";
				}
				document.form.cust_seq.value = v_tmp+document.form.cust_seq.value;
			}	        		            
	
			break;       
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			ComChkObjValid(event.srcElement);
		}
	
	}    
	
	/**
	 * 업무 자바스크립트 onfocusout 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getCustNm()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getCustNm() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);	    
	
	}    
	
	/**
	 * Customer Information Inquiry 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    openFnsInv0013()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function openFnsInv0013() { 	
		var formObject = document.form;
		if(formObject.cust_cnt_cd.value != "" && formObject.cust_seq.value != "") {
			var param = '?cust_cnt_cd='+formObject.cust_cnt_cd.value+'&cust_seq='+formObject.cust_seq.value+'&pop_yn=Y';
			ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 900, 650, 'getPopData', '0,0', false, false, "", "", 0);    
		}
	
	}
	
	/**
	 * Quick Customer Search  화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    openFnsInv0086()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function openFnsInv0086() {
	
		var classId = "FNS_INV_0086";
		ComOpenPopup('/hanjin/FNS_INV_0086.do', 900, 450, 'getFnsInv0086', '1,0,1,1,1', false, false);
	
	}    
	
	/**
	 * Quick Customer Search 팝업에서 호출하는 함수  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getFnsInv0086(rowArray)
	 * </pre>
	 * @param {String[]} rowArray 
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getFnsInv0086(rowArray) {
	
		var colArray = rowArray[0];		
		var formObject = document.form;
	
		formObject.cust_cnt_cd.value = colArray[8];
		formObject.cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
	
	}     
	
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
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var cal = new ComCalendar();
	
			switch(srcName) {
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break; 
	
			case "btn_New":
				sheetObject1.RemoveAll();
	
				with(formObject){
					iss_dt1.value = "";
					iss_dt2.value = "";
					cust_cnt_cd.value = "";
					cust_seq.value = "";
					cust_nm.value = "";
					bl_src_no.value = "";
					giro_no.value = "";
				}
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC10);
				document.form.iss_dt1.focus();
				break; 
	
			case "btn_DownExcel":
				sheetObject1.SpeedDown2Excel(-1);
				break; 
	
			case "btn_Print":
				//alert(srcName);
				window.print();
				break; 
	
			case "btns_calendar1":
				//alert(1);
				cal.setDisplayType('date');
				cal.select(form.iss_dt1, 'yyyy-MM-dd');
				break;
	
			case "btns_calendar2":
				//alert(2);
				cal.setDisplayType('date');
				cal.select(form.iss_dt2, 'yyyy-MM-dd');
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
	
		var tabObjMaxLen = comboObjects.length; 
	
		initControl();
	
	}
	
	/**
	 * 업무 자바스크립트 OnLoadFinish 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet1_OnLoadFinish(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function sheet1_OnLoadFinish(sheetObj) {
	
		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC10);    
		document.form.iss_dt1.focus();
	
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
	function initSheet(sheetObj, sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
	
				//높이 설정
				style.height = 422;
	
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle = "Office|Cust Code|VVD|B/L No|GIRO No|Issue Date|Due Date|공급가액|세액|총액|Del Mark";
				var headCount = ComCountHeadTitle(HeadTitle);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);      
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);
	
				var rowCnt = 0;
				//데이터속성            [ROW,      COL,    DATATYPE,           WIDTH,  DATAALIGN,      COLMERGE,   SAVENAME,           KEYFIELD,   CALCULOGIC, DATAFORMAT,        POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	    0,	    daCenter,		false,		"ibflag");
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	75,  	daCenter,		false,		"ar_ofc_cd",		false,		"",		dfNone,					0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	100,	daCenter,		false,		"cust_cd",			false,		"",		dfNone,					0,		false,		false);
				//InitDataProperty(rowCnt,	cnt++,	dtData,    		 	200,	daLeft,		    false,		"cust_lgl_eng_nm",	false,		"",		dfNone,					0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	110,	daCenter,		false,		"vvd",				false,		"",		dfNone,					0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	130,	daCenter,		false,		"bl_src_no",		false,		"",		dfNone,					0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	130,	daCenter,		false,		"giro_no",			false,		"",		dfNone,					0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	110,	daCenter,		false,		"iss_dt",			false,		"",		dfDateYmd,			    0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		 	110,	daCenter,		false,		"due_dt",			false,		"",		dfDateYmd,			    0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,    		120,	daRight,		false,		"spl_giro_amt",		false,		"",		dfNullInteger,	        0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,    		120,	daRight,		false,		"tva_giro_amt",		false,		"",		dfNullInteger,		    0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtAutoSum,    		120,	daRight,		false,		"tot_giro_amt",		false,		"",		dfNullInteger,	        0,		false,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,   		 	50,	    daCenter,		false,		"delt_flg",			false,		"",		dfNone,					0,		false,		false);
	
				//InitDataCombo(rowCnt, "delt_flg", "Y|N", "Y|N");
	
				CountPosition = 2;
	
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
	function doActionIBSheet(sheetObj, formObj, sAction) {
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
	
		case IBSEARCH_ASYNC20: // customer name 조회
		if (formObj.cust_cnt_cd.value != "" && formObj.cust_seq.value != ""){
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			formObj.ar_ofc_cd2.value = arrStr2[1];
	
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
	
		case IBSEARCH:      //조회         	
	
		var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		formObj.ar_ofc_cd2.value = arrStr2[1];
		//alert(formObj.ar_ofc_cd2.value);
	
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_INV_0064GS.do", FormQueryString(formObj));
	
			sheetObj.SumText(0,"ar_ofc_cd")="Grand Total";
	
		}
		break;
		case IBSAVE:        //저장
		if(validateForm(sheetObj,formObj,sAction)) {
			alert (" Save .. ");                    
		}
		break;
		case IBINSERT:      // 입력
		break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel();
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
	function validateForm(sheetObj, formObj, sAction){
		with(formObj){
	
			if(iss_dt1.value > iss_dt2.value) {
				iss_dt2.value = "";
				ComShowCodeMessage("INV00043");   
				iss_dt2.focus();
				return false;
			}
	
			if(iss_dt1.value == "" && iss_dt2.value == "" && bl_src_no.value == "" && giro_no.value == "") {          		 
				ComShowCodeMessage("INV00004");
				iss_dt1.focus();
				return false;
			}
	
			if((iss_dt1.value == "") && (iss_dt2.value != "")) {
				ComShowCodeMessage("INV00004");
				iss_dt1.focus();
				return false;
			}
	
			if((iss_dt1.value != "") && (iss_dt2.value == "")) {
				ComShowCodeMessage("INV00004");
				iss_dt2.focus();
				return false;
			}
	
		}
	
		return true;
	}
	
	/* 개발자 작업  끝 */