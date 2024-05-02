/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0090.js
 *@FileTitle : Special Stowage Request
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.14
 *@LastModifier : KimByungKyu
 *@LastVersion : 1.0
 * 2009.05.14 KimByungKyu
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
 * @class esm_bkg_0090 : esm_bkg_0090 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0090() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var imdgStwgCateCd = "";
var primeOfcFlg = "";
var stwg_cd = "";
var sXml = "";

var opener = window.dialogArguments;

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
		case "btn_Save":
			setPopupToParent(sheetObject, formObject);

			/*
			 * // PopUp 정보를 Main에 전달
			 * window.dialogArguments.document.form.stwg_rmk.value =
			 * document.form.stwg_rmk.value; for (var i=sheetObject.HeaderRows;
			 * i<=sheetObject.LastRow; i++) { if(sheetObject.CellValue(i,"chk") ==
			 * 1){ window.dialogArguments.document.form.stwg_cd.value =
			 * sheetObject.CellValue(i,"val"); break; } } window.close();
			 */
			break;

		case "btn_Close":
			window.close();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("COM12111");
		} else {
			ComShowMessage(e);
		}
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
}

function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.WaitImageVisible = false;
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	sheetObj.WaitImageVisible = true;
	
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	
	// OLBP인 경우 Font 2 크게, Bold Color 붉은색
	for (var i = 1; i < sheetObjects[0].Rows; i++) {
		if (sheetObjects[0].CellValue(i, "val") == "OLBP") {
			// 2017.07.17 미주 PRIME SVC관련(SHASC, NBOSC, SELSC)인 경우만 OBLP를 표시하도록
			// 수정.
			if (primeOfcFlg == "N") {
				sheetObj.RowHidden(i) = true;
			} else {
				var rColor = sheetObjects[0].RgbColor(255, 0, 0);
				sheetObjects[0].RowFontColor(i) = rColor;
				sheetObjects[0].CellFont("FontBold", i, "val", i, "name") = true;
				sheetObjects[0].CellFont("FontSize", i, "val", i, "name") = 10;
			}
		}
	}
}

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;

	switch (sheetNo) {
	case 1: // t1sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = 350;
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msAll;

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 3, 100);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(4, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			var HeadTitle = "|Sel.|Type|Detail";

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 0, daCenter, true,
					"ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false,
					"chk", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "val",
					false, "", dfNone, 0, false, false);
			InitDataProperty(0, cnt++, dtData, 250, daLeft, false, "name",
					false, "", dfNone, 0, false, false);
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCH;
		sXml = sheetObj.GetSearchXml("ESM_BKG_0090GS.do",
				FormQueryString(formObj));
		imdgStwgCateCd = ComGetEtcData(sXml, "imdg_stwg_cate_cd");
		sheetObj.LoadSearchXml(sXml);

		primeOfcFlg = ComGetEtcData(sXml, "prime_ofc_flg");
		break;

	case SEARCH01: // Validation Check
		formObj.f_cmd.value = SEARCH01;
		var param = "f_cmd="+formObj.f_cmd.value + "&stwg_cd=" + sheetObj.CellValue(sheetObj.SelectRow, "val") + "&ctrt_no="+opener.document.form.sc_no.value;
		sXml = sheetObj.GetSearchXml("ESM_BKG_0090GS.do", param);
		var checkFlg = ComGetEtcData(sXml, "checkFlg");
		if (checkFlg == "N") {
			ComShowCodeMessage("BKG95123");
			return false;
		}
		return true;
	
	case SEARCH02 : // OLBS 에 해당되는 SC인지 여부를 판단
		formObj.f_cmd.value = SEARCH02;
		var parentObj = window.dialogArguments.document.form;
		var scNo = parentObj.sc_no.value;
		var rfa_no = parentObj.rfa_no.value;
		var taa_no = parentObj.taa_no.value;
		var contract_no;
		if(scNo != null && scNo != ""){
			contract_no = scNo;
		}
		if(rfa_no != null && rfa_no != ""){
			contract_no = rfa_no;
		}
		if(taa_no != null && taa_no != ""){
			contract_no = taa_no;
		}
		
		var param = "f_cmd="+formObj.f_cmd.value+"&hrd_cdg_id=STWG_OLBS&attr_ctnt1=SC_NO&attr_ctnt2="+contract_no;
		sXml = sheetObj.GetSearchXml("ESM_BKG_0090GS.do", param);
		var existStwg = ComGetEtcData(sXml, "existStwg");
		if(existStwg == "1"){
			for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				if (sheetObj.CellValue(i, "val") == "OD" || sheetObj.CellValue(i, "val") == "OT" ||
						sheetObj.CellValue(i, "val") == "OLBS" || sheetObj.CellValue(i, "val") == "OLBP") {
					sheetObj.CellEditable(i, "chk") = true;
					sheetObj.CellBackColor(i,"chk") = sheetObj.RgbColor(255, 228, 0);					
					sheetObj.CellBackColor(i,"val") = sheetObj.RgbColor(255, 228, 0);
					sheetObj.CellBackColor(i,"name") = sheetObj.RgbColor(255, 228, 0);
				} else {
					sheetObj.CellEditable(i, "chk") = false;
				}
			}
		}
		
		break;
	}
}

