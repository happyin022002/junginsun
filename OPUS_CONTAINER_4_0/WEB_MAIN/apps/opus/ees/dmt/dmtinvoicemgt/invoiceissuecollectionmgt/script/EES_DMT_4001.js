/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_4001.js
*@FileTitle  : Invoice Creation & Issue
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
	var USER_TARIFF_TYPE_CD;
	var ROWMARK="|";
	var FIELDMARK="=";
	var USR_TRF_TP;
	var Mincount=0 ;
	
	var DEF_SHEET_HEIGHT = 397;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 136;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
     	try {
     		var srcObj=ComGetEvent();
     		var srcName=ComGetEvent("name");
             switch(srcName) {
             	case "btns_calendar": //Calendar button
             		var cal=new ComCalendarFromTo();
    	            cal.select(formObject.fm_cfm_dt,  formObject.to_cfm_dt,  'yyyy-MM-dd');
	         		/*if(srcObj.style.cursor == "hand") {
	    	            var cal=new ComCalendarFromTo();
	    	            cal.select(form.fm_cfm_dt,  form.to_cfm_dt,  'yyyy-MM-dd');
	         		}*/
					break;
 				case "btns_multisearch1": 					
	 				openPopup('s_bkg_no'); 					
 					break;						
 				case "btns_multisearch2": 					
 					openPopup('s_bl_no'); 					
 					break;						
 				case "btns_multisearch3": 					
					openPopup('s_cntr_no'); 					
 					break;						
             	case "btns_cust_cd":
             		openPopup('s_cust_cd');
 					break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 					break;
 				case "btn_new":
					initControl();
					date_enable();
					//EnableControls();
 					break;
 				case "btn_minimize":
                    Mincount=(Mincount+1)%2 ;
                    Minimize(Mincount);
 					break;
 				case "btn_group_billing":
 					if(ComIsBtnEnable(srcName)) {
 						openPopupWindow(sheetObject1, formObject, srcName);
 					}
 					break;
 				case "btn_billing":
 					if(ComIsBtnEnable(srcName)) {
 						openPopupWindow(sheetObject1, formObject, srcName);
 					}
 					break;
 				case "btn_downexcel": 
 					if(ComIsBtnEnable(srcName)) {
 						openPopupWindow(sheetObject1, formObject, srcName);
 					}
 					
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
	//comboObjects array generated in the registration page to IB Combo Object
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		initButton();
		
		for (i=0; i<sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		// IBMultiCombo initializing 
	    for (var k=0; k<comboObjects.length; k++){
	        initCombo(comboObjects[k],k+1);
	    }
	    
		initAxonControl();
		
		date_enable();
		
		sheet1_OnLoadFinish(sheetObjects[0]);
	}
	
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj = document.form;
		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST02);	//office
		doActionIBCombo(sheetObj, formObj, comboObjects[1], SEARCHLIST);	//tariff_type
    }
	
	function sheet1_OnSearchEnd(sheetObj,  code, ErrMsg){
		with(sheetObj){
			if(RowCount() > 0) {
				searchButton();
			}
		}
	}
    function condType_click() {
    	//doEnableCondObj(event.srcElement.value);
    	var formObj=document.form;
   		if (formObj.s_cont_type[0].checked ) {
   			date_enable();
    	}else if (formObj.s_cont_type[1].checked ) {
    		cntr_enable();
    	}
    }
    function date_enable(){
    	var formObj=document.form;
		ComEnableObject(formObj.fm_cfm_dt, true);
		ComEnableObject(formObj.to_cfm_dt, true);
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_cntr_no, true);
    	formObj.fm_cfm_dt.className="input1";
    	formObj.to_cfm_dt.className="input1";
    	formObj.s_bkg_no.className="input2";
    	formObj.s_bl_no.className="input2";
    	formObj.s_cntr_no.className="input2";
    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_cntr_no, "");
		ComEnableObject(formObj.btns_calendar, true);
		ComEnableObject(formObj.btns_multisearch1, false);
		ComEnableObject(formObj.btns_multisearch2, false);
		ComEnableObject(formObj.btns_multisearch3, false);
	    //Period Date initializing
		ComSetObjValue(formObj.today_dt, ComGetMaskedValue(formObj.today_dt.value, "ymd"));
		var temp_day=ComGetDateAdd(ComGetObjValue(formObj.today_dt), "M", -1);
		ComSetObjValue(formObj.fm_cfm_dt, temp_day);
		ComSetObjValue(formObj.to_cfm_dt, ComGetObjValue(formObj.today_dt));
		//cntr disabled
		formObj.s_bkg_no.readOnly=true;
		formObj.s_bl_no.readOnly=true;
		formObj.s_cntr_no.readOnly=true;
		//calendar
		formObj.fm_cfm_dt.readOnly=false;
		formObj.to_cfm_dt.readOnly=false;
    }
    function cntr_enable(){
    	var formObj=document.form;
		ComEnableObject(formObj.fm_cfm_dt, true);
		ComEnableObject(formObj.to_cfm_dt, true);
		ComEnableObject(formObj.s_bkg_no, true);
		ComEnableObject(formObj.s_bl_no, true);
		ComEnableObject(formObj.s_cntr_no, true);
    	formObj.fm_cfm_dt.className="input2";
    	formObj.to_cfm_dt.className="input2";
    	formObj.s_bkg_no.className="input1";
    	formObj.s_bl_no.className="input1";
    	formObj.s_cntr_no.className="input1";
    	ComSetObjValue(formObj.s_bkg_no, "");
    	ComSetObjValue(formObj.s_bl_no, "");
    	ComSetObjValue(formObj.s_cntr_no, "");
		ComEnableObject(formObj.btns_calendar, false);
		ComEnableObject(formObj.btns_multisearch1, true);
		ComEnableObject(formObj.btns_multisearch2, true);
		ComEnableObject(formObj.btns_multisearch3, true);
		ComSetObjValue(formObj.fm_cfm_dt, "");
		ComSetObjValue(formObj.to_cfm_dt, "");
		//cntr disabled
		formObj.s_bkg_no.readOnly=false;
		formObj.s_bl_no.readOnly=false;
		formObj.s_cntr_no.readOnly=false;
		//calendar
		formObj.fm_cfm_dt.readOnly=true;
		formObj.to_cfm_dt.readOnly=true;
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
   					SetMultiSelect(0);
   					SetUseAutoComplete(0);
					SetColBackColor(0, "#CCFFFD");
  					SetColBackColor(1, "#CCFFFD");   					
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "70");
   					SetColWidth(1, "290");
   					//SetColWidth(300);
  					SetDropHeight(160);
  					ValidChar(2);		
  					//no support[check again]CLT 					IMEMode=0;
					SetMaxLength(5);
   		    	}   	    		
   				break; 
   	    	case "tariff_type":   	    		
   	    		with (comboObj) {   	    			
   					SetMultiSelect(1);
					SetColBackColor(0, "#CCFFFD");
  					SetColBackColor(1, "#CCFFFD")   					
   					SetColAlign(0, "left");
   					SetColAlign(1, "left");
   					SetColWidth(0, "50");
   					SetColWidth(1, "310");
					SetDropHeight(160);
					ValidChar(2,2);		
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
		switch(sheetNo) {
			case 1:      // sheet1 init
			    with(sheetObj){				        
				      //no support[check again]CLT 					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				      var HeadTitle="||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|Office|Tariff|Payer|Payer|S/C No.|RFA No.|Invoice|Invoice|Charge|Charge|Charge|Charge|Charge|Ex. Rate|gb|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq|delt_rqst";
				      var HeadTitle1="||Seq.|BKG No.|B/L No.|CNTR|CNTR No.|Office|Tariff|Code|Name|S/C No.|RFA No.|Cur.|Billing AMT|Cur.|Incurred AMT|Exception AMT|D/C AMT|Billable AMT|Ex. Rate|gb|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|chg_cust_cnt_cd|chg_cust_seq|delt_rqst";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      //(headCount, 0, 0, true);
		
				      //SetConfig( { SearchMode:2, FrozenCol:savenamecol("cntr_cnt"), MergeSheet:5, Page:20, DataRowMerge:1 } );
				      SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"},
				                  { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"CheckBox",  Hidden:0,  Width:20,    Align:"Center",  ColMerge:1,   SaveName:"CheckBox" },
				             {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ar_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:6,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"gb" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"vsl_cd" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"skd_voy_no" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"skd_dir_cd" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pol_cd" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pod_cd" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"por_cd" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"del_cd" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"chg_cust_cnt_cd" },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"chg_cust_seq" } ];
				       
				      InitColumns(cols);		
				      SetEditable(1);
				      SetEllipsis(1);
				      //no support[check again]CLT 					ToolTipOption="balloon:true;width:50;";
				      SetToolTipText(0,"ar_curr_cd","Amount per A/R Office Currency");
				      SetToolTipText(0,"inv_amt","Amount per A/R Office Currency");
				      SetToolTipText(1,"ar_curr_cd","Amount per A/R Office Currency");
				      SetToolTipText(1,"inv_amt","Amount per A/R Office Currency");
				      SetSheetHeight(DEF_SHEET_HEIGHT);
		      	}
				break;
		}
	}
    function initAxonControl() {
		//axon_event.addListener('mouseover', 'btn_mouseover', 'btn1_billing');	// onMouseover event
		//axon_event.addListener('mouseout', 'btn_mouseout', 'btn1_billing');	// onMouseout event
		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		//axon_event.addListenerFormat('focus',	'obj_focus',	form); // Get focus
		//axon_event.addListenerFormat('blur',	'obj_blur',		form); //- out of focus
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
		var obj=event.srcElement;
		ComClearSeparator(obj);
		//If you have a block of text so as to choose.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }	
   // out of focus
    function obj_blur(){
    	//check inputing Validation + Inserting separator 
		var obj=event.srcElement;
		if(obj.name == 's_bkg_no' || obj.name == 's_bl_no' || obj.name == 's_cntr_no') {
		}else if(obj.name == 's_cust_cd') {
			doActionText(sheetObjects[0], document.form, obj, SEARCH20);
		}else{
			ComChkObjValid(obj);
		}
    }    
    // (button Show balloon message)
	function btn_mouseover() {
		var bak='lightyellow';
		var msg='Invoice Creation & Issue by Booking';
		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
		var x=event.x+document.body.scrollLeft;
		var y=event.y+document.body.scrollTop;
		var skn=document.all("topdeck").style;
		skn.left=x-150;
		skn.top=y+20;
		document.all("topdeck").innerHTML=content;
		skn.visibility='visible';
    }
    // (button Hide balloon message)
	function btn_mouseout() {
		var skn=document.all("topdeck").style;
		skn.visibility='hidden';
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
	  			case 's_bkg_no':		// BKG No. Multi-Input pop-up calls
	  			case 's_bl_no':			// B/L No. Multi-Input pop-up calls
	  			case 's_cntr_no':		// CNTR No. Multi-Input pop-up calls
	  				var returntitle='';
	  				var sWidth  = 0;
	  				var sHeight = 415;
	  				if (flag == 's_bkg_no') {
	  					returntitle='BKG No.';
	  					sWidth = 425;
	  				}
	  				else if(flag == 's_bl_no') {
	  					returntitle='B/L No.';
	  					sWidth = 420;
	  				}
	  				else if(flag == 's_cntr_no') {
	  					returntitle='CNTR No.';
	  					sWidth = 437;
	  				}
	  				var param="?returnval=" + flag + "&returntitle=" + returntitle;
	  				//ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, sWidth, sHeight, "getDmt_Multi", "1,0", true);
	  				return;
					break;
	  			case 's_cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "1,0", true);
					break;
	  		} // switch-end
  		} // with-end
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
    /*
  	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.s_cust_cd.value=aryPopupData[0][3];
    	document.form.s_cust_name.value=aryPopupData[0][4];
    }    
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:     // Search
				//1.Setting parametor condition, before retrieving
				if (sheetObj.id == "sheet1") {
					ComSetObjValue(formObj.f_cmd, SEARCH);
					formObj.s_ofc_cd.value=comboObjects[0].GetSelectCode();
					setParameters(SEARCH);
					if (validateForm(sheetObj,formObj,sAction)) {
						if(ComGetObjValue(formObj.s_group_by) == "1") {
							sheetObj.SetColHidden("cntr_cnt",0);
							sheetObj.SetColHidden("cntr_no",1);
						} else {
							sheetObj.SetColHidden("cntr_cnt",1);
							sheetObj.SetColHidden("cntr_no",0);
						}
	                    //ComOpenWait Start
	                    sheetObj.SetWaitImageVisible(0);
	                    ComOpenWait(true);	                     						
//	                    sheetObj.DoSearch("EES_DMT_4001GS.do", FormQueryString(formObj) );

                        var sXml=sheetObj.GetSearchData("EES_DMT_4001GS.do", FormQueryString(formObj));
                        sheetObj.LoadSearchData(sXml,{Sync:1} );
                        
	                    //ComOpenWait End
	                    ComOpenWait(false);
						// searching date exist  button is activating 
//						if(sheetObj.RowCount() > 0) {
//							searchButton();
//						}
						//var sXml = sheetObj.GetSearchXml("EES_DMT_1001GS.do", FormQueryString(formObj));
					}
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
	 * EES_DMT_4013, EES_DMT_4002 call
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		if (srcName == "btn_billing") {
			var url="EES_DMT_4002.do"
				+"?group_by="+ComGetObjValue(formObj.s_group_by)
				+"&chg_type="+ComGetObjValue(formObj.s_chg_type)
				+"&ofc_cd="+ComGetObjValue(formObj.s_ofc_cd)
				+"&bkg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bkg_no")
				+"&dmdt_trf_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "dmdt_trf_cd")
				+"&invoice_issue=1"	//Invoice Issue BEFORE
				;

			ComOpenPopup(url, "1050", "700", "callbackProc", "0,1", true);
		}
		else if (srcName == "btn_group_billing") {
			if(sheetObj.CheckedRows("CheckBox") == 0) {
     			ComShowCodeMessage('COM12114', 'BKG No');
     			return;
     		}
			var url="EES_DMT_4013.do"
				+"?s_group_by="+ComGetObjValue(formObj.s_group_by)
				+"&s_chg_type="+ComGetObjValue(formObj.s_chg_type)
				+"&jspno=4001"
				;			
			ComOpenPopup(url, "980", "600", "callbackProc", "0,1", true);
		}
	}
    function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		switch(comboObj.options.id) {
			case "office":
				ComSetObjValue(formObj.f_cmd, SEARCHLIST02); 				
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				// Office List
				var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
				var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
	    	    var comboCodeArr=ofc_cds.split("|");
	    	    var comboTextArr=ofc_nms.split("|");
	    	    for (var i=0 ; i < comboTextArr.length ; i++) {
	    	    	comboObj.InsertItem(i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
	         	}
				var usr_ofc_cd=document.form.usr_ofc_cd.value;
				comboObj.SetSelectCode(usr_ofc_cd);
   	  			if(comboObj.GetSelectCode()!= usr_ofc_cd) {
	    	  		comboObj.InsertItem(0, usr_ofc_cd, usr_ofc_cd);
	    	  		comboObj.SetSelectCode(usr_ofc_cd);
   	  			}
    	    break;
    	    
	        case "tariff_type":	     
	        	//var comboObj=comboObjects[1];
		 		// Tariff type comboList
				ComSetObjValue(formObj.f_cmd, SEARCHLIST); 				
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem=comboItems[0].split(FIELDMARK);
				}
				var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);				
				if(data2 == ''){
					data2='CTIC,DMIF';
					comboObj.SetItemCheck(1,1); //DMIF
					comboObj.SetItemCheck(5,1); //CTIC
				}
				comboObj.SetSelectCode(data2,false);
				USR_TRF_TP=data2;
				formObj.usr_trf_tp.value=data2;
				USER_TARIFF_TYPE_CD=data2;				
				/*with (comboObj) {	                
					SetMultiSeparator(",");	                 
				}*/
				//SetMultiSeparator(",");
			break;
        }
        sheetObj.SetWaitImageVisible(1);
    }
    //Payer chek
    /**
     * @param sheetObj
     * @param formObj
     * @param object
     * @param formCmd
     */
    function doActionText(sheetObj, formObj, object, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.s_cust_cd)));
		if(cust_len == 0){
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_name, "");
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
		}else if(cust_len > 0){
			//VENDOR 조회
			ComSetObjValue(formObj.s_cust_gubun, "1");
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_name, "");
			return;
		}		
		ComSetObjValue(formObj.f_cmd, SEARCH20); 		
		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		var cust_cd=ComGetEtcData(sXml, "PAYER_CODE");
		var cust_nm=ComGetEtcData(sXml, "PAYER_NM");
		var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
		if(cust_nm == null || cust_nm == "") {
			ComSetObjValue(formObj.s_cust_gubun, "");
			ComSetObjValue(formObj.s_cust_cd, "");
			ComSetObjValue(formObj.s_cust_name, "");
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetFocus(formObj.s_cust_cd);
		}else{
			ComSetObjValue(formObj.s_cust_cd, cust_cd);
			ComSetObjValue(formObj.s_cust_name, cust_nm);
		}
        sheetObj.SetWaitImageVisible(1);
    }
    /**
     * Data in the field adds a combo.
     */	
 	function addComboItem(comboObj,comboItems) {
 		switch(comboObj.options.id) {
 			case "tariff_type":
		  		comboObj.InsertItem(0, "All|All", "All");
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}		  		
		  		break;
 		}
 	}

 	 var selComboIndex, selComboCode;
 	 function tariff_type_OnSelect(comboObj ,index, text , code) {
 	  selComboIndex = index;
 	  selComboCode = code;
 	 }
 	 function tariff_type_OnChange(comboObj) {
 	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
 	 }
 	 

	/*
	 * Double-click pop-up(Billing)
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
		var formObj=document.form;
		var url="EES_DMT_4002.do"
			+"?group_by="+ComGetObjValue(formObj.s_group_by)
			+"&chg_type="+ComGetObjValue(formObj.s_chg_type)
			+"&ofc_cd="+ComGetObjValue(formObj.s_ofc_cd)
			+"&bkg_no="+sheetObj.GetCellValue(Row, "bkg_no")
			+"&dmdt_trf_cd="+sheetObj.GetCellValue(Row, "dmdt_trf_cd")
			+"&cntr_no="+sheetObj.GetCellValue(Row, "cntr_no")
			+"&invoice_issue=1"	//Invoice Issue BEFORE
			;

        ComOpenPopup(url, "1050", "700", "callbackProc", "0,1", true);
//		var returnValue=ComOpenWindowCenter(url, "EES_DMT_4002", "1036","700", true);
//		if(returnValue == "Y") {
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//		}
	}
//    function sheet1_OnClick(sheetObj, row, col, Value){
//        if(sheetObj.ColSaveName(col) == "CheckBox")
//              ComSyncAllCheck(sheetObj, col, Value);
//    }	
  	/**
     * IBSHeet mouse click in the data area that occurs when cells Event<br>
     * @param {sheetObj} String : IBSheet cell name
     * @param {Row} Long : Row Index of the cell
     * @param {Col} Long : Column Index of the cell
     * @param {Value} String : Values ??have changed, Format does not apply the values ??to be used when saving
     * @param {CellX} Long : X coordinate of the cell
     * @param {CellY} Long : Y coordinate of the cell
     * @param {CellW} Long : Value of the width of the cell
     * @param {CellH} Long : Vertical height of the cell values
     */
	 function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
		 with(sheetObj) {
			 if (ColSaveName(Col) != "CheckBox") {
				// Check Box Check that row when clicked
                //"/" Separator connected to get row number of the selected row, the result: "3/4/5"
				var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "CheckBox")) {
                            SetCellValue(arr[i], "CheckBox","1",0);
                        }
                    }
                    if (CheckedRows("CheckBox") == RowCount()) {
					    for(var i=0 ; i < HeaderRows(); i++)
							SetHeaderCheck(i,"CheckBox",1);
                    }
                }
            } else {
            	// All Check box Status synchronization
            	ComSyncAllCheck(sheetObj, Col, Value);
            }
		 }
	 }
	/*
	 * Lookup fields to enter information on the screen is stored in a lookup field values.
	 */		
	function setParameters(sAction) {
		var formObj=document.form;
		ComSetObjValue(formObj.s_ofc_cd, ComGetObjValue(office));
		ComSetObjValue(formObj.s_dmdt_trf_cd, ComGetObjValue(tariff_type));
		if(sAction == SEARCH) {
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
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
    	var msg="";
    	with(formObj) {
    		switch(sAction) {
    			case IBSEARCH:     // Search
    				//Check mandatory input(office)
//    				if(office.GetSelectText()== '') {
    				if(ComGetObjValue(formObj.office) == "") {
		        		ComAlertFocus(office, ComGetMsg('DMT02002', "Office"));
		        		return false;
		        	}
    				//Check mandatory input(Tariff Type)
//    				if(tariff_type.GetSelectText() == "") {
    				if(ComGetObjValue(formObj.tariff_type) == "") {
		        		ComAlertFocus(tariff_type, ComGetMsg('DMT02002', "Tariff Type"));
		        		return false;
		        	}
    				//Date checked
    				if(formObj.s_cont_type[0].checked) {
    					var fm_dt=ComTrim(ComGetObjValue(formObj.fm_cfm_dt));
    					var to_dt=ComTrim(ComGetObjValue(formObj.to_cfm_dt));
    					//null check
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.fm_cfm_dt, ComGetMsg('DMT02002', "Confirmed Date"));
    						return false;
    					}
    					if(fm_dt == "") {
    						ComAlertFocus(formObj.to_cfm_dt, ComGetMsg('DMT02002', "Confirmed Date"));
    						return false;
    					}
    					//from , to:Check validation
    					if(ComChkPeriod(fm_dt, to_dt) == 0) {
    			  			ComShowCodeMessage('DMT01048');
    			  			ComSetFocus(formObj.fm_cfm_dt);
    			  			return false;
    					}
    					//from, to : :Check validation 3 months
    					var fm_dt_three_month=ComGetDateAdd(fm_dt, "M", 3);
    					if(ComChkPeriod(to_dt, fm_dt_three_month) == 0) {
    			  			ComShowCodeMessage('COM12133', "To Date", "From Date", "3 month");
    			  			ComSetFocus(formObj.fm_cfm_dt);
    			  			return false;
    					}
    				//CNTR checked
    				} else if(formObj.s_cont_type[1].checked) {
             			if(ComIsNull(formObj.s_bkg_no) && ComIsNull(formObj.s_bl_no) && ComIsNull(formObj.s_cntr_no)) {
             				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
                 			return false;
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
             			var cntrNo=ComGetObjValue(formObj.s_cntr_no);
             			if(cntrNo != '') {
             				var arrCntrNo=cntrNo.split(',');
             				for(var i=0; i<arrCntrNo.length; i++) {
             					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// Exceed the length
             						ComAlertFocus(formObj.s_cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
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
    /**
     * Click on Tab event-related
     * Elements selected tab is active.
     */
    function Minimize(nItem) {
        var objs=document.all.item("showMin");
        if (nItem == "1") {
    	    objs.style.display="none";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(24);
    	    sheetObjects[0].SetSheetHeight(MAX_SHEET_HEIGHT);
    	}
    	else {
    	    objs.style.display="block";
    	    //sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(19);
    	    sheetObjects[0].SetSheetHeight(DEF_SHEET_HEIGHT);
    	}
    }
	/*
	 *  initializing 
	 */		
	function initSearchControls() {
		var formObj=document.form;
		for(var k=0;k<comboObjects.length;k++){
			//initCombo(comboObjects[k],k+1);
			comboObjects[k].SetSelectCode("-1");
			comboObjects[k].RemoveAll();
		}
		formObj.s_group_by.selectedIndex=0;
		formObj.s_chg_type.selectedIndex=0;
		ComSetObjValue(formObj.s_ofc_cd, 		"");
		ComSetObjValue(formObj.s_dmdt_trf_cd, "");
		ComSetObjValue(formObj.fm_cfm_dt, 	"");		
		ComSetObjValue(formObj.to_cfm_dt, 	"");		
		ComSetObjValue(formObj.s_bkg_no, 		"");
		ComSetObjValue(formObj.s_bl_no, 		"");
		ComSetObjValue(formObj.s_cntr_no, 	"");
		ComSetObjValue(formObj.s_sc_no, 		"");
		ComSetObjValue(formObj.s_rfa_no, 		"");
		ComSetObjValue(formObj.s_cust_cd, 	"");
		ComSetObjValue(formObj.s_cust_name, 	"");
		formObj.s_cont_type[0].checked=true;
	}		
	/*
	 * result initializing
	 */
	function initResultControls() {
		sheetObjects[0].RemoveAll();
	}	
	/*
	 * button initializing
	 */
	function initButton() {
		ComBtnDisable("btn_group_billing");
		ComBtnDisable("btn_billing");
		ComBtnDisable("btn_downexcel");
	}
	function searchButton() {
		ComBtnEnable("btn_group_billing");
		ComBtnEnable("btn_billing");
		ComBtnEnable("btn_downexcel");
	}
	/*
	 * htmlControl event initializing 
	 */	
	function initControl() {
		// search initializing
		initSearchControls();
		// search result initializing
		initResultControls();
		// IBMultiCombo initializing 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		//DATA initializing
    	var formObj=document.form;    	
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], SEARCHLIST02);	//office
    	doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCHLIST);		//tariff_type
	    //Button initializing
	    initButton();
	}	

    function callbackProc(rtnVal) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
