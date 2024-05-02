/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0100.js
*@FileTitle : CSR I/F Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
=========================================================*/
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
document.onclick = processButtonClick;

/**
 * retrieve
 * 	
 * @return
 */
function retrieve() {
    var formObject = document.form;
    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}

/**
 * Event handler processing by button name
 *  
 * @return
 */
function processButtonClick() {
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                retrieve();
                break;

            case "btn_new":
                sheetObject.RemoveAll();
                formObject.reset();
			    var rtnVal = getDBDate();    // tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
			    if(rtnVal.length > 0){
			    	setPeriodFromTo(rtnVal);
			    }
                document.form.fm_eff_dt.focus();
                break;

            case "btng_editapprovalstep": //alert("start btng_editapprovalstep");
                if (sheetObjects[0].RowCount() > 0 && sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_status') == 'Approval Requested') {
                    //						var param = '?mode=csr&csr_no='+sheetObjects[0].CellValue(sheetObjects[0].SelectRow,'csr_no')+'&classId=COM_ENS_0T2';
                    //						ComOpenPopup('/opuscntr/COM_ENS_0T2.do'+param, 835, 550, '', 'none', true);	
                    with(document.form) {
                        var v_ofc_cd = ofc_cd.value;
                        var param = '?mode=save&ofc_cd=' + v_ofc_cd + '&csr_no=' + sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'csr_no') + '&sub_sys_cd=TES' + '&classId=COM_ENS_0T1&target_obj_nm=apro_step';
                        ComOpenPopup('/opuscntr/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);
                    }
                }
                //				ComShowCodeMessage( "COM12111");
                break;

            case "btng_csrformat":
                if (sheetObjects[0].RowCount() <= 0) {
                    ComShowMessage(ComGetMsg('TES25006'));
                    return false;
                }
                if (sheetObjects[0].GetSelectRow() == undefined || sheetObjects[0].GetSelectRow() == null || sheetObjects[0].GetSelectRow() == 0) {
                    ComShowMessage(ComGetMsg('TES21908'));
                    return false;
                }
                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == undefined ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == null ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no').trim() == '') {
                    ComShowMessage(ComGetMsg('TES40048'));
                    return false;
                }
                sheetObject1.RemoveAll();
                sheetObject2.RemoveAll();
                doActionIBSheet1(sheetObject2, formObject, IBSEARCH);
                break;

            case "btng_invoicelistinquiry":
                if (sheetObjects[0].RowCount() <= 0) {
                    ComShowMessage(ComGetMsg('TES25006'));
                    return false;
                }
                if (sheetObjects[0].GetSelectRow() == undefined || sheetObjects[0].GetSelectRow() == null || sheetObjects[0].GetSelectRow() == 0) {
                    ComShowMessage(ComGetMsg('TES21908'));
                    return false;
                }
                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == undefined ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == null ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no').trim() == '') {
                    ComShowMessage(ComGetMsg('TES40048'));
                    return false;
                }
                var url = 'ESD_TES_0101.screen';
                url = url + '?csr_no=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') + '&cost_ofc_cd=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'cost_ofc_cd');

                ComOpenWindow(url, window, "dialogWidth:940px;dialogHeight:540px;help:no;status:no;resizable:yes;", true);
                break;

            case "btng_csrcancel": //alert("start btng_csrcancel");
                if (OFC_CD == undefined || OFC_CD == null || OFC_CD.trim() == '') {
                    ComShowMessage('No Inv OFC data is found in the session');
                    return false;
                }
                if (formObject.ofc_cd.value == undefined || formObject.ofc_cd.value == null || formObject.ofc_cd.value.trim() == '') {
                    ComShowMessage('No Invoice Office data');
                    return false;
                }
                if (OFC_CD != formObject.ofc_cd.value) {
                    //ComShowMessage("Inv OFC data retrieved don't match Inv OFC data in the session");
                    //ComShowMessage("login Inv OFC is not authorized");
                    ComShowMessage("No authority to cancel CSR - Invoice office mismatch!");
                    return false;
                }
                if (sheetObjects[0].RowCount() <= 0) {
                    ComShowMessage(ComGetMsg('TES25006'));
                    return false;
                }
                if (sheetObjects[0].GetSelectRow() == undefined || sheetObjects[0].GetSelectRow() == null || sheetObjects[0].GetSelectRow() == 0) {
                    ComShowMessage(ComGetMsg('TES21908'));
                    return false;
                }
                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == undefined ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == null ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no').trim() == '') {
                    ComShowMessage(ComGetMsg('TES40048'));
                    return false;
                }
                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'aft_act_flg') == 'N' || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'aft_act_flg') == 'X') {
                    return false;
                }
                /*
var if_flg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'if_flg');
var rcv_err_flg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'rcv_err_flg');
var tml_inv_sts_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'tml_inv_sts_cd');
var tml_inv_rjct_sts_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'tml_inv_rjct_sts_cd');
					if (if_flg=='E'){ 
						doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					} else if (rcv_err_flg=='E' || (tml_inv_sts_cd=='A' && tml_inv_rjct_sts_cd=='RJ')){ //'A/P Rejected' or 'Disapproved' -> popup창으로 이동
						var url='ESD_TES_0025.screen';
url=url + '?csr_no='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'csr_no');
url=url + '&vndr_no='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'vndr_no');
url=url + '&inv_desc='+encodeURI(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'inv_desc'));
url=url + '&no_of_inv='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'no_of_inv');
url=url + '&csr_curr_cd='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'csr_curr_cd');
url=url + '&csr_amt='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'csr_amt');
url=url + '&attr_ctnt2='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'attr_ctnt2');
url=url + '&iss_dt='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'iss_dt');
url=url + '&rcv_dt='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'rcv_dt');
url=url + '&vndr_term_nm='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'vndr_term_nm');
url=url + '&due_dt='+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'due_dt');
						 ComOpenWindow(url,  window,  "dialogWidth:940px; dialogHeight:500px; help:no; status:no; resizable:yes;" , true);
					}
					*/
                if (sheetObjects[0].RowCount() > 0 && sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_status') == 'Approval Requested') {
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
                } else {
                    if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_status') == 'I/F Error') {
                        doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
                    } else if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_status') == 'A/P Rejected' || sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_status') == 'Disapproved') {
                        var url = 'ESD_TES_0025.screen';
                        url = url + '?csr_no=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no');
                        url = url + '&vndr_no=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'vndr_no');
                        url = url + '&inv_desc=' + encodeURI(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'inv_desc'));
                        url = url + '&no_of_inv=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'no_of_inv');
                        url = url + '&csr_curr_cd=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_curr_cd');
                        url = url + '&csr_amt=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_amt');
                        url = url + '&attr_ctnt2=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'attr_ctnt2');
                        url = url + '&iss_dt=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'iss_dt');
                        url = url + '&rcv_dt=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'rcv_dt');
                        url = url + '&vndr_term_nm=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'vndr_term_nm');
                        url = url + '&due_dt=' + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'due_dt');
                        ComOpenWindow(url, window, "dialogWidth:1200px;dialogHeight:640px;help:no;status:no;resizable:yes;", true);
                    }
                }
                break;

            case "btng_viewapprovalstep":
                if (sheetObjects[0].RowCount() <= 0) {
                    ComShowMessage(ComGetMsg('TES25006'));
                    return false;
                }
                if (sheetObjects[0].GetSelectRow() == undefined || sheetObjects[0].GetSelectRow() == null || sheetObjects[0].GetSelectRow() == 0) {
                    ComShowMessage(ComGetMsg('TES21908'));
                    return false;
                }
                if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == undefined ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no') == null ||
                    sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no').trim() == '') {
                    ComShowMessage(ComGetMsg('TES40048'));
                    return false;
                }
                var apro_rqst_no = sheetObject.GetCellValue(sheetObjects[0].GetSelectRow(), "apro_rqst_no");
                if (apro_rqst_no == undefined || apro_rqst_no == null || apro_rqst_no.trim() == '') {
                    ComShowMessage(ComGetMsg('TES40041', 'Approval Request No'));
                    return false;
                }
                var url = "/opuscntr/COM_ENS_0W1.do?apro_rqst_no=" + apro_rqst_no;
                ComOpenWindow(url, window, "dialogWidth:640px;dialogHeight:250px;help:no;status:no;resizable:yes;", true);
                break;

            case "btns_calendar1":
                var cal = new ComCalendar();
                cal.select(formObject.fm_eff_dt, 'yyyy-MM-dd');
                break;

            case "btns_calendar2":
                var cal = new ComCalendar();
                cal.select(formObject.to_eff_dt, 'yyyy-MM-dd');
                break;

            case "btng_print":
                if (sheetObjects[0].RowCount() < 1) {
                    ComShowCodeMessage("COM132501");
                } else {
                    sheetObjects[0].Down2Excel({
                        HiddenColumn: true
                    });
                }
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
 * 
 * @param {ibsheet} sheet_obj	ibsheet object
 * @return
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * 
 * @return
 */
function loadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    /*
    		if (READONLY_YN!=null && READONLY_YN.trim()=='Y') {
    			document.form.ofc_cd.readOnly=false;
    			document.all.item("btng_csrcancel_yn")[0].style.display="none";
    			document.all.item("btng_csrcancel_yn")[1].style.display="inline";
    		} else {
    			document.form.ofc_cd.readOnly=true;
    			document.all.item("btng_csrcancel_yn")[0].style.display="inline";
    			document.all.item("btng_csrcancel_yn")[1].style.display="none";
    		}
    */
    tes_setBackColorAllTextTypeReadonly(document.form);
    
    var rtnVal = getDBDate();    // tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
    if(rtnVal.length > 0){
    	setPeriodFromTo(rtnVal);
    }
   
    document.form.fm_eff_dt.focus();
}

/** 
 * set Period From To
 * 
 * @return
 */
function setPeriodFromTo(argVal) {
    var formObj = document.form;
    var to_dt = new String(argVal).substring(0, 8);
    var fr_dt;
    if (to_dt != undefined && to_dt != null && to_dt.trim() != '' && to_dt.length == 8 && !isNaN(to_dt)) {
        //fr_dt = tes_getDiffDate(to_dt, -30, 'D');
        fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6, 8);
        if (fr_dt != undefined && fr_dt != null && fr_dt.trim() != '' && fr_dt.length == 8) {
            if (fr_dt.substring(6, 8) > ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10))) {
                fr_dt = fr_dt.substring(0, 6) + ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10));
            }
            formObj.fm_eff_dt.value = fr_dt.substring(0, 4) + '-' + fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
            formObj.to_eff_dt.value = to_dt.substring(0, 4) + '-' + to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
        }
    }
    if (formObj.fm_eff_dt.value != null && formObj.to_eff_dt.value != null) {
        if (READONLY_YN != undefined && READONLY_YN != null && READONLY_YN == 'Y') {
            retrieve();
        }
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 * @param {ibsheet} sheetObj	ib sheet object
 * @param {int}		sheetNo		sheet number
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
			
				var HeadTitle1="|CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|CSR \nCreated Time|CSR requested|CSR requested|CSR Approved/ Disapproved|CSR Approved/ Disapproved|No of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|ASA No." ;
				var HeadTitle2="|CSR No.|Payment S/P|Payment S/P|I/F\nStatus|I/F Status\nUpdated Time|Error Reason|CSR \nCreated Time|ID|Name|ID|Name|No of\n Invoice|Currency|Total\nAmount|Payment\nDue Date|Payment\nGroup|ASA No." ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",               KeyField:0,   CalcLogic:"" },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"inv_desc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"if_status",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:0,   SaveName:"if_dt",                KeyField:0,   CalcLogic:"",   Format:"YmdHms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"if_err_rsn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:140,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                KeyField:0,   CalcLogic:"",   Format:"YmdHms",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rqst_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rqst_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"apro_usr_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"apro_usr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							
							{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"no_of_inv",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"csr_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"csr_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"due_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_grp_lu_cd",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"attr_ctnt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rcv_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vndr_term_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"aft_act_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"if_flg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"rcv_err_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"tml_inv_rjct_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"apro_rqst_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				//SetSheetHeight(ComGetSheetHeight(sheetObj, 18)); 
				ComResizeSheet(sheetObj);
			}
		break;
		
		case 2:      //sheet1 init
			with(sheetObj){
			
				var HeadTitle="csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|pay_curr_cd|pay_amt|apro_step|title|chk_addr1|chk_addr2|chk_addr3|chk_cty_nm|chk_ste_cd|chk_zip_cd|chk_cnt_cd" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"pre_csr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_office",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_prpd_dy",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_to",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_csr_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_group",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_evi_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_due_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_asa_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_amt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_pay_amt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"apro_step",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"pre_title",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_addr1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_addr2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_addr3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_cty_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_ste_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_zip_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"chk_cnt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				//SetSheetHeight(ComGetSheetHeight(sheetObj, 18)); 
				ComResizeSheet(sheetObj);
			}
		break; 
		
		case 3:      //sheet1 init
			with(sheetObj){
			
				var HeadTitle="char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_chart_of_account",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pre_account_name",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pre_gl_date",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_city",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_desc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_debit",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"pre_credit",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				SetEditable(1);
				//SetSheetHeight(ComGetSheetHeight(sheetObj, 18)); 
				ComResizeSheet(sheetObj);
			}
		break;                                
	}
}

