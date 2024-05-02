/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_00089.js
*@FileTitle  : Representative Commodity
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_SAQ_00089 : business script for ESM_SAQ_00089
 */
function ESM_SAQ_00089() {
    this.processButtonClick = tprocessButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}

// global variable
var tabObjects = new Array();
var tabCnt = 0;
var currentTabIndex = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
// Target Group Combo
var comObjects = new Array();
var comboCnt = 0;
var targetGroup = "";
var curr_tgt_orz_cd = "R";
// search tab variable
var tabSearchParams = "";
var tabChildSearchParams = ["", "", "", "", ""];
//Event handler processing by button click event */
document.onclick = processButtonClick;

//Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[currentTabIndex];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve":
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;
            case "btn_print":
                ComShowMessage("btng_print");
                break;
            case "btn_downexcel":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }

                break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e.message);
        }
    }
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
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setComboObject(combo_obj) {
    comObjects[comboCnt++] = combo_obj;
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    optionSetting();
    // year month setting (NOW +2 month)
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.bse_quarter);
    // Org setting
    setOfcTo4thParentOffice(document.form.ofcCd);
    var sheetResizeFull = true;
    var objs = document.all.tabLayer;
    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        objs[i].style.display = "Inline";
        initSheet(sheetObjects[i], i + 1);
        objs[i].style.display = "None";
        ComEndConfigSheet(sheetObjects[i]);
    }
    objs[0].style.display = "Inline";
    for (var k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    // item defalut setting
    for (var k = 0; k < comboCnt; k++) {
        if (comObjects[k].options.id == "targetGrp")
            continue;
        comObjects[k].SetSelectText(0, "ALL");
    }
    resizeSheet();
}

function resizeSheet() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComResizeSheet(sheetObjects[i]);
    }
}

// Org setting
function setOfcTo4thParentOffice(objOrg) {
    var vl = getCodeList("OfcTo4thParentOffice", "ofc_cd=" + objOrg.value);
    if (vl != "") {
        var code = vl[0].split("|");
        objOrg.value = code[0];
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var year=document.form.year.value;
	switch(sheetNo) {
		case 1: // tradeGroupSheet sheet init
			with(sheetObj){
				changeSheetHead(sheetObj, sheetNo, "init");
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
				var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
				var headers = [ ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				for (i=0; i<=3; i++) {
					cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				}
				cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				
				InitColumns(cols);
				SetEditable(0);
				//		 		      SetSheetHeight(436);
			}
			break;
		case 2: // laneSheet sheet init
			with(sheetObj){
				changeSheetHead(sheetObj, sheetNo, "init");
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
				var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
				var headers = [ ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dir",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				for (i=0; i<=3; i++) {
					cols.push({Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				}
				cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				
				InitColumns(cols);
				SetEditable(0);
				//	 		      SetSheetHeight(436);
			}
			break;
		case 3: //cOffice
			with(sheetObj){
				changeSheetHead(sheetObj, sheetNo, "init");
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 , PrevColumnMergeMode:0} );
				var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
				var headers = [ ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvdgcd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				InitColumns(cols);
				SetEditable(0);
				//		 		      SetSheetHeight(407);
			}
			break;
	} // end swich    
}

// handling process after ending sheet1 retrieve
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            if (tabSearchParams != "" && tabSearchParams != searchKeyQueryString(formObj)) {
                for (i = 0; i < sheetObjects.length; i++) {
                    sheetObjects[i].RemoveAll();
                }
            }
            var f_cmd = "";
            if (currentTabIndex == 0) {
                // Target Group retrieve
                f_cmd = "&f_cmd=" + SEARCHLIST01;
            } else if (currentTabIndex == 1) {
                // Lane retrieve
                f_cmd = "&f_cmd=" + SEARCHLIST02;
            } else if (currentTabIndex == 2) {
                // C.Office retrieve
                f_cmd = "&f_cmd=" + SEARCHLIST04;
            }
            if (validateForm(sheetObj, formObj, sAction) == false) {
                break;
            }
            tabSearchParams = searchKeyQueryString(formObj);
            tabChildSearchParams[currentTabIndex] = searchTabQueryString(formObj);
            // retrieve
            sheetObj.DoSearch("ESM_SAQ_0089GS.do", f_cmd + searchTabQueryString(formObj));
            //sheetObj.ShowTreeLevel(2);
            //changing HEADER
            changeSheetHead(sheetObj, currentTabIndex + 1);
            break;
        case IBDOWNEXCEL: //excel download
            selectDownExcelMethod(sheetObj);
            break;
    }
}

/**
 * Down Excel 팝업창 이후 값을 받아서 타입을 리턴함
 *
 * excelType
 * AY - 전체 데이터를 Format 적용해서 down 받는 경우
 * DY - 화면에 보이는 데로 Format 적용해서 down 받는 경우
 * AN - 전체 데이터를 Format 적용하지 않고 down 받는 경우
 * DN - 화면에 보이는 데로 Format 적용하지 않고 down 받는 경우
 */
function callBackExcelMethod(excelType) {
    var sheetObj;
    sheetObj = sheetObjects[currentTabIndex];
    DownExcel(sheetObj, excelType);
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
    tabObjects[tabCnt++] = tab_obj;
}

/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
    switch (tabNo) {
        case 1:
            with(tabObj) {
                var cnt = 0;
                InsertItem(" Target Group/Trade/Sub Trade ", "");
                InsertItem("     Lane      ", "");
                InsertItem(" Lane/Office - Weekly ", "");
            }
            break;
    }
}

