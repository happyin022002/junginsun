/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1085.js
*@FileTitle  : ACI_Vessel Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
 [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
 character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var tab2SearchFlag=false;
var tab3SearchFlag=false;
var sheetObjects=new Array();
var sheetCnt=0;
var aryPrefix=new Array("s1_", "s2_"); //prefix array of strings
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObject, SEARCH, 1);
			break;
		case "btn_New":
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObject.reset();
			formObject.vvd.focus();
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObject, MULTI);
			break;
		case "btn_Edi":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btn_Excel":
			if (sheetObjects[0].RowCount()> 0){
				sheetObjects[0].SetHeaderBackColor("#CCCCCC");
				sheetObjects[0].Down2Excel({ SheetDesign:1,DownCols:makeHiddenSkipCol(sheetObjects[0])});
				sheetObjects[0].SetHeaderBackColor("#333333");
			}

			break;

		case "btn_bl1":
			var bl_no="";
			var pod_cd="";
			with (sheetObjects[tabObjects[0].GetSelectedIndex()]) {
				bl_no=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "bl_no");
				pod_cd=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "pod_cd");
			}
			openBL(bl_no, pod_cd, 0);
			break;

		case "btn_cust1":
			var bl_no="";
			var pod_cd="";
			with (sheetObjects[tabObjects[0].GetSelectedIndex()]) {
				bl_no=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "bl_no");
				pod_cd=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "pod_cd");
			}
			openBL(bl_no, pod_cd, 1);
			break;

		case "btn_Unit1":
			ComOpenWindowCenter("/opuscntr/ESM_BKG_1086.do?pgmNo=ESM_BKG_1086", "1086", 700, 450, true);
			break;

		case "btn_bl2":
			var bl_no="";
			var pod_cd="";
			with (sheetObjects[tabObjects[0].GetSelectedIndex()]) {
				bl_no=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "bl_no");
				pod_cd=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "pod_cd");
			}
			openBL(bl_no, pod_cd, 0);
			break;

		case "btn_cust2":
			var bl_no="";
			var pod_cd="";
			with (sheetObjects[tabObjects[0].GetSelectedIndex()]) {
				bl_no=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "bl_no");
				pod_cd=GetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "pod_cd");
			}
			openBL(bl_no, pod_cd, 1);
			break;

		case "btn_Unit2":
			ComOpenWindowCenter("/opuscntr/ESM_BKG_1086.do?pgmNo=ESM_BKG_1086", "1086", 700, 450, true);
			break;
		case "btn_calendar":
			var cal=new ComCalendar();
			cal.select(formObject.eta_dt, 'yyyy-MM-dd');
			break;
		case "data_type":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComFuncErrMsg(e);
		} else {
			ComFuncErrMsg(e);
		}
	}
}

function sheet1_OnDownFinish(downloadType, result) {
	if(sheet2.RowCount() > 0 ){
		sheet2.SetHeaderBackColor("#CCCCCC");
		sheet2.Down2Excel({ SheetDesign:1,DownCols:makeHiddenSkipCol(sheet2)});
		sheet2.SetHeaderBackColor("#333333");
	}
}


