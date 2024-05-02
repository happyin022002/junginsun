/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0075.js
*@FileTitle  : Monthly Quota Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var initSelect = 1;
var logObj = new Array("SUB_TRADE_INPUT", "LANE_INPUT", "AQ_INPUT", "RGN_INPUT", "POL_INPUT", "POD_INPUT", "ITEM_INPUT");
logObj["SUB_TRADE"] = new Array("false");
logObj["LANE"] = new Array("false");
logObj["AQ"] = new Array("false");
logObj["RGN_OFC"] = new Array("false");
logObj["POL_CD"] = new Array("false");
logObj["POD_CD"] = new Array("false");
logObj["ITEM"] = new Array("true");
var sheetObjects = new Array();
var sheetCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var currentTabIndex = 0;
var comObjects = new Array();
var comboCnt = 0;
var tabSearchParams = ["-1", "", "", ""];
var perfIFdate = "";
var monthNames = new Array();
var monthNumbers = new Array();
var MQTA_STEP_CD = "04";
var WORK_STEP_CD = "04";
var isSearchEnd = false;
var saveParams = "";
var tabSaveParams = "";
var searchSaqStsCd = ""; // version saq_sts_cd
var isSheetEdited = false;
var BSA = 1;
var VOYAGE = 2;
var LOAD = 3;
var LF = 4;
var GREV = 5;
var GRPB = 6;
var CM = 7;
var RA_CM = 8;
var CMB = 9;
var RA_CMB = 10;
var OP = 11;
var RA_OP = 12;
var OPB = 13;
var RA_OPB = 14;
var ICO_FILTER_IDX = 1;
var FILTER_TEXT = "";
var btn_name = "";
var msgArr = new Array();

//Event handler processing by button click event */
document.onclick = processButtonClick;

//Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[currentTabIndex];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        btn_name = srcName; // DownExcel에서 구분자로 사용하기 위해서 세팅함
        if (ComGetBtnDisable(srcName)) return false;
        //           		var srcObj=window.event.srcElement;
        //                if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
        // stting command COMMAND
        formObject.f_cmd.value = getCommandByStep(srcName);
        if (ComGetBtnDisable(srcName)) {
            return false;
        }
        switch (srcName) {
            case "help": // Version()Help
                //    					popupCodeInfo(event.screenX,event.screenY,event.offsetX,event.offsetY);
                popupHelpInfo();
                break;
            case "btng_go":
                tabSearchParams[currentTabIndex] = "";
                doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC02);
                break;
            case "btn_retrieve":
                doActionIBSheet(sheetObjects[3], formObject, IBSEARCH);
                break;
            case "btn_go_retrieve":
                doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC03);
                break;
            case "btn_retrieve2": // retrieve
                doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC03);
                break;
            case "btn_new": // initial search condition
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                formObject.reset();
                controlButtons("", document.form); /* button control */
                monthSetting();
                setYearMonthObject(formObject.year, formObject.bse_quarter);
                var rtn = getCodeList("SaqMonthlyQuotaPerfIFDate", "ofcCd=" + document.form.ofcCd.value);
                perfIFdate = "( Last Update : " + rtn[0].substring(0, 16) + " )";
                changePfmcFromTo(); /* PFMC - setting date */
                changeVersion(); /* Versionsetting */
                break;
            case "btn_save": // save
            case "btn_save1": // save
                if (!ComIsBtnEnable("btn_save")) return;
                doActionIBSheet(sheetObjects[3], formObject, IBSAVE);
                break;
            case "btn_saveasnew": // save of New Version()
                //if (!ComIsBtnEnable("btn_saveasnew")) return;
                // msgs['SAQ90139'] = "Do you want to "+msg1+"?";
                flag = ComShowConfirm(getMsg("SAQ90139", "Save As New Version"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSAVE);
                }
                break;
            case "btn_cancelcurrent":
                //if (!ComIsBtnEnable("btn_cancelcurrent")) return;
                // msgs['SAQ90140'] = "Do you want to "+msg1+" the Version No. "+msg2+"?";
                flag = ComShowConfirm(getMsg("SAQ90140", "Cancel", formObject.mQtaVerNo.value));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_confirmdraft":
                // msgs['SAQ90139'] = "Do you want to "+msg1+"?";
                flag = ComShowConfirm(getMsg("SAQ90139", "Confirm"));
                if (flag) {
                    formObject.f_cmd.value = getCommandByStep(srcName);
                    formObject.mQtaStepCd.value = MQTA_STEP_CD;
                    // desabled button
                    disableAllButton();
                    if (isSheetEdited) {
                        // checking moidfy sheet
                        if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                            controlButtons(searchSaqStsCd, formObject);
                            return;
                        }
                    }

                    if (formObject.f_cmd.value == MODIFY04) {
                        validateConfirmCheck(sheetObjects[3], formObject);
                        //    							var rtn = validateConfirmCheck(sheetObjects[3], formObject);
                        //    							if(rtn == true){
                        //    								formObject.f_cmd.value = MODIFY04;
                        //    								doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
                        //    							}
                    }

                    //    						doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
                }
                break;
            case "btn_cancelconfirmation":
                //if (!ComIsBtnEnable("btn_cancelconfirmation")) return;
                // msgs['SAQ90139'] = "Do you want to "+msg1+"?";
                flag = ComShowConfirm(getMsg("SAQ90139", "Cancel Confirmation"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_notifydraft":
                //if (!ComIsBtnEnable("btn_notifydraft")) return;
                // msgs['SAQ90139'] = "Do you want to "+msg1+"?";
                flag = ComShowConfirm(getMsg("SAQ90139", "Notify"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_cancelnotification":
                //if (!ComIsBtnEnable("btn_cancelnotification")) return;
                // msgs['SAQ90139'] = "Do you want to "+msg1+"?";
                flag = ComShowConfirm(getMsg("SAQ90139", "Cancel Notification"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_downexcel":
                if (sheetObject.RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                }
                break;
            case "btng_adj_downexcel":
                if (sheetObjects[3].RowCount() < 1) { //no data
                    ComShowCodeMessage("COM132501");
                } else {
                    doActionIBSheet(sheetObjects[3], formObject, IBDOWNEXCEL);
                }
                break;
            case "btng_excelimportexport":
                excelimportexport();
                break;
            case "btng_monthly_adj":
                //if (!ComIsBtnEnable("btng_monthly_adj")) return;
                openMonthlyAdj();
                break;
            case "edit_mode": //Edit Mode click
                //if (!ComIsBtnEnable("btng_apply")) return;
                changeEditMode();
                break;
            case "btng_apply":
                //if (!ComIsBtnEnable("btng_apply")) return;
                processCalcApply();
                break;
            case "btng_officeadd":
                officeAdd();
                break;
            case "bu_zoom_in1":
            case "bu_zoom_in2":
            case "bu_zoom_in3":
            case "bu_zoom_in4":
                zoomInOut(srcName, "IN");
                break;
            case "bu_zoom_out1":
            case "bu_zoom_out2":
            case "bu_zoom_out3":
            case "bu_zoom_out4":
                zoomInOut(srcName, "OUT");
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowCodeMessage("COM12111");
        } else {
            ComShowMessage(e);
        }
    }
}

/**
 * 화면의 zoom IN 
 * @param srcName
 * @param p_inout
 * @returns
 */
function zoomInOut(srcName, p_inout) {
    var sheetObj;
    var param;
    param = srcName.substr(-1);

    if (param == "4") {
        sheetObj = sheetObjects[3];
    } else {
        sheetObj = sheetObjects[currentTabIndex];
    }
    var cnt = sheetObj.RowCount() + 2 + 6;
    if (sheetObj.RowCount() > 10) { // 조회 건수가 18개 보다 많을 경우 제어한다.
        if (p_inout == "IN") {
            sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, cnt > 50 ? 50 : cnt));
            document.getElementById("div_zoom_in" + param).style.display = "none";
            document.getElementById("div_zoom_out" + param).style.display = "inline";
        } else if (p_inout == "OUT") {
            sheetObj.SetSheetHeight(ComGetSheetHeight(sheetObj, 18));
            document.getElementById("div_zoom_in" + param).style.display = "inline";
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
    monthSetting();
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.bse_quarter);
    var rtn = getCodeList("SaqMonthlyQuotaPerfIFDate", "ofcCd=" + document.form.ofcCd.value);
    perfIFdate = "( Last Update : " + rtn[0].substring(0, 16) + " )";
    setQTGroupToRhqOffice();
    controlButtons("", document.form);
    var objs = document.all.tabLayer;
    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        //    			if( i < 3 ){
        //        		  objs[i].style.display="Inline";
        //    			}
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (var k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }
    // PFMC - Date setting
    changePfmcFromTo();
    header_rows = sheetObjects[3].HeaderRows();
    if (isDevMode) {
        formObj.ofcCd.readOnly = false;
        sheetObjects[3].SetColHidden("edt_step_val", 0);
        sheetObjects[3].SetColHidden("tot_bsa", 0);
        sheetObjects[3].SetColHidden("rgn_grp", 0);
        //    			formObj.btng_excelimportexport.style.display = "Inline";
    } else {
        //    			formObj.btng_excelimportexport.style.display = "none";
    }
    sheetObjects[3].SetColHidden("pol_cd", 1);
    sheetObjects[3].SetColHidden("pod_cd", 1);
    document.form.year.focus();
}

//initial month
function monthSetting() {
    var rtn = getCodeList("CommonCode", "codeNo=CD01915"); // "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Jan","Feb"
    var code = rtn[0].split("|");
    for (var i = 0; i < code.length + 1; i++) {
        if (i == 12) {
            monthNames[i] = code[0];
        } else if (i == 13) {
            monthNames[i] = code[1];
        } else {
            monthNames[i] = code[i];
        }
    }
    rtn = getCodeList("CommonCode", "codeNo=CD20011"); // "12","01","02","03","04","05","06","07","08","09","10","11","12","01","02"
    code = rtn[0].split("|");
    for (var i = 0; i < code.length + 2; i++) {
        if (i == 0) {
            monthNumbers[i] = code[11];
        } else {
            if (i == 13) {
                monthNumbers[i] = code[0];
            } else if (i == 14) {
                monthNumbers[i] = code[1];
            } else {
                monthNumbers[i] = code[i - 1];
            }
        }
    }
}

// Org setting
function setQTGroupToRhqOffice() {
    var vl = getCodeList("QTGroupToRhqOffice", "ofc_cd=" + document.form.ofcCd.value);
    if (vl != "") {
        var code = vl[0].split("|");
        document.form.ofcCd.value = code[0];
    }
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      // Target Group / Trade sheet1 init
		case 2:      // Sub-Trade sheet3 init
			with(sheetObj){
				changeHeadTitle(sheetObj,"INIT");
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:3, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
				var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				for (var i=0; i<4; i++) {
					cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				}
	
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj,18));
				//SetSheetHeight(230);
				//SetRangeBackColor(1, 2, 1, 24,"#777777");
			}
			break;
		case 3:      // Lane Sheet init
			with(sheetObj){
				changeHeadTitle(sheetObj,"INIT");
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:5, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
				var cols = [ {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"subTrd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lane",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"aqCd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rgnOfcCd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1},
				{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				
				for (var i=0; i<4; i++) {
					cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				}
	
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj,18));
				//SetRangeBackColor(1, 2, 1, 27,"#777777");
				//InitTreeInfo("tree", "sLevel", "#0000FFNAN");
			}
			break;
		case 4:      //rhqAdjSheet
			with(sheetObj){
				target_month_init();
				rhqAdjSheet_changeHeadTitle(sheetObj,"INIT");
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:7, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
				var cols = [ {Type:"Text",      Hidden:0,                Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_grp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_aq_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_rgn_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Float",     Hidden:0,                Width:85,   Align:"Right",   ColMerge:0,   SaveName:"monthly",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fcast",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mdl_rslt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"initial",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rhq",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,                Width:120,  Align:"Center",  ColMerge:1,   SaveName:"remarks",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"edit_flag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"lane_sprt_grp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rgn_pol_pod",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"sprt_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"item_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"edt_step_val",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"org_step_val",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"grs_rpb_rev",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cm_uc_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"opfit_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ra_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ra_opfit_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tot_bsa",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"low_lod",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rgn_grp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
				InitColumns(cols);
				SetEditable(1);
				SetImageList(1,ICO_FILTER);
	
				SetCellImage(0, "sub_trd_cd",1);
				SetCellImage(0, "lane_grp",1);
				SetCellImage(0, "pol_cd",1);
				SetCellImage(0, "pod_cd",1);
				SetCellImage(0, "ctrt_aq_cd",1);
				SetCellImage(0, "ctrt_rgn_ofc_cd",1);
				SetCellImage(0, "item",1);
	
				SetWaitImageVisible(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj,18));
				//SetRangeBackColor(1, 6, 1, 12,"#777777");
			}
			break;
		case 5:      //rmkSheet
			with(sheetObj){
				var HeadTitle="rlane_cd|sprt_grp_cd|bsa_grp_cd|ctrt_rhq_cd|pol_cd|pod_cd|rlane_grp|subj_ctnt|cmt_ctnt|rmk_cre_gdt|cre_ofc_cd";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"sprt_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ctrt_rgn_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rlane_grp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"subj_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cmt_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rmk_cre_gdt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
				InitColumns(cols);
				SetEditable(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj,18));
			}
			break;
	}
}

/*
 *setting title
 */
