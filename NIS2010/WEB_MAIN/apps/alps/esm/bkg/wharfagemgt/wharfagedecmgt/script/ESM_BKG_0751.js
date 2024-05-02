/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :ESM_BKG_0688.js
*@FileTitle : US Wharfage Exception Keyword
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.04.16 김민정
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0751() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 *  버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
			case "btn_RowAdd":
				sheetObject.DataInsert(-1);
				break;
			case "btn_RowDelete":
				if (sheetObject.RowCount > 0) {
					var delCnt = 0;
					for (var i=1; i<sheetObject.RowCount+1; i++) {
						if (sheetObject.CellValue(i, "chk") == "1") {
							if (sheetObject.CellValue(i, "port_seq") != "") {
								sheetObject.CellValue2(i, "ibflag") = "D";
								sheetObject.RowHidden(i) = true;
							} else {
								sheetObject.RowDelete(i, false);
								i--;
							}
							delCnt++;
						}
					}
					if (delCnt == 0) {
						ComShowCodeMessage('BKG00714');
						return;
					}
				}
				break;
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0], document.form, SEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObject, MULTI);
				break;
			case "btn_Close":
				window.close();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
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
	for (i = 0; i < sheetObjects.length; i++) 
	{
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
	axon_event.addListenerForm('Change', 'obj_Change', document.form);
	sheetObjects[0].WaitImageVisible = false;
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
		case "sheet1": //sheet1 init
			with (sheetObj) {
				// 높이 설정
				style.height = 222;
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
	
				var HeadTitle1 = "|Sel.|Yard Code|Berth Name|Bill TO|";
				var headCount = ComCountHeadTitle(HeadTitle1);
	
				// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, true, false);
	
				// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
	
				// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, 
				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, 
				// EDITLEN, FULLINPUT, SORTENABLE,
				// TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++, dtHiddenStatus, 60, daCenter, true, "ibflag");
				InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, false, "chk");
				InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, "yd_cd", true, "", dfNone, 0, true, true, 7);
				InitDataProperty(0, cnt++, dtData, 130, daCenter, true, "brth_desc", false, "", dfNone, 0, true, true, 100);
				InitDataProperty(0, cnt++, dtData, 180, daCenter, true, "bil_rcv_pty_nm",	false, "", dfNone, 0, true, true, 100);
				InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "port_seq");

				CountPosition = 0;
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
	formObj.f_cmd.value = sAction;
	switch (sAction)
	{
		case SEARCH: //Retrieve
			if (validateForm(sheetObj, formObj, sAction))
			{
				ComOpenWait(true,true);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0751GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				var arrCombo = ComXml2ComboString(arrXml[1], "yd_cd", "yd_cd");
				sheetObj.InitDataCombo(0, "yd_cd", arrCombo[0], arrCombo[1]);
				sheetObj.LoadSearchXml(arrXml[0]);
				ComOpenWait(false);
			}
			break;
		case MULTI: //Save
			if (validateForm(sheetObj, formObj, sAction))
			{
				ComOpenWait(true,true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0751GS.do", sheetObj.GetSaveString() + "&" + FormQueryString(formObj));
				if(ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.loadSaveXml(sXml);
					sheetObj.CheckAll("chk") = 0;
					doActionIBSheet(sheetObj, formObj, SEARCH)
				}
				ComOpenWait(false);
			}
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
		case SEARCH: //조회
			// 기본포멧체크
			if (!ComChkValid(formObj))
				return false;
			break;
	case MULTI:
		if (sheetObj.GetSaveString() == "") {
			ComShowCodeMessage("BKG95005");
			return false;
		}
		break;
	}
	return true;
}

/**
 * 화면 input box 변경 시 발생하는 이벤트
 */
function obj_Change() {
	doActionIBSheet(sheetObjects[0], document.form, SEARCH);
}