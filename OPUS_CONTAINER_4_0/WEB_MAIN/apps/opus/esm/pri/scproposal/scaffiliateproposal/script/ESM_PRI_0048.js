/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0048.js
*@FileTitle  : Proposal  Affiliates - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0048 : Business Script for ESM_PRI_0048
     */
//    function ESM_PRI_0048() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.validateForm=validateForm;
//    }
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event  handler processing by button click event */
 document.onclick=processButtonClick;
 /**
  * Event handler processing by button name  <br>
  * <br><b>Example :</b>
  * <pre>
  *     processButtonClick();
  * </pre>
  * @return void
  * @author 
  * @version 2009.04.17
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;          
     	try {
     		var srcName=ComGetEvent("name");     		
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
    			case "btn_DownExcel":
    				doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
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
     * @version 2009.04.17
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
      * @version 2009.04.17
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
         //Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
         }
		var formObj=document.form;
		formObj.hdr_eff_dt.focus();
		formObj.hdr_exp_dt.focus();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
 		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }
        
      /**
       * Handling OnKeyPress<br>
       * <br><b>Example :</b>
       * <pre>
       *     obj_keypress()
       * </pre>
       * @param  void
       * @return void
       * @author 
       * @version 2009.04.17
       */  
	function obj_keypress() {
		switch (event.srcElement.dataformat) {
		case "float":
				ComKeyOnlyNumber(ComGetEvent(), ".");
				break;
		default:
			ComKeyOnlyNumber(ComGetEvent());
			break;
		}
	}
    /**
    * handling OnBeforeActivate event<br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_activate()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */   	
	function obj_activate() {
	    var srcName=ComGetEvent("name");
	    ComClearSeparator(ComGetEvent());
	}
   /**
    * Handling Onbeforedeactivate event<br>
    * <br><b>Example :</b>
    * <pre>
    *     obj_deactivate()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */       
	function obj_deactivate() {
	    ComChkObjValid(ComGetEvent());
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
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         var sheetID=sheetObj.id;
         var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {
             case "sheet1":      //t1sheet1 init
                 with (sheetObj) {
	                
	                 var HeadTitle="|Seq.|propno|amdtseq|afilseq|Customer code|Customer code|Mannual\nInput|Customer Name|Address|Location|Effective Date|Expiry Date|Source|Status|prc_prog_sts_dtl|acpt_usr_id|acpt_ofc_cd|Accept Staff/Team|Accept Date|cust_cnt_cd_tmp|cust_seq_tmp|n1st_cmnc_amdt_seq";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	
	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"afil_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                  {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:6 },
	                  {Type:"CheckBox",  Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mnl_inp_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:0,  Width:180,  Align:"Left",    ColMerge:1,   SaveName:"cust_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
	                  {Type:"Text",      Hidden:0,  Width:165,  Align:"Left",    ColMerge:1,   SaveName:"cust_addr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cust_loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
	                  {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd_tmp",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
	                  {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq_tmp",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  
	                 InitColumns(cols);
	                 SetEditable(0);
	                 resizeSheet(); //SetSheetHeight(130);
	                 SetEllipsis(1);
	                 SetWaitImageVisible(0);
	                 //SetShowButtonImage(2);
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
       * @version 2009.04.17
       */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
             switch(sAction) {
 				case IBSEARCH_ASYNC01: // Retrieving			
	 				sheetObj.SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
	 				//	status
	 				sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
	 				break; 				
	 			case IBSEARCH: // retrieving
	 				ComOpenWait(true); //->waiting->start
	 				formObj.f_cmd.value=SEARCH01;
 	 				sheetObj.DoSearch("ESM_PRI_0048GS.do", FormQueryString(formObj) );
	 				ComOpenWait(false); //->waiting->End
	 				break;
				case IBDOWNEXCEL:
					if(sheetObj.RowCount() < 1){
						ComShowCodeMessage("COM132501");
						}else{
							sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
						}
					break;
             }
         } catch (e) {
           	if (e == "[object Error]") {
                   ComShowMessage(OBJECT_ERROR);
               } else {
                   ComShowMessage(e.message);
               }
          }finally{
	          if (sAction == IBSEARCH_ASYNC01) {
	        	  return;
	          }
	          ComOpenWait(false); //->waiting->End
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
		var sCols="";
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
  			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
  				return false;
  			} else {
  				return true;
  			}
  			break;
  		}
  	}
     /**
     * Calling function in case of Onclick event <br>
     * Showing memopad for address inputting<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col Mandatory OnClick ,Cell's Column Index 
     * @param {str} Value without Value Mandatory Format when saving 
     * @return void
     * @author 
     * @version 2009.06.03
     */  	           
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
	    var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
     		case "cust_nm": 
     		case "cust_addr":
     			ComShowMemoPad(sheetObj, Row, Col, true, 450, 80);
 	    		break;
     		case "acpt_usr_nm":
 	    		if (sheetObj.GetCellValue(Row,"acpt_usr_id")!=""){
 	    			ComUserPopup(sheetObj.GetCellValue(Row,"acpt_usr_id"));
 	    		}
 	    		break;
     	}    	 
    }    