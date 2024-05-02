/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0367_01.js
 *@FileTitle : esm_bkg_0367_01
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.01
 *@LastModifier : 최 선
 *@LastVersion : 1.1
 * 2009.06.09 이진서
 * 1.0 Creation
 *----------------------------------------------------------
 * History
 * 2010.12.01 최 선     1.1 [CHM-201007417] PO & Other No (General) Incoterms Column Add, Validation
 * 2012.01.16 박성호 [CHM-201215571] [BKG_OB] P/O & Other No 생성 로직 변경  
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
 * @class esm_bkg_0367_01 : esm_bkg_0367_01 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0367_01() {
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

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;
var log_script = false;
var URL_ESM_BKG = 'ESM_BKG_0367_01GS.do';
// PO & Other No. 입력 상태 확인용
var po_cust_flag = 'N';
var po_ref_flag = 'N';
var po_ref_dtl_flag = 'N';

var isInquiry = false;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
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
	if (!opener) opener = window.dialogArguments;
	isInquiry = opener.document.form.isInquiry && "Y"==ComGetObjValue(opener.document.form.isInquiry);

	if (document.form.bkg_no.value == '' &&
			document.form.xter_rqst_no.value == '') {
		ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
		self.close();
	}

	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}

	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}
	initControl();
	initCombo();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * initControl 초기화 이벤트 처리 
 */
function initControl() {
	//** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObj = document.form;
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); //
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj); //
	axon_event.addListenerForm('keydown', 'check_Enter', formObj);
	axon_event.addListenerForm("change",  "form1_onChange", formObj);

	if ('S' == ComGetObjValue(formObj.popuptpcd) || 'E' == ComGetObjValue(formObj.popuptpcd) 
			|| isInquiry || 'Y' == ComGetObjValue(formObj.ca_flg) ) {
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn1_Row_Add");
		ComBtnDisable("btn1_Row_Delete");
		ComBtnDisable("btn2_Row_Add");
		ComBtnDisable("btn2_Row_Delete");
		if (isInquiry) {
			ComBtnDisable("btn2_Copy_from");
		}
	}
}

/**
 * initCombo 이벤트 처리<br>
 * weight 단위 와 measuer 단위를 가져온다. <br>
 * @param 
 * @exception EventException
 */
function initCombo() {

	var formObj = document.form;
	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);

	try {
		var param = FormQueryString(formObj);
		param = param + "&cm_code=CD00775";

		var sXml = sheetObjects[1].GetSearchXml("ESM_Booking_UtilGS.do", param);
		var arrXml = sXml.split("|$$|");

		if (arrXml[0].length > 0) {
			var arrCombo = ComXml2ComboString(arrXml[0], "val", "name");
			sheetObjects[1].InitDataCombo(0, "sheet2_wgt_ut_cd", "|" + arrCombo[0], "|" + arrCombo[1], "KGS");
		}

		var param = FormQueryString(formObj);
		param = param + "&cm_code=CD01116";

		var sXml = sheetObjects[1].GetSearchXml("ESM_Booking_UtilGS.do", param);
		var arrXml = sXml.split("|$$|");

		if (arrXml[0].length > 0) {
			var arrCombo = ComXml2ComboString(arrXml[0], "val", "name");
			sheetObjects[1].InitDataCombo(0, "sheet2_meas_ut_cd", arrCombo[0], arrCombo[1], "CBM");
		}

	} catch (ex) {
		bkg_error_alert('', ex);
		return false;
	}

	return true;
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
			style.height = 142;
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
			InitColumnInfo(10, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Container No.|P/O No. (by CNTR)";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			var prefix = "sheet1_";

			InitDataProperty(0, cnt++, dtData, 100, daLeft, true, prefix + "c_cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daLeft, true, prefix + "cust_ref_no_ctnt", false, "", dfNone, 0, true, true, 10, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no_split");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ref_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "cntr_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "pck_qty");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "cntr_mf_wgt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "meas_qty");

			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			CountPosition = 0;

		}
		break;

	case 2: //t1sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 142;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;
			// 자동 트림하여 조회및 저장
			DataAutoTrim = true;
			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(15, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = " |P/O No.(byItem)|Item No.|Description|Package|Package|Weight|Weight|Measure|Measure";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet2_";

			InitDataProperty(0, cnt++, dtCheckBox, 20, daCenter, true, prefix + "del_chk");
			InitDataProperty(0, cnt++, dtData, 99, daLeft, true, prefix + "po_no", false, "", dfNone, 0, true, true, 10, false);
			InitDataProperty(0, cnt++, dtData, 65, daLeft, true, prefix + "itm_no", false, "", dfNone, 0, true, true, 15, false);
			InitDataProperty(0, cnt++, dtData, 70, daLeft, true, prefix + "itm_desc", false, "", dfNone, 0, true, true, 50, false);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, prefix + "pck_qty", false, "", dfNullFloat, 3, true, true, 12, false);
			InitDataProperty(0, cnt++, dtPopupEdit, 20, daRight, false, prefix + "pck_tp_cd", false, "", dfNone, 0, true, true, 2);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, prefix + "cntr_wgt", false, "", dfNullFloat, 3, true, true, 18, false);
			InitDataProperty(0, cnt++, dtCombo, 30, daRight, false, prefix + "wgt_ut_cd", false, "", dfNone, 0, true, true, 3, false);
			InitDataProperty(0, cnt++, dtData, 65, daRight, false, prefix + "meas_qty", false, "", dfNullFloat, 3, true, true, 12, false);
			InitDataProperty(0, cnt++, dtCombo, 30, daRight, false, prefix + "meas_ut_cd", false, "", dfNullFloat, 3, true, true, 3, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no_split");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ref_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "cntr_no");

			InitDataValid(0, prefix + "pck_tp_cd", vtEngUpOther);
			InitDataValid(0, prefix + "itm_no", vtNumericOnly);
			
			AutoRowHeight = false;
			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			DataLinkMouse(prefix + "pck_tp_cd") = true;
			DataLinkMouse(prefix + "wgt_ut_cd") = true;
			DataLinkMouse(prefix + "meas_ut_cd") = true;
			CountPosition = 0;
		}
		break;

	case 3: //t1sheet2 init
		with (sheetObj) {
			// 높이 설정
			style.height = 182;

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
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Ship ID (Delivery No.)|Ship Ref No.|Part No.|Copy to Description";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(10, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = "sheet3_";
			InitDataProperty(0, cnt++, dtCheckBox, 40, daCenter, true, prefix + "del_chk", false, "", dfNone, 0, true);
			InitDataProperty(0, cnt++, dtData, 280, daLeft, true, prefix + "de_no", false, "", dfNone, 0, true, true, 15, false);
			InitDataProperty(0, cnt++, dtData, 280, daLeft, true, prefix + "shp_ref_no", false, "", dfNone, 0, true, true, 15, false);
			InitDataProperty(0, cnt++, dtData, 250, daLeft, true, prefix + "prt_no", false, "", dfNone, 0, true, true, 15, false);
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "check", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no_split");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ref_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "cntr_no");
			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			CountPosition = 0;
		}
		break;

	case 4: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 182;
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
			InitColumnInfo(10, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "Container No.|Load ID (by CNTR)";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			var prefix = "sheet4_";

			InitDataProperty(0, cnt++, dtData, 250, daCenter, true, prefix + "c_cntr_no", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix + "cust_ref_no_ctnt", false, "", dfNone, 0, true, true, 10, false);

			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no_split");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ref_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "cntr_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "pck_qty");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "cntr_mf_wgt");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "meas_qty");

			MultiSelection = false;
			SelectHighLight = true;
			SheetBackColor = RgbColor(248, 248, 248);
			SelectBackColor = RgbColor(236, 246, 247);
			CountPosition = 0;

		}
		break;
		
	case 5: //t1sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 0;
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
			InitColumnInfo(8, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle1 = "||||";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]

			var prefix = "sheet5_";

			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true, prefix + "ibflag");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_no_split");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "ref_seq");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bl_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bl_no_tp");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "bkg_ref_tp_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, prefix + "cust_ref_no_ctnt");
			CountPosition = 0;
		}
		break;
	}
}

