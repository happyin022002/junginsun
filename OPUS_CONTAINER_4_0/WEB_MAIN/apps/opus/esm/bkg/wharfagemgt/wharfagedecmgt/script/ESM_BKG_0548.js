/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName :esm_bkg_0548.js
 *@FileTitle : Customer Code Entry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/05
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/** *** using extra sheet valuable if there are more 2 sheets **** */
	var sheetObject1=sheetObjects[0];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, document.form, SEARCH01);
			break;
		case "btn_save":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND02);
			doActionIBSheet(sheetObject1, document.form, SEARCH01);
			break;
		case "btn_new":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND01);
			break;
		case "btn_DataIF":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND03);
			break;
		case "btn_LocationCode":
			doActionIBSheet(sheetObjects[0], document.form, COMMAND04);
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
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	initControl();
}
/**
* init control
*/
function initControl() {
	var formObject=document.form;
	axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObject);
	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", formObject);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	axon_event.addListenerForm('change', 'obj_Change', document.form);
	axon_event.addListener("change", "obj_OnChange", "vvd", "vps_port_cd", "io_bnd_cd");
	axon_event.addListenerForm("focus", "obj_Focus", document.form);
	formObject.vvd.focus();
}
 /**
  * handling process for KeyUp
  */
function obj_KeyUp() {
	if (window.event.keyCode == 9 || window.event.keyCode == 16) {
		return false;
	}
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	//var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcMaxLength=ComGetEvent("maxlength");
	//var srcValue=window.event.srcElement.getAttribute("value");
	var srcValue=ComGetEvent("value");	
	if (ComChkLen(srcValue, srcMaxLength) == "2") {
		ComSetNextFocus();
	}	
}
 /**
  * object change handling 
  */

function obj_OnChange() {
	var srcName=ComGetEvent("name");
	// call Service and retrieve MRN No and ETA Info in case of change VVD, Port, Bound 
	if (srcName == "vvd" || srcName == "vps_port_cd" || srcName == "io_bnd_cd") {
		var formObject=document.form;
		if ((ComChkLen(formObject.vvd.value, 9) == "2")
				&& (ComChkLen(formObject.vps_port_cd.value, 5) == "2")) {
			doActionIBSheet(sheetObjects[0], formObject, SEARCH);
		}		
	}	
	// update Sheet Status in case of change data
	sheetObjects[0].SetCellValue(1, 0,'U');
}
/**
 * on focus handling 
 */
