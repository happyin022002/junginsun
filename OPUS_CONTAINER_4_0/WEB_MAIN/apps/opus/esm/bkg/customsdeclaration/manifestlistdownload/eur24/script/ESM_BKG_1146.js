/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1146.js
*@FileTitle  : ESM_BKG_1146
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* 개발자 작업 */
// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var state = "";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI02);
			break;
		case "btn_Select":
			doActionIBSheet(sheetObject, formObject, MULTI01);
			break;
		case "btn_Close":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btn_RowAdd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
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
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 * 
 * @param sheet_obj
 *            IBSheet Object
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
		
		// exs b/l inquiry화면이 부모일 경우만 save , row add 버튼 보이게
		if (form.pgm_no.value == "") {
			document.getElementById("btn_RowAdd").style.display = "none";
			document.getElementById("btn_Save").style.display = "none";
		} else {
			document.getElementById("btn_RowAdd").style.display = "inline";
			document.getElementById("btn_Save").style.display = "inline";
		}
	}
	initControl();
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
	// ** Date 구분자 **/
	DATE_SEPARATOR = "-";
	var formObject = document.form;
	//axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); // -
	axon_event.addListenerform('keydown', 'ComKeyEnter', formOject);
	//axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * 조회조건 입력할 때 처리
 */
function obj_KeyUp() {
	var formObject = document.form;
	var srcName = ComGetEvent("name");
	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
	var srcValue = window.event.srcElement.getAttribute("value");
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}
}
/**
 * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
 */
