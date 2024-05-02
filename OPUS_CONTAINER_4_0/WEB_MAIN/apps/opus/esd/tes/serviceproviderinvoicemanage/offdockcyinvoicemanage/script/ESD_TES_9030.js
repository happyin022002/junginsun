/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9030.js
*@FileTitle  : Revised Vol.(Volume Adjustment)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var RVIS_CNTR_LIST_CD = '';
/* Event handler processing by button click event */
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 * @return
 */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_rowadd":
                doActionIBSheet(sheetObject, formObj, IBINSERT);
                break;
            case "btn_save":
                if (!sheetObject.IsDataModified()) {
                    ComShowMessage(ComGetMsg('TES21601'));
                    return false;
                }
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                ComClosePopup();
                break;
            case "btn_close":
                ComClosePopup();
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
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
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    var formObj = document.form;
    //doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    if (formObj.calc_tp_cd.value.trim() == 'A') {
        //AUTO MODE
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    } else if (formObj.calc_tp_cd.value.trim() == 'M' || formObj.calc_tp_cd.value.trim() == 'S') {
        //MANUAL MODE
        doActionIBSheetManual(sheetObjects[0], document.form, IBSEARCH);
    }
}

/**
 * setting sheet initial values and header
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {int} sheetNo 	 
 * 							adding case as numbers of counting sheets
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){			
				var HeadTitle="|STS|Seq.|Cost Code|CNTR No.|B/L|Remarks";				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_rvis_ind_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_cntr_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_rvis_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(240);
			}		
		break;
	
		case 2:   //manual_mode_hidden
			with(sheetObj){
				var HeadTitle="rvis_cntr_list_cd|lgs_cost_cd";				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rvis_cntr_list_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
			}		
		break;
	}
}

/**
 * Auto Calculated Cost handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST;
            sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            break;

        case IBINSERT: //Input
            var Row = sheetObj.DataInsert(-1);
            if (isNaN(formObj.tml_so_dtl_seq.value)) {
                ComShowMessage(ComGetMsg('TES24009', 'tml_so_dtl_seq'));
                return false;
            }
            sheetObj.SetCellValue(Row, "tml_so_dtl_seq", formObj.tml_so_dtl_seq.value, 0);
            setShtCellsEditable(sheetObj, Row, 'lgs_cost_cd|bl_no|cntr_rmk', 'Y');
            sheetObj.InitCellProperty(Row, 'lgs_cost_cd', { Type: "Combo", Align: "Center", Format: "dfNone" });
            sheetObj.CellComboItem(Row, 'lgs_cost_cd', { ComboText: formObj.calcTerminalComboItems.value, ComboCode: formObj.calcTerminalComboItems.value });
            sheetObj.SetCellValue(Row, "lgs_cost_cd", formObj.param_lgs_cost_cd.value, 0);
            sheetObj.SetCellValue(Row, "tml_so_ofc_cty_cd", formObj.tml_so_ofc_cty_cd.value, 0);
            sheetObj.SetCellValue(Row, "tml_so_seq", formObj.tml_so_seq.value, 0);
            break;

        case IBSAVE: //Save
            if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && formObj.calc_tp_cd.value.trim() == 'A') {
                if (sheetObj.RowCount() > 0 && sheetObj.IsDataModified()) {
                    formObj.f_cmd.value = MULTI;
                    var param = sheetObj.GetSaveString(false, false);
                    var savexml = sheetObj.GetSaveData("ESD_TES_9030Popup.do", param + '&' + tesFrmQryStr(formObj));
                    sheetObj.LoadSaveData(savexml, true);
                }
            } else if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && formObj.calc_tp_cd.value.trim() == 'M') {
                if (sheetObj.RowCount() > 0 && sheetObj.IsDataModified()) {
                    formObj.f_cmd.value = MULTI01;
                    var param = sheetObj.GetSaveString(false, false);
                    var savexml = sheetObj.GetSaveData("ESD_TES_9030Popup.do", param + '&' + tesFrmQryStr(formObj));
                    sheetObj.LoadSaveData(savexml, true);
                }
            }            		
            break;
    }
}

/**
 * Manual Calculated Cost handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @return
 */
function doActionIBSheetManual(sheetObj, formObj, sAction, RVIS_CNTR_LIST_CD) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST01;
            sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            break;
    }
}

/**
 * RVIS_CNTR_LIST_CD handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @return
 */
function doActionIBSheetManualRvisCntrListCode(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            break;
    }
}

/**
 * RVIS_CNTR_LIST_CD DEFAULT handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @param {string}	RVIS_CNTR_LIST_CD
 * @return
 */
function doActionIBSheetManualDefaultRetrieve(sheetObj, formObj, sAction, RVIS_CNTR_LIST_CD) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (RVIS_CNTR_LIST_CD == 'N') {
                document.all.div_manual_mode_button.style.display = 'inline';
                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'MT') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH02;
                sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'DG') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH03;
                sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'RF') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH04;
                sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'AK') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH05;
                sheetObj.DoSearch("ESD_TES_9030Popup.do", tesFrmQryStr(formObj));
            }
            break;
    }
}

