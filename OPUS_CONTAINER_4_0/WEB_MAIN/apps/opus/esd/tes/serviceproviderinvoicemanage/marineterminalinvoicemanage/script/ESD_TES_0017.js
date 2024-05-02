/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0017.js
*@FileTitle  :  Marine Terminal Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
// global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var beforetab2 = 1;
var tot_page = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var io_hidden = ''
var auth_ofc_main_hidden_xml = '';
var comboObjects = new Array();
var comboCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3]; //main_hidden
    var vvd_hidden = sheetObjects[4];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                var tmp_inv_no = formObject.inv_no.value;
                var tmp_vndr_seq = formObject.vndr_seq.value;
                var tmp_vndr_nm = formObject.vndr_seq_name.value;
                if (tmp_inv_no == null || tmp_inv_no == '') {
                    if (tmp_vndr_seq == null || tmp_vndr_seq == '') {
                        ComShowCodeMessage('TES21501'); //showErrMessage('Pleas Input Invoice No & Vendor Code!');
                        return;
                    } else {
                        ComShowCodeMessage('TES21502'); //showErrMessage('Please Input Invoice No!');
                        return;
                    }
                } else {
                    if (tmp_vndr_seq == null || tmp_vndr_seq == '') {
                        ComShowCodeMessage('TES21503'); //showErrMessage('Please Input Vendor Code!');
                        return;
                    }
                }
                if (tmp_vndr_seq.length < 6) {
                    ComShowCodeMessage('TES21504'); //showErrMessage('Invaid Vendor Code!');
                    formObject.vndr_seq.value = '';
                    formObject.vndr_seq_name.value = '';
                    //init();
                    formObject.vndr_seq.focus();
                    return;
                }
                formObject.reset();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                sheetObject3.RemoveAll();
                formObject.inv_no.value = tmp_inv_no;
                formObject.vndr_seq.value = tmp_vndr_seq;
                formObject.vndr_seq_name.value = tmp_vndr_nm;
                doActionIBSheet_main_hidden(sheetObject3, formObject, IBSEARCH);
                if (sheetObject3.RowCount() < 1) {
                    ComShowCodeMessage('TES21505', tmp_inv_no, tmp_vndr_seq); //'No Data for\n\nInv No:'+tmp_inv_no+'  &  VNDR Code:'+tmp_vndr_seq
                    return false;
                }
                break;
                
            case "btn_new":
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                formObject.reset();
                formObject.inv_no.focus();
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
                    ComShowCodeMessage('TES21906');
                    return;
                }
                break;
                
            case "btns_remarks":
                if (formObject.tml_so_seq.value == null || formObject.tml_so_seq.value == '') {
                    return false;
                }
                ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=' + $('#hld_rmk').val() + '&isZZ=Y', 'popup_remarks', 450, 140, true);
                break;
                
            case "btng_back":
                if (formObject.tml_so_seq.value == null || formObject.tml_so_seq.value == '') {
                    return false;
                }
                if (vvd_hidden.FindText('vvd', formObject.vvd.value + io_hidden) == vvd_hidden.HeaderRows()) {
                    ComShowCodeMessage('TES21022');
                    return false;
                } else {
                    findPage(-1);
                }
                break;
                
            case "btng_next":
                if (formObject.tml_so_seq.value == null || formObject.tml_so_seq.value == '') {
                    return false;
                }
                if (vvd_hidden.FindText('vvd', formObject.vvd.value + io_hidden) == vvd_hidden.RowCount()) {
                    ComShowCodeMessage('TES21023');
                    return false;
                } else {
                    findPage(1);
                }
                break;
                
            case "btng_totalamount":
                if (formObject.tml_so_seq.value == null || formObject.tml_so_seq.value == '') {
                    return false;
                }
                var url_str = "ESD_TES_9040Pop.screen";
                ComOpenWindow(url_str, window, "dialogWidth:610px;dialogHeight:370px;help:no;status:no;resizable:yes;", true);
                break;
                
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TES21506');
        } else {
            ComShowMessage(e.message);
        }
    }
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

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * 
 */
function loadPage() {
    for (i = 0; i < comboObjects.length; i++) {
        initCombo(comboObjects[i], i + 1);
    }

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
    var sheetObject3 = sheetObjects[3]; //main_hidden
    var sheetObject4 = sheetObjects[4]; //containerlist_hidden
    var sheetObject5 = sheetObjects[5]; //accmulated_hidden
    var sheetObject6 = sheetObjects[6]; //costcalc_hidden
    var formObject = document.form;
    if (!ComIsNull(formObject.inv_no_tmp.value)) {
        // [TES] special character, characterSet problem
        formObject.inv_no.value = formObject.inv_no_tmp.value;
        formObject.vndr_seq.value = vndr_seq;
        chkInput(formObject.vndr_seq);
        doActionIBSheet_main_hidden(sheetObject3, formObject, IBSEARCH);
    }
}

