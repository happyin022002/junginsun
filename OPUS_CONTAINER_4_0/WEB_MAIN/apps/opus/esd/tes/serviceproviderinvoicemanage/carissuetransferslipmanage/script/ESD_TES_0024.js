/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0024.js
*@FileTitle  : Terminal invoice CSR Creation - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;
var comboObjects = new Array();
var comboCnt = 0;
var approvalFlg = "";
var asaNoCurrCodeArr = "";
var asaNoCurrCode = "";
var edi_inv_yn = false;
var tmp_pre_curr_cd = "";
var myWin;
var parmObj = new Array();

/* Event handler processing by button click event */
document.onclick = processButtonClick;
var time_out = false;

/* Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_EDIinvoiceview":
                var url_str = 'ESD_TES_1002Popup.screen';
                url_str += '?tml_so_ofc_cty_cd=' + sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'tml_so_ofc_cty_cd');
                url_str += '&tml_so_seq=' + sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'tml_so_seq');
                url_str += '&vndr_seq=' + document.form.vndr_seq.value;
                url_str += '&inv_no=' + sheetObject.GetCellValue(sheetObject.GetSelectRow(), 'inv_no');
                ComOpenWindow(url_str, window, "dialogWidth:1100px; dialogHeight:1100px; help:no; status:no; resizable:yes;", true);
                break;

            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;

            case "btn_new":
                sheetObject.RemoveAll();
                formObject.reset();
                break;

            case "btng_detail":
                ComShowMessage("btng_detail button Click!!");
                break;

            case "btns_calendar1":
                var cal = new ComCalendar();
                cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
                break;

            case "btng_search":
                //var v_ofc_cd = formObject.cost_ofc_cd.value;
                //						var v_ofc_cd = formObject.ofc_cd.value; 
                //						var v_sub_sys_cd = "TES";              
                //						var v_apro_step = document.form.apro_step.value;
                //						var param = "?mode=set&ofc_cd="+v_ofc_cd+"&sub_sys_cd="+v_sub_sys_cd+"&apro_step="+encodeURIComponent(v_apro_step)+"&target_obj_nm=apro_step&classId=COM_ENS_0T1";                  
                //						ComOpenPopup('/opuscntr/COM_ENS_0T1.do' + param, 835, 550, '', 'none', true);		
                ComShowCodeMessage("COM12111");
                break;

            case "btns_calendar2":
                var cal = new ComCalendar();
                cal.select(formObject.pm_due_dt, 'pm_due_dt', 'yyyy-MM-dd');
                break;

            case "btng_evidence":
                if (formObject.asanogb.value != undefined && formObject.asanogb.value != null && formObject.asanogb.value == "ASA") {
                    if (comboObjects[0].GetSelectCode() == undefined || comboObjects[0].GetSelectCode() == null || comboObjects[0].GetSelectCode() == '') {
                        ComShowMessage(ComGetMsg('TES40025', 'ASA No.'));
                        return false;
                    }
                }
                if (sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined) {
                    ComShowMessage(ComGetMsg('TES25001'));
                    return false;
                }
                //if(document.form.eviInputFlg.value!="Y"){
                if (approvalFlg == "") {
                    if (formObject.evi_gb.value == "1") {
                        //noRtnPopup('ESD_TES_0078.do', 'width=775,height=580,menubar=0,status=0,scrollbars=0,resizable=0');  
                        // ComOpenWindow("ESD_TES_0078.do",  window,  "dialogWidth:"+810+"px; dialogHeight:"+610+"px; help:no; status:no; resizable:no;" , true);
                        ComOpenWindow("ESD_TES_0078.do", window, "help:no;status:no;resizable:no;dialogWidth:810px;dialogHeight:650px", true);
                    } else if (formObject.evi_gb.value == "2") {
                        //noRtnPopup('ESD_TES_0079.do', 'width=775,height=535,menubar=0,status=0,scrollbars=0,resizable=0');   
                        // ComOpenWindow("ESD_TES_0079.do",  window,  "dialogWidth:820px; dialogHeight:590px; help:no; status:no; resizable:no;" , true);
                        ComOpenWindow("ESD_TES_0079.do", window, "help:no;status:no;resizable:no;dialogWidth:820px;dialogHeight:620px", true);
                    } else if (formObject.evi_gb.value == "3") {
                        ComShowMessage(ComGetMsg('TES25019'));
                    } else {
                        ComShowMessage(ComGetMsg('TES25002'));
                    }
                }
                //}else{
                //}
                break;

            case "btng_preview":
                if (formObject.asanogb.value != undefined && formObject.asanogb.value != null && formObject.asanogb.value == "ASA") {
                    if (comboObjects[0].GetSelectCode() == undefined || comboObjects[0].GetSelectCode() == null || comboObjects[0].GetSelectCode() == '') {
                        ComShowMessage(ComGetMsg('TES40025', 'ASA No.'));
                        return false;
                    }
                }
                /*
                if (formObject.iss_dt.value!=null && formObject.iss_dt.value.trim()!='' && 
                	formObject.payment_due_dt.value!=null && formObject.payment_due_dt.value.trim()!='' && 
                	!isValIssDueDt()){
                	ComShowMessage('Issue date must be earlier than payment due date.');
                	return false;
                }
                */
                if (approvalFlg == "") {
                    if (sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined) {
                        ComShowMessage(ComGetMsg('TES25001'));
                        return false;
                    }
                    //if(formObject.asanogb.value=="A/P" && formObject.cnt_cd.value=="KR"){
                    //								if(cnt_cd == "KR"){
                    //										if(formObject.evi_gb.value == ""){
                    //												ComShowMessage(ComGetMsg('TES25002'));
                    //												return false; 
                    //										}else{
                    //												if(formObject.evi_gb.value!="3"){
                    //														if(document.form.eviInputFlg.value == "" && document.form.s_eviInputFlg.value == ""){
                    //																ComShowMessage(ComGetMsg('TES25003'));
                    //																return false; 
                    //														}
                    //												}					
                    //										}
                    //								} 

                    var csr_amt = 0;
                    for (var i = 0; i < sheetObject.RowCount(); i++) {
                        if (sheetObject.GetCellValue(i + 1, 1) == 1) {
                            csr_amt = parseFloat(sheetObject.GetCellValue(i + 1, "inv_total_amt") * 100) + parseFloat(csr_amt);
                        }
                    }

                    formObject.csr_amt.value = (csr_amt / 100);
                    sheetObject1.RemoveAll();
                    sheetObject2.RemoveAll();
                    doActionIBSheet1(sheetObject2, formObject, IBSEARCH);
                }
                //noRtnPopup('ESD_TES_0080.do', 'width=775,height=370,menubar=0,status=0,scrollbars=0,resizable=0');  
                break;

            case "btng_print":
                if (formObject.asanogb.value != undefined && formObject.asanogb.value != null && formObject.asanogb.value == "ASA") {
                    if (comboObjects[0].GetSelectCode() == undefined || comboObjects[0].GetSelectCode() == null || comboObjects[0].GetSelectCode() == '') {
                        ComShowMessage(ComGetMsg('TES40025', 'ASA No.'));
                        return false;
                    }
                }
                var fromObj = new Array();
                var rdObj = new Array();

                fromObj[0] = formObject;
                rdObj[0] = sheetObjects[0];
                parmObj[0] = "1";
                parmObj[1] = "";
                parmObj[2] = "N";
                parmObj[3] = RD_path + "apps/opus/esd/tes/serviceproviderinvoicemanage/carissuetransferslipmanage/report/ESD_TES_0024Print.mrd"; // RD 화면
                parmObj[4] = rdObj;
                parmObj[5] = fromObj;
                rdObjModaless(RdReport, parmObj, 1000, 700);
                break;

            case "btng_approvalrequest":
                if (time_out) {
                    return;
                }
                if (formObject.asanogb.value != undefined && formObject.asanogb.value != null && formObject.asanogb.value == "ASA") {
                    if (comboObjects[0].GetSelectCode() == undefined || comboObjects[0].GetSelectCode() == null || comboObjects[0].GetSelectCode() == '') {
                        ComShowMessage(ComGetMsg('TES40025', 'ASA No.'));
                        return false;
                    }
                }
                if (approvalFlg == "") {
                    if (sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined) {
                        ComShowMessage(ComGetMsg('TES25001'));
                        return false;
                    }
                    //								if(cnt_cd=="KR"){
                    //										if(formObject.evi_gb.value == ""){
                    //												ComShowMessage(ComGetMsg('TES25002'));												
                    //												return false; 
                    //										}else{
                    //												if(formObject.evi_gb.value!="3"){
                    //														if(document.form.eviInputFlg.value == "Y" || document.form.s_eviInputFlg.value == "Y"){
                    //														}else{
                    //																ComShowMessage(ComGetMsg('TES25003'));																
                    //																return false; 
                    //														}
                    //												}						
                    //										}
                    //								} 								
                    ComOpenWait(true);
                    var csr_amt = 0;
                    for (var i = 0; i < sheetObject.RowCount(); i++) {
                        if (sheetObject.GetCellValue(i + 1, 1) == 1) {
                            csr_amt = parseFloat(sheetObject.GetCellValue(i + 1, "inv_total_amt") * 100) + parseFloat(csr_amt);
                        }
                    }
                    formObject.csr_amt.value = (csr_amt / 100);
                    eviData();
                    doActionIBSheet1(sheetObject, formObject, IBSAVE);
                    time_out = true;
                    window.setTimeout('chkTimeOut()', 3000);
                    ComOpenWait(false);
                }
                break;

        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(ComGetMsg('TES21025'));
        } else {
            ComShowMessage(e.message);
        }
        time_out = true;
    }
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param {ibsheet} sheet_obj	ibsheet object
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
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }

    //		if(document.form.asanogb.value=="A/P" && cnt_cd=="KR"){			  
    //		  document.all.item("srLayer")[1].style.display="inline";
    //		  document.all.item("srLayer")[0].style.display="none";
    //		  document.all.item("srLayer")[2].style.display="none";		
    //		  document.all.item("btLayer")[1].style.display="inline";
    //		  document.all.item("btLayer")[0].style.display="none";			      						
    //		}else if(document.form.asanogb.value=="ASA" && cnt_cd=="KR"){
    //		  document.all.item("srLayer")[1].style.display="none";
    //		  document.all.item("srLayer")[0].style.display="none";
    //		  document.all.item("srLayer")[2].style.display="inline";	
    //		  document.all.item("btLayer")[1].style.display="inline";
    //		  document.all.item("btLayer")[0].style.display="none";			      							
    //		}else
    if (document.form.asanogb.value == "ASA") {
        document.all.item("srLayer")[0].style.display = "inline";
        document.all.item("srLayer")[1].style.display = "none";
        document.all.item("srLayer")[2].style.display = "none";
        document.all.item("btLayer")[0].style.display = "inline";
        document.all.item("btLayer")[1].style.display = "none";

    } else if (document.form.asanogb.value == "A/P") {
        document.all.item("srLayer")[0].style.display = "none";
        document.all.item("srLayer")[1].style.display = "none";
        document.all.item("srLayer")[2].style.display = "none";

        document.all.item("btLayer")[0].style.display = "inline";
        document.all.item("btLayer")[1].style.display = "none";

    }
    for (p = 0; p < comboObjects.length; p++) {
        initCombo(comboObjects[p], p + 1, '');
    }
    ComEnableObject(document.form.cost_ofc_cd, false);
    //disableObject(document.form.inv_cfm_dt, false); 
    ComEnableObject(document.form.vndr_seq, false);
    ComEnableObject(document.form.vndr_seq_name, false);
    ComEnableObject(document.form.cnt_inv, false);
    ComEnableObject(document.form.curr_cd, false);
    ComEnableObject(document.form.total_amt, false);
    ComEnableObject(document.form.max_iss_dt, false);
    ComEnableObject(document.form.max_rcv_dt, false);
    ComEnableObject(document.form.gen_pay_term_desc, false);
    ComEnableObject(document.form.csr_no, false);
    var tmp_gen_pay_term_cd = document.form.gen_pay_term_cd.value;
    if (tmp_gen_pay_term_cd != null && tmp_gen_pay_term_cd.trim() != '' && tmp_gen_pay_term_cd.substring(0, 1) == 'O') {
        ComEnableObject(document.form.payment_due_dt, false);
    }
    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * setting sheet initial values and header
 * adding case as numbers of counting sheets
 * @param {ibsheet} sheetObj 	==> , 
 * @param {int} 	sheetNo 	==>  
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
				var HeadTitle="SEQ||Invoice No.|Net Amount|Tax Amount|W.H.T|Total Amount|Issue Date|Receive Date|Confirm Date" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"inv_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:0,   SaveName:"ttl_inv_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vat_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"whld_tax_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_total_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"iss_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_cfm_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"tml_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"tml_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Status",    Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"ibflag",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							{Type:"Text",      Hidden:1, Width:1,    Align:"Right",   ColMerge:0,   SaveName:"edi_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				
				//SetEditable(1);
				SetWaitImageVisible(0);
				SetSavingImage("");
				SetSheetHeight(ComGetSheetHeight(sheetObj, 13));
			}
		break;
		
		case 2:      //sheet1 init
			with(sheetObj){
				var HeadTitle="csr no|office|prpd by|pay to|csr type|desc|pay group|evi tp|due date|asa no|inv dt|currcd|amt|pay_curr_cd|pay_amt|apro_step|title|chk_addr1|chk_addr2|chk_addr3|chk_cty_nm|chk_ste_cd|chk_zip_cd|chk_cnt_cd" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
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
				SetSheetHeight(ComGetSheetHeight(sheetObj, 13));
			}
		break; 
		
		case 3:      //sheet1 init
			with(sheetObj){
				var HeadTitle="char of account|account name|gl date|city|inv no|desc|debit|credit|total amt" ;
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
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
				SetSheetHeight(ComGetSheetHeight(sheetObj, 13));
			}
		break;                                
	}    
}

