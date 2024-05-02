/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_9515.js
*@FileTitle : Yard Group (Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.12
*@LastModifier : 정운
*@LastVersion : 1.0
* 2014.02.12 정운
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
 * @class VOP_VSK_9515 : VOP_VSK_9515 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_9515() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

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

		case "btn_port_cd":
			sUrl = "/hanjin/VOP_VSK_0043.do";
			var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
			if (rVal) {
				formObject.port_cd.value = rVal;
			}
			break;
		
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
			
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
			
		case "btn_close":
			window.close();
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

	initControl();
    document.form.port_cd.focus();
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
	axon_event.addListenerForm('focus', 'obj_focus', form);
	axon_event.addListenerForm('change', 'obj_change', form); 		//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onchange 이벤트에 코드 처리
	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);
	axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
	
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {

			tabIndex = -1;

			// 높이 설정
			style.height = 340;
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
			InitRowInfo(1, 1, 3, document.form.pagerows.value);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)

			var HeadTitle1 = "|PORT|TMNL|Terminal Name|Group|";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,	"ibflag",		false,	"",      	dtStatus,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	"port_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"tmnl_cd",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,			350,	daLeft,		true,	"yd_nm",		false,	"",			dfNone,			0,			false,		false);
			InitDataProperty(0, cnt++ , dtComboEdit,	50,		daCenter,	true,	"yd_grp_id",	false,	"",			dfEngUpKey,		0,			true,		true,     1);

			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"yd_cd",		false,	"",			dfNone,			0,			false,		false);

			InitDataCombo(0, "yd_grp_id", " |A|B|C|D", " |A|B|C|D");
			
		}
		break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	var sheetID = sheetObj.id;
	
	switch (sAction) {
	case IBSEARCH: // 조회
		if(validateForm(sheetObj,formObj,sAction)){
			ComOpenWait(true);			
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_9515GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml);
			ComOpenWait(false);
		}
		break;

	case SEARCH01: //Port Code Check
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("VOP_VSK_9515GS.do", FormQueryString(formObj));
			return sXml;
		break;
	
	case IBSAVE:
			if(formObj.port_cd.value==""){
				ComShowCodeMessage('VSK00027', 'Port');
				formObj.port_cd.focus();
				return false;
			}
			formObj.f_cmd.value = MULTI;			
			var SaveStr = ComGetSaveString(sheetObj);
			if(SaveStr == undefined || SaveStr.length <= 0 ) return;
			
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveXml("VOP_VSK_9515GS.do", SaveStr + "&"+FormQueryString(formObj));
			ComOpenWait(false);
			if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {
				sheetObj.LoadSaveXml(sXml);
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
			}
		break;
	}
}

function obj_deactivate(){
    ComChkObjValid(event.srcElement);
}
function obj_activate(){
	ComClearSeparator(event.srcElement);
}

function obj_focus(){
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}

function obj_keypress(){
	var formObj = document.form;
	switch (event.srcElement.name) {

	    case "port_cd":
	    	ComKeyOnlyAlphabet('upper');
	    	break;

	}
}

function obj_change(){
	var formObj = document.form;
    var sheetObj = sheetObjects[0];
	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {
            case "port_cd":
            	isCheckPortCd(sheetObj, formObj);
            	break;

        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {

		case IBSEARCH:
			if(formObj.port_cd.value==""){
				ComShowCodeMessage('VSK00027', 'Port');
				formObj.port_cd.focus();
				return false;
			}

	}
	return true;
}

/**
 * MDM에 Port Code가 존재하는지 확인한다.
 */
function isCheckPortCd(sheetObj, formObj){
	if(formObj.port_cd.value == null || formObj.port_cd.value == undefined || formObj.port_cd.value == "") return false;
	if(ComChkLen(formObj.port_cd, 5) == 2){
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
		var chkPort = ComGetEtcData(sXml, "check_port");//X-사용가능
		if(chkPort != "X"){
			ComShowCodeMessage("VSK00029", formObj.port_cd.value);
			formObj.port_cd.value = "";
			formObj.port_cd.focus();
		}else{
			return true;
		}
	}else{
		ComShowCodeMessage("COM12114", "Port Code");
		formObj.port_cd.value = "";
		formObj.port_cd.focus();
	}
}


	
/* 개발자 작업 끝 */