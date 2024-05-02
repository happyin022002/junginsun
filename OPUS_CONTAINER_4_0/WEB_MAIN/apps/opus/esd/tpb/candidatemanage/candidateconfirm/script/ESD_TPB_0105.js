/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0105.js
*@FileTitle  : TPB Candidate Confirmation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================
*/
/****************************************************************************************
  Event Code: [Initializing]INIT=0; [Insert]ADD=1; [Retrieve]SEARCH=2; [List retrieve]SEARCHLIST=3;
					[Modify]MODIFY=4; [Remove]REMOVE=5; [List remove]REMOVELIST=6 [Multi process]MULTI=7
					[Constant]  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESD_TPB_0105 : Defining logic script for ESD_TPB_0105 screen
 */
//    function ESD_TPB_0105() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
/* Global Variables */
var curTab = 1;
var beforetab = 0;
var sheetObjects = new Array();
var sheetCnt = 0;
var cancel = "N";
/**
 * Setting IBTab Object Initial.
 * Tab ID is tab1,tab2,...
 * InitTab() function is called before the loadPage() function call from setupPage() function.
 */
function InitTab() {
    try {
        with(document.all.tab1) {
            InsertItem("Dry Index", "");
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
 * Register as an IBSheet Object array
 * This is called from comSheetObject(id)
 * Process can add in case of future necessity to process other items
 * Array defined at the top of the source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Initializing sheet
 * To implement onLoad event of body tag
 * Add functionality to after loading screen.
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        //Setting startup environment. Change the name of the function
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        //Setting final environment.
        ComEndConfigSheet(sheetObjects[i]);
    }
    if (document.form.s_office_level.value == "H") {
        getTPBGenCombo('s_if_rhq_cd', 'searchHandleRHQList', 'F', '', '2', new Array("s_ofc_cd_for_rhq", "s_office_level"));
    } else if (document.form.s_office_level.value == "R") {
        ComClearCombo(document.form.s_if_rhq_cd);
        ComAddComboItem(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value);
        setTimeout("if_rhq_cd_OnChange();", 300);
    } else if (document.form.s_office_level.value == "C") {
        ComClearCombo(document.form.s_if_rhq_cd);
        ComAddComboItem(document.form.s_if_rhq_cd, document.form.s_rhq_cd_for_rhq.value, document.form.s_rhq_cd_for_rhq.value);
        if_ctrl_cd_OnChange();
    } else if (document.form.s_office_level.value == "T" || document.form.s_office_level.value == "") {
        getTPBGenCombo('s_if_rhq_cd', 'searchHandleRHQList', 'F', '', '5', new Array("s_ofc_cd_for_rhq", "s_office_level"));
        getTPBGenCombo('s_if_ctrl_cd', 'searchCtrlOffice', 'F', '', '5', new Array("s_ofc_cd_for_rhq", "s_office_level"));
        if_rhq_cd_OnChange(); //  Setting Control Office ComboBox, TPB Office ComboBox
        if_ctrl_cd_OnChange(); // Setting TPB Office ComboBox
    }
    document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange();
    $('select[name="s_if_rhq_cd"]').change(function() {
        if_rhq_cd_OnChange();
    });
    //	    document.form.s_if_ctrl_cd.onchange=if_ctrl_cd_OnChange();
    $('select[name="s_if_ctrl_cd"]').change(function() {
        if_ctrl_cd_OnChange();
    });

    document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;
    document.form.s_if_ctrl_cd.onchange = if_ctrl_cd_OnChange;
    document.form.s_n3pty_src_sub_sys_cd.onchange = tpb_searchBillingCaseByExpenseType;
    document.form.s_if_rhq_cd.disabled = 0;
}

/**
 * Initializing sheet. Defining header
 * param : sheetObj ==> sheet object, sheetNo ==> sheet No.
 * Composition a initial module in case of multi sheet
 */
function initSheet(sheetObj, sheetNo) {
	sheetObj.UseUtf8=true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init
				with(sheetObj){
					var cnt=0;
					var HeadTitle1="Del.|STS|SEQ|Confirm|Confirm|Confirm|Confirm|Confirm|Confirm|ots_dtl_seq|TPB No.|Exp. Type|Exp. Type|S/P Inv No.|3rd Party|3rd Party|EQ Kind|EQ No|TP/SZ|BKG No.|B/L No.|VVD|Interfaced Amount|Interfaced Amount|Interfaced Amount|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Interfaced by|Interfaced by|Interfaced by|Description|Reviewed by|Reviewed by|Reason for Non-TPB|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd";
					var HeadTitle2="Del.|STS|SEQ|I|G|N|R|D|C|ots_dtl_seq|TPB No.|Main|Sub|S/P Inv No.|Type|Code|EQ Kind|EQ No|TP/SZ|BKG No.|B/L No.|VVD|LCL Cur|LCL Amt|USD(Equiv.)|Interfaced\nRemark|Confirmed\nAmount|I/F Date|Office|ID|Name|Description|Office|ID|Reason for Non-TPB|CSR No.|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|ofc_cd";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},	{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
								{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
								{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cfm_i",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:false },
								{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cfm_g",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:false },
								{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cfm_n",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:false },
								{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cfm_r",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:false },
								{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cfm_d",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:false },
								{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cfm_c",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:false },
								{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ots_dtl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_sub_sys_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_bil_tp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_src_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vndr_cust_div_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
								{Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"trd_party_val",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:8 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_knd_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"g_bkg_no_all",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"g_bl_no_all",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"g_vvd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"if_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"if_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"if_amt_usd",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"if_rmk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cfm_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"if_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"if_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"if_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"if_usr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cfm_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rvw_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rvw_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"n3pty_non_cfm_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"vndr_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"n3pty_if_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"src_vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"tes_gubun",             KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"trs_gubun",             KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"estm_seq_no",           KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"estm_rvis_no",          KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"estm_dtl_seq_no",       KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"estm_svr_id",           KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"cost_expt_flg",         KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"check_finc_dir_cd",     KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"" },
								{Type:"Text",      Hidden:1, Width:65,   Align:"Right",   ColMerge:1,   SaveName:"eq_knd_cd",             KeyField:0,   CalcLogic:"",   Format:"" } ];
								
					InitColumns(cols);
					SetEditable(1);
					SetRowHeight(0, GetRowHeight(1,0));
					SetDataLinkMouse("n3pty_src_no",1);
					SetColHidden("ibflag",1);
					SetColHidden("cfm_i",1);
					SetColHidden("cfm_g",1);
					SetColHidden("cfm_n",1);
					SetColHidden("cfm_r",1);
					SetColHidden("cfm_d",1);
					SetColHidden("cfm_c",1);
					SetColProperty("vndr_cust_div_cd", {ComboText:"|"+combo01Text, ComboCode:"|"+combo01Code} );
					SetColProperty("n3pty_non_cfm_rsn_cd", {ComboText:combo02Text, ComboCode:combo02Code} );
					SetSheetHeight(415);
				}
			break;
	}    
}

/* Event handler defined process to button click event */
document.onclick = processButtonClick;

/* Event handler is branch processing by name of button */
function processButtonClick() {
    /***** Assignment sheet in case of over 2 by tab****/
    var sheetObject = sheetObjects[curTab - 1];
    /******************************************************/
    var formObject = document.form;
    if (curTab == 2)
        formObject = document.form2;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "bttn_add":
                doActionIBSheet(sheetObject, formObject, IBINSERT);
                break;

            case "bttn_cancel":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;

            case "btn_save":
                doActionIBSheet(sheetObject, formObject, IBSAVE);
                break;

            case "bttn_remove":
                break;

            case "bttn_preview":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }
                break;

            case "btn_downexcel":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }
                break;

            case "bttn_print":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }
                break;

            case "btn_retrieve":
                grp_n3pty_src_sub_sys_cd = "_NULL";
                grp_g_vvd = "_NULL";
                grp_curr = "_NULL";
                grp_trd_party_val = "_NULL";
                grp_cnt = 0;
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;

            case "btn_vvd":
                var param = '?sdate=' + formObject.s_sdate.value + '&edate=' + formObject.s_edate.value;
                ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 770, 420, 'getVVD', '1,0,1,1,1,1,1,1', true);
                break;

            case "btn_new":
                sheetObject.RemoveAll();
                formObject.reset();
                cancel = "N";
                break;

            case "btns_calendar1":
                var cal = new calendarPopup();
                cal.select(formObject.s_sdate, 's_sdate', 'yyyy-MM-dd');
                break;

            case "btns_calendar2":
                var cal = new ComCalendarFromTo();
                cal.select(formObject.s_sdate, formObject.s_edate, 'yyyy-MM-dd');
                break;

            case "btn_inv":
                var str = getCheckN3ptyNo(formObject, sheetObject);
                if (str != '') {
                    formObject.f_cmd.value = SEARCH;
                    formObject.method = "post";
                    formObject.action = "ESD_TPB_0106.do?pgmNo=ESD_TPB_0106&parentPgmNo=ESD_TPB_M001";
                    formObject.submit();
                }
                break;

            case "btn_roc":
                var str = getCheckN3ptyNo(formObject, sheetObject);
                if (str != '') {
                    formObject.f_cmd.value = SEARCH;
                    formObject.method = "post";
                    formObject.action = "ESD_TPB_0113.do?pgmNo=ESD_TPB_0113&parentPgmNo=ESD_TPB_M001";
                    formObject.submit();
                }
                break;

            case "btn_wo":
                var str = getCheckN3ptyNo(formObject, sheetObject);
                if (str != '') {
                    formObject.f_cmd.value = SEARCH;
                    formObject.method = "post";
                    formObject.action = "ESD_TPB_0114.do?pgmNo=ESD_TPB_0114&parentPgmNo=ESD_TPB_M001";
                    formObject.submit();
                }
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage('TPB90014');
        } else {
            ComShowMessage(e.message);
        }
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
            cancel = "N";
            //Checking length of input value
            var lenArr = new Array();
            lenArr[0] = new Array(formObj.s_bkg_no_all, 'BKG No', formObj.s_bkg_no_all.getAttribute("maxlength"), 11);
            lenArr[1] = new Array(formObj.s_bl_no_all, 'B/L No', formObj.s_bl_no_all.getAttribute("maxlength"));
            lenArr[2] = new Array(formObj.s_vvd, 'VVD', formObj.s_vvd.getAttribute("maxlength"));
            if (!checkFormLength(lenArr)) {
                return false;
            }
            if (formObj.s_eq_knd_cd.value != '' || formObj.s_eq_no.value != '') {
                if (formObj.s_eq_no.value == '') {
                    ComShowCodeMessage('COM12130', 'Equipment', 'EQ No.', '');
                    formObj.s_eq_no.focus();
                    return false;
                }
                //if(formObj.s_eq_tp_cd.value == ''){
                if (formObj.s_eq_knd_cd.value == '') {
                    ComShowCodeMessage('COM12130', 'Equipment', 'EQ Kind Code', '');
                    formObj.s_eq_knd_cd.focus();
                    return false;
                }
            }
            formObj.f_cmd.value = SEARCH;
            sheetObj.DoSearch("ESD_TPB_0105GS.do", tpbFrmQryStr(formObj));
            break;

        case IBSAVE: //Save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            var grpCnt = 0;
            //Save can't in case of non Confirmed or not checked to Review. UPD removed by status of not checked
            var check_cnt = 0;
            var chkFlg = true;
            cancel = "N";
            //Remark required in case of Confirmed is 'N' or Review Checked
            for (var i = 2; i <= sheetObj.RowCount() + 1; i++) {
                // Checking selected count of checkbox
                if (sheetObj.GetCellValue(i, 'cfm_g') == '1') {
                    grpCnt++;
                }
                if (sheetObj.GetRowStatus(i) != 'R' && sheetObj.GetCellValue(i, 'recm_flg') == '1') {
                    if (sheetObj.GetCellValue(i, 'cfm_rmk') == '') {
                        ComShowCodeMessage('COM12130', (i - 1) + ' Row', 'Remarks', '');
                        return false;
                    }
                }
                //Reason required in case of Confirmed is 'N'
                if (sheetObj.GetRowStatus(i) == 'U' && sheetObj.GetCellValue(i, 'cfm_n') == '1') {
                    if (sheetObj.GetCellValue(i, 'n3pty_non_cfm_rsn_cd') == '') {
                        ComShowCodeMessage('COM12130', (i - 1) + ' Row', 'Reason', '');
                        return false;
                    }
                }
                if (sheetObj.GetRowStatus(i) != 'R') {
                    if (sheetObj.GetCellValue(i, 'n3pty_bil_tp_cd') == '') {
                        ComShowCodeMessage('COM12130', (i - 1) + ' Row', 'Billing Case', '');
                        return false;
                    }
                    // JO Case, CSR No., GL Date, Actual VVD 
                    if (sheetObj.GetCellValue(i, 'n3pty_bil_tp_cd') == 'JO') {
                        if (sheetObj.GetCellValue(i, 'csr_no').length == 0) {
                            ComShowCodeMessage('TPB90038', (i - 1) + ' Row', 'CSR No.', '');
                            return false;
                        }
                        if (sheetObj.GetCellValue(i, 'gl_dt').length != 8) {
                            ComShowCodeMessage('TPB90038', (i - 1) + ' Row', 'GL Date', '');
                            return false;
                        }
                        if (sheetObj.GetCellValue(i, 'vvd_cd').length == 0) {
                            ComShowCodeMessage('TPB90038', (i - 1) + ' Row', 'Actual VVD', '');
                            return false;
                        }
                    }
                }
                //Setting cfm_flg
                if (sheetObj.GetRowStatus(i) != 'R') {
                    if (sheetObj.GetCellValue(i, 'cfm_i') == '1' || sheetObj.GetCellValue(i, 'cfm_g') == '1') {
                        sheetObj.SetCellValue(i, 'n3pty_cfm_cd', 'Y');
                    } else if (sheetObj.GetCellValue(i, 'cfm_n') == '1') {
                        sheetObj.SetCellValue(i, 'n3pty_cfm_cd', 'N');
                    }
                }
                // check_cnt increase in case of changed status of RowStatus and save can
                if (sheetObj.GetRowStatus(i) != "" &&
                    sheetObj.GetCellValue(i, 'cfm_i') == '1' ||
                    sheetObj.GetCellValue(i, 'cfm_g') == '1' ||
                    sheetObj.GetCellValue(i, 'cfm_n') == '1' ||
                    sheetObj.GetCellValue(i, 'cfm_r') == '1' ||
                    sheetObj.GetCellValue(i, 'cfm_d') == '1' ||
                    sheetObj.GetCellValue(i, 'cfm_c') == '1'
                ) {
                    check_cnt += 1;
                } else if (sheetObj.GetRowStatus(i) != "" &&
                    sheetObj.GetCellValue(i, 'cfm_i') != '1' ||
                    sheetObj.GetCellValue(i, 'cfm_g') != '1' ||
                    sheetObj.GetCellValue(i, 'cfm_n') != '1' ||
                    sheetObj.GetCellValue(i, 'cfm_r') != '1' ||
                    sheetObj.GetCellValue(i, 'cfm_d') != '1' ||
                    sheetObj.GetCellValue(i, 'cfm_c') != '1'
                ) {
                    sheetObj.SetRowStatus(i, "");
                }
                
                if(sheetObj.GetCellValue(i, 'cfm_c') == '1'){
                	cancel = "Y";
                }
                
                if(sheetObj.GetRowStatus(i) != "" &&
                	sheetObj.GetCellValue(i, 'cfm_i') == '1' ||
                	sheetObj.GetCellValue(i, 'cfm_g') == '1' ||
                	sheetObj.GetCellValue(i, 'cfm_n') == '1' ||
                	sheetObj.GetCellValue(i, 'cfm_r') == '1' ||
                	sheetObj.GetCellValue(i, 'cfm_d') == '1' ){
                	chkFlg = false;
                }
            }
            if (grpCnt != 0 && grpCnt < 2 || grpCnt > 50) {
                ComShowCodeMessage('TPB90079');
                return;
            }
            // Save can't in case of non checked checkBox
            if (check_cnt < 1) {
                ComShowCodeMessage('TPB90080');
                return;
            }
            
            if(cancel == "Y" && chkFlg == false){
            	ComShowCodeMessage('TPB90109');
                return;
            }
            
            formObj.f_cmd.value = MULTI;
            if(cancel == "Y"){
            	if(ComShowCodeConfirm("TPB90110")){
            		var sParam = sheetObj.GetSaveString(0,1);
            		var sXml = sheetObj.GetSaveData("ESD_TPB_0105GS.do", tpbFrmQryStr(formObj)+"&"+sParam);
                	sheetObj.LoadSaveData(sXml);
            	}
            }else{
            	sheetObj.DoSave("ESD_TPB_0105GS.do", tpbFrmQryStr(formObj));
            }
            
            break;

        case IBINSERT: //Insert
            var Row = sheetObj.DataInsert();
            break;

        case IBCLEAR: //Clear
            sheetObj.RemoveAll();
            cancel = "N";
            break;

        case IBDOWNEXCEL: //Excel download
            sheetObj.Down2Excel(TPBDown2ExcelOptions);
            break;
    }
}

/**
 * Checking validation of input value
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        if (!ComChkValid(formObj)) return false;
    }
    return true;
}

/**
 * Processing function in case of error to result of retrieve
 * Defined by DataSheetObject.prototype.event_OnSearchEnd
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    if (document.form.s_office_level.value == "T" || document.form.s_office_level.value == "C") {
        sheetObj.SetColHidden("cfm_i", 0);
        sheetObj.SetColHidden("cfm_g", 0);
        sheetObj.SetColHidden("cfm_n", 0);
        sheetObj.SetColHidden("cfm_c", 0);
    } else if (document.form.s_office_level.value == "R") {
        sheetObj.SetColHidden("cfm_r", 0);
        sheetObj.SetColHidden("cfm_d", 0);
    } else {
        sheetObj.SetColHidden("cfm_i", 1);
        sheetObj.SetColHidden("cfm_g", 1);
        sheetObj.SetColHidden("cfm_n", 1);
        sheetObj.SetColHidden("cfm_r", 1);
        sheetObj.SetColHidden("cfm_d", 1);
        sheetObj.SetColHidden("cfm_c", 1);
    } //Showing CheckBox of different kind depending on connection permissions
    for (var i = 2; i <= sheetObj.RowCount() + 1; i++) {
        if (sheetObj.GetCellValue(i, "n3pty_src_no") != "") {
            sheetObj.SetCellFontUnderline(i, "n3pty_src_no", 1);
        }
        //Pop-up not link in case of manual registered and MNR module
        if (sheetObj.GetCellValue(i, "n3pty_src_sub_sys_cd") == "MNR" && sheetObj.GetCellValue(i, "n3pty_if_tp_cd") == "M") {
            sheetObj.SetCellFontUnderline(i, "n3pty_src_no", 0);
        }
        //Modify the amount in case of Billing case same 'JO'
        if (sheetObj.GetCellValue(i, "n3pty_bil_tp_cd") == "JO") {
            sheetObj.SetCellEditable(i, "cfm_amt", 1);
        }
        //Setting cfm_amt same if_amt
        sheetObj.SetCellValue(i, "cfm_amt", sheetObj.GetCellValue(i, "if_amt"), 0);
        //A can be confirmed only  I/F target by office of myself
        if (document.form.s_ofc_cd_for_rhq.value != sheetObj.GetCellValue(i, "ofc_cd") && document.form.s_office_level.value != "R") {
            sheetObj.SetRowEditable(i, 0);
            sheetObj.SetColEditable("cfm_i", 1);
            sheetObj.SetColEditable("cfm_g", 1);
            sheetObj.SetColEditable("cfm_n", 1);
            sheetObj.SetColEditable("cfm_r", 1);
            sheetObj.SetColEditable("cfm_d", 1);
            sheetObj.SetColEditable("cfm_c", 1);
        }
    }
    var lvl = document.form.s_office_level.value;

    //Impossible to confirm in case of not selected Currency
    for (var i = 2; i < sheetObj.LastRow() + 1; i++) {
        if (sheetObj.GetCellValue(i, "if_curr_cd") != "") {
            sheetObj.SetCellEditable(i, "if_curr_cd", 0);
        } else {
            sheetObj.SetCellEditable(i, "cfm_i", 0);
            sheetObj.SetCellEditable(i, "cfm_g", 0);
        }
        //Impossible to confirm in case of empty cfm_amt
        if (sheetObj.GetCellValue(i, "cfm_amt") == "0") {
            sheetObj.SetCellEditable(i, "cfm_i", 0);
            sheetObj.SetCellEditable(i, "cfm_g", 0);
        }
        //Possible to editing in case of comfirm flag is 'N'
        if (sheetObj.GetCellValue(i, "cfm_n") == "0") {
            sheetObj.SetCellEditable(i, "n3pty_non_cfm_rsn_cd", 0);
        }
        //Deactivation of Confirm and only Review activation in case of RHQ login
        if (lvl == "R") {
            sheetObj.SetCellEditable(i, "cfm_i", 0);
            sheetObj.SetCellEditable(i, "cfm_g", 0);
            sheetObj.SetCellEditable(i, "cfm_n", 0);
            sheetObj.SetCellEditable(i, "cfm_c", 0);
        }
        if (document.form.s_nr.value == "N") {
            sheetObj.SetCellEditable(i, "cfm_r", 1);
            sheetObj.SetCellEditable(i, "cfm_d", 1);
        } else {
            sheetObj.SetCellEditable(i, "cfm_r", 0);
            sheetObj.SetCellEditable(i, "cfm_d", 0);
            sheetObj.SetColHidden("cfm_r", 1);
            sheetObj.SetColHidden("cfm_d", 1);
        }
    }

    //Checking Outstanding Amount
    tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
}

/**
 * Defined by DataSheetObject.prototype.event_OnSaveEnd
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) {
    if (errMsg == null || errMsg == '') {
    	if(cancel == "Y"){
    		ComShowCodeMessage('COM12116', 'Cancellation ');
    	}else{
    		ComShowCodeMessage('COM12149', 'Data', '', '');
    	}
    }
    var lvl = document.form.s_office_level.value;
    for (var i = 2; i < sheetObj.LastRow() + 1; i++) {
	    if (sheetObj.GetCellValue(i, "n3pty_src_no") != "") {
	        sheetObj.SetCellFontUnderline(i, "n3pty_src_no", 1);
	    }
	    //Pop-up not link in case of manual registered and MNR module
	    if (sheetObj.GetCellValue(i, "n3pty_src_sub_sys_cd") == "MNR" && sheetObj.GetCellValue(i, "n3pty_if_tp_cd") == "M") {
	        sheetObj.SetCellFontUnderline(i, "n3pty_src_no", 0);
	    }
	    //Impossible control in case of after save
	    sheetObj.SetCellEditable(i, "cfm_i", 0);
	    sheetObj.SetCellEditable(i, "cfm_g", 0);
	    sheetObj.SetCellEditable(i, "cfm_n", 0);
	    sheetObj.SetCellEditable(i, "cfm_r", 0);
	    sheetObj.SetCellEditable(i, "cfm_d", 0);
	    sheetObj.SetCellEditable(i, "cfm_c", 0);
	    sheetObj.SetCellEditable(i, "vndr_cust_div_cd", 0);
	    sheetObj.SetCellEditable(i, "trd_party_val", 0);
	    sheetObj.SetCellEditable(i, "cfm_rmk", 0);
	    sheetObj.SetCellEditable(i, "n3pty_non_cfm_rsn_cd", 0);
	    //Impossible to confirm in case of empty Vendor
	    if (sheetObj.GetCellValue(i, "vndr_cust_div_cd") == "" || sheetObj.GetCellValue(i, "trd_party_val") == "") {
	        sheetObj.SetCellEditable(i, "cfm_i", 0);
	        sheetObj.SetCellEditable(i, "cfm_g", 0);
	    }
	    //Impossible to confirm in case of not selected Currency
	    if (sheetObj.GetCellValue(i, "if_curr_cd") != "") {
	        sheetObj.SetCellEditable(i, "if_curr_cd", 0);
	    } else {
	        sheetObj.SetCellEditable(i, "cfm_i", 0);
	        sheetObj.SetCellEditable(i, "cfm_g", 0);
	    }
	    //Impossible to confirm in case of empty cfm_amt
	    if (sheetObj.GetCellValue(i, "cfm_amt") == "0") {
	        sheetObj.SetCellEditable(i, "cfm_i", 0);
	        sheetObj.SetCellEditable(i, "cfm_g", 0);
	    }
	    //Possible to editing in case of comfirm flag is 'N'
	    if (sheetObj.GetCellValue(i, "cfm_n") == "0") {
	        sheetObj.SetCellEditable(i, "n3pty_non_cfm_rsn_cd", 0);
	    }
	    //Deactivation of Confirm and only Review activation in case of RHQ login
	    if (lvl == "R") {
	        sheetObj.SetCellEditable(i, "cfm_i", 0);
	        sheetObj.SetCellEditable(i, "cfm_g", 0);
	    }
    }
    //Checking Outstanding Amount
    tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
}

function sheet1_OnPopupClick(sheetObj, Row, Col) {
    get3rdPartyTarget_sheet(sheetObj.GetCellValue(Row, "vndr_cust_div_cd"), Row, Col, sheetObj);
}

function sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift) {
    return;
}

function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    return;
}

function sheet1_OnClick(sheetObj, Row, Col, Value) {
    var colNm = sheetObj.ColSaveName(Col);
    var lvl = document.form.s_office_level.value;
    if ((colNm == 'cfm_i' || colNm == 'cfm_g' || colNm == 'cfm_n' || colNm == 'cfm_c') &&
        sheetObj.GetCellEditable(Row, colNm) == true) {
        if (Value == '1') {
            if (colNm == 'cfm_n') {
                sheetObj.SetCellValue(Row, 'n3pty_cfm_cd', 'N');
                sheetObj.SetCellValue(Row, 'n3pty_non_cfm_rsn_cd', "");
                sheetObj.SetCellEditable(Row, "n3pty_non_cfm_rsn_cd", 1);
            } else if (colNm == 'cfm_i') {
                sheetObj.SetCellValue(Row, 'n3pty_cfm_cd', '');
            } else if (colNm == 'cfm_g') {
                sheetObj.SetCellValue(Row, 'n3pty_cfm_cd', '');
            }
            return;
        } else {
            if (colNm == 'cfm_flg_y' && sheetObj.GetCellEditable(Row, Col)) {
                sheetObj.SetCellValue(Row, 'cfm_flg_n', '0');
                sheetObj.SetCellValue(Row, 'recm_flg', '0');
                sheetObj.SetCellValue(Row, 'n3pty_cfm_cd', 'Y');
            } else if (colNm == 'cfm_flg_n') {
                sheetObj.SetCellValue(Row, 'cfm_flg_y', '0');
                sheetObj.SetCellValue(Row, 'recm_flg', '0');
                sheetObj.SetCellValue(Row, 'n3pty_cfm_cd', 'N');
                sheetObj.SetCellEditable(Row, "n3pty_non_cfm_rsn_cd", 1);
            } else if (colNm == 'recm_flg') {
                sheetObj.SetCellValue(Row, 'cfm_flg_y', '0');
                sheetObj.SetCellValue(Row, 'cfm_flg_n', '0');
                sheetObj.SetCellValue(Row, 'n3pty_cfm_cd', 'R');
            }
        }
    }
    //Deactivation of Confirm in case of RHQ login
    if (lvl == "R") {
        sheetObj.SetCellEditable(Row, "cfm_flg_y", 0);
    }
    //Calling other module pop-up
    if (colNm == 'n3pty_src_no' && sheetObj.GetCellFontUnderline(Row, colNm)) {
        var src_cd = sheetObj.GetCellValue(Row, "n3pty_src_sub_sys_cd");
        var param;
        var theURL;
        var winName;
        var features;
        if (src_cd == 'TRS') {
            var trs_gubun = sheetObj.GetCellValue(Row, "trs_gubun");
            if (trs_gubun > 0) {
                param = "?pgmNo=ESD_TRS_0038&parentPgmNo=ESD_TPB_M001&inv_no=" + sheetObj.GetCellValue(Row, "n3pty_src_no") + "&inv_vndr_seq=" + sheetObj.GetCellValue(Row, "src_vndr_seq") + "&editflg=N";
                theURL = "ESD_TRS_0038_POP.screen" + param;
                winName = "ESD_TRS_0038";
                //features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=700";
                features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
            } else {
                param = "?pgmNo=ESD_TRS_0033&parentPgmNo=ESD_TPB_M001&inv_no=" + sheetObj.GetCellValue(Row, "n3pty_src_no") + "&inv_vndr_seq=" + sheetObj.GetCellValue(Row, "src_vndr_seq") + "&mode=search";
                theURL = "ESD_TRS_0033_POP.screen" + param;
                winName = "ESD_TRS_0033";
                //features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=630";
                features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
            }
            ComOpenWindow(theURL, winName, features, true);
        } else if (src_cd == 'TES') {
            var tes_gubun = sheetObj.GetCellValue(Row, "tes_gubun");
            if (tes_gubun != "") {
                if (tes_gubun == "TM") {
                    param = "?pgmNo=ESD_TES_0017&parentPgmNo=ESD_TES_M001&inv_no=" + sheetObj.GetCellValue(Row, "n3pty_src_no") + "&vndr_seq=" + sheetObj.GetCellValue(Row, "src_vndr_seq");
                    theURL = "ESD_TES_0017Pop.screen" + param;
                    winName = "ESD_TES_0017";
                    //features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=570";
                    features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
                } else if (tes_gubun == "ON") {
                    param = "?pgmNo=ESD_TES_0068&parentPgmNo=ESD_TES_M001&inv_no=" + sheetObj.GetCellValue(Row, "n3pty_src_no") + "&vndr_seq=" + sheetObj.GetCellValue(Row, "src_vndr_seq");
                    theURL = "ESD_TES_0068Pop.screen" + param;
                    winName = "ESD_TES_0068";
                    //features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=570";
                    features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
                } else if (tes_gubun == "OF") {
                    param = "?pgmNo=ESD_TES_0018&parentPgmNo=ESD_TES_M001&inv_no=" + sheetObj.GetCellValue(Row, "n3pty_src_no") + "&vndr_seq=" + sheetObj.GetCellValue(Row, "src_vndr_seq");
                    theURL = "ESD_TES_0018Pop.screen" + param;
                    winName = "ESD_TES_0018";
                    //features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=620";
                    features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
                } else if (tes_gubun == "ST") {
                    param = "?pgmNo=ESD_TES_0019&parentPgmNo=ESD_TES_M001&inv_no=" + sheetObj.GetCellValue(Row, "n3pty_src_no") + "&vndr_seq=" + sheetObj.GetCellValue(Row, "src_vndr_seq");
                    theURL = "ESD_TES_0019Pop.screen" + param;
                    winName = "ESD_TES_0019";
                    //features = "toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no,width=1020,height=620";
                    features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:700px";
                }
                ComOpenWindow(theURL, winName, features, true);
            }
        } else if (src_cd == 'MNR') {
            var param;
            var winName = "EES_MNR_0192";
            var eqNo = sheetObj.GetCellValue(Row, "eq_no");
            var estmSeqNo = sheetObj.GetCellValue(Row, "estm_seq_no");
            var estmRvisNo = sheetObj.GetCellValue(Row, "estm_rvis_no");
            var eqKndCd = sheetObj.GetCellValue(Row, "eq_knd_cd")
            param = "?pgmNo=EES_MNR_0192&parentPgmNo=ESD_TPB_M001&rqst_eq_no=" + eqNo + "&rpr_rqst_seq=" + estmSeqNo + "&rpr_rqst_ver_no=" + estmRvisNo + "&eq_knd_cd=" + eqKndCd;
            var features = "scroll:yes;status:no;help:no;dialogWidth:1030px;dialogHeight:730px";
            ComOpenWindow('/opuscntr/EES_MNR_0192.do' + param, winName, features, true);
        }
    }
    tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
}

function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    // ComShowMessage( sheetObj.ColSaveName(NewCol) );
    if (sheetObj.ColSaveName(NewCol) == "trd_party_val") {
        var divCd = ComTrim(sheetObj.GetCellValue(NewRow, 'vndr_cust_div_cd'));
        if (divCd != 'C' && divCd != "V" && divCd != "S") {
            // ComShowCodeMessage('TPB90015'); 
            try {
                sheetObj.SelectCell(NewRow, "vndr_cust_div_cd");
            } catch (e) {} /// set focus
        }
    }
    // Controlling of Invoice button and ROC button and W/O button 
    if (sheetObj.GetSelectRow() > 1) {
        if (sheetObj.GetCellValue(NewRow, "n3pty_no") == "") {
            document.getElementById('btn_inv').style.display = 'none';
            document.getElementById('btn_roc').style.display = 'none';
            document.getElementById('btn_wo').style.display = 'none';
        } else {
            document.getElementById('btn_inv').style.display = '';
            document.getElementById('btn_roc').style.display = '';
            document.getElementById('btn_wo').style.display = '';
        }
    }
}

// Invalidity/Validity validation alert in case of Automatic grouping
var _alertSwitch = true;
var grp_n3pty_src_sub_sys_cd = "_NULL";
var grp_g_vvd = "_NULL";
var grp_curr = "_NULL";
var grp_trd_party_val = "_NULL";
var grp_cnt = 0;

/** 
 * OnMouseDown Event for header event in case of the entire selection
 **/
function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
    var colNm = sheetObj.ColSaveName(sheetObj.MouseCol());
    /*
    if( sheetObj.MouseRow()== 1 ){
    	if( colNm == "cfm_i" ){
    		sheetObj.CheckAll("cfm_g",0,1);
    		// Initializing _alertSwitch function in case of cfm_g cancellation
    		_alertSwitch=true;
    		sheetObj.CheckAll("cfm_n",0,1);
    	} else if( colNm == "cfm_g" ){
    		sheetObj.CheckAll("cfm_i",0,1);
    		sheetObj.CheckAll("cfm_n",0,1);
    	} else if( colNm == "cfm_n" ){
    		sheetObj.CheckAll("cfm_i",0,1);
    		sheetObj.CheckAll("cfm_g",0,1);
    		// Initializing _alertSwitch function in case of cfm_g cancellation
    		_alertSwitch=true;
    	}
    }
    // Starting distinguish _alertSwitch
    if( sheetObj.MouseRow()== 1 ){
    	if( colNm == "cfm_i" || colNm == "cfm_n" ){
    		_alertSwitch=true;
    		grp_n3pty_src_sub_sys_cd="_NULL";
    		grp_g_vvd="_NULL";
    		grp_curr="_NULL";
    		grp_trd_party_val="_NULL";
    	} else if( colNm == "cfm_g" ){
    		var k=0;
    		for(var i=2; i <= sheetObj.RowCount()+1 ; i++){
    			if(sheetObj.GetCellValue(i,"cfm_g") == 1){
    				k++;
    			}
    		}
    		if( k==0 ){
    			grp_n3pty_src_sub_sys_cd="_NULL";
    			grp_g_vvd="_NULL";
    			grp_curr="_NULL";
    			grp_trd_party_val="_NULL";
    		}
    		_alertSwitch=false;
    	}
    } else if( sheetObj.MouseRow()> 1 ){
    	var k=0;
    	for(var i=2; i <= sheetObj.RowCount()+1 ; i++){
    		if(sheetObj.GetCellValue(i,"cfm_g") == 1){
    			k++;
    		}
    	}
    	if( k==0 ){
    		grp_n3pty_src_sub_sys_cd="_NULL";
    		grp_g_vvd="_NULL";
    		grp_curr="_NULL";
    		grp_trd_party_val="_NULL";
    	}
    	_alertSwitch=true;
    }
    */
    // Finishing distinguish _alertSwitch
    // Saving for detect a changed of sheet1.vndr_cust_div_cd'
    if (colNm == "vndr_cust_div_cd") {
        document.form.s_vndr_cust_div_cd.value = sheetObj.GetCellValue(Row, "vndr_cust_div_cd");
    }
}

