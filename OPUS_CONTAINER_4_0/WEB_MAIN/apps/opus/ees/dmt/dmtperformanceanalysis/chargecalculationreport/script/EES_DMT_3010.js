/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3010.js
*@FileTitle  : Deleted Charge Report by Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================**/

/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    
	 /* Developer's task	*/

	 // Common global variable

	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 
	 var comboObjects=new Array();
	 var comboCnt=0;
	 
	 var IBDELTRSN=99;
	 
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
 	// Event handler processing by button name */
	function processButtonClick(){
          /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
          var sheetObj=sheetObjects[0];
          /*******************************************************/
          var formObj=document.form;
          try {
     		var srcName=ComGetEvent("name");
     		switch(srcName) {
	     		case "btns_calendar": //Calendar button
					var cal=new ComCalendarFromTo();
                    cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
					break;
				case "btn_New":
					doInit();
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
					break;
				case "btn_Minimize":
 					var schCondDiv=document.getElementById("sch_cond_div");
 					if(schCondDiv.style.display == 'block') {
 						schCondDiv.style.display='none';
 						sheetObj.SetSheetHeight(505);
 					} else {
 						schCondDiv.style.display='block';
 						sheetObj.SetSheetHeight(410);
 					}
 					break;
				case "btn_Detail":
					doProcessPopup(srcName);
					break;
				case "btn_DownExcel":
					if(sheetObj.RowCount() < 1){//no data						
						ComShowCodeMessage("COM132501");
					}else{
						sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
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
         // IBMultiCombo initialization 
         for(var k=0;k<comboObjects.length;k++){
        	 initCombo(comboObjects[k],k+1);
         }
         sheet1_OnLoadFinish();
         // html controls the initialization event
         initControl();
	}
	
	// IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
	
	//no support[check again]CLT 	
	function sheet1_OnLoadFinish() {
		sheetObjects[0].SetWaitImageVisible(0);
		var formObj=document.form;
  		var sheetObj=sheetObjects[0];
  		// Screen initialization
        doInit();
        //Delete Reason Type List retrieving
        doActionIBSheet(sheetObj, formObj, IBDELTRSN);
        sheetObjects[0].SetWaitImageVisible(1);
	}  
	// Initial setup screen
	function doInit() {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		
		// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
		sheetObj.RemoveAll();
		
		sheetObj.CheckAll("chk",0);
		ComResetAll();
		// Inquiry Period (Period) set
		var ofcCurrDate=DmtComOfficeCurrDate(sheetObj, formObj);
		var fmDt=ComGetDateAdd(ofcCurrDate, "M", -1);
		var toDt=ComGetMaskedValue(ofcCurrDate, "ymd");
		ComSetObjValue(formObj.fm_dt, fmDt);
		ComSetObjValue(formObj.to_dt, toDt);
		// DEM/DET Office - RHQ list retrieving
		ofc_flg_click();
	}
	// Event-handling function declarations
	function initControl() {
		//axon_event.addListener('blur',	'obj_blur',	'fm_dt', 'to_dt'); //- focus out
 		//axon_event.addListener('focus',	'obj_focus', 'fm_dt', 'to_dt'); //- focus in
 		//axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- input with keyboard
 		//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
 		//axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');
	}
	// DEM/DET Office Radio Button Click event-handling
	function ofc_flg_click() {
		var formObj=document.form;
		var ofcFlg=ComGetObjValue(formObj.ofc_flg);
		var comboObj=comboObjects[0];
		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND06);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			// When selecting the Default login area RHQ Office Code.(SELHO는 All)
			var usrRhqOfcCd=ComGetObjValue(formObj.usr_rhq_ofc_cd);
			var headOffice=ComGetObjValue(formObj.head_office);
			//2011.02.15 Hard-coding the removal
	   		if(usrRhqOfcCd == headOffice)
			//if(usrRhqOfcCd == 'SELHO')
	   			usrRhqOfcCd="All";
	   		else
	   			comboObj.SetEnable(0);
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
	   		ComEnableObject(formObj.grp_flg, true);
		} else {
			// Office
			comboObj.SetEnable(1);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, SEARCHLIST02);
			ComEnableObject(formObj.chk_sub_ofc, true);
			ComEnableObject(formObj.grp_flg, false);
			formObj.grp_flg.className='input2';
		}
	}
	// Office IBMultiCombo Set the initial value
   	function initComboValue_office() {
   		var usrRhqOfcCd=ComGetObjValue(document.form.usr_rhq_ofc_cd);
   		var headOffice=ComGetObjValue(document.form.head_office);
   		//2011.02.15 Hard-coding the removal
   		if(usrRhqOfcCd == headOffice) usrRhqOfcCd="All";
   		//if(usrRhqOfcCd == 'SELHO')  usrRhqOfcCd = "All";
   		comboObjects[0].SetSelectCode(usrRhqOfcCd);
   	}
	// focus out
    function obj_blur(){
        //Input Validation to check load + mask separator
    	var obj=event.srcElement;
    	ComChkObjValid(obj);
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
         	/*
    	 	case "engup":
		    	// upper case + numbers 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        // only numbers
    	        ComKeyOnlyNumber(event.srcElement);
    	        break;
         	*/
         	default:
	         	// only numbers (integer, date, time)
	            ComKeyOnlyNumber(event.srcElement);
    	 }
     }
	/*
	 * Multiple selected DEM / DET Office of the Sub Office lookup
	 */
	function doInclSubOfc() {
		var formObj=document.form;
		if (formObj.chk_sub_ofc.checked) {	// Sub Office including
			if (ComIsEmpty(comboObjects[0].GetSelectCode())) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked=false;
				return;
			}
			formObj.ofc_cd.value=ComGetObjValue(comboObjects[0]);
			formObj.tmp_ofc_cd.value=ComGetObjValue(comboObjects[0]);
			doActionIBCombo(sheetObjects[0], formObj, comboObjects[0], COMMAND01);
		} 
		else {
			comboObjects[0].SetSelectIndex(-1);
			comboObjects[0].SetSelectCode(formObj.tmp_ofc_cd.value, false);
		}
	}
   /**
      * Sheet the initial setting, the header definition
      * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
      * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
            	    with(sheetObj){		                 
		               //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		               var HeadTitle1="||Seq.|Office|Delete Reason|TTL CNTR|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)|CNTR Volume (Box)";
		               var HeadTitle2="||Seq.|Office|Delete Reason|TTL CNTR|DMIF|DTIC|DMOF|DTOC|CTIC|CTOC";
		
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"},
		                           { Text:HeadTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                      {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		                      {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                      {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:0, Width:280,  Align:"Left",    ColMerge:1,   SaveName:"delt_rsn_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_cntr",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"dmif_sum",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"dtic_sum",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"dmof_sum",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"dtoc_sum",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ctic_sum",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"ctoc_sum",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"delt_rsn_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		               InitColumns(cols);		
		               ShowSubSum([{StdCol:"ofc_cd", SumCols:"ttl_cntr|dmif_sum|dtic_sum|dmof_sum|dtoc_sum|ctic_sum|ctoc_sum", Sort:false, ShowCumulate:false, CaptionCol:-1, OtherColText:"chk=;ofc_cd=%s;seq=S.TTL"}]);
		               SetEditable(1);
		               SetSheetHeight(455);
             	}
                break;
         }
     }
	// Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      // retrieving
            	if(!validateForm(sheetObj,formObj,sAction)) return;
            	
            	// 조회결과 초기화 및 Sort 기능이 적용된 경우, 적용해제해 준다.
            	sheetObj.RemoveAll();	
            	
	            sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
            	formObj.f_cmd.value=SEARCH;  				
                var sXml = sheetObj.GetSearchData("EES_DMT_3010GS.do", FormQueryString(formObj));
                sheetObj.LoadSearchData(sXml, {Sync:1});	
 				ComOpenWait(false);
           	break;
           	
 			case IBDELTRSN:		// Delete Reason info retrieving
 				formObj.f_cmd.value=SEARCHLIST;  				
 				var sXml=sheetObj.GetSearchData("EES_DMT_3010GS.do", FormQueryString(formObj));
 				var etcData=ComGetEtcData(sXml, "DELT_RSN");
 				if (etcData != undefined && etcData != '') {
 					ComAddComboItem(formObj.del_cd, "All", "All");
					var comboItems=etcData.split("|");
					for (var i=0 ; i < comboItems.length ; i++) {
						var item=comboItems[i].split("=");
						var deltRsnCd=item[0];
						var deltRsnDesc=item[1];
						ComAddComboItem(formObj.del_cd, deltRsnDesc, deltRsnCd);
		         	}
				}
 			break;
         }
	}
	/**
	 * Combo default setting 
	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
	 * If the case dasuil combo combo by adding the number of seats will initialize the module configuration
	 */ 
	function initCombo(comboObj, comboNo) {		
	    switch(comboObj.options.id) {  
	    	case "office": 
	    		with (comboObj) { 
					//MultiSelect = false;
	    			SetUseAutoComplete(1);
	    			SetColAlign(0, "left");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
			    }
		    	break;
	    }
	}
	// IBCombo Data retrieval and setting
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
    	 sheetObj.ShowDebugMsg(false);
    	 sheetObj.SetWaitImageVisible(0);
    	 formObj.f_cmd.value=formCmd;     	 
    	 var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
    	 switch(formCmd) {
    	 	case COMMAND06:	// RHQ
    	 		with (comboObj) { 
	    	 		RemoveAll();
					SetMultiSelect(0);
					SetColWidth(0, "65");
					ValidChar(2);	// only upper case
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
					SetColWidth(0, "95");
					ValidChar(2, 2); // only upper case, special character
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
		    	    // Log in to the Default User Office
	    	  		comboObj.SetSelectCode(usrOfcCd);
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
	// Muti combo Click Event Catch
 	function office_OnCheckClick(comboObj, index, code) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.GetItemCheck(index))
   				comboObj.SetItemCheck(index, 0, false);
   			else
   				comboObj.SetItemCheck(index, 1, false);
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	// Muti combo KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	// Pop-up processing
	function doProcessPopup(srcName) {
   		var sheetObj=sheetObjects[0];
   		var formObj=document.form;
   		var sUrl='';
   		var sWidth='';
   		var sHeight='';
   		with(sheetObj) {
 	  		switch(srcName) {
 	  			case 'btn_Detail':
 	  				if(CheckedRows("chk") == 0) {
             			ComShowCodeMessage('COM12114', 'Deleted Charge');
             			return;
             		}
             		var chkCnt=0;
             		var chkRows=FindCheckedRow("chk").split("|");
             		var prevOfcCd=GetCellValue(chkRows[0], "ofc_cd");
             		var chkDelCd='';

             		for(var i=0; i < chkRows.length; i++) {
             			var currOfcCd=GetCellValue(chkRows[i], "ofc_cd");
             			// Office for only one thing can be selected multiple (different item is selected out of Office)
             			if(currOfcCd != prevOfcCd) {
             				ComShowCodeMessage('DMT01066');
         					return;
             			}
             			var delCd=GetCellValue(chkRows[i], "delt_rsn_cd");
             			chkDelCd += ',' + delCd; 
             		}
             		chkDelCd=chkDelCd.substring(1);
             		var dtFlg=ComGetObjValue(formObj.dt_flg);
             		var fmDt=ComGetUnMaskedValue(formObj.fm_dt, 'ymd');
         			var toDt=ComGetUnMaskedValue(formObj.to_dt, 'ymd');
             		var grpFlg=ComGetObjValue(formObj.grp_flg);
             		var paramVal="?dt_flg=" + dtFlg + "&fm_dt=" + fmDt + "&to_dt=" + toDt + "&grp_flg=" + grpFlg
             						+ "&ofc_cd=" + prevOfcCd + "&del_cd=" + chkDelCd;
		 	  		sUrl='EES_DMT_3011.do' + paramVal;
		      		sWidth='1200'; 
		      		sHeight='700';
		      		//ComOpenWindow(sUrl, 'EES_DMT_POP', "width="+sWidth+",height="+sHeight);
              		//return;
		      		break;
 	  		}
   		}
   		var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
		ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
	}
     /**
      * Screen form validation process for processing the input values
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
        	 switch(sAction) {
          		case IBSEARCH:
          			if(!ComIsDate(fm_dt)) {
         				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
         				return false;
         			}
         			if(!ComIsDate(to_dt)) {
         				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
         				return false;
         			}
         			var startDt=ComGetUnMaskedValue(fm_dt, 'ymd');
         			var endDt=ComGetUnMaskedValue(to_dt, 'ymd');
 					//Check period
                    if (startDt > endDt) {
                    	ComShowCodeMessage("COM12133", "'Period From Date'", "'Period To Date'", "earlier");
                    	return false;
                    }
                    // Check whether or not within one month period is
                    var limitDt=ComGetDateAdd(startDt, "M", 1);
                    if (ComChkPeriod(endDt, limitDt) == 0) {
                    	ComShowCodeMessage("DMT00162", "1 month");
                    	return false;
                    }
                    var ofcCd=comboObjects[0].GetSelectCode();
                    if(ComIsEmpty(ofcCd)) {
                    	ComShowCodeMessage('COM12113', "DEM/DET Office");
             			return false;
                    }
                    ComSetObjValue(ofc_cd, ofcCd);
          			break;
        	 }
         }
         return true;
     }
 	// Using a lookup function lookup is complete, an Event occurs
     function sheet1_OnSearchEnd(sheetObj, code,  ErrMsg){
 		with(sheetObj){
 			CheckAll("chk", 0);
 			SetSumText(0, "seq", "TOTAL");
     	}
     }
	// IBSeet mouse click in the data area that occurs when cells Event
 	function sheet1_OnClick(sheetObj, Row, Col, Value) {
        with(sheetObj) {
            if (ColSaveName(Col) == "chk") {
            	//All Check box Check box state synchronization process when you click, ComSyncAllCheck(sheetObj, Col, Value);
            	var cnt=SearchRows()- CheckedRows("chk");
            	if (cnt == 0) {
            		SetHeaderCheck(0, "chk",0);
                    SetHeaderCheck(1, "chk",0);
                } else if(cnt == 1 && Value == '0') {
	            	SetHeaderCheck(0, "chk",1);
                    SetHeaderCheck(1, "chk",1);
                }
            }
        }
 	}
	/* developers work end */