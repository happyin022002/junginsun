/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0203.js
*@FileTitle  : Creating USA Rail Billing S/O
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0; 
var docObjsep="";
var isOverplan="N";
var R=222;
var G=251;
var B=248;
document.onclick=processButtonClick;
/**
 * Register IBSheet Object with array call from comSheetObject(id)
 * 
 * 
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Setting sheets and initialization Implementing the onLoad event handler of
 * body tag Adding the preceding function after loading page
 */
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1: 
		    with(sheetObj){
				var HeadTitle1="|STS|Requested Date|Reference No|CNTR\nTP/SZ|Quantity|Quantity|Quantity|Quantity|Rail ORG|Rail DEST" ;
				var HeadTitle2="|STS|Requested Date|Reference No|CNTR\nTP/SZ|Allocated|Rail Billed|EDI Sent|Remaining|Rail ORG|Rail DEST" ;

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},  { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ 
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
				             {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"requested_date",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ref_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"allocated",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cret_qty",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"edi_qty",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"remaining_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"curr_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
				          ];
		       
				InitColumns(cols);
				SetEditable(1);
		        SetSheetHeight(170);
	      	}
		    break;
		case 2:
		    with(sheetObj){
				var HeadTitle1="|STS|Reference No|Purpose|CNTR No|CNTR\nTP/SZ|Rail ORG|Rail ORG|Rail DEST|Rail DEST|Agreement\nReference No|Route\nPlan|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Verify Result|Internal Remark|Remark\n(Special Instruction)";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
				             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"ref_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"repo_purp_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ref_no",           		KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_pln_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"lessor",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ownr_co_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_used",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"movement_sts",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"creation_yard",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"event_date",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"spcl_instr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"rail_cmb_thru_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mty_rqst_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"trsp_mty_cost_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"repo_pln_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:"ref_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_org_nod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dest_nod_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"inlnd_rout_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rout_dtl_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"so_cre_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cgo_tp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
				InitColumns(cols);
				SetEditable(1);
				resizeSheet(sheetObj)
			}
		    break;
		case 3:
		    with(sheetObj){
	        	var HeadTitle1="SEP|EQ_NO|VERIFY_RESULT|VERIFY_YN" ;
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );
	        	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);
	        	var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sep",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:600,  Align:"Center",  ColMerge:1,   SaveName:"verify_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"verify_yn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lessor",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ownr_co_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_used",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"movement_sts",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"creation_yard",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"event_date",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	        	InitColumns(cols);	
	        	SetEditable(1);
	        	SetVisible(0);
			}
		    break;
	}
}
function processButtonClick() {
	/**
	 * *** Adding additional sheet variables to use more than one sheet per a
	 * tab ****
	 */
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve": {
				if( validateFormSearch(formObject) ) {
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
				}
				break;
			}
			case "btn_reset": {
				formObject.reset();
				frm_yard.RemoveAll();
				to_yard.RemoveAll();
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				break;
			}
			case "btn_minimize": {
				Mincount=(Mincount+1)%2;
				Minimize(Mincount);
				break;
			}
			case "btng_apply": {// apply
				if( searchValidation(sheetObject, formObject) ) {
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "DW", "");
				}
				break;
			}
			case "btng_fillincontainers": {
				if( contatnerValidation(sheetObject1, formObject) ) {
					popEqFileImport(sheetObject1, formObject);
				}
				break;
			}
			case "btng_verify": {
				if( searchVerify(sheetObject1, formObject, "chk1") ) {
					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "VY", "");
				}
				break;
			}
			case "btng_irgadjust": {
				doActionPopupOpen(sheetObject1, formObject);
				break;
			}
			case "btng_socreation": {
				if( validateForm(sheetObject1, formObject) ) {
					doActionIBSheet(sheetObject1, formObject, IBINSERT, "", "");
				}
				break;
			}
			case "btns_frmnode": // FromNode Popup
				openHireYardPopup('getFromNode');
			break;
			case "btns_tonode": // ToNode Popup
				openHireYardPopup('getToNode');
			break;
			case "btns_multirefer": {
				// M Reference No
				openMultipleinquiry('REF', 'Reference No');
				break;
			}
			case "btns_multicntr": {
				// M CNTR
				openMultipleinquiry('CNT', 'CNTR No');
				break;
			}
			case "btns_calendar":{
				getCalendar();
				break;
			}
			case "btns_tvvd": {
				// Trunk VVD Popup
				openTVVDPopup();
				break;
			}
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
function doActionIBSheet(sheetObj, formObj, sAction, obj, irow) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH: {	  // Retrieve
			if( obj == "DW" ) {
				formObj.f_cmd.value=SEARCH09;
				IBS_DoSearchSax(sheetObj, "ESD_TRS_02031GS.do", TrsFrmQryString(formObj));
			} else if( obj == "VY" ) { // Verify
				formObj.f_cmd.value=SEARCH11;
				sheetObj.DoSearch("ESD_TRS_0203GS.do", TrsFrmQryString(formObj));
			} else if( obj == "EQ" ) { // Verify
				formObj.f_cmd.value=SEARCH14;
				sheetObj.DoSearch("ESD_TRS_0203GS.do", TrsFrmQryString(formObj));
			} else {
				formObj.f_cmd.value=SEARCH08;
				IBS_DoSearchSax(sheetObj, "ESD_TRS_0203GS.do", TrsFrmQryString(formObj));
			}
			break;
		}
		case IBINSERT: {	  // Insert
			formObj.f_cmd.value=MULTI02;
			sheetObj.DoSave("ESD_TRS_0203GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			break;
		}
	}
}
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "","");
		}
	}
}
/**
 * Validating inputted values of form
 */