/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}

	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	doActionIBSheet(sheetObjects[0], document.form, INIT, 1);
	ComBtnDisable('btn_bl1');
	ComBtnDisable('btn_cust1');
	ComBtnDisable('btn_bl2');
	ComBtnDisable('btn_cust2');
	document.form.vvd.focus();
}
 /**
  * setting sheet initial values and header
  * @param sheetObj
  * @param sheetNo
  * @return
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1":
		with(sheetObj){
			  var HeadTitle1="|Sel.|Rotation No.|B/L No.|Line\nCode|Agent\nCode|POR|POL|POD|DEL|Trade\nCode|Cargo\nCode|Console\nIND|Origin\nCountry|CNEE\nName|CNEE\nAddress|COMM\nCode|PKG\nQTY|PKG\nTP|PKG\nTP|Cargo\nWeight|Gross\nWeight";
			  var headCount=ComCountHeadTitle(HeadTitle1) + 11;
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:aryPrefix[0]+"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_rotn_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_line_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_voy_agn_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:aryPrefix[0]+"du_trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:aryPrefix[0]+"du_cgo_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"cnsl_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"org_cnt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:aryPrefix[0]+"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:aryPrefix[0]+"cust_addr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_cmdt_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[0]+"pck_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_pck_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"PopupEdit",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_pck_tp_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[0]+"cgo_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[0]+"grs_wgt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"eta_dt" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"vsl_nm" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"vsl_cd" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"skd_voy_no" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"skd_dir_cd" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"clpt_seq" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"v_du_rotn_no" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_instl_no" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"bkg_no" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"bkg_cust_tp_cd" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[0]+"du_mrn_no" } ];
				InitColumns(cols);
				SetEditable(1);
				SetImageList(0,"img/btns_search.gif");
				SetColProperty(aryPrefix[0]+"cnsl_cgo_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetSheetHeight(430);
				SetColProperty(0 ,"du_line_id" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				SetColProperty(0 ,"du_voy_agn_id" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				SetColProperty(0 ,"org_cnt_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"du_pck_tp_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
				SetColProperty(0 ,"du_cmdt_cd" , {AcceptKeys:"N"});
			  }
		break;

	case "sheet2":
		with(sheetObj){
			  var HeadTitle1="|Seq.|B/L No.|POD|CNTR No.|Tare\nWGT|Seal|Serial\nNo.|Marks &\nNumber|Cargo Description|CMDT\nCode|PKG|PKG\nTP|PKG\nTP|No of\nPallets|Weight|Measure|DG|IMO\nClass|UN\nNumber|Flash\nPoint|Temp.\nUnit|Strorage\nReq.|Rf\nReq.|Min\nTemp|Max\nTemp|Temp.\nUnit";
			  var headCount=ComCountHeadTitle(HeadTitle1) + 2;
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:aryPrefix[1]+"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[1]+"cntr_tare_wgt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"cntr_seal_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"du_cntr_ser_no",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:aryPrefix[1]+"cntr_mf_mk_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
					 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:aryPrefix[1]+"cntr_mf_gds_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:400 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"cmdt_hs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[1]+"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"du_pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"PopupEdit",      Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"du_pck_tp_cd2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[1]+"plt_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[1]+"cntr_mf_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:aryPrefix[1]+"meas_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"dcgo_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"imdg_clss_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"imdg_un_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"flsh_pnt_cdo_temp", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"dcgo_temp_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"dg_sto_req_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"rfrt_req_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"min_temp",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"max_temp",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"cgo_temp_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"cntr_mf_seq" },
					 {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:aryPrefix[1]+"bkg_no" } ];
				InitColumns(cols);
				SetEditable(1);
				SetImageList(0,"img/btns_search.gif");
				SetColProperty(aryPrefix[1]+"dcgo_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetColProperty(aryPrefix[1]+"dg_sto_req_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetColProperty(aryPrefix[1]+"rfrt_req_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
				SetSheetHeight(430);
				SetColProperty(0 ,"cntr_seal_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				SetColProperty(0 ,"cmdt_hs_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
				SetColProperty(0 ,"du_pck_tp_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
			  }
		break;

	case "sheet3":
		with(sheetObj){
			  var HeadTitle="flatFile";
			  var headCount=ComCountHeadTitle(HeadTitle);
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers = [ { Text:HeadTitle, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"flat_file" } ];
			  InitColumns(cols);
			  SetEditable(1);
			  SetVisible(0);
			}
		break;
	}
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param tab_obj
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * Tab option
 * setting tab list
 * @param tabObj
 * @param tabNo
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "B/L List", "");
			InsertItem( "Container List", "");
//			InsertTab(cnt++, "Vessel", -1);
		}
		break;
	}
}
/**
 * event in case of clicking tab
 * activating selected tab
 * @param tabObj
 * @param nItem
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	// --------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
	// ------------------------------------------------------//
	beforetab=nItem;
}
/**
 * handling sheet process
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param tabno
 */