function changeHeadTitle(sheetObj, pInit) {
    var year = document.form.year.value;
    var mon = getQuarterToMonth(document.form.bse_quarter.value);
    var monIdx = mon - 1;
    var before_year = (monIdx == 0) ? eval(year - 1) : year;
    var HeadTitle = "";
    var HeadTitle1 = "";

    if (sheetObj.id == "rhqLaneSheet") {
        HeadTitle = "Sub \nTrade|Lane|Area\nDirector|Regional\nOffice|Item|Tree|" + "Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|" + "Recent Quota\n(" + before_year + "." + monthNumbers[monIdx] + ")|";
        HeadTitle1 = "Sub \nTrade|Lane|Area\nDirector|Regional\nOffice|Item|Tree|Quota|Est.\nPFMC|+/-|%|Quarterly|";
    } else {
        var keyHead = (sheetObj.id == "t1sheet1" ? "Trade|Bound|Item|" : "Sub \nTrade|Bound|Item|");
        HeadTitle = keyHead + "Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|" + "Recent Quota\n(" + before_year + "." + monthNumbers[monIdx] + ")|";
        HeadTitle1 = keyHead + "Quota|Est.\nPFMC|+/-|%|Quarterly|";
    }
    for (var j = 0; j < 4; j++) {
        HeadTitle = HeadTitle + year + " " + document.form.bse_quarter.value + " Total|";
    }
    for (var i = 0; i < 3; i++) {
        for (var j = 0; j < 4; j++) {
            HeadTitle = HeadTitle + year + "." + monthNumbers[monIdx + 1] + "|";
        }
        if (monIdx == 11) {
            year = year + 1;
        }
        monIdx++;
    }
    // HeadTitle1 setting
    for (var i = 0; i < 4; i++) {
        HeadTitle1 = HeadTitle1 + "Model\nResult|Guideline|Initial|Final|";
    }

    if (pInit == "INIT") {
        var info = {
            Sort: 0,
            ColMove: 0,
            HeaderCheck: 0,
            ColResize: 1
        };
        var headers = [{
            Text: HeadTitle,
            Align: "Center"
        }, {
            Text: HeadTitle1,
            Align: "Center"
        }];
        sheetObj.InitHeaders(headers, info);

    } else {
        changeHeaderRow(sheetObj, 0, HeadTitle);
        changeHeaderRow(sheetObj, 1, HeadTitle1);
    }
    var unit_text = document.form.unit.options[document.form.unit.selectedIndex];
    document.all("sheet_unit")[currentTabIndex].innerHTML = "Unit : " + unit_text.text + " / USD / USD 1,000*";
}

/*
 * Setting Title
 */
function rhqAdjSheet_changeHeadTitle(sheetObj, pInit) {
    var year = document.form.target_month.value.substring(0, 4);
    var month = document.form.target_month.value.substring(4);
    var before_year = (month == "01") ? year - 1 : year;
    //var before_month=monthNumbers[eval(month)-1];
    var before_month = 0;
    var HeadTitle = "Sub\nTrade" + FILTER_TEXT + "|Lane" + FILTER_TEXT + "|POL" + FILTER_TEXT + "|POD" + FILTER_TEXT + "|Area\nDirector" + FILTER_TEXT + "|Regional\nOffice" + FILTER_TEXT + "|Item" + FILTER_TEXT + "|";
    var HeadTitle1 = HeadTitle;
    HeadTitle = HeadTitle + "Recent Quota\n(" + before_year + "." + before_month + ")|";
    for (var j = 0; j < 4; j++) {
        HeadTitle = HeadTitle + year + "." + month + "|";
    }
    HeadTitle = HeadTitle + "Remarks|";
    HeadTitle1 = HeadTitle1 + "Quarterly|" + "Model\nResult|Guideline|Initial|Final|Remarks|";

    var hiddenTitle = "edit_flag|lane_sprt_grp|rgn_pol_pod|rlane_cd|sprt_grp_cd|bsa_grp_cd|item_seq|ibflag|edt_step_val|org_step_val|lod_qty|grs_rpb_rev|cm_uc_amt|opfit_uc_amt|ra_cm_uc_amt|ra_opfit_uc_amt|tot_bsa|low_lod|rgn_grp";
    HeadTitle = HeadTitle + hiddenTitle;
    HeadTitle1 = HeadTitle1 + hiddenTitle;
    if (pInit == "INIT") {
        var info = {
            Sort: 0,
            ColMove: 0,
            HeaderCheck: 0,
            ColResize: 1
        };
        var headers = [{
            Text: HeadTitle,
            Align: "Center"
        }, {
            Text: HeadTitle1,
            Align: "Center"
        }];
        sheetObj.InitHeaders(headers, info);

    } else {
        changeHeaderRow(sheetObj, 0, HeadTitle);
        changeHeaderRow(sheetObj, 1, HeadTitle1);
    }

    var unit_text = document.form.unit.options[document.form.unit.selectedIndex];
    document.all("adj_sheet_unit").innerHTML = "Unit : " + unit_text.text + " / USD";
}

// rhqAdjSheet target_month setting
function target_month_init(isReload) {
    var formObj = document.form;
    var target_year = formObj.year.value;
    var mon = getQuarterToMonth(document.form.bse_quarter.value);
    var monIdx = mon - 1;
    // rhqAdjSheet Month object
    var obj = formObj.target_month;
    if (obj.options.length > 0 && isReload == false && target_year == obj.options[0].value.substring(0, 4) && mon == obj.options[0].value.substring(4)) {
        return;
    }
    for (i = 0; i < 3; i++) {
        // rhqAdjSheet Month setting
        obj.options[i] = new Option(monthNames[monIdx], target_year + monthNumbers[monIdx + 1]);
        if (monIdx == 11) target_year = target_year + 1;
        monIdx++;
    }
}

// handling process after ending sheet1 retrieve
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH_ASYNC02:
            if (formObj.mqtaMdlVerNo.value != "" && (tabSearchParams[currentTabIndex] != getTabLocalParams())) {
                if (currentTabIndex == 0) {
                    formObj.f_cmd.value = SEARCHLIST02;
                } else if (currentTabIndex == 1) {
                    formObj.f_cmd.value = SEARCHLIST03;
                } else if (currentTabIndex == 2) {
                    formObj.f_cmd.value = SEARCHLIST04;
                }
                if (validateForm(sheetObj, formObj, sAction) == false) {
                    break;
                }
                ComOpenWait(true);
                changeHeadTitle(sheetObj, "");
                tabSearchParams[currentTabIndex] = getTabLocalParams();
                var params = "f_cmd=" + formObj.f_cmd.value + tabSearchParams[currentTabIndex];

                var sXml = sheetObj.GetSearchData("ESM_SAQ_0075GS.do", params);
                if (sXml != "") sheetObj.LoadSearchData(sXml, {
                    sync: 1
                });

                //    				    if (currentTabIndex == 2) {
                //    					} else {
                //    						sheetObj.FrozenCols=7;
                //    					}
                ComOpenWait(false);
            }
            break;
        case IBSEARCH:
            formObj.f_cmd.value = SEARCHLIST;
            formObj.mQtaStepCd.value = MQTA_STEP_CD;
            // desabled button
            disableAllButton();
            if (isSheetEdited) {
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    controlButtons(searchSaqStsCd, formObj);
                    return;
                }
            }
            if (validateForm(sheetObj, formObj, sAction) == false) {
                controlButtons(searchSaqStsCd, formObj);
                break;
            }
            saveParams = "";
            target_month_init(true);
            sub_trd_cd_init();
            ComOpenWait(true);
            rhqAdjSheet_changeHeadTitle(sheetObj, "");
            var version = formObj.version.value.split(":");
            if (document.form.glineVerNo.value != version[1] || document.form.mQtaVerNo.value != version[0]) {
                document.form.mQtaVerNo.value = version[0];
                document.form.glineVerNo.value = version[1];
            }
            sheetObj.DoSearch("ESM_SAQ_0075GS.do", saqFormString(formObj));
            ComOpenWait(false);
            break;
        case IBSEARCH_ASYNC03:
            formObj.f_cmd.value = SEARCHLIST;
            formObj.mQtaStepCd.value = MQTA_STEP_CD;
            if (saveParams == "") {
                return;
            }
            if (isSheetEdited) {
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    return;
                }
            }
            ComOpenWait(true);
            rhqAdjSheet_changeHeadTitle(sheetObj, "");
            saveParams = replaceParams(saveParams, "target_month", formObj.target_month.value);
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            saveParams = replaceParams(saveParams, "mQtaStepCd", formObj.mQtaStepCd.value);
            saveParams = replaceParams(saveParams, "search_sub_trd_cd", formObj.search_sub_trd_cd.value);
            saveParams = replaceParams(saveParams, "search_rlane_cd", formObj.search_rlane_cd.value);
            var tmpP = saveParams;
            sheetObjects[3].DoSearch("ESM_SAQ_0075GS.do", tmpP);
            ComOpenWait(false);
            break;
        case IBSAVE:
            // COMMAND01 : Save
            // MODIFY01 : Save As New Version
            formObj.mQtaStepCd.value = WORK_STEP_CD;
            // desabled button
            disableAllButton();
            if (validateForm(sheetObj, formObj, sAction) == false) {
                controlButtons(searchSaqStsCd, formObj);
                return;
            }
            ComOpenWait(true);
            saveParams = replaceParams(saveParams, "mQtaStepCd", WORK_STEP_CD);
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            sheetObj.DoSave("ESM_SAQ_0075GS.do", saveParams, "ibflag", false);
            //log("IBSAVE DoSaveEnd..................");
            isSheetEdited = false;
            ComOpenWait(false);
            break;
        case IBSEARCH_ASYNC01:
            formObj.mQtaStepCd.value = MQTA_STEP_CD;
            // desabled button
            disableAllButton();
            if (isSheetEdited) {
                // checking moidfy sheet
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    controlButtons(searchSaqStsCd, formObj);
                    return;
                }
            }
            controlButtons(searchSaqStsCd, formObj);
            ComOpenWait(true);
            saveParams = replaceParams(saveParams, "mQtaStepCd", MQTA_STEP_CD);
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            //    				sheetObj.DoSave("ESM_SAQ_0075GS.do", saveParams, "ibflag", false);

            var sParam = sheetObj.GetSaveString(0, 1, "ibflag");
            var sXml = sheetObj.GetSaveData("ESM_SAQ_0075GS.do", sParam + "&" + saveParams);
            sheetObj.LoadSaveData(sXml);

            if (sheetObj.GetEtcData("saqStsCd") != "null" && sheetObj.GetEtcData("saqStsCd") != undefined) {
                // retrieve after save
                var cur_version = formObj.version.value;
                changeVersion();
                formObj.version.value = cur_version;
                searchSaqStsCd = sheetObj.GetEtcData("saqStsCd");
                controlButtons(searchSaqStsCd, formObj);
                changeEditMode();
            }
            isSheetEdited = false;
            ComOpenWait(false);
            break;
        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCHLIST05;
            param = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            sheetObj.DoSearch("ESM_SAQ_0075GS.do", param, {
                Append: false
            });
            break;
        case IBDOWNEXCEL: // excel download
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
    if (btn_name == "btn_downexcel") {
        sheetObj = sheetObjects[currentTabIndex];
    } else {
        sheetObj = sheetObjects[3];
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
                InsertItem(" Trade ", "");
                InsertItem("  Sub Trade ", "");
                InsertItem("   Lane     ", "");
            }
            break;
    }
    tabObj.SetSelectedIndex(0);
}

/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    var beforetab = currentTabIndex;
    for (var i = 0; i < objs.length; i++) {
        if (i != nItem) {
            objs[i].style.display = "none";
            objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
        }
    }
    currentTabIndex = nItem;
    if (tabSearchParams[nItem] == "-1") {
        tabSearchParams[nItem] = "";
    } else {
        doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
    }
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
    //            disableAllButton();
    with(formObj) {
            for (var i = 0; i < 3; i++) {
                var fromDate = document.form.pfmc_fr_year[i].value + document.form.pfmc_fr_month[i].value;
                var toDate = document.form.pfmc_to_year[i].value + document.form.pfmc_to_month[i].value;
                if (Number(fromDate) > Number(toDate)) {
                    ComShowCodeMessage("COM12133", "To date", "from date", "greater");
                    return false;
                }
            }

            if (comObjects[0].GetSelectCode() == '') {
                ComShowCodeMessage("COM12113", "Target Group");
                controlButtons(searchSaqStsCd, formObj);
                return false;
            }
            if (getParam(saveParams, "trade") == null) {
                ComShowCodeMessage("COM12113", "Trade");
                controlButtons(searchSaqStsCd, formObj);
                return false;
            }
            if (getParam(saveParams, "bound") == null) {
                ComShowCodeMessage("COM12113", "Bound");
                controlButtons(searchSaqStsCd, formObj);
                return false;
            }
            if (getParam(saveParams, "mQtaVerNo") == null) {
                ComShowCodeMessage("COM12113", "Version");
                controlButtons(searchSaqStsCd, formObj);
                return false;
            }
            switch (eval(formObj.f_cmd.value)) {
                case MODIFY02:
                    var flg = validateSave(sheetObj);
                    controlButtons(searchSaqStsCd, formObj);
                    return flg;
                    //                	case MODIFY04 :
                    //                			// MODIFY04 : Checking Load ==0 in case of Confirm Draft
                    //                			var flg=validateConfirmCheck(sheetObj, formObj);
                    //                			controlButtons(searchSaqStsCd, formObj);
                    //               				return flg;
                case SEARCHLIST:
                    if (ComIsNull(trade)) {
                        ComShowCodeMessage("COM12113", "Trade");
                        return false;
                    }
                    if (ComIsNull(bound)) {
                        ComShowCodeMessage("COM12113", "Bound");
                        return false;
                    }
                    if (ComIsNull(version)) {
                        ComShowCodeMessage("COM12113", "Version");
                        return false;
                    }
            } // end switch
        }
        //            controlButtons(searchSaqStsCd, formObj);
    return true;
}