function obj_Focus() {
	if (window.event.srcElement.getAttribute("type") == "text") {
		window.event.srcElement.select();
	}
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
* @param sheetObj sheet Object
* @param sheetNo 
*/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1": // sheet1 init
	    with(sheetObj){
        
      var HeadTitle1="|vvd|vps_port_cd|io_bnd_cd|vps_dt|mrn_no|mrn_chk_no|vsl_call_sgn_cd |tml_cd |arr_tms_no |arr_yr |io_port_cd |unld_tp_cd |unld_agn_cd1 |unld_agn_cd2 |unld_agn_cd3 |whf_vol_dc_cd |whf_rt |mf_ref_no |whf_pay_dt |port_nm |vsl_nm |sail_dt|vps_dt|pay_dt|upd_usr_id|upd_dt";
      var prefix='sheet1_';

      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
             {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd" },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_bnd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:500 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mrn_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mrn_chk_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_call_sgn_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"tml_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_tms_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_yr",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"io_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unld_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unld_agn_cd1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unld_agn_cd2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unld_agn_cd3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_vol_dc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_rt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mf_ref_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"whf_pay_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"sail_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vps_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0,  Width:490,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 } ];
       
      InitColumns(cols);

      SetEditable(1);
      SetColProperty(prefix+"vps_dt", {Format:"####-##-##"} );
      SetColProperty(prefix+"whf_pay_dt", {Format:"####-##-##"} );
      SetColProperty(prefix+"pay_dt", {Format:"####-##-##"} );
      //SetSheetHeight(0);
      SetVisible(0);
            }
		break;
	}
}
/**
 * Sheet process handling
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case SEARCH:
		
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH;
			var aryPrefix=new Array("sheet1_");
 			var sXml=sheetObj.GetSearchData("ESM_BKG_0548GS.do",FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			var mrnNo="";
			var vpsDt="";
			var mrnChkNo="";
			var tmlCd="";
			var unldAgnCd1="";
			var unldAgnCd2="";
			var unldAgnCd3="";
			var whfRt="";
			mrnNo=ComGetEtcData(arrXml[0], "mrn_no");
			if (mrnNo != "") {
				vpsDt=ComGetEtcData(arrXml[0], "vps_dt");
				mrnChkNo=ComGetEtcData(arrXml[0], "mrn_chk_no");
			}
			tmlCd=ComGetEtcData(arrXml[0], "tml_cd");
			if (tmlCd != "") {
				unldAgnCd1=ComGetEtcData(arrXml[0], "unld_agn_cd1");
				unldAgnCd2=ComGetEtcData(arrXml[0], "unld_agn_cd2");
				unldAgnCd3=ComGetEtcData(arrXml[0], "unld_agn_cd3");
				whfRt=ComGetEtcData(arrXml[0], "whf_rt");
			}
			formObj.vps_dt.value=vpsDt;
			formObj.mrn_no.value=mrnNo + mrnChkNo;
			formObj.tml_cd.value=tmlCd;
			formObj.unld_agn_cd1.value=unldAgnCd1;
			formObj.unld_agn_cd2.value=unldAgnCd2;
			formObj.unld_agn_cd3.value=unldAgnCd3;
			formObj.whf_rt.value=whfRt;
			if (arrXml[1] != "") {
				ComBkgXml2ComboItem(arrXml[1], io_port_cd, "brth_cd","brth_cd");
			}
			var brthCd=sheetObjects[0].GetCellValue(1, 11);
			if (brthCd != '')
				ComSetObjValue(io_port_cd, brthCd);
			if (ComChkLen(formObj.vps_port_cd.value, 5) != "2")
				formObj.vps_port_cd.focus();
			else
				formObj.io_bnd_cd.focus();
			formObj.port_cd.value=formObj.vps_port_cd.value;
			formObj.whf_bnd_cd.value=formObj.io_bnd_cd.value;
			if (vpsDt != '')
				formObj.whf_pay_dt.value=ComGetDateAdd(vpsDt, "D", "29", "-");
			else
				formObj.whf_pay_dt.value='';
		}
		break;
	case SEARCH01: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH01;
			sheetObj.DoSearch("ESM_BKG_0548GS.do", FormQueryString(formObj)	+ "&" + ComGetPrefixParam("sheet1_") );

		}
		break;
	case SEARCH02: 
		if( validateForm(sheetObj,formObj,sAction) ){
			formObj.f_cmd.value=SEARCH02;
			var aryPrefix=new Array("sheet1_");
 			var sXml=sheetObj.GetSearchData("ESM_BKG_0548GS.do",FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			var brthKrNm="";
			if (ComGetEtcData(arrXml[0], "brth_kr_nm") != "") {
				formObj.port_nm.value=ComGetEtcData(arrXml[0], "brth_kr_nm");
			}
		}
	break;	
	case MULTI: // Save
		IBS_CopyFormToRow(formObj, sheetObj, 1, "");
		break;
	case COMMAND02: // Save
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sParam=ComGetSaveString(sheetObjects);
			sParam += "&" + FormQueryString(formObj) + "&"
					+ ComGetPrefixParam("sheet1_");
 			var SaveXml=sheetObj.GetSaveData("ESM_BKG_0548GS.do", sParam);
 			var xml=sheetObj.LoadSaveData(SaveXml);
			ComOpenWait(false);
		}
		break;
	case COMMAND01: // New
		ComResetAll();
		ComSetFocus(formObj.vvd);
		break;
	case COMMAND03: // Popup - Korea Wharfage - Data Interface
		if (validateForm(sheetObj, formObj, sAction))
			ComOpenWindowCenter("ESM_BKG_0549.do?pgmNo=ESM_BKG_0549" + "&vvd="
					+ formObj.vvd.value + "&whf_pol_cd="
					+ formObj.vps_port_cd.value + "&whf_bnd_cd="
					+ formObj.io_bnd_cd.value + "&mrn_no="
					+ formObj.mrn_no.value, "ESM_BKG_0549", 750, 550, false);
		break;
	case COMMAND04: // Popup - Wharfage Vessel Information - Location Code
		if (validateForm(sheetObj, formObj, sAction))
			ComOpenWindowCenter("ESM_BKG_0733.do?pgmNo=ESM_BKG_0733"
					+ "&loc_cd=" + formObj.vps_port_cd.value, "ESM_BKG_0733",
					795, 560, false);
		break;
	}
}


function sheet1_OnSearchEnd(sheetObj, Code, Msg) { 
	var formObj = document.form;
	if (sheetObjects[0].RowCount() > 0) {	//NODATA일 경우 -1 값이 넘어와 오류발생 조건처리		
		formObj.vsl_call_sgn_cd.value=sheetObjects[0].GetCellValue(1, 7);
		formObj.unld_agn_cd1.value=sheetObjects[0].GetCellValue(1, 13);
		formObj.unld_agn_cd2.value=sheetObjects[0].GetCellValue(1, 14);
		formObj.unld_agn_cd3.value=sheetObjects[0].GetCellValue(1, 15);
		formObj.tml_cd.value=sheetObjects[0].GetCellValue(1, 8);
		
		formObj.whf_rt.value=ComAddComma2(sheetObjects[0].GetCellValue(1, 17), "#,###.0");
		
		formObj.arr_yr.value=sheetObjects[0].GetCellValue(1, 10);
		formObj.arr_tms_no.value=sheetObjects[0].GetCellValue(1, 9);
		var unld_tp_cd=sheetObjects[0].GetCellValue(1, 12);
		if ('1' == unld_tp_cd)
			formObj.unld_tp_cd[0].checked=true;
		if ('2' == unld_tp_cd)
			formObj.unld_tp_cd[1].checked=true;
		ComSetObjValue(io_port_cd, sheetObjects[0].GetCellValue(1, 11));
		if (sheetObjects[0].GetCellValue(1, 23) != '') // ComGetDateAdd("2008-01-01",
			// "D", 365, "")
			formObj.whf_pay_dt.value=ComGetDateAdd(sheetObjects[0].GetCellValue(1, 23), "D", 0, "-");
			formObj.whf_vol_dc_cd.value=( sheetObjects[0].GetCellValue(1, 16) == '') ? '0':sheetObjects[0].GetCellValue(1, 16)  ;
			formObj.port_nm.value=sheetObjects[0].GetCellValue(1, 20);
			formObj.upd_id.value=sheetObjects[0].GetCellValue(1, 24);
			formObj.upd_dt.value=sheetObjects[0].GetCellValue(1, 25);
			formObj.vsl_nm.value=sheetObjects[0].GetCellValue(1, 26);
		
	}	
}

 /**
 * handling process for input validation
 * @param sheetObj sheet Object
 * @param formObj  form Object
 * @param sAction 
 */
