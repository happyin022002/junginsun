/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2015.js
*@FileTitle  : Dual Type Exception Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/

	// Common Global variables
	var sheetObjects=new Array();
	var sheetCnt=0; 
	var comboObjects=new Array();
	var comboCnt=0;	
	//Defining Action
	var IBSEARCH_CUST=101;
	var IBSEARCH_CVRG=102;
	var IBSEARCH_DUAL_CUST=103;
	var IBSEARCH_CNTRCGO=104;
	var IBSEARCH_TYPE=105;
	var IBSEARCH_DUAL_CVRG=106;
	var IBSEARCH_DEL_CUST=107;
	var IBSEARCH_APPLIED=108;
	//Defining data unit separator
	var ROWMARK="|";
	var FIELDMARK="=";
	var DEL_CHK="del_chk";	
	var STATUS="dul_expt_delt_desc";
	var CUST_CD="cust_cd";
	var CUST_NM="cust_nm";
	var TYPE="dmdt_ctrt_expt_tp_cd";
	var EFF_DT="dul_expt_eff_dt";
	var EXP_DT="dul_expt_exp_dt";
	var BOUND="io_bnd_cd";
	var CVRG_CNT="cvrg_cnt_cd";
	var CVRG_RGN="cvrg_rgn_ste_cd";
	var CVRG_LOC="cvrg_loc_cd";
	var CNTRCGO="dmdt_cntr_cgo_tp_cd";
	var REMARK="dul_expt_rmk";
	var UPD_OFC="upd_ofc_cd";
	var UPD_USR_NM="upd_usr_nm";
	var UPD_DT="upd_dt";
	var EXP_DT="exp_dt";
	var SC_NO="sc_no";
	var RFA_NO="rfa_no";
	var PROP_NO="prop_no";
	var DAR_NO="dar_no";
	var VER_NO="ver";
	var VER_STATUS="status";
	var APVL_NO="apvl_no";
	var CNT_CD="cnt_Cd";
	var RGN_CD="rgn_Cd"
	var LOC_CD="loc_cd";
	var LOC_TP="loc_tp";
	var CUST_SEQ="cust_expt_seq";
	//Type (SC, Before) according to the CNTR / Cargo Type must appear differently.
	//At page load, Type according to the CNTR / Cargo Type by looking up, to be saved in global variables, Type change to process that information intended to show
	var sCCNTRCargoType="";
	var rfaCNTRCargoType="";	
  	//Sort when the selected Row in order to maintain the selection state of the variables used
	var currCustCd="";
	var currCustSeq="";
	var DEF_SHEET_HEIGHT = 234;
	var SUB_SHEET_HEIGHT = 152;	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
	     var sheetObject1=sheetObjects[0];
  	     var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObj=document.form;
    	try {
     		var srcObj=ComGetEvent();
     		var srcName=srcObj.getAttribute("name");;
            switch(srcName) {
	         	case "btns_calendar": //Calendar button
	     			var cal=new ComCalendarFromTo();
	                cal.select(formObj.effFmDt, formObj.effToDt, 'yyyy-MM-dd');
					break;
				case "btn_DownExcel":
					if (ComIsBtnEnable("btn_DownExcel")) 
						doActionDownExcel(sheetObject1);
					break;
				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionRetrieve();
					break;
				case "btn_Detail":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionDetail();
					break;
				case "btn_New":
					if (ComIsBtnEnable("btn_New")) 
						doActionNew();
					break;
				case "btn_MainDownExcel":
					if (ComIsBtnEnable("btn_MaindDownExcel"))
						doActionDownExcel(sheetObject2);
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
   	 * IBCombo Object set to an array
   	 * param : combo_obj 
   	 * adding process for list in case of needing batch processing with other items
   	 * defining list on the top of source
   	 */ 
   	function setComboObject(combo_obj) {  
   		comboObjects[comboCnt++]=combo_obj;  
   	}     
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
		var formObj=document.form;
        for (var i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
	 	//1.IBMultiCombo initializing 
	    for (var k=0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
		//2.initializing html control event
		initControl();
		//3.Load on the screen, deactivating makes initializing The controls to be.
		initDisableObjects();
		//4.initializing the status of the button
		initBtnControl();
		//5.IBSheet변경에 따른 호출
		sheet1_OnLoadFinish();
    }
  	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
  //no support[check again]CLT 	
    function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		var sheetObj=sheetObjects[0];
  		//Dual Type Exception registered in the Customer's information search
  		doActionIBCommon(sheetObj,formObj,IBSEARCH_CUST,SEARCH01);
		//Type Inquiry and then retrieved in the result set combo
		doActionIBCommon(sheetObj,formObj,IBSEARCH_TYPE,SEARCH15,TYPE);
		//Country Inquiry, then retrieved in the result set combo
		//Coverage applies in the field of the cnt_cd
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH02,CVRG_CNT);		
  	}
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    //no support[check again]CLT 	
    	sheetObj.ToolTipOption="balloon:true;width:50;";
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
		            	SetColProperty(TYPE, {ComboText:"", ComboCode:""} );
		            	SetColProperty(BOUND, {ComboText:"|Inbound|Outbound", ComboCode:"|I|O"} );
		            	SetColProperty(CVRG_CNT, {ComboText:"", ComboCode:""} );
		            	SetColProperty(CVRG_RGN, {ComboText:"", ComboCode:""} );
		            	SetColProperty(CNTRCGO, {ComboText:"", ComboCode:""} );
            	        
            	      //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            	      var HeadTitle1="|Seq.||Status|Customer|Customer|Type|EFF DT|EXP DT|Bound|Coverage|Coverage|Coverage|CNTR/Cargo Type|Remark|Update|Update|Update";
            	      var HeadTitle2="|Seq.||Status|Code|Name|Type|EFF DT|EXP DT|Bound|CN|RGN|LOC|CNTR/Cargo Type|Remark|Office|Name|Date";
            	      var headCount=ComCountHeadTitle(HeadTitle2) + 1;
            	      (headCount, 0, 0, true);

            	      //SetConfig( { SearchMode:2, FrozenCol:savenamecol(type), MergeSheet:5, Page:20, DataRowMerge:1 } );
            	      SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle1, Align:"Center"},
            	                  { Text:HeadTitle2, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
            	             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:DEL_CHK,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:STATUS,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:TYPE,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:BOUND,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_RGN,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:CVRG_LOC,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:CNTRCGO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:REMARK,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:UPD_OFC,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:UPD_USR_NM,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:UPD_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:CUST_SEQ,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	       
            	      InitColumns(cols);

            	      SetEditable(1);
            	      SetSheetHeight(DEF_SHEET_HEIGHT);
            	      
  	                  SetColProperty(TYPE, {ComboText:"", ComboCode:""} );
	                  SetColProperty(BOUND, {ComboText:"|Inbound|Outbound", ComboCode:"|I|O"} );
	                  SetColProperty(CVRG_CNT, {ComboText:"", ComboCode:""} );
	                  SetColProperty(CVRG_RGN, {ComboText:"", ComboCode:""} );
	                  SetColProperty(CNTRCGO, {ComboText:"", ComboCode:""} );
            	}
            break;
               
            case 2:      // sheet1 init
                with(sheetObj){
	            	SetColProperty(BOUND, {ComboText:"|Inbound|Outbound", ComboCode:"|I|O"} );
	            	SetColProperty(CNTRCGO, {ComboText:"", ComboCode:""} );
            	        
            	      //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            	      var HeadTitle1="Seq.|S/C No.|RFA No.|Prop No.|DAR No.|Ver.|Approval No|Status|EFF DT|EXP DT|Bound|Coverage|Coverage|Coverage|CNTR/Cargo Type|Local Type";
            	      var HeadTitle2="Seq.|S/C No.|RFA No.|Prop No.|DAR No.|Ver.|Approval No|Status|EFF DT|EXP DT|Bound|CN|RGN|LOC|CNTR/Cargo Type|Local Type";
            	      var headCount=ComCountHeadTitle(HeadTitle2);

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle1, Align:"Center"},
            	                  { Text:HeadTitle2, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:SC_NO,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:RFA_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:PROP_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:DAR_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:VER_NO,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:APVL_NO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:VER_STATUS,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:BOUND,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:CNT_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:RGN_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:LOC_CD,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Combo",     Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:CNTRCGO,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:LOC_TP,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	       
            	      InitColumns(cols);
            	      SetEditable(1);
            	      SetSheetHeight(SUB_SHEET_HEIGHT);

	                  SetColProperty(BOUND, {ComboText:"|Inbound|Outbound", ComboCode:"|I|O"} );
	                  SetColProperty(CNTRCGO, {ComboText:"", ComboCode:""} );					
            	}
            break;
        }
    }
   	/**
	 * Initializing Combo 
	 * param : comboObj , comboNo
	 *  adding case as numbers of counting Combos
	 */ 
	function initCombo(comboObj, comboNo) {
	    var formObj=document.form
	    var sheetObj=sheetObjects[0];
	    switch(comboNo) {
	    	//Search Registered on the screen Customer
	    	case 1:
	    		with(comboObj) {
					SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "90");
					SetColWidth(1, "300");
					SetEnable(1);
					SetDropHeight(160);
					ValidChar(2, 1);	// using the English uppercase letters, numbers
					SetMaxLength(8);
	    		}
	    		break;
	     } 
	}
  	function initControl() {
		//axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- out of focus  		
		//axon_event.addListenerFormat('focus',	'obj_focus',	document.form); // Get focus  	
		//axon_event.addListener('keydown', 		'ComKeyEnter', 	'form');
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
    // out of focus
     function obj_blur(){
         //check inputing Validation + Inserting separator 
    	 var obj=ComGetEvent();
    	 if(obj.name == 'svc_provdr' || obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
    	 } else if(obj.name == 'yd_cd' || obj.name == 'tmnl_cd') {
    		 if(obj.value.length > 0 && obj.value.length < 5) {
    			var cdDiv=(obj.name == 'yd_cd') ? 'Yard' : 'Location';
	 			ComShowCodeMessage('DMT00110', cdDiv);
	 		 }
    	 } else {
    		 ComChkObjValid(obj);
    	 }
     }
	function initDisableObjects() {
		var formObj=document.form;
		with(formObj) {
			ComEnableManyObjects(false, custNm);
			custNm.className="input2";
		}		
	}	 
	/**
	 * Screen loading initializing the status of the button
	 */
    function initBtnControl() {
		//Dual Type Exception Button
		ComBtnDisable("btn_Detail");			//Detail button
        ComBtnDisable("btn_DownExcel");			//Down Excel button
        //Dual Type Exception Applied Data's Button
	    ComBtnEnable("btn_Retrieve");			//Retrieve button
		ComBtnEnable("btn_New");				//New button
		ComBtnDisable("btn_MainDownExcel");		//Down Excel button
	}
	// Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	//Dual Type Exception 
			case IBSEARCH:
				if (validateForm(sheetObj,formObj,sAction)) {
					//1.Setting parametor condition, before retrieving
					var cboCustomerObj=comboObjects[0];
					var custCd=ComTrim(cboCustomerObj.GetSelectText());
					if (custCd.length > 2) {
						var custCnt=custCd.substring(0,2);
						var custSeq=custCd.substring(2);
						ComSetObjValue(formObj.cust_cnt_cd, custCnt);
						ComSetObjValue(formObj.cust_seq, 	custSeq);
						switch(custSeq.length) {
							case 1: custSeq="00000" 	+ custSeq;
								break;
							case 2: custSeq="0000" 	+ custSeq;
								break;
							case 3: custSeq="000" 	+ custSeq;
								break;
							case 4: custSeq="00" 		+ custSeq;
								break;
							case 5: custSeq="0" 		+ custSeq;
								break;
						}
						custCd=custCnt + custSeq;
						cboCustomerObj.SetSelectText(custCd);
					} 
					else {
						ComSetObjValue(formObj.cust_cnt_cd, "");
						ComSetObjValue(formObj.cust_seq, 	"");		
					}
					ComSetObjValue(formObj.dul_expt_eff_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effFmDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_exp_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effToDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_delt_flg, 	ComGetObjValue(formObj.status));
					ComSetObjValue(formObj.intg_cd_id, 			"CD01969");
					ComSetObjValue(formObj.f_cmd, 				SEARCH);
					//2.Inquiry ago, the result makes Empty fields.
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					//3.retrievie according to conditions
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
					//sheetObj.DoSearch("EES_DMT_2015GS.do", FormQueryString(formObj) );
					var sXml = sheetObj.GetSearchData("EES_DMT_2015GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml);
		            //*********************************************************************************
		            ComOpenWait(false);
		            //*********************************************************************************
		            
	            	ComBtnEnable("btn_Detail");		//Detail button
	        		ComBtnEnable("btn_DownExcel");	//Down Excel button
	        		
//		            //4.Data exists 
//		            if (sheetObj.RowCount()> 0) {
//		            	//4-1.status of the button : activating 
//		            	ComBtnEnable("btn_Detail");		//Detail button
//		        		ComBtnEnable("btn_DownExcel");	//Down Excel button
//		            }
//		            //5.Data does not exist
//		            else {
//		            	//5-1.status of the button : deactivating
//		            	ComBtnDisable("btn_Detail");			//Detail button
//		            	ComBtnDisable("btn_DownExcel");			//Down Excel button
//		            	ComBtnDisable("btn_MainDownExcel");		//Down Excel button
//		            }
				}
			break;
				
        	//Dual Type Exception Applied 
			case IBSEARCH_APPLIED:
				//1.Setting parametor condition, before retrieving
				var sheetObj1=sheetObjects[0];
				with(sheetObj1) {
					ComSetObjValue(formObj.intg_cd_id, 				"CD01969");
					ComSetObjValue(formObj.cust_cd, 				GetCellValue(GetSelectRow(), CUST_CD));
					ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, 	GetCellValue(GetSelectRow(), TYPE));
					ComSetObjValue(formObj.eff_dt, 					GetCellValue(GetSelectRow(), EFF_DT));
					ComSetObjValue(formObj.exp_dt, 					GetCellValue(GetSelectRow(), EXP_DT));
					ComSetObjValue(formObj.io_bnd_cd, 				GetCellValue(GetSelectRow(), BOUND));
					ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, 	GetCellValue(GetSelectRow(), CNTRCGO));
					//SET COVERAGE
					var cntCd=ComTrim(GetCellValue(GetSelectRow(), CVRG_CNT));
					ComSetObjValue(formObj.cnt_cd, cntCd);
					if (cntCd == "CA" || cntCd == "US") {
						ComSetObjValue(formObj.ste_cd, ComTrim(GetCellValue(GetSelectRow(), CVRG_RGN)));
						ComSetObjValue(formObj.rgn_cd, ""); 
					}
					else {
						ComSetObjValue(formObj.rgn_cd, ComTrim(GetCellValue(GetSelectRow(), CVRG_RGN)));
						ComSetObjValue(formObj.ste_cd, "");
					}
					ComSetObjValue(formObj.loc_cd, ComTrim(GetCellValue(GetSelectRow(), CVRG_LOC)));
					//END
				}
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				//2.Inquiry ago, the result makes Empty fields.
				sheetObj.RemoveAll();
				//3.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 				
				var sXml=sheetObj.GetSearchData("EES_DMT_2015GS.do", FormQueryString(formObj));
				if (sXml.length > 0 && ComGetTotalRows(sXml) > 0) sheetObj.LoadSearchData(sXml,{Sync:1} );
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				
	            //4.Data exists 
	            if (sheetObj.RowCount()> 0) {
	            	//4-1.status of the button : activating 
	            	ComBtnEnable("btn_MainDownExcel");		//Main Down Excel button
	            }
	            //5.Data does not exist
	            else {
	            	//5-1.status of the button : deactivating
	            	ComBtnDisable("btn_MainDownExcel");		//Main Down Excel button
	            }				
			break;
        }
    }
	// Retrieving conditions field: Country, Region Combo Data Inquiry
    function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboField) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    switch(sAction) {
	       //Search Customer, that Dual Type Exception registered 
	    	case IBSEARCH_CUST:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 				
				var sXml=sheetObj.GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var comboObj=comboObjects[0];
				var comboItems=ComGetEtcData(sXml, "CUSTCODE").split(ROWMARK);
				addComboItem(comboObj,comboItems);
            break;
               
            //Search S/C, RFA CNTR/Cargo Type
	    	case IBSEARCH_CNTRCGO:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD01969");
   	 			//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 	    	    
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
	    	    if (sComboAction == SEARCH11) {
	    	    	rfaCNTRCargoType=ComGetEtcData(sXml, "CONTR_CGO");
	    	    	rfaCNTRCargoType=rfaCNTRCargoType.replace("All=All^All|", "");
	    	    }
	    	    else if (sComboAction == SEARCH15) {
	    	    	sCCNTRCargoType=ComGetEtcData(sXml, "COMMON_CD");
	    	    } 
	    	break;
	    	
    	    //Search Type(S/C, Before)
	    	case IBSEARCH_TYPE:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD01970");
   	 			//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 	    	    
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var comboDatas=ComGetEtcData(sXml, "COMMON_CD");
				if (comboDatas != undefined) {
					addCellComboItem(sheetObj,comboDatas,sComboField,false,true);
				}
			break;
			
	    	case IBSEARCH_CVRG:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
   	 			//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 	    	    
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var comboDatas;
				var comboItems;
				var comboItem;
				switch(sComboAction) {
					//3-1.Search Region (All Region List)
					case SEARCH01:
						comboDatas=ComGetEtcData(sXml, "RGN");
						addCellComboItem(sheetObj,comboDatas,sComboField,false);
						break;
					//3-2.Search Country (All Country List)
					case SEARCH02:
						comboDatas=ComGetEtcData(sXml, "CNT");
						addCellComboItem(sheetObj,comboDatas,sComboField,false);
						break;
				}
		}	    	    
	    sheetObj.SetWaitImageVisible(1);
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
    *  Grid Data in the field adds a combo.
    */		
	function addCellComboItem(sheetObj, comboDatas, sComboKey, isCellCombo, isOnlyTextView) {
		var sRow=sheetObj.GetSelectRow();
		var comboTxt="";
		var comboVal="";
		var comboItems;
		var comboItem;
		var comboInitTxt="";
		var comboInitVal="";
		if (comboDatas != undefined && ComTrim(comboDatas).length > 0) {
			comboItems=comboDatas.split(ROWMARK);
			for (var i=0 ; i < comboItems.length ; i++) {
				comboItem=comboItems[i].split(FIELDMARK);
				//When InitDataCombo method call, if you do not select a value
				//Code, Value appears in the combo letter seeks to avoid being pushed.
				if (!isCellCombo && i == 0) {
					comboInitTxt=comboItem[0];
					comboInitVal=comboItem[0];
				}
				if (ComTrim(comboItem[0]) != "") {
					//in case of showing only Text
					if (isOnlyTextView) {
						comboTxt += comboItem[1];
					}
					//in case of getting Text with '^' as delimiter
					else if (comboItem[1].indexOf("\^") != -1) {
						comboTxt += comboItem[1].replace("^", " - ");
					}
					//in case of showing both Text and Code
					else {
						comboTxt += comboItem[0] + "\t" + comboItem[1];
					}
					comboVal += comboItem[0];
				}
				else {
					comboTxt += " \t ";
					comboVal += " ";
				}
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
		else {
			comboTxt += " \t ";
			comboVal += " ";			
		}
		var colName=sComboKey;
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName, {ComboText:comboTxt, ComboCode:comboVal} );
			sheetObj.SetCellValue(sRow,colName,"",0);
		}
		else {
			sheetObj.SetColProperty(colName, {ComboText:comboTxt, ComboCode:comboVal} );
		}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
     	// case in searching, check required fields
     	if (sAction == IBSEARCH) {
     		var effFmDt=ComTrim(ComGetObjValue(formObj.effFmDt));
     		var effToDt=ComTrim(ComGetObjValue(formObj.effToDt));
     		if (effFmDt == "" && effToDt != "") {
     			ComShowCodeMessage("DMT03028", "Effective Date");
     			ComSetFocus(formObj.effFmDt);
     			return false;
     		}
     		else if (effFmDt != "" && effToDt == "") {
     			ComShowCodeMessage("DMT03028", "Effective Date");
     			ComSetFocus(formObj.effToDt);	
     			return false;
     		}
     		else if (effFmDt != "" && effToDt != "" && ComGetDaysBetween(effToDt, effFmDt) > 0) {
    			ComShowCodeMessage("COM12133", "'Effective To Date'", "'Effective From Date'", "earlier");
    			ComSetFocus(formObj.effFmDt);
    			return false;	    			
    		}     		
     	}
     	return true;
    }
   /**
 	* Align the current selection state of ROW has been chosen to handle it functions to maintain
 	*/	
 	function sheet1_OnSort(sheetObj, Col, SortArrow) {
 		with(sheetObj) {
 			for (var row=HeaderRows(); row <= LastRow(); row++) {
if (currCustCd == GetCellValue(row, CUST_CD) && currCustSeq == GetCellValue(row, CUST_SEQ)) {
 					SetSelectRow(row);
 					break;
 				}
 			}
 		}
 	}     
    /**
 	 *Row when it is selected, conditions will change the status of the Row.
 	 */	
 	function sheet1_OnSelectCell(sheetObj,OldRow,OldCol,NewRow,NewCol) {
 		var formObj=document.form;
 		var sheetObj2=sheetObjects[1];
 		//Row selected whenever there is a change in position to perform the following logic.
 		if (OldRow >= sheetObj.HeaderRows()&& OldRow != NewRow) {
 			sheetObj2.RemoveAll();
			//--------------------------------------------------------------
 			currCustCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), CUST_CD);
 			currCustSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), CUST_SEQ);
			//--------------------------------------------------------------
 		}
    }
   /**
    * If you double-click on the selected Row, the Dual Type Exception Applied to query.
    */	
    function sheet1_OnDblClick(sheetObj,Row,Col) {
    	doActionDetail();
    }
 	/**
 	 * BOUND field has been chosen according to the value in, Coverage CN field when MouseOver show tooltips.
 	 */	
 	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
 		with(sheetObj) {
 			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
 				var colName = ColSaveName(MouseCol());
 				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
 					// IF Bound = 'O' , balloon message 'BKG POR'
 					// IF Bound = 'I' ,  balloon message 'BKG DEL'
 					switch(GetCellValue(MouseRow(), BOUND)) {
						case "O": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						case "I": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
						default : SetToolTipText(MouseRow(), MouseCol(), "");
 					}
 				}
 				else if (colName == REMARK) {
 					SetToolTipText(MouseRow(), MouseCol(), GetCellValue(MouseRow(), REMARK));
 				}
 				else {
 					SetToolTipText(MouseRow(), MouseCol(), "");
 				}				
 			}
 			else {
 				SetToolTipText(MouseRow(), MouseCol(), "");
 			}			
 		}
 	}
 	/**
 	 * If the Effective From Date subject to change, To Date will be set automatically, +1 year.
 	 */	
 	function setEffectiveToDate() {
  		var formObj=document.form;
  		var effFmDt=ComTrim(ComGetObjValue(formObj.effFmDt));
  		var effToDt="";
  		if (ComIsDate(effFmDt)) {
  			effToDt=ComGetDateAdd(effFmDt, "Y", 1);
  			effToDt=ComGetDateAdd(effToDt, "D", -1);
  			ComSetObjValue(formObj.effToDt, effToDt);
  		}
 	}
	/**
	 * If you change the Customer Name Customer Code that allows to automatically input.
	 */	
	function combo1_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
	 	var formObj=document.form;
	 	if (NewTxt == "") {
	 		ComClearObject(formObj.custNm);
	 	}
	 	else if (Text.length != 8) {
	 		comboObj.SetSelectText(fetchLeftPadding(NewTxt));
	 	}
	 	ComSetObjValue(formObj.custNm, comboObj.GetSelectCode());
	}
   /**
	* When you click Retrieve button, the function that defines the operation to be executed
	* Dual Type Exception Information to query the Action
	*/	 
    function doActionRetrieve() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var cboCustomerObj=comboObjects[0];
		if (validateForm(sheetObj, formObj, IBSEARCH)) {
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			//--------------------------------------------------------------
			currCustCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), CUST_CD);
			currCustSeq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), CUST_SEQ);
			//--------------------------------------------------------------
		}
    }
   /**
	* Detail button when clicked, a function that defines the operation to be executed
	* Dual Type Exception Applied Action to retrieve information
	*/	 
    function doActionDetail() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	with(sheetObj) {
    		if (GetCellValue(GetSelectRow(), STATUS) == "Deleted") {
	    		ComShowCodeMessage("DMT00179");
	    		return
	    	}
	    	// When Inquiry, S / C, RFA show or hide depending on the processing is performed on the field.
    		showColumnsByType(GetCellValue(GetSelectRow(), TYPE));
    	}
		//Dual Type Exception Applied 
    	doActionIBSheet(sheetObjects[1],formObj,IBSEARCH_APPLIED);
    }
   /**
	* Click the New button on, the function that defines the operation to be executed
	*/	 
    function doActionNew() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var cboCustomerObj=comboObjects[0];
		with(formObj) {
			ComEnableManyObjects(true, effFmDt, effToDt, status);
			effFmDt.className="input";
			effToDt.className="input";
			status.className="input";
			ComClearObject(effFmDt);
			ComClearObject(effToDt);
			ComClearObject(custNm);
			ComSetObjValue(status, "");
		}	    	
		cboCustomerObj.SetEnable(1);
		cboCustomerObj.SetSelectText("");
		
		sheetObj.RemoveAll();
    }	 
   /**
	*  Click the  Down Excel button , the function that defines the operation to be executed
	*/	 
    function doActionDownExcel(sheetObj) {
//method change[check again]CLT 		
    	sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(		sheetObj), SheetDesign:1,Merge:1 });
    }
   /**
	* When Inquiry, S / C, RFA showing the column to vary, depending on the function being able to handle
	*/	
	function showColumnsByType(searchType) {
		var sheetObj2=sheetObjects[1];
		with(sheetObj2) {
			//1.S/C 
			if (searchType == "S") {
				SetColHidden(SC_NO,0);
				SetColHidden(RFA_NO,1);
				SetColHidden(DAR_NO,1);
				SetColHidden(APVL_NO,1);
			}
			//2.Before Booking
			else if (searchType == "B") {
				SetColHidden(SC_NO,1);
				SetColHidden(RFA_NO,0);
				SetColHidden(DAR_NO,0);
				SetColHidden(APVL_NO,0);
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
