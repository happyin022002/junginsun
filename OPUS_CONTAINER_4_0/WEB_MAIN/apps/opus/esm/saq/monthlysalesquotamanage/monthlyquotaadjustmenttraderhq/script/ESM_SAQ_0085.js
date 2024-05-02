/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0085.js
*@FileTitle  : Monthly Quota Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var initSelect = 1;
var logObj = new Array("SUB_TRADE_INPUT", "LANE_INPUT", "ITEM_INPUT");
logObj["SUB_TRADE"] = new Array("false");
logObj["LANE"] = new Array("false");
logObj["ITEM"] = new Array("true");
var sheetObjects = new Array();
var sheetCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var currentTabIndex = 0;
var comObjects = new Array();
var comboCnt = 0;
// tab variable
var tabSearchParams = ["-1", "", "", ""];
// month variable
var monthNames = new Array();
var monthNumbers = new Array();
// apps/opus/esm/saq/script/DynamicPopup.js
var MQTA_STEP_CD = "02";
var WORK_STEP_CD = "02";
var isSearchEnd = false;
var saveParams = "";
var tabSaveParams = "";
var searchSaqStsCd = "";
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
var FILTER_TEXT = "";
var perfIFdate = "";
var btn_name = ""; //DownExcel에서 사용하기 위해서
var msgArr = new Array();

