/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_0019.js
*@FileTitle  : Marine Terminal Storage Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
// global variable
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;

// Event handler processing by button click event 
document.onclick = processButtonClick;

/**
 * Event handler processing by button name
 * @return
 */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                var tmp_inv_no = formObject.inv_no.value;
                var tmp_vndr_seq = formObject.vndr_seq.value;
                var tmp_vndr_nm = formObject.vndr_seq_name.value;
                if (tmp_inv_no == null || tmp_inv_no == '') {
                    if (tmp_vndr_seq == null || tmp_vndr_seq == '') {
                        ComShowMessage(ComGetMsg('TES21501')); //ComShowMessage('Pleas Input Invoice No & Vendor Code!');
                        return;
                    } else {
                        ComShowMessage(ComGetMsg('TES21502')); //ComShowMessage('Please Input Invoice No!');
                        return;
                    }
                } else {
                    if (tmp_vndr_seq == null || tmp_vndr_seq == '') {
                        ComShowMessage(ComGetMsg('TES21503')); //ComShowMessage('Please Input Vendor Code!');
                        return;
                    }
                }
                if (tmp_vndr_seq.length < 6) {
                    ComShowMessage(ComGetMsg('TES21504')); //ComShowMessage('Invaid Vendor Code!');
                    formObject.vndr_seq.value = '';
                    formObject.vndr_seq_name.value = '';
                    init();
                    formObject.vndr_seq.focus();
                    return;
                }
                formObject.reset();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                sheetObject3.RemoveAll();
                sheetObject4.RemoveAll();
                formObject.inv_no.value = tmp_inv_no;
                formObject.vndr_seq.value = tmp_vndr_seq;
                formObject.vndr_seq_name.value = tmp_vndr_nm;
                doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
                break;

            case "btn_new":
                formObject.reset();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                sheetObject3.RemoveAll();
                sheetObject4.RemoveAll();
                break;

            case "btns_remarks":
                ComOpenWindowCenter('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=' + $('#hld_rmk').val() + '&isZZ=Y', 'popup_remarks', 450, 140, true);
                break;

            case "btn_vndr":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_0C1";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3);
                // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 640, 530, 'getVender', dispaly);
                } else {
                    ComShowMessage(ComGetMsg('TES21906'));
                    return;
                }
                break;

            case "btng_totalamount":
                //var url_str = "ESD_TES_906Popup.screen?tml_inv_tp_cd="+formObject.tml_inv_tp_cd.value+"&tml_so_ofc_cty_cd="+formObject.tml_so_ofc_cty_cd.value+"&tml_so_seq="+formObject.tml_so_seq.value;
                var url_str = "ESD_TES_9050Popup.screen?tml_so_ofc_cty_cd=" + formObject.tml_so_ofc_cty_cd.value + "&tml_so_seq=" + formObject.tml_so_seq.value;
                ComOpenWindow(url_str, window, "dialogWidth:610px;dialogHeight:355px;help:no;status:no;resizable:yes;", true);
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES23028'));
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
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
    var sheetObject3 = sheetObjects[3];
    var sheetObject4 = sheetObjects[4];
    var sheetObject5 = sheetObjects[5];
    var formObject = document.form;
    if (!ComIsNull(formObject.inv_no_tmp.value)) {
        formObject.inv_no.value = formObject.inv_no_tmp.value;
        formObject.vndr_seq.value = vndr_seq;
        chkInput(formObject.vndr_seq);
        doActionIBSheet5(sheetObject4, formObject, IBSEARCH);
    }
    document.form.inv_no.focus();
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
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {int} sheetNo 	 
 * 							adding case as numbers of counting sheets
 * @return
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:   //t1sheet1 init
			with(sheetObj){
				var HeadTitle="Seq.|CNTR No.|Type/Size|Gate In|Gate Out|Stay Days|I/O|F/M|T/S|DG|B/B|Verify\nResult|Remarks|STS";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"inv_stay_dys",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"locl_ts_ind_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 } ];
				
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(150);
				SetColProperty("inv_gate_in_dt", {Format:"####-##-####:##"} );
				SetColProperty("inv_gate_out_dt", {Format:"####-##-####:##"} );
			}
		break;
		
		case 2:   //t2sheet1 init
			with(sheetObj){
				var HeadTitle0="Discrepancy Type|Seq.|CNTR No.|Type|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O|Stay Days|Stay Days|SD|Remarks";
				var HeadTitle1="Discrepancy Type|Seq.||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"dscr_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_in_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_in_td_dys",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_out_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_out_td_dys",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(270);
				SetHeaderRowHeight(10);
				SetColProperty("dscr_ind_cd", {ComboText:dscr_ind_cdText, ComboCode:dscr_ind_cdCode} );
				SetColProperty("inv_gate_in_dt", {Format:"####-##-####:##"} );
				SetColProperty("inv_gate_out_dt", {Format:"####-##-####:##"} );
				SetColProperty("mvmt_gate_in_dt", {Format:"####-##-####:##"} );
				SetColProperty("mvmt_gate_out_dt", {Format:"####-##-####:##"} );
			}
		break;
		
		case 3:   //t3sheet1 init
			with(sheetObj){
				var HeadTitle="Calculated Type|Cost Code|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party|";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",         KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"paid_day",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"free_dy_xcld_dys",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:15,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(250);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
			}
		break;
		
		case 4:   //t4sheet1 init
			with(sheetObj){
				var HeadTitle="Calculated Type|Cost Code|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party ";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"stk_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"diff_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"fp_teu_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"ovr_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Popup",     Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(250);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost", ComboCode:"A|M"} );
			}
		break;
		
		case 5:   //main_hidden
			with(sheetObj){
				var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|whld_tax_amt|cost_cd_ftr_rmk";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"yd_nm",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ttl_inv_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"ttl_calc_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"fm_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hld_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"hld_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"to_prd_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 }, 
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
				
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(250);
			}
		break;
		
		case 6:   //t5sheet1 init
			with(sheetObj){
				var HeadTitle="Calculated Type|Cost Code|EQ No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party|";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",         KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"paid_day",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"free_dy_xcld_dys",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Popup",     Hidden:0, Width:15,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(250);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
			}
		break;                
	}
}

