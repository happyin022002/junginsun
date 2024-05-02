/*=========================================================
 * 1.0 Creation
 * Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 * @FileName  : ESD_TRS_0018.js
 * @FileTitle : Other SO Creation
 * @author    : CLT
 * @version   : 1.0
 * @since     : 2014/06/04
=========================================================*/

/*------------------ Defining general java script function   ------------------*/
// General global variable
var initFlag=false;
var sheetObjects=new Array();
var sheetCnt=0;
var ctMode=0;//COST MODE, TRANS MODE , 1-single trans, except DOOR, 2-complex trans, except DOOR, 3-single trans ,DOOR, 4-complex trans ,DOOR
var prefix='surcharge_';
document.onclick=processButtonClick;

/* Branch processing event handler with the name of button */
function processButtonClick() {
    /***** Adding additional sheet variables to use more than one sheet per a tab *****/
    var sheetObject=sheetObjects[0];
    var sheetObject1=sheetObjects[1];
    var sheetObject2=sheetObjects[2];
    var sheetObject3=sheetObjects[3];
    var sheetObject4=sheetObjects[4];
    /*******************************************************/
    var formObject=document.form;

    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
            case "btn_reset":
                loadPage2();
                resetForm(formObject);
                break;
            case "btn_add":
                document.all.TRSP_SO_COST_MONTH.value=document.all.trsp_otr_cost_mon_dt.value.substring(2,6);
                loadPage2();
                if(!validateForm(sheetObject,formObject, IBINSERT )) {
                    return false;
                }
                addSingleUnit();
                break;
            case 'btng_socreation':
                doActionIBSheet(sheetObject,formObject, IBSAVE);
                break;
            case 'btng_wopreview':
                gotoPreview(sheetObject,formObject);
                break;
            case "btng_woissue":
            	gotoIssue(sheetObject4, formObject);
            	break;
            case "btng_downexcel":
                doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "btn_minimize":
                if(document.all.MiniLayer.style.display != "none"){
                    document.all.MiniLayer.style.display="none";
				} else {
					document.all.MiniLayer.style.display = "";
                }
                    resizeSheet();
                break;
            case "btng_provider":
                rep_OnPopupClick();
                break;
            case "btn_fm_node":
                openHireYardPopup('fm_node');
                break;
            case "btn_via_node":
				if (ctMode == 1 || ctMode == 3)
					return;
                openHireYardPopup('via_node');
                break;
            case "btn_to_node":
                openHireYardPopup('to_node');
                break;
            case "btn_dr_node":
				if (ctMode == 1 || ctMode == 2)
					return;
                openHireYardPopup('dr_node');
                break;
            case 'btn_act_cus':
				if (ctMode == 1 || ctMode == 2)
					return;
                popActualCustomer(sheetObject,formObject);
                break;
            case 'btng_fillineq':
                popEqFileImport(sheetObject, formObject);
                break;
                // 2016.11.04 move this process to W/O Issue
//            case 'btng_rateapply':
//                getRateApply(sheetObject, formObject);
//                break;
            case 'btng_commodity':
                popCommodity();
                break;
            case 'btng_customer':
                popCustomer();
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowCodeMessage('COM12111');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj) {
   sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Setting sheets and initialization Implementing the onLoad event handler of body tag Adding the preceding function after loading page
 */
function loadPage() {
	for (i = 0; i < 1; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}

function loadPage2() {
    if(initFlag) {
        return;
    }
    for(i=1; i<sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initFlag=true;
}

/**
 * Define the initial values and headers of sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:
            with(sheetObj)  {
                  var HeadTitle1="STS||EQ No.|TP/SZ|Bound|Cargo\nType|Weight|Weight\nUOM|Cost\nMode|Trans\nMode|Commodity\nCode|COM/\nCNT|Cust\nCode|Cost\nMonth|From Node|From Node|Via Node|Via Node|To Node|To Node|Door\nLocation|Door\nLocation|Actual\nCustomer|Door Delivery\nAddress|Service Provider|Service Provider|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason|Rate Apply\nResult|SPCL\nCGO";
                  var HeadTitle2="STS||EQ No.|TP/SZ|Bound|Cargo\nType|Weight|Weight\nUOM|Cost\nMode|Trans\nMode|Commodity\nCode|COM/\nCNT|Cust\nCode|Cost\nMonth|Loc|Node|Loc|Node|Loc|Node|Loc|Zone|Actual\nCustomer|Door Delivery\nAddress|Provider Code|Provider Name|Currency|Basic\nAmount|Nego\nAmount|Fuel\nSurcharge|Additional\nAmount|Total\nAmount|Reference\nBKG No|Reference\nBL No|Reason|Rate Apply\nResult|SPCL\nCGO";
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);
        
                  var cols = [
                         {Type:"Status",    Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"CheckBox",  Hidden:0, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"ibcheck" },
                         {Type:"Text",      Hidden:0, Width:100, Align:"Center",  ColMerge:1,   SaveName:"eq_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Float",     Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:60,  Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:60,  Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cust_nomi_trkr_flg_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"trsp_otr_cost_mon_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"fm_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:40,  Align:"Center",  ColMerge:1,   SaveName:"fm_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"via_loc_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:40,  Align:"Center",  ColMerge:1,   SaveName:"via_yard_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"to_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:40,  Align:"Center",  ColMerge:1,   SaveName:"to_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"dr_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:40,  Align:"Center",  ColMerge:1,   SaveName:"dr_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"vndr_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Combo",     Hidden:1, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Float",     Hidden:1, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"bzc_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Float",     Hidden:1, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"nego_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Float",     Hidden:1, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"fuel_scg_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Popup",     Hidden:1, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"etc_add_amt",            KeyField:0,   CalcLogic:"",   Format:"",       PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Float",     Hidden:1, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"total_amt",              KeyField:0,   CalcLogic:"|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0, Width:100, Align:"Center",  ColMerge:1,   SaveName:"ref_bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"ref_bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:0, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"trsp_purp_rsn",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:1, Width:90,  Align:"Center",  ColMerge:1,   SaveName:"rate_apply",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Seq",       Hidden:1, Width:100, Align:"Center",  ColMerge:1,   SaveName:"surcharge_key" },
                         {Type:"Seq",       Hidden:1, Width:100, Align:"Center",  ColMerge:1,   SaveName:"inv_xch_rt" },
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_wy_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"act_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"act_cust_addr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"cust_nomi_trkr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"fctry_nm" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_nm" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_phn_no" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_fax_no" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd" },
                         {Type:"Text",      Hidden:1, Width:30,  Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd" },
                         {Type:"Text",      Hidden:1, Width:60,  Align:"Center",  ColMerge:1,   SaveName:"spcl_cgo_cntr_tp_cd" } ];

                  InitColumns(cols);

                  SetEditable(1);
//                  SetColProperty(0, 'curr_cd', {ComboText:"|"+default_currText, ComboCode:"|"+default_currCode} );
                  resizeSheet();
            }
            break;

        case 2:
            with(sheetObj)  {
                  var HeadTitle="";
                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
        
                  var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                         {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck" },
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nomi_trkr_flg_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_otr_cost_mon_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_loc_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_yard_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dr_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dr_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bzc_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"nego_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fuel_scg_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"etc_add_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"total_amt",              KeyField:0,   CalcLogic:"|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ref_bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_purp_rsn",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rate_apply",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"inv_xch_rt" },
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_wy_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_addr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nomi_trkr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fctry_nm" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_nm" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_phn_no" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_fax_no" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd" } ];
                   
                  InitColumns(cols);
        
                  SetEditable(1);
                  SetVisible(false);
                }
           break;

        case 3:   
                with(sheetObj) {
                      var HeadTitle="";
                      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
                      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                      var headers = [ { Text:HeadTitle, Align:"Center"} ];
                      InitHeaders(headers, info);
        
                      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck" },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",                  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_bnd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_meas_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cmdt_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nomi_trkr_flg_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_otr_cost_mon_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"via_loc_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"via_yard_value",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dr_loc_value",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dr_yard_value",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dor_de_addr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vndr_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bzc_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"nego_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"fuel_scg_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"etc_add_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"total_amt",              KeyField:0,   CalcLogic:"|bzc_amt|+|nego_amt|+|fuel_scg_amt|+|etc_add_amt|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ref_bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"trsp_purp_rsn",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1},
                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rate_apply",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"inv_xch_rt" },
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_rt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_wy_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_ofc_cty_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_agmt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_cnt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"act_cust_addr_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_nomi_trkr_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fctry_nm" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_nm" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_phn_no" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_fax_no" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_cd" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"via_nod_cd" },
                             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dor_nod_cd" } ];
                       
                      InitColumns(cols);        
                      SetEditable(1);
                      SetVisible(false);

                    }
           break;

        case 4:     
            with(sheetObj) {
                var HeadTitle="STS||Office|Cost Mded|Trans Mode|Bound|Remarks|Created Date|Creation Office|User ID" ;
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'unique_cd',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_ofc_cty_cd',          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_so_seq',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lgs_cost_full_nm',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'trsp_step_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scg_amt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incur_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'chss_no',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'dry_run_rlbl_pty_tp_cd',      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fne_cuz_desc',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'fumg_cost_tp_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'mgst_tpsz_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'insp_rf_pti_cstms_tp_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_knt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'lftg_cuz_desc',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'stop_loc_nod_cd',             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'grs_wgt',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'incrt_dt',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'scl_stop_plc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'sto_dys',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'ob_bkg_no',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'wt_hrs',                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'otr_rmk',                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scg_amt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incur_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_chss_no',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_dry_run_rlbl_pty_tp_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fne_cuz_desc',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_fumg_cost_tp_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_mgst_tpsz_cd',            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_insp_rf_pti_cstms_tp_cd', KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_knt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_lftg_cuz_desc',           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_stop_loc_nod_cd',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_grs_wgt',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_incrt_dt',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_scl_stop_plc_nod_cd',     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_sto_dys',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_ob_bkg_no',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_wt_hrs',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'inv_otr_rmk',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_bil_flg',               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_cnt_cd',                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cust_seq',                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_vndr_seq',              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_ofc_cd',                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_amt',                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'n3pty_desc',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_ofc_cd',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:10,   Align:"Center",  ColMerge:0,   SaveName:prefix+'cre_usr_id',                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(1);
                SetVisible(false);
            }
            break;

        case 5:
            with(sheetObj) {
        			 cnt=0;
                  var HeadTitle="sts|svc_ord|seq";
                  SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
                  InitHeaders(headers, info);
    
                  var cols = [ {Type:"Status",    Hidden:0, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                         {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0} 
                      ];
                  InitColumns(cols);
                  SetEditable(1);
                  SetVisible(false);
            }
           break;
/*
        case 6:     
            with(sheetObj) {
                cnt=0;
                var HeadTitle="";
                SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [
                    {Type:"Status", Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"ibflag" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"inv_xch_rt" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_trsp_agmt_ofc_cty_cd" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_trsp_agmt_seq" },
                    {Type:"Text",   Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"po_trsp_agmt_rt_tp_cd" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_way_type" },
                    {Type:"Text",   Hidden:0, Width:100, Align:"Center", ColMerge:0, SaveName:"po_trsp_agmt_rt_tp_nm" },
                    {Type:"Text",   Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"po_sp_type" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_cust_nomi_trkr_flg" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_cust_cnt_cd" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_cust_seq" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_cust_cnd_cd_seq" },
                    {Type:"Text",   Hidden:0, Width:60,  Align:"Center", ColMerge:0, SaveName:"po_local_curr_cd" },
                    {Type:"Text",   Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"po_basic_rt" },
                    {Type:"Text",   Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"po_fuel_scg_rt" },
                    {Type:"Text",   Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"po_over_wgt_scg_rt" },
                    {Type:"Text",   Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"po_local_curr_tot_amt" },
                    {Type:"Text",   Hidden:0, Width:80,  Align:"Center", ColMerge:0, SaveName:"po_usd_curr_tot_amt" },
                    {Type:"Text",   Hidden:0, Width:40,  Align:"Center", ColMerge:0, SaveName:"po_rtn_cd" },
                    {Type:"Text",   Hidden:0, Width:100, Align:"Center", ColMerge:0, SaveName:"po_rtn_msg" }
                ];

                InitColumns(cols);        
                SetEditable(1);
                SetVisible(false);
            }
        break;
*/
    }
}

/**
 * move to W/O Preview
 */
function gotoPreview(sheetObj, formOb) {
    var sheetObj1=sheetObjects[4];
    if(sheetObj1.RowCount()< 1) {
        ComShowCodeMessage('TRS90110');
        return false;
    }
	if (!ComShowCodeConfirm('TRS90227', sheetObj1.RowCount())) {
        return false;
    }
	if (sheetObj1.RowCount() > 0) {
        var cty_cd='';
        var seq_no='';
        var vndr_seq='';
        for(var i=1; i<sheetObj1.RowCount()+1; i++) {
            if(i!=1) {
                cty_cd += ',';
                seq_no += ',';
                vndr_seq += ',';
            }
            cty_cd += sheetObj1.GetCellValue(i, 'trsp_so_ofc_cty_cd');
            seq_no += sheetObj1.GetCellValue(i, 'trsp_so_seq');
            vndr_seq += sheetObj1.GetCellValue(i, 'vndr_seq');
            if(sheetObj1.GetCellValue(i, 'vndr_seq') == undefined || ComTrim(sheetObj1.GetCellValue(i, 'vndr_seq')) == '') {
                ComShowCodeMessage('TRS90099');
                return false;
            }
        }
        document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
        document.woForm.trsp_so_seq.value=seq_no;
        document.woForm.vndr_seq.value=vndr_seq;
        document.woForm.submit();
    }
    return;
}

/**
 * move to W/O Issue
 */
function gotoIssue(sheetObj, formObj) {
	if( sheetObj.RowCount()< 1 ) {
		ComShowCodeMessage("TRS90110");
		return false;
	}
	var cty_cd="";
	var seq_no="";
	for(var i=1; i<sheetObj.RowCount()+1; i++) {
		if( i == sheetObj.RowCount()) {
			cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd');
			seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq');
		} else {
			cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd') + ",";
			seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq') + ",";
		}
	}
	document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
	document.woForm.trsp_so_seq.value=seq_no;
	document.woForm.eq_mode.value="CG";
	document.woForm.pgmNo.value="ESD_TRS_0023";
	document.woForm.parentPgmNo.value="ESD_TRS_M001";
	document.woForm.action="ESD_TRS_0023.screen";
	document.woForm.submit();
    return;
}

// 
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		switch (sAction) {
            case IBSEARCH:      //Retrieve
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.f_cmd.value=SEARCH;
                sheetObj.DoSearch("ESD_TRS_0018GS.do" );
                break;
            case IBSAVE:        //Save
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                var sheetObj1=sheetObjects[1];
                var checkList=sheetObj.FindCheckedRow('ibcheck');
                if(checkList == '') {
                    ComShowCodeMessage('COM12176');
                    return false;
                }
                var checkArray=checkList.split('|');
//                for(var k=0; k<checkArray.length; k++) {
//                    var row=checkArray[k];
//                    if(sheetObj.GetCellValue(row, 'rate_apply') == '') {
//                        ComShowCodeMessage('COM12114', 'Rate Apply');
//                        sheetObj.SelectCell(row, 'rate_apply');
//                        return false;
//                    }
//                }
				if (checkArray.length < sheetObj.RowCount() && !ComShowCodeConfirm('TRS90500')) {
					return false;
				}
//				addSurchargeData();
//                var surchargeQuery='&'+sheetObjects[3].GetSaveString(true, false);
                sheetObj.RemoveEtcData();
                formObj.f_cmd.value=ADD;
                formObj.TRSP_SO_TP_CD.value='O';
                formObj.TRSP_SO_STS_CD.value='C'; //SO -C, WO - I
                var queryStr=sheetObj.GetSaveString(false, false, "ibcheck");
                var sheetObj2=sheetObjects[4];
                sheetObj2.DoSearch("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(formObj),{Sync:2} );
                break;
			case IBDOWNEXCEL:
				if (sheetObj.RowCount() < 1) {
                    ComShowCodeMessage("COM132501");
                } else {    
                    sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObj), SheetDesign:1, Merge:1 });    
                }    
              break;
			case IBINSERT:
                sheetObj.DataInsert();
                break;
        }
    } catch(e) {
        if(e == "[object Error]") {
            ComShowCodeMessage('COM12111');
        } else {
            ComShowMessage(e.message);
        }
    }
}

