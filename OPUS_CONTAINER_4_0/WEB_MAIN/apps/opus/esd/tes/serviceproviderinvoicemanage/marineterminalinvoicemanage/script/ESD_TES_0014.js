/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0014.js
*@FileTitle : Marine Terminal Invoice
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/05/27
=========================================================*/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var node;
var comboObjects = new Array();
var comboCnt = 0;

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** using extra sheet valuable if there are more 2 sheets *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        switch (srcName) {
            case "btn_retrieve":
                if (document.form.inv_date_type.value == undefined || document.form.inv_date_type.value == null || document.form.inv_date_type.value.trim() == '') {
                    ComShowMessage('Please select \'Inv. Date\' type');
                    return false;
                }
                if (!((document.form.loc_cd.value != undefined && document.form.loc_cd.value != null && document.form.loc_cd.value.trim() != '' && document.form.loc_cd.value.trim().length == 5 &&
                            nod_cd.GetSelectCode() != undefined && nod_cd.GetSelectCode() != null && nod_cd.GetSelectCode().trim() != '') ||
                        (document.form.yd_cd.value != undefined && document.form.yd_cd.value != null && document.form.yd_cd.value.trim() != '') ||
                        (document.form.vndr_seq.value != undefined && document.form.vndr_seq.value != null && document.form.vndr_seq.value.trim() != '') ||
                        (document.form.cost_ofc_cd.value != undefined && document.form.cost_ofc_cd.value != null && document.form.cost_ofc_cd.value.trim() != '') ||
                        (document.form.inv_ofc_cd.value != undefined && document.form.inv_ofc_cd.value != null && document.form.inv_ofc_cd.value.trim() != ''))) {
                    ComShowMessage('Please enter one of \'Yard Code\', \'S/P Code\', \'Cost OFC\' or \'INV OFC\'.');
                    return false;
                }
                //if (confirm('pause')){return false;}

                if (formObject.vol_show_mode[0].checked == false) {
                    doActionIBSheet(sheetObject, formObject, IBSEARCH);
                } else {
                    if (formObject.cost_tp[0].checked == true) {
                        formObject.cost_code.value = "";
                        formObject.cntr_sty_code.value = "";
                    } else {
                        
                        //2016.08.09 Modify Start.========================
                        var chkCostTpArr = new Array();
                        $("#cost_tp:checked").each(function(){
                            chkCostTpArr.push($(this).attr("desc"));
                        });
                        
                        formObject.cost_code.value = chkCostTpArr.join("");//구분자 없이 붙여서 보낸다.
                        
                        var chkCntrStyCdArr = new Array();
                        $("#cntr_tp:checked").each(function(){
                            chkCntrStyCdArr.push($(this).attr("desc"));
                        });
                        
                        formObject.cntr_sty_code.value = chkCntrStyCdArr.join("");//구분자 없이 붙여서 보낸다.
                        //2016.08.09 Modify E n d.========================
                        
                        
                        /* 2016.08.09 Modify
                        for (var i = 1; i < 7; i++) {
                            if (formObject.cost_tp[i].checked == true) {
                                formObject.cost_code.value = formObject.cost_code.value + formObject.cost_tp[i].desc;
                            }
                        }
                        for (var j = 0; j < 2; j++) {
                            if (formObject.cntr_tp[j].checked == true) {
                                formObject.cntr_sty_code.value = formObject.cntr_sty_code.value + formObject.cntr_tp[j].desc;
                            }
                        }*/
                    }
                    doActionIBSheet1(sheetObject1, formObject, IBSEARCH);
                }
                break;

            case "btn_new":
                try {
                    tes_removeTESCommonALLIframes();
                } catch (e) {}
                formObject.reset();
                sheetObject.RemoveAll();
                sheetObject1.RemoveAll();

                var rtnVal = getDBDate(); // tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
                if (rtnVal.length > 0) {
                    setPeriodFromTo(rtnVal);
                }

                formObject.vol_show_mode[0].checked = true;
                vol_show_mode_sts();
                break;

            case "btns_calendar1":
                var cal = new ComCalendar();
                cal.select(formObject.fm_prd_dt, 'yyyy-MM-dd');
                break;

            case "btns_calendar2":
                var cal = new ComCalendar();
                cal.select(formObject.to_prd_dt, 'yyyy-MM-dd');
                break;

            case "btn_yard":
                var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
                var classId = "COM_ENS_061";
                var param = '?classId=' + classId;
                var chkStr = dispaly.substring(0, 3)
                    // radio PopUp
                if (chkStr == "1,0") {
                    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 770, 500, 'getYard', dispaly);
                } else {
                    ComShowCodeMessage('TES21906');
                    return;
                }
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

            case "btn_cost_ofc_cd":
                var url_str;
                url_str = 'ESD_TES_9300Pop.screen'
                url_str = url_str + '?ofc_cd=' + (formObject.cost_ofc_cd.value == "" ? ofc_cd : formObject.cost_ofc_cd.value);
                url_str = url_str + '&param_nm=cost_ofc_cd'
                ComOpenWindow(url_str, window, "dialogWidth:425px; dialogHeight:440px; help:no; status:no; resizable:yes;", true);
                break;
                /*
                          	   case "btn_inv_ofc_cd" :
                                    var url_str;
                                    url_str='ESD_TES_930.screen'
                                    url_str=url_str + '?ofc_cd='+(formObject.inv_ofc_cd.value==""?ofc_cd:formObject.inv_ofc_cd.value);
                                    url_str=url_str + '&param_nm=inv_ofc_cd'
                                     ComOpenWindow(url_str,   window,  "dialogWidth:425px; dialogHeight:440px; help:no; status:no; resizable:yes;" , true);
                          	        break;
                */
            case "btn_inv_ofc_cd":
                var formObject = document.form;
                var cmdt_cd_val = "";
                var rep_cmdt_cd_val = "";
                var cmdt_desc_val = "";
                var classId = "getCOM_ENS_ofc";
                var xx1 = ""; //CONTI
                var xx2 = ""; //SUB CONTI
                var xx3 = ""; //COUNTRY
                var xx4 = ""; //STATE
                var xx5 = ""; //CONTROL OFFIC
                var xx6 = ""; //LOC CODE
                var xx7 = ""; //LOC NAME
                var xx8 = "";
                var xx9 = "";
                var param = "?conti_cd=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3 + "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6 + "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
                ComOpenPopup('/opuscntr/COM_ENS_071.do' + param, 770, 500, 'getInvOfc', '1,0,1,1,1,1,1,1,1,1,1,1', true);
                break;

            case "btng_print":
                ComShowMessage('Print service will be available soon');
                //                    if(sheetObject.RowCount<1){
                //                        ComShowMessage(getMsg('TES21905'));
                //                        return false
                //                    }else{
                //                        printInvoiceSummary();
                //                    }
                break;

            case "btng_downexcel":
                if (formObject.vol_show_mode[0].checked == false) {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                } else {
                    doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
                }
                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(e.message);
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
 * IBCombo Object
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param(combo_obj) como object
 */
