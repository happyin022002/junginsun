/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0001.js
*@FileTitle  : Register conditional list by items
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/04
=========================================================*/

// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick(){
	/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btng_Save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
			break;
			case "btn_Close":
				ComClosePopup(); 
			break;
			case "btng_RowAdd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
			break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
		      ComShowCodeMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
 */
function loadPage() {
	for(var i=0;i<sheetObjects.length;i++){
		//Sheet configuration setting function(start)
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i]);
		//Sheet configuration setting function(end)
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj) {
	var cnt=0;
    with(sheetObj){
       // if (location.hostname != "")
      //(6, 0, 0, true);									//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
      var HeadTitle0="Del.|STS|Seq.|EQ|SP CNTR|Desc" ;

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

      var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle0, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"delt_flg", TrueValue:"Y", FalseValue:"N"},
             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"spcl_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"list_bx_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];
       
      InitColumns(cols);
      
      SetColProperty(0 ,"cntr_tpsz_cd"     , {AcceptKeys:"E|N" , InputCaseSensitive:1});
      SetColProperty(0 ,"spcl_cntr_tpsz_cd", {AcceptKeys:"E|N" , InputCaseSensitive:1});
      SetEditable(1);//Editkind[optional,Defaultfalse]
      SetRangeBackColor(1, 3, 1, 6,"#555555");      
	  resizeSheet();
      }
}
/*To retrieve when the screen is loaded */
function setRetrieveAction(){
	sheetObject=sheetObjects[0];
	formObject=document.form;
	doActionIBSheet(sheetObject,formObject,IBSEARCH);
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
 * Handling process about the sheet object
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:		//Inquiry
			// Prohibit button click when a business transaction is processing 
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCHLIST;
//method change[check again]CLT 			
			sheetObj.DoSearch("ESM_COA_0001GS.do", coaFormQueryString(formObj, 'select'));
			ComOpenWait(false);
			break;
		case IBSAVE:				//Save
			if(validateForm(sheetObj,formObj,sAction)){
			// Prohibit button click when a business transaction is processing 
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_COA_0001GS.do", coaFormQueryString(formObj, 'select'));
			//sheetObj.DoAllSave("ESM_COA_0001GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			}
			break;
		case IBINSERT:			// Insert
			sheetObj.DataInsert();
			break;
	}
}
/**
* Handling process for form object input validation
*/
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		var dup=sheetObj.ColValueDup("cntr_tpsz_cd")
		if(dup != -1){
			ComShowCodeMessage('COM12115', 'EQ');
			return false;
		}
	}
	return true;
}

function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}

//SJH.20150109.ADD : 저장후 메시지 추가
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    if(ErrMsg == ""){
        // [COM130102] : Success
    	ComShowMessage(ComGetMsg("COM130102","Data"));
    }else{
        ComShowMessage(ComGetMsg("COM132101"));
    }	
    doActionIBSheet(sheetObj,document.form,IBSEARCH);
} 