/**
 * Sheet관련 컬럼 onClick 엑션 이벤트 처리 
 */
function sheet1_OnClick(sheetObject, Row, Col, Value) {
	var formObj = document.form;
	var sXml = null;
	var prefix = sheetObject.id + "_";

	try {
		var target_value = sheetObject.CellText(Row, prefix + "c_cntr_no");

		formObj.cntr_no.value = target_value; // 컨터이너 번호 얻기
		formObj.pck_qty.value = sheetObject.CellText(Row, prefix + "pck_qty").comma();
		formObj.cntr_mf_wgt.value = sheetObject.CellText(Row, prefix + "cntr_mf_wgt").comma();
		formObj.meas_qty.value = sheetObject.CellText(Row, prefix + "meas_qty").comma();

		// 1.container 번호로 필터링 hidden설정
		if (filteredData(sheetObjects[1], "sheet2_cntr_no", target_value)) {
			//2.container 번호로 총합구하기 
			filteredDataSum(sheetObjects[1]);
		}
		//2.container 별로 ship number 구하기 
		// if (filteredData(sheetObjects[2], "sheet3_cntr_no", target_value)) {
		// }
	} catch (ex) {
		bkg_error_alert('', ex);
		return false;
	}
}

/**
 * Sheet2 관련 OnKeyUp 속성설정하기  : 총합구하기 
 * 
 *function sheet2_OnKeyUp(Row, Col, KeyCode, Shift){
 *	filteredDataSum(sheetObjects[1]);
 *}
 */

/**
 * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
 * 
 * @param {ibsheet}
 *            sheetObject IBSheet Object
 * @param {ibsheet}
 *            Row sheetObj의 선택된 Row
 * @param {ibsheet}
 *            Col sheetObj의 선택된 Col
 * @param {String}
 *            Value sheetObj의 입력값
 */
function sheet2_OnChange(sheetObject, Row, Col, Value) {
	filteredDataSum(sheetObjects[1]);
	
	var col_save_name = sheetObject.ColSaveName(Col);  
	if(col_save_name == "sheet2_po_no"){
		sheetObject.CellValue2(Row,"sheet2_po_no") = sheetObject.CellValue(Row,"sheet2_po_no").replace(/[\r|\n]/g, '');
	}
 
}
/**
 * Sheet관련 화면 구성 hidden 속성설정하기 : container번호로 필터링하기  
 * 
 */
