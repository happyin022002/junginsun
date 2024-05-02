/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0042.js
*@FileTitle  : MNR Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends  
     * @class EES_MNR_0042 : business script for EES_MNR_0042.
     */

		var sheetObjects=new Array();
		var sheetCnt=0;
		var comboObjects=new Array();
		var comboCnt=0;    
		var initLoader=0;
		// Event handler processing by button click event */
		document.onclick=processButtonClick;
		// Event handler processing by button name */
		function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
          	switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;
                case "btn_DetailRetrieve":
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH,1);
					break;
				case "btn_DownExcel":
					if(sheetObject1.RowCount() < 1){//no data
		        		ComShowCodeMessage("COM132501");
		        	}else{
		        		 sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
		        	}
					//form.sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(formsheet1), SheetDesign:1,Merge:1 });
					break;
				case "btn_DownExcelDtl":
					if(sheetObject2.RowCount() < 1){//no data
		        		ComShowCodeMessage("COM132501");
		        	}else{
		        		sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
		        	}
					break;
				case "btn_calendar": 
					var cal=new ComCalendarFromTo();       
 					cal.select(form.from_dt,  form.to_dt,  'yyyy-MM-dd'); 
					break;    
		        case "btn_inv_no_multy":           
                    rep_Multiful_inquiry("inv_no");   
					break;
		        case "btn_wo_no_multy":           
                    rep_Multiful_inquiry("inv_wo_no");   
					break;
		        case "btn_csr_no_multy":           
                    rep_Multiful_inquiry("csr_no");   
					break;
				case "btn_provider_popup":
				    ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;							
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		} 
    	}
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		initControl()
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
  	    for(k=0;k<comboObjects.length;k++){
  	        initCombo(comboObjects[k], k + 1);
  	    }			
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);		
    }
    /**
     * IBsetting combo basic info
     * @param	{IBCombo}	comboObj	initializing ComboObject 
     * @param	{Number}	comboNo		ComboObject tag serial number
     */
    function initCombo(comboObj, comboNo) {
  	    switch(comboNo) {  
  	    	case 1: 
  	            with (comboObj) { 
  	    		SetColAlign(0, "left");
  			        //SetColWidth("75")   
					SetUseAutoComplete(1);
  		        }
  	            break;
  	    	case 2: 
  	            with (comboObj) { 
  	    		SetColAlign(0, "left");
  		        }
  	            break;				
  	    	case 3: 
  	            with (comboObj) { 
  	    		SetColAlign(0, "left");
  		        }
  	            break;						
  	     } 
  	}		
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetid=sheetObj.id;
        switch(sheetid) {
             case "sheet1":
            	    with(sheetObj){
                
               var HeadTitle="|sel|Seq.|INV No.|INV OFC|S/P Code|S/P Name|Payment S/P Code|Payment S/P Name|INV Status|Confirm DT|Issue DT|Paid DT|CURR|AMT|EX.Rate Adj|V.A.Tax|Sales Tax|W.H.Tax|Invoice Total|CSR No.|INV Remark";
               var headCount=ComCountHeadTitle(HeadTitle);
               (headCount + 2, 0, 0, true);

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Check",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"wo_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"iss_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mnr_inv_sts_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cfm_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"pay_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mnr_wrk_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:80,  Align:"Right",   ColMerge:0,   SaveName:"inv_adj_bzc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"vat_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"sls_tax_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"whld_tax_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"ttl_amt",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"mnr_inv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"dp_prcs_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pay_inv_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);
               SetSheetHeight(122);
               SetCountPosition(0);
               SetEditable(1);           
                     }
				break;
			case "sheet2":
			    with(sheetObj){
		       
		      var HeadTitle1="|Seq.|W/O\nType|W/O\nNo.|W/O OFC|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Result\nDate|Extra\nItem|Extra\nQty|INV No.|W/O CURR|W/O\nAmount|INV CURR|INV\nAmount|EX.Rate Adj|System Verify\nResult";
		      var HeadTitle2="|Seq.|W/O\nType|W/O\nNo.|W/O OFC|Estimate\nNo.|EQ No.|TP/SZ|Cost\nType|Cost Detail\nType|Repair\nYard|W/O\nDate|Result\nDate|Extra\nItem|Extra\nQty|INV No.|W/O CURR|W/O\nAmount|INV CURR|INV\nAmount|EX.Rate Adj|System Verify\nResult";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount+7, 0, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mnr_wo_tp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"wo_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cost_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"rqst_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eq_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"cost_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cost_dtl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"yd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"wo_dt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rpr_rslt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"mnr_expn_dtl_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"rpr_qty",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cost_amt",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_adj_bzc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_vrfy_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_ofc_cty_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_ord_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"ord_dtl_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"mnr_wo_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rpr_rqst_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rpr_rqst_ver_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//		             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } 
		             ];
		       
		      InitColumns(cols);
		      SetCountPosition(0);
