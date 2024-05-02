/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESD_AOC_3021.js
 *@FileTitle : Ocean Feeder Cost Batch Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.01.14
 *@LastModifier : 이혜민
 *@LastVersion : 1.0
 *
 * History
 * 2013.01.14 CHM-201322300 이혜민 [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
 * 2013.02.15 이재위 [CHM-201323053-01] [AOC] OCN FDR DG cargo Tab  상에서의 Scale up & down 설정변경
 * 2015.02.03 전지예 [CHM-201533794] 45' Cost 추가
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends
 * @class ESD_AOC_3021 : ESD_AOC_3021 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_AOC_3021() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm; 
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

/* 공통전역변수 */
// var calPop = new ComCalendarGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];

	/** **************************************************** */
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;

		case "btn_batch":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;

		case "btn_cost_tariff":
			goCostTrfMgmt();
			break;

		}
		// end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("AOC90004");
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * IBSheet Object를 배열로 등록 comSheetObject(id)에서 호출한다 향후 다른 항목들을 일괄처리할 필요가 있을 때
 * 배열로 담는 프로세스를 추가할 수 있다 배열은 소스 상단에 정의
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

	// MultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}

	// Initializing
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	// doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

	initFunc();
	initControl();
}

function initCombo(comboObj, comboId) {
	var formObject = document.form
	if (comboId == "combo_rhq") {
		comboObj.DropHeight = 200;
		comboObj.MultiSelect = true;
		comboObj.MultiSeparator = ",";
		comboObj.UseEdit = false;
		comboObj.enable = false;
		//comboObj.BackColor = "#CCFFFD";
	} else {
		MultiSelect = false;
		UseEdit = true;
	}
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
	// axon_event.addListener('click', 'obj_click', 'manual'); //Click
	// axon_event.addListener('keyup', 'obj_keyup', 'boo_bkg_no'); //Key Up
	// axon_event.addListenerFormat('blur', 'obj_blur', form); //Blur
	// axon_event.addListenerFormat('focus', 'obj_focus', form); //Focus
	// axon_event.addListenerFormat('keypress','obj_keypress', form); //Key
	// Press
}

/**
 * HTML Control의 objClick이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_click() {
}

/**
 * HTML Control의 objKeyup이벤트에서 영문숫자만 입력 처리한다. <br>
 */
function obj_keyup() {
}

/**
 * HTML Control의 onBlur이벤트에서 Validation을 체크한다. <br>
 */
function obj_blur() {
}

/**
 * HTML Control의 onFocus이벤트에서 마스크 구분자를 제거한다. <br>
 */
function obj_focus() {
	// ComClearSeparator(event.srcElement);
}