/** handling sheet process
 * @param {ibsheet} sheetObj	ibsheet object
 * @param {form} 	formObj		form object
 * @param {String}	sAction		action value
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCHLIST;
            sheetObj.DoSearch("ESD_TES_0100GS.do", tesFrmQryStr(formObj));
            break;

        case IBSAVE: //Save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = MULTI;
            formObj.csr_no.value = sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'csr_no');
            var sXml = sheetObj.GetSaveData("ESD_TES_0100GS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(sXml, true);
            break;

        case IBSEARCH_ASYNC01: //Save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            formObj.f_cmd.value = SEARCH01;
            formObj.csr_no.value = sheetObj.GetCellValue(sheetObj.GetSelectRow(), 'csr_no');
            var sXml = sheetObj.GetSaveData("ESD_TES_0100GS.do", tesFrmQryStr(formObj));
            sheetObj.LoadSaveData(sXml, true);
            break;
    }
}

/** handling sheet process
 * @param {ibsheet} sheetObj		ibsheet object
 * @param {form} 	formObj		form object
 * @param {String}	sAction		action value
 */
function doActionIBSheet1(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH03;
            formObj.csr_no.value = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'csr_no');
            var searchXml = sheetObjects[2].GetSearchData("ESD_TES_0024PreView.do", tesFrmQryStr(formObj));
            var arrXml = searchXml.split("|$$|");
            sheetObjects[1].LoadSearchData(arrXml[0], { Sync: 1 });
            sheetObjects[2].LoadSearchData(arrXml[1], { Sync: 1 });
            searchXml = null;
            arrXml[0] = null;
            arrXml[1] = null;
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet} sheet1	ibsheet ojbect
 * @param {String}  ErrMsg	err message     
 * @return
 */