/**
 * handling sheet process
 * 
 * @param {ibsheet} sheetObj 	
 * @param {form}	formObj	
 * @param {String}	sAction
 */
function doActionIBSheet(sheetObj, formObj, sAction) { //alert("start doActionIBSheet() sAction"+sAction);     		
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve				
            formObj.f_cmd.value = SEARCHLIST01;
            //sheetObj.DoSearch("ESD_TES_0024GS.do", tesFrmQryStr(formObj) );
            var sXml = sheetObj.DoSearch("ESD_TES_0024GS.do", tesFrmQryStr(formObj));
            for (var i = 0; sXml != null && i < sXml.length; i++) {
                sheetObjects[i].LoadSearchData(arrXml[i], { Sync: 1 });
            }
            break;
            
        case IBCOPYROW:
            sheetObj.DataCopy();
            break;
    }
}

/**
 * handling sheet process
 * 
 * @param {ibsheet} sheetObj 	
 * @param {form}	formObj
 * @param {String}	sAction
 */
function doActionIBSheet1(sheetObj, formObj, sAction) { //alert("start doActionIBSheet1");
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH01;
            var param = sheetObjects[0].GetSaveString(false, true, 1);
            var sXml = sheetObjects[2].GetSearchData("ESD_TES_0024PreView.do", param + '&' + tesFrmQryStr(formObj), "", true);
            sheetObjects[2].LoadSearchData(sXml, { Sync: 1 });
            sXml = null;
            break;
            
        case IBSAVE: //Retrieve
            var sRow = sheetObj.FindCheckedRow(1);
            var arrRow = sRow.split("|");
            formObj.inv_knt.value = arrRow.length;
            formObj.f_cmd.value = MULTI01;
            formObj.pay_due_dt.value = formObj.payment_due_dt.value;
            var param = sheetObjects[0].GetSaveString(false, true, 1);

            var sXml = sheetObjects[0].GetSearchData("ESD_TES_0024GS.do", param + '&' + tesFrmQryStr(formObj), "", true);
            sheetObjects[0].LoadSaveData(sXml);
            break;
    }
}

