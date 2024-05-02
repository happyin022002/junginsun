/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0105.js
*@FileTitle  : Forecast History Direct Down Excel 
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/21
=========================================================*/
var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var beforetab = 0;
var searchParams = "";

/* Event handler processing by button click event */
document.onclick = processButtonClick;

/* Event handler processing by button name */
function processButtonClick() {
    /***** setting additional sheet value in case of more 2 sheet per tab *****/
    var sheetObject = sheetObjects[0];
    /*******************************************************/ 
    var formObject = document.form;
    //try {
    var srcName = ComGetEvent("name");
    if (ComGetBtnDisable(srcName)) return false;
    switch (srcName) {
        case "btn_retrieve":
            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;
            
        case "btn_popup_customer":
            var cust_cd = formObject.customer.value;
            spcPopup("Customer", "cust_cd=" + cust_cd, 770, 470, "callbackPopupCustomer", "1,0,1,1,1,1,1,1");
            break;
    } // end switch        	
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
    optionSetting();
    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet2(sheetObjects[i]);
        ComEndConfigSheet(sheetObjects[i]);
    }
    resizeSheet();
    var formObject = document.form;
    var comObj = salesOffice;
    if (comObj.GetItemCount() <= 1) {
        comObj.SetSelectIndex(0);
        var comObj1 = subOffice;
        if (comObj.GetSelectCode() != comObj1.GetSelectCode()) {
            comObj1.SetEnable(0);
        }
    }
    var rtn = getCodeList("ChildOffice", "ofc_cd=" + ofc_cd + "&level=4");
    initData_salesOffice(rtn[0].split("|"), rtn[1].split("|"));
    
    //20160211.ADD : combo set
    if(r_year.length > 0) formObject.year.value = r_year;
    if(r_week.length > 0) formObject.week.value = r_week;
    if(r_duration.length > 0) formObject.duration.value = r_duration;
    var comObj2 = salesOffice;
    if(r_salesOffice.length > 0) comObj2.SetSelectCode(r_salesOffice,false);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj) {

}

/**
 * Changing the title after retrieving it in TabSheet2
 */
var sheet2=new Object();
function initSheet2(sheetObj, isInit){
	if(isInit == undefined){
		isInit=false;
	}
	
    with(sheetObj){
		var HeadTitle1="VVD|Sub\nOffice|Sales Rep|Sales Rep|Modified Date(UTC)|Modified By|Account|Account|Account|Contract Number|Contract Customer|Contract Customer|POL|POD|";
		var HeadTitle2="VVD|Sub\nOffice|CODE|NAME|Modified Date(UTC)|Modified By|TP|CODE|NAME|Contract Number|CODE|NAME|POL|POD|";
		sheet2.masterColumnCount=HeadTitle1.split("|").length - 1;
		sheet2.forecastColumnCount=7; //Total, TEU, hc, 45, 53, rf, wt
		sheet2.bookingColumnCount=8;
		sheet2.itemColumnCount=sheet2.forecastColumnCount +  sheet2.bookingColumnCount ;
		sheet2.columnCount=sheet2.masterColumnCount + sheet2.itemColumnCount ;
		HeadTitle2=HeadTitle2+"Total TEU|TEU|HC|45|53'|RF|WT|Total TEU|20|40|HC|45|53'|RF|WT|";
		
		for(var j=0 ; j < sheet2.forecastColumnCount ; j++){
			HeadTitle1=HeadTitle1 + "F'cast|";
		}
		
		for(var k=0 ; k < sheet2.bookingColumnCount ; k++){
			HeadTitle1=HeadTitle1 + "BKG|";
		}
		
		var cnt=0;
		SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:1000  } );
		var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
		
		InitHeaders(headers, info);
		var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"srep_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"srep_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"modi_gdt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"modi_usr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fcast_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	 			 //20160211.ADD start, 20160325.MOD
    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             //20160211.ADD end				 
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_teu_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_40ft_hc_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_45ft_hc_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_53ft_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_rf_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_ttl_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_20ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_40ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_40ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_45ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_53ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_rf_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_ttl_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lvl",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0}, 
					 {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL1",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL2",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL3",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 ];
		
		InitColumns(cols);
		SetEditable(salesOffice.GetItemCount()==1);
		SetSheetHeight(ComGetSheetHeight(sheetObj,14));
		SetHeaderRowHeight(10);
	}
}