/**
 * IBCombo Object
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param (object)	combo_obj	combo object
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/** 
 * Initialization Combo list
 * @param {comoObj}	comboObj	combo Object
 * @param {int}		comboNo 	combo no
 * @param {String}	combo_val 	combo value
 * @param {String}	def_val 	def value 
 */
function initCombo(comboObj, comboNo, combo_val, def_val) {
    var cnt = 0;
    switch (comboNo) {
        case 1: //currency
            with(comboObj) {
                SetColAlign(0, "center");
                SetColWidth(0, 100);
                SetDropHeight(200);
                SetMultiSelect(true);

                var key = '';
                var val = '';
                for (var i = 0; combo_val != undefined && combo_val != null && i < combo_val.length; i++) {
                    if (combo_val[i] != undefined && combo_val[i] != null) key = combo_val[i];
                    else key = '';
                    if (def_val[i] != undefined && def_val[i] != null) val = def_val[i];
                    else val = '';
                    InsertItem(cnt++, key, key);
                }

            }
            break;
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 * @param(sheet_obj) sheet object
 * @param(sheetNo) sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with(sheetObj){				
				var HeadTitle="SEQ|Page|CNTR No.|Type\r\nSize|F/M|I/O|DG|Working\nDate|IPC|Lane|Sub Trade|T/S|R/D Term|BKG_NO|Verify Result|Remarks";		
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);		
				
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"page",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"locl_ts_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcvde_term_ind_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_con",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"atb_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);		
				SetEditable(1);
				SetSheetHeight(300);
			}
		break;
		
		case 2:      //t2sheet1 init
			with(sheetObj){				
				var HeadTitle="Page|Seq.|Discrepancy Type|CNTR No.|Type\r\nSize|F/M|I/O|DG|Working\nDate|IPC|Lane|Sub Trade|T/S|R/D Term|BKG NO|Remarks";		
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);		
				
				var cols = [ {Type:"Text",      Hidden:1, Width:110,  Align:"Left",    ColMerge:1,   SaveName:"page",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"dscr_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"locl_ts_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:57,   Align:"Center",  ColMerge:0,   SaveName:"rcvde_term_ind_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no_con",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"atb_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);		
				SetEditable(0);
				SetColProperty("dscr_ind_cd", {ComboText:dscr_ind_cdText, ComboCode:dscr_ind_cdCode} );
				resizeSheet();//SetSheetHeight(300);
			}
		break;
		
		case 3:      //t3sheet1 init
			with(sheetObj){				
				var HeadTitle="Calculated Type|Cost Code|Type\r\nSize|I/O|DG|Reefer|Applied\nDate|IPC|Mode|Lane|Sub Trade|Vol.\nTier|Calculated\r\nVol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|Carrier|3rd Party||";		
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);		
				
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"lgs_cost_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tml_wrk_dy_cd",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ioc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tier",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"calc_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rvis_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_rt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"calc_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_crr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_dtl_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
				
				InitColumns(cols);		
				SetEditable(1);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				resizeSheet();//SetSheetHeight(300);
			}
		break;
		
		case 4:      //main_hidden init
			with(sheetObj){
				var HeadTitle="|STS|tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|"
				+"to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_sts_nm|tml_inv_rjct_sts_cd|"
				+"inv_cfm_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|hld_flg|cost_cd_ftr_rmk";		
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);	
					
				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sts",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ttl_calc_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"fm_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"hld_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"to_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_calc_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"sto_dys_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_agmt_ver_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);		
				SetEditable(0);
			}
		break;
		
		case 5:      //vvd_hidden init
			with(sheetObj){		
				var HeadTitle="STATUS|OFC_CTY|SO_SEQ|VVD_SEQ|VSL_CD|VOY_NO|DIR_CD|IO_BND|ATB_DT|VVD_TYPE|CRE_DT|VVD_AMOUNT|VVD";		
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);		
				
				var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_ibflag",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_tml_so_vvd_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_io_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_atb_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_type",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd_amt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);		
				SetEditable(1);
				SetSheetHeight(240);
			}
		break;
		
		case 6:      //sheet_accumulate Vol. init
			with(sheetObj){               
				var HeadTitle="ibflg|pay_vol_qty|accm_seq";		
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pay_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"accm_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);		
				SetEditable(1);
				SetSheetHeight(240);
			}
		break;
		
		case 7:      //total_amt init
			with(sheetObj){				
				var HeadTitle="vvd|io_bnd_cd|cost_cd|inv_amt";		
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );		
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"sum_basis",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);		
				SetEditable(1);
			}
		break;
	}
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[1]);
    ComResizeSheet(sheetObjects[2]);
}

