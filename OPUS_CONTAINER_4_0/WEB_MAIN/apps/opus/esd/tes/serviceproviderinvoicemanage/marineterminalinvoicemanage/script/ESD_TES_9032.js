/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9032.js
*@FileTitle  : Volume Adjustment PopUp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var err_flag = false;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObj = sheetObjects[0];
    var formObj = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btng_rowadd":
                var Row = sheetObj.DataInsert(-1);
                sheetObj.SetCellValue(Row, "rvis_ind_flg", 0);
                sheetObj.SetCellValue(Row, "rvis_lgs_cost_cd", formObj.lgs_cost_cd.value);
                sheetObj.SetCellValue(Row, "rvis_vsl_cd", formObj.vvd.value.substring(0, 4));
                sheetObj.SetCellValue(Row, "rvis_skd_voy_no", formObj.vvd.value.substring(4, 8));
                sheetObj.SetCellValue(Row, "rvis_skd_dir_cd", formObj.vvd.value.substring(8, 9));
                sheetObj.SetCellValue(Row, "rvis_cntr_tpsz_cd", formObj.cntr_tpsz_cd.value);
                sheetObj.SetCellValue(Row, "rvis_cntr_sty_cd", formObj.cntr_sty_cd.value);
                sheetObj.SetCellValue(Row, "rvis_tml_inv_tp_cd", 'TM');
                sheetObj.SetCellValue(Row, "rvis_calc_cost_grp_cd", 'TM');
                sheetObj.SetCellValue(Row, "rvis_tml_rvis_tp_cd", 'V');
                sheetObj.SetCellValue(Row, "rvis_calc_tp_cd", 'M');
                sheetObj.SetCellValue(Row, "rvis_page_rows", formObj.page_rows.value);
                sheetObj.SetCellValue(Row, "ctrt_rt", formObj.ctrt_rt.value);
                //					sheetObj.CellValue(Row, "ibflag") = "I";
                sheetObj.SetRowStatus(Row, "I");
                //sheetObj.RowStatus(Row) = 'R';
                sheetObj.SetCellEditable(Row, "rvis_lgs_cost_cd", 0);
                sheetObj.SetCellEditable(Row, "rvis_cntr_no", 1);
                sheetObj.SetCellEditable(Row, "rvis_bkg_no", 1);
                break;

            case "btn_ok":
                //         	        if (!sheetObj.IsDataModified){
                //         	            ComShowCodeMessage('TES21601'); 
                //         	            return false;
                //         	        }
                if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && formObj.calc_tp_cd.value == 'A') {
                    doActionIBSheet(sheetObj, formObj, IBSAVE);
                } else {
                    //setParentRvisSheet();
                    doActionIBSheet(sheetObj, formObj, IBINSERT);
                }
                if (err_flag == false) {
                    ComClosePopup();
                }
                break;

            case "btn_close":
                ComClosePopup();
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
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
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }  
    
    var formObj = document.form;
    if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && formObj.calc_tp_cd.value == 'A') {
        //자동MODE
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    } else if (formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && (formObj.calc_tp_cd.value == 'M' || document.form.calc_tp_cd.value == 'S')) {
        sheetObjects[0].SetColHidden("ctrt_rt", "1");
        
        //수동MODE
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet init
            with(sheetObj){                
	              var HeadTitle="STS|Seq.|cntr Seq.|dtl Seq.|rvis Seq.|Del.|Cost Code|Rate|CNTR No.|TP|F/M|INV TP|CALC GROUP|RVIS TP|Booking No|bkg_no_split|vsl_cd|skd_voy_no|skd_dir_cd|calc_tp|page_rows";
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
	                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_cntr_list_seq" },
	                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_dtl_seq" },
	                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_rvis_list_seq" },
	                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_ind_flg" },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_lgs_cost_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	                     {Type:"Float",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_rt",               		KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,    UpdateEdit:0,   InsertEdit:0},
	                     
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_sty_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_inv_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_calc_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_rvis_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:14 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_bkg_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_bkg_no_split",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_calc_tp_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_page_rows",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	              SetEditable(1);
	              resizeSheet();//SetSheetHeight(260);
                }

    	break;
    }    
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH01;
            var searchXml = sheetObj.GetSearchData("ESD_TES_9032GS.do", tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
            
        case IBSEARCH_ASYNC01: //Retrieve
            formObj.f_cmd.value = SEARCH02;
            var searchXml = sheetObj.GetSearchData("ESD_TES_9032GS.do", tesFrmQryStr(formObj));
            if (searchXml != "") sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
            
        case IBSAVE:
            formObj.f_cmd.value = MODIFY;
            formObj.rvis_vol_qty.value = getRVISQty();
            var param = sheetObj.GetSaveString(false, false);
            var saveXml = sheetObj.GetSaveData("ESD_TES_9032GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(saveXml, true);
            break;
            
        case IBINSERT:
            for (var i = sheetObjects[0].HeaderRows(); i < sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount(); i++) {
                sheetObjects[0].SetRowFontColor(i, "#000000");
            }
            err_flag = false;
            //no support[check again]CLT var Rows;
            Rows = sheetObj.ColValueDupRows("rvis_cntr_no");
            var arr_rows = Rows.split(',');
            for (var i = 0; arr_rows != '' && i < arr_rows.length; i++) {
                sheetObj.SetRowFontColor(arr_rows[i], "#FF0000");
                err_flag = true;
                // sheetObj.CellValue(arr_rows[i],"remark") = 'Duplicate';
            }
            if (err_flag == true) {
                ComShowMessage("Please check the column in red.");
                return false;
            }
            formObj.f_cmd.value = MODIFY02;
            formObj.rvis_vol_qty.value = getRVISQty();
            var param = sheetObj.GetSaveString();
            var saveXml = sheetObj.GetSaveData("ESD_TES_9032GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(saveXml, true);
            break;
    }
}

function sheet_OnSaveEnd(sheetObj) {
    window.parent.t3sheet1.SetCellValue(document.form.opener_row.value, 'rvis_vol_qty', document.form.rvis_vol_qty.value);
}

function sheet_OnSearchEnd(sheetObj) {
	for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
		sheetObj.SetCellValue(i, "ctrt_rt", document.form.ctrt_rt.value);
	}    
}