function doActionIBSheet(sheetObj, formObj, sAction, tabno) {
	sheetObj.ShowDebugMsg(false);
	formObj.f_cmd.value=sAction;
	switch (sAction) {
	case INIT:
		var sXml=sheetObj.GetSearchData("ESM_BKG_1085GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		// DUBAI TRADE CODE
		var arrCombo1=ComXml2ComboString(arrXml[0], "name", "val") ;
		arrCombo1[0]=" |" + arrCombo1[0];
		arrCombo1[1]=" |"  + arrCombo1[1];
		sheetObjects[0].SetColProperty(aryPrefix[0]+"du_trd_cd", {ComboText:arrCombo1[0], ComboCode:arrCombo1[1]} );
		// DUBAI CARGO CODE
		var arrCombo2=ComXml2ComboString(arrXml[1], "desc", "val");
		arrCombo2[0]=" |" + arrCombo2[0];
		arrCombo2[1]=" |"  + arrCombo2[1];
		sheetObjects[0].SetColProperty(aryPrefix[0]+"du_cgo_cd", {ComboText:arrCombo2[0], ComboCode:arrCombo2[1]} );
		// DUBAI PACKAGE TYPE CODE
//		var arrCombo3 = ComXml2ComboString(arrXml[2], "name", "val");
//		arrCombo3[0] = " |" + arrCombo3[0];
//		arrCombo3[1] = " |"  + arrCombo3[1];
//		sheetObjects[0].InitDataCombo(0, aryPrefix[0] + "du_pck_tp_cd", arrCombo3[0], arrCombo3[1]);
//		sheetObjects[1].InitDataCombo(0, aryPrefix[1] + "du_pck_tp_cd", arrCombo3[0], arrCombo3[1]);
		// retrieve조건  DUBAI CARGO CODE
		ComXml2ComboItem(arrXml[1], cgo_code, "val", "val|desc");
		cgo_code.InsertItem(0, "|", "");
		break;
	case SEARCH: //Retrieve, Tab1
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.sheet_no.value=tabno;
			var sXml=sheetObj.GetSearchData("ESM_BKG_1085GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			if (sheetObjects[0].RowCount()> 0) {
			formObj.vvd_nm.value=sheetObjects[0].GetCellValue(1, aryPrefix[0] + "vsl_nm");
			formObj.eta_dt.value=sheetObjects[0].GetCellValue(1, aryPrefix[0] + "eta_dt");
			formObj.rotn_no.value=sheetObjects[0].GetCellValue(1, aryPrefix[0] + "v_du_rotn_no");
			formObj.instl_no.value=sheetObjects[0].GetCellValue(1, aryPrefix[0] + "du_instl_no");
			formObj.mrn_no.value=sheetObjects[0].GetCellValue(1, aryPrefix[0] + "du_mrn_no");
				//
				if (formObj.data_type[0].checked) {
					ComBtnDisable('btn_bl1');
					ComBtnDisable('btn_cust1');
					ComBtnDisable('btn_bl2');
					ComBtnDisable('btn_cust3');
					ComBtnDisable('btn_Edi');
				} else {
					ComBtnEnable('btn_bl1');
					ComBtnEnable('btn_cust1');
					ComBtnEnable('btn_bl2');
					ComBtnEnable('btn_cust2');
					ComBtnEnable('btn_Edi');
				}
			} else {
				if (formObj.data_type[1].checked) {
					if (ComShowCodeConfirm("BKG95003", "retrieve B/L data")) {
						formObj.data_type[0].checked=true;
						doActionIBSheet(sheetObj, formObj, COMMAND02, 1);
						doActionIBSheet(sheetObj, formObj, SEARCH, 1);
					}
				}
				ComBtnDisable('btn_bl1');
				ComBtnDisable('btn_cust1');
				ComBtnDisable('btn_bl2');
				ComBtnDisable('btn_cust2');
				ComBtnDisable('btn_Edi');
			}
			for(var i=1; i<sheetObjects[0].RowCount()+1 ;i++) {
				sheetObjects[0].SetCellImage(i,aryPrefix[0]+"du_pck_tp_cd2",0);
				sheetObjects[0].SetCellFont("FontUnderline", i, aryPrefix[0]+"bl_no",1);
			}
			for(var i=1; i<sheetObjects[1].RowCount()+1 ;i++) {
				sheetObjects[1].SetCellImage(i,aryPrefix[1]+"du_pck_tp_cd2",0);
				sheetObjects[1].SetCellFont("FontUnderline", i, aryPrefix[1]+"bl_no",1);
			}
			if (formObj.data_type[1].checked) {
				sheetObj.CheckAll(aryPrefix[0] + "chk",1);
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND02:
		if (formObj.data_type[0].checked) {
			$('.cgo1').show();
			$('.cgo2').hide();
		} else {
			$('.cgo2').show();
			$('.cgo1').hide();
		}
		break;
	case MULTI: //Save
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			var sParam="";
			if (formObj.data_type[0].checked) {
				formObj.f_cmd.value=MULTI01;
				sParam=FormQueryString(formObj)
				+ "&" + sheetObjects[0].GetSaveString(true)
				+ "&" + sheetObjects[1].GetSaveString()
				+ "&" + ComGetPrefixParam( aryPrefix );
				var sXml=sheetObj.GetSaveData("ESM_BKG_1085GS.do", sParam);
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSaveData(sXml);
					formObj.data_type[1].checked=true;
					doActionIBSheet(sheetObj, formObj, COMMAND02, 1);
					doActionIBSheet(sheetObj, formObj, SEARCH, 1);
					sheetObj.CheckAll(aryPrefix[0] + "chk",1);
				}
			} else {
				formObj.f_cmd.value=MULTI02;
				sParam=FormQueryString(formObj)
				+ "&" + sheetObjects[0].GetSaveString()
				+ "&" + sheetObjects[1].GetSaveString()
				+ "&" + ComGetPrefixParam( aryPrefix );
				var sXml=sheetObj.GetSaveData("ESM_BKG_1085GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
			}
			ComOpenWait(false);
		}
		break;
	case COMMAND01: // EDI File Download
		if(validateForm(sheetObj,formObj,sAction)) {
			var savedFileName="";
			if (formObj.bl_no.value != "") {
				savedFileName=formObj.bl_no.value;
			} else {
				savedFileName=formObj.vvd.value + "_"+ formObj.pod_cd.value;
			}

			formObj.f_cmd.value=COMMAND01;

			ComOpenWait(true);

			for(var i=1; i<=sheetObj.RowCount(); i++) {
				if(sheetObj.GetCellValue(i, "s1_chk") == 1) {
					sheetObj.SetRowStatus(i,"U");
				} else {
					sheetObj.SetRowStatus(i,"");
				}
			}

			var sParam=FormQueryString(formObj) + "&" + sheetObj.GetSaveString();
			sheetObjects[2].DoSearch("ESM_BKG_1085GS.do", sParam, {Sync:2}  );

			ComOpenWait(false);

			sheetObjects[2].Down2Text({ ColDelim:"", FileName:savedFileName, DownHeader:false});


		}
		break;
	}
}
/**
 * handling process for input validation
 * @param sheetObj
 * @param formObj
 * @param sAction
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case SEARCH: //Retrieve, Tab1
		if (!ComChkValid(formObj))
			return false;
		if (ComIsNull(formObj.bl_no) && (ComIsNull(formObj.vvd) || ComIsNull(formObj.pod_cd)) ) {
			ComShowCodeMessage('BKG00701','VVD & POD or B/L No.');
			formObj.vvd.focus();
			return false;
		}
		break;
	case MULTI:
		for (var i=1; i<sheetObj.RowCount()+ 1; i++) {
			if (sheetObj.GetCellValue(i, aryPrefix[0] + "cust_nm").length > 48)
			{
				ComShowCodeMessage('BKG00107', 'CNEE Name [maximum:48]');
				sheetObj.SelectCell(i, aryPrefix[0] + "cust_nm");
				return false;
			}
			if (sheetObj.GetCellValue(i, aryPrefix[0] + "cust_addr").length > 240)
			{
				ComShowCodeMessage('BKG00107', 'CNEE Address [maximum:240]');
				sheetObj.SelectCell(i, aryPrefix[0] + "cust_addr");
				return false;
			}
		}
		if (formObj.data_type[1].checked) {
			sheetObjects[0].SetCellValue(1, aryPrefix[0] + "eta_dt",formObj.eta_dt.value,0);
			sheetObjects[0].SetCellValue(1, aryPrefix[0] + "du_rotn_no",formObj.rotn_no.value,0);
			sheetObjects[0].SetCellValue(1, aryPrefix[0] + "du_instl_no",formObj.instl_no.value,0);
			sheetObjects[0].SetCellValue(1, aryPrefix[0] + "du_mrn_no",formObj.mrn_no.value,0);
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage('BKG00743');
				return false;
			}
		}
		if (!ComShowCodeConfirm("BKG00824")) {
			return false;
		}
		break;
	case COMMAND01:
		if (sheetObjects[0].CheckedRows(aryPrefix[0] + "chk") == 0) {
			ComShowCodeMessage('BKG00333');
			return false;
		}
		if (!ComShowCodeConfirm("BKG00447")) {
			return false;
		}
		break;
	}
	return true;
}
/**
 * occurring event in case of clicking cell
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 * @return
 */
function sheet1_OnClick(sheetObj, row, col, value) {
	switch (sheetObj.ColSaveName(col)) {
	case aryPrefix[0] + "cust_addr":
		sheetObj.SetCellEditable(row, col,0);
		ComShowMemoPad(sheetObj, row, col, false, 250, 100);
		sheetObj.SetCellEditable(row, col,1);
		break;
	case aryPrefix[0] + "du_pck_tp_cd2":
		var du_pck_tp_cd=ComOpenWindowCenter("ESM_BKG_1086.do?select=true", "1086" , 700, 450, true);
//		if (du_pck_tp_cd == undefined || du_pck_tp_cd == null) break;
//		sheetObj.SetCellValue(row, aryPrefix[0] + "du_pck_tp_cd",du_pck_tp_cd,0);
//		break;
	}
}

function callback1086(rtnValue){

	with (sheetObjects[tabObjects[0].GetSelectedIndex()]) {
		sheetObjects[tabObjects[0].GetSelectedIndex()].SetCellValue(GetSelectRow(), aryPrefix[tabObjects[0].GetSelectedIndex()] + "du_pck_tp_cd", rtnValue, 0);
	}
}


/**
 * occurring event in case of clicking cell
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 * @return
 */
function sheet2_OnClick(sheetObj, row, col, value) {
	switch (sheetObj.ColSaveName(col)) {
	case aryPrefix[1] + "du_pck_tp_cd2":
		var du_pck_tp_cd=ComOpenWindowCenter("ESM_BKG_1086.do?select=true", "1086" , 700, 450, true);
//		if (du_pck_tp_cd == undefined || du_pck_tp_cd == null) break;
//		sheetObj.SetCellValue(row, aryPrefix[1] + "du_pck_tp_cd",du_pck_tp_cd,0);
//		break;
	case aryPrefix[1] + "cntr_mf_mk_desc":
		sheetObj.SetCellEditable(row, col,0);
		ComShowMemoPad(sheetObj, row, col, false, 300, 100);
		sheetObj.SetCellEditable(row, col,1);
		break;
	case aryPrefix[1] + "cntr_mf_gds_desc":
		sheetObj.SetCellEditable(row, col,0);
		ComShowMemoPad(sheetObj, row, col, false, 350, 100);
		sheetObj.SetCellEditable(row, col,1);
		break;
	}
}
/**
 * in case of mouse over
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if (sheetObj.ColSaveName(sheetObj.MouseCol()) == aryPrefix[0] + "bl_no") {
		sheetObj.SetMousePointer("Hand");
	} else {
		sheetObj.SetMousePointer("Default");
	}
}
/**
 * in case of mouse over
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y) {
	if (sheetObj.ColSaveName(sheetObj.MouseCol()) == aryPrefix[1] + "cntr_no") {
		sheetObj.SetMousePointer("Hand");
	} else {
		sheetObj.SetMousePointer("Default");
	}
}
/**
 * event in case of changing sheet1
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	if (Value != "" && sheetObj.ColSaveName(Col) == aryPrefix[0] + "du_pck_tp_cd") {
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_1085GS.do"
				+ "?attr_ctnt1=" + sheetObj.GetCellValue(Row, aryPrefix[0] + "du_pck_tp_cd")
				+ "&f_cmd=" + SEARCH02);
		if (ComGetEtcData(sXml, "du_pck_tp_cd") == "")
		{
			ComShowCodeMessage('BKG00530');
			sheetObj.SetCellValue(Row, aryPrefix[0] + "du_pck_tp_cd","",0);
			sheetObj.SelectCell(Row, aryPrefix[0] + "du_pck_tp_cd");
			return;
		}
	}
}
 /**
  * event in case of changing sheet2
  * @param sheetObj
  * @param Row
  * @param Col
  * @param Value
  */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	if (Value != "" && sheetObj.ColSaveName(Col) == aryPrefix[1] + "du_pck_tp_cd") {
		var sXml=sheetObjects[1].GetSearchData("ESM_BKG_1085GS.do"
				+ "?cstms_pck_tp_cd=" + sheetObj.GetCellValue(Row, aryPrefix[1] + "du_pck_tp_cd")
				+ "&f_cmd=" + SEARCH02);
		if (ComGetEtcData(sXml, "du_pck_tp_cd") == "")
		{
			ComShowCodeMessage('BKG00530');
			sheetObj.SetCellValue(Row, aryPrefix[1] + "du_pck_tp_cd","",0);
			sheetObj.SelectCell(Row, aryPrefix[1] + "du_pck_tp_cd");
			return;
		}
	}
}
/**
 * B/L Detail Open
 * @param bl_no
 * @param tabIndex
 * @return
 */