function searchValidation(sheetObj, formObj) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var fromRow=0;
	var lvTrspCostModCd="";
	var lvRefId="";
	var lvFmNodCd="";
	var lvToNodCd="";
	var lvEqTpszCd="";
	var lvMoreQty="";
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) {
		fromRow=arrRow[i];
		if(  sheetObj.GetCellValue(fromRow, "needed_qty") > sheetObj.GetCellValue(fromRow, "remaining_qty") ){
			isOverplan="Y";
		}
		if( arrRow.length-1 == i ) {
			lvTrspCostModCd=lvTrspCostModCd +""+ sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd");
			lvRefId=lvRefId         +""+ sheetObj.GetCellValue(fromRow, "ref_id");
			lvFmNodCd=lvFmNodCd       +""+ sheetObj.GetCellValue(fromRow, "fm_nod_cd");
			lvToNodCd=lvToNodCd       +""+ sheetObj.GetCellValue(fromRow, "to_nod_cd");
			lvEqTpszCd=lvEqTpszCd      +""+ sheetObj.GetCellValue(fromRow, "eq_tpsz_cd");
			lvMoreQty=lvMoreQty       +""+ ( sheetObj.GetCellValue(fromRow, "needed_qty") - sheetObj.GetCellValue(fromRow, "remaining_qty") ) ;
		} else {
			lvTrspCostModCd=lvTrspCostModCd +""+ sheetObj.GetCellValue(fromRow, "trsp_cost_dtl_mod_cd")+",";
			lvRefId=lvRefId         +""+ sheetObj.GetCellValue(fromRow, "ref_id")         +",";
			lvFmNodCd=lvFmNodCd       +""+ sheetObj.GetCellValue(fromRow, "fm_nod_cd")           +",";
			lvToNodCd=lvToNodCd       +""+ sheetObj.GetCellValue(fromRow, "to_nod_cd")           +",";
			lvEqTpszCd=lvEqTpszCd      +""+ sheetObj.GetCellValue(fromRow, "eq_tpsz_cd")          +",";
			lvMoreQty=lvMoreQty       +""+ ( sheetObj.GetCellValue(fromRow, "needed_qty") - sheetObj.GetCellValue(fromRow, "remaining_qty") ) + "," ;
		}
	}
	formObj.hid_trsp_cost_mod_cd.value=lvTrspCostModCd;
	formObj.hid_ref_id.value=lvRefId;
	formObj.hid_fm_nod_cd.value=lvFmNodCd;
	formObj.hid_to_nod_cd.value=lvToNodCd;
	formObj.hid_eq_tpsz_cd.value=lvEqTpszCd;
	formObj.hid_more_qty.value=lvMoreQty;
	formObj.hid_curr_dt.value=sheetObj.GetCellValue(2, "curr_dt");
	return true;
}
/**
 * Validating inputted values of form - verify
 */
