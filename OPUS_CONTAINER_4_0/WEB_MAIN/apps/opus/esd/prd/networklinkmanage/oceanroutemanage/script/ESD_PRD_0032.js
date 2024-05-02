/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0032.js
 *@FileTitle  : OceanRoute Auto Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/01
=========================================================*/

// Common global variable 
var sheetObjects = new Array();
var sheetCnt = 0;
/* Event handler processing by button click event */
document.onclick = processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
	var sheetObject3 = sheetObjects[3];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;
			case "btn_ok":
				doSetValue(sheetObject, formObject);
				break;
			case "btn_close":
				ComClosePopup();
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	sheet1_OnLoadFinish();
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:  
            with(sheetObj){
        	      var HeadTitle1="Seq.|Chk|Ocn Flag|Rmk|Rmk|Priority|POL|Lane|Dir|Type|1st T/S|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hour)|S/Time\n(Day)";
        	      var HeadTitle2="Seq.|Chk|Ocn Flag|Type|Note|Priority|POL|Lane|Dir|Type|Port|Lane|Dir|Type|Port|Lane|Dir|Type|Port|Lane|Dir|Type|POD|T/Time\n(Day/Hour)|S/Time\n(Day)";
        	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];InitHeaders(headers, info);
        	      var cols = [ 
             	             {Type:"Seq",       Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sSeq" },
             	             {Type:"CheckBox",  Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sChk" },
             	             {Type:"Combo",     Hidden:0, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sRouteFlg",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Combo",     Hidden:0, 	Width:60,   Align:"Left",    ColMerge:1,   SaveName:"sRmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:100,  Align:"Left",    ColMerge:1,   SaveName:"s_route_note",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             	             {Type:"Combo",     Hidden:0, 	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sPrior",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sPol",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sLane",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sDir",       	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sLaneTp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sTS1Port",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs1Lane",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs1Dir",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs1LaneTp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sTs2Port",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs2Lane",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs2Dir",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs2LaneTp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sTs3Port",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs3Lane",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs3Dir",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sTs3Type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sPod",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sFmtTTime",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:0,  	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sFmtSTime",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sTTime",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sSTime",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPol1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPod1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sDir1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sFdrFlg1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPol2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPod2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sDir2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sFdrFlg2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPol3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPod3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sDir3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sFdrFlg3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPol4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPod4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sDir4",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sFdrFlg4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sTT1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sTT2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sTT3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sTT4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sST1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sST2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sST3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sTsInd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPod1Etb",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPol2Etb",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPod2Etb",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPol3Etb",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPod3Etb",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sPol4Etb",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sLnkCnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sFdrUsd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sTgExist",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sDoubtFlg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"sDupAllow",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	       
        	      InitColumns(cols);
        	      SetEditable(1);
        	      SetWaitImageVisible(0);
        	      SetRangeBackColor(1, 5, 1, 21,"#555555");
        	      SetSheetHeight(270);
        	      SetColProperty("sFmtTTime", {Format:"##D-##H"} );
        	      SetColProperty("sFmtSTime", {Format:"##D-##H"} );
        	      InitComboNoMatchText(true);
        	      SetColProperty("sRouteFlg", {ComboText:"|Guide|Standard|Temporary|AddCall|Validation|Doubt|NotUsed", ComboCode:"|G|S|T|A|V|O|N"} );
                  SetColProperty("sRmk", {ComboText:"|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others", ComboCode:"|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others"} );
              	  SetColProperty("sPrior", {ComboText:"|1|2|3|4|5|6|7|8|9", ComboCode:"|1|2|3|4|5|6|7|8|9"} );
              	  ComResizeSheet(sheetObj);
        	}
            break;
    }
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_PRD_0032GS.do", PrdFQString(formObj), { Sync : 2 });
			ComOpenWait(false);
			break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
function doSetValue(sheetObj, formObj) {
	var openerSheet = opener.sheet1;
	if (!otherFlagChk(sheetObj)) {
		ComShowMessage(ComGetMsg('PRD90124'));
		return;
	}
	if (sheetObj.CheckedRows("sChk") > 0) {
		var checkedRow = sheetObj.FindCheckedRow("sChk");
		if (checkedRow.length > 0) {
			checkedRow = checkedRow + "|";
		}
		var arrRow = checkedRow.split("|");
		for (i = 0; i < arrRow.length - 1; i++) {
			if (sheetObj.GetCellValue(arrRow[i], "sDoubtFlg") == "Y") {
				if (!CONFIRM(ComGetMsg('PRD90053'))) {
					continue;
				} else {
					sheetObj.SetCellValue(arrRow[i], "sDupAllow", "Y", 0);
				}
			}
			var iRow = openerSheet.DataInsert(-1);
			var insertRow = arrRow[i];
			if (insertRow == '') {
				break;
			}
			openerSheet.SetRowEditable(iRow, 0);
			openerSheet.SetCellValue(iRow, "s_seq", "", 0);
			openerSheet.SetCellValue(iRow, "s_del", 0);
			openerSheet.SetCellValue(iRow, "ibflag", "I");
			openerSheet.SetCellValue(iRow, "s_pol", 	 sheetObj.GetCellValue(insertRow, "sPol"), 0);
			openerSheet.SetCellValue(iRow, "s_lane", 	 sheetObj.GetCellValue(insertRow, "sLane"), 0);
			openerSheet.SetCellValue(iRow, "s_dir", 	 sheetObj.GetCellValue(insertRow, "sDir"), 0);
			openerSheet.SetCellValue(iRow, "s_svc_type", sheetObj.GetCellValue(insertRow, "sLaneTp"), 0);
			openerSheet.SetCellValue(iRow, "s_ts1_port", sheetObj.GetCellValue(insertRow, "sTS1Port"), 0);
			openerSheet.SetCellValue(iRow, "s_ts1_lane", sheetObj.GetCellValue(insertRow, "sTs1Lane"), 0);
			openerSheet.SetCellValue(iRow, "s_ts1_type", sheetObj.GetCellValue(insertRow, "sTs1LaneTp"), 0);
			openerSheet.SetCellValue(iRow, "s_ts2_port", sheetObj.GetCellValue(insertRow, "sTs2Port"), 0);
			openerSheet.SetCellValue(iRow, "s_ts2_lane", sheetObj.GetCellValue(insertRow, "sTs2Lane"), 0);
			openerSheet.SetCellValue(iRow, "s_ts2_type", sheetObj.GetCellValue(insertRow, "sTs2LaneTp"), 0);
			openerSheet.SetCellValue(iRow, "s_ts3_port", sheetObj.GetCellValue(insertRow, "sTs3Port"), 0);
			openerSheet.SetCellValue(iRow, "s_ts3_lane", sheetObj.GetCellValue(insertRow, "sTs3Lane"), 0);
			openerSheet.SetCellValue(iRow, "s_ts3_type", sheetObj.GetCellValue(insertRow, "sTs3LaneTp"), 0);
			openerSheet.SetCellValue(iRow, "s_fmt_t_time", sheetObj.GetCellValue(insertRow, "sFmtTTime"), 0);
			openerSheet.SetCellValue(iRow, "s_fmt_s_time", sheetObj.GetCellValue(insertRow, "sFmtSTime"), 0);
			openerSheet.SetCellValue(iRow, "s_route_flg", sheetObj.GetCellValue(insertRow, "sRouteFlg"), 0);
			openerSheet.SetCellValue(iRow, "s_pod", sheetObj.GetCellValue(insertRow, "sPod"), 0);
			openerSheet.SetCellValue(iRow, "s_t_time", sheetObj.GetCellValue(insertRow, "sTTime"), 0);
			openerSheet.SetCellValue(iRow, "s_s_time", sheetObj.GetCellValue(insertRow, "sSTime"), 0);
			openerSheet.SetCellValue(iRow, "s_prior", sheetObj.GetCellValue(insertRow, "sPrior"), 0);
			openerSheet.SetCellValue(iRow, "s_f_u", sheetObj.GetCellValue(insertRow, "sFdrUsd"), 0);
			openerSheet.SetCellValue(iRow, "s_c_date", "", 0);
			openerSheet.SetCellValue(iRow, "s_rout_seq", "", 0);
			openerSheet.SetCellValue(iRow, "s_pol1", sheetObj.GetCellValue(insertRow, "sPol1"), 0);
			openerSheet.SetCellValue(iRow, "s_pod1", sheetObj.GetCellValue(insertRow, "sPod1"), 0);
			openerSheet.SetCellValue(iRow, "s_dir1", sheetObj.GetCellValue(insertRow, "sDir1"), 0);
			openerSheet.SetCellValue(iRow, "s_fdr_flg1", sheetObj.GetCellValue(insertRow, "sFdrFlg1"), 0);
			openerSheet.SetCellValue(iRow, "s_pol2", sheetObj.GetCellValue(insertRow, "sPol2"), 0);
			openerSheet.SetCellValue(iRow, "s_pod2", sheetObj.GetCellValue(insertRow, "sPod2"), 0);
			openerSheet.SetCellValue(iRow, "s_dir2", sheetObj.GetCellValue(insertRow, "sDir2"), 0);
			openerSheet.SetCellValue(iRow, "s_fdr_flg2", sheetObj.GetCellValue(insertRow, "sFdrFlg2"), 0);
			openerSheet.SetCellValue(iRow, "s_pol3", sheetObj.GetCellValue(insertRow, "sPol3"), 0);
			openerSheet.SetCellValue(iRow, "s_pod3", sheetObj.GetCellValue(insertRow, "sPod3"), 0);
			openerSheet.SetCellValue(iRow, "s_dir3", sheetObj.GetCellValue(insertRow, "sDir3"), 0);
			openerSheet.SetCellValue(iRow, "s_fdr_flg3", sheetObj.GetCellValue(insertRow, "sFdrFlg3"), 0);
			openerSheet.SetCellValue(iRow, "s_pol4", sheetObj.GetCellValue(insertRow, "sPol4"), 0);
			openerSheet.SetCellValue(iRow, "s_pod4", sheetObj.GetCellValue(insertRow, "sPod4"), 0);
			openerSheet.SetCellValue(iRow, "s_dir4", sheetObj.GetCellValue(insertRow, "sDir4"), 0);
			openerSheet.SetCellValue(iRow, "s_fdr_flg4", sheetObj.GetCellValue(insertRow, "sFdrFlg4"), 0);
			openerSheet.SetCellValue(iRow, "s_route_rmk", sheetObj.GetCellValue(insertRow, "sRmk"), 0);
			openerSheet.SetCellValue(iRow, "s_route_note", sheetObj.GetCellValue(insertRow, "s_route_note"), 0);
			openerSheet.SetCellValue(iRow, "s_n1st_tztm_hrs", sheetObj.GetCellValue(insertRow, "sTT1"), 0);
			openerSheet.SetCellValue(iRow, "s_n2nd_tztm_hrs", sheetObj.GetCellValue(insertRow, "sTT2"), 0);
			openerSheet.SetCellValue(iRow, "s_n3rd_tztm_hrs", sheetObj.GetCellValue(insertRow, "sTT3"), 0);
			openerSheet.SetCellValue(iRow, "s_n4th_tztm_hrs", sheetObj.GetCellValue(insertRow, "sTT4"), 0);
			openerSheet.SetCellValue(iRow, "s_n1st_stay_tm_hrs", sheetObj.GetCellValue(insertRow, "sST1"), 0);
			openerSheet.SetCellValue(iRow, "s_n2nd_stay_tm_hrs", sheetObj.GetCellValue(insertRow, "sST2"), 0);
			openerSheet.SetCellValue(iRow, "s_n3rd_stay_tm_hrs", sheetObj.GetCellValue(insertRow, "sST3"), 0);
			openerSheet.SetCellValue(iRow, "s_ts_ind_cd", sheetObj.GetCellValue(insertRow, "sTsInd"), 0);
			openerSheet.SetCellValue(iRow, "s_pod1_etb", sheetObj.GetCellValue(insertRow, "sPod1Etb"), 0);
			openerSheet.SetCellValue(iRow, "s_pol2_etb", sheetObj.GetCellValue(insertRow, "sPol2Etb"), 0);
			openerSheet.SetCellValue(iRow, "s_pod2_etb", sheetObj.GetCellValue(insertRow, "sPod2Etb"), 0);
			openerSheet.SetCellValue(iRow, "s_pol3_etb", sheetObj.GetCellValue(insertRow, "sPol3Etb"), 0);
			openerSheet.SetCellValue(iRow, "s_pod3_etb", sheetObj.GetCellValue(insertRow, "sPod3Etb"), 0);
			openerSheet.SetCellValue(iRow, "s_pol4_etb", sheetObj.GetCellValue(insertRow, "sPol4Etb"), 0);
			openerSheet.SetCellValue(iRow, "s_lnk_cnt", sheetObj.GetCellValue(insertRow, "sLnkCnt"), 0);
			openerSheet.SetCellValue(iRow, "s_upd_ind_cd", "", 0);
			openerSheet.SetCellValue(iRow, "s_dup_allow", sheetObj.GetCellValue(insertRow, "sDupAllow"), 0);
		}
		opener.ocnRoutSave();
	}
}
/**
 * checking before clicking OK button - show message when the value of Note is null selected in the row that Type is "The Other"
 * 
 * @return
 */
function otherFlagChk(sheetObj) {
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.Rows; i++) {
		if ((sheetObj.GetCellValue(i, "sRmk") == "The Others") && (ComTrim(sheetObj.GetCellValue(i, "s_route_note")) == "")) {
			return false;
		}
	}
	return true;
}
// Duplication Route check - showing Warning Message, in case of Doubt Route
// updating temporarily without Warning Message in case of 'Not Used'
function sheet1_OnChange(sheetObj, Row, Col, Val) {
	if (sheetObj.GetCellValue(Row, "sRouteFlg") == "T" && sheetObj.GetCellValue(Row, "sRmk") == "The Others") {
		sheetObj.SetCellEditable(Row, "s_route_note", 1);
	} else {
		sheetObj.SetCellEditable(Row, "s_route_note", 0);
	}
	if (sheetObj.ColSaveName(Col) == "sRouteFlg" && Val == "T") {
		ComShowMessage("Please select a type of temp flag.");
		sheetObj.SelectCell(Row, "sRmk");
		sheetObj.SetCellValue(Row, "sRmk", 'Space Shortage', 0);
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
	} else if (sheetObj.ColSaveName(Col) == "sRouteFlg" && Val != "T") {
		sheetObj.SetCellValue(Row, "sRmk", '', 0);
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
	} else if (sheetObj.ColSaveName(Col) == "sRmk" && Val != "The Others") {
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
	} else if (sheetObj.ColSaveName(Col) == "s_route_note" && Val != " ") {
		if (sheetObj.GetCellValue(Row, "sRmk") != "The Others") {
			sheetObj.SetCellValue(Row, "s_route_note", '', 0);
		}
	}
	// preventing to select on DROP BOX in case of 'S'
	var idx = sheetObj.GetComboInfo(Row, "sRmk", "SelectedIndex");
	if ((sheetObj.GetCellValue(Row, "sRouteFlg") != "T") && (sheetObj.ColSaveName(Col) == "sRmk") && idx > 0) {
		sheetObj.SetCellValue(Row, "sRmk", ' ', 0);
		ComShowMessage(ComGetMsg('PRD90103'));
	}
	if ((sheetObj.GetCellValue(Row, "sRouteFlg") == "T") && (sheetObj.ColSaveName(Col) == "sRmk") && idx < 1) {
		sheetObj.SelectCell(Row, "sRmk");
		sheetObj.SetCellValue(Row, "sRmk", 'Space Shortage', 0);
		ComShowMessage(ComGetMsg('PRD90102'));
	}
	
	if (sheetObj.ColSaveName(Col) == "sChk") {
		if (Val == "1") {
			if(false) {
				var param = "f_cmd=" + SEARCH11;
					param += "&org_loc_cd=" + sheetObj.GetCellValue(Row, "sPol");
					param += "&dest_loc_cd=" + sheetObj.GetCellValue(Row, "sPod");
					
					param += "&n1st_pol_cd=" + sheetObj.GetCellValue(Row, "sPol1");
					param += "&n1st_pod_cd=" + sheetObj.GetCellValue(Row, "sPod1");
					param += "&n1st_lane_cd=" + sheetObj.GetCellValue(Row, "sLane");
					param += "&n1st_skd_dir_cd=" + sheetObj.GetCellValue(Row, "sDir");
					
					param += "&n2nd_pol_cd=" + sheetObj.GetCellValue(Row, "sPol2");
					param += "&n2nd_pod_cd=" + sheetObj.GetCellValue(Row, "sPod2");
					param += "&n2nd_lane_cd=" + sheetObj.GetCellValue(Row, "sTs1Lane");
					param += "&n2nd_skd_dir_cd=" + sheetObj.GetCellValue(Row, "sTs1Dir");
					
					param += "&n3rd_pol_cd=" + sheetObj.GetCellValue(Row, "sPol3");
					param += "&n3rd_pod_cd=" + sheetObj.GetCellValue(Row, "sPod3");
					param += "&n3rd_lane_cd=" + sheetObj.GetCellValue(Row, "sTs2Lane") 
					param += "&n3rd_skd_dir_cd=" + sheetObj.GetCellValue(Row, "sTs2Dir");
					
					param += "&n4th_pol_cd=" + sheetObj.GetCellValue(Row, "sTs3Port");
					param += "&n4th_pod_cd=" + sheetObj.GetCellValue(Row, "sPod4");
					param += "&n4th_lane_cd=" + sheetObj.GetCellValue(Row, "sTs3Lane");
					param += "&n4th_skd_dir_cd=" + sheetObj.GetCellValue(Row, "sTs3Dir");
					
					param += "&row=" + Row + "&col=" + Col;
				
				sheetObj.DoRowSearch(Row, "ESD_PRD_0032_ROW_GS.do", param, {Sync : 2 });
				if (sheetObj.GetEtcData("rowCount") == 0) {
					sheetObj.SetCellValue(Row, "sDoubtFlg", "", 0);
					sheetObj.SetCellValue(Row, "sDupAllow", "", 0);
				}
			}
			sheetObj.SetCellValue(Row, "sDoubtFlg", "", 0);
			sheetObj.SetCellValue(Row, "sDupAllow", "", 0);
		} else {
			sheetObj.SetCellValue(Row, "sChk", "0", 0);
			sheetObj.SetCellValue(Row, "sDupAllow", "", 0);
		}
	}
}
function CONFIRM(msg1) {
	msg1 = "\n" + "────────────────────────────────     \n\n" + "\n" + "" + msg1 + "\n" + "\n" + "\n────────────────────────────────     \n" + "If you click 'Cancel' button, this route can't be created.";
	return confirm(msg1);
}
/**
 * 
 * @return
 */
function sheet1_OnLoadFinish() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
