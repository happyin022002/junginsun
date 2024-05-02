/*=========================================================
**Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3001.js
*@FileTitle  : Charge Calculation by Office & VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_dmt_3001 : : business script for EES_DMT_3001 .
     */
    function ees_dmt_3001() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
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
	//  Tariff Type Set-Up by User
	var USR_TRF_TP;
	var DEF_SHEET_HEIGHT = 296;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 153;
	// Event handler processing by button click event 
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
          /***** case in Sheet count are more two by Tab, defining adding sheet *****/
          var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcObj=ComGetEvent();
     		var srcName=srcObj.getAttribute("name");
     		// Click on the button at the bottom of the grid is disabled, just return on
     		if(!ComIsBtnEnable(srcName)) return;
             switch(srcName) {
             	case "btns_calendar": //Calendar button
             			var cal=new ComCalendarFromTo();
                        cal.select(formObj.fm_mvmt_dt1, formObj.to_mvmt_dt1, 'yyyy-MM-dd');
					break;
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObj,formObj,IBSEARCH);
 					break;
 				case "btn_New":
 					doInit();	// Retrieving conditions initializing
 					break; 
 				case "btn_Minimize":
 					var schCondDiv=document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {
 						schCondDiv.style.display='none';
 						sheetObj.SetSheetHeight(MAX_SHEET_HEIGHT);
 					} else {
 						schCondDiv.style.display='block';
 						sheetObj.SetSheetHeight(DEF_SHEET_HEIGHT);
 					}
 					break;
 				case "btn_Confirm":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
 				case "btn_Demand":
 					openPopup('demand');
 					break;
 				case "btn_GRPDemand":
 					openPopup('grp_demand');
 					break;
 				case "btn_Billing":
 					openPopup('billing');
 					break;
 				case "btn_GRPINVCreation":
 					openPopup('grp_inv_cre');
 					break;
 				case "btn_OFCTrans":
 					openPopup('ofc_trans');
 					break;	
 				case "btn_Delete":
 					doActionIBSheet(sheetObj,formObj,IBDELETE);
 					break;
 				case "btn_ByETA":
 					openPopup('by_eta');
 					break;
 				case "btn_ByBKG":
 					openPopup('by_bkg');
 					break;
 				case "btn_ByCNTR":
 					openPopup('by_cntr');
 					break;
 				case "btn_MVMTInq":
 					openPopup('mvmt_inq');
 					break;
 				case "btn_ExceptionInq":
 					openPopup('by_excinq');
 					break;
 				case "btn_DownExcel":
 					if(sheetObj.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
 					}					
 					break;
 				case "btn_Close":
 					ComClosePopup(); 
					break;
 				case "btn_Recalc":
 					doActionIBSheet(sheetObj,formObj,COMMAND01);
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
    	 var formObj=document.form;
    	 //Displays a pop-up title at the call handling
    	 if(ComGetObjValue(formObj.call_flag) == "P") {
        	 var spanObj=document.getElementById("title2");
        	 spanObj.innerText=" Charge Calculation by Office/VVD";
        	 ComSetDisplay('btnCloseLayer', true);
    	 }
    	 for(var i=0;i<sheetObjects.length;i++){
    		 ComConfigSheet (sheetObjects[i] );
    		 initSheet(sheetObjects[i],i+1);
    		 ComEndConfigSheet(sheetObjects[i]);
    	 }
		// IBMultiCombo initializing 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		//initializing html control event
		initControl();
		
		var formObj=document.form;
   		var sheetObj=sheetObjects[0];
   		// Office MultiCombo List
   		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST02);
   		// Tariff Type MultiCombo List
 		doActionIBCombo(sheetObj, formObj, comboObjects[1], SEARCHLIST);
 		// Retrieving conditions initializing
 		doInit();
     }
     function initControl() {
		axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- out of focus
//		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- Get focus
		//axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard
		axon_event.addListener('click', 'condType_click', 'cond_type');
		axon_event.addListener('click', 'byPODDTA_click', 'bypodeta');
		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListener('mouseover', 'btn_mouseover', 'btn_ByETA');	// 'by ETA' button  onMouseover event
		axon_event.addListener('mouseout', 'btn_mouseout', 'btn_ByETA');	// 'by ETA' button  onMouseout event
		axon_event.addListener('keydown',	'obj_keydown',		'form');
     }

 	function obj_keydown() {
 		var keyValue=ComGetEvent("keycode");
 		if (keyValue != 13) return;
 		var obj=ComGetEvent();
 		var formObj=document.form;
 		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 	}
     // 'by ETA' onMouseover event  (button Show balloon message)
     function btn_mouseover() {
    	 var bak='lightyellow';
    	 var msg='Manual Batch by POD ETA';
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
     // 'by ETA' onMouseout event  (button hide balloon message)
     function btn_mouseout() {
    	 var skn=document.all("topdeck").style;
    	 skn.visibility='hidden';
     }
     // [by POD ETA] Checkbox click event 
     function byPODDTA_click() {
    	 var obj=ComGetEvent();
    	 doEnableByPODETA(obj);
     }
     // [by POD ETA] Checkbox click event
     function doEnableByPODETA(obj) {
    	 var formObj=document.form;
    	 // VVD CD, CNTR : Checking by POD ETA
    	 if(obj.checked) {
    		 comboObjects[0].SetEnable(0);
    		 comboObjects[1].SetSelectCode('DMIF');
    		 comboObjects[1].SetEnable(0);
    		 comboObjects[2].SetSelectCode('');
    		 comboObjects[2].SetEnable(0);
    		 status_OnCheckClick(comboObjects[2], 0, '');
    		 // After initializing the existing input the item, inactivated
    		 with(formObj) {
    			 ComClearManyObjects(chg_type, fx_ft_ovr_dys);
    			 ComClearManyObjects(cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
    			 ComEnableManyObjects(false, chg_type, fx_ft_ovr_dys);
	    		 ComEnableManyObjects(false, cust_type, cust_cd, btns_search1, svc_provdr, btns_search2, sc_no, rfa_no);
	    		 // VVD CD 
	        	 if(obj.value == 'vvd_cd') {
		    		 ComEnableObject(dem_type, false);
		    		 DmtComSetClassManyObjects('input1', tmnl_cd);
	        	 } else { // CNTR
	        		 ComEnableObject(cntr_no, false);
	        		 ComClearObject(cntr_no);
	        		 formObj.cntr_no.className='input2';
	        		 ComEnableObject(btns_multisearch3, false);
	    	 	 }
    		 } // with-end
		 } else {
			 comboObjects[0].SetEnable(1);
			 comboObjects[1].SetEnable(1);// Tariff Type Combo
			 comboObjects[1].SetSelectCode(USR_TRF_TP);// Tariff Type Combo --> User Setup Tariff Type initializing
    		 comboObjects[2].SetEnable(1);// Status Combo
    		 comboObjects[2].SetSelectCode('F');
			 // Enable the disabled item state the search criteria
    		 with(formObj) {
    			 ComSetObjValue(fx_ft_ovr_dys, "0");
    			 ComEnableManyObjects(true, chg_type, fx_ft_ovr_dys);
	    		 ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
	    		 ComEnableManyObjects(true, cust_type, cust_cd, btns_search1, svc_provdr, btns_search2, sc_no, rfa_no);
				 if(obj.value == 'date') {
					 status_OnCheckClick(comboObjects[2], 1, 'F');
				 } else if(obj.value == 'vvd_cd') {
					 // VVD CD
					 ComEnableObject(dem_type, true);		// Dem Type selectbox activating
					 DmtComSetClassManyObjects('input', tmnl_cd);
					 ComClearObject(dem_type);
				 } else	{
					 // CNTR
					 ComEnableObject(cntr_no, true);
	    			 formObj.cntr_no.className='input1';
	    			 ComEnableObject(btns_multisearch3, true);
				 }
    		 } // with - end
		 }
     }
     function condType_click() {
    	 doEnableCondObj(ComGetEvent("value"));
     }
     function doEnableCondObj(condType) {
    	 var formObj=document.form;
    	 with (formObj) {
    		 if(bypodeta[0].checked) {
    			bypodeta[0].checked=false;
    			doEnableByPODETA(bypodeta[0]);
    		 }
    		 if(bypodeta[1].checked) {
    			bypodeta[1].checked=false;
    			doEnableByPODETA(bypodeta[1]);
    		 }
	    	 switch(condType){
	    	 	case "date":
	    	 		ComEnableManyObjects(true, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd, dem_type, bypodeta[0]);	//VVD CD: Disable
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no, bypodeta[1]);		//CNTR: Disable
	    	 		DmtComSetClassManyObjects('input2', vvd_cd, tmnl_cd, bkg_no, bl_no, cntr_no, dem_type); //deactivating class (input2)
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].SetEnable(1);//Date YD
	    	 		//comboObjects[4].Enable = false; //VVD CD YD
	    	 		//===> Search conditions(VVD CD, CNTR) Clear
	    	 		ComSetObjValue(yard_fmto, "yard_fm");
	    	 		ComClearManyObjects(vvd_cd, tmnl_cd, dem_type);		//VVD CD
	    	 		//comboObjects[4].RemoveAll();						//VVD CD
	    	 		ComClearManyObjects(bkg_no, bl_no, cntr_no);		//CNTR
	    	 		ComEnableManyObjects(true, cust_type, cust_cd, svc_provdr, sc_no, rfa_no);
	    	 		break;
	    	 	case "vvd_cd":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(true, vvd_cd, tmnl_cd, dem_type, bypodeta[0]);
	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no, bypodeta[1]);
	    	 		DmtComSetClassManyObjects('input1', vvd_cd); 			//Display mandatory item
	    	 		DmtComSetClassManyObjects('input2', yd_cd, bkg_no, bl_no, cntr_no);
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].SetEnable(0);//Date YD
	    	 		//comboObjects[4].Enable = false;	//VVD CD YD
	    	 		// Search conditions(Date, CNTR) Clear
	    	 		comboObjects[3].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, bkg_no, bl_no, cntr_no);	//CNTR
	    	 		setDemType();
	    	 		break;
	    	 	case "cntr":
	    	 		ComEnableManyObjects(false, yard_fmto[0], yard_fmto[1], yd_cd);
	    	 		ComEnableManyObjects(false, vvd_cd, tmnl_cd, dem_type, bypodeta[0]);
	    	 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no, bypodeta[1]);
	    	 		DmtComSetClassManyObjects('input1', bkg_no, bl_no, cntr_no); //Display mandatory item
	    	 		DmtComSetClassManyObjects('input2', yd_cd, vvd_cd, tmnl_cd, dem_type);
	    	 		setStatusCombo(condType);
	    	 		comboObjects[3].SetEnable(0);//Date YD
	    	 		//comboObjects[4].Enable = false;	//VVD CD YD
	    	 		//===> Search conditions(Date, VVD CD) Clear
	    	 		comboObjects[3].RemoveAll();		//Date
	    	 		ComClearManyObjects(yd_cd, vvd_cd, tmnl_cd, dem_type);	//VVD CD
	    	 		//comboObjects[4].RemoveAll();							//VVD CD
	    	 		break;
	    	 }
	    	 // Pop-up call 'by POD ETA' check box is disabled
	    	 if(ComGetObjValue(call_flag) == 'P')
	    		 ComEnableManyObjects(false, bypodeta[0], bypodeta[1]);
	    	 // Period Activation
	    	 if(condType == 'date') {
	    		 ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1);
	    		 document.form.btns_calendar.disabled = false;
	    		 DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
	    		 //Period Date initializing
	    		 //Retrieves the current date of User Office
	    		 var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj);
	    		 var fmMvmtDt=ComGetDateAdd(ofcCurrDate, "D", -15);
	    		 var toMvmtDt=ofcCurrDate;
	    		 ComSetObjValue(fm_mvmt_dt1, fmMvmtDt);
	    		 ComSetObjValue(to_mvmt_dt1, toMvmtDt);
	    	 } else {
	    		 ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1);
	    		 document.form.btns_calendar.disabled = true;
	    		 DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
	    		 ComClearManyObjects(fm_mvmt_dt1, to_mvmt_dt1);
	    	 }
	    	 // activate the link icon of Multi-input pop-up window (case in CNTR)
	    	 if(condType == 'cntr') {
	    		 ComEnableManyObjects(true, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 } else {
	    		 ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
	    	 }
    	 } // with - end
    }
    function setStatusCombo(condType) {
    	var comboObj=comboObjects[2];
    	var orgCode=comboObj.GetSelectCode();
    	if (condType=='date') {
    		if (comboObj.GetItemCount() != 5) {
    			comboObj.RemoveAll();
    			initCombo(comboObj, 3);
    		}
    	 } 
    	else {
    		 if (comboObj.GetItemCount() != 4) {
    			 comboObj.RemoveAll();
    			 initCombo(comboObj, 4);
    			 if(orgCode.indexOf('R') != -1) {
    				 orgCode=ComReplaceStr(orgCode, 'R', 'L');
    				// ('All') items check
    				 if(orgCode == 'F,E,L')
    					 orgCode='A,F,E,L';
    			 }
    		 }
    	}
    	comboObj.SetSelectCode(orgCode);
    	 
    	//Status 콤보항목에 선택된 값에 대한 변경이 발생된 경우, 전체선택여부를 체크해서 'All' 항목을 선택 및 해제처리해준다.
    	if (DmtComIsComboAllCheck(comboObj)) {
    		
    		 comboObj.SetItemCheck(0, true);
    	 }
     }
	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
