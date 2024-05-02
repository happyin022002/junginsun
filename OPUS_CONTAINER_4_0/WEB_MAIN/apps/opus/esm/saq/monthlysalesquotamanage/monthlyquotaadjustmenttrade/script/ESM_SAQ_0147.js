/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0147.js
*@FileTitle  : Monthly Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var monthNames = new Array();
var monthNumbers = new Array();
var isSheetEdited = false;
var saveParams = "";

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_close": // close
                ComClosePopup();
                break;
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                break;
            case "btn_save":
                doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    optionSetting();
    monthSetting();
    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    var formObj = document.form;
    formObj.unit.value = formObj.unit_tp.value;
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

function monthSetting() {
    var rtn = getCodeList("CommonCode", "codeNo=CD01915"); //month "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Jan","Feb"
    var code = rtn[0].split("|");
    for (var i = 0; i < code.length + 1; i++) {
        if (i == 12) {
            monthNames[i] = code[0];
        } else if (i == 13) {
            monthNames[i] = code[1];
        } else {
            monthNames[i] = code[i];
        }
    }
    rtn = getCodeList("CommonCode", "codeNo=CD20011"); //month "01","02","03","04","05","06","07","08","09","10","11","12","01","02"
    code = rtn[0].split("|");
    for (var i = 0; i < code.length + 1; i++) {
        if (i == 12) {
            monthNumbers[i] = code[0];
        } else if (i == 13) {
            monthNumbers[i] = code[1];
        } else {
            monthNumbers[i] = code[i];
        }
    }
}

function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
				var HeadTitle1 = changeHeadTitle(sheetObj);
				var HeadTitle2="Sub-Trade|Lane|Regional\nGroup|GRP_SEQ1|Volume|Volume|G.RPB|G.RPB|GRP_SEQ2|Volume|Volume|G.RPB|G.RPB|GRP_SEQ3|Volume|Volume|G.RPB|G.RPB|BSA|RLANE_CD|SPRT_GRP_CD|BSA_GRP_CD|CTRT_RHQ_CD|BSE_MON";
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );

				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}];
				InitHeaders(headers, info);

				var cols = [ {Type:"Text",      Hidden:(isDevMode ? 1 : 1), Width:110,  Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:0,  						Width:90,   Align:"Center",  ColMerge:1,   SaveName:"lane_grp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:0,  						Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"grp_seq1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"load1tmp",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Float",     Hidden:0,  						Width:95,   Align:"Center",  ColMerge:1,   SaveName:"load1",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"g_rpb1tmp",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Float",     Hidden:0,  						Width:95,   Align:"Center",  ColMerge:1,   SaveName:"g_rpb1",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"grp_seq2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"load2tmp",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Float",     Hidden:0,  						Width:95,   Align:"Center",  ColMerge:1,   SaveName:"load2",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"g_rpb2tmp",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Float",     Hidden:0,  						Width:95,   Align:"Center",  ColMerge:1,   SaveName:"g_rpb2",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"grp_seq3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"load3tmp",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Float",     Hidden:0,  						Width:95,   Align:"Center",  ColMerge:1,   SaveName:"load3",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"g_rpb3tmp",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Float",     Hidden:0,  						Width:95,   Align:"Center",  ColMerge:1,   SaveName:"g_rpb3",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:25 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"tot_bsa",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"sprt_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bsa_grp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_rhq_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Text",      Hidden:(isDevMode ? 1 : 1), 	Width:110,  Align:"Center",  ColMerge:1,   SaveName:"trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	             {Type:"Status",    Hidden:1, 						Width:1,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetFocusEditMode(default_edit_mode);
				SetSheetHeight(300);
				SetEditable(1);
	            SetHeaderRowHeight(25);
//	            SetRangeBackColor(1, 2, 1, 36,"#777777");
	      	}
		    break;
	}    
}

//setting head title
function changeHeadTitle(sheetObj) {
    var year = document.form.bse_yr.value;
    var monIdx = document.form.bse_qtr_cd.value.substring(0, 1) * 3 - 3;
    var HeadTitle1 = "Sub-Trade|Lane|Regional\nGroup|";
    for (i = 0; i < 3; i++) {
        var num = i + 1;
        HeadTitle1 = HeadTitle1 + "GRP_SEQ" + num + "|";
        HeadTitle1 = HeadTitle1 + year + "." + monthNumbers[monIdx] + "|";
        HeadTitle1 = HeadTitle1 + year + "." + monthNumbers[monIdx] + "|";
        HeadTitle1 = HeadTitle1 + year + "." + monthNumbers[monIdx] + "|";
        HeadTitle1 = HeadTitle1 + year + "." + monthNumbers[monIdx] + "|";
        if (monIdx == 11) year = year + 1;
        monIdx++;
    }
    HeadTitle1 = HeadTitle1 + "BSA|RLANE_CD|SPRT_GRP_CD|BSA_GRP_CD|CTRT_RHQ_CD|BSE_MON";
    //no support[implemented common]CLT 
    //sheetObj.InitHeaders(0, HeadTitle1, false);
    return HeadTitle1;
}

