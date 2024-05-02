/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9175.jsp
*@FileTitle  : Agreement Storage Rate List Excel Load
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var sheetErrCount = 0;
var opener = window.dialogArguments;
if (!opener) opener = parent;
var gap_st = 2;
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
                if (k == 0) {
                    ComShowCodeMessage('TES10087');
                    return false;
                }
                
                var dupRowCount = 0;
                strErrLine = "";

                for (var i = 0; i < sheetObjects[0].RowCount() + 3; i++) {
                    //sheetObjects[2].SetRowBackColor(i, "");
                    // 69 column
                    for (var j = 0; j < 100 + gap_st; j++) {
                        sheetObjects[0].SetCellBackColor(i, j, "");
                    }
                }

                var dupRowInfo = sheetObjects[0].ColValueDupRows("1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42", false, true);
                if (dupRowInfo != "") {
                    var dupRow = dupRowInfo.split("|");
                    var dupRowNum = dupRow[1].split(",");

                    if (dupRowNum.length > 0) {
                        for (var i = 0; i < dupRowNum.length; i++) {
                            if (sheetObjects[0].GetCellValue(dupRowNum[i], "5lgs_cost_cd") != "SRXXDC") {
                                dupRowCount++;
                                sheetObjects[0].SetRowBackColor(dupRowNum[i], "#FF0000");
                                errLineAdd(dupRowNum[i]);
                            }
                        }
                        if (dupRowCount > 0) {
                            alert("Dup Err Line : " + strErrLine + "\nThere are " + dupRowCount + " duplicate rows total.");
                            //								ComShowCodeMessage('TES10119', dupRowCount);
                            return false;
                        }
                    }
                }

                doActionIBSheet1(sheetObject1, formObject, IBSEARCH);

                if (sheetErrCount == 0) {
                    for (var i = 1; i <= k; i++) {
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, 1))) { //lgs_cost_cd
                            sheetObjects[0].SetCellBackColor(i + 2, 1, "#FF0000");
                            errLineAdd(i + 2);
                            err_count++;
                        } else {
                            //sheetObjects[0].SetCellBackColor(i+2,0,"#000000");
                            sheetObjects[0].SetCellBackColor(i + 2, 1, "");
                        }
                        
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, 1 + gap_st))) {
                            sheetObjects[0].SetCellBackColor(i + 2, 1 + gap_st, "#FF0000");
                            errLineAdd(i + 2);
                            err_count++;
                        } else {
                            //sheetObjects[0].SetCellBackColor(i+2,1,"#000000");
                            sheetObjects[0].SetCellBackColor(i + 2, 1 + gap_st, "");
                        }
                        
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, 2 + gap_st))) {
                            sheetObjects[0].SetCellBackColor(i + 2, 2 + gap_st, "#FF0000");
                            errLineAdd(i + 2);
                            err_count++;
                        } else {
                            //sheetObjects[0].SetCellBackColor(i+2,2,"#000000");
                            sheetObjects[0].SetCellBackColor(i + 2, 2 + gap_st, "");
                        }
                        
                        if (ComIsNull(sheetObjects[0].GetCellValue(i + 2, 3 + gap_st))) {
                            sheetObjects[0].SetCellBackColor(i + 2, 3 + gap_st, "#FF0000");
                            errLineAdd(i + 2);
                            err_count++;
                        } else {
                            //sheetObjects[0].SetCellBackColor(i+2,3,"#000000");
                            sheetObjects[0].SetCellBackColor(i + 2, 3 + gap_st, "");
                        }
                        //							if (ComIsNull(sheetObjects[0].GetCellValue(i+2, 4+gap_st))){
                        //								sheetObjects[0].SetCellBackColor(i+2,4+gap_st,"#FF0000");
                        //								errLineAdd(i+2);
                        //								err_count++;						     		  				   					
                        //							}else{
                        //								//sheetObjects[0].SetCellBackColor(i+2,4,"#000000");
                        //								sheetObjects[0].SetCellBackColor(i+2,4+gap_st,"");
                        //							}
                    }
                }

                if (sheetErrCount > 0 || err_count > 0) {
                    if (strErrLine != "") {
                        alert("Err Line : " + strErrLine + "\nPlease modify sheet.");
                    }

                    //						ComShowCodeMessage('TES10088');
                    sheetErrCount = 0;
                    return false;
                    
                } else if (sheetErrCount == 0 && err_count == 0) {
                    var opener_sheet_obj = opener.t4sheet1;
                    var appendFlg = "";
                    
                    if (opener_sheet_obj.RowCount() == 0) {
                        ComShowCodeMessage('TES10089');
                        appendFlg = true;
                    } else if (opener_sheet_obj.RowCount() > 0) {
                        appendFlg = ComShowConfirm(ComGetMsg('TES10121'));
                    }
                    
                    for (var i = 0; i < sheetObjects[0].RowCount(); i++) {
                        if (sheetObjects[0].GetCellValue(i + 3, "5io_bnd_cd").toUpperCase() == "IB" || sheetObjects[0].GetCellValue(i + 3, "5io_bnd_cd").toUpperCase() == "OB" || sheetObjects[0].GetCellValue(i + 3, "5io_bnd_cd").toUpperCase() == "SAME") {
                            sheetObjects[0].SetCellValue(i + 3, "5io_bnd_cd", sheetObjects[0].GetCellValue(i + 3, "5io_bnd_cd").toUpperCase());
                            if (sheetObjects[0].GetCellValue(i + 3, "5io_bnd_cd").toUpperCase() == "IB") {
                                sheetObjects[0].SetCellValue(i + 3, "5io_bnd_cd", "I");
                            } else if (sheetObjects[0].GetCellValue(i + 3, "5io_bnd_cd").toUpperCase() == "OB") {
                                sheetObjects[0].SetCellValue(i + 3, "5io_bnd_cd", "O");
                            } else if (sheetObjects[0].GetCellValue(i + 3, "5io_bnd_cd").toUpperCase() == "SAME") {
                                sheetObjects[0].SetCellValue(i + 3, "5io_bnd_cd", "S");
                            }
                        } else {
                            sheetObjects[0].SetCellValue(i + 3, "5io_bnd_cd", "");
                        }
                        
                        if (sheetObjects[0].GetCellValue(i + 3, "5sat_flg_fd").toUpperCase() == "E") {
                            sheetObjects[0].SetCellValue(i + 3, "5sat_flg_fd", "Y");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "5sat_flg_fd").toUpperCase() == "I") {
                            sheetObjects[0].SetCellValue(i + 3, "5sat_flg_fd", "");
                        }
                        
                        if (sheetObjects[0].GetCellValue(i + 3, "5sun_flg_fd").toUpperCase() == "E") {
                            sheetObjects[0].SetCellValue(i + 3, "5sun_flg_fd", "Y");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "5sun_flg_fd").toUpperCase() == "I") {
                            sheetObjects[0].SetCellValue(i + 3, "5sun_flg_fd", "");
                        }
                        
                        if (sheetObjects[0].GetCellValue(i + 3, "5hol_flg_fd").toUpperCase() == "E") {
                            sheetObjects[0].SetCellValue(i + 3, "5hol_flg_fd", "Y");
                        } else if (sheetObjects[0].GetCellValue(i + 3, "5hol_flg_fd").toUpperCase() == "I") {
                            sheetObjects[0].SetCellValue(i + 3, "5hol_flg_fd", "");
                        }
                        
                        if (sheetObjects[0].GetCellValue(i + 3, "5to_tr_dys").toUpperCase() == "MAX") {
                            sheetObjects[0].SetCellValue(i + 3, "5to_tr_dys", sheetObjects[0].GetCellValue(i + 3, "5to_tr_dys").toUpperCase());
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
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
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
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 * @param{ibsheet}		sheetObj	Sheet Object
 * @param{int,String}	sheetNo		Sheet No
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){	
				sheetNo=5;		     
				var HeadTitle0="Seq|Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|"
				+ "Exclude Date|Exclude Date|Exclude Date|"
				+ "DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|"
				+ "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|"
				+ "Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|"
				+ "Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|"
				+ "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				var HeadTitle1="Seq|Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "SA|SU|Ho|"
				+ "None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|"
				+ "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				var HeadTitle2="Seq|Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "SA|SU|Ho|"
				+ "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|"
				+ "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},
				{ Text:HeadTitle1, Align:"Center"},
				{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_cntr_sty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_vol_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_sto_agmt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cmnc_hrmnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ft_dys",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dg_none_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_none_fd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sep_dg_none_fd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n1st_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n2nd_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n3rd_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n4th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n5th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n6th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n7th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n8th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n9th_clss_flg_fd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sat_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sun_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"hol_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dg_none_r",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_none_r",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"same_dg_r",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sep_dg_none_r",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n1st_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n2nd_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n3rd_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n4th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n5th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n6th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n7th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n8th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Combo",     Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dcgo_n9th_clss_flg_r",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fm_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							
							{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_calc_prd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_teu_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d5_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d7_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d8_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d9_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dw_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dx_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r5_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r7_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f5_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p2_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p4_fd",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d5_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d7_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d8_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"d9_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dw_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dx_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r5_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"r7_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"f5_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"o4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"s4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"t4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"a4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p2_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"p4_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"teu_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"box_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"move_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tonne_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"agmt_dtl_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"xcld_dy_aply_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"auto_calc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ts_rt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vrfyFlg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetCellBackColor(1,7+gap_st,"#555555");//
				SetRangeBackColor(1, 8+gap_st,  1, 37+gap_st,"#555555");//
				SetRangeBackColor(1, 20+gap_st,  1, 23+gap_st,"#555555");//
				SetRangeBackColor(2,  8+gap_st, 2, 37+gap_st,"#555555");//
				SetRangeBackColor(1, 36+gap_st, 1, 37+gap_st,"#555555");//
				SetRangeBackColor(1, 39+gap_st, 1, 91+gap_st,"#555555");//
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
				SetColProperty(sheetNo+"lgs_cost_cd", {ComboText:opener.lgsCostCDSheet, ComboCode:opener.lgsCostCDSheet} );
				SetColProperty(sheetNo+"tml_cntr_sty_cd", {ComboText:"|Same|F|M", ComboCode:"|S|F|M"} );
				SetColProperty(sheetNo+"tml_agmt_vol_ut_cd", {ComboText:vol_ut_cdCode, ComboCode:vol_ut_cdCode} );
				SetColProperty(sheetNo+"tml_sto_agmt_tp_cd", {ComboText:tml_sto_agmt_tp_codeCode, ComboCode:tml_sto_agmt_tp_codeCode} );
				SetColProperty(sheetNo+"io_bnd_cd", {ComboText:io_bnd_codeText, ComboCode:io_bnd_codeCode} );
				SetColProperty(sheetNo+"ft_dys", {ComboText:"|F", ComboCode:"|F"} );
				SetColProperty(sheetNo+"fp_calc_prd_cd", {ComboText:"|D|M", ComboCode:"|D|M"} );
				SetColProperty(sheetNo+"dg_none_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_none_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sep_dg_none_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n1st_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n2nd_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n3rd_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n4th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n5th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n6th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n7th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n8th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n9th_clss_flg_fd", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dg_none_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_none_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"same_dg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"sep_dg_none_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n1st_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n2nd_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n3rd_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n4th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n5th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n6th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n7th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n8th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"dcgo_n9th_clss_flg_r", {ComboText:"|Y", ComboCode:"|Y"} );
				SetColProperty(sheetNo+"cmnc_hrmnt", {Format:"##:##"} );
				//SetCountFormat()("[SELECTDATAROW / ROWCOUNT]");
				resizeSheet();//SetSheetHeight(300);
			}
			
		break;
		
		case 2:   //t2sheet1 init
			with(sheetObj){
				var HeadTitle="cost_cd|vrfy";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				SetCountPosition(0);
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
            sheetObj.LoadExcel({
                Mode: "HeaderMatch",
                WorkSheetNo: "1",
                WorkSheetName: "",
                Append: false
            });
            //sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:true});
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
            var sXml = sheetObjects[1].GetSearchData("ESD_TES_9170GS.do", param + '&' + tesFrmQryStr(formObj), "", true);
            sheetObjects[1].LoadSearchData(sXml, { Sync: 1 });
            break;
    }
}

/**
 * @param {ibsheet}  	ip_sht_obj		input sheet
 * @param {String}  	opr_sht_nm_str	opener sheet
 */
function setDtaCurrSht2OprSht(ip_sht_obj, opr_sht_nm_str) {
    var formObj = document.form;
    var total_rate = 0;
    var i = 0;
    var opener_sheet_obj = opener.t4sheet1;
    var sheetObject = ip_sht_obj;
    //opener_sheet_obj.RemoveAll();
    for (i = 3; i < sheetObject.Rows; i++) {
        var iRow = opener_sheet_obj.DataInsert(-1);
        for (j = 0; j <= sheetObject.LastCol(); j++) {
            if (sheetObject.ColSaveName(j) != "") {
                for (k = 0; k <= opener_sheet_obj.LastCol(); k++) {
                    if (opener_sheet_obj.ColSaveName(k) == sheetObject.ColSaveName(j)) {
                        opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(k), sheetObject.GetCellValue(i, sheetObject.ColSaveName(j)), 0);
                    }
                }
            }
        }
    }
    opener_obj.document.form.fileImportFlg.value = "Y";
}