function setComboObject(combo_obj) {
    comboObjects[comboCnt++] = combo_obj;
}

/**
 * set Combo list
 * @param(comboObjl) 	combo object
 * @param(comboNo) 		combo number
 * @param(combo_val) 	combo value
 * @param(def_val) 		def value
 */
function initCombo(comboObj, comboNo, combo_val, def_val) {
    var cnt = 0;
    switch (comboNo) {
        case 1: //nod_cd
            with(comboObj) {
                SetColAlign(0, "left");
                SetColWidth(0, "45");
                SetDropHeight(150);
                var tmp = '';
                if (combo_val != null) {
                    tmp = combo_val.split('|');
                }
                for (var i = 0; tmp != null && i < tmp.length; i++) {
                    //						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
                    InsertItem(cnt++, tmp[i], tmp[i]);
                }
                if (def_val != undefined && def_val != null && def_val.trim() != '') {
                    Code = def_val;
                } else {
                    Code = '';
                }
            }
            break;
    }
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    //for(i=0;i< comboObjects.length;i++){
    //      initCombo(comboObjects[i],i+1);
    //}
    for (i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    try {
        var rtnVal = getDBDate(); // tes_getInputValue('DB_DATE', SEARCH06, '', 'setPeriodFromTo');
        if (rtnVal.length > 0) {
            setPeriodFromTo(rtnVal);
        }

        document.form.vol_show_mode[0].checked = true;
        initCheckBox();
    } catch (e) {}
}

/**
 * Initialization check box
 */
function initCheckBox() {
    document.form.cost_tp[0].checked = true;
    document.form.cost_tp[1].checked = false;
    document.form.cost_tp[2].checked = false;
    document.form.cost_tp[3].checked = false;
    document.form.cost_tp[4].checked = false;
    document.form.cost_tp[5].checked = false;
    document.form.cost_tp[6].checked = false;
    document.form.cntr_tp[0].checked = true;
    document.form.cntr_tp[1].checked = true;
    //        disableManyObjects(document.form.cntr_tp[0], document.form.cntr_tp[1]);
    ComEnableManyObjects(false, document.form.cntr_tp[0], document.form.cntr_tp[1]);
}

/**
 * setting sheet initial values and header
 * param : sheetObj ==> , sheetNo ==>  
 * adding case as numbers of counting sheets
 * @param(sheetObj) 	sheet object
 * @param(sheetNo)		sheet number
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with(sheetObj){
			
				var HeadTitle=" |H/Q|RHQ|Inv. OFC|Cost OFC|Yard|S/P|S/P Name|Curr|INV\nAMT|TAX\nAMT|WHT\nAMT|Total\nAMT|USD";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:7, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hq_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"vat_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"whld_tax_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_inv_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"usd_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
				resizeSheet();//SetSheetHeight(240);
				
				ShowSubSum([{StdCol:"hq_ofc_cd", SumCols:"inv_amt|vat_amt|whld_tax_amt|ttl_inv_amt|usd_amt", Sort:true}]);
			}
		break;
		
		case 2:      //sheet1 init
			with(sheetObj){
			
				var HeadTitle0=" |H/Q|RHQ|Inv. OFC|Cost OFC|Yard|S/P|S/P Name|Invoice No|CSR No.|CSR Status|I/F Status\nUpdated Time|VVD|S.LANE|ATB Date|Cost|Cost|Curr|INV\nAMT|USD\nAMT|"
				+ "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
				+ "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
				+ "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
				+ "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
				+ "Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|Volume by Container T/S|"
				+"TEU|BOX|MOVE|Total\n20'|Total\n40'|Total\nTEU|Total\nBOX";
				var HeadTitle1=" |H/Q|RHQ|Inv. OFC|Cost OFC|Yard|S/P|S/P Name|Invoice No|CSR No.|CSR Status|I/F Status\nUpdated Time|VVD|S.LANE|ATB Date|Code|Description|Curr|INV\nAMT|USD\nAMT|"
				+ "D2|D4|D5|D7|D8|D9|DW|DX|R2|R4|R5|R7|F2|F4|F5|O2|O4|S2|S4|T2|T4|A2|A4|P2|P4|TEU|BOX|MOVE|Total\n20'|Total\n40'|Total\nTEU|Total\nBOX";
				
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:7, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle0, Align:"Center"},
				{ Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"hq_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"vndr_lgl_eng_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"csr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"if_status",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                            {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"if_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"atb_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"lgs_cost_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"inv_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"usd_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_d2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_d4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_d5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_d7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_d8",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_d9",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_dw",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_dx",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_r2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_r4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_r5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_r7",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_f2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_f4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_f5",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_o2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_o4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_s2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_s4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_t2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_t4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_a2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_a4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_p2",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vol_p4",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vol_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vol_box",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vol_move",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ttl_20",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ttl_40",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Float",     Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ttl_teu",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							{Type:"Int",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ttl_box",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				InitColumns(cols);
				
				SetEditable(0);
				resizeSheet();//SetSheetHeight(240);
				sheetObj.ShowSubSum([{StdCol:"hq_ofc_cd", SumCols:"inv_amt|usd_amt|vol_d2|vol_d4|vol_d5|vol_d7|vol_d8|vol_d9|vol_dw|vol_dx|vol_r2|vol_r4|vol_r5|vol_r7|vol_f2|vol_f4|vol_f5|vol_o2|vol_o4|vol_s2|vol_s4|vol_t2|vol_t4|vol_a2|vol_a4|vol_p2|vol_p4|vol_teu|vol_box|vol_move|ttl_20|ttl_40|ttl_teu|ttl_box", Sort:true}]);
			}
		break;
	}    
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
    ComResizeSheet(sheetObjects[1]);
}

/**
 * action IBSheet
 *  
 * @param(sheetObj) 	sheet object 
 * @param(formObj) 	form  
 * @param(sAction) 	action value 
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0014GS.do", tesFrmQryStr(formObj));
            //no support[check again]CLT sheetObj.LoadSearchXml4Sax(searchXml);
            sheetObj.LoadSearchData(searchXml);
            break;
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) {
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({
                    DownCols: makeHiddenSkipCol(sheetObj),
                    SheetDesign: 1,
                    Merge: 1
                });
            }
            break;

        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCH17;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0014GS.do", tesFrmQryStr(formObj));
            var vndrNm = ComGetEtcData(searchXml, "vndr_nm");
            formObj.vndr_seq_name.value = vndrNm;
            searchXml = null;

            break;
    }
}

/**
 * action IBSheet 
 * 
 * @param(sheetObj) 	sheet object 
 * @param(formObj) 		form  
 * @param(sAction) 		action value 
 */
function doActionIBSheet1(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            formObj.f_cmd.value = SEARCH01;
            var searchXml = sheetObj.GetSearchData("ESD_TES_0014GS.do", tesFrmQryStr(formObj));
            //no support[check again]CLT sheetObj.LoadSearchXml4Sax(searchXml);
            sheetObj.LoadSearchData(searchXml);
            break;
        case IBDOWNEXCEL:
            if (sheetObj.RowCount() < 1) {
                ComShowCodeMessage("COM132501");
            } else {
                sheetObj.Down2Excel({
                    DownCols: makeHiddenSkipCol(sheetObj),
                    SheetDesign: 1,
                    Merge: 1
                });
            }
            break;
    }
}

