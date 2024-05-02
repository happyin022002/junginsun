/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0068.js
*@FileTitle  : On-dock Rail Charge Container List Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
// global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var beforetab2 = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets다 *****/
    /*******************************************************/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
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
                        ComShowCodeMessage('TES21501'); //ComShowMessage('Pleas Input Invoice No & Vendor Code!');
                        return;
                    } else {
                        ComShowCodeMessage('TES21502'); //ComShowMessage('Please Input Invoice No!');
                        return;
                    }
                } else {
                    if (tmp_vndr_seq == null || tmp_vndr_seq == '') {
                        ComShowCodeMessage('TES21503'); //ComShowMessage('Please Input Vendor Code!');
                        return;
                    }
                }
                if (tmp_vndr_seq.length < 6) {
                    ComShowCodeMessage('TES21504'); //ComShowMessage('Invaid Vendor Code!');
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
                break;
                
            case "btn_new":
                formObject.reset();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                sheetObject3.RemoveAll();
                break;
                
            case "btns_remarks":
                if (formObject.tml_so_seq.value == null || formObject.tml_so_seq.value == '') {
                    return false;
                }
                ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk&isZZ=Y', 'popup_remarks', 360, 160, true);
                break;
                
            case "btn_vndr":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 770, 520, 'getVender', dispaly);
                } else {
                    ComShowCodeMessage('TES21906');
                    return;
                }
                break;
                
            case "btng_totalamount":
                if (formObject.tml_so_seq.value == null || formObject.tml_so_seq.value == '') {
                    return false;
                }
                var url_str = "ESD_TES_9061.screen?tml_inv_tp_cd=" + formObject.tml_inv_tp_cd.value + "&tml_so_ofc_cty_cd=" + formObject.tml_so_ofc_cty_cd.value + "&tml_so_seq=" + formObject.tml_so_seq.value;;
                ComOpenWindow(url_str, window, "dialogWidth:540px;dialogHeight:340px;help:no;status:no;resizable:yes;", true);
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
 * @param(sheet_obj) sheet object 
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
    var sheetObject3 = sheetObjects[3];
    var formObject = document.form;
    
    if (!ComIsNull(formObject.inv_no_tmp.value)) {
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
 * adding case as numbers of counting sheets
 * @param(sheetObj) ==> 
 * @param(sheetNo)  ==>       
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){              
				var HeadTitle="Seq.|VVD|CNTR No.|Type/Size|F/M|DG|Working Date|CLM Date|Rail Billing Date|Verify Result|Remark";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_sty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Date",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wrk_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rail_bil_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dscr_ind_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
				
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(250);			
			}
		break;
		
		case 2:     //sheet2 init
			with(sheetObj){          			
				var HeadTitle="Seq.|Discrepancy Type|CNTR No.|Type/Size|F/M|DG|Working\nDate|CLM Date|Rail Billing\nDate|Remark";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:3, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
							{Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"dscr_ind_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Date",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"clm_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rail_bil_dt",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
				
				InitColumns(cols);
				SetColProperty("dscr_ind_cd", {ComboText:"Discrepancy by Detail Data|Duplicate|NYK List Only|Discrepancy by Period|Not in NYK Source|Double Billing|Different Date", ComboCode:"DD|DP|HO|PD|NH|DB|DF"} );
				
				SetEditable(0);
				SetSheetHeight(250);
			}
		break;
		
		case 3:     //sheet3 init
			with(sheetObj){
				var HeadTitle="Calculated Type|Cost Code|Type/Size|Working Date|Applied\nDate|DG|Calculated Vol.|Revised Vol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remark|3rd Party|dtl_seq";
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:1, DataRowMerge:0 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"calc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Date",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tml_wrk_dy_cd",   KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"calc_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rvis_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_rt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_xch_rt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"calc_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Popup",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
							{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tml_so_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 } ];
				
				InitColumns(cols);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				SetEditable(1);
				SetSheetHeight(250);
		}	
		break;
		
		case 4:      //main_hidden init
			with(sheetObj){			
				var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|yd_cd|yd_nm|tml_inv_sts_cd|tml_inv_rjct_sts_cd|pay_flg|curr_cd|hld_flg|hld_rmk|hld_flg|tml_inv_tp_cd|iss_dt|wrk_dt|cost_cd_ftr_rmk"
				+"rcv_dt|ttl_inv_amt|vat_amt|pay_due_dt|ttl_inv_amt"
				
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:4, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:2,    Align:"Left",    ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"hld_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ttl_calc_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"wrk_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
				InitColumns(cols);
				SetEditable(1);			
			}
		break;
	}    
}