/**
 * @param {ibsheet}		sheet	IBSheet
 * @param {String}		ErrMsg	Error Message
 */
function setDtaCurrSht2OprSht1(sheet, ErrMsg) {
    if (sheet.RowCount() > 0) {
        var queryStr = '';
        var opr_sht_idx = 0;
        var opener_sheet_obj;
        queryStr = sheet.GetSaveString(false, false) + "&prefix=5";
        if (queryStr == null || queryStr == '') {
            //return false;
        } else {
            opr_sht_idx = 2;
            opener_sheet_obj = opener.t4sheet1;
            tes_agmt_copy_rows_to(sheet, opener_sheet_obj, "", false, true, "5");
        }
        opener.form.fileImportFlg.value = "Y";
        ComClosePopup();
    }
}

/**
 * Sheet Excel Load <br>
 * 
 */
function sheet_OnLoadExcel(sheet, result, code, msg) {
    if (isExceedMaxRow(msg)) return;

    var k = sheetObjects[0].RowCount() + 3;
    var sheetNo = 5;
    var j = 0;
    var daysTotalRate = 0;
    var rateTotalRate = 0;
    var total_rate_day = "";
    var total_rate_rate = "";
    var cellNullCheckString = "";
    var i = 0;
    for (i = 3; i < k; i++) {
        for (j = 0; j < 95 + gap_st; j++) {
            cellNullCheckString = cellNullCheckString + "|" + sheetObjects[0].GetCellValue(i, j);
        }
        if (cellNullCheckString == "|||||||||||||||||||||||||||||||||||||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||") {
            for (var jj = i; jj < k; jj++) {
                sheetObjects[0].RowDelete(i, false);
            }
            break;
        }
        cellNullCheckString = "";
    }

    for (var i = 3; i < k; i++) {
        for (j = 40 + gap_st; j < 65 + gap_st; j++) {
            total_rate_day = total_rate_day + "#" + sheetObjects[0].GetCellValue(i, j);
            daysTotalRate = parseInt(sheetObjects[0].GetCellValue(i, j)) + daysTotalRate;
        }
        
        for (j = 65 + gap_st; j < 90 + gap_st; j++) {
            total_rate_rate = total_rate_rate + "#" + sheetObjects[0].GetCellValue(i, j);
            rateTotalRate = parseInt(sheetObjects[0].GetCellValue(i, j)) + rateTotalRate;
        }
        
        if (daysTotalRate == 0 && rateTotalRate > 0) {
            sheetObjects[0].SetCellValue(i, "5ts_rt", total_rate_rate);
        } else if (daysTotalRate > 0 && rateTotalRate == 0) {
            sheetObjects[0].SetCellValue(i, "5ts_rt", total_rate_day);
        } else if (daysTotalRate > 0 && rateTotalRate > 0) {
            sheetObjects[0].SetCellValue(i, "5ts_rt", total_rate_rate);
        } else {
            sheetObjects[0].SetCellValue(i, "5ts_rt", total_rate_rate);
        }
        
        daysTotalRate = 0;
        rateTotalRate = 0;
        total_rate_day = "";
        total_rate_rate = "";
    }

    for (var i = 3; i < sheetObjects[0].RowCount() + 3; i++) {
        var sheetObj = sheetObjects[0];
        if (sheetObj.GetCellValue(i, "5curr_cd") == "KRW" || sheetObj.GetCellValue(i, "5curr_cd") == "JPY") {
            sheetObj.InitCellProperty(i, "5d2_r", dtData, daCenter, "5d2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5d4_r", dtData, daCenter, "5d4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5d5_r", dtData, daCenter, "5d5_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5d7_r", dtData, daCenter, "5d7_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5d8_r", dtData, daCenter, "5d8_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5d9_r", dtData, daCenter, "5d9_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5dw_r", dtData, daCenter, "5dw_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5dx_r", dtData, daCenter, "5dx_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5r2_r", dtData, daCenter, "5r2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5r4_r", dtData, daCenter, "5r4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5r5_r", dtData, daCenter, "5r5_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5r7_r", dtData, daCenter, "5r7_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5f2_r", dtData, daCenter, "5f2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5f4_r", dtData, daCenter, "5f4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5f5_r", dtData, daCenter, "5f5_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5o2_r", dtData, daCenter, "5o2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5o4_r", dtData, daCenter, "5o4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5s2_r", dtData, daCenter, "5s2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5s4_r", dtData, daCenter, "5s4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5t2_r", dtData, daCenter, "5t2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5t4_r", dtData, daCenter, "5t4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5a2_r", dtData, daCenter, "5a2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5a4_r", dtData, daCenter, "5a4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5p2_r", dtData, daCenter, "5p2_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5p4_r", dtData, daCenter, "5p4_r", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5teu_rate", dtData, daCenter, "5teu_rate", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5box_rate", dtData, daCenter, "5box_rate", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5move_rate", dtData, daCenter, "5move_rate", "", dfInteger, 0, 18);
            sheetObj.InitCellProperty(i, "5tonne_rate", dtData, daCenter, "5tonne_rate", "", dfInteger, 0, 18);
        }

        if (sheetObjects[0].GetCellValue(i, "5lgs_cost_cd") != "SRNDTS") {
            sheetObjects[0].SetCellValue(i, "5tml_cntr_sty_cd", "");
        }
    }
}

/**
 * Processing After the sheet retrieved.. <br>
 */
function sheet1_OnSearchEnd() {
    var k = sheetObjects[0].RowCount() + 3;
    var vrfyFlg;
    var vrfyRateSum = 0;
    var vrfyDysSum = 0;
    var errCount = 0;
    var totalErrCount = 0;
    strErrLine = "";

    for (var i = 3; i < k; i++) {
        vrfyFlg = sheetObjects[1].GetCellValue(i - 2, 1).split("|");
        sheetObjects[0].SetCellValue(i - 2, 98 + gap_st, vrfyFlg);
        sheetObjects[0].SetRowBackColor(i, "#FFFFFF");
        vrfyDysSum = parseInt(sheetObjects[0].GetCellValue(i, '5d2_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d5_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d7_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d8_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d9_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5dw_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5dx_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5r4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5r5_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5r7_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5f2_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5f4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5o2_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5o4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5s2_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5s4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5t2_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5t4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5a2_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5a4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5p2_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5p4_fd')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5f5_fd'));

        vrfyRateSum = parseInt(sheetObjects[0].GetCellValue(i, '5d2_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d5_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d7_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d8_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5d9_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5dw_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5dx_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5r4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5r5_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5r7_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5f2_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5f4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5o2_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5o4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5s2_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5s4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5t2_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5t4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5a2_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5a4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5p2_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5p4_r')) +
            parseInt(sheetObjects[0].GetCellValue(i, '5f5_r'));

        if (sheetObjects[0].GetCellValue(i, '5lgs_cost_cd') != sheetObjects[1].GetCellValue(i - 2, 0)) {
            sheetObjects[0].SetCellBackColor(i, '5lgs_cost_cd', "#FF0000");
            errLineAdd(i);
            errCount++;
        }

        if (sheetObjects[0].GetCellValue(i, '5lgs_cost_cd').trim() == "") {
            sheetObjects[0].SetCellBackColor(i, '5lgs_cost_cd', "#FF0000");
            errLineAdd(i);
            errCount++;
        }

        if (vrfyFlg[0] == "Y") {
            sheetObjects[0].SetCellValue(i, '5auto_calc_flg', "Y");
        }

        if (sheetObjects[0].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "C" && sheetObjects[0].GetCellValue(i, '5ft_dys').trim() == "") {
            if (sheetObjects[0].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5teu_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5box_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5move_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (sheetObjects[0].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "T" && sheetObjects[0].GetCellValue(i, '5ft_dys').trim() == "") {
            if (vrfyDysSum > 0 || vrfyRateSum > 0) {} else if (sheetObjects[0].GetCellValue(i, '5teu_rate') == 0.00) {
                sheetObjects[0].SetCellBackColor(i, '5teu_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5box_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5move_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (sheetObjects[0].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "U" && sheetObjects[0].GetCellValue(i, '5ft_dys').trim() == "") {
            if (sheetObjects[0].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5teu_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5box_rate') == 0.00) {
                sheetObjects[0].SetCellBackColor(i, '5box_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5move_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (sheetObjects[0].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "M" && sheetObjects[0].GetCellValue(i, '5ft_dys').trim() == "") {
            if (sheetObjects[0].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5teu_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5box_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5move_rate') == 0.00) {
                sheetObjects[0].SetCellBackColor(i, '5move_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5tonne_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }
        
        if (sheetObjects[0].GetCellValue(i, '5tml_agmt_vol_ut_cd') == "W" && sheetObjects[0].GetCellValue(i, '5ft_dys').trim() == "") {
            if (sheetObjects[0].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5teu_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5box_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5move_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5tonne_rate') = 0.00) {
                sheetObjects[0].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (sheetObjects[0].GetCellValue(i, '5ft_dys') == "F") {
            if (sheetObjects[0].GetCellValue(i, '5teu_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5teu_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5box_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5box_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5move_rate') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5move_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5tonne_rate') > 0.00) {
                sheetObjects[0].SetCellBackColor(i, '5tonne_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (vrfyFlg[11] == "Y") {
            if (sheetObjects[0].GetCellValue(i, '5cmnc_hrmnt') == "") {
                sheetObjects[0].SetCellBackColor(i, '5cmnc_hrmnt', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        } else if (vrfyFlg[11] == "N") {
            if (sheetObjects[0].GetCellValue(i, '5cmnc_hrmnt') != "") {
                sheetObjects[0].SetCellBackColor(i, '5cmnc_hrmnt', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (vrfyFlg[12] == "Y" && sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FD") {
            if (sheetObjects[0].GetCellValue(i, '5io_bnd_cd').trim() == "") {
                sheetObjects[0].SetCellBackColor(i, '5io_bnd_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        } else if (vrfyFlg[12] == "N") {
            if (sheetObjects[0].GetCellValue(i, '5io_bnd_cd').trim() != "") {
                sheetObjects[0].SetCellBackColor(i, '5io_bnd_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (vrfyFlg[13] == "Y") {
            if (sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') != "FD" && sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') != "FP") {
                sheetObjects[0].SetCellBackColor(i, '5tml_sto_agmt_tp_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        //			else if (vrfyFlg[13] == "N"){//20150603 주석처리
        //				if(sheetObjects[0].GetCellValue(i,'5tml_sto_agmt_tp_cd').trim() != ""){
        //					sheetObjects[0].SetCellBackColor(i,'5tml_sto_agmt_tp_cd',"#FF0000");
        //					errLineAdd(i);
        //					errCount++;
        //				} 
        //			}	
        if (sheetObjects[0].GetCellValue(i, '5ft_dys') == "F" && vrfyFlg[14] == "Y" && sheetObjects[0].GetCellValue(i, "5tml_cntr_sty_cd") != "M") {
            if (sheetObjects[0].GetCellValue(i, '5dg_none_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5same_dg_none_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5same_dg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5sep_dg_none_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n1st_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n2nd_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n3rd_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n4th_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n5th_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n6th_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n7th_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n8th_clss_flg_fd').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n9th_clss_flg_fd').trim() == "") {
                sheetObjects[0].SetCellBackColor(i, '5dg_none_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_none_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5sep_dg_none_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n1st_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n4th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n5th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n6th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n7th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n8th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n9th_clss_flg_fd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
            
        } else if (vrfyFlg[14] == "N" && sheetObjects[0].GetCellValue(i, "5tml_cntr_sty_cd") != "M") {
            if (sheetObjects[0].GetCellValue(i, '5dg_none_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5same_dg_none_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5same_dg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5sep_dg_none_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n1st_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n2nd_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n3rd_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n4th_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n5th_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n6th_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n7th_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n8th_clss_flg_fd').trim() == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n9th_clss_flg_fd').trim() == "Y") {
                sheetObjects[0].SetCellBackColor(i, '5dg_none_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_none_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5sep_dg_none_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n1st_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n4th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n5th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n6th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n7th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n8th_clss_flg_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n9th_clss_flg_fd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }
        
        if (sheetObjects[0].GetCellValue(i, '5ft_dys') == "" && vrfyFlg[16] == "Y" && sheetObjects[0].GetCellValue(i, "5tml_cntr_sty_cd") != "M") {
            if (sheetObjects[0].GetCellValue(i, '5dg_none_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5same_dg_none_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5same_dg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5sep_dg_none_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n1st_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n2nd_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n3rd_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n4th_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n5th_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n6th_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n7th_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n8th_clss_flg_r').trim() == "" &&
                sheetObjects[0].GetCellValue(i, '5dcgo_n9th_clss_flg_r').trim() == "") {
                sheetObjects[0].SetCellBackColor(i, '5dg_none_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_none_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5sep_dg_none_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n1st_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n4th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n5th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n6th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n7th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n8th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n9th_clss_flg_r', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        } else if (vrfyFlg[16] == "N" && sheetObjects[0].GetCellValue(i, "5tml_cntr_sty_cd") != "M") {
            if (sheetObjects[0].GetCellValue(i, '5dg_none_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5same_dg_none_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5same_dg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5sep_dg_none_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n1st_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n2nd_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n3rd_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n4th_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n5th_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n6th_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n7th_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n8th_clss_flg_r') == "Y" ||
                sheetObjects[0].GetCellValue(i, '5dcgo_n9th_clss_flg_r') == "Y") {
                sheetObjects[0].SetCellBackColor(i, '5dg_none_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_none_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5same_dg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5sep_dg_none_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n1st_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n2nd_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n3rd_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n4th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n5th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n6th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n7th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n8th_clss_flg_r', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dcgo_n9th_clss_flg_r', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (vrfyFlg[17] == "Y" && sheetObjects[0].GetCellValue(i, '5ft_dys') == "F" &&
            sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FD") {
            if (sheetObjects[0].GetCellValue(i, '5fm_tr_dys') != "" && sheetObjects[0].GetCellValue(i, '5to_tr_dys') != "") {
                sheetObjects[0].SetCellBackColor(i, '5fm_tr_dys', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5to_tr_dys', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        } else if (vrfyFlg[17] == "Y" && sheetObjects[0].GetCellValue(i, '5ft_dys').trim() == "" &&
            sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FD") {
            if (sheetObjects[0].GetCellValue(i, '5fm_tr_dys') == "" || sheetObjects[0].GetCellValue(i, '5to_tr_dys') == "") {
                sheetObjects[0].SetCellBackColor(i, '5fm_tr_dys', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5to_tr_dys', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        } else if (vrfyFlg[17] == "N") {
            if (sheetObjects[0].GetCellValue(i, '5fm_tr_dys').trim() != "" ||
                sheetObjects[0].GetCellValue(i, '5to_tr_dys').trim() != "") {
                sheetObjects[0].SetCellBackColor(i, '5fm_tr_dys', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5to_tr_dys', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }
        
        if (vrfyFlg[18] == "Y" && sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FP") {
            if (sheetObjects[0].GetCellValue(i, '5fp_calc_prd_cd').trim() == "") {
                sheetObjects[0].SetCellBackColor(i, '5fp_calc_prd_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        } else if (vrfyFlg[18] == "N") {
            if (sheetObjects[0].GetCellValue(i, '5fp_calc_prd_cd').trim() != "") {
                sheetObjects[0].SetCellBackColor(i, '5fp_calc_prd_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }
        
        if (vrfyFlg[19] == "Y" && sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FP") {
            if (sheetObjects[0].GetCellValue(i, '5fp_teu_qty') == 0) {
                sheetObjects[0].SetCellBackColor(i, '5fp_teu_qty', "#FF0000");
                errLineAdd(i);
                errCount++;
            } else if (sheetObjects[0].GetCellValue(i, '5teu_rate') == 0 && sheetObjects[0].GetCellValue(i, '5box_rate') == 0) {
                //sheetObjects[0].CellBackColor(i,'5fp_teu_qty') = "#FF0000";	
                sheetObjects[0].SetCellBackColor(i, '5teu_rate', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5box_rate', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        } else if (vrfyFlg[19] == "N") {
            if (sheetObjects[0].GetCellValue(i, '5fp_teu_qty') > 0) {
                sheetObjects[0].SetCellBackColor(i, '5fp_teu_qty', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        //sto_cntr_full_mty_flg
        if (vrfyFlg[27] == "Y") {
            if (sheetObjects[0].GetCellValue(i, '5tml_cntr_sty_cd') == "") {
                sheetObjects[0].SetCellBackColor(i, '5tml_cntr_sty_cd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }

        if (sheetObjects[0].GetCellValue(i, '5ft_dys') == "F") {} else if (sheetObjects[0].GetCellValue(i, '5ft_dys').trim() == "") {
            if (vrfyDysSum > 0) {
                sheetObjects[0].SetCellBackColor(i, '5d2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5d2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5d4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5d5_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5d7_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5d8_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5d9_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dw_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5dx_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5r2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5r4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5r5_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5r7_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5f2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5f4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5o2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5o4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5s2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5s4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5t2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5t4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5a2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5a4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5p2_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5p4_fd', "#FF0000");
                sheetObjects[0].SetCellBackColor(i, '5f5_fd', "#FF0000");
                errLineAdd(i);
                errCount++;
            }
        }
        
        if (sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FP") {
            if (sheetObjects[0].GetCellValue(i, '5fp_calc_prd_cd').trim() == "") {
                sheetObjects[0].SetCellBackColor(i, '5fp_calc_prd_cd', "#FF0000");
            }
        } else if (sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FD") {
            if (sheetObjects[0].GetCellValue(i, '5fp_calc_prd_cd').trim() != "") {
                sheetObjects[0].SetCellBackColor(i, '5fp_calc_prd_cd', "#FF0000");
            }
        }
        
        if (sheetObjects[0].GetCellValue(i, '5tml_sto_agmt_tp_cd') == "FP") {
            sheetObjects[0].SetCellValue(i, '5d2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5d4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5d5_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5d7_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5d8_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5d9_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5dw_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5dx_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5r2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5r4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5r5_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5r7_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5f2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5f4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5o2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5o4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5s2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5s4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5t2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5t4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5a2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5a4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5p2_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5p4_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5f5_fd', 0.00);
            sheetObjects[0].SetCellValue(i, '5d2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5d4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5d5_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5d7_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5d8_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5d9_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5dw_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5dx_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5r2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5r4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5r5_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5r7_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5f2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5f4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5o2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5o4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5s2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5s4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5t2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5t4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5a2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5a4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5p2_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5p4_r', 0.00);
            sheetObjects[0].SetCellValue(i, '5f5_r', 0.00);
            //sheetObjects[0].CellValue(i,'5box_rate')   = 0.00;
            //sheetObjects[0].CellValue(i,'5move_rate')  = 0.00; 				
        }
        
        sheetErrCount = errCount;
        if (errCount > 0) {
            //break;
        }
        vrfyFlg = "";
    }
}

function errLineAdd(row) {
    if (strErrLine == "") {
        strErrLine = strErrLine + sheetObjects[0].GetCellValue(row, '5seq');
    } else {
        if (strErrLine.indexOf(",") == -1) {
            if (strErrLine.indexOf(sheetObjects[0].GetCellValue(row, '5seq')) == -1) {
                strErrLine = strErrLine + "," + sheetObjects[0].GetCellValue(row, '5seq');
            }
        } else {
            if (strErrLine.indexOf("," + sheetObjects[0].GetCellValue(row, '5seq')) == -1) {
                strErrLine = strErrLine + "," + sheetObjects[0].GetCellValue(row, '5seq');
            }
        }

    }
    sheetObjects[0].SetCellBackColor(row, '5seq', "#FF0000");
} 