// validation before save
function validateSave(sheetObj) {
    var msgLane = "";
    var msgError = new Array("", "", "");
    var showMsgError = new Array();
    var idx = 0;
    var selRow = 0;
    var protFlag = "";
    with(sheetObj) {
            protFlag = sheetObj.GetEtcData("inclPortFlag");
            while ((selRow = FindText("item_seq", LOAD, selRow)) > -1) {
                if (GetCellValue(selRow, "edit_flag") != "1" || GetCellValue(selRow, "rgn_grp") == "1") {
                    selRow++;
                    continue;
                }
                msgLane = GetCellValue(selRow, "lane_sprt_grp") + "/";
                if (protFlag == "Y") {
                    msgLane = msgLane + GetCellValue(selRow, "pol_cd") + "/" + GetCellValue(selRow, "pod_cd") + "/";
                }
                msgLane = msgLane + GetCellValue(selRow, "ctrt_rgn_ofc_cd");
                // Load (-) check
                if (GetCellValue(selRow, "lod_qty") < 0) {
                    msgError[0] = msgError[0] + "- " + msgLane + " \n";
                }
                // GRPB (-) check
                if (GetCellValue(selRow, "grs_rpb_rev") < 0) {
                    msgError[1] = msgError[1] + "- " + msgLane + " \n";
                }
                // G.REV/G.RPB (0) check
                if (GetCellValue(selRow, "lod_qty") > 0 && GetCellValue(selRow, "grs_rpb_rev") == 0) {
                    msgError[2] = msgError[2] + "- " + msgLane + " \n";
                }
                selRow++;
            } // end while
            if (msgError[0] != "") {
                showMsgError[idx] = getMsg("SAQ90147", "Volume", msgError[0]);
                idx++;
            }
            if (msgError[1] != "") {
                showMsgError[idx] = getMsg("SAQ90147", "G.REV/G.RPB", msgError[1]);
                idx++;
            }
            if (msgError[2] != "") {
                showMsgError[idx] = getMsg("SAQ90146", msgError[2]);
            }
            if (showMsgError[0] != undefined) {
                showMsgWindow(showMsgError, "0");
                return false;
            }
            return true;
        } // end with
}

// MODIFY04 : Checking Load ==0 in case of Confirm Draft
function validateConfirmCheck(sheetObj, formObj) {
    //    		var params = "f_cmd="+ MODIFY08
    //    		            + saqFormString(formObj).substring(8);
    //    		params = params.replace("mQtaStepCd="+MQTA_STEP_CD, "mQtaStepCd="+WORK_STEP_CD);
    saveParams = replaceParams(saveParams, "mQtaStepCd", WORK_STEP_CD);
    saveParams = replaceParams(saveParams, "f_cmd", MODIFY08);
    //    	    sheetObj.DoSave("ESM_SAQ_0075GS.do", saveParams, "ibflag", false);

    var sParam = sheetObj.GetSaveString(0, 1, "ibflag");
    var sXml = sheetObj.GetSaveData("ESM_SAQ_0075GS.do", sParam + "&" + saveParams);
    sheetObj.LoadSaveData(sXml);

    var msgList = sheetObj.GetEtcData("zeroList");
    if (msgList != "") {
        msgArr = new Array();
        var tmpArr = "";
        var idx = 0;
        if (msgList.constructor == String) {
            msgArr = getStringToArray(msgList, 1024);
        } else {
            idx = 0;
            for (var msgIdx = 0; msgIdx < msgList.length; msgIdx++) {
                tmpArr = getStringToArray(msgList[msgIdx], 1024);
                for (var i = 0; i < tmpArr.length; i++) {
                    msgArr[idx] = tmpArr[i];
                    idx++;
                }
                msgArr[idx] = "\r\n\r\n";
                idx++;
            }
        }
        msgArr = getMsg("SAQ90149", msgArr);
        ComOpenPopupScroll("ESM_SAQ_MSG.do?windowType=" + 1 + "&fontColor=" + "black" + "&fontWeight=&btnFlg=" + true, "500", "340", "validateConfirmCheckPopUp", "1,0", true);


        //    			var msg=getMsg("SAQ90149", msgList);
        //    			return showMsgWindow(msg, "1");
    } else {
        //    			return true;
        formObj.f_cmd.value = MODIFY04;
        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    }
}

function validateConfirmCheckPopUp(rtnVal) {
    var sheetObj = sheetObjects[3];
    var formObj = document.form;
    if (rtnVal == true) {
        formObj.f_cmd.value = MODIFY04;
        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    } else {
        controlButtons(searchSaqStsCd, formObj);
        return false;
    }
}

function disableAllButton() {
    var formObj = document.form;
    ComBtnDisable("btng_monthly_adj");
    ComBtnDisable("btn_saveasnew");
    ComBtnDisable("btng_apply");
    ComBtnDisable("btng_officeadd");
    ComBtnDisable("btn_save");
    ComBtnDisable("btn_save1");
    ComBtnDisable("btn_cancelcurrent");
    ComBtnDisable("btn_confirmdraft");
    ComBtnDisable("btn_cancelconfirmation");
    ComBtnDisable("btn_notifydraft");
    ComBtnDisable("btn_cancelnotification");
    ComBtnDisable("btng_excelimportexport");
}

/**
 * contral button
 **/
function controlButtons(stsCd, formObj) {
    ComBtnDisable("btng_monthly_adj");
    ComBtnDisable("btn_saveasnew");
    ComBtnDisable("btng_apply");
    ComBtnDisable("btng_officeadd");
    ComBtnDisable("btn_cancelcurrent");
    ComBtnDisable("btng_excelimportexport");
    var sheetObj = sheetObjects[3];
    switch (stsCd) {
        case "00": // Init
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_save1");
            ComBtnEnable("btng_officeadd");
            ComBtnEnable("btn_saveasnew");
            ComBtnEnable("btn_cancelcurrent");
            ComBtnEnable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            ComBtnEnable("btng_apply");
            ComBtnEnable("btng_excelimportexport");
            if (sheetObj.GetEtcData("inclPortFlag") == "N") {
                if (formObj.target_month.selectedIndex == 0) {
                    // activation in case of rep_mon == bse_mon
                    ComBtnEnable("btng_monthly_adj");
                }
            }
            break;
        case "FC": // Final Confirm
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btng_officeadd");
            ComBtnDisable("btn_confirmdraft");
            ComBtnEnable("btn_cancelconfirmation");
            ComBtnEnable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            break;
        case "FN": // Final Notify
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btng_officeadd");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnEnable("btn_cancelnotification");
            break;
        default: // Init && "XX" Cancel Current Version()
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btng_officeadd");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            break;
    }
}

// import command
function getCommandByStep(srcName) {
    switch (srcName) {
        case "btn_saveasnew":
            return MODIFY01;
        case "btn_save": // save
        case "btn_save1": // save
            return MODIFY02;
        case "btn_cancelcurrent":
            return MODIFY03;
        case "btn_confirmdraft":
            return MODIFY04;
        case "btn_cancelconfirmation":
            return MODIFY05;
        case "btn_notifydraft":
            return MODIFY06;
        case "btn_cancelnotification":
            return MODIFY07;
        default:
            return "";
    } // end switch
}

function getSelectColumnName() {
    return "rhq";
}

function year_OnChange(obj) {
    changeVersion();
    changePfmcFromTo();
}

function bse_quarter_onChange(obj) {
    changeVersion();
    changePfmcFromTo();
}

function trade_group_OnChange(comObj, value, text) {
    changeTrade();
}

function trade_OnChange(comObj, value, text) {
    changeVersion();
    //subTrade_change();
}

function bound_OnChange(comObj, value, text) {
    changeVersion();
}

/*
 */
function changePfmcFromTo() {
    var formObj = document.form;
    var rep_year = formObj.year.value;
    var mon = getQuarterToMonth(document.form.bse_quarter.value);
    var rep_month = mon - 1;
    var repDate = new Date(rep_year, rep_month, 1);
    var fromDate = new Date(repDate - ((4 * 30) * (24 * 60 * 60 * 1000))); // before 4 month.
    var toDate = new Date(repDate - ((3 * 30) * (24 * 60 * 60 * 1000))); //  before 3 month.
    for (var i = 0; i < 3; i++) {
        formObj.pfmc_fr_year[i].value = fromDate.getFullYear();
        formObj.pfmc_fr_month[i].value = monthNumbers[fromDate.getMonth() + 1];
        formObj.pfmc_to_year[i].value = toDate.getFullYear();
        formObj.pfmc_to_month[i].value = monthNumbers[toDate.getMonth() + 1];
        if (formObj.pfmc_fr_year[i].value == "" || formObj.pfmc_to_year[i].value == "") {
            formObj.pfmc_fr_year[i].value = fromDate.getFullYear() + 1;
            formObj.pfmc_to_year[i].value = toDate.getFullYear() + 1;
        }
    }
}

/**
 * retrieve in case of sub trade chaning
 */
function subTrade_onChange() {
    doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
}

/**
 * retrieve in case of target_month chaning
 */
function target_month_onChange() {
    sub_trd_cd_change(document.form.inclPortFlag.value);
    rlane_cd_change();
}

function sub_trd_cd_init() {
    var formObj = document.form;
    var objSub_trd = formObj.search_sub_trd_cd;
    var objRlane = formObj.search_rlane_cd;
    var sub_opts = objSub_trd.options;
    for (i = (sub_opts == null ? 0 : sub_opts.length); i >= 0; i--) {
        objSub_trd.remove(i);
    }
    var lane_opts = objRlane.options;
    for (i = (lane_opts == null ? 0 : lane_opts.length); i >= 0; i--) {
        objRlane.remove(i);
    }
}

function sub_trd_cd_change(portFlag) {
    var formObj = document.form;
    //    		if (portFlag == "N") return;
    var objSub_trd = formObj.search_sub_trd_cd;
    var selLane = objSub_trd.value;
    var bse_mon = formObj.target_month.value.substring(4);
    var params = "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&bse_mon=" + bse_mon;
    getSelectCodeList(objSub_trd, "SaqMonQtaRhqSubtrd", params, true);
    if (objSub_trd.options.length == 0) {
        objSub_trd.options[0] = new Option("ALL", "");
    } else {
        objSub_trd.value = selLane;
        if (objSub_trd.value == "") {
            objSub_trd.selectedIndex = 0;
        }
    }
}

// rhqAdjSheet rlane_cd setting
function rlane_cd_change() {
    var formObj = document.form;
    var objRlane = formObj.search_rlane_cd;
    var selLane = objRlane.value;
    var bse_mon = formObj.target_month.value.substring(4);
    var sub_trd = formObj.search_sub_trd_cd.value;
    if (sub_trd == "") {
        var opts = objRlane.options;
        for (i = (opts == null ? 0 : opts.length); i >= 0; i--) {
            objRlane.remove(i);
        }
        objRlane.options[0] = new Option("ALL", "");
    } else {
        var params = "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&bse_mon=" + bse_mon + "&sub_trd_cd=" + sub_trd;
        getSelectCodeList(objRlane, "SaqMonQtaRhqLane", params, true);
        if (objRlane.options.length == 0) {
            objRlane.options[0] = new Option("ALL", "");
        } else {
            //checking whether lane exists or not
            var selChk = false;
            for (i = 0; i < objRlane.length; i++) {
                if (objRlane.options[i].value == selLane) {
                    selChk = true;
                    break;
                }
            }
            // is existed
            if (selChk == true && selLane != "") {
                // setting lane
                objRlane.value = selLane;
            } else {
                objRlane.selectedIndex = 0;
            }
        }
    }
}

// version setting
function changeVersion() {
    var obj = document.form;
    if (obj.trade.value == '' || obj.bound.value == '') return;
    var params = "searchFlag=ALL" + "&mQtaStepCd=" + MQTA_STEP_CD + "&year=" + obj.year.value + "&bse_qtr_cd=" + obj.bse_quarter.value + "&trade=" + obj.trade.value + "&dirCd=" + obj.bound.value + "&ofcCd=" + obj.ofcCd.value;
    getSelectCodeList(document.form.version, "SaqMonthlyQuotaStepVersion", params);
}

function changeTrade() {
    var params = "targetGrp=" + comObjects[0].GetSelectCode();
    getSelectCodeList(document.form.trade, "SaqTagetGroupTrade", params);
    changeVersion();
    //subTrade_change();
}

function callbackPopupContractOffice(rowArray) {
    var colArray = rowArray[0];
    document.all.contractOffice.value = colArray[3];
}

/*
 */
function subTrade_change() {
    var params = "targetGrp=" + comObjects[0].GetSelectCode() + "&trade=" + getParam(saveParams, "trade") + "&dirCd=" + getParam(saveParams, "bound");
    getSelectCodeList(document.form.subTrade, "SaqTagetGroupSubTrade", params);
}

/*
 * edit_mode change
 */
function changeEditMode() {
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    var editModeObj = formObj.edit_mode;
    var obj1 = document.getElementById("calc1_div");
    var obj2 = document.getElementById("calc2_div");
    var colName = getSelectColumnName();
    try {
        sheetObj.ReDraw = false;
        if (searchSaqStsCd == "00") {
            if (editModeObj[0].checked) { // "load"
                var calc1 = formObj.calc1;
                obj1.style.display = "";
                obj2.style.display = "none";
                if (calc1.checked) { //Load
                    changeEditCols(sheetObj, LOAD, colName);
                }
            } else if (editModeObj[1].checked) { //G.REV
                changeEditCols(sheetObj, GREV, colName);
                obj1.style.display = "none";
                obj2.style.display = "";
            } else if (editModeObj[2].checked) { //G.RPB
                changeEditCols(sheetObj, GRPB, colName);
                obj1.style.display = "none";
                obj2.style.display = "";
            }
        } else {
            editableCols(sheetObj, LOAD, colName, false);
            editableCols(sheetObj, GREV, colName, false);
            editableCols(sheetObj, GRPB, colName, false);
        }
    } finally {
        sheetObj.ReDraw = true;
    }
}

function changeEditCols(sheetObj, itemCd, colName) {
    editableCols(sheetObj, LOAD, colName, false);
    editableCols(sheetObj, GREV, colName, false);
    editableCols(sheetObj, GRPB, colName, false);
    editableCols(sheetObj, itemCd, colName, true);
}

/**
 * edit column change acoording to [ edit mode radio]
 */
