/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   :  EES_CGM_1100.js
 *@FileTitle  : Inventory by On-Hire Year
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
 * @class EES_CGM_1100 : EES_CGM_1100 business script for
 */

/* developer job */
// common global variables
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
// Event handler processing by button click event */
document.onclick = processButtonClick;
/**
 * Event handler processing by button name <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function processButtonClick() {
	/** *** use additional sheet var in case of more than 2 tap each sheet **** */
	var sheetObject1 = sheetObjects[0];
	/** **************************************************** */
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			if (validateForm(sheetObject1, formObject, IBSEARCH) != false) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			formObject.crnt_loc_cd.focus(); //             		
			break;
		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, IBRESET);
			initControl();
			break;
		case "btn_downexcel":
			doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
			break;
		case "btns_crnt_loc_cd": // Location Popup
			var tmp = formObject.combo_location.text;
			if (tmp == "RCC") {
				// ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000,
				// 450,"rcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
				ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 480,
						"callBackLocation", "1,0,1,1,1,1,1", true, false);
				// ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450,
				// "callBackLocation", "0,1,1,1,1,1,1", true, false);
			} else if (tmp == "LCC") {
				// ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000,
				// 450,"lcc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
				ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 480,
						"callBackLocation", "1,0,1,1,1,1,1", true, false);
				// ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450,
				// "callBackLocation", "0,1,1,1,1,1,1", true, false);
			} else if (tmp == "SCC") {
				// ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000,
				// 450,"scc_cd:crnt_loc_cd", "1,0,1,1,1,1,1", true);
				ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 480,
						"callBackLocation", "1,0,1,1,1,1,1", true, false);
				// ComOpenPopup('/opuscntr/COM_ENS_051.do', 1000, 450,
				// "callBackLocation", "0,1,1,1,1,1,1", true, false);
			}
			break;
		case "btns_crnt_yd_cd": // Yard
			// ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 1000, 450,
			// "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
			ComOpenPopup('/opuscntr/COM_ENS_061.do', 800, 540, "callBackYard",
					"0,1,1,1,1,1,1", true, false);
			break;
		case "btns_vndr":
			ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 540,
					"callBackVendor", "0,1,1,1,1,1", true, false);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * registering IBSheet Object as list <br>
 * 
 * @param {object}
 *            sheet_obj
 * @return
 * @author
 * @version
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		//
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		//
		ComEndConfigSheet(sheetObjects[i]);
	}

	sheet1_OnLoadFinish(sheet1);
}
/**
 * sheet setting and init in case of load finish <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function sheet1_OnLoadFinish(sheetObj) {
	sheetObj.SetWaitImageVisible(0);
	// axon event regist
//	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
	axon_event.addListener('change', 'obj_change', 'crnt_loc_cd');
	axon_event.addListener('change', 'obj_change', 'crnt_yd_cd');
	axon_event.addListener('change', 'obj_change', 'vndr_seq');
	axon_event.addListener('focusout', 'obj_focusout', 'crnt_yd_cd');
	// Multi Combo reset
	comboObjects[comboCnt++] = combo_location;
	comboObjects[comboCnt++] = combo_aciac_div_cd;
	comboObjects[comboCnt++] = combo_group1;
	comboObjects[comboCnt++] = combo_eq_tpsz_cd;
	comboObjects[comboCnt++] = combo_agmt_lstm_cd;
	comboObjects[comboCnt++] = combo_chss_mvmt_sts_cd;
	for ( var k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k]);
	}
	// Active St. MultiCombo value reset
	var arrActive = new Array();
	arrActive[0] = "A|Active";
	arrActive[1] = "I|In-active";
	makeComboObject(combo_aciac_div_cd, arrActive, 1, 0, 0);
	// Group MultiCombo value reset
	var arrGroup = new Array();
	arrGroup[0] = "1|LCC[Location]";
	arrGroup[1] = "2|SCC[Location]";
	arrGroup[2] = "3|Yard";
	arrGroup[3] = "4|Lease term";
	arrGroup[4] = "5|Lessor";
	arrGroup[5] = "6|Mvmt Status";
	makeComboObject(combo_group1, arrGroup, 1, 0, 1);
	/*
	 * // Location MultiCombo value setting doActionIBSheet(sheetObjects[0],
	 * document.form, IBSEARCH_ASYNC01); // Type Size MultiCombo value setting
	 * doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04); //
	 * Lease Term MultiCombo value setting doActionIBSheet(sheetObjects[0],
	 * document.form, IBSEARCH_ASYNC05); // Movement Status MultiCombo value
	 * setting doActionIBSheet(sheetObjects[0], document.form,
	 * IBSEARCH_ASYNC06);
	 */
	doActionIBSheet(sheetObjects[0], document.form, IBRESET);
	initControl();
	sheetObj.SetWaitImageVisible(1);
}
/**
 * init control of form <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function initControl() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	
	// Form Object reset
	with (formObj) {
		crnt_loc_cd.value = "";
		crnt_yd_cd.value = "";
		vndr_seq.value = "";
		include_np.checked = false;
		var sysDate = new Date();
		var year = sysDate.getFullYear();
		var thisYear = ComLpad(year, 4, "0");
		onh_dt.value = thisYear;
	}
	// MultiCombo reset
	for ( var i = 0; i < comboObjects.length; i++) {
		comboObjects[i].SetSelectText("", false);
	}
	// Sheet Object reset
	sheetObj.RemoveAll();
	sheetObj.SetColHidden("group1", 1);
	// init value setting
	comboObjects[0].SetSelectIndex(0);
	comboObjects[1].SetSelectIndex(0);
	comboObjects[2].SetSelectIndex(1, false);//
	// comboObjects[3].Index = 2; //
	// comboObjects[4].Index = 2; //
	// 1100 header title reset
	comboText = "";
	setTitle();
}
function resizeSheet(){
	ComResizeSheet( sheetObjects[0] );
}
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * 
 * @param {object}
 *            sheetObj Sheet Object
 * @param {int}
 *            sheetNo
 * @return
 * @author
 * @version
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID = sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with (sheetObj) {

			var HeadTitle = "|Seq.|LCC|TP/SZ|2006 or Older\nTotal|~ 1980|1981~1985|1986 ~ 1990|1991 ~1995|1996 ~ 2000|2001 ~ 2005|2006~2010|2011 ~ 2015";
			var headCount = ComCountHeadTitle(HeadTitle);

			SetConfig({ SearchMode : 2, MergeSheet : 2, Page : 20, DataRowMerge : 0});

			var info = { Sort : 0, ColMove : 1, HeaderCheck : 0, ColResize : 1 };
			var headers = [ { Text : HeadTitle, Align : "Center" } ];
			InitHeaders(headers, info);

			var cols = [ { Type : "Status", Hidden : 1, Width : 30, Align : "Center", ColMerge : 1, SaveName : "hdnStatus"}, 
			             {Type : "Seq",  Hidden : 0, Width : 30, Align : "Center", ColMerge : 1, SaveName : "Seq"}, 
			             {Type : "Text", Hidden : 0, Width : 90, Align : "Center", ColMerge : 1, SaveName : "group1", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "Text", Hidden : 0, Width : 70, Align : "Center", ColMerge : 0, SaveName : "eq_tpsz_cd", KeyField : 0, CalcLogic : "", Format : "", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 95, Align : "Right", ColMerge : 0, SaveName : "year_total", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_1", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_2", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_3", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_4",	KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_5", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_6", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_7", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1}, 
			             {Type : "AutoSum", Hidden : 0, Width : 85, Align : "Right", ColMerge : 0, SaveName : "year_8", KeyField : 0, CalcLogic : "", Format : "NullInteger", PointCount : 0, UpdateEdit : 0, InsertEdit : 1} ];

			InitColumns(cols);
//			SetSheetHeight(382);
			SetEditable(1);
			SetEditableColorDiff(0);
			resizeSheet( );
		}
		break;
	}
}
/**
 * handling process for Sheet <br>
 * 
 * @param {object}
 *            sheetObj Sheet Object
 * @param {object}
 *            formObj Form Object
 * @param {String}
 *            sAction Action Type
 * @return
 * @author
 * @version
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // retrieve
		// Form Object value setting
		formObj.f_cmd.value = SEARCH;
		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
		if (formObj.include_np.checked) {
			formObj.include_np.value = "Y";
		} else {
			formObj.include_np.value = "";
		}
		
		if(!ComIsEmpty(combo_location.GetSelectCode())) {
 			formObj.location.value = combo_location.GetSelectCode();
 		}
		
		if(!ComIsEmpty(combo_aciac_div_cd.GetSelectCode())) {
 			formObj.aciac_div_cd.value = combo_aciac_div_cd.GetSelectCode();
 		}
		
		if(!ComIsEmpty(combo_group1.GetSelectCode())) {
 			formObj.group1.value = combo_group1.GetSelectCode();
 		}
        //TYPE SIZE 		
		if(!ComIsEmpty(combo_eq_tpsz_cd.GetSelectCode())) {
 			formObj.eq_tpsz_cd.value = combo_eq_tpsz_cd.GetSelectCode();
 		} else {
 			formObj.eq_tpsz_cd.value = "";
 		}
		//LEASE TERM 
		if(!ComIsEmpty(combo_agmt_lstm_cd.GetSelectCode())) {
 			formObj.agmt_lstm_cd.value = combo_agmt_lstm_cd.GetSelectCode();
 		} else {
 			formObj.agmt_lstm_cd.value = "";
 		}
		//MVMT STATUS
		if(!ComIsEmpty(combo_chss_mvmt_sts_cd.GetSelectCode())) {
 			formObj.chss_mvmt_sts_cd.value = combo_chss_mvmt_sts_cd.GetSelectCode();
 		} else {
 			formObj.chss_mvmt_sts_cd.value =  "";
 		}
		
		if(comboObjects[2].GetSelectText()!= ''){
			sheetObj.ShowSubSum([{StdCol:"group1", SumCols:"4|5|6|7|8|9|10|11|12", Sort:1, ShowCumulate:0, CaptionCol:"group1", CaptionText:"Sub Total"}]);
		}
		
		// retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml = sheetObj.GetSearchData("EES_CGM_1100GS.do",
					FormQueryString(formObj));
			setTitle();
			sheetObj.LoadSearchData(sXml, {
				Sync : 1
			});
			ComOpenWait(false);
		}
		break;
	case IBSEARCH_ASYNC01: // Location Combo retrieve
		formObj.f_cmd.value = SEARCH;
		formObj.intg_cd_id.value = COM_CD_TYPE_CD02117; // code type setting
														// (Location)
		var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do",
				FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml, "comboList");
		var arrStr = sStr.split("@");
		// combo control, result string, Text Index, Code Index
		makeComboObject(combo_location, arrStr, 1, 1, 0);
		break;
	case IBSEARCH_ASYNC02: // Yard Validation check
		formObj.f_cmd.value = COMMAND01;
		formObj.yd_cd.value = formObj.crnt_yd_cd.value;
		var sXml = sheetObj.GetSearchData("Check_YardGS.do",
				FormQueryString(formObj));
		var sCheckResult = ComGetEtcData(sXml, "checkResult");
		if (sCheckResult == COM_VALIDATION_FALSE) {
			ComShowCodeMessage('CGM10009', 'Yard');
			formObj.crnt_yd_cd.value = "";
			formObj.crnt_yd_cd.focus();
		}
		break;
	case IBSEARCH_ASYNC04: // Type Size Combo retrieve
		formObj.f_cmd.value = SEARCH04;
		formObj.eq_knd_cd.value = EQ_KND_CD_CHASSIS;
		var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do",
				FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml, "comboList");
		var arrStr = sStr.split("@");
		makeComboObject(combo_eq_tpsz_cd, arrStr, 0, 0, 0);
		// comboObjects[6].DeleteItem(1);
		break;
	case IBSEARCH_ASYNC05: // Term Code Combo retrieve
		formObj.f_cmd.value = SEARCH;
		formObj.intg_cd_id.value = COM_CD_TYPE_CD01948; // code type setting (
														// AGREEMENT LEASE TERM
														// CODE )
		var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do",
				FormQueryString(formObj));
		var sStr = ComGetEtcData(sXml, "comboList");
		var arrStr = sStr.split("@");
		makeComboObject(combo_agmt_lstm_cd, arrStr, 0, 0, 0);
		comboObjects[4].DeleteItem(0);
		break;
	case IBSEARCH_ASYNC06: // Movement Status Combo retrieve
		formObj.f_cmd.value = SEARCH13;
		var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do",
				FormQueryString(formObj));
		var cols = ComCgmXml2ComboString(sXml, "code1", "code1");
		ComCgmMakeMultiCombo(combo_chss_mvmt_sts_cd, cols[0], cols[1], 0);
		break;
	case IBSEARCH_ASYNC08:
		// formObj.f_cmd.value = SEARCH;
		// formObj.loc_cd.value = formObj.crnt_loc_cd.value; // (
		// combo_location)
		// var sXml = sheetObj.GetSearchXml("cgm_Check_LocationGS.do",
		// FormQueryString(formObj));
		formObj.f_cmd.value = SEARCH17;
		var location = formObj.combo_location.text;
		if (location == "RCC") {
			formObj.eq_orz_cht_chktype.value = "RCC";
			formObj.eq_orz_cht_rcc_cd.value = formObj.crnt_loc_cd.value;
		} else if (location == "LCC") {
			formObj.eq_orz_cht_chktype.value = "LCC";
			formObj.eq_orz_cht_lcc_cd.value = formObj.crnt_loc_cd.value;
		} else if (location == "SCC") {
			formObj.eq_orz_cht_chktype.value = "SCC";
			formObj.eq_orz_cht_scc_cd.value = formObj.crnt_loc_cd.value;
		} else {
			formObj.eq_orz_cht_chktype.value = "";
			formObj.eq_orz_cht_scc_cd.value = "";
		}
		var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do",
				FormQueryString(formObj));
		// data count
		var dataCount = ComGetTotalRows(sXml);
		if (dataCount == 0) {
			ComShowCodeMessage('CGM10009', 'location cd');
			formObj.crnt_loc_cd.value = "";
		}
		formObj.crnt_loc_cd.focus();
		break;
	case IBDOWNEXCEL: // down excel
		if (sheetObj.RowCount() < 1) {// no data
			ComShowCodeMessage("COM132501");
		} else {
			sheetObj.Down2Excel({
				DownCols : makeHiddenSkipCol(sheetObj),
				SheetDesign : 1,
				Merge : 1
			});
		}
		break;
	case IBRESET:
		var idx = 0
		var sXml2 = document.form2.sXml.value;
		var arrXml = sXml2.split("|$$|");
		// Location
		if (arrXml[idx] == null) {
			return;
		}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
		var arrStr1 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
			vListData = vArrayListData[i];
			arrStr1[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		// combo control, result string, Text Index, Code Index
		makeComboObject(combo_location, arrStr1, 1, 1, 0);
		idx++;
		// Type/Size
		if (arrXml[idx] == null) {
			return;
		}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
		var arrStr2 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
			vListData = vArrayListData[i];
			arrStr2[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		makeComboObject(combo_eq_tpsz_cd, arrStr2, 0, 0, 0);
		idx++;
		// Lease Term
		if (arrXml[idx] == null) {
			return;
		}
		var vArrayListData = ComCgmXml2ListMap(arrXml[idx]);
		var arrStr3 = new Array();
		for ( var i = 0; i < vArrayListData.length; i++) {
			vListData = vArrayListData[i];
			arrStr3[i] = vListData["code1"] + "|" + vListData["desc1"];
		}
		makeComboObject(combo_agmt_lstm_cd, arrStr3, 0, 0, 0);
		comboObjects[4].DeleteItem(comboObjects[4].FindItem("NP", 0, 1));
		idx++;
		// MVMT Status
		if (arrXml[idx] == null) {
			return;
		}
		var cols2 = ComCgmXml2ComboString(arrXml[idx], "code1", "code1");
		ComCgmMakeMultiCombo(combo_chss_mvmt_sts_cd, cols2[0], cols2[1], 0);
		idx++;
		break;
	}
}
/**
 * handling process for input validation <br>
 * 
 * @param {object}
 *            sheetObj Sheet Object
 * @param {object}
 *            formObj Form Object
 * @param {String}
 *            sAction Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT,
 *            IBDOWNEXCEL)
 * @return {boolean} false => validation check error, true => validation check
 *         succes
 * @author
 * @version
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		switch (sAction) {
		case IBSEARCH:
			if (crnt_loc_cd.value == '') {
				ComShowCodeMessage('CGM10004', 'Location');
				crnt_loc_cd.focus();
				return false;
			} else {
				if (crnt_loc_cd.value.length != 5) {
					ComShowCodeMessage('CGM10044', 'Location(5)');
					crnt_loc_cd.focus();
					return false;
				}
			}
			if (onh_dt.value == '') {
				var sysDate = new Date();
				var year = sysDate.getFullYear();
				var thisYear = ComLpad(year, 4, "0");
				onh_dt.value = thisYear;
			}
			if (onh_dt.value.length != 4) {
				ComShowCodeMessage('CGM10044', 'On-Hire Year')
				onh_dt.focus();
				return false;
			}
			break;
		}
	}
	return true;
}
/**
 * call back function. <br>
 * 
 * @param {Array}
 *            aryPopupData mandatory Array Object
 * @param {Int}
 *            row mandatoryselectedRow
 * @param {Int}
 *            col mandatoryselectedColumn
 * @param {Int}
 *            sheetIdx mandatory Sheet Index
 * @return
 * @author
 * @version
 */
