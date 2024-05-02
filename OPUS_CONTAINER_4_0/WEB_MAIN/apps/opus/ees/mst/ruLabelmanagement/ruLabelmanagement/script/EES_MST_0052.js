/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0050
*@FileTitle  : RU Label Maintenance
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/

var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	document.form.s_ru_label_type.value=document.form.p_ru_type.value;
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	initControl();	
}
/**
      * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
}
/**
    * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {  
   ComKeyOnlyAlphabet('uppernum');
}
/**
 * Validating the data when onblur event occurred <br>
 **/
function obj_blur(){    
   return ComChkObjValid(event.srcElement);
}
/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
   ComClearSeparator(event.srcElement);
}
/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
   ComKeyOnlyNumber(event.srcElement);
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //sheet1 init
	    with(sheetObj){
			var HeadTitle="Seq|RU Label Type|RU Label Value|Type|Remark|Update by|Update Date" ;

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"rstr_usg_lbl_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"rstr_usg_upd_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"remark",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
			InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(450);
        }
		break;
	}
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(validateForm(sheetObj,formObj,sAction)) {
				sheetObj.SetWaitImageVisible(0);
	 			ComOpenWait(true);			
	 			formObj.f_cmd.value=SEARCH;
	 			formObj.s_cntr_no.value=formObj.s_cntr_no.value.toUpperCase();	 			
	 			sheetObj.DoSearch("EES_MST_0052GS.do", FormQueryString(formObj) );
	 			sheetObj.SelectCell(sheetObj.LastRow(), "rstr_usg_tp_cd");
	 			ComOpenWait(false);
			}
			break;
	}
}
/**
    * Validating inputted values of form
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		 switch(sAction) {
		 	case IBSEARCH:
				if(s_cntr_no.value == ''){
					ComShowCodeMessage('MST00002','Container No');
					s_cntr_no.focus();	
					return false;
				}
      		   break;
		 }
	  }
	  return true;
}