/**
 * MInimize click event
 * @param {String} nItem	
 */
function Minimize(nItem) {
    var objs = document.all.item("showMin");
    if (nItem == "1") {
        objs.style.display = "none";
        SetSheetHeight(ComGetSheetHeight(sheetObjects[0], 20));
        sheetObjects[0].focus();
        //no support[check again]CLT 						sheetObjects[0].ViewRows=20; 
    } else {
        objs.style.display = "inline";
        SetSheetHeight(ComGetSheetHeight(sheetObjects[0], 10));
        sheetObjects[0].focus();
        //no support[check again]CLT 						sheetObjects[0].ViewRows=10;
    }
}

/**
 * check Number
 * 
 * @param {Object} obj		object	
 * @return
 */
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/**
 * check Number 
 * 
 * @param {Object} obj		object
 * @return
 */
function isNum1(obj) {
    if (!ComIsNumber(obj, "-")) {
        obj.value = '';
    }
}

/** check date
 * 
 * @param {Object} obj		object
 * @return
 */
function isDate1(obj) {
    if (!ComIsDate(obj)) {
        obj.value = '';
    }
}

/** 
 * 
 * @param {ibSheet}		sheetObj		ibsheet object
 * @param {int}			row				sheet date row값
 * @param {int}			col				sheet date col값
 * @param {String}		value			sheet 값
 * @return
 */
