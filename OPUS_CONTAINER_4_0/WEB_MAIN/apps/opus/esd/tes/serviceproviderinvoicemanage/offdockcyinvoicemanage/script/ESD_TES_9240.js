/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9240.js
*@FileTitle  : Revised Vol.(Volume Adjustment)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
/**
 * @extends Tes
 * @class ESD_TES_9240 : business script for Off-Dock CY Invoice Revised Volume Separate Input
 */
function ESD_TES_9240() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.setComboObject = setComboObject;
    this.setTabObject = setTabObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.initTab = initTab;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
}

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
        var srcName = window.event.srcElement.getAttribute("name");
        switch (srcName) {
            case "btn_rowadd":
                doActionIBSheet(sheetObject, formObj, IBINSERT);
                break;

            case "btn_rowdel":
                doActionIBSheet(sheetObject, formObj, IBDELETE);
                break;


            case "btn_save":
                //if (!sheetObject.IsDataModified){
                //ComShowMessage('수정된 내역이 없습니다.');
                //return false;
                //}
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                ComClosePopup();
                break;

            case "btn_close":
                ComClosePopup();
                break;
        }
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES23028')); //ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet} 	sheetObj 	IBSheet Object
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
    if (formObj.calc_tp_cd.value.trim() == 'A') {
        //자동MODE
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        
    } else if (formObj.calc_tp_cd.value.trim() == 'M' || formObj.calc_tp_cd.value.trim() == 'S') {
        //수동MODE
        doActionIBSheetManual(sheetObjects[0], document.form, IBSEARCH);
    }
}

