/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9010.jsp
*@FileTitle  : Get Container List Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/** processButtonClick
 *  Event handler processing by button name
 */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_tmpdown":
                doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC05);
                break;
                
            case "btn_verify": 
                //if(formObject.excel_chk.value == "N"){
                //	ComShowMessage(ComGetMsg('TES22601'));
                //	return false;
                //}
                verifyContainerList();
                if (formObject.verify_chk.value == null || formObject.verify_chk.value == "" || formObject.verify_chk.value != "Y") {
                    ComShowMessage(ComGetMsg('TES22602'));
                    return false;
                }
                //         	    	var openerSheetObj1 = window.dialogArguments.document.t1sheet1; // Coincidence
                //	    	        var openerSheetObj2 = window.dialogArguments.document.t2sheet1; // Discrepancy
                break;
                
            case "btn_loadexcel":
                if (ComGetObjValue(formObject.file_import_yn) != "Y") {
                    ComShowMessage("Please select YES at File Import.");
                    return false;
                }
                doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
                break;
                
            case "btn_chkdigit":
                if (sheetObject.RowCount() > 0) {
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_rowadd":
                if (ComGetObjValue(formObject.file_import_yn) == "Y") {
                    ComShowMessage('Select NO at File Import to use this function');
                    return false;
                }
                var row = sheetObject.DataInsert(-1);
                sheetObject.SetCellValue(row, 'io_bnd_cd', formObject.io_bnd_cd.value);
                break;
                
            case "btn_rowdel":
                formObject.excel_chk.value = 'N';
                //        	        sheetObject.RowDelete(sheetObject.SelectRow , false);
                var selectedRow = sheetObject.GetSelectionRows('|').split('|');
                for (var i = selectedRow.length - 1; i >= 0; i--) {
                    sheetObject.RowDelete(selectedRow[i], false);
                }
                break;
                
            case "btn_retrieve":
                if (formObject.wo_no.value == '' || formObject.wo_no.value == null) {
                    ComShowMessage("Please enter W/O No.");
                    return false;
                }
                doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC04);
                break;
                
            case "btn_close":
                ComClosePopup();
                break;
                
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
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

    var openerObj;
    openerObj = window.dialogArguments;

    if (!openerObj) openerObj = window.opener; //이 코드 추가할것
    if (!openerObj) openerObj = parent; // 기존 가이드 부분

    initValue(openerObj.document.form, document.form);
}

/** initializing sheet
 * 
 * @param openerObj		opener object
 * @param formObj		from	object
 * @return
 */
function initValue(openerObj, formObj) { //alert("vvd_type===>"+openerObj.vvd_type.value);
    formObj.vvd.value = openerObj.vvd.value;
    formObj.vvd_type.value = openerObj.vvd_type.value;
    formObj.io_bnd_cd.value = openerObj.io_bnd_cd.value;
    formObj.vndr_seq.value = openerObj.vndr_seq.value;
    formObj.yd_cd.value = openerObj.yd_cd.value;
    formObj.rcv_dt.value = openerObj.rcv_dt.value;
    formObj.iss_dt.value = openerObj.iss_dt.value;
    formObj.tml_so_ofc_cty_cd.value = openerObj.tml_so_ofc_cty_cd.value;
    formObj.tml_so_seq.value = openerObj.tml_so_seq.value;
    formObj.atb_dt.value = openerObj.atb_dt.value;
    formObj.call_yd_ind_seq.value = openerObj.call_yd_ind_seq.value; //2016.07.13 Add
    formObj.file_import_yn[0].checked = true;
    formObj.com_list_yn[0].checked = true;
    formObj.manual_input_yn[0].checked = true;
    formObj.manual_input_yn[0].disabled = true;
    formObj.manual_input_yn[1].disabled = true;
    formObj.import_tp_all.checked = true;
    formObj.import_ts_tp[0].checked = false;
    formObj.import_ts_tp[1].checked = false;
    formObj.import_fm_tp[0].checked = false;
    formObj.import_fm_tp[1].checked = false;
    formObj.import_tp_all.disabled = true;
    formObj.import_ts_tp[0].disabled = true;
    formObj.import_ts_tp[1].disabled = true;
    formObj.import_fm_tp[0].disabled = true;
    formObj.import_fm_tp[1].disabled = true;
    ComEnableObject(formObj.wo_no, false);
    //alert("formObj.vvd_type.value===>"+formObj.vvd_type.value);
    if (formObj.vvd_type.value == "H" || formObj.vvd_type.value == "C") {
        formObj.file_import_yn[0].checked = true;
    } else if (formObj.vvd_type.value == "B") {
        formObj.file_import_yn[0].checked = true;
        formObj.file_import_yn[1].disabled = true;
    }
}

/**
 * setting sheet initial values and header
 * @param : sheetObj ==> , 
 * @param : sheetNo ==>  
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet init
			with(sheetObj){
				var HeadTitle="Status|Seq|CNTR No.|Type/Size|F/M|I/O|Working Date|Remark";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1,  ComboMaxHeight:200 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				resizeSheet();//SetSheetHeight(240);
				SetEditable(1);
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:"|"+document.form.cntr_tpsz_cd.value, ComboCode:"|"+document.form.cntr_tpsz_cd.value} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetClipPasteMode(2);
			}
		break;
		
		case 2:      //sheet2 init
			with(sheetObj){
				var HeadTitle="Status|Seq|CNTR No.|Type/Size|F/M|I/O|Working Date|Remark";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1,  ComboMaxHeight:200 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"remark",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				resizeSheet();//SetSheetHeight(240);
				SetEditable(1);
				SetColProperty("cntr_sty_cd", {ComboText:cntr_sty_cdCode, ComboCode:cntr_sty_cdCode} );
				SetColProperty("io_bnd_cd", {ComboText:io_bnd_cdCode, ComboCode:io_bnd_cdCode} );
				SetColProperty("cntr_tpsz_cd", {ComboText:"|"+document.form.cntr_tpsz_cd.value, ComboCode:"|"+document.form.cntr_tpsz_cd.value} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetClipPasteMode(2);
			}
		break;
	}    
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param(sheet_obj) sheet object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/** Apply vefify
 * 
 * @return
 */