/**
 * main_hidden sheet Coincidency, Discrepancy
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet_main_hidden(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0017GS.do", tesFrmQryStr(formObj));
            var arrXml = searchXml.split("|$$|");
            auth_ofc_main_hidden_xml = arrXml[1];
            sheetObjects[3].LoadSearchData(arrXml[0], { Sync: 1 });
            
            //	            sheetObjects[4].LoadSearchXml(arrXml[1]);
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            /* 
				//parameter changed[check again]CLT 	            var searchXml=sheetObj.GetSearchData("ESD_TES_0017GS.do", FormQueryString(formObj));
	            sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
	            var sxml0=sheetObj.GetEtcData("sxml0");
	            var sxml1=sheetObj.GetEtcData("sxml1");
	            sheetObj.RemoveEtcData();
	            sheetObjects[3].LoadSearchData(sxml0,{Sync:1} );
	            sheetObjects[4].LoadSearchData(sxml1,{Sync:1} );
	            searchXml=null; sxml0=null; sxml1=null;          
	            */
            break;
            
        case IBSAVE: //Save
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0017GS.do", tesFrmQryStr(formObj));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;
            break;
    }
}

/**main_hidden Sheet data form
 * @param sheetObj
 * */
function main_hidden_OnSearchEnd(sheetObj) {
    var formObject = document.form;
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject4 = sheetObjects[4];
    if (sheetObj.RowCount() == 1) {
        if (isMarineTerminalINV() == false) {
            ComShowCodeMessage('TES21508');
            return false;
        } else {
            formObject.no_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'inv_ofc_cd');
            formObject.no_yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
            
            var strCntCd = document.form.cntCd.value ;              
              
            if(strCntCd == "US" || strCntCd == "CA" ){  //로그인 유저가 US, CA 인 경우 오피스 체크를 하지 않는다. 2016-03-03 by 김용진
            	var formObject = document.form;
		        formObject.tml_so_ofc_cty_cd.value = sheetObjects[3].GetCellValue(1, 'tml_so_ofc_cty_cd');
		        formObject.tml_so_seq.value = sheetObjects[3].GetCellValue(1, 'tml_so_seq');
		        formObject.inv_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'inv_ofc_cd');
		        formObject.cost_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'cost_ofc_cd');
		        formObject.yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
		        formObject.yd_nm.value = sheetObjects[3].GetCellValue(1, 'yd_nm');
		        formObject.curr_cd.value = sheetObjects[3].GetCellValue(1, 'curr_cd');
		        formObject.hld_flg.value = sheetObjects[3].GetCellValue(1, 'hld_flg');
		
		        formObject.hld_rmk.value = sheetObjects[3].GetCellValue(1, 'hld_rmk');
		        formObject.iss_dt.value = sheetObjects[3].GetCellValue(1, 'iss_dt');
		        formObject.rcv_dt.value = sheetObjects[3].GetCellValue(1, 'rcv_dt');
		        formObject.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[3].GetCellValue(1, 'ttl_inv_amt'));
		        formObject.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[3].GetCellValue(1, 'whld_tax_amt'));
		        formObject.vat_amt.value = tes_chkAmtFmt(sheetObjects[3].GetCellValue(1, 'vat_amt'));
		        formObject.pay_due_dt.value = sheetObjects[3].GetCellValue(1, 'pay_due_dt');
		
		        formObject.cost_cd_ftr_rmk.value = sheetObjects[3].GetCellValue(1, 'cost_cd_ftr_rmk');
		
		        if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'R') {
		            formObject.tml_inv_sts_cd.value = 'Received';
		        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
		            formObject.tml_inv_sts_cd.value = 'Confirmed';
		        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'P') {
		            formObject.tml_inv_sts_cd.value = 'AP Interfaced';
		        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'A') {
		            formObject.tml_inv_sts_cd.value = 'Approval Request';
		        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'D') {
		            formObject.tml_inv_sts_cd.value = 'Paid';
		        }
		        
		        if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'NL') {
		            formObject.tml_inv_rjct_sts_cd.value = 'Normal';
		        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
		            formObject.tml_inv_rjct_sts_cd.value = 'Rejected';
		        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RL') {
		            formObject.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
		        }
		        
		        // tes_chkAmtFmtObj(formObject.ttl_inv_amt);
		        // tes_chkAmtFmtObj(formObject.vat_amt);
		        sheetObjects[4].LoadSearchData(auth_ofc_main_hidden_xml, { Sync: 1 });
		        auth_ofc_main_hidden_xml = null;
		
		        if (isMarineTerminalINV() == true) {
		            doActionIBSheet(sheetObjects[4], formObject, IBSEARCH);
		        }            
            } else {            	
            	var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
                if(rtnValue.length > 0){
                	setFormValue(rtnValue);
                }
            }
        }
    }
}

