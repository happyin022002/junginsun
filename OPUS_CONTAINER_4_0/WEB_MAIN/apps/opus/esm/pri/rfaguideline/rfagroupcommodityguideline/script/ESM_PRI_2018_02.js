/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2018_02.js
 *@FileTitle : RFA Guideline Inquiry - Commodity Group
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
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
     * @class Commodity Group :business script for Commodity Group 
     */
    // common global variables
    var sheetObjects=new Array();
 	var sheetCnt=0;
	var enableFlag=true;
	var isFiredNested=false;
	var supressConfirm=false;	
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
     * @version 2009.04.16
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
					if (validateForm(sheetObject1,formObject,IBSEARCH)) {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case "btn_downexcel":
					if (validateForm(sheetObject1,formObject,IBDOWNEXCEL)) {
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					} else {
						ComShowCodeMessage('PRI08001');
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
    	 $(".util_bar").remove();
    	 $(".gnb_wrap").remove();
         for(i=0;i<sheetObjects.length;i++){
         //Modify Environment Setting Function's name
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);           
         //Add Environment Setting Function
             ComEndConfigSheet(sheetObjects[i]);
         }
         resizeSheet();
         toggleButtons("CLEAR");
         parent.loadTabPage();
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
         switch(sheetID) {
             case "sheet1":
                 with(sheetObj){
		              var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|grp_cmdtseq|Group\nCode|Description";
		              var headCount=ComCountHeadTitle(HeadTitle);
		              (headCount, 0, 0, true);
		
		              SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                  {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",   Sort:0 },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		                  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
		                  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
		                  {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 } ];
		               
		              InitColumns(cols);
		
		              SetEditable(0);
		              SetWaitImageVisible(0);
		              SetShowButtonImage(2);
		              resizeSheet(); //SetSheetHeight(410);
              }
                 break;
             case "sheet2":
            	    with(sheetObj){
		               var HeadTitle="|Sel.|Seq.|svcscpcd|glineseq|Commodity\nType|grpcmdtseq|grpcmdtdtlseq|Commodity\nCode" +
		               "|Description|cre_dt";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",   Sort:0 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
		                      {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"prc_cmdt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_dtl_seq" },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
		                      {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"loc_des",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
		                      {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt" } ];
		                
		               InitColumns(cols);
		
		               SetEditable(0);
		               SetWaitImageVisible(0);
		               SetColProperty("prc_cmdt_tp_cd",{ComboText:COMODITY_TYPE2[1] , ComboCode:COMODITY_TYPE2[0]});
		               SetShowButtonImage(2);
		               resizeSheet(); //SetSheetHeight(410);
               }
                 break;
             case "sheet3":
            	    with(sheetObj){
		               var HeadTitle="|Seq.|Group Code|Group Description|Code|Description";
		               var headCount=ComCountHeadTitle(HeadTitle);
		               (headCount, 0, 0, true);
		
		               SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
		               var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle, Align:"Center"} ];
		               InitHeaders(headers, info);
		
		               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                      {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
		                      {Type:"Text",     Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd" },
		                      {Type:"Text",     Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc" },
		                      {Type:"Text",     Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd" },
		                      {Type:"Text",     Hidden:0,  Width:280,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_nm" } ];
		                
		               InitColumns(cols);
		               SetEditable(1);
		               SetWaitImageVisible(0);
		               SetSheetHeight(260);
                     }
                 break;                 
         }
     }
     
     function resizeSheet() {
 	    ComResizeSheet(sheetObjects[0]);
 	    ComResizeSheet(sheetObjects[1]);
 	}
     
     function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
         sheetObj.ReNumberSeq();    
    }
     
     function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
         sheetObj.ReNumberSeq();    
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
    	  try {
          sheetObj.ShowDebugMsg(false);
	          switch(sAction) {		  		  		
	 				case IBSEARCH:      //Retrieving
						if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
			  				sheetObjects[0].RemoveAll();
							sheetObjects[1].RemoveAll();
							formObj.f_cmd.value=SEARCH01;
 							sheetObj.DoSearch("ESM_PRI_2018_02GS.do", FormQueryString(formObj) );
						} else {
							ComShowCodeMessage('PRI08001');
						}	 
	 					break;
	 				case IBSEARCHAPPEND: // Retrieving
						if (validateForm(sheetObj,document.form,sAction)) {
			  				ComOpenWait(true);
							formObj.f_cmd.value=SEARCH02;
 							sheetObj.DoSearch("ESM_PRI_2018_02GS.do", FormQueryString(formObj) );
						}
						break;
					case IBDOWNEXCEL:      //excel		
		  				ComOpenWait(true);	
						formObj.f_cmd.value=SEARCH03;
 						sheetObjects[2].DoSearch("ESM_PRI_2018_02GS.do", FormQueryString(formObj) );
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
      
      function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
  		if(sheetObjects[2].RowCount() < 1){//no data	
  			ComShowCodeMessage("COM132501");
  		}else{	
  			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj)});
  		}	
  		
  	}    
      
    /**
     * calling function in case of OnSelectCell event <br>
     * Call the doRowChange Function. It executed when row focus changed
     * <br><b>Example :</b>
     * <pre>
     *
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
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, false);
	}	
     /**
      * Calling function in case of clicking SHEET's ROW<br>
      * Retrieving child-sheet by selected row<br>
      * <br><b>Example :</b>
      * <pre>
      *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
      * </pre>
      * @param {ibsheet} sheetM Mandatory HTMLtag(Object) Object
      * @param {ibsheet} sheetD Mandatory HTMLtag(Object) Object
      * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
      * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
      * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
      * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
      * @param {string} appendRow Mandatory SHEET Row Add Option
      * @return void
      * @author 
      * @version 2009.05.19
      */
 	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, appendRow) {
 		var formObj=document.form;
 		if (OldRow != NewRow) {
 			formObj.grp_cmdt_seq.value=sheetM.GetCellValue(NewRow,"grp_cmdt_seq")
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
 		}
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
     function validateForm(sheetObj,formObj,sAction){
  		switch (sAction) {
			case IBSEARCH: // retrieving
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				} else {
					return true;
				}
				break;
			case IBSEARCHAPPEND: // Retrieving
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				} else {
					return true;
				}
				break;				
			case IBDOWNEXCEL: // Excel Download
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				} else {
					return true;
				}
				break;		
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
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj=document.form;
		if( sheetObj.SearchRows()> 0){
			document.form.yn_data.value="Y"
		}else{
			document.form.yn_data.value="N"
		}
	}    
    /**
    * Function to control button<br>
    * <br><b>Example :</b>
    * <pre>
    *     toggleButtons(mode)
    * </pre>
    * @param {string} mode setting value
    * @return void
    * @author 
    * @version 2009.05.22
    */	
 	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_downexcel");
			break;
		case "INIT":
			enableButton("btn_downexcel");
			break;
		case "READONLY":
			disableButton("btn_downexcel");
			break;
		}
	}     	
    /**
    * Calling function in case of clicking tabl on parent screen <br>
    * It shows screen and process retrieve <br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sSvcScpCd Mandatory svc_scp_cd 
    * @param {string} sGlineSeq Mandatory gline_seq
    * @return void
    * @author 
    * @version 2009.04.17
    */ 		    	
 	function tabLoadSheet(sSvcScpCd, sGlineSeq) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			if (enableFlag) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}				
		}
	}
    /**
    * Function to clear control of tab screen on parent <br>
    * <br><b>Example :</b>
    * <pre>
    * tabClearSheet()
    * </pre>
    * @param  void
    * @return void
    * @author 
    * @version 2009.04.17
    */ 	 	 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
	}     	 
    /**
     * Calling function from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return void
     * @author 
     * @version 2009.04.17
     */ 			
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}   
