/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0051.js
*@FileTitle : Off Hire Plan and Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.07.16 노정용
* 1.0 Creation
* 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
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
	 * @class ees_lse_0051 : ees_lse_0051 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0051() {
		this.processButtonClick			= processButtonClick;
		this.setSheetObject				= setSheetObject;
		this.setComboObject				= setComboObject;
		this.loadPage					= loadPage;
		this.initControl				= initControl;
		this.obj_blur					= obj_blur;
		this.obj_focus					= obj_focus;
		this.obj_keypress				= obj_keypress;
		this.obj_keyup					= obj_keyup;
		this.obj_keydown				= obj_keydown;
		this.obj_click					= obj_click;
		this.obj_change					= obj_change;
		this.initSheet					= initSheet;
		this.initCombo					= initCombo;
		this.doActionIBSheet			= doActionIBSheet;
		this.sheet1_OnLoadFinish		= sheet1_OnLoadFinish;
		this.sheet1_OnSearchEnd 		= sheet1_OnSearchEnd;
		this.loc_tp_OnChange			= loc_tp_OnChange;
		this.cntr_tpsz_cd_OnCheckClick	= cntr_tpsz_cd_OnCheckClick;
		this.cntr_tpsz_cd_OnKeyDown		= cntr_tpsz_cd_OnKeyDown;
		this.openPopup					= openPopup;
		this.setPopData_DeliveryLoc		= setPopData_DeliveryLoc;
		this.validateForm				= validateForm;
	}

