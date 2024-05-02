/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0104.js
*@FileTitle  : Forecast History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 0;
//type check
var type_check;
//retrive check
var check_retrive = false;
var tab_retrives = null;
var searchParams = "";
/* Event handler processing by button click event */
document.onclick = processButtonClick;
/* Event handler processing by button name */

function processButtonClick() {
    /***** setting additional sheet value in case of more 2 sheet per tab *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    /*******************************************************/
    var formObject = document.form;
    //try {
    var srcName = ComGetEvent("name");
    if (ComGetBtnDisable(srcName)) return false;
    switch (srcName) {
        case "btn_retrieve":
            //            			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
            //            	    	sheetObjects[0].RemoveAll();
            //        				sheetObjects[1].RemoveAll();

            for (var i = 0; i < tab_retrives.length; i++) {
                tab_retrives[i] = false;
            }
            doActionIBSheet(sheetObjects[beforetab], formObject, IBSEARCH);
            break;
        case "btn_new":
            if (checkModifiedSheet(sheetObjects)) {
                if (ComShowConfirm(getMsg("SPC90001")) != 1) {
                    return;
                }
            }
            //using common funtion : initializing the screen
            //resetAll();
            sheetObjects[beforetab].RemoveAll();
            formObject.reset();
            optionSetting();
            break;
        case "btn_downexcel":
            if (sheetObjects[beforetab].RowCount() < 1) { //no data
                ComShowCodeMessage("COM132501");
            } else {
                doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
            }
            break;
        case "btn_popup_customer":
            var cust_cd = formObject.customer.value;
            spcPopup("Customer", "cust_cd=" + cust_cd, 770, 470, "callbackPopupCustomer", "1,0,1,1,1,1,1,1");
            break;
        case "btn_popup_customerGrp":
            var customerGrp = formObject.customerGrp.value;
            spcPopup("CustomerGroup", "cust_grp_id=" + customerGrp, 770, 470, "callbackPopupCustomerGrp", "1,0,1,1,1,1,1,1");
            break;

        case "btn_directDown":
        	//20160211.ADD
            var param = "year=" + formObject.year.value;
            param = param + "&week=" + formObject.week.value;
            param = param + "&duration=" + formObject.duration.value;
            param = param + "&salesOffice=" + comObjects[3].GetSelectCode();
            ComOpenPopup("ESM_SPC_0105.do?"+param, 750, 300, "", "1,0", true, false); 
            break;

    } // end switch
    //}catch(e) {
    //	if( e == "[object Error]") {
    //		ComShowCodeMessage("COM12111");
    //	} else {
    //		ComShowMessage(e);
    //	}
    //}
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
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * tab1_OnChange 
 * 
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    for (var i = 0; i < objs.length; i++) {
        if (i != nItem) {
            objs[i].style.display = "none";
            objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
        }
    }
    beforetab = nItem;
    var formObject = document.form;
    var comObj = salesRep;
    var comObj1 = trade;
    var comObj2 = subTrade;
    var comObj3 = lane;
    if (beforetab == 0) {
        //SetEnable
        comObj.SetEnable(0); //.enable=false;
        comObj1.SetEnable(1); //.enable=true;
        comObj2.SetEnable(1); //.enable=true;
        comObj3.SetEnable(1); //.enable=true;
        formObject.year.disabled = false;
        formObject.week.disabled = false;
        formObject.duration.disabled = false;
        formObject.customer.disabled = true;
        formObject.bound.disabled = false;

        salesreppopup1.style.display = "none";
        accountpopup1.style.display = "none";
        accountpopup2.style.display = "none";
    } else if (beforetab == 1) {
        formObject.year.disabled = true;
        formObject.week.disabled = true;
        comObj.SetEnable(1); //.enable=true;
        comObj1.SetEnable(0); //.disabled=true;
        comObj2.SetEnable(0); //.disabled=true;
        comObj3.SetEnable(0); //.disabled=true;
        formObject.duration.disabled = true;
        formObject.customer.disabled = false;
        formObject.bound.disabled = true;

        salesreppopup1.style.display = "inline";
        accountpopup1.style.display = "inline";
        accountpopup2.style.display = "inline";
    }
    resizeSheet();
    if (!check_retrive) return;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
    optionSetting();
    tab_retrives = new Array(sheetObjects.length);
    var tdisp = "block";
    var objs = document.all.tabLayer;

    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        objs[i].style.display = "Inline";
        initSheet(sheetObjects[i], i + 1);
        objs[i].style.display = "none";
        ComEndConfigSheet(sheetObjects[i]);
        //initDataSelection(i);
    }
    // initDataSelection(0);
    //initDataSelection(1);

    //            var sheetResizeFull=true;
    //    		document_onresize();
    resizeSheet();

    for (var k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        //tabObjects[k].SetSelectedIndex(0);
    }

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

}

