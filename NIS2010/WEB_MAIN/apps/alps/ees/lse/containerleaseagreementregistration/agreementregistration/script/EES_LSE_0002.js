/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0002.js
*@FileTitle : Lease Agreement Version – Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.02 노정용
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
	 * @class ees_lse_0002 : ees_lse_0002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_lse_0002() {
		this.processButtonClick		= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;
		this.loadPage 				= loadPage;
		this.initControl            = initControl;
		this.obj_keypress           = obj_keypress;
		this.obj_blur               = obj_blur;
		this.obj_focus              = obj_focus;
		this.obj_keydown            = obj_keydown;
		this.obj_change             = obj_change;
		this.initCombo 				= initCombo;
		this.initSheet 				= initSheet;
		this.doActionIBSheet 		= doActionIBSheet;
		this.sheet1_OnLoadFinish    = sheet1_OnLoadFinish;
		this.sheet1_OnScrollNext    = sheet1_OnScrollNext;
		this.combo1_OnChange        = combo1_OnChange;
		this.openPopupPage          = openPopupPage;
		this.setPopData_Agreement   = setPopData_Agreement;
		this.setPopData_Lessor      = setPopData_Lessor;
		this.validateForm 			= validateForm;
		this.clearForm              = clearForm;
	}

	/* 개발자 작업 시작 */
	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		/*******************************************************/
		var formObj = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject, formObj, IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
        			comboObjects[0].Text = "ALL";  // Initial Setting
					break;

				case "btn_Ok":
					comPopupOK();
					break;

				case "btn_Close":
					window.close();
					break;

 				case "btns_search1":
 					openPopupPage("1");
 					break;

 				case "btns_search2":
 					openPopupPage("2");
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

		/* Axon Control Setting*/
		initControl();

		ComSetFocus(document.form.agmt_seq);
	}

	//Axon 이벤트 처리1. 이벤트catch
	function initControl() {
		var formObj = document.form;
		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',		'obj_focus',	formObj); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키보드 입력할때
		axon_event.addListenerFormat('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('change',		'obj_change',	formObj); //- 변경될때.
	}

	//Axon 이벤트 처리2. 이벤트처리함수 --- start
	/**
	 * 키보드가 눌릴 때
	 **/
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
	        	if ( obj.name == "ref_no" ) {
	        		ComKeyOnlyAlphabet('num');
	        	} else {
	        		ComKeyOnlyAlphabet();
	        	}
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
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur(){
	    switch(event.srcElement.name){
	        case "agmt_seq":
	        case "vndr_seq":
	            //숫자이면서 천단위 구분을 하지 않는다.
	            ComChkObjValid(event.srcElement, true, false, false);
	            break;

	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(event.srcElement);
	    }
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 **/
	function obj_focus(){
	    //마스크구분자 없애기
	    ComClearSeparator(event.srcElement);
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

	/**
     * OnChange Event 처리
     */
 	function obj_change(){
		var obj      = event.srcElement;
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {
	    		case "agmt_seq":
	    			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
					break;

	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
				   	break;
			}
	    }
	}
   	//Axon 이벤트 처리2. 이벤트처리함수 --- End

	/**
	 * 콤보 초기설정값, 헤더 정의
	 * param : comboObj ==> 콤보오브젝트, sheetNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.id) {
	        case "combo1":
	        	with(comboObj) {
	            	//BackColor = "cyan";
	            	DropHeight = 250;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            }

	        	break;
	    }
	}

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
					style.height = 250;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "|Sel.|AGMT No.|||Term|Contract No.|Ref. No.|VER|Lessor ABBR|Lessor Name|Office|Period|Period|Created by|Date|Updated by|Date";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtRadioCheck,	30,		daCenter,	true,	"radio",		false,	"",	dfNone,	0,	true,	true);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	false,	"agmt_no",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		50, 	daCenter,	false,	"agmt_cty_cd",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtHidden,		50, 	daCenter,	false,	"agmt_seq",		false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	false,	"lstm_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80, 	daLeft,		false,	"lse_ctrt_no",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			80, 	daLeft,		false,	"ref_no",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	false,	"agmt_ver_seq",	false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			100, 	daCenter,	false,	"vndr_abbr_nm",	false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		false,	"vndr_nm",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"ofc_cd",		false,	"",	dfNone,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"eff_dt",		false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	false,	"exp_dt",		false,	"",	dfDateYmd,	0,	false,	false);
					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"cre_usr_id",	false,	"",	dfNone,	0,	false,	false);

					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"cre_dt",		false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"upd_usr_id",	false,	"",	dfNone,	0,	false,	false);
 					InitDataProperty(0, cnt++ , dtData,		    80,		daCenter,	true,	"upd_dt",		false,	"",	dfNone,	0,	false,	false);
				}
				break;
		}
	}

	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
	        case IBCREATE:		//Lease Term Form Combo Item Setting
	     		sheetObj.WaitImageVisible = false;

	        	formObj.f_cmd.value = SEARCH01;
		     	var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

		        if ( sXml != "" ) {
		        	// "ALL" Item Insert
		            comboObjects[0].InsertItem(0,"ALL"," ");
		            LseComXml2ComboItem(sXml, comboObjects[0], "lease_term_nm", "lease_term_cd", "|");
		            comboObjects[0].Text = "ALL";  // Initial Setting
		        }

		        sheetObj.WaitImageVisible = true;
		        break;

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						//formObj.lstm_cd.value = ComGetObjValue(formObj.combo1);
						sheetObj.WaitImageVisible = false;
	         			ComOpenWait(true);
	         			sheetObj.DoSearch4Post("EES_LSE_0002GS.do",FormQueryString(formObj));
	         			ComOpenWait(false);
					}
				}
				break;

			case IBSEARCHAPPEND:
         		if ( sheetObj.id == "sheet1") {
	            	formObj.f_cmd.value = SEARCH;
	                sheetObj.DoSearch4Post("EES_LSE_0002GS.do", CondParam, "iPage=" + PageNo, true);
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
	 							formObj.vndr_seq.value = ComGetEtcData(sXml, "vndr_seq");
	 							formObj.vndr_nm.value  = ComGetEtcData(sXml, "vndr_nm");
	 							//formObj.lstm_cd.value      = ComGetEtcData(sXml, "lstm_cd");
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

			case IBSEARCH_ASYNC02:	//조회(Form Lessor No. 입력시)
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetNextFocus(formObj.vndr_seq);
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.vndr_seq, "");
	 							ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.vndr_seq, "");
							ComSetFocus(formObj.vndr_seq);
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
	 * sheet1_OnScrollNext
	 */
	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}

	/**
	 * combo1_OnChange
	 */
	function combo1_OnChange(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.lstm_cd.value = comboObj.Code;
	}

	/**
	 * Pop-up Open 부분<br>
	 * @param type 1:Location for FORM, 2:Agreement No. Selection for FORM, 3:Lessor for FORM
	 * @param object 대상 Object
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 */
   function openPopupPage(type, Row, Col) {
   	if ( type == "1" ) {
   		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
   	} else if ( type == "2" ) {
   		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
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
    		formObj.agmt_seq.value = aryPopupData[0][4];
    		formObj.vndr_seq.value = aryPopupData[0][7];
    		formObj.vndr_nm.value  = aryPopupData[0][8];
			//formObj.lstm_cd.value  = aryPopupData[0][6];
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
			formObj.vndr_seq.value = ComLtrim(aryPopupData[0][2],"0");
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
		}

	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if ( ComTrim(ComGetObjValue(formObj.agmt_seq)) == ""
				  && ComTrim(ComGetObjValue(formObj.combo1))   == ""
				  && ComTrim(ComGetObjValue(formObj.vndr_seq)) == "" ) {
					ComShowCodeMessage("LSE01025");
					ComSetFocus(formObj.agmt_seq);
					return false;
				}
				break;
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
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value  = "";
				//formObj.lstm_cd.value      = "";
				break;

			case "vndr_seq":
				formObj.agmt_seq.value     = "";
				formObj.vndr_seq.value = "";
				formObj.vndr_nm.value  = "";
				//formObj.lstm_cd.value      = "";
				break;
		}
	}
	/* 개발자 작업 끝 */