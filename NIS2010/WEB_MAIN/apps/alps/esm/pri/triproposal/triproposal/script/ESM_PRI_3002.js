/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3002.js
 *@FileTitle : TRI Creation &amp; Amendment - Note Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.17
 *@LastModifier : 최성민
 *@LastVersion : 1.0
 * 2009.11.17 최성민
 * 1.0 Creation
=========================================================
* History
* 2011.08.23 서미진 [선처리 후 CSR] TRI Note Creation 화면의 Note 내용을 decode하는 불필요한 Script 제거
* 2015.04.02 송호진 [CHM-201535140] S/C Note conversion에 중복 체크 로직 수정요청 - validateDupCheck 상의 로직 오류 수정 
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
 * @class ESM_PRI_3002 : ESM_PRI_3002 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_3002() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/

var sheetObjects = new Array();
var sheetCnt = 0;

// 콤보에서의 VISIALE 항목 리스트
var sChgCdVisiable = "";

// Note Conversion type Code
var NOTE_CONV_TP_CD = "R";	//TRI RATE NOTE

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * processButtonClick();
 * </pre>
 * 
 * @return 없음
 * @author 최성민
 * @version 2009.10.28
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

	var sheetObject1 = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
        if (srcName != null && srcName != "" && (srcName.indexOf("btn") == 0 || srcName.indexOf("srch_btn") == 0)) {
        	if (getButtonTable(srcName).disabled) {
        		return false;
        	}
        }
        
		switch (srcName) {
		case "btn_copy":
			if (validateForm(sheetObject1, formObject, COMMAND01)) {
				doActionIBSheet(sheetObject1, formObject, COMMAND01);
			}
			break;

		case "btn_paste":
			if (validateForm(sheetObject1, formObject, COMMAND02)) {
				doActionIBSheet(sheetObject1, formObject, COMMAND02);
			}
			break;

		case "btn_rowadd":
			if (validateForm(sheetObject1, formObject, IBINSERT)) {
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
			}
			break;

		case "btn_rowcopy":
			if (validateForm(sheetObject1, formObject, IBCOPYROW)) {
				doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
			}
			break;

		case "btn_delete":
			if (validateForm(sheetObject1, formObject, IBDELETE)) {
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
			}
			break;

		case "btn_retrieve":
			if (validateForm(sheetObject1, formObject, IBSEARCH)) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;

		case "btn_ok":
			if (validateForm(sheetObject1, formObject, IBSAVE)) {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			}
			break;

		case "btn_close":	
			window.close();
			/*
			if (sheetObject1.IsDataModified && ComShowCodeConfirm('PRI00006')) {
				if (validateForm(sheetObject1, formObject, IBSAVE)) {
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				}
			} else {
				window.close();
			}	
			*/		
			break;

		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 <br>
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
 * 배열은 소스 상단에 정의 <br>
 * <br><b>Example :</b>
 * <pre>
 *     setSheetObject(sheetObj);
 * </pre>
 * @param {ibsheet} sheet_obj 필수 IBSheet Object
 * @return 없음
 * @author 최성민
 * @version 2009.10.28
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 <br>
 * body 태그의 onLoad 이벤트핸들러 구현 <br>
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     loadPage();
 * </pre>
 * @return 없음
 * @author 최성민
 * @version 2009.05.17
 */
function loadPage() {
	
	for (i = 0; i < sheetObjects.length; i++) {

		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var formObj = document.form;
	toggleButtons(formObj.is_editable.value);
	//toggleButtons("N");
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
}

/**
 * 시트 초기설정값, 헤더 정의 <br>
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
 * @return 없음
 * @author 최성민
 * @version 2009.05.22
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {
            // 높이 설정
            style.height = 220;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;

            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msHeaderOnly;

           //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo( 1, 1, 7, 100);

            var HeadTitle = "|Sel.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
            		"|Pay Term|Weight\n(Ton < = )|Weight\n( > Ton)|SOC|T/S\nPort|Direct\nCall|Bar Type" +
            		"|1|2|3|4|5|6|7|8|9|10|11|12";
            var headCount = ComCountHeadTitle(HeadTitle);

            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(headCount, 6, 0, true);

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(true, true, true, true, false,false);

            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,		30,   daCenter,  true,	"ibflag");
            InitDataProperty(0, cnt++ , dtDummyCheck,     	40,   daCenter,  true,	"chk");
            InitDataProperty(0, cnt++ , dtComboEdit,	   	50,   daCenter,  true,	"chg_rule_def_cd",			true,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtPopupEditFormat,	100,  daCenter,  true,	"eff_dt",  					true,	"",	dfDateYmd,			0,     true,       true);
            InitDataProperty(0, cnt++ , dtPopupEditFormat,	100,  daCenter,  true,	"exp_dt",     				true,	"",	dfDateYmd, 		 	0,     true,       true);
            InitDataProperty(0, cnt++ , dtCombo,    		90,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtCombo,  	    	45,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtCombo,        	40,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,         	80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		3,     true,       true,	10);
            InitDataProperty(0, cnt++ , dtCombo,   			40,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     true,       true);
            
            InitDataProperty(0, cnt++ , dtCombo,  			50,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,   	    	50,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     true,       true, 	3);
            InitDataProperty(0, cnt++ , dtCombo,      		80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     true,       true);
            
            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_min_cgo_wgt",   		false,	"",	dfFloat,			2,     true,       true,	4);
            InitDataProperty(0, cnt++ , dtData,  			70,   daRight,   true,	"bkg_max_cgo_wgt",    		false,	"",	dfFloat,			2,     true,       true,	4);
            InitDataProperty(0, cnt++ , dtCombo,			40,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtPopupEdit,		70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     true,       true,	5);
            InitDataProperty(0, cnt++ , dtCombo,			50,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     true,       true);
            InitDataProperty(0, cnt++ , dtCombo,   	 		65,   daCenter,  true,	"bkg_hngr_bar_tp_cd",     	false,	"",	dfNone, 			0,     true,       true);
            
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_mapg_id");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_seq");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"trf_pfx_cd");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"amdt_seq");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"tri_prop_no");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"trf_no");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"chg_rule_tp_cd");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_chg_cd");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_rule_cd");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_hdr_seq");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"note_conv_tp_cd");
            InitDataProperty(0, cnt++ , dtHidden,			40,	daLeft,		false,	"bkg_ts_port_tp_cd");
            
            InitDataCombo(0, "bkg_soc_flg", 		" |Yes|No", " |Y|N");
            InitDataCombo(0, "bkg_dir_call_flg", 	" |Yes|No", " |Y|N");
            InitDataCombo(0, "rt_appl_tp_cd", rtApplTpCdComboText, rtApplTpCdComboValue);            
            InitDataCombo(0, "bkg_prc_cgo_tp_cd", bkgPrcCgoTpCdComboText, bkgPrcCgoTpCdComboValue);
            InitDataCombo(0, "rt_op_cd", rtOpCdComboText, rtOpCdComboValue);
            InitDataCombo(0, "pay_term_cd", payTermCdComboText, payTermCdComboValue);            
            InitDataCombo(0, "bkg_hngr_bar_tp_cd", bkgHngrBarTpCdComboText, bkgHngrBarTpCdComboValue);            
            InitDataCombo(0, "bkg_rat_ut_cd", bkgRatUtCdComboText, bkgRatUtCdComboValue);
            InitDataCombo(0, "curr_cd", currCdComboText, currCdComboValue);            
            InitDataCombo(0, "chg_rule_def_cd", chargeRuleCdComboText,chargeRuleCdComboValue);
            
            sChgCdVisiable = chargeRuleCdComboText;	//초기로딩값 세팅
            
                                        
            InitDataValid(0, "chg_rule_def_cd", 			vtEngUpOnly);
            InitDataValid(0, "bkg_imdg_clss_cd", 			vtNumericOther, ".");			 
			 
	 		ShowButtonImage	= 2;	// Edit 가능할때 팝업 이미지 표시
	 		CountPosition = 0;		// Total 숨김
	 		ImageList(0) = "img/btns_calendar.gif";
	 		PopupButtonImage(0, "eff_dt") = 0;
	 		PopupButtonImage(0, "exp_dt") = 0;
            WaitImageVisible = false;
		}
		break;

	}
}

/**
 * Sheet관련 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @return 없음
 * @author 최성민
 * @version 2009.05.22
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		sheetObj.ShowDebugMsg = false;
		switch (sAction) {
			case IBSEARCH: // 조회
  				ComOpenWait(true);
				// NOTE CONVERSION RULE
				var sCd = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
				var sNm = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
		
				// //////////////////////////////////////////////////////////////////////////////
				//formObj.f_cmd.value = SEARCH01;
				//var sXml = sheetObj.GetSearchXml("ESM_PRI_3002GS.do", FormQueryString(formObj));
				var sXml = dialogArguments.getSheetXml(6);
				
				var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd");
		
				if (arrData != null && arrData.length > 0) {
					for ( var i = 0; i < arrData.length; i++) {
						if (sCd.indexOf(arrData[i][0]) < 0) {
							sCd += "|" + arrData[i][0];
							sNm += "|" + arrData[i][0];
						}
					}
					sheetObj.InitDataCombo(0, 2, sNm, sCd, "", "", 0, "", "", sChgCdVisiable);
				}
		
				sheetObj.LoadSearchXml(sXml);
				break;
		
			case IBSAVE: // 저장    
				//formObj.f_cmd.value = MULTI01;
				//sheetObj.DoAllSave("ESM_PRI_3002GS.do", FormQueryString(formObj));
				//메인의 NOTE_CTNT에 데이터를 세팅한다.
				
				var sXml = ComPriSheet2Xml(sheetObj);
				dialogArguments.setSheetXml(sXml, 6);		
		       
				var obj = new Object();
				var sNoteCtnt = formObj.note_ctnt.value;
				obj.note_ctnt = sNoteCtnt;//decodeURIComponent(sNoteCtnt);				
				window.returnValue = obj;
		    	window.close();   
				break;
		
			case IBINSERT: // Row Add
		
				var idx = sheetObj.DataInsert();
		
				sheetObj.CellValue2(idx, "exp_dt") 				= formObj.exp_dt.value;
				sheetObj.CellValue2(idx, "eff_dt") 				= formObj.eff_dt.value;
				sheetObj.CellValue2(idx, "trf_pfx_cd") 			= formObj.trf_pfx_cd.value;
				sheetObj.CellValue2(idx, "tri_prop_no") 		= formObj.tri_prop_no.value;
				sheetObj.CellValue2(idx, "trf_no") 				= formObj.trf_no.value;
				sheetObj.CellValue2(idx, "amdt_seq") 			= formObj.amdt_seq.value;
				sheetObj.CellValue2(idx, "note_conv_mapg_id") 	= formObj.note_conv_mapg_id.value;
				sheetObj.CellValue2(idx, "note_conv_tp_cd") 	= NOTE_CONV_TP_CD;
				sheetObj.CellValue2(idx, "note_conv_seq") 		= parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
		
				sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
		
				// Code 에 Default 값이 존재할경우 적용
				defaultColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
				// Editable를 세팅한다.
				disableColumnValidation(sheetObj, idx, 2, sheetObj.CellValue(idx, "chg_rule_def_cd"));
		
				break;
		
			case IBDELETE: // Delete
				var iCheckRow = sheetObj.FindCheckedRow("chk");
				if (iCheckRow == "") {
					sheetObj.CellValue2(sheetObj.SelectRow, "chk") = "1";
				}
				iCheckRow = sheetObj.FindCheckedRow("chk");
		
				if (iCheckRow != "") {
					deleteRowCheck(sheetObj, "chk");
				}
				break;
		
			case IBCOPYROW:
				copySheetData(sheetObj);
				break;
		
			case COMMAND01: //COPY
		
				var iCheckRow = sheetObj.FindCheckedRow("chk");
		
				//카피하시겠습니까?
				if ((ComShowCodeConfirm("PRI00012"))) {
					if (iCheckRow != "") {
						comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
					}
			
	  				ComOpenWait(true);
					formObj.f_cmd.value = MULTI02;
					sheetObj.DoSave("ESM_PRI_3002GS.do", FormQueryString(formObj), -1, false);
				}
		
				break;
		
			case COMMAND02: //PASTE
		
				// 붙여넣기 하시겠습니까?
				if ((ComShowCodeConfirm("PRI00016"))) {
	  				ComOpenWait(true);
					// NOTE CONVERSION RULE
					var sCd = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
					var sNm = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
					// ////////////////////////////////////////////////////////////
					formObj.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("ESM_PRI_3002GS.do", FormQueryString(formObj));
					var arrData = ComPriXml2Array(sXml, "chg_rule_def_cd");
		
					if (arrData != null && arrData.length > 0) {
						//콤보리스트에 추가후 InitDataCombo 호출
						for ( var i = 0; i < arrData.length; i++) {
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}
						sheetObj.InitDataCombo(0, 2, sNm, sCd, "", "", 0, "", "", sChgCdVisiable);
						// ////////////////////////////////////
						sheetObj.LoadSearchXml(sXml, true);
		
						// SHEET를 LOAD한 후에 기본 값을 세팅한다.
						var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
						var arrRow = ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
		
						if (arrRow != null && arrRow.length > 0) {
		
							for ( var i = 0; i < arrRow.length; i++) {
								sheetObj.RowStatus(arrRow[i]) 						= "I";
								sheetObj.CellValue2(arrRow[i], "note_conv_seq") 	= maxSeq + i;
								sheetObj.CellValue2(arrRow[i], "note_conv_mapg_id") = formObj.note_conv_mapg_id.value;
								sheetObj.CellValue2(arrRow[i], "trf_pfx_cd") 		= formObj.trf_pfx_cd.value;
								sheetObj.CellValue2(arrRow[i], "tri_prop_no") 		= formObj.tri_prop_no.value;
								sheetObj.CellValue2(arrRow[i], "trf_no") 			= formObj.trf_no.value;
								sheetObj.CellValue2(arrRow[i], "amdt_seq") 			= formObj.amdt_seq.value;
								sheetObj.CellValue2(arrRow[i], "note_conv_tp_cd") 	= NOTE_CONV_TP_CD;
							}
						}
					} else {
						ComShowCodeMessage("PRI00328");
					}
				}
				break;
		}
	}catch(e){
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}finally {
		 ComOpenWait(false);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <br><b>Example :</b>
 * <pre>
 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
 *         로직처리;
 *     }
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {form} formObj 필수 html form object
 * @param {int} sAction 필수 프로세스 플래그 상수
 * @returns bool <br>
 *          true  : 폼입력값이 유효할 경우<br>
 *          false : 폼입력값이 유효하지 않을 경우
 * @author 최성민
 * @version 2009.04.17
 */
function validateForm(sheetObj, formObj, sAction) {

	switch (sAction) {

	case IBSAVE:
		
		if(ComTrim(formObj.note_ctnt.value).length < 1) {
			ComShowCodeMessage("PRI00316", "Note");
			formObj.note_ctnt.focus();
			return false;
		}

		if (sheetObj.IsDataModified && sheetObj.GetSaveString() == "") {
			return false;
		}
		
		if (!checkDuration(sheetObj)) {
			return false;
		}

		//FOCUS가 ROW이동될때마다 체크하는 방식을 SAVE할때 체크하는걸로 수정 - 잘못된 데이터가 이행될 경우가 존재하기 때문임.
		for(var i = sheetObj.HeaderRows; getValidRowCount(sheetObj) > 0 && i <= sheetObj.LastRow; i++) {
  	 		//삭제데이터는 체크하지 않는다.
  	 		if(sheetObj.RowStatus(i) == "D") {
  	 			continue;
  	 		}
  	 		
			if(!checkMandatoryValidation(sheetObj, i)) {
				return false;
			}
		}

		if (sheetObj.IsDataModified) {
			//중복체크
			if (!validateDupCheck(sheetObj)) {
				return false;
			}
		}
		
		

		break;

	case IBCOPYROW:
		if (!checkDuration(sheetObj)) {
			return false;
		}

		if (sheetObj.RowCount > 0) {
			//mandatory check
			if (!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
				return false;
			}

		}

		break;

	case IBINSERT:
		if (sheetObj.RowCount > 0) {
			//mandatory check
			if (!checkMandatoryValidation(sheetObj, sheetObj.SelectRow)) {
				return false;
			}

		}
		break;

	case COMMAND01:
		var iCheckRow = sheetObj.FindCheckedRow("chk");

		if (iCheckRow == "") {
			ComShowCodeMessage("PRI00327");
			return false;
		}

		break;

	case COMMAND02:

		break;

	}

	return true;
}

/**
 * SHEET ROW 중복체크를 하는 FUNCTION <br>
 * 모든 항목이 같고 EFF_DT와 EXP_DT가 중첩이 발생할경우에 중복체크를 한다. <br>
 * <br><b>Example :</b>
 * <pre>
 * validateDupCheck(sheetObj)
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return boolean
 * @author 최성민
 * @version 2009.05.20
 */
function validateDupCheck(sheetObj) {

	var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd|bkg_imdg_clss_cd"
			+ "|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt" 
			+ "|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd", false, true);

	if (rowM != "") {
		// ColValueDupRows(ColList, false, true) 함수는 "중복되는 기준 Row List|중복발상기준 Row List" 형식으로 값이 반환되므로 
		// "|" 문자를 기준으로 split 하여 0 은 Key List 로 , 1 은 비고 대상 List 로 한다.  
		var rowDupKeyList = rowM.split("|");
		
		//var rowDup = rowM.replace("|", ","); 			
		//중복되는 모든ROW
		//var rowArr = rowDup.split(",");
		
		var rowArr = rowDupKeyList[0].split(",");
		var rowObj = rowDupKeyList[1].split(",");
			
		var dupValue = "";
		var temValue = "";
		var firstEffDt = "";
		var firstExpDt = "";
		var SecondEffDt = "";
		var SecondExpDt = "";
		var hrows = sheetObj.HeaderRows;

		for ( var i = 0; i < rowArr.length; i++) {
			dupValue = sheetObj.CellValue(rowArr[i], "chg_rule_def_cd");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_rat_ut_cd");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_imdg_clss_cd");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_soc_flg");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_dir_call_flg");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_ts_port_def_cd");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_min_cgo_wgt");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_max_cgo_wgt");
			dupValue += "\t" + sheetObj.CellValue(rowArr[i], "bkg_hngr_bar_tp_cd");

			for ( var j = 0; j < rowObj.length; j++) {
				temValue = sheetObj.CellValue(rowObj[j], "chg_rule_def_cd");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_rat_ut_cd");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_prc_cgo_tp_cd");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_imdg_clss_cd");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_soc_flg");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_dir_call_flg");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_ts_port_def_cd");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_min_cgo_wgt");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_max_cgo_wgt");
				temValue += "\t" + sheetObj.CellValue(rowObj[j], "bkg_hngr_bar_tp_cd");

				//if (i != j) {
					if (dupValue == temValue) {
						firstEffDt = sheetObj.CellValue(rowArr[i], "eff_dt");
						firstExpDt = sheetObj.CellValue(rowArr[i], "exp_dt");

						SecondEffDt = sheetObj.CellValue(rowObj[j], "eff_dt");
						SecondExpDt = sheetObj.CellValue(rowObj[j], "exp_dt");

						if (firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
							ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
							return false;
						}

						if (firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
							ComShowCodeMessage("PRI00303", "Sheet", String(Number(rowArr[i])+1-hrows) + ", " + String(Number(rowObj[j])+1-hrows) );
							return false;
						}

					} //if
				//} //if
			} //for

		} //for

	} //if

	return true;
}

