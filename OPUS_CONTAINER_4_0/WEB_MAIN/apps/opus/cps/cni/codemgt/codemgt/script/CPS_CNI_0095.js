/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0095.js
*@FileTitle  : [CPS_CNI_0095] Main Code-Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/29
=========================================================*/
/**
 * [CPS_CNI_0095] Main Code-Popup
 * @extends
 * @class business script for Main Code Creation 
 *        
 *        
 *        
 */
function cps_cni_0095() {
    this.processButtonClick=processButtonClick;
    this.setSheetObject=setSheetObject;
    this.loadPage=loadPage;
    this.initSheet=initSheet;
    this.initControl=initControl;
    this.doActionIBSheet=doActionIBSheet;
    this.setTabObject=setTabObject;
    this.validateForm=validateForm;
}
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage(year) {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    //registering initial event 
    initControl();
    //retrieving in case of existing claim party no
    //if (!ComIsNull(frm.clm_pty_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    //}	
}
/**
* registering initial event 
*/
function initControl() {
   //keypress
   axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
   axon_event.addListener ('keydown', 'keydownEnter', 'form');
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 

            var HeadTitle1="|Seq.|Code|Name|Location|Register|RGOFC|Update|Tel|Tel|Address|clm_pty_no";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
{Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_pty_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"intl_phn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"pty_addr",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"clm_pty_no" } ];
             
            InitColumns(cols);

            SetEditable(0);
            SetSheetHeight(330);
            break;
            }
	}
}
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting Location
 */
function setLocation(rowArray) { 
   frm.loc_cd.value=rowArray[0][3];
}
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	
	    case "btn2_Save":
	    	opener.setMainCodePopup();
  ComClosePopup(); 
	        break;
	    case "btn1_Close":
  ComClosePopup(); 
	        break; 	    
	}
}
 /**
  * HTML Control KeyPress event
  */
 function keypressFormat() {
  	var obj=event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
     switch(ComGetEvent("name")) {    
     case "clm_pty_abbr_nm":    
    	KeyOnlyUpper();
     	break;
     case "loc_cd":    
     	KeyOnlyUpper();
      	break;     	
     case "loc_cd":    
      	KeyOnlyUpper();
       	break;
      case "cre_ofc_cd":    
       	KeyOnlyUpper();
        	break;         	
 	}
 }
  /**
   * HTML Control KeyDown event
   */
  function keydownEnter() {
  	 if (event.keyCode != 13) {
  		 return;
  	 }
  	 var obj=event.srcElement;
     switch(ComGetEvent("name")) {
      case "pty_nm":
  		if (validForm() && frm.pty_nm.value != "") {
  				doActionIBSheet(SEARCHLIST01);
  		}	    	
       	break;       	
 	}	  
  }
   /**
   * handling process for input validation
   */   
   function validForm() {
//	   var clm_pty_abbr_nm = frm.clm_pty_abbr_nm.value;			
	   if (!frm.delt_flg.checked && 
			ComIsNull(clm_pty_abbr_nm) && 
			ComIsNull(frm.pty_nm.value) &&
			ComIsNull(frm.cre_ofc_cd.value) &&
			ComIsNull(frm.cre_usr_id.value) ) {
			//msgs["CNI00009"] = "Please input {?msg1},";
			ComShowCodeMessage("CNI00009" , "Code or Name or Register or RGOFC");
			frm.clm_pty_abbr_nm.focus();
			return false;
		}	   
		return true;
   }
/**
* The function called when OnDbClick event on Sheet1 triggered 
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
*/
function sheet1_OnDblClick(sheet, row, col) {	
	if (row < 1) {
		return;
	}
	var partyVo={
clm_pty_no:sheet.GetCellValue(row , "clm_pty_no"),
clm_pty_abbr_nm:sheet.GetCellValue(row , "clm_pty_abbr_nm"),
pty_nm:sheet.GetCellValue(row , "pty_nm"),
intl_phn_no:sheet.GetCellValue(row , "intl_phn_no"),
phn_no:sheet.GetCellValue(row , "phn_no"),
loc_cd:sheet.GetCellValue(row , "loc_cd"),
pty_eml:sheet.GetCellValue(row , "pty_eml")
	};
	opener.setMainViewPopup(partyVo);
  ComClosePopup(); 
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;			
		var sXml=sheet1.GetSearchData("CPS_CNI_0095GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
	} 
}
