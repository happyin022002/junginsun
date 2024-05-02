/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_TRS_0921.js
 *@FileTitle  : More Candidates
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/12
=========================================================*/
/**
 * @fileoverview Defining scripts
 * @author author_name
 */
/**
 * @extends Bkg
 * @class ESD_TRS_0921 : Morecandidate
 */
// General global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=0;
var currenttab=0;
var isSheetRetrieved=new Array();
isSheetRetrieved[0] = false;
isSheetRetrieved[1] = false;

var prefix = 'surcharge_';
document.onclick = processButtonClick;

function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;

	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
			case "btn_apply": {
				if (setMoreCandidates(sheetObject)) {
					ComClosePopup();
				}
				break;
			}
			case "btn_close":
				var opener_obj = window.dialogArguments;
				if (!opener_obj)
					opener_obj = parent;
				if (!opener_obj)
					opener_obj = opener;
	            ComEnableObject(opener_obj.document.form.btng_wopreview, true);
				ComClosePopup();
				break;
			case "btn_provider":
			    rep_OnPopupClick();
			break;
			case "btn_filter":
        		sheetObjects[1].RemoveAll();
        		isSheetRetrieved[1] = false;
			    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
			case "btn_retrieve":
        		sheetObjects[1].RemoveAll();
        		isSheetRetrieved[1] = false;
				document.form.cgo_tp_cd.value = document.form.fm_cgo_tp_cd.options[form.fm_cgo_tp_cd.selectedIndex].value;
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage('TRS90384');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {
                var cnt = 0 ;
                InsertItem("Basic", "");
                InsertItem("Surcharge",   "");
            }
            break;
    }
}

/**
 * Register Tab Object with array
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++]=tab_obj;
}
 
/**
 * tab1_OnChange
 */
function tab1_OnChange(tabObj , nItem) {
    var objs = document.all.item("tabLayer");
    objs[beforetab].style.display = "none";
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
    beforetab = nItem;
    currenttab = nItem;
    var formObj = document.form;
    if (currenttab == 0) {
        if(!isSheetRetrieved[0]) {
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
        ComEnableObject(document.form.btn_retrieve, true);
        ComEnableObject(document.form.btn_filter, true);
    } else if (currenttab == 1) {
    	if(formObj.conti_cd.value == "E" && formObj.scg_ind_cd.value == "S") {
            tabObjects[0].SetSelectedIndex(0);
			ComShowCodeMessage('TRS90495'); // The Surcharge is already applied by manual. Please proceed after removing it.
			return;
    	}
        if(!isSheetRetrieved[1]) {
            doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);
        } else {
            ComEnableObject(document.form.btn_retrieve, false);
            ComEnableObject(document.form.btn_filter, false);
        }
    }
}

/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}

    for(k=0;k<tabObjects.length;k++) {
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
    }
    
    if(document.form.rvn_mpt_cntr.value == "Y") {
    	document.form.fm_cgo_tp_cd.disabled = false;
    }
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}

/**
 * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * 
 * @param {ibsheet}
 *            sheetObj IBSheet Object
 * @param {int}
 *            sheetNo The order number of sheetObjects array
 */
function initControl() {
}