/** 
 * OnMouseDown Event for header event in case of the entire selection
 **/
function sheet1_OnChange(sheetObj, Row, Col, Value) {
    var colNm = sheetObj.ColSaveName(Col);
    if (colNm == 'cfm_i' || colNm == 'cfm_g') {
        if (sheetObj.GetCellValue(Row, 'vndr_cust_div_cd') == '' || sheetObj.GetCellValue(Row, 'trd_party_val') == '') {
            sheetObj.SetCellValue(Row, 'cfm_i', 0, 0);
            sheetObj.SetCellValue(Row, 'cfm_g', 0, 0);
            ComShowCodeMessage('TPB90081');
            return;
        }
    }
    // Grouping Validation Check
    switch (Col) {
        case 3: // I
            if (sheetObj.GetCellValue(Row, 'cfm_g') == 1) {
                grp_cnt--;
            }
            sheetObj.SetCellValue(Row, 'cfm_g', 0);
            sheetObj.SetCellValue(Row, 'cfm_n', 0);
            sheetObj.SetCellValue(Row, 'cfm_c', 0);
            sheetObj.SetCellEditable(Row, "n3pty_non_cfm_rsn_cd", 0);
            break;

        case 4: // G
            if (sheetObj.GetCellValue(Row, 'cfm_g') == 1) {
                grp_cnt++;
            } else {
                grp_cnt--;
            }
            sheetObj.SetCellValue(Row, 'cfm_i', 0);
            sheetObj.SetCellValue(Row, 'cfm_n', 0);
            sheetObj.SetCellValue(Row, 'cfm_c', 0);
            sheetObj.SetCellEditable(Row, "n3pty_non_cfm_rsn_cd", 0);
            break;

        case 5: // N
            if (sheetObj.GetCellValue(Row, 'cfm_g') == 1) {
                grp_cnt--;
            }
            sheetObj.SetCellValue(Row, 'cfm_i', 0);
            sheetObj.SetCellValue(Row, 'cfm_g', 0);
            sheetObj.SetCellValue(Row, 'cfm_c', 0);
            break;

        case 6:
            sheetObj.SetCellValue(Row, 'cfm_d', 0);
            break;

        case 7:
            sheetObj.SetCellValue(Row, 'cfm_r', 0);
            break;
            
        case 8: // N
            if (sheetObj.GetCellValue(Row, 'cfm_g') == 1) {
                grp_cnt--;
            }
            sheetObj.SetCellValue(Row, 'cfm_i', 0);
            sheetObj.SetCellValue(Row, 'cfm_n', 0);
            sheetObj.SetCellValue(Row, 'cfm_g', 0);
            break;
    }

    // validation check for "G" selection
    if (sheetObj.GetCellValue(Row, 'cfm_g') == 1) { // when "G" checked
        var errCheck = 0; // total error count
        var errMsg = "Invalidate Data"; // error alarm message
        if (grp_trd_party_val == "_NULL") {
            grp_trd_party_val = sheetObj.GetCellValue(Row, 'trd_party_val');
        } else {
            if (sheetObj.GetCellValue(Row, 'trd_party_val') != grp_trd_party_val) {
                sheetObj.SetCellValue(Row, 'cfm_g', 0);
                errCheck++;
                errMsg += "\n" + errCheck + ". 3rd Party Code";
            }
        }
        if (grp_n3pty_src_sub_sys_cd == "_NULL") {
            grp_n3pty_src_sub_sys_cd = sheetObj.GetCellValue(Row, 'n3pty_src_sub_sys_cd');
        } else {
//            if (sheetObj.GetCellValue(Row, 'n3pty_src_sub_sys_cd') != grp_n3pty_src_sub_sys_cd) {
//                sheetObj.SetCellValue(Row, 'cfm_g', 0);
//                errCheck++;
//                errMsg += "\n" + errCheck + ". Exp.Type";
//            }
        }
        if (grp_g_vvd == "_NULL") {
            grp_g_vvd = sheetObj.GetCellValue(Row, 'g_vvd');
        } else {
            if (sheetObj.GetCellValue(Row, 'g_vvd') != grp_g_vvd) {
                sheetObj.SetCellValue(Row, 'cfm_g', 0);
                errCheck++;
                errMsg += "\n" + errCheck + ". VVD";
            }
        }
        if (grp_curr == "_NULL") {
            grp_curr = sheetObj.GetCellValue(Row, 'if_curr_cd');
        } else {
            if (sheetObj.GetCellValue(Row, 'if_curr_cd') != grp_curr) {
                sheetObj.SetCellValue(Row, 'cfm_g', 0);
                errCheck++;
                errMsg += "\n" + errCheck + ". Currency";
            }
        }
        if (errCheck > 0) {
            grp_cnt--;
            if (_alertSwitch == true) {
                ComShowMessage(errMsg);
            }
        }
    }

    if (colNm == 'trd_party_val') {
        if (sheetObj.GetCellValue(Row, 'vndr_cust_div_cd') == "V") {
            sheetObj.SetCellValue(Row, "vndr_seq", sheetObj.GetCellValue(Row, "trd_party_val"));

        } else if (sheetObj.GetCellValue(Row, 'vndr_cust_div_cd') == "C") {
            if (sheetObj.GetCellValue(Row, "trd_party_val") != null && sheetObj.GetCellValue(Row, "trd_party_val").length > 2) {
                sheetObj.SetCellValue(Row, "cust_cnt_cd", sheetObj.GetCellValue(Row, "trd_party_val").substring(0, 2));
                sheetObj.SetCellValue(Row, "cust_seq", sheetObj.GetCellValue(Row, "trd_party_val").substring(2));
            }

        } else if (sheetObj.GetCellValue(Row, 'vndr_cust_div_cd') == "S") {
            sheetObj.SetCellValue(Row, "n3pty_ofc_cd", sheetObj.GetCellValue(Row, "trd_party_val"));

        }
    }

    // validation check for "G" selection
    /*if( grp_cnt == 0 ){ 
  			grp_n3pty_src_sub_sys_cd="_NULL";
  			grp_g_vvd="_NULL";
  			grp_curr="_NULL";
  			grp_trd_party_val="_NULL";
  		}
  		_sheet_onchange();
  		var colNm=sheetObj.ColSaveName(Col);
  		var lvl=document.form.s_office_level.value;
  		//Impossible to confirm in case of Cost Exception
  		if(colNm == "cfm_i" || colNm == "cfm_g"){
  			if(sheetObj.GetCellValue(Row, 'cost_expt_flg') == "Y"){
  				ComShowCodeMessage('TPB90026','','','');
  				sheetObj.SetCellEditable(Row, "cfm_i",0);
  				sheetObj.SetCellEditable(Row, "cfm_g",0);
  				sheetObj.SetCellValue(Row, "cfm_i","0",0);
  				sheetObj.SetCellValue(Row, "cfm_g","0",0);
  				sheetObj.SetRowStatus(Row,"");
  				//Initializing group check
  				sheetObj.CheckAll("cfm_i",0,1);
  				sheetObj.CheckAll("cfm_g",0,1);
  				sheetObj.CheckAll("cfm_n",0,1);
  				grp_cnt=0;
  				grp_n3pty_src_sub_sys_cd="_NULL";
  				grp_g_vvd="_NULL";
  				grp_curr="_NULL";
  				grp_trd_party_val="_NULL";
  				return;
  			}
  		}
  		//Impossible to confirm in case of FINC_DIR_CD a nonesevent
  		if(colNm == "cfm_i" || colNm == "cfm_g"){
  			if(sheetObj.GetCellValue(Row, 'check_finc_dir_cd') != "Y"){
  				ComShowCodeMessage('TPB90082');
  				sheetObj.SetCellEditable(Row, "cfm_i",0);
  				sheetObj.SetCellEditable(Row, "cfm_g",0);
  				sheetObj.SetCellValue(Row, "cfm_i","0",0);
  				sheetObj.SetCellValue(Row, "cfm_g","0",0);
  				sheetObj.SetRowStatus(Row,"");
  				//Initializing group check
  				sheetObj.CheckAll("cfm_i",0,1);
  				sheetObj.CheckAll("cfm_g",0,1);
  				sheetObj.CheckAll("cfm_n",0,1);
  				grp_cnt=0;
  				grp_n3pty_src_sub_sys_cd="_NULL";
  				grp_g_vvd="_NULL";
  				grp_curr="_NULL";
  				grp_trd_party_val="_NULL";
  				return;
  			}
  		}
  		if(colNm == 'vndr_cust_div_cd' || colNm == 'trd_party_val'){
  			var vndr_cust_div_cd=sheetObj.GetCellValue(Row, "vndr_cust_div_cd");
  			var trd_party_val=sheetObj.GetCellValue(Row, "trd_party_val");
  			trd_party_val=ComTrim(trd_party_val).toUpperCase(); // ComTrim & UPPER CASE 
  			sheetObj.SetCellValue(Row, "trd_party_val",trd_party_val,0);
  			if( ComTrim( sheetObj.GetCellValue(Row, 'trd_party_val') ) != ''){
  				if( ComTrim(sheetObj.GetCellValue(Row, 'vndr_cust_div_cd') ) != ""){
  					sheetObj.SetCellEditable(Row, "cfm_i",1);
  					sheetObj.SetCellEditable(Row, "cfm_g",1);
  				}
  				if(sheetObj.GetCellValue(Row, 'if_curr_cd') == "" ||
  						parseFloat(sheetObj.GetCellValue(Row, 'cfm_amt')) == 0){
  					sheetObj.SetCellEditable(Row, "cfm_flg_y",0);
  					sheetObj.SetCellValue(Row, "cfm_flg_y","0",0);
  				}
  			}else{
  				sheetObj.SetCellEditable(Row, "cfm_flg_y",0);
  				sheetObj.SetCellValue(Row, "cfm_flg_y","0",0);
  				sheetObj.SetCellValue(Row, "trd_party_val","",0);
  			}
  			if(colNm == "vndr_cust_div_cd" && vndr_cust_div_cd == ""){
  				sheetObj.SetCellValue(Row, "trd_party_val","",0);
  				sheetObj.SetCellValue(Row, "vndr_cnt_cd","",0);
  				sheetObj.SetCellValue(Row, "vndr_seq","",0);
  				sheetObj.SetCellValue(Row, "cust_cnt_cd","",0);
  				sheetObj.SetCellValue(Row, "cust_seq","",0);
  				sheetObj.SetCellValue(Row, "n3pty_ofc_cd","",0);
  			}
              // 3rd Party Input directly ... 
              if ( trd_party_val.length == 0 ){ // Setting in case of empty 3rd party value
  				sheetObj.SetCellValue(Row, "trd_party_val","",0);
  				sheetObj.SetCellValue(Row, "vndr_cnt_cd","",0);
  				sheetObj.SetCellValue(Row, "vndr_seq","",0);
  				sheetObj.SetCellValue(Row, "cust_cnt_cd","",0);
  				sheetObj.SetCellValue(Row, "cust_seq","",0);
  				sheetObj.SetCellValue(Row, "n3pty_ofc_cd","",0);
              } else { // Checking Validation in case of not empty 3rd party value
                  if ( colNm == 'trd_party_val' && ( vndr_cust_div_cd=="V" || vndr_cust_div_cd=="C" || vndr_cust_div_cd=="S" ) ){
                        document.all.s_vndr_cust_div_cd.value=vndr_cust_div_cd; // input type hidden
                        document.all.s_trd_party_val.value=trd_party_val; // input type hidden
                        getTPBGenCombo('Void_ThirdParty_Sheet','checkTrdParty','V','','',new Array("s_trd_party_val","s_vndr_cust_div_cd"), Row); 
                  }
              }
  		}
  		if(colNm == 'if_curr_cd'){
  			if(sheetObj.GetCellValue(Row, 'if_curr_cd') != "" && ComTrim(sheetObj.GetCellValue(Row, 'vndr_cust_div_cd')) != '' && sheetObj.GetCellValue(Row, 'trd_party_val') != '' && parseFloat(sheetObj.GetCellValue(Row, 'cfm_amt')) > 0){
  				sheetObj.SetCellEditable(Row, "cfm_i",1);
  				sheetObj.SetCellEditable(Row, "cfm_g",1);
  			}else{
  				sheetObj.SetCellEditable(Row, "cfm_i",0);
  				sheetObj.SetCellEditable(Row, "cfm_g",0);
  				sheetObj.SetCellValue(Row, "cfm_i","0",0);
  				sheetObj.SetCellValue(Row, "cfm_g","0",0);
  			}
  		}
  		if(colNm == 'cfm_amt'){
  			if(parseFloat(sheetObj.GetCellValue(Row, 'cfm_amt')) > 0 && sheetObj.GetCellValue(Row, 'if_curr_cd') != "" && ComTrim(sheetObj.GetCellValue(Row, 'vndr_cust_div_cd')) != '' && sheetObj.GetCellValue(Row, 'trd_party_val') != ''){
  				sheetObj.SetCellEditable(Row, "cfm_i",1);
  				sheetObj.SetCellEditable(Row, "cfm_g",1);
  			}else{
  				sheetObj.SetCellEditable(Row, "cfm_i",0);
  				sheetObj.SetCellEditable(Row, "cfm_g",0);
  				sheetObj.SetCellValue(Row, "cfm_i","0",0);
  				sheetObj.SetCellValue(Row, "cfm_g","0",0);
  			}
  			if(sheetObj.GetCellValue(Row,"n3pty_bil_tp_cd") == "JO"){
  				if( parseFloat(sheetObj.GetCellValue(Row,"cfm_amt")) <= 0  ){
  					ComShowCodeMessage('TPB90035','Confirmed Amount','0.00');
  					sheetObj.SetCellValue(Row,"cfm_amt",sheetObj.GetCellValue(Row,"if_amt"),0);
  					sheetObj.SetCellEditable(Row, "cfm_flg_y",1);
  					sheetObj.SetCellEditable(Row, "cfm_flg_n",1);
  				}
  			}
  		}
  		if(colNm == "cfm_n"){		
  			if(Value == "0"){
  				sheetObj.SetCellValue(Row, 'n3pty_non_cfm_rsn_cd',"",0);
  				sheetObj.SetCellEditable(Row, "n3pty_non_cfm_rsn_cd",0);
  			}else if(Value == "1"){
  				sheetObj.SetCellEditable(Row, "n3pty_non_cfm_rsn_cd",1);
  				sheetObj.SetCellValue(Row, 'cfm_i','0',0);
  				sheetObj.SetCellValue(Row, 'cfm_g','0',0);
  				sheetObj.SetCellValue(Row, 'n3pty_cfm_cd','N',0);
  			}
  		}
  		if(colNm == 'n3pty_non_cfm_rsn_cd'){
  			if(Value == "CN"){
  				ComOpenPopup('/opuscntr/COM_ENS_092.do', 850, 550, 'getStaff_sheet_formail', 'none', Row, 22);
  			}
  		}
  		//Deactivation of Confirm in case of RHQ login
  		if(lvl == "R"){
//  		sheetObj.CellEditable(Row, "cfm_flg_y") = false;
  			sheetObj.SetCellEditable(Row, "cfm_i",0);
  			sheetObj.SetCellEditable(Row, "cfm_g",0);
  		}
  		//Checking Auto Update of Outstanding Amount
  		tpb_chgColor_ots_amt(sheetObj, 59, 17, null, 2);
  		//Controlling UPD STS 
		if(sheetObj.GetCellValue(Row, "cfm_i") == "0" &&
		sheetObj.GetCellValue(Row, "cfm_g") == "0" &&
		sheetObj.GetCellValue(Row, "cfm_n") == "0" &&
		sheetObj.GetCellValue(Row, "cfm_r") == "0" &&
		sheetObj.GetCellValue(Row, "cfm_d") == "0"){
  				sheetObj.SetRowStatus(Row,"");
  		}
  		if(colNm == "vndr_cust_div_cd"){
  			var sVndrCustDivCd=document.form.s_vndr_cust_div_cd.value;
  			var vndrCustDivCd=sheetObj.GetCellValue(Row, "vndr_cust_div_cd");
  			if(sVndrCustDivCd != vndrCustDivCd){
  				sheetObj.SetCellValue(Row, "trd_party_val","",0);
  			}
  		}
  		if( sheetObj.GetCellValue(Row, 'cfm_g') == 1 ){
  			sheetObj.SetCellValue(Row, "n3pty_non_cfm_rsn_cd","",0);
  		}*/
}

