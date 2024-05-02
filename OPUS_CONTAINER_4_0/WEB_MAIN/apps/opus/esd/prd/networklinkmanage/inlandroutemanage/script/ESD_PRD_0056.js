/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0056.js
 *@FileTitle  : USA-Empty 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/30
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESD_PRD_0056 : business script for ESD_PRD_0056
 */
function ESD_PRD_0056() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
	this.doIBSheetClear = doIBSheetClear;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
	this.chkMandatoryForAmerican = chkMandatoryForAmerican;
	this.chkCombindMode = chkMandatoryForAmerican;
	this.setCombindMode = setCombindMode;
	this.doActionIBSheet2 = doActionIBSheet2;
	this.checkFromTo4US = checkFromTo4US;
	this.chkRailLinkForMt = chkRailLinkForMt;
	this.checkMandatory = checkMandatory;
	this.checkRouteList = checkRouteList;
	this.validateLocation = validateLocation;
	this.checkSpChange = checkSpChange;
	this.checkJunk = checkJunk;
	this.checkRoute2 = checkRoute2;
	this.checkRoute4Mt = checkRoute4Mt;
	this.checkRoute3 = checkRoute3;
	this.checkLocCondition = checkLocCondition;
	this.checkDtlLocCondition = checkDtlLocCondition;
	this.getCOM_ENS_051_1 = getCOM_ENS_051_1;
	this.getOrgLoc = getOrgLoc;
	this.getDestLoc = getDestLoc;
	this.sheet1_OnChange = sheet1_OnChange;
	this.sheet2_OnChange = sheet2_OnChange;
	this.sheet2_OnPopupClick = sheet2_OnPopupClick;
	this.getVendor = getVendor;
	this.getNode = getNode;
	this.bottomFrmDisable = bottomFrmDisable;
	this.chkAmericanContinent = chkAmericanContinent;
	this.bottomFrmClear = bottomFrmClear;
	this.changeNodTy1 = changeNodTy1;
	this.changeNodTy2 = changeNodTy2;
	this.changeSelection = changeSelection;
	this.selectTml = selectTml;
	this.getCOM_ENS_061 = getCOM_ENS_061;
	this.selectLoc = selectLoc;
	this.getCOM_ENS_051 = getCOM_ENS_051;
	this.changeDeltFlg = changeDeltFlg;
}
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var maxPrioSeq = 0;
var i_origin = "";
var i_destination = "";
var validateData = "";
var retValidate = 0;
var priority_seq = "";
var comData1 = "";
var comData2 = "";
var min_state = 'MIN';
var cntrTpSizArray = new Array('d2_flg', 'd4_flg', 'd5_flg', 'd7_flg', 'o2_flg', 'o4_flg', 'a2_flg', 'a4_flg', 'r2_flg', 'r5_flg');
var cntrTpSizNmArray = new Array('D2', 'D4', 'D5', 'D7', 'O2', 'O4', 'A2', 'A4', 'R2', 'R5');

document.onclick = processButtonClick;
function setUpperCase(formObject) {
	formObject.from_cd.value = formObject.from_cd.value.toUpperCase();
	formObject.to_cd.value = formObject.to_cd.value.toUpperCase();
}
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	var dispaly;
	var classId;
	var param;
	var chkStr;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		var srcObj = ComGetEvent("nodeName");
		// var keyObj=window.event.keyCode;
		/** ************************* */
		switch (srcName) {
			case "btn_retrieve":
				setUpperCase(formObject);
				if (!checkInput()) {
					return false;
				}
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				bottomFrmClear(formObject);
				sheetObject1.RemoveAll();
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				var cntCd = formObject.cnt_cd.value;
				formObject.reset();
				formObject.cnt_cd.value = cntCd;
				break;
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				sheetObject1.RemoveAll();
				bottomFrmClear(formObject);
				break;
			case "btng_listlink":
				var oriLoc = "";
				var destLoc = "";
				if (sheetObject1.LastRow() != 0) {
					oriLoc = sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "lnk_org_loc");
					destLoc = sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "lnk_dest_loc");
				} else {
					sheetObject1.DataInsert(-1);
				}
				param = '?i_org_cd=' + oriLoc + '&i_dest_cd=' + destLoc + "&row=" + sheetObject1.GetSelectRow() + "&col=" + sheetObject1.GetSelectCol();
				myWin = ComOpenWindowCenter('ESD_PRD_0007.do' + param, 'compop', 750, 480, false, true);
				myWin.focus();
				break;
			case "btng_save":
				if (chkCombindMode(sheetObject1)) {
					doActionIBSheet2(sheetObject1, formObject, IBSAVE);
				}
				break;
			case "btng_rowadd":
				doActionIBSheet2(sheetObject1, formObject, IBINSERT);
				break;
			case "btng_rowcopy":
				doActionIBSheet2(sheetObject1, formObject, IBCOPYROW);
				break;
			case "btn_org_loc":
				dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
				classId = "COM_ENS_051";
				param = '?classId=' + classId;
				chkStr = dispaly.substring(0, 3);
				if (chkStr == "1,0") {
					ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getOrgLoc', dispaly, true);
				} else {
					ComShowMessage(ComGetMst('PRD90063'));
					return;
				}
				break;
			case "btn_dest_loc":
				dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
				classId = "COM_ENS_051";
				param = '?classId=' + classId;
				chkStr = dispaly.substring(0, 3)
				if (chkStr == "1,0") {
					ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getDestLoc', dispaly, true);
				} else {
					ComShowMessage(ComGetMst('PRD90063'));
					return;
				}
				break;
			case "btn_downexcel":
				if (sheetObject.RowCount() < 1) {// no data
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}

				break;
			case "btng_clear":
				sheetObject1.RowDelete(sheetObject1.LastRow(), 1)
				break;
			case "btng_new":
				sheetObject1.RemoveAll();
				bottomFrmClear(formObject);
				break;
			case "btng_saveas":
				if (!confirm(ComGetMsg('PRD90043'))) {
					break;
				}
				if (!chkCombindMode(sheetObject1)) {
					break;
				}
				var invIdx = formObject.i_inv.selectedIndex;
				if (chkAmericanContinent(formObject) && !chkMandatoryForAmerican(formObject, sheetObject1)) {
					break;
				}
				if (!checkRoute3(sheetObject1, formObject)) {
					break;
				}
				doActionIBSheet2(sheetObject1, formObject, MULTI02);
				break;
			case "ib_org_tml_btn":
				selectTml(formObject, 'IB_ORG_TML');
				break;
			case "ob_dest_tml_btn":
				selectTml(formObject, 'OB_DEST_TML');
				break;
			case "ib_dest_loc_btn":
				selectLoc(formObject, 'IB_DEST_LOC');
				break;
			case "ob_org_loc_btn":
				selectLoc(formObject, 'OB_ORG_LOC');
				break;
			case "ts_org_yd_btn":
				selectTml(formObject, 'TS_ORG_YD');
				break;
			case "ts_dest_yd_btn":
				selectTml(formObject, 'TS_DEST_YD');
				break;
			case "mt_org_yd_btn":
				selectTml(formObject, 'MT_ORG_YD');
				break;
			case "mt_dest_yd_btn":
				selectTml(formObject, 'MT_DEST_YD');
				break;
		}
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * 
 */
