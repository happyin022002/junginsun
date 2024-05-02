/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ees_lse_0023_POP.js
 *@FileTitle  : EQ Component
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2015/03/15
=========================================================*/
/*******************************************************************************
 * Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3; MODIFY=4; REMOVE=5;
 * REMOVELIST=6 MULTI=7 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ******************************************************************************/
/* 공통전역변수 */
// var calPop = new calendarPopupGrid();
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet = null
var sheetObj = sheetObjects[0];
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
// 공통전역변수
var Mincount = 0;
var sTgtLocCdNm = "";
var strEqLocTpNm = "";
var strLocCd = "";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	/** **************************************************** */
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;

		case "btn_rowdelete":
			if (sheetObject.FindCheckedRow("check") == "") {
				ComShowCodeMessage("MST00010");
			} else {
				doActionIBSheet(sheetObject, formObject, IBDELETE);
			}
			break;
			
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;

		case "btn_select":
			var Row = sheetObject.RowCount();
			comPopSelect(sheetObj, formObject);
			break;

		case "btn_close":
			ComClosePopup();
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
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
}
/**
 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> sheetObject, sheetNo ==> sheetObject tag
 * serial number 시트가 다수일 경우 시트 수만큼 case를 추가하여 initializing sheet모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			var HeadTitle = "Flag|Sel|Seq|Level|Place|";
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"check",              KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq_num",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:5 },
			             {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"hid_eq_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			
			InitColumns(cols);
			SetSheetHeight(300);
			SetEditable(1);
			SetEditableColorDiff(0);
			SetSelectionMode(smSelectionRow);
			SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
		}
		break;
	}
}
// handling sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBINSERT: // Row Add
		var rowAdd = sheetObj.DataInsert(-1);
		var arrStr = sTgtLocCdNm.split("@");
		var arrCode = "";
		var arrName = "";
		var strCode = "";
		var strName = "";
		for ( var i = 0; i < arrStr.length; i++) {
			arrCode = arrStr[i].split("|");
			arrName = arrStr[i].split("|");
			if (i == 0) {
				strCode = arrCode[0];
				strName = arrCode[1];
			} else {
				strCode = strCode + "|" + arrCode[0];
				strName = strName + "|" + arrCode[1];
			}
		}
		sheetObjects[0].SetColProperty(0, "eq_loc_tp_cd", {
			ComboText : strName,
			ComboCode : strCode
		});
		sheetObjects[0].SetCellValue(rowAdd, "loc_cd", "ALL", 0);
		sheetObjects[0].SetCellValue(rowAdd, "hid_eq_loc_tp_cd", "AL", 0);
		break;

	case IBDELETE:
		sheetObj.SelectFontBold = false;
		if (sheetObj.RowCount() > 0) {
			for(var i=sheetObj.RowCount(); i >= 1; i--) {
				if (sheetObj.GetCellValue(i, "check") == "1") {
					sheetObj.RowDelete(i, false);
				}
			}
			sheetObj.SelectFontBold = true;
		}
		break;
		
	case IBSAVE:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			if(sheetObj.id == "sheet1") {
				formObj.f_cmd.value = MULTI;
				var xml = sheetObj.DoSave("EES_LSE_0023GS.do", FormQueryString(formObj));
			}
		}
		break;

	case IBCREATE:
		// Target Location Combo Item Setting Start
		formObj.f_cmd.value = SEARCH01;
		var intgCdId = 'CD30026';
		var param = "&intgCdId=" + intgCdId;
		var xml = sheetObj.GetSearchData("EES_CIM_COMGS.do",
				FormQueryString(formObj) + param);
		var chk = xml.indexOf("ERROR");
		if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1) {
			sheetObj.LoadSearchData(xml, {
				Sync : 1
			});
			return;
		}
		if (xml != "") {
			sTgtLocCdNm = ComGetEtcData(xml, "code_nm");
		}

		var eqLocTpNmArr = formObj.eq_loc_tp_nm.value.split(",");
		var locCdArr = formObj.loc_cd.value.split(",");
		var eqLocTpCdArr = formObj.eq_loc_tp_cd.value.split(",");
		for ( var k = 0; k < eqLocTpNmArr.length; k++) {
			sheetObj.DataInsert(-1);
			var arrStr = sTgtLocCdNm.split("@");
			var arrCode = "";
			var arrName = "";
			var strCode = "";
			var strName = "";
			for ( var i = 0; i < arrStr.length; i++) {
				arrCode = arrStr[i].split("|");
				arrName = arrStr[i].split("|");
				if (i == 0) {
					strCode = arrCode[0];
					strName = arrCode[1];
				} else {
					strCode = strCode + "|" + arrCode[0];
					strName = strName + "|" + arrCode[1];
				}
			}

			sheetObjects[0].SetColProperty(0, "eq_loc_tp_cd", {
				ComboText : strName,
				ComboCode : strCode
			});
			sheetObj.SetCellValue(k + 1, "eq_loc_tp_cd", eqLocTpNmArr[k]);
			sheetObj.SetCellValue(k + 1, "loc_cd", locCdArr[k]);
			sheetObj.SetCellValue(k + 1, "hid_eq_loc_tp_cd", eqLocTpCdArr[k]);
		}
		break;
	}
}

/**
 * handling in case of clicking image button on sheet1
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var formObj = document.form;
	var sName=sheetObj.ColSaveName(Col);
	var slocTpCd = sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
	switch (sName) {
		case "loc_cd":
			if(slocTpCd == "AL") {
				openLcPopupPage("1", Row, Col, 0);
			}else if(slocTpCd == "CT") {
				openLcPopupPage("2", Row, Col, 0);
			}else if(slocTpCd == "ST") {
				openLcPopupPage("3", Row, Col, 0);
			}else if(slocTpCd == "CN") {
				openLcPopupPage("4", Row, Col, 0);
			}else if(slocTpCd == "RC") {
				openLcPopupPage("5", Row, Col, 0);
			}else if(slocTpCd == "LC") {
				openLcPopupPage("6", Row, Col, 0);
			}else if(slocTpCd == "EC") {
				openLcPopupPage("7", Row, Col, 0);
			}else if(slocTpCd == "SC") {
				openLcPopupPage("8", Row, Col, 0);
			}else if(slocTpCd == "LO") {
				openLcPopupPage("9", Row, Col, 0);
			}
			break;
	}
}	
function openLcPopupPage(type, Row, Col, SheetIdx) {
	if(type == "2") {
		ComOpenPopup('/opuscntr/COM_ENS_0H1.do', 700, 382, 'setPopupData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}else if(type == "3") {
		ComOpenPopup('/opuscntr/COM_ENS_0I1.do', 750, 380, 'setPopupData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}else if(type == "4") {
		ComOpenPopup('/opuscntr/COM_ENS_0M1.do', 850, 530, 'setPopupData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}else if(type == "5") {
		ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setRCCPopData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}else if(type == "6") {
		ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setLCCPopData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}else if(type == "7") {
		ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setECCPopData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}else if(type == "8") {
		ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setSCCPopData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}else if(type == "9") {
		ComOpenPopup('/opuscntr/COM_ENS_051.do', 700, 460, 'setLOCPopData', '1,0,1,1,1,1,1,1', true, false, Row, Col, SheetIdx);
	}
}

function setPopupData(aryPopupData, Row, Col, ShtIdx) {
	if (aryPopupData[0].length > 0 ) {
        with (sheetObjects[ShtIdx]) {
            switch (ColSaveName(Col)) {
            case "loc_cd":                	
            	SetCellValue(Row, Col, aryPopupData[0][3],0);
            }
        }
	}
}

function setRCCPopData(aryPopupData, Row, Col, ShtIdx) {
	if (aryPopupData[0].length > 0 ) {
		with(sheetObjects[ShtIdx]) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "loc_cd":			
					SetCellValue(Row,Col,aryPopupData[0][11],0);		
					break;
			}
		}
	}
}

function setLCCPopData(aryPopupData, Row, Col, ShtIdx) {
	if (aryPopupData[0].length > 0 ) {
		with(sheetObjects[ShtIdx]) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "loc_cd":					
					SetCellValue(Row,Col,aryPopupData[0][10],0);	
					break;
			}
		}
	}
}

function setECCPopData(aryPopupData, Row, Col, ShtIdx) {
	if (aryPopupData[0].length > 0 ) {
		with(sheetObjects[ShtIdx]) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "loc_cd":					
					SetCellValue(Row,Col,aryPopupData[0][9],0);			
					break;
			}
		}
	}
}

function setSCCPopData(aryPopupData, Row, Col, ShtIdx) {
	if (aryPopupData[0].length > 0 ) {
		with(sheetObjects[ShtIdx]) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "loc_cd":
					var dupRow=FindText(Col, aryPopupData[0][8]);						
					SetCellValue(Row,Col,aryPopupData[0][8],0);						
					break;
			}
		}
	}
}


function setLOCPopData(aryPopupData, Row, Col, ShtIdx) {
	if (aryPopupData[0].length > 0 ) {
		with(sheetObjects[ShtIdx]) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "loc_cd":
					var dupRow=FindText(Col, aryPopupData[0][3]);	
					SetCellValue(Row,Col,aryPopupData[0][3],0);			
					break;
			}
		}
	}
}

/**
 * Validating inputted values of form
*/
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSAVE:
			var Cnt = sheetObj.RowCount();
	    	for(var i = 1; i <= Cnt; i++){
	    		if (sheetObj.GetRowStatus(i) != "R"){
					if (sheetObj.GetCellValue(i, "eq_loc_tp_cd") == "") {
						ComShowCodeMessage("LSE10032");
						return false;
					}
				} 
	    	}
	    	break;
			default :	//do nothing
			break;
		}
	return true;
}