function sheet1_OnChange(sheetObj, row, col, value) { //alert("start sheet1_OnChange");
    var sName = sheetObj.ColSaveName(col);
    if (sName == "chk") {
        resetEviData();
    }
    var chkRow = sheetObj.FindCheckedRow(1);
    var arrRow = chkRow.split("|");
    var chkRowCount = 0;
    var maxIss = 0;
    var maxRcv = 0;
    var total_amt = 0;
    var vat_amt = 0;

    if (arrRow.length >= 1) {
        for (idx = 0; idx < arrRow.length; idx++) {
            if (maxIss < sheetObj.GetCellValue(arrRow[idx], "iss_dt")) {
                maxIss = sheetObj.GetCellValue(arrRow[idx], "iss_dt")
            }
            if (maxRcv < sheetObj.GetCellValue(arrRow[idx], "rcv_dt")) {
                maxRcv = sheetObj.GetCellValue(arrRow[idx], "rcv_dt")
            }

            total_amt = parseFloat(sheetObj.GetCellValue(arrRow[idx], "inv_total_amt") * 100) + parseFloat(total_amt) * 100;
            vat_amt = parseFloat(sheetObj.GetCellValue(arrRow[idx], "vat_amt") * 100) + parseFloat(vat_amt) * 100;
            total_amt = total_amt / 100;
            vat_amt = vat_amt / 100;
            chkRowCount++;
        }
    }
    if (maxIss == "0") maxIss = "";
    if (maxRcv == "0") maxRcv = "";
    if (chkRowCount == "0") chkRowCount = "";

    document.form.max_iss_dt.value = maxIss;
    document.form.max_rcv_dt.value = maxRcv;
    document.form.total_amt.value = total_amt;

    ComChkObjValid(document.form.max_iss_dt);
    ComChkObjValid(document.form.max_rcv_dt);
    document.form.cnt_inv.value = chkRowCount;

    if (document.form.total_amt.value >= 0) {
        document.form.csr_tp_cd.value = "S"
    } else {
        document.form.csr_tp_cd.value = "C"
    }

    if (maxIss != "" && ComIsNumber(document.form.gen_pay_term_cd)) {
        document.form.payment_due_dt.value = ComGetDateAdd(maxIss, "D", parseInt(document.form.gen_pay_term_cd.value));
    } else {
        document.form.payment_due_dt.value = "";
        /*
        var tmp_gen_term_cd_val=document.form.gen_pay_term_cd.value.substring(1,3);
        if (!isNaN(tmp_gen_term_cd_val)){
        	document.form.payment_due_dt.value=getAddDate(maxIss, parseInt(tmp_gen_term_cd_val));
        }
        */
    }
    //		alert("document.form.asanogb.value =======>"+document.form.asanogb.value);
    if (document.form.asanogb.value == "A/P" && cnt_cd == "KR") {
        if (vat_amt > 0) {
            document.form.evi_gb1.options[0].selected = true;
            ComEnableObject(document.form.evi_gb1, false);
            eviGbSelect(1);
        } else {
            document.form.evi_gb1.options[0].selected = true;
            ComEnableObject(document.form.evi_gb1, true);
            eviGbSelect(1);
        }
    } else if (document.form.asanogb.value == "ASA" && cnt_cd == "KR") {
        if (vat_amt > 0) {
            document.form.evi_gb2.options[0].selected = true;
            ComEnableObject(document.form.evi_gb2, false);
            eviGbSelect(2);
        } else {
            document.form.evi_gb2.options[0].selected = true;
            ComEnableObject(document.form.evi_gb2, true);
            eviGbSelect(2);
        }
    }
}