/* 개발자 작업  */

	// 공통전역변수

	// Sheet Object Array
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	var vOrcCntrTpszCd = "";
	var vOffhYrmon     = "";
	var vPlanType      = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;

				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel();
					break;

				case "btn_New":
					ComResetAll();
					comboObjects[0].Index = 0;
					comboObjects[1].Index = 0;
					comboObjects[2].Index = 0;
					formObj.lstm_cd.Enable = true;
					ComSetFocus(formObj.loc_tp);
					break;

				case "btns_search1":
					if ( srcObj.style.filter == "" ) {
						openPopup("1");
					}
					break;

				case "btns_calendar1":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.from_offh_yrmon, 'yyyy-MM');
					break;

				case "btns_calendar2":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.to_offh_yrmon, 'yyyy-MM');
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 *
	 * @param combo_obj IBSheet Ojbect
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 *
	 * @param combo_obj IBCombo Ojbect
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj = document.form;

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }

		for ( var i = 0 ; i < sheetObjects.length ; i++ ) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);

			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		initControl();
		
		ComSetObjValue(formObj.loc_tp, " ");

		LseComBtnControl(false, "btns_DownExcel");
		ComEnableObject(formObj.loc_cd, false);
		ComEnableObject(formObj.btns_search1, false);
	}

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		//axon_event.addListenerForm('beforedeactivate',		'obj_blur',		formObj); //- 포커스 나갈때
  		axon_event.addListenerForm('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerForm('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',	'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',	'obj_change',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('click',		'obj_click',	formObj); //- 키 눌렸을때
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
  		var formObj = document.form;
  		var obj     = event.srcElement;

	    switch(obj.name){
	    	case "to_offh_yrmon":
	    		if ( ComChkObjValid(obj) ) {
	    			if ( ComGetObjValue(formObj.from_offh_yrmon) != ""
	    			  && ComGetObjValue(obj) != "" ) {
                      //&& checkEffectiveDate(formObj.from_offh_yrmon, formObj.to_offh_yrmon) ) {
	  					var v2 = ComParseInt(ComGetDateAdd(ComGetObjValue(formObj.from_offh_yrmon)+"-01", "M", 11).replace("-", "").substr(0,6));
	  					var v3 = ComParseInt(ComGetObjValue(obj).replace("-", ""));
	  					if ( v3 > v2 ) {
	  						ComShowCodeMessage("LSE01129", "12");
	  						ComSetFocus(obj);
	  						return false;
		  				}
	    			}
	    		}
	            break;

	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	        	break;
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus(){
		var obj  = event.srcElement;

		if( obj.readOnly ) {
			ComSetNextFocus(obj);
		} else {
		    //마스크구분자 없애기
		    ComClearSeparator(event.srcElement);
		}
	}

	/**
	 * Key-Press Event 처리
	 */
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
	            ComKeyOnlyAlphabet(); 
	            break;
	        case "engup":
	        	if(obj.name == "loc_cd") {
		            ComKeyOnlyAlphabet('uppernum');
	        	}else{
	        		ComKeyOnlyAlphabet('upper');
	        	}
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
  	 * Key-Up Event 처리
  	 */
  	function obj_keyup() {
  		var obj = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
			case "from_offh_yrmon":
				ComKeyEnter('LengthNextFocus');
  				break;

			case "to_offh_yrmon":
				ComKeyEnter('LengthNextFocus');
  				break;
  		}
  	}

   	/**
	 * Key-Down Event 처리
	 */
   	function obj_keydown() {
	   	var formObj  = document.form;
		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;

   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}

	/**
	 * Click Event 처리
	 */
	function obj_click() {
		var formObj = document.form;
		var obj     = event.srcElement;

		switch(obj.name) {
			case "offh_pln_tp_cd":
				if ( vPlanType != ComGetObjValue(obj) ) {
					sheetObjects[0].RemoveAll();

					if ( ComGetObjValue(obj) == "O" ) {
						formObj.lstm_cd.Index = 0;
						formObj.lstm_cd.Enable = false;
						// Plan Data 는 by RCC Data
						ComSetObjValue(formObj.offh_loc_tp_cd, "R");
						sheetObjects[0].ColHidden("offh_loc_cd") = false;
					} else if ( ComGetObjValue(obj) == "B" ) {
						formObj.lstm_cd.Index = 0;
						formObj.lstm_cd.Enable = true;
						// Plan Data 는 by H/O Basic Data
						ComSetObjValue(formObj.offh_loc_tp_cd, "H");
						sheetObjects[0].ColHidden("offh_loc_cd") = true;
					}

					vPlanType = ComGetObjValue(obj);
				}
				break;
		}
	}
	
	/**
	 * Change Event 처리
	 */	 
	function obj_change() {
		var obj      = event.srcElement;
		var formObj  = document.form;

		if ( ComTrim(ComGetObjValue(obj)) != "" ) {
			switch(obj.name) {
	    		case "loc_cd":
	   				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
					break;

	    		case "to_offh_yrmon":
	    			checkDatePeriod(formObj.from_offh_yrmon, formObj.to_offh_yrmon, "ym");
					break;
			}
		}
	}
  	// 2. 이벤트처리함수 -- End

	/**
	 * 시트 초기설정값, 헤더 정의
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * 
	 * @param sheetObj 시트오브젝트, 
	 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
	 */
	function initSheet(sheetObj, sheetNo) {

		var cnt = 0;
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":      //sheet1 init
				with (sheetObj) {

					// 높이 설정
					style.height = 380;

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 3, 3, 100);

					var HeadTitle1 = "RCC|LCC|Term|TP/SZ|DIV|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|G.TTL";

					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true,  "offh_rgn_loc_cd", false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true,  "offh_loc_cd",     false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 45, daCenter, true,  "lstm_cd",         false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 50, daCenter, true,  "cntr_tpsz_cd",    false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 55, daCenter, false, "type_nm",         false,  "",   dfNone);

					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_1",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_2",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_3",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_4",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_5",          false,  "",   dfNone);

					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_6",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_7",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_8",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_9",          false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_10",         false,  "",   dfNone);

					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_11",         false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 53, daRight,  true,  "mnth_12",         false,  "",   dfNone);
					InitDataProperty(0, cnt++, dtData, 60, daRight,  true,  "ttl_qty",         false,  "",   dfNone);

					cnt = 0;
					InitDataProperty(1, cnt++, dtData, 50, daCenter, true,  "offh_rgn_loc_cd", false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 50, daCenter, true,  "offh_loc_cd",     false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 45, daCenter, true,  "lstm_cd",         false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 50, daCenter, true,  "cntr_tpsz_cd",    false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 55, daCenter, false, "type_nm",         false,  "",   dfNone);

					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_1",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_2",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_3",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_4",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_5",          false,  "",   dfNone);

					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_6",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_7",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_8",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_9",          false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_10",         false,  "",   dfNone);

					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_11",         false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 53, daRight,  true,  "mnth_12",         false,  "",   dfNone);
					InitDataProperty(1, cnt++, dtData, 60, daRight,  true,  "ttl_qty",         false,  "",   dfNone);

					cnt = 0;
					InitDataProperty(2, cnt++, dtData, 50, daCenter, true,  "offh_rgn_loc_cd", false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 50, daCenter, true,  "offh_loc_cd",     false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 45, daCenter, true,  "lstm_cd",         false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 50, daCenter, true,  "cntr_tpsz_cd",    false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 55, daCenter, false, "type_nm",         false,  "",   dfNone);

					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_1",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_2",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_3",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_4",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_5",          false,  "",   dfNone);

					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_6",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_7",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_8",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_9",          false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_10",         false,  "",   dfNone);

					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_11",         false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 53, daRight,  true,  "mnth_12",         false,  "",   dfNone);
					InitDataProperty(2, cnt++, dtData, 60, daRight,  true,  "ttl_qty",         false,  "",   dfNone);
				}
				break;
		}
	}

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 *
	 * @param comboObj 콤보오브젝트
	 * @param comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "loc_tp":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	UseAutoComplete = true;
	            	ValidChar(2,0);
	            }
	        	break;

	        case "lstm_cd":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	UseAutoComplete = true;
	            	ValidChar(2,0);
	            }
	        	break;

	        case "cntr_tpsz_cd":
	        	with(comboObj) {
	            	DropHeight = 320;
	            	MultiSelect = true;
	            	UseAutoComplete = true;
	            	ValidChar(2,3);
	            }
	        	break;
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCREATE:
        		sheetObj.WaitImageVisible = false;

        		/* RCC Combo Item Setting */
		        comboObjects[0].InsertItem(0, "ALL", " ");
		        comboObjects[0].InsertItem(1, "RCC", "RCC");
		        comboObjects[0].InsertItem(2, "LCC", "LCC");
        		comboObjects[0].Index = 0;

	            /* Lease Term Combo Item Setting Start */
        		comboObjects[1].InsertItem(0, "ALL", " ");
		        comboObjects[1].InsertItem(1, "LT", "LT");
		        comboObjects[1].InsertItem(2, "ST", "ST");
        		comboObjects[1].Index = 0;

        		/* Container Type/Size Combo Item Setting Start */
        		ComSetObjValue(formObj.f_cmd, SEARCH02);

        		var sXml1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

	            if ( sXml1 != "" ) {
	            	comboObjects[2].InsertItem(0, "ALL", "");
	            	LseComXml2ComboItem(sXml1, comboObjects[2], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	comboObjects[2].Index = 0;
	            	vOrcCntrTpszCd = ComGetEtcData(sXml1, "cntr_tpsz_cd");
	            }

	            /* 초기 Focus Setting */
	            ComSetFocus(formObj.from_offh_yrmon);

		        vPlanType = ComGetObjValue(formObj.offh_pln_tp_cd);
		        sheetObj.ColHidden("offh_loc_cd") = true;
		        ComSetObjValue(formObj.offh_loc_tp_cd, "H");
		        break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
						ComSetObjValue(formObj.f_cmd, SEARCH);

						/* Period 계산 */
						//var v1 = ComGetObjValue(formObj.from_offh_yrmon).substr(0,4) + "-" + ComGetObjValue(formObj.from_offh_yrmon).substr(4,2) + "-01";
						var v1 = ComGetObjValue(formObj.from_offh_yrmon) + "-01";
						var v2 = ComGetObjValue(formObj.from_offh_yrmon).replace("-","");
						var v3 = ComGetObjValue(formObj.to_offh_yrmon).replace("-","");

						vOffhYrmon = v2;
						while( ComParseInt(v2) < ComParseInt(v3) ) {
							v1 = ComGetDateAdd(v1, "M", 1);
							v2 = v1.replace("-", "").substr(0,6);
							vOffhYrmon = vOffhYrmon + "|" + v2;
						}
						ComSetObjValue(formObj.offh_yrmon, vOffhYrmon);
						
						//sheetObj.Redraw = false;
		        		sheetObj.WaitImageVisible = false;
		        		ComOpenWait(true);
						sheetObj.DoSearch4Post("EES_LSE_0051GS.do", FormQueryString(formObj));
						ComOpenWait(false);
					}
				}
				break;

 			case IBSEARCH_ASYNC01:	// Location 조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						ComSetObjValue(formObj.f_cmd, SEARCH05);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
									var vLocTp = ComGetObjValue(formObj.loc_tp);
									var vLocCd = "";
									switch (vLocTp) {
										case "RCC":
											vLocCd = ComGetEtcData(sXml, "rcc_cd");
											break;
	
										case "LCC":
											vLocCd = ComGetEtcData(sXml, "lcc_cd");
											break;
	
										case "SCC":
											vLocCd = ComGetEtcData(sXml, "scc_cd");
											break;											
									}
	
									ComSetObjValue(formObj.loc_cd, vLocCd);
								} else {
									ComShowCodeMessage("LSE01037");
									ComSetObjValue(formObj.loc_cd, "");
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								ComSetObjValue(formObj.loc_cd, "");
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}
				break;
		}
	}

	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}

	/**
	 * IBSheet SearchEnd Event
	 * 
	 * @param sheetObj 시트오브젝트
	 * @param ErrMsg 에러메세지
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;

		if ( ErrMsg == "" ) {
			if ( vOffhYrmon != "" ) {
				var arrOffhYrmon = vOffhYrmon.split("|");
				for ( var i = 0 ; i < 12 ; i++ ) {
					if ( i < arrOffhYrmon.length ) {
						sheetObj.CellValue(0, (5+i)) = arrOffhYrmon[i].substr(0,4)+"-"+arrOffhYrmon[i].substr(4,2);
						sheetObj.ColHidden((5+i)) = false;
					} else {
						sheetObj.ColHidden((5+i)) = true;
					}
				}
			}

			/* 소계 Title Merge 처리 */
			/*
			var strRows1 = ComFindAll(sheetObj, "offh_loc_cd", "TTL");
			var arrStrRows1 = strRows1.split("|");
			for ( var i = 0 ; i < arrStrRows1.length ; i++ ) {
				if ( i%3 == 0 ) {
					if ( ComGetObjValue(formObj.offh_pln_tp_cd) == "O" ) {
						sheetObj.SetMergeCell(arrStrRows1[i], 1, 3, 3);
					} else {
						sheetObj.CellValue(arrStrRows1[i],   "lstm_cd")              = "TTL";
						sheetObj.CellValue(ComParseInt(arrStrRows1[i])+1, "lstm_cd") = "TTL";
						sheetObj.CellValue(ComParseInt(arrStrRows1[i])+2, "lstm_cd") = "TTL";
						sheetObj.SetMergeCell(arrStrRows1[i], 2, 3, 2);
					}
				}
			}
			*/

			/* 합계 Title Merge 처리 */
			/*
			var strRows2 = ComFindAll(sheetObj, "offh_rgn_loc_cd", "G.TTL");
			var arrStrRows2 = strRows2.split("|");
			for ( var i = 0 ; i < arrStrRows2.length ; i++ ) {
				if ( i%3 == 0 ) {
					sheetObj.SetMergeCell(arrStrRows2[i], 0, 3, 4);
				}
			}
			*/
		}
	}

	 /**
	 * IBCombo Change Event
	 * 
	 * @param comboObj 콤보오브젝트
	 * @param Code
	 * @param Text
	 */
	function loc_tp_OnChange(comboObj, Code, Text) {
		var formObj = document.form;
		var obj = formObj.loc_cd;

		ComSetObjValue(obj, "");

		if ( ComTrim(Code) != "" ) {
			obj.className = "input";
			obj.readOnly = false;
			ComEnableObject(formObj.btns_search1, true);
			ComSetFocus(formObj.loc_cd);
		} else {
			obj.className = "input2";
			obj.readOnly = true;
			ComEnableObject(formObj.btns_search1, false);
			ComSetFocus(formObj.lstm_cd);			
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
		if(index==0) {
			var bChk = comboObj.CheckIndex(index);
			if(bChk){
				for(var i = 1 ; i < comboObj.GetCount() ; i++) {
					comboObj.CheckIndex(i) = false;
				}
			}
		} else {
			comboObj.CheckIndex(0) = false;
		}
	}

	/**
	 * combo1_OnKeyDown
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function cntr_tpsz_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			}
		}
	}

	/**
	 * Pop-up Open 부분<br>
	 *
	 * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 */
	function openPopup(type, Row, Col) {
		if ( type == "1" ) {
			ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', false, false, Row, Col, 0);
		}
	}

    /**
     * Location Pop-up Return Value 처리 부분<br>
     *
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
    		if ( ComGetObjValue(formObj.loc_tp) == "RCC" ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][13]);	// RCC
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][11]);	// 2009.10.13 RCC
    		} else if ( ComGetObjValue(formObj.loc_tp) == "LCC" ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][12]);	// LCC
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][10]);	// 2009.10.13 LCC
    		}
    	}
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리<br>
	 *
	 * @param sheetObj 시트오브젝트
	 * @param formObj 폼오브젝트
	 * @param sAction 액션구분
	 */
	function validateForm(sheetObj, formObj, sAction){
		with(formObj){
			switch(sAction) {
				case IBSEARCH:
					if ( !checkDatePeriod(formObj.from_offh_yrmon, formObj.to_offh_yrmon, "ym") ) {
	     				return false;
	     			}
					
					//var v1 = ComGetObjValue(formObj.from_offh_yrmon).substr(0,4) + "-" + ComGetObjValue(formObj.from_offh_yrmon).substr(4,2) + "-01";
	  				var v2 = ComParseInt(ComGetDateAdd(ComGetObjValue(formObj.from_offh_yrmon)+"-01", "M", 11).replace("-", "").substr(0,6));
	  				var v3 = ComParseInt(ComGetObjValue(formObj.to_offh_yrmon).replace("-", ""));

	  				if ( v3 > v2 ) {
	  					ComShowCodeMessage("LSE01090", "12");
	  					ComSetFocus(formObj.to_offh_yrmon);
	  					return false;
	  				}
		    		return ComChkValid(formObj);
		            break;
			}
		}

		return true;
	}
/* 개발자 작업  끝 */