function searchVerify(sheetObj, formObj, sStatus) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var fromRow=0;
	var lvEq_no="";
	var lvFm_nod_cd="";
	var lvDtlToNodCd="";
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	if( arrRow.length > 0 && arrRow.length < 1001 ) {
		for( var i=0; i<arrRow.length; i++ ) {
			fromRow=arrRow[i];
			if( sheetObj.GetCellValue(fromRow, "eq_no") == "" || sheetObj.GetCellValue(fromRow, "fm_nod_cd") == "" ) {
				sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
				sheetObj.SetRowStatus(arrRow[i],"R");
				sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
			} else {
				if( arrRow.length-1 == i ) {
					lvEq_no=lvEq_no +""+ sheetObj.GetCellValue(fromRow, "eq_no");
					lvFm_nod_cd=lvFm_nod_cd +""+ sheetObj.GetCellValue(fromRow, "fm_nod_cd");
					lvDtlToNodCd=lvDtlToNodCd +""+ sheetObj.GetCellValue(fromRow, "to_nod_cd");
				} else {
					lvEq_no=lvEq_no +""+ sheetObj.GetCellValue(fromRow, "eq_no")+",";
					lvFm_nod_cd=lvFm_nod_cd +""+ sheetObj.GetCellValue(fromRow, "fm_nod_cd")+",";
					lvDtlToNodCd=lvDtlToNodCd +""+ sheetObj.GetCellValue(fromRow, "to_nod_cd")+",";
				}
			}
		}
		if( sheetObj.FindCheckedRow("chk1") < 1 ) {
			errMsg=ComGetMsg("TRS90132");
			ComShowMessage(errMsg);
			return false;
		}
		formObj.eq_no_verify.value=lvEq_no;
		formObj.frm_node_verify.value=lvFm_nod_cd;
		formObj.to_nod_verify.value=lvDtlToNodCd;	
	}else{
		ComShowMessage('Only 1000 rows or less could be imported at a time.');
		return false;
	}
	return true;
}

//Sheet의 Object
function openObjSheet() {
	return sheetObjects[1];
}
/**
 * Validating Container File import
 */
function contatnerValidation(sheetObj, formObj) {
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length ; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "eq_no") != "" ) {
			sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
			ComShowMessage(ComGetMsg("TRS90051"));
			return false;
		}
	}
	return true;
}
/*
 * Sheet Object of popup page. Using Importing contain File
 */
function getSheetObj() {
	return sheetObjects[1];
}
/**
 * calling file import window
 */