/**
 * Validating inputted values of form
 */
function validateForm(sheetObj, formObj, sAction) {
    switch(sAction) {
        case IBINSERT:      // add
            if(formObj.otherso_qty.value == '') {
                ComShowCodeMessage('COM12114', 'QTY');
                formObj.otherso_qty.focus();
                return false;
            } else if(formObj.trs_cost_md_cd.options[0].selected) {
                ComShowCodeMessage('COM12114', 'Cost Mode');
                formObj.trs_cost_md_cd.focus();
                return false;
            } else if(formObj.trs_md_cd.options[0].selected) {
                ComShowCodeMessage('COM12114', 'Trans Mode');
                formObj.trs_md_cd.focus();
                return false;
			} else if ((formObj.trs_cost_md_cd.options[1].selected || formObj.trs_cost_md_cd.options[2].selected || formObj.trs_cost_md_cd.options[3].selected || formObj.trs_cost_md_cd.options[4].selected) && formObj.trs_bnd_cd.options[0].selected) {
                ComShowCodeMessage('COM12114', 'Bound');
                formObj.trs_bnd_cd.focus();
                return false;
            } else if(formObj.trs_cago_tp_cd.options[0].selected) {
                ComShowCodeMessage('COM12114', 'Cargo Type');
                formObj.trs_cago_tp_cd.focus();
                return false;
            } else if(formObj.trs_cago_tp_cd.options[1].selected && formObj.cntr_wgt.value == '') {
                ComShowCodeMessage('COM12114', 'Weight');
                formObj.cntr_wgt.focus();
                return false;
            } else if(formObj.trs_cago_tp_cd.options[1].selected && formObj.trs_wgt_cd.options[0].selected) {
                ComShowCodeMessage('COM12114', 'Weight Unit');
                formObj.trs_wgt_cd.focus();
                return false;
            } else if(formObj.trs_cago_tp_cd.options[1].selected && formObj.commodity_cd.value == '') {
                ComShowCodeMessage('COM12114', 'Commodity Code');
                popCommodity();
                return false;
            } else if(formObj.trs_cnt_cd.options[0].selected) {
                ComShowCodeMessage('COM12114', 'NYK/CNT');
                formObj.trs_cnt_cd.focus();
                return false;
			} else if ((formObj.trs_cost_md_cd.value == 'ER' || formObj.trs_cost_md_cd.value == 'CN' || formObj.trs_cost_md_cd.value == 'CF') && formObj.trs_cnt_cd.value != 'NYK') {
                ComShowCodeMessage('COM12114', 'COST MODE AND NYK/CNT');
                formObj.trs_cnt_cd.focus();
                return false;
            } else if(formObj.trs_cnt_cd.options[2].selected && formObj.input_cust_cd.value == '') {
                ComShowCodeMessage('COM12114', 'Customer Code');
                popCustomer();
                return false;
            } else if(formObj.trsp_otr_cost_mon_dt.value.length != 6) {
                ComShowCodeMessage('COM12114', 'Cost Month');
                formObj.trsp_otr_cost_mon_dt.focus();
                return false;
            } else if(formObj.combo_svc_provider.value == '') {
                ComShowCodeMessage('COM12114', 'Service Provider');
                formObj.combo_svc_provider.focus();
                return false;
            } else if(formObj.search_fm_loc.value == '' || search_fm_yard.GetSelectCode()== '') {
                ComShowCodeMessage('COM12114', 'From');
                formObj.search_fm_loc.focus();
                return false;
            } else if(formObj.search_to_loc.value == '' || search_to_yard.GetSelectCode()== '') {
                ComShowCodeMessage('COM12114', 'To');
                formObj.search_to_loc.focus();
                return false;
            } else if(formObj.otherso_reason.value == '') {
                ComShowCodeMessage('COM12114', 'Reason');
                formObj.otherso_reason.focus();
                return false;
            }
            var fmNode=formObj.search_fm_loc.value + search_fm_yard.GetSelectCode();
            var viaNode=formObj.search_via_loc.value + search_via_yard.GetSelectCode();
            var toNode=formObj.search_to_loc.value + search_to_yard.GetSelectCode();
            var doorNode=formObj.search_dr_loc.value + search_dr_yard.GetSelectCode();
            switch(ctMode) {
                case 1:
                    if(fmNode == toNode) {
                        ComShowCodeMessage('COM12115', 'From yard And To yard');
                        formObj.search_fm_loc.focus();
                        return false;
                    }
                    break;
                case 2:
                    if(formObj.search_via_loc.value == '' || search_via_yard.GetSelectCode()== '') {
                        ComShowCodeMessage('COM12114', 'Via');
                        formObj.search_via_loc.focus();
                        return false;
                    } else if(fmNode == toNode) {
                        ComShowCodeMessage('COM12115', 'From yard And To yard');
                        formObj.search_fm_loc.focus();
                        return false;
                    } else if(fmNode == viaNode) {
                        ComShowCodeMessage('COM12115', 'From yard And Via yard');
                        formObj.search_fm_loc.focus();
                        return false;
                    } else if(viaNode == toNode) {
                        ComShowCodeMessage('COM12115', 'Via yard And To yard');
                        formObj.search_via_loc.focus();
                        return false;
                    }
                    break;
                case 3:
                    if(formObj.search_dr_loc.value == '' || search_dr_yard.GetSelectCode()== '') {
                        ComShowCodeMessage('COM12114', 'Door');
                        formObj.search_dr_loc.focus();
                        return false;
                    } else if(formObj.search_act_cust.value == '') {
                        ComShowCodeMessage('COM12114', 'Actual Customer');
                        formObj.door_delv_addr.focus();
                        return false;
                    } else if(formObj.door_delv_addr.value == '') {
                        ComShowCodeMessage('COM12114', 'Door Delivery Address');
                        formObj.door_delv_addr.focus();
                        return false;
                    } else if(fmNode == doorNode) {
                        ComShowCodeMessage('COM12115', 'From yard And Door yard');
                        formObj.search_fm_loc.focus();
                        return false;
                    } else if(toNode == doorNode) {
                        ComShowCodeMessage('COM12115', 'Door yard And To yard');
                        formObj.search_dr_loc.focus();
                        return false;
                    }
                    break;
                case 4:
                    if(formObj.search_via_loc.value == '' || search_via_yard.GetSelectCode()== '') {
                        ComShowCodeMessage('COM12114', 'Via');
                        formObj.search_via_loc.focus();
                        return false;
                    } else if(formObj.search_dr_loc.value == '' || search_dr_yard.GetSelectCode()== '') {
                        ComShowCodeMessage('COM12114', 'Door');
                        formObj.search_dr_loc.focus();
                        return false;
                    } else if(formObj.search_act_cust.value == '') {
                        ComShowCodeMessage('COM12114', 'Actual Customer');
                        formObj.door_delv_addr.focus();
                        return false;
                    } else if(formObj.door_delv_addr.value == '') {
                        ComShowCodeMessage('COM12114', 'Door Delivery Address');
                        formObj.door_delv_addr.focus();
                        return false;
                    } else if(fmNode == viaNode) {
                        ComShowCodeMessage('COM12115', 'From yard And Via yard');
                        formObj.search_fm_loc.focus();
                        return false;
                    } else if(viaNode == toNode) {
                        ComShowCodeMessage('COM12115', 'Via yard And To yard');
                        formObj.search_via_loc.focus();
                        return false;
                    } else if(fmNode == doorNode) {
                        ComShowCodeMessage('COM12115', 'From yard And Door yard');
                        formObj.search_fm_loc.focus();
                        return false;
                    } else if(toNode == doorNode) {
                        ComShowCodeMessage('COM12115', 'Door yard And To yard');
                        formObj.search_dr_loc.focus();
                        return false;
                    } else if(viaNode == doorNode) {
                        ComShowCodeMessage('COM12115', 'Via yard And Door yard');
                        formObj.search_via_loc.focus();
                        return false;
                    }
                    break;
            }
            break;

        case IBSAVE:
                var checkList = sheetObj.FindCheckedRow('ibcheck');
                var checkArray = checkList.split('|');
                for(var k = 0; k < checkArray.length; k++) {
                    var row = checkArray[k];
                    var cost_cd = sheetObj.GetCellValue(row, 'trsp_cost_dtl_mod_cd');
                    if(sheetObj.GetCellValue(row, 'eq_tpsz_cd').length < 1 ) {
                        ComShowCodeMessage('COM12114', 'EQ Type size Code');
                        sheetObj.SelectCell(row, 'eq_tpsz_cd');
                        return false;
                    }
                    if(sheetObj.GetCellValue(row, 'vndr_seq') == undefined || ComTrim(sheetObj.GetCellValue(row, 'vndr_seq')) == '' ) {
                        ComShowCodeMessage('TRS90099');
                        sheetObj.SelectCell(row, 'vndr_seq');
                        return false;
//                    }else if(sheetObj.GetCellValue(row, 'curr_cd') == undefined || ComTrim(sheetObj.GetCellValue(row, 'curr_cd')) == '' ) {
//                        ComShowCodeMessage('TRS90228');
//                        sheetObj.SelectCell(row, 'curr_cd');
//                        return false;
//                    }else if(sheetObj.GetCellValue(row, 'total_amt') == undefined || Number(sheetObj.GetCellValue(row, 'total_amt')) == 0 ) {
//                        ComShowCodeMessage('TRS90222');
//                        sheetObj.SelectCell(row, 'total_amt');
//                        return false;
                    }
                }
            break;
    }
    return true;
}

