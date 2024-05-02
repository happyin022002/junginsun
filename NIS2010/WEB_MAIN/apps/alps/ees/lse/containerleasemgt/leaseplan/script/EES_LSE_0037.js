/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0037.js
*@FileTitle : New Van CNTR Delivery Plan & Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.22 장준우
* 1.0 Creation
* ======================================================
* 2010.12.03 [CHM-201007443-01] 남궁진호 Ref No 항목 추가
* 2011.01.27 남궁진호 [CHM-201108164-01] 공통 팝업 (COM_ENS_051, COM_ENS_0C1) Open Size 조정
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 *@fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	/**
	 * @extends
	 * @class EES_LSE_0037 : EES_LSE_0037 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0037() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
		this.loadPage 				= loadPage;
		this.initControl            = initControl;
		this.obj_blur				= obj_blur;
		this.obj_focus				= obj_focus;
		this.obj_change				= obj_change;
		this.obj_keypress			= obj_keypress;
		this.obj_keyup				= obj_keyup;
		this.initSheet 				= initSheet;
		this.initCombo 				= initCombo;
		this.doActionIBSheet 		= doActionIBSheet;
		this.sheet1_OnDblClick		= sheet1_OnDblClick;
		this.sheet1_OnMouseMove 	= sheet1_OnMouseMove;
		this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
		this.combo1_OnBlur			= combo1_OnBlur;
		this.combo2_OnBlur			= combo2_OnBlur;
		this.combo1_OnKeyDown		= combo1_OnKeyDown;
		this.combo2_OnKeyDown		= combo2_OnKeyDown;
		this.combo1_OnCheckClick	= combo1_OnCheckClick;
		this.combo2_OnCheckClick	= combo2_OnCheckClick;
		this.combo3_OnCheckClick	= combo3_OnCheckClick;
		this.openPopup				= openPopup;
		this.setPopData_Agreement	= setPopData_Agreement;
		this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;
	}

	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	var vOrgLocTp = "";
   	var vOrcCntrTpszCd = "";
   	var vMftVndrSeq = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/

		var formObj = document.form;

		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					dcondTD.innerHTML = "&nbsp;"
					sheetObjects[1].RemoveAll();
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

				case "btn_New":
					dcondTD.innerHTML = "&nbsp;"
					ComResetAll();
					ComSetFocus(formObj.pln_yrmon);
					break;

				case "btn_DownExcel":
					sheetObject1.Down2Excel(-1, false, false, true);
					break;

				case "btn_DownExcel2":
					sheetObject2.SpeedDown2Excel(-1)
					break;

				case "btns_search1":
					// Location Search
					openPopup("1");
					break;

				case "btns_search2":
					// Lease Agreement Search
					openPopup("2");
					break;

			} // end switch
		} catch (e) {
			if ( e == "[object Error]") {
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
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
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

		 /* IBSheet 초기화 */
		 for( var i = 0 ; i < sheetObjects.length ; i++ ) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);

			//khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }
	}

	/**
	 * loadPage 메서드에서 초기 조회하는 메서드를 분리한다.
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

     	/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObjects[0], document.form, IBCREATE);

		/* Axon Control Setting*/
		initControl();

		/* 초기 Focus Setting */
		ComSetFocus(formObj.pln_yrmon);
    }

  	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',		'obj_change',	formObj); //- 변경될때.
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name){
	    	case "pln_yrmon":
  				//Validation 전체 체크(길이,format,최대,최소 등등)
	            //if(ComChkObjValid(obj, true, false, false) == false) {
	            //	ComSetFocus(obj);
	            //}
	            ComChkObjValid(obj, true, false, false);
	    		break;
	        case "agmt_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
	            ComChkObjValid(obj, true, false, false);
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
	 * OnChange Event 처리
	 */
	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
				case "loc_tp":		//Location Type
					formObj.loc_cd.value = "";
					ComSetNextFocus(obj);
					break;
	    		case "loc_cd":
	    			if(ComChkObjValid(obj, false)) {
	    				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    			}
	    			break;

	    		case "agmt_seq":
	    			if(ComChkObjValid(obj, false, false, false)) {
	    				doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	    			}
					break;
			}
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

  		switch(obj.name) {
			case "pln_yrmon":
  				ComKeyEnter('LengthNextFocus');
  				break;

			case "loc_cd":
				if ( ComTrim(obj.value) != "" ) {
					ComKeyEnter('LengthNextFocus');
				}
  				break;

			case "agmt_seq":
  				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
  		}
  	}

   	/**
	 * Key-Down Event 처리
	 */
   	function obj_keydown() {
   		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;
   		var formObj  = document.form;

   		if ( vKeyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   			formObj.agmt_seq.focus();
   		}
   	}
  	// 2. 이벤트처리함수 -- End

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;

		switch(sheetid){
			case "sheet1":
				with (sheetObj) {

					// 높이 설정
					style.height = 288;

					//전체 너비 설정
					SheetWidth = sheetTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "Plan\nYear/Month|AGMT No.|Ref No.|Del. Year|||Manufacturer|TP/SZ|LCC|||Result|JAN|FEB|MAR|1/4 QTA|APR|MAY|JUN|2/4 QTA|JUL|AUG|SEP|3/4 QTA|OCT|NOV|DEC|4/4 QTA|G.TTL|";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 11, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,		75,	daCenter,	true,	"pln_yrmon",	false,	"",	dfDateYm);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"agmt_no",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		100,daLeft,		true,	"ref_no",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"de_yr",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"agmt_cty_cd",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"agmt_seq",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"vndr_abbr_nm",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		55,	daCenter,	true,	"cntr_tpsz_cd",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"del_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"vndr_lgl_eng_nm",false,"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,	90,	daCenter,	true,	"mft_vndr_seq",	false,"",	dfNone);
 					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	false,	"rslt_tp",		false,	"",	dfNone);
 					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_01",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_02",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_03",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	false,	"frst_qurt_tot",false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_04",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_05",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_06",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	false,	"scnd_qurt_tot",false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_07",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_08",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_09",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	false,	"thrd_qurt_tot",false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_10",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_11",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		45,	daRight,	false,	"mnth_12",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	false,	"frth_qurt_tot",false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	false,	"yr_tot",		false,	"", dfNone);
					InitDataProperty(0, cnt++ , dtHidden,	70,	daCenter,	true,	"rslt_tp_seq",	false,	"",	dfNone);

					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					//CountPosition = 0;
 					//EditableColorDiff = false;
 				}
 				break;

			case "sheet2":
				with (sheetObj) {

					// 높이 설정
					style.height = 220;

					//전체 너비 설정
					SheetWidth = sheetTable2.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Seq.|CNTR No.|TP/SZ|Lease Term|On-hire Date|On-hire Yard|F/Days|Off-hire Date|Off-hire Yard|Used Days|Min On-hire Days";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtDataSeq,		50,		daCenter,	true,	"Seq");
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"cntr_no",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"lstm_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"onhire_dt",		false,	"",	dfDateYmd);
 					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	"onhire_loc_cd",	false,	"",	dfNone);
 					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"free_dys",			false,	"",	dfNullInteger);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	false,	"offhire_dt",		false,	"",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	false,	"offhire_loc_cd",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"used_dys",			false,	"",	dfNullInteger);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"min_onhire_dys",	false,	"",	dfNullInteger);

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					//CountPosition = 0;
				}
 				break;
			}
 		}

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	    	case "combo1":
	        	with(comboObj) {
	            	DropHeight = 250;
	            	MultiSelect = true;
	            	//MaxSelect = 1;
	            	MultiSeparator = ",";
	            	Style = 0;
             		UseAutoComplete = true;
             		//영문+특수문자 - 달력
             		ValidChar(1,2);
	        	}
	        	break;
	        case "combo2":
	        	with(comboObj) {
	            	DropHeight = 250;
	            	MultiSelect = true;
	            	//MaxSelect = 1;
	            	MultiSeparator = ",";
	            	Style = 0;
             		UseAutoComplete = true;
             		//영문(대)+특수문자,숫자 - Vender
             		ValidChar(2,3);
	        	}
	        	break;
	        case "combo3":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = true;
	            	//MaxSelect = 1;
	            	MultiSeparator = ",";
	            	Style = 0;
             		UseAutoComplete = true;
             		//영문(대)+특수문자,숫자 - TP/SZ
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

	        	//Plan Month Combo Item Setting Start */
	        	var strText = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
	        	var strCode = "01|02|03|04|05|06|07|08|09|10|11|12";
	        	comboObjects[0].InsertItem(0 , 'ALL','');
	        	LseComText2ComboItem(comboObjects[0], strText, strCode, "|");

	        	//Manufacturer Vendor Combo Item Setting
				formObj.f_cmd.value = SEARCH09;
				var sXml_1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));

				//Container Type/Size Combo Item Setting Start
				formObj.f_cmd.value = SEARCH02;
				var sXml_2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        sheetObj.WaitImageVisible = true;

				if(sXml_1 != "") {
					comboObjects[1].InsertItem(0 , 'ALL','');
					LseComXml2ComboItem(sXml_1, comboObjects[1], "vndr_abbr_nm", "vndr_seq", "|");
					vMftVndrSeq = ComGetEtcData(sXml_1, "vndr_seq");
				}
	            if ( sXml_2 != "" ) {
	            	comboObjects[2].InsertItem(0 , 'ALL','');
	            	LseComXml2ComboItem(sXml_2, comboObjects[2], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	vOrcCntrTpszCd = ComGetEtcData(sXml_2, "cntr_tpsz_cd");
	            }

	            break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						//Lease Plan Month
						formObj.pln_mon_cd.value = ComGetObjValue(comboObjects[0]);
						formObj.mft_vndr_seq.value = ComGetObjValue(comboObjects[1]);

						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("EES_LSE_0037GS.do", FormQueryString(formObj));
						ComOpenWait(false);

						if ( sXml != "" ) {
							var comboVal = ComGetObjValue(comboObjects[0]);

							if ( comboVal != "" )
							{
								for ( var i = 1 ; i <= 12 ; i++ ) {
									eval('sheetObj.ColHidden("mnth_'+ ComLpad(i, 2, "0") + '") = true;');
								}
								sheetObj.ColHidden("frst_qurt_tot") = true;
								sheetObj.ColHidden("scnd_qurt_tot") = true;
								sheetObj.ColHidden("thrd_qurt_tot") = true;
								sheetObj.ColHidden("frth_qurt_tot") = true;

								var arrComboVal = comboVal.split(",");

								for ( var i = 0 ; i < arrComboVal.length ; i++ ) {
									switch(arrComboVal[i]) {
										case "01" :
											sheetObj.ColHidden("mnth_01")       = false;
											sheetObj.ColHidden("frst_qurt_tot") = false;
											break;
										case "02" :
											sheetObj.ColHidden("mnth_02")       = false;
											sheetObj.ColHidden("frst_qurt_tot") = false;
											break;
										case "03" :
											sheetObj.ColHidden("mnth_03")       = false;
											sheetObj.ColHidden("frst_qurt_tot") = false;
											break;
										case "04" :
											sheetObj.ColHidden("mnth_04")       = false;
											sheetObj.ColHidden("scnd_qurt_tot") = false;
											break;
										case "05" :
											sheetObj.ColHidden("mnth_05")       = false;
											sheetObj.ColHidden("scnd_qurt_tot") = false;
											break;
										case "06" :
											sheetObj.ColHidden("mnth_06")       = false;
											sheetObj.ColHidden("scnd_qurt_tot") = false;
											break;
										case "07" :
											sheetObj.ColHidden("mnth_07")       = false;
											sheetObj.ColHidden("thrd_qurt_tot") = false;
											break;
										case "08" :
											sheetObj.ColHidden("mnth_08")       = false;
											sheetObj.ColHidden("thrd_qurt_tot") = false;
											break;
										case "09" :
											sheetObj.ColHidden("mnth_09")       = false;
											sheetObj.ColHidden("thrd_qurt_tot") = false;
											break;
										case "10" :
											sheetObj.ColHidden("mnth_10")       = false;
											sheetObj.ColHidden("frth_qurt_tot") = false;
											break;
										case "11" :
											sheetObj.ColHidden("mnth_11")       = false;
											sheetObj.ColHidden("frth_qurt_tot") = false;
											break;
										case "12" :
											sheetObj.ColHidden("mnth_12")       = false;
											sheetObj.ColHidden("frth_qurt_tot") = false;
											break;
											break;
									}
								}
							} else {
								for ( var i = 1 ; i <= 12 ; i++ ) {
									eval('sheetObj.ColHidden("mnth_'+ ComLpad(i, 2, "0") + '") = false;');
								}
								sheetObj.ColHidden("frst_qurt_tot") = false;
								sheetObj.ColHidden("scnd_qurt_tot") = false;
								sheetObj.ColHidden("thrd_qurt_tot") = false;
								sheetObj.ColHidden("frth_qurt_tot") = false;
							}

							sheetObj.Redraw = false;
							sheetObj.LoadSearchXml(sXml);

							for ( var idx = sheetObj.HeaderRows ; idx <= sheetObj.SearchRows ; idx++ ) {
								if ( sheetObj.CellValue(idx, "rslt_tp_seq") == "3" ) {
									if ( sheetObj.CellValue(idx-2,"frst_qurt_tot") != 0 ) {
										sheetObj.CellValue(idx,"frst_qurt_tot") = Math.round(sheetObj.CellValue(idx-1,"frst_qurt_tot")/sheetObj.CellValue(idx-2,"frst_qurt_tot")*100);
									}
									if ( sheetObj.CellValue(idx-2,"scnd_qurt_tot") != 0 ) {
										sheetObj.CellValue(idx,"scnd_qurt_tot") = Math.round(sheetObj.CellValue(idx-1,"scnd_qurt_tot")/sheetObj.CellValue(idx-2,"scnd_qurt_tot")*100);
									}
									if ( sheetObj.CellValue(idx-2,"thrd_qurt_tot") != 0 ) {
										sheetObj.CellValue(idx,"thrd_qurt_tot") = Math.round(sheetObj.CellValue(idx-1,"thrd_qurt_tot")/sheetObj.CellValue(idx-2,"thrd_qurt_tot")*100);
									}
									if ( sheetObj.CellValue(idx-2,"frth_qurt_tot") != 0 ) {
										sheetObj.CellValue(idx,"frth_qurt_tot") = Math.round(sheetObj.CellValue(idx-1,"frth_qurt_tot")/sheetObj.CellValue(idx-2,"frth_qurt_tot")*100);
									}
									if ( sheetObj.CellValue(idx-2,"yr_tot") != 0 ) {
										sheetObj.CellValue(idx,"yr_tot") = Math.round(sheetObj.CellValue(idx-1,"yr_tot")/sheetObj.CellValue(idx-2,"yr_tot")*100);
									}

									//S.TTL 및 G.TTL에 대한 비율계산 추가
									if(sheetObj.CellValue(idx, "de_yr") == "G.TTL" || sheetObj.CellValue(idx, "vndr_abbr_nm") == "S.TTL" ) {
										for ( var i = 1 ; i <= 12 ; i++ ) {
											var vPlan = eval('sheetObj.CellValue(idx-2,"mnth_'+ ComLpad(i, 2, "0") + '")');
											var vPfmc = eval('sheetObj.CellValue(idx-1,"mnth_'+ ComLpad(i, 2, "0") + '")');

											if ( vPlan != 0 ) {
												var vRatio = (vPfmc / vPlan * 100).toFixed(2);
												eval('sheetObj.CellValue(idx,"mnth_'+ ComLpad(i, 2, "0") + '") = '+ vRatio +';');
											}
										}
									}
								}
							}

							for ( var idx = sheetObj.HeaderRows ; idx <= sheetObj.SearchRows ; idx++ ) {
								for(var i = 0; i < sheetObj.LastCol; i++) {
									switch(sheetObj.ColSaveName(i)) {
										case "mnth_01": case "mnth_02": case "mnth_03": case "frst_qurt_tot":
										case "mnth_04": case "mnth_05": case "mnth_06": case "scnd_qurt_tot":
										case "mnth_07": case "mnth_08": case "mnth_09": case "thrd_qurt_tot":
										case "mnth_10": case "mnth_11": case "mnth_12": case "frth_qurt_tot":
										case "yr_tot":
											var vCommaValue = Number(sheetObj.CellValue(idx, i));
											//비율계산에 대한 '%' 기호추가
											if ( sheetObj.CellValue(idx, "rslt_tp_seq") == "3" ) {
												sheetObj.CellValue(idx, i) = ComGetMaskedValue(vCommaValue, "float");
												sheetObj.CellValue(idx, i) += "%";
											} else {
												sheetObj.CellValue(idx, i) = ComGetMaskedValue(vCommaValue, "int");
											}
											break;
										default : //do nothing
									}
								}
							}
							sheetObj.Redraw = true;
						}
					}
				}
				break;

 			case IBSEARCH_ASYNC01:	//조회(Form Agreement No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						formObj.f_cmd.value = SEARCH03;
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
 						sheetObj.WaitImageVisible = true;

 						if ( sXml != "" ) {
	 						if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
	 							if ( /OW|LP|OL/.test(ComGetEtcData(sXml, "lstm_cd")) ) {
		 							formObj.lstm_cd.value = ComGetEtcData(sXml, "lstm_cd");
		 						} else {
		 							ComShowCodeMessage("LSE01068");
		 							clearForm("agmt_seq");
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								clearForm("agmt_seq");
 								ComSetFocus(formObj.agmt_seq);
 							}
 						}
 					}
 				}
 				break;

 			case IBSEARCH_ASYNC03:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						formObj.f_cmd.value = SEARCH05;
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
									formObj.loc_cd.value = vLocCd;
									ComSetFocus(formObj.loc_cd);
								} else {
									ComShowCodeMessage("LSE01037");
									formObj.loc_cd.value = "";
									ComSetFocus(formObj.loc_cd);
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								formObj.loc_cd.value = "";
								ComSetFocus(formObj.loc_cd);
							}
						}
					}
				}

 				break;
		}
	}

	/**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			//마우스 위치를 행과 컬럼과 값 가져오기
			Row = MouseRow;
			Col = MouseCol;
			if(Row >= HeaderRows && ColSaveName(Col) == "vndr_abbr_nm") {
				sText = CellText(Row,Col);
				//풍선도움말 만들기
				MouseToolTipText = CellText(Row,"vndr_lgl_eng_nm");
			} else {
				MouseToolTipText = "";
			}

			var isFlag = CellValue(Row, "de_yr") != "G.TTL" && CellValue(Row, "vndr_abbr_nm") != "S.TTL";
			DataLinkMouse("agmt_no") = isFlag;
			DataLinkMouse("de_yr") = isFlag;
			DataLinkMouse("vndr_abbr_nm") = isFlag;
			DataLinkMouse("del_cd") = isFlag;
			DataLinkMouse("cntr_tpsz_cd") = isFlag;
			DataLinkMouse("mnth_01") = isFlag;
			DataLinkMouse("mnth_02") = isFlag;
			DataLinkMouse("mnth_03") = isFlag;
			DataLinkMouse("mnth_04") = isFlag;
			DataLinkMouse("mnth_05") = isFlag;
			DataLinkMouse("mnth_06") = isFlag;
			DataLinkMouse("mnth_07") = isFlag;
			DataLinkMouse("mnth_08") = isFlag;
			DataLinkMouse("mnth_09") = isFlag;
			DataLinkMouse("mnth_10") = isFlag;
			DataLinkMouse("mnth_11") = isFlag;
			DataLinkMouse("mnth_12") = isFlag;
		}
	}

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col)
		var vDeMon = "";
		var param = "";

		switch (sName) {
			case "mnth_01":
			case "mnth_02":
			case "mnth_03":
			case "mnth_04":
			case "mnth_05":
			case "mnth_06":
			case "mnth_07":
			case "mnth_08":
			case "mnth_09":
			case "mnth_10":
			case "mnth_11":
			case "mnth_12":
				param = "&de_mon=" + sName.substr(5,2)
					  + "&onhire_loc_cd=" + sheetObj.CellValue(Row,"del_cd")
					  + "&cntr_tpsz_cd="  + sheetObj.CellValue(Row,"cntr_tpsz_cd")
					  + "&mft_vndr_seq="  + sheetObj.CellValue(Row,"mft_vndr_seq")
					  + "&de_yr=" + sheetObj.CellValue(Row,"de_yr");

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = "Plan Year Month : "+ sheetObj.CellValue(Row,"pln_yrmon")
							+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.CellValue(Row, "agmt_no")
						   	+ ",&nbsp;&nbsp;Del. Year : "+ sheetObj.CellValue(Row, "de_yr")
						   	+ ",&nbsp;&nbsp;Manufacturer : "+ sheetObj.CellValue(Row, "vndr_abbr_nm")
						   	+ ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.CellValue(Row, "cntr_tpsz_cd")
						   	+ ",&nbsp;&nbsp;LCC : "+ sheetObj.CellValue(Row, "del_cd")
						   	+ ",&nbsp;&nbsp;Del. Month : "+ sheetObj.CellText(0, Col);
				}
				break;

			case "del_cd":
				param = "&de_mon=" + ComGetObjValue(formObj.hcond_mon_cd)
					  + "&onhire_loc_cd=" + sheetObj.CellValue(Row,"del_cd")
					  + "&cntr_tpsz_cd="  + sheetObj.CellValue(Row,"cntr_tpsz_cd")
					  + "&mft_vndr_seq="  + sheetObj.CellValue(Row,"mft_vndr_seq")
					  + "&de_yr=" + sheetObj.CellValue(Row,"de_yr");

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = "Plan Year Month : "+ sheetObj.CellValue(Row,"pln_yrmon")
							+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.CellValue(Row, "agmt_no")
						   	+ ",&nbsp;&nbsp;Del. Year : "+ sheetObj.CellValue(Row, "de_yr")
						   	+ ",&nbsp;&nbsp;Manufacturer : "+ sheetObj.CellValue(Row, "vndr_abbr_nm")
						   	+ ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.CellValue(Row, "cntr_tpsz_cd")
						   	+ ",&nbsp;&nbsp;LCC : "+ sheetObj.CellValue(Row, "del_cd");
				}
				break;

			case "cntr_tpsz_cd":
				param = "&de_mon=" + ComGetObjValue(formObj.hcond_mon_cd)
					  + "&onhire_loc_cd=" + ComGetObjValue(formObj.hcond_params)
					  + "&cntr_tpsz_cd="  + sheetObj.CellValue(Row,"cntr_tpsz_cd")
					  + "&mft_vndr_seq="  + sheetObj.CellValue(Row,"mft_vndr_seq")
					  + "&de_yr=" + sheetObj.CellValue(Row,"de_yr");

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = "Plan Year Month : "+ sheetObj.CellValue(Row,"pln_yrmon")
						   	+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.CellValue(Row, "agmt_no")
						   	+ ",&nbsp;&nbsp;Del. Year : "+ sheetObj.CellValue(Row, "de_yr")
						   	+ ",&nbsp;&nbsp;Manufacturer : "+ sheetObj.CellValue(Row, "vndr_abbr_nm")
						   	+ ",&nbsp;&nbsp;TP/SZ : "+ sheetObj.CellValue(Row, "cntr_tpsz_cd");
				}
				break;

			case "vndr_abbr_nm":
				param = "&de_mon=" + ComGetObjValue(formObj.hcond_mon_cd)
					  + "&onhire_loc_cd=" + ComGetObjValue(formObj.hcond_params)
					  + "&cntr_tpsz_cd="  + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&mft_vndr_seq="  + sheetObj.CellValue(Row,"mft_vndr_seq")
					  + "&de_yr=" + sheetObj.CellValue(Row,"de_yr");

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = "Plan Year Month : "+ sheetObj.CellValue(Row,"pln_yrmon")
							+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.CellValue(Row, "agmt_no")
						   	+ ",&nbsp;&nbsp;Del. Year : "+ sheetObj.CellValue(Row, "de_yr")
						   	+ ",&nbsp;&nbsp;Manufacturer : "+ sheetObj.CellValue(Row, "vndr_abbr_nm");
				}
				break;
			case "de_yr":
				param = "&de_mon=" + ComGetObjValue(formObj.hcond_mon_cd)
					  + "&onhire_loc_cd=" + ComGetObjValue(formObj.hcond_params)
					  + "&cntr_tpsz_cd="  + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&mft_vndr_seq="  + ComGetObjValue(formObj.hcond_vndr_seq)
					  + "&de_yr=" + sheetObj.CellValue(Row,"de_yr");

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = "Plan Year Month : "+ sheetObj.CellValue(Row,"pln_yrmon")
							+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.CellValue(Row, "agmt_no")
						   	+ ",&nbsp;&nbsp;Del. Year : "+ sheetObj.CellValue(Row, "de_yr");
				}
				break;
			case "agmt_no":
				param = "&onhire_loc_cd=" + ComGetObjValue(formObj.hcond_params)
					  + "&cntr_tpsz_cd="  + ComGetObjValue(formObj.hcond_tpsz_cd)
					  + "&mft_vndr_seq="  + ComGetObjValue(formObj.hcond_vndr_seq);

				if(sheetObj.MousePointer == "Hand") {
					dcondTD.innerHTML = "Plan Year Month : "+ sheetObj.CellValue(Row,"pln_yrmon")
							+ ",&nbsp;&nbsp;AGMT No : "+ sheetObj.CellValue(Row, "agmt_no");
				}
				break;

		}

		var isFlag = sheetObj.CellValue(Row, "de_yr") != "G.TTL"
				  && sheetObj.CellValue(Row, "vndr_abbr_nm") != "S.TTL";

		if ( param != "" && isFlag == true) {
			param = "f_cmd=" + SEARCH04 + param
				  + "&agmt_cty_cd=" + sheetObj.CellValue(Row,"agmt_cty_cd")
	              + "&agmt_seq=" + sheetObj.CellValue(Row,"agmt_seq")
	              + "&pln_yrmon=" + sheetObj.CellValue(Row,"pln_yrmon");
			//alert(param);
			sheetObjects[1].WaitImageVisible = false;
			ComOpenWait(true);
			sheetObjects[1].doSearch4Post("EES_LSE_0037GS.do",param);
			ComOpenWait(false);
		}
	}

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		with(sheetObj) {
			/*
			//소계 Title Merge 처리
			var strRows = ComFindAll(sheetObj, "vndr_abbr_nm", "S.TTL");
			var arrStrRows = strRows.split("|");
			for ( var i = 0 ; i < arrStrRows.length ; i++ ) {
				if ( i%3 == 0 ) {
					SetMergeCell(arrStrRows[i], 6, 3, 2);
				}
			}

			//합계 Title Merge 처리
			var strRows2 = ComFindAll(sheetObj, "de_yr", "G.TTL");
			var arrStrRows2 = strRows2.split("|");
			for ( var i = 0 ; i < arrStrRows2.length ; i++ ) {
				if ( i%3 == 0 ) {
					SetMergeCell(arrStrRows2[i], 2, 3, 6);
				}
			}
			*/

	    	ColBackColor("frst_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("scnd_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("thrd_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("frth_qurt_tot") = LSE_TOTCOL_BACK_COLOR;
			ColBackColor("yr_tot") = LSE_TOTCOL_BACK_COLOR;

			for(var i = 0; i <= SearchRows; i++) {
				if(CellValue(i, "de_yr") == "G.TTL" || CellValue(i, "vndr_abbr_nm") == "S.TTL" ) {
					RowBackColor(i) = LSE_TOTCOL_BACK_COLOR;
				}
			}

			var formObj = document.form;
			formObj.hcond_mon_cd.value = ComGetObjValue(formObj.pln_mon_cd);
			formObj.hcond_vndr_seq.value = ComGetObjValue(formObj.mft_vndr_seq);
			formObj.hcond_tpsz_cd.value = ComGetObjValue(formObj.cntr_tpsz_cd);
			formObj.hcond_params.value = "&loc_cd=" + ComGetObjValue(formObj.loc_cd)
					  				   + "&loc_tp=" + ComGetObjValue(formObj.loc_tp);
		}
    }

	/**
	 * combo1_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.pln_mon_cd.value = ComGetObjValue(comboObj);
	}

    /**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.mft_vndr_seq.value = ComGetObjValue(comboObj);
	}

	/**
	 * combo3_OnBlur
	 */
	function combo3_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
	}

	/**
	 * combo1_OnKeyDown
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.pln_mon_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}

	/**
	 * combo2_OnKeyDown
	 */
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.mft_vndr_seq.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}

	/**
	 * combo3_OnKeyDown
	 */
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if ( KeyCode == 8 || KeyCode == 46 ) {
				for ( var i = 0 ; i < GetCount() ; i++ ) {
					if ( CheckIndex(i) ) {
						//CheckIndex(i) = false;
					}
				}
			} else if(KeyCode == 13) {
				formObj.cntr_tpsz_cd.value = ComGetObjValue(comboObj);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function combo1_OnCheckClick(comboObj, index, code) {
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
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function combo2_OnCheckClick(comboObj, index, code) {
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
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function combo3_OnCheckClick(comboObj, index, code) {
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
     * Pop-up Open 부분<br>
     * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
     * @param object 대상 Object
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		switch(formObj.loc_tp.value) {
    			case "RCC" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "LCC" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "SCC" :	//SCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}

    	} else if ( type == "2" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	}
    }

     /**
      * Agreement Pop-up Return Value 처리 부분<br>
      * @param {arry} returnedValues Pop-up 화면의 Return value array
      * @param Row 대상Object가 IBSheet일 경우 해당 Row index
      * @param Col 대상Object가 IBSheet일 경우 해당 Col index
      * @param 대상IBSheet의 Sheet Array index
      */
     function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj = sheetObjects[SheetIdx];
     	var formObj  = document.form;

     	if ( aryPopupData.length > 0 ) {
     		if(/OW|LP|OL/.test(aryPopupData[0][6])) {
     			formObj.agmt_seq.value = aryPopupData[0][4];
 				formObj.lstm_cd.value  = aryPopupData[0][6];
     		} else {
 	    		ComShowCodeMessage("LSE01068");
 	    		clearForm("agmt_seq");
 	    	}
     	}
     }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
	    	with(formObj){
	    		switch(sAction) {
	    			case IBSEARCH:      //조회
		    			if ( formObj.pln_yrmon.value == "" ) {
							ComShowCodeMessage("LSE01036");
							ComSetFocus(formObj.pln_yrmon);
							return false;
							break;
						}
	    				return ComChkValid(formObj, false);
	    				break;
	    		}
	    	}
		}

		return true;
	}

    /**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName)
	{
		var formObj = document.form;
		switch(fieldName) {
			case "agmt_seq":
				formObj.agmt_seq.value     = "";
				formObj.lstm_cd.value      = "";
				break;
		}
	}
	/* 개발자 작업  끝 */