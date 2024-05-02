/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0052.js
*@FileTitle  : Empty Repo & EQ On/Off Hire
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
var R=0;
var G=255;
var B=0;
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
*/
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
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
		case 1: {
			with(sheetObj){
				var HeadTitle="||Reference No|Kind|BKG No|CNTR No|CNTR\nTP/SZ|From\nNode|To\nNode|CB\nSEQ|Trans.\nMode|Purpose|Lessor|EQ\nLease Term|EQ Owner|EQ Used|Movement\nStatus|Creation Yard|Event Date|Verify Result|Internal Remark|Remark\n(Special Instruction)";
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
			    var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk1" },
			             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"ref_id",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"trsp_cost_dtl_mod_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_nod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_cmb_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trsp_crr_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"repo_purp_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lessor",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ownr_co_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_used",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"movement_sts",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"creation_yard",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"event_date",              KeyField:0,   CalcLogic:"",   Format:"",         	  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"verify_result",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:255 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"inter_rmk",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:255 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"spcl_instr_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:10,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"repo_pln_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ref_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"so_cre_yn",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pln_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_sts_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
			             ];
			    InitColumns(cols);
			    SetEditable(1);
			    ComResizeSheet(sheetObj);
			}
			break;
		}
		case 2: {
            with(sheetObj){
					var HeadTitle0="Office Code|Seqence";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				    var headers = [ { Text:HeadTitle0, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trsp_so_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:0 } ];
		   
					 InitColumns(cols);
					 SetEditable(0);
					 SetVisible(false);
			}
            break;
		}
		case 3: {
			with(sheetObj) {
		    	var HeadTitle1="SEP|EQ_NO|VERIFY_RESULT|VERIFY_YN" ;
		    	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		    	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		    	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		    	InitHeaders(headers, info);
		    	var cols = [ 
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sep",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:600,  Align:"Center",  ColMerge:1,   SaveName:"verify_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"verify_yn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lessor",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ownr_co_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_used",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"movement_sts",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"creation_yard",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"event_date",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"offh_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
			             {Type:"Status",    Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",     	 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }			             
		             ];
		    	InitColumns(cols);
		    	SetEditable(1);
		    	SetVisible(false);
			}
		    break;
		}
	}
}
document.onclick=processButtonClick;
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var sheetObject1=sheetObjects[1];
	var sheetObject2=sheetObjects[2];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve": 
				if( validateFormSearch(formObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
				}
			break;
			case "btn_new":
				formObject.reset();
				frm_yard.RemoveAll();
				to_yard.RemoveAll();
				document.all["id_woissue"].style.display = "inline";
				document.all["id_woissueno"].style.display = "none";
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
			break;
			case "btn_minimize": //Minimize
				if(document.all.MiniLayer.style.display != "none") {
				    document.all.MiniLayer.style.display="none";                
				} else {
				    document.all.MiniLayer.style.display="";                
				}
				ComResizeSheet(sheetObject);				
			break;
			case "btns_calendar": //Calendar
				getCalendar();
			break;
			case "btng_downexcel1": //sheet1 Excel download
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol_TRS(sheetObject), SheetDesign:1, Merge:1 });
				}
			break;
			case "btng_socreation1": //sheet1 S/O Creation
				if( validationCheck(sheetObject) ) {
					doActionIBSheet(sheetObject, formObject, IBSAVE, "");
				}
			break;
			case "btng_woissue1": //sheet1 W/O Issue
				doActionIBSheet(sheetObject1, formObject, IBSAVE, "WO");
			break;
			case "btns_frmnode": //FromNode Popup Window
				openHireYardPopup('getFromNode');
			break;
			case "btns_tonode": //ToNode Popup Window
				openHireYardPopup('getToNode');
			break;
			case "btns_multicntr": //M CNTR
				openMultipleinquiry2(srcName,'CNT');
			break;
			case "btns_multirefno": //M Reference No
				openMultipleinquiry('RFN', 'Reference No');
			break;
			case "btns_multibkgno": //M Booking No
				openMultipleinquiry(srcName, 'Booking No');
			break;
			case "btng_fillincontainers": //Container Select PopUp
				if( contatnerValidation(sheetObject, formObject, "chk1") ) {
					popEqFileImport(sheetObject, formObject);
				}
			break;
			case "btng_sodelete": //S/O Delete
				if( sheetObject.RowCount("U") < 1 ) {
					ComShowCodeMessage("TRS90036");
				} else {
					doActionIBSheet(sheetObject, formObject, IBDELETE, "SO");
				}
				doActionIBSheet(sheetObject, formObject, IBSEARCH, "RE");
			break;
			case "btng_verify":
				if( searchVerify(sheetObject, formObject, "chk1") ) {
					doActionIBSheet(sheetObject2, document.form, IBSEARCH, "EQ");
//					doActionIBSheet(sheetObject2, formObject, IBSEARCH, "VY");
				}
			break;
			case "btns_multi_search_fm_node":
				openMultipleinquiry('FM_NODE', 'NODE Code');
			break;
			case "btns_multi_search_to_node":
				openMultipleinquiry('TO_NODE', 'NODE Code');
			break;
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