/**
 * 
 * @param {ibSheet}	sheetObj		ibsheet object
 * @param {String} 	ErrMsg			err message
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, errMsg) { //alert("start sheet1_OnSaveEnd");
    if (errMsg != "") return false;
    var csr_no = sheetObj.GetEtcData("csrNo");
    document.form.csr_no.value = csr_no;
    sheetObj.RemoveEtcData();
    var chkRow = sheetObj.FindCheckedRow("chk");
    var arrRow = chkRow.split("|");
    for (idx = 0; idx < arrRow.length; idx++) {
        sheetObj.SetCellEditable(arrRow[idx], "chk", 0);
        sheetObj.SetCellValue(arrRow[idx], "chk", 0, 0);
    }
    var previewFlg = "";
    if (tmp_pre_curr_cd == "KRW" || tmp_pre_curr_cd == "JPY") {
        previewFlg = "krjp";
    }
    deleteCheck();
    //        ComShowMessage(ComGetMsg('TES25021'));  
    //document.form.eviInputFlg.value = '';
    resetEviData();

    if (myWin != null && myWin != undefined) {
        if (!myWin.closed) {
            sheetObjects[1].SetCellValue(1, "pre_csr_no", csr_no);
            //var apro_step_arr=document.form.apro_step.value.split("-");                    
            //                    sheetObjects[1].CellValue(1,"apro_step") = apro_step_arr[0];
            myWin = null;
            //sheetObjects[0].RemoveAll();
            if (errMsg == null || errMsg == '') {
                //						noRtnPopup('ESD_TES_0080.do?previewFlg='+previewFlg+'&previewFlgYN=Y', 'width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0'); 
                myWin = ComOpenWindow("ESD_TES_0080.do", "noRtnPopup", "width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0", false);
            }
        }
    } else {
        //sheetObjects[0].RemoveAll();
        //deleteCheck();
        ComShowMessage(ComGetMsg('TES25021'));
    }
}

/**
 * sheet3 search end event
 * 
 * @param {ibsheet}	sheetObj	IBsheet object
 * @param {String}	errMsg		err message
 * @return
 */