/**
 * Calling rep_commodity pop-up
 */
function rep_OnPopupClick() {
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
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
    ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 700, 520, 'getCOM_ENS_rep', '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Calling rep_commodity pop-up : The case selecting one item at pop-up page
 */
function getCOM_ENS_rep(rowArray) {
    var formObj=document.form;
    for(var i=0; i<rowArray.length; i++) {
        var colArray=rowArray[0];
        var colArray2=colArray[2];
        var colArray3=colArray[4];
        formObj.combo_svc_provider.value=colArray2;
        formObj.svc_provider.value=colArray3;
    }
}

/**
 * Loading the list of external combo box
 */
function getComboList(obj) {
    var yard_obj=null;
    var formObj=document.form;
    obj.value=obj.value.toUpperCase();
    if(obj.name == 'search_fm_loc') {
        yard_obj=search_fm_yard;
        if(formObj.trs_cost_md_cd.value == 'CN') {
            formObj.TRSP_SO_EQ_KIND.value='N';
        } else {
        	formObj.TRSP_SO_EQ_KIND.value='';
        }
    } else if(obj.name == 'search_via_loc') {
        yard_obj=search_via_yard;
        formObj.TRSP_SO_EQ_KIND.value='';
    } else if(obj.name == 'search_to_loc') {
        yard_obj=search_to_yard;
        if(formObj.trs_cost_md_cd.value == 'CF') {
            formObj.TRSP_SO_EQ_KIND.value='N';
        } else {
        	formObj.TRSP_SO_EQ_KIND.value='';
        }
    } else if(obj.name == 'search_dr_loc') {
        yard_obj=search_dr_yard;
        formObj.TRSP_SO_EQ_KIND.value='';
    } else {
        formObj.TRSP_SO_EQ_KIND.value='';
    }
    
    var locValue=obj.value;
    if(ComTrim(locValue) == '') {
        yard_obj.RemoveAll();
        return;
    }
    if (obj.name == 'search_dr_loc') {
        getZoneCombo(yard_obj, sheetObjects[0], formObj, locValue);
    } else {
        getYardCombo(yard_obj, sheetObjects[0], formObj, locValue);
    }
}

/**
 * enter check
 */
function enterCheck(obj) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    if(event.keyCode == 13) {
        switch(ComGetEvent("name")) {
            case 'search_fm_loc':
            case 'search_via_loc':
            case 'search_to_loc':
            case 'search_dr_loc':
                getComboList(obj);
                break;
            case 'combo_svc_provider':
                getTextVendorSeq(sheetObj, formObj, obj.value);
                break;
            case 'commodity_cd':
                getTextCmdtCd(sheetObj, formObj, obj.value);
                break;
            case 'input_cust_cd':
                formObj.input_cust_cd.value = formObj.input_cust_cd.value.toUpperCase();
                getTextCustCd(sheetObj, formObj, obj.value);
                break;
        }
    }
}

