/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0142.js
 *@FileTitle : Customer Code Entry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
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
function esm_bkg_0142() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
	this.sheet1_OnClick = sheet1_OnClick;
	this.sheet1_OnScrollNext = sheet1_OnScrollNext;
}

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObj = sheetObjects[0];
	/** **************************************************** */
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var row = sheetObj.SelectRow;

		switch (srcName) {
		case "btn_retrieve":
			formObj.subcmd.value = "";
			doActionIBSheet(sheetObj, formObj, SEARCH);
			break;
		case "btn_new":
			formObj.reset();
			initSheet(sheetObj, 2)
			break;
		case "btn_downexcel":
			sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			break;
		case "btn_print":
			if (sheetObj.RowCount == 0) {
				ComShowCodeMessage("BKG00889");
				return;
			}
			ComOpenWindowCenter("/hanjin/ESM_BKG_0840.do?pgmNo=ESM_BKG_0840", "0840", 1024, 768, false);
			break;
		case "btn_blInquiry":
			if (validateForm(sheetObj, formObj, COMMAND01)) {
				var bl_no = sheetObj.CellValue(row, "bl_no");
				if (bl_no != "")
					ComOpenWindowCenter("/hanjin/ESM_BKG_0029.do?pgmNo=ESM_BKG_0029_2&type=edit&bl_no=" + bl_no, "0029", 1020, 660);
			}
			break;
		case "btn_history":
			if (validateForm(sheetObj, formObj, COMMAND01)) {
				var bl_no = sheetObj.CellValue(row, "bl_no");
				var vvd_cd = sheetObj.CellValue(row, "vvd_cd");
				var url = "/hanjin/ESM_BKG_0431.do?pgmNo=ESM_BKG_0431&bl_no=" + bl_no + "&vvd_cd=" + vvd_cd + "&f_cmd=" + SEARCH;
				ComOpenWindowCenter(url, "0431", 1020, 660, true);
			}
			break;
		case "btn_viewMsg":
			if (validateForm(sheetObj, formObj, COMMAND01)) {
				sheet1_OnDblClick(sheetObj, sheetObj.SelectRow, 0);
			}
			break;
		case "btn_37":
			formObj.subcmd.value = "37";
			if (ComIsBtnEnable("btn_37"))
				doActionIBSheet(sheetObj, formObj, SEARCH);

			break;
		case "btn_21":
			formObj.subcmd.value = "21";
			if (ComIsBtnEnable("btn_21"))
				doActionIBSheet(sheetObj, formObj, SEARCH);
			break;
		case "btn_snd_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObj.s_snd_dt, formObj.e_snd_dt, 'yyyy-MM-dd');
			break;
		case "btn_rcv_calendar":
			var cal = new ComCalendarFromTo();
			cal.select(formObj.s_rcv_dt, formObj.e_rcv_dt, 'yyyy-MM-dd');
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
 * 콤보 Object를 배열로 등록
 * @param combo_obj 콤보오브젝트
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch
 * @param sheetObj IBSheet Object
 * @param CondParam 파라메터
 * @param PageNo 페이지번호
 * @param OnePageRows 한번에 보여지는 건수
 */
function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
	doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
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
		sheetObjects[i].WaitImageVisible = false;
	}
	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;
	// IBMultiCombo초기화
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	document.form.vvd_cd.focus();
	// 화면에서 필요한 이벤트
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('Click', 'obj_Click', document.form);
}

/**
 * 콤보 초기설정값
 * @param comboObj 콤보오브젝트
 */
