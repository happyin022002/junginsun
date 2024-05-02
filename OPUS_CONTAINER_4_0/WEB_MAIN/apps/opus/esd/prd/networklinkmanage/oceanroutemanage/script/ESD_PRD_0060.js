/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESD_PRD_0060.js
 *@FileTitle  : Ocean Route Creation - Multi Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/08/01
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESD_PRD_0060 : business script for ESD_PRD_0060
 */
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var retValidate = 0;
document.onclick = processButtonClick;
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var sheetObject1 = sheetObjects[1];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName)) {
			return false;
		}
		var srcObj = window.event.srcElement.nodeName;
		var keyObj = window.event.keyCode;
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject, formObject, IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				formObject.reset();
				break;
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
			case "btn_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
				break;
			case "btng_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
			case "btng_rowcopy":
				doActionIBSheet(sheetObject, formObject, IBCOPYROW);
				sheetObject.SetCellEditable(sheetObject.GetSelectRow(), "s_chk", 1);
				sheetObject.SetCellValue(sheetObject.GetSelectRow(), "s_insert_flag", 'N', 0);
				sheetObject.SetCellValue(sheetObject.GetSelectRow(), "s_c_user", '', 0);
				sheetObject.SetCellValue(sheetObject.GetSelectRow(), "s_c_date", '', 0);
				break;
			case "btn_tnk_lane_cd":
				selectLane('lane1');
				break;
			case "btn_1st_lane_cd":
				selectLane('lane2');
				break;
			case "btn_2nd_lane_cd":
				selectLane('lane3');
				break;
			case "btn_3rd_lane_cd":
				selectLane('lane4');
				break;
			case "btn_close":
				ComClosePopup();
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
	axon_event.addListener('keypress', 'PrdComKeyEnter', 'lane1', 'lane2', 'lane3', 'lane4');
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
            with(sheetObj) {
        	      var HeadTitle="SEQ|Del.|Save\nCHK|STS|Ocean\nFlag|Rmk|Rmk|Priority|POL|Lane|Dir|SVC\nType|1st T/S|1st T/S|1st T/S|1st T/S|2nd T/S|2nd T/S|2nd T/S|2nd T/S|3rd T/S|3rd T/S|3rd T/S|3rd T/S|POD|T/Time\n(Day/Hour)|S/Time\n(Day)|T/Time\n(Day/Hour)|Flag|C.Date|C.User|Insert Flag"; //|sFU|sRoutSeq|sTTime|sTTDy|sTTHr|sTT1|sTT2|sTT3|sTT4|sSTime|sSTDy|sSTHr|sST1|sST2|sST3|sPol1|sPod1|sDir1|sFdrFlg1|sPol2|sPod2|sDir2|sFdrFlg2|sPol3|sPod3|sDir3|sFdrFlg3|sPol4|sPod4|sDir4|sFdrFlg4|sTsIndCd|sPod1Etb|sPol2Etb|sPod2Etb|sPol3Etb|sPod3Etb|sPol4Etb|sLnkCnt|sUpdIndCd|sRowCopyFlg|sDoubtFlg|sDupAllow";
        	      var HeadTitle1="SEQ|Del.|Save\nCHK|STS|Ocean\nFlag|Type|Note|Priority|POL|Lane|Dir|SVC\nType|Port|Lane|Dir|SVC\nType|Port|Lane|Dir|SVC\nType|Port|Lane|Dir|SVC\nType|POD|T/Time\n(Day/Hour)|S/Time\n(Day)|T/Time\n(Day/Hour)|Flag|C.Date|C.User|Insert Flag";
        	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
        	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	      var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
        	      InitHeaders(headers, info);
        	      var cols = [ 
        	             {Type:"Seq",       Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"s_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"DelCheck",  Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_del",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"CheckBox",  Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_chk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Status",    Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo",     Hidden:0, 	Width:90,   Align:"Center",  ColMerge:1,   SaveName:"s_route_flg",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Combo",     Hidden:0, 	Width:60,   Align:"Left",    ColMerge:1,   SaveName:"s_route_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0, 	Width:100,  Align:"Left",    ColMerge:1,   SaveName:"s_route_note",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Combo",     Hidden:0, 	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"s_prior",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_pol",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,   EditLen:5},
        	             {Type:"Text",      Hidden:0,  	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"s_ts1_lane",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:60,   Align:"Center",  ColMerge:1,   SaveName:"s_ts1_dir",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_ts1_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"PopupEdit", Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_ts1_port",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s_ts2_lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s_ts2_dir",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_ts2_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"PopupEdit", Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_ts2_port",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s_ts3_lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s_ts3_dir",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s_ts3_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"PopupEdit", Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_ts3_port",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
        	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s_ts4_lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"s_ts4_dir",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_ts4_type",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"PopupEdit", Hidden:0, 	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"s_pod",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 ,   EditLen:5 },
        	             {Type:"Text",      Hidden:0,  	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fmt_tot_tt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:0,  	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fmt_tot_st",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tot_tt_st",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"val_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_c_date",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_c_user",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_f_u",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_rout_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_t_time",            KeyField:0,   CalcLogic:"|s_n1st_tztm_hrs|+|s_n2nd_tztm_hrs|+|s_n3rd_tztm_hrs|+|s_n4th_tztm_hrs|",Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:75,   Align:"Center",  ColMerge:1,   SaveName:"s_t_t_dy",            KeyField:0,   CalcLogic:"Int(|s_t_time|/24)",Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:75,   Align:"Center",  ColMerge:1,   SaveName:"s_t_t_hr",            KeyField:0,   CalcLogic:"|s_t_time|%24",Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_n1st_tztm_hrs",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_n2nd_tztm_hrs",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_n3rd_tztm_hrs",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_n4th_tztm_hrs",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:75,   Align:"Center",  ColMerge:1,   SaveName:"s_s_time",            KeyField:0,   CalcLogic:"|s_n1st_stay_tm_hrs|+|s_n2nd_stay_tm_hrs|+|s_n3rd_stay_tm_hrs|",Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:75,   Align:"Center",  ColMerge:1,   SaveName:"s_s_t_dy",            KeyField:0,   CalcLogic:"Int(|s_s_time|/24)",Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:75,   Align:"Center",  ColMerge:1,   SaveName:"s_s_t_hr",            KeyField:0,   CalcLogic:"|s_s_time|%24",Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_n1st_stay_tm_hrs",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_n2nd_stay_tm_hrs",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_n3rd_stay_tm_hrs",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pol1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pod1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_dir1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_fdr_flg1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pol2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pod2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_dir2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_fdr_flg2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pol3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pod3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_dir3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_fdr_flg3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pol4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pod4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_dir4",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_fdr_flg4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_ts_ind",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pod1_etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pol2_etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pod2_etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pol3_etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pod3_etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_pol4_etb",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_lnk_cnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_upd_ind_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:70,   Align:"Center",  ColMerge:1,   SaveName:"s_row_copy_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"s_doubt_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	             {Type:"Text",      Hidden:1, 	Width:50,   Align:"Center",  ColMerge:0,   SaveName:"s_dup_allow",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        	             {Type:"Text",      Hidden:1, 	Width:20,   Align:"Center",  ColMerge:1,   SaveName:"s_insert_flag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
        	       
        	      InitColumns(cols);

        	      SetEditable(1);
        	      SetWaitImageVisible(0);
        	      InitComboNoMatchText(true);
        	      SetColProperty("fmt_tot_tt", {AcceptKeys:"N", Format:"##D-##H"} );
        	      SetColProperty("fmt_tot_st", {AcceptKeys:"N", Format:"##D-##H"} );
        	      SetColProperty("tot_tt_st",  {AcceptKeys:"N", Format:"##D-##H"} );
        	      SetColProperty("s_prior", {ComboText:"|1|2|3|4|5|6|7|8|9", ComboCode:"|1|2|3|4|5|6|7|8|9"} );
              	  SetColProperty("s_f_u", {ComboText:"|Y|N", ComboCode:"|Y|N"} );
              	  SetColProperty("s_route_flg", {ComboText:"|Guide|Standard|Temporary|AddCall|Validation", ComboCode:"|G|S|T|A|V"} );
              	  SetColProperty("s_route_rmk", {ComboText:"|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others", ComboCode:"|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomsProblem|ClericalError|The Others"} );
              	  
              	  SetColProperty(0 ,"s_pol" 	, {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_ts1_lane" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_ts1_port" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_ts2_lane" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_ts2_port" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_ts3_lane" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_ts3_port" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_ts4_lane" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              	  SetColProperty(0 ,"s_pod" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        	      SetRangeBackColor(1, 6, 1, 24,"#555555");
        	      SetHeaderRowHeight(20);
        	      ComResizeSheet(sheetObj);
        	}
            break;
    }
}
// handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	var uid;
	var sXml;
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
		case IBSEARCH:
			if (validateForm(sheetObj, formObj, sAction))
				;
			getLnkCnt(formObj);
			if (!ComChkRequired(formObj))
				return;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("ESD_PRD_0060GS.do", PrdFQString(formObj), { Sync : 2 });
			ComOpenWait(false);
			break;
		case IBSAVE:
			if (validateForm(sheetObj, formObj, sAction))
				;
			if (!inputChk(sheetObj)) {
				return;
			}
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			var bSaveSuccess = sheetObj.DoSave("ESD_PRD_0060GS.do", PrdFQString(formObj));
			ComOpenWait(false);
			if (!bSaveSuccess) {
				return;
			}
			break;
		case IBINSERT:
			var iRow = sheetObj.DataInsert();
			sheetObj.SetCellEditable(iRow, "s_del", 0);
			sheetObj.SetCellBackColor(iRow, "s_del", -1);
			sheetObj.SetCellValue(iRow, "s_insert_flag", 'N', 0);
			break;
		case IBCOPYROW:
			var Row = sheetObj.DataCopy();
			break;
		case IBDOWNEXCEL:
			if (sheetObj.RowCount() < 1) {
				ComShowCodeMessage("COM132501");
			} else {
				sheetObj.Down2Excel({ DownCols : makeHiddenSkipCol(sheetObj), SheetDesign : 1, Merge : 1 });
			}
			break;
		case SEARCH01:
			formObj.f_cmd.value = SEARCH01;
			uid = "ESD_PRD_0004";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
		case SEARCH07:
			formObj.f_cmd.value = SEARCH07;
			uid = "ESD_PRD_0033";
			sXml = sheetObj.GetSaveData("PRD_VALIDATE.do", "uid=" + uid + "&check_data=" + validateData + "&" + PrdFQString(formObj));
			retValidate = ComGetEtcData(sXml, "rowCount");
			break;
	}
}
function inputChk(sheetObj) {
	if (!chkTempRmk(sheetObj)) {
		ComShowMessage(ComGetMsg('PRD90107')); // 'RMK is mandatory!!';
		return false;
	}
	if (!chkDataValid(sheetObj)) {
		ComShowMessage(ComGetMsg('PRD90026')); // 'There is a Route undefined.'
		return false;
	}
	if (!otherFlagChk(sheetObj)) {
		ComShowMessage(ComGetMsg('PRD90124'));
		return false;
	}
	if (sheetObj.CheckedRows("s_chk") == 0 && sheetObj.CheckedRows("s_del") == 0) {
		ComShowCodeMessage('COM130503'); // 'There is no updated data to save.'
		return;
	}
	for ( var i = sheetObj.HeaderRows(); i < sheetObj.Rows; i++) {
		if (sheetObj.GetCellValue(i, "s_chk") != 1 && sheetObj.GetCellValue(i, "s_del") != 1) {
			sheetObj.SetRowStatus(i, "R");
		}
	}
	return true;
}
/**
 * checking that Route Remark is inputed in case of 'Temp Route'
 * 
 * @param sheetObj
 * @return
 */
function chkTempRmk(sheetObj) {
	if (sheetObj.CheckedRows("s_chk") > 0) {
		var checkedRow = sheetObj.FindCheckedRow("s_chk");
		for ( var i = sheetObj.HeaderRows(); i < sheetObj.Rows; i++) {
			// tempflg Check
			if (sheetObj.GetCellValue(i, "s_chk") == 1 && sheetObj.GetCellValue(i, "s_route_flg") == "T") {
				if (ComTrim(sheetObj.GetCellValue(i, "s_route_rmk")) == "") {
					return false;
				}
				;
			}
		}
		return true;
	}
	return true;
}
function chkDataValid(sheetObj) {
	if (sheetObj.CheckedRows("s_chk") > 0) {
		for ( var i = sheetObj.HeaderRows(); i < sheetObj.Rows; i++) {
			if (sheetObj.GetCellValue(i, "s_chk") == 1 && sheetObj.GetCellValue(i, "val_flg") != "Y") {
				return false;
			}
		}
		return true;
	}
	return true;
}
/**
 * checking before save - show message when the value of Note is null selected in the row that Type is "The Other"
 * 
 * @return
 */
function otherFlagChk(sheetObj) {
	if (sheetObj.CheckedRows("s_chk") > 0) {
		var checkedRow = sheetObj.FindCheckedRow("s_chk");
		for ( var i = sheetObj.HeaderRows(); i < sheetObj.Rows; i++) {
			if (sheetObj.GetCellValue(i, "s_chk") == 1 && sheetObj.GetCellValue(i, "s_route_rmk") == "The Others" && ComTrim(sheetObj.GetCellValue(i, "s_route_note")) == "") {
				return false;
			}
		}
		return true;
	}
	return true;
}
/**
 * setting link count of search condition
 * 
 * @param formObj
 * @return
 */
function getLnkCnt(formObj) {
	if (formObj.lane4.value.length > 0) {
		formObj.lnk_cnt.value = 4;
	} else if (formObj.lane3.value.length > 0) {
		formObj.lnk_cnt.value = 3;
	} else if (formObj.lane2.value.length > 0) {
		formObj.lnk_cnt.value = 2;
	} else if (formObj.lane1.value.length > 0) {
		formObj.lnk_cnt.value = 1;
	} else {
		formObj.lnk_cnt.value = 0;
	}
}
function mandatoryChk(formObj) {
	if (formObj.pol_port_cd.value.length != 5 && formObj.pod_port_cd.value.length != 5) {
		ComShowMessage(ComGetMsg('PRD90108'));
		return false;
	}
	return true;
}
// handling pop up open
function sheet1_OnPopupClick(sheetObj, row, col) {
	var oriLoc = "";
	var destLoc = "";
	var lane = "";
	var gubun = "";
	var tsIdx = "";
	var lastPod = "N";
	var tsProt = "N";
	if (sheetObj.ColSaveName(col) == "s_pod") {
		if (sheetObj.GetCellValue(row, "s_ts3_port").length > 0) {
			tsIdx = '4';
		} else if (sheetObj.GetCellValue(row, "s_ts2_port").length > 0) {
			tsIdx = '3';
		} else if (sheetObj.GetCellValue(row, "s_ts1_port").length > 0) {
			tsIdx = '2';
		} else {
			tsIdx = '1';
		}
		oriLoc = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pol" + tsIdx);
		destLoc = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pod" + tsIdx);
		lane = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_ts" + tsIdx + "_lane");
		gubun = tsIdx;
		lastPod = "Y";
	} else {
		tsProt = 'Y';
		var idx = sheetObj.ColSaveName(col).substring(4, 5); // s_ts3_port
		if (sheetObj.ColSaveName(col) == "s_ts" + idx + "_port") {
			gubun = idx;
			oriLoc = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pol" + idx);
			destLoc = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_pod" + idx);
			lane = sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_ts" + idx + "_lane");
		}
	}
	// var param = '?i_org_cd='+ oriLoc +'&i_dest_cd='+destLoc;
	var param = '?ori_loc=' + oriLoc + '&dest_loc=' + destLoc + '&f_cmd=' + SEARCH + '&lane=' + lane + '&gubun=' + gubun + "&row=" + sheetObj.GetSelectRow() + "&col=" + sheetObj.SelectCol + "&sTsPort=" + tsProt + "&isLastPod=" + lastPod;
	myWin = ComOpenWindowCenter('ESD_PRD_0040.do' + param, 'compop', 816, 300, false);
	myWin.focus();
}
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	sheetObj.ShowDebugMsg(false);
	var colSaveName = sheetObj.ColSaveName(Col);
	if (colSaveName == 'fmt_tot_tt' || colSaveName == 'fmt_tot_st' || colSaveName == 'tot_tt_st') {
		var ttdate = sheetObj.GetCellValue(Row, Col);
		if (ttdate.length < 4) {
			sheetObj.SetCellValue(Row, Col, "", 0);
			sheetObj.SelectCell(Row, Col);
			return false;
		}
		var d = ttdate.substr(0, 2);
		var h = ttdate.substr(2, 2);
		if (h > 23) {
			ComShowMessage(ComGetMsg('PRD90015'));
			sheetObj.SetCellValue(Row, Col, "", 0);
			sheetObj.SelectCell(Row, Col);
			return false;
		}
		return false;
	}

	if (sheetObj.GetCellValue(Row, "s_insert_flag") == 'N') {
		sheetObj.SetRowStatus(Row, 'I');
	}
	if (sheetObj.GetCellValue(Row, "s_route_flg") == "T" && sheetObj.GetCellValue(Row, "s_route_rmk") == "The Others") {
		sheetObj.SetCellEditable(Row, "s_route_note", 1);
	} else {
		sheetObj.SetCellEditable(Row, "s_route_note", 0);
	}
	if (sheetObj.ColSaveName(Col) == "s_route_flg" && Value == "T") {
		ComShowMessage(ComGetMsg('PRD90102'));
		sheetObj.CellComboItem(Row, "s_route_rmk", { ComboText : "|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomerProblem|ClericalError|The Others", ComboCode : "|SpaceShortage|CustomerRequest|PortSkip|VSLPhaseOut|CustomerProblem|ClericalError|The Others" });
		sheetObj.SelectCell(Row, "s_route_rmk");
		sheetObj.SetCellValue(Row, "s_route_rmk", 'Space Shortage', 0);
	} else if (sheetObj.ColSaveName(Col) == "s_route_flg" && Value != "T") {
		sheetObj.CellComboItem(Row, "s_route_rmk", { ComboText : " ", ComboCode : " " });
		sheetObj.SetCellValue(Row, "s_route_note", "", 0);

		sheetObj.SetCellValue(Row, "s_route_rmk", ' ', 0);
		sheetObj.SetCellValue(Row, "s_route_note", ' ', 0);
	} else if (sheetObj.ColSaveName(Col) == "s_route_rmk" && Value != "The Others") {
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
	} else if (sheetObj.ColSaveName(Col) == "s_route_note" && Value != " ") {
		if (sheetObj.GetCellValue(Row, "s_route_rmk") != "The Others") {
			sheetObj.SetCellValue(Row, "s_route_note", '', 0);
		}
	}

	// preventing to select on DROP BOX in case of 'S'
	var idx = sheetObj.GetComboInfo(Row, "s_route_rmk", "SelectedIndex");
	if ((sheetObj.GetRowStatus(Row) == 'U' || sheetObj.GetRowStatus(Row) == 'I') && (sheetObj.ColSaveName(Col) == "s_route_rmk") && (sheetObj.GetCellValue(Row, "s_route_flg") != "T") && idx > 0) {
		sheetObj.SetCellValue(Row, "s_route_rmk", ' ', 0);
		sheetObj.SetCellValue(Row, "s_route_note", ' ', 0);
		ComShowMessage(ComGetMsg('PRD90102'));
		sheetObj.SelectCell(Row, "s_route_rmk");
	}
	if ((sheetObj.GetRowStatus(Row) == 'U' || sheetObj.GetRowStatus(Row) == 'I') && (sheetObj.ColSaveName(Col) == "s_route_rmk") && (sheetObj.GetCellValue(Row, "s_route_flg") == "T") && sheetObj.GetCellValue(Row, "s_route_rmk").trim() == "") {
		sheetObj.SetCellValue(Row, "s_route_rmk", '', 0);
		sheetObj.SetCellValue(Row, "s_route_note", '', 0);
		ComShowMessage(ComGetMsg('PRD90103'));
		sheetObj.SelectCell(Row, "s_route_rmk");
	}

	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_insert_flag") == 'N') {
		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_chk") == '1') {
			if (sheetObj.ColSaveName(Col) == "s_pol" || sheetObj.ColSaveName(Col) == "s_ts1_lane" || sheetObj.ColSaveName(Col) == "s_ts1_port" || sheetObj.ColSaveName(Col) == "s_ts2_lane" || sheetObj.ColSaveName(Col) == "s_ts2_port" || sheetObj.ColSaveName(Col) == "s_ts3_lane"
					|| sheetObj.ColSaveName(Col) == "s_ts3_port" || sheetObj.ColSaveName(Col) == "s_ts4_lane" || sheetObj.ColSaveName(Col) == "s_pod") {
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_chk", "0");
				ComShowMessage(ComGetMsg('PRD90123'));
			}
		}
	}
	if (sheetObj.ColSaveName(Col) == "s_chk") {
		if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_insert_flag") == 'N') {
			if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "val_flg") != "Y") {
				ComShowMessage(ComGetMsg('PRD90026'));
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_chk", 0, 0);
				return;
			}
			if (Value == "1") {
				var resultXml = sheetObj.GetSearchData("ESD_PRD_0060GS.do", "f_cmd=" + SEARCH12 + "&s_pol=" + sheetObj.GetCellValue(Row, "s_pol") + "&s_pod=" + sheetObj.GetCellValue(Row, "s_pod") + "&s_pol1=" + sheetObj.GetCellValue(Row, "s_pol1") + "&s_pod1=" + sheetObj.GetCellValue(Row, "s_pod1")
						+ "&s_lane=" + sheetObj.GetCellValue(Row, "s_lane") + "&s_dir1=" + sheetObj.GetCellValue(Row, "s_dir1") + "&s_ts1_port=" + sheetObj.GetCellValue(Row, "s_ts1_port") + "&s_pod2=" + sheetObj.GetCellValue(Row, "s_pod2") + "&s_ts1_lane=" + sheetObj.GetCellValue(Row, "s_ts1_lane")
						+ "&s_dir2=" + sheetObj.GetCellValue(Row, "s_dir2") + "&s_ts2_port=" + sheetObj.GetCellValue(Row, "s_ts2_port") + "&s_pod3=" + sheetObj.GetCellValue(Row, "s_pod3") + "&s_ts2_lane=" + sheetObj.GetCellValue(Row, "s_ts2_lane") + "&s_dir3=" + sheetObj.GetCellValue(Row, "s_dir3")
						+ "&s_ts3_port=" + sheetObj.GetCellValue(Row, "s_ts3_port") + "&s_pod4=" + sheetObj.GetCellValue(Row, "s_pod4") + "&s_ts3_lane=" + sheetObj.GetCellValue(Row, "s_ts3_lane") + "&s_dir4=" + sheetObj.GetCellValue(Row, "s_dir4"));
				var dup_chk = ComGetEtcData(resultXml, "dup_flag");
				if (dup_chk == "Y") {
					ComShowMessage(ComGetMsg('PRD90125'));
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "s_chk", "0");
				} else if (dup_chk == "N") {
				}
			} else {
			}
		} else if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "s_insert_flag") != 'N') {
			if (Value == "1") {
				sheetObj.SetRowStatus(Row, "I");
				if(false) {
					sheetObj.DoRowSearch("ESD_PRD_0032_ROW_GS.do", "f_cmd=" + SEARCH11 + "&org_loc_cd=" + sheetObj.GetCellValue(Row, "s_pol") + "&dest_loc_cd=" + sheetObj.GetCellValue(Row, "s_pod") + "&n1st_pol_cd=" + sheetObj.GetCellValue(Row, "s_pol1") + "&n1st_pod_cd="
							+ sheetObj.GetCellValue(Row, "s_pod1") + "&n1st_lane_cd=" + sheetObj.GetCellValue(Row, "s_ts1_lane") + "&n2nd_pol_cd=" + sheetObj.GetCellValue(Row, "s_pol2") + "&n2nd_pod_cd=" + sheetObj.GetCellValue(Row, "s_pod2") + "&n2nd_lane_cd="
							+ sheetObj.GetCellValue(Row, "s_ts2_lane") + "&n3rd_pol_cd=" + sheetObj.GetCellValue(Row, "s_pol3") + "&n3rd_pod_cd=" + sheetObj.GetCellValue(Row, "s_pod3") + "&n3rd_lane_cd=" + sheetObj.GetCellValue(Row, "s_ts3_lane") + "&n4th_pol_cd=" + sheetObj.GetCellValue(Row, "s_pol4")
							+ "&n4th_pod_cd=" + sheetObj.GetCellValue(Row, "s_pod4") + "&n4th_lane_cd=" + sheetObj.GetCellValue(Row, "s_ts4_lane") + "&row=" + Row + "&col=" + Col);
					if (sheetObj.GetEtcData("rowCount") == 0) {
						sheetObj.SetCellValue(Row, "s_doubt_flg", "", 0);
						sheetObj.SetCellValue(Row, "s_dup_allow", "", 0);
					} else {
						if (sheetObj.GetCellValue(Row, "s_doubt_flg") == "Y") {
							if (!CONFIRM(ComGetMsg('PRD90053'))) {
								sheetObj.SetCellValue(Row, "s_chk", "0", 0);
							} else {
								sheetObj.SetCellValue(Row, "s_dup_allow", "Y", 0);
							}
						}
					}
				}
				sheetObj.SetCellValue(Row, "s_doubt_flg", "", 0);
				sheetObj.SetCellValue(Row, "s_dup_allow", "", 0);
				
				sheetObj.SetCellEditable(Row, "s_route_flg", 1);
				sheetObj.SetCellEditable(Row, "s_route_rmk", 1);
			} else {
				sheetObj.SetCellValue(Row, "s_dup_allow", "", 0);
				sheetObj.SetRowStatus(Row, "R");
				sheetObj.SetCellEditable(Row, "s_route_flg", 0);
				sheetObj.SetCellEditable(Row, "s_route_rmk", 0);
			}
		}
	}
	if (Value == "V") {
		ComShowMessage(ComGetMsg('PRD90104', 'Validation'));
		sheetObj.SetCellValue(Row, "s_route_flg", sheetObj.GetCellValue(Row, "s_upd_ind_cd"), 0);
		return;
	}
	if (Value == "G") {
		sheetObj.SetCellValue(Row, "s_prior", 1, 0);
		return;
	}
	var colNm = sheetObj.ColSaveName(Col);
	if (colNm == "s_pol" || colNm == "s_ts1_port" || colNm == "s_ts2_port" || colNm == "s_ts3_port" || colNm == "s_pod" || colNm == "s_ts1_lane" || colNm == "s_ts2_lane" || colNm == "s_ts3_lane" || colNm == "s_ts4_lane") {
		var param = "f_cmd=" + SEARCH02 + "&s_pol=" + sheetObj.GetCellValue(Row, "s_pol") + "&s_ts1_port=" + sheetObj.GetCellValue(Row, "s_ts1_port") + "&s_ts2_port=" + sheetObj.GetCellValue(Row, "s_ts2_port") + "&s_ts3_port=" + sheetObj.GetCellValue(Row, "s_ts3_port") + "&s_pod="
				+ sheetObj.GetCellValue(Row, "s_pod") + "&s_ts1_lane=" + sheetObj.GetCellValue(Row, "s_ts1_lane") + "&s_ts2_lane=" + sheetObj.GetCellValue(Row, "s_ts2_lane") + "&s_ts3_lane=" + sheetObj.GetCellValue(Row, "s_ts3_lane") + "&s_ts4_lane=" + sheetObj.GetCellValue(Row, "s_ts4_lane");
		var resultXml = sheetObj.GetSearchData("ESD_PRD_0060GS.do", param);
		sheetObj.SetCellValue(Row, "s_prior", ComGetEtcData(resultXml, "prio"), 0);
		sheetObj.SetCellValue(Row, "s_pol1", ComGetEtcData(resultXml, "pol1"), 0);
		sheetObj.SetCellValue(Row, "s_pol2", ComGetEtcData(resultXml, "pol2"), 0);
		sheetObj.SetCellValue(Row, "s_pol3", ComGetEtcData(resultXml, "pol3"), 0);
		sheetObj.SetCellValue(Row, "s_pol4", ComGetEtcData(resultXml, "pol4"), 0);
		sheetObj.SetCellValue(Row, "s_pod1", ComGetEtcData(resultXml, "pod1"), 0);
		sheetObj.SetCellValue(Row, "s_pod2", ComGetEtcData(resultXml, "pod2"), 0);
		sheetObj.SetCellValue(Row, "s_pod3", ComGetEtcData(resultXml, "pod3"), 0);
		sheetObj.SetCellValue(Row, "s_pod4", ComGetEtcData(resultXml, "pod4"), 0);
		sheetObj.SetCellValue(Row, "s_dir1", ComGetEtcData(resultXml, "dir1"), 0);
		sheetObj.SetCellValue(Row, "s_dir2", ComGetEtcData(resultXml, "dir2"), 0);
		sheetObj.SetCellValue(Row, "s_dir3", ComGetEtcData(resultXml, "dir3"), 0);
		sheetObj.SetCellValue(Row, "s_dir4", ComGetEtcData(resultXml, "dir4"), 0);
		sheetObj.SetCellValue(Row, "s_fdr_flg1", ComGetEtcData(resultXml, "fdr_flg1"), 0);
		sheetObj.SetCellValue(Row, "s_fdr_flg2", ComGetEtcData(resultXml, "fdr_flg2"), 0);
		sheetObj.SetCellValue(Row, "s_fdr_flg3", ComGetEtcData(resultXml, "fdr_flg3"), 0);
		sheetObj.SetCellValue(Row, "s_fdr_flg4", ComGetEtcData(resultXml, "fdr_flg4"), 0);
		sheetObj.SetCellValue(Row, "s_ts1_type", ComGetEtcData(resultXml, "svc_tp1"), 0);
		sheetObj.SetCellValue(Row, "s_ts2_type", ComGetEtcData(resultXml, "svc_tp2"), 0);
		sheetObj.SetCellValue(Row, "s_ts3_type", ComGetEtcData(resultXml, "svc_tp3"), 0);
		sheetObj.SetCellValue(Row, "s_ts4_type", ComGetEtcData(resultXml, "svc_tp4"), 0);
		sheetObj.SetCellValue(Row, "fmt_tot_tt", ComGetEtcData(resultXml, "fmt_tot_tt"), 0);
		sheetObj.SetCellValue(Row, "fmt_tot_st", ComGetEtcData(resultXml, "fmt_tot_st"), 0);
		sheetObj.SetCellValue(Row, "tot_tt_st", ComGetEtcData(resultXml, "fmt_tt"), 0);
		sheetObj.SetCellValue(Row, "s_f_u", ComGetEtcData(resultXml, "fdr_usd"), 0);
		sheetObj.SetCellValue(Row, "s_lnk_cnt", ComGetEtcData(resultXml, "link_cnt"), 0);
		sheetObj.SetCellValue(Row, "s_upd_ind_cd", ComGetEtcData(resultXml, "upd_ind_cd"), 0);
		sheetObj.SetCellValue(Row, "val_flg", ComGetEtcData(resultXml, "link_valid_flg"), 0);
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
	}
	return true;
}
/**
 * calling pop up for retrieving Lane code
 * 
 * @param tgt
 * @return
 */
