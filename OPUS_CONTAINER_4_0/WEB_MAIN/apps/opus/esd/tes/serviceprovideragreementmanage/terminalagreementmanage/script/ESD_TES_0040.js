/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0040.js
*@FileTitle : Terminal Agreement Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var parmObj = new Array();

/**
 * Event handler processing by button click event 
 **/
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 **/
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var tabObj = tabObjects;
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                var tmp_agmt_no;
                var tmp_agmt_ver_no;
                var flag = true;
                tmp_agmt_no = formObject.tml_agmt_ofc_cty_cd.value;
                tmp_agmt_ver_no = formObject.tml_agmt_ver_no.value;
                if (ComIsNull(tmp_agmt_no) && ComIsNull(tmp_agmt_ver_no)) {
                    ComShowCodeMessage('TES50301'); // Insert Agreement No & Agreement Version()Information!');
                    flag = false;
                    return false;
                    
                } else if (tmp_agmt_no == undefined || tmp_agmt_no == '' || tmp_agmt_no == null) {
                    ComShowCodeMessage('TES50302'); // Insert Agreement No!');
                    flag = false;
                    return false;
                    
                } else if (tmp_agmt_no.length != 8) {
                    ComShowCodeMessage('TES50303'); // Insert Correct Agreement No!');
                    flag = false;
                    return false;
                    
                } else if (tmp_agmt_ver_no == undefined || tmp_agmt_ver_no == '' || tmp_agmt_ver_no == null) {
                    ComShowCodeMessage('TES50304'); // Insert Agreement Version()Information!');
                    flag = false;
                    return false;
                    
                } else if (tmp_agmt_ver_no.length != 5) {
                    ComShowCodeMessage('TES50305'); // Insert Correct Agreement Version()Information!');
                    flag = false;
                    return false;                    
                }
                
                if (flag) {
                    sheetObject.RemoveAll();
                    sheetObject1.RemoveAll();
                    sheetObject2.RemoveAll();
                    sheetObject3.RemoveAll();
                    formObject.reset();
                    formObject.tml_agmt_ofc_cty_cd.value = tmp_agmt_no;
                    formObject.tml_agmt_ver_no.value = tmp_agmt_ver_no;
                    doActionIBSheet(sheetObject3, formObject, IBSEARCH);
                }
                break;

            case "btn_new":
                formObject.reset();
                formObject.tml_agmt_ofc_cty_cd.value = '';
                formObject.tml_agmt_ver_no.value = '';
                formObject.no_ofc_cd.value = '';
                formObject.no_yd_cd.value = '';
                formObject.auth_ofc_cd.value = '';
                formObject.cre_ofc_cd.value = '';
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                sheetObject3.RemoveAll();
                break;

            case "btng_downexcel":
                var tab;

                tab = tab1.GetSelectedIndex();
                if (tab == 0) {
                    if (sheetObject.RowCount() == 0) {
                        ComShowCodeMessage("TES50306"); // No data at the Terminal Rate List");
                        return;
                    } else {
                        doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                    }
                } else if (tab == 1) {
                    if (sheetObject1.RowCount() == 0) {
                        ComShowCodeMessage("TES50307"); // No data at the Storate Rate List");
                        return;
                    } else {
                        doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
                    }
                } else {
                    if (sheetObject2.RowCount() == 0) {
                        ComShowCodeMessage("TES50307"); // No data at the Storate Rate List");
                        return;
                    } else {
                        doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL);
                    }
                }
                break;

            case "btng_adjustmentscreen":
                var agmt_no = formObject.tml_agmt_ofc_cty_cd.value;
                var agmt_ver_no = formObject.tml_agmt_ver_no.value;
                if (ComIsNull(agmt_no) && ComIsNull(agmt_ver_no)) {
                    ComShowCodeMessage('TES50301'); // Insert Agreement No & Agreement Version()Information!');
                    return;
                } else if (!validate_agmt_no()) {
                    return;
                } else if (!validate_agmt_ver()) {
                    return;
                }
                location.href = "ESD_TES_0034.do?pgmNo=ESD_TES_0034&parentPgmNo=ESD_TES_M001&tml_agmt_ofc_cty_cd=" + agmt_no + "&tml_agmt_ver_no=" + agmt_ver_no;
                break;

            case "btng_print":
                printInvoiceSummary();
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
 * 
 * @param {ibsheet}		sheet_obj  	Sheet Object
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
    
    for (k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var formObject = document.form;
    
    if (!ComIsNull(agmt_no)) {
        formObject.tml_agmt_ofc_cty_cd.value = agmt_no;
        formObject.tml_agmt_ver_no.value = agmt_ver_no;
        doActionIBSheet(sheetObject3, formObject, IBSEARCH);
    }
}