function popEqFileImport(sheetObject, formObject) {
	ComOpenWindow('ESD_TRS_0951.screen', 'ESD_TRS_0951', 'top=200, left=200, width=395, height=300, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
}
/**
 * Validating inputted values of form
 */
function validateForm(sheetObj, formObj){
	if( sheetObj.CheckedRows("chk1") < 1 ) {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var doc_eq_no="";
	var bverifychk=false;
	var birgchk=false;
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) {
		doc_eq_no=ComTrimAll(sheetObj.GetCellValue(arrRow[i], "eq_no"), " ");
		if( sheetObj.GetCellValue(arrRow[i], "so_cre_yn") != "Y" ) {
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
			if( sheetObj.GetCellValue(arrRow[i], "verify_result") == "") {
				errMsg=ComGetMsg("TRS90360");
			} else {
				errMsg=ComGetMsg("TRS90078");
			}
			ComShowMessage(errMsg);
			return false;
		}
		if( sheetObj.GetCellValue(arrRow[i], "rout_dtl_seq") == "0" ) {
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
			sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
			ComShowMessage(ComGetMsg("TRS90148"));
			return false;
		}
		if( doc_eq_no == "" ) {
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
			sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0");
			sheetObj.SetCellValue(arrRow[i], "lessor","",0);
			sheetObj.SetCellValue(arrRow[i], "lstm_cd","",0);
			sheetObj.SetCellValue(arrRow[i], "ownr_co_cd","",0);
			sheetObj.SetCellValue(arrRow[i], "eq_used","",0);
			sheetObj.SetCellValue(arrRow[i], "movement_sts","",0);
			sheetObj.SetCellValue(arrRow[i], "creation_yard","",0);
			sheetObj.SetCellValue(arrRow[i], "event_date","",0);
		}
	}
	return true;
}
/**
 * Event of Sheet1
 */
var doc_row=0; // container check..
function sheet2_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.SetRowStatus(row,"I");
		} else {
			sheetObj.SetRowStatus(row,"R");
		}
	} else if( sheetObj.ColSaveName(col) == "eq_no" ) {
		var doc_eq_no=sheetObj.GetCellValue(row, "eq_no");
		if( doc_eq_no.length >= 10 ) {
			doc_row=row;
			document.form.hid_cntr_no.value=doc_eq_no;
			document.form.hid_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "eq_tpsz_cd");
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH, "EQ","");
		} else {
			sheetObj.SetCellValue(row, "eq_no","");
			sheetObj.SetCellValue(row, "lessor","",0);
			sheetObj.SetCellValue(row, "lstm_cd","",0);
			sheetObj.SetCellValue(row, "ownr_co_cd","",0);
			sheetObj.SetCellValue(row, "eq_used","",0);
			sheetObj.SetCellValue(row, "movement_sts","",0);
			sheetObj.SetCellValue(row, "creation_yard","",0);
			sheetObj.SetCellValue(row, "event_date","",0);
		}
	}
}
/**
 * General processing method working when there is an error of inquiring result
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet2_OnSaveEnd(sheetObj,errMsg) {
	if( errMsg !='' && errMsg !=0 && errMsg !=-1 ) {
		ComShowMessage(errMsg);
	} else {
		errMsg=ComGetMsg("TRS90103");
		ComShowMessage(errMsg);
		var sRow=sheetObj.FindCheckedRow("chk1");
		var arrRow=sRow.split("|");
		for( var ir=arrRow.length-1; ir >=0 ; ir-- ) {
			sheetObj.RowDelete(arrRow[ir], false);
		}
		if( validateFormSearch(document.form) ) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "","");
		}
	}
}
/**
 * General processing method working when there is an error of inquiring result
 * DataSheetObject.prototype.event_OnSaveEnd of IBSheetConfig.js
 */