/**
 * setting sheet initial values and header
 * @param {ibsheet} 	sheetObj 	IBSheet Object
 * @param {int} 		sheetNo 	
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {                   
				var HeadTitle="STS|Seq.|Cost Code|CNTR No.|Type/\nSize|F/M||Gate In||Gate Out|Remark";				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,  	SaveName:"ibflag" },
							{Type:"Seq",       	Hidden:0, Width:30,   Align:"Center",  ColMerge:0,  	SaveName:"",                           	KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:0, Width:70,   Align:"Center",  ColMerge:0,  	SaveName:"lgs_cost_cd",             	KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      	Hidden:0, Width:90,   Align:"Center",  ColMerge:0,  	SaveName:"cntr_no",           		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							
							{Type:"Text",      	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   	SaveName:"cntr_tpsz_cd",           	KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   	SaveName:"cntr_sty_cd",        		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"CheckBox", 	Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   	SaveName:"rvis_gate_in_flg",  		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:0, Width:110, 	Align:"Center",  ColMerge:0,  	SaveName:"inv_gate_in_dt",  		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:16 },
							{Type:"CheckBox", 	Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   	SaveName:"rvis_gate_out_flg",  		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Text",      	Hidden:0, Width:110, 	Align:"Center",  ColMerge:0,   	SaveName:"inv_gate_out_dt",  		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:16  },
							{Type:"Text",      	Hidden:0, Width:200, 	Align:"Center", 	ColMerge:0,   	SaveName:"cntr_rmk",  				KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"tml_so_ofc_cty_cd",  	KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"tml_so_seq",  			KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"tml_so_cntr_list_seq",  	KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"tml_so_dtl_seq",  		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"tml_so_rvis_list_seq",  	KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"tml_inv_tp_cd",  			KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"calc_cost_grp_cd",  		KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      	Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   	SaveName:"tml_rvis_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				resizeSheet();//SetSheetHeight(260);                    
				
				SetColProperty("inv_gate_in_dt", {Format:"####-##-## ##:##"} );
				SetColProperty("inv_gate_out_dt", {Format:"####-##-## ##:##"} );			
			}
		break;
		
		case 2:   //manual_mode_hidden
			with (sheetObj) {			
				var HeadTitle="rvis_cntr_list_cd|lgs_cost_cd";				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_list_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(1);                    
		}
		break;
	}   
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
 * handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg = false;
    switch (sAction) {
        case IBSEARCH: //Retrieve
            //AUTO MODE
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST;
            sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
            break;

        case IBINSERT: //Input
            var Row = sheetObj.DataInsert(-1);
            if (isNaN(formObj.tml_so_dtl_seq.value)) {
                ComShowMessage(ComGetMsg('TES24009', 'tml_so_dtl_seq'));
                return false;
            }
            
            sheetObj.SetCellValue(Row, "tml_so_dtl_seq", formObj.tml_so_dtl_seq.value);           
            
            sheetObj.InitCellProperty(Row, 'lgs_cost_cd', dtCombo, daCenter, 'lgs_cost_cd', '', dfNone);
            sheetObj.InitCellProperty(Row, 'cntr_tpsz_cd', dtCombo, daCenter, 'cntr_tpsz_cd', '', dfNone);
            sheetObj.InitCellProperty(Row, 'cntr_sty_cd', dtCombo, daCenter, 'cntr_sty_cd', '', dfNone);
            
            sheetObj.CellComboItem(Row, 'lgs_cost_cd', formObj.calcTerminalComboItems.value, formObj.calcTerminalComboItems.value);
            sheetObj.CellComboItem(Row, 'cntr_tpsz_cd', formObj.cntr_tpsz_cd.value, formObj.cntr_tpsz_cd.value);
            sheetObj.CellComboItem(Row, 'cntr_sty_cd', formObj.cntr_sty_cdCode.value, formObj.cntr_sty_cdCode.value);
            
            sheetObj.SetCellValue(Row, "lgs_cost_cd", formObj.param_lgs_cost_cd.value);
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd", "");
            sheetObj.SetCellValue(Row, "cntr_sty_cd", "");
            sheetObj.SetCellValue(Row, "tml_so_ofc_cty_cd", formObj.tml_so_ofc_cty_cd.value);
            sheetObj.SetCellValue(Row, "tml_so_seq", formObj.tml_so_seq.value);
            sheetObj.SetCellValue(Row, "vrfy_rslt_ind_cd", "CO");
            break;

        case IBDELETE:
            if (sheetObj.RowCount() > 0) {
                var Row = sheetObj.GetSelectRow();
                // CHM-201432447 [TES] Semi-updated의 revised vol 입력기능 보완 2014-12-09
                if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && (formObj.calc_tp_cd.value.trim() == 'M' || formObj.calc_tp_cd.value.trim() == 'S')) {
                    if (sheetObj.GetCellValue(Row, "tml_so_rvis_list_seq") == null || sheetObj.GetCellValue(Row, "tml_so_rvis_list_seq") == '' || parseInt(sheetObj.GetCellValue(Row, "tml_so_rvis_list_seq"), 10) == 0) {
                        sheetObj.RowDelete(Row, true);
                    } else {
                        sheetObj.SetRowStatus(Row, 'D');
                        sheetObj.SetRowHidden(Row, 1);
                    }
                }
            }
            break;
            
        case IBSAVE: //Save
            //if(chkDupRow(sheetObj)){ 
            if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && formObj.calc_tp_cd.value.trim() == 'A') {
                if (sheetObj.RowCount() > 0 && sheetObj.IsDataModified()) {
                    formObj.f_cmd.value = MULTI;
                    var param = sheetObj.GetSaveString(false, false);
                    var savexml = sheetObj.GetSaveData("ESD_TES_9240Popup.do", param + '&' + tesFrmQryStr(formObj));
                    sheetObj.LoadSaveData(savexml, true);
                }
            } else if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && (formObj.calc_tp_cd.value.trim() == 'M' || formObj.calc_tp_cd.value.trim() == 'S')) {
                if (sheetObj.RowCount() > 0 && sheetObj.IsDataModified) {
                    formObj.f_cmd.value = MULTI01;
                    var param = sheetObj.GetSaveString(false, false);
                    var savexml = sheetObj.GetSaveData("ESD_TES_9240Popup.do", param + '&' + tesFrmQryStr(formObj));
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
 * @param {int}		sAction		
 * @return
 */