// Enter Key
function doSearchEnter() {
	if( event.keyCode == 13 ) {
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
		if( validateFormSearch(formObject) ) {
			doActionIBSheet(sheetObject, formObject, IBSEARCH, "");
		}
	}
}
/**
* file import window Call
*/
function popEqFileImport(sheetObject, formObject) {
	ComOpenWindow('ESD_TRS_0951.screen', 'ESD_TRS_0951', 'top=200, left=200, width=450, height=440, toolbar=0, directories=0, status=0, menubar=0, scrollbars=0, resizable=0');
}
/**
 * Screen to search form validation process for input processing
 */
function validateFormSearch(formObj) {
	var lvFrmDate=doSepRemove(doSepRemove(formObj.frm_reqdate.value, " "), "-");
	var lvToDate=doSepRemove(doSepRemove(formObj.to_reqdate.value, " "), "-");
	var lvFrm_node=doSepRemove(formObj.frm_node.value,     " ");
	var lvTo_node=doSepRemove(formObj.to_node.value,      " ");
	var lvCntr_no=doSepRemove(formObj.cntr_no.value,      " ");
	var lvReference_no=doSepRemove(formObj.reference_no.value, " ");
	var lvBkg_no=doSepRemove(formObj.bkg_no.value, " ");
	
	if( lvFrmDate == "" ) //from date
		formObj.frm_reqdate.value="";
	if( lvToDate == "" ) //to date
		formObj.to_reqdate.value="";
	if( lvFrmDate == "" && lvToDate != "" ) { //If either date is missing
		errMsg=ComGetMsg("TRS90119");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate == "" ) { //If either date is missing
		errMsg=ComGetMsg("TRS90121");
		ComShowMessage(errMsg);
		return false;
	} else if( lvFrmDate != "" && lvToDate != "" ) { //Check the date the part
		if( !doDatecheck(lvFrmDate) ) {
			errMsg=ComGetMsg("TRS90072");
			ComShowMessage(errMsg);
			formObj.frm_reqdate.focus();
			return false;
		} else if( !doDatecheck(lvToDate) ) {
			errMsg=ComGetMsg("TRS90073");
			ComShowMessage(errMsg);
			formObj.to_reqdate.focus();
			return false;
		}

        // 2015.01.21    Hyungwook Choi
		if( ComGetDaysBetween(lvFrmDate, lvToDate) > 30 ) {
			ComShowCodeMessage("TRS90424");
			return false;
		} else if( ComGetDaysBetween(lvFrmDate, lvToDate) < 0 ) {
			ComShowCodeMessage("TRS90118");
			return false;
		}

	} else {
		if( lvReference_no == "" && lvCntr_no == "" && lvBkg_no == "") {
			ComShowCodeMessage("TRS90124");
			return false;
		}
	}
	if( lvFrm_node == "" ) { //From Node
		formObj.frm_node.value="";
		frm_yard.RemoveAll(); // combo Deletion of data
	}
	if( lvTo_node == "" ) { //To Node
		formObj.to_node.value="";
		to_yard.RemoveAll(); // combo Deletion of data
	}
	if( !doengnumcheck(lvCntr_no) ) {
		formObj.cntr_no.value="";
		formObj.cntr_no.focus();
		return false;
	}
	if( !doengnumcheck(lvReference_no) ) {
		formObj.reference_no.value="";
		formObj.reference_no.focus();
		return false;
	}
	if( !doengnumcheck(lvBkg_no) ) {
		formObj.bkg_no.value="";
		formObj.bkg_no.focus();
		return false;
	}
	formObj.hid_frmreqdate.value=lvFrmDate; //from Date
	formObj.hid_toreqdate.value=lvToDate; //to Date
	formObj.frm_node.value=lvFrm_node.toUpperCase();
	formObj.to_node.value=lvTo_node.toUpperCase();
	formObj.cntr_no.value=lvCntr_no.toUpperCase(); //CNTR No
	formObj.reference_no.value=lvReference_no.toUpperCase(); //Reference No
	formObj.bkg_no.value=lvBkg_no.toUpperCase(); //Booking No
	return true;
}
/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction,sObj) {
	switch(sAction) {
		case IBSEARCH:     
			if( sObj == "RE" ) {
			formObj.f_cmd.value=SEARCH03;
			sheetObj.DoSearch("ESD_TRS_0052GS.do", TrsFrmQryString(formObj) );
			} else if( sObj == "EQ" ) { //CNTR No Verify
				formObj.f_cmd.value=SEARCH04;
				var queryStr = sheetObj.GetSaveString(true, true);
				sheetObjects[2].DoSearch("ESD_TRS_0052GS.do", queryStr + "&" + TrsFrmQryString(formObj) );
			} else if( sObj == "VY" ) { //Verify
				sheetObj.RemoveAll();
				formObj.f_cmd.value=SEARCH05;
				sheetObj.DoSearch("ESD_TRS_0052GS.do", TrsFrmQryString(formObj) );
			}
		break;
		case IBSAVE:
			if (sObj == "") {
				if(formObj.rad_wo_issued[0].checked) { // W/O Issued : NO
					formObj.f_cmd.value=MODIFY;
				} else { // W/O Issued : YES
					formObj.f_cmd.value=MODIFY02;
				}
				formObj.cbstatus.value=sObj;
				sheetObj.DoSave("ESD_TRS_0052GS.do", TrsFrmQryString(formObj), "chk1", false, true);
			} else if (sObj == "WO") {
				var cty_cd="";
				var seq_no="";
				for(var i=1; i<sheetObj.RowCount()+1; i++) {
					if( i == sheetObj.RowCount()) {
					cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd');
					seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq');
					} else {
						cty_cd += sheetObj.GetCellValue(i, 'trsp_so_ofc_cty_cd') + ",";
						seq_no += sheetObj.GetCellValue(i, 'trsp_so_seq') + ",";
					}
				}
				document.woForm.trsp_so_ofc_cty_cd.value=cty_cd;
				document.woForm.trsp_so_seq.value=seq_no;
				document.woForm.eq_mode.value="CG";
				document.woForm.pgmNo.value="ESD_TRS_0023";
				document.woForm.action="ESD_TRS_0023.screen?parentPgmNo=ESD_TRS_M001";
				document.woForm.submit();
			} else if (sObj == "SP") {
				if( sheetObj.RowCount("U") < 1 ) {
					ComShowCodeMessage("TRS90036");
					return false;
				} else {
					formObj.f_cmd.value=MODIFY01;
					formObj.cbstatus.value="";
					sheetObj.DoSave("ESD_TRS_0052GS.do", TrsFrmQryString(formObj), "chk1", false, true);
				}
			}
		break;
		case IBDELETE:
			if(!ComShowCodeConfirm("COM12165")) {
				return false;
			}
			formObj.f_cmd.value=REMOVE;
			formObj.cbstatus.value=sObj;
			sheetObj.DoSave("ESD_TRS_0052GS.do", {Param:TrsFrmQryString(formObj), Quest:false, Sync:2 });
		break;
	}
}
/*
 * Separate from the existing Single Unmap combined data.
 *
 */
