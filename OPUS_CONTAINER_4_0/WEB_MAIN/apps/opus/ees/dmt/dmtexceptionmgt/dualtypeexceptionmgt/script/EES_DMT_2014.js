/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_2014.js
*@FileTitle  : Dual Type Exception Creation
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
	var IBSEARCH_CUSTNM=108;
	var IBSEARCH_CHECK_EXPDT=109;
	var IBSEARCH_CHECK_DUP=110;
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
	var DELT_FLG="dul_expt_delt_flg";
	var CUST_CNT_CD="cust_cnt_cd";
	var CUST_SEQ="cust_seq";
	var CUST_EXPT_SEQ="cust_expt_seq";
	var EXP_FLG="exp_flg";
	//When Retrieving Location, Location intended to prevent information from being erased
	var isClearLocation=true;
	//OnChange event that occurred is not made ??on the Screen, 
	//In other words, Retrieving the data, each combo when setting the field, whether generated variables that distinguish.(Enabled in order to prevent unintended actions)
	//Variable settings are made in the Location field.
	var isValueSettingEvent=false;
	//Type (SC, Before) according to the CNTR / Cargo Type must appear differently.
	//At page load, Type according to the CNTR / Cargo Type by looking up, to be saved in global variables, Type change to process that information intended to show
	var sCCNTRCargoType="";
	var rfaCNTRCargoType="";
	var DEF_SHEET_HEIGHT = 424;
	
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
		/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
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
				case "btn_AddDualType":
					if (ComIsBtnEnable("btn_AddDualType")) 
						doActionAddDualType();
					break;
				case "btn_CopyDualType":
					if (ComIsBtnEnable("btn_CopyDualType")) 
						doActionCopyDualType();
					break;
				case "btn_DelDualType":
					if (ComIsBtnEnable("btn_DelDualType"))
						doActionDelDualType();
					break;
				case "btn_ExpireDualType":
					if (ComIsBtnEnable("btn_ExpireDualType"))
						doActionExpireDualType();
					break;
				case "btn_DownExcel":
					if (ComIsBtnEnable("btn_DownExcel"))
						doActionDownExcel();
					break;
				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionRetrieve();
					break;
				case "btn_New":
					if (ComIsBtnEnable("btn_New")) 
						doActionNew();
					break;
				case "btn_Save":
					if (ComIsBtnEnable("btn_Save"))
						doActionSave();
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
        for (i=0 ; i < sheetObjects.length ; i++) {
            ComConfigSheet (sheetObjects[i] );
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
		sheet1_OnLoadFinish();
		//doActionIBCommon(sheetObjects[0],formObj,IBSEARCH_CUST,SEARCH01);
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
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH02,CVRG_CNT,false);
		//Region Inquiry, then retrieved in the result set combo
	 	//Coverage applies in the field of the Region
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH01,CVRG_RGN,false);
   		//S / C CNTR / CGO Inquiry, then stored in global variables
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CNTRCGO,SEARCH15,CNTRCGO);
   		//RFA(Before Booking Request) CNTR/CGO  Inquiry, then stored in global variables
		doActionIBCommon(sheetObj,formObj,IBSEARCH_CNTRCGO,SEARCH11,CNTRCGO); 		
 	}
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                
	                var HeadTitle1="||Seq.|Status|Customer|Customer|Type|EFF DT|EXP DT|Bound|Coverage|Coverage|Coverage|CNTR/Cargo Type|Remark|Update|Update|Update";
	                var HeadTitle2="||Seq.|Status|Code|Name|Type|EFF DT|EXP DT|Bound|CN|RGN|LOC|CNTR/Cargo Type|Remark|Office|Name|Date";
	                var headCount=ComCountHeadTitle(HeadTitle2) + 5;
	                //(headCount, 0, 0, true);
	
	                //SetConfig( { SearchMode:2, FrozenCol:savenamecol(type), MergeSheet:5, Page:20, DataRowMerge:1 } );
	                SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                       {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:DEL_CHK,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:STATUS,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:CUST_CD,          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
	                       {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:CUST_NM,          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:TYPE,             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Date",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:EFF_DT,           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Date",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:EXP_DT,           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:BOUND,            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_CNT,         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2, AcceptKeys:"E", InputCaseSensitive:1 },
	                       {Type:"ComboEdit", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:CVRG_RGN,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3, AcceptKeys:"E", InputCaseSensitive:1 },
	                       {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:CVRG_LOC,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5, AcceptKeys:"E|N", InputCaseSensitive:1 },
	                       {Type:"Combo",     Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:CNTRCGO,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:1,   SaveName:REMARK,           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:200 },
	                       {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:UPD_OFC,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:UPD_USR_NM,       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:UPD_DT,           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CUST_EXPT_SEQ,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:EXP_FLG,          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:DELT_FLG,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CUST_CNT_CD,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:CUST_SEQ,         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetColProperty(TYPE, {ComboText:"", ComboCode:""} );
	                SetColProperty(BOUND, {ComboText:"|Inbound|Outbound", ComboCode:"|I|O"} );
	                SetColProperty(CVRG_CNT, {ComboText:"", ComboCode:""} );
	                SetColProperty(CVRG_RGN, {ComboText:"", ComboCode:""} );
	                SetColProperty(CNTRCGO, {ComboText:"", ComboCode:""} );
	                SetShowButtonImage(2);
	                SetSheetHeight(DEF_SHEET_HEIGHT);
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
   					//SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "90");
					SetColWidth(1, "300");
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
	 * in loading Screen,  initializing the status of the button
	 */
	function initBtnControl() {
		ComBtnEnable("btn_AddDualType");		//Row Add button
		ComBtnDisable("btn_CopyDualType");		//Row Copy button
		ComBtnDisable("btn_DelDualType");		//Delete button
		ComBtnDisable("btn_ExpireDualType");	//Expire button
		ComBtnEnable("btn_Retrieve");			//Retrieve button
		ComBtnEnable("btn_New");				//New button
		ComBtnEnable("btn_Save");				//Save button
		ComBtnDisable("btn_DownExcel");			//Down Excel button
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
						ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0,2));
						ComSetObjValue(formObj.cust_seq, custCd.substring(2));
						cboCustomerObj.SetSelectText(fetchLeftPadding(custCd));
					} 
					else {
						ComSetObjValue(formObj.cust_cnt_cd, "");
						ComSetObjValue(formObj.cust_seq, "");		
					}
					ComSetObjValue(formObj.dul_expt_eff_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effFmDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_exp_dt, 	ComGetUnMaskedValue(ComGetObjValue(formObj.effToDt), "ymd"));
					ComSetObjValue(formObj.dul_expt_delt_flg, 	ComGetObjValue(formObj.status));
					ComSetObjValue(formObj.f_cmd, SEARCH);
					//2.Inquiry ago, the result makes Empty fields.
					sheetObj.RemoveAll();
					//3.retrievie according to conditions
					//*********************************************************************************
					ComOpenWait(true);
					sheetObj.SetWaitImageVisible(0);
					//*********************************************************************************
  
					var sXml=sheetObj.GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj) );
					sheetObj.LoadSearchData(sXml,{Sync:1} );
		            //*********************************************************************************
		            ComOpenWait(false);
		            //*********************************************************************************
		            //4.Data exists 
		            if (sheetObj.RowCount()> 0) {
		            	//4-1.Setting staus of button
		        		ComBtnEnable("btn_CopyDualType");		//Row Copy button
		        		ComBtnEnable("btn_DelDualType");		//Delete button
		        		ComBtnEnable("btn_DownExcel");			//Down Excel button		
		        		ComBtnEnable("btn_ExpireDualType");		//Expire button
		            }
		            //5.Data does not exist
		            else {
		            	//5-1. in  loading Screen , button's staus initialized
		            	initBtnControl();
		            }
				}
			break;
			
			//Customer has selected S / C, Before Booking Customer should check whether.
			case IBSEARCH_DUAL_CUST:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, SEARCH02);
				var custCd=sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(), CUST_CD);
				ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
				ComSetObjValue(formObj.cust_seq, custCd.substring(2));
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObjects[0].GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj));
	            //*********************************************************************************
	            ComOpenWait(false);
	            //*********************************************************************************
				//3.After handling Retrieving results
				var isSCCustomer=ComGetEtcData(sXml, "SC_CUST");
				var isBFCustomer=ComGetEtcData(sXml, "BF_CUST");

				if (isSCCustomer == "Y" && isBFCustomer == "Y") {
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), TYPE, "");
					sheetObj.SetCellEditable(sheetObj.GetSelectRow(), TYPE, 1);
				}
				if (isSCCustomer == "Y" && isBFCustomer == "N") {
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), TYPE, "S");
					sheetObj.SetCellEditable(sheetObj.GetSelectRow(), TYPE, 0);
				}
				if (isSCCustomer == "N" && isBFCustomer == "Y") {
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), TYPE, "B");
					sheetObj.SetCellEditable(sheetObj.GetSelectRow(), TYPE, 0);
				}				
				if (isSCCustomer == "N" && isBFCustomer == "N") {
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), TYPE, "");
					sheetObj.SetCellEditable(sheetObj.GetSelectRow(), TYPE, 0);
				}				
			break;
			
			//Check Coverage ( Dual Coverage )
			case IBSEARCH_DUAL_CVRG:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, SEARCH03);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj));
	            //*********************************************************************************
	            ComOpenWait(false);
	            //*********************************************************************************
				//3.After handling Retrieving results
				var isDualCoverage=ComGetEtcData(sXml, "IS_DUALCVRG");
				ComSetObjValue(formObj.result, "");
				ComSetObjValue(formObj.result, isDualCoverage);
			break;
			
			//Select Dual Type Customer to check whether the information can be deleted.
			case IBSEARCH_DEL_CUST:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, SEARCH04);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObjects[0].GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj));
	            //*********************************************************************************
	            ComOpenWait(false);
	            //*********************************************************************************
				//3.After handling Retrieving results
				var result=ComGetEtcData(sXml, "DEL_CUST");
				ComSetObjValue(formObj.result, result);
				if (result != "Y") {
					ComSetObjValue(formObj.result_sc_no, ComGetEtcData(sXml, "SC_NO"));
					ComSetObjValue(formObj.result_dar_no, ComGetEtcData(sXml, "DAR_NO"));
				}
				else {
					ComSetObjValue(formObj.result_sc_no, "");
					ComSetObjValue(formObj.result_dar_no, "");
				}
			break;
			
			//Check EXP DT .(if it is small then S/C, Before Booking Expire Date , then error)
			case IBSEARCH_CHECK_EXPDT:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, SEARCH05);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObjects[0].GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var result=ComGetEtcData(sXml, "RESULT");
				ComSetObjValue(formObj.result, result);
				if (result != "Y") {
					ComSetObjValue(formObj.result_sc_no, ComGetEtcData(sXml, "SC_NO"));
					ComSetObjValue(formObj.result_dar_no, ComGetEtcData(sXml, "DAR_NO"));
				}
				else {
					ComSetObjValue(formObj.result_sc_no, "");
					ComSetObjValue(formObj.result_dar_no, "");
				}				
			break;
			
			//Check duplication: DUAL TYPE EXCEPTION  DB 
			case IBSEARCH_CHECK_DUP:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, SEARCH06);
				//2.retrievie according to conditions
				//*********************************************************************************
				ComOpenWait(true);
				sheetObjects[0].SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObjects[0].GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj));
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var result=ComGetEtcData(sXml, "RESULT");
				ComSetObjValue(formObj.result, result);
				if (result == "Y") {
					ComSetObjValue(formObj.result_dul_expt_eff_dt, ComGetEtcData(sXml, "DUL_EXPT_EFF_DT"));
					ComSetObjValue(formObj.result_dul_expt_exp_dt, ComGetEtcData(sXml, "DUL_EXPT_EXP_DT"));
				}
				else {
					ComSetObjValue(formObj.result_dul_expt_eff_dt, "");
					ComSetObjValue(formObj.result_dul_expt_exp_dt, "");					
				}
			break;
			
			case IBSAVE:
				ComSetObjValue(formObj.f_cmd, MULTI);
				var sParam="";
				var sParam1=sheetObjects[0].GetSaveString();
				if (sheetObj.IsDataModified()== true) {
					sParam=sParam1 + "&";
				}
				sParam += "&" + FormQueryString(formObj);				
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
				var sXml=sheetObj.GetSaveData("EES_DMT_2014GS.do", sParam);
                sheetObj.LoadSearchData(sXml,{Sync:1} );
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				//3.Save and processing results
				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
					ComSetObjValue(formObj.result, "Y");
				}
				else {
					ComSetObjValue(formObj.result, "N");
				}
			break;
        }
    }
    /**
     * To query, the parameters required to establishing the function
     */	
	function setCommonParameters(sheetObj,sComboAction) {
    	var formObj=document.form;
    	//Action need to run a set of parameters that define
		ComSetObjValue(formObj.f_cmd, sComboAction);
		switch(sComboAction) {
			//Search all Region
			case SEARCH01 :
				break;
			//Search all Country
			case SEARCH02 :
				break;
			// Search  Region of Country
			case SEARCH03:
				ComSetObjValue(formObj.cnt_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_CNT));
				break;
			// Search  Country, Region include Location
			case SEARCH04:
				ComSetObjValue(formObj.loc_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_LOC));
				break;
			//Search Country  include Region	
			case SEARCH13:
				//Search Country  include Region	
				ComSetObjValue(formObj.rgn_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_RGN));
				break;
			// Search Country  include  State 
			case SEARCH17:
				ComSetObjValue(formObj.ste_cd, sheetObj.GetCellValue(sheetObj.GetSelectRow(), CVRG_RGN));
				break;
		}
	}
	// Retrieving conditions fields Country, Region Combo Data Inquiry
    // The last argument is that sInitCellCombo, Screen when loading, Coverage When setting to false information that put the argument values, the default value if no value is set to true
    function doActionIBCommon(sheetObj,formObj,sAction,sComboAction,sComboField,sInitCellCombo) {
        sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
	    switch(sAction) {
	       //Search Customer, that Dual Type Exception registered 
	    	case IBSEARCH_CUST:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				//2.retrievie according to conditions
				//*********************************************************************************
//				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 				
				var sXml=sheetObj.GetSearchData("EES_DMT_2014GS.do", FormQueryString(formObj));
				//*********************************************************************************
//				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var comboObj=comboObjects[0];
				var comboItems=ComGetEtcData(sXml, "CUSTCODE").split(ROWMARK);
				//3-1.Results retrieved before I had to set up combos, the existing information must be removed.
				comboObj.RemoveAll();
				addComboItem(comboObj,comboItems);
            break;
            
            //Search S/C, RFA CNTR/Cargo Type
	    	case IBSEARCH_CNTRCGO:
				//1.Setting parametor condition, before retrieving
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.intg_cd_id, "CD01969");
   	 			//2.retrievie according to conditions
				//*********************************************************************************
//				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
//				ComOpenWait(false);
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
//				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 	    	    
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
//				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var comboDatas=ComGetEtcData(sXml, "COMMON_CD");
				if (comboDatas != undefined) {
					addCellComboItem(sheetObj,comboDatas,sComboField,false,true);
				}
    		break;
    		
	    	case IBSEARCH_CUSTNM:
				//1.Setting parametor condition, before retrieving
	    		var custCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), CUST_CD);
				ComSetObjValue(formObj.f_cmd, sComboAction);
				ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
				ComSetObjValue(formObj.cust_seq, custCd.substring(2));
   	 			//2.retrievie according to conditions
				//*********************************************************************************
