/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0428.js
 *@FileTitle : US AMS: Receive History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.06.01 이수빈
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
 * @class US AMS: Receive History : US AMS: Receive History 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_0428() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.setComboObject = setComboObject;
	this.validateForm = validateForm;
}

/* 개발자 작업	*/ 

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var end_no = 0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용 *****/
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];

	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_view":
			doActionIBSheet(sheetObject, formObject, IBROWSEARCH);
			break;

		case "btn_calendar":
			if (formObject.fromd.disabled)
				return;
			var cal = new ComCalendarFromTo();
			cal.select(formObject.fromd, formObject.tod, 'yyyy-MM-dd');
			break;
		case "btn_downexcel":
			sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
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
 * 콤보 Object를 comboObjects 배열에 등록
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * Combo Object 초기화
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
	case "rcv_msg_tp_id":
		var i = 0;
		with (comboObj) {
			ColBackColor(0) = "#CCFFFD";
			DropHeight = 200;
			MultiSelect = false;
			MaxSelect = 1;
		}
		break;
	}
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i], i + 1);

		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (i = 0; i < comboObjects.length; i++) {
		initCombo(comboObjects[i], i + 1);
	}

	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
	document.form.vvd.focus();

	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("click", "obj_click", document.form);
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	//US AMS Main Menu : VVD 입력시
	if (!ComIsNull(document.form.vvd))
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
			// 높이 설정
			style.height = 402;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = false;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 2, 1000);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(18, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "Seq.|MSG|Receive Date|Receive Date|Receive Seq.|VVD|POL|V.POD|Customs|B/L No.|Batch No.|SCAC|Reason|msg_desc|cnt_cd|io_bnd_cd|rcv_seq|rcv_date|rjct_flg";
			var headCount = ComCountHeadTitle(HeadTitle);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 50, daCenter, false, "Seq");
			InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "rcv_msg_tp_id", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "rcv_dt", false, "", dfDateYmd, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "rcv_tm", false, "", dfTimeHms, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "rcv_seq", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "vvd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pol_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "vpod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, false, "bl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "cstms_bat_no", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "scac_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daLeft, false, "reason", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "msg_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "cnt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "io_bnd_cd", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rcv_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rcv_date", false, "", dfUserFormat2, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 100, daCenter, false, "rjct_flg", false, "", dfNone, 0, true, true);

			InitUserFormat2(0, "rcv_date", "####-##-## ##:##:##", "-|:|:");

			CountFormat = "[SELECTDATAROW / TOTALROWS]";
		}
		break;
	} // switch end
}