/**
 * Marine Termianal Invoice true, false
 */
function isMarineTerminalINV() {
    var sheetObject = sheetObjects[3];
    if (sheetObject.GetCellValue(1, "tml_inv_tp_cd") == "TM") {
        return true;
    } else {
        return false;
    }
}

/**
 * containerlist_hidden Sheet Coincidency, Discrepancy
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case (IBSEARCH):
            formObj.f_cmd.value = SEARCH01;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0017GS.do", tesFrmQryStr(formObj));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 1 });
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 1 });
            sheetObjects[2].LoadSearchData(arrXml[2], { Sync: 1 });
            sheetObjects[5].LoadSearchData(arrXml[3], { Sync: 1 });
            sheetObjects[6].LoadSearchData(arrXml[4], { Sync: 1 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            arrXml[3] = null;
            arrXml[4] = null;
            break;
            /*              
                sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
            	var sxml0=sheetObj.GetEtcData("sxml0");
            	var sxml1=sheetObj.GetEtcData("sxml1");
            	var sxml2=sheetObj.GetEtcData("sxml2");
            	var sxml3=sheetObj.GetEtcData("sxml3");
            	var sxml4=sheetObj.GetEtcData("sxml4");
            	sheetObj.RemoveEtcData();
            	sheetObjects[0].LoadSearchData(sxml0,{Sync:1} );
            	sheetObjects[1].LoadSearchData(sxml1,{Sync:1} );
            	sheetObjects[2].LoadSearchData(sxml2,{Sync:1} );
            	sheetObjects[5].LoadSearchData(sxml3,{Sync:1} );
            	sheetObjects[6].LoadSearchData(sxml4,{Sync:1} );
            	searchXml=null; sxml0=null; sxml1=null; sxml2=null; sxml3=null; sxml4=null;
                break;
*/
    }
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param tab_obj
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * Initialization Tab
 * @param(tab_obj)
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("Verification", "");
                InsertItem("Discrepancy", "");
                InsertItem("Cost Calculation", "");
            }
            break;
    }
}