function sheet3_OnSearchEnd(sheetObj, code, errMsg) { //alert("start sheet3_OnSearchEnd");
    var srcName = ComGetEvent("name");
    var previewFlg = "";

    var pre_csr_no = sheetObj.GetEtcData("pre_csr_no");
    var pre_office = sheetObj.GetEtcData("pre_office");
    var pre_prpd_dy = sheetObj.GetEtcData("pre_prpd_dy");
    var pre_pay_to = sheetObj.GetEtcData("pre_pay_to");
    var pre_csr_type = sheetObj.GetEtcData("pre_csr_type");
    var pre_desc = sheetObj.GetEtcData("pre_desc");
    var pre_pay_group = sheetObj.GetEtcData("pre_pay_group");
    var pre_evi_tp = sheetObj.GetEtcData("pre_evi_tp");
    var pre_due_date = sheetObj.GetEtcData("pre_due_date");
    if (document.form.asa_no.value != "" || comboObjects[0].GetSelectCode() != "") {
        var pre_asa_no = comboObjects[0].GetSelectCode();
    } else {
        var pre_asa_no = sheetObj.GetEtcData("pre_asa_no");
    }
    var pre_inv_dt = sheetObj.GetEtcData("pre_inv_dt");
    var pre_curr_cd = sheetObj.GetEtcData("pre_curr_cd");
    var pre_amt = sheetObj.GetEtcData("pre_amt");
    var pre_pay_amt = sheetObj.GetEtcData("pre_pay_amt");
    var chk_addr1 = sheetObj.GetEtcData("chk_addr1");
    var chk_addr2 = sheetObj.GetEtcData("chk_addr2");
    var chk_addr3 = sheetObj.GetEtcData("chk_addr3");
    var chk_cty_nm = sheetObj.GetEtcData("chk_cty_nm");
    var chk_ste_cd = sheetObj.GetEtcData("chk_ste_cd");
    var chk_zip_cd = sheetObj.GetEtcData("chk_zip_cd");
    var chk_cnt_cd = sheetObj.GetEtcData("chk_cnt_cd");
    var pre_evi_tp_count = "";
    var pre_title = "";
    pre_due_date = document.form.payment_due_dt.value;
    if (pre_amt == 0 || comboObjects[0].GetSelectCode() != "") {
        pre_title = "TRANSFER SLIP";
    } else {
        pre_title = "CONSULTATION SLIP";
    }
    var pre_evi_tp
        //		if(cnt_cd =="KR"){
        //				pre_evi_tp_count="1";
        //				pre_evi_tp=pre_evi_tp;						
        //		}else{
    var sRow = sheetObjects[0].FindCheckedRow(1);
    var arrRow = sRow.split("|");
    pre_evi_tp_count = arrRow.length;
    pre_evi_tp = pre_evi_tp + "/" + pre_evi_tp_count;
    //		}	
    if (cnt_cd == "KR" || cnt_cd == "JP" || pre_curr_cd == "KRW" || pre_curr_cd == "JPY") {
        pre_amt     = pre_amt;
        pre_pay_amt = pre_pay_amt;
    } else {
        pre_amt     = tes_chkAmtFmt(pre_amt);
        pre_pay_amt = tes_chkAmtFmt(pre_pay_amt);
    }
    tmp_pre_curr_cd = pre_curr_cd;
    if (pre_curr_cd == "KRW" || pre_curr_cd == "JPY") {
        previewFlg = "krjp";
    }
    sheetObjects[1].RemoveAll();
    sheetObjects[1].DataInsert(-1);
    if (srcName == "btng_preview") {
        pre_csr_no = "";
    }
    sheetObjects[1].SetCellValue(1, "pre_csr_no", pre_csr_no);
    sheetObjects[1].SetCellValue(1, "pre_office", document.form.cost_ofc_cd.value);
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
    /**
        for(var i=0;i<sheetObjects[2].Rowcount;i++){
		sheetObjects[2].SetCellValue(i+1,"pre_debit",tes_chkAmtFmt(sheetObjects[2].GetCellValue(i+1,"pre_debit")));
		sheetObjects[2].SetCellValue(i+1,"pre_credit",tes_chkAmtFmt(sheetObjects[2].GetCellValue(i+1,"pre_credit")));
        }      
        **/
    if (errMsg == null || errMsg.trim() == '') {
        //			noRtnPopup('ESD_TES_0080.do?previewFlg='+previewFlg+'&previewFlgYN=Y','width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');
        myWin = ComOpenWindow("ESD_TES_0080.do?previewFlg=" + previewFlg + '&previewFlgYN=Y', "noRtnPopup", "width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0", false);
        //			window.open('ESD_TES_0080.do?previewFlg='+previewFlg+'&previewFlgYN=Y','myWin','width=775,height=700,menubar=0,status=0,scrollbars=0,resizable=0');            
    }
}

/**
 * sheet1 search end event
 * 
 * @param {ibsheet}	sheetObj	IBsheet object
 * @param {String}	errMsg		err message
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) { //alert("start sheet1_OnSearchEnd");
    var asaNoString = sheetObj.GetEtcData("asaNoString");
    var csrNo = sheetObj.GetEtcData("csrNo");
    var apOfcCd = sheetObj.GetEtcData("apOfcCd");
    asaNoCurrCodeArr = sheetObj.GetEtcData("asaCurrCdstring").split("|");
    document.form.csr_no.value = csrNo;
    document.form.ap_ofc_cd.value = apOfcCd;
    for (p = 0; p < comboObjects.length; p++) {
        initCombo(comboObjects[p], p + 1, asaNoString);
    }
    sheetObj.SelectCell(sheetObj.GetSelectRow(), sheetObj.GetSelectCol());
    for (var i = 1; i <= sheetObj.RowCount(); i++) {
        if (sheetObj.GetCellValue(i, 'edi_flg')) {
            edi_inv_yn = true;
        }
    }
    if (edi_inv_yn) {
        document.all.EDILayer01.style.display = "inline";
    } else {
        document.all.EDILayer01.style.display = "none";
    }
}

/**
 * set Combo list
 * @param {comoObj}	comboObj		combo Object
 * @param {int}		comboNo 		combo no
 * @param {String}	asaNoString 	asa number value
 */
function initCombo(comboObj, comboNo, asaNoString) {
    var cnt = 0;
    var asaNoArray = asaNoString.split("|");
    switch (comboNo) {
        case 1:
            comboObj.RemoveAll();
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "106");
                InsertItem(cnt++, '', '');
                for (i = 0; i < asaNoArray.length; i++) {
                    InsertItem(cnt++, asaNoArray[i], asaNoArray[i]);
                }
            }
            break;
    }
}