/**
 * handling sheet process
 * @param(sheetobj) sheet object
 * @param(formobj) form object
 * @param(sAction) Action value
 */
function doActionIBSheet_main_hidden(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = SEARCH;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0068GS.do", tesFrmQryStr(formObj));
            if (searchXml != "") sheetObj.LoadSearchData(searchXml, { Append: 1, Sync: 1 });
            break;
            
        case IBSAVE: //Save
            break;
            
        case IBSEARCH_ASYNC01: //Retrieve
            break;
            
        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0068GS.do", tesFrmQryStr(formObj));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;
            break;
    }
}

/**
 * search end event
 * @param main_hidden
 * @param ErrMsg
 * @return
 */
function main_hidden_OnSearchEnd(main_hidden, ErrMsg) {
    var formObj = document.form;
    if (main_hidden.RowCount() == 1) {
        formObj.no_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'inv_ofc_cd');
        formObj.no_yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
        
        var strCntCd = document.form.cntCd.value ;      
              
        if(strCntCd == "US" || strCntCd == "CA" ){  //로그인 유저가 US, CA 인 경우 오피스 체크를 하지 않는다. 2016-03-03 by 김용진
	        var formObj = document.form;
	        formObj.tml_so_ofc_cty_cd.value = sheetObjects[3].GetCellValue(1, 'tml_so_ofc_cty_cd');
	        formObj.tml_so_seq.value = sheetObjects[3].GetCellValue(1, 'tml_so_seq');
	        formObj.cost_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'cost_ofc_cd');
	        formObj.inv_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'inv_ofc_cd');
	        formObj.yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
	        formObj.yd_nm.value = sheetObjects[3].GetCellValue(1, 'yd_nm');
	        formObj.pay_flg.value = sheetObjects[3].GetCellValue(1, 'pay_flg');
	        formObj.curr_cd.value = sheetObjects[3].GetCellValue(1, 'curr_cd');
	        formObj.hld_flg.value = sheetObjects[3].GetCellValue(1, 'hld_flg');
	        formObj.hld_rmk.value = sheetObjects[3].GetCellValue(1, 'hld_rmk');
	        formObj.iss_dt.value = sheetObjects[3].GetCellValue(1, 'iss_dt');
	        formObj.rcv_dt.value = sheetObjects[3].GetCellValue(1, 'rcv_dt');
	        formObj.ttl_inv_amt.value = sheetObjects[3].GetCellValue(1, 'ttl_inv_amt');
	        formObj.vat_amt.value = sheetObjects[3].GetCellValue(1, 'vat_amt');
	        formObj.pay_due_dt.value = sheetObjects[3].GetCellValue(1, 'pay_due_dt');
	        formObj.whld_tax_amt.value = sheetObjects[3].GetCellValue(1, 'whld_tax_amt');
	        formObj.tml_inv_tp_cd.value = sheetObjects[3].GetCellValue(1, 'tml_inv_tp_cd');
	
	        formObj.wrk_dt.value = sheetObjects[3].GetCellValue(1, 'wrk_dt');
	
	        t1sheet1_OnLoadFinish(sheetObjects[0]);
	
	        formObj.cost_cd_ftr_rmk.value = sheetObjects[3].GetCellValue(1, 'cost_cd_ftr_rmk');
	
	        if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'R') {
	            formObj.tml_inv_sts_cd.value = 'Received';
	        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
	            formObj.tml_inv_sts_cd.value = 'Confirmed';
	        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'P') {
	            formObj.tml_inv_sts_cd.value = 'AP Interfaced';
	        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'A') {
	            formObj.tml_inv_sts_cd.value = 'Approval Request';
	        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'D') {
	            formObj.tml_inv_sts_cd.value = 'Paid';
	        }
	        if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'NL') {
	            formObj.tml_inv_rjct_sts_cd.value = 'Normal';
	        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
	            formObj.tml_inv_rjct_sts_cd.value = 'Rejected';
	        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RL') {
	            formObj.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
	        }
	        tes_chkAmtFmtObj(formObj.ttl_inv_amt);
	        tes_chkAmtFmtObj(formObj.vat_amt);
	        tes_chkAmtFmtObj(formObj.whld_tax_amt);
	        if (sheetObjects[3].RowCount() > 0) {
	            doActionIBSheet1(sheetObjects[1], formObj, IBSEARCH);
	        } else {
	            ComShowMessage('No Data for\n\nInv No:' + inv_no + '  &  VNDR Code:' + vndr_seq);
	        }
	        
	        var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    		getAgmtCostCdList(0, 75, 150, costCdFtrRmk);  
    		
    		// tes_getComboItem('agmt_lgs_cost_cd', 1, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|min_wrk_dt', 'setAgmtCostCd');  	        
	        
	    } else {
	    	var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
            if(rtnValue.length > 0){
            	setFormValue(rtnValue);
            }	    		
	    }
    }
}