/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 * 
 * @param {ibsheet}  	sheetObj	IBSheet Object
 * @param {int,string}	sheetNo  	Sheet Object 
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) { 
		case 1:   //t1sheet1 init
			with(sheetObj){
			
				var HeadTitle0="Cost Code|F/M|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
				+ "Applied Date|Applied Date|Applied Date|Applied Date|Lane|Sub Trade|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|DG|"
				+ "Tier Vol.|Tier Vol.|OT\nShift|THC|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|Rate by Container Type Size|"
				+ "Rate by Container Type Size|Rate by Container Type Size|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|"
				+ "Remark|agmt_dtl_rmk";
				var HeadTitle1="Cost Code|F/M|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
				+ "WD|Sat|Sun|H/D|Lane|Sub Trade|None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "Fr|To|OT\nShift|THC|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Remark|agmt_dtl_rmk";
				var HeadTitle2="Cost Code|F/M|Auto\nCal.\nY/N|Volume \nUOM|Currency|TP CC|I/O|IPC/\nOcean|Mode|"
				+ "WD|Sat|Sun|H/D|Lane|Sub Trade|None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "Fr|To|OT\nShift|THC|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nGang Hour|Rate\nTonne|Remark|agmt_dtl_rmk";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tml_cntr_sty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },		                   
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"auto_calc_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_vol_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"thrp_lgs_cost_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tml_trns_mod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"wkdy_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sat_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sun_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hol_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dg_none",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"same_dg_none",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"same_dg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sep_dg_none",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n1st_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n2nd_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n3rd_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n4th_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n5th_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n6th_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n7th_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n8th_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n9th_clss_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_tr_vol_val",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_tr_vol_val",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tml_ovt_shft_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"thc_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d5",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d7",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d8",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d9",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dw",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dx",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"r2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"r4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"r5",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"r7",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"f2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"f4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"f5",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"o2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"o4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"t2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"t4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"a2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"a4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"p2",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"p4",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"teu_rate",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"box_rate",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"move_rate",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },							
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"gang_hour_rate",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tonne_rate",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"remark",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"agmt_dtl_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
							
				InitColumns(cols);
				
				SetEditable(1);
				//SetRangeBackColor(1, 7, 1, 12,"#DEFBF8");// TEMP CLOSE
				//SetRangeBackColor(1, 13, 2, 25,"#DEFBF8");// TEMP CLOSE
				//SetRangeBackColor(1, 25, 1, 57,"#DEFBF8");// TEMP CLOSE
				SetColProperty("thc_tp_cd", {ComboText:" |GIO|LIFT|BOTH", ComboCode:thc_tp_cdCode} );
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
				//no support[check again]CLT style.height=GetSheetHeight(15);
				resizeSheet();//SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
			}
		break;
		
		case 2:   //t2sheet1 init
			with(sheetObj){
				//no support[check again]CLT style.height=GetSheetHeight(16);
				
				var HeadTitle0="Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|DG Class for Free Day|"
				+ "Exclude Date|Exclude Date|Exclude Date|"
				+ "DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|DG Class For Rate|"
				+ "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Days|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Remark";
				var HeadTitle1="Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "SA|SU|Ho|"
				+ "None|Same|Same|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|Separate|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Remark";
				var HeadTitle2="Cost Code|F/M|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "SA|SU|Ho|"
				+ "None|No DG|DG|No DG|1|2|3|4|5|6|7|8|9|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Remark";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:2, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tml_cntr_sty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_vol_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tml_sto_agmt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmnc_hrmnt",             KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dg_none_fd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"same_dg_none_fd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"same_dg_fd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sep_dg_none_fd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n1st_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n2nd_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n3rd_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n4th_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n5th_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n6th_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n7th_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n8th_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n9th_clss_flg_fd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sat_flg_fd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sun_flg_fd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hol_flg_fd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dg_none_r",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"same_dg_none_r",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"same_dg_r",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sep_dg_none_r",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n1st_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n2nd_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n3rd_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n4th_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n5th_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n6th_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n7th_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n8th_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_n9th_clss_flg_r",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_tr_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_tr_dys",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fp_calc_prd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
							
							{Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fp_teu_qty",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d5_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d7_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d8_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d9_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dw_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dx_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r5_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r7_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"f2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"f4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"f5_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"o2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"o4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"t2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"t4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"a2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"a4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p2_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p4_fd",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d5_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d7_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d8_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"d9_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dw_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dx_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r5_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"r7_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"f2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"f4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"f5_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"o2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"o4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"t2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"t4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"a2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"a4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p2_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Float",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"p4_r",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"teu_rate",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"box_rate",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"move_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tonne_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"remark",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"agmt_dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				//SetCellBackColor(1,7,"#DEFBF8");//
				//SetRangeBackColor(1, 8, 2, 21,"#DEFBF8");//
				//SetRangeBackColor(1, 20, 1, 23,"#DEFBF8");//
				//SetRangeBackColor(1, 24, 2, 35,"#DEFBF8");//
				//SetRangeBackColor(1, 36, 2, 90,"#DEFBF8");//
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
				//no support[check again]CLT style.height=GetSheetHeight(15);
				resizeSheet();//SetSheetHeight(ComGetSheetHeight(sheetObj, 15));			
			}
		break;
		
		case 3:   //t3sheet1( EQ Storage Rate List Tab) init 
			with(sheetObj){
			
				var HeadTitle0="Cost Code|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "Exclude Date|Exclude Date|Exclude Date|"
				+ "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|"
				+ "Days|Days|Days|Days|Days|Days|"
				+ "Days|Days|Days|"
				+ "Rate|Rate|Rate|Rate|Rate|Rate|"
				+ "Rate|Rate|Rate|"									              
				+ "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				
				var HeadTitle1="Cost Code|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
				+ "SA|SU|Ho|"
				+ "From|To|Cal.\nPeriod|Pool\nTEU|"
				+ "SL2|TA2|GN4|EG5|CH2|CH4|CLG|UMG|Chassis-\nGenset|" 
				+ "SL2|TA2|GN4|EG5|CH2|CH4|CLG|UMG|Chassis-\nGenset|"
				+ "Rate\nTEU|Rate\nBox|Rate\nMove|Rate\nTonne|Verify\nResult|Remark";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1,MaxSort:7  } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"}];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_vol_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tml_sto_agmt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cmnc_hrmnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
							{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sat_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sun_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"hol_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Int",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Text",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fp_calc_prd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fp_teu_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sl2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ta2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gn4_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eg5_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch4_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							
							{Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clg_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"umg_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"com_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sl2_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ta2_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gn4_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eg5_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch2_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch4_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clg_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"umg_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"com_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"teu_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"box_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"move_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tonne_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"remark",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"agmt_dtl_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"xcld_dy_aply_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:250,  Align:"Center",  ColMerge:1,   SaveName:"ts_rt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"vrfyflg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_dtl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
				
				InitColumns(cols);
				SetEditable(1);
				resizeSheet();//SetSheetHeight(380);
				
				SetRangeBackColor(1, 7, 1, 31,"#555555");//
				SetRangeBackColor(2, 7, 2, 31,"#555555");//
				//					              SetRangeBackColor(1, 23, 1, 26,"#555555");//
				//					              SetRangeBackColor(1, 27, 2, 38,"#555555");//
				//					              SetRangeBackColor(1, 39, 1, 92,"#555555");//
				
				SetColProperty(sheetNo+"cmnc_hrmnt", {Format:"##:##"} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
			}
		break;      
		
		case 4:   //main_hidden
			with(sheetObj){
				//no support[check again]CLT style.height=GetSheetHeight(5);
				var HeadTitle="Yard Code|Contract Office|Vendor Code|Vendor Name|Effective From DT|Creation Date|Update Date|Auto Extension|Effective To Dt|Creation User|Update User|Yard Name";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:1, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cre_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Date",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eff_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Date",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Date",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"upd_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"auto_xtd_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Date",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eff_to_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"yd_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 5));
			}
		break;               
	}    
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
    ComResizeSheet(sheetObjects[1]);
    ComResizeSheet(sheetObjects[2]);
}

/**
 * Sheet Cell PopupClick Event
 * Terminal Rate List Tab
 * 
 * @param {sheetObj}  	Sheet Object
 * @param {row}  		Row No
 * @param {col}  		Column No
 */
function t1sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";
    var myWin = window.open('', "popagmtcrermk3", myOption);
    myWin.focus();
    formObj.pop_cost_cd.value = sheetObjects[0].GetCellValue(row, "lgs_cost_cd");
    formObj.pop_sheetObj.value = "t1sheet1";
    formObj.pop_row.value = row;
    formObj.pop_agmt_rmk.value = sheetObjects[0].GetCellValue(row, "agmt_dtl_rmk");
    formObj.pop_mode.value = "inquiry"
    formObj.action = 'ESD_TES_9080.screen';
    formObj.target = 'popagmtcrermk3';
    formObj.submit();
}

/**
 * Sheet Cell PopupClick Event
 * Storage Rate List Tab
 * 
 * @param {sheetObj}  	Sheet Object
 * @param {row}  		Row No
 * @param {col}  		Column No
 */
function t2sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    var myOption = "width=410,height=420,menubar=0,status=0,scrollbars=0,resizable=0";
    var myWin = window.open('', "popagmtcrermk4", myOption);
    myWin.focus();
    formObj.pop_cost_cd.value = sheetObjects[1].GetCellValue(row, "lgs_cost_cd");
    formObj.pop_sheetObj.value = "t2sheet1";
    formObj.pop_row.value = row;
    formObj.pop_agmt_rmk.value = sheetObjects[1].GetCellValue(row, "agmt_dtl_rmk");
    formObj.pop_mode.value = "inquiry"
    formObj.action = 'ESD_TES_9080.screen';
    formObj.target = 'popagmtcrermk4';
    formObj.submit();
}