function doSeparateRemove(sheetObj) {
	var fromRow=0;
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		fromRow=arrRow[i];
		if( sheetObj.GetCellValue(fromRow, "trsp_so_cmb_seq").length > 0 ) {
			sheetObj.SetCellValue(fromRow, "trsp_so_cmb_seq","",0);
			sheetObj.SetCellEditable(fromRow, "inter_rmk",1);
			sheetObj.SetCellEditable(fromRow, "spcl_instr_rmk",1);
		}
	}
}
/*
 *Check logic for CB Seq
 */
function validationCheck(sheetObj) {
	if( sheetObj.RowCount("U") < 1 || sheetObj.FindCheckedRow("chk1")=="" ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	//Determine the number of data rows
	var arrRow=sheetObj.FindCheckedRow("chk1").split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "trsp_so_cmb_seq").length > 0 ) {
			ComShowCodeMessage("TRS90062");
			return false;
		}
	}
	var bverifychk=false;
	for( var i=0; i <arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "so_cre_yn") != "Y" && sheetObj.GetCellValue(arrRow[i], "eq_no") != "" && sheetObj.GetCellEditable( arrRow[i] ,"eq_no")   ) {  
			sheetObj.SetRowStatus(arrRow[i], "R");
			sheetObj.SetRowBackColor(arrRow[i], "#NANNANNAN");
			if( sheetObj.GetCellValue(arrRow[i], "verify_result") == "" ) {
				errMsg=ComGetMsg("TRS90360");
			} else {
				errMsg=ComGetMsg("TRS90078");
			}
			bverifychk=true;
			break;
		}
	}
	if( bverifychk ) {
		ComShowMessage(errMsg);
		return false;
	}
	return true;
}
/**
 * Container File import processing for the validation process
 */