function editableCols(sheetObj, itemCd, colName, flg) {
    var selRow = 0;
    var isEdit = false; // true : enable, false : disabled
    var first_rane_grp = "";
    if (flg == undefined) {
        flg = true;
    }
    while ((selRow = sheetObj.FindText('item_seq', itemCd.toString(), selRow)) >= 0) {
        if (sheetObj.GetCellValue(selRow, "rgn_grp") == "0" && flg == false && sheetObj.GetCellEditable(selRow, colName) == false) {
            if (selRow < 14) {
                return;
            }
            selRow++;
            continue;
        }
        if (sheetObj.GetCellValue(selRow, "rgn_grp") == "1") { // case total : skip.
            selRow++;
            continue;
        }
        // editable in case of edit_flag == 1
        if (sheetObj.GetCellValue(selRow, 'edit_flag') == "1") {
            changeSheetBackColor(sheetObj, selRow, colName, flg)
            sheetObj.SetCellEditable(selRow, colName, flg);
        }
        selRow++;
    }
}

function changeSheetBackColor(sheetObj, row, col, flg) {
    if (flg == true) {
        sheetObj.SetCellBackColor(row, col, "#FFFFFF");
    } else {
        sheetObj.SetCellBackColor(row, col, sheetObj.GetCellBackColor(row, "item"));
    }
}

function getTabLocalParams() {
    var formObj = document.form;
    var trade_group = comObjects[0].GetSelectCode(); //document.getElementById("trade_group").GetSelectCode();
    return "&glineVerNo=" + formObj.glineVerNo.value + "&mqtaMdlVerNo=" + formObj.mqtaMdlVerNo.value + "&slsFcastPubNo=" + formObj.slsFcastPubNo.value + "&mQtaVerNo=" + getParam(saveParams, "mQtaVerNo") + "&trade_group=" + trade_group + "&year=" + getParam(saveParams, "year") + "&bse_quarter=" + getParam(saveParams, "bse_quarter") + "&trade=" + getParam(saveParams, "trade") + "&bound=" + getParam(saveParams, "bound") + "&ctrt_rhq_cd=" + formObj.ofcCd.value + "&pfmc_fr_year=" + formObj.pfmc_fr_year[currentTabIndex].value + "&pfmc_fr_month=" + formObj.pfmc_fr_month[currentTabIndex].value + "&pfmc_to_year=" + formObj.pfmc_to_year[currentTabIndex].value + "&pfmc_to_month=" + formObj.pfmc_to_month[currentTabIndex].value + "&unit=" + getParam(saveParams, "unit");
}

//    	/*
//    	 * rhqLaneSheet Tree Double Click Event
//    	 */
//    	function rhqLaneSheet_OnDblClick(sheetObj, Row, Col) {
//    		with(sheetObj) {
//    			//Text Validation Check
//    			var text=GetCellValue(Row,Col);
//    			if (text != 'TOTAL') return;
//    			var end_row=Row;
//    			var end_text="";
//    			do {
//    				end_row++;
//    				end_text=GetCellText(end_row,Col);
//    			} while (text == end_text );
//    			end_row=end_row-1;
//    			//log("find end-row=" + end_row);
//    			if(!(GetRowHidden(end_row))){
//    				SetRowExpanded(end_row,!(GetRowExpanded(end_row)));
//    			}
//    		} // end with
//    	}

//function callbackRemark() {
//    if (window.isRemarkRefresh == true) {
//        doActionIBSheet(sheetObjects[4], document.form, IBSEARCH_ASYNC05);
//        processRemarkHighlight(getParseSaveParam(window.remarkRefreshParam, "rlane_grp"), getParseSaveParam(window.remarkRefreshParam, "pol_cd"), getParseSaveParam(window.remarkRefreshParam, "pod_cd"), getParseSaveParam(window.remarkRefreshParam, "ctrt_rgn_ofc_cd"));
//    }
//}

function callbackRemark(rtnVal) {		
	var rtnValue = rtnVal; 
	
    if (rtnValue[0] == "OK") {        
        doActionIBSheet(sheetObjects[4], document.form, IBSEARCH_ASYNC05);
        processRemarkHighlight(rtnValue[1], rtnValue[3], rtnValue[4], rtnValue[5]); //rlane_grp, pol_cd, pod_cd, ctrt_rgn_ofc_cd     
    }
}

function rmkSheet_OnSearchEnd(sheetObj, errMsg) {
    if (sheetObj.GetEtcData("status") != "OK" && sheetObj.GetEtcData("status") != undefined) {
        ComShowMessage(errMsg);
    } else {
        processAllRemarkHighlight();
    }
}

function processAllRemarkHighlight() {
    var sheetObj = sheetObjects[4]; //remark sheet
    var lastRow = sheetObj.LastRow();
    var rlane_grp = "";
    var pol_cd = "";
    var pod_cd = "";
    var ctrt_rgn_ofc_cd = "";
    var selRow = 0;
    for (var row = sheetObj.HeaderRows(); row <= lastRow; row++) {
        selRow = 0;
        rlane_grp = sheetObj.GetCellValue(row, "rlane_grp");
        pol_cd = sheetObj.GetCellValue(row, "pol_cd");
        pod_cd = sheetObj.GetCellValue(row, "pod_cd");
        ctrt_rgn_ofc_cd = sheetObj.GetCellValue(row, "ctrt_rgn_ofc_cd");
        processRemarkHighlight(rlane_grp, pol_cd, pod_cd, ctrt_rgn_ofc_cd);
    }
}

function processRemarkHighlight(rlane_grp, pol_cd, pod_cd, ctrt_rgn_ofc_cd) {
    var adjSheetObj = sheetObjects[3];
    var selRow = 0;
    var cols = new Array('lane_grp', 'pol_cd', 'pod_cd', 'ctrt_rgn_ofc_cd');
    var oriValues = new Array(rlane_grp, pol_cd, pod_cd, ctrt_rgn_ofc_cd);
    var valueCols = new Array('col_row_index', 'item_nm');
    var values = processFindValue(adjSheetObj, cols, oriValues, valueCols);
    if (values.length != 0) {
        adjSheetObj.SetCellFontColor(values[0], "remarks", "#FF0000"); // 색깔바꾸기
    }
}

/**
 * the value that satisfy the condition of a particular column
 */
function processFindValue(sheetObj, cols, oriValues, valueCol, startCol) {
    // //log("processFilterSheet : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+", valueCol="+valueCol+", startCol="+startCol);
    var valueCols = new Array();
    if (valueCol.constructor == String) {
        valueCols[0] = valueCol;
    } else {
        valueCols = valueCol;
    }
    if (startCol == undefined)
        startCol = 0;
    var value = new Array();
    var selRow = startCol;
    var flg;
    for (var i = 0; i <= sheetObj.LastRow(); i++) {
        flg = false;
        for (var j = 0; j < cols.length; j++) {
            selRow = sheetObj.FindText(cols[j], oriValues[j], selRow);
            if (selRow < 0) { //not matched
                break;
            }
        }
        if (selRow >= 0) {
            i = selRow;
            selRow++;
            for (var j = 0; j < cols.length; j++) {
                if (oriValues[j] != sheetObj.GetCellValue(i, cols[(j)])) {
                    flg = true;
                    break;
                }
            }
            if (flg == false) {
                for (var idx = 0; idx < valueCols.length; idx++) {
                    if (valueCols[idx] == "col_row_index") {
                        value[idx] = i;
                    } else {
                        value[idx] = sheetObj.GetCellValue(i, valueCols[idx]);
                    }
                }
                break;
            }
        } else {
            break;
        }
    }
    return value;
}

function getParseSaveParam(params, str) {
    var value = "";
    var tmp;
    var arr = params.split("&");
    for (var i = 0; i < arr.length; i++) {
        tmp = arr[i].split("=");
        if (tmp[0] == str) {
            value = tmp[1];
            break;
        }
    }
    return value;
}

/**
 */
function rhqAdjSheet_OnSearchEnd(sheetObj, errMsg) {
    var formObj = document.form;
    ComOpenWait(false);
    rhqAdjSheet_SearchEnd(sheetObj, formObj);
    //retrieving remark
    doActionIBSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC05);
}

// Save, Save As New Version
function rhqAdjSheet_OnSaveEnd(sheetObj, errMsg) {
    var formObj = document.form;
    ComOpenWait(false);
    //log("rhqAdjSheet_OnSaveEnd..................");
    if (sheetObj.GetEtcData("version") != "null" && sheetObj.GetEtcData("version") != undefined) {
        // retrieve version after saving
        // setting new version
        changeVersion();
        formObj.version.value = sheetObj.GetEtcData("version") + ":" + formObj.glineVerNo.value;
        document.form.mQtaVerNo.value = sheetObj.GetEtcData("version");
        rhqAdjSheet_SearchEnd(sheetObj, formObj);
        saveParams = replaceParams(saveParams, "version", formObj.version.value);
        saveParams = replaceParams(saveParams, "mQtaVerNo", formObj.mQtaVerNo.value);
    }
    if (formObj.f_cmd.value == MODIFY02) {
        // retrieving Tab information
        tabSearchParams = ["", "", "", ""];
        doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
    }
    //    		else if (sheetObj.EtcData("command") == MODIFY04  ) {
    //    			alert("rhqAdjSheet_OnSaveEnd : MODIFY04");
    //    		    if( sheetObj.EtcData("status")  == "ERROR" &&  sheetObj.EtcData("errorCd") == "SAQ00099"   ){
    //    		        showMsgWindow(sheetObj.EtcData("errorMsg"));
    //    		    }
    //    		}
    if (sheetObj.GetEtcData("validationMsg") != "" && sheetObj.GetEtcData("status") == "MSG") {
        showMsgWindow(sheetObj.GetEtcData("validationMsg"));
    }
    if (formObj.target_month.selectedIndex == 0) {
        // activating in case of  rep_mon == bse_mon
        ComBtnEnable("btng_monthly_adj");
    }
    controlButtons(searchSaqStsCd, formObj);
}

function rhqAdjSheet_SearchEnd(sheetObj, formObj) {
    // setting for save
    isSheetEdited = false;
    searchSaqStsCd = sheetObj.GetEtcData("saqStsCd");
    formObj.mqtaMdlVerNo.value = sheetObj.GetEtcData("mqtaMdlVerNo");
    formObj.slsFcastPubNo.value = sheetObj.GetEtcData("slsFcastPubNo");
    formObj.inclPortFlag.value = sheetObj.GetEtcData("inclPortFlag");

    // inclPortFlag ==> POL/POD  display
    if (sheetObj.GetEtcData("inclPortFlag") == "Y") {
        sheetObj.SetColHidden("pol_cd", 0);
        sheetObj.SetColHidden("pod_cd", 0);
        ComBtnDisable("btng_monthly_adj");
    } else {
        sheetObj.SetColHidden("pol_cd", 1);
        sheetObj.SetColHidden("pod_cd", 1);
    }
    changeEditMode();
    reloadFilter();

    initCheckListDragPopupCompound(new Array(getConvertForPopup(sheetObj.GetEtcData("LANE_TOTAL")), getConvertForPopup(sheetObj.GetEtcData("RGN_OFC_TOTAL"))), "CALCULATION", new Array("LANE_CAL", "RGN_CAL"), new Array(new Array("Sub Trade", "Lane", "Select"), new Array("Regional Office", "Select")), "55:45", new Array("35:32:33", "53:47"), new Array(true, true));
    // Tab information
    // go button click
    if (saveParams == "") {
        clearTabSearchParams();
        // Tab information
        saveParams = getLocalParams();
        doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
    } else {
        saveParams = replaceParams(saveParams, "mqtaMdlVerNo", formObj.mqtaMdlVerNo.value);
        saveParams = replaceParams(saveParams, "slsFcastPubNo", formObj.slsFcastPubNo.value);
        saveParams = replaceParams(saveParams, "inclPortFlag", formObj.inclPortFlag.value);
    }
    target_month_onChange();
    controlButtons(searchSaqStsCd, formObj);
}

function reloadFilter() {
    var data = getSingleData(sheetObjects[3], "sub_trd_cd", "ASC");
    initCheckListDragPopup(data, "SUB_TRADE", "SUB_TRADE_INPUT", "Sub Trade", "Select", "sheetName='rhqAdjSheet' colName='sub_trd_cd' ", true);
    data = getDoubleData(sheetObjects[3], "sub_trd_cd", "lane_grp");
    initCheckListDragPopup2(data, "LANE", "LANE_INPUT", "Sub Trade", "Lane", "Select", "sheetName='rhqAdjSheet' colName='lane_grp' ", true);
    data = getSingleData(sheetObjects[3], "ctrt_aq_cd", "ASC");
    initCheckListDragPopup(data, "AQ", "AQ_INPUT", "Area Director", "Select", "sheetName='rhqAdjSheet' colName='ctrt_aq_cd' ", true);
    data = getDoubleData(sheetObjects[3], "ctrt_aq_cd", "ctrt_rgn_ofc_cd");
    initCheckListDragPopup2(data, "RGN_OFC", "RGN_INPUT", "Area Director", "Regional Office", "Select", "sheetName='rhqAdjSheet' colName='ctrt_rgn_ofc_cd' ", true);
    data = getSingleData(sheetObjects[3], "item", "ASC");
    initCheckListDragPopup(data, "ITEM", "ITEM_INPUT", "Item", "Select", "sheetName='rhqAdjSheet' colName='item' ", true);

    //            initCheckListDragPopupSheet(sheetObj.GetEtcData("SUB_TRADE"),"SUB_TRADE","SUB_TRADE_INPUT",new Array("Sub Trade","Select"),                      "100:30" ,     "sheetName='rhqAdjSheet' colName='sub_trd_cd' ", true, logObj);
    //            initCheckListDragPopupSheet(sheetObj.GetEtcData("LANE"),     "LANE",     "LANE_INPUT",     new Array("Sub Trade","Lane","Select"),               "100:100:30",  "sheetName='rhqAdjSheet' colName='lane_grp' ", true, logObj);
    //            initCheckListDragPopupSheet(sheetObj.GetEtcData("AQ"),       "AQ",       "AQ_INPUT",       new Array("Area Director","Select"),                  "100:30" ,     "sheetName='rhqAdjSheet' colName='ctrt_aq_cd' ", true, logObj);
    //            initCheckListDragPopupSheet(sheetObj.GetEtcData("RGN_OFC"),  "RGN_OFC",  "RGN_INPUT",      new Array("Area Director","Regional Office","Select"),"100:100:30" , "sheetName='rhqAdjSheet' colName='ctrt_rgn_ofc_cd' ", true, logObj);
    //            initCheckListDragPopupSheet(sheetObj.GetEtcData("POL_CD"),   "POL_CD",   "POL_INPUT",      new Array("POL","Select"),                            "100:30" ,     "sheetName='rhqAdjSheet' colName='pol_cd' ", true, logObj);
    //            initCheckListDragPopupSheet(sheetObj.GetEtcData("POD_CD"),   "POD_CD",   "POD_INPUT",      new Array("POD","Select"),                            "100:30" ,     "sheetName='rhqAdjSheet' colName='pod_cd' ", true, logObj);
    //            initCheckListDragPopupSheet(sheetObj.GetEtcData("ITEM"),     "ITEM",     "ITEM_INPUT",     new Array("Item","Select"),                           "100:30" ,     "sheetName='rhqAdjSheet' colName='item' ", true, logObj);
    //      		initCalcCheckListDragPopupSheet( new Array( sheetObj.GetEtcData("LANE_TOTAL"), sheetObj.GetEtcData("RGN_OFC_TOTAL")),"CALCULATION",new Array("LANE_CAL","RGN_CAL"),new Array(new Array("Sub Trade","Lane","Select"),new Array("Regional Office","Select")),"56:44"  ,new Array("75:75:30","100:20") ,new Array("true","true"));
}

