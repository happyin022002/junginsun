/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0026.js
*@FileTitle : Immediate Exit Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.10 장준우
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
     * @class EES_LSE_0026 : EES_LSE_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0026() {
    	this.processButtonClick 	= processButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initControl 			= initControl;
		this.obj_blur 				= obj_blur;
		this.obj_focus 				= obj_focus;
		this.obj_change 			= obj_change;
		this.obj_keypress 			= obj_keypress;
		this.obj_keyup 				= obj_keyup;
		this.obj_keydown 			= obj_keydown;
		this.initSheet 				= initSheet;
		this.doActionIBSheet 		= doActionIBSheet;
		this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
		this.openPopup 				= openPopup;
		this.setPopData_Agreement 	= setPopData_Agreement;
		this.setPopData_DeliveryLoc = setPopData_DeliveryLoc;
		this.validateForm 			= validateForm;
		this.clearForm 				= clearForm;
    }

   	/* 개발자 작업	*/


	// 공통전역변수
	var vXmlBuff;
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

				case "btn_retrive":
					if(ComChkValid(formObj) == true) {
						doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					}
					break;

				case "btn_new":
					ComResetAll();
					formObj.loc_cd.readOnly = true;
					formObj.loc_cd.className = "input2";
					formObj.cntr_no.className = "input2";
					formObj.agmt_seq.className = "input1";
					formObj.cntr_no.readOnly = true;
					ComEnableObject(formObj.btns_search2, false);
					ComSetFocus(formObj.agmt_seq);
					break;

				case "btn_downExcel":
					ComOpenWait(true);
					sheetObjects[1].LoadSearchXml(vXmlBuff);
					sheetObjects[1].SpeedDown2Excel(-1);
					ComOpenWait(false);
					break;

				case "btns_search":		//AGMT No. 조회 팝업
 					openPopup("1");
 					break;

 				case "btns_search2":	//Location. 조회 팝업
 					openPopup("2");
 					break;
 				case "chk_cntr":
					if ( srcObj.checked ) {
						clearForm("agmt_seq");
						formObj.cntr_no.className = "input1";
						formObj.agmt_seq.className = "input";
						formObj.cntr_no.readOnly = false;
						ComSetFocus(formObj.cntr_no);
					} else {
						formObj.cntr_no.value = "";
						formObj.cntr_no.className = "input2";
						formObj.agmt_seq.className = "input1";
						formObj.cntr_no.readOnly = true;
						ComSetFocus(formObj.agmt_seq);
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

		    //khlee-시작 환경 설정 함수 이름 변경
		    ComConfigSheet (sheetObjects[i] );

		    initSheet(sheetObjects[i],i+1);
		    //khlee-마지막 환경 설정 함수 추가
		    ComEndConfigSheet(sheetObjects[i]);
        }

		/* Axon Control Setting*/
    	initControl();

    	/* 초기 Focus Setting */
    	ComEnableObject(formObj.btns_search2, false);
    	ComSetFocus(formObj.agmt_seq);
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
		axon_event.addListenerForm('change',   		'obj_change',  	formObj); //- 변경될때.
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
	    	case "agmt_seq" :
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
  			case "agmt_seq":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
				}
				break;
			case "loc_tp":		//Location Type
				formObj.loc_cd.value = "";
				if(obj.value == "") {
					formObj.loc_cd.readOnly = true;
					formObj.loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search2, false);
				} else {
					formObj.loc_cd.readOnly = false;
					formObj.loc_cd.className = "input";
					ComEnableObject(formObj.btns_search2, true);
					formObj.loc_cd.maxLength = obj.value == "5" ? 7 : 5;
					ComSetNextFocus(obj);
				}
				break;
			case "loc_cd":		//Location Code
  				if ( ComTrim(obj.value) != "" ) {
  					if(obj.maxLength == 5) {
	        			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
  					} else {
  						doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC03);
  					}
  				}
  				break;
  			case "cntr_no":
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC04);
				}
				break;
		}
	}

	/**
	 * Key-Press Event 처리
	 */
  	function obj_keypress() {
  		var obj = event.srcElement;
  		var formObj = document.form;

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
	        	} else if(obj.name == "cntr_no") {
		        	if(formObj.cntr_no.value.length < 4) ComKeyOnlyAlphabet('upper');
		        	else ComKeyOnlyNumber(obj);
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
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "agmt_seq":
  				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
			default :
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

   		if(vKeyCode == 13 && ComChkValid(formObj)) {
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
        var formObj = document.form;

        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 379;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   	InitRowInfo( 2, 1, 3,1000);

                 	//전체 데이터는 XML로 저장하고, 페이지 개수 만큼만 표시하고, 나머지는 자동 스크롤 방식
                 	ScrollTrack = false;
                 	MassOfSearch = 1;

					var HeadTitle = "|Seq.|Imme Exit|CNTR No.|TP/SZ|On-hire|On-hire|Current Yard|MVMT|ACT Date|F/M||";
                    var HeadTitle1 = "|Seq.|Imme Exit|CNTR No.|TP/SZ|Date|Yard|Current Yard|MVMT|ACT Date|F/M||";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, Editable, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no");
                    InitDataProperty(0, cnt++ , dtCheckBox,    	60,   	daCenter,  	true,   "imdt_ext_flg",	false,  "",	dfNone,     0,		true,		false);
                    InitDataProperty(0, cnt++ , dtData,     	110,   	daCenter,  	true,   "cntr_no",     	false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,     	50,   	daCenter,  	true,   "cntr_tpsz_cd", false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "onh_dt", 		false,  "",	dfDateYmd,  0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "onh_yd_cd",  	false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "crnt_yd_cd",   false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	60,   	daCenter,  	true,   "cnmv_sts_cd",  false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "cnmv_dt",  	false,  "",	dfDateYmd,  0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,   "full_flg",     false,  "",	dfNone,     0,		false,		false);

                    InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"agmt_cty_cd",	false,	"",	dfNone,     0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"agmt_seq",		false,	"",	dfNone,     0,		false,		false);

					ShowButtonImage = 1;
					CheckAllImageVisible = true;
					SelectBackColor = LSE_SELECT_BACK_COLOR;
					FitColWidth();

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
               }
                break;
           	case 2:      //t1sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 379;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                   	InitRowInfo( 2, 1, 3,100);

					var HeadTitle = "|Seq.|Imme Exit|CNTR No.|TP/SZ|On-hire|On-hire|Current Yard|MVMT|ACT Date|F/M||";
                    var HeadTitle1 = "|Seq.|Imme Exit|CNTR No.|TP/SZ|Date|Yard|Current Yard|MVMT|ACT Date|F/M||";
                    var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, Editable, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no");
                    InitDataProperty(0, cnt++ , dtCheckBox,    	60,   	daCenter,  	true,   "imdt_ext_flg",	false,  "",	dfNone,     0,		true,		false);
                    InitDataProperty(0, cnt++ , dtData,     	110,   	daCenter,  	true,   "cntr_no",     	false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,     	50,   	daCenter,  	true,   "cntr_tpsz_cd", false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "onh_dt", 		false,  "",	dfDateYmd,  0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "onh_yd_cd",  	false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "crnt_yd_cd",   false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	60,   	daCenter,  	true,   "cnmv_sts_cd",  false,  "",	dfNone,     0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	90,   	daCenter,  	true,   "cnmv_dt",  	false,  "",	dfDateYmd,  0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,      	50,    	daCenter,  	true,   "full_flg",     false,  "",	dfNone,     0,		false,		false);

                    InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"agmt_cty_cd",	false,	"",	dfNone,     0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"agmt_seq",		false,	"",	dfNone,     0,		false,		false);

					ShowButtonImage = 1;
					CheckAllImageVisible = true;
					WaitImageVisible = false;
					SelectBackColor = LSE_SELECT_BACK_COLOR;
					FitColWidth();

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
						//------------------------------------ Client의 처리속도를 위하여 부분범위 처리한다.
						//sheetObj.DoSearch4Post("EES_LSE_0025GS.do",FormQueryString(formObj));
						vXmlBuff = sheetObj.GetSearchXml("EES_LSE_0025GS.do",FormQueryString(formObj));
						sheetObj.LoadSearchXml(vXmlBuff);
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
 							var vLstmCd = ComGetEtcData(sXml, "lstm_cd");
	 						if ( vLstmCd != undefined ) {
								ComSetObjValue(formObj.vndr_seq, ComGetEtcData(sXml, "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm,  ComGetEtcData(sXml, "vndr_nm"));
								ComSetObjValue(formObj.lstm_cd,  ComGetEtcData(sXml, "lstm_cd"));
								ComSetObjValue(formObj.ref_no,   ComGetEtcData(sXml, "ref_no"));
								ComSetObjValue(formObj.ctrt_no,   ComGetEtcData(sXml, "lse_ctrt_no"));
								ComSetObjValue(formObj.free_dys, ComGetEtcData(sXml, "lse_free_dys"));
								ComSetObjValue(formObj.ofc_cd,   ComGetEtcData(sXml, "ofc_cd"));
								ComSetObjValue(formObj.eff_dt,   ComGetEtcData(sXml, "eff_dt"));
								ComSetObjValue(formObj.exp_dt,   ComGetEtcData(sXml, "exp_dt"));
								ComSetNextFocus(formObj.agmt_seq);
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

			case IBSEARCH_ASYNC02:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vLocTp = formObj.loc_tp[formObj.loc_tp.selectedIndex].text;
 						var param = "f_cmd="+SEARCH05+"&loc_tp="+ vLocTp
 								  +"&loc_cd="+ComGetObjValue(formObj.loc_cd);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "rcc_cd") != undefined ) {
								if ( ComGetEtcData(sXml, "rcc_cd") != "" ) {
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
 			case IBSEARCH_ASYNC03:	// Yard 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH+"&node_cd="+ComGetObjValue(formObj.loc_cd)
 								  + "&mode=yard";
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_061GS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) == 1 ) {
							ComSetFocus(formObj.loc_cd);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.loc_cd.value = "";
							ComSetFocus(formObj.loc_cd);
						}
					}
				}

 				break;
 			case IBSEARCH_ASYNC04:	// Container 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var param = "f_cmd="+SEARCH17+"&cntr_no="+ComGetObjValue(formObj.cntr_no);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							ComSetFocus(formObj.cntr_no);
						} else {
							ComShowCodeMessage("LSE01048");
							formObj.cntr_no.value = "";
							ComSetFocus(formObj.cntr_no);
						}
					}
				}

 				break;

        }
    }

    /**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	sheetObj.FitColWidth();
    }

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 2:Location Code Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "2" ) {
			switch(formObj.loc_tp.value) {
    			case "1" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"rcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "2" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"lcc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "4" :	//SCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 800, 430,"scc_cd:loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "5" :	//Yard
					ComOpenPopup("/hanjin/COM_ENS_061.do",755, 610, "setPopData_DeliveryLoc", "1,0,1,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
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
     function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj = sheetObjects[SheetIdx];
     	var formObj  = document.form;

     	if ( aryPopupData.length > 0 ) {
			ComSetObjValue(formObj.agmt_seq, aryPopupData[0][4]);
    		ComSetObjValue(formObj.ref_no,   aryPopupData[0][5]);
    		ComSetObjValue(formObj.ctrt_no,  aryPopupData[0][14]);
    		ComSetObjValue(formObj.vndr_seq, aryPopupData[0][7]);
    		ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][8]);
    		ComSetObjValue(formObj.lstm_cd,  aryPopupData[0][6]);
    		ComSetObjValue(formObj.eff_dt,   aryPopupData[0][9]);
			ComSetObjValue(formObj.exp_dt,   aryPopupData[0][10]);
			ComSetObjValue(formObj.free_dys, ComAddComma(aryPopupData[0][11]));
			ComSetObjValue(formObj.ofc_cd,   aryPopupData[0][12]);
			ComSetNextFocus(formObj.agmt_seq);
     	}
     }

	/**
      * DeliveryLoc(Yard) Pop-up Return Value 처리 부분<br>
      * @param {arry} returnedValues Pop-up 화면의 Return value array
      * @param Row 대상Object가 IBSheet일 경우 해당 Row index
      * @param Col 대상Object가 IBSheet일 경우 해당 Col index
      * @param 대상IBSheet의 Sheet Array index
      */
     function setPopData_DeliveryLoc(aryPopupData, Row, Col, SheetIdx) {
     	var sheetObj = sheetObjects[SheetIdx];
     	var formObj  = document.form;

     	if ( aryPopupData.length > 0 ) {
     		if ( formObj.loc_tp.value == "5" ) {
				ComSetObjValue(formObj.loc_cd, aryPopupData[0][3]);
			}
     	}
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH:      //조회
					if(formObj.agmt_seq.className == "input1" && formObj.agmt_seq.value == "") {
						if ( formObj.lstm_cd.value == "" ) {
							ComShowCodeMessage("LSE01006");
							ComSetFocus(formObj.agmt_seq);
							return false;
							break;
						}
					} else if(formObj.cntr_no.className == "input1" && formObj.cntr_no.value == "") {
						ComShowCodeMessage("LSE01064");
						ComSetFocus(formObj.cntr_no);
						return false;
						break;
					}

    				return ComChkValid(formObj, false);
    				break;
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
			case "agmt_seq":
				ComSetObjValue(formObj.agmt_seq,    "");
				ComSetObjValue(formObj.ref_no,      "");
				ComSetObjValue(formObj.ctrt_no,     "");
				ComSetObjValue(formObj.vndr_seq, 	"");
				ComSetObjValue(formObj.vndr_nm,  	"");
				ComSetObjValue(formObj.lstm_cd,     "");
				ComSetObjValue(formObj.eff_dt,  	"");
				ComSetObjValue(formObj.exp_dt,      "");
				ComSetObjValue(formObj.free_dys,  	"");
				ComSetObjValue(formObj.ofc_cd,      "");
				formObj.loc_tp.value     = "";
				formObj.loc_cd.readOnly  = true;
				formObj.loc_cd.className = "input2";
				ComSetFocus(formObj.agmt_seq);
				break;
		}
	}


	/* 개발자 작업  끝 */