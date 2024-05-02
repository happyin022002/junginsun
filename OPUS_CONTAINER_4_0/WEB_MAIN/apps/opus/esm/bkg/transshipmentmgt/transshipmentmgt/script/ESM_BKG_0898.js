/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0898.js
 *@FileTitle  :  Vessel/Port Group Assign by VVD, Port
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/28
=========================================================*/
/****************************************************************************************
 EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
 OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects = new Array();
var sheetCnt = 0;
var prefix1 = "sheet1_";
var prefix2 = "sheet2_";
var prefix3 = "sheet3_";
var prefix4 = "sheet4_";
var layList = null;
var trnsModCd = "";

// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	/** **************************************************** */
	var formObject = document.form;
    if(layList == undefined || layList == null) layList = document.getElementById("layList");
	try {
		var srcName = ComGetEvent("name");
		switch (srcName) {
		case "btn_multBkgNo":	
			
			if($("#btn_multBkgNo").is(":disabled")) return;
			var stop = $("#bkg_no").offset().top;
		    var sleft = $("#bkg_no").offset().left;
		    layList.style.left = sleft + "px";
		    layList.style.top = (stop-80) + "px";
		    
			if($("#layList").is(":visible") == false){
				$("#layList").show();
			}else{
				$("#layList").hide();
			}
			
			break;
		case "btn_retrieve":
//			if (ComChkLen(formObject.vvd, 9) != 2) {
//				ComShowCodeMessage("BKG00549");
//				return;
//			}
//			if (ComChkLen(formObject.port, 5) != 2 && ComChkLen(formObject.pol, 5) != 2 ) {
////				ComShowCodeMessage("BKG00424");
//				ComShowCodeMessage("BKG95025", "POD or 1st POL");
//				return;
//			}
			if(validateForm(sheetObjects[1], formObject, SEARCH)){
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				sheetObjects[4].RemoveAll();
				doActionIBSheet(sheetObject1, formObject, SEARCH);
			}
//			ComSetDisplay("btn_UnCheckAll", false);
//			ComSetDisplay("btn_CheckAll", true);
			break;
		case "btn_save":
			if(validateForm(sheetObjects[1], formObject, COMMAND03)){
				doActionIBSheet(sheetObjects[1], formObject, COMMAND03);				
			}
			break;
		case "btn_new":
			iniForm();
			break;
		case "btn_apply":
			if(!checkSelectSheet2()) return; 
			applyValues();
			break;
		case "btn_selectall":
			if(sheetObject2.RowCount()<1) return;
//			ComSetDisplay("btn_CheckAll", false);
//			ComSetDisplay("btn_UnCheckAll", true);
			sheetObject2.CheckAll(prefix2 + "chk", "1", 1);
//			validateSheet(false);
			break;
		case "btn_deselectall":
//			ComSetDisplay("btn_CheckAll", true);
//			ComSetDisplay("btn_UnCheckAll", false);
			sheetObject2.CheckAll(prefix2 + "chk", "0", 1);
			break;
		case "btn_vvdportchange":
//			var sRow1 = sheetObjects[0].FindCheckedRow(prefix1 + "chk");
//			var arrRow1 = sRow1.split("|");
//			var sRow2 = sheetObjects[1].FindCheckedRow(prefix2 + "chk");
//			var arrRow2 = sRow2.split("|");
//			if((sRow1 == "" && sRow2 == "") || (sRow1 != "" && sRow2 == "")){
//				ComShowCodeMessage("BKG00155");
//				return;
//			}
//			if (arrRow1.length == 0 || arrRow2.length == 0) {
//				ComShowCodeMessage("BKG00155");
//				return;
//			}
			
//			if(validateForm(sheetObjects[1], formObject, COMMAND02)){
//				doActionIBSheet(sheetObjects[2], formObject, COMMAND02);
//			}
			
			if(validateForm(sheetObjects[1], formObject, COMMAND04)){
				showRouteDetail();
			}
			break;
		case "btn_selectall_route":
			if(sheetObject1.RowCount()<1) return;
			sheetObject1.CheckAll(prefix1 + "chk", 1, 0);
			manageDeatilRowsHidden(0, "ALL");
			break;
		case "btn_deselectall_route":
			sheetObject1.CheckAll(prefix1 + "chk", 0, 0);
			manageDeatilRowsHidden(1, "ALL");
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 * 
 * @param sheet_obj
 *            IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * initializing sheet implementing onLoad event handler in body tag adding
 * first-served functions after loading screen.
 */
function loadPage() {
	for (i = 0; i < sheetObjects.length; i++) {
		if(i!=1){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}
	
	doActionIBSheet(sheetObjects[0], document.form, INIT);
	//Initialize sheetObjects[1] after getting Transport Mode Code
	ComConfigSheet(sheetObjects[1]);
	initSheet(sheetObjects[1], 2);
	ComEndConfigSheet(sheetObjects[1]);
	
	iniForm();
//	ComSetDisplay("btn_UnCheckAll", false);
	// axon_event.addListenerFormat('keypress','bkg0898_keypress',document.form);
	jqueryEvent();	
}

/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 * 
 * @param sheetObj
 *            sheet Object
 * @param sheetNo
 */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	switch (sheetNo) {
	case 1: // sheet1 init : Route Detail sheet(visible)
	    with(sheetObj){
		      var HeadTitle1="|Seq|Sel|POR|POL|POD|DEL|BKG Count|T.VVD|PRE VVD|PRE Relay|POST VVD|POST Relay|Remark|";
		
		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"seq" },
//		             {Type:"Radio",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, RadioIcon:0 },
		             {Type:"CheckBox",  Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"por_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
   		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"pol_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"pod_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"del_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_count",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"tvvd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"pre_vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"pre_relay",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"post_vvd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"post_relay", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		            ,{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix1+"route_key",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
		             ];
		       
		      InitColumns(cols);
		      SetSheetHeight(152);
		      SetEditable(1);      
            }
		break;
	case 2: // sheet2 init : BKG Detail Sheet(visible)
	    with(sheetObj){
//		      var HeadTitle1="|SEQ|SEL.|Booking No.|B/L No.|POL|TS1|TS2|TS3|POD|Result";
		      var HeadTitle1="|Seq|Sel|Booking No.|B/L No.|POR|POR|POL|POL|POD|POD|DEL|DEL|Term|Term|Trans|Trans|M'ty P/Up|M'ty P/Up|Full RTN||1st POL||1st VVD|1st POD|||2nd POL||2nd VVD|2nd POD|||3rd POL||3rd VVD|3rd POD|||4th POL||4th VVD|4th POD||Result||||";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:15, DataRowMerge:1, UseNoDataRow:0} );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
		             {Type:"Seq",		Hidden:0, Width:35,		Align:"Center",	ColMerge:1,	SaveName:prefix2+"seq" },
		             {Type:"CheckBox",	Hidden:0, Width:35,		Align:"Center",	ColMerge:1,	SaveName:prefix2+"chk",				KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:1,	InsertEdit:1 },
		             {Type:"Text",		Hidden:0, Width:100,	Align:"left",	ColMerge:1,	SaveName:prefix2+"bkg_no",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0, Width:100,	Align:"left",	ColMerge:1,	SaveName:prefix2+"bl_no",			KeyField:0,	CalcLogic:"",	Format:"",	PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
//		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"pol",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"ts1",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"ts2",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"ts3",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"result",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"por_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"por_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"pol_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"pod_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"del_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"org_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"dest_trns_mod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 

		             {Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"por_cd",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"por_nod_cd",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 ,EditLen:7,	InputCaseSensitive:1},
		             {Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_cd",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_nod_cd",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_cd",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_nod_cd",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"del_cd",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"del_nod_cd",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 ,EditLen:7,	InputCaseSensitive:1},
		             {Type:"Text",		Hidden:0,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"rcv_term_cd",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"de_term_cd",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
			         {Type:"Combo",		Hidden:0,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"org_trns_mod_cd",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 , ComboCode:trnsModCd, ComboText:trnsModCd},
			         {Type:"Combo",		Hidden:0,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"dest_trns_mod_cd",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 , ComboCode:trnsModCd, ComboText:trnsModCd},
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"mty_pkup_yd_cd",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:0,	Width:75,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"mty_pkup_dt",			KeyField:0,	CalcLogic:"",	Format:"Ymd",	PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:10 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"full_rtn_yd_cd",		KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:0,	Width:5,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"dum1",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_yd_cd1",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_clpt_ind_seq1",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:85,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"vvd1",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:9,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_yd_cd1",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_clpt_ind_seq1",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:5,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"dum2",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_yd_cd2",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_clpt_ind_seq2",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:85,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"vvd2",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:9,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_yd_cd2",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_clpt_ind_seq2",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:5,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"dum3",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_yd_cd3",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_clpt_ind_seq3",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:85,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"vvd3",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:9,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_yd_cd3",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_clpt_ind_seq3",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:5,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"dum4",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_yd_cd4",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pol_clpt_ind_seq4",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:85,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"vvd4",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:9,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:0,	Width:70,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_yd_cd4",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0	,EditLen:7,	InputCaseSensitive:1 },
		             {Type:"Text",		Hidden:1,	Width:20,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"pod_clpt_ind_seq4",	KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:1,	InsertEdit:0 },
		             {Type:"Text",		Hidden:0,	Width:500,	Align:"Left",	ColMerge:1,	SaveName:prefix2+"result",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0	,MultiLineText:1, Wrap:1 }
		            ,{Type:"Text",		Hidden:0,	Width:5,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"dum5",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 }
		            ,{Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"tvvd",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 }
		            ,{Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"tvvd_seq",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 }
		            ,{Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"route_key",			KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 }
		            ,{Type:"Text",		Hidden:1,	Width:60,	Align:"Center",	ColMerge:1,	SaveName:prefix2+"vvd_key",				KeyField:0,	CalcLogic:"",	Format:"",		PointCount:0,	UpdateEdit:0,	InsertEdit:0 }
		             ];
		      InitColumns(cols);
		      SetSheetHeight(320);
		      SetComboOpenMode(1);

		      SetEditable(1);      
            }
		break;
	case 3: // Not used
	    with(sheetObj){
		      var HeadTitle="|Cd|Seq|Pol1|Pol2|Pod1|Pod2|vslCd|skdVoyNo|skdDirCd|PolSeq|PodSeq";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"vsl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"pol_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"pod_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix3+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"pol_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix3+"pod_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetVisible(false);
		      SetEditable(1);      
            }
		break;
	case 4: // Use for temporary data storage during save logic (Not visible)
	    with(sheetObj){     
		      var HeadTitle="|bkgNo|tvvd|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix4+"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix4+"tvvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix4+"vsl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix4+"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix4+"pol_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix4+"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix4+"pod_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix4+"bkg_vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"pol_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"pod_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"mt_pickup_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"m_pu",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"f_ru",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"por_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"por_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"del_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"pol_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"pod_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"org_trns_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"dest_trns_mod_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		            ,{Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix4+"prev_tvvd", 		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
		             ];
		       
		      InitColumns(cols);
		      SetVisible(false);
		      SetEditable(1);    
            }
		break;
	case 5:// Use to set/get to/from ESM_BKG_0092(Route Detail)  (Not visible)
	    with(sheetObj){   
		      var HeadTitle="|Cd|Seq|Pol1|Pol2|Pod1|Pod2|Vvd|PolSeq|PodSeq";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vsl_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pol_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"pod_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"bkg_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pol_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"pod_clpt_ind_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);
		      SetVisible(false);
		      SetEditable(1);   
            }
		break;
	}
}

