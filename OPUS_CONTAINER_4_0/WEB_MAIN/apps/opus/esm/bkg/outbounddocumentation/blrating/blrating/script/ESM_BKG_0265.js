/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0265.jsp
*@FileTitle  : Freight & Charge_Freight & Charge Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
 Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_bkg_0265 : business script for esm_bkg_0265
 */
/* developer job	*/
//common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
//	document.form.bkg_no.value = 'SEL000101306';
	if (document.form.bkg_no.value == '') {
		ComShowCodeMessage("BKG00463");
  ComClosePopup(); 
	}
	initControl();
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj=document.form;	
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
/**
* setting init control
**/
function initControl() {
//	axon_event.addListenerFormat('keypress','bkg0265_keypress',document.form);
	axon_event.addListenerFormat('beforedeactivate','bkg0265_fncCheckLength',document.form);
	axon_event.addListenerFormat('beforedeactivate','bkg0265_fncCheckLength',document.form);
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch (sheetNo) {
	case 1: //t1sheet1 init
		with (sheetObj) {
	    var HeadTitle1="";

	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	    var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	    InitHeaders(headers, info);

	    var cols = [ {Type:"Status",    Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
	              {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	     
	    InitColumns(cols);
	    SetVisible(0);
		SetEditable(1);
	    

		}
		break;
	}
}
var Freight_Charge_Remark='';
//handling of Sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: //retrieve
		ComSetObjValue(formObj.f_cmd, SEARCH);
 		var sXml=sheetObj.GetSearchData("ESM_BKG_0265GS.do", FormQueryString(formObj));
		var BKG_NO=ComGetEtcData(sXml, "BKG_NO");
		if (BKG_NO == '')
			return;
		var BL_CVRD_TP_CD=ComGetEtcData(sXml, "BL_CVRD_TP_CD");
		var INTER_RMK=ComGetEtcData(sXml, "INTER_RMK");
		var DIFF_RMK=ComGetEtcData(sXml, "DIFF_RMK");
		var MST_CVRD_BL_NO=ComGetEtcData(sXml, "MST_CVRD_BL_NO");
		var THIRD_PARTY_FREIGHT=ComGetEtcData(sXml, "THIRD_PARTY_FREIGHT");
		//1. Internal Memo for Reference
		if (typeof INTER_RMK != null && typeof INTER_RMK != "undefined" && INTER_RMK != "") {
			ComSetObjValue(formObj.inter_rmk, INTER_RMK);
		}
		//2. Freight & Charge Remark
		if (typeof DIFF_RMK != null && typeof DIFF_RMK != "undefined" && DIFF_RMK != "") {
			ComSetObjValue(formObj.diff_rmk, DIFF_RMK);
		}
		//3. MST_CVRD_BL_NO
		if (typeof MST_CVRD_BL_NO != null && typeof MST_CVRD_BL_NO != "undefined" && MST_CVRD_BL_NO != "") {
			Freight_Charge_Remark=Freight_Charge_Remark + MST_CVRD_BL_NO;
		}
		//4. THIRD_PARTY_FREIGHT
		if (typeof THIRD_PARTY_FREIGHT != null && typeof THIRD_PARTY_FREIGHT != "undefined" && THIRD_PARTY_FREIGHT != "") {
			Freight_Charge_Remark=Freight_Charge_Remark + '\r\n' + THIRD_PARTY_FREIGHT;
		}
		//Freight_Charge_Remark = Freight_Charge_Remark.split('\r\n').join("");
		break;
	case IBSAVE: // save
	if (!ComShowConfirm(ComGetMsg("BKG00350")))
		return; // Are you sure to save the changes?
		ComSetObjValue(formObj.f_cmd, MULTI);
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0265GS.do", FormQueryString(formObj));
		var State=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
		if ( State == "S" ) {
 			sheetObj.LoadSaveData(sXml);
			ComShowMessage(ComGetMsg("BKG06071"));
		}else{
			fnExceptionMessage(sXml);
		}
		break;
	}
}
// Event handler processing by button name
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btn_clause":
			if (!ComShowConfirm(ComGetMsg("BKG00197")))
				return; // Are you sure to save the changes?
			ComSetObjValue(formObject.diff_rmk, Freight_Charge_Remark);
			formObject.diff_rmk.focus();
			break;
		case "btn_close":
			ComClosePopup(); 
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
* TEXTAREA Max Length Contol<br>
* @param {object} bytes
* @return number <br>
*/
function fncCheckLength(_obj, _maxlen) {
	var objname=_obj;
	cols=parseInt(objname.cols);
	rows=parseInt(objname.rows)-2;
	//var maxlen = cols * rows;
	var maxlen=_maxlen;
	var objstr=objname.value;
	var objstrlen=objstr.length; 
	var bytesize=0; 
	var strlen=0; 
	var onechar=""; 
	var objstr2=""; 
	try {
		for (i=0; i < objstrlen; i++) {
			onechar=objstr.charAt(i);
			if (escape(onechar).length > 4) {
				bytesize += 2;
			} else {
				bytesize++; 
			}
			if (bytesize <= maxlen) {
				strlen=i + 1; 
			}
		}
		// over Max length
		if (bytesize > maxlen) { 
			objstr2=objstr.substr(0, strlen);
			objname.value=objstr2;
		}
	} catch (ex) {
		return false;
	}
	objname.focus();
}
/**
 * ENTER key control.<br>
 * @param {object} bytes
 * @return number <br>
 */
function bkg0265_fncCheckLength() {
	var srcName=ComGetEvent("name");
	if(srcName == "inter_rmk"){
		fncCheckLength(document.form.inter_rmk,'500');
	}else if(srcName == "diff_rmk"){
		fncCheckLength(document.form.diff_rmk,'500');
	}
}
/**
 * Size Check<br>
 * @param {object} bytes
 * @return number <br>
 */
String.prototype.bytes=function() {
	var str=this;
	var l=0;
	for ( var i=0; i < str.length; i++)
		l += (str.charCodeAt(i) > 128) ? 2 : 1;
	return l;
}
 /**
  * Upper Case<br>
  * @param 
  * @return  <br>
  */
 function bkg0265_keypress(){
 	var srcName=ComGetEvent("name");
 	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
 	 if(keyValue >= 97 && keyValue <= 122) {//Lower Case
          event.keyCode=keyValue + 65 - 97;
      }
 }
  /**
  * fnExceptionMessage  
  * error Message Alert
  * @param 
  * @return 
  */
  function fnExceptionMessage(rXml){
  	var rMsg=ComGetEtcData(rXml,"Exception");
  	var rmsg=rMsg.split("<||>");
  	if(rmsg[3] != undefined && rmsg[3].length > 0) {
  		ComShowMessage(rmsg[3]);
  	}else{
   		sheetObjects[0].LoadSaveData(rXml);
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


/*
 * MOUSE PASTE 이벤트
 */
function mousePaste(obj){
	setTimeout(function(){
    	checkSpecial(obj);	//특수문자 제외 로직
	}, 100)
}    

