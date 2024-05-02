/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  ESD_TRS_0950.js
*@FileTitle  : Service Order create - Chassis or Genset
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
/*------------------From here the common JavaScript function is defined.     ------------------*/
/* Common global variable  */
var sheetObjects=new Array();
var sheetCnt=0;
var Mincount=0;
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
		ComConfigSheet(sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle */
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btng_fileimport":
				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
				break;
			case "btng_delete":
				doActionIBSheet(sheetObject,formObject,IBDELETE);
				break;
			case "btng_verify":
				importEqNo(sheetObject, formObject);
				break;
			 case "btn_close":
				 ComClosePopup(); 
			  break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Sheet, the initial setting, the header definition
 * initSheet
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
	        var HeadTitle="Seq.|STS||EQ No|Verify Result" ;
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"eq_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Status",    Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	               {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
	               {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"eq_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"verify_result",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_seq" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vndr_abbr_nm" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lstm_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ownr_co_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"usr_co_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"lst_sts_yd_cd" },
	               {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mvmt_dt" } ];
	        InitColumns(cols);
	        SetEditable(1);
	        SetColHidden('ibflag',1);
	        SetSheetHeight(240);
		   }
			break;
	}
}
/*
 *	Sheet processing-related processes
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	   case IBSEARCH:      
			break;
		case IBDELETE:     
			var checkList=sheetObj.FindCheckedRow('ibcheck');
			var checkArray=checkList.split('|');
			for(var k=checkArray.length-1; k>=0; k--)
			{
				sheetObj.RowDelete(checkArray[k], false);
			}
			break;
	   case IBINSERT:      
			sheetObj.DataInsert();
			break;
	   case IBDOWNEXCEL:   
		   if(sheetObj.RowCount() < 1){//no data
			   ComShowCodeMessage("COM132501");
			   }else{
				   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
			   }
			break;
	   case IBLOADEXCEL:   
			sheetObj.RemoveAll();
			sheetObj.LoadExcel();
//			var costMode=window.document.form.trs_cost_md_cd.value;
			var costMode="CY";
			
			if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ){
				for(var i=1; i<sheetObj.RowCount()+1; i++){
					sheetObj.SetCellValue(i, 'eq_no',cntrCheckDigit(sheetObj.GetCellValue(i, 'eq_no')),0);
				}
			}
			break;
	}
}
/**
 * Screen form validation process for processing the input values
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	}
	return true;
}
/**
 * Click on event-related MInimize
 */
function Minimize(nItem)
{
	var objs=document.all.item("showMin");
	if ( nItem == "1" )
	{
		objs.style.display="none";
//no support[check again]CLT 		sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(20);
		sheetObjects[0].focus();
//no support[check again]CLT 		sheetObjects[0].ViewRows=20;
	}
	else
	{
		objs.style.display="inline";
//no support[check again]CLT 		sheetObjects[0].style.height=sheetObjects[0].GetSheetHeight(10);
		sheetObjects[0].focus();
//no support[check again]CLT 		sheetObjects[0].ViewRows=10;
	}
}
function importEqNo(sheetObj, formObj)
{
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	if(checkList == ''){
		ComShowCodeMessage('COM12176');
		return false;
	}
	sheetObj.RemoveEtcData();
	var queryStr=sheetObj.GetSaveString(false, false, "ibcheck");
	if(queryStr=='') return false;
//	var costMode = window.dialogArguments.document.form.trs_cost_md_cd.value;
	var costMode="CY";
	if(costMode=='CY' || costMode=='DR' || costMode=='LS' || costMode=='TS' || costMode=='ER' || costMode=='CN' || costMode=='CF' ){
		document.form.f_cmd.value=SEARCH01;
	}else if(costMode=='HD' || costMode=='HN' || costMode=='HF'){
		document.form.f_cmd.value=SEARCH02;
	}else if(costMode=='GN' || costMode=='GF'){
		document.form.f_cmd.value=SEARCH03;
	}else{
		ComShowCodeMessage('TRS90205');
		window.dialogArguments.form.trs_cost_md_cd.focus();
		return;
	}
	var searchXml=sheetObj.GetSaveData("ESD_TRS_0018GS.do", queryStr+'&'+TrsFrmQryString(formObj));
	sheetObj.LoadSearchData(searchXml,{Sync:1, Append:1} );
}
/**
 * When an error occurs, save the results to a common processing function
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if (verifyEqNo(sheetObj)) //VERIFY delete logic.
		{
			var opener = window.dialogArguments;
			if (!opener) {
				opener=window.opener; 
			}
			if (!opener) {
				opener=parent; 
			}
			
			opener.importEqNo(sheetObj, self.window);
		}
	}
}
/**
* S / O Creation create whether it within two weeks upon confirmation
*/
function verifyEqNo(sheetObj)
{
	var checkList=sheetObj.FindCheckedRow('ibcheck');
	var checkArray=checkList.split('|');
	var returnFlag=true;
	if(checkList == '')
	{
		ComShowCodeMessage('COM12176');
		return false;
	}
	for(var k=0; k<checkArray.length; k++)
	{
		var row=checkArray[k];
		var eq_no=sheetObj.GetCellValue(row, 'eq_no');
		if(sheetObj.GetEtcData(eq_no) != '' &&  sheetObj.GetEtcData(eq_no) != undefined)
		{
			sheetObj.SetCellValue(row, 'verify_result','OK',0);
			sheetObj.SetRowBackColor(row,15723503);
		}else
		{
			sheetObj.SetCellValue(row, 'verify_result','Not Company data',0);
			sheetObj.SetRowBackColor(row,"#EEFFE2");
		}
	}
	return returnFlag;
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg){
    if(isExceedMaxRow(msg))return;
}