function sheet2_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg.length > 0 ) {
		ComShowMessage(errMsg);
	} else {
		 if( document.form.f_cmd.value == SEARCH09 ) {
			var currRefid=document.form.hid_ref_id.value;
			var moreQty=document.form.hid_more_qty.value;
			var overplanRefid=sheetObj.GetEtcData('overplan_ref_id');
			var arr_currRefid=currRefid.split(",");
			var arr_moreQty=moreQty.split(",");
			var arr_overplanRefid=overplanRefid.split(",");
			for( var i=0; i<arr_currRefid.length; i++ ) {
				if( arr_overplanRefid[i] != "nl" ) {
					var rRow=sheetObjects[0].FindText("ref_id", arr_currRefid[i]  , 0);
					var iRow=sheetObjects[0].DataInsert(rRow );
					sheetObjects[0].SetCellValue(iRow, "chk1","Y",0);
					sheetObjects[0].SetCellValue(iRow, "trsp_cost_dtl_mod_name" ,sheetObjects[0].GetCellValue(rRow, "trsp_cost_dtl_mod_name"),0);
					sheetObjects[0].SetCellValue(iRow, "requested_date" ,sheetObjects[0].GetCellValue(rRow, "curr_dt"),0);
					sheetObjects[0].SetCellValue(iRow, "ref_id" ,arr_overplanRefid[i],0);
					sheetObjects[0].SetCellValue(iRow, "eq_tpsz_cd" ,sheetObjects[0].GetCellValue(rRow, "eq_tpsz_cd"),0);
					sheetObjects[0].SetCellValue(iRow, "allocated" ,arr_moreQty[i],0);
					sheetObjects[0].SetCellValue(iRow, "cret_qty" ,0,0);
					sheetObjects[0].SetCellValue(iRow, "edi_qty" ,0,0);
					sheetObjects[0].SetCellValue(iRow, "remaining_qty" ,arr_moreQty[i],0);
					sheetObjects[0].SetCellValue(iRow, "needed_qty" ,arr_moreQty[i],0);
					sheetObjects[0].SetCellValue(iRow, "fm_nod_cd" ,sheetObjects[0].GetCellValue(rRow, "fm_nod_cd"),0);
					sheetObjects[0].SetCellValue(iRow, "to_nod_cd" ,sheetObjects[0].GetCellValue(rRow, "to_nod_cd"),0);
					sheetObjects[0].SetCellValue(iRow, "trsp_cost_dtl_mod_cd" ,sheetObjects[0].GetCellValue(rRow, "trsp_cost_dtl_mod_cd"),0);
					sheetObjects[0].SetCellValue(iRow, "curr_dt" ,sheetObjects[0].GetCellValue(rRow, "curr_dt"),0);
					sheetObjects[0].SetCellValue(rRow, "needed_qty" ,sheetObjects[0].GetCellValue(rRow, "remaining_qty"),0);
				}
			}
		}else if(document.form.f_cmd.value == SEARCH11){
			
		}
	}
}
/**
 * 
 * @param sheetObj
 * @param errMsg
 */
function sheet3_OnSearchEnd(sheetObj,errMsg) {
	if( errMsg==-1 ) {
		if( document.form.f_cmd.value == SEARCH14 ) {
			sheetObjects[1].SetCellValue(doc_row, "eq_no","",0);
			sheetObjects[1].SetRowStatus(doc_row,"R");
			sheetObjects[1].SetCellValue(doc_row, "chk1","0",0);
			sheetObjects[1].SetRowBackColor(doc_row,"#DEFAF0");
		} else {
			ComShowMessage(errMsg);
		}
	} else {
		var bchk=false;
		if( document.form.f_cmd.value == SEARCH14 ) {
			var doc_cntr_no=sheetObjects[2].GetCellValue(1, "eq_no");
			for( var ir=1; ir < sheetObjects[1].RowCount()+1; ir++ ) {
				if( doc_cntr_no == sheetObjects[1].GetCellValue(ir, "eq_no") && (ir != doc_row) ) {
					bchk=true;
					break;
				}
			}
			if( bchk ) {
				sheetObjects[1].SetRowStatus(doc_row,"R");
				sheetObjects[1].SetCellValue(doc_row, "chk1","0",0);
				sheetObjects[1].SetRowBackColor(doc_row,"#DEFAF0");
				sheetObjects[1].SetCellValue(doc_row, "eq_no","",0);
				sheetObjects[1].SetCellValue(doc_row, "lessor","",0);
				sheetObjects[1].SetCellValue(doc_row, "lstm_cd","",0);
				sheetObjects[1].SetCellValue(doc_row, "ownr_co_cd","",0);
				sheetObjects[1].SetCellValue(doc_row, "eq_used","",0);
				sheetObjects[1].SetCellValue(doc_row, "movement_sts","",0);
				sheetObjects[1].SetCellValue(doc_row, "creation_yard","",0);
				sheetObjects[1].SetCellValue(doc_row, "event_date","",0);
				errMsg="The same Container No exits."; // ComGetMsg("TRS90103");
				ComShowMessage(errMsg);
			} else {
				sheetObjects[1].SetCellValue(doc_row, "eq_no",sheetObjects[2].GetCellValue(1, "eq_no"),0);
				sheetObjects[1].SetCellValue(doc_row, "lessor",sheetObjects[2].GetCellValue(1, "lessor"),0);
				sheetObjects[1].SetCellValue(doc_row, "lstm_cd",sheetObjects[2].GetCellValue(1, "lstm_cd"),0);
				sheetObjects[1].SetCellValue(doc_row, "ownr_co_cd",sheetObjects[2].GetCellValue(1, "ownr_co_cd"),0);
				sheetObjects[1].SetCellValue(doc_row, "eq_used",sheetObjects[2].GetCellValue(1, "eq_used"),0);
				sheetObjects[1].SetCellValue(doc_row, "movement_sts",sheetObjects[2].GetCellValue(1, "movement_sts"),0);
				sheetObjects[1].SetCellValue(doc_row, "creation_yard",sheetObjects[2].GetCellValue(1, "creation_yard"),0);
				sheetObjects[1].SetCellValue(doc_row, "event_date",sheetObjects[2].GetCellValue(1, "event_date"),0);
			}
			sheetObjects[2].RemoveAll();
			document.form.hid_cntr_no.value="";
			doc_row=0;
		} else {
			doSearchVerify(sheetObjects[1], sheetObjects[2]);
		}
	}
}
/*
 * Selecting S/O Creation item of the result of verification function
 */