function sheet1_OnClick(sheet, Row, Col, Value) {
	if (imdgStwgCateCd != "Y") {
		for (var i = 1; i < sheet.Rows; i++) {
			if (i != Row) {
				sheet.CellValue(i, "chk") = 0;
			}
		}
	} else {
		alert("This UN No. should be loaded 'on deck' as per IMDG code.");
		if (stwg_cd.length > 0) {
			for (var i = 1; i < sheet.Rows; i++) {
				if (sheet.CellValue(i, "val") == stwg_cd) {
					sheet.CellValue(i, "chk") = 1;
				}
			}
		}
	}

	// OLBP가 체크되어 있었는데(처음 Loading 시점) 변경 될 경우 경고메세지를 표시.
	// 1. 체크를 풀 경우
	// 2. 다른 Stowage Code로 변경 할 경우
	if (document.form.stwg_cd.value == "OLBP") {
		// if(sheet.CellValue(Row,"val") == "OLBP" && sheet.CellValue(Row,"chk")
		// == 1){
		alert("Check your 'OLBP' before you uncheck");
		// }
	}
	
}

// function sheet1_OnChange(sheetObj, Row, Col, Value){
// var colName = sheetObj.ColSaveName(Col);
// var formObj = document.form;
// if(imdgStwgCateCd == "Y"){
// alert("This UN No. should be loaded 'on deck' as per IMDG code.");
// if(stwg_cd.length > 0){
// for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
// if(sheetObj.CellValue(i,"val") == stwg_cd){
// sheetObj.CellValue2(i,"chk") = 1;
// } else {
// sheetObj.CellValue2(i,"chk") = 0;
// }
// }
// }
// }
// }

function sheet1_OnBeforeCheck(Row,Col){
	
	// Validation Check
	// 아래 Stowage Code의 경우 정해진 S/C에 한해서만 체크 할 수 있도록 Validation Check 함.
	// ex) 삼성의 경우 OBSS만 찍을 수 있음. 
	sheetObjects[0].AllowCheck = doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}
	

function initControl() {
	// Axon 이벤트 처리1. 이벤트catch(개발자변경)
	axon_event.addListenerForm('keyup', 'obj_keyup', form);
}

// Remark의 글자수 제한
function obj_keyup() {
	switch (event.srcElement.name) {
	case "stwg_rmk":
		var frm = document.form.stwg_rmk.value.length;
		if (frm > 500) {
			ComShowCodeMessage("BKG01137", "500");
			document.form.stwg_rmk.value = document.form.stwg_rmk.value
					.substring(0, 500);
		}
		break;
	}
}

function setPopupToParent(sheetObject, formObj) {
	var stwgRmk = formObj.stwg_rmk.value;
	var stwgCd = "";
	for (var i = sheetObject.HeaderRows; i <= sheetObject.LastRow; i++) {
		if (sheetObject.CellValue(i, "chk") == 1) {
			stwgCd = sheetObject.CellValue(i, "val");
			break;
		}
	}
	var calllFunc = formObj.calllFunc.value;
	if (calllFunc != '') {
		eval('window.dialogArguments.' + calllFunc)(new Array(stwgCd, stwgRmk));
	}
	window.close();
}

// Main에 있는 정보를 셋팅한다.
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObject = document.form;
	// Main에 있는 Remark를 셋팅하는데 입력한 그대로 보여주기 위해 script로 가져온다.
	formObject.stwg_rmk.value = window.dialogArguments.document.form.stwg_rmk.value;

	// Main에 있는 StowageCode를 셋팅한다
	stwg_cd = ComTrimAll(formObject.stwg_cd.value);
	old_stwg_cd = stwg_cd;
	if (stwg_cd.length > 0) {
		for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if (sheetObj.CellValue(i, "val") == stwg_cd) {
				sheetObj.CellValue(i, "chk") = 1;
				break;
			}
		}
	}
	if (imdgStwgCateCd == "Y") {
		sheetObj.Editable = false;
	}
	
	// 2018.04.19 iylee POD가 CAVAN일 경우 OLBP의 Detail 문구를 다음과 같이 설정.
	var findOLBPRow = sheetObj.FindText(2, "OLBP", 0, false);
	if (formObject.pod_cd.value == "CAVAN"){
		sheetObj.CellValue(findOLBPRow, "name") = "** CANADA RAIL EXPRESS(SM Prime SVC)";
	} else {
		sheetObj.CellValue(findOLBPRow, "name") = "** Priority Early Discharge (SM Prime SVC)";
	}
	

}
/* 개발자 작업 끝 */