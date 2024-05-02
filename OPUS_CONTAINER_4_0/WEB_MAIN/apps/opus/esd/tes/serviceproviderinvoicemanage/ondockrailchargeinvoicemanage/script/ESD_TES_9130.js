/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9130.js
*@FileTitle  : On-dock Rail Charge Invoice Save & Confirm - Coincidence 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObject = sheetObjects[0];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_loadexcel":
                //ComShowMessage("btn_loadexcel button click");
                formObject.excel_chk.value = "";
                doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
                break;
                
            case "btn_verify":
                //ComShowMessage("btn_verify button click");
                verifyContainerList();

                if (formObject.excel_chk.value == "N") {
                    ComShowMessage(ComGetMsg('TES22601'));
                    return false;
                }

                if (formObject.verify_chk.value == null || formObject.verify_chk.value == "" || formObject.verify_chk.value != "Y") {
                    ComShowMessage(ComGetMsg('TES22602'));
                    return false;
                }
                break;
                
            case "btn_rowdel":
                var selectedRow = sheetObject.GetSelectionRows('|').split('|');
                for (var i = selectedRow.length - 1; i >= 0; i--) {
                    sheetObject.RowDelete(selectedRow[i], false);
                }
                break;
                
            case "btn_ok":
                //ComShowMessage("btn_ok button click");
                break;
                
            case "btn_close":
                ComClosePopup();
                break;
                
            case "btn_sampleExecl":
                location.href = "apps/opus/esd/tes/serviceproviderinvoicemanage/ondockrailchargeinvoicemanage/jsp/ESD_TES_9130DL.jsp";
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
    var opener = window.opener; //dialogArguments;
    if (!opener) var opener = parent;
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initValue(opener.document.form, document.form);
}

function initValue(openerObj, formObj) {
    formObj.vndr_seq.value = openerObj.vndr_seq.value;
    formObj.yd_cd.value = openerObj.yd_cd.value;
    formObj.rcv_dt.value = openerObj.rcv_dt.value;
    formObj.tml_so_ofc_cty_cd.value = openerObj.tml_so_ofc_cty_cd.value;
    formObj.tml_so_seq.value = openerObj.tml_so_seq.value;
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){			
				var HeadTitle=" Sts|Seq.|CNTR No.|Type/Size|F/M|Working Date|";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				resizeSheet();//SetSheetHeight(240);
			}		
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBLOADEXCEL: //Retrieve
            sheetObj.RemoveAll();
            sheetObj.LoadExcel({ Mode: "HeaderMatch" });
            break;
            
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            var param = sheetObj.GetSaveString(false, false);
            var saveXml = sheetObj.GetSearchData("ESD_TES_9130GS.do", param + '&' + tesFrmQryStr(formObj));
            sheetObj.RemoveAll();
            if (saveXml != "") sheetObj.LoadSaveData(saveXml, true);
            break;
            
        case SEARCH01: //Retrieve CNTR TYPE CD List 				
            formObj.f_cmd.value = SEARCH01;
            var param = sheetObj.GetSaveString(true, false);
            var sXml = sheetObj.GetSearchData("ESD_TES_9130GS.do", param + '&' + tesFrmQryStr(formObj), "", true);

            sheetObj.RemoveAll();
            sheetObj.LoadSearchData(sXml, { Append: 1, Sync: 1 });
            break;            
    }
}