//no support[check again]CLT 	function sheet1_OnLoadFinish() {
   		
//	}
	/*
	 * INIT SETTING 
	 */
   	function doInit() {
   		var formObj=document.form;
   		var sheetObj=sheetObjects[0];
   		sheetObj.CheckAll("chk",0);
   		ComResetAll();
		doEnableByPODETA(formObj.bypodeta[0]);
		// route calls screen( 'M'enu / 'P'opup )
		var callFlag=ComGetObjValue(formObj.call_flag);
		if(callFlag == 'M') {
			// Retrieving conditions Partly to enable / disable processing
			doEnableCondObj("date");
		} else {
			// when called EES_DMT_4005.do Screen, Parameters passed to the Retrieving conditions in the data set to pop up
			// Retrieving conditions Partly to enable / disable processing
			formObj.cond_type[2].checked=true;
			doEnableCondObj("cntr");
			initComboValue_office();
			initComboValue_tariff_type();
			initComboValue_status();
			// Several CNTR No reads from the operner page.
			var opener=window.dialogArguments;
			if (!opener) opener=parent;
			ComSetObjValue(formObj.cntr_no, opener.document.form.cntr_nos.value);
		}
		
		var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
		// Activates the corresponding objects.
		ComEnableManyObjects(true, formObj.cond_type[0], formObj.cond_type[1], formObj.cond_type[2]);
		initBtns();
		
		initComboStatus(comboObjects[2]);
   	}
   	// button status initializing
	function initBtns() {
		DmtComEnableManyBtns(false, "btn_Confirm", "btn_Recalc", "btn_Demand", "btn_GRPDemand", "btn_Billing", "btn_GRPINVCreation", "btn_OFCTrans"
									,"btn_Delete", "btn_ByETA", "btn_ByBKG", "btn_ByCNTR", "btn_MVMTInq", "btn_ExceptionInq", "btn_DownExcel");
	}
   	// IBMultiCombo Office initializing
   	function initComboValue_office() {
   		var formObj=document.form;
   		if(ComGetObjValue(formObj.call_flag)=='M') {
   			comboObjects[0].SetEnable(1);
   	   		ComSetObjValue(comboObjects[0], formObj.usr_ofc_cd.value);
   		} else {
   			comboObjects[0].SetEnable(0);
   			comboObjects[0].SetSelectCode(ComGetObjValue(formObj.ofc_cd));
   		}
   	}
   	// IBMultiCombo Tariff Type initializing
   	function initComboValue_tariff_type() {
   		var formObj=document.form;
   		if(ComGetObjValue(formObj.call_flag)=='M') {
	   		comboObjects[1].SetEnable(1);
	   		comboObjects[1].SetSelectCode(USR_TRF_TP);
	   		ComSetObjValue(formObj.usr_trf_tp, USR_TRF_TP);
   		} else {
   			comboObjects[1].SetEnable(0);
	   		ComSetObjValue(comboObjects[1], formObj.dmdt_trf_cd.value);
   		}
   	}
   	// IBMultiCombo Status initializing
   	function initComboValue_status() {
   		var formObj=document.form;
   		if(ComGetObjValue(formObj.call_flag)=='M') {
	   		comboObjects[2].SetEnable(1);
	   		ComSetObjValue(comboObjects[2], "F");
   		} else {
   			comboObjects[2].SetEnable(0);
	   		ComSetObjValue(comboObjects[2], formObj.dmdt_chg_sts_cd);
   		}
   	}
	// IBMultiCombo YardCode2 initializing
   	function initComboValue_yd_cd2() {
   		comboObjects[3].RemoveAll();
   	}
   	// IBMultiCombo TerminalCode2 initializing
