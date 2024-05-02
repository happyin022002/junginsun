/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0026.js
*@FileTitle  : Budget vs Actual
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/26
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
 var WIDTH_DETAIL_POPUP=1050;
 var HEIGHT_DETAIL_POPUP=510;
 var gRefresh=true; //2016.05.19 BackEndJob Add
 
// Event handler processing by button click event */
 	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
	        switch(srcName) {
				case "btn_Retrieve":
       	  			//if(!checkVvd(document.form)) break;
       	  			doActionIBSheet(sheetObject1,formObject,IBSEARCH); //Normal Retrieve
       	  			//doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01); //2016.05.19 Add BackEndJob.
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_port_cd":
					var sUrl="/opuscntr/VOP_VSK_0043.do";
					ComOpenPopup(sUrl, 805, 510, "portCallBack", "0,0", true);
					break;
				case "btn_period" :
					var cal=new ComCalendarFromTo();
					cal.select(formObject.from_date, formObject.to_date, 'yyyy-MM-dd');
					break;
				case "btn_vvd_search":
					var vsl_cd=formObject.vsl_cd.value;
                	var sUrl="";
                	if(vsl_cd == ""){
                		sUrl="/opuscntr/VOP_VSK_0219.do";
                		ComOpenPopup(sUrl, 500, 480, "getVslCdData", "0,0", true);
                	}else{
                		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
                		ComOpenPopup(sUrl, 340, 400, "getVvdData", "0,0", true);
                	}
				break;
				case "btn_lane_search":
					openLaneCode();
		        break;
				case "btn_DownExcel":
					
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel({ HiddenColumn:true, DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
					}
	
				break;	
				case "btn_Detail":
					var prefix = "sheet1_";
					var selectRow = sheetObject1.GetSelectRow();
					if(selectRow < 0 || sheetObject1.RowCount < 1) return;
					var param  = "port_cd="     + sheetObjects[0].GetCellValue(selectRow, prefix + "yd_cd");
						param += "&vvd="     + sheetObjects[0].GetCellValue(selectRow, prefix + "vvd");
						param += "&acct_cd="     + sheetObjects[0].GetCellValue(selectRow, prefix + "acct_cd");
						param += "&vndr_seq="     + sheetObjects[0].GetCellValue(selectRow, prefix + "vndr_seq");
						param += "&iss_cty_cd=" + sheetObjects[0].GetCellValue(selectRow, prefix + "iss_cty_cd");
						param += "&so_seq="     + sheetObjects[0].GetCellValue(selectRow, prefix + "so_seq");
						param += "&cost_cd="     + sheetObjects[0].GetCellValue(selectRow, prefix + "cost_cd");
					var sUrl="/opuscntr/VOP_PSO_0214.do?" + param;	
					var sFeatures="toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_DETAIL_POPUP + ",height=" + HEIGHT_DETAIL_POPUP;
					ComOpenPopup(sUrl, WIDTH_DETAIL_POPUP, HEIGHT_DETAIL_POPUP, "", "0,1", true);
					
					//ComOpenWindow(sUrl, "DETAIL", sFeatures, false);
				break;	
				
				case "btns_VendorSeq":
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 560, 'setVendorSeq', '1,0,1,1,1', true);
				break;
            }
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
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
		var formObject=document.form
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
//			doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
        }
		initControl(sheetObjects[0]);  
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
		
		sheet1_OnLoadFinish(sheetObjects[0]);

		
    }
     //no support[check again]CLT 
    function sheet1_OnLoadFinish(sheetObj) {
    	 sheetObj.SetWaitImageVisible(0);
    	 var formObject=document.form;  
//   	 doActionIBCombo(sheetObjects[0] ,formObject,IBSEARCH,SEARCHLIST); 
//    	 doActionIBCombo(sheetObjects[0], formObject, COMMAND02);
    	 doActionIBCombo(sheetObjects[0], formObject, IBSEARCH, SEARCH01);
     }
      /**
       * setting combo initial values and header
       * param : comboObj, comboNo
       * adding case as numbers of counting combos
       */ 
      function initCombo(comboObj, comboNo) {
    	  var formObject=document.form;
    	  
    	  switch(comboObj.options.id) {  
	    	  case "term_code":		//Yard 
		    	  with (comboObj) { 
		    		  SetMultiSelect(1);
		    		  SetUseAutoComplete(1);
		    		  SetColAlign(0, "left");
		    		  SetColAlign(1, "left");
		    		  SetColWidth(0, "40");
		    		  SetColWidth(1, "340");
		    		  SetDropHeight(160);
		    	  }
	    	  break; 
	    	  case "combo1":		//Account 
		    	  with (comboObj) { 
		    		  SetMultiSelect(0);
		    		  SetUseAutoComplete(1);
		    		  SetColAlign(0, "left");
		    		  SetColWidth(0, "60");
					  SetColWidth(1, "300");
					  SetDropHeight(190);
					  SetMaxLength(6);
						
		    	  }
	    	  break; 
	    	  //VOP_VSK_0027
			  case "vskd_port_rhq_cd": 	//CTRL H/Q
					with (comboObj) { 
						SetMultiSelect(0);
						SetUseAutoComplete(1);
						SetColAlign(0, "left");
						SetDropHeight(160);
					}
			  break;
			  case "sls_ofc_cd":		//CTRL H/Q
					with (comboObj) { 
						SetMultiSelect(0);
						SetUseAutoComplete(1);
						SetColAlign(0, "left");
						SetDropHeight(160);
					}
			  break;	    
			  case "cntr_vsl_clss_capa":		//Vessel Class
					with (comboObj) { 
						SetMultiSelect(0);
						SetUseAutoComplete(1);
						SetColAlign(0, "left");
						SetColWidth(0, "65");
						SetDropHeight(160);
					}
			  break;
//			  case "vsl_slan_cd":		//Lane CDs
//					with (comboObj) { 
//						MultiSelect = false;
//						UseAutoComplete = true;	
//						SetColAlign("left");        
//						SetColWidth("50");
//						DropHeight = 160;
//					}
//			  break;
    	  } 
      }
    /**
     * registering initial event
     */
    function initControl(sheetObj){
    	formObj=document.form;
    	//setToday(formObj.from_date,"ymd");
    	document.form.from_date.value=ComGetDateAdd(ComGetNowInfo("ymd"),"M",-1,"-");
    	setToday(formObj.to_date,"ymd");

		axon_event.addListenerForm	('change'  , 'obj_change'      , form);
        axon_event.addListenerForm  ('blur'    , 'obj_deactivate'   , form); 
    	axon_event.addListenerForm  ('paste'   , 'obj_paste'       , form); 
    	axon_event.addListenerForm  ('drop'    , 'obj_drop'        , form); 
    }
    
 // Retrieving Lane SVC Type
    function doActionIBCombo( sheetObj , formObj,sAction,sComboAction ) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {

    		case IBSEARCH_ASYNC01: 
    			if (sheetObj.id == "sheet1") {				
    				//Initializing combo
    				term_code.RemoveAll();	//Yard
    				formObj.f_cmd.value=COMMAND01;
    				//var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", FormQueryString(formObj));
    				var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", FormQueryString(formObj));
    				var comboItems=ComGetEtcData(sXml, "lane").split(ROWMARK);
    				addComboItem(term_code,comboItems);	
    			};
                break;
    
    		case COMMAND03:      // Control Office
    			formObj.f_cmd.value=SEARCH02;
    			var sParam=FormQueryString(formObj);
    			var sXml=sheetObj.GetSearchData("VOP_PSO_0026GS.do", sParam);
    			return sXml;
    			break;
    		case IBSEARCH:      // Open
    			formObj.f_cmd.value=SEARCH01;
    			var sParam=FormQueryString(formObj);
    			var sXml=sheetObj.GetSearchData("VOP_PSO_0026GS.do", sParam);
    			var rhqCdArr=("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	//CTRL H/Q
    			var rhqDescArr=("ALL|"+ComGetEtcData(sXml, "rhq_list")).split("|");	
    			appendMultiComboItem(vskd_port_rhq_cd, rhqCdArr, rhqDescArr, "", "DEF");
    			var comboItems=ComGetEtcData(sXml, "account" ).split(ROWMARK); //Account
    			//comboObjects[2].RemoveAll();
    			addComboItem(combo1,comboItems);
    			var comboItems1=ComGetEtcData(sXml, "vsl" ).split(ROWMARK); //Vessel Class
    			//comboObjects[4].RemoveAll();
    			addComboItem(cntr_vsl_clss_capa,comboItems1);
    			break;  
	    }
	}
	/**
	 * Adding data to combo
	 */	
	function addComboItem(comboObj,comboItems) {
		comboObj.RemoveAll();
		for (var i=0 ; i < comboItems.length ; i++) {
			var comboItem=comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1] , comboItem[0]);
		}   		
		comboObj.InsertItem(0, "ALL","");
	}
	/**
	 * Adding data to class combo
	 */	
	function addComboItemClass(comboObj,comboItems) {
		 comboObj.RemoveAll(); 
		 if(comboItems == null || comboItems.length == 1 ){
			 comboObj.SetEnable(false);
		 }else{
			 comboObj.SetEnable(true);
		 }
		 for (var i=1 ; i < comboItems.length ; i++) {
			 comboObj.InsertItem(i-1, comboItems[i] , comboItems[i]);
		 }
		 if(!(comboItems == null || comboItems.length == 1)){
			 comboObj.InsertItem(0, "ALL","");
		 }
	}

	function obj_change(){
		var formObj	= document.form;
		var eleObj	= ComGetEvent();
		/*******************************************************/
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "port_cd":
		    	if(eleObj.value.length == 5){
		    		loadTerminal();
		    		term_code.Focus();
		    		sheetObjects[0].RemoveAll();
		    	} else{
		    		term_code.RemoveAll();
		    	}
				break;
		    case "term_code":
		    	if(eleObj.value.length == 2){
		    		formObj.vsl_cd.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;
		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		combo1.focus();
		    		sheetObjects[0].RemoveAll();
		    	}
				break;
		} 
	}
	
	
	//Copy & Paste
	function obj_paste(){
		var eleObj=ComGetEvent();
		var formObj=document.form;
		switch (eleObj.name) {
			case "port_cd":
				gf_SetControlPastePattern(event, "A");
				break;
			case "vsl_cd":
				gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
				break;
			case "skd_voy_no":
				gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
				break;
			case "skd_dir_cd":
				gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
				break;				
			case "vndr_seq":
				gf_SetControlPastePattern(event, "0");
				break;			
			case "from_date":
				gf_SetControlPastePattern(event, "0");
				break;			
			case "to_date":
				gf_SetControlPastePattern(event, "0");
				break;			
		}
	}
	function obj_drop(){
		event.returnValue=false;
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
		        	
		        	var HeadTitle1 ="|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|Account Code|Account Code|Cost Code|Cost Code|Service Provider|Service Provider|Curr.|I/O|Tariff Cost|Adjustment|INV.AMT|INV.AMT(USD)|Status|INV.No.|CSR No.|Remark|Vessel Class||";
		        	    HeadTitle1 +="|Formula|Formula|Rev Lane|Rev VVD|ATD/ETD|Payment|Payment|Created User|Created Date|Updated  User|Updated  Date";
		        	var HeadTitle2 ="|CTRL\nH/Q|CTRL\nOFC|Port\nCD|TMNL\nCD|Lane\nCD|VVD|CD|Des.|CD|Des.|CD|Des.|Curr.|I/O|Tariff Cost|Adjustment|INV.AMT|INV.AMT(USD)|Status|INV.No.|CSR No.|Remark|Vessel Class||";
		        	    HeadTitle2 +="|Formula|Formula|Rev Lane|Rev VVD|ATD/ETD|Paid Date|Due Date|Created User|Created Date|Updated  User|Updated  Date";
		        	var headCount=ComCountHeadTitle(HeadTitle1);
		        	var prefix="sheet1_";

		        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
		        	var headers = [ { Text:HeadTitle1, Align:"Center"},
		        	                { Text:HeadTitle2, Align:"Center"} ];
		        	InitHeaders(headers, info);

		        	var cols = [ 
		        	             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		        	             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vskd_port_rhq_cd", KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sls_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",              KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"acct_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cost_nm",          KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",         KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"io",          	 KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"calc_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"adj_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"locl_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"usd_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
		        	             {Type:"Text",      Hidden:0, Width:75,   Align:"Left",    ColMerge:1,   SaveName:prefix+"status",         	 KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"inv_no",           KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:prefix+"csr_no",           KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_clss",         KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:prefix+"iss_cty_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:1, Width:10,   Align:"Left",    ColMerge:1,   SaveName:prefix+"so_seq",           KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"xpr_desc",         KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"foml_desc",        KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rev_vvd",          KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"act_dt",           KeyField:0,   CalcLogic:"",   Format:"####-##-##" },
                                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_dt",           KeyField:0,   CalcLogic:"",   Format:"" },
                                 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pay_due_dt",       KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"" },
		        	             {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"" }  ];
		       
		        	InitColumns(cols);

		        	SetEditable(0);
		            SetRowHeight(0,20);
		            SetRowHeight(1,20);
		            //SetSheetHeight(400);
		            resizeSheet();
		            SetRangeBackColor(1, 6, 1, 12,"#777777");
		            SetSumRowHidden(1);
				}
			    break;
        }
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var prefix="sheet1_";
		switch(sAction) {
	        case IBSEARCH_ASYNC01: //BackEndJob Start - process 1.
	            formObj.f_cmd.value=SEARCH03;
	            var sXml=sheetObj.GetSearchData("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	            var key=ComGetEtcData(sXml,"key");
	            if (key.length > 0) {
	                gRefresh=true; // should retrieve result file
	                formObj.key.value=key;
	                sheetObj.SetWaitImageVisible(0);
	                ComOpenWait(true);
	                sheetObj.SetWaitTimeOut(10000);
	                timer = setInterval(getBackEndJobStatus, 3000); // action getBackEndJobStatus function after 3 seconds.
	            }
	            break;	            
	        case IBSEARCH_ASYNC02:  //BackEndJob Status - process 2.        
	            formObj.f_cmd.value=SEARCH04;
	            var sXml=sheetObj.GetSearchData("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	            var jobState=ComGetEtcData(sXml, "jb_sts_flg")+"";
	            // 2 : processing, 3:success , 4:fail
	            if (jobState == "3") {//success
	                ComOpenWait(false);
	                clearInterval(timer);
	                //ComShowCodeMessage("JOO00160"); //Success to execute
	                //ComShowMessage("Success to execute.");
	                if (gRefresh)
	                    doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
	            } else if (jobState == "4") {
	                ComOpenWait(false);
	                clearInterval(timer);
	                // BackEndJob Fail
	                //ComShowCodeMessage('JOO00151'); //Fail to execute.
	                ComShowMessage("Fail to retrieve.");
	            } else if (jobState == "5") {
	                ComOpenWait(false);
	                clearInterval(timer);
	                //ComShowCodeMessage('JOO00152'); //Read result file aleady
	                ComShowMessage("Read result file aleady.");
	            }
	            break;
	            	            
	        case IBSEARCH_ASYNC03://BackEndJob result - process 3.          
	                sheetObj.SetWaitImageVisible(1);
	                formObj.f_cmd.value=SEARCH05;
	                var sXml=sheetObj.GetSearchData("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	                sheetObj.LoadSearchData(sXml,{Sync:0} );
	                break;
	            
			case IBSEARCH:      //Retrieving
           		if(!validateForm(sheetObj,formObj,sAction)) return;           		
       			//sheetObj.SetWaitImageVisible(0);
   	  			ComOpenWait(true);
       			formObj.f_cmd.value=SEARCH;
       			sheetObj.DoSearch("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
       			//var sXml=sheetObj.GetSearchData("VOP_PSO_0026GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), {Sync:2});
                //sheetObjects[0].LoadSearchData(sXml);	            
       			break;
       			
		  	case IBCLEAR:       //Initializing
				initSearchControls("CLEAR");
				break;
				
			case COMMAND06:	//Service Provider   
				formObj.f_cmd.value=COMMAND06;//
				var param=FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("VOP_PSO_0002GS.do", param );
				var spName=ComGetEtcData(sXml, "spName");	//Service Provider Name
				formObj.vndr_lgl_eng_nm.value=spName;
				if(spName != ""){
				} else{
					ComShowCodeMessage('PSO00021');	//There is no Service Provider like this.
					//formObj.vndr_seq.focus();
					formObj.vndr_seq.value="";
				}
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
    		 		if(from_date.value == ''){
           				ComShowCodeMessage('PSO00003');
           				from_date.focus();
           				return false;
           			}	
           			if(to_date.value == ''){
           				ComShowCodeMessage('PSO00003');
           				to_date.focus();
           				return false;
           			}	
           			break;
    		 }      
    	 }
         return true;
    }
     /** 
      * Handling deactivate event
      */
     function obj_deactivate(){
    	 var formObj=document.form;
    	 obj=ComGetEvent();      	
    	 with(formObj){
    		 if(obj.name=="from_date" || obj.name=="to_date"){
    			 var creDtFr=ComReplaceStr(from_date.value,"-","");
    			 var creDtTo=ComReplaceStr(to_date.value,"-","");
    			 switch(ComGetEvent("name")) {
	    	    	case "from_date":	// Agreement From Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				from_date.value='';
	    	    				from_date.focus();
	    	    				return;
	    	    			}
	    	    			//[2015.07.02]in 1 year
	    	    			var dayDiff = ComGetDaysBetween(creDtFr, creDtTo);
	    	    			if(Number(dayDiff) > 365){
	    	    				ComShowCodeMessage('COM12133','Period','1 year','less');
	    	    				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
	    	    				from_date.value='';
	    	    				from_date.focus();
	    	    				return;
	    	    			}
	    	    			//in 1 year
	    	    			/*if((Number(creDtTo.substr(0,4)) * 12 + Number(creDtTo.substr(4,2))) - (Number(creDtFr.substr(0,4)) * 12 + Number(creDtFr.substr(4,2))) >= 12){
	    	    				ComShowCodeMessage('COM12133','Period','1 year','less');
	    	    				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
	    	    				from_date.value='';
	    	    				from_date.focus();
	    	    				return;
	    	    			}*/
	    	    		}
	    	            break;
	    	    	case "to_date":	// Agreement To Date
	    	    		if(creDtFr != '' && creDtTo != ''){
	    	    			if(creDtFr > creDtTo){
	    	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	    	    				to_date.value='';
	    	    				to_date.focus();
	    	    				return;
	    	    			}
	    	    			//[2015.07.02]in 1 year
	    	    			var dayDiff = ComGetDaysBetween(creDtFr, creDtTo);
	    	    			if(Number(dayDiff) > 365){
	    	    				ComShowCodeMessage('COM12133','Period','1 year','less');
	    	    				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
	    	    				to_date.value='';
	    	    				to_date.focus();
	    	    				return;
	    	    			}
	    	    			//in 1 year
	    	    			/*if((Number(creDtTo.substr(0,4)) * 12 + Number(creDtTo.substr(4,2))) - (Number(creDtFr.substr(0,4)) * 12 + Number(creDtFr.substr(4,2))) >= 12){
	    	    				ComShowCodeMessage('COM12133','Period','1 year','less');
	    	    				//msgs['COM12133'] = '{?msg1} must be {?msg3} than {?msg2}.';
	    	    				to_date.value='';
	    	    				to_date.focus();
	    	    				return;
	    	    			}*/
	    	    		}
	    	           	break;	
	        	}
    			ComChkObjValid(ComGetEvent());
    		 }
    		 if(obj.name == "vndr_seq"){
 				if(obj.value != ""){
					doActionIBSheet(sheetObjects[0], formObj, COMMAND06);
				} else{
					formObj.vndr_lgl_eng_nm.value="";
				}
    		 }
        }
    }
    /**
     * 
     * @param rtnObjs
     * @return
     */
	function getLaneCodeData(rtnObjs){
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_slan_cd.value=rtnDatas[1];
				}
			}
    	}
	}
	/**
	  * INIT SETTING
	  */
	function initSearchControls(flag) {
		var formObj=document.form;
		ComClearObject( formObj.port_cd );
		ComClearObject( term_code );
		ComClearObject( formObj.vsl_cd );
		ComClearObject( formObj.skd_voy_no );
		ComClearObject( formObj.skd_dir_cd );
		ComClearObject( formObj.date_type );
		vskd_port_rhq_cd.SetSelectText("");
		sls_ofc_cd.SetSelectText("");
		//formObj.differ.checked = false;
		formObj.vndr_seq.value="";
		formObj.vndr_lgl_eng_nm.value="";
		formObj.vsl_slan_cd.value="";
//		ComClearObject( formObj.csr_no );
//		ComClearObject( formObj.inv_no );
		term_code.SetSelectText("");//Yard
		combo1.SetSelectText("");//Account
		cntr_vsl_clss_capa.SetSelectText("");//Vessel Class
//		formObj.status.Text = "";		//Status
		//setToday(formObj.from_date,"ymd");
    	document.form.from_date.value=ComGetDateAdd(ComGetNowInfo("ymd"),"M",-1,"-");
    	setToday(formObj.to_date,"ymd");
    	sheetObjects[0].RemoveAll();
//    	initControl(sheetObjects[0]);
    	sheet1_OnLoadFinish(sheetObjects[0]);
	}
    /**
     * Setting about VVD
     * @param obj
     * @return
     */
    function getVslCdData(obj){
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.vsl_cd.value=rtnDatas[1];
					sheetObjects[0].RemoveAll();
				}
			}
    	}
    }
	function getVvdData(obj){
    	if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					document.form.skd_voy_no.value=rtnDatas[2];
					document.form.skd_dir_cd.value=rtnDatas[3];
					sheetObjects[0].RemoveAll();
				}
			}
    	}
    }
    /**
     * if one of VVD item is inputed, three VVD items have to input
     */
    function checkVvd(formObj){
    	if( formObj.vsl_cd.value != "" 
          ||formObj.skd_voy_no.value != ""
          ||formObj.skd_dir_cd.value != "")
    	{
    		if(formObj.vsl_cd.value == "")
    		{
    			ComShowCodeMessage("PSO00031");
    			formObj.vsl_cd.focus();
    			return false;
    		}
    		else if(formObj.skd_voy_no.value == "")
    		{
    			ComShowCodeMessage("PSO00032");
    			formObj.skd_voy_no.focus();
    			return false;
    		}
    		else if(formObj.skd_dir_cd.value == "")
    		{
    			ComShowCodeMessage("PSO00033");
    			formObj.skd_dir_cd.focus();
    			return false;
    		}
    		else{
    			formObj.vvd.value=formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
    			return true;
    		}
    	}
    	return true;
    }            
    /**
     * Combo Account
     */
    function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		//Initializing combo
		sheetObjects[0].RemoveAll();
    }
	/**
	 * Combo Account
	 */
    function combo1_OnKeyDown(comboObj, KeyCode, Shift){
    	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");
    } 
	 /**
	  * CTRL H/Q onchange
	  */
    //comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode
	 function vskd_port_rhq_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var sXml=doActionIBCombo(sheetObjects[0], document.form, COMMAND03);
		var sCtrlOfc=ComGetEtcData(sXml, "ctrl_ofc_list");
		if(sCtrlOfc != null && sCtrlOfc != undefined){
			strText=("ALL|"+sCtrlOfc).split("|");	//
		}
		//CTRL Combo Setting.
		appendMultiComboItem(sls_ofc_cd, strText, strText, "", "DEF");
	}
    /**
     * setting vendor popup
     */
    function setVendorSeq(aryPopupData, row, col, sheetIdx){
    	var formObject=document.form;
    	formObject.vndr_seq.value=aryPopupData[0][2];
    	formObject.vndr_lgl_eng_nm.value=aryPopupData[0][4];
    }     

  	/**
 	 * Adding item to Mutil Combo
 	 * @param comboObj
 	 * @param optionCds
 	 * @param optionTxts
 	 * @param selCode
 	 * @return
 	 */
 	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode, sFlag){
 		comboObj.RemoveAll();
 		if(optionCdArr != null){
 			if(sFlag == "DEF"){
 				for(var i=0; i<optionCdArr.length; i++) {
 					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
 				}
 			}else{
 				for(var i=0; i<optionCdArr.length; i++) {
 					comboObj.InsertItem(i, optionDescArr[i], optionCdArr[i]);
 				}
 			}
 			comboObj.SetSelectCode(selCode,false);
 		}
 	}     
 	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
 		var prefix=sheetObj.id+"_";
 		var Row=sheetObj.MouseRow();
	    var Col=sheetObj.MouseCol();
	    var sText = "";
	    var selColName = sheetObj.CellSaveName (Row, Col);
	    sText = sheetObj.GetCellText(Row,selColName)
		if(sText != ""){
	    	sheetObj.SetToolTipText(Row,Col,sText);
	    }
 	}
 	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH){
 		var prefix=sheetObj.id + "_";
		var colName=sheetObj.ColSaveName(Col);
		var colWidth=sheetObj.GetColWidth(Col);
		
		switch(colName){
			case prefix+ "foml_desc":
			case prefix+ "xpr_desc":
				var tmpValue = sheetObj.GetCellValue(Row, Col);
				if(!ComIsEmpty(tmpValue)){
					ComShowMemoPad(sheetObj, Row, Col, true, 800, null, null,1);
				}
				break;
		}
		
		if(colName!=prefix+"acct_eng_nm" &&
				colName!=prefix+"cost_nm" &&
				colName!=prefix+"vndr_lgl_eng_nm"){
			return false;
		}
		switch(colName){
			case prefix+"acct_eng_nm":
				if(colWidth!=70){
					colWidth=70;
				}else{
					colWidth=0;
				}
				break;
			case prefix+"cost_nm":
				if(colWidth!=70){
					colWidth=70;
				}else{
					colWidth=0;
				}
				break;
			case prefix+"vndr_lgl_eng_nm":
				if(colWidth!=70){
					colWidth=70;
				}else{
					colWidth=0;
				}
				break;
		}
		sheetObj.SetColWidth(colName,colWidth);
 	}
	
	/**
	* port code CallBack event
	*/
	function portCallBack(rtnVal) {
		if(rtnVal){
			document.form.port_cd.value=rtnVal;
			loadTerminal();
			sheetObjects[0].RemoveAll();
		}
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		sheetObjects[0].SetSumRowHidden(0);
        ComOpenWait(false);
        sheetObjects[0].SetSumValue(1,"TOTAL");
	}
	

	var selComboIndex, selComboCode;
	function term_code_OnSelect(comboObj ,index, text , code) {
		selComboIndex = index;
		selComboCode = code;
	}
	function term_code_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	}
	
	function getBackEndJobStatus() {
	    //alert("UF_getBackEndJobStatus");
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	}

	function resizeSheet(){
		for (var i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	