function doIBSheetClear(sheetObj) {
	var firstChk = false;
	var firstChkRow = 0;
	for (i = 1; i <= +sheetObj.RowCount(); i++) {
		if (firstChk == true && i > firstChkRow && sheetObj.GetCellValue(i, "clear_chk") != 1) {
			sheetObj.SetCellValue(i, "clear_chk", 1, 0);
		}
		if (sheetObj.GetCellValue(i, "clear_chk") == 1) {
			if (firstChk == false) {
				firstChk = true;
				firstChkRow = i;
			}
			sheetObj.SetCellValue(i, "lnk_org_loc", "", 0);
			sheetObj.SetCellValue(i, "lnk_org_type", "", 0);
			sheetObj.SetCellValue(i, "lnk_dest_loc", "", 0);
			sheetObj.SetCellValue(i, "lnk_dest_type", "", 0);
			sheetObj.SetCellValue(i, "trsp_mod_cd", "", 0);
			sheetObj.SetCellValue(i, "spname", "", 0);
			sheetObj.SetCellValue(i, "vndr_seq", "", 0);
			sheetObj.SetCellValue(i, "vndr_name", "", 0);
			sheetObj.SetCellValue(i, "tztm_hrs", "", 0);
			sheetObj.SetCellValue(i, "rail_crr_tp_cd", "", 0);
			sheetObj.SetCellValue(i, "inlnd_rout_junc_nm", "", 0);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'from_cd', 'to_cd');
	doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with(sheetObj) {
			  var HeadTitle="Del.|WRS|CHK|STS|ORG.LOC|Node|DEST.LOC|Node|INV Billing Patten|Route Plan|C/TOFC|Junction|C.User|C.Date|U.User|U.Date|D.User|D.Date|Constraint Y/N|Remarks" ;
			  HeadTitle += "|D2|D4|D5|D7|O2|O4|A2|A4|R2|R5";
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers = [ { Text:HeadTitle, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ 
			               	 {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delChk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
					         {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"wrs_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
					         {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"un_del",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
					         {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ori_loc",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"ori_loc_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc_type",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inv_bl_pt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_pl",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
					         {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"c_tofc",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
					         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"junc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cre_date",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_date",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"del_date",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"constraint",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"remark",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d2_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d4_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d5_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"d7_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o2_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"o4_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"a2_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"a4_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"r2_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"r5_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_org_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_dest_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } 
					    ];
			   
			  InitColumns(cols);
			  SetEditable(1);
			  SetSheetHeight(230);
			  SetColProperty("inv_bl_pt", 			{ ComboText : inv_bill_ptnCode, ComboCode : inv_bill_ptnCode });
			  SetColProperty("rout_pl", 			{ ComboText : rout_planCode, ComboCode : rout_planCode });
			  SetColProperty("c_tofc", 				{ ComboText : rail_crr_tp_cdCode, ComboCode : rail_crr_tp_cdCode });
			  SetSelectionMode(smSelectionFree);
			  SetColProperty(0, "ori_loc", 			{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
			  SetColProperty(0, "ori_loc_type", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
			  SetColProperty(0, "dest_loc", 		{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
			  SetColProperty(0, "dest_loc_type", 	{ AcceptKeys : "E|N", InputCaseSensitive : 1 });
        }
            break;
        case 2:
            with(sheetObj){
            
        var HeadTitle="Del.|STS|SEQ|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T(DD.HH)|AGMT No|Reference No|Combined Mode|C/TOFC|Junction|lnk_org_nod_cd|lnk_dest_nod_cd|clon_trsp_mod_cd|rout_org_nod_cd|rout_dest_nod_cd|rout_seq|rout_dtl_seq|selRow|clon_vndr_seq|clon_agmt_no|clon_combined_md|clon_rail_crr_tp_cd|clon_inlnd_rout_junc_nm" ;
        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        var headers = [ { Text:HeadTitle, Align:"Center"} ];
        InitHeaders(headers, info);
        var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibseq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_loc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
         {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
         {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_loc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
         {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_type",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
         {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trsp_mod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_name",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tztm_hrs",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
         {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"refe_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_cmb_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
         {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"rail_crr_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_junc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"clon_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_org_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_dest_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_dtl_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"selRow",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"clon_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"clon_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"clon_combined_md",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:1, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"clon_rail_crr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"clon_inlnd_rout_junc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
         
        InitColumns(cols);
        SetEditable(1);
        SetSheetHeight(180);
        ComResizeSheet(sheetObj, 80);
        SetColProperty(0, "trsp_mod_cd", 	{ComboText:trsp_mod_cdText, ComboCode:trsp_mod_cdCode} );
        SetColProperty(0, "rail_crr_tp_cd", {ComboText:rail_crr_tp_cdText, ComboCode:rail_crr_tp_cdCode} );
        SetColProperty(0, "tztm_hrs", 		{AcceptKeys:"N", Format:"##.##"} );
     	SetColProperty(0, "lnk_org_loc" , 	{AcceptKeys:"E|N" , InputCaseSensitive:1});
    	SetColProperty(0, "lnk_org_type" , 	{AcceptKeys:"E|N" , InputCaseSensitive:1});
    	SetColProperty(0, "lnk_dest_loc" , 	{AcceptKeys:"E|N" , InputCaseSensitive:1});
    	SetColProperty(0, "lnk_dest_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
    	SetColProperty(0, "vndr_seq" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
    	SetColProperty(0, "agmt_no" , 		{AcceptKeys:"E|N" , InputCaseSensitive:1});
        }
         break;
    }
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCHLIST;
				sheetObj.DoSearch("ESD_PRD_0056GS.do", PrdFQString(formObj), { Sync : 2 });
			}
			break;
		case IBSAVE:
			formObj.f_cmd.value = MULTI;
			var iCheckRow = sheetObj.FindCheckedRow("delChk");
			if (iCheckRow != "") {
				if (!confirm(ComGetMsg('PRD90078'))) {
					break;
				}
			}
			sheetObj.DoSave("ESD_PRD_0056GS.do", {Param : PrdFQString(formObj), Quest:1});
			break;
		case IBCOPYROW:
			sheetObj.DataCopy();
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			uid = "ESD_PRD_0005";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case SEARCH05:
			formObj.f_cmd.value = SEARCH05;
			uid = "ESD_PRD_0005";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			sParam = PrdFQString(formObj);
			var sXml = sheetObj.GetSearchData("ESD_PRD_0056GS.do", sParam);
			formObj.cnt_cd.value = ComGetEtcData(sXml, "cnt_cd");
			break;
	}
}

/**
 * 
 */
function sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	if (errCode >= 0) {
		 ComShowCodeMessage('COM132601');
		 doActionIBSheet(sheetObj, document.form, IBSEARCH);
	}
}

/**
 * 
 */
function sheet1_OnDblClick(sheetObj, row, col, value) {
	var formObj = document.form;
	formObj.i_selrow.value = row;
	formObj.i_rout_seq.value = sheetObj.GetCellValue(row, "rout_seq");
	doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH); // sheetObjects[1]->sheet2
}

/**
 * 
 */
function chkMandatoryForAmerican(formObj, sheetObj) {
	var invIdx = formObj.i_inv.selectedIndex;
	var routPlnIdx = formObj.i_rout_pln_cd.selectedIndex;
	var findRd = false;
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
		sheetObj.FindText("trsp_mod_cd", "RAIL", i, -1) != -1 ? findRd = true : "";
		if (findRd) {
			break;
		}
			
	}
	if (findRd) {
		if (invIdx == 0) {
			ComShowMessage(ComGetMsg('PRD90017'));
			formObj.i_inv.focus();
			return false;
		}
		if (routPlnIdx == 0) {
			ComShowMessage(ComGetMsg('PRD90018'));
			formObj.i_rout_pln_cd.focus();
			return false;
		}
		for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
			if (sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD") {
				if (sheetObj.GetCellValue(i, "agmt_no") == "" || sheetObj.GetCellValue(i, "refe_no") == "") {
					ComShowMessage(ComGetMsg('PRD90037'));
					sheetObj.SelectCell(i, "agmt_no");
					return false;
				}
				if (sheetObj.GetCellValue(i, "rail_crr_tp_cd") == "") {
					ComShowMessage(ComGetMsg('PRD90038'));
					sheetObj.SelectCell(i, "rail_crr_tp_cd");
					return false;
				}
			} else {
				if (sheetObj.GetCellValue(i, "agmt_no") != "" || sheetObj.GetCellValue(i, "refe_no") != "") {
					ComShowMessage(ComGetMsg('PRD90039'));
					sheetObj.SelectCell(i, "agmt_no");
					return false;
				}
				if (sheetObj.GetCellValue(i, "rail_crr_tp_cd") != "") {
					ComShowMessage(ComGetMsg('PRD90040'));
					sheetObj.SelectCell(i, "rail_crr_tp_cd");
					return false;
				}
			}
		}
	}
	return true;
}

/**
 * 
 */
function chkCombindMode(sheetObj) {
	var formObj = document.form;
	var inv = formObj.i_inv.value;
	var firstRD = false;
	var lastRD = false;
	var firstRow = 0;
	var lastRow = 0;
	var combindChk = true;
	var rdLink1 = false;
	var rdLink2 = false;
	var rdLink3 = false;
	var chkCnt = 0;
	var rdCnt = 0;
	if (inv.substring(0, 1) == 'C') { // || inv.substring(0,1) == 'S'
		for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
			if (firstRD == false && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD") {
				firstRD = true;
				firstRow = i;
				lastRow = firstRow;
				rdCnt++;
			} else if (firstRD == true && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD") {
				lastRow = i;
				rdCnt++;
			}
			if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
				chkCnt++;
			}
				
		}
		
		if (eval(lastRow - firstRow) > 2 || rdCnt > 3) {
			combindChk = false;
			ComShowMessage(ComGetMsg('PRD90021'));
			return combindChk;
		}
		
		if (rdCnt == 3 && eval(lastRow - firstRow) == 2) {
			if (ComIsContainsChars(formObj.i_inv, "3") != true) {
				ComShowMessage(ComGetMsg('PRD90034'));
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					// rd range
					if (i < firstRow || i > lastRow) {
						combindChk = false;
						ComShowMessage(ComGetMsg('PRD90021'));
						return combindChk;
					}
				} else {
					if (i >= firstRow && i <= lastRow) {
						combindChk = false;
						ComShowMessage(ComGetMsg('PRD90021'));
						return combindChk;
					}
				}
			}
			// when including the RD-RD
		} else if (rdCnt == 2 && eval(lastRow - firstRow) == 1) { // if it has two consecutive rds
			if (ComIsContainsChars(formObj.i_inv, "2") != true) {
				ComShowMessage(ComGetMsg('PRD90034'));
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					// out of range of rd
					if (i < firstRow || i > lastRow) {
						combindChk = false;
						ComShowMessage(ComGetMsg('PRD90021'));
						return combindChk;
					}
				} else {
					if (i >= firstRow && i <= lastRow) {
						combindChk = false;
						ComShowMessage(ComGetMsg('PRD90021'));
						return combindChk;
					}
				}
			}
			// when the number of rd is 2 and it is RD-TD-RD
		} else if (rdCnt == 2 && eval(lastRow - firstRow) == 2) {
			if (ComIsContainsChars(formObj.i_inv, "1") != true) {
				ComShowMessage(ComGetMsg('PRD90034'));
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					combindChk = false;
					ComShowMessage(ComGetMsg('PRD90021'));
					return combindChk;
				}
			}
		} else if (rdCnt == 1) {
			if (ComIsContainsChars(formObj.i_inv, "1") != true) {
				ComShowMessage(ComGetMsg('PRD90034'));
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					combindChk = false;
					ComShowMessage(ComGetMsg('PRD90021'));
					return combindChk;
				}
			}
		} else if (rdCnt == 0) {
			var invIdx = formObj.i_inv.selectedIndex;
			if (invIdx > 0) {
				ComShowMessage(ComGetMsg('PRD90034'));
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					combindChk = false;
					ComShowMessage(ComGetMsg('PRD90021'));
					return combindChk;
				}
			}
		}
	} else {
		var sp = '';
		var firstCombindMode = false;
		var firstCombindCnt = 0;
		for ( var j = sheetObj.HeaderRows(); j < sheetObj.LastRow() + 1; j++) {
			if (sheetObj.GetCellValue(j, "inlnd_rout_cmb_flg") == 1 && !firstCombindMode && sheetObj.RowCount() > 1) { // in case of first combind
				sp = sheetObj.GetCellValue(j, "vndr_seq");
				firstCombindMode = true;
				firstCombindCnt++;
			} else if (sheetObj.GetCellValue(j, "inlnd_rout_cmb_flg") == 1 && firstCombindMode == true && sheetObj.RowCount() > 1) { // after first combind
				if (sp != sheetObj.GetCellValue(j, "vndr_seq")) {
					ComShowMessage(ComGetMsg('PRD90022'));
					combindChk = false;
					return combindChk;
				}
			} else if (sheetObj.GetCellValue(j, "inlnd_rout_cmb_flg") == 1 && sheetObj.RowCount() == 1) { // when there is 1 data
				ComShowMessage(ComGetMsg('PRD90021'));
				combindChk = false;
				return combindChk;
			} else if (firstCombindMode == true && firstCombindCnt < 2) { // when there is 1 checked data
				ComShowMessage(ComGetMsg('PRD90024'));
				combindChk = false;
				return combindChk;
			}
		}// for
	}
	return combindChk;
}
// in case of selecting INV Billing
function setCombindMode() {
	var sheetObj = sheetObjects[1];
	var formObj = document.form;
	var inv = formObj.i_inv.value;
	var firstRD = false;
	var lastRD = false;
	var firstRow = 0;
	var lastRow = 0;
	sheetObj.CheckAll("inlnd_rout_cmb_flg", 0);
	// finding first and last row which is RD
	if (inv.substring(0, 1) == 'C') { // || inv.substring(0,1) == 'S'
		for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
			if (firstRD == false && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD") {
				firstRD = true;
				firstRow = i;
				lastRow = firstRow;
			} else if (firstRD == true && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD") {
				lastRow = i;
			}
		}
		// checking RD from the beginning to the end(not checking when it is RTR and the number of RD is 1)
		if (firstRow > 0) {
			for (j = firstRow; j <= lastRow; j++) {
				// checking when the number of RD is 2 or 3
				if (eval(lastRow - firstRow) == 1 || eval(lastRow - firstRow) == 2) {
					sheetObj.SetCellValue(j, "inlnd_rout_cmb_flg", 1, 0);
				}
			}
		}
	}
}
// handling of Sheet process
function doActionIBSheet2(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	var rout_org_nod_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_org_nod_cd");
	var rout_dest_nod_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_dest_nod_cd");
	var rout_seq = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_seq");
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH;
				formObj.i_rout_org_nod_cd.value = rout_org_nod_cd;
				formObj.i_rout_dest_nod_cd.value = rout_dest_nod_cd;
				formObj.i_rout_seq.value = rout_seq;
				sheetObj.DoSearch("ESD_PRD_0056DETAIL_GS.do", PrdFQString(formObj), { Sync : 2 });
				ComEtcDataToForm(formObj, sheetObj);
				formObj.detail_org_i_inv.value = sheetObj.GetEtcData("i_inv");
				formObj.detail_org_i_rout_pln_cd.value = sheetObj.GetEtcData("i_rout_pln_cd");
			}
			break;
		case IBSAVE:
			if (validateForm(sheetObj, formObj, sAction)) {
				var isNew = true;
				for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
					if (isNew && sheetObj.GetRowStatus(i) == 'I') {
						isNew = true;
					} else {
						isNew = false;
					}
					var trspModCode = sheetObj.GetCellValue(i, 'trsp_mod_cd');
					if (trspModCode != 'RD') {
						ComShowCodeMessage('PRD00082', trspModCode == 'TD' ? 'Truck' : 'Water');
						return false;
					}
				}
				if (!checkRoute4Mt(sheetObj, formObj)) {
					return false;
				}
					
				if (!checkFromTo4US(sheetObj)) {
					ComShowCodeMessage('PRD90111');
					return false;
				} else {
					if (!chkMandatoryForAmerican(formObj, sheetObj)) {
						return false;
					}
					if (!chkRailLinkForMt(sheetObj)) {
						return false;	
					}
					if (!checkSpChange(sheetObj)) {
						ComShowCodeMessage('PRD90080');
						return false;
					}
					if (!checkJunk(sheetObj)) {
						ComShowCodeMessage('PRD90081');
						return false;
					}
                    if( !checkWRS(sheetObj , 'M')) {
                    	ComShowCodeMessage('PRD90079');
                        return false;
                    }   					
				}
				// inserting row on master when creating new detail
				if (isNew) {
					sheetObjects[0].DataInsert(-1);
					formObj.i_selrow.value = sheetObjects[0].LastRow(); // row number of master which will be set after saving detail
				}
				formObj.f_cmd.value = MULTI01;
				var SaveStr = sheetObj.GetSaveString(true);
				if (sheetObj.IsDataModified() && SaveStr == "")
					return;
				sXml = sheetObj.GetSaveData("ESD_PRD_0056MST_ROWSEARCH.do", SaveStr + "&" + PrdFQString(formObj) + "&isNew=" + isNew);
				var strErrMsg = ComGetEtcData(sXml, 'strErrMsg');
				if (strErrMsg != '') {
					// error if same route is exists
					ComShowMessage(strErrMsg);
					if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) == 'I') {
						sheetObjects[0].RowDelete(sheetObjects[0].GetSelectRow(), false);
					}
				} else {
					sheetObj.RemoveAll();
					bottomFrmClear(formObj);
					formObj.i_org_cd.value = i_origin;
					formObj.i_dest_cd.value = i_destination;
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				}
			}
			break;
		case MULTI02: // SAVEAS
			formObj.f_cmd.value = MULTI02;
			var updateRow = false;
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetRowStatus(i) != 'R') {
					updateRow = true;
					break;
				}
			}
			// checking data excepting grid
			var detail_org_i_inv = formObj.detail_org_i_inv.value;
			var detail_org_i_rout_pln_cd = formObj.detail_org_i_rout_pln_cd.value;
			var detail_org_i_bkg_flg = formObj.detail_org_i_bkg_flg.value;
			
            var detail_org_i_wrs_fl_cd = formObj.detail_org_i_wrs_fl_cd.value ;
            var detail_org_i_wrs_mt_cd = formObj.detail_org_i_wrs_mt_cd.value ;
            
			var i_inv = formObj.i_inv.value;
			var i_rout_pln_cd = formObj.i_rout_pln_cd.value;
			var i_bkg_flg = formObj.i_bkg_flg.value;
			
            var i_wrs_fl_cd = formObj.i_wrs_fl_cd.value ;
            var i_wrs_mt_cd = formObj.i_wrs_mt_cd.value ;   
            
			var etcInDataUpdate = true;
			
			
			if (detail_org_i_inv == i_inv && detail_org_i_rout_pln_cd == i_rout_pln_cd && detail_org_i_bkg_flg == detail_org_i_bkg_flg &&  detail_org_i_wrs_fl_cd == i_wrs_fl_cd && detail_org_i_wrs_mt_cd ==i_wrs_mt_cd) {
				etcInDataUpdate = false;
			}
			if (updateRow || etcInDataUpdate) {
				if (chkAmericanContinent(formObj)) {
					if (!chkMandatoryForAmerican(formObj, sheetObj)) {
						return false;
					}
					if (!checkJunk(sheetObj)) {
						ComShowCodeMessage("PRD90081");
						return false;
					}
                    
                    if( !checkWRS(sheetObj , 'M')) {
                    	ComShowCodeMessage("PRD90079");
                    	return false;
                    } 					
				}
				
				sheetObjects[0].DataInsert(-1);
				formObj.i_selrow.value = sheetObjects[0].LastRow();
				var SaveStr = sheetObj.GetSaveString(true);
				sXml = sheetObj.GetSaveData("ESD_PRD_0005MST_ROWSEARCH.do", SaveStr + "&" + PrdFQString(formObj));
				var strErrMsg = ComGetEtcData(sXml, 'strErrMsg');
				if (strErrMsg == '') {
					maxPrioSeq = ComGetEtcData(sXml, 'maxPrioSeq');
					bottomFrmClear(formObj);
					formObj.i_org_cd.value = i_origin;
					formObj.i_dest_cd.value = i_destination;

					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					sheetObjects[1].RemoveAll();
				} else {
					ComShowMessage(strErrMsg);
					sheetObjects[0].RowDelete(sheetObjects[0].LastRow(), false);
				}
			} else {
				ComShowCodeMessage('PRD90042');
			}
			break;
		case IBINSERT:
			if (validateForm(sheetObj, formObj, sAction)) {
				var modRoutOrgLoc = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_org_loc");
				var modRoutOrgType = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_org_type");
				var modRoutDestLoc = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc");
				var modRoutDestType = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type");
				if (sheetObj.RowCount() > 0) {
					if (modRoutOrgLoc.length > 0 && modRoutDestLoc.length > 0) {
						var row = sheetObj.DataInsert(-1);
						sheetObj.SetRowEditable(row, 1);
						sheetObj.SetCellValue(sheetObj.LastRow(), "lnk_org_loc", modRoutDestLoc, 0);
						sheetObj.SetCellValue(sheetObj.LastRow(), "lnk_org_type", modRoutDestType, 0);
					} else {
						ComShowCodeMessage('PRD90025');
						return;
					}
				} else {
					var row = sheetObj.DataInsert(-1);
					sheetObj.SetRowEditable(row, 1);
				}
			}
			break;
		case SEARCH08:
			formObj.f_cmd.value = SEARCH08;
			uid = "ESD_PRD_0005";
			sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			comData1 = ComGetEtcData(sXml, "comData1");
			comData2 = ComGetEtcData(sXml, "comData2");
			if (retValidate < 1) {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_name", comData2, 0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_seq", "", 0);
				sheetObj.SelectCell(sheetObj.GetSelectRow(), "vndr_seq");
			} else {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_name", comData2, 0);
			}
			break;
		case IBCOPYROW:
			sheetObj.DataCopy();
			break;
	}
}
// for empty
function checkFromTo4US(sheetObj) {
	var fromNod = sheetObj.GetCellValue(parseInt(sheetObj.HeaderRows()), "lnk_org_loc");
	var toNod = sheetObj.GetCellValue(parseInt(sheetObj.LastRow()), "lnk_dest_loc");
	var org = fromNod.substring(0, 2);
	var des = toNod.substring(0, 2);
	if (chkAmericaCntCd(org) && chkAmericaCntCd(des)) {
		return true;
	}
	return false;
}
function chkRailLinkForMt(sheetObj) {
	if (sheetObj.GetCellValue(parseInt(sheetObj.HeaderRows()), "trsp_mod_cd") != "RD" || sheetObj.GetCellValue(sheetObj.LastRow(), "trsp_mod_cd") != "RD") {
		ComShowCodeMessage('PRD90082');
		return false;
	}
	return true;
}