/**
 * 필터데이터를 추출한다(싱글)
 * @param sheetObj
 * @param colName
 * @param order
 * @returns {String}
 */
function getSingleData(sheetObj, colName, order) {
    var dataObj = processSortValue(sheetObj, colName, order);
    var data = "";
    var arrData = dataObj.arrData;
    for (var i = 0; i < arrData.length; i++) {
        data += arrData[i] + "|";
    }
    if (dataObj.hasNullData == true) {
        data = "|" + data;
    }
    return data;
}

/**
 * 필터데이터를 추출한다.(더블)
 * 
 * @param sheetObj
 * @param firstColName
 * @param secondColName
 * @returns {String}
 */
function getDoubleData(sheetObj, firstColName, secondColName) {
    var data = "";
    var sName = "";
    var rName = "";
    var rtnValue = "";
    var arrAq = "";
    var arrOfc = "";

    for (i = 2; i < sheetObj.LastRow(); i++) {
        sName = sheetObj.GetCellValue(i, firstColName);
        rName = sheetObj.GetCellValue(i, secondColName);

        if (arrAq.indexOf(sName) < 0) {
            if (arrAq != "") rtnValue = rtnValue + "&";
            rtnValue = rtnValue + sName + ";";
            arrAq = arrAq + sName;
        }
        if (arrOfc.indexOf(rName) < 0) {
            rtnValue = rtnValue + rName + "|";
            arrOfc = arrOfc + rName;
        }
    }

    data = rtnValue;
    return data;
}

function processSortValue(sheetObj, colName, order) {
    var end = sheetObj.LastRow();
    var vl = "";
    var data = "|";
    var len = 0;
    var returnData = new Object();
    returnData.arrData = new Array();
    returnData.hasNullData = false;
    for (var i = sheetObj.HeaderRows(); i <= end; i++) {
        vl = sheetObj.GetCellValue(i, colName);
        if (processPreCheck(sheetObj, i, colName) == true && data.indexOf("|" + vl + "|") < 0 && vl != "") {
            data += vl + "|";
        } else if (vl == "") {
            returnData.hasNullData = true;
        }
    }
    if (data.length > 1) {
        data = data.substring(1, data.length - 1);
        var arrData = data.split("|");
        returnData.arrData = arrData; //processSortData(arrData,0,arrData.length-1);
    }
    return returnData;
}

function processPreCheck(sheetObj, row, colName) {
    if (sheetObj == sheetObjects[0]) {
        return true;
    } else if (sheetObj == sheetObjects[3]) {
        if (sheetObj.GetRowStatus(row) == "D") {
            return false;
        } else {
            return true;
        }
    }
}

// ---------------------------------------------------------------------------------

function getLocalParams() {
    var obj = document.form;
    var params = saqFormString(obj);
    return params;
}

function getParam(params, paramName) {
    var idx1 = params.indexOf(paramName + "=");
    if (idx1 < 0) {
        return "";
    }
    var idx2 = params.indexOf("&", idx1);
    if (idx2 < 0) {
        idx2 = params.length;
    }
    var v = paramName.length + 1;
    var value = params.substring(idx1 + v, idx2);
    return value;
}

function replaceParams(params, paramName, paramValue) {
    var idx1 = params.indexOf(paramName + "=");
    if (idx1 < 0) {
        params += "&" + paramName + "=" + paramValue;
        return params;
    }
    var idx2 = params.indexOf("&", idx1);
    if (idx2 < 0) {
        idx2 = params.length;
    }
    var v = paramName.length + 1;
    var startStr = params.substring(0, idx1 + v);
    var endStr = params.substring(idx2, params.length);
    var value = startStr + paramValue + endStr;
    return value;
}

function getTrd_cd() {
    var idx = saveParams.indexOf("&trade=")
    var trd_cd = saveParams.substring(idx + 7, idx + 10);
    return trd_cd;
}

/**
 * open popup(ESM_SAQ_042)
 */
function rhqAdjSheet_OnMouseDown(sheetObj, button, shift, x, y) {
        with(sheetObj) {
                var row = MouseRow();
                var col = MouseCol();
                var popupWidth = 200;
                var popupHeight = 200;

                dynamicPopupClose();

                if (row < HeaderRows() && row > -1) {
                    var colName = ColSaveName(col);
                    var html = null;
                    var objName = "";
                    if (colName == "sub_trd_cd") {
                        objName = "SUB_TRADE";
                    } else if (colName == "lane_grp") {
                        objName = "LANE";
                        popupWidth = 300;
                    } else if (colName == "ctrt_aq_cd") {
                        objName = "AQ";
                    } else if (colName == "ctrt_rgn_ofc_cd") {
                        objName = "RGN_OFC";
                        popupWidth = 300;
                    } else if (colName == "pol_cd") {
                        objName = "POL_CD";
                    } else if (colName == "pod_cd") {
                        objName = "POD_CD";
                    } else if (colName == "item") {
                        objName = "ITEM";
                    }
                    var divObj = document.getElementById("DIV__" + objName + "__DIV");
                    var evtobj = window.event ? window.event : e
                    var tempX = event.clientX + document.body.scrollLeft;
                    var tempY = event.clientY + document.body.scrollTop;

                    openDynamicDragPopup(divObj, x, evtobj.offsetY + 950, popupWidth, popupHeight, sheetObj);
                    //                    openDynamicDragPopup(divObj,tempX,tempY,popupWidth,popupHeight,sheetObj);

                }
            } // end with
    }
    //    	function rhqAdjSheet_OnUserResize(sheetObj,lWidth,lHeight){
    //    	    dynamicPopupClose();
    //    	}
    //no support[check again]CLT 	function rhqAdjSheet_OnScroll(sheetObj,row,col){
    //    	    dynamicPopupClose();
    //    	}
    //    	function rhqAdjSheet_OnResize(sheetObj,row,col){
    //    	    dynamicPopupClose();
    //    	}

// change of cursor
function rhqAdjSheet_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    var col = sheetObj.MouseCol();
    var row = sheetObj.MouseRow();
    var cursor = "Default";
    var text = "";
    if (sheetObj.ColSaveName(col) == "remarks" && sheetObj.GetCellValue(row, col) > "") {
        cursor = "Hand";
        var cols = new Array('rlane_grp', 'pol_cd', 'pod_cd', 'ctrt_rgn_ofc_cd');
        var oriValues = new Array(sheetObj.GetCellValue(row, "lane_grp"), sheetObj.GetCellValue(row, "pol_cd"), sheetObj.GetCellValue(row, "pod_cd"), sheetObj.GetCellValue(row, "ctrt_rgn_ofc_cd"));
        var valueCols = new Array('subj_ctnt', 'cre_ofc_cd', 'rmk_cre_gdt');
        var values = processFindValue(sheetObjects[4], cols, oriValues, valueCols);
        if (values.length != 0) {
            text = values[2].substring(0, 16) + "\n" + values[1] + "\n--------------------------------------------\n" + values[0];
            // text = values;
        }
    } else if (sheetObj.ColSaveName(col) == "lane_grp") {
        cursor = "Hand";
    }
    //no support[check again]CLT 	    sheetObj.MouseToolTipText=text;
    sheetObj.SetMousePointer(cursor);
}

function rhqAdjSheet_OnDblClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "remarks" && sheetObj.GetCellValue(row, col) != "") {
        var params = "gline_ver_no=" + formObj.glineVerNo.value + "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd") + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, "sprt_grp_cd") + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, "bsa_grp_cd") + "&bse_mon=" + formObj.target_month.value.substring(4) + "&ctrt_rhq_cd=" + formObj.ofcCd.value + "&ctrt_rgn_ofc_cd=" + sheetObj.GetCellValue(row, "ctrt_rgn_ofc_cd") + "&pol_cd=" + sheetObj.GetCellValue(row, "pol_cd") + "&pod_cd=" + sheetObj.GetCellValue(row, "pod_cd") + "&cre_ofc_cd=" + formObj.ofcCd.value + "&saq_sts_cd=" + searchSaqStsCd;
        //log("remarks params=" + params);
        var width = 450;
        var height = 650;
        var callback = "callbackRemark";
        ComOpenPopupScroll("ESM_SAQ_0112.do?" + params, width, height, callback, "0,0", true);
    } else if (sheetObj.ColSaveName(col) == "lane_grp" && sheetObj.GetCellValue(row, "bsa_grp_cd") != "") {
        var params = "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&gline_ver_no=" + formObj.glineVerNo.value + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd") + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, "sprt_grp_cd") + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, "bsa_grp_cd") + "&bse_mon=" + formObj.target_month.value.substring(4);
        var width = 550;
        var height = 390;
        var callback = "callbackRemark";
        ComOpenPopupScroll("ESM_SAQ_0116.do?" + params, width, height, callback, "0,0", true);
    }
}

// Calculations
function rhqAdjSheet_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    if (colName == "rhq" || colName == "final") {
        var msg = processCalcLogic(sheetObj, row, col);
        if (msg != undefined && msg != "") {
            ComShowMessage(msg);
        }
    }
}

function setTotalData(sheetObj, row, col, loadTot, revTot, cmTot, raCmTot, raOpTot) {
    var bsa = 0;
    var cmbTot = 0;
    var raCmbTot = 0;
    var opbTot = 0;
    var raOpbTot = 0;
    var rpbTot = 0;
    //            ComShowMessage("setTotalData="+row+",loadTot="+loadTot+",revTot="+revTot+", cmTot="+cmTot+",raCmTot= "+raCmTot+",item="+sheetObj.CellValue(row,"item"))
    //            bsa = parseFloat(sheetObj.CellValue(row,hiddenSaveName));
    //            lfTot = getZeroToInfinity( loadTot/bsa ) * 100;
    rpbTot = getZeroToInfinity(revTot / loadTot);
    cmbTot = getZeroToInfinity(cmTot / loadTot);
    sheetObj.SetCellValue(row + 1, col, getZeroToNullString(loadTot), 0);
    sheetObj.SetCellValue(row + 2, col, getZeroToNullString(revTot), 0);
    sheetObj.SetCellValue(row + 3, col, getZeroToNullString(rpbTot), 0);
    sheetObj.SetCellValue(row + 4, col, getZeroToNullString(cmTot), 0);
    sheetObj.SetCellValue(row + 5, col, getZeroToNullString(cmbTot), 0);
}

function processCalcTotal(sheetObj, row, col, isAll) {
    var loadTot = 0;
    var cmTot = 0;
    var raCmTot = 0;
    var raOpTot = 0;
    var revTot = 0;
    if (!ComIsNumber(col)) {
        col = sheetObj.SaveNameCol(col);
    }
    if (isAll == undefined) {
        isAll = false;
    }
    var pre_lane_grp = sheetObj.GetCellValue(row, "lane_grp")
    var totalRow = sheetObj.FindText("lane_grp", pre_lane_grp, 0);
    var pre_lane_sprt_grp = sheetObj.GetCellValue(totalRow, "lane_sprt_grp");
    var lastRow = sheetObj.LastRow();
    row = totalRow;
    for (var i = 1; true; i++) {
        newRow = row + 6 * i + 1;
        var lane_grp = sheetObj.GetCellValue(newRow, "lane_grp")
        var lane_sprt_grp = sheetObj.GetCellValue(newRow, "lane_sprt_grp");
        if (pre_lane_grp != lane_grp) {
            setTotalData(sheetObj, totalRow, col, loadTot, revTot, cmTot, raCmTot, raOpTot);
            if (pre_lane_sprt_grp != lane_sprt_grp) {
                if (isAll) {
                    if (newRow > lastRow) {
                        break;
                    }
                    pre_lane_grp = lane_grp;
                    pre_lane_sprt_grp = lane_sprt_grp;
                    totalRow = newRow - 1;
                } else {
                    break;
                }
            } else {
                pre_lane_grp = lane_grp;
                pre_lane_sprt_grp = lane_sprt_grp;
                totalRow = newRow - 1;
            }
            loadTot = 0;
            revTot = 0;
            cmTot = 0;
        } else {
            loadTot += parseFloat(sheetObj.GetCellValue(newRow, "edt_step_val")); //load
            revTot += parseFloat(sheetObj.GetCellValue(newRow + 1, "edt_step_val")); //rev
            cmTot += parseFloat(sheetObj.GetCellValue(newRow + 3, "edt_step_val")); //cm
        }
    }
}