/**
 * handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST;
            var sXml = sheetObj.GetSearchData("ESD_TES_0019GS.do", tesFrmQryStr(formObj));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                if (i == 4) {
                    sheetObjects[5].LoadSearchData(arrXml[i], { Sync: 1 });
                } else {
                    sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
                }
            }
            break;
    }
}

/**
 * main hidden handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} formObj		Form Object
 * @param {int} sAction			
 * @return
 */
function doActionIBSheet5(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (validateForm(sheetObj, formObj, sAction)){
            	formObj.f_cmd.value = SEARCH;
            	sheetObj.DoSearch("ESD_TES_0019GS.do", tesFrmQryStr(formObj));
            }                
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0001GS.do", tesFrmQryStr(formObj, 'calcTerminalComboItems|tmp_common_code|manual_lgs_cost_cd'));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;

            break;
    }
}

/**
 * t3 ( Cost Calc.(TMNL) ) Sheet OnPopupClick event
 * n3pty_flg : 3rd Party,  rvis_vol_qty : Revised Volume
 * @param {ibsheet}	sheetObj 	IBSheet Object
 * @param {int}	row 		IBSheet Object Row Index
 * @param {int}	col 		IBSheet Object Column Index
 * @return
 */
function t3sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y') {
            var url_str = 'ESD_TES_9254Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&inv_no=' + formObj.inv_no.value;
            ComOpenWindow(url_str, window, "dialogWidth:720px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
        }
    }
}

/**
 * 4t ( Cost Calc.(SR by Day) ) IBSheet OnPopupClick event
 * @param {ibsheet}	sheetObj 	IBSheet Object
 * @param {int}	row 		IBSheet Object Row Index
 * @param {int}	col 		IBSheet Object Column Index
 * @return
 */
function t4sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y') {
            var url_str = 'ESD_TES_9254Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&inv_no=' + formObj.inv_no.value;
            ComOpenWindow(url_str, window, "dialogWidth:720px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
        }
    }
}