// Event handler processing by button click event */
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[currentTabIndex];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        btn_name = srcName;
        if (ComGetBtnDisable(srcName)) return false;
        //        		var srcObj=window.event.srcElement;
        //             if(srcObj.GetEnable()!= undefined && !srcObj.GetEnable()) return;
        formObject.f_cmd.value = getCommandByStep(srcName);
        switch (srcName) {
            case "help": // Version()Help
                // 					popupCodeInfo(event.screenX,event.screenY,event.offsetX,event.offsetY);
                popupHelpInfo();
                break;
            case "btng_go": // top TAB retrieve
                tabSearchParams[currentTabIndex] = "";
                doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC02);
                break;
            case "btn_retrieve": // retrieve
                doActionIBSheet(sheetObjects[3], formObject, IBSEARCH);
                break;
            case "btn_go_retrieve": // retrieve
                doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC03);
                break;
            case "btn_retrieve2": // retrieve
                doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC03);
                break;
            case "btn_new": // initializing conditaion
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
                changePfmcFromTo(); /* PFMC date setting */
                changeVersion(); /* Versionsetting */
                break;
            case "btn_save": // save
            case "btn_save1": // save
                if (!ComIsBtnEnable("btn_save")) return;
                doActionIBSheet(sheetObjects[3], formObject, IBSAVE);
                break;
            case "btn_saveasnew":
                if (!ComIsBtnEnable("btn_saveasnew")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Save As New Version"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSAVE);
                }
                break;
            case "btn_cancelcurrent":
                if (!ComIsBtnEnable("btn_cancelcurrent")) return;
                flag = ComShowConfirm(getMsg("SAQ90140", "Cancel", formObject.mQtaVerNo.value));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_confirmdraft":
                if (!ComIsBtnEnable("btn_confirmdraft")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Confirm"));
                if (flag) {
                    formObject.f_cmd.value = getCommandByStep(srcName);
                    if (isSheetEdited) {
                        // If there is modified data to Trade Sheet
                        if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                            return;
                        }
                    }
                    if (formObject.f_cmd.value == MODIFY04) {
                        validateConfirmCheck(sheetObjects[3], formObject);
                        //							var rtn = validateConfirmCheck(sheetObjects[3], formObject);
                        //							if(rtn == true){
                        //								formObject.f_cmd.value = MODIFY04;
                        //								doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
                        //							}
                    } else if (formObject.f_cmd.value == MODIFY06) {
                        doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                    }
                    // 						doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
                }
                break;
            case "btn_cancelconfirmation":
                if (!ComIsBtnEnable("btn_cancelconfirmation")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Cancel Confirmation"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_notifydraft":
                if (!ComIsBtnEnable("btn_notifydraft")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Notify"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_cancelnotification":
                if (!ComIsBtnEnable("btn_cancelnotification")) return;
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
            case "btng_monthly_adj":
                if (!ComIsBtnEnable("btng_monthly_adj")) return;
                openMonthlyAdj();
                break;
            case "edit_mode": //Edit Mode click
                if (!ComIsBtnEnable("btng_apply")) return;
                changeEditMode();
                break;
            case "btng_apply":
                if (!ComIsBtnEnable("btng_apply")) return;
                processCalcApply();
                break;
                // 			    case "btng_roundoffcalc":
                // 					if (formObject.btng_roundoffcalc.Enable == false ) return;
                // 			        processCalcRoundOff();
                // 			        break;
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
    optionSetting();
    monthSetting();
    var formObj = document.form;
    setYearMonthObject(formObj.year, formObj.bse_quarter);
    setQTGroupToRhqOffice();
    var rtn = getCodeList("SaqMonthlyQuotaPerfIFDate", "ofcCd=" + document.form.ofcCd.value);
    perfIFdate = "( Last Update : " + rtn[0].substring(0, 16) + " )";
    // button control
    controlButtons("", document.form);
    var objs = document.all.item("tabLayer");
    for (var i = 0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        /* 			if( i < 3 ){
             		  objs[i].style.display="Inline";
         			}*/
        initSheet(sheetObjects[i], i + 1, "INIT");
        ComEndConfigSheet(sheetObjects[i]);
    }
    //for(var k=0;k<tabObjects.length;k++){
    initTab(tabObjects[0], 1);

    //}
    // PFMC date setting
    changePfmcFromTo();
    if (isDevMode) {
        formObj.ofcCd.readOnly = false;
        sheetObjects[3].SetColHidden("edt_step_val", 0);
        sheetObjects[3].SetColHidden("tot_bsa", 0);
        //document.getElementById('excel_div').style.display='block';
    } else {}
    //document.form.year.focus();
}

//setting month
function monthSetting() {
    var rtn = getCodeList("CommonCode", "codeNo=CD01915"); //영문월 "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Jan","Feb"
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
    rtn = getCodeList("CommonCode", "codeNo=CD20011"); //월번호 "12","01","02","03","04","05","06","07","08","09","10","11","12","01","02"
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
function initSheet(sheetObj, sheetNo, pInit) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      // Target Group / Trade sheet1 init
		case 2:      // Sub-Trade sheet3 init
			with(sheetObj){
				changeHeadTitle(sheetObj,pInit);
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:3, DataRowMerge:0, PrevColumnMergeMode:0  } );
	
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
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
					cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				}
				InitColumns(cols);
				SetEditable(0);
				//SetRangeBackColor(1, 3, 1, 31, "#777777");
				SetWaitImageVisible(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj,18));
			}
			break;
	
		case 3:      //RHQ Lane Sheet init
			with(sheetObj){
			changeHeadTitle(sheetObj,pInit);
			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:4, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
			var cols = [ {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"tree",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"subTrd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			
			for (var i=0; i<4; i++) {
				cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
				cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			}
			InitColumns(cols);
			SetEditable(0);
			SetWaitImageVisible(0);
			SetSheetHeight(ComGetSheetHeight(sheetObj,18));
			//SetRangeBackColor(1, 4, 1, 32, "#777777");
			// InitTreeInfo("tree", "sLevel", "#0000FFNAN";
			}
			break;
	
		case 4:      //trdGrpAdjSheet
			with(sheetObj){
				target_month_init();
				trdGrpAdjSheet_changeHeadTitle(sheetObj, pInit);
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:4, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
				var cols = [ {Type:"Text",      Hidden:0,                Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_grp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Text",      Hidden:0,                Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,                Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, ImgWidth:10, ImgHeight:10 },
				{Type:"Float",     Hidden:0,                Width:85,   Align:"Right",   ColMerge:0,   SaveName:"monthly",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fcast",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mdl_rslt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"trd_grp",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rhq",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"final",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:0,                Width:70,   Align:"Right",   ColMerge:0,   SaveName:"adjusted",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,                Width:110,  Align:"Center",  ColMerge:1,   SaveName:"remarks",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rhq_ke",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"edit_flag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"lane_sprt_grp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"sprt_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Int",       Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"item_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"edt_step_val",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"org_step_val",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"grs_rpb_rev",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cm_uc_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"opfit_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ra_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ra_opfit_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tot_bsa",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Float",     Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"low_qty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:(isDevMode?0:1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
				InitColumns(cols);
				SetEditable(1);
	
				SetImageList(0,ICO_FILTER);
	
				SetCellImage(0, "sub_trd_cd",0);
				SetCellImage(0, "lane_grp",0);
				SetCellImage(0, "item",0);
				//SetRangeBackColor(1, 4, 1, 50, "#777777");
				SetWaitImageVisible(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj,18));
			}
			break;
	
		case 5:      //rmkSheet
			with(sheetObj){
				var HeadTitle="rlane_cd|sprt_grp_cd|bsa_grp_cd|ctrt_rhq_cd|rlane_grp|subj_ctnt|cmt_ctnt|rmk_cre_gdt|cre_ofc_cd";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rlane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"sprt_grp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa_grp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ctrt_rhq_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rlane_grp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"subj_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cmt_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rmk_cre_gdt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cre_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
				InitColumns(cols);
				SetEditable(0);
				SetWaitImageVisible(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj,18));
			}
			break;
	}
}

/*
 * setting header title
 */
function changeHeadTitle(sheetObj, pInit) {
    var year = document.form.year.value;
    var mon = getQuarterToMonth(document.form.bse_quarter.value);
    var monIdx = mon - 1;
    var before_year = (monIdx == 0) ? eval(year - 1) : year;
    var HeadTitle = "";
    var HeadTitle1 = "";
    if (sheetObj.id == "rhqLaneSheet") {
        HeadTitle = "Tree|Sub \nTrade|Lane|Item|" + "Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|" + "Recent Quota\n(" + before_year + "." + monthNumbers[monIdx] + ")|";
        HeadTitle1 = "Tree|Sub \nTrade|Lane|Item|Quota|Est.\nPFMC|+/-|%|Quarterly|";
    } else {
        var keyHead = (sheetObj.id == "t1sheet1" ? "Trade|Bound|Item|" : "Sub \nTrade|Bound|Item|");
        HeadTitle = keyHead + "Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|" + "Recent Quota\n(" + before_year + "." + monthNumbers[monIdx] + ")|";
        HeadTitle1 = keyHead + "Quota|Est.\nPFMC|+/-|%|Quarterly|";
    }
    for (var j = 0; j < 6; j++) {
        HeadTitle = HeadTitle + year + " " + document.form.bse_quarter.value + " Total|";
    }
    for (var i = 0; i < 3; i++) {
        for (var j = 0; j < 6; j++) {
            HeadTitle = HeadTitle + year + "." + monthNumbers[monIdx + 1] + "|";
        }
        if (monIdx == 11) {
            year = year + 1;
        }
        monIdx++;
    }
    // HeadTitle1 setting
    for (var i = 0; i < 4; i++) {
        HeadTitle1 = HeadTitle1 + "Model\nResult|Guideline|Trade\nGroup|Regional\nGroup|Final|Final\nAdjusted|";
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

    var unit_text = document.form.unit.options[document.form.unit.selectedIndex].text;
    document.all("sheet_unit")[currentTabIndex].innerHTML = "Unit : " + unit_text + " / USD / USD 1,000*";
}

/*
 * trdGrpAdjSheet setting header title
 */
function trdGrpAdjSheet_changeHeadTitle(sheetObj, pInit) {
    var year = document.form.target_month.value.substring(0, 4);
    var month = document.form.target_month.value.substring(4);
    var mon = getQuarterToMonth(document.form.bse_quarter.value);
    var before_year = (mon == "01") ? year - 1 : year;
    var before_month = monthNumbers[eval(mon) - 1];
    var HeadTitle = "Sub\nTrade" + FILTER_TEXT + "|Lane" + FILTER_TEXT + "|Regional\nGroup" + "|Item" + FILTER_TEXT + "|";
    var HeadTitle1 = HeadTitle;
    // HeadTitle setting
    HeadTitle = HeadTitle + "Recent Quota\n(" + before_year + "." + before_month + ")|";
    for (var j = 0; j < 6; j++) {
        HeadTitle = HeadTitle + year + "." + month + "|";
    }
    HeadTitle = HeadTitle + "Remarks|";
    HeadTitle1 = HeadTitle1 + "Quarterly|Model\nResult|Guideline|Trade\nGroup|Regional\nGroup|Final|Final\nAdjusted|Remarks|";
    var hiddenTitle = "rhq_ke|edit_flag|lane_sprt_grp|rlane_cd|sprt_grp_cd|bsa_grp_cd|item_seq|ibflag|edt_step_val|org_step_val|lod_qty|grs_rpb_rev|cm_uc_amt|opfit_uc_amt|ra_cm_uc_amt|ra_opfit_uc_amt|tot_bsa|low_qty";

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

    var unit_text = document.form.unit.options[document.form.unit.selectedIndex].text;
    document.all("adj_sheet_unit").innerHTML = "Unit : " + unit_text + " / USD";
}

// trdGrpAdjSheet target_month setting
function target_month_init(isReload) {
    if (isReload == undefined) {
        isReload = false;
    }
    var formObj = document.form;
    var target_year = formObj.year.value;
    var mon = getQuarterToMonth(document.form.bse_quarter.value);
    var monIdx = mon - 1;
    // rhqAdjSheet Month object
    var obj = formObj.target_month;
    if (obj.options.length > 0 && isReload == false && target_year == obj.options[0].value.substring(0, 4) && mon == obj.options[0].value.substring(4)) {
        return;
    }
    for (var i = 0; i < 3; i++) {
        // rhqAdjSheet Month setting
        obj.options[i] = new Option(monthNames[monIdx], target_year + monthNumbers[monIdx + 1]);
        if (monIdx == 11) target_year = target_year + 1;
        monIdx++;
    }
}

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH_ASYNC02: // Tab retrieve
            if (formObj.mqtaMdlVerNo.value != "" && (tabSearchParams[currentTabIndex] != getTabLocalParams())) {
                if (currentTabIndex == 0) {
                    // Target Group/Trade retrieve
                    formObj.f_cmd.value = SEARCHLIST02;
                } else if (currentTabIndex == 1) {
                    // Sub-Trade retrieve
                    formObj.f_cmd.value = SEARCHLIST03;
                } else if (currentTabIndex == 2) {
                    // RHQ/Lane retrieve
                    formObj.f_cmd.value = SEARCHLIST04;
                }
                if (validateForm(sheetObj, formObj, sAction) == false) {
                    break;
                }
                ComOpenWait(true);
                changeHeadTitle(sheetObj, "");
                // setting search condition
                tabSearchParams[currentTabIndex] = getTabLocalParams();
                var params = "f_cmd=" + formObj.f_cmd.value + tabSearchParams[currentTabIndex];
                // retrieve
                if (currentTabIndex == 2) {
                    // Lane retrieve
                    var sXml = sheetObj.GetSearchData("ESM_SAQ_0085GS.do", params);
                    if (sXml != "") sheetObj.LoadSearchData(sXml, {
                        sync: 1
                    });
                    // 						sheetObj.FrozenCols=8;
                } else {
                    var sXml = sheetObj.GetSearchData("ESM_SAQ_0048GS2.do", params);
                    if (sXml != "") sheetObj.LoadSearchData(sXml, {
                        sync: 1
                    });
                    // 						sheetObj.FrozenCols=7;
                }
                ComOpenWait(false);
            }
            break;
        case IBSEARCH: //retrieve
            formObj.f_cmd.value = SEARCHLIST;
            formObj.mQtaStepCd.value = MQTA_STEP_CD;
            if (isSheetEdited) {
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    return;
                }
            }
            if (validateForm(sheetObj, formObj, sAction) == false) {
                break;
            }
            ComOpenWait(true);
            saveParams = "";
            target_month_init(true);
            sub_trd_cd_init();
            trdGrpAdjSheet_changeHeadTitle(sheetObj, "");
            // trdGrpAdjSheet retrieve
            var version = formObj.version.value.split(":");
            if (version.length == 2) {
                document.form.mQtaVerNo.value = version[0];
                document.form.glineVerNo.value = version[1];
            }
            var param = saqFormString(formObj);
            sheetObjects[3].DoSearch("ESM_SAQ_0085GS.do", param);
            ComOpenWait(false);
            break;
        case IBSEARCH_ASYNC03: //retrieve(go)
        case IBSEARCH_ASYNC04: //retrieve
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
            trdGrpAdjSheet_changeHeadTitle(sheetObj, "");
            saveParams = replaceParams(saveParams, "target_month", formObj.target_month.value);
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            saveParams = replaceParams(saveParams, "search_sub_trd_cd", formObj.search_sub_trd_cd.value);
            saveParams = replaceParams(saveParams, "search_rlane_cd", formObj.search_rlane_cd.value);
            var tmpP = saveParams;
            sheetObjects[3].DoSearch("ESM_SAQ_0085GS.do", tmpP);
            ComOpenWait(false);
            break;
        case IBSAVE:
            // MODIFY01 : Save
            // MODIFY02 : Save As New Version
            if (validateForm(sheetObj, formObj, sAction) == false) {
                return;
            }
            ComOpenWait(true);
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            sheetObj.DoSave("ESM_SAQ_0085GS.do", saveParams, "ibflag", false);
            isSheetEdited = false;
            ComOpenWait(false);
            break;
        case IBSEARCH_ASYNC01: // Cancel Current Version()~ Confirm Draft
            // MODIFY03 : Cancel Current Version
            // MODIFY04, MODIFY06 : Confirm Draft
            // MODIFY05 : Cancel Confirmation
            // MODIFY07 : Notify Draft
            // MODIFY08 : Cancel Notification
            if (isSheetEdited) {
                // If there is modified data to Trade Sheet
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    return;
                }
            }
            ComOpenWait(true);
            saveParams = getLocalParams(); //current parameter setting
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            // 				sheetObj.DoSave("ESM_SAQ_0085GS.do",saveParams, "ibflag", false);
            var sParam = sheetObj.GetSaveString(0, 1, "ibflag");
            var sXml = sheetObj.GetSaveData("ESM_SAQ_0085GS.do", sParam + "&" + saveParams);
            sheetObj.LoadSaveData(sXml, {
                Sync: 1
            });
            ComOpenWait(false);
            if (sheetObj.GetEtcData("saqStsCd") != "null" && sheetObj.GetEtcData("saqStsCd") != undefined) {
                var cur_version = formObj.version.value;
                changeVersion();
                formObj.version.value = cur_version;
                searchSaqStsCd = sheetObj.GetEtcData("saqStsCd");
                controlButtons(searchSaqStsCd, formObj);
                changeEditMode();
            }
            isSheetEdited = false;
            break;
        case IBSEARCH_ASYNC05:
            formObj.f_cmd.value = SEARCHLIST05;
            param = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            sheetObj.DoSearch("ESM_SAQ_0048GS2.do", param, {
                Append: false
            });
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
                SetSelectedIndex(0);
            }
            break;
    }
}