function processCalcLogic(sheetObj, row, col) {
    if (!ComIsNumber(col)) {
        col = sheetObj.SaveNameCol(col);
    }
    var appdMsg = ""; // return Message
    var baseCol = sheetObj.SaveNameCol("edt_step_val");
    var grs_rpb = 0;
    var APPLY_MODE = "percent";
    var apply_value = 0;
    try {
        sheetObj.RenderSheet(0);
        with(sheetObj) {
                apply_value = calcIncreaseRatio(GetCellValue(row, col), GetCellValue(row, baseCol));
                //log("processCalcLogic] apply_value=" + apply_value);
                switch (eval(GetCellValue(row, "item_seq"))) {
                    case LOAD:
                        setCalcBaseColumn(sheetObj, row, baseCol, GetCellValue(row, col));
                        calculationOneItemSet(sheetObj, row, col, baseCol);
                        apply_value = GetCellValue(row, baseCol) / GetCellValue(row, "tot_bsa");
                        processCalcRgnPolPodChange(LOAD, sheetObj, row + 1, col, baseCol, "percent", apply_value);
                        break;
                    case GREV:
                        grs_rpb = getZeroToInfinity(GetCellValue(row, col) / GetCellValue(row - 1, baseCol));
                        setCalcBaseColumn(sheetObj, row + 1, baseCol, grs_rpb);
                        calculationOneItemSet(sheetObj, row - 1, col, baseCol);
                        processCalcRgnPolPodChange(GRPB, sheetObj, row + 2, col, baseCol, "amount", grs_rpb);
                        break;
                    case GRPB:
                        setCalcBaseColumn(sheetObj, row, baseCol, GetCellValue(row, col));
                        calculationOneItemSet(sheetObj, row - 2, col, baseCol);
                        processCalcRgnPolPodChange(GRPB, sheetObj, row + 1, col, baseCol, "amount", GetCellValue(row, col));
                        break;
                } // end switch
            } // end with
    } catch (e) {
        ComShowMessage(e.message);
        appdMsg = appdMsg + "\n" + e;
    } finally {
        sheetObj.RenderSheet(1);
    }
    processCalcRoundOff2(sheetObj, row, col);
    return appdMsg;
}

/**
 * LOAD/GRPB input variable or ratio of change (all apply lane_sprt_grp )
 * Cell input or Apply button process.
 * APPLY_MODE = amount, percent, round
 * CALC_VALUE =  change variable  according to apply_mod
 */
function processCalcRgnPolPodChange(ITEM, sheetObj, row, col, baseCol, APPLY_MODE, CALC_VALUE) {
    isSheetEdited = true;
    var lane_sprt_grp = sheetObj.GetCellValue(row, "lane_sprt_grp");
    var rgn_pol_pod = sheetObj.GetCellValue(row, "rgn_pol_pod");
    var move_pos = 0;
    var selRow = row;
    var load_row = 0;
    var apply_value = 0;
    var cell_value = 0;
    var cur_trade_cd = getTrd_cd();
    var tmp_lod_val = 0;
    var tmp_rpb_val = 0;
    switch (ITEM) {
        case LOAD:
            move_pos = 0;
            break;
        case GRPB:
            move_pos = -2; // LOAD ROW=GRPB ROW - 2;
            break;
    } //end switch
    //log("processCalcRgnPolPodChange] move_pos=" + move_pos);
    with(sheetObj) {
            if (isNaN(CALC_VALUE) == false) {
                apply_value = eval(CALC_VALUE);
            }
            //log("processCalcRgnPolPodChange] apply_value=" + apply_value);
            while ((selRow = sheetObj.FindText("item_seq", ITEM.toString(), selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_sprt_grp") != lane_sprt_grp) {
                    break;
                }
                if (GetCellValue(selRow, "rgn_pol_pod") != rgn_pol_pod) {
                    selRow++;
                    continue;
                }
                //log("processCalcRgnPolPodChange] rgn_pol_pod=" + GetCellValue(selRow, "rgn_pol_pod"));
                if (ITEM == LOAD && APPLY_MODE == "amount") {
                    if (GetCellValue(selRow, 'edit_flag') == "1") {
                        cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                        apply_value = getZeroToInfinity(cell_value / GetCellValue(selRow, "tot_bsa"));
                        APPLY_MODE = "percent";
                        tmp_lod_val = cell_value;
                    }
                } else if (ITEM == LOAD && APPLY_MODE == "percent") {
                    if (cur_trade_cd == "IAS" || cur_trade_cd == "EMS") {
                        cell_value = GetCellValue(row - 1, col);
                    } else {
                        cell_value = GetCellValue(selRow, "tot_bsa") * apply_value;
                    }
                } else if (ITEM == GRPB) {
                    cell_value = apply_value;
                }
                setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                load_row = selRow + move_pos;
                calculationOneItemSet(sheetObj, load_row, col, baseCol);
                selRow++;
            } // end while
        } // end with
    processCalcTotal(sheetObj, row, col);
}

/**
 * LOAD/GRPB input variable or ratio of change (all apply lane_sprt_grp )
 * Cell input or Apply button process.
 * APPLY_MODE = amount, percent, round
 * CALC_VALUE =  change variable  according to apply_mod
 */
function processCalcGroupChange(ITEM, sheetObj, row, col, baseCol, APPLY_MODE, CALC_VALUE) {
    isSheetEdited = true;
    var lane_sprt_grp = sheetObj.GetCellValue(row, "lane_sprt_grp");
    var move_pos = 0;
    var selRow = row;
    var load_row = 0;
    var apply_value = 0;
    var cell_value = 0;
    var tmp_lod_val = new Array();
    var tmp_rpb_val = new Array();
    var cur_trade_cd = getTrd_cd();
    var apply_LF = new Array();
    var rev_f = 0;
    var grs_rev = 0;
    switch (ITEM) {
        case LOAD:
            move_pos = 0;
            break;
        case GREV:
            move_pos = -2; // LOAD ROW=GRPB ROW - 2;
            break;
        case GRPB:
            move_pos = -2; // LOAD ROW=GRPB ROW - 2;
            break;
    } //end switch
    //log("processCalcGroupChange] move_pos=" + move_pos);
    with(sheetObj) {
            if (isNaN(CALC_VALUE) == false) {
                apply_value = eval(CALC_VALUE);
            }
            //log("processCalcGroupChange] apply_value=" + apply_value);
            while ((selRow = sheetObj.FindText("item_seq", ITEM.toString(), selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_sprt_grp") != lane_sprt_grp) {
                    break;
                }
                if (GetCellValue(selRow, "rgn_grp") == "1") {
                    selRow++;
                    continue;
                }
                //log("processCalcGroupChange] lane_sprt_grp=" + GetCellValue(selRow, "lane_sprt_grp"));
                if (ITEM == LOAD && APPLY_MODE == "amount") {
                    if (GetCellValue(selRow, "edit_flag") == "1") {
                        cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                        apply_LF[GetCellValue(selRow, "rgn_pol_pod")] = new Array();
                        apply_LF[GetCellValue(selRow, "rgn_pol_pod")] = getZeroToInfinity(cell_value / GetCellValue(selRow, "tot_bsa"));
                        tmp_lod_val[GetCellValue(selRow, "rgn_pol_pod")] = cell_value;
                    } else {
                        if (cur_trade_cd == "IAS" || cur_trade_cd == "EMS") {
                            cell_value = tmp_lod_val[GetCellValue(selRow, "rgn_pol_pod")];
                        } else {
                            cell_value = GetCellValue(selRow, "tot_bsa") * apply_LF[GetCellValue(selRow, "rgn_pol_pod")];
                        }
                    }
                } else if (ITEM == GRPB) {
                    if (GetCellValue(selRow, "edit_flag") == "1") {
                        cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                        tmp_rpb_val[GetCellValue(selRow, "rgn_pol_pod")] = cell_value;
                    } else {
                        cell_value = tmp_rpb_val[GetCellValue(selRow, "rgn_pol_pod")];
                    }
                } else if (ITEM == GREV) {
                    grs_rev = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, CALC_VALUE);
                    rev_f = calcIncreaseRatio(grs_rev, GetCellValue(selRow, baseCol));
                    selRow++;
                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), "percent", rev_f);
                } else {
                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                }
                setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                load_row = selRow + move_pos;
                calculationOneItemSet(sheetObj, load_row, col, baseCol);
                selRow++;
            } // end while
        } // end with
}

function calculationCellApplyMode(org_value, APPLY_MODE, apply_value) {
    switch (APPLY_MODE) {
        case "round":
            var unit = getParam(saveParams, "unit");
            if (unit == "T" || unit == "") {
                return Math.round(org_value);
            } else if (unit == "F") {
                return Math.round(org_value * 2) / 2;
            }
        case "percent":
            return eval(org_value) * eval(apply_value);
        case "amount":
            return eval(org_value) + eval(apply_value);
    }
}

function calculationOneItemSet(sheetObj, row, displayCol, baseCol) {
    with(sheetObj) {
            var item_cnt = 4;
            var lod_qty = GetCellValue(row, baseCol);
            var grs_rpb = GetCellValue(row + 2, baseCol); //GRPB
            if (lod_qty != 0) {
                var cm_uc_amt = GetCellValue(row, "cm_uc_amt");
                SetCellValue(row + 1, baseCol, grs_rpb * lod_qty, 0); //GREV set
                SetCellValue(row + 3, baseCol, (grs_rpb - cm_uc_amt) * lod_qty, 0); //CM set
                SetCellValue(row + 4, baseCol, (grs_rpb - cm_uc_amt), 0); //RA_CM set
            } else {
                for (var i = 0; i <= item_cnt; i++) {
                    SetCellValue(row + i, baseCol, 0, 0);
                }
            }
            SetCellValue(row, "lod_qty", lod_qty, 0);
            SetCellValue(row, "grs_rpb_rev", GetCellValue(row + 2, baseCol), 0);
            // Display
            for (var i = 0; i <= item_cnt; i++) {
                SetCellValue(row + i, displayCol, getDisplayZeroToNull(GetCellValue(row + i, baseCol)), 0);
            }
        } // end with
    if (ComIsBtnEnable("btng_monthly_adj")) {
        ComBtnDisable("btng_monthly_adj");
    }
}

function processMainGrpRoundOff(sheetObj) {
    var rgn_list = sheetObj.GetEtcData("RGN_OFC_TOTAL").split(";");
    var selRow = 1;
    var baseCol = sheetObj.SaveNameCol("edt_step_val");
    var APPLY_MODE = "round";
    var cell_value = "";
    var col = getSelectColumnName();
    with(sheetObj) {
        for (var i = 0; i < rgn_list.length; i++) {
            var rgn_ofc_cd = rgn_list[i];
            selRow = 1;
            while (true) {
                selRow = FindText("ctrt_rgn_ofc_cd", rgn_ofc_cd, selRow);
                if (selRow < 0) {
                    break;
                }
                selRow = FindText("item_seq", LOAD, selRow);
                if (selRow < 0) {
                    break;
                }
                if (GetCellValue(selRow, "edit_flag") != 1 || GetCellValue(selRow, "rgn_grp") != 0) {
                    selRow++;
                    continue;
                }
                cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE);
                setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                // RGN-POL-POD item (Load row standard)
                calculationOneItemSet(sheetObj, selRow, col, baseCol);
                // NEW L/F = LOAD/BSA
                apply_value = GetCellValue(selRow, baseCol) / GetCellValue(selRow, "tot_bsa");
                // lane_sprt_grp LOAD calculate
                processCalcRgnPolPodChange(LOAD, sheetObj, selRow + 1, col, baseCol, "percent", apply_value);
                selRow++;
            }
        }
    }
}

function processCalcRoundOff2(sheetObj, row, col) {
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    var ITEM = LOAD;
    var APPLY_MODE = "round";
    var baseCol = sheetObj.SaveNameCol("edt_step_val");
    var cell_value = "";
    var selRow = row;
    if (!document.form.edit_mode[0].checked) {
        return;
    }
    cell_value = calculationCellApplyMode(sheetObj.GetCellValue(row, baseCol), APPLY_MODE);
    setCalcBaseColumn(sheetObj, row, baseCol, cell_value);
    // RGN-POL-POD item calculate ( Load row standard)
    calculationOneItemSet(sheetObj, row, col, baseCol);
    // NEW L/F  = LOAD/BSA
    apply_value = sheetObj.GetCellValue(row, baseCol) / sheetObj.GetCellValue(row, "tot_bsa");
    // lane_sprt_grp LOAD
    processCalcRgnPolPodChange(LOAD, sheetObj, row + 1, col, baseCol, "percent", apply_value);
    try {
        sheetObj.RenderSheet(0);
        with(sheetObj) {
                // ROW LOAD Round
                while ((selRow = sheetObj.FindText("item_seq", LOAD, selRow)) >= 0) {
                    if (GetCellValue(selRow, "lane_sprt_grp") != GetCellValue(row, "lane_sprt_grp")) {
                        selRow++;
                        break;
                    }
                    // apply_value
                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE);
                    setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                    // RGN-POL-POD item
                    calculationOneItemSet(sheetObj, selRow, col, baseCol);
                    selRow++;
                } // end whilea
            } // end with
        processCalcTotal(sheetObj, sheetObj.HeaderRows(), col, true);
    } catch (e) {
        ComShowMessage(e.message);
    } finally {
        sheetObj.RenderSheet(1);
    }
}