/**
 * handling sheet process
 * 
 * @param {ibsheet}		sheetObj  	IBSheet Object
 * @param {Obejct}		formObj  	Form Object
 * @param {String}		sAction  	Action Command
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TES_0040GS.do", tesFrmQryStr(formObj)); // main_hidden_OnSearchEnd			
            break;
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

/**
 * handling sheet process
 * Terminal Rate List, Storage Rate List Tab
 * 
 * @param {sheetObj}  	Sheet Object
 * @param {formObj}  	Form Object
 * @param {sAction}  	Action Command
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH01;
            var sXml = sheetObj.GetSearchData("ESD_TES_0040_02GS.do", tesFrmQryStr(formObj));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 }); // t1sheet1_OnSearchEnd  t2sheet1_OnSearchEnd
            }
            sheetObj.RemoveEtcData();
            sXml = null;
            arrXml = null;
            break;
        case IBDOWNEXCEL:
            sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            break;
    }
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * 
 * @param {ibtab}		tab_obj  	Tab Object
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * Initialization Tab
 * 
 * @param {ibtab}		tabobj  	Tab Object
 * @param {int,string}	tabNo		Tab No
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("Terminal Rate List", "");
                InsertItem("Storage Rate List", "");
                InsertItem("CHS / MGS Storage Rate List", "");
            }
            break;
    }
}

/**
 * only English and numbers permitted
 * 
 * @param {Object}		obj  	Object
 */
