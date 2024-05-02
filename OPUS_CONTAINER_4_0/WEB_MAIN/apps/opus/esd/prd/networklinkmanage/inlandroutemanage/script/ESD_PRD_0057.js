/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0057.js
 *@FileTitle  : USA-FULL 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview 
 * @author OPUS
 */
/**
 * @extends
 * @class ESD_PRD_0057 : business script for ESD_PRD_0057
 */
function ESD_PRD_0057() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.doIBSheetClear = doIBSheetClear;
	this.prdComKeyUp = prdComKeyUp;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
	this.chkMandatoryForAmerican = chkMandatoryForAmerican;
	this.chkCombindMode = chkCombindMode;
	this.setCombindMode = setCombindMode;
	this.clearDetailHiddenValue = clearDetailHiddenValue;
	this.doActionIBSheet2 = doActionIBSheet2;
	this.checkMandatory = checkMandatory;
	this.checkRouteList = checkRouteList;
	this.validateLocation = validateLocation;
	this.checkSpChange = checkSpChange;
	this.checkJunk = checkJunk;
	this.checkRoute2 = checkRoute2;
	this.checkRoute3 = checkRoute3;
	this.checkLocCondition = checkLocCondition;
	this.checkDtlLocCondition = checkDtlLocCondition;
	this.getCOM_ENS_051_1 = getCOM_ENS_051_1;
	this.sheet1_OnChange = sheet1_OnChange;
	this.sheet1_OnPopupClick = sheet1_OnPopupClick;
	this.sheet2_OnPopupClick = sheet2_OnPopupClick;
	this.getVendor = getVendor;
	this.getNode = getNode;
	this.bottomFrmDisable = bottomFrmDisable;
	this.chkMandatory4Search = chkMandatory4Search;
	this.bottomFrmClear = bottomFrmClear;
	this.changeNodTy1 = changeNodTy1;
	this.changeSelection = changeSelection;
	this.selectTml = selectTml;
	this.getCOM_ENS_061 = getCOM_ENS_061;
	this.sheetMinimize = sheetMinimize;
	this.changeDeltFlg = changeDeltFlg;
	this.checkInput = checkInput;
}
/* Common global variable */
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
/* Event handler processing by button click event */
document.onclick = processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var sheetObject2 = sheetObjects[2];
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
		switch (srcName) {
			case "btn_retrieve":
				if (!checkInput())
					return false;
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
				formObject.i_org_cd.value = i_origin;
				formObject.i_dest_cd.value = i_destination;
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
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
				myWin = ComOpenWindowCenter('ESD_PRD_0007.do' + param, 'compop', 700, 480, false);
				myWin.focus();
				break;
			case "btn_downexcel":
				if (sheetObject.RowCount() < 1) {// no data
					ComShowCodeMessage("COM132501");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				}

				break;
			case "btng_save":
				if (chkCombindMode(sheetObject1)) {
					doActionIBSheet2(sheetObject1, formObject, IBSAVE);
				}
				break;
			case "btng_rowadd":
				doActionIBSheet2(sheetObject1, formObject, IBINSERT);
				break;
			// 05. Location (COM_ENS_051)
			case "btn_org_loc":
				dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
				classId = "COM_ENS_051";
				param = '?classId=' + classId;
				chkStr = dispaly.substring(0, 3);
				// radio PopUp
				if (chkStr == "1,0") {
					comPopup('/opuscntr/COM_ENS_051.do' + param, 810, 550, 'getOrgLoc', dispaly);
				} else {
					ComShowMessage(ComGetMsg('PRD90063'));
					return;
				}
				break;
			case "btn_dest_loc":
				dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
				classId = "COM_ENS_051";
				param = '?classId=' + classId;
				chkStr = dispaly.substring(0, 3)
				// radio PopUp
				if (chkStr == "1,0") {
					comPopup('/opuscntr/COM_ENS_051.do' + param, 810, 550, 'getDestLoc', dispaly);
				} else {
					ComShowMessage(ComGetMsg('PRD90063'));
					return;
				}
				break;
			case "btng_clear":
				sheetObject1.RowDelete(sheetObject1.LastRow(), 1)
				break;
			case "btng_new":
				sheetObject1.SetEditable(1);
				ComEnableObject(formObject.i_inv, true);
				ComEnableObject(formObject.i_rout_pln_cd, true);
				sheetObject1.RemoveAll();
				bottomFrmClear(formObject);
				clearDetailHiddenValue(formObject);
				break;
			case "btng_saveas":
				if (!confirm(ComGetMsg('PRD90043'))) {
					break;
				}
				if (!chkCombindMode(sheetObject1)) {
					break;
				}
				// checking the Americas
				var invIdx = formObject.i_inv.selectedIndex;
				if (!chkMandatoryForAmerican(formObject, sheetObject1)) {
					break;
				}
				// checking if it is connection
				if (!checkRoute3(sheetObject1, formObject)) {
					break;
				}
				doActionIBSheet2(sheetObject1, formObject, MULTI02);
				break;
			case "ib_org_loc_btn":
				selectLoc(formObject, 'IB_ORG_LOC');
				break;
			case "ib_dest_loc_btn":
				selectLoc(formObject, 'IB_DEST_LOC');
				break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(ComGetMsg('COM12111'));
		} else {
			ComShowMessage(e.message);
		}
	}
}
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
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'i_org_cd', 'i_dest_cd', 'i_hub_loc');
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
        case 1:   
            with(sheetObj){
        	    	 var HeadTitle="Del.|BKG|WRS|CHK|STS|Priority|ORG Node|DEST Node|HUB Nod|R.P|Route|Tmp Flg|FREE SHTL|Currency|Total Cost(or USD)|Total T/T|C.User|C.Date|U.User|U.Date|D.User|D.Date|Remarks|Rout SEQ|Hub Search Gb|Front Gb|Undefine Nod|Gu|Ori|ORG.LOC|Node|DEST.LOC|Node" ;
        	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        	         var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	         InitHeaders(headers, info);
        	         var cols = [ 
        	             {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
        	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_bkg_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" },
        	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"wrs_full_cmdt",        	   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N" },
        	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"un_del",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
        	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prio_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2},
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_org_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_dest_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hub",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rout_pln_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
        	             {Type:"Text",      Hidden:0, Width:470,  Align:"Left",    ColMerge:0,   SaveName:"route",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_tmp_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, TrueValue:"Y", FalseValue:"N" },
        	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_incl_sttl_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, TrueValue:"Y", FalseValue:"N" },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"ttl_cost",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tot_tt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_date",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"inlnd_rout_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hub_search_gb",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"front_gb",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"undefine_nod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"group_gubun",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ori_prio_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_loc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"org_loc_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } 
        	         ];
        	         InitColumns(cols);
        	         SetEditable(1);
        	         SetSheetHeight(160);
        	         SetColProperty("tot_tt", 			 {AcceptKeys:"N", Format:"##D##H"} );
        	         SetColProperty(0 ,"ori_loc" , 		 {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	         SetColProperty(0 ,"ori_loc_type" ,  {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	         SetColProperty(0 ,"dest_loc" , 	 {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	         SetColProperty(0 ,"dest_loc_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	         SetColProperty(0 ,"prio_seq" , 	 {AcceptKeys:"N",	ExceptKeys:"[-]", 	DefaultValue:"99",	AllowNull:false,	Focus:true});
        }
            break;
        case 2:      //IBSheet2 init
            with(sheetObj){
		             var HeadTitle="Del.|STS|SEQ|Clear|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T(DD.HH)|AGMT No|Reference No|Combined Mode|C/TOFC|Junction|Currency|Cost|Expiry Date|lnk_org_nod_cd|b|c|d|e|f|g|f|g|h|i|j|k|fc" ;
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ 
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rnllws",              	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibseq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"clear_chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
			                 {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"combined_md",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
			                 {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"rail_crr_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_junc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",       			  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"agree_rate",       		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_to_dt",       		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"clon_inlnd_rout_junc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fc",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetSheetHeight(180);
		             ComResizeSheet(sheetObj, 80);
		             SetColProperty("trsp_mod_cd", {ComboText:trsp_mod_cdText, ComboCode:trsp_mod_cdCode} );
		             SetColProperty("rail_crr_tp_cd", {ComboText:rail_crr_tp_cdText, ComboCode:rail_crr_tp_cdCode} );
		             SetColProperty(0, "tztm_hrs", {AcceptKeys:"N", Format:"##.##"} );
 	            	 SetColProperty(0 ,"lnk_org_loc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            	 SetColProperty(0 ,"lnk_org_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            	 SetColProperty(0 ,"lnk_dest_loc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            	 SetColProperty(0 ,"lnk_dest_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            	 SetColProperty(0 ,"vndr_seq" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            	 SetColProperty(0 ,"agmt_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            	
         }
         break;
        case 3: //Temp Sheet
            with(sheetObj){        
		            var HeadTitle="OFC_CD|SO_SEQ" ;
		            SetHeaderRowHeight(30);
		  
		            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
		  
		            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		            var headers = [ { Text:HeadTitle, Align:"Center"} ];
		            InitHeaders(headers, info);
		  
		            var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:'trsp_so_ofc_cty_cd',  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:'trsp_so_seq',         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];                   
		            InitColumns(cols);        
		            SetEditable(1);
		            SetVisible(false);
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
			formObj.f_cmd.value = SEARCHLIST;
			i_origin = formObj.i_org_cd.value;
			i_destination = formObj.i_dest_cd.value;
			sheetObj.DoSearch("ESD_PRD_0057GS.do", PrdFQString(formObj), { Sync : 2 });
			break;
		case IBSAVE:
			if (!checkRouteList(sheetObj))
				return false;
			var iCheckRow = sheetObj.FindCheckedRow("del_chk");
			if (iCheckRow != "") {
				if (!confirm(ComGetMsg('PRD90084'))) {
					break;
				}
			}
			var check = true;
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetRowStatus(i) == 'U' && sheetObj.GetCellValue(i, "wrs_full_cmdt") == 1) {
					if (sheetObj.GetCellValue(i, "inlnd_rout_bkg_flg") == 1 && (sheetObj.GetCellValue(i, "prio_seq") == "1" || sheetObj.GetCellValue(i, "prio_seq") == "2")) {
						continue;
					} else {
						ComShowMessage(ComGetMsg('PRD90085'));
						check = false;
						break;
					}
				}
			}
			if(check) {
				formObj.f_cmd.value = MULTI;
				var rst = sheetObj.DoSave("ESD_PRD_0057GS.do", { Param : PrdFQString(formObj), Sync : 2 });
			}
			break;
		case IBCOPYROW:
			sheetObj.DataCopy();
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			uid = "ESD_PRD_0057";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case SEARCH05:
			formObj.f_cmd.value = SEARCH05;
			uid = "ESD_PRD_0057";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			sParam = PrdFQString(formObj);
			var sXml = sheetObj.GetSearchData("ESD_PRD_0057GS.do", sParam);
			formObj.cnt_cd.value = ComGetEtcData(sXml, "cnt_cd");
			break;
	}
}

// double click event
function sheet1_OnDblClick(sheetObj, row, col, value) {
	var formObj = document.form;
	formObj.i_sel_row.value = row;
	doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
}

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var frm = document.form;
	if (frm.i_del_flg.checked) {
		for ( var i = 1; i <= sheetObj.RowCount(); i++) {
			sheetObj.SetCellEditable(i, "del_chk", 0);
		}
	}
}

function sheet2_OnSearchEnd(sheetObj, errCode, errMsg) {
	if (isInvCnt(document.form)) {
	} else {
		sheetObj.SetEditable(1);
		ComBtnEnable("btng_save");
	}
}
// checking mandatory elements if the row has the case of USA Rail
function chkMandatoryForAmerican(formObj, sheetObj) {
	// inv billing, Route Plan is mandatory input condition if it is the Americas and has RD in link
	var invIdx = formObj.i_inv.selectedIndex;
	var routPlnIdx = formObj.i_rout_pln_cd.selectedIndex;
	var findRd = false;
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
		sheetObj.FindText("trsp_mod_cd", "RAIL", i, -1) != -1 ? findRd = true : "";
		if (findRd)
			break;
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
		} // FOR
	}
	return true;
}
// double click event - SHEET1, save event - SHEET2
function chkCombindMode(sheetObj) {
	// checking combindmode through all rd if inv billing,pattern starts with 'C','S'
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
			if (sheetObj.GetCellValue(i, "combined_md") == 1)
				chkCnt++;
		}
		if (eval(lastRow - firstRow) > 2 || rdCnt > 3) {
			combindChk = false;
			ComShowMessage(ComGetMsg('PRD90021'));
			return combindChk;
		}
		// followings are only when the max of difference between 2 rds is 2 and the number of rds is under 4
		// when including the RD-RD-RD
		if (rdCnt == 3 && eval(lastRow - firstRow) == 2) {
			if (ComIsContainsChars(formObj.i_inv, "3") != true) {
				ComShowMessage(ComGetMsg('PRD90034'));
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "combined_md") == 1) {
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
				if (sheetObj.GetCellValue(i, "combined_md") == 1) {
					// out of range - rd
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
				if (sheetObj.GetCellValue(i, "combined_md") == 1) {
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
				if (sheetObj.GetCellValue(i, "combined_md") == 1) {
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
				if (sheetObj.GetCellValue(i, "combined_md") == 1) {
					combindChk = false;
					ComShowMessage(ComGetMsg('PRD90021'));
					return combindChk;
				}
			}
		}
	} else {
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
	sheetObj.CheckAll("combined_md", 0);
	// finding the first and last row which is RD
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
		// checking through RD(dosen't check when it is RTR or the number of RD is 1)
		if (firstRow > 0) {
			for (j = firstRow; j <= lastRow; j++) {
				if (eval(lastRow - firstRow) == 1 || eval(lastRow - firstRow) == 2) {
					sheetObj.SetCellValue(j, "combined_md", 1, 0);
				}
			}
		}
	}
}

/**
 * clearing hidden value in case of new event on detail
 */
function clearDetailHiddenValue(formObj) {
	formObj.i_rout_org_nod_cd.value = '';
	formObj.i_rout_dest_nod_cd.value = '';
	formObj.i_rout_seq.value = '';
	formObj.i_hub_search_gb.value = '';
	formObj.i_front_gb.value = '';
	formObj.i_undefine_nod.value = '';
	formObj.detail_org_i_inv.value = '';
	formObj.detail_org_i_rout_pln_cd.value = '';
	formObj.detail_org_i_bkg_flg.value = '';
	formObj.i_mcntr_rout_flg.value = '';
	formObj.detail_org_i_wrs_fl_cd.value = '';
	formObj.detail_org_i_wrs_mt_cd.value = '';
}

/**
 * 
 */
function doActionIBSheet2(sheetObj, formObj, sAction) {
	var sheetObject2 = sheetObjects[2];
	var uid;
	var sXml;

	var rout_org_nod_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_org_nod_cd");
	var rout_dest_nod_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_dest_nod_cd");
	var rout_seq = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_seq");
	var hub_search_gb = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "hub_search_gb");
	var front_gb = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "front_gb");
	var undefine_nod = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "undefine_nod");
	switch (sAction) {
		case IBSEARCH:
			formObj.f_cmd.value = SEARCH;
			formObj.i_rout_org_nod_cd.value = rout_org_nod_cd;
			formObj.i_rout_dest_nod_cd.value = rout_dest_nod_cd;
			formObj.i_rout_seq.value = rout_seq;
			formObj.i_hub_search_gb.value = hub_search_gb;
			formObj.i_front_gb.value = front_gb;
			formObj.i_undefine_nod.value = undefine_nod;

			sheetObj.DoSearch("ESD_PRD_0057GS.do", PrdFQString(formObj), { Sync : 2 });
			ComEtcDataToForm(formObj, sheetObj);
			formObj.detail_org_i_inv.value = sheetObj.GetEtcData("i_inv");
			formObj.detail_org_i_rout_pln_cd.value = sheetObj.GetEtcData("i_rout_pln_cd");
			formObj.detail_org_i_bkg_flg.value = sheetObj.GetEtcData("i_bkg_flg");
			formObj.i_mcntr_rout_flg.value = sheetObj.GetEtcData("i_mcntr_rout_flg");
			formObj.detail_org_i_wrs_fl_cd.value = sheetObj.GetEtcData("i_wrs_fl_cd");
			formObj.detail_org_i_wrs_mt_cd.value = sheetObj.GetEtcData("i_wrs_mt_cd");

			chkCombindMode(sheetObj);
			if (formObj.disable_bkg_flg.value == 'F') {
				ComEnableObject(formObj.i_bkg_flg, false);
			} else {
				ComEnableObject(formObj.i_bkg_flg, true);
			}
			break;
		case IBSAVE:
			sheetObject2.RemoveAll();
			var isNew = false;
			for ( var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.LastRow()); i++) {
				if (isNew || sheetObj.GetRowStatus(i) == 'I') {
					isNew = true;
				} else {
					isNew = false;
				}
			}
			var invIdx = formObj.i_inv.selectedIndex;
			if (!chkMandatoryForAmerican(formObj, sheetObj)) {
				return;
			}

			if (!checkSpChange(sheetObj)) {
				ComShowMessage(ComGetMsg('PRD90041'));
				return false;
			}
			if (!checkJunk(sheetObj)) {
				ComShowMessage(ComGetMsg('PRD90081'));
				sheetObj.SelectCell(sheetObj.GetSelectRow(), "inlnd_rout_junc_nm");
				return false;
			}

			var detail_org_i_inv = formObj.detail_org_i_inv.value;
			var i_inv = formObj.i_inv.value;
			var detail_org_i_rout_pln_cd = formObj.detail_org_i_rout_pln_cd.value;
			var i_rout_pln_cd = formObj.i_rout_pln_cd.value;
			if (!isNew && (detail_org_i_inv != i_inv || detail_org_i_rout_pln_cd != i_rout_pln_cd)) {
				ComShowMessage(ComGetMsg('PRD90048'));
				return false;
			}

			if (!checkWRS(sheetObj, formObj.r_btn_irg_cd.value)) {
				if (formObj.r_btn_irg_cd.value == 'M') {
					ComShowMessage(ComGetMsg('PRD90079'));
				} else {
					ComShowMessage(ComGetMsg('PRD90086'));
				}
				return false;
			}

			if (!checkRoute2(sheetObj, formObj)) {
				return;
			}

			sheetObject2.DataInsert(-1);
			if (isNew) {
				sheetObjects[0].DataInsert(-1);
				formObj.i_sel_row.value = sheetObjects[0].LastRow();
				sheetObj.SetCellValue(sheetObj.HeaderRows(), "lnk_org_nod_cd", sheetObj.GetCellValue(sheetObj.HeaderRows(), "lnk_org_loc") + sheetObj.GetCellValue(sheetObj.HeaderRows(), "lnk_org_type"), 0);
				sheetObj.SetCellValue(sheetObj.LastRow(), "lnk_dest_nod_cd", sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type"), 0);
				formObj.i_rout_org_nod_cd.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), "lnk_org_nod_cd");
				formObj.i_rout_dest_nod_cd.value = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_nod_cd");
			}
			if (ComIsEmpty(i_origin) || ComIsEmpty(i_destination)) {
				i_origin = formObj.i_rout_org_nod_cd.value;
				i_destination = formObj.i_rout_dest_nod_cd.value;
			}

			var SaveStr = sheetObj.GetSaveString(true);
			if (sheetObj.IsDataModified() && SaveStr == "") {
				return;
			}
			formObj.f_cmd.value = MULTI01;
			sXml = sheetObj.GetSaveData("ESD_PRD_0057MST_ROWSEARCH.do", SaveStr + "&" + PrdFQString(formObj) + "&isNew=" + isNew);
			var strErrMsg = ComGetEtcData(sXml, 'strErrMsg');
			if (strErrMsg == '') {
				bottomFrmClear(formObj);
				formObj.i_org_cd.value = i_origin;
				formObj.i_dest_cd.value = i_destination;
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				sheetObjects[1].RemoveAll();
			} else {
				if (isNew) {
					sheetObjects[0].RowDelete(sheetObjects[0].LastRow());
				}
				ComShowMessage(strErrMsg);
			}
			break;
		case MULTI02: // SAVEAS
			sheetObject2.RemoveAll();
			var updateRow = false;
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetRowStatus(i) != 'R') {
					updateRow = true;
				}
			}
			// checking data excepting grid
			var detail_org_i_inv = formObj.detail_org_i_inv.value;
			var detail_org_i_rout_pln_cd = formObj.detail_org_i_rout_pln_cd.value;
			var detail_org_i_bkg_flg = formObj.detail_org_i_bkg_flg.value;

			var detail_org_i_wrs_fl_cd = formObj.detail_org_i_wrs_fl_cd.value;
			var detail_org_i_wrs_mt_cd = formObj.detail_org_i_wrs_mt_cd.value;

			var i_inv = formObj.i_inv.value;
			var i_rout_pln_cd = formObj.i_rout_pln_cd.value;
			var i_bkg_flg = formObj.i_bkg_flg.value;
			var i_wrs_fl_cd = formObj.wrs_f_chk.value;

			var etcInDataUpdate = true;
			if (detail_org_i_inv == i_inv && detail_org_i_rout_pln_cd == i_rout_pln_cd && detail_org_i_bkg_flg == i_bkg_flg && detail_org_i_wrs_fl_cd == i_wrs_fl_cd) {
				etcInDataUpdate = false;
			}
			// saving when data is created or updated
			if (updateRow || etcInDataUpdate) {
				if (!chkMandatoryForAmerican(formObj, sheetObj))
					return;
				if (!checkJunk(sheetObj)) {
					ComShowMessage(ComGetMsg('PRD90081'));
					return false;
				}

				if (!checkWRS(sheetObj, 'M')) {
					ComShowMessage(ComGetMsg('PRD90079'));
					return false;
				}
				sheetObject2.DataInsert(-1);
				sheetObjects[0].DataInsert(-1);
				formObj.i_sel_row.value = sheetObjects[0].LastRow();
				if (ComIsEmpty(i_origin) || ComIsEmpty(i_destination)) {
					formObj.i_rout_org_nod_cd.value = sheetObj.GetCellValue(sheetObj.HeaderRows(), "lnk_org_nod_cd");
					formObj.i_rout_dest_nod_cd.value = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_nod_cd");
					i_origin = formObj.i_rout_org_nod_cd.value;
					i_destination = formObj.i_rout_dest_nod_cd.value;
				}
				
				var SaveStr = sheetObj.GetSaveString(true);
				if(sheetObj.IsDataModified && SaveStr == "") return;
				formObj.f_cmd.value = MULTI02;
				sXml = sheetObj.GetSaveData("ESD_PRD_0057MST_ROWSEARCH.do", SaveStr + "&" + PrdFQString(formObj));
				var strErrMsg = ComGetEtcData(sXml, 'strErrMsg');
				if (strErrMsg == '') {
					bottomFrmClear(formObj);
					formObj.i_org_cd.value = i_origin;
					formObj.i_dest_cd.value = i_destination;
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
					sheetObjects[1].RemoveAll();
				} else {
					sheetObjects[0].RowDelete(sheetObjects[0].LastRow());
					ComShowMessage(strErrMsg);
					return;
				}
			} else {
				ComShowMessage(ComGetMsg('PRD90042'));
			}
			break;
		case IBINSERT:
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
					ComShowMessage(ComGetMsg('PRD90025'));
					return;
				}
			} else {
				// in case of creating route
				var row = sheetObj.DataInsert(-1);
				sheetObj.SetRowEditable(row, 1);
			}
			break;
		case SEARCH08:
			formObj.f_cmd.value = SEARCH08;
			uid = "ESD_PRD_0057";
			sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			comData1 = ComGetEtcData(sXml, "comData1");
			comData2 = ComGetEtcData(sXml, "comData2");
			// if row count is lesser than 1
			if (retValidate < 1) {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_name", comData2, 0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_seq", "", 0);
				sheetObj.SelectCell(sheetObj.GetSelectRow(), "vndr_seq");
			} else {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vndr_name", comData2, 0);
			}
			break;
	}
}
function chkRailLinkForMt(sheetObj) {
	if (sheetObj.GetCellValue(parseInt(sheetObj.HeaderRows()), "trsp_mod_cd") != "RD" || sheetObj.GetCellValue(sheetObj.LastRow(), "trsp_mod_cd") != "RD") {
		return false;
	}
	return true;
}
/*
 * checking Mandatory elements
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
	// setting i_org_cd,i_dest_cd with from, to which is the value of retrieving
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
	if (gubun == 'B') {
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
		ComShowMessage(ComGetMsg('PRD90007'));
	}
	return retValue;
}
function checkRouteList(sheetObject) {
	var retValue = true;
	var sIRow = sheetObject.FindStatusRow("I");
	if (sIRow.length > 0) {
		sIRow = sIRow + ";";
	}
	// putting received result into array
	var arIRow = sIRow.split(";");
	if (arIRow.length > 1) { // when data exists
		ComShowMessage(ComGetMsg('PRD90026'));
		retValue = false;
	}
	return retValue;
}
// validation for Location code
function validateLocation(loc, num) {
	if (num == 1) {
		document.form.i_org_cd.value = loc.toUpperCase();
	}
	if (num == 2) {
		document.form.i_dest_cd.value = loc.toUpperCase();
	}
	validateData = loc.toUpperCase();
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	if (retValidate < 1) { // if row count is lesser than 1
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
// if there is changed value on row which is USA Rail, showing message that it should be done with 'save as'
function checkSpChange(sheetObj) {
	for ( var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
		// possible to save in case of 'NEW'. duplication will be checked on the server side
		if (sheetObj.GetRowStatus(i) == 'I')
			return true;
	}// for1
	for ( var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
		if (sheetObj.GetRowStatus(i) != 'R') {
			// if the changed data is not sp, it should be done with 'save as'
			// only checking link and sp. the other ones will be done other validation check logic
			// in case of NEW, there will be no data in rout_org_nod_cd,rout_DEST_nod_cd
			// when it is only updated(not existing created data) and clon from,to,mode are same value
			// mode - td : only sp can be modified
			// mode - rd : only junk can be modified
			if (sheetObj.GetCellValue(i, "lnk_org_nod_cd") == sheetObj.GetCellValue(i, "lnk_org_loc") + sheetObj.GetCellValue(i, "lnk_org_type") || sheetObj.GetCellValue(i, "lnk_dest_nod_cd") == sheetObj.GetCellValue(i, "lnk_dest_loc") + sheetObj.GetCellValue(i, "lnk_dest_type")
					|| sheetObj.GetCellValue(i, "clon_trsp_mod_cd") == sheetObj.GetCellValue(i, "trsp_mod_cd")) {
				// if from,to,mode are not changed
				// when it is not RD, only sp can be modified
				if (sheetObj.GetCellValue(i, "trsp_mod_cd") != "RD") {
					if (sheetObj.GetCellValue(i, "clon_agmt_no") != sheetObj.GetCellValue(i, "agmt_no") || sheetObj.GetCellValue(i, "clon_combined_md") != sheetObj.GetCellValue(i, "combined_md") || sheetObj.GetCellValue(i, "clon_inlnd_rout_junc_nm") != sheetObj.GetCellValue(i, "inlnd_rout_junc_nm")) {
						return false;
					}
					// when it is RD, only junk can be modified
				} else if (sheetObj.GetCellValue(i, "clon_agmt_no") != sheetObj.GetCellValue(i, "agmt_no") || sheetObj.GetCellValue(i, "clon_rail_crr_tp_cd") != sheetObj.GetCellValue(i, "rail_crr_tp_cd") || sheetObj.GetCellValue(i, "clon_vndr_seq") != sheetObj.GetCellValue(i, "vndr_seq")) {
					return false;
				}
			} else {
				// using save as
				return false;
			}
		}
	}// for2
	return true;
}
/*
 * JUNK validation in case of USA Rail if the consecutive data are RD, JUNK is mandatory
 */