function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
         case 1: 
            with (sheetObj) {
             var HeadTitle0="Sel.|One Way/\nRound Trip|Seq|AGMT No.|S/P Type|S/P\nCode|S/P\nName|Rejected\nHistory|AGMT\nType|Trans\nShipment|Cargo\nNature|Commodity\nGroup Code|EQ\nType/Size|UDU|Rate|Rate|Negotiated|Total Amount|Fuel\nSurcharge|Vat\nSurcharge|Total\nAmount|Amount(USD)|Customer\nCode|Feeder Term|Feeder Term|Weight\nTier|UOM";
             var HeadTitle1="Sel.|One Way/\nRound Trip|Seq|AGMT No.|S/P Type|S/P\nCode|S/P\nName|Rejected\nHistory|AGMT\nType|Trans\nShipment|Cargo\nNature|Commodity\nGroup Code|EQ\nType/Size|UDU|Currency|Amount|Negotiated|Total Amount|Fuel\nSurcharge|Vat\nSurcharge|Total\nAmount|Amount(USD)|Customer\nCode|Receiving|Delivery|Weight\nTier|UOM";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:0 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
             InitHeaders(headers, info);
             var cols = [ {Type:"Radio",     Hidden:0, Width:28,   Align:"Center",  ColMerge:1,   SaveName:"ibchk" },
                 {Type:"Combo",  Hidden:0, Width:120, Align:"Center", ColMerge:1,  SaveName:"way_type",              KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:40,  Align:"Center", ColMerge:1,  SaveName:"seq",                   KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:70,  Align:"Center", ColMerge:1,  SaveName:"agmt_no",               KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:1,  SaveName:"vndr_tp_cd",            KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:50,  Align:"Center", ColMerge:1,  SaveName:"vndr_seq",              KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:150, Align:"Left",   ColMerge:1,  SaveName:"vndr_nm",               KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:70,  Align:"Center", ColMerge:1,  SaveName:"rjt_hist",              KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:60,  Align:"Center", ColMerge:1,  SaveName:"trsp_agmt_rt_tp_nm",    KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:1,  SaveName:"trsp_bnd_cd",           KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:50,  Align:"Center", ColMerge:1,  SaveName:"spcl_cgo_cntr_tp_cd",   KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:80,  Align:"Center", ColMerge:1,  SaveName:"cmdt_grp_cd",           KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:1,  SaveName:"trsp_agmt_eq_tp_sz_cd", KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:120, Align:"Center", ColMerge:1,  SaveName:"usr_def_rmk",           KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:70,  Align:"Center", ColMerge:1,  SaveName:"curr_cd",               KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",  Hidden:0, Width:80,  Align:"right",  ColMerge:1,  SaveName:"basic_rate",            KeyField:0,  CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",  Hidden:0, Width:80,  Align:"right",  ColMerge:1,  SaveName:"nego_amt",              KeyField:0,  CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",  Hidden:1, Width:80,  Align:"right",  ColMerge:1,  SaveName:"total_amt",             KeyField:0,  CalcLogic:"|basic_rate|+|nego_amt|",  Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",  Hidden:1, Width:80,  Align:"right",  ColMerge:1,  SaveName:"fuel_scg_rt",           KeyField:0,  CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",  Hidden:1, Width:80,  Align:"right",  ColMerge:1,  SaveName:"vat_scg_rt",            KeyField:0,  CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",  Hidden:1, Width:80,  Align:"right",  ColMerge:1,  SaveName:"tot_amount",            KeyField:0,  CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Float",  Hidden:1, Width:85,  Align:"right",  ColMerge:1,  SaveName:"tot_usd_amount",        KeyField:0,  CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:70,  Align:"Center", ColMerge:1,  SaveName:"cust_cd",               KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:65,  Align:"Center", ColMerge:1,  SaveName:"wtr_rcv_term_cd",       KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:65,  Align:"Center", ColMerge:1,  SaveName:"wtr_de_term_cd",        KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:65,  Align:"Center", ColMerge:1,  SaveName:"to_wgt",                KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:0, Width:65,  Align:"Center", ColMerge:1,  SaveName:"wgt_meas_ut_cd",        KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"trsp_agmt_ofc_cty_cd",  KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"trsp_agmt_seq",         KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"trsp_agmt_rt_tp_ser_no",KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"trsp_agmt_rt_tp_cd",    KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"cust_nomi_trkr_flg",    KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"cre_ofc_cd",            KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"cre_usr_id",            KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",   Hidden:1, Width:65,  Align:"Center", ColMerge:1,  SaveName:"cre_dt",                KeyField:0,  CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
              
             InitColumns(cols);
             SetEditable(1);
             SetSheetHeight(293); //293
             SetColProperty('way_type', {ComboText:"|OneWay(CYrate)|RoundTrip(DRrate)", ComboCode:"|ONE|RND"} );
             SetRowHeight(30);
             SetCountPosition(0);
             //SetRangeBackColor(1,8,1,13,"#555555");
             //SetRangeBackColor(1,14,1,16,"#555555");
           }
            break;
         case 2: 
             with(sheetObj) {
             var HeadTitle1="Sel.|Status|Surcharge|Surcharge|Common|Auto-Apply" +
                            "|Effective Date|Effective Date|All Route|Fixed\nRatio Div|Fixed\nRatio Div|Ratio|Rate|Rate|Rate|Rate|Applied\nAmount" +
                            "|EQ\nType/Size" +
                            "|Weight\nTier|UOM|UDU|XCH RT|SeqNo|OFC|AGMT_SEQ|TP_NO|NOD_SEQ|RT_SEQ";
             var HeadTitle2="Sel.|Status|Surcharge|Surcharge|Common|Auto-Apply" +
                            "|From|To|All Route|Fixed\nRatio Div|Fixed\nRatio Div|Ratio|Currency|Amount|One Way\n(CY rate)|Round Trip\n(DR rate)|Applied\nAmount" +
                            "|EQ\nType/Size" +
                            "|Weight\nTier|UOM|UDU|XCH RT|SeqNo|OFC|AGMT_SEQ|TP_NO|NOD_SEQ|RT_SEQ";
             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol: 4, ComboMaxHeight:200 } );
             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle1, Align:"Center"},
                             { Text:HeadTitle2, Align:"Center"} ];
             InitHeaders(headers, info);
             var cols = [
                 {Type:"CheckBox", Hidden:0, Width:50,  Align:"Center", ColMerge:1, SaveName:"ibchk" },
                 {Type:"Status",   Hidden:1, Width:45,  Align:"Center", ColMerge:1, SaveName:"ibflag",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:0 },                                            
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Left",   ColMerge:1, SaveName:"trsp_scg_cd",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },                                            
                 {Type:"Text",     Hidden:0, Width:200, Align:"Left",   ColMerge:1, SaveName:"trsp_scg_nm",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:50 },                                              
                 {Type:"CheckBox", Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_aply_flg",       KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                 {Type:"CheckBox", Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"wo_aply_flg",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:2, HeaderCheck:0, TrueValue:"Y", FalseValue:"N" },
                 {Type:"Date",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_fm_dt",              KeyField:1, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },                                              
                 {Type:"Date",     Hidden:1, Width:75,  Align:"Center", ColMerge:1, SaveName:"eff_to_dt",              KeyField:1, CalcLogic:"", Format:"Ymd",       PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:10 },                                              
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_rout_all_flg",      KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:1 },                                             
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_scg_rt_div_cd",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},                                             
                 {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"agmt_scg_rt_div_nm",     KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},
                 {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"ratio",                  KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                 {Type:"Text",     Hidden:0, Width:70,  Align:"Center", ColMerge:1, SaveName:"curr_cd",                KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0},
                 {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rt",                KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_one_wy_rt",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },                                             
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"trsp_rnd_rt",            KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:0, InsertEdit:0, EditLen:15 },                                             
                 {Type:"Float",    Hidden:0, Width:70,  Align:"Right",  ColMerge:1, SaveName:"appl_rt",                KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:0, EditLen:15 },                                             
                 {Type:"Text",     Hidden:0, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_eq_tp_sz_cd",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:4 },
                 {Type:"Text",     Hidden:0, Width:80,  Align:"Right",  ColMerge:1, SaveName:"to_wgt",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:9 },
                 {Type:"Text",     Hidden:0, Width:80,  Align:"Center", ColMerge:1, SaveName:"wgt_meas_ut_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:3 },
                 {Type:"Text",     Hidden:0, Width:100, Align:"Left",   ColMerge:1, SaveName:"usr_def_rmk",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:500 },
                 {Type:"Float",    Hidden:0, Width:65,  Align:"Center", ColMerge:1, SaveName:"wo_scg_xch_rt",          KeyField:0,  CalcLogic:"",Format:"NullFloat", PointCount:6, UpdateEdit:0, InsertEdit:0 },

                 {Type:"Seq",      Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"ui_seqno",               KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:8 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:3 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_seq",          KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_rt_tp_ser_no", KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:4 },
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_nod_seq",  KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"trsp_agmt_scg_rt_seq",   KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"cre_ofc_cd",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"cre_usr_id",             KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"cre_dt",                 KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Text",     Hidden:1, Width:60,  Align:"Center", ColMerge:1, SaveName:"com_scg_knd_cd",         KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:6 },
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"com_scg_seq",            KeyField:0, CalcLogic:"", Format:"",          PointCount:0, UpdateEdit:0, InsertEdit:0, EditLen:12},
                 {Type:"Float",    Hidden:1, Width:70,  Align:"Right",  ColMerge:1, SaveName:"appl_rt_hidden",         KeyField:0, CalcLogic:"", Format:"NullFloat", PointCount:2, UpdateEdit:1, InsertEdit:0, EditLen:15}
             ];
             InitColumns(cols);
             SetEditable(1);
             SetSheetHeight(293);
             SetRowHeight(30);
             SetCountPosition(0);
         }
         break;
    }
}