/**
 * Check WRS
 */
function checkWRS(sheetObj, irgGb) {
	var formObj = document.form;
	var inv = formObj.i_inv.value;
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + sheetObj.HeaderRows(); i++) {
		var cTofc = sheetObj.GetCellValue(i, "rail_crr_tp_cd");
		var sp = sheetObj.GetCellValue(i, "vndr_seq");
		if (inv == 'S2R') {
			if (formObj.wrs_chk.checked) {
				formObj.i_inv.focus();
				return false;
			}
		}
		if (cTofc.substring(0, 1) == 'T') {
			if (formObj.wrs_chk.checked) {
				sheetObj.SelectCell(i, "rail_crr_tp_cd");
				return false;
			}
		}
		if (sp == '108386') {
			if (formObj.wrs_chk.checked) {
				sheetObj.SelectCell(i, "vndr_seq");
				return false;
			}
		}
	}
	return true;
}
/*
 * checking Mandatory
 */
function checkMandatory() {
	var formObj = document.form;
	var retValue = true;
	var gubun = '';
	for (i = 0; i < formObj.r_inbound.length; i++) {
		if (formObj.r_inbound[i].checked) {
			gubun = formObj.r_inbound[i].value;
		}
	}
	if (gubun == 'I') {
		orgCd = formObj.i_org_cd_ib.value;
		destCd = formObj.i_dest_cd_ib.value;
		formObj.i_org_cd.value = formObj.i_org_cd_ib.value;
		formObj.i_dest_cd.value = formObj.i_dest_cd_ib.value;
		if ((orgCd.length != 7) || (destCd.length != 5))
			retValue = false;
	}
	if (gubun == 'O') {
		orgCd = formObj.i_org_cd_ob.value;
		destCd = formObj.i_dest_cd_ob.value;
		formObj.i_org_cd.value = formObj.i_org_cd_ob.value;
		formObj.i_dest_cd.value = formObj.i_dest_cd_ob.value;
		if ((orgCd.length != 5) || (destCd.length != 7))
			retValue = false;
	}
	if (gubun == 'T') {
		orgCd = formObj.i_org_cd_ts.value;
		destCd = formObj.i_dest_cd_ts.value;
		formObj.i_org_cd.value = formObj.i_org_cd_ts.value;
		formObj.i_dest_cd.value = formObj.i_dest_cd_ts.value;
		if ((orgCd.length != 5) || (destCd.length != 5))
			retValue = false;
	}
	if (gubun == 'M') {
		orgCd = formObj.i_org_cd_mt.value;
		destCd = formObj.i_dest_cd_mt.value;
		formObj.i_org_cd.value = formObj.i_org_cd_mt.value;
		formObj.i_dest_cd.value = formObj.i_dest_cd_mt.value;
		if ((orgCd.length != 7) || (destCd.length != 7))
			retValue = false;
	}
	if (!retValue) {
		ComShowCodeMessage('PRD90007');
	}
	return retValue;
}
function checkRouteList(sheetObject) {
	var retValue = true;
	var sIRow = sheetObject.FindStatusRow("I");
	if (sIRow.length > 0) {
		sIRow = sIRow + ";";
	}
	var arIRow = sIRow.split(";");
	if (arIRow.length > 1) {
		ComShowCodeMessage('PRD90026');
		retValue = false;
	}
	return retValue;
}
/**
 * 
 */