/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab_OnChange(tabObj, nItem) {
    var objs = document.all.item("tabLayer");
    objs[nItem].style.display = "Inline";
    var beforetab = currentTabIndex;
    if (currentTabIndex != nItem) {
        objs[beforetab].style.display = "none";
    }
    /* 		for(var i = 0; i<objs.length; i++){
    		       if(i != nItem){
    		        objs[i].style.display="none";
    		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    		       }
    		      }*/
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
    with(formObj) {
        if (comObjects[0].GetSelectCode() == '') {
            ComShowCodeMessage("COM12113", "Target Group");
            return false;
        }
        if (getParam(saveParams, "trade") == null) {
            ComShowCodeMessage("COM12113", "Trade");
            return false;
        }
        if (getParam(saveParams, "bound") == null) {
            ComShowCodeMessage("COM12113", "Bound");
            return false;
        }
        if (getParam(saveParams, "mQtaVerNo") == null) {
            ComShowCodeMessage("COM12113", "Version");
            return false;
        }
        switch (eval(f_cmd.value)) {
            case MODIFY01:
                return validateSave(sheetObj);
                //             	case MODIFY04 :
                //            				return validateConfirmCheck(sheetObj, formObj);
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
    return true;
}

// Check before saving message...
function validateSave(sheetObj) {
    var msgLane = "";
    var msgError = new Array("", "", "");
    var showMsgError = new Array();
    var idx = 0;
    var selRow = 0;
    with(sheetObj) {
            // 1. Load/GRPB (-) check (2007.06.08)
            while ((selRow = FindText("item_seq", LOAD, selRow)) > -1) {
                if (GetCellValue(selRow, "edit_flag") != "1") {
                    selRow++;
                    continue;
                }
                msgLane = GetCellValue(selRow, "lane_sprt_grp") + "/" + GetCellValue(selRow, "rhq_cd");
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

// MODIFY04 : Confirm Draft 일때 Load 0 check Inform
function validateConfirmCheck(sheetObj, formObj) {
    if (sheetObjects[3].rowCount == 0) {
        //no support[implemented common]CLT 			ComShowMessage(sheetObj.MessageText ("UserMsg13"));
        return false;
    }
    // 		var params = "f_cmd="+ MODIFY09
    // 		            + saqFormString(formObj).substring(8);
    saveParams = replaceParams(saveParams, "f_cmd", MODIFY09);
    // check retrieve
    // 	    sheetObj.DoSave("ESM_SAQ_0085GS.do", saveParams, "ibflag", false);
    var sParam = sheetObj.GetSaveString(0, 1, "ibflag");
    var sXml = sheetObj.GetSaveData("ESM_SAQ_0085GS.do", sParam + "&" + saveParams);
    sheetObj.LoadSaveData(sXml, { Sync: 1 });
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
        //            return showMsgWindow(getMsg("SAQ90149", msgList), "1");
    } else {
        // 			return true;
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
        return false;
    }
}

/**
 * control button
 **/
function controlButtons(stsCd, formObj) {
    ComBtnDisable("btng_monthly_adj");
    ComBtnDisable("btng_apply");
    ComBtnDisable("btn_cancelcurrent");
    switch (stsCd) {
        case "00": // Init
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_save1");
            ComBtnEnable("btn_saveasnew");
            ComBtnEnable("btn_cancelcurrent");
            ComBtnEnable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            ComBtnEnable("btng_apply");
            if (formObj.target_month.selectedIndex == 0) {
                ComBtnEnable("btng_monthly_adj");
            }
            break;
        case "DC": // Confirm Draft
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btn_saveasnew");
            ComBtnDisable("btn_confirmdraft");
            ComBtnEnable("btn_cancelconfirmation");
            ComBtnEnable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            break;
        case "DN": // Notify Draft
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btn_saveasnew");
            ComBtnDisable("btn_cancelcurrent");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnEnable("btn_cancelnotification");
            break;
        case "FR": // Confirm Draft
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btn_saveasnew");
            ComBtnEnable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            break;
        default: // Init && "FC", "XX" Cancel Current Version()
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btn_saveasnew");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            break;
    }
}

// 상태별 COMMAND 가져오기
function getCommandByStep(srcName) {
    switch (srcName) {
        case "btn_saveasnew":
            return MODIFY02;
        case "btn_save": // save
        case "btn_save1": // save
            return MODIFY01;
        case "btn_cancelcurrent":
            return MODIFY03;
        case "btn_confirmdraft":
            return (WORK_STEP_CD == "02" ? MODIFY04 : MODIFY06);
        case "btn_cancelconfirmation":
            return MODIFY05;
        case "btn_notifydraft":
            return MODIFY07;
        case "btn_cancelnotification":
            return MODIFY08;
        default:
            return "";
    } // end switch
}

//load column
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
 * PFMC from ~ to
 */
function changePfmcFromTo() {
    var formObj = document.form;
    var rep_year = formObj.year.value;
    var mon = getQuarterToMonth(document.form.bse_quarter.value);
    var bse_quarter = mon - 1;
    var repDate = new Date(rep_year, bse_quarter, 1);
    var fromDate = new Date(repDate - ((4 * 30) * (24 * 60 * 60 * 1000))); // -4 months
    var toDate = new Date(repDate - ((3 * 30) * (24 * 60 * 60 * 1000))); // -3 months
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

/*
 * retrieve Sub Trade
 */
function subTrade_onChange() {
    doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
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

/*
 * target_month retrieve
 */
// 	function target_month_onChange() {
// 		doActionIBSheet(sheetObjects[3],document.form,IBSEARCH);
// 	}

/*
 * target_month retrieve
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

// rhqAdjSheet sub_trd_cd setting
function sub_trd_cd_change(portFlag) {
    var formObj = document.form;
    // 		if (portFlag == "N") return;
    var objSub_trd = formObj.search_sub_trd_cd;
    var selSub_trd = objSub_trd.value;
    var bse_mon = formObj.target_month.value.substring(4);
    var params = "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&bse_mon=" + bse_mon;
    getSelectCodeList(objSub_trd, "SaqMonQtaTrdSubtrd", params, true);
    if (objSub_trd.options.length == 0) {
        objSub_trd.options[0] = new Option("ALL", "");
    } else {
        // checking whether data exists or not
        var selChk = false;
        for (i = 0; i < objSub_trd.length; i++) {
            if (objSub_trd.options[i].value == selSub_trd) {
                selChk = true;
                break;
            }
        }
        if (selChk == true && selSub_trd != "") {
            objSub_trd.value = selSub_trd;
        } else {
            objSub_trd.selectedIndex = 0;
        }
    }
}

// rhqAdjSheet rlane_cd setting
function rlane_cd_change() {
    var formObj = document.form;
    var objRlane = formObj.search_rlane_cd;
    // setting Lane
    var selLane = objRlane.value;
    var bse_mon = formObj.target_month.value.substring(4);
    var sub_trd = formObj.search_sub_trd_cd.value;
    if (sub_trd == "") {
        // case of  sub_trd ==all
        var opts = objRlane.options;
        for (i = (opts == null ? 0 : opts.length); i >= 0; i--) {
            objRlane.remove(i);
        }
        objRlane.options[0] = new Option("ALL", "");
    } else {
        var params = "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + formObj.year.value + "&trd_cd=" + formObj.trade.value + "&dir_cd=" + formObj.bound.value + "&mqta_ver_no=" + formObj.mQtaVerNo.value + "&bse_mon=" + bse_mon + "&sub_trd_cd=" + sub_trd;
        getSelectCodeList(objRlane, "SaqMonQtaTrdLane", params, true);
        if (objRlane.options.length == 0) {
            objRlane.options[0] = new Option("ALL", "");
        } else {
            // in case of existing Lane
            var selChk = false;
            for (i = 0; i < objRlane.length; i++) {
                if (objRlane.options[i].value == selLane) {
                    selChk = true;
                    break;
                }
            }
            if (selChk == true && selLane != "") {
                // setting Lane
                objRlane.value = selLane;
            } else {
                // setting Lane in case of not existing Lane
                objRlane.selectedIndex = 0;
            }
        }
    }
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
 * setting Sub Trade
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
}

function changeEditCols(sheetObj, itemCd, colName) {
    editableCols(sheetObj, LOAD, colName, false);
    editableCols(sheetObj, GREV, colName, false);
    editableCols(sheetObj, GRPB, colName, false);
    editableCols(sheetObj, itemCd, colName, true);
}

/**
 *
 * @param sheetObj
 * @param itemCd
 * @param colName
 * @param flg
 */
function editableCols(sheetObj, itemCd, colName, flg) {
    var selRow = 0;
    var isEdit = false; // true : editable, false : disabled
    var first_rane_grp = "";
    if (flg == undefined) {
        flg = true;
    }
    while ((selRow = sheetObj.FindText('item_seq', itemCd.toString(), selRow)) >= 0) {
        if (flg == false && sheetObj.GetCellEditable(selRow, colName) == false) {
            if (selRow < 14) {
                return;
            }
            selRow++;
            continue;
        }
        // editable in case of edit_flag==1
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
    var trade_group = comObjects[0].GetSelectCode(); //trade_group.GetSelectCode();
    return "&glineVerNo=" + formObj.glineVerNo.value + "&mqtaMdlVerNo=" + formObj.mqtaMdlVerNo.value + "&slsFcastPubNo=" + formObj.slsFcastPubNo.value + "&mQtaVerNo=" + getParam(saveParams, "mQtaVerNo") + "&trade_group=" + trade_group + "&year=" + getParam(saveParams, "year") + "&bse_quarter=" + getParam(saveParams, "bse_quarter") + "&trade=" + getParam(saveParams, "trade") + "&bound=" + getParam(saveParams, "bound") + "&ctrt_rhq_cd=" + getParam(saveParams, "ofcCd") + "&pfmc_fr_year=" + formObj.pfmc_fr_year[currentTabIndex].value + "&pfmc_fr_month=" + formObj.pfmc_fr_month[currentTabIndex].value + "&pfmc_to_year=" + formObj.pfmc_to_year[currentTabIndex].value + "&pfmc_to_month=" + formObj.pfmc_to_month[currentTabIndex].value + "&unit=" + getParam(saveParams, "unit");
}

// 	function rhqLaneSheet_OnDblClick(sheetObj, Row, Col) {
// 		with(sheetObj) {
// 			var text=GetCellValue(Row,Col);
// 			if (text != 'TOTAL') return;
// 			var end_row=Row;
// 			//var end_row = FindText(Col, text, Row, false);
// 			var end_text="";
// 			do {
// 				end_row++;
// 				end_text=GetCellText(end_row,Col);
// 			} while (text == end_text );
// 			end_row=end_row-1;
// 			//log("find end-row=" + end_row);
// 			if(!(GetRowHidden(end_row))){
// 				SetRowExpanded(end_row,!(GetRowExpanded(end_row)));
// 			}
// 		} // end with
// 	}

//function callbackRemark() {
//    if (window.isRemarkRefresh == true) {
//        doActionIBSheet(sheetObjects[4], document.form, IBSEARCH_ASYNC05);
//        processRemarkHighlight(getParseSaveParam(window.remarkRefreshParam, "rlane_grp"), getParseSaveParam(window.remarkRefreshParam, "ctrt_rhq_cd"));
//    }
//}

function callbackRemark(rtnVal) {		
	var rtnValue = rtnVal; 
	
    if (rtnValue[0] == "OK") {        
        doActionIBSheet(sheetObjects[4], document.form, IBSEARCH_ASYNC05);
        processRemarkHighlight(rtnValue[1], rtnValue[2]);        
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
    var ctrt_rhq_cd = "";
    var selRow = 0;
    for (var row = sheetObj.HeaderRows(); row <= lastRow; row++) {
        selRow = 0;
        rlane_grp = sheetObj.GetCellValue(row, "rlane_grp");
        ctrt_rhq_cd = sheetObj.GetCellValue(row, "ctrt_rhq_cd");
        processRemarkHighlight(rlane_grp, ctrt_rhq_cd);
    }
}

function processRemarkHighlight(rlane_grp, ctrt_rhq_cd) {
    var adjSheetObj = sheetObjects[3];
    var selRow = 0;
    var cols = new Array('lane_grp', 'rhq_cd');
    var oriValues = new Array(rlane_grp, ctrt_rhq_cd);
    var valueCols = new Array('col_row_index', 'item_nm');
    var values = processFindValue(adjSheetObj, cols, oriValues, valueCols);
    if (values.length != 0) {
        adjSheetObj.SetCellFontColor(values[0], "remarks", "#FF0000"); // 색깔바꾸기
    }
}

function processFindValue(sheetObj, cols, oriValues, valueCol, startCol) {
    // //log("processFindValue : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+", valueCol="+valueCol+", startCol="+startCol);
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
            if (selRow < 0) {
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

function trdGrpAdjSheet_OnSearchEnd(sheetObj, errMsg) {
    var formObj = document.form;
    ComOpenWait(false);
    trdGrpAdjSheet_SearchEnd(sheetObj, formObj);
    doActionIBSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC05);
}

function trdGrpAdjSheet_OnSaveEnd(sheetObj, errMsg) {
    var formObj = document.form;
    ComOpenWait(false);
    if (sheetObj.GetEtcData("version") != "null" && sheetObj.GetEtcData("version") != undefined) {
        changeVersion();
        formObj.version.value = sheetObj.GetEtcData("version") + ":" + formObj.glineVerNo.value;
        document.form.mQtaVerNo.value = sheetObj.GetEtcData("version");
        trdGrpAdjSheet_SearchEnd(sheetObj, formObj);
    }
    if (formObj.f_cmd.value == MODIFY01) {
        tabSearchParams = ["", "", "", ""];
        doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
    } else if (formObj.f_cmd.value == MODIFY02) {
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }
    if (formObj.target_month.selectedIndex == 0) {
        //activation btng_monthly_adj in case of rep_mon == bse_mon
        ComBtnEnable("btng_monthly_adj");
    }
}

function trdGrpAdjSheet_SearchEnd(sheetObj, formObj) {
    isSheetEdited = false;
    searchSaqStsCd = sheetObj.GetEtcData("saqStsCd");
    formObj.mqtaMdlVerNo.value = sheetObj.GetEtcData("mqtaMdlVerNo");
    formObj.slsFcastPubNo.value = sheetObj.GetEtcData("slsFcastPubNo");
    formObj.inclPortFlag.value = sheetObj.GetEtcData("inclPortFlag");
    WORK_STEP_CD = "02";
    if (searchSaqStsCd == "FR") {
        WORK_STEP_CD = "04";
    }
    changeEditMode();
    reloadFilter();
    initCheckListDragPopupSingle(new Array(getConvertForPopup(sheetObj.GetEtcData("LANE_TOTAL"))), "CALCULATION", new Array("LANE_CAL"), new Array(new Array("Sub Trade", "Lane", "Select")), "100", new Array("35:35:30"), new Array(true));

    if (saveParams == "") {
        clearTabSearchParams();
        saveParams = getLocalParams();
        doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
    }
    target_month_onChange();

    controlButtons(searchSaqStsCd, formObj);
}

// ---------------------------------------------------------------------------------
function reloadFilter() {
    var data = getSingleData(sheetObjects[3], "sub_trd_cd", "ASC");
    initCheckListDragPopup(data, "SUB_TRADE", "SUB_TRADE_INPUT", "Sub Trade", "Select", "sheetName='trdGrpAdjSheet' colName='sub_trd_cd' ", true);
    data = getDoubleData(sheetObjects[3], "sub_trd_cd", "lane_grp");
    initCheckListDragPopup2(data, "LANE", "LANE_INPUT", "Sub Trade", "Lane", "Select", "sheetName='trdGrpAdjSheet' colName='lane_grp' ", true);
    data = getSingleData(sheetObjects[3], "item", "ASC");
    initCheckListDragPopup(data, "ITEM", "ITEM_INPUT", "Item", "Select", "sheetName='sheet2' colName='item' ", true);
}

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

function getDoubleData(sheetObj, firstColName, secondColName) {
    var data = "";
    var sRow = 0;
    var rRow = 0;
    var arr = new Array();
    arr[0] = sheetObj.GetCellValue(3, firstColName);
    arr[arr[0]] = new Array();
    arr[arr[0]][0] = sheetObj.GetCellValue(3, secondColName);
    var sName = "";
    var rName = "";
    for (i = 2; i < sheetObj.LastRow(); i++) {
        sName = sheetObj.GetCellValue(i, firstColName);
        rName = sheetObj.GetCellValue(i, secondColName);
        if (arr[sRow] != sName) {
            rRow = 0;
            sRow++;
            arr[sRow] = sName;
            arr[sName] = new Array();
            arr[sName][0] = rName;
        }
        if (arr[sName][rRow] != rName) {
            rRow++;
            arr[sName][rRow] = rName;
        }
    }
    for (i = 0; i < arr.length; i++) {
        if (i != 0) {
            data += "&";
        }
        data += arr[i] + ";";
        for (j = 0; j < arr[arr[i]].length; j++) {
            data += arr[arr[i]][j] + "|";
            rRow++;
        }
    }
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

function trdGrpAdjSheet_OnMouseDown(sheetObj, button, shift, x, y) {
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
                } else if (colName == "item") {
                    objName = "ITEM";
                }
                var divObj = document.getElementById("DIV__" + objName + "__DIV");
                var evtobj = window.event ? window.event : e
                var tempX = event.clientX + document.body.scrollLeft;
                var tempY = event.clientY + document.body.scrollTop;

                openDynamicDragPopup(divObj, x, evtobj.offsetY + 950, popupWidth, popupHeight, sheetObj);
                //                 openDynamicDragPopup(divObj,tempX,tempY,popupWidth,popupHeight,sheetObj);

            }
        } // end with
}

function trdGrpAdjSheet_OnUserResize(sheetObj, lWidth, lHeight) {
    dynamicPopupClose();
}

function trdGrpAdjSheet_OnScroll(sheetObj, row, col) {
    dynamicPopupClose();
}

function trdGrpAdjSheet_OnResize(sheetObj, row, col) {
    dynamicPopupClose();
}

function trdGrpAdjSheet_OnMouseMove(sheetObj, Button, Shift, X, Y) {
    var col = sheetObj.MouseCol();
    var row = sheetObj.MouseRow();
    var cursor = "Default";
    var text = "";
    if (sheetObj.ColSaveName(col) == "remarks" && sheetObj.GetCellValue(row, col) > "") {
        cursor = "Hand";
        var cols = new Array('rlane_grp', 'ctrt_rhq_cd');
        var oriValues = new Array(sheetObj.GetCellValue(row, "lane_grp"), sheetObj.GetCellValue(row, "rhq_cd"));
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

function trdGrpAdjSheet_OnDblClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "remarks" && sheetObj.GetCellValue(row, col) != "") {
        var params = "&gline_ver_no=" + formObj.glineVerNo.value + "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd") + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, "sprt_grp_cd") + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, "bsa_grp_cd") + "&ctrt_rhq_cd=" + sheetObj.GetCellValue(row, "rhq_cd") + "&bse_mon=" + formObj.target_month.value.substring(4) + "&cre_ofc_cd=" + formObj.ofcCd.value + "&saq_sts_cd=" + searchSaqStsCd;
        var width = 450;
        var height = 650;
        var callback = "callbackRemark";
        ComOpenPopupScroll("ESM_SAQ_0112.do?" + params, width, height, callback, "0,0", true);
        callbackRemark();
    } else if (sheetObj.ColSaveName(col) == "lane_grp" && sheetObj.GetCellValue(row, "bsa_grp_cd") != "") {
        var params = "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&gline_ver_no=" + formObj.glineVerNo.value + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd") + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, "sprt_grp_cd") + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, "bsa_grp_cd") + "&bse_mon=" + formObj.target_month.value.substring(4);
        var width = 550;
        var height = 390;
        var callback = "callbackRemark";
        ComOpenPopupScroll("ESM_SAQ_0116.do?" + params, width, height, callback, "0,0", true);
    }
}

function trdGrpAdjSheet_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    if (colName == "rhq") {
        var msg = processCalcLogic(sheetObj, row, col);
        if (msg != undefined && msg != "") {
            ComShowMessage(msg);
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
                // ratio of change
                apply_value = calcIncreaseRatio(GetCellValue(row, col), GetCellValue(row, baseCol));
                switch (eval(GetCellValue(row, "item_seq"))) {
                    case LOAD: // Weekly data Load
                        setCalcBaseColumn(sheetObj, row, baseCol, GetCellValue(row, col));
                        calculationOneRHQ(sheetObj, row, col, baseCol);
                        apply_value = GetCellValue(row, baseCol) / GetCellValue(row, "tot_bsa");
                        processCalcGroupChange(LOAD, sheetObj, row + 1, col, baseCol, "percent", apply_value);
                        break;
                    case GREV:
                        grs_rpb = GetCellValue(row, col) / GetCellValue(row - 1, baseCol);
                        setCalcBaseColumn(sheetObj, row + 1, baseCol, grs_rpb);
                        calculationOneRHQ(sheetObj, row - 1, col, baseCol);
                        processCalcGroupChange(GRPB, sheetObj, row + 2, col, baseCol, APPLY_MODE, apply_value);
                        break;
                    case GRPB:
                        setCalcBaseColumn(sheetObj, row, baseCol, GetCellValue(row, col));
                        calculationOneRHQ(sheetObj, row - 2, col, baseCol);
                        processCalcGroupChange(GRPB, sheetObj, row + 1, col, baseCol, APPLY_MODE, apply_value);
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

function processCalcGroupChange(ITEM, sheetObj, row, col, baseCol, APPLY_MODE, CALC_VALUE) {
    isSheetEdited = true;
    var lane_sprt_grp = sheetObj.GetCellValue(row, "lane_sprt_grp");
    var rhq_key = sheetObj.GetCellValue(row, "rhq_key");
    var move_pos = 0;
    var selRow = row;
    var load_row = 0;
    var apply_value = 0;
    var cell_value = 0;
    var cur_trade_cd = getTrd_cd();
    switch (ITEM) {
        case LOAD:
            move_pos = 0;
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
            while ((selRow = sheetObj.FindText("item_seq", "" + ITEM, selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_sprt_grp") != lane_sprt_grp) {
                    break;
                }
                if (GetCellValue(selRow, "rhq_key") != rhq_key) {
                    selRow++;
                    continue;
                }
                ////log("processCalcGroupChange] lane_sprt_grp=" + GetCellValue(selRow, "lane_sprt_grp"));
                if (ITEM == LOAD && APPLY_MODE == "amount") {
                    if (GetCellValue(selRow, 'edit_flag') == "1") {
                        cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                        apply_value = getZeroToInfinity(cell_value / GetCellValue(selRow, "tot_bsa"));
                        APPLY_MODE = "percent";
                    }
                } else if (ITEM == LOAD && APPLY_MODE == "percent") {
                    if (cur_trade_cd == "IAS" || cur_trade_cd == "EMS") {
                        cell_value = GetCellValue(row - 1, baseCol);
                    } else {
                        cell_value = GetCellValue(selRow, "tot_bsa") * apply_value;
                    }
                } else {
                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                }
                setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                // RHQ item apply
                load_row = selRow + move_pos;
                calculationOneRHQ(sheetObj, load_row, col, baseCol);
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

function calculationOneRHQ(sheetObj, row, displayCol, baseCol) {
    with(sheetObj) {
            var item_cnt = 4; // GREV item count
            var lod_qty = GetCellValue(row, baseCol);
            var grs_rpb = GetCellValue(row + 2, baseCol); //GRPB
            ////log("calculationOneRHQ] lod_qty = " + lod_qty + ", baseCol="+ColSaveName(baseCol)+", row="+row);
            if (lod_qty != 0) {
                var cm_uc_amt = GetCellValue(row, "cm_uc_amt");
                //log("calculationOneRHQ] lod_qty=" + lod_qty + " , grs_rpb=" + grs_rpb);
                SetCellValue(row + 1, baseCol, grs_rpb * lod_qty, 0); //GREV set
                SetCellValue(row + 3, baseCol, (grs_rpb - cm_uc_amt) * lod_qty, 0); //CM set
                SetCellValue(row + 4, baseCol, (grs_rpb - cm_uc_amt), 0); //CMB set
            } else {
                // setting RHQ == 0  in case of LOAD == 0
                for (var i = 0; i <= item_cnt; i++) {
                    SetCellValue(row + i, baseCol, 0, 0);
                }
            }
            SetCellValue(row, "lod_qty", lod_qty, 0);
            SetCellValue(row, "grs_rpb_rev", GetCellValue(row + 2, baseCol), 0);
            // Display
            for (var i = 0; i <= item_cnt; i++) {
                ////log("Display baseCol = " + CellValue(row+i, "item") + " value = " + CellValue(row+i,  baseCol));
                SetCellValue(row + i, displayCol, getDisplayZeroToNull(GetCellValue(row + i, baseCol)), 0);
            }
        } // end with
    if (ComIsBtnEnable("btng_monthly_adj")) {
        ComBtnDisable("btng_monthly_adj");
    }
}

function processMainGrpRoundOff(sheetObj) {
    var selRow = 1;
    var baseCol = sheetObj.SaveNameCol("edt_step_val"); // variable from calcuration
    var APPLY_MODE = "round";
    var cell_value = "";
    var col = getSelectColumnName();
    var orgCol = sheetObj.SaveNameCol("org_step_val"); // variable from db
    with(sheetObj) {
        selRow = 1;
        while (true) {
            selRow = FindText("item_seq", LOAD, selRow);
            if (selRow < 0) {
                break;
            }
            if (GetCellValue(selRow, "edit_flag") != 1) {
                selRow++;
                continue;
            }
            cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE);
            setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
            calculationOneRHQ(sheetObj, selRow, col, baseCol);
            apply_value = GetCellValue(selRow, baseCol) / GetCellValue(selRow, "tot_bsa");
            processCalcGroupChange(LOAD, sheetObj, selRow + 1, col, baseCol, "percent", apply_value);
            selRow++;
        }
    }
}

function processCalcRoundOff2(sheetObj, row, col) {
    var baseCol = sheetObj.SaveNameCol("edt_step_val"); // variable from calcuration
    var orgCol = sheetObj.SaveNameCol("org_step_val"); // variable from db
    var APPLY_MODE = "round";
    var cell_value = "";
    var selRow = row;
    var ITEM = LOAD;
    if (!document.form.edit_mode[0].checked) {
        return;
    }
    cell_value = calculationCellApplyMode(sheetObj.GetCellValue(row, baseCol), APPLY_MODE);
    setCalcBaseColumn(sheetObj, row, baseCol, cell_value);
    calculationOneRHQ(sheetObj, row, col, baseCol);
    apply_value = sheetObj.GetCellValue(row, baseCol) / sheetObj.GetCellValue(row, "tot_bsa");
    processCalcGroupChange(LOAD, sheetObj, row + 1, col, baseCol, "percent", apply_value);
    try {
        sheetObj.RenderSheet(0);
        with(sheetObj) {
                // 전체 ROW LOAD Round apply
                while ((selRow = sheetObj.FindText("item_seq", LOAD, selRow)) >= 0) {
                    if (GetCellValue(selRow, "lane_sprt_grp") != GetCellValue(row, "lane_sprt_grp")) {
                        selRow++;
                        break;
                    }
                    // apply_value apply
                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE);
                    setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                    // RHQ-KEY item apply
                    calculationOneRHQ(sheetObj, selRow, col, baseCol);
                    selRow++;
                } // end while
            } // end with
    } catch (e) {
        ComShowMessage(e.message);
    } finally {
        sheetObj.RenderSheet(1);
    }
}

function processCalcRoundOff() {
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    var ITEM = LOAD;
    var APPLY_MODE = "round";
    var startDate = new Date();
    processMainGrpRoundOff(sheetObj)
    try {
        sheetObj.RenderSheet(0);
        var baseCol = sheetObj.SaveNameCol("edt_step_val");
        // 			var lane_list=sheetObj.GetEtcData("LANE_TOTAL").split(";");
        var selCol = sheetObj.SaveNameCol(getSelectColumnName());
        var selRow = 1;
        var cell_value = 0;
        with(sheetObj) {
                while ((selRow = sheetObj.FindText("item_seq", LOAD, selRow)) >= 0) {
                    cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE);
                    setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                    calculationOneRHQ(sheetObj, selRow, selCol, baseCol);
                    selRow++;
                } // end while
            } // end with
    } catch (e) {
        ComShowMessage(e.message);
    } finally {
        sheetObj.RenderSheet(1);
    }
    var endDate = new Date();
    //log("processCalcRoundOff] =========================================================");
    //log("start Time : " + startDate);
    //log("end Time : " + endDate);
    //log("Process Time : " + (endDate.getTime() - startDate.getTime())/1000);
}

function setCalcBaseColumn(sheetObj, row, baseCol, changeValue) {
    sheetObj.SetCellValue(row, baseCol, changeValue, 0);
}

function getDisplayZeroToNull(num) {
    return (num == 0 ? "" : Math.round(num * 10) / 10);
}

function calcIncreaseRatio(newValue, oldValue) {
    if (oldValue == 0) oldValue = 1;
    var ratio = getZeroToInfinity(parseFloat(newValue) / parseFloat(oldValue));
    return (Math.round(ratio * 1000000000000) / 1000000000000);
}

function getZeroToInfinity(vl) {
    if (vl == Infinity || isNaN(vl)) {
        return 0;
    }
    return vl;
}

function processSheetPopupOK(objName, inputObjName) {
    //log("processPopupOK() call : objName=" + objName + " inputObjName=" + inputObjName);
    var divObj = eval(objName);
    var sheetObj = eval(inputObjName);
    var inputObjects = new Array();
    logObjValue(objName, inputObjName, logObj);
    inputObjects[0] = parseSheetCheckBoxStr(eval("SUB_TRADE_INPUT"));
    inputObjects[1] = parseSheetCheckBoxStr(eval("LANE_INPUT"));
    inputObjects[2] = parseSheetCheckBoxStr(eval("ITEM_INPUT"));
    processDynamicPopupHideRow(divObj, sheetObj, inputObjects);
}

/*
        inputObjects[0]=parseCheckBoxStr(eval("SUB_TRADE_INPUT"));
        inputObjects[1]=parseCheckBoxStr(eval("LANE_INPUT"));  *
        inputObjects[2]=parseCheckBoxStr(eval("ITEM_INPUT"));
 */
function processPopupOK(objName, inputObjName, html) {

    // //log("processPopupOK() call : objName=" + objName + " inputObjName=" +
    // inputObjName);
    var divObj = eval(objName);
    var inputObj = eval(inputObjName);
    var inputObjects = new Array();

    if (objName != "REMARKS") {
        inputObjects[0] = parseCheckBoxStr(eval("SUB_TRADE_INPUT"), true, " :true|");
        inputObjects[1] = parseCheckBoxStr(eval("LANE_INPUT"), true, " :true|");
        inputObjects[2] = parseCheckBoxStr(eval("ITEM_INPUT"), true, " :true|");
		
		trdGrpAdjSheet.RenderSheet(0); 
        if (inputObj.length != undefined) {
            for (var i = 0; i < inputObj.length; i++) {
                processHideRow(divObj, inputObj[i], inputObjects);
            }
        } else {
            processHideRow(divObj, inputObj, inputObjects);
        }
        trdGrpAdjSheet.SetDataMerge();  
    	trdGrpAdjSheet.RenderSheet(1);  
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

/**
 * Row의 활성화/비활성화 작업을 진행함
 * 
 * @param sheetObj
 * @param cols
 * @param oriValues
 * @param inputObjects
 * @param isDisplay
 * @returns {Number}
 */
function processFilterSheet(sheetObj, cols, oriValues, inputObjects, isDisplay) {
    //log("processFilterSheet : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+",inputObjects="+inputObjects+", isDisplay="+isDisplay);
    //log("processFilterSheet : cols.length=" + cols.length);
    var filterCnt = 0;
    //     sheetObj.ReDraw=false;
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
    //     for(var i=0 ; i <= sheetObj.LastRow(); i++){
    //         flg=false;
    //         for(var j=0 ; j < cols.length ; j++ ){
    //             selRow=sheetObj.FindText(cols[j],oriValues[j],selRow);
    //             if( selRow < 0 ){//찾는 값이 없다..
    //                 break;
    //             }
    //         }
    //         if( selRow >= 0  ){
    //             i=selRow;
    //             selRow++;
    //             for(var j=0 ; j < cols.length ; j++ ){
    //            	 if(oriValues[j] != sheetObj.GetCellValue(i,cols[(j)])  ){
    //                     flg=true;
    //                     break;
    //                 }
    //             }
    //             if(flg == false  ){
    //                 if( isDisplay == true){
    //                     if( filterValidation(sheetObj,i,cols,inputObjects) ){
    //                         sheetObj.SetRowHidden(i,!isDisplay);
    //                     }
    //                 }else{
    //                    sheetObj.SetRowHidden(i,!isDisplay);
    //                 }
    //             }
    //         }else{
    //             sheetObj.SetRowHidden(i,!isDisplay);
    //             break;
    //         }
    //     }
    //    sheetObj.ReDraw=true;
    return filterCnt;
}

function filterValidation(sheetObj, row, cols, inputObjects) {
    var retValue = false;
    if (cols[0] == "sub_trd_cd") {
        if (inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0) {
            retValue = true;
        }
    } else if (cols[0] == "lane_grp") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0) {
            retValue = true;
        }
    } else if (cols[0] == "item") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0) {
            retValue = true;
        }
    }
    return retValue;
}

function processCalcApply() {
    var calcObj = document.form.calc_value;
    if (isNaN(calcObj.value)) {
        ComShowCodeMessage("COM12122", "Input value of the Apply");
        calcObj.focus();
        return;
    }
    var obj = document.getElementById("DIV__CALCULATION__DIV");
    //     var pObj=document.getElementsByName("btng_apply")[0];
    if (obj != null) {
        var evtobj = window.event ? window.event : e
        var tempX = event.clientX + document.body.scrollLeft;
        var tempY = event.clientY + document.body.scrollTop;
        //         openDynamicDragPopup(obj,tempX-300,tempY,300,400,sheetObjects[3]);
        openDynamicDragPopup(obj, tempX - 400, evtobj.offsetY + 850, 410, 300, sheetObjects[3]);
    }
}

/*
 * all check event
 */
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

function processCalcPopupOK(objName) {
    var divObj = document.getElementById(objName);
    //var inputObjects=parseSheetCheckBoxStr(eval("LANE_CAL"),false);
    var inputObjects = parseCheckBoxStr(eval("LANE_CAL"), false, " :true|");
    if (inputObjects == "") {
        ComShowCodeMessage("COM12113", "Lane");
        return;
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    var editModeObj = formObj.edit_mode;
    var ITEM = 0;
    var APPLY_MODE = "";
    var CALC_VALUE = eval(formObj.calc_value.value); // 변경값
    var NEW_ITEM = 0;
    var NEW_APPLY_MODE = "";
    var NEW_CALC_VALUE = "";
    var baseCol = sheetObj.SaveNameCol("edt_step_val");
    var selCol = sheetObj.SaveNameCol(getSelectColumnName());
    var selRow = 1;
    var grs_rpb = 0;
    var grs_rev = 0;
    try {
        sheetObj.RenderSheet(0);
        var arrLANE_TOTAL = inputObjects.split(":true|");
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
        with(sheetObj) {
            for (var i = 0; i < arrLANE_TOTAL.length; i++) {
                NEW_ITEM = ITEM;
                NEW_APPLY_MODE = APPLY_MODE;
                NEW_CALC_VALUE = CALC_VALUE;
                selRow = sheetObj.FindText("lane_sprt_grp", arrLANE_TOTAL[i], selRow);
                if (selRow == -1) {
                    continue;
                }
                while ((selRow = sheetObj.FindText("item_seq", "" + ITEM, selRow)) >= 0) {
                    if (arrLANE_TOTAL[i] == GetCellValue(selRow, "lane_sprt_grp") && GetCellValue(selRow, "edit_flag") == "1") {
                        if (ITEM == GREV) {
                            //ratio of change for GREV.
                            grs_rev = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, CALC_VALUE);
                            // setting GRPB
                            NEW_CALC_VALUE = calcIncreaseRatio(grs_rev, GetCellValue(selRow, baseCol));
                            NEW_APPLY_MODE = "percent";
                            NEW_ITEM = GRPB;
                        }
                        // LANE Group Change call
                        processCalcGroupChange(NEW_ITEM, sheetObj, selRow, selCol, baseCol, NEW_APPLY_MODE, NEW_CALC_VALUE);
                    }
                    selRow++;
                }
                selRow = 1;
            }
        }
        processCalcRoundOff();
    } catch (e) {
        ComShowMessage(e.message);
    } finally {
        sheetObj.RenderSheet(1);
    }
}

function openMonthlyAdj() {
    var formObj = document.form;
    //formObj.f_cmd.value = SEARCHLIST;
    var params = "gline_ver_no=" + formObj.glineVerNo.value + "&mqta_step_cd=" + WORK_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&trdCd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&unit=" + getParam(saveParams, "unit");
    var width = 850;
    var height = 500;
    //log("openMonthlyAdj] Popup prams=" + params);
    var callback = "callbackRemark";
    ComOpenPopupScroll("ESM_SAQ_0148.do?" + params, width, height, callback, "0,0", true);
}

function clearTabSearchParams() {
    for (var i = 0; i < tabSearchParams.length; i++) {
        tabSearchParams[i] = "";
    }
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