/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {int} tab_obj			Tab Object
 * @return
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * Tab set the default entry
 * @param {tab}		tabObj		tab
 * @param {int}	tabNo		tab index
 * @return
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("  Verification  ", "");
                InsertItem("  Discrepancy  ", "");
                InsertItem("Cost Calc.(SR by FD)", "");
                InsertItem("Cost Calc.(SR by FP)", "");
                InsertItem("Cost Calc.(SR by EQ)", "");
            }
            break;
    }
}

/**
 * Tab change event
 * @param {tab}		tabObj
 * @param {int}		nItem index
 * @return
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";
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
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} formObj		Form Object
 * @param {int} sAction			
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {}
    return true;
}

/**
 *	invoice type - Marine Storage
 */
function isMarineStorage() {
    var tml_inv_tp_cd = sheetObjects[4].GetCellValue(1, 'tml_inv_tp_cd');
    var inv_no = document.form.inv_no.value;
    if (tml_inv_tp_cd == 'TM') {
        ComShowMessage(inv_no + ' is Terminal Invoice.');
        return false;
    } else if (tml_inv_tp_cd == 'ON') {
        ComShowMessage(inv_no + ' is On-dock Invoice.');
        return false;
    } else if (tml_inv_tp_cd == 'OF') {
        ComShowMessage(inv_no + ' is Off-dock Invoice.');
        return false;
    } else if (tml_inv_tp_cd == 'ST') {
        return true;
    }
}

/**
 * search end event
 * @param {ibsheet}	t4sheet1	main_hidden sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function main_hidden_OnSearchEnd(sheetObj, ErrMsg) {
    var formObj = document.form;
    if (sheetObj.RowCount() == 1) {
        if (isMarineStorage() == true) {
            formObj.no_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'inv_ofc_cd');
            formObj.no_yd_cd.value = sheetObjects[4].GetCellValue(1, 'yd_cd');
            
            var strCntCd = document.form.cntCd.value ;      
              
            if(strCntCd == "US" || strCntCd == "CA" ){  //로그인 유저가 US, CA 인 경우 오피스 체크를 하지 않는다. 2016-03-03 by 김용진
            	var formObj = document.form;
		        formObj.tml_so_ofc_cty_cd.value = sheetObjects[4].GetCellValue(1, 'tml_so_ofc_cty_cd');
		        formObj.tml_so_seq.value = sheetObjects[4].GetCellValue(1, 'tml_so_seq');
		        formObj.cost_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'cost_ofc_cd');
		        formObj.vndr_seq.value = tes_lpad(sheetObjects[4].GetCellValue(1, 'vndr_seq'), 6, '0');
		        formObj.inv_no.value = sheetObjects[4].GetCellValue(1, 'inv_no');
		        formObj.inv_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'inv_ofc_cd');
		        formObj.yd_cd.value = sheetObjects[4].GetCellValue(1, 'yd_cd');
		        formObj.yd_nm.value = sheetObjects[4].GetCellValue(1, 'yd_nm');
		        formObj.hld_flg.value = sheetObjects[4].GetCellValue(1, 'hld_flg');
		        formObj.hld_rmk.value = sheetObjects[4].GetCellValue(1, 'hld_rmk');
		        formObj.iss_dt.value = sheetObjects[4].GetCellValue(1, 'iss_dt');
		        formObj.rcv_dt.value = sheetObjects[4].GetCellValue(1, 'rcv_dt');
		        formObj.eff_dt.value = sheetObjects[4].GetCellValue(1, 'eff_dt');
		        formObj.ttl_inv_amt.value = sheetObjects[4].GetCellValue(1, 'ttl_inv_amt');
		        formObj.tml_inv_tp_cd.value = sheetObjects[4].GetCellValue(1, 'tml_inv_tp_cd');
		        formObj.cost_cd_ftr_rmk.value = sheetObjects[4].GetCellValue(1, 'cost_cd_ftr_rmk');
		
		        tes_chkAmtFmtObj(formObj.ttl_inv_amt);
		        formObj.vat_amt.value = sheetObjects[4].GetCellValue(1, 'vat_amt');
		        tes_chkAmtFmtObj(formObj.vat_amt);
		        formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[4].GetCellValue(1, 'whld_tax_amt'), sheetObjects[4].GetCellValue(1, 'curr_cd'));
		        formObj.pay_due_dt.value = sheetObjects[4].GetCellValue(1, 'pay_due_dt');
		        formObj.tml_inv_rjct_sts_cd.value = sheetObjects[4].GetCellValue(1, 'tml_inv_rjct_sts_cd');
		        formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(sheetObjects[4].GetCellValue(1, 'tml_inv_rjct_sts_cd'));
		        formObj.fm_prd_dt.value = sheetObjects[4].GetCellValue(1, 'fm_prd_dt') + ' ~ ' + sheetObjects[4].GetCellValue(1, 'to_prd_dt');
				
				var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    			getAgmtCostCdList(0, 75, 150, costCdFtrRmk);  // tes_getComboItem('agmt_lgs_cost_cd', 1, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|fm_prd_dt', 'setAgmtCostCd'); 
		
		        if (sheetObjects[4].RowCount() > 0 && formObj.yd_cd.value != '') {
		            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		        }
            } else {
            	var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
                if(rtnValue.length > 0){
                	setFormValue(rtnValue);
                } 
            }            
        }
    } else {
        ComShowMessage(ComGetMsg('TES21505', formObj.inv_no.value, formObj.vndr_seq.value)); //ComShowMessage('No Data for \n\nInv No:'+formObj.inv_no.value+'  &  VNDR Code:'+formObj.vndr_seq.value);
    }
}

/**
 * set Coin Sheet Status
 * @return
 */