function checkJunk(sheetObj) {
	var nextIdx = 0;
	var totRowCnt = sheetObj.HeaderRows() + sheetObj.RowCount();
	for ( var i = sheetObj.HeaderRows(); i < (sheetObj.HeaderRows() + sheetObj.RowCount()); i++) {
		nextIdx = i + 1;
		if (nextIdx < totRowCnt) {
			if (sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD" && sheetObj.GetCellValue(nextIdx, "trsp_mod_cd") == "RD") {
				// if junc value is empty in case of RD-RD
				if (ComIsEmpty(sheetObj.GetCellValue(i, "inlnd_rout_junc_nm"))) {
					return false;
				}
			} else {
				// if junc value is not empty when it is not case of RD-RD
				if (!ComIsEmpty(sheetObj.GetCellValue(i, "inlnd_rout_junc_nm"))) {
					return false;
				}
			}
		} else if (i == sheetObj.RowCount() && !ComIsEmpty(sheetObj.GetCellValue(i, "inlnd_rout_junc_nm"))) {
			return false;
		}
	}// for
	return true;
}
/*
 * checking connection
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

	// putting received result into array
	var arIRow = sIRow.split(";");
	if (arIRow.length > 0) {
		arIRow = arIRow + ";";
	}
	// formObj.i_newRouteCd.value = "";
	formObj.i_new_route_cd.value = "";
	// in case of updating Route, checking it is same with value of master
	// checking it is updated
	var gubun = '';
	for (i = 0; i < formObj.r_inbound.length; i++) {
		if (formObj.r_inbound[i].checked) {
			gubun = formObj.r_inbound[i].value;
		}
	}
	// in case of new Route, no checking on USA FULL
	if (arIRow.length >= 2 && arURow.length == 1) {
		// formObj.i_newRouteCd.value = "Y";
		formObj.i_new_route_cd.value = "Y";
		formObj.i_rout_seq.value = 0;
		formObj.i_rout_org_nod_cd.value = sheetObj.GetCellValue(1, "lnk_org_loc") + sheetObj.GetCellValue(1, "lnk_org_type");
		formObj.i_rout_dest_nod_cd.value = sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_loc") + sheetObj.GetCellValue(sheetObj.LastRow(), "lnk_dest_type");
	} else {
		if (arURow.length > 1) {
			// formObj.i_newRouteCd.value = "N";
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
	// checking the connection
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
			orgSheetVal = sheetObj.GetCellValue(i, "org_loc");
			destSheetVal = sheetObj.GetCellValue(i, "rout_dest_nod_cd");
		}
		if (gubun == 'B') { // 5,5
			orgSheetVal = sheetObj.GetCellValue(i, "org_loc");
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
	if (gubun == 'B') {
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
	var colArray = rowArray[0];
	document.all.i_org_cd.value = colArray[3];
}
function getOrgLoc(rowArray) {
	var colArray = rowArray[0];
	document.all.i_org_cd.value = colArray[3];
}
function getDestLoc(rowArray) {
	var colArray = rowArray[0];
	document.all.i_dest_cd.value = colArray[3];
}

/**
 * priority will be given as retrieving data
 */