/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    var beforetab = currentTabIndex;
    objs[beforetab].style.display = "none";
    for (var i = 0; i < objs.length; i++) {
        if (i != nItem) {
            objs[i].style.display = "none";
            objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
        }
    }
    currentTabIndex = nItem;
    resizeSheet();
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    // 		with(formObj){
    if (ComIsNull(formObj.ofcCd)) {
        ComShowCodeMessage("COM12113", "Org.");
        return false;
    }
    if (ComIsNull(formObj.year)) {
        ComShowCodeMessage("COM12113", "Year");
        return false;
    }
    if (ComIsNull(formObj.bse_quarter)) {
        ComShowCodeMessage("COM12113", "Month");
        return false;
    }
    if (targetGrp.GetSelectCode() == '') {
        ComShowCodeMessage("COM12113", "Target Group");
        return false;
    }
    if (ComIsNull(formObj.version)) {
        ComShowCodeMessage("COM12113", "Version");
        return false;
    }
    if (tgtOrzCd.GetSelectCode() == '') {
        ComShowCodeMessage("COM12113", "Status");
        tgtOrzCd.Focus();
        return false;
    }
    switch (currentTabIndex) {
        case 0:
            if (getItem_parameter(item01) == "ALL:") {
                ComShowCodeMessage("COM12113", "Item");
                return false;
            }
            break;
        case 1:
            if (ComIsNull(formObj.trade02)) {
                ComShowCodeMessage("COM12113", "Trade");
                return false;
            }
            if (getItem_parameter(item02) == "ALL:") {
                ComShowCodeMessage("COM12113", "Item");
                return false;
            }
            break;
        case 2:
            if (ComIsNull(formObj.trade04)) {
                ComShowCodeMessage("COM12113", "Trade");
                return false;
            }
            if (ComIsNull(formObj.dirCd04)) {
                ComShowCodeMessage("COM12113", "Bound");
                return false;
            }
            if (ComIsNull(formObj.from_wk04)) {
                ComShowCodeMessage("COM12113", "Duration(Week)");
                return false;
            }
            if (getItem_parameter(item04) == "ALL:") {
                ComShowCodeMessage("COM12113", "Item");
                return false;
            }
            break;
            // 	        } // switch end
    } // with end
    return true;
}

function searchKeyQueryString(formObj) {
    var query = "";
    var v_tgtOrzCd = tgtOrzCd.GetSelectCode();
    var version = formObj.version.value;
    version = version.split("-");

    var mstVersion = version[0];
    var glineVerNo = version[1];
    var a_tgtOrzCd = v_tgtOrzCd.split("-");


    var datCreStepCd = a_tgtOrzCd[0];
    var p_tgtOrzCd = a_tgtOrzCd[1];

    query += "&ofcCd=" + formObj.ofcCd.value;
    query += "&year=" + formObj.year.value;
    query += "&bse_quarter=" + formObj.bse_quarter.value;
    query += "&targetGrp=" + targetGroup;
    query += "&unit=" + formObj.unit.value;
    query += "&version=" + glineVerNo;
    query += "&mstVersion=" + mstVersion;
    query += "&datCreStepCd=" + datCreStepCd;
    query += "&tgtOrzCd=" + p_tgtOrzCd;
    return query;
}

