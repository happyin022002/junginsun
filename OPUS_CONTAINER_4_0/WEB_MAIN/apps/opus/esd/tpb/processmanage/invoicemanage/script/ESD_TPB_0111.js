/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0111.js
*@FileTitle  : TPB Invoice Revise/Cancel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/

/* Global Variables */
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var readOnly = true;
var tabObjects = new Array();
var tabCnt = 0;
// collection activity global variables
var s_clt_agn_flg = ""; // now final status (in the db system)
var isSaveEnd = true;
//Sheet Column 위치
var colLoc = new Array();

/* Event handler defined process to button click event */
document.onclick = processButtonClick;

/* Event handler is branch processing by name of button */
function processButtonClick() {
    /***** Assignment sheet in case of over 2 by tab ****/
    var sheetObject = sheetObjects[curTab - 1];
    /******************************************************/
    var formObject = document.form;
    if (curTab == 2)
        formObject = document.form2;
    //  		try {
    var srcName = ComGetEvent("name");
    switch (srcName) {
        case "btn_new":
            location.href = "ESD_TPB_0111.do?pgmNo=ESD_TPB_0111&parentPgmNo=ESD_TPB_M001";
            break;

        case "bttn_add":
            doActionIBSheet(sheetObject, formObject, IBINSERT);
            break;

        case "btn_save":
            var tot_amt = ComGetUnMaskedValue(document.form.s_total_amt.value, "float");
            if (!isSaveable()) {
                ComShowCodeMessage("TPB90091");
                return;
            }
            if (tot_amt < 0.00) {
                ComShowCodeMessage('TPB90033', 'Total Amount', '0.00');
            } else {
                doActionIBSheet(sheetObject, formObject, IBSAVE);
            }
            break;

        case "bttn_remove":
            break;

        case "btn_preview":
            if (s_clt_agn_flg == "Y") {
                document.all.btn_preview.disabled = true;
            } else {
                document.all.btn_preview.disabled = false;
            }
            if (document.all.btn_preview.disabled) {
                ComShowCodeMessage("TPB90009", "", "", "");
                return;
            }
            if (formObject.s_n3pty_inv_no.value == '') {
                ComShowCodeMessage("COM12151", "Invoice", "", "");
                return;
            }
            var s_dao_n3pty_bil_tp_cd = formObject.s_dao_n3pty_bil_tp_cd.value;
            var s_n3pty_inv_no = formObject.s_n3pty_inv_no.value;
            var s_n3pty_inv_his_seq = formObject.s_n3pty_inv_his_seq.value;
            var s_n3pty_inv_rmd_cd = formObject.s_n3pty_inv_rmd_cd.value;
            var s_final_flg = formObject.s_final_flg.value;

            var s_n3pty_no = formObject.s_n3pty_no.value;
            var s_trd_party_val = formObject.s_trd_party_val.value;

            openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd, s_final_flg, s_n3pty_no, s_trd_party_val);
            break;

        case "bttn_excel":
            doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
            break;

        case "bttn_print":
            doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
            break;

        case "bttn_search":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;

        case "btns_calendar":
            var cal = new ComCalendar();
            cal.select(formObject.s_rcv_due_dt, 'yyyy-MM-dd');
            break;

        case "btn_alertConfirm":
            doActionIBSheet(sheetObject, formObject, IBSAVE);
            break;

        case "btn_invoicesheetset":
            openInvoiceSheetSetPopupWin(formObject);
            amtReCalculate();
            break;

        case "btn_collectionactivity":
            if (formObject.s_n3pty_no.value.length == 14) {
                openRecoveryActPopup(formObject.s_n3pty_no.value, formObject.s_n3pty_inv_no.value, '', 'N');
            } else {
                ComShowMessage('Input valid TPB No.');
            }
            break;

        case "btn_settlement":
            var ots = formObject.s_detail_ots_sts_cd.value;
            var otsArr = ots.split("|");
            for (var i = 0; i < otsArr.length; i++) {
                if (otsArr[i] != 'O' && otsArr[i] != 'J' && otsArr[i] != 'L' && otsArr[i] != 'M') {
                    ComShowCodeMessage('TPB90056', '', '', '');
                    return;
                }
            }
            location.href = "ESD_TPB_0015.do?n3pty_no=" + formObject.s_detail_n3pty_no.value + "&f_cmd=" + SEARCH;
            break;

        case "btn_caremarks":
            if (document.all.btn_caremarks.disabled) return;
            //  					var s_clt_agn_rmk=document.all.s_clt_agn_rmk.value;
            //  					var theURL="ESD_TPB_0803.do?s_clt_agn_rmk="+s_clt_agn_rmk;
            //  					var winName="ESD_TPB_0803";
            //  					var features="scroll:no;status:no;help:no;dialogWidth:405px;dialogHeight:330px";
            //  					var rtnValue=ComOpenWindow(theURL,  window,  features , true);

            var s_clt_agn_rmk = document.all.s_clt_agn_rmk.value;
            var theURL = "ESD_TPB_0803.do?s_clt_agn_rmk=" + s_clt_agn_rmk;
            ComOpenPopup(theURL, 480, 280, "setCLREmark", "0,0,1,1,1,1,1", true);

            //  	  		    	if(rtnValue != undefined && rtnValue != null ){
            //  	  		    		document.all.s_clt_agn_rmk.value=rtnValue;
            //  	  		    	}
            break;

        case "btn_cancel":
            if (!document.all.btn_cancel.disabled) {
                openInvoiceCancelRemarkPopup();
            } else {
                ComShowCodeMessage('TPB90021', '', '', '');
                return;
            }
            break;

        case "btn_erpInterface":
            if (ComShowConfirm(ComGetMsg("TPB90008", "", "", ""))) {
                doActionIBSheet(sheetObject, formObject, ADD);
            }
            break;

        case "btn_3rdParty":
            get3rdParty(document.all.s_vndr_cust_div_cd.value);
            break;

        case "btn_retrieve":
            doActionIBSheet(sheetObject, formObject, COMMAND01);
            break;

    } // end switch
    //  		}catch(e) {			
    //  			if( e == "[object Error]") {
    //  				ComShowMessage(getMsg('COM12111'));
    //  			} else {
    //  				ComShowMessage(e);
    //  			}
    //  		}
}