//    	function processCalcRoundOff() {
//    	    var formObj = document.form;
//    	    var sheetObj = sheetObjects[3];
//    		var ITEM = LOAD;
//    		var APPLY_MODE = "round";
//
//    		var startDate = new Date();
//    		processMainGrpRoundOff(sheetObj);
//
//
//
//    		try{
//    		    sheetObj.Redraw = false;
//
//    		    var baseCol = sheetObj.SaveNameCol("edt_step_val");
//    			var selCol = sheetObj.SaveNameCol(getSelectColumnName());
//    			var selRow = 1;
//    			var cell_value = 0;
//
//    			with (sheetObj) {
//
//    				// 전체 ROW LOAD Round
//    				while((selRow = sheetObj.FindText("item_seq", LOAD, selRow)) >= 0) {
//    					// apply_value
//    					cell_value = calculationCellApplyMode(CellValue(selRow, baseCol), APPLY_MODE );
//    					setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
//
//    					// RGN-POL-POD item
//    					calculationOneItemSet(sheetObj, selRow, selCol, baseCol);
//    					selRow++;
//    				} // end whilea
//
//    			} // end with
//    			 processCalcTotal(sheetObj,sheetObj.HeaderRows,selCol,true);
//    		} catch(e) {
//    			ComShowMessage(e);
//    		} finally {
//    		    sheetObj.Redraw = true;
//    		}
//
//    		var endDate = new Date();
//    		//log("processCalcRoundOff] =========================================================");
//    		//log("start Time : " + startDate);
//    		//log("end Time : " + endDate);
//    		//log("Process Time : " + (endDate.getTime() - startDate.getTime())/1000);
//    	}

function setCalcBaseColumn(sheetObj, row, baseCol, changeValue) {
    sheetObj.SetCellValue(row, baseCol, changeValue, 0);
}

// Calculate it to two decimal places
function getDisplayZeroToNull(num) {
    return (num == 0 ? "" : Math.round(num * 10) / 10);
}

// rate of increase
function calcIncreaseRatio(newValue, oldValue) {
    if (oldValue == 0) oldValue = 1;
    var ratio = getZeroToInfinity(parseFloat(newValue) / parseFloat(oldValue));
    return (Math.round(ratio * 1000000000000) / 1000000000000);
}

// Numerical Verification
function getZeroToInfinity(vl) {
    if (vl == Infinity || isNaN(vl)) {
        return 0;
    }
    return vl;
}

/*
 */
function processSheetPopupOK(objName, inputObjName) {
    //log("processSheetPopupOK() call : objName=" + objName + " inputObjName=" + inputObjName);
    var divObj = eval(objName);
    var sheetObj = eval(inputObjName);
    var inputObjects = new Array();
    logObjValue(objName, inputObjName, logObj);
    inputObjects[0] = parseSheetCheckBoxStr(eval("SUB_TRADE_INPUT"), "  :true|");
    inputObjects[1] = parseSheetCheckBoxStr(eval("LANE_INPUT"), "  :true|");
    inputObjects[2] = parseSheetCheckBoxStr(eval("RGN_INPUT"), "  :true|");
    inputObjects[3] = parseSheetCheckBoxStr(eval("POL_INPUT"), "  :true|");
    inputObjects[4] = parseSheetCheckBoxStr(eval("POD_INPUT"), "  :true|");
    inputObjects[5] = parseSheetCheckBoxStr(eval("ITEM_INPUT"), "  :true|");
    processDynamicPopupHideRow(divObj, sheetObj, inputObjects);
}

function processPopupOK(objName, inputObjName, html) {
    // //log("processPopupOK() call : objName=" + objName + " inputObjName=" +
    // inputObjName);
    var divObj = eval(objName);
    var inputObj = eval(inputObjName);
    var inputObjects = new Array();

    if (objName != "REMARKS") {
        inputObjects[0] = parseCheckBoxStr(eval("SUB_TRADE_INPUT"), true, " :true|");
        inputObjects[1] = parseCheckBoxStr(eval("LANE_INPUT"), true, " :true|");
        inputObjects[2] = parseCheckBoxStr(eval("AQ_INPUT"), true, " :true|");
        inputObjects[3] = parseCheckBoxStr(eval("RGN_INPUT"), true, " :true|");
        // inputObjects[3] = parseCheckBoxStr(eval("POL_INPUT"),true," :true|");
        // inputObjects[4] = parseCheckBoxStr(eval("POD_INPUT"),true," :true|");
        inputObjects[4] = parseCheckBoxStr(eval("ITEM_INPUT"), true, " :true|");
		
		rhqAdjSheet.RenderSheet(0); 
        if (inputObj.length != undefined) {
            for (var i = 0; i < inputObj.length; i++) {
                processHideRow(divObj, inputObj[i], inputObjects);
            }
        } else {
            processHideRow(divObj, inputObj, inputObjects);
        }
        rhqAdjSheet.SetDataMerge();  
    	rhqAdjSheet.RenderSheet(1);  
    }
}

function parseCheckBoxStr(obj, isAll, option) {
    var str = "";
    if (isAll == undefined) {
        isAll = true;
    }
    if (obj.length != undefined) {
        for (var i = 0; i < obj.length; i++) {
            if (isAll == false) {
                if (obj[i].checked) {
                    str += obj[i].value + ":" + obj[i].checked + "|";
                }
            } else {
                str += obj[i].value + ":" + obj[i].checked + "|";
            }
        }
    } else {
        if (isAll == false) {
            if (obj.checked) {
                str += obj.value + ":" + obj.checked + "|";
            }
        } else {
            str += obj.value + ":" + obj.checked + "|";
        }
    }
    str += option;
    //log("parseCheckBoxStr call : obj=" + obj.id + " return str=" + str);
    return str;
}

function processHideRow(divObj, inputObj, inputObjects) {
    // Loading 후 처음 Filter를 사용할때 oldValue를 인식하지 못하여 undefined가 나와서 이렬경우 True를 설정해 주었음
    if (inputObj.oldValue == undefined) inputObj.oldValue = true;
    if ((inputObj.checked && (inputObj.oldValue == "false" || inputObj.oldValue == false)) ||
        (!inputObj.checked && (inputObj.oldValue == "true" || inputObj.oldValue == true))) {

        var sheetObj = document.getElementById(divObj.getAttribute('sheetName')); //divObj.sheetName ==> divObj.getAttribute('sheetName')
        var colName = divObj.getAttribute('colName'); //colName ==> divObj.getAttribute('colName')
        var cols = new Array();
        var values = new Array();
        if (inputObj.checked == true) {
            cols[0] = colName;
            values[0] = inputObj.value;
            var filterCnt = processFilterSheet(sheetObjects[3], cols, values, inputObjects, true);
            if (colName == "item" && inputObj.value == "Volumn") {
                values[0] = "L/F";
                processFilterSheet(sheetObjects[3], cols, values, inputObjects, true);
            }
        } else if (inputObj.checked == false) {
            cols[0] = colName;
            values[0] = inputObj.value;
            var filterCnt = processFilterSheet(sheetObjects[3], cols, values, inputObjects, false);
            if (colName == "item" && inputObj.value == "Volumn") {
                values[0] = "L/F";
                processFilterSheet(sheetObjects[3], cols, values, inputObjects, false);
            }
        }
        inputObj.oldValue = inputObj.checked;
    }
}

/*
 */
function processFilterSheet(sheetObj, cols, oriValues, inputObjects, isDisplay) {
    //log("processFilterSheet : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+",inputObjects="+inputObjects+", isDisplay="+isDisplay);
    //log("processFilterSheet : cols.length=" + cols.length);
    var filterCnt = 0;
    //         sheetObj.ReDraw=false;
    var selRow = 0;
    var flg;

    var findId = 0;
    var findText = "";

    // 대상 Row를 찾는다.
    for (j = 0; j < cols.length; j++) {
        while (findId != -1) {
            findId = sheetObj.FindText(cols[j], oriValues[j], findId);
            if (findId >= 0) {
                findText += findId + "|";
                findId++;
            }
        }
    }

    // 대상 Row를 일괄 False 시키거나 True 일 경우는 다른 필터를 참조하여 Hidden 여부를 결정한다.
    if (findText != "") {
        if (isDisplay == true) {
            var findText1 = "";
            var findText2 = "";
            var arrText = findText.split("|");

            for (var k = 0; k < arrText.length; k++) {
                // 모든 필터가 True이면 활성화, 하나라도 False면 비활성화
                if (filterValidation(sheetObj, arrText[k], cols, inputObjects)) {
                    findText1 += arrText[k] + "|"; // 활성화
                } else {
                    findText2 += arrText[k] + "|"; // 비활성화
                }
            }
            // 다른 필터가 모두 체크되어 있을 경우(활성화)
            if (findText1 != "") {
                sheetObj.SetRowHidden(findText1, !isDisplay);
            }
            // 다른 필터가 체크되지 않은 것이 있을 경우(비활성화)
            if (findText2 != "") {
                sheetObj.SetRowHidden(findText2, isDisplay);
            }

        } else {
            // 일괄 Hidden 시킴(비활성화)
            sheetObj.SetRowHidden(findText, !isDisplay);
        }
    }

    // 이전 로직    
    //         for(var i=0 ; i <= sheetObj.LastRow(); i++){
    //             flg=false;
    //             for(var j=0 ; j < cols.length ; j++ ){
    //                 selRow=sheetObj.FindText(cols[j],oriValues[j],selRow);
    //                 if( selRow < 0 ){//찾는 값이 없다..
    //                     break;
    //                 }
    //             }
    //             if( selRow >= 0 ){
    //                 i=selRow;
    //                 selRow++;
    //                 for(var j=0 ; j < cols.length ; j++ ){
    //                	 if(oriValues[j] != sheetObj.GetCellValue(i,cols[(j)])  ){
    //                         flg=true;
    //                         break;
    //                     }
    //                 }
    //                 if(flg == false  ){
    //                     if( isDisplay == true){
    //                         if( filterValidation(sheetObj,i,cols,inputObjects) ){
    //                             sheetObj.SetRowHidden(i,!isDisplay);
    //                         }
    //                     }else{
    //                        sheetObj.SetRowHidden(i,!isDisplay);
    //                     }
    //                 }
    //             }else{
    //                 sheetObj.SetRowHidden(i,!isDisplay);
    //                 break;
    //             }
    //         }
    //        sheetObj.ReDraw=true;
    return filterCnt;
}

/*
        inputObjects[0]=parseCheckBoxStr(eval("SUB_TRADE_INPUT"));
        inputObjects[1]=parseCheckBoxStr(eval("LANE_INPUT"));
        inputObjects[2]=parseCheckBoxStr(eval("RGN_INPUT"));
        inputObjects[3]=parseCheckBoxStr(eval("POL_INPUT"));
        inputObjects[4]=parseCheckBoxStr(eval("POD_INPUT"));
        inputObjects[5]=parseCheckBoxStr(eval("ITEM_INPUT"));
 */
function filterValidation(sheetObj, row, cols, inputObjects) {
    var retValue = false;
    if (cols[0] == "sub_trd_cd") {
        if (inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "ctrt_aq_cd") + ":true|")) >= 0 && inputObjects[3].indexOf((sheetObj.GetCellValue(row, "ctrt_rgn_ofc_cd") + ":true|")) >= 0
            //				&& inputObjects[3].indexOf( (sheetObj.GetCellValue(row,"pol_cd")+":true|")) >=0
            //				&& inputObjects[4].indexOf( (sheetObj.GetCellValue(row,"pod_cd")+":true|")) >=0
            && inputObjects[4].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0
        ) {
            retValue = true;
        }
    } else if (cols[0] == "lane_grp") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "ctrt_aq_cd") + ":true|")) >= 0 && inputObjects[3].indexOf((sheetObj.GetCellValue(row, "ctrt_rgn_ofc_cd") + ":true|")) >= 0
            //				&& inputObjects[3].indexOf( (sheetObj.GetCellValue(row,"pol_cd")+":true|")) >=0
            //				&& inputObjects[4].indexOf( (sheetObj.GetCellValue(row,"pod_cd")+":true|")) >=0
            && inputObjects[4].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0
        ) {
            retValue = true;
        }
    } else if (cols[0] == "ctrt_aq_cd") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[3].indexOf((sheetObj.GetCellValue(row, "ctrt_rgn_ofc_cd") + ":true|")) >= 0
            //				&& inputObjects[3].indexOf( (sheetObj.GetCellValue(row,"pol_cd")+":true|")) >=0
            //				&& inputObjects[4].indexOf( (sheetObj.GetCellValue(row,"pod_cd")+":true|")) >=0
            && inputObjects[4].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0
        ) {
            retValue = true;
        }
    } else if (cols[0] == "ctrt_rgn_ofc_cd") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "ctrt_aq_cd") + ":true|")) >= 0
            //				&& inputObjects[3].indexOf( (sheetObj.GetCellValue(row,"pol_cd")+":true|")) >=0
            //				&& inputObjects[4].indexOf( (sheetObj.GetCellValue(row,"pod_cd")+":true|")) >=0
            && inputObjects[4].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0
        ) {
            retValue = true;
        }
        //        }else if( cols[0] == "pol_cd" ){
        //        	if( inputObjects[0].indexOf( (sheetObj.GetCellValue(row,"sub_trd_cd")+":true|")) >=0
        //				&& inputObjects[1].indexOf( (sheetObj.GetCellValue(row,"lane_grp")+":true|")) >=0
        //				&& inputObjects[2].indexOf( (sheetObj.GetCellValue(row,"ctrt_rgn_ofc_cd")+":true|")) >=0
        ////				&& inputObjects[4].indexOf( (sheetObj.GetCellValue(row,"pod_cd")+":true|")) >=0
        //				&& inputObjects[5].indexOf( (sheetObj.GetCellValue(row,"item")+":true|")) >=0
        //             ){
        //                retValue=true;
        //            }
        //        }else if( cols[0] == "pod_cd" ){
        //        	if( inputObjects[0].indexOf( (sheetObj.GetCellValue(row,"sub_trd_cd")+":true|")) >=0
        //				&& inputObjects[1].indexOf( (sheetObj.GetCellValue(row,"lane_grp")+":true|")) >=0
        //				&& inputObjects[2].indexOf( (sheetObj.GetCellValue(row,"ctrt_rgn_ofc_cd")+":true|")) >=0
        ////				&& inputObjects[3].indexOf( (sheetObj.GetCellValue(row,"pol_cd")+":true|")) >=0
        //				&& inputObjects[5].indexOf( (sheetObj.GetCellValue(row,"item")+":true|")) >=0
        //             ){
        //                retValue=true;
        //            }
    } else if (cols[0] == "item") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "ctrt_aq_cd") + ":true|")) >= 0 && inputObjects[3].indexOf((sheetObj.GetCellValue(row, "ctrt_rgn_ofc_cd") + ":true|")) >= 0
            //				&& inputObjects[3].indexOf( (sheetObj.GetCellValue(row,"pol_cd")+":true|")) >=0
            //				&& inputObjects[4].indexOf( (sheetObj.GetCellValue(row,"pod_cd")+":true|")) >=0
        ) {
            retValue = true;
        }
    }
    return retValue;
}