/**
 * Sheet process handling
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var arrPreFix = sheetObj.id + "_";
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case INIT:
		formObj.f_cmd.value = INIT;
		var sXml = sheetObj.GetSearchData("ESM_BKG_0898GS.do", FormQueryString(formObj));
		trnsModCd = ComGetEtcData(sXml, "CD01720_CODE");
		break;
	case SEARCH: // Retrieve
		ComOpenWait(true);
		setTimeout( function () { //show processing image
		try{
			clearBaseVvd();
			//Search Route Details information
			formObj.f_cmd.value = SEARCH;
			var sXml = sheetObj.GetSearchData("ESM_BKG_0898GS.do",
					FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPreFix));
				
	//		sheetObj.RenderSheet(0);
	//		sheetObj.SetVisible(false);
			sheetObj.LoadSearchData(sXml, {
				Sync : 0
			});
			if (ComGetTotalRows(sXml) > 0){
				//Search BKG Details information
				formObj.f_cmd.value = SEARCH01;
				var sXmlDetail = sheetObjects[1].GetSearchData("ESM_BKG_0898GS.do",
						FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix2));
	
				sheetObjects[1].LoadSearchData(sXmlDetail, {
					Sync : 1
				});
	
				ComSetObjValue(formObj.base_vvd, ComGetObjValue(formObj.vvd));
				if(ComGetObjValue(formObj.base_vvd)==""){
					setLabel(0);
				}else{
					setLabel(1);
				}
				manageDeatilRowsHidden(1,"ALL");
				setVvdColor();
			}
	//		sheetObj.RenderSheet(1);
	//		sheetObj.SetVisible(true);
	//		ComSetDisplay("btn_UnCheckAll", false);
			ComClearObject(formObj.totalBl);
			ComClearObject(formObj.success);
			ComClearObject(formObj.fail);
			ComOpenWait(false);
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
			ComOpenWait(false);
		}
		} , 100);
		break;
	case COMMAND01: // bkg_detail Retrieve
		formObj.f_cmd.value = COMMAND01;
		var params = FormQueryString(formObj);
		params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(true));				
		params = params + "&" + ComGetPrefixParam("sheet2_");
		var sXml = sheetObjects[1].GetSearchData("ESM_BKG_0898GS.do", params);
		sheetObjects[1].RenderSheet(0);
		sheetObjects[1].LoadSearchData(sXml, {
			Sync : 1
		});
		sheetObjects[1].RenderSheet(1);
		ComSetDisplay("btn_UnCheckAll", false);
		// no support[check again]CLT
		ComSetObjValue(formObj.totalBl,sheetObjects[1].RowCount());
		break;
	case COMMAND02:      //VVD_Port Change Retrieve
	    formObj.f_cmd.value=COMMAND02;
	    var params=FormQueryString(formObj);
    	params=params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true));
		params=params + "&" + ComGetPrefixParam("sheet3_");
		sheetObj.SetWaitImageVisible(0);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0898GS.do", params);
	    sheetObj.LoadSearchData(sXml,{Sync:1});
	    break; 
	case COMMAND03:      //Save
		ComOpenWait(true);
		setTimeout( function () { //show processing image
		try{
			formObj.f_cmd.value=COMMAND03;
			ComSetObjValue(formObj.success, "0");
			ComSetObjValue(formObj.fail, "0");
			
			var sheet2Row = findCheckedVisibleRow(sheetObjects[1], prefix2 + "chk");
			var arrSheet2Row = sheet2Row.split("|");
			ComSetObjValue(formObj.totalBl, arrSheet2Row.length);
			
			for ( var icnt = 0; icnt < arrSheet2Row.length; icnt++) {
				sheetObjects[3].RemoveAll();
				
				for(var vvdNo=1;vvdNo<=4;vvdNo++){
					if(sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pol_yd_cd"+String(vvdNo))!=""){
						var row = sheetObjects[3].DataInsert(-1);
						sheetObjects[3].SetCellValue(row, prefix4 + "pol_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pol_yd_cd"+String(vvdNo)).substring(0,5), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "pod_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pod_yd_cd"+String(vvdNo)).substring(0,5), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "pol_yd_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pol_yd_cd"+String(vvdNo)), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "pod_yd_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pod_yd_cd"+String(vvdNo)), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "bkg_vvd_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"vvd"+String(vvdNo)), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "bkg_no", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"bkg_no"), 0);
//						sheetObjects[3].SetCellValue(row, prefix4 + "tvvd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"tvvd"), 0);
//						if(vvdNo==1){ //set only for first row //Quit calculating tvvd at screen side
//							sheetObjects[3].SetCellValue(row, prefix4 + "tvvd", getTvvd(arrSheet2Row[icnt]), 0);
//							sheetObjects[3].SetCellValue(row, prefix4 + "prev_tvvd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"tvvd"), 0);							
//						}else{
//							sheetObjects[3].SetCellValue(row, prefix4 + "tvvd", "", 0);
//							sheetObjects[3].SetCellValue(row, prefix4 + "prev_tvvd", "", 0);
//						}
						sheetObjects[3].SetCellValue(row, prefix4 + "tvvd", "", 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "prev_tvvd", "", 0);
						
						sheetObjects[3].SetCellValue(row, prefix4 + "mt_pickup_dt", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"mty_pkup_dt").replace(/-/g,""), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "m_pu", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"mty_pkup_yd_cd"), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "f_ru", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"full_rtn_yd_cd"), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "pol_clpt_ind_seq", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pol_clpt_ind_seq"+String(vvdNo)), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "pod_clpt_ind_seq", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pod_clpt_ind_seq"+String(vvdNo)), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "por_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"por_nod_cd").substring(0,5), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "por_nod_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"por_nod_cd"), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "del_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"del_nod_cd").substring(0,5), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "del_nod_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"del_nod_cd"), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "pol_nod_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pol_nod_cd"), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "pod_nod_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"pod_nod_cd"), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "org_trns_mod_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"org_trns_mod_cd"), 0);
						sheetObjects[3].SetCellValue(row, prefix4 + "dest_trns_mod_cd", sheetObjects[1].GetCellValue(arrSheet2Row[icnt], prefix2+"dest_trns_mod_cd"), 0);
					}else{
						break;
					}
				}
				
				var params = FormQueryString(formObj);
				params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true));
				params = params + "&" + ComGetPrefixParam("sheet4_");
	
				var sXml = sheetObjects[3].GetSaveData("ESM_BKG_0898GS.do", params);
				var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
				if (State == "S") {
					//Update information in the screen
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "result", "Success", 0);
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "mty_pkup_yd_cd", ComGetEtcData(sXml,"mty_pkup_yd_cd"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "mty_pkup_dt", ComGetEtcData(sXml,"mty_pkup_dt"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "full_rtn_yd_cd", ComGetEtcData(sXml,"full_rtn_yd_cd"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "vvd1", ComGetEtcData(sXml,"vvd1"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_yd_cd1", ComGetEtcData(sXml,"pol_yd_cd1"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_clpt_ind_seq1", ComGetEtcData(sXml,"pol_clpt_ind_seq1"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_yd_cd1", ComGetEtcData(sXml,"pod_yd_cd1"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_clpt_ind_seq1", ComGetEtcData(sXml,"pod_clpt_ind_seq1"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "vvd2", ComGetEtcData(sXml,"vvd2"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_yd_cd2", ComGetEtcData(sXml,"pol_yd_cd2"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_clpt_ind_seq2", ComGetEtcData(sXml,"pol_clpt_ind_seq2"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_yd_cd2", ComGetEtcData(sXml,"pod_yd_cd2"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_clpt_ind_seq2", ComGetEtcData(sXml,"pod_clpt_ind_seq2"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "vvd3", ComGetEtcData(sXml,"vvd3"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_yd_cd3", ComGetEtcData(sXml,"pol_yd_cd3"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_clpt_ind_seq3", ComGetEtcData(sXml,"pol_clpt_ind_seq3"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_yd_cd3", ComGetEtcData(sXml,"pod_yd_cd3"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_clpt_ind_seq3", ComGetEtcData(sXml,"pod_clpt_ind_seq3"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "vvd4", ComGetEtcData(sXml,"vvd4"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_yd_cd4", ComGetEtcData(sXml,"pol_yd_cd4"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pol_clpt_ind_seq4", ComGetEtcData(sXml,"pol_clpt_ind_seq4"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_yd_cd4", ComGetEtcData(sXml,"pod_yd_cd4"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "pod_clpt_ind_seq4", ComGetEtcData(sXml,"pod_clpt_ind_seq4"));
					
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "por_nod_cd", ComGetEtcData(sXml,"por_nod_cd"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "del_nod_cd", ComGetEtcData(sXml,"del_nod_cd"));
					
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "org_trns_mod_cd", ComGetEtcData(sXml,"org_trns_mod_cd"));
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "dest_trns_mod_cd", ComGetEtcData(sXml,"dest_trns_mod_cd")); 
					
					ComSetObjValue(formObj.success, ComParseInt(formObj.success) + 1);
				} else {
	//				sheetObjects[1].LoadSearchData(sXml, {
	//					Sync : 1
	//				});
	//				return false;
//					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "result", ComGetSelectSingleNode(sXml ,"message").replace(/\<\|\|\>/g," "), 0);
					var result = ComGetSelectSingleNode(sXml ,"message").trim();
					if(result.substring(0,4)=="<||>") result=result.substring(5,result.length);
					if(result.substring(result.length-4)=="<||>") result=result.substring(0,result.length-4);
					sheetObjects[1].SetCellValue(arrSheet2Row[icnt], prefix2 + "result",result.replace(/\<\|\|\>/g,"\n"), 0);
					ComSetObjValue(formObj.fail, ComParseInt(formObj.fail) + 1);
					
				}		
			}
			if (arrSheet2Row.length == ComParseInt(formObj.success)) {
				ComShowCodeMessage("BKG06022");
			}else{
				ComShowCodeMessage("BKG00628", ComParseInt(formObj.fail) + " Booking(s). Please check result column.");
			}
			ComOpenWait(false);
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
			ComOpenWait(false);
		}
		} , 100);
		break; 
	}
}
/**
 * handling process for input validation
 * 
 * @param flag
 */