function searchTabQueryString(formObj) {
    var queryString = searchKeyQueryString(formObj);
    switch (currentTabIndex) {
        case 0: // targetGroup
            queryString = queryString + "&trade=" + formObj.trade01.value + "&dirCd=" + formObj.dirCd01.value + "&item=" + getItem_parameter(item01);
            break;
        case 1: // lane
            queryString = queryString + "&trade=" + formObj.trade02.value + "&dirCd=" + formObj.dirCd02.value + "&item=" + getItem_parameter(item02);
            break;
        case 2: // cOffice
            var from_wk = formObj.from_wk04.value;
            var to_wk = formObj.to_wk04.value;
            from_wk = from_wk.split("|")[0];
            to_wk = to_wk.split("|")[0];
            queryString = queryString + "&trade=" + formObj.trade04.value + "&dirCd=" + formObj.dirCd04.value + "&subTrade=" + formObj.subTrade04.value + "&rlaneCd=" + lane04.GetSelectCode() + "&item=" + getItem_parameter(item04) + "&from_wk=" + from_wk + "&to_wk=" + to_wk;
            break;
    } // end switch
    return queryString;
}

/*
 *  Item Parameter
 */
function getItem_parameter(comObj) {
    var code = comObj.GetSelectCode().split(",");
    var param = "";
    for (var i = 0; i < code.length; i++) {
        param = param + comObj.GetText(code[i], 1) + ":";
    }
    return param;
}

/*
 *  Target Group change
 */
function targetGrp_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    // 	    targetGroup = comboObj.GetText(parseInt(newIndex), 0);
    targetGroup = comboObj.GetSelectCode();
    version_change();
    trade_change();
}

/*
 * setting versrion when Year / Target Group changed
 */
function version_change() {
    var obj = document.form.version;
    var stage = document.form.stage.value;

//    if (document.form.stage[0].checked) {
//        stage = document.form.stage[0].value; 
//    } else {
//        stage = document.form.stage[1].value;
//    }
    var params = "year=" + document.form.year.value + "&bse_qtr_cd=" + form.bse_quarter.value + "&targetGrp=" + targetGroup + "&tgt_orz_cd=" + curr_tgt_orz_cd + "&tgt_ofc_cd1=" + document.form.ofcCd.value + "&tgt_ofc_cd2=" + document.form.ofcCd.value + "&stage=" + stage;
    getSelectCodeList(obj, "SaqSmryHdrMstVersion", params);
    tgtOrzCd_change();
}

function tgtOrzCd_change() {
    // 		var comboObj=document.getElementById("tgtOrzCd");
    var comboObj = tgtOrzCd;
    var version = document.form.version.value;
    version = version.split("-");
    var mstVersion = version[0];
    var glineVerNo = version[1];
    var stage = document.form.stage.value;
    
//    if (document.form.stage[0].checked) {
//        stage = document.form.stage[0].value;
//    } else {
//        stage = document.form.stage[1].value;
//    }
    var params = "year=" + document.form.year.value + "&bse_qtr_cd=" + form.bse_quarter.value + "&targetGrp=" + targetGroup + "&tgt_orz_cd=" + curr_tgt_orz_cd + "&qta_mst_ver_no=" + mstVersion + "&tgt_ofc_cd1=" + document.form.ofcCd.value + "&tgt_ofc_cd2=" + document.form.ofcCd.value + "&stage=" + stage;
    getComboCodeList(comboObj, "MonthlyTgtOrzCd", params);
}

/*
 * Trade setting when Target Group changing
 */
function trade_change() {
    var params = "targetGrp=" + targetGroup;
    getSelectCodeList(document.form.trade01, "SaqTagetGroupTrade", params, true);
    document.form.trade01.options[document.form.trade01.options.length] = new Option('ALL', '');
    document.form.trade01.value = "";
    getSelectCodeList(document.form.trade02, "SaqTagetGroupTrade", params, true);
    getSelectCodeList(document.form.trade04, "SaqTagetGroupTrade", params, true);
    trade04_OnChange();
}

function trade04_OnChange() {
    subTrade_change('L2');
    fromAndToWK_change('L2');
    SaqSearchOptionLane("lane04", true, false, 'Y', document.form.trade04.value);
}

/*
 * Trade setting when Trade changing
 */