function validateForm(sheetObj, formObj, sAction) {
	var vvd=formObj.vvd.value;
	var vpsPortCd=formObj.vps_port_cd.value;
	var ioBndCd=formObj.io_bnd_cd.value;
	switch (sAction) {
	case SEARCH01:
		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00887', 'vvd');
			formObj.vvd.focus();
			return false;
		}
		if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00887', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}
		return true;
		break;
	case SEARCH02:
		return true;
		break;
	case SEARCH:
		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00887', 'VVD');
			return false;
		}
		if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00887', 'Port');
			return false;
		}
		return true;
		break;
	case MULTI: // Save
		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00715', 'VVD');
			formObj.vvd.focus();
			return false;
		} else if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00715', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}
		if (!ComShowConfirm(ComGetMsg("BKG00498")))
			return false;
		return true;
		break;
	case COMMAND02: // Save
		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00715', 'VVD');
			formObj.vvd.focus();
			return false;
		} else if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00715', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND01: // Init screen
		if (sheetObjects[0].IsDataModified()) {
			if (!ComShowConfirm(ComGetMsg("BKG00386"))) {
				return true;
			} else {
				return false;
			}
		}
		return true;
		break;
	case COMMAND03: // Init Screen
		if (ComChkLen(vvd, 9) != "2") {
			ComShowCodeMessage('BKG00887', 'vvd');
			formObj.vvd.focus();
			return false;
		}
		if (ComChkLen(vpsPortCd, 5) != "2") {
			ComShowCodeMessage('BKG00887', 'Port');
			formObj.vps_port_cd.focus();
			return false;
		}
		return true;
		break;
	case COMMAND04: // Init Screen
		return true;
		break;
	}
}
/**
 * on focusing at In/Out port Code
 */
function moveIoPortCd() {
	io_port_cd.focus();
}
 /**
  * combobox(In/Out PortCd) change handling 
  * @param comboObj
  * @param value
  * @param text
  * @return
  */
function io_port_cd_OnChange(comboObj, value, text){
	doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
}
 /**
   * object change handling 
   */
 function obj_Change() {
 	var formObject=document.form;
 	var srcName=ComGetEvent("name");
 	if (srcName == "io_bnd_cd") { 		
 		var vvd=formObject.vvd.value
 		var vps_port_cd=formObject.vps_port_cd.value
 		var io_bnd_cd=formObject.io_bnd_cd.value
 		//var vps_dt = formObject.vps_dt.value
 		ComResetAll();
 		formObject.vvd.value=vvd;
 		formObject.vps_port_cd.value=vps_port_cd;
 		formObject.io_bnd_cd.value=io_bnd_cd;
 		//formObject.vps_dt.value = vps_dt;
 	}
 }
