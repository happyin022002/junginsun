/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0023.js
*@FileTitle  : Boiler Plate Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
// When there is no data after retrieve, Copy the data from guideline and set the flag to True. Prevent to showing Copy message when retrieve again.
 var GUIDELINE_COPY=false;
 var rData="N";
 var opener;
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
  * @version 2009.04.17
  */
     function processButtonClick(){
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          var sheetObject3=sheetObjects[2];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_RowAdd": 					
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
 				case "btn_RowDelete":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;
 				case "btn_Amend":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND01);
					break;
 				case "btn_AmendCancel":
					doActionIBSheet(sheetObjects[0],document.form,COMMAND02);
					break; 					
 				case "btn_Accept":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY01);
					break;					
 				case "btn_AcceptCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY02);
					break; 					
 				case "btn_RowAdd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
 				case "btn_RowDelete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					break;
 				case "btn_Amend2":
 					doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
 					break;
 				case "btn_AmendCancel2":
 					doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
 					break;
 				case "btn_Accept2":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
					break;				
 				case "btn_AcceptCancel2":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
					break; 					
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 					break;
 				case "btn_Save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 					break;
 				case "btn_AcceptAll":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY05);
					break;
 				case "btn_AcceptAllCancel":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY06);
					break;
 				case "btn_glinecopy":
					doActionIBSheet(sheetObjects[0],document.form,MODIFY07);
					break;					
 				case "btn_DownExcel":
 					doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
 					break;
 				case "btn_LoadExcel":
 					// Check whether modified data exist on data sheet 1, 2
 					if(sheetObjects[0].IsDataModified()== false && sheetObjects[1].IsDataModified()== false){
 						var formObj=document.form;				
 						if (formObj.prop_no.value =="" && formObj.amdt_seq.value ==""){
 							ComShowCodeMessage('PRI01055');
 							return;
 						}
 		   	    		var sPropNo=formObj.prop_no.value;
 						var sAmdtSeq=formObj.amdt_seq.value;
 						var sEffDt=formObj.eff_dt.value;
 						var mBlplSeq=0;
 						var mDpSeq=0;
 						// Find maximum value of blpl seq  and dp_seq
 						if (sheetObjects[0].RowCount()> 0) {
	 						for(i=1; i<=sheetObjects[0].RowCount();i++){
	 							if(mBlplSeq < parseInt(sheetObjects[0].GetCellValue(i,"blpl_seq"), 10)) {
	 								mBlplSeq=parseInt(sheetObjects[0].GetCellValue(i,"blpl_seq"), 10);
 								}
	 							if(mDpSeq < parseInt(sheetObjects[0].GetCellValue(i,"dp_seq"), 10)) {
	 								mDpSeq=parseInt(sheetObjects[0].GetCellValue(i,"dp_seq"), 10);
 								}
	 						}
 						}
 						var sParam="sPropNo="+sPropNo+"&sAmdtSeq="+sAmdtSeq+"&mBlplSeq="+mBlplSeq+"&mDpSeq="+mDpSeq;				
 		   	    		ComOpenPopup("ESM_PRI_0074.do?"+sParam, 1000, 570, "loadExcel_returnVal", "none", false);
 					} else {
 						ComShowCodeMessage('PRI01057');
 						return;
 					}
 					break;
 				case "btn_Close":
 					 ComPopUpReturnValue(rData);
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
     
     function loadExcel_returnVal() {
    	 rData="Y";
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
  		axon_event.addListenerForm('beforeactivate', 'obj_activate', document.form);
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		axon_event.addListenerFormat ('keypress', 'obj_keypress', document.form);         
		var formObj=document.form;
		formObj.hdr_eff_dt.focus();
		formObj.hdr_exp_dt.focus();
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
		 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 buttonControl();
     }
  	/**
  	 * Handling body tag's unonLoad event handler <br>
  	 * adding the functions when screen is closing.<br>
  	 * <br><b>Example :</b>
  	 * <pre>
  	 *     unloadPage();
  	 * </pre>
  	 * @return void
  	 * @author 
  	 * @version 2009.08.17
  	 */      
	 function unloadPage(){
		 ComPopUpReturnValue(rData);
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
				ComKeyOnlyNumber(event.srcElement, ".");
				break;
		default:
			ComKeyOnlyNumber(event.srcElement);
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
		//var formObject = document.form;
	    var srcName=ComGetEvent("name");
	    ComClearSeparator (event.srcElement);
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
	    ComChkObjValid(event.srcElement);
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
             case "sheet1":
                 with (sheetObj) {
                 var HeadTitle="|Sel.|Seq.|propno|amdtseq|blplseq|Title|Effective Date|Effective Date|Source|Source|Status|Status|dpseq|acpt_usr_id|acpt_ofc_cd|acpt_dt|n1st_cmnc_amdt_seq|maxdpseq|maxdpseqctnt";
                 var headCount=ComCountHeadTitle(HeadTitle);

                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			                  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 if (amdt_seq == "0"){
                	 cols.push({Type:"Text",      Hidden:0,  Width:430,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 });
                 }else{
                	 cols.push({Type:"Text",      Hidden:0,  Width:430,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 });
                 }
                 	cols.push({Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 	cols.push({Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 	cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 	cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 	cols.push({Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                 	cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"max_dp_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
	                 cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"max_dp_seq_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
      
                 InitColumns(cols);
                 SetEditable(1);
                 SetWaitImageVisible(0);
                 SetSheetHeight(240);
                }
                 break;
                 
             case "sheet2":
                 with (sheetObj) {
                 var HeadTitle="|Sel.|Seq.|propno|amdtseq|blplseq|blplctntseq|Contents|Effective Date|Effective Date|Source|Source|Status|Status|usr_id|ofc_cd|acpt_dt|dp_seq|n1st_amdt_seq";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 (headCount, 0, 0, true);

                 SetConfig( { SearchMode:0, MergeSheet:5, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",              Wrap:1 },
               {Type:"DummyCheck", Hidden:0, Width:40,  Align:"Center",  ColMerge:0,   SaveName:"chk",                 Wrap:1 },
               {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                 Wrap:1 },
               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:0, Width:500,  Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
                  
                InitColumns(cols);
                SetEditable(1);
				SetWaitImageVisible(0);
				SetSheetHeight(180);
 			   	}			
                 break;
                 
             case "sheet3":// Use it to download excel
                 with (sheetObj) {
                 var HeadTitle="|Effective Date|Effective Date|Source|Status|Title|Contents";
                 var headCount=ComCountHeadTitle(HeadTitle);
                 (headCount, 0, 0, true);

                 SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

                 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            Wrap:1 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"eff_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"exp_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_dtl",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_dtl",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
                  {Type:"Text",      Hidden:0,  Width:420,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100,   Wrap:1 },
                  {Type:"Text",      Hidden:0,  Width:450,  Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   Wrap:1 } ];
                  
                 InitColumns(cols);

                SetEditable(1);
				SetWaitImageVisible(0);
				SetSheetHeight(150);
 			   	}			
                 break;
         }
     }
     /**
      * Calling Function in case of OnBeforeCheck event <br>
      * When Check Box clicked, ComPriCheckWithPnS function calls <br>od
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row Mandatory Cell's Row Index
      * @param {int} Col Mandatory Cell's Column Index
      * @return void
      * @author 
      * @version 2009.04.17
      */     	
  	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName=sheetObj.ColSaveName(Col);
  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
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
     	var amdt_seq=formObj.amdt_seq.value;
 		var eff_dt=formObj.eff_dt.value;
 		var sts=formObj.prop_sts_cd.value;
 		var req_usr_flg=formObj.req_usr_flg.value;
 		var apro_usr_flg=formObj.apro_usr_flg.value;
         if (errMsg == "") {
        	 if (sts == "I" && sheetObjects[0].RowCount()<= 0 && GUIDELINE_COPY == false && (req_usr_flg == "true" || apro_usr_flg == "true") ){
             	if (ComShowCodeConfirm("PRI01006")) {
             		GUIDELINE_COPY=true;
             		document.form.f_cmd.value=MULTI10;             	
             		var sXml=sheetObj.GetSaveData("ESM_PRI_0023GS.do", FormQueryString(document.form));
                     var saveOk=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);                     
                     formObj.blpl_hdr_seq.value=ComGetEtcData(sXml,"blpl_hdr_seq");                     
                     if (saveOk == "S"){
                    	 // Main Function Call
                    	 opener.comUpdateProposalStatusSummary("06", "");
                    	 doActionIBSheet(sheetObj, document.form, IBSEARCH);
                         if (sheetObjects[0].RowCount()> 0){
                        	 ComShowCodeMessage("PRI01017");    
                          	 rData="Y";
                          }else{
                          	 ComShowCodeMessage("PRI01019");
                          } 
                     }
             	} 	            
         	}        	 
         	setHeader();
         }
         var cols="blpl_tit_nm";
         searchEndFontChange(sheetObj, cols,document.form.lgcy_if_flg.value);        
 	}  	     
     /**
     * calling function when occurring OnSaveEnd event <br>
     * After save completed, Define the font style of sheet and set "Y" to modification flag. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.04.17
     */ 	
 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
 		var formObj=document.form;
    	 if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			var cols="blpl_tit_nm";
	        searchEndFontChange(sheetObj, cols)	
         	if (sheetObj.RowCount()<= 0){
         		formObj.blpl_hdr_seq.value="";         		
         	}
         	rData="Y";
		}
    	 sheetObj.ReNumberSeq();
	}     
    /**
     * calling function when occurring OnSaveEnd event <br>
     * Setting data modification flag to "Y" after saving<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory from server
     * @return void
     * @author 
     * @version 2009.04.17
     */ 	 	
 	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
 		if(sheetObj.GetEtcData(ComWebKey.Trans_Result_Key) == "S") {
			rData="Y";
		}
 		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	}  	
     /**
      * Calling Function in case of OnBeforeCheck event <br>
      * When Check Box clicked, ComPriCheckWithPnS function calls <br>od
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @param {int} Row Mandatory Cell's Row Index
      * @param {int} Col Mandatory Cell's Column Index
      * @return void
      * @author 
      * @version 2009.04.17
      */     	
  	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName=sheetObj.ColSaveName(Col);
  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
  		}
  	}
    /**
     * Calling Function in case of OnSearchEnd event <br>
     * After retrieve finish, define the font style of sheet and control button.
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
	function sheet2_OnSearchEnd(sheetObj, errMsg){
    	 searchEndFontChange(sheetObj, "",document.form.lgcy_if_flg.value);
    	 sheet_auto_size(sheetObjects[0]);
    	 sheet_auto_size(sheetObj);
         buttonControl();
         ComOpenWait(false);
	}  	  	
     /**
     * Calling function in case of Onclick event <br>
     * when specified cell of Sheet clicked, display the notepad window. <br>
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
     function sheet2_OnClick(sheetObj, Row, Col, Value) {
	    //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
	    var colname=sheetObj.ColSaveName(Col);
	    var amdtSeq=document.form.amdt_seq.value;
	    var eff_dt=document.form.eff_dt.value;
	    var sts=document.form.prop_sts_cd.value;
	    var readOnly=false;
	    var stsCd=sheetObj.GetCellValue(Row, "prc_prog_sts_cd");
     	switch(colname)
     	{
 	    	case "blpl_ctnt":
 	    		if (amdtSeq == 0){
 	    			if (sts =="R" || sts =="Q"){
 	    				readOnly=true;   
 	    			}else{
						if (stsCd == "A"){
							readOnly=true;
						}else{
							readOnly=false;	
						}
 	    			} 	    			   			
 	    		}
 	    		else if(sheetObj.GetCellValue(Row, "n1st_cmnc_amdt_seq") == amdtSeq){
 	    			if (sheetObj.GetCellValue(Row , "src_info_cd") != "AD"){
 						if (sts =="R" || sts =="Q"){
 							readOnly=true;   
 						}else{
 							if (stsCd == "A"){
 								readOnly=true;
 							}else{
 								readOnly=false;	
 							} 							
 						} 		
  					}else{
 						readOnly=true; 						
 					}
 				}else{
 					readOnly=true; 					
 				} 	    		
 	    		ComShowMemoPad(sheetObj, Row, Col, readOnly, 665, 200);
 	    		break;
     	}    	 
    }     
       
     /**
     * calling function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *		sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} OldRow Mandatory ,previous selected cell's Row Index
     * @param {int} OldCol Mandatory Previous selected Cell's Column Index
     * @param {int} NewRow Mandatory ,current selected cell's Row Index
     * @param {int} NewCol Mandatory ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.04.17
     */        	
  	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
  		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
  	}      
  	var isFiredNested=false;
	var supressConfirm=false;	
	/**
	 * in case of modifying row on Sheet <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {form} formObj mandatory html form object
	 * @param {int} sAction mandatory,Constant Variable
	 * @returns bool <br>
	 *          true  : valid<br>
	 *          false : inValid
	 * @author 
	 * @version 2009.05.01
	 */	
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				if (validateForm(sheetM,document.form,IBSAVE)) {
					isFiredNested=true;
					sheetM.SelectCell(NewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (sheetD.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					adjNewRow = Math.max(NewRow - sheetM.RowCount("D"), sheetM.HeaderRows());
					var rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
					supressConfirm=false;
				}
				if (rslt) {
					isFiredNested=true;
					sheetM.SelectCell(adjNewRow, NewCol, false);
					isFiredNested=false;
				} else {
					isFiredNested=true;
					sheetM.SelectCell(OldRow, OldCol, false);
					isFiredNested=false;
					return -1;
				}
			}
			if (appendRow) {
				isFiredNested=true;
				var idx=sheetM.DataInsert();
				isFiredNested=false;
				return idx;
			} else {
				formObj.blpl_seq.value=sheetM.GetCellValue(adjNewRow, "blpl_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
			}
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
    * @version 2009.04.17
    */
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         try{
             switch(sAction) {
 			case IBSEARCH_ASYNC01: // setting Combo
 				sheetObj.SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
 				sheetObjects[1].SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
 	        	//status
  				sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
  				sheetObjects[1].SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
 				break;	              
 			case IBSEARCH: // Master Retrieve
 				sheetObj.ColumnSort();
 				ComOpenWait(true); //->waiting->start 
 				for (var i=0; i < sheetObjects.length; i++) {
 					sheetObjects[i].RemoveAll();
 				}				
 				formObj.blpl_ref_yr.value="";
 				formObj.f_cmd.value=SEARCH01; 				
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0023GS.do" , FormQueryString(formObj));
 				sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 				if (ComGetEtcData(sXml,"blpl_ref_yr") != undefined){
 					formObj.blpl_ref_yr.value=ComGetEtcData(sXml,"blpl_ref_yr");
 				} 				
 				if (ComGetEtcData(sXml,"blpl_hdr_seq") != undefined){
 					formObj.blpl_hdr_seq.value=ComGetEtcData(sXml,"blpl_hdr_seq");
 				}
 				ComOpenWait(false); //->waiting->End
 				break;
 			case IBSEARCHAPPEND: // detail Retrieve
 				ComOpenWait(true); //->waiting->start 
 				formObj.f_cmd.value=SEARCH02;
 				sheetObj.DoSearch("ESM_PRI_0023GS.do", FormQueryString(formObj), {Sync:2} );
 				ComOpenWait(false); //->waiting->End
 				break;
 			case IBSAVE: // Saving
 				ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 	        	for (var a=0; a <= 1; a++) {
 	        		for (var i=sheetObjects[a].HeaderRows(); i <= sheetObjects[a].LastRow(); i++) {
 	            		// if Proposal &src_info_cd= GC(Guideline Copy),  GM(Guideline Modification)
							if (sheetObjects[a].GetRowStatus(i) == "U"
							&& sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
							&& sheetObjects[a].GetCellValue(i, "src_info_cd") == "GC") {
 	            			sheetObjects[a].SetCellValue(i, "src_info_cd","GM");
 	            		}
 	            		// if Proposal &  src_info_cd = PC(Previous Contract),  PM(Previous Contract Modification)
							if (sheetObjects[a].GetRowStatus(i) == "U"
							&& sheetObjects[a].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value
							&& sheetObjects[a].GetCellValue(i, "src_info_cd") == "PC") {
 	            			sheetObjects[a].SetCellValue(i, "src_info_cd","PM");
 	            		}
 	        		}
 	        	}			
 	        	changeDpSeq_header (sheetObjects[0]);
 				formObj.f_cmd.value=MULTI01;
 				var sParam=FormQueryString(formObj); 				
 				var sParamSheet1=sheetObjects[0].GetSaveString();
 				if (sParamSheet1 != "") {
 					sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
 				}
 				var sParamSheet2=sheetObjects[1].GetSaveString();
 				if (sParamSheet2 != "") {
 					sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
 				}
 				if (!supressConfirm && !ComPriConfirmSave()) {
 					return false;
 				}
 				var sXml=sheetObj.GetSaveData("ESM_PRI_0023GS.do", sParam);
 				sheetObjects[1].LoadSaveData(sXml, true);
 				sXml=ComDeleteMsg(sXml);
 				sheetObjects[0].LoadSaveData(sXml, true);
 				ComOpenWait(false); //->waiting->End
 				if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
 					return false;
 				} else {
 					rData="Y";
 					opener.comUpdateProposalStatusSummary("06", "");
 			     	setHeader();
 			     	buttonControl(); 					
 					return true;
 				}
 				break;
 			case IBINSERT: // Row Add 			
 				var eff_dt=formObj.eff_dt.value;
 				var exp_dt=formObj.exp_dt.value;
 				if (validateForm(sheetObj,document.form,sAction)) {
 					if (sheetObj.id == "sheet1") {
 						var amdt_seq=formObj.amdt_seq.value;
 						if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=amdt_seq){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
 						var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
 						if (idx < 0) {
 							return false;
 						}
 						sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
 						sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
 						sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
 						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
 						sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value,0);
 						sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
 						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
 						if (idx == 1){
 							sheetObj.SetCellValue(idx, "max_dp_seq",0,0);
 						}else{
 							sheetObj.SetCellValue(idx, "max_dp_seq",sheetObj.GetCellValue(idx - 1, "max_dp_seq"));
 						}
 						sheetObjects[1].RemoveAll();
 						sheetObj.SetCellValue(idx, "blpl_seq",parseInt(ComPriGetMax(sheetObj, "blpl_seq")) + 1,0);
 						sheetObj.SelectCell(idx, "blpl_tit_nm");
 					}
 					if (sheetObj.id == "sheet2") {
 						if(sheetObjects[0].LastRow()==0){
 							ComShowCodeMessage("PRI01004");
 							return;							
 						}
 						var amdt_seq=formObj.amdt_seq.value;
 						if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=amdt_seq){
 							ComShowCodeMessage("PRI01002");
 							return;
 						}
 						var idx=sheetObj.DataInsert();
 						sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value,0);
 						sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
 						sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
 						sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value,0);
 						sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value,0);
 						sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
 						sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
 						var blpl_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "blpl_seq");
 						sheetObj.SetCellValue(idx, "blpl_seq",blpl_seq,0);
 						sheetObj.SetCellValue(idx, "blpl_ctnt_seq",parseInt(ComPriGetMax(sheetObj, "blpl_ctnt_seq")) + 1,0);
 						sheetObj.SetCellValue(idx, "max_dp_seq_ctnt",0,0);// it is value being queried. so, when you do input, it has no meaning.
 						if(amdt_seq!=0){
 							sheetObj.SetCellFont("FontColor", idx, "chk", idx, "prc_prog_sts_dtl","#FF0000");
 						}
 						sheetObj.SetCellValue(idx, "dp_seq", sheetObj.RowCount(),0);
 						sheetObj.SelectCell(idx, "blpl_ctnt");
 					}
 				}
 				break;
 			case IBDELETE: // Delete
 				
 				setTimeout(function(){ ComOpenWait(true); }, 10);
 				
 				setTimeout(function(){

 					//###################################################################
 					var amdt_seq=formObj.amdt_seq.value;		
 	 				var eff_dt=formObj.eff_dt.value; 		
 	 				if(amdt_seq=="0"){	
 	 					if (validateForm(sheetObj,document.form,sAction)) {
 	 						if (sheetObj.CheckedRows("chk") <= 0) {
 	 			        		//sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
 	 							ComShowCodeMessage("COM12176");
 	 							ComOpenWait(false);
 	 							return;
 	 			        	} 				
 	 						//--------------------------------
 	 		 				if (checkDelete(sheetObj) != "Y"){
 	 		 					ComShowCodeMessage('PRI01132');
 	 		 					ComOpenWait(false);
 	 		 					return;
 	 		 				}
 	 						//-------------------------------
 	 		 				if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
 	 						    sheetObjects[1].RemoveAll();
 	 						}
 	 						var delCnt=deleteRowCheck(sheetObj, "chk");
 	 						if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
 	 						    sheetObjects[1].RemoveAll();
 	 						}
 	 						if(sheetObj.id !="sheet1" && getValidRowCount(sheetObjects[1])==0 && ComShowCodeConfirm('PRI00017')){				
 	 							if(sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow())!= "I"){
 	 								sheetObjects[0].SetRowHidden(sheetObjects[0].GetSelectRow(), true);
 	 							}		
 	 							sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),"D");
 	 							if (getSearchRow(sheetObjects[0]) > 0){
 	 								formObj.blpl_seq.value=sheetObjects[0].GetCellValue(getSearchRow(sheetObjects[0]), "blpl_seq");
 	 								doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
 	 							}														 
 	 						}
 	 						ComOpenWait(false);	
 	 					}
 	 				}else{	 					
 	 					var eff_dt=formObj.eff_dt.value;
 	 					if (sheetObj.CheckedRows("chk") <= 0) {
 	 		        		//sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
 	 						ComShowCodeMessage("COM12176");
 	 						ComOpenWait(false);
 							return;
 	 		        	}
 	 					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 	 					if(chkArr.length > 0){	
 	 						for(var i=0;i < chkArr.length;i++){
 	 							if(sheetObj.GetCellValue(chkArr[i],"amdt_seq") != amdt_seq
 	 									|| ((sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="NW"
 	 										&&  sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="GC"
 	 											&&  sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="GM"
 	 												||  sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd") != "I" )
 	 												&&  sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq") == amdt_seq)){
 	 								ComShowCodeMessage("PRI01002");
 	 								ComOpenWait(false);
 	 								return;
 	 							}
 	 						}
 							//--------------------------------
 			 				if (checkDelete(sheetObj) != "Y"){
 			 					ComShowCodeMessage('PRI01132');
 			 					ComOpenWait(false);
 			 					return;
 			 				}
 							//-------------------------------
 	 						var editColumn="";
 	 						if (sheetObj.id == "sheet1"){
 	 							editColumn="blpl_tit_nm";
 	 						}else{
 	 							editColumn="blpl_ctnt";
 	 						}
 	 						var sRow=0;
 	 						for(var j=0;j < chkArr.length;j++){							
 	 							if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!= amdt_seq){
 	 								isFiredNested=true;
 	 								comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow, "D", editColumn);
 	 								if (sheetObj.id == "sheet1" && sRow == 0){
 	 									for (var i=sheetObjects[1].RowCount(); i > 0 ; i--){
 	 										// except already amended row									
 	 										if(sheetObjects[1].GetCellValue(i,"n1st_cmnc_amdt_seq")== amdt_seq && sheetObjects[1].GetCellValue(i,"src_info_cd")=="NW"){
 	 											sheetObjects[1].SetCellValue(i,"chk",1);
 	 										}else if(sheetObjects[1].GetCellValue(i,"amdt_seq")!= amdt_seq  ){
 	 											// 											sheetObjects[1].CellValue(i,"chk") = 1;
 	 										}else if (sheetObjects[1].GetCellValue(i,"n1st_cmnc_amdt_seq")== amdt_seq && sheetObjects[1].GetCellValue(i,"ibflag")!="I"){
 	 											comSheetAmendCancelRow(sheetObjects[1],formObj,i,"M", "blpl_ctnt");
 	 										}else{	
 	 											comSheetAmendRow(sheetObjects[1],formObj,i,"D","blpl_ctnt");
 	 										}										
 	 									}
 	 									deleteRowCheck(sheetObjects[1], "chk");
 	 								}
 	 								sRow++;
 	 							}
 	 						} 						
 	 						deleteRowCheck(sheetObj, "chk");
 	 						isFiredNested=false;
 	 					}else{ 				
 	 						if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!=amdt_seq
 	 								|| ( sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")==amdt_seq
 	 										&& (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd")!="NW"
 	 											|| sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd")!="I")	)){
 	 							ComShowCodeMessage("PRI01002"); 	
 	 							return;
 	 						}
 	 						//--------------------------------
 	 						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",1);
 	 		 				if (checkDelete(sheetObj) != "Y"){
 	 		 					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",0);
 	 		 					ComShowCodeMessage('PRI01132');
 	 		 					ComOpenWait(false);
 	 		 					return;
 	 		 				}
 	 		 				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk",0);
 	 						//-------------------------------
 	 		 				if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"n1st_cmnc_amdt_seq")!=amdt_seq){
 	 							comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"D","");
 	 							if (sheetObj.id == "sheet1"){		
 	 								for (var i=sheetObjects[1].RowCount(); i > 0 ; i--){
 	 									// except already amended row
 	 									if(sheetObjects[1].GetCellValue(i,"amdt_seq")!= amdt_seq || sheetObjects[1].GetCellValue(i,"n1st_cmnc_amdt_seq")== amdt_seq){
 	 										sheetObjects[1].SetCellValue(i,"chk",1);
 	 									}else{	
 	 										comSheetAmendRow(sheetObjects[1],formObj,i,"D","blpl_ctnt");
 	 									}
 	 								}			
 	 								deleteRowCheck(sheetObjects[1], "chk");
 	 							}
 	 						}else{
 	 							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk",1);
 	 							deleteRowCheck(sheetObj, "chk");
 	 							if (sheetObj.id == "sheet1"){
 	 								for (var i=1 ; i <= sheetObjects[1].RowCount(); i++){
 	 									sheetObjects[1].SetCellValue(i,"chk",1);
 	 								}
 	 								deleteRowCheck(sheetObjects[1], "chk");
 	 							}
 	 						}	
 	 					}					
 	 				}
 	 				if(sheetObj.id !="sheet1" &&  getValidRowCount(sheetObjects[1])==0 && ComShowCodeConfirm('PRI00017')){
 	 					if(sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow())!="I"){
 	 						sheetObjects[0].SetRowHidden(sheetObjects[0].GetSelectRow(), true);
 	 					}			
 	 					sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),"D");
 	 					if (getSearchRow(sheetObjects[0]) > 0){
 	 						formObj.blpl_seq.value=sheetObjects[0].GetCellValue(getSearchRow(sheetObjects[0]), "blpl_seq");
 	 						doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
 	 					}
 	 				}
 	 				
 	 				//###################################################################
 	 				
 	 				ComOpenWait(false);
 	 				
 				},1000);
 				
 				break; 						
 			case MODIFY01: // Accept
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value=MODIFY01;
 				var rVal=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					opener.comUpdateProposalStatusSummary("06", "");
  					rData="Y";
  				}
 				break;				
 			case MODIFY02: // Accept Cancel
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value=MODIFY02;
 				var rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					opener.comUpdateProposalStatusSummary("06", "");
  					rData="Y";
  				} 
 				break;					
 			case MODIFY03: // Detail Accept
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00008")) {
 	            	return false;
 	            }
 				formObj.f_cmd.value=MODIFY03;
 				var rVal=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					opener.comUpdateProposalStatusSummary("06", "");
  					rData="Y";
  				}
 				break;				
 			case MODIFY04: // Detail Accept Cancel
 				ComOpenWait(true); //->waiting->start 
 	            if (!ComShowCodeConfirm("PRI00009")) {
 	            	return false;
 	            }			
 				formObj.f_cmd.value=MODIFY04;
 				var rVal=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0023GS.do");
 				ComOpenWait(false); //->waiting->End
  				if (rVal){
  					opener.comUpdateProposalStatusSummary("06", "");
  					rData="Y";
  				} 
 				break; 				
 			case MODIFY05: // Accept All
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01015")){
 					return false;
 				}			
 				formObj.f_cmd.value=MODIFY05;
 				formObj.sts_cd.value='A';
 				var sParam=FormQueryString(formObj) +"&amdt_seq_accept="+formObj.amdt_seq.value;
 				sheetObj.DoAllSave("ESM_PRI_0023GS.do", sParam);
 				sheetAcceptCheckedRows();
 				ComOpenWait(false); //->waiting->End
 				opener.comUpdateProposalStatusSummary("06", "");				
 				rData="Y";
 				break;			
 			case MODIFY06: // Cancel All
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01010")){
 					return false;
 				}					
 				formObj.f_cmd.value=MODIFY06;
 				formObj.sts_cd.value='I';
 				var sParam=FormQueryString(formObj) +"&amdt_seq_accept="+formObj.amdt_seq.value;
 				sheetObj.DoAllSave("ESM_PRI_0023GS.do", sParam);
 				sheetAcceptCancelCheckedRows();
 				ComOpenWait(false); //->waiting->End
 				opener.comUpdateProposalStatusSummary("06", "");
 				rData="Y";
 				break;		
 			case MODIFY07: // Guideline copy
 				ComOpenWait(true); //->waiting->start 
 				if (!ComShowCodeConfirm("PRI01009")){
 					return false;
 				}	
         		document.form.f_cmd.value=MULTI10;        	
         		var sXml=sheetObj.GetSaveData("ESM_PRI_0023GS.do", FormQueryString(document.form));
                 var saveOk=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
                 if (saveOk == "S"){
                	 opener.comUpdateProposalStatusSummary("06", "");
                     doActionIBSheet(sheetObj, document.form, IBSEARCH);
      				 ComOpenWait(false); //->waiting->End
                     if (sheetObjects[0].RowCount()<= 0){
                     	ComShowCodeMessage("PRI01019");
                     }else{
                    	 sheetObj.LoadSaveData(sXml, true);
                     }
                 }
 				break;				
 			case COMMAND01: // Amend			
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var editColumn="";
 				if (sheetObj.id == "sheet1"){
 					editColumn="blpl_tit_nm";
 				}
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){					
 						ComShowCodeMessage("PRI00310");
 					}else{						
 						comSheetAmendRow(sheetObj,formObj,chkArr[0],"M", editColumn);						
 					}
 				}else{ 					
 					comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", editColumn);
 				}
 				break;			
 			case COMMAND02: // Amend Cancel		
 				var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
 				var editColumn="";
 				if (sheetObj.id == "sheet1"){
 					editColumn="blpl_tit_nm";
 				}				
 				if(chkArr.length > 0){
 					if(chkArr.length > 1){
 						ComShowCodeMessage("PRI00310");
 					}else{
 						comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", editColumn);						
 					}
 				}else{					
 					comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", editColumn);
 				}
 				break;			
 			case IBDOWNEXCEL:      //excel		
