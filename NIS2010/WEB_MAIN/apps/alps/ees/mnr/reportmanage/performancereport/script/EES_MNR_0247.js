/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0247.jsp
*@FileTitle : Disposal Equipment Detail list
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.23 장준우
* 1.0 Creation
*=======================================================
* 2010.12.06 남궁진호 [CHM-201007441-01]Disposal Result Equipment list 팝업 신규개발 
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
     * @class EES_MNR_0247 : EES_MNR_0247 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0247() {
    	this.processButtonClick      = processButtonClick;
		this.setSheetObject          = setSheetObject;
		this.loadPage                = loadPage;
		this.sheet1_OnLoadFinish     = sheet1_OnLoadFinish;
		this.initControl             = initControl;
		this.obj_blur                = obj_blur;
		this.obj_focus               = obj_focus;
		this.obj_change              = obj_change;
		this.obj_keypress            = obj_keypress;
		this.obj_keyup               = obj_keyup;
		this.obj_keydown             = obj_keydown;
		this.initSheet               = initSheet;
		this.doActionIBSheet         = doActionIBSheet;
		this.sheet1_OnSearchEnd      = sheet1_OnSearchEnd;
		this.validateForm            = validateForm;
    }

   	/* 개발자 작업	*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObj = document.form;

     	try {
     		var srcObj  = window.event.srcElement;
 			var srcName = window.event.srcElement.getAttribute("name");

 			switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 					break;

 				case "btn_New":
					sheetObject.ColHidden("part_amt") = false;
					sheetObject.ColHidden("cal_part_amt") = true;
 					break;

             	case "btn_DownExcel":
             		sheetObject.Down2Excel(-1);
					break;

				case "btn_Close":
					window.close();
                    break;

				case "p_chk_usd":
					/* 매각금액의 통화코드 변환처리 */
					var viewFlag = srcObj.checked;
					sheetObject.ColHidden("part_amt") = viewFlag;
					sheetObject.ColHidden("cal_part_amt") = !viewFlag;
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

    	/* Axon Control Setting*/
    	initControl();

    	doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
	        default: //do nothing
	        	ComChkObjValid(obj);
	        	break;
	    }
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
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];

		switch(obj.name) {
			default :
				//do nothing
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
    function initSheet(sheetObj, sheetNo) {
    	var formObj = document.form;
		var sheetid = sheetObj.id;
		var cnt = 0;

		switch(sheetid) {
			case "sheet1":
				with(sheetObj) {
					// 높이 설정
					style.height = 310;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);

					var HeadTitle = "Seq.|RHQ|Rquest\nOffice|Approval\nOffice|EQ Type|EQ No.|TP/SZ|MNFR Date|Sale Type|Disposal No.|Disposal No.|Sold Date|Buyer|Buyer"
								  + "|RCC|LCC|SCC|LOC|Yard|Disposal Kind|RPR Cost(USD)|Currency|Disposal\nAmount|Disposal\nAmount(USD)||Tariff Price||Verify Result";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 9, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDataSeq,		40,		daCenter,	true,	"seq_no",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"rhq_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"rqst_ofc_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"apro_ofc_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtHidden,		70,		daCenter,	true,	"eq_knd_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			90,		daCenter,	true,	"eq_no",			false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"eq_tpsz_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"manu_dt",			false,	"",	dfDateYmd);
					InitDataProperty(0, cnt++ , dtCombo,		70,		daCenter,	true,	"disp_tp_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	"disp_no",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,	true,	"disp_dtl_seq",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	"disp_sold_dt",		false,	"",	dfUserFormat);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"cust_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			190,	daLeft,		true,	"cust_nm",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"rcc_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"lcc_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"scc_cd",			false,	"",	dfNone);

					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"loc_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,	"disp_yd_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			150,	daLeft,		true,	"disp_rsn_cd",		false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,	"rpr_cost_amt",		false,	"",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"curr_cd",			false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,	"part_amt",			false,	"",	dfFloat, 2);
					InitDataProperty(0, cnt++ , dtHidden,		90,		daRight,	true,	"cal_part_amt",		false,	"",	dfFloat, 2);
					InitDataProperty(0, cnt++ , dtHidden,		90,		daRight,	true,	"disp_ut_prc",		false,	"",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtData,			90,		daRight,	true,	"disp_trf_ut_prc",	false,	"",	dfNullFloat, 2);
					InitDataProperty(0, cnt++ , dtHidden,		30,		daCenter,	true,	"disp_vrfy_tp_cd",	false,	"",	dfNone);
					InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,	"disp_vrfy_tp_nm",	false,	"",	dfNone);

 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					CountPosition = 2;

					InitUserFormat(0, "disp_sold_dt", "####-##-##", "-");
					InitDataCombo(0, "disp_tp_cd", "Contract|Bidding", "C|B");
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
						var sXml = sheetObj.GetSearchXml("EES_MNR_0247GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchXml(sXml);
						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
				break;
			default :
				//do nothing
		}
    }

	/**
     * 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	with(sheetObj) {
    		var formObj = document.form;
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
    				return ComChkValid(formObj, true);
    				break;
				default :	//do nothing
    		}
    	}

        return true;
	}
	/* 개발자 작업  끝 */