/**
 * General Node popup
 */
function openHireYardPopup( btn_obj ) {
    var formObject=document.form;
    var cmdt_cd_val="";   
    var rep_cmdt_cd_val="";   
    var cmdt_desc_val="";   
    var classId="getCOM_ENS_061_1";
    var xx1="";  //CONTI
    var xx2="";  //SUB CONTI
    var xx3="";  //COUNTRY
    var xx4="";  //STATE
    var xx5="";  //CONTROL OFFIC
    var xx6="";  //LOC CODE
    var xx7="";  //LOC NAME
    var xx8="";
    var xx9="";
    var v_mode="";
    var returnFunction='setFmNode';
	if (btn_obj == 'via_node')
		returnFunction = 'setViaNode';
	else if (btn_obj == 'to_node')
		returnFunction = 'setToNode';
	else if (btn_obj == 'dr_node')
		returnFunction = 'setDoorNode';
	if (btn_obj == 'dr_node') {
        v_mode="zone"
    } else {
        v_mode="yard";
    }
    var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v_mode;
    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 805, 500, returnFunction, '1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * Processing popSearchPiCommCodeGrid
 */
function popSearchPiCommCodeGrid(classID, midCD, cdName, sheetName, sRow, colCode, colName) {
    var myUrl=getPopupURL(POPUP_PI_COMM);
    var myOption=getPopupOption(POPUP_PI_COMM);
    var url;
	if (myWin != null)
		ComClosePopup();
    url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
    myWin=window.open(url, "piCommCodePop", myOption);
    myWin.focus();
}

/**
 * Setting fmNode from popup
 */
function setFmNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var loc=node.substring(0,5);
    var yard=node.substring(5,7);
    document.form.search_fm_loc.value=loc;
    getComboList(document.form.search_fm_loc);
    search_fm_yard.SetSelectCode(yard, true);
}

/**
 * Setting viaNode from popup
 */
function setViaNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var loc=node.substring(0,5);
    var yard=node.substring(5,7);
    document.form.search_via_loc.value=loc;
    getComboList(document.form.search_via_loc);
    search_via_yard.SetSelectCode(yard, true);
}

/**
 * Setting toNode from popup
 */
function setToNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var loc=node.substring(0,5);
    var yard=node.substring(5,7);
    document.form.search_to_loc.value=loc;
    getComboList(document.form.search_to_loc);
    search_to_yard.SetSelectCode(yard, true);
}

/**
 * Setting doorNode from popup
 */
function setDoorNode(rowArray) {
    var formObject=document.form;
    var colArray=rowArray[0];
    var node=colArray[3];
    var loc=node.substring(0,5);
    var yard=node.substring(5,7);
    document.form.search_dr_loc.value=loc;
    getComboList(document.form.search_dr_loc);
    search_dr_yard.SetSelectCode(yard, true);
}

/**
 * Adding each one when clicking ADD button
 */
