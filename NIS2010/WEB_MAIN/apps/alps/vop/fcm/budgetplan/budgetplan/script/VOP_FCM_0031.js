/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0031.js
 *@FileTitle : Budget & Rolling Plan Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.10.04
 *@LastModifier : 유혁
 *@LastVersion : 1.0
 * 2011.10.04 유혁
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
 * @class VOP_FCM_0031 : VOP_FCM_0031 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0031() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */

	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_New":		//조회조건 초기화
			sheetObject.RemoveAll();
			formObject.reset();
			break;
		case "btn_Standard":
			var sUrl = "/hanjin/VOP_FCM_0032.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 1015, 650, "", "0,0", true);
			if (rVal) {
				//formObject.crr_cd.value = rVal;
			}
			break;
		case "btn2_Expand":
			ColHiddenObject(false);			
			break;
		case "btn2_Reduction":
			ColHiddenObject(true);			
			break;				
		case "btns_calendarsn":
			var cal = new ComCalendar();
			cal.setDisplayType('year');
			cal.select(formObject.sn_dt, 'yyyy');
			break;				
		case "btns_calendarfm":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.fm_dt, 'yyyy-MM');
			break;	
		case "btns_calendarto":
			var cal = new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.to_dt, 'yyyy-MM');
			break;
		case "btn2_Down_Excel":
			doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
 * IBSheet Object 컬럼의 숨기여부를 설정하거나 확인한다.
 */
function ColHiddenObject(hidden) {
    var objs = document.all.item("btnLayer");

    if(hidden) {
		objs[0].style.display = "Inline";
		objs[1].style.display = "none";
    } else {
		objs[0].style.display = "none";
		objs[1].style.display = "Inline";
    }
	
	var sColStr = sheetObjects[0].GetSelectionCols("|");
	var headCount = sColStr.split("|");

	for(var i = 0; i < headCount.length; i++) {
		if( i >= 19) {
			sheetObjects[0].ColHidden(i) = hidden;
		}
	}

}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {

		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		ComEndConfigSheet(sheetObjects[i]);
	}

	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	
	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet} sheetObj IBSheet Object
 * @param {int} sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
	var formObj = document.form;

	// Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerForm("keypress",		 "obj_keypress",	  formObj);
	axon_event.addListenerForm("focus", "obj_activate", formObj);
	axon_event.addListener('keyup', 'obj_keyup', 'vsl_cd', 'crr_cd');
	axon_event.addListenerForm("focusout", "obj_focusout", formObj);
	

}

/**
 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}


/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */ 
function initCombo(comboObj, comboNo) {
    var formObj = document.form;
    switch(comboObj.id) {
    	case "sn_cd":
    		with (comboObj) { 
				MultiSelect = false;
				DropHeight = 320;
				InsertItem(0, 'BP','BP');
				InsertItem(1, 'PR','PR');
				InsertItem(2, 'Q1','Q1');
				InsertItem(3, 'Q2','Q2');
				InsertItem(4, 'Q3','Q3');
				InsertItem(5, 'Q4','Q4');
				UseAutoComplete = true;
				ValidChar(2, 0);
				MaxLength = 2;
			}
			break;
     }
}
function obj_activate() {
	ComClearSeparator(event.srcElement);
	if (event.srcElement.options) {
		event.srcElement.focus();
	} else {
		event.srcElement.select();
	}
	
}

// 업무 자바스크립트 OnFocusOut 이벤트 처리
function obj_focusout() {
	 var form = document.form;
	 
	switch(event.srcElement.name){ 
	case "fm_dt":
		 var vFm_dt = form.fm_dt.value
		 form.fm_dt.value = vFm_dt.substring(0,4)+'-'+vFm_dt.substring(4,6);
 		break;
	case "to_dt":
		 var vTo_dt = form.to_dt.value
		 form.to_dt.value = vTo_dt.substring(0,4)+'-'+vTo_dt.substring(4,6);
		break; 		
	case "sn_dt":
		if(form.sn_dt.value.length == 4){
			form.fm_dt.value = form.sn_dt.value + "-01";
			form.to_dt.value = form.sn_dt.value + "-12";
		}
		break;
	}
} 

