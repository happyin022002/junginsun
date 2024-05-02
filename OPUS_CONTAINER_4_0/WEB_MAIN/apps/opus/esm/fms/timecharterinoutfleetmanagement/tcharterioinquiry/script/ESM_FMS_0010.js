/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0010.jsp
*@FileTitle  : Statement of Account
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0010 : esm_fms_0010 definition of biz script for creation screen
     */

    //  common global variables 
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name  */
    function processButtonClick(){
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var sheetObject2=sheetObjects[2];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		switch(srcName) {
     			case "btn_retrieve":
     				doActionIBSheet(sheetObject,formObject,IBSEARCH);
     				break;
     			case "btn_new":
    		 		//ComResetAll();
    		 		//sheetObjects[1].SetVisible(false);
    		 		clearAll();//NYK Modify 2014.10.21
  //no support[implemented common]CLT 	  				controlScrollBar();
     				break;
     			case "btn_savetofile":
     				//sheetObject.SpeedDown2Excel(-1);
//     				Down2Excel();
     				sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
     				break;
     			case "btn_print":
     				rdOpen(document.form);
     				break;
     			case "btn_vslCd":
     				clearAll();//NYK Modify 2014.10.21
     				ComOpenPopup("ESM_FMS_0022.do", 520, 470, "setVslCd", "1,0,1,1,1", true, false, null, null, null, "esm_fms_0022");
     				break;
     			case "btn_fletCtrtNo":
     				if(formObject.vslCd.value == "") {
     					ComAlertFocus(formObject.vslCd, ComGetMsg('FMS01231'));
     					return;
     				}
     				clearAll("CTRT"); //NYK Modify 2014.10.21
     				ComOpenPopup("ESM_FMS_0023.do?vsl_cd=" + formObject.vslCd.value, 520, 405, "setContractNo", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0023");
     				break;
     			case "btn_vslCdClr":
     				form.vslCd.value="";
     				form.vslEngNm.value="";
     				form.fletCtrtNo.value="";
     				form.fletCtrtTpCd.value="";
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
     * Registering IBSheet Object as Array
     * In case there is needs to do batch processing, process saving as Array can be added
     * defining array on the top of source
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
    	initControl();
    }
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
    	var sheetID=sheetObj.id;
    	switch(sheetID) {
 			case "sheet1":
 			    with(sheetObj){
		 		      var HeadTitle="Item Name|Hire No.|Period|Description|Curr|DR Amount|Curr|CR Amount";
		 		      var headCount=ComCountHeadTitle(HeadTitle);
		 		      (headCount, 0, 0, true);
		
		 		      //SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		 		      SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:0 } );
		
		 		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		 		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		 		      InitHeaders(headers, info);
		
		 		      var cols = [ {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"itm_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hire_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"acct_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"acct_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Float",     Hidden:0,  Width:87,   Align:"Right",   ColMerge:0,   SaveName:"dr_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Float",     Hidden:0,  Width:87,   Align:"Right",   ColMerge:0,   SaveName:"cr_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 } ];
		 		       
		 		      InitColumns(cols);
		
		 		      SetEditable(1);
		 		      SetFocusAfterProcess(0);
//		 		      SetSheetHeight(460);
		 		      SetCountPosition(0);
		 		      resizeSheet();
 		      }
 				break;
 			case "sheet2":
 			    with(sheetObj){
		 		      var HeadTitle="Item Name|Hire No.|Period|Description|Currency|DR Amount|Currency|CR Amount";
		 		      var headCount=ComCountHeadTitle(HeadTitle);
		 		      (headCount, 0, 0, true);
		
		 		      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		
		 		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		 		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		 		      InitHeaders(headers, info);
		
		 		      var cols = [ {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"itm_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hire_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"acct_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"acct_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Float",     Hidden:0,  Width:87,   Align:"Right",   ColMerge:0,   SaveName:"dr_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		 		             {Type:"Float",     Hidden:0,  Width:87,   Align:"Right",   ColMerge:0,   SaveName:"cr_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
		 		       
		 		      InitColumns(cols);
		
		 		      SetEditable(1);
		 		      SetRowHidden(0, 1);
		 		      SetFocusAfterProcess(0);
		 		      SetCountPosition(0);
		 		      SetVisible(false);
 		      }
 				break;
 			case "sheet3":
 			    with(sheetObj){
		 		      var HeadTitle="Item Name|Hire No.|Period|Description|Currency|DR Amount|Currency|CR Amount";
		 		      var headCount=ComCountHeadTitle(HeadTitle);
		 		      (headCount, 0, 0, true);
		
		 		      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
		
		 		      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		 		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		 		      InitHeaders(headers, info);
		
		 		      var cols = [ {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:0,   SaveName:"itm_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hire_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Center",  ColMerge:0,   SaveName:"acct_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"acct_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Float",     Hidden:0,  Width:77,   Align:"Right",   ColMerge:0,   SaveName:"dr_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 },
		 		             {Type:"Float",     Hidden:0,  Width:77,   Align:"Right",   ColMerge:0,   SaveName:"cr_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1,   EditLen:-1 } ];
		 		       
		 		      InitColumns(cols);
		
		 		      SetEditable(1);
		 		      SetRowHidden(0, 1);
		 		      SetFocusAfterProcess(0);
		 		      SetCountPosition(0);
		 		     SetVisible(false);
 		      }
 				break;
    	}
    }
    /**
     * Handling IBSheet's process(Retrieve, Save) <br>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form}    formObj Mandatory html form object
     * @param {int}     sAction mandatory,Constant Variable
     **/  
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
 			case IBSEARCH:     
 				if(objNm == "fletCtrtTpCd") {
		 			formObj.f_cmd.value=SEARCH04;
		 			var param=FormQueryString(formObj) + "&flet_ctrt_no=" + formObj.fletCtrtNo.value;
		 			var sXml=sheetObj.GetSearchData("ESM_FMS_0050GS.do" , param);
		   			var ctrtType=ComGetEtcData(sXml, "ctrtType");
		   			if(typeof ctrtType != "undefined" && ctrtType != "") {
		   				formObj.fletCtrtTpCd.value=ctrtType;
					}
 				} else if(objNm == "vslCd") {
        			formObj.f_cmd.value=SEARCH01;
        			var param=FormQueryString(formObj) + "&vsl_cd=" + formObj.vslCd.value;
        			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do", param);
    	   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
    	   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
    	   				formObj.vslEngNm.value=vslEngNm;
    	   				form.fletCtrtNo.value="";
         				form.fletCtrtTpCd.value="";
    	   				//form.btn_vslCdClr.checked = true;
         				
         				initDefaultContractNo(); //NYK Modify 2014.10.21
    				} else {
    					//form.btn_vslCdClr.checked = false;
    					formObj.vslCd.value="";
    					form.fletCtrtNo.value="";
         				form.fletCtrtTpCd.value="";
    					ComAlertFocus(formObj.vslCd, ComGetMsg("FMS00006", "Vessel Code"));
    					return;
    				}
 				} else {
	 				if(validateForm(sheetObj,formObj,sAction)) {
	 					formObj.f_cmd.value=SEARCH;
	 					var sXml=sheetObj.GetSearchData("ESM_FMS_0010GS.do", FormQueryString(formObj));
	       	   	  		var arrXml=sXml.split("|$$|");
	       	   	  		if (arrXml.length > 0) {

	     	   	  		sheetObjects[0].LoadSearchData(arrXml[0],{Sync:0});
     	   	  			sheetObjects[1].RemoveAll();
     	   	  			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1});
//	     	   	  			var total=ComFmsGetAttr(arrXml[1], "DATA", "TOTAL");
//	     	   	  			if(total > 0) {
//	     	   	  				sheetObjects[1].SetSheetHeight(40 + (total * 20));
//	     	   	  			} else {
//	     	   	  				sheetObjects[1].SetVisible(false);
//	     	   	  			}
//no support[implemented common]CLT 	     	   	  			controlScrollBar();
	     	   	  		} else {
	     	   	  			sheetObjects[1].SetVisible(false);
	     	   	  		}
	 				}
 				}
	 			break;
            	
			case IBSEARCH_ASYNC02: //NYK Modify 2014.10.21				
				if(formObj.vslCd.value == "") return;				
				var f_query = "";					
				f_query += "f_cmd=" + SEARCH01; 
				f_query += "&vsl_cd="+formObj.vslCd.value;	 			
				f_query += "&type_flag="+gFletCtrtTpCdAll;  
				
				var sXml = sheetObj.GetSearchData("FMS_COMGS.do",f_query);

	   			var varFletCtrtNo = ComGetEtcData(sXml, "flet_ctrt_no");
	   			
	   			if(typeof varFletCtrtNo != "undefined" && varFletCtrtNo != "" ) {
					formObj.fletCtrtNo.value = varFletCtrtNo;
				}else{
					ComShowCodeMessage("FMS20001","Agreement");
					clearAll();
					return;
				}
				if(formObj.fletCtrtNo.value != ""){
					contract_no_change();
				}
				break;
    	}
    }
    /**
     * Handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form}    formObj     Form Object
     * @param {int}     sAction     Action Code(Example:IBSEARCH,IBSAVE,IBDELETE,IBDOWNEXCEL)
     **/
    function validateForm(sheetObj,formObj,sAction){
    	if (!ComChkValid(formObj)) {
    		return false;
     	}
    	return true;
    }
    /**
 	 * Setting Vessel Code and Name selected in Vessel Code PopUp into Form Item<br>
 	 * @param {arry} aryPopupData
 	 */
 	function setVslCd(aryPopupData) {
 		form.vslCd.value=aryPopupData[0][2];
 		form.vslEngNm.value=aryPopupData[0][3];
 		
 		initDefaultContractNo(); //NYK Modify 2014.10.21
 	}
 	/**
	 * Setting Contract No selected in Contract Code PopUp into Form Item<br>
	 * @param {arry} aryPopupData
	 */
	function setContractNo(aryPopupData){
		form.fletCtrtNo.value=aryPopupData[0][3];
		contract_no_change();//NYK Modify 2014.10.21
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"fletCtrtTpCd");
	}
	
	//NYK Modify 2014.10.21
    function contract_no_change() {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"fletCtrtTpCd");
    }
	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
 	function initControl() {
 		//Axon Event Handling1. Event catch
// 		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 			//- Code handling to onkeypress Event of All Controls having dateformat attribute
// 		axon_event.addListenerForm  ('keypress', 'engnum_keypress', form); 			//- Code Handling to OnKeypress Event of All Controls
 		axon_event.addListenerForm  ('change',   'obj_change',   form); 			//- Code Handling to OnChange Event of All Controls
 	}

    /**
     * Getting Vessel Name from onchange Event of HTML Control<br>
     * @return none
     */
	function obj_change() {
		if((ComGetEvent("name") == "vslCd")) {
	    	form.vslEngNm.value="";
	    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"vslCd");
		}
	}
    /**
     * Controlling scroll bar automatically when retrieving data.<br>
     **/
	function controlScrollBar() {
 		try{
 			top.syncHeight();
 		} catch(err){ComFuncErrMsg(err.message);}
 	}
    /**
     * Setting each title's Font Bold when OnSearchEnd Event of sheet1 is occurred<br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {string}  errMsg      Error Message
     * @return none
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	for(var row=1; row<=sheetObj.LastRow(); row++) {
    		if(sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "1." ||
    				sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "2." ||
    				sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "3." ||
    				sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "4." ||
    				sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "5." ||
    				sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "6." ||
    				sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "7." ||
    				sheetObj.GetCellValue(row,"itm_nm").substring(0,2) == "8.") 
    		{
	    		sheetObj.SetRowBackColor(row,"#FFF3A4");
	    		sheetObj.SetCellFont("FontBold", row, "itm_nm",1);
	    		sheetObj.SetMergeCell(row, 0, 1, 4);
    		} else {
    			sheetObj.SetToolTipText(row,"acct_desc",sheetObj.GetCellValue(row,"acct_desc"));
    		}
    	}
    }
    /**
     * Setting each title's Font Bold when OnSearchEnd Event of sheet2 is occurred<br>
     * @param {ibsheet}	sheetObj    IBSheet Object
     * @param {string}  errMsg      Error Message
     * @return none
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	sheetObj.SetVisible(sheetObj.RowCount() > 0);
    	for(var row=1; row<=sheetObj.LastRow(); row++) {
    		if(row == 1) {
    			sheetObj.SetCellValue(row, "itm_nm","Total Amount",0);
    		} else {
    			sheetObj.SetCellValue(row, "itm_nm","",0);
    		}
    		sheetObj.SetRowBackColor(row,"#FFE6FB");
    		sheetObj.SetCellFont("FontBold", row, "itm_nm",1);
    		sheetObj.SetCellFont("FontBold", row, "curr_cd1",1);
    		sheetObj.SetCellFont("FontBold", row, "dr_amt",1);
    		sheetObj.SetCellFont("FontBold", row, "curr_cd2",1);
    		sheetObj.SetCellFont("FontBold", row, "cr_amt",1);
    	}

    }
    /**
     * Moving data to temporary sheet to print data part and summary part together, then printing as Excel <br>
     */
    function Down2Excel(){
 		if(sheetObjects[0].RowCount()== 0) {
 			ComShowCodeMessage("FMS00016");
 			return;
 		}
    	var targetSheetObj=sheetObjects[2];
    	for(var row=1; row<=sheetObjects[0].LastRow(); row++) {
    		var currRow=targetSheetObj.DataInsert();
    		targetSheetObj.SetCellValue(currRow,"itm_nm",sheetObjects[0].GetCellValue(row,"itm_nm"),0);
    		if(sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "1." ||
    				sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "2." ||
    				sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "3." ||
    				sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "4." ||
    				sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "5." ||
    				sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "6." ||
    				sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "7." ||
    				sheetObjects[0].GetCellValue(row,"itm_nm").substring(0,2) == "8.") {
				targetSheetObj.SetCellValue(currRow,"hire_no","",0);
				targetSheetObj.SetCellValue(currRow,"acct_dt","",0);
				targetSheetObj.SetCellValue(currRow,"acct_desc","",0);
    		} else {
    			targetSheetObj.SetCellValue(currRow,"hire_no",sheetObjects[0].GetCellValue(row,"hire_no"),0);
    			targetSheetObj.SetCellValue(currRow,"acct_dt",sheetObjects[0].GetCellValue(row,"acct_dt"),0);
    			targetSheetObj.SetCellValue(currRow,"acct_desc",sheetObjects[0].GetCellValue(row,"acct_desc"),0);
    		}
    		targetSheetObj.SetCellValue(currRow,"curr_cd1",sheetObjects[0].GetCellValue(row,"curr_cd1"),0);
    		targetSheetObj.SetCellValue(currRow,"dr_amt",sheetObjects[0].GetCellValue(row,"dr_amt"),0);
    		targetSheetObj.SetCellValue(currRow,"curr_cd2",sheetObjects[0].GetCellValue(row,"curr_cd2"),0);
    		targetSheetObj.SetCellValue(currRow,"cr_amt",sheetObjects[0].GetCellValue(row,"cr_amt"),0);
    	}
    	for(var row=1; row<=sheetObjects[1].LastRow(); row++) {
    		var currRow=targetSheetObj.DataInsert();
    		if(row == 1) {
    			targetSheetObj.SetCellValue(currRow,"itm_nm","Total Amount",0);
    		}
    		targetSheetObj.SetCellValue(currRow,"hire_no",sheetObjects[1].GetCellValue(row,"hire_no"),0);
    		targetSheetObj.SetCellValue(currRow,"acct_dt",sheetObjects[1].GetCellValue(row,"acct_dt"),0);
    		targetSheetObj.SetCellValue(currRow,"acct_desc",sheetObjects[1].GetCellValue(row,"acct_desc"),0);
    		targetSheetObj.SetCellValue(currRow,"curr_cd1",sheetObjects[1].GetCellValue(row,"curr_cd1"),0);
    		targetSheetObj.SetCellValue(currRow,"dr_amt",sheetObjects[1].GetCellValue(row,"dr_amt"),0);
    		targetSheetObj.SetCellValue(currRow,"curr_cd2",sheetObjects[1].GetCellValue(row,"curr_cd2"),0);
    		targetSheetObj.SetCellValue(currRow,"cr_amt",sheetObjects[1].GetCellValue(row,"cr_amt"),0);
    	}
    	targetSheetObj.Down2Excel({ HiddenColumn:-1});
    	targetSheetObj.RemoveAll();
    }
 	/**
     * Printing RD <br>
     * @param {ibsheet}	rdObject    IBSheet Object
     * @param {form}    formObj     Form Object
     * @return none
     **/
 	function rdOpen(formObject){
 		if(sheetObjects[0].RowCount() == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}
  		
 		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
 		//var rdParam = '/rv '+ rdParam;
		var rdFile = 'apps/opus/esm/fms/timecharterinoutfleetmanagement/tcharterioinquiry/report/ESM_FMS_011.mrd';

 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();
	}
    /**
     * Setting scroll position of sheet 2 as same as scroll position of sheet1 when OnScroll Event of Sheet1 is occurred<br>
     */
    function sheet1_OnScroll(sheetObj, olGetTopRow, oldLeftCol, newGetTopRow, newLeftCol) {
    	sheetObjects[1].SetHighLeftCol(newGetHighLeftCol());
    }
    /**
     * Setting scroll position of sheet 1 as same as scroll position of sheet2 when OnScroll Event of Sheet2 is occurred<br>
     */
    function sheet2_OnScroll(sheetObj, olGetTopRow, oldLeftCol, newGetTopRow, newLeftCol) {
    	sheetObjects[0].SetHighLeftCol(newGetHighLeftCol());
    }  
	
 	function clearAll(flag){
 		//NYK Modify 2014.10.21
		switch(flag){
			case "CTRT" :
				var tmpVslCd = form.vslCd.value;
				var tmpVslEngNm = form.vslEngNm.value;
				ComResetAll();
				form.vslCd.value = tmpVslCd;
				form.vslEngNm.value = tmpVslEngNm;
				break;
			default :
				ComResetAll();
				break;
		}
 		//sheetObjects[1].style.height = 0;
		//controlScrollBar();
 	}

    //NYK Modify 2014.10.21
    function initDefaultContractNo(){
  	  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);   
    }  
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    