function addSingleUnit() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var row=1;
    for(var i=0; i< formObj.otherso_qty.value; i++) {
        sheetObj.DataInsert(-1);
        row=sheetObj.RowCount()+1;
        sheetObj.SetCellValue(row, 'trsp_bnd_cd',formObj.trs_bnd_cd.value,0);// bound cd
        sheetObj.SetCellValue(row, 'cgo_tp_cd',formObj.trs_cago_tp_cd.value,0);// cago type cd
        sheetObj.SetCellValue(row, 'cntr_wgt',formObj.cntr_wgt.value,0);// container weight
        sheetObj.SetCellValue(row, 'wgt_meas_ut_cd',formObj.trs_wgt_cd.value,0);// weight measure unit cd
        sheetObj.SetCellValue(row, 'cmdt_cd',formObj.commodity_cd.value,0);// commodity cd
        sheetObj.SetCellValue(row, 'cust_nomi_trkr_flg_nm',formObj.trs_cnt_cd.value,0);// cust nominate tracker flag
        sheetObj.SetCellValue(row, 'cust_nomi_trkr_flg',(formObj.trs_cnt_cd.value=='CNT'?'Y':'N'),0);// cust nominate tracker flag
        sheetObj.SetCellValue(row, 'cust_cnt_cd_seq',formObj.input_cust_cd.value,0);// cust cnt cd seq
        sheetObj.SetCellValue(row, 'cust_cnt_cd',formObj.input_cust_cd.value.substring(0,2),0);// cust cnt cd
        sheetObj.SetCellValue(row, 'cust_seq',get_only_num(formObj.input_cust_cd.value),0);// cust seq
        sheetObj.SetCellValue(row, 'trsp_otr_cost_mon_dt',formObj.TRSP_SO_COST_MONTH.value,0);// cost month
        sheetObj.SetCellValue(row, 'fctry_nm',formObj.fctry_nm.value,0);// factory name
        sheetObj.SetCellValue(row, 'cntc_pson_nm',formObj.cntc_pson_nm.value,0);// container person name
        sheetObj.SetCellValue(row, 'cntc_pson_phn_no',formObj.cntc_pson_phn_no.value,0);// container person phone no
        sheetObj.SetCellValue(row, 'cntc_pson_fax_no',formObj.cntc_pson_fax_no.value,0);// container person fax no
        sheetObj.SetCellValue(row, 'eq_knd_cd',formObj.TRSP_EQ_KND_CD.value,0);// container person fax no
        sheetObj.SetCellValue(row, 'trsp_cost_dtl_mod_cd',formObj.trs_cost_md_cd.value,0);// cost mode
        sheetObj.SetCellValue(row, 'trsp_crr_mod_cd',formObj.trs_md_cd.value,0);// trans mode
        sheetObj.SetCellValue(row, 'vndr_seq',formObj.combo_svc_provider.value,0);// Service Provider code
        sheetObj.SetCellValue(row, 'vndr_desc',formObj.svc_provider.value,0);// Service Provider description
        sheetObj.SetCellValue(row, 'trsp_purp_rsn',formObj.otherso_reason.value,0);// Reason
        sheetObj.SetCellValue(row, 'fm_loc_value',formObj.search_fm_loc.value,0);// from location
        sheetObj.SetCellValue(row, 'fm_yard_value',search_fm_yard.GetSelectCode(),0);// from yard
        sheetObj.SetCellValue(row, 'fm_nod_cd',formObj.search_fm_loc.value+search_fm_yard.GetSelectCode(),0);
        sheetObj.SetCellValue(row, 'to_loc_value',formObj.search_to_loc.value,0);// to location
        sheetObj.SetCellValue(row, 'to_yard_value',search_to_yard.GetSelectCode(),0);// to yard
        sheetObj.SetCellValue(row, 'to_nod_cd',formObj.search_to_loc.value+search_to_yard.GetSelectCode(),0);
//        sheetObj.SetCellValue(row, 'etc_add_amt', '0.00', 0);// etc_add_amount
        if(formObj.trs_cago_tp_cd.value == "F") {
            sheetObj.SetCellValue(row, 'spcl_cgo_cntr_tp_cd', 'GP', 0);// spcl_cgo_cntr_tp_cd
        }
        
        switch(ctMode) {
            case 2:
				sheetObj.SetCellValue(row, 'via_loc_value', formObj.search_via_loc.value, 0);
                sheetObj.SetCellValue(row, 'via_yard_value',search_via_yard.GetSelectCode(),0);
                sheetObj.SetCellValue(row, 'via_nod_cd',formObj.search_via_loc.value+search_via_yard.GetSelectCode(),0);
                break;
            case 3:
                sheetObj.SetCellValue(row, 'dr_loc_value',formObj.search_dr_loc.value,0);// door location
                sheetObj.SetCellValue(row, 'dr_yard_value',search_dr_yard.GetSelectCode(),0);// door yard
                sheetObj.SetCellValue(row, 'dor_nod_cd',formObj.search_dr_loc.value+search_dr_yard.GetSelectCode(),0);
                sheetObj.SetCellValue(row, 'act_cust_cnt_cd_seq',formObj.search_act_cust.value,0);// Actual Customer
                sheetObj.SetCellValue(row, 'act_cust_cnt_cd',formObj.search_act_cust.value.substring(0,2),0);// Actual Customer
                sheetObj.SetCellValue(row, 'act_cust_seq',get_only_num(formObj.search_act_cust.value),0);// Actual Customer
                sheetObj.SetCellValue(row, 'dor_de_addr',formObj.door_delv_addr.value,0);// door delivery
                sheetObj.SetCellValue(row, 'act_cust_addr_seq',formObj.act_cust_addr_seq.value,0);// addr seq
                break;
            case 4:
				sheetObj.SetCellValue(row, 'via_loc_value', formObj.search_via_loc.value, 0);
                sheetObj.SetCellValue(row, 'via_yard_value',search_via_yard.GetSelectCode(),0);
                sheetObj.SetCellValue(row, 'via_nod_cd',formObj.search_via_loc.value+search_via_yard.GetSelectCode(),0);
                sheetObj.SetCellValue(row, 'dr_loc_value',formObj.search_dr_loc.value,0);// door location
                sheetObj.SetCellValue(row, 'dr_yard_value',search_dr_yard.GetSelectCode(),0);// door yard
                sheetObj.SetCellValue(row, 'dor_nod_cd',formObj.search_dr_loc.value+search_dr_yard.GetSelectCode(),0);
                sheetObj.SetCellValue(row, 'act_cust_cnt_cd_seq',formObj.search_act_cust.value,0);// Actual Customer
                sheetObj.SetCellValue(row, 'act_cust_cnt_cd',formObj.search_act_cust.value.substring(0,2),0);// Actual Customer
                sheetObj.SetCellValue(row, 'act_cust_seq',get_only_num(formObj.search_act_cust.value),0);// Actual Customer
                sheetObj.SetCellValue(row, 'dor_de_addr',formObj.door_delv_addr.value,0);// door delivery
                sheetObj.SetCellValue(row, 'act_cust_addr_seq',formObj.act_cust_addr_seq.value,0);// addr seq
                break;
        }
    }
}

/**
 * Opening popup page when Additional Amount is clicked
 */
function sheet_OnPopupClick(sheetObj, row, col) {
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
//        case 'etc_add_amt':
//            popSurchargeInputInquiry(sheetObj, row, col);
//            break;
    }
}

/**
 * Resetting the searching option
 */
function resetForm(formObj) {
    formObj.reset();
    formObj.otherso_qty.value='';
    formObj.trs_cost_md_cd.options[0].selected=true;
    formObj.trs_md_cd.options[0].selected=true;
    formObj.combo_svc_provider.value='';
    formObj.svc_provider.value='';
    formObj.search_fm_loc.value='';
    search_fm_yard.RemoveAll();
    formObj.search_via_loc.value='';
    search_via_yard.RemoveAll();
    formObj.search_to_loc.value='';
    search_to_yard.RemoveAll();
    formObj.search_dr_loc.value='';
    search_dr_yard.RemoveAll();
    formObj.search_act_cust.value='';
    formObj.door_delv_addr.value='';
    formObj.otherso_reason.value='';
}

/**
 * Resetting the searching option when COST MODE and TRANS MODE are changed
 */