function validateLocation(loc, num) {
	if (num == 1) {
		document.form.i_org_cd.value = loc.toUpperCase();
	} else if (num == 2) {
		document.form.i_dest_cd.value = loc.toUpperCase();
	}
	
	validateData = loc.toUpperCase();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	if (retValidate < 1) {
		if (num == 1) {
			document.form.i_org_cd.focus();
		} else if (num == 2) {
			document.form.i_dest_cd.focus();
		}
	} else {
		if (num == 1) {
			document.form.i_dest_cd.focus();
		}
	}
	return false;
}

/**
 * 
 */
function checkSpChange(sheetObj) {
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
		if (sheetObj.GetRowStatus(i) == 'I') {
			return true;
		}
			
	}
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
		if (sheetObj.GetRowStatus(i) != 'R') {
			if (sheetObj.GetCellValue(i, "lnk_org_nod_cd") == sheetObj.GetCellValue(i, "lnk_org_loc") + sheetObj.GetCellValue(i, "lnk_org_type") 
					|| sheetObj.GetCellValue(i, "lnk_dest_nod_cd") == sheetObj.GetCellValue(i, "lnk_dest_loc") + sheetObj.GetCellValue(i, "lnk_dest_type")
					|| sheetObj.GetCellValue(i, "clon_trsp_mod_cd") == sheetObj.GetCellValue(i, "trsp_mod_cd")
				) {
				if (sheetObj.GetCellValue(i, "trsp_mod_cd") != "RD") {
					if (sheetObj.GetCellValue(i, "clon_agmt_no") != sheetObj.GetCellValue(i, "agmt_no") || sheetObj.GetCellValue(i, "clon_combined_md") != sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg")
							|| sheetObj.GetCellValue(i, "clon_inlnd_rout_junc_nm") != sheetObj.GetCellValue(i, "inlnd_rout_junc_nm")) {
						return false;
					}
				} else if ((sheetObj.GetCellValue(i, "clon_agmt_no") != "" && sheetObj.GetCellValue(i, "clon_agmt_no") != sheetObj.GetCellValue(i, "agmt_no")) || sheetObj.GetCellValue(i, "clon_rail_crr_tp_cd") != sheetObj.GetCellValue(i, "rail_crr_tp_cd") || sheetObj.GetCellValue(i, "clon_vndr_seq") != sheetObj.GetCellValue(i, "vndr_seq")) {
					return false;
				}
			} else {
				return false;
			}
		}
	}
	return true;
}
// JUNK validation when it has USA Rail
function checkJunk(sheetObj) {
	var nextIdx = 0;
	var totRowCnt = sheetObj.HeaderRows() + sheetObj.RowCount();
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
		nextIdx = i + 1;
		if (nextIdx < totRowCnt && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD" && sheetObj.GetCellValue(nextIdx, "trsp_mod_cd") == "RD") {
			if (ComIsEmpty(sheetObj.GetCellValue(i, "inlnd_rout_junc_nm"))) {
				return false;
			}
		} else if (i == sheetObj.RowCount() && !ComIsEmpty(sheetObj.GetCellValue(i, "inlnd_rout_junc_nm"))) {
			return false;
		}
	}// for
	return true;
}
/*
 * check connection
 */
