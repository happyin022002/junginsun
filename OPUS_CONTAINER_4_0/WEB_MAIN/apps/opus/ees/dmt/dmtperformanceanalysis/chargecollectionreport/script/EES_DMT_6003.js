/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6003.js
*@FileTitle  : Monthly Invoiced &amp; Collection by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   	/* Developer's task	*/
    // common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
          /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
 		  var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
          try {
        	  var srcObj=ComGetEvent();
        	  var srcName=srcObj.getAttribute("name");
        	  switch(srcName) {
        	  	case "btns_calendar":
					var cal=new ComCalendarFromTo();
	                cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');					
					break;
        	  	case "btn_Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_New":
					doInit();
					break;
				case "btn_DownExcel":
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
					}
					
					break;
				case "btn_Minimize":
					var schCondDiv=document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {	
 						schCondDiv.style.display='none';
 						sheetObj.SetSheetHeight(470);
 					} else {
 						schCondDiv.style.display='block';
 						sheetObj.SetSheetHeight(350);
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
      * Register as an array IBSheet Object
      * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
      * Array defined at the top of the source
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
        for(var k=0;k<comboObjects.length;k++){
       	 	initCombo(comboObjects[k],k+1);
        }
        
        initControl();
        
        sheet1_OnLoadFinish()
	}
	
  	function initControl() {
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
  		//axon_event.addListener('blur',	'obj_blur',	'to_mvmt_mon', 'fm_dt', 'to_dt');	
   		//axon_event.addListener('focus',	'obj_focus', 'to_mvmt_mon', 'fm_dt', 'to_dt');
   		//axon_event.addListenerFormat('keypress','obj_keypress', document.form);		
   		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
   		//axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
   		//axon_event.addListener('click', 'dt_flg_click', 'dt_flg');
   		//axon_event.addListener('click', 'incl_cntr_click', 'incl_cntr');
   		
   		//ofc_flg_click();
  	}
	function keyPress() {
        var eventKey=window.event.keyCode ;
        if( eventKey == 13 ) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
	function doInit() {
		var formObj=document.form;
		ComResetAll();
		dt_flg_click();
		ofc_flg_click();
		incl_cntr_click();
		
		var sheetObj=sheetObjects[0];
		sheetObj.RemoveAll();
	}
	function incl_cntr_click() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var inclCntr=ComGetObjValue(formObj.incl_cntr);
		var hiddenFlg=true;
		if(inclCntr == 'Y')	
			hiddenFlg=false;
		with(sheetObj) {
			SetColHidden("bill_cntr",hiddenFlg);
			SetColHidden("inv_cntr",hiddenFlg);
			//ColHidden("inv_m_cntr")		= hiddenFlg;
			SetColHidden("inv_tot_cntr",hiddenFlg);
			SetColHidden("coll_cntr",hiddenFlg);
			//ColHidden("coll_m_cntr")	= hiddenFlg;
			SetColHidden("coll_tot_cntr",hiddenFlg);
		}
	}
	function dt_flg_click() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		with(formObj) {
			var dtFlg=ComGetObjValue(dt_flg);
			var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
			if(dtFlg == 'M') {
				ComEnableObject(to_mvmt_mon, true);
				ComEnableManyObjects(false, fm_dt, to_dt, btns_calendar);
				DmtComSetClassManyObjects('input1', to_mvmt_mon);
    	 		DmtComSetClassManyObjects('input2', fm_dt, to_dt);
				//ComSetObjValue(to_mvmt_mon, ComGetNowInfo("ym"));
    	 		ComSetObjValue(to_mvmt_mon, ofcCurrDate.substring(0, 7));
				ComClearManyObjects(fm_dt, to_dt);
			} else {
				ComEnableObject(to_mvmt_mon, false);
				ComEnableManyObjects(true, fm_dt, to_dt, btns_calendar);
				DmtComSetClassManyObjects('input1', fm_dt, to_dt);
    	 		DmtComSetClassManyObjects('input2', to_mvmt_mon);
				var fmDt=ComGetDateAdd(ofcCurrDate, "M", -1);
				var toDt=ofcCurrDate;
				ComSetObjValue(fm_dt, fmDt);
				ComSetObjValue(to_dt, toDt);
				ComClearManyObjects(to_mvmt_mon);
			}
		} // with-end
	}
	function ofc_flg_click() {
		var formObj=document.form;
		var ofcFlg=ComGetObjValue(formObj.ofc_flg);
		var comboObj=comboObjects[0];
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
			var headOffice=ComGetObjValue(formObj.head_office);
			if(usrRhqOfcCd == headOffice)
				usrRhqOfcCd="All";
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
	   		ComEnableObject(formObj.grp_flg, true);
		} else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
			ComEnableObject(formObj.chk_sub_ofc, true);
			ComEnableObject(formObj.grp_flg, false);
			formObj.grp_flg.className='input2';
		}
	}
    function obj_blur(){
    	var obj=ComGetEvent();
    	ComChkObjValid(obj);
	}
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
    	var obj=ComGetEvent();
    	ComClearSeparator(obj);
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }
	function obj_keypress() {
    	 switch(ComGetEvent("dataformat")){
         	/*
    	 	case "engup":
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	*/
         	default:
	            ComKeyOnlyNumber(ComGetEvent());
    	 }
     }
	function doInclSubOfc() {
		var formObj=document.form;
		var comboObj=comboObjects[0];
		if(formObj.chk_sub_ofc.checked) {	
			if( ComIsEmpty(comboObj.GetSelectCode()) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked=false;
				return;
			}
			formObj.ofc_cd.value=ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value=ComGetObjValue(comboObj);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
		} else {
			ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
		}
	}
   /**
      * Sheet the initial setting, the header definition
     * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
     * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
      */
	function initSheet(sheetObj,sheetNo) {
    	  var cnt=0;
    	  var sheetID=sheetObj.id;
    	  switch(sheetID) {
    	  	case "sheet1":
    	  		with(sheetObj){
    	  			
    	  			//	no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	  			var HeadTitle1="|Seq.|Office|Charge|Bound|Cur.|Billable|Billable|Invoiced|Invoiced|Invoiced|Invoiced|Invoiced|Collected|Collected|Collected|Collected|Collected|Collected";
    	  			var HeadTitle2="|Seq.|Office|Charge|Bound|Cur.|Auto|Auto| Auto | Auto |Manual|Total|Total|Auto|Auto|Manual|Other|Total|Total";
    	  			var HeadTitle3="|Seq.|Office|Charge|Bound|Cur.|CNTR|AMT|CNTR| AMT  | AMT |CNTR|AMT|CNTR|  AMT  | AMT |AMT|CNTR| AMT ";

    	  			SetConfig( { SearchMode:2, FrozenCol:6, MergeSheet:5, Page:20, DataRowMerge:1 } );

    	  			var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
    	  			var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"} ];
    	  			
    	  			InitHeaders(headers, info);    	  			

    	  			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
    	  			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	  			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"tariff",         KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd",         KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	  			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",        KeyField:0,   CalcLogic:"",   Format:"",           PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
    	  			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bill_cntr",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Status: F, C, I with To Date within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bill_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Status: F, C, I with To Date within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"inv_cntr",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Invoice Issued within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Invoice Issued within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_m_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Invoice Issued within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"inv_tot_cntr",   KeyField:0,   CalcLogic:"|inv_cntr|",Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Invoice Issued within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"inv_tot_amt",    KeyField:0,   CalcLogic:"|inv_amt|+|inv_m_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"Invoice Issued within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"coll_cntr",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"A/R interfaced within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"coll_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"A/R interfaced within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"coll_m_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"A/R interfaced within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"coll_oth_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"A/R interfaced within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"coll_tot_cntr",  KeyField:0,   CalcLogic:"|coll_cntr|",Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"A/R interfaced within the period"},
    	  			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"coll_tot_amt",   KeyField:0,   CalcLogic:"|coll_amt|+|coll_m_amt|+|coll_oth_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1,  ToolTipText:"A/R interfaced within the period"}];
					
    	  			InitColumns(cols);
     			
					ShowSubSum([
					            {StdCol:"ofc_cd", SumCols:"bill_cntr|bill_amt|inv_cntr|inv_amt|inv_m_amt|inv_tot_cntr|inv_tot_amt|coll_cntr|coll_amt|coll_m_amt|coll_oth_amt|coll_tot_cntr|coll_tot_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"ofc_cd=%s;tariff=;curr_cd=;seq=S.TTL"},
					            {StdCol:"tariff", SumCols:"bill_cntr|bill_amt|inv_cntr|inv_amt|inv_m_amt|inv_tot_cntr|inv_tot_amt|coll_cntr|coll_amt|coll_m_amt|coll_oth_amt|coll_tot_cntr|coll_tot_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"ofc_cd=%s;tariff=%s;curr_cd=;seq=S.TTL"}
					           ]);

    	  			SetEditable(0);
    	  			SetCountPosition(0);
    	      //no support[check again]CLT 					ToolTipOption="balloon:true;width:50;";
   	  				SetSheetHeight(440);
    	  		}
    	  		break;
    	  }
	}
   // Sheet processing-related processes
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:     
				if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
				formObj.f_cmd.value=SEARCH;

				ComOpenWait(true);
				var sXml = sheetObj.GetSearchData("EES_DMT_6003GS.do", FormQueryString(formObj));
	            sheetObj.LoadSearchData(sXml, {Sync:1});
	            ComOpenWait(false);
			break;
         }
     }
 	function initCombo(comboObj, comboNo) {
 		var formObj=document.form;
 	    switch(comboObj.options.id) {  
 	    	case "office": 
 	    		with (comboObj) { 
 					//MultiSelect = false;
 	    			SetUseAutoComplete(1);
 	    			SetColWidth(0, 80);
 	    			SetColAlign(0, "left");
 					SetDropHeight(160);
 					SetColBackColor(0,"#CCFFFD");
 					//MaxLength = 6;
 			    }
 	    	break;
 	    }
 	}
 	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
     	 sheetObj.ShowDebugMsg(false);
     	 sheetObj.SetWaitImageVisible(0);
     	 formObj.f_cmd.value=formCmd;
