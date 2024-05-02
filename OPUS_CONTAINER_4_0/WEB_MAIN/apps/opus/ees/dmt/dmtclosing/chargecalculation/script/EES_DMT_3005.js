/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3005.js
*@FileTitle  : Charge Inquiry by Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
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
	var USR_TRF_TP;
	//Action for separation variables defined button functions
	var IBPRECAL=99;
	var IBCONFIRM=97;
	var IBDELCANCEL=96;
	var IBDRSAVE=94;
	var IBCHKBKGNO=93;
	// Check at BKG No, event conflict due to the global variable to avoid duplicate processing
 	var G_BKGNO_CHK_FLG=false;
 	var timer;
	// 'Retrieve button' run at the click of a mouse for a global variable logic
	var G_CHANGE_SKIP=false;
	// BKG_NO Validation 
	var G_BKGNO_CHK_OK=false;
	// onchange event occurs, the object of BKG_NO, BL_NO
	var G_CHANGE_OBJ=null;
	
	var DEF_SHEET_HEIGHT = 292;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 225;

	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
          /***** case in Sheet count are more two by Tab, defining adding sheet *****/
          var sheetObj1=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		  if(ComGetBtnDisable(srcName)) return false;
     		// Click the button at the bottom of the grid is disabled, return
     		if(!ComIsBtnEnable(srcName)) return;
             switch(srcName) {
             	case "btn_PreCal":
             		doActionIBSheet(sheetObj1,formObj,IBPRECAL);
					break;
             	case "btn_DRSave":
             		doActionIBSheet(sheetObj1,formObj,IBDRSAVE);
					break;
				case "btn_Balance":
					alert(srcName);
					break;
             	case "btn_Retrieve":
             		// formObj onchange event of the cause was forced to bkg_no
             		if( ComGetObjValue(formObj.bkg_no) != '' || ComGetObjValue(formObj.bl_no) != '') {
             			var chgObj=G_CHANGE_OBJ;
             			if(chgObj == null) chgObj=formObj.bkg_no;
             			G_CHANGE_SKIP=false;
             			doCheckBKGNo(chgObj);
             			//fireClickEvent( chgObj, "change");
             		/*	$(chgObj).change();
             			$(chgObj).change(function(){
             				obj_change();
             			});*/
             			
             			//chgObj.fireEvent("onchange");
             			if(!G_BKGNO_CHK_OK) return;
             		}
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;
				case "btn_New":
					doInit();
					break;
				case "btn_Minimize":
					var miniDiv=document.getElementById("mini_div");
 					if(miniDiv.style.display == 'block') {
 						miniDiv.style.display='none';
 						sheetObj1.SetSheetHeight(MAX_SHEET_HEIGHT);
 					} else {
 						miniDiv.style.display='block';
 						sheetObj1.SetSheetHeight(DEF_SHEET_HEIGHT);
 					}
					break;
 				case "btn_Confirm":
 					doActionIBSheet(sheetObj1,formObj,IBCONFIRM);
 					break;
 				case "btn_DELCancel":
 					doActionIBSheet(sheetObj1,formObj,IBDELCANCEL);
 					break;
 				case "btn_DownExcel":
  					sheetObj1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj1), SheetDesign:1,Merge:1 });
 					break;
 				case "btn_Close":
 					//window.returnValue = "Y";
 					ComClosePopup(); 
					break;
 				case "btns_calendar": //Calendar button
					var cal=new ComCalendar();
					cal.select(formObj.dr_dt, 'yyyy-MM-dd');
					break;
 				//----------- pop up --------------------	
 				case "btn_Demand":
 				case "btn_Billing":
 				case "btn_OFCTrans":
 				case "btn_Delete":
 				case "btn_ByETA":
 				case "btn_ByCNTR":
 				//case "btn_ROInfo":
 				case "btn_MVMTInq":
 				case "btn_ExceptionInq":
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
     
     function initControl() {
//    		axon_event.addListenerFormat('keypress',	'obj_keypress', document.form); // on press keyboard
     		axon_event.addListener('focus',		'obj_focus',		'bkg_no', 'bl_no');
//     		axon_event.addListener('keydown',	'obj_keydown',		'form');
//     		axon_event.addListener('click',		'byPODDTA_click',	'bypodeta');
     		axon_event.addListener('mouseover', 'obj_mouseover',	'tdROffice', 'tdDRDate');	// Display balloon messages
    		axon_event.addListener('mouseout',	'obj_mouseout',		'tdROffice', 'tdDRDate');	// Hide balloon message
     		axon_event.addListener('blur',		'obj_blur',			'dr_dt');
     		axon_event.addListener('change',	'obj_change',		'bkg_no', 'bl_no');
     		axon_event.addListener('mousedown', 'obj_mousedown',	'btn_Retrieve');
      }
     function obj_mouseover() {
  		var msg='';
  		var x=event.x+document.body.scrollLeft;
  		var y=event.y+document.body.scrollTop;
      	switch(event.srcElement.id){
       		case 'tdROffice':
       			msg="Cargo Release Office";
       			x=x;
       			y=y-20;
       			break;
       		case 'tdDRDate':
       			msg="Delivery & Return Date";
       			x=x;
       			y=y+20;
       			break;
      	}
  		var bak='lightyellow';
  		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
  						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
  		var skn=document.all("topdeck").style;
  		skn.left=x;
  		skn.top=y;
  		document.all("topdeck").innerHTML=content;
  		skn.visibility='visible';
 	}
 	// 'by ETA' onMouseout event  (button Hide balloon message)
 	function obj_mouseout() {
 		var skn=document.all("topdeck").style;
 		skn.visibility='hidden';
 	}
  	function obj_keydown() {
  		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
  		if (keyValue != 13) return;
  		var obj=event.srcElement;
  		var formObj=document.form;
  		if(!doCheckBKGNo(obj)) return;
  		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
  	}
 	// 'Retrieve button' run at the click of a mouse logic - a priority
 	function obj_mousedown() {
 		G_CHANGE_SKIP=true;
 	}
 	// BKG No, BL No event of the check Validation function for processing
 	function obj_change() {
 		var obj=ComGetEvent();
 		// BKG_NO, BL_NO onchange event occurs in the text box object stored in global variables
 		G_CHANGE_OBJ=obj;
 		// Global variables (G_CHANGE_SKIP) is false when running only on
         if (!G_CHANGE_SKIP) {
 	 		if(G_BKGNO_CHK_FLG) return;
 	 		doCheckBKGNo(obj);
         }
 		// BKG_NO, BL_NO Validation Logic to run again, a global variable (G_CHANGE_SKIP) setting to false
 		G_CHANGE_SKIP=false;
 	}
	function doCheckBKGNo(obj) {
		var formObj=document.form;
		if(obj.name == 'bkg_no') {
			var bkgNo=ComGetObjValue(obj);
			if (bkgNo.length >= 11 && bkgNo.length <= 13) {
				G_BKGNO_CHK_FLG=true;
				doActionIBSheet(sheetObjects[0], formObj, IBCHKBKGNO, obj);
				G_BKGNO_CHK_FLG=false;
				if(!G_BKGNO_CHK_OK) return false;
			} else if(bkgNo != '') {
				ComShowCodeMessage('DMT00110', 'BKG No.');
				ComClearObject(formObj.bl_no);
				ComSetFocus(formObj.bkg_no);
				G_BKGNO_CHK_OK=false;
				return false;
			}
		} else if(obj.name == 'bl_no') { 
			 var blNo=ComGetObjValue(obj);
			 if (blNo.length == 12 || blNo.length == 10) {
				 G_BKGNO_CHK_FLG=true;
				 doActionIBSheet(sheetObjects[0], formObj, IBCHKBKGNO, obj);
				 G_BKGNO_CHK_FLG=false;
				 if(!G_BKGNO_CHK_OK) return false;
			 } else if(blNo != '') {
				 ComShowCodeMessage('DMT00110', 'BL No.');
				 ComClearObject(formObj.bkg_no);
				 ComSetFocus(formObj.bl_no);
				 G_BKGNO_CHK_OK=false;
				 return false;
			 }
		}
		return true;
	}
	
	// out of focus
 	function obj_blur() {
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
    	 switch(ComGetEvent().dataformat){
         	case "engup":
		    	// upper case + numbers 
         		ComKeyOnlyAlphabet('uppernum');
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

	
	// button status initializing
	function initBtns() {
		DmtComEnableManyBtns(false, "btn_PreCal", "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
		document.getElementById("btn_PreCal").style.color='';
	//	document.getElementById("btn_ROInfo").style.color = '';
	}
	/**
  	  * INIT SETTING
  	  */
  	function doInit() {
  		G_BKGNOCHK_OK=false;
  		sheetObjects[0].CheckAll("chk",0);
  		sheetObjects[0].RemoveAll();
  		ComResetAll();
  		status_combo.SetItemCheck(0, false);
  		status_combo.SetItemCheck(0, true);
  		initBtns();
  	}
  	// IBMultiCombo Office initializing
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
   	// IBMultiCombo Office initializing
   	function initComboValue_status_combo() {
		//comboObjects[1].Enable = true;
		comboObjects[1].SetItemCheck(0,1);
		status_combo_OnCheckClick(comboObjects[1], 0, 'A');
   	}
	// RHQ IBMultiCombo initializing
   	function initComboValue_rhq_ofc() {
   		var formObj=document.form;
   		// RHQ of the Default User Login
		var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
		var headOffice=ComGetObjValue(formObj.head_office);
   		if(usrRhqOfcCd == headOffice)
   			usrRhqOfcCd="All";
   		ComSetObjValue(comboObjects[2], usrRhqOfcCd);
   		//comboObjects[2].SetColWidth(150);
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
		              var HeadTitle1="||Seq.|STS|CNTR No.|T/S|Office|From YD|To YD|Fm|To|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT"
		              + "|Billable AMT|G/B|S.O.C|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|Invoice No.|ISS DT|INV Cur.|Billing AMT|A/R"
		              + "|svr_id|dmdt_trf_cd|chg_seq|cntr_cyc_no|dmdt_chg_loc_div_cd|ofc_rhq_cd|bkg_no|bl_no|dul_tp_expt_flg|cxl_bkg_chg_flg";

		              SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                  {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		                  {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"General/Balance Charge Type"},
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"li",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Local/Intransit DEM Type"},
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Carrier's Haulage"},
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d_o",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Cargo Release"},
		                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ofc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Cargo Release Office"},
		                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"clt_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ofc_trns_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Office Transferred"},
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"roll_ovr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Roll Over due to Carrier Schedule Change"},
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"iss_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_inv_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_ar_if_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dul_tp_expt_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cxl_bkg_chg_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(1);
		              SetCountPosition(0);
		              SetEllipsis(1);
                      SetSheetHeight(DEF_SHEET_HEIGHT);
              //no support[check again]CLT ToolTipOption="balloon:true;width:50;";
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
	    	case "tariff_type":
	    		with (comboObj) { 
					SetMultiSelect(0);
					SetUseAutoComplete(1);
  					SetColBackColor(0,"#CCFFFD");
   					SetColBackColor(1,"#CCFFFD");
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "45");
					SetColWidth(1, "300");
					SetDropHeight(160);
		    	}
				break;
	    	case "status_combo":
   	    		with (comboObj) { 
    				SetMultiSelect(1);
  					SetColBackColor(0,"#CCFFFD");
   					SetColBackColor(1,"#CCFFFD");    				
					SetColAlign(0, "left");
					//SetColWidth(0, "100");
					addComboItem(comboObj, comboNo);
					SetSelectCode("C");
					SetDropHeight(170);
   		    	}
   	    		break;
	    	case "rhq_ofc":
   	    		with (comboObj) { 
    				SetMultiSelect(0);
  					SetColBackColor(0,"#CCFFFD");
   					SetColBackColor(1,"#CCFFFD");    				
					SetColAlign(0, "left");
					SetDropHeight(170);
   		    	}
   	    		break;
	    }
	}
   // Process of Sheet
     function doActionIBSheet(sheetObj, formObj, sAction, srcObj) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:		// Search
            	if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
            	sheetObj.DoSearch("EES_DMT_3005GS.do", FormQueryString(formObj));
            break;
            
         	case IBCHKBKGNO:
         		if(srcObj.name == 'bkg_no')
         			ComClearObject(formObj.bl_no);
         		else
         			ComClearObject(formObj.bkg_no);
				formObj.f_cmd.value=COMMAND02;
 				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
				var bkgNo=ComGetEtcData(sXml, "BKG_NO");
				var blNo=ComGetEtcData(sXml, "BL_NO");
				if (bkgNo != undefined && bkgNo != '') {
					ComSetObjValue(formObj.bkg_no, bkgNo);
					ComSetObjValue(formObj.bl_no, blNo);
					G_BKGNO_CHK_OK=true;
				} else {
					var objName=srcObj.caption;
					ComShowCodeMessage('DMT00110', objName);
					ComSetFocus(srcObj);
					G_BKGNO_CHK_OK=false;
				}
			break;
			
 			case IBPRECAL:
	         	if(!validateForm(sheetObj,formObj,sAction)) return;
	         	//formObj.f_cmd.value = MULTI02;
	         	//sheetObj.DoSave("EES_DMT_3005GS.do", FormQueryString(formObj),"chk");
	         	sheetObj.SetWaitImageVisible(0);
	         	ComOpenWait(true);
	         	formObj.f_cmd.value=COMMAND01;
	         	ComSetObjValue(formObj.backendjob_id, "PRECAL");
	         	var params=sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
 	         	var sXml=sheetObj.GetSaveData("EES_DMT_3005GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // After three seconds, running getBackEndJobStatus function - a recursive call
				}
	        break;
         }
     }
	 /**
	 * Status of BackEndJob a '3 'to make sure when.
	 */
	 function getBackEndJobStatus() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	//It gets a status of backendjob. 2
	 	ComSetObjValue(formObj.f_cmd, COMMAND02);
	 	var params="f_cmd=" + COMMAND02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key); // FormQueryString(formObj)
 	 	var sXml=sheetObj.GetSearchData("EES_DMT_3005GS.do", params);
	 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	 	// jobState == "2" BackEndJob Progress......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob success.
	 		getBackEndJobLoadFile();
	 	}
	 	else if (jobState == "4") {
	 		clearInterval(timer);
	 		// Failure BackEndJob.
	 		var jbUsrErrMsg=ComGetEtcData(sXml, "jb_usr_err_msg");
	 		if (jbUsrErrMsg != undefined && jbUsrErrMsg != '')
	 			ComShowMessage(jbUsrErrMsg);
	 		else
	 			ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 	else if (jobState == "5") {
	 		clearInterval(timer);
	 		// BackEndJob already have read the resulting file.
	 		ComShowCodeMessage("DMT01125");
	 		ComOpenWait(false);
	 	}
	 }
	//At the end of BackEndJob success is a reflection of the resulting data.
	function getBackEndJobLoadFile() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	//It returns a result. 3
	 	ComSetObjValue(formObj.f_cmd, MULTI02);
	 	var params="f_cmd=" + MULTI02 + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key); // FormQueryString(formObj)
 	 	var sXml=sheetObj.GetSaveData("EES_DMT_3005GS.do", params);
 	 	sheetObj.LoadSaveData(sXml, {Sync:1});
	 	ComOpenWait(false);
	}
     function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
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
 				if(data2 == '') {
 					data2='DMIF';
 				} else {
 					//Tariff Type Set-Up Tariff Type has multiple values??, the first set
 					data2=data2.split(',')[0];
 				}
 				// Tariff Type IBMultiCombo initializing
 				comboObj.SetSelectCode(data2);
 				// Set Global variables (USR_TRF_TP), IBMultiCombo Tariff Type initializing function (initComboValue_tariff_type ()) for use in
 				USR_TRF_TP=data2;
 				formObj.usr_trf_tp.value=data2;
 				break;
 	        case "rhq_ofc":	// RHQ
		 		var data=ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems=data.split("|");
					comboObj.InsertItem(0, "All", "All");
					for (var i=0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
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
  			case "status_combo":
				comboObj.InsertItem(0, "All", "A");
  				comboObj.InsertItem(1, "Finished",	"F");
  				comboObj.InsertItem(2, "Confirmed",	"C");
  				comboObj.InsertItem(3, "Invoiced",	"I");
  				comboObj.InsertItem(4, "Long Staying", "L");
  				comboObj.InsertItem(5, "Error", 	"E");
  				comboObj.InsertItem(6, "No Charge", "N");
  				comboObj.InsertItem(7, "Unfinished","U");
  				comboObj.InsertItem(8, "Deleted",	"D");
				break;
  		}
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
                    // AllCheck box Status synchronization
                    SetHeaderCheck(0, "chk",(CheckedRows("chk") == RowCount()));
                }
            } else {
            	// case in click Check box ,  All Check box Status synchronization
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
 	function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		var sheetObj=sheetObjects[0];
  		//sheetObj.WaitImageVisible = false;
  		// Search Tariff Type MultiCombo List
  		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
  		// RHQ information
		doActionIBCombo(sheetObj, formObj, comboObjects[2], COMMAND06);
  		//sheetObj.WaitImageVisible = true;
		var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
  		doInit();
		/*********************************************
         * Pop-up window for call handling (Retrieve running)
         **********************************************/
		if(ComGetObjValue(formObj.call_flag) == "P") {
			// Search conditions deactivating 
			ComEnableManyObjects(false, formObj.bkg_no, formObj.bl_no);
			// Retrieve 
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
  	}
  	/**
  	 * IBSheet lookup function Retrieving is complete, caused by an Event
  	 */
  	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
  		ComOpenWait(false);
  		
  		if(ErrMsg != '') return;
		var formObj=document.form;
		var fCmd=formObj.f_cmd.value;
		sheetObj.CheckAll("chk", 0);
		
		if (fCmd == SEARCH || fCmd == SEARCH01) {
  			var bkgNo=ComGetObjValue(formObj.bkg_no);
        	var blNo=ComGetObjValue(formObj.bl_no);
        	// Etc Data Sheet that exists to fill the Form object's value.
        	ComEtcDataToForm(formObj, sheetObj);
  			// Without a resulting data, Search conditions enter the data retention
        	if(sheetObj.SearchRows()== 0) {
        		ComSetObjValue(formObj.bkg_no, bkgNo);
        		ComSetObjValue(formObj.bl_no, blNo);
        		ComClearManyObjects(formObj.tot_bil_amt, formObj.cntr_qty);
        		initBtns();
        	} 
        	else {
        		var cellBackColor="#76DEE1";
    			for (var i=sheetObj.GetTopRow(); i <= sheetObj.SearchRows(); i++) {
    				if (sheetObj.GetCellValue(i, "dmdt_ar_if_cd") == 'Y') {
    					sheetObj.SetRowBackColor(i,cellBackColor);
    				}
    			}
        		// Activating of button
        		DmtComEnableManyBtns(true,	"btn_PreCal", "btn_ByCNTR", "btn_MVMTInq", "btn_DownExcel");
				var strCol = "|" + sheetObj.SaveNameCol("bil_amt"); + "|";
            	var bilAmt = sheetObj.ComputeSum(strCol);
            	ComSetObjValue(formObj.tot_bil_amt, ComAddComma2(bilAmt+'', "#,###.00"));
        	}
        	ComClearObject(formObj.dr_dt);
  			// 'Pre Cal.' button색 initializing
	  		document.getElementById("btn_PreCal").style.color="";
		}
  	}
  	/**
     * After saving handling
     */
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg) {
    	
		if (ErrMsg != '') {	// Error when saving
		 //ComShowCodeMessage('COM12151', "Tariff Type");
		} 
		else {
			var formObj=document.form;
			var fCmd=formObj.f_cmd.value;
			if (fCmd == MULTI02) {	// PreCal
				var strCol = "|" + sheetObj.SaveNameCol("bil_amt"); + "|";
				
				// Total Billable AMT Setting Field Values
				var bilAmt = sheetObj.ComputeSum(strCol);
	        	
	  			ComSetObjValue(formObj.tot_bil_amt, ComAddComma2(bilAmt+'', "#,###.00"));
				ComBtnDisable("btn_PreCal");
				// 'Pre Cal.' button changes color to red
	  			document.getElementById("btn_PreCal").style.color="red";
			}
		}
    }
    /**
	 * Row selected and the information passed to EES_DMT_3003.do is called a pop-up.
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		doProcessPopup('btn_ByCNTR');
	}
  	/**
  	 * Status CheckClick event handling multi-combo
  	 * @param comboObj
  	 * @param index
  	 * @param code
  	 * @return
  	 */
	var checked = false;