function validateSheet(flag) {
	with (sheetObjects[1]) {
		var sRow = FindCheckedRow(prefix2 + "chk");
		var arrRow = sRow.split("|");
		var pol = "";
		var ts2 = "";
		var ts3 = "";
		var pod = "";
		for ( var i = 0; i < arrRow.length; i++) {
			pol = GetCellValue(arrRow[i], prefix2 + "pol");
			ts1 = GetCellValue(arrRow[i], prefix2 + "ts1");
			ts2 = GetCellValue(arrRow[i], prefix2 + "ts2");
			ts3 = GetCellValue(arrRow[i], prefix2 + "ts3");
			pod = GetCellValue(arrRow[i], prefix2 + "pod_cd");
			if (pol != GetCellValue(arrRow[i], prefix2 + "pol")
					|| ts1 != GetCellValue(arrRow[i], prefix2 + "ts1")
					|| ts2 != GetCellValue(arrRow[i], prefix2 + "ts2")
					|| ts3 != GetCellValue(arrRow[i], prefix2 + "ts3")
					|| pod != GetCellValue(arrRow[i], prefix2 + "pod_cd")) {
				SetCellValue(arrRow[i], prefix2 + "chk", 0);
				ComShowCodeMessage("BKG00721");
				if (flag) {
					break;
				} else {
//					ComSetDisplay("btn_CheckAll", true);
//					ComSetDisplay("btn_UnCheckAll", false);
				}
			}
		}
	}
}
/**
 * sheet1 change handling
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);
//	if (sName == prefix1 + "chk" && Value == "1") {
//		ComSetObjValue(formObj.success, "0");
//		ComSetObjValue(formObj.fail, "0");
//		sheetObjects[2].RemoveAll();
//		sheetObjects[3].RemoveAll();
//		sheetObjects[4].RemoveAll();
//		doActionIBSheet(sheetObj, formObj, COMMAND01);
		
//	}
	
	if (sName == prefix1 + "chk"){
		manageDeatilRowsHidden(1- Value, sheetObj.GetCellValue(Row, prefix1+"route_key"));
	}
	
//	ComSetDisplay("btn_UnCheckAll", false);
//	ComSetDisplay("btn_CheckAll", true);
}
/**
 * sheet2 change handling
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var formObj = document.form;
	var sName = sheetObj.ColSaveName(Col);
//	if (sName == prefix2 + "chk" && Value == "1") {
//		validateSheet(true);
//	}
	//Changed value is set to red
	if(
		(sName==prefix2+"pol_nod_cd")||(sName==prefix2+"pod_nod_cd")||(sName==prefix2+"por_nod_cd")||(sName==prefix2+"del_nod_cd")
		||(sName==prefix2+"mty_pkup_yd_cd")||(sName==prefix2+"mty_pkup_dt")||(sName==prefix2+"full_rtn_yd_cd")
		||(sName==prefix2+"pol_yd_cd1")||(sName==prefix2+"vvd1")||(sName==prefix2+"pod_yd_cd1")
		||(sName==prefix2+"pol_yd_cd2")||(sName==prefix2+"vvd2")||(sName==prefix2+"pod_yd_cd2")
		||(sName==prefix2+"pol_yd_cd3")||(sName==prefix2+"vvd3")||(sName==prefix2+"pod_yd_cd3")
		||(sName==prefix2+"pol_yd_cd4")||(sName==prefix2+"vvd4")||(sName==prefix2+"pod_yd_cd4")
		||(sName==prefix2+"org_trns_mod_cd")||(sName==prefix2+"dest_trns_mod_cd")
	){
		if(Value!= sheetObjects[1].CellSearchValue(Row, Col)){
			sheetObjects[1].SetCellFontColor(Row, Col, "#FF0000");
		}else{
			sheetObjects[1].SetCellFontColor(Row, Col, "#000000");
		}
	}
	
	if(sName==prefix2+"pol_yd_cd1"){
		sheetObjects[1].SetCellValue(Row, prefix2+"pol_nod_cd", Value);
		if(sheetObjects[1].GetCellValue(Row, prefix2+"rcv_term_cd")=="Y"){
			if(sheetObjects[1].GetCellValue(Row, prefix2+"por_nod_cd").substring(0,5)==Value.substring(0,5)){ //Change POR only in case of terminal change
				sheetObjects[1].SetCellValue(Row, prefix2+"por_nod_cd", Value);				
			}else{
//				sheetObjects[1].SetCellValue(Row, prefix2+"por_nod_cd", sheetObjects[1].CellSearchValue(Row, prefix2+"por_nod_cd"));				
			}
		}
	}
	
	if((sName==prefix2+"pod_yd_cd1")||(sName==prefix2+"pod_yd_cd2")||(sName==prefix2+"pod_yd_cd3")||(sName==prefix2+"pod_yd_cd4")){
		for(vvdNum=4;vvdNum>0;vvdNum--){ // must be different from "vvdNo"
			if((vvdNum==1)||(sheetObjects[1].GetCellValue(Row, prefix2+"pod_yd_cd"+String(vvdNum))!="")){
				sheetObjects[1].SetCellValue(Row, prefix2+"pod_nod_cd", sheetObjects[1].GetCellValue(Row, prefix2+"pod_yd_cd"+String(vvdNum)));
				if(sheetObjects[1].GetCellValue(Row, prefix2+"de_term_cd")=="Y"){
					if(sheetObjects[1].GetCellValue(Row, prefix2+"del_nod_cd").substring(0,5)==sheetObjects[1].GetCellValue(Row, prefix2+"pod_yd_cd"+String(vvdNum)).substring(0,5)){
						sheetObjects[1].SetCellValue(Row, prefix2+"del_nod_cd", sheetObjects[1].GetCellValue(Row, prefix2+"pod_yd_cd"+String(vvdNum)));
					}else{
//						sheetObjects[1].SetCellValue(Row, prefix2+"del_nod_cd", sheetObjects[1].CellSearchValue(Row, prefix2+"del_nod_cd"));
					}
				}
				break;
			}
		}
	}
	
	//If VVD is changed, delete POL/POD_CLPT_IND_SEQ
	if(sName.substring(7,16)=="pol_yd_cd"){
		sheetObjects[1].SetCellValue(Row, prefix2+"pol_clpt_ind_seq"+sName.substring(16,17), "", 0);
	}
	if(sName.substring(7,10)=="vvd"){
		sheetObjects[1].SetCellValue(Row, prefix2+"pol_clpt_ind_seq"+sName.substring(10,11), "", 0);
		sheetObjects[1].SetCellValue(Row, prefix2+"pod_clpt_ind_seq"+sName.substring(10,11), "", 0);
	}
	if(sName.substring(7,16)=="pod_yd_cd"){
		sheetObjects[1].SetCellValue(Row, prefix2+"pod_clpt_ind_seq"+sName.substring(16,17), "", 0);
	}	
}
/**
 * obj key press event handling
 */