var item_cnt = 0; // 현재 sheet에 보이는 item의 갯수
function filteredData(sheetObj, tmp_name, tmp_value) {
	item_cnt = 0;
	var cnt = sheetObj.LastRow;

	for (ix = 1; ix <= cnt; ix++) {
		if (sheetObj.RowStatus(ix) == 'D') {
		} else if (sheetObj.CellValue(ix, tmp_name) == tmp_value) {
			sheetObj.RowHidden(ix) = false;
			item_cnt++;
		} else {
			sheetObjects[2].CheckAll2("sheet3_check") = 0;
			sheetObj.RowHidden(ix) = true;
		}
	}
	return true;
}

/**
 * 버튼 활성화/비활성화 
 * Copy from C/M 버튼 처리 Sheet상에 항목이 하나도 없으면 버튼이 활성화된다.
 */
function button_ComBtnDisable(sheetObj) {
	if (!isInquiry) {
		var formObj = document.form;
		var cnt = sheetObj.TotalRows;
		if (cnt > 0) {
			ComBtnDisable("btn2_Copy_from");
		} else {
			ComBtnEnable("btn2_Copy_from");
		}
	}
}

/**
 * Sheet 조회완료 후 이벤트 발생
 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg) {

}

/**
 * Sheet관련 화면 구성 컬럼별 총합구하기 .
 */
function filteredDataSum(sheetObj) {
	var prefix = "sheet2_";
	var formObj = document.form;
	var cnt = sheetObj.LastRow;
	var sum1 = 0, sum2 = 0, sum3 = 0;

	try {
		for (i = 1; i <= cnt; i++) {

			if (sheetObj.RowHidden(i) == false) {
				sum1 += Number(sheetObj.CellValue(i, prefix + "pck_qty"));
				sum2 += Number(sheetObj.CellValue(i, prefix + "cntr_wgt"));
				sum3 += Number(sheetObj.CellValue(i, prefix + "meas_qty"));
			}
		}

		var style_p = formObj.t_pck_qty.style;
		var style_c = formObj.t_cntr_mf_wgt.style;
		var style_m = formObj.t_meas_qty.style;

		if (sum1 != formObj.pck_qty.value) {
			style_p.color = 'ff0000';
		} else {
			style_p.color = '#000000';
		}
		if (sum2 != formObj.cntr_mf_wgt.value) {
			style_c.color = 'ff0000';
		} else {
			style_c.color = '#000000';
		}
		if (sum3 != formObj.meas_qty.value) {
			style_m.color = 'ff0000';
		} else {
			style_m.color = '#000000';
		}

		formObj.t_pck_qty.value = String(sum1).comma();
		formObj.t_cntr_mf_wgt.value = String(sum2).comma();
		formObj.t_meas_qty.value = String(sum3).comma();

	} catch (ex) {
		bkg_error_alert('filteredDataSum', ex);
		return false;
	}
}

/**
 * Sheet관련 화면 구성 초기값 셋팅 
 */