//parameter changed[check again]CLT      	 
     	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
     	 switch(formCmd) {
     	 	case COMMAND06:	// RHQ
     	 		with (comboObj) { 
 	    	 		RemoveAll();
 					SetMultiSelect(0);
 					/*SetColWidth(0, "45");*/
 					ValidChar(2);	
 					//MaxLength = 6;
     	 		}
     	 		var data=ComGetEtcData(sXml, "common_cd");
 				if (data != undefined && data != '') {
 					var comboItems=data.split("|");
 					comboObj.InsertItem(0, "All", "All");
 					for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
 		         	}
 				}
 				break;
     	 	case SEARCHLIST02: // Office
     	 		with (comboObj) { 
 	    	 		RemoveAll();
 					SetMultiSelect(1);
 					/*SetColWidth(0, "95");*/
 					ValidChar(2, 2); 
     	 		}
 				var data=ComGetEtcData(sXml, "OFC_CD");
 				if (data != undefined && data != '') {
 					var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
 					var idx=0;
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx=1;
 					}
 		    	    var comboItems=data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
	    	  		comboObj.SetSelectCode(usrOfcCd, false);
 				}
 	    	    break;
     	 	case COMMAND01:	// Incl. Sub Office
     	 		var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
	     	 	if (subOfcCds != undefined && subOfcCds != '') {
		 			var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
					if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds=usrOfcCd + ',' + subOfcCds;
					comboObj.SetSelectCode(subOfcCds, false);
		 		}
     	 		break;
     	 }
 	}
     /**
      * Screen input form validation process for handling
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
   				case IBSEARCH:
	   				var dtFlg=ComGetObjValue(dt_flg);
	   				if(dtFlg == 'M') {
	   					if(!ComIsDate(to_mvmt_mon, "ym")) {
	          				ComShowCodeMessage('COM12180');
	          				ComSetFocus(to_mvmt_mon);
	          				return false;
	          			}
	   					var toMvmtMon=ComGetUnMaskedValue(to_mvmt_mon, 'ym');
	   					var lastDay=ComGetLastDay(ComParseInt(toMvmtMon.substring(0, 4)), ComParseInt(toMvmtMon.substring(4)));
	   					var startDt=toMvmtMon + '01';
	   					var endDt=toMvmtMon + '' + lastDay;
	   					ComSetObjValue(start_dt, startDt);
	   					ComSetObjValue(end_dt, endDt);
	   				} else {
	   					if(!ComIsDate(fm_dt)) {
	          				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'From Date'));
	          				return false;
	          			}
	          			if(!ComIsDate(to_dt)) {
	          				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'To Date'));
	          				return false;
	          			}
	   					var startDt=ComGetUnMaskedValue(fm_dt, 'ymd');
	          			var endDt=ComGetUnMaskedValue(to_dt, 'ymd');
	          			if (ComChkPeriod(startDt, endDt) == 0) {
                        	ComShowCodeMessage("DMT01020");
                        	return false;
                        }
                        var limitDt=ComGetDateAdd(startDt, "M", 1);
                        if (ComChkPeriod(endDt, limitDt) == 0) {
                        	ComShowCodeMessage("DMT00162", "1 month");
                        	return false;
                        }
	   					ComSetObjValue(start_dt, startDt);
	   					ComSetObjValue(end_dt, endDt);
	   				}
	   				// DEM/DET Office
                    var ofcCd=comboObjects[0].GetSelectCode();
                    if(ComIsEmpty(ofcCd)) {
                    	ComShowCodeMessage('COM12113', "DEM/DET Office");
             			return false;
                    }
                    ComSetObjValue(ofc_cd, ofcCd);
	                break;
    	 	} // switch - end
         } // with - end
         return true;
	}
     
  	function office_OnCheckClick(comboObj, index, code) {
 		var formObj=document.form;
		if (formObj.chk_sub_ofc.checked) {
			if (comboObj.GetItemCheck(index)) {
				comboObj.SetItemCheck(index, 0, false);
			}
			else {
				comboObj.SetItemCheck(index, 1, false);
			}
			ComShowCodeMessage('DMT00107');
		}	
 	}

 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
//no support[check again]CLT 	
 	function sheet1_OnLoadFinish() {
  		var formObj=document.form
  		sheetObjects[0].SetWaitImageVisible(0);
        doInit();
        sheetObjects[0].SetWaitImageVisible(1);
  	}

 	function sheet1_OnSearchEnd(sheetObj, Code, Msg) {
 		
 		sheetObj.SetSumText(0, "seq","TTL");
 	}
 	
	/* Developer's task end */
