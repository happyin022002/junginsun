/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : VOP_FCM_0053.js
 *@FileTitle : Trend Line Set up(Pop-Up)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 진마리아
 *@LastVersion : 1.0
 * 2011.10.04 유혁
 * 1.0 Creation
 * 
 * History
 * 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
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
 * @class VOP_FCM_0053 : VOP_FCM_0053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_FCM_0053() {
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
var ipageNo = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var selectVal;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObj = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

// case "btn_Retrieve":
// doActionIBSheet(sheetObj, formObj, IBSEARCH);
// break;
//
// case "btn_New":
// sheetObj.RemoveAll();
// formObj.reset();
// break;
//
// case "btns_calendar2":
// var cal = new ComCalendarFromTo();
// cal.select(formObj.trnd_line_fm_dt, formObj.trnd_line_to_dt,
// 'yyyy-MM-dd');
// break;

		case "btn_Close":
			self.close();
			break;

		case "btn_OK":
			doOK(sheetObj);
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
 * btn_OK 및 sheet 더블클릭시 호출
 * 
 * 
 */
function doOK(sheetObj) {
	if (sheetObj.RowCount == 0) {
		self.close();
	} else {
		var checkedRow = sheetObj.CheckedRows("checkbox");
		if(checkedRow!=sheetObj.RowCount){
			ComShowMessage("Please select Trend Line");
			return false;
		}
		comPopupOK();
	}
}
/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;

}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {

		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	
	setupTrendLine();
}

function setupTrendLine(){
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var parentObj = getParent(0);
	var prefix 	= "sheet1_";
	var classCount = 0;
	
	formObj.vsl_slan_cd.value = parentObj.CellValue(1,prefix+"vsl_slan_cd");
	formObj.pf_svc_tp_cd.value = parentObj.CellValue(1,prefix+"pf_svc_tp_cd");
	formObj.svc_dur_dys.value = parentObj.CellValue(1,prefix+"svc_dur_dys");
	formObj.brth_itval_dys.value = parentObj.CellValue(1,prefix+"brth_itval_dys");
	formObj.n1st_vsl_clss_cd.value 	= parentObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
	
	classCount = parentObj.CellValue(1,prefix+"n1st_vsl_clss_knt");	 
	if (classCount == 0) {	 
		formObj.n1st_vsl_clss_knt.value = "";
	}else {
		formObj.n1st_vsl_clss_knt.value = classCount;
		sheetObj.DataInsert(-1);
		sheetObj.CellValue2(2, sheetObj.prefix+"cntr_dzn_capa")=parentObj.CellValue(1,prefix+"n1st_vsl_clss_cd");
		sheetObj.CellValue2(2, sheetObj.prefix+"vsl_slan_cd")=formObj.vsl_slan_cd.value
	}

	formObj.n2nd_vsl_clss_cd.value = parentObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");	
	classCount = parentObj.CellValue(1,prefix+"n2nd_vsl_clss_knt");	 
	if (classCount == 0) {	 
		formObj.n2nd_vsl_clss_knt.value = "";
	}else {
		formObj.n2nd_vsl_clss_knt.value = classCount;
		sheetObj.DataInsert(-1)
		sheetObj.CellValue2(3, sheetObj.prefix+"cntr_dzn_capa")=parentObj.CellValue(1,prefix+"n2nd_vsl_clss_cd");
		sheetObj.CellValue2(3, sheetObj.prefix+"vsl_slan_cd")=formObj.vsl_slan_cd.value
	}

	formObj.n3rd_vsl_clss_cd.value 	= parentObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
	classCount = parentObj.CellValue(1,prefix+"n3rd_vsl_clss_knt");
	if (classCount == 0) {	 
		formObj.n3rd_vsl_clss_knt.value = "";
	}else {
		formObj.n3rd_vsl_clss_knt.value = classCount;
		sheetObj.DataInsert(-1)
		sheetObj.CellValue2(4, sheetObj.prefix+"cntr_dzn_capa")=parentObj.CellValue(1,prefix+"n3rd_vsl_clss_cd");
		sheetObj.CellValue2(4, sheetObj.prefix+"vsl_slan_cd")=formObj.vsl_slan_cd.value
	}
	
	// 부모창의 셋업정보를 복사
	var parentSetupObj = getParent(6);
	var sRow = parentSetupObj.HeaderRows;
	var eRow = sRow + parentSetupObj.RowCount;
	var sRow2 = sheetObj.HeaderRows;
	var parentFormObj = window.dialogArguments.form;
	
	for(var i=sRow; i<eRow; i++, sRow2++){
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"vsl_slan_cd"      ) = parentSetupObj.CellValue(i, parentSetupObj.prefix+"vsl_slan_cd"      );
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"trnd_line_no" ) = parentSetupObj.CellValue(i, parentSetupObj.prefix+"trnd_line_no" );
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"trnd_line_rmk"    ) = parentSetupObj.CellValue(i, parentSetupObj.prefix+"trnd_line_rmk"    );
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"trnd_line_seq"    ) = parentSetupObj.CellValue(i, parentSetupObj.prefix+"trnd_line_seq"    );
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"n1st_coef_val"    ) = parentSetupObj.CellValue(i, parentSetupObj.prefix+"n1st_coef_val"    );
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"n2nd_coef_val"    ) = parentSetupObj.CellValue(i, parentSetupObj.prefix+"n2nd_coef_val"    );
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"trnd_line_cons_val"         ) = parentSetupObj.CellValue(i, parentSetupObj.prefix+"trnd_line_cons_val"         );
		
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"trnd_line_tp_cd"  )         = parentFormObj.trnd_line_tp_cd.value;
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"vsl_cd"  )                  = parentFormObj.vsl_cd.value;
		sheetObj.CellValue2(sRow2, sheetObj.prefix+"trnd_line_cntr_dzn_capa"  ) = parentFormObj.cntr_dzn_capa.value;
		
		sheetObj.CellValue2(sRow2, "checkbox") = 1;
	}
	
	