function getStaff_sheet_formail(rowArray, row, col) {
    var gubun = ':';
    var user_id = '';
    var user_email = '';
    for (var i = 0; i < rowArray.length; i++) {
        if (i == rowArray.length - 1) gubun = '';
        colArray = rowArray[i];
        user_id += colArray[0] + gubun;
        user_email += colArray[1] + gubun;
    }
    var sheetObj = sheetObjects[0];
    sheetObj.SetCellValue(row, 'toEmail', user_email + ");" + user_id);
}

var mover_pos = "";

function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    try {
        //Getting row and column of mouse position
        Row = sheetObj.MouseRow();
        Col = sheetObj.MouseCol();
        //Passing in case of not data row and not 'if_rmk' column
        if (Row <= 0 || sheetObj.ColSaveName(Col) != 'if_rmk') {
            ShowTip.style.visibility = 'hidden';
            return;
        }
        //Recollection tooltip cell position
        if (mover_pos == Row + "/" + Col) return;
        mover_pos = Row + "/" + Col;
        sText = sheetObj.GetCellText(Row, "if_rmk");
        //Wipping tooltip in case of empty value 
        if (sText == "") {
            ShowTip.style.visibility = 'hidden';
            return;
        }
        //Making tooltip
        popFrame2.sheetPopToolTip(sheetObj, X + 2, Y - 2, ShowTip, sText);
    } catch (e) {}
}

