/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_DMT_3003.js
 *@FileTitle  : Charge Calculation by CNTR
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/11
=========================================================*/
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
		var sheetObj=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcObj=window.event.srcElement;
     		var srcName=srcObj.getAttribute("name");
			// Click the button at the bottom of the grid is disabled, return
			if(!ComIsBtnEnable(srcName)) return;
             switch(srcName) {
             	case "btn_PreCal":
             		if(ComGetBtnDisable(srcName)){
             			return false;
             		}
             		doActionIBSheet(sheetObj,formObj,IBPRECAL);
					break;
             	case "btn_WebCancel":
             		if(ComGetBtnDisable(srcName)){
             			return false;
             		}
             		doActionIBSheet(sheetObj,formObj,IBWEBCANCEL);
					break;
             	case "btn_Retrieve":
             		if(ComGetBtnDisable(srcName)){
             			return false;
             		}
             		ComSetObjValue(formObj.est_mk, "");
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
				case "btn_New":
					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
					ComResetAll();
					doInit();
					break;
				case "btn_Close":
					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
 					//window.returnValue="Y";
					ComPopUpReturnValue("Y");
					break;
				case "btn_Save":
					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
 					break;
 				case "btn_Confirm":
 					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
 					doActionIBSheet(sheetObj,formObj,IBCONFIRM);
 					break;
 				case "btn_DELCancel":
 					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
 					doActionIBSheet(sheetObj,formObj,IBDELCANCEL);
 					break;
 				case "btn_DRCancel":
 					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
 					doActionIBSheet(sheetObj,formObj,IBDRCANCEL);
 					break;
 				case "btns_calendar1": //Calendar button
 					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
             		//if(srcObj.style.cursor == "hand") {
					var cal=new ComCalendar();
					cal.select(formObj.fm_mvmt_dt, 'yyyy-MM-dd');
             		//}
					break;
		        case "btns_calendar2": //Calendar button
		        	if(ComGetBtnDisable(srcName)){
             			return false;
             		}
		        	//if(srcObj.style.cursor == "hand") {
	                var cal=new ComCalendar();
	                cal.select(formObj.to_mvmt_dt, 'yyyy-MM-dd');
		        	//}
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
					if(ComGetBtnDisable(srcName)){
             			return false;
             		}
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
		var formObj=document.form;
		//Displays a pop-up title at the call handling
		if(ComGetObjValue(formObj.call_flag) == "P") {
//			var spanObj=document.getElementById("title2");
//       	 	spanObj.innerText=" Charge Calculation by CNTR";
       	 	ComSetDisplay('btn_Close', true);
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
		
		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 		sheetObj.SetWaitImageVisible(0);
 		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
 		initComboValue_tariff_type();
		doInit();
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
			if(opnSheetObj.GetCellValue(opnSheetObj.GetSelectRow(), "to_mvmt_sts_cd") == 'PC') {
				// Search PreCal information
				ComSetObjValue(formObj.est_mk, "P");
			}
			// Retrieve 
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
        sheetObj.SetWaitImageVisible(1);
	}
	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
    //no support[check again]CLT 	function sheet1_OnLoadFinish() {
		
   	//} 
	// Screen initializing
	function doInit() {
		var formObj=document.form;
		initBtns();
		ComSetDisplay('tbl_webmty', false);
		with(formObj) {
			if(ComGetObjValue(formObj.call_flag)=='M') {
				ComEnableObject(cntr_no, true);
				DmtComSetClassManyObjects('input1', cntr_no);
			}
			ComEnableManyObjects(true, chg_type, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
			DmtComSetClassManyObjects('input1', fm_mvmt_dt, fm_mvmt_yd_cd);
			ComEnableManyObjects(true, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
			DmtComSetClassManyObjects('input1', to_mvmt_dt, to_mvmt_yd_cd);
			//comboObjects[0].Enable = true;
			comboObjects[1].SetEnable(1);
		}
	}
	/**
	  * Screen initializing
	  */
	function initBtns() {
		// Activating of button status initializing
		DmtComEnableManyBtns(false, 'btn_PreCal','btn_Save','btn_Confirm','btn_Demand','btn_Billing','btn_OFCTrans','btn_Delete'
									,'btn_DELCancel','btn_Partial','btn_DRCancel','btn_CalcDetail','btn_CorrHistory'
									,'btn_MVMTInq','btn_ExceptionInq', 'btn_OTHistory');
		document.getElementById("btn_PreCal").style.color='';
		//document.getElementById("btn_ROInfo").style.color = '';
		ComSetDisplay('btn_WebCancel1', false);
	}
	function initControl() {
		axon_event.addListenerFormat('blur',	'obj_blur',		document.form); //- out of focus
//		axon_event.addListenerFormat('focus',	'obj_focus',	document.form); // Get focus
		//axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard
		//axon_event.addListener('keydown',	'obj_keydown',		'form');
		//axon_event.addListener('keyup',		'obj_keyup',		'fm_mvmt_yd_cd', 'to_mvmt_yd_cd');
		axon_event.addListener('mouseover', 'obj_mouseover',	'td_ch', 'rlse_dt');
		axon_event.addListener('mouseout',	'obj_mouseout',		'td_ch', 'rlse_dt');
	}
	// keydown event 
	function obj_keydown() {
		// Remark (s) after entering the item, except the Enter key lookup 
		if(ComGetEvent("name") == 'corr_rmk') return;
		ComKeyEnter();
	}
	/*
	 * KeyUp event  - From/To Yard Code Validation 
	 */
	function obj_keyup() {
		var keyValue=event.keyCode;
		if(keyValue == 9) return;	// tab key
		var srcObj=ComGetEvent();
		var formObj=document.form;
		var ydCd=ComTrim(ComGetObjValue(srcObj));
		if (ydCd.length == 7) {
			formObj.yd_cd1.value=ydCd;
			doActionIBCombo(sheetObjects[0], formObj, comboObjects[1], SEARCH14, srcObj);
		}
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
		var obj=event.srcElement;
	 	if(obj.name == 'fm_mvmt_yd_cd' || obj.name == 'to_mvmt_yd_cd') {
	 		if(obj.value.length > 0 && obj.value.length < 7) {
	 			ComSetObjValue(document.form.chk_yd_cd, "N");
	 			ComShowCodeMessage('DMT00110', 'Yard');
	 			ComClearObject(obj);
	 			ComSetFocus(obj);
	 		}
	 	} else
	 		ComChkObjValid(obj);
	}
    /**
     * HTML Control Foucs in
     */
	function obj_focus(){
		var obj=event.srcElement;
        //If you have a block of text so as to choose.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) {
        	ComClearSeparator(obj);
        	obj.select();
        }
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
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"hidStatus" },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rt_over",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rt_under",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"rt_rate",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"rt_day",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rt_cur_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"AutoSum",   Hidden:0, Width:80,  Align:"Right",   ColMerge:0,   SaveName:"rt_chrg",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
					   
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
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "45");
					SetColWidth(1, "300");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					SetBackColor("#CCFFFD");
		    	}
				break;
	    	case "to_mvmt_sts":
				with (comboObj) { 
    				SetMultiSelect(0);
    				SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "60");
					SetDropHeight(170);
					SetColBackColor(0,"#CCFFFD");
					SetBackColor("#CCFFFD");
					ValidChar(2);	// use upper case
					SetMaxLength(2);
   		    	}
				addComboItem(comboObj, 'DMIF');
   	    		break;
	    } // switch end
	}
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg(false);
	    if(!validateForm(sheetObj,formObj,sAction)) return;
        sheetObj.SetWaitImageVisible(0);
    	ComOpenWait(true);
	    switch(sAction) {
	        case IBSEARCH:		// Search
	        	formObj.f_cmd.value=SEARCH;
        		sheetObj.DoSearch("EES_DMT_3003GS.do", FormQueryString(formObj) );
	        	var req_stu=formObj.dmdt_delt_rqst_sts_cd.value;
	        	 if (req_stu =='R'){
	        		 formObj.dmdt_chg_sts_desc.style.color="1e90ff";
	        		 formObj.dmdt_chg_sts_desc.style.fontWeight="bold";
	             }else if(req_stu =='J'){
	            	  formObj.dmdt_chg_sts_desc.style.color="red";
	            	  formObj.dmdt_chg_sts_desc.style.fontWeight="bold";
 		         }else { 
 		        	  formObj.dmdt_chg_sts_desc.style.color="black";
 		         }
	        	break;
	        case IBSAVE:		// Save
				formObj.f_cmd.value=MODIFY;
				var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveData(sXml);
				break;
	        case IBCONFIRM:		// Confirm
				formObj.f_cmd.value=MULTI;
				var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));
				sheetObj.LoadSaveData(sXml);
				break;
			case IBDELCANCEL:	// Delete Cancel
				 formObj.f_cmd.value=MULTI01;
				 var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));
				 sheetObj.LoadSaveData(sXml);
				 break;
			case IBPRECAL:
	         	formObj.f_cmd.value=MULTI02;
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));
	         	sheetObj.LoadSaveData(sXml);
	         	break;
			case IBWEBCANCEL:
	         	formObj.f_cmd.value=MODIFY01;
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));
	         	sheetObj.LoadSaveData(sXml);
	         	break;
			case IBDRCANCEL:	// D/R Cancel
				if(ComGetObjValue(formObj.chg_seq) == '1') {
					// 추가 로직 2016-06-01
					ComSetObjValue(formObj.to_mvmt_dt, "");
					ComSetObjValue(formObj.to_mvmt_yd_cd, "");
					ComSetObjValue(comboObjects[1], "");
					ComSetObjValue(formObj.to_mvmt_sts_cd, "");
					comboObjects[1].SetSelectCode(0);
					
				    formObj.f_cmd.value=MODIFY;
				    var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));					
				} else {
					formObj.f_cmd.value=REMOVE;
					var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));
				}							    

				sheetObj.LoadSaveData(sXml);
				break;
	    }
	}
	/**
	 * Tariff Type Code and Description information brings with IBSheet.
	 */
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=formCmd;
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
 				if(data2 == '')
 					data2='DMIF';
 				else {
 					//Tariff Type Set-Up Tariff Type has multiple values??, the first set
 					data2=data2.split(',')[0];
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
		  				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0].toString());
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
						comboObj.InsertItem(0, "", "");
		 				comboObj.InsertItem(1, "ID", "ID");
		 				comboObj.InsertItem(2, "EN", "EN");
		 				comboObj.InsertItem(3, "TN", "TN");
		 				comboObj.InsertItem(4, "DR", "DR");
		 				comboObj.InsertItem(5, "XX", "XX");
		 				if(ComGetObjValue(document.form.dmdt_chg_loc_div_cd) == 'TSP')
		 					comboObj.InsertItem(6, "VL", "VL");
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
 	function tariff_type_OnChange(OldIndex, OldText, OldCode, NewIndex, NewText, NewCode) {
 		var toMvmtStsCombo=comboObjects[1];
 		toMvmtStsCombo.RemoveAll();
 		addComboItem(toMvmtStsCombo, NewCode);
 	}
	// Tariff Type IBCombo OnChagne event In case of handling
 	function tariff_type_OnKeyDown(comboObj, keyCode, shift) {
 		//if(keyCode == 13) ComKeyEnter();
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
  		// Error occurs during Search
  		if(ErrMsg != '') return;
  		var formObj=document.form;
  		with(formObj) {
			var fCmd=ComGetObjValue(f_cmd);
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
        	// No data found
        	if(retCntrNo == '') {
        		ComSetObjValue(cntr_no, cntrNo);
        		//ComClearManyObjects(dmdt_chg_sts_desc, xcld_sat_flg, xcld_sun_flg, xcld_hol_flg, total_amt, aft_expt_dc_amt, bil_amt);
        		ComClearManyObjects(dmdt_chg_sts_desc, total_amt, aft_expt_dc_amt, bil_amt);
        		comboObjects[1].SetSelectCode('');
        		// Activating of button status initializing
        		DmtComEnableManyBtns(false, 'btn_PreCal','btn_Save','btn_Confirm','btn_Demand','btn_Billing','btn_OFCTrans','btn_Delete'
        									,'btn_DELCancel','btn_Partial','btn_DRCancel','btn_CalcDetail','btn_CorrHistory'
        									,'btn_MVMTInq','btn_ExceptionInq', 'btn_OTHistory');
        		ComSetDisplay('btn_WebCancel', false);
        		//document.getElementById("btn_ROInfo").style.color = "";
        	} else {
        		sheetObj.FitColWidth();
        		// Query results, even when there is no grid to run DoSave or DoAllSave.
        		/*
        		if(sheetObj.SearchRows()== 0) {
	        		var row=sheetObj.DataInsert(-1);
	        		sheetObj.SetCellValue(row, "rt_chrg","0");
	        		sheetObj.SetRowHidden(row,1);
	        		sheetObj.SetRowHidden(sheetObj.LastRow(),1);
        		}*/
        		// ********** Data exist ************
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
        		// xcld_sat_flg(Y/N) | xcld_sun_flg(Y/N) | xcld_hol_flg(Y/N) format  --> 예) Y|Y|Y, N|N|N
        		// 'Y' value, the checkbox is checked.
        		/*
        		ComSetObjValue(xcld_sat_flg, arrXcldFlgs[0]);
        		ComSetObjValue(xcld_sun_flg, arrXcldFlgs[1]);
        		ComSetObjValue(xcld_hol_flg, arrXcldFlgs[2]);
        		*/
        		// Charge Sequence,   fm_mvmt_dt, fm_mvmt_yd_cd / to_mvmt_dt, to_mvmt_yd_cd, to_mvmt_sts_cd , activating /deactivating 
        		var chgSeq=ComGetObjValue(chg_seq);
        		var chgMaxSeq=ComGetObjValue(chg_max_seq);
        		if(chgSeq == '1') { // General Charge
        			ComEnableManyObjects(true, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
        			DmtComSetClassManyObjects('input1', fm_mvmt_dt, fm_mvmt_yd_cd);
        			if(chgMaxSeq == '1') { //Exists than General Charge - From / To enable both
        				ComEnableManyObjects(true, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
	        			DmtComSetClassManyObjects('input1', to_mvmt_dt, to_mvmt_yd_cd);
	        			comboObjects[1].SetEnable(1);
        			} else {
	        			ComEnableManyObjects(false, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
	        			DmtComSetClassManyObjects('input2', to_mvmt_dt, to_mvmt_yd_cd);
	        			comboObjects[1].SetEnable(0);
        			}
        		} else if(chgSeq < chgMaxSeq) { // From/To  deactivating 
        			ComEnableManyObjects(false, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
        			DmtComSetClassManyObjects('input2', fm_mvmt_dt, fm_mvmt_yd_cd);
        			ComEnableManyObjects(false, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
        			DmtComSetClassManyObjects('input2', to_mvmt_dt, to_mvmt_yd_cd);
        			comboObjects[1].SetEnable(0);
        		} else { // chg_seq == chg_max_seq(last data Balance Charge)
        			ComEnableManyObjects(false, fm_mvmt_dt, fm_mvmt_yd_cd, btns_calendar1);	        			
        			DmtComSetClassManyObjects('input2', fm_mvmt_dt, fm_mvmt_yd_cd);
        			ComEnableManyObjects(true, to_mvmt_dt, to_mvmt_yd_cd, btns_calendar2);
        			DmtComSetClassManyObjects('input1', to_mvmt_dt, to_mvmt_yd_cd);
        			comboObjects[1].SetEnable(1);
        		}
        		// After data retrieval, Charge Status Activating of button status according to the set
        		DmtComEnableManyBtns(true,	'btn_Demand', 'btn_Billing', 'btn_OFCTrans', 'btn_DRCancel', 'btn_CalcDetail'
        								, 'btn_CorrHistory', 'btn_MVMTInq' ,'btn_ExceptionInq', 'btn_OTHistory');
        		// Web, "Y" if (web_ind_flg = 'Y') one only, Web M'ty / Grace End field and the 'Web Cancel' button shows.
        		if(ComGetObjValue(web_ind_flg) == 'Y') {
        			ComSetDisplay('tbl_webmty', true);
        			ComSetDisplay('btn_WebCancel', true);
        		} else {
        			ComSetDisplay('tbl_webmty', false);
        			ComSetDisplay('btn_WebCancel', false);
        		}
        		//After PreCal, Retrieve for 'Pre Cal.' button and disabled, it changes to red
        		if(ComGetObjValue(est_mk) == 'P') {
        			document.getElementById("btn_PreCal").style.color='red';
        			DmtComEnableManyBtns(false, 'btn_PreCal','btn_Save','btn_Confirm','btn_Demand','btn_Billing','btn_OFCTrans','btn_Delete'
        					,'btn_DELCancel','btn_Partial','btn_DRCancel');
        		} else {
        			document.getElementById("btn_PreCal").style.color='';
        			DmtComEnableManyBtns(true, 'btn_PreCal', 'btn_Save');
        			//By Charge Status Activating of button deactivating
	        		if(chgStsCd == 'F')
	        			ComBtnEnable("btn_Confirm");
	        		else
	        			ComBtnDisable("btn_Confirm");
	        		if(chgStsCd == 'D') {
	        			ComBtnDisable("btn_Delete");
	        			ComBtnEnable("btn_DELCancel");
	        		} else {
	        			ComBtnEnable("btn_Delete");
	        			ComBtnDisable("btn_DELCancel");
	        		}
	        		if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'L' || chgStsCd == 'I')
	        			ComBtnEnable("btn_Partial");
	        		else
	        			ComBtnDisable("btn_Partial");
	        		// Case in Charge Type = Balance 'DRCancel'Activating of button
	        		if(ComGetObjValue(chg_seq) == '1') {
						formObj.f_cmd.value=SEARCH01;
						var sXml=sheetObj.GetSaveData("EES_DMT_3003GS.do", FormQueryString(formObj));
						var rtnStr=ComGetEtcData(sXml, "COUNT");	
	        			if (rtnStr == '1' && (chgStsCd == 'F' || chsStsCd == 'C') && comboObjects[1].GetSelectCode() == 'DR') {
	        				ComBtnEnable("btn_DRCancel");
	        			} else {	// Charge Type: General
		        			ComBtnDisable("btn_DRCancel");
	        			}
	        		}	
	        		else
	        			ComBtnEnable("btn_DRCancel");			// Charge Type: Balance
        		}	
        		// D/C by AMT or % Setting Field Values
	        	aft_expt_dc_amt.value=ComAddComma2(aftExptDcAmt+'', "#,###.00");	
	        	// Billable AMT Setting Field Values
	        	bil_amt.value=ComAddComma2(bilAmt+'', "#,###.00");
//	        	if(ComGetObjValue(roll_ovr) == 'S')
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
    	// Error when saving
		if(ErrMsg != '') return;
		var formObj=document.form;
		var fCmd=formObj.f_cmd.value;
		if(fCmd == MULTI02) {	// after Pre Calculation
			ComSetObjValue(formObj.est_mk, "P");
			// 'Pre Cal.' button changes color to red
			document.getElementById("btn_PreCal").style.color="red";
		} else if(fCmd == REMOVE) {
			if(ComGetObjValue(formObj.call_flag) == "P") {
				//window.returnValue="Y";
				//ComClosePopup(); 
				ComPopUpReturnValue("Y");
			}
		}
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }
	/*
  	 * Pop-up call processing
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var paramVal='';
  		var sScroll='no';
  		var sIframe=true;
		var modal = true;
  		var chgStsCd=ComGetObjValue(formObj.dmdt_chg_sts_cd);
		var delt_rqst_sts="";
 		delt_rqst_sts=ComGetObjValue(formObj.dmdt_delt_rqst_sts_cd) //2011.10.10
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'btn_Demand':
     				if( !(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'I' || chgStsCd == 'L' || chgStsCd == 'U') ) {
     					ComShowCodeMessage('DMT01077');
        				return;
     				}
     				chgStsCd="F,C,I,L,U";
     				paramVal="?group_by=2"
		     	 	 			+"&chg_type="	+ ComGetObjValue(formObj.chg_type)
		     	 	 			+"&ofc_cd="		+ ComGetObjValue(formObj.ofc_cd)
		     	 				+"&dmdt_chg_sts_cd=" + chgStsCd
		     	 				+"&bkg_no="		+ ComGetObjValue(formObj.bkg_no)
		     	 				+"&dmdt_trf_cd="+ ComGetObjValue(formObj.dmdt_trf_cd)
		     	 				+"&cntr_no="	+ ComGetObjValue(formObj.cntr_no)
		     	 				+"&dmdt_inv_no="
		     	 				+"&invoice_issue=1"	//Invoice Issue BEFORE
		     	 				;
             		sUrl='EES_DMT_3109.do' + paramVal;
              		sWidth  = '945';
              		sHeight = '688';
              		sIframe = false;
  				break;
  				
	  			case 'btn_Billing':
	  				var chgStsCd=ComGetObjValue(formObj.dmdt_chg_sts_cd);
             		var invIssue='1'; // before:1, after:2
             		var invNo='';
             		var ofcCd='';
             		if(delt_rqst_sts == "R") {
     					ComShowCodeMessage('DMT01154');
     					return;
     				}
             		if(chgStsCd == 'I') {
	  					invIssue='2';
	  					invNo=ComGetObjValue(formObj.dmdt_inv_no);
	  					ofcCd=ComGetObjValue(formObj.cre_ofc_cd);
	  				} else if(chgStsCd != 'C') {
	  					ComShowCodeMessage('DMT01076', 'Billing');
         				return;
             		} else {
             			ofcCd=ComGetObjValue(formObj.ofc_cd);
             		}
         			paramVal="?group_by=2"
		        				+ "&chg_type="		+ ComGetObjValue(formObj.chg_type)
		        				+ "&ofc_cd="		+ ofcCd
		        				+ "&bkg_no="		+ ComGetObjValue(formObj.bkg_no)
		        				+ "&dmdt_trf_cd="	+ ComGetObjValue(formObj.dmdt_trf_cd)
		        				+ "&invoice_no="	+ invNo
		        				+ "&invoice_issue=" + invIssue;
			        sUrl='EES_DMT_4002.do' + paramVal;
              		sWidth  = '1050';
              		sHeight = '660';
              		sIframe = false;              		
           		break;
           		
	  			case 'btn_OFCTrans':	
	  				if(chgStsCd != 'F' && chgStsCd != 'L') {
	  					ComShowCodeMessage('DMT01019');
     					return;
	  				}
       				if(delt_rqst_sts == "R") {
     					ComShowCodeMessage('DMT01153');
     					return;
     				}
             		var fmOfcCd=ComGetObjValue(formObj.ofc_cd);
             		var ofcRhqCd=ComGetObjValue(formObj.ofc_rhq_cd);
		  			var paramVal="?fm_ofc_cd=" + fmOfcCd + "&ofc_rhq_cd=" + ofcRhqCd;
             		sUrl='EES_DMT_3101.do' + paramVal;
              		sWidth  = '618';
              		sHeight = '445';
              		sIframe = true;
					modal   = true;
           		break;
           		
	  			case 'btn_Delete':
	  				if(chgStsCd == 'I') {
	  					ComShowCodeMessage('DMT01026');
	  					return;
	  				}
	  				if(chgStsCd == 'D') {
		  				ComShowCodeMessage("DMT00176", ComGetObjValue(formObj.bkg_no));
	  					return;
	  				}
           			//2011.10.10 KHH [CHM-201113639-01]
        			if(delt_rqst_sts=='R'){
        				ComShowCodeMessage('DMT01155');
        				return;
        			}
	  				sUrl='EES_DMT_3104.do';
              		sWidth  = '450';
              		sHeight = '549';
              		sIframe=true;
  				break;
  				
	  			case 'btn_Partial':
	  				if(ComGetObjValue(formObj.dul_tp_expt_flg) == 'Y') {
	  					ComShowCodeMessage('DMT03069', 'Split');
	  					return;
	  				}
      				if(delt_rqst_sts == "R") {
     					ComShowCodeMessage('DMT01155');
     					return;
     				}					
	  				var svr_id=ComGetObjValue(formObj.svr_id);
	  				var cntr_no=ComGetObjValue(formObj.cntr_no);
	  				var cntr_cyc_no=ComGetObjValue(formObj.cntr_cyc_no);
	  				var dmdt_trf_cd=ComGetObjValue(formObj.dmdt_trf_cd);
	  				var dmdt_chg_loc_div_cd=ComGetObjValue(formObj.dmdt_chg_loc_div_cd);
	  				var cntr_tpsz_cd=ComGetObjValue(formObj.cntr_tpsz_cd);
	  				var dmdt_chg_sts_cd=ComGetObjValue(formObj.dmdt_chg_sts_cd);
	  				var bkg_no=ComGetObjValue(formObj.bkg_no);
	  				var bl_no=ComGetObjValue(formObj.bl_no);
	  				var paramVal="?svr_id=" + svr_id + "&cntr_no=" + cntr_no + "&cntr_cyc_no=" + cntr_cyc_no
	  									+ "&dmdt_trf_cd=" + dmdt_trf_cd + "&dmdt_chg_loc_div_cd=" + dmdt_chg_loc_div_cd
	  									+ "&bkg_no=" + bkg_no + "&bl_no=" + bl_no + "&cntr_tpsz_cd=" + cntr_tpsz_cd
	  									+ "&dmdt_chg_sts_cd=" + dmdt_chg_sts_cd;
	  				sUrl='EES_DMT_3102.do' + paramVal;
              		sWidth  = '880';
              		sHeight = '390';
              		sIframe = true;
              		//ComOpenWindow(sUrl, 'EES_DMT_3102', 'width='+sWidth+',height='+sHeight);
              		//return;
           		break;
           		
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
              		sHeight='650';
              		sIframe=false;
              		//ComOpenWindow(sUrl, 'EES_DMT_3107', 'width='+sWidth+',height='+sHeight);
              		//return;
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
              		sWidth  = '919';
              		sHeight = '515';
              		sIframe = true;
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
              		sWidth  = '817';
              		sHeight = '365';
              		sIframe=true;
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
					modal = false;
	  				break;
	  			case 'btn_ExceptionInq':
	  				var scNo=ComGetObjValue(formObj.sc_no);
	  				var rfaNo=ComGetObjValue(formObj.rfa_no);
	  				if(scNo != '' && rfaNo != '') scNo='';
	  				paramVal="?caller=3003"
	  							+ "&sc_no=" + scNo
	  							+ "&rfa_no=" + rfaNo
	  							+ "&trf_cd=" + ComGetObjValue(formObj.dmdt_trf_cd)
	  							;
	  				sUrl='EES_DMT_2007_1_POP.do' + paramVal;
              		sWidth  = '1280';
              		sHeight = '700';
              		sScroll = 'yes';
              		sIframe=false;
					modal = false;
	  				break;
	  		} // switch-end
  		} // with-end

  		if(sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenPopup(sUrl, sWidth, sHeight, "findCommodity", "0,1", modal);
  		}
//  		if(sUrl != '') {
//  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
//  			var returnValue=ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, sIframe, sScroll);
//  			if(returnValue == "Y") {
// 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
// 			}
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
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
			var delt_rqst_sts=ComGetObjValue(dmdt_delt_rqst_sts_cd);
			switch(sAction) {
				case IBSEARCH:     // Search
					var cntrNo=ComGetObjValue(cntr_no);
					if(cntrNo == '') {
						ComShowCodeMessage('DMT00102', "CNTR No.");
						ComSetFocus(cntr_no);
						return false;
					}
					var trfCd=comboObjects[0].GetSelectCode();
					// Screen Open separator -> call_flag == 'M'enu: menu, call_flag ==' P'opup: Pop-up call
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
				case IBWEBCANCEL:
					// If the Invoiced Status Error Handling
					var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
             		if(chgStsCd == 'I') {
             			var msg=(sAction == IBSAVE) ? 'save' : 'web cancel';
             			ComShowCodeMessage('DMT01068', msg);
            			return false;
             		}
             		//Balance Charge does not exist, or (General Charge) available only if the last Balance Charge
             		if(ComGetObjValue(chg_seq) != ComGetObjValue(chg_max_seq)) {
             			ComShowCodeMessage('DMT01030');
            			return false;
             		}
             		// Check mandatory item(CNTR No.)
					if(ComIsEmpty(cntr_no)) {
						ComShowCodeMessage('DMT03028', 'CNTR No.');
						ComSetFocus(cntr_no);
            			return false;
					}
					// Check mandatory item(From MVMT Date)
             		if(ComIsEmpty(fm_mvmt_dt)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Date');
						ComSetFocus(fm_mvmt_dt);
            			return false;
             		}
             		// Check mandatory item(From MVMT Yard)
             		if(ComIsEmpty(fm_mvmt_yd_cd)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Yard');
						ComSetFocus(fm_mvmt_yd_cd);
            			return false;
             		}
             		if(sAction == IBSAVE) {
	             		/*
	             		Status is Long Staying, Unfinished, No Charge, or if Error
						 To Date / Yard / Status Not a required field.
						When any one of three inputs, and all three are mandatory, 
						If all three with no Pre Cal. / Save is possible
	             		 */
	             		if(chgStsCd == 'L' || chgStsCd == 'U' || chgStsCd == 'N' || chgStsCd == 'E') {
	             			if( !ComIsNull(to_mvmt_dt) || !ComIsNull(to_mvmt_yd_cd) || ComGetObjValue(comboObjects[1]) != '' ) {
	             				if(ComIsNull(to_mvmt_dt)) {
	             					ComShowCodeMessage('DMT02002', 'To MVMT Date');
	             					ComSetFocus(to_mvmt_dt);
	                    			return false;
	             				}
	             				if(ComIsNull(to_mvmt_yd_cd)) {
	             					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
	             					ComSetFocus(to_mvmt_yd_cd);
	                    			return false;
	             				}
	             				if(ComGetObjValue(comboObjects[1]) == '') {
	             					ComShowCodeMessage('DMT02002', 'To MVMT Status');
	                    			return false;
	             				}
	             			}
	             		} else if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'D') {
	             			if(ComIsNull(to_mvmt_dt)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Date');
             					ComSetFocus(to_mvmt_dt);
                    			return false;
             				}
             				if(ComIsNull(to_mvmt_yd_cd)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
             					ComSetFocus(to_mvmt_yd_cd);
                    			return false;
             				}
             				if(ComGetObjValue(comboObjects[1]) == '') {
             					ComShowCodeMessage('DMT02002', 'To MVMT Status');
                    			return false;
             				}
	             		}
						if(!ComIsNull(fm_mvmt_dt) && !ComIsNull(to_mvmt_dt)) {
		             		var fmMvmtDt=ComGetObjValue(fm_mvmt_dt);
		             		var toMvmtDt=ComGetObjValue(to_mvmt_dt);
		             		/*
		          	    	 ComChkPeriod(fromDate, toDate)
		          	    	 0 : fromDate > toDate
		          	    	 1 : fromDate < toDate
		          	    	 2 : fromDate=toDate
		          	    	 */
							if(ComChkPeriod(fmMvmtDt, toMvmtDt) == 0) {
								ComShowCodeMessage('DMT01020');
		            			return false;
		            		}
							var toMvmtStsCd=comboObjects[1].GetSelectCode();
							if(toMvmtStsCd == 'DR') {
								//The current date by User Office Retrieving
								var currDt=DmtComOfficeCurrDate(sheetObj, formObj);
								if(ComChkPeriod(toMvmtDt, currDt) == 1) {
			            			ComShowCodeMessage('DMT01031', 'D/R Date', 'current date');
			            			return false;
			            		}
							}
	             		}
             		}
					// Check mandatory item(Remark(s))
             		if(ComIsNull(corr_rmk)) {
						ComShowCodeMessage('DMT01038');
						ComSetFocus(corr_rmk);
            			return false;
					}
					if(ComGetLenByByte(corr_rmk) < 10) {
						ComShowCodeMessage('COM12143', 'Remark(s)', '10');
						ComSetFocus(corr_rmk);
     					return false;
					}
					// Web Cancel 
					if(sAction == IBWEBCANCEL) {
						if(!ComShowCodeConfirm('DMT01037')) return false;
						// To information initializing
						ComSetObjValue(to_mvmt_dt, "");
						ComSetObjValue(to_mvmt_yd_cd, "");
						ComSetObjValue(comboObjects[1], "");
						ComSetObjValue(web_cancel_flg, "Y");
						ComSetObjValue(corr_rmk, "Web Cancel: " + ComGetObjValue(corr_rmk));
					} else {	
						// Save 
						ComSetObjValue(web_cancel_flg, "N");
					}
					// setting  To MVMT Status Code 
					ComSetObjValue(to_mvmt_sts_cd, comboObjects[1].GetSelectCode());
     				break;
				case IBCONFIRM:      //Confirm
     				if(chgStsCd != 'F') {
     					//ComShowCodeMessage('DMT03018');
     					ComBtnDisable("btn_Confirm");
     					return false;
     				}
     				ComSetObjValue(ibflag, "U");
             		break;
             	case IBDELCANCEL:
     				if(chgStsCd != 'D') {
     					ComBtnDisable("btn_DELCancel");
     					return false;
     				}
     				if(!ComShowCodeConfirm('DMT01063'))
             			return false;
             		ComSetObjValue(ibflag, "U");
             		break;
             	case IBDRCANCEL:
             	    if (delt_rqst_sts =='R'){
           	         	ComShowCodeMessage('DMT01155');
        				return;
           	        }				
             		if(!ComShowCodeConfirm('DMT01039'))
             			return false;
             		if(chgStsCd == 'I') {
             			ComShowCodeMessage('DMT01043');
             			return false;
             		}
             		break;
             	case IBPRECAL:
             		var chgStsCd=ComGetObjValue(dmdt_chg_sts_cd);
             		if(chgStsCd == 'I') {
             			ComShowCodeMessage('DMT01068', 'pre cal.');
            			return false;
             		}
             		//Balance Charge does not exist, or (General Charge) available only if the last Balance Charge
             		if(ComGetObjValue(chg_seq) != ComGetObjValue(chg_max_seq)) {
             			ComShowCodeMessage('DMT01030');
            			return false;
             		}
             		// Check mandatory item(CNTR No.)
					if(ComIsEmpty(cntr_no)) {
						ComShowCodeMessage('DMT03028', 'CNTR No.');
						ComSetFocus(cntr_no);
            			return false;
					}
					// Check mandatory item(From MVMT Date)
             		if(ComIsEmpty(fm_mvmt_dt)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Date');
						ComSetFocus(fm_mvmt_dt);
            			return false;
             		}
             		// Check mandatory item(From MVMT Yard)
             		if(ComIsEmpty(fm_mvmt_yd_cd)) {
             			ComShowCodeMessage('DMT03028', 'From MVMT Yard');
						ComSetFocus(fm_mvmt_yd_cd);
            			return false;
             		}
             		/*
             		Status is Long Staying, Unfinished, No Charge, or if Error
					 To Date / Yard / Status Not a required field.
					When any one of three inputs, and all three are mandatory, 
					If all three with no Pre Cal. / Save is possible
             		 */
             		if(chgStsCd == 'L' || chgStsCd == 'U' || chgStsCd == 'N' || chgStsCd == 'E') {
             			if( !ComIsNull(to_mvmt_dt) || !ComIsNull(to_mvmt_yd_cd) || ComGetObjValue(comboObjects[1]) != '' ) {
             				if(ComIsNull(to_mvmt_dt)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Date');
             					ComSetFocus(to_mvmt_dt);
                    			return false;
             				}
             				if(ComIsNull(to_mvmt_yd_cd)) {
             					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
             					ComSetFocus(to_mvmt_yd_cd);
                    			return false;
             				}
             				if(ComGetObjValue(comboObjects[1]) == '') {
             					ComShowCodeMessage('DMT02002', 'To MVMT Status');
                    			return false;
             				}
             			}
             		} else if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'D') {
             			if(ComIsNull(to_mvmt_dt)) {
         					ComShowCodeMessage('DMT02002', 'To MVMT Date');
         					ComSetFocus(to_mvmt_dt);
                			return false;
         				}
         				if(ComIsNull(to_mvmt_yd_cd)) {
         					ComShowCodeMessage('DMT02002', 'To MVMT Yard');
         					ComSetFocus(to_mvmt_yd_cd);
                			return false;
         				}
         				if(ComGetObjValue(comboObjects[1]) == '') {
         					ComShowCodeMessage('DMT02002', 'To MVMT Status');
                			return false;
         				}
             		}
             		if(!ComIsNull(fm_mvmt_dt) && !ComIsNull(to_mvmt_dt)) {
	             		//var fmMvmtDt = ComGetUnMaskedValue(fm_mvmt_dt, "ymd");
	             		//var toMvmtDt = ComGetUnMaskedValue(to_mvmt_dt, "ymd");
	             		var fmMvmtDt=ComGetObjValue(fm_mvmt_dt);
	             		var toMvmtDt=ComGetObjValue(to_mvmt_dt);
	             		/*
	          	    	 ComChkPeriod(fromDate, toDate)
	          	    	 0 : fromDate > toDate
	          	    	 1 : fromDate < toDate
	          	    	 2 : fromDate=toDate
	          	    	 */
						if(ComChkPeriod(fmMvmtDt, toMvmtDt) == 0) {
							ComShowCodeMessage('DMT01020');
	            			return false;
	            		}
						var toMvmtStsCd=comboObjects[1].GetSelectCode();
						if(toMvmtStsCd == 'DR') {
							//The current date by User Office Retrieving(2010.04.06 수정)
							var currDt=DmtComOfficeCurrDate(sheetObj, formObj);
							if(ComChkPeriod(toMvmtDt, currDt) == 1) {
		            			ComShowCodeMessage('DMT01031', 'D/R Date', 'current date');
		            			return false;
		            		}
						}
             		}
             		// setting To MVMT Status Code
					ComSetObjValue(to_mvmt_sts_cd, comboObjects[1].GetSelectCode());
             		break;
			} // switch - end	
    	} // with - end
        return true;
    }