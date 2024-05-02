/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3521.js
*@FileTitle : Inland Rates Amend Request
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.21 
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_3521 : Business Script for ESM_PRI_3521
     */
	var sheetObjects=new Array();
	var sheetCnt=0;
    // Variable to check whether modified data exist. It returns to main, When it's value is True, Retrieve again.
    var returnData=false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.10.28
     */
	function processButtonClick(){
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
            switch(srcName) {
				case "btn_ok":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_Close":
					ComClosePopup();
					break;
            } // end switch            
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
  /**
	* registering IBSheet Object as list <br>
	* adding process for list in case of needing batch processing with other items<br>
	* defining list on the top of source <br>
	* <br><b>Example :</b>
	* <pre>
	*     setSheetObject(sheetObj);
	* </pre>
	* @param {ibsheet} sheet_obj mandatory IBSheet Object
	* @return void
	* @author 
	* @version 2009.10.28
	*/
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
   /**
    * initializing sheet <br>
    * implementing onLoad event handler in body tag <br>
    * adding first-served functions after loading screen. <br>
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return void
    * @author 
    * @version 2009.05.17
    */
	function loadPage() {
		
   	 if (!opener) opener = window.dialogArguments;
   	 if (!opener) opener = window.opener;
   	 if (!opener) opener = parent;
  	 
		for(i=0;i<sheetObjects.length;i++){
			//Modify Environment Setting Function's name
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//Add Environment Setting Function
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		if (sheetObjects[0].RowCount()> 0){
			sheetObjects[0].SelectCell(1, "eff_dt");
		}
	}
    /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets  <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} sheetNo mandatory IBSheet Object Serial No
     * @return void
     * @author 
     * @version 2009.05.22
     */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
     	switch(sheetID) {
        case "sheet1":      //t1sheet1 init
            with(sheetObj){
	          var HeadTitle="|Amend No.|Effective Date|1|2|3|4|5|6|7|8|9";
	          var headCount=ComCountHeadTitle(HeadTitle);
	
	          SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                 {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Date",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",            KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pub_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_inlnd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"trf_inlnd_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bef_eff_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt" } ];
	           
	          InitColumns(cols);
	
	          SetEditable(1);
	          SetCountPosition(0);
	          SetWaitImageVisible(0);
	          resizeSheet(); //SetSheetHeight(42);
            }


            break;            
     	}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}

  /**
   * Handling sheet's processes <br>
   * <br><b>Example :</b>
   * <pre>
   *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
   * </pre>
   * @param {ibsheet} sheetObj mandatory IBSheet Object
   * @param {form} formObj mandatory html form object
   * @param {int} sAction mandatory,Constant Variable
   * @return void
   * @author 
   * @version 2009.05.22
   */
 	function doActionIBSheet(sheetObj, formObj, sAction) {
 		try {
	 		sheetObj.ShowDebugMsg(false);
	 		switch (sAction) {																		
		 		case IBSEARCH: // retrieving
					var sXml=opener.getSheetXml();
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					break;
	 			case IBSAVE: // Save
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				if (!ComPriConfirmSave()) {
						return false;
					}
	  				ComOpenWait(true);
	  				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "amdt_seq",parseInt(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")) + 1,0);
	  				
	  				var SaveStr = sheetObj.GetSaveString(1);
	 	   		    var param="f_cmd=" + MODIFY01 + "&"+SaveStr;
	 	   		    var rtnData = sheetObj.GetSaveData("ESM_PRI_3521GS.do", param);
	 	   		    sheetObj.LoadSaveData(rtnData);
	  				
	 				break;	 				
	 		}
 		}catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e);
 			}
 		}finally {
 			 ComOpenWait(false);
 		}
 	}
 	/**
 	 * Calling Function in case of OnSearchEnd event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj mandatory IBSheet Object
 	 * @param {string} ErrMsg mandatory from server
 	 * @return void
 	 * @author 
 	 * @version 2009.05.20
 	 */
 	function sheet1_OnSearchEnd(sheetObj, errMsg){
 		var formObj=document.form;
 		formObj.tariff_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")+"-"+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no");
 		formObj.inland_nm.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_nm");
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bef_eff_dt",sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt"),0);
 		//sheetObj.CellValue2(sheetObj.SelectRow, "amdt_seq") = parseInt(sheetObj.CellValue(sheetObj.SelectRow, "amdt_seq")) + 1;
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_sts_cd","I",0);
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "eff_dt","",0);
 	}
 	
 	/**
     * Calling function in case of OnSaveEnd event <br>
     * showing message in case of succesful saving<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2015.06.08
     */         
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {      
        if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
        	returnData=true;
        }
        if (returnData){
			ComPopUpReturnValue(returnData);
		}
    }

	/**
    * checking whether other user modified datas already about same s/c no.<BR>
    * Checking whether data modified by other user <br> 
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} sheetObj sheet object contains update date and key
    * @param {String} checkTpCd ,code to be define table to check update date
    *  
    * @return boolean , true :modified, false: not modified
    * @author 
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
    	var returnValue=false;
        /////////////////////////////////////////////////////////////////////
        // update date checking
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
								+ "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
								+ "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
								+ "&key3="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
								+ "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_seq")
								+ "&upd_dt="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "upd_dt");
	        var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   case "CHECK2" : //amend
		   var amdt_seq=parseInt(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq"));
	   		//checking if next seq is created already
	   		amdt_seq++;
	        var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_INLND&page_name=Inland Rates"
								+ "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
								+ "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
						        + "&key3="+amdt_seq
								+ "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_inlnd_seq")
								+ "&upd_dt="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "upd_dt");
	        var cXml=sheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	sheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   }
       return returnValue;
        /////////////////////////////////////////////////////////////////////
    }
     /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *        handling logic
     *     }
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : inValid
     * @author 
     * @version 2009.04.17
     */
 	function validateForm(sheetObj, formObj, sAction) {
 		switch (sAction) {
 		case IBSEARCH: // retrieving
			break;
   		case IBSAVE:
			var effDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt");
			var bExpDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "exp_dt");
			var bEffDt=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bef_eff_dt");
   			if(effDt == "") {
   				ComShowCodeMessage("PRI00316", "Effective Date");
   				sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
   				return false;
   			}  
   			if(bEffDt >= effDt) {
   				ComShowCodeMessage("PRI00354", "previous amendment Seq. effective date");
   				sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
   				return false;
   			}
   			/*
   			if(bExpDt != "" && bExpDt < effDt) {
   				ComShowCodeMessage("PRI00353", "tariff rule expiration date");
   				sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
   				return false;
   			}
   			*/
			/////////////////////////////////////////////////////////////////////
	        // update date checking
	        if( checkChangingUpdateDate(sheetObj, "CHECK2") ){
	        	return false;
	        }
	        /////////////////////////////////////////////////////////////////////
 			break;
 		}
 		return true;
 	}