/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;

	switch (sAction) {
	case IBCREATE: //콤보 데이터 조회, 미국현재날짜
		formObj.f_cmd.value = INIT;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0428GS.do", FormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		formObj.fromd.value = ComGetEtcData(arrXml[0], "date");
		formObj.tod.value = ComGetEtcData(arrXml[0], "date");
		ComXml2ComboItem(arrXml[0], formObj.rcv_msg_tp_id, "val", "name|desc");
		ComXml2ComboItem(arrXml[1], formObj.rct_rhq_cd, "val", "desc");
		formObj.rcv_msg_tp_id.DropHeight = 200;
		formObj.rcv_msg_tp_id.Code = 'AL';
		break;

	case IBSEARCH: //조회
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		if (formObj.bl_nos.value != "") {
			comboObjects[1].index = 0;
		}
		var vvd = formObj.vvd.value.trim();
		formObj.vsl_cd.value = vvd.substring(0, 4);
		formObj.skd_voy_no.value = vvd.substring(4, 8);
		formObj.skd_dir_cd.value = vvd.substring(8, 9);

		var bl_nos = formObj.bl_nos.value.trim();
		// formObj.bl_no.value = bl_nos.substring(0,10);
		formObj.bl_no.value = formObj.bl_nos.value;
		sheetObj.DoSearch("ESM_BKG_0428GS.do", FormQueryString(formObj));
		end_no = 0;
		ComOpenWait(false);
		break;

	case IBSEARCHAPPEND: // 페이징 조회
		if (!validateForm(sheetObj, formObj, IBSEARCH))
			return false;
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH;
		// sheetObj.DoSearch("ESM_BKG_0428GS.do", CondParam, "page_no=" + PageNo, true);
		sheetObj.DoSearch("ESM_BKG_0428GS.do", CondParam, "page_no=" + PageNo + "&end_no=" + end_no, true);
		ComOpenWait(false);
		break;

	case IBROWSEARCH:
		if (sheetObj.RowCount == 0)
			return false;

		var params;
		var vvd = sheetObj.CellValue(sheetObj.SelectRow, "vvd");
		var pol = sheetObj.CellValue(sheetObj.SelectRow, "pol_cd");
		var pod = sheetObj.CellValue(sheetObj.SelectRow, "pod_cd");
		var blNo = sheetObj.CellValue(sheetObj.SelectRow, "bl_no");
		var batchNo = sheetObj.CellValue(sheetObj.SelectRow, "cstms_bat_no");
		params = "vvd2=" + vvd + "&pol=" + pol + "&pod=" + pod + "&blNo=" + blNo + "&batchNo=" + batchNo;

		var msg_tp = sheetObj.CellValue(sheetObj.SelectRow, "rcv_msg_tp_id");
		var cnt_cd = sheetObj.CellValue(sheetObj.SelectRow, "cnt_cd");
		var io_bnd_cd = sheetObj.CellValue(sheetObj.SelectRow, "io_bnd_cd");
		var rcv_date = sheetObj.CellValue(sheetObj.SelectRow, "rcv_date");
		var rcv_seq = sheetObj.CellValue(sheetObj.SelectRow, "rcv_seq");
		params = params + "&msg_tp_id=" + msg_tp + "&cnt_cd=" + cnt_cd + "&io_bnd_cd=" + io_bnd_cd + "&rcv_date=" + rcv_date
				+ "&rcv_seq=" + rcv_seq;

		ComOpenWindowCenter("ESM_BKG_0429.do?" + params, "ESM_BKG_0429", 500, 520);
		break;
	}// switch end

}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: //조회
		if (formObj.gubun.checked) {
			if (!ComChkRequired(formObj))
				return false;

			var days = ComGetDaysBetween(formObj.fromd.value, formObj.tod.value);
			if (days >= 15) {
				ComShowCodeMessage('BKG50468'); // Can't Input Date Over 15 days!"
				formObj.fromd.focus();
				return false;
			}
		} else {
			if (formObj.vvd.value == '' && formObj.bl_nos.value == '') {
				ComShowMessage("'VVD' or 'B/L No.'" + Msg_Required);
				return false;
			}
		}

		if (formObj.bl_nos.value != '') {
			if (!ComChkObjValid(formObj.bl_nos))
				return false;
		} else if (formObj.pol_cd.value != '') {
			if (!ComChkObjValid(formObj.pol_cd))
				return false;
		} else if (formObj.pod_cd.value != '') {
			if (!ComChkObjValid(formObj.pod_cd))
				return false;
		} else if (formObj.cstms_bat_no.value != '') {
			var obj = formObj.cstms_bat_no;
			if (obj.value.length < obj.getAttribute("maxlength")) {
				var msg = "'" + obj.getAttribute("caption") + "' 값을 " + obj.getAttribute("maxlength") + " 길이만큼  모두 입력하세요";
				ComShowMessage(msg);
				return false;
			}
		}
		return true;
		break;
	}
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
 * @param sheetObj
 * @param CondParam
 * @param PageNo
 * @param OnePageRows
 * @return
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {

	//alert("CondParam : " + CondParam + "\nPageNo : " + PageNo+ "\nOnePageRows : " + OnePageRows);

	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
}

/**
 * 헤더 클릭 시 Sort 이벤트 Catch
 * @param sheetObj
 * @param col
 * @param sortArr
 * @return
 */