//		      SetSheetHeight(220);
		      SetEditable(1);
		      resizeSheet( sheetObj );
		            }


				break;
        }
    }
	function initControl() {  
	    //Axon handling event1. eventcatch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  
	    //axon_event.addListenerFormat('focus',   'obj_activate',    form);            
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            
		axon_event.addListenerFormat('change',	 'obj_change',	form); 
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
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject. 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++]=combo_obj;  
	}  
	/**
	 * HTML Control의 deactivate event <br>
	 **/
	function obj_deactivate(){    
		obj=ComGetEvent();       
	    ComChkObjValid(ComGetEvent()); 
	} 
	/**
	 * HTML Control의 activate event <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(ComGetEvent());
	}        
	function obj_change(){     
		var obj=ComGetEvent(); 
		var formObj=document.form; 
		var sheetObj=sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {      
	    		case "vndr_seq":   
	        		vndr_seq_confirm();  
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;  
	    		case "inv_ofc_cd":   
					doCheckOffice(sheetObj,formObj.inv_ofc_cd,formObj.inv_ofc_cd.value);
				   	break;  
	    		case "cost_ofc_cd":   
					doCheckOffice(sheetObj,formObj.cost_ofc_cd,formObj.cost_ofc_cd.value);
				   	break;  										
			}       
	    } 
	}     
	/**
	 * HTML Control의 keypress event <br>
	 **/     
