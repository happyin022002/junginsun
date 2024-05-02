/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3006.js
*@FileTitle  : Charge Inquiry by CNTR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
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
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type";
	var ROWMARK="|";
	var FIELDMARK="=";
	// Tariff Type Set-Up by User information 
	var USR_TRF_TP;
	// Action button that contains the variable definitions for functions
	var IBPRECAL=99;
	var IBWEBCANCEL=98;
	var IBCONFIRM=97;
	var IBDELCANCEL=96;
	var IBDRCANCEL=95;
	var IBDRSAVE=94;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
	function processButtonClick(){
		/***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObj1=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcObj=ComGetEvent();
     		var srcName=srcObj.getAttribute("name");
			// Click the button at the bottom of the grid is disabled, return
			if(!ComIsBtnEnable(srcName)) return;
             switch(srcName) {
             	case "btn_PreCal":
             		doActionIBSheet(sheetObj1,formObj,IBPRECAL);
					break;
             	case "btn_WebCancel":
             		doActionIBSheet(sheetObj1,formObj,IBWEBCANCEL);
					break;
             	case "btn_Retrieve":
             		ComSetObjValue(formObj.est_mk, "");
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;
				case "btn_New":
					ComResetAll();
					sheetObj1.RemoveAll();
					initBtns();
					//[2015.06.04] cntr_no, chg_type enable
	        		ComEnableManyObjects(true, formObj.cntr_no, formObj.chg_type);
	        		DmtComSetClassManyObjects('input1', formObj.cntr_no);
	        		DmtComSetClassManyObjects('input', formObj.chg_type);
	        		
					ComSetDisplay('tbl_webmty', false);
					break;
				case "btn_Save":
 					doActionIBSheet(sheetObj1,formObj,IBSAVE);
 					break;
 				case "btn_Confirm":
 					doActionIBSheet(sheetObj1,formObj,IBCONFIRM);
 					break;
 				case "btn_DELCancel":
 					doActionIBSheet(sheetObj1,formObj,IBDELCANCEL);
 					break;
 				case "btn_DRCancel":
 					doActionIBSheet(sheetObj1,formObj,IBDRCANCEL);
 					break;
 				case "btn_Close":
 					//window.returnValue = "Y";
 					ComClosePopup(); 
					break;
 				case "btns_calendar1": //Calendar button
             		if(srcObj.style.cursor == "hand") {
						var cal=new ComCalendar();
						cal.select(formObj.fm_mvmt_dt, 'yyyy-MM-dd');
             		}
					break;
		        case "btns_calendar2": //Calendar button
		        	if(srcObj.style.cursor == "hand") {
		                var cal=new ComCalendar();
		                cal.select(formObj.to_mvmt_dt, 'yyyy-MM-dd');
		        	}
	                break;
 				//---- pop up ------
 				case "btn_Demand":
				case "btn_Billing":
				case "btn_OFCTrans":
				case "btn_Delete":
				case 'btn_Partial':
				case 'btn_CalcDetail':
				case 'btn_CorrHistory':
				case 'btn_OTHistory':
				//case 'btn_ROInfo':
				case 'btn_MVMTInq':
				case 'btn_ExceptionInq':
 				//default:
 					doProcessPopup(srcName);
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
		 //Displays a pop-up title at the call handling
    	 if(ComGetObjValue(document.form.call_flag) == "P") {
        	 var spanObj=document.getElementById("title");
        	 spanObj.innerText=" Charge Inquiry by CNTR";
        	 //ComSetDisplay('btnCloseLayer', true);
    	 } 
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
		initControl();
		sheet1_OnLoadFinish();
	}
	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
   //no support[check again]CLT 	
	function sheet1_OnLoadFinish() {
		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 		sheetObj.SetWaitImageVisible(0);
 		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
 		initComboValue_tariff_type();
		initBtns();

		/*********************************************
         * Pop-up window for call handling (Retrieve running)
         **********************************************/
		if(ComGetObjValue(formObj.call_flag) == "P") {
			
			var chg_type=(ComGetObjValue(formObj.chg_seq) == "1") ? "G" : "B";
			ComSetObjValue(formObj.chg_type, chg_type);
			// Search conditions deactivating 
			ComEnableManyObjects(false, formObj.cntr_no, formObj.chg_type);
			var opener=window.dialogArguments;
			if (!opener) opener=parent;
			var opnSheetObj=opener.sheetObjects[0];
//			var opener=window.dialogArguments;
//			var opnSheetObj=opener.sheetObjects[0];
			if(opnSheetObj.GetCellValue(opnSheetObj.GetSelectRow(), "to_mvmt_sts_cd") == 'PC') {
				// Search PreCal information
				ComSetObjValue(formObj.est_mk, "P");
			}
			// Retrieve
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
        sheetObj.SetWaitImageVisible(1);
   	}
	/**
	  * Screen initializing
	  */
	function initBtns() {
		// Activating of button status initializing
		DmtComEnableManyBtns(false, 'btn_CalcDetail','btn_CorrHistory', 'btn_OTHistory',  'btn_MVMTInq');
		//document.getElementById("btn_ROInfo").style.color = "";
	}
	function initControl() {
		//axon_event.addListenerFormat('blur',	'obj_blur',		form);		//- out of focus
		//axon_event.addListenerFormat('keypress','obj_keypress', form);		//- on press keyboard
		//axon_event.addListener('focus',		'obj_focus',		'cntr_no'); // Get focus
		//axon_event.addListener('keydown',	'ComKeyEnter',		'form');
		//axon_event.addListener('mouseover',	'obj_mouseover',	'td_ch', 'rlse_dt');
		//axon_event.addListener('mouseout',	'obj_mouseout',		'td_ch', 'rlse_dt');
	}
	// onMouseover event  (button Show balloon message)
    function obj_mouseover() {
    	var msg='';
    	switch(ComGetEvent("id")){
     		case 'td_ch':
     		case 'ch':
     			msg="Carrier's Haulage";
     			break;
     		case "rlse_dt":
     			msg="Cargo Release Date";
     			break;
    	}
    	var bak='lightyellow';
   	 	var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
   	 				+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
   	 	var x=event.x+document.body.scrollLeft;
		var y=event.y+document.body.scrollTop;
		var skn=document.all("topdeck").style;
		skn.left=x-10;
		skn.top=y+10;
		document.all("topdeck").innerHTML=content;
		skn.visibility='visible';
    }
    // onMouseout event  (button Hide balloon message)
	function obj_mouseout() {
		var skn=document.all("topdeck").style;
		skn.visibility='hidden';
	}
	// out of focus
	function obj_blur(){
		//check inputing Validation + Inserting separator 
		var obj=ComGetEvent();
		ComChkObjValid(obj);
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
 	// IBMultiCombo Tariff Type initializing
  	function initComboValue_tariff_type() {
 		var formObj=document.form;
   		if(ComGetObjValue(formObj.call_flag)=='M') {
   			// call from Menu('M')
   			comboObjects[0].SetEnable(1);
   			comboObjects[0].SetSelectCode(USR_TRF_TP);
   			ComSetObjValue(formObj.usr_trf_tp, USR_TRF_TP);
   		} else {
   			// call from Pop up('P')
   			comboObjects[0].SetEnable(0);
   			comboObjects[0].SetSelectCode(ComGetObjValue(formObj.dmdt_trf_cd));
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
			case 1:	// sheet1 init
			    with(sheetObj){
		        	var HeadTitle1="|Over Day|Over Day|Rate per Day|Over Day|Cur.|Charge AMT";
		        	var headCount=ComCountHeadTitle(HeadTitle1);

		        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		        	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		        	InitHeaders(headers, info);

		        	var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hidStatus" },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rt_over",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rt_under",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"rt_rate",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rt_day",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rt_cur_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rt_chrg",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		        	InitColumns(cols);
					SetCountPosition(0);
					SetSheetHeight(107);
					SetEditable(0);
	        		FitColWidth();
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
	    	case "tariff_type":
	    		with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					/*SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "45");
					SetColWidth(1, "300");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");*/
		    	}
				break;
	    	case "to_mvmt_sts":
				with (comboObj) { 
    				SetMultiSelect(0);
    				/*SetColAlign(0, "left");
    				SetColWidth(0, "60");
					SetDropHeight(170);
					SetColBackColor(0,"#CCFFFD");*/
    				SetEnable(false); 
   		    	}
				addComboItem(comboObj, 'DMIF');
   	    		break;
	    } // switch end
	}
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    switch(sAction) {
	        case IBSEARCH:		// Search
	        	if(!validateForm(sheetObj,formObj,sAction)) return;
		        sheetObj.SetWaitImageVisible(0);
		    	ComOpenWait(true);
	        	formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT 	        	
	        	sheetObj.DoSearch("EES_DMT_3006GS.do", FormQueryString(formObj) );
	        	break;
	    }
	}
	/**
	 * Tariff Type Code and Description information brings with IBSheet.
	 * @param sheetObj
	 * @param formObj
	 * @param comboObj
	 * @param formCmd
	 * @return
	 */
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=formCmd;
//parameter changed[check again]CLT 		
		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		switch(comboObj.options.id) {
	        case "tariff_type":
		 		// Tariff type comboList
				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj,comboItems);					
				}
				// search Tariff Type Set-Up by User
 				var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				
 				// if Tariff Type Set-Up by User is not exist, setting Default value
 				if(data2 == '') {
 					data2='DMIF';
 				} else {
 					//Tariff Type Set-Up Tariff Type has multiple values??, the first set
 					data2=data2.split('|')[0];
 				}
 				// Tariff Type IBMultiCombo initializing
 				comboObj.SetSelectCode(data2);
 				// Set Global variables (USR_TRF_TP), IBMultiCombo Tariff Type initializing function (initComboValue_tariff_type ()) for use in
 				USR_TRF_TP=data2;
 				formObj.usr_trf_tp.value=data2;
 				break;
	        case "to_mvmt_sts":
 	        	var data=ComGetEtcData(sXml, "YD");
				if (data != undefined && data != '') {
					ComSetObjValue(formObj.chk_yd_cd, "Y");
					// Yard Code Enter moves the focus to the object position.
					if(srcObj.options.id == 'fm_mvmt_yd_cd')
						formObj.to_mvmt_dt.focus();
					else {
						formObj.to_mvmt_sts.focus();
					}
				} else {
					ComSetObjValue(formObj.chk_yd_cd, "N");
					ComShowCodeMessage('DMT00110', "Yard");
					ComClearObject(srcObj);
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
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
 			case "to_mvmt_sts":
		  		switch(comboItems) {
		 			case "DTOC":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "OC", "OC");
		 				comboObj.InsertItem(2, "DR", "DR");
						break;
		 			case "CTOC":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "VL", "VL");
		 				comboObj.InsertItem(2, "DR", "DR");
						break;
		 			case "DMOF":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "VL", "VL");
		 				comboObj.InsertItem(2, "EN", "EN");
		 				comboObj.InsertItem(3, "TN", "TN");
		 				comboObj.InsertItem(4, "DR", "DR");
						break;
		 			case "DMIF":
		 				comboObj.InsertItem(1, "ID", "ID");
		 				comboObj.InsertItem(1, "ID", "ID");
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "ID", "ID");
		 				comboObj.InsertItem(2, "EN", "EN");
		 				comboObj.InsertItem(3, "TN", "TN");
		 				comboObj.InsertItem(4, "DR", "DR");
		 				comboObj.InsertItem(5, "XX", "XX");
						break;
		 			case "DTIC":
		 			case "CTIC":
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "MT", "MT");
		 				comboObj.InsertItem(2, "DR", "DR");
		 				comboObj.InsertItem(3, "CS", "CS");
		 				comboObj.InsertItem(4, "XX", "XX");
						break;
		  		}
		  		break;	
 		}
 	}
 	// Tariff Type IBCombo OnChagne event In case of handling
 	function tariff_type_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
 		/*
 		var toMvmtStsCombo=comboObjects[1];
 		toMvmtStsCombo.RemoveAll();
 		addComboItem(toMvmtStsCombo, value);
 		*/
 	}
 // To MVMT STS IBCombo OnFocus event In case of handling
 	function to_mvmt_sts_OnFocus(comboObj) {
 		comboObj.SetSelectCode(comboObj.GetSelectCode());
 	}
    /**
  	 * IBSheet lookup function Retrieving is complete, caused by an Event
  	 */
	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
  		ComOpenWait(false);
		if(ErrMsg != '') return;
		var formObj=document.form;
		with(formObj) {
  			var cntrNo=ComGetObjValue(cntr_no);
        	// Etc Data Sheet that exists to fill the Form object's value.
        	ComEtcDataToForm(formObj, sheetObj);
        	// 'Dual Type Exception' Checkbox 표시
        	if(ComGetObjValue(dul_tp_expt_flg) == 'Y')
        		dul_tp_expt_chk.checked=true;
        	else
        		dul_tp_expt_chk.checked=false;
        	var retCntrNo=ComGetObjValue(cntr_no);
        	var bilAmt='0';
        	var aftExptDcAmt='0';
        	if(retCntrNo == '') {
        		// No data found
        		ComSetObjValue(cntr_no, cntrNo);
        		//ComClearManyObjects(dmdt_chg_sts_desc, xcld_sat_flg, xcld_sun_flg, xcld_hol_flg, total_amt, aft_expt_dc_amt, bil_amt);
        		ComClearManyObjects(dmdt_chg_sts_desc, total_amt, aft_expt_dc_amt, bil_amt);
        		comboObjects[1].SetSelectCode('');
        		ComSetDisplay('tbl_webmty', false);
        		DmtComEnableManyBtns(false, 'btn_CalcDetail','btn_CorrHistory', 'btn_OTHistory',  'btn_MVMTInq');
        		//document.getElementById("btn_ROInfo").style.color = "";
        	} else {
        		sheetObj.FitColWidth();
       			ComSetDisplay('tbl_webmty', false);
        		// Data exist
       		// Search Option deactivating 
        		comboObjects[0].SetEnable(0);
        		ComEnableManyObjects(false, cntr_no, chg_type);
        		DmtComSetClassManyObjects('input2', cntr_no, chg_type);
        		var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
        		var toMvmtStsCd=ComGetObjValue(to_mvmt_sts_cd);
        		var comboObj=comboObjects[1];
        		comboObj.SetSelectCode(toMvmtStsCd);
        		if(toMvmtStsCd != '' && comboObj.GetSelectCode()== '') {
        			comboObj.InsertItem(comboObj.GetItemCount(), toMvmtStsCd.toString(), toMvmtStsCd.toString());
        			comboObj.SetSelectCode(toMvmtStsCd);
        		}
        		// Billable AMT
        		bilAmt=ComGetObjValue(bil_amt);
        		// Charge AMT TOTAL
        		var totalAmt=sheetObj.GetCellValue(sheetObj.LastRow(), "rt_chrg");
        		var xchRt=parseFloat(ComGetObjValue(xch_rt));
        		if(totalAmt == '') totalAmt='0';
        		if(xchRt != 1) {
        			totalAmt=parseFloat(totalAmt) * xchRt;
        			totalAmt=DMTtrimCurrencyAmount(ComGetObjValue(bzc_trf_curr_cd), totalAmt);
        		}
        		// Total AMT
        		total_amt.value=ComAddComma2(totalAmt+'', "#,###.00");
        		// D/C by AMT or %
        		aftExptDcAmt=parseFloat(totalAmt - bilAmt).toFixed(2);
        		/*
        		var xcldFlgs=ComGetObjValue(xcld_flgs);
        		var arrXcldFlgs=xcldFlgs.split('|');
        		for(var i=0; i<3; i++) {
        			if(arrXcldFlgs[i] == 'N') arrXcldFlgs[i]="";
        		}*/
        		// xcld_sat_flg(Y/N) | xcld_sun_flg(Y/N) | get xcld_hol_flg(Y/N)  format  --> ex.) Y|Y|Y, N|N|N
        		// 'Y' value, the checkbox is checked.
        		//ComSetObjValue(xcld_sat_flg, arrXcldFlgs[0]);
        		//ComSetObjValue(xcld_sun_flg, arrXcldFlgs[1]);
        		//ComSetObjValue(xcld_hol_flg, arrXcldFlgs[2]);
        		// After data retrieval, Charge Status Activating of button status according to the set
        		DmtComEnableManyBtns(true, 'btn_CalcDetail','btn_CorrHistory', 'btn_OTHistory', 'btn_MVMTInq');
        		// D/C by AMT or % Setting Field Values
	        	aft_expt_dc_amt.value=ComAddComma2(aftExptDcAmt+'', "#,###.00");	
	        	// Billable AMT Setting Field Values
	        	bil_amt.value=ComAddComma2(bilAmt+'', "#,###.00");
//	        	if( ComGetObjValue(roll_ovr) == 'S')
//			  		document.getElementById("btn_ROInfo").style.color = 'red';
//	        	else
//	        		document.getElementById("btn_ROInfo").style.color = '';
        	} // if else - end
        	var awkGauge="";
        	var bkgCgoTp=ComGetObjValue(dmdt_bkg_cgo_tp_cd);
        	// If Cargo Type two 'AWK' , then Awkward In / Out-Gauge Information Display (ex: AWK - In Gauge)
        	if(bkgCgoTp == 'AWK') {
        		awkGauge=ComGetObjValue(awk_gauge);
        		if(awkGauge == 'I')
        			awkGauge="In";
        		else
        			awkGauge="Out";
        		awkGauge=" - " + awkGauge + " Gauge";
        	}
        	ComSetObjValue(dmdt_bkg_cgo_tp_cd, bkgCgoTp + awkGauge);
		} // with(formObj) - end
	}
	/**
     * After saving handling
     */
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg){
    	 ComOpenWait(false);
		 if(ErrMsg != '') {	// Error when saving
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
			var formObj=document.form;
			var fCmd=formObj.f_cmd.value;
			if(fCmd == MULTI) {	// Confirm
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				/*var chkRows=sheetObj.FindCheckedRow("chk").split("|");
				for(var i=0; i < chkRows.length-1; i++) {
					sheetObj.SetCellValue(chkRows[i], "dmdt_chg_sts_cd",'C');
				}
				//All UnCheck -> sheetObj.RowStatus (i) all of the 'R' be changed to
				sheetObj.CheckAll("chk",0);*/
			} else if(fCmd == MULTI01) {	// DelCancel
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}
		 }
    }
	/*
  	 * Pop-up call processing
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj=sheetObjects[0];
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var sScroll='no';
  		var sIframe=true;
  		var modal= true;
  		var formObj=document.form;
  		var chgStsCd=ComGetObjValue(formObj.dmdt_chg_sts_cd);
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'btn_CalcDetail':
	  				var est_mk=ComGetObjValue(formObj.est_mk);
	  				var svr_id=ComGetObjValue(formObj.svr_id);
	  				var cntr_no=ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no=ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd=ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd=ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq=ComGetObjValue(formObj.chg_seq);
	  				var ofc_cd=ComGetObjValue(formObj.ofc_cd);
	  				var cntr_tpsz_cd=ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var bkg_no=ComGetObjValue(formObj.bkg_no);
	  				var bl_no=ComGetObjValue(formObj.bl_no);
	  				var fm_mvmt_dt=ComGetUnMaskedValue(formObj.fm_mvmt_dt, "ymd"); 
	  				var fm_mvmt_yd_cd=ComGetObjValue(formObj.fm_mvmt_yd_cd);			
	  				var paramVal="?est_mk=" + est_mk + "&svr_id=" + svr_id + "&cntr_no=" + cntr_no
	  										+ "&cntr_cyc_no=" + cntr_cyc_no	+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd 
	  										+ "&chg_seq=" + chg_seq + "&ofc_cd=" + ofc_cd + "&cntr_tpsz_cd=" + cntr_tpsz_cd + "&bkg_no=" + bkg_no + "&bl_no=" + bl_no
	  										+ "&fm_mvmt_dt=" + fm_mvmt_dt
	  										+ "&fm_mvmt_yd_cd=" + fm_mvmt_yd_cd
	  										;
	  				sUrl='EES_DMT_3107.do' + paramVal;
              		sWidth='920';
              		sHeight='850';
					sIframe=false;
           		break;
           		
	  			case 'btn_CorrHistory':
	  				var svr_id=ComGetObjValue(formObj.svr_id);
	  				var cntr_no=ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no=ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd=ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd=ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq=ComGetObjValue(formObj.chg_seq);
	  				var chg_type=ComGetObjValue(formObj.chg_type);
	  				var ofc_cd=ComGetObjValue(formObj.ofc_cd);
	  				var cntr_tpsz_cd=ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var bkg_no=ComGetObjValue(formObj.bkg_no);
	  				var bl_no=ComGetObjValue(formObj.bl_no);
	  				var paramVal="?svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  									+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd + "&chg_seq=" + chg_seq
	  									+ "&chg_type=" + chg_type + "&ofc_cd=" + ofc_cd + "&cntr_tpsz_cd=" + cntr_tpsz_cd + "&bkg_no=" + bkg_no + "&bl_no=" + bl_no;
	  				sUrl='EES_DMT_3103.do' + paramVal;
              		sWidth='919';
              		sHeight='515';
             	break;
             	
	  			case 'btn_OTHistory':
	  				var ofc_cd=ComGetObjValue(formObj.ofc_cd);
	  				var svr_id=ComGetObjValue(formObj.svr_id);
	  				var cntr_no=ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no=ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd=ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd=ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var chg_seq=ComGetObjValue(formObj.chg_seq);
	  				var paramVal="?ofc_cd=" + ofc_cd + "&svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  									+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd + "&chg_seq=" + chg_seq;
	  				sUrl='EES_DMT_3105.do' + paramVal;
              		sWidth='817';
              		sHeight='365';
             	break;
//	  			case 'btn_ROInfo':
//	  				var paramVal = "?bkg_no=" + ComGetObjValue(formObj.bkg_no);
//	  				sUrl	= 'ESM_BKG_0724.do' + paramVal;
//              		sWidth	= '1000';
//              		sHeight	= '450';
//	  				break;
	  			case 'btn_MVMTInq':
	  				var cntrNo=ComGetObjValue(formObj.cntr_no);
	  				var cntrTpszCd=ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var paramVal="?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
	                        		"&check_digit=" + cntrNo.substring(10,11) +
			                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl='EES_CTM_0408_POP.do' + paramVal;
					sWidth='1020';
					sHeight='690';
					sIframe=false;
  				break;
	  		} // switch-end
  		} // with-end
  		if(sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			var returnValue=ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, sIframe, sScroll);
  			if(returnValue == "Y") {
 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
 			}
  		}
  	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
			switch(sAction) {
				case IBSEARCH:     // Search
					var cntrNo=ComGetObjValue(cntr_no);
					if(cntrNo == '') {
						ComShowCodeMessage('DMT00102', "CNTR No.");
						ComSetFocus(cntr_no);
						return false;
					}
					var trfCd=comboObjects[0].GetSelectCode();
					// Screen Open separator -> call_flag == 'M': menu, call_flag == 'P': Pop-up call
					var callFlag=call_flag.value;
					if(callFlag == 'M') {
						var locDivCd;
						//[If the Open Screen Menu.] DTOC => POR, DMOF => POL, DTIC => DEL, DMIF => POD, CTOC => POR, CTIC => DEL
						if(trfCd == 'DTOC' || trfCd == 'CTOC')
							locDivCd='POR';
						else if(trfCd == 'DMOF')
							locDivCd='POL';
						else if(trfCd == 'DTIC' || trfCd == 'CTIC')
							locDivCd='DEL';
						else if(trfCd == 'DMIF')
							locDivCd='POD';
						ComSetObjValue(dmdt_chg_loc_div_cd, locDivCd);
					}
					ComSetObjValue(dmdt_trf_cd, trfCd);
					break;
				case IBSAVE:
					var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
					var to_mvmt_sts=ComGetObjValue("to_mvmt_sts_cd");
					if( (chgStsCd == 'F' || chgStsCd == 'U' || chgStsCd == 'L') && to_mvmt_sts == 'DR') {
					}
					else {
     					ComShowCodeMessage('DMT03018');
     					return false;
     				}
     				break;
				case IBCONFIRM:      //Confirm
         			var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
     				if(chgStsCd != 'F') {
     					//ComShowCodeMessage('DMT03018');
     					ComBtnDisable("btn_Confirm");
     					return false;
     				}
     				ComSetObjValue(ibflag, "U");
             		break;
             	case IBDELCANCEL:
             		var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
     				if(chgStsCd != 'D') {
     					ComBtnDisable("btn_DELCancel");
     					return false;
     				}
             		ComSetObjValue(ibflag, "U");
             		break;
             	case IBPRECAL:	
             	case IBDRSAVE:
             		var drDt=ComGetObjValue(dr_dt);
             		if(drDt == '') {
             			ComShowCodeMessage('DMT02002', 'D/R Date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		drDt=ComGetUnMaskedValue(dr_dt, "ymd");
             		if(ComChkPeriod(drDt, CURR_DATE) == 1) { //1 : fromDate < toDate
             			ComShowCodeMessage('DMT01031', 'D/R Date', 'current date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return false;
             		}
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var fmMvmtDt=sheetObj.GetCellValue(chkRows[i], "fm_mvmt_dt");
     					if(ComChkPeriod(drDt, fmMvmtDt) == 1) {
                 			ComShowCodeMessage('DMT01031', 'D/R Date', 'From date');
                 			sheetObj.SetSelectRow(chkRows[i]);
                 			return false;
                 		}
     					var chgStsCd=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
     					var to_mvmt_sts=sheetObj.GetCellValue(chkRows[i], "to_mvmt_sts_cd");
         				if((chgStsCd == 'F' && to_mvmt_sts == 'DR') || chgStsCd == 'U' || chgStsCd == 'L') {
         				} else {
         					ComShowCodeMessage('DMT01059');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
             		}
             		break;
			} // switch - end	
    	} // with - end
        return true;
    }