function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //
            if (isSheetEdited) {
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    return;
                }
            }
            saveParams = "";
            formObj.f_cmd.value = SEARCHLIST;
            sheetObj.DoSearch("ESM_SAQ_0147GS.do", saqFormString(formObj));
            if (sheetObj.GetEtcData("status") == "OK") {
                retrieved = true;
            }
            isSheetEdited = false;
            //	        if(!validateStep(sheetObj)){
            //        		var monIdx = document.form.bse_qtr_cd.value.substring(0,1)*3-3;	
            //        		//msg["SAQ90150"] = "Please "Set Final" and in each months ( month, month+1, month+2 ) and save
            //        		//					 before running "Monthly Adj."
            //        		ComShowMessage(getMsg("SAQ90150",monthNames[monIdx],monthNames[monIdx+1],monthNames[monIdx+2]));
            //	        	//showMsgWindow(getMsg("SAQ90150",monthNames[monIdx],monthNames[monIdx+1],monthNames[monIdx+2]));
            //	        	close();
            //	        }
            break;
        case IBSAVE: //save            
            if (validateSave(sheetObj)) {
                formObj.f_cmd.value = MULTI;
                saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
                var rtn = doSaveSheet(sheetObj, "ESM_SAQ_0147GS.do", saveParams);
                isSheetEdited = false;
            }
            break;
    }
}

// Check before saving message...
function validateSave(sheetObj) {
    var msgLane = "";
    var msgError = new Array("", "", "");
    var showMsgError = new Array();
    var selRow = 0;
    with(sheetObj) {
            for (var selRow = HeaderRows(); selRow <= LastRow(); selRow++) {
                var grp_seq = GetCellValue(selRow, "grp_seq2");
                if (grp_seq == "1") { // check editable column
                    msgLane = GetCellValue(selRow, "lane_grp") + "/" + GetCellValue(selRow, "rhq_cd") + "/" + GetCellValue(0, "load2tmp");
                    // Load (-) check
                    if (GetCellValue(selRow, "load1tmp") < 0) {
                        msgError[0] = msgError[0] + "- " + msgLane + " \n";
                    }
                    // GRPB (-) check
                    if (GetCellValue(selRow, "g_rpb2tmp") < 0) {
                        msgError[1] = msgError[1] + "- " + msgLane + " \n";
                    }
                    // G.REV/G.RPB (0) check
                    if (GetCellValue(selRow, "load2tmp") > 0 && GetCellValue(selRow, "g_rpb2tmp") == 0) {
                        if (GetCellValue(selRow, "load2tmp") < 0.1) {
                            SetCellValue(selRow, "load2tmp", 0);
                            processCalcLogic(sheetObj, selRow, SaveNameCol("load2"));
                        } else {
                            msgError[2] = msgError[2] + "- " + msgLane + " \n";
                        }
                    }
                }
                var grp_seq = GetCellValue(selRow, "grp_seq3");
                if (grp_seq == "1") { // check editable column
                    msgLane = GetCellValue(selRow, "lane_grp") + "/" + GetCellValue(selRow, "rhq_cd") + "/" + GetCellValue(0, "load3tmp");
                    // Load (-) check
                    if (GetCellValue(selRow, "load1tmp") < 0) {
                        msgError[0] = msgError[0] + "- " + msgLane + " \n";
                    }
                    // GRPB (-) check
                    if (GetCellValue(selRow, "g_rpb3tmp") < 0) {
                        msgError[1] = msgError[1] + "- " + msgLane + " \n";
                    }
                    // G.REV/G.RPB (0) check
                    if (GetCellValue(selRow, "load3tmp") > 0 && GetCellValue(selRow, "g_rpb3tmp") == 0) {
                        if (GetCellValue(selRow, "load3tmp") < 0.1) {
                            SetCellValue(selRow, "load3tmp", 0);
                            processCalcLogic(sheetObj, selRow, SaveNameCol("load3"));
                        } else {
                            msgError[2] = msgError[2] + "- " + msgLane + " \n";
                        }
                    }
                }
            }
            if (msgError[0] != "") {
                showMsgError[0] = getMsg("SAQ90147", "Load", msgError[0]);
            }
            if (msgError[1] != "") {
                showMsgError[1] = getMsg("SAQ90147", "G.REV/G.RPB", msgError[1]);
            }
            if (msgError[2] != "") {
                showMsgError[2] = getMsg("SAQ90146", msgError[2]);
            }
            if (showMsgError[0] != undefined) {
                showMsgWindow(showMsgError, "0");
                return false;
            }
            return true;
        } // end with      
}

//no support[implemented common]CLT 
function changeSheetBackColor(sheetObj, row, col) {
    sheetObj.SetCellBackColor(row, col, "#F9F9F9");
}

function editableCols(sheetObj, colName, seq) {
    var selRow = 0;
    while ((selRow = sheetObj.FindText(colName + seq, "1", selRow)) >= 0) {
        //no support[implemented common]CLT 
        changeSheetBackColor(sheetObj, selRow, "g_rpb" + seq);
        //no support[implemented common]CLT 
        changeSheetBackColor(sheetObj, selRow, "load" + seq);
        sheetObj.SetCellEditable(selRow, "g_rpb" + seq, 1);
        sheetObj.SetCellEditable(selRow, "load" + seq, 1);
        selRow++;
    }
}

