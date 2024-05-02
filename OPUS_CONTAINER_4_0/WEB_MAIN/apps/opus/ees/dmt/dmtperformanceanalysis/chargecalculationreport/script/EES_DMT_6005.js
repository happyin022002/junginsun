/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_6005.js
*@FileTitle  : Summary Report by Customer 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

   	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0; 
	var DEF_SHEET_HEIGHT = 379;
	var MAX_SHEET_HEIGHT = DEF_SHEET_HEIGHT + 145;
	
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	
	// Event handler processing by button name
	function processButtonClick(){
    	 /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
    	 var sheetObj=sheetObjects[0];
    	 /*******************************************************/
    	 var formObj=document.form;
    	 try {
     		var srcObj=ComGetEvent();
     		var srcName=srcObj.getAttribute("name");
     		// Click the icon to pop-up window when the link is disabled, just return
     		if(!ComIsBtnEnable(srcName)) return;
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

				case "btn_Minimize":
					var schCondDiv=document.getElementById("sch_cond_div");
 					if (schCondDiv.style.display == 'block') {	// Showing the status of the selection criteria
 						schCondDiv.style.display='none';
 						sheetObj.SetSheetHeight(MAX_SHEET_HEIGHT);
 					} 
 					else {
 						schCondDiv.style.display='block';
 						sheetObj.SetSheetHeight(DEF_SHEET_HEIGHT);
 					}
				break;
				
				case "btn_DownExcel":
					if (sheetObj.RowCount() < 1) {//no data
						ComShowCodeMessage("COM132501");
					} 
					else {
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					}
				break;
				
				case "btn_Detail":
					doProcessPopup(srcName);
				break;
				
				case "btns_multisearch":
					var returntitle='';
					if(ComGetObjValue(formObj.sch_flg) == 'SC')
						returntitle='S/C No.';
					else
						returntitle='RFA No.';
					var param="?returnval=sc_rfa_no" + "&returntitle=" + returntitle;
					ComOpenPopup('EES_DMT_MULTI.do'+param, 440, 415, 'getDmt_Multi', '0,1', true);
				break;
				
				case "btns_customer":
					ComOpenPopup('COM_ENS_041.do', 810, 445, "getCustCd", "0,1", true);
				break;
				
				case "btns_ctrt_ofc":
					ComOpenPopup('COM_ENS_071.do', 770, 476, "getCtrtOfcCd", "0,1", true);
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
     
    //Page generated in the comboObjects IBCombo Object Properties in an array
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
		  //html control event initializing
		  initControl();
		  
		  sheet1_OnLoadFinish();
	}
	
	// Event-handling function declarations
  	function initControl() {
  		axon_event.addListenerForm('blur',	'obj_blur',	document.form); //- focus out
//  		axon_event.addListenerFormat('focus', 'obj_focus', document.form);
//   		axon_event.addListenerFormat('keypress','obj_keypress', document.form);			//- input with keyboard
//   		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
   		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');	// DEM/DET Office in case of radio button clicked
   		axon_event.addListener('click', 'incl_dc_click', 'incl_dc');	// in case of 'Incl. CNTR Column' CheckBox clicked 
   		axon_event.addListener('click', 'sch_flg_click', 'sch_flg');
   		axon_event.addListener('change','sttl_lvl_change', 'sttl_lvl');
  	}
  	
  	var CHK_LOCK_FLG=false;
	//focus out
    function obj_blur(){
        //Input Validation check + input mask delimiter
    	var obj=event.srcElement;
        var objName=obj.name;
        if(objName == 'fm_dt' || objName == 'to_dt') {
        	ComChkObjValid(obj);
        } else if(objName == 'cust_cd') {
        	var formObj=document.form;
        	var custCd=ComGetObjValue(obj);
        	var custLen=ComGetLenByByte(custCd);
            if(custLen == 0) {
	            ComSetObjValue(formObj.cust_nm, "");
            	return;
            }
            if(custLen > 2) {
    			//If the first two digits alpha CUSTOMER views
    			if(ComIsAlphabet(custCd.substring(0,2))) {
    				ComSetObjValue(formObj.s_cust_gubun, "2");
    	            ComSetObjValue(formObj.s_cust_cd, custCd);
    	            doActionIBCombo(sheetObjects[0], formObj, null, SEARCH20);
    			//VENDOR or query
    			} else {
    				ComShowCodeMessage("DMT00165", "Customer");
    				ComSetObjValue(formObj.s_cust_gubun, "");
    	            ComSetObjValue(formObj.cust_cd, "");
    	            ComSetObjValue(formObj.cust_nm, "");
    	            ComSetFocus(formObj.cust_cd);
    				return;
    			}
    		} else {
    			ComShowCodeMessage("DMT00165", "Customer");
    			ComSetObjValue(formObj.s_cust_gubun, "");
                ComSetObjValue(formObj.cust_cd, "");
                ComSetObjValue(formObj.cust_nm, "");
                ComSetFocus(formObj.cust_cd);
    			return;
    		}
        } else if(objName == 'cvr_cd' || objName == 'por_cd' || objName == 'pol_cd' || objName == 'pod_cd' || objName == 'del_cd') {
        	if(obj.value.length > 0) {
        		CHK_LOCK_FLG=false;
	        	if(obj.value.length != 2 && obj.value.length != 5) {
	        		CHK_LOCK_FLG=true;
	   	 			ComShowCodeMessage('DMT05015');
	   	 			ComClearObject(obj);
	   	 			ComSetFocus(obj);
	        	} else {
	        		checkLocCntCd(obj);
	        	}
        	}
    	}
	}
    
    function checkLocCntCd(srcObj) {
    	var sheetObj=sheetObjects[0];
    	var formObj=document.form;
		var cd=ComTrim(ComGetObjValue(srcObj));
		if(cd.length == 2) {
			// Country Code Validation check
			ComSetObjValue(formObj.cnt_cd, cd);
			doActionIBCombo(sheetObj, formObj, null, COMMAND11, srcObj);
		} else {
			// Location Code Validation check
			ComSetObjValue(formObj.loc_cd, cd);
			doActionIBCombo(sheetObj, formObj, null, COMMAND07, srcObj);
		}
    }
    
  	function sttl_lvl_change() {
  		var sheetObj=sheetObjects[0];
  		sheet1_OnSearchEnd(sheetObj, '', '');
  	}
  	
	// When S/C No, RFA No, Contract Office, Customer Code  selecting your search criteria (check the radio button) event forwarding
  	function sch_flg_click() {
  		doEnableCondObj(event.srcElement.value);
  	}
  	
  	// When S/C No, RFA No, Contract Office, Customer Code selecting your search criteria (check the radio button) event processing
  	function doEnableCondObj(condType) {
  		var formObj=document.form;
  		with (formObj) {
  			incl_dc.checked=true;
			//ComEnableObject(incl_dc, true);
  			switch(condType) {
  				case "SC":
  				case "RFA":
  					ComEnableManyObjects(true, sc_rfa_no, btns_multisearch);
  					ComEnableManyObjects(false, ctrt_ofc, btns_ctrt_ofc, cust_cd, btns_customer);		
  					ComClearManyObjects(sc_rfa_no, ctrt_ofc, cust_cd, cust_nm);
  					DmtComSetClassManyObjects('input1', sc_rfa_no); 			//Display the required item
  					ComSetFocus(sc_rfa_no);
  					if(condType == 'SC') {
  						incl_dc.checked=false;
  					}
  					break;			
  				case "CTRT":
  					ComEnableManyObjects(true, ctrt_ofc, btns_ctrt_ofc);
  					ComEnableManyObjects(false, sc_rfa_no, btns_multisearch, cust_cd, btns_customer);		
  					ComClearManyObjects(sc_rfa_no, cust_cd, cust_nm);
  					DmtComSetClassManyObjects('input1', ctrt_ofc); 			//Display the required item
	    	 		DmtComSetClassManyObjects('input2', sc_rfa_no, cust_cd);
  					ComSetObjValue(ctrt_ofc, ComGetObjValue(usr_ofc_cd));
  					ComSetFocus(ctrt_ofc);
  					break;
  				case "CUST":
  					ComEnableManyObjects(true, cust_cd, btns_customer);
  					ComEnableManyObjects(false, sc_rfa_no, btns_multisearch, ctrt_ofc, btns_ctrt_ofc);		
  					ComClearManyObjects(sc_rfa_no, ctrt_ofc, cust_cd, cust_nm);
  					DmtComSetClassManyObjects('input1', cust_cd); 			//Display the required item
	    	 		DmtComSetClassManyObjects('input2', sc_rfa_no, ctrt_ofc);
  					ComSetFocus(cust_cd);
  					break;
  			} // switch - end
  		} // with end
  		incl_dc_click();
  	}
  	
	// Initial setup screen
	function doInit() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		ComResetAll();
		// To MVMT Date initialization of search period 
		var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
		var fmDt=ComGetDateAdd(ofcCurrDate, "M", -1);
		var toDt=ofcCurrDate;
		ComSetObjValue(formObj.fm_dt, fmDt);
		ComSetObjValue(formObj.to_dt, toDt);
		// DEM/DET Office initialization of search condition (Default: RHQ)
		ofc_flg_click();
		// running logic in case of 'Incl. CNTR Column' CheckBox checked
		incl_dc_click();
		// Office Contract Office Default value is set to sign.
		doEnableCondObj('SC');
		DmtComEnableManyBtns(false, "btn_Detail", "btn_DownExcel");
	}
	
	//'Incl. D / C Column 'CheckBox events that occur during check processing
	function incl_dc_click() {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var inclCntr=ComGetObjValue(formObj.incl_dc);
		var hiddenFlg=true;
		if(inclCntr == 'Y')	// CNTR Col show
			hiddenFlg=false;
		sheetObj.SetColHidden("dc_cntr",hiddenFlg);
		sheetObj.SetColHidden("dc_amt",hiddenFlg);
	}
	
	// DEM/DET Office Radio Button click event processing
	function ofc_flg_click() {
		var formObj=document.form;
		var ofcFlg=ComGetObjValue(formObj.ofc_flg);
		var comboObj=comboObjects[1];
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			// When selecting RHQ RHQ Office Code in the Default Login.(SELHO는 All)
			var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
			var headOffice=ComGetObjValue(formObj.head_office);
	   		//2011.02.15 Hard-coding the removal
			if(usrRhqOfcCd == headOffice) 
	   			usrRhqOfcCd="All";
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
		} 
		else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST01);
			ComEnableObject(formObj.chk_sub_ofc, true);
		}
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
    
	//JavaScript event handling tasks OnKeyPress
	function obj_keypress() {
    	 switch(event.srcElement.dataformat){
    	 	case "engup":
		    	// only upper case
         		ComKeyOnlyAlphabet('upper');
		        break;
    	 	case "engnum":
		    	// upper case + numbers
         		ComKeyOnlyAlphabet('uppernum');
		        break;
    	 	case "engnum2":
		    	// upper case + numbers + ',' 
		    	DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
	
	/*
	 * Multiple selected DEM / DET Office of the Sub-mucin (Sub Office) lookup 
	 */
	function doInclSubOfc() {
		var formObj=document.form;
		var comboObj=comboObjects[1];
		if (formObj.chk_sub_ofc.checked) {	// Sub Office including
			if( ComIsEmpty(comboObj.GetSelectCode()) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked=false;
				return;
			}
			formObj.ofc_cd.value=ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value=ComGetObjValue(comboObj);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
		} 
		else {
			comboObj.SetSelectIndex(-1);
			comboObj.SetSelectCode(formObj.tmp_ofc_cd.value, false);
		}
	}
	
	// Office IBMultiCombo initializing
	function initComboValue_tariff_type() {
		ComSetObjValue(comboObjects[0], "All,DMIF,DTIC,DMOF,DTOC,CTIC,CTOC");
	}
	
	// Tariff Type IBMultiCombo click event processing
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
	}    

	function isTariffAllCheck(comboObj) {
		var allTariffCnt = comboObj.GetItemCount();
		var selTariffCnt = 0;
		for (var i = 1; i < allTariffCnt; i++) {	// All 항목은 제외
			if (comboObj.GetItemCheck(i)) selTariffCnt++;
		}
		
		return selTariffCnt == allTariffCnt-1;		// 선택항목에서 All 항목은 제외
	}
	
	// 'Incl. Sub Office 'check box is checked, select the Office Multi-combo should not be permitted to.
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

	// multi combo KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	
	/*
  	 * Each common pop-up function calls 
  	 */
  	function doProcessPopup(srcName) {
  		var sheetObj=sheetObjects[0];
  		var formObj=document.form;
  		var sUrl='';
  		var sWidth='';
  		var sHeight='';
  		sUrl='EES_DMT_6006.do';
  		sWidth='1280';
  		sHeight='700';
  		var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
  	}
  	
  	/*
      * Multi-input pop-up page is closed, then the function is invoked Opener
      * - Set in the appropriate fields, allows multi-input.
      */
	function getDmt_Multi(rArray, return_val) {
     	var targObj=eval("document.form." + return_val);
     	var retStr=rArray.toString().toUpperCase();
     	ComSetObjValue(targObj, retStr);
	}
	
	/*
  	 * Customer Code Customer common values ​​selected in the pop-up settings in the appropriate fields
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value=aryPopupData[0][3];
    	document.form.cust_nm.value=aryPopupData[0][4];
    }
    
    /*
  	 * Customer Code Customer common values ​​selected in the pop-up settings in the appropriate fields
  	 */
    function getCtrtOfcCd(aryPopupData) {
    	document.form.ctrt_ofc.value=aryPopupData[0][3];
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
            	 	var HeadTitle1=" |Seq.|S/C No.|RFA No.|Customer|Customer|CTRT\nOFC|Tariff|DMT\nOFC|CVR|POR|POL|POD|DEL|TTL\nCNTR|AVG\nSTY|Incurred%|Exception%|Over\nCNTR|AVG\nOver|Cur.|Incurred|Incurred|CMDT EXPT|CMDT EXPT|Exception|Exception|Discount|Discount|Billable|Billable|Invoiced|Invoiced|Collected|Collected|US Rail Storage|US Rail Storage";
            	 	var HeadTitle2=" |Seq.|S/C No.|RFA No.|Code|Name|CTRT\nOFC|Tariff|DMT\nOFC|CVR|POR|POL|POD|DEL|TTL\nCNTR|AVG\nSTY|Incurred%|Exception%|Over\nCNTR|AVG\nOver|Cur.|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT";

            	 	SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:7, Page:20, DataRowMerge:0 } );

            	 	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	 	var headers = [ { Text:HeadTitle1, Align:"Center"},
                           { Text:HeadTitle2, Align:"Center"} ];
            	 	InitHeaders(headers, info);

            	 	var cols = [ {Type:"Status", Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"sc_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"rfa_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ctrt_ofc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"dmdt_ofc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cvr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl_cntr",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"avg_sty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"incur_rto",     KeyField:0,   CalcLogic:"ComRound(|incur_cntr|/|ttl_cntr|,4)*100",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"expt_rto",      KeyField:0,   CalcLogic:"ComRound(|expt_cntr|/|ttl_cntr|,4)*100",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"over_cntr",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"avg_over",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"incur_cntr",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"incur_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_cntr",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"cmdt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"expt_cntr",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"expt_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"dc_cntr",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dc_amt",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bill_cntr",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"bill_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"inv_cntr",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"inv_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"coll_cntr",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"coll_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"us_rail_cntr",  KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"us_rail_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_sty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"AutoSum",   Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_over",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"sc_rfa_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                
            		var formObj=document.form;
            		var schFlg=ComGetObjValue(formObj.sch_flg);
            		var sttlLvl=ComGetObjValue(formObj.sttl_lvl);
            		// Step 1 to calculate the subtotal column names based on
            		var stdCol;
           			ColumnSort("seq", "ASC");
           			if(schFlg == 'SC') {
           				stdCol="sc_no";
           				SetColHidden("sc_no",0);
           				SetColHidden("rfa_no",1);
           			} 
           			else if(schFlg == 'RFA') {
            			stdCol="rfa_no";
            			SetColHidden("sc_no",1);
            			SetColHidden("rfa_no",0);
            		} 
           			else {
            			stdCol="sc_rfa_no";
            			SetColHidden("sc_no",0);
            			SetColHidden("rfa_no",0);
            		}
            		HideSubSum(stdCol);
            		HideSubSum("trf_cd");
            		HideSubSum("dmdt_ofc");
            		HideSubSum("cvr_cd");
            		sttlLvl=ComParseInt(sttlLvl);

            	 	InitColumns(cols);
            	 	
            		// Subtotal column by a step  -  S/C No. or RFA No. 
        			if (sttlLvl == 4) {
            			ShowSubSum([
            			            {StdCol:stdCol,     SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=;cust_nm=;ctrt_ofc=;trf_cd=;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
            			           ,{StdCol:"trf_cd",   SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
            			           ,{StdCol:"dmdt_ofc", SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=%s;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
            			           ,{StdCol:"cvr_cd",   SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=%s;cvr_cd=%s;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
           			            	]);
        			}
        			else if (sttlLvl == 3) {
            			ShowSubSum([
            			            {StdCol:stdCol,     SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=;cust_nm=;ctrt_ofc=;trf_cd=;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
            			           ,{StdCol:"trf_cd",   SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
            			           ,{StdCol:"dmdt_ofc", SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=%s;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
           			            	]);            				
        			}
        			else if (sttlLvl == 2) {
            			ShowSubSum([
            			            {StdCol:stdCol,     SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=;cust_nm=;ctrt_ofc=;trf_cd=;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
            			           ,{StdCol:"trf_cd",   SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=%s;cust_nm=%s;ctrt_ofc=%s;trf_cd=%s;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
           			            	]);            				
        			}
        			else {
            			ShowSubSum([
            			            {StdCol:stdCol,    SumCols:"ttl_sty|ttl_over|ttl_cntr|avg_sty|incur_rto|expt_rto|over_cntr|avg_over|incur_cntr|incur_amt|cmdt_cntr|cmdt_amt|expt_cntr|expt_amt|dc_cntr|dc_amt|bill_cntr|bill_amt|inv_cntr|inv_amt|coll_cntr|coll_amt", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;seq=S.TTL;sc_no=%s;rfa_no=%s;cust_cd=;cust_nm=;ctrt_ofc=;trf_cd=;dmdt_ofc=;cvr_cd=;por_cd=;pol_cd=;pod_cd=;del_cd=;curr_cd=%s;"+"avg_sty=ComRound(|ttl_sty|/|ttl_cntr|, 0);avg_over=ComRound(|ttl_over|/|over_cntr|,0);"+"incur_rto=ComRound(|incur_cntr|/|ttl_cntr|,4)*100;expt_rto=ComRound(|expt_cntr|/|ttl_cntr|,4)*100"}
           			            	]);            				

        			}

            	 	SetEditable(1);
            	 	SetCountPosition(2);
            	 	SetEllipsis(1);
                    SetSheetHeight(DEF_SHEET_HEIGHT);
             	}
                break;
        }
    }
     
	/**
  	 * Combo basic setting 
  	 * param : comboObj ==> combo obejct, comboNo ==> Combo object ID of the tag attached to the serial number
  	 * If the case dasuil combo combo by adding the number of seats will initialize the module configuration
  	 */ 
  	function initCombo(comboObj, comboNo) {
  		var formObj=document.form;
  	    switch(comboObj.options.id) {  
  	    	case "office":
  	    		with (comboObj) {
  	    			SetUseAutoComplete(1);
  	    			SetColAlign(0, "left");
  					SetDropHeight(160);
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
  	    }
  	}
  	
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //retrieving
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
				sheetObj.RemoveAll();	
				
				sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
			    var sXml = sheetObj.GetSearchData("EES_DMT_6005GS.do", FormQueryString(formObj));
			    sheetObj.LoadSearchData(sXml, {Sync:1});	
	       		ComOpenWait(false);
			break;
         }
	}
	
	// IBCombo data retrieval and setting
 	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd, srcObj) {
     	 sheetObj.ShowDebugMsg(false);
     	 sheetObj.SetWaitImageVisible(0);
     	 formObj.f_cmd.value=formCmd;
     	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
     	 switch(formCmd) {
	     	case SEARCHLIST:	// tariff type
 				var data = ComGetEtcData(sXml, "common_tariff_cd");
 				if (data != undefined && data != '') {
 					var comboItems = data.split("|");
 			  		for (var i=0; i < comboItems.length; i++) {
 			  	   		var comboItem = comboItems[i].split("=");
 			  			comboObj.InsertItem(i+1, comboItem[0] + "|" + comboItem[1], comboItem[0]);
 			  	   	}
 			  		comboObj.InsertItem(0, "All|All", "All");
 				}
			break;
			
     	 	case COMMAND06:	// RHQ
     	 		with (comboObj) { 
 	    	 		RemoveAll();
 					SetMultiSelect(0);
 					SetColWidth(0, "95");
 					ValidChar(2);	// upper case
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
			
     	 	case SEARCHLIST01: // Office
     	 		with (comboObj) { 
 	    	 		RemoveAll();
 					SetMultiSelect(1);
 					SetColWidth(0, "95");
 					ValidChar(2, 2); // only upper case, special letters
     	 		}
 				var data=ComGetEtcData(sXml, "OFC_CD");
 				if (data != undefined && data != '') {
 					var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
 					var idx=0;
 					// Login Office is not in a multi-combo list, add at the top of the list
 					if(data.indexOf(usrOfcCd) == -1) {
 						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
 						idx=1;
 					}
 		    	    var comboItems=data.split("|");
 		    	    for (var i=0 ; i < comboItems.length ; i++) {
 		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
 		         	}
 	    	  		// Log in to the User Office to Default Settings
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
   	 		
     		case COMMAND07:	// Location Code Check
	 	 		var locCd=ComGetEtcData(sXml, "LOC_CD");
	 	 		if(locCd == '') {
	 	 			ComShowCodeMessage('DMT00110', "Location");
	 	 			ComClearObject(srcObj);
	 	 			CHK_LOCK_FLG=true;
	 	 		}
 	 		break;
 	 		
     		case COMMAND11:	// Country Code Check
	 	 		var cntCd=ComGetEtcData(sXml, "CNT_CD");
	 	 		if(cntCd == '') {
	 	 			ComShowCodeMessage('DMT00110', "Country");
	 	 			ComClearObject(srcObj);
	 	 			CHK_LOCK_FLG=true;
	 	 		}
 	 		break;
 	 		
     		case SEARCH20: // Customer Name retrieving	
	     		var custCd=ComGetEtcData(sXml, "PAYER_CODE");
	            var custNm=ComGetEtcData(sXml, "PAYER_NM");
	            if(custNm == null || custNm == "" || custNm == undefined) {
	            	ComSetObjValue(form.s_cust_gubun, "");
	                ComSetObjValue(form.cust_cd, "");
	                ComSetObjValue(form.cust_nm, "");
	            	ComShowCodeMessage("DMT00165", "Customer");
	                ComSetFocus(formObj.cust_cd);
	            } else {
	            	ComSetObjValue(form.cust_cd, custCd);
	                ComSetObjValue(form.cust_nm, custNm);
	            }
   			break;
     	 }
     	sheetObj.SetWaitImageVisible(1);
 	}
 	
	/**
      * Screen input form validation process for handling
      */
	function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
        	 	case IBSEARCH:
        	 		if(!ComIsDate(fm_dt)) {
         				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'To MVMT Date From Date'));
         				return false;
         			}
         			if(!ComIsDate(to_dt)) {
         				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'To MVMT Date To Date'));
         				return false;
         			}
  					var fmDt=ComGetObjValue(fm_dt);
         			var toDt=ComGetObjValue(to_dt);
         			/*
         			ComChkPeriod(fromDate, toDate)
         			0 : fromDate > toDate
         			1 : fromDate < toDate
         			2 : fromDate=toDate
         			*/
         			// Check period
                    if (ComChkPeriod(fmDt, toDt) == 0) {
                    	ComShowCodeMessage("DMT01020");
                    	return false;
                    }
                    var limitDt=ComGetDateAdd(fmDt, "M", 1);
                    if (ComChkPeriod(toDt, limitDt) == 0) {
                    	ComShowCodeMessage("DMT00162", "1 month");
                    	return false;
                    }
                    // Tariff Type
	                var trfCd=comboObjects[0].GetSelectCode();
	                if(ComIsEmpty(trfCd)) {
	                	ComShowCodeMessage('COM12113', "Tariff Type");
	         			return false;
	                }
	                // If the entire selection, 'All' to remove a value is sent.(DBDAO Requires the internal logic)
	                if(trfCd.indexOf('All') != -1)
	                	trfCd=ComReplaceStr(trfCd, "All,", "");
	                ComSetObjValue(dmdt_trf_cd, trfCd);
	                // ******** Code retrieving Option input check  ******* START
	                //  S/C No., RFA No., Contract Office, Customer 
	                var schFlg=ComGetObjValue(sch_flg);
	                // S/C No. or RFA No.
	                if(schFlg == 'SC' || schFlg == 'RFA') {
	                	var scRfaNo=ComGetObjValue(sc_rfa_no);
		                if(ComIsEmpty(scRfaNo)) {
		                	var fldNm=(schFlg == 'SC') ? 'S/C No' : 'RFA No';
		                	ComShowCodeMessage('DMT05014', fldNm);
		         			return false;
		                }
	                }
	                // Contract Office
	                if(schFlg == 'CTRT') {
	                	var ctrtOfc=ComGetObjValue(ctrt_ofc);
		                if(ComIsEmpty(ctrtOfc)) {
		                	ComShowCodeMessage('DMT05014', 'Contract Office');
		         			return false;
		                }
	                }
	                // Customer Code
	                if(schFlg == 'CUST') {
	                	var custCd=ComGetObjValue(cust_cd);
		                if(ComIsEmpty(custCd)) {
		                	ComShowCodeMessage('DMT05014', 'Customer Code');
		         			return false;
		                }
	                }
	                // ********* Code input check  *********** END
	                // DEM/DET Office
	                var ofcCd=comboObjects[1].GetSelectCode();
	                if(ComIsEmpty(ofcCd)) {
	                	ComShowCodeMessage('DMT05014', "DEM/DET Office");
	         			return false;
	                }
	                ComSetObjValue(ofc_cd, ofcCd);
	                // Coverage Location input check
	                if(!ComIsEmpty(cvr_cd)) {
	                	var len=ComGetLenByByte(cvr_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(cvr_cd);
	                		return false;
	                	}
	                }
	                // ***** BKG Location input check
	                if(!ComIsEmpty(por_cd)) {
	                	var len=ComGetLenByByte(por_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(por_cd);
	                		return false;
	                	}
	                }
	                if(!ComIsEmpty(pol_cd)) {
	                	var len=ComGetLenByByte(pol_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(pol_cd);
	                		return false;
	                	}
	                }
	                if(!ComIsEmpty(pod_cd)) {
	                	var len=ComGetLenByByte(pod_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(pod_cd);
	                		return false;
	                	}
	                }
	                if(!ComIsEmpty(del_cd)) {
	                	var len=ComGetLenByByte(del_cd);
	                	if(len != 2 && len != 5) {
	                		ComShowCodeMessage('DMT05015');
	                		ComSetFocus(del_cd);
	                		return false;
	                	}
	                }
	                //************************************
	                //'To MVMT Date' hidden variable final value of the search condition is set.
	                ComSetObjValue(start_dt, ComGetUnMaskedValue(fm_dt, "ymd"));
	                ComSetObjValue(end_dt, ComGetUnMaskedValue(to_dt, "ymd"));
        	 		break;
        	 } // switch - end
         } // with - end
         return true;
	}
	
	// IBSheet using Object tag on the page creates an instance of the Event will occur when you complete.
	function sheet1_OnLoadFinish() {
  		var formObj=document.form;
  		var sheetObj=sheetObjects[0];
  		sheetObj.SetColHidden("ttl_sty",1);
  		sheetObj.SetColHidden("ttl_over",1);
  		// Tariff Type MultiCombo List retrieving
		doActionIBCombo(sheetObj, formObj, comboObjects[0], SEARCHLIST);
  		//OPEN view calling
        doInit(); 
	}
	
	//speech bubble
    function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){ 
    	with(sheetObj) {
    		//Get the value from the column and row position of the mouse
  			Row = MouseRow();
  			Col = MouseCol();
    		var mttText='';
    		//ComDebug(Row);
    		if(Row == 0 || Row == 1) {
    			var colSaveNm=ColSaveName(MouseCol());
    			switch(colSaveNm) {
    				case "cvr_cd":
						mttText='Coverage';
					break;

    				case "ttl_cntr":
						mttText='Total General Charge with Status F, C, I, N';
					break;
    				
    				case "avg_sty":
						mttText='Average Statying Days of Total CNTR';
					break;
    				
    				case 'over_cntr':
						mttText='Total General Charge over F/T with Status F,C,I';
						break;

    				case 'avg_over':
						mttText='Average Over Days of Total CNTR over F/T';
					break;
    				
    				case "incur_cntr":
    				case "incur_amt":
						mttText='DEM/DET Incurrence per Basic Tariff';
					break;		
    				
    				case "cmdt_cntr":
    				case "cmdt_amt":
						mttText='Exception per Commodity Exception Tariff';
					break;				
    				
    				case "expt_cntr":
    				case "expt_amt":
						mttText='Exception per S/C Exception Tariff/Before Booking';
					break;
    				
    				case "dc_cntr":
    				case "dc_amt":
						mttText='Discount per After Booking';
					break;				
    				
    				case "bill_cntr":
    				case "bill_amt":
						mttText='Billable AMT=Incurred - CMDT EXPT - Exception - Discount AMT';
					break;
    			}
    		} 
    		else {
    			mttText='';
    		}
    		SetToolTipText(Row, Col, mttText);
    	}
	}
    
	function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg){
		if(sheetObj.SearchRows()== 0) {
			DmtComEnableManyBtns(false, "btn_Detail", "btn_DownExcel");
			return;
		}
		DmtComEnableManyBtns(true, "btn_Detail", "btn_DownExcel");
		// Step 1 to calculate the subtotal column names based on
		var stdCol;
		with(sheetObj) {
   			SetSumText(0, "seq", "TTL");
    		
   			var avgStySum='0';
    		var avgOverSum='0';
    		var totIncurRto='0';
    		var totExptRto='0';

    		if(GetSumValue(0, "ttl_cntr") != '0') {
    			avgStySum=ComRound(GetSumValue(0, "ttl_sty") / GetSumValue(0, "ttl_cntr"), 0);
    			totIncurRto=ComRound(GetSumValue(0, "incur_cntr") / GetSumValue(0, "ttl_cntr"), 4)*100;
    			totExptRto=ComRound(GetSumValue(0, "expt_cntr") / GetSumValue(0, "ttl_cntr"), 4)*100;
    		}
    		
    		if(GetSumValue(0, "over_cntr") != '0')
    			avgOverSum=ComRound(GetSumValue(0, "ttl_over") / GetSumValue(0, "over_cntr"), 0);
    		
    		SetSumValue(0, "avg_sty",avgStySum);
    		SetSumValue(0, "avg_over",avgOverSum);
    		SetSumValue(0, "incur_rto",totIncurRto);
    		SetSumValue(0, "expt_rto",totExptRto);
		} // with - end
	}	
	/* Developer's task end */
