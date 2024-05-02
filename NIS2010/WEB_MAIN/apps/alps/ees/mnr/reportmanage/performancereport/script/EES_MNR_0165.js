/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0165.jsp
*@FileTitle : Disposal Performance by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.18
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.18 장준우
* 1.0 Creation
*=======================================================
* 2010.12.06 남궁진호 [CHM-201007441-01]Performance 실적에 대한 팝업 Link
* 2011.03.02 남궁진호 [CHM-201108450-01] G.TTL Detail 조회 팝업 오류 수정
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
     * @class EES_MNR_0165 : EES_MNR_0165 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MNR_0165() {
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

	var vCntrTpszHdr = "";
	var vCntrTpszDtl = "";
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
					ComSetFocus(formObj.p_str_evnt_dt);
					for(var i = 0; i < comboObjects.length; i++) {
						comboObjects[i].Index = 0;
					}
 					break;

 				case "btns_search":	//Buyer 조회 팝업
 					openPopup("1");
 					break;

				case "btns_calendar":	// Event Duration (FromTo)
					if ( srcObj.style.filter == "" ) {
						var cal = new ComCalendarFromTo();
						cal.select(formObj.p_str_evnt_dt, formObj.p_end_evnt_dt, 'yyyy-MM-dd');
					}
					break;

             	case "btn_DownExcel":
             		sheetObject.Down2Excel(-1, false, false, true);
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
    		case "p_cust_cd":	//Buyer Code
    			if ( ComTrim(obj.value) != "" ) {
	        		doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC01);
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
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 3, 20, 100);

					var HeadTitle1 = "RHQ|Office|Currency|Result||G.TTL|G.TTL|G.TTL"+ vCntrTpszHdr +"|";
					var HeadTitle2 = "RHQ|Office|Currency|Result||Quota|PFMC|Ratio"+ vCntrTpszDtl +"|";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 8, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, false, true, false,false)

					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					for(var i = 0; i < 3; i++) {
						cnt = 0;
						// 데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
						InitDataProperty(i, cnt++ , dtData,			60,		daCenter,	true,	"rhq_cd",			false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			60,		daCenter,	true,	"rqst_ofc_cd",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			60,		daCenter,	true,	"curr_cd",			false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			50,		daCenter,	false,	"rslt_tp_nm",		false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtHidden,		50,		daCenter,	false,	"rslt_tp_seq",		false,	"",	dfNone);

						InitDataProperty(i, cnt++ , dtData,			90,  	daRight,	false,	"quta_tpsz_dp00",	false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			90,  	daRight,	false,	"pfmc_tpsz_dp00",	false,	"",	dfNone);
						InitDataProperty(i, cnt++ , dtData,			90,  	daRight,	false,	"rato_tpsz_dp00",	false,	"",	dfNone);

						for(var j = 1; j < vCntrTpszCnt; j++) {
							var tpsz_dp_no = "tpsz_dp"+ ComLpad(j, 2, "0");
							InitDataProperty(i, cnt++ , dtData,		80,  	daRight,	false,	"quta_"+ tpsz_dp_no, false,	"",	dfNone);
							InitDataProperty(i, cnt++ , dtData,		80,  	daRight,	false,	"pfmc_"+ tpsz_dp_no, false,	"",	dfNone);
							InitDataProperty(i, cnt++ , dtData,		80,  	daRight,	false,	"rato_"+ tpsz_dp_no, false,	"",	dfNone);

	                    	if(vArrCntrTpsz[j] != "") {
								eval('ColHidden("quta_tpsz_dp'+ ComLpad(j, 2, "0") + '") = false;');
								eval('ColHidden("pfmc_tpsz_dp'+ ComLpad(j, 2, "0") + '") = false;');
								eval('ColHidden("rato_tpsz_dp'+ ComLpad(j, 2, "0") + '") = false;');
							} else {
								eval('ColHidden("quta_tpsz_dp'+ ComLpad(j, 2, "0") + '") = true;');
								eval('ColHidden("pfmc_tpsz_dp'+ ComLpad(j, 2, "0") + '") = true;');
								eval('ColHidden("rato_tpsz_dp'+ ComLpad(j, 2, "0") + '") = true;');
							}
						}

						InitDataProperty(i, cnt++ , dtAutoSum,       50,    daRight,  	true,  	"auto_sum",        	false,  "",	dfNone);
					}
					ColHidden("auto_sum") = true;
					SelectBackColor = MNR_SELECT_BACK_COLOR;
 					CountFormat = "[SELECTDATAROW / TOTALROWS]";
 					CountPosition = 0;
 					sheetObj.SetMergeCell(0, 3, 2, 2);
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
	    	case "combo2":
	        	with(comboObj) {
	            	DropHeight = 150;
	            	UseAutoComplete = true;
	            	Enable = false;
	            	ValidChar(2, 1);	//영문(대)+숫자
	            	MaxLength = 6;
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
					new Array("MdmOrganization","RHQ","FALSE"),	//RHQ_CD
					new Array("MnrGenCd","CD00038", "COMMON")	//DISP_RSN_CD
				)

				var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);

				//조건부 콤보데이타에 값을 세팅함
				for(var i = 0; i < comboList.length;i++){
					if(comboList[i] != null){
						for(var j = 0; j < comboList[i].length;j++){
							var tempText = comboList[i][j].split("|");

							if(i == 0) {
								comboObjects[0].InsertItem(j, tempText[0] ,tempText[0]);
							} else if(i == 1) {
								comboObjects[2].InsertItem(j, tempText[1] ,tempText[0]);
							}
						}
					}
				}

				comboObjects[0].InsertItem(0 , 'ALL','');
				comboObjects[0].Index = 0;
				comboObjects[2].InsertItem(0 , 'ALL','');
				comboObjects[2].Index = 0;
				break;
			case IBSEARCH:			//조회
				if(validateForm(sheetObj, formObj, sAction)) {
					if(sheetObj.id == "sheet1") {
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible = false;
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchXml("EES_MNR_0165GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchXml(sXml);
						ComOpenWait(false);
						sheetObj.WaitImageVisible = true;
					}
				}
				break;
 			case IBSEARCH_ASYNC01:	// Buyer Code 조회
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
	 * sheet1_OnMouseMove :: 마우스가 Sheet 위에서 움직일 때 발생하는 Event
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		with(sheetObj) {
			if(/pfmc_tpsz_dp*/.test(ColSaveName(MouseCol)) == true) {
				if(MouseRow > HeaderRows) {
					DataLinkMouse(MouseCol) = true;
					if(MouseRow > LastRow -3) {
						MousePointer = "Hand";
					}
				}
			}

		}
	}

	/**
	 * sheet1_OnDblClick
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj = document.form;
		var sName  = sheetObj.ColSaveName(Col);
		var vOfcCd = sheetObj.CellValue(Row,"rqst_ofc_cd");
		var params = ComGetObjValue(formObj.h_etc_params);

		switch (sName) {
			case "pfmc_tpsz_dp01": case "pfmc_tpsz_dp02": case "pfmc_tpsz_dp03":
			case "pfmc_tpsz_dp04": case "pfmc_tpsz_dp05": case "pfmc_tpsz_dp06":
			case "pfmc_tpsz_dp07": case "pfmc_tpsz_dp08": case "pfmc_tpsz_dp09":
			case "pfmc_tpsz_dp10": case "pfmc_tpsz_dp11": case "pfmc_tpsz_dp12":
			case "pfmc_tpsz_dp13": case "pfmc_tpsz_dp14": case "pfmc_tpsz_dp15":
			case "pfmc_tpsz_dp16": case "pfmc_tpsz_dp17": case "pfmc_tpsz_dp18":
			case "pfmc_tpsz_dp19": case "pfmc_tpsz_dp20": case "pfmc_tpsz_dp21":
			case "pfmc_tpsz_dp22": case "pfmc_tpsz_dp23": case "pfmc_tpsz_dp24":
			case "pfmc_tpsz_dp25": case "pfmc_tpsz_dp26": case "pfmc_tpsz_dp27":
			case "pfmc_tpsz_dp28": case "pfmc_tpsz_dp29": case "pfmc_tpsz_dp30":
				params += "&h_eq_tpsz_cd="+ sheetObj.CellText(0, Col);
				params += "&h_rhq_cd="+ sheetObj.CellValue(Row,"rhq_cd");

				if(vOfcCd == "S.TTL") {
					params += "&h_ofc_cd="+ ComGetObjValue(formObj.h_ofc_cd);
					params += "&h_curr_cd=";
				} else {
					params += "&h_ofc_cd="+ sheetObj.CellValue(Row,"rqst_ofc_cd");
					params += "&h_curr_cd="+ sheetObj.CellValue(Row,"curr_cd");
				}
		        break;
			case "pfmc_tpsz_dp00":
				params += "&h_eq_tpsz_cd=";
				params += "&h_rhq_cd="+ sheetObj.CellValue(Row,"rhq_cd");

				if(vOfcCd == "S.TTL") {
					params += "&h_ofc_cd="+ ComGetObjValue(formObj.h_ofc_cd);
					params += "&h_curr_cd=";
				} else {
					params += "&h_ofc_cd="+ sheetObj.CellValue(Row,"rqst_ofc_cd");
					params += "&h_curr_cd="+ sheetObj.CellValue(Row,"curr_cd");
				}
				break;
		}

		if (sheetObj.MousePointer == "Hand") {
			ComOpenWindowCenter("/hanjin/EES_MNR_0247.do?"+ params, "EES_MNR_0247", 950, 555, true);
		}
	}

    /**
	 * sheet1_OnMouseDown
	 * 마우스가 눌러졌을때 발생하는 Event 처리
	 * SUMMARY 에 해당하는 DETAIL 조회
	 */
	function sheet1_OnMouseDown(sheetObj , Button, Shift, X, Y) {
		var formObj = document.form;
		var sRow = sheetObj.MouseRow;
		var sCol = sheetObj.MouseCol;

		var sName  = sheetObj.ColSaveName(sCol);
		var params = "";
		
		if(sheetObj.MouseRow > sheetObj.LastRow -3 && sheetObj.LastRow > 1) {
			switch (sName) {
				case "pfmc_tpsz_dp01": case "pfmc_tpsz_dp02": case "pfmc_tpsz_dp03":
				case "pfmc_tpsz_dp04": case "pfmc_tpsz_dp05": case "pfmc_tpsz_dp06":
				case "pfmc_tpsz_dp07": case "pfmc_tpsz_dp08": case "pfmc_tpsz_dp09":
				case "pfmc_tpsz_dp10": case "pfmc_tpsz_dp11": case "pfmc_tpsz_dp12":
				case "pfmc_tpsz_dp13": case "pfmc_tpsz_dp14": case "pfmc_tpsz_dp15":
				case "pfmc_tpsz_dp16": case "pfmc_tpsz_dp17": case "pfmc_tpsz_dp18":
				case "pfmc_tpsz_dp19": case "pfmc_tpsz_dp20": case "pfmc_tpsz_dp21":
				case "pfmc_tpsz_dp22": case "pfmc_tpsz_dp23": case "pfmc_tpsz_dp24":
				case "pfmc_tpsz_dp25": case "pfmc_tpsz_dp26": case "pfmc_tpsz_dp27":
				case "pfmc_tpsz_dp28": case "pfmc_tpsz_dp29": case "pfmc_tpsz_dp30":
					params += "&h_eq_tpsz_cd="+ sheetObj.CellText(0, sCol);
					params += "&h_rhq_cd="+ ComGetObjValue(formObj.h_rhq_cd);
					params += "&h_ofc_cd="+ ComGetObjValue(formObj.h_ofc_cd);
					params += "&h_curr_cd=";
			        break;
				case "pfmc_tpsz_dp00":
					params += "&h_eq_tpsz_cd=";
					params += "&h_rhq_cd="+ ComGetObjValue(formObj.h_rhq_cd);
					params += "&h_ofc_cd="+ ComGetObjValue(formObj.h_ofc_cd);
					params += "&h_curr_cd=";
					break;
			}

			if (params != "") {
				params += ComGetObjValue(formObj.h_etc_params);
				ComOpenWindowCenter("/hanjin/EES_MNR_0247.do?"+ params, "EES_MNR_0247", 950, 555, true);
			}
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

			if(LastRow > 2) {
				for(var i = 0; i < LastRow -3; i++) {
					if(CellValue(i, "rqst_ofc_cd") == "S.TTL" ) {
						RowBackColor(i) = MNR_TOTCOL_BACK_COLOR;
					}
				}

				for(var i = LastRow -3; i > LastRow -6; i--) {
					for(var j = 0; j < LastCol; j++) {
						CellText(i +3, j) = CellText(i, j);
						if(/curr_cd|rslt_tp_nm/.test(ColSaveName(j))) {
							CellAlign(i +3, j) = daCenter;
						}
					}
				}

				for ( var i = 1 ; i < vCntrTpszCnt ; i++ ) {
					var qutaData = eval('CellValue(LastRow -5, "quta_tpsz_dp'+ ComLpad(i, 2, "0") + '")');
					var pfmcData = eval('CellValue(LastRow -5, "pfmc_tpsz_dp'+ ComLpad(i, 2, "0") + '")');

					if(qutaData <= 0 && pfmcData <= 0) {
						eval('ColHidden("quta_tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
						eval('ColHidden("pfmc_tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
						eval('ColHidden("rato_tpsz_dp'+ ComLpad(i, 2, "0") + '") = true;');
					} else {
						eval('ColHidden("quta_tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
						eval('ColHidden("pfmc_tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
						eval('ColHidden("rato_tpsz_dp'+ ComLpad(i, 2, "0") + '") = false;');
						viewCnt++;
					}
				}

				if(510 + (viewCnt * 80 * 3) > 984) {
					SheetWidth = 984;
				} else {
					SheetWidth = 520 + (viewCnt * 80 * 3);
				}

				sheetObj.RowDelete(LastRow -5, false);
				sheetObj.RowDelete(LastRow -4, false);
				sheetObj.RowDelete(LastRow -3, false);

				sheetObj.SetMergeCell(LastRow -2 , 0, 3, 2);
				sheetObj.SetMergeCell(LastRow -2 , 2, 3, 1);
				sheetObj.CellValue2(LastRow -2, "rhq_cd") = "G.TTL";
				sheetObj.CellValue2(LastRow -1, "rhq_cd") = "G.TTL";
				sheetObj.CellValue2(LastRow, "rhq_cd") = "G.TTL";

				var formObj = document.form;
				formObj.h_rhq_cd.value = ComGetObjValue(formObj.p_rhq_cd);
				formObj.h_ofc_cd.value = ComGetObjValue(formObj.p_ofc_cd);
				formObj.h_etc_params.value = "&h_str_evnt_dt="+ ComGetObjValue(formObj.p_str_evnt_dt)
										   + "&h_end_evnt_dt="+ ComGetObjValue(formObj.p_end_evnt_dt)
										   + "&h_disp_tp_cd="+ ComGetObjValue(formObj.p_disp_tp_cd)
										   + "&h_disp_tp_nm="+ ComGetObjText(formObj.p_disp_tp_cd)
										   + "&h_eq_knd_cd="+ ComGetObjValue(formObj.p_eq_knd_cd)
										   + "&h_eq_knd_nm="+ ComGetObjText(formObj.p_eq_knd_cd)
										   + "&h_disp_rsn_cd="+ ComGetObjValue(formObj.p_disp_rsn_cd)
										   + "&h_disp_rsn_nm="+ ComGetObjText(formObj.combo3)
										   + "&h_cust_cd="+ ComGetObjValue(formObj.p_cust_cd)
										   + "&h_vndr_nm="+ ComGetObjValue(formObj.p_vndr_nm);
			}
    	}
    }

    /**
	 * combo1_OnBlur
	 */
	function combo1_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.p_rhq_cd.value = ComGetObjValue(comboObj);

		if(ComGetObjValue(formObj.p_rhq_cd) == "ALL") {
			ComSetObjValue(formObj.p_rhq_cd, "");
		}
	}

	/**
	 * combo1_OnChange
	 */
	function combo1_OnChange(comboObj,Index_Code, Text) {
		var formObj = document.form;
		ComSetObjValue(formObj.p_ofc_cd, "");
		comboObjects[1].removeAll();

		if(Index_Code != "") {
			comboObjects[1].Enable = true;

			var sCondition = new Array (
				new Array("MdmOrganization","SEARCH",Index_Code)
			)
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition);

			if(comboList[0] != null){
				for(var j = 0; j < comboList[0].length;j++){
			   		var tempText = comboList[0][j].split("|");
			   		comboObjects[1].InsertItem(j,comboList[0][j] ,tempText[0]);
				}

				comboObjects[1].InsertItem(0 , 'ALL','');
				comboObjects[1].Index = 0;
			}
			ComSetFocus(formObj.combo2);
		} else {
			comboObjects[1].Enable = false;
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
				formObj.p_rhq_cd.value = ComGetObjValue(comboObj);
				if(ComGetObjValue(formObj.p_rhq_cd) == "ALL") {
					ComSetObjValue(formObj.p_rhq_cd, "");
				}

				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
		}
	}

	/**
	 * combo2_OnBlur
	 */
	function combo2_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		var combTxt = ComGetObjValue(comboObj);

		if(combTxt == "" || combTxt == "ALL") {
			ComSetObjValue(formObj.p_ofc_cd, "");
			comboObj.Index = 0;
		} else {
			formObj.p_ofc_cd.value = combTxt;
		}
	}

	/**
	 * cobo2_OnKeyDown
	 */
	function combo2_OnKeyDown(comboObj, KeyCode, Shift) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];

		with(comboObj) {
			if(KeyCode == 13) {
				formObj.p_ofc_cd.value = ComGetObjValue(comboObj);
				if(ComGetObjValue(formObj.p_ofc_cd) == "ALL") {
					ComSetObjValue(formObj.p_ofc_cd, "");
				}

				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			}
		}
	}

	/**
	 * combo3_OnBlur
	 */
	function combo3_OnBlur(comboObj, Index_Code, Text) {
		var formObj = document.form;
		formObj.p_disp_rsn_cd.value = ComGetObjValue(comboObj);

		if(ComGetObjValue(formObj.p_disp_rsn_cd) == "ALL") {
			ComSetObjValue(formObj.p_disp_rsn_cd, "");
		}
	}

	/**
	 * cobo3_OnKeyDown
	 */
	function combo3_OnKeyDown(comboObj, KeyCode, Shift) {
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

    	if(type == "1") {
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
			formObj.p_vndr_nm.value = aryPopupData[0][4];
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
			vArrCntrTpsz = eqTpSzStr.split("|");
			vCntrTpszCnt = vArrCntrTpsz.length;
			vCntrTpszHdr = "";
			vCntrTpszDtl = "";

			for(var j = 0; j < eqTpSzAry.length; j++) {
				for(var k = 0; k < 3; k++) {
					vCntrTpszHdr += ("|"+ eqTpSzAry[j]);
					if(k == 0) {
						vCntrTpszDtl += "|Quota";
					} else if(k == 1) {
						vCntrTpszDtl += "|PFMC";
					} else {//k == 2
						vCntrTpszDtl += "|Ratio";
					}
				}
			}

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