/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0956.js
*@FileTitle  : Request Service Provider Inquiry Pop up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
/**
 * @extends Bkg
 * @class ESD_TRS_0956 : USA Rail Billing Detail Inquiry Popup
 */
function ESD_TRS_0956() {
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
/*------------------ Defining general java script function   ------------------*/
/* General global variable */
var sheetObjects=new Array();
var sheetCnt=0;
/**
 * Register IBSheet Object with array
 * call from comSheetObject(id)
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH)
}
document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	/***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_close":
				ComClosePopup(); 
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			errMsg=ComGetMsg("TRS90106");
			ComShowMessage(errMsg);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Define the initial values and headers of sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //t1sheet1 init
		    with(sheetObj){
	    
	      var HeadTitle="S/P Name|S/P Code|WRS User ID|Tel No" ;

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prov_vndr_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prov_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prov_phn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	       
	      InitColumns(cols);

	      SetEditable(1);
	      SetSheetHeight(102);
	      }


		break;
	}
}
function doActionIBSheet(sheetObj,formObj,sAction) {
	var opener_obj=window.dialogArguments;
    sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH13;
			formObj.f_prov_vndr_seq.value=opener_obj.docProvvndrseq;
			formObj.f_trsp_so_ofc_cd.value=opener_obj.docTrsp_so_ofc_cd;
			formObj.f_trsp_so_seq.value=opener_obj.docTrsp_so_seq;
			if( formObj.f_prov_vndr_seq.value == "" ) {
				errMsg=ComGetMsg("TRS90132");
				ComShowMessage(errMsg);
			} else {
 				sheetObj.DoSearch("ESD_TRS_0956GS.do", TrsFrmQryString(formObj) );
			}
		break;
	}
}
