/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0061.js
*@FileTitle  : Cargo Re-Handling Performance 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
　
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
     * @extends 
     * @class VOP_OPF_0061 : VOP_OPF_0061 business script for
     */
    function VOP_OPF_0061() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject		= setSheetObject;
    	this.loadPage			= loadPage;
    	this.initSheet			= initSheet;
    	this.initControl		= initControl;
    	this.doActionIBSheet	= doActionIBSheet;
    	this.setTabObject		= setTabObject;
    	this.validateForm		= validateForm;
    }
    
   	/* Developer performance	*/
    // common global variables
    var tabObjects				= new Array();
    var beforetab				= 1;
    var sheetObjects			= new Array();
    var sheetCnt				= 0;
	var comboObjects			= new Array();
	var comboCnt				= 0;
	// Event handler processing by button click event */
	document.onclick			= processButtonClick;
	
	// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        var formObject=document.form;
	   	try {
	   		var srcName=ComGetEvent("name");
	   		if(ComGetBtnDisable(srcName)) return false;
	   		switch(srcName) {
	   			case "btn_Retrieve":
	   		    	if(!ComChkValid(formObject)){
	   		    		return false;
	   		    	}
	   				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
	   				break;
	   			case "btn_New":
	   				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
	   				break;
	   			case "btn_Excel":
	   				if(sheetObject1.RowCount() < 1){//no data
	   					ComShowCodeMessage("COM132501");
	   					}else{
	   						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	   					}
	   				
	   				break;
	   			case "btn_loc_cd":	//Location retrieve pop-up
	   				var loc_cd=formObject.loc_cd.value;
	   		    	var sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="+loc_cd;
//	   				var rVal=ComOpenPopupWithTarget(sUrl, 422, 520, "setPortCode", "0,0", true);
//	   				if(rVal){
//	   					formObject.loc_cd.value=rVal;
//	   					loc_cd_onchange();
//	   				} 
	   		    	ComOpenPopup(sUrl, 422, 520, "setPortCode", "0,0", true);
	   				break;
	    		case "btn_slan_cd_pop":
	    			var slan_cd=formObject.slan_cd.value;
	    			ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 420, 480, "slan_cd_pop_event", "0,0", true);
	    			break;
	   	        case "from_calendar": // From calendar button
	   	            var cal=new ComCalendar();
	   	            cal.select(formObject.from_date, 'yyyy-MM-dd');
	   	            break;
	   	        case "to_calendar": // From calendar button
	   	            var cal=new ComCalendar();
	   	            cal.select(formObject.to_date, 'yyyy-MM-dd');
	   	            break;
	   	        case "from_to_calendar": // From calendar button
                	var cal=new ComCalendarFromTo();
                	cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
	   	            break;
	   	        case "rh_reason":
	   	        	hideShowReason();
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
     * PortCode setting
     */    
    function setPortCode(rtnVal) {
    	if(rtnVal){
    		    document.form.loc_cd.value=rtnVal;
				loc_cd_onchange();
			} 
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
      * register Combo Object to array
      */    
 	 function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	 } 
 	 /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
    	 
    	 for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet 	(sheetObjects[i] );
             initSheet			(sheetObjects[i],i+1,null);
             ComEndConfigSheet	(sheetObjects[i]);
         }
    	 
  	 	//initializing IBMultiCombo
  	    for(var c=0; c<comboObjects.length; c++){
  	        initCombo			(comboObjects[c], c+1);
  	    }  
  	    setRhq();
     	//setting From Date 
     	set_from_date();
     	initControl();
     	
     }
	 	/* get RHQ combo  */
