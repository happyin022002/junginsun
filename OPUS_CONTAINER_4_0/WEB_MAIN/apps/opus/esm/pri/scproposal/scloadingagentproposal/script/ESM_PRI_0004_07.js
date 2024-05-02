/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_07.js
*@FileTitle  : S/C Proposal Loading Agent - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // Common Global variable
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var tabLoad=new Array();
 tabLoad[0]=0;
 tabLoad[1]=0;
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
  * @version 2009.10.28
  */
 function processButtonClick(){
     var sheetObject1=sheetObjects[0];
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
			case "btn_retrieve":
				if(validateForm(sheetObject1,formObject,IBSEARCH)) {
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				} 
				break;
        } // end switch
	}catch(e) {
		if (e == "[object Error]") {
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
   * @return N/A
   * @author 
   * @version 2009.05.17
   */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         resizeSheet();
 		 loadSts=true;
 		 parent.loadTabPage();
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
      * @version 2009.05.22
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
 		 var formObj=document.form;
         switch(sheetID) {             
             case "sheet1":
           	    with(sheetObj){
	               var HeadTitle="|Sel.|Seq.|lodg_agn_seq|amdt_seq|Customer Code|Customer Code|Mannual Input|Customer Name|Address|Location" +
	               "|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date" +
	               "|1|2|3|4|5";
	               var headCount=ComCountHeadTitle(HeadTitle);
	
	               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	               var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	               var headers = [ { Text:HeadTitle, Align:"Center"} ];
	               InitHeaders(headers, info);
	
	               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lodg_agn_seq" },
	                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
	                      {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:2 },
	                      {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	                      {Type:"CheckBox",  Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"mnl_inp_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0, Width:270,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cust_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                      {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:0, Width:140,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                      {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
	                      {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
	                      {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl" },
	                      {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl" },
	                      {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
	                
	               InitColumns(cols);
	
	               SetEditable(0);
	               SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
	               SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
	               SetEllipsis(1);
	               SetWaitImageVisible(0);
	               //SetShowButtonImage(2);
	               //SetAutoRowHeight(0);
	               resizeSheet(); //SetSheetHeight(310);
               }


                break
         }
     }
     
     function resizeSheet() {
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
      * @version 2009.05.22
      */
      function doActionIBSheet(sheetObj,formObj,sAction) {
    	  try {
	          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {
	 	        case IBSEARCH:
	  				ComOpenWait(true);
	 	         	formObj.f_cmd.value=SEARCH01;
 	 				sheetObj.DoSearch("ESM_PRI_0004_07GS.do", FormQueryString(formObj) );
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
     	* registering IBTab Object as list <br>
     	* adding process for list in case of needing batch processing with other items  <br>
     	* defining list on the top of source <br>
     	* <br><b>Example :</b>
     	* <pre>
     	*     setTabObject(tab_obj);
     	* </pre>
     	* @param {ibtab} tab_obj Mandatory IBTab Object
     	* @return N/A
     	* @author 
     	* @version 2009.10.28
     	*/
      function setTabObject(tab_obj){
          tabObjects[tabCnt++]=tab_obj;
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
        * @version 2009.04.17
        */
       function validateForm(sheetObj,formObj,sAction){
    		switch (sAction) {
   		case IBSEARCH: 
 	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
 				return false;
 			}
   			break;
   		}	
         return true;
       }
  	   /**
   	    * Calling function in case of OnClick event <br>
   	    * Calling ComShowMemoPad() in case of multi-line<br>
   	    * <br><b>Example :</b>
   	    * <pre>
   	    *	
   	    * </pre>
   	    * @param {ibsheet} sheetObj Mandatory IBSheet Object
   	    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
   	    * @param {int} Col Mandatory OnPopupClick ,Cell's Column Index
   	    * @return N/A
   	    * @author 
   	    * @version 2009.04.17
   	    */  
   	    function sheet1_OnClick(sheetObj, Row, Col, Value) {
   		    //showing memopad for description (MemoPad : Editable)
   		    var colname=sheetObj.ColSaveName(Col);
   	     	switch(colname)
   	     	{
   	 	    	case "cust_addr":
   	 	    		sheetObj.SetCellEditable(Row,"cust_addr",0);
   	 	    		ComShowMemoPad(sheetObj, Row, Col, true, 200);
   	 	    		break;
   	     	}
   	    }
	     /**
	      * Calling function in case of clicking tab on parent screen <br>
	      * <br><b>Example :</b>
	      * <pre>
	      * tabLoadSheet("ACE", "1")
	      * </pre>
	      * @param {string} sPropNo Mandatory prop_no 
	      * @param {string} sAmdtSeq Mandatory amdt_seq 
	      * @param {string} sSvcScpCd Mandatory svc_scp_cd 
	      * @param {string} sConChk Mandatory Conversion check 
	      * @return N/A
	      * @author 
	      * @version 2009.05.21
	      */ 
	     function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk) {
	     	var formObject=document.form;
	     	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	     		formObject.prop_no.value=sPropNo;
	     		formObject.amdt_seq.value=sAmdtSeq;
	     		formObject.svc_scp_cd.value=sSvcScpCd;
	     		formObject.con_chk.value=sConChk;
  				doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	     	}
	     }	
 		/**
	     * Clearing controls of tab screen on parent screen <br>
	     * <br><b>Example :</b>
	     * <pre>
	     * tabClearSheet()
	     * </pre>
	     * @param N/A
	     * @return N/A
	     * @author 
	     * @version 2009.05.20
	     */ 
  		function tabClearSheet() {
  			var formObject=document.form;
  			formObject.prop_no.value="";
  			formObject.amdt_seq.value="";
  			formObject.svc_scp_cd.value="";  			
  			sheetObjects[0].RemoveAll();
  		}
  		var enableFlag=true;
 		/**
 	     * Calling from main<br>
 	     * if Confirmation=YES,Disable to add,modify,delete. <br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     * tabEnableSheet(flag)
 	     * </pre>
 	     * @param {boolean} flag Mandatory from main
 	     * @return N/A
 	     * @author 
 	     * @version 2009.04.17
 	     */
  		function tabEnableSheet(flag) {
  			var formObject=document.form;  			
  			enableFlag=flag;  			
  			//sheetObjects[0].Editable = flag;
  		}
  		
	     var loadSts=false;
 		/**
 	     * Calling from main<br>
 	     * if Confirmation=YES,Disable to add,modify,delete. <br>
 	     * <br><b>Example :</b>
 	     * <pre>
 	     * tabEnableSheet(flag)
 	     * </pre>
 	     * @param {boolean} flag Mandatory from main
 	     * @return N/A
 	     * @author 
 	     * @version 2009.04.17
 	     */
	     function loadFinishCheck(){
	         return loadSts;
	     }    	     