function checkRoute2(sheetObj, formObj) {
	var k = 0;
	var modRoutOrgLoc = "";
	var modRoutDestLoc = "";
	var routOrgNod = new Array();
	var routDestNod = new Array();
	routOrgNod[k] = "";
	routDestNod[k] = "";
	var sURow = sheetObj.FindStatusRow("U");
	if (sURow.length > 0) {
		sURow = sURow + ";";
	}
	// putting received result into array
	var arURow = sURow.split(";");
	var sIRow = sheetObj.FindStatusRow("I");
	if (sIRow.length > 0) {
		sIRow = sIRow + ";";
	}
	// putting received result into array
	var arIRow = sIRow.split(";");
	formObj.i_new_route_cd.value = "";
	// in case of updating Route, checking it is same with value of master
	// checking it is updated (arURow.length > 1)
	var gubun = '';
	for (i = 0; i < formObj.r_inbound.length; i++) {
		if (formObj.r_inbound[i].checked) {
			gubun = formObj.r_inbound[i].value;
		}
	}
	// new Route
	if (arIRow.length >= 2 && arURow.length == 1) {
		formObj.i_new_route_cd.value = "Y";
		formObj.i_rout_seq.value = 0;
		formObj.i_rout_org_nod_cd.value = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type");
		formObj.i_rout_dest_nod_cd.value = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type");
		// ComShowMessage("new rout::"+formObj.i_rout_org_nod_cd.value+", "+formObj.i_rout_dest_nod_cd.value);
		// checking if search conditions are same with loc of ori, dest
		var org_loc = formObj.i_org_cd.value;
		var dest_loc = formObj.i_dest_cd.value;
		// handling according to IN/OUT/BOTH
		if (gubun == 'I') {
			if (org_loc != sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type") || dest_loc != sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc")) {
				ComShowMessage(ComGetMsg('PRD90028'));
				return false;
			}
		} else if (gubun == 'O') {
			// 'O' 5 digits , 7 digits
			if (org_loc != sheetObj.GetCellValue(1, "lnk_org_loc") || dest_loc != sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type")) {
				ComShowMessage(ComGetMsg('PRD90028'));
				return false;
			}
		} else if (gubun == 'B') {
			// 'B' 5 digits , 5 digits
			if (org_loc != sheetObj.GetCellValue(1, "lnk_org_loc") || dest_loc != sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc")) {
				ComShowMessage(ComGetMsg('PRD90028'));
				return false;
			}
		} else if (gubun == 'M') {
			// 'M' 7 digits , 7 digits
			if (org_loc != sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type") || dest_loc != sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type")) {
				ComShowMessage(ComGetMsg('PRD90028'));
				return false;
			}
		}
	} else {
		if (arURow.length > 1) {
			formObj.i_new_route_cd.value = "N";
		}
		var hRoutOrgNodCd = formObj.i_rout_org_nod_cd.value; // master org of route which will be modified
		var hRoutDestNodCd = formObj.i_rout_dest_nod_cd.value; // master dest of route which will be modified
		var firstRoutOrgNodCd = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type"); // first org of modified route
		var lastRoutDestNodCd = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type"); // last dest of modified route
		// in case of updating, the first and last ones before modifying should be same with the ones after modifying(because it is key value of master table)
		if (hRoutOrgNodCd != firstRoutOrgNodCd || hRoutDestNodCd != lastRoutDestNodCd) {
			ComShowMessage(ComGetMsg('PRD90029'));
			return false;
		}
	}
	// it is also possible to modify master data only as well as update or create each link(Y: insert, N:update, M:master update)
	if (formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N") {
		formObj.i_new_route_cd.value = "M";
	}
	// putting into array to know the connection later. if rows are cleared, it can be judged as 'Delete'
	for (i = 1; i <= sheetObj.RowCount(); i++) {
		routOrgNod[k] = sheetObj.GetCellValue(i, "lnk_org_loc") + sheetObj.GetCellValue(i, "lnk_org_type");
		routDestNod[k] = sheetObj.GetCellValue(i, "lnk_dest_loc") + sheetObj.GetCellValue(i, "lnk_dest_type");
		k++;
	}
	var j = 0;
	// checking connection
	for (i = 0; i < routOrgNod.length; i++) {
		if (sheetObj.RowCount() == 1) {
			return true;
		} else {
			j = i + 1;
		}
		if (routDestNod[i] == routOrgNod[j]) { // the number of rows are more than 2
			if (j == (routOrgNod.length - 1))
				return true;
		} else {
			ComShowMessage(ComGetMsg('PRD90030'));
			return false;
		}
	}
}
// checking Empty connection
function checkRoute4Mt(sheetObj, formObj) {
	var k = 0;
	var modRoutOrgLoc = "";
	var modRoutDestLoc = "";
	var routOrgNod = new Array();
	var routDestNod = new Array();
	routOrgNod[k] = "";
	routDestNod[k] = "";
	var sURow = sheetObj.FindStatusRow("U");
	if (sURow.length > 0) {
		sURow = sURow + ";";
	}
	// putting received result into array
	var arURow = sURow.split(";");
	var sIRow = sheetObj.FindStatusRow("I");
	if (sIRow.length > 0) {
		sIRow = sIRow + ";";
	}
	// putting received result into array
	var arIRow = sIRow.split(";");
	formObj.i_new_route_cd.value = "";
	// new Route
	if (arIRow.length >= 2 && arURow.length == 1) {
		formObj.i_new_route_cd.value = "Y";
		formObj.i_rout_seq.value = 0;
		formObj.i_rout_org_nod_cd.value = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type");
		formObj.i_rout_dest_nod_cd.value = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type");
	} else {
		if (arURow.length > 1) {
			formObj.i_new_route_cd.value = "N";
		}
		var hRoutOrgNodCd = formObj.i_rout_org_nod_cd.value; // master org route which will be modified
		var hRoutDestNodCd = formObj.i_rout_dest_nod_cd.value; // master dest route which will be modified
		var firstRoutOrgNodCd = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type"); // first org route which is modified
		var lastRoutDestNodCd = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type"); // last dest route which is modified
		// in case of updating, the first and last ones before modifying should be same with the ones after modifying(because it is key value of master table)
		if (hRoutOrgNodCd != firstRoutOrgNodCd || hRoutDestNodCd != lastRoutDestNodCd) {
			ComShowMessage(ComGetMsg('PRD90083'));
			return false;
		}
	}
	// it is also possible to modify master data only as well as update or create each link(Y: insert, N:update, M:master update)
	if (formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N") {
		formObj.i_new_route_cd.value = "M";
	}
	// putting into array to know the connection later. if rows are cleared, it can be judged as 'Delete'
	for (i = 1; i <= sheetObj.RowCount(); i++) {
		routOrgNod[k] = sheetObj.GetCellValue(i, "lnk_org_loc") + sheetObj.GetCellValue(i, "lnk_org_type");
		routDestNod[k] = sheetObj.GetCellValue(i, "lnk_dest_loc") + sheetObj.GetCellValue(i, "lnk_dest_type");
		k++;
	}
	var j = 0;
	// check connection
	for (i = 0; i < routOrgNod.length; i++) {
		if (sheetObj.RowCount() == 1) {
			return true;
		} else {
			j = i + 1;
		}
		if (routDestNod[i] == routOrgNod[j]) { // the number of rows are more than 2
			if (j == (routOrgNod.length - 1))
				return true;
		} else {
			ComShowMessage(ComGetMsg('PRD90030'));
			return false;
		}
	}
}
// checking connection of 'saveas'
function checkRoute3(sheetObj, formObj) {
	var k = 0;
	var modRoutOrgLoc = "";
	var modRoutDestLoc = "";
	var routOrgNod = new Array();
	var routDestNod = new Array();
	routOrgNod[k] = "";
	routDestNod[k] = "";
	var sURow = sheetObj.FindStatusRow("U");
	if (sURow.length > 0) {
		sURow = sURow + ";";
	}

	var arURow = sURow.split(";");
	var sIRow = sheetObj.FindStatusRow("I");
	if (sIRow.length > 0) {
		sIRow = sIRow + ";";
	}
	var arIRow = sIRow.split(";");
	formObj.i_new_route_cd.value = "";
	var gubun = '';
	for (i = 0; i < formObj.r_inbound.length; i++) {
		if (formObj.r_inbound[i].checked) {
			gubun = formObj.r_inbound[i].value;
			break;
		}
	}
	
	if (arIRow.length >= 2 && arURow.length == 1) {
		formObj.i_new_route_cd.value = "Y";
		formObj.i_rout_seq.value = 0;
		formObj.i_rout_org_nod_cd.value = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type");
		formObj.i_rout_dest_nod_cd.value = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type");
		var org_loc = formObj.i_org_cd.value;
		var dest_loc = formObj.i_dest_cd.value;
	} else {
		if (arURow.length > 1) {
			formObj.i_new_route_cd.value = "N";
		}
		var hRoutOrgNodCd = formObj.i_rout_org_nod_cd.value; // master org of route which will be modified
		var hRoutDestNodCd = formObj.i_rout_dest_nod_cd.value; // master dest of route which will be modified
		var firstRoutOrgNodCd = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type"); // first org of modified route
		var lastRoutDestNodCd = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type"); // last dest of modified route
		// changing basic information in case of SAVE AS
		if (hRoutOrgNodCd != firstRoutOrgNodCd) {
			formObj.i_rout_org_nod_cd.value = firstRoutOrgNodCd;
		}
		if (hRoutDestNodCd != lastRoutDestNodCd) {
			formObj.i_rout_dest_nod_cd.value = lastRoutDestNodCd;
		}
	}
	// it is also possible to modify master data only as well as update or create each link(Y: insert, N:update, M:master update)
	if (formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N") {
		formObj.i_new_route_cd.value = "M";
	}
	// putting into array to know the connection later. if rows are cleared, it can be judged as 'Delete'
	for (i = 1; i <= sheetObj.RowCount(); i++) {
		routOrgNod[k] = sheetObj.GetCellValue(i, "lnk_org_loc") + sheetObj.GetCellValue(i, "lnk_org_type");
		routDestNod[k] = sheetObj.GetCellValue(i, "lnk_dest_loc") + sheetObj.GetCellValue(i, "lnk_dest_type");
		k++;
	}
	var j = 0;
	// checking connection
	for (i = 0; i < routOrgNod.length; i++) {
		if (sheetObj.RowCount() == 1) {
			return true;
		} else {
			j = i + 1;
		}
		if (routDestNod[i] == routOrgNod[j]) { // the number of rows are more than 2
			if (j == (routOrgNod.length - 1))
				return true;
		} else {
			ComShowMessage(ComGetMsg('PRD90030'));
			return false;
		}
	}
}
/*
 * checking route when saving master data
 */