function callBackLocation(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	var location = formObj.combo_location.text;
	var crntLocCd = "";
	var i = 0;
	for (i = 0; i < aryPopupData.length; i++) {
		if (location == 'RCC') {
			crntLocCd = crntLocCd + aryPopupData[i][11];
		} else if (location == 'LCC') {
			crntLocCd = crntLocCd + aryPopupData[i][10];
		} else if (location == 'SCC') {
			crntLocCd = crntLocCd + aryPopupData[i][8];
		}
		if (i < aryPopupData.length - 1) {
			crntLocCd = crntLocCd + ",";
		}
	}
	formObj.crnt_loc_cd.value = crntLocCd;
}
/**
 * call back function. <br>
 * 
 * @param {Array}
 *            aryPopupData mandatory Array Object
 * @param {Int}
 *            row mandatoryselectedRow
 * @param {Int}
 *            col mandatoryselectedColumn
 * @param {Int}
 *            sheetIdx mandatory Sheet Index
 * @return
 * @author
 * @version
 */
function callBackYard(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	var crntYdCd = "";
	var i = 0;
	for (i = 0; i < aryPopupData.length; i++) {
		crntYdCd = crntYdCd + aryPopupData[i][3];
		if (i < aryPopupData.length - 1) {
			crntYdCd = crntYdCd + ",";
		}
	}
	formObj.crnt_yd_cd.value = crntYdCd;
}
function callBackVendor(aryPopupData, row, col, sheetIdx) {
	var formObj = document.form;
	var vndrSeq = "";
	var i = 0;
	for (i = 0; i < aryPopupData.length; i++) {
		vndrSeq = vndrSeq + aryPopupData[i][2];
		if (i < aryPopupData.length - 1) {
			vndrSeq = vndrSeq + ",";
		}
	}
	formObj.vndr_seq.value = vndrSeq;
}
function sheet1_OnChangeSum(sheetObj, Row) {

}
/**
 * Sheet1 OnSearchEnd event handling <br>
 * 
 * @param {object}
 *            sheetObj Sheet Object
 * @param {string}
 *            ErrMsg String
 * @return
 * @version
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SetSumText(0, "Seq", "");
		SetSumText(0, "group1", "Grand Total");
		SetCellAlign(0, "group1", "Center");
	}
}
/**
 * Sheet1 OnMouseDown event handling <br>
 * 
 * @param {Integer}
 *            Button mandatory Integer
 * @param {integer}
 *            Shift mandatory Integer
 * @param {Integer}
 *            X mandatory Integer
 * @param {integer}
 *            Y mandatory Integer
 * @return
 * @author
 * @version
 */
function sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (sheetObj.RowCount() + 1 == sheetObj.MouseRow()) {
		// alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow
		// +":"+sheetObj.MouseCol)
		// var groupValue1 = sheetObj.GetCellValue(sheetObj.MouseRow, "group1");
		// alert(groupValue1);
		sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(),0, 0, 0, 0);
	}
}
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
	var eqKndCd = EQ_KND_CD_CHASSIS;
	var location = comboObjects[0].GetSelectCode();
	var crntLocCd = document.form.crnt_loc_cd.value;
	var crntYdCd = document.form.crnt_yd_cd.value;
	var aciacDivCd = comboObjects[1].GetSelectCode();
	var includeNp = "";
	if (document.form.include_np.checked) {
		includeNp = "Y";
	}
	var group1 = comboObjects[2].GetSelectCode();
	var groupValue1 = sheetObj.GetCellValue(Row, "group1");
	var s2_group1 = "";
	var s2_groupValue1 = "";
	var s3_gtotal = "";
	if (groupValue1.substring(0, 9) == "Sub Total") {
		s2_group1 = "SubSum";
		s2_groupValue1 = sheetObj.GetCellValue(Row - 1, "group1");
		groupValue1 = s2_groupValue1;
	} else if (groupValue1 == "Grand Total") {
		s3_gtotal = "GTOTAL";
	} else {
		s2_group1 = "";
		s2_groupValue1 = "";
	}
	var agmtLstmCd = comboObjects[4].GetSelectText();
	var vndrSeq = document.form.vndr_seq.value;
	var chssMvmtStsCd = comboObjects[5].GetSelectText();
	var eqTpszCd = comboObjects[3].GetSelectText();
	// var eqTpszCd = sheetObj.GetCellValue(Row,'eq_tpsz_cd');
	var colSaveName = sheetObj.ColSaveName(Col);
	var inqFmDys = '';
	var inqToDys = '';
	var baseData = document.form.onh_dt.value;
	if (baseData == '')
		return;
	if (parseInt(Col) == 4) // total
	{
		inqFmDys = '';
		inqToDys = (parseInt(baseData) + 0);
	} else if (parseInt(Col) == 12) {
		inqFmDys = (parseInt(baseData) - 5 + 1);
		inqToDys = (parseInt(baseData) + 0);
	} else if (parseInt(Col) == 11) {
		inqFmDys = (parseInt(baseData) - 10 + 1);
		inqToDys = (parseInt(baseData) - 5);
	} else if (parseInt(Col) == 10) {
		inqFmDys = (parseInt(baseData) - 15 + 1);
		inqToDys = (parseInt(baseData) - 10);
	} else if (parseInt(Col) == 9) {
		inqFmDys = (parseInt(baseData) - 20 + 1);
		inqToDys = (parseInt(baseData) - 15);
	} else if (parseInt(Col) == 8) {
		inqFmDys = (parseInt(baseData) - 25 + 1);
		inqToDys = (parseInt(baseData) - 20);
	} else if (parseInt(Col) == 7) {
		inqFmDys = (parseInt(baseData) - 30 + 1);
		inqToDys = (parseInt(baseData) - 25);
	} else if (parseInt(Col) == 6) {
		inqFmDys = (parseInt(baseData) - 35 + 1)
		inqToDys = (parseInt(baseData) - 30);
	} else if (parseInt(Col) == 5) {
		inqFmDys = '';
		inqToDys = (parseInt(baseData) - 35);
	}
	var param = "?program_id=1100";
	param = param + "&inq_fm_dys=" + inqFmDys;
	param = param + "&inq_to_dys=" + inqToDys;
	param = param + "&eq_knd_cd=" + eqKndCd;
	param = param + "&location=" + location;
	param = param + "&crnt_loc_cd=" + crntLocCd;
	param = param + "&crnt_yd_cd=" + crntYdCd;
	param = param + "&aciac_div_cd=" + aciacDivCd;
	param = param + "&include_np=" + includeNp;
	param = param + "&eq_tpsz_cd=" + eqTpszCd;
	param = param + "&group1=" + group1;
	param = param + "&group_value1=" + groupValue1;
	param = param + "&agmt_lstm_cd=" + agmtLstmCd;
	param = param + "&vndr_seq=" + vndrSeq;
	param = param + "&chss_mvmt_sts_cd=" + chssMvmtStsCd;
	param = param + "&s_group1=" + "COL_EQ_TPSZ_CD";
	param = param + "&s_group1_val=" + sheetObj.GetCellValue(Row, 'eq_tpsz_cd');
	param = param + "&s2_group1=" + s2_group1;
	param = param + "&s2_group1_val=" + s2_groupValue1;
	param = param + "&s3_gtotal=" + s3_gtotal;
	// var seq = sheetObj.GetCellValue(Row, "Seq");
	// alert(param);
	if (Col >= 3)// && seq != '')
	{
		ComOpenPopup('/opuscntr/EES_CGM_1091.do' + param, 900, 550, "", "1,0",
				true, false);
	} else {
		ComShowCodeMessage('CGM10016');
	}
}
/**
 * Location Multi-Combo OnChange event handling <br>
 * 
 * @param {object}
 *            ComboObj mandatory Sheet Object
 * @param {int}
 *            Index_Code mandatory
 * @param {string}
 *            Text mandatory
 * @return
 * @version
 */
