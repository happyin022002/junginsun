/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4008.js
*@FileTitle  : Issued Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================**/

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
	
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	var PERIOD_GAP=15;
	var USR_TRF_TP;
	var Mincount=0 ;
	
	var DEF_SHEET_HEIGHT = 420;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 116;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
    	/***** case in Sheet count are more two by Tab, defining adding sheet *****/
    	var sheetObject1=sheetObjects[0];
    	/*******************************************************/
    	var formObject=document.form;
    	try {
     		var srcObj=window.ComGetEvent();
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return;
				switch(srcName) {
	             	case "btns_calendar": //Calendar button
	             		var cal=new ComCalendarFromTo();
	    	            cal.select(formObject.s_issue_fm,  formObject.s_issue_to,  'yyyy-MM-dd');
		         		/*if(srcObj.style.cursor == "hand") {
		    	            var cal=new ComCalendarFromTo();
		    	            cal.select(formObject.s_issue_fm,  formObject.s_issue_to,  'yyyy-MM-dd');
		    	            //cal.select(form.s_issue_fm,  form.s_issue_to,  'yyyy-MM-dd');
		         		}*/
						break;
	 				case "btn_issue_usr":	 					
	 						openPopup('issue_usr_id');	 					
	 					break;						
	 				case "btns_multisearch1":
	 						openPopup('s_invoice_no');	 					
	 					break;						
	 				case "btns_multisearch2":	 					
	 						openPopup('s_bkg_no');
	 					break;						
	 				case "btns_multisearch3":	 					
	 						openPopup('s_bl_no');
	 					break;						
	             	case "btns_cust_cd":
	             		openPopup('s_payer_cd');
	 					break;
					case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;
					case "btn_New":
						initControl();
						ofc_enable();
						break;
					case "btn_Minimize":
						Mincount=(Mincount+1)%2 ;
	                    Minimize(Mincount);
						break;
					case "btn_Detail":
						openPopupWindow(sheetObject1, formObject, srcName)
						break;
					case "btn_DownExcel":
						if(sheetObject1.RowCount() < 1){//no data						
							ComShowCodeMessage("COM132501");
						}else{
							if(ComIsBtnEnable(srcName)) {
		 						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
		 					}
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++]=sheet_obj;
    }
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
     // IBMultiCombo initializing 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);
	    }
		//initializing html control event
		initAxonControl();
		//column enable/disable
		ofc_enable();
		initButton(); // 버튼초기화 셋팅
		//initControl();
		sheet1_OnLoadFinish();
		//disable();
		//tariff_type.SetBackColor("#e9f4ff");
		//ar_if.SetBackColor("#e9f4ff");  
		//invoice_status.SetBackColor("#e9f4ff");
		//office.SetBackColor("#e9f4ff");  
    }
    
    /*function disable() {
    	alert(1);
        document.getElementById("btn_Detail").disabled=true;
        document.getElementById("btn_DownExcel").disabled=true;
        alert(2);
    }*/
    
    //no support[check again]CLT 
    function sheet1_OnLoadFinish(sheetObj) {
    	var formObj=document.form;
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST);
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[2], SEARCH15);
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[3], SEARCHLIST02);
    }
    function initAxonControl() {
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerFormat('blur',	'obj_blur',		document.form); //- out of focus
//		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); // Get focus
		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard
    }
   // out of focus
    function obj_blur(){
    	//check inputing Validation + Inserting separator 
		var obj=ComGetEvent();
		if(obj.name == 's_bkg_no' || obj.name == 's_bl_no' || obj.name == 's_invoice_no') {
		}else if(obj.name == 's_payer_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		}else{
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
    }
    function ofc_enable() {
    	var formObj=document.form;
    	//Issue Office
    	comboObjects[3].SetEnable(1);
    	comboObjects[3].SetSelectIndex(-1);
    	
    	//Issue Date
		ComEnableObject(formObj.s_issue_fm, true);
		ComEnableObject(formObj.s_issue_to, true);
		ComEnableObject(formObj.s_inv_over, true);
		ComEnableObject(formObj.s_issue_usr_id, true);
	    //Period Date initializing
		ComSetObjValue(formObj.today_dt, ComGetMaskedValue(formObj.today_dt.value, "ymd"));
		var temp_day=ComGetDateAdd(ComGetObjValue(formObj.today_dt), "M", -1);
		ComSetObjValue(formObj.s_issue_fm, temp_day);
		ComSetObjValue(formObj.s_issue_to, ComGetObjValue(formObj.today_dt));
		
		//Issue Office initializing:User Office is Default
  		var usrOfcCd = formObj.usr_ofc_cd.value;
		comboObjects[3].SetSelectCode(usrOfcCd, false);
		
		//OFC ClassName
    	formObj.s_issue_fm.className="input1";
    	formObj.s_issue_to.className="input1";
		formObj.s_inv_over.className="input";
		formObj.s_issue_usr_id.className="input";
		formObj.s_inv_over.readOnly=false;
		formObj.s_issue_usr_id.readOnly=false;
		formObj.s_issue_fm.readOnly=false;
		formObj.s_issue_to.readOnly=false;
		ComEnableObject(formObj.btns_calendar, true);
		ComEnableObject(formObj.btn_issue_usr, true);
		ComEnableObject(formObj.chk_sub_ofc, true);
		ComSetObjValue(formObj.s_inv_check, "N");
		//INV 
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_invoice_no, true);
    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_invoice_no, "");
		ComEnableObject(formObj.btns_multisearch1, false);
		ComEnableObject(formObj.btns_multisearch2, false);
		ComEnableObject(formObj.btns_multisearch3, false);
    	formObj.s_bkg_no.className="input2";
    	formObj.s_bl_no.className="input2";
    	formObj.s_invoice_no.className="input2";
		//inv disabled
		formObj.s_invoice_no.readOnly=true;
		formObj.s_bkg_no.readOnly=true;
		formObj.s_bl_no.readOnly=true;
    }    
    function inv_enable(){
    	var formObj=document.form;
    	//OFC
    	comboObjects[3].SetEnable(0);
    	comboObjects[3].SetSelectIndex(-1);
    	
		ComEnableObject(formObj.s_issue_fm, true);
		ComEnableObject(formObj.s_issue_to, true);
		formObj.s_issue_fm.className="input2";
    	formObj.s_issue_to.className="input2";
    	formObj.s_inv_over.className="input2";
    	formObj.s_issue_usr_id.className="input2";
		ComEnableObject(formObj.btns_calendar, false);
		ComEnableObject(formObj.btn_issue_usr, false);
		ComEnableObject(formObj.chk_sub_ofc, false);
		ComSetObjValue(formObj.s_issue_fm, "");
		ComSetObjValue(formObj.s_issue_to, "");
		ComSetObjValue(formObj.s_inv_over, "");
		ComSetObjValue(formObj.s_issue_usr_id, "");
		ComSetObjValue(formObj.chk_sub_ofc, "");
		formObj.s_issue_fm.readOnly=true;
		formObj.s_issue_to.readOnly=true;
		formObj.s_inv_over.readOnly=true;
		formObj.s_issue_usr_id.readOnly=true;
		//INV
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_invoice_no, true);
    	formObj.s_bkg_no.className="input1";
    	formObj.s_bl_no.className="input1";
    	formObj.s_invoice_no.className="input1";
    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_invoice_no, "");
		ComEnableObject(formObj.btns_multisearch1, true);
		ComEnableObject(formObj.btns_multisearch2, true);
		ComEnableObject(formObj.btns_multisearch3, true);
		formObj.s_bkg_no.readOnly=false;
		formObj.s_bl_no.readOnly=false;
		formObj.s_invoice_no.readOnly=false;
		ComSetObjValue(formObj.s_inv_check, "Y");
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
		              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		              var HeadTitle1="|Seq.|INV No|Split|AR IF|STS|Tariff|BKG No.|B/L No.|CNTR No.|S/C No.|RFA No.|CTRT OFC|Cur.|Incurred AMT";
		              HeadTitle1 += "|Exception AMT|D/C AMT|Billable AMT|INV Cur.|Billing AMT|Tax AMT|Payable AMT|Port";
		              HeadTitle1 += "|ISS DT|ISS OFC|ISS ID|ISS Name|I/F No.|I/F DT|I/F OFC|I/F ID|I/F Name|INV Over|Payer CD|Payer Name|Credit/Ref.|payer delt flg";
		              var headCount=ComCountHeadTitle(HeadTitle1);
		              //(headCount, 0, 0, true);
		
		              //SetConfig( { SearchMode:2, FrozenCol:savenamecol("bkg_no"), MergeSheet:5, Page:20, DataRowMerge:1 } );
		              SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"inv_prt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_ar_if_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ctrt_ofc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"dmdt_expt_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"dc_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bil_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"tax_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"port",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"issue_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"issue_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ar_if_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_if_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ar_if_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"ar_if_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"ar_if_usr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_over",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"act_payr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"act_payr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:30 },
		                     {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cr_inv_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"act_delt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		               
		              InitColumns(cols);		
		              SetEditable(1);
		              SetCountPosition(0);
		              SetEllipsis(1);
	                  FrozenCols=SaveNameCol("bkg_no");
		              //no support[check again]CLT 					ToolTipOption="balloon:true;width:50;";
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
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {  
   	    	case "office": 
   	    		with (comboObj) {   	    		
   					SetMultiSelect(1);
   					SetUseAutoComplete(1);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");   					
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "65");
   					SetColWidth(1, "250");
  					SetDropHeight(160);
  					ValidChar(2);	// use upper case
					SetMaxLength(6);
   		    	}
   				break; 
   	    	case "tariff_type":
   	    		with (comboObj) {   	    			
   					SetMultiSelect(1);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "50");
   					SetColWidth(1, "310");
					SetDropHeight(160);
   		    	}
   				break; 
   	    	case "ar_if":
   	    		var rhq_ofc_cd=ComGetObjValue(formObj.session_rhq_ofc_cd);
   	    		with (comboObj) { 
   	    			SetMultiSelect(0);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");   	    			
   	    			SetColAlign(0, "left");
   	    			SetColWidth(0, "100");
   	    			SetDropHeight(170);
   	    			addComboItem(comboObj, comboNo);
   		    	}
   				break; 
   	    	case "invoice_status":
   	    		with (comboObj) { 
					SetMultiSelect(1);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");					
					SetColAlign(0, "left");
					SetColWidth(0, "130");
					SetDropHeight(160);
   		    	}
   	    		break;
   	    }
   	}
   	// Process of Sheet
   	function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:     // Search
           	   ComSetObjValue(formObj.f_cmd, SEARCH);
        	   setParameters(SEARCH);
        	   if (validateForm(sheetObj,formObj,sAction)) {
        		   if(ComGetObjValue(formObj.s_group_by) == "1") {
        			   sheetObj.SetColHidden("cntr_no",1);
        		   } else {
        			   sheetObj.SetColHidden("cntr_no",0);
        		   }
                   //ComOpenWait Start
                   sheetObj.SetWaitImageVisible(0);
                   ComOpenWait(true);         		   
                   sheetObj.DoSearch("EES_DMT_4008GS.do", FormQueryString(formObj) );
                   //ComOpenWait End
                   ComOpenWait(false);
//                   if(sheetObj.GetTotalRows()> 0 ) {
//        			   searchButton();
//        		   }else{
//        			   initButton();
//        		   }
//        		   //Payer Code if the Code is not valid anymore, looks red, balloon message "Payer Code not available any more!"
//        		   for(var i=1; i < sheetObj.GetTotalRows()+ 1 ; i++) {
//        			   if(sheetObj.GetCellValue(i, "act_delt_flg") == "Y") {
//        				   sheetObj.SetCellBackColor(i,"act_payr_cd","#FF0000");
//        				   sheetObj.SetCellBackColor(i,"act_payr_nm","#FF0000");
//        			   }
//        		   }
        	   }
        	   break;
			case IBDOWNEXCEL:	// EXCEL DOWNLOAD
				if (sheetObj.id == "sheet1") { 					
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}; 
				break;
        }
    }
	/**
	 * EES_DMT_4002 call
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		if (srcName == "btn_Detail") {
			var invoice_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_inv_no");
			if (invoice_no.substring(2,3) == "T" || invoice_no.substring(2,3) == "R") {
				var url="EES_DMT_4002.do"
					+"?group_by="+ComGetObjValue(formObj.s_group_by)
					//+"&chg_type="+ComGetObjValue(formObj.s_chg_type)
					+"&ofc_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cre_ofc_cd")
					+"&bkg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no")
					+"&dmdt_trf_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_trf_cd")
					+"&cntr_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_no")
					+"&invoice_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_inv_no")
					+"&invoice_issue=2"	//Invoice Issue AFTER
					;
				ComOpenPopup(url, "1050","700", "callbackNotFound", "1,0", true);
//				var returnValue=ComOpenWindowCenter(url, "EES_DMT_4002", "1100","800", true);
//				if(returnValue == "Y") {
//					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//				}
			}
			else {
				var url="EES_DMT_4004P.do"
					+"?dmdt_inv_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_inv_no")
					+"&caller=4008"
					;
				ComOpenWindowCenter(url, "EES_DMT_4004", "1100","700", true);
			}
		}
	}
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg(false);
    	sheetObj.SetWaitImageVisible(0);
    	formObj.f_cmd.value=formCmd;     	
    	var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		switch(comboObj.options.id) {
			case "tariff_type":
				/*with (comboObj) {	                
					RemoveAll();
	                SetMultiSeparator(",");	                 
	            }*/
		 		// Tariff type comboList
				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);				
				if (data != undefined && data != '') {					
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem=comboItems[0].split(FIELDMARK);
				}
				var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);
				//alert(data2);
				// User Setup Tariff Type not exist : Default.
				if(data2 == ""){
					data2='CTIC,DMIF';
					comboObj.SetItemCheck(1, 1); //add
					comboObj.SetItemCheck(5, 1); //add
				}
				comboObj.SetSelectCode(data2, false);
				USR_TRF_TP=data2;
				//alert(USR_TRF_TP);
				formObj.usr_trf_tp.value=data2;
				//alert(formObj.usr_trf_tp.value);
				break;
				
	        case "invoice_status":
		 		// Invoice Status comboList
				var data=ComGetEtcData(sXml, "COMMON_CD");				
				if (data != undefined && data != '') {
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
				}
				break;
				
			case "office": // Issue Office
				if(formCmd== SEARCHLIST02) {
					// Office List
					var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
					var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
					if (ofc_cds != undefined && ofc_cds != '') {
						var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
	 					var idx=0;
	 					// login Office is first item
	 					if(ofc_cds.indexOf(usrOfcCd) == -1) {
	 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
	 						idx=1;
	 					}
						var comboCodeArr=ofc_cds.split("|");
						var comboTextArr=ofc_nms.split("|");
						for (var i=0 ; i < comboTextArr.length ; i++) {
							comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
						}
						// login User Office is  Default
		    	  		comboObj.SetSelectCode(usrOfcCd, false);
					}
				}else{// formCmd == COMMAND01
 	    		   	var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
 	    	   		if (subOfcCds != undefined && subOfcCds != '') {
 	    	   			var arrOfcCd=subOfcCds.split(',');
 	    	   			var str='';
 	    	   			for(var i=0; i<arrOfcCd.length; i++) {  	    	   				
 	    	   				var idx=comboObj.FindItem(arrOfcCd[i], 0);
 	    	   				if(idx != -1)
 	    	   					str=str + ',' + arrOfcCd[i];
 	    	   			}
 	    	   			str=str.substring(1);
 	    	   			var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
 	    	   			if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
 	    	   				str=usrOfcCd + ',' + str;
 	    	   			}
 	    	   			comboObj.SetSelectCode(str, false);
 	    	   		}
				}
				with (comboObj) {	                
					//RemoveAll();
	                SetMultiSeparator(",");	                 
	            }
	    	    break;	        
        }
        sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Data in the field adds a combo.
     */	
 	function addComboItem(comboObj,comboItems) {
 		var formObj=document.form;
 		switch(comboObj.options.id) {
 			case "tariff_type":
		  		comboObj.InsertItem(0, "All|All", "All");
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  			comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);		  	   		
		  	   	}
		  		with (comboObj) {	                
					//RemoveAll();
	                SetMultiSeparator(",");	                 
	            }
		  		break;
 			case "ar_if":
  	  				comboObj.InsertItem(0, "All|", "All");
  	  				comboObj.InsertItem(1, "No|", "N");
  	  				comboObj.InsertItem(2, "Yes|", "Y");
  	  				comboObj.SetSelectIndex(0);
  				break;
 			case "invoice_status":
 				comboObj.InsertItem(0, "All", "All");
	  			comboObj.SetItemCheck(0,1);
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  			comboObj.InsertItem(i+1, comboItem[1], comboItem[0]);
		  			comboObj.SetItemCheck(i+1,1);
		  	   	}
		  		with (comboObj) {	                
					//RemoveAll();
	                SetMultiSeparator(",");	                 
	            }
		  		break;
 		}
 	}    
    //Payer chek
    function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.s_payer_cd));
		var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
		if(cust_len == 0){
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_payer_cd, "");
			ComSetObjValue(formObj.s_payer_nm, "");
			return;
		}
		var cre_cnt_cd="";
		if(cust_len > 2) {
			var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
			//If the two-digit alphanumeric code, then Retrieving CUSTOMER
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
			// else Retrieving VENDOR
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_payer_cd, "");
			ComSetObjValue(formObj.s_payer_nm, "");
			return;
		}	
		ComSetObjValue(formObj.f_cmd, formCmd); 		
		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
		var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
		var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
		if(cust_nm == null || cust_nm == "") {
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_payer_cd, "");
			ComSetObjValue(formObj.s_payer_nm, "");
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetFocus(formObj.s_payer_cd);
		}else{
			ComSetObjValue(formObj.s_payer_cd, ComGetObjValue(formObj.s_cust_cd));
			ComSetObjValue(formObj.s_payer_nm, cust_nm);
		}
        sheetObj.SetWaitImageVisible(1);
    }
	//Multi Combo click event
	function tariff_type_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 
	//Multi Combo click event
	function ar_if_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 	
	//Multi Combo click event
	function invoice_status_OnCheckClick(comboObj, index, code) {
		setMultiCombo(comboObj, index, code) ;
	} 	
	//Multi Combo click event
	function office_OnCheckClick(comboObj, index, code) {
		var formObj=document.form;
   		if (formObj.chk_sub_ofc.checked) {
   			if (comboObj.GetItemCheck(index))
   				comboObj.SetItemCheck(index, 0, false);
   			else
   				comboObj.SetItemCheck(index, 1, false);
   			ComShowCodeMessage('DMT00107');
   		}
		//setMultiCombo(comboObj, index, code) ;
	} 	
	/*
	 * Multi-select the DEM / DET Office of the Sub-mucin (Sub Office) lookup
	 */
	function doInclSubOfc() {
		var formObj=document.form;
		if (formObj.chk_sub_ofc.checked) {	// Sub Office
			if (ComIsEmpty(comboObjects[0].GetSelectCode())) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked=false;
				return;
			}
			formObj.ofc_cd.value=ComGetObjValue(comboObjects[3]);										
			formObj.tmp_ofc_cd.value=ComGetObjValue(comboObjects[3]);									
			doActionIBCombo(sheetObjects[0], formObj, comboObjects[3], COMMAND01)						
		} 
		else {
			comboObjects[3].SetSelectIndex(-1);
			comboObjects[3].SetSelectCode(formObj.tmp_ofc_cd.value);
		}
	} 	
	/*
  	 * Each common pop-up function calls 
  	 */
  	function openPopup(flag, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'issue_usr_id':		// Issue Name Inquiry Popup
					ComOpenPopup('COM_ENS_091.do', 770, 520, "setUsrNm", "1,0,1,1,1,1,1", true);
					break;
	  			case 's_invoice_no':		// CNTR No. Multi-Input pop-up calls
	  			case 's_bkg_no':		// BKG No. Multi-Input pop-up calls
	  			case 's_bl_no':		// B/L No. Multi-Input pop-up calls
		  			var returntitle='';
		  			var sWidth = 0;
		  			var sHeight = 431;
	  				if (flag == 's_bkg_no') {
	  					returntitle='BKG No.';
	  					sWidth = 425;
	  				}
	  				else if(flag == 's_bl_no') {
	  					returntitle='B/L No.';
	  					sWidth = 420;
	  				}
	  				else if(flag == 's_invoice_no') {
	  					returntitle='Invoice No.';
	  					sWidth = 460;
	  				}
	  				var param="?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, sWidth, sHeight, "getDmt_Multi", "1,0", true);
				break;
				
	  			case 's_payer_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 485, "getPayerCd", "1,0,1,1,1,1,1", true);
				break;
	  		} // switch-end
  		} // with-end
  		if(sUrl.indexOf('.do') != -1) {
  			var sWinName=ComReplaceStr(sUrl, '.do', '');
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  		}
  		else if(sUrl != '') {
  			ComOpenWindow(sUrl, "", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=" + sWidth + ",height=" + sHeight + ",left=0,top=0");
  		}
  	}
  	/*
  	 * Issue Name common in the pop-up, select the Issue Name, Issue Code value set in the appropriate fields
  	 */
	function setUsrNm(aryPopupData){
  		document.form.s_issue_usr_id.value=aryPopupData[0][4];
  	}  	
     /*
     * Multi-input pop-up page is closed, then the function is invoked Opener
     * - Set in a field allows multiple inputs.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj=eval("document.form." + return_val);
    	var retStr=rArray.toString().toUpperCase();
    	ComSetObjValue(targObj, retStr);
    }
    function getPayerCd(aryPopupData){
    	document.form.s_payer_cd.value=aryPopupData[0][3];
    	document.form.s_payer_nm.value=aryPopupData[0][4];
    }
    function ofc_inv_click(){
    	//doEnableCondObj(ComGetEvent().value);
    	var formObj=document.form;
   		if (formObj.ofc_inv_chk[0].checked ) {
   			ofc_enable();
    	}else if (formObj.ofc_inv_chk[1].checked ) {
    		inv_enable();
    	}
    }
	/*
	 * Lookup fields to enter information on the screen is stored in a lookup field values.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		ComSetObjValue(formObj.s_issue_ofc, ComGetObjValue(formObj.office));
		ComSetObjValue(formObj.s_dmdt_trf_cd, ComGetObjValue(formObj.tariff_type));
		ComSetObjValue(formObj.s_dmdt_ar_if_cd, ComGetObjValue(formObj.ar_if));
		ComSetObjValue(formObj.s_dmdt_inv_sts_cd, ComGetObjValue(formObj.invoice_status));
		if (formObj.ofc_inv_chk[0].checked ) {
			ComSetObjValue(formObj.s_inv_check, "N");
		}else{
			ComSetObjValue(formObj.s_inv_check, "Y");
		}
		if(sAction == SEARCH || sAction == SEARCH01) {
			ComSetObjValue(formObj.s_cust_cd, ComGetObjValue(formObj.s_payer_cd));
			var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
			if(cust_len > 2) {
				var char_chk=ComGetObjValue(formObj.s_cust_cd).substring(0,2);
				//If the two-digit alphanumeric code, then Retrieving CUSTOMER
				if(ComIsAlphabet(char_chk)) {
					ComSetObjValue(formObj.s_cust_gubun, "2");
				// else Retrieving VENDOR
				}else{
					ComSetObjValue(formObj.s_cust_gubun, "1");
				}
			}
		}		
	}   
	/*
	 * Tool Tip(Issued, Cancelled, Credit)
	 */
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y ) {
		var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		var sName=sheetObj.ColSaveName(sheetObj.MouseCol());
		
		with(sheetObj) {
			
			if (sName == "dmdt_inv_sts_cd") {
				var sText = GetCellText(Row, Col);
				//Help create a balloon message
				if (sText == "I") {
					SetToolTipText(Row, Col, "Issued");
				}
				else if (sText == "C") {
					SetToolTipText(Row, Col, "Credit Note");
				}
				else if(sText == "X") {
					SetToolTipText(Row, Col, "Cancelled");
				}
				else {
					SetToolTipText(Row, Col, "");
				}
				SetMousePointer("Hand");
			} 
			else if (sName == "act_payr_cd") {
				var sText = GetCellText(Row, "act_delt_flg");
				if (sText == "Y") {
					SetToolTipText(Row, Col, "Payer Code not available any more!");
				}
				else {
					SetToolTipText(Row, Col, "");
				}
				SetMousePointer("Hand");
			}
			else if (sName == "act_payr_nm") {
				var sText = GetCellText(Row, "act_delt_flg");
				if (sText == "Y") {
					SetToolTipText(Row, Col, "Payer Code not available any more!");
				}
				else {
					SetToolTipText(Row, Col, "");
				}
				SetMousePointer("Hand");
			}
			else {
				SetToolTipText(Row, Col, "");
			}
		}
	}
	/*
	 * Double-click pop-up(4002)
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var invoice_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_inv_no");
		if (invoice_no.substring(2,3) == "T" || invoice_no.substring(2,3) == "R") {
			var url="EES_DMT_4002.do"
				+"?group_by="+ComGetObjValue(formObj.s_group_by)
				//+"&chg_type="+ComGetObjValue(formObj.s_chg_type)
				+"&ofc_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cre_ofc_cd")
				+"&bkg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no")
				+"&dmdt_trf_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_trf_cd")
				+"&cntr_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "cntr_no")
				+"&invoice_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_inv_no")
				+"&invoice_issue=2"	//Invoice Issue AFTER
				;
//			var returnValue=ComOpenWindowCenter(url, "EES_DMT_4002", "1100","800", true);
			var returnValue = ComOpenWindowCenter(url, "EES_DMT_4002", "1050","700", true);
			if (returnValue == "Y") {
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}
//			if(returnValue == "Y") {
//				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//			}
		}
		else {
			var url="EES_DMT_4004P.do"
				+"?dmdt_inv_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_inv_no")
				+"&caller=4008"
				;
			ComOpenWindowCenter(url, "EES_DMT_4004", "1100","700", true);
		}
	}

    function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg){
        with (sheetObj) {
            if (RowCount() > 0) {
			   searchButton();
		    }
            else {
			   initButton();
		    }
		   //Payer Code if the Code is not valid anymore, looks red, balloon message "Payer Code not available any more!"
		   for (var i=1; i < GetTotalRows()+ 1 ; i++) {
			   if (GetCellValue(i, "act_delt_flg") == "Y") {
				   SetCellBackColor(i,"act_payr_cd","#FF0000");
				   SetCellBackColor(i,"act_payr_nm","#FF0000");
			   }
		   }
        }
    }    
	// multi combo Click Event Catch
 	function office_OnCheckClick(comboObj, index, code) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.GetItemCheck(index))
   				comboObj.SetItemCheck(index,0);
   			else
   				comboObj.SetItemCheck(index,1);
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	// multi combo KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
    		switch(sAction) {
    			case IBSEARCH:
		        	//tariff type Valid check
		        	if(ComGetObjValue(formObj.tariff_type) == "") {
		        		ComAlertFocus(formObj.tariff_type, ComGetMsg('COM12113', "Tariff Type"));
		        		return false;
		        	}
		        	//A/R I/F Valid check
		        	if(ComTrim(ComGetObjValue(formObj.ar_if)) == "") {
		        		ComAlertFocus(formObj.ar_if, ComGetMsg('COM12113', "A/R I/F status"));
		        		return false;
		        	}
		        	//A/R I/F Valid check
		        	if(ComTrim(ComGetObjValue(formObj.invoice_status)) == "") {
		        		ComAlertFocus(formObj.invoice_status, ComGetMsg('COM12113', "Invoice Staus"));
		        		return false;
		        	}
		        	//OFC CHECKED
		        	if (formObj.ofc_inv_chk[0].checked ) {
		        		if(ComTrim(ComGetObjValue(formObj.office)) == "") {
			        		ComAlertFocus(formObj.office, ComGetMsg('COM12113', "Office"));
			        		return false;
			        	}
		        		var fm_dt=ComTrim(ComGetObjValue(formObj.s_issue_fm));
    					var to_dt=ComTrim(ComGetObjValue(formObj.s_issue_to));
    					//null check
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.s_issue_fm, ComGetMsg('DMT02002', "Issued Date"));
    						return false;
    					}
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.s_issue_to, ComGetMsg('DMT02002', "Issued Date"));
    						return false;
    					}
    					//from , to check validation
    					if(ComChkPeriod(fm_dt, to_dt) == 0) {
    			  			ComShowCodeMessage('DMT01048');
    			  			ComSetFocus(formObj.s_issue_fm);
    			  			return false;
    					}
    					//from, to 1 yesr check validation
    					var fm_dt_three_month=ComGetDateAdd(fm_dt, "M", 12);
    					if(ComChkPeriod(to_dt, fm_dt_three_month) == 0) {
    			  			ComShowCodeMessage('COM12133', "To Date", "From Date", "1 year");
    			  			ComSetFocus(formObj.s_issue_fm);
    			  			return false;
    					}
			        //INV CHECKED
		        	}else if (formObj.ofc_inv_chk[1].checked ) {
		        		if(ComIsNull(formObj.s_invoice_no) && ComIsNull(formObj.s_bkg_no) && ComIsNull(formObj.s_bl_no)) {
             				ComShowCodeMessage('DMT00102', 'Invoice No. or BKG No. or B/L No.');
                 			return false;
             			}
             			var invoiceNo=ComGetObjValue(formObj.s_invoice_no);
             			if(invoiceNo != '') {
             				var arrInvoiceNo=invoiceNo.split(',');
             				for(var i=0; i<arrInvoiceNo.length; i++) {
             					if(ComChkLen(arrInvoiceNo[i], 9) == 0) {	// Exceed the length
             						ComAlertFocus(formObj.s_invoice_no, ComGetMsg('COM12173', 'Invoice No.', '9'));
    	                 			return false;
             					}
             				}
             			}
             			var bkgNo=ComGetObjValue(formObj.s_bkg_no);
             			if(bkgNo != '') {
             				var arrBkgNo=bkgNo.split(',');
             				for(var i=0; i<arrBkgNo.length; i++) {
             					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
             						ComAlertFocus(formObj.s_bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
    	                 			return false;
             					}
             				}
             			}
             			var blNo=ComGetObjValue(formObj.s_bl_no);
             			if(blNo != '') {
             				var arrBlNo=blNo.split(',');
             				for(var i=0; i<arrBlNo.length; i++) {
             					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
             						ComAlertFocus(formObj.s_bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
    	                 			return false;
             					}
             				}
             			}
		        	}
    				break;
    		}
        }
        return true;
    }
	/*
	 *  initializing 
	 */		
	function initSearchControls() {
		var formObj=document.form;
		for(var k=0;k<comboObjects.length;k++){
			comboObjects[k].SetSelectCode("-1");
			comboObjects[k].RemoveAll();
		}
		formObj.s_group_by.selectedIndex=0;
		ComSetObjValue(formObj.s_inv_over, 		"0");
		ComSetObjValue(formObj.s_issue_usr_id, 	"");		
		ComSetObjValue(formObj.s_payer_cd, 		"");	
		ComSetObjValue(formObj.s_payer_nm, 		"");
		ComSetObjValue(formObj.s_sc_no, 		"");
		ComSetObjValue(formObj.s_rfa_no, 		"");
		ComSetObjValue(formObj.s_payer_gubun, 		"");
		ComSetObjValue(formObj.s_dmdt_trf_cd, 		"");
		ComSetObjValue(formObj.s_dmdt_ar_if_cd, 	"");
		ComSetObjValue(formObj.s_dmdt_inv_sts_cd, 	"");
		ComSetObjValue(formObj.s_issue_ofc, 		"");
		formObj.ofc_inv_chk[0].checked=true;
	}		    
    /**
     * Click on Tab event-related
     * Elements selected tab is active.
     */
    function Minimize(nItem)
    {
        var objs=document.all.item("showMin");
        if (nItem == "1") {
    	    objs.style.display="none";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(23);
    	    sheetObjects[0].SetSheetHeight(MAX_SHEET_HEIGHT);
    	} 
        else {
    	    objs.style.display="block";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(17);
    	    sheetObjects[0].SetSheetHeight(DEF_SHEET_HEIGHT);
    	}
    }
	/*
	 * search result initializing
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}	
	/*
	 * button initializing
	 */
	function initButton() {
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnEnable("btn_Minimize");
		ComBtnDisable("btn_Detail");
		ComBtnDisable("btn_DownExcel");
	}
	function searchButton() {
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnEnable("btn_Minimize");
		ComBtnEnable("btn_Detail");
		ComBtnEnable("btn_DownExcel");
	}
	/*
	 * htmlControl event initializing 
	 */	
	function initControl() {
		initSearchControls();
		initResultControls();
		//Combo initializing
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		//DATA initializing
		var formObj=document.form;
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST);
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[2], SEARCH15);
		doActionIBCombo(sheetObjects[0], formObj, comboObjects[3], SEARCHLIST02);
		initButton();
	}	
	 
    function callbackNotFound(rtnVal) {			
    	if (rtnVal == "Y") {
    		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
    }
	 