/**
 * handling process for input validation
 * @param(sheetObj) 	sheet object 
 * @param(formObj) 		form  
 * @param(sAction) 		action value      
 */
function validateForm(sheetObj, formObj, sAction) {
    with(formObj) {
        //            if (!ComIsNumber(iPage)) {
        //
        //                return false;
        //            }
    }
    return true;
}

/**
 * check period 
 */
function setPeriodFromTo(argVal) {
    var formObj = document.form;
    var to_dt = new String(argVal).substring(0, 8);
    var fr_dt;
    if (to_dt != undefined && to_dt != null && to_dt.trim() != '' && to_dt.length == 8) {

        //fr_dt = tes_getDiffDate(to_dt, -30, 'D');
        fr_dt = tes_getDiffDate(to_dt, -1, 'M') + to_dt.substring(6, 8);
        if (fr_dt != undefined && fr_dt != null && fr_dt.trim() != '' && fr_dt.length == 8) {
            if (fr_dt.substring(6, 8) > ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10))) {
                fr_dt = fr_dt.substring(0, 6) + ComGetLastDay(parseInt(fr_dt.substring(0, 4), 10), parseInt(fr_dt.substring(4, 6), 10));
            }
            formObj.fm_prd_dt.value = fr_dt.substring(0, 4) + '-' + fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
            formObj.to_prd_dt.value = to_dt.substring(0, 4) + '-' + to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
        }
    }
}

