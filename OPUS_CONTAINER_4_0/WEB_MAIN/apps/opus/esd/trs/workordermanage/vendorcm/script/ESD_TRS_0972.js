/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_TRS_0972.jsp
 *@FileTitle : Vendor CM
 *@author     : CLT
 *@version    : 1.0
 *@since      : 
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var openObject;
document.onclick = processButtonClick;
openObject = opener;
if (!openObject) {
	openObject = parent;
}

/**
 * 
 * @returns
 */
function ESD_TRS_0972() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
}

/**
 * 
 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_accept": {
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var arrRow = checkList.split("|");
				if (checkList == '') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				doActionIBSheet(sheetObject, formObject, MULTI01);
				break;
			}
			case "btn_reject": {
				var checkList = sheetObject.FindCheckedRow('ibcheck');
				var arrRow = checkList.split("|");
				if (checkList == '') {
					ComShowCodeMessage('COM12176');
					return false;
				}
				doActionIBSheet(sheetObject, formObject, MULTI02);
				break;
			}
			case "btn_close": {
				ComClosePopup();
				break;
			}
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
	if(history_flag != 'Y') {
		$('#btn_accept').show();
		$('#btn_reject').show();
	}
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	$('.GMFocusRowBackground').css('background-color', '#ffffff');
	$('.GMFocusRowBorder').css('border', '0px solid #6db3fe');
	$('.GMFocusCellBorder').css('border', '0px solid #1183f7');	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
		case 1:
			with (sheetObj) {
				var HeadTitle1 = "VND_CM_GROUP||W/O|S/O|Container|Date|Type|rcv_msg_tp_cd|Entity|Reject\nReason|Element|Element|New Value|New Value|New Value|Old Value|Old Value|Old Value|trsp_so_ofc_cty_cd|trsp_so_seq|trsp_wo_ofc_cty_cd|trsp_wo_seq|max_rcv_msg_seq|ibflag";
				var HeadTitle2 = "VND_CM_GROUP||W/O|S/O|Container|Date|Type|rcv_msg_tp_cd|Entity|Reject\nReason|n_curr_cd|Element|Curr.|Value|Fuel\nRatio|Curr.|Value|Fuel\nRatio|trsp_so_ofc_cty_cd|trsp_so_seq|trsp_wo_ofc_cty_cd|trsp_wo_seq|max_rcv_msg_seq|ibflag";
				SetConfig({ SearchMode : 2, MergeSheet : 7, Page : 20, FrozenCol : 0, DataRowMerge : 0 , PrevColumnMergeMode:0});
				var info = { Sort : 0, ColMove : 1, HeaderCheck : 1, ColResize : 1 };
				var headers = [{ Text : HeadTitle1, Align : "Center" }, { Text : HeadTitle2, Align : "Center" }];
				InitHeaders(headers, info);
				var cols = [
						{ Type : "Text",   Hidden:1,  Width:30,      Align:"Center",    ColMerge : 1, SaveName:"vnd_cm_group" },
						{ Type : "CheckBox",  Hidden:0,  Width:30,   Align:"Center",     ColMerge : 1, SaveName:"ibcheck" },
						{ Type : "Text",   Hidden : 0, Width : 80,   Align : "Center", ColMerge : 1, SaveName : "wo_no", 			UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 80,   Align : "Center", ColMerge : 1, SaveName : "so_no", 			UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 120,  Align : "Center", ColMerge : 1, SaveName : "eq_cop_no", 		UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 120,  Align : "Center", ColMerge : 1, SaveName : "locl_cre_dt", 		UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 100,  Align : "Center", ColMerge : 1, SaveName : "rcv_msg_tp_cd_nm", UpdateEdit:0,   InsertEdit:0 },						
						{ Type : "Text",   Hidden : 1, Width : 100,  Align : "Center", ColMerge : 1, SaveName : "rcv_msg_tp_cd", 	UpdateEdit:0,   InsertEdit:0 },						
						{ Type : "Text",   Hidden : 0, Width : 80,   Align : "left",   ColMerge : 1, SaveName : "rcv_msg", 			UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 100,  Align : "left",   ColMerge : 1, SaveName : "edi_rjct_rsn_cd_nm", UpdateEdit:0, InsertEdit:0 },
						{ Type : "Text",   Hidden : 1, Width : 100,  Align : "Center", ColMerge : 0, SaveName : "n_lgs_cost_cd", 	UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 150,  Align : "left",   ColMerge : 0, SaveName : "n_lgs_cost_cd_nm", UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 1, Width : 100,  Align : "Center", ColMerge : 0, SaveName : "n_curr_cd", 		UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 150,  Align : "left",   ColMerge : 0, SaveName : "n_rcv_amt", 		UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 70,   Align : "right",  ColMerge : 0, SaveName : "n_fuel_rto", 		UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 1, Width : 100,  Align : "Center", ColMerge : 0, SaveName : "o_curr_cd", 		UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 150,  Align : "left",   ColMerge : 0, SaveName : "o_rcv_amt", 		UpdateEdit:0,   InsertEdit:0 },
						{ Type : "Text",   Hidden : 0, Width : 70,   Align : "right",  ColMerge : 0, SaveName : "o_fuel_rto", 		UpdateEdit:0,   InsertEdit:0 },	
						{ Type : "Text",   Hidden : 1, Width : 30,   Align : "Center", ColMerge : 0, SaveName : "trsp_so_ofc_cty_cd", UpdateEdit:0, InsertEdit:0  },
						{ Type : "Text",   Hidden : 1, Width : 30,   Align : "Center", ColMerge : 0, SaveName : "trsp_so_seq", 		UpdateEdit:0,   InsertEdit:0  },
						{ Type : "Text",   Hidden : 1, Width : 30,   Align : "Center", ColMerge : 0, SaveName : "trsp_wo_ofc_cty_cd", UpdateEdit:0, InsertEdit:0  },
						{ Type : "Text",   Hidden : 1, Width : 30,   Align : "Center", ColMerge : 0, SaveName : "trsp_wo_seq", 		UpdateEdit:0,   InsertEdit:0  },						
						{ Type : "Text",   Hidden : 1, Width : 100,  Align : "Center", ColMerge : 0, SaveName : "max_rcv_msg_seq", 	UpdateEdit:0,   InsertEdit:0 },	
						{ Type : "Status", Hidden : 1, Width : 30,   Align : "Center", ColMerge : 0, SaveName : "ibflag" }
				];
				InitColumns(cols);
				resizeSheet();
			}
			break;
	}
}
/**
 * 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
		case IBSEARCH: {
			formObj.f_cmd.value = SEARCHLIST;
			sheetObj.DoSearch("ESD_TRS_0972GS.do", TrsFrmQryString(formObj), { Sync : 2 });
			break;
		}
		case MULTI01: {
			formObj.f_cmd.value = MULTI01;
			sheetObj.DoAllSave("ESD_TRS_0972GS.do", TrsFrmQryString(formObj));
			break;
		}
		case MULTI02: {
			formObj.f_cmd.value = MULTI02;
			sheetObj.DoAllSave("ESD_TRS_0972GS.do", TrsFrmQryString(formObj));
			break;
		}
	}
}

function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj = document.form;
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	//openObject.fnOpenRetrieveEvent();
	openObject.afterChangeMgmt();
}
/**
 * 
 */
function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
}