/**
 * Tab click event
 * @param(tabObj)
 * @param(nItem)
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
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //            if (!ComIsNumber(formObj.iPage)) {
        //                return false;
        //            }
    }
    return true;
}

function t3sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        var url_str = "ESD_TES_9252Pop.screen";
        url_str = url_str + "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + "&tml_so_seq=" + formObj.tml_so_seq.value;
        url_str = url_str + "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
        url_str = url_str + "&inv_no=" + encodeURIComponent(formObj.inv_no.value);
        url_str = url_str + "&curr_cd=" + formObj.curr_cd.value;
        ComOpenWindow(url_str, window, "dialogWidth:800px;dialogHeight:450px;help:no;status:no;resizable:yes;", true);
    } else if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") == 'SVXXJO') {
            ComShowCodeMessage('TES40021');
            return false;
        }
        if (sheetObj.GetCellValue(row, "lgs_cost_cd") != "TMXXDC" && sheetObj.GetCellValue(row, "calc_tp_cd") == "A") {
            var url_str = "ESD_TES_9072Pop.screen";
            url_str += "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
            url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
            url_str += "&vndr_seq=" + formObj.vndr_seq.value;
            url_str += "&yd_cd=" + formObj.yd_cd.value;
            url_str += "&vvd=" + formObj.vvd.value;
            url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
            url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
            url_str += "&io_bnd_cd=" + sheetObj.GetCellValue(row, "io_bnd_cd");
            url_str += "&dcgo_ind_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
            url_str += "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
            url_str += "&lane_cd=" + sheetObj.GetCellValue(row, "lane_cd");
            url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
            url_str += "&tml_trns_mod_cd=" + sheetObj.GetCellValue(row, "tml_trns_mod_cd");
            url_str += "&cal_vol=" + sheetObj.GetCellValue(row, "calc_vol_qty");
            url_str += "&fm_tr_vol_val=" + sheetObj.GetCellValue(row, "fm_tr_vol_val");
            url_str += "&to_tr_vol_val=" + sheetObj.GetCellValue(row, "to_tr_vol_val");
            url_str += "&rvis_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");
            url_str += "&vol_tr_ut_cd=" + sheetObj.GetCellValue(row, "vol_tr_ut_cd");
            url_str += "&calc_tp_cd=" + sheetObj.GetCellValue(row, "calc_tp_cd");
            url_str += "&cntr_sty_cd=" + sheetObj.GetCellValue(row, "cntr_sty_cd");
            url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
            url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
            url_str += "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
            url_str += "&rc_flg=" + sheetObj.GetCellValue(row, "rc_flg");
            url_str += "&opener_row=" + row;
            ComOpenWindow(url_str, window, "dialogWidth:440px;dialogHeight:450px;help:no;status:no;resizable:yes;", true);
        } else if (sheetObj.GetCellValue(row, "lgs_cost_cd") != "TMXXDC" && sheetObj.GetCellValue(row, "calc_tp_cd") == "M") {
            if (sheetObj.GetCellValue(row, 'lgs_cost_cd') == "SVRHCD" || sheetObj.GetCellValue(row, 'lgs_cost_cd') == "SVRHCC") {
                var url_str = "ESD_TES_9191Pop.screen";
                url_str += "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
                url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
                url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
                url_str += "&vvd=" + formObj.vvd.value;
                url_str += "&yd_cd=" + formObj.yd_cd.value;
                url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
                url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
                url_str += "&io_bnd_cd=" + sheetObj.GetCellValue(row, "io_bnd_cd");
                url_str += "&dcgo_clss_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
                url_str += "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
                url_str += "&lane_cd=" + sheetObj.GetCellValue(row, "lane_cd");
                url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
                url_str += "&vol_tr_ut_cd=" + sheetObj.GetCellValue(row, "vol_tr_ut_cd");
                url_str += "&rh_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");
                url_str += "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
                url_str += "&rc_flg=" + sheetObj.GetCellValue(row, "rc_flg");
                url_str += "&opener_row=" + row;
                ComOpenWindow(url_str, window, "dialogWidth:420px;dialogHeight:420px;help:no;status:no;resizable:yes;", true);
            } else {
                var url_str = "ESD_TES_9072Pop.screen";
                url_str += "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
                url_str += "&tml_so_seq=" + formObj.tml_so_seq.value;
                url_str += "&vndr_seq=" + formObj.vndr_seq.value;
                url_str += "&yd_cd=" + formObj.yd_cd.value;
                url_str += "&vvd=" + formObj.vvd.value;
                url_str += "&lgs_cost_cd=" + sheetObj.GetCellValue(row, "lgs_cost_cd");
                url_str += "&cntr_tpsz_cd=" + sheetObj.GetCellValue(row, "cntr_tpsz_cd");
                url_str += "&io_bnd_cd=" + sheetObj.GetCellValue(row, "io_bnd_cd");
                url_str += "&dcgo_clss_cd=" + sheetObj.GetCellValue(row, "dcgo_ind_cd");
                url_str += "&ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
                url_str += "&lane_cd=" + sheetObj.GetCellValue(row, "lane_cd");
                url_str += "&tml_wrk_dy_cd=" + sheetObj.GetCellValue(row, "tml_wrk_dy_cd");
                url_str += "&tml_trns_mod_cd=" + sheetObj.GetCellValue(row, "tml_trns_mod_cd");
                url_str += "&cal_vol=" + sheetObj.GetCellValue(row, "calc_vol_qty");
                url_str += "&fm_tr_vol_val=" + sheetObj.GetCellValue(row, "fm_tr_vol_val");
                url_str += "&to_tr_vol_val=" + sheetObj.GetCellValue(row, "to_tr_vol_val");
                url_str += "&rvis_div=" + 'N';
                url_str += "&rvis_vol_qty=" + sheetObj.GetCellValue(row, "rvis_vol_qty");
                url_str += "&calc_tp_cd=" + sheetObj.GetCellValue(row, "calc_tp_cd");
                url_str += "&opener_row=" + row;
                url_str += "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
                url_str += "&ctrt_rt=" + sheetObj.GetCellValue(row, "ctrt_rt");
                url_str += "&sub_trd_cd=" + sheetObj.GetCellValue(row, "sub_trd_cd");
                url_str += "&rc_flg=" + sheetObj.GetCellValue(row, "rc_flg");
                ComOpenWindow(url_str, window, "dialogWidth:440px;dialogHeight:450px;help:no;status:no;resizable:yes;", true);
            }
        }
    }
}

/**
 * check input value
 * @param(obj) input text
 */