function setCoinShtStat() {
    var formObj = document.form;
    formObj.sht_01_ttl_box.value = 0;
    formObj.sht_01_full.value = 0;
    formObj.sht_01_mt.value = 0;
    //formObj.sht_01_ts_bkg.value		= 0;
    formObj.sht_01_ts_same_yard.value = 0;
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
        if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != null && $.trim(sheetObjects[0].GetCellValue(i, "cntr_sty_cd")) != '') {
            try {
                with(formObj) {
                    if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") == 'F') {
                        sht_01_full.value++;
                    } else if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") == 'M') {
                        sht_01_mt.value++;
                    }
                }
            } catch (e) {
                //ComShowMessage(e);
            }
        }
        if (sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != undefined && sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != null && $.trim(sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd")) != '') {
            try {
                with(formObj) {
                    if (sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") == 'T') {
                        sht_01_ts_same_yard.value++;
                    }
                }
            } catch (e) {
                //ComShowMessage(e);
            }
        }
    }
    for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != null && $.trim(sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd")) != '') {
            try {
                with(formObj) {
                    eval('sht_01_' + sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd")).value++;
                }
            } catch (e) {
                //ComShowMessage(e);
            }
        }
    }
}

/**
 * t1(Coincidence) sheet OnMouseMove Event
 * @param {ibsheet}	t1sheet1	Coincidence) sheet
 * @param {int}	Button
 * @param {int}	Shift
 * @param {Long}	X
 * @param {Long}	Y
 * @return
 */
function t1sheet1_OnMouseMove(t1sheet1, Button, Shift, X, Y) {
    var row = t1sheet1.MouseRow();
    var col = t1sheet1.MouseCol();
    var sDscrIndCd = t1sheet1.GetCellValue(row, "dscr_ind_cd");

    if (t1sheet1.ColSaveName(col) == "dscr_ind_cd" && row >= 1 && !ComIsNull(sDscrIndCd)) {
        t1sheet1.SetToolTipText(row, col, getCodeName(sDscrIndCd, dscr_ind_cdCode, dscr_ind_cdText));
    }
}

