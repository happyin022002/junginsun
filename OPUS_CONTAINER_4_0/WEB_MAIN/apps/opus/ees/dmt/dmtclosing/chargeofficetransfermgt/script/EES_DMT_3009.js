/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3009.js
*@FileTitle  : Office Transfer History
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
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	
	var DEF_SHEET_HEIGHT = 480;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
      /***** case in Sheet count are more two by Tab, defining adding sheet *****/
		var sheetObj=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcObj= ComGetEvent();
     		var srcName= ComGetEvent("name");
     		// Click the button at the bottom of the grid is disabled, return
     		if(!ComIsBtnEnable(srcName)) return;
		     switch(srcName) {
		     	case "btns_calendar": //Calendar button
					var cal=new ComCalendarFromTo();
					cal.select(formObj.fm_cre_dt, formObj.to_cre_dt, 'yyyy-MM-dd');
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
				case "btn_New":
					doInit();
					break; 
				case "btn_DownExcel":
					if(sheetObj.RowCount() < 1){//no data
						  ComShowCodeMessage("COM132501");
						}else{
							sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
						}
 					break;
				case "btn_ByBKG":
				case "btn_ByCNTR":
					doProcessPopup(srcName);
					break;
				case "btns_multisearch":
					alert("The service is not available now.");
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
		
		sheet1_OnLoadFinish();
     }
     function sheet1_OnLoadFinish() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		//sheetObj.WaitImageVisible = false;
		ComSetObjValue(formObj.ofc_cd, ComGetObjValue(formObj.rhq_ofc_cd));
		// From Office
		doActionIBCombo(sheetObj, formObj, comboObjects[0], COMMAND08);
		// To Office
		doActionIBCombo(sheetObj, formObj, comboObjects[1], COMMAND08);
		// Tariff
		doActionIBCombo(sheetObj, formObj, comboObjects[2], SEARCHLIST);
	    // Retrieving conditions initializing
	    doInit();
	    //sheetObj.WaitImageVisible = true; 
 	}
 	/*
	 * INIT SETTING
	 */
	function doInit() {
		sheetObjects[0].RemoveAll();
		ComSetObjValue(document.form.cond_type, "date");
		doEnableCondObj("date");
	}
	function initControl() {
		// axon_event.addListenerForm  ('blur',	'obj_blur',		document.form, 'cond_type'); //- out of focus
		// axon_event.addListenerFormat('focus',	'obj_focus',	document.form); // Get focus
		// axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard
		// axon_event.addListener('click',		'condType_click',	'cond_type');
		// axon_event.addListener('keydown',	'ComKeyEnter',		'form');
		// axon_event.addListener('mouseover', 'btn_mouseover',	'OTDate');	// onMouseover event(balloon message)
		// axon_event.addListener('mouseout',	'btn_mouseout',		'OTDate');	// onMouseout event(balloon message)
		doEnableCondObj("date");
	}
	// 'by ETA' onMouseover event  (button Show balloon message)
	function btn_mouseover() {
		var bak='lightyellow';
		var msg='Office Transferred Date';
		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
    	var x=event.x+document.body.scrollLeft;
		var y=event.y+document.body.scrollTop;
		var skn=document.all("topdeck").style;
		skn.left=x+10;
		skn.top=y-20;
		document.all("topdeck").innerHTML=content;
		skn.visibility='visible';
     }
     // 'by ETA' onMouseout event  (button Hide balloon message)
     function btn_mouseout() {
    	 var skn=document.all("topdeck").style;
    	 skn.visibility='hidden';
     }
	/*
	 * From/To Office의 RHQ Select Object OnChange event Forward
	 */
	function rhp_change() {
		var obj=ComGetEvent();
		doRhqChange(obj);
	}
	/*
	 * From/To Office의 RHQ Select Object OnChange event 
	 */
	function doRhqChange(obj) {
		var formObj=document.form;
		// the selected text value of From/To Office RHQ (Text required)
		var rhqCd=ComGetObjValue(obj);
		ComSetObjValue(formObj.ofc_cd, rhqCd);
		// Belonging to the selected RHQ, Office Code list specifying IBMultiCombo Object set
		var comboObj=(obj.name == 'fm_rhq') ? comboObjects[0] : comboObjects[1];
		comboObj.RemoveAll();
		doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND08);
		comboObj.SetSelectCode('All');
	}
	// out of focus
    function obj_blur(){
        //check inputing Validation + Inserting separator 
		 var obj=ComGetEvent();
		 if(obj.name == 'bkg_no' || obj.name == 'bl_no' || obj.name == 'cntr_no') {
		 } else {
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
        if (ComGetEvent('isContentEditable') && ComGetEvent('value') != null && obj.value.length >=1 ) obj.select();
    }
	//business javascript OnKeyPress event handling
//	function obj_keypress() {
//		switch(ComGetEvent().dataformat){
//        	case "engup":
//		    	// upper case + numbers 
//        		ComKeyOnlyAlphabet('uppernum', ',');
//		        break;
//        	case "engup2":
//		    	//  upper case + numbers + exceptional letters
//        		DmtComKeyOnlyAlphabet('uppernum', ',');
//		        break;
//        	case "int":
//	   	        //only numbers
//	   	        ComKeyOnlyNumber(ComGetEvent());
//	   	        break;
//        	default:
//	         	// only numbers(integer, date, time)
//	            ComKeyOnlyNumber(ComGetEvent());
//		}
//    }
	/*
	 * Search separator (Date / CNTR) Select the radio button click event handler function passed to
	 */
	function condType_click() {
		doEnableCondObj(ComGetEvent('value'));
	}
	/*
	 * Search separator (Date / CNTR) Select the radio button click event handler function passed to
	 */
	function doEnableCondObj(condType) {
     	 var formObj=document.form;
     	 with (formObj) {
 	    	 switch(condType){
 	    	 	case "date":   
 	    	 		// ******** activating  **********
 	    	 		// O/T Date
 	    	 		ComEnableManyObjects(true, fm_cre_dt, to_cre_dt, btns_calendar);
 	 	    		setClassManyObjects('input1', fm_cre_dt, to_cre_dt);
 	 	    		// date initializing 
 	 	    		var fmCreDt=ComGetDateAdd(null, "M", -1);
 	 	    		//var toCreDt = ComGetNowInfo();
 	 	    		var toCreDt=DmtComOfficeCurrDate(sheetObjects[0], formObj);
 	 	    		ComSetObjValue(fm_cre_dt, fmCreDt);
 	 	    		ComSetObjValue(to_cre_dt, toCreDt);
 	    	 		//ComEnableManyObjects(true, fm_rhq, to_rhq);
 	    	 		// From RHQ is Default value (case in not All')이,
 	    	 		//  initializing Default value, search Office Code of  all  RHQ.
 	    	 		/*
 	    	 		if(fm_rhq.value != '') {
 	    	 			ComClearObject(fm_rhq);
 	    	 			doRhqChange(fm_rhq);
 	    	 		}*/
 	    	 		// if ToRHQ is different to RHQ of the login user Office,
 	    	 		// initializing login RHQ, search Office Code of login RHQ.
 	    	 		/*
 	    	 		if(ComGetObjValue(to_rhq) != rhq_ofc_cd.value) {
 	    	 			ComSetObjValue(to_rhq, rhq_ofc_cd.value);
 	    	 			doRhqChange(to_rhq);
 	    	 		}*/
 	    	 		initComboValue_fm_ofc();
 	    	 		initComboValue_to_ofc();
 	    	 		initComboValue_tariff_type();
 	    	 		// ******** deactivating  **********
 	    	 		ComEnableManyObjects(false, bkg_no, bl_no, cntr_no);	//CNTR Disable
 	    	 		setClassManyObjects('input2', bkg_no, bl_no, cntr_no);	//비activating  class (input2)
 	    	 		ComClearManyObjects(bkg_no, bl_no, cntr_no);
 	    	 		// MULTI input pop-up window's icons disable 
 	    	 		ComEnableManyObjects(false, btns_multisearch1, btns_multisearch2, btns_multisearch3);
 	    	 		break;
 	    	 	case "cntr":
 	    	 		// ******** deactivating  **********
 	    	 		// O/T Date
 	    	 		ComEnableManyObjects(false, fm_cre_dt, to_cre_dt, btns_calendar);
 	 	    		setClassManyObjects('input2', fm_cre_dt, to_cre_dt);
 	 	    		ComClearManyObjects(fm_cre_dt, to_cre_dt);
 	 	    		ComSetObjValue(comboObjects[0], "");
 	 	    		ComSetObjValue(comboObjects[1], "");
 	 	    		ComSetObjValue(comboObjects[2], "");
 	    	 		comboObjects[0].SetEnable(0);
 	    	 		comboObjects[1].SetEnable(0);
 	    	 		comboObjects[2].SetEnable(0);
 	    	 		// ******** activating  **********
 	    	 		ComEnableManyObjects(true, bkg_no, bl_no, cntr_no);		//CNTR
 	    	 		setClassManyObjects('input1', bkg_no, bl_no, cntr_no);	//비activating  class (input2)
 	    	 		// MULTI input pop-up window's icons enable 
 	    	 		ComEnableManyObjects(true, btns_multisearch1, btns_multisearch2, btns_multisearch3);
 	    	 		break;
 	    	 }
     	 }
	}
	/*
	 * Setting HTML Element ClassName
	 */
	function setClassManyObjects(clsNm, objs) {
		try {
              var args=arguments;
              if (args.length < 2) return;
              for(var i=1; i<args.length; i++) {
                  if (args[i].tagName != undefined) {
                 	 args[i].className=clsNm;
                  }
              }
		} catch(err) { ComFuncErrMsg(err.message); }
	}
	/*
	 * HTML Select Object of the selected item, a specific value (Text) of the items specified in
	 */
	function setSelObjText(obj, sText) {
		for (var idx=0; idx < obj.length; idx++) {
	        if (obj[idx].text == sText) {
	            obj[idx].selected=true;
	            break;
	        }
	    }
	}
	// IBMultiCombo From Office initializing
	function initComboValue_fm_ofc() {
		comboObjects[0].SetEnable(1);
		ComSetObjValue(comboObjects[0], "");
	}
	// IBMultiCombo To Office Type initializing
	function initComboValue_to_ofc() {
		comboObjects[1].SetEnable(1);
		ComSetObjValue(comboObjects[1], ComGetObjValue(document.form.usr_ofc_cd));
	}
	// IBMultiCombo Tariff Type initializing
	function initComboValue_tariff_type() {
		comboObjects[2].SetEnable(1);
		ComSetObjValue(comboObjects[2], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
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
			      var HeadTitle1=" |SEL|Seq.|STS|A/R|CNTR No.|T/S|Tariff|From|To|Reason";
			      HeadTitle1 += "|BKG No.|B/L No.|VVD CD|POR|POL|POD|DEL|Cur.|Billable AMT|G/B|O/T Date|User OFC|User Name|svr_id|cntr_cyc_no|dmdt_chg_loc_div_cd|chg_seq|ofc_rhq_cd";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, FrozenCol: 6, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_ar_if_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_ofc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:"trns_rsn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,	ToolTip:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bzc_trf_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bil_amt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chg_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1,  ToolTipText:"General/Balance Charge Type"},
			             {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"usr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ofc_rhq_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetEllipsis(1);
		          //FrozenCols=SaveNameCol("cntr_tpsz_cd");
			      //no support[check again]CLT
			      //ToolTipOption="balloon:true;width:50px;";
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
   	    	case "fm_ofc":
   	    	case "to_ofc":
   	    		with (comboObj) {
   					SetMultiSelect(0);
   					SetUseAutoComplete(1);
					/*SetColAlign(0, "left");
					SetColWidth(0, "60");
  					SetDropHeight(160);*/
					//ColBackColor(0) = "#CCFFFD";
					//BackColor = "#CCFFFD";
   					ValidChar(2);	// use upper case
					SetMaxLength(6);
   		    	}
   				break;
   	    	case "tariff_type":
   	    		with (comboObj) { 
   					SetMultiSelect(1);
					/*SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "45");
					SetColWidth(1, "310");
					SetDropHeight(160);*/
					//ColBackColor(0) = "#CCFFFD";
  					//ColBackColor(1) = "#CCFFFD";
  					//BackColor = "#CCFFFD";
   		    	}
   				break;
   	     }
   	}
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:     // Search
            	if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;
//parameter changed[check again]CLT             	
            	sheetObj.DoSearch("EES_DMT_3009GS.do", FormQueryString(formObj) );
            	ComOpenWait(false);
            	break;
         }
     }
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
		sheetObj.ShowDebugMsg(false);
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value=formCmd;
//parameter changed[check again]CLT 		
		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
		switch(comboObj.options.id) {
			case "fm_ofc":
			case "to_ofc":
				var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
				if(subOfcCds != undefined && subOfcCds != '') {
					var comboItems=subOfcCds.split(",");
					addComboItem(comboObj,comboItems);
				}
	    	    break;
	        case "tariff_type":
		 		// Tariff type comboList
				var data=ComGetEtcData(sXml, COMMON_TARIFF_CD);
				if (data != undefined && data != '') {
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj,comboItems);
					comboItem=comboItems[0].split(FIELDMARK);
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
 			case "fm_ofc":
 			case "to_ofc":
		  		comboObj.InsertItem(0, "", "");
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		//var comboItem = comboItems[i].split(FIELDMARK);
		  			comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);
		  	   	}
		  		break;
 			case "tariff_type":
		  		comboObj.InsertItem(0, "All|All", "All");
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		  	   	}
		  		break;
 		}
 	}
 	// Multi Combo click event