var delCnt = 1;
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var ColSaveName = sheetObj.ColSaveName(Col);
	if (ColSaveName == "prio_seq") {
		if (Value == '') {
			return false;
		}

		var o = Number(Value);
		if (o == 0) {
			sheetObj.SetCellValue(Row, Col, sheetObj.GetCellValue(Row, "ori_prio_seq"), 0);
			ComShowMessage(ComGetMsg('PRD90090'));
		} else {
			sheetObj.SetCellValue(Row, Col, o, 0);
		}
		return false;
	} else if (ColSaveName == 'wrs_full_cmdt') {
		if (Value == 1) {
			var org_nod_cd = sheetObj.GetCellValue(Row, "rout_org_nod_cd");
			var dest_nod_cd = sheetObj.GetCellValue(Row, "rout_dest_nod_cd");

			var org_idx = sheetObj.FindCheckedRow(Col);
			var arrRow = org_idx.split("|");
			for (idx = 0; idx < arrRow.length; idx++) {
				if (Row == arrRow[idx] || org_nod_cd != sheetObj.GetCellValue(arrRow[idx], "rout_org_nod_cd") || dest_nod_cd != sheetObj.GetCellValue(arrRow[idx], "rout_dest_nod_cd")) {
					continue;
				} else {
					if (ComShowCodeConfirm('PRD90087')) {
						break;
					} else {
						sheetObj.SetCellValue(Row, "wrs_full_cmdt", 0, 0);
						return;
					}
				}
			}
			sheetObj.SetCellValue(Row, "inlnd_rout_bkg_flg", 1, 0);
			if (!(sheetObj.GetCellValue(Row, "prio_seq") == "1")) {
				if (ComShowCodeConfirm("PRD90088")) {
					sheetObj.SetCellValue(Row, "old_prio_seq", sheetObj.GetCellValue(Row, "prio_seq"), 0);
					sheetObj.SetCellValue(Row, "prio_seq", "1", 0);
					// sheetObj.SetCellValue(Row,"force_prio_flg", "Y", 0);
				} else {
					sheetObj.SetCellValue(Row, "old_prio_seq", sheetObj.GetCellValue(Row, "prio_seq"), 0);
				}
			}
		}
	}
}