//Handling the process related with Sheet
function doActionIBSheet(sheetObj, formObj, sAction, quite) { 
    switch (sAction) {
        case IBSEARCH: //Retrieve
            var sheetObj = sheetObjects[beforetab];
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            
            var param = "year=" + formObj.year.value;
            param = param + "&week=" + formObj.week.value;
            param = param + "&duration=" + formObj.duration.value;
            param = param + "&ioc=" + (formObj.id_chk_ocn.checked ? formObj.id_chk_ocn.value : (formObj.id_chk_ipc.checked ? formObj.id_chk_ipc.value : formObj.id_chk_ts.value));
            param = param + "&vvd=" + formObj.vvd.value;
            param = param + "&trade=" + comObjects[0].GetSelectCode();
            param = param + "&subTrade=" + comObjects[1].GetSelectCode();
            param = param + "&lane=" + comObjects[2].GetSelectCode();
            param = param + "&bound=" + formObj.bound.value;
            param = param + "&salesOffice=" + comObjects[3].GetSelectCode();;
            param = param + "&subOffice=" + comObjects[4].GetSelectCode();;
            param = param + "&salesRep=" + comObjects[5].GetSelectCode();
            param = param + "&customer=" + formObj.customer.value;
            searchParams = param;        
            
            var rtn = sheetObj.GetSearchData("ESM_SPC_0104GS.do", "f_cmd=" + SEARCHLIST02 + "&" + searchParams);
		    if (ComGetTotalRows(rtn) > 0) {
		        sheetObj.RenderSheet(0);
		        sheetObj.LoadSearchData(rtn, { Sync: 1 });
		        sheetObj.RenderSheet(1);
		        
		        sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign: 1,  Merge: 1,  ExcelFontSize: 9  });
		    } else {
		    	ComShowCodeMessage('COM130401');
		        sheetObj.LoadSearchData(rtn, { Sync: 1 });
		    }       
            break;
    }
}

function vvdChanged() {
    var obj = ComGetEvent();
    if (obj.value == "") {
        trade_OnChange(comObjects[0], comObjects[0].GetSelectCode(), comObjects[0].GetSelectText());
    } else {
        document.all.id_chk_ocn.checked = true;
        document.all.id_chk_ocn.disabled = false;
        document.all.id_chk_ipc.disabled = false;
        document.all.id_chk_ts.disabled = false;
    }
}

function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    if (newCode == "") return;
    if (document.all.vvd.value != "") return;
    if (newCode.charAt() != "I") {
        document.all.id_chk_ocn.checked = true;
        document.all.id_chk_ocn.disabled = true;
        document.all.id_chk_ipc.disabled = true;
        document.all.id_chk_ts.disabled = true;
    } else {
        document.all.id_chk_ipc.checked = true;
        document.all.id_chk_ocn.disabled = true;
        document.all.id_chk_ipc.disabled = false;
        document.all.id_chk_ts.disabled = false;
    }
    var formObj = document.form;
    var trade = formObj.trade.value;

    if (trade != null && trade != '') {
        SpcSearchOptionSubTrade("subTrade", true, false, "", formObj.trade.value); 		
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subTrade.value, true); 
    }
}

function subTrade_OnChange(combj, value, text) {
    if (value == "") return;
    if (document.all.vvd.value != "") return;

    var formObj = document.form;
    var subTrade = formObj.subTrade.value;

    if (subTrade != null && subTrade != '') {
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subTrade.value, true); 
    }
}

function salesOffice_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    if (newCode == "") return;
    var rtn = getCodeList("ChildOffice", "ofc_cd=" + newCode + "&level=5&include=1");
    initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));
    if (subOffice.GetSelectCode() == "") {
        var rtn = getCodeList("SalesRep", "ofc_cd=" + newCode + "&level=4");
        initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
    }
    var subObj = subOffice;
    subOffice_OnChange(subObj, subObj.GetSelectCode(), subObj.GetSelectText());
}

