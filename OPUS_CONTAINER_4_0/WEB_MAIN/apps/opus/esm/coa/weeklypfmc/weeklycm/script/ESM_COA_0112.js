/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0112.js
*@FileTitle : VVD Status
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================
* History
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------Code for JSDoc creation below ------------------*/
   /**
     * @fileoverview 
     */

    /**
     * @extends 
     * @class ESM_COA_0112 : ESM_COA_0112 Business script for the UI
     */
    function ESM_COA_0112() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.setSheetObject 		= setSheetObject;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setRetrieveAction 		= setRetrieveAction;
    }
    
 // Grobla Variable


    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    	/* Event handler processing by button name */
    	function processButtonClick(){
    		/***** Specify additional sheet variable in case of using more than two sheet per tab *****/
    		var sheetObject = sheetObjects[0];
    	
    	var formObject = document.form;
    		
    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			if(ComGetBtnDisable(srcName)) return false;
    		
    			switch(srcName) {
    				case "btn_Retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				
    				case "btn_Save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;

    				case "btn_monthvvdif":
    					doActionIBSheet(sheetObject,formObject,COMMAND01);
    					break;
    					
    				case "btn_Close":
    					window.close();
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
* initializing sheet
* implementing onLoad event handler in body tag
* adding first-served functions after loading screen.
    	 */
    	function loadPage() {
    	
    		for(i=0;i<sheetObjects.length;i++){
    		
    			//Sheet configuration setting function(start)
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//Sheet configuration setting function(end)
    			ComEndConfigSheet(sheetObjects[i]);
    			
    	    }
    	}
    	
    	/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
    	 */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
    		
    		switch(sheetNo) {
    			case 1:      //sheet1 init
    				with (sheetObj) {
    				
    					SheetWidth = mainTable.clientWidth;				    //Setting width
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); 	 //setting Host information[mandatory][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly; 	 	 	 	 	        //Merge kind [optional, Default msNone]
    					Editable = true; 	 	 	 	 	 			    //Edit kind [optional, Default false]
    					InitRowInfo( 1, 1, 9, 100); 	 	 	 	 	 	//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100] 
    					InitColumnInfo(15, 0, 0, true); 	 	 	 	 	 	//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false] 
    					InitHeadMode(true, true, false, true, false,false);	// setting function handling header  ;
    					var HeadTitle = "|RSLT_CD|STATUS|Year/Month|Week|AR CNFM.|DELT.|VVD|TRADE|REV. LANE|IOC|PORT|||";
    					InitHeadRow(0, HeadTitle, true); 	 	 	 	 	//Header Title Information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					
            			//Row data attribute	    [ROW, COL  , DATATYPE  , WIDTH, DATAALIGN, COLMERGE, SAVENAME               , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
            			InitDataProperty(0  , cnt++, dtStatus  ,    30, daCenter , false   , "ibflag"               , false   , ""        ,	dfNone   ,	0         , false     ,	false );								        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    90, daCenter , false   , "rslt_cd"              , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    90, daCenter , false   , "rslt"                 , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    70, daCenter , false   , "cost_yrmon"           , false   , ""        ,	dfNone   ,	0         , true     );        			
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "cost_wk"              , false   , ""        ,	dfNone   ,	0         , false    );        			        			
            			InitDataProperty(0  , cnt++, dtData    ,    60, daCenter , false   , "mon_tgt_flg"          , false   , ""        ,	dfNone   ,	0         , false    );        			
            			InitDataProperty(0  , cnt++, dtData    ,    40, daCenter , false   , "delt_flg"             , false   , ""        ,	dfNone   ,	0         , false    );        			        			
            			InitDataProperty(0  , cnt++, dtData    ,    90, daCenter , false   , "vvd"                  , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "trd_cd"               , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    90, daCenter , false   , "rlane_cd"             , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "ioc_cd"               , false   , ""        ,	dfNone   ,	0         , false    );
            			InitDataProperty(0  , cnt++, dtData    ,    50, daCenter , false   , "lst_lodg_port_cd"     , false   , ""        ,	dfNone   ,	0         , false    );        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    40, daCenter , false   , "vsl_cd"               , false   , ""        ,	dfNone   ,	0         , false    );        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    40, daCenter , false   , "skd_voy_no"           , false   , ""        ,	dfNone   ,	0         , false    );        			        			
            			InitDataProperty(0  , cnt++, dtHidden  ,    40, daCenter , false   , "dir_cd"               , false   , ""        ,	dfNone   ,	0         , false    );        			        			
    					
    					CountPosition  = 2 ;
    					style.height = GetSheetHeight(15) ;	
    					WaitImageVisible = false;
    				}
    				break;
    		}
    	}
    	
    	/**
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items 
* defining list on the top of source
    	 */
    	function setSheetObject(sheet_obj){
    	
    		sheetObjects[sheetCnt++] = sheet_obj;
    	
    	}

    	/**
    	* Open the popup in case of double clickng on sheet
    	*/
        function sheet1_OnDblClick(sheetObj , row, col){
            var vvd  = "";
            var classId = "COM_ENS_0B1";
            var param = "";
            if(sheetObj.ColSaveName(col) == "vvd"){ // In case of VVD
              vvd = sheetObj.CellValue(row, "vvd");
              param = '?vvd_cd='+vvd+'&classId='+classId;
              ComOpenPopup("/opuscntr/COM_ENS_0B1.do"+param, 630, 430, "", "0,0,1,1,1,1,1,1,1,1", true);
            }
        }
        
        /**
    	* Handling process about the sheet object
    	*/
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBSEARCH:      //Inquiry
    				// Prohibit button click when a business transaction is processing 
					ComOpenWait(true);
    				formObj.f_cmd.value = SEARCH;
    				sheetObj.DoSearch4Post("ESM_COA_0112GS.do", coaFormQueryString(formObj));
    				ComOpenWait(false);
    				break;
    			case IBSAVE:        //Save
    				// Prohibit button click when a business transaction is processing 
					ComOpenWait(true);
    				formObj.f_cmd.value = MULTI;
    				sheetObj.DoAllSave("ESM_COA_0112GS.do", coaFormQueryString(formObj));
    				ComOpenWait(false);
    				// Retrieve result
    				setRetrieveAction();
    				break;	
    			case COMMAND01:		//Month VVD I/F
    				
    				if (!ComShowConfirm(ComGetMsg("COA10062"))) {
    					return false;
    				}
    				// Prohibit button click when a business transaction is processing 
					ComOpenWait(true);
    				formObj.f_cmd.value = COMMAND01;
    				//sheetObj.DoSearch4Post("ESM_COA_0112GS.do", coaFormQueryString(formObj));
	  				var sXml = sheetObj.GetSearchXml("ESM_COA_0112GS.do", coaFormQueryString(formObj));

	  				if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S" ){
    					ComShowCodeMessage("COA10018","Month VVD I/F");
				    }
	  				
    				ComOpenWait(false);
    				// Retrieve result
    				setRetrieveAction();	
    				break;				
    		}
    	}
    	
    	/**
				* Retrieve in case of loading window
    	*/
        function setRetrieveAction(){       
        	sheetObject = sheetObjects[0];
        	formObject = document.form;    	
        	doActionIBSheet(sheetObject,formObject,IBSEARCH);
        }	
        