/**
 * OnSearchEnd 이벤트 발생시 호출되는 function <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
 * @return 없음
 * @author 최성민
 * @version 2009.05.20
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		disableColumnValidation(sheetObj, i, 2, sheetObj.CellValue(i, "chg_rule_def_cd"));

 		//Rule Code 일 경우에는 색상을 지정
 		//setChargeRuleColor(sheetObj, i);
	}
}

/**
 * OnChange 이벤트 발생시 호출되는 function <br>
 * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
 * @return 없음
 * @author 최성민
 * @version 2009.06.25
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;

	switch (colName) {
	case "chg_rule_def_cd":

		if (Value != null && Value != "" && Value.length == 3) {
			//DEFAULT 데이터처리
			defaultColumnValidation(sheetObj, Row, Col, Value);
			// 컬럼 disable 처리
			disableColumnValidation(sheetObj, Row, Col, Value);

			var sCode = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
			var sText = sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
			
			if (sCode.indexOf(Value) < 0) {
				formObj.f_cmd.value = COMMAND09;
				sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);

				var arrData = ComPriXml2Array(sXml, "cd|nm");
				if (arrData != null && arrData.length > 0) {
					sCode += "|" + Value;
					sText += "|" + Value;
					sheetObj.InitDataCombo(0, "chg_rule_def_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);

					//ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
				} else {
					sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
				}
			}

			insertChargeRuleType(sheetObj, Row);
		} else {
			sheetObj.CellValue2(Row, "chg_rule_def_cd") = "";
		}

		// Rule & Charge Code 색 구분
		//setChargeRuleColor(sheetObj, Row);
		break;

	case "eff_dt":
		var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
		var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");

		if (sheetObj.CellValue(Row, "eff_dt") < effDt) {
			ComShowCodeMessage("PRI08016");
			sheetObj.CellValue2(Row, "eff_dt") = effDt;
			sheetObj.SelectCell(Row, "eff_dt");
		}

		if (sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt")) {
			ComShowCodeMessage("PRI00306");
			sheetObj.CellValue2(Row, "eff_dt") = effDt;
			sheetObj.SelectCell(Row, "eff_dt");
		}
		break;

	case "exp_dt":
		var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
		var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");

		if (sheetObj.CellValue(Row, "exp_dt") > expDt) {
			ComShowCodeMessage("PRI08016");
			sheetObj.CellValue2(Row, "exp_dt") = expDt;
			sheetObj.SelectCell(Row, "exp_dt");
		}

		if (sheetObj.CellValue(Row, "eff_dt") > sheetObj.CellValue(Row, "exp_dt")) {
			ComShowCodeMessage("PRI00306");
			sheetObj.CellValue2(Row, "exp_dt") = expDt;
			sheetObj.SelectCell(Row, "exp_dt");
		}
		break;
		
	case "bkg_prc_cgo_tp_cd": 	
		var chgRuleDefCd = 	sheetObj.CellValue(Row, "chg_rule_def_cd");
		
		if(chgRuleDefCd == "APP"){
			if(Value != "DG") {
				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
				sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") = "";
			}
		}
		
		if(Value == "DG") {
			sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = true;
		} else {
			sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = false;
			sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
		}
		break;	
		
	case "rt_appl_tp_cd":
		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
		var rtOpCd = sheetObj.CellValue(Row, "rt_op_cd");

		if(Value == "A" || Value == "F") {
			sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
			sheetObj.CellValue2(Row, "curr_cd") 		= "USD";
			sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
			sheetObj.CellEditable(Row, "rt_op_cd")		= true;
			sheetObj.CellEditable(Row, "curr_cd")		= true;
			sheetObj.CellEditable(Row, "frt_rt_amt")	= true;
			} else {
				sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
				sheetObj.CellValue2(Row, "curr_cd") 		= "";
				sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
				sheetObj.CellEditable(Row, "rt_op_cd")		= false;
				sheetObj.CellEditable(Row, "curr_cd") 		= false;
				sheetObj.CellEditable(Row, "frt_rt_amt")	= false;
			}
			
			if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
				&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
				&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
				&& chgRuleDefCd != "RAC" ) {
	    		 					
				if( Value == "F") {
					sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
					sheetObj.CellEditable(Row, "rt_op_cd") 	= false;
				}
				
				if( Value == "A") {
					sheetObj.CellValue2(Row, "curr_cd") 	= "";
					sheetObj.CellEditable(Row, "curr_cd") 	= false;
				}
				
 		} else if(chgRuleDefCd == "ADD" || chgRuleDefCd == "ARB") {
 			if (Value == "I" || Value == "A"){ 	   
 				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
 				sheetObj.CellValue2(Row, "curr_cd") 	= "";
				sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
					
 				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 			} else if (Value == "S" || Value == "N"){
				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
				sheetObj.CellValue2(Row, "curr_cd") 	= "";
				sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
				} else {
				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= true;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
				sheetObj.CellValue2(Row, "curr_cd") 	= "USD";
				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
				sheetObj.CellValue2(Row, "frt_rt_amt") 	= "0";
				}
 		} else if(chgRuleDefCd == "NOT") {
 			if (Value != "I" && Value != "N"){ 	   
 				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "I";
 				sheetObj.CellValue2(Row, "rt_op_cd") 	= "";
				sheetObj.CellValue2(Row, "curr_cd") 	= "";
				sheetObj.CellValue2(Row, "frt_rt_amt") 	= "";
 				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 			}
 		} else if(chgRuleDefCd == "APP") {
 			if (Value != "S" && Value != "N"){ 	   
 				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "S";
 				sheetObj.CellValue2(Row, "rt_op_cd") 		= "";
				sheetObj.CellValue2(Row, "curr_cd") 		= "";
				sheetObj.CellValue2(Row, "frt_rt_amt") 		= "";
 				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
 			}
 		} else if(chgRuleDefCd == "TYP") {
 			
 			if (Value == "A"){ 	    	    				
 				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
 			} else if (Value == "N"){ 	    	    				
 				sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= false;
				sheetObj.CellValue2(Row, "curr_cd") 	= "";
 			} else {
 				ComShowCodeMessage("PRI00333", sheetObj.CellText(Row, Col));
 				sheetObj.CellEditable(Row, "rt_op_cd") 				= true;
				sheetObj.CellEditable(Row, "curr_cd") 				= false;
				sheetObj.CellEditable(Row, "frt_rt_amt") 			= true;
 				sheetObj.CellValue2(Row, "rt_appl_tp_cd") 	= "A";
 				sheetObj.CellValue2(Row, "curr_cd") 		= "";
 				sheetObj.CellValue2(Row, "rt_op_cd") 		= "+";
				sheetObj.CellValue2(Row, "frt_rt_amt") 		= "0";
 			}
 		}

		break;

	case "rt_op_cd":
		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
		var rtApplTpCd = sheetObj.CellValue(Row, "rt_appl_tp_cd");
		if (chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR"
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {

			if (rtApplTpCd == "F") {
				if (Value == ">" || Value == "<") {
					ComShowCodeMessage("PRI00326");
					sheetObj.CellValue2(Row, "rt_op_cd") = "+";
					sheetObj.SelectCell(Row, "rt_op_cd");
				}
			}
		} else if (chgRuleDefCd == "RAR") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.CellValue2(Row, "rt_op_cd") = "+";
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		} else if (chgRuleDefCd == "RAP") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.CellValue2(Row, "rt_op_cd") = "+";
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		} else if (chgRuleDefCd == "DOR") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.CellValue2(Row, "rt_op_cd") = "+";
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		} else if (chgRuleDefCd == "TYP") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.CellValue2(Row, "rt_op_cd") = "+";
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		}
		break;

	case "bkg_ts_port_def_cd":
		if (Value.length == 5) {
			formObj.f_cmd.value = COMMAND24;
			formObj.cd.value = Value;
			var sParam = FormQueryString(formObj);
			sParam += "&etc1=" + PRI_RP_SCP;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = arrData[0];
				sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "L";

				// T/S PORT에 데이터가 존재하면 DIRECT CALL 비활성화
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;

			} else {
				sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
				sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
				sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");
				sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
			}
		} else {
			sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
			sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");
			sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
		}

		//sheetObj.CellBackColor(Row, "bkg_ts_port_def_cd") = 0;
		break;

	case "bkg_dir_call_flg":
		if (Value == "Y") {
			sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = false;
		} else {
			sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;
		}
		break;
/*
	case "bkg_slan_cd":
		if (Value.length == 3) {
			formObj.f_cmd.value = COMMAND26;
			formObj.cd.value = Value;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bkg_slan_cd") = arrData[0];
			} else {
				sheetObj.CellValue2(Row, "bkg_slan_cd") = "";
				sheetObj.SelectCell(Row, "bkg_slan_cd");
			}
		} else {
			sheetObj.CellValue2(Row, "bkg_slan_cd") = "";
			sheetObj.SelectCell(Row, "bkg_slan_cd");
		}
		break;

	case "bkg_vvd_cd":
		if (Value.length == 9) {

			var vslCd = Value.substring(0, 4);
			var skdVoyNo = Value.substring(4, 8);
			var skdDirCd = Value.substring(8, 9);

			var sParam = "f_cmd=" + COMMAND27;
			sParam += "&cd=" + vslCd;
			sParam += "&etc1=" + skdVoyNo;
			sParam += "&etc2=" + skdDirCd;

			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bkg_vvd_cd") = arrData[0];
				sheetObj.CellValue2(Row, "bkg_vsl_cd") = vslCd;
				sheetObj.CellValue2(Row, "bkg_skd_voy_no") = skdVoyNo;
				sheetObj.CellValue2(Row, "bkg_skd_dir_cd") = skdDirCd;

			} else {
				sheetObj.CellValue2(Row, "bkg_vvd_cd") = "";
				sheetObj.CellValue2(Row, "bkg_vsl_cd") = "";
				sheetObj.CellValue2(Row, "bkg_skd_voy_no") = "";
				sheetObj.CellValue2(Row, "bkg_skd_dir_cd") = "";
				sheetObj.SelectCell(Row, "bkg_vvd_cd");

			}
		} else {
			sheetObj.CellValue2(Row, "bkg_vvd_cd") = "";
			sheetObj.CellValue2(Row, "bkg_vsl_cd") = "";
			sheetObj.CellValue2(Row, "bkg_skd_voy_no") = "";
			sheetObj.CellValue2(Row, "bkg_skd_dir_cd") = "";
			sheetObj.SelectCell(Row, "bkg_vvd_cd");

		}
		break;
*/
	case "bkg_imdg_clss_cd":
		if (Value.length > 0) {
			formObj.f_cmd.value = COMMAND30;
			formObj.cd.value = Value;
			var sParam = FormQueryString(formObj);
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var arrData = ComPriXml2ComboString(sXml, "cd", "nm");

			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = arrData[0];
			} else {
				sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
				sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");
			}
		} else {
			sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
			sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");
		}
		break;

	case "curr_cd":
		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
		if (chgRuleDefCd == "ARB" || chgRuleDefCd == "ADD") {
			if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK") {

				ComShowCodeMessage("PRI01074", "USD, EUR, GBP, INR, NOK");
				sheetObj.CellValue2(Row, "curr_cd") = "USD";
				sheetObj.SelectCell(Row, "curr_cd");
			}
		}
		break;
	}

}

