/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3518.js
*@FileTitle  : Tariff General Information Amend Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
					if (returnData){
						ComPopUpReturnValue(returnData);
					}
					break;
				case "btn_close":
					ComPopUpReturnValue(returnData);
					break;
            } // end switch            
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
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
		for(i=0;i<sheetObjects.length;i++){
			//Modify Environment Setting Function's name
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//Add Environment Setting Function
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);		
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
        		var HeadTitle="||Amend No.|Effective Date|1|2|3|4|5|";
        		var headCount=ComCountHeadTitle(HeadTitle);
        		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
        		var info={ Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        		var headers=[ { Text:HeadTitle, Align:"Center"} ];
        		InitHeaders(headers, info);
        		var cols=[ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
        		           {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt" },  
        		           {Type:"Text",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"amdt_seq",    KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		           {Type:"Date",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",      KeyField:1,   CalcLogic:"",   Format:"Ymd",  PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        		           {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd",  KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		           {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_no",      KeyField:0,   CalcLogic:"",   Format:"",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		           {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"pub_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		           {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
        		           {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:1,   SaveName:"bef_eff_dt",  KeyField:1,   CalcLogic:"",   Format:"Ymd",  PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
        		             ];
        		InitColumns(cols);
        		SetEditable(1);
        		SetCountPosition(0);
        		SetWaitImageVisible(0);
        		SetSheetHeight(75);
        	}
            break;            
     	}
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
					var sXml=parent.getSheetXml();					
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					break;
	 			case IBSAVE: // Save
	 				if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	 				if (!ComPriConfirmSave()) {
						return false;
					}
	  				ComOpenWait(true);
	  				var sParam=sheetObj.GetSaveString(true);
	  				var sXml = sheetObj.GetSaveData("ESM_PRI_3518GS.do", "f_cmd=" + MODIFY01+"&"+sParam);
	  				if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S") {
	  					returnData = true;  
			        } 
	 				break;	 				
	 		}
 		}catch(e){
 			if (e == "[object Error]") {
 				ComShowMessage(OBJECT_ERROR);
 			} else {
 				ComShowMessage(e.message);
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
 		if (sheetObjects[0].RowCount()> 0){
			sheetObjects[0].SelectCell(1, "eff_dt");
		}
 		
 		var formObj=document.form;
 		formObj.tariff_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")+"-"+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no");
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bef_eff_dt", sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eff_dt"),0);
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "amdt_seq",parseInt(sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")),0);
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "eff_dt","",0);
 	}
    /**
     * calling function when occurring OnSaveEnd event <br>
     * After save completed, Set "Y" to Modification Flag. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2010.10.19
     */ 	
    /**
    * checking whether other user modified datas already about same s/c no.<BR>
    * It checks whether data in the same contract number has already modified by another user. <BR>
    * <br><b>Example :</b>
    * <pre>
    *     checkChangingUpdateDate(sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} checkSheetObj ,sheet object with update date,key
    * @param {String} checkTpCd ,code to be define table to check update date
    *  
    * @return boolean , true :modified, false: not modified
    * @author 
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(checkSheetObj, checkTpCd ){
    	var returnValue=false;
        /////////////////////////////////////////////////////////////////////
        // update date checking
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam="f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC&page_name=Tariff General Information"
	        						+ "&key1="  + checkSheetObj.GetCellValue(1, "trf_pfx_cd")
	        						+ "&key2="  + checkSheetObj.GetCellValue(1, "trf_no")
	        						+ "&key3="  + checkSheetObj.GetCellValue(1, "amdt_seq")
	        						+ "&upd_dt="+ checkSheetObj.GetCellValue(1, "upd_dt");
//parameter changed[check again]CLT 	        
	        var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:1} );
	        	ComOpenWait(false); //->waiting->End
	        	returnValue=true;
	        }
	        break;
	   case "CHECK2" : //amend
		   var amdt_seq=parseInt(checkSheetObj.GetCellValue(1, "amdt_seq"));
	   		//checking if next seq is created already
	   		amdt_seq++;
	        var checkParam="f_cmd="  + SEARCHLIST08+"&table_name=PRI_TRF_BZC&page_name=Tariff General Information"
	        						+ "&key1="  + checkSheetObj.GetCellValue(1, "trf_pfx_cd")
	        						+ "&key2="  + checkSheetObj.GetCellValue(1, "trf_no")
	        						+ "&key3="  + amdt_seq
	        						+ "&upd_dt="+ checkSheetObj.GetCellValue(1, "upd_dt");
//parameter changed[check again]CLT 	        
	        var cXml=checkSheetObj.GetSearchData("PRICommonGS.do" , checkParam);
	        if (ComGetEtcData(cXml, ComWebKey.Trans_Result_Key) == "F" ){
	        	checkSheetObj.LoadSearchData(cXml,{Sync:1} );
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
   			// Mandatory Input
   			if(effDt == "") {
   				ComShowCodeMessage("PRI00316", "Effective Date");
   				sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
   				return false;
   			}  
   			// Current Sequence's EFF_DT > Previous Sequence's EFF_DT 
   			if(bEffDt >= effDt) {
   				ComShowCodeMessage("PRI00354", "previous amendment Seq. effective date");
   				sheetObj.SelectCell(sheetObj.GetSelectRow(), "eff_dt");
   				return false;
   			}
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