function sheet_OnLoadExcel(sheetObj, result, code, msg) {
    if (isExceedMaxRow(msg)) return;

    if (sheetObj.RowCount() > 0) {
        doActionIBSheet(sheetObj, document.form, SEARCH01);
    }

    document.form.excel_chk.value = "Y";
    for (var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
    	
    	// 2016-04-28 conventional container numbers 처리 관련으로 주석 처리
//        if (sheetObj.GetCellValue(i, "cntr_no").length != 11 || !ComIsAlphabet(sheetObj.GetCellValue(i, "cntr_no"), "n")) {
//            sheetObj.SetCellBackColor(i, "cntr_no", "#FFFF66");
//            sheetObj.SetCellFontColor(i, "cntr_no", "#FF0000");
//            document.form.excel_chk.value = "N";
//        }
        
        if (sheetObj.GetCellValue(i, "cntr_sty_cd").length != 1 || !(sheetObj.GetCellValue(i, "cntr_sty_cd").toUpperCase() == "M" || sheetObj.GetCellValue(i, "cntr_sty_cd").toUpperCase() == "F")) {
            sheetObj.SetCellBackColor(i, "cntr_sty_cd", "#FFFF66");
            sheetObj.SetCellFontColor(i, "cntr_sty_cd", "#FF0000");
            document.form.excel_chk.value = "N";
        }

        // 			if(!ComIsDate(sheetObj.GetCellValue(i, "wrk_dt"))){
        //	 			sheetObj.SetCellBackColor(i, "wrk_dt","#FFFF66");
        // 	 			sheetObj.SetCellFontColor(i, "wrk_dt","#FF0000");
        //	 			document.form.excel_chk.value="N";
        //	 		}

        if (document.form.wrk_dt.value != null && document.form.wrk_dt.value != "") {
            sheetObj.SetCellValue(i, "wrk_dt", document.form.wrk_dt.value);
        }

        //	 		if(sheetObj.GetCellValue(i, "cntr_tpsz_cd")==""){
        //	        	document.form.cntr_no.value = sheetObj.GetCellValue(i, "cntr_no");
        //	        	document.form.row.value = i;
        //	        	
        //	        	 tes_getInputValue('tmp_cntr_tpsz_cd', SEARCH23, 'cntr_no|row', 'searchCntrTPSZ');
        //	 		}

    }

    var Rows = sheetObj.ColValueDupRows("cntr_no|cntr_sty_cd");

    if (Rows != '') {
        var arr_rows = Rows.split(',');
        for (var i = 0;
            (arr_rows != null || arr_row.trim() != '') && i < arr_rows.length; i++) {
            sheetObj.SetRowFontColor(arr_rows[i], "#FF0000");
            document.form.excel_chk.value = "N";
        }
    }
}

function searchCntrTPSZ(row) {
    sheetObjects[0].SetCellValue(row, "cntr_tpsz_cd", document.form.tmp_cntr_tpsz_cd.value);
}

function sheet_OnSaveEnd(sheetObj) {
    //		window.opener.fileImp();//window.dialogArguments.fileImp();
    var opener_obj;
    opener_obj = window.dialogArguments;
    if (!opener_obj) opener_obj = window.opener; //이 코드 추가할것
    if (!opener_obj) opener_obj = parent; //이 코드 추가할것

    opener_obj.fileImp();
    var count = parseInt(opener_obj.t1sheet1.RowCount()) + parseInt(opener_obj.t2sheet1.RowCount());
    ComShowMessage(count + ComGetMsg('TES40043')); //ComShowMessage((parseInt(opener_obj.document.t1sheet1.RowCount()) + parseInt(opener_obj.document.t2sheet1.RowCount()))+ '건의 List가 verify완료되었습니다.');
    ComClosePopup();
}

function verifyContainerList() {
    var formObj = document.form;
    //ComShowMessage("verifyContainerList");
    if (sheetObjects[0].RowCount() < 1) {
        ComShowMessage(ComGetMsg('TES40017'));
        return false;
    }

    document.form.excel_chk.value = "Y";
    for (var i = sheetObjects[0].HeaderRows(); i < (sheetObjects[0].HeaderRows() + sheetObjects[0].RowCount()); i++) {
    
    	// 2016-04-28 conventional container numbers 처리 관련으로 주석 처리
//        if (sheetObjects[0].GetCellValue(i, "cntr_no").length != 11 || !ComIsAlphabet(sheetObjects[0].GetCellValue(i, "cntr_no"), "n")) {
//            sheetObjects[0].SetCellBackColor(i, "cntr_no", "#FFFF66");
//            sheetObjects[0].SetCellFontColor(i, "cntr_no", "#FF0000");
//            document.form.excel_chk.value = "N";
//        }
        
        if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd").length != 1 || !(sheetObjects[0].GetCellValue(i, "cntr_sty_cd").toUpperCase() == "M" || sheetObjects[0].GetCellValue(i, "cntr_sty_cd").toUpperCase() == "F")) {
            sheetObjects[0].SetCellBackColor(i, "cntr_sty_cd", "#FFFF66");
            sheetObjects[0].SetCellFontColor(i, "cntr_sty_cd", "#FF0000");
            document.form.excel_chk.value = "N";
        }

    }

    var Rows = sheetObjects[0].ColValueDupRows("cntr_no|cntr_sty_cd");
    if (Rows != '') {
        var arr_rows = Rows.split(',');
        for (var i = 0;
            (arr_rows != null || arr_row.trim() != '') && i < arr_rows.length; i++) {
            sheetObjects[0].SetRowFontColor(arr_rows[i], "#FF0000");
            document.form.excel_chk.value = "N";
        }
    }

    if (formObj.excel_chk.value == "N") {
        ComShowMessage(ComGetMsg('TES22601'));
        return false;
    }
    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    formObj.verify_chk.value = "Y";
}