/**
 * handling sheet process
 * @param sheetObj   sheet object
 * @param formObj    form  object
 * @param sAction    Action value
 * @return
 */
function doActionIBSheet1(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH01;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0068GS.do", tesFrmQryStr(formObj));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[0].LoadSearchData(arrXml[0], { Sync: 1 });
            sheetObjects[1].LoadSearchData(arrXml[1], { Sync: 1 });
            sheetObjects[2].LoadSearchData(arrXml[2], { Sync: 1 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            arrXml[2] = null;
            break;
    }
}

/**
 * handling sheet process
 * @param sheetObj   sheet object
 * @param formObj    form object
 * @param sAction    Action value
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            sheetObj.DoSearch("UI_ESD_TES_0068_2DATA.html");
            break;
    }
}

/**
 * handling sheet process
 * @param sheetObj   sheet object
 * @param formObj    form object
 * @param sAction    Action value
 */
function doActionIBSheet3(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (validateForm(sheetObj, formObj, sAction))
                sheetObj.DoSearch("UI_ESD_TES_0068_3DATA.html");
            break;
        case IBSAVE: //Save
            if (validateForm(sheetObj, formObj, sAction))
                break;
        case IBINSERT:
            var Row = sheetObj.DataInsert();
            break;
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) { //no data
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({
                    HiddenColumn: -1
                });
            }

            break;
    }
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param(tab_obj)
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * Initialization Tab
 * @param tabObj  tab object
 * @param tabNo   tab number  
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
 * Tab click change event
 * @param(tabObj)
 * @param(nItem)
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    for (var i = 0; i < objs.length; i++) {
        if (i != nItem) {
            objs[i].style.display = "none";
            objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
        }
    }
    beforetab = nItem;
}

/**
 * handling process for input validation
 * @param sheetObj   sheet object
 * @param formObj    form object 
 * @param sAction    Action value 
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {

    }
    return true;
}

/**
 * check input value
 * @param(obj) object
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
 *  validation check VndrSeq
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
        
        // doActionIBSheet_main_hidden(sheetObjects[3], formObj, IBSEARCH_ASYNC05);
        // tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

/**
 * validation check vndrcode
 * @return
 */
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

function t1sheet1_OnLoadFinish(t1sheet1) {
    var formObj = document.form;
    var max_wrk_dt = "";
    var min_wrk_dt = "";

    if (t1sheet1.RowCount() > 1) {
        max_wrk_dt = t1sheet1.GetCellValue(t1sheet1.HeaderRows(), "wrk_dt");
        min_wrk_dt = t1sheet1.GetCellValue(t1sheet1.HeaderRows(), "wrk_dt");
    }

    for (var i = t1sheet1.HeaderRows(); i < t1sheet1.HeaderRows() + t1sheet1.RowCount(); i++) {
        if (max_wrk_dt < t1sheet1.GetCellValue(i, "wrk_dt")) max_wrk_dt = t1sheet1.GetCellValue(i, "wrk_dt");
        if (min_wrk_dt > t1sheet1.GetCellValue(i, "wrk_dt")) min_wrk_dt = t1sheet1.GetCellValue(i, "wrk_dt");
    }

    if (t1sheet1.RowCount() == 1) { // There is one row in the sheetObj.
        document.form.max_wrk_dt.value = max_wrk_dt;
        document.form.min_wrk_dt.value = max_wrk_dt;
    } else {
        document.form.max_wrk_dt.value = document.form.wrk_dt.value;
        document.form.min_wrk_dt.value = document.form.wrk_dt.value;
    }
}

/**
 * t1 sheet object set value
 * @param t1sheet1    sheet 1 object
 * @param ErrMsg      
 * @return
 */