function isApNum(obj) {
    if (!ComIsAlphabet(obj, "n")) {
        obj.value = '';
    }
}

/**
 * only numbers and ',' permitted
 * 
 * @param {Object}		obj  	Object
 */
function isNumPod(obj) {
    //숫자, '.'만..
    if (!ComIsNumber(obj, ".")) {
        obj.value = '';
    }
}

/**
 * only numbers permitted
 * 
 * @param {Object}		obj  	Object
 */
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * only numbers permitted
 * 
 * @param {Object}		obj  	Object
 * @param {string}		val  	Value
 */
function isNum2(val, obj) {
    if (!ComIsNumber(val)) {
        obj.value = '';
    }
}

/**
 * only English permitted
 * 
 * @param {Object}	obj  	Object
 */
function isAlpha(obj) {
    if (ComIsAlphabet(obj)) {
        obj.value = '';
    }
}

/**
 * set add Period
 * 
 * @param {Object}		obj  	Object
 */
function addPeriod(obj) {
    var tmp_agmt_ver = '';
    if (getStrLen(obj.value) <= 2) {
        if (event.keyCode != 8) isNum(obj);
    }
    if (getStrLen(obj.value) == 4) {
        var tmp = obj.value.substr(3, 1);
        if (tmp == '.') {
            tmp_agmt_ver = obj.value.substr(0, 3);
            obj.value = tmp_agmt_ver;
        }
    }
    if (getStrLen(obj.value) > 4) {
        var tmp = obj.value.substr(3, 2);
        if (event.keyCode != 8) isNum2(tmp, obj);
    }
    if (getStrLen(obj.value) == 3) {
        var tmp = obj.value.substr(2, 1);
        if (tmp != '.') {
            if (event.keyCode != 8) obj.value = '';
        }
    }
    if (getStrLen(obj.value) == 2) {
        if (event.keyCode != 8) {
            tmp_agmt_ver = obj.value;
            obj.value = tmp_agmt_ver + '.';
        }
    }
}