function combo_location_OnChange(comboObj, oldIndex, oldText, oldCode,
		newIndex, newText, newCode) {
	document.form.crnt_loc_cd.value = "";
	/*
	 * arrGroup[0]="1|LCC[Location]"; arrGroup[1]="2|SCC[Location]";
	 * arrGroup[2]="3|Yard";
	 */
	if (newCode == "RCC") {
		combo_group1.SetSelectCode("1");
	} else if (newCode == "LCC") {
		combo_group1.SetSelectCode("2");
	} else if (newCode == "SCC") {
		combo_group1.SetSelectCode("3");
	}
	// combo_location_text.value = comboObj.GetText(parseInt(newIndex), 0);
	// document.form.combo_location_text.value = newCode;
}

function combo_location_OnBlur() {
	// document.form.combo_location_text.value = combo_location.GetSelectCode();
}

function combo_aciac_div_cd_OnChange(comboObj, oldIndex, oldText, oldCode,
		newIndex, newText, newCode) {
	// document.form.combo_aciac_div_cd_text.value =
	// comboObj.GetText(parseInt(newIndex), 0);
}

function combo_aciac_div_cd_OnBlur() {
	// document.form.combo_aciac_div_cd_text.value =
	// combo_aciac_div_cd.GetText(parseInt(combo_aciac_div_cd.GetSelectIndex()),
	// 0);
}