function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg) {
    var formObj = document.form;
    formObj.sht_01_ttl_box.value = 0;
    formObj.sht_01_full.value = 0;
    formObj.sht_01_mt.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D2.value = 0;
    formObj.sht_01_D4.value = 0;
    formObj.sht_01_D5.value = 0;
    formObj.sht_01_D7.value = 0;
    formObj.sht_01_D8.value = 0;
    formObj.sht_01_D9.value = 0;
    //		formObj.sht_01_DW.value=0;
    //		formObj.sht_01_DX.value=0;
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
    formObj.sht_01_ttl_box.value = sheetObjects[0].RowCount();

    for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != null && sheetObjects[0].GetCellValue(i, "cntr_sty_cd").trim() != '') {
            try {
                with(formObj) {
                    if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") == 'F') {
                        sht_01_full.value++;
                    } else if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") == 'M') {
                        sht_01_mt.value++;
                    }
                }
            } catch (e) {}
        }
    }
    // Type/Size code
    for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != null && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd").trim() != '') {
            try {
                with(formObj) {
                    eval('sht_01_' + sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd")).value++;
                }
            } catch (e) {}
        }
    }
    setTooltip(t1sheet1, 'cntr_rmk');
    for (i = i = t1sheet1.HeaderRows(); i < t1sheet1.HeaderRows() + t1sheet1.RowCount(); i++) {
        if (t1sheet1.GetCellValue(i, 'dscr_ind_cd') == 'CO') {
            t1sheet1.SetToolTipText(i, 'dscr_ind_cd', 'Coincidence');
        } else if (t1sheet1.GetCellValue(i, 'dscr_ind_cd') == 'HO') {
            t1sheet1.SetToolTipText(i, 'dscr_ind_cd', 'NYK List only');
        } else if (t1sheet1.GetCellValue(i, 'dscr_ind_cd') == 'HD') {
            t1sheet1.SetToolTipText(i, 'dscr_ind_cd', 'NYK List double');
        } else if (t1sheet1.GetCellValue(i, 'dscr_ind_cd') == 'NH') {
            t1sheet1.SetToolTipText(i, 'dscr_ind_cd', 'Not in NYK source');
        } else if (t1sheet1.GetCellValue(i, 'dscr_ind_cd') == 'DB') {
            t1sheet1.SetToolTipText(i, 'dscr_ind_cd', 'Double billing');
        } else if (t1sheet1.GetCellValue(i, 'dscr_ind_cd') == 'DD') {
            t1sheet1.SetToolTipText(i, 'dscr_ind_cd', 'Discrepancy by detail data');
        } else if (t1sheet1.GetCellValue(i, 'dscr_ind_cd') == 'NN') {
            t1sheet1.SetToolTipText(i, 'dscr_ind_cd', 'Container does not exist in this yard');
        }
    }
}

/**
 * t2sheet1 search end event
 * @param t2sheet1
 * @param ErrMsg
 * @return
 */
function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg) {
    setTooltip(t2sheet1, 'cntr_rmk');
}

/***
 * Cost Calculation tab search end event
 * @param t3sheet1    
 * @param ErrMsg	   
 */