function contatnerValidation(sheetObj, formObj, sStatus) {
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		if( sheetObj.GetCellValue(arrRow[i], "eq_no") != "" ) {
			sheetObj.SetCellValue(arrRow[i], "chk1","0",0);//Lets check the boxes checked off.
			sheetObj.SetRowStatus(arrRow[i],"R");
			sheetObj.SetRowBackColor(arrRow[i],"#NANNANNAN");
		}
	}
	if( sheetObj.RowCount("U") < 1 ) {
		ComShowCodeMessage("TRS90051");
		return false;
	}
	return true;
}
//tab1 sheet of information about
function t1sheet1_OnClick(sheetObj, row , col , value) {
	if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
		return false;
	}
	if( sheetObj.GetCellProperty(row, col, "dpDataType")== 6 ) {
			value=sheetObj.GetCellValue(row, sheetObj.ColSaveName(col-1));
		if( sheetObj.ColSaveName(col).indexOf("yard")>-1 ) {
			getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		}
	}
}
function doSeperationCheck(sheetObj, col, row) {
	if( sheetObj.ColSaveName(col) == "CMC" ) {
		if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
			sheetObj.SetCellValue(row, "CMC","0",0);
			return false;
		} else {
			return true;
		}
	}
}
var doc_row=0; //container check..
function t1sheet1_OnChange(sheetObj, row, col, value) {
	if( sheetObj.ColSaveName(col) == "chk1" ) {
		if( value == "1" ) {
			sheetObj.SetRowStatus(row,"U");
			if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
				for( var i=1; i<(sheetObj.RowCount()+1); i++ ) {
					if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq") == sheetObj.GetCellValue(i, "trsp_so_cmb_seq") ) {
						sheetObj.SetRowStatus(i,"U");
						sheetObj.SetCellValue(i, "chk1","1",0);
					}
				}
			}
		} else {
			sheetObj.SetRowStatus(row,"R");
			if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq").length > 0 ) {
				for( var i=1; i<(sheetObj.RowCount()+1); i++ ) {
					if( sheetObj.GetCellValue(row, "trsp_so_cmb_seq") == sheetObj.GetCellValue(i, "trsp_so_cmb_seq") ) {
						sheetObj.SetRowStatus(i,"R");
						sheetObj.SetCellValue(i, "chk1","0",0);
					}
				}
			}
		}
	} else if( sheetObj.ColSaveName(col) == "eq_no" ) {
		var doc_eq_no=sheetObj.GetCellValue(row, "eq_no");
		if( doc_eq_no.length >= 10 ) {
			doc_row=row;
			document.form.hid_cntr_no.value=doc_eq_no.toUpperCase();
			document.form.hid_cntr_tpsz_cd.value=sheetObj.GetCellValue(row, "eq_tpsz_cd");
			document.form.frm_node_verify.value=sheetObj.GetCellValue(row, "fm_nod_cd");
			sheetObjects[2].RemoveAll();
			var curRow = sheetObjects[2].DataInsert();
			sheetObjects[2].SetCellValue(curRow, "eq_no", doc_eq_no, 0);
			sheetObjects[2].SetCellValue(curRow, "eq_tpsz_cd", sheetObj.GetCellValue(row, "eq_tpsz_cd"), 0);
//			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH, "EQ");
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
function doDataEquals(sheetObj) { //In order to compare the data added.
	if( sheetObj.RowCount("U") < 1 ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	//Determine the number of data rows
	var fromRow=0;
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	for( var i=0; i < arrRow.length; i++ ) {
		fromRow=arrRow[i];
		var lvFmnod=doSepRemove(sheetObj.GetCellValue(fromRow, "fm_nod_cd"), " ");
		var lvTonod=doSepRemove(sheetObj.GetCellValue(fromRow, "to_nod_cd"), " ");
		if( sheetObj.GetCellValue(fromRow, "eq_tpsz_cd").indexOf("2") < 0 ) {
			sheetObj.SetRowStatus(fromRow,"R");//false
			sheetObj.SetCellValue(fromRow, "chk1","0",0);
			sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
		} else {
			if( lvFmnod == "" || lvTonod == "" ) {
				sheetObj.SetRowStatus(fromRow,"R");//false
				sheetObj.SetCellValue(fromRow, "chk1","0",0);
				sheetObj.SetRowBackColor(fromRow,"#NANNANNAN");
			}
		}
	}
	return true;
}
/*
 * Sheet pop-up window that is used by the object (None if clear)
 */
function getSheetObj() {
	return sheetObjects[0];
}
// From Node1/2,  To Node1/2
function doTimeCheck(of, of2, ot, ot2) {
	if( of == of2 && ot == ot2 ) { //Comparison of Location Information
		return true;
	} else {
		return false;
	}
}

// Changes the background color and the part of CB
function IBS_Sheet2SheetStatus4(fromSheet) {
	var iz=0;
	var cs=0;
	for( var i=0; i<fromSheet.RowCount(); i++ ) {
		if( i % 2 == 0 )
			iz++;
		if( cs == 0 )
			cs=1;
		else if( cs == 1 )
			cs=2;
		else if( cs == 2 )
			cs=1;
		if( iz % 2 == 0 ) {
			fromSheet.SetCellValue(i+2, "trsp_so_cmb_seq",iz+"-"+cs,0);
			fromSheet.SetRowBackColor(i+2,"#DCEAA2");
		} else {
			fromSheet.SetCellValue(i+2, "trsp_so_cmb_seq",iz+"-"+cs,0);
			fromSheet.SetRowBackColor(i+2,"#FFFFFF");
		}
	}
}
/*
 * Get a list of external combo box (ESD_TRS_0003.js also exists).
 */
function getComboList(obj, comObj, sep) { //object, Taking part in the value, 'Node kind
	var formObj=document.form;
	var lvobj=doSepRemove(obj.value.toUpperCase(), " ");
	obj.value=lvobj;
	var lvkind=formObj.sel_kind.value; 
	comObj = eval(comObj.id);
	
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
		if( lvkind == "ALL" ) {  
			formObj.TRSP_SO_EQ_KIND.value="A";
		} else if( lvkind == "CN" ) {
			formObj.TRSP_SO_EQ_KIND.value="N";
		} else {
			formObj.TRSP_SO_EQ_KIND.value="";
		}
		formObj.search_fm_node.value="";
		lvFromNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'V' ) {
		lvViaNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'T' ) {
		if( lvkind == "ALL" ) {  
			formObj.TRSP_SO_EQ_KIND.value="A";
		} else if( lvkind == "CF" ) {
			formObj.TRSP_SO_EQ_KIND.value="N";
		} else {
			formObj.TRSP_SO_EQ_KIND.value="";
		}
		formObj.search_to_node.value="";
		lvToNode=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	} else if( sep == 'D' ) {
		lvDoorLoc=getYardCombo(comObj, sheetObjects[0], formObj, lvobj);
	}
	comObj.Focus();
}
/**
 * Common Node popup
 */
 function openHireYardPopup(objName) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var classId=objName;
	var xx1=""; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	var param="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 830, 500, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
}
/**
 * popSearchPiCommCodeGrid treatment process
 */
function popSearchPiCommCodeGrid(classID,midCD,cdName,sheetName,sRow,colCode,colName){
	var myUrl=getPopupURL(POPUP_PI_COMM);
	var myOption=getPopupOption(POPUP_PI_COMM);
	var url;
if(myWin!=null)  ComClosePopup(); 
	url=myUrl+"?class_id="+classID + "&mid_cd="+midCD + "&cdName="+cdName+ "&sheetName="+sheetName+ "&sRow="+sRow+ "&colCode="+colCode+ "&colName="+colName;
	myWin=window.open(url, "piCommCodePop", myOption);
	myWin.focus();
}
/**
 * From Node to pop the return value for
 */
function getFromNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.frm_node.value=lvLoc;
	formObject.search_fm_node.value="";
	getYardCombo(frm_yard, sheetObjects[0], formObject, lvLoc);
	frm_yard.SetSelectCode(lvYard, true);
}
/**
 * The return value for the pop-up To Node
 */