function sheet1_OnSort(sheetObj, col, sortArr) {
	if (col == 2) {
		sheetObj.ColumnSort("rcv_dt|rcv_tm", sortArr);
	}
}

/**
 * 조회 후 처리
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	for (i = 1; i < sheetObj.RowCount + 1; i++) {
		if (sheetObj.CellValue(i, "rcv_msg_tp_id") != 'MR' && sheetObj.CellValue(i, "rcv_msg_tp_id") != 'AR'
				&& sheetObj.CellValue(i, "rcv_msg_tp_id") != 'HR' && sheetObj.CellValue(i, "rcv_msg_tp_id") != 'TR'
					&& sheetObj.CellValue(i, "rcv_msg_tp_id") != 'BR')
			continue;
		if (sheetObj.CellValue(i, "rjct_flg") == 'Y') {
			sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
		}
	}
	var formObj = document.form;
	formObj.cnt_cd.value = sheetObj.CellValue(1, "cnt_cd");
	formObj.io_bnd_cd.value = sheetObj.CellValue(1, "io_bnd_cd");
	formObj.rcv_date.value = sheetObj.CellValue(1, "rcv_date");
	formObj.rcv_seq.value = sheetObj.CellValue(1, "rcv_seq");
}

/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");

	if (srcName == "vvd" && ComChkLen(srcValue, 1) == "2") { // 2: 길이 동일
		formObject.gubun.checked = false;
		alterRequiredChk(false);
	}

	if (keyValue != 9 && keyValue !=16 &&(srcName == "vvd" || srcName == "pol_cd" || srcName == "pod_cd" || srcName == "bl_nos")
			&& ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}

/**
 * Click 이벤트 Catch
 */
function obj_click() {
	var formObject = document.form;
	var srcObj = window.event.srcElement;
	var srcName = srcObj.getAttribute("name");
	var srcVal = srcObj.checked;
	if (srcName == "gubun") {
		alterRequiredChk(srcVal);
	}
}

/**
 * 체크 박스 선택 시 Form 컨트롤 활성화 처리
 * @param checked
 * @return
 */
function alterRequiredChk(checked) {
	var formObject = document.form;
	if (checked) {
		formObject.fromd.disabled = false;
		formObject.tod.disabled = false;
		formObject.fromt.disabled = false;
		formObject.tot.disabled = false;
	} else {
		formObject.fromd.disabled = true;
		formObject.tod.disabled = true;
		formObject.fromt.disabled = true;
		formObject.tot.disabled = true;
		formObject.vvd.focus();
	}
}

/**
 * 시트 선택 시 데이터 처리
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	setDetailParam(sheetObj, Row);
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col) {

	setDetailParam(sheetObj, Row);
	doActionIBSheet(sheetObj, document.form, IBROWSEARCH);
}

function setDetailParam(sheetObj, Row) {
	var formObj = document.form;
	formObj.cnt_cd.value = sheetObj.CellValue(Row, "cnt_cd");
	formObj.io_bnd_cd.value = sheetObj.CellValue(Row, "io_bnd_cd");
	formObj.rcv_date.value = sheetObj.CellValue(Row, "rcv_date");
	formObj.rcv_seq.value = sheetObj.CellValue(Row, "rcv_seq");
}

/**
 * 헤더를 클릭한 경우(소트시)
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
// function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
// var col = sheetObj.MouseCol
// if (sheetObj.MouseRow == 0 || sheetObj.MouseRow == 1) {
// if (sheetObj.RowCount < sheetObj.TotalRows) {
// ComOpenWait(true);
// end_no = sheetObj.TotalRows;
// sheetObj.TopRow = sheetObj.RowCount;
// sheetObj.TopRow = 0;
// if(col == 2){
// sheetObj.ColumnSort("rcv_dt|rcv_tm");
// } else {
// sheetObj.ColumnSort(col);
// }
// ComOpenWait(false);
// }
// }
// }

/* 개발자 작업 끝 */