/**
 * OnClick 이벤트 발생시 호출되는 function <br>
 * 달력 DIV를 호출한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
 * @return 없음
 * @author 최성민
 * @version 2009.06.18
 */
function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	var colname = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	var pinkColor = sheetObj.RgbColor(255, 192, 203);

	switch (colname) {
	case "eff_dt":
		cal = new ComCalendarGrid();
		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
		break;
	case "exp_dt":
		cal = new ComCalendarGrid();
		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
		break;

	case "bkg_ts_port_def_cd":
		var sUrl = "/hanjin/ESM_PRI_4026.do?";
		var sParam = "&location_cmd=L";

		var rtnVal = ComPriOpenWindowCenter(sUrl + sParam, "ESM_PRI_4026", 700, 325, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, Col) = rtnVal.cd;
			sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = rtnVal.tp;
		}
		break;
/*
	case "bkg_slan_cd":
		var sUrl = "/hanjin/ESM_PRI_4012.do?" + FormQueryString(document.form);

		var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_4012", 420, 370, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, Col) = rtnVal.toString();
		}
		break;

	case "bkg_vvd_cd":
		var sUrl = "/hanjin/ESM_PRI_4013.do?" + FormQueryString(document.form);

		var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_4013", 420, 370, true);
		if (rtnVal != null) {
			sheetObj.CellValue2(Row, Col) = rtnVal.toString();
			sheetObj.SelectCell(Row, Col);
		}
		break;
*/
	}

}

