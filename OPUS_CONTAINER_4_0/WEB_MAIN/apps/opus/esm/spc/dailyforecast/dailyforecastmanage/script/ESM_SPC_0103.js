/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SPC_0103.js
*@FileTitle  : Account Registration 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
var sheetObjects = new Array();
var comObjects = new Array();
var sheetCnt = 0;
var comboCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
//type check 
var type_check;
//retrive check
var check_retrive = false;
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
            //            			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
            sheetObjects[0].RemoveAll();

            doActionIBSheet(sheetObject, formObject, IBSEARCH);
            break;
        case "btn_new":
            if (checkModifiedSheet(sheetObjects)) {
                if (ComShowConfirm(getMsg("SPC90001")) != 1) {
                    return;
                }
            }
            //using common funtion : initializing the screen
            resetAll();
            searchSalesRep = new Array();
            break;
        case "btn_save":
            doActionIBSheet(sheetObject, formObject, IBSAVE);
            break;
        case "btn_rowadd":
            doActionIBSheet(sheetObject, formObject, IBINSERT);
            break;
        case "btn_ok":
            //window.returnValue="OK";
            ComPopUpReturnValue("OK");
            ComClosePopup();
            break;
        case "btn_close":
            ComPopUpReturnValue("CLOSE");
            //window.returnValue="CLOSE";
            ComClosePopup();
            break;
        case "btn_downexcel":
            doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
    optionSetting();
    tab_retrives = new Array(sheetObjects.length);
    var tdisp = "block";
    for (var i = 0; i < sheetObjects.length; i++) {
        // change the name of start environment setting funtion
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        // Adding last environment setting funtion
        ComEndConfigSheet(sheetObjects[i]);
    }
    //            var sheetResizeFull=true;
    //    		document_onresize();

    var rtn = getCodeList("ChildOffice", "ofc_cd=" + ofc_cd + "&level=4");
    initData_rgnOffice(rtn[0].split("|"), rtn[1].split("|"));
    var formObject = document.form;
    var comObj = rgnOffice;
    var focusObj = comObj;
    if (comObj.GetItemCount() <= 1) {
        comObj.SetSelectIndex(0);
        var comObj1 = subOffice;
        if (comObj.GetSelectCode() != comObj1.GetSelectCode()) {
            comObj1.SetEnable(0);
        }
    }
    var setAllField = true;
    var focusObj = null;
    if (rgn_ofc_cd != "") {
        comObjects[0].SetSelectCode(rgn_ofc_cd);
        comObjects[0].SetEnable(0);
    } else {
        focusObj = focusObj == null ? comObjects[0] : null;
    }
    if (sub_ofc_cd != "") {
        comObjects[1].SetSelectCode(sub_ofc_cd);
        comObjects[1].SetEnable(0);
    } else {
        focusObj = focusObj == null ? comObjects[1] : null;
    }
    if (srep_id != "") {
        comObjects[2].SetSelectCode(srep_id);
        comObjects[0].SetEnable(0);
        comObjects[1].SetEnable(0);
        comObjects[2].SetEnable(0);
        search_srep_id.innerText = srep_id;
    } else {
        focusObj = focusObj == null ? comObjects[2] : null;
        setAllField = setAllField && false;
    }
    if (srep_nm != "") {
        search_srep_nm.innerText = srep_nm;
    }
    if (ioc_cd != "") {
        formObject.ioc.value = ioc_cd;
        formObject.ioc.disabled = true;
        search_ioc_cd.innerText = ioc_cd == "O" ? "OCN" : ioc_cd == "I" ? "IPC" : ioc_cd == "T" ? "TS" : "";
    } else {
        focusObj = focusObj == null ? formObject.ioc : null;
        setAllField = setAllField && false;
    }
    if (trd_cd != "") {
        comObjects[3].SetSelectCode(trd_cd);
        comObjects[3].SetEnable(0);
        search_trd_cd.innerText = trd_cd;
    } else {
        focusObj = focusObj == null ? comObjects[3] : null;
        setAllField = setAllField && false;
    }
    if (sub_trd_cd != "") {
        comObjects[4].SetSelectCode(sub_trd_cd);
        comObjects[4].SetEnable(0);
        search_sub_trd_cd.innerText = sub_trd_cd;
    } else {
        focusObj = focusObj == null ? comObjects[4] : null;
        setAllField = setAllField && false;
    }
    if (rlane_cd != "") {
        comObjects[5].SetSelectCode(rlane_cd);
        comObjects[5].SetEnable(0);
        search_rlane_cd.innerText = rlane_cd;
    } else {
        focusObj = focusObj == null ? comObjects[5] : null;
        setAllField = setAllField && false;
    }
    if (bound != "") {
        formObject.bound.value = bound;
        formObject.bound.disabled = true;
        search_bound.innerText = bound;
    } else {
        focusObj = focusObj == null ? formObject.bound : null;
        setAllField = setAllField && false;
    }
    if (setAllField) {
        searchCondition.style.display = "none";
        searchInformation.style.display = "inline";
        doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
    } else {
        searchCondition.style.display = "inline";
        searchInformation.style.display = "none";
        if (focusObj != null) {
            focusObj.focus();
        }
        //    	    	if(isDevMode){
        //    	    	}
    }
    //        	document_onresize();
    resizeSheet();
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
    }
}