function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_TRS_0921GS.do", TrsFrmQryString(formObj));
			break;
		case IBSEARCH_ASYNC01:
            formObj.f_cmd.value = SEARCH04;
            var checkedRows = sheetObjects[0].FindCheckedRow("ibchk");
            if(checkedRows == "") {
                tabObjects[0].SetSelectedIndex(0);
    			ComShowCodeMessage('TRS90496'); // Select Basic Rate first.
            	return;
            }
            var arrRow = checkedRows.split("|");
            var basicRowSaveStr = sheetObjects[0].RowSaveStr(arrRow[0]);
            sheetObj.DoSearch("ESD_TRS_0229GS.do", TrsFrmQryString(formObj) + "&" + basicRowSaveStr);
			break;
	}
}

function sheet0_OnSearchEnd(sheetObj, code, errMsg) {
	if(code == 0)
		isSheetRetrieved[0] = true;
	for ( var i = 1; i <= sheetObjects[0].RowCount(); i++) {
		if ((sheetObjects[0].GetCellValue(i + 1, "curr_cd") == null || sheetObjects[0].GetCellValue(i + 1, "curr_cd") == "")) {
			sheetObjects[0].SetCellEditable(i + 1, "ibchk", 0);
			sheetObjects[0].SetCellEditable(i + 1, "way_type", 0);
		}
		if (sheetObjects[0].GetCellValue(i + 1, "seq") == 'Preset') {
			sheetObjects[0].SetCellValue(i + 1, "nego_amt", document.form.nego_amt.value, 0);
			sheetObjects[0].SetCellValue(i + 1, "fuel_scg_rt", document.form.fuel_scg_rt.value, 0);
			sheetObjects[0].SetCellValue(i + 1, "vat_scg_rt", document.form.etc_add_amt.value, 0);
		}
	}
}