// function bkg0898_keypress(){
// obj=event.srcElement;
// if(obj.dataformat == null) return;
// window.defaultStatus=obj.dataformat;
// switch(obj.dataformat){
// case "num":
// ComKeyOnlyNumber(event.srcElement);
// break;
// case "engup":
// ComKeyOnlyAlphabet('uppernum');
// break;
// }
// }
/**
 * handling process after ending route detail
 */
function callBack0092(){
	if (0 == sheetObjects[4].RowCount()) {
		return;
	}
	
	var sheet1Count = sheetObjects[1].RowCount(); //Main data
	var sheet4Count = sheetObjects[4].RowCount(); //The data of Route Detail
	for(m=1;m<=sheet1Count;m++){
		if(sheetObjects[1].GetCellValue(m, prefix2+"chk")==1){ //Checked row is target
			for(j=1;j<=4;j++){
				if(j<=sheet4Count){ // Set values of Route Detail
					if(sheetObjects[4].GetCellValue(j, "pol_cd")!=""){
						sheetObjects[1].SetCellValue(m, prefix2+"vvd"+String(j), sheetObjects[4].GetCellValue(j, "bkg_vvd_cd"));
						sheetObjects[1].SetCellValue(m, prefix2+"pol_yd_cd"+String(j), sheetObjects[4].GetCellValue(j, "pol_cd")+sheetObjects[4].GetCellValue(j, "pol_yd_cd"));
						sheetObjects[1].SetCellValue(m, prefix2+"pol_clpt_ind_seq"+String(j), sheetObjects[4].GetCellValue(j, "pol_clpt_ind_seq"));
						sheetObjects[1].SetCellValue(m, prefix2+"pod_yd_cd"+String(j), sheetObjects[4].GetCellValue(j, "pod_cd")+sheetObjects[4].GetCellValue(j, "pod_yd_cd"));
						sheetObjects[1].SetCellValue(m, prefix2+"pod_clpt_ind_seq"+String(j), sheetObjects[4].GetCellValue(j, "pod_clpt_ind_seq"));
					}
				}else{ // Delete rest values (not specified VVDs to 4th)
					sheetObjects[1].SetCellValue(m, prefix2+"vvd"+String(j), "");
					sheetObjects[1].SetCellValue(m, prefix2+"pol_yd_cd"+String(j), "");
					sheetObjects[1].SetCellValue(m, prefix2+"pol_clpt_ind_seq"+String(j), "");
					sheetObjects[1].SetCellValue(m, prefix2+"pod_yd_cd"+String(j), "");
					sheetObjects[1].SetCellValue(m, prefix2+"pod_clpt_ind_seq"+String(j), "");					
				}
			}
			//Only when POR and DEL of selected bookings are same, update transport mode
			if(ComGetObjValue(document.form.same_por_del)=="Y"){
				sheetObjects[1].SetCellValue(m, prefix2+"org_trns_mod_cd", ComGetObjValue(document.form.org_trns_mod_cd));
				sheetObjects[1].SetCellValue(m, prefix2+"dest_trns_mod_cd", ComGetObjValue(document.form.dest_trns_mod_cd));
			}
		}
	}
}