// sheetObj.InitDataCombo(0, sheetObj.prefix+"cntr_vsl_clss_capa",
// "Class/Lane|Class|All", "1|2");

}

/**
 * 부모창의 활성화된 Sheet 정보를 가져온다.
 * 
 * @return
 */
function getParent(idx){
	var opner = window.dialogArguments;
	
	if(opner.sheetObjects && opner.sheetObjects.length > 0){
		return opner.sheetObjects[idx];
	}
	return opner.sheetObjects[idx];
}

function initControl() {
	var formObj = document.form;
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
// axon_event.addListenerForm("focus", "obj_activate", formObj);
// axon_event.addListenerForm("blur", "obj_deactivate', formObj);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var prefix = sheetObj.id + "_";
	sheetObj.prefix = prefix;

	switch (sheetObj.id) {
	case "sheet1": // IBSheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 200;
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
			InitRowInfo(2, 1, 9, 100);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, false, false, false, false)

			var HeadTitle = "|Design Capacity|Design Capacity|Fuel Consumption Trend Line|Fuel Consumption Trend Line|trnd_line_seq|trnd_line_tp_cd|n1st_coef_val|n2nd_coef_val|trnd_line_cons_val|vsl_cd|trnd_line_cntr_dzn_capa|avg_gnr_csm_wgt|avg_blr_csm_wgt|checkbox";
			var HeadTitle2 = "|Design Capa.|Lane|Type No.|Remark|trnd_line_seq|trnd_line_tp_cd|n1st_coef_val|n2nd_coef_val|trnd_line_cons_val|vsl_cd|trnd_line_cntr_dzn_capa|avg_gnr_csm_wgt|avg_blr_csm_wgt|checkbox";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			InitHeadRow(1, HeadTitle2, false);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0,	daCenter, false, prefix+"ibflag");
			InitDataProperty(0, cnt++, dtData,		   100,	daCenter, true,  prefix+"cntr_dzn_capa",           false, "", dfNone, 0, false,  false);
			InitDataProperty(0, cnt++, dtData,         120, daCenter, false, prefix+"vsl_slan_cd",             false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtPopup,        150, daCenter, false, prefix+"trnd_line_no",        false, "", dfNone, 0, true,  true);
			InitDataProperty(0, cnt++, dtData,         100, daCenter, false, prefix+"trnd_line_rmk",           false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"trnd_line_seq",           false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"trnd_line_tp_cd",         false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"n1st_coef_val",           false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"n2nd_coef_val",           false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"trnd_line_cons_val",                false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"vsl_cd",                  false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"trnd_line_cntr_dzn_capa", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"avg_gnr_csm_wgt",         false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden,       100, daCenter, false, prefix+"avg_blr_csm_wgt",         false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox,     25,	daCenter, true,	"checkbox",                        false, "", dfNone, 0, true, true);
			// CountFormat = "[SELECTDATAROW / TOTALROWS]";

			FocusAfterProcess = false;
			CountPosition = 0;
			ColHidden("checkbox") = true;
		}
		break;
		
