/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0514.js
*@FileTitle  : SHA Tide Information Creation
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
        var sheetObject2=sheetObjects[1];   //t1sheet1
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_Retrieve":
					 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					 doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_Save":
					 doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_Excel":
 					sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
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
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initCombo(comboObjects[0], 1);
        initCombo(comboObjects[1], 2);
        initControl();
    }
	/**
	 * setting combo initial values and header
	 * param : comboObj, comboNo
	 * adding case as numbers of counting combos 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
   	    switch(comboObj.options.id) {
			case "tide_yr":  
				with(comboObj) {
					comboObj.SetDropHeight(300);
					comboObj.SetBackColor("#CCFFFD");
					for(var j=6; j<=20 ; j++)
					{
						if(j < 10 )
							InsertItem(i++,  "200"+j,  "200"+j);
						else
							InsertItem(i++,  "20"+j,  "20"+j);
					}
					Code=document.form.nowYear.value;
					comboObj.SetSelectText(Code);
				}
				break;
			case "tide_mon":  
				with(comboObj) {
					comboObj.SetDropHeight(300);
					comboObj.SetBackColor("#CCFFFD");
					for(var j=1; j<=12 ; j++)
					{
						if(j < 10 )
							InsertItem(i++,  "0"+j, j);
						else
							InsertItem(i++,  ""+j,  j);
					}
					Text=document.form.nowMonth.value;
					comboObj.SetSelectText(Text);
				}
				break;				
		}
	}  
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     * 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            with(sheetObj){
              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
              var HeadTitle1="|Port Code|Year|Month|Day|1st Time|1st Time|Max Draft|Max Draft|2nd Time|2nd Time|Max Draft|Max Draft||";
              var HeadTitle2="|Port Code|Year|Month|Day|HH:MM (In)|HH:MM (Out)|High (In)|High (Out)|HH:MM (In)|HH:MM (Out)|High (In)|High (Out)||";
              var headCount=ComCountHeadTitle(HeadTitle1);
              var prefix="sheet1_";

              SetConfig( { SearchMode:2, MergeSheet:1, Page:100, FrozenCol:0, DataRowMerge:0 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"loc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tide_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tide_mon",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tide_dy",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_tide_fm_hrmnt", KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_tide_to_hrmnt", KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_high_tide_hgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"n1st_low_tide_hgt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_fm_tide_hrmnt", KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_to_tide_hrmnt", KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_high_tide_hgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_low_tide_hgt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
               
              InitColumns(cols);
              resizeSheet();
              //SetSheetHeight(442);
             }
            break;	
            case "sheet2":  
            	 with(sheetObj){
		         SetConfig( { SearchMode:2 } );
		
		         var info    = { Sort:1 };
		         var headers = {Text:"Empty headers"};
		         InitHeaders(headers, info);
		
		         var cols = [{Type:"Status",    Hidden:0, Width:40,   Align:"Center",    SaveName:"ibflag" }];
		          
		         InitColumns(cols);
		         SetWaitImageVisible(0);
           }
           break;
       }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
	        	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 				var sXml=sheetObj.GetSearchData("VOP_VSK_0513GS.do", sParam);
				if(sXml.length>0){ 
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				break;
			case IBSAVE:        //Save
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("VOP_VSK_0513GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
				break;
			case IBCLEAR:
				var statsCnt = sheetObj.RowCount("I") + sheetObj.RowCount("U") + sheetObj.RowCount("D");    						
				if(statsCnt > 0 ){
					if(ComShowCodeConfirm("VSK50012")){
						//formObj.loc_cd.value = "";
						comboObjects[0].RemoveAll();
				        initCombo(comboObjects[0], 1);
				        comboObjects[1].RemoveAll();
				        initCombo(comboObjects[1], 2);
						formObj.upd_dt.value="";
						formObj.upd_usr_id.value="";            		
						sheetObj.RemoveAll();
					}
				}else{
					//formObj.loc_cd.value = "";
					comboObjects[0].RemoveAll();
			        initCombo(comboObjects[0], 1);
			        comboObjects[1].RemoveAll();
			        initCombo(comboObjects[1], 2);
					formObj.upd_dt.value="";
					formObj.upd_usr_id.value="";            		
					sheetObj.RemoveAll();
				}
				break;
        }
    }
    function initControl() {
       	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
       	axon_event.addListenerFormat('keyup', 'obj_keyup', form);
       	axon_event.addListener('change', 'loc_cd_onchangeMax5', 'loc_cd', ''); //loc_cd change Event
       	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /** 
     * Handling key up event
     */ 
    function obj_keyup(){
    	var formObj=document.form;
     	obj=event.srcElement;
     	if(obj.dataformat == null) return;
     	window.defaultStatus=obj.dataformat;
     	switch(obj.dataformat) {
     	    case "engup":
     	        if(document.form.loc_cd.value.length == 5 ){    	        	
     	        	//Port Code validation check
    				formObj.f_cmd.value=SEARCH01;
     				var sXml=sheetObjects[1].GetSearchData("VOP_VSK_0513GS.do", FormQueryString(formObj));
    	    		var sLocCd=ComGetEtcData(sXml, "loc_cd");
    	    		if(sLocCd=="null" || sLocCd==null || sLocCd==""){
    	    			ComAlertFocus(formObj.loc_cd, ComGetMsg('VSK50015'));
    	    		}
     	        }
     	        break;
     	}
    } 
    /**
     * Checking Port Code length is 5
     */
	function loc_cd_onchangeMax5(){
		var formObj=document.form;
		if(formObj.loc_cd.value != ""){
			if(formObj.loc_cd.value.length < 5 ){
				ComShowCodeMessage("VSK50014");
				ComAlertFocus(formObj.loc_cd, "");
				return ;
			}
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (!isNumber(formObj.iPage)) {
                return false;
            }
        }
        return true;
    }
	// process after retrieve
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			var color1="#E5EAFF";
			var color2="#E6FEC5";
			SetColBackColor("Date",color1);
			SetColBackColor("FirstTime1",color2);
			SetColBackColor("FirstTime2",color2);
			SetColBackColor("SecondTime1",color2);
			SetColBackColor("SecondTime2",color2);
		}
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
         	     //if(obj.name=="agmt_iss_ofc_cd") ComKeyOnlyAlphabet('uppernum');
         	     ComKeyOnlyAlphabet('upper');
         	     break;
         	case "engdn":
         	     if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
         	     else ComKeyOnlyAlphabet('lower');
         	     break;
    	}
    } 
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		document.form.upd_dt.value=sheetObj.GetCellValue(NewRow, "sheet1_upd_dt");
		document.form.upd_usr_id.value=sheetObj.GetCellValue(NewRow, "sheet1_upd_usr_id");
	}
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			document.form.upd_dt.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_upd_dt");
			document.form.upd_usr_id.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sheet1_upd_usr_id");
		}
	}
    function tide_yr_OnChange(comObj,index,text)
    {
    	var formObj=document.form;
		formObj.upd_dt.value="";
		formObj.upd_usr_id.value="";            		
		sheetObjects[0].RemoveAll();
	}
    function tide_mon_OnChange(comObj,index,text)
    {
    	var formObj=document.form;
		formObj.upd_dt.value="";
		formObj.upd_usr_id.value="";            		
		sheetObjects[0].RemoveAll();
	}	
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