function resetSearchCondition(selObj) {
    var formObj=document.form;
    formObj.combo_svc_provider.value='';
    formObj.svc_provider.value='';
    formObj.search_fm_loc.value='';
    search_fm_yard.RemoveAll();
    formObj.search_via_loc.value='';
    search_via_yard.RemoveAll();
    formObj.search_to_loc.value='';
    search_to_yard.RemoveAll();
    formObj.search_dr_loc.value='';
    search_dr_yard.RemoveAll();
    formObj.search_act_cust.value='';
    formObj.door_delv_addr.value='';
    formObj.otherso_reason.value='';
    var costMode=formObj.trs_cost_md_cd.value;
    var tranMode=formObj.trs_md_cd.value;
    // Confirming 4 conditions for setting whether activate searching options as COST MODE
	if ((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR')
		ctMode = 1;
	else if (!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode != 'DR')
		ctMode = 2;
	else if ((tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR')
		ctMode = 3;
	else if (!(tranMode == 'WD' || tranMode == 'TD' || tranMode == 'RD' || tranMode == 'WD') && costMode == 'DR')
		ctMode = 4;
    setKindEnabled();    // Activating/Deactivating searching options 
    if(selObj.name == 'trs_cost_md_cd') {
        sheetObjects[0].RemoveAll(); // Delete all content of sheet when cost mode is changed
    }
    
    // EQ_KND_CD - U:CONTAINER, Z:CHASSIS, G:GENSET
    if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ) {
        document.form.TRSP_EQ_KND_CD.value='U';
    } else if(costMode=='HD' || costMode=='HN' || costMode=='HF') {
        document.form.TRSP_EQ_KND_CD.value='Z';
    } else if(costMode=='GN' || costMode=='GF') {
        document.form.TRSP_EQ_KND_CD.value='G';
    } else {
        document.form.TRSP_EQ_KND_CD.value='';
    }
    if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS') {
        document.form.trs_cago_tp_cd.value='F';
        document.form.trs_cnt_cd.value='';
    } else if(costMode=='ER' || costMode=='CN' || costMode=='CF' ) {
        document.form.trs_cago_tp_cd.value='M';
        document.form.trs_cnt_cd.value='COM';
    } else {
        document.form.trs_cago_tp_cd.value='';
        document.form.trs_cnt_cd.value='';
    }
}

/**
 * Activating searching options as selecting the kind of COST MODE and TRANS MODE 
 */
function setKindEnabled() {
    var sheetObj=sheetObjects[0];
    var obj=document.form;
    switch(ctMode) {
        case 1:
            obj.search_via_loc.disabled=true;
            obj.search_dr_loc.disabled=true;
            search_via_yard.SetEnable(0);
            search_dr_yard.SetEnable(0);
            obj.search_act_cust.disabled=true;
            obj.door_delv_addr.disabled=true;
            obj.search_act_cust.disabled=true;
            obj.btn_act_cus.style.visibility="hidden";
            break;
        case 2:
            obj.search_via_loc.disabled=false;
            obj.search_dr_loc.disabled=true;
            search_via_yard.SetEnable(1);
            search_dr_yard.SetEnable(0);
            obj.search_act_cust.disabled=true;
            obj.door_delv_addr.disabled=true;
            obj.search_act_cust.disabled=true;
            obj.btn_act_cus.style.visibility="hidden";
            break;
        case 3:
            obj.search_via_loc.disabled=true;
            obj.search_dr_loc.disabled=false;
            search_via_yard.SetEnable(0);
            search_dr_yard.SetEnable(1);
            obj.search_act_cust.disabled=false;
            obj.door_delv_addr.disabled=false;
            obj.search_act_cust.disabled=false;
            obj.btn_act_cus.style.visibility="visible";
            break;
        case 4:
            obj.search_via_loc.disabled=false;
            obj.search_dr_loc.disabled=false;
            search_via_yard.SetEnable(1);
            search_dr_yard.SetEnable(1);
            obj.search_act_cust.disabled=false;
            obj.door_delv_addr.disabled=false;
            obj.search_act_cust.disabled=false;
            obj.btn_act_cus.style.visibility="visible";
            break;
    }
}

/**
 * number check
 */
function checkNumber(obj, delflag) {
    if(!ComIsNumber(obj)) {
        ComShowCodeMessage('COM12122', obj.name);
		if (delflag)
			obj.value = '';
    }
}

/**
 * file import popup
 */
function popEqFileImport(sheetObject, formObject) {
    if(sheetObject.RowCount()== 0) {
        ComShowCodeMessage('TRS90132');
        return false;
    }
    var myOption="width=500,height=355,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0950.do';
    myWin=ComOpenWindow('ESD_TRS_0950.do', 'popEqFileImport', 'top=200, left=200, width=500, height=380, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
}

/**
 * Getting data from file import popup
 */
function importEqNo(popSheetObj, obj) {
    var sheetObj=sheetObjects[0];
    var sheetObj2=sheetObjects[2];
    var checkList=popSheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    var row=0;
    var value='';
    var costMode=document.form.trs_cost_md_cd.value;
    if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ) {
        document.form.f_cmd.value=SEARCH04;
    } else if(costMode=='HD' || costMode=='HN' || costMode=='HF') {
        document.form.f_cmd.value=SEARCH05;
    } else if(costMode=='GN' || costMode=='GF') {
        document.form.f_cmd.value=SEARCH06;
    }
    var queryStr=popSheetObj.GetSaveString(false, false, "ibcheck");
    if(queryStr=='') {
        return false;
    }
    sheetObj2.DoSearch("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(document.form),{Sync:2} );
    for(var i=0; i < checkArray.length; i++) {
        if(popSheetObj.GetCellValue(checkArray[i], 'verify_result') != 'OK') {
            var new_row = sheetObj2.DataInsert(-1);
            sheetObj2.SetCellValue(new_row, 'eq_no',popSheetObj.GetCellValue(checkArray[i], 'eq_no'),0);
        }
    }
    // Making array with the rows which doesn't have eq_no
    var emptyEqArray=new Array();
    var cnt=0;
	for ( var k = 2; k < sheetObj.RowCount() + 2; k++) {
		if (sheetObj.GetCellValue(k, 'eq_no') == '')
			emptyEqArray[cnt++] = k;
    }
    cnt=0; // Counting inserted data
    var tempEqNo='';
    var loopLength=Math.min(sheetObj2.RowCount(),emptyEqArray.length);
    for(var k=0; k<loopLength;k++) {
        sheetObj.SetCellValue(emptyEqArray[k], 'eq_no',sheetObj2.GetCellValue(k+1, 'eq_no'),0);
        sheetObj.SetCellValue(emptyEqArray[k], 'eq_tpsz_cd',sheetObj2.GetCellValue(k+1, 'eq_tpsz_cd'),0);
    }
//    obj.close();
}

/*
 * 2016.11.04 move this process to W/O Issue
 * 
function getRateApply(sheetObj, formObj) {
    var checkList=sheetObj.FindCheckedRow('ibcheck');
    if(checkList == '') {
        ComShowCodeMessage('COM12176');
        return false;
    }
    var checkArray=checkList.split('|');
    var rateSheetObj=sheetObjects[5];
    formObj.f_cmd.value=SEARCH16;
    rateSheetObj.RemoveAll();
    var queryStr=sheetObj.GetSaveString(false, false, "ibcheck");
    rateSheetObj.DoSearch("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(formObj),{Sync:2} );

    var main_row;
    var find_row;
    for(var i=0; i<checkArray.length; i++) {
        if(rateSheetObj.RowCount() > 0) {
        	main_row = sheetObj.GetCellValue(checkArray[i], 'inv_xch_rt');
            find_row = rateSheetObj.FindText('inv_xch_rt', main_row, 0, 2);
            sheetObj.SetCellValue(checkArray[i], 'trsp_agmt_ofc_cty_cd',rateSheetObj.GetCellValue(find_row, "po_trsp_agmt_ofc_cty_cd"),0);
            sheetObj.SetCellValue(checkArray[i], 'trsp_agmt_seq',rateSheetObj.GetCellValue(find_row, "po_trsp_agmt_seq"),0);
            sheetObj.SetCellValue(checkArray[i], 'trsp_agmt_rt_tp_cd',rateSheetObj.GetCellValue(find_row, "po_trsp_agmt_rt_tp_cd"),0);
            sheetObj.SetCellValue(checkArray[i], 'trsp_agmt_wy_tp_cd',rateSheetObj.GetCellValue(find_row, "po_way_type"),0);
            sheetObj.SetCellValue(checkArray[i], 'cust_nomi_trkr_flg',rateSheetObj.GetCellValue(find_row, "po_cust_nomi_trkr_flg"),0);
            if (rateSheetObj.GetCellValue(find_row, "po_local_curr_cd") != '') {
                sheetObj.SetCellValue(checkArray[i], 'curr_cd',rateSheetObj.GetCellValue(find_row, "po_local_curr_cd"),0);
            }
            sheetObj.SetCellValue(checkArray[i], 'bzc_amt',rateSheetObj.GetCellValue(find_row, "po_basic_rt"),0);
            sheetObj.SetCellValue(checkArray[i], 'fuel_scg_amt',rateSheetObj.GetCellValue(find_row, "po_fuel_scg_rt"),0);
            sheetObj.SetCellValue(checkArray[i], 'total_amt',rateSheetObj.GetCellValue(find_row, "po_local_curr_tot_amt"),0);
            if(rateSheetObj.GetCellValue(find_row, "po_local_curr_cd") == undefined || ComTrim(rateSheetObj.GetCellValue(find_row, "po_local_curr_cd")) == '') {
                sheetObj.SetCellValue(checkArray[i], 'rate_apply', 'AGMT Not Found', 0);
            } else {
                sheetObj.SetCellValue(checkArray[i], 'rate_apply', 'Y', 0);
            }
        }
    }
}
*/

/**
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
// function sheet2_OnSearchEnd(sheetObj, errMsg)
// {
// var formObj=document.form;
// if( errMsg != '' ) {
// ComShowMessage(errMsg);
// }
// }
/**
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js
 */
function sheet4_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != '' ) {
        ComShowMessage(errMsg);
    } else {
        if(formObj.f_cmd.value == ADD) {
            ComShowCodeMessage('TRS90107');
            sheetObjects[0].RemoveAll();
            sheetObjects[3].RemoveAll();
        }
    }
}

/**
 * DataSheetObject.prototype.event_OnSearchEnd of IBSheetConfig.js 
 */
/*
function sheet5_OnSearchEnd(sheetObj, errMsg) {
    var formObj=document.form;
    if( errMsg != '' ) {
        ComShowMessage(errMsg);
    } else {
        if(formObj.f_cmd.value == SEARCH16) {
            ComShowCodeMessage('COM12116', 'Rate Apply');
        }
    }
}
*/

/**
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
/*
function sheet5_OnSaveEnd(sheetObj,errMsg) {
    if(errMsg!=null && errMsg != '') {
        ComShowMessage(errMsg);
    }
}
*/

/**
 * sheet click event
 */
function sheet_OnClick(sheetObj, row, col, value) {
    var colName=sheetObj.ColSaveName(col);
    switch(colName) {
        case 'eq_tpsz_cd':
            if(sheetObj.GetCellValue(row, 'eq_no') == '' || (sheetObj.GetCellValue(row, 'eq_no') != '' && sheetObj.GetCellValue(row, 'eq_tpsz_cd') == '')) {
                sheetObj.SetCellEditable(row, 'eq_tpsz_cd', 1);
            } else if(sheetObj.SetCellValue(row, 'eq_no') != '' && sheetObj.GetCellValue(row, 'eq_tpsz_cd') != '') {
                sheetObj.GetCellEditable(row, 'eq_tpsz_cd', 0);
            }
            break;
    }
}

// 
function sheet_OnChange(sheetObj, row, col, value) {
    var colName=sheetObj.ColSaveName(col);
    var formObj=document.form;
    switch(colName) {
        case('eq_no'):
            var costMode=formObj.trs_cost_md_cd.value;
            if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ) {
                value=cntrCheckDigit(value);
                formObj.f_cmd.value=SEARCH10;
            } else if(costMode=='HD' || costMode=='HN' || costMode=='HF') {
                formObj.f_cmd.value=SEARCH11;
            } else if(costMode=='GN' || costMode=='GF') {
                formObj.f_cmd.value=SEARCH12;
            }
            sheetObj.SetCellValue(row, col,value.toUpperCase(),0);
            var urlStr='ibflag=R&eq_no='+value+'&row='+row+'&col=eq_tpsz_cd';
            sheetObj.DoRowSearch(row, 'ESD_TRS_0018GS.do',urlStr+'&'+TrsFrmQryString(formObj), { Wait : 1, Sync : 1 });
            sheetObj.SetCellValue(row, 'ibcheck','1',0);
            break;
        case 'eq_tpsz_cd':
            sheetObj.RemoveEtcData();
            value=value.toUpperCase();
            var costMode=formObj.trs_cost_md_cd.value;
            if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ) {
                formObj.f_cmd.value=SEARCH14;
            } else if(costMode=='HD' || costMode=='HN' || costMode=='HF') {
                formObj.f_cmd.value=SEARCH12;
            } else if(costMode=='GN' || costMode=='GF') {
                formObj.f_cmd.value=SEARCH13;
            }
            formObj.EQ_TPSZ_CD.value=value;
            sheetObj.DoRowSearch(row, "ESD_TRS_0014GS.do",TrsFrmQryString(formObj), { Sync : 2 });
            sheetObj.SetCellValue(row, 'eq_tpsz_cd', value, 0);
            if (sheetObj.GetEtcData("eq_tpsz_cd") == undefined || sheetObj.GetEtcData("eq_tpsz_cd") == '') {
                ComShowCodeMessage('COM12114', 'Type size Code');
                sheetObj.SetCellValue( row, col,'',0);
                return;
            }
            break;
//        case('etc_add_amt'):
//            if(value== '' || Number(value)==0) {
//                var surcharge_sheetObj=sheetObjects[3];
//                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
//                 // Removing the values previously set 
//				for ( var a = surcharge_sheetObj.RowCount(); a > 0; a--) {
//					if (surcharge_sheetObj.GetCellValue(a, prefix + 'unique_cd') == unique_cd)
//						surcharge_sheetObj.RowDelete(a, false);
//                }
//            } else {
//                var surcharge_sheetObj=sheetObjects[3];
//                var unique_cd=sheetObj.GetCellValue(row, 'surcharge_key');
//                var sum=0;
//                for(var a=surcharge_sheetObj.RowCount(); a>0 ;a--) {
//                    if( surcharge_sheetObj.GetCellValue(a, prefix+'unique_cd') == unique_cd)
//                        sum += Number(surcharge_sheetObj.GetCellValue(a, prefix+'scg_amt'));
//                }
//                
//                if(sum != Number(deleteComma(value))) {
//                    ComShowCodeMessage('COM12114', 'Additional Etc Amount');
//                    sheetObj.SetCellValue(row, 'etc_add_amt',0,0);
//					for ( var a = surcharge_sheetObj.RowCount(); a > 0; a--) {
//						if (surcharge_sheetObj.GetCellValue(a, prefix + 'unique_cd') == unique_cd)
//							surcharge_sheetObj.RowDelete(a, false);
//                    }
//                }
//            }
//            break;
//        case('curr_cd'):
//            if(value == 'JPY' || value == 'KRW') {
//                setDecimalType(sheetObj, row);
//            } else {
//                setFloatingType(sheetObj, row);
//            }
//            break;
        case('fm_loc_value'):
        case('fm_yard_value'):
            sheetObj.SetCellValue(row, 'fm_nod_cd',sheetObj.GetCellValue(row, 'fm_loc_value')+sheetObj.GetCellValue(row, 'fm_yard_value'),0);
            break;
        case('to_loc_value'):
        case('to_yard_value'):
            sheetObj.SetCellValue(row, 'to_nod_cd',sheetObj.GetCellValue(row, 'to_loc_value')+sheetObj.GetCellValue(row, 'to_yard_value'),0);
            break;
        case('via_loc_value'):
        case('via_yard_value'):
            sheetObj.SetCellValue(row, 'via_nod_cd',sheetObj.GetCellValue(row, 'via_loc_value')+sheetObj.GetCellValue(row, 'via_yard_value'),0);
            break;
        case('dor_loc_value'):
        case('dor_yard_value'):
            sheetObj.SetCellValue(row, 'dor_nod_cd',sheetObj.GetCellValue(row, 'dor_loc_value')+sheetObj.GetCellValue(row, 'dor_yard_value'),0);
            break;
    }
}

