﻿
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_0048.js
*@FileTitle  : Monthly Quota Adjustment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_SAQ_0048 : business script for ESM_SAQ_0048
 */
var initSelect = 1;
var logObj = new Array("SUB_TRADE_INPUT", "LANE_INPUT", "RHQ_INPUT", "ITEM_INPUT");
logObj["SUB_TRADE"] = new Array("false");
logObj["LANE"] = new Array("false");
logObj["RHQ"] = new Array("false");
logObj["ITEM"] = new Array("true");
var sheetObjects = new Array();
var sheetCnt = 0;
var tabObjects = new Array();
var tabCnt = 0;
var currentTabIndex = 0;
var comObjects = new Array();
var comboCnt = 0;
var isZeroLoad = "TRUE";
var perfIFdate = "";
var tabSearchParams = ["-1", "", "", ""];
var monthNames = new Array();
var monthNumbers = new Array();
var MQTA_STEP_CD = "01";
var WORK_STEP_CD = "01";
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
var LOAD_TOTAL = 15;
var saveParams = "";
var ICO_UNCHECK_IDX = 1;
var ICO_CHECK_IDX = 2;
var ICO_FILTER_IDX = 3;
var FILTER_TEXT = "";
var btn_name = ""; //DownExcel에서 사용하기 위해서
var msgArr = new Array();
var lane_ttl = "";
var rhq = "";

// Event handler processing by button click event */    
document.onclick = processButtonClick;