function chkInput(obj) {
    if (obj.maxLength < tes_getStrLen(obj.value)) {
        obj.value = '';
        obj.focus();
        return false;
    }
    validateVndrSeq();
}

/**
 * validation check vndr_seq
 *
 */
function validateVndrSeq() {
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
        
        var sRtnVal = getVndrSeqNm("vndr_seq_name"); 
        if(sRtnVal == "Y"){
        	formObj.is_valid_vndr_seq.value = sRtnVal;
        	formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
        }  
	        
        //doActionIBSheet_main_hidden(sheetObjects[3], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

function checkValidVndrCode() {
    var formObj = document.form;
    var tmp = '';
    if (formObj.is_valid_vndr_seq.value != undefined && formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value.trim() != '') {
        tmp = formObj.is_valid_vndr_seq.value.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
                //					formObj.vndr_seq_name.value=(tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                ComShowCodeMessage('TES21511');
                formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                formObj.vndr_seq.focus();
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            ComShowCodeMessage('TES21511');
            formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            formObj.vndr_seq.focus();
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        ComShowCodeMessage('TES21511');
        formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        formObj.vndr_seq.focus();
    }
}

/**
 * get Vendor Help
 * @param(rowArray) 
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * vvd_hidden search end event
 * @param(sheetObj) sheet object 
 */
function vvd_hidden_OnSearchEnd(sheetObj) {
    var formObj = document.form;
    if (sheetObj.RowCount() > 0 && ComIsNull(formObj.vvd.value) && ComIsNull(formObj.atb_dt.value)) {
        if (formObj.vvd.value == '' && sheetObj.GetCellValue(1, 'vvd_atb_dt') != '' && formObj.tml_so_seq.value != '') {
            formObj.vvd.value = sheetObj.GetCellValue(1, "vvd_vsl_cd") + sheetObj.GetCellValue(1, "vvd_skd_voy_no") + sheetObj.GetCellValue(1, "vvd_skd_dir_cd");
            formObj.io_bnd_cd.value = sheetObj.GetCellValue(1, "vvd_io_bnd_cd");
            formObj.atb_dt.value = sheetObj.GetCellValue(1, "vvd_atb_dt");
            io_hidden = sheetObj.GetCellValue(1, "vvd_io_bnd_cd");
        }
    }
    
    if (sheetObj.RowCount() > 0 && formObj.tml_so_seq.value != '') {
        formObj.page.value = sheetObj.FindText('vvd', formObj.vvd.value + io_hidden) + ' / ' + sheetObj.RowCount();
    } else {
        formObj.page.value = '';
    }
    
    var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    getAgmtCostCdList(0, 75, 150, costCdFtrRmk); 		
    
    //tes_getComboItem('agmt_lgs_cost_cd', 1, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|atb_dt', 'setAgmtCostCd');
    
}

/**
 * search end event
 * @param(sheetObj) sheet Object 
 */
function t1sheet1_OnSearchEnd(sheetObj) {
    var formObj = document.form;
    formObj.sht_01_ttl.value = 0;
    formObj.sht_01_full.value = 0;
    formObj.sht_01_mt.value = 0;
    formObj.sht_01_ts_same_yard.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D4.value = 0;
    formObj.sht_01_D5.value = 0;
    formObj.sht_01_D7.value = 0;
    formObj.sht_01_D8.value = 0;
    formObj.sht_01_D9.value = 0;
    //        formObj.sht_01_DW.value=0;
    //        formObj.sht_01_DX.value=0;
    formObj.sht_01_R2.value = 0;
    formObj.sht_01_R4.value = 0;
    formObj.sht_01_R5.value = 0;
    formObj.sht_01_F2.value = 0;
    formObj.sht_01_F4.value = 0;
    formObj.sht_01_F5.value = 0;
    formObj.sht_01_O2.value = 0;
    formObj.sht_01_O4.value = 0;
    formObj.sht_01_S2.value = 0;
    formObj.sht_01_S4.value = 0;
    formObj.sht_01_T2.value = 0;
    formObj.sht_01_T4.value = 0;
    formObj.sht_01_A2.value = 0;
    formObj.sht_01_A4.value = 0;
    formObj.sht_01_P2.value = 0;
    formObj.sht_01_P4.value = 0;
    formObj.sht_01_Z2.value = 0;
    formObj.sht_01_Z4.value = 0;
    formObj.sht_01_ttl.value = sheetObjects[0].RowCount();
    for (var i = 1; i <= sheetObj.RowCount(); i++) {
        with(formObj) {
            if (sheetObj.GetCellValue(i, "cntr_sty_cd") == 'F') {
                sht_01_full.value++;
            } else if (sheetObj.GetCellValue(i, "cntr_sty_cd") == 'M') {
                sht_01_mt.value++;
            }
            if (sheetObj.GetCellValue(i, "sam_locl_ts_ind_cd") == 'T') {
                sht_01_ts_same_yard.value++;
            }
            try{
                eval('sht_01_' + sheetObj.GetCellValue(i, "cntr_tpsz_cd")).value++;
            }catch(e){}
        }
    }
    setTooltip(sheetObj, 'cntr_rmk');
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'CO') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Coincidence');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'HO') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'NYK List only');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'HD') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'NYK List double');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'NH') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Not in NYK source');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'DB') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Double billing');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'DD') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Discrepancy by detail data');
        } else if (sheetObj.GetCellValue(i, 'dscr_ind_cd') == 'NN') {
            sheetObj.SetToolTipText(i, 'dscr_ind_cd', 'Container does not exist in this yard');
        }
    }
}

