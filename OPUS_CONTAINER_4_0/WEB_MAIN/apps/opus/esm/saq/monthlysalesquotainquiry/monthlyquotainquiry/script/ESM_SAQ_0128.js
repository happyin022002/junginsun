/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0128.js
*@FileTitle  : Regional Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
/**
 * @extends
 * @class ESM_SAQ_0128 : business script for ESM_SAQ_0128
 */
var tabObjects = new Array();
var tabCnt = 0;
var currentTabIndex = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comObjects = new Array();
var comboCnt = 0;
var targetGroup = "";
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
    // Org setting
    setOfcTo4thParentOffice(document.form.ofcCd);
    var sheetResizeFull = true;
    var objs = document.all.tabLayer;
    var formObj = document.form;
    setYearMonthObjectByRelease(formObj.year, formObj.quarter);
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
    }
    // item defalut setting
    for (var k = 0; k < comboCnt; k++) {
        comObjects[k].SetSelectText("ALL");
    }
    resizeSheet();
    version_change();
    document.form.year.focus();
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var year=document.form.year.value;
	switch(sheetNo) {
		case 1: // Total sheet init
			with(sheetObj){
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
				changeSheetHead(sheetObj, sheetNo,"init");
				var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tgt_grp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				for (i=0; i<=3; i++) {
					cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
				}
				cols.push({Type:"Text",      Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
				InitColumns(cols);
				SetEditable(0);
				//SetSheetHeight(446);
			}
			break;
	
		case 2: // tradeGroupSheet sheet init
			with(sheetObj){
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
				changeSheetHead(sheetObj, sheetNo,"init");
				var cols = [ {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				for (i=0; i<=3; i++) {
					cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
				}
				cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0});
				InitColumns(cols);
				SetEditable(0);
				//SetSheetHeight(436);
			}
			break;
	
		case 3: // laneSheet sheet init
			with(sheetObj){
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
				changeSheetHead(sheetObj, sheetNo,"init");
				var cols = [ {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				
				for (i=0; i<=3; i++) {
					cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
				}
				cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				InitColumns(cols);
				SetEditable(0);
				//SetSheetHeight(436);
			}
			break;
	
		case 4: //cOffice
			with(sheetObj){
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 , PrevColumnMergeMode:0} );
				changeSheetHead(sheetObj, sheetNo,"init");
	
				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvdgcd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				];
				cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				InitColumns(cols);
				SetEditable(0);
				//SetSheetHeight(407);
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
            if (validateForm(sheetObj, formObj, sAction) == false) {
                break;
            }

            var f_cmd = "";
            var f_url = "";
            if (currentTabIndex == 0) {
                // Target Group retrieve
                f_cmd = "&f_cmd=" + SEARCHLIST10;
                f_url = "ESM_SAQ_0128GS10.do";
            } else if (currentTabIndex == 1) {
                // Target Group retrieve
                f_cmd = "&f_cmd=" + SEARCHLIST01;
                f_url = "ESM_SAQ_0128GS01.do";
            } else if (currentTabIndex == 2) {
                // Lane retrieve
                f_cmd = "&f_cmd=" + SEARCHLIST02;
                f_url = "ESM_SAQ_0128GS02.do";
            } else if (currentTabIndex == 3) {
                // C.Office retrieve
                f_cmd = "&f_cmd=" + SEARCHLIST03;
                f_url = "ESM_SAQ_0128GS03.do";
            }
            ComOpenWait(true);
            tabSearchParams = searchKeyQueryString(formObj);
            tabChildSearchParams[currentTabIndex] = searchTabQueryString(formObj);
            var sXml = sheetObj.GetSearchData(f_url, f_cmd + searchTabQueryString(formObj));
            if (sXml != "") sheetObj.LoadSearchData(sXml, { sync: 1 });

            changeSheetHead(sheetObj, currentTabIndex + 1);
            ComOpenWait(false);
            break;
        case IBDOWNEXCEL: //excel download
            selectDownExcelMethod(sheetObj);
            break;
    }
}

function callBackExcelMethod(excelType) {
    var sheetObj = sheetObjects[currentTabIndex];
    if (sheetObj.RowCount() < 1) { //no data
        ComShowCodeMessage("COM132501");
        return;
    }
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
                InsertItem("   Total   ", "");
                InsertItem(" Target Group/Trade/Sub Trade ", "");
                InsertItem("     Lane      ", "");
                InsertItem(" Lane/Office - Weekly ", "");
            }
            break;
    }
    tabObj.SetSelectedIndex(0);
}

