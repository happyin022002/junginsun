/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_6061.js
 *@FileTitle : RFA Quotation - Rate Adjust
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.19
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2009.08.19 송민석
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
 * @class ESM_PRI_6061 : ESM_PRI_6061 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_6061() {
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
var OPERATING_ADD_ROW = 1;
var OPERATING_DELETE_ROW = 2;
var OPERATING_COPY_ROW = 3;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return 없음
 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
			if (getButtonTable(srcName).disabled) {
				return false;
			}
		}

		switch (srcName) {

		case "btn_Add":
			doActionIBSheet(sheetObject2, formObject, IBINSERT);
			break;
		case "btn_Copy":
			doActionIBSheet(sheetObject2, formObject, IBCOPYROW);
			break;

		case "btn_Delete":
			doActionIBSheet(sheetObject2, formObject, IBDELETE);
			break;

		case "btn1_Add":
			doActionIBSheet(sheetObject3, formObject, IBINSERT);
			break;
		case "btn1_Copy":
			doActionIBSheet(sheetObject3, formObject, IBCOPYROW);
			break;

		case "btn1_Delete":
			doActionIBSheet(sheetObject3, formObject, IBDELETE);
			break;

		case "btn_Save":
			break;

		case "btn1_OK":
			doActionIBSheet(sheetObject2, formObject, IBSAVE);
			break;

		case "btn1_Close":
			self.close();
			break;

		case "rate_adjust":
			chageRateAdjustRadio();
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} sheet_obj 필수, sheet Object
 * @return 없음
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @return 없음
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		// khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
	}
	ComOpenWait(true);
	chageRateAdjustRadio();
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	ComOpenWait(false);
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {String} sheetNo 필수, sheet의 ID
 * @return 없음
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	sheetObj.WaitImageVisible = false;

	switch (sheetObj.id) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 125;
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
			InitRowInfo(1, 1, 15, 100);

			var HeadTitle1 = "|Seq.|Commodity Group|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
			// SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");

			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 0, daLeft, true, "cmdt_nm", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);

			CountPosition = 0;
		}
		break;

	case "sheet2": // sheet2 init
		with (sheetObj) {

			// 높이 설정
			style.height = 105;
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

			var HeadTitle1 = "|Seq.|Application|Origin|Origin Term|O.Via|D.Via|Dest.|Dest. Term|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|matching_pnt|parents_seq|hiddencheck";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
			// SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");

			InitDataProperty(0, cnt++, dtSeq, 40, daCenter, true, "seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 85, daCenter, true, "application", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "ori_loc_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, true, "ori_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "ori_via_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "dest_via_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true, "dest_loc_def_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, true, "dest_term_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "matching_pnt", false, "", dfInteger, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "parents_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 0, daLeft, true, "hiddencheck", false, "", dfInteger, 0, true, true);

			CountPosition = 0;
			ColHidden("seq") = true;
			ColHidden("hiddencheck") = true;

			InitDataCombo(0, "ori_loc_def_cd", appendDefaultData(oriLocText), appendDefaultData(oriLocValue));
			InitDataCombo(0, "dest_loc_def_cd", appendDefaultData(destLocText), appendDefaultData(destLocValue));
			InitDataCombo(0, "ori_via_def_cd", appendDefaultData(oriViaText), appendDefaultData(oriViaValue));
			InitDataCombo(0, "dest_via_def_cd", appendDefaultData(destViaText), appendDefaultData(destViaValue));

			InitDataCombo(0, "application", applicationText, applicationValue);
			InitDataCombo(0, "ori_term_cd", appendDefaultData(receiveTermText), appendDefaultData(receiveTermValue));
			InitDataCombo(0, "dest_term_cd", appendDefaultData(destTermText), appendDefaultData(destTermValue));
		}
		break;

	case "sheet3": // sheet3 init
		with (sheetObj) {

			// 높이 설정
			style.height = 105;
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

			var HeadTitle1 = "|Seq.|Per|Cargo Type|Currency|Amount(+/-)|Percentage(+/-)|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|parents_seq|hiddencheck";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT,
			// SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true, "ibflag");

			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, "seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 40, daCenter, true, "per", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 70, daCenter, true, "cargo", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCombo, 70, daCenter, true, "currency", true, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtImageText, 0, daCenter, true, "amount", false, "", dfNullFloat, 2, true, true);
			InitDataProperty(0, cnt++, dtImageText, 0, daCenter, true, "percent", false, "", dfNullFloat, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "qttn_ver_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "gen_spcl_rt_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "cmdt_hdr_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 0, daLeft, true, "parents_seq", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtCheckBox, 0, daLeft, true, "hiddencheck", false, "", dfInteger, 0, true, true);

			CountPosition = 0;

			ColHidden("seq") = true;
			ColHidden("hiddencheck") = true;

			InitDataCombo(0, "per", appendDefaultData(perText), appendDefaultData(perValue));
			InitDataCombo(0, "cargo", appendDefaultData(cargoText), appendDefaultData(cargoValue));
			InitDataCombo(0, "currency", (currencyText), (currencyValue));
			// ImageList 속성을 사용하여 이미지를 이미 생성함
			ImageList("myImage1") = KeyFieldImage;
			CellImage(0, "amount") = "myImage1";
			CellImage(0, "percent") = "myImage1";
		}
		break;

	}
}

