/*========================================================= 
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName 	 : ESD_PRD_0055.js
 *@FileTitle  : Inland Route Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/26
=========================================================*/
function ESD_PRD_0055() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
	this.sheetMinimize = sheetMinimize;
	this.prdComKeyDown = prdComKeyDown;
	this.sheet1_OnDblClick = sheet1_OnDblClick;
	this.chkCombindMode = chkCombindMode;
	this.setCombindMode = setCombindMode;
	this.doActionIBSheet2 = doActionIBSheet2;
	this.validateLocation = validateLocation;
	this.getCOM_ENS_051_1 = getCOM_ENS_051_1;
	this.getOrgLoc = getOrgLoc;
	this.getDestLoc = getDestLoc;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
	this.sheet2_OnPopupClick = sheet2_OnPopupClick;
	this.getVendor = getVendor;
	this.getNode = getNode;
	this.validateForm = validateForm;
	this.bottomFrmDisable = bottomFrmDisable;
	this.disableObjectR = disableObjectR;
	this.enableObjectR = enableObjectR;
	this.chkAmericanContinent = chkAmericanContinent;
	this.clearObjectN = clearObjectN;
	this.bottomFrmClear = bottomFrmClear;
	this.inputChkFromTo = inputChkFromTo;
	this.selectTml = selectTml;
	this.getCOM_ENS_061 = getCOM_ENS_061;
	this.selectLoc = selectLoc;
	this.getCOM_ENS_051 = getCOM_ENS_051;
	this.changeSelection = changeSelection;
}
// Common global variable
var tabObjects = new Array();
var sheetObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetCnt = 0;
var maxPrioSeq = 0;
var i_origin = "";
var i_destination = "";
var validateData = "";
var retValidate = 0;
var priority_seq = "";
var min_state = 'MIN';
var nodeCd = "";
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	var classId;
	var param;
	var chkStr;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		var keyObj = window.event.keyCode;
		var srcObj = ComGetEvent("nodeName");
		switch (srcName) {
			case "btn_retrieve":
				sheetObject1.RemoveAll();
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				if (!chkAmericanContinent(formObject)) {
					bottomFrmDisable(true);
				} else {
					bottomFrmDisable(false);
				}
				bottomFrmClear(formObject);
				enableObjectR(formObject.i_bkg_flg);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				formObject.reset();
				break;
			case "btn_org_loc":
				classId = "COM_ENS_051";
				param = '?classId=' + classId;
				chkStr = dispaly.substring(0, 3);
				if (chkStr == "1,0") {
					ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getOrgLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				} else {
					ComShowMessage(ComGetMsg('PRD90063'));
					return;
				}
				break;
			case "btn_dest_loc":
				classId = "COM_ENS_0051";
				param = '?classId=' + classId;
				chkStr = dispaly.substring(0, 3)
				if (chkStr == "1,0") {
					ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getDestLoc', "1,0,1,1,1,1,1,1,1,1,1,1", true);
				} else {
					ComShowMessage(ComGetMsg('PRD90063'));
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
			case "ib_dest_loc_btn":
				selectLoc(formObject, 'IB_DEST_LOC');
				break;
			case "ib_org_loc_btn":
				selectLoc(formObject, 'IB_ORG_LOC');
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
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * 
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	bottomFrmDisable(true);
	axon_event.addListenerForm('change', 'form_onChange', form);
}

function form_onChange(evt, el) {
	var formObj = document.form;
	var xml = "";
	var srcName;
	var srcValue;
	if (el) {
		srcName = el.getAttribute("name");
		srcValue = el.getAttribute("value");
	} else {
		srcName = ComGetEvent("name");
		srcValue = ComGetEvent("value");
	}
	if (srcName == "i_org_cd") {
		inputChkUpper(document.form.i_org_cd, 0, 'SEARCH02');
	} else if (srcName == "i_dest_cd") {
		inputChkUpper(document.form.i_dest_cd, 0, 'SEARCH02');
	}
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
            with(sheetObj){
        	         var HeadTitle="Del.|BKG|STS|Constraint|Priority|ORG.LOC|Node|DEST.LOC|Node|Route|Tmp Flg|FreeInc|Total T/T|IO_BND_CD|N1ST_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N2ND_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N3RD_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N4TH_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N5TH_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N6TH_NODE|Trans Mode|VNDR code|VNDR Name|AGMT_NO|AGMT_CRE_OFC_CD|AGMT_REF_NO|N7TH_NODE|Creation office|Creation Date(YYYY-MM-DD)|Remarks|Rout Org Nod Cd|Rout Dest Nod Cd|Rout SEQ|Hub Search Gb|Front Gb|Undefine Nod|Gu|Ori" ;
        	         var prefix="";
        	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
        	         InitHeaders(headers, info);
        	         var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delChk",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inlnd_rout_bkg_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
	            	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Image",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnst_flg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"prio_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"org_loc",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"org_loc_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dest_loc",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dest_loc_type",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:470,  Align:"Left",    ColMerge:0,   SaveName:prefix+"route",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inlnd_rout_tmp_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
	            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inlnd_rout_incl_sttl_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
	            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_tt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"io_bnd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_agmt_cre_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_agmt_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_agmt_cre_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_agmt_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_agmt_cre_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_agmt_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_agmt_cre_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n4th_agmt_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_agmt_cre_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n5th_agmt_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_vndr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_agmt_cre_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n6th_agmt_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n7th_nod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inlnd_rout_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_org_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_dest_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_search_gb",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"front_gb",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"undefine_nod",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"group_gubun",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ori_prio_seq",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnst_rmk",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	            	          
        	         InitColumns(cols);
        	         SetEditable(1);
        	         sheetObj.SetSheetHeight(200);
        	         SetColProperty(prefix+"prio_seq", {ComboText:"|", ComboCode:"|"} );
        	         SetImageList(0,"/opuscntr/img/opus/ico_r.gif");
        	         SetColProperty(prefix+"tot_tt", {Format:"##D##H"} );
        	 }
            break;
        case 2:      //IBSheet2 init
            with(sheetObj){
		             var HeadTitle="Del.|STS|SEQ|Clear|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T(DD.HH)|AGMT No|Reference No|Combined Mode|C/TOFC|Junction|a|b|c|d|e|f|G|F|fc" ;
		             var prefix="";
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		             var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rnllws",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibseq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"clear_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lnk_org_loc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
					                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lnk_org_type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
					                 {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lnk_dest_loc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
					                 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lnk_dest_type",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
					                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vndr_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"vndr_abbr_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fmt_tztm_hrs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"agmt_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
					                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"agmt_ref_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                 {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inlnd_rout_cmb_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 , TrueValue:"Y", FalseValue:"N"},
					                 {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rail_crr_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inlnd_rout_junc_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lnk_org_nod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lnk_dest_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"clon_trsp_mod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_org_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_dest_nod_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rout_dtl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"selRow",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					                 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fc",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             InitColumns(cols);
		             SetEditable(1);
		             SetColProperty(prefix+"trsp_mod_cd", {ComboText:trsp_mod_cdText, ComboCode:trsp_mod_cdCode} );
		             SetColProperty(prefix+"rail_crr_tp_cd", {ComboText:rail_crr_tp_cdText, ComboCode:rail_crr_tp_cdCode} );
		             SetColProperty(prefix+"fmt_tztm_hrs", {AcceptKeys:"N", Format:"##.##"} );
		             
		             ComResizeSheet(sheetObj, 100);     
         }
         break;
    }
}

// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var sXml;
	switch (sAction) {
		case IBSEARCH:
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			if (!ComChkRequired(formObj)) {
				return false;
			}

			formObj.f_cmd.value = SEARCHLIST01;
			i_origin = formObj.i_org_cd.value;
			i_destination = formObj.i_dest_cd.value;
			var prefix = "";
			ComOpenWait(true);
			setTimeout(function() {
				var sXml = sheetObj.GetSearchData("ESD_PRD_0055GS.do", PrdFQString(formObj) + "&" + ComGetPrefixParam(""));
				sheetObj.LoadSearchData(sXml, { Append : 1, Sync : 1 });
				priority_seq = ComGetEtcData(sXml, "prio_seq_combo");
				sheetObjects[0].InitDataCombo(0, prefix + "prio_seq", ComGetEtcData(sXml, "prio_seq_combo"), ComGetEtcData(sXml, "prio_seq_combo"));
				maxPrioSeq = ComGetEtcData(sXml, "maxPrioSeq")
				sheetObj.DoSearch("ESD_PRD_0055GS.do", PrdFQString(formObj) + "&" + ComGetPrefixParam(""), { Sync : 2 });
				ComOpenWait(false);
			}, 100);
			break;
		case SEARCH02:
			formObj.f_cmd.value = SEARCH02;
			sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=ESD_PRD_0055&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case SEARCH05:
			formObj.f_cmd.value = SEARCH05;
			sXml = sheetObj.GetSearchData("PRD_VALIDATE.do", "uid=ESD_PRD_0055&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case IBDOWNEXCEL:
			sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			break;
	}
}

/**
 * 
 */
function sheet1_OnDblClick(sheetObj, Row, col, value) {
	var formObj = document.form;
	formObj.i_selRow.value = Row;
	var cnstRmk = sheetObj.GetCellValue(Row, "cnst_rmk");
	if (!ComIsNull(cnstRmk)) {
		ComShowMessage(cnstRmk);
	}
	doActionIBSheet2(sheetObjects[1], formObj, IBSEARCH);
}

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
	if (inv.substring(0, 1) == 'C' || inv.substring(0, 1) == 'S') {
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
			if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1)
				chkCnt++;
		}
		// the max of difference between 2 rds is 2, the max of the number of RD link is 3
		if (eval(lastRow - firstRow) > 2 || rdCnt > 3) {
			combindChk = false;
			ComShowCodeMessage('PRD90021');
			return combindChk;
		}
		// followings are only when the max of difference between 2 rds is 2 and the number of rds is under 4
		// when including the RD-RD-RD
		if (rdCnt == 3 && eval(lastRow - firstRow) == 2) {
			if (ComIsContainsChars(formObj.i_inv, "3") != true) {
				ComShowCodeMessage('PRD90034');
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					if (i < firstRow || i > lastRow) {
						combindChk = false;
						ComShowCodeMessage('PRD90021');
						return combindChk;
					}
				} else {
					if (i >= firstRow && i <= lastRow) {
						combindChk = false;
						ComShowCodeMessage('PRD90021');
						return combindChk;
					}
				}
			}
			// when including the RD-RD
		} else if (rdCnt == 2 && eval(lastRow - firstRow) == 1) { // if it has two consecutive rds
			if (ComIsContainsChars(formObj.i_inv, "2") != true) {
				ComShowCodeMessage('PRD90034');
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					// out of range of rd
					if (i < firstRow || i > lastRow) {
						combindChk = false;
						ComShowCodeMessage('PRD90021');
						return combindChk;
					}
				} else {
					if (i >= firstRow && i <= lastRow) {
						combindChk = false;
						ComShowCodeMessage('PRD90021');
						return combindChk;
					}
				}
			}
			// when the number of rd is 2 and it is RD-TD-RD
		} else if (rdCnt == 2 && eval(lastRow - firstRow) == 2) {
			if (ComIsContainsChars(formObj.i_inv, "1") != true) {
				ComShowCodeMessage('PRD90034');
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					combindChk = false;
					ComShowCodeMessage('PRD90021');
					return combindChk;
				}
			}
		} else if (rdCnt == 1) {
			if (ComIsContainsChars(formObj.i_inv, "1") != true) {
				ComShowCodeMessage('PRD90034');
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					combindChk = false;
					ComShowCodeMessage('PRD90021');
					return combindChk;
				}
			}
		} else if (rdCnt == 0) {
			var invIdx = formObj.i_inv.selectedIndex;
			if (invIdx > 0) {
				ComShowCodeMessage('PRD90034');
				combindChk = false;
				return combindChk;
			}
			for ( var i = sheetObj.HeaderRows(); i < sheetObj.LastRow() + 1; i++) {
				if (sheetObj.GetCellValue(i, "inlnd_rout_cmb_flg") == 1) {
					combindChk = false;
					ComShowCodeMessage('PRD90021');
					return combindChk;
				}
			}
		}
	} else { // checking that sp is same when mode is different and inv billing,pattern is not 'C','S' and combind mode is set
		var sp = '';
		var firstCombindMode = false;
		var firstCombindCnt = 0;
		for ( var j = sheetObj.HeaderRows(); j < sheetObj.LastRow() + 1; j++) {
			if (sheetObj.GetCellValue(j, "inlnd_rout_cmb_flg") == 1 && firstCombindMode == false && sheetObj.RowCount() > 1) { // in case of first combind
				sp = sheetObj.GetCellValue(j, "vndr_seq");
				firstCombindMode = true;
				firstCombindCnt++;
			} else if (sheetObj.GetCellValue(j, "inlnd_rout_cmb_flg") == 1 && firstCombindMode == true && sheetObj.RowCount() > 1) { // after first combind
				if (sp != sheetObj.GetCellValue(j, "vndr_seq")) {
					ComShowCodeMessage('PRD90022');
					combindChk = false;
					return combindChk;
				}
			} else if (sheetObj.GetCellValue(j, "inlnd_rout_cmb_flg") == 1 && sheetObj.RowCount() == 1) { // when there is 1 data
				ComShowCodeMessage('PRD90023');
				combindChk = false;
				return combindChk;
			} else if (firstCombindMode == true && firstCombindCnt < 2) { // when there is 1 checked data
				ComShowCodeMessage('PRD90024');
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
	if (inv.substring(0, 1) == 'C' || inv.substring(0, 1) == 'S') {
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
	sheetObj.ShowDebugMsg(false);
	var rout_org_nod_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_org_nod_cd");
	var rout_dest_nod_cd = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_dest_nod_cd");
	var rout_seq = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "rout_seq");
	var hub_search_gb = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "hub_search_gb");
	var front_gb = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "front_gb");
	var undefine_nod = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "undefine_nod");
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value = SEARCH;
				formObj.i_rout_org_nod_cd.value = rout_org_nod_cd;
				formObj.i_rout_dest_nod_cd.value = rout_dest_nod_cd;
				formObj.i_rout_seq.value = rout_seq;
				formObj.i_hub_search_gb.value = hub_search_gb;
				formObj.i_front_gb.value = front_gb;
				formObj.i_undefine_nod.value = undefine_nod;
				sheetObj.DoSearch("ESD_PRD_0055GS.do", PrdFQString(formObj), { Sync : 2 });
				ComEtcDataToForm(formObj, sheetObj);
				chkCombindMode(sheetObj);
				if (formObj.disable_bkg_flg.value == 'F') {
					ComEnableObject(formObj.i_bkg_flg, false);
				} else {
					ComEnableObject(formObj.i_bkg_flg, true);
				}
			}
			break;
	}
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
			// document.form.i_org_cd.value = "";
			document.form.i_route_rmk.focus();
		} else if (num == 2) {
			// document.form.i_dest_cd.value = "";
			document.form.i_dest_cd.focus();
		}
	} else {
		if (num == 1) {
			// document.form.i_org_cd.value = "";
			document.form.i_dest_cd.focus();
		}
	}
	return false;
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
function sheet2_OnSearchEnd(sheetObj) {
	var formObj = document.form;
	for ( var i = 1; i <= sheetObj.GetTotalRows(); i++) {
		if (formObj.i_hub_search_gb.value == "Y") {
			sheetObj.SetCellValue(i, "rnllws", 'R', 0);
			sheetObj.SetRowStatus(i, 'I');
		}
		if (sheetObj.GetCellValue(i, "fc") == "T") {
			sheetObj.SetCellEditable(i, "rail_crr_tp_cd", 1);
		} else {
			sheetObj.SetCellEditable(i, "rail_crr_tp_cd", 0);
		}
	}
	if (formObj.i_hub_search_gb.value == "Y") {
		if (formObj.i_front_gb.value == "F") {
			var Row = sheetObj.DataInsert(0);
			sheetObj.SetCellValue(Row, "rnllws", 'R', 0);
			sheetObj.SetRowStatus(Row, 'I');
			sheetObj.SetCellValue(Row, "lnk_org_loc", formObj.i_rout_dest_nod_cd.value.substr(0, 5), 0);
			sheetObj.SetCellValue(Row, "lnk_org_type", formObj.i_rout_dest_nod_cd.value.substr(5), 0);
			sheetObj.SetCellValue(Row, "lnk_dest_loc", formObj.i_undefine_nod.value.substr(0, 5), 0);
			sheetObj.SetCellValue(Row, "lnk_dest_type", formObj.i_undefine_nod.value.substr(5), 0);
			sheetObj.SetCellValue(Row, "i_selRow", formObj.i_selRow.value, 0);
		}
		if (formObj.i_front_gb.value == "B") {
			var Row = sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(Row, "rnllws", 'R', 0);
			sheetObj.SetRowStatus(Row, 'I');
			sheetObj.SetCellValue(Row, "lnk_org_loc", formObj.i_rout_dest_nod_cd.value.substr(0, 5), 0);
			sheetObj.SetCellValue(Row, "lnk_org_type", formObj.i_rout_dest_nod_cd.value.substr(5), 0);
			sheetObj.SetCellValue(Row, "lnk_dest_loc", formObj.i_undefine_nod.value.substr(0, 5), 0);
			sheetObj.SetCellValue(Row, "lnk_dest_type", formObj.i_undefine_nod.value.substr(5), 0);
			sheetObj.SetCellValue(Row, "i_selRow", formObj.i_selRow.value, 0);
		}
	}
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
		classId = "COM_ENS_0061";
		param = '?loc_cd=' + loc_cd_val + '&classId=' + classId;
		chkStr = dispaly.substring(0, 3)
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 800, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1", true, false, row, col);
	}
	if (sheetObj.ColSaveName(col) == "vndr_seq") {
		loc_cd_val = sheetObj.GetCellValue(row, col);
		dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // Radio PopUp
		classId = "COM_ENS_00C1";
		param = '?pts_vndr_cd=' + loc_cd_val + '&classId=' + classId;
		chkStr = dispaly.substring(0, 3)
		// Radio PopUp
		if (chkStr == "1,0") {
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param, 800, 550, 'getVendor', dispaly, true, false, row, col);
		} else {
			ComShowMessage(ComGetMst('PRD90063'));
			return;
		}
	}
}
function getVendor(rowArray, row, col) {
	var sheetObj = sheetObjects[1];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, "vndr_seq", colArray[6], 0);
	sheetObj.SetCellValue(row, "vndr_abbr_nm", colArray[7], 0);
}
/**
 * Location : in case of single selection of radio button on pop up
 */