/**
 * Search End event
 * @param {ibsheet}	t1sheet1	Coincidence sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg) {
    setCoinShtStat();
    setTooltip(t1sheet1, 'cntr_rmk');
}

/**
 * Search End event
 * @param {ibsheet}	t2sheet1	Discrepancy sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg) {
    setTooltip(t2sheet1, 'cntr_rmk');
}

/**
 * Search End event
 * @param {ibsheet}	t4sheet1	Cost Calc.(TMNL) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg) {
    var formObj = document.form;
    var ttl_amt = 0;
    for (var i = 1; i <= sheetObjects[2].RowCount(); i++) {
        t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);
        if (sheetObjects[2].GetCellValue(i, "inv_amt") != undefined && sheetObjects[2].GetCellValue(i, "inv_amt") != null && $.trim(sheetObjects[2].GetCellValue(i, "inv_amt")) != '') {
            try {
                ttl_amt = ttl_amt + eval(sheetObjects[2].GetCellValue(i, "inv_amt"));
            } catch (e) {
                //ComShowMessage(e);
            }
        }
    }
    formObj.ttl_calc_amt1.value = ttl_amt;
    tes_chkAmtFmtObj(formObj.ttl_calc_amt1);
    setTooltip(t3sheet1, 'calc_rmk');
}

/**
 * Search End event
 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by Day) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t4sheet1_OnSearchEnd(t4sheet1, ErrMsg) {
    var formObj = document.form;
    var ttl_amt = 0;
    for (var i = 1; i <= sheetObjects[3].RowCount(); i++) {
        t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);
        if (sheetObjects[3].GetCellValue(i, "inv_amt") != undefined && sheetObjects[3].GetCellValue(i, "inv_amt") != null && $.trim(sheetObjects[3].GetCellValue(i, "inv_amt")) != '') {
            try {
                ttl_amt = ttl_amt + eval(sheetObjects[3].GetCellValue(i, "inv_amt"));
            } catch (e) {
                //ComShowMessage(e); 
            }
        }
    }
    formObj.ttl_calc_amt2.value = ttl_amt;
    tes_chkAmtFmtObj(formObj.ttl_calc_amt2);
    setTooltip(t4sheet1, 'calc_rmk');
}

/** t5sheet1_OnSearchEnd
 * 
 * @param t5sheet1
 * @param ErrMsg
 */
function t5sheet1_OnSearchEnd(t5sheet1, ErrMsg) {
    var formObj = document.form;
    var ttl_amt = 0;
    for (var i = 1; i <= sheetObjects[5].RowCount(); i++) {
        t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")), 0);
        if (sheetObjects[5].GetCellValue(i, "inv_amt") != undefined && sheetObjects[5].GetCellValue(i, "inv_amt") != null && $.trim(sheetObjects[5].GetCellValue(i, "inv_amt")) != '') {
            try {
                ttl_amt = ttl_amt + eval(sheetObjects[5].GetCellValue(i, "inv_amt"));
            } catch (e) {
                //ComShowMessage(e);
            }
        }
    }
    formObj.ttl_calc_amt3.value = ttl_amt;
    tes_chkAmtFmtObj(formObj.ttl_calc_amt3);
    setTooltip(t5sheet1, 'calc_rmk');
}

/**
 * set vender name
 * @param {Array}	rowArray	vender array	
 * @return
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * @param {object}	obj
 * @return 
 */
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
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
        
        //doActionIBSheet5(sheetObjects[4], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

/**
 * Validation check Vender Code
 * @return
 */
function checkValidVndrCode() {
    var formObj = document.form;
    var tmp = '';
    //		ComShowMessage('is_valid_vndr_seq:'+formObj.is_valid_vndr_seq.value);
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
                ComShowMessage(ComGetMsg('TES21040'));
                formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                formObj.vndr_seq.focus();
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            ComShowMessage(ComGetMsg('TES21040'));
            formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            formObj.vndr_seq.focus();
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        ComShowMessage(ComGetMsg('TES21040'));
        formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        formObj.vndr_seq.focus();
    }
}

/**
 * check Input value
 * @param {object}	obj	: vander code
 * @return
 */
function chkInput(obj) {
    if (obj.maxLength < tes_getStrLen(obj.value)) {
        obj.value = '';
        obj.focus();
        return false;
    }
    if (tes_getStrLen(obj.value) == 6) {
        validateVndrSeq();
    }
}

/**
 * Initialization Sheet
 * @return
 */
