/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0064.js
*@FileTitle  : VSL Condition Statistics
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
     * @class VOP_OPF_0064 : VOP_OPF_0064 business script for
     */
   	/* Developer performance	*/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
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
//					var rVal=ComOpenPopupWithTarget(sUrl, 425, 520, "", "0,0", true);
//					if(rVal){
//						formObject.loc_cd.value=rVal;
//						loc_cd_onchange();
//					} 
					ComOpenPopup(sUrl, 422, 520, "setPortCode", "0,0", true);
					break;
	            case "vsl_cd_pop":
	            	var vsl_cd=formObject.vsl_cd.value;
	            	ComOpenPopup("VOP_VSK_0219.do?vsl_cd="+vsl_cd, 460, 500, "event_vsl_cd_pop", "0,0", true);
	            	break;					
				case "btn_slan_cd_pop":
					var slan_cd=formObject.slan_cd.value;
					ComOpenPopup("VOP_VSK_0202.do?vsl_slan_cd="+slan_cd, 420, 480, "slan_cd_pop_event", "0,0", true);
					break;
				case "from_calendar": // From calendar button
				    var cal=new ComCalendar();
				    cal.select(formObject.from_date, 'yyyy-MM-dd');
				    break;
				case "to_calendar": // From  calendar button
				    var cal=new ComCalendar();
				    cal.select(formObject.to_date, 'yyyy-MM-dd');
				    break;
				case "from_to_calendar": // From  calendar button
					var cal=new ComCalendarFromTo();
					cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
				    break;
				case "rh_reason":
					var rhReasonFlg=false;
					if(document.form.rh_reason.checked)
						rhReasonFlg=false;
					else
						rhReasonFlg=true;
					//sheetObject1.Redraw = false;
					for (i=0; i<=sheetObject1.LastCol(); i++) {
						if (sheetObject1.SetCellValue(0,i).indexOf("R/H Reason") >= 0) sheetObject1.GetColHidden(i,rhReasonFlg);
					}
					//sheetObject1.Redraw = true;
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
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//initializing IBMultiCombo
		for(var c=0; c<comboObjects.length; c++){
			initCombo(comboObjects[c], c+1);
		}  
		//setting From Date 
		set_from_date();
		initControl();
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
	 * param : comboObj , comboNo 　
	 *adding case as numbers of counting combos
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.options.id) {
			case "yd_cd":
				with(comboObj) {
					InsertItem(i++,  "All",  "");
					comboObj.SetSelectText("All");
	        	}
				break;
		}
	}
 	/** 
     * initControl()
     */ 
	function initControl() {
		axon_event.addListenerForm('deactivate', 'obj_deactivate', form);
		axon_event.addListenerFormat('focus', 'obj_activate', form);
		axon_event.addListenerForm ('blur', 'obj_blur', form);
		
		axon_event.addListenerForm('keyup', 'obj_keyup', form);
	}    
 
 	/**
 	 * handling in case of Object Deactivate event in form
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
					comboObjects[0].RemoveAll();  //initialize YD_CD combo
					comboObjects[0].InsertItem(0, "All","");
					comboObjects[0].SetSelectText("All");
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
    		case "vsl_cd":
    			if( formObj.vsl_cd.value != ""){
    				if(!ComChkObjValid(obj)){
    					setFocus("vsl_cd");
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
                    		}else{
                        		ComAddSeparator(ComGetEvent());
                        	}
                		}else{
                    		ComAddSeparator(ComGetEvent());
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
                    		}else{
                        		ComAddSeparator(ComGetEvent());
                        	}
                		}else{
                    		ComAddSeparator(ComGetEvent());
                    	}
                    }
                }
    			break;
    	}
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
//					class_name();
				}else{
//					class_name_all();
				}
				break;
				
			case "slan_cd":
				if( formObj.slan_cd.value.length == 3 ){
					change_event();
//					class_name();
				}else{
//					class_name_all();
				}
				break;

       	}
    }
    
   	//Port Code change event and YD_CD combo creation
   	function loc_cd_onchange(){
   		comboObjects[0].RemoveAll();  //initialize YD_CD combo
   		var formObj=document.form;
   		formObj.f_cmd.value=SEARCH01;
   		var sRhqXml=sheetObjects[1].GetSearchData("VOP_OPF_0057GS.do", FormQueryString(formObj));
		if(ComGetTotalRows(sRhqXml) == 0){
			ComAlertFocus(formObj.loc_cd, ComGetMsg("OPF50004", "Data"));
			setObjValue("loc_cd", "");
			setFocus("loc_cd");
		}else{
			comboObjects[0].SetDropHeight(200);
			ComXml2ComboItem(sRhqXml, comboObjects[0], "yd_cd", "yd_cd|yd_nm");
		}
		comboObjects[0].InsertItem(0, "All","");
		comboObjects[0].SetSelectText("All");
		if(formObj.loc_cd.value == ""){
			comboObjects[0].RemoveAll();  //initialize YD_CD combo
   			comboObjects[0].InsertItem(0, "All","");
   			comboObjects[0].SetSelectText("All");
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
    		// Length Check
	    	if(elementObj.maxLength != elementObj.value.length){
	    		ComShowCodeMessage("OPF50007",elementObj.caption,elementObj.maxLength);
	    		elementObj.focus();
	    		return false;
	    	}
    		// Popup Data Validation Check!
    		if(elementObj.name=="slan_cd"){
        		gubun="slanCd";
        	}else if(elementObj.name=="vsl_cd"){
    			gubun="vslCd";
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
    	}
    }   	
    /**
     * slan_cd Data PopUp Value input method
     */
    function slan_cd_pop_event(aryPopupData) {
    	document.form.slan_cd.value=aryPopupData[0][1];
    }
    /**
     * vsl_cd Data PopUp Value input method
     */
    function event_vsl_cd_pop(aryPopupData) {
    	document.form.vsl_cd.value=aryPopupData[0][1];
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
				with (sheetObj) {

		            var HeadTitle1="|Lane|VVD|Port|ATA|ATB|ATD|Draft|Draft|Draft|Draft|Ballast|Ballast|Stability|Stability|";
		            HeadTitle1 += "Bunker|Bunker|Bunker|Bunker|Bunker|Bunker|Bunker|Bunker|Bunker Supply\nIn Port|Bunker Supply\nIn Port|Bunker Supply\nIn Port|Bunker Supply\nIn Port|";
		            HeadTitle1 += "Bunker Consumption\nIn Port|Bunker Consumption\nIn Port|Bunker Consumption\nIn Port|Bunker Consumption\nIn Port|";
		            HeadTitle1 += "Bunker Consumption\nDuring Port to Port|Bunker Consumption\nDuring Port to Port|Bunker Consumption\nDuring Port to Port|Bunker Consumption\nDuring Port to Port";
		            var HeadTitle2="|Lane|VVD|Port|ATA|ATB|ATD|Arrival|Arrival|Departure|Departure|Arr|Dept|Arr|Dept|";
		            HeadTitle2 += "Arrival|Arrival|Arrival|Arrival|Departure|Departure|Departure|Departure|";
		            HeadTitle2 += "F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO";
		            var HeadTitle3="|Lane|VVD|Port|ATA|ATB|ATD|AFT|FWD|AFT|FWD|Arr|Dept|Arr|Dept|";
		            HeadTitle3 += "F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO|F.O.|D.O.|LSFO|LSDO";
		            var headCount=ComCountHeadTitle(HeadTitle1);
		            //(headCount, 0, 0, true);
		            var prefix="sheet1_";
	
		            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
	
		            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		            var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"},
		                      { Text:HeadTitle3, Align:"Center"} ];
		            InitHeaders(headers, info);
	
		            var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eta",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"etb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"etd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ada",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"adf",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dda",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddf",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ba",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bd",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sa",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sd",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"afo",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ado",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"alsfo",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"alsdo",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dfo",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ddo",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dlsfo",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dlsdo",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsfo",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bsdo",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bslsfo",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bslsdo",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bcfo",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bcdo",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bclsfo",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bclsdo",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bcdfo",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bcddo",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bcdlsfo", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"bcdlsdo", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		             
		            InitColumns(cols);
	
		            SetEditable(0);
		           // SetSheetHeight(440);
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
					formObj.f_cmd.value=SEARCH;
		        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
		        	var sXml=sheetObj.GetSearchData("VOP_OPF_0064GS.do", sParam);
					if(sXml.length>0){ 
						sheetObj.LoadSearchData(sXml,{Sync:0} );
					}
				}	
				break;
			case IBCLEAR:
				setObjValue("loc_cd", "");
				comboObjects[0].RemoveAll();
				initCombo(comboObjects[0], 1);
				setObjValue("vsl_cd", "");
				setObjValue("slan_cd", ""); 
				set_from_date();
				sheetObj.RemoveAll();
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
				}else if(gubun=="vslCd"){
					formObj.f_cmd.value=COMMAND16;
					var vslXml=sheetObj.GetSearchData("VOP_VSK_0219GS.do?vsl_cd="+formObj.vsl_cd.value , FormQueryString(formObj));
					var strVslCd=ComGetEtcData(vslXml, "vsl_eng_nm");
					if(isNull(strVslCd)){
						ComShowCodeMessage("OPF50004", "Data");
	 					setObjValue("vsl_cd", "");
	 					setFocus("vsl_cd");		    			  
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
			if(isNull(formObj.slan_cd.value)){
				ComShowCodeMessage("OPF50009", "Lane");
				formObj.slan_cd.focus();
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
	/* Developer performance  end */