function processCalcApply() {
    var calcObj = document.form.calc_value;
    if (calcObj.value == "") {
        ComShowCodeMessage("COM12122", "Input value of the Apply");
        calcObj.focus();
        return;
    }
    var obj = document.getElementById("DIV__CALCULATION__DIV");
    //        var pObj=document.getElementsByName("btng_apply")[0];
    if (obj != null) {
        var evtobj = window.event ? window.event : e
        var tempX = event.clientX + document.body.scrollLeft;
        var tempY = event.clientY + document.body.scrollTop;
        //            openDynamicDragPopup(obj,tempX-400,tempY,410,300,sheetObjects[3]);
        openDynamicDragPopup(obj, tempX - 400, evtobj.offsetY + 850, 410, 300, sheetObjects[3]);
    }
}

function popupCheckAll(allObj, inputObj) {
    var check = allObj.checked;
    if (inputObj.length != undefined) {
        for (var i = 0; i < inputObj.length; i++) {
            inputObj[i].checked = check;
        }
    } else {
        inputObj.checked = check;
    }
}

function processCalcPopupOK(objName, html) {
    var startDate = new Date();
    var divObj = document.getElementById(objName);
    var inputObjects = new Array();
    //    	    inputObjects[0]=parseSheetCheckBoxStr(eval("LANE_CAL"),false);
    //    	    inputObjects[1]=parseSheetCheckBoxStr(eval("RGN_CAL"),false);
    inputObjects[0] = parseCheckBoxStr(eval("LANE_CAL"), false, " :true|");
    inputObjects[1] = parseCheckBoxStr(eval("RGN_CAL"), false, " :true|");
    if (inputObjects[0] == "") {
        ComShowCodeMessage("COM12113", "Lane");
        return;
    } else if (inputObjects[1] == "") {
        ComShowCodeMessage("COM12113", "R.OFC");
        return;
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    var editModeObj = formObj.edit_mode;
    var ITEM = 0;
    var APPLY_MODE = "";
    var CALC_VALUE = eval(formObj.calc_value.value);
    var NEW_ITEM = 0;
    var NEW_APPLY_MODE = "";
    var NEW_CALC_VALUE = "";
    var apply_LF = new Array();
    var lf_idx = 0;
    var baseCol = sheetObj.SaveNameCol("edt_step_val");
    var selCol = sheetObj.SaveNameCol(getSelectColumnName());
    var selRow = 1;
    var grs_rev = 0;
    var cell_value = 0;
    try {
        sheetObj.RenderSheet(0);
        var arrLANE_TOTAL = inputObjects[0].split(":true|");
        var arrRGN_OFC = inputObjects[1].split(":true|");
        var allRgnCount = (sheetObj.GetEtcData("RGN_OFC").split(";")).length;
        var isAllRgn = (allRgnCount == arrRGN_OFC.length ? true : false);
        var tmp_lod_val = 0;
        var tmp_rpg_val = 0;
        var cur_trade_cd = getTrd_cd();
        //log("processCalcPopupOK] arrLANE_TOTAL=" + arrLANE_TOTAL + " length=" + arrLANE_TOTAL.length);
        //log("processCalcPopupOK] allRgnCount=" + allRgnCount + " arrRGN_OFC.length=" + arrRGN_OFC.length);
        if (editModeObj[0].checked) { //LOAD
            ITEM = LOAD;
            APPLY_MODE = "amount";
        } else if (editModeObj[1].checked) { //G.REV
            ITEM = GREV;
            APPLY_MODE = (formObj.calc2[0].checked ? "amount" : "percent");
        } else if (editModeObj[2].checked) { //G.RPB
            ITEM = GRPB
            APPLY_MODE = (formObj.calc2[0].checked ? "amount" : "percent");
        }
        if (APPLY_MODE == "percent") {
            CALC_VALUE = (100 + eval(CALC_VALUE)) / 100;
        }
        //log("processCalcPopupOK] ITEM=" + ITEM);
        //log("processCalcPopupOK] APPLY_MODE=" + APPLY_MODE);
        //log("processCalcPopupOK] CALC_VALUE=" + CALC_VALUE);
        with(sheetObj) {
                for (var i = 0; i < arrLANE_TOTAL.length; i++) {
                    NEW_ITEM = ITEM;
                    NEW_APPLY_MODE = APPLY_MODE;
                    NEW_CALC_VALUE = CALC_VALUE;
                    selRow = sheetObj.FindText("lane_sprt_grp", arrLANE_TOTAL[i], selRow);
                    if (selRow == -1) {
                        continue;
                    }
                    //log("processCalcPopupOK] lane_sprt_grp=" + arrLANE_TOTAL[i] + " ROW=" + selRow);
                    if (isAllRgn) {
                        if (ITEM == GREV && APPLY_MODE == "percent") {
                            grs_rev = calculationCellApplyMode(GetCellValue(selRow + 2, baseCol), APPLY_MODE, CALC_VALUE);
                            NEW_CALC_VALUE = calcIncreaseRatio(grs_rev, GetCellValue(selRow + 2, baseCol));
                            NEW_APPLY_MODE = "percent";
                            NEW_ITEM = GRPB;
                        }
                        processCalcGroupChange(NEW_ITEM, sheetObj, selRow, selCol, baseCol, NEW_APPLY_MODE, NEW_CALC_VALUE);
                    } else {
                        var apply_LF = new Array();
                        var apply_TOTBSA = new Array();
                        var apply_RPB = new Array();
                        while ((selRow = sheetObj.FindText("item_seq", NEW_ITEM.toString(), selRow)) >= 0) {
                            if (arrLANE_TOTAL[i] == GetCellValue(selRow, "lane_sprt_grp") && inputObjects[1].indexOf(GetCellValue(selRow, "ctrt_rgn_ofc_cd") + ":true|") >= 0 && GetCellValue(selRow, "rgn_grp") == "0") {
                                if (NEW_ITEM == LOAD && NEW_APPLY_MODE == "amount") {
                                    if (GetCellValue(selRow, "edit_flag") == "1") {
                                        cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, NEW_CALC_VALUE);
                                        apply_LF[GetCellValue(selRow, "rgn_pol_pod")] = new Array();
                                        apply_LF[GetCellValue(selRow, "rgn_pol_pod")] = getZeroToInfinity(cell_value / GetCellValue(selRow, "tot_bsa"));
                                        apply_TOTBSA[GetCellValue(selRow, "rgn_pol_pod")] = new Array();
                                        apply_TOTBSA[GetCellValue(selRow, "rgn_pol_pod")] = GetCellValue(selRow, "tot_bsa");
                                        cell_value = calculationCellApplyMode(cell_value, "round");
                                    } else if (NEW_ITEM == LOAD && GetCellValue(selRow, 'edit_flag') != "1") {
                                        if (cur_trade_cd == "IAS" || cur_trade_cd == "EMS") {
                                            cell_value = apply_TOTBSA[GetCellValue(selRow, "rgn_pol_pod")] * apply_LF[GetCellValue(selRow, "rgn_pol_pod")];
                                            cell_value = calculationCellApplyMode(cell_value, "round");
                                        } else {
                                            cell_value = GetCellValue(selRow, "tot_bsa") * apply_LF[GetCellValue(selRow, "rgn_pol_pod")];
                                            cell_value = calculationCellApplyMode(cell_value, "round");
                                        }
                                    }
                                } else if (NEW_ITEM == GREV && NEW_APPLY_MODE == "percent") {
                                    grs_rev = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, CALC_VALUE);
                                    NEW_CALC_VALUE = calcIncreaseRatio(grs_rev, GetCellValue(selRow, baseCol));
                                    if (grs_rev != 0) {
                                        NEW_APPLY_MODE = "percent";
                                        NEW_ITEM = GRPB;
                                    }
                                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), NEW_APPLY_MODE, NEW_CALC_VALUE);
                                } else if (NEW_ITEM == GREV && NEW_APPLY_MODE == "amount") {
                                    grs_rev = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, CALC_VALUE);
                                    NEW_CALC_VALUE = calcIncreaseRatio(grs_rev, GetCellValue(selRow, baseCol));
                                    NEW_APPLY_MODE = "percent";
                                    cell_value = calculationCellApplyMode(GetCellValue(selRow + 1, baseCol), NEW_APPLY_MODE, NEW_CALC_VALUE);
                                    setCalcBaseColumn(sheetObj, selRow + 1, baseCol, cell_value);
                                    NEW_APPLY_MODE = "amount";
                                } else if (NEW_ITEM == GRPB && (cur_trade_cd == "IAS" || cur_trade_cd == "EMS")) {
                                    if (GetCellValue(selRow, "edit_flag") == "1") {
                                        cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), NEW_APPLY_MODE, NEW_CALC_VALUE);
                                        //tmp_rpb_val = cell_value;
                                        apply_RPB[GetCellValue(selRow, "rgn_pol_pod")] = new Array();
                                        apply_RPB[GetCellValue(selRow, "rgn_pol_pod")] = cell_value;
                                    } else {
                                        cell_value = apply_RPB[GetCellValue(selRow, "rgn_pol_pod")];
                                    }
                                } else {
                                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), NEW_APPLY_MODE, NEW_CALC_VALUE);
                                }
                                setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                                // RGN-POL-POD item
                                if (NEW_ITEM == LOAD && NEW_APPLY_MODE == "amount") {
                                    calculationOneItemSet(sheetObj, selRow, selCol, baseCol);
                                } else {
                                    if (GetCellValue(selRow, "item") == "G.REV") {
                                        calculationOneItemSet(sheetObj, selRow - 1, selCol, baseCol);
                                    } else {
                                        calculationOneItemSet(sheetObj, selRow - 2, selCol, baseCol);
                                    }
                                }
                            }
                            selRow++;
                        } // end while
                    } // end if (isAllRgn)
                    selRow = 1;
                } // end for i
            } // end with
            //Total sum
        processCalcTotal(sheetObj, sheetObj.HeaderRows(), selCol, true);
    } catch (e) {
        ComShowMessage(e.message);
    } finally {
        sheetObj.RenderSheet(1);
    }
    var endDate = new Date();
    //log("processCalcPopupOK] =========================================================");
    //log("start Time : " + startDate);
    //log("end Time : " + endDate);
    //log("Process Time : " + (endDate.getTime() - startDate.getTime())/1000);
}

// Monthly Adj popup
function openMonthlyAdj() {
    var formObj = document.form;
    var params = "gline_ver_no=" + formObj.glineVerNo.value + "&mqta_step_cd=" + WORK_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&unit=" + getParam(saveParams, "unit");
    var width = 850;
    var height = 500;
    ////log("openMonthlyAdj] Popup prams=" + params);
    var callback = "callbackRemark";
    ComOpenPopupScroll("ESM_SAQ_0149.do?" + params, width, height, callback, "0,0", true);
}

function clearTabSearchParams() {
    for (var i = 0; i < tabSearchParams.length; i++) {
        tabSearchParams[i] = "";
    }
}

// Excel Upload popup
function excelimportexport() {
    var formObj = document.form;
    var width;
    var height;
    width = 1030;
    height = 700;
    var callback = "callbackExcelUpload";
    // Step setting
    var params = "mQtaStepCd=" + WORK_STEP_CD + "&glineVerNo=" + getParam(saveParams, "glineVerNo") + "&mQtaVerNo=" + getParam(saveParams, "mQtaVerNo") + "&year=" + getParam(saveParams, "year") + "&bse_quarter=" + getParam(saveParams, "bse_quarter") + "&trade=" + getParam(saveParams, "trade") + "&bound=" + getParam(saveParams, "bound") + "&unit=" + getParam(saveParams, "unit") + "&inclPortFlag=N";
    ComOpenPopupScroll("ESM_SAQ_0161.do?" + params, width, height, callback, "0,0", true);
    callbackExcelUpload();
}

function callbackExcelUpload() {
    if (window.isParentRefresh == true) {
        doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
    }
}

function officeAdd() {
    var formObj = document.form;
    var width = 700;
    var height = 640;
    var callback = "callbackExcelUpload";
    //    	var params  = "mqta_step_cd=" + WORK_STEP_CD
    //    	            + "&mqta_ver_no=" + getParam(saveParams,"mQtaVerNo")
    //    	            + "&rhq_cd="      + getParam(saveParams,"ofcCd")
    //    				+ "&bse_yr="      + getParam(saveParams,"year")
    //    				+ "&bse_qtr_cd="  + getParam(saveParams,"bse_quarter")
    //    				+ "&trade_group=" + getParam(saveParams,"trade_group")
    //    				+ "&trd_cd="      + getParam(saveParams,"trade")
    //    				+ "&dir_cd="      + getParam(saveParams,"bound");
    var params = "mqta_step_cd=" + WORK_STEP_CD + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&rhq_cd=" + formObj.ofcCd.value + "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&trade_group=" + trade_group.GetSelectCode() + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound");
    ComOpenPopupScroll("ESM_SAQ_0162.do?" + params, width, height, callback, "0,0", true);
    callbackExcelUpload();
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_quarter");
    SaqSearchOptionTargetGroup("trade_group");
    SaqSearchOptionBound("bound", false);
    SaqSearchOptionComCode("unit", "CD00897", false);
    SaqSearchOptionYear("pfmc_fr_year");
    SaqSearchOptionMonth("pfmc_fr_month");
    SaqSearchOptionYear("pfmc_to_year");
    SaqSearchOptionMonth("pfmc_to_month");
}

function callBackReturnString(rtnValue) {
    return rtnValue;
}