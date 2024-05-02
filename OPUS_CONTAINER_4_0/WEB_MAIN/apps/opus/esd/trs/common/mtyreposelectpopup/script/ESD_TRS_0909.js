/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0909.js
*@FileTitle  : Empty Repo Select
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
* @extends 
* @class ESD_TRS_0909 : business script for ESD_TRS_0909
*/
/*------------------From here the common JavaScript function is defined.     ------------------*/
/* Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var sheetObjSingle; //Single Transportation opener
var preSetSelectRow = 0;
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
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();	
}
	/**
 	 * initControl <br>
	 **/
	function initControl() {
	    //Axon 이벤트 처리1. 이벤트catch
	//		axon_event.addListener  ('keypress', 'engnum_keypress', 'boo_bkg_no', 'vvd_vvd');
	//		axon_event.addListener  ('click', 'manual_click', 'manual');    
	//		axon_event.addListener  ('keyup', 'bkgno_keyup', 'boo_bkg_no'); 
	//		axon_event.addListenerFormat('blur',    'obj_blur',     form);  
	//		axon_event.addListenerFormat('focus',   'obj_focus',    form);  
	//		axon_event.addListenerFormat('keypress','obj_keypress', form);     
	//		axon_event.addListener  ('change', 'customer_change', 'cus_cust_nm');     
	}
	/**
	 * engnum_keypress <br>
	 **/
	function engnum_keypress() {
	//    ComKeyOnlyAlphabet('uppernum');
	}
	/**
	 * manual_click
	 **/
	function manual_click() {
	//    form.boo_bkg_no.readOnly =!form.manual.checked;
	}
	/**
	 * bkgno_keyup
	 **/
	function bkgno_keyup() {
	    /*
	    if (form.boo_bkg_no.value != form.hdn_boo_bkg_no.value) 
		form.boo_bl_no.value="";
	    else
		form.boo_bl_no.value=form.hdn_boo_bl_no.value;
		*/
	}
	/**
	 * obj_blur
	 **/
	function obj_blur(){
	//    return ComChkObjValid(event.srcElement);
	}
	/**
	 * obj_focus
	 **/
	function obj_focus(){
	//    ComClearSeparator(event.srcElement);
	}
	/**
	 * obj_keypress
	 **/
	function obj_keypress(){
	//    ComKeyOnlyNumber(event.srcElement);
	}
 /**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		 case 1:      //sheet1 init
			with (sheetObj) {
	             var HeadTitle0="|Seq|EQ No|TP/SZ|VVD|Mty Repo BKG NO";
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	             var headers = [ { Text:HeadTitle0, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibcheck",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					        {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	             InitColumns(cols);
	
	             SetEditable(1);//Edit[Option,Defaultfalse]
//	             SetHeaderRowHeight(10);
	             SetSheetHeight(ComGetSheetHeight(sheetObj,7));	// setting height
			}
		break;		
	}	
}
	/* Click the button to define an event handler that receives and processes events */
	document.onclick=processButtonClick;
	function processButtonClick(){
		try {
			var sheetObject=sheetObjects[0];
		    var formObject=document.form;
			var srcName=ComGetEvent("name");
			with(document.form) {
				switch (srcName) {
					case "btn_close":
						ComClosePopup(); 
					break;
					case "btn_new":
					resetHeader(sheetObject, formObject);
					break;
					case "btn_ok":
						applyCntrSelect(sheetObjects[0]);
					break;
					case 'btns_mty_bkg_no':
						rep_Multiful_inquiry(srcName);
						break;
					case "btn_retrieve":
						doActionIBSheet(sheetObject,formObject,IBSEARCH);
						break;
				} // end switch
			}// end with
		} catch(e) {
			if( e="[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
/**
 * Pop-up call rep_commodity
 */
function rep_Multiful_inquiry(btn_obj)
{
		var formObject=document.form;
		var cmdt_cd_val="";  
		var rep_cmdt_cd_val=""; 
		var cmdt_desc_val="";   
		var classId="getTRS_ENS_906";
		var xx1=btn_obj;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var param="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9;
		ComOpenPopup('ESD_TRS_0906.do' + param, 400, 360, 'getTRS_ENS_906', 'none',true);
}		
/**
 * Location: If a pop-up from a single selection.
 */
function getTRS_ENS_906(rowArray,return_val) {
	var formObject=document.form;
	formObject.mty_bkg_no.value=rowArray;
}
/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	if( sAction == IBSEARCH) {
			formObj.f_cmd.value=SEARCH01;
			if( formObj.mty_bkg_no.value == "" ||formObj.mty_bkg_no.value == null ) return;
			 var queryStr='';
			 sheetObj.DoSearch("ESD_TRS_0909GS.do", TrsFrmQryString(formObj)+"&"+ queryStr,{Append:false} );
	}
}
/*
function applyCntrSelect(sheetObj){
	var openerMainSheet=opener.sheetObjects[0];
	var checkList=openerMainSheet.FindCheckedRow('chk1');
	var checkArray=checkList.split('|');
	var ibcheckList=sheetObj.FindCheckedRow('ibcheck');
	var ibcheckArray=ibcheckList.split('|');
	var ibcheckCnt=ibcheckArray.length-1; 
	for(var k=0; k<ibcheckArray.length-1; k++){
openerMainSheet.SetCellValue(checkArray[k], 'eq_no',sheetObj.GetCellValue(ibcheckArray[k], 'eq_no'));
	}
  ComClosePopup(); 
}*/
function applyCntrSelect(sheetObj){
	var openerMainSheet=opener.sheetObjects[0];
	var checkList=openerMainSheet.FindCheckedRow('chk1');
	var checkArray=checkList.split('|');
	var ibcheckList=sheetObj.FindCheckedRow('ibcheck');
	var ibcheckArray=ibcheckList.split('|');
	var ibcheckCnt=ibcheckArray.length-1;
	var ibcheckArray_1=ibcheckList.split('|');
	var checkLength=0;
	if( checkArray.length > ibcheckArray.length )  
		checkLength=ibcheckArray.length;
	else
		checkLength=checkArray.length; 
	var k=0;
	var j=0; 
		while( k <= checkArray.length-2 ){
			j=0; 
			while( j <= ibcheckArray.length-2 ){
				if( (k <= checkArray.length-2) && ( j <= ibcheckArray.length-2) ){
					if( openerMainSheet.GetCellValue(checkArray[k], 'eq_tpsz_cd') == sheetObj.GetCellValue(ibcheckArray[j], 'eq_tpsz_cd')  ){
						if( ibcheckArray_1[j] != 'Y' ){
							openerMainSheet.SetCellValue(checkArray[k], 'eq_no',sheetObj.GetCellValue(ibcheckArray[j], 'eq_no'));
							ibcheckArray_1[j]='Y';
							k++;
							j=0;
						}else{
							j++;
						}
					}else{
						j++;
					}
				}else{
					j++;
				}
			}
			k++;
		}
  ComClosePopup(); 
}
/**** the header part is reset. ****/
function resetHeader(sheetObj,formObj){
	formObj.mty_bkg_no.value='';
	sheetObj.RemoveAll();
}
