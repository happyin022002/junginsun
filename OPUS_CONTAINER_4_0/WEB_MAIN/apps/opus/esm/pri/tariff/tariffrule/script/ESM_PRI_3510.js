/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3510.js
*@FileTitle : Tariff Rule Publish
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    // Common Global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    //retrieving main in case of "Y"
    var returnData=false;
	  //flag for saving message
	  var supressConfirm=false;
	  var opener;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    /**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2010.10.19
     */
	function processButtonClick(){
         var sheetObject1=sheetObjects[0];          
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);

					break;
				case "btn_Close":
					ComPopUpReturnValue(returnData);
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
     * registering IBSheet Object as list <br>
     * adding process for list in case of needing batch processing with other items  <br>
     * defining list on the top of source <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj Mandatory IBSheet Object
     * @return N/A
     * @author 
     * @version 2010.10.19
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
    * @return N/A
	* @author 
	* @version 2010.10.19
    */
	function loadPage() {
		
		if (!opener) opener = window.dialogArguments;
	   	if (!opener) opener = window.opener;
	   	if (!opener) opener = parent;
   	 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		if (sheetObjects[0].RowCount()> 0){
			sheetObjects[0].SelectCell(1, "pub_dt");
		}				
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
     * @version 2010.10.19
     */
	function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //t1sheet1 init
                with(sheetObj){
            	var HeadTitle="|Amend No.|Effective Date|Expiration Date|Publish Date|1|2|3|4|5|6|7";
            	var headCount=ComCountHeadTitle(HeadTitle);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"pub_dt",               KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"trf_pfx_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_rule_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"trf_rule_amdt_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trf_rule_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bef_pub_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"upd_dt" } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetWaitImageVisible(0);
              resizeSheet(); //SetSheetHeight(65);
              }
                break;
        }
    }
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}

	
    /**
     * Handling Sheet's process <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,process constant variable
     * @return N/A
     * @author 
     * @version 2010.10.19
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        try{
        	switch(sAction) {
            case IBSEARCH:               	
            	
            	var sXml=opener.getSheetXml();
            	sheetObj.LoadSearchData(sXml,{Sync:1} );
            	break;
 			case IBSEARCH_ASYNC01: // SYSDATE
	 			formObj.f_cmd.value=SEARCHLIST10;	 
	 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj));
 		       	var sValue=ComGetEtcData(sXml,"SYSDATE"); 		       	
 		       	return sValue;
 				break;
            case IBSAVE:      
 			 	if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
 			 	var sRow=sheetObj.GetSelectRow();
 			 	var effDt=sheetObj.GetCellValue(sRow, "eff_dt");
 			 	var pubDt=sheetObj.GetCellValue(sRow, "pub_dt");
 	   			var ret=ComGetDaysBetween(effDt, pubDt);
 	   			if(ret > 0) {
	 	   			if(!ComShowCodeConfirm("PRI06007")) {
	 	   				return false;	
	 	   			}
	 	   			ComOpenWait(true);	 	   			
	 	   			sheetObj.SetCellValue(sRow, "eff_dt",pubDt,0);
	 	   			sheetObj.DoAllSave("ESM_PRI_3510GS.do", "f_cmd=" + MODIFY05);
 	   			} else {
	 	   			if(!ComShowCodeConfirm("PRI06005", "Tariff Rule")) {
	 			 		return false;
	 			 	}
	 	   			ComOpenWait(true);	 	   			
	 	   			sheetObj.DoAllSave("ESM_PRI_3510GS.do", "f_cmd=" + MODIFY05);
 	   			}
 	        	window.close();
              	break;
        	}        	 
        } catch (e) {
        	if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }finally{
        	ComOpenWait(false); //->waiting->End
        }
    }
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,process constant variable
     * @returns bool <br>
     *          true  : Valid<br>
     *          false : Invalid
     * @author 
     * @version 2010.10.19
     */
   	function validateForm(sheetObj, formObj, sAction) {
   		switch (sAction) {
	   		case IBSEARCH: 
	   			break;
	   		case IBSAVE: 
	   			var sRow=sheetObj.GetSelectRow();
	   			var effDt=sheetObj.GetCellValue(sRow, "eff_dt");
	   			var expDt=sheetObj.GetCellValue(sRow, "exp_dt");
	   			var pubDt=sheetObj.GetCellValue(sRow, "pub_dt");
	   			var befPubDt=sheetObj.GetCellValue(sRow, "bef_pub_dt");
	   			var ruleTpCd=sheetObj.GetCellValue(sRow, "trf_rule_amdt_tp_cd");
	   			//Mandatory
	   			if(pubDt == "") {
	   				ComShowCodeMessage("PRI00316", "Publish Date");
	   				sheetObj.SelectCell(sRow, "pub_dt");
	   				return false;
	   			}
	   			//SYSDATE
//	   			var curDate=doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01); 	   			
//	   			if(pubDt < curDate) {
//	 	   			ComShowCodeMessage("PRI06008", ComGetMaskedValue(curDate, "ymd"));
//	   				sheetObj.SelectCell(sRow, "pub_dt");
//	   				return false;
//	   			}
	   			//Inputting before 9 days
//	   			var psret=ComGetDaysBetween(curDate, pubDt);	   			
//	   			if(psret > 9) {
//	 	   			ComShowCodeMessage("PRI06009");
//	   				sheetObj.SelectCell(sRow, "pub_dt");
//	   				return false;
//	   			}
	   			//Publish date must be later than previous amendment Seq. publish date
//	   			if(befPubDt != "" && befPubDt >= pubDt) {
//	   				ComShowCodeMessage("PRI06008", "previous amendment Seq. publish date");
//	   				sheetObj.SelectCell(sRow, "pub_dt");
//	   				return false;
//	   			}
	   			//Please check effective date (30 day validation)
//	   			var ret=ComGetDaysBetween(effDt, pubDt);
//	   			if(ruleTpCd == "A" || ruleTpCd == "I") {
//	   				if(ret > -30) {
//	   					ComShowCodeMessage("PRI06006");
//	   					return false;   					
//	   				}
//	   			}
				/////////////////////////////////////////////////////////////////////
		        // update date
		        if( checkChangingUpdateDate(sheetObj, "CHECK1") ){
		        	return false;
		        }
		        /////////////////////////////////////////////////////////////////////
		        break;
   		}
 		return true;
   	}
 	/**
 	 * calling function in case of OnSearchEnd event <br>
 	 * <br><b>Example :</b>
 	 * <pre>
 	 *
 	 * </pre>
 	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 	 * @param {string} ErrMsg Mandatory from server
 	 * @return N/A
 	 * @author 
 	 * @version 2010.10.19
 	 */
 	function sheet1_OnSearchEnd(sheetObj, code ,errMsg){
 		if(sheetObj.RowCount() ==0 ) return;
 		var formObj=document.form;
		formObj.tariff_cd.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")+"-"+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no");
		formObj.rule_no.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no");
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "trf_rule_sts_cd" , "F" , 0);//Publish
 		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pub_dt",ComGetNowInfo(),0);
 	}
   /**
    * Calling function in case of OnSaveEnd Event <br>
    * Setting update flag to "Y" after saving <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {string} ErrMsg Mandatory from server
    * @return N/A
	* @author 
 	* @version 2010.10.19
    */ 	
	function sheet1_OnSaveEnd(sheetObj, code ,ErrMsg)  {
		if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
   	 		returnData=true;
   	 	}
		
		if (returnData){
			ComPopUpReturnValue(returnData);
				ComClosePopup(); 
		}
	} 
	/**
    * Checking whether other user process(amend,request) same contract number after retrieving <br>
    * <br><b>Example :</b>
    * <pre>
    *     (sheetObjects[0],"CHECK1");
    * </pre>
    * @param {object} checkSheetObj
    * @param {String} checkTpCd
    *  
    * @return boolean ,  true : Modification, false: No modification
    * @author 
    * @version 2010.06.29
    */
   function checkChangingUpdateDate(sheetObj, checkTpCd ){
    	var returnValue=false;
        /////////////////////////////////////////////////////////////////////
	   switch(checkTpCd){
	   case "CHECK1" :
	        var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
+ "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
+ "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
+ "&key3="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq")
+ "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no")
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
	   		//Checking whether next seq is created already or not
	   		//amdt_seq++;
	        var checkParam="f_cmd="+SEARCHLIST08+"&table_name=PRI_TRF_RULE&page_name=Tariff Rule"
+ "&key1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_pfx_cd")
+ "&key2="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_no")
	        + "&key3="+amdt_seq
+ "&key4="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "trf_rule_no")
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