/**
 * Duration 의 Validation function <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return 없음
 * @author 최성민
 * @version 2009.07.15
 */
function checkDuration(sheetObj) {
	var formObj = document.form;
	var rowCount = getValidRowCount(sheetObj);
	var effDt = ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
	var expDt = ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
	if (rowCount > 0) {
		for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if (sheetObj.RowStatus(i) == "D") {
				continue;
			}
			
			//날짜가 역전되도 AUTORATING시 APP데이터가 필요하기 때문에 VALIDATION제외 
			if(sheetObj.CellValue(i, "chg_rule_def_cd") == "APP") {
				continue;
			}
			
			if (sheetObj.CellValue(i, "eff_dt") < effDt) {
				ComShowCodeMessage("PRI08016");
				sheetObj.CellValue2(i, "eff_dt") = effDt;
				sheetObj.SelectCell(i, "eff_dt");
				return false;
			}

			if (sheetObj.CellValue(i, "eff_dt") > sheetObj.CellValue(i, "exp_dt")) {
				ComShowCodeMessage("PRI00306");
				sheetObj.CellValue2(i, "eff_dt") = effDt;
				sheetObj.CellValue2(i, "exp_dt") = expDt;
				sheetObj.SelectCell(i, "eff_dt");
				return false;
			}

			if (sheetObj.CellValue(i, "exp_dt") > expDt) {
				ComShowCodeMessage("PRI08016");
				sheetObj.CellValue2(i, "exp_dt") = expDt;
				sheetObj.SelectCell(i, "exp_dt");
				return false;
			}
		}
	}

	return true;
}