/**
 * Sheet Column data Duplication handling<br>
 */
function checkDuplicateCol(sheetObj, Row, colName, Value, Value1) {
	var formObj=document.form;
	if ( Value != "" ) {
		if(sheetObj.id != "sheet1") {
			var dupRow=sheetObj.FindText(colName, Value);
			if ( dupRow != -1 && Row != dupRow && sheetObj.GetRowStatus(dupRow) != "D" ) {
				if ( sheetObj.id == "sheet1" ) {
					ComShowCodeMessage("LSE01008");
					sheetObj.SetCellValue(Row, colName," ",0);
				} else if ( sheetObj.id == "sheet1" ) {
					sheetObj.RowDelete(Row, false);
				} else if ( sheetObj.id == "sheet1" ) {
					if ( ComGetObjValue(combo1) == "LT" ) {
						ComShowCodeMessage("LSE01059");
					} else {
						ComShowCodeMessage("LSE01060");
					}
					sheetObj.SetCellValue(Row, colName,"",0);
				} else {
					ComShowCodeMessage("LSE01059");
					sheetObj.SetCellValue(Row, colName,"",0);
				}
			}
		}else{
			var dupRow=sheet1.FindText(colName, Value);
			//값이 없다면 -1 값이 있다면 이상
			if ( (dupRow != -1 && Row != dupRow && t1sheet1.GetRowStatus(dupRow) != "D")  ) {
				if(sheetObjects[6].GetCellValue(Row,"loc_cd") == sheetObjects[6].GetCellValue(dupRow,"loc_cd")) {
					ComShowCodeMessage("LSE01008");
					sheetObj.RowDelete(Row, false);
				}else{
					var dupRow1=t1sheet1.FindText(colName, Value);
					if(dupRow1 == -1) {
						ComShowCodeMessage("LSE01008");
						sheetObj.RowDelete(Row, false);
					}
				}
			}else{
				var dupRow1=t1sheet1.FindText(colName, Value);
				if(dupRow1 == -1) {
					ComShowCodeMessage("LSE01008");
					sheetObj.RowDelete(Row, false);
				}
			}
		}
	} else {
		if ( sheetObj.id == "t1sheet1" ) {
			sheetObj.SetCellValue(Row, colName," ",0);
		} else {
			sheetObj.SetCellValue(Row, colName,"",0);
		}
	}
}

