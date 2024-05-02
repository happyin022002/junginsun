/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0059.js
*@FileTitle  : Cancel Issue Release
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/* Developer Work	*/
// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var prefix1="sheet1_";
// Event handler processing by button click event */
document.onclick=processButtonClick;
var save_success=false;
var opener=window.dialogArguments;
window.onunload=function(){	if(save_success) try{ opener.bkg_search();} catch (ex) {} }
/**
 * initializing sheet implementing onLoad event handler in body tag adding first-served functions after loading screen.
 */
function loadPage() {
	initControl();
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
 * To set the initial control
 **/
function initControl() {
	//** Date Separator **/
	DATE_SEPARATOR="-";
	var formObj=document.form;
	axon_event.addListenerFormat('focus', 'obj_activate', formObj); //- 포커스 들어갈때
	axon_event.addListenerForm('blur', 'obj_deactivate', formObj); //- 포커스 나갈때
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj); //- When typing the keyboard

}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	try {
		switch (sheetNo) {
		case 1: //t1sheet1 init
			with (sheetObj) {
	        var HeadTitle1="|||||||||||||";
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag"},
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bkg_no" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rqst_bl_tp_cd" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_rt_incl_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_rt_xcld_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_ppd_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_clt_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"obl_ttl_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"non_nego_rt_incl_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"non_nego_rt_xcld_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"non_nego_ppd_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"non_nego_clt_knt" },
	               {Type:"Int",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"cpy_ttl_knt" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rqst_iss_plc_nm" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"rqst_iss_dt" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_de_to_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_de_mzd_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"bl_doc_rqst_rmk" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix1+"loc_nm" } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetVisible(false);
			}
			break;
		}
	} catch (ex) {
		bkg_error_alert('initSheet', ex);
	}
}
// Event handler processing by button name */
function processButtonClick() {
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		/** * BUTTON BL ISSUE (r) ** */
		case "btn_confirm":
			doActionIBSheet(sheetObjects[0], document.form, IBSAVE);
			break;
		case "btn_close":
			var obj=new Object();
			obj.obl_ttl_knt=ComGetObjValue(formObject.frm_sheet1_obl_ttl_knt);
			obj.cpy_ttl_knt=ComGetObjValue(formObject.frm_sheet1_cpy_ttl_knt);
			ComPopUpReturnValue(obj);
			ComClosePopup(); 
			break;
		case "btn_pre_set":
			fnPreSet();
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
//handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var aryPrefix=new Array(prefix1);
	if (!validateForm(sheetObj, formObj, sAction)) {
		return;
	}
	switch (sAction) {
		case IBSEARCH: //Retrieve
			ComSetObjValue(formObj.f_cmd, SEARCH);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0059GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			for ( var inx=0; inx < arrXml.length; inx++) {
				sheetObjects[inx].LoadSearchData(arrXml[inx],{Sync:1} );
			}
			fnOnSearchEnd();
			break;
		case IBSAVE: //저장
			ComSetObjValue(formObj.f_cmd, MULTI);
			if (IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_")) {
			}
			var sParam=ComGetSaveString(sheetObjects);
			if (sParam == "") {
				ComShowCodeMessage('BKG00260');
				return;
			}
			sParam += "&" + FormQueryString(formObj); // hidden param value string
			sParam += "&" + ComGetPrefixParam(aryPrefix);// prefix string array
			if(ComGetUnMaskedValue(formObj.frm_sheet1_obl_ttl_knt.value,"int").length > 5
					||ComGetUnMaskedValue(formObj.frm_sheet1_cpy_ttl_knt.value,"int").length >5){
				ComShowCodeMessage('BKG08253');
				return;
			}
			if (!ComShowConfirm(ComGetMsg("BKG00498"))) {
				return;
			}
			
			var sXml=sheetObj.GetSaveData("ESM_BKG_0059GS.do", sParam);
			// result handling
			sheetObj.LoadSaveData(sXml);
			var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			if ( State == "S" ) {// result handling
				parent.sheetObjects['t11sheet1'].SetCellValue(1,"t11sheet1_rqst_bl_tp_cd",ComGetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd)); 
				sheetObj.LoadSaveData(sXml);
				ComShowMessage(ComGetMsg("BKG06071"));
				save_success=true;
			}
			break;
		}
}
/**
 * fnOnSearchEnd
 * param :sheetObj, ErrMsg
 */