/**
 * 
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var ColSaveName = sheetObj.ColSaveName(Col);
	var RowStatus = sheetObj.GetRowStatus(Row);
	var lnk_org_loc_cd = sheetObj.GetCellValue(Row, "lnk_org_loc") + sheetObj.GetCellValue(Row, "lnk_org_type");
	var lnk_dest_loc_cd = sheetObj.GetCellValue(Row, "lnk_dest_loc") + sheetObj.GetCellValue(Row, "lnk_dest_type");
	if ((RowStatus == "I" || RowStatus == "U") && (ColSaveName == "lnk_org_loc" || ColSaveName == "lnk_dest_loc" || ColSaveName == "trsp_mod_cd" || ColSaveName == "lnk_org_type" || ColSaveName == "lnk_dest_type")) {
		// checking link validation
		if (sheetObj.GetCellValue(Row, "lnk_org_loc") != "" && sheetObj.GetCellValue(Row, "lnk_dest_loc") != "" && sheetObj.GetCellValue(Row, "trsp_mod_cd") != "" && sheetObj.GetCellValue(Row, "lnk_org_type") != "" && sheetObj.GetCellValue(Row, "lnk_dest_type") != "") {
			// conversion of function[check again]CLT
			sheetObj.DoRowSearch(Row, "ESD_PRD_000 5ROWSEARCH.do", "f_cmd=" + SEARCH11 + "&from_nod=" + lnk_org_loc_cd + "&to_nod=" + lnk_dest_loc_cd + "&trsp_mod=" + sheetObj.GetCellValue(Row, "trsp_mod_cd") + "&row=" + Row + "&col=" + Col, { Sync : 2 })
			if (sheetObj.GetEtcData("rowCount") == 0) {
				sheetObj.SetCellValue(Row, "vndr_seq", "", 0);
				sheetObj.SetCellValue(Row, "vndr_name", "", 0);
				sheetObj.SetCellValue(Row, "tztm_hrs", "", 0);
				sheetObj.SetCellValue(Row, "rail_crr_tp_cd", "", 0);
				sheetObj.SetCellValue(Row, "combined_md", "", 0);
				sheetObj.SetCellValue(Row, "inlnd_rout_junc_nm", "", 0);
				sheetObj.SelectCell(Row, "lnk_dest_loc");
			}
		}
	} else if (ColSaveName == "vndr_seq") {
		if (Value.length > 0) {
			validateData = Value;
			doActionIBSheet2(sheetObj, document.form, SEARCH08);
		} else {
			sheetObj.SetCellValue(Row, "vndr_name", "", 0);
		}
	} else if (ColSaveName == "agmt_no") {
		if (Value == "") {
			sheetObj.SetCellValue(Row, "refe_no", "", 0);
			return false;
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
				ComShowCodeMessage('PRD90070');
				sheetObj.SetCellBackColor(Row, "vndr_seq", "#FFA040");
				sheetObj.SetCellBackColor(Row, "agmt_no", "#FFA040");
			} else {
				sheetObj.SetCellBackColor(Row, "vndr_seq", "#FFFFFF");
				sheetObj.SetCellBackColor(Row, "agmt_no", "#FFFFFF");
			}
		}
	}
	// editable in case of USA Rail (S) -----------------------------------------------
	if (sheetObj.GetCellValue(Row, "trsp_mod_cd") == "RD") {
		sheetObj.SetCellEditable(Row, "agmt_no", 1);
		sheetObj.SetCellEditable(Row, "rail_crr_tp_cd", 1);
		sheetObj.SetCellEditable(Row, "inlnd_rout_junc_nm", 1);
	} else {
		sheetObj.SetCellEditable(Row, "agmt_no", 0);
		sheetObj.SetCellEditable(Row, "rail_crr_tp_cd", 0);
		sheetObj.SetCellEditable(Row, "inlnd_rout_junc_nm", 0);
		sheetObj.SetCellValue(Row, "refe_no", "", 0);
		sheetObj.SetCellValue(Row, "rail_crr_tp_cd", "", 0);
		sheetObj.SetCellValue(Row, "inlnd_rout_junc_nm", "", 0);
		if (!ComIsEmpty(sheetObj.GetCellValue(Row, "agmt_no"))) {
			sheetObj.SetCellValue(Row, "agmt_no", "", 0);
			sheetObj.SelectCell(Row, "agmt_no");
			ComShowCodeMessage('PRD90049');
			return false;
		}
		// if(!ComIsEmpty(sheetObj.GetCellValue(Row,"refe_no")) ) {
		// sheetObj.SetCellValue(Row,"refe_no","",0);
		// sheetObj.SelectCell(Row,"refe_no");
		// ComShowCodeMessage('PRD90050');
		// return false;
		// }
		// if(!ComIsEmpty(sheetObj.GetCellValue(Row,"rail_crr_tp_cd")) ) {
		// sheetObj.SetCellValue(Row,"rail_crr_tp_cd","",0);
		// sheetObj.SelectCell(Row,"rail_crr_tp_cd");
		// ComShowCodeMessage('PRD90051');
		// return false;
		// }
		// if(!ComIsEmpty(sheetObj.GetCellValue(Row,"inlnd_rout_junc_nm")) ) {
		// sheetObj.SetCellValue(Row,"inlnd_rout_junc_nm","",0);
		// sheetObj.SelectCell(Row,"inlnd_rout_junc_nm");
		// ComShowCodeMessage('PRD90052');
		// }
	}
	// editable in case of USA Rail (E) -----------------------------------------------
}
/*
 * calling Biz common pop up from sheet - calling comPopupInSheet() : Parameter - row, col
 */
