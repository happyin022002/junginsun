	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0083.js
	 *@FileTitle : (Vietnam) Booking Data for Tax 
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.09
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.06.09 정휘택
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
	 * fns_inv_0083 : fns_inv_0083 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0083()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0083() {
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
		var sheetObject1 = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			var cal = new ComCalendar();
	
			switch(srcName) {
	
			case "btn_RowAdd":
				sheetObject1.DataInsert();
				break;
	
			case "btn_RowCopy":
				sheetObject1.DataCopy();
				break;
	
			case "btn_Delete":
				alert(srcName);
				break;
	
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
	
			case "btn_Save":
				alert(srcName);
				break;
	
			case "btn_New":
				formObject.sa_dt1.value = ""; 
				formObject.sa_dt2.value = "";
				formObject.pol.value = "";
				sheetObject1.RemoveAll();
				break;
	
			case "btn_DownExcel":
				sheetObject1.SpeedDown2Excel(-1);
				break;
	
			case "btns_calendar1":
				cal.setDisplayType('date');
				cal.select(form.sa_dt1, 'yyyy-MM-dd');
				break;
	
			case "btns_calendar2":
				cal.setDisplayType('date');
				cal.select(form.sa_dt2, 'yyyy-MM-dd');
				break;
	
			case "btn_Other":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
		if (srcName == "sa_dt1" ) {
			var v_sa_dt1 = formObject.sa_dt1.value
			if (v_sa_dt1.length == 8) {
				formObject.sa_dt2.focus();	   
				//formObject.sa_dt2.value = formObject.sa_dt1.value;	    		 		
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
			case "pol":	
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
		case "sa_dt1":
			// 입력Validation 확인 및 마스킹 처리
			ComChkObjValid(event.srcElement);
			break;
	
		case "sa_dt2":
			// 입력Validation 확인 및 마스킹 처리
			ComChkObjValid(event.srcElement);
			break;
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			ComChkObjValid(event.srcElement);
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
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	
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
		var sheetID = sheetObj.id;
		switch(sheetID) {
	
		case "sheet1":
			with (sheetObj) {
	
				// 높이 설정
				style.height = 465;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
	
				var HeadTitle1 = "BKG Office|Trunk VVD|First VVD|B/L No.|BKG No.|Sailing Date|POR|POL|POD|DEL|PRE";
				HeadTitle1 += "|Customer Name on B/L|Cust. Code|Cust. Name on Customer Table|OFT(USD)|S.CHG(USD)|B.D2|B.D4|B.D5|B.R2|B.R4";
				HeadTitle1 += "|B.R5|B.Oth|D2|D4|D5|R2|R4|R5|Oth|Feederage";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				var rowCnt = 0;
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//InitDataProperty(rowCnt,	cnt++,	dtHiddenStatus,	00,		daCenter,		false,		"ibflag");
				InitDataProperty(rowCnt,	cnt++,	dtData,    		80,		daCenter,		false,		"bkg_ofc",			    false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		90,		daCenter,		false,		"trk_vvd",				false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		90,		daCenter,		false,		"fst_vvd",				false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		90,		daCenter,		false,		"bl_no",				false,		"",		dfNone,			0,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,    		90,		daCenter,		false,		"bkg_no",				false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		80,		daCenter,		false,		"sail_dt",		        false,		"",		dfDateYmd,		0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		50,		daCenter,		false,		"por",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		50,		daCenter,		false,		"pol",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		50,		daCenter,		false,		"pod",					false,		"",		dfNone,			0,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,    		50,		daCenter,		false,		"del",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,    		50,		daCenter,		false,		"pre",					false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			170,	daLeft,	    	false,		"cust_nm",				false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			100,	daCenter,		false,		"cust_cd",				false,		"",		dfNone,			0,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			170,	daLeft,		    false,		"cust_e_nm",		    false,		"",		dfNone,			0,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		"oft",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			70,		daRight,		false,		"s_chg",				false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"bd2",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"bd4",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"bd5",					false,		"",		dfNumber,	2,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"br2",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"br4",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"br5",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"both",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"d2",					false,		"",		dfNumber,	2,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"d4",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"d5",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"r2",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"r4",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"r5",					false,		"",		dfNumber,	2,		false);
	
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"oth",					false,		"",		dfNumber,	2,		false);
				InitDataProperty(rowCnt,	cnt++,	dtData,			50,		daRight,		false,		"feederage",			false,		"",		dfNumber,	2,		false);
	
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
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH:      //조회
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("FNS_INV_0083GS.do", FormQueryString(formObj));
		}
		break;
	
		case IBSAVE:        //저장	 	        
		formObj.f_cmd.value = MULTI;
		var sXml = sheetObj.GetSearchXml("FNS_INV_0083GS.do", FormQueryString(formObj)); 
		var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
		//alert(state);
		var arIfNo = ComGetEtcData(sXml,"ar_if_no");
		formObj.ar_if_no.value = arIfNo;
	
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
			if(sa_dt1.value > sa_dt2.value) {
				ComShowCodeMessage("INV00043");     
				return false;
			}
	
			if((sa_dt1.value == "") || (sa_dt2.value == "")) {          		 
				ComShowCodeMessage("INV00043");    
				sa_dt1.focus();
				return false;
			}
	
			if(ComGetDaysBetween(sa_dt1.value, sa_dt2.value) > 30) {
				ComShowCodeMessage("INV00043");        		 
				return false;
			}
	
			if(pol.value == "") {          		 
				ComShowCodeMessage("COM12114", "POL");
				pol.focus();
				return false;
			}
		}
	
		return true;
	}
	
	/* 개발자 작업  끝 */