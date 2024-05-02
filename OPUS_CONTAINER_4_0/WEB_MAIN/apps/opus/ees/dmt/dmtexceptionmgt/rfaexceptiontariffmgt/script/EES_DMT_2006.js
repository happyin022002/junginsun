/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2006.js
*@FileTitle  : DEM/DET Adjustment Request & Approval Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class business script for searching DEM/DET Adjustment Request & Approval Status
     */
	// Common Global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;	
	//Defining Action
	var IBSEARCH_TARIFF=100;
	var IBSEARCH_CUST_NM=105;	
	//Business Global Variables
	var ROWMARK="|";
	var FIELDMARK="=";
	//S/C Exception Tariff 
	var TO_CC="to_cc";
	var SC_NO="sc_no";
	var DAR_NO="dar_no";
	var VER="ver_no";
	var APVL_NO="apvl_no";
	var RFA_NO="rfa_no";
	var PROP_NO="prop_no";
	var STATUS="status";
	var TARIFF="dmdt_trf_cd";
	var CVRG="coverage";
	var REQ_OFC="req_ofc_cd";
	var APRO_OFC="apro_ofc_cd";
	var DATE="upd_dt";
	var CUST_CD="cust_cd";
	var CUST_NM="cust_nm";	
	var BKG_NO="bkg_no";
	var BL_NO="bl_no";
	var CVRG_CNT="cnt_cd";
	var CVRG_RGN="rgn_cd";
	var CVRG_LOC="loc_cd";
	//Date for getting information first (old) and last (current) date to the variable representing the interval
	var PERIOD_GAP=7;	
	
	var DEF_SHEET_HEIGHT = 114;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick() {
		/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2]; 
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4];
		var sheetObject6=sheetObjects[5]; 
		/*******************************************************/
		var formObj=document.form;
    	try {
    		var srcName =ComGetEvent("name");
    		
    		switch(srcName) {
	         	case "btns_calendar": //Calendar button
					var cal=new ComCalendarFromTo();
					cal.select(formObj.updDtFm, formObj.updDtTo, 'yyyy-MM-dd');
					break;            
				
	         	case "btn_retrieve":
					if (ComIsBtnEnable("btn_retrieve")) 
						doActionRetrieve();					
					break;
				
				case "btn_new":
					if (ComIsBtnEnable("btn_new")) 
						doActionNew();						
					break;
				
				case "btn_minimize":
					// [26/5/2014] @Dung.Nguyen:
					// Content: Change "btn_mnimize" to "btn_minimize"
					if (ComIsBtnEnable("btn_minimize"))
						doActionMinimize();
					break;
				
				case "btn_detail":
					if (ComIsBtnEnable("btn_detail")) 
						doActionDetail();
					break;
				
				case "t1btn_SCdownexcel":
					doActionDownExcel(sheetObject1);
					break;
				
				case "t1btn_Beforedownexcel":
					doActionDownExcel(sheetObject2);
					break;
				
				case "t1btn_Afterdownexcel":
					doActionDownExcel(sheetObject3);
					break;
				
				case "t2btn_SCdownexcel":
					doActionDownExcel(sheetObject4);
					break;
				
				case "t2btn_Beforedownexcel":
					doActionDownExcel(sheetObject5);
					break;
				
				case "t2btn_Afterdownexcel":
					doActionDownExcel(sheetObject6);
					break;																					
            } // end switch
    	}catch(e) {
    		if( e.message == "[object Error]") {
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	var formObj=document.form;
    	for (i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
		}
        for (var k=0 ; k < tabObjects.length ; k++) {
            initTab(tabObjects[k],k+1);
        }

        //IBMultiCombo initializing 
	    for (var k=0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }

		//initializing html control event
		initControl();
		initViewControls();
		
		t1sheet1_OnLoadFinish();
    }
    
	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
	function t1sheet1_OnLoadFinish() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		//Tariff Inquiry by Tariff Type information to combo configuration.
   		doActionIBCommon(sheetObj, formObj, IBSEARCH_TARIFF, SEARCH09);
	}
	
   	function initControl() {
		axon_event.addListenerForm('blur',				'obj_deactivate',  	document.form, 'cond_type'); //- out of focus
//		axon_event.addListenerFormat('focus',			'obj_focus',		document.form); // Get focus
		axon_event.addListenerFormat('keypress',		'obj_keypress', 	document.form); //- on press keyboard
		axon_event.addListener('click', 				'condType_click', 	'cond_type');
		axon_event.addListener('keydown', 				'ComKeyEnter', 		'form');
		axon_event.addListener('blur', 					'obj_blur', 		'custCd');
  	}
   /**
    * in Screen Load , Controls  initializing
    */     
    function initViewControls() {
    	var formObj=document.form;
    	var cboTariff=comboObjects[0];
	 	//Type initializing
	 	initType();
	 	//Group by( S/C & DAR)
	 	ComSetObjValue(formObj.groupBy, "DAR");
	 	//Date Field setting
	 	initDateControls();
	 	//That should show the screen when loading hides certain fields (all Sent tab, TO / CC fields)
	 	initColumn();
	 	//When the screen loads, according to the default display fields appear.
	 	showColumn();
    	// Clear all search results if you allow.
    	for (var sheetNo=0 ; sheetNo < sheetObjects.length ; sheetNo++) {
    		sheetObjects[sheetNo].RemoveAll();
    	}	 	
    }
    
    function initType() {
    	 var formObj=document.form;
    	 switch (ComTrim(ComGetObjValue(formObj.login_rhqofc_cd))) {
	    	 case "NYCNA" : 
	    		 	formObj.searchType[0].checked=true;	//SC
	    		 	formObj.searchType[1].checked=false;	//Before
	    		 	formObj.searchType[2].checked=true;	//After
	    		 break;
	    	 case "HAMUR" :
	    		 	formObj.searchType[0].checked=false;	//SC
	    		 	formObj.searchType[1].checked=true;	//Before
	    		 	formObj.searchType[2].checked=true;	//After
	    		 break;
	    	 default :
	    		 	formObj.searchType[0].checked=true;	//SC
 		 			formObj.searchType[1].checked=true;	//Before
 		 			formObj.searchType[2].checked=true;	//After	 
    	 }
    	 displayGridByType();
     }
   	function initDateControls() {
   		var formObj=document.form;
   		//Searching conditions Partly to enable / disable processing
   		formObj.cond_type[0].checked=true;
   		doEnableCondObj("date");		
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
            case "t1sheet1":
            case "t2sheet1":
            	with(sheetObj){
	            	var HeadTitle1="Seq.|To/CC|S/C No.|Ver.|Status|Tariff|Country|Region|Location|Request|APVL|Date|Proposal No.|Customer|Customer";
	
	            	SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TO_CC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:SC_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:VER,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:STATUS,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:CVRG_RGN,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:CVRG_LOC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:REQ_OFC,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:APRO_OFC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:DATE,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:PROP_NO,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
	            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:CUST_NM,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }
	            	 ];
	            	 
	            	InitColumns(cols);
	
	            	SetCountPosition(0);
	            	//SetSheetWidth(mainTable.clientWidth);
	            	SetSheetHeight(DEF_SHEET_HEIGHT);
	            	SetEditable(1);
            	}
				break;
            case "t1sheet2":
            case "t2sheet2":
                with(sheetObj){
					var HeadTitle1="Seq.|To/CC|DAR No.|Ver.|APVL No.|Status|Tariff|Country|Region|Location|Request|APVL|Date|RFA No.|Proposal No.|Customer|Customer";
					
					SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TO_CC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:115,  Align:"Center",  ColMerge:1,   SaveName:DAR_NO,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:VER,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:APVL_NO,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:STATUS,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:CVRG_RGN,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:CVRG_LOC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:REQ_OFC,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:APRO_OFC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:DATE,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:RFA_NO,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:PROP_NO,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }
					];
					
					InitColumns(cols);
					
					SetCountPosition(0);
					//SetSheetWidth(mainTable.clientWidth);
	            	SetSheetHeight(DEF_SHEET_HEIGHT);
					SetEditable(1);
            	}

				break;
            case "t1sheet3":
            case "t2sheet3":
                with(sheetObj){
					var HeadTitle1="Seq.|To/CC|DAR No.|APVL No.|Status|Tariff|Coverage|BKG No.|B/L No.|Request|APVL|Date|S/C No.|RFA No.|Customer|Customer";
					
					SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:TO_CC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:DAR_NO,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:APVL_NO,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:STATUS,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:TARIFF,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:CVRG,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:BKG_NO,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:BL_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:REQ_OFC,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:APRO_OFC,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:DATE,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:SC_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:RFA_NO,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
					{Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }
					];
					
					InitColumns(cols);
					
					SetCountPosition(0);
					//SetSheetWidth(mainTable.clientWidth);
	            	SetSheetHeight(DEF_SHEET_HEIGHT);
					SetEditable(1);
            	}
				break;
        }
    }
   // out of focus
 	function obj_deactivate(){
 		//check inputing Validation + Inserting separator 
 		var obj=ComGetEvent();
 		if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
 		} else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
 			if(obj.value.length > 0 && obj.value.length < 5) {
 	 			ComShowCodeMessage('DMT00110', 'Location');
 	 			ComClearObject(obj);
		 	}
 		} else {
 			ComChkObjValid(obj);
 		}
	}
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
   	 var obj=ComGetEvent();
        ComClearSeparator(obj);
        //If you have a block of text so as to choose.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }    
	//business javascript OnKeyPress event handling
	function obj_keypress() {
		var formObj=document.form;
		switch(ComGetEvent().dataformat){
			case "engup":
				// upper case + numbers 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
      		case "engup2":
		    	//  upper case + numbers + exceptional letters
		    	DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
      		case "int":
	 	        //only numbers
	 	        ComKeyOnlyNumber(ComGetEvent());
	 	        break;
      		default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(ComGetEvent());
		}		
		// search option, DAR item, then enter data in a particular field, the entered value of other fields makes Clear.
		clearNoSelectDARFields();
	} 

	function obj_blur() {
		switch(ComGetEvent("name")){
			case "custCd":
				searchCustomerName();
				break;
		}
	}
 	/**
	 * Enter the Customer ID then, when focus out, Customer Name is looking up.
	 */
	function searchCustomerName() {
		var formObj=document.form;
		var custCd=ComTrim(ComGetObjValue(formObj.custCd));
		if (custCd.length > 2) {
			ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
			ComSetObjValue(formObj.cust_seq, custCd.substring(2));		 
			doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_CUST_NM, SEARCH19);
		} else {
			ComClearObject(formObj.custNm);
		}
	}
    function condType_click() {
    	doEnableCondObj(ComGetEvent("value"));
    }
	function doEnableCondObj(condType) {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		with (formObj) {
			switch(condType){
				case "date":
					//Date Searching conditions of the fields activating 
					ComEnableManyObjects(true, updDtFm, updDtTo, toCc, userOfficeOnly, userOnly);
					updDtFm.className="input1";
					updDtTo.className="input1";
					toCc.className="input";
					userOfficeOnly.className="trans";
					userOnly.className="trans";
					var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
					ComSetObjValue(updDtFm, ComGetDateAdd(ofcCurrDate, "D", -7));
					ComSetObjValue(updDtTo, ofcCurrDate);
					//Setting Office in default value
					setDefaultOffice();
					office.className="input2";
					//Dar Searching conditions of the fields deactivating 
					ComEnableManyObjects(false, sCNo, rFANo, proposalNo, darNo, approvalNo, bkgNo, blNo);
					ComClearManyObjects(sCNo, rFANo, proposalNo, darNo, approvalNo, bkgNo, blNo);
					break;
				case "dar":
					//Dar Searching conditions of the fields activating 
					ComEnableManyObjects(true, sCNo, rFANo, proposalNo, darNo, approvalNo, bkgNo, blNo);
					sCNo.className="input";
					rFANo.className="input";
					proposalNo.className="input";
					darNo.className="input";
					approvalNo.className="input";
					bkgNo.className="input";
					blNo.className="input";
					//Date Searching conditions of the fields deactivating 
					ComEnableManyObjects(false, updDtFm, updDtTo, toCc, userOfficeOnly, userOnly);
					ComClearManyObjects(updDtFm, updDtTo, office);
				    office.className="input2";
					ComSetObjValue(toCc, "");
					userOfficeOnly.checked=false;
					userOnly.checked=false;
					ComSetFocus(sCNo);
					break;
			}
		}
	}
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var cboTariff=comboObjects[0];
        switch(sAction) {
        	case IBSEARCH:     // Search
              	if(!validateForm(sheetObj,formObj,sAction)) return;
				//1.Searching conditions 
				ComSetObjValue(formObj.f_cmd, 		SEARCH);
				ComSetObjValue(formObj.group_by, 	ComGetObjValue(formObj.groupBy));
				ComSetObjValue(formObj.dmdt_trf_cd, cboTariff.GetSelectText());
				ComSetObjValue(formObj.fm_dt, 		ComGetObjValue(formObj.updDtFm));
				ComSetObjValue(formObj.to_dt, 		ComGetObjValue(formObj.updDtTo));
				if (formObj.userOnly.checked) {
					ComSetObjValue(formObj.usr_id, ComGetObjValue(formObj.login_usr_id));
					ComSetObjValue(formObj.usr_ofc_cd, "");
					ComSetObjValue(formObj.usr_ofc_only, "N");
				} else if (formObj.userOfficeOnly.checked) {
					ComSetObjValue(formObj.usr_id, "");						
					ComSetObjValue(formObj.usr_ofc_cd, ComGetObjValue(formObj.login_ofc_cd));
					ComSetObjValue(formObj.usr_ofc_only, "Y");
				} else {
					ComSetObjValue(formObj.usr_id, "");
					ComSetObjValue(formObj.usr_ofc_cd, ComGetObjValue(formObj.ofc_cd));
					ComSetObjValue(formObj.usr_ofc_only, "N");
				}
				ComSetObjValue(formObj.to_cc, 		ComGetObjValue(formObj.toCc));
				ComSetObjValue(formObj.sc_no, 		ComGetObjValue(formObj.sCNo));
				ComSetObjValue(formObj.rfa_no, 		ComGetObjValue(formObj.rFANo));
				ComSetObjValue(formObj.prop_no, 	ComGetObjValue(formObj.proposalNo));
				ComSetObjValue(formObj.dar_no, 		ComGetObjValue(formObj.darNo));
				ComSetObjValue(formObj.apvl_no, 	ComGetObjValue(formObj.approvalNo));
				ComSetObjValue(formObj.bkg_no, 		ComGetObjValue(formObj.bkgNo));
				ComSetObjValue(formObj.bl_no, 		ComGetObjValue(formObj.blNo));
				ComSetObjValue(formObj.cust_cd, 	ComTrim(ComGetObjValue(formObj.custCd)));
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				//sheetObj.DoSearch("EES_DMT_2006GS.do", FormQueryString(formObj));
		        var sXml = sheetObj.GetSearchData("EES_DMT_2006GS.do", FormQueryString(formObj));
			    sheetObj.LoadSearchData(sXml, {Sync:1});					
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************					
				break;
        }
    }
	/**
	 * Combo initializing 
	 */	
	function doActionIBCommon(sheetObj, formObj, sAction, sComboAction) {
	    sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    switch(sAction) {
	    	//Search Tariff Type
	    	case IBSEARCH_TARIFF:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				//*********************************************************************************
				var comboItems=ComSearchEtcData(sheetObj, "DMTCommonFinderGS.do", FormQueryString(formObj), "all_tariff_cd").split(ROWMARK);
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var comboObj=comboObjects[0];
				addComboItem(comboObj,comboItems);
				//4.Tariff : set all selected
				selectAllTariff();
				break;
			//Search CUSTOMER NAME
        	case IBSEARCH_CUST_NM:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				//*********************************************************************************
				var custNm=ComSearchEtcData(sheetObj, "DMTCommonFinderGS.do", FormQueryString(formObj), "CUST_NM");
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				if (custNm == "") {
					ComShowCodeMessage("DMT06001");
					ComClearObject(formObj.custCd);
					ComClearObject(formObj.custNm);
					ComSetFocus(formObj.custCd);
					return;
				} else {
					//set to  8-digit
					if (ComGetObjValue(formObj.custCd).length < 8)
						ComSetObjValue(formObj.custCd, fetchLeftPadding(ComGetObjValue(formObj.custCd)));
					ComSetObjValue(formObj.custNm, custNm);
				}
        		break;					
	    }
		sheetObj.SetWaitImageVisible(1);
	}
    /**
     * IBTab Object is defined as an array.
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * Initialization Tab
     * Setting Tab's entry.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "Received" , "");
					InsertItem( "Sent" , "");
					SetSelectedIndex(0);
                }
             	break;
         }
    }
    /**
     * Click on Tab event-related
     * Elements selected tab is active.
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="block";
    	objs[beforetab].style.display="none";
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
  	/** 
  	 * IBCombo Object set to an array
  	 * param : combo_obj 
  	 * adding process for list in case of needing batch processing with other items
  	 * defining list on the top of source
  	 */ 
  	function setComboObject(combo_obj) {  
  		comboObjects[comboCnt++]=combo_obj;  
  	}
  	/**
   	 * Initializing Combo 
   	 * param : comboObj , comboNo
   	 *  adding case as numbers of counting Combos
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form
   	    switch(comboNo) {
   	    	//Tariff Type
   	    	case 1:
   	    		with(comboObj) {
   					SetMultiSelect(1);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "55");
					SetColWidth(1, "330");
   					//SetDropHeight(200);
   	    		}
   	    		break;
   	     } 
   	}
	/**
     * Data in the field adds a combo.
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i=0 ; i < comboItems.length ; i++) {
    		var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
    /**
     * Select the first item
     */	
 	function setComboItem(comboObj,comboItems) {
 		var checkedItem=comboItems[0].split(FIELDMARK);
 		comboObj.SetSelectText(checkedItem[0]);
 	}
 	
 	//Tariff Type Multi Combo click event
 	/*
 	function combo1_OnCheckClick(comboObj ,index, code) {
 		var comboObj =comboObjects[0]; 
 		setMultiCombo(comboObj, index, code) ;
 	}
	*/
 	
 	var comboIndex, comboCode;
 	function combo1_OnSelect(comObj, index, code) {
 	    comboIndex = index;
 	    comboCode = code;
 	}
 	
 	function combo1_OnChange(comObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
 	    setMultiCombo(comObj, comboIndex, comboCode);
 	}

 	
    /**
    * handling process for input validation
    */
   function validateForm(sheetObj,formObj,sAction){
       with(formObj){
    	   //No select Type : Retrieve error
    	   if (!searchType[0].checked && !searchType[1].checked && !searchType[2].checked) {
    		   ComShowCodeMessage("DMT02010");
       		   ComSetFocus(searchType[0]);
       		   return false;
       		}
       }
       return true;
   }
    /**	 
	 * Tariff Type : all selected
	 */		
	function selectAllTariff() {
		var comboObj=comboObjects[0];
		for (var i=0 ; i < comboObj.GetItemCount(); i++) {
			comboObj.SetItemCheck(i, true); 
    	} 		
	}
	function openWinSearchCustomer(srcName) {
		var sheetObj=sheetObjects[0];
		doProcessPopup(sheetObj, srcName);
	}
    /**	 
	 * Received Tab of the S / C Exception Tariff Double-click one of the items retrieved, the pop-up pops and gives CRUD Screen.
	 */		 
	function t1sheet1_OnDblClick(sheetObj,Row,Col) {
		 //var sheetObj=sheetObjects[0];
		 doProcessPopup(sheetObj, 't1sheet1');
	}
    /**	 
	 * Sent Tab of the S / C Exception Tariff Double-click one of the items retrieved, the pop-up pops and gives CRUD Screen.
	 */		 
	function t2sheet1_OnDblClick(sheetObj,Row,Col) {
		 //var sheetObj=sheetObjects[3];
		 doProcessPopup(sheetObj, 't2sheet1');
	}
    /**	 
	 * Before Booking DAR of Received Tab, double click one of the items retrieved, the pop-up pops CRUD Screen gives you.
	 */		 
	function t1sheet2_OnDblClick(sheetObj,Row,Col) {
		 //var sheetObj=sheetObjects[1];
		 doProcessPopup(sheetObj, 't1sheet2');
	}
    /**	 
	 * Before Booking DAR of Sent Tab, double click one of the items retrieved, the pop-up pops CRUD Screen gives you.
	 */		 
	function t2sheet2_OnDblClick(sheetObj,Row,Col) {
		 //var sheetObj=sheetObjects[4];
		 doProcessPopup(sheetObj, 't2sheet2');
	}
    /**	 
	 * Received Tab  After Booking DAR, double click one of the items retrieved, the pop-up pops CRUD Screen gives you.
	 */		 
	function t1sheet3_OnDblClick(sheetObj,Row,Col) {
		 //var sheetObj=sheetObjects[2];
		 doProcessPopup(sheetObj, 't1sheet3');
	}		
    /**	 
	 * Sent Tab  After Booking DAR, double click one of the items retrieved, the pop-up pops CRUD Screen gives you.
	 */		 
	function t2sheet3_OnDblClick(sheetObj,Row,Col) {
		 //var sheetObj=sheetObjects[5];
		 doProcessPopup(sheetObj, 't2sheet3');
	}
 	/*
 	 * Each common pop-up function calls 
 	 */
 	function doProcessPopup(sheetObj, srcName) {
 		var formObj=document.form;
 		var sUrl='';
 		var sWidth='';
 		var sHeight='';
 		
  		switch(srcName) {
  			case "cust_cd":		// Customer Inquiry Popup
				ComOpenPopup('COM_ENS_041.do', 770, 485, "findCustomer", "0,1", true);
				break;
			
  			case "t1sheet1":
  			case "t2sheet1":
  				var propNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), PROP_NO);
  				ComOpenPopup('EES_DMT_2001.do?prop_no=' + propNo + '&caller=2006', 1280, 755, "findCustomer", "0,1", false);
  				break;
  			
  			case "t1sheet2":
  			case "t2sheet2":
  				var darNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), DAR_NO);
  				ComOpenPopup('EES_DMT_2005P.do?dar_no=' + darNo + '&caller=2006&sheetId=' + srcName, 1280, 675, "findCustomer", "0,1", false);
  				break;
  			
  			case "t1sheet3":
  			case "t2sheet3":
  				var darNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), DAR_NO);
  				ComOpenPopup('EES_DMT_2009P.do?dar_no=' + darNo + '&caller=2006&sheetId=' + srcName, 1280, 600, "findCustomer", "0,1", false);
  				break;
  		}
 	}
 	/**
	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
	 */
	function findCustomer(aryPopupData) {
		var formObj=document.form;
		document.form.custCd.value=aryPopupData[0][3];
		document.form.custNm.value=aryPopupData[0][4];
	}
 	/**
 	 * Request & Approval Status Inquiry of S/C and DAR  to query data that meet the criteria that define the behavior of the function
 	 */ 	 
	function doActionRetrieve() {
 		var formObj=document.form;
 		var sheetSCObjRcvTab=sheetObjects[0];	//S/C Exception Grid Object in Received tab
 		var sheetSCObjSntTab=sheetObjects[3];	//S/C Exception Grid Object in Sent tab
 		var sheetBBObjRcvTab=sheetObjects[1];	//Before Booking Grid Object in Received tab
 		var sheetBBObjSntTab=sheetObjects[4];	//Before Booking Grid Object in Sent tab
 		var sheetABObjRcvTab=sheetObjects[2];	//After Booking Grid Object in Received tab
 		var sheetABObjSntTab=sheetObjects[5];	//After Booking Grid Object in Sent tab
 		with(formObj) {
	 		if (searchType[0].checked == false && searchType[1].checked == false && searchType[2].checked == false) {
	 			ComShowCodeMessage("DMT02010");
	 			return;
	 		}
 		}
 		var sCNo=ComTrim(ComGetObjValue(formObj.sCNo));
 		var rFANo=ComTrim(ComGetObjValue(formObj.rFANo));
 		var propNo=ComTrim(ComGetObjValue(formObj.proposalNo));
 		var darNo=ComTrim(ComGetObjValue(formObj.darNo));
 		var apvlNo=ComTrim(ComGetObjValue(formObj.approvalNo));
 		var bkgNo=ComTrim(ComGetObjValue(formObj.bkgNo));
 		var blNo=ComTrim(ComGetObjValue(formObj.blNo));
 		if (formObj.cond_type[0].checked) {
 			var startDt=ComTrim(ComGetObjValue(formObj.updDtFm));
 			var endDt=ComTrim(ComGetObjValue(formObj.updDtTo))
 			if (startDt == "") {
 				ComShowCodeMessage("DMT00102", "'Update'");
 				ComSetFocus(formObj.updDtFm);
 				return false;
 			} else if (endDt == "") {
 				ComShowCodeMessage("DMT00102", "'Update'");
 				ComSetFocus(formObj.updDtTo);
 				return false;
 			}
			startDt=ComGetUnMaskedValue(startDt, 	'ymd');
     		endDt=ComGetUnMaskedValue(endDt, 	'ymd');
            limitDt=ComGetDateAdd(startDt, "M", 1);
            if (ComChkPeriod(endDt, limitDt) == 0) {
            	ComShowCodeMessage("DMT00162", "1 month");
            	return false;
            }
 		}
 		else if (formObj.cond_type[1].checked) {
			var inputFieldCount=0;
			if (sCNo 	!= "") 	inputFieldCount++;
			if (rFANo 	!= "") 	inputFieldCount++;
			if (propNo 	!= "") 	inputFieldCount++;
			if (darNo 	!= "") 	inputFieldCount++;
			if (apvlNo 	!= "") 	inputFieldCount++;
			if (bkgNo 	!= "") 	inputFieldCount++;
			if (blNo 	!= "") 	inputFieldCount++;
			if (inputFieldCount == 0 || inputFieldCount > 1) {
			    ComShowCodeMessage("DMT00181");
			    ComSetFocus(formObj.sCNo);
			    return false;    			 
			}
			if (darNo != "") {
				var darType=darNo.substring(darNo.length - 1);
				if (darType != "A" && darType != "B") {
					ComShowCodeMessage("DMT00171", "DAR No.");
					ComSetFocus(formObj.darNo);
					return;
				}
			} else if (apvlNo != "") {
				var apvlType=apvlNo.substring(apvlNo.length - 1);
				if (apvlType != "A" && apvlType != "B") {
					ComShowCodeMessage("DMT00171", "APVL No.");
					ComSetFocus(formObj.approvalNo);
					return;
				}
			}
 		}
 		// Clear =======================================
 		sheetSCObjRcvTab.RemoveAll();
 		sheetSCObjSntTab.RemoveAll();
 		sheetBBObjRcvTab.RemoveAll();
 		sheetBBObjSntTab.RemoveAll();
 		sheetABObjRcvTab.RemoveAll();
 		sheetABObjSntTab.RemoveAll();
		//hide. ===============================
 		showColumn();
 		
 		//S/C searching ==============================================================
 		if (formObj.searchType[0].checked) {
 			ComSetObjValue(formObj.type, "SC");
 			if (formObj.cond_type[0].checked) {
 				ComSetObjValue(formObj.cond_tp, "DATE");
 				//Received Tab
 				ComSetObjValue(formObj.tab_tp, "RCV");
 				doActionIBSheet(sheetSCObjRcvTab,formObj,IBSEARCH);
 				//Sent Tab
 				if (ComGetObjValue(formObj.toCc) == "" || ComGetObjValue(formObj.toCc) == "to") {
	 				ComSetObjValue(formObj.tab_tp, "SND");
	 				doActionIBSheet(sheetSCObjSntTab,formObj,IBSEARCH);
 				}
 			}
 			//DAR searching
 			else if (formObj.cond_type[1].checked) {
 				//only S/C No. or Proposal No. inputted
 				if (sCNo != "" || propNo != "" || bkgNo != "" || blNo != "") {
	 				ComSetObjValue(formObj.cond_tp, "DAR");
	 				//Received Tab
	 				ComSetObjValue(formObj.tab_tp, "RCV");
	 				doActionIBSheet(sheetSCObjRcvTab,formObj,IBSEARCH);
 				}
 			}
 		}
 		//Before Booking Request  searching ===========================================
 		if (formObj.searchType[1].checked) {
 			ComSetObjValue(formObj.type, "BB");
 			//Date searching
 			if (formObj.cond_type[0].checked) {
 				ComSetObjValue(formObj.cond_tp, "DATE"); 				
 				//Received Tab
 				ComSetObjValue(formObj.tab_tp, "RCV");
 				doActionIBSheet(sheetBBObjRcvTab,formObj,IBSEARCH);
 				//Sent Tab
 				if (ComGetObjValue(formObj.toCc) == "" || ComGetObjValue(formObj.toCc) == "to") { 				
 					ComSetObjValue(formObj.tab_tp, "SND");
 					doActionIBSheet(sheetBBObjSntTab,formObj,IBSEARCH);
 				}
 			}
 			//DAR searching
 			else {
 				//only RFA No.or Proposal No.or DAR No.or APVL No.  inputted
 				if (rFANo != "" || propNo != "" || darNo != "" || apvlNo != "" || bkgNo != "" || blNo != "") {
 					ComSetObjValue(formObj.cond_tp, "DAR");
					//Received Tab
					ComSetObjValue(formObj.tab_tp, "RCV");
					var isRetrieve=false;
 					if (darNo != "") {
 						if (darNo.substring(darNo.length - 1) == "B") {
 							isRetrieve=true;
 						}
 					} else if (apvlNo != "") {
 						if (apvlNo.substring(apvlNo.length - 1) == "B") {
 							isRetrieve=true;
 						} 
 					} else {
 						isRetrieve=true;
 					}
 					if (isRetrieve) doActionIBSheet(sheetBBObjRcvTab,formObj,IBSEARCH);
 				}
 			}
 		}
 		//After Booking Request============================================
 		if (formObj.searchType[2].checked) {
 			ComSetObjValue(formObj.type, "AB");
 			if (formObj.cond_type[0].checked) {
 				ComSetObjValue(formObj.cond_tp, "DATE"); 				
 				//Received Tab
 				ComSetObjValue(formObj.tab_tp, "RCV");
 				doActionIBSheet(sheetABObjRcvTab,formObj,IBSEARCH);
 				//Sent Tab
 				if (ComGetObjValue(formObj.toCc) == "" || ComGetObjValue(formObj.toCc) == "to") { 
 					ComSetObjValue(formObj.tab_tp, "SND");
 					doActionIBSheet(sheetABObjSntTab,formObj,IBSEARCH);
 				}
 			}
 			//DAR
 			else {
 				//only S/C no or RFA No.or Proposal No.or DAR No.or APVL No.  inputted
 				if (sCNo != "" || rFANo != "" || darNo != "" || apvlNo != "" || bkgNo != "" || blNo != "") {
 					ComSetObjValue(formObj.cond_tp, "DAR");
					//Received Tab
					ComSetObjValue(formObj.tab_tp, "RCV");
					var isRetrieve=false;
 					if (darNo != "") {
 						if (darNo.substring(darNo.length - 1) == "A") {
 							isRetrieve=true;
 						}
 					} else if (apvlNo != "") {
 						if (apvlNo.substring(apvlNo.length - 1) == "A") {
 							isRetrieve=true;
 						} 						
 					} else {
 						isRetrieve=true;
 					}
 					if (isRetrieve) doActionIBSheet(sheetABObjRcvTab,formObj,IBSEARCH); 					
 				}
 			}
 		}
	}
 	/**
	 * Request & Approval Status conditions of S/C and DAR initializing
	 */ 	 
	function doActionNew() {
		 initViewControls();
	}
	function doActionMinimize() {
		if (conditionLayer.style.display == 'block') {
			conditionLayer.style.display='none';
		} else {
			conditionLayer.style.display='block';
		}
		displayGridByType();
	}
 	/**
	 * S/C and Request & Approval Status of DAR through its pop-up screen, a function that defines the behavior of Detail
	 */ 	 
	function doActionDetail() {
		var formObj=document.form;
		var isOpenWin=false;
		var fromSheetNo=tabObjects[0].GetSelectedIndex()* 3;
		var toSheetNo=(tabObjects[0].GetSelectedIndex()+ 1) * 3;
		for (var sheetNo=0 ; sheetNo < sheetObjects.length ; sheetNo++) {
			if (sheetNo < fromSheetNo || sheetNo >= toSheetNo) continue;
			var sheetObj=sheetObjects[sheetNo];
			with(sheetObj) {
				if (RowCount()> 0 && GetSelectRow()>= HeaderRows()) {
					switch(id) {
						case "t1sheet1":
							doProcessPopup(sheetObj, 't1sheet1');
							isOpenWin=true;
							break;
						case "t2sheet1":
							doProcessPopup(sheetObj, 't2sheet1');
							isOpenWin=true;
							break;
						case "t1sheet2":
							doProcessPopup(sheetObj, 't1sheet2');
							isOpenWin=true;
							break;
						case "t2sheet2":
							doProcessPopup(sheetObj, 't2sheet2');
							isOpenWin=true;
							break;
						case "t1sheet3":
							doProcessPopup(sheetObj, 't1sheet3');
							isOpenWin=true;
							break;
						case "t2sheet3":
							doProcessPopup(sheetObj, 't2sheet3');
							isOpenWin=true;
							break;
					}
					if (isOpenWin) break;
				}
			}
		}
	}
	
	function doActionDownExcel(sheetObj) {
		if(sheetObj.RowCount() < 1){
			ComShowCodeMessage("COM132501");
		} else {
			sheetObj.Down2Excel({ HiddenColumn:-1});
		}
	}
	
	function initColumn() {
 		for (var i=3 ; i < 6 ; i++) {
			sheetObjects[i].SetColHidden(TO_CC,1);
		} 
	}
 	/**
 	 * Depending on conditions, the selection of Inquiry and inputs, lookup, show or hide much of a particular field functions that operate
 	 */
	function showColumn() {
		var formObj=document.form;
		//1.Group By 
		if (ComTrim(ComGetObjValue(formObj.groupBy)) == "DAR") {
			for (var i=0 ; i < sheetObjects.length ; i++) {
				sheetObjects[i].SetColHidden(TARIFF,1);
				//After Booking 
				if ((i + 1) % 3 == 0) {
					sheetObjects[i].SetColHidden(CVRG,1);
					sheetObjects[i].SetColHidden(BKG_NO,1);
					sheetObjects[i].SetColHidden(BL_NO,1);
				}
				//S/C, Before Booking
				else {
					sheetObjects[i].SetColHidden(CVRG_CNT,1);
					sheetObjects[i].SetColHidden(CVRG_RGN,1);
					sheetObjects[i].SetColHidden(CVRG_LOC,1);
				}
			}
		}
		else {
			for (var i=0 ; i < sheetObjects.length ; i++) {
				sheetObjects[i].SetColHidden(TARIFF,0);
				//After Booking
				if ((i + 1) % 3 == 0) {
					sheetObjects[i].SetColHidden(CVRG,0);
					sheetObjects[i].SetColHidden(BKG_NO,0);
					sheetObjects[i].SetColHidden(BL_NO,0);
				}
				//S/C, Before Booking 
				else {
					sheetObjects[i].SetColHidden(CVRG_CNT,0);
					sheetObjects[i].SetColHidden(CVRG_RGN,0);
					sheetObjects[i].SetColHidden(CVRG_LOC,0);
				}				
			}		
		}
		//2.Date or DAR 
		if (formObj.cond_type[0].checked) {
			showToCcColumn(false);
		} else {
			showToCcColumn(true);
		} 
	}
  	/**
  	 * Sent  CC  field  hide
  	 */ 	 
    function showToCcColumn(flag) {
		for (var i=0 ; i < 3 ; i++) {
			sheetObjects[i].SetColHidden(TO_CC,flag);
		}    	
    }
 	/**
 	 * DAR search field, enter the value of the items in a particular field when the other fields Clear all makes.
 	 */
 	function clearNoSelectDARFields() {
 	    var formObj=document.form;
 		with(formObj) {
 			switch(ComGetEvent("name")) {
 				case "sCNo":
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);
 					break;
 				case "rFANo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 				case "proposalNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 				case "darNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 				case "approvalNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 				case "bkgNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(blNo)) != "") ComClearObject(blNo);					
 					break;
 				case "blNo":
 					if (ComTrim(ComGetObjValue(sCNo)) != "") ComClearObject(sCNo);
 					if (ComTrim(ComGetObjValue(rFANo)) != "") ComClearObject(rFANo);
 					if (ComTrim(ComGetObjValue(proposalNo)) != "") ComClearObject(proposalNo);
 					if (ComTrim(ComGetObjValue(darNo)) != "") ComClearObject(darNo);
 					if (ComTrim(ComGetObjValue(approvalNo)) != "") ComClearObject(approvalNo);
 					if (ComTrim(ComGetObjValue(bkgNo)) != "") ComClearObject(bkgNo);						
 					break;				
 			}
 		}		
 	}
  	/**
  	 * Select or deselect the Type, depending on the show or hide the corresponding Sheet function that performs the action
  	 */ 	 
 	function displayGridByType() {
 		var formObj=document.form;
		 var sheetRcvSCObj=sheetObjects[0];
		 var sheetRcvBBObj=sheetObjects[1];
		 var sheetRcvABObj=sheetObjects[2];
		 var sheetSntSCObj=sheetObjects[3];
		 var sheetSntBBObj=sheetObjects[4];
		 var sheetSntABObj=sheetObjects[5];
 		var displayGridCount=0;
 		with(formObj) {
	 		for (var typeNo=0 ; typeNo < searchType.length ; typeNo++) {
	 			if (searchType[typeNo].checked) {
	 				displayGridCount++;
	 			}
	 		}
	 		var addHeight=0;
	 		switch(displayGridCount) {
		 		case 1:
		 			addHeight = 190;
			 		if (conditionLayer.style.display == 'none') {
			 			addHeight += 161;
			 		}
			 		break;
		 		
		 		case 2:
		 			addHeight = 40;
			 		if (conditionLayer.style.display == 'none') {
			 			addHeight += 80;
			 		}
			 		break;
			 	
		 		case 3:
		 			addHeight = 40;
			 		if (conditionLayer.style.display == 'none') {
			 			addHeight += 51;
			 		}				 		
			 		break;
		 		
	 		}

	 		//S/C Exception Tariff
 	 		if (searchType[0].checked) {
 	 			receivedTabSCTariffLayer.style.display='block';
 	 			sentTabSCTariffLayer.style.display='block';
 	 			sheetRcvSCObj.SetSheetHeight(DEF_SHEET_HEIGHT + addHeight);
 	 			sheetSntSCObj.SetSheetHeight(DEF_SHEET_HEIGHT + addHeight);
 	 		} else {
 	 			receivedTabSCTariffLayer.style.display='none';
 	 			sentTabSCTariffLayer.style.display='none';
 	 		}
 	 		//Before Booking DAR
 	 		if (searchType[1].checked) {
 	 			receivedTabBeforeBookingLayer.style.display='block';
 	 			sentTabBeforeBookingLayer.style.display='block';
 	 			sheetRcvBBObj.SetSheetHeight(DEF_SHEET_HEIGHT + addHeight);
 	 			sheetSntBBObj.SetSheetHeight(DEF_SHEET_HEIGHT + addHeight);
 	 		} else {
 	 			receivedTabBeforeBookingLayer.style.display='none';
 	 			sentTabBeforeBookingLayer.style.display='none';
 	 		}
 	 		//After Booking DAR
 	 		if (searchType[2].checked) {
 	 			receivedTabAfterBookingLayer.style.display='block';
 	 			sentTabAfterBookingLayer.style.display='block';
 	 			sheetRcvABObj.SetSheetHeight(DEF_SHEET_HEIGHT + addHeight);
 	 			sheetSntABObj.SetSheetHeight(DEF_SHEET_HEIGHT + addHeight);
 	 		} else {
 	 			receivedTabAfterBookingLayer.style.display='none';
 	 			sentTabAfterBookingLayer.style.display='none';
 	 		} 	 			
 		}
 	}
  	/**
  	 * set Office 
  	 */
  	function setDefaultOffice() {
  		var formObj=document.form;
  		var cboTariff=comboObjects[0];
	 	with(formObj) {
	 		//Tariff  deactivating 
	 		//cboTariff.Text = "";
	 		//cboTariff.Enable = false;
		 	//Office  deactivating  and setting
	 		ComEnableManyObjects(false, office);
	 		ComSetObjValue(office, login_ofc_cd.value);
 			ComSetObjValue(usr_ofc_cd, login_ofc_cd.value);
 			ComSetObjValue(ofc_cd, login_ofc_cd.value);
	 	}  		
  	}
   /**
   	* User Only check for the column, To/Cc functions that change status
    */
  	function modifyToCc() {
  		var formObj=document.form;
  		//When selecting User Only, To/CC the "To" or "All" maintaining and deactivating
  		with(formObj) {
  			if (formObj.userOnly.checked) {
  				ComSetObjValue(toCc, "to");
  				ComEnableManyObjects(false, toCc);
  				toCc.className="input2";
  			} else {
 				ComSetObjValue(toCc, "");
  				ComEnableManyObjects(true, toCc);
  				toCc.className="input";  				
  			}
  		}
  	}
   /**
 	* According to the eight-digit Customer Code returned by a function that
 	*/	
    function fetchLeftPadding(custCd) {
    	var result=custCd;
    	if (custCd != "" && custCd.length > 2) {
			var custCnt=custCd.substring(0,2);
			var custSeq=custCd.substring(2);
			switch(custSeq.length) {
				case 1: custSeq="00000" + custSeq;
					break;
				case 2: custSeq="0000" + custSeq;
					break;
				case 3: custSeq="000" + custSeq;
					break;
				case 4: custSeq="00" + custSeq;
					break;
				case 5: custSeq="0" + custSeq;
					break;
			}
			result=custCnt + custSeq;
    	}
    	return result;
    }
   /** 
 	* Check Req Office and  Approval Office 
 	*/
    function isSameOffice(reqOfc, apvlOfc) {
    	return true;
    }
    /**
    * Delivered normally not received from the server being able to handle the data function 
    */
   function handleNullString(sVal) {
        if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";
        return ComTrim(sVal);
   } 	