/**
 * handling process for input validation
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}		sAction		
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //ComShowMessage('1:'+formObj.tml_so_ofc_cty_cd.value + '\n 2:'+ +formObj.tml_so_seq.value + '\n 3:'+ +formObj.calc_tp_cd.value + '\n 4:' +formObj.param_lgs_cost_cd.value + '\n 5:' +formObj.param_cntr_tpsz_cd.value);
        if (formObj.tml_so_ofc_cty_cd.value == undefined || formObj.tml_so_ofc_cty_cd.value == null || formObj.tml_so_ofc_cty_cd.value.trim() == '' ||
            formObj.tml_so_seq.value == undefined || formObj.tml_so_seq.value == null || formObj.tml_so_seq.value.trim() == '' ||
            formObj.calc_tp_cd.value == undefined || formObj.calc_tp_cd.value == null || formObj.calc_tp_cd.value.trim() == '' ||
            formObj.param_lgs_cost_cd.value == undefined || formObj.param_lgs_cost_cd.value == null || formObj.param_lgs_cost_cd.value.trim() == '') {
            ComShowMessage('Errors in missing mandatory item(s) to input.');
            return false;
        }
    }
    return true;
}

/**
 * search end event
 * @param {sheet}	sheet			ibsheet
 * @param {string}	ErrMsg			error message
 * @return
 */
function sheet_OnSearchEnd(sheet, ErrMsg) {
    var formObj = document.form;
    
    if (formObj.calc_tp_cd.value.trim() == 'M' || formObj.calc_tp_cd.value.trim() == 'S') {            
        for (var i = 1; i <= sheet.RowCount(); i++) {
            sheet.SetCellValue(i, "tml_so_dtl_seq", formObj.tml_so_dtl_seq.value, 0);       
            sheet.SetCellEditable(i, "cntr_no" , true);
            sheet.SetCellEditable(i, "bl_no" , true);
        }
        document.all.div_manual_mode_button.style.display = 'inline';
    }    
}

/**
 * save end event
 * @param {sheet}	sheet			ibsheet
 * @param {int}		Row				sheet row index
 * @param {int}		Col				sheet column index
 * @param {int}		Value			
 * @return
 */
function sheet_OnSaveEnd(sheet, Row, Col, Value) {
    if (sheet.RowCount() > 0) {
        resetOprRevVol(sheet);
    }
}

/**
 * search end event
 * @param {sheet}	sheetObj		ibsheet
 * @param {string}	ErrMsg			error message
 * @return
 */
function manual_mode_hidden_OnSearchEnd(sheetObj, ErrMsg) {
    //ComShowMessage('manual_mode_hidden_OnSearchEnd - '+sheetObj.CellValue(1,'rvis_cntr_list_cd'));
    if (sheetObj.RowCount() == 1) {
        RVIS_CNTR_LIST_CD = sheetObj.GetCellValue(1, 'rvis_cntr_list_cd');
        doActionIBSheetManualDefaultRetrieve(sheetObjects[0], document.form, IBSEARCH, sheetObj.GetCellValue(1, 'rvis_cntr_list_cd'));
    } else if (sheetObj.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES21032'));
        return false;
    }
}

//		function resetOprCalcVol(sheetObj){
//			var formObj = document.form;
//			var opener_obj = window.dialogArguments;
//			var opener_sheet_obj =  opener_obj.document.t3sheet1;
//			var sheet_curr_row = formObj.sheet_curr_row.value;
//			//ComShowMessage(sheet_curr_row + ' // '+getRevVolCnt(sheetObj));
//			opener_sheet_obj.CellValue(sheet_curr_row,'calc_vol_qty') = sheetObj.RowCount;
//		}

/**
 * reset Openp RevVol
 * @param {sheet}	sheetObj	ibsheet	
 * @return
 */
function resetOprRevVol(sheetObj) {
    var formObj = document.form;
    var opener_obj = window.parent;
    var opener_sheet_obj = opener_obj.t3sheet1;
    var sheet_curr_row = formObj.sheet_curr_row.value;
    //ComShowMessage(sheet_curr_row + ' // '+getRevVolCnt(sheetObj));
    opener_sheet_obj.SetCellValue(sheet_curr_row, 'rvis_vol_qty', getRevVolCnt(sheetObj));
}

/**
 * get RevVol Count
 * @param {sheet}	sheetObj	ibsheet	
 * @return
 */
function getRevVolCnt(sheetObj) {
    var rev_Y_vol_cnt = 0;
    var rev_vol_cnt = sheetObj.RowCount();
    if (rev_vol_cnt > 0) {        
        for (i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
            if (sheetObj.GetCellValue(i, 'tml_rvis_ind_flg') == 1) {
                rev_Y_vol_cnt++;
            }
        }
    }
    return (rev_vol_cnt - rev_Y_vol_cnt);
}

/**
 * set Sheett Cells Editable
 * @param {sheet}	sheetObj	ibsheet
 * @param {int}		rownum		row number
 * @param {int}		colnms		
 * @param {string}	to_sts		 
 * @return
 */
function setShtCellsEditable(sheetObj, rownum, colnms, to_sts) {
    if (rownum == null || rownum == undefined || colnms == null || colnms == undefined || to_sts == null || to_sts == undefined) {
        return false;
    }
    var arr_colnms = colnms.split('|');
    for (var i = 0; i < arr_colnms.length; i++) {
        sheetObj.SetCellEditable(rownum, arr_colnms[i], (to_sts != null && to_sts == 'Y' ? 1 : 0));
    }
}

/**
 * check duplicate row
 * @param {sheet}	sheet	ibsheet
 * @return
 */
function chkDupRow(sheet) {
    var Row = sheet.ColValueDup("cntr_no");
    if (Row > 0) {
        ComShowMessage(ComGetMsg('TES23050', 'CNTR NO'));
        return false;
    } else {
        return true;
    }
}