//	function obj_keypress(){     
//	    obj=event.srcElement;    
//	    if(obj.dataformat == null) return; 
//	    window.defaultStatus=obj.dataformat;
//	    switch(obj.dataformat) {  
//	        case "ymd":   
//	        case "int":    
//				ComKeyOnlyNumber(obj); 
//	            break;     
//	        case "float":   
//	            ComKeyOnlyNumber(obj, ".");
//	            break; 
//	        case "eng":   
//	            ComKeyOnlyAlphabet();
//				break;   
//	        case "engup": 
//	            if(obj.name=="vndr_seq"){ 
//					ComKeyOnlyNumber(obj);     
//				}else{
//					ComKeyOnlyAlphabet('uppernum', "44");	
//				}  
//	        	break;	  
//	    }
//	} 	
   /**
    * handling process after ending sheet1 retrieve.
    * @param sheetObj
    * @param errMsg
    * @return
    */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
		sheetObj.RenderSheet(0);
		for(i=sheetObj.LastRow(); i > 1 ; i--){
			sheetObj.SetCellValue(i,  "inv_curr_cd",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),  "curr_cd"),0);
		}
		sheetObj.RenderSheet(1);
	}
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH,1);
	}
	/**  
	 * combo1 Change event      
	 * @param {IBMultiCombo}  comboObj ComboObject  
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */  
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		form.combo1_text.value = comboObj.GetText(parseInt(newIndex), 0);
		form.input_date_type_code.value= comboObj.GetSelectCode();
	}   	
	/**  
	 * combo2 Change event      
	 * @param {IBMultiCombo}  comboObj ComboObject  
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */  
	function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		if(newText == "ALL"){
			form.combo2_text.value = comboObj.GetText(parseInt(newIndex), 0);
			form.input_type_code.value = "";
		}else{
			form.combo2_text.value = comboObj.GetText(parseInt(newIndex), 0);
			form.input_type_code.value = comboObj.GetSelectCode();
		}
		
	}
	/**  
	 * combo3 Change event      
	 * @param {IBMultiCombo}  comboObj ComboObject  
	 * @param  {String}    Index_Code   Index or Code
	 * @param  {String}    Text
	 */  
	function combo3_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		if(newText == "ALL"){
			form.combo3_text.value = comboObj.GetText(parseInt(newIndex), 0);
			form.mnr_inv_sts_cd.value="";
		}else{
			form.combo3_text.value = comboObj.GetText(parseInt(newIndex), 0);
			form.mnr_inv_sts_cd.value=comboObj.GetSelectCode();
		}
	}
  	/**
     * handling process for sheet
     * @param	{IBSheet}	sheetObj	handling sheetObject 
     * @param	{Form}		formObj		handling formObject
     * @param	{Number}	sAction		Action constants  
     * @param	{Number}	sheetIdx	sheetIdx
     */
    function doActionIBSheet(sheetObj,formObj,sAction, sheetIdx) {
        switch(sAction) {
          	case IBSEARCH:      //retrieving
	          	if(validateForm(sheetObj,formObj,sAction, sheetIdx)){
					sheetObjects[1].RemoveAll();
					formObj.inv_sch_type_code.value="CO";
					if ( sheetIdx == "1"){
						if(sheetObjects[0].RowCount()!= 0){
						sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),"U");
						formObj.f_cmd.value=SEARCH01;
						var sParam=ComGetSaveString(sheetObjects[0]);
						if (sParam == "") return;
				    	sParam += "&" + FormQueryString(formObj);
				    	var sXml=sheetObj.GetSaveData("EES_MNR_0042GS.do", sParam);
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),"");
						}else{
							ComShowCodeMessage("MNR00024");
						}
					}else{
						formObj.f_cmd.value=SEARCH;
						sheetObj.DoSearch("EES_MNR_0042GS.do",FormQueryString(formObj) );
					}	
				}		
                break;
			case IBCLEAR:      // initializing
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
				if(initLoader == 0){
					//retrieving common combo.  
					var sCondition=new Array (
						new Array("MnrGenCd","CD00040", "COMMON"),	//MNR Input Date Type Code 
						new Array("MnrGenCd","CD00045", "COMMON"),	//Invoice Input Type Code
						new Array("MnrGenCd","CD00042", "COMMON"),	//Account Payable  Invoice  Status Code
						new Array("MnrGenCd","CD00004", "COMMON"),	//System Verification Result Code 
						new Array("MnrGenCd","CD00027", "COMMON")	//Repair Invoice Status Code
					);   
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//setting combo
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							//initializing sheetCombo
							sheetComboText="";
							sheetComboCode="";
							for(var j=0; j < comboList[i].length;j++){ 
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//MNR Input Date Type Code
								if(i==0) {
									combo1.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										combo1.SetSelectCode(tempText[0]);
									}  								
								//Invoice Input Type Code
								} else if(i==1){
									combo2.InsertItem(j, tempText[1] ,tempText[0]);
									if(j == 0){      
										combo2.InsertItem(0, "ALL" ,"ALL");
									}  								
								//Account Payable  Invoice  Status Code
								} else if(i==2){
									if(j == 0){      
										combo3.InsertItem(0, "ALL" ,"ALL");
									} 									
									combo3.InsertItem(j + 1, tempText[1] ,tempText[0]);
								//Repair Invoice Status Code
								} else if(i==4){
									combo3.InsertItem(j + 1, tempText[1] ,tempText[0]);
								}
							}