//   	function initComboValue_tmnl_cd2() {
//   		comboObjects[4].RemoveAll();
//   	}
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
     /**
      * HTML Control Foucs in
      */
	function obj_focus(){
		var obj=ComGetEvent();
		//ComClearSeparator(obj);
		//If you have a block of text so as to choose.
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
	//business javascript OnKeyPress event handling
	function obj_keypress() {
    	 switch(ComGetEvent("dataformat")){
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
	/*
	 *  Check code Validation : Yard, Port(Location) KeyUp event function
	 */
	function obj_keyup() {
		var srcObj=ComGetEvent();
		checkLocYdCd(srcObj);
	}
	/*
	 *   Check code Validation : Yard, Port(Location) 
	 */
	function checkLocYdCd(srcObj) {
		var formObj=document.form;
		var cd=ComTrim(ComGetObjValue(srcObj));
		if (cd.length == 5) {
			//var comboObj = (srcObj.name == 'yd_cd') ? comboObjects[3]:comboObjects[4];
			var comboObj=comboObjects[3];
			if(srcObj.name == 'yd_cd') {
				formObj.yd_cd1.value=cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCH14, srcObj);
				if(comboObj.GetItemCount() == 0) {
					formObj.loc_cd.value=cd;
					doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, formObj.tmnl_cd);
				}
			} else {
				formObj.loc_cd.value=cd;
				doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND07, srcObj);
			}
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
					SetSelectionMode(smSelectionList);
					var HeadTitle1=" ||Seq.|STS|CNTR No.|T/S|From YD|To YD|Fm|To|Tariff|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT";
					HeadTitle1 += "|Billable AMT|BKG No.|B/L No.|VVD CD|Lane|POR|POL|POD|DEL|R|D|S/C No.|RFA No.|A/Cust.|G/B|S.O.C|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O";
					HeadTitle1 += "|Payer CD|Payer Name|SHPR CD|Shipper Name|CNEE CD|Cosignee Name|NTFY CD|Notify Name|A/R Cust.|A/R Actual Payer Name|S/P CD|Service Provider Name";
					HeadTitle1 += "|svr_id|cntr_cyc_no|dmdt_chg_loc_div_cd|chg_seqe|ofc_cd|ofc_rhq_cd|ar_curr_cd";
					var headCount=ComCountHeadTitle(HeadTitle1);
					SetConfig( { SearchMode:2, FrozenCol:SaveNameCol("cntr_tpsz_cd"), MergeSheet:5, Page:20, DataRowMerge:1,FrozenCol:5 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
					 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lane",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"acust",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"General/Balance Charge Type"},
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"li",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Local/Intransit DEM Type"},
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Carrier's Haulage"},
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d_o",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Cargo Release"},
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ofc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Cargo Release Office"},
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"clt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ofc_trns_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Office Transferred'"},
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"roll_ovr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"Roll Over due to Carrier Schedule Change"},
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"payer_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"shipper_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shipper_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ntfy_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_act_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ar_act_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"svc_provdr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"svc_provdr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ar_curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(DEF_SHEET_HEIGHT);//120;
					SetEditable(1);
					SetEllipsis(1);
				}
				break;
			case 2:      // Hidden Sheet(4013 - GRP INV Creation )
				with(sheetObj){
					var HeadTitle="||Seq.|bkg_no|bl_no|cntr_cnt|cntr_no|gb|ofc_cd|dmdt_trf_cd|cust_cd|sc_no|rfa_no|ar_curr_cd|inv_amt|bzc_trf_curr_cd|org_chg_amt|sc_rfa_expt_amt" + "|aft_expt_dc_amt|bil_amt|inv_xch_rt|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|vvd_cd|payer_cd";
					SetConfig( { SearchMode:2, FrozenCol:SaveNameCol("cntr_cnt"), MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"CheckBox" },
					 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"gb",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rfa_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ar_curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bil_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:6,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"por_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"del_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd" },
					 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd" } ];
					   
					InitColumns(cols);
					SetSheetHeight(130);
					SetEditable(1);
				}
	            break;
         }
     }
	/**
   	 * Initializing Combo 
   	 * param : comboObj , comboNo
   	 * adding case as numbers of counting Combos
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj=document.form;
   	    switch(comboObj.options.id) {  
   	    	case "office": 
   	    		with (comboObj) { 
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "70");
					SetColWidth(1, "250");
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					SetDropHeight(160);
  					ValidChar(2);	// upper case
					SetMaxLength(6);
   		    	}
   				break; 
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					SetMultiSelect(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "310");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
   		    	}
   				break; 
   	    	case "combo_status":
   	    		with (comboObj) { 
   	    			if(comboNo==3) {
	   					SetMultiSelect(1);
						SetColAlign(0, "left");
						SetColAlign(1, "left");
						SetColWidth(0, "110");
						SetColWidth(1, "150");
						SetDropHeight(160);
						SetColBackColor(0,"#CCFFFD");
	  					SetColBackColor(1,"#CCFFFD");
						addComboItem(comboObj, comboNo);
						//Code = "F";
   	    			} else {
   	    				SetMultiSelect(1);
						SetColAlign(0, "left");
						SetColWidth(0, "110");
						SetColWidth(1, "0");
   						SetDropHeight(160);
   						SetColBackColor(0,"#CCFFFD");
   						addComboItem(comboObj, comboNo);
   						//Code = "F";
   	    			}
   		    	}
   	    		break;
   	    	case "yd_cd2":
   	    	case "tmnl_cd2":
   	    		with (comboObj) { 
   	    			SetMultiSelect(0);
  					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "50");
  					SetDropHeight(160);
   		    	}
   	    		break;
   	     }
   	}
   	/**
   	 * Process of Sheet
   	 */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:     // Search
            	if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
            	if(formObj.bypodeta[0].checked || formObj.bypodeta[1].checked)
            		formObj.f_cmd.value=SEARCH01;
            	else
            		formObj.f_cmd.value=SEARCH;
            	formObj.ofc_cd.value=comboObjects[0].GetSelectCode();
            	// Tariff Type
            	var trf_tp=comboObjects[1].GetSelectCode();
            	if(trf_tp.indexOf('All') != -1)
            		trf_tp=ComReplaceStr(trf_tp, "All,", "");
            	formObj.dmdt_trf_cd.value=trf_tp;
            	formObj.dmdt_chg_sts_cd.value=comboObjects[2].GetSelectCode();
            	if(formObj.fx_ft_ovr_dys.value == '') formObj.fx_ft_ovr_dys.value='0';
            	
            	//sheetObj.DoSearch("EES_DMT_3001GS.do", FormQueryString(formObj));	// + "&" + ComGetPrefixParam(prefix) );
            	var sXml = sheetObj.GetSearchData("EES_DMT_3001GS.do", FormQueryString(formObj));
            	sheetObj.LoadSearchData(sXml, {Sync:1});	
            	
            	ComOpenWait(false);
               	for (var j=1; j<=sheetObj.RowCount(); j++) {
               		var req_stu = sheetObj.GetCellValue(j,"dmdt_delt_rqst_sts_cd");
   		            if (req_stu =='R') {
   		            	sheetObj.SetCellFontColor(j, "dmdt_chg_sts_cd","#1E90FF");
   		            	sheetObj.SetCellFont("FontBold", j, 3,1);
   		            }
   		            else if (req_stu =='J') {
   		        	    sheetObj.SetCellFontColor(j, "dmdt_chg_sts_cd","#FF0000");
   		        	    sheetObj.SetCellFont("FontBold", j, 3,1);
   		            }
   		            else { 
   		            	sheetObj.SetCellFontColor(j, "dmdt_chg_sts_cd","#000000");
   		            }
	            }				
	        break;
            
 			case IBSAVE:        // Confirm
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	 			sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
 				formObj.f_cmd.value=MULTI;
		      	sheetObj.DoSave("EES_DMT_3001GS.do", FormQueryString(formObj), "chk");
		      	ComOpenWait(false);
            break;
            
 			case IBDELETE:      // Delete
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				openPopup('delete');
            break;
            
	        case COMMAND01:		// Recalculation 
		        if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	         	ComOpenWait(true);
				formObj.f_cmd.value=COMMAND01;
	         	ComSetObjValue(formObj.backendjob_id, "RECALC");
	         	var params=sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3001GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}	
			break;		
         }
     }
     function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
    	 sheetObj.ShowDebugMsg(false);
    	 sheetObj.SetWaitImageVisible(0);
    	 formObj.f_cmd.value=formCmd;
    	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 switch(comboObj.options.id) {
 	       case "office":
 	    	   	// Office List
				var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
				var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
	    	    var comboCodeArr=ofc_cds.split("|");
	    	    var comboTextArr=ofc_nms.split("|");
	    	    // login User Office is Default - if not exists in combo list, then add item 
    	  		var usrOfcCd=formObj.usr_ofc_cd.value;
    	  		var idx=0; 
	    	    if(ofc_cds.indexOf(usrOfcCd) == -1) {
	    	    	comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
	    	    	idx=1;
	    	    }
	    	    for (var i=0 ; i < comboTextArr.length ; i++) {
	    	    	comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i].toString());		
	         	}
	    	    comboObj.SetSelectCode(usrOfcCd);
	    	    break;
 	        case "tariff_type":
 		 		// Tariff type comboList
 				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);
 				if (data != undefined && data != '') {
 					var comboItems=data.split(ROWMARK);
 					addComboItem(comboObj,comboItems);
 				}
 				// search Tariff Type Set-Up by User
 				var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				// Tariff Type Set-Up by User is not exists -->set Default value .
 				if(data2 == '') data2='CTIC,DMIF';
 				if (data2.indexOf('All') == -1) {
 	 				// Tariff Type IBMultiCombo initializing
 	 				comboObj.SetSelectCode(data2);
 				}
 				
 				// set Global Variables(USR_TRF_TP) : for IBMultiCombo Tariff Type initializing function(initComboValue_tariff_type())
 				USR_TRF_TP=data2;
 				formObj.usr_trf_tp.value=data2;
 				break;
 	        case "yd_cd2":
 	        //case "tmnl_cd2":
 	        	var comboDatas;
 	        	var chkObj;
 	        	var condType=ComGetObjValue(formObj.cond_type);
 	        	if(srcObj.name == 'yd_cd') {
	 	        	comboObj.RemoveAll();
	 	        	chkObj=formObj.chk_yd_cd;
	 	        	comboDatas=ComGetEtcData(sXml, "YD");
 	        	} else {
 	        		if(condType == 'date')
 	        			chkObj=formObj.chk_yd_cd;
 	        		else
 	        			chkObj=formObj.chk_loc_cd;
 	        		comboDatas=ComGetEtcData(sXml, "LOC_CD");
 	        	}
				if (comboDatas != undefined && comboDatas != '') {
					ComSetObjValue(chkObj, "Y");
					if(srcObj.name == 'yd_cd') {
						comboItems=comboDatas.split(ROWMARK);
						addComboItem(comboObj, comboItems);
					} else {
						ComSetObjValue(formObj.loc_rhq_cd, ComGetEtcData(sXml, "LOC_RHQ_CD"));
					}
				} else {
					if(srcObj.name == 'yd_cd') {
						sheetObj.SetWaitImageVisible(1);
						return;
					}
					ComSetObjValue(chkObj, "N");
					ComShowCodeMessage('DMT00110', "Location");
					srcObj.focus();
				}
 	        	break;
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
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0].toString());
		  	   	}
		  		break;
  			case "combo_status":
  				if(comboItems == 3) {
	  				comboObj.InsertItem(0, "All", "A");
	  				comboObj.InsertItem(1, "Finished|To Date", "F");
	  				comboObj.InsertItem(2, "Long Staying|From Date", "L");
	  				comboObj.InsertItem(3, "System Error|From Date", "E");
	  				comboObj.InsertItem(4, "All Long Staying|Regardless of Date", "R");
  				} else {
  					comboObj.InsertItem(0, "All", "A");
  	  				comboObj.InsertItem(1, "Finished", "F");
  	  				comboObj.InsertItem(2, "Long Staying", "L");
  	  				comboObj.InsertItem(3, "System Error", "E");
  				}
  				break;
  			case "yd_cd2":
  			case "tmnl_cd2":
  				for (var i=0 ; i < comboItems.length ; i++) {
  		    		var comboItem=comboItems[i].split(FIELDMARK);
  					comboObj.InsertItem(i, comboItem[1], comboItem[0]);		
  		    	}
  				break;
  		}
  	}
  	/**
  	 * DEM Type selection to enable / disable processing according to the Tariff Type selection value
  	 */
  	function setDemType() {
  		var formObj=document.form;
  		with(formObj) {
	  		if(ComGetObjValue(cond_type) != 'vvd_cd') return;
	  		var trf_tp=comboObjects[1].GetSelectCode();
	  		if(trf_tp.indexOf('DMIF') != -1 || trf_tp.indexOf('DMOF') != -1) {
	  			ComEnableObject(dem_type, true);
	  			dem_type.className='input';
	  			ComClearObject(dem_type);
	  		} else {
	  			ComEnableObject(dem_type, false);
	  			dem_type.className='input2';
	  			ComClearObject(dem_type);
	  		}
  		}
  	}
	//Multi Combo click event
	function tariff_type_OnCheckClick(comboObj, index, code) {
		var codes = comboObj.GetSelectCode();
	    if (index == 0) {
	    	var bChk=comboObj.GetItemCheck(index);
    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    			comboObj.SetItemCheck(i, bChk, false);
	    	}
	    } 
	    else if (comboObj.GetItemCheck(0)) {
			comboObj.SetItemCheck(0, 0, false);
	    } 
	    else if (isTariffAllCheck(comboObj)) {
	    	comboObj.SetItemCheck(0, 1, false);
	    }
	    setDemType();
	}
	function status_OnCheckClick(comboObj, index, code) {
		var codes=comboObj.GetSelectCode();
		if (codes.indexOf('L') != -1 && codes.indexOf('R') != -1) {
			ComShowCodeMessage('DMT01067');
			comboObj.SetItemCheck(index,0);
			return;
		}
		var formObj=document.form;
		with (formObj) {
			if(index == 0) {
				if (comboObj.GetItemCheck(0))	// All
					comboObj.SetSelectCode("A,F,L,E");
				else
					comboObj.SetSelectCode('');
			} 
			else if (comboObj.GetItemCheck(0)) {
				comboObj.SetItemCheck(0, 0, false);
			} 
			else if (codes.indexOf('F') != -1 && codes.indexOf('L') != -1 && codes.indexOf('E') != -1) {
				comboObj.SetItemCheck(0, 1, false);
			}
			if (codes == '' || codes == 'R') {	//no selected or All Long Statying --> Date, the calendar icon inactive
				ComEnableManyObjects(false, fm_mvmt_dt1, to_mvmt_dt1);
				document.form.btns_calendar.disabled = true;
				DmtComSetClassManyObjects('input2', fm_mvmt_dt1, to_mvmt_dt1);
			} 
			else {
				if (ComGetObjValue(cond_type) == 'date') {
					ComEnableManyObjects(true, fm_mvmt_dt1, to_mvmt_dt1);
					document.form.btns_calendar.disabled = false;
					DmtComSetClassManyObjects('input1', fm_mvmt_dt1, to_mvmt_dt1);
				}
			}
		}
	}
	/**
	 * Row selected and the information passed to EES_DMT_3003.do is called a pop-up.
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		var formObj=document.form;
		//retrieve the results by POD ETA: 'by CNTR' Pop-up windows can not Retrieving
		if(formObj.bypodeta[0].checked || formObj.bypodeta[1].checked)
			return;
		openPopup('by_cntr', Row);
	}
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
            if (ColSaveName(Col) != "chk") {
                // Check Box Check that row when clicked
                //"/" Separator connected to get row number of the selected row, the result: "3/4/5"
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                    for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "chk")) {
                        	// Toggle
                    		SetCellValue(arr[i], "chk",(GetCellValue(arr[i], "chk") == '0') ? "1" : "0",0);
                        }
                    }
                    // All Check box Status synchronization
                    SetHeaderCheck(0, "chk",(CheckedRows("chk") == RowCount()));
                }
            } else {
            	//case in click Check box ,   All Check box Status synchronization
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
	/*
	 * Balloon handling in Grid
	 */
