/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0649.js
*@FileTitle  : Cancel Issue Release
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG_0649 : business script for ESM_BKG_0649
 */
function ESM_BKG_0649() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
var prefix2="sheet2_";
var prefix3="sheet3_";
var dirty_flag="N";
var bf_frm_sheet2_riss_rsn="";
// Event handler processing by button click event  */
document.onclick=processButtonClick;
/**
 * initializing sheet 
 * implementing onLoad event handler in body tag 
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;	
	initControl();
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initComboSetVal(sheetObjects[0], formObj);
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
}
/**
 * restering init event
 **/
function initControl() {
	DATE_SEPARATOR="-";
	var formObj=document.form;
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObj); // -
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', formObj); // -
//	axon_event.addListenerFormat('keypress', 'obj_keypress', formObj); // -
//	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //
//	axon_event.addListener('keydown', 'check_Enter', 'form');
}
/**
 * retrieving combo data
 **/
function initComboSetVal(sheetObj, formObj) {
	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
	var param=FormQueryString(formObj);
	param=param + "&cm_code=CD01648";
	var sXml=sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	var arrXml=sXml.split("|$$|");
	if (arrXml[0].length > 0) {
		ComXml2ComboItem(arrXml[0], bl_riss_rsn_cd, "val", "name");
	}
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with(sheetObj){
			
			var HeadTitle1="|||||||";			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_no" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_tp_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"shipper_code" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"shipper_name" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_iss_knt" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_srnd_flg" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_iss_flg" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"do_yn" } ];
			   
			InitColumns(cols);
			//SetSheetHeight(0);
			SetVisible(0);
			SetEditable(1);
			//SetGetCountPosition()(0);
        }
		break;
	case 2: //t1sheet1 init
		with(sheetObj){
			var HeadTitle1="||||||||";
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"ibflag" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"bkg_no" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"his_seq" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"bkg_evnt_knd_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"riss_flg" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"bl_riss_rsn_cd" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"riss_rsn" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix2+"iss_cxl_flg" }];
			   
			InitColumns(cols);
			SetVisible(0);
			SetEditable(1);
			//SetGetCountPosition()(0);
        }
		break;
	case 3: //sheet1 init
		with(sheetObj){
			var HeadTitle1="||No|Office|By|Date|";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"ibflag" },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"his_seq" },
			 {Type:"Int",       Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix3+"iss_rdem_knt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix3+"evnt_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix3+"evnt_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Popup",     Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"evnt_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix3+"obl_rdem_cfm_flg" } ];
			   
			InitColumns(cols);
			SetEditable(1);
			//SetSheetHeight(82);
			//82 is less than min-value
			SetSheetHeight(150);
			//SetGetCountPosition()(0);
			SetShowButtonImage(1);
			SetColProperty(0 ,prefix3 + "evnt_ofc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
			SetColProperty(0 ,prefix3 + "evnt_usr_id" , {AcceptKeys:"E" , InputCaseSensitive:1});
			SetDataLinkMouse(prefix3 + "evnt_dt",1);
		}
		break;
	}
}
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(!processValidate(srcName)) return; 
		switch (srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
				break;
			case "btn_Confirm":
				if(ComGetObjValue(formObj.frm_sheet1_obl_released_flg)== 'Y' && ComGetObjValue(formObj.frm_sheet1_bl_tp_cd)== 'W' )
				{
					ComSetObjValue(formObj.setupfocoblflag, 'Y');
				}
				doActionIBSheet(sheetObjects[0],document.form,MULTI01);
				break;
			case "btn_Close":
				ComClosePopup(); 
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
* checking validation 
* param :comObj
*/
function processValidate(_action) {
	var formObj=document.form;
	switch (_action) {
	case "btn_Retrieve":
//		if("Y" == dirty_flag || bf_frm_sheet2_riss_rsn != formObj.frm_sheet2_riss_rsn.value ) {
//			if(!confirm(ComGetMsg("BKG95056"))){
//				return false;
//			}
//		}
		break;
	case "btn_Save":
		if(ComGetLenByByte(formObj.frm_sheet2_riss_rsn.value) > 4000){
			ComShowCodeMessage('BKG00107', '[maximum:4000]');
			return false;
		}
		break;
	}
	return true;
}			
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array(prefix1, prefix2, prefix3);
	if (!validateForm(sheetObj, formObj, sAction)) return;
	switch (sAction) {
		case IBSEARCH: 
//			if("Y" == dirty_flag || bf_frm_sheet2_riss_rsn != formObj.frm_sheet2_riss_rsn.value ) {
//				if(confirm(ComGetMsg("BKG95056"))){
//					doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
//					return false;
//				}
//			}
			ComSetObjValue(formObj.f_cmd, SEARCH);
			ComSetObjValue(formObj.bl_no,ComGetObjValue(formObj.frm_sheet1_bl_no));
			ComSetObjValue(formObj.bkg_no,ComGetObjValue(formObj.frm_sheet1_bkg_no));
			var sXml=sheetObj.GetSearchData("ESM_BKG_0649GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			//ComResetAll();
			var arrXml=sXml.split("|$$|");
			var State=ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY");
			if ( State == "S" ) {
				for ( var inx=0; inx < arrXml.length; inx++) {
					sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
				}	
				if (IBS_CopyRowToForm(sheetObjects[0], formObj, 1, "frm_")) {
				}
				;
				fnOnSearchEnd();
				if(-1 != sheetObjects[1].GetCellValue(1,"sheet2_bl_riss_rsn_cd")){
					bl_riss_rsn_cd.SetSelectCode(sheetObjects[1].GetCellValue(1,"sheet2_bl_riss_rsn_cd"));
				}
				if(-1 != sheetObjects[1].GetCellValue(1,"sheet2_riss_rsn")){
					ComSetObjValue(formObj.frm_sheet2_riss_rsn,sheetObjects[1].GetCellValue(1,"sheet2_riss_rsn"));
				}
			}else{
				fnExceptionMessage(sXml);
			}
			
			dirty_flag =="N";
			break;
		case IBSAVE: 
			if (!ComShowConfirm(ComGetMsg("BKG00824"))) {//"Do you want to Save your Changes?";
				return;
			}
			ComSetObjValue(formObj.f_cmd, MULTI);
			ComSetObjValue(formObj.bkg_no,ComGetObjValue(formObj.frm_sheet1_bkg_no));	
			// select box :  bl_riss_rsn_cd 		
			ComSetObjValue(formObj.frm_sheet2_bl_riss_rsn_cd,ComGetObjValue(formObj.bl_riss_rsn_cd));
			
			if(sheetObjects[1].RowCount()==0){
				sheetObjects[1].DataInsert();
			}
			//setting changed value in sheet
			if (IBS_CopyFormToRow(formObj, sheetObjects[1], 1, "frm_")) {}
			var sParam=ComGetSaveString(sheetObjects);
			sParam += "&" + FormQueryString(formObj); 
			sParam += "&" + ComGetPrefixParam(aryPrefix);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0649GS.do", sParam);
			var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			if ( State == "S" ) {
				sheetObj.LoadSaveData(sXml);
				ComShowMessage(ComGetMsg("BKG06071"));
				dirty_flag="N";
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			}else{
				fnExceptionMessage(sXml);
			}
			break;
		case MULTI01: 
			if (!ComShowConfirm(ComGetMsg("BKG00618"))) {//"Would you really want to confirm?";
				return;
			}
			ComSetObjValue(formObj.f_cmd, MULTI01);
			ComSetObjValue(formObj.bkg_no,ComGetObjValue(formObj.frm_sheet1_bkg_no));	
			// select box :  bl_riss_rsn_cd 		
			ComSetObjValue(formObj.frm_sheet2_bl_riss_rsn_cd,ComGetObjValue(formObj.bl_riss_rsn_cd));
			
			if(sheetObjects[1].RowCount()==0){
				sheetObjects[1].DataInsert();
			}
			sheetObjects[1].SetCellValue(1,aryPrefix[1] + "iss_cxl_flg","Y");
			//setting change value in sheet
			if (IBS_CopyFormToRow(formObj, sheetObjects[1], 1, "frm_")) {
				
			}
			var sParam=ComGetSaveString(sheetObjects);
			sParam += "&" + FormQueryString(formObj); 
			sParam += "&" + ComGetPrefixParam(aryPrefix);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0649GS.do", sParam);
			var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			if ( State == "S" ) {
				sheetObj.LoadSaveData(sXml);
				rValueClose();
			}else{
				fnExceptionMessage(sXml);
			}
			break;
		}
}
/**
* rValueSave 
*/
function rValueClose() {
	if('Y' == document.form.isPopUp.value){
		var obj=new Object();
		obj.msg="OK";
		ComPopUpReturnValue(obj);
	}else{
		ComShowMessage("Data confirm Successfully !");
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var sheetObject2=sheetObjects[2];
	switch (sAction) {
		case IBSEARCH: // search 
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == '' && ComGetObjValue(formObj.frm_sheet1_bl_no)  == '') {
				return false;
			}
			if(ComGetObjValue(formObj.bl_no).substring(0, 12) != ComGetObjValue(formObj.frm_sheet1_bl_no)){
				return true;
			}
			break;
		case IBSAVE: // save
			if (ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bl_no);
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == ''|| ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				return;
			}
			if( ComGetObjValue(formObj.bl_no).substring(0, 12) != ComGetObjValue(formObj.frm_sheet1_bl_no)){
				ComShowCodeMessage("BKG00012");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00457");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_iss_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_iss_flg).toUpperCase() != 'Y') {
				ComShowCodeMessage("BKG00478");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_do_yn) != '' && ComGetObjValue(formObj.frm_sheet1_do_yn).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00434");
				return false;
			}
			var rCnt=sheetObject2.RowCount();
			for (i=1; i <= rCnt; i++) {
				sheetObject2.SetCellValue(i, prefix3 + "obl_rdem_cfm_flg","N",0);
			}
			break;
		case MULTI01: // confirm
			if( ComGetObjValue(formObj.bl_no).substring(0, 12) != ComGetObjValue(formObj.frm_sheet1_bl_no)){
				ComShowCodeMessage("BKG00012");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_bkg_no) == ''|| ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				return;
			}
			if (ComGetObjValue(formObj.frm_sheet1_bl_no) == '') {
				ComShowCodeMessage("BKG00445");
				ComSetFocus(formObj.frm_sheet1_bl_no);
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_srnd_flg).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00457");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_obl_iss_flg) != '' && ComGetObjValue(formObj.frm_sheet1_obl_iss_flg).toUpperCase() != 'Y') {
				ComShowCodeMessage("BKG00478");
				return false;
			}
			if (ComGetObjValue(formObj.frm_sheet1_do_yn) != '' && ComGetObjValue(formObj.frm_sheet1_do_yn).toUpperCase() == 'Y') {
				ComShowCodeMessage("BKG00434");
				return false;
			}
			var rIndex_Code=ComGetObjValue(formObj.bl_riss_rsn_cd);
			// pass in case of Print fail/ cancle/ lost
			if (!(rIndex_Code == 'P' || rIndex_Code == 'C' || rIndex_Code == 'L')) {
				if(!fn_buttonChange()){
					return false;
				}
				// all change modify status for saving 
				var collectCount=0; // Collect count 
				var issueCount=ComGetObjValue(formObj.frm_sheet1_bl_issue_no); // Issue Count
				var cnt=sheetObject2.GetTotalRows();
				for (i=1; i <= cnt; i++) {
					collectCount=collectCount + parseInt(sheetObject2.GetCellValue(i, prefix3 + "iss_rdem_knt"));
				}
				//[compare sum]Issue Count and Collect count 
				if(collectCount != issueCount){
					ComShowCodeMessage("BKG00454");
					return false;
				}
				var rCnt=sheetObject2.RowCount();
				for (i=1; i <= rCnt; i++) {
					sheetObject2.SetCellValue(i, prefix3 + "obl_rdem_cfm_flg","Y",0);
				}
			}
		break;
	}
	return true;
}
/**
 * fnOnSearchEnd  handling after retrieving  
 * param :sheetObj, ErrMsg
 */
