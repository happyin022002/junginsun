/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0026.js
*@FileTitle  : [CPS_CNI_0026] Main Code-Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/**
 * [CPS_CNI_0026] Main Code-Inquiry
 * @extends
 * @class business script for Main Code Creation 
 */
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
    if (!ComIsNull(frm.clm_pty_no.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
    frm.clm_pty_abbr_nm.focus();
}
/**
* registering initial event 
*/
function initControl() {
   //keypress
   //axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
  // axon_event.addListener ('keydown', 'keydownEnter', 'form');
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
           
            //no support[check again]CLT 			MultiSelection=false;
            var HeadTitle1="|Seq.|Code|Refund/Vndr Code|Name|Location|Register|RGOFC|Update|Tel|Tel|Fax|Fax|E-Mail|pty_rmk|clm_pty_no";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                   {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_pty_abbr_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"pty_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"intl_phn_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"phn_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"intl_fax_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"pty_eml",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pty_rmk" },
                   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clm_pty_no" } ];
             
            InitColumns(cols);
            SetSheetHeight(330);
            SetEditable(0);
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
		case "btn1_Retrieve":
			if (validForm()) {
				doActionIBSheet(SEARCHLIST01);
			}
			break;
	    case "btn1_New":
    		ComResetAll();
    		frm.clm_pty_abbr_nm.focus();
	        break;	
		case "btn1_Detail":
			var row=sheet1.GetSelectRow();
			var clmPtyNo=sheet1.GetCellValue(row , "clm_pty_no");
			popupMainCodeView(clmPtyNo);
	        break;
		case "btn1_Print":	
			if (sheet1.RowCount()< 1) {
				//msgs["CNI00024"] = "There is no data to print.";
				ComShowCodeMessage("CNI00024");
				frm.clm_pty_abbr_nm.focus();
				return;
			}			
			doActionIBSheet(PRINT);
	        break; 	
		case "btns_location":
			//calling Location common popup
			popupLocation();
	        break;
		case "delt_flg":
			if (frm.delt_flg.checked) {
				doActionIBSheet(SEARCHLIST01);
			}
	        break;
	}
}
 /**
  * HTML Control KeyPress event
  */
 function keypressFormat() {
  	var obj=ComGetEvent();
 	if(obj.dataformat == null) return;
 	window.defaultStatus=obj.dataformat;
     switch(ComGetEvent("name")) {    
     case "clm_pty_abbr_nm":    
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
  	 var obj=ComGetEvent();
     switch(ComGetEvent("name")) {    
     case "clm_pty_abbr_nm":
		if (validForm() && frm.clm_pty_abbr_nm.value != "") {
				doActionIBSheet(SEARCHLIST01);
		}	    	
     	break;
     case "pty_nm":
 		if (validForm() && frm.pty_nm.value != "") {
 				doActionIBSheet(SEARCHLIST01);
 		}	    	
      	break;
     case "loc_cd":
 		if (validForm() && frm.loc_cd.value != "") {
 				doActionIBSheet(SEARCHLIST01);
 		}	  
 		break;
     case "cre_ofc_cd":
  		if (validForm() && frm.cre_ofc_cd.value != "") {
  				doActionIBSheet(SEARCHLIST01);
  		}
  		break;
     case "cre_usr_id":
  		if (validForm() && frm.cre_usr_id.value != "") {
  				doActionIBSheet(SEARCHLIST01);
  		}  		
      	break;
 	}	  
  }
   /**
   * handling process for input validation
   */   
   function validForm() {
	   var clm_pty_abbr_nm=frm.clm_pty_abbr_nm.value;			
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
var clmPtyNo=sheet1.GetCellValue(row , "clm_pty_no");
	popupMainCodeView(clmPtyNo);	
}
/**
* Calling Function in case of OnChange event
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
* @param {string} value Changed value, the value when saving, to which format is not applied
*/
function sheet1_OnClick(sheet , row, col, value) {	
	var ptyRmk=sheet.GetCellValue(row , "pty_rmk");
	frm.pty_rmk.value=ptyRmk;
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.pty_rmk.value="";		
		frm.f_cmd.value=SEARCHLIST01;		
	 		var sXml=sheet1.GetSearchData("CPS_CNI_0026GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
		if (sheet1.RowCount()> 0) {
			frm.pty_rmk.value=sheet1.GetCellValue(1 , "pty_rmk");
		}
	} else if (sAction == PRINT) {
		frm.f_cmd.value=PRINT;
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0084.do]";
		var rpost="/rpost ["+FormQueryString(frm)+"]";
		var rpaper="/rpaper [A4]";	
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";
		frm.com_mrdArguments.value=rv+ " " +rf+ " " +rpost+  " " +rpaper  ;
		frm.com_mrdTitle.value="Main Code-Inquiry Print";
		frm.com_mrdBodyTitle.value="Main Code-Inquiry";
		frm.com_mrdPath.value="apps/opus/cps/cni/codemgt/codemgt/report/CPS_CNI_0084.mrd";
		var feature="resizable=yes,width=1000,height=600"
		popupRd(1000,600);
	} 
}