/**
 * Setting IBTab Object Initial.
 * Tab ID is tab1,tab2,...
 * InitTab() function is called before the loadPage() function call from setupPage() function.
 */
function InitTab(tab) {
    try {
        with(tab) {
            InsertItem("Tanker Index", "");
            InsertItem("Tanker Index", "");
            InsertItem("Time Charter", "");
            InsertItem("Bunker Price", "");
            InsertItem("Ship Price", "");
            InsertItem("FFA Index", "");
        }
    } catch (e) {
        ComShowMessage(e.message);
    }
}

/**
 * onChange event of tab1
 * Implementing defined function from IBSheetConfig.js
 */
function tab1_OnChange(nItem) {
    ChangeTab(document.all.tab1, nItem);
}

/**
 * Showing tab contents in case of clicking IBTab Object
 * ID of Grouped each tab DIV TAG defined "tabLayer"
 */
function ChangeTab(tabObj, nItem) {
    formObject = document.form;
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        //Setting startup environment. Change the name of the function
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        //Setting final environment.
        ComEndConfigSheet(sheetObjects[i]);
        sheetObjects[i].SetVisible(false);
    }
    getCurrencyList();
    ComOpenWait(true);
    document.form.s_clt_agn_flg.onchage = s_clt_agn_flg_OnChange;
    var s_correction_yn = document.form.s_correction_yn.value;
    if (s_correction_yn == "Y") { // Added In 2008-06-04
        document.form.s_vndr_cust_div_cd.value = document.form.s_h_vndr_cust_div_cd.value;
        document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange;
        document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus;
        document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;
    }
    if (document.all.s_detail_n3pty_no.value != "" || document.all.s_n3pty_inv_no.value != "") {
        doActionIBSheet(sheetObjects[sheetObjects.length - 1], document.form, IBSEARCH);
        editInit();
    } else {
        document.all.btn_retrieve.style.display = "";
        document.all.s_n3pty_inv_no.readOnly = false;
    }
    if (document.form.s_n3pty_inv_no.value == "") {
        //			document.form.s_curr_cd.disabled=true;
    }
    ComOpenWait(false);
}

