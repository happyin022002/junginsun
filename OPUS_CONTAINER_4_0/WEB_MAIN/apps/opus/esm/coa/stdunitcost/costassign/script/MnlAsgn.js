/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_9999.js
*@FileTitle : Batch Test Page
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
      */
    /**
     * @extends 
			* business script for window
     */
    function MnlAsgn() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
// Grobla Variable
var sheetObjects=new Array();
var sheetCnt=0;
/**
 * Sheet default setting and Initialize
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
}
/**
 * Registering IBSheet Object as list
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/* Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			//case "btn_close":
				//window.close();
			//break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Initialize sheet and define header info
 */
function initSheet(sheetObj,sheetNo) {
	var formObj=document.form;
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
	        
	      var HeadTitle="SEQ|COA_BAT_CD|CNT|";
	      cnt=0;

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:1, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"" },
	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:"coa_bat_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:0,  Width:200,  Align:"Right",   ColMerge:1,   SaveName:"cnt",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);

	      SetEditable(1);
	      SetCountPosition(0);
//	      SetHeaderRowHeight(10);
	      SetSheetHeight(200) ;
	      }


			break;
	}
}
// Handling process about the sheet object
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Inquiry
			if (!validateCond(formObj)) {
				return false;
			}
			// Prohibit button click when a business transaction is processing 
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCHLIST;
 			sheetObj.DoSearch("MnlAsgnGS.do", coaFormQueryString(formObj) );
//			var xml = sheetObj.GetSearchXml("MnlAsgnGS.do", FormQueryString(formObj));
//			formObj.aa.value= xml;
			ComOpenWait(false);
			break;
	}
}
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	with(sheetObj) {
	}
}
/**
 * Handling process for input validation
 */
function validateCond(formObj) {
	with(formObj){
	}
	return true;
}