function getToNode(rowArray) {
	var formObject=document.form;
	var colArray=rowArray[0];
	var node=colArray[3];
	var lvLoc=node.substring(0, 5);
	var lvYard=node.substring(5, 7);
	formObject.to_node.value=lvLoc;
	formObject.search_to_node.value="";
	getYardCombo(to_yard, sheetObjects[0], formObject, lvLoc);
	to_yard.SetSelectCode(lvYard, true);
}

/**
 * 
 * @param sheetObj
 * @param errMsg
 */
function sheet3_OnSearchEnd(sheetObj, errMsg) {
	if (errMsg.length > 0) {
		if (document.form.f_cmd.value == SEARCH04) {
			sheetObjects[0].SetCellValue(doc_row, "eq_no", "", 0);
			// sheetObjects[0].SetRowStatus(doc_row, "R");
			sheetObjects[0].SetCellValue(doc_row, "chk1", "0", 0);
			sheetObjects[0].SetRowBackColor(doc_row, "#NANNANNAN");
		} else {
			ComShowMessage(errMsg);
		}
	} else {
		if (document.form.f_cmd.value == SEARCH04) {
			for ( var ir = 1; ir < sheetObjects[0].RowCount() + 1; ir++) {
				for ( var row = 1; row < sheetObjects[2].RowCount() + 1; row++) {
					if (sheetObjects[0].GetCellValue(ir, "eq_no") == sheetObjects[2].GetCellValue(row, "eq_no")) {
						if (sheetObjects[0].GetCellValue(ir, "eq_tpsz_cd") != sheetObjects[2].GetCellValue(row, "eq_tpsz_cd")) {
							sheetObjects[0].SetRowStatus(ir, "R");
							sheetObjects[0].SetCellValue(ir, "chk1", "0", 0);
							sheetObjects[0].SetRowBackColor(ir, "#NANNANNAN");
							sheetObjects[0].SetCellValue(ir, "eq_no", "", 0);
							sheetObjects[0].SetCellValue(ir, "lessor", "", 0);
							sheetObjects[0].SetCellValue(ir, "lstm_cd", "", 0);
							sheetObjects[0].SetCellValue(ir, "ownr_co_cd", "", 0);
							sheetObjects[0].SetCellValue(ir, "eq_used", "", 0);
							sheetObjects[0].SetCellValue(ir, "movement_sts", "", 0);
							sheetObjects[0].SetCellValue(ir, "creation_yard", "", 0);
							sheetObjects[0].SetCellValue(ir, "event_date", "", 0);
							
							errMsg = ComGetMsg("TRS90345");
							ComShowMessage(errMsg);
							return;
						} else {
							sheetObjects[0].SetCellValue(ir, "eq_no", sheetObjects[2].GetCellValue(row, "eq_no"), 0);
							sheetObjects[0].SetCellValue(ir, "lessor", sheetObjects[2].GetCellValue(row, "lessor"), 0);
							sheetObjects[0].SetCellValue(ir, "lstm_cd", sheetObjects[2].GetCellValue(row, "lstm_cd"), 0);
							sheetObjects[0].SetCellValue(ir, "ownr_co_cd", sheetObjects[2].GetCellValue(row, "ownr_co_cd"), 0);
							sheetObjects[0].SetCellValue(ir, "eq_used", sheetObjects[2].GetCellValue(row, "eq_used"), 0);
							sheetObjects[0].SetCellValue(ir, "movement_sts", sheetObjects[2].GetCellValue(row, "movement_sts"), 0);
							sheetObjects[0].SetCellValue(ir, "creation_yard", sheetObjects[2].GetCellValue(row, "creation_yard"), 0);
							sheetObjects[0].SetCellValue(ir, "event_date", sheetObjects[2].GetCellValue(row, "event_date"), 0);
							sheetObjects[0].SetRowBackColor(ir, "");
						}
					}
				}
			}
			sheetObjects[2].RemoveAll();
			document.form.hid_cntr_no.value="";
			doc_row=0;

			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH, "VY");
		} else {
			doSearchVerify(sheetObjects[0], sheetObjects[2]);
			ComShowCodeMessage('COM12116', 'Verify');
		}
	}
}

