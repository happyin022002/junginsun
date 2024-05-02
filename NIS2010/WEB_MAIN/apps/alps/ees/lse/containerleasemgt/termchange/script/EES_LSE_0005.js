/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0005.js
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.03 장준우
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
     * @author 한진해운
     */

    /**
     * @extends
     * @class EES_LSE_0005 : EES_LSE_0005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0005() {
    	this.processButtonClick		 = processButtonClick;
		this.setSheetObject 		 = setSheetObject;
		this.loadPage 				 = loadPage;
		this.initControl 			 = initControl;
		this.obj_blur 				 = obj_blur;
		this.obj_focus 				 = obj_focus;
		this.obj_change 			 = obj_change;
		this.obj_keypress 			 = obj_keypress;
		this.obj_keyup 				 = obj_keyup;
		this.obj_keydown 			 = obj_keydown;
		this.initSheet 				 = initSheet;
		this.doActionIBSheet 		 = doActionIBSheet;
		this.sheet1_OnSaveEnd 		 = sheet1_OnSaveEnd;
		this.sheet1_OnSearchEnd 	 = sheet1_OnSearchEnd;
		this.openPopup 				 = openPopup;
		this.setPopData_CurAgreement = setPopData_CurAgreement;
		this.setPopData_AftAgreement = setPopData_AftAgreement;
		this.validateForm 			 = validateForm;
		this.clearForm 				 = clearForm;
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
         var sheetObject = sheetObjects[0];

         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcObj  = window.event.srcElement;
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
					case "di_flag":
	  					div_dcond1.style.display = srcObj.checked ? "inline" : "none";
						div_dcond2.style.display = srcObj.checked ? "inline" : "none";
						clearForm("di_vndr_seq");
		  				break;
					case "btn_Retrieve":
						if(ComChkValid(formObj) == true) {
							doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
						}
	 					break;

					case "btn_New":
						ComResetAll();
						div_diFlag.style.display = "none";
						div_dcond1.style.display = "none";
						div_dcond2.style.display = "none";
						ComSetFocus(formObj.cur_agmt_seq);
						break;

					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObj, IBSAVE);
						break;

					case "btns_calendar":		// Activity Date
						if ( srcObj.style.filter == "" ) {
							var cal = new ComCalendar();
			                cal.select(formObj.act_dt, "yyyy-MM-dd");
						}
						break;

					case "btns_search2":	//Current AGMT No.
	 					openPopup("1");
	 					break;

	 				case "btns_search3":	//After AGMT No.
	 					openPopup("2");
	 					break;

					case "btns_search":		//Office Code
	 					openPopup("3");
	 					break;

	 				case "btns_search1":	//Lessor Search
	 					openPopup("4");
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

	        //khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

	        initSheet(sheetObjects[i],i+1);
	        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

		/* Axon Control Setting*/
    	initControl();

    	/* 초기 Focus Setting */
    	ComSetFocus(formObj.cur_agmt_seq);

    }

	// Axon 이벤트 처리
  	// 1. 이벤트catch
  	function initControl() {
  		var formObj = document.form;
  		axon_event.addListenerFormat('blur',		'obj_blur',		formObj); //- 포커스 나갈때
		axon_event.addListenerForm('focus',			'obj_focus',	formObj); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('keyup',		'obj_keyup',	formObj); //- 키 올라올때
		axon_event.addListenerForm('keydown',		'obj_keydown',	formObj); //- 키 눌렸을때
		axon_event.addListenerFormat('change',   	'obj_change',  	formObj); //- 변경될때.
  	}

	//이벤트 중복방지 변수
	var preEventType = null;
  	// 2. 이벤트처리함수 -- Start
  	/**
	 * HTML Control의 포커스 나가는 이벤트에서 Validation을 체크한다.
	 **/
	function obj_blur() {
		var obj = event.srcElement;
		var formObj = document.form;

		if(preEventType == event.type) {
			//preEventType = null;
			//return;
		}

	    switch(obj.name) {
	    	case "cur_agmt_seq" :
	    	case "aft_agmt_seq" :
	    		/* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	    		break;
	    	case "act_dt":
	    		ComChkObjValid(obj);
	    		break;
	    	case "di_vndr_seq" :
	    		/* 숫자이면서 천단위 구분을 하지 않는다. */
	            ComChkObjValid(obj, true, false, false);
	            break;
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
  			case "cur_agmt_seq":	//Current Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC02);
				}
				break;
			case "aft_agmt_seq":	//After Agreement No.
				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC03);
				}
				break;
			case "act_dt":			//Activity Date
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC04);
  				}
				break;
			case "ofc_cd":			//Office Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
				break;
			case "di_vndr_seq":		//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
  				}
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
  			case "cur_agmt_seq":
  			case "aft_agmt_seq":
  			case "di_vndr_seq":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
			case "act_dt":
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

   		if(vKeyCode == 13 && ComChkValid(formObj, false)) {
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
		var sheetid = sheetObj.id;
        switch(sheetid) {
            case "sheet1":      // sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 310;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					var HeadTitle = "||Seq.|CNTR No.|TP/SZ|Yard|Status|MVMT|MVMT Date||Pick Up Charge|Pick Up Credit|Min O/H Days|Free Days|DII/DIO Fee||||||||||||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk");
					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no");

					InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,	"cntr_no",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"cntr_tpsz_cd",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"lst_sts_yd_cd",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"cntr_sts_cd",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"cnmv_sts_cd",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	"cnmv_dt",				false,	"",	dfDateYmd,     0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		100,	daRight,	true,	"cntr_pkup_chg_amt",	false,	"",	dfFloat,       2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"cntr_pkup_psv_amt",	false,	"",	dfFloat,       2,		true,		true,	8);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"cntr_pkup_ngv_amt",	false,	"",	dfFloat,       2,		true,		true,	8);
					InitDataProperty(0, cnt++ , dtData,			100,	daRight,	true,	"cntr_min_onh_dys",		false,	"",	dfInteger,     0,		true,		true,	4);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	"rntl_chg_free_dys",	false,	"",	dfInteger,     0,		true,		true,	4);
					InitDataProperty(0, cnt++ , dtData,			80,		daRight,	true,	"dii_fee",				false,	"",	dfFloat,       2,		true,		true,	8);

					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"onh_dt",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"cur_agmt_cty_cd",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"cur_agmt_seq",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"aft_agmt_cty_cd",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"aft_agmt_seq",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"act_dt",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"di_flag",				false,	"",	dfNone,        0,		false,		false);

					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"row_seq",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"term_cng_seq",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"seq_set",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"aft_lstm_cd",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"aft_vndr_seq",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"cntr_full_flg",		false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"ofc_cd",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"dir_itchg_vndr_seq",	false,	"",	dfNone,        0,		false,		false);

					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"cntr_sts_seq",			false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"yd_cd",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"loc_cd",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"scc_cd",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"ecc_cd",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"lcc_cd",				false,	"",	dfNone,        0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"rcc_cd",				false,	"",	dfNone,        0,		false,		false);

					ShowButtonImage = 1;
					SelectBackColor = LSE_SELECT_BACK_COLOR;
					CheckAllImageVisible = true;

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
						//sheetObj.DoSearch4Post("EES_LSE_0005GS.do",FormQueryString(formObj));
						//------------------------------------ Client의 처리속도를 위하여 SpeedOption 처리한다.
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						sheetObj.SpeedOption = "NOFIT,NOSUM,NOCALC,NOROWHEIGHT, NOMERGEROW, NOTRIM, NOTDTAG, NOCOMBO, NOFORMAT";
          				sheetObj.DoSearch("EES_LSE_0005GS.do",FormQueryString(formObj));
          				ComOpenWait(false);
					}
				}
				break;

			case IBSAVE:			//저장
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						if(sheetObj.FindCheckedRow("del_chk") != "") {
							//----------------------------------------------------------------
							// 클라이언트 성능문제로 DoSave 에서 GetSaveXml 방식으로 변경한다.
							//----------------------------------------------------------------
							//formObj.f_cmd.value = MULTI;
							//sheetObj.DoAllSave("EES_LSE_0005GS.do", FormQueryString(formObj));
							sheetObj.WaitImageVisible = false;
							ComOpenWait(true);

							var sParam = "f_cmd=" + MULTI;
							sParam = sParam + "&" + LseGetAllSaveText(sheetObj, true, "ibflag", "");
							var sXml = sheetObj.GetSaveXml("EES_LSE_0005GS.do", sParam);
							sheetObj.LoadSaveXml(sXml);

							ComOpenWait(false);
							sheetObj.WaitImageVisible = true;
						} else {
							ComShowMessage(MessageText("UserMsg13"));
						}
					}
				}
				break;

			case IBSEARCH_ASYNC01:	// Office Code 에 대한 Validation 체크
				if(validateForm(sheetObj,formObj,sAction)) {
		        	var param = "f_cmd="+SEARCH16+"&ofc_cd="+ComGetObjValue(formObj.ofc_cd);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "ofc_cd") != undefined ) {
							if ( ComGetEtcData(sXml, "ofc_cd") != "" ) {
								formObj.ofc_cd.value = ComGetEtcData(sXml, "ofc_cd") ;
								ComSetNextFocus(formObj.ofc_cd);
							}else{
								ComShowCodeMessage("LSE01035");
								formObj.ofc_cd.value = "";
								ComSetFocus(formObj.ofc_cd);
							}
						} else {
							var errMsg = LseComGetErrMsg(sXml);
							if ( errMsg != "" ) {
								ComShowMessage(errMsg);
							}
							formObj.ofc_cd.value = "";
							ComSetFocus(formObj.ofc_cd);
						}
					}
				}

	        	break;

			case IBSEARCH_ASYNC02:	//조회(Form Current Agreement No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						//계약번호의 동일여부를 확인한다.
 						if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
							ComShowCodeMessage('LSE01072');
							clearForm("cur_agmt_seq");
							return;
			            }

 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param = "f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.cur_agmt_cty_cd)
 								  + "&agmt_seq="+ComGetObjValue(formObj.cur_agmt_seq);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								ComSetObjValue(formObj.cur_vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								ComSetObjValue(formObj.cur_vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
								ComSetObjValue(formObj.cur_lstm_cd,  ComGetEtcData(sXml, "lstm_cd"));
								ComSetObjValue(formObj.cur_ref_no,   ComGetEtcData(sXml, "ref_no"));
								ComSetObjValue(formObj.cur_ctrt_no,   ComGetEtcData(sXml, "lse_ctrt_no"));

								if(/MI|MO/.test(formObj.cur_lstm_cd.value)) {
									div_diFlag.style.display = "inline";
								} else {
									div_diFlag.style.display = "none";
								}
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								clearForm("cur_agmt_seq");
								ComSetFocus(formObj.cur_agmt_seq);
							}

							div_dcond1.style.display = "none";
							div_dcond2.style.display = "none";
							formObj.di_flag.checked = false;
							clearForm("di_vndr_seq");
						}
 					}
				}
				break;
			case IBSEARCH_ASYNC03:	//조회(Form After Agreement No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						//계약번호의 동일여부를 확인한다.
 						if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
							ComShowCodeMessage('LSE01072');
							clearForm("aft_agmt_seq");
							return;
			            }

 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param = "f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.aft_agmt_cty_cd)
 								  + "&agmt_seq="+ComGetObjValue(formObj.aft_agmt_seq);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								ComSetObjValue(formObj.aft_vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								ComSetObjValue(formObj.aft_vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
								ComSetObjValue(formObj.aft_lstm_cd,  ComGetEtcData(sXml, "lstm_cd"));
								ComSetObjValue(formObj.aft_ref_no,   ComGetEtcData(sXml, "ref_no"));
								ComSetObjValue(formObj.aft_ctrt_no,   ComGetEtcData(sXml, "lse_ctrt_no"));
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								clearForm("aft_agmt_seq");
								ComSetFocus(formObj.aft_agmt_seq);
							}
						}
 					}
				}
				break;
			case IBSEARCH_ASYNC04:	// Activity Date 에 대한 Validation 체크
				if(validateForm(sheetObj,formObj,sAction)) {
					//=======================================================================
					//[Deprecated - 2010.03.09] 사용자 요청에 의해 유효계약기간 검증로직은 삭제됨.
					//-----------------------------------------------------------------------
		        	//ComSetObjValue(formObj.f_cmd, SEARCH01);
	 				//sheetObj.WaitImageVisible = false;
		        	//var sXml = sheetObj.GetSearchXml("EES_LSE_0005GS.do", FormQueryString(formObj));
		        	//var sCheckResult = ComGetEtcData(sXml,"checkResult");
		        	//sheetObj.WaitImageVisible = true;

		        	//if(sCheckResult == "FALSE") {
		        	//	ComShowCodeMessage("LSE01066");
		        	//	formObj.act_dt.value = "";
		        	//	formObj.act_dt.focus();
		        	//}
				}

	        	break;
	        case IBSEARCH_ASYNC05:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.di_vndr_seq);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.di_vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetFocus(formObj.di_vndr_nm);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("di_vndr_seq");
 						}
					} else {
						var errMsg = LseComGetErrMsg(sXml);
						if ( errMsg != "" ) {
							ComShowMessage(errMsg);
						}
						clearForm("di_vndr_seq");
					}
				}
				break;
		}
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
    	//do nothing
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
				case "cntr_pkup_psv_amt":
					if(Value < 0) {
						CellValue2(Row,"cntr_pkup_psv_amt") = 0;
					} else {
						CellValue2(Row,"cntr_pkup_ngv_amt") = 0;
					}
					break;
				case "cntr_pkup_ngv_amt":
					if(Value < 0) {
						CellValue2(Row,"cntr_pkup_ngv_amt") = 0;
					} else {
						CellValue2(Row,"cntr_pkup_psv_amt") = 0;
					}
					break;
				case "cntr_min_onh_dys":
				case "rntl_chg_free_dys":
				case "dii_fee":
					if(Value < 0) {
						CellValue2(Row,Col) = 0;
					}
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
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_CurAgreement', '1,0', true);
    	} else if ( type == "2" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_AftAgreement', '1,0', true);
    	} else if ( type == "3" ) {
			ComOpenPopupWithTarget('/hanjin/COM_ENS_071.do', 755, 635, "ofc_cd:ofc_cd", "1,0,1,1,1,1,1,1", true);
    	} else if( type == "4") {
    		ComOpenPopup('/hanjin/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
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
    function setPopData_CurAgreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
    		ComSetObjValue(formObj.cur_agmt_seq, aryPopupData[0][4]);
    		ComSetObjValue(formObj.cur_ctrt_no,  aryPopupData[0][14]);
    		ComSetObjValue(formObj.cur_ref_no,   aryPopupData[0][5]);
    		ComSetObjValue(formObj.cur_vndr_seq, aryPopupData[0][7]);
    		ComSetObjValue(formObj.cur_vndr_nm,  aryPopupData[0][8]);
    		ComSetObjValue(formObj.cur_lstm_cd,  aryPopupData[0][6]);

    		if(/MI|MO/.test(formObj.cur_lstm_cd.value)) {
				div_diFlag.style.display = "inline";
			} else {
				div_diFlag.style.display = "none";
			}

			div_dcond1.style.display = "none";
			div_dcond2.style.display = "none";
			formObj.di_flag.checked = false;
			clearForm("di_vndr_seq");

			if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
				ComShowCodeMessage('LSE01072');
				clearForm("cur_agmt_seq");
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
    function setPopData_AftAgreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
    		ComSetObjValue(formObj.aft_agmt_seq, aryPopupData[0][4]);
    		ComSetObjValue(formObj.aft_ctrt_no,  aryPopupData[0][14]);
    		ComSetObjValue(formObj.aft_ref_no,   aryPopupData[0][5]);
    		ComSetObjValue(formObj.aft_vndr_seq, aryPopupData[0][7]);
    		ComSetObjValue(formObj.aft_vndr_nm,  aryPopupData[0][8]);
    		ComSetObjValue(formObj.aft_lstm_cd,  aryPopupData[0][6]);

    		if(formObj.cur_agmt_seq.value == formObj.aft_agmt_seq.value) {
				ComShowCodeMessage('LSE01072');
				clearForm("aft_agmt_seq");
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
			ComSetObjValue(formObj.di_vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.di_vndr_nm,  aryPopupData[0][4]);
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      	//조회
    				if(ComChkValid(formObj, true)) {
	    				var vAgmtSeq = ComGetObjValue(formObj.cur_agmt_seq);

	    				if(ComGetObjValue(formObj.cur_lstm_cd) == "") {
							ComShowCodeMessage('LSE01056');
							clearForm("cur_agmt_seq");
							return false;
	    				} else if(ComGetObjValue(formObj.aft_lstm_cd) == "") {
							ComShowCodeMessage('LSE01056');
							clearForm("aft_agmt_seq");
							return false;
						} else if(vAgmtSeq == formObj.aft_agmt_seq.value) {
							ComShowCodeMessage('LSE01072');
							clearForm("aft_agmt_seq");
							return false;
	    				}

	    				var vMiniDate = ComGetDateAdd(null, "M", -1, "").substring(0,6);
	    				if(ComIsDate(formObj.act_dt.value) &&
	    					!/OW|LP|OL/.test(formObj.cur_lstm_cd.value)) {
	    					if(ComReplaceStr(formObj.act_dt.value,"-") < vMiniDate) {
				        		ComShowCodeMessage('LSE01067');
				        		ComSetObjValue(formObj.act_dt, "");
				        		ComSetFocus(formObj.act_dt);
								return false;
	    					}
	    				}
    				}

					return true;
					break;
    			case IBSEARCH_ASYNC04:  //유효성검증
    				if(ComChkValid(formObj, true)) {
	    				var vMiniDate = ComGetDateAdd(null, "M", -1, "").substring(0,6);
	    				if(ComIsDate(formObj.act_dt.value) &&
	    					!/OW|LP|OL/.test(formObj.cur_lstm_cd.value)) {
	    					if(ComReplaceStr(formObj.act_dt.value,"-") < vMiniDate) {
				        		ComShowCodeMessage('LSE01067');
				        		ComSetObjValue(formObj.act_dt, "");
				        		ComSetFocus(formObj.act_dt);
								return false;
	    					}
	    				}
    				}

    				return true;
    				break;
				default :	//do nothing
    		}
    	}

	    with(sheetObj) {
    		switch(sAction) {
	    		case IBSAVE:		//저장
	    			var vDiVndrCd = formObj.di_vndr_seq.value;

	    			if(formObj.di_flag.checked && vDiVndrCd == "") {
	    				ComShowCodeMessage('LSE01044');
			        	ComSetFocus(formObj.di_vndr_seq);
	    				return false;
	    			} else if(vDiVndrCd != "") {
						for(var idx = HeaderRows; idx <= SearchRows; idx++) {
		    				if(CellValue(idx,"del_chk") == 1) {
								CellValue2(idx,"dir_itchg_vndr_seq") = vDiVndrCd;
		    				}
						}
	    			}

					//===========================================================
					// 클라이언트 성능문제로 DoSave 에서 GetSaveXml 방식으로 변경한다.
					//===========================================================
					//sheetObj.WaitImageVisible = false;
					//ComOpenWait(true, "mainTable");

					//선택된 대상에 대하여 ibflag 값을 설정한다.
	    			//for(var idx = HeaderRows; idx <= SearchRows; idx++) {
	    			//	if(CellValue(idx,"del_chk") == 1) {
					//		RowStatus(idx) = "U";
					//		CellValue(idx,"dir_itchg_vndr_seq") = vDiVndrCd;
	    			//	} else {
    				//		RowStatus(idx) = "R";
	    			//	}
    				//}
					//ComOpenWait(false, "mainTable");
					//sheetObj.WaitImageVisible = true;

	    			return true;
	    			break;

	    		default : 	//do nothing
    		}
    	}

        return true;
	}

  	/**
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			case "cur_agmt_seq":
				ComSetObjValue(formObj.cur_agmt_seq,    "");
				ComSetObjValue(formObj.cur_ctrt_no,     "");
				ComSetObjValue(formObj.cur_ref_no,      "");
				ComSetObjValue(formObj.cur_vndr_seq, 	"");
				ComSetObjValue(formObj.cur_vndr_nm,  	"");
				ComSetObjValue(formObj.cur_lstm_cd,     "");
				div_diFlag.style.display = "none";
				div_dcond1.style.display = "none";
				div_dcond2.style.display = "none";
				formObj.di_flag.checked = false;
				clearForm("di_vndr_seq");
				sheetObjects[0].RemoveAll();
				ComSetFocus(formObj.cur_agmt_seq);
				break;
			case "aft_agmt_seq":
				ComSetObjValue(formObj.aft_agmt_seq,    "");
				ComSetObjValue(formObj.aft_ctrt_no,     "");
				ComSetObjValue(formObj.aft_ref_no,      "");
				ComSetObjValue(formObj.aft_vndr_seq, 	"");
				ComSetObjValue(formObj.aft_vndr_nm,  	"");
				ComSetObjValue(formObj.aft_lstm_cd,     "");
				ComSetObjValue(formObj.act_dt,     	    "");
				sheetObjects[0].RemoveAll();
				ComSetFocus(formObj.aft_agmt_seq);
				break;
			case "di_vndr_seq":
				ComSetObjValue(formObj.di_vndr_seq, 	"");
				ComSetObjValue(formObj.di_vndr_nm,  	"");
				sheetObjects[0].RemoveAll();
				ComSetFocus(formObj.di_vndr_seq);
				break;
		}
	}


	/* 개발자 작업  끝 */