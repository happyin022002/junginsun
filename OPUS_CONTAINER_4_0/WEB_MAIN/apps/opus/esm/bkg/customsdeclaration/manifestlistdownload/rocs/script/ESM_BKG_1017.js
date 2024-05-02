/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_1017.js
 *@FileTitle : ESM_BKG-1017
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/13
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	 /* */
	 var sheetObject1=sheetObjects[0];
	/*******************************************************/ 
	var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_new":				
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
			case "btn_Close":
				ComClosePopup(); 
				break;  
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
}
/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		 var formObj=document.form;
 		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
 		//initSheetData(sheetObjects[0], formObj);
 		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form); 
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){		        		      
			      var HeadTitle1="| |vsl_call_ref_no|vvd_number|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|dem_free_dt|brth_ctnt|ntfy_ltr_ctnt|cre_usr_id|cre_dt|vps_eta_dt|vvd_number|user_ofc_cd";
			      var headCount=ComCountHeadTitle(HeadTitle1);
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetCountPosition(0);
			      SetSheetHeight(302);
		            }
				break;
		}
	}
	 /**
	  * 
	  * @return
	  */
	 function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");		
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		if (srcName == "bl_no" && ComIsKorean(formObject.bl_no.value)) 
		{							 
			formObject.bl_no.focus();			 
		}
	 }
	// handling process for Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {  
		switch(sAction) {
		case IBSAVE:  			
			formObj.f_cmd.value=MULTI;				
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(1, "ibflag","I",0);
			sheetObj.DoSave("ESM_BKG_1017GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			ComClosePopup(); 
			break;
		}
	}
