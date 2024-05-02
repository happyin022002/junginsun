/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0517.js
*@FileTitle  : VOSI Update Monitoring
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
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
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        var sheetObject1=sheetObjects[0];   //t1sheet1
        var sheetObject2=sheetObjects[1];   //temp sheet
        var formObject=document.form;
     	try {
     		var srcName= ComGetEvent("name");
     		if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_Monitoring_Port":
					sUrl="/opuscntr/VOP_VSK_0033.do";
//					ComOpenWindow("VOP_VSK_0033.do", "", "width=1000,height=560", true);
					ComOpenPopup(sUrl, 722, 490, "getMonitoringPortHelp", "0,0", true);
					break;
				case "btn_Excel":
					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					break;
				case "btn_loc_cd":	//Location popup
					sUrl="/opuscntr/VOP_VSK_0043.do";
					ComOpenPopup(sUrl, 522, 560, "returnPortHelp", "0,0", true);
					
					break;
	            case "btns_calendar": //calendar
	                var cal=new ComCalendar();
	               // cal.select(formObject.sel_date, 'yyyy-MM-dd');
	               cal.setDisplayType('year');
	               cal.select(formObject.sel_date, 'yyyy');
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
	 * after [Port] Button Click, calling from Pop-up
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.loc_cd.value=rtnDatas;
				}
			}
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
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
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
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initCombo(comboObjects[0]);
        doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
        initControl();
        //Setting Total Head Color
        //sheetObjects[0].SetCellBackColor(0, 19,"#6CC2D5");
        //sheetObjects[0].SetCellBackColor(1, 19,"#6CC2D5");
        //sheetObjects[0].SetCellBackColor(1, 20,"#6CC2D5");
    }
	/**
	 * setting combo initial values and header
	 * param : comboObj, comboNo
	 * adding case as numbers of counting combos 
	 */ 
	function initCombo(comboObj) {
		var i=0;
   	    switch(comboObj.options.id) {
			case "rhq":
				with(comboObj) {
					comboObj.SetDropHeight(125);
					InsertItem(i++,  "ALL",  "^");
					comboObj.SetSelectCode("^");
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
 		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            with(sheetObj){
              var HeadTitle1="|RHQ|PORT|Port Information Update Ratio (%)|Port Information Update Ratio (%)|Port Information Update Ratio (%)|Port Information Update Ratio (%)|Port Information Update Ratio (%)|Port Information Update Ratio (%)|Port Information Update Ratio (%)|";
              HeadTitle1 += "TMNL Information Update Ratio (%)|TMNL Information Update Ratio (%)|TMNL Information Update Ratio (%)|TMNL Information Update Ratio (%)|TMNL Information Update Ratio (%)|TMNL Information Update Ratio (%)|";
              HeadTitle1 += "Berth Window (%)|Berth Window (%)|Total Update Ratio (%)|Total Update Ratio (%)";
              var HeadTitle2="|RHQ|PORT|Maneuvering|Maneuvering|Non Working|Trucking|Trucking|Railroad|Railroad|G/Crane|G/Crane|F/Crane|F/Crane|G/Structure|G/Structure|1st|2nd|1st|2nd";
              var HeadTitle3="|RHQ|PORT|1H|2H|Yearly|1H|2H|1H|2H|1H|2H|1H|2H|1H|2H|1H|2H|1H|2H";
              var headCount=ComCountHeadTitle(HeadTitle1);
              var prefix="sheet1_";

              SetConfig( { SearchMode:2, MergeSheet:7, Page:990, FrozenCol:0, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"},
                          { Text:HeadTitle3, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rhq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"manu_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"manu_2nd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"nonw_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"truc_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"truc_2nd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rail_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rail_2nd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gcrn_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gcrn_2nd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fcrn_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"fcrn_2nd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gstr_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"gstr_2nd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bwin_1st2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bwin_2nd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Float",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tot_1st",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
		                     {Type:"Float",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tot_2nd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1,   UpdateEdit:0,   InsertEdit:1 },
	                     ];
               
		              InitColumns(cols);
		              SetCountPosition(0);
		              SetSheetHeight(402);
		              resizeSheet();
                    }
              break;
 		}
	}
    /** 
     * initControl()
     */ 
    function initControl() {
    	axon_event.addListenerFormat('keypress'	, 'obj_keypress'		, form);
    	axon_event.addListenerFormat('keyup'	, 'obj_keyup'			, form);
    	axon_event.addListener		('change'	, 'loc_cd_onchangeMax5'	, 'loc_cd', ''); //loc_cd change Event
    	axon_event.addListener		('keydown'	, 'ComKeyEnter'			, 'form');
    }
    /** 
     * Handling key press event
     */ 
    function obj_keypress(){
     	obj=event.srcElement;
     	if(obj.dataformat == null) return;
     	window.defaultStatus=obj.dataformat;
     	switch(obj.dataformat) {
     	    case "engup":
     	        ComKeyOnlyAlphabet('upper');
     	        break;
     	    case "engdn":
     	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
     	        else ComKeyOnlyAlphabet('lower');
     	        break;
     	    case "ymd":
     	    	ComKeyOnlyNumber(event.srcElement);
     	        break;     	        
            default:
                ComKeyOnlyNumber(event.srcElement);
     	}
    }
    /** 
     * Handling key up event
     */ 
    function obj_keyup(){
     	obj=event.srcElement;
     	if(obj.dataformat == null) return;
     	window.defaultStatus=obj.dataformat;
     	switch(obj.dataformat) {
     	    case "engup":
     	        if(document.form.loc_cd.value.length == 5 ){    	        	
     	        	loc_cd_onchange();
     	        }
     	        break;
     	    case "engdn":
     	        if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
     	        else ComKeyOnlyAlphabet('lower');
     	        break;
     	}
    } 
    /** 
     * Cheking Port Code length is 5
     */ 
	function loc_cd_onchangeMax5(){
		var formObj=document.form;
		if(formObj.loc_cd.value != ""){
			//alert("LOC_CD = "+formObj.loc_cd.value);
			if(formObj.loc_cd.value.length < 5 ){
				ComShowCodeMessage("VSK50014");
				ComAlertFocus(formObj.loc_cd, "");
				return ;
			}
		}
	}
	//Handling Port Code change event
	function loc_cd_onchange(){
	    var formObj=document.form;
		formObj.f_cmd.value=SEARCH01;
		var sRhqXml=sheetObjects[1].GetSearchData("VOP_VSK_0517GS.do", FormQueryString(formObj));
		var sRhqVal=ComGetEtcData(sRhqXml, "cmbVal");
		var sRhqName=ComGetEtcData(sRhqXml, "cmbName");
		if( sRhqVal != "")
		{
			var arrRhqVal=sRhqVal.split("|");
			var arrRhqName=sRhqName.split("|");
			for(var i=0; i<arrRhqVal.length ; i++)
			{
				rhqChangeFlg=false;
				comboObjects[0].SetSelectCode(arrRhqVal[0],false);
			}
		}else{
			ComShowCodeMessage('VSK50015', formObj.loc_cd.value);
			ComClearObject(formObj.loc_cd);
			comboObjects[0].SetSelectCode("^",false);
		}
	}
	//Handling RHQ change event
    function rhq_OnChange(comObj,index,text)
    {
    	var formObj=document.form;
		formObj.loc_cd.value="";
    }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
 			case IBSEARCH:      //Retrieve
 				if(validateForm(sheetObj,formObj,sAction)){
 					formObj.f_cmd.value=SEARCH;
 					sheetObj.DoSearch("VOP_VSK_0517GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
 				}	
 				break;
			case IBCLEAR:
				formObj.loc_cd.value="";
				comboObjects[0].RemoveAll();
		        initCombo(comboObjects[0], 1);
				formObj.sel_date.value=formObj.nowDate.value;            		
				sheetObj.RemoveAll();
				break;
			case SEARCH01:
				formObj.f_cmd.value=SEARCH01;
				var sParam=FormQueryString(formObj)
				var sXml=sheetObj.GetSearchData("VOP_VSK_0221GS.do", sParam);
				var rhqlist=ComGetEtcData(sXml, "rhqlist");
				if(rhqlist){
					var comboObj=comboObjects[0];
					var rhqs=rhqlist.split(":");
					for(var i=0; i<rhqs.length; i++){
						comboObj.InsertItem(-1, rhqs[i], rhqs[i]);
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
        	 if(ComIsEmpty(formObj.sel_date.value)){
				ComShowCodeMessage("COM12114", "Date");
				ComAlertFocus(formObj.sel_date, "");
				return false;
         	}
         }
         return true;
     }
	// process after retrieve
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		if(sheetObj.RowCount()> 0){
			/**
			var color1="#E5EAFF";		// sky-blue
			var color2="#F7E1EC";		// pink
			var color3="#6CC2D5";		// light blue
			var color4="#EB7C98";		// light red
			**/
			sheetObj.SetColBackColor(1,"#E5EAFF");
			sheetObj.SetColBackColor(2,"#E5EAFF");
			//Setting Sub Total RGB
			for(var i=0 ; i<= sheetObj.RowCount()+2 ; i++){
				if(sheetObj.GetCellValue(i, "sheet1_port") == "Sub Total"){
					sheetObj.SetCellFont("FontBold", i,2,1);
					for(var j=2 ; j<21 ; j++){
						sheetObj.SetCellBackColor(i, j,"#F7E1EC");
					}
				}
			}
			//Setting Total RGB
			var allRowCount=sheetObj.RowCount()+2;
			for(var j=1 ; j<21 ; j++){
				sheetObj.SetCellFont("FontBold", allRowCount(), j,1);
				sheetObj.SetCellBackColor(allRowCount(), j,"#F7E1EC");
			}
		}
	}
    /**
     * Checking Null
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