function checkLocCondition(sheetObj) {
	var formObject = document.form;
	var org_loc = formObject.i_org_cd.value;
	var dest_loc = formObject.i_dest_cd.value;
	var gubun = '';
	for (i = 0; i < formObject.r_inbound.length; i++) {
		if (formObject.r_inbound[i].checked) {
			gubun = formObject.r_inbound[i].value;
		}
	}
	var orgSheetVal = '';
	var destSheetVal = '';
	for ( var i = 1; i <= sheetObj.RowCount(); i++) {
		if (gubun == 'I') { // 7,5
			orgSheetVal = sheetObj.GetCellValue(i, "rout_org_nod_cd");
			destSheetVal = sheetObj.GetCellValue(i, "dest_loc");
		}
		if (gubun == 'O') { // 5,7
			orgSheetVal = sheetObj.GetCellValue(i, "ori_loc");
			destSheetVal = sheetObj.GetCellValue(i, "rout_dest_nod_cd");
		}
		if (gubun == 'T') { // 5,5
			orgSheetVal = sheetObj.GetCellValue(i, "ori_loc");
			destSheetVal = sheetObj.GetCellValue(i, "dest_loc");
		}
		if (gubun == 'M') { // 7,7
			orgSheetVal = sheetObj.GetCellValue(i, "rout_org_nod_cd");
			destSheetVal = sheetObj.GetCellValue(i, "rout_dest_nod_cd");
		}
		if (org_loc != orgSheetVal || dest_loc != destSheetVal) {
			ComShowMessage(ComGetMsg('PRD90031'));
			return false;
		}
	}
	return true;
}
/*
 * checking route when saving detail data
 */
function checkDtlLocCondition(sheetObj) {
	var formObject = document.form;
	var org_loc = formObject.i_org_cd.value;
	var dest_loc = formObject.i_dest_cd.value;
	var gubun = '';
	for (i = 0; i < formObject.r_inbound.length; i++) {
		if (formObject.r_inbound[i].checked) {
			gubun = formObject.r_inbound[i].value;
		}
	}
	var orgSheetVal = '';
	var destSheetVal = '';
	if (gubun == 'I') {
		orgSheetVal = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type");
		destSheetVal = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc");
	}
	if (gubun == 'O') {
		orgSheetVal = sheetObj.GetCellValue(1, "lnk_org_loc");
		destSheetVal = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type");
	}
	if (gubun == 'T') {
		orgSheetVal = sheetObj.GetCellValue(1, "lnk_org_loc");// sheetObj.GetCellValue(1,"lnk_org_type");
		destSheetVal = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc");// +sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type");
	}
	if (gubun == 'M') {
		orgSheetVal = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type");
		destSheetVal = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type");
	}
	// ComShowMessage(org_loc+","+dest_loc+"sheet org_loc,dest_loc==["+orgSheetVal+","+destSheetVal);
	if (org_loc != orgSheetVal || dest_loc != destSheetVal) {
		ComShowMessage(ComGetMsg('PRD90032'));
		return false;
	}
	return true;
}
function getCOM_ENS_051_1(rowArray) {
	// alertComPopupData(rowArray);
	var colArray = rowArray[0];
	document.all.i_org_cd.value = colArray[3];
}
function getOrgLoc(rowArray) {
	// alertComPopupData(rowArray);
	var colArray = rowArray[0];
	document.all.i_org_cd.value = colArray[3];
}
function getDestLoc(rowArray) {
	// alertComPopupData(rowArray);
	var colArray = rowArray[0];
	document.all.i_dest_cd.value = colArray[3];
}
/*
 * priority will be given as retrieving data
 */
var delCnt = 1;
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var i, curGubun, oriData, curOri;
	var change_seq = Value;
	ori_seq = sheetObj.GetCellValue(Row, "ori_prio_seq");
	var priorityArray = priority_seq.split("|");
	var priorityArrayLength = priorityArray.length - 1;

	var changedArr = new Array();
	var changedIdx = 0;
	var curMax = maxPrioSeq;
	if (sheetObj.ColSaveName(Col) == "prio_seq" && Value == 0) {
		sheetObj.SetCellValue(Row, "prio_seq", sheetObj.GetCellValue(Row, "ori_prio_seq"), 0);
		ComShowMessage("Not select Value 0.");
		return false;
	}
	if (sheetObj.ColSaveName(Col) == "prio_seq" || sheetObj.ColSaveName(Col) == "delChk") {
		if (sheetObj.ColSaveName(Col) == "delChk") {
			change_seq = priorityArray[priorityArrayLength - delCnt];
			if (ori_seq == 0) {
				ori_seq = priorityArray[priorityArrayLength - (delCnt + 1)];
			}
			if (sheetObj.GetCellValue(Row, "delChk") == 1) {
				delCnt++;
			} else {
				delCnt--;
			}
			sheetObj.SetCellValue(Row, "prio_seq", change_seq, 0);
		}

		var prePrioSeq;
		for (i = 1; i <= sheetObj.rowcount; i++) {
			curOri = sheetObj.GetCellValue(i, "ori_prio_seq");
			if (prePrioSeq == curOri) {
				continue;
			}
			var continueChk = false;
			for ( var index = 0; index < changedArr.length; index++) {
				if (changedArr[index] == curOri) {
					continueChk = true;
					continue;
				}
			}
			if (continueChk)
				continue;
			if (eval(ori_seq) - eval(change_seq) > 0 || eval(ori_seq) == 0) { // if priority get higher ( ex: 4->1)
				if ((eval(change_seq) <= eval(curOri) && eval(curOri) < eval(ori_seq)) || (eval(change_seq) <= eval(curOri) && eval(ori_seq) == 0)) {
					var upArr = new Array();
					var upIdx = 0;
					for ( var index = 0; index < priorityArrayLength; index++) {
						if (eval(curOri) < eval(priorityArray[index])) {
							upArr[upIdx] = priorityArray[index];
							upIdx++;
						}
					} // for
					sheetObj.SetCellValue(i, "prio_seq", upArr[0], 0);
				}
			} else { // if priority get lower (ex:1 -> 4)
				if (eval(ori_seq) == 0) {
					if (eval(change_seq) <= eval(curMax)) {
						if (eval(ori_seq) < eval(curOri) && eval(curOri) <= eval(change_seq)) {
							var downArr = new Array();
							var downIdx = 0;
							for ( var index = 0; index < priorityArrayLength; index++) {
								if (eval(curOri) > eval(priorityArray[index]) && eval(priorityArray[index]) != 0) {
									downArr[downIdx] = priorityArray[index];
									downIdx++;
								}
							} // for
							if (downArr.length > 0) {
								sheetObj.SetCellValue(i, "prio_seq", downArr[downArr.length - 1], 0);
							}
						}
					}
				} else {
					if (eval(ori_seq) < eval(curOri) && eval(curOri) <= eval(change_seq)) {
						var downArr = new Array();
						var downIdx = 0;
						for ( var index = 0; index < priorityArrayLength; index++) {
							if (eval(curOri) > eval(priorityArray[index]) && eval(priorityArray[index]) != 0) {
								downArr[downIdx] = priorityArray[index];
								downIdx++;
							}
						} // for
						if (downArr.length > 0) {
							sheetObj.SetCellValue(i, "prio_seq", downArr[downArr.length - 1], 0);
						}
					}
				}
			}
			changedArr[changedIdx++] = curOri;
			prePrioSeq = curOri;
		}
		for (j = 1; j <= sheetObj.rowcount; j++) {
			sheetObj.SetCellValue(j, "ori_prio_seq", sheetObj.GetCellValue(j, "prio_seq"), 0);
		}
	}
	var col_nm = sheetObj.ColSaveName(Col);
	if (col_nm == "wrs_chk") {
		if (sheetObj.GetCellValue(Row, Col) == 1) {
			fncCntrTpSzControl(sheetObj, Row, true);
		} else {
			var tpsz_chk = true;
			var mssg = "";
			for ( var j = 0; j < cntrTpSizArray.length; j++) {
				if (sheetObj.GetCellValue(Row, cntrTpSizArray[j]) == 1) {
					tpsz_chk = false;
					mssg += cntrTpSizNmArray[j] + ",";
				}
			}
			if (!tpsz_chk) {
				ComShowCodeMessage("PRD00093", mssg.substr(0, mssg.length - 1));
				sheetObj.SetCellValue(Row, "wrs_chk", 1, 0);
				return false;
			}
			// CNTR TYPE/SIZE 비활성화
			fncCntrTpSzControl(sheetObj, Row, false);
		}
	}
	
	if ($.inArray(col_nm, cntrTpSizArray) != -1) {
		var ori_loc = sheetObj.GetCellValue(Row, "ori_loc");
		if (sheetObj.GetCellValue(Row, col_nm) == 1) {
			for (i = 1; i < sheetObj.LastRow() + 1; i++) {
				if (i != Row && sheetObj.GetCellValue(i, "ori_loc") == ori_loc && sheetObj.GetCellValue(i, col_nm) == 1) {
					sheetObj.SetCellValue(i, col_nm, 0, 0);
				}
			}
		}		
	}
}
/**
 * Container Type Size Editable 관리.
 */