function sheet1_OnChange(sheetObj, row, col, value) {
    isSheetEdited = true;
    var colName = sheetObj.ColSaveName(col);
    if (colName == "load2" || colName == "load3" || colName == "g_rpb2" || colName == "g_rpb3") {
        if (sheetObj.GetCellValue(row, col) == "") {
            sheetObj.SetCellValue(row, col, 0, 0);
        } else if (eval(sheetObj.GetCellValue(row, col)) < 0) {
            showMsgWindow(getMsg("SAQ90119", "Volume/G.RPB "));
            sheetObj.SetCellValue(row, col, sheetObj.GetCellValue(row, col - 1), 0);
            return;
        }
        var msg = processCalcLogic(sheetObj, row, col);
        if (msg != undefined && msg != "") {
            ComShowMessage(msg);
        }
    }
}

function processCalcLogic(sheetObj, row, col) {
    var tmp_rlane_cd = sheetObj.GetCellValue(row, "rlane_cd");
    var tmp_rhq_cd = sheetObj.GetCellValue(row, "rhq_cd");
    var tmp_sprt_grp_cd = sheetObj.GetCellValue(row, "sprt_grp_cd");
    var rate = sheetObj.GetCellValue(row, col) / sheetObj.GetCellValue(row, "tot_bsa");
    var selRow = row;
    var org_val = sheetObj.GetCellValue(row, col);
    var trd_cd = sheetObj.GetCellValue(row, "trd_cd");
    var colName = sheetObj.ColSaveName(col);
    sheetObj.SetCellValue(row, col - 1, sheetObj.GetCellValue(row, col));
    while ((selRow = sheetObj.FindText("lane_grp", tmp_rlane_cd + "-" + tmp_sprt_grp_cd, selRow, 0)) >= 0) {
        if (sheetObj.GetCellValue(selRow, "rhq_cd") == tmp_rhq_cd) {
            if (sheetObj.GetCellValue(selRow, col) != "") {
                if ((colName == "load2" || colName == "load3") && org_val == 0) {
                    sheetObj.SetCellValue(selRow, col + 1, 0, 0);
                    sheetObj.SetCellValue(selRow, col + 2, 0, 0);
                }
                if (trd_cd == "IAS" || trd_cd == "EMS") {
                    if (colName == "g_rpb2" || colName == "g_rpb3") {
                        sheetObj.SetCellValue(selRow, col, org_val, 0);
                        sheetObj.SetCellValue(selRow, col - 1, org_val, 0);
                    } else {
                        sheetObj.SetCellValue(selRow, col, getRoundOffApply(org_val), 0);
                        sheetObj.SetCellValue(selRow, col - 1, getRoundOffApply(org_val), 0);
                    }
                } else {
                    if (colName == "g_rpb2" || colName == "g_rpb3") {
                        sheetObj.SetCellValue(selRow, col, org_val, 0);
                        sheetObj.SetCellValue(selRow, col - 1, org_val, 0);
                    } else {
                        sheetObj.SetCellValue(selRow, col, getRoundOffApply(sheetObj.GetCellValue(selRow, "tot_bsa") * rate), 0);
                        sheetObj.SetCellValue(selRow, col - 1, getRoundOffApply(sheetObj.GetCellValue(selRow, "tot_bsa") * rate), 0);
                    }
                }
            }
        }
        selRow++;
    }
}

function sheet1_OnSearchEnd(sheetObj, errMsg) {
    editableCols(sheetObj, "grp_seq", 2);
    editableCols(sheetObj, "grp_seq", 3);
    saveParams = getLocalParams();
}

function getLocalParams() {
    var obj = document.form;
    var params = saqFormString(obj);
    return params;
}

function getParam(params, paramName) {
    var idx1 = params.indexOf(paramName + "=");
    if (idx1 < 0) {
        return "";
    }
    var idx2 = params.indexOf("&", idx1);
    if (idx2 < 0) {
        idx2 = params.length;
    }
    var v = paramName.length + 1;
    var value = params.substring(idx1 + v, idx2);
    return value;
}

function getRoundOffApply(org_value) {
    var unit = getParam(saveParams, "unit")
    if (unit == "T" || unit == "") {
        return Math.round(org_value);
    } else if (unit == "F") {
        return Math.round(org_value * 2) / 2;
    }
}

function replaceParams(params, paramName, paramValue) {
    var idx1 = params.indexOf(paramName + "=");
    if (idx1 < 0) {
        params += "&" + paramName + "=" + paramValue;
        return params;
    }
    var idx2 = params.indexOf("&", idx1);
    if (idx2 < 0) {
        idx2 = params.length;
    }
    var v = paramName.length + 1;
    var startStr = params.substring(0, idx1 + v);
    var endStr = params.substring(idx2, params.length);
    var value = startStr + paramValue + endStr;
    return value;
}

function optionSetting() {
    SaqSearchOptionComCode("unit", "CD00897", false);
}

function callBackReturnString(rtnValue) {
    return rtnValue;
}