function sheet2_OnPopupClick(sheetObj, row, col) {
	var loc_cd_val;
	var dispaly;
	var classId;
	var param;
	var chkStr;
	var ColSaveName = sheetObj.ColSaveName(col);

	if (ColSaveName == "lnk_org_loc" || ColSaveName == "lnk_dest_loc") {
		loc_cd_val = sheetObj.GetCellValue(row, col);
		dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
		classId = "COM_ENS_061";
		param = '?loc_cd=' + loc_cd_val + '&classId=' + classId;
		chkStr = dispaly.substring(0, 3)
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true, true, row, col);
	} else if (ColSaveName == "vndr_seq") {
		loc_cd_val = sheetObj.GetCellValue(row, col);
		dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
		classId = "COM_ENS_0C1";
		param = '?pts_vndr_cd=' + loc_cd_val + '&classId=' + classId;
		chkStr = dispaly.substring(0, 3)
		// Radio PopUp
		if (chkStr == "1,0") {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 800, 560, 'getVendor', dispaly, true, false, row, col, 1);
		} else {
			ComShowCodeMessage('PRD90063');
			return;
		}
	}
}
function getVendor(rowArray, row, col) {
	var sheetObj = sheetObjects[1];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(parseInt(row), "vndr_seq", colArray[2], 0);
	sheetObj.SetCellValue(parseInt(row), "vndr_name", colArray[4], 0);
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
 * deactivating form input value
 */
function bottomFrmDisable(gb) {
	var formObj = document.form;
	if (gb) {
		ComEnableObject(formObj.i_inv, false);
		ComEnableObject(formObj.i_rout_pln_cd, false);
		ComEnableObject(formObj.i_wrs_fl_cd, false);
		ComEnableObject(formObj.i_wrs_mt_cd, false);
	} else {
		ComEnableObject(formObj.i_inv, true);
		ComEnableObject(formObj.i_rout_pln_cd, true);
		ComEnableObject(formObj.i_wrs_fl_cd, true);
		ComEnableObject(formObj.i_wrs_mt_cd, true);
	}
	var gubun = formObj.r_btn_irg_cd.value;
}
function chkMandatory4Search(formObj) {
	var inputCnt = 0;
	if (formObj.i_hub_loc.value.length > 0) {
		if (!(formObj.i_hub_loc.value.length == 5 || formObj.i_hub_loc.value.length == 7)) {
			ComShowMessage(ComGetMsg('PRD90095'));
			formObj.i_hub_loc.select();
			formObj.i_hub_loc.focus();
			return false;
		} else {
			if (formObj.i_org_cd.value.length < 1 && formObj.i_dest_cd.value.length < 1) {
				ComShowMessage(ComGetMsg('PRD90096'));
				return false;
			}
		}
	} else {
		if (formObj.i_org_cd.value.length < 2 || formObj.i_dest_cd.value.length < 5) {
			ComShowMessage(ComGetMsg('PRD90096'));
			return false;
		}
	}
	return true;
}
function bottomFrmClear(formObj) {
	ComClearObject(formObj.i_inv);
	ComClearObject(formObj.i_rout_pln_cd);
	ComClearObject(formObj.i_bkg_flg);
	ComClearObject(formObj.wrs_f_chk);
	ComClearObject(formObj.i_route_rmk);
}
function changeNodTy1(nodTy) {
	document.form.r_btn_nod_ty_cd.value = nodTy;
}
function changeSelection(gubun) {
	var formObj = document.form;
	formObj.r_btn_irg_cd.value = gubun;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	if (gubun == 'B') {
		ComClearObject(formObj.i_hub_loc);
		ComEnableObject(formObj.i_hub_loc, false);
		ComEnableObject(formObj.nod_tp_cd1[0], false);
		ComEnableObject(formObj.nod_tp_cd1[1], false);
		formObj.r_btn_nod_ty_cd.value = 'X';
	} else {
		ComEnableObject(formObj.i_hub_loc, true);
		ComEnableObject(formObj.nod_tp_cd1[0], true);
		ComEnableObject(formObj.nod_tp_cd1[1], true);
		for ( var index = 0; index < formObj.nod_tp_cd1.length; index++) {
			if (formObj.nod_tp_cd1[index].checked == true) {
				formObj.r_btn_nod_ty_cd.value = formObj.nod_tp_cd1[index].value;
			}
		}
	}
	bottomFrmClear(formObj);
}
var portInd = '';
function selectTml(frm, pt) {
	portInd = pt;
	if (pt == 'IB_ORG_TML')
		param = "?node_cd=" + frm.i_org_cd_ib.value;
	if (pt == 'OB_DEST_TML')
		param = "?node_cd=" + frm.i_dest_cd_ob.value;
	if (pt == 'TS_ORG_YD')
		param = "?node_cd=" + frm.i_org_cd_ts.value;
	if (pt == 'TS_DEST_YD')
		param = "?node_cd=" + frm.i_dest_cd_ts.value;
	if (pt == 'MT_ORG_YD')
		param = "?node_cd=" + frm.i_org_cd_ts.value;
	if (pt == 'MT_DEST_YD')
		param = "?node_cd=" + frm.i_dest_cd_ts.value;
	comPopup('/opuscntr/COM_ENS_061.do' + param, 800, 550, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1');
}
function getCOM_ENS_061(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'IB_ORG_TML') {
		frm.i_org_cd_ib.value = cArray[3];
	}
	if (portInd == 'OB_DEST_TML') {
		frm.i_dest_cd_ob.value = cArray[3];
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
	var param = '?loc_port_ind=1';
	portInd = pt;
	if (portInd == 'IB_DEST_LOC') {
		param = param + '&node_cd=' + frm.i_dest_cd.value;
	}
	if (portInd == 'IB_ORG_LOC') {
		param = param + '&node_cd=' + frm.i_org_cd.value;
	}
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNodeCd', "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
function getNodeCd(rowArray) {
	var colArray = rowArray[0];
	if (portInd == 'IB_DEST_LOC') {
		document.all.i_dest_cd.value = colArray[3];
	}
	if (portInd == 'IB_ORG_LOC') {
		document.all.i_org_cd.value = colArray[3];
	}
}
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'IB_ORG_LOC') {
		frm.i_org_cd.value = cArray[3];
	}
	if (portInd == 'IB_DEST_LOC') {
		frm.i_dest_cd.value = cArray[3];
	}
}
/**
 * 
 */
function changeDeltFlg() {
	var frm = document.form;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
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
	var i_org_cd = formObject.i_org_cd.value;
	var i_dest_cd = formObject.i_dest_cd.value;
	var i_hub_loc = formObject.i_hub_loc.value;
	if (i_org_cd == "" && i_dest_cd == "") {
		ComShowCodeMessage("COM130403", 'Origin CD or Dest CD');
		return false;
	} else {
		if (i_org_cd.length > 0) {
			if (!(i_org_cd.length == 5 || i_org_cd.length == 7)) {
				ComShowMessage(ComGetMsg('PRD90119', 'two', '5 or 7'));
				formObject.i_org_cd.select();
				formObject.i_org_cd.focus();
				return false;
			}
			var org = i_org_cd.substring(0, 2);
			if (chkAmericaCnt("i_org_cd") == false) {
				ComShowMessage(ComGetMsg('PRD90097'));
				formObject.i_org_cd.select();
				formObject.i_org_cd.focus();
				return false;
			}
			var cnt_cd = document.form.cnt_cd.value;
			var org_cd = document.form.i_org_cd.value;
			var cnt = 0;
			if (cnt_cd != null && cnt_cd.length >= 3) {
				for ( var idx = 0; idx < cnt_cd.length; idx = idx + 3) {
					if (cnt_cd.substr(idx, 2) == org_cd.substr(0, 2)) {
						cnt++;
					}
				}
			}
		}
		if (i_dest_cd.length > 0) {
			if (!(i_dest_cd.length == 5 || i_dest_cd.length == 7)) {
				ComShowMessage(ComGetMsg('PRD90119', 'two', '5 or 7'));
				formObject.i_dest_cd.select();
				formObject.i_dest_cd.focus();
				return false;
			}
			var dest = i_dest_cd.substring(0, 2);
			if (chkAmericaCnt("i_dest_cd") == false) {
				ComShowMessage(ComGetMsg('PRD90097'));
				formObject.i_dest_cd.select();
				formObject.i_dest_cd.focus();
				return false;
			}
		}
		if (i_hub_loc.length > 0) {
			if (!(i_hub_loc.length == 5 || i_hub_loc.length == 7)) {
				ComShowMessage(ComGetMsg('PRD90119', 'two', '5 or 7'));
				formObject.i_hub_loc.select();
				formObject.i_hub_loc.focus();
				return false;
			}
			var hub = i_hub_loc.substring(0, 2);
			if (chkAmericaCnt("i_hub_loc") == false) {
				ComShowMessage(ComGetMsg('PRD90097'));
				formObject.i_hub_loc.select();
				formObject.i_hub_loc.focus();
				return false;
			}
		}
	}
	return true;
}
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
function isInvCnt(formObj) {
	if (formObj.i_org_cd.value.length > 0 && (formObj.i_org_cd.value.length >= 5 && formObj.i_org_cd.value.length <= 7)) {
		var org = formObj.i_org_cd.value.substring(0, 2);
		if (org == "US" || org == "CA") {
			return true;
		}
	}
	if (formObj.i_dest_cd.value.length > 0 && (formObj.i_dest_cd.value.length >= 5 && formObj.i_dest_cd.value.length <= 7)) {
		var des = formObj.i_dest_cd.value.substring(0, 2);
		if (des == "US" || des == "CA") {
			return true;
		}
	}
	if (formObj.i_hub_loc.value.length > 0 && (formObj.i_hub_loc.value.length >= 5 && formObj.i_hub_loc.value.length <= 7)) {
		var hub = formObj.i_hub_loc.value.substring(0, 2);
		if (hub == "US" || hub == "CA") {
			return true;
		}
	}
	return false;
}

/**
 * Check WRS
 */
function checkWRS(sheetObj, irgGb) {
	var formObj = document.form;
	var inv = formObj.i_inv.value;
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
		var cTofc = sheetObj.GetCellValue(i, "rail_crr_tp_cd");
		var sp = sheetObj.GetCellValue(i, "vndr_seq");
		if (inv == 'S2R') {
			if (irgGb != 'M' && formObj.wrs_f_chk.checked) {
				formObj.i_inv.focus();
				return false;
			}
		}
		if (cTofc.substring(0, 1) == 'T') {
			if (irgGb != 'M' && formObj.wrs_f_chk.checked) {
				sheetObj.SelectCell(i, "rail_crr_tp_cd");
				return false;
			}
		}
		if (sp == '108386') {
			if (irgGb != 'M' && formObj.wrs_f_chk.checked) {
				sheetObj.SelectCell(i, "vndr_seq");
				return false;
			}
		}
	}
	return true;
}