function verifyContainerList() {
    var formObj = document.form;
    if (formObj.import_tp_all.checked == true) {
        formObj.all_tp.value = 'Y';
    } else {
        formObj.all_tp.value = 'N';
    }
    formObj.fm_tp.value = '';
    formObj.ts_tp.value = '';
    for (var i = 0; i < 2; i++) {
        if (formObj.import_fm_tp[i].checked == true) {
            formObj.fm_tp.value = formObj.fm_tp.value + formObj.import_fm_tp[i].value;
        }
        if (formObj.import_ts_tp[i].checked == true) {
            formObj.ts_tp.value = formObj.ts_tp.value + formObj.import_ts_tp[i].value;
        }
    }
    if (ComGetObjValue(formObj.file_import_yn) == "N") {
        for (var i = sheetObjects[0].HeaderRows(); i < sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount(); i++) {
            sheetObjects[0].SetRowFontColor(i, "#000000");
            if (sheetObjects[0].GetCellValue(i, "remark") == 'Duplicate') {
                sheetObjects[0].SetCellValue(i, "remark", '');
            }
        }
        if (ComGetObjValue(formObj.manual_input_yn) == "N") {
            if (sheetObjects[0].RowCount() == 0) {
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
            } else {
                doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            }
        } else {
            if (sheetObjects[0].RowCount() < 1) {
                ComShowMessage('Please insert CNTR information');
                return false;
            }
            if (validateManualInput() == false) {
                return false;
            }
            if (mandatoryCheck() == false) {
                return false;
            }
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    } else {
        if (formObj.excel_chk.value == "N") {
            sheet_OnLoadExcel(sheetObjects[0]);
        }
        if (sheetObjects[0].RowCount() < 1) {
            ComShowMessage(ComGetMsg('TES40017')); // File has not been imported
            return false;
        }
        if (formObj.excel_chk.value == "N") {
            ComShowMessage(ComGetMsg('TES22601')); // EXCEL FILE SOURCE DATA is wrong
            return false;
        }
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    }
    formObj.verify_chk.value = "Y";
}

/** handling sheet process
 *  @param sheetObj 	sheet 	Object
 *  @param formObj 		form 	Object
 *  @param sAction 		sAction Object
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {        
        case IBSEARCH_ASYNC03: //COM List Only VERIFY
            formObj.f_cmd.value = SEARCH03;
            var saveXml = sheetObj.GetSearchData("ESD_TES_9010GS.do", tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            //ComShowMessage(saveXml);
            if (saveXml != "") sheetObj.LoadSaveData(saveXml, true);
            break;
            
        case IBSEARCH_ASYNC01: //Check Digit
            formObj.f_cmd.value = SEARCH01;
            //alert("SEARCH01:"+SEARCH01);
            var param = sheetObj.GetSaveString(true, false);
            var searchXml = sheetObj.GetSearchData("ESD_TES_9010GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            //ComShowMessage(searchXml);
            if (searchXml != "") sheetObj.LoadSearchData(searchXml, { Sync: 1 });
            break;
            
        case IBSEARCH_ASYNC04: //Work Order Calling
            formObj.f_cmd.value = SEARCH04;
            //alert("SEARCH04:"+SEARCH04);
            var searchXml = sheetObj.GetSearchData("ESD_TES_9010GS.do", tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            //ComShowMessage(searchXml);
            if (searchXml != "") sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
            
        case IBLOADEXCEL: //Retrieve
            sheetObj.RemoveAll();
            sheetObj.LoadExcel({ Mode: "HeaderMatch" });
            //                checkExcelData(sheetObj);
            //				formValue2Sheet(sheetObj);
            break;
            
        case IBSEARCH:  //FILE VERIFY
            formObj.f_cmd.value = SEARCH;
            var param = sheetObj.GetSaveString(true, false);
            var searchXml = sheetObj.GetSearchData("ESD_TES_9010GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            if (searchXml != "") sheetObj.LoadSaveData(searchXml, true);
            break;

        case SEARCH05: //search CNTR Type CD 				
            formObj.f_cmd.value = SEARCH05;
            var param = sheetObj.GetSaveString(true, false);
            var sXml = sheetObj.GetSearchData("ESD_TES_9010GS.do", param + '&' + tesFrmQryStr(formObj), "", true);

            sheetObj.RemoveAll();
            sheetObj.LoadSearchData(sXml, { Append: 1, Sync: 1 });
            break;   
       	
       	case IBSEARCH_ASYNC05: //search Template Down			
            formObj.f_cmd.value = SEARCH06;
            var param = sheetObj.GetSaveString(true, false);
            var sXml = sheetObj.GetSearchData("ESD_TES_9010GS.do", param + '&' + tesFrmQryStr(formObj), "", true);

            sheetObj.RemoveAll();
            //if (saveXml != "") sheetObj.LoadSaveData(saveXml, true);
            sheetObj.LoadSearchData(sXml, { Append: 1, Sync: 1 });
            break;                 
    }
}

/** doActionIBSheet1
 * 
 * @param sheetObj 	sheetObj value
 * @param formObj	formObj value
 * @param sAction	Action value
 * @return
 */
function doActionIBSheet1(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH03;
            //alert("SEARCH03:"+SEARCH03);
            var searchXml = sheetObj.GetSearchData("ESD_TES_9010GS.do", tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            //ComShowMessage(searchXml);
            if (searchXml != "") sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
    }
}

/** Show after saving message
 * 
 * @param sheetObj
 * @return
 */
function sheet_OnSaveEnd(sheetObj) {

    var opener_obj;
    opener_obj = window.dialogArguments;
    if (!opener_obj) opener_obj = window.opener; //이 코드 추가할것
    if (!opener_obj) opener_obj = parent; //이 코드 추가할것

    opener_obj.fileimp();
    var count = parseInt(opener_obj.t1sheet1.RowCount()) + parseInt(opener_obj.t2sheet1.RowCount());
    ComShowMessage(count + ComGetMsg('TES40043')); //ComShowMessage((parseInt(window.dialogArguments.document.t1sheet1.RowCount()) + parseInt(window.dialogArguments.document.t2sheet1.RowCount()))+ '건의 List가 verify완료되었습니다.');
    ComClosePopup();
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg){
	sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
}

/** sheet after change
 * 
 * @param sheetObj	
 * @param row
 * @param col
 * @param value
 * @return
 */
function sheet_OnChange(sheetObj, row, col, value, oldValue, raiseFlag) {
    if (sheetObj.ColSaveName(col) == 'cntr_no' || sheetObj.ColSaveName(col) == 'cntr_tpsz_cd' || sheetObj.ColSaveName(col) == 'cntr_sty_cd' || sheetObj.ColSaveName(col) == 'wrk_dt') {
        document.form.excel_chk.value = 'N';
    }
    	
    if (sheetObj.ColSaveName(col) == 'cntr_no') {
        document.form.cntr_no.value = value;
        document.form.row.value = row;
        
		sheetObjects[0].SetCellValue(row, "cntr_tpsz_cd", getCntrTpSz());  //tes_getInputValue('tmp_cntr_tpsz_cd', SEARCH23, 'cntr_no|row', 'searchCntrTPSZ');
    }
}

function searchCntrTPSZ(row) {
    sheetObjects[0].SetCellValue(row, "cntr_tpsz_cd", document.form.tmp_cntr_tpsz_cd.value);
}

/** excel load
 * 
 * @param sheetObj
 * @return
 */
function sheet_OnLoadExcel(sheetObj, result, code, msg) {
    if (isExceedMaxRow(msg)) return;	
	
	if (sheetObj.RowCount() > 0) {
        doActionIBSheet(sheetObj, document.form, SEARCH05);
    }
	
    document.form.excel_chk.value = "Y";
    sheetObj.SetDataAutoTrim(1);

    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        sheetObj.SetCellValue(i, "io_bnd_cd", sheetObj.GetCellValue(i, "io_bnd_cd").toUpperCase());
        if (sheetObj.GetCellValue(i, "cntr_no").length == 0 || !ComIsAlphabet(sheetObj.GetCellValue(i, "cntr_no"), "n")) {
            sheetObj.SetCellBackColor(i, "cntr_no", "#FFFF66");
            sheetObj.SetCellFontColor(i, "cntr_no", "#FF0000");
            document.form.excel_chk.value = "N";
            sheetObj.SetCellValue(i, "remark", 'CNTR No.');
            sheetObj.RowDelete(i, 0);
            i = i - 1;
        }
        
        if (sheetObj.GetCellValue(i, "cntr_sty_cd").length != 1 || !(sheetObj.GetCellValue(i, "cntr_sty_cd").toUpperCase() == "M" || sheetObj.GetCellValue(i, "cntr_sty_cd").toUpperCase() == "F")) {
            sheetObj.SetCellBackColor(i, "cntr_sty_cd", "#FFFF66");
            sheetObj.SetCellFontColor(i, "cntr_sty_cd", "#FF0000");
            document.form.excel_chk.value = "N";
            sheetObj.SetCellValue(i, "remark", 'Full/Empty');
        }
        
        if (sheetObj.GetCellValue(i, "io_bnd_cd").length != 1 || !(sheetObj.GetCellValue(i, "io_bnd_cd").toUpperCase() == "I" || sheetObj.GetCellValue(i, "io_bnd_cd").toUpperCase() == "O") || sheetObj.GetCellValue(i, "io_bnd_cd").toUpperCase() != document.form.io_bnd_cd.value) {
            //alert(sheetObj.CellBackColor(i, "io_bnd_cd"));
            sheetObj.SetCellBackColor(i, "io_bnd_cd", "#FFFF66");
            sheetObj.SetCellFontColor(i, "io_bnd_cd", "#FF0000");
            document.form.excel_chk.value = "N";
            sheetObj.SetCellValue(i, "remark", 'Bound');
        }
        
        if (!ComIsDate(sheetObj.GetCellValue(i, "wrk_dt"))) {
            sheetObj.SetCellBackColor(i, "wrk_dt", "#FFFF66");
            sheetObj.SetCellFontColor(i, "wrk_dt", "#FF0000");
            document.form.excel_chk.value = "N";
            sheetObj.SetCellValue(i, "remark", 'Working Date');
        }

//        if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "") {
//            document.form.cntr_no.value = sheetObj.GetCellValue(i, "cntr_no");
//            document.form.row.value = i;
//
//            tes_getInputValue('tmp_cntr_tpsz_cd', SEARCH23, 'cntr_no|row', 'searchCntrTPSZ');
//        }

    }
    
    var Rows = sheetObj.ColValueDupRows("cntr_no");
    var arr_rows = Rows.split(',');
    
    for (var i = 0; arr_rows != '' && i < arr_rows.length; i++) {
        sheetObj.SetRowFontColor(arr_rows[i], "#FF0000");
        document.form.excel_chk.value = "N";
        sheetObj.SetCellValue(arr_rows[i], "remark", 'Duplicate');
    }
}

