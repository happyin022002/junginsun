function ESM_BKG_0556() {
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

var rdObjects = new Array();
var rdCnt = 0;

// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

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
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab 기본 설정 탭의 항목을 설정한다.
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt = 0;
			InsertTab(cnt++, "청구서", -1);
			InsertTab(cnt++, "수정", -1);
		}
		break
	}
}

/**
 * Tab 클릭시 이벤트 관련 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj, nItem) {
	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	// --------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab = nItem;

	// tab Index는 0 부터 시작 함
	// 첫번째 tab = "청구서" 인 경우 수정 된 내용을 업데이트 해준다
	// ??? sheet1_OnAfterEdit는 없애도 될 듯 하다. 좀 지켜 보자. ^^
	if (nItem == 0) {
		doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
	}
}

/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	// TAB 생성
	for (k = 0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
	}

	// IBSHEET 생성
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

	// RD Viewer 생성
	if (location.hostname == "localhost") {
		RD_path = "http://localhost:7001/hanjin/";
	}
	rdOpen(rdObjects[0], document.form, sheetObjects[0], "");

	initControl();
}

function initControl() {
	var formObject = document.form;
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObject);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComSetFocus(formObject.whf_ntc_dt1);
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

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {

	case IBSEARCH: // 조회
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0556GS.do", FormQueryString(formObj)
					+ "&" + ComGetPrefixParam("sheet1_"));
		}
		break;

	case IBSAVE: // 저장
		var StringBuffer = function() {
			this.buffer = new Array();
		}
		StringBuffer.prototype.append = function(str) {
			this.buffer.push(str);
			return this;
		}
		StringBuffer.prototype.toString = function() {
			return this.buffer.join("");
		}
		var s = new StringBuffer();

		s.append("/rdata [");
		for ( var i = 0; i < sheetObjects[0].RowCount; i++) {

			if(sheetObjects[0].RowStatus(i+1) == "D") continue;

			s.append(sheetObjects[0].CellValue(i + 1, 2)).append("^").append(
					sheetObj.CellValue(i + 1, 3)).append("^").append(
					sheetObj.CellValue(i + 1, 5)).append("^").append(
					sheetObj.CellValue(i + 1, 6)).append("^").append(
					sheetObj.CellValue(i + 1, 7)).append("^").append(
					sheetObj.CellValue(i + 1, 8)).append("^").append(
					sheetObj.CellValue(i + 1, 9)).append("^").append(
					sheetObj.CellValue(i + 1, 10)).append("^").append(
					sheetObj.CellValue(i + 1, 11)).append("^").append(
					sheetObj.CellValue(i + 1, 12)).append("^").append(
					sheetObj.CellValue(i + 1, 15)).append("^").append(
					sheetObj.CellValue(i + 1, 16)).append("^").append(
					sheetObj.CellValue(i + 1, 17)).append("^").append(
					formObj.demand_month.value).append("^").append(
					formObj.calculate_month.value).append("^").append(
					formObj.represent.value).append("^").append(
					formObj.phone_num.value).append("^").append("~")
		}
		s.append("] /rnl [~]");
		s.append(" /rv b14[" + formObj.demand_month.value + "] "); // 청구월
		s.append("b15[" + formObj.calculate_month.value + "] "); // 투자비보전(정산월)
		s.append("b16[" + formObj.phone_num.value + "] "); // 전화번호
		s.append("b17[" + formObj.represent.value + "] "); // 대표자
		if(formObj.port_cd.value == 'KRINC') {
			s.append("b18[인천항만공사] "); //
		} else { //if(formObj.port_cd.value == 'KRPUS') {
			s.append("b18[(부산<감천>)부산항만공사] "); //

		}

		var Rdviewer = rdObjects[0];
		var xmldata = "<?xml version=\"1.0\" encoding=\"euc-kr\"?><root><startdate>20080101</startdate><enddate>20081231</enddate><today>20090113</today><table1>	<a>		<a1>100 </a1>		<a2> 200</a2>		<a3>300 </a3>		<a4>400 </a4>		<a5>500 </a5>	</a></table1></root>";
		var mrdpath = RD_path + "apps/alps/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0556_2.mrd";
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.setbackgroundcolor(128, 128, 128);
		Rdviewer.SetPageLineColor(128, 128, 128);
		Rdviewer.SetNoDataDialogInfo(0, "", ""); // 데이터 없음 메시지 창 숨김
		Rdviewer.FileOpen(mrdpath, s.toString());

		break;


	case IBDELETE: // 삭제

		var checked = 0;

		for ( var i = sheetObj.RowCount; i > 0; i--) {
			if (sheetObj.CellValue(i, 1) == '1') {
				checked = 1;
				sheetObj.RowDelete(i,false);
			}
		}

		if (checked == 0)
			ComShowCodeMessage('BKG00249');

		sheetObj.ReNumberSeq();

		break;

	case IBDOWNEXCEL: // processButtonClick()에 직접 구현 됨
		break;

	}
}

/*
 * Report 호출시에 기본 값 설정 및 호출 메서드.
 */