/**
 *Tab Basic setting
 *Setting items of tab
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem("By Office", "");
                InsertItem("By Account", "");
            }
            break;
    }
    tabObj.SetSelectedIndex(0);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt = 0;
    switch (sheetNo) {
        case 1: //sheet1 init
            initSheet1(sheetObj);
            break;
        case 2: //sheet1 init
            initSheet2(sheetObj);
            break;
        case 3: //sheet1 init
            initSheet3(sheetObj);
            break;
    }
}

/**
 * Changing title after retrieving TabSheet1
 */
var sheet1=new Object();
function initSheet1(sheetObj){
    with(sheetObj){
      var HeadTitle1="Trade|Sub\nTrade|Lane|BD|O/I/T|Office|Week|VVD|Date|POL|POD|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|lvl|cL1|cL2|cL3|";
      var HeadTitle2="Trade|Sub\nTrade|Lane|BD|O/I/T|Office|Week|VVD|Date|POL|POD|Total TEU|TEU|HC|45'|53'|RF|WT|TEU|HC|45'|53'|RF|WT|lvl|cL1|cL2|cL3|";
      var cnt=0;
      SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:100  } );
      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);
      var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sls_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_wk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bse_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	             {Type:"Text",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_teu_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_lod_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_40ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_45ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_53ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_rf_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"aloc_lod_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"aloc_40ft_hc_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"aloc_45ft_hc_qty",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"aloc_53ft_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"aloc_rf_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"aloc_ttl_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lvl",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0}, //, TreeCol:1 ,  LevelSaveName:"sLevel"
    	             {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL1",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL2",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"CheckBox", Hidden:1, Width:30,   Align:"Center",   ColMerge:0,   SaveName:"cL3",               KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);
      SetEditable(salesOffice.GetItemCount()==1);
      SetSheetHeight(ComGetSheetHeight(sheetObj,14));
      SetHeaderRowHeight(10);
      //InitTreeInfo("lvl", "", "#0000FFNAN");

	}
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
      //20160206.MOD
      var HeadTitle1="|Sub\nOffice|Sales Rep|Sales Rep|Modified Date(UTC)|Modified By|Account|Account|Account|Contract Number|Contract Customer|Contract Customer|POL|POD|";
      var HeadTitle2="|Sub\nOffice|CODE|NAME|Modified Date(UTC)|Modified By|TP|CODE|NAME|Contract Number|CODE|NAME|POL|POD|";
      var HeadTail="||||";				//20160211.ADD
      sheet2.masterColumnCount=HeadTitle1.split("|").length - 1;
      sheet2.forecastColumnCount=7;//5; //Total, TEU, hc, 45, 53, rf, wt
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
      //20160211.ADD
      HeadTitle1=HeadTitle1 + HeadTail;
      HeadTitle2=HeadTitle2 + HeadTail;
      var cnt=0;
      SetConfig( { SearchMode:2, DataRowMerge:0, MergeSheet:7, Page:100  } );
      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
      InitHeaders(headers, info);
      var cols = [   {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sub_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"srep_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"srep_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"modi_gdt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"modi_usr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fcast_cust_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	 			 //20160211.ADD start, 20160325.MOD
    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             //20160211.ADD end
    	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_teu_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_40ft_hc_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_45ft_hc_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_53ft_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"fcast_rf_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"fcast_ttl_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_ttl_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_20ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_40ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_40ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_45ft_hc_qty",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_53ft_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_rf_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Int",       Hidden:1,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"usd_bkg_ttl_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lvl",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0}, //, TreeCol:1 ,  LevelSaveName:"sLevel"
    	             {Type:"CheckBox",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cL1",                  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"CheckBox",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cL2",                  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"CheckBox",  Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cL3",                  KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);
      SetEditable(salesOffice.GetItemCount()==1);
      SetSheetHeight(ComGetSheetHeight(sheetObj,14));
      SetHeaderRowHeight(10);
      //InitTreeInfo("lvl", "", "#0000FFNAN");
      }
}