//	function tariff_type_OnCheckClick(comboObj, index, code) {
//	    if(index==0) {
//	    	var bChk=comboObj.GetItemCheck(index);
//    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
//    			comboObj.SetItemCheck(i,bChk);
//	    	}
//	    } else {
//    		comboObj.SetItemCheck(0,0);
//	    }
//	}

 	var selComboIndex, selComboCode;
 	function tariff_type_OnSelect(comboObj ,index, code) {
 		selComboIndex = index;
 		selComboCode = code;
 	}
 	function tariff_type_OnChange() {
 	    setMultiCombo(tariff_type, selComboIndex, selComboCode);
 	}
 	
	/**
	 * Row selected and the information passed to EES_DMT_3003.do is called a pop-up.
	 */
	function sheet1_OnDblClick(sheetObj,Row,Col) {
		if(sheetObj.ColSaveName(Col) == "chk") return;
		doProcessPopup('btn_ByCNTR');
	}
	/*
	 * Balloon handling in Grid
	 */
//	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
//		with(sheetObj){
//			Row=MouseRow();
//			Col=MouseCol();
//			if (Row > 0) {
//				var ttText = '';
//				var colSaveNm = ColSaveName(Col);
//				if (colSaveNm == 'trns_rsn') {	// Showing the entire contents of Remark
//					var corrRmk = GetCellValue(Row, "trns_rsn");
//					if (corrRmk == '') return;
//					ttText = corrRmk;
//				}
//				SetToolTipText(Row, Col, ttText); 				
//			} 
//			else {
//				SetToolTipText(Row, Col, "");
//			}
//		}
//	}
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
  	 * Pop-up call processing
  	 */
  	function doProcessPopup(srcName) {
  		var formObj=document.form;
  		var sheetObj=sheetObjects[0];
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		with(sheetObj) {
	  		switch(srcName) {
		  		case 'm_bkg_no':	// BKG No. Multi-Input pop-up calls
	  			case 'm_bl_no':		// B/L No. Multi-Input pop-up calls
	  			case 'm_cntr_no':	// CNTR No. Multi-Input pop-up calls
		  			var flag=ComReplaceStr(srcName,"m_","");
			  		// Specify the details of multi-input pop-up title
	  				var returntitle='';
	  				if(flag == 'bkg_no')
	  					returntitle='BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle='B/L No.';
	  				else if(flag == 'cntr_no')
	  					returntitle='CNTR No.';
	  				var param="?returnval=" + flag + "&returntitle=" + returntitle;	  				//
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 420, 431, "getDmt_Multi", "1,0", true);
	  				return;
				break;
				
		  		case 'btn_ByBKG':
		  			var chkRow=GetSelectRow();
					var bkgNo=GetCellValue(chkRow , "bkg_no");
					var blNo=GetCellValue(chkRow , "bl_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgStsCd=GetCellValue(chkRow , "dmdt_chg_sts_cd");
		  			var paramVal="?call_flag=P"
		  								+ "&bkg_no=" + bkgNo
		  								+ "&bl_no=" + blNo
		  								+ "&dmdt_trf_cd=" + trfCd
		  								+ "&dmdt_chg_sts_cd=" + chgStsCd;
		  			// case in same RHQ OFC
		  			if(ComGetObjValue(formObj.rhq_ofc_cd) == GetCellValue(chkRow , "ofc_rhq_cd"))
		  				sUrl='EES_DMT_3002P.do';
		  			else
		  				sUrl='EES_DMT_3005P.do';
	  				sUrl=sUrl + paramVal;
	          		//sWidth='1010';
	  				//sHeight='755';
	  				sWidth='1280';
	          		sHeight='700';
	  			break;
	  			
		  		case 'btn_ByCNTR':
		  			var chkRow=GetSelectRow();
					var svrId=GetCellValue(chkRow , "svr_id");
					var cntrNo=GetCellValue(chkRow , "cntr_no");
					var cntrCycNo=GetCellValue(chkRow , "cntr_cyc_no");
					var trfCd=GetCellValue(chkRow , "dmdt_trf_cd");
					var chgLocDivCd=GetCellValue(chkRow , "dmdt_chg_loc_div_cd");
					var chgSeq=GetCellValue(chkRow , "chg_seq");
		  			var paramVal="?call_flag=P"
			  							+ "&svr_id=" + svrId
			  							+ "&cntr_no=" + cntrNo
			  							+ "&cntr_cyc_no=" + cntrCycNo
			  							+ "&dmdt_trf_cd=" + trfCd 
			  							+ "&dmdt_chg_loc_div_cd=" + chgLocDivCd
			  							+ "&chg_seq=" + chgSeq;
		  			// case in same RHQ OFC
		  			if(ComGetObjValue(formObj.rhq_ofc_cd) == GetCellValue(chkRow , "ofc_rhq_cd"))
		  				sUrl='EES_DMT_3003P.do';
		  			else
		  				sUrl='EES_DMT_3006P.do';
	  				sUrl=sUrl + paramVal;
	          		sWidth='1100';
	          		sHeight='700';
  				break;
	  		}
  		}
  		if (sUrl != '') {
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
  			ComOpenPopup(sUrl, sWidth, sHeight, "callbackProc", "0,1", true);
  		}
  	}
  	
  	function callbackProc(rtnVal) {
  		if (rtnVal == "Y") {
  			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
  		}
  	}
  	
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 var condType=ComGetObjValue(cond_type);
        	 //******************** Date conditions  ************************
        	 if(condType == 'date') {
      			if(!ComIsDate(fm_cre_dt)) {
      				ComAlertFocus(fm_cre_dt, ComGetMsg('COM12134', 'O/T From Date'));
      				return false;
      			}
      			if(!ComIsDate(to_cre_dt)) {
      				ComAlertFocus(to_cre_dt, ComGetMsg('COM12134', 'O/T To Date'));
      				return false;
      			}
      			var startDate=ComGetUnMaskedValue(fm_cre_dt, 'ymd');
      			var endDate=ComGetUnMaskedValue(to_cre_dt, 'ymd');
				//Check period
      			if (startDate > endDate) {
					ComShowCodeMessage("COM12133", "'O/T From Date'", "'O/T To Date'", "earlier");
					return false;
				}
      			/*
      			var fmRHQ=ComGetObjValue(fm_rhq);
      			var fmOfcCd=comboObjects[0].GetSelectCode();
      			if(fmRHQ != '' && fmOfcCd == '') {
      				ComShowCodeMessage('COM12113', "From Office");
          			return false;
      			}
      			var toRHQ=ComGetObjValue(to_rhq);
      			var toOfcCd=comboObjects[1].GetSelectCode();
      			if(toRHQ != '' && toOfcCd == '') {
      				ComShowCodeMessage('COM12113', "To Office");
          			return false;
      			}
          		// From Office
          		if(fmRHQ == '') {
          			ComSetObjValue(fm_ofc_cd, "");
          		} else {
          			ComSetObjValue(fm_ofc_cd, fmOfcCd);
          		}
          		// To Office
          		if(toRHQ == '') {
          			ComSetObjValue(to_ofc_cd, "");
          		} else {
         			ComSetObjValue(to_ofc_cd, toOfcCd);
          		}
          		*/
          		var fmOfcCd=comboObjects[0].GetSelectText();
          		var toOfcCd=comboObjects[1].GetSelectText();
      			ComSetObjValue(fm_ofc_cd, fmOfcCd);
      			ComSetObjValue(to_ofc_cd, toOfcCd);
      			var trfCd=comboObjects[2].GetSelectCode();
          		if(trfCd.indexOf('All,') != -1) {
          			//trfCd = ComReplaceStr(trfCd, 'All,', '');
          			trfCd='';
          		}
          		ComSetObjValue(dmdt_trf_cd, trfCd);
      		} else {
      			//******************** CNTR conditions  ************************
  				if(ComIsNull(bkg_no) && ComIsNull(bl_no) && ComIsNull(cntr_no)) {
      				ComShowCodeMessage('DMT00102', 'BKG No. or B/L No. or CNTR No.');
          			return false;
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
      		} // if-else end
         } // with end
         return true;
     }

     function fm_ofc_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	 fm_ofc.value = newCode;
     }
   
     function fm_ofc_OnBlur(comboObj) {
    	 fm_ofc.value = comboObj.GetSelectCode();
     }
     
     function to_ofc_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    	 to_ofc.value = newCode;
     }
   
     function to_ofc_OnBlur(comboObj) {
    	 to_ofc.value = comboObj.GetSelectCode();
     }
     
//     function tariff_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
//    	 tariff_type.value = newCode;
//     }
   
     function tariff_type_OnBlur(comboObj) {
    	 tariff_type.value = comboObj.GetSelectCode();
     }