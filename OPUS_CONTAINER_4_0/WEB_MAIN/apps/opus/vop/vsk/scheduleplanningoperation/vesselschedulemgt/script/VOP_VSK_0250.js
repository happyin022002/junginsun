/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0250.jsp
*@FileTitle  : Port SKD Information(Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
// public variable
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
		switch (srcName) {
		case "btn_Close":
			ComClosePopup(); 
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
function loadPage() {
	var formObj=document.form;
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	formObj.vsl_cd.readOnly=true;
	formObj.skd_voy_no.readOnly=true;
	formObj.skd_dir_cd.readOnly=true;
	formObj.vps_port_cd.readOnly=true;
	formObj.clpt_ind_seq2.readOnly=true;
	formObj.skd_ind.readOnly=true;
	formObj.pf_eta_dt.readOnly=true;
	formObj.pf_etb_dt.readOnly=true;
	formObj.pf_etd_dt.readOnly=true;
	formObj.vps_eta_dt.readOnly=true;
	formObj.vps_etb_dt.readOnly=true;
	formObj.vps_etd_dt.readOnly=true;
	formObj.cng_ind.readOnly=true;
	formObj.vps_rmk.readOnly=true;
	formObj.vsl_eng_nm.readOnly=true;
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
}
/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
		      tabIndex=-1;
		        
		      var HeadTitle="|vsl_eng_nm|skd_ind|cng_ind|pf_eta_dt|pf_etb_dt|pf_etd_dt|vps_eta_dt|vps_etb_dt|vps_etd_dt|vps_rmk|clpt_ind_seq|skd_cng_sts_cd|";
		      var headCount=ComCountHeadTitle(HeadTitle);
		      
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"skd_ind",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cng_ind",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pf_eta_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pf_etb_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pf_etd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vps_eta_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vps_etb_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vps_etd_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vps_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"clpt_ind_seq2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"skd_cng_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(0);
		      SetVisible(false);
            }

		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	sheetObj.SetWaitImageVisible(0);
	switch (sAction) {
		case IBSEARCH: // Retrieve
			if (validateForm(sheetObj, formObj, sAction)) {
				if (sheetObj.id == "sheet1") {
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj);
					sheetObj.DoSearch("VOP_VSK_0250GS.do", sParam );
				}
			}
			break;
		default:
	}
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
	ComOpenWait(false);
	var i=1;
	var formObj = document.form;
	formObj.vsl_eng_nm.value = getSheetVal(sheetObj, 1, i++);
	formObj.skd_ind.value = getSheetVal(sheetObj, 1, i++);
	formObj.cng_ind.value = getSheetVal(sheetObj, 1, i++); 
	formObj.pf_eta_dt.value = getSheetVal(sheetObj, 1, i++);
	formObj.pf_etb_dt.value = getSheetVal(sheetObj, 1, i++);
	formObj.pf_etd_dt.value = getSheetVal(sheetObj, 1, i++);
	formObj.vps_eta_dt.value = getSheetVal(sheetObj, 1, i++);
	formObj.vps_etb_dt.value = getSheetVal(sheetObj, 1, i++);
	formObj.vps_etd_dt.value = getSheetVal(sheetObj, 1, i++);
	formObj.vps_rmk.value = getSheetVal(sheetObj, 1, i++);
	formObj.clpt_ind_seq2.value = getSheetVal(sheetObj, 1, i++);
	// Skip:font color를 white로 변경
	if(getSheetVal(sheetObj, 1, i++) == "S") {
		formObj.vps_eta_dt.style.color = "#FFFFFF";
		formObj.vps_etb_dt.style.color = "#FFFFFF";
		formObj.vps_etd_dt.style.color = "#FFFFFF";
	}
}

function getSheetVal(sheetObj, row, col) {
	return sheetObj.GetCellValue(row, col) == -1 ? "" : sheetObj.GetCellValue(row, col);
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage))
		// {
		// return false;
		// }
	}
	return true;
}