function doActionIBSheetManual(sheetObj, formObj, sAction, RVIS_CNTR_LIST_CD) {
    sheetObj.ShowDebugMsg = false;
    switch (sAction) {
        case IBSEARCH: //Retrieve
            // MANUAL MODE : TES_TML_SO_RVIS_LIST Retrieve 
            // ROWCOUNT == 0 : RVIS_CNTR_LIST_CD DEFAULT
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST01;
            sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
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
    //RVIS_CNTR_LIST_CD
    sheetObj.ShowDebugMsg = false;
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
            break;
    }
}

/**
 * RVIS_CNTR_LIST_CD DEFAULT List handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @param {string}	RVIS_CNTR_LIST_CD		Cost Code  Revise Container List Code
 * @return
 */
function doActionIBSheetManualDefaultRetrieve(sheetObj, formObj, sAction, RVIS_CNTR_LIST_CD) {
    //Retrieve RVIS_CNTR_LIST_CD DEFAULT List
    //ComShowMessage('doActionIBSheetManualDefaultRetrieve:'+RVIS_CNTR_LIST_CD);
    sheetObj.ShowDebugMsg = false;
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (RVIS_CNTR_LIST_CD == 'N') {
                document.all.div_manual_mode_button.style.display = 'inline';
                formObj.f_cmd.value = SEARCH01;
                //formObj.f_cmd.value = '';
                sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'MT') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH02;
                sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'DG') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH03;
                sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'RF') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH04;
                sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
            } else if (RVIS_CNTR_LIST_CD == 'AK') {
                document.all.div_manual_mode_button.style.display = 'none';
                formObj.f_cmd.value = SEARCH05;
                sheetObj.DoSearch("ESD_TES_9240Popup.do", tesFrmQryStr(formObj));
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
        if (ComIsNull(formObj.tml_so_ofc_cty_cd.value) || formObj.tml_so_ofc_cty_cd.value ==undefined  || ComIsNull(formObj.tml_so_seq.value) || formObj.tml_so_seq.value ==undefined  || ComIsNull(formObj.param_lgs_cost_cd.value) || formObj.param_lgs_cost_cd.value ==undefined ) { 
            ComShowMessage('Errors in missing mandatory item(s) to input.');
            return false;
        }
    }
    return true;
}


/** EVENT ***********************************************************************************/

/**
 * sheet change event
 * @param {sheet}	sheet			ibsheet
 * @param {int}		Row				sheet row index
 * @param {int}		Col				sheet column index
 * @param {int}		Value			
 * @return
 */
function sheet_OnChange(sheet, Row, Col, Value) {

}

/**
 * sheet retrieve event
 * @param {sheet}	sheet			ibsheet
 * @param {string}	ErrMsg			error message
 * @return
 */
function sheet_OnSearchEnd(sheet, ErrMsg) {
    var formObj = document.form;
   
    for (var i = 1; i <= sheet.RowCount(); i++) {
        if (!ComIsNull(sheet.GetCellValue(i, "inv_gate_in_dt"))) {
            sheet.SetCellEditable(i, 'rvis_gate_in_flg', true);
        } 
        
        if (!ComIsNull(sheet.GetCellValue(i, "inv_gate_out_dt"))) {
            sheet.SetCellEditable(i, 'rvis_gate_out_flg', true);
        }

        if (formObj.calc_tp_cd.value.trim() == 'M' || formObj.calc_tp_cd.value.trim() == 'S') {            
            sheet.SetCellValue(i, "tml_so_dtl_seq", formObj.tml_so_dtl_seq.value);
            sheet.SetCellEditable(i, 'cntr_no', true);
            sheet.SetCellEditable(i, 'cntr_tpsz_cd', true);
            sheet.SetCellEditable(i, 'cntr_sty_cd', true);
            sheet.SetCellEditable(i, 'inv_gate_in_dt', true);
            sheet.SetCellEditable(i, 'inv_gate_out_dt', true);         
        }
    }   
    
    if (formObj.calc_tp_cd.value.trim() == 'M' || formObj.calc_tp_cd.value.trim() == 'S') {            
         document.all.div_manual_mode_button.style.display = 'inline';
    }
}

/**
 * sheet save event
 * @param {sheet}	sheet			ibsheet
 * @param {int}		Row				sheet row index
 * @param {int}		Col				sheet column index
 * @param {int}		Value			
 * @return
 */