/**
 * Insert according to the success of the grid to remove the contents.
 */
function IBS_Sheet2SheetStatus3_2(fromSheet, toSheet, sStatus)  {
	if (typeof fromSheet == null || fromSheet.tagName == "undefined") {
		return false;
	}
		
	if (typeof toSheet == null || toSheet.tagName == "undefined") {
		return false;
	}
	var fromRow=0;
	var sRow=fromSheet.FindCheckedRow(sStatus);
	var arrRow=sRow.split("|");
	var rowCount=(arrRow.length)+toSheet.RowCount();
	var rowXml="";
	var allXml="<?xml version='1.0'  ?><SHEET>  <DATA TOTAL='"+rowCount+"'>";
	for (ir=0; ir < arrRow.length; ir++) {
		fromRow=arrRow[ir];
		rowXml="<TR>";
		rowXml += "<TD>" + fromSheet.GetCellValue(fromRow,"trsp_so_ofc_cty_cd") + "</TD>";
		rowXml += "<TD>" + fromSheet.GetCellValue(fromRow,"trsp_so_seq") + "</TD>";
		rowXml += "</TR>";
		allXml += rowXml;
	}
	allXml += "</DATA></SHEET>";
	toSheet.LoadSearchData(allXml,{Append:1 , Sync:1} );
}
/**
 * t1sheet1_OnSaveEnd
 */
