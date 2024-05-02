/*=========================================================

*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0069.js
*@FileTitle  : VOP_OPF_0069
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
     * @class VOP_OPF_0069 : VOP_OPF_0069 business script for
     */
    function VOP_OPF_0069() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
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
		　
		var sheetObject1=sheetObjects[0];   //t1sheet1
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			var obj = event.target || event.srcElement;
			   if ($(obj).prop('disabled')) {
			 return;
			 }
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_Excel":
					//sheetObject1.Down2Excel(-1);
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						}
					
					break;					
	   			case "btn_loc_cd":	//Location retrieve pop-up
	   				var loc_cd=formObject.loc_cd.value;
	   		    	var sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="+loc_cd;
//	   				var rVal=ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
//	   				if(rVal){
//	   					formObject.loc_cd.value=rVal;
//	   					loc_cd_onchange();
//	   				} 
	   		    	ComOpenPopup(sUrl, 422, 520, "setPortCode", "0,0", true);
	   				break;
	   			case "btn_target_lanes":
	   		    	var sUrl="/opuscntr/VOP_OPF_0067.do";
	   				ComOpenPopup(sUrl, 600, 480, "", "0,0", true, false, "", "", "","");
	   				break;
	   			case "btn_target_ports":
	   		    	var sUrl="/opuscntr/VOP_OPF_0068.do";
	   				ComOpenPopup(sUrl, 600, 540, "", "0,0", true, false, "", "", "","");
	   				break;
	   	        case "from_calendar": // From calendar button
                	var cal=new ComCalendar();
                	cal.setDisplayType('month');
                	cal.select(formObject.from_date, 'yyyy-MM');
	   	            break;
	   	        case "to_calendar": // From calendar button
                	//var cal = new ComCalendarFromTo();
                	//cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM');
                	var cal=new ComCalendar();
                	cal.setDisplayType('month');
                	cal.select(formObject.to_date, 'yyyy-MM');
	   	            break;
				case "btn_Detail":
					var sUrl="";				
					if(sheetObject1.RowCount()> 1){
						var sName=sheetObject1.ColSaveName(sheetObject1.GetSelectCol());
						var vRhq=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_rhq");
						var vPort=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_port");
						var vYard="";
						var vLane="";
						if( comboObjects[3].GetSelectCode()== "M"){
							if(sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_month").length != 6){
								break;
							}
							if( sName != "sheet1_port"){
								break;
							}
							vYard=comboObjects[1].GetSelectCode();
							vLane=comboObjects[2].GetSelectCode();
						}else{
							if(sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_lane").length != 3){
								break;
							}
							if( sName == "sheet1_port" || sName == "sheet1_yard"){
								if (sName == "sheet1_yard") {
									vYard=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_yard");
									//vLane = sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_lane");
								}
								vLane=comboObjects[2].GetSelectCode();
							}else{
								break;
							}							
						}						
                		sUrl="/opuscntr/VOP_OPF_2069.do?rhq="+vRhq+"&port="+vPort+"&yard="+vYard+"&lane="+vLane
                		                                     +"&group_by="+comboObjects[3].GetSelectCode()
                											 +"&from_date="+getObjValue("from_date")
                											 +"&to_date="+getObjValue("to_date")
                											 +"&tml_prod_rpt_rsn_cd="+getObjValue("tml_prod_rpt_rsn_cd")
                											 +"&carr_cd="+getObjValue("carr_cd")
                											 +"&target_lanes="+comboObjects[4].GetSelectCode()
                											 +"&target_ports="+comboObjects[5].GetSelectCode();
//                		ComOpenPopup(sUrl, 900, 420, "", "0,0", true, false, "", "", "","TDR Details");
                		ComOpenPopup(sUrl, 905, 420, "", "0,0", true, false, "", "", "","TDR Details");
					}else{
						ComShowCodeMessage("COM12177");
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
  	    //RHQ combo 
  	    setRhq();
  	    //Lane combo
  	    //setSlan_cd("");
  	    ComBtnDisable("btn_Detail");
     	//From Date 
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
		comboObjects[0].InsertItem(0, "All", "ALL");
		comboObjects[0].SetSelectText("All");		
	}	
	
	
    /* get RSO combo */
	function setSlan_cd(tml_prod_rpt_flg){
		var formObj=document.form;
		formObj.tml_prod_rpt_flg.value=tml_prod_rpt_flg;
		formObj.f_cmd.value=SEARCH;
		var sRhqXml=sheetObjects[1].GetSearchData("VOP_OPF_0067GS.do",FormQueryString(formObj));
		ComXml2ComboItem(sRhqXml, comboObjects[2], "vsl_slan_cd", "vsl_slan_cd|vsl_slan_cd");
		comboObjects[2].InsertItem(0, "All","ALL");
		comboObjects[2].SetSelectText("All");
	}	
	//From Date 
	function set_from_date(){
		var formObj=document.form;
		var vNowDate=formObj.now_date.value;
		var vlastDay=formObj.last_day.value;
		formObj.from_date.value=ComGetDateAdd(vNowDate, "M", -2).substr(0, 7);
		formObj.to_date.value=vlastDay.substr(0,4)+"-"+vlastDay.substr(4,2); 
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
			case "slan_cd":
				with(comboObj) {
					comboObj.SetDropHeight(200);
	        	}
				break;				
			case "group_by":
				with(comboObj) {
					comboObj.SetDropHeight(60);
					InsertItem(i++,  "By Lane", "L");
					InsertItem(i++,  "By Month", "M");
					comboObj.SetSelectCode("L");
	        	}
				break;
			case "target_lanes":
				with(comboObj) {
					comboObj.SetDropHeight(60);
					InsertItem(i++,  "All",  "ALL");
					InsertItem(i++,  "Target Lanes Only", "Y");
					comboObj.SetSelectCode("Y");
	        	}
				break;			
			case "target_ports":
				with(comboObj) {
					comboObj.SetDropHeight(60);
					InsertItem(i++,  "All",  "ALL");
					InsertItem(i++,  "Target Ports Only", "B");
					comboObj.SetSelectCode("B");
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
 	 * handling about Object Deactivate event in Form.
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
		}
	}
    /** 
     * handling work javascript OnFocus event  <br>
     */    
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
	//RHQ change event
    function rhq_OnChange(comObj,index,text)
    {
    	var formObj=document.form;
		formObj.loc_cd.value="";
		comboObjects[1].RemoveAll();  //initialize YD_CD combo
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
//					class_name();
				}else{
//					class_name_all();
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
	
    /**
     * popup Data Validation method input in Key
     */
    function change_event() {
    	var elementObj=event.srcElement;
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
        	}
    		doActionIBSheet(sheetObj, document.form, IBROWSEARCH, gubun);
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
	//Group change event Find or create function combo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)

    function group_by_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
    {
    	sheetObjects[0].RemoveAll();
    	if(newIndex == "L"){
    		sheetObjects[0].SetColHidden("sheet1_yard",0);
    		sheetObjects[0].SetColHidden("sheet1_lane",0);
    		sheetObjects[0].SetColHidden("sheet1_month",1);
    		sheetObjects[0].FrozenCols=5;
    	}else if(newIndex == "M"){
    		sheetObjects[0].SetColHidden("sheet1_yard",1);
    		sheetObjects[0].SetColHidden("sheet1_lane",1);
    		sheetObjects[0].SetColHidden("sheet1_month",0);
    		sheetObjects[0].FrozenCols=6;
    	}
    	ComBtnDisable("btn_Detail");
    }  
	//Target Lanes Only change event
    function target_lanes_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
    {
  	    //Lane combo
  	    //setSlan_cd("");
  	    if(newIndex == "Y"){
  	    	setSlan_cd("Y");
  	    }else{
  	    	setSlan_cd("");
  	    }
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

	                var HeadTitle1="|RHQ|Port|Yard|Lane|Month|TTL TDR|TTL\nMoves|Gross\nWorking HRS|Gross\nGang HRS|Gross\nTMNL PROD|Gross\nGang PROD|Average\nNo. of Crane";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                (headCount, 6, 0, true);
	                var prefix="sheet1_";
	
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:200, DataRowMerge:0 } );
	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rhq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yard",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lane",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"month",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"tdr_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"tot_mvs",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"work_gross", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"gang_gross", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"tmnl_prod",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"gang_prod",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:prefix+"avg_clan",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(0);
	                SetColHidden("sheet1_month",1);
	                SetDataLinkMouse(prefix+"yard",1);
	                //SetSheetHeight(402);
	                resizeSheet();
				}
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}

	
	// handling process related Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
 			case IBSEARCH:      //Retrieve
 				if(validateForm(sheetObj,formObj,sAction)){
 					formObj.f_cmd.value=SEARCH;
 		        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 		        	var sXml=sheetObj.GetSearchData("VOP_OPF_0069GS.do", sParam);
 					if(sXml.length>0){ 
 						sheetObj.LoadSearchData(sXml,{Sync:0} );
 						sheetObj.SetColFontUnderline( sheetObj.id+"_yard",1);
 					}
 				}	
 				break;
 			case IBCLEAR:
 				setObjValue("loc_cd", "");
				//comboObjects[0].RemoveAll();
        		//initCombo(comboObjects[0], 1); 				
 				set_from_date();
 				formObj.tml_prod_rpt_rsn_cd.checked=false;
 				formObj.carr_cd1.checked=true;
 				formObj.carr_cd2.checked=false;
 				comboObjects[0].SetSelectCode("ALL");
 				comboObjects[2].SetSelectCode("ALL");
 				comboObjects[3].SetSelectCode("L");
 				comboObjects[4].RemoveAll();
         		initCombo(comboObjects[4], 2);
 				comboObjects[5].RemoveAll();
         		initCombo(comboObjects[5], 3);
 				sheetObj.RemoveAll();
 				ComBtnDisable("btn_Detail");
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
					setFocus("loc_cd");
					return false;
				}
 			}
			if(isNull(formObj.from_date.value)){
				ComShowCodeMessage("OPF50009", "Period");
				formObj.from_date.focus();
				return false;
			}else if(isNull(formObj.to_date.value)){
				ComShowCodeMessage("OPF50009", "Period");
				formObj.to_date.focus();
				return false;
			}
			//Carrier Code 
			//if()
			if(formObj.carr_cd1.checked && formObj.carr_cd2.checked){// OWN, OTHER
				formObj.carr_cd.value="";
			}else if(formObj.carr_cd1.checked && !formObj.carr_cd2.checked){// OWN
				formObj.carr_cd.value=formObj.carr_cd1.value;
			}else if(!formObj.carr_cd1.checked && formObj.carr_cd2.checked){// OTHER
				formObj.carr_cd.value=formObj.carr_cd2.value;
			}else{
				formObj.carr_cd.value="X";
			}
         }
         return true;
     }
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			//sheetObj.SetMergeCell(sheetObj.LastRow, 1, 1, 2);
 	 		if(sheetObj.RowCount()> 0){
 	 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
 	 				if(sheetObj.GetCellValue(i, "sheet1_rhq") == "S.Total"){
 	 					sheetObj.SetCellFont("FontBold", i,"sheet1_rhq",1);
 	 					sheetObj.SetCellAlign(i, "sheet1_rhq","Left");
 	 					for(var j=1 ; j<13 ; j++){
 	 						sheetObj.SetCellBackColor(i, j,"#E8E7EC");
 	 					}
 	 				} 	 				
 	 				if(sheetObj.GetCellValue(i, "sheet1_port") == "S.Total"){
 	 					sheetObj.SetCellFont("FontBold", i,"sheet1_port",1);
 	 					sheetObj.SetCellAlign(i, "sheet1_port","Left");
 	 					for(var j=1 ; j<13 ; j++){
 	 						sheetObj.SetCellBackColor(i, j,"#E8E7EC");
 	 					}
 	 				}
 	 			}
 	 			if(sheetObj.RowCount()> 2){
	 	 			//setting Grand Total RGB 
	 	 			var allRowCount=sheetObj.LastRow();
	 	 			for(var j=1 ; j<=12 ; j++){
	 	 				sheetObj.SetCellFont("FontBold", allRowCount-1, j,1);
	 	 				sheetObj.SetCellFont("FontBold", allRowCount, j,1);
	 	 				sheetObj.SetCellBackColor(allRowCount-1, j,"#F7E1EC");
	 	 				sheetObj.SetCellBackColor(allRowCount, j,"#F7E1EC");
	 	 			}
 	 			}
 				//sheetObj.RowMerge(sheetObj.LastRow-1) = true;
 				//sheetObj.RowMerge(sheetObj.LastRow) = true;
 				sheetObj.SetCellAlign(sheetObj.LastRow()-1, "sheet1_rhq","Left");
 				sheetObj.SetCellAlign(sheetObj.LastRow(), "sheet1_rhq","Left");
 				sheetObj.SetMergeCell(sheetObj.LastRow(), 1, 1, 2);
 	 		} 			
		}
	}
    function sheet1_OnClick(sheetObj, Row, Col){
    	var sName=sheetObj.ColSaveName(Col);
		if( comboObjects[3].GetSelectCode()== "M"){
			if( sName == "sheet1_port"){
				if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_port").length == 5){
					ComBtnEnable("btn_Detail");
				}else{
					ComBtnDisable("btn_Detail");
				}
			}else{
				ComBtnDisable("btn_Detail");
			}
		}else{
			if( sName == "sheet1_port" ||  sName == "sheet1_yard"){
				if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_port").length == 5
						|| sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_yard").length == 7){
					ComBtnEnable("btn_Detail");
				}else{
					ComBtnDisable("btn_Detail");
				}
			}else{
				ComBtnDisable("btn_Detail");
			}			
		}
    }
    function sheet1_OnDblClick(sheetObj, Row, Col){
    	var sName=sheetObj.ColSaveName(Col);
    	var vRhq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_rhq");
    	var vPort=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_port");
		var vYard="";
		var vLane="";
		if( comboObjects[3].GetSelectCode()== "M"){
			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_month").length != 6){
				return false;
			}
			if( sName != "sheet1_port"){
				return false;
			}
			vYard=comboObjects[1].GetSelectCode();
			vLane=comboObjects[2].GetSelectCode();
		}else{
			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_lane").length != 3){
				return false;
			}
			if( sName == "sheet1_port" || sName == "sheet1_yard"){
				if (sName == "sheet1_yard") {
					vYard=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_yard");
					//vLane = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_lane");
				}
				vLane=comboObjects[2].GetSelectCode();
			}else{
				return false;
			}
		}
		sUrl="/opuscntr/VOP_OPF_2069.do?rhq="+vRhq+"&port="+vPort+"&yard="+vYard+"&lane="+vLane
		                                     +"&group_by="+comboObjects[3].GetSelectCode()
											 +"&from_date="+getObjValue("from_date")
											 +"&to_date="+getObjValue("to_date")
											 +"&tml_prod_rpt_rsn_cd="+getObjValue("tml_prod_rpt_rsn_cd")
											 +"&carr_cd="+getObjValue("carr_cd")
											 +"&target_lanes="+comboObjects[4].GetSelectCode()
											 +"&target_ports="+comboObjects[5].GetSelectCode();
		ComOpenPopup(sUrl, 900, 450, " ", "0,0", true, false, "", "", "","TDR Details");
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