/**
 * sheet에 관련된 실제 Action(Retrieve, Add, Delete)을 일으키는 함수 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {object} formObj 필수, html document form Object
 * @param {int} sAction 필수, action의 구분
 * @return 없음
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		if (sheetObj.id == "sheet1") {
			formObj.f_cmd.value = SEARCH01;
			var params = FormQueryString(formObj);
			sheetObj.DoSearch("ESM_PRI_6061GS.do", params);
		}
		ComOpenWait(false);
		break;

	case IBSAVE: // 저장
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		ComOpenWait(true);
		formObj.f_cmd.value = MULTI;
		var sParam = FormQueryString(formObj);
		var sParamSheet1 = sheetObjects[1].GetSaveString(true);
		var sParamSheet2 = sheetObjects[2].GetSaveString(true);
		if (sParamSheet1 == "")
			return;
		if (sParamSheet2 == "")
			return;
		if (sParamSheet1 != "") {
			sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
		}
		if (sParamSheet2 != "") {
			sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
		}

		var sXml = sheetObjects[1].GetSaveXml("ESM_PRI_6061GS.do", sParam);
		sheetObjects[1].LoadSaveXml(sXml);
		var result = sheetObjects[1].EtcData("TRANS_RESULT_KEY");
		if (result == "S") {
			window.returnValue = "SUCCESS"
			self.close();
		}
		ComOpenWait(false);

		break;
	case IBINSERT: // 입력
		processOperatingSheet(sheetObj, OPERATING_ADD_ROW);
		break;
	case IBDELETE: // 삭제
		if (!validateForm(sheetObj, document.form, sAction)) {
			return false;
		}
		processOperatingSheet(sheetObj, OPERATING_DELETE_ROW);
		break;
	case IBCOPYROW: // 입력

		processOperatingSheet(sheetObj, OPERATING_COPY_ROW);
		break;
	}
}

/**
 * 입력받은 값에 default string을 붙여서 return한다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * InitDataCombo(0, &quot;currency&quot;, appendDefaultData(currencyText), appendDefaultData(currencyValue));
 * </pre>
 * 
 * @param {string} str 필수, Combo code에서 쓸 코드 string
 * @return string, default를 붙인 string
 */
function appendDefaultData(str) {
	return " |" + str;
}

/**
 * sheet에 row insert할때 기본으로 assign되어야 할값을 form에서 부터<BR>
 * assign한다
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * setInitDataToSheet(row, sheetObj, formObj);
 * </pre>
 * 
 * @param {int} idx 필수, 작업할 row index
 * @param {object} sheetObj 필수, sheet Object
 * @param {object} formObj 필수, HTML Form Object
 * @return 없음
 */