/**
 * CODE항목 선택시 CODE값에 따라 수정가능한 항목을 체크하는 function <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *	disableColumnValidation(sheetObj, Row, Col, Value);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
 * @return 없음
 * @author 최성민
 * @version 2009.07.02
 */
function disableColumnValidation(sheetObj, Row, Col, Value) {

	initColumnEditable(sheetObj, Row, Col, Value);

	switch (Value) {
	case "APP":
		sheetObj.CellEditable(Row, "bkg_rat_ut_cd") = false;
		//sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") = false;
		sheetObj.CellEditable(Row, "rt_op_cd") = false;
		sheetObj.CellEditable(Row, "curr_cd") = false;
		sheetObj.CellEditable(Row, "frt_rt_amt") = false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;
		break;

	case "NOT":
		sheetObj.CellEditable(Row, "rt_op_cd") = false;
		sheetObj.CellEditable(Row, "curr_cd") = false;
		sheetObj.CellEditable(Row, "frt_rt_amt") = false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;
		break;

	case "RAS":

		sheetObj.CellEditable(Row, "rt_appl_tp_cd") = false;
		sheetObj.CellEditable(Row, "curr_cd") = false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;
		break;

	case "ARB":
		//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;

		if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "S" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "I" 
			|| sheetObj.CellValue(Row, "rt_appl_tp_cd") == "N") {

			sheetObj.CellEditable(Row, "rt_op_cd") = false;
			sheetObj.CellEditable(Row, "curr_cd") = false;
			sheetObj.CellEditable(Row, "frt_rt_amt") = false;
		} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
			sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
		} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
			sheetObj.CellEditable(Row, "curr_cd") 				= false;
		}
		break;

	case "ADD":
		//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;

		if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "S" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "I" 
			|| sheetObj.CellValue(Row, "rt_appl_tp_cd") == "N") {

			sheetObj.CellEditable(Row, "rt_op_cd") = false;
			sheetObj.CellEditable(Row, "curr_cd") = false;
			sheetObj.CellEditable(Row, "frt_rt_amt") = false;
		} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
			sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
		} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
			sheetObj.CellEditable(Row, "curr_cd") 				= false;
		}
		break;

	case "TYP":
		//sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
		sheetObj.CellEditable(Row, "curr_cd") = false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;
		break;

	case "RAR":
		sheetObj.CellEditable(Row, "rt_appl_tp_cd") = false;
		sheetObj.CellEditable(Row, "curr_cd") = false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;
		break;

	case "RAP":
		sheetObj.CellEditable(Row, "rt_appl_tp_cd") = false;
		sheetObj.CellEditable(Row, "curr_cd") = false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;
		break;

	case "DOR":
		sheetObj.CellEditable(Row, "rt_appl_tp_cd") = false;
		sheetObj.CellEditable(Row, "curr_cd") = false;
		sheetObj.CellEditable(Row, "pay_term_cd") = false;
		break;

	default: //SURCHARGE 												
		if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "S" 
			|| sheetObj.CellValue(Row, "rt_appl_tp_cd") == "I" 
			|| sheetObj.CellValue(Row, "rt_appl_tp_cd") == "N") {
			sheetObj.CellEditable(Row, "rt_op_cd") = false;
			sheetObj.CellEditable(Row, "curr_cd") = false;
			sheetObj.CellEditable(Row, "frt_rt_amt") = false;
		} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="F" ) {
			sheetObj.CellEditable(Row, "rt_op_cd") 				= false;
		} else if (sheetObj.CellValue(Row, "rt_appl_tp_cd")=="A" ) {
			sheetObj.CellEditable(Row, "curr_cd") 				= false;
		}
		break;
	}
}

