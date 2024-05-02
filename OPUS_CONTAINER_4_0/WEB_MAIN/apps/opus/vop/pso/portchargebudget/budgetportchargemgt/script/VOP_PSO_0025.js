/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0025.js
*@FileTitle  : Budget vs Actual
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 
 // public variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var LANE="lane";
 var ROWMARK="|";
 var FIELDMARK=",";
// Event handler processing by button  click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
	        switch(srcName) {
	        	case "btn_Detail"://Detail Button Click
	        	    if(sheetObject1.RowCount()== 0) return ;
	        	    
	        	    var condGubun 		= ComGetObjValue(formObject.gubun);
	        	    var condVslSlanCd 	= ComGetObjValue(formObject.vsl_slan_cd);
	        	    var condPortCd 		= ComGetObjValue(formObject.port_cd);
	        	    var condTermCd 		= comboObjects[0].GetSelectCode();
	        	    var condVslCls 		= comboObjects[2].GetSelectCode();
	        	    var condCreDtFr		= ComGetObjValue(formObject.cre_dt_fr);
	        	    var condCreDtTo		= ComGetObjValue(formObject.cre_dt_to);
	        	    if("0" == condGubun){ //Port
	        	    	if(ComTrimAll(condPortCd) == ""){ //lane null
	        	    		condPortCd = sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_vsl_slan_cd");
	        	    	}
	        	    }else{ //Lane
	        	    	if(ComTrimAll(condVslSlanCd) == ""){
	        	    		condVslSlanCd = sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_vsl_slan_cd");
	        	    	}	        	    	
	        	    }
	        	    
		        	var sUrl="/opuscntr/VOP_PSO_0201.do?acctNo="+sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_lgs_cost_cd")
		        	           +"&gubun="	+condGubun
		        	           +"&laneCd="	+condVslSlanCd
		        	           +"&locCd="	+condPortCd
		        	           +"&termCd="	+condTermCd
		        	           +"&vslCls="	+condVslCls
		        	           +"&creDtFr="	+condCreDtFr
		        	           +"&creDtTo="	+condCreDtTo;
					ComOpenPopup(sUrl, 750, 390, "", "0,1", true);
	        		break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_vsl_slan_cd":
					openLaneCode();
					break;						
				case "btn_port_cd":
					var sUrl="/opuscntr/VOP_VSK_0043.do?op=0043";
					ComOpenPopup(sUrl, 422, 510, "setPortCode", "1,0,1,1,1,1,1", true);
					
					break;
				case "btns_Calendar1" :		// Agreement Date (From Date)
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.cre_dt_fr, "yyyy-MM");
					break;
				case "btns_Calendar2" :		// Agreement Date (To Date)
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(formObject.cre_dt_to, "yyyy-MM");
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
	 * Handling data from Port Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
	function setPortCode(rtnObjs){
		var formObj=document.form;
		var sheetObj=null;
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.port_cd.value=rtnDatas;
				}
			}
		}
	}
   
    function loadTerminal(code) {
    	var formObject=document.form;
		doActionIBCombo(sheetObjects[0] ,formObject,IBSEARCH_ASYNC01,COMMAND01);
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
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj) {  
	    comboObjects[comboCnt++]=combo_obj;  
	}
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
     */
    function loadPage() {
		var formObject=document.form;
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
			
        }
		initControl(sheetObjects[0]);  