/** com_list_only sts
 * 
 * @return
 */
function com_list_only_sts() {
    var formObj = document.form;
    if (formObj.file_import_yn[0].checked == true) {
        formObj.com_list_yn[0].disabled = false;
        formObj.com_list_yn[1].disabled = false;
        formObj.manual_input_yn[0].disabled = true;
        formObj.manual_input_yn[1].disabled = true;
        formObj.import_tp_all.disabled = true;
        formObj.import_ts_tp[0].disabled = true;
        formObj.import_ts_tp[1].disabled = true;
        formObj.import_fm_tp[0].disabled = true;
        formObj.import_fm_tp[1].disabled = true;
        ComEnableObject(formObj.wo_no, false);
    } else {
        //	        if(formObj.manual_input_yn[0].checked == true){
        //	            formObj.com_list_yn[0].disabled = false;
        //	            formObj.com_list_yn[1].disabled = false;
        //    	        formObj.manual_input_yn[0].disabled = false;
        //    	        formObj.manual_input_yn[1].disabled = false;
        //	        }else{
        formObj.com_list_yn[1].checked = true;
        formObj.com_list_yn[0].disabled = true;
        formObj.com_list_yn[1].disabled = true;
        formObj.manual_input_yn[0].disabled = false;
        formObj.manual_input_yn[1].disabled = false;
        if (formObj.manual_input_yn[0].checked == true) {
            formObj.import_tp_all.disabled = true;
            formObj.import_ts_tp[0].disabled = true;
            formObj.import_ts_tp[1].disabled = true;
            formObj.import_fm_tp[0].disabled = true;
            formObj.import_fm_tp[1].disabled = true;
            ComEnableObject(formObj.wo_no, false);
        } else {
            formObj.import_tp_all.disabled = false;
            formObj.import_ts_tp[0].disabled = false;
            formObj.import_ts_tp[1].disabled = false;
            formObj.import_fm_tp[0].disabled = false;
            formObj.import_fm_tp[1].disabled = false;
            ComEnableObject(formObj.wo_no, true);
        }
        //	        }
    }
}