function setInitDataToSheet(idx, sheetObj, formObj) {
	var sheetObject1 = sheetObjects[0];
	sheetObj.CellValue2(idx, "qttn_no") = sheetObject1.CellValue(sheetObject1.SelectRow, "qttn_no");
	sheetObj.CellValue2(idx, "qttn_ver_no") = sheetObject1.CellValue(sheetObject1.SelectRow, "qttn_ver_no");
	sheetObj.CellValue2(idx, "gen_spcl_rt_tp_cd") = sheetObject1.CellValue(sheetObject1.SelectRow, "gen_spcl_rt_tp_cd");
	sheetObj.CellValue2(idx, "cmdt_hdr_seq") = sheetObject1.CellValue(sheetObject1.SelectRow, "cmdt_hdr_seq");

	if (sheetObj.id == "sheet2") {
		sheetObj.CellValue2(idx, "parents_seq") = sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "seq");
		searchLocViaCd(sheetObj, sheetObj.SelectRow, "", "ori_loc_def_cd");
		searchLocViaCd(sheetObj, sheetObj.SelectRow, "", "ori_via_def_cd");
		searchLocViaCd(sheetObj, sheetObj.SelectRow, "", "dest_loc_def_cd");
		searchLocViaCd(sheetObj, sheetObj.SelectRow, "", "dest_via_def_cd");
		searchLocViaCd(sheetObj, sheetObj.SelectRow, "", "ori_term_cd");
		searchLocViaCd(sheetObj, sheetObj.SelectRow, "", "dest_term_cd");
	} else if (sheetObj.id == "sheet3") {
		sheetObj.CellValue2(idx, "parents_seq") = sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "seq");
		sheetObj.CellValue2(idx, "currency") = "USD";
	}

}
/**
 * sheet에 데이터가 add,delete,copy 됐을때 공통적으로<BR>
 * 해야 할 작업을 진생시켜준다.
 * 
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * processOperatingSheet(sheetObj, OPERATING_COPY_ROW);
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} operatingTP 필수, 작업구분 코드 <br>
 *            OPERATING_ADD_ROW = 1 <br>
 *            OPERATING_DELETE_ROW = 2 <br>
 *            OPERATING_COPY_ROW = 3 <br>
 * @return 없음
 */
function processOperatingSheet(sheetObj, operatingTP) {
	var formObj = document.form;
	switch (operatingTP) {
	case OPERATING_ADD_ROW:
		if (sheetObj.id == "sheet2") {
			parentsSheetObj = sheetObjects[0];
		} else if (sheetObj.id == "sheet3") {
			parentsSheetObj = sheetObjects[1];
		}

		var operating_value = sheetObj.DataInsert(-1);
		var row = operating_value;
		var parentsSheetObj;
		if (sheetObj.id == "sheet2") {
			setInitDataToSheet(row, sheetObj, formObj);
			filteringSheet(sheetObjects[1], sheetObjects[2], sheetObjects[1].CellValue(row, "seq"), "parents_seq");
			parentsSheetObj = sheetObjects[0];

		} else if (sheetObj.id == "sheet3") {
			setInitDataToSheet(row, sheetObj, formObj);
			parentsSheetObj = sheetObjects[1];
			if (parentsSheetObj.CellValue(parentsSheetObj.SelectRow, "application") == "E") {
				sheetObj.CellValue2(row, "amount") = "0.00";
				sheetObj.CellValue2(row, "percent") = "0.00";
				sheetObj.CellEditable(row, "currency") = false;
				sheetObj.CellEditable(row, "amount") = false;
				sheetObj.CellEditable(row, "percent") = false;
			}

		}
		setHighlightSheet(parentsSheetObj, sheetObj, sheetObj.CellValue(row, "parents_seq"));
		break;

	case OPERATING_DELETE_ROW:

		var operating_value = sheetObj.CellValue(sheetObj.SelectRow, "seq");
		var parentsSheetObj;
		sheetObj.RowDelete();

		if (sheetObj.id == "sheet2") {
			deleteChildRows(sheetObjects[2], operating_value);
			filteringSheet(sheetObjects[1], sheetObjects[2], sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "seq"), "parents_seq");
			parentsSheetObj = sheetObjects[0];
		} else if (sheetObj.id == "sheet3") {
			parentsSheetObj = sheetObjects[1];
		}
		setHighlightSheet(parentsSheetObj, sheetObj, parentsSheetObj.CellValue(parentsSheetObj.SelectRow, "seq"));
		break;
	case OPERATING_COPY_ROW:
		var operating_value = sheetObj.DataCopy();
		if (sheetObj.id == "sheet2") {
			hideSheetData(sheetObjects[2]);
			ComSheetFiltering(sheetObjects[2], sheetObjects[1].CellValue(operating_value, "seq"), "parents_seq", false, false);
		}
		break;
	}
	changeButtonStatus();

}

/**
 * 자식 sheet에 데이터가 1건이라도 있다면 부모 sheet의 해당 row를<BR>
 * highlight 시킨다.<BR>
 * 
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * setHighlightSheet(parentsSheetObj, sheetObj, parentsSheetObj.CellValue(parentsSheetObj.SelectRow, &quot;seq&quot;));
 * </pre>
 * 
 * @param {object} parentsSheetObj 필수, sheetObj의 부모 sheet Object
 * @param {object} sheetObj 필수, sheet Object
 * @param {string} parents_key 필수, sheetObj와 연결된 parentsSheetObj의 key값 <br>
 * @return 없음
 */