//		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		sheet1_OnLoadFinish(sheetObjects[0]);
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
     /**
      * Handling onLoadFinish Event
      * @param sheetObj
      * @return
      */
    function sheet1_OnLoadFinish(sheetObj) {
    	 sheetObj.SetWaitImageVisible(0);
    	 var formObject=document.form;
    	 doActionIBCombo(sheetObjects[0] ,formObject,IBSEARCH,SEARCHLIST); 
//  	 initHOOfc();
//  	 initCombo();     
//  	 doActionIBSheet(sheetObj,document.form,IBCLEAR);
//  	 sheetObj.WaitImageVisible = true; 
     }
	 /**
	 * setting combo initial values and header
   * param : comboObj, comboNo
   * adding case as numbers of counting combos
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObject=document.form;
	    
	    switch(comboObj.options.id) {  
	          case "term_code": 
	           with (comboObj) { 
     				SetMultiSelect(1);
				    SetMultiSeparator(",");  // add 
     				SetUseAutoComplete(1);
     				SetMaxLength(2);
					ValidChar(2, 1);
	 		    	}
	 			break; 
	 		  case "combo1": 
	           with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetDropHeight(190);
					SetMaxLength(6);
					SetColWidth(0, "60");
					SetColWidth(1, "300");
	 		    	}
	 			break; 
	 		  case "combo2": 
		           with (comboObj) { 
						SetMultiSelect(0);
						SetUseAutoComplete(1);
						SetColAlign(0, "left");
						SetColWidth(0, "60");
		 		    	}
		 			break;
		} 
 	}
    /**
     * registering initial event
     */
    function initControl(sheetObj){
    	formObj=document.form;
    	setToday(formObj.cre_dt_fr,"ym");
    	setToday(formObj.cre_dt_to,"ym");
        axon_event.addListenerForm('keyup', 'obj_keyup', form);
    	axon_event.addListenerForm  ('blur', 'obj_blur', form);
        axon_event.addListener('change', 'obj_change', 'form'); 
    }
 	// Retrieving Lane SVC Type
	function doActionIBCombo( sheetObj , formObj,sAction,sComboAction ) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      // Retrieving
			if (sheetObj.id == "sheet1") {	
				//Initializing combo
				comboObjects[1].RemoveAll();
				formObj.f_cmd.value=SEARCHLIST;
				var sXml=sheetObj.GetSearchData("VOP_PSO_0025GS.do", FormQueryString(formObj));
				var comboItems=ComGetEtcData(sXml, "account" ).split(ROWMARK);
				addComboItem(comboObjects[1],comboItems);		
				comboItems=ComGetEtcData(sXml, "vsl" ).split(ROWMARK);
				addComboItem(comboObjects[2],comboItems);		
				ComOpenWait(false);
			};
            break;
		case IBSEARCH_ASYNC01: 
			if (sheetObj.id == "sheet1") {				
				//Initializing combo
				comboObjects[0].RemoveAll();
				//formObj.f_cmd.value = sComboAction;
				formObj.f_cmd.value=COMMAND01;
				//var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
				var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj));
				var comboItems=ComGetEtcData(sXml, "lane").split(ROWMARK);
				addComboItem(comboObjects[0],comboItems);	
			};
            break;
	    }
	}
	function obj_change(){
		var obj=event.srcElement;
		switch(ComGetEvent("name")) {
			case "gubun":
				var HeadTitle1="";
				var HeadTitle2="";
				if( document.form.gubun.value == 0 ) {
					HeadTitle1="|Seq.|Port|Account\nCode|Budget|Budget|Estimate(USD)|Estimate(USD)|Actual(USD Invoice)|Actual(USD Invoice)|Budget vs Actual(Invoice)|Budget vs Actual(Invoice)|Estimate vs Actual(Invoice)|Estimate vs Actual(Invoice)|Budget vs Estimate|Budget vs Estimate";
					HeadTitle2="|Seq.|Port|Account\nCode|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call";
				} else {
					HeadTitle1="|Seq.|Lane|Account\nCode|Budget|Budget|Estimate(USD)|Estimate(USD)|Actual(USD Invoice)|Actual(USD Invoice)|Budget vs Actual(Invoice)|Budget vs Actual(Invoice)|Estimate vs Actual(Invoice)|Estimate vs Actual(Invoice)|Budget vs Estimate|Budget vs Estimate";
					HeadTitle2="|Seq.|Lane|Account\nCode|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call";
				}
				changeHeaderRow(sheetObjects[0] , 0 , HeadTitle1);
				changeHeaderRow(sheetObjects[0] , 1 , HeadTitle2);
				sheetObjects[0].RemoveAll();
			break;
		}
	}	
	/**
	 * Adding data to combo
	 */	
	function addComboItem(comboObj,comboItems) {
		for (var i=0 ; i < comboItems.length ; i++) {
			var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] +"|"+  comboItem[1], comboItem[0]);
		}   		
		comboObj.InsertItem(0, " | "," ");
	}
	function obj_keyup(){
		var eleObj=ComGetEvent();
		var formObj=document.form;
		switch (eleObj.name) {
//		    case "cre_dt_fr":
//		    	if(eleObj.value.length == 6){
//		    		formObj.cre_dt_to.focus();
//		    	}
//				break; 
//		    case "cre_dt_to":
//		    	if(eleObj.value.length == 6){
//		    		formObj.vsl_slan_cd.focus();
//		    	}
//				break;
		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.port_cd.focus();
					sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "port_cd":
		    	if(eleObj.value.length == 5){
			    	loadTerminal();
		    		term_code.focus();
					sheetObjects[0].RemoveAll();
		    	} else{
		    		term_code.RemoveAll();
		    	}
				break;
		    case "term_code":
		    	if(eleObj.value.length == 2){
//		    		combo1.focus();
					sheetObjects[0].RemoveAll();
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
		var sheetid=sheetObj.id;
		switch(sheetid) {
				case "sheet1":
				    with(sheetObj){			        
				      var HeadTitle1="";
				      var HeadTitle2="";
				      HeadTitle1="|Seq.|Port|Account\nCode|Budget|Budget|Estimate(USD)|Estimate(USD)|Actual(USD Invoice)|Actual(USD Invoice)|Budget vs Actual(Invoice)|Budget vs Actual(Invoice)|Estimate vs Actual(Invoice)|Estimate vs Actual(Invoice)|Budget vs Estimate|Budget vs Estimate";
				      HeadTitle2="|Seq.|Port|Account\nCode|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call|Amount|Call";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      //(headCount, 0, 0, true);
				      var prefix="sheet1_";
	
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
	
				      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
				             {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",                            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lgs_cost_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"budget_amount",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"budget_call",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estima_amount",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estima_call",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"actual_amount",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"actual_call",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"budget_vs_actual_amount", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"budget_vs_actual_call",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estima_vs_actual_amount", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"estima_vs_actual_call",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"budget_vs_estima_amount", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:1, Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"budget_vs_estima_call",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
				      SetCountPosition(0);
				      SetEditable(0);
				      //SetSheetHeight(455);
				      resizeSheet(sheetObj);
				      SetSumRowHidden(1);
					}
					break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieving
           		if(validateForm(sheetObj,formObj,sAction)){
           			sheetObj.SetWaitImageVisible(0);
        	        ComOpenWait(true);
           			formObj.f_cmd.value=SEARCH;
           			sheetObj.DoSearch("VOP_PSO_0025GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
				}
			break;
		  	case IBCLEAR:       //Initializing
				initSearchControls("CLEAR");
			break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    		 switch(sAction) {
    		 	case IBSEARCH:
    		 		if(cre_dt_fr.value == ''){
           				ComShowCodeMessage('PSO00003');
           				cre_dt_fr.focus();
           				return false;
           			}	
           			if(cre_dt_to.value == ''){
           				ComShowCodeMessage('PSO00003');
           				cre_dt_fr.focus();
           				return false;
           			}	
           			break;
    		 }      
    	 }
         return true;
    }
     /** 
      * Handling key press event
      */ 
     function obj_keypress(){
    	 obj=ComGetEvent();
    	 if(obj.dataformat == null) return;
    	 window.defaultStatus=obj.dataformat;
    	 switch(obj.dataformat) {
    	 	case "ym": case "ymd":
    	 		ComKeyOnlyNumber(obj);
    	 		break;
    	 	case "num":
    	 		if(obj.name=="vndr_seq"){
    	    		ComKeyOnlyNumber(obj,",");
    	    	} else {
    	    		ComKeyOnlyNumber(obj);
    	    	}
    	        break;
    	    case "eng":
    	        ComKeyOnlyAlphabet(); 
    	        break;
    	    case "engup":
    	        if(obj.name=="vsl_slan_cd") ComKeyOnlyAlphabet('uppernum')
    	        else ComKeyOnlyAlphabet('upper');
    	        break;
    	    case "engdn":
    	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
    	        else ComKeyOnlyAlphabet('lower');
    	        break;
    	 }
     }
     /** 
      * Handling actiavate event
      */
     function obj_activate(){
    	 ComClearSeparator(event.srcElement);
     }
     function obj_blur(){
    	 var formObj=document.form;
    	 obj=event.srcElement;      	
    	 with(formObj){
    		 if(obj.name=="cre_dt_fr" || obj.name=="cre_dt_to"){
    			 var creDtFr=ComReplaceStr(cre_dt_fr.value,"-","");
    			 var creDtTo=ComReplaceStr(cre_dt_to.value,"-","");
    			 switch(ComGetEvent("name")) {
    			 case "cre_dt_fr":	// Agreement From Date
    				 if(creDtFr != '' && creDtTo != ''){
    					 if(creDtFr > creDtTo){
    						 ComShowCodeMessage('COM12133','To date','From date','greater');
    						 cre_dt_fr.value='';
    						 return;
    					 }
    					 //in 1 year
    					 if((Number(creDtTo.substr(0,4)) * 12 + Number(creDtTo.substr(4,2))) - (Number(creDtFr.substr(0,4)) * 12 + Number(creDtFr.substr(4,2))) >= 12){
    						 ComShowCodeMessage('COM12133','Period','1 year','less');
    						 //msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
    						 cre_dt_fr.value='';
    						 return;
    					 }
    				 }
    				 break;
    			 case "cre_dt_to":	// Agreement To Date
    				 if(creDtFr != '' && creDtTo != ''){
    					 if(creDtFr > creDtTo){
    						 ComShowCodeMessage('COM12133','To date','From date','greater');
    						 cre_dt_to.value='';
    						 return;
    					 }
    				 }//in 1 year
    				 if((Number(creDtTo.substr(0,4)) * 12 + Number(creDtTo.substr(4,2))) - (Number(creDtFr.substr(0,4)) * 12 + Number(creDtFr.substr(4,2))) >= 12){
    					 ComShowCodeMessage('COM12133','Period','1 year','less');
    					 //msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
    					 cre_dt_to.value='';
    					 return;
    				 }
    				 break;	
    			 }
    			 ComChkObjValid(event.srcElement);
    		 }
    	 }
     }

	/**
	  * INIT SETTING
	  */
	function initSearchControls(flag) {
		var formObj=document.form;
		ComClearObject(formObj.vsl_slan_cd);
		ComClearObject(formObj.port_cd);
		comboObjects[0].RemoveAll();
		comboObjects[0].SetSelectText("");
		comboObjects[1].SetSelectText("");
		comboObjects[2].SetSelectText("");
		setToday(formObj.cre_dt_fr,"ym");
    	setToday(formObj.cre_dt_to,"ym");
    	sheetObjects[0].RemoveAll();
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObjects[0].SetSumRowHidden(0);
        ComOpenWait(false);
        sheetObjects[0].SetSumValue("SEQ","TOTAL");
	}
    /**
    * IBCombo Event
    */
//    function combo1_OnChange(comb, Index_Code, Text){
//		//Initializing combo
//		sheetObjects[0].RemoveAll();
//    }
    /**
    * IBCombo Event
    */
    function combo1_OnChange(comb, Index_Code, Text){
		//Initializing combo
		sheetObjects[0].RemoveAll();
    }
    /**
    * IBCombo Event
    */
    function combo2_OnChange(comb, Index_Code, Text){
		//Initializing combo
		sheetObjects[0].RemoveAll();
    }
    
	var selComboIndex, selComboCode;
	function term_code_OnSelect(comboObj ,index, text , code) {
		selComboIndex = index;
		selComboCode = code;
	}
	function term_code_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	}

	function resizeSheet(){
		for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	