/**
 *  print invoice summary
 */
function printInvoiceSummary() {
    var fromObj = new Array();
    var rdObj = new Array();
    var paramObj = new Array();
    fromObj[0] = document.form;
    rdObj[0] = sheetObjects[0];

    paramObj[0] = "1";
    paramObj[1] = "";
    paramObj[2] = "N";
    paramObj[3] = RD_path + "apps/opus/esd/tes/serviceproviderinvoicemanage/marineterminalinvoicemanage/report/ESD_TES_801.mrd";
    paramObj[4] = rdObj;
    paramObj[5] = fromObj;
    rdObjModaless(RdReport, paramObj, 1000, 700);
}

/**
 * check period
 */
function chkPeriod() {
    var formObj = document.form;
    var is_valid = 0;
    var fromVal = formObj.fm_prd_dt.value;
    var toVal = formObj.to_prd_dt.value;
    is_valid = ComGetDaysBetween(fromVal, toVal);
    if (is_valid < 0) {
        formObj.to_prd_dt.value = '';
        ComAlertFocus(formObj.fm_prd_dt, "From Date is Later than To Date");
    }
}

/**
 * get vender name
 * @param(obj) object
 */
function getVndrName(obj) {
    var formObj = document.form;
    if (tes_getStrLen(obj.value) == 6) {
        if (formObj.vndr_seq.value == null || formObj.vndr_seq.value.trim() == '') {
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';
            return false;
        }
        if ((formObj.vndr_seq_hidden.value == null || formObj.vndr_seq_hidden.value.trim() == '') || formObj.vndr_seq.value.trim() != formObj.vndr_seq_hidden.value.trim()) {
            formObj.vndr_seq_hidden.value = '';
            formObj.is_valid_vndr_seq.value = '';

            var sRtnVal = getVndrSeqNm("vndr_seq_name"); // tes_getInputValue('is_valid_vndr_seq', SEARCH07, 'vndr_seq', 'checkValidVndrCode');
            if (sRtnVal == "Y") {
                formObj.is_valid_vndr_seq.value = sRtnVal;
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
            }
        }
    }
}