function sheet1_OnSearchEnd(sheet1, ErrMsg) { //alert("start sheet1_OnSearchEnd");
    if (sheet1.RowCount() > 0) {
        for (var i = 1; i <= sheet1.RowCount() + 1; i++) {
            if (sheet1.GetCellValue(i, 'aft_act_flg') != null && (sheet1.GetCellValue(i, 'aft_act_flg') == 'N' || sheet1.GetCellValue(i, 'aft_act_flg') == 'X')) {
                sheet1.SetRowBackColor(i, "#FF9999");
            }
        }
    }
    //no support[implemented common]CLT 		sheet1.SelectHighLight=false;
}

/**
 * handling sheet process
 * 
 * @param {ibsheet} sheet1	ibsheet ojbect
 * @param {String}  ErrMsg	err message    
 * @return
 */
function sheet1_OnSaveEnd(sheet1, ErrMsg) {
    if (sheet1.RowCount() > 0) {
        for (var i = 1; i <= sheet1.RowCount(); i++) {
            if (sheet1.GetCellValue(i, 'aft_act_flg') != null && (sheet1.GetCellValue(i, 'aft_act_flg') == 'N' || sheet1.GetCellValue(i, 'aft_act_flg') == 'X')) {
                sheet1.SetRowBackColor(i, "#FF9999");
            }
        }
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet} sheetObj	ibsheet ojbect
 * @param {String}  errMsg		err message    
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, code, errMsg) { //alert("sheet3_OnSearchEnd");
    var srcName = ComGetEvent("name");
    if (code != 0) {
        ComShowMessage(errMsg);
    }
    //      var previewFlg      	= "";
    //		var pre_csr_no			= sheetObj.EtcData("pre_csr_no");			
    //		var pre_office			= sheetObj.EtcData("pre_office");				
    //		var pre_prpd_dy			= sheetObj.EtcData("pre_prpd_dy");			
    //		var pre_pay_to			= sheetObj.EtcData("pre_pay_to");				
    //		var pre_csr_type		= sheetObj.EtcData("pre_csr_type");		
    //		var pre_desc			= sheetObj.EtcData("pre_desc");					
    //		var pre_pay_group		= sheetObj.EtcData("pre_pay_group");		
    //		var pre_evi_tp			= sheetObj.EtcData("pre_evi_tp");				
    //		var pre_due_date		= sheetObj.EtcData("pre_due_date");
    //		var pre_asa_no			= sheetObj.EtcData("pre_asa_no");		
    //		var pre_inv_dt			= sheetObj.EtcData("pre_inv_dt");				
    //		var pre_curr_cd			= sheetObj.EtcData("pre_curr_cd");			
    //		var pre_amt				= sheetObj.EtcData("pre_amt");
    //		var chk_addr1			= sheetObj.EtcData("chk_addr1");
    //		var chk_addr2			= sheetObj.EtcData("chk_addr2");
    //		var chk_addr3			= sheetObj.EtcData("chk_addr3");
    //		var chk_cty_nm			= sheetObj.EtcData("chk_cty_nm");
    //		var chk_ste_cd			= sheetObj.EtcData("chk_ste_cd");
    //		var chk_zip_cd			= sheetObj.EtcData("chk_zip_cd");
    //		var chk_cnt_cd			= sheetObj.EtcData("chk_cnt_cd");
    //		var pre_evi_tp_count	= "";
    //		var pre_title			= pre_title  = "CONSULTATION SLIP";
    //		
    //		var pre_evi_tp;
    var v_apro_step = '';
    if (sheetObjects[0].RowCount() > 0 &&
        (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_status') != 'Approval Requested' && sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'if_status') != 'Disapproved')) {
        //			v_apro_step = sheetObjects[2].EtcData("apro_step");
        v_apro_step = sheetObjects[1].GetCellValue(1, "apro_step");
    }
    var previewFlg       = "";
    var pre_csr_no       = sheetObjects[1].GetCellValue(1, "pre_csr_no");
    var pre_office       = sheetObjects[1].GetCellValue(1, "pre_office");
    var pre_prpd_dy      = sheetObjects[1].GetCellValue(1, "pre_prpd_dy");
    var pre_pay_to       = sheetObjects[1].GetCellValue(1, "pre_pay_to");
    var pre_csr_type     = sheetObjects[1].GetCellValue(1, "pre_csr_type");
    var pre_desc         = sheetObjects[1].GetCellValue(1, "pre_desc");
    var pre_pay_group    = sheetObjects[1].GetCellValue(1, "pre_pay_group");
    var pre_evi_tp       = sheetObjects[1].GetCellValue(1, "pre_evi_tp");
    var pre_due_date     = sheetObjects[1].GetCellValue(1, "pre_due_date");
    var pre_asa_no       = sheetObjects[1].GetCellValue(1, "pre_asa_no");
    var pre_inv_dt       = sheetObjects[1].GetCellValue(1, "pre_inv_dt");
    var pre_curr_cd      = sheetObjects[1].GetCellValue(1, "pre_curr_cd");
    var pre_amt          = sheetObjects[1].GetCellValue(1, "pre_amt");
    var pre_pay_amt      = sheetObjects[1].GetCellValue(1, "pre_pay_amt");
    var chk_addr1        = sheetObjects[1].GetCellValue(1, "chk_addr1");
    var chk_addr2        = sheetObjects[1].GetCellValue(1, "chk_addr2");
    var chk_addr3        = sheetObjects[1].GetCellValue(1, "chk_addr3");
    var chk_cty_nm       = sheetObjects[1].GetCellValue(1, "chk_cty_nm");
    var chk_ste_cd       = sheetObjects[1].GetCellValue(1, "chk_ste_cd");
    var chk_zip_cd       = sheetObjects[1].GetCellValue(1, "chk_zip_cd");
    var chk_cnt_cd       = sheetObjects[1].GetCellValue(1, "chk_cnt_cd");
    var pre_evi_tp_count = "";
    var pre_title        = pre_title = "CONSULTATION SLIP";
    if (cnt_cd == "KR") {
        pre_evi_tp_count = "1";
        //			pre_evi_tp  = pre_evi_tp;	
    } else {
        var sRow = sheetObjects[0].FindCheckedRow(1);
        var arrRow = sRow.split("|");
        pre_evi_tp_count = arrRow.length - 1;
        pre_evi_tp_count = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'no_of_inv');
        pre_evi_tp = pre_evi_tp + "/" + pre_evi_tp_count;
    }
    if (cnt_cd == "KR" || cnt_cd == "JP") {
        pre_amt     = tes_chkAmtFmt(pre_amt    , pre_curr_cd);
        pre_pay_amt = tes_chkAmtFmt(pre_pay_amt, pre_curr_cd);
    } else {
        pre_amt     = tes_chkAmtFmt(pre_amt);
        pre_pay_amt = tes_chkAmtFmt(pre_pay_amt);
    }
    if (pre_curr_cd == "KRW" || pre_curr_cd == "JPY") {
        previewFlg = "krjp";
    }
    sheetObjects[1].RemoveAll();
    sheetObjects[1].DataInsert(-1);
    sheetObjects[1].SetCellValue(1, "pre_csr_no", pre_csr_no);
    sheetObjects[1].SetCellValue(1, "pre_office", sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), 'cost_ofc_cd'));
    sheetObjects[1].SetCellValue(1, "pre_prpd_dy", pre_prpd_dy);
    sheetObjects[1].SetCellValue(1, "pre_pay_to", pre_pay_to);
    sheetObjects[1].SetCellValue(1, "pre_csr_type", pre_csr_type);
    sheetObjects[1].SetCellValue(1, "pre_desc", pre_desc);
    sheetObjects[1].SetCellValue(1, "pre_pay_group", pre_pay_group);
    sheetObjects[1].SetCellValue(1, "pre_evi_tp", pre_evi_tp);
    sheetObjects[1].SetCellValue(1, "pre_due_date", pre_due_date);
    sheetObjects[1].SetCellValue(1, "pre_asa_no", pre_asa_no);
    sheetObjects[1].SetCellValue(1, "pre_inv_dt", pre_inv_dt);
    sheetObjects[1].SetCellValue(1, "pre_curr_cd", pre_curr_cd);
    sheetObjects[1].SetCellValue(1, "pre_amt", pre_amt);
    sheetObjects[1].SetCellValue(1, "pre_pay_amt", pre_pay_amt);
    sheetObjects[1].SetCellValue(1, "pre_title", pre_title);
    sheetObjects[1].SetCellValue(1, "chk_addr1", chk_addr1);
    sheetObjects[1].SetCellValue(1, "chk_addr2", chk_addr2);
    sheetObjects[1].SetCellValue(1, "chk_addr3", chk_addr3);
    sheetObjects[1].SetCellValue(1, "chk_cty_nm", chk_cty_nm);
    sheetObjects[1].SetCellValue(1, "chk_ste_cd", chk_ste_cd);
    sheetObjects[1].SetCellValue(1, "chk_zip_cd", chk_zip_cd);
    sheetObjects[1].SetCellValue(1, "chk_cnt_cd", chk_cnt_cd);
    /*
    var tml_inv_sts_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'tml_inv_sts_cd');
    var tml_inv_rjct_sts_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'tml_inv_rjct_sts_cd');
    var if_flg=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),'if_flg');
    		if (sheetObjects[0].RowCount()> 0){
    			if ( if_flg!=undefined && if_flg!=null && if_flg!='' &&
    				!((tml_inv_sts_cd!=null && tml_inv_sts_cd=='A') && (tml_inv_rjct_sts_cd!=null && tml_inv_rjct_sts_cd=='RJ')) ) 
    			{
    				v_apro_step=sheetObjects[2].GetEtcData("apro_step");
    			}
    		}
    */
    sheetObjects[1].SetCellValue(1, "apro_step", v_apro_step);
    window.open('ESD_TES_0080.do?previewFlg=' + previewFlg, 'nonpop', 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');
}