function tab_OnChange(tabObj, nItem) {
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
    if (ComIsNull(formObj.ofcCd)) {
        ComShowCodeMessage("COM12113", "Org.");
        return false;
    }
    if (ComIsNull(formObj.year)) {
        ComShowCodeMessage("COM12113", "Year");
        return false;
    }
    if (ComIsNull(formObj.quarter)) {
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
    if (ComIsNull(formObj.unit)) {
        ComShowCodeMessage("COM12113", "Unit");
        return false;
    }
    switch (currentTabIndex) {
        case 1: // targetGroupretrieve check
            if (getItem_parameter(item01) == "ALL:") {
                ComShowCodeMessage("COM12113", "Item");
                return false;
            }
            break;
        case 2: // Lane retrieve check
            if (ComIsNull(formObj.trade02)) {
                ComShowCodeMessage("COM12113", "Trade");
                return false;
            }
            if (getItem_parameter(item02) == "ALL:") {
                ComShowCodeMessage("COM12113", "Item");
                return false;
            }
            break;
        case 3: // Lane/Office retrieve check
            if (ComIsNull(formObj.trade03)) {
                ComShowCodeMessage("COM12113", "Trade");
                return false;
            }
            if (ComIsNull(formObj.dirCd03)) {
                ComShowCodeMessage("COM12113", "Bound");
                return false;
            }
            if (getItem_parameter(item03) == "ALL:") {
                ComShowCodeMessage("COM12113", "Item");
                return false;
            }
            if (ComIsNull(formObj.from_wk03)) {
                ComShowCodeMessage("COM12113", "Week");
                return false;
            }
            break;
    } // switch end
    //	 		with(formObj){
    //	 		} // with end
    return true;
}

/*
 */
function searchKeyQueryString(formObj) {
    var query = "";
    query += "&ofcCd=" + formObj.ofcCd.value;
    query += "&year=" + formObj.year.value;
    query += "&month=" + formObj.quarter.value;
    query += "&targetGrp=" + targetGroup;
    query += "&version=" + formObj.version.value;
    query += "&unit=" + formObj.unit.value;
    return query;
}

/*
 */
function searchTabQueryString(formObj) {
    var queryString = searchKeyQueryString(formObj);
    switch (currentTabIndex) {
        case 0: // total
            selType = formObj.selType00[0].checked ? "Q" : "T";
            queryString = queryString + "&selType=" + selType;
            break;
        case 1: // targetGroup
            selType = formObj.selType01[0].checked ? "Q" : "T";
            queryString = queryString + "&trade=" + formObj.trade01.value + "&dirCd=" + formObj.dirCd01.value + "&selType=" + selType + "&item=" + getItem_parameter(item01);
            break;
        case 2: // lane
            selType = formObj.selType02[0].checked ? "Q" : "T";
            queryString = queryString + "&trade=" + formObj.trade02.value + "&dirCd=" + formObj.dirCd02.value + "&selType=" + selType + "&item=" + getItem_parameter(item02);
            break;
        case 3: // cOffice
            selType = formObj.selType03[0].checked ? "Q" : "T";
            var from_wk = formObj.from_wk03.value;
            var to_wk = formObj.to_wk03.value;
            from_wk = from_wk.split("|")[0];
            to_wk = to_wk.split("|")[0];
            queryString = queryString + "&trade=" + formObj.trade03.value + "&dirCd=" + formObj.dirCd03.value + "&selType=" + selType + "&subTrade=" + formObj.subTrade03.value + "&rlaneCd=" + lane03.GetSelectCode() + "&item=" + getItem_parameter(item03) + "&from_wk=" + from_wk + "&to_wk=" + to_wk;
            break;
    } // end switch
    return queryString;
}

/*
 */
function getItem_parameter(comObj) {
    // 		var code = comObj.Code.split("|");
    var code = comObj.GetSelectCode().split(",");
    var param = "";
    for (var i = 0; i < code.length; i++) {
        param = param + comObj.GetText(code[i], 1) + ":";
    }
    return param;
}

/*
 */
function targetGrp_OnChange(comObj, value, text) {
    targetGroup = targetGrp.GetSelectCode();
    version_change();
    trade_change();
}

/*
 */
function version_change() {
    var obj = document.form.version;
    var params = "year=" + document.form.year.value + "&quarter=" + form.quarter.value + "&targetGrp=" + targetGroup + "&searchFlag=ALL"; //select All
    getSelectCodeList(obj, "SaqMonthlyQuotaReleaseVersion", params);
    fromAndToWK_change("L2");
}

/*
 */
function trade_change() {
    var params = "targetGrp=" + targetGroup;
    getSelectCodeList(document.form.trade01, "SaqTagetGroupTrade", params, true);
    document.form.trade01.options[document.form.trade01.options.length] = new Option('ALL', '');
    document.form.trade01.value = "";
    getSelectCodeList(document.form.trade02, "SaqTagetGroupTrade", params, true);
    getSelectCodeList(document.form.trade03, "SaqTagetGroupTrade", params, true);
    trade03_OnChange();
    fromAndToWK_change("L2");
}

function trade03_OnChange() {
    subTrade_change('L2');
    SaqSearchOptionLane("lane03", true, false, 'Y', document.form.trade03.value);
}

function subTrade_change(office) {
    var subTradeObj;
    var params;
    if (document.form.dirCd03.value == "") {
        document.form.dirCd03.value = "E";
    }
    if (office == "L2") {
        subTradeObj = document.form.subTrade03;
        params = "targetGrp=" + targetGroup + "&trade=" + document.form.trade03.value + "&dirCd=" + document.form.dirCd03.value;
    }
    getSelectCodeList(subTradeObj, "SaqTagetGroupSubTrade", params, true, new Option("ALL", ""));
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
        div_name = "week_text03"
        from_wk = formObj.from_wk03.value;
        to_wk = formObj.to_wk03.value;
    }
    var objs = document.getElementById(div_name);
    if (from_wk == "" || to_wk == "") {
        objs.innerHTML = "";
    } else {
        var fromDate = from_wk.split("|")[1];
        var toDate = to_wk.split("|")[2];
        objs.innerHTML = "(" + fromDate + " ~ " + toDate + ")";
    }
}