function initControl() {
	var formObj=document.form;
	axon_event.addListenerFormat('keypress','obj_keypress',	form);
}

function obj_keypress() {
	var obj = ComGetEvent();
    var obj_name = ComGetEvent("name");
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    var vKeyCode = ComGetEvent("keycode");
    switch(obj.dataformat) {
    	case "engup":
    		if(obj_name=="loc_cd") ComKeyOnlyAlphabet('upper');
    		break;
    }
}
/**
 * handling event when changing Sheet.<br>
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	with (sheetObj) {
		var sName = ColSaveName(Col);
		switch (sName) {
		case "eq_loc_tp_cd":
			if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "AL") {
				sheetObj.SetCellValue(Row, "loc_cd", "ALL", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "AL", 0);
			} 
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "CT") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "CT", 0);
			}
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "ST") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "ST", 0);
			}
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "CN") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "CN", 0);
			}
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "RC") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "RC", 0);
			}
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "LC") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "LC", 0);
			}
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "SC") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "SC", 0);
			}
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "EC") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "EC", 0);
			}
			else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "LO") {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "LO", 0);
			}
			else {
				sheetObj.SetCellValue(Row, "loc_cd", "", 0);
				sheetObj.SetCellValue(Row, "hid_eq_loc_tp_cd", "", 0);
			}
			break;
		case "loc_cd":
			if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "CT" ) {
				if(Value.length != 1) {
					//Location Code의 길이가 1인지 확인
					 ComShowCodeMessage("LSE10032");
					 sheetObj.SetCellValue(Row, "loc_cd", "");
				}
			}else if (sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "ST" || sheetObj.GetCellValue(Row, "eq_loc_tp_cd") == "CN") {
				if(Value.length != 2) {
					//Location Code의 길이가 2인지 확인
					 ComShowCodeMessage("LSE10032");
					 sheetObj.SetCellValue(Row, "loc_cd", "");
				}
			} else {
				if (Value.length != 5) {
					//Location Code의 길이가 5인지 확인
					 ComShowCodeMessage("LSE10032");
					 sheetObj.SetCellValue(Row, "loc_cd", "");
				}
			}
			// Find right Place code for each eq_loc_tp_cd
			setAsyncData(sheetObj, Row, Col, Value);
			break;
		default:
			break;
		}
	}
}
/**
 * Sheet Object Location Code change, Validation handling<br>
 * @param sheetObj
 * @param Row Row index
 * @param Col Col index
 * @param Value
 */