function sheet1_OnSearchEnd(sheetObj, code, errMsg) {
	if(code != 0) {
		return;
	}

	isSheetRetrieved[1] = true;
	
    var checkedRows = sheetObjects[0].FindCheckedRow("ibchk");
    var arrRow = checkedRows.split("|");
	// basic이 preset이면 
    if(sheetObjects[0].GetCellValue(arrRow[0],"seq") == "Preset") {
    	var opener_obj = window.dialogArguments;
    	if (!opener_obj)
    		opener_obj = parent;
    	if (!opener_obj)
    		opener_obj = opener;

    	var opener_sheet2 = opener_obj.sheetObjects[1];
    	var lgs_cost_cd = "";
    	// surcharge별 기 저장된 데이타를 가져와 
    	for ( var a = 1; a < opener_sheet2.RowCount()+1; a++) {
    		// W/O Preview할 때 Fuel Surcharge 코그인 lgs_cost_cd가 SCFUTD로 들어옴
    		lgs_cost_cd = opener_sheet2.GetCellValue(a, prefix + 'lgs_cost_cd');
    		if(lgs_cost_cd.substring(2,4) == 'FU') {
    			lgs_cost_cd = 'SCFAAL';
    		}
        	for ( var b = 2; b < sheetObj.RowCount()+2; b++) {
        		// 동일한 surcharge code별로
	    		if ( opener_sheet2.GetCellValue(a, prefix + 'unique_cd') == document.form.trsp_so_seq.value &&
	    			 lgs_cost_cd == sheetObj.GetCellValue(b, 'trsp_scg_cd') &&
	    			 opener_sheet2.GetCellValue(a, prefix + 'trsp_agmt_scg_rt_seq') == sheetObj.GetCellValue(b, 'trsp_agmt_scg_rt_seq') &&
	    			 opener_sheet2.GetCellValue(a, prefix + 'com_scg_knd_cd') == sheetObj.GetCellValue(b, 'com_scg_knd_cd') &&
	    			 opener_sheet2.GetCellValue(a, prefix + 'com_scg_seq') == sheetObj.GetCellValue(b, 'com_scg_seq')
	    			 ) {
	        		// applied amount에 세팅
	    			sheetObj.SetCellValue(b, 'appl_rt', Number(opener_sheet2.GetCellValue(a, prefix + 'scg_amt')), 0);
	    			sheetObj.SetCellValue(b, 'appl_rt_hidden', Number(opener_sheet2.GetCellValue(a, prefix + 'scg_amt')), 0);
	    			// 해당 row를 checked
	    			sheetObj.SetCellValue(b, "ibchk", true, 0);
	    		}
        	}
    	}
    	
    }
}

/**
 * Defining OnChange Event of sheet
 */
function sheet1_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    var formObj = document.form;
    var std = 1;
    switch(colName) {
        case 'ibchk':
            var fuelValSum = 0.00; // etc surcharge summary
            var etcValSum = 0.00; // etc surcharge summary
    	    var wayType = "appl_rt"; // way type
    	    var checkedRows = sheetObjects[0].FindCheckedRow("ibchk");    
    	    var arrRow = checkedRows.split("|");
    	    var isChecked = sheetObj.GetCellValue(row, 'ibchk');
    		// preset
    	    if(sheetObjects[0].GetCellValue(arrRow[0],"seq") == "Preset") {
	        	if(isChecked) { // checked
	        		if(sheetObj.GetCellValue(row, "appl_rt_hidden")=="") {                              // applied amount is null THEN set by default value
	        			//sheetObj.SetCellValue(row, wayType, sheetObj.GetCellValue(row, "trsp_rt"), 0);
	        			sheetObj.SetCellValue(row, wayType, Number(sheetObj.GetCellValue(row, "trsp_rt")) * Number(sheetObj.GetCellValue(row, "wo_scg_xch_rt")), 0);
	        		} else {                                                                            // applied amount is not null THEN set by applied amount
	        			if(sheetObj.GetCellValue(row, "agmt_scg_rt_div_cd") == 'F') {                                             // Fixed
		        			sheetObj.SetCellValue(row, wayType, sheetObj.GetCellValue(row, "appl_rt_hidden"), 0);
	        			} else if(formObj.basic_rt.value == sheetObjects[0].GetCellValue(globalSheet1CheckedRow, "basic_rate")) { // Ratio & Basic Rate is not changed
		        			sheetObj.SetCellValue(row, wayType, sheetObj.GetCellValue(row, "appl_rt_hidden"), 0);
	        			} else {                                                                                                  // Ratio & Basic Rate is changed
		        			//sheetObj.SetCellValue(row, wayType, sheetObj.GetCellValue(row, "trsp_rt"), 0);
		        			sheetObj.SetCellValue(row, wayType, Number(sheetObj.GetCellValue(row, "trsp_rt")) * Number(sheetObj.GetCellValue(row, "wo_scg_xch_rt")), 0);
	        			}
	        		}
	        	} else { // unchecked THEN remove value
	        		sheetObj.SetCellValue(row, wayType, '', 0);
	        	}
    	    } else { // not preset
	        	if(isChecked) { // checked THEN set by default value
	        		//sheetObj.SetCellValue(row, wayType, sheetObj.GetCellValue(row, "trsp_rt"), 0);
        			sheetObj.SetCellValue(row, wayType, Number(sheetObj.GetCellValue(row, "trsp_rt")) * Number(sheetObj.GetCellValue(row, "wo_scg_xch_rt")), 0);
	        	} else { // unchecked THEN remove value
	        		sheetObj.SetCellValue(row, wayType, '', 0);
	        	}
    	    }
        	
    	    var checkedRows2 = sheetObj.FindCheckedRow("ibchk");
    	    if(checkedRows2.length > 0) {
        	    var arrRow2 = checkedRows2.split("|");
                var rowTotCnt = arrRow2.length;
                
                for ( var i = 0; i < rowTotCnt; i++) {
                	if(sheetObj.GetCellValue(arrRow2[i],"trsp_scg_cd") == "SCFAAL") { // except Fuel Surcharge
                		fuelValSum = fuelValSum + Number(sheetObj.GetCellValue(arrRow2[i], wayType)==''?0:sheetObj.GetCellValue(arrRow2[i], wayType));
                	} else {
                    	etcValSum = etcValSum + Number(sheetObj.GetCellValue(arrRow2[i], wayType)==''?0:sheetObj.GetCellValue(arrRow2[i], wayType));
                	}
                }
    	    }
    	    // set etc surcharge summary
            if(etcValSum=='') { etcValSum = 0.00;}
    	    sheetObjects[0].SetCellValue(arrRow[0], "fuel_scg_rt", fuelValSum, 0);
    	    sheetObjects[0].SetCellValue(arrRow[0], "vat_scg_rt", etcValSum, 0);
            break;
        case 'appl_rt':
            var fuelValSum = 0.00; // etc surcharge summary
            var etcValSum = 0.00; // etc surcharge summary
    	    var wayType = "appl_rt"; // way type
    	    var checkedRows = sheetObjects[0].FindCheckedRow("ibchk");    
    	    var arrRow = checkedRows.split("|");
        	
    	    var checkedRows2 = sheetObj.FindCheckedRow("ibchk");
    	    if(checkedRows2.length > 0) {
	    	    var arrRow2 = checkedRows2.split("|");
	            var rowTotCnt = arrRow2.length;
	            
	            for ( var i = 0; i < rowTotCnt; i++) {
	            	if(sheetObj.GetCellValue(arrRow2[i],"trsp_scg_cd") == "SCFAAL") { // except Fuel Surcharge
	            		fuelValSum = fuelValSum + eval(sheetObj.GetCellValue(arrRow2[i], wayType)==''?0:sheetObj.GetCellValue(arrRow2[i], wayType));
	            	} else {
	                	etcValSum = etcValSum + eval(sheetObj.GetCellValue(arrRow2[i], wayType)==''?0.00:sheetObj.GetCellValue(arrRow2[i], wayType));
	            	}
	            }
    	    }
        	
    	    // set etc surcharge summary
    	    sheetObjects[0].SetCellValue(arrRow[0], "fuel_scg_rt", fuelValSum, 0);
    	    sheetObjects[0].SetCellValue(arrRow[0], "vat_scg_rt", etcValSum, 0);
            break;
    }
}