function subOffice_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    var rtn = "";
    if (newCode == "") {
        rtn(getCodeList("SalesRep", "ofc_cd=" + salesOffice.SetSelectCode + "&level=4"));
    } else {
        rtn = getCodeList("SalesRep", "ofc_cd=" + newCode + "&level=5");
    }
    initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
}

function initDataValue_salesOffice() {
    var sheetObj = salesOffice;
    with(sheetObj) {
        Index2 = 0;
    }
}

function initData_salesOffice(codes, names) {
    var sheetObj = salesOffice;
    var cnt = 0;
    with(sheetObj) {
        RemoveAll();
        SetTitle("Office|Name");
        SetColWidth(0, "60");
        SetColWidth(1, "250");
        SetColAlign(0, "left");
        SetColAlign(1, "left");
        
        SetMultiSelect(0);
        SetMaxSelect(1);
        SetDropHeight(190);
        ValidChar(2, 1); //영어대문자,숫자포함 도움말 ValidChar 참고
        SetMaxLength(6);
        if (codes == undefined || codes == null) {
            return;
        }
        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }
        var selectCode = "";
        for (var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[1] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
        }
        if (selectCode != "") {
            Code = selectCode;
        } else {
            Index = 0;
        }
        SetEnable((GetItemCount() > 1));
    }
}

function initData_subOffice(codes, names) {
    var sheetObj = subOffice;
    var cnt = 0;
    with(sheetObj) {
        RemoveAll();
        SetTitle("Office|Name");
        SetColWidth(0, "60");
        SetColWidth(1, "250");
        SetColAlign(0, "left");
        SetColAlign(1, "left");
        
        SetMultiSelect(0);
        SetMaxSelect(1);
        SetDropHeight(190);
        ValidChar(2, 1); //영어대문자,숫자포함 도움말 ValidChar 참고
        SetMaxLength(6);
        if (codes == undefined || codes == null) {
            return;
        }
        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }
        var selectCode = "";
        for (var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[1] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
        }
        if (selectCode != "") {
            Code = selectCode;
        } else {
            Index = 0;
        }
        SetEnable((GetItemCount() > 1));
        SetEnable(!(Index > 1));
    }
}

function initDataValue_subOffice() {
    var sheetObj = subOffice;
    with(sheetObj) {
        Index2 = 0;
    }
}

function initData_salesRep(codes, names) {
    var sheetObj = salesRep;
    var cnt = 0;
    with(sheetObj) {
        RemoveAll();
        SetTitle("Code|Name|OFC|OFC NM");
        SetColWidth(0, "60");
        SetColWidth(1, "150");
        SetColWidth(2, "60");
        SetColWidth(3, "100");
        SetColAlign(0, "left");
        SetColAlign(1, "left");
        SetColAlign(2, "left");
        SetColAlign(3, "left");
        
        SetMultiSelect(0);
        SetMaxSelect(1);
        SetDropHeight(190);
        ValidChar(2, 1); //영어대문자,숫자포함 도움말 ValidChar 참고
        SetMaxLength(20);
        if (codes == undefined || codes == null) {
            return;
        }
        if (codes.length > 2) {
            InsertItem(-1, "|ALL", "");
        }
        var selectCode = "";
        for (var i = 0; i < codes.length - 1; i++) {
            var txt = names[i].split("~");
            if (txt[3] == "1") {
                selectCode = codes[i];
            }
            InsertItem(-1, codes[i] + "|" + names[i].replace(/~/g, "|"), codes[i]);
        }
        if (selectCode != "") {
            Code = selectCode;
        } else {
            Index = 0;
        }
    }
}

function initDataValue_salesRep() {
    var sheetObj = salesRep;
    with(sheetObj) {
        Index2 = 0;
    }
}