function t1sheet1_OnClick(sheetObj, row, col) {
    //        	switch(sheetObj.ColSaveName(col)){
    //            	case "pol_cd":
    //            	case "pod_cd":
    //            		var mark=t1sheet1.GetCellValue(row, col);
    //            		if(mark == "+"){
    //            			t1sheet1.SetRowExpanded(row,1);
    //            			t1sheet1.SetCellValue(row, col,"-",0);
    //            		}
    //            		else if(mark == "-"){
    //            			t1sheet1.SetRowExpanded(row,0);
    //            			t1sheet1.SetCellValue(row, col,"+",0);
    //            		}
    //            		break;
    //    		}
    switch (sheetObj.ColSaveName(col)) {
        case "pol_cd":
        case "pod_cd":
            var mark = sheetObj.GetCellValue(row, col);
            if (mark == "+") {
                //toggleExpand(sheetObj, row, col);
                var startRow = row + 1;
                var endRow = sheetObj.GetMergedEndCell(row, col - 1).split(",")[0];

                for (; startRow <= endRow; startRow++) {
                    sheetObj.SetRowHidden(startRow, 0);
                    if (sheetObj.ColSaveName(col) == "pol_cd" && sheetObj.GetCellValue(startRow, "pod_cd") == '+') {
                        startRow = sheetObj.GetMergedEndCell(startRow, "pol_cd").split(",")[0];
                    }
                }
                sheetObj.SetCellValue(row, col, "-", 0);

            } else if (mark == "-") {
                var startRow = row + 1;
                var endRow = sheetObj.GetMergedEndCell(row, col - 1).split(",")[0];
                for (; startRow <= endRow; startRow++) {
                    sheetObj.SetRowHidden(startRow, 1);
                }
                sheetObj.SetCellValue(row, col, "+", 0);
            }
            sheetObj.SetDataMerge();
            break;
    }
}

function t1sheet2_OnClick(sheetObj, row, col) {
    var csName = t1sheet2.ColSaveName(col);
    switch (csName) {
        case "pol_cd":
        case "pod_cd":

            //        		var mark=t1sheet2.GetCellValue(row, col);
            //        		if(mark == "+"){
            //        			t1sheet2.SetRowExpanded(row,1);
            //        			t1sheet2.SetCellValue(row, col,"-",0);
            //        		}
            //        		else if(mark == "-"){
            //        			t1sheet2.SetRowExpanded(row,0);
            //        			t1sheet2.SetCellValue(row, col,"+",0);
            //        		}
            //        		break;
            var mark = sheetObj.GetCellValue(row, col);
            if (mark == "+") {
                //toggleExpand(sheetObj, row, col);
                var startRow = row + 1;
                var endRow = sheetObj.GetMergedEndCell(csName == "pol_cd" ? row + 1 : row, csName == "pol_cd" ? col - 4 : col - 1).split(",")[0];

                for (; startRow <= endRow; startRow++) {
                    sheetObj.SetRowHidden(startRow, 0);
                    if (sheetObj.ColSaveName(col) == "pol_cd" && sheetObj.GetCellValue(startRow, "pod_cd") == '+') {
                        startRow = sheetObj.GetMergedEndCell(startRow, "pol_cd").split(",")[0];
                    }
                }
                sheetObj.SetCellValue(row, col, "-", 0);

            } else if (mark == "-") {
                var startRow = row + 1;
                var endRow = sheetObj.GetMergedEndCell(csName == "pol_cd" ? row + 1 : row, csName == "pol_cd" ? col - 4 : col - 1).split(",")[0];
                for (; startRow <= endRow; startRow++) {
                    sheetObj.SetRowHidden(startRow, 1);
                }
                sheetObj.SetCellValue(row, col, "+", 0);
            }
            sheetObj.SetDataMerge();
            break;
    }
}