/** mandatoryCheck
 *  cntr no  
 * @return
 */
function mandatoryCheck() {
    var sheetObj = sheetObjects[0];
    var err_flag = false;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'cntr_no').length == 0) {
            ComShowMessage('Please input CNTR No.');
            return false
        }
    }
}

/** validation Manual input
 * 
 * @return
 */
function validateManualInput() {
    var sheetObj = sheetObjects[0];
    var err_flag = false;
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (!(sheetObj.GetCellValue(i, 'wrk_dt').length == 8 || sheetObj.GetCellValue(i, 'wrk_dt').length == 0)) {
            sheetObj.SetCellFontColor(i, 'wrk_dt', "#FF0000");
            err_flag = true;
        }
        
        if (sheetObj.GetCellValue(i, 'wrk_dt').length == 8) {
            var year = sheetObj.GetCellValue(i, 'wrk_dt').substring(0, 4);
            var month = sheetObj.GetCellValue(i, 'wrk_dt').substring(4, 6);
            var day = sheetObj.GetCellValue(i, 'wrk_dt').substring(6, 8);
            if (ComParseInt(year) >= 1900 && ComIsMonth(month) && ComIsDay(year, month, day)) {
                sheetObj.SetCellFontColor(i, 'wrk_dt', "#000000");
            } else {
                sheetObj.SetCellFontColor(i, 'wrk_dt', "#FF0000");
                err_flag = true;
            }
        }
        
        // 2016-04-28 conventional container numbers 처리 관련으로 주석 처리
//        if (sheetObj.GetCellValue(i, 'cntr_no').length != 11) {
//            sheetObj.SetCellFontColor(i, 'cntr_no', "#FF0000");
//            err_flag = true;
//        }
//        
//        var cntr_char = sheetObj.GetCellValue(i, 'cntr_no').substring(0, 4);
//        var cntr_num = sheetObj.GetCellValue(i, 'cntr_no').substring(4, 11);
//        
//        if (ComIsContainsCharsOnly(cntr_char, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ') && ComIsNumber(cntr_num)) {
//            sheetObj.SetCellFontColor(i, 'cntr_no', "#000000");
//        } else {
//            sheetObj.SetCellFontColor(i, 'cntr_no', "#FF0000");
//            err_flag = true;
//        }
    }
    
    //no support[check again]CLT var Rows;
    Rows = sheetObj.ColValueDupRows("cntr_no");
    var arr_rows = Rows.split(',');
    
    for (var i = 0; arr_rows != '' && i < arr_rows.length; i++) {
        sheetObj.SetRowFontColor(arr_rows[i], "#FF0000");
        err_flag = true;
        sheetObj.SetCellValue(arr_rows[i], "remark", 'Duplicate');
    }
    
    if (err_flag == true) {
        ComShowMessage("Please check the column in red.");
        return false;
    }
}

