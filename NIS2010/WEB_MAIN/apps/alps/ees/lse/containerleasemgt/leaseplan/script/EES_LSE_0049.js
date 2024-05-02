/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0049.js
*@FileTitle : Long Term Lease CNTR Delivery Plan & Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
 * ======================================================
 * 2010.12.01 박명신 [CHM-201007443-01] REF_NO 항목 추가
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
	 * @class ees_lse_0049 : ees_lse_0049 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0049() {
		this.processButtonClick			= processButtonClick;
		this.setSheetObject 			= setSheetObject;
		this.setComboObject 			= setComboObject;
		this.loadPage 					= loadPage;
		this.initControl            	= initControl;
		this.obj_blur					= obj_blur;
		this.obj_focus					= obj_focus;
		this.obj_change					= obj_change;
		this.obj_keypress				= obj_keypress;
		this.obj_keyup					= obj_keyup;
		this.obj_keydown				= obj_keydown;
		this.initSheet 					= initSheet;
		this.initCombo 					= initCombo;
		this.doActionIBSheet 			= doActionIBSheet;
		this.sheet1_OnLoadFinish		= sheet1_OnLoadFinish;
		this.sheet1_OnSearchEnd			= sheet1_OnSearchEnd;
		this.sheet1_OnDblClick			= sheet1_OnDblClick;
		this.de_mon_OnCheckClick		= de_mon_OnCheckClick;
		this.de_mon_OnKeyDown			= de_mon_OnKeyDown;
		this.cntr_tpsz_cd_OnCheckClick	= cntr_tpsz_cd_OnCheckClick;
		this.cntr_tpsz_cd_OnKeyDown		= cntr_tpsz_cd_OnKeyDown;
		this.openPopup					= openPopup;
		this.setPopData_DeliveryLoc		= setPopData_DeliveryLoc;
		this.setPopData_Agreement		= setPopData_Agreement;
		this.setPopData_Lessor			= setPopData_Lessor;
		this.validateForm 				= validateForm;
		this.clearForm 					= clearForm;
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

   	var LONG_TERM_CD = "LT";

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
					sheetObjects[1].RemoveAll();
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

				case "btn_New":
					ComResetAll();
					ComSetFocus(formObj.pln_yr);
					comboObjects[0].Index = 0;
					comboObjects[1].Index = 0;
					break;

				case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1)
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

				case "btns_search3":
					// Lessor Search
					openPopup("3");
					break;

				case "loc_tp":
					if ( ComGetObjValue(srcObj) != vOrgLocTp ) {
						vOrgLocTp = ComGetObjValue(srcObj);
						ComSetObjValue(srcObj, "");
						ComSetFocus(srcObj);
					}
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

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
			initCombo(comboObjects[k], k+1);
		}

		/* IBSheet 초기화 */
		for( var i = 0 ; i < sheetObjects.length ; i++ ) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);

			//khlee-마지막 환경 설정 함수 추가
 			ComEndConfigSheet(sheetObjects[i]);
 		}

		/* Axon Control Setting*/
		initControl();

		/* 초기 Value Setting */
		/*
		if ( formObj.loc_tp[0].checked ) {
			vOrgLocTp = formObj.loc_tp[0].value;
		} else if ( formObj.loc_tp[1].checked ) {
			vOrgLocTp = formObj.loc_tp[1].value;
		} else if ( formObj.loc_tp[2].checked ) {
			vOrgLocTp = formObj.loc_tp[2].value;
		}
		*/
		vOrgLocTp = ComGetObjValue(formObj.loc_tp);
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

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;

	    switch(obj.name){
	    	case "pln_yr":
	        case "agmt_seq":
	        case "mft_vndr_seq":
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
	    		case "loc_cd":
	    			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	    			break;

	    		case "agmt_seq":
	    			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
					break;

	    		case "mft_vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
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
			case "pln_yr":
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

 			case "mft_vndr_seq":
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
   			ComSetNextFocus(obj);
   			if ( ComGetObjValue(formObj.lstm_cd) == LONG_TERM_CD ) {
   				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   			}
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
					style.height = 300;

					//전체 너비 설정
					SheetWidth = sheetTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 3, 3, 100);

					var HeadTitle1 = "Plan Year|Del. Year|AGMT No.|Ref No.|Lessor|Delivery LOC(LCC)|TP/SZ|Result|JAN|FEB|MAR|1/4 QTA|APR|MAY|JUN|2/4 QTA|JUL|AUG|SEP|3/4 QTA|OCT|NOV|DEC|4/4 QTA|G.TTL|";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 8, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					for(var i = 0; i < 3; i ++) {
    					cnt = 0;
						// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(i, cnt++ , dtData,		65,	daCenter,	true,	"pln_yr",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		65,	daCenter,	true,	"de_yr",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		80,	daCenter,	true,	"agmt_no",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		80,	daLeft,		true,	"ref_no",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		55,	daCenter,	true,	"vndr_abbr_nm",	false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,	   110,	daCenter,	true,	"del_cd",		false,	"",	dfNone);

						InitDataProperty(i, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd",	false,	"",	dfNone);
	 					InitDataProperty(i, cnt++ , dtData,		55,	daCenter,	false,	"rslt_tp",		false,	"",	dfNone);

	 					InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_01",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_02",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_03",		false,	"",	dfNone);

						InitDataProperty(i, cnt++ , dtData,		60,	daRight,	false,	"frst_qurt_tot",false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_04",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_05",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_06",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		60,	daRight,	false,	"scnd_qurt_tot",false,	"",	dfNone);

						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_07",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_08",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_09",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		60,	daRight,	false,	"thrd_qurt_tot",false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_10",		false,	"",	dfNone);

						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_11",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		45,	daRight,	false,	"mnth_12",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		60,	daRight,	false,	"frth_qurt_tot",false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,		60,	daRight,	false,	"yr_tot",		false,	"", dfNone);
						InitDataProperty(i, cnt++ , dtHidden,	70,	daCenter,	true,	"rslt_tp_seq",	false,	"",	dfNone);
					}

					/*
					cnt = 0
					InitDataProperty(1, cnt++ , dtData,		65,	daCenter,	true,	"pln_yr",		false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		65,	daCenter,	true,	"de_yr",		false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		80,	daCenter,	true,	"agmt_no",		false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,		55,	daCenter,	true,	"vndr_abbr_nm",	false,	"",	dfNone);
					InitDataProperty(1, cnt++ , dtData,    110,	daCenter,	true,	"del_cd",		false,	"",	dfNone);

					InitDataProperty(1, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd",	false,	"",	dfNone);
 					InitDataProperty(1, cnt++ , dtData,		55,	daCenter,	false,	"rslt_tp",		false,	"",	dfNone);
 					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_01",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_02",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_03",		false,	"",	dfInteger);

					InitDataProperty(1, cnt++ , dtData,		60,	daRight,	false,	"frst_qurt_tot",false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_04",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_05",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_06",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		60,	daRight,	false,	"scnd_qurt_tot",false,	"",	dfInteger);

					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_07",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_08",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_09",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		60,	daRight,	false,	"thrd_qurt_tot",false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_10",		false,	"",	dfInteger);

					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_11",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		45,	daRight,	false,	"mnth_12",		false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		60,	daRight,	false,	"frth_qurt_tot",false,	"",	dfInteger);
					InitDataProperty(1, cnt++ , dtData,		60,	daRight,	false,	"yr_tot",		false,	"", dfInteger);
					InitDataProperty(1, cnt++ , dtHidden,	70,	daCenter,	true,	"rslt_tp_seq",	false,	"",	dfNone);

					cnt = 0
					InitDataProperty(2, cnt++ , dtData,		65,	daCenter,	true,	"pln_yr",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		65,	daCenter,	true,	"de_yr",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		80,	daCenter,	true,	"agmt_no",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		55,	daCenter,	true,	"vndr_abbr_nm",	false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,    110,	daCenter,	true,	"del_cd",		false,	"",	dfNone);

					InitDataProperty(2, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd",	false,	"",	dfNone);
 					InitDataProperty(2, cnt++ , dtData,		55,	daCenter,	false,	"rslt_tp",		false,	"",	dfNone);
 					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_01",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_02",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_03",		false,	"",	dfNone);

					InitDataProperty(2, cnt++ , dtData,		60,	daRight,	false,	"frst_qurt_tot",false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_04",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_05",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_06",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		60,	daRight,	false,	"scnd_qurt_tot",false,	"",	dfNone);

					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_07",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_08",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_09",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		60,	daRight,	false,	"thrd_qurt_tot",false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_10",		false,	"",	dfNone);

					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_11",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		45,	daRight,	false,	"mnth_12",		false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		60,	daRight,	false,	"frth_qurt_tot",false,	"",	dfNone);
					InitDataProperty(2, cnt++ , dtData,		60,	daRight,	false,	"yr_tot",		false,	"", dfNone);
					InitDataProperty(2, cnt++ , dtHidden,	70,	daCenter,	true,	"rslt_tp_seq",	false,	"",	dfNone);
					*/
					DataLinkMouse("agmt_no") = true;
					DataLinkMouse("vndr_abbr_nm") = true;
					DataLinkMouse("del_cd") = true;
					DataLinkMouse("cntr_tpsz_cd") = true;
					DataLinkMouse("mnth_01") = true;
					DataLinkMouse("mnth_02") = true;
					DataLinkMouse("mnth_03") = true;
					DataLinkMouse("mnth_04") = true;
					DataLinkMouse("mnth_05") = true;
					DataLinkMouse("mnth_06") = true;
					DataLinkMouse("mnth_07") = true;
					DataLinkMouse("mnth_08") = true;
					DataLinkMouse("mnth_09") = true;
					DataLinkMouse("mnth_10") = true;
					DataLinkMouse("mnth_11") = true;
					DataLinkMouse("mnth_12") = true;

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					//CountPosition = 0;
 				}
 				break;

			case "sheet2":
				with (sheetObj) {

					// 높이 설정
					style.height = 300;

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

					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"onhire_dt",		false,	"",	dfDateYmd);
 					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"onhire_loc_cd",	false,	"",	dfNone);
 					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"free_dys",			false,	"",	dfNullInteger);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"offhire_dt",		false,	"",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"offhire_loc_cd",	false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"used_dys",			false,	"",	dfNullInteger);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	false,	"min_onhire_dys",	false,	"",	dfNullInteger);

 					//CountFormat = "[SELECTDATAROW / TOTALROWS]";
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
	        case "de_mon":
	        	with(comboObj) {
	            	DropHeight = 250;
	            	MultiSelect = true;
	            	UseAutoComplete = true;
	            	ValidChar(1,2);
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

				/* Plan Month Combo Item Setting Start */
	        	//var strText = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
	        	//var strCode = "01|02|03|04|05|06|07|08|09|10|11|12";
	        	//LseComText2ComboItem(comboObjects[0], strText, strCode, "|");
				comboObjects[0].InsertItem(0,  "ALL", "");
				comboObjects[0].InsertItem(1,  "Jan", "01");
				comboObjects[0].InsertItem(2,  "Feb", "02");
				comboObjects[0].InsertItem(3,  "Mar", "03");
				comboObjects[0].InsertItem(4,  "Apr", "04");
				comboObjects[0].InsertItem(5,  "May", "05");
				comboObjects[0].InsertItem(6,  "Jun", "06");
				comboObjects[0].InsertItem(7,  "Jul", "07");
				comboObjects[0].InsertItem(8,  "Aug", "08");
				comboObjects[0].InsertItem(9,  "Sep", "09");
				comboObjects[0].InsertItem(10, "Oct", "10");
				comboObjects[0].InsertItem(11, "Nov", "11");
				comboObjects[0].InsertItem(12, "Dec", "12");
				comboObjects[0].Index = 0;

				/* Container Type/Size Combo Item Setting Start */
	        	ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

	            if ( sXml != "" ) {
	            	comboObjects[1].InsertItem(0, 'ALL','');
	            	LseComXml2ComboItem(sXml, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	comboObjects[1].Index = 0;
	            	vOrcCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
	            }

	            /* 초기 Focus Setting */
	    		ComSetFocus(formObj.pln_yr);
	            sheetObj.WaitImageVisible = true;
	            break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						ComSetObjValue(formObj.f_cmd, SEARCH);

						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("EES_LSE_0049GS.do", FormQueryString(formObj));
						ComOpenWait(false);

						if ( sXml != "" ) {
							var comboVal = ComGetObjValue(comboObjects[0]);

							if ( comboVal != "" ) {
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

							//for ( var idx = 0 ; idx <= sheetObj.SearchRows ; idx++ ) {
							for ( var idx = sheetObj.HeaderRows ; idx <= sheetObj.LastRow ; idx++ ) {
								//if ( sheetObj.CellValue(idx, "rslt_tp_seq") == "3" ) {
									//비율계산에 대한 '%' 기호추가
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
												}  else {
													sheetObj.CellValue(idx, i) = ComGetMaskedValue(vCommaValue, "int");
												}

												break;
											default : //do nothing
										}
									}
								//}
							}

							sheetObj.Redraw = true;
						} else {
							sheetObj.LoadSearchXml(sXml);
						}
					}
				}
				break;

 			case IBSEARCH_ASYNC01:	//조회(Form Agreement No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
 						sheetObj.WaitImageVisible = true;

 						if ( sXml != "" ) {
	 						if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
	 							if ( ComGetEtcData(sXml, "lstm_cd") == LONG_TERM_CD ) {
		 							ComSetObjValue(formObj.mft_vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
		 							ComSetObjValue(formObj.mft_vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
		 							ComSetObjValue(formObj.lstm_cd,      ComGetEtcData(sXml, "lstm_cd"));
		 						} else {
		 							ComShowCodeMessage("LSE01057");
		 							clearForm("agmt_seq");
		 							sheetObjects[0].RemoveAll();
		 							sheetObjects[1].RemoveAll();
		 							ComSetFocus(formObj.agmt_seq);
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								clearForm("agmt_seq");
 								sheetObjects[0].RemoveAll();
	 							sheetObjects[1].RemoveAll();
 								ComSetFocus(formObj.agmt_seq);
 							}
 						}
 					}
 				}
 				break;

 			case IBSEARCH_ASYNC02:	//조회(Form Lessor No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH04+"&vndr_seq="+ComGetObjValue(formObj.mft_vndr_seq)+"&lstm_cd=LT";
 						sheetObj.WaitImageVisible = false;
 						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
 						sheetObj.WaitImageVisible = true;

 						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
		 						if ( ComGetEtcData(sXml, "lstm_cd") == LONG_TERM_CD ) {
		 							ComSetObjValue(formObj.mft_vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
		 							ComSetObjValue(formObj.mft_vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
		 							ComSetObjValue(formObj.lstm_cd,      ComGetEtcData(sXml, "lstm_cd"));
		 						} else {
		 							ComShowCodeMessage("LSE01057");
		 							clearForm("mft_vndr_seq");
		 						}
	 						} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								clearForm("mft_vndr_seq");
 								ComSetFocus(formObj.mft_vndr_seq);
 							}
 						}
 					}
 				}
 				break;

 			case IBSEARCH_ASYNC03:	// Location 조회
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

	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if ( ErrMsg != "" ) {
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
		}
	}

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var sName = sheetObj.ColSaveName(Col);
		var vDeMon = "";
		var param  = "";

		if ( !(sheetObj.CellValue(Row, "agmt_no") == "G.TTL" || sheetObj.CellValue(Row, "vndr_abbr_nm") == "S.TTL") ) {
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
				case "mnth_12": param = "&de_mon=" + sName.substr(5,2);

				case "cntr_tpsz_cd":
					param = param + "&cntr_tpsz_cd="  + sheetObj.CellValue(Row,"cntr_tpsz_cd");

				case "del_cd":
					param = param + "&onhire_loc_cd=" + sheetObj.CellValue(Row,"del_cd")

				case "vndr_abbr_nm":
				case "agmt_no":
					param = param + "&agmt_cty_cd=" + sheetObj.CellValue(Row,"agmt_no").substr(0,3)
				                  + "&agmt_seq=" + sheetObj.CellValue(Row,"agmt_no").substr(3,6)
				                  + "&de_yr=" + sheetObj.CellValue(Row,"de_yr")
				                  + "&pln_yr=" + sheetObj.CellValue(Row,"pln_yr");
					break;
			}

			if ( param != "" ) {
				param = "f_cmd=" + SEARCH04 + param;
				sheetObjects[1].WaitImageVisible = false;
				ComOpenWait(true);
				sheetObjects[1].doSearch4Post("EES_LSE_0049GS.do",param);
				ComOpenWait(false);
			}
		}
	}

	/**
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function de_mon_OnCheckClick(comboObj, index, code) {
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
	 * de_mon_OnKeyDown
	 * @deprecated 2009.07.21 IBCombo Single로 현재 사용되지 않는다.
	 */
	function de_mon_OnKeyDown(comboObj, KeyCode, Shift) {
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
	 * cntr_tpsz_cd_OnKeyDown
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
     * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
     * @param object 대상 Object
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', false, false, Row, Col, 0);
    	} else if ( type == "2" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "3" ) {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
    	}
    }

     /**
     * Location Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
    		if ( formObj.loc_tp[0].checked ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][13]);	// RCC
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][11]);	// 2009.10.13 RCC
    		} else if ( formObj.loc_tp[1].checked ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][12]);	// LCC
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][10]);	// 2009.10.13 LCC
    		} else if ( formObj.loc_tp[2].checked ) {
    			//ComSetObjValue(formObj.loc_cd, aryPopupData[0][10]);	// SCC
    			ComSetObjValue(formObj.loc_cd, aryPopupData[0][8]);		// 2009.10.13 SCC
    		}
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
 	    	if ( aryPopupData[0][6] == LONG_TERM_CD ) {
 	    		ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
 	    		ComSetObjValue(formObj.mft_vndr_seq, aryPopupData[0][7]);
 	    		ComSetObjValue(formObj.mft_vndr_nm,  aryPopupData[0][8]);
 	    		ComSetObjValue(formObj.lstm_cd,      aryPopupData[0][6]);
 	    	} else {
 	    		ComShowCodeMessage("LSE01057");
 	    		clearForm("agmt_seq");
 	    	}
     	}
     }

	/**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
		var sheetObj = sheetObjects[SheetIdx];
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.mft_vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
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
		    			if ( ComGetObjValue(formObj.pln_yr) == "" ) {
							ComShowCodeMessage("LSE01036");
							ComSetFocus(formObj.pln_yr);
							return false;
							break;
						}
	    				return ComChkValid(formObj);
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
			case "mft_vndr_seq":
				ComSetObjValue(formObj.agmt_seq,     "");
				ComSetObjValue(formObj.mft_vndr_seq, "");
				ComSetObjValue(formObj.mft_vndr_nm,  "");
				ComSetObjValue(formObj.lstm_cd,      "");
				break;
		}
	}
	/* 개발자 작업  끝 */