function obj_keypress() {
	switch (event.srcElement.dataformat) {
	case "uppernum":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('uppernum');
		break;
	case "upper":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyOnlyAlphabet('upper');
		break;
	case "uppernum2":
		// 영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
		ComKeyAlphabetNChar('uppernum');
		break;
	default:
		// 숫자만입력하기(정수,날짜,시간)
		ComKeyOnlyNumber(ComGetEvent());
	}
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * 
 * @param sheetObj
 *            시트오브젝트
 * @param sheetNo
 *            시트오브젝트 태그의 아이디에 붙인 일련번호
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetId = sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
        with(sheetObj){
		var HeadTitle1=" |Sel.|bl_no|RCV DT|STATUS|mf_no|ref_gds_itm_nm|PREV_DOC_NO|SubPlace|FIXED";
		var headCount=ComCountHeadTitle(HeadTitle1);
		
		SetConfig( { SearchMode:2, MergeSheet:5, Page:100, FrozenCol:0, DataRowMerge:1 } );
		
		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);
		
		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					{Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"msg_func_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mf_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ref_gds_itm_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prev_doc_nos",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pre_vsl_dchg_yd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"fixed",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		   
		InitColumns(cols);
		SetEditable(1);
		SetWaitImageVisible(0);
        SetSheetHeight(250);
		}


		break;
	}
}
/**
 * Sheet관련 프로세스 처리
 * 
 * @param sheetObj
 *            Sheet
 * @param formObj
 *            form객체
 * @param sAction
 *            작업처리코드
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBINSERT: // 입력
		sheetObj.DataInsert(-1);
		var nowRow = sheetObj.GetSelectRow();
		sheetObj.SetCellValue(nowRow, "msg_func_id", "M", 0);
		sheetObj.SetCellEditable(nowRow, "msg_func_id", 0);
		sheetObj.SetCellEditable(nowRow, "cre_dt", 0);
		break;
	case IBSEARCH: // 조회
		formObj.f_cmd.value = SEARCH;
		formObj.cnt_cd.value = formObj.pol_cd.value.substr(0, 2);
		ComOpenWait(true);
		sheetObj.DoSearch("ESM_BKG_1146GS.do", FormQueryString(formObj));
		break;
	case MULTI01: // SELECT
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		if (form.pgm_no.value == "") {
			// 부모가 EXS 가 아닌 경우
			var obj = new Object();
			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "chk") == "1"
						|| sheetObj.GetCellValue(i, "chk") == "Y") {
					obj.cd = sheetObj.GetCellValue(i, "mf_no");
					obj.nm = sheetObj.GetCellValue(i, "ref_gds_itm_nm");
					break;
				}
			}
			if (obj.cd != "") {
				window.returnValue = obj;
				ComClosePopup();
			}
		} else {
			// 부모가 EXS
			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				if (sheetObj.GetCellValue(i, "chk") == "1"
						|| sheetObj.GetCellValue(i, "chk") == "Y") {
					sheetObj.SetRowStatus(i, "I");
				} else {
					sheetObj.SetRowStatus(i, "");
				}
			}
			formObj.f_cmd.value = MULTI01;
			if (!ComShowCodeConfirm("COM12158", "[Prev. Doc No]")) {
				return false;
			}
			var sParam = sheetObjects[0].GetSaveString();
			// alert("sParam : " + sParam);
			sParam += "&" + FormQueryString(formObj);
			ComOpenWait(true);
			var sXml = sheetObj.GetSaveData("ESM_BKG_1146GS.do", sParam);
			var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (state == "S") {
				doActionIBSheet(sheetObj, document.form, IBSEARCH);
				// ComShowCodeConfirm("BKG00102");
				ComShowCodeMessage("BKG00102");
			}
		}
		break;
	case MULTI02: // SAVE (Prev. Doc Append)
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetRowStatus(i) == "I") {
				if (sheetObj.GetCellValue(i, "prev_doc_nos") != "") {
					sheetObj.SetCellValue(i, "mf_no", sheetObj.GetCellValue(i,
							"prev_doc_nos").substring(0, 11));
					sheetObj.SetCellValue(i, "ref_gds_itm_nm", sheetObj
							.GetCellValue(i, "prev_doc_nos").substring(11));
					sheetObj.SetCellValue(i, "bl_no", formObj.bl_no.value);
				} else {
					sheetObj.SetRowStatus(i, "");
				}
			} else {
				sheetObj.SetRowStatus(i, "");
			}
		}
		// 1. Prev. Doc 수신 테이블에 insert 작업
		formObj.f_cmd.value = MULTI02;
		if (!ComShowCodeConfirm("BKG00498", "[Prev. Doc No]")) {
			return false;
		}
		var sParam = sheetObjects[0].GetSaveString();
		// alert("sParam : " + sParam);
		sParam += "&" + FormQueryString(formObj);
		var sXml = sheetObj.GetSaveData("ESM_BKG_1146GS.do", sParam);
		var state = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (state == "S") {
			sheetObj.RenderSheet(0);
			sheetObj.LoadSearchData(sXml, {
				Sync : 1
			});
			sheetObj.RenderSheet(1);
		} else {
			ComShowMessage(ComResultMessage(sXml));
		}
		doActionIBSheet(sheetObj, document.form, IBSEARCH);
		break;
	case COMMAND01:
		if (form.pgm_no.value == "") {
			ComClosePopup();
		}
		if (!comPopupOK(sheetObj, formObj, sAction))
			return false;
		break;
	}
}
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 * 
 * @param sheetObj
 *            Sheet
 * @param formObj
 *            form객체
 * @param sAction
 *            작업처리코드
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // 조회
		break;
	case MULTI01: // Prev. Doc Select
		// empty row 삭제
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "prev_doc_nos") == "") {
				sheetObj.SetRowHidden(i, "1");
			}
		}
		// 중복 체크
		var allListPreDoc = "";
		var addListPreDoc = "";
		var sameFlag = false;
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "prev_doc_nos") == "")
				continue;
			allListPreDoc = sheetObj.GetCellValue(i, "prev_doc_nos")
					+ sheetObj.GetCellValue(i, "pre_vsl_dchg_yd_nm");
			if (sameFlag)
				break;
			for ( var j = sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
				if (sheetObj.GetCellValue(j, "prev_doc_nos") == "")
					continue;
				if (sheetObj.GetRowStatus(j) == "I") {
					addListPreDoc = sheetObj.GetCellValue(j, "prev_doc_nos")
							+ sheetObj.GetCellValue(j, "pre_vsl_dchg_yd_nm");
					if (i != j && allListPreDoc == addListPreDoc) {
						// ComShowMessage("Duplicated value exists.");
						ComShowCodeMessage("BKG06134");
						sameFlag = true;
						sheetObj.SetRowBackColor(j, "#FFFFC0");
						break;
					}
				}
			} // end for(j)
		} // end for(i)
		if (sameFlag)
			return false;
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (form.pgm_no.value == "")
				break;
			if (sheetObj.GetCellValue(i, "cre_dt") == "") {
				// ComShowMessage("Prev. Doc No is created. SAVE please!");
				ComShowCodeMessage("BKG06137", "created", "SAVE");
				return false;
			}
			if (sheetObj.GetCellValue(i, "chk") == "1"
					|| sheetObj.GetCellValue(i, "chk") == "Y") {
				if (sheetObj.GetCellValue(i, "fixed") == sheetObj.GetCellValue(
						i, "prev_doc_nos")
						+ sheetObj.GetCellValue(i, "pre_vsl_dchg_yd_nm")) {
					// ComShowMessage("Nothing Changed!!!");
					ComShowCodeMessage("BKG00737");
					return false;
				}
			}
		}
		return true;
		break;
	case MULTI02: // Prev. Doc Save
		// empty row 삭제
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "prev_doc_nos") == "") {
				sheetObj.SetRowHidden(i, "1");
			}
		}
		// 중복 체크
		var allListPreDoc = "";
		var addListPreDoc = "";
		var sameFlag = false;
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "prev_doc_nos") == "")
				continue;
			allListPreDoc = sheetObj.GetCellValue(i, "prev_doc_nos")
					+ sheetObj.GetCellValue(i, "pre_vsl_dchg_yd_nm");
			if (sameFlag)
				break;
			for ( var j = sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
				if (sheetObj.GetCellValue(j, "prev_doc_nos") == "")
					continue;
				if (sheetObj.GetRowStatus(j) == "I") {
					addListPreDoc = sheetObj.GetCellValue(j, "prev_doc_nos")
							+ sheetObj.GetCellValue(j, "pre_vsl_dchg_yd_nm");
					if (i != j && allListPreDoc == addListPreDoc) {
						// ComShowMessage("Duplicated value exists.");
						ComShowCodeMessage("BKG06134");
						sameFlag = true;
						sheetObj.SetRowBackColor(j, "#FFFFC0");
						break;
					}
				}
			} // end for(j)
		} // end for(i)
		if (sameFlag)
			return false;
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "prev_doc_nos") == "")
				continue;
			if (formObj.pol_cd.value.indexOf("ES") > -1
					&& sheetObj.GetCellValue(i, "prev_doc_nos").length < 12) {
				// ComShowMessage("Length of Prev.DocNo must be greater than 11
				// digit.");
				ComShowCodeMessage("BKG06135");
				return false;
			}
			if (formObj.pol_cd.value.indexOf("PT") > -1
					&& sheetObj.GetCellValue(i, "prev_doc_nos").length != 23) {
				// ComShowMessage("Length of Prev.DocNo must be 23 digit.");
				ComShowCodeMessage("BKG06136");
				return false;
			}
		}
		return true;
		break;
	case COMMAND01:
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "cre_dt") == "") {
				// ComShowMessage("Prev. Doc No is created. SAVE please!");
				ComShowCodeMessage("BKG06137", "created", "SAVE");
				return false;
			}
			if (sheetObj.GetCellValue(i, "chk") == "1"
					|| sheetObj.GetCellValue(i, "chk") == "Y") {
				if (sheetObj.GetCellValue(i, "fixed") != sheetObj.GetCellValue(
						i, "prev_doc_nos")
						+ sheetObj.GetCellValue(i, "pre_vsl_dchg_yd_nm")) {
					// ComShowMessage("Prev. Doc No is changed. SELECT
					// please!");
					ComShowCodeMessage("BKG06137", "changed", "SELECT");
					return false;
				}
			}
		}
		return true;
		break;
	}
}
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
	with (sheetObj) {
		ComOpenWait(false);
		// 현재 check 되어있는 fixed 값에 대한 row 를 pink 컬러로 표시
		for ( var i = HeaderRows(); i <= LastRow(); i++) {
			if (GetCellValue(i, "chk") == "1" || GetCellValue(i, "chk") == "Y") {
				SetRowBackColor(i, "#FFDCF1");// pink
			}
			SetCellEditable(i, "cre_dt", 0);
			SetCellEditable(i, "msg_func_id", 0);
			SetCellEditable(i, "prev_doc_nos", 0);
			SetCellEditable(i, "pre_vsl_dchg_yd_nm", 0);
		}
	}// end with
	
}
function sheet1_OnClick(sheetObj, row, col) {
	var rowCnt = sheetObj.RowCount();
	var check = sheetObj.GetCellValue(row, "chk");
	var colSaveName = sheetObj.ColSaveName(col);
	switch (colSaveName) {
	/* Check Box 클릭시 머리클릭 처리 */
	case "chk":
		for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetCellValue(i, "chk") == "1"
					|| sheetObj.GetCellValue(i, "chk") == "Y") {
				sheetObj.SetCellValue(i, "chk", 0, 0);
			}
		} // end for(i)
		break;
	} // end switch
}
function comPopupOK(sheetObj, formObj, sAction) {
	//if (!validateForm(sheetObj, formObj, sAction))	return false;
	if (!opener) {
		opener = window.dialogArguments;
		if (!opener) opener=parent; //이 코드 추가할것
	}
	for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		if (sheetObj.GetCellValue(i, "chk") == "1"
				|| sheetObj.GetCellValue(i, "chk") == "Y") {
			if (sheetObj.GetCellValue(i, "fixed") == sheetObj.GetCellValue(i,
					"prev_doc_nos")
					+ sheetObj.GetCellValue(i, "pre_vsl_dchg_yd_nm")) {
				opener.document.form.prev_doc_no.value = sheetObj.GetCellValue(
						i, "prev_doc_nos");
				opener.document.form.prev_doc_yd.value = sheetObj.GetCellValue(
						i, "pre_vsl_dchg_yd_nm");
			}
		}
	} // end for(i)
	ComClosePopup();
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComOpenWait(false);
}

function ComClosePopup(){
	if(parent) $(parent.document).find(".layer_popup,.layer_popup_bg").fadeOut(100);
	if(opener) window.close();
}
/* 개발자 작업 끝 */
