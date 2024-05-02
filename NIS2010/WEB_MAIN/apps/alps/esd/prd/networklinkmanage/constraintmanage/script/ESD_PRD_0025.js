/*=========================================================
 *SM Lines(c) 2018 SM Lines
 *@FileName : ESD_PRD_0025.js
 *@FileTitle : Exception Customer Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 *===============================================================================
 History
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
 * @class ESM_SPC_0121 : esm_spc_0115 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_PRD_0025() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var opener = window.dialogArguments;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
			
		case "btn_add":
			sheetObject.DataInsert(-1);
			break;
			
		case "btn_close":
			fn_rtnExcep(sheetObject);
			window.close();
			break;
			
		case "btn_save":
			doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;			
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	
	var p_expt = formObj.cnst_cst_expt.value;
	if(p_expt == "Y") {
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}	
}
/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 */
function initControl() {
	axon_event.addListenerFormat('keypress', 'form1_keypress', form); //Key Press
}
/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}
/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}
/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur() {
}
/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus() {
	//            ComClearSeparator(event.srcElement);
}
/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function form1_keypress() {
	switch (event.srcElement.dataformat) {
	case "engupnum":
		ComKeyOnlyAlphabet("uppernum");
		break;
	}
}
/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: //sheet1 init
		with (sheetObj) {
			//높이 설정
			style.height = GetSheetHeight(10);
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly; //msAll / msPrevColumnMerge / msHeaderOnly
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 9, 100);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false);			
			var HeadTitle1 = "Del|STS|Expt Type|Number|Remark|Valid|Expt Key";
			var headCount = ComCountHeadTitle(HeadTitle1);
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,			KEYFIELD, 	CALCULOGIC,	DATAFORMAT,		POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDelCheck ,  40,    daCenter,  true,    "chk",                 false,  "", dfNone, 0, true, true, -1,  false, true,  "", true);
			InitDataProperty(0, cnt++, dtStatus,     30,    daCenter,  true,    "ibflag");
			InitDataProperty(0, cnt++, dtCombo,      80,    daCenter,  true,    "cnst_expt_tp_cd",     false,  "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData,       100,   daLeft,    true,    "cnst_expt_no",        false,  "", dfNone, 0, true, true,  20, false, false, "", false);
			InitDataProperty(0, cnt++, dtData,       100,   daLeft,    true,    "cnst_expt_rmk",       false,  "", dfNone, 0, true, true,  100,false, false, "", false);
			InitDataProperty(0, cnt++, dtHidden,     100,   daCenter,  true,    "cnst_expt_valid",     false,  "", dfNone, 0, true, true,  20, false, false, "", false);
			InitDataProperty(0, cnt++, dtHidden,     100,   daCenter,  true,    "cnst_expt_seq",       false,  "", dfNone, 0, true, true,  20, false, false, "", false);
			
			InitDataCombo(0, 'cnst_expt_tp_cd', cnst_expt_tp_cdText, cnst_expt_tp_cdCode);
	}
		break;
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	sheetObj.ShowDebugMsg = false;

	switch (sAction) {
	case IBSEARCH:      //조회   
		formObj.f_cmd.value = SEARCH;
    	var param = FormQueryString(formObj);		
		sheetObj.DoSearch4Post("ESD_PRD_0025GS.do", param);		
		break;
		
	case IBSAVE:
		if (validateChk(sheetObj, sAction)) {
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("ESD_PRD_0025GS.do", PrdFQString(formObj));
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		break;
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObject = document.form;
	var colName = sheetObj.ColSaveName(Col);
	var data_type = sheetObj.ReadDataProperty(Row, Col, 0);
	if (data_type == dtData) {
		sheetObj.CellValue2(Row, Col) = sheetObj.CellValue(Row, Col).toUpperCase();
	}
}
/**
 * 조회 후에 이벤트 
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
}


function fn_rtnExcep(sheetObject) {
	var org_sheet = opener.sheetObjects[0];
	var chk_data = 0;
	
	if(sheetObject.RowCount > 0) {
		for (var i = 0 ; i < sheetObject.Rows ; i++) {
			if (sheetObject.CellValue(i, "ibflag") == "R" || sheetObject.CellValue(i, "ibflag") == "U" || sheetObject.CellValue(i, "ibflag") == "D") {
				chk_data = chk_data+1;
			}
		}
	} else {
		chk_data = 0;
	}
	
	if(chk_data >= 1) {
		org_sheet.CellValue2(org_sheet.SelectRow, "s_cnst_cst_expt") = 'Y';
	}else {
		org_sheet.CellValue2(org_sheet.SelectRow, "s_cnst_cst_expt") = '';
	}
}


function validateChk(sheetObject, sAction) {
	var rtnVal = true;
	var chkCnt = 0;
	var chkRow = 0;
	
	switch (sAction) {
		case IBSAVE:
			for (var i = 1 ; i < sheetObject.Rows ; i++) {
				if (ComTrim(sheetObject.CellValue(i, "cnst_expt_no")) == "") {
					chkCnt = chkCnt+1;
					chkRow = i;
				}
			}
	}
	
	if(chkCnt >= 1) {
		ComShowMessage(ComGetMsg('PRD90108'));
		sheetObject.SelectCell(chkRow, "cnst_expt_no");
		rtnVal =  false;
	}
	
	return rtnVal;
}

function fn_unload() {
    fn_rtnExcep(sheetObjects[0]);
}

