/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0024.js
*@FileTitle : Off Hire Plan Input & Update by H/Q
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.02 오봉현
* 1.0 Creation
* 2009.07.02 노정용
* 1.1 Modification
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
	 * @class ees_lse_0024 : ees_lse_0024 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0024() {
		this.processButtonClick				= processButtonClick;
		this.setSheetObject 				= setSheetObject;
		this.setComboObject 				= setComboObject;
		this.loadPage 						= loadPage;
		this.initControl            		= initControl;
		this.obj_blur						= obj_blur;
		this.obj_focus						= obj_focus;
		this.obj_keypress					= obj_keypress;
		this.obj_keyup						= obj_keyup;
		this.obj_keydown					= obj_keydown;
		this.obj_click						= obj_click;
		this.initSheet 						= initSheet;
		this.initCombo 						= initCombo;
		this.doActionIBSheet 				= doActionIBSheet;
		this.sheet1_OnSearchEnd 			= sheet1_OnSearchEnd;
		this.sheet1_OnSaveEnd 				= sheet1_OnSaveEnd;
		this.sheet1_OnChange 				= sheet1_OnChange;
		this.sheet1_OnLoadExcel 			= sheet1_OnLoadExcel;
		this.cntr_tpsz_cd_OnBlur			= cntr_tpsz_cd_OnBlur;
		this.cntr_tpsz_cd_OnKeyDown			= cntr_tpsz_cd_OnKeyDown;
		this.cntr_tpsz_cd_OnCheckClick		= cntr_tpsz_cd_OnCheckClick;
		this.offh_rgn_loc_cd_OnBlur			= offh_rgn_loc_cd_OnBlur;
		this.offh_rgn_loc_cd_OnKeyDown		= offh_rgn_loc_cd_OnKeyDown;
		this.offh_rgn_loc_cd_OnCheckClick	= offh_rgn_loc_cd_OnCheckClick;
		this.validateForm 					= validateForm;
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
   	var vOrcOffhLocCd = "";
	var vOrgOffhPlnTpCd = "";
	var vPlnYr          = "";
   	var bFlag = false;//엑셀업로드시 메시지 내용 체크유무
   	var balIdx = "";
	var balIdx2 = "";

	var IBVRSNUP = 99;
	var PLAN_TYPE_BASIC   = "B";
	var PLAN_TYPE_OPERATE = "O";

	var GRAND_TOTAL_NAME = "G.TTL";
	var SUB_TOTAL_NAME   = "TTL";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		/*******************************************************/

		var formObj = document.form;

		try {
			var srcObj  = window.event.srcElement;
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btns_LoadExcel":
					doActionIBSheet(sheetObjects[0], formObj, IBLOADEXCEL);
					break;

				case "btns_DownExcel":
					if ( ComIsBtnEnable(srcName) ) {
						doActionIBSheet(sheetObjects[0], formObj, IBDOWNEXCEL);
					}
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

				case "btn_New":
					ComResetAll();
					LseComBtnControl(false, "btn_Save|btn_Ver|btns_DownExcel");
					ComSetFocus(formObj.pln_yr);
					comboObjects[0].Index = 0;
					comboObjects[1].Index = 0;
					comboObjects[2].Index = 0;
					comboObjects[1].Enable = true;
					bFlag = false;
					break;

				case "btn_Save":
					if ( ComIsBtnEnable(srcName) ) {
						if ( ComShowCodeConfirm("COM12147", "Off-Hire Plan by H/O") ) {
							doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
						}
					}
 					break;

				case "btn_Ver":
					if ( ComIsBtnEnable(srcName) ) {
						if ( ComShowCodeConfirm("LSE01062") ) {
							doActionIBSheet(sheetObjects[0], formObj, IBVRSNUP);
						}
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

		LseComBtnControl(false, "btn_Save|btn_Ver|btns_DownExcel");

		vOrgOffhPlnTpCd = ComGetObjValue(formObj.offh_pln_tp_cd);
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
		axon_event.addListenerForm('click',			'obj_click',	formObj); //- 키 눌렸을때
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
		var obj = event.srcElement;
		var frm = document.form;

	    switch(obj.name){
	    	case "pln_yr":
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
	            ComKeyOnlyAlphabet('upper');
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

			case "start_yrmon":
  				ComKeyEnter('LengthNextFocus');
  				break;

			case "end_yrmon":
  				ComKeyEnter('LengthNextFocus');
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
   		}
   	}

	/**
	 * HTML Control의 Value가 변경되었을 경우 처리한다.
	 */
	function obj_click() {
		var obj     = event.srcElement;
		var formObj = document.form;

		switch(obj.name) {
			case "offh_pln_tp_cd":
				if ( ComGetObjValue(obj) != vOrgOffhPlnTpCd ) {
					vOrgOffhPlnTpCd = ComGetObjValue(obj);
					vPlanYear       = ComGetObjValue(formObj.pln_yr);

					ComResetAll();
					ComSetObjValue(obj, vOrgOffhPlnTpCd);

					comboObjects[0].Index = 0;
					comboObjects[1].Index = 0;
					comboObjects[2].Index = 0;

					if ( ComGetObjValue(obj) == PLAN_TYPE_BASIC ) {
						sheetObjects[0].ColHidden("lstm_cd") = false;
						comboObjects[1].Enable = true;
					} else if ( ComGetObjValue(obj) == PLAN_TYPE_OPERATE ) {
						sheetObjects[0].ColHidden("lstm_cd") = true;
						comboObjects[1].Enable = false;
					}

					ComSetObjValue(formObj.pln_yr, vPlanYear);
					ComSetFocus(formObj.pln_yr);
				}
    			break;
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
		var formObj = document.form;

		switch(sheetid){
			case "sheet1":
				with (sheetObj) {

					// 높이 설정
					style.height = 402;

					//전체 너비 설정
					SheetWidth = sheetTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "RCC|TP/SZ|Term|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC|G.TTL|||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"offh_rgn_loc_cd",	false,	"",	dfNone,		-1, false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"cntr_tpsz_cd",		false,	"",	dfNone,		-1, false,	false);
 					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"lstm_cd",			false,	"",	dfNone,		-1, false,	false);
 					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_01",			false,	"",	dfInteger,	-1, true,	true,	6);
 					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_02",			false,	"",	dfInteger,	-1, true,	true,	6);

 					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_03",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_04",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_05",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_06",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_07",			false,	"",	dfInteger,	-1, true,	true,	6);

					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_08",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_09",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_10",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_11",			false,	"",	dfInteger,	-1, true,	true,	6);
					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"mnth_12",			false,	"",	dfInteger,	-1, true,	true,	6);

					InitDataProperty(0, cnt++ , dtData,			60,		daRight,	false,	"yr_tot",			false,	"|3|+|4|+|5|+|6|+|7|+|8|+|9|+|10|+|11|+|12|+|13|+|14|", dfInteger,	-1, false,	false,	6);
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag",			false,	"",	dfNone,		-1, false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"pln_yr",			false,	"", dfNone,		-1, false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daRight,	true,	"offh_ver_seq",		false,	"", dfNone,		-1, false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"offh_pln_tp_cd",	false,	"", dfNone,		-1, false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"offh_loc_tp_cd",	false,	"", dfNone,		-1, false,	false);

					InitDataCombo(0, "lstm_cd", "LT|ST", "LT|ST");
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
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
	        case "cntr_tpsz_cd":
	        	with(comboObj) {
	            	DropHeight = 320;
	            	MultiSelect = true;
	            	UseAutoComplete = true;
	            	ValidChar(2,3);
	        	}
	        	break;

	        case "lstm_cd":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = false;
	            	UseAutoComplete = true;
	            	ValidChar(2,2);
	            }

	        	break;

	        case "offh_rgn_loc_cd":
	        	with(comboObj) {
	            	DropHeight = 200;
	            	MultiSelect = true;
	            	UseAutoComplete = true;
	            	ValidChar(2,2);
	            }
	        	break;
	    }
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;

				/* Container Type/Size Combo Item Setting Start */
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
	            if ( sXml1 != "" ) {
	            	comboObjects[0].InsertItem(0, 'ALL', '');
	            	LseComXml2ComboItem(sXml1, comboObjects[0], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
	            	comboObjects[0].Index = 0;
	            	vOrcCntrTpszCd = ComGetEtcData(sXml1, "cntr_tpsz_cd");
	            }

	            /* Lease Term Combo Item Setting Start */
	            //var strText = "ALL|LT|ST";
        		//var strCode = " |LT|ST";
        		//LseComText2ComboItem(comboObjects[1], strText, strCode, "|");
	            comboObjects[1].InsertItem(0, 'ALL', ' ');
	            comboObjects[1].InsertItem(1, 'LT','LT');
	            comboObjects[1].InsertItem(2, 'ST','ST');
        		comboObjects[1].Index = 0;

	            /* RCC Combo Item Setting */
	        	ComSetObjValue(formObj.f_cmd, SEARCH08);
		        var sXml3 = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));
		        if ( sXml3 != "" ) {
		        	comboObjects[2].InsertItem(0, 'ALL', '');
			        LseComXml2ComboItem(sXml3, comboObjects[2], "rcc_cd", "rcc_cd", "|");
			        comboObjects[2].Index = 0;
			        vOrcOffhLocCd = ComGetEtcData(sXml3, "rcc_cd");
		        }
		        sheetObj.InitDataCombo(0, "offh_rgn_loc_cd", vOrcOffhLocCd+"|"+GRAND_TOTAL_NAME, vOrcOffhLocCd+"|"+GRAND_TOTAL_NAME);

		        /* 초기 Focus Setting */
				ComSetFocus(formObj.pln_yr);
		        sheetObj.WaitImageVisible = true;
	            break;

			case IBSEARCH://조회
				if ( validateForm(sheetObj, formObj, sAction) ) {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					sheetObj.Redraw = false;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.DoSearch4Post("EES_LSE_0024GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
				break;

			case IBSAVE://저장
				if ( validateForm(sheetObj, formObj, sAction) ) {
					with(sheetObj) {
						for ( var i = HeaderRows ; i <= LastRow ; i++ ) {
							if ( (CellValue(i, "offh_rgn_loc_cd") != GRAND_TOTAL_NAME || CellValue(i, "cntr_tpsz_cd") != SUB_TOTAL_NAME) && CellValue(i, "pln_yr") == "" ) {
								CellValue2(i, "offh_pln_tp_cd") = ComGetObjValue(formObj.offh_pln_tp_cd);
							}
							if ( (CellValue(i, "offh_rgn_loc_cd") != GRAND_TOTAL_NAME || CellValue(i, "cntr_tpsz_cd") != SUB_TOTAL_NAME) && CellValue(i, "pln_yr") == "" ) {
								CellValue2(i, "offh_loc_tp_cd") = ComGetObjValue(formObj.offh_loc_tp_cd);
							}
							if ( (CellValue(i, "offh_rgn_loc_cd") != GRAND_TOTAL_NAME || CellValue(i, "cntr_tpsz_cd") != SUB_TOTAL_NAME) && CellValue(i, "pln_yr") == "" ) {
								CellValue2(i, "pln_yr") = ComGetObjValue(formObj.pln_yr);
							}
						}
						ComSetObjValue(formObj.f_cmd, MULTI);

						if (sheetObj.IsDataModified == true) {
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							DoSave("EES_LSE_0024GS.do",FormQueryString(formObj), -1, false);
							ComOpenWait(false);
						} else {
							ComShowCodeMessage("LSE01033");
						}
					}
				}

				break;

			case IBVRSNUP:
				ComSetObjValue(formObj.f_cmd, COMMAND01);
				var sParam = FormQueryString(formObj);
				//sheetObj.DoSave("EES_LSE_0024GS.do",FormQueryString(formObj));
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveXml("EES_LSE_0024GS.do",sParam);
				sheetObj.Redraw = false;
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
				break;

			case IBDOWNEXCEL:
				if ( sheetObj.ToTalRows < 1 ) {
					var row = sheetObj.DataInsert(0);
					sheetObj.RowHidden(row) = true;
					//sheetObj.Down2Excel(-1);
					sheetObj.SpeedDown2Excel(-1);
					sheetObj.RowDelete(row, false);
				} else {
					//sheetObj.Down2Excel(-1);
					sheetObj.SpeedDown2Excel(-1);
				}
				break;

			case IBLOADEXCEL://EXCEL UPLOAD
				vOrgOffhPlnTpCd = ComGetObjValue(formObj.offh_pln_tp_cd);
				vPlnYr          = ComGetObjValue(formObj.pln_yr);

				if (bFlag) {
					if ( ComShowCodeConfirm("LSE01138") ) {
						ComResetAll();

		 				with(sheetObj) {
	 						LoadExcel();
		 				}
			 			bFlag = false;
					}
				} else {
					ComResetAll();

					with(sheetObj) {
		 				LoadExcel();
		 			}
		 			bFlag = false;
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
		var formObj = document.form;
		if ( ErrMsg == "" ) {
			with(sheetObj){
				ComSetObjValue(formObj.offh_ver_seq, sheetObj.CellValue(1, "offh_ver_seq"));

				//소계표현하기
				ShowSubSum("offh_rgn_loc_cd", "3|4|5|6|7|8|9|10|11|12|13|14|15", -1, false, false, -1, "0=%s;1=TTL;2=;yr_tot=|3|+|4|+|5|+|6|+|7|+|8|+|9|+|10|+|11|+|12|+|13|+|14|","",false);

			    //소계 편집불가 및 색표시
			    for ( var rowIdx = HeaderRows ; rowIdx <= LastRow ; rowIdx++ ) {
			    	if ( (CellValue(rowIdx, "offh_rgn_loc_cd") == GRAND_TOTAL_NAME) || (CellValue(rowIdx, "cntr_tpsz_cd") == SUB_TOTAL_NAME) ) {
			    		RowEditable(rowIdx)   = false;
			    		//RowBackColor(rowIdx)  = SubSumBackColor;
			    		RowStatus(rowIdx) = "R";
			    		if ( CellValue(rowIdx, "cntr_tpsz_cd") == SUB_TOTAL_NAME ) {
			    			SetMergeCell(rowIdx, 1, 1, 2);
			    		}
			    	}
	            }
			}
			LseComBtnControl(true, "btn_Save|btn_Ver|btns_DownExcel");
			sheetObj.Redraw = true;
			bFlag = true;
		} else {
			sheetObj.Redraw = true;
		}
    }

	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		if ( ErrMsg == "" ) {
			if ( ComGetObjValue(formObj.f_cmd) == MULTI ) {
				ComShowCodeMessage("LSE10001");
			} else if ( ComGetObjValue(formObj.f_cmd) == COMMAND01 ) {
				ComShowCodeMessage("LSE10004");
			}
			ComSetObjValue(formObj.offh_ver_seq, "");
			sheetObj.Redraw = true;
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		} else {
			sheetObj.Redraw = true;
		}
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		with (sheetObj) {
			Redraw = false;

			var vCntrTpszCd = CellValue(Row, "cntr_tpsz_cd");
			var vLstmCd     = CellValue(Row, "lstm_cd");
			var vQtySum     = 0;

			for ( var rowIdx = HeaderRows ; rowIdx <= LastRow ; rowIdx++ ) {
				if ( CellValue(rowIdx, "offh_rgn_loc_cd") != GRAND_TOTAL_NAME ) {
					if ( CellValue(rowIdx, "cntr_tpsz_cd") == vCntrTpszCd && CellValue(rowIdx, "lstm_cd") == vLstmCd ) {
						vQtySum = vQtySum + ComParseInt(CellValue(rowIdx, Col));
					}
				} else {
					if ( CellValue(rowIdx, "cntr_tpsz_cd") == vCntrTpszCd && CellValue(rowIdx, "lstm_cd") == vLstmCd ) {
						CellValue2(rowIdx, Col) = vQtySum;
					}
				}
			}

			HideSubSum();
			ShowSubSum("offh_rgn_loc_cd", "3|4|5|6|7|8|9|10|11|12|13|14|15", -1, false, false, -1, "0=%s;1=TTL;2=;yr_tot=|3|+|4|+|5|+|6|+|7|+|8|+|9|+|10|+|11|+|12|+|13|+|14|","",false);

		    //소계 편집불가 및 색표시
			for ( var rowIdx = HeaderRows ; rowIdx <= LastRow ; rowIdx++ ) {
				if ( (CellValue(rowIdx, "offh_rgn_loc_cd") == GRAND_TOTAL_NAME) || (CellValue(rowIdx, "cntr_tpsz_cd") == SUB_TOTAL_NAME) ) {
		    		RowEditable(rowIdx)   = false;
		    		//RowBackColor(rowIdx)  = SubSumBackColor;
		    		RowStatus(rowIdx) = "R";
		    		if ( CellValue(rowIdx, "cntr_tpsz_cd") == SUB_TOTAL_NAME ) {
		    			SetMergeCell(rowIdx, 1, 1, 2);
		    		}
		    	}
            }
		    Redraw = true;
		}
	}

	function sheet1_OnLoadExcel(sheetObj) {
		var formObj = document.form;

		ComSetObjValue(formObj.offh_pln_tp_cd, vOrgOffhPlnTpCd);
		ComSetObjValue(formObj.pln_yr, vPlnYr);

		with(sheetObj){
			/* 업로드된 엑셀 데이터 중 G.TTL/TTL 데이터는 삭제처리 */
			for ( var rowIdx = LastRow ; rowIdx >= HeaderRows ; rowIdx-- ) {
				if ( (CellValue(rowIdx, "offh_rgn_loc_cd") == GRAND_TOTAL_NAME) || (CellValue(rowIdx, "cntr_tpsz_cd") == SUB_TOTAL_NAME) ) {
					RowDelete(rowIdx, false);
				}
			}

			//소계표현하기
			ShowSubSum("offh_rgn_loc_cd", "3|4|5|6|7|8|9|10|11|12|13|14|15", -1, false, false, -1, "0=%s;1="+SUB_TOTAL_NAME+";2=;yr_tot=|3|+|4|+|5|+|6|+|7|+|8|+|9|+|10|+|11|+|12|+|13|+|14|","",false);

		    //소계 편집불가 및 색표시
			for ( var rowIdx = HeaderRows ; rowIdx <= LastRow ; rowIdx++ ) {
				if ( (CellValue(rowIdx, "offh_rgn_loc_cd") == GRAND_TOTAL_NAME) || (CellValue(rowIdx, "cntr_tpsz_cd") == SUB_TOTAL_NAME) ) {
		    		RowEditable(rowIdx)   = false;
		    		//RowBackColor(rowIdx)  = SubSumBackColor;
		    		RowStatus(rowIdx) = "R";
		    		if ( CellValue(rowIdx, "cntr_tpsz_cd") == SUB_TOTAL_NAME ) {
		    			SetMergeCell(rowIdx, 1, 1, 2);
		    		}
		    	} else {
		    		if ( ComGetObjValue(formObj.offh_pln_tp_cd) == PLAN_TYPE_OPERATE ) {
		    			CellValue2(rowIdx, "lstm_cd") = "LT";
		    		}
		    	}
            }
		}
		LseComBtnControl(true, "btn_Save");
		LseComBtnControl(false, "btn_Ver|btns_DownExcel");
		bFlag = true;
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
	 * MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
	 * @return
	 */
	function offh_rgn_loc_cd_OnCheckClick(comboObj, index, code) {
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
	function offh_rgn_loc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
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
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		switch(sAction) {
    			case IBSEARCH://조회
	    			if ( ComGetObjValue(formObj.pln_yr) == "" ) {
						ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.pln_yr);
						return false;
						break;
					}
    				return ComChkValid(formObj);
    				break;

    			case IBSAVE://조회
	    			if ( ComGetObjValue(formObj.pln_yr) == "" ) {
						ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.pln_yr);
						return false;
						break;
					}
					break;
    		}
    	}

		return true;
	}

	/* 개발자 작업  끝 */