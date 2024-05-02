/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_0470.js
 *@FileTitle : ESM_BKG-0470
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.03
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.06.03 김승민
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
 * @class ESM_BKG-0470 : ESM_BKG-0470 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0470() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var state = "";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			break;
		case "btn_transmit":
			doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
			break;

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
* IBSheet Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
* @param sheet_obj IBSheet Object
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

for (i = 0; i < sheetObjects.length; i++) {

	// khlee-시작 환경 설정 함수 이름 변경
	ComConfigSheet(sheetObjects[i]);

	initSheet(sheetObjects[i], i + 1);
	// khlee-마지막 환경 설정 함수 추가
	ComEndConfigSheet(sheetObjects[i]);
}
initControl();
document.form.form1_in_vvd_cd.focus();
}

//시트 데이터 초기화
function initSheetData(sheetObj, formObj) {

// formObj.vvd_cd.value = "";
// formObj.pod_cd.value = "";

sheetObj.RemoveAll();
sheetObj.DataInsert(-1);

IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
}


/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo sheetObjects 배열에서 순번
 */
function initControl() {
// ** Date 구분자 **/
DATE_SEPARATOR = "-";

var formObject = document.form;
// Axon 이벤트 처리1. 이벤트catch(개발자변경)
axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // - 키보드
axon_event.addListenerForm  ('blur', 'obj_deactivate',  formObject); //- 포커스 나갈때
axon_event.addListenerFormat('focus',   'obj_activate',    formObject); //- 포커스 들어갈때
axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
axon_event.addListener('keydown', 'ComKeyEnter', 'form');

ComBtnDisable("btn_transmit");
ComBtnDisable("btn_save");
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
switch (event.srcElement.dataformat) {
case "uppernum":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyAlphabet('uppernum');
	break;ComKeyAlphabetNChar
case "upper":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyAlphabet('upper');
	break;		
case "uppernum2":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyAlphabetNChar('uppernum2');
	break;	
case "num":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyNumber('num', '-');
	break;
case "num2":
	// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	ComKeyOnlyNumber('num', '');
	break;
default:
	// 숫자만입력하기(정수,날짜,시간)
	ComKeyOnlyNumber(event.srcElement);
}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_activate(){
	//입력Validation 확인하기
	switch(event.srcElement.name){
	
    	case "form1_eta_dt1":
    		ComClearSeparator(event.srcElement);
			break;
		default:
			break;
			//return;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
 **/
function obj_deactivate(){
	//if (event.srcElement.getAttribute("required") != null) return;
	
    //입력Validation 확인하기
	switch(event.srcElement.name){
	
    	case "form1_eta_dt1":
    		ComAddSeparator(event.srcElement);
			break;
		default:
			break;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}  

 /**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * @param sheetObj 시트오브젝트
 * @param sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {

var cnt = 0;
var sheetID = sheetObj.id;

switch (sheetID) {
case "sheet1": // sheet1 init
	with (sheetObj) {
		// 높이 설정
		style.height = 225;
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
		InitRowInfo(1, 1, 3, 100);

		// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		InitColumnInfo(12, 0, 0, true);

		// 해더에서 처리할 수 있는 각종 기능을 설정한다
		InitHeadMode(true, true, true, true, false, false)

		var HeadTitle1 = "|||||||||||";

		// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		InitHeadRow(0, HeadTitle1, true);

		// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
		// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
		// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
		// FORMATFIX]
		InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "in_vvd_cd");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "in_pod_cd");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_dt1");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "eta_dt2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etb_dt1");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "etb_dt2");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "arr_yd_cd");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "lodg_wgt");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cstms_mf_cd");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "in_pod_cd_split");
		InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "mf_rmk");
	}
	break;

}
}

/**
* Sheet관련 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
sheetObj.ShowDebugMsg = false;
switch (sAction) {

case IBSAVE: // 조회
	if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		// alert(sheetObj.RowCount);
		formObj.f_cmd.value = MULTI;
		//sheetObj.WaitImageVisible = false;
		//ComOpenWait(true);
		sheetObj.DoAllSave("ESM_BKG_0470GS.do", FormQueryString(formObj));
		//ComOpenWait(false);
		state = sheetObj.EtcData("TRANS_RESULT_KEY");
		ComOpenWait(false);
		if (state == "S") {
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
		}
		
	}
	break;

case IBSEARCH: // 조회
	if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		sheetObj.RemoveAll();
		sheetObj.DataInsert(-1);
		IBS_CopyFormToRow(formObj, sheetObj, 1, "form1_");
		formObj.f_cmd.value = SEARCH;
		formObj.in_vvd_cd.value = formObj.form1_in_vvd_cd.value;
		formObj.in_pod_cd.value = formObj.form1_in_pod_cd.value;
		//formObj.in_pod_cd_split.value = formObj.in_pod_cd_split.value;
		// alert(sheetObj.cellValue(1,"bl_no"));
		// alert(sheetObj.cellValue(1,"vvd_cd"));
		// alert(sheetObj.cellValue(1,"pod_cd"));
		//sheetObj.WaitImageVisible = false;
		//ComOpenWait(true,true);		
		//ComOpenWait(false);	
		sheetObj.DoSearch("ESM_BKG_0470GS.do", FormQueryString(formObj));
		
		if (sheetObj.RowCount == 1) {
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form1_");
			//ComOpenWait(false);	
		} else if (sheetObj.RowCount == 0) {
			//alert();
			initSheetData(sheetObj, formObj);
			formObj.form1_eta_dt1.value="";
			formObj.form1_mf_rmk.value="";
			
		}
		state = sheetObj.EtcData("TRANS_RESULT_KEY");

		if (state == "S") {
			if ( sheetObj.RowCount > 0)
			{
				ComBtnEnable("btn_transmit");
				ComBtnEnable("btn_save");
			}
		}
		ComOpenWait(false);
	
	}
	break;
case COMMAND01: // 저장
	if (validateForm(sheetObj, formObj, sAction)) {
		formObj.f_cmd.value = MULTI01;
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		// alert(sheetObj.cellValue(1,"bl_no"));
		// alert(sheetObj.cellValue(1,"vvd_cd"));
		// alert(sheetObj.cellValue(1,"pod_cd"));
		sheetObj.WaitImageVisible = false;
		//ComOpenWait(true,true);	
		//ComOpenWait(false);
		formObj.in_pod_cd_split.value = formObj.form1_in_pod_cd_split.value;
		sheetObj.DoSearch("ESM_BKG_0470GS.do", FormQueryString(formObj));
		ComEtcDataToForm(formObj, sheetObj);
		ComOpenWait(false);
		
	}
	// var sUrl =
	// "/hanjin/ESM_BKG_0470.do?vvd_cd="+formObj.in_vvd_cd.value+"&pod_cd="+formObj.in_pod_cd.value;
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 423, 172, true);
	// ComOpenWindowCenter(sUrl, "ESM_BKG_0990", 1024, 768, true);

	break;
}
}

/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
* @param sheetObj Sheet
* @param formObj form객체
* @param sAction 작업처리코드
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		//alert(formObj.vvdCd.value);
		//alert(formObj.vps_eta_start_dt.value);
		if (formObj.form1_in_vvd_cd.value == "" || formObj.form1_in_vvd_cd.value.length != 9 ) 
		{
			ComShowCodeMessage('BKG00203');
			formObj.form1_in_vvd_cd.focus();
			return false;
		} 
		if (formObj.form1_in_pod_cd.value == "" || formObj.form1_in_pod_cd.value.length != 5 ) 
		{
			ComShowCodeMessage('BKG00203');
			formObj.form1_in_vvd_cd.focus();
			return false;
		} 				
		return true;
		break;
	case IBSAVE: // 조회
		if (formObj.form1_in_vvd_cd.value == "" || formObj.form1_in_vvd_cd.value.length != 9 ) 
		{
			ComShowCodeMessage('BKG00203');
			formObj.form1_in_vvd_cd.focus();
			return false;
		} 
		if (formObj.form1_in_pod_cd.value == "" || formObj.form1_in_pod_cd.value.length != 5 ) 
		{
			ComShowCodeMessage('BKG00203');
			formObj.form1_in_vvd_cd.focus();
			return false;
		} 				
		return true;
		break;	
	case COMMAND01: // 조회
		if (formObj.form1_in_vvd_cd.value == "" || formObj.form1_in_vvd_cd.value.length != 9 ) 
		{
			ComShowCodeMessage('BKG00203');
			formObj.form1_in_vvd_cd.focus();
			return false;
		} 
		if (formObj.form1_in_pod_cd.value == "" || formObj.form1_in_pod_cd.value.length != 5 ) 
		{
			ComShowCodeMessage('BKG00203');
			formObj.form1_in_pod_cd.focus();
			return false;
		} 				
		return true;
		break;			
		
	}
}
/* 개발자 작업 끝 */