function fnOnSearchEnd() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	try {
		/** =====================================
		 *  FORM VALUE BINDING
		 *  ===================================== */
		if (IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_")) {};
		//B/L Type
		var blIssTpCd = ComGetObjValue(formObj.bl_iss_tp_cd);
		if(blIssTpCd == "B"){
			blIssTpCd = "O";
		}
		fnRadioCheck('bl_tp_cd', fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd),blIssTpCd));
		//Deliver To
		fnRadioCheck('bl_de_to_cd', fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_bl_de_to_cd),""));
		//Method
		fnRadioCheck('bl_de_mzd_cd', fnNullToBlank(ComGetObjValue(formObj.frm_sheet1_bl_de_mzd_cd),""));
		var formObj=document.form;
		ComSetObjValue(formObj.frm_sheet1_obl_rt_incl_knt, ComAddComma(formObj.frm_sheet1_obl_rt_incl_knt));
		ComSetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt, ComAddComma(formObj.frm_sheet1_obl_rt_xcld_knt));
		ComSetObjValue(formObj.frm_sheet1_obl_ppd_knt, ComAddComma(formObj.frm_sheet1_obl_ppd_knt));
		ComSetObjValue(formObj.frm_sheet1_obl_clt_knt, ComAddComma(formObj.frm_sheet1_obl_clt_knt));
		ComSetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt, ComAddComma(formObj.frm_sheet1_non_nego_rt_incl_knt));
		ComSetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt, ComAddComma(formObj.frm_sheet1_non_nego_rt_xcld_knt));
		ComSetObjValue(formObj.frm_sheet1_non_nego_ppd_knt, ComAddComma(formObj.frm_sheet1_non_nego_ppd_knt));
		ComSetObjValue(formObj.frm_sheet1_non_nego_clt_knt, ComAddComma(formObj.frm_sheet1_non_nego_clt_knt));
		ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt, ComAddComma(formObj.frm_sheet1_obl_ttl_knt));
		ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt, ComAddComma(formObj.frm_sheet1_cpy_ttl_knt));
	} catch (ex) {
		bkg_error_alert('fnOnSearchEnd', ex);
		return false;
	}
}
/**
* fnPreSet
* 
*/
function fnPreSet() {
	var formObj=document.form;
	ComSetObjValue(formObj.frm_sheet1_obl_rt_incl_knt, 0);
	ComSetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt, 3);
	ComSetObjValue(formObj.frm_sheet1_obl_ppd_knt, 0);
	ComSetObjValue(formObj.frm_sheet1_obl_clt_knt, 0);
	ComSetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt, 5);
	ComSetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt, 5);
	ComSetObjValue(formObj.frm_sheet1_non_nego_ppd_knt, 0);
	ComSetObjValue(formObj.frm_sheet1_non_nego_clt_knt, 0);
	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,3);
	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,10);
	//return true;
}
/**
* fnRadioCheck
* param : v_obj, v_value
*/
function fnRadioCheck(v_obj, v_value) {
	var radio=document.getElementsByName(v_obj);
	if (radio == null)
		return;
	for ( var i=0; i < radio.length; i++) {
		if (radio[i].value == v_value) {
			radio[i].checked=true;
			break;
		}
	}
}
/**
* fnNullToBlank
* param : xval,yval
*/
function fnNullToBlank(xval,yval) {
    return (xval!= null && xval != "") ? xval : yval;
 } 
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // search   
		if (ComGetObjValue(formObj.bkg_no) == ''){
			ComShowCodeMessage("BKG00463");
			return false;
		}
		break;
	case IBSAVE: // save
		//B/L Type 
		ComSetObjValue(formObj.frm_sheet1_rqst_bl_tp_cd,ComGetObjValue(formObj.bl_tp_cd));
		//Deliver To	
		ComSetObjValue(formObj.frm_sheet1_bl_de_to_cd, ComGetObjValue(formObj.bl_de_to_cd));
		//Method
		ComSetObjValue(formObj.frm_sheet1_bl_de_mzd_cd, ComGetObjValue(formObj.bl_de_mzd_cd));
		break;
	}
	return true;
}
 /**
  * onblur event Validation check. <br>
  **/
 function obj_activate() {
 	//input Validation check
 	switch (event.srcElement.name) {
 	case "frm_sheet1_rqst_iss_dt":
 		ComClearSeparator(event.srcElement);
 		break;
 	default:
 		break;
 	}
 }
 /**
  * onblur event Validation check. <br>
  **/
 function obj_deactivate() {
	  var formObj=document.form;
	  //input Validation check
 	switch (event.srcElement.name) {
 	case "frm_sheet1_rqst_iss_dt":
 		ComAddSeparator(event.srcElement);
 		break;
 	case "frm_sheet1_obl_rt_incl_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_clt_knt),"int"),10); 		
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,ComAddComma(sum));
 		break;
 	case "frm_sheet1_obl_rt_xcld_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_clt_knt),"int"),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,ComAddComma(sum));
 		break; 
 	case "frm_sheet1_obl_ppd_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_clt_knt),"int"),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,ComAddComma(sum));
 		break; 
 	case "frm_sheet1_obl_clt_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_obl_clt_knt),"int"),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_obl_ttl_knt,ComAddComma(sum));
 		break; 
 	case "frm_sheet1_non_nego_rt_incl_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_clt_knt),"int"),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,ComAddComma(sum));
 		break;
 	case "frm_sheet1_non_nego_rt_xcld_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_clt_knt),"int"),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,ComAddComma(sum));
 		break;  	
 	case "frm_sheet1_non_nego_ppd_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_clt_knt),"int"),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,ComAddComma(sum));
 		break;  
 	case "frm_sheet1_non_nego_clt_knt":
 		var sum=parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_incl_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_rt_xcld_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_ppd_knt),"int"),10)+parseInt(ComGetUnMaskedValue(ComGetObjValue(formObj.frm_sheet1_non_nego_clt_knt),"int"),10);
 		if (!isNaN(sum))	ComSetObjValue(formObj.frm_sheet1_cpy_ttl_knt,ComAddComma(sum));
 		break;  
 	default:
 		break;
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
 * bkg_error_alert
 * param : msg, ex
 */
function bkg_error_alert(msg, ex) {
	alert('[ ' + msg + ' ]=[ ' + ex.name + ' ][ ' + ex.number + ' ][ ' + ex.description + ' ]');
}

function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/* Developer Work End */
