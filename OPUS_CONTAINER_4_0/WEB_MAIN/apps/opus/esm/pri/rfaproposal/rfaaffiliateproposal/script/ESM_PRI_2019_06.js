/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_06.js
*@FileTitle  : RFA Proposal Inquiry - Affiliate 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    // global variables
    var sheetObjects=new Array();
 	var sheetCnt=0;
 	//Event handler processing by button click event */
 	document.onclick=processButtonClick;
	 /**
	  * Event handler processing by button name  <br>
	  */
     function processButtonClick(){
        var formObject=document.form;          
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
    			case "btn_DownExcel":
    				doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
    				break;
 				case "btn_Close":
 					ComClosePopup();
 					break; 					
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * Initializing and setting Sheet basics <br>
      * Setting body tag's onLoad event handler <br>
      * Adding pre-handling function after loading screen on the browser  <br>
      */
     function loadPage() {
    	 
    	 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    		
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
        }
   		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		// axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);        
  	    var formObj=document.form; 
	    if (formObj.cond_prop_no.value !="" && formObj.cond_prop_no.value != "null" ){
	    	formObj.f_cmd.value=SEARCH02;
			formObj.prop_no.value=formObj.cond_prop_no.value;
			formObj.cond_prop_no.value="";
			var param=FormQueryString(formObj);
			var sXml=sheetObjects[0].GetSearchData("ESM_PRI_2019_06GS.do" , param);
			if (ComGetEtcData(sXml,"rfa_no") != undefined){
				formObj.rfaNo.value=ComGetEtcData(sXml,"rfa_no");
			} 			 	
			if (ComGetEtcData(sXml,"amdt_seq") != undefined){
				formObj.amdt_seq.value=ComGetEtcData(sXml,"amdt_seq");
			}	
			if (ComGetEtcData(sXml,"ctrt_eff_dt") != undefined){
				formObj.hdr_eff_dt.value=ComGetEtcData(sXml,"ctrt_eff_dt");
			}
			if (ComGetEtcData(sXml,"ctrt_exp_dt") != undefined){
				formObj.hdr_exp_dt.value=ComGetEtcData(sXml,"ctrt_exp_dt");
			}	
	    } else{//  calling from 2019
		   if (formObj.hdr_eff_dt.value !="" && formObj.hdr_eff_dt.value != "null"){
			   formObj.hdr_eff_dt.focus();
		   }
		   if (formObj.hdr_exp_dt.value !="" && formObj.hdr_exp_dt.value != "null"){
			   formObj.hdr_exp_dt.focus();
		   }     			 
	  }    	  
	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 		
	}
  /**
   * handling OnKeyPress events <br>
   */        
//	function obj_keypress() {
//		switch (event.srcElement.dataformat) {
//		case "float":
//				ComKeyOnlyNumber(event.srcElement, ".");
//				break;
//		default:
//			ComKeyOnlyNumber(event.srcElement);
//			break;
//		}
//	}
   /**
   * handling OnBeforeActivate events <br>
   */   	
	function obj_activate() {
	    var srcName=ComGetEvent("name");
	    ComClearSeparator (event.srcElement);
	}
    /**
    * handling Onbeforedeactivate events <br>
    */   	
	function obj_deactivate() {
	    ComChkObjValid(event.srcElement);
	}     
     /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
            	    with(sheetObj){
		               var HeadTitle="|Sel.|propno|amdtseq|afilseq|n1stCmncAmdtSeq|Customer code|Customer code|Customer Name|Location|Effective Date|Expiry Date|Source|Status|Accept Staff/Team|Accept Date|acpt_usr_id";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                      {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"afil_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:320,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                      {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               InitColumns(cols);
		               SetEditable(0);
		               SetEllipsis(1);
		               SetWaitImageVisible(0);
		               SetShowButtonImage(2);
		               resizeSheet(); //SetSheetHeight(160);
             		}
                break;
         }
     }
     
     function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
      /**
       * Handling sheet process <br>
       */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try {
             switch(sAction) {			
	 			case IBSEARCH: // retrieve
	 				ComOpenWait(true); //->waiting->start
	 				if (!validateForm(sheetObj,formObj,sAction)) {
	 					ComShowCodeMessage("PRI01021");
	 					return;
	 				}
	 				formObj.f_cmd.value=SEARCH01;
	 				sheetObj.DoSearch("ESM_PRI_2019_06GS.do", FormQueryString(formObj) );
	 				ComOpenWait(false); 
	 				break;
				case IBDOWNEXCEL:
					if(sheetObj.RowCount() < 1){
						ComShowCodeMessage("COM132501");
						}else{
							sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
						}
					break;
	         }
         } catch (e) {
           	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         } finally{
         	ComOpenWait(false); //->waiting->End
         }
     }
     /**
     * calling function when occurring OnClick Event <br>
     * showing memo pad when inputting address, calling User Info PopUp  <br>
     */  	           
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
 	    	case "cust_nm": 
 	    		ComShowMemoPad(sheetObj, Row, Col, true, 450, 80);
 	    		break;
     		case "acpt_usr_nm":
 	    		if (sheetObj.GetCellValue(Row,"acpt_usr_id")!=""){
 	    			ComUserPopup(sheetObj.GetCellValue(Row,"acpt_usr_id"));
 	    		}
 	    		break;
     	}    	 
     }
  	/**
  	 * checking validation process of inputed form data <br>
  	 */
   	function validateForm(sheetObj, formObj, sAction) {
   		switch (sAction) {
   		case IBSEARCH: // retrieve
   			if (formObj.prop_no.value == "" || formObj.prop_no.value == "null" ) {
   				return false;
   			}
   			break;
   		}
   		return true;
   	}     
