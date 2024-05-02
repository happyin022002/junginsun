/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_TRS_0973.jsp
 *@FileTitle : JOEDI History
 *@author     : CLT
 *@version    : 1.0
 *@since      : 
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
document.onclick = processButtonClick;

function ESD_TRS_0973() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
}

function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_close":
				ComClosePopup();
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items <br>
 * defining list on the top of source <br>
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * adding first-served functions after loading screen. <br>
 */
function loadPage() {
	for (var i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	$('.GMFocusRowBackground').css('background-color', '#ffffff');
	$('.GMFocusRowBorder').css('border', '0px solid #6db3fe');
	$('.GMFocusCellBorder').css('border', '0px solid #1183f7');
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetObj.id) {
		case "sheet1":
			with (sheetObj) {
				var HeadTitle1 = "Container/COP|S/O|W/O|S/P Code|S/P Name|Message|Message|Message|Message|Message|Message";
				var HeadTitle2 = "Container/COP|S/O|W/O|S/P Code|S/P Name|Bound|Type|Type|Date|Typd Code|Edi Msg Seq";
				SetConfig({ SearchMode : 2, MergeSheet : 7, Page : 20, FrozenCol : 0, DataRowMerge : 0 , SelectionRowsMode:1, PrevColumnMergeMode:0});
				var info = { Sort : 0, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 1, SaveName : "eq_cop_no", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 1, SaveName : "so_no", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 120, Align : "Center", ColMerge : 1, SaveName : "wo_no", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 80,  Align : "Center", ColMerge : 1, SaveName : "vndr_seq", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 250, Align : "left",   ColMerge : 1, SaveName : "vndr_lgl_eng_nm", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 100, Align : "Center", ColMerge : 0, SaveName : "msg_bnd_nm", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 0, Width : 150, Align : "left", 	ColMerge : 0, SaveName : "msg_tp_nm", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Image",Hidden : 0, Width : 25,  Align : "Center", ColMerge : 0, SaveName : "pop_img", UpdateEdit:0,   InsertEdit:0, ImgHeight:20, ImgWidth:19 },
						{ Type : "Text", Hidden : 0, Width : 130, Align : "Center", ColMerge : 0, SaveName : "cre_dt", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 1, Width : 0,   Align : "Center", ColMerge : 0, SaveName : "msg_tp_cd", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text", Hidden : 1, Width : 0,   Align : "left", 	ColMerge : 0, SaveName : "edi_msg_seq", UpdateEdit:0,   InsertEdit:0 }
				];
				InitColumns(cols);
				SetImageList(1, "img/btns_search_g.gif");
				resizeSheet(sheetObj);
			}
			break;
	}
}
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch("ESD_TRS_0973GS.do", TrsFrmQryString(formObj));
			break;
		}
	}
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 */
function sheet1_OnClick(sheetObj, Row, Col) {
	if(sheetObj.ColSaveName(Col) == "pop_img" && sheetObj.GetCellValue(Row, "msg_tp_cd") == 'P') {
		var sono = sheetObj.GetCellValue(Row, 'so_no');
		var ediMsgSeq = sheetObj.GetCellValue(Row, 'edi_msg_seq');
		ComOpenWindowCenter("ESD_TRS_0972.do?history=Y&so_no=" + sono + "&rcv_msg_seq=" + ediMsgSeq , 'ESD_TRS_0972', 1200, 560, false, false);		
	}
}