function initCombo(comboObj) {
	comboObj.MultiSelect = true;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ",";
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
			style.height = 260;
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
			InitRowInfo(2, 1, 4, 100);

			var HeadTitle1 = "Seq.|VVD|POL|POD|B/L No.|Filer|C.STS|Stage|Status|Status|Reason|Type|Send Date|Receive Date|Error Note|ack_desc|result_desc|Error Field Desc|Message Text|manifest_ttl|sent_by_a6a|sent_by_al|target_ttl|unmanifest|total|processed|error";
			var HeadTitle2 = "Seq.|VVD|POL|POD|B/L No.|Filer|C.STS|Stage|Ack.|Result|Reason|Type|Send Date|Receive Date|Error Note|ack_desc|result_desc|Error Field Desc|Message Text|manifest_ttl|sent_by_a6a|sent_by_al|target_ttl|unmanifest|total|processed|error";
			var headCount = ComCountHeadTitle(HeadTitle1);

			// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false)

			// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,
			// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
			// INSERTEDIT,
			// EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
			// FORMATFIX]
			InitDataProperty(0, cnt++, dtDataSeq, 40, daCenter, true, "SEQ");
			InitDataProperty(0, cnt++, dtData, 90, daCenter, true, "vvd_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pol_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "pod_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 100, daCenter, true, "bl_no", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "cstms_file_tp_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 40, daCenter, true, "mf_sts_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 60, daCenter, true, "cstms_trsm_sts_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cstms_ack_rcv_rslt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "cstms_ack_proc_rslt_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 55, daCenter, true, "cstms_ack_rjct_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 50, daCenter, true, "full_mty_cd", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "amdt_snd_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 110, daCenter, true, "cstms_ack_rcv_dt", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 300, daLeft, true, "cstms_ack_rjct_msg", false, "", dfNone, 0, true, true);

			// HIDDEN
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "ack_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "result_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 500, daLeft, true, "err_cd_desc", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtData, 300, daLeft, true, "err_tp_ctnt", false, "", dfNone, 0, true, true);

			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "manifest_ttl", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "sent_by_a6a", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "sent_by_al", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "target_ttl", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "unmanifest", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "total", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "processed", false, "", dfNone, 0, true, true);
			InitDataProperty(0, cnt++, dtHidden, 30, daLeft, true, "error", false, "", dfNone, 0, true, true);

			sheetObj.DataLinkMouse("cstms_ack_rcv_rslt_cd") = true;
			sheetObj.DataLinkMouse("cstms_ack_proc_rslt_cd") = true;
			sheetObj.DataLinkMouse("cstms_ack_rjct_cd") = true;
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
function doActionIBSheet(sheetObj, formObj, sAction, CondParam, PageNo) {
	sheetObj.ShowDebugMsg = false;
	switch (sAction) {
	case INIT:
		//Status Combo
		formObj.f_cmd.value = INIT;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0142GS.do", FormQueryString(formObj));
		ComXml2ComboItem(sXml, formObj.cstms_ack_proc_rslt_cd, "attr_ctnt1", "attr_ctnt1|attr_ctnt2");
		formObj.cstms_ack_proc_rslt_cd.InsertItem(0, "", "");
		formObj.cstms_ack_proc_rslt_cd.DropHeight = 200;
		break;
	case SEARCH: //Retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESM_BKG_0142GS.do?page_no=", FormQueryString(formObj));
			if (sheetObj.RowCount > 0 && !formObj.rpt_flag[2].checked) {
				IBS_CopyRowToForm(sheetObj, formObj, 2, "frm_");
				for ( var i = 0; i < formObj.elements.length; i++) {
					if (formObj.elements[i].name.indexOf("frm_") >= 0)
					{
						formObj.elements[i].value = ComAddComma2(formObj.elements[i], "#,###");
					}
				}
			} else {
				for ( var i = 0; i < formObj.elements.length; i++) {
					if (formObj.elements[i].getAttribute("readonly") == true) {
						formObj.elements[i].value = "";
					}
				}
			}
			for ( var i = 2; i <= sheetObj.RowCount + 1; i++) {
				sheetObj.CellFontColor(i, "cstms_ack_rcv_rslt_cd") = sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFontUnderline(i, "cstms_ack_rcv_rslt_cd") = true;
				sheetObj.CellFontColor(i, "cstms_ack_proc_rslt_cd") = sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFontUnderline(i, "cstms_ack_proc_rslt_cd") = true;
				sheetObj.CellFontColor(i, "cstms_ack_rjct_cd") = sheetObj.RgbColor(0, 0, 255);
				sheetObj.CellFontUnderline(i, "cstms_ack_rjct_cd") = true;
				if (sheetObj.CellValue(i, "cstms_ack_proc_rslt_cd") == "37"
					|| sheetObj.CellValue(i, "cstms_ack_proc_rslt_cd") == "44"
						|| sheetObj.CellValue(i, "cstms_ack_proc_rslt_cd") == "21"
							|| sheetObj.CellValue(i, "cstms_ack_proc_rslt_cd") == "48") {
					sheetObj.RowFontColor(i) = sheetObj.RgbColor(255, 0, 0);
				} else if (sheetObj.CellValue(i, "cstms_ack_proc_rslt_cd") == "01") {
					sheetObj.RowFontColor(i) = sheetObj.RgbColor(0, 0, 255);
				}
			}
			ComOpenWait(false);
		}
		break;
	case IBSEARCHAPPEND: // 페이징 조회
		formObj.f_cmd.value = SEARCH;
		sheetObj.DoSearch("ESM_BKG_0142GS.do", CondParam, "page_no=" + PageNo, true);
		break;
	}
}

/**
 * Status 콤보를 클릭할 때 전체체크
 * @param comboObj 콤보오브젝트
 * @param index  index
 * @param code code
 */