function subTrade_change(office) {
    var subTradeObj;
    var params;
    if (office == "L2") {
        subTradeObj = document.form.subTrade04;
        params = "targetGrp=" + targetGroup + "&trade=" + document.form.trade04.value + "&dirCd=" + document.form.dirCd04.value;
    }
    getSelectCodeList(subTradeObj, "SaqTagetGroupSubTrade", params, true, new Option("ALL", ""));
}

function tgtOrzCd_OnChange(value, text) {
    fromAndToWK_change("L2");
}

function clearSelectOption(obj, option) {
    var opts = obj.options;
    for (var i = (opts == null ? 0 : opts.length); i >= 0; i--) {
        opts.remove(i);
    }
    if (option != undefined && option.nodeName == "OPTION") {
        obj.options[0] = option;
    }
}

function changeWeekText(office) {
    var from_wk;
    var to_wk;
    var formObj = document.form;
    var div_name;
    if (office == "L2") {
        div_name = "week_text04"
        from_wk = formObj.from_wk04.value;
        to_wk = formObj.to_wk04.value;
    }
    var objs = document.getElementById(div_name);
    if (from_wk == "" || to_wk == "") {
        objs.innerHTML = "";
    } else {
        var fromDate = from_wk.split("|")[1];
        var toDate = to_wk.split("|")[2];
        objs.innerHTML = "(" + fromDate + "~" + toDate + ")";
    }
}

function dirCd_change(office) {
    fromAndToWK_change(office);
}

function week_onChange(office) {
    changeWeekText(office);
}

/*
 * from week, to week set
 */
function fromAndToWK_change(office) {
    var fromObj;
    var toObj;
    var params;
    var formObj = document.form;
    var year = formObj.year.value;
    var bse_quarter = formObj.bse_quarter.value;
    var version = formObj.version.value;
    var tgt_orz_cd = tgtOrzCd.GetSelectCode();
    var trade = "";
    var dircd = "";
    if (office == "L2") { // weekly
        trade = formObj.trade04.value;
        dircd = formObj.dirCd04.value;
        fromObj = formObj.from_wk04;
        toObj = formObj.to_wk04;
    }
    if (year != "" && bse_quarter != "" && version != "" && trade != "" && dircd != "" && tgt_orz_cd != "") {
        version = version.split("-");
        var mstVersion = version[0];
        var glineVerNo = version[1];
        tgt_orz_cd = tgt_orz_cd.split("-");
        var dat_cre_step_cd = tgt_orz_cd[0];
        var tgt_orz_cd = tgt_orz_cd[1];
        params = "qta_mst_ver_no=" + mstVersion + "&bse_yr=" + year + "&bse_qtr_cd=" + bse_quarter + "&trd_cd=" + trade + "&dir_cd=" + dircd + "&dat_cre_step_cd=" + dat_cre_step_cd + "&tgt_orz_cd=" + tgt_orz_cd;
        getSelectCodeList(fromObj, "SaqMonQtaAdjSmryWeek", params, true);
        getSelectCodeList(toObj, "SaqMonQtaAdjSmryWeek", params, false);
    } else {
        clearSelectOption(fromObj);
        clearSelectOption(toObj);
    }
    changeWeekText(office)
}

// 	/*
// 	 * tradeGroupSheet Tree Double Click Event
// 	 */
// 	function tradeGroupSheet_OnDblClick(sheetObj, Row, Col) {
// 		common_tree_DblClick(sheetObj, Row, Col);
// 	}
// 	/*
// 	 * laneSheet Tree Double Click Event
// 	 */
// 	function laneSheet_OnDblClick(sheetObj, Row, Col) {
// 		common_tree_DblClick(sheetObj, Row, Col);
// 	}

/*
 * lOfficeSheet Tree Double Click Event
 */
function lOfficeSheet2_OnDblClick(sheetObj, Row, Col) {
    // 		common_tree_DblClick(sheetObj, Row, Col);
    vvdgcd_popUp(sheetObj, Row, Col);
}

/**
 * Sheet Head Setting
 */