function getVVD(rArray) {
    var cArray = rArray[0];
    document.all.s_vvd.value = cArray[7];
}

function valueSplit(formObj) {
    //Dividing input value
    formObj.s_bkg_no.value = formObj.s_bkg_no_all;
    formObj.s_bl_no.value = formObj.s_bl_no_all;
    formObj.s_vsl_cd.value = formObj.s_vvd.value.substring(0, 4);
    formObj.s_skd_voy_no.value = formObj.s_vvd.value.substring(4, 8);
    formObj.s_skd_dir_cd.value = formObj.s_vvd.value.substring(8, 9);
}

function if_rhq_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    var f = document.form;
    if (f.s_office_level.value == "H") { // HO
        ComClearCombo(f.s_if_ctrl_cd);
        getTPBGenCombo('s_if_ctrl_cd', 'searchControlOfficeList', 'F', '', '2', new Array("s_if_rhq_cd", "s_office_level"));
        ComClearCombo(f.s_if_ofc_cd);
        getTPBGenCombo('s_if_ofc_cd', 'searchTPBOfficeList', 'F', '', '2', new Array("", ""));
    } else if (f.s_office_level.value == "R") { //RHQ
        getTPBGenCombo('s_if_ctrl_cd', 'searchControlOfficeList', 'F', '', '2', new Array("s_if_rhq_cd", "s_office_level"));
    } else if (f.s_office_level.value == "T" || f.s_office_level.value == "") { //General Office
        ComClearCombo(f.s_if_ofc_cd);
        ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
    }
}