function rdOpen(rdObject, formObject, sheetObjects, paraArry) {
	var Rdviewer = rdObject;

	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.SetNoDataDialogInfo(0, "", ""); // 데이터 없음 메시지 창 숨김

	// 열고자 하는 RD 파일을 지정한다.
	var strPath = RD_path + "apps/alps/esm/bkg/wharfagemgt/wharfagedecmgt/report/ESM_BKG_0556_2.mrd";
	var rdParam = "/rdata []";

	Rdviewer.FileOpen(strPath, RDServer + rdParam);
}

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	var objs = document.all.item("tabLayer");
	var tab1Status = objs[0].style.display;
	var Rdviewer = rdObjects[0];

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch (srcName) {

		case "btn_retrieve":

			// if( tab1Status == "inline" ){
			var whfNtcDt1 = formObject.whf_ntc_dt1.value;
			var whfNtcDt2 = formObject.whf_ntc_dt2.value;

			var rdObject = rdObjects[0];
			// var paraAry = new Array('','','','','','','','');

			var whfBndCd = '';
			for ( var i = 0; i < formObject.whf_bnd_cd.length; i++) {
				if (formObject.whf_bnd_cd[i].checked == true)
					whfBndCd = formObject.whf_bnd_cd[i].value;
			}

			var portNm = '';
			for ( var i = 0; i < formObject.port_nm.length; i++) {
				if (formObject.port_nm[i].checked == true)
					portNm = formObject.port_nm[i].value;
			}


			if( portNm == '감천항' || portNm == '북항' || portNm == '신항' ){
				formObject.port_cd.value = 'KRPUS';
			} else if(portNm == '인천항') {
				formObject.port_cd.value = 'KRINC';
			} else if(portNm == '광양항') {
				formObject.port_cd.value = 'KRKAN';
			} else if(portNm == '울산항') {
				formObject.port_cd.value = 'KRUSN';
			} else if(portNm == '평택항') {
				formObject.port_cd.value = 'KRPTK';
			} else if(portNm == 'A') {
				formObject.port_cd.value = 'A';
			}
			var paraAry = new Array(whfNtcDt1.split("-").join(""), whfNtcDt2
					.split("-").join(""), whfBndCd, portNm,
					formObject.demand_month.value,
					formObject.calculate_month.value,
					formObject.represent.value, formObject.phone_num.value);

			doActionIBSheet(sheetObject1, document.form, IBSEARCH);
			doActionIBSheet(sheetObject1, document.form, IBSAVE);

			break;

		case "btn_downexcel":
				sheetObject1.SpeedDown2Excel(0, false, false, "", "", false, false, "", true, "sheet1_Chk","sheet1_ibflag|sheet1_Chk");
			break;
		case "btn_print":
			if (tab1Status == "inline") {
				Rdviewer.PrintDialog(); // 인쇄 대화상자 띄움

			} else {
				return false;
			}
			break;

		case "btn_add":
			sheetObject1.DataInsert(-1);
			break;

		case "btn_del":
			doActionIBSheet(sheetObject1, document.form, IBDELETE);
			break;

		case "btn_save":
			doActionIBSheet(sheetObject1, document.form, IBSAVE);

			break;

		case "btn_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObject.whf_ntc_dt1, formObject.whf_ntc_dt2,
					'yyyy-MM-dd');
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
 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++] = tab_obj;
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		var strText = "";
		if(formObj.whf_ntc_flg.value == "Y"){
			strText = "허가";
		}else{
			strText = "납기";
		}
		
		if (formObj.whf_ntc_dt1.value == "") {
			ComShowCodeMessage('BKG00887', strText+'시작일자');
			return false;
		}

		if (formObj.whf_ntc_dt2.value == "") {
			ComShowCodeMessage('BKG00887', strText+'종료일자');
			return false;
		}

		return true;
		break;

	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;

	switch (sheetObj.id) {
	case "sheet1": // sheet1 init
		with (sheetObj) {

			// 높이 설정
			style.height = 357;
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

			var HeadTitle1 = "||번호|선명|CODE|항차|호출부호|입출항횟수|외내항구분|반출입구분|입항일시|비관리청유무|고지번호|DEC NO|단/복수|납부금액|남부일자|대납경비";

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(18, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			var prefix = 'sheet1_';
			InitDataProperty(0, cnt++, dtHiddenStatus, 30, daCenter, true,
					prefix + "ibflag");
			InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true, prefix
					+ "Chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtSeq, 30, daCenter, true, prefix
					+ "Seq", false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, prefix
					+ "vsl_nm", false, "", dfNone, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix
					+ "vsl_cd", false, "", dfNone, 0, true, true, 30);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix
					+ "hcnt", false, "", dfNone, 0, true, true, 5);

			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix
					+ "call_sgn_no", false, "", dfNone, 0, true, true, 9);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix
					+ "ichcnt", false, "", dfUserFormat, 0, true, true, 8);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, prefix
					+ "ongubun", false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtCombo, 80, daCenter, true, prefix
					+ "whf_bnd_cd", false, "", dfNone, 0, true, true, 1);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix
					+ "sail_dt", false, "", dfDateYmd, 0, true, true, 10);

			InitDataProperty(0, cnt++, dtCombo, 100, daCenter, true, prefix
					+ "bkrcisnot", false, "", dfNone, 0, false, false, 1);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, prefix
					+ "whf_ntc_no", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix
					+ "whf_decl_no", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, prefix
					+ "cust_kind_cd", false, "", dfNone, 0, true, true, 6);
			InitDataProperty(0, cnt++, dtAutoSumEx, 100, daRight, true, prefix
					+ "ntc_amt", false, "", dfInteger, 0, true, true, 12);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true, prefix
					+ "pay_dt", false, "", dfDateYmd, 0, true, true, 10);
			InitDataProperty(0, cnt++, dtAutoSumEx, 0, daRight, true, prefix
					+ "comm_amt", false, "", dfInteger, 0, true, true, 12);

			CountPosition = 0;

			InitDataCombo(0, prefix + "ongubun", "1", "1");
			InitDataCombo(0, prefix + "whf_bnd_cd", "1|2", "1|2");
			InitDataCombo(0, prefix + "bkrcisnot", "2", "2");

			InitDataValid(0, prefix + "vsl_nm", vtEngUpOther, '0123456789');
			InitDataValid(0, prefix + "hcnt", vtEngUpOther, '0123456789');
			InitDataValid(0, prefix + "call_sgn_no", vtEngUpOther, '0123456789');
			InitUserFormat(0, prefix + "ichcnt", "####-###", "");

			InitDataValid(0, prefix + "whf_ntc_no", vtEngUpOther, '0123456789');


		}
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.SumText(0, 2) = "";
	sheetObj.SumText(0, 3) = "        TOTAL";
}

function sheet1_OnAfterEdit(sheetObj, Row, Col) {
	doActionIBSheet(sheetObj, document.form, IBSAVE);
}

/**
 * RD 출력
 *
 * @param rdObject
 * @return
 */
function rdPrint(rdObject) {
	var Rdviewer = rdObject;

	Rdviewer.PrintDialog();
	// Rdviewer.CMPrint();
}