// 				var xmlFile="apps/opus/esm/pri/scproposal/scboilerplateproposal/script/ESM_PRI_0023.xml";
 				ComOpenWait(true); //->waiting->start 
 				if (!validateForm(sheetObj,document.form,sAction)) {
 					return false;
 				}
 				formObj.f_cmd.value=SEARCH03;
 				sheetObjects[2].DoSearch("ESM_PRI_0023GS.do", FormQueryString(formObj), {Sync:2});
 				sheetObjects[2].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[2]), SheetDesign:1, Merge:1});
// 				sheetObjects[2].Down2Excel({ HiddenColumn:-1,Merge:false,URL:xmlFile});
 				ComOpenWait(false); //->waiting->End
 				break;			
           }        	 
         } catch (e) {
         	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
         	if (sAction == COMMAND01 || sAction == COMMAND02 || sAction == IBINSERT
         			|| sAction == IBSEARCH_ASYNC01 || sAction == IBDELETE) {
         		return;
         	}
         	ComOpenWait(false); //->waiting->End
         }
     }
    /**
    * When it opens, automatically update boilerplate using S/C Guideline of the year Data (Not Use) <br>
    * <br><b>Example :</b>
    * <pre>
    *		getHeader();
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */
 	function getHeader (){
		var formObj=document.form;		
		var blplRefYr=formObj.hdr_eff_dt.value;			
		formObj.f_cmd.value=SEARCH;
		formObj.blpl_ref_yr.value=blplRefYr.substring(0,4);
		var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0023GS.do", FormQueryString(formObj));
		var arrData=ComPriXml2Array(sXml, "eff_dt|exp_dt|blpl_nm|blpl_hdr_seq|blpl_ref_yr");
		if (arrData != null && arrData.length > 0) {
			formObj.blpl_hdr_seq.value=arrData[0][3];
			formObj.blpl_ref_yr.value=arrData[0][4]; 
		}
	}   
	/**
     * Controlling button's authority<br>
     * controlling buttons <br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl()
     * </pre>
     * @param  void
     * @return void
     * @author 
     * @version 2009.04.17
     */
     function buttonControl(){
			var formObj=document.form;
			var req_usr_flg=formObj.req_usr_flg.value;
			var apro_usr_flg=formObj.apro_usr_flg.value;
			var amdt_seq=formObj.amdt_seq.value;
			var sts=formObj.prop_sts_cd.value;
			var sheetObj=sheetObjects[1];
			ComBtnDisable("btn_glinecopy");
			if (apro_usr_flg == "false" && req_usr_flg == "false"){
 				ComBtnDisable("btn_Save");
 				ComBtnDisable("btn_RowDelete");
 				ComBtnDisable("btn_RowAdd");
 				ComBtnDisable("btn_Amend");
 				ComBtnDisable("btn_AmendCancel");
 				ComBtnDisable("btn_Accept");
 				ComBtnDisable("btn_AcceptCancel"); 				
				ComBtnDisable("btn_RowAdd2");
				ComBtnDisable("btn_RowDelete2");
				ComBtnDisable("btn_Amend2");
				ComBtnDisable("btn_AmendCancel2"); 				
				ComBtnDisable("btn_AcceptAll");
				ComBtnDisable("btn_AcceptAllCancel"); 	
				ComBtnDisable("btn_Accept2");
				ComBtnDisable("btn_AcceptCancel2");	
				ComBtnDisable("btn_LoadExcel");	
				for (var i=1; i <= sheetObjects[0].RowCount();i++){
					sheetObjects[0].SetCellEditable(i,"blpl_tit_nm",0);
				}		
 				return;
 			}			
			if(amdt_seq == 0) {
				hiddenButton("btn_Amend");
				hiddenButton("btn_AmendCancel");
				hiddenButton("btn_Amend2");
				hiddenButton("btn_AmendCancel2");
			} else {
				showButton("btn_Amend");
				showButton("btn_AmendCancel");	
				showButton("btn_Amend2");
				showButton("btn_AmendCancel2");	
			}	
			try{
				switch(sts) { 				
					case 'I':   // Initial	
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");	
						if (apro_usr_flg == "true" || req_usr_flg == "true" ){
							if (sheetObjects[0].RowCount()<= 0 ){
								ComBtnEnable("btn_glinecopy");
							}
						}						
						for (var i=1; i <=sheetObj.RowCount(); i++){
							if (sheetObj.GetCellValue(i, "amdt_seq") == sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq")){
								if (sheetObj.GetCellValue(i, "prc_prog_sts_cd") =="I" && sheetObj.GetCellValue(i, "src_info_cd") != "AD" ){
									sheetObj.SetCellBackColor(i, "blpl_ctnt","#FFFFFF");
								}
							}							
						}
						for (var i=1; i <=sheetObjects[0].RowCount(); i++){
							if (sheetObjects[0].GetCellValue(i, "prc_prog_sts_cd") == "I"){
								if (sheetObjects[0].GetCellValue(i, "src_info_cd") != "AD"){
									sheetObjects[0].SetCellEditable(i,"blpl_tit_nm",1);
								}else{
									sheetObjects[0].SetCellEditable(i,"blpl_tit_nm",0);
								}
							}else{
								sheetObjects[0].SetCellEditable(i,"blpl_tit_nm",0);
							}
						}
						break;
					case 'A': // Approved					
						ComBtnDisable("btn_Save");						
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_AcceptCancel2");
						ComBtnDisable("btn_LoadExcel");	
						break;
						
					case 'Q':// Requested - Prohibit modify related to save  - If there is countoffer, Authority User can modify it 
						ComBtnDisable("btn_Save");						
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");						
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_AcceptAll");
							ComBtnEnable("btn_AcceptAllCancel");
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
							ComBtnEnable("btn_Accept2");
							ComBtnEnable("btn_AcceptCancel2");
						}else{
							ComBtnDisable("btn_AcceptAll");
							ComBtnDisable("btn_AcceptAllCancel");
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");
							ComBtnDisable("btn_Accept2");
							ComBtnDisable("btn_AcceptCancel2");		
						}						
						ComBtnDisable("btn_LoadExcel");	
						for (var i=1; i <= sheetObjects[0].RowCount();i++){
							sheetObjects[0].SetCellEditable(i,"blpl_tit_nm",0);
						}				
						break;
						
					case 'R':  // Returned
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");	
						ComBtnDisable("btn_LoadExcel");	
						if(req_usr_flg == "true"){
							ComBtnDisable("btn_AcceptAll");
							ComBtnDisable("btn_AcceptAllCancel");
							ComBtnDisable("btn_Accept");
							ComBtnDisable("btn_AcceptCancel");
							ComBtnDisable("btn_Accept2");
							ComBtnDisable("btn_AcceptCancel2");	
						}
						if (apro_usr_flg == "true"){
							ComBtnEnable("btn_AcceptAll");
							ComBtnEnable("btn_AcceptAllCancel");
							ComBtnEnable("btn_Accept");
							ComBtnEnable("btn_AcceptCancel");
							ComBtnEnable("btn_Accept2");
							ComBtnEnable("btn_AcceptCancel2");	
						}
						for (var i=1; i <= sheetObjects[0].RowCount();i++){
							sheetObjects[0].SetCellEditable(i,"blpl_tit_nm",0);
						}
						break;
					case 'F': // Filed
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");						
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");							
						ComBtnDisable("btn_LoadExcel");	
						for (var i=1; i <= sheetObjects[0].RowCount();i++){
							sheetObjects[0].SetCellEditable(i,"blpl_tit_nm",0);
						}
						break;
					case 'C': //  // Cancled
						ComBtnDisable("btn_Save");
						ComBtnDisable("btn_RowAdd");
						ComBtnDisable("btn_RowDelete");
						ComBtnDisable("btn_Amend");
						ComBtnDisable("btn_AmendCancel");
						ComBtnDisable("btn_RowAdd2");
						ComBtnDisable("btn_RowDelete2");
						ComBtnDisable("btn_Amend2");
						ComBtnDisable("btn_AmendCancel2");						
						ComBtnDisable("btn_AcceptAll");
						ComBtnDisable("btn_AcceptAllCancel");
						ComBtnDisable("btn_Accept");
						ComBtnDisable("btn_AcceptCancel");
						ComBtnDisable("btn_Accept2");
						ComBtnDisable("btn_AcceptCancel2");							
						ComBtnDisable("btn_LoadExcel");	
						break;
					default:
	    				showButton("btn_Amend");
	    				showButton("btn_AmendCancel");
	    				showButton("btn_Amend2");
	    				showButton("btn_AmendCancel2");
	    				ComBtnEnable("btn_AcceptAll");
	    				ComBtnEnable("btn_AcceptAllCancel");
	    				ComBtnEnable("btn_Accept");
	    				ComBtnEnable("btn_AcceptCancel");
	    				ComBtnEnable("btn_Accept2");
	    				ComBtnEnable("btn_AcceptCancel2");
						break;
				} 		
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}           
//    /**
//    * Changing color by source code of DETAIL<br>
//    * 
//    * <br><b>Example :</b>
//    * <pre>
//    * manageMasterColor(sheetM, sheetD);
//    * </pre>
//    * @param {object} IBSheet  
//    * @param {object} IBSheet
//    * @return void
//    * @author 
//    * @version 2009.06.10
//    */ 	
//    function manageMasterColor(sheetM, sheetD) {
//    	//SHEET ROW COUNT
//		var row_count = sheetD.RowCount;
//    	var formObj = document.form;
//    	var amdt_seq = formObj.amdt_seq.value;
//    	var eff_dt = formObj.eff_dt.value;
//		
//		// Amendment Assign
//		var amend_check = false;
//		//ALL AMEND DELETE
//		var amend_delete_check = false;
//		
//		try {
//  			if(row_count > 0){  				
//  				amend_delete_check = true;  				
//	  			for(var i=1 ; i <= row_count; i++){	  				
//  					if(sheetD.CellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
//  						if(sheetD.CellValue(i,"src_info_cd") !="AD") {
//  							amend_delete_check = false;
//	  	  				}
//  						
//  						if(sheetD.CellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
//	  	  					amend_check = true;
//	  	  				}
//  					}
//	  			}
//	  			
//	  			if(amdt_seq == "0"){
//	  				amend_delete_check = false;
//	  			}
//	  			
//	  			if(amend_delete_check) {
////	  				sheetM.CellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol, true);
////	  				sheetM.CellFont("FontItalic", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)=true;
////	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= "#FF0000";  
//	  			} else if(amend_check){
//	  				sheetM.CellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol, false);
//	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= "#FF0000";
//	  			} else {
//	  				sheetM.CellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol, false);
//	  				sheetM.CellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol)= "#000000";
//	  			}
//  			}
//		}catch(e) {}
//	}  	
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
			}
			break;
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			}
			break;
		case IBSEARCH_ASYNC01: // Retrieving
			break;
		case IBSAVE: // Saving
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage("PRI00301");
				return false;
			}			
			/*if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
				ComShowCodeMessage("PRI00007");
				return false;
			}*/			
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}			
			if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			break;			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
				return false;
			}
			break;
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
				return false;
			}
			break;
		case IBDOWNEXCEL:			
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == ""  ) {
				return false;
			}
        	if (sheetObjects[0].IsDataModified()== true || sheetObjects[1].IsDataModified()== true){
        		ComShowCodeMessage('PRI00309','Boiler Plate');
        		return false;
        	}			
			break;			
		}
		return true;
	}
    /**
    * Process all of data shows in sheet accept cancel when Cancel All process.  
    * @param  void
    * @return void
    * @author 
    * @version 2009.05.29
    */	
	function sheetAcceptCancelCheckedRows(){
		var eff_dt=document.form.eff_dt.value;
		var amdtSeq=document.form.amdt_seq.value;
		for ( var j=0 ; j <= 1; j++){
			comChangeValue(sheetObjects[j], "chk", "0");
			comChangeValue(sheetObjects[j], "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdtSeq+"|A");
			comChangeValue(sheetObjects[j], "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "I|Initial|R", "chk", "1");
			comChangeValue(sheetObjects[j], "chk|ibflag", "0|R", "chk", "1");	
		}		
	}    	
    /**
    * Process all of data shows in sheet accept when Accept All process.  
    * @param  void
    * @return void
    * @author 
    * @version 2009.05.29
    */	
	function sheetAcceptCheckedRows(){
		var eff_dt=document.form.eff_dt.value;
		var amdtSeq=document.form.amdt_seq.value;
		for ( var j=0 ; j <= 1; j++){
			comChangeValue(sheetObjects[j], "chk", "0");
			comChangeValue(sheetObjects[j], "chk", "1", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdtSeq+"|I");
			comChangeValue(sheetObjects[j], "prc_prog_sts_cd|prc_prog_sts_dtl|ibflag", "A|Accepted|R", "chk", "1");
			comChangeValue(sheetObjects[j], "chk|ibflag", "0|R", "chk", "1");
		}		
	}    
    /**
    * Calculate Max Sequence No. + 1, Using the Sequence No. of window. <br>
    * <br><b>Example :</b>
    * <pre>
    *     getAmendMaxDpSeq(sheetObj, sCol);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} sCol Mandatory, Seq No. 
    * @returns int Max Seq No. + 1
    * @author 
    * @version 2009.04.17
    */
    function getAmendMaxDpSeq(sheetObj, sCol){
        var max=0;
        var formObj=document.form;
        var amdtSeq=document.form.amdt_seq.value;
        for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
        	if (sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") != amdtSeq && ComParseInt(sheetObj.GetCellValue(i, sCol)) > max) {
        		max=sheetObj.GetCellValue(i, sCol);
                if (sheetObj.id == "sheet1"){
                	if (max < ComParseInt(sheetObj.GetCellValue(i, "max_dp_seq"))){
                		max=sheetObj.GetCellValue(i, "max_dp_seq");
                	}
                }else{
                	if (max < ComParseInt(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "max_dp_seq_ctnt"))){
                		max=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "max_dp_seq_ctnt");
                	}
                }                
            }
        }
        return max;    	
    }
    /**
    * Set the dp_seq column that ordering sequence. <br>
    * @version 2009.04.17
    */
 	function changeDpSeq_header (sheetObj){
 		var amdtSeq=document.form.amdt_seq.value;
 		var dpSeq=ComParseInt(getAmendMaxDpSeq(sheetObj, "dp_seq")) + 1;
 		
		for (var i=1; i <= sheetObj.RowCount(); i++){
			if (sheetObj.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.GetCellValue(i, "src_info_cd") != "AM"
				&& sheetObj.GetCellValue(i, "ibflag") !="D" && sheetObj.GetCellValue(i, "src_info_cd") != "AD" ){
				sheetObj.SetCellValue(i, "dp_seq",dpSeq++ );
			}
		}
		changeDpSeq_content (sheetObjects[1]);
 	}
 	
    /**
     * set dp_seq of below parts
     * @version 2016.08.02
     */
  	function changeDpSeq_content (sheetObj){
 		var amdtSeq=document.form.amdt_seq.value;
		var dpSeq=parseInt(getCurrentMaxDpSeq(sheetObj, "dp_seq"))+1;
		var initialdpSeq = dpSeq;
 		
		for (var i=1; i <= sheetObj.RowCount(); i++){
			if(sheetObj.GetCellValue(i, "dp_seq") >= initialdpSeq){
				if(sheetObj.GetCellValue(i, "ibflag") == "R"){
					sheetObj.SetCellValue(i, "ibflag", "U");
				}
				sheetObj.SetCellValue(i, "dp_seq", dpSeq++);
			}
		}
 	}
 	
    /**
    * Setting Boiler Plate's name. <br>
    * <br><b>Example :</b>
    * <pre>
    *		setHeader();
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */    
    function setHeader(){
     	var sheetObj=sheetObjects[0];
     	var formObj=document.form;
     	// When it is not GUIDELINE COPIED,  Don’t show the title. 09.08.27 
    	if (sheetObj.RowCount()> 0){
     		if (formObj.blpl_ref_yr.value == ""){
         		//formObj.blpl_ref_yr.value = formObj.hdr_eff_dt.value.substr(0,4);
         	}
     	}else{
     		formObj.blpl_ref_yr.value="";
     		formObj.blpl_hdr_seq.value="";
     	}
    }
    /**
    * Find deleted Row, Return Row +1 or Row -1 of deleted Row. <br>
    * <br><b>Example :</b>
    * <pre>
    *		getSearchRow(sheetObj);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @return rValue. When deleted row is last row, return last row - 1. otherwise, last row + 1
    * @author 
    * @version 2009.04.17
    */    
	function getSearchRow(sheetObj){
		var mRow=1;
		var rValue=1;
		for (var i=1;i <= sheetObj.RowCount();i++){
			if (sheetObj.GetCellValue(i, "ibflag") =="D" ){
				mRow=i;
				break;
			}		
		}
		if (mRow == sheetObj.RowCount()){
			rValue=mRow - 1;
		}else{
			rValue=mRow + 1;
		}
		return rValue;
	}
    /**
     * When Master Delete, check accepted data exists in Detail data.<br>
     * Accept data exists, cannot delete.<br>
     * <br><b>Example :</b>
     * <pre>
     *		checkDelete(sheetObj);
     * </pre>
     * @param  void
     * @return {string} <br>
     *          Y : Delete available<br>
     *          N : Delete unavailable.<br>
     * @author 
     * @version 2009.05.07
     */ 
    function checkDelete(sheetObj){
    	 var sheetID=sheetObj.id;
    	 if (sheetID != "sheet1"){
    		 return "Y";
    	 }
    	var formObj=document.form;        
        var rValue="Y";        
        formObj.f_cmd.value=SEARCH04;
        var sParam=FormQueryString(formObj);
        var sParamSheet=sheetObjects[0].GetSaveString(false, false, "chk");
        var sXml=sheetObj.GetSearchData("ESM_PRI_0023GS.do" , sParamSheet +"&"+sParam);
        var arrData=ComPriXml2Array(sXml, "cd");         
        if (arrData !=null && arrData.length > 0){
        	if (arrData[0][0] > 0){
	       		rValue="N";
	        }
        }
        return rValue;  
    }      

    /**
     * change sheet size based on sheet1 row counts
     * @version 2016.07.29
     */
    function sheet_auto_size(sheetObj){
    	var sheet1_RowCount = sheetObjects[0].RowCount();
 		if(sheet1_RowCount > 0){
 			if(sheetObj == sheetObjects[0]){
 				sheetObj.SetSheetHeight((sheetObj.RowCount()+4)*24,1);
 			}else if(sheetObj == sheetObjects[1]){
 				sheetObj.SetSheetHeight(180+240-((sheet1_RowCount+4)*24),1);
 			}
 		}
    }
    
    /**
     * find a dp_seq of the first added row in this amendment's previous row 
     * @version 2016.07.29
     */
    function getCurrentMaxDpSeq(sheetObj, sCol){
        var max=0;
        var amdtSeq=document.form.amdt_seq.value;
	        for (var i=1; i <= sheetObj.RowCount(); i++) {	        	
        		if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && sheetObj.GetRowStatus(i) == "I" && max == 0){
        			max=sheetObj.GetCellValue(i-1, sCol);
        		}
	        }		
        return max;   	
    }