/**
 * Input Value Check
 * 
 * @param {Object}		obj  	Object
 */
function chkInput(obj) {
    if (obj.maxLength < getStrLen(obj.value)) {
        obj.value = '';
        obj.focus();
        return false;
    }
}

/**
 * get String Length
 * 
 * @param {string}		src  	Source
 */
function getStrLen(src) {
    src = new String(src);
    var byteLength = 0;
    for (var inx = 0; inx < src.length; inx++) {
        var oneChar = escape(src.charAt(inx));
        if (oneChar.length == 1) {
            byteLength++;
        } else if (oneChar.indexOf("%u") != -1) {
            byteLength += 2;
        } else if (oneChar.indexOf("%") != -1) {
            byteLength += oneChar.length / 3;
        }
    }
    return byteLength;
}

/**
 * Agreement No Check.
 * 
 * @param {Object}	obj  	Object
 */
function chkAgmtNo(obj) {
    if (!checkAgmtFormat(obj.value)) {
        ComShowCodeMessage('TES50305');
        obj.value = '';
        obj.select();
        return false;
    }
}

/**
 * Agreement No Format Check 
 * 
 * @param {Object}		obj  	Object
 */
function checkAgmtFormat(dt) {
    var date_regexp = "^([A-Za-z]{3}\\d{5})$";
    if (dt.search(date_regexp) != -1) {
        return true;
    } else {
        return false;
    }
}

