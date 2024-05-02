/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0010.js
*@FileTitle : Cost Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_LEA_0010 : business script for ESD_LEA_0010 
     */
    function ESD_LEA_0010() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;    	
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
	var sheetObjects 	= new Array();
	var sheetCnt 		= 0;
	var comboObjects 	= new Array();
	var comboCnt 		= 0;

	/* IB MULTI COMBO (Main Cost Type Code) - the global variable for not to handling onChange Event in case of loading the page for the first time */ 
	var comboOnChangeEvtEnableFlag	= 'N';
	
    /* Event handler processing by button click event */
    document.onclick = processButtonClick;

    /* Event handler processing by button name */
    	function processButtonClick(){
    		 var sheetObject  = sheetObjects[0];
    		 var sheetObject1 = sheetObjects[1];
    		 var sheetObject2 = sheetObjects[2];

    		 var formObject = document.form;

    		try {
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

    				case "btn_retrieve":
    				 	sheetObject.RemoveAll();
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btng_downexcel":
    					
    					if (sheetObject.RowCount == 0){	//LEA90008 : No data found
    						ComShowMessage(ComGetMsg("LEA90008"));
    						return;
    					}
    					
    					//lea_form2sheet(formObject, sheetObject2);
    					//sheetObject2.Down2Excel(-1	, false	,	false,	true,	"",	"",	false,	false, "",	true);
    					//sheetObject .Down2Excel(-1	, true	,	false,	true,	"",	"",	false,	false, "",	true);
    					//doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
            	    	sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
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
    	 * Registering IBSheet Object as list
    	 * Adding process for list in case of needing batch processing with other items
    	 * Defining list on the top of source
    	 */
    	function setSheetObject(sheet_obj){
    		sheetObjects[sheetCnt++] = sheet_obj;
    	}

     	/**
         * Registering IBCombo Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source 
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }    	
    	
    	/**
    	 * initializing sheet
    	 * implementing onLoad event handler in body tag
    	 * adding first-served functions after loading screen.
    	 */
        
    	function loadPage(frmMnCostTypeCode, frmSubCostTypeCode) {

    		for(i=0;i<sheetObjects.length;i++){

    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		//Initializing IBMultiCombo
    		initCombo_mn_cost_tp_cd		();
    		initCombo_sub_cost_tp_cd	();
    		initCombo_frm_accl_type_cd	();
    		
    		comboOnChangeEvtEnableFlag	= 'Y';
    		
//    		doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
//    		lea_initCombo(sheetObjects[1],document.form);
    		
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    	}
    	
        /**
         * Registering IBCombo Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
        }

        /**
         * Initializing IB MULTI COMBO
         */
        function initCombo_mn_cost_tp_cd(){
        	
    		var formObj = document.form;

    		formObj.f_cmd.value 	= SEARCH20	;		//Retrieving IB MULTI COMBO.MAIN COST TYPE CODE
    		formObj.cost_kind.value	= "COST_KIND_MAIN"; 
   		
			//var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
			
			var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
			
    		var comboList 	= new Array();
    		comboList		= LeaXml2ComboString(sXml, "code", "name");
    		
    		//Setting IB MULTI COMBO Property
    		formObj.mn_cost_tp_cd.SetTitle("Main Cost Type");
    		formObj.mn_cost_tp_cd.SetColAlign("left");
    		formObj.mn_cost_tp_cd.SetColWidth("120");
    		
    		if(comboList != null){
    			for(var i = 0; i < comboList.length;i++){ 
    				var code = comboList[i].substring(0, comboList[i].indexOf('|') );
    				formObj.mn_cost_tp_cd.InsertItem(i, comboList[i] , code);
    				formObj.mn_cost_tp_cd.Code = code;
    			}
    			formObj.mn_cost_tp_cd.InsertItem(0, "All" , "All");
    			formObj.mn_cost_tp_cd.Code2 = "All";
    		}        	
        }
        
        /**
         * Initializing IB MULTI COMBO
         */        
        function initCombo_sub_cost_tp_cd(){
        	
    		var formObj = document.form;

    		formObj.f_cmd.value 	= SEARCH20	;	//Retrieving IB MULTI COMBO.SUB COST TYPE CODE 
    		formObj.cost_kind.value	= "COST_KIND_SUB"; 
   		
			//var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
			
			var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
			
    		var comboList 	= new Array();
    		comboList		= LeaXml2ComboString(sXml, "code", "name");
    		
    		//Setting IB MULTI COMBO Property
    		formObj.sub_cost_tp_cd.SetTitle("Sub Cost Type | Sub Cost Type Name");
    		formObj.sub_cost_tp_cd.SetColAlign("left|left");
    		formObj.sub_cost_tp_cd.SetColWidth("125|300");
    		formObj.sub_cost_tp_cd.DropHeight = 400;
    		
    		if(comboList != null){
    			for(var i = 0; i < comboList.length;i++){ 
    				var code = comboList[i].substring(0, comboList[i].indexOf('|') );
    				formObj.sub_cost_tp_cd.InsertItem(i, comboList[i] , code);
    				formObj.sub_cost_tp_cd.Code = code;
    			}
    			formObj.sub_cost_tp_cd.InsertItem(0, "All" , "All");
    			formObj.sub_cost_tp_cd.Code2 = "All";
    		}        	
        }        
        
        /**
         * Initializing IB MULTI COMBO 
         */
        function initCombo_frm_accl_type_cd(){
        	
    		var formObj = document.form;

    		//Setting IB MULTI COMBO Property
    		formObj.frm_accl_type_cd.SetTitle("Accrual Type");
    		formObj.frm_accl_type_cd.SetColAlign("left");
    		formObj.frm_accl_type_cd.SetColWidth("120");
    		
   			formObj.frm_accl_type_cd.InsertItem(0, "All"		, "All"		);
   			formObj.frm_accl_type_cd.InsertItem(1, "Auto" 		, "Auto"	);
   			formObj.frm_accl_type_cd.InsertItem(2, "Manual" 	, "Manual"	);
   			formObj.frm_accl_type_cd.InsertItem(3, "Transfer" 	, "Transfer");
   			formObj.frm_accl_type_cd.Code2 = "All";
        }
        
        
        
        /**
         * Handling IB MULTI COMBO onChange Event
         */  
        function mn_cost_tp_cd_OnChange(comboObj, Index_Code, Text){  	

        	//The purpose that handles blocking in case of Loading IB COMBO,initializing, and occurring onChange Event and working onChange event after loading the page only.
        	if(comboOnChangeEvtEnableFlag != 'Y')	return;
        	
    		var formObj = document.form;
    		formObj.sub_cost_tp_cd.removeAll();
    	
    		formObj.f_cmd.value 			= SEARCH20	;	//Retrieving IB MULTI COMBO
    		formObj.cost_kind.value			= "COST_KIND_SUB"; 
    		formObj.sel_mn_cost_tp_cd.value = Index_Code;
    		
        	if(Index_Code == 'All')		formObj.sel_mn_cost_tp_cd.value = '';
   		
        	sheetObjects[0].WaitImageVisible = false;
			//var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
			
			var sXml = sheetObjects[0].GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
			
			
			sheetObjects[0].WaitImageVisible = true;
    		var comboList 	= new Array();
    		comboList		= LeaXml2ComboString(sXml, "code", "name");
    	
    		if(comboList != null){
    			for(var i = 0; i < comboList.length;i++){ 
    				var code = comboList[i].substring(0, comboList[i].indexOf('|') );
    				formObj.sub_cost_tp_cd.InsertItem(i, comboList[i] , code);
    				formObj.sub_cost_tp_cd.Code = code;
    			}
    			formObj.sub_cost_tp_cd.InsertItem(0, "All" , "All");
    			formObj.sub_cost_tp_cd.Code2 = "All";
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
    					// Setting height
    					style.height = 400;
    					//Setting width
    					SheetWidth = mainTable.clientWidth;

    					//Setting the Host information[Required][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//Kind of merge [Optional, Default msNone]
    					MergeSheet = msHeaderOnly;

    				   //Edit kind [Optional, Default false]
    					Editable = true;

    					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 2, 1, 9, 100);

    					//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(14, 1 , 0, true);

    					// Setting function handling header
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "Cost\nType Ⅰ|Cost Type Ⅱ|Cost Type Ⅱ|Cost Code|Cost Code|Account Code|Account Code|Account Code|Account Code|Accrual|Accrual|Accrual|Source|Source";
    					var HeadTitle1 = "Cost\nType Ⅰ|Code|Name|Code|Name|Code|Name|Rep.\nCode|Other Lines||Type|Case|Est.|Actual";

    					//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, true);

    					//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData  ,       60,    daCenter,   true ,    "mn_cost_tp_cd"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "sub_cost_tp_cd"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,      200,    daCenter,   false,    "sub_cost_tp_nm"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       60,    daCenter,   false,    "lgs_cost_cd"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,      170,    daCenter,   false,    "lgs_cost_full_nm"	,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "acct_cd"					,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,      200,    daCenter,   false,    "acct_cd_nm"				,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "rep_acct_cd"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       80,    daCenter,   false,    "otr_crr_acct_cd"	,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtHidden,       60,    daCenter,   true ,    "accl_auto_cd"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       60,    daCenter,   true ,    "accl_auto_nm"			,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "accl_lgc_tp_cd"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "estm_cost_flg"		,     false,          "",       dfNone,          0,     false,       false);
    					InitDataProperty(0, cnt++ , dtData  ,       50,    daCenter,   false,    "cost_src_sys_cd"	,     false,          "",       dfNone,          0,     false,       false);

    					RangeBackColor(1,1, 1,13) = RgbColor(222, 251, 248);   // ENIS
    					HeadRowHeight = 21 ;
    					HeadRowHeight = 20 ;

    				}
    				break;
    			case 2:      //sheet1 init
    				with (sheetObj) {
    					// Setting height
    					style.height = 280;
    					//Setting width
    					SheetWidth = mainTable.clientWidth;

    					//Setting the Host information[Required][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//Kind of merge [Optional, Default msNone]
    					MergeSheet = msHeaderOnly;

    				   //Edit kind [Optional, Default false]
    					Editable = true;

    					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 9, 100);

    					//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(1, 0 , 0, true);

    					// Setting function handling header
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "";
    					
    					//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true,    "",     false,          "",       dfNone,          0,     true,       true);


    				}
    				break;
    			case 3:      //sheet1 init
    				with (sheetObj) {
    					// Setting height
    					style.height = 280;
    					//Setting width
    					SheetWidth = mainTable.clientWidth;

    					//Setting the Host information[Required][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//Kind of merge [Optional, Default msNone]
    					MergeSheet = msHeaderOnly;

    				   //Edit kind [Optional, Default false]
    					Editable = true;

    					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 1, 1, 9, 100);

    					//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(5, 3 , 0, true);

    					// Setting function handling header
    					InitHeadMode(true, true, false, true, false,false) ;

    					var HeadTitle = "Cost Code|Account Code|Cost Type I|Cost Type Ⅱ|Accrual Type";

    					//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, true);

    					//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "lgs_cost_cd"			,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "acct_cd"					,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,   true ,    "mn_cost_tp_cd"		,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "sub_cost_tp_cd"		,     false,          "",       dfNone,          0,     true,       true);
    					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,   false,    "accl_auto_cd"		,     false,          "",       dfNone,          0,     true,       true);

    					RangeBackColor(1,1, 1,13) = RgbColor(222, 251, 248);   // ENIS
    					HeadRowHeight = 21 ;
    					HeadRowHeight = 20 ;

    				}
    				break;
    		}
    	}

      // Handling the process about the sheet
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		   case IBSEARCH:      //Retrieving
    			  	formObj.f_cmd.value = SEARCH;
    			  	//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
    			  	
    			  	var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
    			  	
    			  	
    			    //showErrMessage(searchXml);
    			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml, false);
                break;

    		   case IBDOWNEXCEL:        //Excel down
    			 // sheetObj.Down2Excel(-1, false, false, true);
    			   sheetObj.Down2Excel(-1,false,false,true,"","",false,false, "",true);

    		  break;

    		}
    	}


      // Handling the process about the sheet
    	function doActionIBSheet2(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBSEARCH_ASYNC01:      //Retrieving
    				formObj.f_cmd.value = SEARCH01;
    				//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
    				
    				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
    				
    				
    			    //showErrMessage(searchXml);
    			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);			    
    			    break;
    			case IBSEARCH_ASYNC02:      //Retrieving
    			  	formObj.f_cmd.value = SEARCH02;
    				//var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", FormQueryString(formObj));
    				
    				var searchXml = sheetObj.GetSearchXml("ESD_LEA_0010GS.do", leaFormQueryString(formObj));
    				
    				
    			    //showErrMessage(searchXml);
    			    if(searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
    			    break;
    		}
    	}


       /**
    	 * Handling the process for the input validation
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
//                if (!isNumber(iPage)) {
    //
//                    return false;
//                }
    		}

    		return true;
    	}

    	/**
    	 * Calling this function when occurring on mouse move in sheet.
    	 *
    	 */
    	function sheet1_OnMouseMove(sheetObj,buttonValue, shiftValue, x_pos, y_pos)
    	{ 
          sText = sheetObj.CellText(sheetObj.MouseRow,sheetObj.MouseCol);
         
          //Setting the mouse cursor.
          if (sheetObj.MouseCol == 2 || sheetObj.MouseCol == 4 || sheetObj.MouseCol == 6){
               //Making the ballon help.
          		sheetObj.ToolTipText(sheetObj.MouseRow,sheetObj.MouseCol)  = sText;
          }

      }	
        
       /**
         * Handling the retrieving process when pressed Enter key Event
         */
    		function lea_enterRetrieve(){
    			var sheetObject = sheetObjects[0];
    			var formObject = document.form;
     			sheetObject.RemoveAll();
     			doActionIBSheet(sheetObject,formObject,IBSEARCH);
    		}
     		
       /**
         * Copying the form data to sheet one
         */
    		function lea_form2sheet(formObj, sheetObj){
    			sheetObj.RemoveAll();
    			var Row = sheetObj.DataInsert(-1);
    			sheetObj.CellValue(Row , "mn_cost_tp_cd"	) = formObj.mn_cost_tp_cd.Text		;
    			sheetObj.CellValue(Row , "sub_cost_tp_cd"	) = formObj.sub_cost_tp_cd.Text		;
    			sheetObj.CellValue(Row , "lgs_cost_cd"		) = formObj.frm_cost_cd.value		;
    			sheetObj.CellValue(Row , "acct_cd"			) = formObj.frm_acct_cd.value		;
    			sheetObj.CellValue(Row , "accl_auto_cd"	  	) = formObj.frm_accl_type_cd.Text	;
    		}

        		