/**
 * Changing title after retrieving TabSheet1
 */
function initSheet1(sheetObj) {
	with(sheetObj){    	      
		var cnt=0;
		var HeadTitle0= "Del|Load Account|Load Account|Load Account|Contract Customer|Contract Customer"
		var HeadTitle1=	"Del|Code|Type|Name|Code|Name"
		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		var info    = { Sort:1, ColMove:0, HeaderCheck:1, ColResize:1 };
		var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
		 InitHeaders(headers, info);
		var cols = [ {Type:"DelCheck",  	Hidden:0, 	Width:45,   	Align:"Center",  ColMerge:1,   SaveName:"del_flag",          			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
					{Type:"PopupEdit", 		Hidden:0, 	Width:100,  	Align:"Center",  ColMerge:1,   SaveName:"cust_cd",           			KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					{Type:"Combo" ,     	Hidden:0,  	Width:90,  		Align:"Center",  ColMerge:1,   SaveName:"fcast_cust_tp_cd",  			KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
					{Type:"Text",      		Hidden:0,  	Width:200, 		Align:"Left",    ColMerge:1,   SaveName:"cust_nm",           			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 ,   EditLen:100 },
					{Type:"PopupEdit",      Hidden:0,  	Width:90, 		Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cd",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:8 , AcceptKeys:"E|N" , InputCaseSensitive:1},
					{Type:"Text",      		Hidden:0,  	Width:200, 		Align:"Left",    ColMerge:1,   SaveName:"ctrt_cust_nm",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:100 },
					{Type:"Text" ,     		Hidden:1,  	Width:20,   	Align:"Center",  ColMerge:1,   SaveName:"srep_cd",           			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					{Type:"Text" ,     		Hidden:1,  	Width:40,   	Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					{Type:"Text" ,     		Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					{Type:"Text" ,     		Hidden:1,  	Width:20,   	Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					{Type:"Text" ,     		Hidden:1,  	Width:40,   	Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					{Type:"Text" ,     		Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"ioc_ts_cd",         			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					{Type:"Text" ,     		Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",       			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2},
					{Type:"Text" ,     		Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"cust_seq",          			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6},
					{Type:"Text" ,     		Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_cnt_cd",       		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2},
					{Type:"Text" ,     		Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"ctrt_cust_seq",          		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6},
					{Type:"Text" ,     		Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"fcast_seq",          			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6},
					{Type:"Text" ,     		Hidden:1,  	Width:100,  	Align:"Center",  ColMerge:1,   SaveName:"org_fcast_cust_tp_cd",  		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
					{Type:"Status" ,     	Hidden:1,  	Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"ibflag",            			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];   	       
		InitColumns(cols);
		SetEditable(1);
		SetColProperty(0 ,1 , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		SetColProperty("fcast_cust_tp_cd", {ComboText:"BCO|Non-BCO", ComboCode:"B|N"} );
		
		if(is_child == "true") {
		SetSheetHeight(ComGetSheetHeight(sheetObj,10) );
		} 
		//SetHeaderRowHeight(10);
	}
}

// Handling the process related with sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            var param = "salesRep=" + comObjects[2].GetSelectCode();
            param = param + "&ioc=" + formObj.ioc.value;
            param = param + "&trade=" + comObjects[3].GetSelectCode();
            param = param + "&subTrade=" + comObjects[4].GetSelectCode();
            param = param + "&lane=" + comObjects[5].GetSelectCode();
            param = param + "&bound=" + formObj.bound.value;            
            param = param + "&fcast_cust_tp_cd=" + formObj.accountType.value;
            
            var sXml = sheetObj.GetSearchData("ESM_SPC_0103GS.do", "f_cmd=" + (SEARCHLIST) + "&" + param);
            if (ComGetTotalRows(sXml) > 0) {
                sheetObj.RenderSheet(0);
                sheetObj.LoadSearchData(sXml, { Sync: 1 });
                sheetObj.RenderSheet(1);
                srep_id = comObjects[2].GetSelectCode();
                rlane_cd = comObjects[5].GetSelectCode();
                trd_cd = comObjects[3].GetSelectCode();
                sub_trd_cd = comObjects[4].GetSelectCode();
                bound = formObj.bound.value;
                ioc_cd = formObj.ioc.value;
                sub_ofc_cd = comObjects[1].GetSelectCode();
//                if (sheetObj.RowCount() > 0) {
//                    formObj.accountType.value = sheetObj.GetCellValue(1, "fcast_cust_tp_cd");
//                }

            } else {
                sheetObj.LoadSearchData(sXml, { Sync: 1 });
            }
            check_retrive = true;
            break;
        case IBSAVE: //save
            if (!validateForm(sheetObj, formObj, sAction)) {
                return false;
            }
            var param = "salesRep=" + comObjects[2].GetSelectCode();
            param = param + "&ioc=" + formObj.ioc.value;
            param = param + "&trade=" + comObjects[3].GetSelectCode();
            param = param + "&subTrade=" + comObjects[4].GetSelectCode();
            param = param + "&lane=" + comObjects[5].GetSelectCode();
            param = param + "&bound=" + formObj.bound.value;
            param = param + "&accountType=" + formObj.accountType.value;
            var rtn = doSaveSheet(sheetObj, "ESM_SPC_0103GS.do", "f_cmd=" + (MULTI) + "&" + param, null);
            break;
        case IBINSERT: // Insert
            if (!check_retrive) {
                ComShowMessage(getMsg("SPC90124"));
                return;
            }
            var row = sheetObj.DataInsert(-1);
            sheetObj.SetCellValue(row, "srep_cd", comObjects[2].GetSelectCode(), 0);
            sheetObj.SetCellValue(row, "trd_cd", comObjects[3].GetSelectCode(), 0);
            sheetObj.SetCellValue(row, "sub_trd_cd", comObjects[4].GetSelectCode(), 0);
            sheetObj.SetCellValue(row, "rlane_cd", comObjects[5].GetSelectCode(), 0);
            sheetObj.SetCellValue(row, "dir_cd", formObj.bound.value, 0);
            sheetObj.SetCellValue(row, "ioc_ts_cd", formObj.ioc.value, 0);
            sheetObj.SetCellValue(row, "fcast_cust_tp_cd", "B", 0);
            sheetObj.SelectCell(row, 1, true, "");
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

function changeAccountType() {
    //alert("changeAccountType"); 
//    var obj = event.srcElement;
//    var acct_tp = obj.value;
//    var sheetObj = sheetObjects[0];
//    for (var i = 0; i < sheetObj.RowCount(); i++) {
//        sheetObj.SetCellValue(i + 1, "fcast_cust_tp_cd", acct_tp);
//    }
}

/*Setting the value of selected pol popup in the sheet
 *
 */
function setSheet1PopUpValue(rowArray, row, col) {
    var sheetObj = sheetObjects[0];
    var colArray = rowArray[0];
//    var orgCd = sheetObj.GetCellValue(row, "fcast_cust_tp_cd");
    sheetObj.SetCellValue(row, "cust_cd", colArray[3]);
    sheetObj.SetCellValue(row, "cust_nm", colArray[4]);
    sheetObj.SetCellValue(row, "cust_cnt_cd", colArray[3].substring(0, 2));
    sheetObj.SetCellValue(row, "cust_seq", colArray[3].substring(2));
    sheetObj.SetCellValue(row, "fcast_cust_tp_cd", colArray[10]);
//    sheetObj.SetCellValue(row, "fcast_cust_tp_cd", orgCd); //
}
/*Setting the value of selected pol popup in the sheet
 *
 */
function setSheet1PopUpValue2(rowArray, row, col) {
	var sheetObj = sheetObjects[0];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, "ctrt_cust_cd", colArray[3]);
	sheetObj.SetCellValue(row, "ctrt_cust_nm", colArray[4]);
	sheetObj.SetCellValue(row, "ctrt_cust_cnt_cd", colArray[3].substring(0, 2));
	sheetObj.SetCellValue(row, "ctrt_cust_seq", colArray[3].substring(2));
}

/* In case of clicking pol common popup			
 *
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
    if (sheetObj.ColSaveName(col) == "cust_cd") {
        var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
        var cust_cd = sheetObj.GetCellValue(row, col);
        spcPopup("Customer", "cust_cd=" + cust_cd + "&ofc_cd=" + sub_ofc_cd, 770, 470, 'setSheet1PopUpValue', dispaly, row, col);
    }
    else if (sheetObj.ColSaveName(col) == "ctrt_cust_cd") {
    	var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
    	var ctrt_cust_cd = sheetObj.GetCellValue(row, col);
    	spcPopup("Customer", "cust_cd=" + ctrt_cust_cd + "&ofc_cd=" + sub_ofc_cd, 770, 470, 'setSheet1PopUpValue2', dispaly, row, col);
    }
}
var selectedCell_OldValue = 0;

function sheet1_OnSelectCell(sheetObj, orow, ocol, row, col) {
    selectedCell_OldValue = sheetObj.GetCellValue(row, col) * 1;
}

function sheet1_OnChange(sheetObj, row, col, value, oldValue) {
    switch (sheetObj.ColSaveName(col)) {
        case "cust_cd":
            if (ComTrim(value).length <= 0) {
                sheetObj.SetCellValue(row, "cust_nm", "", 0);
                break;
            } else if (ComTrim(value).length <= 2) {
                ComShowCodeMessage("COM12143", "Account Code", "2");
                sheetObj.SetCellValue(row, col, "", 0);
                //    				sheetObj.SetSelectCell(row, col);

                break;
            }
            if (isNaN(value.substring(2))) {
                ComShowMessage("Invalid Format");
                sheetObj.SetCellValue(row, col, "", 0);
                //    				sheetObj.SetSelectCell(row, col);
                break;
            }
            var value1 = value.toUpperCase();
            var rtn = "";
            if (value1 == "XX999999") {
                rtn = new Array("XX999999|", "OTHERS|");
            } else {
                rtn = getCodeList("CustAbbrNm", "cust_cnt_cd=" + value1.substring(0, 2) + "&cust_seq=" + value1.substring(2));
            }
            if (rtn[0] == "") {
                sheetObj.SetCellValue(row, col, "", 0);
                sheetObj.SetCellValue(row, "cust_nm", "", 0);
                break;
            }
            if (rtn[0].split("|").length > 2) {
                var cust_cd = value;
                spcPopup("Customer", "cust_cd=" + cust_cd + "&ofc_cd=" + sub_ofc_cd, 770, 470, 'setSheet1PopUpValue', dispaly, row, col);
                break;
            }
            sheetObj.SetCellValue(row, "cust_nm", rtn[1].split("|")[0], 0);
            sheetObj.SetCellValue(row, "cust_cnt_cd", value1.substring(0, 2), 0);
            sheetObj.SetCellValue(row, "cust_seq", value1.substring(2), 0);
            sheetObj.SetCellValue(row, col, value1, 0);
            break;
        case "ctrt_cust_cd":
        	if (ComTrim(value).length <= 0) {
        		sheetObj.SetCellValue(row, "ctrt_cust_nm", "", 0);
        		break;
        	} else if (ComTrim(value).length <= 2) {
        		ComShowCodeMessage("COM12143", "Account Code", "2");
        		sheetObj.SetCellValue(row, col, "", 0);
        		break;
        	}
        	if (isNaN(value.substring(2))) {
        		ComShowMessage("Invalid Format");
        		sheetObj.SetCellValue(row, col, "", 0);
        		break;
        	}
        	var rtn = "";
        	if (value == "XX999999") {
        		rtn = new Array("XX999999|", "OTHERS|");
        	} else {
        		rtn = getCodeList("CustAbbrNm", "cust_cnt_cd=" + value.substring(0, 2) + "&cust_seq=" + value.substring(2));
        	}
        	if (rtn[0] == "") {
        		sheetObj.SetCellValue(row, col, "", 0);
        		sheetObj.SetCellValue(row, "ctrt_cust_nm", "", 0);
        		break;
        	}
        	if (rtn[0].split("|").length > 2) {
        		var ctrt_cust_cd = value;
        		spcPopup("Customer", "cust_cd=" + ctrt_cust_cd + "&ofc_cd=" + sub_ofc_cd, 770, 470, 'setSheet1PopUpValue', dispaly, row, col);
        		break;
        	}
        	sheetObj.SetCellValue(row, "ctrt_cust_nm", rtn[1].split("|")[0], 0);
        	sheetObj.SetCellValue(row, "ctrt_cust_cnt_cd", value.substring(0, 2), 0);
        	sheetObj.SetCellValue(row, "ctrt_cust_seq", value.substring(2), 0);
        	sheetObj.SetCellValue(row, col, value, 0);
        	break;
        case "del_flag":
            break;
    }
    selectedCell_OldValue = value;
}

function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    if (newCode == "") return;

    var formObj = document.form;
    var trade = formObj.trade.value;

    if (trade != null && trade != '') {
        SpcSearchOptionSubTrade("subTrade", true, false, "", formObj.trade.value); // 0207 SHKIM			
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subTrade.value, true); // 0207 SHKIM
    }

}

function subTrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    if (newCode == "") return;

    var formObj = document.form;
    var subTrade = formObj.subTrade.value;

    if (subTrade != null && subTrade != '') {
        SpcSearchOptionLane("lane", true, true, '', formObj.trade.value, formObj.subTrade.value, true); // 0207 SHKIM
    }
}

function rgnOffice_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    if (newCode == "") return;
    var rtn = getCodeList("ChildOffice", "ofc_cd=" + newCode + "&level=5&include=1");
    initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));
    if (subOffice.GetSelectCode() == "") {
        var rtn = getCodeList("SalesRep", "ofc_cd=" + newCode + "&level=4");
        initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
    }
    var subObj = subOffice;
    subOffice_OnChange(subObj, -1, "", "", subObj.GetSelectIndex(), subObj.GetSelectText(), subObj.GetSelectCode());
}

function subOffice_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    document.form.subOffice_text.value = newCode;
    var rtn = "";
    if (newCode == "") {
        rtn = getCodeList("SalesRep", "ofc_cd=" + rgnOffice.SetSelectCode() + "&level=4");
    } else {
        rtn = getCodeList("SalesRep", "ofc_cd=" + newCode + "&level=5");
    }
    initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
}

function initDataValue_trade() {
    var sheetObj = trade;
    with(sheetObj) {
        SetSelectIndex(0);
    }
}

function initDataValue_subTrade() {
    var sheetObj = subTrade;
    with(sheetObj) {
        SetSelectIndex(0);
    }
}

function initDataValue_lane() {
    var sheetObj = lane;
    with(sheetObj) {
        SetSelectIndex(0);
    }
}

function initDataValue_rgnOffice() {
    var sheetObj = rgnOffice;
    with(sheetObj) {
        SetSelectIndex(0);
    }
}

function initData_rgnOffice(codes, names) {
    var sheetObj = rgnOffice;
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
            SetSelectCode(selectCode);
        } else {
            SetSelectIndex(0); //SetSelectIndex(0, 0);
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
            SetSelectCode(selectCode);
        } else {
            SetSelectIndex(0); //SetSelectIndex(0, 0);
        }
        SetEnable((GetItemCount() > 1));
        SetEnable(!(GetSelectIndex() > 1));
    }
}

function initDataValue_subOffice() {
    var sheetObj = subOffice;
    with(sheetObj) {
        SetSelectIndex(0);
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
            SetSelectCode(selectCode);
        } else {
            SetSelectIndex(0); //SetSelectIndex(0, 0);
        }
    }
}

function initDataValue_salesRep() {
    var sheetObj = salesRep;
    with(sheetObj) {
        SetSelectIndex(0);
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    switch (sAction) {
        case IBSEARCH: //Retrieve
            if (comObjects[2].GetSelectCode() == "") {
                ComShowMessage(getMsg("SPC90114", "Sales Rep"));
                return false;
            }
            if (formObj.ioc.value == "") {
                ComShowMessage(getMsg("SPC90114", "IOC"));
                formObj.ioc.focus();
                return false;
            }
            if (comObjects[3].GetSelectCode() == "") {
                ComShowMessage(getMsg("SPC90114", "Trade"));
                return false;
            }
            if (comObjects[4].GetSelectCode() == "") {
                ComShowMessage(getMsg("SPC90114", "Sub Trade"));
                return false;
            }
            if (comObjects[5].GetSelectCode() == "") {
                ComShowMessage(getMsg("SPC90114", "Lane"));
                return false;
            }
            if (formObj.bound.value == "") {
                ComShowMessage(getMsg("SPC90114", "Bound"));
                //formObj.bound.focus();
                return false;
            }
            return true;
        case IBSAVE:
            var frow = sheetObj.ColValueDup("cust_cd|fcast_cust_tp_cd|ctrt_cust_cd", 0);
            if (frow > 0) {                
                ComShowCodeMessage("COM131301", "[Account Code / Account Type] ");
                sheetObj.SetSelectCell(frow, "cust_cd");
                return false;
            }
            return true;
    }
    return true;
}

function sheet1_OnSaveEnd(sheetObj, Code, errMsg) {
    if (sheetObj.GetEtcData("status") == "OK") {
//        ComShowMessage("saved successfully.");
    	ComShowCodeMessage("COM130102", "Data"); // {?msg1} was saved successfully.	
    } else {
        ComShowMessage(errMsg);
    }
}

function optionSetting() {
    SpcSearchOptionTrade("trade");
    SpcSearchOptionSubTrade("subTrade", true, true);
    SpcSearchOptionLane("lane");
    SpcSearchOptionBound("bound");
}

function resizeSheet() {
    ComResizeSheet(sheetObjects[0]);
}
