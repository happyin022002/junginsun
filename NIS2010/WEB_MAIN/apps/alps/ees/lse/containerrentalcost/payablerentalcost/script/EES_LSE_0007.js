/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0007.js
*@FileTitle : Container Rental Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.09.10 노정용
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
	 * @class EES_LSE_0007 : EES_LSE_0007 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0007() {
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

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	var usrOfcCd = "";
	var backEndJobType;
	var timer;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					removePage(formObj);
					// 조회 버튼 클릭 시 현재 선택된 Row 의 재설정하지 않음.
					ComSetObjValue(formObj.checkedRows,    "");
					//ComSetObjValue(formObj.checkedChgSeqs, "");
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
					ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
					ComSetObjValue(formObj.chg_cost_yrmon, ComGetObjValue(formObj.cost_yrmon));
					ComAddSeparator(form.chg_cost_yrmon, "ym");
					comboObjects[0].Index = 0;
					ComSetFocus(formObj.vndr_seq);
					break;

				case "btns_calendar":
					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.chg_cost_yrmon, 'yyyy-MM');
					break;

				case "btns_search":		// Lessor(Service Provider) Pop-up
					openPopupPage("2");
					break;

				case "btns_search2":	// Currency Pop-up
					openPopupPage("4");
					break;

				case "btns_search3":	// Pay Vendor Pop-up
					openPopupPage("5");
					break;

				case "btn_FileImport":	// Lessor Invoice File Import Pop-up
					openPopupPage("1");
					break;

				case "btn_ChgCreate":
					if ( ComShowCodeConfirm("LSE01116") ) {
						removePage(formObj);
						doActionIBSheet(sheetObject1, formObj, IBSAVE);
					}
					break;

				case "btn_ChgDelete":
					if ( ComShowCodeConfirm("LSE01117") ) {
						removePage(formObj);
						doActionIBSheet(sheetObject1, formObj, IBDELETE);
					}
					break;

				case "btn_Audit":
					openPopupPage("3");
					break;

				case "btns_calendar1":
					var cal = new ComCalendar();
	                cal.select(formObj.inv_rcv_dt, 'yyyy-MM-dd');
					break;

				case "btns_calendar2":
					var cal = new ComCalendar();
	                cal.select(formObj.inv_iss_dt, 'yyyy-MM-dd');
					break;

				case "btn_InvoiceCreation":
					if ( ComShowCodeConfirm("LSE01120") ) {
						doActionIBSheet(sheetObject2, formObj, IBSAVE);
					}
					break;

				case "btn_Office":
					openPopupPage("10");
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

		for ( var i = 0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
	    }

		/* Axon Control Setting*/
		initControl();

		/* Cost Month Default Value Setting : 전월 */
		ComSetObjValue(formObj.chg_cost_yrmon, ComGetObjValue(formObj.cost_yrmon));
		ComAddSeparator(form.chg_cost_yrmon, "ym");

		usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
	}

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		//axon_event.addListenerForm('beforedeactivate',		'obj_blur',		formObj); //- 포커스 나갈때
  		axon_event.addListenerForm('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress','obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',	'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerForm('change',	'obj_change',	formObj); //- 키 눌렸을때
  	}

  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 */
	function obj_blur(){
  		var formObj = document.form;
  		var obj     = event.srcElement;

	    switch(obj.name){
	        case "vndr_seq":
	        case "pay_vndr_seq":
	            /* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;

	        case "inv_rcv_dt":
	        	ComChkObjValid(obj);
	        	//if ( ComGetObjValue(formObj.inv_rcv_dt) != "" ) {
	        	//	setInvEffDt(formObj, ComGetObjValue(formObj.inv_rcv_dt));
	        	//}
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
	        	if ( obj.name == "cost_ofc_cd" ) {
	        		ComKeyOnlyAlphabet('uppernum');
	        	} else {
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
			case "chg_cost_yrmon":
				ComKeyEnter('LengthNextFocus');
  				break;

			case "vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.vndr_nm,"");
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;

			case "pay_vndr_seq":
  				if ( ComTrim(ComGetObjValue(obj)) == "" ) {
  					ComSetObjValue(formObj.pay_vndr_nm,"");
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
	   	var formObj  = document.form;
		var obj      = event.srcElement;
   		var vKeyCode = event.keyCode;

   		switch (obj.name) {
	   		case "inv_rmk":
				// 힌글입력방지
	    		if ( event.keyCode == "229" ) {
	    			event.returnValue = false;
	    			return true;
	    		}
	
				if ( ComGetLenByByte(obj) > 999) {
	  				ComShowCodeMessage("LSE01021");
	  				return false;
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
				case "chg_cost_yrmon":
					sheetObjects[0].RemoveAll();
					removePage(formObj);
					break;

				case "vndr_seq":
					sheetObjects[0].RemoveAll();
					removePage(formObj);
					doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
				   	break;

	    		case "curr_cd":
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
				   	break;

	    		case "inv_rcv_dt":
	    			//if ( ComGetObjValue(formObj.inv_rcv_dt) != "" ) {
	    			//	setInvEffDt(formObj, ComGetObjValue(obj));
	    			//}
	    			break;

	    		case "cost_ofc_cd":			//Office Code
	  				if ( ComTrim(obj.value) != "" ) {
		        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
	  				}
					break;

	    		case "pay_vndr_seq":
					doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
				   	break;
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
		var sheetID = sheetObj.id;

		switch(sheetID) {
			case "sheet1":
				with (sheetObj) {
					// 높이 설정
					style.height = 182;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "||Seq.|STS|AGMT No.|Ver|Term|Contract No.|Reference|Effective date|Effective date|Invoice No|Charge AMT|Lessor AMT|Credit AMT|Payable AMT|DIFF. AMT|Register No.|Currency||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 5, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,	"chkbox",  	 		false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	true,	"seq");
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	"chg_sts_cd",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"agmt_no",			false,	"",	dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	"agmt_lst_ver_seq", false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	"lstm_cd", 	   		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"lse_ctrt_no",		false,	"",	dfNone,	0,			false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"ref_no",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"eff_dt",			false,	"",	dfDateYmd,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			65,		daCenter,	true,	"exp_dt",			false,	"",	dfDateYmd,		0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"inv_no",			false,	"",	dfNone,			0,	false,	false,	20);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"hjs_ttl_chg_amt",		false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"inv_ttl_chg_amt",		false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"cr_ttl_amt",		false,	"",	dfNullFloat,	2,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	"pay_rntl_cost_amt",false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	"diff_cost_amt",	false,	"|pay_rntl_cost_amt|-|hjs_ttl_chg_amt|",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"if_rgst_no",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"curr_cd",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"agmt_cty_cd",		false,	"",	dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"agmt_seq",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"chg_seq",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"inv_fil_flg",		false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"cre_dt",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"cre_usr_id",		false,	"",	dfNone,			0,	false,	false);

					CountPosition = 0;
				}
				break;

			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 122;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Sel.|Invoice No.|User ID|Create Date|AGMT No.|Contract No.|Issue Ofc.|Lease Term|Lessor AMT|Credit AMT|Payable AMT|Charge Total||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,	daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,	daCenter,	true,	"chkbox",  	 			false,	"",	dfNone,			0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"inv_no", 				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"cre_usr_id", 			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			90,	daCenter,	true,	"cre_dt",		 		false,	"",	dfDateYmd,		0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"agmt_no", 				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,daCenter,	true,	"lse_ctrt_no",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"issu_ofc_cd", 			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,	"lstm_cd", 				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,daRight,	false,	"inv_ttl_chg_amt",		false,	"",	dfNullFloat,	2,	false,	false);
					
					InitDataProperty(0, cnt++ , dtData,			100,daRight,	false,	"cr_ttl_amt",			false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100,daRight,	true,	"pay_rntl_cost_amt", 	false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		90,	daRight,	false,	"hjs_ttl_chg_amt", 		false,	"",	dfNullFloat,	2,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter,	true,	"agmt_cty_cd",			false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter,	true,	"agmt_seq",				false,	"",	dfNone,			0,	false,	false);

					InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter,	true,	"chg_seq",				false,	"",	dfNone,			0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		60,	daCenter,	true,	"chg_sts_cd",			false,	"",	dfNone,			0,	false,	false);

					CountPosition = 0;
				}
				break;

			case "sheet3":
				with (sheetObj) {
					// 높이 설정
					style.height = 82;

					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge;

					// 전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Seq.|Invoice No.|VVD|Cost Code|Cost Name|AGMT No.|Contract No.|Charge Type|TP/SZ|Lessor AMT|Credit AMT||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	false,	"Seq");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"inv_no", 				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	"vvd", 					false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"cost_cd", 				false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtData,			230,	daLeft,		true,	"cost_nm", 				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"agmt_no",				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"lse_ctrt_no",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"lse_pay_chg_tp_cd",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"cntr_tpsz_cd",			false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"ttl_cost_amt", 		false,	"",	dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"cr_amt", 				false,	"",	dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"agmt_cty_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"agmt_seq",				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"chg_seq",				false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"acct_cd",				false,	"",	dfNone);

					CountPosition = 0;
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
			case "lstm_cd":
				with(comboObj) {
					DropHeight = 250;
					MultiSelect = false;
					UseAutoComplete = true;
				}
 	        	break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;
				/* Lease Term Form Combo Item Setting */
				var strText = "ALL|OF|LT|ST|SI|MI|SO";
        		var strCode = " |OF|LT|ST|SI|MI|SO";

        		LseComText2ComboItem(comboObjects[0], strText, strCode, "|");
        		comboObjects[0].Index = 0;

        		/* 초기 Focus Setting */
        		ComSetFocus(formObj.vndr_seq);

		        break;

			case IBSEARCH:      //조회
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						ComSetObjValue(formObj.f_cmd, SEARCH);
						sheetObj.DoSearch4Post("EES_LSE_0007GS.do", FormQueryString(formObj));
					} else if ( sheetObj.id = "sheet3" ) {
						/*========================================*/
						/* Sheet2 Check box Check 시 Sheet3 Search */
						/*========================================*/
						// Sheet2 Checkbox Row Find. Sheet3 조회조건으로 사용.
						var chkRows   = sheetObjects[1].FindCheckedRow("chkbox");
						var arrChkRow = chkRows.split("|");
						var chgSeqs   = "";

						for ( var i = 0 ; i < arrChkRow.length-1 ; i++ ) {
							var chgSeq = sheetObjects[1].CellValue(arrChkRow[i], "chg_seq");

							// sheetObjects[2] Sheet에 없는 chg_seq 만 조회하기 위한 조건
							if ( sheetObj.FindText("chg_seq", chgSeq) == -1 ) {
								if ( chgSeqs == "" ) {
									chgSeqs = chgSeq;
								} else {
									chgSeqs = chgSeqs + "|" + chgSeq;
								}
							}
						}

						var sParam = "f_cmd="+COMMAND05;
						sParam = sParam + "&chg_seq="+chgSeqs;

						if ( sheetObj.RowCount > 0 ) {
							// sheet3 에 조회된 내역이 있다면 새로 조회된 내용을 Append.
							sheetObj.DoSearch4Post("EES_LSE_0007GS.do", sParam, "", true);
						} else {
							// sheet3 에 조회된 내역이 없을 경우.
							sheetObj.DoSearch4Post("EES_LSE_0007GS.do", sParam);
						}
					}
				}

 				break;

			case IBSAVE:      //저장
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						// Charge Creation.
						ComSetObjValue(formObj.f_cmd, COMMAND01);
						// BackEnd Job 수행 후 메세지 처리위한 처리내용 Setting.
						backEndJobType = ComGetObjValue(formObj.f_cmd);

						var sParam = FormQueryString(formObj);
						// Check box 선택된 Row 만 Charge Creation.
						var sSheetParam = sheetObj.GetSaveString(false, false, "chkbox");
						sSheetParam = ComSetPrifix(sSheetParam, "sheet1_");
						sParam = sParam + "&" + sSheetParam;

						var sXml = sheetObj.GetSaveXml("EES_LSE_0007GS.do" , sParam);

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.RequestTimeOut = 10000;
							timer = setInterval(getBackEndJobStatus, 3000);
						}
					} else if ( sheetObj.id == "sheet2" ) {
						// Invoice Creation.
						ComSetObjValue(formObj.f_cmd, COMMAND06);
						// BackEnd Job 수행 후 메세지 처리위한 처리내용 Setting.
						backEndJobType = ComGetObjValue(formObj.f_cmd);

						var sParam = FormQueryString(formObj);
						// Check box 선택된 Row 만 Invoice Creation. sheet2는 Header Data 로 사용됨.
						var sSheetParam = sheetObj.GetSaveString(false, false, "chkbox");
						sSheetParam = ComSetPrifix(sSheetParam, "sheet2_");
						sParam = sParam + "&" + sSheetParam;

						// Sub Total 숨기기.
						sheetObjects[2].HideSubSum("ibflag");

						// sheet3는 Invoice Creation 의 Detail Data 로 사용됨.
						var sSheetParam2 = sheetObjects[2].GetSaveString(true);
						sSheetParam2 = ComSetPrifix(sSheetParam2, "sheet3_");
						sParam = sParam + "&" + sSheetParam2;

						var sXml = sheetObj.GetSaveXml("EES_LSE_0007GS.do" , sParam);

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
							sheetObjects[0].WaitImageVisible = false;
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.RequestTimeOut = 10000;
							timer = setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;

			case IBDELETE:
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						ComSetObjValue(formObj.f_cmd, COMMAND02);
						// BackEnd Job 수행 후 메세지 처리위한 처리내용 Setting.
						backEndJobType = ComGetObjValue(formObj.f_cmd);

						var sParam = FormQueryString(formObj);
						// Check box 선택된 Row 만 Charge Creation.
						var sSheetParam = sheetObj.GetSaveString(false, false, "chkbox");
						sSheetParam = ComSetPrifix(sSheetParam, "sheet1_");
						sParam = sParam + "&" + sSheetParam;

						var sXml = sheetObj.GetSaveXml("EES_LSE_0007GS.do" , sParam);

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							sheetObj.RequestTimeOut = 10000;
							timer = setInterval(getBackEndJobStatus, 3000);
						}
					}
				}
				break;

			case IBSEARCH_ASYNC01:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								//ComDebug(ComGetEtcData(sXml, "gen_pay_term_cd"));
								ComSetObjValue(formObj.gen_pay_term_cd, ComGetEtcData(sXml, "gen_pay_term_cd"));
								ComSetNextFocus(formObj.vndr_seq);
							} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.vndr_seq, "");
	 							ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetObjValue(formObj.gen_pay_term_cd, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.vndr_seq, "");
							ComSetObjValue(formObj.gen_pay_term_cd, "");
							ComSetFocus(formObj.vndr_seq);
						}
					}
				}
				break;

 			case IBSEARCH_ASYNC02:	//조회(Form Curr 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH07+"&curr_cd="+ComGetObjValue(formObj.curr_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
						if ( ComGetEtcData(sXml, "curr_cd") != undefined ) {
							ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
							ComSetNextFocus(formObj.curr_cd);
						} else {
							//ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.curr_cd, "");
							ComSetFocus(formObj.curr_cd);
						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						ComSetObjValue(formObj.curr_cd, "");
						ComSetFocus(formObj.curr_cd);
					}
				}
				break;

			case IBSEARCH_ASYNC03:	// Office Code 에 대한 Validation 체크
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param = "f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.cost_ofc_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;
	
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.cost_ofc_cd.value = ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.cost_ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.cost_ofc_cd.value = "";
								ComSetFocus(formObj.cost_ofc_cd);
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.cost_ofc_cd.value = "";
							ComSetFocus(formObj.cost_ofc_cd);
						}
					}
				}
	        	break;

			case IBSEARCH_ASYNC04:	//조회(Form Pay Vendor 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.pay_vndr_seq);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
						sheetObj.WaitImageVisible = true;
	
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.pay_vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetNextFocus(formObj.pay_vndr_seq);
							} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.pay_vndr_seq, "");
	 							ComSetObjValue(formObj.pay_vndr_nm, "");
	 							ComSetFocus(formObj.pay_vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.pay_vndr_seq, "");
							ComSetFocus(formObj.pay_vndr_seq);
						}
					}
				}
				break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
			case IBSEARCH:
				if ( sheetObj.id == "sheet1" ) {
					if( ComGetObjText(formObj.chg_cost_yrmon) == "" ) {
						ComShowCodeMessage("LSE01098");
						ComSetFocus(formObj.chg_cost_yrmon);
						return false;
					}

					if( ComGetObjText(formObj.vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.vndr_seq);
						return false;
					}
				}
				break;

			case IBSAVE:
				if ( sheetObj.id == "sheet1" ) {
					// Charge Creation : Check 된 Row 확인.
					var sRow = sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return false;
					}
					var arrRow = sRow.split("|"); //결과 : "1|3|5|"
					for ( var i = 0 ; i < arrRow.length-1 ; i++ ) {
						var chg_sts = sheetObj.CellValue(arrRow[i], "chg_sts_cd");
						if ( chg_sts != "N") {
							ComShowCodeMessage("LSE01058");
							return false;
						}
					}
				} else if ( sheetObj.id == "sheet2" ) {
					// Invoice Creation : Check 된 Row 확인.
					var sRow = sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return false;
					}

					if( ComGetObjText(formObj.pay_vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.pay_vndr_seq);
						return false;
					}

					if( ComGetObjText(formObj.inv_rcv_dt) == "" ) {
						ComShowCodeMessage("LSE01123");
						ComSetFocus(formObj.inv_rcv_dt);
						return false;
					}

					if( ComGetObjText(formObj.inv_iss_dt) == "" ) {
						ComShowCodeMessage("LSE01111");
						ComSetFocus(formObj.inv_iss_dt);
						return false;
					}
					/*
					if( ComGetObjText(formObj.vndr_term_nm) == "" ) {
						ComShowCodeMessage("LSE01122");
						ComSetFocus(formObj.vndr_term_nm);
						return false;
					}
 					*/
					if( ComGetObjText(formObj.curr_cd) == "" ) {
						ComShowCodeMessage("LSE01012");
						ComSetFocus(formObj.curr_cd);
						return false;
					}
				}
				break;

			case IBDELETE:
				if ( sheetObj.id == "sheet1" ) {
					// Charge Delete : Check 된 Row 확인.
					var sRow = sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return 0;
					}
					var arrRow = sRow.split("|"); //결과 : "1|3|5|"
					for ( var i = 0 ; i < arrRow.length-1 ; i++ ) {
						var chg_sts = sheetObj.CellValue(arrRow[i], "chg_sts_cd");
						if ( chg_sts  == "N" ) {
							ComShowCodeMessage("LSE01099");
							return false;
						} else if ( chg_sts  == "I" ) {
							ComShowCodeMessage("LSE01100");
							return false;
						}
					}
				}
				break;

			case IBSEARCH_ASYNC01:
				if ( sheetObj.id == "sheet1" ) {
					if( ComGetObjText(formObj.vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.vndr_seq);
						return false;
					}
				}
				break;

			case IBSEARCH_ASYNC04:
				if ( sheetObj.id == "sheet1" ) {
					if( ComGetObjText(formObj.pay_vndr_seq) == "" ) {
						ComShowCodeMessage("LSE01044");
						ComSetFocus(formObj.pay_vndr_seq);
						return false;
					}
				}
				break;
		}

		return true;
	}

	/**
	 * Sheet1 OnLoadFinish Event 처리
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);
	}

	/**
	 * Sheet1 OnSearchEnd Event 처리
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if ( ErrMsg == "" ) {
			var formObj = document.form;

			for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
				var chg_sts = sheetObj.CellValue(i, "chg_sts_cd");
				if ( chg_sts  == "I") {
					//sheetObj.CellEditable(i, "chkbox") = false; 
					sheetObj.CellEditable(i, "chkbox") = true;  //2014.12.10
				} else if ( chg_sts  == "H") {
					sheetObj.CellEditable(i, "inv_no") = true;
				} else if ( chg_sts  == "C") {
					if ( sheetObj.CellValue(i, "inv_fil_flg") == "N" ) {
						sheetObj.CellEditable(i, "inv_no") = true;
					}
				}
			}

			// 재조회 전 check 된 Row를 재조회 후 재설정. Row Index 로 재설정(Charge Sequence 사용안함).
			var sRows = ComGetObjValue(formObj.checkedRows);
			if ( sRows != "" ) {
				var arrRow = sRows.split("|");
				for ( var i = 0 ; i < arrRow.length-1 ; i++ ) {
					sheetObj.CellValue(arrRow[i], "chkbox") = 1;
				}
			}
			/*
			var chgSeqs = ComGetObjValue(formObj.checkedChgSeqs);
			if ( chgSeqs != "" ) {
				var arrChgSeq = chgSeqs.split("|");
				for ( var i = 0 ; i < arrChgSeq.length ; i++ ) {
					for ( var j = sheetObj.HeaderRows ; j <= sheetObj.LastRow ; j++ ) {
						if ( sheetObj.CellValue(j, "chg_seq") == arrChgSeq[i] ) {
							sheetObj.CellValue(j, "chkbox") = 1;
						}
					}
				}
			}
			*/
		}
	}

	/**
	 * sheet1 OnChange Event 처리
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj   = document.form;
		var colName   = sheetObj.ColSaveName(Col);
		var sheetObj2 = sheetObjects[1];

		switch (colName) {
			case "chkbox":
				checkChargeForAudit(sheetObj, Row, Value);
				// 2014.12.10-12.17 
		        var arrRows = sheetObj.FindCheckedRow("chkbox");
		        var btnSw = 0;
		        arrRows = arrRows.split("|");  // 1|

		        for(var idx=0; idx < arrRows.length -1; idx++){
		        	if(sheetObj.CellValue(arrRows[idx], "chg_sts_cd") == "I"){
			        	btnSw = 1;
			        }
				}
		        
				if(btnSw == 1){	
			        ComBtnDisable("btn_InvoiceCreation");
			        ComBtnDisable("btn_FileImport");
			        ComBtnDisable("btn_ChgCreate");
			        ComBtnDisable("btn_ChgDelete");
				}else{
					ComBtnEnable("btn_InvoiceCreation");					
					ComBtnEnable("btn_FileImport");
					ComBtnEnable("btn_ChgCreate");
					ComBtnEnable("btn_ChgDelete");
				}
					
				break;

			case "inv_no":
				var sParam = "f_cmd="+COMMAND04;
				sParam = sParam + "&chg_seq="+sheetObj.CellValue(Row, "chg_seq");
				sParam = sParam + "&agmt_cty_cd="+sheetObj.CellValue(Row, "agmt_cty_cd");
				sParam = sParam + "&agmt_seq="+sheetObj.CellValue(Row, "agmt_seq");
				sParam = sParam + "&inv_no="+Value;

				var sXml = sheetObj.GetSaveXml("EES_LSE_0007GS.do" , sParam);

				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") != "S" ) {
					ComShowCodeMessage("LSE01101");
					sheetObj.CellValue2(Row, "inv_no") = "";
				} else if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					sheetObj.CellValue(Row, "chkbox") = "0";
					sheetObj.CellValue(Row, "chg_sts_cd") = "C";
					//sheetObj.CellValue(Row, "inv_no")
					//removePage(formObj);
				}
				break;
		}
	}

	/**
	 * Invoice Creation 완료된 건의 Audit 내역을 조회함.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param CellX
	 * @param CellY
	 * @param CellW
	 * @param CellH
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj   = document.form;
		var colName   = sheetObj.ColSaveName(Col);

		switch(colName) {
			case "if_rgst_no":
				if ( sheetObj.CellValue(Row, "chg_sts_cd") == "I" ) {

					var sParam = "?chg_cost_yrmon="   + ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon),"-","");
					sParam = sParam + "&vndr_seq="    + ComGetObjValue(formObj.vndr_seq);
					sParam = sParam + "&vndr_nm="     + ComGetObjValue(formObj.vndr_nm);
					sParam = sParam + "&inv_no="      + sheetObj.CellValue(Row, "inv_no");
					sParam = sParam + "&chg_seq="     + sheetObj.CellValue(Row, "chg_seq");
					sParam = sParam + "&agmt_cty_cd=" + sheetObj.CellValue(Row, "agmt_cty_cd");
					sParam = sParam + "&agmt_seq="    + sheetObj.CellValue(Row, "agmt_seq");
					sParam = sParam + "&inv_yn=Y";

					ComOpenPopup('/hanjin/EES_LSE_0007_01.do'+sParam, 920, 550, 'setPopData_Audit', '1,0', true);
				}
				break;
		}
	}

	/**
	 * sheet2 OnChange Event 처리
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj   = document.form;
		var colName   = sheetObj.ColSaveName(Col);

		switch (colName) {
			case "chkbox":
				var invNo = sheetObj.CellValue(Row, "inv_no");
				for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++) {
					if ( sheetObj.CellValue(i, "inv_no") == invNo ) {
						if ( sheetObj.CellValue(i, "chg_sts_cd") == "I" || //2014.12.10
							sheetObj.CellValue(i, "chg_sts_cd") == "A") {
							if ( sheetObj.CellValue(i, "chkbox") != Value ) {
								sheetObj.CellValue2(i, "chkbox") = Value;
							}
						} else {
							if ( Value == "1" ) {
								ComShowCodeMessage("LSE01102");
								sheetObj.CellValue2(i, "chkbox") = "0";
							}
							return;
						}
					}
				}

				// check 되면 sheet3 에 조회, uncheck 되면 sheet3 에서 삭제
				if ( Value == "1" ) {
					ComSetObjValue(formObj.pay_vndr_seq, formObj.vndr_seq.value);
					ComSetObjValue(formObj.pay_vndr_nm, formObj.vndr_nm.value);
					doActionIBSheet(sheetObjects[2], formObj, IBSEARCH);
				} else {
					while ( sheetObjects[2].FindText("inv_no", invNo) != -1 ) {
						sheetObjects[2].RowDelete(sheetObjects[2].FindText("inv_no", invNo), false);
					}
					sheet3_ShowSubSum(sheetObjects[2]);
					if  ( sheetObjects[2].RowCount < 1 ) {
						removePage2(formObj);
					}
				}
				break;
		}
	}

	//function sheet2_OnSaveEnd(sheetObj, ErrMsg) {
	//	var formObj = document.form;
	//	if ( ErrMsg == "" ) {
	//		ComShowCodeMessage("LSE01121");
	//		removePage(formObj);
	//		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	//	}
	//}

	/**
	 * sheet3 OnSearchEnd Event 처리
	 * 
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		if ( ErrMsg == "" ) {
			sheet3_ShowSubSum(sheetObj);
		}
	}

	/**
	 * sheet1 에 checkbox 를 선택하면 Audit 된 내용을 sheet1 의 조회된 Data 를 이용하여 sheet2 에 조회.
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Value
	 * @return
	 */
	function checkChargeForAudit(sheetObj, Row, Value) {
		var formObj   = document.form;
		var sheetObj2 = sheetObjects[1];

		if ( sheetObj.CellValue(Row, "chg_sts_cd") == "C"
		  || sheetObj.CellValue(Row, "chg_sts_cd") == "H"
		  || sheetObj.CellValue(Row, "chg_sts_cd") == "I" // 2014.12.10  
		  || sheetObj.CellValue(Row, "chg_sts_cd") == "A") {
			if ( Value == "1" ) {
				if ( sheetObj.CellValue(Row, "inv_no") == "" ) {
					return;
				}

				var newRowIdx = sheetObj2.DataInsert(-1);

				sheetObj2.CellValue2(newRowIdx, "inv_no")            = sheetObj.CellValue(Row, "inv_no");
				sheetObj2.CellValue2(newRowIdx, "agmt_no")           = sheetObj.CellValue(Row, "agmt_no");
				sheetObj2.CellValue2(newRowIdx, "lse_ctrt_no")       = sheetObj.CellValue(Row, "lse_ctrt_no");
				sheetObj2.CellValue2(newRowIdx, "cre_dt")            = sheetObj.CellValue(Row, "cre_dt");
				sheetObj2.CellValue2(newRowIdx, "cre_usr_id")        = sheetObj.CellValue(Row, "cre_usr_id");
				sheetObj2.CellValue2(newRowIdx, "issu_ofc_cd")       = usrOfcCd;
				sheetObj2.CellValue2(newRowIdx, "lstm_cd")           = sheetObj.CellValue(Row, "lstm_cd");
				sheetObj2.CellValue2(newRowIdx, "agmt_no")           = sheetObj.CellValue(Row, "agmt_no");
				sheetObj2.CellValue2(newRowIdx, "pay_rntl_cost_amt") = sheetObj.CellValue(Row, "pay_rntl_cost_amt");
				sheetObj2.CellValue2(newRowIdx, "hjs_ttl_chg_amt")   = sheetObj.CellValue(Row, "hjs_ttl_chg_amt");
				sheetObj2.CellValue2(newRowIdx, "cr_ttl_amt")        = sheetObj.CellValue(Row, "cr_ttl_amt");
				sheetObj2.CellValue2(newRowIdx, "inv_ttl_chg_amt")   = sheetObj.CellValue(Row, "inv_ttl_chg_amt");
				sheetObj2.CellValue2(newRowIdx, "agmt_cty_cd")       = sheetObj.CellValue(Row, "agmt_cty_cd");
				sheetObj2.CellValue2(newRowIdx, "agmt_seq")          = sheetObj.CellValue(Row, "agmt_seq");
				sheetObj2.CellValue2(newRowIdx, "chg_seq")           = sheetObj.CellValue(Row, "chg_seq");
				sheetObj2.CellValue2(newRowIdx, "chg_sts_cd")        = sheetObj.CellValue(Row, "chg_sts_cd");
			} else {
				var delRowIdx = sheetObj2.FindText("agmt_no", sheetObj.CellValue(Row, "agmt_no"));
				var invNo     = sheetObj2.CellValue(delRowIdx, "inv_no");
				sheetObj2.RowDelete(delRowIdx, false);

				while ( sheetObjects[2].FindText("inv_no", invNo) != -1 ) {
					sheetObjects[2].RowDelete(sheetObjects[2].FindText("inv_no", invNo), false);
				}
				sheet3_ShowSubSum(sheetObjects[2]);
				if  ( sheetObjects[2].RowCount < 1 ) {
					removePage2(formObj);
				}
			}

			sheet2_ShowSubSum(sheetObj2);
		}
	}

	/**
	 * sheet2 sub total 설정
	 * @param sheetObj
	 * @return
	 */
	function sheet2_ShowSubSum(sheetObj) {
		with(sheetObj) {
			HideSubSum("inv_no");
			ColumnSort("inv_no|agmt_no");
			ShowSubSum("inv_no", "9|10|11|12", -1, false, false, 0, "inv_no=S.Total;usr_id=;cre_dt=;agmt_no=;lse_ctrt_no=;issu_ofc_cd=;lstm_cd=");

			var aSubSumRows = FindSubSumRow("inv_no").split("|");
			for (var i = 0; i < aSubSumRows.length - 1; i ++) {
				RowMerge(aSubSumRows[i]) = true;
			}

			// Sum Line Font Bold 처리
			var sSumRow = FindSubSumRow();
			var arrSumRow = sSumRow.split("|");
			for ( var i = 0 ; i < arrSumRow.length -1 ; i++ ) {
				SetMergeCell(arrSumRow[i], 2, 1, 7);
				CellFont("FontBold", arrSumRow[i], "inv_no")			= true;
				CellFont("FontBold", arrSumRow[i], "pay_rntl_cost_amt")	= true;
				CellFont("FontBold", arrSumRow[i], "hjs_ttl_chg_amt")	= true;
				CellFont("FontBold", arrSumRow[i], "cr_ttl_amt")		= true;
				CellFont("FontBold", arrSumRow[i], "inv_ttl_chg_amt")	= true;
			}
		}
	}

	/**
	 * sheet3 total 설정
	 * 
	 * @param sheetObj
	 * @return
	 */
	function sheet3_ShowSubSum(sheetObj) {
		var formObj = document.form;
		with(sheetObj) {
			HideSubSum("ibflag");

			if ( sheetObj.RowCount > 0 ) {
				var amt   = parseFloat(sheetObj.ComputeSum("|10|"));
				var crAmt = parseFloat(sheetObj.ComputeSum("|11|"));
				ComSetObjValue(formObj.inv_amt, (amt + crAmt).toFixed(2));
				ComSetObjValue(formObj.cr_amt,  crAmt.toFixed(2));

				ComAddSeparator(form.inv_amt, "float");
				ComAddSeparator(form.cr_amt,  "float");

				ComSetObjValue(formObj.curr_cd,       "USD");
				ComSetObjValue(formObj.vndr_term_nm,  ComGetObjValue(formObj.gen_pay_term_cd));
				ComSetObjValue(formObj.inv_ofc_cd,   usrOfcCd);
				ComSetObjValue(formObj.cost_ofc_cd,  usrOfcCd);
			}

			ShowSubSum("ibflag", "10|11", -1, false, false, 0, "inv_no=Total;vvd=;acct_cd=;cost_nm=;agmt_no=;lse_ctrt_no=;lse_pay_chg_tp_cd=;cntr_tpsz_cd=");
			ReNumberSeq();

			// Sum Line Font Bold 처리
			var sSumRow = FindSubSumRow();
			var arrSumRow = sSumRow.split("|");
			for ( var i = 0 ; i < arrSumRow.length -1 ; i++ ) {
				SetMergeCell(arrSumRow[i], 2, 1, 8);
				CellFont("FontBold", arrSumRow[i], "inv_no")		= true;
				CellFont("FontBold", arrSumRow[i], "ttl_cost_amt")	= true;
				CellFont("FontBold", arrSumRow[i], "cr_amt")		= true;
			}
		}
	}

	/**
	 * Pop-up Open
	 * 
	 * @param type
	 * @param Row
	 * @param Col
	 * @param SheetIdx
	 * @return
	 */
	function openPopupPage(type, Row, Col, SheetIdx) {
		var formObj = document.form;
		var sheetObj = sheetObjects[1];

		if ( type == "1" ) {
			if ( ComGetObjValue(formObj.chg_cost_yrmon) == "" ) {
				ComShowCodeMessage("LSE01098");
				return;
			}
			if ( ComGetObjValue(formObj.vndr_seq) == "" ) {
				ComShowCodeMessage("LSE01044");
				ComSetFocus(formObj.vndr_seq);
				return;
			}
			ComOpenPopup('/hanjin/EES_LSE_0008.do?chg_cost_yrmon='+ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon),"-",""), 820, 430, 'setPopData_InvoiceFileImport', '1,0', true);
		} else if ( type == "2" ) {
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 710, 470, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
		} else if ( type == "3" ) {
			var invNo     = "";
			var chgSeq    = "";
			var agmtCtyCd = "";
			var agmtSeq   = "";

			if ( sheetObj.RowCount < 1) {
				ComShowCodeMessage("LSE01119");
				return;
			}

			for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
				if ( sheetObj.CellValue(i, "chg_seq") != "" ) {
					if ( chgSeq == "" ) {
						invNo     = sheetObj.CellValue(i, "inv_no");
						chgSeq    = sheetObj.CellValue(i, "chg_seq");
						agmtCtyCd = sheetObj.CellValue(i, "agmt_cty_cd");
						agmtSeq   = sheetObj.CellValue(i, "agmt_seq");
					} else {
						invNo     = invNo     + "|" + sheetObj.CellValue(i, "inv_no");
						chgSeq    = chgSeq    + "|" + sheetObj.CellValue(i, "chg_seq");
						agmtCtyCd = agmtCtyCd + "|" + sheetObj.CellValue(i, "agmt_cty_cd");
						agmtSeq   = agmtSeq   + "|" + sheetObj.CellValue(i, "agmt_seq");
					}
				}
			}

			var sParam = "?chg_cost_yrmon="+ComReplaceStr(ComGetObjValue(formObj.chg_cost_yrmon),"-","");
			sParam = sParam + "&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
			sParam = sParam + "&vndr_nm="+ComGetObjValue(formObj.vndr_nm);
			sParam = sParam + "&inv_no="+invNo;
			sParam = sParam + "&chg_seq="+chgSeq;
			sParam = sParam + "&agmt_cty_cd="+agmtCtyCd;
			sParam = sParam + "&agmt_seq="+agmtSeq;

			ComOpenPopup('/hanjin/EES_LSE_0007_01.do'+sParam, 920, 550, 'setPopData_Audit', '1,0', true);
		} else if ( type == "4") {
			ComOpenPopup('/hanjin/COM_ENS_N13.do', 500, 420, 'setPopData_Currency', '1,0', true);
		} else if ( type == "5" ) {
			ComOpenPopup('/hanjin/COM_ENS_0C1.do', 710, 470, 'setPopData_PayVendor', '1,0,1,1,1,1,1,1', true);
		} else if ( type == "10" ) {
			var formObj = document.form;
    		var sUrl    = '/hanjin/COM_ENS_071.do';
			var iWidth  = 855;
			var iHeight = 435;
			var sTargetObjList = "ofc_cd:cost_ofc_cd";
			var sDisplay = "1,0,1,1,1,1,1,1";

			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
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
		var formObj  = document.form;

		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
		}
	}

	/**
	 * Lessor(Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_PayVendor(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.pay_vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.pay_vndr_nm,  aryPopupData[0][4]);
		}
	}

	/**
	 * Lessor Invoice File Import 완료 후 Pop-up Return Value 처리 부분
	 * 
	 * @return
	 */
	function setPopData_InvoiceFileImport() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		// 기존 check 된 sheet1 Checkbox Row Find
		setCheckedChgSeq(sheetObj);

		// 조회조건과 sheet1을 제외한 페이지 초기화 
		removePage(formObj);

		// sheet1 재조회
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	}

	/**
	 * Audit 완료 후 Pop-up Return Value 처리 부분
	 * 
	 * @return
	 */
	function setPopData_Audit() {
		var formObj  = document.form;
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];

		// 기존 check 된 sheet1 Checkbox Row Find
		setCheckedChgSeq(sheetObj1);

		// 조회조건과 sheet1을 제외한 페이지 초기화 
		removePage(formObj);

		// sheet1 재조회
		doActionIBSheet(sheetObj1, formObj, IBSEARCH);
	}

	/**
	 * Currency Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.curr_cd, aryPopupData[0][1]);
		}
	}

	/**
	 * BackEndJob 관련 Status='3, 4, 5' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj   = document.form;
		var sheetObj  = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		// 기존 BackEnd Job Type 설정(Charge Creation/Charge Delete/Invoice Creation)
		var backEndJobName = "";

		ComSetObjValue(form.f_cmd, COMMAND03);
		var sXml = sheetObj.GetSearchXml("EES_LSE_0007GS.do", FormQueryString(form));

		if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
			var jobState = ComGetEtcData(sXml, "jb_sts_flg")
	
			if ( jobState == "3" || jobState == "4" || jobState == "5" ) {
				if ( backEndJobType == COMMAND01 ) {
					backEndJobName = "Payable Charge Creation";
				} else if ( backEndJobType == COMMAND02 ) {
					backEndJobName = "Payable Charge Delete";
				} else if ( backEndJobType == COMMAND06 ) {
					backEndJobName = "Payable Invoice Creation";
				}
	
				// 재조회 시 Check 설정을 위하여 현재 Check 되어 있는 Row Index 를 구하여 Setting.
				setCheckedChgSeq(sheetObj);

				clearInterval(timer);	
				ComOpenWait(false);
				sheetObj.WaitImageVisible  = true;
				sheetObj2.WaitImageVisible = true;
			}
	
			if (jobState == "3") {
				ComShowCodeMessage("LSE01134", backEndJobName);
	
				// Invoice Creation 이 성공할 경우 해당 Row 의 CheckBox 는 Edit 불가이므로 Check 되면 안됨. 따라서, 위에서 Setting 한 값을 초기화 함.
				if ( backEndJobType == COMMAND06 ) {
					ComSetObjValue(formObj.checkedRows,    "");
					//ComSetObjValue(formObj.checkedChgSeqs, "");
				}
			} else if (jobState == "4") {
				// JOB 상태가 '4' 일 경우 Server 에서 EventException 발생하므로 아래 로직은 수행안됨.
				ComShowCodeMessage("LSE01135", backEndJobName);
			} else if (jobState == "5") {
				// JOB 상태가 '5' 인 경우 조회용 JOB 이 아니므로 아래 로직은 수행안됨.
				ComShowCodeMessage("LSE01125");
			}
	
			if ( jobState == "3" || jobState == "4" || jobState == "5" ) {
				// 조회조건과 sheet1을 제외한 페이지 초기화 
				removePage(formObj);
			
				// sheet1 재조회
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		} else {
			// 조회 결과가 'F' 인 경우 (Exception 발생)
			ComOpenWait(false);
			sheetObj.WaitImageVisible  = true;
			sheetObj2.WaitImageVisible = true;
			clearInterval(timer);
			sheetObjects[2].LoadSearchXml(sXml);
		}
	}

	/**
	 * sheet2, sheet3 초기화 및 하단 Invoice Creation Form 초기화.
	 * 
	 * @param formObj
	 * @return
	 */
	function removePage(formObj) {
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();

		removePage2(formObj);
	}

	/**
	 * 하단 Invoice Creation Form 부분 초기화.
	 * 
	 * @param formObj
	 * @return
	 */
	function removePage2(formObj) {
		ComSetObjValue(formObj.vndr_term_nm, "");
		ComSetObjValue(formObj.inv_rcv_dt,   "");
		ComSetObjValue(formObj.inv_iss_dt,   "");
		//ComSetObjValue(formObj.inv_eff_dt,   "");
		ComSetObjValue(formObj.inv_ofc_cd,   "");
		ComSetObjValue(formObj.cost_ofc_cd,  "");
		ComSetObjValue(formObj.curr_cd,      "");
		ComSetObjValue(formObj.inv_amt,      "");
		ComSetObjValue(formObj.cr_amt,       "");
		ComSetObjValue(formObj.inv_rmk,      "");
		ComSetObjValue(formObj.pay_vndr_seq, "");
		ComSetObjValue(formObj.pay_vndr_nm, "");
	}

	/**
	 * CheckBox 선택된 Row 의 Charge Sequence 및 Row Index 구하기.
	 * 
	 * @param sheetObj
	 * @return
	 */
	function setCheckedChgSeq(sheetObj) {
		var formObj = document.form;
		var sRow    = sheetObj.FindCheckedRow("chkbox");
		ComSetObjValue(formObj.checkedRows, sRow);
		/*
		var arrRow  = sRow.split("|");
		var chgSeqs = "";
		for ( var i = 0 ; i < arrRow.length-1 ; i++ ) {
			if ( i == 0 ) {
				chgSeqs = sheetObj.CellValue(arrRow[i], "chg_seq");
			} else {
				chgSeqs = chgSeqs + "|" + sheetObj.CellValue(arrRow[i], "chg_seq");
			}
		}
		ComSetObjValue(formObj.checkedChgSeqs, chgSeqs);
		*/
	}
/*
	function setInvEffDt(formObj, Value) {
		// 1. Receive Date 가 해당월이면 Effective Date 는 해당월 시작일
		// 2. 해당월이 아닐 경우 Effective Date = Receive Date
		var rcvDt = ComReplaceStr(Value, "-", "").substr(0, 6);
		var curDt = ComReplaceStr(ComGetNowInfo("ymd", "-"), "-", "").substr(0, 6);
		//ComDebug("rcvDt : " + rcvDt);
		//ComDebug("curDt : " + curDt);
		if ( ComParseInt(rcvDt) < ComParseInt(curDt) ) {
			ComSetObjValue(formObj.inv_eff_dt, curDt+"01");
		} else if ( ComParseInt(rcvDt) == ComParseInt(curDt) ) {
			ComSetObjValue(formObj.inv_eff_dt, Value);
		}

		ComAddSeparator(form.inv_eff_dt, "ymd");
	}
*/
	/* 개발자 작업  끝 */