/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_0018.js
*@FileTitle  : Off-dock CY Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/**
 * @extends Tes
 * @class ESD_TES_0018 : business script for Off-Dock CY Container List 
 */
function ESD_TES_0018() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.setComboObject = setComboObject;
    this.setTabObject = setTabObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.initTab = initTab;
    this.doActionIBSheet = doActionIBSheet;
    this.validateForm = validateForm;
}

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
    var sheetObject6 = sheetObjects[6];
    /** **************************************************** */
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                retrieve('Y');
                break;

            case "btn_new":
                formObject.reset();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                sheetObject3.RemoveAll();
                sheetObject4.RemoveAll();
                sheetObject6.RemoveAll();
                break;

            case "btn_vndr":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
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

            case "btns_remarks":
                var display = "1,0,1,1,1,1,1,1,1,1,1,1";
                ComOpenPopup('ESD_TES_9210RemarksPopup.screen?hld_rmk_inp_nm=hld_rmk&isZZ=Y', 500, 150, '', display, true);
                break;

            case "btng_totalamount":
                var url_str = 'ESD_TES_9050Popup.screen?tml_so_ofc_cty_cd=' + formObject.tml_so_ofc_cty_cd.value + '&tml_so_seq=' + formObject.tml_so_seq.value;
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
 * @param {ibsheet} sheet_obj 	IBSheet Object
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
    
    var formObj = document.form;
    
    if (!ComIsNull(formObj.inv_no_tmp.value)) {
        formObj.inv_no.value = formObj.inv_no_tmp.value;
        formObj.vndr_seq.value = vndr_seq;
        validateVndrSeq();
        retrieve('Y');
    }
    
    document.form.inv_no.focus();
    
    for (var i = 1; i < sheetObjects[2].Rows; i++) {
        sheetObjects[2].SetCellEditable(i, 'n3pty_flg', 1);
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
				var HeadTitle="Seq.|CNTR No.|Type/Size|Gate In|Gate Out|F/M|I/O|DG|B/B|Mode|Verify\nResult|Remarks|";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
							{Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_clss_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bb_cgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"dscr_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 } ];
				
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(150);
				SetColProperty("inv_gate_in_dt", {Format:"####-##-####:##"} );
				SetColProperty("inv_gate_out_dt", {Format:"####-##-####:##"} );
			}
		break;
		
		case 2:   //t2sheet1 init
			with(sheetObj){
				var HeadTitle0="Discrepancy Type|Seq.|CNTR No.|Type/|F/M|Gate In|Gate In|G/I|Gate Out|Gate Out|G/O\|Remarks";
				var HeadTitle1="Discrepancy Type|Seq.||Size||MVMT|Invoice|Diff.|MVMT|Invoice|Diff.|";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Combo",     Hidden:0, Width:160,  Align:"Left",    ColMerge:1,   SaveName:"dscr_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
							{Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_in_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_in_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_in_td_dys",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_gate_out_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,   Align:"Center",  ColMerge:0,   SaveName:"inv_gate_out_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gate_out_td_dys",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(270);
				SetColProperty("inv_gate_in_dt", {Format:"####-##-####:##"} );
				SetColProperty("inv_gate_out_dt", {Format:"####-##-####:##"} );
				SetColProperty("mvmt_gate_in_dt", {Format:"####-##-####:##"} );
				SetColProperty("mvmt_gate_out_dt", {Format:"####-##-####:##"} );
				SetColProperty("dscr_ind_cd", {ComboText:dscr_ind_cdText, ComboCode:dscr_ind_cdCode} );
				SetHeaderRowHeight(10);
				SetRangeBackColor(1,5,1,6,"#555555");//
				SetRangeBackColor(1,8,1,9,"#555555");//
			}
		break;
		
		case 3:   //t3sheet1 init
			with(sheetObj){
				var HeadTitle="Calculated Type|Cost Code|Type/Size|Calculated\nVol.|Year\nMonth|Revised Vol.|UOM|Mode|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"calc_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",       KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rvis_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Combo",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tml_trns_mod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rc_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
							
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(250);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
				SetColProperty("tml_trns_mod_cd", {ComboText:"Same|Truck|Rail|Mother|Barge|Feeder|Other", ComboCode:"S|T|R|V|B|F|O"} );
			}
		break;
		
		case 4:   //t4sheet1 init
			with(sheetObj){
				var HeadTitle="Calculated Type|Cost Code|CNTR No.|Type/\nSize|I/O|DG.|Year\nMonth|Stay\nDays|F/Days|Paid\nDays|Exclude\nDays|Over\nDays|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party";
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
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"paid_day",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"free_dy_xcld_dys",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(250);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost|SemiAutoInputCost", ComboCode:"A|M|S"} );
			}
		break;
		
		case 5:   //t5sheet1 init
			with(sheetObj){
				var HeadTitle="Calculated Type|Cost Code|Date|Stacking\nVol.|Vol. by\nInvoice|Differ|Free\nPool|Over\nVol.|UOM|Rate|AGMT\nCurr.|Exch.\nRate|Amount|Remarks|3rd Party";
				SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Combo",     Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"calc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lgs_cost_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"wrk_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"stk_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:37,   Align:"Right",   ColMerge:0,   SaveName:"diff_vol_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fp_teu_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"ovr_vol_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"vol_tr_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"n3pty_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(250);
				SetColProperty("calc_tp_cd", {ComboText:"AutoCalculatedCost|ManualInputCost", ComboCode:"A|M"} );
			}
		break;
		
		case 6:   //main_hidden
			with(sheetObj){
				var HeadTitle="tml_so_ofc_cty_cd|tml_so_seq|inv_ofc_cd|cost_ofc_cd|inv_no|vndr_seq|yd_cd|yd_nm|curr_cd|ttl_inv_amt|vat_amt|ttl_calc_amt|fm_prd_dt|hld_flg|hld_rmk|to_prd_dt|tml_inv_tp_cd|tml_cost_grp_cd|tml_calc_ind_cd|sto_dys_ind_cd|iss_dt|rcv_dt|eff_dt|pay_due_dt|pay_flg|tml_inv_sts_cd|tml_inv_rjct_sts_cd|inv_cfm_dt|inv_rjct_dt|tml_agmt_ofc_cty_cd|tml_agmt_seq|tml_agmt_ver_no|inv_rjct_rmk|cre_usr_id|cre_dt|upd_usr_id|upd_dt|cost_cd_ftr_rmk";
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
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_cost_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_calc_ind_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sto_dys_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_due_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_cfm_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"inv_rjct_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"tml_odck_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"cost_cd_ftr_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
				
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(250);
			}
		break;
		
		case 7:   //t6sheet1 init
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
							{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dcgo_ind_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rev_yrmon",         KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"stay_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"free_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"paid_day",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"free_dy_xcld_dys",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Int",       Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"vol_tr_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ctrt_rt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_xch_rt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"calc_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Popup",     Hidden:0, Width:10,   Align:"Left",    ColMerge:0,   SaveName:"n3pty_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"tml_so_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
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
function doActionIBSheetAllSheets(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            var arr_sht = getCostCalcShtToSaveArr('N');
            formObj.f_cmd.value = SEARCHLIST03;
            var sXml = sheetObj.GetSearchData("ESD_TES_0018GS.do", tesFrmQryStr(formObj));
            var arrXml = sXml.split("|$$|");
            for (var i = 0; arrXml != null && i < arrXml.length; i++) {
                if (i == 5) {
                    sheetObjects[6].LoadSearchData(arrXml[i], { Sync: 1 });
                } else {
                    sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
                }

            }
            // sheetObj.LoadSearchXml(sXml);
            // var idx = 0;
            // var sxml0;
            // var sxml1;
            // var sxml2;
            // var sxml3;
            // var sxml4;
            // sxml0 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
            // sxml1 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
            // for (var i=0; arr_sht!=null && i<arr_sht.length; i++) {
            // if (arr_sht[i]==2) { //TMNL
            // sxml2 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
            // } else if (arr_sht[i]==3) { //FD
            // sxml3 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
            // }
            // }
            // sxml4 = sheetObj.EtcData(eval(new String('sxml'+new String(idx++))));
            //				
            // sheetObj.RemoveEtcData();
            //				
            // sheetObjects[0].LoadSearchXml(sxml0);
            // sheetObjects[1].LoadSearchXml(sxml1);
            // for (var i=0; arr_sht!=null && i<arr_sht.length; i++){
            // sheetObjects[arr_sht[i]].LoadSearchXml(eval('sxml'+new String(arr_sht[i])));
            // }
            // sheetObjects[4].LoadSearchXml(sxml4);
            // sXml=null; sxml0=null; sxml1=null; sxml2=null; sxml3=null; sxml4=null;
            break;
        case IBSAVE: //Save
            break;
    }
}

/**
 * main hidden handling sheet process
 * @param {ibsheet} sheetObj 	IBSheet Object
 * @param {form} 	formObj		Form Object
 * @param {int}	sAction		
 * @return
 */
function doActionMainHiddenSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TES_0018GS.do", tesFrmQryStr(formObj));
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0018GS.do", tesFrmQryStr(formObj));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;

            break;
    }
}