function fncCntrTpSzControl(sheetObj, Row, editableFlag) {
	for ( var j = 0; j < cntrTpSizArray.length; j++) {
		sheetObj.SetCellEditable(Row, cntrTpSizArray[j], editableFlag);
	}
}

function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var lnk_org_loc_cd = sheetObj.GetCellValue(Row, "lnk_org_loc") + sheetObj.GetCellValue(Row, "lnk_org_type");
	var lnk_dest_loc_cd = sheetObj.GetCellValue(Row, "lnk_dest_loc") + sheetObj.GetCellValue(Row, "lnk_dest_type");
	if ((sheetObj.GetRowStatus(Row) == "I" || sheetObj.GetRowStatus(Row) == "U")
			&& (sheetObj.ColSaveName(Col) == "lnk_org_loc" || sheetObj.ColSaveName(Col) == "lnk_dest_loc" || sheetObj.ColSaveName(Col) == "trsp_mod_cd" || sheetObj.ColSaveName(Col) == "lnk_org_type" || sheetObj.ColSaveName(Col) == "lnk_dest_type")) {
		// checking validation for link
		if (sheetObj.GetCellValue(Row, "lnk_org_loc") != "" && sheetObj.GetCellValue(Row, "lnk_dest_loc") != "" && sheetObj.GetCellValue(Row, "trsp_mod_cd") != "" && sheetObj.GetCellValue(Row, "lnk_org_type") != "" && sheetObj.GetCellValue(Row, "lnk_dest_type") != "") {
			sheetObj.DoRowSearch(Row, "ESD_PRD_0005ROWSEARCH.do", "f_cmd=" + SEARCH11 + "&from_nod=" + lnk_org_loc_cd + "&to_nod=" + lnk_dest_loc_cd + "&trsp_mod=" + sheetObj.GetCellValue(Row, "trsp_mod_cd") + "&row=" + Row + "&col=" + Col, { Sync : 2 })
			if (sheetObj.GetEtcData("rowCount") == 0) {
				sheetObj.SetCellValue(Row, "lnk_org_loc", "", 0);
				sheetObj.SetCellValue(Row, "lnk_dest_loc", "", 0);
				sheetObj.SetCellValue(Row, "lnk_org_type", "", 0);
				sheetObj.SetCellValue(Row, "lnk_dest_type", "", 0);
				sheetObj.SetCellValue(Row, "vndr_seq", "", 0);
				sheetObj.SetCellValue(Row, "vndr_name", "", 0);
				sheetObj.SetCellValue(Row, "tztm_hrs", "", 0);
				sheetObj.SetCellValue(Row, "rail_crr_tp_cd", "", 0);
				sheetObj.SetCellValue(Row, "inlnd_rout_cmb_flg", "", 0);
				sheetObj.SetCellValue(Row, "inlnd_rout_junc_nm", "", 0);
				sheetObj.SelectCell(Row, "lnk_dest_loc");
			}
		}
	}
	// checking sp code
	if (sheetObj.ColSaveName(Col) == "vndr_seq") {
		if (sheetObj.GetCellValue(Row, "vndr_seq").length > 0) {
			validateData = sheetObj.GetCellValue(Row, "vndr_seq");
			doActionIBSheet2(sheetObj, document.form, SEARCH08);
		}
	}
	// checking validation for agree no
	if (sheetObj.ColSaveName(Col) == "agmt_no") {
		if (Value == "") {
			sheetObj.SetCellValue(Row, "refe_no", "", 0);
			return;
		}
		var cty_cd = Value.substring(0, 3);
		var agmt_cd = Value.substring(3);
		var vndr_seq = sheetObj.GetCellValue(Row, "vndr_seq");
		sheetObj.DoRowSearch(Row, "ESD_PRD_0005_AGMT_NO_GS.do", "f_cmd=" + SEARCH01 + "&cty_cd=" + cty_cd + "&agmt_seq=" + agmt_cd + "&row=" + Row + "&col=" + Col + "&vndr_seq=" + vndr_seq, { Sync : 2 });
		if (sheetObj.GetEtcData("rowCount") == 0) {
			sheetObj.SetCellValue(Row, "refe_no", "", 0);
			sheetObj.SetCellValue(Row, "agmt_no", "", 0);
			sheetObj.SetCellBackColor(Row, "vndr_seq", "#FFFFFF");
			sheetObj.SetCellBackColor(Row, "agmt_no", "#FFFFFF");
		} else {
			if (sheetObj.GetEtcData("trs_vndr_seq") != vndr_seq) {
				ComShowMessage(ComGetMsg('PRD90070'));
				sheetObj.SetCellBackColor(Row, "vndr_seq", "#FFA040");
				sheetObj.SetCellBackColor(Row, "agmt_no", "#FFA040");
			} else {
				sheetObj.SetCellBackColor(Row, "vndr_seq", "#FFFFFF");
				sheetObj.SetCellBackColor(Row, "agmt_no", "#FFFFFF");
			}
		}
	}
	// enabling in case of USA Rail (S) -----------------------------------------------
	if (checkFromTo4US(sheetObj) && sheetObj.GetCellValue(Row, "trsp_mod_cd") == "RD") {
		sheetObj.SetCellEditable(Row, "agmt_no", 1);
		sheetObj.SetCellEditable(Row, "rail_crr_tp_cd", 1);
		sheetObj.SetCellEditable(Row, "inlnd_rout_junc_nm", 1);
	} else {
		sheetObj.SetCellValue(Row, "agmt_no", "", 0);
		sheetObj.SetCellValue(Row, "refe_no", "", 0);
		sheetObj.SetCellValue(Row, "rail_crr_tp_cd", "", 0);
		sheetObj.SetCellValue(Row, "inlnd_rout_junc_nm", "", 0);
		sheetObj.SetCellEditable(Row, "agmt_no", 0);
		sheetObj.SetCellEditable(Row, "rail_crr_tp_cd", 0);
		sheetObj.SetCellEditable(Row, "inlnd_rout_junc_nm", 0);
	}
	// enabling in case of USA Rail (E) -----------------------------------------------
}
/**
 * calling Biz common pop up from sheet - calling comPopupInSheet() : Parameter - row, col
 */
