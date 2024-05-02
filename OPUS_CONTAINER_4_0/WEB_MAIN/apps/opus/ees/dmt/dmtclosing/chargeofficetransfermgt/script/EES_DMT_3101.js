/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3101.jsp
*@FileTitle  : Office Transfer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code added code to make a good  JSDoc ------------------*/
   /**
     * @fileoverview JavaScript is commonly used in business calendar-related functions are defined as.
     * @author Hanjin Shipping
     */
    /**
     * @extends 
     * @class EES_DMT_3101 : EES_DMT_3101 on the screen for creating the script defines the task using.
     */
      	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var ROWMARK="|";
	var FIELDMARK="=";
	// Event handler processing by button click event */
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
 				case "btn_Save":
 					doActionIBSheet(sheetObj,formObj,IBSAVE);
					break;
 				case "btn_Close":
 					ComClosePopup(); 
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
      * IRegister as an array IBSheet Object
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
      *  initializing sheet
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
         sheet1_OnLoadFinish(sheet1);
     }
	// IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
  		function sheet1_OnLoadFinish() {
		var formObj=document.form;
 		var sheetObj=sheetObjects[0];
 		//sheetObj.WaitImageVisible = false;
		// RHQ Combobox initializing
        doActionIBCombo(sheetObj, formObj, formObj.shd_rhq_cd, COMMAND06);
        // Should Read RHQ initializing
        ComSetObjValue(formObj.shd_rhq_cd, formObj.ofc_rhq_cd.value);
        // Viewed conditions initializing
        doInit();
        //sheetObj.WaitImageVisible = true; 
   	}
	function initControl() {
 		//axon_event.addListenerForm  ('blur',	'obj_blur',		document.form); //- focus out
 		//axon_event.addListenerFormat('focus',	'obj_focus',	document.form); //- focus in
 		axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- input with keyboard
 		axon_event.addListener('change',		'rhq_change',	'shd_rhq_cd');
 		//axon_event.addListener('keydown',		'ComKeyEnter',	'form');
 	}
	// From/To Office의 RHQ Select Object OnChange Event Handling
 	function rhq_change() {
 		var formObj=document.form;
 		//var obj = formObj.shd_rhq_cd;
 		// Office RHQ of the selected item
 		//var rhqCd = ComGetObjValue(obj);
 		//ComSetObjValue(formObj.ofc_cd, rhqCd);
 		// Belonging to the selected RHQ IBMultiCombo Object Office Code specifies the set list
 		var comboObj=comboObjects[0];
 		comboObj.RemoveAll();
 		doActionIBCombo(sheetObjects[0], formObj, formObj.cb_to_ofc_cd, SEARCHLIST02);
 	}
 	//JavaScript event handling tasks OnKeyPress
	function obj_keypress() {
		switch(event.srcElement.dataformat){
        	case "engup":
		    	// upper case + numbers 
        		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
        	case "engup3":
		    	// upper case + ALL
        		DmtComKeyOnlyAlphabet('upperall');
		        break;
        	case "int":
	   	        //only numbers
	   	        //ComKeyOnlyNumber(event.srcElement);
	   	        break;
        	default:
	         	// only numbers (integer, date, time)
	            //ComKeyOnlyNumber(event.srcElement);
		}
    }
	/*
	 * INIT SETTING
	 */
	function doInit() {
		var formObj=document.form;
		rhq_change();
//		var opener=window.dialogArguments;
//		var opnSheetObj=opener.document.form.sheet1;
		var opener=window.dialogArguments;
		if (!opener) opener=parent;
		var opnSheetObj=opener.sheetObjects[0];
		var sheetObj=sheetObjects[0];
		// "chk" Views column of sheet1 is checked as XML, making data
		var sXml=ComMakeSearchXml(opnSheetObj, false, "chk", "cntr_no|cntr_tpsz_cd|bkg_no|bl_no|rlse_ofc|svr_id|cntr_cyc_no|dmdt_chg_loc_div_cd|chg_seq|dmdt_chg_sts_cd|dmdt_trf_cd");
		//Query XML to load into sheet2
		sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
		//alert(sheetObj.TopRow + '..' + sheetObj.SearchRows);
		if(sheetObj.SearchRows()== 0) {
			// by CNTR Called on the screen 
			var row=sheetObj.DataInsert(-1);
			//sheetObj.CellValue(row, "ibflag") = formObject.login_usr_nm.value;
			var opnFormObj=opener.document.form;
			sheetObj.SetCellValue(row, "cntr_no",ComGetObjValue(opnFormObj.cntr_no));
			sheetObj.SetCellValue(row, "cntr_tpsz_cd",ComGetObjValue(opnFormObj.cntr_tpsz_cd));
			sheetObj.SetCellValue(row, "bkg_no",ComGetObjValue(opnFormObj.bkg_no));
			sheetObj.SetCellValue(row, "bl_no",ComGetObjValue(opnFormObj.bl_no));
			sheetObj.SetCellValue(row, "rlse_ofc",ComGetObjValue(opnFormObj.rlse_ofc));
			sheetObj.SetCellValue(row, "svr_id",ComGetObjValue(opnFormObj.svr_id));
			sheetObj.SetCellValue(row, "cntr_cyc_no",ComGetObjValue(opnFormObj.cntr_cyc_no));
			sheetObj.SetCellValue(row, "dmdt_chg_loc_div_cd",ComGetObjValue(opnFormObj.dmdt_chg_loc_div_cd));
			sheetObj.SetCellValue(row, "chg_seq",ComGetObjValue(opnFormObj.chg_seq));
			sheetObj.SetCellValue(row, "dmdt_chg_sts_cd",ComGetObjValue(opnFormObj.dmdt_chg_sts_cd));
			sheetObj.SetCellValue(row, "dmdt_trf_cd",ComGetObjValue(opnFormObj.dmdt_trf_cd));
		}
		sheetObj.CheckAll("chk",1);
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
               
               var HeadTitle="||Seq.|CNTR No.|T/S|BKG No.|B/L No.|D/O or R/OFC";

               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                      {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rlse_ofc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);
               //no support[check again]CLT style.height=GetSheetHeight(12);
               SetSheetHeight(273);
               SetEditable(1);
                     }


               break;
         }
     }
	 /**
	 * Combo basic setting 
	 * param : comboObj ==> combo object, comboNo ==> Combo object ID of the tag attached to the serial number
	 * If the case dasuil combo combo by adding the number of seats will initialize the module configuration
	 */
 	function initCombo(comboObj, comboNo) {
	    var formObj=document.form;
	    switch(comboObj.id) {
	    	case "cb_to_ofc_cd":
	    		with (comboObj) {
					SetMultiSelect(0);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColWidth(0, "60");
   					SetDropHeight(160);
 					SetColBackColor(0,"#CCFFFD");
 					SetBackColor("#CCFFFD");
 					ValidChar(2);	// using upper case 
					SetMaxLength(6);
    		    }
				break; 
	     }
 	}
   // Sheet processing-related processes
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSAVE:        // saving
         		if(!validateForm(sheetObj,formObj,sAction)) return;
	         	sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
 				formObj.f_cmd.value=MULTI;
 				sheetObj.DoSave("EES_DMT_3101GS.do", FormQueryString(formObj),"chk",0);
 				ComOpenWait(false);
                break;
         }
     }
	// After saving treatment
	function sheet1_OnSaveEnd(sheetObj, Code, Msg){
		// Save error
		if(Msg != '') return;
		ComShowCodeMessage('DMT01074');
		var opener=window.dialogArguments;
		if (!opener) opener=parent;
		var opnSheetObj=opener.sheetObjects[0];		
		opener.doActionIBSheet(opnSheetObj, opener.document.form, IBSEARCH);	
		ComClosePopup(); 
	}
	function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
        with(sheetObj) {
        	if (sheetObj.ColSaveName(Col) == "chk") {
            	//AllCheck box when you click Check box synchronization processing conditions
	            ComSyncAllCheck(sheetObj, Col, Value);
            }
        }
    }
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
 		sheetObj.ShowDebugMsg(false);
 		sheetObj.SetWaitImageVisible(0);
 		formObj.f_cmd.value=formCmd;
 		var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
 		switch(comboObj.id) {
 			case "cb_to_ofc_cd":
 				if(formCmd == SEARCHLIST02) {
	 				var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
	 				if(subOfcCds != undefined && subOfcCds != '') {
	 					var comboItems=subOfcCds.split("|");
	 					addComboItem1(comboObjects[0],comboItems);
	 					comboObjects[0].SetSelectIndex(-1);
	 				}
 				} else { // COMMAND09
 					var rhqCd=ComGetEtcData(sXml, "RHQ_CD");
 					if(rhqCd != '') {
 						// input ToOffice
 						var toOfcCd=comboObjects[0].GetSelectText();
 						ComSetObjValue(document.form.shd_rhq_cd, rhqCd);
 						rhq_change();
 						comboObjects[0].SetSelectCode(toOfcCd);
 					} else {
 						comboObj.SetSelectCode("");
 						ComShowCodeMessage('DMT00110', 'Should Read Office');
 					}
 				}
 	    	    break;
 			case "shd_rhq_cd":    
        		var data=ComGetEtcData(sXml, "common_cd");
				if (data != undefined && data != '') {
					var comboItems=data.split(ROWMARK);
					addComboItem(comboObj, comboItems);
				}
				 break;
         }
         sheetObj.SetWaitImageVisible(1);
     }
	/**
	 * Data in the field adds a combo.
	 */	
  	function addComboItem(comboObj,comboItems) {
  		switch(comboObj.id) {
//  			case "cb_to_ofc_cd":
// 		  		for (var i=0 ; i < comboItems.length ; i++) {
// 		  			comboObj.InsertItem(i, comboItems[i], comboItems[i]);
// 		  	   	}
// 		  		break;
  			case "shd_rhq_cd":
  				for (var i=0 ; i < comboItems.length ; i++) {
		  	   		ComAddComboItem(comboObj, comboItems[i], comboItems[i]);
		  	   	}
 		  		break;
  		}
  	}

    function addComboItem1(comboObj, comboItems) {
        for (var i=0 ; i < comboItems.length ; i++) {
            var comboItem=comboItems[i].split(ROWMARK);
            comboObj.InsertItem(i, comboItem[0], comboItem[0]);     
        }           
    }
  	/*
  	 * To (Should Read) Office Code if entered directly, Validation gives redundant processing year 
  	 * Flag variable for controlling
  	 */
  	var TO_OFC_CHK_FLG=false;
  	/*
  	 * Event processing that occurs when the focus goes off
  	 */
  	function cb_to_ofc_cd_OnBlur(comboObj) {
  		if(TO_OFC_CHK_FLG) {
  			return;
  		}
  		var ofcCd=comboObj.GetSelectText();
  		if(ofcCd == '') return;
  		if(ofcCd.length < 5) {
  			TO_OFC_CHK_FLG=true;
  			comboObj.SetSelectCode("");
  			ComShowCodeMessage('DMT00110', 'Should Read Office');
  			return;
  		}
  		TO_OFC_CHK_FLG=true;
  		var formObj=document.form;
  		ComSetObjValue(formObj.ofc_cd, ofcCd);
  		doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND09);
  	}
  	// Item Combo is selected when the event occurs has been changed
	function cb_to_ofc_cd_OnChange(comboObj,value,text) {
  		// Office changes that exist in the combo list
  		if(value != '') {
  			TO_OFC_CHK_FLG=true;
  		} else if(text != '')
  			TO_OFC_CHK_FLG=false;
  	}
	// When the keyboard is pressed, an event occur
  	function cb_to_ofc_cd_OnKeyDown(comboObj, keycode, shift) {
  		if(keycode != 13) return;
  		if(TO_OFC_CHK_FLG) return;
  		var ofcCd=comboObj.GetSelectText();
  		if(ofcCd == '') return;
  		if(ofcCd.length < 5) {
  			TO_OFC_CHK_FLG=true;
  			comboObj.SetSelectCode("");
  			ComShowCodeMessage('DMT00110', 'Should Read Office');
  			return;
  		}
  		TO_OFC_CHK_FLG=true;
  		var formObj=document.form;
  		ComSetObjValue(formObj.ofc_cd, ofcCd);
  		doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND09);
  		//TO_OFC_CHK_FLG = false;
  	}
     /**
      * Screen input form validation process for handling
      */
     function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
        	 switch(sAction) {
		         case IBSAVE:
		        	 var fmOfcCd=ComGetObjValue(fm_ofc_cd);
		        	 var toOfcCd=ComGetObjValue(comboObjects[0]);
		        	 if(ComIsEmpty(toOfcCd)) {
		        		 ComShowCodeMessage('DMT01021');
		        		 return false;
		        	 }
		        	 if(fmOfcCd == toOfcCd) {
		        		 ComShowCodeMessage('DMT01044');
		        		 return false;
		        	 }
		        	 var fmOfcRhqCd=ComGetObjValue(ofc_rhq_cd);
		        	 var toOfcRhqCd=ComGetObjValue(document.form.shd_rhq_cd);
		        	 // 'L' status, the other regions of the CNTR O / T can not
		        	 if(fmOfcRhqCd != toOfcRhqCd) {
		        		 for(var i=sheetObj.GetTopRow(); i <= sheetObj.LastRow(); i++) {
		        			 if(sheetObj.GetCellValue(i, "dmdt_chg_sts_cd") == 'L') {
		        				ComShowCodeMessage('DMT01010');
		        				return false;
		        			}
		        		 }
		        	 }
		        	 var trnsRsn=ComGetObjValue(trns_rsn);
		        	 if(ComIsEmpty(trnsRsn)) {
		        		 ComShowCodeMessage('DMT01045');
		        		 ComSetFocus(trns_rsn);
		        		 return false;
		        	 }
		        	 if(ComChkLenByByte(trnsRsn, 500) == 0) {	// Length exceeds
		        		 ComAlertFocus(trnsRsn, ComGetMsg('COM12173', 'Reason', '500'));
		        		 return false;
		        	 }
		        	 ComSetObjValue(to_ofc_cd, comboObjects[0].GetSelectCode());
		        	 break;
        	 }
         }
         return true;
     }
	/* developers work end */
