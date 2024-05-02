/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0205.js
*@FileTitle  : Tire Replacement History Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Developer's task	*/
// Common global variable
var sheetObjects = new Array();
var sheetCnt = 0;

// Defining event handler of button click */
document.onclick = processButtonClick;

// Event handler to diverge process by button name */
function processButtonClick(){
	/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
	var sheetObject1=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1,document.form,IBSEARCH);
			break;
		case "btn_new":
			doActionIBSheet(sheetObject1,formObject,IBCLEAR);
			break;
		case "btn_downexcel":
			doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;
		case "cre_dt_cal":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
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
function initControl() {
	//Axon event handling 1. Catching event
	//axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
	//axon_event.addListenerFormat('focus',   'obj_activate',    form);
	//axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
}
/**
 * Assigning array of IBSheet object
 * Array defined at the top of the source
 */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * Sheet default setting and initializing
 * To implement for onload event of body tag
 * After loading in your browser should display the ability to add pre-processing
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
}
function resizeSheet( sheetObj ){
    ComResizeSheet( sheetObj );
}
/**
 * Initializing variable for IBSheet and defining header
 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      // sheet1 init
	    with(sheetObj){
			var HeadTitle="|Seq.|RHQ|Office|S/P Name|EQ No|Curr|Replace QTY|Replace AMT|Replace DT";
	
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
	
			var cols = [ {Type:"Status",    Hidden:1, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rhq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"curr",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rp_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"rp_amt",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
			{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rp_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 
			InitColumns(cols);
	
			SetEditable(1);
//			SetSheetHeight(380);
			
			resizeSheet( sheetObj );
        }
		break;
	}
}
//Sheet processing-related processes
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //Retrieving
	if(validateForm(sheetObj,formObj,sAction))
		if ( sheetObj.id == "sheet1"){
			formObj.f_cmd.value=SEARCH;
 			sheetObj.DoSearch("EES_MNR_0205GS.do",FormQueryString(formObj) );
		}
	break;
	case IBCLEAR:        //Initializing
		MnrWaitControl(true);
		sheetObj.SetWaitImageVisible(0);
		//Initializing sheet
		for(i=0;i<sheetObjects.length;i++){
			sheetObjects[i].RemoveAll();
		}
		formObj.eq_no.value="";
		formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
		MnrSetFromDate(formObj.from_dt);
		formObj.to_dt.value=ComGetNowInfo();
		sheetObj.SetWaitImageVisible(1);
		MnrWaitControl(false);
		break;
	case IBDOWNEXCEL:
 		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
		break;
	}
}
/**
 * Validating process for input form data
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if(sAction==IBSEARCH) {
			if(!MnrChkFromDate(formObj.from_dt)) return false;
		}
	}
	return true;
}
/* End of developer's task */