function obj_keyup() {
	var formObj = document.form;
	var obj = event.srcElement;
	var val = obj.value;
	
	switch (event.srcElement.name) {
	case "vsl_cd":
		if (val == "") {
			formObj.vsl_eng_nm.value = "";
			formObj.tmp_vsl_cd.value = "";
		}

		if (!obj || val == "" || ComChkLen(val, 4) != 2) {
			break;
		}
		if (formObj.tmp_vsl_cd.value != obj.value) {
			sheetObj = sheetObjects[0];
			//doActionIBSheet(sheetObj, formObj, SEARCH01);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
		break;

	case "crr_cd":
		if (val == "") {
			formObj.tmp_crr_cd.value = "";
		}

		if (!obj || val == "" || ComChkLen(val, 3) != 2) {
			break;
		}
		if (formObj.tmp_crr_cd.value != obj.value) {
			sheetObj = sheetObjects[0];
			doActionIBSheet(sheetObj, formObj, SEARCH02);
			obj.focus();
		}
		break;
	}
}

function obj_keypress() {
	switch(event.srcElement.name){
		case "sn_dt":
			ComKeyOnlyAlphabet("uppernum");
			break;
		case "sn_cd":
			ComKeyOnlyAlphabet("uppernum");
			break;
		case "fm_dt":
			ComKeyOnlyAlphabet("uppernum");
			break;
		case "to_dt":
			ComKeyOnlyAlphabet("uppernum");
			ComKeyOnlyNumber();
			break;
		case "status":
			ComKeyOnlyAlphabet("upper");
			break;		
		case "bk_price":
			ComKeyOnlyAlphabet("uppernum");
			break;
		case "bk_fo":
			ComKeyOnlyAlphabet("uppernum");
			break;
		case "bk_do":
			ComKeyOnlyAlphabet("uppernum");
			break;
		
	}

}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init [Departure Report]
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 410;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(3, 1, 3, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle = "SEQ|Scenario\nCD|Rev.\nMonth|Rev.\nLane|Week|Trade|Sub\nTrade|Vsl\nCD|Voyage\nNo.|Dir\nCD|Design\nCapacity|Carrier\nCD|P/F SKD\nType|Trend Line\nType|Start/End Port|Start/End Port|Port\nDays|Sea\nDays|Maneuv\nDays|Creation\nID|Creation\nDate|FO|FO|FO|FO|FO|DO|DO|DO|DO|DO|Total";
			var HeadTitle2 = "SEQ|Scenario\nCD|Rev.\nMonth|Rev.\nLane|Week|Trade|Sub\nTrade|Vsl\nCD|Voyage\nNo.|Dir\nCD|Design\nCapacity|Carrier\nCD|P/F SKD\nType|Trend Line\nType|Start|End|Port\nDays|Sea\nDays|Maneuv\nDays|Creation\nID|Creation\nDate|Ton|Ton|Ton|Unit Cost|AMT|Ton|Ton|Ton|Unit Cost|AMT|Total";
			var HeadTitle3 = "SEQ|Scenario\nCD|Rev.\nMonth|Rev.\nLane|Week|Trade|Sub\nTrade|Vsl\nCD|Voyage\nNo.|Dir\nCD|Design\nCapacity|Carrier\nCD|P/F SKD\nType|Trend Line\nType|Start|End|Port\nDays|Sea\nDays|Maneuv\nDays|Creation\nID|Creation\nDate|Port|Sea|MANEUV|Unit Cost|AMT|Port|Sea|MANEUV|Unit Cost|AMT|Total";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			sheetObj.FrozenCols = 4;

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtDataSeq,		60,			daCenter,	true,	"seq",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"bud_scnr_no",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"bud_yrmon",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"rlane_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,	"bud_wk",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"trd_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,	"sub_trd_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,	"vsl_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,			daCenter,	true,	"skd_voy_no",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			30,			daCenter,	true,	"skd_dir_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"cntr_vsl_clss_capa",		false,	"",			dfInteger,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"crr_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"pf_skd_tp_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtPopup,		80,			daCenter,	true,	"trnd_line_tp_cd",		false,	"",			dfNone,			0,			true,		true);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"st_port_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"end_port_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	"port_dys",		false,	"",			 dfDateYmd,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	"sea_dys",		false,	"",			 dfDateYmd,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	"mnvr_dys",		false,	"",			 dfDateYmd,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daCenter,	true,	"cre_usr_id",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,	"cre_dt",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"foil_port_csm_wgt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"foil_sea_csm_wgt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"foil_mnvr_csm_wgt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"foil_uc_amt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,			daRight,	true,	"foil_csm_cost_amt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"doil_port_csm_wgt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"doil_sea_csm_wgt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"doil_mnvr_csm_wgt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,			daRight,	true,	"doil_uc_amt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,			daRight,	true,	"doil_csm_cost_amt",		false,	"",			dfNullFloat,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,			daRight,	true,	"ttl_csm_amt",		false,	"",			dfNullFloat,			0,			false,		false);
			
			ImageList(0) = "img/btns_search.gif";
            PopupButtonImage(0,"trnd_line_tp_cd") = 0;	
            ShowButtonImage = 2;
		}
		ColHiddenObject(true);
		break;
		
	}
}