//	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
//		with(sheetObj){
//			Row=MouseRow();
//			Col=MouseCol();
//			if (Row > 0) {
//				var ttText='';
//				var colSaveNm=ColSaveName(Col);
//				switch(colSaveNm) {
//					case "chg_type": 
//						ttText='General/Balance Charge Type';
//						break;
//					case "li": 
//						ttText='Local/Intransit DEM Type';
//						break;
//					case "ch":
//						ttText="Carrier's Haulage";
//						break;
//					case "d_o":
//						ttText='Cargo Release';
//						break;
//					case "rlse_ofc":
//						ttText='Cargo Release Office';
//						break;
//					case "ofc_trns_flg":
//						ttText='Office Transferred';
//						break;
//					case "roll_ovr":
//						ttText='Roll Over due to Carrier Schedule Change';
//						break;	
//					case "web_ind_flg":
//						ttText='Web Empty Notification';
//						break;	
//				}
//				SetToolTipText(Row, Col, ttText);
//			} 
//			else {
//				SetToolTipText(Row, Col, "");
//			}
//		}
//	}
	/**
  	 * IBSheet lookup function Retrieving is complete, caused by an Event
  	 */
  	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
  		if(ErrMsg != '') return;
		var formObj=document.form;
		with(formObj) {
			sheetObj.CheckAll("chk",0);
  			// Without a resulting data, Search conditions enter the data retention
        	if(sheetObj.SearchRows()== 0) {
        		initBtns();
        	} else {
        		// ****** resulting data ********
        		// by POD ETA check
        		if(formObj.f_cmd.value == SEARCH01) {
        			ComEnableManyObjects(false, cond_type[0], cond_type[1], cond_type[2], bypodeta[0], bypodeta[1]);
        			ComEnableManyObjects(false, vvd_cd, tmnl_cd, bkg_no, bl_no); 
        			ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
        			if(bypodeta[0].checked)
        				DmtComSetClassManyObjects('input2', vvd_cd, tmnl_cd);
        			else
        				DmtComSetClassManyObjects('input2', bkg_no, bl_no);
        			// Activating of button
        			DmtComEnableManyBtns(true, "btn_ByETA", "btn_MVMTInq", "btn_DownExcel");
        			// Deactivating of button 
        			DmtComEnableManyBtns(false, "btn_Confirm", "btn_Recalc", "btn_Demand", "btn_GRPDemand", "btn_Billing", "btn_GRPINVCreation",
	   	    				 					"btn_OFCTrans", "btn_Delete", "btn_ByBKG", "btn_ByCNTR", "btn_ExceptionInq");
        		} else {
        			// Activating of button
        			DmtComEnableManyBtns(true,	"btn_Confirm", "btn_Recalc", "btn_Demand", "btn_GRPDemand", "btn_Billing", "btn_GRPINVCreation", "btn_OFCTrans",
   	    				 						"btn_Delete", "btn_ExceptionInq", "btn_ByBKG", "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
        			// Deactivating of button
        			DmtComEnableManyBtns(false, "btn_ByETA");
        		}
  			}
		} // with end
  	}

  	/**
     * After saving handling
     */
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg){
		 if(ErrMsg != '') {	// Error when saving
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			var chkRows=sheetObj.FindCheckedRow("chk").split("|");
      		for(var i=0; i < chkRows.length; i++) {
      			sheetObj.SetCellValue(chkRows[i], "dmdt_chg_sts_cd",'C');
      		}
      		//all UnCheck --> sheetObj.RowStatus(i) all of them change to 'R'
			sheetObj.CheckAll("chk",0);
		 }
    }
    /*
  	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value=aryPopupData[0][3];
    }
    /*
  	 * Service Provider Inquiry Common pop-up calls
  	 */
    function getSvcProvdr(aryPopupData) {
    	document.form.svc_provdr.value=aryPopupData[0][2];
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
  	 * Each common pop-up function calls 
  	 */
  	function openPopup(flag, arg) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var paramVal='';
  		var sScroll='no';
		var modal = true;
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 445, "getCustCd", "0,1", true);
					break;
	  			case 'svc_provdr':	// Service Provider Popup
					ComOpenPopup('COM_ENS_0C1.do', 700, 488, "getSvcProvdr", "0,1", true);
					break;
	  			case 'bkg_no':		// BKG No. Multi-Input pop-up calls
	  			case 'bl_no':		// B/L No. Multi-Input pop-up calls
	  			case 'cntr_no':		// CNTR No. Multi-Input pop-up calls
	  				// Specify the details of multi-input pop-up title
	  				var returntitle='';
	  				var sWidth  = 0;
	  				var sHeight = 415;
	  				if (flag == 'bkg_no') {
	  					returntitle='BKG No.';
	  					sWidth = 425;
	  				}
	  				else if(flag == 'bl_no') {
	  					returntitle='B/L No.';
	  					sWidth = 420;
	  				}
	  				else if(flag == 'cntr_no') {
	  					returntitle='CNTR No.';
	  					sWidth = 437;
	  				}
	  				var param="?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, sWidth, sHeight, "getDmt_Multi", "1,0", true);
				break;
				
	  			case 'delete':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		var chkCnt=0;
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
						var chg_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
						var delt_rqst_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_delt_rqst_sts_cd");
               			// 2011.10.10 KHH [CHM-201113639-01]
            			if(delt_rqst_sts=='R'){
            				ComShowCodeMessage('DMT01155');
            				return;
            			}
             			if(chg_sts == '') {
             				ComShowCodeMessage('DMT01060');
             				sheetObj.SetSelectRow(i);
             				return;
             			} else if(chg_sts == 'D') {
             				ComShowCodeMessage("DMT00176", sheetObj.GetCellValue(chkRows[i], "cntr_no"));
    	  					return;
             			} else if(chg_sts != 'I' ) { // 2011.10.10 D 추가
         					chkCnt++;
         				}
             		}
             		if(chkCnt == 0) {
             			ComShowCodeMessage('DMT01026');
     					return;
             		}
	  				sUrl='EES_DMT_3104.do';
              		sWidth  = '450';
              		sHeight = '560';
	  			break;
	  			
	  			case 'demand':
	  				var chkRow=GetSelectRow();
	  				var chgStsCd=GetCellValue(chkRow, "dmdt_chg_sts_cd");
     				if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'I' || chgStsCd == 'L' || chgStsCd == 'U') {
     				} else {
     					ComShowCodeMessage('DMT01077');
        				return;
     				}
     				chgStsCd="F,C,I,L,U";
     				paramVal="?group_by=2"
		     	 	 			+"&chg_type="	+ ComGetObjValue(formObj.chg_type)
		     	 	 			+"&ofc_cd="		+ ComGetObjValue(formObj.ofc_cd)
		     	 				+"&dmdt_chg_sts_cd=" + chgStsCd
		     	 				+"&bkg_no="		+ GetCellValue(chkRow, "bkg_no")
		     	 				+"&dmdt_trf_cd="+ GetCellValue(chkRow, "dmdt_trf_cd")
		     	 				+"&cntr_no="	+ GetCellValue(chkRow, "cntr_no")
		     	 				+"&dmdt_inv_no="
		     	 				+"&invoice_issue=1"	//Invoice Issue BEFORE
		     	 				;
             		sUrl='EES_DMT_3109.do' + paramVal;
              		sWidth  = '945';
              		sHeight = '688';
	  			break;
	  			
	  			case 'grp_demand':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		var chkRows=FindCheckedRow("chk").split("|");
             		var firstTrfCd=GetCellValue(chkRows[0], "dmdt_trf_cd");
             		for(var i=1; i < chkRows.length; i++) {
             			if(GetCellValue(chkRows[i], "dmdt_trf_cd") != firstTrfCd)
             				SetCellValue(chkRows[i], "chk","0",0);
             		}
             		var chkCnt=0;
             		chkRows=FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
             			var chg_sts=GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts == 'F' || chg_sts == 'C' || chg_sts == 'I' || chg_sts == 'L' || chg_sts == 'U') {
         				} else {
         					ComShowCodeMessage('DMT01077');
            				return;
         				}
             		}
             		var chgStsCd=comboObjects[2].GetSelectText();
             		chgStsCd=ComReplaceStr(chgStsCd, "System Error", "");
             		var chgStsCd2=comboObjects[2].GetSelectCode();
             		chgStsCd2=ComReplaceStr(chgStsCd2, "E", "");
             		paramVal="?ofc_cd="				+ GetCellValue(chkRows[0], "ofc_cd")
             					+ "&dmdt_trf_cd="		+ GetCellValue(chkRows[0], "dmdt_trf_cd")
		        				+ "&dmdt_chg_sts_cd="	+ chgStsCd
		        				+ "&dmdt_chg_sts_cd_2="	+ chgStsCd2
		        				;
             		sUrl='EES_DMT_3108.do' + paramVal;
              		sWidth='1020';
              		sHeight='700';
             	break;
             	
	  			case 'billing':
	  				var chkRow=GetSelectRow();
	  				if(GetCellValue(chkRow, "dmdt_chg_sts_cd") != 'C') {
             			ComShowCodeMessage('DMT01076', 'Billing');
             			return;
             		}
	  				if(GetCellValue(chkRow, "dmdt_delt_rqst_sts_cd") == 'R') {
             			ComShowCodeMessage('DMT01154');
             			return;
             		}					
         			var chgType=ComGetObjValue(formObj.chg_type);
         			var paramVal="?group_by=2"
			        				+"&chg_type="	+ (chgType=='' ? 'A' : chgType)
									+"&ofc_cd="		+ GetCellValue(chkRow, "ofc_cd")
									+"&bkg_no="		+ GetCellValue(chkRow, "bkg_no")
									+"&dmdt_trf_cd="+ GetCellValue(chkRow, "dmdt_trf_cd")
			        				+"&invoice_issue=1";	//Invoice Issue BEFORE
			        sUrl='EES_DMT_4002.do' + paramVal;
              		sWidth  = '1050';
              		sHeight = '700';
             	break;
             	
	  			case 'grp_inv_cre':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		var chkRows=FindCheckedRow("chk").split("|");
	  				for(var i=0; i < chkRows.length; i++) {
	  					var chgStsCd=GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chgStsCd != 'C') {
         					ComShowCodeMessage('DMT01076', 'GRP INV Creation');
         					return;
         				}
         				var delt_rqst_sts=GetCellValue(chkRows[i], "dmdt_delt_rqst_sts_cd");
               			// 2011.10.10 KHH [CHM-201113639-01]
            			if(delt_rqst_sts=='R'){
            				ComShowCodeMessage('DMT01154');
            				return;
            			}
             		}
             		// Hidden Sheet
             		var sheetObj2=sheetObjects[1];
             		sheetObj2.RemoveAll();
             		//Sheet1 checked the "chk" Creating a retrieving data as XML
             		var sXml=ComMakeSearchXml(sheetObj, false, "chk", "bkg_no|bl_no|cntr_cnt|cntr_no|gb|ofc_cd|dmdt_trf_cd|cust_cd|sc_no|rfa_no|ar_curr_cd|inv_amt|bzc_trf_curr_cd|org_chg_amt|sc_rfa_expt_amt|aft_expt_dc_amt|bil_amt|inv_xch_rt|vsl_cd|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|por_cd|del_cd|vvd_cd|payer_cd|chg_cust_cnt_cd|chg_cust_seq");             		
             		//Retrieving XML to load into sheet2
             		sheetObj2.LoadSearchData(sXml,{Append:1 , Sync:1} );
             		with(sheetObj2) {
	             		for(var i=GetTopRow(); i <= LastRow(); i++) {
	             			var vvdCd=GetCellValue(i, "vvd_cd");
	             			SetCellValue(i, "vsl_cd",vvdCd.substring(0, 4),0);
	             			SetCellValue(i, "skd_voy_no",vvdCd.substring(4, 8),0);
	             			SetCellValue(i, "skd_dir_cd",vvdCd.substring(8),0);
	             			SetCellValue(i, "cust_cd",GetCellValue(i, "payer_cd"),0);
	             		}
	             		//formObj.f_cmd.value = SEARCH02;
	             		var sParam=GetSaveString(true) + "&f_cmd=" + SEARCH02;	// + FormQueryString(formObj);
	             		var sXml=GetSaveData("EES_DMT_3001GS.do", sParam);
	             		LoadSaveData(sXml);
	             		for(var i=GetTopRow(); i <= LastRow(); i++) {
	             			SetCellValue(i, "cust_cd",GetCellValue(i, "payer_cd"),0);
	             		}
             		}
             		// add.kimtk.2009.12.7
             		sheetObj2.CheckAll("CheckBox",1);
             		var chgType=ComGetObjValue(formObj.chg_type);
             		if(chgType == '') chgType='A'; 
             		paramVal="?jspno=3001"
             					+ "&s_group_by=2"	//Invoice Issue BEFORE
		        				+ "&s_chg_type=" + chgType
		        				+ "&inv_xch_rt="
		        				;
			        sUrl='EES_DMT_4013.do' + paramVal;
              		sWidth = '980';
              		sHeight = '586';
             	break;
             	
	  			case 'ofc_trans':	
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		var chkRows=FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
             			var chg_sts=GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
             			var delt_rqst_sts=""; 
             			delt_rqst_sts=GetCellValue(chkRows[i], "dmdt_delt_rqst_sts_cd"); //2011.10.10
         				if(chg_sts != 'F' && chg_sts != 'L') {
         					ComShowCodeMessage('DMT01019');
         					return;
         				}
						if(delt_rqst_sts == "R") {
         					ComShowCodeMessage('DMT01153');
         					return;
         				}
             		}
					var fmOfcCd=GetCellValue(chkRows[0], "ofc_cd");		//comboObjects[0].GetSelectCode();
					var ofcRhqCd=GetCellValue(chkRows[0], "ofc_rhq_cd");
		  			var paramVal="?fm_ofc_cd=" + fmOfcCd + "&ofc_rhq_cd=" + ofcRhqCd;
             		sUrl='EES_DMT_3101.do' + paramVal;
              		sWidth  = '618';
              		sHeight = '445';
             	break;
             	
	  			case 'by_eta':
	  				if (CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		var chkRows=FindCheckedRow("chk").split("|");
             		for (var i=0; i < chkRows.length; i++) {
             			var chg_sts = GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
             			if (chg_sts != '') {
             				ComShowCodeMessage('DMT01054');
             				SetSelectRow(chkRows[i]);
             				return;
             			}
             		}
	  				sUrl='EES_DMT_3106.do' + '?call_flag=byofc';
              		sWidth  = '800';
              		sHeight = '540';
	  			break;
	  			
	  			case 'by_bkg':
	  				var chkRow=GetSelectRow();
					var bkgNo=GetCellValue(chkRow , "bkg_no");
					var blNo=GetCellValue(chkRow , "bl_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgStsCd=GetCellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd + "&dmdt_chg_sts_cd=" + chgStsCd;
	  				sUrl='EES_DMT_3002P.do' + paramVal;
	          		sWidth  = '1280';
	          		sHeight = '700';
	  			break;
	  			
	  			case 'by_cntr':
	  				var chkRow=GetSelectRow();
					var svrId=GetCellValue(chkRow , "svr_id");
					var cntrNo=GetCellValue(chkRow , "cntr_no");
					var cntrCycNo=GetCellValue(chkRow , "cntr_cyc_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgLocDivCd=GetCellValue(chkRow , "dmdt_chg_loc_div_cd");
					var chgSeq=GetCellValue(chkRow , "chg_seq");
		  			var paramVal="?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
	  				sUrl='EES_DMT_3003P.do' + paramVal;
	          		sWidth  = '1150';
	          		sHeight = '700';
	  			break;
	  			
	  			case 'mvmt_inq':
	  				if(SearchRows()== 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');  //DMT06001
	         			return;
	         		}
	  				var inqRow=0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows=FindCheckedRow("chk").split("|");
	  					inqRow=chkRows[0];
	  				} else if(GetSelectRow()> 0) {
	  					inqRow=GetSelectRow();
	  				}
					var cntrNo=GetCellValue(inqRow , "cntr_no");
					var cntrTpszCd=GetCellValue(inqRow , "cntr_tpsz_cd");
	  				var paramVal="?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl='EES_CTM_0408_POP.do' + paramVal;
					sWidth  = '1020';
					sHeight = '680';
					modal = false;
	  			break;
	  			
	  			case 'by_excinq':
	  				/*
	  				if(SearchRows()== 0) {
	         			ComShowCodeMessage('COM12114', 'CNTR');
	         			return;
	         		}
	  				var inqRow=0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows=FindCheckedRow("chk").split("|");
	  					inqRow=chkRows[0];
	  				} else if(GetSelectRow()> 0) {
	  					inqRow=GetSelectRow();
	  				}*/
	  				var selRow=GetSelectRow();
					var scNo=GetCellValue(selRow , "sc_no");
					var rfaNo=GetCellValue(selRow , "rfa_no");
	  				if(scNo != '' && rfaNo != '') scNo='';
	  				var paramVal="?caller=3001&sc_no=" + scNo
	  								+ "&rfa_no=" + rfaNo 
	  								+ "&trf_cd=" + GetCellValue(selRow , "dmdt_trf_cd")
	  								;
	  				sUrl='EES_DMT_2007_1_POP.do' + paramVal;
              		sWidth  = '1280';
              		sHeight = '800';
              		sScroll = 'yes';
					modal = false;
	  			break;
	  		} // switch - end
  		} // with(sheetObj) - end
  		if(sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
 // 			var returnValue=ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, sIframe, sScroll);
  			ComOpenPopup(sUrl, sWidth, sHeight, "findCommodity", "0,1", modal);
  			
  			
  		}