function initDataSelection(sheetNo) {
    if (sheetNo == 0) {
        changeDataSelection1(document.getElementsByName("chkDs1OFC")[0], false);
        changeDataSelection1(document.getElementsByName("chkDs1POL")[0], false);
        changeDataSelection1(document.getElementsByName("chkDs1POD")[0], false);
        changeDataSelection1(document.getElementsByName("chkDs1HC")[0], false);
        changeDataSelection1(document.getElementsByName("chkDs145")[0], false);
        changeDataSelection1(document.getElementsByName("chkDs153")[0], false);
        changeDataSelection1(document.getElementsByName("chkDs1RF")[0], false);
        changeDataSelection1(document.getElementsByName("chkDs1WT")[0], false);
    }
    if (sheetNo == 1) {
        changeDataSelection(document.getElementsByName("chkDs2Account")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2OFC")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2POL")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2POD")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2HC")[0], false);
        changeDataSelection(document.getElementsByName("chkDs245")[0], false);
        changeDataSelection(document.getElementsByName("chkDs253")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2RF")[0], false);
        changeDataSelection(document.getElementsByName("chkDs2WT")[0], false);
    }
}

function changeDataSelection(tobj, internal) {
    if (internal == undefined || internal == null) {
        internal == false;
    }
    beforetab = 1;
    var sheetObj = sheetObjects[beforetab];
    var obj = null;
    //    		if(tobj == undefined || tobj == null){
    //    			tobj=null;
    //    			obj=event.srcElement;
    //    		}
    //    		else{
    obj = tobj;
    //    		}
    var sts = obj.checked;
    var hval = sts ? 0 : 1; //체크박스 언체크시 hidden

    switch (obj.name) {
        case "chkDs2Account":
            //    		    sheetObj.ShowTreeLevel(sts?2:1,0);
            sheetObj.SetColHidden("fcast_cust_tp_cd", !sts);
            sheetObj.SetColHidden("cust_cd", !sts);
            sheetObj.SetColHidden("cust_nm", !sts);
            sheetObj.SetColHidden("pol_cd", !sts);

            var iCheckRow1 = sheetObj.FindCheckedRow("cL2");
            var arrRow1 = iCheckRow1.split("|"); //2레벨 POL				
            for (var idx = 0; idx < arrRow1.length; idx++) {
                sheetObj.SetRowHidden(arrRow1[idx], hval);
            }

            if (!sts) { //접을때는 POD도 같이
                //    				document.all.ds2POD.checked=false;
                //        			changeDataSelection(document.all.ds2POD, true);
                //sheetObj.ShowTreeLevel(sts?2:1, 0);
                if (document.all.ds2POD.checked) {
                    document.all.ds2POD.checked = false;
                    sheetObj.SetColHidden("pod_cd", hval);
                }
                var iCheckRow = sheetObj.FindCheckedRow("cL3");
                var arrRow = iCheckRow.split("|"); //3레벨 POD
                for (var idx = 0; idx < arrRow.length; idx++) {
                    sheetObj.SetRowHidden(arrRow[idx], 1);
                }
            } else {
            	//History : POD도 선택사항이었으나 추후 무조건 보여주기로 수정.
                var dSts = document.all.ds2POD.checked;
                changeDataSelection(document.all.ds2POD, true);			//20160226.ADD

//                var iCheckRow = sheetObj.FindCheckedRow("cL3");		//20160226.DEL : 반복
//                var arrRow = iCheckRow.split("|"); //3레벨 POD
//                for (var idx = 0; idx < arrRow.length; idx++) {
//                    sheetObj.SetRowHidden(arrRow[idx], !dSts);
//                }
            }


            sheetObj.SetDataMerge();
            break;
        case "chkDs2OFC":
        case "chkDs2POL":
        case "chkDs2POD":
            //    		if(!internal){
            //    				if(!document.all.ds2Account.checked){
            //    					document.all.ds2Account.checked=true;
            //    					changeDataSelection(document.all.ds2Account, false);
            //    				}
            //    				//sheetObj.ShowTreeLevel(sts?3:2, 1);
            //    			}
            //    			sheetObj.SetColHidden("pod_cd",!sts);
            //    			if(sts){
            //    				ChangeValue(sheetObj, "pod_cd", "+", "pod_cd", "-");
            //    			}
            //    			ChangeValue(sheetObj, "pol_cd", "+", "pol_cd", "-");

            //펼칠때는 Accout/POL도 같이
            if (sts) {
                if (!document.all.chkDs2Account.checked) { //ds2Account->chkDs2Account
                    document.all.chkDs2Account.checked = true;
                    sheetObj.SetColHidden("fcast_cust_tp_cd", 0);
                    sheetObj.SetColHidden("cust_cd", 0);
                    sheetObj.SetColHidden("cust_nm", 0);
                    sheetObj.SetColHidden("pol_cd", 0);
                }
                var iCheckRow = sheetObj.FindCheckedRow("cL2");
                var arrRow = iCheckRow.split("|"); //2레벨 POL				
                for (var idx = 0; idx < arrRow.length; idx++) {
                    sheetObj.SetRowHidden(arrRow[idx], 0);
                }
            }

            var iCheckRow1 = sheetObj.FindCheckedRow("cL3");
            var arrRow1 = iCheckRow1.split("|"); //3레벨 POD	
            for (var idx = 0; idx < arrRow1.length; idx++) {
                sheetObj.SetRowHidden(arrRow1[idx], hval);
            }

            sheetObj.SetColHidden("pod_cd", hval);

            if (sts) {
                ChangeValue(sheetObj, "pod_cd", "+", "pod_cd", "-");
            }
            ChangeValue(sheetObj, "pol_cd", "+", "pol_cd", "-");
            sheetObj.SetDataMerge();
            break;

        case "chkDs2HC":
            // showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU
            if (document.form.chkDs2HC.checked || document.form.chkDs245.checked || document.form.chkDs253.checked)
                sheetObj.SetColHidden("fcast_ttl_qty", 0);
            else
                sheetObj.SetColHidden("fcast_ttl_qty", 1);
            sheetObj.SetColHidden("fcast_40ft_hc_qty", !sts);
            sheetObj.SetColHidden("usd_bkg_40ft_hc_qty", !sts);
            sheetObj.SetColHidden("aloc_40ft_hc_qty", !sts);
            break;
        case "chkDs245":
            // showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU
            if (document.form.chkDs2HC.checked || document.form.chkDs245.checked || document.form.chkDs253.checked)
                sheetObj.SetColHidden("fcast_ttl_qty", 0);
            else
                sheetObj.SetColHidden("fcast_ttl_qty", 1);
            sheetObj.SetColHidden("fcast_45ft_hc_qty", !sts);
            sheetObj.SetColHidden("usd_bkg_45ft_hc_qty", !sts);
            sheetObj.SetColHidden("aloc_45ft_hc_qty", !sts);
            break;
        case "chkDs253":
            // showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU
            if (document.form.chkDs2HC.checked || document.form.chkDs245.checked || document.form.chkDs253.checked)
                sheetObj.SetColHidden("fcast_ttl_qty", 0);
            else
                sheetObj.SetColHidden("fcast_ttl_qty", 1);
            sheetObj.SetColHidden("fcast_53ft_qty", !sts);
            sheetObj.SetColHidden("usd_bkg_53ft_qty", !sts);
            sheetObj.SetColHidden("aloc_53ft_qty", !sts);
            break;
        case "chkDs2RF":
            sheetObj.SetColHidden("fcast_rf_qty", !sts);
            sheetObj.SetColHidden("usd_bkg_rf_qty", !sts);
            sheetObj.SetColHidden("aloc_rf_qty", !sts);
            break;
        case "chkDs2WT":
            sheetObj.SetColHidden("fcast_ttl_wgt", !sts);
            sheetObj.SetColHidden("usd_bkg_ttl_wgt", !sts);
            sheetObj.SetColHidden("aloc_ttl_wgt", !sts);
            break;
    }
}