function sheet_OnSaveEnd(sheet, Row, Col, Value) {
    if (sheet.RowCount() >= 0) {
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
    //ComShowMessage('manual_mode_hidden_OnSearchEnd - '+sheetObj.GetCellValue(1,'rvis_cntr_list_cd'));
    if (sheetObj.RowCount() == 1) {
        RVIS_CNTR_LIST_CD = sheetObj.GetCellValue(1, 'rvis_cntr_list_cd');
        doActionIBSheetManualDefaultRetrieve(sheetObjects[0], document.form, IBSEARCH, sheetObj.GetCellValue(1, 'rvis_cntr_list_cd'));
    } else if (sheetObj.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES21032'));
        return false;
    }
}


function sheet_OnClick(sheet, Row, Col, Value) {
    if (sheet.ColSaveName(Col) == 'rvis_gate_in_flg' || sheet.ColSaveName(Col) == 'rvis_gate_out_flg') {
        //ComShowMessage(sheet.GetCellValue(Row, Col));
    }
}

function resetOprCalcVol(sheetObj) {
    var formObj = document.form;
    var opener_obj = window.dialogArguments;
    var opener_sheet_obj = opener_obj.document.t3sheet1;
    var sheet_curr_row = formObj.sheet_curr_row.value;
    //ComShowMessage(sheet_curr_row + ' // '+getRevVolCnt(sheetObj));
    opener_sheet_obj.GetCellValue(sheet_curr_row, 'calc_vol_qty') = getCalcVolCnt(sheetObj);
}

function resetOprRevVol(sheetObj) {
    //ComShowMessage('resetOprRevVol');
    var formObj = document.form;

    var opener_obj = parent; //이 코드 추가할것

    var opener_sheet_obj = opener_obj.t3sheet1;
    var sheet_curr_row = formObj.sheet_curr_row.value;
    var cnt = getRevVolCnt(sheetObj);
    opener_sheet_obj.SetCellValue(sheet_curr_row, 'rvis_vol_qty', cnt);
}

function getCalcVolCnt(sheetObj) {
    var rev_vol_cnt = 0;

    if (sheetObj.RowCount() > 0) {
        for (i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
            if (sheetObj.GetCellValue(i, "inv_gate_in_dt") != null && sheetObj.GetCellValue(i, "inv_gate_in_dt").trim() != '') {
                rev_vol_cnt++;
            }
            if (sheetObj.GetCellValue(i, "inv_gate_out_dt") != null && sheetObj.GetCellValue(i, "inv_gate_out_dt").trim() != '') {
                rev_vol_cnt++;
            }
        }
    }
    return rev_vol_cnt;
}

function getRevVolCnt(sheetObj) {
    var rev_Y_vol_cnt = 0; //revised 'Y' cnt
    var rev_vol_cnt = 0; //rev_vol_cnt

    if (sheetObj.RowCount() > 0) {
        for (i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) { //제목은 제외
        
            if (sheetObj.GetCellValue(i, "inv_gate_in_dt") != null && sheetObj.GetCellValue(i, "inv_gate_in_dt").trim() != '') {
                rev_vol_cnt++;
            }
            if (sheetObj.GetCellValue(i, "inv_gate_out_dt") != null && sheetObj.GetCellValue(i, "inv_gate_out_dt").trim() != '') {
                rev_vol_cnt++;
            }
            if (sheetObj.GetCellValue(i, "rvis_gate_in_flg") == 1) {
                rev_Y_vol_cnt++;
            }
            if (sheetObj.GetCellValue(i, "rvis_gate_out_flg") == 1) {
                rev_Y_vol_cnt++;
            }
        }
    }
    //ComShowMessage(rev_vol_cnt + ' / ' + rev_Y_vol_cnt);
    return (rev_vol_cnt - rev_Y_vol_cnt);
}

function chkDupRow(sheet) {
    var Row = sheet.ColValueDup("cntr_no");
    if (Row > 0) {
        ComShowMessage(ComGetMsg('TES23050', 'CNTR NO'));
        return false;
    } else {
        return true;
    }
}