function editInit() {
    document.all.btn_preview.style.display = "";
    var s_same_version_yn = document.all.s_same_version_yn.value;
    var s_correction_yn = document.all.s_correction_yn.value;
    var s_inquiryOnly_yn = document.all.s_inquiryOnly_yn.value;;
    if (s_inquiryOnly_yn == "Y") {
        //              document.all.s_curr_cd.disabled=true;
        document.all.s_vat_xch_rt_chk.disabled = true;
        document.all.s_clt_agn_flg.disabled = true;
        for (i = 0; i < sheetObjects.length; i++) {
            sheetObjects[i].SetEditable(0);
        }
        // } else if (s_same_version_yn=="Y" && s_correction_yn=="Y"){
    } else if (s_correction_yn == "Y") {
        readOnly = false;
        document.all.btn_cancel.disabled = false;
        document.all.btn_cancel.style.display = "";
        document.all.btn_save.disabled = false;
        document.all.btn_save.style.display = "";
    } else {
        document.all.s_curr_cd.disabled = true;
        document.all.s_vat_xch_rt_chk.disabled = true;
        document.all.s_clt_agn_flg.disabled = true;
        for (i = 0; i < sheetObjects.length; i++) {
            sheetObjects[i].SetEditable(0);
        }
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	sheetObj.UseUtf8=true;
	//switch(sheetNo) {
	//case 1:	  //IBSheet1 init
	if(sheetNo != sheetObjects.length){ 
		with (sheetObj) {		
			var cnt=0;
			
			var HeadTitle="Del.|STS|Seq.|Invoice No|TPB No.|Billing Case|Billing Case Name|EQ Kind|EQ No.|TP/SZ|BKG No.|B/L No.|VVD|VVD|MG Set No.|Location|Route|New EQ No.|New Seal No.|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|CSR No.|GL Date|Original AMT|Invoice AMT|||||||||||||||||||VAT|VAT AMT";
			sheetNo="";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"delChkBox",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
						{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" },
						{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
						{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_knd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no_all",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_all",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"mgset_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:230,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"route",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
						{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_cntr_seal_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
						{Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cita_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
						{Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cntr_wgt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
						{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_cntr_wgt_ut_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
						{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"wt_hrs",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
						{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"occr_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"new_bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
						{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"damage_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"repair_location",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lst_free_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"pkup_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ft_ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gl_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"ots_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"inv_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:17 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_knd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fm_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"via_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"dor_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no_split",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"estm_svr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"n3pty_inv_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"original_inv_dtl_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"so_if_seq",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ots_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vat_dtl_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
						{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"vat_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:17 } ];
			
			InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(120);
			SetColProperty(sheetNo+"n3pty_cntr_wgt_ut_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
			
			SetImageList(0,"/opuscntr/img/opus/button/btns_calendar.gif");		   
		
		}
	}else{
		//break;
		//case 2:	  //IBSheet2 init
		with (sheetObj) {
			var cnt=0;			
			//  				   (55, 0, 0, true);
			var HeadTitle="Del.|STS|Seq.|Invoice No|TPB No.|Billing Case|Billing Case Name|EQ Type|EQ No.|TP/SZ|BKG No.|B/L No.|MG Set No.|VVD|Location|Route|Citation No.|Weight|UOM|Waiting Time(Hr)|Occured Date|New VVD|New BKG No.|Damaged Date|Repair Location|Last Free Date|Pick-up Date|Over Day|New EQ No.|New Seal No.|OTS AMT|Invoice AMT||||||||||||||||||||||VAT|VAT AMT";
			sheetNo="";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"delChkBox",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
						{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" },
						{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"seq" },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_inv_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"n3pty_bil_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_knd_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bkg_no_all",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"bl_no_all",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"mgset_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"yd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"route",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_cntr_seal_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"cita_no",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"cntr_wgt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"n3pty_cntr_wgt_ut_cd", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"wt_hrs",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"occr_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Popup",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"new_bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"damage_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Popup",     Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"repair_location",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"lst_free_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Date",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"pkup_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"ft_ovr_dys",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gl_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"ots_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"inv_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"eq_knd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"fm_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"via_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"to_nod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"dor_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bkg_no_split",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bl_no_tp",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"bl_no_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"vsl_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"skd_voy_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"skd_dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"estm_svr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"n3pty_inv_dtl_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Right",   ColMerge:1,   SaveName:sheetNo+"original_inv_dtl_amt", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"so_if_seq",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ots_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vat_dtl_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
						{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:sheetNo+"vat_dtl_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:17 } ];
			
			InitColumns(cols);
			SetEditable(0);
			SetColEditable("vat_dtl_chk",1);
			SetSheetHeight(120);
		}
		//break;
	}
}

function setCLREmark(rtnValue) {
    if (rtnValue != undefined && rtnValue != null) {
        document.all.s_clt_agn_rmk.value = rtnValue.s_clt_agn_rmk;
    }
}

/* Processing Sheet */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            //Retrieving hidden sheet
            formObj.f_cmd.value = SEARCH;
            var x = sheetObj.GetSearchData("ESD_TPB_0111GS.do", tpbFrmQryStr(formObj));
            sheetObj.LoadSearchData(x, {
                Sync: 1
            });
            var bilArr = tpb_getBillingCase(sheet0); //Billing case array
            tpb_makeTabLoad(formObj, sheetObjects, bilArr[0], x);
            formObj.s_dao_n3pty_bil_tp_cd.value = bilArr[1].join("','");
            //Initializing currency value in case of screen loading
            if (document.form.s_from_curr_cd.value == "") {
                document.form.s_from_curr_cd.value = document.form.s_curr_cd.value;
                lastSelectedCurrency = document.form.s_curr_cd.value; // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
            } else {
                //in case of currency changing
                if (document.form.s_from_curr_cd.value != "") {
                    for (var i = 0; i < sheetObjects.length - 1; i++) {
                        for (var j = 1; j <= sheetObjects[i].RowCount(); j++) {
                            sheetObjects[i].SetRowStatus(j, "U");
                        }
                    }
                }
            }
            amtReCalculate();
            break;

        case IBSAVE: //Save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            if (formObj.s_curr_cd.value == "") {
                ComShowCodeMessage("COM12113", "Currency", "", "");
                return false;
            }
            //Total amount(KRW,JPY,VND) only integer
            if ((formObj.s_curr_cd.value == "KRW" || formObj.s_curr_cd.value == "JPY" || formObj.s_curr_cd.value == "VND")) {
                var totAmt = ComGetUnMaskedValue(formObj.s_total_amt.value, "float");
                var addAmt = ComGetUnMaskedValue(formObj.s_add_amt.value, "float");
                var ddctAmt = ComGetUnMaskedValue(formObj.s_ddct_amt.value, "float");
                if (parseFloat(addAmt) - parseInt(addAmt) > 0) {
                    ComShowCodeMessage("TPB90093");
                    return false;
                }
                if (parseFloat(ddctAmt) - parseInt(ddctAmt) > 0) {
                    ComShowCodeMessage("TPB90094");
                    return false;
                }
                if (parseFloat(totAmt) - parseInt(totAmt) > 0) {
                    ComShowCodeMessage("TPB90024", "", "", "");
                    return false;
                }
            }
            var msg = ComGetMsg("TPB90054");
            if (formObj.s_n3pty_inv_sts_cd.value == "A") {
                msg += "\n\n" + ComGetMsg("TPB90057");
            }
            if (ComShowConfirm(ComGetMsg("TPB90054"))) {
                var s_h_vndr_cust_div_cd = formObj.s_h_vndr_cust_div_cd.value;
                var s_trd_party_code = formObj.s_trd_party_code.value;
                /// on save
                for (var i = 0; i < sheetObjects.length - 1; i++) {
                    for (var j = 1; j <= sheetObjects[i].RowCount(); j++) {
                        sheetObjects[i].SetRowStatus(j, "U");
                    }
                }
                //Calculating Invoice Amount
                var sum_save_string = "";
                var sum_inv_amt = 0;
                for (var i = 0; i < sheetObjects.length - 1; i++) {
                    for (var j = 1; j <= sheetObjects[i].RowCount(); j++) {
                        var tmp_ots_amt = parseFloat(sheetObjects[i].GetCellValue(j, 33)); //ots_amt // be careful
                        var tmp_inv_dtl_amt = parseFloat(sheetObjects[i].GetCellValue(j, 34)); //inv_dtl_amt // be careful
                        sum_inv_amt += tmp_inv_dtl_amt;
                    }
                    sum_save_string += sheetObjects[i].GetSaveString();
                    sum_save_string += "&";
                }
                if (document.form.cnt_cd.value == "IN") {
                    formObj.s_sum_inv_amt.value = ComGetUnMaskedValue(document.form.lst_invoice_total.value, "float");
                } else {
                    formObj.s_sum_inv_amt.value = ComGetUnMaskedValue(document.form.s_total_amt.value, "float");
                }
                // TOTAL INVOICE AMOUNT CHECK -----  
                var sum_inv_amt = formObj.s_sum_inv_amt.value;
                try {
                    sum_inv_amt = sum_inv_amt - 0.00;
                } catch (e) {
                    ComShowCodeMessage('COM12111');
                    return;
                }
                if (sum_inv_amt <= 0.0) {
                    ComShowCodeMessage('TPB90035', 'Total Amount ', '0.00 ');
                    return;
                }
                if (document.form.cnt_cd.value == 'IN') {
                    if (document.form.lst_tax.value.length != 0) {
                        document.form.s_vat_amt.value = ComGetUnMaskedValue(document.form.lst_tax.value, "float");
                    }
                }
                document.form.s_net_amt.value = ComGetUnMaskedValue(document.form.s_net_amt.value, "float");
                formObj.f_cmd.value = MULTI;
                var sXml = sheetObjects[sheetObjects.length - 1].GetSaveData("ESD_TPB_0111GS.do", sum_save_string + tpbFrmQryStr(formObj));
                //ComShowMessage(sXml);
                sheetObjects[sheetObjects.length - 1].LoadSaveData(sXml);
            }
            break;

        case ADD: //ERP I/F
            formObj.f_cmd.value = ADD;
            div_processing_show(); // show processing image
            var sXml = sheetObjects[sheetObjects.length - 1].GetSaveData("ESD_TPB_0111GS.do", tpbFrmQryStr(formObj));
            //ComShowMessage(sXml);
            sheetObjects[sheetObjects.length - 1].LoadSaveData(sXml);
            div_processing_hide(); // hide processing image
            var s_cnt_cd = document.form.s_cnt_cd.value;
            if (s_cnt_cd == 'IN') {
                var ttl_amt = minusFloat(addFloat(v("s_net_amt"), v("s_add_amt")), v("s_ddct_amt"));
                formObj.s_total_amt.value = ComAddComma2(ttl_amt + "", "#,###.00", ",", "");
            } else {
                formObj.s_vat_amt.value = ComAddComma2(sheetObj.GetEtcData("s_vat_amt") + "", "#,###.00");
                formObj.s_total_amt.value = ComAddComma2(sheetObj.GetEtcData("s_total_amt") + "", "#,###.00");
            }
            break;

        case IBINSERT: //Insert
            var Row = sheetObj.DataInsert();
            break;

        case IBCLEAR: //Clear
            sheetObj.RemoveAll();
            break;

        case IBDOWNEXCEL: //Excel download
            if (sheetObj.RowCount() < 1) { //no data
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel(TPBDown2ExcelOptions);
            }
            break;

        case COMMAND01: //Retrieve
            var tpb_no = document.all.s_n3pty_no.value;
            var tpb_inv_no = document.all.s_n3pty_inv_no.value;
            if (tpb_no.length == 0 && tpb_inv_no.length == 0) {
                ComShowCodeMessage("TPB90064");
                document.all.s_n3pty_no.focus();
                return;
            }
            //retrieving hidden sheet
            formObj.f_cmd.value = SEARCHLIST;
            var sXml = sheetObjects[sheetObjects.length - 1].GetSearchData("ESD_TPB_0111GS.do", tpbFrmQryStr(formObj));
            //ComShowMessage(sXml);
            if (!isNaN(sXml) || sXml.indexOf("SHEET") == -1) {
                ComShowCodeMessage("TPB90095");
                return;
            }
            sheetObjects[sheetObjects.length - 1].LoadSearchData(sXml, {
                Sync: 1
            });
            //IBS_EtcDataToForm2(formObj, sheetObj);
            var n3pty_no = sheetObj.GetEtcData("s_detail_n3pty_no");
            var tmp_n3pty_no = sheetObj.GetEtcData("s_n3pty_no");
            var tmp_n3pty_inv_no = sheetObj.GetEtcData("s_n3pty_inv_no");
            var tmp_n3pty_inv_rmd_cd = sheetObj.GetEtcData("s_n3pty_inv_rmd_cd");
            var tmp_n3pty_inv_his_seq = sheetObj.GetEtcData("s_n3pty_inv_his_seq");
            var tmp_h_vndr_cust_div_cd = sheetObj.GetEtcData("s_h_vndr_cust_div_cd");
            var tmp_trd_party_code = sheetObj.GetEtcData("s_trd_party_code");
            var tmp_revise_able = sheetObj.GetEtcData("s_revise_able");
            var tmp_ida_tax_seq = sheetObj.GetEtcData("s_ida_tax_seq");
            var tmp_clt_agm_rmk = sheetObj.GetEtcData("s_clt_agn_rmk");
            if (tmp_n3pty_inv_rmd_cd == undefined || tmp_n3pty_inv_rmd_cd == null) {
                ComShowCodeMessage("TPB90095");
                return;
            }
            if (n3pty_no == undefined || n3pty_no == null) {
                n3pty_no = "";
            }
            if (tmp_n3pty_no == undefined || tmp_n3pty_no == null) {
                tmp_n3pty_no = "";
            }
            if (tmp_n3pty_inv_no == undefined || tmp_n3pty_inv_no == null) {
                tmp_n3pty_inv_no = "";
            }
            if (tmp_n3pty_inv_rmd_cd == undefined || tmp_n3pty_inv_rmd_cd == null) {
                tmp_n3pty_inv_rmd_cd = "";
            }
            if (tmp_n3pty_inv_his_seq == undefined || tmp_n3pty_inv_his_seq == null) {
                tmp_n3pty_inv_his_seq = "";
            }
            if (tmp_h_vndr_cust_div_cd == undefined || tmp_h_vndr_cust_div_cd == null) {
                tmp_h_vndr_cust_div_cd = "";
            }
            if (tmp_trd_party_code == undefined || tmp_trd_party_code == null) {
                tmp_trd_party_code = "";
            }
            if (tmp_revise_able == undefined || tmp_revise_able == null) {
                tmp_revise_able = "";
            }
            if (tmp_ida_tax_seq == undefined || tmp_ida_tax_seq == null) {
                tmp_ida_tax_seq = "";
            }
            if (tmp_clt_agm_rmk == undefined || tmp_clt_agm_rmk == null) {
                tmp_clt_agm_rmk = "";
            }
            formObj.s_detail_n3pty_no.value = n3pty_no;
            formObj.s_n3pty_no.value = tmp_n3pty_no;
            formObj.s_n3pty_inv_no.value = tmp_n3pty_inv_no;
            formObj.s_n3pty_inv_rmd_cd.value = tmp_n3pty_inv_rmd_cd;
            formObj.s_n3pty_inv_his_seq.value = tmp_n3pty_inv_his_seq;
            formObj.s_h_vndr_cust_div_cd.value = tmp_h_vndr_cust_div_cd;
            formObj.s_trd_party_code.value = tmp_trd_party_code;
            formObj.s_correction_yn.value = tmp_revise_able;
            formObj.s_inquiryOnly_yn.value = tmp_revise_able == "Y" ? "N" : "Y";
            formObj.s_ida_tax_seq.value = tmp_ida_tax_seq;
            formObj.s_clt_agn_rmk.value = tmp_clt_agm_rmk;
            document.form.f_cmd.value = IBSEARCH;
            document.form.method = "post";
            document.form.action = "ESD_TPB_0111.do?pgmNo=ESD_TPB_0111&parentPgmNo=ESD_TPB_M001";
            document.form.submit();
    }
}

/**
 * Checking validation of input value
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //if (!isNumber(formObj.iPage)) {
        //	return false;
        // }
    }
    return true;
}

/**
 * handling process after ending sheet0 retrieve
 */
function sheet0_OnSearchEnd(sheetObj, errMsg) {
    ComEtcDataToForm(document.form, sheetObj);
    s_clt_agn_flg = sheetObj.GetEtcData("s_clt_agn_flg");
    var s_n3pty_inv_sts_cd = sheetObj.GetEtcData("s_n3pty_inv_sts_cd");
    var s_n3pty_inv_rmd_yn = sheetObj.GetEtcData("s_n3pty_inv_rmd_yn");
    var s_final_flg = sheetObj.GetEtcData("s_final_flg");
    var s_lnk_n3pty_inv_no = sheetObj.GetEtcData("s_lnk_n3pty_inv_no");
    var erpif_yn = sheetObj.GetEtcData("erpif_yn");
    document.all.prcs_cnt.value = sheetObj.GetEtcData("s_prcs_cnt");
    //Collection Agency cd
    if (s_clt_agn_flg != undefined) {
        if (s_clt_agn_flg == "Y") {
            document.form.s_clt_agn_flg.checked = true;
            document.all.btn_preview.disabled = true;
        } else {
            document.form.s_clt_agn_flg.checked = false;
        }
    }
    //A/R interface
    if (s_n3pty_inv_sts_cd != undefined && s_n3pty_inv_sts_cd != "N") {
        document.all.btn_save.disabled = false;
        document.all.btn_cancel.disabled = false;
    }
    // ERP I/F BTN
    var s_inquiryOnly_yn = document.all.s_inquiryOnly_yn.value;
    if (s_inquiryOnly_yn == "Y") {
        document.all.btn_erpInterface.disabled = true;
        document.all.btn_erpInterface.style.display = 'none';
    } else if (erpif_yn != undefined && erpif_yn == "Y") {
        document.all.btn_erpInterface.disabled = false;
        document.all.btn_erpInterface.style.display = '';
    } else {
        document.all.btn_erpInterface.disabled = true;
        document.all.btn_erpInterface.style.display = 'none';
    }
    var s_vat_amt = document.form.s_vat_amt.value;
    if (s_vat_amt != "" && parseFloat(s_vat_amt) > 0) {
        document.form.s_vat_xch_rt_chk.checked = true;
        document.form.s_vat_xch_rt.value = sheetObj.GetEtcData("s_vat_xch_rt_original");
    } else {
        document.form.s_vat_xch_rt_chk.checked = false;
        document.form.s_vat_xch_rt.value = sheetObj.GetEtcData("s_vat_xch_rt_original");
    }
    //VAT amount format
    document.form.s_net_amt.value = ComAddComma2(document.form.s_net_amt.value, "#,###.00");
    document.form.s_add_amt.value = ComAddComma2(document.form.s_add_amt.value, "#,###.00");
    document.form.s_ddct_amt.value = ComAddComma2(document.form.s_ddct_amt.value, "#,###.00");
    document.form.s_vat_amt.value = ComAddComma2(s_vat_amt, "#,###.00");
    document.form.s_total_amt.value = addFloat(document.form.s_total_amt.value, 0);
    document.form.org_clt_agn_flg.value = document.form.s_clt_agn_flg.checked;
    var s_cnt_cd = document.form.s_cnt_cd.value;
    if (s_cnt_cd == 'IN') {
        document.form.lst_invoice_total.value = addFloat(v("s_total_amt"), v("tot_svc_tax"));
    }
}

/**
 * Defined by DataSheetObject.prototype.event_OnSaveEnd
 */
function sheet0_OnSaveEnd(sheetObj, code, errMsg) {
    if (errMsg == null || errMsg == '') {
        if (document.form.f_cmd.value == REMOVE) {
            ComShowCodeMessage('TPB90059');
            document.form.method = "post";
            document.form.f_cmd.value = "";
            document.form.action = "ESD_TPB_0106.do?pgmNo=ESD_TPB_0106&parentPgmNo=ESD_TPB_M001";
            document.form.submit();
            return;
        } else if (document.form.f_cmd.value == MULTI) {
            ComShowCodeMessage('COM12149', 'Invoice', '', '');
            document.all.btn_save.style.display = 'none';
            document.all.btn_cancel.style.display = 'none';
            var hdr_del_result = sheetObj.GetEtcData("hdr_del_result");
            // ComShowMessage(hdr_del_result);
            if (hdr_del_result == "HDR_DELETE") {
                //document.form.action = "ESD_TPB_0106.do?sysCommUiTitle=Invoice Revision - Main&sysCommUiNavigation=Service Delivery > 3rd Party Billing > Invoice Management";
                document.form.action = "ESD_TPB_0106.do?pgmNo=ESD_TPB_0106&parentPgmNo=ESD_TPB_M001";
                document.form.submit();
                return;
            } else if (hdr_del_result.substring(0, 1) == "R") { // Rxx
                document.form.s_n3pty_inv_rmd_cd.value = hdr_del_result;
                document.form.s_n3pty_inv_his_seq.value = (parseInt(document.form.s_n3pty_inv_his_seq.value) + 2).toString();
                document.form.s_his_seq.value = document.form.s_n3pty_inv_his_seq.value;
            }
            isSaveEnd = true;
            //Initializing currency variables
            document.form.s_from_curr_cd.value = "";
            document.all.btn_save.style.display = 'none';
            document.all.btn_cancel.style.display = 'none';
        } else if (document.form.f_cmd.value == ADD) {
            ComShowCodeMessage('COM12149', 'ERP Interface', '', '');
            document.all.btn_erpInterface.style.display = 'none';
        }
    } else {
        ComShowMessage(errMsg);
    }
    document.form.s_h_vndr_cust_div_cd.value = document.form.s_vndr_cust_div_cd.value;
    doActionIBSheet(sheetObjects[sheetObjects.length - 1], document.form, IBSEARCH);
}

//Loading Tab data
function tpb_makeTabLoad(formObj, sheetObjects, bilArr, x) {
    for (var i = 0; i < sheetObjects.length - 1; i++) {
        //Setting TAB title
        if (bilArr[i] == undefined) {
            //	document.getElementById("tabSheet"+(i+1)).style.display = "none";
            //	continue;
        }
        //document.getElementById("tab_title"+(i+1)).innerHTML = bilArr[i];
        var title = bilArr[i];
        if (formObj.load_num.value == "0") {
            tabObjects[i].InsertItem(title, "");
        }
        //Data load/
        sheetObjects[i].LoadSearchData(x, {
            Sync: 1
        });
        for (var j = 1; j <= sheetObjects[i].RowCount(); j++) {
            if (sheetObjects[i].GetCellValue(j, 6) != bilArr[i]) {
                sheetObjects[i].RowDelete(j, false);
                --j;
            }
            if (j != 0) {
                sheetObjects[i].SetCellValue(j, 2, j); //seq // be careful
                sheetObjects[i].SetRowStatus(j, "R");
            }
            sheetObjects[i].SetTotalRows(j); //Setting Row count
            //Checking Auto Update of Outstanding Amount
            tpb_chgColor_ots_amt(sheetObjects[i], 49, 30, j); // be careful 
            sheetObjects[i].SetVisible(true);
        }
        tpb_setSheetByBillingCase(sheetObjects[i], sheetObjects[i].GetCellValue(1, 5), i + 1); //n3pty_bil_tp_cd // be careful
    }
    formObj.load_num.value = "1";
}

function tpb_getBillingCase(sheetObject) {
    var bilArrNm = new Array(); //Billing case Name array
    var bilArrCd = new Array(); //Billing case CD array
    for (var i = 1; i <= sheetObject.RowCount(); i++) {
        bilArrNm[bilArrNm.length] = sheetObject.GetCellValue(i, 6); //n3pty_bil_tp_nm // be careful
        bilArrCd[bilArrCd.length] = sheetObject.GetCellValue(i, 5); //n3pty_bil_tp_cd // be careful
    }
    for (var i = 0; i < bilArrNm.length; i++) {
        var dbl = 0;
        for (var j = 0; j < bilArrNm.length; j++) {
            if (bilArrNm[i] != bilArrNm[j]) {
                continue;
            } else {
                dbl++;
                if (dbl > 1) {
                    bilArrNm.splice(j, 1);
                    bilArrCd.splice(j, 1);
                    j--;
                }
            }
        }
    }
    return new Array(bilArrNm, bilArrCd);
}

function tpb_chkLenByByte(obj, len, name) {
    if (!chkLenByByte(obj, len)) {
        ComShowCodeMessage("COM12142", name, len, "");
    }
}

var lastSelectedCurrency = ""; // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
function changeCurrency(val) {
    if (document.form.s_n3pty_inv_rmd_cd.value != null && document.form.s_n3pty_inv_rmd_cd.value != "") {
        if (val == null || val == "") { // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
            document.form.s_curr_cd.value = lastSelectedCurrency;
            return;
        }
        doActionIBSheet(sheetObjects[sheetObjects.length - 1], document.form, IBSEARCH);
        lastSelectedCurrency = document.form.s_curr_cd.value; // select currency <select>, save last value // Added By Kim Jin-seung in 2007-05-14
        calculateForIndiaInvoice();
    }
}

function s_clt_agn_flg_OnChange() {
    isSaveEnd = false;
}

// show processing image 
function div_processing_show() {
    document.all.div_processing.style.display = '';
    // setTimeout("div_processing_hide();", 1000);
}

// hide processing image 
function div_processing_hide() {
    document.all.div_processing.style.display = 'none';
}

function tpb_setSheetByBillingCase(sheetObj, cd, idx) {
    idx = "";
    //cd = prompt('TL/ST/DR/OW/FU/CI/RO/RH/CP/BB/FL/AW \nVD/GD/TR/CY/JO/RF/DG/SL/CC/WT/CD/ZD/CH/EE');
    switch (cd) {
        case "TL":
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "yd_cd", 1); //yd_cd
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "ST":
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_cntr_seal_no
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "DR":
            sheetObj.SetColHidden(idx + "yd_cd", 1); //yd_cd
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "OW":
            sheetObj.SetColHidden(idx + "yd_cd", 1); //yd_cd
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "FU":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "CI":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "RO":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "RH":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "CP":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "BB":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "FL":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "AW":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "VD":
            sheetObj.SetColHidden(idx + "eq_knd_nm", 1); //eq_knd_nm
            sheetObj.SetColHidden(idx + "eq_no", 1); //eq_no
            sheetObj.SetColHidden(idx + "eq_tpsz_cd", 1); //eq_tpsz_cd
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "GD":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "vvd", 1); //vvd
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "TR":
            sheetObj.SetColHidden(idx + "yd_cd", 1); //yd_cd
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "CY":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "JO":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            //  				sheetObj.ColHidden(idx+"csr_no") = true;			//csr_no
            //  				sheetObj.ColHidden(idx+"gl_dt") = true;			//gl_dt
            //  				sheetObj.ColHidden(idx+"vvd_cd") = true;			//vvd_cd (actual vvd)
            sheetObj.SetColHidden(idx + "vvd", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 0); //vvd_cd (actual vvd)
            for (var i = 1; i <= sheetObj.RowCount(); i++) {
                sheetObj.SetCellEditable(i, idx + "inv_dtl_amt", false);
            } // JO Case inv_dtl_amt Blocking ... Added By Kim Jin-seung In 2007-10-29
            break;

        case "RF":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "DG":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "SL":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "CC":
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "WT":
            sheetObj.SetColHidden(idx + "yd_cd", 1); //yd_cd
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "CD":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "vvd", 1); //vvd
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "ZD":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //vvd
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "CH":
            sheetObj.SetColHidden(idx + "yd_cd", 1); //yd_cd
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;

        case "EE":
            sheetObj.SetColHidden(idx + "bkg_no_all", 1); //bkg_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "bl_no_all", 1); //bl_no_all
            sheetObj.SetColHidden(idx + "vvd", 1); //vvd
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "route", 1); //route
            sheetObj.SetColHidden(idx + "mgset_no", 1); //mgset_no
            sheetObj.SetColHidden(idx + "new_eq_no", 1); //new_eq_no
            sheetObj.SetColHidden(idx + "new_cntr_seal_no", 1); //new_seal_no
            sheetObj.SetColHidden(idx + "cita_no", 1); //citation_no
            sheetObj.SetColHidden(idx + "cntr_wgt", 1); //weight
            sheetObj.SetColHidden(idx + "n3pty_cntr_wgt_ut_cd", 1); //uom
            sheetObj.SetColHidden(idx + "wt_hrs", 1); //waiting_tm
            sheetObj.SetColHidden(idx + "occr_dt", 1); //occur_dt
            sheetObj.SetColHidden(idx + "new_vsl_cd", 1); //new_vvd
            sheetObj.SetColHidden(idx + "new_bkg_no", 1); //new_bkg_all
            sheetObj.SetColHidden(idx + "damage_dt", 1); //damage_dt
            sheetObj.SetColHidden(idx + "repair_location", 1); //repair_location
            sheetObj.SetColHidden(idx + "lst_free_dt", 1); //last_free_dt
            sheetObj.SetColHidden(idx + "pkup_dt", 1); //pick_up_dt
            sheetObj.SetColHidden(idx + "ft_ovr_dys", 1); //over_day
            sheetObj.SetColHidden(idx + "csr_no", 1); //csr_no
            sheetObj.SetColHidden(idx + "gl_dt", 1); //gl_dt
            sheetObj.SetColHidden(idx + "vvd_cd", 1); //vvd_cd (actual vvd)
            break;
    }
}

function openInvoiceCancelRemarkPopup() {
    var theURL = "ESD_TPB_0810.do";
    // ComShowMessage( theURL );
    ComOpenPopup(theURL, 600, 220, "invoiceCancelRemark", "0,0,1,1,1,1,1", true);
}

function invoiceCancelRemark(rtnVal) {
    var formObject = document.form;
    if (rtnVal != undefined && rtnVal != null) {
        document.form.s_invoice_cancel_remark.value = rtnVal.remark;
        if (rtnVal.remark.length == 0) {
            ComShowCodeMessage("TPB90060");
            return false;
        }
        if (rtnVal.result) {
            formObject.f_cmd.value = REMOVE;
            sheetObjects[sheetObjects.length - 1].DoSave("ESD_TPB_0111GS.do", tpbFrmQryStr(formObject), 3, false);
        }
    } else {
        return false;
    }
}

function isSaveable() {
    /* 1. Checking in form changing */
    // 1-1. Save Original Value
    var org_due_date = document.form.org_due_date.value;
    var org_adm_chrg = ComGetUnMaskedValue(document.form.org_adm_chrg.value, "float");
    var org_ddct_amt = ComGetUnMaskedValue(document.form.org_ddct_amt.value, "float");
    var org_tot_amt = ComGetUnMaskedValue(document.form.org_tot_amt.value, "float");
    var org_inv_desc = document.form.org_inv_desc.value;
    var org_usr_inp_ctnt1 = document.form.org_usr_inp_ctnt1.value;
    var org_vndr_cust_addr = document.form.org_vndr_cust_addr.value;
    var org_cty_nm = document.form.org_cty_nm.value;
    var org_ste_cd = document.form.org_ste_cd.value;
    var org_zip_cd = document.form.org_zip_cd.value;
    var org_usr_inp_ctnt2 = document.form.org_usr_inp_ctnt2.value;
    var org_vndr_cust_ref_rmk = document.form.org_vndr_cust_ref_rmk.value;
    // 1-2. Save Current Value
    var cur_due_date = document.form.s_rcv_due_dt.value;
    var cur_adm_chrg = ComGetUnMaskedValue(document.form.s_add_amt.value, "float");
    var cur_ddct_amt = ComGetUnMaskedValue(document.form.s_ddct_amt.value, "float");
    //var cur_tot_amt  = parseFloat(delete_Char(document.form.s_total_amt.value,","));
    if (document.form.cnt_cd.value == "IN") {
        var cur_tot_amt = ComGetUnMaskedValue(document.form.lst_invoice_total.value, "float");
    } else {
        var cur_tot_amt = ComGetUnMaskedValue(document.form.s_total_amt.value, "float");
    }
    var cur_inv_desc = document.form.s_inv_desc.value;
    var cur_usr_inp_ctnt1 = document.form.s_usr_inp_ctnt1.value;
    var cur_vndr_cust_addr = document.form.s_vndr_cust_addr.value;
    var cur_cty_nm = document.form.s_cty_nm.value;
    var cur_ste_cd = document.form.s_ste_cd.value;
    var cur_zip_cd = document.form.s_zip_cd.value;
    var cur_usr_inp_ctnt2 = document.form.s_usr_inp_ctnt2.value;
    var cur_vndr_cust_ref_rmk = document.form.s_vndr_cust_ref_rmk.value;
    if (org_due_date == cur_due_date && org_adm_chrg == cur_adm_chrg && org_ddct_amt == cur_ddct_amt && org_tot_amt == cur_tot_amt && org_inv_desc == cur_inv_desc && document.form.s_clt_agn_flg.checked.toString() == document.form.org_clt_agn_flg.value && org_usr_inp_ctnt1 == cur_usr_inp_ctnt1 && org_vndr_cust_addr == cur_vndr_cust_addr && org_cty_nm == cur_cty_nm && org_ste_cd == cur_ste_cd && org_zip_cd == cur_zip_cd && org_usr_inp_ctnt2 == cur_usr_inp_ctnt2 && org_vndr_cust_ref_rmk == cur_vndr_cust_ref_rmk) {
        return false;
    }
    /* 2. Checking in IBSheet changing */
    // 1-1. Invoice Amount Check
    if (document.form.inv_amt_sts.value != 'U') {
        return false;
    }
    return true;
}

/**
 *  Calculating VAT amount only India
 **/
function calculateForIndiaInvoice() {
    /*
    alert(   
    	(("11.22".split("."))[1]).length   
    ) ;
    */
    var s_ddct_amt = v("s_ddct_amt");
    var s_net_amt = v("s_net_amt");
    var s_add_amt = v("s_add_amt");
    var s_ddct_amt_f = ComGetUnMaskedValue(ComTrim(s_ddct_amt), "float");
    var s_amt = addFloat(s_net_amt, s_add_amt);
    var s_amt_f = ComGetUnMaskedValue(ComTrim(s_amt), "float");
    var s_cnt_cd = document.form.s_cnt_cd.value;
    if (s_ddct_amt_f - s_amt_f > 0) {
        ComShowCodeMessage('TPB90032', 'Deducted Amount', '(Net Amount + Administration Charge)');
    }
    // Service Tax
    //alert(v("s_total_amt"));
    //alert(v("expn_tax"));
    //alert(multiplyFloat( v("s_total_amt"), v("expn_tax") );
    if (s_cnt_cd == 'IN') {
        document.form.tot_expn_tax.value = multiplyFloat(v("s_total_amt"), v("expn_tax"));
        // Education Cess
        document.form.tot_edu_tax.value = multiplyFloat(v("tot_expn_tax"), v("edu_tax"));
        // Higher Edu Cess
        document.form.tot_high_edu_tax.value = multiplyFloat(v("tot_expn_tax"), v("high_edu_tax"));
        // Total Service Tax
        document.form.tot_svc_tax.value = addFloat(addFloat(v("tot_expn_tax"), v("tot_edu_tax")), v("tot_high_edu_tax"));
        // Expense
        document.form.lst_expense.value = v("s_total_amt");
        // Tax
        document.form.lst_tax.value = v("tot_svc_tax");
        // Invoice Total
        //document.form.lst_invoice_total.value = ComAddComma2(addFloat( v("lst_expense"), v("lst_tax") ),"#,###.00");;
        document.form.lst_invoice_total.value = addFloat(v("s_total_amt"), v("tot_svc_tax"));
    }
}

function v(arg) {
    //  	alert(arg);
    return eval("document.form." + arg + ".value");
}

/*
 * calculating below the 3 decimal places. rounding off below the 2 decimal places
 */
function addFloat(f1, f2) {
    f1 = ComGetUnMaskedValue(ComTrim(f1), "float");
    f2 = ComGetUnMaskedValue(ComTrim(f2), "float");
    var result = (Math.floor(f1 * 1000) + Math.floor(f2 * 1000)) / 10;
    if (result - Math.floor(result) >= 0.5) {
        result = (Math.floor(result) + 1) / 100;
    } else {
        result = (Math.floor(result)) / 100;
    }
    result = ComAddComma2(result + "", "#,###.00");
    if (((result.split("."))[1]).length < 2) {
        result = result + "0";
    }
    return result;
}

/*
 * calculating below the 3 decimal places. rounding off below the 2 decimal places
 */
function minusFloat(f1, f2) {
    f1 = ComGetUnMaskedValue(ComTrim(f1), "float");
    f2 = ComGetUnMaskedValue(ComTrim(f2), "float");
    var result = (Math.floor(f1 * 1000) - Math.floor(f2 * 1000)) / 10;
    if (result - Math.floor(result) >= 0.5) {
        result = (Math.floor(result) + 1) / 100;
    } else {
        result = (Math.floor(result)) / 100;
    }
    result = ComAddComma2(result + "", "#,###.00");
    if (((result.split("."))[1]).length < 2) {
        result = result + "0";
    }
    return result;
}

/*
 * calculating below the 3 decimal places. rounding off below the 2 decimal places
 */
function multiplyFloat(f1, f2) {
    f1 = ComGetUnMaskedValue(ComTrim(f1), "float");
    f2 = ComGetUnMaskedValue(ComTrim(f2), "float");
    var result = (Math.floor(f1 * 1000) * Math.floor(f2 * 1000)) / 1000000;
    if (result - Math.floor(result) >= 0.5) {
        result = (Math.floor(result) + 1) / 100;
    } else {
        result = (Math.floor(result)) / 100;
    }
    result = ComAddComma2(result + "", "#,###.00");
    if (((result.split("."))[1]).length < 2) {
        result = result + "0";
    }
    return result;
}

/**
 * Calling Invoice Preview pop-up
 *
 * @param : formObject - formObject
 * @param : s_dao_n3pty_bil_tp_cd - s_dao_n3pty_bil_tp_cd
 * @param : s_n3pty_inv_no - s_n3pty_inv_no
 * @param : s_n3pty_inv_his_seq - s_n3pty_inv_his_seq
 * @param : s_n3pty_inv_rmd_cd - s_n3pty_inv_rmd_cd
 * @param : s_final_flg - s_final_flg
 */
function openInvoicePreviewPopupWin(formObject, s_dao_n3pty_bil_tp_cd, s_n3pty_inv_no, s_n3pty_inv_his_seq, s_n3pty_inv_rmd_cd, s_final_flg, s_n3pty_no, s_trd_party_val) {
    var theURL = "ESD_TPB_0112.do?pgmNo=ESD_TPB_0112&parentPgmNo=ESD_TPB_M001&f_cmd=" + SEARCH + "&s_dao_n3pty_bil_tp_cd=" + s_dao_n3pty_bil_tp_cd + "&s_n3pty_inv_no=" + s_n3pty_inv_no + "&s_n3pty_inv_his_seq=" + s_n3pty_inv_his_seq + "&s_n3pty_inv_rmd_cd=" + s_n3pty_inv_rmd_cd + "&s_final_flg=" + s_final_flg + "&s_n3pty_no=" + s_n3pty_no + "&s_trd_party_val=" + s_trd_party_val;
    //ComShowMessage( theURL );
    var features = "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:768px";
    var rtnValue = ComOpenWindow(theURL, window, features, true);
}

/**
 * Checking input value length
 */
function checkLength(obj, len, name) {
    if (!ComChkLenByByte(obj, len)) {
        ComShowCodeMessage("COM12142", name, len, "");
        obj.focus();
    }
}

/**
 * Setting currency combobox
 */
function getCurrencyList() {
    var sheetObj = sheetObjects[0];
    var formObj = document.form;
    formObj.f_cmd.value = SEARCH01;
    var query = tpbFrmQryStr(formObj);
    var otherObjs = new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd");
    query = query + "&id=s_curr_cd&method=searchInvoiceCurrency&mode=F&obj=&all=2";
    //  		sheetObj.RemoveEtcData();
    //method change[check again]CLT
    var comboXml = sheetObj.GetSearchData("TPBCommonCodeGS.do", query);
    if (comboXml != "") sheetObj.LoadSearchData(comboXml, { Sync: 1 });
    //  		var bil_curr_cd=sheetObj.GetEtcData('BIL_CURR_CD');
    var bil_curr_cd = ComGetEtcData(comboXml, 'BIL_CURR_CD');
    var bilCurrCdArray = bil_curr_cd.split('|');
    var comboObj = eval("document.all.s_curr_cd");
    if (comboObj != undefined) {
        ComClearCombo(comboObj);
    }
    ComAddComboItem(comboObj, "<<Select>>", "");
    var k = 0;
    while (k < bilCurrCdArray.length - 1) {
        k++;
        ComAddComboItem(comboObj, bilCurrCdArray[k], bilCurrCdArray[k]);
    }
}
/* Finishing work */