function dirCd03_change(office) {
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
    var quarter = formObj.quarter.value;
    var version = formObj.version.value;
    var trade = "";
    var dircd = "";
    if (office == "L2") { // weekly
        trade = formObj.trade03.value;
        dircd = formObj.dirCd03.value;
        fromObj = document.form.from_wk03;
        toObj = document.form.to_wk03;
    }
    if (year != "" && quarter != "" && version != "" && trade != "" && dircd != "") {
        params = "mqta_rlse_ver_no=" + version + "&bse_yr=" + year + "&bse_qtr_cd=" + quarter + "&trd_cd=" + trade + "&dir_cd=" + dircd
        getSelectCodeList(fromObj, "SaqMonQtaWeek", params, true);
        getSelectCodeList(toObj, "SaqMonQtaWeek", params, false);
    } else {
        clearSelectOption(fromObj);
        clearSelectOption(toObj);
    }
    changeWeekText(office)
}

//	 	/*
//	 	 * tradeGroupSheet Tree Double Click Event
//	 	 */
//	 	function TotalSheet_OnDblClick(sheetObj, Row, Col) {
//	 		common_tree_DblClick(sheetObj, Row, Col);
//	 	}
//	 	/*
//	 	 * tradeGroupSheet Tree Double Click Event
//	 	 */
//	 	function tradeGroupSheet_OnDblClick(sheetObj, Row, Col) {
//	 		common_tree_DblClick(sheetObj, Row, Col);
//	 	}
//	 	/*
//	 	 * laneSheet Tree Double Click Event
//	 	 */
//	 	function laneSheet_OnDblClick(sheetObj, Row, Col) {
//	 		common_tree_DblClick(sheetObj, Row, Col);
//	 	}

/*
 * cOfficeSheet Tree Double Click Event
 */
function cOfficeSheet2_OnDblClick(sheetObj, Row, Col) {
    //	 		common_tree_DblClick(sheetObj, Row, Col);
    vvdgcd_popUp(sheetObj, Row, Col);
}

function changeSheetHead(sheetObj, sheetNo, gubun) {
    var year = document.form.year.value;
    var month = eval(document.form.quarter.value.substring(0, 1)) * 3 - 2;
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
            // InitHeadMode(true, true, false, true, false, false)
            var HeadTitle1 = "";
            if (sheetNo == 1) {
                HeadTitle1 = "Target Group|Trade|Bound|Item|Quarter\nTotal|";
            } else if (sheetNo == 2) {
                HeadTitle1 = "Trade|Bound|Sub Trade|Item|Quarter\nTotal|";
            } else if (sheetNo == 3) {
                HeadTitle1 = "Bound|Sub Trade|Lane|Item|Quarter\nTotal|";
            } else if (sheetNo == 4) {
                HeadTitle1 = "Week|Sub Trade|Lane|VVD Group|VVD|Item|Quota|";
            }
            if (sheetNo != 4) {
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
        // Sheet Unit Setting
    var unit_text = document.form.unit.options[document.form.unit.selectedIndex].text;
    document.all("sheet_unit")[currentTabIndex].innerHTML = "Unit : " + unit_text + " / USD / USD 1,000*";
}

function cOfficeSheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    vvdgcd_cur_chng(sheetObj, Button, Shift, X, Y);
}

function vvdgcd_popUp(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "vvdgcd" && sheetObj.GetCellValue(row, col).substring(0, 5) != "TOTAL" && sheetObj.GetCellValue(row, col).substring(0, 5) != " ") {
        var params = "&bse_yr=" + formObj.year.value + "&bse_qtr_cd=" + formObj.quarter.value + "&rlane_cd=" + sheetObj.GetCellValue(row, col).substring(0, 5) + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, col).substring(6, 7) + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, col).substring(7, 9);
        switch (currentTabIndex) {
            case 3:
                params = params + "&trd_cd=" + formObj.trade03.value + "&dir_cd=" + formObj.dirCd03.value;
                break;
        }
        params = params + "&tbl_gbn=CONFIRMED";
        var width = 600;
        var height = 450;
        var callback = "callbackRemark";
        ComOpenPopup("ESM_SAQ_0116.do?" + params, width, height, callback, "0,0", true);
    }
}

function vvdgcd_cur_chng(sheetObj, Button, Shift, X, Y) {
    var col = sheetObj.MouseCol();
    var row = sheetObj.MouseRow();
    var cursor = "Default";
    if ((sheetObj.ColSaveName(col) == "vvdgcd" && sheetObj.GetCellValue(row, col) > "") && (sheetObj.GetCellValue(row, col).substring(0, 5) != "TOTAL")) {
        cursor = "Hand";
    }
    sheetObj.SetMousePointer(cursor);
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("quarter");
    SaqSearchOptionTargetGroup("targetGrp");
    SaqSearchOptionComCode("unit", "CD00897", false);
    SaqSearchOptionBound("dirCd01");
    SaqSearchOptionComCodeMulti("item01", "CD01061", true, true, 8, "type2");
    SaqSearchOptionBound("dirCd02");
    SaqSearchOptionComCodeMulti("item02", "CD01061", true, true, 8, "type2");
    SaqSearchOptionBound("dirCd03", false);
    SaqSearchOptionLane("lane03");
    SaqSearchOptionComCodeMulti("item03", "CD01061", true, true, 8, "type2");
    item01.SetSelectIndex(0);
    item02.SetSelectIndex(0);
    item03.SetSelectIndex(0);
}