function changeDataSelection1(tobj, internal) {
    if (internal == undefined || internal == null) {
        internal == false;
    }
    beforetab = 0;
    var sheetObj = sheetObjects[beforetab];
    var obj = null;
    if (tobj == undefined || tobj == null) {
        tobj = null;
        obj = event.srcElement;
    } else {
        obj = tobj;
    }
    var sts = obj.checked;

    sheetObj = t1sheet1;
    switch (ComGetEvent("name")) {
        case "chkDs1OFC":
        case "chkDs1POL":
        case "chkDs1POD":
            _controlTree(t1sheet1);
            break;
        case "chkDs1HC":
            sheetObj.SetColHidden("aloc_40ft_hc_qty", !sts);
            // showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU
            if (document.form.chkDs1HC.checked || document.form.chkDs145.checked || document.form.chkDs153.checked)
                sheetObj.SetColHidden("fcast_lod_qty", 0);
            else
                sheetObj.SetColHidden("fcast_lod_qty", 1);
            sheetObj.SetColHidden("fcast_40ft_hc_qty", !sts);
            break;
        case "chkDs145":
            sheetObj.SetColHidden("aloc_45ft_hc_qty", !sts);
            // showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU.
            if (document.form.chkDs1HC.checked || document.form.chkDs145.checked || document.form.chkDs153.checked)
                sheetObj.SetColHidden("fcast_lod_qty", 0);
            else
                sheetObj.SetColHidden("fcast_lod_qty", 1);
            sheetObj.SetColHidden("fcast_45ft_hc_qty", !sts);
            break;
        case "chkDs153":
            sheetObj.SetColHidden("aloc_53ft_qty", !sts);
            // showing TEU in case of checking  HC, 45, 53 according to Adding Total TEU.
            if (document.form.chkDs1HC.checked || document.form.chkDs145.checked || document.form.chkDs153.checked)
                sheetObj.SetColHidden("fcast_lod_qty", 0);
            else
                sheetObj.SetColHidden("fcast_lod_qty", 1);
            sheetObj.SetColHidden("fcast_53ft_qty", !sts);
            break;
        case "chkDs1RF":
            sheetObj.SetColHidden("aloc_rf_qty", !sts);
            sheetObj.SetColHidden("fcast_rf_qty", !sts);
            break;
        case "chkDs1WT":
            sheetObj.SetColHidden("aloc_ttl_wgt", !sts);
            sheetObj.SetColHidden("fcast_ttl_wgt", !sts);
            break;
    }
}