//    /**
//     **/
//	 function checkExcelData(sheetObj){
//	 	//ComShowMessage(sheetObj.RowCount);
//	 	document.form.excel_chk.value="Y";
//	 	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
//	 		if(sheetObj.CellValue(i, "cntr_no").length != 11 || !ComIsAlphabet(sheetObj.CellValue(i, "cntr_no"))){
//	 			sheetObj.CellBackColor(i, "cntr_no") = "#FFFF66";
//	 			sheetObj.CellFontColor(i, "cntr_no") = "#FF0000";	
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "cntr_tpsz_cd").length != 2 || !ComIsAlphabet(sheetObj.CellValue(i, "cntr_tpsz_cd"))){
//	 			sheetObj.CellBackColor(i, "cntr_tpsz_cd") = "#FFFF66";
//	 			sheetObj.CellFontColor(i, "cntr_tpsz_cd") = "#FF0000";
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "cntr_sty_cd").length != 1 || !(sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "M"
//	 		                                                      || sheetObj.CellValue(i, "cntr_sty_cd").toUpperCase() == "F")){
//	 			sheetObj.CellBackColor(i, "cntr_sty_cd") = "#FFFF66"; 
//	 			sheetObj.CellFontColor(i, "cntr_sty_cd") = "#FF0000";
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(sheetObj.CellValue(i, "io_bnd_cd").length != 1 || !(sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() == "I"
//	 		                                                  ||sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() == "O")
//	 		                                                  ||sheetObj.CellValue(i, "io_bnd_cd").toUpperCase() != document.form.io_bnd_cd.value){
//	 			sheetObj.CellBackColor(i, "io_bnd_cd") = "#FFFF66";
//	 			sheetObj.CellFontColor(i, "io_bnd_cd") = "#FF0000";
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		if(!chk_Date(sheetObj.CellValue(i, "wrk_dt"))){
//	 			sheetObj.CellBackColor(i, "wrk_dt") = "#FFFF66";
//	 			sheetObj.CellFontColor(i, "wrk_dt") = "#FF0000";
//	 			document.form.excel_chk.value="N";
//	 		}
//	 		for(var j= i+1 ; j<sheetObj.HeaderRows + sheetObj.RowCount; j++){
//				if(sheetObj.CellValue(i, "cntr_no") == sheetObj.CellValue(j, "cntr_no")){
//		 			sheetObj.RowBackColor(i) = "#FFFF66";
//		 			sheetObj.RowFontColor(i) = "#FF0000";
//		 			sheetObj.RowBackColor(j) = "#FFFF66";
//		 			sheetObj.RowFontColor(j) = "#FF0000";
//	 				document.form.excel_chk.value="N";
//
//				}
//			}
//		}
//	}
//    function sheet_OnSearchEnd(sheetObj, ErrMsg){
//        var hidden_sheet = sheetObjects[1];
//        var queryStr = '';
//        var opr_sht_idx = 0;
//        var opener_sheet_obj;
//
//		if (sheetObj.RowCount > 0){
//			for (var i=sheetObj.HeaderRows; i<(sheetObj.HeaderRows + sheetObj.RowCount); i++){
//				sheetObj.RowStatus(i) = 'I';
//			}
//
//
//
//
//			queryStr = sheetObj.GetSaveString(false, false, 'co_flg');
//			if (queryStr==null || queryStr==''){
//				//return false;
//			} else {
//				opr_sht_idx = 0; //TO COINCIDENCE
//				opener_sheet_obj = window.dialogArguments.document.t1sheet1;
//				tes_copy_rows_to(opener_sheet_obj, queryStr, true);
//			}
//
//			opener_sheet_obj = window.dialogArguments.document.t2sheet1;
//			queryStr = sheetObj.GetSaveString(false, false, 'dc_flg');
//			if(queryStr==null || queryStr==''){
////				return false;
//			} else {
//				opr_sht_idx = 1; //TO DISCREPANCY
//				tes_copy_rows_to(opener_sheet_obj, queryStr, true);
//			}
////			opener_sheet_obj = window.dialogArguments.document.t2sheet1;
//
//			for(var i=opener_sheet_obj.HeaderRows; i<opener_sheet_obj.HeaderRows+opener_sheet_obj.RowCount; i++){
//    			if(opener_sheet_obj.CellValue(i,"dscr_dtl_ind_cd") == "I"){
//    				opener_sheet_obj.CellBackColor(i, "io_bnd_cd"	) = "#FFFF66";
//    				opener_sheet_obj.CellFontColor(i, "io_bnd_cd"	) = "#FF0000";
//    			}else if(opener_sheet_obj.CellValue(i,"dscr_dtl_ind_cd") == "F"){
//    				opener_sheet_obj.CellBackColor(i, "cntr_sty_cd") = "#FFFF66";
//    				opener_sheet_obj.CellFontColor(i, "cntr_sty_cd") = "#FF0000";
//    			}else if(opener_sheet_obj.CellValue(i,"dscr_dtl_ind_cd") == "T"){
//    				opener_sheet_obj.CellBackColor(i, "cntr_tpsz_cd") = "#FFFF66";
//    				opener_sheet_obj.CellFontColor(i, "cntr_tpsz_cd") = "#FF0000";
//    			}
//			}
//
//		    for(var i=hidden_sheet.HeaderRows; i<(hidden_sheet.HeaderRows+hidden_sheet.RowCount); i++){
//		        hidden_sheet.RowStatus(i) = 'I';
//		        if(sheetObj.FindText('cntr_no', hidden_sheet.CellValue(i,'cntr_no'))>0){
//		            hidden_sheet.CellValue(i,'dc_flg') = '';
//		        }
//		    }
//		    queryStr = hidden_sheet.GetSaveString(false,false,'dc_flg');
//		    if(queryStr == null || queryStr == ''){
//		        //return false;
//		    }else{
//		        tes_copy_rows_to(opener_sheet_obj, queryStr, true);
//		    }
//			window.focus();
//			var count = parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount);
//			ComShowMessage(count+ComGetMsg('TES40043')); //ComShowMessage((parseInt(window.dialogArguments.document.t1sheet1.RowCount) + parseInt(window.dialogArguments.document.t2sheet1.RowCount))+ '건의 List가 verify완료되었습니다.');
//			window.close();
//		}
//	}
//    function formValue2Sheet(sheetObj){
//        for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
//            sheetObj.CellValue(i, "vvd"  	)  =  document.form.vvd.value;
//            sheetObj.CellValue(i, "vndr_seq"	)  =  document.form.vndr_seq.value;
//            sheetObj.CellValue(i, "yd_cd"   	)  =  document.form.yd_cd.value;
//            sheetObj.CellValue(i, "rcv_dt"  	)  =  document.form.rcv_dt.value;
//        }
//    }
//	function copySheet(fromSheetObj,toSheetObj1,toSheetObj2){
//	    var openerFormObj = window.dialogArguments.document.form;
////		ComShowMessage(openerFormObj.laneComboItems.value);
//
//        toSheetObj1.RemoveAll(); // Coincidece Sheet
//        toSheetObj2.RemoveAll(); // Discrepancy Sheet
//        for(var i=fromSheetObj.HeaderRows ; i<fromSheetObj.HeaderRows + fromSheetObj.RowCount; i++){
//			if(fromSheetObj.CellValue(i, "dscr_ind_cd"  ) == "CO"){ // Coincidece
//				var Row = toSheetObj1.DataInsert(-1);
//				//ComShowMessage(Row);
//    		    toSheetObj1.CellComboItem(Row, 'lane_cd', openerFormObj.laneComboItems.value,  openerFormObj.laneComboItems.value);
//
//				toSheetObj1.CellValue(Row, "sts"  		  		)  = "I";
//				toSheetObj1.CellValue(Row, "vvd"  		  	)  = fromSheetObj.CellValue(i, "vvd");
//				toSheetObj1.CellValue(Row, "vndr_seq"		  	)  = fromSheetObj.CellValue(i, "vndr_seq");
//				toSheetObj1.CellValue(Row, "cntr_no"      		)  = fromSheetObj.CellValue(i, "cntr_no");
//				toSheetObj1.CellValue(Row, "cntr_tpsz_cd" 		)  = fromSheetObj.CellValue(i, "cntr_tpsz_cd");
//				toSheetObj1.CellValue(Row, "cntr_sty_cd"		)  = fromSheetObj.CellValue(i, "cntr_sty_cd");
//				toSheetObj1.CellValue(Row, "locl_ts_ind_cd"     )  = fromSheetObj.CellValue(i, "locl_ts_ind_cd");
//				toSheetObj1.CellValue(Row, "io_bnd_cd" 		    )  = fromSheetObj.CellValue(i, "io_bnd_cd");
//				toSheetObj1.CellValue(Row, "ioc_cd" 		    )  = fromSheetObj.CellValue(i, "ioc_cd");
//				toSheetObj1.CellValue(Row, "lane_cd" 	      	)  = fromSheetObj.CellValue(i, "lane_cd");
//				toSheetObj1.CellValue(Row, "rcvde_term_ind_cd"  )  = fromSheetObj.CellValue(i, "rcvde_term_ind_cd");
//				toSheetObj1.CellValue(Row, "pre_yd_cd"     		)  = fromSheetObj.CellValue(i, "pre_yd_cd");
//				toSheetObj1.CellValue(Row, "same_ts"     		)  = fromSheetObj.CellValue(i, "same_ts");
//				toSheetObj1.CellValue(Row, "wrk_dt"     		)  = fromSheetObj.CellValue(i, "wrk_dt");
//				toSheetObj1.CellValue(Row, "dcgo_clss_cd" 		)  = fromSheetObj.CellValue(i, "dcgo_clss_cd");
//				toSheetObj1.CellValue(Row, "bkg_no" 		  	)  = fromSheetObj.CellValue(i, "bkg_no");
//				toSheetObj1.CellValue(Row, "bkg_no_split" 		)  = fromSheetObj.CellValue(i, "bkg_no_split");
//
//				toSheetObj1.CellValue(Row, "tml_so_ofc_cty_cd" 	)  = document.form.tml_so_ofc_cty_cd.value;
//				toSheetObj1.CellValue(Row, "tml_so_seq"        	)  = document.form.tml_so_seq.value;
//				toSheetObj1.CellValue(Row, "vrfy_rslt_ind_cd"   )  = "CO";
//				//toSheetObj1.CellValue(Row, "dscr_ind_cd"   	)  = "CO";
//
//
//				toSheetObj1.CellValue(Row, "vsl_cd"				)  = fromSheetObj.CellValue(i, "vvd").substring(0,4);
//				toSheetObj1.CellValue(Row, "skd_voy_no"			)  = fromSheetObj.CellValue(i, "vvd").substring(4,8);
//				toSheetObj1.CellValue(Row, "skd_dir_cd"			)  = fromSheetObj.CellValue(i, "vvd").substring(8,9);
//				toSheetObj1.CellValue(Row, "dscr_ind_nm"     	)  = fromSheetObj.CellValue(i, "dscr_ind_nm");
//				toSheetObj1.CellValue(Row, "dscr_dtl_ind_cd"    )  = fromSheetObj.CellValue(i, "dscr_dtl_ind_cd");
//				toSheetObj1.CellValue(Row, "bb_cgo_flg"         )  = fromSheetObj.CellValue(i, "bb_cgo_flg");
//				toSheetObj1.CellValue(Row, "awk_cgo_flg"        )  = fromSheetObj.CellValue(i, "awk_cgo_flg");
//				toSheetObj1.CellValue(Row, "rc_flg"       		)  = fromSheetObj.CellValue(i, "rc_flg");
//
//				if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "I"){
//					toSheetObj1.CellBackColor(Row, "io_bnd_cd") = "#FFFF66";
//					toSheetObj1.CellFontColor(Row, "io_bnd_cd") = "#FF0000";
//				}else if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "F"){
//					toSheetObj1.CellBackColor(Row, "cntr_sty_cd") = "#FFFF66";
//					toSheetObj1.CellFontColor(Row, "cntr_sty_cd") = "#FF0000";
//				}else if(toSheetObj1.CellValue(Row,"dscr_dtl_ind_cd") == "T"){
//					toSheetObj1.CellBackColor(Row, "cntr_tpsz_cd") = "#FFFF66";
//					toSheetObj1.CellFontColor(Row, "cntr_tpsz_cd") = "#FF0000";
//				}
//
//			}else{		// Discrepancy
//				var Row2 = toSheetObj2.DataInsert(-1);
//				//ComShowMessage(Row);
//
//    		toSheetObj2.CellComboItem(Row2, 'lane_cd', openerFormObj.laneComboItems.value,  openerFormObj.laneComboItems.value);
//
//				toSheetObj2.CellValue(Row2, "sts"  		  		)  = "I";
//				toSheetObj2.CellValue(Row2, "vvd"  		  	)  = fromSheetObj.CellValue(i, "vvd");
//				toSheetObj2.CellValue(Row2, "vndr_seq"		  	)  = fromSheetObj.CellValue(i, "vndr_seq");
//				toSheetObj2.CellValue(Row2, "cntr_no"      		)  = fromSheetObj.CellValue(i, "cntr_no");
//				toSheetObj2.CellValue(Row2, "cntr_tpsz_cd" 		)  = fromSheetObj.CellValue(i, "cntr_tpsz_cd");
//				toSheetObj2.CellValue(Row2, "cntr_sty_cd"		)  = fromSheetObj.CellValue(i, "cntr_sty_cd");
//				toSheetObj2.CellValue(Row2, "locl_ts_ind_cd"    )  = fromSheetObj.CellValue(i, "locl_ts_ind_cd");
//				toSheetObj2.CellValue(Row2, "io_bnd_cd" 		)  = fromSheetObj.CellValue(i, "io_bnd_cd");
//				toSheetObj2.CellValue(Row2, "ioc_cd" 		    )  = fromSheetObj.CellValue(i, "ioc_cd");
//				toSheetObj2.CellValue(Row2, "lane_cd" 	      	)  = fromSheetObj.CellValue(i, "lane_cd");
//				toSheetObj2.CellValue(Row2, "rcvde_term_ind_cd" )  = fromSheetObj.CellValue(i, "rcvde_term_ind_cd");
//				toSheetObj2.CellValue(Row2, "pre_yd_cd"     	)  = fromSheetObj.CellValue(i, "pre_yd_cd");
//				toSheetObj2.CellValue(Row2, "same_ts"     		)  = fromSheetObj.CellValue(i, "same_ts");
//				toSheetObj2.CellValue(Row2, "wrk_dt"     		)  = fromSheetObj.CellValue(i, "wrk_dt");
//				toSheetObj2.CellValue(Row2, "dcgo_clss_cd"   	)  = fromSheetObj.CellValue(i, "dcgo_clss_cd");
//				toSheetObj2.CellValue(Row2, "bkg_no" 		  	)  = fromSheetObj.CellValue(i, "bkg_no");
//				toSheetObj2.CellValue(Row2, "bkg_no_split" 		)  = fromSheetObj.CellValue(i, "bkg_no_split");
//
//				toSheetObj2.CellValue(Row2, "tml_so_ofc_cty_cd"	)  = document.form.tml_so_ofc_cty_cd.value;
//				toSheetObj2.CellValue(Row2, "tml_so_seq"       	)  = document.form.tml_so_seq				.value;
//				toSheetObj2.CellValue(Row2, "vrfy_rslt_ind_cd"  )  = "DC";
//
//				toSheetObj2.CellValue(Row2, "dscr_ind_cd"   	)  = fromSheetObj.CellValue(i, "dscr_ind_cd");
//				toSheetObj2.CellValue(Row2, "vsl_cd"			)  = fromSheetObj.CellValue(i, "vvd"  	     ).substring(0,4);
//				toSheetObj2.CellValue(Row2, "skd_voy_no"		)  = fromSheetObj.CellValue(i, "vvd"  	   	 ).substring(4,8);
//				toSheetObj2.CellValue(Row2, "skd_dir_cd"		)  = fromSheetObj.CellValue(i, "vvd"  	   	 ).substring(8,9);
//				toSheetObj2.CellValue(Row2, "dscr_ind_nm"     	)  = fromSheetObj.CellValue(i, "dscr_ind_nm");
//				toSheetObj2.CellValue(Row2, "dscr_dtl_ind_cd"   )  = fromSheetObj.CellValue(i, "dscr_dtl_ind_cd");
//				toSheetObj2.CellValue(Row2, "bb_cgo_flg"        )  = fromSheetObj.CellValue(i, "bb_cgo_flg");
//				toSheetObj2.CellValue(Row2, "awk_cgo_flg"       )  = fromSheetObj.CellValue(i, "awk_cgo_flg");
//				toSheetObj2.CellValue(Row2, "rc_flg"       		)  = fromSheetObj.CellValue(i, "rc_flg");
//
//				if(toSheetObj2.CellValue(Row2,"dscr_dtl_ind_cd") == "I"){
//					toSheetObj2.CellBackColor(Row2, "io_bnd_cd"	) = "#FFFF66";
//					toSheetObj2.CellFontColor(Row2, "io_bnd_cd"	) = "#FF0000";
//				}else if(toSheetObj2.CellValue(Row2,"dscr_dtl_ind_cd") == "F"){
//					toSheetObj2.CellBackColor(Row2, "cntr_sty_cd") = "#FFFF66";
//					toSheetObj2.CellFontColor(Row2, "cntr_sty_cd") = "#FF0000";
//				}else if(toSheetObj2.CellValue(Row2,"dscr_dtl_ind_cd") == "T"){
//					toSheetObj2.CellBackColor(Row2, "cntr_tpsz_cd") = "#FFFF66";
//					toSheetObj2.CellFontColor(Row2, "cntr_tpsz_cd") = "#FF0000";
//				}
//
//			}
//		}
//
//		toSheetObj1.CountFormat = "[SELECTDATAROW / ROWCOUNT]";
//		toSheetObj2.CountFormat = "[SELECTDATAROW / ROWCOUNT]";
//		openerFormObj.cost_calc_mode.value = "N";
//
//		sumaryByItem2OpenerForm(fromSheetObj);
//	}
//   /**
//     * handling process for input validation
//     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
////            if (!isNumber(iPage)) {
////
////                return false;
////            }
//        }
//
//        return true;
//    }
//    function sumaryByItem2OpenerForm(sheetObject){
//        var openerFormObj = window.dialogArguments.document.form;
//
//		var cntTot		 = 0;
//		var cntSizeD2  = 0;  				var cntSizeO2  = 0;
//		var cntSizeD4  = 0;         var cntSizeO4  = 0;
//		var cntSizeD5  = 0;         var cntSizeS2  = 0;
//		var cntSizeD7  = 0;         var cntSizeS4  = 0;
//		var cntSizeD8  = 0;         var cntSizeT2  = 0;
//		var cntSizeD9  = 0;         var cntSizeT4  = 0;
//		var cntSizeDW  = 0;         var cntSizeA2  = 0;
//		var cntSizeDX  = 0;         var cntSizeA4  = 0;
//		var cntSizeR2  = 0;         var cntSizeP2  = 0;
//		var cntSizeR4  = 0;         var cntSizeP4  = 0;
//		var cntSizeR5  = 0;         var cntSizeZ2  = 0;
//		var cntSizeF2  = 0;         var cntSizeZ4  = 0;
//		var cntSizeF4  = 0;
//		var cntFull		 = 0;					var cntEmpty   = 0;
//		var cntTs			 = 0;					var cntSameTs	 = 0;
//    	for(var i=sheetObject.HeaderRows ; i<sheetObject.HeaderRows + sheetObject.RowCount; i++){
//			if(sheetObject.CellValue(i, "dscr_ind_cd"  ) == "CO"){
//			    cntTot++;
//				if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D2") 	   cntSizeD2++;
//				else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D4") cntSizeD4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D5") cntSizeD5++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D7") cntSizeD7++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D8") cntSizeD8++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "D9") cntSizeD9++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DW") cntSizeDW++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "DX") cntSizeDX++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R2") cntSizeR2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R4") cntSizeR4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "R5") cntSizeR5++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F2") cntSizeF2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "F4") cntSizeF4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O2") cntSizeO2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "O4") cntSizeO4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S2") cntSizeS2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "S4") cntSizeS4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T2") cntSizeT2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "T4") cntSizeT4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A2") cntSizeA2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "A4") cntSizeA4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P2") cntSizeP2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "P4") cntSizeP4++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z2") cntSizeZ2++;
//                else if(sheetObject.CellValue(i, "cntr_tpsz_cd" ) == "Z4") cntSizeZ4++;
//
//                if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "F") 	   cntFull++;
//                else if(sheetObject.CellValue(i, "cntr_sty_cd" ) == "M")   cntEmpty++;
//
//                if(sheetObject.CellValue(i, "locl_ts_ind_cd" 	) == "T")  cntTs++;
//                if(sheetObject.CellValue(i, "same_ts" ) == "T")            cntSameTs++;
//            }
//        }
//		openerFormObj.size_d2				.value = 	addComma(cntSizeD2);
//		openerFormObj.size_d4       .value =  addComma(cntSizeD4);
//		openerFormObj.size_d5       .value =  addComma(cntSizeD5);
//		openerFormObj.size_d7       .value =  addComma(cntSizeD7);
//		openerFormObj.size_d8       .value =  addComma(cntSizeD8);
//		openerFormObj.size_d9       .value =  addComma(cntSizeD9);
//		openerFormObj.size_dw       .value =  addComma(cntSizeDW);
//		openerFormObj.size_dx       .value =  addComma(cntSizeDX);
//		openerFormObj.size_r2       .value =  addComma(cntSizeR2);
//		openerFormObj.size_r4       .value =  addComma(cntSizeR4);
//		openerFormObj.size_r5       .value =  addComma(cntSizeR5);
//		openerFormObj.size_f2       .value =  addComma(cntSizeF2);
//		openerFormObj.size_f4       .value =  addComma(cntSizeF4);
//		openerFormObj.size_o2       .value =  addComma(cntSizeO2);
//		openerFormObj.size_o4       .value =  addComma(cntSizeO4);
//		openerFormObj.size_s2       .value =  addComma(cntSizeS2);
//		openerFormObj.size_s4       .value =  addComma(cntSizeS4);
//		openerFormObj.size_t2       .value =  addComma(cntSizeT2);
//		openerFormObj.size_t4       .value =  addComma(cntSizeT4);
//		openerFormObj.size_a2       .value =  addComma(cntSizeA2);
//		openerFormObj.size_a4       .value =  addComma(cntSizeA4);
//		openerFormObj.size_p2       .value =  addComma(cntSizeP2);
//		openerFormObj.size_p4       .value =  addComma(cntSizeP4);
//		openerFormObj.size_z2       .value =  addComma(cntSizeZ2);
//		openerFormObj.size_z4       .value =  addComma(cntSizeZ4);
//
//		openerFormObj.container_tot .value =  addComma(cntTot);
//		openerFormObj.full          .value =  addComma(cntFull);
//		openerFormObj.empty         .value =  addComma(cntEmpty);
//		openerFormObj.same_ts       .value =  addComma(cntTs);
//		//openerFormObj.bkg_ts        .value =  addComma(cntTs);
//		//openerFormObj.same_ts       .value =  addComma(cntSameTs);
//    }
//	function deleteComma(src){
//		var src = String(src);
//		if (src==null || trim(src)==''){
//			return '';
//		}
//		return src.replace(/,/gi,'');
//	}
//	function addComma(src){
//		var src = String(src);
//		if (src==null || trim(src)==''){
//			return '';
//		}
//		var re = /(-?\d+)(\d{3})/;
//		while (re.test(src)) {
//			src = src.replace(re, "$1,$2");
//		}
//		return  src;
//	}