/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : FNS_JOO_0080.js
 *@FileTitle : Combined Data Inquery
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.01.15
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2010.01.15 박희동
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
 * @class FNS_JOO_0080 : FNS_JOO_0080 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function FNS_JOO_0080() {
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

//공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var prefix = "sheet1_";

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj1 = sheetObjects[0];

	/*******************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if (srcName == null) {
			return;
		}
		// class 가 btn1_1 이면 return한다.
		if (!JooBtnClickEnable(srcName)) {
			return;
		}

		switch (srcName) {

		case "btn_fr_back":
			UF_addMonth(formObj.fr_dt, -1);
			sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
			break;

		case "btn_fr_next":
			if (!UF_chkPeriod()){
				return;
			}
			UF_addMonth(formObj.fr_dt, 1);
			sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
			break;

		case "btn_to_back":
			if (!UF_chkPeriod()){
				return;
			}
			UF_addMonth(formObj.to_dt, -1);
			sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
			break;

		case "btn_to_next":
			UF_addMonth(formObj.to_dt, 1);
			sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
			break;

		case "btn_retrieve":
			doActionIBSheet(sheetObj1, formObj, IBSEARCH);
			break;

		case "btn_downexcel":
			sheetObj1.SpeedDown2Excel();
			break;

		case "btn_new":
			sheetObj1.RemoveAll();
			formObj.slp_ofc_cd.Index = 0;
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage(ofcList) {

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	//최초에는 trade만 조회하고 trade변경시에 lane을 읽어온다.
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1, ofcList);
	}

	initControl();
}

/**
 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sheetObjects 배열에서 순번
 **/
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;

	//Axon 이벤트 처리1. 이벤트catch
	axon_event.addListenerFormat('beforedeactivate', 'obj_blur', formObj); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	axon_event.addListenerFormat('beforeactivate', 'obj_focus', formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerFormat('keyup', 'form_keyup', formObj);

	axon_event.addListener('keypress', 'fr_dt_keypress', 'fr_dt');
	axon_event.addListener('keypress', 'to_dt_keypress', 'to_dt');
    axon_event.addListener('keyup', 'fr_dt_keyup', 'fr_dt');	
    axon_event.addListener('keyup', 'to_dt_keyup', 'to_dt');
}

//Axon 이벤트 처리2. 이벤트처리함수
function obj_blur() {
	ComChkObjValid(event.srcElement);
}

function obj_focus() {
	ComClearSeparator(event.srcElement);
}

function fr_dt_keypress() {
	ComKeyOnlyNumber(document.form.fr_dt);
}

function to_dt_keypress() {
	ComKeyOnlyNumber(document.form.to_dt);
}

function fr_dt_keyup(){
	var formObj = document.form;
	var frDt = ComReplaceStr(formObj.fr_dt.value,"-","");
	if (frDt.length == 8){
		sheetObjects[0].RemoveAll();
		doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
	}
}

function to_dt_keyup(){
	var formObj = document.form;
	var toDt = ComReplaceStr(formObj.to_dt.value,"-",""); 
	if (toDt.length == 8){
		sheetObjects[0].RemoveAll();
		doActionIBSheet(sheetObjects[0], formObj, IBROWSEARCH);
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
	case 1: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 400;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			var HeadTitle = "Acct Yrmon|Office|Trade|Lane|Carrier|Combined|Combined No.|Adjust Flag";
			var headCount = ComCountHeadTitle(HeadTitle);

			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			//InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "acct_yrmon" , false, "", dfDateYmd);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "ofc_cd"     , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "trd_cd"     , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "rlane_cd"   , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "jo_crr_cd"  , false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "cmb_cfm_flg", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "stl_cmb_seq", false, "", dfNone);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix+ "stl_adj_flg", false, "", dfNone);
		}
		break;

	}
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 */
function initCombo(comboObj, comboNo, ofcList) {
	var formObject = document.form

	switch (comboNo) {
	case 1:
		with (comboObj) {
			MultiSelect = false;
			UseAutoComplete = true;
			SetColAlign("left");
			SetColWidth("30");
			DropHeight = 160;
			ValidChar(2, 0);//영문대문자만 입력가능
			MaxLength = 6;
		}
		var comboItems = ofcList.split("|");

		addComboItem(comboObj, comboItems);
		comboObj.index = 0;

		if (comboItems.length == 1) {
			comboObj.Enable = false;
		} else {
			comboObj.Enable = true;
		}
		break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;

	if (!validateForm(sheetObj, formObj, sAction)) {
		return false;
	}

	switch (sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0080GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			sheetObj.LoadSearchXml(sXml);
			break;

		case IBROWSEARCH: //조회조건변경시 해당하는 OFFICE List를 COmbo로 setting
			comboObjects[0].RemoveAll();

			formObj.f_cmd.value = SEARCHLIST01;
			var sXml = sheetObj.GetSearchXml("FNS_JOO_0080GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
			var ofcList = ComGetEtcData(sXml,"ofc_list");
			initCombo(comboObjects[0],1, ofcList);
			
			break;
			
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
		case IBSEARCH: //조회
			var frDt = ComReplaceStr(formObj.fr_dt, "-", "");
	
			var toDt = ComReplaceStr(formObj.to_dt, "-", "");
	
			if (ComGetDaysBetween(frDt, toDt) < 0) {
				ComShowCodeMessage("JOO00078");
				formObj.to_dt.focus();
				return false;
			}
			break;
		}
	return true;
}

function slp_ofc_cd_OnChange(comboObj, idx_cd, text) {
	sheetObjects[0].RemoveAll();
}

function UF_chkPeriod(){
	var aBol = true;
	var formObj = document.form;
	var fr = ComReplaceStr(formObj.fr_dt.value,"-","");
	var to = ComReplaceStr(formObj.to_dt.value,"-","");
	
	if (fr == "" || to == ""){
		aBol = true;
	}else{
		if (Number(fr) == Number(to)){
			ComShowCodeMessage("JOO00078");
			aBol = false;
		}
	}
	
	return aBol;
}

/* 개발자 작업  끝 */