function callBack0092_old() {
	if (0 == sheetObjects[4].RowCount()) {
		return;
	}
	var formObj = document.form;
	var sheetObj = sheetObjects[4];
	var sRow1 = sheetObjects[0].FindCheckedRow(prefix1 + "chk");
	var arrRow1 = sRow1.split("|");
	var sRow2 = sheetObjects[1].FindCheckedRow(prefix2 + "chk");
	var arrRow2 = sRow2.split("|");
	ComSetObjValue(formObj.success, "0");
	ComSetObjValue(formObj.fail, "0");
	ComOpenWait(true);
	for ( var icnt = 0; icnt < arrRow2.length; icnt++) {
		sheetObjects[3].RemoveAll();
		// no support[check again]CLT for(var iRow=1;iRow<sheetObj.Rows;iRow++){
		for(var iRow=1;iRow<sheetObj.HeaderRows()+sheetObj.RowCount();iRow++){
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "vsl_pre_pst_cd", sheetObj.GetCellValue(iRow, "vsl_pre_pst_cd"), 0);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "vsl_seq", sheetObj.GetCellValue(iRow, "vsl_seq"), 0);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "pol_cd", sheetObj.GetCellValue(iRow, "pol_cd"), 0);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "pod_cd", sheetObj.GetCellValue(iRow, "pod_cd"), 0);
			if (!ComIsEmpty(sheetObj.GetCellValue(iRow, "pol_yd_cd"))) {
				sheetObjects[3].SetCellValue(iRow, prefix4 + "pol_yd_cd", sheetObj.GetCellValue(iRow, "pol_cd") + sheetObj.GetCellValue(iRow, "pol_yd_cd"), 0);
			}
			if (!ComIsEmpty(sheetObj.GetCellValue(iRow, "pod_yd_cd"))) {
				sheetObjects[3].SetCellValue(iRow, prefix4 + "pod_yd_cd", sheetObj.GetCellValue(iRow, "pod_cd")	+ sheetObj.GetCellValue(iRow, "pod_yd_cd"), 0);
			}
			sheetObjects[3].SetCellValue(iRow, prefix4 + "pol_clpt_ind_seq",sheetObj.GetCellValue(iRow, "pol_clpt_ind_seq"), 0);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "pod_clpt_ind_seq",sheetObj.GetCellValue(iRow, "pod_clpt_ind_seq"), 0);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "bkg_vvd_cd", sheetObj.GetCellValue(iRow, "bkg_vvd_cd"), 0);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "bkg_no", sheetObjects[1].GetCellValue(arrRow2[icnt], prefix2 + "bkg_no"), 0);
			sheetObjects[3].SetCellValue(iRow, prefix4 + "tvvd", sheetObjects[0].GetCellValue(arrRow1[0], prefix1 + "tvvd"), 0);
		}
		formObj.f_cmd.value = COMMAND03;
		var params = FormQueryString(formObj);
		params = params + "&" + ComSetPrifix(sheetObjects[3].GetSaveString(true));
		params = params + "&" + ComGetPrefixParam("sheet4_");
		sheetObjects[3].SetWaitImageVisible(0);
		var sXml = sheetObjects[3].GetSaveData("ESM_BKG_0898GS.do", params);
		var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		if (State == "S") {
			sheetObjects[1].SetCellValue(arrRow2[icnt], prefix2 + "result",
					"Success", 0);
			ComSetObjValue(formObj.success, ComParseInt(formObj.success) + 1);
		} else {
			ComOpenWait(false);
			sheetObjects[1].LoadSearchData(sXml, {
				Sync : 1
			});
			return false;
			// sheetObjects[1].CellValue2(arrRow2[icnt],prefix2+"result")="Fail";
			// ComSetObjValue(formObj.fail,ComParseInt(formObj.fail)+1);
		}
		sheetObjects[1].SetCellValue(arrRow2[icnt], prefix2 + "chk", "0", 0);
		if (icnt == 0) {
//			ComSetDisplay("btn_UnCheckAll", false);
//			ComSetDisplay("btn_CheckAll", true);
		}
	}
	ComOpenWait(false);
	if (arrRow2.length > 0) {
		ComShowCodeMessage("BKG06022");
	}	
}
/**
 * initializing form
 */
function iniForm() {
	var formObject = document.form;
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
	sheetObjects[3].RemoveAll();
	sheetObjects[4].RemoveAll();
	ComClearObject(formObject.vvd);
//	ComClearObject(formObject.port);
	ComClearObject(formObject.pol);
	ComClearObject(formObject.pol_yd_cd);
	ComClearObject(formObject.pod);
	ComClearObject(formObject.pod_yd_cd);
	ComClearObject(formObject.bkgOfcCd);
	ComClearObject(formObject.bkg_no);
	ComClearObject(formObject.totalBl);
	ComClearObject(formObject.success);
	ComClearObject(formObject.fail);
	ComClearObject(formObject.mty_pkup_yd_cd_apply);
	ComClearObject(formObject.mty_pkup_dt_apply);
	ComClearObject(formObject.full_rtn_yd_cd_apply);
	clearBaseVvd();
	ComClearObject(formObject.pol_yd_cd_apply);
	ComClearObject(formObject.pod_yd_cd_apply);
	ComClearObject(formObject.with_relay);
	multiBkgTextArea(1);
	
	
}
/**
 * input to sheet in case of call T/S Route
 */
//function RouteToSheet(sheetObj, prefix) {
//	if (ComIsEmpty(sheetObj.GetCellValue(1, prefix + "vsl_pre_pst_cd"))) {
//		return;
//	}
//	sheetObjects[4].RemoveAll();
//	for(var iRow=1;iRow<sheetObj.LastRow()+1;iRow++){
//		with (sheetObjects[4]) {
//			DataInsert(-1);
//			SetCellValue(iRow, "vsl_pre_pst_cd", sheetObj.GetCellValue(iRow, prefix + "vsl_pre_pst_cd"), 0);				
//			SetCellValue(iRow, "vsl_seq", sheetObj.GetCellValue(iRow, prefix + "vsl_seq"), 0);				
//			SetCellValue(iRow, "pol_cd", sheetObj.GetCellValue(iRow, prefix + "pol_cd"), 0);				
//			if (!ComIsEmpty(sheetObj.GetCellValue(iRow, prefix + "pol_yd_cd"))) {
//				SetCellValue(iRow, "pol_yd_cd", sheetObj.GetCellValue(iRow,prefix + "pol_yd_cd").substring(5, 8), 0); 					
//			}
//			SetCellValue(iRow, "pod_cd", sheetObj.GetCellValue(iRow, prefix
//					+ "pod_cd"), 0);
//			if (!ComIsEmpty(sheetObj.GetCellValue(iRow, prefix + "pod_yd_cd"))) {
//				SetCellValue(iRow, "pod_yd_cd", sheetObj.GetCellValue(iRow, prefix + "pod_yd_cd").substring(5, 8), 0);					
//			}
//			SetCellValue(iRow, "bkg_vvd_cd", sheetObj.GetCellValue(iRow, prefix + "vsl_cd")+ sheetObj.GetCellValue(iRow, prefix + "skd_voy_no")+ sheetObj.GetCellValue(iRow, prefix + "skd_dir_cd"), 0);												
//			SetCellValue(iRow, "pol_clpt_ind_seq", sheetObj.GetCellValue(iRow,prefix + "pol_clpt_ind_seq"), 0);				
//			SetCellValue(iRow, "pod_clpt_ind_seq", sheetObj.GetCellValue(iRow,prefix + "pod_clpt_ind_seq"), 0);				
//		}
//	}
//}

