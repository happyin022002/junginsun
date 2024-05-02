/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_DMT_3002.js
 *@FileTitle  : Charge Calculation by Booking
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------ The following code added code to make a good  JSDoc  ------------------*/
   /**	
     * @fileoverview 		Calendar function is defined with javascript file used commonly in business 
     * @author Hanjin Shipping
     */
    /**
   	/* Developer operation	*/
    // common entire variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	// Tariff Type Set-Up Info by User
	var USR_TRF_TP;
	// variables definition for sort of button function
	var IBPRECAL=99;
	var IBCONFIRM=97;
	var IBDELCANCEL=96;
	var IBBALANCECRE=95;
	var IBDRSAVE=94;
	var IBCHKBKGNO=93;
	// FLAG Entire variables for preventing duplicated process of event conflict in case of  BKG No check 
	var G_BKGNO_CHK_FLG=false;
	var timer;
	// Entire variables for running logic in case of 'Retrieve' button click
	var G_CHANGE_SKIP=false;
	// BKG_NO Validation result
	var G_BKGNO_CHK_OK=false;
	// BKG_NO, BL_NO  onchange event occurring object
	var G_CHANGE_OBJ=null;
	var DEF_SHEET_HEIGHT = 200;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 241;
	
	var chg_clac_flg = "N";
	var batch_bkg_no 	= "";
	var batch_cntr_no 	= "";
	
	// Event handler processing by button click event  */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
          /***** assigning added sheet variables in case of two more tabs *****/
          var sheetObj1=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(!ComIsBtnEnable(srcName)) return;
             switch(srcName) {
             	case "btn_PreCal":
             		doActionIBSheet(sheetObj1,formObj,IBPRECAL);
					break;
             	case "btn_DRSave":
             		doActionIBSheet(sheetObj1,formObj,IBDRSAVE);
					break;
				case "btn_Balance":
					doActionIBSheet(sheetObj1,formObj,IBBALANCECRE);
					break;
             	case "btn_Retrieve":
             		if( ComGetObjValue(formObj.bkg_no) != '' || ComGetObjValue(formObj.bl_no) != '') {
             			var chgObj=G_CHANGE_OBJ;
             			if(chgObj == null) chgObj=formObj.bkg_no;
             			G_CHANGE_SKIP=false;
//             			chgObj.fireEvent("onchange");
             			doCheckBKGNo(formObj.bkg_no);
             			if(!G_BKGNO_CHK_OK) return;
             		}
					doActionIBSheet(sheetObj1,formObj,IBSEARCH);
					break;
				case "btn_New":
					doInit();
					break;
				case "btn_Minimize":
					var miniDiv=document.getElementById("mini_div");
 					if (miniDiv.style.display == 'block') {
 						miniDiv.style.display ='none';
 						sheetObj1.SetSheetHeight(MAX_SHEET_HEIGHT);
 					} 
 					else {
 						miniDiv.style.display ='block';
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
 					if(sheetObj1.RowCount() < 1){//no data
 						ComShowCodeMessage("COM132501");
 					}else{
 						sheetObj1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj1), SheetDesign:1,Merge:1 });
 					} 					
 					break;
 				case "btn_Close":
 					window.returnValue="Y";
 					ComClosePopup(); 
					break;
 				case "btns_calendar": // calendar button
					var cal=new ComCalendar();
					cal.select(formObj.dr_dt, 'yyyy-MM-dd');
					break;
 				//----------- process of popup --------------------	
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
 				case "btn_Recalc":
 					 doActionIBSheet(sheetObj1,formObj,IBSAVE);
 					break;
 				case "btn_Batch":
					 doActionIBSheet(sheetObj1,formObj,IBBATCH);
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
     //registering IBCombo Object as comboObjects array
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
    	 // showing title in case of calling popup
    	 if(ComGetObjValue(document.form.call_flag) == "P") {
//        	 var spanObj=document.getElementById("title");
//        	 spanObj.innerText=" Charge Calculation by Booking";
        	 ComSetDisplay('btn_Close', true);
    	 }
         // IBMultiCombo initiation
         for(var k=0;k<comboObjects.length;k++){
        	 initCombo(comboObjects[k],k+1);
         }
         // html control event initializing
         initControl();
         
         sheet1_OnLoadFinish();
     }
     function initControl() {
		//axon_event.addListenerFormat('keypress',	'obj_keypress', document.form); // in case of input with keyboard
		axon_event.addListener('focus',		'obj_focus',		'bkg_no', 'bl_no');
		axon_event.addListener('keydown',	'obj_keydown',		'form');
		axon_event.addListener('click',		'byPODDTA_click',	'bypodeta');
		axon_event.addListener('mouseover', 'obj_mouseover',	'btn_ByETA', 'tdROffice', 'tdDRDate');	// show speech bubble
		axon_event.addListener('mouseout',	'obj_mouseout',		'btn_ByETA', 'tdROffice', 'tdDRDate');	// hide  speech bubble
		axon_event.addListener('blur',		'obj_blur',			'dr_dt');
		axon_event.addListener('change',	'obj_change',		'bkg_no', 'bl_no');
		axon_event.addListener('mousedown', 'obj_mousedown',	'btn_Retrieve');
     }
	// 'by ETA' onMouseover event  (show button speech bubble)
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
      		case 'btn_ByETA':
      			msg='Manual Batch by POD ETA';
      			x=x-150;
      			y=y+20;
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
	// 'by ETA' onMouseout event  ( hide button speech bubble)
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
	// first logic in case of 'Retrieve button' click
	function obj_mousedown() {
		G_CHANGE_SKIP=true;
	}
	// function for validation of BKG No, BL No 
	function obj_change() {
		var obj=event.srcElement;
		// saving object among BKG_NO, BL_NO occurring onchange event 
		G_CHANGE_OBJ=obj;
		// running in case of that entire variables(G_CHANGE_SKIP) is false
        if (!G_CHANGE_SKIP) {
	 		if(G_BKGNO_CHK_FLG) return;
	 		doCheckBKGNo(obj);
        }
		// setting entire variables (G_CHANGE_SKIP) false for BKG_NO, BL_NO Validation logic running again
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

		ComClearObject(formObj.batch_cntr);
		
		return true;
	}
	// focus out
 	function obj_blur() {
 		// checking input validation and input mask delimiter
 		var obj=event.srcElement;
		ComChkObjValid(obj);
 	}
 	/**
	* HTML Control Foucs in
	*/
 	function obj_focus(){
		var obj=event.srcElement;
		ComClearSeparator(obj);
		// select as block in case of that there is words
		if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
	}
	// OnKeyPress event handling
	function obj_keypress() {
		switch(ComGetEvent("dataformat")){
			case "engup":
				// upper case + number 
				ComKeyOnlyAlphabet('uppernum');
			break;
			
			case "int":
			    //only number
			    ComKeyOnlyNumber(ComGetEvent());
			break;
			
			default:
		     	// only number(integer, date, time)
		        ComKeyOnlyNumber(ComGetEvent());
		 }
    }
	// [by POD ETA] Checkbox click event handling
    function byPODDTA_click() {
		var obj=ComGetEvent();
		doEnableByPODETA(obj);
    }
    // [by POD ETA] Checkbox click event handling 
	function doEnableByPODETA(obj) {
		var formObj=document.form;
		// in case of check of by POD ETA
		if(obj.checked) {
			 comboObjects[0].SetSelectCode('DMIF');// Tariff Type combo: DMIF, inactivity
			 comboObjects[0].SetEnable(0);
			 comboObjects[1].SetSelectCode('');// Status combo: space, inactivity
			 comboObjects[1].SetEnable(0);
		} else {
			 initComboValue_tariff_type();
			 initComboValue_status();
		}
    }
	 /**
  	  * INIT SETTING
  	  */
  	function doInit() {
  		var formObj=document.form;
  		G_BKGNOCHK_OK=false;
  		ComResetAll();
  		sheetObjects[0].CheckAll("chk",0);
		doEnableByPODETA(formObj.bypodeta);
		if(formObj.bypodeta.disabled) {
			ComEnableManyObjects(true, formObj.bkg_no, formObj.bl_no, formObj.bypodeta);
			DmtComSetClassManyObjects('input1', formObj.bkg_no, formObj.bl_no);
		}
		initBtns();
  	}
	// button status initializing
	function initBtns() {
//		DmtComEnableManyBtns(false, "btn_PreCal", "btn_DRSave", "btn_Balance",
//									"btn_Confirm", "btn_Demand", "btn_Billing", "btn_OFCTrans","btn_Delete", "btn_DELCancel",
//									"btn_ByETA", "btn_ByCNTR", "btn_ROInfo", "btn_MVMTInq", "btn_ExceptionInq", "btn_DownExcel","btn_Recalc");
		DmtComEnableManyBtns(false, "btn_PreCal", "btn_DRSave", "btn_Balance",
				"btn_Confirm", "btn_Demand", "btn_Billing", "btn_OFCTrans","btn_Delete", "btn_DELCancel",
				"btn_ByETA", "btn_ByCNTR", "btn_MVMTInq", "btn_ExceptionInq", "btn_DownExcel","btn_Recalc");
		document.getElementById("btn_PreCal").style.color='';
		//document.getElementById("btn_ROInfo").style.color = '';
	}
  	// Tariff Type IBMultiCombo initializing
   	function initComboValue_tariff_type() {
   		var formObj=document.form;
   		if(ComGetObjValue(formObj.call_flag)=='M') {
   			// calling with 'M'emu
   			comboObjects[0].SetEnable(1);
   			comboObjects[0].SetSelectCode(USR_TRF_TP);
   			ComSetObjValue(formObj.usr_trf_tp, USR_TRF_TP);
   		} else {
   			// calling with 'P'opup
   			comboObjects[0].SetEnable(0);
   			comboObjects[0].SetSelectCode(ComGetObjValue(formObj.dmdt_trf_cd));
   		}
   	}
   	// Status IBMultiCombo initializing
   	function initComboValue_status() {
		comboObjects[1].SetEnable(1);
		comboObjects[1].SetItemCheck(0,1);
		combo_status_OnCheckClick(comboObjects[1], 0, 'A');
   	}
   	
	// RHQ IBMultiCombo initializing
   	function initComboValue_rhq_ofc() {
   		var formObj=document.form;
   		// RHQ of login User Default value (SELHO is All)
		var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
		var headOffice=ComGetObjValue(formObj.head_office);
//   		if(usrRhqOfcCd == 'SELHO')
//   			usrRhqOfcCd = "All";
   		if(usrRhqOfcCd == headOffice)
   			usrRhqOfcCd="All";
   		ComSetObjValue(comboObjects[2], usrRhqOfcCd);
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
					var HeadTitle1="||Seq.|STS|CNTR No.|T/S|Office|From YD|To YD|Fm|To|F/T|Over|From DT|To DT|F/T CMNC|F/T End|Cur.|Incurred AMT|Exception AMT|D/C AMT"+ "|Billable AMT|G/B|S.O.C|L/I|C/H|D/O|R/OFC|CCT OFC|O/T|R/O|Invoice No.|ISS DT|INV Cur.|Billing AMT|A/R|WEB|Web M'ty|Grace End|PIC Name";
					SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					  {Type:"CheckBox",  Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
					  {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_yd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ft_dys",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"fx_ft_ovr_dys",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_mvmt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_mvmt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_cmnc_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ft_end_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bzc_trf_curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"org_chg_amt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"sc_rfa_expt_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"aft_expt_dc_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bil_amt",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chg_type",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"General/Balance Charge Type"},
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"soc_flg",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"li",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Local/Intransit DEM Type"},
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ch",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Carrier's Haulage"},
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"d_o",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Cargo Release"},
					  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ofc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Cargo Release Office"},
					  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"clt_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ofc_trns_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Office Transferred"},
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"roll_ovr",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Roll Over due to Carrier Schedule Change"},
					  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"iss_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"cntr_inv_amt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_ar_if_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"web_ind_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Web Empty Notification"},
					  {Type:"Date",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"web_cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Web Empty Notified Date"},
					  {Type:"Date",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"web_mty_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Grace Period End Date"},
					  {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"web_ntfy_pic_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_rhq_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dul_tp_expt_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cxl_bkg_chg_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_delt_rqst_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					InitColumns(cols);
					SetEditable(1);
					SetEllipsis(1);
					SetSelectionMode(smSelectionList);
					SetSheetHeight(DEF_SHEET_HEIGHT);
				}
                break;
         }
     }
     /**
	 * Combo basic setting 
	 * param : comboObj ==> combo obejct, comboNo ==> serial number on combo object tag id
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
	    	case "combo_status":
   	    		with (comboObj) { 
    				SetMultiSelect(1);
					SetColAlign(0, "left");
					SetColWidth(0, "100");
					SetDropHeight(170);
					SetColBackColor(0,"#CCFFFD");
					SetBackColor("#CCFFFD");
					addComboItem(comboObj, comboNo);
					Code="C";
   		    	}
   	    		break;
	    	case "rhq_ofc":
   	    		with (comboObj) { 
    				SetMultiSelect(0);
					SetColAlign(0, "left");
					SetColWidth(0, "70");
					SetDropHeight(170);
					SetColBackColor(0,"#CCFFFD");
					SetBackColor("#CCFFFD");
   		    	}
   	    		break;
	    }
	}
   // handling process for Sheet
     function doActionIBSheet(sheetObj, formObj, sAction, srcObj) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:		// retrieving
            	if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
            	if(formObj.bypodeta.checked){
            		formObj.f_cmd.value=SEARCH01;	// by POD ETA retrieving
            		formObj.f_cmd_text.value=SEARCH01;	// by POD ETA retrieving
            	} else {
            		formObj.f_cmd.value=SEARCH;
            		formObj.f_cmd_text.value=SEARCH;
            	}
            	sheetObj.DoSearch("EES_DMT_3002GS.do", FormQueryString(formObj) );
            	ComOpenWait(false);
              	for (var j=1; j<=sheetObj.RowCount(); j++) {
              		var req_stu=sheetObj.GetCellValue(j,"dmdt_delt_rqst_sts_cd");
	   		           if (req_stu =='R'){
	   		        	   sheetObj.SetCellFontColor(j, "dmdt_chg_sts_cd","#1E90FF");
	   		        	   sheetObj.SetCellFont("FontBold", j, 3,1);
	   		           }else if(req_stu =='J'){
	   		        	   sheetObj.SetCellFontColor(j, "dmdt_chg_sts_cd","#FF0000");
	   		        	   sheetObj.SetCellFont("FontBold", j, 3,1);
	   		           }else { 
	   		        	   sheetObj.SetCellFontColor(j, "dmdt_chg_sts_cd","#000000");
	   		           }
		            }
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
         	case IBCONFIRM:		// Confirm
         		if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	     		ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				sheetObj.DoSave("EES_DMT_3002GS.do", FormQueryString(formObj),"chk");
				ComOpenWait(false);
				break;
 			case IBDELCANCEL:	// Delete Cancel
				 if(!validateForm(sheetObj,formObj,sAction)) return;
	 			sheetObj.SetWaitImageVisible(0);
	     		ComOpenWait(true);
				formObj.f_cmd.value=MULTI01;
				sheetObj.DoSave("EES_DMT_3002GS.do", FormQueryString(formObj),"chk");
				ComOpenWait(false);
				break;
 			case IBPRECAL:
	         	if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	         	ComOpenWait(true);
	         	formObj.f_cmd.value=COMMAND01;	//original MULTI02
	         	ComSetObjValue(formObj.backendjob_id, "PRECAL");
	         	var params=sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3002GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // calling getBackEndJobStatus function after three seconds - recall
				}
	         	break;
 			case IBDRSAVE:
	         	if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	         	ComOpenWait(true);
	         	formObj.f_cmd.value=COMMAND01;	//original MULTI03
	         	ComSetObjValue(formObj.backendjob_id, "DRSAVE");
	         	var params=sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3002GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // calling getBackEndJobStatus function after three seconds - recall
				}
	         	break;
 			case IBBALANCECRE:
 				if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	         	ComOpenWait(true);
	         	formObj.f_cmd.value=COMMAND01;	//original MULTI04
	         	ComSetObjValue(formObj.backendjob_id, "BALANCE");
	         	var params=sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3002GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // calling getBackEndJobStatus function after three seconds - recall
				}
	         	break;
	        case IBSAVE:		// Recalculation 
	        if(!validateForm(sheetObj,formObj,sAction)) return;
         	sheetObj.SetWaitImageVisible(0);
         	ComOpenWait(true);
			formObj.f_cmd.value=COMMAND01;
//          Back End로 변경	        
//	       	var sXml = sheetObj.GetSaveXml("EES_DMT_3002GS.do",FormQueryString(formObj) + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false,true,"chk"),"sheet1_"));
//	    		sheetObj.LoadSaveXml(sXml);
	         	ComSetObjValue(formObj.backendjob_id, "RECALC");
	         	var params=sheetObj.GetSaveString(false, true, "chk") + "&" + FormQueryString(formObj);
	         	var sXml=sheetObj.GetSaveData("EES_DMT_3002GS.do", params);
				var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey");
				if (backendJobKey != undefined && backendJobKey != '') {
					ComSetObjValue(formObj.backendjob_key, backendJobKey);
					sheetObj.SetWaitImageVisible(0);
					sheetObj.SetWaitTimeOut(10000);
					timer=setInterval(getBackEndJobStatus, 3000); // 3초 후에 getBackEndJobStatus함수 실행 - 재귀호출
				}	
			break;					

	        case IBBATCH:

		 		batch_bkg_no 	= "";
		 		batch_cntr_no 	= "";
    			batch_bkg_no 	= ComGetObjValue(formObj.bkg_no);
    			batch_cntr_no 	= ComGetObjValue(formObj.batch_cntr);
    			var batch_dmdt_trf_cd 	= ComGetObjValue(formObj.dmdt_trf_cd);
    			
				ComSetObjValue(formObj.bat_run_tm_id, "");

    			if(!ComShowCodeConfirm("DMT01166", batch_bkg_no, batch_cntr_no)){
    				return;
    			}
    			
    			if(!validateForm(sheetObj,formObj,sAction)) return;  

    			//MOVEMENT CHECK LOGIC 추가
    			formObj.f_cmd.value = SEARCH02;

				var sXml = sheetObj.GetSearchData("EES_DMT_3002GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml, {Sync:1});
				
				var checkBatch = ComGetEtcData(sXml, "CHECK_BATCH");
				ComSetObjValue(formObj.chk_batch, checkBatch);

				var batRunTmId = ComGetEtcData(sXml, "BAT_RUN_TM_ID");
				ComSetObjValue(formObj.bat_run_tm_id, batRunTmId);
    			
				var checkFlg = checkBatch.substring(0,1);
		        if(checkFlg == "N"){
		        	ComShowCodeMessage("DMT01167",batch_bkg_no,  batch_cntr_no);
		        	return;
		        } else if(checkFlg == "I"){
		        	var checkInvoice = checkBatch.substring(2, checkBatch.length);
		        	ComShowCodeMessage("DMT01168", checkInvoice);
		        	return;
		        }
		        
	         	sheetObj.WaitImageVisible=false;

	        	ComOpenWait(true);
    			formObj.f_cmd.value = MULTI05;

				var sXml=sheetObj.GetSearchData("EES_DMT_3002GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml, {Sync:1});

	        	ComOpenWait(false);
				var BatchStatus = ComGetEtcData(sXml, "BatchStatus");

	        	ComOpenWait(true);
				switch(BatchStatus){
					case "R": // success	
						sheetObj.SetWaitImageVisible(0);
						sheetObj.SetWaitTimeOut(10000);
						timer=setInterval(getRetrieveEndJobStatus, 3000); // calling getBackEndJobStatus function after three seconds - recall
						break;
					default: 
						//ComShowCodeMessage("SCE01262");
						ComOpenWait(false);
			        	doActionIBSheet(sheetObj,formObj,IBSEARCH);
						break;							
				}
				break;			
         }
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
	 	var sXml=sheetObj.GetSearchData("EES_DMT_3002GS.do", params);
	 	var jobState=ComGetEtcData(sXml, "jb_sts_flg");
	 	// jobState == "2" BackEndJob processing......
	 	if (jobState == "3") {
	 		clearInterval(timer);
	 		// BackEndJob was successful
	 		getBackEndJobLoadFile();
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
	// reflect result data in case of BackEndJob successful end
	function getBackEndJobLoadFile() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];
	 	var fCmd;
	 	var backendjobId=ComGetObjValue(formObj.backendjob_id);
	 	if(backendjobId == 'PRECAL')
	 		fCmd=MULTI02;
	 	else if(backendjobId == 'DRSAVE')
	 		fCmd=MULTI03;
	 	else if(backendjobId == 'BALANCE')
	 		fCmd=MULTI04;
	 	else if(backendjobId == 'RECALC')
	 		fCmd=MODIFY;
	 	ComSetObjValue(formObj.f_cmd, fCmd);
	 	var params="f_cmd=" + fCmd + "&backendjob_key=" + ComGetObjValue(formObj.backendjob_key);
	 	var sXml=sheetObj.GetSaveData("EES_DMT_3002GS.do", params);
	 	sheetObj.LoadSaveData(sXml);
	 	ComOpenWait(false);
	}
     function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
    	 sheetObj.ShowDebugMsg(false);
    	 sheetObj.SetWaitImageVisible(0);
    	 formObj.f_cmd.value=formCmd;
    	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 switch(comboObj.options.id) {
 	        case "tariff_type":
 				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);
 				if (data != undefined && data != '') {
 					var comboItems=data.split(ROWMARK);
 					addComboItem(comboObj,comboItems);
 				}
 				// retrieving Tariff Type Set-Up by user
 				var data2=ComGetEtcData(sXml, USER_TARIFF_TYPE);
 				// setting default value by user in case of that there is not Tariff Type Set-Up.
 				if(data2 == '')
 					data2='DMIF';
 				else {
 					// setting Tariff Type in case of that there are many of Tariff Type Set-Up values
 					data2=data2.split(',')[0];
 				}
 				// setting initial value of Tariff Type IBMultiCombo
 				comboObj.SetSelectCode(data2);
 				// IBMultiCombo Tariff Type initializing function
 				USR_TRF_TP=data2; 
 				formObj.usr_trf_tp.value=data2;
// 				formObj.dmdt_trf_cd.value=data2;
 				break;
 	       case "rhq_ofc":	// RHQ
		 		var data=ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems=data.split("|");
					comboObj.InsertItem(0, "All", "All");
					for (var i=0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i].toString(), comboItems[i].toString());		
		         	}
				}
				break;	
         }
         sheetObj.SetWaitImageVisible(1);
     }
     /**
      * add data to combo field.
      */	
  	function addComboItem(comboObj,comboItems) {
  		switch(comboObj.options.id) {
  			case "tariff_type":
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0].toString());
		  	   	}
		  		break;
  			case "combo_status":
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
     * event in case of click of data area cell in IBSeet<br>
     * @param {sheetObj} String : IBSheet cell name
     * @param {Row} Long : Row Index
     * @param {Col} Long : Column Index
     * @param {Value} String : changed value, value not applied by Format
     * @param {CellX} Long : x-coordinate
     * @param {CellY} Long : Y-coordinate
     * @param {CellW} Long : width
     * @param {CellH} Long : height
     */
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
            if (ColSaveName(Col) != "chk") {
                // Check box checked in case of row clicked
                // getting row number selected "/" delimeter linking, result :"3/4/5"
                var sRowStr=GetSelectionRows("/");
                var arr=sRowStr.split("/");
                if (arr.length > 1) {
                	for (i=0; i<arr.length; i++) {
                        if (GetCellEditable(arr[i], "chk")) {
                        	// toggle function
                        	SetCellValue(arr[i], "chk",(GetCellValue(arr[i], "chk") == '0') ? "1" : "0",0);
                        }
                    }
                    // AllCheck box status synchronization
                    SetHeaderCheck(0, "chk",(CheckedRows("chk") == RowCount()));
                }
            } else {
            	//AllCheck box status synchronization process in case of Check box clicked
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }

	function sheet1_OnLoadFinish() {
		var formObj = document.form
		var sheetObj = sheetObjects[0];
		
		//sheetObj.WaitImageVisible = false;
		// Tariff Type MultiCombo List retrievint
		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
		
		// RHQ Info
		doActionIBCombo(sheetObj, formObj, comboObjects[2], COMMAND06);
		
		//sheetObj.WaitImageVisible = true;
		
		var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
//		if(usrRhqOfcCd != 'NYCNA') {
//			// 비 미주지역 로그인시 그리드의 해당 컬럼을 숨김.
//			with(sheetObj) {
//				ColHidden("web_ind_flg")	= true;
//				ColHidden("web_cre_dt")		= true;
//				ColHidden("web_mty_dt")		= true;
//				ColHidden("web_ntfy_pic_nm")= true;
//			}
//		}
		
		// initializing condition
		doInit();

        // process in case of calling with popup (Retrieve run)
        if(ComGetObjValue(formObj.call_flag) == "P") {
        	// search condition item inactivity
        	ComEnableManyObjects(false, formObj.bkg_no, formObj.bl_no, formObj.bypodeta);
			 
        	// Retrieve run
        	doActionIBSheet(sheetObj,formObj,IBSEARCH);
        }
	}
	
  	/**
  	 * IBSheet Event Using a lookup function lookup is complete and occurs 
  	 */
  	function sheet1_OnSearchEnd(sheetObj,code,ErrMsg) {
  		if(ErrMsg != '') return;
		var formObj=document.form;
		var fCmd=formObj.f_cmd_text.value;
		sheetObj.CheckAll("chk",0);
		// 'SEARCH' --> Retrieve
		// 'SEARCH01' --> 'by POD ETA' After checking the check box Retrieve
		if(fCmd == SEARCH || fCmd == SEARCH01) {
  			var bkgNo=ComGetObjValue(formObj.bkg_no);
        	var blNo=ComGetObjValue(formObj.bl_no);
        	// That exist in Sheet Form object fills in the value of EtcData.
        	ComEtcDataToForm(formObj, sheetObj);
  			// If you do not have the resulting data, search criteria, enter the data retention
        	if(sheetObj.SearchRows()== 0) {
        		ComSetObjValue(formObj.bkg_no, bkgNo);
        		ComSetObjValue(formObj.bl_no, blNo);
        		ComClearManyObjects(formObj.tot_bil_amt, formObj.cntr_qty);
        		initBtns();
        	} else {
        		if(fCmd == SEARCH) {
        			var cellBackColor="#76DEE1";
        			for(var i=sheetObj.GetTopRow(); i <= sheetObj.SearchRows(); i++) {
        				if(sheetObj.GetCellValue(i, "dmdt_ar_if_cd") == 'Y') {
        					sheetObj.SetRowBackColor(i,cellBackColor);
        				}
        			}
        			var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
        			//if(usrRhqOfcCd == ComGetObjValue(formObj.rhq_ofc_cd) || usrRhqOfcCd == 'SELHO') {
        			if(usrRhqOfcCd == ComGetObjValue(formObj.rhq_ofc_cd) || usrRhqOfcCd == ComGetObjValue(formObj.head_office)) {
		        		// button activity
		        		DmtComEnableManyBtns(true,	"btn_PreCal", "btn_DRSave", "btn_Balance",
		        									"btn_Confirm", "btn_Demand", "btn_Billing", "btn_OFCTrans","btn_Delete", "btn_DELCancel",
		        									"btn_ByCNTR", "btn_MVMTInq", "btn_ExceptionInq", "btn_DownExcel","btn_Recalc");
		        		// button inactivity
		        		DmtComEnableManyBtns(false,	"btn_ByETA");
        			} else {
        				// button activity
        				DmtComEnableManyBtns(true,	"btn_PreCal",
													"btn_ByCNTR", "btn_MVMTInq", "btn_ExceptionInq", "btn_DownExcel","btn_Recalc");
        				// button inactivity
						DmtComEnableManyBtns(false,	"btn_DRSave", "btn_Balance", "btn_DELCancel",
													"btn_Confirm", "btn_Demand", "btn_Billing", "btn_OFCTrans","btn_Delete", "btn_ByETA","btn_Recalc");
        			}
	        	//	if(sheetObj.CellValue(sheetObj.TopRow, "roll_ovr") == 'S')
				  		//document.getElementById("btn_ROInfo").style.color = "red";
	        	//	else
	        			//document.getElementById("btn_ROInfo").style.color = "";
        		} else if(fCmd == SEARCH01) {
	        		// in case of retrievingby POD ETA
	        		ComEnableManyObjects(false, formObj.bkg_no, formObj.bl_no, formObj.bypodeta);
	        		DmtComSetClassManyObjects('input2', formObj.bkg_no, formObj.bl_no);
	        		DmtComEnableManyBtns(true,	"btn_ByETA", "btn_MVMTInq", "btn_DownExcel");
        			DmtComEnableManyBtns(false,	"btn_PreCal", "btn_DRSave", "btn_Balance",
        										"btn_Confirm", "btn_Demand", "btn_Billing", "btn_OFCTrans","btn_Delete", "btn_DELCancel",
        										"btn_ByCNTR", "btn_ExceptionInq", "btn_Recalc");
        			//document.getElementById("btn_ROInfo").style.color = "";
        		}
        		// Total Billable AMT Setting Field Values
            	var bilAmt=sheetObj.ComputeSum("|21|");
            	ComSetObjValue(formObj.tot_bil_amt, ComAddComma2(bilAmt+'', "#,###.00"));
  			}
        	ComClearObject(formObj.dr_dt);
        	// 'Pre Cal.' Button to initialize the color
	  		document.getElementById("btn_PreCal").style.color="";
		}
  	}
  	/**
     * handling after saving
     */
    function sheet1_OnSaveEnd(sheetObj, code, ErrMsg ){
		if(ErrMsg != '') return;
		var formObj=document.form;
		var fCmd=formObj.f_cmd.value;
		if(fCmd == MULTI) {	// Confirm
			var chkRows=sheetObj.FindCheckedRow("chk").split("|");
			for(var i=0; i < chkRows.length; i++) {
				sheetObj.SetCellValue(chkRows[i], "dmdt_chg_sts_cd",'C');
			}
			//Entire UnCheck --> sheetObj.RowStatus(i) is changed to 'R'
			sheetObj.CheckAll("chk",0);
		} else if(fCmd == MULTI02) {	// process after PreCal 
			// Total Billable AMT  Setting Field Values
        	var bilAmt=sheetObj.ComputeSum("|bil_amt|");
  			ComSetObjValue(formObj.tot_bil_amt, ComAddComma2(bilAmt+'', "#,###.00"));
  			// 버튼 비활성화
  			DmtComEnableManyBtns(false, "btn_PreCal", "btn_DRSave", "btn_Balance",
					"btn_Confirm", "btn_Demand", "btn_Billing", "btn_OFCTrans","btn_Delete", "btn_DELCancel", "btn_ByETA" ,"btn_Recalc");
  			// 'Pre Cal.' Button changes color to red
  			document.getElementById("btn_PreCal").style.color="red";
		} else { // MULTI01: DelCancel, MULTI03: D/R Save, MULTI04: Balance Creation
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
    }
    /**
	 * Row EES_DMT_3003.do of selected pages by passing that information is called a pop-up.
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		var formObj=document.form;
		// by POD ETA If the query results 'by CNTR' pop-up windows can not query
		if(formObj.bypodeta.checked)
			return;
		doProcessPopup('btn_ByCNTR');
	}
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
				comboObj.SetSelectCode('A,F,C,I,L,E,N,U,D', false);
			}
			// All 항목이 해제된 경우
			else {
				comboObj.SetItemCheck('A', false, false);
				comboObj.SetItemCheck('F', false, false);
				comboObj.SetItemCheck('C', false, false);
				comboObj.SetItemCheck('I', false, false);
				comboObj.SetItemCheck('L', false, false);
				comboObj.SetItemCheck('E', false, false);
				comboObj.SetItemCheck('N', false, false);
				comboObj.SetItemCheck('U', false, false);
				comboObj.SetItemCheck('D', false, false);
			}
		} 
		else {
			// Finished, Long Staying, System Error 가 선택된 경우, All 항목을 선택해준다.
			if (codes.indexOf('F') != -1 
				&& codes.indexOf('C') != -1 
				&& codes.indexOf('I') != -1
				&& codes.indexOf('L') != -1
				&& codes.indexOf('E') != -1
				&& codes.indexOf('N') != -1
				&& codes.indexOf('U') != -1
				&& codes.indexOf('D') != -1) {
				comboObj.SetItemCheck(0, true, false);
			}
			// Finished, Long Staying, System Error 중 한 항목이라도 선택되지 않았다면, All 항목을 선택해제해준다.
			else if (codes.indexOf('F') == -1 
					|| codes.indexOf('C') == -1 
					|| codes.indexOf('I') == -1
					|| codes.indexOf('L') == -1
					|| codes.indexOf('E') == -1
					|| codes.indexOf('N') == -1
					|| codes.indexOf('U') == -1
					|| codes.indexOf('D') == -1
					) {
				comboObj.SetItemCheck(0, false, false);
			}
		}
	}
  	/*
  	 * Each pop-up call processing
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		var paramVal='';
  		var sScroll='no';
  		var sIframe= true;
  		var modal= true;
  		with(sheetObj) {
	  		switch(srcName) {
	  			case 'btn_Demand':
	  				var chkRow=GetSelectRow();
         			var chgStsCd;
         			var chkFlag=false;
  					for(var i=GetTopRow(); i <= LastRow(); i++) {
  						chgStsCd=GetCellValue(i, "dmdt_chg_sts_cd");
  						if(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'I' || chgStsCd == 'L' || chgStsCd == 'U') {
  							chkFlag=true;
  							break;
  						}
  					}
  					if(chkFlag == false) {
  						ComShowCodeMessage('DMT01040');
     					return;
  					}
  					chgStsCd="F,C,I,L,U";
     				paramVal="?group_by=2"
		     	 	 			+"&chg_type=A"
		     	 	 			+"&ofc_cd="			+ GetCellValue(chkRow, "ofc_cd")
		     	 				+"&dmdt_chg_sts_cd="+ chgStsCd
		     	 				+"&bkg_no="			+ GetCellValue(chkRow, "bkg_no")
		     	 				+"&dmdt_trf_cd="	+ GetCellValue(chkRow, "dmdt_trf_cd")
		     	 				+"&cntr_no="		+ GetCellValue(chkRow, "cntr_no")
		     	 				+"&dmdt_inv_no="
		     	 				+"&invoice_issue=1"	//Invoice Issue BEFORE
		     	 				;
             		sUrl='EES_DMT_3109.do' + paramVal;
              		sWidth  = '945';
              		sHeight = '688';
              		sIframe=true;
	  			break;
	  			
	  			case 'btn_Billing':
	  				var chkRow=GetSelectRow();
	  				var chgStsCd=GetCellValue(chkRow, "dmdt_chg_sts_cd");
	  				var delt_rqst_sts=GetCellValue(chkRow, "dmdt_delt_rqst_sts_cd");//2011.10.10
             		var invIssue='1'; // before:1, after:2
             		var invNo='';
             		var ofcCd='';
	  				if(chgStsCd == 'I') {
	  					invIssue='2';
						invNo=GetCellValue(chkRow, "dmdt_inv_no");
						ofcCd=GetCellValue(chkRow, "cre_ofc_cd");
	  				} else {
	  					var chkFlag=false;
		  		         var chkCnt=0;
		  		         for(var i=GetTopRow(); i <= LastRow(); i++) {
			  		         if(GetCellValue(i, "dmdt_chg_sts_cd") == 'C') {
			  		        	 ofcCd=GetCellValue(i, "ofc_cd");
			  		              chkFlag=true;
			  		              chkCnt++;
			  		              break;
			  		          }
		  		          }
		  		          if(chkCnt == 0){
		  		        	  alert("There is no confirmed charge or invoiced charge!")
		  		        	  break;
			  		       }	  					
	  					
	  					if(delt_rqst_sts == "R") {
	  						ComShowCodeMessage('DMT01154');
         					return;
	  					}
             		}
         			paramVal="?group_by=2"
		        				+ "&chg_type=A"
		        				+ "&ofc_cd="		+ ofcCd
								+ "&bkg_no="		+ GetCellValue(chkRow, "bkg_no")
								+ "&dmdt_trf_cd="	+ GetCellValue(chkRow, "dmdt_trf_cd")
		        				+ "&invoice_no="	+ invNo
		        				+ "&invoice_issue=" + invIssue
		        				;
			        sUrl='EES_DMT_4002.do' + paramVal;
              		sWidth='1050';
              		sHeight='700';
              		sIframe=false;
             	break;
             	
	  			case 'btn_OFCTrans':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		var chkRows=FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
             			var chgStsCd=GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
            			var delt_rqst_sts=""; 
            			delt_rqst_sts=GetCellValue(chkRows[i], "dmdt_delt_rqst_sts_cd"); //2011.10.10
         				if(chgStsCd != 'F' && chgStsCd != 'L') {
         					ComShowCodeMessage('DMT01019');
         					return;
         				}
         				// 2011.10.10 KHH [CHM-201113740-01]
          				if(delt_rqst_sts == "R") {
         					ComShowCodeMessage('DMT01153');
         					return;
         				}
             		}
             		var prevOfc=GetCellValue(chkRows[0], "ofc_cd");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var currOfc=GetCellValue(chkRows[i], "ofc_cd");
         				if(currOfc != prevOfc) {
         					//ComShowCodeMessage('DMT00144', 'Office');
         					ComShowMessage('All Office must be same.');
         					return;
         				}
             		}
					var fmOfcCd=GetCellValue(chkRows[0], "ofc_cd");
					var ofcRhqCd=GetCellValue(chkRows[0], "ofc_rhq_cd");
		  			paramVal="?fm_ofc_cd=" + fmOfcCd + "&ofc_rhq_cd=" + ofcRhqCd;
             		sUrl='EES_DMT_3101.do' + paramVal;
              		sWidth  = '618';
              		sHeight = '445';
              		sIframe=true;
           		break;
           		
	  			case 'btn_Delete':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR for Delete');
             			return;
             		}
             		var chkCnt=0;
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
						var chgStsCd=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
						var delt_rqst_sts=sheetObj.GetCellValue(chkRows[i], "dmdt_delt_rqst_sts_cd");
            			// 2011.10.10 KHH [CHM-201113639-01]
            			if(delt_rqst_sts=='R'){
            				ComShowCodeMessage('DMT01155');
            				return;
            			}
             			if(chgStsCd == '') {
             				ComShowCodeMessage('DMT01060');
             				sheetObj.SetSelectRow(i);
             				return;
             			} else if(chgStsCd == 'D') {
             				// 2011.10.10 KHH [CHM-201113639-01]
             				ComShowCodeMessage("DMT00176", sheetObj.GetCellValue(chkRows[i], "cntr_no"));
    	  					return;
         				} else if(chgStsCd != 'I') {
         					chkCnt++;
         				}
             		}
             		if(chkCnt == 0) {
             			ComShowCodeMessage('DMT01026');
     					return;
             		}
             		sUrl='EES_DMT_3104.do';
              		sWidth  = '450';
              		sHeight = '549';
              		sIframe=true;
	  			break;
	  			
	  			case 'btn_ByETA':
	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'CNTR');
             			return;
             		}
             		var chkRows=FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length-1; i++) {
             			var chg_sts=GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
             			if(chg_sts != '') {
             				ComShowCodeMessage('DMT01054');
             				SetSelectRow(chkRows[i]);
             				return;
             			}
             		}
	  				sUrl='EES_DMT_3106.do' + '?call_flag=bybkg';
              		sWidth  = '790';
              		sHeight = '522';
              		sIframe=true;
	  			break;
	  			
	  			case 'btn_ByCNTR':
	  				var chkRow=GetSelectRow();
	  				var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
        			//if(usrRhqOfcCd == ComGetObjValue(formObj.rhq_ofc_cd) || usrRhqOfcCd == 'SELHO')
	  				if(usrRhqOfcCd == ComGetObjValue(formObj.rhq_ofc_cd) || usrRhqOfcCd == ComGetObjValue(formObj.head_office)) {
        				sUrl="EES_DMT_3003P.do";
    	          		sWidth  = '1150';
    	          		sHeight = '700';        				
	  				}
        			else {
        				sUrl="EES_DMT_3006P.do";
    	          		sWidth  = '1150';
    	          		sHeight = '700';        				
        			}
					var svrId=GetCellValue(chkRow , "svr_id");
					var cntrNo=GetCellValue(chkRow , "cntr_no");
					var cntrCycNo=GetCellValue(chkRow , "cntr_cyc_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgLocDivCd=GetCellValue(chkRow , "dmdt_chg_loc_div_cd");
					var chgSeq=GetCellValue(chkRow , "chg_seq");
		  			paramVal="?call_flag=P&svr_id=" + svrId + "&cntr_no=" + cntrNo + "&cntr_cyc_no=" + cntrCycNo + "&dmdt_trf_cd=" + trfCd 
		  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd + "&chg_seq=" + chgSeq;
	  				sUrl=sUrl + paramVal;

	          		sIframe=true;
	  			break;
//	  			case 'btn_ROInfo':
//	  				var bkgNo = ComGetObjValue(document.form.bkg_no);
//	  				if(ComIsEmpty(bkgNo)) {
//	  					ComShowCodeMessage('DMT03028', 'BKG No.');
//	  					return;
//	  				}
//	  				
//	  				paramVal = "?bkg_no=" + bkgNo;
//	  				sUrl	= 'ESM_BKG_0724.do' + paramVal;
//              		sWidth	= '1000';
//              		sHeight	= '450';
//	  				break;
	  			case 'btn_MVMTInq':
	  				var inqRow=0;
	  				if(CheckedRows("chk") > 0) {
	  					var chkRows=FindCheckedRow("chk").split("|");
	  					inqRow=chkRows[0];
	  				} else if(GetSelectRow()> 0) {
	  					inqRow=GetSelectRow();
	  				}
					var cntrNo=GetCellValue(inqRow , "cntr_no");
					var cntrTpszCd=GetCellValue(inqRow , "cntr_tpsz_cd");
	  				paramVal="?pop_mode=Y&p_cntrno=" + cntrNo.substring(0,10) +
                        		"&check_digit=" + cntrNo.substring(10,11) +
		                        "&ctnr_tpsz_cd=" + cntrTpszCd;
					sUrl='EES_CTM_0408_POP.do' + paramVal;
					sWidth='1020';
					sHeight='690';
					sIframe=false;
					modal=false;
	  			break;
	  			
	  			case 'btn_ExceptionInq':
	  				var scNo=ComGetObjValue(formObj.sc_no);
	  				var rfaNo=ComGetObjValue(formObj.rfa_no);
	  				if(scNo != '' && rfaNo != '') scNo='';
	  				paramVal="?caller=3002"
	  							+ "&sc_no="		+ scNo
	  							+ "&rfa_no="	+ rfaNo
	  							+ "&trf_cd=" + GetCellValue(GetSelectRow(), "dmdt_trf_cd")
	  							;
	  				sUrl='EES_DMT_2007_1_POP.do' + paramVal;
              		sWidth  = '1280';
              		sHeight = '700';
              		sScroll = 'yes';
              		sIframe=false;
					modal=false;
	  				break;
	  		} // switch-end
  		} // with-end
  		if(sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenPopup(sUrl, sWidth, sHeight, "findCommodity", "1,0", modal);
  		}
  	}
 
  	function findCommodity(rtnVal) {
  		var formObj = document.form;
  		var sheetObj=sheetObjects[0];
        if(rtnVal == "Y") {
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		}
   }
  	
     /**
      * Screen form validation process for processing the input values
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
          		case IBSEARCH:      //조회
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
             		if(!bypodeta.checked && comboObjects[1].GetSelectCode()== '') {
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
             			var chgStsCd=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chgStsCd != 'F') {
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
             			var chgStsCd=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
         				if(chgStsCd != 'D') {
         					ComShowCodeMessage('DMT01042');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
             		}
             		if(!ComShowCodeConfirm('DMT01063'))
             			return false;
             		break;
             	case IBPRECAL:
             	case IBDRSAVE:
             		var drDt=ComGetObjValue(dr_dt);
             		if(drDt == '') {
             			ComShowCodeMessage('DMT02002', 'D/R Date');
             			ComSetFocus(dr_dt);
             			return false;
             		}
             		// DMT01031: {?msg1} should be same or later than {?msg2}';
             		drDt=ComGetUnMaskedValue(dr_dt, "ymd");
             		//사용자 Office 의 현재 날짜를 조회한다.
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
             			var chkRow=chkRows[i];
             			/*
	           	    	 ComChkPeriod(fromDate, toDate)
	           	    	 0 : fromDate > toDate
	           	    	 1 : fromDate < toDate
	           	    	 2 : fromDate=toDate
	           	    	 */
             			if( sheetObj.GetCellValue(chkRow, "chg_type") == 'B') {
             				// In Balance Charge D / R Date From Date is always greater than the known
             				if(ComChkPeriod(drDt, fmMvmtDt) != 0) {
                     			ComShowCodeMessage('DMT01078');
                     			sheetObj.SetSelectRow(chkRow);
                     			return false;
                     		}
             			} else {
             				if(ComChkPeriod(drDt, fmMvmtDt) == 1) {
                     			ComShowCodeMessage('DMT01031', 'D/R Date', 'From date');
                     			sheetObj.SetSelectRow(chkRow);
                     			return false;
                     		}
             			}
						var chgStsCd=sheetObj.GetCellValue(chkRow, "dmdt_chg_sts_cd");
						var toMvmtSts=sheetObj.GetCellValue(chkRow, "to_mvmt_sts_cd");
         				if((chgStsCd == 'F' && toMvmtSts == 'DR') || chgStsCd == 'U' || chgStsCd == 'L') {
         				} else {
         					ComShowCodeMessage('DMT01060');
         					sheetObj.SetSelectRow(chkRow);
         					return false;
         				}
             		}
             		/*for(var i=0; i < chkRows.length-1; i++) {
var toMvmtYdCd=sheetObj.GetCellValue(chkRows[i], "to_mvmt_yd_cd");
             			if(toMvmtYdCd == '')
sheetObj.SetCellValue(chkRows[i], "to_mvmt_yd_cd",sheetObj.GetCellValue(chkRows[i], "fm_mvmt_yd_cd"),0);
             		}*/
             		// Status values ​​stored in the variable search criteria
             		ComSetObjValue(sch_chg_sts, comboObjects[1].GetSelectCode());
             		break;
             	case IBBALANCECRE:
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'Charge');
             			return false;
             		}
             		var chkRows=sheetObj.FindCheckedRow("chk").split("|");
             		for(var i=0; i < chkRows.length; i++) {
						var chgStsCd=sheetObj.GetCellValue(chkRows[i], "dmdt_chg_sts_cd");
						var toMvmtStsCd=sheetObj.GetCellValue(chkRows[i], "to_mvmt_sts_cd");
         				if( !(chgStsCd == 'F' || chgStsCd == 'C' || chgStsCd == 'I') || toMvmtStsCd != 'DR') {
         					ComShowCodeMessage('DMT01058');
         					sheetObj.SetSelectRow(chkRows[i]);
         					return false;
         				}
         				if(sheetObj.GetCellValue(chkRows[i], "dul_tp_expt_flg") == 'Y') {
         					ComShowCodeMessage('DMT03069', 'Balance Creation');
         					sheetObj.SetSelectRow(chkRows[i]);
                 			return false;
         				}
         				if(!sheetObj.GetCellValue(chkRows[i], "to_mvmt_dt")) {
         					ComShowCodeMessage('DMT03028', 'To DT');
         					sheetObj.SetSelectRow(chkRows[i]);
                 			return false;
         				}
             		}
             		if(!ComShowCodeConfirm('DMT01069'))
             			return false;
             		break;
             	case IBSAVE:
             		if(sheetObj.CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'Charge for Recalculation');
             			return false;
             		}
             		break;
             		
             	case IBBATCH:
             		var bkgNo = ComGetObjValue(bkg_no);
          			var blNo = ComGetObjValue(bl_no);
          			
          			if(bkgNo == '' && blNo == '') {
          				ComShowCodeMessage('DMT00102', "BKG No. or B/L No.");
             			return false;
          			}
          			ComSetObjValue(dmdt_trf_cd,		comboObjects[0].GetSelectCode());
          			ComSetObjValue(dmdt_chg_sts_cd,	comboObjects[1].GetSelectCode());
          			ComSetObjValue(rhq_ofc_cd,		comboObjects[2].GetSelectCode());
             		break;   
        	 }
         }
         return true;
     }

	 /**
	 * confirm to status 3 for BackEndJob
	 */
	 function getRetrieveEndJobStatus() {
	 	var formObj=document.form;
	 	var sheetObj=sheetObjects[0];

		formObj.f_cmd.value = SEARCH03;

		var sXml = sheetObj.GetSearchData("EES_DMT_3002GS.do", FormQueryString(formObj));
//		sheetObj.LoadSearchData(sXml, {Sync:1});
		
		var batRsltFlg = ComGetEtcData(sXml, "BAT_RSLT_FLG");
		var batRsltRmk = ComGetEtcData(sXml, "BAT_RSLT_RMK");
		
		if ( batRsltFlg == "Y") {
	 		clearInterval(timer);
	 		// read already BackEndJob result file
	 		if ( batRsltRmk != " "  ){
	 			alert(batRsltRmk);
	 		}
//		    ComShowCodeMessage("DMT01165",batch_bkg_no,  batch_cntr_no);
	 		ComOpenWait(false);
	        doActionIBSheet(sheetObj,formObj,IBSEARCH);
	 	}
	 }
	/* developers work end */