/**
 * SHEET에 보이는 항목들을 EDITABLE 초기화하는 function <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *	initColumnEditable(sheetObj, Row, Col, Value);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
 * @return 없음
 * @author 최성민
 * @version 2009.07.02
 */
function initColumnEditable(sheetObj, Row, Col, Value) {
	sheetObj.CellEditable(Row, "rt_appl_tp_cd") = true;
	sheetObj.CellEditable(Row, "bkg_rat_ut_cd") = true;
	sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") = true;

	if (sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = true;
	} else {
		sheetObj.CellEditable(Row, "bkg_imdg_clss_cd") = false;
	}
	sheetObj.CellEditable(Row, "rt_op_cd") = true;
	sheetObj.CellEditable(Row, "curr_cd") = true;
	sheetObj.CellEditable(Row, "frt_rt_amt") = true;
	sheetObj.CellEditable(Row, "pay_term_cd") = true;
	sheetObj.CellEditable(Row, "bkg_soc_flg") = true;
	sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;

	if (sheetObj.CellValue(Row, "bkg_ts_port_def_cd") != "") {
		sheetObj.CellEditable(Row, "bkg_dir_call_flg") = false;
	} else {
		sheetObj.CellEditable(Row, "bkg_dir_call_flg") = true;
	}

	if (sheetObj.CellValue(Row, "bkg_dir_call_flg") == "Y") {
		sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = false;
	} else {
		sheetObj.CellEditable(Row, "bkg_ts_port_def_cd") = true;
	}
}