function if_ctrl_cd_OnChange() {
    var f = document.form;
    if (f.s_office_level.value == "H") { // HO
        ComClearCombo(f.s_if_ofc_cd);
        getTPBGenCombo('s_if_ofc_cd', 'searchTPBOfficeList', 'F', '', '2', new Array("s_if_ctrl_cd", "s_office_level"));
    } else if (f.s_office_level.value == "R") { //RHQ
        ComClearCombo(f.s_if_ofc_cd);
        getTPBGenCombo('s_if_ofc_cd', 'searchTPBOfficeList', 'F', '', '2', new Array("s_if_ctrl_cd", "s_office_level"));
    } else if (f.s_office_level.value == "C") { //CTRL
        getTPBGenCombo('s_if_ofc_cd', 'searchTPBOfficeList', 'F', '', '2', new Array("s_if_ctrl_cd", "s_office_level"));
    } else if (f.s_office_level.value == "T" || f.s_office_level.value == "") { //General Office
        ComClearCombo(f.s_if_ofc_cd);
        ComAddComboItem(f.s_if_ofc_cd, f.s_ofc_cd_for_rhq.value, f.s_ofc_cd_for_rhq.value);
    }
}

function tpb_searchBillingCaseByExpenseType() {
    if (document.all.s_n3pty_src_sub_sys_cd.value != "") {
        getTPBGenCombo('s_n3pty_bil_tp_cd', 'searchBillingCaseByExpenseType', 'F', '', '2', new Array("s_n3pty_src_sub_sys_cd"));
    } else {
        ComClearCombo(document.all.s_n3pty_bil_tp_cd);
        ComAddComboItem(document.all.s_n3pty_bil_tp_cd, "", "<<Select>>");
    }
}

function getCheckN3ptyNo(formObj, sheetObj) {
    var str = '';
    var temp = '';
    if (sheetObj.RowCount() > 0) {
        for (var i = 2; i < sheetObj.RowCount() + 2; i++) {
            //if(sheetObj.RowStatus(i) == 'U'){
            temp = sheetObj.GetCellValue(i, 'n3pty_no');
            if (temp.length == 14) {
                str += temp + "|";
                temp = '';
            }
        }
        document.form.s_n3pty_no_strs_link.value = str;
    } else {
        str = '';
    }
    if (str == '') {
        ComShowCodeMessage('COM12176', '', '', '');
    }
    return str;
}

/* Finishing work */