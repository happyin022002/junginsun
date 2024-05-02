/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9160.js
*@FileTitle  : Agreement Terminal Rate List Excel Load
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var sheetErrCount = 0;
var gap_tm = 3;
var strErrLine = "";

/** Event handler processing by button click event */
document.onclick = processButtonClick;

/** Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    /*******************************************************/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_loadexcel":
                doActionIBSheet(sheetObject, formObject, IBLOADEXCEL);
                break;

            case "btn_verify":
                var k = sheetObjects[0].RowCount();
                var err_count = 0;
                var dupRowCount = 0;
                var errRow = "";
                
                if (k == 0) {
                    ComShowCodeMessage('TES10087');
                    return false;
                }

                for (var j = 0; j < sheetObjects[0].RowCount() + 3; j++) {
                    // 69 column
                    for (var jj = 0; jj < 69; jj++) {
                        sheetObjects[0].SetCellBackColor(j, jj, "");
                    }
                }
                strErrLine = "";

                var dupRowInfo = sheetObjects[0].ColValueDupRows("1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33", false, true);
                if (dupRowInfo != "") {
                    var dupRow = dupRowInfo.split("|");
                    var dupRowNum = dupRow[1].split(",");
                    if (dupRowNum.length > 0) {
                        for (var i = 0; i < dupRowNum.length; i++) {
                            if (sheetObjects[0].GetCellValue(dupRowNum[i], "3auto_calc_flg") == "Y") {
                                sheetObjects[0].SetRowBackColor(dupRowNum[i], "#FF0000");
                                dupRowCount++;
                                errLineAdd(dupRowNum[i]);
                            }
                        }
                        if (dupRowCount > 0) {
                            alert("Dup Err Line : " + strErrLine + "\nThere are " + dupRowCount + " duplicate rows total.");
                            //								ComShowCodeMessage('TES10119',dupRowCount);
                            return false;
                        }
                    }
                }

                doActionIBSheet1(sheetObject1, formObject, IBSEARCH);
                
                if (sheetErrCount == 0) {
                    for (var i = 1; i <= k; i++) {
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, '3lgs_cost_cd'))) {
                            sheetObjects[0].SetCellBackColor(i + 2, '3lgs_cost_cd', "#FF0000");
                            err_count++;
                            
                            if(errRow == ""){
                            	errRow = i;
                            } else {
                            	errRow += ", " + i;
                            }
                            
                        } else {
                            //sheetObjects[0].SetCellBackColor(i+2,'3lgs_cost_cd',"#000000");
                            sheetObjects[0].SetCellBackColor(i + 2, '3lgs_cost_cd', "");
                        }
                        
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, '3auto_calc_flg'))) {
                            sheetObjects[0].SetCellBackColor(i + 2, '3auto_calc_flg', "#FF0000");
                            err_count++;
                            if(errRow == ""){
                            	errRow = i;
                            } else {
                            	errRow += ", " + i;
                            }
                        }
                        
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, '3tml_agmt_vol_ut_cd'))) {
                            sheetObjects[0].SetCellBackColor(i + 2, '3tml_agmt_vol_ut_cd', "#FF0000");
                            err_count++;
                            if(errRow == ""){
                            	errRow = i;
                            } else {
                            	errRow += ", " + i;
                            }
                        }
                        
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, '3curr_cd'))) {
                            sheetObjects[0].SetCellBackColor(i + 2, '3curr_cd', "#FF0000");
                            err_count++;
                            if(errRow == ""){
                            	errRow = i;
                            } else {
                            	errRow += ", " + i;
                            }
                        }
                    }
                }
				
                if (sheetErrCount > 0 || err_count > 0) {
                    if (strErrLine != "") {
                        alert("Err Line : " + strErrLine + "\nPlease modify sheet.");
                        
                    } else if (err_count > 0) {
                        alert("Err Line : " + errRow + "\nPlease modify sheet.");
                    }

                    //						ComShowCodeMessage('TES10088');
                    sheetErrCount = 0;
                    return false;
                } else if (sheetErrCount == 0 && err_count == 0) {
                    var opener_sheet_obj = window.opener.t2sheet1;
                    var appendFlg = "";
                    if (opener_sheet_obj.RowCount() == 0) {
                        ComShowCodeMessage('TES10089');
                        appendFlg = true;
                    } else if (opener_sheet_obj.RowCount() > 0) {
                        appendFlg = ComShowConfirm(ComGetMsg('TES10120'));
                    }
                    
                    for (var i = 0; i < sheetObjects[0].RowCount(); i++) {
                        if (sheetObjects[0].GetCellValue(i + 3, "3io_bnd_cd").toUpperCase().trim() == "IB" || sheetObjects[0].GetCellValue(i + 3, "3io_bnd_cd").toUpperCase().trim() == "OB" || sheetObjects[0].GetCellValue(i + 3, "3io_bnd_cd").toUpperCase().trim() == "SAME") {
                            sheetObjects[0].SetCellValue(i + 3, "3io_bnd_cd", sheetObjects[0].GetCellValue(i + 3, "3io_bnd_cd").toUpperCase());
                            if (sheetObjects[0].GetCellValue(i + 3, "3io_bnd_cd").toUpperCase().trim() == "IB") {
                                sheetObjects[0].SetCellValue(i + 3, "3io_bnd_cd", "I");
                            } else if (sheetObjects[0].GetCellValue(i + 3, "3io_bnd_cd").toUpperCase().trim() == "OB") {
                                sheetObjects[0].SetCellValue(i + 3, "3io_bnd_cd", "O");
                            } else if (sheetObjects[0].GetCellValue(i + 3, "3io_bnd_cd").toUpperCase().trim() == "SAME") {
                                sheetObjects[0].SetCellValue(i + 3, "3io_bnd_cd", "S");
                            }
                        } else {
                            sheetObjects[0].SetCellValue(i + 3, "3io_bnd_cd", "");
                        }
                        
                        if (sheetObjects[0].GetCellValue(i + 3, "3ioc_cd").toUpperCase().trim() == "IPC" || sheetObjects[0].GetCellValue(i + 3, "3ioc_cd").toUpperCase().trim() == "OCN" || sheetObjects[0].GetCellValue(i + 3, "3ioc_cd").toUpperCase().trim() == "SAME") {
                            sheetObjects[0].SetCellValue(i + 3, "3ioc_cd", sheetObjects[0].GetCellValue(i + 3, "3ioc_cd").toUpperCase());
                            if (sheetObjects[0].GetCellValue(i + 3, "3ioc_cd").toUpperCase().trim() == "IPC") {
                                sheetObjects[0].SetCellValue(i + 3, "3ioc_cd", "I");
                            } else if (sheetObjects[0].GetCellValue(i + 3, "3ioc_cd").toUpperCase().trim() == "OCN") {
                                sheetObjects[0].SetCellValue(i + 3, "3ioc_cd", "O");
                            } else if (sheetObjects[0].GetCellValue(i + 3, "3ioc_cd").toUpperCase().trim() == "SAME") {
                                sheetObjects[0].SetCellValue(i + 3, "3ioc_cd", "S");
                            }
                        } else {
                            sheetObjects[0].SetCellValue(i + 3, "3ioc_cd", "");
                        }
                        
                        if (sheetObjects[0].GetCellValue(i + 3, "3lane_cd").toUpperCase().trim() == "SAME") {
                            sheetObjects[0].SetCellValue(i + 3, "3lane_cd", "Sam");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "3lane_cd").toUpperCase().trim() == "OTH") {
                            sheetObjects[0].SetCellValue(i + 3, "3lane_cd", "OTH");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "3lane_cd").toUpperCase() != "") {
                            sheetObjects[0].SetCellValue(i + 3, "3lane_cd", sheetObjects[0].GetCellValue(i + 3, "3lane_cd").toUpperCase());
                        }
                        
                        if (sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase() == "SAME" || sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "S") {
                            sheetObjects[0].SetCellValue(i + 3, "3tml_trns_mod_cd", "S");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "TRUCK" || sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "T") {
                            sheetObjects[0].SetCellValue(i + 3, "3tml_trns_mod_cd", "T");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "RAIL" || sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "R") {
                            sheetObjects[0].SetCellValue(i + 3, "3tml_trns_mod_cd", "R");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "BARGE" || sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "B") {
                            sheetObjects[0].SetCellValue(i + 3, "3tml_trns_mod_cd", "B");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "FEEDER" || sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "F") {
                            sheetObjects[0].SetCellValue(i + 3, "3tml_trns_mod_cd", "F");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "MOTHER" || sheetObjects[0].GetCellValue(i + 3, "3tml_trns_mod_cd").toUpperCase().trim() == "V") {
                            sheetObjects[0].SetCellValue(i + 3, "3tml_trns_mod_cd", "V");
                        }
                    }
                    
                    //setDtaCurrSht2OprSht(sheetObjects[0], sheetObjects[2]);
                    if (appendFlg == true) {
                        setDtaCurrSht2OprSht1(sheetObjects[0], '');
                    } else if (appendFlg == false) {
                        opener_sheet_obj.RemoveAll();
                        setDtaCurrSht2OprSht1(sheetObjects[0], '');
                    }
                    
                    ComClosePopup();
                    sheetErrCount = 0;
                }
                break;

            case "btn_close":
                ComClosePopup();
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21025');
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * registering IBSheet Object as list.<br>
 * adding process for list in case of needing batch processing with other items.<br>
 * defining list on the top of source.<br>
 * @param{ibsheet}	sheet_obj	Sheet Object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet.<br>
 * implementing onLoad event handler in body tag.<br>
 * adding first-served functions after loading screen..<br>
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}