function item01_OnCheckClick(comboObj, index, code) {
    SaqAllChkMultiCombo(comboObj, index);
}

function item02_OnCheckClick(comboObj, index, code) {
    SaqAllChkMultiCombo(comboObj, index);
}

function item03_OnCheckClick(comboObj, index, code) {
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







































/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0128.js
*@FileTitle  : Regional Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
/**
 * @extends
 * @class ESM_SAQ_0128 : business script for ESM_SAQ_0128
 */
	 var tabObjects=new Array();
	 var tabCnt=0 ;
	 var currentTabIndex=1;
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var comObjects=new Array();
	 var comboCnt=0;
	 var targetGroup="";
	 var tabSearchParams="";
	 var tabChildSearchParams=["", "", "", "", ""];
	 
	//Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 
	//Event handler processing by button name */
	 	function processButtonClick(){
	 		 var sheetObject=sheetObjects[currentTabIndex];
	 		 var formObject=document.form;
	 		try {
	 			var srcName=ComGetEvent("name");
	 			if(ComGetBtnDisable(srcName)) return false;
	 			switch(srcName) {
	 				case "btn_retrieve":
	 					doActionIBSheet(sheetObject,formObject,IBSEARCH);
	 					break;
	 				case "btn_downexcel":
	 					if(sheetObject.RowCount() < 1){//no data
	 		        	     ComShowCodeMessage("COM132501");
 		        	    } else{
 		        	    	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
 		        	    }
	 					break;
	 			} // end switch
	 		}catch(e) {
	 			if( e == "[object Error]") {
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
	 	function setSheetObject(sheet_obj){
	 	   sheetObjects[sheetCnt++]=sheet_obj;
	 	}
	 	
	 	/**
	     * registering IBCombo Object as list
	     * adding process for list in case of needing batch processing with other items
	     * defining list on the top of source
	     */
	     function setComboObject(combo_obj){
	 		comObjects[comboCnt++]=combo_obj;
	     }
	     
	     /**
	      * initializing sheet
	      * implementing onLoad event handler in body tag
	      * adding first-served functions after loading screen.
	      */
	 	function loadPage() {
	 		optionSetting();
	 		// Org setting
	 		setOfcTo4thParentOffice(document.form.ofcCd);
	 		var sheetResizeFull=true;
	 		var objs=document.all.tabLayer;
        	var formObj=document.form;
        	setYearMonthObjectByRelease(formObj.year, formObj.quarter);
	 		for(var i=0;i<sheetObjects.length;i++){
	 			ComConfigSheet(sheetObjects[i]);
	 			objs[i].style.display="Inline";
	 			initSheet(sheetObjects[i],i+1);
	 			objs[i].style.display="None";
	 			ComEndConfigSheet(sheetObjects[i]);
	 		}
	 		objs[0].style.display="Inline";
	 		for(var k=0;k<tabObjects.length;k++){
	 			initTab(tabObjects[k],k+1);
	 		}
	 		// item defalut setting
	 		for(var k=0; k<comboCnt; k++){
	 			comObjects[k].SetSelectText("ALL");
	 		}
	 		resizeSheet();
	 		version_change();
	 		document.form.year.focus();
	 	}
	 	
	 	function resizeSheet(){
	        for(i=0;i<sheetObjects.length;i++){
	            ComResizeSheet(sheetObjects[i]);
	        }    		
		}
		
	     // Org setting
	     function setOfcTo4thParentOffice( objOrg ){
	         var vl= getCodeList("OfcTo4thParentOffice", "ofc_cd="+ objOrg.value);
	         if( vl != ""){
	             var code=vl[0].split("|");
	             objOrg.value=code[0];
	         }
	     }
	     
	     /**
	      * initializing sheet
	      * implementing onLoad event handler in body tag
	      * adding first-served functions after loading screen.
	      */
	 	function initSheet(sheetObj,sheetNo) {
	 		var cnt=0;
	 		var year=document.form.year.value;
	 		switch(sheetNo) {
	 			case 1: // Total sheet init
	 			    with(sheetObj){
			 		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
		    		      changeSheetHead(sheetObj, sheetNo,"init");
			 		      var cols = [ {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"tgt_grp",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				 		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 		      for (i=0; i<=3; i++) {
			 		    	  cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
			 		      }
			 		      cols.push({Type:"Text",      Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
			 		      InitColumns(cols);
			 		      SetEditable(0);
//			 		      SetSheetHeight(446);
		 		      }
	 				break;

	 			case 2: // tradeGroupSheet sheet init
	 			    with(sheetObj){
			 		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
		    		      changeSheetHead(sheetObj, sheetNo,"init");
			 		      var cols = [ {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 		      for (i=0; i<=3; i++) {
			 		    	  cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
			 		      }
			 		      cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0});
			 		      InitColumns(cols);
			 		      SetEditable(0);
//			 		      SetSheetHeight(436);
		 		      }
	 				break;

	 			case 3: // laneSheet sheet init
	 			    with(sheetObj){
			 		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
		    		      changeSheetHead(sheetObj, sheetNo,"init");
			 		      var cols = [ {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 		      for (i=0; i<=3; i++) {
			 		    	  cols.push({Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 });
			 		      }
			 		      cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			 		      InitColumns(cols);
			 		      SetEditable(0);
//			 		      SetSheetHeight(436);
		 		      }
	 				break;

	 			case 4: //cOffice
	 			    with(sheetObj){
			 		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 , PrevColumnMergeMode:0} );
		    		      changeSheetHead(sheetObj, sheetNo,"init");

			 		      var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"week",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvdgcd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			 		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
			 		             ];
			 		     cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			 		      InitColumns(cols);
			 		      SetEditable(0);
//			 		      SetSheetHeight(407);
		 		      }
	 				break;
	 			} // end swich
	 	}
	 	
	   	// handling process after ending sheet1 retrieve
	 	function doActionIBSheet(sheetObj,formObj,sAction) {
	 		sheetObj.ShowDebugMsg(false);
	 		switch(sAction) {
	 		   case IBSEARCH:
	 				if (tabSearchParams != "" && tabSearchParams != searchKeyQueryString(formObj)) {
	 					for(i=0;i<sheetObjects.length;i++){
	 						sheetObjects[i].RemoveAll();
	 					}
	 				}
	 				if (validateForm(sheetObj,formObj,sAction) == false) {
	 					break;
	 				}

	 		   		var f_cmd="";
	 		   		var f_url="";
	 		   		if (currentTabIndex == 0) {
	 		   			// Target Group retrieve
	 				    f_cmd="&f_cmd=" + SEARCHLIST10;
	 				   f_url="ESM_SAQ_0128GS10.do";
	 		   		} else if (currentTabIndex == 1) {
	 		   			// Target Group retrieve
	 				    f_cmd="&f_cmd=" + SEARCHLIST01;
	 				   f_url="ESM_SAQ_0128GS01.do";
	 		   		} else if (currentTabIndex == 2) {
	 		   			// Lane retrieve
	 				    f_cmd="&f_cmd=" + SEARCHLIST02;
	 				   f_url="ESM_SAQ_0128GS02.do";
	 		   		} else if (currentTabIndex == 3) {
	 		   			// C.Office retrieve
	 				    f_cmd="&f_cmd=" + SEARCHLIST03;
	 				   f_url="ESM_SAQ_0128GS03.do";
	 		   		}
	 		   		ComOpenWait(true);
	 		   		tabSearchParams=searchKeyQueryString(formObj);
	 		   		tabChildSearchParams[currentTabIndex]=searchTabQueryString(formObj);
	 		   		var sXml=sheetObj.GetSearchData(f_url, f_cmd+searchTabQueryString(formObj) );
	 		   		if (sXml != "") sheetObj.LoadSearchData(sXml, {sync:1});

	 		    	changeSheetHead(sheetObj, currentTabIndex+1);
	 		    	ComOpenWait(false);
	 				break;
	 		   case IBDOWNEXCEL:  //excel download
	    		  selectDownExcelMethod(sheetObj);
	 			  break;
	 		}
	 	}

   	 function callBackExcelMethod(excelType) {
	    	var sheetObj = sheetObjects[currentTabIndex];
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				return;
			}
			DownExcel(sheetObj, excelType);
		}

	 	/**
	     * registering IBSheet Object as list
	     * adding process for list in case of needing batch processing with other items
	     * defining list on the top of source
	     */
	 	function setTabObject(tab_obj){
	 		tabObjects[tabCnt++]=tab_obj;
	 	}
	 	
	 	/**
	     * initializing Tab
	     * setting Tab items
	     */
	 	function initTab(tabObj , tabNo) {
	 		 switch(tabNo) {
	 			 case 1:
	 				with (tabObj) {
	 					var cnt=0 ;
						InsertItem( "   Total   " , "");
						InsertItem( " Target Group/Trade/Sub Trade " , "");
						InsertItem( "     Lane      " , "");
						InsertItem( " Lane/Office - Weekly " , "");
	 				}
	 			 break;
	 		}
	 		tabObj.SetSelectedIndex(0);
	 	}

     	function tab_OnChange(tabObj , nItem)
     	{
     		var objs=document.all.item("tabLayer");
        	objs[nItem].style.display="Inline";
        	var beforetab=currentTabIndex;
        	objs[beforetab].style.display="none";
     		for(var i = 0; i<objs.length; i++){
    		       if(i != nItem){
    		        objs[i].style.display="none";
    		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    		       }
    		      }
     		currentTabIndex=nItem;
     		resizeSheet();
     	}

	    /**
	 	 * handling process for input validation
	 	 */
	 	function validateForm(sheetObj,formObj,sAction){
	 		if (ComIsNull(formObj.ofcCd)) {
            	ComShowCodeMessage("COM12113", "Org.");
                 return false;
             }
             if (ComIsNull(formObj.year)) {
             	ComShowCodeMessage("COM12113", "Year");
                 return false;
             }
             if (ComIsNull(formObj.quarter)) {
             	ComShowCodeMessage("COM12113", "Month");
                 return false;
             }
             if (targetGrp.GetSelectCode()== '') {
             	ComShowCodeMessage("COM12113", "Target Group");
                 return false;
             }
             if (ComIsNull(formObj.version)) {
             	ComShowCodeMessage("COM12113", "Version");
                 return false;
             }
             if (ComIsNull(formObj.unit)) {
             	ComShowCodeMessage("COM12113", "Unit");
                 return false;
             }
 			switch (currentTabIndex) {
 				case 1 : // targetGroupretrieve check
 		            if (getItem_parameter(item01) == "ALL:") {
 		            	ComShowCodeMessage("COM12113", "Item");
 		                return false;
 		            }
 					break;
 				case 2 : // Lane retrieve check
 		            if (ComIsNull(formObj.trade02)) {
 		            	ComShowCodeMessage("COM12113", "Trade");
 		                return false;
 		            }
 		            if (getItem_parameter(item02) == "ALL:") {
 		            	ComShowCodeMessage("COM12113", "Item");
 		                return false;
 		            }
 					break;
 				case 3 : // Lane/Office retrieve check
 		            if (ComIsNull(formObj.trade03)) {
 		            	ComShowCodeMessage("COM12113", "Trade");
 		                return false;
 		            }
 		            if (ComIsNull(formObj.dirCd03)) {
 		            	ComShowCodeMessage("COM12113", "Bound");
 		                return false;
 		            }
 		            if (getItem_parameter(item03) == "ALL:") {
 		            	ComShowCodeMessage("COM12113", "Item");
 		                return false;
 		            }
 		            if (ComIsNull(formObj.from_wk03)) {
 		            	ComShowCodeMessage("COM12113", "Week");
 		                return false;
 		            }
 					break;
 	        } // switch end
//	 		with(formObj){
//	 		} // with end
	 		return true;
	 	}
	 	
	 	/*
	 	 */
	 	function searchKeyQueryString(formObj) {
	 		var query="";
	 		query += "&ofcCd="+formObj.ofcCd.value;
	 		query += "&year="+formObj.year.value;
	 		query += "&month="+formObj.quarter.value;
	 		query += "&targetGrp="+targetGroup;
	 		query += "&version="+formObj.version.value;
	 		query += "&unit="+formObj.unit.value;
	 		return query;
	 	}
	 	
	 	/*
	 	 */
	 	function searchTabQueryString(formObj) {
	 		var queryString=searchKeyQueryString(formObj);
	 		switch (currentTabIndex) {
	 			case 0 : // total
	 				selType=formObj.selType00[0].checked ? "Q" : "T";
	 				queryString=queryString
	 							+ "&selType="+selType
	 							;
	 				break;
	 			case 1 : // targetGroup
	 				selType=formObj.selType01[0].checked ? "Q" : "T";
	 				queryString=queryString
	 							+ "&trade="+formObj.trade01.value
	 							+ "&dirCd="+formObj.dirCd01.value
	 							+ "&selType="+selType
	 							+ "&item="+getItem_parameter(item01)
	 							;
	 				break;
	 			case 2 : // lane
	 				selType=formObj.selType02[0].checked ? "Q" : "T";
	 				queryString=queryString
	 							+ "&trade="+formObj.trade02.value
	 							+ "&dirCd="+formObj.dirCd02.value
	 							+ "&selType="+selType
	 							+ "&item="+getItem_parameter(item02)
	 							;
	 				break;
	 			case 3 : // cOffice
	 				selType=formObj.selType03[0].checked ? "Q" : "T";
	 			    var from_wk=formObj.from_wk03.value;
	 			    var to_wk=formObj.to_wk03.value;
	 			    from_wk=from_wk.split("|")[0];
	 			    to_wk=to_wk.split("|")[0];
	 				queryString=queryString
	 							+ "&trade="+formObj.trade03.value
	 							+ "&dirCd="+formObj.dirCd03.value
	 							+ "&selType="+selType
	 							+ "&subTrade="+ formObj.subTrade03.value
	 							+ "&rlaneCd="+ lane03.GetSelectCode()
	 							+ "&item="+getItem_parameter(item03)
	 							+ "&from_wk="+from_wk
	 							+ "&to_wk="+to_wk
	 							;
	 				break;
	 		} // end switch
	 		return queryString;
	 	}
	 	
	 	/*
	 	 */
	 	function getItem_parameter(comObj){
	// 		var code = comObj.Code.split("|");
	 		var code=comObj.GetSelectCode().split(",");
	 		var param="";
	 		for (var i=0; i<code.length; i++) {
	 			param=param + comObj.GetText(code[i], 1) + ":";
	 		}
	 		return param;
	 	}
	 	
	 	/*
	 	 */
	 	function targetGrp_OnChange(comObj, value, text){
	 		targetGroup=targetGrp.GetSelectCode();
	 	    version_change();
	     	trade_change();
	 	}
	 	
	 	/*
	 	 */
	 	function version_change() {
	 		var obj= document.form.version;
	 		var params="year="+document.form.year.value
	 					+ "&quarter="+form.quarter.value
	 					+ "&targetGrp="+targetGroup
	 					+ "&searchFlag=ALL"; //select All
	 		getSelectCodeList(obj, "SaqMonthlyQuotaReleaseVersion", params);
            fromAndToWK_change("L2");
	 	}
	 	
	 	/*
	 	 */
	 	function trade_change() {
	 		var params="targetGrp="+targetGroup;
	 		getSelectCodeList(document.form.trade01, "SaqTagetGroupTrade", params, true);
	 		document.form.trade01.options[document.form.trade01.options.length]=new Option('ALL', '');
	 		document.form.trade01.value="";
	 		getSelectCodeList(document.form.trade02, "SaqTagetGroupTrade", params, true);
	 		getSelectCodeList(document.form.trade03, "SaqTagetGroupTrade", params, true);
	 		trade03_OnChange();
	 		fromAndToWK_change("L2") ;
	 	}
	 	
	 	function trade03_OnChange(){
	 		subTrade_change('L2');
	 		SaqSearchOptionLane("lane03", true, false, 'Y', document.form.trade03.value);
	 	}
	 	
	 	function subTrade_change(office) {
	 		var subTradeObj;
	 		var params;
	 		if(document.form.dirCd03.value == "" ){
	 			document.form.dirCd03.value = "E";
	 		}
	 		if (office == "L2") {
	 		    subTradeObj=document.form.subTrade03;
	 		    params="targetGrp="+targetGroup
	 					+ "&trade="+document.form.trade03.value
	 					+ "&dirCd="+document.form.dirCd03.value;
	 		}
	 		getSelectCodeList(subTradeObj, "SaqTagetGroupSubTrade", params,true,new Option("ALL", ""));
	 	}
	 	
	 	function clearSelectOption(obj,option){
	 	    var opts=obj.options;
	     	for (var i=(opts == null ? 0 : opts.length); i >= 0; i--) {
	     		opts.remove(i);
	     	}
	         if (option != undefined && option.nodeName == "OPTION") {
	         	obj.options[0]=option;
	         }
	 	}
	 	
	     function changeWeekText(office){
	         var from_wk;
	         var to_wk ;
	         var formObj=document.form;
	         var div_name ;
	         if( office == "L2"){
	             div_name="week_text03"
	             from_wk=formObj.from_wk03.value;
	             to_wk=formObj.to_wk03.value;
	         }
	         var objs=document.getElementById(div_name);
	         if( from_wk == "" || to_wk == ""){
	             objs.innerHTML="";
	         }else{
	             var fromDate=from_wk.split("|")[1];
	             var toDate=to_wk.split("|")[2];
	             objs.innerHTML="("+fromDate+" ~ "+toDate+")";
	         }
	     }
	     
	 	function dirCd_change(office){
	 	    fromAndToWK_change(office);
	 	}
	 	
	 	function week_onChange(office){
	 	    changeWeekText(office);
	 	}
	 	
	 	/*
	 	 * from week, to week set
	 	 */
	 	function fromAndToWK_change(office) {
	 		var fromObj;
	 		var toObj;
	 		var params;
	 		var formObj=document.form;
	 		var year=formObj.year.value;
	 		var quarter=formObj.quarter.value;
	 		var version=formObj.version.value;
	 		var trade="";
	 		var dircd="";
	 	    if( office == "L2" ){ // weekly
	 		    trade=formObj.trade03.value;
	 		    dircd=formObj.dirCd03.value;
	 		    fromObj= document.form.from_wk03;
	 		    toObj= document.form.to_wk03;
	 	    }
	 		if( year != ""
	 		    && quarter != ""
	 		    && version != ""
	 		    && trade != ""
	 		    && dircd != "" ){
	 		    params="mqta_rlse_ver_no="+version
	 		            +"&bse_yr="+year
	 		            +"&bse_qtr_cd="+quarter
	 		            +"&trd_cd="+trade
	 		            +"&dir_cd="+dircd
	             getSelectCodeList(fromObj, "SaqMonQtaWeek", params, true);
	             getSelectCodeList(toObj, "SaqMonQtaWeek", params, false);
	 		}else {
	 		    clearSelectOption(fromObj);
	 		    clearSelectOption(toObj);
	 		}
	 		changeWeekText(office)
	 	}
	 	
//	 	/*
//	 	 * tradeGroupSheet Tree Double Click Event
//	 	 */
//	 	function TotalSheet_OnDblClick(sheetObj, Row, Col) {
//	 		common_tree_DblClick(sheetObj, Row, Col);
//	 	}
//	 	/*
//	 	 * tradeGroupSheet Tree Double Click Event
//	 	 */
//	 	function tradeGroupSheet_OnDblClick(sheetObj, Row, Col) {
//	 		common_tree_DblClick(sheetObj, Row, Col);
//	 	}
//	 	/*
//	 	 * laneSheet Tree Double Click Event
//	 	 */
//	 	function laneSheet_OnDblClick(sheetObj, Row, Col) {
//	 		common_tree_DblClick(sheetObj, Row, Col);
//	 	}

	 	/*
	 	 * cOfficeSheet Tree Double Click Event
	 	 */
	 	function cOfficeSheet2_OnDblClick(sheetObj, Row, Col) {
//	 		common_tree_DblClick(sheetObj, Row, Col);
	 		vvdgcd_popUp (sheetObj , Row , Col );
	 	}

	 	function changeSheetHead(sheetObj, sheetNo, gubun) {
	 		var year=document.form.year.value;
	 		var month=eval(document.form.quarter.value.substring(0,1))*3-2;
	 		var years=[year, year, year];
	 		var months=[month, month+1, month+2];
	 		for(var i=0; i<months.length; i++) {
	 			if (months[i] == 13) {
	 				years[i]=eval(year) + 1;
	 				months[i]=1;
	 			} else if (months[i] == 14) {
	 				years[i]=eval(year) + 1;
	 				months[i]=2;
	 			}
	 			if (months[i] < 10) {
	 				months[i]="0" + months[i];
	 			}
	 		}
	 		var i,j=0;
	 		with(sheetObj) {
	 	        // InitHeadMode(true, true, false, true, false, false)
	 	        var HeadTitle1="";
	 			if (sheetNo == 1) {
	 				HeadTitle1="Target Group|Trade|Bound|Item|Quarter\nTotal|";
	 			}else if (sheetNo == 2) {
	 				HeadTitle1="Trade|Bound|Sub Trade|Item|Quarter\nTotal|";
	 			} else if (sheetNo == 3) {
	 				HeadTitle1="Bound|Sub Trade|Lane|Item|Quarter\nTotal|";
	 	        } else if (sheetNo == 4) {
	 	       		HeadTitle1="Week|Sub Trade|Lane|VVD Group|VVD|Item|Quota|";
	 	        }
	 	        if( sheetNo != 4){
	     	        for(var i=0; i<3; i++) {
	     	        	HeadTitle1=HeadTitle1 + years[i] + "." + months[i] + "|";
	     	        }
	 	        }
 	        	if( gubun == "init"){
					var headers = [ { Text:HeadTitle1, Align:"Center"}];
		 	        var info    = { Sort:0, ColMove:1, ColResize:1, HeaderCheck:1 };
		 	        sheetObj.InitHeaders(headers, info);
				} else{
	    			changeHeaderRow(sheetObj, 0 , HeadTitle1);
				}
	 		}
	 		 // Sheet Unit Setting
	 		var unit_text=document.form.unit.options[document.form.unit.selectedIndex].text;
	 		document.all("sheet_unit")[currentTabIndex].innerHTML="Unit : "+unit_text+" / USD / USD 1,000*";
	 	}
	 	
	 	function cOfficeSheet2_OnMouseMove(sheetObj,Button, Shift, X, Y) {
	 		vvdgcd_cur_chng(sheetObj,Button, Shift, X, Y);
	 	}
	 	
	 	function vvdgcd_popUp (sheetObj , row , col )
	 	{
	 		var formObj=document.form;
	 		if( sheetObj.ColSaveName(col) == "vvdgcd"
	 			&& sheetObj.GetCellValue(row, col).substring(0,5)!="TOTAL"
	 				&& sheetObj.GetCellValue(row, col).substring(0,5)!=" " ){
	 			var params="&bse_yr=" + formObj.year.value
	 			+ "&bse_qtr_cd=" + formObj.quarter.value
	 			+ "&rlane_cd=" + sheetObj.GetCellValue(row, col).substring(0,5)
	 			+ "&sprt_grp_cd=" + sheetObj.GetCellValue(row, col).substring(6,7)
	 			+ "&bsa_grp_cd=" + sheetObj.GetCellValue(row, col).substring(7,9);
	 			switch (currentTabIndex) {
	 				case 3:
 						params= params  + "&trd_cd=" + formObj.trade03.value + "&dir_cd=" + formObj.dirCd03.value;
	 					break;
	 			}
	 			params=params + "&tbl_gbn=CONFIRMED";
	            var width=600;
	            var height=450;
	            var callback="callbackRemark";
	            ComOpenPopup("ESM_SAQ_0116.do?"+params, width, height, callback,"0,0", true);
	 	    }
	 	}

	 	function vvdgcd_cur_chng(sheetObj,Button, Shift, X, Y) {
	 	    var col=sheetObj.MouseCol();
	 	    var row=sheetObj.MouseRow();
	 	    var cursor="Default";
	 	    if ((sheetObj.ColSaveName(col) == "vvdgcd"
	 	    	&& sheetObj.GetCellValue(row,col) > "" )
	 	    	&& (sheetObj.GetCellValue(row,col).substring(0,5) != "TOTAL")){
	 	      	  cursor="Hand";
	 	    }
	 	    sheetObj.SetMousePointer(cursor);
	 	}
	 	
	 	function optionSetting() {
			SaqSearchOptionYear("year");
			SaqSearchOptionQuarter("quarter");
			SaqSearchOptionTargetGroup("targetGrp");
			SaqSearchOptionComCode("unit", "CD00897", false);
			SaqSearchOptionBound("dirCd01");
			SaqSearchOptionComCodeMulti("item01", "CD01061", true, true, 8, "type2");
			SaqSearchOptionBound("dirCd02");
			SaqSearchOptionComCodeMulti("item02", "CD01061", true, true, 8, "type2");
			SaqSearchOptionBound("dirCd03", false);
			SaqSearchOptionLane("lane03");
			SaqSearchOptionComCodeMulti("item03", "CD01061", true, true, 8, "type2");
			item01.SetSelectIndex(0);
			item02.SetSelectIndex(0);
			item03.SetSelectIndex(0);
	    }
	    
	 	function item01_OnCheckClick(comboObj, index, code) { 
	 		SaqAllChkMultiCombo(comboObj,index);    
	 	}
	 	
	 	function item02_OnCheckClick(comboObj, index, code) { 
	 		SaqAllChkMultiCombo(comboObj,index);    
	 	} 
	 	
	 	function item03_OnCheckClick(comboObj, index, code) { 
	 		SaqAllChkMultiCombo(comboObj,index);    
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