function setHighlightSheet(parentsSheetObj, sheetObj, parents_key) {
	var row = sheetObj.FindText("parents_seq", parents_key)
	var p_row = parentsSheetObj.FindText("seq", parents_key)
	if (row >= 0) {// hightlight시킴
		parentsSheetObj.RowBackColor(p_row) = parentsSheetObj.RgbColor(255, 255, 180);
	} else {
		parentsSheetObj.RowBackColor(p_row) = parentsSheetObj.RgbColor(255, 255, 255);
	}
}

/**
 * Unit radio 선택에 따라 sheet의 입력 column을 변화시킨다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * chageRateAdjustRadio();
 * </pre>
 * 
 * @return 없음
 */
function chageRateAdjustRadio() {
	var formObj = document.form;
	var sheetObj = sheetObjects[2];
	var code = ComPriGetCheckedRadioButtonValue(formObj.rate_adjust);
	if (code == "AMT") {
		sheetObj.ColHidden("percent") = true;
		sheetObj.ColHidden("amount") = false;
		sheetObj.ColHidden("currency") = false;
	} else {
		sheetObj.ColHidden("percent") = false;
		sheetObj.ColHidden("amount") = true;
		sheetObj.ColHidden("currency") = true;
	}
}

/**
 * sheet1, sheet2,sheet3의 경우 서로 부모 자식의 관계 sheet인데<BR>
 * 부모의 선택된 row가 변경되면 그에 따라 자식 sheet의 선택 내용도<BR>
 * 변경시켜준다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * goToRowOfSheet(&quot;sheet2&quot;, parents_row);
 * </pre>
 * 
 * @param {string} targetSheetId 필수, sheet Object의 name
 * @param {int} row 필수, row index
 * @return 없음
 */