function setAsyncData(sheetObj, Row, Col, Value, Type) {
	if (Type == undefined || Type == null) Type = "1";
	with(sheetObj) {
		if (GetCellValue(Row, Col) != "") {
			var loc_tp = "";
			var loc_col_nm = "";
			if (Value == "ALL") return;
			var param = "f_cmd="  + SEARCH21
			 + "&eq_loc_tp_cd=" + sheetObj.GetCellValue(Row,"eq_loc_tp_cd")
			 + "&loc_cd=" + Value
			 + "&loc_tp=" + loc_tp;
			
			SetWaitImageVisible(0);
			var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",param);
			SetWaitImageVisible(1);
			
			if(sXml != "") {
				if ( ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S" ) {
					if ( ComGetEtcData(sXml, loc_col_nm) != "" ) {
						var vLccCd=ComGetEtcData(sXml, loc_col_nm);
					} else {
						if ( type == "1" ) {
							ComShowCodeMessage("LSE01037");
						} else {
							SetCellValue(Row,Col,"",0);
						}
					}
				} else {
					if ( Type == "1" ) {
						ComShowCodeMessage("LSE01037");
						SetCellValue(Row,Col,"",0);
						SelectCell(Row,Col);
					} else {
						SetCellValue(Row,Col,"",0);
					}
				}
			}
		}
		
	}
}
/**
 * Calling rep_commodity pop-up
 * 

function rep_Multiful_inquiry1(sheetObj, Row, input_obj) {
	var formObj = document.form;
	var xx1 = input_obj;
	var eq_loc_tp_cd = sheetObj.GetCellValue(Row, "eq_loc_tp_cd");
	var loc_cd = sheetObj.GetCellValue(Row, "loc_cd");
	var param = "?returnval=" + xx1 + "&eq_loc_tp_cd=" + eq_loc_tp_cd
			+ "&loc_cd=" + loc_cd + "&returnrow=" + Row;
	ComOpenPopup('/opuscntr/EES_LSE_0023_01_POP.do' + param, 700, 500,
			'setPopupParam', '1,0', '', '', '', '', '', 'locPop');
}
*/