function fnOnSearchEnd() {
	var formObj=document.form;
	//FORM VALUE BINDING 
	with(formObj) {
//        if (IBS_CopyRowToForm(sheetObjects[1], formObj, 1, "frm_")) {
//        }
        bf_frm_sheet2_riss_rsn=formObj.frm_sheet2_riss_rsn.value ; 
       
        var sheetObject2=sheetObjects[2];
        var cnt=sheetObject2.GetTotalRows();
        // select box :  bl_riss_rsn_cd
        ComSetObjValue(formObj.bl_riss_rsn_cd, ComGetObjValue(formObj.frm_sheet2_bl_riss_rsn_cd));
        // show maximum 3 
        var limitcnt=3;
        if (cnt < limitcnt) {
            for (i=cnt; i < limitcnt; i++) {
                var Row=sheetObject2.DataInsert(-1);
                sheetObject2.SetCellValue(Row, prefix3 + "iss_rdem_knt",0,0);
            }
        }
        // all change modify status for saving  
        for (i=0; i <= limitcnt; i++) {
            sheetObject2.SetRowStatus(i,"U");
        }
        ComSetObjValue(formObj.bl_no,ComGetObjValue(formObj.frm_sheet1_bl_no));
        // setting null in case of B/L Collection value not exist 
        if(cnt == 0) {
            ComSetObjValue(formObj.bl_riss_rsn_cd, '');			// Reason
            ComSetObjValue(formObj.frm_sheet2_riss_rsn, '');	// Remark
            bf_frm_sheet2_riss_rsn=frm_sheet2_riss_rsn.value ; 
        }
	}
}
/** 
 * " handling Combo value change 
 * setting grid value in case of bl_riss_rsn_cd  change 
 * 	1. B/L Collection enable in case of B/L Type Change(B->W), Amend/Switch, Damaged  
 * 	 amend/switch=A  , type change=T , damaged =D
 * @param comboObj, Index_Code, Text
 */
 var rIndex_Code='';
