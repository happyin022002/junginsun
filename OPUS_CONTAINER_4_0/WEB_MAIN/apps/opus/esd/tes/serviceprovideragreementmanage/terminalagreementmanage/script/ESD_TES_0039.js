/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0039.js
*@FileTitle : Terminal Agreement Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
// Common variables.
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var fromObj = new Array();
var rdObj = new Array();
var parmObj = new Array();

/**
 * Register IBSheet object on sheetObjects array.
 * 
 * @param {ibsheet}	sheet_obj  	Sheet Object
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Coding event handler for body tag's OnLoad.
 * Add  pre-process functions after loading by browser.
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }

    document.form.yd_cd.focus();

    // 20140808[9014787] EnterKey Event
    axon_event.addListener('keydown', 'ComKeyEnter', 'form');
}

/**
 * Defining button events. 
 **/
document.onclick = processButtonClick;

/**
 *  Handling button event. 
 **/
function processButtonClick() {
    /***** Setting each tab's sheet variable. *****/
    var sheetObject = sheetObjects[0];
    var sheetObject2 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_minimize":
                if (document.all.MiniLayer.style.display != "none") {
                    document.all.MiniLayer.style.display = "none";
                    ComResizeSheet(sheetObjects[0]);
                } else {
                    document.all.MiniLayer.style.display = "";
                    sheetObjects[0].SetSheetHeight(ComGetSheetHeight(sheetObjects[0], 7));
                    resizeSheet();
                }                
                break;
            case "btn_retrieve":
                if (!ComIsNull(formObject.eff_on.value)) {
                    if (!ComIsDate(formObject.eff_on)) {
                        ComShowCodeMessage('TES10079');
                        return false;
                    }
                }
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;

            case "btn_new":
                sheetObject.RemoveAll();
                formObject.reset();
                document.form.yd_cd_hidden.value = '';
                break;

            case "btn_yard":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 500, 'getYard', dispaly);
                } else {
                    ComShowCodeMessage('TES10004');
                    return;
                }
                break;

            case "btn_vndr":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
                // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 520, 'getVender', dispaly);
                } else {
                    ComShowCodeMessage('TES10004');
                    return;
                }
                break;

            case "btns_calendar":
                var cal = new ComCalendar();
                cal.select(formObject.eff_on, 'yyyy-MM-dd');
                break;

            case "btng_adjustmentscreen":
                if (sheetObjects[0].GetSelectRow() == 1 || sheetObjects[0].GetSelectRow() == 0) {
                    ComShowCodeMessage('TES10080');
                    return false;
                }

                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 0) == "" || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "agmt_no") == "" || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ver_no") == "") {
                    ComShowCodeMessage('TES10081');
                    return false;
                }

                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cre_ofc_cd") != ofc_cd) {
                    ComShowCodeMessage('TES50203'); // Change creation office code 
                    return false;
                }

                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tml_agmt_sts_cd") == "C") {
                    var reg_gb = ComShowConfirm(ComGetMsg('TES10124'));
                } else if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "tml_agmt_sts_cd") == "P") {
                    var reg_gb = true;
                }

                if (reg_gb == true) {
                    var agmt_no = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "agmt_no");
                    var agmt_ver_no = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ver_no");
                    location.href = "ESD_TES_0034.do?pgmNo=ESD_TES_0034&parentPgmNo=ESD_TES_M001&tml_agmt_ofc_cty_cd=" + agmt_no + "&tml_agmt_ver_no=" + agmt_ver_no + "&inquiryFlg=Y&sysCommUiTitle=Terminal Agreement Creation %26 Adjustment&sysCommUiNavigation=Terminal S/O > Agreement > Terminal Agreement Creation %26 Adjustment";
                } else {
                    return false;
                }
                break;

            case "btng_detail":
                if (sheetObjects[0].GetSelectRow() == 1 || sheetObjects[0].GetSelectRow() == 0) {
                    ComShowCodeMessage('TES10080');
                    return false;
                }

                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 0) == "" ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "agmt_no") == "" ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ver_no") == "") {
                    ComShowCodeMessage('TES10081');
                    return false;
                }

                var agmt_no = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "agmt_no");
                var agmt_ver_no = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ver_no");
                if (ComIsNull(agmt_no) || ComIsNull(agmt_ver_no)) {
                    ComShowCodeMessage('TES10081');
                    return false;
                }
                
                formObject.no_ofc_cd.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cre_ofc_cd");
                formObject.no_yd_cd.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "yd_cd");
                
                var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'goDetail');
                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cre_ofc_cd") != ofc_cd) {
	                if(rtnValue.length > 0){	                	
	                	goDetail(rtnValue);
	                }
                } else {goDetail("Y");}
                break;

            case "btng_downexcel":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }
                break;

            case "btng_print":
                if (sheetObjects[0].RowCount('') > 0) {
                    fromObj[0] = formObject; // Set array.
                    rdObj[0] = sheetObjects[0];
                    parmObj[0] = "1";
                    parmObj[1] = "";
                    parmObj[2] = "N";
                    parmObj[3] = RD_path + "apps/opus/esd/tes/serviceprovideragreementmanage/terminalagreementmanage/report/ESD_TES_0803.mrd";
                    parmObj[4] = rdObj;
                    parmObj[5] = fromObj;
                    rdObjModaless(RdReport, parmObj, 1000, 700);
                } else {
                    ComShowMessage(ComGetMsg('TES10078'));
                }
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
 * Initialize sheets.
 * Coding initial modules as sheet's count.
 * 
 * @param {ibsheet}		sheetObj  	IBSheet Object
 * @param {int,String}	sheetNo  	Serial number for sheet object's ID.
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){			
				var HeadTitle="Seq.|Agreement\r\nNo.|Agreement\r\nVer.|Yard Code|S/P\r\nCode|S/P\r\nName(ABBR)|Effective Date|Effective Date|Auto Extension\r\nY/N|Contract Office|Creation Office|Currency|Creation Date|Creation User ID|Update Date|Update User ID|Deleted\r\nY/N|AGMT\r\nStatus" ;
				var HeadTitle1="Seq.|Agreement\r\nNo.|Agreement\r\nVer.|Yard Code|S/P\r\nCode|S/P\r\nName(ABBR)|From|To|Auto Extension\r\nY/N|Contract Office|Creation Office|Currency|Creation Date|Creation User ID|Update Date|Update User ID|Deleted\r\nY/N|AGMT\r\nStatus" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ver_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_fm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_to_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"auto_xtd_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tml_agmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
				//SetRangeBackColor(1, 6, 1, 7,"#DEFBF8");//
				SetRowHeight(0,10);
				SetRowHeight(1,10);
				//no support[check again]CLT 					style.height=GetSheetHeight(15);
				//resizeSheet();//SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
				SetSheetHeight(ComGetSheetHeight(sheetObj, 7));
			}
		break;
		
		case 2:   //t1sheet1 init
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
				//SetColProperty("thc_tp_cd", {ComboText:" |GIO|LIFT|BOTH", ComboCode:thc_tp_cdCode} );
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
				//no support[check again]CLT style.height=GetSheetHeight(15);
				resizeSheet();//SetSheetHeight(ComGetSheetHeight(sheetObj, 15));
			}
		break;
		
		case 3:   //t2sheet1 init
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
		
		case 4:   //t3sheet1( EQ Storage Rate List Tab) init 
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
				
				//SetColProperty(sheetNo+"cmnc_hrmnt", {Format:"##:##"} );
				SetCountFormat("[SELECTDATAROW / ROWCOUNT]");
				SetHeaderRowHeight(21);
				SetHeaderRowHeight(20);
			}
		break;      
		
		case 5:   //main_hidden
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
    //ComResizeSheet(sheetObjects[0]);
    ComResizeSheet(sheetObjects[1]);
    ComResizeSheet(sheetObjects[2]);
    ComResizeSheet(sheetObjects[3]);
}