function openBL(bl_no, pod_cd, tabIndex) {
	ComOpenWindowCenter("/opuscntr/ESM_BKG_1087.do?pgmNo=ESM_BKG_1087"
			+"&bl_no="+bl_no
			+"&pod_cd="+pod_cd
			+"&tabIndex=" + tabIndex, "1087", 1100, 680, true);
}
/**
 * automatically moving next list, automatically retrieve in case of typing enter key
 */
/**
 * in case of double click
 * @param sheetObj
 * @param row
 * @param col
 * @return
  */
function sheet1_OnDblClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == aryPrefix[0] + "bl_no") {
		var sParam="pgmNo=ESM_BKG_0079_POP&openTab=B9&bkg_no=" + sheetObj.GetCellValue(row, aryPrefix[0] + "bkg_no");
		ComOpenWindowCenter("ESM_BKG_0079_POP.do?" + sParam, "ESM_BKG_0079", 1324, 650,true);
	}
}
/**
* in case of double click
* @param sheetObj
* @param row
* @param col
* @return
 */
function sheet2_OnDblClick(sheetObj, row, col) {
	if (sheetObj.ColSaveName(col) == aryPrefix[1] + "bl_no") {
	var sParam="&bkg_no=" + sheetObj.GetCellValue(row, aryPrefix[1] + "bkg_no");
	comBkgCallPopBkgDetail(sheetObj.GetCellValue(row, aryPrefix[1] + "bkg_no"));
	}
}