//							System Verification Result Code
							if(i==3) {
								sheetObjects[1].SetColProperty("mnr_vrfy_tp_cd", {ComboText:sheetComboText, ComboCode:sheetComboCode} );
							} 		
							if(i==4){
								combo3.DeleteItem("HC", true); //invoice confirmed Deduplication
								combo3.DeleteItem("SS", true); //deleting SPP
								combo3.DeleteItem("SR", true); //deleting SPP
							}
						}
					}
				}
				initLoader=1;	
				formObj.from_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "m", -3);
				formObj.to_dt.value=ComGetNowInfo();
				combo2.SetSelectCode('ALL');
				combo3.SetSelectCode('ALL');
				formObj.vndr_seq.value='';
				formObj.vndr_lgl_eng_nm.value='';
				formObj.inv_no.value='';
				formObj.inv_wo_no.value='';
				formObj.csr_no.value='';
				formObj.cost_ofc_cd.value='';
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction, sheetIdx){
        with(formObj){
			if(sAction==IBSEARCH) {
				if(formObj.inv_ofc_cd.value=="" && formObj.cost_ofc_cd.value==""){
					ComShowCodeMessage("MNR00172","INV OFC or W/O OFC ");
					ComSetFocus(formObj.inv_no);
					return false;
				}
				var arrWoNo=formObj.inv_wo_no.value.split(",");
				if(arrWoNo!=""){
					for(i=0;i<arrWoNo.length;i++){
						if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
							ComShowCodeMessage("MNR00010","W/O No");
							return false;
						}
					}
				}
				if(ComGetDaysBetween(formObj.from_dt.value, formObj.to_dt.value) < 0){
					ComShowCodeMessage("MNR00366");
    				ComClearSeparator(formObj.from_dt);
    				ComSetFocus(formObj.from_dt);
    				return false;
				}
			}
        }
        return true;
    }
	/**
	 * getting rep_Multiful_inquiry  
	 *           
	 * Location : in case of Single choice     
	 */      
	function getMnr_Multi(rowArray,ret_val) {
		var formObj=document.form;  
		var tempText=""; 
		//initializing   
		eval("document.form." + ret_val + ".value='';"); 
		for(var i=0; i<rowArray.length; i++) {   
			var colArray=rowArray[i];     
			tempText +=  rowArray[i] + ',';    
		}      
		//clearing comma(,)      
		if (tempText != "")       
	        tempText=tempText.substr(0, tempText.length - 1);   	
		tempText=tempText.toUpperCase(); 	            
		eval("document.form." + ret_val + ".value='" + tempText + "';"); 
	}      
	/**
	 * (Service Provider) handling Pop-up Return Value<br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Sheet Array index 
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;   
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=aryPopupData[0][2];
			formObj.vndr_lgl_eng_nm.value=aryPopupData[0][4];
		}
	}	
	/**  
	 * checking whether vndr_seq exists or not     
	 */  
	function vndr_seq_confirm(){
		var formObj=document.form;
		if(formObj.vndr_seq.value != ""){ 
			//retrieving service provider 
			var sCondition=new Array ( 
				new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
			)                            
			//setting in case of existing retrieving result
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition); 
			if(comboList[0] != null){
				var tempText=comboList[0][0].split("|"); 
				formObj.vndr_lgl_eng_nm.value=tempText[1];  
			} else {       
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}   
		}
	}
	/**  
	 * checking whether office code exists or not     
	 */  
	function doCheckOffice(sheetObj,formObjName,formObjValue){
	    retArray=MnrGeneralCodeCheck(sheetObj,"OFC",formObjValue);  
		if(retArray == null){           
			ComShowCodeMessage("MNR00165",formObjValue);       				
			formObjName.value="";       
		} else {  	
			return;     
		}   		 
	}
