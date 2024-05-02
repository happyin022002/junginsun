/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0034.js
*@FileTitle : New Van CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.18 장준우
* 1.0 Creation
* ====================================================
* 2010.12.03 박명신 [CHM-201007443-01] REF_NO 항목 추가
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
     * @author 한진해운
     */

    /**
     * @extends
     * @class EES_LSE_0034 : EES_LSE_0034 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0034() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;

    	this.obj_blur 				= obj_blur;
    	this.obj_focus 				= obj_focus;
    	this.obj_change 			= obj_change;
    	this.obj_keypress 			= obj_keypress;
    	this.obj_keyup 				= obj_keyup;
    	this.obj_keydown 			= obj_keydown;
    	this.obj_click				= obj_click;

    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.sheet1_OnScrollNext 	= sheet1_OnScrollNext;
    	this.sheet1_OnChange 		= sheet1_OnChange;
    	this.sheet1_OnPopupClick 	= sheet1_OnPopupClick;
    	this.sheet1_OnValidation 	= sheet1_OnValidation;
    	this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
    	this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    	this.sheet1_OnLoadExcel		= sheet1_OnLoadExcel;

    	this.openPopup 				= openPopup;
    	this.setPopData_Agreement   = setPopData_Agreement;
    	this.setPopData_DeliveryLoc = setPopData_DeliveryLoc;
    	this.validateForm 			= validateForm;
    	this.clearForm 				= clearForm;
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

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObj = document.form;

     	try {
 			var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

 				case "btn_New":
					ComResetAll();

					// 조회 전 데이터 가공 방지를 위한 버튼 콘트롤
					LseComBtnControl(false, "btn_RowAdd|btn_Delete");

					ComSetFocus(formObj.pln_yrmon);
 					break;

 				case "btn_Save":
 					doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
 					break;

 				case "btn_RowAdd":
 					if ( ComIsBtnEnable(srcName) ) {
 						doActionIBSheet(sheetObjects[0], formObj, IBINSERT);
 					} else {
 						ComSetFocus(formObj.pln_yrmon);
 					}
 					break;

 				case "btn_Delete":
 					if ( ComIsBtnEnable(srcName) ) {
 						ComRowHideDelete(sheetObject1, "del_chk");
 					} else {
 						ComSetFocus(formObj.pln_yrmon);
 					}
 					break;

 				case "btns_calendar1":
 					var cal = new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObj.pln_yrmon, 'yyyy-MM');
             	 	break;

				case "btn_LoadExcel":
					doActionIBSheet(sheetObject1,formObj,IBLOADEXCEL);
				break;

             	case "btn_DownExcel":
					sheetObject1.SpeedDown2Excel(-1,false,false,"","",false,false,"",false,"del_chk|last_chk");
					break;

 			} // end switch
     	} catch(e) {
     		if(e == "[object Error]") {
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
    function setSheetObject(sheet_obj) {
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;

		for(i = 0; i < sheetObjects.length; i++) {
	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i], i+1);
	        //khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
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

    	/* 조회 전 데이터 가공 방지를 위한 버튼 콘트롤 */
    	LseComBtnControl(false, "btn_RowAdd|btn_Delete");

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
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('change',   	'obj_change',  	formObj); //- 변경될때.
		axon_event.addListenerForm('click',			'obj_click',	formObj); //- 클릭하였을 때
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur() {
		var obj = event.srcElement;

		if(preEventType == event.type) {
			preEventType = null;
			return;
		}

	    switch(obj.name) {
	    	case "pln_yrmon":
  				//Validation 전체 체크(길이,format,최대,최소 등등)
	            if(ComChkObjValid(obj)) {
	            	document.form.cre_usr_id.focus();
	            } else {
	            	ComSetFocus(obj);
	            }

	    		break;
	        default: //do nothing
	    }

	    preEventType = event.type;
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus() {
		var obj = event.srcElement;

	    if(obj.readOnly) {
	    	//ComSetNextFocus(obj);
	    } else {
	    	//마스크구분자 없애기
		    ComClearSeparator(obj);
	    }
	}

	/**
	 * Change Event 처리
	 */
	function obj_change() {
		var obj = event.srcElement;
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
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "pln_yrmon":
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

   		if(vKeyCode == 13) {
   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
   		}
   	}

   	/**
     * Click Event 처리
     */
   	function obj_click() {
   		var obj      = event.srcElement;
  		var vKeyCode = event.keyCode;
  		var formObj  = document.form;

  		switch (obj.name) {
  			case "cre_usr_id":
  				if(obj.value != "") {
  					//사용자정보 화면을 팝업한다.
					ComUserPopup(obj.value);
  				}
  				break;
  		}
   	}
  	//2. 이벤트처리함수 -- End


  	/**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		var sheetid = sheetObj.id;

		switch(sheetid) {
			case "sheet1":
				with(sheetObj) {
					// 높이 설정
					style.height = 420;
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

					var HeadTitle1 = "|Sel.|Seq.|Year|Month|||AGMT No.|AGMT No.|Ref No.|Lease Term|Manufacturer|Delivery SCC|TP/SZ|Delivery Month|Q'ty||Remark";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 9, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);


					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no");

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"pln_yr",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		60,		daCenter,	true,	"pln_mon",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"pln_yrmon",	false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"pln_seq",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"agmt_cty_cd",	false,	"",	dfEngUpKey,    0,		false,		false);
					InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	"agmt_seq",		true,	"",	dfNone, 	   0,		true,		true,	6);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,	"ref_no",		false,	"",	dfNone, 	   0,		false,		false,	6);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"lstm_cd",		false,	"",	dfEngUpKey,    0,		false,		false);
					InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	"mft_vndr_seq",	true,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtPopupEdit,	100,	daCenter,	true,	"del_cd",		true,	"",	dfEngUpKey,    0,		true,		true, 	5);
					InitDataProperty(0, cnt++ , dtCombo,		100,	daCenter,	true,	"cntr_tpsz_cd",	true,	"",	dfNone,        0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,	"new_van_yrmon",true,	"",	dfDateYm,      0,		true,		true);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	false,	"de_qty",		true,	"",	dfInteger, 	   0,		true,		true,	6);
					InitDataProperty(0, cnt++ , dtHidden,		60,		daCenter,	true,	"last_chk",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			350,	daLeft,		false,	"pln_rmk",		false,	"",	dfEngUpKey,	   0,		true,		true, 	1000);

					InitDataValid(0, "agmt_seq",	 vtNumericOnly);
					//InitDataValid(0, "mft_vndr_seq", vtEngUpOther, "0123456789-,.() ");
					InitDataValid(0, "del_cd",		 vtEngUpOnly);
					InitDataValid(0, "pln_rmk",		 vtEngOther,   "0123456789-,.() ");

					InitDataCombo(0, "pln_mon", "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec", "01|02|03|04|05|06|07|08|09|10|11|12");

					ShowButtonImage = 0;
					SelectBackColor = LSE_SELECT_BACK_COLOR;

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					//CountPosition = 0;
				}
				break;
		}
	}

	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @param CondParam
	 * @param PageNo
	 */
    function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
        sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBCREATE:
				sheetObj.WaitImageVisible = false;
				//Container Type/Size Grid Combo Item Setting
				formObj.f_cmd.value = SEARCH02;
				var sXml_1 = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));
				//Manufacturer Grid Combo Item Setting
				formObj.f_cmd.value = SEARCH09;
				var sXml_2 = sheetObj.GetSearchXml("EES_LSE_COMGS.do",FormQueryString(formObj));

				//sheetObj.WaitImageVisible = true;
				if(sXml_1 != "") {
					sheetObj.InitDataCombo(0, "cntr_tpsz_cd", ComGetEtcData(sXml_1, "cntr_tpsz_nm"), ComGetEtcData(sXml_1, "cntr_tpsz_cd"));
				}
				if(sXml_2 != "") {
					var vCols = ComLseXml2ComboString(sXml_2, "vndr_seq", "vndr_seq|vndr_abbr_nm", "\t");
					sheetObj.InitDataCombo(0, "mft_vndr_seq", vCols[1], vCols[0], "","",1);
				}
				break;
			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.DoSearch4Post("EES_LSE_0034GS.do",FormQueryString(formObj));
						ComOpenWait(false);
					}
				}
				break;
			case IBSEARCHAPPEND:	//조회(페이징처리)
				if(sheetObj.id == "sheet1") {
					formObj.f_cmd.value = SEARCH;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.DoSearch4Post("EES_LSE_0034GS.do", CondParam, "iPage="+ PageNo, true);
					ComOpenWait(false);
				}
				break;
			case IBINSERT:			// 입력
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						var Row = sheetObj.DataInsert(-1);
						var arrCode = sheetObj.GetComboInfo(0,"mft_vndr_seq", "Code").split("|");

						sheetObj.CellValue2(Row,"pln_yr")     = formObj.pln_yrmon.value.split("-")[0];
						sheetObj.CellValue2(Row,"pln_mon")    = formObj.pln_yrmon.value.split("-")[1];
						sheetObj.CellValue2(Row,"pln_yrmon")  = formObj.pln_yrmon.value.replaceStr("-");
						sheetObj.CellValue2(Row,"agmt_cty_cd") = "HHO";
						sheetObj.CellValue2(Row,"mft_vndr_seq") = "";
						sheetObj.CellValue2(Row,"mft_vndr_seq") = arrCode[0];
						sheetObj.SelectCell(Row,"agmt_seq");
					}
				}
				break;
			case IBLOADEXCEL://EXCEL UPLOAD
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						sheetObj.LoadExcel(-1);
					}
				}
				break;
			case IBSAVE:			//저장
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true, "mainTable");

				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = MULTI;
						sheetObj.DoSave("EES_LSE_0034GS.do", FormQueryString(formObj));
					}
				}

				ComOpenWait(false, "mainTable");
				sheetObj.WaitImageVisible = true;
				break;
		}
    }

  	/**
	 * Sheet의 OnScrollNext Event 처리부분.<br>
	 * @param sheetObj
	 * @param CondParam
	 * @param PageNo
	 * @param OnePageRows
	 */
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}

	/**
	 * Sheet의 OnChange Event 처리부분.<br>
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj = document.form;

		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "agmt_seq":
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="  + SEARCH03
 								 + "&agmt_cty_cd=HHO"
 								 + "&agmt_seq="+ CellValue(Row,Col);
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
 						WaitImageVisible = true;

 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "agmt_seq") != undefined) {
				 				if (ComGetEtcData(sXml, "agmt_seq") != "") {
				 					CellValue2(Row,Col)       = ComGetEtcData(sXml, "agmt_seq");
				 					CellValue2(Row,"lstm_cd") = "";
				 					CellValue(Row,"lstm_cd")  = ComGetEtcData(sXml, "lstm_cd");
				 					CellValue(Row,"ref_no")  = ComGetEtcData(sXml, "ref_no");
		 						} else {
		 							ComShowCodeMessage("LSE01039");
		 							CellValue2(Row,Col) 	  = "";
		 							CellValue2(Row,"lstm_cd") = "";
		 							return false;
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								CellValue2(Row,Col) 	  = "";
 								CellValue2(Row,"lstm_cd") = "";
 								SelectCell(Row,Col);
 								return false;
 							}
 						}
					} else {
						CellValue2(Row,"lstm_cd") = "";
					}
					break;
				case "lstm_cd":
					if(CellValue(Row,Col) != "") {
						if(/OW|LP|OL/.test(Value) == false) {
							ComShowCodeMessage("LSE01068");
							CellValue2(Row,"agmt_seq") = "";
 							CellValue2(Row,Col) = "";
 							return false;
						} else {
			 				var param = "f_cmd="  + SEARCH01
			 						 + "&pln_yrmon="+ CellValue(Row,"pln_yrmon")
	 								 + "&agmt_seq="+ CellValue(Row,"agmt_seq");
	 						WaitImageVisible = false;
				        	var sXml = sheetObj.GetSearchXml("EES_LSE_0034GS.do", param);
				        	var sCheckResult = ComGetEtcData(sXml,"checkDupYrmon");
				        	WaitImageVisible = true;

				        	if(sCheckResult != "") {
				        		ComShowCodeMessage("LSE01071", sCheckResult);
				        		CellValue2(Row,"agmt_seq") = "";
 								CellValue2(Row,Col) = "";
 								return false;
				        	}
						}
					}
					break;
				case "mft_vndr_seq":// Grid Manufacturer Code Check
					if(CellValue(Row,Col) != "") {
						//콤보코드와 텍스트를 가져온다.
						var isExist = false;
						var arrCode = GetComboInfo(0,"mft_vndr_seq", "Code").split("|");

						for(var i = 0; i < arrCode.length; i++) {
							if(arrCode[i] == Value) {
								isExist = true;
								break;
							} else if(i +1 == arrCode.length) {
								ComShowCodeMessage("LSE01048");
								CellValue2(Row,Col) = arrCode[0];
								SelectCell(Row,Col);
								return false;
							}
						}
					}
					break;
				case "del_cd":		// Grid Location Code Check
					if(CellValue(Row,Col) != "") {
						var param = "f_cmd="  + SEARCH05
 								 + "&loc_cd=" + CellValue(Row,Col)
 								 + "&loc_tp=SCC";
						WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
 						WaitImageVisible = true;

 						if (sXml != "") {
		 					if (ComGetEtcData(sXml, "scc_cd") != undefined) {
				 				if (ComGetEtcData(sXml, "scc_cd") != "") {
				 					CellValue2(Row,Col) = ComGetEtcData(sXml, "scc_cd");
		 						} else {
		 							ComShowCodeMessage("LSE01037");
		 							CellValue2(Row,Col) = "";
		 							return false;
		 						}
 							} else {
 								var errMsg = LseComGetErrMsg(sXml);
 								if ( errMsg != "" ) {
 									ComShowMessage(errMsg);
 								}
 								CellValue2(Row,Col) = "";
 								SelectCell(Row,Col);
 								return false;
 							}
 						}
					}
					break;
				case "new_van_yrmon":// Grid dfDateYm format Check
					if(CellValue(Row,Col) != "") {
						if(ComIsDate(Value, "ym") == false) {
							ComShowMessage(MessageText("UserMsg01"));
							CellValue2(Row,Col) = "";
 							SelectCell(Row,Col);
							return false;
						}
					}
					break;
			}
 		}

 		return true;
 	}

 	/**
 	 * Sheet의 OnPopupClick Event 처리부분.<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
    function sheet1_OnPopupClick(sheetObj,Row,Col) {
 		with(sheetObj) {
			var sName = ColSaveName(Col);

			switch(sName) {
				case "agmt_seq":	//Agreement No Pop-up
					openPopup("1", Row, Col);
					break;
				case "del_cd":	// Delivery Location Pop-up
					openPopup("3", Row, Col);
					break;
			}
 		}
    }

    /**
     * 저장처리 전에 유효성 검사를 할수 있도록 발생하는 Event
     * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
     */
    function sheet1_OnValidation(sheetObj, Row, Col, Value) {
    	with(sheetObj) {
	    	//특정 컬럼 내에 중복된 값이 존재하는지 여부를 확인
			var dupRow = ColValueDup("pln_yrmon|agmt_cty_cd|agmt_seq|lstm_cd|mft_vndr_seq|del_cd|cntr_tpsz_cd|new_van_yrmon", false);

			//중복행이 발견되면 하일라이트 처리하고 메세지 알린후 해당 행을 삭제처리
			if(dupRow != -1) {
				ComShowCodeMessage("LSE01069");
				ValidateFail = true;
			}
    	}
    }

	/**
	 * 저장처리 전에 입력항목에 대한 유효성을 검사한다.
	 */
    function checkSaveValidation(sheetObj) {
		with(sheetObj) {
			for(var i = HeaderRows; i <= LastRow; i++) {
				for(var j = 0; j <= LastCol; j++) {
					if(RowStatus(i) == "I" && CellValue(i, "last_chk") != "OK") {
						var saveName = ColSaveName(j);
						if(/agmt_seq|lstm_cd|mft_vndr_seq|del_cd|new_van_yrmon/.test(saveName)) {
							var index = FindText(j, CellText(i, j));
							if(index == -1 || index == i) {
								if(!sheet1_OnChange(sheetObj, i, j, CellValue(i, j))) {
									CellValue2(i, "last_chk") = "Fail";
									return false;
								} else if(saveName == "new_van_yrmon") {
									CellValue2(i, "last_chk") = "OK";
								} else {
									CellValue2(i, "last_chk") = "Hold";
								}
							} else {
								if(saveName == "new_van_yrmon") {
									CellValue2(i, "last_chk") = "OK";
								} else {
									CellValue2(i, "last_chk") = "Hold";
								}
							}
						}
					}
				}
			}
		}

		return true;
    }

    /**
     * 저장 함수를 이용하여 저장이 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if(!/Error/.test(ErrMsg)) {
    		ComShowCodeMessage("LSE10001");
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }

    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	// 조회 후 데이터 가공을 위한 버튼 콘트롤
    	LseComBtnControl(true, "btn_RowAdd|btn_Delete");
    }

    /**
	 * 엑셀에서 데이터를 모두 읽어들였을때 발생하는 Event
	 * @param sheetObj
	 */
	function sheet1_OnLoadExcel(sheetObj) {
		var vPlnYrmon = document.form.pln_yrmon.value;

    	with(sheetObj) {
    		for(var i = HeaderRows; i <= RowCount; i++) {
    			if(RowStatus(i) == "I") {
	    			CellValue2(i,"pln_yr")  = vPlnYrmon.split("-")[0];
					CellValue2(i,"pln_mon") = vPlnYrmon.split("-")[1];
					CellValue2(i,"pln_yrmon") = vPlnYrmon.replaceStr("-");
					CellValue2(i,"agmt_cty_cd") = "HHO";
    			}
    		}
    	}
	}

  	/**
 	 * Sheet의 duplicate Data check 부분.<br>
 	 * @param sheetObj
 	 * @deprecated 2009.06.22 현재 사용되지 않는다.
 	 */
    function checkDupData(sheetObj) {
    	with(sheetObj) {
    		var resultRow = ColValueDupRows("pln_yrmon|agmt_cty_cd|agmt_seq|lstm_cd|mft_vndr_seq|del_cd|cntr_tpsz_cd|new_van_yrmon",false,true); //중복결과

			//중복결과가 있을 경우
			if ( resultRow != "" ) {
				var arrResultRow  = resultRow.split("|");       //중복결과 array
				var arrBaseRow    = arrResultRow[0].split(","); //중복 기준열 index array
				var arrDupRow     = arrResultRow[1].split(","); //중복열 index array
				var realDupRowIdx = "";                         //공백제거 후 중복열 결과 Row index

				//공백인 Row Filtering
				for ( var baseIdx = 0 ; baseIdx < arrBaseRow.length ; baseIdx++ ) {
					if ( CellValue(arrBaseRow[baseIdx],"pln_yrmon")     != ""
					  && CellValue(arrBaseRow[baseIdx],"agmt_cty_cd")  	!= ""
					  && CellValue(arrBaseRow[baseIdx],"agmt_seq")     	!= ""
					  && CellValue(arrBaseRow[baseIdx],"lstm_cd")       != ""
					  && CellValue(arrBaseRow[baseIdx],"mft_vndr_seq")  != ""
					  && CellValue(arrBaseRow[baseIdx],"del_cd")       	!= ""
					  && CellValue(arrBaseRow[baseIdx],"cntr_tpsz_cd")  != ""
					  && CellValue(arrBaseRow[baseIdx],"new_van_yrmon") != "" ) {
						//중복 기준열 = 중복 열 인 경우 Filtering
						for ( var dupIdx = 0 ; dupIdx < arrDupRow.length ; dupIdx++ ) {
							if ( CellValue(arrDupRow[dupIdx],"pln_yrmon")      == CellValue(arrBaseRow[baseIdx],"pln_yr")
							  && CellValue(arrDupRow[dupIdx],"agmt_cty_cd")    == CellValue(arrBaseRow[baseIdx],"agmt_cty_cd")
							  && CellValue(arrDupRow[dupIdx],"agmt_seq")       == CellValue(arrBaseRow[baseIdx],"agmt_seq")
							  && CellValue(arrDupRow[dupIdx],"lstm_cd")        == CellValue(arrBaseRow[baseIdx],"lstm_cd")
							  && CellValue(arrDupRow[dupIdx],"mft_vndr_seq")   == CellValue(arrBaseRow[baseIdx],"mft_vndr_seq")
							  && CellValue(arrDupRow[dupIdx],"del_cd")         == CellValue(arrBaseRow[baseIdx],"del_cd")
							  && CellValue(arrDupRow[dupIdx],"cntr_tpsz_cd")   == CellValue(arrBaseRow[baseIdx],"cntr_tpsz_cd")
							  && CellValue(arrDupRow[dupIdx],"new_van_yrmon")  == CellValue(arrBaseRow[baseIdx],"new_van_yrmon") ) {
								if ( realDupRowIdx == "" ) {
									realDupRowIdx = arrDupRow[baseIdx];
								} else {
									realDupRowIdx =  realDupRowIdx + "," + arrDupRow[baseIdx];
								}
							}
						}
					} else if ( RowStatus(arrBaseRow[baseIdx]) == "I" ) {
						RowDelete(arrBaseRow[baseIdx]);
					}
				}

				//공백인 Row Filtering 후 실데이터가 있는 Row가 있다면 메세지 후 삭제
				if ( realDupRowIdx != "" ) {
					ComShowCodeMessage("LSE01031");
					ColumnSort("pln_yrmon|agmt_cty_cd|agmt_seq|lstm_cd|del_cd|mft_vndr_seq|cntr_tpsz_cd|new_van_yrmon|de_qty","ASC|ASC|ASC|ASC|ASC|ASC|ASC|ASC");
					return false;
				}
			}
    	}

    	return true;
    }

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 3:Location Popup for GRID
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement',  '1,0', false, false, Row, Col, 0);
    	} else if ( type == "3" ) {
    		ComOpenPopup('/hanjin/COM_ENS_051.do', 800, 430, 'setPopData_DeliveryLoc', '1,0,1,1,0,0,0,0', false, false, Row, Col, 0);
    	}

    	return;
    }

  	/**
     * Agreement Pop-up Return Value 처리 부분<br>
     * @param {arry} returnedValues Pop-up 화면의 Return value array
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     * @param 대상IBSheet의 Sheet Array index
     */
    function setPopData_Agreement(aryPopupData, Row, Col, sheetIdx) {
    	if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var vLeaseTerm = aryPopupData[0][6];
				if(vLeaseTerm == "OW"||vLeaseTerm == "LP"||vLeaseTerm == "OL") {
					CellValue2(Row, "agmt_seq") = aryPopupData[0][4];
					CellValue(Row, "ref_no")   = aryPopupData[0][5];
					CellValue2(Row,"lstm_cd")   = "";
					CellValue(Row, "lstm_cd")   = aryPopupData[0][6];
				} else {
					ComShowCodeMessage("LSE01068");
					CellValue2(Row, "agmt_seq") = "";
					CellValue2(Row, "lstm_cd")  = "";
				}
			}
		}
    }

  	/**
	 * Location Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_DeliveryLoc(aryPopupData, Row, Col, sheetIdx) {
		if(aryPopupData.length > 0) {
			with(sheetObjects[sheetIdx]) {
				var sName = ColSaveName(Col);

				switch(sName) {
					case "del_cd":
						CellValue2(Row, sName) = aryPopupData[0][10]; //SCC
						break;
					default :	//do nothing
				}
			}
		}
	}

    /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function validateForm(sheetObj, formObj, sAction) {
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
    			case IBINSERT:		//추가
    			case IBLOADEXCEL:	//업로드
					if(formObj.pln_yrmon.value == "") {
						ComShowCodeMessage("LSE01036");
						ComSetFocus(formObj.pln_yrmon);
						return false;
						break;
					}
    				return ComChkValid(formObj, false);
    				break;
				default :	//do nothing
    		}
    	}

	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//저장
	    			return checkSaveValidation(sheetObj);
	    			break;
	    		default : 	//do nothing
    		}
    	}

        return true;
	}

  	/**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 * @deprecated 2009.06.22 현재 사용되지 않는다.
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			default :	//do nothing
		}
	}
	/* 개발자 작업  끝 */