/**
 * handling process for input validation
 * @param {ibsheet} sheetObj	ibsheet object
 * @param {form} 	formObj		form object
 * @param {String}	sAction		action value
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //            if (!isNumber(iPage)) {
        //
        //                return false;
        //            }
    }
    return true;
}

/** 
 * validate Date
 * 
 * @param {object} obj object	
 * @return
 */
function validateDateObj(obj) {
    if (obj.readOnly == true) {
        return false;
    }
    obj.value = obj.value.trim();
    if (obj.value == null || obj.value.trim() == '') {
        return false;
    }
    if (!checkPeriodFormat(obj.value) || !tes_isValidDateObject(obj.value, '-')) {
        ComShowMessage(ComGetMsg('TES23011'));
        obj.focus();
        return false;
    }
    var formObj = document.form;
    if (formObj.fm_eff_dt.value != null && formObj.fm_eff_dt.value.trim() != '' &&
        formObj.to_eff_dt.value != null && formObj.to_eff_dt.value.trim() != '' &&
        !isValFmTo(formObj.fm_eff_dt.value, formObj.to_eff_dt.value)) {
        ComShowMessage(ComGetMsg('TES24012'));
        return false;
    }
    return true;
}

/**
 * validate check date format
 * 
 * @param {String} fmDt
 * @param {String} toDt
 * @return
 */
function isValFmTo(fmDt, toDt) {
    if (fmDt == undefined || fmDt == null || fmDt.trim() == '' || toDt == undefined || toDt == null || toDt.trim() == '') {
        return false;
    }
    var str_fmDt = fmDt.replace(/-/gi, '');
    var str_toDt = toDt.replace(/-/gi, '');
    if (isNaN(str_fmDt) || isNaN(str_toDt) || str_fmDt.trim().length != 8 || str_toDt.trim().length != 8) {
        return false;
    }
    if (parseInt(str_toDt, 10) - parseInt(str_fmDt, 10) <= 0) {
        return false;
    }
    return true;
}

/**
 * validate check date format
 * 
 * @param {String} prd_dt
 * @return
 */
function checkPeriodFormat(prd_dt) {
    var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
    if (!tes_checkFormat2(prd_dt, date_regexp)) {
        return false;
    } else {
        return true;
    }
}