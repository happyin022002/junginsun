/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0910.js
*@FileTitle  : CY & Door S/O Creation Matchmaking Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE :  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var selRow=0;
var selCol=0;
var selOfc="";
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
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
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	goSoOfficeCode(sheetObjects[0]);
}
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_apply":
				goApply();
			break;
			case "btn_close":
				ComClosePopup(); 
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg=getMsg("COM12111");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
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
	        var HeadTitle="Seq|Office code";

	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ofc_cd_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	         
	        InitColumns(cols);

	        SetEditable(1);//Editkind[,Defaultfalse]
//	        SetSheetHeight(280);// setting height
	        resizeSheet();
			}
		break;
	}
}
function sheet_OnChange(sheetObj, Row, Col, Value) {
	if( sheetObj.ColSaveName(Col) == "chk1" ) {
		if( Value == "1" ) {
			sheetObj.SetRowStatus(Row,"I");
		} else {
			sheetObj.SetRowStatus(Row,"R");
		}
	}
}
function sheet_OnClick(sheetObj, row, col, newPos){
    selRow=row;
    selCol=col;
    selOfc=sheetObj.GetCellValue(row, "ofc_cd");
}
function sheet_OnDblClick(sheetObj, row, col ){
    selRow=row;
    selCol=col;
    selOfc=sheetObj.GetCellValue(row, "ofc_cd");
	goApply();
}
function goApply() {
	var opener=window.dialogArguments;
	if (!opener)
		opener = parent;
	if( selOfc != "" ) {
		opener.rtn_office_code(selOfc);
		ComClosePopup(); 
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH: 
			formObj.f_cmd.value=SEARCH04;
			sheetObj.DoSearch("ESD_SCE_0910GS.do", SceFrmQryString(formObj) );
		break;
	}
}
function goSoOfficeCode(sheetObj) {
	doActionIBSheet(sheetObj, document.form, IBSEARCH);
}
/**
 * When the error occurs on the result of a lookup function to handle common
 * 
*/
function sheet_OnSearchEnd(sheetObj,errMsg){
	if(errMsg!=null&&errMsg!=0){
		ComShowMessage(errMsg);
	}
	var lv_ofc=document.form.sel_ofc_cd.value;
	var lv_row=sheetObj.FindText("ofc_cd", lv_ofc, 0, -1, false);
	sheetObj.SelectCell(lv_row, "ofc_cd_name", false);
}
/**
 * display Get
 * 
 * @param multi Availability Multi-Select
 *              true : Multiple Choice, false : Impossible
 */
function getCommPopDisplay(multi){
 	var display=multi?'0,1,1,1,1,1,1,1,1,1,1,1':'1,0,1,1,1,1,1,1,1,1,1,1' ;
 	return display ;
}
/**
 * classId Get
 */
function getCommPopClassId(){
	var url=document.location.href ;
	var classId=url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".do")) ;
	return classId ;
}
function resizeSheet(){ // auto-sizing
    ComResizeSheet(sheetObjects[0]);
} 