//				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 	    	    
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
//				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var result=ComGetEtcData(sXml, "CUST_NM");
				if (result != undefined && result != "") {
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), sComboField, result, 0);
				}
				else {
					ComShowCodeMessage("DMT00165", "Customer Code");
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), CUST_CD, "", 0);
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), CUST_NM, "", 0);
				}
    		break;
    		
	    	case IBSEARCH_CVRG:
				//1.Setting parametor condition, before retrieving
				setCommonParameters(sheetObj,sComboAction);
   	 			//2.retrievie according to conditions
				//*********************************************************************************
//				ComOpenWait(true);
				sheetObj.SetWaitImageVisible(0);
				//*********************************************************************************
//parameter changed[check again]CLT 	    	    
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				//*********************************************************************************
//				ComOpenWait(false);
				//*********************************************************************************
				//3.After handling Retrieving results
				var comboDatas;
				var comboItems;
				var comboItem;
				// Coverage of the information search, loadPage If you are calling from and if you call in the grid due to selection intended to identify.
				sInitCellCombo=sInitCellCombo == false ? false : true;
				switch(sComboAction) {
					//3-1.Search Region (All Region List)
					case SEARCH01:
						comboDatas=ComGetEtcData(sXml, "RGN");
						addCellComboItem(sheetObj,comboDatas,sComboField,sInitCellCombo);
					break;
					
					//3-2.Search Country (All Country List)
					case SEARCH02:
						comboDatas=ComGetEtcData(sXml, "CNT");
						addCellComboItem(sheetObj,comboDatas,sComboField,sInitCellCombo);
					break;
					
					//3-3. Search  Region of Country
					case SEARCH03:
						sComboField=sComboField.split(ROWMARK);
						//In response XML, Region or State allows to extract information entered in the list.
						var cntCd=sheetObj.GetCellValue(sheetObj.GetSelectRow(), sComboField[0]);
						if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
							comboDatas=ComGetEtcData(sXml, "STE");
						} else {
							comboDatas=ComGetEtcData(sXml, "RGN");
						}
						// If you do not have the search results, Error Message show makes initializing to Empty.
						if (comboDatas == undefined || ComTrim(comboDatas) == "") {
							ComShowCodeMessage("DMT00110", "Country");
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), sComboField[0],"");
							return;
						} else {
							addCellComboItem(sheetObj,comboDatas,sComboField[1],true);
						}				
					break;
					
					//3-4.Coverage location of the parent item lookup (which corresponds to the location entered higher CN, RGN to be Inquiry)
					case SEARCH04:
						sComboField=sComboField.split(ROWMARK);
						//In response XML, Country information, choose from the list allows querying.
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj,comboDatas,sComboField[0]);
							//In response XML,  Region or State information, choose from the list allows querying.다.
							var cntCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sComboField[0]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=ComGetEtcData(sXml, "STE");
								} else {
									comboDatas=ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj,comboDatas,sComboField[1]);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Location");
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),sComboField[2],"",0);
						}
					break;
					
					//3-5.Region as a higher item code (Country) should query information.
					case SEARCH13:	
					//3-6.State as a higher item code (Country) should query information.
					case SEARCH17:
						sComboField=sComboField.split(ROWMARK);
						//In response XML, Country information, choose from the list allows querying.
						comboDatas=ComGetEtcData(sXml, "CNT");
						if (comboDatas != undefined) {
							setCellComboItem(sheetObj,comboDatas,sComboField[1]);
							//In response XML,  Region or State information, choose from the list allows querying.다.
							var cntCd=ComTrim(sheetObj.GetCellValue(sheetObj.GetSelectRow(), sComboField[1]));
							if (cntCd != "") {
								if (cntCd.substring(0,2) == "US" || cntCd.substring(0,2) == "CA") {
									comboDatas=ComGetEtcData(sXml, "STE");
								} 
								else {
									comboDatas=ComGetEtcData(sXml, "RGN");
								}
								setCellComboItem(sheetObj,comboDatas,sComboField[2]);
							}
						}
						else {
							ComShowCodeMessage("DMT00110", "Region");
							sheetObj.SetCellValue(sheetObj.GetSelectRow(), sComboField[2],"",0);
						}
					break;
				}	    	    
	    	break;               
        }
		sheetObj.SetWaitImageVisible(1);
    }
     /**
      * Choose from a grid of data in the field makes the combo.
      */		
 	function setCellComboItem(sheetObj,comboDatas,sComboKey) {
 		var sRow=sheetObj.GetSelectRow();
 		var sVal="";
 		if (comboDatas != undefined) {
 			var comboItem=comboDatas.split(FIELDMARK);
 			sVal=comboItem[0];
 		}
 		sheetObj.SetCellValue(sRow, sComboKey,sVal);
 	}
     /**
      * Grid Data in the field adds a combo.
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
      * Data in the field adds a combo.
      */	
 	function addComboItem(comboObj, comboItems) {
     	for (var i=0 ; i < comboItems.length ; i++) {
     		var comboItem=comboItems[i].split(FIELDMARK);
 			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
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
    	else if (sAction == IBSAVE) {
    		with(sheetObj) {
    			// save Data does not exist
    			if (RowCount()== 0) {
    				ComShowCodeMessage("DMT00128");
    				return false;
    			}
				//0.check duplication
				if (!dupValidate(sheetObj)) return false;
    			for (var row=HeaderRows(); row <= LastRow(); row++) {
    				if (GetRowStatus(row) == "I" || GetRowStatus(row) == "U") {
    					//1.Check mandatory input
	    				//1-1.Customer Code
    					if (ComTrim(GetCellValue(row, CUST_CD)) == "") {
    						ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "Customer Code");
	    					return false;
	    				}
	    				//1-2.Type
    					if (ComTrim(GetCellValue(row, TYPE)) == "") {
    						ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "Type");
	    					return false;
	    				}
	    				//1-3.EFF DT
    					if (ComTrim(GetCellValue(row, EFF_DT)) == "") {
    						ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "EFF DT");
	    					return false;
	    				}
	    				//1-4.EXP DT
	    				//If ROW EXP DT Expire button, click the column information are essential inputs.
    					if (GetCellValue(row, EXP_FLG) == "Y" && ComTrim(GetCellValue(row, EXP_DT)) == "") {
    						ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "EXP DT");
	    					return false;
	    				}
	    				//If the input EXP DT, EFF DT checks to see if an earlier date.
    					if (ComTrim(GetCellValue(row, EXP_DT)) != "") {
    						if (ComGetDaysBetween(ComTrim(GetCellValue(row, EXP_DT)), ComTrim(GetCellValue(row, EFF_DT))) > 0) {
	    		    			ComShowCodeMessage("COM12133", "'EFF DT'", "'EXP DT'", "earlier");
	    		    			return false;	    			
	    		    		}
	    					//Check  EXP DT 
    						else if (GetCellValue(row, STATUS) == "Live" && !checkExpireDate(row)) {
	    		    			return false;		    						
	    					}
	    				}
	    				//1-5.Check Bound
    					if (ComTrim(GetCellValue(row, BOUND)) == "") {
    						ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "Bound");
	    					return false;
	    				}
	    				//1-6.Check  Coverage
    					if (ComTrim(GetCellValue(row, CVRG_CNT)) == "") {
    						ComShowCodeMessage("DMT00108", GetCellValue(row, "Seq"), "Coverage");
	    					return false;
	    				}
	    				//1-7.Check  Coverage( Dual Type )
    					if (GetRowStatus(row) == "I") {
    						if (ComTrim(GetCellValue(row, CVRG_CNT)) != "") {
		    					if (!checkDualCoverage(row)) {
		    						return false;
		    					}
		    				}
	    				}
    				}
    			}
    		}
    	}
		return true;
    }
   	/**
   	 * Check the data dupication Dual Type Exception Inquiry
   	 */	      
   	 function dupValidate(sheetObj) {
         var formObj=document.form;
         var srcEffDt="";
         var srcExpDt="";
         var trgEffDt="";
         var trgExpDt="";
   		with(sheetObj) {
   			//1.Check dupication DB data
   			for (var row=HeaderRows(); row <= LastRow(); row++) {
   				if (GetRowStatus(row) == "I") {
   					if (!dupValidateWithDB(row)) return false;
   				}
   			}
   			//2.Check dupication Screen data
 			for (var i=HeaderRows(); i <= LastRow()- 1 ; i++) {
 				if (GetCellValue(i, STATUS) == "Deleted" || GetRowStatus(i) == "D") continue;
 				srcEffDt=GetCellValue(i, EFF_DT) != "" ? GetCellValue(i, EFF_DT) : "99991231";
 				srcExpDt=GetCellValue(i, EXP_DT) != "" ? GetCellValue(i, EXP_DT) : "99991231";
 				for (var j=i + 1 ; j <= LastRow(); j++) {
 					if (GetCellValue(j, STATUS) == "Deleted" || GetRowStatus(j) == "D") continue;
 					trgEffDt=GetCellValue(j, EFF_DT) != "" ? GetCellValue(j, EFF_DT) : "99991231";
 					trgExpDt=GetCellValue(j, EXP_DT) != "" ? GetCellValue(j, EXP_DT) : "99991231";
 					if (	GetCellValue(i, CUST_CD) == GetCellValue(j, CUST_CD)
 							&& 	GetCellValue(i, TYPE) == GetCellValue(j, TYPE)
 							&& 	GetCellValue(i, BOUND) == GetCellValue(j, BOUND)
 							&& 	GetCellValue(i, CVRG_CNT) == GetCellValue(j, CVRG_CNT)
 							&& 	GetCellValue(i, CVRG_RGN) == GetCellValue(j, CVRG_RGN)
 							&& 	GetCellValue(i, CVRG_LOC) == GetCellValue(j, CVRG_LOC)
 							&& 	GetCellValue(i, CNTRCGO) == GetCellValue(j, CNTRCGO)		) {
 						//Check whether there is overlap with EFF_DT EXP_DT
 						if (	(	trgEffDt >= srcEffDt &&  trgEffDt <= srcExpDt	)
 							||	(	trgExpDt >= srcEffDt &&  trgExpDt <= srcExpDt	)
 							||	(	srcEffDt >= trgEffDt &&  srcEffDt <= trgExpDt	)									
 							||	(	srcExpDt >= trgEffDt &&  srcExpDt <= trgExpDt	)	) {
 							//====================================Create Error message ================================================================================
 							var dupAlertMsg="\n\n";
 							dupAlertMsg += "Customer Code : [ " + GetCellValue(i, CUST_CD)+ " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "Type : [ " + GetCellText(i, TYPE) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "EFF DT : [ " + GetCellValue(i, EFF_DT) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "EXP DT : [ " + GetCellValue(i, EXP_DT) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "BOUND : [ " + GetCellText(i, BOUND) + " ]";
 							dupAlertMsg += "\n";				
 							dupAlertMsg += "Coverage : [ " + GetCellValue(i, CVRG_CNT) + " ][ " + GetCellValue(i, CVRG_RGN) + " ][ " + GetCellValue(i, CVRG_LOC) + " ]";
 							dupAlertMsg += "\n";
 							dupAlertMsg += "CNTR/Cargo Type : [ " + GetCellText(i, CNTRCGO) + " ]";
 							//====================================================================================================================================
 							ComShowCodeMessage("DMT00138", GetCellValue(j, "Seq"), dupAlertMsg);
 							return false;
 						}
 					}
 				}	// for
 			} // for
   		} //end with
  		return true;
   	 }
   	/**
   	 * Entered ROW and DB data duplication function to check whether
   	 */
     function dupValidateWithDB(row) {
     	var formObj=document.form;
   		var sheetObj=sheetObjects[0];
   		with(sheetObj) {
			ComSetObjValue(formObj.cust_cd, GetCellValue(row, CUST_CD));
			ComSetObjValue(formObj.dul_expt_eff_dt, GetCellValue(row, EFF_DT));
			ComSetObjValue(formObj.dul_expt_exp_dt, GetCellValue(row, EXP_DT));
			ComSetObjValue(formObj.io_bnd_cd, GetCellValue(row, BOUND));
			ComSetObjValue(formObj.cvrg_cnt_cd, GetCellValue(row, CVRG_CNT));
			ComSetObjValue(formObj.cvrg_rgn_ste_cd, GetCellValue(row, CVRG_RGN));
			ComSetObjValue(formObj.cvrg_loc_cd, GetCellValue(row, CVRG_LOC));
			ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, GetCellValue(row, TYPE));
			ComSetObjValue(formObj.dmdt_cntr_cgo_tp_cd, GetCellValue(row, CNTRCGO));
 			doActionIBSheet(sheetObj,formObj,IBSEARCH_CHECK_DUP);
 			if (ComGetObjValue(formObj.result) == "Y") {
 				//====================================Create Error message ================================================================================
 				var dupAlertMsg="\n\n";
 				dupAlertMsg += "Customer Code : [ " + GetCellValue(row, CUST_CD)+ " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "Type : [ " + GetCellText(row, TYPE) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "EFF DT : [ " + ComGetObjValue(formObj.result_dul_expt_eff_dt) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "EXP DT : [ " + ComGetObjValue(formObj.result_dul_expt_exp_dt) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "BOUND : [ " + GetCellText(row, BOUND) + " ]";
 				dupAlertMsg += "\n";				
 				dupAlertMsg += "Coverage : [ " + GetCellValue(row, CVRG_CNT) + " ][ " + GetCellValue(row, CVRG_RGN) + " ][ " + GetCellValue(row, CVRG_LOC) + " ]";
 				dupAlertMsg += "\n";
 				dupAlertMsg += "CNTR/Cargo Type : [ " + GetCellText(row, CNTRCGO) + " ]";
 				ComShowCodeMessage("DMT00138", GetCellValue(row, "Seq"), dupAlertMsg);
 				return false;
 				//====================================================================================================================================
 			}
 		} 
 		return true;
   	}
	/**
	 * Expire Date entered in the selected Row function that checks the validity of
	 *  Expire Date's S/C, Before Booking < inputed Expire Date -> error
	 */	      
	 function checkExpireDate(row) {
		 var formObj=document.form;
		 var sheetObj=sheetObjects[0];
     	//2.Setting parametor condition, before retrieving
		with(sheetObj) {
			var custCd=sheetObj.GetCellValue(row, CUST_CD);
			var typeCd=sheetObj.GetCellValue(row, TYPE);
			var cntCd=sheetObj.GetCellValue(row, CVRG_CNT);
	     	var rgnCd="";
	     	var steCd="";
	     	if (cntCd == "CA" || cntCd == "US") {
	     		steCd=sheetObj.GetCellValue(row, CVRG_RGN);
	     		rgnCd="";
	     	}
	     	else {
	     		steCd="";
	     		rgnCd=sheetObj.GetCellValue(row, CVRG_RGN);
	     	}
	     	var locCd=sheetObj.GetCellValue(row, CVRG_LOC);
		}
     	ComSetObjValue(formObj.cust_cnt_cd, custCd.substring(0, 2));
     	ComSetObjValue(formObj.cust_seq, custCd.substring(2));
     	ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, typeCd);
     	ComSetObjValue(formObj.cvrg_cnt_cd, cntCd);
     	ComSetObjValue(formObj.cvrg_rgn_cd, rgnCd);
     	ComSetObjValue(formObj.cvrg_ste_cd, steCd);
     	ComSetObjValue(formObj.cvrg_loc_cd, locCd);
    	//EFF DT
     	ComSetObjValue(formObj.dul_expt_eff_dt, 	 sheetObj.GetCellValue(row, EFF_DT));
    	//EXP DT
     	ComSetObjValue(formObj.dul_expt_exp_dt, 	 sheetObj.GetCellValue(row, EXP_DT));
		 //Check Expire Date
		 doActionIBSheet(sheetObj,formObj,IBSEARCH_CHECK_EXPDT);
     	//4.After the Inquiry, the results will be performed.
     	//4-1.Unable to delete
     	if (ComGetObjValue(formObj.result) != "Y") {
     		var scNo=ComGetObjValue(formObj.result_sc_no);
     		var darNo=ComGetObjValue(formObj.result_dar_no);
     		var custCd=sheetObj.GetCellValue(row, CUST_CD);
    		//S/C 
     		if (sheetObj.GetCellValue(row, TYPE) == "S") {
    			ComShowCodeMessage("DMT04011", custCd, scNo);
    		}
    		//Before Booking
     		else if (sheetObj.GetCellValue(row, TYPE) == "B") {
    			ComShowCodeMessage("DMT04012", custCd, darNo);
    		}
     		return false;
     	}
     	return true;
	 }
   	/**
   	 * Check the data dupication Dual Type Exception Inquiry
   	 */	      
   	 function checkDualCoverage(selectRow) {
   		 var formObj=document.form;
   		 var sheetObj=sheetObjects[0];
   		 var cntCd;
   		 var rgnCd;
   		 var steCd;
   		 var locCd;
   		 with(sheetObj) {
   			 cntCd=GetCellValue(selectRow, CVRG_CNT);
   			 if (cntCd == "CA" || cntCd == "US") {
   				 steCd=GetCellValue(selectRow, CVRG_RGN);
   				 rgnCd="";
   			 }
   			 else {
   				 steCd="";
   				 rgnCd=GetCellValue(selectRow, CVRG_RGN);
   			 }
   			 locCd=GetCellValue(selectRow, CVRG_LOC);
   		 }
   		 ComSetObjValue(formObj.cnt_cd, cntCd);
   		 ComSetObjValue(formObj.rgn_cd, rgnCd);
   		 ComSetObjValue(formObj.ste_cd, steCd);
   		 ComSetObjValue(formObj.loc_cd, locCd);
   		 //Check Dual Coverage
   		 doActionIBSheet(sheetObj,formObj,IBSEARCH_DUAL_CVRG);
   		 if (ComGetObjValue(formObj.result) != "Y") {
   			var errAlertMsg="";
   			with(sheetObj) {
				errAlertMsg += "[ " + GetCellValue(selectRow, CVRG_CNT) + " ]";
				errAlertMsg += "[ " + GetCellValue(selectRow, CVRG_RGN) + " ]";
				errAlertMsg += "[ " + GetCellValue(selectRow, CVRG_LOC) + " ]";
				ComShowCodeMessage("DMT00132", GetCellValue(selectRow, "Seq"), errAlertMsg);
   			}
			return false;
   		 }
   		 return true;
   	 }
 	/**
 	 * Sheet1 change
 	 */		 
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		var formObj=document.form;
		with(sheetObj) {
			switch(ColSaveName(Col)) {
				case CUST_CD:
					//After you enter the Customer Code, Customer Name lookup automatically makes the settings.
					if (Value == "" || Value.length < 3) {
						ComShowCodeMessage("DMT00165", "Customer Code");
						SetCellValue(Row, CUST_CD, "", 0);
						SetCellValue(Row, CUST_NM, "", 0);
					}
					else {
						if (Value.length != 8) {
							SetCellValue(Row, Col, fetchLeftPadding(Value), 0);
						}
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CUSTNM,SEARCH19,CUST_NM);//CUST_NM 조회
						doActionIBSheet(sheetObj,formObj,IBSEARCH_DUAL_CUST);				//CUST 에 대한 TYPE 콤보지정가능여부 조회
					}
				break;
				
				case TYPE:
					//Before
					if (GetCellValue(Row,TYPE) == "B") {
						SetCellValue(Row, CNTRCGO,"");
						addCellComboItem(sheetObj, rfaCNTRCargoType, CNTRCGO, true, false);
					}
					//S/C
					else if (GetCellValue(Row,TYPE) == "S") {
						SetCellValue(Row, CNTRCGO,"");
						addCellComboItem(sheetObj, sCCNTRCargoType, CNTRCGO, true, true);
					}
					else {
						SetCellValue(Row, CNTRCGO,"");
						addCellComboItem(sheetObj, "", CNTRCGO, true, true);
					}
				break;
				
				case CVRG_CNT:
					var cntCd=ComTrim(sheetObj.GetCellValue(Row,Col));
					//If Country is Empty, All Region information is Inquiry.
					if (cntCd.length == 0) {
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH01,CVRG_RGN);
						sheetObj.SetCellValue(Row, CVRG_RGN,"");
					}
					//Search information of Country belonging to the sub-Regsion or State 	
					else if (cntCd.length == 2) {
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH03,CVRG_CNT + "|" + CVRG_RGN);
					}
					//If Country is changed, Location information erase.
					if (isClearLocation) clearLocation(sheetObj,CVRG_LOC);
				break;
				
				case CVRG_RGN:
					var rgnCd=ComTrim(sheetObj.GetCellValue(Row,Col));
					//Search higher Country of  Region includes
					switch(rgnCd.length) {
						case 2: 
							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH17,"|" + CVRG_CNT + "|" + CVRG_RGN);
							break;
						case 3:
							doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH13,"|" + CVRG_CNT + "|" + CVRG_RGN);
							break;
					}
					//If Region is changed, Location information erase.
					if (isClearLocation) clearLocation(sheetObj,CVRG_LOC);
				break;
				
				case CVRG_LOC:
					var locCd=ComTrim(sheetObj.GetCellValue(Row,Col));
		    		if (locCd.length == 5) {
						isClearLocation=false;
						isValueSettingEvent=true;
						//Search higher Country, Region or State of  Location includes
						doActionIBCommon(sheetObj,formObj,IBSEARCH_CVRG,SEARCH04,CVRG_CNT + "|" + CVRG_RGN + "|" + CVRG_LOC);
						isValueSettingEvent=false;
						isClearLocation=true;
					}
					else if (locCd.length > 0) {
						ComShowCodeMessage("DMT00110", "Location");
						sheetObj.SetCellValue(Row, Col,"",0);
					}
				break;				
			}
		}
	}
	/**
	 * BOUND field has been chosen according to the value in, Coverage CN field when MouseOver show tooltips.
	 */	
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		with(sheetObj) {
			if (MouseRow()>= HeaderRows()&& MouseRow()<= LastRow()) {
				var colName = ColSaveName(MouseCol());
				if (colName == CVRG_CNT || colName == CVRG_RGN || colName == CVRG_LOC) {
					//IF Bound = 'O' ,  balloon message 'BKG POR',IF Bound = 'I' ,  balloon message 'BKG DEL'
					switch(GetCellValue(MouseRow(), BOUND)) {
						case "O": SetToolTipText(MouseRow(), MouseCol(), "BKG POR"); break;
						case "I": SetToolTipText(MouseRow(), MouseCol(), "BKG DEL"); break;
						default : SetToolTipText(MouseRow(), MouseCol(), "");
					}
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
	function sheet1_OnPopupClick(sheetObj,Row,Col) {
		ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
	}
    function getCustCd(aryPopupData) {
  		var formObj=document.form;
  		var sheetObj=sheetObjects[0];
  		with(sheetObj) {
  			SetCellValue(GetSelectRow(), CUST_CD, aryPopupData[0][3], 0);	//sheet 이벤트발생 방지
  			SetCellValue(GetSelectRow(), CUST_NM, aryPopupData[0][4], 0);	//sheet 이벤트발생 방비
  		}
  		//Search  S/C and Before Booking  Customer by Customer Code
  		doActionIBSheet(sheetObj,formObj,IBSEARCH_DUAL_CUST);
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
	* Row Add button when clicked, a function that defines the behavior to be executed
	*/	 
    function doActionAddDualType() {
    	var sheetObj=sheetObjects[0];
		with(sheetObj) {
			DataInsert(-1);
			// TYPE = Empty=
			SetCellValue(LastRow(), TYPE,"");
			// CNTR/Cargo Type = Empty 
			SetCellValue(LastRow(), CNTRCGO,"");
			addCellComboItem(sheetObj,"",CNTRCGO,false,false);
		}
		//Row Copy the Row Delete button is automatically activating.
		if (!ComIsBtnEnable("btn_CopyDualType")) {	ComBtnEnable("btn_CopyDualType")};
		if (!ComIsBtnEnable("btn_DelDualType")) { 	ComBtnEnable("btn_DelDualType")};
    }
   /**
	* Row Copy button when clicked, a function that defines the operation to be executed
	*/	 
    function doActionCopyDualType() {
		var sheetObj=sheetObjects[0];
		with(sheetObj) {
			var row=DataCopy();
			SetRowStatus(row,"I");
			SetCellValue(row, STATUS,"",0);
			SetCellValue(row, UPD_OFC,"",0);
			SetCellValue(row, UPD_USR_NM,"",0);
			SetCellValue(row, UPD_DT,"",0);
		}
    }
   /**
	* When you click Delete button, a function that defines the operation to be executed
	*/	 
    function doActionDelDualType() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
        var delRows=sheetObj.FindCheckedRow("del_chk");
        if (delRows == "") {
        	ComShowCodeMessage("DMT00154", "delete");
        	return;
        }
        var delRowArr=delRows.split(ROWMARK);
        // "Do you want to delete [Value]?" 
        var msg="delete " + fetchAllCustomerCodeSelected();
        if (!ComShowCodeConfirm("DMT00135", msg)) return;
        //Check row status for delete
        for (var i=0 ; i < delRowArr.length - 1 ; i++) {
        	if (sheetObj.GetCellValue(delRowArr[i], STATUS) == "Deleted") {
        		ComShowCodeMessage("DMT00176", sheetObj.GetCellValue(delRowArr[i], CUST_CD));
        		return;
        	}
        	// case in Live 
        	if (sheetObj.GetCellValue(delRowArr[i], STATUS) == "Live") {
	        	//2-1.Setting parametor condition, before retrieving
        		var custCd=sheetObj.GetCellValue(delRowArr[i], CUST_CD);
        		var typeCd=sheetObj.GetCellValue(delRowArr[i], TYPE);
        		var cntCd=sheetObj.GetCellValue(delRowArr[i], CVRG_CNT);
	        	var rgnCd="";
	        	var steCd="";
	        	if (cntCd == "CA" || cntCd == "US") {
	        		steCd=sheetObj.GetCellValue(delRowArr[i], CVRG_RGN);
	        		rgnCd="";
	        	}
	        	else {
	        		steCd="";
	        		rgnCd=sheetObj.GetCellValue(delRowArr[i], CVRG_RGN);
	        	}
	        	var locCd=sheetObj.GetCellValue(delRowArr[i], CVRG_LOC);
	        	ComSetObjValue(formObj.cust_cnt_cd, 		 custCd.substring(0, 2));
	        	ComSetObjValue(formObj.cust_seq, 			 custCd.substring(2));
	        	ComSetObjValue(formObj.dmdt_ctrt_expt_tp_cd, typeCd);
	        	ComSetObjValue(formObj.cvrg_cnt_cd, 		 cntCd);
	        	ComSetObjValue(formObj.cvrg_rgn_cd, 		 rgnCd);
	        	ComSetObjValue(formObj.cvrg_ste_cd, 		 steCd);
	        	ComSetObjValue(formObj.cvrg_loc_cd, 		 locCd);
	        	//EFF DT
	        	ComSetObjValue(formObj.dul_expt_eff_dt, 	 sheetObj.GetCellValue(delRowArr[i], EFF_DT));
	        	//EXP DT
	        	ComSetObjValue(formObj.dul_expt_exp_dt, 	 sheetObj.GetCellValue(delRowArr[i], EXP_DT));
	        	//2-2. call Searching modul.
	        	doActionIBSheet(sheetObj,formObj,IBSEARCH_DEL_CUST);
	        	//2-3.After the Inquiry, the results will be performed.
	        	//2-4.Unable to delete
	        	if (ComGetObjValue(formObj.result) != "Y") {
	        		var scNo=ComGetObjValue(formObj.result_sc_no);
	        		var darNo=ComGetObjValue(formObj.result_dar_no);
	        		var custCd=sheetObj.GetCellValue(delRowArr[i], CUST_CD);
	        		//S/C 
	        		if (sheetObj.GetCellValue(delRowArr[i], TYPE) == "S") {
	        			ComShowCodeMessage("DMT02031", custCd, scNo);
	        		}
	        		//Before Booking
	        		else if (sheetObj.GetCellValue(delRowArr[i], TYPE) == "B") {
	        			ComShowCodeMessage("DMT02032", custCd, darNo);
	        		}
	        		return;
	        	}
        	}
        }
        //delete ROW
        for (var i=0 ; i < delRowArr.length ; i++) {
        	if (sheetObj.GetRowStatus(delRowArr[i]) == "I") {
				sheetObj.RowDelete(delRowArr[i], false);
			} else {
				sheetObj.SetRowStatus(delRowArr[i],"D");
				sheetObj.SetRowHidden(delRowArr[i],1);
			}
        }
		//Row Copy the Row Delete button is automatically deactivating.
        if (fetchRowCount() == 0) {
        	if (ComIsBtnEnable("btn_CopyDualType")) ComBtnDisable("btn_CopyDualType");
        	if (ComIsBtnEnable("btn_DelDualType")) ComBtnDisable("btn_DelDualType");
        }
    }
   /**
	* Expire button when clicked, a function that defines the behavior to be executed
	*/	 
    function doActionExpireDualType() {
		var sheetObj=sheetObjects[0];
		//no selected, Alert
        var delRows=sheetObj.FindCheckedRow("del_chk");
        if (delRows == "") {
        	ComShowCodeMessage("DMT00154", "expire");
        	return;
        }		
		//if select Deleted,  “[Value] was already deleted” Alert
		if (isExpireDualType()) {
			remarkCheckExpireDualType();
		}
    }
   /**
	* Check  selected items for  Expire
	*/		
	function isExpireDualType() {
		var sheetObj=sheetObjects[0];
        //Check validation for  Expire
        with(sheetObj) {
            var expRows=FindCheckedRow("del_chk");
            var expRowArr=expRows.split(ROWMARK);
	        for (var i=0; i < expRowArr.length; i++) {
	        	if (	GetRowStatus(expRowArr[i]) != "D"
	        		&&	GetCellValue(expRowArr[i], STATUS) == "Deleted"	) {
	        		ComShowCodeMessage("DMT00176", GetCellValue(expRowArr[i], CUST_CD));
					return false;	        		
	        	}
	        }
        }
		return true;
	}
   /**
	* EXP DT column for all selected items marked as required and give input to enable a function by activating
	*/	
	function remarkCheckExpireDualType() {
		var sheetObj=sheetObjects[0];
        with(sheetObj) {
            var expRows=FindCheckedRow("del_chk");
            var expRowArr=expRows.split(ROWMARK);
	        for (var i=0; i < expRowArr.length; i++) {
	        	if (GetRowStatus(expRowArr[i]) != "D") {
					SetCellValue(expRowArr[i], EXP_FLG,"Y");
					SetCellEditable(expRowArr[i], EXP_DT,1);
	        	}
	        }
        }
	}
   /**
	*  Click the  Down Excel button , the function that defines the operation to be executed
	*/	 
    function doActionDownExcel() {
		var sheetObj=sheetObjects[0];
//method change[check again]CLT 		
		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(		sheetObj), SheetDesign:1,Merge:1 });
    }
   /**
	* When you click Retrieve button, the function that defines the operation to be executed
	*/	 
    function doActionRetrieve() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var cboCustomerObj=comboObjects[0];
		if (validateForm(sheetObj,formObj,IBSEARCH)) {
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
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
		// Delete Searching result
		sheetObj.RemoveAll();
		//button initializing  
		initBtnControl();
    }
   /**
	* Save button when clicked, a function that defines the behavior to be executed
	*/	 
    function doActionSave() {
    	var formObj=document.form;
    	var sheetObj=sheetObjects[0];
    	var cboCustomerObj=comboObjects[0];
		if (validateForm(sheetObj,formObj,IBSAVE)) {
			doActionIBSheet(sheetObj,formObj,IBSAVE); 
			if (ComGetObjValue(formObj.result) == "Y") {
				//Customer information and after re-Inquiry, in order to maintain the previous status value must backup the currently selected value.
				var custCd=cboCustomerObj.GetSelectText();
				//With the addition of Customer Information, Customer information is re-Inquiry.
				doActionIBCommon(sheetObj,formObj,IBSEARCH_CUST,SEARCH01);
				//Previously selected from a list of the newly retrieved Customer selection allows information.
				cboCustomerObj.SetSelectText(custCd);
				doActionRetrieve();
			}			
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
	function setCustomerFromPopup(arvPopupData,Row,Col,sheetIdx) {
		//sheetObjects[sheetIdx].CellValue2(row,col) = arvPopupData[0][2];
	} 	
	/**
	 * Location  initializing
	 */		
	function clearLocation(sheetObj,sComboKey) {
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sComboKey,"",0);
	}
   /**
 	* Customer Code of all the selected data, a function that returns 
 	*/	
 	function fetchAllCustomerCodeSelected() {
 		var sheetObj=sheetObjects[0];
 		var codes="";
         with(sheetObj) {
             var expRows=FindCheckedRow("del_chk");
             var expRowArr=expRows.split(ROWMARK);
 	        for (var i=0 ; i < expRowArr.length - 1 ; i++) {
 	        	if (GetRowStatus(expRowArr[i]) != "D") {
 	        		if (codes.indexOf(GetCellValue(expRowArr[i], CUST_CD)) == -1)
 	        			codes += GetCellValue(expRowArr[i], CUST_CD) + " ";
 	        	}
 	        }
         }
         return codes;
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
 	* Do not delete the entire Row Count function to obtain
 	*/ 	
 	function fetchRowCount() {
 		var sheetObj=sheetObjects[0];
 		var count=0;
 		with(sheetObj) {
 			for (var row=HeaderRows(); row <= LastRow(); row++) {
 				if (GetRowStatus(row) != "D") count++;
 			}
 		}
 		return count;
 	}