function cstms_ack_proc_rslt_cd_OnCheckClick(comboObj, index, code) {
	if (code == "") {
		var bChk = comboObj.CheckIndex(index);
		for ( var i = 1; i < comboObj.GetCount(); i++) {
			comboObj.CheckIndex(i) = bChk;
		}
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
	case SEARCH: //Retrieve
		// 기본포멧체크
		if (!ComChkValid(formObj))
			return false;

		if (formObj.rpt_flag[0].checked || formObj.rpt_flag[1].checked) {
			// A6A, E10
			if (formObj.subcmd.value == "") {
				// Retrieve
				if (ComIsNull(formObj.vvd_cd) && ComIsNull(formObj.bl_no) && ComIsNull(formObj.s_snd_dt) && ComIsNull(formObj.s_rcv_dt)) {
					ComShowCodeMessage('BKG00626', 'VVD or B/L No or Send Date(From,To) or Receive Date(From, To)');
					return false;
				}
			} else {
				// 37/01, 21/01
				if (ComIsNull(formObj.bl_no) && ComIsNull(formObj.vvd_cd) && ComIsNull(formObj.s_rcv_dt)) {
					ComShowCodeMessage('BKG00626', 'VVD or B/L No or Receive Date(From, To)');
					return false;
				}
				break;
			}
		} else {
			// A6
			if (ComIsNull(formObj.vvd_cd) && ComIsNull(formObj.s_snd_dt) && ComIsNull(formObj.s_rcv_dt)) {
				ComShowCodeMessage('BKG00626', 'VVD or Send Date(From,To) or Receive Date(From, To)');
				return false;
			}
		}
		if (!ComIsNull(formObj.s_snd_dt.value)) {
			var diffDate = ComGetDaysBetween(formObj.s_snd_dt, formObj.e_snd_dt);
			var year = formObj.s_snd_dt.value.substring(0, 4);
			var month = formObj.s_snd_dt.value.substring(5, 7);
			var lastDay = ComGetLastDay(year, parseInt(month, 10));			
			if (diffDate + 1 > lastDay) {
				ComShowCodeMessage('BKG01080');
				formObj.e_snd_dt.select();
				return false;
			}
		}
		if (!ComIsNull(formObj.s_rcv_dt.value)) {
			var diffDate = ComGetDaysBetween(formObj.s_rcv_dt, formObj.e_rcv_dt);
			var year = formObj.s_rcv_dt.value.substring(0, 4);
			var month = formObj.s_rcv_dt.value.substring(5, 7);
			var lastDay = ComGetLastDay(year, parseInt(month, 10));
			
			if (diffDate + 1 > lastDay) {
				ComShowCodeMessage('BKG01080');
				formObj.e_rcv_dt.select();
				return false;
			}
		}
		break;
	case COMMAND01:
		if (sheetObj.RowCount <= 0) {
			ComShowCodeMessage('BKG00395');
			return false;
		}
		break;
	}
	return true;
}

/**
 * 마우스가 Sheet 위에서 움직일 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param Button 마우스버튼 방향
 * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
 * @param X X 좌표
 * @param Y Y 좌표
 */
function sheet1_OnMouseMove(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var row = sheetObj.MouseRow;
	var col = sheetObj.MouseCol;
	if (row > 0) {
		if (sheetObj.ColSaveName(col) == "cstms_ack_rcv_rslt_cd") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "ack_desc");
		} else if (sheetObj.ColSaveName(col) == "cstms_ack_proc_rslt_cd") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "result_desc");
		} else if (sheetObj.ColSaveName(col) == "cstms_ack_rjct_cd") {
			sheetObj.ToolTipText(row, col) = sheetObj.CellText(row, "err_cd_desc");
		}
	}
}

/**
 * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
 * @param sheetObj 시트오브젝트
 * @param row row Index
 * @param col col Index
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var p1 = sheetObj.CellValue(row, "cstms_ack_rcv_rslt_cd");
	var p2 = sheetObj.CellValue(row, "ack_desc");
	var p3 = sheetObj.CellValue(row, "cstms_ack_proc_rslt_cd");
	var p4 = sheetObj.CellValue(row, "result_desc");
	var p5 = sheetObj.CellValue(row, "cstms_ack_rjct_msg");
	var p6 = sheetObj.CellValue(row, "cstms_ack_rjct_cd");
	var p7 = sheetObj.CellValue(row, "err_cd_desc");
	var p8 = sheetObj.CellValue(row, "err_tp_ctnt");
	ComOpenWindowCenter("/hanjin/ESM_BKG_0433.do?pgmNo=ESM_BKG_0433&p1=" + p1 + "&p2=" + p2 + "&p3=" + p3 + "&p4=" + p4 + "&p5=" + p5 + "&p6=" + p6 + "&p7="
			+ p7 + "&p8=" + p8, "0433", 520, 420);
}

/**
 * 버튼 Disable 
 */
function obj_Click() {
	if (document.form.rpt_flag[2].checked) {
		ComBtnDisable("btn_37");
		ComBtnDisable("btn_21");
	} else {
		ComBtnEnable("btn_37");
		ComBtnEnable("btn_21");
	}
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
	if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}