/**
 * Actual Customer popup
 */
function popActualCustomer(sheetObject, formObject) {
    ComOpenPopup('ESD_TRS_0914.screen', 800, 600, 'window', '0,0', true);
}

/**
 * Getting data from Actual Customer popup
 */
function applyAtualCustomer(winObj, selected_row, act_cust_cd, act_cust_cnt_cd, act_cust_seq, act_cust_addr_seq, act_cust_nm, factory_nm, factory_zip_code, factory_addr, factory_tel_no, factory_fax_no, pic_nm) {
    var formObj=document.form;
    formObj.search_act_cust.value=act_cust_cd;
    formObj.door_delv_addr.value=(factory_addr==undefined?'':factory_addr);
    formObj.act_cust_addr_seq.value=(act_cust_addr_seq==undefined?'':act_cust_addr_seq);
}

/**
 * Surcharge Input Inquiry popup
 */
/*
function popSurchargeInputInquiry(sheetObj, row, col) {
    var myOption="width=773,height=805,menubar=0,status=0,scrollbars=0,resizable=0";
    var url='ESD_TRS_0918.screen';
    url += '?unique_cd='+sheetObj.GetCellValue(row, 'surcharge_key');
    url += '&open_mode=search';
    url += '&step_cd=WO';
    url += '&main_row='+row;
    url += '&sheet_arr_no=3';
    url += '&cgo_tp_cd='+sheetObj.GetCellValue(row, 'cgo_tp_cd');
    myWin=window.open(url, "popSurchargeInputInquiry", myOption);
    myWin.focus();
}
*/

/**
 * Getting data from Surcharge Input Inquiry popup
 */
