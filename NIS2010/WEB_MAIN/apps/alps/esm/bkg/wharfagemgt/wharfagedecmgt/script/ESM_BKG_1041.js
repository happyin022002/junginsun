/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName :ESM_BKG_1041.js
 *@FileTitle : US Wharfage Exception Keyword
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.16 김민정
 * 1.0 Creation
=========================================================*/
/*******************************************************************************
 * 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 * [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7 기타 여분의 문자상수
 * COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/

/**
 * 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1041() {
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
var intervalId = "";

var searchFlg = null;

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
					for ( var i = 1; i < sheetObject.RowCount + 1; i++) {
						if (sheetObject.CellValue(i, "chk") == "1") {
							if (sheetObject.CellValue(i, "io_bnd_cd") != "") {
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
				doActionIBSheet(sheetObject, document.form, COMMAND01);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject, formObject, MULTI);
				break;
			case "btn_WHFSend":
				var vvd = formObject.vvd.value;
				var bound = formObject.bound.value;
				var crr_cd = formObject.crr_cd.value;
				var param = "?pgmNo=ESM_BKG_1040&vvd=" + vvd + "&bound=" + bound + "&crr_cd=" + crr_cd;
				ComOpenWindowCenter("/hanjin/ESM_BKG_1040.do"+param, "1040", 1024, 620, true);
				break;
			case "btn_excel":
				sheetObject.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "1");
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
 * @param searchFlg 자동조회여부
 */