function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg) {
    setTooltip(t2sheet1, 'cntr_rmk');
}

function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    setTooltip(sheetObj, 'calc_rmk');
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        sheetObj.SetCellValue(i, "calc_rmk", ComToString(sheetObj.GetCellValue(i, "calc_rmk")), 0);
        if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'WD') {
            sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Week day');
        } else if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'SA') {
            sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Saturday');
        } else if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'SU') {
            sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Sunday');
        } else if (sheetObj.GetCellValue(i, 'tml_wrk_dy_cd') == 'HO') {
            sheetObj.SetToolTipText(i, 'tml_wrk_dy_cd', 'Holiday');
        }
        if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'C') {
            sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Container');
        } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'T') {
            sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'TEU');
        } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'U') {
            sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'BOX');
        } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'M') {
            sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Move');
        } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'G') {
            sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Gang/Hour');
        } else if (sheetObj.GetCellValue(i, 'vol_tr_ut_cd') == 'W') {
            sheetObj.SetToolTipText(i, 'vol_tr_ut_cd', 'Tonne');
        }
    }
}

function accm_hidden_OnSearchEnd(sheetObj) {
    var formObj = document.form;
    if (sheetObj.RowCount() > 0) {
        formObj.pay_vol_qty.value = tes_addComma(sheetObj.GetCellValue(1, 'pay_vol_qty'));
    }
}

function total_hidden_OnSearchEnd(sheetObj) {
    ShowCalculatedAmountByVVD();
}

/**
 * Show Calculated Amount By VVD
 */
function ShowCalculatedAmountByVVD() {
    var sheetObj = sheetObjects[2];
    var tot_hidden = sheetObjects[6];
    var formObj = document.form;
    var total_amt = 0;
    var curr_amt = 0;
    
    for (var i = tot_hidden.HeaderRows(); i < tot_hidden.HeaderRows() + tot_hidden.RowCount(); i++) {
        if ((tot_hidden.GetCellValue(i, 'vvd') + tot_hidden.GetCellValue(i, 'io_bnd_cd')) != (formObj.vvd.value + formObj.io_bnd_cd.value)) {
            total_amt = Math.round(total_amt * 100) / 100 + Math.round(tot_hidden.GetCellValue(i, 'inv_amt') * 100) / 100;
        }
    }
    
    for (var i = sheetObj.HeaderRows(); i < sheetObj.HeaderRows() + sheetObj.RowCount(); i++) {
        curr_amt = Math.round(curr_amt * 100) / 100 + Math.round(sheetObj.GetCellValue(i, 'inv_amt') * 100) / 100;
    }
    curr_amt = Math.round(curr_amt * 100) / 100;
    total_amt = Math.round((total_amt + curr_amt) * 100) / 100;
    formObj.vvd_inv_amt.value = tes_chkAmtFmt(curr_amt, formObj.curr_cd.value);
    formObj.tot_inv_amt.value = tes_chkAmtFmt(total_amt, formObj.curr_cd.value);
}

function findPage(dir) {
    var vvd_hidden = sheetObjects[4];
    var formObj = document.form;
    var page = vvd_hidden.FindText('vvd', formObj.vvd.value + io_hidden);
    page = page + eval(dir);
    formObj.vvd.value = vvd_hidden.GetCellValue(page, 'vvd').substring(0, 9);
    formObj.io_bnd_cd.value = vvd_hidden.GetCellValue(page, 'vvd_io_bnd_cd');
    io_hidden = vvd_hidden.GetCellValue(page, 'vvd_io_bnd_cd');
    formObj.atb_dt.value = vvd_hidden.GetCellValue(page, 'vvd_atb_dt');
    formObj.page.value = page + ' / ' + vvd_hidden.RowCount();
    doActionIBSheet(sheetObjects[4], formObj, IBSEARCH);
}

