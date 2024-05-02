/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0093.js
*@FileTitle : Mis Use In & Out Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
* =======================================================
* 2010.12.22 남궁진호[CHM-201007442-01] Request OFC POPUP 세로SIZE 조정
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
     * @class EES_LSE_0093 : EES_LSE_0093 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0093() {
    	this.processButtonClick = processButtonClick;
		this.setSheetObject 	= setSheetObject;
		this.loadPage 			= loadPage;
		this.initControl 		= initControl;
		this.obj_blur 			= obj_blur;
		this.obj_focus 			= obj_focus;
		this.obj_change 		= obj_change;
		this.obj_keypress 		= obj_keypress;
		this.obj_keyup 			= obj_keyup;
		this.obj_keydown 		= obj_keydown;
		this.initSheet 			= initSheet;
		this.doActionIBSheet 	= doActionIBSheet;
		this.sheet1_OnScrollNext = sheet1_OnScrollNext;
		this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
		this.sheet1_OnMouseMove = sheet1_OnMouseMove;
		this.sheet1_OnClick 	= sheet1_OnClick;
		this.openPopup 			= openPopup;
		this.validateForm 		= validateForm;
		this.checkDurationDate 	= checkDurationDate;
    }

   	/* 개발자 작업	*/

	// 공통전역변수

	var sheetObjects = new Array();
	var sheetCnt = 0;

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
					doActionIBSheet(sheetObject1,formObj,IBSEARCH);
					break;

				case "btn_New":
					ComResetAll();
		    		ComSetFocus(formObj.rqst_ofc_cd);
					break;

				case "btn_downExcel":
					sheetObject1.SpeedDown2Excel(-1);
					break;

				case "btns_search":		//Office Code
 					openPopup("1");
 					break;

 				case "btns_calendar":		// Request Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.str_rqst_dt, formObj.end_rqst_dt, 'yyyy-MM-dd');
					}
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		var formObj = document.form;

        for(i=0;i<sheetObjects.length;i++){

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }

        /* Axon Control Setting*/
    	initControl();

		/* 초기 Focus Setting */
		ComSetFocus(formObj.rqst_ofc_cd);
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
		axon_event.addListenerFormat('change',  	'obj_change',  	formObj); //- 변경될때.
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
			//preEventType = null;
			//return;
		}

	    switch(obj.name) {
	    	default:
	            /* Validation 전체 체크(길이,format,최대,최소 등등) */
	            ComChkObjValid(obj);
	        	break;
	    }

	    preEventType = event.type;
	}

	/**
	 * HTML Control의 포커스 들어가는 이벤트에서 마스크 구분자를 제거한다.
	 */
	function obj_focus() {
		var obj = event.srcElement;

	    if(obj.readOnly) {
	    	ComSetNextFocus(obj);
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
		var formObj = document.form;

  		switch(obj.name) {
  			case "rqst_ofc_cd":			//Office Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;

  			case "str_rqst_dt":
    		case "end_rqst_dt":
    			checkDurationDate(obj);
	    		break;

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
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
			default :
			  	ComKeyEnter('LengthNextFocus');
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
  	//2. 이벤트처리함수 -- End

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
                    style.height = 368;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "Seq.|Case|Status|Request No.|Approval No.|CNTR No.|TP/SZ|Lease\nTerm|APP AGMT No.|MU Date|MU By / From|MU Place|Return SCC|Return SCC|Return SCC|Return SCC|Per Diem|Lift On\nCharge|Liable Party|Request Reason|Request File Attachment||APP/REJ Reason|APP/REJ File Attachment||Cancel Reason|Cancel File Attachment|";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		   			InitDataProperty(0, cnt++ , dtDataSeq,	40,		daCenter,	true,	"seq_no");
		   			InitDataProperty(0, cnt++ , dtCombo,	50,		daCenter,	true,	"mss_rqst_io_mod_cd", 	false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"mss_usd_apro_mod_cd", 	false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	true,	"rqst_no",      		false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		130,	daCenter,	true,	"apro_no",      		false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"cntr_no",      		false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"cntr_tpsz_cd",      	false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"lstm_cd",      		false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,	"apro_agmt_no",      	false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,	"mss_usd_dt",      		false,	"",	dfDateYmd,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		240,	daLeft,		true,	"mss_usd_fm_nm",      	false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		70,		daCenter,	true,	"mss_use_plc_nm",      	false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"n1st_ref_ofc_cd",      false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"n2nd_ref_ofc_cd",      false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"n3rd_ref_ofc_cd",      false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"n4th_ref_ofc_cd",      false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		70,		daRight,	true,	"pd_chg_rt_amt",      	false,	"",	dfFloat,	2,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		70,		daRight,	true,	"lft_chg_rt_amt",      	false,	"",	dfFloat,	2,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		240,	daLeft,		true,	"libor_pty_nm",      	false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		false,	"rqst_rsn_desc",		false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,		270,	daLeft,		false,	"rqst_file_sav_nm",		false,	"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	200,	daLeft,		false,	"rqst_file_sav_id",		false,	"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		false,	"apro_rsn_desc",		false,	"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		270,	daLeft,		false,	"apro_file_sav_nm",		false,	"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	200,	daLeft,		false,	"apro_file_sav_id",		false,	"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,		300,	daLeft,		false,	"cxl_rsn_desc",			false,	"",	dfNone,		0,		false,		false);
                    InitDataProperty(0, cnt++ , dtPopup,	200,	daLeft,		false,	"cxl_file_sav_nm",		false,	"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,	200,	daLeft,		false,	"cxl_file_sav_id",		false,	"",	dfNone,		0,		false,		false);

					InitDataCombo(0, "mss_rqst_io_mod_cd", "MUI|MUO", "I|O");

                    SelectBackColor = LSE_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";

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

			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.DoSearch4Post("EES_LSE_0093GS.do",FormQueryString(formObj));
						ComOpenWait(false);
					}
				}
				break;

			case IBSEARCH_ASYNC01:	// Office Code 에 대한 Validation 체크
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param = "f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.rqst_ofc_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.rqst_ofc_cd.value = ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.rqst_ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.rqst_ofc_cd.value = "";
								ComSetFocus(formObj.rqst_ofc_cd);
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.rqst_ofc_cd.value = "";
							ComSetFocus(formObj.rqst_ofc_cd);
						}
					}
				}

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
		//doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
	}

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		ColFontColor("rqst_file_sav_nm") = RgbColor(0, 0, 255);
    		ColFontColor("apro_file_sav_nm") = RgbColor(0, 0, 255);
    		ColFontColor("cxl_file_sav_nm") = RgbColor(0, 0, 255);
    	}
    }

    /**
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			var linkFlag = CellValue(MouseRow, MouseCol) != "";
			DataLinkMouse("rqst_file_sav_nm") = linkFlag;
			DataLinkMouse("apro_file_sav_nm") = linkFlag;
			DataLinkMouse("cxl_file_sav_nm")  = linkFlag;
		}
	}

	/**
	 * sheet1_OnClick
	 */
	function sheet1_OnClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);

		if(sheetObj.MousePointer != "Hand") return;

		with(sheetObj) {
			switch(sName) {
				case "rqst_file_sav_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, "rqst_file_sav_id");
					break;
				case "apro_file_sav_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, "apro_file_sav_id");
					break;
				case "cxl_file_sav_nm":
					location.href = "/hanjin/FileDownload?key="+CellText(Row, "cxl_file_sav_id");
					break;
			}
		}
	}

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 2:Office Code Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
			ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 755, 435, "ofc_cd:rqst_ofc_cd", "1,0,1,1,1,1,1,1", true);
    	}

    	return;
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
    				if (!checkDurationDate()) {
    					return false;
    				}

    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}

        return true;
    }

	/**
	 * Duration Date Validation 처리 부분<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj = document.form;
    	var vEffDt = ComReplaceStr(ComGetObjValue(formObj.str_rqst_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.end_rqst_dt),"-","");

    	//Duration이 필수입력이 아닌경우
    	if( vEffDt == "" && vExpDt == "" ) {
    		return true;
    	}

		/* Duration Date Validation(str_rqst_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_rqst_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "str_rqst_dt") {
			ComShowCodeMessage("LSE01078");
			ComSetFocus(formObj.str_rqst_dt);
			return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.str_rqst_dt) ) {
			ComShowCodeMessage("LSE01080");
			ComSetObjValue(formObj.str_rqst_dt,"");
			ComSetFocus(formObj.str_rqst_dt);
			return false;
		}

		/* Duration Date Validation(end_rqst_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_rqst_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "end_rqst_dt") {
			ComShowCodeMessage("LSE01079");
			ComSetFocus(formObj.end_rqst_dt);
			return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.end_rqst_dt) ) {
			ComShowCodeMessage("LSE01081");
			ComSetObjValue(formObj.end_rqst_dt,"");
			ComSetFocus(formObj.end_rqst_dt);
			return false;
		}

		/* Duration Date Validation(str_rqst_dt < end_rqst_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("LSE01082");

				if(eventObj == null) {
					ComSetObjValue(formObj.end_rqst_dt,"");
					ComSetFocus(formObj.end_rqst_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
		}

		return true;
    }

	/* 개발자 작업  끝 */