function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg) {
    var formObj = document.form;
    formObj.ttl_calc_amt1.value = 0;
    formObj.ttl_calc_amt2.value = 0;
    formObj.ttl_calc_amt3.value = 0;
    var ttl_calc_amt = 0;
    for (var i = 1; i <= t3sheet1.RowCount(); i++) {
        if (t3sheet1.GetCellValue(i, "inv_amt") != undefined && t3sheet1.GetCellValue(i, "inv_amt") != null && $.trim(t3sheet1.GetCellValue(i, "inv_amt")) != '') {
            ttl_calc_amt += eval(t3sheet1.GetCellValue(i, "inv_amt"));
        }
        if (t3sheet1.GetCellValue(i, 'tml_wrk_dy_cd') == 'WD') {
            t3sheet1.SetToolTipText(i, 'tml_wrk_dy_cd', 'Week day');
        } else if (t3sheet1.GetCellValue(i, 'tml_wrk_dy_cd') == 'SA') {
            t3sheet1.SetToolTipText(i, 'tml_wrk_dy_cd', 'Saturday');
        } else if (t3sheet1.GetCellValue(i, 'tml_wrk_dy_cd') == 'SU') {
            t3sheet1.SetToolTipText(i, 'tml_wrk_dy_cd', 'Sunday');
        } else if (t3sheet1.GetCellValue(i, 'tml_wrk_dy_cd') == 'HO') {
            t3sheet1.SetToolTipText(i, 'tml_wrk_dy_cd', 'Holiday');
        }
        if (t3sheet1.GetCellValue(i, 'vol_tr_ut_cd') == 'C') {
            t3sheet1.SetToolTipText(i, 'vol_tr_ut_cd', 'Container');
        } else if (t3sheet1.GetCellValue(i, 'vol_tr_ut_cd') == 'T') {
            t3sheet1.SetToolTipText(i, 'vol_tr_ut_cd', 'TEU');
        } else if (t3sheet1.GetCellValue(i, 'vol_tr_ut_cd') == 'U') {
            t3sheet1.SetToolTipText(i, 'vol_tr_ut_cd', 'BOX');
        } else if (t3sheet1.GetCellValue(i, 'vol_tr_ut_cd') == 'M') {
            t3sheet1.SetToolTipText(i, 'vol_tr_ut_cd', 'Move');
        } else if (t3sheet1.GetCellValue(i, 'vol_tr_ut_cd') == 'G') {
            t3sheet1.SetToolTipText(i, 'vol_tr_ut_cd', 'Gang/Hour');
        }
    }
    formObj.ttl_calc_amt1.value = ttl_calc_amt;
    formObj.ttl_calc_amt2.value = ttl_calc_amt;
    formObj.ttl_calc_amt3.value = ttl_calc_amt;
    tes_chkAmtFmtObj(formObj.ttl_calc_amt1);
    tes_chkAmtFmtObj(formObj.ttl_calc_amt2);
    tes_chkAmtFmtObj(formObj.ttl_calc_amt3);
    setTooltip(t3sheet1, 'calc_rmk');
}

/**
 * get Vendor value
 * @param(rowArray) rowArray
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * sheet object tpb popup click event
 * @param sheetObj  sheet object
 * @param row       row
 * @param col       col
 * @return
 */
function t3sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        var url_str = "ESD_TES_9251Pop.screen";
        url_str = url_str + "?tml_so_ofc_cty_cd=" + formObj.tml_so_ofc_cty_cd.value;
        url_str = url_str + "&tml_so_seq=" + formObj.tml_so_seq.value;
        url_str = url_str + "&tml_so_dtl_seq=" + sheetObj.GetCellValue(row, "tml_so_dtl_seq");
        url_str = url_str + "&inv_no=" + formObj.inv_no.value;
        url_str = url_str + "&curr_cd=" + formObj.curr_cd.value;
        ComOpenWindow(url_str, window, "dialogWidth:820px; dialogHeight:470px; help:no; status:no; resizable:yes;", true);
    }
    /*else if (sheetObj.ColSaveName(col) == "rvis_vol_qty")
				{
		if (sheetObj.GetCellValue(row,"lgs_cost_cd")!="TMXXDC" && sheetObj.GetCellValue(row,"calc_tp_cd")=="A")
					{
						var url_str="ESD_TES_907_1Pop.screen";
								url_str += "?tml_inv_tp_cd="			+formObj.tml_inv_tp_cd		.value;
								url_str += "&tml_so_ofc_cty_cd="	+formObj.tml_so_ofc_cty_cd.value;
								url_str += "&tml_so_seq="					+formObj.tml_so_seq				.value;
								url_str += "&vndr_seq="						+formObj.vndr_seq					.value;
								url_str += "&yd_cd="							+formObj.yd_cd						.value;
		url_str += "&lgs_cost_cd="				+sheetObj.GetCellValue(row,"lgs_cost_cd"	);
		url_str += "&cntr_tpsz_cd="				+sheetObj.GetCellValue(row,"cntr_tpsz_cd");
		url_str += "&dcgo_clss_cd="				+sheetObj.GetCellValue(row,"dcgo_ind_cd");
		url_str += "&cal_vol="						+sheetObj.GetCellValue(row,"calc_vol_qty");
		url_str += "&tml_wrk_dy_cd="									+sheetObj.GetCellValue(row,"tml_wrk_dy_cd"		);
		url_str += "&rvis_vol_qty="				+sheetObj.GetCellValue(row,"rvis_vol_qty");
		url_str += "&vol_tr_ut_cd="         +sheetObj.GetCellValue(row,"vol_tr_ut_cd");
		url_str += "&tml_so_dtl_seq="         +sheetObj.GetCellValue(row,"tml_so_dtl_seq");
		url_str += "&ctrt_rt="         +sheetObj.GetCellValue(row,"ctrt_rt");
								url_str += "&opener_row="					+row;
						 ComOpenWindow(url_str,  window,  "dialogWidth:430px; dialogHeight:405px; help:no; status:no; resizable:yes;" , true);
					}
				}*/
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
 * sheet form set value
 * 
 * @return
 */