function getNode(rowArray, row, col) {
	var sheetObj = sheetObjects[1];
	var colArray = rowArray[0];
	sheetObj.SetCellValue(row, col + 1, colArray[3].substring(5), 0);
	sheetObj.SetCellValue(row, col, colArray[3].substring(0, 5), 0);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	// 2015.04.23
	switch (sAction) {
		case IBSEARCH:
			if (formObj.i_org_cd.value == "" && formObj.i_dest_cd.value == "") {
				ComShowCodeMessage("COM130403", 'From or To');
				return false;
			}
	}
	return true;
}
/**
 * disabling form input value
 */
function bottomFrmDisable(gb) {
	var formObj = document.form;
	if (gb) {
		disableObjectR(formObj.i_inv);
		disableObjectR(formObj.i_rout_pln_cd);
		disableObjectR(formObj.i_wrs_fl_cd);
		disableObjectR(formObj.i_wrs_mt_cd);
	} else {
		enableObjectR(formObj.i_inv);
		enableObjectR(formObj.i_rout_pln_cd);
		enableObjectR(formObj.i_wrs_fl_cd);
		enableObjectR(formObj.i_wrs_mt_cd);
	}
}

/**
 * 
 */
function disableObjectR(obj) {
	obj.disabled = true;
}

/**
 * 
 */
