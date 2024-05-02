/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3502.js
*@FileTitle  : Tariff Code Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

	var sheetObjects=new Array();
	var sheetCnt=0;
	var origin_nm="";
	var comboObjects=new Array();
	var comboCnt=0;
	//Event handler processing by button click event
	document.onclick=processButtonClick;
	
	/**
     * Event handler processing by button name  <br>
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch (srcName) {
				case "btn_save": //save
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				case "btn_retrieve": //retrieve
					doActionIBSheet(sheetObject1, formObject, SEARCH02);
					break;
				case "btn_new": //clear
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
		 			ComOpenWait(false);
		 			comboObjects[0].SetEnable(0);
					ComBtnDisable("btn_delete");			
		   			ComSetFocus(document.form.trf_no);
					break;
				case "btn_delete": 
					doActionIBSheet(sheetObject1, formObject, IBDELETE);
					ComSetFocus(document.form.trf_no);
					break;
				case "btn_rowadd": 
	                doActionIBSheet(sheetObject1, formObject,IBINSERT);
					break;
				case "btn_rowdelete": 
					doActionIBSheet(sheetObject1, formObject, MODIFY02);					
					break;								
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	
    /**
    * handling Axon event<br>
    */    
     function initControl() {
         //handling Axon event            
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form	); 	
        axon_event.addListenerFormat ('keydown', 'obj_keydown', document.form);
        ComClearSeparator (document.form.trf_no,"eng");  
        ComClearSeparator (document.form.trf_nm,"eng");  
     }
     
    /**
    * initializing IBCOMBO <br>
    */ 
	function initCombo(comboObj, comboNo) {
	    switch(comboObj.options.id) {
	        case "inland_rates":
	            var i=0;
	            with (comboObj) {
	                SetDropHeight(100);
	                SetUseAutoComplete(1);
	                SetEnable(0);    
	                InsertItem(i++, "", "");
	                InsertItem(i++, "Yes", "Y");
	                InsertItem(i++, "No", "N");
	                Code="";
	            }
	            break;        
	    }
	}
	
     /**
      * handling OnKeyDown events <br>
      */
     function obj_keydown(){
         //retrieving data when clicking enter key 
         var eleName=event.srcElement.name;
         if (eleName == "trf_cd"|| eleName == "trf_nm"){
             if (event.keyCode == 13){
                 doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
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
	* registering IBCombo Object as list <br>
	* adding process for list in case of needing batch processing with other items  <br>
	* defining list on the top of source <br>
	*/
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	
   /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
	function loadPage() {
    	initControl();
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);	
			ComSetFocus(document.form.trf_no);
			ComBtnDisable("btn_rowadd");
			ComBtnDisable("btn_rowdelete");
			ComBtnDisable("btn_delete");
		}
	    //initializing IBMultiCombo
	    for(var k=0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }
		document.form.trf_pfx_cd.value=ConstantMgr.getScacCode()+" -";
	}
	
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
     	switch(sheetID) {
	     	case "sheet1":
	     	    with(sheetObj){
	     			var HeadTitle="ibflag|Seq|Service Scope|Description";
	     		    var headCount=ComCountHeadTitle(HeadTitle);
	
	     		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	     		    var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	     		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
	     		    InitHeaders(headers, info);
	
	     		    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	     		                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	     		                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, ComboText:scopeCdText, ComboCode:scopeCdValue },
	     		                 {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"svc_scp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	     		                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
	     		                 {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" } ];
	     		     
	     		    InitColumns(cols);
	
	     		    SetEditable(1);
	     		    SetWaitImageVisible(0);
	     		   resizeSheet();//SetSheetHeight(200);
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
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {																		
	 			case IBSEARCH: // retrieve
	 				break;
		 		case SEARCH01: // retrieving tariff no. 
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			ComOpenWait(true);	 			
		 			formObj.f_cmd.value=SEARCH01;
//parameter changed[check again]CLT
		 			var sXml=sheetObj.GetSearchData("ESM_PRI_3502GS.do", FormQueryString(formObj));
		 			// checking tariff name is null
	 		 		if (ComGetEtcData(sXml,"trf_nm")  != undefined){  
	 		 			origin_nm=ComGetEtcData(sXml,"trf_nm");
	 		 			formObj.trf_nm.value=origin_nm;
	 		 		}else { 
	 		 			formObj.trf_nm.value="";
	 		 		}
	 		 		// checking new tariff no. 
	 		 		if (ComGetEtcData(sXml,"cre_flg")  != undefined){ 
	 		 			formObj.cre_flg.value=ComGetEtcData(sXml,"cre_flg");
	 		 			ComBtnEnable("btn_delete");
	 		 			formObj.trf_nm.readOnly=true;
	 		 			formObj.trf_nm.setAttribute("class","input2");
	 		 			formObj.trf_orz_nm.readOnly=true;
	 		 			formObj.trf_orz_nm.setAttribute("class","input2");
	 		 			formObj.trf_orz_tp_nm.readOnly=true;
	 		 			formObj.trf_orz_tp_nm.setAttribute("class","input2");
	 		 		}else { 
	 		 			//new tariff no.
	 		 			formObj.cre_flg.value="";
	 		 			ComBtnDisable("btn_delete");
	 		 			formObj.trf_nm.readOnly=false;
	 		 			formObj.trf_nm.setAttribute("class","input1");
	 		 			formObj.trf_orz_nm.readOnly=false;
	 		 			formObj.trf_orz_nm.setAttribute("class","input1");
	 		 			formObj.trf_orz_tp_nm.readOnly=false;
	 		 			formObj.trf_orz_tp_nm.setAttribute("class","input1");
	 		 		}
	 		 		//getting inland flag   & setting readonly 
	 		 		if (ComGetEtcData(sXml,"trf_inlnd_flg")  != undefined){
		 		 		if (ComGetEtcData(sXml,"trf_inlnd_flg")  == "Y"){
		 		           comboObjects[0].SetSelectText("Yes");
		 		 		}else{
		 		           comboObjects[0].SetSelectText("No");
		 		 		}
	 		 		}else{ 
	 		 			ComSetObjValue(formObj.inland_rates, "");
	 		 		}
	                sheetObj.RemoveAll();
	 		 		break;	
		 		case SEARCH02: // retrieving service scope  
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		 			ComOpenWait(true);
		 			formObj.f_cmd.value=SEARCH02;
//method change[check again]CLT
		 			var sXml = sheetObj.GetSearchData("ESM_PRI_3502GS.do", FormQueryString(formObj) );
		 			//DoSearch
		 			sheetObj.LoadSearchData(sXml,{Sync:1} );
		 			//setting inland flag combo activate mode
		 			ComOpenWait(false);
		 			if (formObj.trf_nm.value == ""){
		 				comboObjects[0].SetEnable(1);
		 			}		 			
 		 			break;		 				 		
		 		case IBCLEAR:      
		 			ComOpenWait(true);		 		
		 			formObj.reset();
		 			document.form.trf_pfx_cd.value=ConstantMgr.getScacCode()+" -";
		 			sheetObj.RemoveAll();
		   			ComBtnDisable("btn_rowadd");
		   			ComBtnDisable("btn_rowdelete");
 		 			formObj.trf_nm.readOnly=true;
 		 			formObj.trf_nm.setAttribute("class","input2");
		 			ComSetObjValue(formObj.inland_rates, "");
		 			break;
		 		case IBINSERT: // Row Add		 		
		 			addRow();
		 			break; 
		 		case IBDELETE:       	
		 			if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (!ComShowCodeConfirm("PRI00002")) {
						return false;
					}
		 			ComOpenWait(true);	
		 			formObj.f_cmd.value=MODIFY01;
//parameter changed[check again]CLT
		 			var sXml=sheetObj.GetSaveData("ESM_PRI_3502GS.do", FormQueryString(formObj));
		 			var del=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		 			if(del != "F" ){
		      		    doActionIBSheet(sheetObj,document.form,IBCLEAR);
			   			ComSetFocus(document.form.trf_no);
			   			formObj.trf_nm.readOnly=true;
			 			ComOpenWait(false);
			 			comboObjects[0].SetEnable(0);
		       	   	}
//parameter changed[check again]CLT
		     	    sheetObj.LoadSaveData(sXml);
		     	    break;			
                case IBSAVE: // save
		 			if (!validateForm(sheetObj,document.form,sAction)) {		 				
						return false;
					} 					
                    var sParamSheet1=sheetObjects[0].GetSaveString(true);
					if (sheetObjects[0].IsDataModified()&& sParamSheet1 == "") {
					    return;
					}
		 			formObj.f_cmd.value=MULTI01;		
		 			var inland=inland_rates.GetSelectCode();
	                if(inland == "Y"){
	                    formObj.trf_inlnd_flg.value="Y";
	                }else if(inland == "N"){
	                    formObj.trf_inlnd_flg.value="N";
	                }	 			
			 		var sParam=sheetObj.GetSaveString(false, true);
			 		sParam += "&" + FormQueryString(formObj);        	
 		 			var sXml=sheetObj.GetSaveData("ESM_PRI_3502GS.do", sParam);
		 			var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
		     	    if(sav != "F" ){
						doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
						doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
						comboObjects[0].SetEnable(0);
			       	}
 		 			sheetObj.LoadSaveData(sXml);
		 			break;	
		 		case MODIFY02: // Row Delete
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}		 		
					with (sheetObjects[0]) { 
						SetCellValue(GetSelectRow(), "trf_pfx_cd",document.form.trf_pfx_cd.value);
		                SetCellValue(GetSelectRow(), "trf_no",document.form.trf_no.value);
					}
					var sts=sheetObj.GetRowStatus(sheetObj.GetSelectRow());
					sheetObj.SetRowStatus(sheetObj.GetSelectRow(),"D");
					if( sts != "I"){
						sheetObj.SetRowHidden(sheetObj.GetSelectRow(), 1);
					}	
					break; 
	 		}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}finally {
			 ComOpenWait(false);
		}
	}
 	
   /**
    * calling Tariff No. OnKeyPress<br>
    */
	function searchTariffCodeName(obj) {   
		comboObjects[0].SetEnable(0);
		if(obj.value.length == 3) {  
			ComBtnEnable("btn_rowadd");
			ComBtnEnable("btn_rowdelete");
			doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
			doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
		}
	}
   
    /**
     * checking validation process of inputed form data <br>
     */
 	function validateForm(sheetObj, formObj, sAction) {
 		switch (sAction) {
 			case SEARCH02: // retrieve
 				if(formObj.trf_no.value.length != 3) {
						ComShowCodeMessage('PRI00308',"input","Tariff Code"); // Tariff Code is null
						ComSetFocus(document.form.trf_no);					
						return false;
		    	}
		    	break;
 			case IBSAVE: // save
 				//Tariff Code is null
		    	if(formObj.trf_no.value.length != 3) {
		    		ComShowCodeMessage('PRI00316',"Tariff Code");  
					ComSetFocus(document.form.trf_no);			
					return false;
		    	}
	          	//inland rates check
	          	if(inland_rates.GetSelectCode()==""){
	          		ComShowCodeMessage("PRI00316","Inland Rates");
	          		formObj.inland_rates.focus();
	          		return false;
	          	} 	 
	    	 	//Tariff Name is null
		    	if(formObj.trf_nm.value == "") {
		    		ComShowCodeMessage('PRI00316',"Tariff Name"); 					
					ComSetFocus(document.form.trf_nm);							
					return false;
		    	}
	            //checking Tariff Scope duplicate
		        //sheetObj.SpaceDupCheck = false;           
	            var dupRow=sheetObj.ColValueDup("svc_scp_cd");
	            if (dupRow>0) {
	            	sheetObj.SetSelectRow(dupRow);
	                ComShowCodeMessage("PRI00342","Tariff Scope");
	                ComSetFocus(sheetObj.ColValueDupRows("svc_scp_cd"));	
	                return false;
	            }	             
            	if(!sheetObjects[0].IsDataModified()&& formObj.cre_flg.value != ""){
            		ComShowCodeMessage('PRI00301'); 
	                return false;
            	}	            	
		    	break;	    	 
 			case IBDELETE:  
 				if(formObj.trf_no.value.length != 3) {
 					ComShowCodeMessage('PRI00308',"input","Tariff Code"); // Tariff Code is null
					ComSetFocus(document.form.trf_no);	
					return false;
 				} 
    	 		break;
 		}
 		return true;
 	}
 	
    /**
     * handling sheet1's add row  
     */
    function addRow() {
		var idx=sheetObjects[0].DataInsert(-1);
		sheetObjects[0].SetCellValue(idx, "trf_pfx_cd",document.form.trf_pfx_cd.value);
		sheetObjects[0].SetCellValue(idx, "trf_no",document.form.trf_no.value);
    }
     
    /**
     * calling function when occurring OnChange Event <br>
     */  
    function sheet1_OnChange(sheetObj, Row, Col) {
    	var colName=sheetObj.ColSaveName(Col);
	    var formObj=document.form;
	    switch(colName)
	    {
	    	case "svc_scp_cd":
	    		var idx=sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	            var sText=sheetObj.GetComboInfo(Row, Col, "Text");
	            var arrText=sText.split("|");
	            sheetObj.SetCellValue(Row,"svc_scp_nm",arrText[idx].split("	")[1] ,0);
	            break;                
	    }
    }
      
    function validationForm(obj){
    	var len=(obj.value).length;
    	if(! ComIsAlphabet(obj)){
    		if ( ComIsKorean(obj) ){
    			obj.value=(obj.value).substring(0,len-2);
			} else {
				obj.value=(obj.value).substring(0,len-1);
			}
			obj.focus();
		}
		else {
			upper(obj);
		}
	}