function setFormValue(argVal) {
    //if (document.form.auth_ofc_cd.value.trim() == "Y") {
    if (argVal.trim() == "Y") {
        var formObj = document.form;
        formObj.tml_so_ofc_cty_cd.value = sheetObjects[3].GetCellValue(1, 'tml_so_ofc_cty_cd');
        formObj.tml_so_seq.value = sheetObjects[3].GetCellValue(1, 'tml_so_seq');
        formObj.cost_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'cost_ofc_cd');
        formObj.inv_ofc_cd.value = sheetObjects[3].GetCellValue(1, 'inv_ofc_cd');
        formObj.yd_cd.value = sheetObjects[3].GetCellValue(1, 'yd_cd');
        formObj.yd_nm.value = sheetObjects[3].GetCellValue(1, 'yd_nm');
        formObj.pay_flg.value = sheetObjects[3].GetCellValue(1, 'pay_flg');
        formObj.curr_cd.value = sheetObjects[3].GetCellValue(1, 'curr_cd');
        formObj.hld_flg.value = sheetObjects[3].GetCellValue(1, 'hld_flg');
        formObj.hld_rmk.value = sheetObjects[3].GetCellValue(1, 'hld_rmk');
        formObj.iss_dt.value = sheetObjects[3].GetCellValue(1, 'iss_dt');
        formObj.rcv_dt.value = sheetObjects[3].GetCellValue(1, 'rcv_dt');
        formObj.ttl_inv_amt.value = sheetObjects[3].GetCellValue(1, 'ttl_inv_amt');
        formObj.vat_amt.value = sheetObjects[3].GetCellValue(1, 'vat_amt');
        formObj.pay_due_dt.value = sheetObjects[3].GetCellValue(1, 'pay_due_dt');
        formObj.whld_tax_amt.value = sheetObjects[3].GetCellValue(1, 'whld_tax_amt');
        formObj.tml_inv_tp_cd.value = sheetObjects[3].GetCellValue(1, 'tml_inv_tp_cd');

        formObj.wrk_dt.value = sheetObjects[3].GetCellValue(1, 'wrk_dt');

        t1sheet1_OnLoadFinish(sheetObjects[0]);

        formObj.cost_cd_ftr_rmk.value = sheetObjects[3].GetCellValue(1, 'cost_cd_ftr_rmk');

        if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'R') {
            formObj.tml_inv_sts_cd.value = 'Received';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'C') {
            formObj.tml_inv_sts_cd.value = 'Confirmed';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'P') {
            formObj.tml_inv_sts_cd.value = 'AP Interfaced';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'A') {
            formObj.tml_inv_sts_cd.value = 'Approval Request';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_sts_cd') == 'D') {
            formObj.tml_inv_sts_cd.value = 'Paid';
        }
        if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'NL') {
            formObj.tml_inv_rjct_sts_cd.value = 'Normal';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RJ') {
            formObj.tml_inv_rjct_sts_cd.value = 'Rejected';
        } else if (sheetObjects[3].GetCellValue(1, 'tml_inv_rjct_sts_cd') == 'RL') {
            formObj.tml_inv_rjct_sts_cd.value = 'Reject Lifted';
        }
        tes_chkAmtFmtObj(formObj.ttl_inv_amt);
        tes_chkAmtFmtObj(formObj.vat_amt);
        tes_chkAmtFmtObj(formObj.whld_tax_amt);
        if (sheetObjects[3].RowCount() > 0) {
            doActionIBSheet1(sheetObjects[1], formObj, IBSEARCH);
        } else {
            ComShowMessage('No Data for\n\nInv No:' + inv_no + '  &  VNDR Code:' + vndr_seq);
        }
		
		var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    	getAgmtCostCdList(0, 75, 150, costCdFtrRmk);   	

        //tes_getComboItem('agmt_lgs_cost_cd', 1, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|min_wrk_dt', 'setAgmtCostCd');

    } else {
        ComShowMessage(ComGetMsg('TES21051'));
        document.form.auth_ofc_cd.value = "";
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[3].RemoveAll();
    }
}