/**
 *  Cost Calc.(TMNL) Sheet OnPopupClick event
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
            var url_str = 'ESD_TES_9253Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&inv_no=' + formObj.inv_no.value;
            ComOpenWindow(url_str, window, "dialogWidth:710px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
        }
        
    } else if (sheetObj.ColSaveName(col) == "rvis_vol_qty") {
        if (sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd') != null && sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd') == 'IO') {
            var url_str = 'ESD_TES_9074Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
            url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
            url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
            url_str = url_str + '&param_dcgo_clss_cd=' + sheetObj.GetCellValue(row, 'dcgo_ind_cd');
            url_str = url_str + '&param_rc_flg=' + sheetObj.GetCellValue(row, 'rc_flg');
            ComOpenWindow(url_str, window, "dialogWidth:610px; dialogHeight:430px; help:no; status:no; resizable:yes;", true);
            
        } else if (sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd') != null && sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd') == 'DT') {
            var url_str = 'ESD_TES_9075Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&calc_tp_cd=' + sheetObj.GetCellValue(row, 'calc_tp_cd');
            url_str = url_str + '&param_lgs_cost_cd=' + sheetObj.GetCellValue(row, 'lgs_cost_cd');
            url_str = url_str + '&param_cntr_tpsz_cd=' + sheetObj.GetCellValue(row, 'cntr_tpsz_cd');
            url_str = url_str + '&param_dcgo_clss_cd=' + sheetObj.GetCellValue(row, 'dcgo_ind_cd');
            url_str = url_str + '&param_rc_flg=' + sheetObj.GetCellValue(row, 'rc_flg');
            url_str = url_str + '&fm_prd_dt=' + formObj.fm_prd_dt.value;
            ComOpenWindow(url_str, window, "dialogWidth:610px; dialogHeight:430px; help:no; status:no; resizable:yes;", true);
        }
    }
}

/**
 * Cost Calc.(SR by Day) IBSheet OnPopupClick event
 * @param {ibsheet}	sheetObj 	IBSheet Object
 * @param {int}	row 		IBSheet Object Row Index
 * @param {int}	col 		IBSheet Object Column Index
 * @return
 */
