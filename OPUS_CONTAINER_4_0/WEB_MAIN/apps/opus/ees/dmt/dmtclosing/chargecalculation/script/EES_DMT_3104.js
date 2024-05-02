/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3104.js
*@FileTitle  : Exemption Reason Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
 // Common Global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** case in Sheet count are more two by Tab, defining adding sheet *****/
          var sheetObj1=sheetObjects[1];
          /*******************************************************/
          var formObj=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		switch(srcName) {
				case "btn_Save":
					doActionIBSheet(sheetObj1,formObj,IBSAVE);
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
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
    	doInit();
	}
	function initControl() {
  		//axon_event.addListenerFormat('keypress','obj_keypress', document.form); //- on press keyboard
  	}
  	//business javascript OnKeyPress event handling
   	function obj_keypress() {
       	 switch(event.srcElement.dataformat){
            	case "engup":
   		    	// All characters except lowercase letters
            		DmtComKeyOnlyAlphabet('upperall');
   		        break;
       	 }
  	}
	//IBSheet using Object tag on the page creates an instance of the Event will occur when complete.
//function sheet1_OnLoadFinish() {
//  		//var formObj = document.form;
//  		//var sheetObj = sheetObjects[0];
//  		//sheetObj.WaitImageVisible = false;
//        doInit();
//        //sheetObj.WaitImageVisible = true; 
//	}
	function doInit() {
 		var formObj=document.form;
// 		var opener=window.dialogArguments;
// 		var opnSheetObj=opener.document.form.sheet1;
		var opener=window.dialogArguments; 
		if (!opener) opener=parent;
//		var opnSheetObj=opener.document.form.sheet1
		var opnSheetObj=opener.sheet1;
 		var sheetObj=sheetObjects[1];
		
 		// Search Delete Reason List
 		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 		
 		var sXml = ComMakeSearchXml(opnSheetObj, false, "chk", "svr_id|cntr_no|cntr_cyc_no|dmdt_trf_cd|dmdt_chg_loc_div_cd|chg_seq|bkg_no|ofc_cd");
 		//sheet2로 조회XML 로드하기
 		//sheetObj.LoadSearchXml(sXml, true);
 		sheetObj.LoadSearchData(sXml, {Sync:1});
 		
 		if (sheetObj.SearchRows() == 0) {
 			// Called in by CNTR Screen 
 			var row=sheetObj.DataInsert(-1);
 			var opnFormObj=opener.document.form;
 			
 			sheetObj.SetCellValue(row, "svr_id",ComGetObjValue(opnFormObj.svr_id));
 			sheetObj.SetCellValue(row, "cntr_no",ComGetObjValue(opnFormObj.cntr_no));
 			sheetObj.SetCellValue(row, "cntr_cyc_no",ComGetObjValue(opnFormObj.cntr_cyc_no));
 			sheetObj.SetCellValue(row, "dmdt_trf_cd",ComGetObjValue(opnFormObj.dmdt_trf_cd));
 			sheetObj.SetCellValue(row, "dmdt_chg_loc_div_cd",ComGetObjValue(opnFormObj.dmdt_chg_loc_div_cd));
 			sheetObj.SetCellValue(row, "chg_seq",ComGetObjValue(opnFormObj.chg_seq));
 			sheetObj.SetCellValue(row, "bkg_no",ComGetObjValue(opnFormObj.bkg_no));
 		}
 		for(var i=sheetObj.GetTopRow(); i <= sheetObj.SearchRows(); i++) {
 			sheetObj.SetRowStatus(i, "U");
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
		               var HeadTitle1="|Seq.|Sel.|Charge Delete Reason";
		               (5, 0, 0, true);
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                      {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"chk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"intg_cd_val_dp_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"intg_cd_val_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               SetSheetHeight(320);
                     }


                 break;
             case 2:      // sheet2 init(hidden)
                 with(sheetObj){
		              var HeadTitle="|SVR ID|CNTR No.|CNTR_CYC_NO|TRF|DIV|CHG_SEQ";
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                  {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svr_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		                  {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_cyc_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"dmdt_chg_loc_div_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chg_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                  {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               
		              InitColumns(cols);
		              SetEditable(1);
		               SetSheetHeight(320);
                       }
                 break;
         } // switch end
     }
   // Process of Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:     // Search
            	formObj.f_cmd.value=SEARCH;
            	sheetObj.DoSearch("EES_DMT_3104GS.do", FormQueryString(formObj));
 				//var sXml = sheetObj.GetSearchData("EES_DMT_3104GS.do", FormQueryString(formObj));
 				//sheetObj.LoadSearchData(sXml, {Sync:1});
 			break;
 			
            case IBSAVE:        // save
            	if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.SetWaitImageVisible(0);
	        	ComOpenWait(true);
        		formObj.f_cmd.value=MULTI;
        		sheetObj.DoSave("EES_DMT_3104GS.do", FormQueryString(formObj), -1, false);
        		ComOpenWait(false);
        	break;
         }
     }
    // After saving handling 
	function sheet2_OnSaveEnd(sheetObj, code, ErrMsg) {
		 if(ErrMsg != '') {	// Error when saving
			 //ComShowCodeMessage('COM12151', "Tariff Type");
		 } else {
//			var opener=window.dialogArguments;
			var opener=window.dialogArguments;
			if (!opener) opener=parent;
			opener.doActionIBSheet(opener.sheetObjects[0],opener.document.form,IBSEARCH);
			ComClosePopup(); 
		 }
	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj) {
        	 switch(sAction) {
		         case IBSAVE:
		        	var sheetObj1=sheetObjects[0];
		        	var chkCnt=sheetObj1.CheckedRows("chk");
					if(chkCnt == 0) {
						ComShowCodeMessage('DMT01049');
						return false;
					}
		        	var chkRows=sheetObj1.FindCheckedRow("chk").split("|");
					var chgDeltRsnCd=sheetObj1.GetCellValue(chkRows[0], "intg_cd_val_ctnt");
					var corrRmk=ComGetObjValue(corr_rmk);
					if(corrRmk != '')
						corrRmk=ComTrim(corrRmk);
					if(chgDeltRsnCd == 'OTH' && corrRmk == '') {
						ComShowCodeMessage('DMT01038');
						ComSetFocus(corr_rmk);
						return false;
					}
					var chgDelRsnDesc=sheetObj1.GetCellValue(chkRows[0], "intg_cd_val_dp_desc");
					if(corrRmk != '')
						corrRmk=chgDelRsnDesc + " : " + corrRmk;
					else
						corrRmk=chgDelRsnDesc;
					ComSetObjValue(corr_rmk, corrRmk);
					if(ComChkLenByByte(corrRmk, 500) == 0) {	// Exceed the length
						ComShowCodeMessage('COM12173', 'Remark', '500');
						ComSetFocus(corr_rmk);
						return false;
					}
					ComSetObjValue(dmdt_chg_delt_rsn_cd, chgDeltRsnCd);
					for(var i=sheetObj.GetTopRow(); i <= sheetObj.SearchRows(); i++) {
						sheetObj.SetRowStatus(i, "U");
					}
				break;
        	 } // switch end
         } // with end
         return true;
     }