function sheet_OnChange(sheet, row, col) {
    var formObj = document.form;
    if (sheet.RowCount() > 0) {
        if (formObj.calc_tp_cd.value == 'A') {} else if (formObj.calc_tp_cd.value == 'M' || formObj.calc_tp_cd.value == 'S') {
            if (sheet.ColSaveName(col) == "rvis_ind_flg") {
                if (sheet.CellSearchValue(row, 'rvis_ind_flg') != sheet.GetCellValue(row, 'rvis_ind_flg')) {
                    if (sheet.GetCellValue(row, 'rvis_tml_so_rvis_list_seq') == null || sheet.GetCellValue(row, 'rvis_tml_so_rvis_list_seq') == '') {
                        //							sheet.CellValue(row,'ibflag') = "I";
                        sheet.SetRowStatus(row, "I");
                    } else {
                        //							sheet.CellValue(row,'ibflag') = "U";
                        sheet.SetRowStatus(row, "U");
                    }
                }
                /*
							if (sheet.CellSearchValue(row,'rvis_ind_flg')!=sheet.GetCellValue(row,'rvis_ind_flg')) {
							if (sheet.GetCellValue(row,'rvis_ind_flg')=='0'){
							if (sheet.GetCellValue(row,'rvis_tml_so_rvis_list_seq')==null || sheet.GetCellValue(row,'rvis_tml_so_rvis_list_seq')=='') {
//								sheet.CellValue(row,'ibflag') = "I";
								sheet.SetRowStatus(row,"I");
							} else {
//								sheet.CellValue(row,'ibflag') = "U";
								sheet.SetRowStatus(row,"U");
							}
							} else if (sheet.GetCellValue(row,'rvis_ind_flg')=='1') {
							if (!(sheet.GetCellValue(row,'rvis_tml_so_rvis_list_seq')==null || sheet.GetCellValue(row,'rvis_tml_so_rvis_list_seq')=='')) {
//								sheet.CellValue(row,'ibflag') = "D";
								sheet.SetRowStatus(row,"D");
							} else {
//								sheet.CellValue(row,'ibflag') = "R";
								sheet.SetRowStatus(row,"R");
							}
						}
					} else {
						//alert('ELSE : ' + sheet.CellSearchValue(row,'ibflag'));
						//sheet.RowStatus(row) = sheet.CellSearchValue(row,'ibflag');
						//sheet.CellValue2(row,'ibflag') = sheet.CellSearchValue(row,'ibflag');
//						sheet.CellValue2(row,'ibflag') = "I";
						sheet.SetRowStatus(row,"I");
					}*/
            }
        }
    }
}

function getRVISQty() {
    var sheetObj = sheetObjects[0];
    var qty = 0;
    var cntr_tpsz = document.form.cntr_tpsz_cd.value;
    var calc_tp = 0;
    if (document.form.calc_tp_cd.value == 'A') {
        calc_tp = 0
    } else if (document.form.calc_tp_cd.value == 'M' || document.form.calc_tp_cd.value == 'S') {
        calc_tp = 0;
    }
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'rvis_ind_flg') == calc_tp) {
            qty = parseInt(qty) + 1;
        }
    }
    /**
     * convert the volume if UOM is t(TEU)
     * return : volume
     */
    if (document.form.vol_tr_ut_cd.value == 'T') {
        if (cntr_tpsz == 'D4') {
            return parseFloat(qty) * 2;
        } else if (cntr_tpsz == 'D7') {
            return parseFloat(qty) * 2.25;
        } else if (cntr_tpsz == 'D8') {
            return parseFloat(qty) * 2.4;
        } else if (cntr_tpsz == 'D9') {
            return parseFloat(qty) * 2.4;
        } else if (cntr_tpsz == 'DW') {
            return parseFloat(qty) * 2.65;
        } else if (cntr_tpsz == 'DX') {
            return parseFloat(qty) * 2.25;
        }
    }
    return qty;
}