/**
 * CODE항목 선택시 CODE TYPE에 따라 필수 컬럼을 체크하는 function <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *	checkMandatoryValidation(sheetObj, Row);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @return 없음
 * @author 최성민
 * @version 2009.07.02
 */
function checkMandatoryValidation(sheetObj, Row) {
	var rowCount = sheetObj.RowCount;
	var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");

	if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
			&& chgRuleDefCd != "RAC" ) {
			
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001 && (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F")) {
				//Application 이 Fixed Amount, Adjust 로 지정될 경우는 Amount 가 필수입력항목 지정.(7/21)
	 			ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") { 			
	 			// SURCHARGE CODE 입력시, APPLICATION이 FIXED AMOUNT 또는 ADJUST 일 경우
	 			// BKG SOURCE부분의 PER를 필수 입력 항목 변경 요청 - 2009.11.09
				if (sheetObj.CellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
			}
		} else if (chgRuleDefCd == "APP") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} 
		} else if (chgRuleDefCd == "NOT") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			}  			
		} else if (chgRuleDefCd == "RAS") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") < 0.001) {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} 
		} else if (chgRuleDefCd == "ARB") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			}
		} else if (chgRuleDefCd == "ADD") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} 
		} else if (chgRuleDefCd == "TYP") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "" && sheetObj.CellValue(Row, "rt_appl_tp_cd") == "A") {
				//TYP|RAR|RAC|RAP|DOR은 0값을 허용
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_rat_ut_cd") == "") {
				ComShowCodeMessage("PRI00316","Per");
				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "rule_appl_chg_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Type");
				sheetObj.SelectCell(Row, "rule_appl_chg_tp_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "conv_rat_ut_cd") == "") { 
				ComShowCodeMessage("PRI00316","Per (in S/C)"); 
				sheetObj.SelectCell(Row, "conv_rat_ut_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAR") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
				//TYP|RAR|RAC|RAP|DOR은 0값을 허용
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_por_def_cd") == "" && sheetObj.CellValue(Row, "bkg_pol_def_cd") == "" 
				 && sheetObj.CellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.CellValue(Row, "bkg_del_def_cd") == "") {
				//POR, POL,POD,DEL중 1개이상 입력 				 				
				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
				sheetObj.SelectCell(Row, "bkg_por_def_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "conv_org_loc_def_cd") == "" && sheetObj.CellValue(Row, "conv_org_via_loc_def_cd") == "" 
				 && sheetObj.CellValue(Row, "conv_dest_via_loc_def_cd") == "" && sheetObj.CellValue(Row, "conv_dest_loc_def_cd") == "") {
				//Origin , Origin Via,Dest Via, Dest 중  1개이상 입력 				 				
				ComShowCodeMessage("PRI01052","Origin, Origin Via, Dest Via, Dest");
				sheetObj.SelectCell(Row, "conv_org_loc_def_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAP") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
				//TYP|RAR|RAC|RAP|DOR은 0값을 허용
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_cmdt_def_cd") == "" && sheetObj.CellValue(Row, "bkg_scg_grp_cmdt_cd") == "") {
				ComShowCodeMessage("PRI00334","Commodity","GRI Commodity");
				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "conv_cmdt_def_cd") == "") {
				ComShowCodeMessage("PRI00316","Commodity (in S/C)");
				sheetObj.SelectCell(Row, "conv_cmdt_def_cd");
				return false;
			}
		} else if (chgRuleDefCd == "DOR") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
				//TYP|RAR|RAC|RAP|DOR은 0값을 허용
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_rcv_term_cd") == "" && sheetObj.CellValue(Row, "bkg_de_term_cd") == "") {
				ComShowCodeMessage("PRI00334","Receiving Term","Delivery Term");
				sheetObj.SelectCell(Row, "bkg_rcv_term_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "conv_prc_rcv_term_cd") == "" && sheetObj.CellValue(Row, "conv_prc_de_term_cd") == "") {
				ComShowCodeMessage("PRI00334","Receiving Term (in S/C)","Delivery Term (in S/C)");
				sheetObj.SelectCell(Row, "conv_prc_rcv_term_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAC") {
			if(sheetObj.CellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.CellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Cargo Type");
				sheetObj.SelectCell(Row, "bkg_prc_cgo_tp_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.CellValue(Row, "frt_rt_amt") == "") {
				//TYP|RAR|RAC|RAP|DOR은 0값을 허용
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.CellValue(Row, "conv_prc_cgo_tp_cd") == "") { 
				ComShowCodeMessage("PRI00316","Cargo Type (in S/C)"); 
				sheetObj.SelectCell(Row, "conv_prc_cgo_tp_cd");
				return false;
			}
		}
		
	return true;
}

/**
 * CODE항목 선택시 CODE TYPE에 따라 컬럼항목 DEFAULT 처리하는 function <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *	defaultColumnValidation(sheetObj, Row, Col, Value);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
 * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
 * @return 없음
 * @author 최성민
 * @version 2009.07.02
 */
function defaultColumnValidation(sheetObj, Row, Col, Value) {

	initColumnValue(sheetObj, Row);

	switch (Value) {
	case "TYP":
		sheetObj.CellValue2(Row, "curr_cd") = "";
		sheetObj.CellValue2(Row, "bkg_rat_ut_cd") = "D4";
		sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		sheetObj.CellValue2(Row, "rt_appl_tp_cd") = "A";
		break;

	case "NOT":
		sheetObj.CellValue2(Row, "rt_appl_tp_cd") = "I";
		break;

	case "RAS":
		sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		sheetObj.CellValue2(Row, "frt_rt_amt") = "0";	
		break;

	case "RAR":
		sheetObj.CellValue2(Row, "curr_cd") = "";
		sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		break;

	case "RAP":
		sheetObj.CellValue2(Row, "curr_cd") = "";
		sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		break;

	case "DOR":
		sheetObj.CellValue2(Row, "curr_cd") = "";
		sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		break;

	case "ARB":
		sheetObj.CellValue2(Row, "rt_appl_tp_cd") = "S";
		// sheetObj.CellValue2(Row, "curr_cd") = "USD";
		// sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		// sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		break;

	case "ADD":
		sheetObj.CellValue2(Row, "rt_appl_tp_cd") = "S";
		// sheetObj.CellValue2(Row, "curr_cd") = "USD";
		// sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		// sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		break;

	default:
		sheetObj.CellValue2(Row, "rt_appl_tp_cd") = "S";
		break;

	}
}

/**
 * 데이터를 초기화하는 function <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *	initColumnValue(sheetObj, Row);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @return 없음
 * @author 최성민
 * @version 2009.07.02
 */
function initColumnValue(sheetObj, Row) {

	sheetObj.CellValue2(Row, "rt_appl_tp_cd") = "";
	sheetObj.CellValue2(Row, "rt_op_cd") = "";
	sheetObj.CellValue2(Row, "curr_cd") = "";
	sheetObj.CellValue2(Row, "frt_rt_amt") = "";
	sheetObj.CellValue2(Row, "pay_term_cd") = "";
	sheetObj.CellValue2(Row, "bkg_rat_ut_cd") = "";
	sheetObj.CellValue2(Row, "bkg_prc_cgo_tp_cd") = "";
	sheetObj.CellValue2(Row, "bkg_imdg_clss_cd") = "";
	sheetObj.CellValue2(Row, "bkg_soc_flg") = "";
	sheetObj.CellValue2(Row, "bkg_ts_port_tp_cd") = "";
	sheetObj.CellValue2(Row, "bkg_ts_port_def_cd") = "";
	sheetObj.CellValue2(Row, "bkg_dir_call_flg") = "";

	//sheetObj.CellValue2(Row, "bkg_vvd_cd") = "";
}

	
/**
 * SHEET ROW를 멀티 복사하는 function <br>
 * 
 * <br><b>Example :</b>
 * <pre>
 *	copySheetData(sheetObj);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @return 없음
 * @author 최성민
 * @version 2010.03.23
 */	
function copySheetData(sheetObj) {

	//SHEET를 LOAD한 후에 기본 값을 세팅한다.
	var maxSeq = parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
	var sCheckRow = sheetObj.FindCheckedRow("chk");
	if(sCheckRow == ""){
		sheetObj.CellValue2(sheetObj.SelectRow,"chk")= "1";
	}
	sCheckRow = sheetObj.FindCheckedRow("chk");	

	var aCheckArr = ComRtrim(sCheckRow, '|').split("|");
	
	if(aCheckArr != null && aCheckArr.length > 0) {
		for(var i=aCheckArr.length-1; i>=0; i--) {
			sheetObj.SelectRow = aCheckArr[i];
			var idx = sheetObj.DataCopy();
			sheetObj.CellValue2(idx, "note_conv_seq") 	= maxSeq;      	
			sheetObj.CellValue2(idx, "chk") = 0;

  			// Rule & Charge Code 색 구분
  			//setChargeRuleColor(sheetObj, idx);
			maxSeq++;
		}
	}
}

/**
 * CODE COMBO 선택시 CHARGE RULE TYPE에 따라 데이터를 분기하는 function <br>
 * RULE코드를 선택하면 CHG_RULE_TP_CD:C 이고 NOTE_CONV_RULE_CD에 코드값등록  <br>
 * CHARGE코드를 선택하면 CHG_RULE_TP_CD:R 이고 NOTE_CONV_CHG_CD에 코드값등록  <br>
 * <br><b>Example :</b>
 * <pre>
 *	insertChargeRuleType(sheetObj);
 * </pre>
 * @param {ibsheet} sheetObj 필수 IBSheet Object
 * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
 * @return 없음
 * @author 최성민
 * @version 2009.07.02
 */
function insertChargeRuleType(sheetObj, Row) {
	var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");

	if (chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
		&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
		&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {

		//CHARGE
		sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "C";
		sheetObj.CellValue2(Row, "note_conv_chg_cd") = chgRuleDefCd;
		sheetObj.CellValue2(Row, "note_conv_rule_cd") = "";
	} else {
		//RULE
		sheetObj.CellValue2(Row, "chg_rule_tp_cd") = "R";
		sheetObj.CellValue2(Row, "note_conv_rule_cd") = chgRuleDefCd;
		sheetObj.CellValue2(Row, "note_conv_chg_cd") = "";
	}
}

	/**
	 * Code 가 Rule Code 일 경우에는 색상을 지정하는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * setChargeRuleColor(sheetObj, Row);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 IBSheet Object 의 Row Index
	 * @return 없음
	 * @author 최성민
	 * @version 2009.07.09
	 */ 
	function setChargeRuleColor(sheetObj, Row) {
		// Rule & Charge Code 색 구분
		var sCodeColor = sheetObj.RgbColor(255,200,200);
		var chgRuleDefCd = sheetObj.CellValue(Row, "chg_rule_def_cd");
 		
		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
			&& chgRuleDefCd != "RAC" ) {
			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = 0;
		} else {
			sheetObj.CellBackColor(Row,"chg_rule_def_cd") = sCodeColor;
		} 
	}
	
 
	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 박성수
	 * @version 2009.05.01
	 */
 function toggleButtons(mode) {
 	var formObj = document.form;
     switch (mode) {
	     case "Y":	    	
	    	 ComBtnEnable("btn_copy");
	    	 ComBtnEnable("btn_paste");
	    	 ComBtnEnable("btn_rowadd");
	    	 ComBtnEnable("btn_rowcopy");
	    	 ComBtnEnable("btn_delete");
	    	 ComBtnEnable("btn_ok");
	    	 ComBtnEnable("btn_close");
	    	 
	    	 sheetObjects[0].Editable = true;
	    	 
	    	 formObj.note_ctnt.readOnly = false;
	         break;
	         
	     case "N":
	    	 ComBtnDisable("btn_copy");
	    	 ComBtnDisable("btn_paste");
	    	 ComBtnDisable("btn_rowadd");
	    	 ComBtnDisable("btn_rowcopy");
	    	 ComBtnDisable("btn_delete");
	    	 ComBtnDisable("btn_ok");
	    	 ComBtnEnable("btn_close");
	    	 
	    	 sheetObjects[0].Editable = false;
	    	 
	    	 formObj.note_ctnt.readOnly = true;
	         break;
	         
	         
	     case "M":
	    	 //if (bIsAproUsr && sheetObj.CellValue(Row, "prop_sts_cd") == "Q") 일경우
	    	 //승인권자이면서 STATUS가 REQUEST일경우에는 NOTE_CTNT만 수정할수 있다.
	    	 ComBtnDisable("btn_copy");
	    	 ComBtnDisable("btn_paste");
	    	 ComBtnDisable("btn_rowadd");
	    	 ComBtnDisable("btn_rowcopy");
	    	 ComBtnDisable("btn_delete");
	    	 ComBtnEnable("btn_ok");
	    	 ComBtnEnable("btn_close");
	    	 
	    	 sheetObjects[0].Editable = false;
	    	 
	    	 formObj.note_ctnt.readOnly = false;
	         break;
     }
       
 }

/* 개발자 작업  끝 */