//  		if(sUrl != '') {
//  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
//  			var returnValue=ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, sScroll);
//  			/*if(returnValue == "Y") {
// 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
// 			}*/
//  		}
  	}
  	

  	function findCommodity(rtnVal) {
  		var formObj = document.form;
  		var sheetObj=sheetObjects[0];
        if(rtnVal == "Y") {
        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
   }
    /**
     *  initializing of all of Object <br>
     *  If IBMultiCombo id = "myCombo" if "initComboValue_myCombo ()" JavaScript function that is defined and if you call the function,  <br>
     *  that function is not, set to IBMultiCombo.Code2 = "-1" for not select anything <br>
    * @return none
     */
    function resetSearchControls(){
        try {
            for(var i=0; i<document.forms.length; i++){
                document.forms[i].reset();
            }
            var objs=document.getElementsByTagName("OBJECT");
            for(var i=0 ; i < objs.length ; i++){
                var sObjId=objs[i].classid;
                switch(sObjId){
//                    case CLSID_IBSHEET: //IBSheet
//                        objs[i].RemoveAll();
//                        break;
                    case CLSID_IBMCOMBO: //IBMultiCombo 
                        var id=objs[i].id;
                        var funcName="initComboValue_" + id;
                        if (ComFuncCheck(funcName)) {
                            ComFunc();
                        } else {
                            objs[i].SetSelectCode("-1",false);
                        }
                        break;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
             	case IBSEARCH:     // Search
             		// Office Combo Check
             		if(comboObjects[0].GetSelectText()== '') {
             			ComShowCodeMessage('COM12113', "Office");
             			return false;
             		}
             		// Tariff Type Combo Check
             		if(comboObjects[1].GetSelectCode()== '') {
             			ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
             		}
             		// Status Combo Check
             		if(comboObjects[2].GetSelectCode()== '' && !bypodeta[0].checked && !bypodeta[1].checked) {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}
             		ComSetObjValue(fm_mvmt_yd_cd, '');
             		ComSetObjValue(to_mvmt_yd_cd, '');
             		var condType=ComGetObjValue(cond_type);
             		//******************** Date conditions  ************************
             		if(condType == 'date') {
             			if(!ComIsDate(fm_mvmt_dt1)) {
             				ComAlertFocus(fm_mvmt_dt1, ComGetMsg('COM12134', 'Period From Date'));
             				return false;
             			}
             			if(!ComIsDate(to_mvmt_dt1)) {
             				ComAlertFocus(to_mvmt_dt1, ComGetMsg('COM12134', 'Period To Date'));
             				return false;
             			}
             			var startDt=ComGetUnMaskedValue(fm_mvmt_dt1, 'ymd');
             			var endDt=ComGetUnMaskedValue(to_mvmt_dt1, 'ymd');
             			// Check period
                        if (ComChkPeriod(startDt, endDt) == 0) {
                        	ComShowCodeMessage("DMT01020");
                        	return false;
                        }
                        var limitDt=ComGetDateAdd(startDt, "M", 1);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", "1 month");
                        	return false;
                        }
                        ComSetObjValue(fm_mvmt_dt, startDt);
                        ComSetObjValue(to_mvmt_dt, endDt);
                        var yardCd=ComGetObjValue(yd_cd);
                        // check YardCode
                        if((yardCd != '' && yardCd.length < 5) || (yardCd.length == 5 && ComGetObjValue(chk_yd_cd) == "N")) {
        					ComAlertFocus(yd_cd, ComGetMsg('DMT00110', 'Yard'));
        					return false;
        	       		} else if(yardCd.length == 5) {
        	       			var yardFmto=ComGetObjValue(yard_fmto);
             				if(yardFmto == 'yard_fm') {
             					ComSetObjValue(fm_mvmt_yd_cd, yardCd);
             					ComSetObjValue(to_mvmt_yd_cd, '');
             				} else {
             					ComSetObjValue(fm_mvmt_yd_cd, '');
             					ComSetObjValue(to_mvmt_yd_cd, yardCd);
             				}
        	       		}
             			var yardCd2=ComGetObjValue(comboObjects[3]);
             			//  check  YardCode
             			if(yardCd2 != '') {
             				var yardFmto=ComGetObjValue(yard_fmto);
             				if(yardFmto == 'yard_fm') {
             					ComSetObjValue(fm_mvmt_yd_cd, yardCd2);
             					ComSetObjValue(to_mvmt_yd_cd, '');
             				} else {
             					ComSetObjValue(fm_mvmt_yd_cd, '');
             					ComSetObjValue(to_mvmt_yd_cd, yardCd2);
             				}
             			}
             		//******************** VVD CD conditions  ************************
             		} else if(condType == 'vvd_cd') {
             			if( ComChkLen(vvd_cd, 9) != 2) {	// Nine digits, or
             				//ComShowCodeMessage('DMT00102', "VVD CD");
             				ComAlertFocus(vvd_cd, ComGetMsg('DMT00119', 'VVD CD', '9'));
         					return false;
             			}
             			ComSetObjValue(pod_cd, "");
             			ComSetObjValue(pol_cd, "");
             			var tmnlCd=ComGetObjValue(tmnl_cd);
             			if(bypodeta[0].checked) {
             				//var tmnlCd = comboObjects[4].Code;
             				if(ComChkLen(tmnlCd, 5) != 2 || ComGetObjValue(chk_loc_cd) != "Y") {
             					//ComAlertFocus(tmnl_cd, ComGetMsg('DMT00119', 'Port', '5'));
             					ComAlertFocus(tmnl_cd, ComGetMsg('DMT00110', 'Location'));
             					return false;
             				}
             				var usrRhqOfcCd=ComGetObjValue(usr_rhq_ofc_cd);
//             				if(usrRhqOfcCd != 'SELHO') {
//             					if(usrRhqOfcCd != ComGetObjValue(loc_rhq_cd)) {
//             						ComShowCodeMessage('DMT01129');
//    	                 			return false;
//             					}
//             				}
             				if(usrRhqOfcCd != ComGetObjValue(head_office)) {
             					if(usrRhqOfcCd != ComGetObjValue(loc_rhq_cd)) {
             						ComShowCodeMessage('DMT01129');
             						return false;
             					}
             				}
             				ComSetObjValue(pod_cd, tmnlCd);
             			} else if(tmnlCd != '') {
             				if( tmnlCd.length < 5 || tmnlCd.length == 5 && ComGetObjValue(chk_loc_cd) == "N" ) {	
             					ComAlertFocus(tmnl_cd, ComGetMsg('DMT00110', 'Location'));
            	       			return false;
             				}
             				var trf_cd=comboObjects[1].GetSelectCode();
             				if(trf_cd.indexOf('I') != -1)	// Inbound
             					ComSetObjValue(pod_cd, tmnlCd);
             				if(trf_cd.indexOf('O') != -1)	// Outbound
             					ComSetObjValue(pol_cd, tmnlCd);
             			}
             		//******************** CNTR conditions  ************************	
             		} else {
             			if(bypodeta[1].checked) {
	             			if(ComIsNull(bkg_no) && ComIsNull(bl_no)) {
	             				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No.');
	                 			return false;
	             			}
             			} else {
             				if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
	             				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
	                 			return false;
             				}
             			}
             			var bkgNo=ComGetObjValue(bkg_no);
             			if(bkgNo != '') {
             				var arrBkgNo=bkgNo.split(',');
             				for(var i=0; i<arrBkgNo.length; i++) {
             					if(ComChkLen(arrBkgNo[i], 11) != 2 && ComChkLen(arrBkgNo[i], 12) != 2 && ComChkLen(arrBkgNo[i], 13) != 2) {
             						ComAlertFocus(bkg_no, ComGetMsg('DMT00119', 'BKG No.', '11~13'));
    	                 			return false;
             					}
             				}
             			}
             			var blNo=ComGetObjValue(bl_no);
             			if(blNo != '') {
             				var arrBlNo=blNo.split(',');
             				for(var i=0; i<arrBlNo.length; i++) {
             					if(ComChkLen(arrBlNo[i], 10) != 2 && ComChkLen(arrBlNo[i], 12) != 2) {
             						ComAlertFocus(bl_no, ComGetMsg('COM12175', 'B/L No.', '10', '12'));
    	                 			return false;
             					}
             				}
             			}
             			var cntrNo=ComGetObjValue(cntr_no);
             			if(cntrNo != '') {
             				var arrCntrNo=cntrNo.split(',');
             				for(var i=0; i<arrCntrNo.length; i++) {
             					if(ComChkLen(arrCntrNo[i], 14) == 0) {	// Exceed the length
             						ComAlertFocus(cntr_no, ComGetMsg('COM12173', 'CNTR No.', '14'));
    	                 			return false;
             					}
             				}
             			}
             		}
             		if(svc_provdr.value != '') {
             			if(!ComIsNumber(svc_provdr)) {
             				ComAlertFocus(svc_provdr, ComGetMsg('COM12122', 'Service Provider'));
             				return false;
             			}
             			if(ComChkLen(svc_provdr, 6) != 2) {
         					ComAlertFocus(svc_provdr, ComGetMsg('DMT00120', 'Service Provider', '6'));
         					return false;
         				}
             		}
             		break;
             	case IBSAVE:      //Confirm
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR for Confirm');
             			return false;
             		}
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
             			var chg_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'F') {
         					ComShowCodeMessage('DMT03018');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
             		}
             		break;
             	case IBDELETE:
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR for Delete');
             			return false;
             		}
             		var chkCnt=0;
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
             			var chg_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'I') {
         					chkCnt++;
         				}
             		}
             		if(chkCnt == 0) {
             			ComShowCodeMessage('DMT01026');
     					return false;
             		}
             		break;
        	 } // switch-end
         } // with-end
         return true;
     }
     