/**
 * validation check vander code
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
                formObj.vndr_seq_name.value = (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
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
 * get yard code 
 */
function getYard(rowArray) {
    //ComShowMessage("getYard");
    var colArray = rowArray[0];
    document.all.loc_cd.value = colArray[3].substr(0, 5);
    node = colArray[3].substr(5, 2);
    getNodeCdList(0, "", "", node);  // tes_getComboItem('nod_cd', 1, SEARCHLIST04, '', 'loc_cd', 'setNodCode');
    //document.all.nod_cd.Code = colArray[3].substr(5, 2);
    //document.all.yd_cd_name.value = colArray[4];
}

/**
 * get nod code
 */
function setNodCode() {
    //document.all.nod_cd.SetSelectCode(node);
    comboObjects[0].SetSelectCode(node);
    node = ''
}

/**
 * get vender code
 * @param(rowArray)  
 */
function getVender(rowArray) {
    // ComShowMessage("getVender");
    var colArray = rowArray[0];
    //document.all.vndr_seq.value = colArray[2].substr(2,6);
    document.all.vndr_seq.value = colArray[6];
    document.all.vndr_seq_name.value = colArray[4];
}

/**
 * get office code
 * @param(rowArray)  
 */
function getOffice(rowArray) {
    //ComShowMessage("getOffice");
    var colArray = rowArray[0];
    document.all.cost_ofc_cd = colArray[3];
}

/**
 * get cost code
 * @param(rowArray)  
 */
function getCostOfc(rowArray) {
    var formObject = document.form;
    for (var i = 0; i < rowArray.length; i++) {
        var colArray = rowArray[0];
        document.form.cost_ofc_cd.value = colArray[3];
    }
}

/**
 * get invoice code
 * @param(rowArray)  
 */
function getInvOfc(rowArray) {
    var formObject = document.form;
    for (var i = 0; i < rowArray.length; i++) {
        var colArray = rowArray[0];
        document.form.inv_ofc_cd.value = colArray[3];
    }
}

/**
 * validation code yard code 
 */
function validateYardCode() {
    var formObj = document.form;
    if (formObj.yd_cd.value == null || formObj.yd_cd.value.trim() == '') {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        return false;
    }
    
    if ((formObj.yd_cd_hidden.value == null || formObj.yd_cd_hidden.value.trim() == '') || formObj.yd_cd.value.trim() != formObj.yd_cd_hidden.value.trim()) {
        formObj.yd_cd_hidden.value = '';
        formObj.is_valid_yd_cd.value = '';
        
        var rtnVal = getYdCdValid();    //  tes_getInputValue('is_valid_yd_cd', SEARCH20, 'yd_cd', 'checkValidYardCode');
        if(rtnVal.length > 0){
        	checkValidYardCode(rtnVal);
        }        
    }
}

/**
 * validation check yard code
 */
function checkValidYardCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_yd_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_yd_cd.value != null && formObj.is_valid_yd_cd.value == 'Y') {
                formObj.yd_cd_hidden.value = formObj.yd_cd.value;
                formObj.yd_cd_deltflg.value = (tmp[9] != undefined && tmp[9] != null ? tmp[9] : '');
                if (formObj.yd_cd_deltflg.value == "Y") {
                    ComShowMessage('Deleted Yard Code!');
                }
                //getInputValue('cost_ofc_cd', COMMAND01, 'yd_cd', 'setCostOfcReadOnlyFalse');
            } else {
                formObj.is_valid_yd_cd.value = '';
                formObj.yd_cd_hidden.value = '';
                formObj.yd_cd.value = '';
                ComShowCodeMessage('TES10066');
            }
        } else {
            formObj.is_valid_yd_cd.value = '';
            formObj.yd_cd_hidden.value = '';
            formObj.yd_cd.value = '';
            ComShowCodeMessage('TES10066');
        }
    } else {
        formObj.is_valid_yd_cd.value = '';
        formObj.yd_cd_hidden.value = '';
        formObj.yd_cd.value = '';
        ComShowCodeMessage('TES10066');
    }
}