function combo_group1_OnBlur() {
	// document.form.combo_group1_text.value =
	// combo_group1.GetText(parseInt(combo_group1.GetSelectIndex()), 0);
}
/**
 * Group1 Multi-Combo OnChange event handling <br>
 * 
 * @param {object}
 *            ComboObj mandatory Sheet Object
 * @param {int}
 *            Index_Code mandatory
 * @param {string}
 *            Text mandatory
 * @return
 * @version
 */
function combo_group1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex,
		newText, newCode) {
	// Group MultiCombo value reset
	var arrGroup = new Array();
	var sheetObj = sheetObjects[0];
	// Sheet Object title value setting
	sheetObj.RemoveAll();
	sheetObj.SetCellValue(0, "group1", comboObj.GetSelectText());
	if (sheetObj.GetCellValue(0, "group1") == "") {
		sheetObj.SetColHidden("group1", 1);
	} else {
		sheetObj.SetColHidden("group1", 0);
	}
	// document.form.combo_group1_text.value =
	// comboObj.GetText(parseInt(newIndex), 0);
}

function combo_eq_tpsz_cd_OnChange(comboObj, oldIndex, oldText, oldCode,
		newIndex, newText, newCode) {
	// document.form.combo_eq_tpsz_cd_text.value = newCode;
}