/**
 * setComboObject
 * @param {combo object} combo_obj	combo object
 * @return
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * 
 * @param {combo object} 	comObj	combo object
 * @param {int} 			index	
 * @param {String} 			text	
 * @return
 */
function asa_no_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    asaNoCurrCode = "";
    asa_no.value = comboObj.GetSelectCode();
    asaNoCurrCode = asaNoCurrCodeArr[comboObj.index - 1];
}

/**
 *  approvalrequest
 */
function approvalrequest() { //alert("start approvalrequest");     		
    var sheetObject = sheetObjects[0];
    var formObject = document.form;

    if (sheetObject.FindCheckedRow(1) == "" || sheetObject.FindCheckedRow(1) == null || sheetObject.FindCheckedRow(1) == undefined) {
        ComShowMessage(ComGetMsg('TES25001'));
        return false;
    }
    //if(formObject.asanogb.value=="A/P" && formObject.cnt_cd.value=="KR"){
    //if(formObject.asanogb.value=="A/P"){
    //				if(cnt_cd=="KR"){
    //						if(formObject.evi_gb.value == ""){
    //								ComShowMessage(ComGetMsg('TES25002'));								
    //								return false; 
    //						}else{
    //								if(formObject.evi_gb.value!="3"){
    //										if(document.form.eviInputFlg.value == "" && document.form.s_eviInputFlg.value == ""){
    //												ComShowMessage(ComGetMsg('TES25003'));												
    //												return false; 
    //										}
    //								}						
    //						}
    //				} 								
    ComOpenWait(true);
    var csr_amt = 0;
    for (var i = 0; i < sheetObject.RowCount(); i++) {
        if (sheetObject.GetCellValue(i + 1, 1) == 1) {
            csr_amt = parseFloat(sheetObject.GetCellValue(i + 1, "inv_total_amt") * 100) + parseFloat(csr_amt);
        }
    }
    formObject.csr_amt.value = (csr_amt / 100);
    eviData();
    doActionIBSheet1(sheetObject, formObject, IBSAVE);
    ComOpenWait(false);

}

/**
 * 
 * @param {int}	evi_gb
 * @return
 */
function eviGbSelect(evi_gb) { //alert("start eviGbSelect");
    if (evi_gb == 1) {
        document.form.evi_gb.value = document.form.evi_gb1.value;
    } else if (evi_gb == 2) {
        document.form.evi_gb.value = document.form.evi_gb2.value;
    }
    /**
	 		if(document.form.evi_ctnt1.value!="" && evi_gb ==1){
	 			var gb=confirm("증빙구분을 변경하면 이미 저장되어 있는 정보가 삭제 됩니다.\n\n증빙구분을 변경하시겠습니까?");
	 		}
	 		if(gb){
					document.form.tax_naid_flg.value="";
					document.form.finance_flg.value="";
					document.form.fa_flg.value="";
					document.form.tax_type.value="";
					document.form.tax_nsl_flg.value="";
					document.form.evi_inv_dt.value="";
					document.form.evi_comp_no.value="";
					document.form.evi_total_net_amt.value="";
					document.form.evi_tax_no2.value="";
					document.form.evi_total_tax_amt.value="";
					document.form.evi_ctnt1.value="";
					document.form.evi_ctnt2.value="";
					document.form.evi_ctnt3.value="";
					document.form.evi_ctnt4.value="";
					document.form.evi_ctnt5.value="";
					document.form.evi_ctnt6.value="";
					document.form.evi_ctnt7.value="";
					document.form.evi_ctnt8.value="";
					document.form.evi_ctnt9.value="";
					document.form.evi_ctnt10.value="";
					document.form.evi_ctnt11.value="";
					document.form.evi_ctnt12.value="";
					document.form.evi_tax_no.value="";
					document.form.evi_tax_code.value="";
			}else{					 
					return false;
			}	
			**/
}

/**
 * set evi data
 * 
 * @return
 */
function eviData() {
    if (document.form.evi_gb.value == 2) {
        document.form.tax_naid_flg.value = document.form.s_tax_naid_flg.value;
        document.form.finance_flg.value = document.form.s_finance_flg.value;
        document.form.fa_flg.value = document.form.s_fa_flg.value;
        document.form.tax_type.value = document.form.s_tax_type.value;
        document.form.tax_nsl_flg.value = document.form.s_tax_nsl_flg.value;
        document.form.evi_inv_dt.value = document.form.s_evi_inv_dt.value;
        document.form.evi_comp_no.value = document.form.s_evi_comp_no.value;
        document.form.evi_total_net_amt.value = document.form.s_evi_total_net_amt.value;
        document.form.evi_tax_no2.value = document.form.s_evi_tax_no2.value;
        document.form.evi_total_tax_amt.value = document.form.s_evi_total_tax_amt.value;
        document.form.evi_ctnt1.value = document.form.s_evi_ctnt1.value;
        document.form.evi_ctnt2.value = document.form.s_evi_ctnt2.value;
        document.form.evi_ctnt3.value = document.form.s_evi_ctnt3.value;
        document.form.evi_ctnt4.value = document.form.s_evi_ctnt4.value;
        document.form.evi_ctnt5.value = document.form.s_evi_ctnt5.value;
        document.form.evi_ctnt6.value = document.form.s_evi_ctnt6.value;
        document.form.evi_ctnt7.value = document.form.s_evi_ctnt7.value;
        document.form.evi_ctnt8.value = document.form.s_evi_ctnt8.value;
        document.form.evi_ctnt9.value = document.form.s_evi_ctnt9.value;
        document.form.evi_ctnt10.value = document.form.s_evi_ctnt10.value;
        document.form.evi_ctnt11.value = document.form.s_evi_ctnt11.value;
        document.form.evi_ctnt12.value = document.form.s_evi_ctnt12.value;
        document.form.evi_tax_no.value = document.form.s_evi_tax_no.value;
        document.form.evi_tax_code.value = document.form.s_evi_tax_code.value;
    }
}