//function sheet3_OnSearchEnd(sheetObj, Code, ErrMsg){
//	var formObj = document.form;
//	RouteToSheet(sheetObjects[2],prefix3);
////	ComSetObjValue(formObj.bkg_pol_cd,sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix1+"pol_cd"));
////	ComSetObjValue(formObj.bkg_pod_cd,sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix1+"pod_cd"));
////	ComSetObjValue(formObj.bkg_por_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"por_cd"));
////	ComSetObjValue(formObj.bkg_del_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"del_cd"));
////	ComSetObjValue(formObj.bkg_por_yd_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"por_nod_cd"));
////	ComSetObjValue(formObj.bkg_pol_yd_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"pol_nod_cd"));
////	ComSetObjValue(formObj.bkg_pod_yd_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"pod_nod_cd"));
////	ComSetObjValue(formObj.bkg_del_yd_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"del_nod_cd"));
////	ComSetObjValue(formObj.dest_trns_mod_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"dest_trns_mod_cd"));
////	ComSetObjValue(formObj.org_trns_mod_cd,sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"org_trns_mod_cd"));
////	var param="?bkg_no="+sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),prefix2+"bkg_no");
////	param+="&bkgTrunkVvd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix1+"tvvd");
//
//	var row = findCheckedVisibleRow(sheetObjects[1], prefix2+"chk").split("|")[0];
//	ComSetObjValue(formObj.bkg_pol_cd, sheetObjects[1].CellSearchValue(row, prefix2+"pol_cd"));
//	ComSetObjValue(formObj.bkg_pod_cd, sheetObjects[1].CellSearchValue(row, prefix2+"pod_cd"));
//	ComSetObjValue(formObj.bkg_por_cd, sheetObjects[1].CellSearchValue(row, prefix2+"por_cd"));
//	ComSetObjValue(formObj.bkg_del_cd, sheetObjects[1].CellSearchValue(row, prefix2+"del_cd"));
//	ComSetObjValue(formObj.bkg_por_yd_cd, sheetObjects[1].CellSearchValue(row, prefix2+"por_nod_cd").substring(5,7));
//	ComSetObjValue(formObj.bkg_pol_yd_cd, sheetObjects[1].CellSearchValue(row, prefix2+"pol_nod_cd").substring(5,7));
//	ComSetObjValue(formObj.bkg_pod_yd_cd, sheetObjects[1].CellSearchValue(row, prefix2+"pod_nod_cd").substring(5,7));
//	ComSetObjValue(formObj.bkg_del_yd_cd, sheetObjects[1].CellSearchValue(row, prefix2+"del_nod_cd").substring(5,7));
//	ComSetObjValue(formObj.org_trns_mod_cd, sheetObjects[1].CellSearchValue(row, prefix2+"org_trns_mod_cd"));
//	ComSetObjValue(formObj.dest_trns_mod_cd, sheetObjects[1].CellSearchValue(row, prefix2+"dest_trns_mod_cd"));
//
//	var param="?bkg_no="+sheetObjects[1].GetCellValue(row, prefix2+"bkg_no");
//	param+="&bkgTrunkVvd="+sheetObjects[1].GetCellValue(row, prefix2+"tvvd");
//				param+="&ca_flg=";
//				param+="&callSheetIdx=4";
//				param+="&pgmNo=ESM_BKG_0092";
//		
//	ComOpenPopup("/opuscntr/ESM_BKG_0092.do"+param, 700, 510, 'callBack0092','1,0,1,1,1', true);
//}

function manageDeatilRowsHidden(hide, routeKey){
	var rowCount = sheetObjects[1].RowCount();
	var changeIdx = "";
	for (i=1;i<=rowCount;i++){
		if(((routeKey=="ALL")&&(sheetObjects[1].GetRowHidden(i)!=hide))
		  ||(sheetObjects[1].GetCellValue(i, prefix2 + "route_key") == routeKey)){
			changeIdx += i + "|"; //make index string for performance
			sheetObjects[1].SetCellValue(i, prefix2+"chk", 0, 0);
		}
	}
	if(changeIdx!=""){
		sheetObjects[1].SetRowHidden(changeIdx, hide);
	}
}
/**
 * change values of BKG detail by Apply button
 */
function applyValues(){	
	var sheetObject2 = sheetObjects[1];
	var formObject = document.form;
	var rowCount = sheetObjects[1].RowCount();
	var mty_pkup_yd_cd = ComGetObjValue(formObject.mty_pkup_yd_cd_apply);
	var mty_pkup_dt = ComGetObjValue(formObject.mty_pkup_dt_apply);
	var full_rtn_yd_cd = ComGetObjValue(formObject.full_rtn_yd_cd_apply);
	var pol_yd_cd = ComGetObjValue(formObject.pol_yd_cd_apply);
	var pod_yd_cd = ComGetObjValue(formObject.pod_yd_cd_apply);
	for (row=1;row<=rowCount;row++){
		if((sheetObject2.GetRowHidden(row)==0)&&(sheetObject2.GetCellValue(row, prefix2+"chk")==1)){
			if(mty_pkup_yd_cd!=""){
				sheetObject2.SetCellValue(row, prefix2+"mty_pkup_yd_cd", mty_pkup_yd_cd);
			}
			if(mty_pkup_dt!=""){
				sheetObject2.SetCellValue(row, prefix2+"mty_pkup_dt", mty_pkup_dt);
			}
			if(full_rtn_yd_cd!=""){
				sheetObject2.SetCellValue(row, prefix2+"full_rtn_yd_cd", full_rtn_yd_cd);
			}
			//change POL and POD
			if((pol_yd_cd!="")||(pod_yd_cd!="")){
				if(ComGetObjValue(formObject.base_vvd)!=""){ //change POL and POD of searched VVD
					for(vvdNo=1;vvdNo<=4;vvdNo++){
						if(sheetObject2.GetCellValue(row, prefix2+"vvd"+String(vvdNo))==ComGetObjValue(formObject.base_vvd)){
							if(pol_yd_cd!=""){
								sheetObject2.SetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo), pol_yd_cd);
								if((vvdNo>1)&&(formObject.with_relay.checked)){ //if with Relay Terminal is checked, POD of next VVD is updated.
									sheetObject2.SetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo-1), pol_yd_cd);
								}
							}
							if(pod_yd_cd!=""){
								sheetObject2.SetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo), pod_yd_cd);
								if((vvdNo<4)&&(formObject.with_relay.checked)&&(sheetObject2.GetCellValue(row, prefix2+"vvd"+String(vvdNo+1))!="")){//if with Relay Terminal is checked, POL of previous VVD is updated.
									sheetObject2.SetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo+1), pod_yd_cd);
								}
							}
							break;
						}
					}					
				}else{ // change 1st POL and last POD(in case of Booking No search)
					if(pol_yd_cd!=""){
						sheetObject2.SetCellValue(row, prefix2+"pol_yd_cd1", pol_yd_cd);
					}
					if(pod_yd_cd!=""){
						for(vvdNo=4;vvdNo>=1;vvdNo--){
							if(sheetObject2.GetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo))!=""){
								sheetObject2.SetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo), pod_yd_cd);
								break;
							}
						}
					}
				}
			}
		}
	}
}
/**
 * make the searched VVD blue
 */
