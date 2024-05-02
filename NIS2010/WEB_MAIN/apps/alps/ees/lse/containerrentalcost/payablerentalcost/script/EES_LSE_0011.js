/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0011.js
*@FileTitle : Operational Lease Payable Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.09 노정용
* 1.0 Creation
* =========================================================
*  2010.09.13 남궁진호 [CHM-201005908-01] 
*    REV VVD ,TP/SZ, Payment Period가 중복되어 입력될경우 에러 메세지 발생 메세지 코드 [LSE01005]
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
	 * @class EES_LSE_0011 : EES_LSE_0011 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_LSE_0011() {
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

	var arrAgmtNoInfo = new Array();

	var preVndrSeq = "";
	var usrOfcCd      = "";

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObj = document.form;

		//try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_RowAdd":
					doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;

				case "btn_RowDelete":
					if ( ComShowCodeConfirm("COM12165", "") ) {
						doActionIBSheet(sheetObject1, formObj, IBDELETE);
					}
					break;

				case "btn_SoCreate":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;

				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
					ComSetObjValue(formObj.usr_ofc_cd, usrOfcCd);
					break;

				case "btns_calendar1":
					var cal = new ComCalendar();
	                cal.select(formObj.bil_fm_dt, 'yyyy-MM-dd');
					break;

				case "btns_calendar2":
					var cal = new ComCalendar();
	                cal.select(formObj.bil_to_dt, 'yyyy-MM-dd');
					break;

				case "btns_calendar3":
					var cal = new ComCalendar();
	                cal.select(formObj.inv_rcv_dt, 'yyyy-MM-dd');
					break;

				case "btns_calendar4":
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
		//}catch(e) {
		//	if( e == "[object Error]") {
		//		ComShowMessage(OBJECT_ERROR);
		//	} else {
		//		ComShowMessage(e);
		//	}
		//}
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
	    	case "bil_to_dt":
	    		ComChkObjValid(obj);
	    		checkEffDate(formObj.bil_fm_dt, formObj.bil_to_dt);
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
  		var vKeyCode = event.keyCode;

  		switch(obj.name) {
			case "bil_fm_dt":
			case "bil_to_dt":
				if ( vKeyCode == 13 ) {
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
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
	    		case "curr_cd":
	    			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
				   	break;

	    		case "cost_ofc_cd":			//Office Code
					if ( ComTrim(obj.value) != "" ) {
						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
					}
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
					style.height = 170;

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

					var HeadTitle1 = "|Sel.|STS|Lessor|Paymeny Period|Paymeny Period|REV VVD|REV VVD|REV VVD|REV VVD|Date|TP/SZ|Qty.|AGMT No.|Contract No.|Lessor\nName|Currency|Principal|Balance|Interest|Libor|Payment|Invoice No|Remarks||||||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtCheckBox,		30,		daCenter,	false,	"chkbox");
					InitDataProperty(0, cnt++, dtData,			30,		daCenter,	false,	"op_lse_sts_cd",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtCombo,			60,		daCenter,	false,	"vndr_seq",			true,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++, dtData,			130,	daCenter,	false,	"bil_fm_dt",		true,	"",	dfDateYmd,	0,	true,	true,	8);

					InitDataProperty(0, cnt++, dtData,			130,	daCenter,	false,	"bil_to_dt",		true,	"",	dfDateYmd,	0,	true,	true,	8);
					InitDataProperty(0, cnt++, dtData,			33,		daCenter,	false,	"vsl_cd",			false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			33,		daCenter,	false,	"skd_voy_no",		true,	"",	dfNone,		0,	true,	true,	4);
					InitDataProperty(0, cnt++, dtData,			14,		daCenter,	false,	"skd_dir_cd",		false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			14,		daCenter,	false,	"rev_dir_cd",		false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			70,		daCenter,	false,	"pay_dt",			true,	"",	dfDateYmd,	0,	true,	true,	8);
					InitDataProperty(0, cnt++, dtCombo,			55,		daCenter,	false,	"cntr_tpsz_cd",		true,	"",	dfNone,		0,	true,	true);
					InitDataProperty(0, cnt++, dtData,			50,		daRight,	false,	"op_lse_qty",		true,	"",	dfInteger,	0,	true,	true,	6);
					InitDataProperty(0, cnt++, dtCombo,			70,		daCenter,	false,	"agmt_no",			false,	"",	dfNone,		0,	false,	true);
					InitDataProperty(0, cnt++, dtData,			90,		daLeft,		false,	"lse_ctrt_no",		false,	"",	dfNone,		0,	false,	false);

					InitDataProperty(0, cnt++, dtData,			120,	daLeft,		false,	"vndr_lgl_eng_nm",	false,	"",	dfNone,		0,	false,	false);
					InitDataProperty(0, cnt++, dtData,			70,		daCenter,	false,	"curr_cd",			true,	"",	dfNone,		0,	false,	false,	3);
					InitDataProperty(0, cnt++, dtData,			80,		daRight,	false,	"prin_amt",			false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			80,		daRight,	false,	"bal_amt",			false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			80,		daRight,	false,	"int_amt",			false,	"",	dfFloat,	2,	true,	true,	10);

					InitDataProperty(0, cnt++, dtData,			80,		daRight,	false,	"libor_amt",		false,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			80,		daRight,	false,	"pay_amt",			true,	"",	dfFloat,	2,	true,	true,	10);
					InitDataProperty(0, cnt++, dtData,			100,	daCenter,	false,	"inv_no",			true,	"",	dfNone,		0,	true,	true,	20);
					InitDataProperty(0, cnt++, dtData,			130,	daCenter,	false,	"diff_rmk",			false,	"",	dfNone,		0,	true,	true,	250);
					InitDataProperty(0, cnt++, dtHidden,		40,		daCenter,	false,	"op_seq",			false,	"",	dfNone,		0);

					InitDataProperty(0, cnt++, dtHidden,		40,		daCenter,	false,	"agmt_cty_cd",		false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	false,	"agmt_seq",			false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	false,	"co_ofc_cd",		false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	false,	"cre_ofc_cd",		false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	false,	"acct_cd",			false,	"",	dfNone,		0);

					InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	false,	"cost_cd",			false,	"",	dfNone,		0);
					InitDataProperty(0, cnt++, dtHidden,		50,		daCenter,	false,	"cost_nm",			false,	"",	dfNone,		0);

					InitDataValid(0, "skd_voy_no",	vtNumericOnly);

					CountPosition = 0;
				}
				break;

			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 100

					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|Seq.|Invoice No.|VVD|Cost Code|Cost Name|AGMT No.|Contract No.|Charge\nType|TP/SZ|Amount|Credit Amount|||||";
					var headCount = ComCountHeadTitle(HeadTitle1);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,	false,	"Seq");
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"inv_no", 				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"vvd", 					false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"acct_cd", 				false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtData,			170,	daLeft,		true,	"cost_nm", 				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"agmt_no",				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"lst_ctrt_no",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	false,	"lse_pay_chg_tp_cd",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"cntr_tpsz_cd",			false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"ttl_cost_amt", 		false,	"",	dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	"cr_amt", 				false,	"",	dfNullFloat,	2);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"agmt_cty_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"agmt_seq",				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"op_seq",				false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"cost_cd",				false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,	true,	"op_lse_qty",			false,	"",	dfNone);

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
			case "vndr_seq":
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
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;

				/* Multi Combo Setting : Lessor */
				comboObjects[0].InsertItem(0, "130131|ICC", "130131");
				comboObjects[0].InsertItem(1, "146684|UINTAS", "146684");
				comboObjects[0].SetColWidth("60|80");
        		comboObjects[0].Index = 1;

        		/* Sheet Combo Setting : Container Type Size */
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var sXml1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				if ( ComGetEtcData(sXml1,"TRANS_RESULT_KEY") == "S" ) {
					sheetObj.InitDataCombo(0, "cntr_tpsz_cd", ComGetEtcData(sXml1, "cntr_tpsz_nm"), ComGetEtcData(sXml1, "cntr_tpsz_cd"));
				}

				/* Sheet Combo Setting : Lessor */
				sheetObj.InitDataCombo(0, "vndr_seq", "UINTAS\t146684|ICC\t130131", "146684|130131", "UINTAS", "146684", 0);

				/* Sheet Combo Setting : Agreement No. */
				var sParam = "f_cmd=" + SEARCH15;
				sParam = sParam + "&vndr_seq=146684|130131";
				var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", sParam);
				if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
					var agmtNoLists   = ComGetEtcData(sXml, "agmt_no_list");
					var arrAgmtNoList = agmtNoLists.split("^");
					for ( var i = 0 ; i < arrAgmtNoList.length ; i++ ) {
						var agmtNoInfos  = arrAgmtNoList[i];
						arrAgmtNoInfo[i] = agmtNoInfos.split("|");
					}
				}

				var agmtNos = "";
				for ( var i = 0 ; i < arrAgmtNoInfo.length ; i++ ) {
					if ( agmtNos == "" ) {
						agmtNos = arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
					} else {
						agmtNos = agmtNos + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
					}
				}
				sheetObj.InitDataCombo(0, "agmt_no", agmtNos, agmtNos);

				/* 초기 Focus Setting */
				ComSetFocus(formObj.bil_fm_dt);
				sheetObj.WaitImageVisible = true;
				break;

			case IBSEARCH:      //조회
				if ( validateForm(sheetObj, formObj, sAction) ) {
					switch (sheetObj.id) {
						case "sheet1":
							ComSetObjValue(formObj.f_cmd, SEARCH);

							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);
							var sXml = sheetObj.GetSearchXml("EES_LSE_0011GS.do", FormQueryString(formObj));
							if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
								sheetObj.LoadSearchXml(sXml);
							}
							ComOpenWait(false);

							break;
					}
				}
				break;

			case IBSAVE:        //저장
				if ( validateForm(sheetObj, formObj, sAction) ) {
					switch (sheetObj.id) {
						case "sheet1":
							ComSetObjValue(formObj.f_cmd, MULTI);
//							var sSheetParam = sheetObjects[0].GetSaveString();							
							sheetObj.DoSave("EES_LSE_0011GS.do", FormQueryString(formObj));
							break;

						case "sheet2":
							ComSetObjValue(formObj.f_cmd, COMMAND01);

							var sParam = FormQueryString(formObj);

							var sSheetParam = sheetObjects[0].GetSaveString(false, false, "chkbox");
							sSheetParam = ComSetPrifix(sSheetParam, "sheet1_");
							sParam = sParam + "&" + sSheetParam;

							sheetObj.HideSubSum("ibflag");

							var sSheetParam2 = sheetObj.GetSaveString(true);
							sSheetParam2 = ComSetPrifix(sSheetParam2, "sheet2_");
							sParam = sParam + "&" + sSheetParam2;

							var sXml = sheetObj.GetSaveXml("EES_LSE_0011GS.do" , sParam);

							if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
								ComSetObjValue(formObj.backendjob_key, ComGetEtcData(sXml,"BackEndJobKey"));
								sheetObjects[0].WaitImageVisible = false;
								sheetObj.WaitImageVisible = false;
								ComOpenWait(true);
								sheetObj.RequestTimeOut = 10000;
								timer = setInterval(getBackEndJobStatus, 3000);
							}
							break;
					}
				}
				break;

			case IBINSERT:      // 입력
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var rowIdx = sheetObj.DataInsert(-1);
					sheetObj.CellValue(rowIdx, "vndr_seq")       = ComGetObjValue(formObj.vndr_seq);
					sheetObj.CellEditable(rowIdx, "vndr_seq")    = false;
					sheetObj.CellValue2(rowIdx, "op_lse_sts_cd") = "H";
					sheetObj.CellValue2(rowIdx, "vsl_cd")        = "CNTC";
					sheetObj.CellValue2(rowIdx, "skd_dir_cd")    = "M";
					sheetObj.CellValue2(rowIdx, "rev_dir_cd")    = "M";
					sheetObj.CellValue2(rowIdx, "co_ofc_cd")     = usrOfcCd;
					sheetObj.CellValue2(rowIdx, "cre_ofc_cd")    = usrOfcCd;
					sheetObj.CellValue2(rowIdx, "curr_cd")       = "USD";
					sheetObj.CellValue2(rowIdx, "bil_fm_dt")     = ComReplaceStr(ComGetObjValue(formObj.bil_fm_dt), "-", "");
					sheetObj.CellValue2(rowIdx, "bil_to_dt")     = ComReplaceStr(ComGetObjValue(formObj.bil_to_dt), "-", "");

					/* Sheet Combo Item Setting */
					setSheetComboAgmtNo(sheetObj, rowIdx);
					/* Sheet Data Item Setting */
					setSheetDataCtrtNo(sheetObj, rowIdx);
				}
				break;

			case IBDELETE:
				var sheetObj2 = sheetObjects[1];
				var chkRows   = sheetObj.FindCheckedRow("chkbox");
				var arrChkRow = chkRows.split("|");

				for ( var i = 0 ; i < arrChkRow.length-1 ; i++ ) {
					var delRowIdx = sheetObj2.FindText("agmt_no", sheetObj.CellValue(arrChkRow[i], "agmt_no"));
					sheetObj2.RowDelete(delRowIdx, false);
				}

				removePage2();
				sheet2_ShowSubSum(sheetObj2);

				ComRowHideDelete(sheetObj, "chkbox");
				break;

			case IBSEARCH_ASYNC01:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					if ( sheetObj.id == "sheet1" ) {
						var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								//ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetObjValue(formObj.gen_pay_term_cd, ComGetEtcData(sXml, "gen_pay_term_cd"));
								ComSetNextFocus(formObj.vndr_seq);
							} else {
	 							ComShowCodeMessage("LSE01019");
	 							//ComSetObjValue(formObj.vndr_seq, "");
	 							//ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetObjValue(formObj.gen_pay_term_cd, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							//ComSetObjValue(formObj.vndr_seq, "");
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
		}
	}

	function vndr_seq_OnChange(comboObj, Index, Text) {
		var formObj = document.form;

		// 화면 초기 로딩시 preVndrSeq = "" 임.
		if ( preVndrSeq != "" && sheetObjects[0].RowCount > 0 ) {
			if (ComShowCodeConfirm("LSE01127", "")) {
				preVndrSeq = ComGetObjValue(comboObj);

				sheetObjects[0].RemoveAll();
				removePage();

				/* Vendor Pay Term Code 조회 */
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
			} else {
				comboObj.Code2 = preVndrSeq;
			}
		} else {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC01);
			preVndrSeq = ComGetObjValue(comboObj);
		}
	}

	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;

		/* IBMulti Combo Item Setting */
		doActionIBSheet(sheetObj, formObj, IBCREATE);

		/* Vendor Pay Term Code 조회 */
		doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj = document.form;

		if ( ErrMsg == "" ) {
			for ( var i = sheetObj.HeaderRows ; i <= sheetObj.LastRow ; i++ ) {
				if ( sheetObj.CellValue(i, "op_lse_sts_cd") ==  "I" ) {
					sheetObj.RowEditable(i) = false;
				} else if ( sheetObj.CellValue(i, "op_lse_sts_cd") ==  "S" ) {
					setSheetComboAgmtNo(sheetObj, i);
				}
			}
			removePage();
		}
	}

	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		var formObj = document.form;
		if ( ErrMsg == "" ) {
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		removePage();
	}

	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj   = document.form;
		var colName   = sheetObj.ColSaveName(Col);
		var sheetObj2 = sheetObjects[1];

		switch (colName) {
			case "chkbox":
				if ( Value == "1" ) {
					var newRowIdx = sheetObj2.DataInsert(-1);

					sheetObj2.CellValue2(newRowIdx, "inv_no")            = sheetObj.CellValue(Row, "inv_no");
					sheetObj2.CellValue2(newRowIdx, "vvd")               = sheetObj.CellValue(Row, "vsl_cd")+sheetObj.CellValue(Row, "skd_voy_no")+sheetObj.CellValue(Row, "skd_dir_cd")+sheetObj.CellValue(Row, "rev_dir_cd");
					sheetObj2.CellValue2(newRowIdx, "acct_cd")           = sheetObj.CellValue(Row, "acct_cd");
					sheetObj2.CellValue2(newRowIdx, "cost_nm")           = sheetObj.CellValue(Row, "cost_nm");
					sheetObj2.CellValue2(newRowIdx, "agmt_no")           = sheetObj.CellValue(Row, "agmt_no");
					sheetObj2.CellValue2(newRowIdx, "lst_ctrt_no")       = sheetObj.CellValue(Row, "lst_ctrt_no");
					sheetObj2.CellValue2(newRowIdx, "lse_pay_chg_tp_cd") = 'OPL';
					sheetObj2.CellValue2(newRowIdx, "cntr_tpsz_cd")      = sheetObj.CellValue(Row, "cntr_tpsz_cd");
					sheetObj2.CellValue2(newRowIdx, "ttl_cost_amt")      = sheetObj.CellValue(Row, "pay_amt");
					sheetObj2.CellValue2(newRowIdx, "cr_amt")            = 0;
					sheetObj2.CellValue2(newRowIdx, "agmt_cty_cd")       = sheetObj.CellValue(Row, "agmt_cty_cd");
					sheetObj2.CellValue2(newRowIdx, "agmt_seq")          = sheetObj.CellValue(Row, "agmt_seq");
					sheetObj2.CellValue2(newRowIdx, "op_seq")            = sheetObj.CellValue(Row, "op_seq");
					sheetObj2.CellValue2(newRowIdx, "cost_cd")           = sheetObj.CellValue(Row, "cost_cd");
					sheetObj2.CellValue2(newRowIdx, "op_lse_qty")        = sheetObj.CellValue(Row, "op_lse_qty");

				} else {
					var delRowIdx = sheetObj2.FindText("agmt_no", sheetObj.CellValue(Row, "agmt_no"));
					sheetObj2.RowDelete(delRowIdx, false);
				}

				sheet2_ShowSubSum(sheetObj2);
				break;

			case "vndr_seq":
				setSheetComboAgmtNo(sheetObj, Row);
				setSheetDataCtrtNo(sheetObj, Row);
				break;

			case "agmt_no":
				setSheetDataCtrtNo(sheetObj, Row);
				break;

			case "skd_voy_no":
				
				// Rev Voyage 가  4자리 이상, "0000" 포멧 유지하도록 한다.
				if(!(ComChkLen(Value, 4) == 2) || !ComIsMonth(Value.substr(2,2)) ) {
					sheetObj.CellValue2(Row, Col) = "";
					return;
				}

				checkVoyageCntrTp(sheetObj, Row, Col, Value);
				break;
			case "cntr_tpsz_cd":
				checkVoyageCntrTp(sheetObj, Row, Col, Value);
				break;
			case "bil_to_dt":
				checkVoyageCntrTp(sheetObj, Row, Col, Value);
				break;
			default :
				
				if ( sheetObj.CellValue(Row, "ibflag") == "U" && sheetObj.CellValue(Row, "chkbox") == "1" ) {
					var rowIdx = sheetObj2.FindText("agmt_no", sheetObj.CellValue(Row, "agmt_no"));

					sheetObj2.CellValue2(rowIdx, "vvd")          = sheetObj.CellValue(Row, "vsl_cd")+sheetObj.CellValue(Row, "skd_voy_no")+sheetObj.CellValue(Row, "skd_dir_cd")+sheetObj.CellValue(Row, "rev_dir_cd");
					sheetObj2.CellValue2(rowIdx, "cntr_tpsz_cd") = sheetObj.CellValue(Row, "cntr_tpsz_cd");
					sheetObj2.CellValue2(rowIdx, "ttl_cost_amt") = sheetObj.CellValue(Row, "pay_amt");
					sheetObj2.CellValue2(rowIdx, "op_lse_qty")   = sheetObj.CellValue(Row, "op_lse_qty");

					sheet2_ShowSubSum(sheetObj2);
				}
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * vvd 입력시 Paymeny Period의 ToDate,TP/SZ이 동일한지 체크하는 로직.
	 */
	function checkVoyageCntrTp (sheetObj, Row, Col, Value){
		var	i;
		var rowCnt = sheetObj.RowCount;
		var totalCnt = rowCnt;
		var srcData = sheetObj.CellValue(Row, "bil_to_dt") + sheetObj.CellValue(Row, "skd_voy_no") + sheetObj.CellValue(Row, "cntr_tpsz_cd");
		var targetData;
		
		if (ComIsNull(Value)) return;
		
		for (i=1; i<=totalCnt ; i++){
			if (i!=Row){
				targetData = sheetObj.CellValue(i, "bil_to_dt") + sheetObj.CellValue(i, "skd_voy_no") + sheetObj.CellValue(i, "cntr_tpsz_cd");
				if (srcData == targetData) {// 중복이 발생했을 경우.
					ComShowCodeMessage("LSE01005", "Payment Period,REV VVD,TP/SZ");
					sheetObj.CellValue2(Row, Col) = "";
					return;
				}
			}
		}		
		
		return;
	}
	
	function setSheetComboAgmtNo(sheetObj, Row) {
		var Value = sheetObj.CellValue(Row, "vndr_seq");
		var agmtNos = "";
		for ( var i = 0 ; i < arrAgmtNoInfo.length ; i++ ) {
			if ( Value == arrAgmtNoInfo[i][0] ) {
				if ( agmtNos == "" ) {
					agmtNos = arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
				} else {
					agmtNos = agmtNos + "|" + arrAgmtNoInfo[i][1] + ComLpad(arrAgmtNoInfo[i][2], 6, "0");
				}
			}
		}
		sheetObj.CellComboItem(Row, "agmt_no", agmtNos, agmtNos);
	}

	function setSheetDataCtrtNo(sheetObj, Row) {
		var agmtNo = sheetObj.CellValue(Row, "agmt_no");

		sheetObj.CellValue2(Row, "agmt_cty_cd") = agmtNo.substr(0, 3);
		sheetObj.CellValue2(Row, "agmt_seq")    = ComLtrim(agmtNo.substr(3), "0");

		var agmtSeq = ComLtrim(agmtNo.substr(3), "0");

		for ( var i = 0 ; i < arrAgmtNoInfo.length ; i++ ) {
			if ( agmtSeq == arrAgmtNoInfo[i][2] ) {
				sheetObj.CellValue2(Row, "lse_ctrt_no") = arrAgmtNoInfo[i][3];
			}
		}
	}

	function sheet2_ShowSubSum(sheetObj) {
		var formObj = document.form;
		with(sheetObj) {
			HideSubSum("ibflag");
			if ( sheetObj.RowCount > 0 ) {
				var amt   = sheetObj.ComputeSum("|10|");
				var crAmt = sheetObj.ComputeSum("|11|");
				var qty   = sheetObj.ComputeSum("|16|");

				ComSetObjValue(formObj.lse_op_qty, qty);
				ComSetObjValue(formObj.pay_amt, amt);

				ComSetObjValue(formObj.inv_amt, amt);
				ComSetObjValue(formObj.cr_amt,  crAmt);

				ComAddSeparator(form.lse_op_qty, "int");
				ComAddSeparator(form.pay_amt, "float");
				ComAddSeparator(form.inv_amt, "float");
				ComAddSeparator(form.cr_amt, "float");

				ComSetObjValue(formObj.vndr_term_nm,  ComGetObjValue(formObj.gen_pay_term_cd));
				ComSetObjValue(formObj.inv_ofc_cd,  usrOfcCd);
				ComSetObjValue(formObj.cost_ofc_cd, usrOfcCd);

				ComSetObjValue(formObj.curr_cd,       "USD");
			}
			ShowSubSum("ibflag", "10|11", -1, false, false, 0, "inv_no=;vvd=;acct_cd=;cost_nm=Total;agmt_no=;lse_ctrt_no=;lse_pay_chg_tp_cd=;cntr_tpsz_cd=");
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
			case IBSAVE:
			case IBINSERT:
				return ComChkValid(formObj);
				break;
		}

		return true;
	}

	/**
	 * Effective Date Validation 처리 부분<br>
	 */
    function checkEffDate(obj1, obj2) {
    	var formObj = document.form;

		/* Date Validation(eff_dt < exp_dt) */
		var vEffDt = ComReplaceStr(ComGetObjValue(obj1),"-","");
		if ( vEffDt == "" ) return false;
		var vExpDt = ComReplaceStr(ComGetObjValue(obj2),"-","");
		if ( vExpDt == "" ) return false;
		if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
			ComShowCodeMessage("LSE01115");
			ComSetObjValue(obj2,"");
			ComSetFocus(obj2);
			return false;
		}
		return true;
    }

    
    
	function removePage() {
		sheetObjects[1].RemoveAll();
		removePage2();
	}

	function removePage2() {
		var formObj = document.form;

		ComSetObjValue(formObj.lse_op_qty,   "");
		ComSetObjValue(formObj.pay_amt,      "");
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
	}

	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj   = document.form;
		var sheetObj  = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];

		ComSetObjValue(form.f_cmd, COMMAND02);
		var sXml = sheetObj.GetSearchXml("EES_LSE_0011GS.do", FormQueryString(form));
		if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
			var jobState = ComGetEtcData(sXml, "jb_sts_flg")

			if (jobState == "3") {
				sheetObj.WaitImageVisible  = true;
				sheetObj2.WaitImageVisible = true;
				ComOpenWait(false);
				clearInterval(timer);

				ComShowCodeMessage("LSE01121");
			} else if (jobState == "4") {
				sheetObj.WaitImageVisible  = true;
				sheetObj2.WaitImageVisible = true;
				ComOpenWait(false);
				clearInterval(timer);

				ComShowCodeMessage("LSE01124");
			} else if (jobState == "5") {
				sheetObj.WaitImageVisible  = true;
				sheetObj2.WaitImageVisible = true;
				ComOpenWait(false);
				clearInterval(timer);

				ComShowCodeMessage("LSE01125");
			}

			removePage();
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		} else {
			// 조회 결과가 'F' 인 경우 (Exception 발생)
			ComOpenWait(false);
			sheetObj.WaitImageVisible  = true;
			sheetObj2.WaitImageVisible = true;
			clearInterval(timer);
			sheetObj2.LoadSearchXml(sXml);
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

		if ( type == "10" ) {
			var formObj = document.form;
    		var sUrl    = '/hanjin/COM_ENS_071.do';
			var iWidth  = 855;
			var iHeight = 435;
			var sTargetObjList = "ofc_cd:cost_ofc_cd";
			var sDisplay = "1,0,1,1,1,1,1,1";

			ComOpenPopupWithTarget(sUrl, iWidth, iHeight, sTargetObjList, sDisplay, true);
		}
	}
	/* 개발자 작업  끝 */