/**
 *  Coding retrieve, save...
 * 
 * @param {sheetObj}  	Sheet Object
 * @param {formObj}  	Form Object
 * @param {sAction}  	Action Command
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: // retrieve
            sheetObjects[1].RemoveAll();
            sheetObjects[2].RemoveAll();
            sheetObjects[3].RemoveAll();          
            
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TES_0039GS.do", tesFrmQryStr(formObj));
            break;
            
        case IBDOWNEXCEL: // Downloading excel.
            //            	sheetObj.Down2Excel(-1, false, false, true);            	
            if (sheetObj.RowCount() < 1) {
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1, Merge: 1 });
            }
            break;
            
        case IBLOADEXCEL: // Uploading excel.
            sheetObj.LoadExcel();
            break;

        case IBSEARCH_ASYNC04:
            formObj.f_cmd.value = SEARCH16;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0039GS.do", tesFrmQryStr(formObj));
            var ydNm = ComGetEtcData(searchXml, "yd_nm");
            formObj.yd_cd_name.value = ydNm;
            validateYardCode();
            searchXml = null;
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0039GS.do", tesFrmQryStr(formObj));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;
            break;
            
       	case IBSEARCH_ASYNC06: // main_hidden
            formObj.f_cmd.value = SEARCH;
            
            formObj.tml_agmt_ofc_cty_cd.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "agmt_no");
            formObj.tml_agmt_ver_no.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ver_no");
            
            sheetObjects[4].DoSearch("ESD_TES_0040GS.do", tesFrmQryStr(formObj)); //  main_hidden_OnSearchEnd	
            break;
            
        case IBSEARCH_ASYNC07: //Retrieve Detail            
            formObj.f_cmd.value = SEARCH01;
            var sXml = sheetObjects[1].GetSearchData("ESD_TES_0040_02GS.do", tesFrmQryStr(formObj));
            var arrXml = sXml.split("|$$|");
           
            sheetObjects[1].LoadSearchData(arrXml[0], { Sync: 1 }); // t1sheet1_OnSearchEnd  
            sheetObjects[2].LoadSearchData(arrXml[1], { Sync: 1 }); // t2sheet1_OnSearchEnd
            sheetObjects[3].LoadSearchData(arrXml[2], { Sync: 1 }); //  
           
            sheetObj.RemoveEtcData();
            sXml = null;
            arrXml = null;
            break;
    }
}

/**
 * After completing sheet retrieve, functions. 
 * 
 * @param {ibsheet}		sheetObj	sheet Objcet
 **/