/**
 * setting sheet initial values and header.<br>
 * param : sheetObj ==> , sheetNo ==>  .<br>
 * adding case as numbers of counting sheets.<br>
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{int,String}	sheetNo		Sheet No
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
    switch(sheetNo) {
         case 1:      //sheet1 init
            with (sheetObj) {
        	 	if (!opener) opener=window.dialogArguments;
        	 	if (!opener) opener=window.opener;
             	if (!opener) opener=parent;
                 var sheetNo=3;
                 var HeadTitle0="Seq|Cost Code|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|F/M|I/O|IPC/\nOcean|Mode|"
                 + "Applied Date|Applied Date|Applied Date|Applied Date|Lane|Sub Trade|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|"
                 + "Tier Vol.|Tier Vol.|OT\nShift|THC|"
                 + "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
                 + "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
                 + "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
                 + "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
                 + "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
                 + "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Verify\nResult|Remark|||||||";
                 var HeadTitle1="Seq|Cost Code|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|F/M|I/O|IPC/\nOcean|Mode|"
                 + "WD|Sat|Sun|H/D|Lane|Sub Trade|None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
                 + "Fr|To|OT\nShift|THC|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Verify\nResult|Remark|||||||";
                 var HeadTitle2="Seq|Cost Code|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|F/M|I/O|IPC/\nOcean|Mode|"
                 + "WD|Sat|Sun|H/D|Lane|Sub Trade|None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
                 + "Fr|To|OT\nShift|THC|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Verify\nResult|Remark|||||||";

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1,  ComboMaxHeight:120 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle0, Align:"Center"},
                             { Text:HeadTitle1, Align:"Center"},
                             { Text:HeadTitle2, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [{Type:"Seq",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
                        {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                        {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"auto_calc_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_vol_ut_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"thrp_lgs_cost_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       
                        {Type:"Combo",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_cntr_sty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"io_bnd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ioc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_trns_mod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"wkdy_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                       
                        {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sat_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sun_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"hol_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lane_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
                        {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        
                        {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dg_none",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_none",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sep_dg_none",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n1st_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n2nd_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n3rd_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n4th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n5th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n6th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n7th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n8th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n9th_clss_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fm_tr_vol_val",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_tr_vol_val",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_ovt_shft_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
                        {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"thc_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d5",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d7",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d8",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d9",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dw",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dx",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r5",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r7",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f5",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p2",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p4",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"teu_rate",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"box_rate",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"move_rate",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gang_hour_rate",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        
                        {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tonne_rate",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"verify_result",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"agmt_dtl_rmk",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_dy_aply_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_aply_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },

                        {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_vol_aply_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ts_rt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_dtl_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vrfyflg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" } ];
                  
                 InitColumns(cols);

                 SetEditable(1);
                 SetRangeBackColor(1, 10, 1, 13,"#555555");//
                 SetRangeBackColor(1, 16, 1, 31,"#555555");//
                 SetRangeBackColor(2, 16, 2, 31,"#555555");//
                 SetRangeBackColor(1, 26, 1, 57,"#555555");//
                 SetColProperty(sheetNo+"lgs_cost_cd", {ComboText:opener.lgsCostCDSheet, ComboCode:opener.lgsCostCDSheet} );
                 SetColProperty(sheetNo+"auto_calc_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
                 SetColProperty(sheetNo+"tml_agmt_vol_ut_cd", {ComboText:vol_ut_cdCode, ComboCode:vol_ut_cdCode} );
                 
                 SetColProperty(sheetNo+"tml_cntr_sty_cd", {ComboText:"|Same|Full|Empty", ComboCode:"|S|F|M"} );//20150406
                 
                 var arrSubTrdTxt = document.form.sub_trd_txt.value.split("|");
                 var arrSubTrdCd = document.form.sub_trd_cd.value.split("|");
                 var subTrdTxt = "";
                 
                 for(var ii=1; ii<arrSubTrdTxt.length; ii++){
                	 subTrdTxt = subTrdTxt + "|" + arrSubTrdCd[ii] + "\t" + arrSubTrdTxt[ii];
                 }
                 
                 SetColProperty(sheetNo+"sub_trd_cd", {ComboText:"|Same\tSame|OTH\tOTH"+subTrdTxt, ComboCode:"|S|O"+document.form.sub_trd_cd.value} );//20150406
                 
                 SetColProperty(sheetNo+"thc_tp_cd", {ComboText:" |GIO|LIFT|BOTH", ComboCode:thc_tp_codeCode} );
                 SetColProperty(sheetNo+"wkdy_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"sat_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"sun_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"hol_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dg_none", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"same_dg_none", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"same_dg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"sep_dg_none", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n1st_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n2nd_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n3rd_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n4th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n5th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n6th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n7th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n7th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n8th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetColProperty(sheetNo+"dcgo_n9th_clss_flg", {ComboText:"|Y", ComboCode:"|Y"} );
                 SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
                 SetHeaderRowHeight(21);
                 SetHeaderRowHeight(20);
                 resizeSheet();//SetSheetHeight(ComGetSheetHeight(sheetObj,10));
           }
           break;
            
         case 2:   //t2sheet1 init
            with (sheetObj) {
                 var HeadTitle="cost_cd|vrfy";

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"vrfy_string",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
                  
                 InitColumns(cols);

                 SetEditable(1);
                 SetSheetHeight(ComGetSheetHeight(sheetObj,4));
            }
            break;
    }    
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}

/**
 * handling sheet process. <br>
 * @param {ibsheet}  	sheetObj	Sheet Object
 * @param {String}  	formObj		Form Object
 * @param {String}  	sAction		Action Command
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBLOADEXCEL:
            //sheetObj.LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",StartRow:"116",EndRow:"-1"});
            //sheetObj.LoadExcel({Append:1});
            sheetObj.LoadExcel({ Mode: "HeaderMatch",  WorkSheetNo: "1",  WorkSheetName: "",  Append: false });
            //				sheetObj.LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",WorkSheetName:"",Append:false});
            break;
    }
}

/**
 * handling sheet process. <br>
 * @param {ibsheet}  	sheetObj	Sheet Object
 * @param {String}  	formObj		Form Object
 * @param {String}  	sAction		Action Command
 */