function t1sheet1_OnSaveEnd(sheetObj, errCode, errMsg) {
	if(errCode  >= 0 ) {
		if( document.form.f_cmd.value == REMOVE ) {
			ComShowCodeMessage("TRS90109");
		} else if( document.form.f_cmd.value == MODIFY01 ){
			doSeparateRemove(sheetObj);
		} else {
			ComShowCodeMessage("TRS90105");
			IBS_Sheet2SheetStatus3_2(sheetObj, sheetObjects[1], "chk1");
			if ( validateFormSearch(document.form) ) {
				doActionIBSheet(sheetObj, document.form, IBSEARCH, "RE");
			}
		}
	}
}

/**
 * Common Trunk VVD popup
 */
function openMultipleinquiry(obj, obj2) {
	var formObject=document.form;
	var cmdt_cd_val="";   
	var rep_cmdt_cd_val=""; 
	var cmdt_desc_val="";   
	var xx1=obj; //CONTI
	var xx2=""; //SUB CONTI
	var xx3=""; //COUNTRY
	var xx4=""; //STATE
	var xx5=""; //CONTROL OFFIC
	var xx6=""; //LOC CODE
	var xx7=""; //LOC NAME
	var xx8="";
	var xx9="";
	var classId="getTRS_ENS_906";
	var param="?returnval="+xx1+"&returntitle="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
	ComOpenPopup('/opuscntr/ESD_TRS_0906.do' + param, 450, 420, "getTRS_ENS_906", '0,1',true);
}
/**
 * Common Multiple Inquiry popup
 */
 function openMultipleinquiry2(btn_obj,obj2) 
{
		var formObject=document.form;
		var cmdt_cd_val="";   
		var rep_cmdt_cd_val=""; 
		var cmdt_desc_val="";   
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var classId="getTRS_ENS_906";
		var param="?returnval="+xx1+"&sconti_cd="+obj2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 450, 450, "getTRS_ENS_906", '0,1',true);
}
/**
 * Location: If multiple selection in the pop-up.
 */
function getTRS_ENS_906(rowArray, x1) {
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
	if(x1 == 'RFN'){
		formObject.reference_no.value=reObj;
	} else if( x1 == "FM_NODE" ) {
		formObject.search_fm_node.value=reObj;
		resetLocYard("FROM");
	} else if( x1 == "TO_NODE" ) {
		formObject.search_to_node.value=reObj;
		resetLocYard("TO");
	}else{
		var formObject=document.form;
		if(x1 == 'btns_multicntr'){
			formObject.cntr_no.value=rowArray;
			checkDigit();
		} else if (x1 == 'btns_multibkgno') {
        	formObject.bkg_no.value=rowArray;
            checkDigit();
        }
	}
}
function checkDigit(obj){
	var formObj=document.form;
	if (obj == undefined){
		obj=formObj.cntr_no;
	}
	obj.value=obj.value.toUpperCase();
	if(formObj.name == 'form'){
		obj.value=multiCntrChkDgt(obj.value);
	}
}

/*
 * Calendar Pop-Up Multi-Input
 */
function getCalendar() {
    var cal=new ComCalendarFromTo();
	cal.displayType="date";
	cal.select(document.form.frm_reqdate, document.form.to_reqdate, 'yyyy-MM-dd');
}

// Addition to date.
function getDateBetween(obj) {
	if(ComIsNull(obj.value)) {
		 document.form.to_reqdate.value = "";
	} else {
		if(document.form.frm_reqdate.value != "" && document.form.frm_reqdate.value.split("-").join("").length == 8) {
		    document.form.to_reqdate.value = ComGetDateAdd(obj.value,"D", 30, "-");
		}
	}
	
}

/**
 * Screen input form validation process for handling - Cntr verify
 */