function setSearch_Init_Page1() {
	var formObj = document.form;
	var sObject = sheetObjects[4];
	var prefix = 'sheet5_';
	var isfirst = true;
	var c_row = sObject.LastRow;

	formObj.vbkg_no.value = formObj.bkg_no.value;

	for ( var row = 1; row <= c_row; row++) {
		if (isfirst) {
			var bkg_no = sObject.CellValue(row, prefix + "bkg_no");
			var bl_no = sObject.CellValue(row, prefix + "bl_no");
			var bl_no_tp = sObject.CellValue(row, prefix + "bl_no_tp");
			formObj.vbl_no.value = bl_no + bl_no_tp;
			isfirst = false;
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'BKPO') {
			formObj.bkpo.value = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'LCNO') {
			formObj.lcno.value = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'HINV') {
			formObj.hinv.value = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'LCDT') { // YYYY-MM-DD 
			formObj.lcdt.value = sObject.CellValue(row, prefix + "cust_ref_no_ctnt").getDataString();
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'HPDP') {
			formObj.hpdp.value = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'OTHR') {
			formObj.othr.value = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'POYN') {
			po_ref_flag = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'DTYN') {
			po_ref_dtl_flag = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
		if (sObject.cellvalue(row, prefix + "bkg_ref_tp_cd") == 'INCO') {
			formObj.inco.value = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");
		}
	}
}

/**
 * 문자를 받아서 3자리마다 콤마를 찍어 반환한다.
 */
String.prototype.comma = function() {
	tmp = this.split('.');
	var str = new Array();
	var v = tmp[0].replace(/,/gi, ''); // 콤마를 빈문자열로 대체
	for ( var i = 0; i <= v.length; i++) { //문자열만큼 루프를 돈다.
		str[str.length] = v.charAt(v.length - i); // 스트링에 거꾸로 담음
		if (i % 3 == 0 && i != 0 && i != v.length) { //첫부분이나, 끝부분에는 콤마가 안들어감
			str[str.length] = '.'; // 세자리마다 점을 찍음 - 배열을 핸들링할때 쉼표가 들어가면 헛갈리므로
		}
	}
	str = str.reverse().join('').replace(/\./gi, ','); // 배열을 거꾸로된 스트링으로 바꾼후에,
	// 점을 콤마로 치환
	return (tmp.length == 2) ? str + '.' + tmp[1] : str;
}

/**
 * 문자를 받아서 YYYY-MM-DD자리마다 콤마를 찍어 반환한다.
 */
String.prototype.getDataString = function(dateFormat) {
	if (this == '')
		return '';
	return this.substring(0, 4) + "-" + this.substring(4, 6) + "-" + this.substring(6, 8);
}

/**
 * SPO No.의 Mandatory Item을 관리한다.
 * 필수값을 체크해서 공백이면 false를 return 
 * 
 */
var man_POB = false; // P/O No (by BKG)
var man_POC = false; // P/O Nl ( by CNTR)
var man_POM = false; // P/O No (by ITEM)
var man_INV = false; // Invoice No.
var man_DPT = false; // Department No
var man_LCN = false; // L/C No
var man_SHP = false; // Ship ID
var man_PRT = false; // Part No
var man_INC = false; // Incoterms
var man_MSL = false; // Load ID (by CNTR)

function filtereMandatory_Item(man_Item) {
	// Mandatory Item String
	var sManItmDesc = "";

	if (man_Item == undefined || man_Item == '')
		return false;
	try {
		var ifilter = man_Item.split(",");
		for ( var inx = 0; inx < ifilter.length; inx++) {
			if ('POB' == ifilter[inx]) {
				man_POB = true;
				sManItmDesc += " P/O No.(by BKG),"
			}
			if ('POC' == ifilter[inx]) {
				man_POC = true;
				sManItmDesc += " P/O No.(by CNTR),"
			} 
			if ('POM' == ifilter[inx]) {
				man_POM = true;
				sManItmDesc += " P/O No.(by Item)," 
			} 
			if ('INV' == ifilter[inx]) {
				man_INV = true;
				sManItmDesc += " Invoice No.," 
			} 
			if ('DPT' == ifilter[inx]) {
				man_DPT = true;
				sManItmDesc += " Department No.," 
			} 
			if ('LCN' == ifilter[inx]) {
				man_LCN = true;
				sManItmDesc += " L/C No.," 
			} 
			if ('SHP' == ifilter[inx]) {
				man_SHP = true;
				sManItmDesc += " Ship ID," 
			} 
			if ('PRT' == ifilter[inx]) {
				man_PRT = true;
				sManItmDesc += " Part No.," 
			} 
			if ('INC' == ifilter[inx]) {
				man_INC = true;
				sManItmDesc += " Incoterms," 
			} 
			if ('MSL' == ifilter[inx]) {
				man_MSL = true;
				sManItmDesc += " Load ID (by CNTR)," 
			}
		}
		
		if (sManItmDesc.length>0) {
			document.all.manItmLayer.style.display = "Inline";
			document.all.vManItm.value = "*Mandatory Item :" + sManItmDesc.substring(0,sManItmDesc.length-1);
			po_cust_flag = 'Y';
		} else {
			document.all.manItmLayer.style.display = "none";
			po_cust_flag = 'N';
		}
		
		
		return true;
	} catch (ex) {
		bkg_error_alert('', ex);
		return false;
	}
}

/**
 * SPO No.의 Mandatory Item을 관리한다.
 * 필수값을 체크해서 공백이면 false를 return 
 * [input Text :공백체크]POB : P/O No (by BKG)
 * [input Text :공백체크]LCN : L/C No
 * [input Text :공백체크]INV : Invoice No.
 * [input Text :공백체크]DPT : Department No
 * [input Text :공백체크]INC : Incoterms
 * [Sheet Text :공백체크]POC : P/O Nl (by CNTR)
 * [Sheet Text :공백체크]POM : P/O No (by ITEM)
 * [Sheet Text :공백체크]MSL : Load ID (by CNTR)
 */
function validate_Mandatory_Item() {
	var formObj = document.form;
	var bkpo = ComGetObjValue(formObj.bkpo);
	var lcno = ComGetObjValue(formObj.lcno);
	var hinv = ComGetObjValue(formObj.hinv);
	var hpdp = ComGetObjValue(formObj.hpdp);
	var inco = ComGetObjValue(formObj.inco);
	
	if (man_POB) {// 공백체크 
		if (bkpo == '') {
			ComShowCodeMessage("BKG00888", "P/O No");
			formObj.bkpo.focus();
			return false;
		}
	}
	if (man_LCN) {
		if (lcno == '') {
			ComShowCodeMessage("BKG00888", "L/C No");
			formObj.lcno.focus();
			return false;
		}
	}
	if (man_INV) {
		if (hinv == '') {
			ComShowCodeMessage("BKG00888", "Invoice No");
			formObj.hinv.focus();
			return false;
		}
	}
	if (man_DPT) {
		if (hpdp == '') {
			ComShowCodeMessage("BKG00888", "Department No");
			formObj.hpdp.focus();
			return false;
		}
	}
	if (man_INC) {
		if (inco == '') {
			ComShowCodeMessage("BKG00888", "Incoterms");
			formObj.inco.focus();
			return false;
		}
	}
	if (man_POC) {
		//P/O Nl ( by CNTR) sheet1의  컬럼값 체크  
		var sObject = sheetObjects[0];
		var prefix = sObject.id + "_";
		var c_row = sObject.LastRow;

		for ( var row = 1; row <= c_row; row++) {
			if ('' == sObject.CellValue(row, prefix + "cust_ref_no_ctnt")) {
				ComShowCodeMessage("BKG00888", sObject.CellValue(row, prefix + "cntr_no") + "  P/O No(by CNTR)");
				sObject.SelectCell(row, prefix + "cust_ref_no_ctnt", true);
				return false;
			}
		}
	}
	if (man_POM) {
		//POM : P/O No (by ITEM) sheet2의 컬럼값 체크 
		var sObject = sheetObjects[1];
		var prefix = sObject.id + "_";
		var c_row = sObject.LastRow;

		for ( var row = 1; row <= c_row; row++) {
			if ('' == sObject.CellValue(row, prefix + "po_no")) {
				ComShowCodeMessage("BKG00888", row + " row P/O No(by ITEM)");
				sObject.SelectCell(row, prefix + "po_no", true);
				return false;
			}
		}
	}
	
	if (man_SHP) {
		var sObject = sheetObjects[2];
		var prefix = sObject.id + "_";
		var c_row = sObject.LastRow;  

		for ( var row = 1; row <= c_row; row++) {
			if ('' == sObject.CellValue(row, prefix + "de_no")) {
				ComShowCodeMessage("BKG00888", "Ship ID(Delivery No.)");
				return false;
			}
		}
	}
	
	if (man_PRT) {
		var sObject = sheetObjects[2];
		var prefix = sObject.id + "_";
		var c_row = sObject.LastRow;  

		for ( var row = 1; row <= c_row; row++) {
			if ('' == sObject.CellValue(row, prefix + "prt_no")) {
				ComShowCodeMessage("BKG00888", "Part No.");
				return false;
			}
		}
	}
	
	if (man_MSL) {
		//P/O Nl ( by CNTR) sheet1의  컬럼값 체크  
		var sObject = sheetObjects[3];
		var prefix = sObject.id + "_";
		var c_row = sObject.LastRow;

		for ( var row = 1; row <= c_row; row++) {
			if ('' == sObject.CellValue(row, prefix + "cust_ref_no_ctnt")) {
				ComShowCodeMessage("BKG00888", sObject.CellValue(row, prefix + "cntr_no") + "  Load ID (by CNTR)");
				sObject.SelectCell(row, prefix + "cust_ref_no_ctnt", true);
				return false;
			}
		}
	}
	return true;
}
/**
 * Sheet관련 프로세스 처리
 * IBSEARCH : //booking no 에 따른 화면 조회
 * SEARCH01:  // PO & Other No에 CM정보를 Copy하기 위해 조회한다
 * IBSAVE:    //저장
 * IBINSERT:  // 입력
 * IBDELETE:  // 삭제
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_", "sheet5_");
	var prefix = sheetObj.id + "_";

	switch (sAction) {
	case IBSEARCH: //booking no 에 따른 화면 조회


		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.				
		ComSetObjValue(formObj.f_cmd, SEARCH);

		// 2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		//BookingNo가 유효하지 않은경우 메세지 처리후 화면을 닫는다.
		var result   = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		
		if (document.form.bkg_no.value != '') {
			if(result == 'F'){
				setSearch_Init_Page1();
				ComShowCodeMessage("BKG00463");// 조회를 위한 BKG no가 없습니다.
				self.close();
			}
		}
		
		// 3.조회후 결과처리
		var arrXml = sXml.split("|$$|");
		for ( var inx = 0; inx < arrXml.length; inx++) {
			sheetObjects[inx].LoadSearchXml(arrXml[inx]);
		}
	
		//4.PO No.의 Mandatory Item을 관리한다.
		var man_Item = ComGetEtcData(arrXml[0], "man_Item");
		if (filtereMandatory_Item(man_Item)) {
		}
		;

		// 5.컨테이너 테이블의 진짜 컨테이너 번호 얻기
		if(sheetObjects[0].RowCount > 0) {
			ComSetObjValue(formObj.cntr_no, sheetObjects[0].CellText(1, prefix + "c_cntr_no"));
			ComSetObjValue(formObj.pck_qty, sheetObjects[0].CellText(1, prefix + "pck_qty").comma());
			ComSetObjValue(formObj.cntr_mf_wgt, sheetObjects[0].CellText(1, prefix + "cntr_mf_wgt").comma());
			ComSetObjValue(formObj.meas_qty, sheetObjects[0].CellText(1, prefix + "meas_qty").comma());
		}
		// 6.화면 구성 초기값 셋팅
		setSearch_Init_Page1();

		var target_value = ComGetObjValue(formObj.cntr_no);
		// 7.container 번호로 필터링 hidden설정
		if (filteredData(sheetObjects[1], "sheet2_cntr_no", target_value)) {
			//2.container 번호로 총합구하기 
			filteredDataSum(sheetObjects[1]);
		}
		//2.container 별로 ship number 구하기 
		// if (filteredData(sheetObjects[2], "sheet3_cntr_no", target_value)) {

		// }
		// Copy from C/M 버튼처리
		if (button_ComBtnDisable(sheetObjects[1])) {
		}


		break;

	case SEARCH01: // PO & Other No에 CM정보를 Copy하기 위해 조회한다

		//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.		
		ComSetObjValue(formObj.f_cmd, SEARCH01);

		// 2.조회조건으로 조회실행
		var sXml = sheetObj.GetSearchXml(URL_ESM_BKG, FormQueryString(formObj) + "&" + ComGetPrefixParam('sheet2_'));

		// 3.조회후 결과처리
		sheetObjects[1].LoadSearchXml(sXml);

		var target_value = ComGetObjValue(formObj.cntr_no);
		// 4.container 번호로 필터링 hidden설정
		if (filteredData(sheetObjects[1], "sheet2_cntr_no", target_value)) {
			//2.container 번호로 총합구하기 
			filteredDataSum(sheetObjects[1]);
		}
		ComBtnDisable("btn2_Copy_from");
		break;

	case IBSAVE: //저장
		//1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.	
		if (!validateForm(sheetObj, formObj, sAction)) { //2015/03/26 양동훈 
			return;
		}// validation check 
		if (!validate_Mandatory_Item()) { 
			return;
		}
		if (setSheetByBkg()) {
		}// 변경값 sheet에 데이터 반영 
		ComSetObjValue(formObj.f_cmd, MULTI);

		// 2.저장조건으로 실행
		var sParam = ComGetSaveString(sheetObjects); // 변경된 sheet문자열

		if (sParam == "")
			return;

		sParam += "&" + FormQueryString(formObj); // hidden param value 문자열
		
		sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix 문자열 배열

		if (!ComShowConfirm(ComGetMsg("BKG00350"))) {
			return;
		}
		
		var sXml = sheetObj.GetSaveXml(URL_ESM_BKG, sParam);

		// 3.저장후 결과처리
		var xml = "<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA></ETC-DATA><MESSAGE></MESSAGE></RESULT>";
		sheetObjects[0].LoadSaveXml(sXml);

		break;

	case IBINSERT: // 입력
		// container no가 없을 경우 row add 불가처리
		if (sheetObjects[0].RowCount == 0 && sheetObj.id == "sheet2")
			return;
		var Row = sheetObj.DataInsert(-1);
		sheetObj.CellValue(Row, sheetObj.id + "_cntr_no") = ComGetObjValue(formObj.cntr_no);
		break;

	case IBDELETE: // 삭제
		// container no가 없을 경우 row delete 불가처리
		if (sheetObjects[0].RowCount == 0 && sheetObj.id == "sheet2")
			return;
		if (sheetObj.FindCheckedRow(prefix + "del_chk") != "") {
			ComRowHideDelete(sheetObj, prefix + "del_chk");
		} else {
			ComShowMessage(ComGetMsg("COM12189"));
			// ComShowCodeMessage("BKG00149",'NOT SELECT');
		}
		filteredDataSum(sheetObjects[1]);

		break;
	}
}
/**
 * Sheet 저장완료 후 이벤트 발생
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH); // unique key 값을 얻어오기위해서
}

/**
 * Package Code 및 Description을 호출 .<br>
 * @param {arry} pck_tp_cd
 */
var current_Row = '';
function sheet2_OnPopupClick(sheetObj, Row, Col) {
	current_Row = Row;
	comBkgCallPop0696("setCallBack0696", sheetObj.CellValue(Row, "sheet2_pck_tp_cd"));
}
/**
 * Package Code 및 Description을 검색 및 조회 .<br>
 * @param {arry} aryPopupData
 */
function setCallBack0696(aryPopupData) {
	sheetObjects[1].CellValue(current_Row, "sheet2_pck_tp_cd") = aryPopupData[0][3];
}

/**
 * Sheet에 booking 정보를 수집하고 저장하여 처리하는 함수 
 */
function setSheetByBkg() {
	var formObj = document.form;
	var v_bkpo = formObj.bkpo.value;
	var v_lcno = formObj.lcno.value;
	var v_hinv = formObj.hinv.value;
	var v_lcdt = formObj.lcdt.value.split('-').join("");
	var v_hpdp = formObj.hpdp.value;
	var v_othr = formObj.othr.value;
	var v_inco = formObj.inco.value;

	try {
		if (!isSheetModify('BKPO', v_bkpo)) { //수정모드
			isSheetInsert('BKPO', v_bkpo);// 신규추가
		}

		if (!isSheetModify('LCNO', v_lcno)) { //수정모드
			isSheetInsert('LCNO', v_lcno);// 신규추가
		}

		if (!isSheetModify('HINV', v_hinv)) { //수정모드
			isSheetInsert('HINV', v_hinv);// 신규추가
		}

		if (!isSheetModify('LCDT', v_lcdt)) { //수정모드
			isSheetInsert('LCDT', v_lcdt);// 신규추가
		}

		if (!isSheetModify('HPDP', v_hpdp)) { //수정모드
			isSheetInsert('HPDP', v_hpdp);// 신규추가
		}

		if (!isSheetModify('OTHR', v_othr)) { //수정모드
			isSheetInsert('OTHR', v_othr);// 신규추가
		}
		
		if (!isSheetModify('INCO', v_inco)) { //수정모드
			isSheetInsert('INCO', v_inco);// 신규추가
		}
	} catch (ex) {
		bkg_error_alert('setSheetByBkg', ex);
		return false;
	}

	return true;
}
 /**
  * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
  **/
 function obj_activate() {
 	//입력Validation 확인하기
 	switch (event.srcElement.name) {
 		case "lcdt":
 			ComClearSeparator(event.srcElement);
 			break;	
 		default:
 			break;
 	}	
 }
 /**
  * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
  **/
 function obj_deactivate() {
 	 var formObj = document.form;
 		
 	// 입력Validation 확인하기
 	switch (event.srcElement.name) {
		case "lcdt":
			ComAddSeparator(event.srcElement);
			break;
		default:
			break;
	}
}
/**
 * Sheet의 데이터값 존재시 추가모드로 처리하는 함수 
 * param :_var1,_var2  = 구분값, 데이터값
 */
function isSheetInsert(_var1, _var2) {
	var formObj = document.form;
	var sObject = sheetObjects[4];
	var prefix = 'sheet5_';

	try {
		var row = sObject.DataInsert(-1);
		sObject.CellValue(row, prefix + "bkg_no") = formObj.bkg_no.value;
		sObject.CellValue(row, prefix + "bkg_ref_tp_cd") = _var1;
		sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
	} catch (ex) {
		bkg_error_alert('isSheetInsert', ex);
		return false;
	}
}

/**
 * Sheet의 데이터값 존재시 수정모드로 수정하도록 처리하는 함수 
 */
function isSheetModify(_var1, _var2) {
	var sObject = sheetObjects[4];
	var prefix = 'sheet5_';
	var r_flag = false;
	var c_row = sObject.LastRow;

	try {
		for ( var row = 1; row <= c_row; row++) {
			//update
			var v_bkg_ref_tp_cd = sObject.cellvalue(row, prefix + "bkg_ref_tp_cd");
			var v_cust_ref_no_ctnt = sObject.CellValue(row, prefix + "cust_ref_no_ctnt");

			if (_var1 == 'BKPO' && v_bkg_ref_tp_cd == 'BKPO') {
				if (v_cust_ref_no_ctnt != _var2) {
					sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
					sObject.RowStatus(row) = "U";
				} else {
					sObject.RowStatus(row) = "R";
				}
				r_flag = true;
				break;
			}
			if (_var1 == 'LCNO' && v_bkg_ref_tp_cd == 'LCNO') {
				if (v_cust_ref_no_ctnt != _var2) { //alert('update LCNO'+row);
					sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
					sObject.RowStatus(row) = "U";
				} else {
					sObject.RowStatus(row) = "R";
				}
				r_flag = true;
				break;
			}
			if (_var1 == 'HINV' && v_bkg_ref_tp_cd == 'HINV') {
				if (v_cust_ref_no_ctnt != _var2) { //alert('update HINV'+row);
					sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
					sObject.RowStatus(row) = "U";
				} else {
					sObject.RowStatus(row) = "R";
				}
				r_flag = true;
				break;
			}
			if (_var1 == 'LCDT' && v_bkg_ref_tp_cd == 'LCDT') {
				if (v_cust_ref_no_ctnt != _var2) { //alert('update LCDT'+row);
					sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
					sObject.RowStatus(row) = "U";
				} else {
					sObject.RowStatus(row) = "R";
				}
				r_flag = true;
				break;
			}
			if (_var1 == 'HPDP' && v_bkg_ref_tp_cd == 'HPDP') {
				if (v_cust_ref_no_ctnt != _var2) { //alert('update HPDP'+row);
					sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
					sObject.RowStatus(row) = "U";
				} else {
					sObject.RowStatus(row) = "R";
				}
				r_flag = true;
				break;
			}
			if (_var1 == 'OTHR' && v_bkg_ref_tp_cd == 'OTHR') {
				if (v_cust_ref_no_ctnt != _var2) { //alert('update OTHR'+row);
					sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
					sObject.RowStatus(row) = "U";
				} else {
					sObject.RowStatus(row) = "R";
				}
				r_flag = true;
				break;
			}
			if (_var1 == 'INCO' && v_bkg_ref_tp_cd == 'INCO') {
				if (v_cust_ref_no_ctnt != _var2) { //alert('update INCO'+row);
					sObject.CellValue(row, prefix + "cust_ref_no_ctnt") = _var2;
					sObject.RowStatus(row) = "U";
				} else {
					sObject.RowStatus(row) = "R";
				}
				r_flag = true;
				break;
			}
		}
	} catch (ex) {
		bkg_error_alert('isSheetModify', ex);
		return false;
	}
	return r_flag;
}

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
	var sheetObject4 = sheetObjects[3];
	var sheetObject5 = sheetObjects[4];
	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn1_Row_Add":
			doActionIBSheet(sheetObject2, formObject, IBINSERT);
			break;

		case "btn2_Row_Add":
			doActionIBSheet(sheetObject3, formObject, IBINSERT);
			break;

		case "btn1_Row_Delete":
			doActionIBSheet(sheetObject2, formObject, IBDELETE);
			break;

		case "btn2_Row_Delete":
			doActionIBSheet(sheetObject3, formObject, IBDELETE);
			break;

		case "btn2_Copy_from":
			if (ComIsBtnEnable("btn2_Copy_from"))
				doActionIBSheet(sheetObject1, formObject, SEARCH01);
			break;
			
		case "btn2_Copy_Desc":
			copyToDescShip();
			break;

		case "btn_Save":
			doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;

		case "btn_Calendar": //calender button
			var cal = new ComCalendar();
			cal.select(formObject.lcdt, 'yyyy-MM-dd');
			break;

		case "btn_Close":
			self.close();
			break;
		} // end switch
	} catch (ex) {
		if (ex == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			alert(ex);
		}
		bkg_error_alert('', ex);
	}
}