/**
 * Agreement Ver No Check..
 * 
 * @param {Object}		obj  	Object
 */
function chkAgmtVer(obj) {
    if (!checkAgmtVerFormat(obj.value)) {
        ComShowCodeMessage('TES50305');
        obj.value = '';
        obj.focus();
        return false;
    }
}

/**
 * Agreement Ver No Check.
 * 
 * @param {Object}		obj  	Object
 */
function checkAgmtVerFormat(dt) {
    var ver_regexp = "^(\\d{2}(\\.\\d{2}))$";
    if (dt.search(ver_regexp) != -1) {
        return true;
    } else {
        return false;
    }
}

/**
 * Tab change event
 * 
 * @param {Object|	obj  	Object
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
    beforetab = nItem;
    resizeSheet();
}

/**
 * validation check Agreement No
 * 
 * @param {Object}		obj  	Object
 */
function validate_agmt_no() {
    var formObj = document.form;
    if (ComIsNull(formObj.tml_agmt_ofc_cty_cd.value)) {
        ComShowCodeMessage('TES50304'); // ComShowMessage("Insert Agreement No.!");
        obj.focus();
        return false;
    }
    if (!checkAgmtFormat(formObj.tml_agmt_ofc_cty_cd.value)) {
        ComShowCodeMessage('TES50305');
        formObj.tml_agmt_ofc_cty_cd.value = '';
        //obj.select();
        formObj.tml_agmt_ofc_cty_cd.focus();
        return false;
    }
    return true;
}

/**
 * validation check Agreement Ver No
 * 
 * @param {Object}		obj  	Object
 */
function validate_agmt_ver() {
    var formObj = document.form;
    if (ComIsNull(formObj.tml_agmt_ver_no.value)) {
        ComShowMessage('TES50304'); //"Insert Agreement Version()Information!");
        return false;
    }
    //Input한 AgmtNo.의 길이 체크
    if (formObj.tml_agmt_ver_no.maxLength < getStrLen(formObj.tml_agmt_ver_no.value)) {
        ComShowCodeMessage('TES50305'); // ComShowMessage('Error : Agreement No Length')
        formObj.tml_agmt_ver_no.value = '';
        formObj.tml_agmt_ver_no.focus();
        return false;
    }
    if (!checkAgmtVerFormat(formObj.tml_agmt_ver_no.value)) {
        ComShowCodeMessage('TES50305');
        formObj.tml_agmt_ver_no.value = '';
        formObj.tml_agmt_ver_no.focus();
        return false;
    }
    return true;
}

/**
 * search end event
 * Form Object Value 설정
 * 
 * @param {ibsheet}		main_hidden		IBSheet Object
 * @param {string}		ErrMsg		  	Error Message
 */
function main_hidden_OnSearchEnd(main_hidden, ErrMsg) {
    var formObj = document.form;
    if (main_hidden.RowCount() == 1) {
        formObj.no_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'cre_ofc_cd');
        formObj.no_yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
        
        var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');        
       	if(rtnValue == "Y"){
    		setFormValue(rtnValue);
    	}        
    }
}

/**
 * search end event
 * set tml_trns_mod_cd 
 * 
 * @param {sheetObj}	Sheet Object
 */