var globalSheet1CheckedRow = -1;
/**
 * Defining OnChange Event of sheet
 */
function sheet0_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    var formObj = document.form;
    var std = 1;
    var wo_cd_src = '';
    var wo_cd_tgt = '';
    switch(colName) {
        case('ibchk'): {
        	var isChecked = sheetObj.GetCellValue(row, 'ibchk');
        	if(isChecked) {
                if(!isSheetRetrieved[1] && (formObj.conti_cd.value != "E" || (formObj.conti_cd.value == "E" && formObj.scg_ind_cd.value == "M"))) {
                    doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC01);
                    globalSheet1CheckedRow = row;
                }
        	} else {
        		sheetObjects[1].RemoveAll();
        		isSheetRetrieved[1] = false;
        	}
            break;
        }
    }
}

function setMoreCandidates(sheetObj) {
	ComOpenWait(true);
	var formObject = document.form;
	var opener_obj = window.dialogArguments;
	if (!opener_obj)
		opener_obj = parent;
	if (!opener_obj)
		opener_obj = opener;
    ComEnableObject(opener_obj.document.form.btng_wopreview, false);

	var opener_sheet = opener_obj.sheetObjects[0];
	var opener_sheet2 = opener_obj.sheetObjects[1];

	var rowTotCnt = 0;
	var chkRowCnt = 0;
	var selectedRowNo = "";
	var way_tp_cd = "";
	var oneway_curr_cd = "";
	var roundtrip_curr_cd = "";
	var targetRow = document.form.targetRow.value;
	var gubun_name = "";
	
	var conti_cd = document.form.conti_cd.value;
	var scg_ind_cd = document.form.scg_ind_cd.value;
	
			////////////////////////////////////////////////
			var openerCheckedRows = opener_sheet.FindCheckedRow("ibcheck");
			var openerCheckedArrRow;
        	if(openerCheckedRows == '') {
        		openerCheckedRows = opener_sheet.FindCheckedRow("more_candi_flg");
            	if(openerCheckedRows == '') {
            		openerCheckedArrRow = [opener_sheet.GetSelectRow()];
            		rowTotCnt = 1;
            		if(openerCheckedArrRow < 2) {
            			ComShowCodeMessage('COM12176');
        	        	ComOpenWait(false);
        	            ComEnableObject(opener_obj.document.form.btng_wopreview, true);
            			return false;
            		}
            	} else {
            		openerCheckedArrRow = openerCheckedRows.split("|");
            		rowTotCnt = openerCheckedArrRow.length;
            	}
        	} else {
        		openerCheckedArrRow = openerCheckedRows.split("|");
        		rowTotCnt = openerCheckedArrRow.length;
        	}
            
            var checkedRows = sheetObj.FindCheckedRow("ibchk");
            if(checkedRows == "") {
        		ComShowCodeMessage('TRS90382');
	        	ComOpenWait(false);
	            ComEnableObject(opener_obj.document.form.btng_wopreview, true);
        		return false;
            }

        	if(formObject.conti_cd.value == "E" && formObject.scg_ind_cd.value == "S") {
    			ComShowCodeMessage('TRS90495'); // The Surcharge is already applied by manual. Please proceed after removing it.
	        	ComOpenWait(false);
	            ComEnableObject(opener_obj.document.form.btng_wopreview, true);
    			return false;
        	}
            
            var arrRow = checkedRows.split("|");
            selectedRowNo = arrRow[0];
            
            // check bound & tranship
            var bound_cd = document.form.bound_cd.value;
            if(bound_cd=="T" && sheetObj.GetCellValue(selectedRowNo, "trsp_bnd_cd")=="N") { // BND : T && T/Sip : Y,Blank
    			ComShowCodeMessage('TRS90452');
	        	ComOpenWait(false);
	            ComEnableObject(opener_obj.document.form.btng_wopreview, true);
    			return false;
            }else if(bound_cd!="T" && sheetObj.GetCellValue(selectedRowNo, "trsp_bnd_cd")=="Y") { // BND : I,O,Blank && T/Sip : N,Blank
    			ComShowCodeMessage('TRS90453');
	        	ComOpenWait(false);
	            ComEnableObject(opener_obj.document.form.btng_wopreview, true);
    			return false;
            }

			var scgXml = "<SHEET>";
				scgXml += "	<DATA COLORDER='surcharge_trsp_so_ofc_cty_cd|surcharge_trsp_so_seq|surcharge_unique_cd|surcharge_lgs_cost_cd|surcharge_lgs_cost_full_nm|surcharge_scg_amt|surcharge_cre_ofc_cd|surcharge_cre_usr_id|surcharge_cre_dt|surcharge_trsp_agmt_ofc_cty_cd|surcharge_trsp_agmt_seq|surcharge_trsp_agmt_rt_tp_ser_no|surcharge_trsp_agmt_scg_nod_seq|surcharge_trsp_agmt_scg_rt_seq|surcharge_fuel_rto|surcharge_com_scg_knd_cd|surcharge_com_scg_seq|surcharge_curr_cd|surcharge_wo_scg_xch_rt|surcharge_org_scg_amt'>";
			var chkCnt = 0;
            for ( var i = 0; i < rowTotCnt; i++) {
            	targetRow = openerCheckedArrRow[i];

            	var trsp_so_seq = opener_sheet.GetCellValue(targetRow, "trsp_so_seq");
            	var currency = opener_sheet.GetCellValue(targetRow, "po_local_curr_cd");
            	if (currency == "JPY" || currency == "KRW" || currency == "TWD") {
            		opener_sheet.SetCellValue(targetRow, "etc_add_amt", "0.00", 0);
            	} else {
            		opener_sheet.SetCellValue(targetRow, "etc_add_amt", "0.00", 0);
            	}
            	if(conti_cd != "E" || (conti_cd == "E" && scg_ind_cd == "M")) {
	            	for ( var a = opener_sheet2.RowCount(); a > 0; a--) {
	            		if (opener_sheet2.GetCellValue(a, prefix + 'unique_cd') == trsp_so_seq) {
	            			opener_sheet2.RowDelete(a, false);
	            		}
	            	}
            	}
            	
				if (sheetObj.GetCellValue(selectedRowNo, "cust_cd").length > 0) {
					opener_sheet.SetCellValue(targetRow, "po_sp_type", "CNT", 0);
					opener_sheet.SetCellValue(targetRow, "cust_cnt_cd_seq", sheetObj.GetCellValue(selectedRowNo, "cust_cd"), 0);
					opener_sheet.SetCellValue(targetRow, "po_cust_cnt_cd", sheetObj.GetCellValue(selectedRowNo, "cust_cd").substring(0, 2), 0);
					opener_sheet.SetCellValue(targetRow, "po_cust_seq", sheetObj.GetCellValue(selectedRowNo, "cust_cd").substring(2, 8), 0);
					opener_sheet.SetCellValue(targetRow, "po_cust_nomi_trkr_flg", "Y", 0);
				} else {
					opener_sheet.SetCellValue(targetRow, "po_sp_type", "NYK", 0);
					opener_sheet.SetCellValue(targetRow, "cust_cnt_cd_seq", "", 0);
					opener_sheet.SetCellValue(targetRow, "po_cust_cnt_cd", "", 0);
					opener_sheet.SetCellValue(targetRow, "po_cust_seq", "", 0);
					opener_sheet.SetCellValue(targetRow, "po_cust_nomi_trkr_flg", "N", 0);
				}
				opener_sheet.SetCellValue(targetRow, "vndr_seq", sheetObj.GetCellValue(selectedRowNo, "vndr_seq"), 0);
				opener_sheet.SetCellValue(targetRow, "vndr_nm", sheetObj.GetCellValue(selectedRowNo, "vndr_nm"), 0);
				opener_sheet.SetCellValue(targetRow, "po_trsp_agmt_rt_tp_nm", sheetObj.GetCellValue(selectedRowNo, "trsp_agmt_rt_tp_nm"), 0);
				opener_sheet.SetCellValue(targetRow, "po_local_curr_cd", sheetObj.GetCellValue(selectedRowNo, "curr_cd"), 0);
				//if(opener_sheet.GetCellValue(targetRow, "nego_amt") == "0.00") { // set basic rate only when negotiated amount not exists
					opener_sheet.SetCellValue(targetRow, "po_basic_rt", sheetObj.GetCellValue(selectedRowNo, "basic_rate"), 0);
				//}
				opener_sheet.SetCellValue(targetRow, "po_fuel_scg_rt", sheetObj.GetCellValue(selectedRowNo, "fuel_scg_rt"), 0);
				opener_sheet.SetCellValue(targetRow, "etc_add_amt", sheetObj.GetCellValue(selectedRowNo, "vat_scg_rt").toFixed(2), 0); 
				opener_sheet.SetCellValue(targetRow, "po_local_curr_tot_amt", sheetObj.GetCellValue(selectedRowNo, "tot_amount"), 0);
				// calculate total amount for USD on SERVER Module
				//opener_sheet.SetCellValue(targetRow, "po_usd_curr_tot_amt", sheetObj.GetCellValue(selectedRowNo, "tot_usd_amount"), 0);
				opener_sheet.SetCellValue(targetRow, "po_trsp_agmt_ofc_cty_cd", sheetObj.GetCellValue(selectedRowNo, "trsp_agmt_ofc_cty_cd"), 0);
				opener_sheet.SetCellValue(targetRow, "po_trsp_agmt_seq", sheetObj.GetCellValue(selectedRowNo, "trsp_agmt_seq"), 0);
				opener_sheet.SetCellValue(targetRow, "po_way_type", sheetObj.GetCellValue(selectedRowNo, "way_type"), 0);
				opener_sheet.SetCellValue(targetRow, "po_trsp_agmt_rt_tp_cd", sheetObj.GetCellValue(selectedRowNo, "agmt_rt_tp_cd"), 0);
				/* Default Service Provider Flag - Default S/P --> 'Y', None-default S/O --> 'N' */
				if (sheetObj.GetCellValue(selectedRowNo, "seq") == 'Preset')
					opener_sheet.SetCellValue(targetRow, "trsp_dflt_vndr_flg", 'Y', 0);
				else
					opener_sheet.SetCellValue(targetRow, "trsp_dflt_vndr_flg", '', 0);				
				
				var etc_total_amt = 0;				
				// 구주가 아니거나 또는 구주이면서 Surcharge Popup에서 입력하지 않았으면 MoreCandidate에서 Surcharge 변경 가능
            	if(conti_cd != "E" || (conti_cd == "E" && scg_ind_cd == "M")) {
				
		            var checkedRowsScg = sheetObjects[1].FindCheckedRow("ibchk");
		        	if(checkedRowsScg.length > 0) {
		        		var after_scg_ind_cd = scg_ind_cd;
			            var arrRowScg = checkedRowsScg.split("|");
//						var scgXml = "<SHEET>";
//							scgXml += "	<DATA COLORDER='surcharge_trsp_so_ofc_cty_cd|surcharge_trsp_so_seq|surcharge_unique_cd|surcharge_lgs_cost_cd|surcharge_lgs_cost_full_nm|surcharge_scg_amt|surcharge_cre_ofc_cd|surcharge_cre_usr_id|surcharge_cre_dt|surcharge_trsp_agmt_ofc_cty_cd|surcharge_trsp_agmt_seq|surcharge_trsp_agmt_rt_tp_ser_no|surcharge_trsp_agmt_scg_nod_seq|surcharge_trsp_agmt_scg_rt_seq|surcharge_fuel_rto|surcharge_com_scg_knd_cd|surcharge_com_scg_seq'>";
			            for ( var j = 0; j < arrRowScg.length; j++) {
		            		if(sheetObjects[1].GetCellValue(arrRowScg[j], "appl_rt")=='' || sheetObjects[1].GetCellValue(arrRowScg[j], "appl_rt")=='0') {
			            		continue;
		            		}
		            		
		            		if(sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_scg_cd") != "SCFAAL") {
		            			etc_total_amt += Number(sheetObjects[1].GetCellValue(arrRowScg[j], "appl_rt"));
		            		}
		            		
		            		// 변경 값이 한 건이라도 있으면 Opener Sheet의 scg_ind_cd을 M으로 변경
		            		after_scg_ind_cd = "M";
		            		
							scgXml += "	<TR>";
							scgXml += "		<TD>" + opener_sheet.GetCellValue(targetRow, "trsp_so_ofc_cty_cd") + "</TD>";
							scgXml += "		<TD>" + opener_sheet.GetCellValue(targetRow, "trsp_so_seq") + "</TD>";
							scgXml += "		<TD>" + opener_sheet.GetCellValue(targetRow, "trsp_so_seq") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_scg_cd") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_scg_nm") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "appl_rt") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "cre_ofc_cd") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "cre_usr_id") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "cre_dt") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_agmt_ofc_cty_cd") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_agmt_seq") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_agmt_rt_tp_ser_no") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_agmt_scg_nod_seq") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_agmt_scg_rt_seq") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "ratio") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "com_scg_knd_cd") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "com_scg_seq") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "curr_cd") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "wo_scg_xch_rt") + "</TD>";
							scgXml += "		<TD>" + sheetObjects[1].GetCellValue(arrRowScg[j], "trsp_rt") + "</TD>";
							scgXml += "	</TR>";
							
							chkCnt += 1;
			            }