/**
 * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
 **/
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "int":
		//숫자 만입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;
	case "float":
		//숫자+"."입력하기
		ComKeyOnlyNumber(event.srcElement, ".");
		break;
	default:
		//숫자만입력하기
		ComKeyOnlyNumber(event.srcElement);
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) { //2015/03/26 양동훈 수정
	with (formObj) {
		if (sAction == IBSAVE) {
			//저장시 각시트별 중복체크   
			if (sheetObjects[2].IsDataModified) {
				//var Row = sheetObj.ColValueDup("eq_cedex_otr_cd|eq_cedex_otr_tp_cd"); 
				// if(Row > 0){
				// ComShowCodeMessage("MNR00006",i + 1 + "번째 시트의 " + Row + "행에
				// ");
				// sheetObj.CellValue2(Row, "eq_cedex_otr_cd") = "";
				// sheetObj.SelectCell(Row, "eq_cedex_otr_cd", true);
				// return false;
				// }
//				alert(sheetObjects[2].CellValue(1,1)); 이 값들을 가져와야됨
//				alert(sheetObjects[2].CellValue(1,2));
				
				//[CHM-201640641] 처리로 인해 아래 로직 주석처리
//				for(var ir=sheetObjects[2].HeaderRows ;ir<=sheetObjects[2].RowCount ;ir++ ){
//					if(ComIsEmpty(sheetObjects[2].CellValue(ir,"sheet3_de_no"))
//						&&ComIsEmpty(sheetObjects[2].CellValue(ir,"sheet3_prt_no"))){
//						ComShowCodeMessage("BKG00445", "Ship ID or Part No");//"Mandatory Input item(s) is(are) missing: {?msg1}"
//						return false;
//					}
//				}
			}
		}
	}
	return true;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "P/O No by CNTR / Item", -1);
			InsertTab(cnt++, "Ship ID", -1);
			InsertTab(cnt++, "Load ID", -1);
		}
		break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;
}