/**
 * validation check vndr code
 */
function validateVNDRCode() {
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
        
		var rtnVal = getVndrSeqValid("vndr_seq_name");
        
        if(rtnVal.length > 0){
        	checkValidVendorCode(rtnVal);
        }
        
        //doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
        //tes_getInputValue('is_valid_vndr_seq', SEARCHLIST01, 'vndr_seq', 'checkValidVNDRCode');
    }
}

/**
 * validation check vndr code
 */
function checkValidVendorCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_vndr_seq.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_vndr_seq.value != null && formObj.is_valid_vndr_seq.value == 'Y') {
                formObj.vndr_seq_name.value = (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
                formObj.vndr_seq_hidden.value = formObj.vndr_seq.value;
                formObj.vndr_seq_deltflg.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
                if (formObj.vndr_seq_deltflg.value == "Y") {
                    ComShowMessage('Deleted S/P Code!');
                }
            } else {
                formObj.is_valid_vndr_seq.value = '';
                formObj.vndr_seq_hidden.value = '';
                formObj.vndr_seq.value = '';
                formObj.vndr_seq_name.value = '';
                ComShowCodeMessage('TES10067');
            }
        } else {
            formObj.is_valid_vndr_seq.value = '';
            formObj.vndr_seq_hidden.value = '';
            formObj.vndr_seq.value = '';
            formObj.vndr_seq_name.value = '';
            ComShowCodeMessage('TES10067');
        }
    } else {
        formObj.is_valid_vndr_seq.value = '';
        formObj.vndr_seq_hidden.value = '';
        formObj.vndr_seq.value = '';
        formObj.vndr_seq_name.value = '';
        ComShowCodeMessage('TES10067');
    }
}

/**
 * value check invoice office code, office code
 * @param(inv_ofc_cd) invoice office code
 */
function checkValidOFC(inv_ofc_cd) {
    if (ofc_cd == '') {
        ComShowMessage('No Inv OFC data is found in the session');
        return false;
    }
    
    if (inv_ofc_cd == '' || inv_ofc_cd == null) {
        ComShowMessage("Inv OFC data does not exist at the selected invoice!");
        return false;
    }
    
    if (ofc_cd != inv_ofc_cd) {
        ComShowMessage("No authority to correct/delete selected invoice - Invoice office mismatch!");
        return false;
    }
    return true;
}

/**
 *  validation check cost code
 *	@return
 */
function validateCostOFCCode() {
    var formObj = document.form;
    if (formObj.cost_ofc_cd.value == null || formObj.cost_ofc_cd.value.trim() == '') {
        formObj.cost_ofc_cd_hidden.value = '';
        formObj.is_valid_cost_ofc_cd.value = '';
        return false;
    }
    
    if ((formObj.cost_ofc_cd_hidden.value == null || formObj.cost_ofc_cd_hidden.value.trim() == '') || formObj.cost_ofc_cd.value.trim() != formObj.cost_ofc_cd_hidden.value.trim()) {
        formObj.cost_ofc_cd_hidden.value = '';
        formObj.is_valid_cost_ofc_cd.value = '';
        
        var sTempCostCd = formObj.cost_ofc_cd.value;
        var aCostOfcCd = new Array();
        
        aCostOfcCd = sTempCostCd.split(",");
        
        for(i=0; i < aCostOfcCd.length; i++){
        	formObj.cost_ofc_cd.value = aCostOfcCd[i];
        	var rtnVal = getCostOfcValidDelYN();    // tes_getInputValue('is_valid_cost_ofc_cd', SEARCHLIST02, 'cost_ofc_cd', 'checkValidCostOFCCode');
	        if(rtnVal.length > 0){
	        	checkValidCostOFCCode(rtnVal);
	        }      
        }
        
        formObj.cost_ofc_cd.value = sTempCostCd; 
    }
}