//  	function status_combo_OnCheckClick(comboObj, index, code) {
//  		checked = true;
//		var formObj=document.form;
//		//var codes = comboObj.Code;
//		with (formObj) {
//			if(index == 0) {
//				if(comboObj.GetItemCheck(0))	// All check
//					comboObj.SetSelectCode("A,F,C,I,L,E,N,U,D");
//				else // All uncheck
//				{
//					comboObj.SetSelectIndex(-1);
////					comboObj.SetSelectCode('');
////					comboObj.SetSelectText('');
////					formObj.comboObj_text.value = "";
//				}
//			} else if(comboObj.GetItemCheck(0)) {
//				comboObj.SetItemCheck(0,0);
//			}
//		}
//	}
	function status_combo_OnCheckClick(comboObj, index, code) {
		var formObj=document.form;
		//var codes = comboObj.Code;
//		with (formObj) {
//			if(index == 0) {
//				if(comboObj.GetItemCheck(0))	// All check
//					comboObj.SetSelectCode("A,F,C,I,L,E,N,U,D");
//				else // All uncheck
//					comboObj.SetSelectText("");
//			} else if(comboObj.GetItemCheck(0)) {
//				comboObj.SetItemCheck(0,0);
//			}
//		}
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
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'btn_ByCNTR':
	  				var chkRow=GetSelectRow();
	  				var svrId=GetCellValue(chkRow , "svr_id");
					var cntrNo=GetCellValue(chkRow , "cntr_no");
					var cntrCycNo=GetCellValue(chkRow , "cntr_cyc_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgLocDivCd=GetCellValue(chkRow , "dmdt_chg_loc_div_cd");
					var chgSeq=GetCellValue(chkRow , "chg_seq");
		  			var paramVal="?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
	  				sUrl='EES_DMT_3006P.do' + paramVal;
	          		sWidth='1150';
	          		sHeight='700';
	          		ComOpenWindowCenter(sUrl, null, sWidth, sHeight, true);
	          		return;
	  				break;
//	  			case 'btn_ROInfo':
//	  				var bkgNo = ComGetObjValue(document.form.bkg_no);
//	  				if(ComIsEmpty(bkgNo)) {
//	  					ComShowCodeMessage('DMT03028', 'BKG No.');
//	  					return;
//	  				}
//	  				
//	  				var paramVal = "?bkg_no=" + bkgNo;
//	  				sUrl	= 'ESM_BKG_0724.do' + paramVal;
//              		sWidth	= '1000';
//              		sHeight	= '450';
//	  				break;
	  			case 'btn_MVMTInq':
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
					sWidth='1020';
					sHeight='690';
					sIframe=false;
	  				break;
	  				
	  		} // switch-end
  		} // with-end
  		if(sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, sIframe, sScroll);  			
  		}
  	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
          		case IBSEARCH:     // Search
          			var bkgNo=ComGetObjValue(bkg_no);
          			var blNo=ComGetObjValue(bl_no);
          			if(bkgNo == '' && blNo == '') {
          				ComShowCodeMessage('DMT00102', "BKG No. or B/L No.");
             			return false;
          			}
          			// Tariff Type Combo Check
             		if(comboObjects[0].GetSelectCode()== '') {
             			ComShowCodeMessage('COM12113', "Tariff Type");
             			return false;
             		}
             		// Status Combo Check
             		if(comboObjects[1].GetSelectCode()== '') {
             			ComShowCodeMessage('COM12113', "Status");
             			return false;
             		}
          			ComSetObjValue(dmdt_trf_cd,		comboObjects[0].GetSelectCode());
          			ComSetObjValue(dmdt_chg_sts_cd,	comboObjects[1].GetSelectCode());
          			ComSetObjValue(rhq_ofc_cd,		comboObjects[2].GetSelectCode());
          			ComBtnEnable("btn_PreCal");
          			break;
          		case IBCONFIRM:      //Confirm
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR for Confirm');
             			return false;
             		}
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'F') {
         					ComShowCodeMessage('DMT03018');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
             		}
             		break;
             	case IBDELCANCEL:
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('DMT01042');
             			return false;
             		}
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chg_sts != 'D') {
         					ComShowCodeMessage('DMT01042');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
             		}
             		break;
             	case IBPRECAL:	
             		var drDt=ComGetObjValue(dr_dt);
             		if(drDt == '') {
             			ComShowCodeMessage('DMT02002', 'D/R Date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		drDt=ComGetUnMaskedValue(dr_dt, "ymd");
             		//The current date by User Office Retrieving(2010.04.06 수정)
					var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
             		if(ComChkPeriod(drDt, ofcCurrDate) == 1) { //1 : fromDate < toDate
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
             			/*
	           	    	 ComChkPeriod(fromDate, toDate)
	           	    	 0 : fromDate > toDate
	           	    	 1 : fromDate < toDate
	           	    	 2 : fromDate=toDate
	           	    	 */
     					if(ComChkPeriod(drDt, fmMvmtDt) == 1) {
                 			ComShowCodeMessage('DMT01031', 'D/R Date', 'From date');
                 			sheetObj.SetSelectRow(chkRows[i]);
                 			return false;
                 		}
     					var chgStsCd=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
     					var toMvmtSts=sheetObj.GetCellValue(chkRows[i], "to_mvmt_sts_cd");
         				if((chgStsCd == 'F' && toMvmtSts == 'DR') || chgStsCd == 'U' || chgStsCd == 'L') {
         				} else {
         					ComShowCodeMessage('DMT01060');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
             		}
             		// Status values ??stored in the variable Search conditions
             		ComSetObjValue(sch_chg_sts, comboObjects[1].GetSelectCode());
             		break;
        	 }
         }
         return true;
     }

     function status_combo_OnChange(comboObj , oldIndex, oldText , oldCode , newIndex, newText , newCode){
    	 ComSetMultiCombo(comboObj, sSelectIndex, sSelectCode);
     }
     
     function status_combo_OnBlur(comboObj) {
    	 ComSetMultiCombo(comboObj, sSelectIndex, sSelectCode);
     }
     
     var sSelectIndex = 0, sSelectCode = 0;
     function status_combo_OnSelect(comboObj, index, text, code) {
    	 sSelectIndex = index;
    	 sSelectCode = code;
     }