//							scgXml += "	</DATA>";
//							scgXml += "</SHEET>";
//			            scgXml=scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
//			            scgXml=scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
//						opener_sheet2.LoadSearchData(scgXml,{Append : 1} );

						opener_sheet.SetCellValue(targetRow, "scg_ind_cd", after_scg_ind_cd, 0);
		        	}
	        	}
            	opener_sheet.SetCellValue(targetRow, "etc_add_amt", etc_total_amt.toFixed(2), 0); 
				// calculate total amount for USD on SERVER Module
				opener_obj.searchLocalCurr2UsdCurr(opener_sheet, opener_obj.document.form, targetRow);
            }
            
          

			scgXml += "	</DATA>";
			scgXml += "</SHEET>";
	        scgXml=scgXml.replace(new RegExp("<TD>","gi"),'<TD><![CDATA[');
	        scgXml=scgXml.replace(new RegExp("</TD>","gi"),']]></TD>');
	        if(chkCnt > 0) {
	        	opener_sheet2.SetWaitImageVisible(true);
	        	opener_sheet2.LoadSearchData(scgXml,{Append : 1} );
	        } else {
	        	ComOpenWait(false);
	            ComEnableObject(opener_obj.document.form.btng_wopreview, true);
	        }
		
			return true;
			////////////////////////////////////////////////
		
	rowTotCnt = sheetObj.RowCount();
	
	if (rowTotCnt == 0) {
		ComShowCodeMessage('PRD90013');
    	ComOpenWait(false);
        ComEnableObject(opener_obj.document.form.btng_wopreview, true);
		return false;
	}
	if (chkRowCnt == 0) {
		ComShowCodeMessage('TRS90215');
    	ComOpenWait(false);
        ComEnableObject(opener_obj.document.form.btng_wopreview, true);
		return false;
	}
	ComOpenWait(false);
    ComEnableObject(opener_obj.document.form.btng_wopreview, true);
	return false;
}