function sheet2_OnPopupClick(sheetObj, row, col) {
	var loc_cd_val;
	var dispaly;
	var classId;
	var param;
	var chkStr;
	if (sheetObj.ColSaveName(col) == "lnk_org_loc" || sheetObj.ColSaveName(col) == "lnk_dest_loc") {
		loc_cd_val = sheetObj.GetCellValue(row, col);
		dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
		classId = "COM_ENS_061";
		param = '?loc_cd=' + loc_cd_val + '&classId=' + classId;
		chkStr = dispaly.substring(0, 3)
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true, true, row, col);
	}
	if (sheetObj.ColSaveName(col) == "vndr_seq") {
		loc_cd_val = sheetObj.GetCellValue(row, col);
		dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
		classId = "COM_ENS_0C1";
		param = '?pts_vndr_cd=' + loc_cd_val + '&classId=' + classId;
		chkStr = dispaly.substring(0, 3)
		// Radio PopUp
		if (chkStr == "1,0") {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 810, 550, 'getVendor', dispaly, true, false, row, col);
		} else {
			ComShowMessage(ComGetMsg('PRD90063'));
			return;
		}
	}
}
function getVendor(rowArray, row, col) {
	var sheetObj = sheetObjects[1];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, "vndr_seq", colArray[2], 0);
	sheetObj.SetCellValue(row, "vndr_name", colArray[4], 0);
}
/**
 * Location : in case of single selection of radio button on pop up
 */
function getNode(rowArray, row, col) {
	var sheetObj = sheetObjects[1];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(parseInt(row), parseInt(col) + 1, colArray[3].substring(5), 0);
	sheetObj.SetCellValue(parseInt(row), parseInt(col), colArray[3].substring(0, 5), 0);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	return true;
}
/**
 * disabling form input value
 */
function bottomFrmDisable(gb) {
	var formObj = document.form;
	if (gb) {
		ComEnableObject(formObj.i_inv, false);
		ComEnableObject(formObj.i_rout_pln_cd, false);
		ComEnableObject(formObj.i_wrs_fl_cd,false);
    	ComEnableObject(formObj.i_wrs_mt_cd,false);
	} else {
		ComEnableObject(formObj.i_inv, true);
		ComEnableObject(formObj.i_rout_pln_cd, true);
		ComEnableObject(formObj.i_wrs_fl_cd,true);
    	ComEnableObject(formObj.i_wrs_mt_cd,true);
	}
	var gubun = formObj.rBtnIrgCd.value;
}
function chkAmericanContinent(formObj) {
	var org = formObj.i_org_cd.value.substring(0, 2);
	var des = formObj.i_dest_cd.value.substring(0, 2);
	if ((org == "US" || org == "CA") && (des == "US" || des == "CA")) {
		return true;
	}
	return false;
}

function bottomFrmClear(formObj) {
	ComClearObject(formObj.i_inv);
	ComClearObject(formObj.i_rout_pln_cd);
	ComClearObject(formObj.i_route_rmk);
	ComClearObject(formObj.wrs_chk);
}

function changeNodTy1(nodTy) {
	document.form.rBtnNodTyCd1.value = nodTy;
}
function changeNodTy2(nodTy) {
	document.form.rBtnNodTyCd2.value = nodTy;
}

/**
 * WRS Flag Event
 */
function changeSelection(gubun) {
	document.form.wrs_flg.value = gubun;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
}

/**
 * 
 */
function setWRS(gb) {
	var formObj = document.form;
	if (gb == 'M') {
		ComEnableObject(formObj.i_wrs_fl_cd, false);
		ComEnableObject(formObj.i_bkg_flg, false);
		ComEnableObject(formObj.i_wrs_mt_cd, true);
	} else {
		ComEnableObject(formObj.i_wrs_mt_cd, false);
		ComEnableObject(formObj.i_bkg_flg, true);
		ComEnableObject(formObj.i_wrs_fl_cd, true);
	}
}

var portInd = '';
function selectTml(frm, pt) {
	portInd = pt;
	if (pt == 'IB_ORG_TML')
		param = "?node_cd=" + frm.from_cd.value;
	if (pt == 'OB_DEST_TML')
		param = "?node_cd=" + frm.to_cd.value;
	if (pt == 'TS_ORG_YD')
		param = "?node_cd=" + frm.i_org_cd_ts.value;
	if (pt == 'TS_DEST_YD')
		param = "?node_cd=" + frm.i_dest_cd_ts.value;
	if (pt == 'MT_ORG_YD')
		param = "?node_cd=" + frm.i_org_cd_ts.value;
	if (pt == 'MT_DEST_YD')
		param = "?node_cd=" + frm.i_dest_cd_ts.value;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
function getCOM_ENS_061(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'IB_ORG_TML') {
		frm.from_cd.value = cArray[3];
	}
	if (portInd == 'OB_DEST_TML') {
		frm.to_cd.value = cArray[3];
	}
	if (portInd == 'TS_ORG_YD') {
		frm.i_org_cd_ts.value = cArray[3];
	}
	if (portInd == 'TS_DEST_YD') {
		frm.i_dest_cd_ts.value = cArray[3];
	}
	if (portInd == 'MT_ORG_YD') {
		frm.i_org_cd_mt.value = cArray[3];
	}
	if (portInd == 'MT_DEST_YD') {
		frm.i_dest_cd_mt.value = cArray[3];
	}
}
function selectLoc(frm, pt) {
	portInd = pt;
	if (pt == 'IB_DEST_LOC')
		param = "?loc_cd=" + frm.i_dest_cd_ib.value;
	if (pt == 'OB_ORG_LOC')
		param = "?loc_cd=" + frm.i_org_cd_ob.value;
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'IB_ORG_TML') {
		frm.i_dest_cd_ib.value = cArray[3];
	}
	if (portInd == 'OB_ORG_LOC') {
		frm.i_org_cd_ob.value = cArray[3];
	}
}

function changeDeltFlg() {
	var frm = document.form;
	sheetObjects[0].RemoveAll();
	sheetObjects[0].RenderSheet(0);
	if (frm.i_del_flg.checked) {
		sheetObjects[0].SetColHidden("upd_id", 1);
		sheetObjects[0].SetColHidden("upd_date", 1);
		sheetObjects[0].SetColHidden("del_id", 0);
		sheetObjects[0].SetColHidden("del_date", 0);
	} else {
		sheetObjects[0].SetColHidden("upd_id", 0);
		sheetObjects[0].SetColHidden("upd_date", 0);
		sheetObjects[0].SetColHidden("del_id", 1);
		sheetObjects[0].SetColHidden("del_date", 1);
	}
	sheetObjects[0].RenderSheet(1);
}
/*
 * checking input condition for retrieve
 */
function checkInput() {
	var formObject = document.form;
	var from_cd = formObject.from_cd.value;
	var to_cd = formObject.to_cd.value;

	// 2015.04.23
	if (from_cd == "" && to_cd == "") {
		ComShowCodeMessage("COM130403", 'From or To');
		return false;
	}

	if (from_cd.length > 0) {
		if (!(from_cd.length < 2)) {
			var org = from_cd.substring(0, 2);
			if (chkAmericaCnt("from_cd") == false) {
				// if(!(org == "US" || org == "CA" || org == "MX") ) {
				ComShowMessage(ComGetMsg('PRD90097'));
				formObject.from_cd.select();
				formObject.from_cd.focus();
				return false;
			}
		} else {
			ComShowMessage(ComGetMsg('PRD90097'));
			formObject.from_cd.select();
			formObject.from_cd.focus();
			return false;
		}
	}
	if (to_cd.length > 0) {
		if (!(to_cd.length < 2)) {
			var dest = to_cd.substring(0, 2);
			if (chkAmericaCnt("to_cd") == false) {
				// if(!(dest == "US" || dest == "CA" || dest == "MX") ) {
				ComShowMessage(ComGetMsg('PRD90097'));
				formObject.to_cd.select();
				formObject.to_cd.focus();
				return false;
			}
		} else {
			ComShowMessage(ComGetMsg('PRD90097'));
			formObject.to_cd.select();
			formObject.to_cd.focus();
			return false;
		}
	}
	return true;
}

/**
 * 
 * @param objNm
 * @returns {Boolean}
 */
function chkAmericaCnt(objNm) {
	var cnt_cd = document.form.cnt_cd.value;
	var obj = document.getElementsByName(objNm);
	var str = obj[0].value;
	var cnt = 0;
	if (cnt_cd != null && cnt_cd.length >= 3) {
		for ( var idx = 0; idx < cnt_cd.length; idx = idx + 3) {
			if (cnt_cd.substr(idx, 2) == str.substr(0, 2)) {
				cnt++;
			}
		}
	}
	if (cnt <= 0) {
		return false;
	} else {
		return true;
	}
}
function chkAmericaCntCd(vaCntCd) {
	var cnt_cd = document.form.cnt_cd.value;
	var str = vaCntCd
	var cnt = 0;
	if (cnt_cd != null && cnt_cd.length >= 3) {
		for ( var idx = 0; idx < cnt_cd.length; idx = idx + 3) {
			if (cnt_cd.substr(idx, 2) == str.substr(0, 2)) {
				cnt++;
			}
		}
	}
	if (cnt <= 0) {
		return false;
	} else {
		return true;
	}
}