function enableObjectR(obj) {
	obj.disabled = false;
}
/**
 * 
 */
function chkAmericanContinent(formObj) {
	var org = formObj.i_org_cd.value.substring(0, 2);
	var des = formObj.i_dest_cd.value.substring(0, 2);
	if ((org == "US" || org == "CA") && (des == "US" || des == "CA")) {
		return true;
	}
	return false;
}
/**
 * initialize value of Object
 * 
 * @param obj
 *            Object
 * @return
 */
function clearObjectN(obj) {
	switch (obj.type) {
		case "select-one":
			obj.selectedIndex = '0';
		case "radio":
		case "checkbox":
			obj.checked = false;
			break;
		case "text":
		case "password":
			obj.readOnly = false;
			obj.value = "";
			break;
		default:
	} // end switch
}
function bottomFrmClear(formObj) {
	clearObjectN(formObj.i_inv);
	clearObjectN(formObj.i_rout_pln_cd);
	clearObjectN(formObj.i_wrs_fl_cd);
	clearObjectN(formObj.i_wrs_mt_cd);
	clearObjectN(formObj.i_route_rmk);
}
function inputChkFromTo(obj, e) {
	var objNm = obj.name;
	var objVal = eval('document.form.' + objNm + '.value');
	var objEle = eval('document.form.' + objNm);
	var cmd = '';
	re = /^[a-zA-Z0-9]+$/;
	te = /\t/;
	validateData = objVal.toUpperCase();
	if (e == 9) {
		if (objVal.length > 0) {
			if (objVal.length == 5) {
				cmd = 'SEARCH02';
				doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
			} else if (objVal.length == 7) {
				cmd = 'SEARCH05';
				doActionIBSheet(sheetObjects[0], document.form, SEARCH05);
			}
			if (retValidate < 1 && cmd != "") {
				objEle.focus();
				return false;
			} else {
				// moving to next focus
				tmp = GetObjectByTabIndex(document.form, objEle.tabIndex + 1);
				if (tmp == null)
					tmp = GetObjectByTabIndex(document.form, 1);
				if (tmp != null) {
					if (tmp.type == 'select-one') {
						tmp.selectedIndex;
					} else {
						tmp.select();
					}
					tmp.focus();
				}
				// objEle.focus();
				return false;
			}
		} else {
			// moving to next focus
			tmp = GetObjectByTabIndex(document.form, objEle.tabIndex + 1);
			if (tmp == null)
				tmp = GetObjectByTabIndex(document.form, 1);
			if (tmp != null) {
				tmp.select();
				tmp.focus();
			}
			return false;
		}
	} else if (e == 8 || e == 46 || (e >= 37 && e <= 40)) {
	} else {
		if (objVal.length > 0) {
			// changing to Capital characters. checking if it is alphabet or number format
			if (re.test(objVal)) {
				objEle.value = objVal.toUpperCase();
				return false;
			} else {
				ComShowMessage(ComGetMsg('PRD90016'));
			}
		}
	}
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
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 800, 550, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
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
}
function selectLoc(frm, pt) {
	portInd = pt;
	if (pt == 'IB_DEST_LOC')
		param = "?loc_cd=" + frm.i_dest_cd.value;
	if (pt == 'IB_ORG_LOC')
		param = "?loc_cd=" + frm.i_org_cd.value;
	ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
}
function getCOM_ENS_051(rArray) {
	var cArray = rArray[0];
	var frm = document.form;
	if (portInd == 'IB_DEST_LOC') {
		frm.i_dest_cd.value = cArray[3];
	}
	if (portInd == 'IB_ORG_LOC') {
		frm.i_org_cd.value = cArray[3];
	}
}
function changeSelection(gubun) {
	document.form.rBtnIrgCd.value = gubun;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
}
