/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0011.js
*@FileTitle  : Boiler Plate Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var preYear="";
 var preSeq="";
 // Save Current Event
 var eventStatus="";
 var arrValue=new Array();
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 
    /**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.17
    */
    function processButtonClick(){
    	var sheetObject1=sheetObjects[0];
        var sheetObject2=sheetObjects[1];
        var sheetObject3=sheetObjects[2];
        /*******************************************************/
        var formObject=document.form;
        try {
        	var srcName=ComGetEvent("name");
        	if(ComGetBtnDisable(srcName)) return false;

    		switch(srcName) {
   				case "btn_retrieve":
   					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
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
    * registering IBSheet Object as list <br>
    * adding process for list in case of needing batch processing with other items<br>
    * defining list on the top of source <br>
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj mandatory IBSheet Object
    * @return void
    * @author 
    * @version 2009.04.17
    */   
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
     
    /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return void
    * @author 
    * @version 2009.04.17
    */
    function loadPage() {
    	 for(i=0;i<sheetObjects.length;i++){
    		 //Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             //Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
         }
         //Initializing IBMultiCombo
         for(var k=0; k < comboObjects.length; k++){
             initCombo(comboObjects[k], k + 1);
         }
         initControl();
         doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
         
         // color
         $("table[ibcb-name=blpl_ref_yr_IBCBMainTbl]").css("background-color", 'rgb(244, 246, 246)');
         $("table[ibcb-name=eff_dt_IBCBMainTbl]").css("background-color", 'rgb(244, 246, 246)');
         $("input[name=cfm_flg]").css("background-color", 'rgb(244, 246, 246)');
         $("input[name=exp_dt]").css("background-color", 'rgb(244, 246, 246)');
    }
     
    /**
    * Catching events for Axon event.<br>
    * <br><b>Example :</b>
    * <pre>
    *     initControl()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */        
    function initControl() {
         // Process Axon Event No.1, Event Catch           
    	 axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
     	 axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
     	 axon_event.addListenerForm('blur', 'obj_deactivate', document.form);
    }

    /**
    * handling OnBeforeActivate event<br>
    * <br><b>Example :</b>
    * <pre>
    * obj_activate()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */        
    function obj_activate() {
        ComClearSeparator (event.srcElement);	   
 	}
    
   /**
    * Handling Onbeforedeactivate event<br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */     
 	function obj_deactivate() {
 	    ComChkObjValid(event.srcElement);
 	}
 	
    /**
    * setting sheet initial values and header <br>
    * adding case as numbers of counting sheets  <br>
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} sheetNo mandatory IBSheet Object Serial No
    * @return void
    * @author 
    * @version 2009.04.17
    */
 	function initSheet(sheetObj,sheetNo) {
 		var cnt=0;
        switch(sheetObj.id) {
        	case "sheet0":
        		with (sheetObj) {
        			sheetObj.SetVisible(false);
            	}
        		break;
	        case "sheet1":      // sheet1 init
	        	with (sheetObj){
					var HeadTitle="|Sel.|Del Check|Seq.|Title|blpl_hdr_seq|blpl_seq|dp_seq";
					
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
					             {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
					             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_hdr_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					
					InitColumns(cols);
					
					SetEditable(0);
					SetWaitImageVisible(0);
					SetColHidden("del_chk",1);
					SetSheetHeight(280);
                 }
                 break;
	        case "sheet2":      // sheet2 init
	            with(sheetObj){
	        		var HeadTitle="|Sel.|Del Check|Seq.|Contents|blpl_hdr_seq|blpl_seq|blpl_ctnt_seq|dp_seq";

	        		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

	        		var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        		var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        		InitHeaders(headers, info);

	        		var cols = [ {Type:"Status",    Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	        		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	        		             {Type:"DelCheck",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	        		             {Type:"Seq",       Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	        		             {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3000 },
	        		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_hdr_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"dp_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	           
	        		InitColumns(cols);

	        		SetEditable(0);
	        		SetWaitImageVisible(0);
	                SetColHidden("del_chk",1);
	                SetAutoRowHeight(0);
	                SetSheetHeight(215);
                }
	            break;
        }
    }
     
    /**
    * calling function in case of OnSelectCell event <br>
    * Retrieve Content. <br>
    * <br><b>Example :</b>
    * <pre>
    *		sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} OldRow Mandatory ,previous selected cell's Row Index
    * @param {int} OldCol Mandatory Previous selected Cell's Column Index
    * @param {int} NewRow Mandatory ,current selected cell's Row Index
    * @param {int} NewCol Mandatory ,current selected cell's Column Index
    * @return void
    * @author 
    * @version 2009.04.17
    */   
 	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
        var formObj=document.form;
 		formObj.blpl_seq.value=sheetObjects[1].GetCellValue(NewRow, "blpl_seq");
		if(formObj.blpl_seq.value == "undefined" || ComIsEmpty(formObj.blpl_seq.value)) {
			formObj.blpl_seq.value=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(),"blpl_seq");
		}
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
    }
 	 
    /**
 	* Handling sheet's processes <br>
 	* <br><b>Example :</b>
 	* <pre>
 	*     doActionIBSheet(sheetObj, document.form, IBSEARCH)
 	* </pre>
 	* @param {ibsheet} sheetObj mandatory IBSheet Object
 	* @param {form} formObj mandatory html form object
 	* @param {int} sAction mandatory,Constant Variable
 	* @return void
 	* @author 
 	* @version 2009.04.17
 	*/  
    function doActionIBSheet(sheetObj,formObj,sAction) {
        try{
        	switch(sAction) {
	        	case IBSEARCH_ASYNC01:
	                formObj.f_cmd.value=SEARCH04;
	                var sParam=FormQueryString(formObj);	      
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0011GS.do", sParam);
	                ComPriXml2ComboItem(sXml, blpl_ref_yr, "blpl_ref_yr", "blpl_ref_yr");
	          		break;
	          	case IBSEARCH_ASYNC02:
	          		formObj.f_cmd.value=SEARCH05;
	                var sParam=FormQueryString(formObj);     
	                clearControl();
	                var sXml=sheetObj.GetSearchData("ESM_PRI_0011GS.do", sParam);
	                ComPriXml2ComboItem(sXml, eff_dt, "blpl_hdr_seq", "eff_dt|exp_dt|cfm_flg");                
	     			arrValue=ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg");
	          		break;         		
	 	        case IBSEARCH:      //Retrieving
	 	            ComOpenWait(true); //->waiting->start
	 	         	if ( sheetObj.id == "sheet0") {
	 	         		if (validateForm(sheetObj,document.form,sAction)) {
	 	         			removeSearchCondition(formObj);	 	        			   
	 		                formObj.f_cmd.value=SEARCH01;
	 		                var sXml=sheetObj.GetSearchData("ESM_PRI_0011GS.do", FormQueryString(formObj));
	 	            		var arrData=ComPriXml2Array(sXml, "blpl_hdr_seq|cfm_flg|eff_dt|exp_dt");
	 		       			if (arrData != null && arrData.length > 0) {
	 		       				formObj.blpl_hdr_seq.value=arrData[0][0];
	 		       				formObj.cfm_flg.value=arrData[0][1];		  
	 		       				eff_dt.value=arrData[0][2];
	 		       				formObj.exp_dt.value=arrData[0][3];		       					
	 		    			}		            		   
	 					}	
	 	        	}else if ( sheetObj.id == "sheet1") {
	 	            	if (validateForm(sheetObj,document.form,sAction)) {
	 	            		for (var i=0; i < sheetObjects.length; i++) {
	 	            			sheetObjects[i].RemoveAll();
	 		   				} 
	 						formObj.f_cmd.value=SEARCH02;
//parameter changed[check again]CLT
	 						sheetObj.DoSearch("ESM_PRI_0011GS.do", FormQueryString(formObj) );
	 	            	}	  
	 				}else if ( sheetObj.id == "sheet2") {
	 					if (validateForm(sheetObj,document.form,sAction)) {
	 						formObj.f_cmd.value=SEARCH03;				
//parameter changed[check again]CLT
	 						sheetObj.DoSearch("ESM_PRI_0011GS.do", FormQueryString(formObj) );
	 					}
	 				}	   		 
	 	         	ComOpenWait(false); //->waiting->End
	                break; 	
            }        	 
        } catch (e) {
            if (e == "[object Error]") {
            	ComShowMessage(OBJECT_ERROR);
            } else {
            	ComShowMessage(e.message);
            }
        }finally{
             if (sAction == IBSEARCH_ASYNC01 || sAction == IBSEARCH_ASYNC02) {
        		 return;
	         }
	         ComOpenWait(false); //->waiting->End
        }        
    }    
     
    /**
     * setting intial combo value <br>
     * <br><b>Example :</b>
     * <pre>
     *     initCombo(comboObj,1);
     * </pre>
     * @param {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @param {int} comboNo Mandatory IBMultiCombo Object ,Serial no for Tag's ID
     * @return void
     * @author 
     * @version 2009.04.17
    */      
    function initCombo(comboObj, comboNo) {
 	    switch(comboObj.options.id) { 	        
 	        case "blpl_ref_yr":
	            var i=0;
	            with(comboObj) {
	                Style=1;
	            	//BackColor = "cyan";
//	            	UseEdit = false;
	            	SetDropHeight(200);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            }
	            break; 	 
 	        case "eff_dt":
	            var i=0;
	            with(comboObj) {
	            	Style=1;
	            	//BackColor = "cyan";
//	            	UseEdit = false;
	            	SetDropHeight(100);
	            	SetMultiSelect(0);
	            	SetMaxSelect(1);
	            }
	            break; 		            
 	    }
    }
     
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.04.17
    */
    function validateForm(sheetObj,formObj,sAction){
        switch (sAction) {    	 
	 	    case IBSEARCH: // retrieving
 			    if (blpl_ref_yr.GetSelectCode()== "") {
 				    ComPriInputValueFailed("select","Year", blpl_ref_yr);
	 			    return false;
	 		    } 
 			    if (eff_dt.GetSelectCode()== "") {
 				    ComPriInputValueFailed("select","duration", eff_dt);
	 			    return false;
	 		    } 
	 		    break;
        }
        return true;
    }
     
  	/**
      * Reset the search condition. <br>
      * Save in case of modified data.
      * <br><b>Example :</b>
      * <pre>
      *     searchConditionReset(formObj,gubun)
      * </pre>
      * @param {form} formObj 
      * @param {String} gubun    
      * @return void
      * @author 
      * @version 2009.06.10
      */
 	function removeSearchCondition(formObj) {
 		if(eventStatus == "IBCOPY") return;
	 	// Reset the window, except years
 		eff_dt.value="";
 		formObj.exp_dt.value="";
 		formObj.blpl_hdr_seq.value="";
 		formObj.cfm_flg.value="";
 	}
 	
 	/**
     * Calling function in case of Onclick event <br>
     * Showing memopad for address inputting<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2009.06.03
     */  	           
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
	    //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
	    var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
 	    	case "blpl_ctnt":
 	    		ComShowMemoPad(sheetObj,Row,Col,true,1200,200);
 	    		break;
     	}    	 
    }
     
     /**
      * event in case of losting IBMulti Combo's focus<br>
      * Retrieve Boiler Plate Header Year.<br>
      * <br><b>Example :</b>
      * <pre>
      *    blpl_ref_yr_OnBlur(comboObj);
      * </pre>
      * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
      * @return void
      * @author 
      * @version 2009.04.17
      */      
  	function blpl_ref_yr_OnBlur(comboObj) {  		
		var formObj=document.form;
		var code= comboObj.GetSelectCode();
		if (code != null && code != "" && preYear != blpl_ref_yr.GetSelectCode()){
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);				
		}
		preYear=code;
		eff_dt.SetColWidth(0, 78);
		eff_dt.SetColWidth(1, 78);
		eff_dt.SetDropHeight(24);
		formObj.eff_dt.focus();
	}
  	
	function blpl_ref_yr_OnChange(comboObj, code, text) {
		var formObj=document.form;
		var code= comboObj.GetSelectCode();
		if (code != null && code != "" && preYear != blpl_ref_yr.GetSelectCode()){
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC02);				
		}
		preYear=code;
		eff_dt.SetColWidth(0, 78);
		eff_dt.SetColWidth(1, 78);
		eff_dt.SetDropHeight(24);
		formObj.eff_dt.focus();
	}
	
    /**
     * event in case of losting IBMulti Combo's focus<br>
     * Retrieve data. <br>
     * <br><b>Example :</b>
     * <pre>
     *    eff_dt_OnBlur(comboObj);
     * </pre>
     * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
     * @return void
     * @author 
     * @version 2009.04.17
     */ 
  	function eff_dt_getData(comboObj) {
		var formObj=document.form;
		var code= comboObj.GetSelectCode();
		if (code != null && code != "" && preSeq != eff_dt.GetSelectCode()) {
			formObj.blpl_hdr_seq.value=code;
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);			
		}else{
			formObj.blpl_hdr_seq.value="";
		}
		preSeq=code;
		if (arrValue != null && arrValue.length > 0){
			for (var i=0; code !="" && arrValue[0] != null && i < arrValue[0].length; i++){
				if (arrValue[i][0] == code){
					formObj.cfm_flg.value=arrValue[i][1];
					break;
				}
			}
		}
		formObj.cfm_flg.focus();
	}
  	
    /**
    * event in case of changing selected item of IBMulti Combo<br>
    * <br><b>Example :</b>
    * <pre>
    *    eff_dt_OnChange(comboObj, code, text);
    * </pre>
    * @param   {IBMultiCombo} comboObj Mandatory IBMultiCombo Object
    * @param   {string} code Mandatory code
    * @param   {string} text charater on screen 
    * @return void
    * @author 
    * @version 2009.04.17
    */
	function eff_dt_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
		var formObj=document.form;
		if (code == "" || text == "") {
			return;
		}				
		var expText=comboObj.GetText(parseInt(newindex,10), 1);	
		formObj.exp_dt.value=expText;
		eff_dt_getData(comboObj);
	}
	
    /**
    * Initialize control.<br>
    * <br><b>Example :</b>
    * <pre>
    *    clearContro());
    * </pre>
    * @return void
    * @author 
    * @version 2009.04.17
    */   	
	function clearControl(){
		var formObj=document.form;
 		sheetObjects[0].RemoveAll();
 		sheetObjects[1].RemoveAll();
 		sheetObjects[2].RemoveAll();
		formObj.exp_dt.value="";
		formObj.cfm_flg.value="";
	}

	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}

	function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}