function bkg_error_alert(msg, ex) {
	alert('[ ' + msg + ' ] = [ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function copyToDesc(chkObj) {
	// 0.선택한 값을 parent창에 값을 넘겨준다.
	var result_msg = '';

    if (chkObj.checked) {
		if (chkObj.name == "check_bkpo") {
			result_msg = result_msg + "\n P/O No:" + form.bkpo.value;			
		}
		if (chkObj.name == "check_lcno") {
			result_msg = result_msg + "\n L/C No:" + form.lcno.value;
		}
		if (chkObj.name == "check_hinv") {
			result_msg = result_msg + "\n Invoice No:" + form.hinv.value;
		}
		if (chkObj.name == "check_lcdt") {
			result_msg = result_msg + "\n L/C Date:" + form.lcdt.value;
		}
		if (chkObj.name == "check_hpdp") {
			result_msg = result_msg + "\n Department No:" + form.hpdp.value;
		}
		if (chkObj.name == "check_othr") {
			result_msg = result_msg + "\n Other Ref. No:" + form.othr.value;
		}	
		if (chkObj.name == "check_inco") {
			result_msg = result_msg + "\n Incoterms:" + form.inco.value;
		}		
		
		// 저장시 M&D 호출하여 버튼색 및 Description에 추가
		if (result_msg.length > 0) {
			if (form.all.callback_func.value != '') {
				eval('opener.'+form.all.callback_func.value)(po_cust_flag, po_ref_flag, po_ref_dtl_flag, result_msg);
			}
		}
    }
}


/**
 * 셀의 값이 변경되었을때 발생하는 이벤트 <br>
 * 
 * @param {ibsheet}
 *            sheetObject IBSheet Object
 * @param {ibsheet}
 *            Row sheetObj의 선택된 Row
 * @param {ibsheet}
 *            Col sheetObj의 선택된 Col
 * @param {String}
 *            Value sheetObj의 입력값
 */
function copyToDescShip() {
	var prefix = 'sheet3_';
	var ship_result_msg = '';
	var part_result_msg = '';
	var ship_ref_result_msg = '';
	var result_msg = '';

	for(var i=0; i < sheetObjects[2].Rows; i++)
	if (sheetObjects[2].cellvalue(i, prefix + "del_chk") == 1) {
		ship_result_msg = ship_result_msg + sheetObjects[2].CellValue(i, prefix + "de_no") + ",";
		part_result_msg = part_result_msg + sheetObjects[2].CellValue(i, prefix + "prt_no") + ",";	
		ship_ref_result_msg = ship_ref_result_msg + sheetObjects[2].CellValue(i, prefix + "shp_ref_no") + ",";	
	}
	// 저장시 M&D 호출하여 버튼색 및 Description에 추가
	if (form.all.callback_func.value != '') {
		if (ship_result_msg.length > 0){
			ship_result_msg = "\n Ship ID:" + ship_result_msg.substring(0, ship_result_msg.length -1);
		}
		
		if (part_result_msg.length > 0){
			part_result_msg = "\n Part No:" + part_result_msg.substring(0, part_result_msg.length -1);
		}
		
		if (ship_ref_result_msg.length > 0){
			ship_ref_result_msg = "\n Ship Ref No:" + ship_ref_result_msg.substring(0, ship_ref_result_msg.length -1);
		}
		
		result_msg =  ship_result_msg + part_result_msg + ship_ref_result_msg;
		
		if (result_msg.length > 0)
			eval('opener.'+form.all.callback_func.value)(po_cust_flag, po_ref_flag, po_ref_dtl_flag, result_msg);
	}
}


function form1_onChange() {
	var srcName = event.srcElement.getAttribute("name");
	switch(srcName){
		case "bkpo":
			var cVal = event.srcElement.value;
			if(cVal!='' && man_POB && man_POC){

				var sObject = sheetObjects[0];
				var prefix = sObject.id + "_";
				var c_row = sObject.LastRow;

				for ( var row = 1; row <= c_row; row++) {
					if ('' != sObject.CellValue(row, prefix + "cntr_no") && '' == sObject.CellValue(row, prefix + "cust_ref_no_ctnt")) {
						sObject.CellValue2(row, prefix + "cust_ref_no_ctnt") = cVal;
					}
				}
			} 
			break;
	}

}

/* 개발자 작업  끝 */