function setVvdColor(){
	var rowCount = sheetObjects[1].RowCount();
	var changeIdx = "";
	for (i=1;i<=rowCount;i++){
		for (vvdNo=1;vvdNo<=4;vvdNo++){
			if(sheetObjects[1].GetCellValue(i, prefix2+"vvd"+String(vvdNo))==ComGetObjValue(document.form.base_vvd)){
				sheetObjects[1].SetCellFontColor(i, prefix2+"vvd"+String(vvdNo), "#0000FF");
				break;
			}
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    switch (sAction){
    	case SEARCH: // Retrieve
    		if((ComIsEmpty(formObj.vvd))&&(ComIsEmpty(formObj.bkg_no))&&(ComIsEmpty($("#mult_bkg_no").val()))){
				ComShowCodeMessage("BKG95025", "VVD or Booking No");
    			return false;
    		}
    		if((!ComIsEmpty(formObj.vvd))&&(ComIsEmpty(formObj.pod))&&(ComIsEmpty(formObj.pol))){
				ComShowCodeMessage("BKG95025", "Loading Port or Discharging Port");
    			return false;
    		}
    		if($("#mult_bkg_no").val().indexOf("'")!=-1){
    			ComShowCodeMessage('BKG00445',"only alphanumeric characters in Booking No");
    			return false;
    		}
//    		if(duplicateBkgNoCheck()) return false;
    		
    		
			if($('#rows').css("color").indexOf('255') > 0){
				ComShowMessage('You can input Booking No up to 100 Maximum. Please kindly check Booking No again.');
				$("#layList").show();
				return false;
			}
			/* 멀티 부킹 중복 체크 */
			duplicateBkgNoCheck('mult_bkg_no');
			return true;
    		break;
//    	case COMMAND02: // Route Edit
//    		if(!checkSelectSheet2()) return false;
//        	var arrSheet2 = sheetObj.FindCheckedRow(prefix2 + "chk").split("|");
//        	for(q=1;q<arrSheet2.length;q++){
//        		if(sheetObj.GetCellValue(arrSheet2[q], prefix2+"vvd_key")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"vvd_key")){
//        			ComShowCodeMessage("BKG95031", "Bookings of the same route");
//        			return false;
//        		}
//        	}
//    		break;
        case COMMAND03: // Save
        	if(!checkSelectSheet2()) return false;
        	var arrSheet2 = findCheckedVisibleRow(sheetObj, prefix2 + "chk").split("|");
        	var arrVvd = ["A","1st","2nd","3rd","4th"]; //String array for error message
        	var row = 0;
        	for(q=0;q<arrSheet2.length;q++){

        		row = arrSheet2[q];
        		if((sheetObj.GetCellValue(row, prefix2+"por_nod_cd")).length<5){
					sheetObj.SelectCell(row, prefix2+"por_nod_cd", 1);
					ComShowCodeMessage("COM12193", " POR [Seq = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
					return false;
        		}
        		if((sheetObj.GetCellValue(row, prefix2+"del_nod_cd")).length<5){
					sheetObj.SelectCell(row, prefix2+"del_nod_cd", 1);
					ComShowCodeMessage("COM12193", " DEL [Seq = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
					return false;
        		}
        		
        		for(vvdNo=1;vvdNo<=4;vvdNo++){
        			//if a part of VVD is input or it's 1st VVD
        			if((vvdNo==1)
        			||(sheetObj.GetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo))
        			  +sheetObj.GetCellValue(row, prefix2+"vvd"+String(vvdNo))
        			  +sheetObj.GetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo)) !="")){
        				//check the set of POL,VVD,POD and length
        				//POL
        				if(sheetObj.GetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo))==""){
        					sheetObj.SelectCell(row, prefix2+"pol_yd_cd"+String(vvdNo), 1);
        					ComShowCodeMessage("COM12193", arrVvd[vvdNo]+" POL [Seq = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
        					return false;
        				}else if(sheetObj.GetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo)).length<5){
        					sheetObj.SelectCell(row, prefix2+"pol_yd_cd"+String(vvdNo), 1);
        					ComShowCodeMessage("COM12193", "correct code in "+arrVvd[vvdNo]+" POL [Seq = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
        					return false;
        				}
        				//VVD(null is allowed if it's feeder)
        				if((sheetObj.GetCellValue(row, prefix2+"vvd"+String(vvdNo))!="")&&(sheetObj.GetCellValue(row, prefix2+"vvd"+String(vvdNo)).length<9)){
        					sheetObj.SelectCell(row, prefix2+"vvd"+String(vvdNo), 1);
        					ComShowCodeMessage("COM12193", "correct code in "+arrVvd[vvdNo]+" VVD [Seq = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
        					return false;
        				}
        				//POD
        				if(sheetObj.GetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo))==""){
        					sheetObj.SelectCell(row, prefix2+"pod_yd_cd"+String(vvdNo), 1);
        					ComShowCodeMessage("COM12193", arrVvd[vvdNo]+" POD [Seq = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
        					return false;       					
        				}else if(sheetObj.GetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo)).length<5){
        					sheetObj.SelectCell(row, prefix2+"pod_yd_cd"+String(vvdNo), 1);
        					ComShowCodeMessage("COM12193", "correct code in "+arrVvd[vvdNo]+" POD [Seq = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
        					return false;
        				}

        				//check previous VVD
        				if(vvdNo>=2){
	        				if(sheetObj.GetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo-1))==""){
	        					sheetObj.SelectCell(row, prefix2+"pol_yd_cd"+String(vvdNo-1));
	        					ComShowCodeMessage("COM12193", arrVvd[vvdNo-1]+" VVD information [SEQ = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
	        					return false;
	        				}
        				}
        			}
        		}
        		//At least, 1 VVD is needed.
        		if((sheetObj.GetCellValue(row, prefix2+"vvd1")=="")
        		 &&(sheetObj.GetCellValue(row, prefix2+"vvd2")=="")
        		 &&(sheetObj.GetCellValue(row, prefix2+"vvd3")=="")
        		 &&(sheetObj.GetCellValue(row, prefix2+"vvd4")=="")
        		){
        			sheetObj.SelectCell(row, prefix2+"vvd1");
        			ComShowCodeMessage("COM12193", "at least 1 VVD [SEQ = "+sheetObj.GetCellValue(row, prefix2+"seq")+"]");
        			return false;
        		}
        	}
            break;
    	case COMMAND04: // Route Edit
    		if(!checkSelectSheet2()) return false;
    		//clear parameter object value
    		ComSetObjValue(document.form.bkg_por_cd, "");
    		ComSetObjValue(document.form.bkg_pol_cd, "");
    		ComSetObjValue(document.form.bkg_pod_cd, "");
    		ComSetObjValue(document.form.bkg_del_cd, "");
    		ComSetObjValue(document.form.bkg_por_yd_cd, "");
    		ComSetObjValue(document.form.bkg_pol_yd_cd, "");
    		ComSetObjValue(document.form.bkg_pod_yd_cd, "");
    		ComSetObjValue(document.form.bkg_del_yd_cd, "");
    		ComSetObjValue(document.form.org_trns_mod_cd, "");
    		ComSetObjValue(document.form.dest_trns_mod_cd, "");
    		ComSetObjValue(document.form.same_por_del, "Y");

    		//check whether selected BKG have the same route (VVD)
        	var arrSheet2 = findCheckedVisibleRow(sheetObj, prefix2 + "chk").split("|");
        	for(q=1;q<arrSheet2.length;q++){
        		if(
        			  (sheetObj.GetCellValue(arrSheet2[q], prefix2+"pol_yd_cd1")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pol_yd_cd1"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"vvd1")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"vvd1"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"pod_yd_cd1")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pod_yd_cd1"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"pol_yd_cd2")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pol_yd_cd2"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"vvd2")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"vvd2"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"pod_yd_cd2")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pod_yd_cd2"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"pol_yd_cd3")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pol_yd_cd3"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"vvd3")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"vvd3"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"pod_yd_cd3")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pod_yd_cd3"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"pol_yd_cd4")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pol_yd_cd4"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"vvd4")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"vvd4"))
        			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"pod_yd_cd4")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"pod_yd_cd4"))
        		){
        			ComShowCodeMessage("BKG95031", "Bookings of the same route");
        			return false;
        		}
        		
        		if(
          			  (sheetObj.GetCellValue(arrSheet2[q], prefix2+"por_nod_cd")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"por_nod_cd"))
          			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"del_nod_cd")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"del_nod_cd"))
          			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"org_trns_mod_cd")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"org_trns_mod_cd"))
          			||(sheetObj.GetCellValue(arrSheet2[q], prefix2+"dest_trns_mod_cd")!=sheetObj.GetCellValue(arrSheet2[q-1], prefix2+"dest_trns_mod_cd"))
          		){

            		ComSetObjValue(document.form.same_por_del, "N");
          		}
        		
        	}
    		break;
    }
    return true;
}
/**
 * check whether booking is selected&visible or not
 */