function doSearchVerify(sheetObj1, sheetObj2) {
	var sRow=sheetObj1.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	var fromRow=0;
	var verifyCount=0;
	for( var i=0; i<arrRow.length; i++ ) {
		fromRow=arrRow[i];
		var lvEa_no=sheetObj1.GetCellValue(fromRow, "eq_no");
		sheetObj1.SetCellValue(fromRow, "so_cre_yn","Y",0);
		for( var z=1; z<(sheetObj2.RowCount()+1); z++ ) {
			if( lvEa_no == sheetObj2.GetCellValue(z, "eq_no") ) {
				sheetObj1.SetCellValue(fromRow, "verify_result",sheetObj2.GetCellValue(z, "verify_result"),0);
				if( sheetObj2.GetCellValue(z, "verify_yn") == "N" ) {
					sheetObj1.SetCellValue(fromRow, "so_cre_yn","Y",0);
				} else {
					sheetObj1.SetCellValue(fromRow, "so_cre_yn","",0);
					sheetObj1.SetRowStatus(fromRow,"R");
					sheetObj1.SetCellValue(fromRow, "chk1","0",0);
					sheetObj1.SetRowBackColor(fromRow,"#DEFAF0");
				}
				sheetObj2.RowDelete(z, false);
				break;
			}
		}
		if( sheetObj1.GetCellValue(fromRow, "verify_result") == "" ) {
			sheetObj1.SetRowStatus(fromRow,"I");
			sheetObj1.SetCellValue(fromRow, "verify_result","OK",0);
		}
		if(sheetObj1.GetCellValue(fromRow, "verify_result") != "OK"){
			verifyCount=verifyCount + 1;
		}
	}
	if(verifyCount < 1){
		errMsg=ComGetMsg("TRS90375");
		ComShowMessage(errMsg);	
	}
}
/**
 * Resizing the page
 */