/**
 *  validation check cost code
 *	@return
 */
function checkValidCostOFCCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_cost_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_cost_ofc_cd.value != null && formObj.is_valid_cost_ofc_cd.value == 'Y') {
                formObj.cost_ofc_cd_hidden.value = formObj.cost_ofc_cd.value;
                formObj.cost_ofc_cd_deltflg.value = (tmp[2] != undefined && tmp[2] != null ? tmp[2] : '');
                if (formObj.cost_ofc_cd_deltflg.value == "Y") {
                    ComShowMessage('Deleted Office Code!');
                }
            } else {
                formObj.is_valid_cost_ofc_cd.value = '';
                formObj.cost_ofc_cd_hidden.value = '';
                formObj.cost_ofc_cd.value = '';
                ComShowCodeMessage('TES40052', 'Cost Office Code');
            }
        } else {
            formObj.is_valid_cost_ofc_cd.value = '';
            formObj.cost_ofc_cd_hidden.value = '';
            formObj.cost_ofc_cd.value = '';
            ComShowCodeMessage('TES40052', 'Cost Office Code');
        }
    } else {
        formObj.is_valid_cost_ofc_cd.value = '';
        formObj.cost_ofc_cd_hidden.value = '';
        formObj.cost_ofc_cd.value = '';
        ComShowCodeMessage('TES40052', 'Cost Office Code');
    }
}

/**
 *  validation check invoice office code
 *	@return
 */
function validateInvOFCCode() {
    var formObj = document.form;
    if (formObj.inv_ofc_cd.value == null || formObj.inv_ofc_cd.value.trim() == '') {
        formObj.inv_ofc_cd_hidden.value = '';
        formObj.is_valid_inv_ofc_cd.value = '';
        return false;
    }
    if ((formObj.inv_ofc_cd_hidden.value == null || formObj.inv_ofc_cd_hidden.value.trim() == '') || formObj.inv_ofc_cd.value.trim() != formObj.inv_ofc_cd_hidden.value.trim()) {
        formObj.inv_ofc_cd_hidden.value = '';
        formObj.is_valid_inv_ofc_cd.value = '';
        
        var rtnVal = getInvOfcValidDelYN();     // tes_getInputValue('is_valid_inv_ofc_cd', SEARCHLIST03, 'inv_ofc_cd', 'checkValidInvOFCCode');
        if(rtnVal.length > 0){
        	checkValidInvOFCCode(rtnVal);
        }        
    }
}

/**
 *  validation check invoice office 
 *	@return
 */
function checkValidInvOFCCode(argVal) {
    var formObj = document.form;
    var tmp = '';
    if (argVal != undefined && argVal != null && argVal.trim() != '') {
        tmp = argVal.split('|');
        if (tmp.length > 0) {
            formObj.is_valid_inv_ofc_cd.value = (tmp[0] != undefined && tmp[0] != null ? tmp[0] : '');
            if (formObj.is_valid_inv_ofc_cd.value != null && formObj.is_valid_inv_ofc_cd.value == 'Y') {
                formObj.inv_ofc_cd_hidden.value = formObj.inv_ofc_cd.value;
                formObj.inv_ofc_cd_deltflg.value = (tmp[1] != undefined && tmp[1] != null ? tmp[1] : '');
                if (formObj.inv_ofc_cd_deltflg.value == "Y") {
                    ComShowMessage('Deleted Office Code!');
                }
            } else {
                formObj.is_valid_inv_ofc_cd.value = '';
                formObj.inv_ofc_cd_hidden.value = '';
                formObj.inv_ofc_cd.value = '';
                ComShowCodeMessage('TES40052', 'Invoice Office Code');
            }
        } else {
            formObj.is_valid_inv_ofc_cd.value = '';
            formObj.inv_ofc_cd_hidden.value = '';
            formObj.inv_ofc_cd.value = '';
            ComShowCodeMessage('TES40052', 'Invoice Office Code');
        }
    } else {
        formObj.is_valid_inv_ofc_cd.value = '';
        formObj.inv_ofc_cd_hidden.value = '';
        formObj.inv_ofc_cd.value = '';
        ComShowCodeMessage('TES40052', 'Invoice Office Code');
    }
}

/**
 * volume show mode status
 * 
 */
