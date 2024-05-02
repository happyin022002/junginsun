/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0962.js
*@FileTitle : W / O issuance screen
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
* @extends 
* @class ESD_TRS_0962 : business script for ESD_TRS_0962
*/
function ESD_TRS_0962() {
    this.processButtonClick=processButtonClick;
    this.setSheetObject=setSheetObject;
    this.setComboObject=setComboObject;
    this.setTabObject=setTabObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;        
    this.initControl=initControl;
    this.initTab=initTab;
    this.doActionIBSheet=doActionIBSheet;
    this.validateForm=validateForm;
}
/*------------------From here the common JavaScript function is defined.    ------------------*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
/* Click the button to define an event handler that receives and processes events */
document.onclick=processButtonClick;
/* Button to process certain filename, separated on a quarterly event handler to handle  */
function processButtonClick(){
	 var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_close":
				ComClosePopup(); 
			  break;
			case "btng_edisend":
//					if(formObject.ets_sts_flg.value == 'Y'){
//						return;
//					}					
				  resendEDI(sheetObject, formObject);
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
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
    with(sheetObj){

			var HeadTitle="|EQ No|S/O No|W/O Issue Time|Ack/Nck|Ack/Nck\nReceived Time|Error MSG" ;
			
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eq_no",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_iss_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_rcv_rslt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_rcv_rslt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:"edi_rcv_rslt_msg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_ofc_cty_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trsp_so_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			
			InitColumns(cols);
			
			SetEditable(1);
            SetColHidden('ibflag',1);
            SetSheetHeight(180);
			}
			break;


    	case 2:      //sheet2 init
    		with(sheetObj){
			
			var HeadTitle="ibflag|wo_edi_flg|conti_cd";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"wo_edi_flg" },
			{Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"conti_cd" } ];
			
			InitColumns(cols);
			
			SetEditable(0);
			SetVisible(0);
    		}
			break;
	}
}
/*
* handling of Sheet 
*/
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	   case IBSEARCH:      
			formObj.f_cmd.value=SEARCH03;
 			sheetObj.DoSearch("ESD_TRS_0024GS.do", TrsFrmQryString(formObj) );
			break;
	}
	setDisplayForm(sheetObj,formObj);
}
/*
 * Viewed in preview
 */
function resendEDI(sheetObj,formObj){
	if(formObj.edi_loc.value == 'ASIA'||formObj.edi_loc.value == 'EUR'){
		if(formObj.edi_loc.value == 'ASIA' ){
			formObj.f_cmd.value=SEARCH04;
//			formObj.edi_loc.value = 'ASIA';
		}else if(formObj.edi_loc.value == 'EUR'){
			formObj.f_cmd.value=SEARCH05;
//			formObj.edi_loc.value = 'EUR';
		}
		formObj.edi_trsp_wo_ofc_cty_cd.value=formObj.trsp_wo_ofc_cty_cd.value.substring(0,3);
		formObj.edi_trsp_wo_seq.value=formObj.trsp_wo_ofc_cty_cd.value.substring(3);
		var queryStr=sheetObj.GetSaveString(true, false);
 		sheetObj.DoSearch("ESD_TRS_0024GS.do", queryStr+"&"+TrsFrmQryString(formObj) );
	}else{
		ComShowMessage("Function is underdeveloped.");
	}
}
function setDisplayForm(sheetObj,formObj){
//	var vseq = formObj.edi_vndr_seq.value ;
	var queryStr='';
	formObj.edi_loc.value='';
	queryStr='&wo_vndr_seq='+formObj.edi_vndr_seq.value;
	formObj.f_cmd.value=SEARCH07;
 	sheetObjects[1].DoSearch("ESD_TRS_0024GS.do", queryStr+"&"+ TrsFrmQryString(document.form),{Append:true} );
formObj.edi_loc.value=sheetObjects[1].GetCellValue(1,"conti_cd");
	if(formObj.edi_loc.value != 'ASIA' && formObj.edi_loc.value != 'EUR'){
		document.all.btng_edisend.style.display="none";
//		document.all.btn1_right_r.style.display="none";
//		document.all.btn1_left_r.style.display="none";
	}
}
/**
 * sheet1_OnSearchEnd
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	if( errMsg != null && errMsg != '' ) {
		ComShowMessage(errMsg);
	} else {
		if(formObj.f_cmd.value == SEARCH02 || formObj.f_cmd.value == SEARCH04){
			ComShowCodeMessage('TRS90208');
		}
	}
}
/**
 * sheet1_OnChange
 */
function sheet1_OnChange(sheetObj, row, col, value)
{
	var colName=sheetObj.ColSaveName(col);
	var formObj=document.form;
	switch(colName)
	{
		case('ibcheck'):
			if( formObj.edi_vndr_seq.value == '102297' ){
				for(var i=1; i<sheetObj.RowCount()+1; i++){
					sheetObj.SetCellValue(i, 'ibcheck',value,0);
				}
			}
			break;
	}
}
