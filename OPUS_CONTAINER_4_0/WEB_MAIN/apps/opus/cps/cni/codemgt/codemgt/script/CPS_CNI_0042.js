/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0042.js
*@FileTitle  : CCC VVD & SKD Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
/**
 * [CPS_CNI_0042]  CCC VVD & SKD Inquiry
 * @extends
 * @class  business script for CCC VVD & SKD Inquiry
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
var locType="";
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
 **/
function loadPage() {
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
    var trnk_ref_vvd_no=frm.trnk_ref_vvd_no.value;
    if (!ComIsNull(trnk_ref_vvd_no) && trnk_ref_vvd_no.length == 9) {
    	doActionIBSheet(SEARCHLIST01);
    } 
    frm.trnk_ref_vvd_no.focus();
}
/**
* registering initial event 
*/
function initControl() {
   //keypress
   axon_event.addListenerFormat('keypress', 'keypressFormat', frm);
   axon_event.addListener ('keyup', 'keyup', "form");
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
            
            var HeadTitle1="Seq.|Lane|VVD|POL|CCT|ETD|POD|ETB";
            var headCount=ComCountHeadTitle(HeadTitle1);
           // (headCount, 0, 0, true);

            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"cct",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vps_etb_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
             
            InitColumns(cols);
            SetEditable(0);
            SetSheetHeight(282);

			
			break;		
		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting VVD
 */
 function setVVD(rowArray) {
	 var vvd=rowArray[0][7];
	 frm.vsl_cd.value=vvd.substring(0,4);
	 frm.skd_voy_no.value=vvd.substring(4,8);
	 frm.skd_dir_cd.value=vvd.substring(8,9);
	 doActionIBSheet(SEARCHLIST01);
 }
 /**
  * setting Location
  */
 function setLocation(rowArray) { 
	if (locType == "pod") {
		frm.pod.value=rowArray[0][3];
	}
	if (locType == "pol") {
		frm.pol.value=rowArray[0][3];
	}
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
	        break;
	    case "btn1_Select":
	    	var row=sheet1.GetSelectRow();
	    	if (sheet1.RowCount()== 0 || row  < 1) {
	    		return;
	    	}	    	
	    	var vvdSkdVo={
	    			slan_cd:sheet1.GetCellValue(row , "slan_cd"),
	    			vvd:sheet1.GetCellValue(row , "vvd"),
	    			pol:sheet1.GetCellValue(row , "pol"),
	    			pod:sheet1.GetCellValue(row , "pod"),
	    			cct:sheet1.GetCellValue(row , "cct"),
	    			vps_etd_dt:sheet1.GetCellValue(row , "vps_etd_dt"),
	    			vps_etb_dt:sheet1.GetCellValue(row, "vps_etb_dt")
	    	};	    	
	    	opener.setVvdSkd(vvdSkdVo);   	
	    	ComClosePopup(); 
	        break;
	    case "btn1_Close":	    	
	    	ComClosePopup(); 
	        break;
	    case "btns_vvd":
	    	popupVVD();
	        break;
	    case "btns_pol":
	    	locType="pol";
	    	popupLocation();
	        break;	        
	    case "btns_pod":
	    	locType="pod";
	    	popupLocation();
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
     case "trnk_ref_vvd_no":    
    	 ComKeyOnlyAlphabet('uppernum');
    	 break;
     case "pol":
     case "pod":
    	 ComKeyOnlyAlphabet('upper');     	
      	break;     	
 	}
 }
  /**
   * HTML Control Keyup event
   */
  function keyup() {  	 
  	 var obj=event.srcElement;
     switch(ComGetEvent("name")) {   
     case "trnk_ref_vvd_no":
    	 if (obj.value.length == 9 || (event.keyCode == 13 && validForm()) ) {    	  	
    		 doActionIBSheet(SEARCHLIST01);  
    	 }
    	 break;
     case "pol":	 
     case "pod":
    	 if (obj.value.length > 0) {
    	  	 if (event.keyCode == 13 && validForm()) {
    	  		 doActionIBSheet(SEARCHLIST01);
    	  	 }
    	 }
    	 break;    	 
     }
  }
   /**
   * handling process for input validation
   */   
   function validForm() {
	   return ComChkValid(frm);
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
	var vvdSkdVo={
			slan_cd:sheet.GetCellValue(row , "slan_cd"),
			vvd:sheet.GetCellValue(row , "vvd"),
			pol:sheet.GetCellValue(row , "pol"),
			pod:sheet.GetCellValue(row , "pod"),
			cct:sheet.GetCellValue(row , "cct"),
			vps_etd_dt:sheet.GetCellValue(row , "vps_etd_dt"),
			vps_etb_dt:sheet.GetCellValue(row, "vps_etb_dt")
	};
	opener.setVvdSkd(vvdSkdVo);
  ComClosePopup(); 
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;
		var trnk_ref_vvd_no=frm.trnk_ref_vvd_no.value;
		frm.vsl_cd.value=trnk_ref_vvd_no.substring(0,4);
		frm.skd_voy_no.value=trnk_ref_vvd_no.substring(4,8);
		frm.skd_dir_cd.value=trnk_ref_vvd_no.substring(8,9);		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0042GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
	} 
}