/**
 * HTML Control의 onKeypress이벤트에서 숫자만 입력되게 한다. <br>
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "engup": // 영문대문자
		ComKeyOnlyAlphabet('upper');
		break;

	case "engupnum": // 숫자+"영문대분자"입력하기
		ComKeyOnlyAlphabet('uppernum');
		break;

	case "num": // 숫자 입력하기
		ComKeyOnlyNumber(event.srcElement);
		break;

	case "engnum": // 숫자+"영문대소"입력하기
		ComKeyOnlyAlphabet('num');
		break;

	case "engupcomma": // 영문대문자+Comma
		ComKeyOnlyAlphabet('upper', '44');
		break;

	default:
	}
}
// Axon 이벤트 처리2. 이벤트처리함수 --- end

/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			// 높이 설정
			style.height = GetSheetHeight(10);
			// 전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			// Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "")
				InitHostInfo(location.hostname, location.port, page_path);

			// 전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly; // msAll / msPrevColumnMerge /
										// msHeaderOnly

			// 전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(2, 1, 25);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, false, true, true, true, false);

			var HeadTitle1 = "Sts||RHQ|Tariff No|Weight Criteria|Weight Criteria|Weight Criteria|Status|Status|CURR|Progress|Creation\nTime|Creation\nUser|Update\nTime|Update\nUser";
			var HeadTitle2 = "Sts||RHQ|Tariff No|20'|40'|45'|Status|Status|CURR|Progress|Creation\nTime|Creation\nUser|Update\nTime|Update\nUser";

			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성[ ROW,COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 40, daCenter, true,
					"ibflag", false, "", dfNone, 0, false, false, 0, false,
					true, "", false);
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, true, "chk");     
			InitDataProperty(0, cnt++, dtData, 70, daCenter, true, "rhq_cd",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true,
					"cost_trf_no", false, "", dfNone, 0, false, false, 30,
					false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,
					"cntr_20ft_crte_wgt", false, "", dfNullFloat, 3, true,
					true, 12, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,
					"cntr_40ft_crte_wgt", false, "", dfNullFloat, 3, true,
					true, 12, false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,
					"cntr_45ft_crte_wgt", false, "", dfNullFloat, 3, true,
					true, 12, false, true, "", false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "sts_cd",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "sts_nm",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);
			InitDataProperty(0, cnt++, dtHidden, 60, daCenter, true, "curr_cd",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);
			InitDataProperty(0, cnt++, dtData, 80, daCenter, true,
					"prog_ratio", false, "", dfNone, 0, false, false, 30,
					false, true, "", false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "cre_dt",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "cre_usr_id",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);
			InitDataProperty(0, cnt++, dtData, 150, daCenter, true, "upd_dt",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);
			InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "upd_usr_id",
					false, "", dfNone, 0, false, false, 30, false, true, "",
					false);

			DataLinkMouse("sts_nm") = true;
		}
		break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction, chkflg) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch4Post("ESD_AOC_3021GS.do", AocFrmQryString(formObj));
		break;

	// case SEARCH01: //RHQ Office Code
	// if(!validateForm(sheetObj,formObj,sAction)) return;
	// formObj.f_cmd.value = SEARCH01;
	// var sXml = sheetObj.GetSearchXml("ESD_AOC_3021GS.do",
	// AocFrmQryString(formObj));
	//			
	// formObj.shq_flg.value = ComGetEtcData(sXml, "shq_flg");
	// formObj.rhq_cd.value = ComGetEtcData(sXml, "rhq_cd");
	//			
	// if( formObj.shq_flg.value == "Y" ){
	// comboObjects[0].Code = formObj.param_rhq_cd.value;
	// formObj.rhq_cd.value = formObj.param_rhq_cd.value;
	// } else{
	// comboObjects[0].Code = formObj.rhq_cd.value;
	// }
	// comboObjects[0].enable = false;
	// break;

	case SEARCH02: // Combo List
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetObj.GetSearchXml("ESD_AOC_3021GS.do",
				AocFrmQryString(formObj));
		var arrXml = sXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], formObj.combo_rhq, "val", "name");
		var rhqCd = formObj.rhq_cd.value;
		if(rhqCd == 'SHARC'){
			comboObjects[0].Code = 'SHARC,SELIB,TYOIB';
		}else{
			comboObjects[0].Code = rhqCd;			
		}
		break;

	case MULTI: // Batch Creation
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value = MULTI;
		  var sRowStr = sheetObj.FindCheckedRow(1);
		  var rownum = sRowStr.split('|');
		  for(var i=0; i<rownum.length-1; i++){
			  sheetObj.RowStatus(rownum[i]) = "I";
		  }
		sheetObj.DoSave("ESD_AOC_3021GS.do", FormQueryString(formObj), -1,false);
		break;
	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case MULTI:

		// Waiting 또는 Progressing 경우 진행 불가, 진행 상태가 Created 또는 Updated 경우 확인 메시지창
		// 띄움
		var msgFlg = "N";
		if (sheetObj.RowCount > 0) {
			if (sheetObj.CellValue(sheetObj.SelectRow, "sts_cd") == "W"
					|| sheetObj.CellValue(sheetObj.SelectRow, "sts_cd") == "P") {
				ComShowCodeMessage("AOC90005");
				return false;
			}
			if (sheetObj.CellValue(sheetObj.SelectRow, "sts_cd") == "B"
					|| sheetObj.CellValue(sheetObj.SelectRow, "sts_cd") == "U"
					|| sheetObj.CellValue(sheetObj.SelectRow, "sts_cd") == "E") {
				msgFlg = "Y";
			}
		}
		if (msgFlg == "Y") {
			if (!ComShowCodeConfirm("AOC90006")) {
				return false;
			}
		}

		// Weight Criteria 항목 필수 입력 체크
		if (sheetObj.RowCount > 0) {
			if (sheetObj.CellValue(sheetObj.SelectRow, "cntr_20ft_crte_wgt") == ""
					|| sheetObj.CellValue(sheetObj.SelectRow,
							"cntr_40ft_crte_wgt") == ""
					|| sheetObj.CellValue(sheetObj.SelectRow,
							"cntr_45ft_crte_wgt") == "") {
				ComShowCodeMessage("COM130403", "Weight Criteria");
				return false;
			}
		}

		if (!confirm("Did you insert Weight Criteria properly? \nIf 'Yes', Plz click 'OK' for Batch Creation.")) {
			return false;
		}

		break;
	}

	return true;
}

function initFunc() {
	if (document.form.shq_flg.value == "Y") {
		ComBtnDisable("btn_batch");
	} else {
		ComBtnEnable("btn_batch");
	}
}

/**
 * 조회결과가 오류가 발생했을 때 공통처리하는 함수 IBSheetConfig.js에서
 * DataSheetObject.prototype.event_OnSearchEnd에서 정의
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	for ( var idx = 0 + parseInt(sheetObj.HeaderRows); idx <= sheetObj.LastRow; idx++) {
		if (sheetObj.CellValue(idx, "sts_cd") == "E") {
			sheetObj.CellFontUnderline(idx, "sts_nm") = true;
		}
	}
}

/**
 * 저장 후 이벤트 처리
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg != "") {
		ComShowCodeMessage("AOC90005"); // 시스템 오류 등, 예기치 않은 서버오류에 의한 메시지가 왔을 경우
										// 해당에서 처리한다.
	} else {
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}

function sheet1_OnClick(sheetObj, Row, Col, Value) {
	var colNm = sheetObj.ColSaveName(Col);

	if (colNm == "sts_nm" && sheetObj.CellValue(Row, "sts_cd") == "E") {
		var sUrl = "/hanjin/ESD_AOC_3902.do";
		var param = '?cost_trf_no=' + sheetObj.CellValue(Row, "cost_trf_no");
		param = param + '&curr_cd=' + sheetObj.CellValue(Row, "curr_cd");
		param = param + '&cre_dt=' + sheetObj.CellValue(Row, "cre_dt");
		param = param + '&cre_usr_id=' + sheetObj.CellValue(Row, "cre_usr_id");
		param = param + '&rhq_cd=' + document.form.rhq_cd.value;
		var myOption = "width=780,height=600,menubar=0,status=0,scrollbars=0,resizable=1";
		window.open(sUrl + param, "ESD_AOC_3902", myOption);
	}
}

function sheet1_OnDblClick(sheetObj, Row, Col) {
	goCostTrfMgmt();
}

function goCostTrfMgmt() {
	// Tariff No 없을 경우
	if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cost_trf_no") == "") {
		ComShowCodeMessage("AOC90002", "Tariff No.");
		return;
	}
	// Checking Status( B:Created, U:Updated, C:Confirmed ) B/U/C 상태가 아니면 메시지 띄움
	if (sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sts_cd") != "B"
			&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sts_cd") != "U"
			&& sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sts_cd") != "C") {
		ComShowCodeMessage("AOC90012");
		return;
	}

	var sUrl = "";
	var param = '?trf_no='
			+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow,
					"cost_trf_no");
	param = param + '&rhq_cd='
			+ sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "rhq_cd");
	var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";

	if (document.form.rhq_cd.value == "HAMRU") {
		sUrl = "/hanjin/ESD_AOC_3022.do";
		window.open(sUrl + param, "ESD_AOC_3022", myOption);
	} else if (document.form.rhq_cd.value == "SHARC") {
		sUrl = "/hanjin/ESD_AOC_3122.do";
		window.open(sUrl + param, "ESD_AOC_3122", myOption);
	} else if (document.form.rhq_cd.value == "SINRS") {
		sUrl = "/hanjin/ESD_AOC_3222.do";
		window.open(sUrl + param, "ESD_AOC_3222", myOption);
	}
}

function combo_rhq_OnCheckClick(comboObj, index, code) {
	if (code == "") {
		if (comboObj.CheckIndex(0) == false) {
			comboObj.Code = "";
			comboObj.CheckIndex(0) = false;
		} else {
			comboObj.Code = "";
			comboObj.CheckIndex(0) = true;
		}
	} else {
		comboObj.CheckIndex(0) = false;
	}
}