/**
 * reset evi data
 * 
 * @return
 */
function resetEviData() { //alert("start resetEviData");
    document.form.eviInputFlg.value = '';
    document.form.tax_naid_flg.value = '';
    document.form.finance_flg.value = '';
    document.form.fa_flg.value = '';
    document.form.tax_type.value = '';
    document.form.tax_nsl_flg.value = '';
    document.form.s_tax_naid_flg.value = '';
    document.form.s_finance_flg.value = '';
    document.form.s_fa_flg.value = '';
    document.form.s_tax_type.value = '';
    document.form.s_tax_nsl_flg.value = '';
    for (var i = 0; i < document.form.elements.length; i++) {
        try {
            if ((document.form.elements[i].name.length >= 4 && document.form.elements[i].name.substring(0, 4) == 'evi_') ||
                (document.form.elements[i].name.length >= 6 && document.form.elements[i].name.substring(0, 6) == 's_evi_')) {
                document.form.elements[i].value = '';
            }
        } catch (e) {
            ComShowMessage(e.message);
        }
    }
    document.form.attr_ctnt8.value = '';

}

/**
 * check delete
 *  
 * @return
 */
function deleteCheck() { //alert("start deleteCheck");
    var k = 0;
    for (var i = 0; i < sheetObjects[0].RowCount(); i++) {
        if (sheetObjects[0].GetCellValue(i + 1, 1) == 1) {
            sheetObjects[0].RowDelete(i + 1, false);
            k++;
            i = i - k;
        }
    }
    if (sheetObjects[0].RowCount() == 0) {
        approvalFlg = "Y";
    }
}

/*
 *  rtnObjPopup(Url, Option);
 *  noRtnPopup("test.popup.PopTest1.do", "width=310,height=350,menubar=0,status=0,scrollbars=0,resizable=0");
 * @param String code
 *  :
 */
function noRtnPopup(myUrl, myOption) {
    myWin = window.open(myUrl, "noRtnPopup", myOption);
    //myWin.moveTo(0,0);
    myWin.focus();
}

function chkTimeOut() {
    time_out = false;
}

/** 
 * check date format
 * 
 * @param	{object} obj
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
    return true;
}

/**
 * check date format 2
 * 
 * @param {object} obj
 * @return
 */
function validateDateObj2(obj) { //alert("start validateDateObj2");
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
    if (formObj.max_iss_dt.value != null && formObj.max_iss_dt.value.trim() != '' &&
        formObj.payment_due_dt.value != null && formObj.payment_due_dt.value.trim() != '') {
        if (ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value) < 0) {
            formObj.payment_due_dt.value = formObj.max_iss_dt.value;
        }
        if (ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value) > 100) {
            formObj.payment_due_dt.value = ComGetDateAdd(formObj.max_iss_dt.value, "D", 100);
        }
        formObj.gen_pay_term_cd.value = ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
        formObj.gen_pay_term_desc.value = ComGetDaysBetween(formObj.max_iss_dt.value, formObj.payment_due_dt.value);
    }
    /*
    		if (formObj.max_iss_dt.value!=null && formObj.max_iss_dt.value.trim()!='' && 
    			formObj.payment_due_dt.value!=null && formObj.payment_due_dt.value.trim()!='' && 
    			!isValIssDueDt()){
    			ComShowMessage('Issue date must be earlier than payment due date.');
    			return false;
    		}
    */
    return true;
}

/**
 * validation check issu date
 * 
 * @return
 */
function isValIssDueDt() {
    var str_issDt = document.form.max_iss_dt.value.replace(/-/gi, '');
    var str_dueDt = document.form.payment_due_dt.value.replace(/-/gi, '');
    if (isNaN(str_issDt) || isNaN(str_dueDt) || str_issDt.trim().length != 8 || str_dueDt.trim().length != 8) {
        return false;
    }
    if (parseInt(str_issDt, 10) - parseInt(str_dueDt, 10) > 0) {
        return false;
    }
    return true;
}

/**
 * check date format
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