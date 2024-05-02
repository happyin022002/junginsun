/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1008.jsp
 *@FileTitle : Auth Setup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.05.21 김도완
 * 1.0 Creation
 * ------------------------------------------------------
 * History
 * 2011.10.12 윤태승 [CHM-201113684-01][ESB_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
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
 * @class Customer Code Entry : Customer Code Entry 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_1008() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}
// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_RowAdd":
			doActionIBSheet(sheetObject1, formObject, IBINSERT);
			break;
		case "btn_RowDelete":
			doActionIBSheet(sheetObject1, formObject, IBDELETE);
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
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
	axon_event.addListenerFormat("KeyPress", "my_obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
	case "sheet1":
		with (sheetObj) {
			// 높이 설정
			style.height = 420;
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
			InitRowInfo(2, 1, 16, 100);
			var HeadTitle1 = " |Sel.|User|User|User|B/L Inquiry|B/L Inquiry|B/L Inquiry|B/L Inquiry|B/L Inquiry|B/L Inquiry|B/L Inquiry|B/L Inquiry|B/L Inquiry|B/L Inquiry|P/MIB|P/MIB|MI|OFM|OFM|Change POD|Creation|Creation|Creation";
			var HeadTitle2 = " |Sel.|ID|Name|Office|VVD|POD|DEL|HUB|Cstms Loc|P/MIB No.|F.POD|PTT|FTZ|DIV|HUB|Cstms Loc|Multi|MI|History|POD|Date|User ID|Office";
			var headCount = ComCountHeadTitle(HeadTitle1);
			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false)
			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT,
			// UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			var prefix = "sheet1_";
			
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, false, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, prefix + "del_chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, prefix + "usr_id", true, "", dfEngUpKey, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 120, daLeft, false, prefix + "usr_nm", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "ofc_cd", false, "", dfNone, 0, false, false);
			
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_pod", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_del", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_hub", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, true, prefix + "bl_cstms", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, true, prefix + "bl_mib", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_fpo", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_ptt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_ftz", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "bl_div", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "mi_hub", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 80, daCenter, true, prefix + "mi_cstms", false, "", dfNone, 0, true, true);
			
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "mi_multi", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "of_mit", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 60, daCenter, true, prefix + "of_his", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 76, daCenter, true, prefix + "chg_pod", false, "", dfNone, 0, true, true);			
			InitDataProperty(0, cnt++, dtData, 130, daCenter, false, prefix + "cre_dt", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, prefix + "cre_usr_id", false, "", dfNone, 0, false, true);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, prefix + "cofc_cd", false, "", dfNone, 0, false, true);
		}
		break;
	}
}
// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, Row, Col) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
	switch (sAction) {
	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction))
		{
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_1008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			ComOpenWait(false);
		}
		break;
	case SEARCH01: // 조회
		if (validateForm(sheetObj, formObj, sAction))
		{
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH01;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			var search_auth_count = ComGetEtcData(sXml, "search_auth_count");
			if (search_auth_count > 0) {
				ComShowCodeMessage('BKG00764', 'User ID');
				sheetObj.CellValue2(Row, "sheet1_usr_id") = "";
				sheetObj.CellValue2(Row, "sheet1_usr_nm") = "";
				sheetObj.CellValue2(Row, "sheet1_ofc_cd") = "";
				ComOpenWait(false);
				return;
			}
			if (ComGetEtcData(sXml, "search_usr_nm") == "")
			{
				ComShowCodeMessage("BKG00768");
				sheetObj.CellValue2(Row, "sheet1_usr_id") = "";
				sheetObj.CellValue2(Row, "sheet1_usr_nm") = "";
				sheetObj.CellValue2(Row, "sheet1_ofc_cd") = "";
				ComOpenWait(false);
				return;
			}
			sheetObj.CellValue(Row, Col + 1) = ComGetEtcData(sXml, "search_usr_nm");
			sheetObj.CellValue(Row, Col + 2) = ComGetEtcData(sXml, "search_ofc_cd");
			if (isNullEtcData(sXml)) {
				ComShowCodeMessage('BKG00768');
				sheetObj.CellValue2(Row, Col) = "";
			}
			ComOpenWait(false);
		}
		break;
	case IBSAVE: // 저장
		if (validateForm(sheetObj, formObj, sAction))
		{
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			if (sheetObj.DoSave("ESM_BKG_1008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_")), -1, false) {
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_BKG_1008GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
			}
			ComOpenWait(false);
		}
		break;
	case IBINSERT: // 입력
		sheetObj.DataInsert(-1);
		sheetObj.SelectCell(sheetObj.SelectRow, 2);
		break;
	case IBDELETE: // 삭제
		if (sheetObj.CheckedRows(1) == 0) {
			ComShowCodeMessage('BKG00249'); // No Selected Row
			return;
		}
		if (sheetObj.CheckedRows(1) > 0) {
			if (ComShowCodeConfirm('BKG03037')) {
				ComRowHideDelete(sheetObj, "sheet1_del_chk");
			}
		}
		break;
	case IBDOWNEXCEL: // 엑셀다운로드
		ComOpenWait(true);
		sheetObj.SpeedDown2Excel(1);
		ComOpenWait(false);
		break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI:
		var prefix = "sheet1_";
		for ( var i = 2; i <= sheetObj.RowCount + 2; i++) {
			var vUsrId = sheetObj.CellValue(i, prefix + "usr_id");
			if (sheetObj.CellValue(i, "ibflag") != "R") {
				if (!ComIsNull(vUsrId)) {
					ComShowCodeMessage('BKG00104', 'User ID');
					return false;
				}
			}
		}
		break;
	}
	return true;
}