// 	function combo_status_OnSelect(comboObj ,index, code) {
// 		selComboIndex = index;
// 		selComboCode = code;
// 	}
// 	
// 	function combo_status_OnChange(comboObj, OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
// 		DmtComMultiComboStatus_OnChange(document.form, comboObj, selComboIndex);
// 	}
 	
	function combo_status_OnCheckClick(comboObj, index, code) {
		var codes  = comboObj.GetSelectCode();
		var allchk = comboObj.GetItemCheck(0);
		
		if(codes.indexOf('L') != -1 && codes.indexOf('R') != -1) {
			ComShowCodeMessage('DMT01067');
			comboObj.SetItemCheck(index, false, false);	
			return;
		}
		
		if (index == 0) {
			// All 항목이 선택된 경우
			if (allchk) {
				comboObj.SetItemCheck('R', false, false);
				comboObj.SetSelectCode('A,F,L,E', false);
			}
			// All 항목이 해제된 경우
			else {
				comboObj.SetItemCheck('A', false, false);
				comboObj.SetItemCheck('F', false, false);
				comboObj.SetItemCheck('L', false, false);
				comboObj.SetItemCheck('E', false, false);
			}
		} 
		else {
			// Finished, Long Staying, System Error 가 선택된 경우, All 항목을 선택해준다.
			if (codes.indexOf('F') != -1 && codes.indexOf('L') != -1 && codes.indexOf('E') != -1) {
				comboObj.SetItemCheck(0, true, false);
			}
			// Finished, Long Staying, System Error 중 한 항목이라도 선택되지 않았다면, All 항목을 선택해제해준다.
			else if (codes.indexOf('F') == -1 || codes.indexOf('L') == -1 || codes.indexOf('E') == -1) {
				comboObj.SetItemCheck(0, false, false);
			}
		}
		
		if (codes == '' || codes == 'R') {	//no selected or All Long Statying --> Date, the calendar icon inactive
			ComEnableManyObjects(false, document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
			document.form.btns_calendar.disabled = true;
			DmtComSetClassManyObjects('input2', document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
		} 
		else {
			if (ComGetObjValue(document.form.cond_type) == 'date') {
				ComEnableManyObjects(true, document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
				document.form.btns_calendar.disabled = false;
				DmtComSetClassManyObjects('input1', document.form.fm_mvmt_dt1, document.form.to_mvmt_dt1);
			}
		}
	}
	
	function initComboStatus(comboObj) {
		comboObj.SetItemCheck('A', false, false);
		comboObj.SetItemCheck('F', true,  false);
		comboObj.SetItemCheck('L', false, false);
		comboObj.SetItemCheck('E', false, false);
		comboObj.SetItemCheck('R', false, false);
	}
	
	function isTariffAllCheck(comboObj) {
		var allTariffCnt = comboObj.GetItemCount();
		var selTariffCnt = 0;
		for (var i = 1; i < allTariffCnt; i++) {	// All 항목은 제외
			if (comboObj.GetItemCheck(i)) selTariffCnt++;
		}
		
		return selTariffCnt == allTariffCnt-1;		// 선택항목에서 All 항목은 제외
	}
	

	 /**
	 * confirm to status 3 for BackEndJob
	 */
	 function getBackEndJobStatus() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	 	var params="f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml=sheetObj.GetSearchData("EES_DMT_3001GS.do", params);
	 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	 	// jobState == "2" BackEndJob processing......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob was successful
	 		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// BackEndJob was failed
	 		var jbUsrErrMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// read already BackEndJob result file
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 }

 	