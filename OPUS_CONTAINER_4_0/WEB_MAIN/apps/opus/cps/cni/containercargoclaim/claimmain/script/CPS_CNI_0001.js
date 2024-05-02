/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0001.js
*@FileTitle  : [CPS_GEM_0001]  Client Default Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/**
 * [CPS_CNI_0001]Client Default Setup
 * @extends
 * @class business script for Client Default Setup 
 */

// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
// common type Main Code Inquiry
var type="";
// Area Name Array
var names=new Array();
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage(year) {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    var xml=frm.sXml.value;    
	var list=SheetXml2ListMap(xml);
	var combo=frm.clm_area_cd;
	var clmAreaCd=frm.clmAreaCd.value;
	var j = 0;
	for(var i=0 ; i < list.length; i++) {
		var arrData = list[i];
		if (arrData != undefined) {
			ComAddComboItem(combo ,arrData["code"] , arrData["code"]);
			names[j++]=arrData["name"];
		}
	}
	if (ComIsNull(clmAreaCd)) {		 
		frm.clm_area_nm.value=names[0];
	} else {
		combo.value=clmAreaCd;
		frm.clm_area_nm.value=names[combo.selectedIndex];
	}
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
			SetConfig( { SearchMode:2, DataRowMerge:0 } );
			var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
			var headers ="";
			InitHeaders(headers, info);
			var cols = [{}];
			InitColumns(cols);
			break;		
		}
	}
}
// Event handler processing by button click event
	document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
	function processButtonClick() {
	var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	 	
		case "btn1_Save":
			//msgs["CNI00012"] = "Data was changed. Do you want to save it?";
			if (ComShowCodeConfirm("CNI00012")) {
				doActionIBSheet(MULTI);
			} 
			break;	        
		case "btn1_Close":			
			ComClosePopup(); 
	        break;	  
		case "btn1_Test":			
			popupClientDefaultSetup();
	        break;	  
	}
}
/**
* setting change area
*/
function onchangeClmAreaCd() {	
	var combo=frm.clm_area_cd;	
	frm.clm_area_nm.value=names[combo.selectedIndex];
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == MULTI) {		
		var codeVal = document.form.clm_area_cd.value;
		frm.f_cmd.value=MULTI;		
		var param="f_cmd=" + MULTI;
		param += "&" + FormQueryString(frm);
 		var sXml=sheet1.GetSearchData("CPS_CNI_0001GS.do", param);
		sheet1.LoadSearchData(sXml,{Sync:1} );
		if (opener.temp1 != "undifind" ){
			if(!opener) opener = parent;
			opener.temp1 = codeVal;
		}
	}
}