function loadPage(searchFlg) {
	this.searchFlg = searchFlg;
	for (i = 0; i < sheetObjects.length; i++) {
		//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee-마지막 환경 설정 함수 추가
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].WaitImageVisible = false;
	}
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_Change', document.form);
	
    doActionIBSheet(sheetObjects[0], document.form, INIT);
    if (this.searchFlg) doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
	document.form.vvd.focus();
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
			style.height = 440;

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

			var HeadTitle1 = "ibflag|Sel.|Seq.|B/L No.|CNTR No.|F/M|DEL/POR|US State|Type|20FT|40FT|45FT";
			var headCount = ComCountHeadTitle(HeadTitle1) + 10;

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, true, false);

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
			// SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++, dtHiddenStatus, 60, daCenter, true, "ibflag");
			InitDataProperty(0, cnt++, dtDummyCheck, 40, daCenter, false, "chk");
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, false, "seq");
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "bl_no", true, "", dfNone, 0, false, true, 12, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "cntr_no", true, "", dfNone, 0, false, true, 14);
			InitDataProperty(0, cnt++, dtCombo, 90, daCenter, false, "full_mty_cd", false, "", dfNone, 0, false, true);
			InitDataProperty(0, cnt++, dtData, 120, daCenter, false, "org_dest_loc_cd", true, "", dfNone, 0, false, true, 5, true);
			InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "ste_cd", false, "", dfNone, 0, false, true, 2);
			InitDataProperty(0, cnt++, dtCombo, 120, daCenter, false, "usa_whf_trsp_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ft20", false, "", dfNullFloat, 2, false, true, 10);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ft40", false, "", dfNullFloat, 2, false, true, 10);
			InitDataProperty(0, cnt++, dtData, 70, daRight, false, "ft45", false, "", dfNullFloat, 2, false, true, 10);
			
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "io_bnd_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "vsl_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "skd_voy_no");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "skd_dir_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "port_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, true, "cntr_tpsz_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "usa_whf_rat_ut_cd");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "rat_as_qty");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "whf_ut_prc");
			InitDataProperty(0, cnt++, dtHidden, 0, daCenter, false, "crr_cd");
			
			InitDataCombo(0, "full_mty_cd", "Full|Empty", "F|M", "Empty");
			
			InitDataValid(0, "bl_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "cntr_no", vtEngUpOther, "1234567890");
			InitDataValid(0, "org_dest_loc_cd", vtEngUpOnly);
			InitDataValid(0, "ste_cd", vtEngUpOnly);
		}
		break;
		case "sheet2": //sheet2 init
			with (sheetObj) {
				// 높이 설정
				style.height = 100;
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
		
				var HeadTitle1 = "|||B/L No.|CNTR No.|F/M|DEL|Term|Type|20FT|40FT|45FT||||||||||||||";
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
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 30, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "bl_no");
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "cntr_no");
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "full_mty_cd");
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "org_dest_loc_cd");
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "ste_cd");
				InitDataProperty(0, cnt++, dtData, 70, daCenter, false, "usa_whf_trsp_tp_cd");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ft20");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ft40");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ft45");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "io_bnd_cd");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "vsl_cd");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "skd_voy_no");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "skd_dir_cd");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "port_cd");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "cntr_tpsz_cd");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "usa_whf_rat_ut_cd");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "rat_as_qty");
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "whf_ut_prc");
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
	switch (sAction) {
		case INIT:
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1041GS.do", FormQueryString(formObj));
			var arrCombo = ComXml2ComboString(sXml, "name", "val");
			sheetObj.InitDataCombo(0, "usa_whf_trsp_tp_cd", arrCombo[0], arrCombo[1]);
			break;
		case COMMAND01:
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true,true);
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1041GS.do", FormQueryString(formObj));
				// 30초 이상 걸리는 경우가 발생해서 BackEndJob으로 돌림  3초마다
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[1], '" + key + "');", 1000);
			} 
			break;
		case SEARCH: //Retrieve
			if (validateForm(sheetObj, formObj, sAction))
			{
				sheetObj.DoSearch("ESM_BKG_1041GS.do", FormQueryString(formObj));
				if (sheetObj.RowCount > 0) {
					formObj.crr_cd.value = sheetObj.CellValue(1, "crr_cd");
				} else {
					formObj.crr_cd.value = "";
				}
			}
			break;
		case MULTI: //Save
			if (validateForm(sheetObj, formObj, sAction))
			{
				ComOpenWait(true);
				var sParam = sheetObj.GetSaveString() + "&" + FormQueryString(formObj);
				if (sheetObj.GetSaveString() == "") {
					return;
				}
				var sXml = sheetObj.GetSaveXml("ESM_BKG_1041GS.do", sParam);
				if(ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSaveXml(sXml);
					sheetObj.CheckAll("chk") = 0;
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				ComOpenWait(false);
			}
			break;
	}
}

 /**
 * BackEndJob 결과조회
 * @param sheetObj 시트오브젝으
 * @param sKey BackEndJob Key
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml = sheetObj.GetSearchXml("ESM_BKG_1041GS.do?f_cmd=" + SEARCH02 + "&key=" + sKey);
	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		// sheet1, sheet2 다시 조회
		doActionIBSheet(sheetObjects[0], document.form, SEARCH);
		ComOpenWait(false);
		return;
	} else if (sJbStsFlg == "FAIL") {
		// 에러
		clearInterval(intervalId);
		// 에러메시지 보여주고
		ComShowMessage(ComResultMessage(sXml));
		ComOpenWait(false);
		return;
	}
}

/**
 * 키보드 눌렀을때 발생하는 이벤트
 * @param sheetObj 시트오브젝트
 * @param Row Row Index
 * @param Col Col Index
 * @param KeyCode KeyCode
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 */
function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) {
	if (sheetObj.ColSaveName(Col) == "ft20") {
		if (sheetObj.CellValue(Row, "ft40") != ""
				|| sheetObj.CellValue(Row, "ft45") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
	if (sheetObj.ColSaveName(Col) == "ft40") {
		if (sheetObj.CellValue(Row, "ft20") != ""
				|| sheetObj.CellValue(Row, "ft45") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
	if (sheetObj.ColSaveName(Col) == "ft45") {
		if (sheetObj.CellValue(Row, "ft20") != ""
				|| sheetObj.CellValue(Row, "ft40") != "") {
			sheetObj.CellEditable(Row, Col) = false;
		} else {
			sheetObj.CellEditable(Row, Col) = true;
		}
	}
}

/**
 * 시트1 변경시 이벤트
 * @param sheetObj 시트오브젝트
 * @param Row Row Index
 * @param Col Col Index
 * @param Value 변경값
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (sheetObj.ColSaveName(Col) == "bl_no") {
		//BL NO 입력 후 조회
		ComOpenWait(true);
		document.form.f_cmd.value = SEARCH01;
		sheetObjects[1].DoSearch("ESM_BKG_1041GS.do?bl_no="	+ sheetObj.CellValue(Row, "bl_no"),	FormQueryString(document.form));
		for ( var i = 1; i < sheetObjects[1].RowCount + 1; i++) {
			if (i > 1) {
				sheetObj.DataInsert(-1);
			}
			for ( var col = 0; col <= sheetObjects[1].LastCol; col++) {
				sheetObj.CellValue2(sheetObj.LastRow, col) = sheetObjects[1]
						.CellValue(i, col);
			}
			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(255, 255, 204);
			sheetObj.CellValue2(sheetObj.LastRow, "ibflag") = "I";
		}
		ComOpenWait(false);
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
		case MULTI: //Save
			if (!sheetObj.IsDataModified) {
				ComShowCodeMessage("BKG95005");
				return false;
			}
			for (var i=1; i<sheetObj.RowCount+1; i++) {
				if (sheetObj.CellValue(i, "ibflag") != 'D' && sheetObj.CellValue(i, "ft20") == "" && sheetObj.CellValue(i, "ft40") == "" && sheetObj.CellValue(i, "ft45") =="") {
					ComShowMessage(i +" Recode [Container Size]is mandatory item.");
					return false;
				}
			}
			// 저장하시겠습니까?
			if (!ComShowCodeConfirm("BKG00824")) {
				return false;
			}
		break;
	}
	return true;
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

/**
 * 조회조건 바꿀때 시트 초기화
 * @return
 */
function obj_Change() {
	var formObject = document.form;
	var srcName = window.event.srcElement.getAttribute("name");
	if (srcName == "bound") {
		sheetObjects[0].RemoveAll();
	}
}