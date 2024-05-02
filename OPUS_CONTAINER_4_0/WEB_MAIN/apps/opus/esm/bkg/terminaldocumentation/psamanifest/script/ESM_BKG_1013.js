/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1013.js
*@FileTitle  : PSA Vessel Registeration : Import Schedule
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
/**
 * Function definition for creating JSDOC 
 */

//Common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
//Event Handler definition for Button Click event */
document.onclick=processButtonClick;
//Event Handler for branch processing by judging button name */
function processButtonClick(){
	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_calendar1":
			var cal=new ComCalendarFromTo(); 
			cal.select(formObject.etb_dt1,formObject.etb_dt2, 'yyyy-MM-dd'); 
			break;
		case "btn_Close":
			ComClosePopup(); 
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
 /**
  * Registering IBSheet Object in to Array
  * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
  * The array is defined at upper part of source
  * @param sheet_obj IBSheet Object
  */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
   /**
    * Sheet basic setting & initializing
    * onLoad Event HandlerImplementation of body tag
    * After loading screen in the browser, add function in pre-processing
    */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// Key 입력 처리
//	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
//	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	document.form.port_cd.focus();
}
     /**
      * Definition for sheet initial setting value, header
      * param : sheetObj ==> sheet object, 
      * sheetNo ==> If the serial number ID tag attached to the sheet are many,
      * adding 'Case' clause as a number of sheets, configures initial module.
      */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
	case "sheet1":
		with (sheetObj) {
       
	        var HeadTitle1="|SEQ|SEL|OPUS VVD|OPUS VVD|OPUS VVD|PSA Vessel Name|Voyage/Direction";
	        var headCount=ComCountHeadTitle(HeadTitle1);
//	        (headCount, 0, 0, true);
	
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
	               {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Sel",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
	               {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"psa_vsl_nm",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
	               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"psa_voy_dir_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 } ];
	         
	        InitColumns(cols);
	
	        SetEditable(1);
	        SetCountPosition(0);
//	        SetSheetHeight(0);
	        sheet1.SetVisible(false);
		}
		break;
	}
}
// Handling process about Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:		
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value=SEARCH;			
 			var sXml=sheetObj.GetSearchData("ESM_BKG_1013GS.do",  FormQueryString(formObj));
			opener.sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
			for(var i=1; i <=opener.sheetObjects[0].RowCount(); i++) {
				opener.sheetObjects[0].SetRowStatus(i,"I");
			}
			ComClosePopup(); 
		}
	break;
	}
}
/**
 * Handling validity verification process about screen form input value
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (port_cd.value.length < 5) {
			ComShowCodeMessage("BKG00424");
			port_cd.focus();
			return false;
		}
		if (etb_dt1.value.length < 10) {
			ComShowCodeMessage("BKG00755");
			etb_dt1.focus();
			return false;
		}
		if (etb_dt2.value.length < 10) {
			ComShowCodeMessage("BKG00755");
			etb_dt2.focus();
			return false;
		}
		if (ComGetDaysBetween(etb_dt1.value, etb_dt2.value) > 40) {
			ComShowCodeMessage("COM132001",ComGetDaysBetween(etb_dt1.value, etb_dt2.value)+" Days " ,"40 Days");
			return false;
		}
	}
	return true;
}