// case "sheet2": // TREND LINE INFO
// with (sheetObj) {
// // 높이 설정
// style.height = 100;
// // 전체 너비 설정
// SheetWidth = mainTable.clientWidth;
//
// // Host정보 설정[필수][HostIp, Port, PagePath]
// if (location.hostname != "")
// InitHostInfo(location.hostname, location.port, page_path);
//
// // 전체Merge 종류 [선택, Default msNone]
// MergeSheet = msHeaderOnly;
//
// // 전체Edit 허용 여부 [선택, Default false]
// Editable = true;
//
// // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
// InitRowInfo(1, 1, 10, 100);
//
// // 해더에서 처리할 수 있는 각종 기능을 설정한다
// InitHeadMode(true, false, false, false, false, false)
//
// var HeadTitle =
// "|trnd_line_seq|trnd_line_tp_cd|trnd_line_cht_tp_cd|trnd_line_fm_dt|trnd_line_to_dt|trnd_line_no|trnd_line_rmk";
// var headCount = ComCountHeadTitle(HeadTitle);
//
// // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
// InitColumnInfo(headCount, 0, 0, false);
//
// // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
// InitHeadRow(0, HeadTitle, true);
//
// // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD,
// CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
// InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, false,
// prefix+"ibflag");
// InitDataProperty(0, cnt++, dtData, 100, daCenter, false,
// prefix+"trnd_line_seq", false, "", dfNone, 0, true, true);
// InitDataProperty(0, cnt++, dtData, 100, daCenter, false,
// prefix+"trnd_line_tp_cd", false, "", dfNone, 0, true, true);
// InitDataProperty(0, cnt++, dtData, 100, daCenter, false,
// prefix+"trnd_line_cht_tp_cd", false, "", dfNone, 0, true, true);
// InitDataProperty(0, cnt++, dtData, 100, daCenter, false,
// prefix+"trnd_line_fm_dt", false, "", dfNone, 0, true, true);
// InitDataProperty(0, cnt++, dtData, 100, daCenter, false,
// prefix+"trnd_line_to_dt", false, "", dfNone, 0, true, true);
// InitDataProperty(0, cnt++, dtData, 100, daCenter, false,
// prefix+"trnd_line_no", false, "", dfNone, 0, true, true);
// InitDataProperty(0, cnt++, dtData, 100, daCenter, false,
// prefix+"trnd_line_rmk", false, "", dfNone, 0, true, true);
// // CountFormat = "[SELECTDATAROW / TOTALROWS]";
// }
// break;
		
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
			case SEARCH:
				return true;
			default:
				return false;
		}
  	}
}

function sheet1_OnPopupClick(sheetObj, Row, Col){
	var formObj = document.form;
	var saveName = sheetObj.ColSaveName(Col);
	switch(saveName){
		case sheetObj.prefix+"trnd_line_no":
			ComOpenPopup("VOP_FCM_0014.do", 950, 650, "setTrndLineNo", "0,0", true, false, Row, Col, 0);
			break;
			
		default:
	}	
}

function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj = document.form;
	var saveName = sheetObj.ColSaveName(Col);
	var prefix = sheetObj.prefix;
	switch(saveName){
		case prefix+"trnd_line_no":
			if(Value==""){
				sheetObj.CellValue2(Row, prefix+"trnd_line_rmk") = "";
				sheetObj.CellValue2(Row, prefix+"trnd_line_seq") = "";
				sheetObj.CellValue2(Row, prefix+"n1st_coef_val") = "";
				sheetObj.CellValue2(Row, prefix+"n2nd_coef_val") = "";
				sheetObj.CellValue2(Row, prefix+"trnd_line_cons_val") = "";
				sheetObj.CellValue2(Row, "checkbox") = 0;
			}else{
				sheetObj.CellValue2(Row, "checkbox") = 1;
			}
		break;
	}
}

function setTrndLineNo(aryPopupData, Row, Col, sheetIdx) {
	 var formObj = document.form;
	 var sheetObj = sheetObjects[sheetIdx];
	 if(aryPopupData!=""){
		 sheetObj.CellValue2(Row, sheetObj.prefix+"trnd_line_no") = aryPopupData[0][14];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"trnd_line_tp_cd") = aryPopupData[0][1];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"trnd_line_rmk") = aryPopupData[0][17];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"trnd_line_seq") = aryPopupData[0][0];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"n1st_coef_val") = aryPopupData[0][8];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"n2nd_coef_val") = aryPopupData[0][9];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"trnd_line_cons_val") = aryPopupData[0][10];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"vsl_cd") = aryPopupData[0][5];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"trnd_line_cntr_dzn_capa") = aryPopupData[0][3];
		 
		 sheetObj.CellValue2(Row, sheetObj.prefix+"avg_gnr_csm_wgt") = aryPopupData[0][20];
		 sheetObj.CellValue2(Row, sheetObj.prefix+"avg_blr_csm_wgt") = aryPopupData[0][21];
		 
		 
		 sheetObj.CellValue2(Row, "checkbox") = 1;
	 }
}