function goToRowOfSheet(targetSheetId, row) {
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var sheetObj3 = sheetObjects[2];

	switch (targetSheetId) {
	case "sheet1":
		var parents_seq = sheetObj2.CellValue(row, "parents_seq");
		var parents_row = sheetObj1.FindText("seq", parents_seq);
		sheetObj1.SelectRow = parents_row;
		sheet1_OnClick(sheetObj1, parents_row, "seq", "")
		break;
	case "sheet2":
		sheetObj2.SelectRow = row;
		sheet2_OnClick(sheetObj2, row, "seq", "");
		break;
	case "sheet3":
		sheetObj3.SelectRow = row;
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
 * <b>Example :</b>
 * 
 * <pre>
 *      if (!validateForm(sheetObj,document.form,sAction)) {
 *          return false;
 *       }
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {object} formObj 필수, html document form Object
 * @param {int} sAction 필수, action의 구분
 * 
 * @return boolean, true: 유효, false: 비유효
 */
function validateForm(sheetObj, formObj, sAction) {

	switch (sAction) {
	case IBSAVE:
		if (sheetObj.id == "sheet2") {
			var sheetObj1 = sheetObjects[0];
			var sheetObj2 = sheetObjects[1];
			var sheetObj3 = sheetObjects[2];
			// 중복체크(sheet1)시작
			var colNames = "application|ori_loc_def_cd|ori_term_cd|ori_via_def_cd|dest_via_def_cd|dest_loc_def_cd|dest_term_cd|qttn_no|qttn_ver_no|gen_spcl_rt_tp_cd|cmdt_hdr_seq|matching_pnt|parents_seq";
			var dupRow = sheetObj2.ColValueDup(colNames, false);
			if (dupRow >= 0) {
				goToRowOfSheet("sheet1", dupRow);
				goToRowOfSheet("sheet2", dupRow);
				ComShowCodeMessage("PRI00302");
				return false;
			}
			// 중복체크(sheet1)종료

			// 자식 node가 없는 row 체크 시작
			var sheetCnt = sheetObj2.RowCount;
			for ( var i = sheetObj2.HeaderRows; i <= sheetCnt; i++) {
				var seq = sheetObj2.CellValue(i, "seq");
				var parents_row = sheetObj3.FindText("parents_seq", seq);
				if (parents_row < 0) {
					goToRowOfSheet("sheet1", i);
					goToRowOfSheet("sheet2", i);
					ComShowCodeMessage("PRI00007");
					return false;
				}
			}
			// 자식 node가 없는 row 체크 종료

			// 중복체크(sheet2) 시작
			sheetCnt = sheetObj3.RowCount;
			for ( var i = sheetObj3.HeaderRows; i <= sheetCnt; i++) {
				var parents_seq = sheetObj3.CellValue(i, "parents_seq");
				var per = sheetObj3.CellValue(i, "per").trim();
				var cargo = sheetObj3.CellValue(i, "cargo").trim();
				for ( var j = i + 1; j <= sheetCnt; j++) {
					var parents_seq2 = sheetObj3.CellValue(j, "parents_seq");
					var per2 = sheetObj3.CellValue(j, "per").trim();
					var cargo2 = sheetObj3.CellValue(j, "cargo").trim();
					if (parents_seq == parents_seq2) {
						if ((per == per2 && cargo == cargo2) || (per == "" && cargo == "") || (per2 == "" && cargo2 == "")) {
							var parents_row = sheetObj3.CellValue(j, "parents_seq");
							goToRowOfSheet("sheet1", parents_row);
							goToRowOfSheet("sheet2", parents_row);
							goToRowOfSheet("sheet3", j);
							ComShowCodeMessage("PRI00302");
							return false;
						}
					}
				}
			}
			// 중복체크(sheet2) 종료

			// 필수입력체크(sheet3) 시작
			var rate_adjust = ComPriGetCheckedRadioButtonValue(formObj.rate_adjust);

			sheetCnt = sheetObj3.RowCount;
			for ( var i = sheetObj3.HeaderRows; i <= sheetCnt; i++) {
				if (sheetObj3.CellEditable(i, "amount") == false) {// edit가 불가능 하면 필수 입력체크를 생략한다.
					continue;
				}
				if (rate_adjust == "AMT") {
					var amount = sheetObj3.CellValue(i, "amount");
					var currency = sheetObj3.CellValue(i, "currency").trim();
					if (amount == "") {
						var parents_row = sheetObj3.CellValue(i, "parents_seq");
						goToRowOfSheet("sheet1", parents_row);
						goToRowOfSheet("sheet2", parents_row);
						sheetObj3.SelectCell(i, "amount");
						ComShowCodeMessage("PRI08010", i, "Amount");
						return false;
					} else if (currency == "") {
						var parents_row = sheetObj3.CellValue(i, "parents_seq");
						goToRowOfSheet("sheet1", parents_row);
						goToRowOfSheet("sheet2", parents_row);
						sheetObj3.SelectCell(i, "currency");
						ComShowCodeMessage("PRI08010", i, "Currency");
						return false;
					}
				} else {
					var percent = sheetObj3.CellValue(i, "percent")
					if (percent == "") {
						var parents_row = sheetObj3.CellValue(i, "parents_seq");
						goToRowOfSheet("sheet1", parents_row);
						goToRowOfSheet("sheet2", parents_row);
						sheetObj3.SelectCell(i, "percent");
						ComShowCodeMessage("PRI08010", i, "Percent");
						return false;
					}
				}
			}
			// 필수입력체크(sheet3) 종료
		}
		break;

	}

	return true;
}

/**
 * sheet의 모든 row를 hidden 시킨다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * hideSheetData(sheetObjects[2]);
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @return 없음
 */
function hideSheetData(sheetObj) {
	for ( var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
		sheetObj.RowHidden(i) = true;
	}
}

/**
 * sheet에서 조건에 맞는 row를 모두 삭제 한다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * deleteChildRows(sheetObjects[2], operating_value);
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {string} parents_seq 필수, 삭제할 seq
 * @return 없음
 */
function deleteChildRows(sheetObj, parents_seq) {

	var row = 0;
	while (true) {
		row = sheetObj.FindText("parents_seq", parents_seq);
		if (row < 0)
			break;
		sheetObj.RowDelete(row, false);
	}
}

/**
 * sheet에서 조건에 맞는 값을 찾아 그 row를 선택된 상태로 만든다.<BR>
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * selectFirstRow(sheetObj, value, col)
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {string} value 필수, 검색할 값
 * @param {string} col 필수, 검색할 column
 * @return 없음
 */
function selectFirstRow(sheetObj, value, col) {
	var row = sheetObj.FindText(col, value);
	if (row >= 0)
		sheetObj.SelectRow = row;
}

/**
 * sheet에서 조건에 맞는 값을 찾아 그 row를 선택된 상태로 만든다.<BR>
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * filteringSheet(sheetObjects[1], sheetObjects[2], sheetObjects[1].CellValue(sheetObjects[1].SelectRow, &quot;seq&quot;), &quot;parents_seq&quot;);
 * </pre>
 * 
 * @param {object} parentsSheetObj 필수, sheetObj의 부모 sheet Object
 * @param {object} sheetObj 필수, sheet Object
 * @param {string} value 필수, sheetObj와 연결된 parentsSheetObj의 key값 <br>
 * @param {string} col 필수, 검색할 column name <br>
 * 
 * @return 없음
 */
function filteringSheet(parentsSheetObj, sheetObj, value, col) {
	hideSheetData(sheetObj);
	// 부모 sheet의 선택된 row가 없다면 실행하지 않는다.
	if (parentsSheetObj.SelectRow != -1) {
		// select된 row가 hidden되어 있다면 실행하지 않는다.
		var isHidden = parentsSheetObj.RowHidden(parentsSheetObj.SelectRow)
		if (isHidden == false) {
			ComSheetFiltering(sheetObj, value, col, false, false);
			selectFirstRow(sheetObj, value, col)
		}
	}
}

/**
 * 조건에 맞춰 Location code들을 검색한다.<BR>
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * searchLocViaCd(sheetObj, row, col, &quot;ori_loc_def_cd&quot;);
 * searchLocViaCd(sheetObj, row, col, &quot;dest_loc_def_cd&quot;);
 * searchLocViaCd(sheetObj, row, col, &quot;ori_via_def_cd&quot;);
 * searchLocViaCd(sheetObj, row, col, &quot;ori_term_cd&quot;);
 * searchLocViaCd(sheetObj, row, col, &quot;dest_term_cd&quot;);
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} row 필수, row index
 * @param {string} col 필수, 검색할 column name
 * @param {string} changeColName 필수, 변경된 combo의 name
 * 
 * @return 없음
 */
function searchLocViaCd(sheetObj, row, col, changeColName) {
	var formObj = document.form;
	var params;
	var opTpCd;
	var org_dest_tp_cd;
	var ori_loc_def_cd = sheetObj.CellValue(row, "ori_loc_def_cd");
	var dest_loc_def_cd = sheetObj.CellValue(row, "dest_loc_def_cd");
	var ori_via_def_cd = sheetObj.CellValue(row, "ori_via_def_cd");
	var dest_via_def_cd = sheetObj.CellValue(row, "dest_via_def_cd");
	var isShowCd = false;
	formObj.f_cmd.value = COMMAND01;

	params = FormQueryString(formObj);

	switch (changeColName) {
	case "ori_loc_def_cd":
		opTpCd = "A";
		org_dest_tp_cd = "O";
		ori_loc_def_cd = "";
		break;
	case "dest_loc_def_cd":
		opTpCd = "A";
		org_dest_tp_cd = "D";
		dest_loc_def_cd = "";
		break;
	case "ori_via_def_cd":
		opTpCd = "B";
		org_dest_tp_cd = "O";
		ori_via_def_cd = "";
		break;
	case "dest_via_def_cd":
		opTpCd = "B";
		org_dest_tp_cd = "D";
		dest_via_def_cd = "";
		break;
	case "ori_term_cd":
		opTpCd = "C";
		org_dest_tp_cd = "O";
		dest_via_def_cd = "";
		// isShowCd = true;
		break;
	case "dest_term_cd":
		opTpCd = "C";
		org_dest_tp_cd = "D";
		dest_via_def_cd = "";
		break;

	}
	params += "&org_dest_tp_cd=" + org_dest_tp_cd;
	params += "&ori_loc_def_cd=" + ori_loc_def_cd;
	params += "&dest_loc_def_cd=" + dest_loc_def_cd;
	params += "&ori_via_def_cd=" + ori_via_def_cd;
	params += "&dest_via_def_cd=" + dest_via_def_cd;
	params += "&op_tp_cd=" + opTpCd;
	params += "&cmdt_hdr_seq=" + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cmdt_hdr_seq");

	var sXml = sheetObj.GetSearchXml("ESM_PRI_6061GS.do", params);

	var comboData = ComPriXml2Array(sXml, "cd|nm");
	comboData = makeArray2ComboStr(comboData, isShowCd);
	if (comboData.length > 0) {
		sheetObjects[1].CellComboItem(row, changeColName, appendDefaultData(comboData[1]), appendDefaultData(comboData[0]));
	}
}

/**
 * array에 담긴 code,name을 combo에서 사용할수 있는 형태로 바꿔준다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * comboData = makeArray2ComboStr(comboData, isShowCd);
 * </pre>
 * 
 * @param {Array} arr 필수, Code,Name의 Array
 * @param {boolean} isShowCd 필수, combo에 code를 보여줄지 여부
 * @return Array, [0] = '|'로 연결된 code string , [1] = '|'로 연결된 name string
 */
function makeArray2ComboStr(arr, isShowCd) {
	var cd = "";
	var nm = "";
	if (isShowCd == undefined) {
		isShowCd = false;
	}
	if (arr != undefined) {
		for ( var i = 0; i < arr.length; i++) {

			if (i != 0) {
				cd = cd + "|"
				nm = nm + "|"
			}
			cd = cd + arr[i][0];
			if (isShowCd == true)
				nm = nm + arr[i][0] + "\t" + arr[i][1];
			else
				nm = nm + arr[i][1];
		}
	}
	return new Array(cd, nm)
}

/**
 * 현재 화면의 데이터 상태를 고려해 버튼들의 상태를 바꾼다. <br>
 * <b>Example :</b>
 * 
 * <pre>
 * changeButtonStatus();
 * </pre>
 * 
 * @return 없음
 */
function changeButtonStatus() {
	disableButton("btn_Add");
	disableButton("btn_Copy");
	disableButton("btn_Delete");
	disableButton("btn1_Add");
	disableButton("btn1_Copy");
	disableButton("btn1_Delete");
	var cnt = sheetObjects[0].RowCount;
	if (cnt == 0) {
		return;
	}
	enableButton("btn_Add");
	cnt = sheetObjects[1].RowCount;
	if (cnt != 0) {
		if (sheetObjects[1].SelectRow < 0)
			return;
		var isHidden = sheetObjects[1].RowHidden(sheetObjects[1].SelectRow)
		if (isHidden == true) {
			return;
		}
		enableButton("btn_Copy");
		enableButton("btn_Delete");
	} else {
		return;
	}

	enableButton("btn1_Add");
	cnt = sheetObjects[2].RowCount;
	if (cnt != 0) {
		if (sheetObjects[2].SelectRow < 0)
			return;
		var isHidden = sheetObjects[2].RowHidden(sheetObjects[2].SelectRow)
		if (isHidden == true) {
			return;
		}
		enableButton("btn1_Copy");
		enableButton("btn1_Delete");
	}

}

/**
 * 입력된 값에 따라 matching point를 계산한다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * changeMatchingPnt(sheetObj, row, col);
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} row 필수, row index
 * 
 * @return 없음
 */
function changeMatchingPnt(sheetObj, row) {
	var ori_loc_def_cd = sheetObj.CellValue(row, "ori_loc_def_cd");
	var dest_loc_def_cd = sheetObj.CellValue(row, "dest_loc_def_cd");
	var ori_via_def_cd = sheetObj.CellValue(row, "ori_via_def_cd");
	var dest_via_def_cd = sheetObj.CellValue(row, "dest_via_def_cd");
	var ori_term_cd = sheetObj.CellValue(row, "ori_term_cd");
	var dest_term_cd = sheetObj.CellValue(row, "dest_term_cd");
	var matchingPnt = 0;
	if (ori_loc_def_cd.trim() != "") {
		matchingPnt++;
	}
	if (dest_loc_def_cd.trim() != "") {
		matchingPnt++;
	}
	if (ori_via_def_cd.trim() != "") {
		matchingPnt++;
	}
	if (dest_via_def_cd.trim() != "") {
		matchingPnt++;
	}
	if (ori_term_cd.trim() != "") {
		matchingPnt++;
	}
	if (dest_term_cd.trim() != "") {
		matchingPnt++;
	}
	sheetObj.CellValue2(row, "matching_pnt") = matchingPnt;
}

/**
 * application combo의 선택된값에 따라 특정 필드의 값을<BR>
 * disable 또는 enable시킨다.
 * 
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * changeEnableForApplication(sheetObj, value);
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {string} value 필수, application combo의 선택된값
 * 
 * @return 없음
 */
function changeEnableForApplication(sheetObj, value) {
	var childSheetObj = sheetObjects[2];
	var flg = true;
	if (value == "E") {
		flg = false;
	} else if (value == "I") {
		flg = true;
	}
	var row = 0;
	var parentsSeq = sheetObj.CellValue(sheetObj.SelectRow, "seq");
	while (true) {
		row = childSheetObj.FindText("parents_seq", parentsSeq, row);
		if (row < 0)
			break;
		childSheetObj.CellEditable(row, "currency") = flg;
		childSheetObj.CellEditable(row, "amount") = flg;
		childSheetObj.CellEditable(row, "percent") = flg;
		row++;
	}
}

/**
 * sheet를 이용해 조회를 했을경우 조회 완료후 자동 호출됨 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {String} ErrMsg 필수, sheet의 결과 메시지
 * @return 없음
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	changeButtonStatus();
}
/**
 * sheet를 마우스 클릭 했을경우 자동 호출됨 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} row 필수, 클릭된 row index
 * @param {int} col 필수, 클릭된 col index
 * @param {string} value 필수, 클릭된 cell의 값
 * @return 없음
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	filteringSheet(sheetObj, sheetObjects[1], sheetObj.CellValue(row, "seq"), "parents_seq");
	var row2 = sheetObjects[1].FindText("parents_seq", sheetObj.CellValue(row, "seq"));
	filteringSheet(sheetObjects[1], sheetObjects[2], sheetObjects[1].CellValue(row2, "seq"), "parents_seq");
	changeButtonStatus();
}
/**
 * sheet를 마우스 클릭 했을경우 자동 호출됨 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} row 필수, 클릭된 row index
 * @param {int} col 필수, 클릭된 col index
 * @param {string} value 필수, 클릭된 cell의 값
 * @return 없음
 */
function sheet2_OnClick(sheetObj, row, col, value) {
	filteringSheet(sheetObj, sheetObjects[2], sheetObj.CellValue(row, "seq"), "parents_seq");
	changeButtonStatus();

}

/**
 * sheet의 내용이 변경 되었을때 자동 호출됨 <br>
 * <b>Example :</b>
 * 
 * <pre>
 * </pre>
 * 
 * @param {object} sheetObj 필수, sheet Object
 * @param {int} row 필수, 변경된 row index
 * @param {int} col 필수, 변경된 col index
 * @param {string} value 필수, 변경된 cell의 값
 * @return 없음
 */
function sheet2_OnChange(sheetObj, row, col, value) {

	switch (sheetObj.ColSaveName(col)) {
	case "ori_loc_def_cd":
		searchLocViaCd(sheetObj, row, col, "dest_loc_def_cd");
		searchLocViaCd(sheetObj, row, col, "ori_via_def_cd");
		searchLocViaCd(sheetObj, row, col, "dest_via_def_cd");
		searchLocViaCd(sheetObj, row, col, "ori_term_cd");
		searchLocViaCd(sheetObj, row, col, "dest_term_cd");

		break;
	case "dest_loc_def_cd":
		searchLocViaCd(sheetObj, row, col, "ori_loc_def_cd");
		searchLocViaCd(sheetObj, row, col, "ori_via_def_cd");
		searchLocViaCd(sheetObj, row, col, "dest_via_def_cd");
		searchLocViaCd(sheetObj, row, col, "ori_term_cd");
		searchLocViaCd(sheetObj, row, col, "dest_term_cd");

		break;
	case "ori_via_def_cd":
		searchLocViaCd(sheetObj, row, col, "ori_loc_def_cd");
		searchLocViaCd(sheetObj, row, col, "dest_loc_def_cd");
		searchLocViaCd(sheetObj, row, col, "dest_via_def_cd");
		searchLocViaCd(sheetObj, row, col, "ori_term_cd");
		searchLocViaCd(sheetObj, row, col, "dest_term_cd");

		break;
	case "dest_via_def_cd":
		searchLocViaCd(sheetObj, row, col, "ori_loc_def_cd");
		searchLocViaCd(sheetObj, row, col, "dest_loc_def_cd");
		searchLocViaCd(sheetObj, row, col, "ori_via_def_cd");
		searchLocViaCd(sheetObj, row, col, "ori_term_cd");
		searchLocViaCd(sheetObj, row, col, "dest_term_cd");
		break;
	case "application":
		changeEnableForApplication(sheetObj, value)
		break;
	}
	changeMatchingPnt(sheetObj, row, col);
}

/* 개발자 작업 끝 */