function sheet1_OnSearchEnd(sheetObj) {
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'tml_agmt_sts_cd') == 'P') {
            sheetObj.SetToolTipText(i, 'tml_agmt_sts_cd', 'Processing');
        } else if (sheetObj.GetCellValue(i, 'tml_agmt_sts_cd') == 'C') {
            sheetObj.SetToolTipText(i, 'tml_agmt_sts_cd', 'Confirmed');
        }
    }
}

/**
 * Setting yard information.
 * 
 * @param {Array}	rowArray  	rowArray
 */
function getYard(rowArray) {
    var colArray = rowArray[0];
    document.all.yd_cd.value = colArray[3];
    document.all.yd_cd_name.value = colArray[4];
}

/**
 * getYardName
 * @return
 */
function getYardName() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        return false;
    }
    validateYardCode("yd_cd_name");   // doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
}

/**
 * Setting vendor information.
 * 
 * @param {Array}	rowArray  	rowArray
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];
    //document.all.vndr_seq.value = colArray[6];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * Validating yard code.
 * 
 */
function validateYardCode(argColNm) {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        return false;
    }
    
    if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value.trim() == '') || formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()) {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        
        var rtnVal = getYdCdValid(argColNm); // tes_getInputValue('is_valid_yd_cd', SEARCH20, 'yd_cd', 'checkValidYardCode');   
        
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }
    }
}

/**
 * Validating yard code.
 * 
 */
function checkValidYardCode(rtnVal) {
    var formObj = document.form;
    var tmp = '';
    if (rtnVal != undefined && rtnVal != null && rtnVal.trim() != '') {
        tmp = rtnVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                // 					formObj.yd_cd_name.value=(tmp[2]!=undefined&&tmp[2]!=null?tmp[2]:'');
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                formObj.yd_cd_deltflg.value = (tmp[9] != undefined && tmp[9] != null ? tmp[9] : '');
                if (formObj.yd_cd_deltflg.value == "Y") {
                    ComShowMessage(ComGetMsg('TES10129'));
                }
            } else {
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                formObj.yd_cd.value = '';
                formObj.yd_cd_name.value = '';
                ComShowMessage(ComGetMsg('TES10066'));
            }
        } else {
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            formObj.yd_cd.value = '';
            formObj.yd_cd_name.value = '';
            ComShowMessage(ComGetMsg('TES10066'));
        }
    } else {
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        formObj.yd_cd.value = '';
        formObj.yd_cd_name.value = '';
        ComShowMessage(ComGetMsg('TES10066'));
    }
}

/**
 * Validating vendor code.
 * 
 */
function validateVendorCode() {
    var formObj = document.form;
    if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
        return false;
    }
    
    if (formObj.vndr_seq.value.length < 6) {
        formObj.vndr_seq.value = tes_lpad(formObj.vndr_seq.value, 6, 0);
    }
    
    if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
        formObj.vndr_seq_hidden.value = '';
        formObj.is_valid_vndr_seq.value = '';
        
        var rtnVal = getVndrSeqValid("vndr_seq_name");
        
        if(rtnVal.length > 0){
        	checkValidVendorCode(rtnVal);
        }
        //doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCHLIST01, 'vndr_seq', 'checkValidVendorCode');
    }
}

/**
 * Validating vendor code.
 * 
 */
function checkValidVendorCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                // 					formObj.vndr_seq_name.value=(tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
                formObj.vndr_seq_deltflg.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
                if (formObj.vndr_seq_deltflg.value == "Y") {
                    ComShowMessage(ComGetMsg('TES10130'));
                }
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                ComShowMessage(ComGetMsg('TES10067'));
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            ComShowMessage(ComGetMsg('TES10067'));
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        ComShowMessage(ComGetMsg('TES10067'));
    }
}

/** goDetail()
 * 
 * @return
 */
function goDetail(argVal) {
    if (argVal == "Y") {
        location.href = "ESD_TES_0040.do?pgmNo=ESD_TES_0040&parentPgmNo=ESD_TES_M001&agmt_no=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "agmt_no") + "&agmt_ver_no=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ver_no") + "&sysCommUiTitle=Detail&sysCommUiNavigation=Terminal S/O > Agreement > Terminal Agreement Inquiry";        
    } else {
        ComShowMessage(ComGetMsg('TES50202'));
    }
}

/**
 * Input Value Check
 * 
 * @param {Object}	obj  	Object
 */
function chkInput(obj) {
    if (obj.maxLength < getStrLen(obj.value)) {
        obj.value = ''; //substring(obj.value,0,obj.maxLength);
        obj.focus();
        return false;
    }
}

/**
 * Checking number value.
 * 
 * @param {Object}	obj  	Object
 */
function isNum1(obj) {
    if (!ComIsNumber(obj, "-")) {
        obj.value = '';
    }
}

/**
 * English/Checking number value.
 * 
 * @param {Object}	obj  	Object
 */
function isApNum2(obj) {
    if (!ComIsAlphabet(obj, 'n')) {
        obj.value = '';
    }
    obj.value = obj.value.toUpperCase();
}

/**
 * Checking number value.
 * 
 * @param {Object}	obj  	Object
 */
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * Initialization Tab
 * 
 * @param {ibtab}		tabobj  	Tab Object
 * @param {int,string}	tabNo		Tab No
 */    
function initTab(tabObj , tabNo) {
     switch(tabNo) {
         case 1:
            with (tabObj) {
                var cnt=0 ;
                InsertItem( "Terminal Rate List" , "");
                InsertItem( "Storage Rate List" , "");
                InsertItem( "CHS / MGS Storage Rate List" , "");
            }
         break;
     }
}

/**
 * Tab change event
 * 
 * @param {Object|	obj  	Object
 */    
function tab1_OnChange(tabObj , nItem) {
    var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
	beforetab=nItem;
	resizeSheet();
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * 
 * @param {ibtab}		tab_obj  	Tab Object
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++]=tab_obj;
}

function sheet1_OnDblClick(sheetObj, row, col) {
    var formObj = document.form;
    
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();  
    
    formObj.no_ofc_cd.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cre_ofc_cd");
    formObj.no_yd_cd.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "yd_cd");
    
    var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'goDetail');
    if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "cre_ofc_cd") != ofc_cd) {
	    if(rtnValue == "Y"){
	    	doActionIBSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC06);
	    } else {
	    	ComShowMessage(ComGetMsg('TES50202'));  // No authority to make inquiry to the agreement with your log-in office. Only agreement details of yards in your region can be retrieved.
	    } 
    } else {doActionIBSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC06);}

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
    if (sheetObjects[4].RowCount() == 1) {
        formObj.no_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'cre_ofc_cd');
        formObj.no_yd_cd.value = sheetObjects[4].GetCellValue(1, 'yd_cd');
        
//        formObj.yd_cd.value = sheetObjects[4].GetCellValue(1, 'yd_cd');
//        formObj.ctrt_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'ctrt_ofc_cd');
//        formObj.vndr_seq.value = sheetObjects[4].GetCellValue(1, 'vndr_seq');
//        formObj.vndr_abbr_nm.value = sheetObjects[4].GetCellValue(1, 'vndr_abbr_nm');
//        formObj.eff_fm_dt.value = sheetObjects[4].GetCellValue(1, 'eff_fm_dt');
//        formObj.cre_dt.value = sheetObjects[4].GetCellValue(1, 'cre_dt');
//        formObj.upd_dt.value = sheetObjects[4].GetCellValue(1, 'upd_dt');
//        formObj.auto_xtd_flg.value = sheetObjects[4].GetCellValue(1, 'auto_xtd_flg');
//        formObj.eff_to_dt.value = sheetObjects[4].GetCellValue(1, 'eff_to_dt');
//        formObj.cre_usr_id.value = sheetObjects[4].GetCellValue(1, 'cre_usr_id');
//        formObj.upd_usr_id.value = sheetObjects[4].GetCellValue(1, 'upd_usr_id');
//        formObj.no_cre_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'cre_ofc_cd');
        
        doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC07);
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