function vol_show_mode_sts() {
    var formObj = document.form;
    if (formObj.vol_show_mode[0].checked == false) {
        document.all.SearchLayer1.style.display = "inline"
        document.all.SearchLayer2.style.display = "none"
            //disableManyObjects(formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
            //                   formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);
        ComEnableManyObjects(false, formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
            formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);
    } else {
        document.all.SearchLayer1.style.display = "none"
        document.all.SearchLayer2.style.display = "inline"
            //enableManyObjects(formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
            //                   formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);
        ComEnableManyObjects(true, formObj.cost_tp[0], formObj.cost_tp[1], formObj.cost_tp[2], formObj.cost_tp[3], formObj.cost_tp[4],
            formObj.cost_tp[5], formObj.cost_tp[6], formObj.cntr_tp[0], formObj.cntr_tp[1]);
    }
    initCheckBox();
    resizeSheet();
}

/**
 * cost type click event  
 */
function cost_tpOnclick() {
    document.form.cost_tp[0].checked = false;
    ComEnableManyObjects(true, document.form.cntr_tp[0], document.form.cntr_tp[1]);
}

/**
 * get code combo 
 *  @param(obj) object
 */
function getNodeCodeCombo(obj) {
    if (obj.value.length == "5") {
    	getNodeCdList(0, "", "", "");   // tes_getComboItem('nod_cd', 1, SEARCHLIST04, '', 'loc_cd', '');
    } else {
        return false;
    }
}

/** check input value
 * @param {obj}  object
 **/
function chkInput(obj) {
    //	ComShowMessage('strleng: '+getStrLen(obj.value));
    if (obj.maxLength < getStrLen(obj.value)) {
        obj.value = '';
        obj.focus();
        return false;
    }
}

/** check number
 * @param {obj}  object
 **/
function isNum(obj) {
    if (!ComIsNumber(obj)) {
        obj.value = '';
    }
}

/** check number
 * @param {obj}  object
 **/
function isNum1(obj) {
    if (!ComIsNumber(obj, "-")) {
        obj.value = '';
    }
}

/** only English and numbers permitted
 * @param {obj}  object
 **/
function isApNum(obj) {
    if (!ComIsAlphabet(obj, 'n')) {
        obj.value = '';
    }
}

/** check English
 * @param {obj}  object
 **/
function isAlpha(obj) {
    if (!ComIsAlphabet(obj)) {
        obj.value = "";
    }
}

/** check string length 
 * @param {src}  문자열
 **/
function getStrLen(src) {
    src = new String(src);
    var byteLength = 0;
    for (var inx = 0; inx < src.length; inx++) {
        var oneChar = escape(src.charAt(inx));
        if (oneChar.length == 1) {
            byteLength++;
        } else if (oneChar.indexOf("%u") != -1) {
            byteLength += 2;
        } else if (oneChar.indexOf("%") != -1) {
            byteLength += oneChar.length / 3;
        }
    }
    return byteLength;
}

/**
 * yard code change event
 * @return
 */
function nod_cd_OnChange() {
    var formObj = document.form;
    formObj.yd_cd.value = formObj.loc_cd.value + nod_cd.GetSelectCode();
}

/**
 * search end event
 * @param sheetObj
 * @return
 */
function sheet1_OnSearchEnd(sheetObj) {
    //	    sheetObj.ShowSubSum([{StdCol:"hq_ofc_cd", SumCols:"inv_amt|vat_amt|whld_tax_amt|ttl_inv_amt|usd_amt", Sort:true}]);
}

/**
 * search end event 
 * @param sheetObj
 * @return
 */
function sheet2_OnSearchEnd(sheetObj) {
    document.form.cost_code.value = "";
    document.form.cntr_sty_code.value = "";
    sheetObj.ShowSubSum([{
        StdCol: "hq_ofc_cd",
        SumCols: "inv_amt|usd_amt|vol_d2|vol_d4|vol_d5|vol_d7|vol_d8|vol_d9|vol_dw|vol_dx|vol_r2|vol_r4|vol_r5|vol_r7|vol_f2|vol_f4|vol_f5|vol_o2|vol_o4|vol_s2|vol_s4|vol_t2|vol_t4|vol_a2|vol_a4|vol_p2|vol_p4|vol_teu|vol_box|vol_move|ttl_20|ttl_40|ttl_teu|ttl_box",
        Sort: true
    }]);
}