function doActionIBSheet1(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH;
            var param = sheetObjects[0].GetSaveString(false, false);
            var sXml = sheetObjects[1].GetSearchData("ESD_TES_9160GS.do", param + '&' + tesFrmQryStr(formObj), "", true);
            sheetObjects[1].LoadSearchData(sXml, { Sync: 1 });
            break;
    }
}

/**
 * set DtaCurrSht2OprSht( <br>
 * @param {ibsheet}  	ip_sht_obj		input sheet
 * @param {String}  	opr_sht_nm_str	opener sheet
 */
function setDtaCurrSht2OprSht(ip_sht_obj, opr_sht_nm_str) {
    var formObj = document.form;
    var opener_obj;
    if (!opener_obj) opener_obj = window.dialogArguments;
    if (!opener_obj) opener_obj = window.opener;
    if (!opener_obj) opener_obj = parent;
    var opener_sheet_obj = opener_obj.t2sheet1;
    var sheetObject = ip_sht_obj;
    //opener_sheet_obj.RemoveAll();
    //no support[check again]CLT 	for (i=3; i<sheetObject.Rows; i++)
    {
        var iRow = opener_sheet_obj.DataInsert(-1);
        for (j = 0; j <= sheetObject.LastCol(); j++) {
            if (sheetObject.ColSaveName(j) != "") {
                for (k = 0; k <= opener_sheet_obj.LastCol(); k++) {
                    if (opener_sheet_obj.ColSaveName(k) == sheetObject.ColSaveName(j)) {
                        opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(k), sheetObject.GetCellValue(i, sheetObject.ColSaveName(j)), 0);
                        if (sheetObject.GetCellValue(i, '3wkdy_flg') == "Y" &&
                            sheetObject.GetCellValue(i, '3sat_flg') == "Y" &&
                            sheetObject.GetCellValue(i, '3sun_flg') == "Y" &&
                            sheetObject.GetCellValue(i, '3hol_flg') == "Y") {
                            opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(61 + gap_tm), "P", 0);
                        } else {
                            opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(61 + gap_tm), "S", 0);
                        }
                        if (sheetObject.GetCellValue(i, '3dg_none') == "Y") {
                            opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(62 + gap_tm), "N", 0);
                        } else if (sheetObject.GetCellValue(i, '3same_dg_none') == "Y" &&
                            sheetObject.GetCellValue(i, '3same_dg') == "Y") {
                            opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(62 + gap_tm), "A", 0);
                        } else {
                            opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(62 + gap_tm), "S", 0);
                        }
                        if (sheetObject.GetCellValue(i, '3fm_tr_vol_val') == "1" &&
                            sheetObject.GetCellValue(i, '3to_tr_vol_val') == "MAX") {
                            opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(63 + gap_tm), "N", 0);
                        } else {
                            opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(63 + gap_tm), "S", 0);
                        }
                    }
                }
            }
        }
    }
    opener_obj.document.form.fileImportFlg.value = "Y";
}

