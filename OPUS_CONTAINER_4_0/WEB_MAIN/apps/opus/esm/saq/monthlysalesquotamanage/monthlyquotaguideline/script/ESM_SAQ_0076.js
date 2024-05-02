/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0076.js
*@FileTitle  : Master Version Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_SAQ_0076 : business script for ESM_SAQ_0076
 */
var tabObjects = new Array();
var tabCnt = 0;
var currentTabIndex = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comObjects = new Array();
var comboCnt = 0;
var targetGroup = "";
var TRADE_BOUND_DATA = "";
var tabSearchParams = ["-1", "", ""];
var sXmlParam = "";
//var versionFlag;

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[currentTabIndex];
    /*******************************************************/
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        if (ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
            case "btn_retrieve": // retrieve
                changeSheetHead(sheetObject, currentTabIndex + 1);
                tabSearchParams[currentTabIndex] = ""; // 초기화
                doActionIBSheet(sheetObject, formObject, IBSEARCH);
                break;
                
            case "btn_new": // Initialization condition
                sheetObject.RemoveAll();
                formObject.reset();
                //Year, Quarter Setting
                setYearMonthObject(formObject.year, formObject.bse_qtr_cd);
                //Target Group Setting
                var tgtObj = targetGrp;
                if (tgtObj.GetItemCount() > 0) {
                    tgtObj.SetSelectIndex(0);
                }
                version_change();
                break;
                
            case "btn_saveasnew":
                flag = ComShowConfirm(ComGetMsg("SAQ90139", "Save As New Version"));
                if (flag) {
                    doActionIBSheet(sheetObject, formObject, IBSAVE);
                }
                break;
                
            case "btn_cancelcurrent":
                //if (formObject.btn_cancelcurrent.Enable == false ) return;
                if (!ComIsBtnEnable("btn_cancelcurrent")) return;
                flag = ComShowConfirm(getMsg("SAQ90140", "Cancel", formObject.version.value));
                if (flag) {
                    formObject.f_cmd.value = MODIFY01;
                    //formObject.f_cmd.value = COMMAND09;
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_confirmdraft":
                //if (formObject.btn_confirmdraft.Enable == false ) return;
                if (!ComIsBtnEnable("btn_confirmdraft")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Confirm"));
                if (flag) {
                    formObject.f_cmd.value = MODIFY02;
                    //formObject.f_cmd.value = COMMAND11;
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_cancelconfirmation":
                //if (formObject.btn_cancelconfirmation.Enable == false ) return;
                if (!ComIsBtnEnable("btn_cancelconfirmation")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Cancel Confirmation"));
                if (flag) {
                    formObject.f_cmd.value = MODIFY03;
                    //formObject.f_cmd.value = COMMAND12;
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_notifydraft":
                //if (formObject.btn_notifydraft.Enable == false ) return;
                if (!ComIsBtnEnable("btn_notifydraft")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Notify"));
                if (flag) {
                    formObject.f_cmd.value = MODIFY04;
                    //formObject.f_cmd.value = COMMAND21;
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                    //                            processNotify(sheetObject,formObject,IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_cancelnotification":
                //if (formObject.btn_cancelnotification.Enable == false ) return;
                if (!ComIsBtnEnable("btn_cancelnotification")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Cancel Notification"));
                if (flag) {
                    formObject.f_cmd.value = MODIFY05;
                    //formObject.f_cmd.value = COMMAND22;
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_confirmasfinal":
                //if (formObject.btn_confirmasfinal.Enable == false ) return;
                if (!ComIsBtnEnable("btn_confirmasfinal")) return;
                flag = ComShowConfirm(getMsg("SAQ90140", "Confirm", formObject.version.value));
                if (flag) {
                    formObject.f_cmd.value = MODIFY06;
                    //formObject.f_cmd.value = COMMAND31;
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_cancelfinal":
                //if (formObject.btn_cancelfinal.Enable == false ) return;
                if (!ComIsBtnEnable("btn_cancelfinal")) return;
                flag = ComShowConfirm(getMsg("SAQ90141", "Cancel Final", formObject.version.value + "-QF", formObject.version.value + "-QN"));
                if (flag) {
                    formObject.f_cmd.value = MODIFY07;
                    //formObject.f_cmd.value = COMMAND32;
                    doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC01);
                }
                break;
                
            case "btn_downexcel":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }
                break;
                
            case "btn_basedatacreation":
                doActionIBSheet(sheetObject, formObject, MODIFY01);
                break;

            case "btn_saveasfinal":
                //doActionIBSheet(sheetObject, formObject, MULTI02);
                break;
			case "bu_zoom_in1":
			case "bu_zoom_in2":
				zoomInOut(srcName, "IN");
				break;
			case "bu_zoom_out1":
			case "bu_zoom_out2":
				zoomInOut(srcName, "OUT");
                
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
 * 화면의 zoom IN 
 * @param srcName
 * @param p_inout
 * @returns
 */
function zoomInOut(srcName,p_inout){
	var sheetObj ;
	var param;
	param = srcName.substr(-1);
	
	sheetObj = sheetObjects[currentTabIndex];
	var cnt = sheetObj.RowCount()+2+6;
	if(sheetObj.RowCount()>10){// 조회 건수가 18개 보다 많을 경우 제어한다.
		if (p_inout == "IN"){
			sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, cnt>50?50:cnt));
			document.getElementById("div_zoom_in"  + param).style.display = "none";
			document.getElementById("div_zoom_out" + param).style.display = "inline";
		} else if (p_inout == "OUT" ) {
			sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, 18));
			document.getElementById("div_zoom_in"  + param).style.display = "inline";
			document.getElementById("div_zoom_out" + param).style.display = "none";
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
    var sheetResizeFull = true;
    // button control
    controlButtons("", document.form);
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.bse_qtr_cd);
    var objs = document.all.tabLayer;

    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        objs[i].style.display = "Inline";
        initSheet(sheetObjects[i], i + 1);
        objs[i].style.display = "none";
        ComEndConfigSheet(sheetObjects[i]);
    }
    
    resizeSheet();
    
    for (var k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    // Target Group setting
    var tgtObj = targetGrp;
    if (tgtObj.GetItemCount() > 0) {
        tgtObj.SetSelectIndex(0);
    }
    
    search_onChange();
    document.form.year.focus();  
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    		sheetObj.SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
    		changeSheetHead(sheetObj, sheetNo ,"init");

			var cols = [ 	{Type:"Text",	Hidden:0,  Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"",      	KeyField:0,   CalcLogic:"",   Format:"",            			PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
			             	{Type:"Text",   	Hidden:0,  Width:50,   	Align:"Center",  ColMerge:1,   SaveName:"",      	KeyField:0,   CalcLogic:"",   Format:"",            			PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
			              	{Type:"Text",   	Hidden:0,  Width:70,   	Align:"Center",  ColMerge:1,   SaveName:"item",  	KeyField:0,   CalcLogic:"",   Format:"",            			PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
			             	{Type:"Float",  	Hidden:0,  Width:90,   	Align:"Right",   ColMerge:0,   SaveName:"",      	KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   						UpdateEdit:0,   InsertEdit:0 },
			             	{Type:"Text",   	Hidden:1,  Width:0,    	Align:"Right",   ColMerge:0,   SaveName:"",      	KeyField:0,   CalcLogic:"",   Format:"",            			PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
			             	{Type:"Float",  	Hidden:0,  Width:90,   	Align:"Right",   ColMerge:0,   SaveName:"",      	KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   						UpdateEdit:0,   InsertEdit:0 } ];
			             	
			for (var i=0; i<4; i++) {
				cols.push({Type:"Text",      	Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"",     				UpdateEdit:0,   InsertEdit:0, 	PointCount:0 });
				cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   	UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   	UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   	UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   	UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   	UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Float",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   	UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Float",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"",      KeyField:0,   CalcLogic:"",   Format:"#,##0.#####" ,   	UpdateEdit:0,   InsertEdit:0 });
			}
			sheetObj.InitColumns(cols);
			sheetObj.SetEditable(0);
//			sheetObj.SetSheetHeight(390);			
//			sheetObj.SetRangeBackColor(1,3, 1,42,"#777777");
}

function resizeSheet() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComResizeSheet(sheetObjects[i]);
    }
}

/**
 */
function changeSheetHead(sheetObj, sheetNo, gubun) {
    var base_year = document.form.year.value;
    var quarter = eval(document.form.bse_qtr_cd.value.substring(0, 1) * 3) - 2;
    var month = new Array();
    var rtn = getCodeList("CommonCode", "codeNo=CD20011"); //month "01","02","03","04","05","06","07","08","09","10","11","12","01","02"
    var code = rtn[0].split("|");
    for (var i = 0; i < code.length + 1; i++) {
        if (i == 12) {
            month[i] = code[0];
        } else if (i == 13) {
            month[i] = code[1];
        } else {
            month[i] = code[i];
        }
    }
    var recent_yr_mon = "";
    var i, j = 0;
    var cur_qtr = document.form.bse_qtr_cd.value;
    with(sheetObj) {
        var HeadTitle = (sheetNo == 1 ? "Trade" : "Sub\nTrade") + "|Bound|Item|";
        if (quarter == 1) {
            recent_yr_mon = eval(base_year) - 1 + ".12";
        } else {
            recent_yr_mon = base_year + "." + month[quarter - 2];
        }
        for (i = 0; i < 1; i++) {
            HeadTitle = HeadTitle + "Recent Quota\n(As of " + recent_yr_mon + ")|";
        }
        HeadTitle = HeadTitle + "|Recent Target\n(As of " + recent_yr_mon + ")|";
        for (i = 0; i < 6; i++) {
            HeadTitle = HeadTitle + base_year + " " + cur_qtr + " Total(Sales Quota)|";
        }
        for (i = 0; i < 2; i++) {
            HeadTitle = HeadTitle + base_year + " " + cur_qtr + " Total\n(Load Target)|";
        }
        for (j = -1; j < 2; j++) {
            for (i = 0; i < 6; i++) {
                HeadTitle = HeadTitle + base_year + "." + month[quarter + j] + "(Sales Quota)|";
            }
            for (i = 0; i < 2; i++) {
                HeadTitle = HeadTitle + base_year + "." + month[quarter + j] + "(Load Target)|";
            }
        }
        var HeadTitle1 = (sheetNo == 1 ? "Trade" : "Sub\nTrade") + "|Bound|Item|Quarterly||Quarterly |";
        for (i = 0; i < 4; i++) {
            HeadTitle1 = HeadTitle1 + "Model\nResult|Guideline|Trade\nGroup|Regional\nGroup|Final|Final\nAdjusted|Initial|Final|";
        }

        if (gubun == "init") {
            var headers = [{
                Text: HeadTitle,
                Align: "Center"
            }, {
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
            changeHeaderRow(sheetObj, 0, HeadTitle);
            changeHeaderRow(sheetObj, 1, HeadTitle1);
        }
    }
    // Sheet Unit Setting
	var unit_text=document.form.unit.options[document.form.unit.selectedIndex].text;
	document.all("sheet_unit")[currentTabIndex].innerHTML="Unit : "+unit_text+" / USD / USD 1,000*";
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH:
            formObj.f_cmd.value = "";
            if (tabSearchParams[currentTabIndex] != searchQueryString(formObj)) {
                //log("checkModifiedSheet(sheetObjects[1])" + checkModifiedSheet(sheetObjects[1]));
                if (checkModifiedSheet(sheetObjects[1])) {
                    if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                        return;
                    }
                }
                if (validateForm(sheetObj, formObj, sAction) == false) {
                    break;
                }
                ComOpenWait(true);
                formObj.mqtaMdlVerNo.value = "";
                formObj.slsFcastPubNo.value = "";
                // log("sheetParams" + searchQueryString(formObj));
                tabSearchParams[currentTabIndex] = searchQueryString(formObj);
                if (currentTabIndex == 0) {
                    formObj.f_cmd.value = SEARCHLIST01;
                } else if (currentTabIndex == 1) {
                    formObj.f_cmd.value = SEARCHLIST02;
                }
                var sXml = sheetObj.GetSearchData("ESM_SAQ_0076GS.do", saqFormString(formObj));
                if (sXml != "") {
                    sheetObj.LoadSearchData(sXml, {
                        sync: 1
                    });
                    sXmlParam = sXml;
                }
                formObj.mqtaMdlVerNo.value = ComGetEtcData(sXml, "mqtaMdlVerNo");
                //    				    if (sheetObj.RowCount()> 0) {
                //    					    formObj.mqtaMdlVerNo.value=ComGetEtcData(sXml, "mqtaMdlVerNo");
                //    					    formObj.slsFcastPubNo.value=ComGetEtcData(sXml, "slsFcastPubNo");
                //    					    TRADE_BOUND_DATA=ComGetEtcData(sXml, "TRADE_BOUND");
                //    					    controlButtons(ComGetEtcData(sXml, "saqStsCd"), formObj);
                //    				    }
            }
            break;
            
        case IBSAVE:
            if (validateForm(sheetObj, formObj, sAction) == false) {
                return;
            }
            ComOpenWait(true);
            if (currentTabIndex == 0) {
                //formObj.f_cmd.value = COMMAND01;
                formObj.f_cmd.value = SEARCHLIST01;
            } else if (currentTabIndex == 1) {
                //formObj.f_cmd.value = COMMAND02;
                formObj.f_cmd.value = SEARCHLIST02;
            }
            sheetObj.SetWaitTimeOut(300);
            var sXml = sheetObj.GetSearchData("ESM_SAQ_0076GS.do", saqFormString(formObj) + "&" + "item", {
                Append: false
            });
            if (sXml != "") sheetObj.LoadSearchData(sXml, {
                sync: 1
            });

            if (sheetObj.GetEtcData("version") != "null") {
                version_change();
                formObj.version.value = sheetObj.GetEtcData("version");
            }
            tabSearchParams[currentTabIndex] = searchQueryString(formObj);
            controlButtons(sheetObj.GetEtcData("saqStsCd"), formObj);
            ComOpenWait(false);
            break;
            
        case IBSEARCH_ASYNC01: // Cancel Current Version()~ Confirm Draft
            // COMMAND09 : Cancel Current Version
            // COMMAND11 : Confirm Draft
            // COMMAND12 : Cancel Confirmation
            // COMMAND21 : Notify Draft
            // COMMAND22 : Cancel Notification
            // COMMAND31 : Confirm As Final
            // COMMAND32 : Cancel Final
            if (validateForm(sheetObj, formObj, sAction) == false) {
                return;
            }
            //    				sheetObj.GetSaveData("ESM_SAQ_0076GS.do", saqFormString(formObj), "item");
            ComOpenWait(true);
            var sParam = sheetObj.GetSaveString(0, 1, "item");
            sParam = sParam + "&" + saqFormString(formObj);
            var sXml = sheetObj.GetSaveData("ESM_SAQ_0076GS.do", sParam);
            sheetObj.LoadSaveData(sXml, {Sync: 1});

            var cur_version = formObj.version.value;
            version_change();
            controlButtons(sheetObj.GetEtcData("saqStsCd"), formObj);
            formObj.version.value = cur_version;
            ComOpenWait(false);
            break;
            
        case IBDOWNEXCEL: //excel download
            selectDownExcelMethod(sheetObj);
            break;
        
        case MODIFY01:            
            formObj.f_cmd.value=MODIFY01;
            selectVal = saqFormString(formObj);			  
		  	//sheetObj.DoSearch("ESM_SAQ_0182GS.do", selectVal);   
		  	var sXml = sheetObj.GetSaveData("ESM_SAQ_0182GS.do", selectVal);
            sheetObj.LoadSaveData(sXml, {Sync: 1});            
            //versionFlag = setInterval(version_change, 3000);	//밀리초  - 3초            
            version_change();
            break;
	 			
	  	case MULTI02:      
	    	if (formObj.newVersion.value == null || formObj.newVersion.value == "") {			
	 			break;
	 		}
	 		var flag=confirm(getMsg("SAQ90139", "save Version" + formObj.newVersion.value + " as Master Version"));
	 		
	 		if (flag) {
				formObj.f_cmd.value=MULTI02;
				selectVal = saqFormString(formObj);	
				//sheetObj.DoSearch("ESM_SAQ_0182GS.do", FormQueryString(formObj), "trd", false);
				var sXml = sheetObj.GetSaveData("ESM_SAQ_0182GS.do", selectVal);
            	sheetObj.LoadSaveData(sXml, {Sync: 1});
			}
			version_change();
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
                InsertItem("Trade", "");
                InsertItem("  Sub Trade ", "");
            }
            break;
    }
}

function resizeSheetLoadPage() {
    for (i = 0; i < sheetObjects.length; i++) {
        ComResizeSheet(sheetObjects[i],58);
    }
} 

var resizeFlag = 0;

/**
 * Event when clicking Tab
 * activating selected tab items
 */
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
    //resizeSheet();
    
    //20150112 정원호 로드 페이지 시에 스크롤이 발생하고 탭 이동 이후에는 생기지 않아서 처음 resize시에만 높이를 지정하여 resize하는 방법으로 처리 
	if(resizeFlag == 0){
        resizeSheetLoadPage();
        resizeFlag++;
    }else{
        resizeSheet();
    }    
    
    if (tabSearchParams[nItem] == "-1") {
        tabSearchParams[nItem] = "";
    } else {
        changeSheetHead(sheetObjects[currentTabIndex], currentTabIndex + 1);
        doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH);
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    //    		with(formObj){
    switch (sAction) {
        case IBSEARCH:
            if (targetGrp.GetSelectCode() == '') {
                ComShowCodeMessage("COM12113", "Target Group");
                return false;
            }
            if (ComIsNull(formObj.version.value)) {
                ComShowCodeMessage("COM12113", "Version");
                return false;
            }
            if (ComIsNull(formObj.trade)) {
                ComShowCodeMessage("COM12113", "Trade");
                return false;
            }
            if (ComIsNull(formObj.dirCd)) {
                ComShowCodeMessage("COM12113", "Bound");
                return false;
            }
            break;
        case IBSAVE:
            if (validateForm(sheetObj, formObj, IBSEARCH) == false) {
                return false;
            }
            if (ComIsNull(formObj.mqtaMdlVerNo.value)) {
                ComShowMessage(getMsg("SAQ90199", "Quarterly Quota Model Version Number"));
                return false;
            }
            break;
        case IBSEARCH_ASYNC01: // Confirm Draft check
            if (validateForm(sheetObj, formObj, IBSEARCH) == false) {
                return false;
            }
            if (ComIsNull(formObj.mqtaMdlVerNo.value)) {
                ComShowMessage(getMsg("SAQ90199", "Quarterly Quota Model Version Number"));
                return false;
            }
            break;
    } // switch end
    //} // with end
    return true;
}

/**
 * button control
 */
function controlButtons(stsCd, formObj) {    
    switch (stsCd) {
        case "00": // Init
            ComBtnEnable("btn_cancelcurrent");
            ComBtnEnable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            ComBtnDisable("btn_confirmasfinal");
            ComBtnDisable("btn_cancelfinal");
			
			ComBtnEnable("btn_saveasnew");
            break;
            
        case "FC": // Confirm Draft
            ComBtnEnable("btn_cancelcurrent");
            ComBtnDisable("btn_confirmdraft");
            ComBtnEnable("btn_cancelconfirmation");
            ComBtnEnable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            ComBtnDisable("btn_confirmasfinale");
            ComBtnDisable("btn_cancelfinal");
            
            //ComBtnDisable("btn_saveasfinal");
            ComBtnDisable("btn_saveasnew");
            break;
            
        case "FN": // Notify Draft
            ComBtnDisable("btn_cancelcurrent");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnEnable("btn_cancelnotification");
            ComBtnDisable("btn_confirmasfinal");
            ComBtnDisable("btn_cancelfinal");
            
            //ComBtnDisable("btn_saveasfinal");
            ComBtnDisable("btn_saveasnew");
            break;
            
        case "QN": // Quota Notification
            ComBtnDisable("btn_cancelcurrent");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            ComBtnEnable("btn_confirmasfinal");
            ComBtnDisable("btn_cancelfinal");
            
            //ComBtnDisable("btn_saveasfinal");
            ComBtnDisable("btn_saveasnew");
            break;
            
        case "QF": // Confirm As Final
            ComBtnDisable("btn_cancelcurrent");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmatione");
            ComBtnDisable("btn_notifydrafte");
            ComBtnDisable("btn_cancelnotification");
            ComBtnDisable("btn_confirmasfinal");
            ComBtnEnable("btn_cancelfinal");
            
            //ComBtnDisable("btn_saveasfinal");
            ComBtnDisable("btn_saveasnew");
            break;
            
        default: // Init && "XX" Cancel Current Version()
            ComBtnDisable("btn_cancelcurrent");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            ComBtnDisable("btn_confirmasfinal");
            ComBtnDisable("btn_cancelfinal");
            break;
    }
}

function search_onChange() { 		
	var params="year="+document.form.year.value	+ "&bse_qtr_cd="+document.form.bse_qtr_cd.value;
	getSelectCodeList(document.form.newVersion, "MonthlyQuotaModelVersion", params);
	
	var versionText = "";
	
	if(document.form.newVersion.value != "") {
		versionText = document.form.newVersion.options[document.form.newVersion.selectedIndex].text;
		ComBtnDisable("btn_basedatacreation");		
		if(versionText.lastIndexOf("F") != -1) { 			
			//ComBtnDisable("btn_saveasfinal");
		} else {			
			//ComBtnEnable("btn_saveasfinal");
		}
	} else {
		ComBtnEnable("btn_basedatacreation");
		//ComBtnDisable("btn_saveasfinal");
	}
}

/*
 *  Target Group 변경시
 */
function targetGrp_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {    
    targetGroup = comboObj.GetSelectCode();
    version_change();
    trade_change();
}

/*
 * Year / Target Group 변경시 version setting
 */
function version_change() {
    search_onChange();
    if (targetGroup == '') return;    
    var obj = document.form.version;
    var params = "&searchFlag=ALL" + "&year=" + document.form.year.value + "&bse_qtr_cd=" + document.form.bse_qtr_cd.value + "&targetGrp=" + targetGroup;
    getSelectCodeList(obj, "SaqMonthlyQuotaGuidelineVersion", params);
    
//    if(document.form.version.value != ""){
//    	clearInterval(versionFlag);
//    }
}

/*
 * version onChange() event
 */
function version_onChange() {
    var status = document.form.version.options[document.form.version.selectedIndex];
    var idx = status.indexOf("-");
    // NEW : reset, status == null ? 00.
    status = (status == "NEW" ? '' : (idx == -1 ? '00' : status.substring(idx + 1)));
    controlButtons(status, document.form);
}

/*
 * Trade setting in case of Target Group
 */
function trade_change() {
    var params = "targetGrp=" + targetGroup;
    getSelectCodeList(document.form.trade, "SaqTagetGroupTrade", params);
}

function searchQueryString(formObj) {
    return "targetGrp=" + targetGroup + "&year=" + formObj.year.value + "&bse_qtr_cd=" + formObj.bse_qtr_cd.value + "&version=" + formObj.version.value + "&trade=" + formObj.trade.value + "&dirCd=" + formObj.dirCd.value + "&unit=" + formObj.unit.value;
}

/**
 * changing in case of tradeSheet Yearly Target . min, max
 */
function tradeSheet_OnChange(Obj, Row, Col, Value) {
    with(Obj) {
        if (Row == 4 && ColSaveName(Col) == "target") {
            var max = eval(EtcData("max_lod"));
            var min = eval(EtcData("min_lod"));
            var lod = eval(GetCellValue(Row, Col));
            if (lod > max) {
                ComShowMessage(getMsg("SAQ90123", "Load", max));
                SetCellValue(Row, Col, max, 0);
            } else if (lod < min) {
                ComShowMessage(getMsg("SAQ90120", "Load", min));
                SetCellValue(Row, Col, min, 0);
            }
        }
    }
}

function tradeSheet_OnSearchEnd(Obj, ErrMsg) {
    ComOpenWait(false);
    with(Obj) {
        if (RowCount("R") > 0) {
            SetCellEditable(18, "target", 1);
            SetCellEditable(20, "target", 1);
            SetCellEditable(22, "target", 1);
            SetCellEditable(26, "target", 1);
        }
    }
    searchEnd(Obj, sXmlParam);
}

function subTradeSheet_OnSearchEnd(Obj, ErrMsg) {
    ComOpenWait(false);
    searchEnd(Obj, sXmlParam);
}

function parseCheckBoxStr(obj, isAll, option) {
    var str = "";
    if (isAll == undefined) {
        isAll = true;
    }
    if (option == undefined) {
        option = "";
    }
    if (obj.length != undefined) {
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].checked) {
                isCheck = "Y";
            } else {
                isCheck = "N"
            }
            str += obj[i].value + "|" + isCheck + ";";
        }
    } else {
        if (obj.checked) {
            isCheck = "Y";
        } else {
            isCheck = "N"
        }
        str += obj.value + "|" + isCheck + ";";
    }
    str += option;
    log("parseCheckBoxStr call : obj=" + obj.id + " return str=" + str);
    return str;
}
//    	function processNotify(sheetObj, formObject, sAction) {
//    		if(sheetObj.RowCount()== 0) return;
//    		var trd_cd=formObject.trade.value;
//    		var isChecked=false;
//    		if (trd_cd == 'IAS' || trd_cd == 'EMS' || trd_cd == 'COM') {
//    			isChecked=true;
//    		}
//    		// Popup draw
//    		initFinalConfirmPopup(isChecked);
//    	    var obj=document.getElementById("DIV__FINAL_POPUP__DIV");
//    	    var pObj=document.getElementsByName("notify_div")[0];
//    	    if( obj != null ){
//    	        var evtobj=window.event? window.event : e
//    	        var trdDir=TRADE_BOUND_DATA.split(";");
//    	        var heightOffset=24*(trdDir.length-1) ;
//    	        openDynamicDragPopup(obj,evtobj.offsetX,evtobj.offsetY,250,165+heightOffset,pObj);
//    	    }
//    	}

// click event.
function finalConfirmPopupOK(objName, html) {
    var divObj = document.getElementById(objName);
    var inputObjects = parseCheckBoxStr(document.getElementsByName("CHK_POLPOD"), false);
    log("inputObjects=" + inputObjects);
    var formObject = document.form;
    log("finalConfirmPopupOK] f_cmd=" + formObject.f_cmd.value + "//");
    formObject.inclPortFlag.value = inputObjects;
    //formObject.f_cmd.value = COMMAND21;
    formObject.f_cmd.value = MODIFY04;
    doActionIBSheet(sheetObjects[currentTabIndex], formObject, IBSEARCH_ASYNC01);
}

function check_click() {
    log("check_click] f_cmd=" + document.form.f_cmd.value + "//");
}

//  notify popup.
function initFinalConfirmPopup(isChecked) {
    var objName="FINAL_POPUP";
            var confirmMessage=getMsg("SAQ90138");
            var chkFlag=(isChecked ? "CHECKED" : "");
         	log("initFinalConfirmPopup] f_cmd=" + document.form.f_cmd.value + "//");
            var html="\n"
                +"<DIV id='"+objName+"'> \n"
                +" <TABLE style=\"WIDTH: 100%; BORDER-COLLAPSE: collapse; HEIGHT: 100%\"> \n"
                +" 	<TR> \n"
                +" 		<TD style='padding:2px; background-color:#FFFFFF; border:1px solid #A3A4C7;'> \n"
                //append for drag(s)
                        +" <TABLE border=1 style=\"WIDTH: 100%; BORDER-COLLAPSE: collapse; \"> \n"
                        +" 		<tr> \n"
                        +" 			<td >  \n"
                                    +" 	<table style='padding:0px; width:100% ;border:0px;height:9px;cursor:hand;' > \n"
                                    +" 		<tr> \n"
                                    +" 			<td style=' font-size: 1px;padding:0px; background-color:#1083CF; border:0px solid #A3A4C7;' >"
                                    +"<img src='/opuscntr/img/space.gif' width='100%' height='20' border='1'  onDragStart=\"dynamicPopupDragStart()\"  onDragEnd=\"dynamicPopupDragEnd()\" onDrag=\"dynamicPopupDrag()\"></td> \n"
                                    +" 		</tr> \n"
                                    +" 	</table> \n"
                        +" 		 </td> \n"
                        +" 		</tr> \n"
                        +"  </TABLE> \n"
                 //append for drag(e)
                +" 			<table border=1 width=100% valign='top' !height=100%> \n"
                +" 				<tr> \n"
                +" 					<td width=100% > \n"
                +" 										<TABLE style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'> \n"
                +" 											<TR style='height:50;font-family: Arial; font-weight:800;  font-size: 11px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'> \n"
                +" 												<TD width='90%' style='border:1px solid #A3A4C7;'> \n"
                +" 													  "+confirmMessage +" \n"
                +" 												</TD> \n"
                +" 											</TR> \n"
                +" 											<TR style='height:25;font-family: Arial; font-weight:800;  font-size: 10px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'> \n"
                +" 												<TD width='90%' align='center' style='border:1px solid #A3A4C7;'> \n"
                +" <table   style='border-collapse: collapse;width:100%; border:1px solid #A3A4C7;' border='1'>"
                +"  <tr style='height:20;font-family: Arial; font-weight:800;  font-size: 11px;text-align:center; color: #000000;background-color:#E9F0F0; border:1px solid #A3A4C7;'>"
                +        "<td>Trade</td><td>Bound</td><td>BY POL POD</td>"
                +"</tr> ";
    	        var trdDir=TRADE_BOUND_DATA.split(";");
    	        var data="";
    	        var isChecked="";
    	        for(var i=0 ; i < trdDir.length-1 ; i++){
    	           data=trdDir[i].split("|");
    	           if( data[0] == "IAS" || data[0] == "EMS"){
    	               isChecked="checked";
    	           }else{
    	               isChecked="";
    	           }
                    html += "  <tr style='height:20;font-family: Arial; font-weight:500;  font-size: 8px;text-align:center; color: #000000;background-color:#E9F0FB; border:1px solid #A3A4C7;'>"
                    +"       <td>"+data[0]+"</td><td>"+data[1]+"</td><td><INPUT type='checkbox' " + chkFlag + " name='CHK_POLPOD' value='"+data[0]+"|"+data[1]+"' "+isChecked+"></td>"
                    +"</tr> ";
    	        }
                html +=" </table>"
                +" 													  \n"
                +" 												</TD> \n"
                +" 											</TR> \n"
                +"      								</TABLE> \n"
                +" 					</td> \n"
                +" 				</tr> \n"
                +" 			</table> \n"
                +" 			<TABLE border=1 style=\"WIDTH: 100%; HEIGHT: 26px\"> \n"
                +" 				<TR> \n"
                +" 					<TD style='padding:3px; background-color:#FFFFFF; border:1px solid #A3A4C7;'> \n"
                +" 						<TABLE style=\"WIDTH: 100%; HEIGHT: 20px\"> \n"
                +" 							<TR> \n"
                +" 								<TD align=middle> \n"
                +" 									<IMG style='cursor:hand' onclick='dynamicPopupClose();finalConfirmPopupOK(\""+objName+"\");' height=20 src=\"/opuscntr/img/opus/button/btn_ok.gif\" width=66 border=0 name=btn_ok> \n"
                +" 								</TD> \n"
                +" 								<TD align=middle> \n"
                +" 									<IMG style='cursor:hand' onclick=dynamicPopupClose() height=20 src=\"/opuscntr/img/opus/button/btn_close.gif\" width=66 border=0 name=btn_close> \n"
                +" 								</TD> \n"
                +" 							</TR> \n"
                +" 						</TABLE> \n"
                +" 					</TD> \n"
                +" 				</TR> \n"
                +" 			</TABLE> \n"
                +" 		</TD> \n"
                +" 	</TR> \n"
                +" </TABLE> \n"
                +"</DIV>";
            if(document.getElementById("DIV__"+objName+"__DIV") == null ){
                var obj=document.createElement("DIV");
                obj.id="DIV__"+objName+"__DIV";
                obj.style.display="none";
                obj.innerHTML=html;
                document.body.appendChild(obj);
            }else{
                var obj=document.getElementById("DIV__"+objName+"__DIV");
                obj.style.display="none";
                obj.innerHTML=html;
            }
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_qtr_cd");
    SaqSearchOptionTargetGroup("targetGrp", document.form.ofcCd.value, false);
    SaqSearchOptionComCode("dirCd", "CD00593", false);
    SaqSearchOptionComCode("unit", "CD00897", false);
}

function searchEnd(sheetObj, sXml) {
    var formObj = document.form;
    if (sheetObj.RowCount() > 0) {
        formObj.mqtaMdlVerNo.value = ComGetEtcData(sXml, "mqtaMdlVerNo");
        formObj.slsFcastPubNo.value = ComGetEtcData(sXml, "slsFcastPubNo");
        TRADE_BOUND_DATA = ComGetEtcData(sXml, "TRADE_BOUND");
        controlButtons(ComGetEtcData(sXml, "saqStsCd"), formObj);
    }
}