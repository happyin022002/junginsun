/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9140.js
*@FileTitle  : ESD_TES_9140
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/**
 * @extends Tes
 * @class ESD_TES_9140 : business script for Off-Dock CY Container List - Coincidence 에서 File Upload
 */
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var verify_done = false;
var opener_obj = window.dialogArguments;
if (!opener_obj) var opener_obj = parent;
var insCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 * @return
 */
function processButtonClick() {
    var sheetObject = sheetObjects[0];
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_loadexcel":
                // eBilling - E
                if (ComGetObjValue(formObj.manual_input_yn) == "Y") {
                    return false;
                }
                if (!chkOprShtData()) {
                    return false;
                }
                sheetObject.RemoveAll();
                doActionIBSheet(sheetObject, formObj, IBLOADEXCEL);
                break;
            case "btn_chkdigit":
                if (sheetObject.RowCount() > 0) {
                    doActionIBSheet(sheetObject, formObj, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_verify":
                if (!chkOprShtData()) {
                    return false;
                }
                if (sheetObject.RowCount() > 0) {
                    delBlkRows(sheetObject);
                    if (ComGetObjValue(formObj.manual_input_yn) != "Y") {
                        val_chk(sheetObject);
                        if(!chkDupRow(sheet)){return;}; 
                        rmvInvRow(sheetObject);
                        getMinMaxFilepuploadDate(sheetObject);
                        if (!verify_done) {
                            if (formObj.vndr_seq.value == undefined || formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '' ||
                                formObj.yd_cd.value == undefined || formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
                                ComShowMessage(ComGetMsg('TES23050', 'VNDR Code/YD_CD'));
                                return false;
                            }
                            if (formObj.fm_prd_dt.value == undefined || formObj.fm_prd_dt.value == null || formObj.fm_prd_dt.value.trim() == '' ||
                                formObj.to_prd_dt.value == undefined || formObj.to_prd_dt.value == null || formObj.to_prd_dt.value.trim() == '') {
                                ComShowMessage(ComGetMsg('TES24016'));
                            }
                            if (rmvInvRow(sheetObject)) {
                                if (sheetObject.RowCount() > 0) {
                                    doActionIBSheet(sheetObject, formObj, IBSEARCH);
                                } else {
                                    ComShowMessage(ComGetMsg('TES23051'));
                                    break;
                                }
                            }
                        } else {
                            ComShowMessage(ComGetMsg('TES23052'));
                        }
                    } else {
                        for (var i = 1; sheetObject != null && i <= sheetObject.RowCount(); i++) {
                            sheetObject.SetCellValue(i, 'valid_chk', '', 0);
                            sheetObject.SetCellValue(i, 'dup_chk_conf', '', 0);
                            sheetObject.SetRowFontColor(i, "#000000");
                        }
                        val_chk(sheetObject);
                        if(!chkDupRow(sheet)){return;}; 
                        if (rmvInvRow(sheetObject)) {
                            getMinMaxFilepuploadDate(sheetObject);
                            if (sheetObject.RowCount() > 0) {
                                doActionIBSheet(sheetObject, formObj, IBSEARCH);
                            } else {
                                ComShowMessage(ComGetMsg('TES23051'));
                                break;
                            }
                        }
                    }
                }
                break;
            case "btn_rowadd":
                if (ComGetObjValue(formObj.manual_input_yn) != "Y") {
                    return false;
                }
                var row = sheetObject.DataInsert(-1);
                setShtCellsEditable(sheetObject, row, 'cntr_no|cntr_sty_cd|cntr_tpsz_cd|inv_gate_in_dt|inv_gate_out_dt|valid_chk|dup_chk_conf');
                formObj.manual_input_yn[0].disabled = true;
                formObj.manual_input_yn[1].disabled = true;
                sheetObject.SetCellValue(row, 'cntr_sty_cd', '');
                sheetObject.SetCellValue(row, 'cntr_tpsz_cd', '');
                verify_done = false;
                break;
            case "btn_close":
                ComClosePopup();
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            verify_done = false;
            ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage("The service is not available now.");
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * set Sheet Cells Editable
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {int}		rownum		Row Index
 * @param {int}		colnms		editable
 * @return
 */
function setShtCellsEditable(sheetObj, rownum, colnms) {
    if (rownum == null || rownum == undefined || colnms == null || colnms == undefined) {
        return false;
    }
    var arr_colnms = colnms.split('|');
    for (var i = 0; arr_colnms != null && i < arr_colnms.length; i++) {
        sheetObj.SetCellEditable(rownum, arr_colnms[i], 1);
    }
}

/**
 * set sheet status
 * @param {ibsheet}	sheetObj	IBSheet Object
 * @param {int}		sts_colnm	Column Index 
 * @param {int}		to_sts		Column Index 
 * @return
 */
function setShtStatus(sheetObj, sts_colnm, to_sts) {
    if (sheetObj.RowCount() > 0) {
        if (sts_colnm != null && sts_colnm != undefined && sts_colnm.trim() != '' &&
            to_sts != null && to_sts != undefined && to_sts.trim() != '') {
            for (i = 1; i < sheetObj.RowCount(); i++) {
                sheetObj.SetCellValue(i, sts_colnm, to_sts, 0);
            }
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet} sheet_obj 	IBSheet Object
 * @return
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @return
 */
function loadPage() {
    var opener = window.dialogArguments;
    if (!opener) var opener = parent;
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    chkOprShtData();
    document.form.manual_input_yn[1].checked = true;
}

/**
 * @return
 */
function chkOprShtData() {
    if (hasOprShtData()) {
        if (!confirm(ComGetMsg('TES23053'))) {
            ComClosePopup();
        } else {
            opener_obj.removeOffdockCYInvoice01();
            window.focus();
        }
        return false;
    }
    return true;
}

/**
 * Exist check Coincidence, Discrepancy, CalcTMNL, CalcByDay sheet data
 * @return
 */
function hasOprShtData() {
    var opener_sheet_obj;
    for (var i = 1; i <= 4; i++) {
        opener_sheet_obj = opener_obj.eval('t' + i + 'sheet1');
        if (opener_sheet_obj != null && opener_sheet_obj.RowCount() > 0) {
            return true;
        }
    }
    return false;
}

/**
 * setting sheet initial values and header
 * @param {ibsheet}sheetObj 	IBSheet Object
 * @param {int} 	sheetNo 	 
 * 							adding case as numbers of counting sheets
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
				var HeadTitle="|Seq.No.|CNTR No.|F/M|Type/Size|Gate In|Gate Out|Stay Days";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:150} );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							{Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
							{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"inv_gate_in_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:16 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"inv_gate_out_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:16 },
							{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"valid_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"dup_chk_conf",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				InitColumns(cols);
				SetEditable(1);
				//SetColProperty("inv_gate_in_dt", {Format:"YmdHm"} );
				//SetColProperty("inv_gate_out_dt", {Format:"YmdHm"} );
				SetColProperty("inv_gate_in_dt", {Format:"####-##-## ##:##"} );
				SetColProperty("inv_gate_out_dt", {Format:"####-##-## ##:##"} );
				
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:"|"+document.form.cntr_tpsz_cd.value, ComboCode:"|"+document.form.cntr_tpsz_cd.value} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetSheetHeight(240);
			}
		break;
	}
}

/**
 * handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction		
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            getMinMaxFilepuploadDate(sheetObj);
            formObj.f_cmd.value = SEARCHLIST;
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                var str = sheetObj.GetCellValue(i, "inv_gate_in_dt");
                var str2 = sheetObj.GetCellValue(i, "inv_gate_out_dt");
                str = str.replace(/\/|\-|\./g, "");
                str = str.replace(" ", "");
                str = str.replace(":", "");
                str2 = str2.replace(/\/|\-|\./g, "");
                str2 = str2.replace(" ", "");
                str2 = str2.replace(":", "");
                sheetObj.SetCellValue(i, "inv_gate_in_dt", str);
                sheetObj.SetCellValue(i, "inv_gate_out_dt", str2);
            }
            var param = sheetObj.GetSaveString(true, false);
            var sXml = sheetObj.GetSearchData("ESD_TES_9140Popup.do", param + '&' + tesFrmQryStr(formObj), "", true);
            sheetObj.LoadSearchData(sXml, { Append: 1, Sync: 1 });
            break;

        case IBSEARCH_ASYNC01:
            formObj.f_cmd.value = SEARCH01;
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                var str = sheetObj.GetCellValue(i, "inv_gate_in_dt");
                var str2 = sheetObj.GetCellValue(i, "inv_gate_out_dt");
                str = str.replace(/\/|\-|\./g, "");
                str = str.replace(" ", "");
                str = str.replace(":", "");
                str2 = str2.replace(/\/|\-|\./g, "");
                str2 = str2.replace(" ", "");
                str2 = str2.replace(":", "");
                sheetObj.SetCellValue(i, "inv_gate_in_dt", str);
                sheetObj.SetCellValue(i, "inv_gate_out_dt", str2);
            }
            var param = sheetObj.GetSaveString(true, false);
            //var str = "&fileup_min_gt_in_dt=" + sheet.GetCellValue(i,'inv_gate_in_dt') + "&fileup_max_gt_out_dt=" + sheet.GetCellValue(i,'inv_gate_out_dt');
            var searchXml = sheetObj.GetSearchData("ESD_TES_9140Popup.do", param + '&' + tesFrmQryStr(formObj), "", true);
            sheetObj.RemoveAll();
            if (searchXml != null && searchXml != '') {
            	sheetObj.LoadSearchData(searchXml, { Sync: 1 });
            }
            break;

        case IBLOADEXCEL:
            sheetObj.LoadExcel({ Mode: "HeaderMatch" });
            break;

        case SEARCH03: //Retrieve				
            formObj.f_cmd.value = SEARCH03;
            var param = sheetObj.GetSaveString(true, false);
            var sXml = sheetObj.GetSearchData("ESD_TES_9140Popup.do", param + '&' + tesFrmQryStr(formObj), "", true);

            sheetObj.RemoveAll();
            sheetObj.LoadSearchData(sXml, { Append: 1, Sync: 1 });
            break;
    }
}

/**
 * search end event
 * @param {ibsheet}	sheet		IBSheet Object
 * @param {string}	ErrMsg		error message
 * @return
 */
function sheet_OnSearchEnd(sheet, ErrMsg) {
    if (sheet.RowCount() > 0) {
        if (document.form.f_cmd.value == SEARCHLIST) {
            verify_done = true;
            opener_obj.retrieveCntrList();
            insCnt = sheet.GetEtcData("insCnt");
            sheet.RemoveEtcData();
            //insCnt += opener_obj.document.t1sheet1.RowCount;
            //insCnt += opener_obj.document.t2sheet1.RowCount;
            insCnt = (insCnt != undefined && insCnt != null & insCnt != '' ? insCnt : 0);
            window.focus();
            ComShowMessage(ComGetMsg('TES23058', insCnt));
            ComClosePopup();
        }
    }
}

/**
 * loae excel event
 * @param {ibsheet}	sheet		IBSheet Object
 * @return
 */
function sheet_OnLoadExcel(sheet, result, code, msg) {
    //if(isExceedMaxRow(msg))return;

    if (sheet.RowCount() > 0) {
        document.form.manual_input_yn[0].disabled = true;
        document.form.manual_input_yn[1].disabled = true;
        doActionIBSheet(sheet, document.form, SEARCH03);
    }

    delBlkRows(sheet);
    val_chk(sheet);    
    if(!chkDupRow(sheet)){return;};
    rmvInvRow(sheet);    
    getMinMaxFilepuploadDate(sheet);

    //		for(var i=sheet.HeaderRows(); i<sheet.HeaderRows()+ sheet.RowCount(); i++){
    //	 		if(sheet.GetCellValue(i, "cntr_tpsz_cd")==""){
    //	        	document.form.cntr_no.value = sheet.GetCellValue(i, "cntr_no");
    //	        	document.form.row.value = i;
    //	        	
    //	        	 tes_getInputValue('tmp_cntr_tpsz_cd', SEARCH23, 'cntr_no|row', 'searchCntrTPSZ');
    //	 		}
    //		}

    verify_done = false;
}

/**
 * Sheet change event
 * @param {ibsheet}	sheet		IBSheet Object
 * @param {int}		row			Row Index
 * @param {int}		col			Column Index
 * @param {int}		val			
 * @return
 */
function sheet_OnChange(sheet, row, col, val) {
    var sName = null;
    if (sheet.RowCount() > 0) {
        sName = sheet.ColSaveName(col);
        if (sName != undefined && sName != null && (sName == 'cntr_sty_cd' || sName == 'cntr_tpsz_cd')) {
            sheet.SetCellValue(row, col, sheet.GetCellValue(row, col).toUpperCase(), 0);
        }
    }

    if (sheet.ColSaveName(col) == 'cntr_no') {
        document.form.cntr_no.value = val;
        document.form.row.value = row;

        tes_getInputValue('tmp_cntr_tpsz_cd', SEARCH23, 'cntr_no|row', 'searchCntrTPSZ');
    }
}

/** searchCntrTPSZ
 * 
 * @param row
 */
function searchCntrTPSZ(row) {
    sheetObjects[0].SetCellValue(row, "cntr_tpsz_cd", document.form.tmp_cntr_tpsz_cd.value);
}

/**
 * get Min Max Date data
 * @param {ibsheet}	sheet		IBSheet Object
 * @return
 */
function getMinMaxFilepuploadDate(sheet) {
    var formObj = document.form;
    var fileup_min_gt_in_dt;
    var fileup_max_gt_out_dt;
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if (fileup_min_gt_in_dt == null || fileup_min_gt_in_dt.trim() == '') {
            if (sheet.GetCellValue(i, 'inv_gate_in_dt') != null && sheet.GetCellValue(i, 'inv_gate_in_dt') != '') {
                fileup_min_gt_in_dt = sheet.GetCellValue(i, 'inv_gate_in_dt').trim().replace(/-/gi, '');
            } else {
                fileup_min_gt_in_dt = "";
            }
        } else {
            if (sheet.GetCellValue(i, 'inv_gate_in_dt') != null && sheet.GetCellValue(i, 'inv_gate_in_dt') != '') {
                if (sheet.GetCellValue(i, 'inv_gate_in_dt') < fileup_min_gt_in_dt) {
                    fileup_min_gt_in_dt = sheet.GetCellValue(i, 'inv_gate_in_dt').trim().replace(/-/gi, '');
                } else {
                    fileup_min_gt_in_dt = "";
                }
            }
        }
        
        if (fileup_max_gt_out_dt == null || fileup_max_gt_out_dt.trim() == '') {
            if (sheet.GetCellValue(i, 'inv_gate_out_dt') != null && sheet.GetCellValue(i, 'inv_gate_out_dt') != '') {
                fileup_max_gt_out_dt = sheet.GetCellValue(i, 'inv_gate_out_dt').trim().replace(/-/gi, '');
            } else {
                fileup_max_gt_out_dt = "";
            }
        } else {
            if (sheet.GetCellValue(i, 'inv_gate_out_dt') != null || sheet.GetCellValue(i, 'inv_gate_out_dt') != '') {
                if (sheet.GetCellValue(i, 'inv_gate_out_dt') > fileup_max_gt_out_dt) {
                    fileup_max_gt_out_dt = sheet.GetCellValue(i, 'inv_gate_out_dt').trim().replace(/-/gi, '');
                } else {
                    fileup_max_gt_out_dt = "";
                }
            }
        }
    }
    
    if (!chkGtOutDt()) {
        var opr_to_prd_dt = opener_obj.document.form.to_prd_dt.value.trim().replace(/-/gi, '');
        var curr_to_prd_dt = formObj.to_prd_dt.value.trim().replace(/-/gi, '');
        if (opr_to_prd_dt != undefined && opr_to_prd_dt != null && opr_to_prd_dt != '') {
            if (opr_to_prd_dt != curr_to_prd_dt) {
                ComShowMessage(ComGetMsg('TES23064')); //ComShowMessage('Period의 마지막 값과 일치하지 않습니다. 진행불가');
                sheetObjects[0].RemoveAll();
                return false;
            }
        } else {
            ComShowMessage(ComGetMsg('TES23065')); //ComShowMessage('Period의 값에 오류가 발생했습니다. 진행불가');
            sheetObjects[0].RemoveAll();
            return false;
        }
        fileup_max_gt_out_dt = formObj.to_prd_dt.value.trim().replace(/-/gi, '');
    }
    
    formObj.fileup_min_gt_in_dt.value = (fileup_min_gt_in_dt.length >= 8 ? fileup_min_gt_in_dt.substring(0, 8) : '');
    formObj.fileup_max_gt_out_dt.value = (fileup_max_gt_out_dt.length >= 8 ? fileup_max_gt_out_dt.substring(0, 8) : '');
}

/**
 * handling process for input validation
 * @param {ibsheet}	sheetObj	IBSheet Object
 * @param {form}	formObj		
 * @param {int}		sAction		
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //            if (!ComIsNumber(iPage)) {
        //
        //                return false;
        //            }
    }
    return true;
}

/**
 * duplication check
 * @param {ibsheet}	sheet	IBSheet Object
 * @return
 */
function chkDupRow(sheet) {
    var idx = 0;
    var Rows;
    Rows = sheet.ColValueDupRows("cntr_no|inv_gate_in_dt|inv_gate_out_dt");
    var arr_rows = null;
    
    if (Rows != null && Rows.trim() != '') {
        arr_rows = Rows.split(',');
    }
    
    for (var i = 0; arr_rows != null && i < arr_rows.length; i++) {
        sheet.SetRowFontColor(arr_rows[i], "#FF0000");
        sheet.SetCellValue(arr_rows[i], "dup_chk_conf", ++idx, 0);
    }
    
    if (idx > 0) {
        ComShowMessage(ComGetMsg('TES24030', idx));
        return false;        
    } else {
    	return true;
    }
}

/**
 * validation check excel data
 * @param {ibsheet}	sheet	IBSheet Object
 * @return
 */
function rmvInvRow(sheet) {
    var inval_row = false;
    if (sheet.RowCount() > 0) {
        var delRows = '';
        var cnt = 0;
        
        for (var i = 1; i <= sheet.RowCount(); i++) {
            if ((sheet.GetCellValue(i, 'valid_chk') != undefined && sheet.GetCellValue(i, 'valid_chk').trim() == 'X') ||
                (sheet.GetCellValue(i, 'dup_chk_conf') != undefined && sheet.GetCellValue(i, 'dup_chk_conf') != null && sheet.GetCellValue(i, 'dup_chk_conf').trim() != '')) {
                delRows = delRows + (cnt > 0 ? "|" : "") + (new String(i));
                inval_row = true;
                cnt++;
            }
        }
        
        if (inval_row) {
            ComShowMessage(ComGetMsg('TES23055', cnt));
        } else {
            return true;
        }
    }
}

/**
 * row delete
 * @param {ibsheet}sheet	IBSheet Object
 * @param {int}	delRows	row index
 * @return
 */
function delInvalRow(sheet, delRows) {
    if (sheet.RowCount() > 0) {
        var arr = delRows.split('|');
        
        for (var i = (arr.length - 1); arr != null && i >= 0; i--) {
            sheet.RowDelete(arr[i], false);
        }
        
        return true;
    }
}

/**
 * @param {ibsheet}sheet	IBSheet Object
 * @return
 */
function delBlkRows(sheet) {
    if (sheet.RowCount() > 0) {    
        for (var i = sheet.RowCount(); sheet != null && i >= 0; i--) {        
            if ((sheet.GetCellValue(i, 'cntr_no') == null || sheet.GetCellValue(i, 'cntr_no') == '') &&
                (sheet.GetCellValue(i, 'cntr_sty_cd') == null || sheet.GetCellValue(i, 'cntr_sty_cd') == '') &&
                (sheet.GetCellValue(i, 'cntr_tpsz_cd') == null || sheet.GetCellValue(i, 'cntr_tpsz_cd') == '') &&
                (sheet.GetCellValue(i, 'inv_gate_in_dt') == null || sheet.GetCellValue(i, 'inv_gate_in_dt') == '') &&
                (sheet.GetCellValue(i, 'inv_gate_out_dt') == null || sheet.GetCellValue(i, 'inv_gate_out_dt') == '')) {
                sheet.RowDelete(i, false);
            }
        }
    }
}

/**
 * validation check sheet
 * @param {ibsheet}sheet	IBSheet Object
 * @return
 */
function val_chk(sheet) {
    if (sheet.RowCount() > 0) {
        var isValid = true;
        
        for (var i = 1; i <= sheet.RowCount(); i++) {
            if (sheet.GetCellValue(i, 'inv_gate_in_dt') != "" && !isValidYYYYMMDDHHMI(sheet.GetCellValue(i, 'inv_gate_in_dt'))) {
                isValid = false;
            } else {
                if (isValid) {
                    isValid = true;
                }
            }

            if (!chkGtOutDt() && (sheet.GetCellValue(i, 'inv_gate_out_dt') == null || sheet.GetCellValue(i, 'inv_gate_out_dt').trim() == '')) {
                sheet.SetCellValue(i, 'inv_gate_out_dt', sheet.GetCellValue(i, 'inv_gate_out_dt').trim());
                if (isValid) {
                    isValid = true;
                }
            } else {
                if (!isValidYYYYMMDDHHMI(sheet.GetCellValue(i, 'inv_gate_out_dt'))) {
                    isValid = false;
                } else {
                    if (isValid) {
                        isValid = true;
                    }
                }
            }

            if (sheet.GetCellValue(i, 'inv_gate_in_dt') != null && sheet.GetCellValue(i, 'inv_gate_in_dt').trim() != '' &&
                sheet.GetCellValue(i, 'inv_gate_out_dt') != null && sheet.GetCellValue(i, 'inv_gate_out_dt').trim() != '') {
                if (!(parseInt(sheet.GetCellValue(i, 'inv_gate_out_dt').trim().substring(0, 4), 10) - parseInt(sheet.GetCellValue(i, 'inv_gate_in_dt').trim().substring(0, 4), 10) >= 0)) {
                    isValid = false;
                } else {
                    if (isValid) {
                        isValid = true;
                    }
                }
            }

            if (sheet.GetCellValue(i, 'inv_gate_in_dt') != null && sheet.GetCellValue(i, 'inv_gate_in_dt').trim() != '' && document.form.to_prd_dt.value != null) {
                if (!(parseInt((tes_getDiffDate(new String(document.form.to_prd_dt.value).trim().replace(/-/gi, ''), 1, null) + '0000'), 10) - parseInt(sheet.GetCellValue(i, 'inv_gate_in_dt'), 10) >= 0)) {
                    isValid = false;
                } else {
                    if (isValid) {
                        isValid = true;
                    }
                }
            }


            if (sheet.GetCellValue(i, 'inv_gate_out_dt') != null && sheet.GetCellValue(i, 'inv_gate_out_dt').trim() != '' && document.form.fm_prd_dt.value != null) {
                if (!(parseInt(sheet.GetCellValue(i, 'inv_gate_out_dt'), 10) - parseInt((document.form.fm_prd_dt.value.trim().replace(/-/gi, '') + '0000'), 10) >= 0)) {
                    isValid = false;
                } else {
                    if (isValid) {
                        isValid = true;
                    }
                }
            }
            
            if (sheet.GetCellValue(i, 'cntr_sty_cd') == null || sheet.GetCellValue(i, 'cntr_sty_cd').trim() == '') {
                isValid = false;
            }
            
            if (!isValid) {
                sheet.SetRowFontColor(i, "#FF0000");
                sheet.SetCellValue(i, 'valid_chk', 'X', 0);
            } else {
                sheet.SetCellValue(i, 'valid_chk', '', 0);
            }
            
            isValid = true;
        }
    }
}

/**
 * validation check Gate Out Date
 * @return
 */
function chkGtOutDt() {
    var formObj = document.form;
    var tml_cost_grp_cd = formObj.tml_cost_grp_cd.value;
    var tml_calc_ind_cd = formObj.tml_calc_ind_cd.value;
    var sto_dys_ind_cd = formObj.sto_dys_ind_cd.value;
    
    if (tml_calc_ind_cd != undefined && tml_calc_ind_cd.trim().length == 2) {
        if (tml_calc_ind_cd.trim() == 'SP') {
            return false;
        }
    }
    
    if (sto_dys_ind_cd != undefined && sto_dys_ind_cd.trim().length == 2) {
        if (sto_dys_ind_cd.trim() == 'DT') {
            return false;
        }
    }
    
    return true;
}

/**
 * validate check date format
 * @param {string}	src	date
 * @return
 */
function checkDateFormat(src) {
    var date_regexp = /(^\d{4}-\d{2}-\d{2}$)/;
    
    if (src.search(date_regexp) != -1) {
        return true;
    } else {
        return false;
    }
}

/**
 * validate check date format
 * @param {String}	str		YYYYMM
 * @return
 */
function isValidYYYYMM(src) {
    var str = src.replace(/\/|\-|\./g, "");
    str = str.replace(" ", "");
    str = str.replace(":", "");
    /*
    		if (!isNumSlash(src) && !isNumPeriod(src) && !isNumDash(src)) {
    			return false;
    		}
    */
    if (str.length != 6) {
        return false;
    }
    var year = str.substring(0, 4);
    var month = str.substring(4, 6);
    
    if (ComParseInt(year) >= 1900 && isMonth(month))
        return true;
    else {
        return false;
    }
}

/**
 * validation check date+time format
 * @param {String}	str		YYYYMMDDHHMI
 * @return
 */
function isValidYYYYMMDDHHMI(str) {
    str = new String(str);
    str = str.replace(/\/|\-|\./g, "");
    str = str.replace(" ", "");
    str = str.replace(":", "");
    if (str.length != 12) {
        return false;
    }
    
    if (!ComIsNumber(str)) {
        return false;
    }
    
    if (str.length != 12) {
        return false;
    }
    
    var sDate = str.substring(0, 8);
    var sHour = str.substring(8, 10);
    var sMin = str.substring(10, 12);
    
    if (ComIsDate(sDate) && ComIsTime(sHour + ":" + sMin, "hm")) {
        return true;
    } else {
        return false;
    }
}

/**
 * validation check month format
 * @param {String}	month	MM
 * @return
 */
function isMonth(month) {
    if (month.length > 2) return false;
    month = parseInt(month, 10);
    if ((month <= 0) || (month > 12)) return false;
    return true;
}

/**
 * validation check day format
 * @param {String}	day	DD
 * @return
 */
function isDay2(day) {
    if (day.length > 2) return false;
    day = parseInt(day, 10);
    if ((day <= 0) || (day > 31)) return false;
    return true;
}

/**
 * validation check day format
 * @param {String}	year	YYYY
 * @param {String}	month	MM
 * @param {String}	day		DD
 * @return
 */
function isDay(year, month, day) {
    if (day.length > 2) return false;
    year = parseInt(year, 10);
    month = parseInt(month, 10);
    day = parseInt(day, 10);
    if ((day <= 0) || (day > ComGetLastDay(year, month))) return false;
    return true;
}

/**
 * validation check hour format
 * @param {String}	hh	HH
 * @return
 */
function isHour(hh) {
    var h = parseInt(hh, 10);
    return (h >= 0 && h < 24);
}

/**
 * validation check minute format
 * @param {String}	mi	MI
 * @return
 */
function isMin(mi) {
    var m = parseInt(mi, 10);
    return (m >= 0 && m < 60);
}

/**
 * ComConfigSheet
 * @param {sheet}	sheet_obj	ibsheet
 * @return
 */
function TesComConfigSheet(sheet_obj) {
    ComConfigSheet(sheet_obj);
    try {
        with(sheet_obj) {}
    } catch (err) {
        ComFuncErrMsg(err.message);
    }
}