function getCustAbbrNm(custCntCd, custSeq) {
    var custNm = "";
    var rtn = getCodeList("CustAbbrNm", "cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq);
    var code = rtn[0];
    var text = rtn[1];
    var arrText = text.split("|");
    if (arrText.length > 0) {
        custNm = arrText[0];
    }
    return custNm;
}

function getCustGrpNm(customerGrp) {
    var custNm = "";
    var rtn = getCodeList("CustGrpNm", "cust_grp_id=" + customerGrp);
    var code = rtn[0];
    var text = rtn[1];
    var arrText = text.split("|");
    if (arrText.length > 0) {
        custNm = arrText[0];
    }
    return custNm;
}

function callbackPopupCustomerGrp(rowArray) {
    var colArray = rowArray[0];
    document.all.customerGrp.value = colArray[3];
}

function customer_OnKeyDown() {
    log(event.keyCode);
    if (event.keyCode > 128) {
        event.cancelBubble = true;
        return false;
    }
    if (event.srcElement.value.length >= 2) {
        if (event.keyCode >= 65 && event.keyCode <= 90) {
            event.cancelBubble = true;
            return false;
        }
    }
}

function callbackPopupCustomer(rowArray) {
    var colArray = rowArray[0];
    var val = colArray[3];
    document.all.customer.value = val;
    document.all.customerCo.value = val.substring(0, 2);
    document.all.customerCd.value = val.substring(2);
    document.all.customerNm.value = colArray[4];
}

function customer_OnChange() {
    var obj = event.srcElement;
    var val = obj.value;
    var custCntCd = val.substring(0, 2);
    var custSeq = val.substring(2);
    document.all.customerCo.value = custCntCd
    document.all.customerCd.value = custSeq
    if (custSeq.length > 0) {
        obj.value = custCntCd + lpad(custSeq, 6, '0');
        document.all.customerNm.value = getCustAbbrNm(custCntCd, custSeq);
    }
    if (obj.value.length < 8) {
        document.all.customerNm.value = "";
    }
}

function customer_OnKeyPress() {
    eventKeyChangeChar(UPPER_CASE);
}

function customerGrp_OnChange() {
    var obj = event.srcElement;
    var customerGrp = obj.value;
    if (customerGrp.length > 0) {
        document.all.customerGrpNm.value = getCustGrpNm(customerGrp);
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case IBSEARCH: //Retrieve
            var sheetObj = sheetObjects[beforetab];
            var vvd = formObj.vvd.value;
            var trade = comObjects[0].GetSelectCode();
            var lane = comObjects[2].GetSelectCode();
            var office = comObjects[3].GetSelectCode();
            var suboffice = comObjects[4].code;

            if (vvd != "" && vvd.length < 9) {
                ComShowCodeMessage("COM12174", "VVD", "9");
                formObj.vvd.focus();
                return false;
            } else if (vvd == "" && trade == "") {
                ComShowMessage(getMsg("SPC90114", "Trade"));
                comObjects[0].Focus();
                return false;
            } else if (vvd == "" && lane == "") {
                ComShowMessage(getMsg("SPC90114", "Lane"));
                comObjects[2].Focus();
                return false;
            } else if (office == "") {
                ComShowMessage(getMsg("SPC90114", "Office"));
                comObjects[3].Focus();
                return false;
            }

            break;
    }
    return true;
}

function initDataValue_trade() {
    var sheetObj = trade;
    with(sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_subTrade() {
    var sheetObj = subTrade;
    with(sheetObj) {
        Index2 = 0;
    }
}

function initDataValue_lane() {
    var sheetObj = lane;
    with(sheetObj) {
        Index2 = 0;
    }
}

function optionSetting() {
    SpcSearchOptionYear("year");
    SpcSearchOptionWeek("week");
    SpcSearchOptionDuration("duration", 5, 4);
    SpcSearchOptionTrade("trade", false);
    SpcSearchOptionSubTrade("subTrade", true, true);
    SpcSearchOptionLane("lane", true, true);
    SpcSearchOptionBound("bound");
}

function resizeSheet() {
    for (var i = 0; i < sheetObjects.length; i++) {
        ComResizeSheet(sheetObjects[i]);
    }
}