//	function setRhq(){
//		var formObj=document.form;
//		formObj.f_cmd.value=SEARCH01;
//		var param=FormQueryString(formObj)+"&comboCd=CD02723"
//		var sXml=sheetObjects[1].GetSearchData("VOP_OPF_UTILGS.do", param);
//		ComXml2ComboItem(sXml, comboObjects[0], "val", "val|desc");
//		comboObjects[0].InsertItem(0, "All", "ALL");
//		comboObjects[0].SetSelectText("All");
//	}
	
	function setRhq(){
		var formObj			= document.form;
		formObj.f_cmd.value	= SEARCH01;
		var param			= FormQueryString(formObj);
		var sXml			= sheetObjects[1].GetSearchData("VOP_VSK_0221GS.do", param);
		var rhqlist			= ComGetEtcData(sXml, "rhqlist");
		
		if(rhqlist){
			var comboObj	= comboObjects[0];
			var rhqs		= rhqlist.split(":");
			for(var i=0; i<rhqs.length; i++){
				comboObj.InsertItem(-1, rhqs[i], rhqs[i]);
			}
		}
		comboObjects[0].InsertItem		(0, "All", "ALL");
		comboObjects[0].SetSelectText	("All");		
	}	
	
	function makeHeaderRestowReasonList(sheetObj){
		var formObj				= document.form;
		formObj.f_cmd.value		= SEARCH01;
		var sParam      		= FormQueryString(formObj); // + "&" + ComGetPrefixParam("sheet1_");
		var sXml				= sheetObj.GetSearchData("VOP_OPF_0061GS.do", sParam);
		var sRestowReasonArr	= ComGetEtcData(sXml, "restowReasonList");
		var sRestowReasonList 	= "";
		
		if(sRestowReasonArr != null && sRestowReasonArr != "" && sRestowReasonArr != undefined){
			sRestowReasonList 	= sRestowReasonArr.split("|");	
		}else{
			sRestowReasonList	= "";
		}
		
		return	sRestowReasonList;
	}	
	
     //setting From Date 
     function set_from_date(){
     	var formObj=document.form;
     	var vNowDate=formObj.now_date.value;
     	var vlastDay=formObj.last_day.value;
     	formObj.from_date.value=ComGetDateAdd(vNowDate, "M", -1).substr(0, 8)+"01";
     	formObj.to_date.value=vlastDay.substr(0,4)+"-"+vlastDay.substr(4,2)+"-"+vlastDay.substr(6,2); 
     }
	/**
	 * set Combo
	 * param :  comboObj , comboNo　
	 *adding case as numbers of counting combos
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.options.id) {
			case "rhq":
				with(comboObj) {
					comboObj.SetDropHeight(125);
					comboObj.SetBackColor("#CCFFFD");
	        	}
				break;
			/*case "yd_cd":
				with(comboObj) {
					InsertItem(i++,  "ALL",  "");
					comboObj.SetSelectText("ALL");
	        	}
				break;*/
		}
	}
 	/** 
     * initControl()
     */ 
	function initControl() {
		axon_event.addListenerForm	('deactivate'	, 'obj_deactivate'	, form);
		axon_event.addListenerFormat('focus'		, 'obj_activate'	, form);
		axon_event.addListenerForm 	('blur'			, 'obj_blur'		, form);
		axon_event.addListenerForm	('keyup'		, 'obj_keyup'		, form);
	}

 	/**
 	 * Form 내의 Object Deactivate 이벤트시 처리.
 	 * 
 	 * @return void
 	 */        
	function obj_deactivate(){
		obj=ComGetEvent();
		var formObj=document.form;
		switch(ComGetEvent("name")) {
			case "loc_cd":
				if( formObj.loc_cd.value != ""){
					if(!ComChkObjValid(obj)){
						setFocus("loc_cd");
						return false;
					}
				}else{
					comboObjects[0].SetSelectText("All");
					comboObjects[1].RemoveAll();  //initialize YD_CD combo
					comboObjects[1].InsertItem(0, "All","");
					comboObjects[1].SetSelectText("All");
				}
				break;
    		case "slan_cd":
    			if( formObj.slan_cd.value != ""){
    				if(!ComChkObjValid(obj)){
    					setFocus("slan_cd");
    					return false;
    				}
    			}
    			break; 				 		 
		}
	}
    //handling work javascript OnFocus event
    function obj_activate() {
       	//delete mask separator
        //ComClearSeparator(event.srcElement);
       	switch(ComGetEvent("name")){ 	    	
       		case "from_date":
       			ComClearSeparator(ComGetEvent());
       			break;
       		case "to_date":
       			ComClearSeparator(ComGetEvent());
       			break;
       	}
    }
    /** 
     * handling work javascript OnBlur event  <br>
     */    
    function obj_blur(){
    	obj=ComGetEvent();
    	var formObj=document.form;
    	switch(ComGetEvent("name")) {
			case "from_date":
    			if( formObj.from_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("from_date", "");
                    	setFocus("from_date");
                        return false;
                    }else{
                    	if( formObj.to_date.value != ""){
                    		if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) >= 365){
                    			ComAlertFocus(formObj.from_date, ComGetMsg("OPF50021"));
                    			setObjValue("from_date", "");
                    			return false;
                    		}
                    	}
                    }
                }
    			break;
    		case "to_date":
    			if( formObj.to_date.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("to_date", "");
                    	setFocus("to_date");
                        return false;
                    }else{
                    	if( formObj.from_date.value != ""){
                    		if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) >= 365){
                    			ComAlertFocus(formObj.to_date, ComGetMsg("OPF50021"));
                    			setObjValue("to_date", "");
                    			return false;
                    		}
                    	}
                    }
                }
    			break;
    	}
    }         
	//RHQ change eventFind or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

    function rhq_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
    {
    	var formObj=document.form;
		formObj.loc_cd.value="";
		comboObjects[1].RemoveAll();  //initialize YD_CD combo
		comboObjects[1].SetBackColor("#CCFFFD");
		comboObjects[1].InsertItem(0, "All","");
		comboObjects[1].SetSelectText("All");
    }
    
    /** 
     * Object 의 KeyUp 이벤트에 대한 처리  <br>
     */     
	function obj_keyup(){
		obj = event.srcElement;
		var formObj = document.form;

		switch(ComGetEvent("name")) {
			case "loc_cd":
				if( formObj.loc_cd.value.length == 5 ){
					loc_cd_onchange();
					class_name();
				}else{
					class_name_all();
				}
				break;
				
			case "slan_cd":
				if( formObj.slan_cd.value.length == 3 ){
					change_event();
					class_name();
				}else{
					class_name_all();
				}
				break;

       	}
    }
	
	function class_name(){
		var formObj=document.form;
		if(formObj.loc_cd.value == "" && formObj.slan_cd.value == ""){
			formObj.loc_cd.className="input1";
			formObj.slan_cd.className="input1";
		}else if(formObj.loc_cd.value == ""){
			formObj.loc_cd.className="input";
			formObj.slan_cd.className="input1";
		}else if(formObj.slan_cd.value == ""){
			formObj.loc_cd.className="input1";
			formObj.slan_cd.className="input";
		}
	}
	function class_name_all(){
		var formObj=document.form;
		if(formObj.loc_cd.value == "" && formObj.slan_cd.value == ""){
			formObj.loc_cd.className="input1";
			formObj.slan_cd.className="input1";
		}
	}
    
   	//Port Code change event and YD_CD combo creation
   	function loc_cd_onchange(){
   		comboObjects[1].RemoveAll();  //initialize YD_CD combo
   		var formObj=document.form;
   		formObj.f_cmd.value=SEARCH01;
   		var sRhqXml=sheetObjects[1].GetSearchData("VOP_OPF_0057GS.do", FormQueryString(formObj));
   		if(ComGetTotalRows(sRhqXml) == 0){
			ComAlertFocus(formObj.loc_cd, ComGetMsg("OPF50004", "Data"));
			setObjValue("loc_cd", "");
			setFocus("loc_cd");		
		}else{
			comboObjects[1].SetDropHeight(200);
			ComXml2ComboItem(sRhqXml, comboObjects[1], "yd_cd", "yd_cd|yd_nm");
		}
		comboObjects[1].SetBackColor("#CCFFFD");
		comboObjects[1].InsertItem(0, "All","");
		comboObjects[1].SetSelectText("All");
		//setting RHQ
		formObj.f_cmd.value=SEARCH01;
		var s2RhqXml=sheetObjects[1].GetSearchData("VOP_OPF_0069GS.do", FormQueryString(formObj));
		var sRhqVal=ComGetEtcData(s2RhqXml, "cmbVal");
		var sRhqName=ComGetEtcData(s2RhqXml, "cmbName");
		if( sRhqVal != "")
		{
			var arrRhqVal=sRhqVal.split("|");
			var arrRhqName=sRhqName.split("|");
			for(var i=0; i<arrRhqVal.length ; i++)
			{
				rhqChangeFlg=false;
				comboObjects[0].SetSelectCode(arrRhqVal[0],false);
			}
		}		
   	}
    /**
     * popup Data Validation method input in Key
     */
    function change_event() {
    	var elementObj=ComGetEvent();
    	var sheetObj=sheetObjects[1];
    	var gubun="";
    	if(!isNull(elementObj.value)){   		
    		// Length Check..
	    	if(elementObj.maxLength != elementObj.value.length){
	    		ComShowCodeMessage("OPF50007",elementObj.caption,elementObj.maxLength);
	    		elementObj.focus();
	    		return false;
	    	}
    		// Popup Data Validation Check!
    		if(elementObj.name=="slan_cd"){
        		gubun="slanCd";
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }   	
    /**
     * slan_cd Data PopUp Value input method.
     */
    function slan_cd_pop_event(aryPopupData) {
    	document.form.slan_cd.value=aryPopupData[0][1];
    }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo,headTitleList) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {

	                 ////var HeadTitle1	= "|Port|Lane|VVD CD|CGO OPR|Cargo Vol.|Cargo Vol.|Cargo Vol.|R/H Unit|R/H Unit|R/H Moves|R/H Moves|C/C\nMoves|C/D/C\nMoves|R/H(%)\nRatio by Unit|R/H(%)\nRatio by Moves|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason|R/H Reason";
	                 ////var HeadTitle2	= "|Port|Lane|VVD CD|CGO OPR|Full|Empty|Total|By OWN Acc.|By Others Acc.|By OWN Acc.|By Others Acc.|C/C\nMoves|C/D/C\nMoves|R/H(%)\nRatio by Unit|R/H(%)\nRatio by Moves|CC|CR|IC|ID|IF|IG|IH|IL|IO|IP|IR|IS|IT|IW|IX|XX";

            	 	 var HeadTitleMerge1		= "";
            	 	 var HeadTitleMerge2		= "";
            	 	 var HeadTitleAdd1			= "";
            	 	 var HeadTitleAdd2			= "";            	 	 
            	 	
	                 var HeadTitle1				= "|Port|Lane|VVD CD|CGO OPR|Cargo Vol.|Cargo Vol.|Cargo Vol.|R/H Unit|R/H Unit|R/H Moves|R/H Moves|C/C\nMoves|C/D/C\nMoves|R/H(%)\nRatio by Unit|R/H(%)\nRatio by Moves|";
	                 var HeadTitle2				= "|Port|Lane|VVD CD|CGO OPR|Full|Empty|Total|By OWN Acc.|By Others Acc.|By OWN Acc.|By Others Acc.|C/C\nMoves|C/D/C\nMoves|R/H(%)\nRatio by Unit|R/H(%)\nRatio by Moves|";

						if(!isNull(headTitleList)){
							for(var i=0; i < headTitleList.length; i++){
								HeadTitleAdd1	= HeadTitleAdd1+"|R/H Reason";
								HeadTitleAdd2	= HeadTitleAdd2+"|"+headTitleList[i];
							}
						}else{
							HeadTitleAdd1		= "|R/H Reason";
							HeadTitleAdd2		= "|R/H Reason";
						}
	                 
					 HeadTitleMerge1			= HeadTitle1 + HeadTitleAdd1;
					 HeadTitleMerge2			= HeadTitle2 + HeadTitleAdd2;
	                 var headCount				= ComCountHeadTitle(HeadTitleMerge1);
//	                 (headCount, 5, 0, true);
	                 
	                 SetHeaderRowHeight(10);
	                 var rowCnt		= 0;
	                 var prefix		= "sheet1_";
	
	                 SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
	                 var info    	= { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	                 
	                 var headers 	= [ { Text:HeadTitleMerge1, Align:"Center"},{ Text:HeadTitleMerge2, Align:"Center"} ];
	                 InitHeaders	(headers, info);
	
	                 var cols 		= [
	                      {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                	  {Type:"Text",      Hidden:0,  Width:72,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"fl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"mt",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tl",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"own_rh_unit",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"oth_rh_unit",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"own_rh_move",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"oth_rh_move",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cc_move",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cdc_move",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Float",     Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rh_unit_ratio", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rh_move_ratio", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                	  {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"restow_reason_list",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }	                	  
						  ];
	                 
						if(!isNull(headTitleList)){
							for(var i=0; i < headTitleList.length; i++){
								var col_fix	= (i+1 < 10 ? "0" + (i+1) : i+1);
								cols.push({Type:"Int",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_"+i,	KeyField:0,   CalcLogic:"",   Format:"Integer",	PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
							}
							
						}else{
							cols.push({Type:"Int",   Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn",	KeyField:0,   CalcLogic:"",   Format:"Integer",	PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
						}
						
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_cc",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_cr",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_ic",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_id",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_if",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_ig",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_ih",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_il",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_io",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_ip",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_ir",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_is",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_it",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_iw",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_ix",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						//{Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rsn_xx",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } 
						
						////];
						                  
	             InitColumns(cols);
	             SetEditable(0);
                 //SetSheetHeight(440);
	             resizeSheet();
			}
			break;
   		}
     }
     
     function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0]);
    	}

     
     // handling process related Sheet
     function doActionIBSheet(sheetObj,formObj,sAction, gubun) {
     	sheetObj.ShowDebugMsg(false);
     	switch(sAction) {
 			case IBSEARCH:      //Retrieve
 				if(validateForm(sheetObj,formObj,sAction)){
 					
 					//:2016-11-29:add extraction function for gathering restow code list://
 			     	var sRestowReasonList	= makeHeaderRestowReasonList(sheetObj);
 			     	
 			     	sheetObjects[0] = sheetObjects[0].Reset();
 			     	ComConfigSheet 			(sheetObjects[0]);
 			     	initSheet				(sheetObjects[0], 1, sRestowReasonList);
 			     	ComEndConfigSheet		(sheetObjects[0]);
 			     	//:2016-11-29:add extraction function for gathering restow code list://
 					
 			     	hideShowReason();
			   	    
 					formObj.f_cmd.value	= SEARCH;
 		        	var sParam			= FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") + "&restow_reason_list="+sRestowReasonList;
 		        	var sXml			= sheetObjects[0].GetSearchData("VOP_OPF_0061GS.do", sParam);
 					if(sXml.length>0){ 
 						sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 					}
 				}	
 				break;
 				
 			case IBCLEAR:
 				setObjValue("loc_cd", "");
				//comboObjects[0].RemoveAll();
        		//initCombo(comboObjects[0], 1); 
				comboObjects[0].SetSelectCode("ALL");
 				comboObjects[1].RemoveAll();
         		initCombo(comboObjects[1], 2);
 				setObjValue("slan_cd", ""); 
 				set_from_date();
 				 	
 				sheetObjects[0] = sheetObjects[0].Reset();
 			    ComConfigSheet 			(sheetObjects[0]);
 			    initSheet				(sheetObjects[0], 1, null);
 			    ComEndConfigSheet		(sheetObjects[0]);
 			     	
 				break;				
 			case IBROWSEARCH:	
 				if(gubun=="slanCd"){
 					formObj.f_cmd.value=COMMAND12;
 					var lanXml=sheetObjects[1].GetSearchData("VOP_VSK_0202GS.do?vsl_slan_cd="+formObj.slan_cd.value , FormQueryString(formObj));
 					var strLanCdDesc=ComGetEtcData(lanXml, "checkLane");
 					if(isNull(strLanCdDesc)){
 						ComShowCodeMessage("OPF50004", "Data");
 						setObjValue("slan_cd", "");
 						setFocus("slan_cd");
 						return false;
 					}
 				}
 				break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
          	if(!isNull(formObj.loc_cd.value)){
				if( formObj.loc_cd.value.length != 5 ){
					setObjValue("loc_cd", "");
					setFocus("loc_cd");
					return false;
				}
 			}
 			if(!isNull(formObj.slan_cd.value)){
				if( formObj.slan_cd.value.length != 3 ){
					setObjValue("slan_cd", "");
					setFocus("slan_cd");
					return false;
				}
 			}
 			
  			if(isNull(formObj.loc_cd.value)){
  				ComShowCodeMessage("OPF50009", "Port");
				formObj.loc_cd.focus();
				return false;
			}else if(isNull(formObj.from_date.value)){
				ComShowCodeMessage("OPF50009", "From to Date");
				formObj.from_date.focus();
				return false;
			}else if(isNull(formObj.to_date.value)){
				ComShowCodeMessage("OPF50009", "From to Date");
				formObj.to_date.focus();
				return false;
			}
         }
         return true;
     }
     // [t1sheet1] Event occured after retrieving by retrieve method
     function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 		if(sheetObj.RowCount()> 0){
 			/**
 			var color1="#E5EAFF";		
 			var color2="#F7E1EC";		
 			var color3="#6CC2D5";		
 			var color4="#EB7C98";		
 			**/			
 			//sheetObj.ColBackColor(1) = "#E8E7EC";
 			//setting Sub Total RGB 
 			var lastCol = sheetObj.LastCol();
 			
 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
 				var reason	= sheetObj.GetCellValue(i, "sheet1_restow_reason_list");
 				reason = reason.split("|");
 				for(var k=0; k<reason.length; k++){
 					sheetObj.SetCellValue(i, "sheet1_rsn_"+ k, reason[k], 0);
 				}
 				
 				if(sheetObj.GetCellValue(i, "sheet1_opr") == "S.Total"){
 					sheetObj.SetCellFont("FontBold", i,"sheet1_opr",1);
 					for(var j=4 ; j<=lastCol ; j++){
 						sheetObj.SetCellBackColor(i, j,"#E8E7EC");
 					}
 				}
 				if(sheetObj.GetCellValue(i, "sheet1_lane") == "Total"){
 					sheetObj.SetCellFont("FontBold", i,"sheet1_lane",1);
 					for(var j=2 ; j<=lastCol ; j++){
 						sheetObj.SetCellBackColor(i, j,"#F7E1EC");
 					}
 				}
 				if(sheetObj.GetCellValue(i, "sheet1_port") == "G.Total"){
 					sheetObj.SetCellFont("FontBold", i,"sheet1_port",1);
 					for(var j=1 ; j<=lastCol ; j++){
 						sheetObj.SetCellBackColor(i, j,"#F7E1EC");
 					}
 				}  				
 			}
 			//setting Grand Total RGB 
 			var allRowCount=sheetObj.LastRow();
 			for(var j=1 ; j<=lastCol ; j++){
 				sheetObj.SetCellFont("FontBold", allRowCount, j,1);
 				sheetObj.SetCellBackColor(allRowCount, j,"#F7E1EC");
 			}
 		}    	
     }
 	/**
      * Get Object Value
      */
     function getObjValue(name) {
     	return ComGetObjValue(eval("document.form."+name));
     }
     /**
      * Set Object Value
      */
     function setObjValue(name, value) {
     	ComSetObjValue(eval("document.form."+name), value);
     }
     /**
      * Move Focus in Object
      */
     function setFocus(name) {
     	ComSetFocus(eval("document.form."+name));
     	eval("document.form."+name).select();
     }    
     /**
      * checking Null in window form input value
      */
     function isNull(itemValue){
         if(itemValue==null || itemValue=="" || itemValue=="undefined"){
         	return true;
         }
         else{
         	return false;
         }
     }    
     function hideShowReason(){
    	var rhReasonFlg = !document.form.rh_reason.checked;
   	    for (var i = 0; i <= sheetObjects[0].LastCol(); i++) {
   	    	if (sheetObjects[0].GetCellValue(0, i).indexOf("R/H Reason") >= 0){
   	    		sheetObjects[0].SetColHidden(i, rhReasonFlg);
   	    	}
   	    }
   	    if (document.form.rh_reason.checked) {
   	    	sheetObjects[0].SetColWidth("sheet1_rh_move_ratio", 95);
        }
     }
	/* Developer performance  end */