function _controlTree(sheetObj) {

    var formObj = document.form;

    var sts1 = true;
    var sts2 = formObj.chkDs1POL.checked;
    var sts3 = formObj.chkDs1POD.checked;
    with(sheetObj) {
        //	log("sheetobj" + sheetObj);
        //ShowTreeLevel(sts3?3:(sts2?2:1));
        if (sts2) {
            _ChangeValue(sheetObj, "lvl", "1", "pol_cd", "-");
        }
        if (sts3) {
            _ChangeValue(sheetObj, "lvl", "2", "pod_cd", "-");
        }

        if (!sts1) _HideRow(sheetObj, "lvl", 1);
        if (sts1) _ShowRow(sheetObj, "lvl", 1); //
        if (!sts2) _HideRow(sheetObj, "lvl", 2);
        if (sts2) _ShowRow(sheetObj, "lvl", 2); //
        if (!sts3) _HideRow(sheetObj, "lvl", 3);
        if (sts3) _ShowRow(sheetObj, "lvl", 3); //
        SetColHidden("pod_cd", !sts3);
        SetColHidden("pol_cd", !sts2 && !sts3);
    }
    return true;
}

function _ShowRow(sheetObj, col, val) {
    with(sheetObj) {
        var iCheckRow = sheetObj.FindCheckedRow(val == 1 ? "cL1" : (val == 2 ? "cL2" : "cL3"));
        var arrRow = iCheckRow.split("|");
        for (var idx = 0; idx < arrRow.length; idx++) {
            sheetObj.SetRowHidden(arrRow[idx], 0);
        }
        //        		var frow=-1;
        //        		while((frow=FindText(col, val, frow + 1)) >= 0){
        //        			SetRowHidden(frow,0);
        //        		}
    }
}

function _HideRow(sheetObj, col, val) {

    with(sheetObj) {
        var iCheckRow = sheetObj.FindCheckedRow(val == 1 ? "cL1" : (val == 2 ? "cL2" : "cL3"));
        var arrRow = iCheckRow.split("|");
        for (var idx = 0; idx < arrRow.length; idx++) {
            sheetObj.SetRowHidden(arrRow[idx], 1);
        }

        //        		var frow=-1;
        //        		while((frow=FindText(col, val, frow + 1)) >= 0){
        //        			SetRowHidden(frow,1);
        //        		}
    }
}


function _ChangeValue(sheetObj, col, val, sCol, sVal) {
    with(sheetObj) {
        var frow = -1;
        while ((frow = FindText(col, val, frow + 1)) >= 0) {
            SetCellValue(frow, sCol, sVal, 0);
        }
    }
}