function t4sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y') {
            var url_str = 'ESD_TES_9253Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&inv_no=' + formObj.inv_no.value;
            ComOpenWindow(url_str, window, "dialogWidth:720px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
        }
    }
}

/**
 * Cost Calc.(SR by Pool) IBSheet OnPopupClick event
 * @param {ibsheet}	sheetObj 	IBSheet Object
 * @param {int}	row 		IBSheet Object Row Index
 * @param {int}	col 		IBSheet Object Column Index
 * @return
 */
function t5sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y') {
            var url_str = 'ESD_TES_9253Popup.screen';
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
                InsertItem("Cost Calc.(TMNL)", "");
                InsertItem("Cost Calc.(SR by Day)", "");
                InsertItem("Cost Calc.(SR by Pool)", "");
                InsertItem("Cost Calc.(SR by EQ)", "");
            }
            break;
    }
}

/**
 * Tab click event
 * @param {tab}		tabObj
 * @param {int}		nItem
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
    with(formObj) {
        //            if (!ComIsNumber(formObj.iPage)) {
        //                return false;
        // 				}
    }
    return true;
}

/**
 * check input value
 * @param(obj) input text
 */
function chkInput(obj) {
    //	showErrMessage('strleng: '+getStrLen(obj.value));
    if (obj.maxLength < tes_getStrLen(obj.value)) {
        obj.value = '';
        obj.focus();
        return false;
    }
    validateVndrSeq();
}

/**
 * Vender Code Validation
 * @return
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
        
        // doActionMainHiddenSheet(sheetObjects[5], formObj, IBSEARCH_ASYNC05);
        // tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
    }
}

/**
 * Vender Code Validation
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
                //					formObj.vndr_seq_name.value=(tmp[1]!=undefined&&tmp[1]!=null?tmp[1]:'');
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                // formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                ComShowMessage(ComGetMsg('TES24006', 'VNDR Code'));
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            // formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            ComShowMessage(ComGetMsg('TES24006', 'VNDR Code'));
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        // formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        ComShowMessage(ComGetMsg('TES24006', 'VNDR Code'));
    }
}

/**
 * (Coincidence)Tab Sheet at the bottom is set by calculating the statistic
 * @return
 */