function selectLane(tgt) {
	var frm = document.form;
	var param = '?classId=' + 'COM_ENS_081';
	if (tgt == 'lane1')
		param = param + '&lane_cd=' + frm.lane1.value;
	if (tgt == 'lane2')
		param = param + '&lane_cd=' + frm.lane2.value;
	if (tgt == 'lane3')
		param = param + '&lane_cd=' + frm.lane3.value;
	if (tgt == 'lane4')
		param = param + '&lane_cd=' + frm.lane4.value;
	ComOpenPopup('/opuscntr/COM_ENS_081.do' + param, 800, 380, 'getLane' + tgt.substr(4, 1), "1,0,1,1,1,1,1,1,1,1,1,1", true);
}
/**
 * setting Land code into search condition
 * 
 * @param rowArray
 * @return
 */
function getLane1(rowArray) {
	var colArray = rowArray[0];
	document.form.lane1.value = colArray[3];
}
/**
 * setting Land code into search condition
 * 
 * @param rowArray
 * @return
 */
function getLane2(rowArray) {
	var colArray = rowArray[0];
	document.form.lane2.value = colArray[3];
}
/**
 * setting Land code into search condition
 * 
 * @param rowArray
 * @return
 */
function getLane3(rowArray) {
	var colArray = rowArray[0];
	document.form.lane3.value = colArray[3];
}
/**
 * setting Land code into search condition
 * 
 * @param rowArray
 * @return
 */
function getLane4(rowArray) {
	var colArray = rowArray[0];
	document.form.lane4.value = colArray[3];
}
/**
 * handling process after ending sheet1 save
 * 
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	if (ErrMsg != '') {
		return;
	}
	var formObj = document.form;
	var rowcount = sheetObj.RowCount();
	var flg = 0;
	for (k = 0; k <= rowcount; k++) {
		if (sheetObj.GetRowStatus(k) == 'I') {
			flg++;
		}
	}
	if (flg == 0) {
		ComShowMessage("Data" + ComGetMsg('COM130102'));
		ComClosePopup();
	}
}