/**
 * set DtaCurrSht2OprSht1
 * @param {ibsheet}		sheet	IBSheet
 * @param {String}		ErrMsg	Error Message
 */
function setDtaCurrSht2OprSht1(sheet, ErrMsg) {
    if (sheet.RowCount() > 0) {
        var queryStr = '';
        var opr_sht_idx = 0;
        var opener_sheet_obj;
        var opener_obj;
        if (!opener_obj) opener_obj = window.dialogArguments;
        if (!opener_obj) opener_obj = window.opener;
        if (!opener_obj) opener_obj = parent;
        queryStr = sheet.GetSaveString(false, false, "3lgs_cost_cd"); // + "&prefix=3";
        if (queryStr == null || queryStr == '') {
            //return false;
        } else {
            opr_sht_idx = 2;
            opener_sheet_obj = opener_obj.t2sheet1;
            tes_agmt_copy_rows_to(sheet, opener_sheet_obj, "", true, true, "3");
        }
        opener_obj.document.form.fileImportFlg.value = "Y";
        ComClosePopup();
    }
}

/**
 * Processing After the sheet retrieved.. <br>
 */
function sheet1_OnSearchEnd() {
    var k = sheetObjects[0].RowCount() + 3;
    var errCount = 0;
    var vrfyFlg;
    strErrLine = "";

    for (var i = 3; i < k; i++) {
        vrfyFlg = sheetObjects[1].GetCellValue(i - 2, 'vrfy_string').split("|");
        sheetObjects[0].SetCellValue(i, '3vrfyflg', sheetObjects[1].GetCellValue(i - 2, 'vrfy_string'));
        sheetObjects[0].SetRowBackColor(i, "#FFFFFF");

        if (sheetObjects[0].GetCellValue(i, '3auto_calc_flg') == "Y") {
            if (sheetObjects[0].GetCellValue(i, '3lgs_cost_cd') != sheetObjects[1].GetCellValue(i - 2, 0)) {
                sheetObjects[0].SetCellBackColor(i, '3lgs_cost_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
            
            if (sheetObjects[0].GetCellValue(i, '3lgs_cost_cd').trim() == "") {
                sheetObjects[0].SetCellBackColor(i, '3lgs_cost_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
            
            if (vrfyFlg[0] != sheetObjects[0].GetCellValue(i, '3auto_calc_flg')) {
                sheetObjects[0].SetCellBackColor(i, '3auto_calc_flg', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
            
            // Volume UOM 2016-05-23 추가
            if (vrfyFlg[0] == "Y" && sheetObjects[0].GetCellValue(i, '3tml_agmt_vol_ut_cd') == "W") {
                sheetObjects[0].SetCellBackColor(i, '3tml_agmt_vol_ut_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
            
            if (vrfyFlg[2] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3io_bnd_cd').toUpperCase() != "IB" &&
                    sheetObjects[0].GetCellValue(i, '3io_bnd_cd') != "OB" &&
                    sheetObjects[0].GetCellValue(i, '3io_bnd_cd').toUpperCase() != "SAME") {
                    sheetObjects[0].SetCellBackColor(i, '3io_bnd_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[2] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3io_bnd_cd').trim() != "") {
                    sheetObjects[0].SetCellBackColor(i, '3io_bnd_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }
            if (vrfyFlg[3] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3ioc_cd').toUpperCase() != "IPC" &&
                    sheetObjects[0].GetCellValue(i, '3ioc_cd').toUpperCase() != "OCN" &&
                    sheetObjects[0].GetCellValue(i, '3ioc_cd').toUpperCase() != "SAME") {
                    sheetObjects[0].SetCellBackColor(i, '3ioc_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[3] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3ioc_cd').trim() != "") {
                    sheetObjects[0].SetCellBackColor(i, '3ioc_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }
            if (vrfyFlg[4] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3wkdy_flg') == "" &&
                    sheetObjects[0].GetCellValue(i, '3sat_flg') == "" &&
                    sheetObjects[0].GetCellValue(i, '3sun_flg') == "" &&
                    sheetObjects[0].GetCellValue(i, '3hol_flg') == "") {
                    sheetObjects[0].SetCellBackColor(i, '3wkdy_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3sat_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3sun_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3hol_flg', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[4] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3wkdy_flg') != "" ||
                    sheetObjects[0].GetCellValue(i, '3sat_flg') != "" ||
                    sheetObjects[0].GetCellValue(i, '3sun_flg') != "" ||
                    sheetObjects[0].GetCellValue(i, '3hol_flg') != "") {
                    sheetObjects[0].SetCellBackColor(i, '3wkdy_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3sat_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3sun_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3hol_flg', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }
            if (vrfyFlg[5] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3lane_cd').trim() == "") {
                    sheetObjects[0].SetCellBackColor(i, '3lane_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[5] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3lane_cd').trim() != "") {
                    sheetObjects[0].SetCellBackColor(i, '3lane_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }
            if (vrfyFlg[6] == "Y" && sheetObjects[0].GetCellValue(i, "3tml_cntr_sty_cd") != "M") {
                if (sheetObjects[0].GetCellValue(i, '3dg_none').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3same_dg_none').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3same_dg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3sep_dg_none').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n1st_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n2nd_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n3rd_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n4th_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n5th_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n6th_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n7th_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n8th_clss_flg').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3dcgo_n9th_clss_flg').trim() == "") {
                    sheetObjects[0].SetCellBackColor(i, '3dg_none', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3same_dg_none', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3same_dg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3sep_dg_none', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n1st_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n2nd_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n3rd_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n4th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n5th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n6th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n7th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n8th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n9th_clss_flg', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[6] == "N" && sheetObjects[0].GetCellValue(i, "3tml_cntr_sty_cd") != "M") {
                if (sheetObjects[0].GetCellValue(i, '3dg_none').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3same_dg_none').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3same_dg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3sep_dg_none').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n1st_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n2nd_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n3rd_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n4th_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n5th_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n6th_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n7th_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n8th_clss_flg').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3dcgo_n9th_clss_flg').trim() != "") {
                    sheetObjects[0].SetCellBackColor(i, '3dg_none', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3same_dg_none', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3same_dg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3sep_dg_none', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n1st_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n2nd_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n3rd_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n4th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n5th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n6th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n7th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n8th_clss_flg', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dcgo_n9th_clss_flg', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }
            if (vrfyFlg[7] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3fm_tr_vol_val').trim() == "" &&
                    sheetObjects[0].GetCellValue(i, '3to_tr_vol_val').trim() == "") {
                    sheetObjects[0].SetCellBackColor(i, '3fm_tr_vol_val', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3to_tr_vol_val', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[7] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3fm_tr_vol_val').trim() != "" ||
                    sheetObjects[0].GetCellValue(i, '3to_tr_vol_val').trim() != "") {
                    sheetObjects[0].SetCellBackColor(i, '3fm_tr_vol_val', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3to_tr_vol_val', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }
            //				if (vrfyFlg[8] == "Y"){
            //					if(sheetObjects[0].GetCellValue(i,'3tml_ovt_shft_cd').trim() == "" ){
            //						sheetObjects[0].SetCellBackColor(i,'3tml_ovt_shft_cd',"#FF0000");
            //						errCount++;
            //					}
            //				}else if (vrfyFlg[8] == "N"){
            //					if(sheetObjects[0].GetCellValue(i,'3tml_ovt_shft_cd').trim() != "" ){
            //						sheetObjects[0].SetCellBackColor(i,'3tml_ovt_shft_cd',"#FF0000");
            //						errCount++;
            //					}
            //				}
            if (vrfyFlg[9] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3thc_tp_cd').trim() == "") {
                    sheetObjects[0].SetCellBackColor(i, '3thc_tp_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[9] != "Y") {
                if (sheetObjects[0].GetCellValue(i, '3thc_tp_cd').trim() != "") {
                    sheetObjects[0].SetCellBackColor(i, '3thc_tp_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }
            //rt_cntr_tpsz_flg
            if (vrfyFlg[20] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3d2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3d2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3d4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3d5') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3d7') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3d8') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3d9') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3dw') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3dx') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3r4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3r5') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3r7') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3f2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3f4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3o2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3o4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3s2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3s4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3t2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3t4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3a2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3a4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3p2') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3p4') > 0 ||
                    sheetObjects[0].GetCellValue(i, '3f5') > 0) {
                    sheetObjects[0].SetCellBackColor(i, '3d2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3d2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3d4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3d5', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3d7', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3d8', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3d9', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dw', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3dx', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3r4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3r5', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3r7', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3f2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3f4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3o2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3o4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3s2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3s4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3t2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3t4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3a2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3a4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3p2', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3p4', "#FF0000");
                    sheetObjects[0].SetCellBackColor(i, '3f5', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }

            //rt_teu_flg
            if (vrfyFlg[21] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3teu_rate') > 0) {
                    sheetObjects[0].SetCellBackColor(i, '3teu_rate', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }

            if (vrfyFlg[22] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3box_rate') > 0) {
                    sheetObjects[0].SetCellBackColor(i, '3box_rate', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }

            if (vrfyFlg[23] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3move_rate') > 0) {
                    sheetObjects[0].SetCellBackColor(i, '3move_rate', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }

            if (vrfyFlg[25] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3tml_trns_mod_cd').trim() == "") {
                    sheetObjects[0].SetCellBackColor(i, '3tml_trns_mod_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            } else if (vrfyFlg[25] == "N") {
                if (sheetObjects[0].GetCellValue(i, '3tml_trns_mod_cd').trim() != "") {
                    sheetObjects[0].SetCellBackColor(i, '3tml_trns_mod_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }

            //TML_CNTR_STY_CD
            if (vrfyFlg[26] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3tml_cntr_sty_cd') == "") {
                    sheetObjects[0].SetCellBackColor(i, '3tml_cntr_sty_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }

            //TML_CNTR_STY_CD
            if (vrfyFlg[28] == "Y") {
                if (sheetObjects[0].GetCellValue(i, '3sub_trd_cd') == "") {
                    sheetObjects[0].SetCellBackColor(i, '3sub_trd_cd', "#FF0000");
                    errLineAdd(i);
                    errCount++;
                }
            }

            sheetErrCount = errCount;
            vrfyFlg = "";

        }
    }

}

/** errLineAdd
 * 
 * @param row
 */
function errLineAdd(row) {
    if (strErrLine == "") {
        strErrLine = strErrLine + sheetObjects[0].GetCellValue(row, '3seq');
    } else {
        if (strErrLine.indexOf(",") == -1) {
            if (strErrLine.indexOf(sheetObjects[0].GetCellValue(row, '3seq')) == -1) {
                strErrLine = strErrLine + "," + sheetObjects[0].GetCellValue(row, '3seq');
            }
        } else {
            if (strErrLine.indexOf("," + sheetObjects[0].GetCellValue(row, '3seq')) == -1) {
                strErrLine = strErrLine + "," + sheetObjects[0].GetCellValue(row, '3seq');
            }
        }

    }
    sheetObjects[0].SetCellBackColor(row, '3seq', "#FF0000");
}

/**
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet_OnChange(sheetObj, Row, Col, Value) {
    var total_rate = "";
    for (i = 30 + gap_tm; i < 55 + gap_tm; i++) {
        total_rate = total_rate + "#" + sheetObjects[0].GetCellValue(Row, i);
    }

    if (Col > 29 + gap_tm || Col < 55 + gap_tm) {
        sheetObj.SetCellValue(Row, "3ts_rt", total_rate);
    }

    if (Col == 27 + gap_tm) {
        sheetObj.SetCellValue(Row, "3to_tr_vol_val", sheetObj.GetCellValue(Row, "3to_tr_vol_val").toUpperCase());
        if (sheetObj.GetCellValue(Row, "3to_tr_vol_val") != "MAX") {
            if (!ComIsNumber(sheetObj.GetCellValue(Row, "3to_tr_vol_val"))) {
                sheetObj.SetCellValue(Row, "3to_tr_vol_val", "");
            }
        }
    }
}

/**
 * load excel event <br>
 * 
 */
function sheet_OnLoadExcel(sheet, result, code, msg) {
    if (isExceedMaxRow(msg)) return;

    var k = sheetObjects[0].RowCount() + 3;
    var sheetNo = 3;
    var total_rate = "";
    var i = 0;
    var j = 0;
    var cellNullCheckString = "";
    
    for (i = 3; i < k; i++) {
        for (j = 30 + gap_tm; j < 55 + gap_tm; j++) {
            total_rate = total_rate + "#" + sheetObjects[0].GetCellValue(i, j);
        }
        sheetObjects[0].SetCellValue(i, "3ts_rt", total_rate);
        total_rate = "";
    }
    
    for (i = 3; i < k; i++) {
        for (j = 0; j < 63 + gap_tm; j++) {
            cellNullCheckString = cellNullCheckString + "|" + sheetObjects[0].GetCellValue(i, j);
        }
        //showErrMessage (cellNullCheckString);
        if (cellNullCheckString == "|||||||||||||||||||||||||||||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||||") {
            for (var jj = i; jj < k; jj++) {
                sheetObjects[0].RowDelete(i, false);
            }
            break;
        }
        cellNullCheckString = "";
    }
    
    //		for(i=3; i < sheetObjects[0].RowCount()+ 3; i++) {
    //			if(ComGetLenByByte(sheetObjects[0].GetCellValue(i,"3tml_ovt_shft_cd")) > 1 ){
    //				sheetObjects[0].SetCellValue(i,"3tml_ovt_shft_cd","");
    //			}
    //		}

    for (i = 3; i < sheetObjects[0].RowCount() + 3; i++) {
        if (sheetObjects[0].GetCellValue(i, "3lgs_cost_cd") != "TMNDTS") {
            sheetObjects[0].SetCellValue(i, "3tml_cntr_sty_cd", "");
        }

        if (sheetObjects[0].GetCellValue(i, "3sub_trd_cd") != "" && sheetObjects[0].GetCellValue(i, "3lgs_cost_cd") != "" && !(sheetObjects[0].GetCellValue(i, "3lgs_cost_cd").substring(0, 2) == "TP" || sheetObjects[0].GetCellValue(i, "3lgs_cost_cd").substring(0, 2) == "SV")) {
            sheetObjects[0].SetCellValue(i, "3sub_trd_cd", "");
        }

    }

    for (i = 0; i < sheetObjects[0].RowCount(); i++) {
        var sheetObj = sheetObjects[0];
        var sheetNo = 3;
        var Row = 3;
        if (sheetObj.GetCellValue(Row, "3curr_cd") == "KRW" || sheetObj.GetCellValue(Row, "3curr_cd") == "JPY") {
            sheetObj.InitColumns(Row, sheetNo + "d2", dtData, daCenter, sheetNo + "d2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "d4", dtData, daCenter, sheetNo + "d4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "d5", dtData, daCenter, sheetNo + "d5", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "d7", dtData, daCenter, sheetNo + "d7", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "d8", dtData, daCenter, sheetNo + "d8", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "d9", dtData, daCenter, sheetNo + "d9", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "dw", dtData, daCenter, sheetNo + "dw", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "dx", dtData, daCenter, sheetNo + "dx", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "r2", dtData, daCenter, sheetNo + "r2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "r4", dtData, daCenter, sheetNo + "r4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "r5", dtData, daCenter, sheetNo + "r5", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "r7", dtData, daCenter, sheetNo + "r7", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "f2", dtData, daCenter, sheetNo + "f2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "f4", dtData, daCenter, sheetNo + "f4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "f5", dtData, daCenter, sheetNo + "f5", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "o2", dtData, daCenter, sheetNo + "o2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "o4", dtData, daCenter, sheetNo + "o4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "s2", dtData, daCenter, sheetNo + "s2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "s4", dtData, daCenter, sheetNo + "s4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "t2", dtData, daCenter, sheetNo + "t2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "t4", dtData, daCenter, sheetNo + "t4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "a2", dtData, daCenter, sheetNo + "a2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "a4", dtData, daCenter, sheetNo + "a4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "p2", dtData, daCenter, sheetNo + "p2", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "p4", dtData, daCenter, sheetNo + "p4", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "teu_rate", dtData, daCenter, sheetNo + "teu_rate", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "box_rate", dtData, daCenter, sheetNo + "box_rate", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "move_rate", dtData, daCenter, sheetNo + "move_rate", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "gang_hour_rate", dtData, daCenter, sheetNo + "gang_hour_rate", "", dfInteger, 0, 18);
            sheetObj.InitColumns(Row, sheetNo + "tonne_rate", dtData, daCenter, sheetNo + "tonne_rate", "", dfInteger, 0, 18);
            Row++;
        }
    }
    //		sheetObjects[0].ColumnSort("3lgs_cost_cd", "DESC");
} 