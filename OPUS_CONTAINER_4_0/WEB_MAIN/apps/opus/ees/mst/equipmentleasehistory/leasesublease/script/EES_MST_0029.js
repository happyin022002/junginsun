/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0029.js
*@FileTitle  : Container Status Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class ees_mst_0029 : business script for ees_mst_0029
     */
    function ees_mst_0029() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	 // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var SEARCH_ENABLE=true; 
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 // Event handler processing by button name */
     function processButtonClick(){
       	var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
     	try {
     		 var srcName=ComGetEvent("name");
     	     if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
					case "btn_Retrieve":
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					case "btn_close":
						ComClosePopup(); 
					break;					
					case "New":
						sheetObject1.RemoveAll();
						formObject.cntr_no.value="";
						formObject.chk_dgt.value="";
						formObject.aciac_div_cd.value="";
						formObject.cntr_tpsz_cd.value="";
						formObject.lstm_cd.value="";
						formObject.cntr_tpsz_iso_cd.value="";
						formObject.cntr_old_van_flg.value="";
						formObject.ownr_co_cd.value="";
						formObject.cntr_use_co_cd.value="";
						formObject.cntr_no.focus();
						
						formObject.chk_dgt.readOnly = true;
	                	formObject.chk_dgt.className="input";	
					break;
					case "Down_Excel":
						if(sheetObject1.RowCount() < 1){//no data
							ComShowCodeMessage("COM132501");
		        	    } else{
		        	    	sheetObject1.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
		        	    }
					break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     /**
      * registering IBsheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         if (document.form.cntr_no.value.length > 0)
 		   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 		initControl();
     }
     
	// 1. event catch
	function initControl() {
		var formObj=document.form;
	    axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- handling OnBeforeDeactivate event of all control except rdoCity
	    axon_event.addListenerFormat('beforeactivate',   'obj_activate',    form);            //- handling OnBeforeDeactivate event of all control that has dataformat attribute
		//axon_event.addListenerFormat('keyup',	'obj_keydown',	form); //- when key down
		axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- when key down
		//axon_event.addListener('keydown',	'ComKeyEnter',	    'form'); //- when key down
		// axon_event.addListenerFormat('keyup',	'obj_keyup',	form); //- when key down
		// axon_event.addListenerFormat('keypress','obj_keypress',	form); //- when key down
 		axon_event.addListenerForm('change',	'obj_change',	form); //- when object is changed.		
		formObj.cntr_no.focus();
	} 
	//handling event deactivate of Object
	function obj_deactivate(){
	    //ComChkObjValid(ComGetEvent());
	}
	function obj_activate(){
	    //ComClearSeparator(ComGetEvent());
	}	
//  	function obj_keyup() {
// 		var obj=ComGetEvent();
// 		var vKeyCode=event.keyCode;
// 		var formObj=document.form;
//  		switch(ComGetEvent("name")) {
//			case "cntr_no":
//			if ( ComTrim(ComGetObjValue(obj)) != "" ) {
//				ComKeyEnter('LengthNextFocus');
//			}
//			break;
//	   }
// 	}  	 
// 	function obj_keypress(){
//	    obj=ComGetEvent();
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {
//	        case "engup":
//	            if(obj.name=="cntr_no") ComKeyOnlyAlphabet('uppernum');
//	            break;
//	    }        
//	}
	/**
	 * handling event when object is changed
	 */
	function obj_change(){
		var obj=ComGetEvent("name");
		var formObj=document.form;
		switch(obj) {
    		case "cntr_no":
    			if ( SEARCH_ENABLE ) {
    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase(); // Copy&paste lower case to upper case
    				formObj.chk_dgt.value="";
    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    				ComSetFocus(formObj.cntr_no);
    			}
				break;	
				
    		case "chk_dgt":
    			if ( formObj.chk_dgt.value !="" ) {
    				formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    				ComSetFocus(formObj.cntr_no);
    			}
				break;	
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
            	    with(sheetObj){
		               var HeadTitle="|Status|Date|Yard|AGMT No.|Contract No.|Lessor|Lessor Name|F/M|Pre Movement|DOC Charge|DOC Credit|Curr.|Handle On/Off Charge|DII/DIO Fee|Free Day|Pick Up Charge|Pick Up Credit|Term Change|Created Date|Updated Date|Created User|Updated User|Remark(s)";
		               var prefix="sheet1_";
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sheetStatus" },
		                      {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                      {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_evnt_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ref_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_full_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_amt",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_cr_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cntr_lft_chg_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cntr_dir_itchg_fee_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"rntl_chg_free_dys",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_chg_amt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_chg_cr_amt",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"cntr_lstm_cng_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:120,    Align:"Center",  ColMerge:0,   SaveName:"cre_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:120,    Align:"Center",  ColMerge:0,   SaveName:"upd_dt",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:0,   SaveName:"upd_usr_id",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cntr_sts_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		               InitColumns(cols);
		               SetEditable(0);
		              // SetSheetHeight(400);
		               resizeSheet();
                     }
                 break;
         }
     }
     // handling process for sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
				if(validateForm(sheetObj,formObj,sAction)){
	            	formObj.f_cmd.value=SEARCH;
	            	if (formObj.cntr_no.value.trim().length == 0) {
	            		ComShowCodeMessage("MST00001","CNTR NO.");
	            		formObj.cntr_no.focus();
	            		return;
	            	}
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);	            	
					
					if (formObj.cntr_no.value.trim().length == 10){
	            		formObj.cntr_no.value=formObj.cntr_no.value.toUpperCase() + formObj.chk_dgt.value; // Copy&paste lower case to upper case
	            	}
					
					var sXml=sheetObj.GetSearchData("EES_MST_0029GS.do", FormQueryString(formObj));
	            	var arrXml=sXml.split("|$$|");
	            	
	            	var strCntrNo = ComXmlString(arrXml[0], "cntr_no")+"";
	            	formObj.cntr_no.value=strCntrNo.substring(0,10);
	            	formObj.chk_dgt.value=ComXmlString(arrXml[0], "chk_dgt");
	            	formObj.aciac_div_cd.value=ComXmlString(arrXml[0], "aciac_div_cd");
	            	formObj.cntr_tpsz_cd.value=ComXmlString(arrXml[0], "cntr_tpsz_cd");
	            	formObj.lstm_cd.value=ComXmlString(arrXml[0], "lstm_cd");
	            	formObj.cntr_tpsz_iso_cd.value=ComXmlString(arrXml[0], "cntr_tpsz_iso_cd");
	            	formObj.cntr_old_van_flg.value=ComXmlString(arrXml[0], "cntr_old_van_flg");
	            	formObj.ownr_co_cd.value=ComXmlString(arrXml[0], "ownr_co_cd");
	            	formObj.cntr_use_co_cd.value=ComXmlString(arrXml[0], "cntr_use_co_cd");
	            	if (arrXml.length > 1) sheetObjects[0].LoadSearchData(arrXml[1],{Sync:1} );
	            	if (arrXml.length == 1) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
	            	
	            	if(strCntrNo == "") {
	        			formObj.chk_dgt.readOnly = true;
	                	formObj.chk_dgt.className="input";			
	    			}else{
	    				formObj.chk_dgt.readOnly = false;
	    				formObj.chk_dgt.className="input1";
	    			}
	            	ComOpenWait(false);
				}
			break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         return true;
     }
     
 	function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	}
