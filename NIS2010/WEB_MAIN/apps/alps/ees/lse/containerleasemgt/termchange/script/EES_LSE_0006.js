/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0006.js
*@FileTitle : Term Change Inquiry
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
     * @class EES_LSE_0006 : EES_LSE_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_LSE_0006() {
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
		this.sheet1_OnSearchEnd  = sheet1_OnSearchEnd;
		this.openPopup 			= openPopup;
		this.setPopData_Agreement = setPopData_Agreement;
		this.setPopData_Lessor 	= setPopData_Lessor;
		this.validateForm 		= validateForm;
		this.clearForm 			= clearForm;
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
		 var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						if(ComChkValid(formObj) == true) {
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}
						break;

					case "btn_new":
						ComResetAll();
						if(formObj.dcond_tp.value == "01") {
							div_dcond1.style.display = "inline";
							div_dcond2.style.display = "none";
				    		ComSetFocus(formObj.agmt_seq1);
				    	} else {
				    		div_dcond1.style.display = "none";
							div_dcond2.style.display = "inline";
				    		ComSetFocus(formObj.vndr_seq2);
				    	}
						break;

					case "btn_downexcel":
						ComOpenWait(true);
						sheetObjects[1].LoadSearchXml(vXmlBuff);
						sheetObjects[1].SpeedDown2Excel(-1);
						ComOpenWait(false);
						break;

					case "btns_search":		//AGMT No.
	 					openPopup("1");
	 					break;

	 				case "btns_search2":	//Lessor
	 					openPopup("2");
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
    	if(formObj.dcond_tp.value == "01") {
    		ComSetFocus(formObj.agmt_seq1);
    	} else {
    		ComSetFocus(formObj.vndr_seq2);
    	}
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
	    	case "agmt_seq1" :
	    	case "vndr_seq2" :
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
  			case "dcond_tp":
  				if(obj.value == "01") {
  					div_dcond1.style.display = "inline";
  					div_dcond2.style.display = "none";
  					clearForm("vndr_seq2");
  				} else {
  					div_dcond1.style.display = "none";
  					div_dcond2.style.display = "inline";
  					clearForm("agmt_seq1");
  				}
  				ComSetNextFocus(obj);
  				break;
  			case "agmt_seq1":	//Agreement No.
  				if ( ComTrim(obj.value) != "" ) {
					doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
				}
				break;
			case "vndr_seq2":	//Lessor Code
  				if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC02);
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
  			case "agmt_seq1":
  			case "vndr_seq2":
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
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 3, 1000);

                 	//전체 데이터는 XML로 저장하고, 페이지 개수 만큼만 표시하고, 나머지는 자동 스크롤 방식
                 	ScrollTrack = false;
                 	MassOfSearch = 1;

					var HeadTitle1 = "Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Before|Before|Before|Before|Before|Before|After|After|After|After|After|After";
					var HeadTitle2 = "Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|Contract Period|Contract Period|Agreement|Term|Contract No.|Lessor|ERP FA I/F|ERP FA I/F";
					var HeadTitle3 = "Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|EFF. Date|EXP. Date|Agreement|Term|Contract No.|Lessor|Date|Y";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDataSeq,	40,		daCenter,	true,	"seq_no");
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cntr_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,	"cntr_tpsz_cd",     false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"cre_dt",    		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"cnmv_sts_cd",      false,	"",		dfNone);

                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"bef_agmt_no",  	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"bef_lstm_cd",      false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		110,	daLeft,		true,	"bef_ref_no",     	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,	"bef_vndr_abbr_nm", false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"bef_lst_bef_dt", 	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"bef_lst_exp_dt", 	false,	"",		dfNone);

                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"aft_agmt_no",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"aft_lstm_cd",     	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		110,	daLeft,		true,	"aft_ref_no",    	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,	"aft_vndr_abbr_nm", false,	"",		dfNone);

                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"aft_fa_if_dt",     false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	true,	"aft_fa_if_sts_cd", false,	"",		dfNone);

                	SelectBackColor = LSE_SELECT_BACK_COLOR;

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";

               }
                break;

			case "sheet2":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 420;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(3, 1, 3, 100);

					var HeadTitle1 = "Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Before|Before|Before|Before|Before|Before|After|After|After|After|After|After";
					var HeadTitle2 = "Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|Contract Period|Contract Period|Agreement|Term|Contract No.|Lessor|ERP FA I/F|ERP FA I/F";
					var HeadTitle3 = "Seq.|CNTR No.|TP/SZ|T/C Date|MVMT|Agreement|Term|Contract No.|Lessor|EFF. Date|EXP. Date|Agreement|Term|Contract No.|Lessor|Date|Y";

					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    InitHeadRow(2, HeadTitle3, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, DATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDataSeq,	40,		daCenter,	true,	"seq_no");
                    InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,	"cntr_no",			false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,	"cntr_tpsz_cd",     false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"cre_dt",    		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"cnmv_sts_cd",      false,	"",		dfNone);

                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"bef_agmt_no",  	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"bef_lstm_cd",      false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		110,	daLeft,		true,	"bef_ref_no",     	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,	"bef_vndr_abbr_nm", false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"bef_lst_bef_dt", 	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"bef_lst_exp_dt", 	false,	"",		dfNone);

                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"aft_agmt_no",		false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,	"aft_lstm_cd",     	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		110,	daLeft,		true,	"aft_ref_no",    	false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		55,		daCenter,	true,	"aft_vndr_abbr_nm", false,	"",		dfNone);

                    InitDataProperty(0, cnt++ , dtData,		85,		daCenter,	true,	"aft_fa_if_dt",     false,	"",		dfNone);
                    InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	true,	"aft_fa_if_sts_cd", false,	"",		dfNone);

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
						//------------------------------------ Client의 처리속도를 위하여 부분범위 처리한다.
						//sheetObj.DoSearch4Post("EES_LSE_0006GS.do",FormQueryString(formObj));
						vXmlBuff = sheetObj.GetSearchXml("EES_LSE_0006GS.do",FormQueryString(formObj));
						sheetObj.LoadSearchXml(vXmlBuff);
						ComOpenWait(false);
					}
				}
				break;

			case IBSEARCHAPPEND:	//조회(페이징처리)
				if(sheetObj.id == "sheet1") {
					formObj.f_cmd.value = SEARCH;
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					sheetObj.DoSearch4Post("EES_LSE_0006GS.do", CondParam, "iPage="+ PageNo, true);
					ComOpenWait(false);
				}
				break;

			case IBSEARCH_ASYNC01:	//조회(Form Agreement No. 입력시)
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						ComSetObjValue(formObj.f_cmd, SEARCH03);
 						var param = "f_cmd="+SEARCH03+"&agmt_cty_cd="+ComGetObjValue(formObj.agmt_cty_cd)
 								  + "&agmt_seq="+ComGetObjValue(formObj.agmt_seq1);
 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do",param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "lstm_cd") != undefined ) {
								ComSetObjValue(formObj.vndr_seq1, ComGetEtcData(sXml, "vndr_seq"));
								ComSetObjValue(formObj.vndr_nm1,  ComGetEtcData(sXml, "vndr_nm"));
								ComSetObjValue(formObj.lstm_cd1,  ComGetEtcData(sXml, "lstm_cd"));
								ComSetFocus(formObj.vndr_nm1);
							} else {
								var errMsg = LseComGetErrMsg(sXml);
								if ( errMsg != "" ) {
									ComShowMessage(errMsg);
								}
								clearForm("agmt_seq1");
							}
						}
 					}
				}
				break;

			case IBSEARCH_ASYNC02:	//조회(Form Lessor No. 입력시)
				if ( validateForm(sheetObj, formObj, sAction) ) {
					var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq2);
					sheetObj.WaitImageVisible = false;
					var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
					sheetObj.WaitImageVisible = true;

					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
							ComSetObjValue(formObj.vndr_nm2, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
							ComSetFocus(formObj.vndr_nm2);
 						} else {
 							ComShowCodeMessage("LSE01019");
 							clearForm("vndr_seq2");
 							ComSetFocus(formObj.vndr_seq2);
 						}
					} else {
						ComShowCodeMessage("LSE01019");
						clearForm("vndr_seq2");
						ComSetFocus(formObj.vndr_seq2);
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
    	//do nothing
    }

    /**
     * Pop-up Open 부분<br>
     * @param type 1:Agreement No. Popup for FORM, 2:Office Code Popup for FORM
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	if ( type == "1" ) {
    		ComOpenPopup('/hanjin/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);
    	} else if ( type == "2" ) {
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
    function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
    	var sheetObj = sheetObjects[SheetIdx];
    	var formObj  = document.form;

    	if ( aryPopupData.length > 0 ) {
    		ComSetObjValue(formObj.agmt_seq1, aryPopupData[0][4]);
    		ComSetObjValue(formObj.vndr_seq1, aryPopupData[0][7]);
    		ComSetObjValue(formObj.vndr_nm1,  aryPopupData[0][8]);
    		ComSetObjValue(formObj.lstm_cd1,  aryPopupData[0][6]);
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
			ComSetObjValue(formObj.vndr_seq2, ComLtrim(aryPopupData[0][2],"0"));
			ComSetObjValue(formObj.vndr_nm2,  aryPopupData[0][4]);
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:      //조회
    				if(formObj.dcond_tp.value == "01" && formObj.agmt_seq1.value == "") {
    					ComShowCodeMessage("LSE01006");
			    		ComSetFocus(formObj.agmt_seq1);
			    		return false;
    				} else if(formObj.dcond_tp.value == "01" && formObj.vndr_seq1.value == "") {
    					return false;
			    	} else if(formObj.dcond_tp.value == "02" && formObj.vndr_seq2.value == "") {
			    		ComShowCodeMessage("LSE01044");
			    		ComSetFocus(formObj.vndr_seq2);
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
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 * @deprecated 2009.06.22 현재 사용되지 않는다.
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			case "agmt_seq1":
				ComSetObjValue(formObj.agmt_seq1,    "");
				ComSetObjValue(formObj.vndr_seq1, 	"");
				ComSetObjValue(formObj.vndr_nm1,  	"");
				ComSetObjValue(formObj.lstm_cd1,     "");
				ComSetFocus(formObj.agmt_seq1);
				break;
			case "vndr_seq2":
				ComSetObjValue(formObj.vndr_seq2, 	"");
				ComSetObjValue(formObj.vndr_nm2,  	"");
				ComSetFocus(formObj.vndr_seq2);
				break;
		}
	}

	/* 개발자 작업  끝 */