function searchVerify(sheetObj, formObj, sStatus) {
	sheetObjects[2].RemoveAll();
	if( sheetObj.CheckedRows("chk1") < 1  ) {
		ComShowCodeMessage("TRS90036");
		return false;
	}
	var fromRow=0;
	var lvEq_no="";
	var lvFm_nod_cd="";
	var sRow=sheetObj.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	
	for( var i=0; i<arrRow.length; i++ ) {
		fromRow=arrRow[i];
		sheetObj.SetCellValue(fromRow, "verify_result","",0);// verify result Initialization
//		if( sheetObj.GetCellValue(fromRow, "eq_no") == ""  ) {  // Verify missing or omitted if not EQ_NO EDIT.
		if( sheetObj.GetCellValue(fromRow, "eq_no") == "" || !sheetObj.GetCellEditable( fromRow ,"eq_no")  ) {  // Verify missing or omitted if not EQ_NO EDIT.
				
		} else {
			if( arrRow.length-1 == i ) {
				lvEq_no=lvEq_no +""+ sheetObj.GetCellValue(fromRow, "eq_no");
				lvFm_nod_cd=lvFm_nod_cd +""+ sheetObj.GetCellValue(fromRow, "fm_nod_cd");
			} else {
				lvEq_no=lvEq_no +""+ sheetObj.GetCellValue(fromRow, "eq_no")+",";
				lvFm_nod_cd=lvFm_nod_cd +""+ sheetObj.GetCellValue(fromRow, "fm_nod_cd")+",";
			}
			
			var row = sheetObjects[2].DataInsert(-1);
			sheetObjects[2].SetCellValue(row, "eq_no", sheetObj.GetCellValue(fromRow, "eq_no"), 0);
		}
	}
	if( sheetObj.CheckedRows("chk1") < 1   ||  lvEq_no.length < 1 ) {
		ComShowCodeMessage("TRS90132");
		return false;
	}
	
	// TODO CHECK EQ_NO VALIDATION
	var dupRow = sheetObjects[2].ColValueDup("eq_no");
	if(dupRow > -1 || dupRow !="-1") {
		errMsg = ComGetMsg("TRS90133");
		ComShowMessage(errMsg);
		return false;
	}
	
	formObj.eq_no_verify.value=lvEq_no;
	formObj.frm_node_verify.value=lvFm_nod_cd;
	return true;
}
/*
 * Verify the results viewed on the S / O Creation item selection
 */
function doSearchVerify(sheetObj1, sheetObj2) {
	var sRow=sheetObj1.FindCheckedRow("chk1");
	var arrRow=sRow.split("|");
	var fromRow=0;
	
	for( var i=0; i<arrRow.length; i++ ) {
		fromRow=arrRow[i];
		var lvEa_no=sheetObj1.GetCellValue(fromRow, "eq_no");
		if( sheetObj1.GetCellValue(fromRow, "eq_no") != "") { // Both can be created so ever a 'Y' marking, EQ_NO only in
			sheetObj1.SetCellValue(fromRow, "so_cre_yn","Y",0);// verify verify ok because it's not logic, turning the data.
		}
		if( sheetObj1.GetCellValue(fromRow, "verify_result") == "" && sheetObj1.GetCellValue(fromRow, "eq_no") != "" ) {
			sheetObj1.SetCellValue(fromRow, "verify_result","OK",0);
		}
		for( var z=1; z<(sheetObj2.RowCount()+1); z++ ) {
			if( lvEa_no == sheetObj2.GetCellValue(z, "eq_no") ) {
				sheetObj1.SetCellValue(fromRow, "verify_result",sheetObj2.GetCellValue(z, "verify_result"),0);
				if( sheetObj2.GetCellValue(z, "verify_yn") == "N" ) { //S / O Creation available
					sheetObj1.SetCellValue(fromRow, "so_cre_yn","Y",0);
				} else {
					sheetObj1.SetCellValue(fromRow, "so_cre_yn","",0);// S / O Creation possible.
					sheetObj1.SetRowStatus(fromRow,"R");
					sheetObj1.SetCellValue(fromRow, "chk1","0",0);
					sheetObj1.SetRowBackColor(fromRow,"#NANNANNAN");
				}
				//sheetObj2.RowDelete(z, false);
				break;
			}
		}
	}
}


function resetLocYard(which) {
	var formObj = document.form;
	if(which=='FROM') {
		if(formObj.search_fm_node.value.length > 0) {
			formObj.frm_node.value="";
			frm_yard.RemoveAll();
		}
	}else{
		if(formObj.search_to_node.value.length > 0) {
			formObj.to_node.value="";
			to_yard.RemoveAll();
		}
	}
}

/**
 * W / O Issued or S / O Creation change No, Yes
 */
function fun_wosoChange(obj) {
	sheetObjects[0].RemoveAll();
	if( obj == "YES" ) {
		document.all["id_woissue"].style.display = "none";
		document.all["id_woissueno"].style.display = "inline";		

	} else {
		document.all["id_woissue"].style.display = "inline";
		document.all["id_woissueno"].style.display = "none";
	}
}