/**
 * Program Name Data List OpenWindow. <br>
 * @param {int}	Row	행번호
 * @param {int}	Col	컬럼번호
 **/
function sheet1_OnPopupClick(sheetObj,Row,Col){
    switch (sheetObj.ColSaveName(Col)) {
   		case "trnd_line_tp_cd" :
   				var url = '/hanjin/VOP_FCM_0014.do';
   				ComOpenPopup(url, 950, 650, 'setTrndLineTpCd', '0,0', false, false, Row, Col, 0);
   			break;
    }
}

function setTrndLineTpCd(aryPopupData, row, col, sheetIdx){
	var sheetObject = sheetObjects[0];
	sheetObject.CellValue(row,col)= aryPopupData[0][14];
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	switch (sAction) {
		case IBSEARCH: // 조회
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var rXml = sheetObj.DoSearch("VOP_FCM_0031GS.do",
						FormQueryString(formObj));
				
				var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
				var sColStr = sheetObj.GetSelectionCols("|");
				var headCount = sColStr.split("|");
	
				for(var i = 0; i < headCount.length; i++) {
					if( i < 19) {
						//if(!( i == 12 || i == 13 )){
							sheetObj.ColBackColor(i) = grayColor;
						//}
					}
				}
				ColHiddenObject(true);
				
				ComOpenWait(false);
			}
			break;
		case IBDOWNEXCEL:      
			sheetObj.SpeedDown2Excel(true);
			break;		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	var vsl_cd = formObj.vsl_cd;
	var vsl_eng_nm = formObj.vsl_eng_nm;
	var crr_cd = formObj.crr_cd;
	var sn_dt = formObj.sn_dt;
	var sn_cd = formObj.sn_cd;
	var fm_dt = formObj.fm_dt;
	var to_dt = formObj.to_dt;

	with (formObj) {
/*		if (ComChkLen(vsl_cd, 2) == 1 && ComChkLen(vsl_eng_nm, 2) == 1
				&& ComChkLen(crr_cd, 2) == 1 && ComChkLen(call_sgn_no, 2) == 1
				&& ComChkLen(lloyd_no, 2) == 1) {
			ComShowCodeMessage('VSK00022', "2", "vessel code");
			return false;
		}*/
		if (ComIsNull(sn_dt) || ComIsNull(sn_cd.Code) || ComIsNull(fm_dt) || ComIsNull(to_dt)) {
			return false;
		}
	}

	return true;
}

/* 개발자 작업 끝 */