var searchSalesRep = new Array();
//Handling the process related with Sheet

function doActionIBSheet(sheetObj, formObj, sAction, quite) {
    if (quite == undefined) quite = false;
    sheetObj.ShowDebugMsg(false);
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
            param = param + "&salesOffice=" + comObjects[3].GetSelectCode();
            param = param + "&subOffice=" + comObjects[4].GetSelectCode();
            param = param + "&salesRep=" + comObjects[5].GetSelectCode();
            param = param + "&customer=" + formObj.customer.value;
            searchParams = param;
            if (beforetab == 0) {
                searchByOffice(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                if (sheetObj.RowCount() > 0) {
                    sheetObj.RenderSheet(0);
                    _controlTree(sheetObj);
                    sheetObj.SetDataMerge();
                    sheetObj.RenderSheet(1);
                }

            } else if (beforetab == 1) {            	
                searchByAccount(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                if (sheetObj.RowCount() > 0) {
                    sheetObj.RenderSheet(0);
                    changeDataSelection(document.all.chkDs2Account, false); //ds2Account ->chkDs2Account
                    sheetObj.SetDataMerge();
                    sheetObj.RenderSheet(1);
                }
            }
            break;
        case IBDOWNEXCEL: //Excel download
            sheetObj.Down2Excel({
                DownCols: makeHiddenSkipCol(sheetObj),
                SheetDesign: 1,
                Merge: 1,
                ExcelFontSize: 9
            });
            break;
    }
}

function searchByOffice(sheetObj, formObj, command) {
    if (tab_retrives[beforetab]) return;
    //     		var rtn = sheetObj.DoSearch("ESM_SPC_0104GS.do", "f_cmd="+command+"&"+searchParams );
    var rtn = sheetObj.GetSearchData("ESM_SPC_0104GS.do", "f_cmd=" + command + "&" + searchParams);
    if (ComGetTotalRows(rtn) > 0) {
        sheetObj.RenderSheet(0);
        sheetObj.LoadSearchData(rtn, {
            Sync: 1
        });
        sheetObj.RenderSheet(1);
    } else {
        sheetObj.LoadSearchData(rtn, {
            Sync: 1
        });
    }

    tab_retrives[beforetab] = true;
}

function searchByAccount(sheetObj, formObj, command) {
    if (tab_retrives[beforetab]) return;
    //     		var rtn = sheetObj.DoSearch("ESM_SPC_0104GS.do", "f_cmd="+command+"&"+searchParams );
    var rtn = sheetObj.GetSearchData("ESM_SPC_0104GS.do", "f_cmd=" + command + "&" + searchParams);
    if (ComGetTotalRows(rtn) > 0) {
        sheetObj.RenderSheet(0);
        sheetObj.LoadSearchData(rtn, {
            Sync: 1
        });
        sheetObj.RenderSheet(1);
    } else {
        sheetObj.LoadSearchData(rtn, {
            Sync: 1
        });
    }

    tab_retrives[beforetab] = true;
}

function t1sheet2_OnSelectCell(sheetObj, orow, ocol, row, col) {
    selectedCell_OldValue = sheetObj.GetCellValue(row, col) * 1;
}

function t1sheet1_OnChange(sheetObj, row, col, value) {}

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
        SpcSearchOptionSubTrade("subTrade", true, false, "", formObj.trade.value); // 0207 SHKIM			
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subTrade.value, true); // 0207 SHKIM
    }


}


function subTrade_OnChange(combj, value, text) {
    if (value == "") return;
    if (document.all.vvd.value != "") return;

    var formObj = document.form;
    var subTrade = formObj.subTrade.value;

    if (subTrade != null && subTrade != '') {
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subTrade.value, true); // 0207 SHKIM
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
        //no support[check again]CLT 	        ShowCol=0;
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
        //no support[check again]CLT 	        ShowCol=0;
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
        //no support[check again]CLT 	        ShowCol=0;
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
            if (beforetab == 0) {
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
            } else if (beforetab == 1) {
                if (vvd = "" || vvd.length < 9) {
                    ComShowCodeMessage("COM12174", "VVD", "9");
                    formObj.vvd.focus();
                    return false;
                } else if (office == "") {
                    ComShowMessage(getMsg("SPC90114", "Office"));
                    comObjects[3].Focus();
                    return false;
                }
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