function setCoinShtStat() {
    var formObj = document.form;
    // 초기화
    formObj.sht_01_ttl_box.value = 0;
    formObj.sht_01_full.value = 0;
    formObj.sht_01_mt.value = 0;
    // formObj.sht_01_ts_bkg.value = 0;
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
        if (sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_sty_cd") != null && sheetObjects[0].GetCellValue(i, "cntr_sty_cd").trim() != '') {
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
        if (sheetObjects[0].GetCellValue(i, "locl_ts_ind_cd") != undefined && sheetObjects[0].GetCellValue(i, "locl_ts_ind_cd") != null && sheetObjects[0].GetCellValue(i, "locl_ts_ind_cd") != '') {
            try {
                with(formObj) {
                    if (sheetObjects[0].GetCellValue(i, "locl_ts_ind_cd") == 'T') {
                        sht_01_ts_bkg.value++;
                    }
                }
            } catch (e) {
                //ComShowMessage(e);
            }
        }
        if (sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != undefined && sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != null && sheetObjects[0].GetCellValue(i, "sam_locl_ts_ind_cd") != '') {
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
    // Type/Size code
    for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != undefined && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != null && sheetObjects[0].GetCellValue(i, "cntr_tpsz_cd") != '') {
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
 * Retrieve buuton clck event
 * @param REMOVE_YN
 * @return
 */
function retrieve(REMOVE_YN) {
    try {
        if (fnChkSearchForm()) {
            var formObj = document.form;
            if (REMOVE_YN != undefined && REMOVE_YN.trim() == 'Y') {
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                sheetObjects[4].RemoveAll();
                sheetObjects[5].RemoveAll();
                sheetObjects[6].RemoveAll();
            }
            //main hidden sheet 
            doActionMainHiddenSheet(sheetObjects[5], formObj, IBSEARCH);
        }
    } catch (e) {}
}

/**
 * (Retrieve button) check lookup mandatory
 * @return
 */
function fnChkSearchForm() {
    var formObj = document.form;
    if (formObj.inv_no.value == null || formObj.inv_no.value == '') {
        ComShowMessage(ComGetMsg('TES21026', 'Inv No'));
        formObj.inv_no.focus();
        return false;
    } else if (formObj.vndr_seq.value == null || formObj.vndr_seq.value == '') {
        ComShowMessage(ComGetMsg('TES23007', 'VNDR Code'));
        formObj.vndr_seq.focus();
        return false;
    }
    return true;
}

/**
 * search end event
 * @param {sheet}	main_hidden		ibsheet
 * @param {string}	ErrMsg			error message
 * @return
 */
function main_hidden_OnSearchEnd(main_hidden, ErrMsg) {
    var formObj = document.form;
    if (main_hidden.RowCount() == 1) {
        if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') != 'OF') {
            formObj.reset();
            if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'TM') {
                ComShowMessage(ComGetMsg('TES40050', 'Terminal invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ST') {
                ComShowMessage(ComGetMsg('TES40050', 'Storage invoice'));
            } else if (main_hidden.GetCellValue(1, 'tml_inv_tp_cd') == 'ON') {
                ComShowMessage(ComGetMsg('TES40050', 'On-dock invoice'));
                // } else if (main_hidden.CellValue(1,'tml_inv_tp_cd')=='OF'){
            } else {
                ComShowMessage(ComGetMsg('TES21034'));
            }
            return;
        }

        formObj.tml_odck_flg.value = sheetObjects[5].GetCellValue(1, 'tml_odck_flg') == "Y" ? "On" : "Off";
        formObj.no_ofc_cd.value = sheetObjects[5].GetCellValue(1, 'inv_ofc_cd');
        formObj.no_yd_cd.value = sheetObjects[5].GetCellValue(1, 'yd_cd');
        
        var strCntCd = document.form.cntCd.value ;   
        
        if(strCntCd == "US" || strCntCd == "CA" ){  //로그인 유저가 US, CA 인 경우 오피스 체크를 하지 않는다. 2016-03-03 by 김용진
        	setHdSheet2Form();
	        if (sheetObjects[5].RowCount() == 1 && sheetObjects[5].GetCellValue(1, 'tml_inv_tp_cd') == 'OF') {
	            doActionIBSheetAllSheets(sheetObjects[0], document.form, IBSEARCH);
	        }
        } else {
       		var rtnValue = getAuthOfcCd();      // tes_getInputValue('auth_ofc_cd', SEARCHLIST07, 'no_ofc_cd|cre_ofc_cd|act_tp|no_yd_cd', 'setFormValue');
            if(rtnValue.length > 0){
            	setFormValue(rtnValue);
            }       	
        }  
        confirm_done = false;
        save_conf_01 = true;
        
    } else if (main_hidden.RowCount() > 1) {
        ComShowMessage(ComGetMsg('TES24043'));
        // disablePage();
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[3].RemoveAll();
        sheetObjects[4].RemoveAll();
        sheetObjects[5].RemoveAll();
        sheetObjects[6].RemoveAll();

        return false;
    } else {
        formObj.reset();
        ComShowMessage(ComGetMsg('TES21034'));
        return false;
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
 * main hidden sheet data
 * @param MODE
 * @return
 */
function setHdSheet2Form(MODE) {
    var formObj = document.form;
    if (sheetObjects[5].RowCount() == 1) {
        formObj.tml_so_ofc_cty_cd.value = sheetObjects[5].GetCellValue(1, 'tml_so_ofc_cty_cd');
        formObj.tml_so_seq.value = sheetObjects[5].GetCellValue(1, 'tml_so_seq');
        formObj.tml_cost_grp_cd.value = sheetObjects[5].GetCellValue(1, 'tml_cost_grp_cd');
        formObj.inv_ofc_cd.value = sheetObjects[5].GetCellValue(1, 'inv_ofc_cd');
        formObj.cost_ofc_cd.value = sheetObjects[5].GetCellValue(1, 'cost_ofc_cd');
        formObj.vndr_seq.value = tes_lpad(sheetObjects[5].GetCellValue(1, 'vndr_seq'), 6, '0');
        formObj.yd_cd.value = sheetObjects[5].GetCellValue(1, 'yd_cd');
        formObj.yd_nm.value = sheetObjects[5].GetCellValue(1, 'yd_nm');
        formObj.fm_prd_dt.value = sheetObjects[5].GetCellValue(1, 'fm_prd_dt');
        formObj.to_prd_dt.value = sheetObjects[5].GetCellValue(1, 'to_prd_dt');
        formObj.inv_no.value = sheetObjects[5].GetCellValue(1, 'inv_no');
        formObj.iss_dt.value = sheetObjects[5].GetCellValue(1, 'iss_dt');
        formObj.ttl_inv_amt.value = tes_chkAmtFmt(sheetObjects[5].GetCellValue(1, 'ttl_inv_amt'), sheetObjects[5].GetCellValue(1, 'curr_cd'));
        formObj.whld_tax_amt.value = tes_chkAmtFmt(sheetObjects[5].GetCellValue(1, 'whld_tax_amt'), sheetObjects[5].GetCellValue(1, 'curr_cd'));
        // formObj.hld_rmk.value = sheetObjects[5].CellValue(1, 'hld_rmk');
        formObj.hld_flg.value = sheetObjects[5].GetCellValue(1, 'hld_flg');
        formObj.hld_rmk.value = sheetObjects[5].GetCellValue(1, 'hld_rmk');

        formObj.cost_cd_ftr_rmk.value = sheetObjects[5].GetCellValue(1, 'cost_cd_ftr_rmk');

        if (sheetObjects[5].GetCellValue(1, 'hld_flg') != undefined && sheetObjects[5].GetCellValue(1, 'hld_flg') == 'Y') {
            formObj.hld_flg.checked = true;
        } else {
            formObj.hld_flg.checked = false;
        }
        formObj.pay_due_dt.value = sheetObjects[5].GetCellValue(1, 'pay_due_dt');
        formObj.pay_flg.value = sheetObjects[5].GetCellValue(1, 'pay_flg');
        formObj.rcv_dt.value = sheetObjects[5].GetCellValue(1, 'rcv_dt');
        formObj.curr_cd.value = sheetObjects[5].GetCellValue(1, 'curr_cd');
        // formObj.tml_inv_tp_cd.value = sheetObjects[5].CellValue(1,
        // 'tml_inv_tp_cd');
        var inv_sts_cd = sheetObjects[5].GetCellValue(1, 'tml_inv_sts_cd');
        if (inv_sts_cd != undefined && inv_sts_cd == 'R') {
            inv_sts_cd = 'RC'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'C') {
            inv_sts_cd = 'CF'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'P') {
            inv_sts_cd = 'AP'
        } else if (inv_sts_cd != undefined && inv_sts_cd == 'A') {
            inv_sts_cd = 'AR'
        }
        formObj.tml_inv_sts_cd.value = inv_sts_cd;
        formObj.tml_inv_sts_cd.title = tes_getInvStsFullNm(inv_sts_cd);
        var rjct_sts_cd = sheetObjects[5].GetCellValue(1, 'tml_inv_rjct_sts_cd');
        formObj.tml_inv_rjct_sts_cd.value = (rjct_sts_cd != null && rjct_sts_cd.trim() != '' ? rjct_sts_cd : 'NL');
        formObj.tml_inv_rjct_sts_cd.title = tes_getInvRejectStsFullNm(rjct_sts_cd != null && rjct_sts_cd.trim() != '' ? rjct_sts_cd : 'NL');
        // formObj.inv_rjct_rmk.value = sheetObjects[5].CellValue(1,
        // 'inv_rjct_rmk');
        // radio button
        // var tml_calc_ind_cd = sheetObjects[5].CellValue(1,
        // 'tml_calc_ind_cd');
        // var sto_dys_ind_cd = sheetObjects[5].CellValue(1,
        // 'sto_dys_ind_cd');
        // ComShowMessage('tml_cost_grp_cd:'+tml_cost_grp_cd+'\n' +
        // 'tml_calc_ind_cd:'+tml_calc_ind_cd+'\n'+'sto_dys_ind_cd:'+sto_dys_ind_cd+'\n');
        // formObj.tml_calc_ind_cd.value = tml_calc_ind_cd;
        // formObj.sto_dys_ind_cd.value = sto_dys_ind_cd;

        if (formObj.tml_odck_flg.value == "Off") {
            formObj.agmt_ftr_inv_tp_cd.value = "OTOS";

        } else {
            formObj.agmt_ftr_inv_tp_cd.value = "OFON";
        }
		
		var costCdFtrRmk = formObj.cost_cd_ftr_rmk.value;
    	getAgmtCostCdList(0, 75, 150, costCdFtrRmk);  // tes_getComboItem('agmt_lgs_cost_cd', 1, SEARCHLIST10, '', 'vndr_seq|yd_cd|agmt_ftr_inv_tp_cd|fm_prd_dt|to_prd_dt', 'setAgmtCostCd');

    } else if (sheetObjects[5].RowCount() > 0) {
        ComShowMessage(ComGetMsg('TES21035')); // ComShowMessage('ERR');
        return false;
    } else {
        ComShowMessage(ComGetMsg('TES21035')); // ComShowMessage('ERR2');
        return false;
    }
}

/**
 * 
 * @return
 */
//	function setCalcCostCond() {
//
////		ComShowMessage('setCalcCostCond!');
//
//		var formObj = document.form;
//
//		var tml_cost_grp_cd	= '';
//		var tml_calc_ind_cd	= '';
//		var sto_dys_ind_cd	= '';
//
//		if (formObj.TMNL.checked == true) {
//			tml_cost_grp_cd = 'TM';
//			if (formObj.Storage[0].checked == true) {
//				tml_cost_grp_cd = 'TD';
//			} else if (formObj.Storage[1].checked == true) {
//				tml_cost_grp_cd = 'TP';
//			}
//		} else {
//			tml_cost_grp_cd = '';
//			if (formObj.Storage[0].checked == true) {
//				tml_cost_grp_cd = 'SD';
//			} else if (formObj.Storage[1].checked == true) {
//				tml_cost_grp_cd = 'SP';
//			} else {
//				tml_cost_grp_cd = '';
//			}
//		}
////		if (formObj.CostCalcMethod[0].disabled == true && formObj.CostCalcMethod[1].disabled == true) {
////			tml_calc_ind_cd = '';
//// } else {
//			if (formObj.CostCalcMethod[0].checked == true) {
//				tml_calc_ind_cd = 'TP';
//			} else if (formObj.CostCalcMethod[1].checked == true) {
//				tml_calc_ind_cd = 'SP';
//			} else {
//				tml_calc_ind_cd = '';
//			}
////		}
////		if (formObj.StorageFD[0].disabled == true && formObj.StorageFD[1].disabled == true) {
////			sto_dys_ind_cd = '';
//// } else {
//			if (formObj.StorageFD[0].checked == true) {
//				sto_dys_ind_cd = 'IO';
//			} else if (formObj.StorageFD[1].checked == true) {
//				sto_dys_ind_cd = 'DT';
//			} else {
//				sto_dys_ind_cd = '';
//			}
////		}
//
//		formObj.tml_inv_tp_cd.value		= 'OF';
//		// ComShowMessage('[function setCalcCostCond]\n\n
//		// tml_cost_grp_cd:'+tml_cost_grp_cd+'\n' +
//		// 'tml_calc_ind_cd:'+tml_calc_ind_cd+'\n'+'sto_dys_ind_cd:'+sto_dys_ind_cd+'\n');
//		formObj.tml_cost_grp_cd.value	= tml_cost_grp_cd;
//		formObj.tml_calc_ind_cd.value	= tml_calc_ind_cd;
//		formObj.sto_dys_ind_cd.value	= sto_dys_ind_cd;
//	}

/**
 * 
 * @param ROWCOUNT_CHK_YN
 * @return
 */
function getCostCalcShtToSaveArr(ROWCOUNT_CHK_YN) {
    if (sheetObjects[5].RowCount() == 0) {
        return false;
    }
    var arr_sht_to_go = new Array();
    var tml_cost_grp_cd = sheetObjects[5].GetCellValue(1, 'tml_cost_grp_cd');
    var tml_calc_ind_cd = sheetObjects[5].GetCellValue(1, 'tml_calc_ind_cd');
    var sto_dys_ind_cd = sheetObjects[5].GetCellValue(1, 'sto_dys_ind_cd');
    if (tml_cost_grp_cd != undefined && tml_cost_grp_cd.trim().length == 2) {
        if (tml_cost_grp_cd.trim().substring(0, 1) == 'T') { //TMNL
            if (ROWCOUNT_CHK_YN != undefined && ROWCOUNT_CHK_YN.trim() == 'Y') {
                if (sheetObjects[2].RowCount() > 0 && sheetObjects[2].IsDataModified()) {
                    arr_sht_to_go[arr_sht_to_go.length] = 2;
                }
            } else {
                arr_sht_to_go[arr_sht_to_go.length] = 2;
            }
        }
        if (tml_cost_grp_cd.trim().substring(1, 2) == 'D') { //By Day
            if (ROWCOUNT_CHK_YN != undefined && ROWCOUNT_CHK_YN.trim() == 'Y') {
                if (sheetObjects[3].RowCount() > 0 && sheetObjects[3].IsDataModified()) {
                    arr_sht_to_go[arr_sht_to_go.length] = 3;
                }
            } else {
                arr_sht_to_go[arr_sht_to_go.length] = 3;
            }
        } else if (tml_cost_grp_cd.trim().substring(1, 2) == 'P') { //By Pool
            if (ROWCOUNT_CHK_YN != undefined && ROWCOUNT_CHK_YN.trim() == 'Y') {
                if (sheetObjects[4].RowCount() > 0 && sheetObjects[4].IsDataModified()) {
                    arr_sht_to_go[arr_sht_to_go.length] = 4;
                }
            } else {
                arr_sht_to_go[arr_sht_to_go.length] = 4;
            }
        }
    } else {
        return false;
    }
    return arr_sht_to_go;
}

/**
 * Cost Group Calculated AMT
 * @param sheetObj
 * @param colnm
 * @return
 */
function getShtTotCalcAmt(sheetObj, colnm) {
    var tot_inv_amt_val = 0;
    for (var i = 1; i < sheetObj.RowCount() + 1; i++) {
        if (sheetObj.GetRowSumable(i) && sheetObj.GetCellValue(i, colnm) != null && sheetObj.GetCellValue(i, colnm) != '' &&
            sheetObj.GetCellValue(i, colnm) != undefined && !isNaN(parseFloat(sheetObj.GetCellValue(i, colnm))) && sheetObj.GetRowStatus(i) != 'D') {
            tot_inv_amt_val = tot_inv_amt_val + parseFloat(sheetObj.GetCellValue(i, colnm));
        }
    }
    tot_inv_amt_val *= 100;
    tot_inv_amt_val = new String(tot_inv_amt_val);
    var tmp = tot_inv_amt_val.split('.');
    if (tmp.length > 2) {
        return '';
    }
    tmp[0] /= 100;
    var tmp2 = new String(tmp[0]).split('.');
    if (tmp2.length > 2) {
        return '';
    }
    tot_inv_amt_val = tes_addComma(tmp2[0]) + (tmp2[1] != undefined && tmp2[1] != null && tmp2[1] != '' ? '.' + tmp2[1] : '');
    return tot_inv_amt_val;
}

/**
 * (Coincidence) Tab sheet OnMouseMove Event
 * @param {ibsheet}	t1sheet1	Coincidence) Tab sheet
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
 * t1sheet1 sheet search end event
 * @param {ibsheet}	t1sheet1	Coincidence sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t1sheet1_OnSearchEnd(t1sheet1, ErrMsg) {
    for (var i = 1; i <= t1sheet1.RowCount(); i++) {
        t1sheet1.SetCellValue(i, "cntr_rmk", ComToString(t1sheet1.GetCellValue(i, "cntr_rmk")), 0);
    }
    setCoinShtStat();
    setTooltip(t1sheet1, 'cntr_rmk');
}

/**
 * t2sheet1 sheet search end event
 * @param {ibsheet}	t2sheet1	Discrepancy sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t2sheet1_OnSearchEnd(t2sheet1, ErrMsg) {
    for (var i = 1; i <= t2sheet1.RowCount(); i++) {
        t2sheet1.SetCellValue(i, "cntr_rmk", ComToString(t2sheet1.GetCellValue(i, "cntr_rmk")), 0);
    }
    setTooltip(t2sheet1, 'cntr_rmk');
}

/**
 * t3sheet1 sheet search end event
 * @param {ibsheet}	t4sheet1	Cost Calc.(TMNL) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t3sheet1_OnSearchEnd(t3sheet1, ErrMsg) {
    for (var i = 1; i <= t3sheet1.RowCount(); i++) {
        t3sheet1.SetCellValue(i, "calc_rmk", ComToString(t3sheet1.GetCellValue(i, "calc_rmk")), 0);
    }
    if (t3sheet1.RowCount() > 0) {
        document.form.t3sht_tot_inv_amt.value = getShtTotCalcAmt(t3sheet1, 'inv_amt');
    }
    setTooltip(t3sheet1, 'calc_rmk');
}

/**
 * t4sheet1 sheet search end event
 * @param {ibsheet}	t4sheet1	Cost Calc.(SR by Day) sheet
 * @param {string}	ErrMsg		error message
 * @return
 */
function t4sheet1_OnSearchEnd(t4sheet1, ErrMsg) {
    for (var i = 1; i <= t4sheet1.RowCount(); i++) {
        t4sheet1.SetCellValue(i, "calc_rmk", ComToString(t4sheet1.GetCellValue(i, "calc_rmk")), 0);
    }
    if (t4sheet1.RowCount() > 0) {
        document.form.t4sht_tot_inv_amt.value = getShtTotCalcAmt(t4sheet1, 'inv_amt');
    }
    setTooltip(t4sheet1, 'calc_rmk');
}

/**
 * search end event
 * @param t5sheet1
 * @param ErrMsg
 * @return
 */
function t5sheet1_OnSearchEnd(t5sheet1, ErrMsg) {
    for (var i = 1; i <= t5sheet1.RowCount(); i++) {
        t5sheet1.SetCellValue(i, "calc_rmk", ComToString(t5sheet1.GetCellValue(i, "calc_rmk")), 0);
    }
    if (t5sheet1.RowCount() > 0) {
        document.form.t5sht_tot_inv_amt.value = getShtTotCalcAmt(t5sheet1, 'inv_amt');
    }
    setTooltip(t5sheet1, 'calc_rmk');
}

/** t6sheet1_OnSearchEnd
 *  
 * @param t6sheet1
 * @param ErrMsg
 */
function t6sheet1_OnSearchEnd(t6sheet1, ErrMsg) {
    for (var i = 1; i <= t6sheet1.RowCount(); i++) {
        t6sheet1.SetCellValue(i, "calc_rmk", ComToString(t6sheet1.GetCellValue(i, "calc_rmk")), 0);
    }
    if (t6sheet1.RowCount() > 0) {
        document.form.t6sht_tot_inv_amt.value = getShtTotCalcAmt(t6sheet1, 'inv_amt');
    }
    setTooltip(t6sheet1, 'calc_rmk');
}

/** t6sheet1_OnPopupClick
 * 
 * @param sheetObj
 * @param row
 * @param col
 * @returns {Boolean}
 */
function t6sheet1_OnPopupClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "n3pty_flg") {
        if (sheetObj.GetCellValue(row, 'n3pty_flg') == 'Y') {
            var url_str = 'ESD_TES_9253Popup.screen';
            url_str = url_str + '?tml_so_ofc_cty_cd=' + formObj.tml_so_ofc_cty_cd.value;
            url_str = url_str + '&tml_so_seq=' + formObj.tml_so_seq.value;
            url_str = url_str + '&tml_so_dtl_seq=' + sheetObj.GetCellValue(row, 'tml_so_dtl_seq');
            url_str = url_str + '&inv_no=' + formObj.inv_no.value;
            ComOpenWindow(url_str, window, "dialogWidth:720px; dialogHeight:420px; help:no; status:no; resizable:yes;", true);
        }
    }
}

/**
 * setting vender name
 * @param {Array}	rowArray	vender info array	
 * @return
 */
function getVender(rowArray) {
    var colArray = rowArray[0];
    document.all.vndr_seq.value = colArray[2];
    document.all.vndr_seq_name.value = colArray[4];
}

function setFormValue(argVal) {
    //if (document.form.auth_ofc_cd.value.trim() == "Y") {
    if (argVal.trim() == "Y") {
        setHdSheet2Form();
        if (sheetObjects[5].RowCount() == 1 && sheetObjects[5].GetCellValue(1, 'tml_inv_tp_cd') == 'OF') {
            doActionIBSheetAllSheets(sheetObjects[0], document.form, IBSEARCH);
        }
    } else {
        ComShowMessage(ComGetMsg('TES21051'));
        document.form.auth_ofc_cd.value = "";
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        sheetObjects[2].RemoveAll();
        sheetObjects[3].RemoveAll();
        sheetObjects[4].RemoveAll();
        sheetObjects[6].RemoveAll();
    }
}