function bl_riss_rsn_cd_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
	var formObj=document.form;
	var sheetObject2=sheetObjects[2];
	dirty_flag="Y";
	if(sheetObject2.GetTotalRows()== 0) return;
	if (bl_riss_rsn_cd.GetSelectCode() == 'A' || bl_riss_rsn_cd.GetSelectCode() == 'D' || bl_riss_rsn_cd.GetSelectCode() == 'T') {
		sheetObject2.SetEditable(1);
		//ComBtnEnable("btn_Save");
		//ComBtnEnable("btn_Confirm");
	} else {
		sheetObject2.SetEditable(0);
		//ComBtnDisable("btn_Save");
		//ComBtnDisable("btn_Confirm");
	}	
	rIndex_Code=bl_riss_rsn_cd.GetSelectCode();
	/*	
	 1. initialize B/L Collection info in case of Reason is not  B/L Type Change(B->W), Amend/Switch, Damaged
	*/
	if (rIndex_Code == 'P' || rIndex_Code == 'C' || rIndex_Code == 'L'){
		var limitcnt=3;
		var cnt=fnNullToBlank(ComGetObjValue(document.form.frm_sheet1_bl_issue_no), 0)// Issue Count	
		if (cnt < limitcnt) {
			for (i=cnt+1; i < limitcnt+1; i++) {
				sheetObject2.SetCellValue(i, prefix3 + "iss_rdem_knt",0,0);
				sheetObject2.SetCellValue(i, prefix3 + "evnt_ofc_cd","",0);
				sheetObject2.SetCellValue(i, prefix3 + "evnt_usr_id","",0);
				sheetObject2.SetCellValue(i, prefix3 + "evnt_dt","",0);
			}
		}
	}
}
/**
 * handling  OnKeyUp event of sheet column 
 * @param sheetObj, Row, Col, Value
 */