function t1sheet1_OnSearchEnd(sheetObj) {
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'tml_trns_mod_cd') == 'S') {
            sheetObj.SetToolTipText(i, 'tml_trns_mod_cd', 'Same');
        } else if (sheetObj.GetCellValue(i, 'tml_trns_mod_cd') == 'T') {
            sheetObj.SetToolTipText(i, 'tml_trns_mod_cd', 'Truck');
        } else if (sheetObj.GetCellValue(i, 'tml_trns_mod_cd') == 'R') {
            sheetObj.SetToolTipText(i, 'tml_trns_mod_cd', 'Rail');
        } else if (sheetObj.GetCellValue(i, 'tml_trns_mod_cd') == 'B') {
            sheetObj.SetToolTipText(i, 'tml_trns_mod_cd', 'Barge');
        } else if (sheetObj.GetCellValue(i, 'tml_trns_mod_cd') == 'F') {
            sheetObj.SetToolTipText(i, 'tml_trns_mod_cd', 'Feeder');
        } else if (sheetObj.GetCellValue(i, 'tml_trns_mod_cd') == 'V') {
            sheetObj.SetToolTipText(i, 'tml_trns_mod_cd', 'Mother');
        }
    }
}

/**
 * search end event
 * tml_sto_agmt_tp_cd 값 설정
 * 
 * @param {ibsheet}		sheetObj	IBSheet Object
 */
function t2sheet1_OnSearchEnd(sheetObj) {
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'tml_sto_agmt_tp_cd') == 'FD') {
            sheetObj.SetToolTipText(i, 'tml_sto_agmt_tp_cd', 'Free Day');
        } else if (sheetObj.GetCellValue(i, 'tml_sto_agmt_tp_cd') == 'FP') {
            sheetObj.SetToolTipText(i, 'tml_sto_agmt_tp_cd', 'Free Pool');
        }
    }
}

/**
 * set value
 * 
 * @param {object}	obj  	Object
 */
function setValue(obj) {
    ComShowMessage(obj.value)
    obj.value = obj.value;
}

/**
 * Invoice Summary List Report Print.
 * 
 * @param {object}	obj  	Object
 */
function printInvoiceSummary() {
    var fromObj = new Array();
    var rdObj = new Array();

    fromObj[0] = document.form;
    rdObj[0] = sheetObjects[3]; //main_hidden
    rdObj[1] = sheetObjects[0]; //Terminal Rate
    rdObj[2] = sheetObjects[1]; //Storage Rate
    rdObj[3] = sheetObjects[2]; //EQ Storage Rate
    parmObj[0] = "1";
    parmObj[1] = "";
    parmObj[2] = "N";
    parmObj[3] = RD_path + "apps/opus/esd/tes/serviceprovideragreementmanage/terminalagreementmanage/report/ESD_TES_0804.mrd";
    parmObj[4] = rdObj;
    parmObj[5] = fromObj;
    rdObjModaless(RdReport, parmObj, 1000, 700);
}

/** setFormValue()
 * 
 * @return
 */
function setFormValue(argValue) {
    if (argValue.trim() == "Y") {
        var formObj = document.form;
        formObj.yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
        formObj.ctrt_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'ctrt_ofc_cd');
        formObj.vndr_seq.value = sheetObjects[3].GetCellValue(1, 'vndr_seq');
        formObj.vndr_abbr_nm.value = sheetObjects[3].GetCellValue(1, 'vndr_abbr_nm');
        formObj.eff_fm_dt.value = sheetObjects[3].GetCellValue(1, 'eff_fm_dt');
        formObj.cre_dt.value = sheetObjects[3].GetCellValue(1, 'cre_dt');
        formObj.upd_dt.value = sheetObjects[3].GetCellValue(1, 'upd_dt');
        formObj.auto_xtd_flg.value = sheetObjects[3].GetCellValue(1, 'auto_xtd_flg');
        formObj.eff_to_dt.value = sheetObjects[3].GetCellValue(1, 'eff_to_dt');
        formObj.cre_usr_id.value = sheetObjects[3].GetCellValue(1, 'cre_usr_id');
        formObj.upd_usr_id.value = sheetObjects[3].GetCellValue(1, 'upd_usr_id');
        formObj.no_cre_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'cre_ofc_cd');
        doActionIBSheet2(sheetObjects[0], document.form, IBSEARCH);
    } else {
        ComShowMessage(ComGetMsg('TES50202'));
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[3].RemoveAll();
    }
}