function changeSheetHead(sheetObj, sheetNo, gubun) {
    var year = document.form.year.value;
    var month = getQuarterToMonth(document.form.bse_quarter.value);
    var years = [year, year, year];
    var months = [month, month + 1, month + 2];
    for (var i = 0; i < months.length; i++) {
        if (months[i] == 13) {
            years[i] = eval(year) + 1;
            months[i] = 1;
        } else if (months[i] == 14) {
            years[i] = eval(year) + 1;
            months[i] = 2;
        }
        if (months[i] < 10) {
            months[i] = "0" + months[i];
        }
    }
    var i, j = 0;
    with(sheetObj) {
        // 	        InitHeadMode(true, true, false, true, false, false)
        var HeadTitle1 = "";
        if (sheetNo == 1) {
            HeadTitle1 = "Trade|Bound|Sub Trade|Item|Quarter\nTotal|";
        } else if (sheetNo == 2) {
            HeadTitle1 = "Bound|Sub Trade|Lane|Item|Quarter\nTotal|";
        } else if (sheetNo == 3) {
            HeadTitle1 = "Week|Sub Trade|Lane|VVD Group|VVD|Item|Quota|";
        }
        if (sheetNo != 3) {
            for (var i = 0; i < 3; i++) {
                HeadTitle1 = HeadTitle1 + years[i] + "." + months[i] + "|";
            }
        }

        if (gubun == "init") {
            var headers = [{
                Text: HeadTitle1,
                Align: "Center"
            }];
            var info = {
                Sort: 0,
                ColMove: 1,
                ColResize: 1,
                HeaderCheck: 1
            };
            sheetObj.InitHeaders(headers, info);
        } else {
            changeHeaderRow(sheetObj, 0, HeadTitle1);
        }


    }
}

function lOfficeSheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    vvdgcd_cur_chng(sheetObj, Button, Shift, X, Y);
}

function ltSheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    vvdgcd_cur_chng(sheetObj, Button, Shift, X, Y);
}

function vvdgcd_popUp(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "vvdgcd" && sheetObj.GetCellValue(row, col).substring(0, 5) != "TOTAL") {
        var params = "&bse_yr=" + formObj.year.value + "&bse_qtr_cd=" + formObj.bse_quarter.value + "&rlane_cd=" + sheetObj.GetCellValue(row, col).substring(0, 5) + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, col).substring(6, 7) + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, col).substring(7, 9);
        switch (currentTabIndex) {
            case 2:
                params = params + "&trd_cd=" + formObj.trade04.value + "&dir_cd=" + formObj.dirCd04.value;
                break;
        };
        var width = 600;
        var height = 450;
        var callback = "callbackRemark";
        ComOpenPopup("/opuscntr/ESM_SAQ_0116.do?" + params, width, height, callback, "0,0", true);
    }
}

function vvdgcd_cur_chng(sheetObj, Button, Shift, X, Y) {
    var col = sheetObj.MouseCol();
    var row = sheetObj.MouseRow();
    var cursor = "Default";
    if ((sheetObj.ColSaveName(col) == "vvdgcd" && sheetObj.GetCellValue(row, col) > "") &&
        (sheetObj.GetCellValue(row, col).substring(0, 5) != "TOTAL")) {
        cursor = "Hand";
    }
    sheetObj.SetMousePointer(cursor);
}

function item01_OnCheckClick(comboObj, index, code) {
    SaqAllChkMultiCombo(comboObj, index);
}

function item02_OnCheckClick(comboObj, index, code) {
    SaqAllChkMultiCombo(comboObj, index);
}

function item04_OnCheckClick(comboObj, index, code) {
    SaqAllChkMultiCombo(comboObj, index);
}

function getSelectText(comboObj) {
    var mText = "";
    var curCode = comboObj.GetSelectCode();
    if (curCode == undefined || curCode == null || curCode == "")
        return "";
    var arrCode = curCode.split("|");
    if (arrCode == null)
        return "";
    for (var i = 0; i < arrCode.length; i++) {
        mText += comboObj.GetText(i, 1) + "|";
    }
    return mText.replace(/\|$/, '');
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_quarter");
    SaqSearchOptionTargetGroup("targetGrp");
    SaqSearchOptionComCode("unit", "CD00897", false);
    SaqSearchOptionBound("dirCd01");
    SaqSearchOptionComCodeMulti("item01", "CD01061", true, true, 8, "type2");
    SaqSearchOptionBound("dirCd02");
    SaqSearchOptionComCodeMulti("item02", "CD01061", true, true, 8, "type2");
    SaqSearchOptionBound("dirCd04", false);
    SaqSearchOptionLane("lane04");
    SaqSearchOptionComCodeMulti("item04", "CD01061", true, true, 8, "type2");
}