function reSize() {
    var div01 = document.all.SearchLayer01.style.display;
    var div02 = document.all.SearchLayer02.style.display;
    var obj = ComGetEvent();
    if (div01 == "inline") {
        //			obj.src="/opuscntr/img/bu_prev01.gif";
        $('#updown').removeClass('btn_up').addClass('btn_down');
        document.all.SearchLayer01.style.display = "none";
        document.all.SearchLayer02.style.display = "none";
    } else {
        //			obj.src="/opuscntr/img/bu_next01.gif";
        $('#updown').removeClass('btn_down').addClass('btn_up');
        document.all.SearchLayer01.style.display = "inline";
        document.all.SearchLayer02.style.display = "inline";
    }
}

/** replaceAll
 * 
 */
function replaceAll(temp, org, rep) {
    return temp.split(org).join(rep);
}

/**
 *  setAgmtCostCd
 */
function setAgmtCostCd() {
    var formObj = document.form;
    var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;

    if (costCdFtrRmk != null && costCdFtrRmk != "") {
        var tmpArr = costCdFtrRmk.split("|");

        for (var i = 0; i < tmpArr.length; i++) {
            agmt_lgs_cost_cd.SetSelectCode(tmpArr[i]);
        }
    }
}

/**
 *  setFormValue
 */
function setFormValue(argVal) {
    //if (document.form.auth_ofc_cd.value.trim() == "Y") {
    if (argVal.trim() == "Y") {
        var formObject = document.form;
        formObject.tml_so_ofc_cty_cd.value = sheetObjects[3].GetCellValue(1, 'tml_so_ofc_cty_cd');
        formObject.tml_so_seq.value = sheetObjects[3].GetCellValue(1, 'tml_so_seq');
        formObject.inv_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'inv_ofc_cd');
        formObject.cost_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'cost_ofc_cd');
        formObject.yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
        formObject.yd_nm.value = sheetObjects[3].GetCellValue(1, 'yd_nm');
        formObject.curr_cd.value = sheetObjects[3].GetCellValue(1, 'curr_cd');
        formObject.hld_flg.value = sheetObjects[3].GetCellValue(1, 'hld_flg');

        formObject.hld_rmk.value = sheetObjects[3].GetCellValue(1, 'hld_rmk');
        formObject.iss_dt.value = sheetObjects[3].GetCellValue(1, 'iss_dt');
        formObject.rcv_dt.value = sheetObjects[3].GetCellValue(1, 'rcv_dt');
        formObject.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[3].GetCellValue(1, 'ttl_inv_amt'));
        formObject.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[3].GetCellValue(1, 'whld_tax_amt'));
        formObject.vat_amt.value = tes_chkAmtFmt(sheetObjects[3].GetCellValue(1, 'vat_amt'));
        formObject.pay_due_dt.value = sheetObjects[3].GetCellValue(1, 'pay_due_dt');

        formObject.cost_cd_ftr_rmk.value = sheetObjects[3].GetCellValue(1, 'cost_cd_ftr_rmk');

        if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'R') {
            formObject.tml_inv_sts_cd.value = 'Received';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
            formObject.tml_inv_sts_cd.value = 'Confirmed';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'P') {
            formObject.tml_inv_sts_cd.value = 'AP Interfaced';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'A') {
            formObject.tml_inv_sts_cd.value = 'Approval Request';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'D') {
            formObject.tml_inv_sts_cd.value = 'Paid';
        }
        
        if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'NL') {
            formObject.tml_inv_rjct_sts_cd.value = 'Normal';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
            formObject.tml_inv_rjct_sts_cd.value = 'Rejected';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RL') {
            formObject.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
        }
        
        // tes_chkAmtFmtObj(formObject.ttl_inv_amt);
        // tes_chkAmtFmtObj(formObject.vat_amt);
        sheetObjects[4].LoadSearchData(auth_ofc_main_hidden_xml, { Sync: 1 });
        auth_ofc_main_hidden_xml = null;

        if (isMarineTerminalINV() == true) {
            doActionIBSheet(sheetObjects[4], formObject, IBSEARCH);
        }
        
    } else {
        ComShowMessage(ComGetMsg('TES21051'));
        document.form.auth_ofc_cd.value = "";
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
    }
}