function Minimize(nItem) {
	var objs=document.all.item("MiniLayer");
	if( nItem == "1" ) {
		objs.style.display="none";
	} else {
		objs.style.display="inline";
	}
}
function validateFormSearch(formObj) {
	var lvFrmDate=ComTrimAll(ComTrimAll(formObj.frm_plandate.value, " "), "-");
	var lvToDate=ComTrimAll(ComTrimAll(formObj.to_plandate.value, " "), "-");
	var lvFrm_node=ComTrimAll(formObj.frm_node.value, " ");
	var lvTo_node=ComTrimAll(formObj.to_node.value, " ");
	var lvRef_no=ComTrimAll(formObj.refer_no.value, " ");
	var lvCntr_no=ComTrimAll(formObj.cntr_no.value, " ");
	if( lvFrmDate == "" ) 
		formObj.frm_plandate.value="";
	if( lvToDate == "" ) // to date
		formObj.to_plandate.value="";
	if( lvRef_no == "" ) // BKG No
		formObj.refer_no.value="";
	if( lvCntr_no == "" ) // CNTR No
		formObj.cntr_no.value="";
	if( lvFrmDate == "" && lvToDate != "" ) { 
		errMsg=ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) {
		errMsg=ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) {
		if( !ComIsDate(lvFrmDate) ) {
			errMsg=ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_plandate.focus();
			return false;
		} else if( !ComIsDate(lvToDate) ) {
			errMsg=ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_plandate.focus();
			return false;
		}
		if( ComGetDaysBetween(lvFrmDate, lvToDate) > 30 ) {
			ComShowCodeMessage('TRS90424');
			return false;
		} else if( ComGetDaysBetween(lvFrmDate, lvToDate) < 0 ) {
			errMsg=ComGetMsg("TRS90118");
			ComShowMessage(errMsg);
			return false;
		}
	} else {
		if( lvRef_no == "" && lvCntr_no == "" ) {
			errMsg=ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
	}
	if( lvFrm_node == "" ) { 
		formObj.frm_node.value="";
		frm_yard.RemoveAll();
	}
	if( lvTo_node == "" ) {
		formObj.to_node.value="";
		to_yard.RemoveAll();
	}
	if( !ComIsAlphabet(ComTrimAll(lvRef_no, ","), "n") && lvRef_no != "" ) {
		formObj.refer_no.value="";
		formObj.refer_no.focus();
		return false;
	}
	if( !ComIsAlphabet(ComTrimAll(lvCntr_no, ","), "n") && lvCntr_no != "" ) {
		formObj.cntr_no.value="";
		formObj.cntr_no.focus();
		return false;
	}
	formObj.hid_frmdate.value=lvFrmDate; 
	formObj.hid_todate.value=lvToDate; // to Date
	formObj.frm_node.value=lvFrm_node.toUpperCase();
	formObj.to_node.value=lvTo_node.toUpperCase();
	formObj.refer_no.value=lvRef_no.toUpperCase(); // BKG No.
	formObj.cntr_no.value=lvCntr_no.toUpperCase(); // CNTR No
	return true;
}
/*
 * Calling IRG Adjust Pop up
 */
function doActionPopupOpen(sheetObj, formObject) {
	var sRow=sheetObj.FindCheckedRow("chk1");
	if(sRow == '') {
		ComShowMessage(ComGetMsg("TRS90036"));
		return false;
	}
	var arrRow=sRow.split("|");
	for( var i=0; i<arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "rout_dtl_seq") == "0" ) {
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetCellValue(arrRow[i], "chk1","0",0);
			sheetObj.SetRowBackColor(arrRow[i],"#DEFAF0"); 
			
			ComShowMessage(ComGetMsg("TRS90148"));
			return false;
		}
	}
	var myOption="width=1000; height=480; help=no; status=no; resizable=no; scroll=no; ";
    ComOpenWindow('ESD_TRS_0928.do', 'ESD_TRS_0928',myOption, false);
}
/*
 * Pop-Up from IBSheet
 */
function sheet1_OnPopupClick(sheetObj, row, col) {
	if ( sheetObj.ColSaveName(col) == "p1" ) {
		ComShowCodeMessage('TRS90334')+ row;
	}
}
/*
 * Loading the list of external combo box (Also in ESD_TRS_0003.js).
 */
