/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0244.jsp
*@FileTitle : Disposal Performance by RCC
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.06 장준우
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
     * @class EES_MNR_0244 : EES_MNR_0244 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0244() {
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
		this.openPopup               = openPopup;
		this.initDynamicEqTpszCd     = initDynamicEqTpszCd;
		this.setDynamicEqTpszHeader  = setDynamicEqTpszHeader;
		this.validateForm            = validateForm;
		this.clearForm               = clearForm;
    }

   	/* 개발자 작업	*/

   	/* Sheet Select Back Color */
	var MNR_SELECT_BACK_COLOR = 10092543;
	var MNR_TOTCOL_BACK_COLOR = 15723503;

	var cntrTpSz = new Array();
	var chssTpSz = new Array();
	var gsetTpSz = new Array();

	var vCntrTpszHdr = "| | | | | | | | | | | | | | | | | | | | | | | | | | | | | |";
	var vArrCntrTpsz = vCntrTpszHdr.split("|");
	var vCntrTpszCnt = vArrCntrTpsz.length;

	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;

	var sheetObjects = new Array();
	var sheetCnt = 0;

	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;

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
					ComResetAll();
					setDynamicEqTpszHeader(sheetObjects[0], "U");
					formObj.p_loc_cd.readOnly = true;
					formObj.p_loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search, false);
					ComSetFocus(formObj.p_str_evnt_dt);
					comboObjects[0].Index = 0;
 					break;

             	case "btns_search":	//Form Location. 조회 팝업
 					openPopup("1");
 					break;
 				case "btns_search2":	//Buyer 조회 팝업
 					openPopup("2");
 					break;

				case "btns_calendar":	// Event Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.p_str_evnt_dt, formObj.p_end_evnt_dt, 'yyyy-MM-dd');
					}
					break;

             	case "btn_DownExcel":
             		sheetObject.Down2Excel(-1);
					break;

				case "p_chk_expand":
					/* 트리 형태일 때 보여질 트리레벨 설정기능 */
					if ( srcObj.checked ) {
						sheetObject.ShowTreeLevel(-1);
					} else {
						sheetObject.ShowTreeLevel(0);
					}
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

		/* IBMultiCombo 초기화 */
		for ( var k = 0 ; k < comboObjects.length ; k++ ) {
	        initCombo(comboObjects[k], k+1);
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

    	/* 초기 Focus Setting */
    	ComSetFocus(formObj.p_str_evnt_dt);
    	ComEnableObject(formObj.btns_search, false);
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
		var tabObj = tabObjects[0];

		switch(obj.name) {
			case "p_str_evnt_dt":
    		case "p_end_evnt_dt":
    			checkDurationDate(obj);
	    		break;
			case "p_eq_knd_cd":			//Equipment Type
				sheetObjects[0].RemoveAll();
				setDynamicEqTpszHeader(sheetObjects[0], obj.value);
				break;
			case "p_loc_tp":		//Location Type
				formObj.p_loc_cd.value = "";
				if(obj.value == "") {
					formObj.p_loc_cd.readOnly = true;
					formObj.p_loc_cd.className = "input2";
					ComEnableObject(formObj.btns_search, false);
				} else {
					formObj.p_loc_cd.readOnly = false;
					formObj.p_loc_cd.className = "input";
					ComEnableObject(formObj.btns_search, true);
					ComSetNextFocus(obj);
				}
				break;
			case "p_loc_cd":	//Location Code
    			if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
  				}
    			break;
    		case "p_cust_cd":	//Buyer Code
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
	        	if(obj.name == "p_cust_cd") {
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
  		var obj     = event.srcElement;
  		var formObj = document.form;

  		switch(obj.name) {
  			case "p_loc_cd":
  				ComKeyEnter('LengthNextFocus');
  				break;
  			case "p_cust_cd":
				if ( ComTrim(obj.value) == "" ) {
  					clearForm(obj.name);
  				} else {
  					ComKeyEnter('LengthNextFocus');
  				}
  				break;
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
					//style.height = 410;
					//전체 너비 설정
					//SheetWidth = mainTable.clientWidth;
					SheetWidth = 984;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 4, 20, 100);

					var HeadTitle = "RCC||||||G.TTL|Ratio|TTL Amount(USD)"+ vCntrTpszHdr +"|";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 9, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					for(var i = 0; i < 4; i++) {
						cnt = 0;
						// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(i, cnt++ , dtData,			100,	daLeft,		true,	"loc_cd",			false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtHidden,		50,  	daCenter,	true,	"level_no",			false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtHidden,		70,		daCenter,	true,	"rcc_cd",			false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtHidden,		70,		daCenter,	true,	"lcc_cd",			false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtHidden,		70,		daCenter,	true,	"scc_cd",			false,	"",	dfNone);

						InitDataProperty(i, cnt++ , dtHidden,		70,		daCenter,	true,	"disp_qty_tot",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			70,		daRight,	true,	"disp_qty_cnt",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			70,		daRight,	true,	"disp_qty_rto",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			110,	daRight,	true,	"cal_part_amt_tot",	false,	"",	dfNone);

						for(var j = 1; j < vCntrTpszCnt; j++) {
							var tpsz_dp_no = "tpsz_dp"+ ComLpad(j, 2, "0");
							InitDataProperty(i, cnt++ , dtData,		80,  	daRight,	false,	tpsz_dp_no,			false,	"",	dfNone);

	                    	if(vArrCntrTpsz[j] != "") {
								eval('ColHidden("tpsz_dp'+ ComLpad(j, 2, "0") + '") = false;');
							} else {
								eval('ColHidden("tpsz_dp'+ ComLpad(j, 2, "0") + '") = true;');
							}
						}

						InitDataProperty(i, cnt++ , dtAutoSum,       50,    daRight,  	true,  	"auto_sum",        	false,  "",	dfNone);
					}
					ColHidden("auto_sum") = true;
					SelectBackColor = MNR_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					CountPosition = 0;

 					//초기 로드 시 트리에 대한 기본 정보를 설정한다.
					InitTreeInfo("loc_cd", "", RgbColor(0,0,255), false);
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
	        case "combo1":
	        	with(comboObj) {
	            	DropHeight = 250;
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
				//Equipment Type/Size Grid Header Item Setting
				initDynamicEqTpszCd(sheetObj);
				setDynamicEqTpszHeader(sheetObj, formObj.p_eq_knd_cd.value);

				//Disposal Kind Combo Item Setting
				//공통콤보 정보를 가져온다.
				var sCondition = new Array (
					new Array("MnrGenCd","CD00038", "COMMON")	//DISP_RSN_CD
				)

				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);
				//DISP_RSN_CD 세팅
				if(comboList[0] != null){
					for(var j = 0; j < comboList[0].length;j++){
						var tempText = comboList[0][j].split("|");
						comboObjects[0].InsertItem(j,tempText[1] ,tempText[0]);
					}
				}

				comboObjects[0].InsertItem(0 , 'ALL','');
				comboObjects[0].Index = 0;
				break;
			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("EES_MNR_0244GS.do", FormQueryString(formObj));

						if(ComGetTotalRows(sXml) > 4) {
							sheetObj.Redraw = false;
							sheetObj.LoadSearchXml(sXml);
							sheetObj.Redraw = true;
						} else {
							sheetObj.LoadSearchXml("<SHEET><DATA TOTAL='0'></DATA></SHEET>");
						}

						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
				break;
			case IBSEARCH_ASYNC01:	// Location 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
						var vLocType = formObj.p_loc_tp.value;
						var vLocCode = formObj.p_loc_cd.value;
 						var param = "f_cmd="+SEARCH+"&loc_nm=&un_loc_ind_cd=&cnt_cd=&loc_eq_ofc=&select=&loc_state=";

 						if(vLocType == "RCC") {
							param += "&loc_cd=&rcc_cd="+ vLocCode +"&lcc_cd=";
 						} else if(vLocType == "LCC") {
							param += "&loc_cd=&rcc_cd=&lcc_cd="+ vLocCode;
 						} else if(vLocType == "SCC") {//SCC는 LOC의 부분집합이다.
							param += "&loc_cd="+ vLocCode +"&rcc_cd=&lcc_cd=";
 						}

 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_051GS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) < 1 ) {
							ComShowCodeMessage("MNR00117");
 							formObj.p_loc_cd.value = "";
							ComSetFocus(formObj.p_loc_cd);
						} else if(vLocType == "SCC") {
							var aryData = MnrXmlToArray(sXml);
							if(vLocCode != aryData[0][14]) {
								ComShowCodeMessage("MNR00117");
	 							formObj.p_loc_cd.value = "";
								ComSetFocus(formObj.p_loc_cd);
							}
						}
					}
				}
 				break;
 			case IBSEARCH_ASYNC02:	// Buyer Code 조회
 				if(validateForm(sheetObj,formObj,sAction)) {
 					if ( sheetObj.id == "sheet1") {
 						var vCustCntCd = formObj.p_cust_cd.value;
 						var param = "f_cmd="+SEARCH+"&cust_cd="+ vCustCntCd.substr(0,2) +"&cust="+ vCustCntCd.substr(2);

 						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("COM_ENS_041GS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( ComGetTotalRows(sXml) != 1 ) {
							ComShowCodeMessage("MNR00025", "Buyer");
 							clearForm("p_cust_cd");
							ComSetFocus(formObj.p_cust_cd);
						} else {
							var aryData = MnrXmlToArray(sXml);
							ComSetObjValue(formObj.p_vndr_nm, aryData[0][11]);
							formObj.p_vndr_nm.focus();
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
    	with(sheetObj) {
    		var formObj = document.form;
			var viewCnt = 0;

			if(LastRow > 3) {
				ColBackColor("disp_qty_cnt") = MNR_TOTCOL_BACK_COLOR;
				ColBackColor("disp_qty_rto") = MNR_TOTCOL_BACK_COLOR;
				ColBackColor("cal_part_amt_tot") = MNR_TOTCOL_BACK_COLOR;

				//------------------------------------------------------------------------------------------------
				//[주의] 엑셀 다운로드시 Ratio행에 대한 Data 왜곡이 발생하여 SQL상의 TO_CHAR 함수로 기능을 대체한다.(by jwjang 2010.10.11)
				//------------------------------------------------------------------------------------------------
				/*
				for ( var i = sheetObj.HeaderRows ; i < sheetObj.LastRow ; i++ ) {
					if(i != LastRow -2) {
						var vCommaValue = Number(sheetObj.CellValue(i, "disp_qty_rto"));
						//비율계산에 대한 '%' 기호추가
						sheetObj.CellValue(i, "disp_qty_rto") = ComGetMaskedValue(vCommaValue.toFixed(2), "float");
						sheetObj.CellValue(i, "disp_qty_rto") += "%";
					} else {//Ratio행에 대한 보정계산
						for(var j = 0; j < sheetObj.LastCol; j++) {
							var vSaveName = sheetObj.ColSaveName(j);
							if(!/level_no|(loc|rcc|lcc|scc)_cd|disp_qty_(tot|rto)|cal_part_amt_tot|auto_sum/.test(vSaveName)) {
								sheetObj.InitCellProperty(i, j, dtNull, daRight, vSaveName, "", dfNone);

								//var vCommaValue = Number(sheetObj.CellValue(i, j));
								//비율계산에 대한 '%' 기호추가
								//sheetObj.CellValue(i, j) = ComGetMaskedValue(vCommaValue.toFixed(2), "float");
								//sheetObj.CellValue(i, j) += "%";

								//--------------------------------------------------------------------
								var vTotCnt = Number(CellValue(i -1, "disp_qty_tot"));
								var vQtyCnt = Number(CellValue(i -1, j));
								var vRatio  = (vQtyCnt / vTotCnt * 100).toFixed(2);
								CellValue(i, j) = ComGetMaskedValue(vRatio, "float") +"%";
								//--------------------------------------------------------------------
							}
						}
					}
				}
				*/

				for(var i = LastRow -4; i > LastRow -8; i--) {
					for(var j = 0; j < LastCol; j++) {
						CellText(i +4, j) = CellText(i, j);
						if(ColSaveName(j) == "loc_cd") {
							CellAlign(i +4, "loc_cd") = daCenter;
						}
					}
				}

				for ( var i = 1 ; i < vCntrTpszCnt ; i++ ) {
					var cellData = eval('CellValue(LastRow -7, "tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					if(cellData <= 0) {
						eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
					} else {
						eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
					}

					var viewFlag = eval('ColHidden("tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					if(viewFlag == false) {
						viewCnt++;
					}
				}

				if(360 + (viewCnt * 80) > 984) {
					SheetWidth = 984;
				} else {
					SheetWidth = 370 + (viewCnt * 80);
				}

				sheetObj.RowDelete(LastRow -7, false);
				sheetObj.RowDelete(LastRow -6, false);
				sheetObj.RowDelete(LastRow -5, false);
				sheetObj.RowDelete(LastRow -4, false);

				sheetObj.CellValue2(LastRow -3, "loc_cd") = "G.TTL";
				sheetObj.CellValue2(LastRow -2, "loc_cd") = "G.AMT";
				sheetObj.CellValue2(LastRow -1, "loc_cd") = "G.AVG";
				sheetObj.CellValue2(LastRow, "loc_cd") = "Ratio";

				//트리 형태일 때 보여질 트리 레벨을 설정한다.
				sheetObj.ShowTreeLevel(formObj.p_chk_expand.checked);
			}
    	}
    }

	/**
	 * combo1_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.p_disp_rsn_cd.value = ComGetObjValue(comboObj);

		if(ComGetObjValue(formObj.p_disp_rsn_cd) == "ALL") {
			ComSetObjValue(formObj.p_disp_rsn_cd, "");
		}
	}

	/**
	 * cobo1_OnKeyDown
	 */
	function combo1_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if(KeyCode == 13) {
				formObj.p_disp_rsn_cd.value = ComGetObjValue(comboObj);
				if(ComGetObjValue(formObj.p_disp_rsn_cd) == "ALL") {
					ComSetObjValue(formObj.p_disp_rsn_cd, "");
				}

				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
		}
	}

	/**
     * Pop-up Open 부분<br>
     * @param type 1:Location Code, 2:Currency Code
     * @param Row 대상Object가 IBSheet일 경우 해당 Row index
     * @param Col 대상Object가 IBSheet일 경우 해당 Col index
     */
    function openPopup(type, Row, Col) {
    	var formObj = document.form;

    	if ( type == "1" ) {
    		switch(formObj.p_loc_tp.value) {
    			case "RCC" :	//RCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"rcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "LCC" :	//LCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"lcc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			case "SCC" :	//SCC
    				ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 755, 610,"scc_cd:p_loc_cd", "1,0,1,1,1,1,1", true);
    				break;
    			default : 	//do nothing
    		}
    	} else if(type == "2") {
    		ComOpenPopup('/hanjin/COM_ENS_041.do', 780, 520, 'setPopData_BuyerCd', '1,0,1,1,1,1,1,1', true);
    	}

    	return;
    }

	/**
	 * (Service Provider) Pop-up Return Value 처리 부분<br>
	 * @param {arry} returnedValues Pop-up 화면의 Return value array
	 * @param Row 대상Object가 IBSheet일 경우 해당 Row index
	 * @param Col 대상Object가 IBSheet일 경우 해당 Col index
	 * @param 대상IBSheet의 Sheet Array index
	 */
	function setPopData_BuyerCd(aryPopupData, Row, Col, SheetIdx) {
		var formObj  = document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.p_cust_cd.value = aryPopupData[0][3];
			formObj.p_vndr_nm.value  = aryPopupData[0][4];
		}
	}

	/**
	 * EQ_TYPE별 타입사이즈를 조회해서 각 배열에 담는다.
	 */
	function initDynamicEqTpszCd(sheetObj) {
		var arrXml = MnrComSearchGrid(sheetObj,"type_size_search_ind","");

		if(arrXml != null) {
			for(var i = 0; i < arrXml.length; i++) {
				if(i == 0){//U
					cntrTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 1){//Z
					chssTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				} else if(i == 2){//G
					gsetTpSz = MnrXmlToOneDimArray(arrXml[i], "cd_id");
				}
			}
		}
	}

	/**
	 * Equipment Type/Size Grid Header Setting
	 */
	function setDynamicEqTpszHeader(sheetObj, eqKndCd) {
		var eqTpSzAry = new Array();

		if(eqKndCd == "U") {
			eqTpSzAry = cntrTpSz;
		} else if(eqKndCd == "Z") {
			eqTpSzAry = chssTpSz;
		} else {//eqKndCd is 'G'
			eqTpSzAry = gsetTpSz;
		}

		if(eqTpSzAry.length > 0) {
			var eqTpSzStr = "|"+ eqTpSzAry.toString().replace(/,/g, "|");
			vCntrTpszHdr = eqTpSzStr;
			vArrCntrTpsz = eqTpSzStr.split("|");
			vCntrTpszCnt = vArrCntrTpsz.length;

			for(i = 0; i < sheetObjects.length; i++) {
				/* IBSheet 재설정 */
				//khlee-시작 환경 설정 함수 이름 변경
				ComConfigSheet (sheetObjects[i] );
				initSheet(sheetObjects[i], i+1);
				//khlee-마지막 환경 설정 함수 추가
				ComEndConfigSheet(sheetObjects[i]);
			}
		}
	}

	/**
	 * Duration Date Validation 처리 부분<br>
	 */
    function checkDurationDate(eventObj) {
    	var formObj = document.form;
    	var vEffDt = ComReplaceStr(ComGetObjValue(formObj.p_str_evnt_dt),"-","");
		var vExpDt = ComReplaceStr(ComGetObjValue(formObj.p_end_evnt_dt),"-","");

		/* Duration Date Validation(p_str_evnt_dt) */
		if(vEffDt == "" && eventObj == null) {
			ComShowCodeMessage("MNR00172", "Start Date");
			ComSetFocus(formObj.p_str_evnt_dt);
			return false;
		} else if(vEffDt == "" && eventObj.name == "p_str_evnt_dt") {
			ComShowCodeMessage("MNR00172", "Start Date");
			ComSetFocus(formObj.p_str_evnt_dt);
			return false;
		} else if (vEffDt != "" && !ComIsDate(formObj.p_str_evnt_dt) ) {
			ComShowCodeMessage("MNR00346");
			ComSetObjValue(formObj.p_str_evnt_dt,"");
			ComSetFocus(formObj.p_str_evnt_dt);
			return false;
		}

		/* Duration Date Validation(end_evnt_dt) */
		if(vExpDt == "" && eventObj == null) {
			ComShowCodeMessage("MNR00172", "End Date");
			ComSetFocus(formObj.p_end_evnt_dt);
			return false;
		} else if(vExpDt == "" && eventObj.name == "p_end_evnt_dt") {
			ComShowCodeMessage("MNR00172", "End Date");
			ComSetFocus(formObj.p_end_evnt_dt);
			return false;
		} else if (vExpDt != "" && !ComIsDate(formObj.p_end_evnt_dt) ) {
			ComShowCodeMessage("MNR00347");
			ComSetObjValue(formObj.p_end_evnt_dt,"");
			ComSetFocus(formObj.p_end_evnt_dt);
			return false;
		}

		/* Duration Date Validation(str_evnt_dt < end_evnt_dt) */
		if(vEffDt != "" && vExpDt != "") {
			if ( ComChkPeriod(vEffDt, vExpDt) != 1 ) {
				ComShowCodeMessage("MNR00346");

				if(eventObj == null) {
					ComSetObjValue(formObj.p_end_evnt_dt,"");
					ComSetFocus(formObj.p_end_evnt_dt);
				} else {
					ComSetObjValue(eventObj,"");
					ComSetFocus(eventObj);
				}
				return false;
			}
		}

		return true;
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
	 * Form Element Clear 처리부분.<br>
	 * @param fieldName
	 */
	function clearForm(fieldName) {
		var formObj = document.form;
		switch(fieldName) {
			case "p_cust_cd":
				ComSetObjValue(formObj.p_cust_cd, 	"");
				ComSetObjValue(formObj.p_vndr_nm,  	"");
				ComSetFocus(formObj.p_cust_cd);
				break;
			default :	//do nothing
		}
	}
	/* 개발자 작업  끝 */