/*
function setSurchargeInputInquiry(winObj, sheetObj, formObj, totalSum) {
    var row=formObj.main_row.value;
    var unique_cd=formObj.unique_cd.value;
    sheetObjects[0].SetCellValue(row, 'etc_add_amt',totalSum);
    for(var a=sheetObjects[3].RowCount(); a>0 ;a--) {
		if (sheetObjects[3].GetCellValue(a, prefix + 'unique_cd') == unique_cd)
			sheetObjects[3].RowDelete(a, false);
    }
    var queryStr=sheetObj.GetSaveString(true, true);
    if(queryStr !='') {
        var url='?prefix='+prefix;
        sheetObjects[3].DoSearch("ESD_TRS_0969.screen"+url, queryStr,{Sync:2} );
    }
  ComClosePopup(); 
}
*/

/**
 * Adding Fuel surcharge to surcharge sheet 
 */
/*
function addSurchargeData() {
    var mainSheetObj=sheetObjects[0];
    var surchargeSheetObj=sheetObjects[3];
    var checkList=mainSheetObj.FindCheckedRow('ibcheck');
    var checkArray=checkList.split('|');
    for(var k=0; k<checkArray.length; k++) {
        var main_row=checkArray[k];
        var fuelSurcharge=mainSheetObj.GetCellValue(main_row, 'fuel_scg_amt');
        var cgo_tp_cd=mainSheetObj.GetCellValue(main_row, 'cgo_tp_cd');
		if (cgo_tp_cd == 'F')
			cgo_tp_cd = 'C';
		else
			cgo_tp_cd = 'M';
        if(Number(fuelSurcharge) != 0) {
            var surcharge_row=surchargeSheetObj.DataInsert(-1);
            var trans_md=mainSheetObj.GetCellValue(main_row, 'trsp_crr_mod_cd');
            //trans mode uses only 6 codes
			if (trans_md == 'RW')
				trans_md = 'WR';
			else if (trans_md == 'TW')
				trans_md = 'WT';
			else if (trans_md == 'TR')
				trans_md = 'RT';
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'unique_cd',mainSheetObj.GetCellValue(main_row, 'surcharge_key'),0);
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'lgs_cost_cd','S'+cgo_tp_cd+'FU'+trans_md,0);
            surchargeSheetObj.SetCellValue(surcharge_row, prefix+'scg_amt',fuelSurcharge,0);
        }
    }
}
*/

/**
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet_OnSaveEnd(sheetObj, errCode, errMsg) {
	if(errCode >= 0) {
    if(errMsg!=null && errMsg != '') {
        ComShowMessage(errMsg);
    }
}
}

// Focusing
function fun_Focus(obj) {
    var val=removeBar(obj.value);
    obj.value=val;
    obj.select();
}

// 
function removeBar(str) {
    var value="";
    for ( var i=0; i < str.length; i++ ) {
        var ch=str.charAt(i);
		if (ch != '-')
			value = value + ch;
    }
    return value;
}

// commodity popup
function popCommodity() {
    ComOpenPopup('/opuscntr/COM_ENS_011.do', 780, 400, 'setCommodity', '1,0,1,1,1,1,1,1,1,1,1,1');
}

// Getting commodity code 
function setCommodity(rowArray) {
    var formObj=document.form;
    if(rowArray.length>0) {
        formObj.commodity_cd.value=rowArray[0][2];
        formObj.commodity_nm.value=rowArray[0][3];
    }
}

/**
 * customer popup
 */
function popCustomer() {
    ComOpenPopup('/opuscntr/COM_ENS_041.do', 800, 460, 'setCustomerPop', '1,0,1,1,1,1,1,1');
}

/**
 * Getting value from customer popup
 */
function setCustomerPop(rowArray) {
    var formObj=document.form;
    var colArray='';
    if(rowArray.length>0) {
        formObj.input_cust_cd.value=rowArray[0][3];
        formObj.input_cust_nm.value=rowArray[0][4];
    }
}

/**
 * Using only number
 */
function get_only_num(obj) {
    var str=escape(obj);
    var returnNum='';
    for (i=0; i<str.length; i++) {
        if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57 )
        	returnNum += str.charAt(i);
    }
    return returnNum;
}

/**
 * Inputting Customer Code 
 */
function setCntCombo(obj) {
    var formObj=document.form;
    if(obj.value == '') {
        formObj.input_cust_nm.value='';
        formObj.trs_cnt_cd.options[1].selected=true;
    } else {
        formObj.trs_cnt_cd.options[2].selected=true;
    }
}

/**
 * Inputting Cost Month
 */
function checkCostMonth(obj) {
    obj.value=get_only_num(obj.value);
    if(obj.value.length != 4) {
        ComShowCodeMessage('COM12114', 'Month');
        obj.focus();
        return;
    } else if(isNaN(Number(obj.value.substring(2,4)))) {
        ComShowCodeMessage('COM12114', 'Month');
        obj.focus();
        return;
    } else if(Number(obj.value.substring(2,4)) > 12) {
        ComShowCodeMessage('COM12114', 'Month');
        obj.focus();
        return;
    } else if(Number(obj.value.substring(2,4)) < 1) {
        ComShowCodeMessage('COM12114', 'Month');
        obj.focus();
        return;
    }
}

/**
 * Resetting the searching option
 */
/*
function setDecimalType(sheetObj, row) {
    sheetObj.InitCellProperty(row, 'bzc_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'fuel_scg_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.InitCellProperty(row, 'total_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
    sheetObj.SetCellValue(row, 'bzc_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'bzc_amt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'fuel_scg_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'fuel_scg_amt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'total_amt',chkAmtPos_JPY(sheetObj.GetCellValue(row, 'total_amt')),0);
    var surcharge_sheetObj=sheetObjects[3];
    var sur_key=sheetObj.GetCellValue(row, 'surcharge_key');
    for(var i=1; i<surcharge_sheetObj.RowCount()+1; i++) {
        if(sur_key == surcharge_sheetObj.GetCellValue(i, prefix+'unique_cd')) {
            surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
            surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt',{ Type:"Null",Align:"Null",Format:"dfInteger",PointCount:0} );
            surcharge_sheetObj.SetCellValue(i, prefix+'scg_amt',chkAmtPos_JPY(surcharge_sheetObj.GetCellValue(i, prefix+'scg_amt')),0);
            surcharge_sheetObj.SetCellValue(i, prefix+'n3pty_amt',chkAmtPos_JPY(surcharge_sheetObj.GetCellValue(i, prefix+'n3pty_amt')),0);
        }
    }
}
*/

/**
 * Resetting the searching option
 */
/*
function setFloatingType(sheetObj, row) {
    sheetObj.InitCellProperty(row, 'bzc_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'nego_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'fuel_scg_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'etc_add_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.InitCellProperty(row, 'total_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
    sheetObj.SetCellValue(row, 'bzc_amt',chkAmtPos(sheetObj.GetCellValue(row, 'bzc_amt')),0);
    sheetObj.SetCellValue(row, 'nego_amt',chkAmtPos(sheetObj.GetCellValue(row, 'nego_amt')),0);
    sheetObj.SetCellValue(row, 'fuel_scg_amt',chkAmtPos(sheetObj.GetCellValue(row, 'fuel_scg_amt')),0);
    sheetObj.SetCellValue(row, 'etc_add_amt',chkAmtPos(sheetObj.GetCellValue(row, 'etc_add_amt')),0);
    sheetObj.SetCellValue(row, 'total_amt',chkAmtPos(sheetObj.GetCellValue(row, 'total_amt')),0);
    var surcharge_sheetObj=sheetObjects[3];
    var sur_key=sheetObj.GetCellValue(row, 'surcharge_key');
    for(var i=1; i<surcharge_sheetObj.RowCount()+1; i++) {
        if(sur_key == surcharge_sheetObj.GetCellValue(i, prefix+'unique_cd')) {
            surcharge_sheetObj.InitCellProperty(i, prefix+'scg_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
            surcharge_sheetObj.InitCellProperty(i, prefix+'n3pty_amt',{ Type:"Null",Align:"Null",Format:"dfFloat",PointCount:2} );
            surcharge_sheetObj.SetCellValue(i, prefix+'scg_amt',chkAmtPos(surcharge_sheetObj.GetCellValue(i, prefix+'scg_amt')),0);
            surcharge_sheetObj.SetCellValue(i, prefix+'n3pty_amt',chkAmtPos(surcharge_sheetObj.GetCellValue(i, prefix+'n3pty_amt')),0);
        }
    }
}
*/

function BlurDate(obj) {
	if (obj.value == "") {
       return;
   }
   if ( !ComIsDate(obj,"ym") ) {
        errMsg=ComGetMsg("TRS90376");
        ComShowMessage(errMsg);
        obj.focus();
        return ;
    }
}

// 
function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}