// Event handler processing by button name */
function processButtonClick() {
    var sheetObject = sheetObjects[currentTabIndex];
    var formObject = document.form;
    try {
        var srcName = ComGetEvent("name");
        var srcObj = ComGetEvent();
        btn_name = srcName;
        if (ComGetBtnDisable(srcName)) return false;

        formObject.f_cmd.value = getCommandByStep(srcName);
        switch (srcName) {
            case "help": // Version()Help
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
            case "btn_retrieve2":
                doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC03);
                break;
            case "btn_new":
                sheetObjects[0].RemoveAll();
                sheetObjects[1].RemoveAll();
                sheetObjects[2].RemoveAll();
                sheetObjects[3].RemoveAll();
                formObject.reset();
                // button control
                controlButtons("", document.form);
                setYearMonthObject(formObject.year, formObject.bse_quarter);
                var rtn = getCodeList("SaqMonthlyQuotaPerfIFDate", "ofcCd=" + document.form.ofcCd.value);
                perfIFdate = "( Last Update : " + rtn[0].substring(0, 16) + " )";
                // Target Group setting
                var tgtObj = trade_group;
                tgtObj.SetSelectIndex(0);
                changePfmcFromTo(); /* PFMC Date setting */
                target_month_init(true); /* Month setting */
                changeVersion(); /* Versionsetting */
                break;
            case "btn_save": // save
            case "btn_save1": // save
                if (!ComIsBtnEnable("btn_save")) return;
                formObject.f_cmd.value = getCommandByStep(srcName);
                formObject.mQtaStepCd.value = WORK_STEP_CD;

                if (formObject.f_cmd.value == MODIFY01 || formObject.f_cmd.value == MODIFY03) {
                    validateSave(sheetObjects[3]);
                    //    						var rtn = validateSave(sheetObjects[3]);
                    //							if(rtn == true){
                    //								formObject.f_cmd.value = MODIFY01;
                    //								doActionIBSheet(sheetObjects[3],formObject,IBSAVE);
                    //							}
                    //    					}else if(formObject.f_cmd.value == MODIFY03){
                    //    						validateSave(sheetObjects[3]);
                    //    						var rtn = validateSave(sheetObjects[3]);
                    //							if(rtn == true){
                    //								formObject.f_cmd.value = MODIFY03;
                    //								doActionIBSheet(sheetObjects[3],formObject,IBSAVE);
                    //							}
                }
                break;
            case "btn_saveasnew": // New Version()save
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
                    formObject.mQtaStepCd.value = MQTA_STEP_CD;
                    if (isSheetEdited) {
                        // If there is modified data to Trade Sheet
                        if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                            return;
                        }
                    }
                    if (formObject.f_cmd.value == MODIFY06) {
                        validateConfirmCheck(sheetObjects[3], formObject);
                        //    							var rtn = validateConfirmCheck(sheetObjects[3], formObject);
                        //    							if(rtn == true){
                        //    								formObject.f_cmd.value = MODIFY06;
                        //    								doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
                        //    							}
                    } else if (formObject.f_cmd.value == MODIFY08) {
                        validateConfirmMonthCheck(sheetObjects[3], formObject);
                        //    							var rtn = validateConfirmMonthCheck(sheetObjects[3],formObject);
                        //    							if(rtn == true){
                        //    								formObject.f_cmd.value = MODIFY08;
                        //    								doActionIBSheet(sheetObjects[3],formObject,IBSEARCH_ASYNC01);
                        //    							}
                    }
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
                if (WORK_STEP_CD == '01') {
                    flag = ComShowConfirm(getMsg("SAQ90139", "Notify"));
                    if (flag) {
                        doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                    }
                } else {
                    trdGrpAdjSheet_FinalConfirm(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btn_cancelnotification":
                if (!ComIsBtnEnable("btn_cancelnotification")) return;
                flag = ComShowConfirm(getMsg("SAQ90139", "Cancel Notification"));
                if (flag) {
                    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
                }
                break;
            case "btng_downexcel":
                doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
                break;
            case "btng_adj_downexcel":
                doActionIBSheet(sheetObjects[3], formObject, IBDOWNEXCEL);
                break;
            case "btng_monthly_adj":
                if (!ComIsBtnEnable("btng_monthly_adj")) return;
                openMonthlyAdj();
                break;
            case "edit_mode": //Edit Mode click
            case "calc1": //Edit Mode L/F click
                if (!ComIsBtnEnable("btng_apply")) return;
                changeEditMode();
                break;
            case "btng_apply":
                if (!ComIsBtnEnable("btng_apply")) return;
                processCalcApply();
                break;
            case "btng_showcheck":
                if (!ComIsBtnEnable("btng_showcheck")) return;
                changeCheckHidden(1);
                break;
            case "btng_hidecheck":
                if (!ComIsBtnEnable("btng_hidecheck")) return;
                changeCheckHidden(0);
                break;
            case "btng_setfinal":
                if (!ComIsBtnEnable("btng_setfinal")) return;
                processSetFinal();
                break;
            case "btng_excelimportexport": // excel upload
                excelimportexport();
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
    var formObj = document.form;

    optionSetting();
    target_month_init(true);

    // button control
    controlButtons("", document.form);

    // year month 초기값 setting (최종 확정 월 +1 개월)
    setYearMonthObject(formObj.year, formObj.bse_quarter);

    var objs = document.all.item("tabLayer");
    var rtn = getCodeList("SaqMonthlyQuotaPerfIFDate", "ofcCd=" + document.form.ofcCd.value);
    perfIFdate = "( Last Update : " + rtn[0].substring(0, 16) + " )";
    for (var i = 0; i < sheetObjects.length; i++) {

        ComConfigSheet(sheetObjects[i]);
        if (i < 3) {
            objs[i].style.display = "Inline";
        }
        initSheet(sheetObjects[i], i + 1, "INIT");
        if (i < 3) {
            objs[i].style.display = "none";
        }
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (var k = 0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
        tabObjects[k].SetSelectedIndex(0);
    }

    // Target Group setting
    var tgtObj = trade_group;
    tgtObj.SetSelectIndex(0);
    // PFMC date setting
    changePfmcFromTo();

    if (isDevMode) {
        formObj.ofcCd.readOnly = false;
        sheetObjects[3].SetColHidden("edt_step_val", 0);
        sheetObjects[3].SetColHidden("tot_bsa", 0);

    }

    document.form.year.focus();
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
			with (sheetObj) {
        		changeHeadTitle(sheetObj,pInit);
                SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:3, DataRowMerge:0 , PrevColumnMergeMode:0} );

                var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  	KeyField:0,   CalcLogic:"",   Format:"#,##0.#####", UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  	KeyField:0,   CalcLogic:"",   Format:"#,##0.#####", UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",  	KeyField:0,   CalcLogic:"",   Format:"#,##0.#####", UpdateEdit:1,   InsertEdit:1 } ];
                for (var i=0; i<4; i++) {
                    cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",       UpdateEdit:1,   InsertEdit:1 });
                    cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"#,##0.#####",     UpdateEdit:1,   InsertEdit:1 });
                    cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"#,##0.#####",     UpdateEdit:1,   InsertEdit:1 });
                    cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"#,##0.#####",     UpdateEdit:1,   InsertEdit:1 });
                    cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"#,##0.#####",     UpdateEdit:1,   InsertEdit:1 });
                    cols.push({Type:"Float",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"#,##0.#####",     UpdateEdit:1,   InsertEdit:1 });
                }

                InitColumns(cols);

                SetEditable(0);
                SetWaitImageVisible(0);
                SetSheetHeight(ComGetSheetHeight(sheetObj, 18));

				//SetRangeBackColor(1, 2, 1, 36,"#777777");
            }
			break;
		case 3:      //RHQ Lane Sheet init
			with (sheetObj) {
			changeHeadTitle(sheetObj,pInit);
			SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:5, DataRowMerge:0, PrevColumnMergeMode:0 } );

			var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
			var headers = [ ];

			InitHeaders(headers, info);
	        var cols = [ {Type:"Text",      Hidden:1,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tree",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1}, //, TreeCol:1 
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhqCd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"subTrd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ImgWidth:10, ImgHeight:10},
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , ImgWidth:10, ImgHeight:10},
	                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        for (var i=0; i<4; i++) {
    		  cols.push({ Type:"Text",      Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    		  cols.push({ Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    		  cols.push({ Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    		  cols.push({ Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    		  cols.push({ Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
    		  cols.push({ Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	        }

	        InitColumns(cols);
	        SetEditable(0);
	        SetWaitImageVisible(0);
	        SetSheetHeight(ComGetSheetHeight(sheetObj, 18));
			//SetRangeBackColor(1, 2, 1, 38,"#777777");

	        /* setting image(s) */
			//SetCellImage(0, "subTrd",0);
			//SetCellImage(0, "lane",0);

			//ShowTreeLevel(0);

		   }
			break;
		case 4:      //trdGrpAdjSheet
            with (sheetObj) {
				target_month_init();
				trdGrpAdjSheet_changeHeadTitle(sheetObj,pInit);
				SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:4, DataRowMerge:0, PrevColumnMergeMode:0 } );


				var cols = [ {Type:"Text",      Hidden:0,                   Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ImgWidth:10, ImgHeight:10},
				             {Type:"Text",      Hidden:0,                   Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_grp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  , ImgWidth:10, ImgHeight:10},
				             {Type:"Text",      Hidden:0,                   Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  , ImgWidth:10, ImgHeight:10},
				             {Type:"Text",      Hidden:0,                   Width:70,   Align:"Center",  ColMerge:1,   SaveName:"item",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0  , ImgWidth:10, ImgHeight:10},
				             {Type:"Float",     Hidden:0,                   Width:85,   Align:"Right",   ColMerge:0,   SaveName:"monthly",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,                   Width:70,   Align:"Right",   ColMerge:0,   SaveName:"fcast",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,                   Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mdl_rslt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,                   Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk_trd_grp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ImgWidth:10, ImgHeight:10 },
				             {Type:"Float",     Hidden:0,                   Width:70,   Align:"Right",   ColMerge:0,   SaveName:"trd_grp",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0  },
				             {Type:"Text",      Hidden:1,                   Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk_rhq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 , ImgWidth:10, ImgHeight:10 },
				             {Type:"Float",     Hidden:0,                   Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rhq",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0  },
				             {Type:"Float",     Hidden:0,                   Width:70,   Align:"Right",   ColMerge:0,   SaveName:"final",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0  },
				             {Type:"Float",     Hidden:0,                   Width:70,   Align:"Right",   ColMerge:0,   SaveName:"adjusted",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,                   Width:110,  Align:"Center",  ColMerge:1,   SaveName:"remarks",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:(isDevMode? 0 : 1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:(isDevMode? 0 : 1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"sprt_grp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:(isDevMode? 0 : 1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa_grp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:(isDevMode? 0 : 1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"item_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:(isDevMode? 0 : 1),  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"edit_grp",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"edt_step_val",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"org_step_val",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"org_trd",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"org_rhq",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"grs_rpb_rev",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cm_uc_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"opfit_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ra_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ra_opfit_uc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"tot_bsa",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"low_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:13,  UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:(isDevMode? 0 : 1),  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lane_sprt_grp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:(isDevMode? 0 : 1),  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				InitColumns(cols);
				SetEditable(1);

				SetImageList(1,ICO_UNCHECK);
				SetImageList(2,ICO_CHECK);
				SetImageList(3,ICO_FILTER);

				SetCellImage(0, "sub_trd_cd",3);
				SetCellImage(0, "lane_grp",3);
				SetCellImage(0, "rhq_cd",3);
				SetCellImage(0, "item",3);

				SetCellImage(1, "chk_rhq",1);
				SetCellImage(1, "chk_trd_grp",1);

				//SetRangeBackColor(1, 3, 1, 30,"#777777"); //#DEFBF8

				SetWaitImageVisible(0);
				SetSheetHeight(ComGetSheetHeight(sheetObj, 18));
			}
            break;
		case 5:      //rmkSheet
			with (sheetObj) {
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
        HeadTitle = "Tree|Regional\nGroup|Sub \nTrade|Lane|Item|" + "Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|" + "Recent Quota\n(" + before_year + "." + monthNumbers[monIdx] + ")|";
        HeadTitle1 = "Tree|Regional\nGroup|Sub \nTrade|Lane|Item|Quota|Est.\nPFMC|+/-|%|Quarterly|";
    } else {
        var keyHead = (sheetObj.id == "t1sheet1" ? "Trade|Bound|Item|" : "Sub \nTrade|Bound|Item|");
        HeadTitle = keyHead + "Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|Performance\n" + perfIFdate + "|" + "Recent Quota\n(" + before_year + "." + monthNumbers[monIdx] + ")|";
        HeadTitle1 = keyHead + "Quota|Est.\nPFMC|+/-|%|Quarterly|";
    }
    for (var j = 0; j < 6; j++) {
        HeadTitle = HeadTitle + year + " " + document.form.bse_quarter.value + " Total|";
    }
    for (i = 0; i < 3; i++) {
        for (var j = 0; j < 6; j++) {
            HeadTitle = HeadTitle + year + "." + monthNumbers[monIdx + 1] + "|";
        }
        if (monIdx == 11) {
            year = year + 1;
        }
        monIdx++;
    }
    // HeadTitle1 setting
    for (i = 0; i < 4; i++) {
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
    // Sheet Unit Setting
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

    var hiddenTitle = "rlane_cd|sprt_grp_cd|bsa_grp_cd|item_seq|ibflag|edit_grp|edt_step_val|org_step_val|org_trd|org_rhq|lod_qty|grs_rpb_rev|cm_uc_amt|opfit_uc_amt|ra_cm_uc_amt|ra_opfit_uc_amt|tot_bsa|low_qty|lane_sprt_grp|";
    var HeadTitle = "Sub\nTrade" + FILTER_TEXT + "|Lane" + FILTER_TEXT + "|Regional\nGroup" + FILTER_TEXT + "|Item" + FILTER_TEXT + "|";
    var HeadTitle1 = HeadTitle;
    // HeadTitle setting
    HeadTitle = HeadTitle + "Recent Quota\n(" + before_year + "." + before_month + ")|";
    for (var j = 0; j < 8; j++) {
        HeadTitle = HeadTitle + year + "." + month + "|";
    }
    HeadTitle = HeadTitle + "Remarks|";
    HeadTitle1 = HeadTitle1 + "Quarterly|" + "Model\nResult|Guideline||Trade\nGroup||Regional\nGroup|Final|Final\nAdjusted|Remarks|";

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
    // Sheet Unit Setting
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
    var rtn = getCodeList("CommonCode", "codeNo=CD01915"); //month "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec","Jan","Feb"
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
    rtn = getCodeList("CommonCode", "codeNo=CD20011"); //month "12","01","02","03","04","05","06","07","08","09","10","11","12","01","02"
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

// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    switch (sAction) {
        case IBSEARCH_ASYNC02: // Tab search
            if (formObj.mqtaMdlVerNo.value != "" && (tabSearchParams[currentTabIndex] != getTabLocalParams())) {
                if (currentTabIndex == 0) {
                    // Target Group/Trade search
                    formObj.f_cmd.value = SEARCHLIST02;
                } else if (currentTabIndex == 1) {
                    // Sub-Trade search;
                    formObj.f_cmd.value = SEARCHLIST03;
                } else if (currentTabIndex == 2) {
                    // RHQ/Lane search
                    formObj.f_cmd.value = SEARCHLIST04;
                }
                if (validateForm(sheetObj, formObj, sAction) == false) {
                    break;
                }
                ComOpenWait(true);
                changeHeadTitle(sheetObj, "");
                tabSearchParams[currentTabIndex] = getTabLocalParams();
                var params = "f_cmd=" + formObj.f_cmd.value + tabSearchParams[currentTabIndex];
                // retrieve
                //     				    sheetObj.DoSearch("ESM_SAQ_0048GS2.do", params );
                var sXml = sheetObj.GetSearchData("ESM_SAQ_0048GS2.do", params);
                if (sXml != "") sheetObj.LoadSearchData(sXml, {
                    sync: 1
                });
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
            // trdGrpAdjSheet retrieve
            if (validateForm(sheetObj, formObj, sAction) == false) {
                break;
            }
            ComOpenWait(true);
            saveParams = "";
            target_month_init(true);
            sub_trd_cd_init();
            trdGrpAdjSheet_changeHeadTitle(sheetObj, "");
            var version = formObj.version.value.split(":");
            if (version.length == 2) {
                document.form.mQtaVerNo.value = version[0];
                document.form.glineVerNo.value = version[1];
            }
            var param = saqFormString(formObj);
            var sXml = sheetObj.GetSearchData("ESM_SAQ_0048GS1.do", param);
            if (sXml != "") sheetObj.LoadSearchData(sXml, {
                sync: 1
            });
            //sheetObjects[3].DoSearch("ESM_SAQ_0048GS1.do",param  );
            ComOpenWait(false);
            break;
        case IBSEARCH_ASYNC03: //retrieve
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
            saveParams = replaceParams(saveParams, "mQtaStepCd", formObj.mQtaStepCd.value);
            saveParams = replaceParams(saveParams, "search_sub_trd_cd", formObj.search_sub_trd_cd.value);
            saveParams = replaceParams(saveParams, "search_rlane_cd", formObj.search_rlane_cd.value);
            var tmpP = saveParams;
            sheetObjects[3].DoSearch("ESM_SAQ_0048GS1.do", tmpP);
            ComOpenWait(false);
            break;
        case IBSAVE: //save
            // MODIFY01, MODIFY03 : Save
            // MODIFY02 : Save As New Version
            formObj.mQtaStepCd.value = WORK_STEP_CD;
            ComOpenWait(true);
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            saveParams = replaceParams(saveParams, "mQtaStepCd", formObj.mQtaStepCd.value);
            //    				sheetObj.DoSave("ESM_SAQ_0048GS1.do", saveParams, "ibflag", false);
            var sParam = sheetObj.GetSaveString(0, 1, "ibflag");
            var sXml = sheetObj.GetSaveData("ESM_SAQ_0048GS1.do", sParam + "&" + saveParams);
            sheetObj.LoadSaveData(sXml, {
                Sync: 1
            });


            ComOpenWait(false);
            isSheetEdited = false;
            if (WORK_STEP_CD == '01' || WORK_STEP_CD == '03') {
                // Tab retrieve
                tabSearchParams = ["", "", "", ""];
                doActionIBSheet(sheetObjects[currentTabIndex], formObj, IBSEARCH_ASYNC02);
            }
            break;
        case IBSEARCH_ASYNC01: // Cancel Current Version()~ Confirm Draft
            // MODIFY04, MODIFY05 : Cancel Current Version
            // MODIFY06, MODIFY08 : Confirm Draft
            // MODIFY07, MODIFY09 : Cancel Confirmation
            // MODIFY10, MODIFY12 : Notify Draft
            // MODIFY11, MODIFY13 : Cancel Notification
            formObj.mQtaStepCd.value = MQTA_STEP_CD;
            if (isSheetEdited) {
                // If there is modified data to Trade Sheet
                if (ComShowConfirm(getMsg("SAQ90001")) != 1) {
                    return;
                }
            }
            ComOpenWait(true);
            saveParams = replaceParams(saveParams, "f_cmd", formObj.f_cmd.value);
            saveParams = replaceParams(saveParams, "mQtaStepCd", formObj.mQtaStepCd.value);
            saveParams = getLocalParams();
            //sheetObj.DoSave("ESM_SAQ_0048GS1.do", saveParams, "ibflag", false);
            var sParam = sheetObj.GetSaveString(0, 1, "ibflag");            
            var sXml = sheetObj.GetSaveData("ESM_SAQ_0048GS1.do", sParam + "&" + saveParams);
            sheetObj.LoadSaveData(sXml, { Sync: 1 });
            ComOpenWait(false);
            
            if (sheetObj.GetEtcData("saqStsCd") != "null" && sheetObj.GetEtcData("saqStsCd") != undefined) {
                var cur_version = formObj.version.value;
                changeVersion();
                formObj.version.value = cur_version;
                // 버튼 처리
                searchSaqStsCd = sheetObj.GetEtcData("saqStsCd");
                controlButtons(searchSaqStsCd, formObj);
                changeEditMode();
            }
            
            isSheetEdited = false;
            
            if (formObj.f_cmd.value == MODIFY08 || formObj.f_cmd.value == MODIFY09) {
                tabSearchParams = ["", "", "", ""];
                doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
            }
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

    if (btn_name == "btng_downexcel") {
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
                InsertItem("  Regional Group/Lane  ", "");
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
    var beforetab = currentTabIndex;
    for (i = 0; i < 3; i++) {
        objs[i].style.display = "none";
    }
    objs[nItem].style.display = "Inline";
    //--------------- important --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex - 1;
    //------------------------------------------------------//
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
                    break;
            } // end switch
        } // end with
    return true;
}

// Check before saving message...
function validateSave(sheetObj) {
    var msgLane = "";
    var msgError = new Array("", "", "");
    var showMsgError = new Array();
    var idx = 0;
    var selRow = 0;
    var work_col = getSelectColumnName();
    var formObj = document.form;
    with(sheetObj) {
            while ((selRow = FindText("item_seq", "" + LOAD, selRow)) > -1) {
                if (GetCellValue(selRow, "lane_grp").toUpperCase() == "TOTAL" || GetCellValue(selRow, "edit_grp") != "1") {
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
            // Lane Checking  in case of L/F > 100%
            msgLane = "";
            while ((selRow = FindText("item_seq", "" + LF, selRow)) > -1) {
                if (GetCellValue(selRow, work_col) > 100 && msgLane.indexOf(GetCellValue(selRow, "lane_sprt_grp")) < 0) {
                    msgLane = msgLane + "- " + GetCellValue(selRow, "lane_sprt_grp") + " \n";
                }
                selRow++;
            } // end while
            if (msgLane != "") {
                msgArr = new Array();
                var tmpArr = "";
                var idx = 0;
                if (msgLane.constructor == String) {
                    msgArr = getStringToArray(msgLane, 1024);
                } else {
                    idx = 0;
                    for (var msgIdx = 0; msgIdx < msgLane.length; msgIdx++) {
                        tmpArr = getStringToArray(msgLane[msgIdx], 1024);
                        for (var i = 0; i < tmpArr.length; i++) {
                            msgArr[idx] = tmpArr[i];
                            idx++;
                        }
                        msgArr[idx] = "\r\n\r\n";
                        idx++;
                    }
                }
                msgArr = getMsg("SAQ90131", msgArr);
                ComOpenPopupScroll("ESM_SAQ_MSG.do?windowType=" + 1 + "&fontColor=" + "black" + "&fontWeight=&btnFlg=" + true, "500", "340", "validateSavePopUp", "1,0", true);
                //                   	return showMsgWindow(getMsg("SAQ90131", msgLane), "1");
            } else {
                //                	return true;
                if (formObj.f_cmd.value == MODIFY01 || formObj.f_cmd.value == MODIFY03) {
                    doActionIBSheet(sheetObj, formObj, IBSAVE);
                }
            }
        } // end with
}

// MODIFY06 : Checking Load 0  in Confirm Draft
function validateConfirmCheck(sheetObj, formObj) {
    if (sheetObjects[3].RowCount("R") == 0) {
        return false;
    }
    var params = replaceParams(saveParams, "f_cmd", MODIFY14);
    params = params.replace("mQtaStepCd=" + MQTA_STEP_CD, "mQtaStepCd=" + WORK_STEP_CD);
    saveParams = replaceParams(saveParams, "f_cmd", MODIFY14);
    saveParams = replaceParams(saveParams, "mQtaStepCd", WORK_STEP_CD);
    //    	    sheetObj.DoSave("ESM_SAQ_0048GS1.do", saveParams, "ibflag", false);

    var sParam = sheetObj.GetSaveString(0, 1, "ibflag");
    var sXml = sheetObj.GetSaveData("ESM_SAQ_0048GS1.do", sParam + "&" + saveParams);
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
        //    	    	return showMsgWindow(getMsg("SAQ90149", msgList), "1");
    } else {
        //    			return true;
        formObj.f_cmd.value = MODIFY06;
        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    }
}

// MODIFY08 : Checking Load 0  in Confirm Draft
function validateConfirmMonthCheck(sheetObj, formObj) {
    saveParams = replaceParams(saveParams, "f_cmd", MODIFY15);
    saveParams = replaceParams(saveParams, "mQtaStepCd", WORK_STEP_CD);
    //    	    sheetObj.DoSave("ESM_SAQ_0048GS1.do", saveParams, "ibflag", false);

    var sParam = sheetObj.GetSaveString(0, 1, "ibflag");
    var sXml = sheetObj.GetSaveData("ESM_SAQ_0048GS1.do", sParam + "&" + saveParams);
    sheetObj.LoadSaveData(sXml, {
        Sync: 1
    });
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
        msgArr = getMsg("SAQ90151", msgArr);
        ComOpenPopupScroll("ESM_SAQ_MSG.do?windowType=" + 1 + "&fontColor=" + "blue" + "&fontWeight=" + "bold" + "&btnFlg=" + true, "500", "340", "validateConfirmMonthCheckPopUp", "1,0", true);
        //               	return showMsgWindow(getMsg("SAQ90151", msgList), "1","500","340","blue","bold");
    } else {
        //    	    	return true;
        formObj.f_cmd.value = MODIFY08;
        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    }
}

function validateConfirmMonthCheckPopUp(rtnVal) {
    var sheetObj = sheetObjects[3];
    var formObj = document.form;
    if (rtnVal == true) {
        validateConfirmCheck(sheetObj, formObj)
    } else {
        return false;
    }
}

function validateConfirmCheckPopUp(rtnVal) {    
    var sheetObj = sheetObjects[3];
    var formObj = document.form;
    if (rtnVal == true) {
    	formObj.f_cmd.value = MODIFY06;
        doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC01);
    } else {
        return false;
    }
}

function validateSavePopUp(rtnVal) {
    var sheetObj = sheetObjects[3];
    var formObj = document.form;
    if (rtnVal == true) {
        doActionIBSheet(sheetObj, formObj, IBSAVE);
    } else {
        return false;
    }
}

function controlButtons(stsCd, formObj) {
    ComBtnDisable("btn_saveasnew");
    ComBtnDisable("btng_monthly_adj");
    ComBtnDisable("btng_apply");
    ComBtnDisable("btng_showcheck");
    ComBtnDisable("btng_hidecheck");
    ComBtnDisable("btng_setfinal");
    ComBtnDisable("btn_cancelcurrent");
    ComBtnDisable("btng_excelimportexport");
    switch (stsCd) {
        case "DR": // STEP 03 Init
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_save1");
            ComBtnEnable("btng_showcheck");
            ComBtnEnable("btng_hidecheck");
            ComBtnEnable("btng_setfinal");
            ComBtnEnable("btn_confirmdraft");
            ComBtnEnable("btng_apply");
            ComBtnEnable("btng_excelimportexport");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            if (formObj.target_month.selectedIndex == 0) {
                ComBtnEnable("btng_monthly_adj");
            }
            break;
        case "00": // Init
            ComBtnEnable("btn_save");
            ComBtnEnable("btn_save1");
            ComBtnEnable("btn_cancelcurrent");
            ComBtnEnable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            ComBtnEnable("btng_apply");
            ComBtnEnable("btn_saveasnew");
            ComBtnEnable("btng_excelimportexport");
            if (formObj.target_month.selectedIndex == 0) {
                ComBtnEnable("btng_monthly_adj");
            }
            break;
        case "DC": // Confirm Draft
        case "FC": // Final Confirm
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btn_confirmdraft");
            ComBtnEnable("btn_cancelconfirmation");
            ComBtnEnable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            break;
        case "DN": // Notify Draft
        case "FN": // Final Notify
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnEnable("btn_cancelnotification");
            break;
        default: // Init && "XX" Cancel Current Version()
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_save1");
            ComBtnDisable("btn_confirmdraft");
            ComBtnDisable("btn_cancelconfirmation");
            ComBtnDisable("btn_notifydraft");
            ComBtnDisable("btn_cancelnotification");
            break;
    }
    if (sheetObjects[3].RowCount("R") == 0) {
        ComBtnDisable("btng_monthly_adj");
    }
}

function changeCheckHidden(flag) {

    if (flag == true) {
        // 컬럼을 Hidden 시킴
        sheetObjects[3].SetColHidden("chk_rhq", flag);
        sheetObjects[3].SetColHidden("chk_trd_grp", flag);
        ComBtnDisable("btng_setfinal");
    } else {
        // Hidden된 컬럼을 보이게 함
        sheetObjects[3].SetColHidden("chk_rhq", flag);
        sheetObjects[3].SetColHidden("chk_trd_grp", flag);
        var findRow = 0;
        if (sheetObjects[3].RowCount() > 0) {
            while (findRow != -1) {
                findRow = sheetObjects[3].FindText("item", "Volume", findRow + 1);
                if (sheetObjects[3].GetCellValue(findRow, "rhq_cd") != "TOTAL") {
                    sheetObjects[3].InitCellProperty(findRow, "chk_rhq", {
                        Type: "CheckBox"
                    });
                    sheetObjects[3].InitCellProperty(findRow, "chk_trd_grp", {
                        Type: "CheckBox"
                    });
                    sheetObjects[3].InitCellProperty(findRow + 1, "chk_rhq", {
                        Type: "CheckBox"
                    });
                    sheetObjects[3].InitCellProperty(findRow + 1, "chk_trd_grp", {
                        Type: "CheckBox"
                    });
                }
            }
        }
        ComBtnEnable("btng_setfinal");
    }
}

function getCommandByStep(srcName) {
    switch (srcName) {
        case "btn_saveasnew":
            return MODIFY02;
        case "btn_save":
        case "btn_save1":
            return (WORK_STEP_CD == "01" ? MODIFY01 : MODIFY03);
        case "btn_cancelcurrent":
            return (WORK_STEP_CD == "01" ? MODIFY04 : MODIFY05);
        case "btn_confirmdraft":
            return (WORK_STEP_CD == "01" ? MODIFY06 : MODIFY08);
        case "btn_cancelconfirmation":
            return (WORK_STEP_CD == "01" ? MODIFY07 : MODIFY09);
        case "btn_notifydraft":
            return (WORK_STEP_CD == "01" ? MODIFY10 : MODIFY12);
        case "btn_cancelnotification":
            return (WORK_STEP_CD == "01" ? MODIFY11 : MODIFY13);
        default:
            return "";
    } // end switch
}

function getSelectColumnName() {
    return (WORK_STEP_CD == "01" ? "trd_grp" : "final");
}

function year_OnChange(obj) {
    changeVersion();
    changePfmcFromTo();
}

function bse_quarter_onChange(obj) {
    changeVersion();
    changePfmcFromTo();
}

function trade_group_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    changeTrade();
}

function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    changeVersion();
    //subTrade_change();
}

function bound_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    changeVersion();
}

/*
 *  PFMC from ~ to Change
 */
function changePfmcFromTo() {
    var formObj = document.form;
    var rep_year = formObj.year.value;
    var month = eval(getQuarterToMonth(formObj.bse_quarter.value)) - 1;
    var repDate = new Date(rep_year, month, 1);
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

function subTrade_onChange() {
    doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
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

function subTrade_change() {
    var params = "targetGrp=" + comObjects[0].GetSelectCode() + "&trade=" + getParam(saveParams, "trade") + "&dirCd=" + getParam(saveParams, "bound");
    getSelectCodeList(document.form.subTrade, "SaqTagetGroupSubTrade", params);
}

function callbackPopupContractOffice(rowArray) {
    var colArray = rowArray[0];
    document.all.contractOffice.value = colArray[3];
}

/*
 * rhqLaneSheet Tree Double Click Event
 */
function rhqLaneSheet_OnDblClick(sheetObj, Row, Col) {
    common_tree_DblClick(sheetObj, Row, Col);
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
    if (searchSaqStsCd == "00" || searchSaqStsCd == "DR") {
        if (editModeObj[0].checked) { // LOAD
            var calc1 = formObj.calc1;
            obj1.style.display = "";
            obj2.style.display = "none";
            switch (true) {
                case calc1[0].checked: // Load
                    changeEditCols(sheetObj, LOAD, colName);
                    break;
                case calc1[1].checked: // Load(%)
                    changeEditCols(sheetObj, LOAD_TOTAL, colName);
                    break;
                case calc1[2].checked: // L/F(%)
                    changeEditCols(sheetObj, LF, colName);
                    break;
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
        editableCols(sheetObj, LOAD_TOTAL, colName, false);
        editableCols(sheetObj, LF, colName, false);
        editableCols(sheetObj, GREV, colName, false);
        editableCols(sheetObj, GRPB, colName, false);
    }
}

function changeEditCols(sheetObj, itemCd, colName) {
    editableCols(sheetObj, LOAD, colName, false);
    editableCols(sheetObj, LOAD_TOTAL, colName, false);
    editableCols(sheetObj, LF, colName, false);
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
    var isTotal = false; // true : Total, false : general
    var isLoadTotal = false;

    if (flg == undefined) {
        flg = true;
    }
    if (itemCd == LOAD_TOTAL) {
        itemCd = LOAD;
        isLoadTotal = true;
    }
    while ((selRow = sheetObj.FindText("item_seq", itemCd.toString(), selRow)) >= 0) {
        if (sheetObj.GetCellValue(selRow, "edit_grp") != "1") {
            // 첫번째 그룹이 아니면 수정불가
            selRow++;
            continue;
        }
        if (sheetObj.GetCellValue(selRow, 'rhq_cd').toUpperCase() == "TOTAL") {
            isTotal = true; // Total 수정 항목
            if (!(itemCd == GREV || itemCd == LF || isLoadTotal)) {
                selRow++;
                continue;
            }
            // disabled in case of BAS == 0
            if (itemCd == LF && sheetObj.GetCellValue(selRow, 'tot_bsa') == 0) {
                changeSheetBackColor(sheetObj, selRow, colName, isTotal, false);
                sheetObj.SetCellEditable(selRow, colName, false);
                selRow++;
                continue;
            }
        } else {
            isTotal = false; // enable data item
            if (isLoadTotal == true || !(itemCd == LOAD || itemCd == GRPB)) {
                selRow++;
                continue;
            }
        }
        // finish in case of sheetObj.CellEditable == flg
        if (flg == false && sheetObj.GetCellEditable(selRow, colName) == false) {
            return;
        }
        //log("selRow="+selRow + " isTotal=" + isTotal);
        changeSheetBackColor(sheetObj, selRow, colName, isTotal, flg)
        sheetObj.SetCellEditable(selRow, colName, flg);
        selRow++;
    }
}

function changeSheetBackColor(sheetObj, row, col, isTotal, flg) {
    if (flg == true) {
        sheetObj.SetCellBackColor(row, col, "#FFFFFF");
    } else {
        sheetObj.SetCellBackColor(row, col, sheetObj.GetCellBackColor(row, "item"));
    }
}

function getTabLocalParams() {
    var formObj = document.form;
    var trade_group = comObjects[0].GetSelectCode(); //trade_group.GetSelectCode();
    return "&glineVerNo=" + formObj.glineVerNo.value + "&mqtaMdlVerNo=" + formObj.mqtaMdlVerNo.value + "&slsFcastPubNo=" + formObj.slsFcastPubNo.value + "&mQtaVerNo=" + getParam(saveParams, "mQtaVerNo") + "&trade_group=" + trade_group + "&year=" + getParam(saveParams, "year") + "&bse_quarter=" + getParam(saveParams, "bse_quarter") + "&trade=" + getParam(saveParams, "trade") + "&bound=" + getParam(saveParams, "bound") + "&pfmc_fr_year=" + formObj.pfmc_fr_year[currentTabIndex].value + "&pfmc_fr_month=" + formObj.pfmc_fr_month[currentTabIndex].value + "&pfmc_to_year=" + formObj.pfmc_to_year[currentTabIndex].value + "&pfmc_to_month=" + formObj.pfmc_to_month[currentTabIndex].value + "&unit=" + getParam(saveParams, "unit");
}

function callbackRemark(rtnVal) {		
	var rtnValue = rtnVal; 
	
    if (rtnValue[0] == "OK") {        
        doActionIBSheet(sheetObjects[4], document.form, IBSEARCH_ASYNC05);
        processRemarkHighlight(rtnValue[1], rtnValue[2]);
        //processRemarkHighlight(getParseSaveParam(window.remarkRefreshParam, "rlane_grp"), getParseSaveParam(window.remarkRefreshParam, "ctrt_rhq_cd"));
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

/**
 *
 * @param sheetObj
 * @param cols
 * @param oriValues
 * @param valueCol
 * @param startCol
 * @returns {Array}
 */
function processFindValue(sheetObj, cols, oriValues, valueCol, startCol) {
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
            if (selRow < 0) { //찾는 값이 없다..
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

/**
 * create filter object after retrieve trdGrpAdjSheet Sheet.
 * used click in case of Retrieve, Save As New Version .
 */
function trdGrpAdjSheet_OnSearchEnd(sheetObj, errMsg) {
    var formObj = document.form;
    ComOpenWait(false);
    trdGrpAdjSheet_SearchEnd(sheetObj, formObj);
    doActionIBSheet(sheetObjects[4], formObj, IBSEARCH_ASYNC05); //Rmk sheet
}

function trdGrpAdjSheet_OnSaveEnd(sheetObj, errMsg) {
    var formObj = document.form;
    if (sheetObj.GetEtcData("status") == "OK") {
        if (sheetObj.GetEtcData("version") != "null" && sheetObj.GetEtcData("version") != undefined) {
            changeVersion();
            formObj.version.value = sheetObj.GetEtcData("version") + ":" + formObj.glineVerNo.value;
            document.form.mQtaVerNo.value = sheetObj.GetEtcData("version");
            trdGrpAdjSheet_SearchEnd(sheetObj, formObj);
        }
        if (formObj.target_month.selectedIndex == 0) {
            ComBtnEnable("btng_monthly_adj");
        }

    }
}

function trdGrpAdjSheet_SearchEnd(sheetObj, formObj) {
    isSheetEdited = false;
    searchSaqStsCd = sheetObj.GetEtcData("saqStsCd");
    formObj.mqtaMdlVerNo.value = sheetObj.GetEtcData("mqtaMdlVerNo");
    formObj.slsFcastPubNo.value = sheetObj.GetEtcData("slsFcastPubNo");
    isZeroLoad = sheetObj.GetEtcData("isZeroLoad");
    lane_ttl = sheetObj.GetEtcData("LANE_TOTAL");
    rhq = sheetObj.GetEtcData("RHQ");
    // Final check column show & hide
    if (searchSaqStsCd == "DR") {
        sheetObj.SetCellImage(1, "chk_rhq", 1);
        sheetObj.SetCellImage(1, "chk_trd_grp", 1);
        changeCheckHidden(false);
    } else {
        changeCheckHidden(true);
    }
    WORK_STEP_CD = "01";
    if (searchSaqStsCd == "DR" || searchSaqStsCd == "FC" || searchSaqStsCd == "FN") {
        WORK_STEP_CD = "03";
    }
    changeEditMode();
    reloadFilter();

    initCheckListDragPopupCompound(new Array(getConvertForPopup(sheetObj.GetEtcData("LANE_TOTAL")), getConvertForPopup(sheetObj.GetEtcData("RHQ_TOTAL"))), "CALCULATION", new Array("LANE_CAL", "RHQ_CAL"), new Array(new Array("Sub Trade", "Lane", "Select"), new Array("Regional Group", "Select")), "55:45", new Array("35:32:33", "53:47"), new Array(true, true));

    if (saveParams == "") {
        clearTabSearchParams();
        saveParams = getLocalParams();
        doActionIBSheet(sheetObjects[currentTabIndex], document.form, IBSEARCH_ASYNC02);
    }
    target_month_onChange();
    controlButtons(searchSaqStsCd, formObj);
}

function reloadFilter() {
    var data = getSingleData(sheetObjects[3], "sub_trd_cd", "ASC");
    initCheckListDragPopup(data, "SUB_TRADE", "SUB_TRADE_INPUT", "Sub Trade", "Select", "sheetName='trdGrpAdjSheet' colName='sub_trd_cd' ", true);
    data = getDoubleData(sheetObjects[3], "sub_trd_cd", "lane_grp");
    initCheckListDragPopup2(data, "LANE", "LANE_INPUT", "Sub Trade", "Lane", "Select", "sheetName='trdGrpAdjSheet' colName='lane_grp' ", true);
    data = getSingleData(sheetObjects[3], "rhq_cd", "ASC");
    initCheckListDragPopup(data, "RHQ", "RHQ_INPUT", "Regional Group", "Select", "sheetName='trdGrpAdjSheet' colName='rhq_cd' ", true);
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
                } else if (colName == "rhq_cd") {
                    objName = "RHQ";
                } else if (colName == "item") {
                    objName = "ITEM";
                } else if (colName == "chk_rhq" || colName == "chk_trd_grp") {
                    changeSetFinalAllCheck(sheetObj, colName);
                    return;
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

// change mouse courser
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
        }
    } else if (sheetObj.ColSaveName(col) == "lane_grp") {
        cursor = "Hand";
    }
    sheetObj.SetMousePointer(cursor);
}

function trdGrpAdjSheet_OnDblClick(sheetObj, row, col) {
    var formObj = document.form;
    if (sheetObj.ColSaveName(col) == "remarks" && sheetObj.GetCellValue(row, col) != "") {
        var params = "gline_ver_no=" + formObj.glineVerNo.value + "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd") + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, "sprt_grp_cd") + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, "bsa_grp_cd") + "&ctrt_rhq_cd=" + sheetObj.GetCellValue(row, "rhq_cd") + "&bse_mon=" + formObj.target_month.value.substring(4) + "&cre_ofc_cd=" + formObj.ofcCd.value + "&saq_sts_cd=" + searchSaqStsCd;
        var width = 450;
        var height = 650;
        var callback = "callbackRemark";
        ComOpenPopupScroll("/opuscntr/ESM_SAQ_0112.do?" + params, width, height, callback, "0,0", true);
    } else if (sheetObj.ColSaveName(col) == "lane_grp" && sheetObj.GetCellValue(row, "bsa_grp_cd") != "") {
        var params = "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&gline_ver_no=" + formObj.glineVerNo.value + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd") + "&sprt_grp_cd=" + sheetObj.GetCellValue(row, "sprt_grp_cd") + "&bsa_grp_cd=" + sheetObj.GetCellValue(row, "bsa_grp_cd") + "&bse_mon=" + formObj.target_month.value.substring(4);
        var width = 550;
        var height = 405;
        var callback = "callbackRemark";
        ComOpenPopupScroll("/opuscntr/ESM_SAQ_0116.do?" + params, width, height, callback, "0,0", true);
    }
}

function trdGrpAdjSheet_OnChange(sheetObj, row, col, value) {
    var colName = sheetObj.ColSaveName(col);
    if (colName == "trd_grp" || colName == "final") {
        var msg = processCalcLogic(sheetObj, row, col);
        if (msg != undefined && msg != "") {
            ComShowMessage(msg);
        }
    } else if (colName == "chk_rhq" || colName == "chk_trd_grp") {
        var rhq_check = sheetObj.GetCellValue(row, "chk_rhq");
        var trd_grp_check = sheetObj.GetCellValue(row, "chk_trd_grp");
        if (rhq_check == 1 && trd_grp_check == 1) {
            if (colName == "chk_rhq") {
                sheetObj.SetCellValue(row, "chk_trd_grp", 0, 0);
            } else {
                sheetObj.SetCellValue(row, "chk_rhq", 0, 0);
            }
        }
    }
}

function processCalcLogic(sheetObj, row, col) {
    if (!ComIsNumber(col)) {
        col = sheetObj.SaveNameCol(col);
    }
    var appdMsg = ""; // return Message
    var baseCol = sheetObj.SaveNameCol("edt_step_val"); // variable from calcuration
    var orgCol = sheetObj.SaveNameCol("org_step_val"); // variable from db
    try {
        sheetObj.RenderSheet(0);
        switch (eval(sheetObj.GetCellValue(row, "item_seq"))) {
            case LF:
                var new_lod_qty = sheetObj.GetCellValue(row - 3, baseCol) * (sheetObj.GetCellValue(row, col) / 100);
                setCalcBaseColumn(sheetObj, row - 1, col, new_lod_qty);
                processCalcLaneSprtGrpAllChange(LOAD, sheetObj, row - 1, col, baseCol, "percent");
                break;
            case LOAD:
                if (sheetObj.GetCellValue(row, 'rhq_cd').toUpperCase() == "TOTAL") {
                    processCalcLaneSprtGrpAllChange(LOAD, sheetObj, row, col, baseCol, "percent");
                } else {
                    setCalcBaseColumn(sheetObj, row, baseCol, sheetObj.GetCellValue(row, col));
                    processCalcLaneSprtGrpRHQChange(LOAD, sheetObj, row, col, baseCol, orgCol);
                }
                break;
            case GREV:
                processCalcLaneSprtGrpAllChange(GREV, sheetObj, row, col, baseCol, "percent");
                break;
            case GRPB:
                setCalcBaseColumn(sheetObj, row, baseCol, sheetObj.GetCellValue(row, col));
                processCalcLaneSprtGrpRHQChange(GRPB, sheetObj, row, col, baseCol, orgCol);
                break;
        } // end switch
    } catch (e) {
        ComShowMessage(e.message);
        appdMsg = appdMsg + "\n" + e;
    } finally {
        sheetObj.RenderSheet(1);
    }
    processCalcRoundOff2(sheetObj, row, col);
    return appdMsg;
}

function processCalcLaneSprtGrpRHQChange(ITEM, sheetObj, row, col, baseCol, orgCol) {
    var lane_sprt_grp = sheetObj.GetCellValue(row, "lane_sprt_grp");
    var rhq_cd = sheetObj.GetCellValue(row, "rhq_cd");
    var move_pos = 0;
    var load_row = 0;
    switch (ITEM) {
        case LOAD:
            move_pos = 0;
            break;
        case GRPB:
            move_pos = -2; // LOAD ROW=GRPB ROW - 2;
            break;
    } //end switch
    with(sheetObj) {
            load_row = row + move_pos;
            calculationOneRHQ(sheetObj, load_row, col, baseCol);
            calculationOneTOTAL(GetCellValue(row, "lane_grp"), sheetObj, col, baseCol);
            var ratio = calculationCellApplyMode(GetCellValue(row, baseCol), "divide", GetCellValue(row, "tot_bsa"));
            var org_lod_val = GetCellValue(row, baseCol);
            var cur_trade_cd = getTrd_cd();
            var selRow = row + 1;
            while ((selRow = sheetObj.FindText("item_seq", "" + ITEM, selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_sprt_grp") != lane_sprt_grp) {
                    break;
                }
                if (GetCellValue(selRow, "rhq_cd") == rhq_cd) {
                    if (cur_trade_cd == "IAS" || cur_trade_cd == "EMS") {
                        setCalcBaseColumn(sheetObj, selRow, baseCol, org_lod_val);
                    } else {
                        if (ITEM == GRPB) {
                            setCalcBaseColumn(sheetObj, selRow, baseCol, GetCellValue(row, baseCol));
                        } else {
                            setCalcBaseColumn(sheetObj, selRow, baseCol, (GetCellValue(selRow, "tot_bsa") * ratio));
                        }
                    }
                    load_row = selRow + move_pos;
                    calculationOneRHQ(sheetObj, load_row, col, baseCol);
                    calculationOneTOTAL(GetCellValue(selRow, "lane_grp"), sheetObj, col, baseCol);
                }
                selRow++;
            }
        } // end with
}

/**
 *
 * @param ITEM
 * @param sheetObj
 * @param row
 * @param col
 * @param baseCol
 * @param APPLY_MODE
 * @param CALC_VALUE
 */
function processCalcLaneSprtGrpAllChange(ITEM, sheetObj, row, col, baseCol, APPLY_MODE, CALC_VALUE) {
    var lane_sprt_grp = sheetObj.GetCellValue(row, "lane_sprt_grp");
    var lane_grp_cd = sheetObj.GetCellValue(row, "lane_grp");
    var rhq_cd = "";
    var key_cd = "";
    var move_pos = 0;
    var load_row = 0;
    var lod_qty = 0;
    var grs_rev = 0;
    var apply_value = 0;
    var ori_arr = rhq.split(";");
    var org_lod_val = new Array();
    var apply_LF = new Array();
    for (i = 0; i < ori_arr.length - 2; i++) {
        org_lod_val[i] = ori_arr[i + 1];
        apply_LF[i] = ori_arr[i + 1];
    }
    var apply_GRPB = new Array();
    switch (ITEM) {
        case LOAD:
            move_pos = 0;
            break;
        case GREV:
            move_pos = -1; // LOAD ROW=GREV ROW -1;
            break;
        case GRPB:
            move_pos = -2; // LOAD ROW=GRPB ROW -2;
            break;
    } //end switch
    with(sheetObj) {
            if (isNaN(CALC_VALUE) == false) {
                apply_value = eval(CALC_VALUE);
            } else if (APPLY_MODE == "percent") {
                apply_value = calcIncreaseRatio(GetCellValue(row, col), GetCellValue(row, baseCol));
            }
            var selRow = row + 1;
            while ((selRow = sheetObj.FindText("item_seq", "" + ITEM, selRow)) >= 0) {
                rhq_cd = GetCellValue(selRow, "rhq_cd");
                key_cd = rhq_cd;
                if (GetCellValue(selRow, "lane_sprt_grp") != lane_sprt_grp) {
                    break;
                }
                if (rhq_cd.toUpperCase() == "TOTAL") {
                    calculationOneTOTAL(lane_grp_cd, sheetObj, col, baseCol);
                    lane_grp_cd = sheetObj.GetCellValue(selRow, "lane_grp");
                    selRow++;
                    continue;
                }
                // LOAD position
                load_row = selRow + move_pos;
                switch (ITEM) {
                    case LOAD:
                        if (APPLY_MODE == "round") {
                            lod_qty = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, 0);
                        } else {
                            var cur_trade_cd = getTrd_cd();
                            if (GetCellValue(selRow, "edit_grp") == "1") {
                                lod_qty = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                                apply_LF[key_cd] = calculationCellApplyMode(lod_qty, "divide", GetCellValue(selRow, "tot_bsa"));
                                org_lod_val[key_cd] = lod_qty;
                            } else {
                                if (org_lod_val[key_cd] == undefined) {
                                    org_lod_val[key_cd] = "";
                                }
                                if (apply_LF[key_cd] == undefined) {
                                    apply_LF[key_cd] = "";
                                }
                                if (cur_trade_cd == "IAS" || cur_trade_cd == "EMS") {
                                    lod_qty = org_lod_val[key_cd];
                                } else {
                                    lod_qty = calculationCellApplyMode(GetCellValue(selRow, "tot_bsa"), "percent", apply_LF[key_cd]);
                                }
                            }
                        }
                        setCalcBaseColumn(sheetObj, selRow, baseCol, lod_qty);
                        break;
                    case GREV:
                        if (GetCellValue(selRow, "edit_grp") == "1") {
                            grs_rev = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                            apply_GRPB[key_cd] = calculationCellApplyMode(grs_rev, "divide", GetCellValue(load_row, baseCol));
                        } else if (apply_GRPB[key_cd] == undefined) {
                            apply_GRPB[key_cd] = "";
                        }
                        setCalcBaseColumn(sheetObj, selRow + 1, baseCol, apply_GRPB[key_cd]);
                        break;
                    case GRPB:
                        if (GetCellValue(selRow, "edit_grp") == "1") {
                            apply_GRPB[key_cd] = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                        } else if (apply_GRPB[key_cd] == undefined) {
                            apply_GRPB[key_cd] = "";
                        }
                        setCalcBaseColumn(sheetObj, selRow, baseCol, apply_GRPB[key_cd]);
                        break;
                } // end switch
                calculationOneRHQ(sheetObj, load_row, col, baseCol);
                selRow++;
            } // end while
            calculationOneTOTAL(lane_grp_cd, sheetObj, col, baseCol);
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
        case "divide":
            apply_value = (apply_value == 0 ? 1 : apply_value);
            return eval(org_value) / eval(apply_value);
    }
}

function calculationOneRHQ(sheetObj, row, displayCol, baseCol) {
    with(sheetObj) {
            var item_cnt = 4; // define GREV item
            var lod_qty = GetCellValue(row, baseCol);
            var grs_rpb = GetCellValue(row + 2, baseCol); //GRPB
            if (lod_qty != 0) {
                var cm_uc_amt = GetCellValue(row, "cm_uc_amt");
                SetCellValue(row + 1, baseCol, grs_rpb * lod_qty, 0); //GREV set
                SetCellValue(row + 3, baseCol, (grs_rpb - cm_uc_amt) * lod_qty, 0); //CM set
                SetCellValue(row + 4, baseCol, (grs_rpb - cm_uc_amt), 0); //CMB set
            } else {
                // RHQ item is 0 in case of LOAD ==0
                for (var i = 0; i <= item_cnt; i++) {
                    SetCellValue(row + i, baseCol, 0, 0);
                }
            }
            // column for save
            SetCellValue(row, "lod_qty", lod_qty, 0);
            SetCellValue(row, "grs_rpb_rev", GetCellValue(row + 2, baseCol), 0);
            // Display
            for (var i = 0; i <= item_cnt; i++) {
                SetCellValue(row + i, displayCol, getDisplayZeroToNull(GetCellValue(row + i, baseCol)), 0);
            }
        } // end with
}

function calculationOneTOTAL(lane_grp_cd, sheetObj, displayCol, baseCol) {
    isSheetEdited = true;
    var item_cnt = 5;
    var voyage = 0;
    var sum_lod_qty = 0;
    var sum_grs_rev = 0;
    var sum_cm = 0;
    var total_load_row = 0; // TOTAL LOAD ROW
    var selRow = sheetObj.FindText("lane_grp", lane_grp_cd, 1);
    with(sheetObj) {
            while ((selRow = sheetObj.FindText("item_seq", "" + LOAD, selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_grp") == lane_grp_cd && GetCellValue(selRow, "rhq_cd").toUpperCase() == "TOTAL") {
                    total_load_row = selRow;
                    break;
                }
                selRow++;
            }
            selRow = selRow + 1;
            while ((selRow = sheetObj.FindText("item_seq", "" + LOAD, selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_grp") != lane_grp_cd) {
                    break;
                }
                sum_lod_qty = eval(sum_lod_qty) + eval(GetCellValue(selRow, baseCol));
                sum_grs_rev = eval(sum_grs_rev) + eval(GetCellValue(selRow + 1, baseCol));
                sum_cm = eval(sum_cm) + eval(GetCellValue(selRow + 3, baseCol));
                selRow++;
            }
            if (sum_lod_qty != 0) {
                // LF = sum_lod_qty/BSA*100
                var tot_lf = (GetCellValue(total_load_row - 2, baseCol) == 0 ? 0 : (sum_lod_qty / GetCellValue(total_load_row - 2, baseCol)) * 100); //BSA
                SetCellValue(total_load_row, baseCol, sum_lod_qty, 0); //LOAD
                SetCellValue(total_load_row + 1, baseCol, tot_lf, 0); //LF
                SetCellValue(total_load_row + 2, baseCol, sum_grs_rev, 0); //GREV
                SetCellValue(total_load_row + 3, baseCol, sum_grs_rev / sum_lod_qty, 0); //GRPB
                SetCellValue(total_load_row + 4, baseCol, sum_cm, 0); //CM
                SetCellValue(total_load_row + 5, baseCol, sum_cm / sum_lod_qty, 0); //CMB
            } else {
                for (var i = 0; i <= item_cnt; i++) {
                    SetCellValue(total_load_row + i, baseCol, 0, 0);
                }
            }
            // TOTAL Display
            for (var i = 0; i <= item_cnt; i++) {
                SetCellValue(total_load_row + i, displayCol, getDisplayZeroToNull(GetCellValue(total_load_row + i, baseCol)), 0);
            }
        } // end with
    if (ComIsBtnEnable("btng_monthly_adj")) {
        ComBtnDisable ("btng_monthly_adj");
    }
}

function processMainGrpRoundOff(sheetObj) {
    var rhq_list = rhq.split(";");
    var selRow = 1;
    var baseCol = sheetObj.SaveNameCol("edt_step_val");
    var APPLY_MODE = "round";
    var cell_value = "";
    var col = getSelectColumnName();
    var orgCol = sheetObj.SaveNameCol("org_step_val");
    with(sheetObj) {
        for (var i = 0; i < rhq_list.length; i++) {
            var rhq_ofc_cd = rhq_list[i];
            if (rhq_ofc_cd.toUpperCase() == "TOTAL") {
                continue;
            }
            selRow = 1;
            while (true) {
                selRow = FindText("rhq_cd", rhq_ofc_cd, selRow);
                if (selRow < 0) {
                    break;
                }
                selRow = FindText("item_seq", "" + LOAD, selRow);
                if (selRow < 0) {
                    break;
                }
                if (GetCellValue(selRow, "edit_grp") != 1 || GetCellValue(selRow, "rhq_cd") == "TOTAL") {
                    selRow++;
                    continue;
                }
                cell_value = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE);
                setCalcBaseColumn(sheetObj, selRow, baseCol, cell_value);
                processCalcLaneSprtGrpRHQChange(LOAD, sheetObj, selRow, col, baseCol, orgCol);
                selRow++;
            }
        }
    }
}

// Intermediate processing of Round Off
function processCalcRoundOff2(sheetObj, row, col) {
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    var ITEM = LOAD;
    var APPLY_MODE = "round";
    var cell_value = "";
    var baseCol = sheetObj.SaveNameCol("edt_step_val");
    var orgCol = sheetObj.SaveNameCol("org_step_val");
    if (!document.form.edit_mode[0].checked) {
        return;
    }
    with(sheetObj) {
        cell_value = calculationCellApplyMode(GetCellValue(row, col), APPLY_MODE);
        setCalcBaseColumn(sheetObj, row, baseCol, cell_value);
        processCalcLaneSprtGrpRHQChange(LOAD, sheetObj, row, col, baseCol, orgCol);
        if (GetCellValue(row, "rhq_cd") == "TOTAL") {
            if (GetCellValue(row, "item") == "Volume") {
                row = row + 7;
            } else {
                row = row + 6;
            }
        }
        processCalcLaneSprtGrpAllChange(ITEM, sheetObj, row - 1, col, baseCol, APPLY_MODE);
    }
}

//    	function processCalcRoundOff() {
//    	    var formObj = document.form;
//    	    var sheetObj = sheetObjects[3];
//    		var ITEM = LOAD;
//    		var APPLY_MODE = "round";
//
//    		processMainGrpRoundOff(sheetObj)
//
//
//    		var startTime = new Date();
//
//    		try{
//    		    sheetObj.Redraw = false;
//
//    		    var baseCol = sheetObj.SaveNameCol("edt_step_val");
//    		    //LANE_TOTAL data는 sub_trd_cd|rlane_cd;sub_trd_cd|rlane_cd;sub_trd_cd|rlane_cd; 형식으로 돼 있다.
//    			var lane_list = sheetObj.EtcData("LANE_TOTAL").split(";");
//                var lane_vl = "";
//    			var selCol = sheetObj.SaveNameCol(getSelectColumnName());
//    			var selRow = 1;
//
//    			with (sheetObj) {
//
//    				for(var i=0; i<lane_list.length-1; i++) {
//    				    lane_vl = lane_list[i].split("|");
//    				    lane_vl = lane_vl[1];
//
//    					selRow = sheetObj.FindText("lane_sprt_grp", lane_vl, selRow);
//    					log("processCalcRoundOff] lane_sprt_grp = " + lane_vl + " ROW = " + selRow);
//
//    					if (selRow >= 0 && CellValue(selRow, "rhq_cd").toUpperCase() == "TOTAL") {
//    					    selRow = selRow+10;
//    					    // LANE Month call
//    					    processCalcLaneSprtGrpAllChange(ITEM, sheetObj, selRow, selCol, baseCol, APPLY_MODE);
//    				    }
//    				    selRow++;
//    				} // end for i
//    			} // end with
//
//    		} catch(e) {
//    			ComShowMessage(e);
//    		} finally {
//    		    sheetObj.Redraw = true;
//    		}
//
//    		var endTime = new Date();
//    		log("===================================================");
//    		log("startTime = " + startTime);
//    		log("endTime = " + endTime);
//    		log("Time = " + (endTime.getTime() - startTime.getTime())/1000 );
//    	}

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

// Numerical Verification
function getZeroToInfinity(vl) {
    if (vl == Infinity || isNaN(vl)) {
        return 0;
    }
    return vl;
}

// set Final button click
function processSetFinal() {
    var sheetObj = sheetObjects[3];
    var startTime = new Date();
    try {
        //    		    sheetObj.RenderSheet(0);
        var displayCol = sheetObj.SaveNameCol("final");
        var baseCol = sheetObj.SaveNameCol("edt_step_val");
        //    			var lane_list=sheetObj.GetEtcData("LANE_TOTAL").split(";");
        var lane_list = lane_ttl.split(";");
        var selRow = 1;
        var lane_vl = "";
        with(sheetObj) {
                for (var i = 0; i < lane_list.length - 1; i++) {
                    lane_vl = lane_list[i].split("|");
                    lane_vl = lane_vl[1];
                    selRow = sheetObj.FindText("lane_sprt_grp", lane_vl, selRow);
                    //    					log("processSetFinal] lane_sprt_grp=" + lane_vl + " ROW=" + selRow);
                    selRow = processCalcFinal_LaneSprtGroup(lane_vl, sheetObj, selRow, displayCol, baseCol);
                } // end for i
            } // end with
    } catch (e) {
        ComShowMessage(e.message);
    } finally {
        //    		    sheetObj.RenderSheet(1);
    }
    var endTime = new Date();
    //    		log("===================================================");
    //    		log("startTime=" + startTime);
    //    		log("endTime=" + endTime);
    //    		log("Time=" + (endTime.getTime() - startTime.getTime())/1000 );
}

function processCalcFinal_LaneSprtGroup(lane_sprt_grp, sheetObj, selRow, displayCol, baseCol) {
    with(sheetObj) {
            var ori_arr = rhq.split(";");
            var apply_KEY = new Array();
            var chk_trd_grp_vol = new Array();
            var chk_rhq_vol = new Array();
            var chk_trd_grp_rev = new Array();
            var chk_rhq_rev = new Array();
            for (i = 0; i < ori_arr.length - 2; i++) {
                apply_KEY[i] = ori_arr[i + 1];
                apply_KEY[apply_KEY[i]] = new Array(5);
                chk_trd_grp_vol[i] = ori_arr[i + 1];
                chk_rhq_vol[i] = ori_arr[i + 1];
                chk_trd_grp_rev[i] = ori_arr[i + 1];
                chk_rhq_rev[i] = ori_arr[i + 1];
            }
            var lane_grp_cd = GetCellValue(selRow, "lane_grp");
            var rhq_cd = "";
            var tot_bsa = 0;
            var cur_trade_cd = getTrd_cd();
            //    			log("processCalcFinal_LaneSprtGroup] lane_sprt_grp=" + lane_sprt_grp + " lane_grp_cd=" + lane_grp_cd + " =======================");
            while ((selRow = sheetObj.FindText("item_seq", "" + LOAD, selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_sprt_grp") != lane_sprt_grp) {
                    // LANE GROUP
                    break;
                }
                rhq_cd = GetCellValue(selRow, "rhq_cd").toUpperCase();
                tot_bsa = (GetCellValue(selRow, "tot_bsa") == 0 ? 1 : GetCellValue(selRow, "tot_bsa"));
                //    				log("processCalcFinal_LaneSprtGroup] lane_grp_cd=" + lane_grp_cd + " rhq_cd=" + rhq_cd + " tot_bsa=" + tot_bsa);
                if (chk_trd_grp_vol[rhq_cd] == undefined && chk_rhq_vol[rhq_cd] == undefined && chk_trd_grp_rev[rhq_cd] == undefined && chk_rhq_rev[rhq_cd] == undefined) {
                    chk_trd_grp_vol[rhq_cd] = GetCellValue(selRow, "chk_trd_grp");
                    chk_rhq_vol[rhq_cd] = GetCellValue(selRow, "chk_rhq");
                    chk_trd_grp_rev[rhq_cd] = GetCellValue(selRow + 1, "chk_trd_grp");
                    chk_rhq_rev[rhq_cd] = GetCellValue(selRow + 1, "chk_rhq");
                }
                if (rhq_cd == "TOTAL") {
                    var chk_flag = true;
                    for (i = 0; i < apply_KEY.length; i++) {
                        if (apply_KEY[apply_KEY[i]][4] == "Y" && chk_flag) {
                            // TOTAL
                            calculationOneTOTAL(lane_grp_cd, sheetObj, displayCol, baseCol);
                            chk_flag = false;
                        }
                    }
                    lane_grp_cd = GetCellValue(selRow, "lane_grp");
                    selRow = selRow + 1;
                    continue;
                }
                //    				if (CellValue(selRow, "edit_grp") == "1") {
                // [0] : LOAD saveName, [1] : GREV saveName, [2] : L/F, [3] : GRPB, [4] : change flag
                apply_KEY[rhq_cd] = new Array(5);
                // LOAD copy
                if (chk_trd_grp_vol[rhq_cd] == 1) {
                    SetCellValue(selRow, baseCol, GetCellValue(selRow, "org_trd"), 0);
                    apply_KEY[rhq_cd][0] = "org_trd";
                    apply_KEY[rhq_cd][2] = GetCellValue(selRow, "org_trd") / tot_bsa;
                } else if (chk_rhq_vol[rhq_cd] == 1) {
                    SetCellValue(selRow, baseCol, GetCellValue(selRow, "org_rhq"), 0);
                    apply_KEY[rhq_cd][0] = "org_rhq";
                    apply_KEY[rhq_cd][2] = GetCellValue(selRow, "org_rhq") / tot_bsa;
                }
                // GREV, GRPB copy
                if (chk_trd_grp_rev[rhq_cd] == 1) {
                    // GRPB = GREV/LOAD
                    SetCellValue(selRow + 2, baseCol, GetCellValue(selRow + 1, "org_trd") / GetCellValue(selRow, baseCol), 0);
                    apply_KEY[rhq_cd][1] = "org_trd";
                    apply_KEY[rhq_cd][3] = GetCellValue(selRow + 2, baseCol);
                } else if (chk_rhq_rev[rhq_cd] == 1) {
                    // GRPB = GREV/LOAD
                    SetCellValue(selRow + 2, baseCol, GetCellValue(selRow + 1, "org_rhq") / GetCellValue(selRow, baseCol), 0);
                    apply_KEY[rhq_cd][1] = "org_rhq";
                    apply_KEY[rhq_cd][3] = GetCellValue(selRow + 2, baseCol);
                }
                //
                //    				} else {
                //    					// 다른 그룹은 apply_KEY 로 적용...
                //    					// [0] : LOAD saveName, [1] : GREV saveName, [2] : L/F, [3] : GRPB, [4] : 변경여부
                //
                //    					if (apply_KEY[rhq_cd][2] != undefined) {
                //    					    if( cur_trade_cd =="IAS" ){
                //    						  CellValue2(selRow, baseCol) = apply_KEY[rhq_cd][5]; ;
                //    					    }else{
                //    					      // LOAD = BSA * L/F
                //    						  CellValue2(selRow, baseCol) = tot_bsa * apply_KEY[rhq_cd][2];
                //    					    }
                //    					}
                //    					if (apply_KEY[rhq_cd][1] != undefined) {
                //    						// GRPB setting
                //    						CellValue2(selRow+2, baseCol) = apply_KEY[rhq_cd][3];
                //    					}
                //
                //    					//log("processCalcFinal_LaneSprtGroup] Load = " + CellValue(selRow, baseCol) + " GRPB = " + CellValue(selRow+2, baseCol) );
                //    				}
                //
                if (apply_KEY[rhq_cd][0] != undefined || apply_KEY[rhq_cd][1] != undefined) {
                    calculationOneRHQ(sheetObj, selRow, displayCol, baseCol);
                    apply_KEY[rhq_cd][4] = "Y";
                } else {
                    apply_KEY[rhq_cd][4] = "";
                }
                selRow++;
                //    				log("processCalcFinal_LaneSprtGroup] apply_KEY["+rhq_cd+"]=" + apply_KEY[rhq_cd]);
            } // end while
            var chk_flag = true;
            var apply_text;
            for (i = 0; i < apply_KEY.length; i++) {
                apply_text = apply_KEY[i];
                if (apply_KEY[apply_text][4] == "Y" && chk_flag) {
                    calculationOneTOTAL(lane_grp_cd, sheetObj, displayCol, baseCol);
                    chk_flag = false;
                }
            }
        } // end with
    return selRow++;
}

function processPopupOK(objName, inputObjName, html) {
    // log("processPopupOK() call : objName=" + objName + " inputObjName=" +
    // inputObjName);
    var divObj = eval(objName);
    var inputObj = eval(inputObjName);
    var inputObjects = new Array();

    //v    		if (objName != "REMARKS") {
    inputObjects[0] = parseCheckBoxStr(eval("SUB_TRADE_INPUT"), true, " :true|");
    inputObjects[1] = parseCheckBoxStr(eval("LANE_INPUT"), true, " :true|");
    inputObjects[2] = parseCheckBoxStr(eval("RHQ_INPUT"), true, " :true|");
    inputObjects[3] = parseCheckBoxStr(eval("ITEM_INPUT"), true, " :true|");
	
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
    //v    		}
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

function processSheetPopupOK(objName, inputObjName) {
    //    	log("processSheetPopupOK() call : objName=" + objName + " inputObjName=" + inputObjName);
    var divObj = eval(objName);
    var sheetObj = eval(inputObjName);
    var inputObjects = new Array();
    logObjValue(objName, inputObjName, logObj);
    inputObjects[0] = parseSheetCheckBoxStr(eval("SUB_TRADE_INPUT"));
    inputObjects[1] = parseSheetCheckBoxStr(eval("LANE_INPUT"));
    inputObjects[2] = parseSheetCheckBoxStr(eval("RHQ_INPUT"));
    inputObjects[3] = parseSheetCheckBoxStr(eval("ITEM_INPUT"));
    processDynamicPopupHideRow(divObj, sheetObj, inputObjects);
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
        //show.
        if (inputObj.checked == true) {
            cols[0] = colName;
            values[0] = inputObj.value;
            var filterCnt = processFilterSheet(sheetObjects[3], cols, values, inputObjects, true);
            if (colName == "item" && inputObj.value == "Load") {
                values[0] = "L/F";
                processFilterSheet(sheetObjects[3], cols, values, inputObjects, true);
            }
            //hide.
        } else if (inputObj.checked == false) {
            cols[0] = colName;
            values[0] = inputObj.value;
            var filterCnt = processFilterSheet(sheetObjects[3], cols, values, inputObjects, false);
            if (colName == "item" && inputObj.value == "Load") {
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
 * @returns
 */
function processFilterSheet(sheetObj, cols, oriValues, inputObjects, isDisplay) {
    //         log("processFilterSheet : sheetObj="+sheetObj+",cols="+cols+", oriValues="+oriValues+",inputObjects="+inputObjects+", isDisplay="+isDisplay);
    //         log("processFilterSheet : cols.length=" + cols.length);
    var filterCnt = 0;
    //         sheetObj.ReDraw=false;
    //         var selRow=0;
    //         var flg ;

    var findId = 0;
    var findText = "";

    for (j = 0; j < cols.length; j++) {
        while (findId != -1) {
            findId = sheetObj.FindText(cols[j], oriValues[j], findId);
            if (findId >= 0) {
                findText += findId + "|";
                findId++;
            }
        }
    }
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

            if (findText1 != "") {
                sheetObj.SetRowHidden(findText1, !isDisplay);
            }
            if (findText2 != "") {
                sheetObj.SetRowHidden(findText2, isDisplay);
            }

        } else {
            sheetObj.SetRowHidden(findText, !isDisplay);
        }
    }

    //         for(var i=0 ; i <= sheetObj.LastRow(); i++){
    //             flg=false;
    //             for(var j=0 ; j < cols.length ; j++ ){
    //                 selRow=sheetObj.FindText(cols[j],oriValues[j],selRow);
    //                 //log("processFilterSheet : sheetObj.FindText("+cols[j]+","+oriValues[j]+","+selRow+") =" + selRow);
    //                 if( selRow < 0 ){
    //                     break;
    //                 }
    //             }
    //             if( selRow >= 0  ){
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
    ////                 sheetObj.SetRowHidden(i,!isDisplay);
    //                 break;
    //             }
    //         }
    //        sheetObj.ReDraw=true;
    return filterCnt;
}

/*
        inputObjects[0]=parseCheckBoxStr(eval("SUB_TRADE_INPUT"));
        inputObjects[1]=parseCheckBoxStr(eval("LANE_INPUT"));
        inputObjects[2]=parseCheckBoxStr(eval("RHQ_INPUT"));
        inputObjects[3]=parseCheckBoxStr(eval("ITEM_INPUT"));
 */
function filterValidation(sheetObj, row, cols, inputObjects) {
    var retValue = false;
    if (cols[0] == "sub_trd_cd") {
        if (inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "rhq_cd") + ":true|")) >= 0 && inputObjects[3].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0) {
            retValue = true;
        }
    } else if (cols[0] == "lane_grp") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "rhq_cd") + ":true|")) >= 0 && inputObjects[3].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0) {
            retValue = true;
        }
    } else if (cols[0] == "rhq_cd") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[3].indexOf((sheetObj.GetCellValue(row, "item") + ":true|")) >= 0) {
            retValue = true;
        }
    } else if (cols[0] == "item") {
        if (inputObjects[0].indexOf((sheetObj.GetCellValue(row, "sub_trd_cd") + ":true|")) >= 0 && inputObjects[1].indexOf((sheetObj.GetCellValue(row, "lane_grp") + ":true|")) >= 0 && inputObjects[2].indexOf((sheetObj.GetCellValue(row, "rhq_cd") + ":true|")) >= 0) {
            retValue = true;
        }
    }
    //        log("filterValidation] cols=" + cols + " retValue=" + retValue);
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
    var pObj = document.getElementsByName("btng_apply")[0];
    if (obj != null) {
        var evtobj = window.event ? window.event : e
        var tempX = event.clientX + document.body.scrollLeft;
        var tempY = event.clientY + document.body.scrollTop;
        //            openDynamicDragPopup(obj,tempX-400,tempY,410,300,sheetObjects[3]);
        openDynamicDragPopup(obj, tempX - 400, evtobj.offsetY + 870, 410, 300, sheetObjects[3]);
    }
}

function popupCheckAll(allObj, inputObj) {
    var check = allObj.checked;
    if (inputObj.length != undefined) {
        for (var i = 0; i < inputObj.length; i++) {
            i
            nputObj[i].checked = check;
        }
    } else {
        inputObj.checked = check;
    }
}

function processCalcPopupOK(objName, html) {
    var startTime = new Date();
    var divObj = document.getElementById(objName);
    var inputObjects = new Array();
    inputObjects[0] = parseCheckBoxStr(eval("LANE_CAL"), false, " :true|");
    inputObjects[1] = parseCheckBoxStr(eval("RHQ_CAL"), false, " :true|");
    if (inputObjects[0] == "") {
        ComShowCodeMessage("COM12113", "Lane");
        return;
    } else if (inputObjects[1] == "") {
        ComShowCodeMessage("COM12113", "RHQ");
        return;
    }
    var formObj = document.form;
    var sheetObj = sheetObjects[3];
    var editModeObj = formObj.edit_mode;
    var ITEM = 0;
    var APPLY_MODE = "";
    var CALC_VALUE = eval(formObj.calc_value.value); // change value
    var isLoadTotal = false; // Load(%) select y/n
    var baseCol = "edt_step_val"; //sheetObj.SaveNameCol("edt_step_val"); //variable from calculate
    var selCol = sheetObj.SaveNameCol(getSelectColumnName());
    var selRow = 1;
    var lod_qty = 0;
    var grs_rev = 0;
    var newLF = 0;
    var NEW_APPLY_MODE = "";
    var NEW_CALC_VALUE = 0;
    try {
        sheetObj.RenderSheet(0);
        var allRhqCount = (rhq.split(";")).length - 1;
        var arrLANE_TOTAL = inputObjects[0].split(":true|");
        var arrRHQ = inputObjects[1].split(":true|");
        var isAllRHQ = (allRhqCount == arrRHQ.length ? true : false);
        //    		    log("processCalcPopupOK] arrLANE_TOTAL=" + arrLANE_TOTAL + " length=" + arrLANE_TOTAL.length);
        //    		    log("processCalcPopupOK] arrRHQ=" + arrRHQ + " length=" + arrRHQ.length);
        //    		    log("processCalcPopupOK] isAllRHQ=" + isAllRHQ + " allRhqCount=" + allRhqCount);
        if (editModeObj[0].checked) { //LOAD
            ITEM = LOAD;
            APPLY_MODE = (formObj.calc1[0].checked ? "amount" : "percent");
            isLoadTotal = formObj.calc1[1].checked;
        } else if (editModeObj[1].checked) { //G.REV
            ITEM = GREV;
            APPLY_MODE = (formObj.calc2[0].checked ? "amount" : "percent");
        } else if (editModeObj[2].checked) { //G.RPB
            ITEM = GRPB
            APPLY_MODE = (formObj.calc2[0].checked ? "amount" : "percent");
        }
        //    			log("processCalcPopupOK] ITEM=" + ITEM);
        //    			log("processCalcPopupOK] APPLY_MODE=" + APPLY_MODE);
        //    			log("processCalcPopupOK] CALC_VALUE=" + CALC_VALUE);
        with(sheetObj) {
                // LANE lane_sprt_grp treated as a unit.
                for (var i = 0; i < arrLANE_TOTAL.length; i++) {
                    selRow = sheetObj.FindText("lane_sprt_grp", arrLANE_TOTAL[i], selRow);
                    //    					log("processCalcPopupOK] for arrLANE_TOTAL[i]=" + arrLANE_TOTAL[i] + " , selRow=" + selRow);
                    if (selRow == -1) {
                        continue;
                    }
                    if (isLoadTotal == false && ITEM == LOAD && APPLY_MODE == "percent" && GetCellValue(selRow, "tot_bsa") == 0) {
                        selRow++;
                        continue;
                    }
                    if (isLoadTotal) {
                        ITEM = LOAD_TOTAL;
                    }
                    processCalcApplyRHQ(ITEM, arrLANE_TOTAL[i], inputObjects[1], sheetObj, selRow, selCol, baseCol, APPLY_MODE, CALC_VALUE);
                    selRow++;
                } // end for i
            } // end with
    } catch (e) {
        ComShowMessage(e.message);
    } finally {
        sheetObj.RenderSheet(1);
    }
    var endTime = new Date();
    //    		log("===================================================");
    //    		log("startTime=" + startTime);
    //    		log("endTime=" + endTime);
    //    		log("Time=" + (endTime.getTime() - startTime.getTime())/1000 );
}

function processCalcApplyRHQ(ITEM, lane_sprt_grp, rhq_string, sheetObj, row, col, baseCol, APPLY_MODE, CALC_VALUE) {
    var lane_grp_cd = "";
    var rhq_cd = "";
    var key_cd = "";
    var selRow = row;
    var move_pos = 0;
    var load_row = 0;
    var lod_qty = 0;
    var grs_rev = 0;
    var apply_value = 0;
    var tot_item_value = 0;
    var tot_plus_value = 0;
    var plus_value = 0;
    var isLoadTotal = false;
    var ori_arr = rhq.split(";");
    var apply_LF = new Array();
    var apply_GRPB = new Array();
    for (i = 0; i < ori_arr.length - 2; i++) {
        apply_LF[i] = ori_arr[i + 1];
        apply_GRPB[i] = ori_arr[i + 1];
    }
    switch (ITEM) {
        case LOAD:
            move_pos = 0;
            break;
        case LOAD_TOTAL: // LOAD(%)
            ITEM = LOAD;
            move_pos = 0;
            isLoadTotal = true;
            break;
        case GREV:
            move_pos = -1; // LOAD ROW=GREV ROW -1;
            break;
        case GRPB:
            move_pos = -2; // LOAD ROW=GRPB ROW -2;
            break;
    } //end switch
    //    		log("processCalcApplyRHQ] move_pos=" + move_pos);
    with(sheetObj) {
            CALC_VALUE = getZeroToInfinity(CALC_VALUE);
            if (APPLY_MODE == "percent") {
                apply_value = (100 + eval(CALC_VALUE)) / 100;
            } else {
                apply_value = eval(CALC_VALUE);
            }
            //    			log("processCalcApplyRHQ] apply_value=" + apply_value);
            lane_grp_cd = GetCellValue(selRow, "lane_grp");
            while ((selRow = sheetObj.FindText("item_seq", "" + ITEM, selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_grp") != lane_grp_cd) {
                    break;
                }
                if (GetCellValue(selRow, "rhq_cd").toUpperCase() == "TOTAL") {
                    if (isLoadTotal) {
                        // Load(%)
                        lod_qty = GetCellValue(selRow, baseCol) * apply_value;
                        tot_plus_value = lod_qty - GetCellValue(selRow, baseCol);
                    } else if (ITEM == LOAD && APPLY_MODE == "percent") {
                        // NEW L/F = ('L/F'+CALC_VALUE)/100
                        var newLF = (eval(GetCellValue(selRow + 1, baseCol)) + eval(CALC_VALUE)) / 100;
                        // Load = BSA * (('L/F'+CALC_VALUE)/100)
                        lod_qty = GetCellValue(selRow - 2, baseCol) * newLF;
                        tot_plus_value = lod_qty - GetCellValue(selRow, baseCol);
                        //    						log("processCalcApplyRHQ] total : BSA=" + GetCellValue(selRow-2, baseCol));
                        //    						log("processCalcApplyRHQ] total : L/F=" + GetCellValue(selRow+1, baseCol));
                        //    						log("processCalcApplyRHQ] total : LOAD=" + GetCellValue(selRow, baseCol));
                        //    						log("processCalcApplyRHQ] total : NEW L/F=" + newLF );
                    } else if (ITEM == GREV) {
                        grs_rev = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                        tot_plus_value = grs_rev - GetCellValue(selRow, baseCol);
                        APPLY_MODE = "percent";
                        //    						log("processCalcApplyRHQ] total : GREV=" + GetCellValue(selRow, baseCol));
                    }
                    selRow++;
                    continue;
                }
                if (rhq_string.indexOf(GetCellValue(selRow, "rhq_cd")) == -1) {
                    selRow++;
                    continue;
                }
                // total. tot_item_value
                tot_item_value = eval(tot_item_value) + eval(GetCellValue(selRow, baseCol));
                selRow++;
            }
            selRow = row + 6;
            //    			log("processCalcApplyRHQ] tot_item_value=" + tot_item_value);
            while ((selRow = sheetObj.FindText("item_seq", "" + ITEM, selRow)) >= 0) {
                if (GetCellValue(selRow, "lane_sprt_grp") != lane_sprt_grp) {
                    break;
                }
                rhq_cd = GetCellValue(selRow, "rhq_cd");
                key_cd = rhq_cd;
                if (rhq_cd.toUpperCase() == "TOTAL") {
                    calculationOneTOTAL(lane_grp_cd, sheetObj, col, baseCol);
                    lane_grp_cd = GetCellValue(selRow, "lane_grp");
                    selRow++;
                    continue;
                }
                if (rhq_string.indexOf(rhq_cd) == -1) {
                    selRow++;
                    continue;
                }
                //    				log("processCalcApplyRHQ] lane_grp_cd=" + GetCellValue(selRow, "lane_grp")+ " , rhq_cd=" + rhq_cd );
                load_row = selRow + move_pos;
                switch (ITEM) {
                    case LOAD:
                        if (GetCellValue(selRow, "edit_grp") == "1") {
                            if (APPLY_MODE == "percent") {
                                // apply_value = (LOAD/tot_item_value) * tot_plus_value
                                apply_value = (GetCellValue(selRow, baseCol) / tot_item_value) * tot_plus_value;
                            }
                            lod_qty = calculationCellApplyMode(GetCellValue(selRow, baseCol), "amount", apply_value);
                            lod_qty = calculationCellApplyMode(lod_qty, "round");
                            apply_LF[key_cd] = calculationCellApplyMode(lod_qty, "divide", GetCellValue(selRow, "tot_bsa"));
                        } else {
                            lod_qty = calculationCellApplyMode(GetCellValue(selRow, "tot_bsa"), "percent", apply_LF[key_cd]);
                            lod_qty = calculationCellApplyMode(lod_qty, "round");
                        }
                        setCalcBaseColumn(sheetObj, load_row, baseCol, lod_qty);
                        //log("processCalcApplyRHQ] new LOAD=" + lod_qty);
                        break;
                    case GREV:
                        if (GetCellValue(selRow, "edit_grp") == "1") {
                            // apply_value = (GREV/tot_item_value) * tot_plus_value
                            plus_value = (GetCellValue(selRow, baseCol) / tot_item_value) * tot_plus_value;
                            grs_rev = eval(GetCellValue(selRow, baseCol)) + eval(plus_value);
                            apply_GRPB[key_cd] = calculationCellApplyMode(grs_rev, "divide", GetCellValue(load_row, baseCol));
                        }
                        setCalcBaseColumn(sheetObj, selRow + 1, baseCol, apply_GRPB[key_cd]);
                        //log("processCalcApplyRHQ] new GREV=" + grs_rev + " new GRPB=" + apply_GRPB[key_cd]);
                        break;
                    case GRPB:
                        if (GetCellValue(selRow, "edit_grp") == "1") {
                            apply_GRPB[key_cd] = calculationCellApplyMode(GetCellValue(selRow, baseCol), APPLY_MODE, apply_value);
                        }
                        setCalcBaseColumn(sheetObj, selRow, baseCol, apply_GRPB[key_cd]);
                        //log("processCalcApplyRHQ] new GRPB=" + apply_GRPB[key_cd]);
                        break;
                } // end switch
                calculationOneRHQ(sheetObj, load_row, col, baseCol);
                selRow++;
            } // end while
            calculationOneTOTAL(lane_grp_cd, sheetObj, col, baseCol);
        } // end with
}

function trdGrpAdjSheet_FinalConfirm(sheetObj, formObject, sAction) {
    if (!ComShowConfirm(getMsg("SAQ90139", "Notify"))) {
        return;
    }
    if (sheetObj.RowCount() == 0) return;
    formObject.f_cmd.value = MODIFY12;
    doActionIBSheet(sheetObjects[3], formObject, IBSEARCH_ASYNC01);
}

function check_click() {
    //log("check_click] f_cmd=" + document.form.f_cmd.value + "//");
}

function changeSetFinalAllCheck(sheetObj, colName) {
    if (sheetObj.RowCount() == 0) {
        return;
    }
    var otherColName;
    var check_cd = "0";
    if (colName == "chk_rhq") {
        otherColName = "chk_trd_grp";
    } else {
        otherColName = "chk_rhq";
    }
    with(sheetObj) {
        var head = GetCellImage(HeaderRows() - 1, colName);
        SetCellImage(HeaderRows() - 1, otherColName, ICO_UNCHECK_IDX);
        if (head == GetImageList(ICO_CHECK_IDX)) {
            check_cd = "0";
            SetCellImage(HeaderRows() - 1, colName, ICO_UNCHECK_IDX);
        } else if (head == GetImageList(ICO_UNCHECK_IDX)) {
            check_cd = "1";
            SetCellImage(HeaderRows() - 1, colName, ICO_CHECK_IDX);
        }
        if (check_cd == 0) {
            var findRow = 0;
            while (findRow != -1) {
                findRow = sheetObjects[3].FindText(colName, "1", findRow + 1);
                SetCellValue(findRow, colName, check_cd, 0);
            }
        } else {
            for (var i = HeaderRows(); i <= LastRow(); i++) {
                if (GetCellEditable(i, colName) == true) {
                    SetCellValue(i, colName, check_cd, 0);
                    if (GetCellValue(i, otherColName) == "1") {
                        SetCellValue(i, otherColName, "0", 0);
                    }
                }
            }
        }
    }
}

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
    //    		if (portFlag == "N") return;
    var objSub_trd = formObj.search_sub_trd_cd;
    var selSub_trd = objSub_trd.value;
    var bse_mon = formObj.target_month.value.substring(4);
    var params = "&mqta_step_cd=" + MQTA_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&trd_cd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&bse_mon=" + bse_mon;
    getSelectCodeList(objSub_trd, "SaqMonQtaTrdSubtrd", params, true);
    if (objSub_trd.options.length == 0) {
        objSub_trd.options[0] = new Option("ALL", "");
    } else {
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
        getSelectCodeList(objRlane, "SaqMonQtaTrdLane", params, true);
        if (objRlane.options.length == 0) {
            objRlane.options[0] = new Option("ALL", "");
        } else {
            var selChk = false;
            for (i = 0; i < objRlane.length; i++) {
                if (objRlane.options[i].value == selLane) {
                    selChk = true;
                    break;
                }
            }
            if (selChk == true && selLane != "") {
                objRlane.value = selLane;
            } else {
                objRlane.selectedIndex = 0;
            }
        }
    }
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

// rhqAdjSheet rlane_cd setting
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

function openMonthlyAdj() {
    //          var srcName=ComGetEvent("name");
    var formObj = document.form;
    //            formObj.f_cmd.value = SEARCHLIST;

    var params = "gline_ver_no=" + formObj.glineVerNo.value + "&mqta_step_cd=" + WORK_STEP_CD + "&bse_yr=" + getParam(saveParams, "year") + "&bse_qtr_cd=" + getParam(saveParams, "bse_quarter") + "&trdCd=" + getParam(saveParams, "trade") + "&dir_cd=" + getParam(saveParams, "bound") + "&mqta_ver_no=" + getParam(saveParams, "mQtaVerNo") + "&unit=" + formObj.unit.value;
    var width = 850;
    var height = 500;
    //log("openMonthlyAdj] Popup prams=" + params);
    //            var callback = "";
    var callback = "callbackRemark";
    ComOpenPopupScroll("ESM_SAQ_0147.do?" + params, width, height, callback, "0,0", true);
    //window.open("ESM_SAQ_0147.do?"+params, width, height, callback,"0,0", true);
}

function clearTabSearchParams() {
    for (var i = 0; i < tabSearchParams.length; i++) {
        tabSearchParams[i] = "";
    }
}

function openUSModeAdj() {
    if (sheetObjects[3].IsDataModified()) {
        ComShowMessage(getMsg("SAQ90130"));
        return false;
    }
    var width = 800;
    var height = 500;
    var params = replaceParams(saveParams, "mQtaStepCd", WORK_STEP_CD);
    //            var params = saveParams+"&login_ofc_cd="+document.form.login_ofc_cd.value;;
    //    		if(isFinalVersion()){
    //    		    params = replaceParams(params,"yqta_step_cd","03");
    //    		}
    //    		log("openUSModeAdj] Popup params=" + params);
    var callback = "callbackUSModeAdj";
    ComOpenPopupScroll("/opuscntr/ESM_SAQ_0157.do?" + params, width, height, callback, "0,0", true);
    callbackUSModeAdj();
}

function callbackUSModeAdj() {
    if (window.isParentRefresh == true) {
        doActionIBSheet(sheetObjects[3], document.form, IBSEARCH);
    }
}

// Excel Upload
function excelimportexport() {
    var formObj = document.form;
    var width;
    var height;
    width = 1030;
    height = 700;
    var callback = "";
    var params = "mQtaStepCd=" + WORK_STEP_CD + "&glineVerNo=" + getParam(saveParams, "glineVerNo") + "&mQtaVerNo=" + getParam(saveParams, "mQtaVerNo") + "&year=" + getParam(saveParams, "year") + "&bse_quarter=" + getParam(saveParams, "bse_quarter") + "&trade=" + getParam(saveParams, "trade") + "&bound=" + getParam(saveParams, "bound") + "&unit=" + getParam(saveParams, "unit") + "&inclPortFlag=N";
    ComOpenPopupScroll("ESM_SAQ_0176.do?" + params, width, height, callback, "0,0", true);
    callbackUSModeAdj();
}

function processUSModeMixButton() {
    var usmodediv = document.all.item("usmodediv");
    var trd_cd = getParseSaveParam(saveParams, "trade");
    var hostname = location.hostname;
    if (trd_cd == "TPS") {
        usmodediv.style.display = "Inline";
    } else {
        usmodediv.style.display = "none";
    }
}

function optionSetting() {
    SaqSearchOptionYear("year");
    SaqSearchOptionQuarter("bse_quarter");
    SaqSearchOptionTargetGroup("trade_group", document.form.ofcCd.value, false);
    SaqSearchOptionBound("bound", false);
    SaqSearchOptionComCode("unit", "CD00897", false);
    SaqSearchOptionYear("pfmc_fr_year");
    SaqSearchOptionMonth("pfmc_fr_month");
    SaqSearchOptionYear("pfmc_to_year");
    SaqSearchOptionMonth("pfmc_to_month");
}