function sheet3_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	if (sheetObj.ColSaveName(Col) == prefix3 + "iss_rdem_knt") {
		dirty_flag="Y";
		var no=sheetObj.GetCellValue(Row, Col);
		if (parseInt(no) > 0) {
			sheetObj.SetCellValue(Row, prefix3 + "iss_rdem_knt",no,0);
			sheetObj.SetCellValue(Row, prefix3 + "evnt_ofc_cd",ComGetObjValue(formObj.strOfc_cd),0);
			sheetObj.SetCellValue(Row, prefix3 + "evnt_usr_id",ComGetObjValue(formObj.strUsr_id),0);
			sheetObj.SetCellValue(Row, prefix3 + "evnt_dt",ComGetNowInfo(),0);
		}else{
			sheetObj.SetCellValue(Row, prefix3 + "evnt_ofc_cd","",0);
			sheetObj.SetCellValue(Row, prefix3 + "evnt_usr_id","",0);
			sheetObj.SetCellValue(Row, prefix3 + "evnt_dt","",0);
		}
	}
}
/**
* fn_buttonChange, button enable or disable 
*/
function fn_buttonChange(){
	var formObj=document.form;
	var sheetObj=sheetObjects[2];
	var collectCount=0; // Collect count 
	var issueCount=fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_bl_issue_no), 0)// Issue Count
	var cnt=sheetObj.GetTotalRows();
	dirty_flag="Y";
	for (i=1; i <= cnt; i++) {
		collectCount=collectCount + parseInt(sheetObj.GetCellValue(i, prefix3 + "iss_rdem_knt"));
	}
	//[compare sum]Issue Count and Collect count 
	if(collectCount != issueCount){
		ComShowCodeMessage("BKG08068");
		return false;
	}
	return true;
}
/**
* fnNullToBlank
* return default value in case of null
* param : xval,yval
*/
function fnNullToBlank(xval, yval) {
	return (xval != null && xval != "") ? xval : yval;
}
 /**
  * handling when popup click on IBSheet Object에서 팝업을 클릭시
 */
function sheet3_OnPopupClick(sheetObj, Row,Col){
  if (sheetObj.ColSaveName(Col) == prefix3 + "evnt_dt") {
	  var cal=new ComCalendarGrid();
	    cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
}
 /* retrieveing enter key press on search conditions*/
 function check_Enter() {
 	var formObj=document.form;
 	if (event.keyCode == 13) {
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
 	}
 }
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
 /**
 * fnExceptionMessage 
 */
 function fnExceptionMessage(rXml){
	var formObj=document.form;

 	if(rXml.indexOf("BKG00457") != -1){
 		ComShowMessage(ComGetMsg("BKG00457"));
 	}else{
 		sheetObjects[0].LoadSaveData(rXml);
 	}
 	ComResetAll();
	ComSetFocus(formObj.frm_sheet1_bkg_no);
 }