function checkSelectSheet2(){
	var rowCount = sheetObjects[1].RowCount();
	
	for(var i=1;i<=rowCount;i++){
		if((sheetObjects[1].GetCellValue(i, prefix2 + "chk")==1)&&(sheetObjects[1].GetRowHidden(i)==0)){
			return true;
		}
	}	
	ComShowCodeMessage("BKG95031", "target Bookings");
	return false;
}

/**
 * open Route Detail(ESM_BKG_0092)
 */
function showRouteDetail(){
	//copy selected data of sheetObjects[1] to sheetObjects[4]
	var row = findCheckedVisibleRow(sheetObjects[1], prefix2 + "chk").split("|")[0];
	
	sheetObjects[4].RemoveAll();
	for(var vvdNo=1;vvdNo<=4;vvdNo++){
		if((sheetObjects[1].GetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo))!="")
			||(sheetObjects[1].GetCellValue(row, prefix2+"vvd"+String(vvdNo))!="")
			||(sheetObjects[1].GetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo))!="")   ){
			
			var newRow=sheetObjects[4].DataInsert(-1);
			sheetObjects[4].SetCellValue(newRow, "pol_cd", sheetObjects[1].GetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo)).substring(0,5), 0);
			sheetObjects[4].SetCellValue(newRow, "pol_yd_cd", sheetObjects[1].GetCellValue(row, prefix2+"pol_yd_cd"+String(vvdNo)).substring(5,7), 0);
			sheetObjects[4].SetCellValue(newRow, "pod_cd", sheetObjects[1].GetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo)).substring(0,5), 0);
			sheetObjects[4].SetCellValue(newRow, "pod_yd_cd", sheetObjects[1].GetCellValue(row, prefix2+"pod_yd_cd"+String(vvdNo)).substring(5,7), 0);
			sheetObjects[4].SetCellValue(newRow, "bkg_vvd_cd", sheetObjects[1].GetCellValue(row, prefix2+"vvd"+String(vvdNo)), 0);
			sheetObjects[4].SetCellValue(newRow, "pol_clpt_ind_seq", sheetObjects[1].GetCellValue(row, prefix2+"pol_clpt_ind_seq"+String(vvdNo)), 0);
			sheetObjects[4].SetCellValue(newRow, "pod_clpt_ind_seq", sheetObjects[1].GetCellValue(row, prefix2+"pod_clpt_ind_seq"+String(vvdNo)), 0);
			
		}
	}
	
	//Copy data to form objects to show POR ~ DEL
	ComSetObjValue(document.form.bkg_pol_cd, sheetObjects[1].GetCellValue(row, prefix2+"pol_nod_cd").substring(0,5));
	ComSetObjValue(document.form.bkg_pod_cd, sheetObjects[1].GetCellValue(row, prefix2+"pod_nod_cd").substring(0,5));
	ComSetObjValue(document.form.bkg_pol_yd_cd, sheetObjects[1].GetCellValue(row, prefix2+"pol_nod_cd").substring(5,7));
	ComSetObjValue(document.form.bkg_pod_yd_cd, sheetObjects[1].GetCellValue(row, prefix2+"pod_nod_cd").substring(5,7));
	if(ComGetObjValue(document.form.same_por_del)=="Y"){
		ComSetObjValue(document.form.bkg_por_cd, sheetObjects[1].GetCellValue(row, prefix2+"por_nod_cd").substring(0,5));
		ComSetObjValue(document.form.bkg_del_cd, sheetObjects[1].GetCellValue(row, prefix2+"del_nod_cd").substring(0,5));
		ComSetObjValue(document.form.bkg_por_yd_cd, sheetObjects[1].GetCellValue(row, prefix2+"por_nod_cd").substring(5,7));
		ComSetObjValue(document.form.bkg_del_yd_cd, sheetObjects[1].GetCellValue(row, prefix2+"del_nod_cd").substring(5,7));
		ComSetObjValue(document.form.org_trns_mod_cd, sheetObjects[1].GetCellValue(row, prefix2+"org_trns_mod_cd"));
		ComSetObjValue(document.form.dest_trns_mod_cd, sheetObjects[1].GetCellValue(row, prefix2+"dest_trns_mod_cd"));		
	}

	var param="?bkg_no=";
	param+="&bkgTrunkVvd=";
				param+="&ca_flg=";
				param+="&callSheetIdx=4";
				param+="&pgmNo=ESM_BKG_0092";
		
	ComOpenPopup("/opuscntr/ESM_BKG_0092.do"+param, 700, 510, 'callBack0092','1,0,1,1,1', true);	
}

function jqueryEvent(){
	$("#bkg_no").keyup(function(){
		if($(this).val() != ""){
			multiBkgTextArea(1, 'mult_bkg_no');
		}
	});
	$("#mult_bkg_no").keyup(function(){
		multiBkgTextArea(2, 'mult_bkg_no');
	});
	
	$("#mult_bkg_no").focusout(function(){
		$("#layList").hide();
	});
}

function setLabel(code){
	if(code==0){
		document.getElementById("lbl_pol").innerText = "1st POL";
		document.getElementById("lbl_pod").innerText = "Last POD";
	}else if(code==1){
		document.getElementById("lbl_pol").innerText = "POL";
		document.getElementById("lbl_pod").innerText = "POD";
	}
}

function clearBaseVvd(){
	ComClearObject(document.form.base_vvd);
	setLabel(0);
}

/**
 * return indexes(1|2|4|...) of checked and visible rows
 */
function findCheckedVisibleRow(sheetObj, col){

	var arrCheckedRow = sheetObj.FindCheckedRow(col).split("|");
	var checkedRow="";
	for(i=0; i<arrCheckedRow.length;i++){
		if(sheetObj.GetRowHidden(arrCheckedRow[i])==0){
			if(checkedRow==""){
				checkedRow += arrCheckedRow[i];
			}else{
				checkedRow += "|" + arrCheckedRow[i];							
			}
		}
	}
	return checkedRow;
}

function getTvvd(row){
	var tvvd = "";
	//If route is same, use origin route vvd seq for TVVD
	if(
	     (sheetObjects[1].GetCellValue(row, prefix2+"pol_yd_cd1").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pol_yd_cd1").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"pod_yd_cd1").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pod_yd_cd1").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"pol_yd_cd2").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pol_yd_cd2").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"pod_yd_cd2").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pod_yd_cd2").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"pol_yd_cd3").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pol_yd_cd3").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"pod_yd_cd3").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pod_yd_cd3").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"pol_yd_cd4").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pol_yd_cd4").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"pod_yd_cd4").substring(0,5)==sheetObjects[1].CellSearchValue(row, prefix2+"pod_yd_cd4").substring(0,5))
	   &&(sheetObjects[1].GetCellValue(row, prefix2+"tvvd_seq")!="")
			){
		tvvd = sheetObjects[1].GetCellValue(row, prefix2+"vvd"+String(sheetObjects[1].GetCellValue(row, prefix2+"tvvd_seq")));
		
	}
	//If previous TVVD exists, set it TVVD again
	if(tvvd==""){
		for(var k=1;k<+4;k++){
			if(sheetObjects[1].GetCellValue(row, prefix2+"vvd"+String(k))==sheetObjects[1].GetCellValue(row, prefix2+"tvvd")){
				tvvd = sheetObjects[1].GetCellValue(row, prefix2+"tvvd");
			}
		}
	}
	
	return tvvd;
}