function combo_eq_tpsz_cd_OnBlur() {
	// document.form.combo_eq_tpsz_cd_text.value =
	// combo_eq_tpsz_cd.GetSelectCode();
}

function combo_agmt_lstm_cd_OnChange(comboObj, oldIndex, oldText, oldCode,
		newIndex, newText, newCode) {
	// document.form.combo_agmt_lstm_cd_text.value = newCode;
}

function combo_agmt_lstm_cd_OnBlur() {
	// document.form.combo_agmt_lstm_cd_text.value =
	// combo_agmt_lstm_cd.GetSelectCode();
}

function combo_chss_mvmt_sts_cd_OnChange(comboObj, oldIndex, oldText, oldCode,
		newIndex, newText, newCode) {
	// document.form.combo_chss_mvmt_sts_cd_text.value = newCode;
}

function combo_chss_mvmt_sts_cd_OnBlur() {
	// document.form.combo_chss_mvmt_sts_cd_text.value =
	// combo_chss_mvmt_sts_cd.GetSelectCode();
}
/**
 * Object activate event handling <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function obj_activate() {
	ComClearSeparator(event.srcElement);
}
/**
 * Object deactivate event handling <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function obj_deactivate() {
	// ComChkObjValid(event.srcElement);
}
/**
 * Object Keypress event handling <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function obj_keypress() {
	obj = event.srcElement;
	if (obj.dataformat == null)
		return;
	window.defaultStatus = obj.dataformat;
	switch (obj.dataformat) {
	case "ym":
	case "ymd":
		ComKeyOnlyNumber(obj);
		break;
	case "int":
		if (obj.name == "vndr_seq")
			ComKeyOnlyNumber(obj, ",");
		else
			ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		if (obj.name == "vndr_seq")
			ComKeyOnlyNumber(obj, ",");
		else
			ComKeyOnlyAlphabet();
		break;
	case "engup":
		if (obj.name == "crnt_loc_cd")
			ComKeyOnlyAlphabet('upper');// ComKeyOnlyAlphabet('uppernum');
		else if (obj.name == "crnt_yd_cd")
			ComKeyOnlyAlphabet('uppernum', "44");
		else
			ComKeyOnlyAlphabet('upper');
		break;
	case "engdn":
		if (obj.name == "txtEngDn2")
			ComKeyOnlyAlphabet('lowernum')
		else
			ComKeyOnlyAlphabet('lower');
		break;
	}
}
/**
 * Object change event handling <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function obj_change() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	obj = event.srcElement;
	switch(ComGetEvent("name")) {
	case "vndr_seq":
		var vndrSeq = ComTrimAll(formObj.vndr_seq.value);
		var arrVndrSeq = vndrSeq.split(",");
		for ( var i = 0; i < arrVndrSeq.length; i++) {
			// 
			if (arrVndrSeq[i] == '') {
				ComShowCodeMessage('CGM10009', 'Lessor');
				formObj.vndr_seq.value = "";
				ComSetFocus(formObj.vndr_seq);
				break;
			}
		}
		break;
	}
}
/**
 * Object obj_focusout event handling <br>
 * 
 * @param
 * @return
 * @author
 * @version
 */