function getComboList(obj, comObj, sep) { // object, value receiving part,
	comObj = eval(comObj.id);
	var formObj=document.form;
	var lvobj=ComTrimAll(obj, " ");
	obj.value=lvobj;
	if( lvobj == "" ) {
		obj.value="";
		comObj.RemoveAll();
		return false;
	} else if( lvobj.length != 5 ) {
		obj.focus();
		errMsg=ComGetMsg("TRS90074");
		ComShowMessage(errMsg);
		return false;
	}
	if( !doengnumcheck(lvobj) ) {
		obj.value="";
		comObj.RemoveAll();
		obj.focus();
		return false;
	}
	if( sep == 'F' ) {
		lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.focus();
}
/**
 * General Node popup
 */
 function openHireYardPopup(objName) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";   
	var cmdt_desc_val="";   
	var classId=objName;
	var xx1=""; // CONTI
	var xx2=""; // SUB CONTI
	var xx3=""; // COUNTRY
	var xx4=""; // STATE
	var xx5=""; // CONTROL OFFIC
	var xx6=""; // LOC CODE
	var xx7=""; // LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 820, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * From Node popup's return value
 */
function getFromNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.frm_node.value=lvLoc;
	getYardCombo(frm_yard, sheetObjects[0], formObject, lvLoc);
	frm_yard.CODE=lvYard;
}
/**
 * To Node popup's return value
 */
function getToNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.to_node.value=lvLoc;
	getYardCombo(to_yard, sheetObjects[0], formObject, lvLoc);
	to_yard.CODE=lvYard;
}
/**
 * General Trunk VVD popup
 */
 function openMultipleinquiry(obj, obj2) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";   
	var cmdt_desc_val="";   
	var xx1=""; // CONTI
	var xx2=""; // SUB CONTI
	var xx3=""; // COUNTRY
	var xx4=""; // STATE
	var xx5=""; // CONTROL OFFIC
	var xx6=""; // LOC CODE
	var xx7=""; // LOC NAME
	var xx8="";
	var xx9="";
	var classId="getTRS_ENS_906";
	var param="?returnval="+obj+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+ "&pgmNo=ESD_TRS_0203";
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 420, 390, "getTRS_ENS_906", '1,0,1,1,1,1,1,1');
}
/**
 * Location : The case selecting one item at pop-up page
 */
function getTRS_ENS_906(rowArray, obj) {
	var reObj="";
	var formObject=document.form;
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
		if( i == rowArray.length-1 ) {
			reObj=reObj + colArray;
		} else {
			reObj=reObj + colArray + ",";
		}
	}
	if( obj == "VVD" ) {
		formObject.trunk_vvd.value=reObj;
	} else if( obj == "REF" ) {
		formObject.refer_no.value=reObj;
	} else if( obj == "BLN" ) {
		formObject.bill_no.value=reObj;
	} else if( obj == "CNT" ) {
		formObject.cntr_no.value=multiCntrChkDgt(reObj);
	} else {
		errMsg=ComGetMsg("TRS90132");
		ComShowMessage(errMsg);
	}
}
/**
 * General Trunk VVD popup
 */
 function openTVVDPopup() {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val="";   
	var cmdt_desc_val="";   
	var v1=""; // ETDETA
	var v2=""; // SDATE
	var v3=""; // EDATE
	var v4=""; // VVD_CD
	var v5=""; // LOC_CD
	var v6=""; // LANE_CD
	var v7=""; // OPER
	var xx1=""; // CONTI
	var xx2=""; // SUB CONTI
	var xx3=""; // COUNTRY
	var xx4=""; // STATE
	var xx5=""; // CONTROL OFFIC
	var xx6=""; // LOC CODE
	var xx7=""; // LOC NAME
	var xx8="";
	var xx9="";
	var classId="getCOM_ENS_VVD_1";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_0B2.do' + param, 772, 500, classId, '1,0,1,1,1,1,1,1');
}
function getCOM_ENS_VVD_1(rowArray) {
	var formObject=document.form;
	var gubun="";
	var colArray=rowArray[0];
	formObject.trunk_vvd.value=colArray[7] + gubun;
}
/*
 * Multi-Calendar input Pop-Up
 */
function getCalendar() {
	var cal=new ComCalendarFromTo();
	cal.displayType="date";
	cal.select(document.form.frm_plandate, document.form.to_plandate, 'yyyy-MM-dd');	
}
function getDateBetween(obj) {
	if(document.form.frm_plandate.value == ""){
		document.form.to_plandate.value="";
	}else{
		document.form.to_plandate.value=ComGetDateAdd(obj.value, "D", 30);		
	}
}