function init() {
    var formObject = document.form;
    var tmp_inv_no = formObject.inv_no.value;
    var tmp_vndr_seq = formObject.vndr_seq.value;
    var tmp_vndr_nm = formObject.vndr_seq_name.value;
    formObject.reset();
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
    sheetObjects[2].RemoveAll();
    sheetObjects[3].RemoveAll();
    sheetObjects[4].RemoveAll();
    sheetObjects[5].RemoveAll();
    formObject.inv_no.value = tmp_inv_no;
    formObject.vndr_seq.value = tmp_vndr_seq;
    formObject.vndr_seq_name.value = tmp_vndr_nm;
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
 * 
 * @return
 */
function setFormValue(argVal) {
    //if (document.form.auth_ofc_cd.value.trim() == "Y") {
    if (argVal.trim() == "Y") {
        var formObj = document.form;
        formObj.tml_so_ofc_cty_cd.value = sheetObjects[4].GetCellValue(1, 'tml_so_ofc_cty_cd');
        formObj.tml_so_seq.value = sheetObjects[4].GetCellValue(1, 'tml_so_seq');
        formObj.cost_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'cost_ofc_cd');
        formObj.vndr_seq.value = tes_lpad(sheetObjects[4].GetCellValue(1, 'vndr_seq'), 6, '0');
        formObj.inv_no.value = sheetObjects[4].GetCellValue(1, 'inv_no');
        formObj.inv_ofc_cd.value = sheetObjects[4].GetCellValue(1, 'inv_ofc_cd');
        formObj.yd_cd.value = sheetObjects[4].GetCellValue(1, 'yd_cd');
        formObj.yd_nm.value = sheetObjects[4].GetCellValue(1, 'yd_nm');
        formObj.hld_flg.value = sheetObjects[4].GetCellValue(1, 'hld_flg');
        formObj.hld_rmk.value = sheetObjects[4].GetCellValue(1, 'hld_rmk');
        formObj.iss_dt.value = sheetObjects[4].GetCellValue(1, 'iss_dt');
        formObj.rcv_dt.value = sheetObjects[4].GetCellValue(1, 'rcv_dt');
        formObj.eff_dt.value = sheetObjects[4].GetCellValue(1, 'eff_dt');
        formObj.ttl_inv_amt.value = sheetObjects[4].GetCellValue(1, 'ttl_inv_amt');
        formObj.tml_inv_tp_cd.value = sheetObjects[4].GetCellValue(1, 'tml_inv_tp_cd');
        formObj.cost_cd_ftr_rmk.value = sheetObjects[4].GetCellValue(1, 'cost_cd_ftr_rmk');

        tes_chkAmtFmtObj(formObj.ttl_inv_amt);
        formObj.vat_amt.value = sheetObjects[4].GetCellValue(1, 'vat_amt');
        tes_chkAmtFmtObj(formObj.vat_amt);
        formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[4].GetCellValue(1, 'whld_tax_amt'), sheetObjects[4].GetCellValue(1, 'curr_cd'));
        formObj.pay_due_dt.value = sheetObjects[4].GetCellValue(1, 'pay_due_dt');
        formObj.tml_inv_rjct_sts_cd.value = sheetObjects[4].GetCellValue(1, 'tml_inv_rjct_sts_cd');
        formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(sheetObjects[4].GetCellValue(1, 'tml_inv_rjct_sts_cd'));
        formObj.fm_prd_dt.value = sheetObjects[4].GetCellValue(1, 'fm_prd_dt') + ' ~ ' + sheetObjects[4].GetCellValue(1, 'to_prd_dt');

        var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    	getAgmtCostCdList(0, 75, 150, costCdFtrRmk);  // tes_getComboItem('agmt_lgs_cost_cd', 1, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|fm_prd_dt', 'setAgmtCostCd'); 

        if (sheetObjects[4].RowCount() > 0 && formObj.yd_cd.value != '') {
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    } else {
        ComShowMessage(ComGetMsg('TES21051'));
        document.form.auth_ofc_cd.value = "";
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[3].RemoveAll();
        sheetObjects[4].RemoveAll();
        sheetObjects[5].RemoveAll();
    }
}