/**
 * 시트 변경 시 처리
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var prefix = "sheet1_";
	var formObject = document.form;
	if (sheetObj.ColSaveName(Col) == prefix + "usr_id") {
		formObject.ch_usr_id.value = Value;
		doActionIBSheet(sheetObj, formObject, SEARCH01, Row, Col);
	}
}

/**
 * ETC-DATA 가 널인지 확인
 */
function isNullEtcData(xmlStr) {
	var rtn = false;
	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	xmlDoc.loadXML(xmlStr);
	var xmlRoot = xmlDoc.documentElement;
	if (xmlRoot == null)
		return true;
	var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
	if (etcDataNode == null)
		return true;
	var etcNodes = etcDataNode.childNodes;
	if (etcNodes == null)
		return true;
	if (etcNodes.length == 0)
		rtn = true;
	return rtn;
}

/**
 * KeyPress 이벤트 처리
 */
function my_obj_KeyPress() {
	switch (event.srcElement.dataformat) {
	case "eng": // 영문 + 숫자
		// 영문은 기본 대문자로 한다.(포멧에 대소문자 구분 + 숫자가 없음)
		MyComKeyOnlyAlphabet('uppernum');
		break;
	case "engspnum": // 영문대문자
		MyComKeyOnlyAlphabet('upperspecialcharnum');
		break;
	default: // 영문 + 숫자
		MyComKeyOnlyAlphabet('uppernum');
		break;
	}
}

/**
 * KeyPress 이벤트 발생 시 호출되며 포맷에 맞는지 확인
 */
function MyComKeyOnlyAlphabet(sFlag) {
	try {
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var bCanNum = false;
		var bSpecialChar = false;
		if (sFlag.indexOf("specialchar") >= 0)
			bSpecialChar = true;
		if (sFlag == undefined || sFlag == null || sFlag.constructor != String)
			sFlag = "";
		sFlag = sFlag.toLowerCase();
		if (sFlag.length >= 3) {
			if (sFlag.substr(sFlag.length - 3) == "num")
				bCanNum = true;
			if (sFlag.length > 5)
				sFlag = sFlag.substr(0, 5);
		}
		if (keyValue >= 97 && keyValue <= 122) { // 소문자
			if (sFlag == "upper")
				event.keyCode = keyValue + 65 - 97;
			event.returnValue = true;
		} else if (keyValue >= 65 && keyValue <= 90) { // 대문자
			if (sFlag == "lower")
				event.keyCode = keyValue + 97 - 65;
			event.returnValue = true;
		} else if (bCanNum && keyValue >= 48 && keyValue <= 57) {// 숫자
			event.returnValue = true;
		} else if (bSpecialChar
				&& ((keyValue >= 33 && keyValue <= 47) || (keyValue >= 58 && keyValue <= 64) || (keyValue >= 91 && keyValue <= 96))) {// 특수문자
			event.returnValue = true;
		} else {
			event.returnValue = false;
		}
		return true;
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
}
/* 개발자 작업 끝 */