function comPopSelect(sheetObj, formObject) {
	var formObj = document.form;
	var checkRows;
	var colsCnt = sheetObj.LastCol() + 1;
	var rows = sheetObj.RowCount();

	var return_val = formObj.returnval.value;
	checkRows = sheetObj.CheckedRows("check");
	var return_row = formObj.returnrow.value;
	if (checkRows == 0) {
		ComShowCodeMessage("LSE01045");
		return;
	} else {
		var idx = 0;
		var strLocCd = "";
		var fullLocCd = "";
		
		var strEqLocTpNm ="";
        var fullEqLocTpNm = "";
		var strLocLevel = "";
		var arrLocLevel = "";
		var arrLocCd = "";

		var fullEqLocTpCd = "";
		var fullCd = "";
		
		for ( var i = 1; i < rows + 1; i++) {
			if (sheetObj.GetCellValue(i, "check") == 1) {

				strLocCd = sheetObj.GetCellValue(i, "loc_cd");
				strLocLevel = sheetObj.GetCellValue(i, "hid_eq_loc_tp_cd"); 
				strEqLocTpNm = ChangeCodeNm(strLocLevel);
				
				if (strLocLevel != "") {
					fullCd = fullCd + "," + strLocCd;
					fullEqLocTpCd = fullEqLocTpCd + "," + strLocLevel;
					fullEqLocTpNm = fullEqLocTpNm + "," + strEqLocTpNm;
				}

			}
		}

	}

	opener.getLse_Multi01(fullEqLocTpCd, fullCd, fullEqLocTpNm, return_row); // 호출하는 부모js에
																// getLse_Multi
																// 붙여넣으면 됩니다.
	ComClosePopup();
}

function getLse_Multi(rowArray, ret_row) {
	var formObj = document.form;
	var tempText = "";
	var tempText01 = "";
	// initializing
	var strEqLocTpCd = sheetObjects[0].GetCellValue(ret_row, "eq_loc_tp_cd");

	for ( var i = 0; i < rowArray.length; i++) {
		var colArray = rowArray[i];
		tempText += rowArray[i] + ',';
		tempText01 += strEqLocTpCd + ",";
	}
	// clearing comma(,)
	tempText = LseDelLastDelim(tempText);
	tempText = tempText.toUpperCase();

	tempText01 = LseDelLastDelim(tempText01);
	tempText01 = tempText01.toUpperCase();

	sheetObjects[0].SetCellValue(ret_row, "hid_eq_loc_tp_cd", tempText01, 0);
	sheetObjects[0].SetCellValue(ret_row, "loc_cd", tempText, 0);
}
/**
 * @param {String}
 * @return {String}
 * @author
 * @version 2009.06.04
 */
function LseDelLastDelim(str) {
	// 
	if (str != "") {
		str = str.substr(0, str.length - 1);
	}
	return str;
}


function ChangeCodeNm(code){
	var codeNm = "";
	switch(code)
	{
	case "AL" : 
		codeNm = "ALL";
		break;
	case "CT" :
		codeNm = "Continent";
		break;
	case "ST" : 
		codeNm = "Sub Continent";
		break;
	case "CN" : 
		codeNm = "Country";
		break;
	case "RC" : 
		codeNm = "RCC";
		break;
	case "LC" : 
		codeNm = "LCC";
		break;
	case "EC" : 
		codeNm = "ECC";
		break;
	case "SC" :
		codeNm = "SCC";
		break;
	case "LO" : 
		codeNm = "LOC";
		break;
	}
	return codeNm;
}
/* 개발자 작업 끝 */
