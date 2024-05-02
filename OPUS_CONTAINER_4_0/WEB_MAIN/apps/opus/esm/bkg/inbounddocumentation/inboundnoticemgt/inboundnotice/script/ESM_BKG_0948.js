/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0948.js
*@FileTitle  : Hold Mail/Alert Set-Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // Common global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var isRetrieved=false;
    var sOldLocCd="";
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     */
    function processButtonClick() {
    	var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn2_Add":
                	doActionIBSheet(sheetObject1,formObject,IBINSERT);
                    break;
                case "btn2_Delete":
                	doActionIBSheet(sheetObject1,formObject,IBDELETE);
                    break;
                case "btn1_Retrieve":
                	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                    break;
                case "btn1_Save":
                	doActionIBSheet(sheetObject1,formObject,IBSAVE);
                    break;
            } // end switch
        } catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }
    /**
     * registering IBSheet Object as list<br>
     * adding process for list in case of needing batch processing with other items<br>
     * defining list on the top of source <br>
     * 
     * @param {IBSheet} sheet_obj, IBSheet control
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen. <br>
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }       
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)
//    	document.form.loc_cd.focus();
    }
    /**
     * HTML Tag Event
     */
    function initControl() {
    	var formObject=document.form;
    	//axon_event.addListenerFormat("keypress","obj_KeyPress", form);
    	axon_event.addListenerFormat("keypress","obj_ComKeyEnter", formObject);
    	axon_event.addListener("keydown","obj_keydown", "loc_cd");
//    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * Key Down Event
     */
    function obj_ComKeyEnter() {
        var formObject=document.form;
        
        var maxlength = formObject.loc_cd.getAttribute("maxlength");
        if ( formObject.loc_cd.value.length == 0 ) ComShowCodeMessage("BKG01101", "'"+formObject.loc_cd.getAttribute("caption")+"' ");
        else if ( formObject.loc_cd.value.length == maxlength ) doActionIBSheet(sheetObjects[0],formObject,IBSEARCH); 
    	
    }
    function obj_keydown() {
    	var sheetObject1=sheetObjects[0];
    	var formObject=document.form;
        var evt_code=(window.netscape) ? ev.which : event.keyCode;
    	switch(ComGetEvent("name")) {
	        case "loc_cd":
	        	if (evt_code == 13) {
	        		doActionIBSheet(sheetObject1, formObject, IBSEARCH);	        		
	        	}
	        	break;
   	    }
    }
    /**
     * setting sheet initial values and header<br>
     * adding case as numbers of counting sheets <br>
     * 
     * @param {ibsheet} sheetObj Mandatory, IBSheet Obj
     * @param {number}  sheetNo  Mandatory, IBSheet Obj Seq
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":
				with(sheetObj){
					var HeadTitle1="|Sel.|SEQ|Customs Location|Code|Mail/Alert|Enable Flag|Staff ID|E-mail";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix=sheetObj.id + "_";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk" },
					 {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hld_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_loc_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
					 {Type:"Combo",     Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_dspo_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ntc_mzd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ntc_enbl_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ntc_usr_id",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
					 {Type:"Text",      Hidden:0, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:40 } ];
					   
					InitColumns(cols);
					SetSheetHeight(490);
					SetEditable(1);
//					SetGetCountPosition()(0);
					SetColProperty(prefix+"ntc_mzd_cd", {ComboText:evtValue, ComboCode:evtCode} );
					SetColProperty(prefix+"ntc_enbl_flg", {ComboText:"No|Yes", ComboCode:"N|Y"} );
				}
                break;
        }
    }
    /**
     * handling process for Sheet <br>
     * 
     * @param {ibsheet} sheetObj Mandatory,IBSheet Obj
     * @param {object}  formObj  Mandatory,HTML Form Obj
     * @param {string}  sAction  Mandatory,Action name
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
    	sheetObj.SetWaitImageVisible(0);
    	var prefix=sheetObj.id + "_";
        switch(sAction) {
            // Customs code
            case IBSEARCH_ASYNC02:
            	formObj.f_cmd.value=SEARCH02;
            	var sXml=sheetObj.GetSearchData("ESM_BKG_0948GS.do", FormQueryString(formObj));
                var arrData=ComXml2ComboString(sXml, "val", "name");
                if (arrData != null && arrData.length == 2) {
				    arrData[1]="All|"+ arrData[1];
				    arrData[0]="*|"+ arrData[0];
    			    sheetObj.SetColProperty(prefix+"cstms_dspo_cd", {ComboText:arrData[1], ComboCode:arrData[0]} );
                }
                break;
            case IBSEARCH:      // Search
            	if(!validateForm(sheetObj,formObj,sAction)) return;
                // Location validation check
                ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH01;
            	var sXml=sheetObj.GetSearchData("ESM_BKG_0948GS.do", FormQueryString(formObj));
		        if (ComGetEtcData(sXml, "loc_validate") == "false") {
		        	ComShowCodeMessage("BKG00461");
		        	formObj.loc_cd.value="";
//		        	formObj.loc_cd.focus();
		        	ComOpenWait(false);		        	
		        	break;
		        } 		        
        		formObj.f_cmd.value=SEARCH; 
                // (PageUrl, [CondParam], [PageParam], [IsAppend], [AppendRow])
        		sheetObj.DoSearch("ESM_BKG_0948GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
                ComOpenWait(false);
                break;
            case IBINSERT:      // Insert
                if(!validateForm(sheetObj,formObj,sAction)) return;
            	var vRow=sheetObj.DataInsert(-1);
            	sheetObj.SetCellValue(vRow, prefix + "hld_seq","0",0);
            	sheetObj.SetCellValue(vRow, prefix + "cstms_loc_cd",formObj.loc_cd.value,0);
            	sheetObj.SetCellValue(vRow, prefix + "ntc_usr_id",formObj.user_id.value,0);
            	sheetObj.SetCellValue(vRow, prefix + "ntc_eml",formObj.user_eml.value,0);
            	break;
            case IBDELETE:
            	ComRowHideDelete(sheetObj, prefix + "del_chk");
            	break;
            case IBSAVE:        // Save
                if (!validateForm(sheetObj,formObj,sAction)) return;
                ComOpenWait(true);
        		formObj.f_cmd.value=MULTI;
        		sheetObj.DoSave("ESM_BKG_0948GS.do", FormQueryString(formObj), -1, false);
        		ComOpenWait(false);
                break;
        }
    }
    /**
     * handling process for input validation <br>
     * 
     * @param {ibsheet} sheetObj Mandatory,IBSheet obj
     * @param {object}  formObj  Mandatory,HTML Form obj
     * @param {string}  sAction  Mandatory,Action  
     * @return boolean Form obj validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var prefix=sheetObj.id + "_";
    	switch(sAction) {
    	    case IBSEARCH:
    	    	// Validation check
    	    	if (!ComChkValid(formObj)) return false;
            	if (ComIsModifiedSheets(sheetObj)) {
            		if (ComShowCodeConfirm("BKG00824")) {
            			doActionIBSheet(sheetObj,formObj,IBSAVE);
            			return false;
            		}
            	}
    	    	break;
    	    case IBINSERT:   // Insert
            	if (isRetrieved == false) {
            		ComShowCodeMessage("BKG00448"); 
            		return false;
            	}
            	if (isChangedSearchKeyword() == false) {
            		ComShowCodeMessage("BKG01072"); 
    	    	    resetSearchKeyword();
    	    	    return false;
            	}
            	break;
    	    case IBSAVE:    //Save
    	        var i=0, j=0;
    	        for (i=0; i<sheetObj.RowCount(); i++)
    	        {    	        	
    	        	if (sheetObj.GetRowStatus(i+1) == "D") continue; // Except Deletion
    	        	if (sheetObj.GetCellValue(i+1, prefix + "ntc_enbl_flg") == "Y")
    	        	{
    	        		for (j=i+1; j<sheetObj.RowCount(); j++)
    	        		{
    	        			if (sheetObj.GetRowStatus(j+1) == "D") continue; // Except Deletion
    	        			if (sheetObj.GetCellValue(j+1, prefix + "ntc_enbl_flg") == "Y")
    	        			{
    	        				if (sheetObj.GetCellValue(i+1, prefix + "cstms_dspo_cd") == "*") // ALL
    	        				{
    	        					if (sheetObj.GetCellValue(i+1, prefix + "ntc_mzd_cd") == "M") // ALL
    	        					{
    	        						if ( (sheetObj.GetCellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.GetCellValue(j+1, prefix + "cstms_loc_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "ntc_usr_id") == sheetObj.GetCellValue(j+1, prefix + "ntc_usr_id")) )
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					} else 
    	        					{
    	        						if ( (sheetObj.GetCellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.GetCellValue(j+1, prefix + "cstms_loc_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "ntc_mzd_cd") == sheetObj.GetCellValue(j+1, prefix + "ntc_mzd_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "ntc_usr_id") == sheetObj.GetCellValue(j+1, prefix + "ntc_usr_id")) )
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					}
    	        				} else {
    	        					if (sheetObj.GetCellValue(i+1, prefix + "ntc_mzd_cd") == "M") // ALL
    	        					{
    	        						if ( (sheetObj.GetCellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.GetCellValue(j+1, prefix + "cstms_loc_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "cstms_dspo_cd") == sheetObj.GetCellValue(j+1, prefix + "cstms_dspo_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "ntc_usr_id") == sheetObj.GetCellValue(j+1, prefix + "ntc_usr_id")) )
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					} else 
    	        					{
    	        						if ( (sheetObj.GetCellValue(i+1, prefix + "cstms_loc_cd") == sheetObj.GetCellValue(j+1, prefix + "cstms_loc_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "cstms_dspo_cd") == sheetObj.GetCellValue(j+1, prefix + "cstms_dspo_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "ntc_mzd_cd") == sheetObj.GetCellValue(j+1, prefix + "ntc_mzd_cd")) &&
    	        								(sheetObj.GetCellValue(i+1, prefix + "ntc_usr_id") == sheetObj.GetCellValue(j+1, prefix + "ntc_usr_id")) )
                	        			{
                	    		        	ComShowCodeMessage("BKG00488", j+1);
                	    		        	return false;
                	        			}
    	        					}
    	        				}
    	        			}
    	        		}
    	        	}
        	    	// E-mail Form check
    	        	if((sheetObj.GetRowStatus(i+1) != "R") && (sheetObj.GetRowStatus(i+1) != "D") &&
    	        			(sheetObj.GetCellValue(i+1, prefix + "ntc_enbl_flg") == "Y") &&
    	        			(sheetObj.GetCellValue(i+1, prefix + "ntc_mzd_cd") == "M" || sheetObj.GetCellValue(i+1, prefix + "ntc_mzd_cd") == "E"))
    		    	{
	        		if(ComIsEmailAddr(sheetObj.GetCellValue(i+1, prefix + "ntc_eml")) == false)
       		    		{
       		    			ComShowCodeMessage("BKG00366");
       		    			sheetObj.SelectCell(i+1, prefix + "ntc_eml");
       		    			return false;
       		    		}  
       		    	}    	        	
    	        }    	    
	    	    break;
    	}
        return true;
    }   
    /**
     * handling event after retrieving <br>
     * 
     * @param {ibsheet} sheetObj Mandatory,IBSheet obj
     * @param {string}  ErrMsg   
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	var formObject=document.form;
    	var prefix=sheetObj.id + "_";
    	// Save
    	sOldLocCd=formObject.loc_cd.value;
    	isRetrieved=true;
    }
    /**
     * Save Event <br>
     * 
     * @param {ibsheet} sheetObj Mandatory,IBSheet obj
     * @param {string}  ErrMsg  
     */
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
    	if (ErrMsg == "") {    	
    		ComBkgSaveCompleted();
    		doActionIBSheet(sheetObj,document.form,IBSEARCH);
    	}
    }
    /**
     * Checking whether Retrieve option changed<br>
     * 
     * @return boolean true: changed, false: Nothing changed
     */
    function isChangedSearchKeyword() {
    	var formObject=document.form;
    	if (sOldLocCd  != formObject.loc_cd.value) {
    		return false;
    	}
    	return true;
    }
    /**
     * Rollback the modified Data without saving
     */
    function resetSearchKeyword() {
    	var formObject=document.form;
    	formObject.loc_cd.value=sOldLocCd;
    }