function obj_focusout() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	obj = event.srcElement;
	switch(ComGetEvent("name")) {
	case "crnt_yd_cd":
		break;
	}
}
/**
 * Combo Object reset <br>
 * 
 * @param {object}
 *            comboObj Combo Object
 * @return
 * @author
 * @version
 */
function initCombo(comboObj) {
	switch (comboObj.options.id) {
	case "combo_location":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			SetDropHeight(100);
			SetMultiSelect(0);
			SetMaxSelect(1);
			SetEnable(1);
			comboObj.SetUseAutoComplete(1);
		}
		break;
	case "combo_aciac_div_cd":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			SetDropHeight(100);
			SetMultiSelect(0);
			SetMaxSelect(1);
			SetEnable(1);
			comboObj.SetUseAutoComplete(1);
		}
		break;
	case "combo_group1":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			SetDropHeight(170);
			SetMultiSelect(0);
			SetMaxSelect(1);
			SetEnable(1);
			comboObj.SetUseAutoComplete(1);
		}
		break;
	case "combo_eq_tpsz_cd":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			SetDropHeight(150);
			SetMultiSelect(1);
			SetMaxSelect(100);
			SetEnable(1);
			SetMaxLength(20);
		}
		break;
	case "combo_agmt_lstm_cd":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			SetDropHeight(180);
			SetMultiSelect(1);
			SetMaxSelect(100);
			SetEnable(1);
			SetMaxLength(20);
		}
		break;
	case "combo_chss_mvmt_sts_cd":
		var cnt = 0;
		with (comboObj) {
			Code = "";
			Text = "";
			SetDropHeight(150);
			SetMultiSelect(1);
			SetMaxSelect(100);
			SetEnable(1);
			SetMaxLength(20);
		}
		break;
	}
}
function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
	cmbObj.RemoveAll();
	if (opt == 0) {
		for ( var i = 0; i < arrStr.length; i++) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
		}
	} else if (opt == 1) {
		cmbObj.InsertItem(0, "", "");
		for ( var i = 0; i < arrStr.length; i++) {
			var arrCode = arrStr[i].split("|");
			cmbObj.InsertItem(i + 1, arrCode[txtCol], arrCode[codeCol]);
		}
	}
	cmbObj.SetSelectIndex("", false);
}
function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
	cmbObj.RemoveAll();
	if (arrStr == undefined) {
		cmbObj.InsertItem(0, "Include Pool Chassis", "I");
		cmbObj.InsertItem(1, "Exclude Pool Chassis", "E");
		cmbObj.InsertItem(2, "Only Pool Chassis", "O");
	} else {
		var arrCode = arrStr[0].split("|");
		var arrCode2 = arrStr[1].split("|");
		for ( var i = 0; i < arrCode.length; i++) {
			var arrCode3 = arrCode[i].split("|");
			var arrCode4 = arrCode2[i].split("|");
			if (i == 0) {
				cmbObj.InsertItem(0, "Include Pool Chassis", "I");
				cmbObj.InsertItem(1, "Exclude Pool Chassis", "E");
				cmbObj.InsertItem(2, "Only Pool Chassis", "O");
				cmbObj.InsertItem(i + 3, arrCode4[txtCol], arrCode3[codeCol]);
			} else {
				cmbObj.InsertItem(i + 3, arrCode4[txtCol], arrCode3[codeCol]);
			}
		}
	}
	cmbObj.SetSelectIndex("", false);
}
function setTitle() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var baseData = formObj.onh_dt.value;
	if (baseData == null || baseData == '')
		return;
	sheetObj.SetCellValue(0, 4, parseInt(baseData) + " or Older\nTotal");
	sheetObj.SetCellValue(0, 12, (parseInt(baseData) - 5 + 1) + "~"
			+ (parseInt(baseData) + 0));
	sheetObj.SetCellValue(0, 11, (parseInt(baseData) - 10 + 1) + "~"
			+ (parseInt(baseData) - 5));
	sheetObj.SetCellValue(0, 10, (parseInt(baseData) - 15 + 1) + "~"
			+ (parseInt(baseData) - 10));
	sheetObj.SetCellValue(0, 9, (parseInt(baseData) - 20 + 1) + "~"
			+ (parseInt(baseData) - 15));
	sheetObj.SetCellValue(0, 8, (parseInt(baseData) - 25 + 1) + "~"
			+ (parseInt(baseData) - 20));
	sheetObj.SetCellValue(0, 7, (parseInt(baseData) - 30 + 1) + "~"
			+ (parseInt(baseData) - 25));
	sheetObj.SetCellValue(0, 6, (parseInt(baseData) - 35 + 1) + "~"
			+ (parseInt(baseData) - 30));
	sheetObj.SetCellValue(0, 5, "~" + (parseInt(baseData) - 35));
	return;
}
function enterFire() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	if (event.keyCode == 13) {
		if (validateForm(sheetObj, formObj, IBSEARCH)) {
			ComKeyEnter('search');
		}
	}
}
function obj_keyup() {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	obj = event.srcElement;
	switch(ComGetEvent("name")) {
	case "crnt_loc_cd":
		var crntLocCd = ComTrimAll(formObj.crnt_loc_cd.value);
		var arrCrntLocCd = crntLocCd.split(",");
		for ( var i = 0; i < arrCrntLocCd.length; i++) {
			// 
			if (arrCrntLocCd[i] == '') {
				ComShowCodeMessage('CGM10009', 'Location');
				formObj.crnt_loc_cd.value = "";
				ComSetFocus(formObj.crnt_loc_cd);
				break;
			} else {
				// if(formObj.crnt_loc_cd.value != ''){
				if (formObj.crnt_loc_cd.value.length == 5) {
					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC08);
				}
			}
		}
		break;
	case "crnt_yd_cd":
		var crntYdCd = ComTrimAll(formObj.crnt_yd_cd.value);
		if (formObj.crnt_yd_cd.value.search(',') > 0
				|| (formObj.crnt_yd_cd.value == '')) {
			break;
		}
		var arrCrntYdCd = crntYdCd.split(",");
		for ( var i = 0; i < arrCrntYdCd.length; i++) {
			// 
			if (arrCrntYdCd[i] == '') {
				ComShowCodeMessage('CGM10009', 'Yard');
				formObj.crnt_yd_cd.value = "";
				ComSetFocus(formObj.crnt_yd_cd);
				break;
			}
		}
		// if(arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value != ''){
		if (arrCrntYdCd.length == 1 && formObj.crnt_yd_cd.value.length == 7) {
			// doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
		}
		break;
	}
}
/* developer job end */