/*
 * format number
 * ex) formatDecimal(37, 3) => 37.000, formatDecimal(37.9, 2) => 37.90
 */
function formatDecimal(val, p){
    var s = val.toString();
    if (s.indexOf('.') == -1) s += '.';
    while (s.length <= s.indexOf('.') + p) s += '0';
    return s;
}

//////////////////////////////// S/P Select Popup START ///////////////////////////////////////////
/**
 * S / P information, retrieving
 */
function  vender_blur(){
	var formObj=document.form;
	var error_val="";
	var lvobj=formObj.fm_vndr_prmry_seq.value;
	if(lvobj !=""){
		for (var i=0; i < lvobj.length; i++)
		{
			var oneChar=lvobj.charAt(i)
			if (oneChar != "")
			{
				if (  (oneChar >= "0" && oneChar <= "9" )  ){
				}else {
					error_val="Y";
					break;
				}
			}
		}
	}
	if(error_val =="Y" ){
		formObj.fm_vndr_prmry_seq.value = "";
		formObj.fm_vndr_prmry_nm.value = "";
		return;
	}
    sheet1.RemoveEtcData();
	formObj.f_cmd.value=SEARCH07;
	sheetObjects[1].GetSearchData("ESD_TRS_0220GS.do",TrsFrmQryString(formObj));
	x1=ComSearchEtcData(sheetObjects[1], "ESD_TRS_0220GS.do",TrsFrmQryString(formObj), 'VNDR_NM');
	
	if(x1 !="" && x1 != undefined){ //
		formObj.fm_vndr_prmry_nm.value=x1;
	}else{
		formObj.fm_vndr_prmry_seq.value = "";
		formObj.fm_vndr_prmry_nm.value="";
	}
}

/**
  * rep_commodity Pop-up call
  */
function rep_OnPopupClick()
 {
	var formObject=document.form;
	var cmdt_cd_val="";   	
	var rep_cmdt_cd_val="";   	
	var cmdt_desc_val="";   	
	var classId="getCOM_ENS_rep";
	var xx1="";  //CONTI
	var xx2="";  //SUB CONTI
	var xx3="";  //COUNTRY
	var xx4="";  //STATE
	var xx5="";  //CONTROL OFFIC
	var xx6="";  //LOC CODE
	var xx7="";  //LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&func_div=1";
	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 699, 520, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * rep_commodity Pop-up call
 */
function getCOM_ENS_rep(rowArray) {
	
	var formObj=document.form;
	for(var i=0; i<rowArray.length; i++) 
	{
		var colArray=rowArray[0];
		var colArray2=colArray[2];
		var colArray3=colArray[3];
		var colArray4=colArray[4];
		formObj.fm_vndr_prmry_seq.value=colArray2;
		formObj.fm_vndr_prmry_nm.value=colArray4;
	}
}

/**
 * Upper Case
 **/
function toUpperCase(obj) {
    obj.value = obj.value.toUpperCase();
}