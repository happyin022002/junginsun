/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_13.js
 *@FileTitle  : Amend History Inquiry - Boiler Plate
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
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
     * @class ESM_PRI_0057_13 : Business Script for ESM_PRI_0057_13
     */
    function ESM_PRI_0057_13() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	 // common global variables
	 var sheetObjects=new Array();
	 var sheetCnt=0;
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
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
         resizeSheet();
         loadSts=true;
         parent.loadTabPage();
     }
     /**
      * The event triggered when creation of object instance is completed. <br>
      * <br><b>Example :</b>
      * <pre>
      *    
      * </pre>
      * @param {ibsheet} sheetObj mandatory IBSheet Object
      * @return void
      * @author 
      * @version 2009.04.17
      */      
     //no support[check again]CLT function sheet1_OnLoadFinish(sheetObj) {   
         
     //}
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
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|propno|amdtseq|blplseq|Title|Effective Date|Effective Date|Source|Source|Status|Status|Accept Staff/Team|Accept Date|dpseq|||";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
					  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:430,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:135,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					    
					InitColumns(cols);
					SetSheetHeight(132);
					SetEditable(0);
					SetWaitImageVisible(0);
					SetAutoRowHeight(0);
				}
                 break;
             case "sheet2":
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|propno|amdtseq|blplseq|blplctntseq|Content|Effective Date|Effective Date|Source|Source|Status|Status|Accept Staff/Team|Accept Date|usr_id|ofc_cd|dp_seq|n1st_amdt_seq";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",              Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk",                 Wrap:1 },
					  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                 Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:0, Width:620,  Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:0, Width:215,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Date",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
					  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
					    
					InitColumns(cols);
					resizeSheet(); //SetSheetHeight(140);
					SetEditable(0);
					SetWaitImageVisible(0);
					SetAutoRowHeight(0);
				}			
                 break;
         }
     }
     
     function resizeSheet() {
  	    ComResizeSheet(sheetObjects[1]);
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
        searchEndFontChange(sheetObj, "", document.form.lgcy_if_flg.value);
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
	function sheet2_OnSearchEnd(sheetObj, errMsg){
    	 searchEndFontChange(sheetObj, "", document.form.lgcy_if_flg.value);
         manageMasterColor(sheetObjects[0], sheetObjects[1]);	
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
    function sheet2_OnClick(sheetObj, Row, Col, Value) {
        //Showing Memopad in case of Clicking desc cell(MemoPad : Editable)
	    var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
 	    	case "blpl_ctnt": 	
 	    		var widsize = sheetObj.GetColWidth("blpl_ctnt")+sheetObj.GetColWidth("eff_dt")+sheetObj.GetColWidth("exp_dt")+sheetObj.GetColWidth("src_info_dtl");
 	    		//ComShowMemoPad(sheetObj, Row, Col, true, widsize,  parseInt(sheetObj.GetDataRowHeight()) * 5, 4000, "X");
 	    		ComShowMemoPad(sheetObj, Row, Col, true, widsize,  parseInt(sheetObj.GetDataRowHeight()) * 10);
 	    		break;
     	}    	 
    }     
    /**
     * calling function in case of OnSelectCell event <br>
     * Displaying different highlight color at Amend Row<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory, IBSheet Object
     * @param {int} OldRow Mandatory, ,Previous selected cell's Row Index
     * @param {int} OldCol Mandatory, ,Previous selected cell's Column Index
     * @param {int} NewRow Mandatory, ,current selected cell's Row Index
     * @param {int} NewCol Mandatory, ,current selected cell's Column Index
     * @return void
     * @author 
     * @version 2009.04.17
     */         
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {

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
         if (OldRow != NewRow) {
        	 
         }
  		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol);
  	}
    /**
     * When Master Sheet Row modified, Retrieve Detail data. <br>
     * <br><b>Example :</b>
     * <pre>
     *		doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol);
     * </pre>
     * @param {ibsheet} sheetM Mandatory Master IBSheet Object
     * @param {ibsheet} sheetD Mandatory Detail IBSheet Object
     * @param {int} OldRow Mandatory ,previous selected cell's Row Index
     * @param {int} OldCol Mandatory Previous selected Cell's Column Index
     * @param {int} NewRow Mandatory ,current selected cell's Row Index
     * @param {int} NewCol Mandatory ,current selected cell's Column Index     * 
     * @return void
     * @author 
     * @version 2009.04.17
     */    	
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol) {
		var formObj=document.form;
		if (OldRow != NewRow) {			
			formObj.blpl_seq.value=sheetM.GetCellValue(NewRow, "blpl_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
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
	 			case IBSEARCH: // retrieving
	 				ComOpenWait(true); //->waiting->start
	 				for (var i=0; i < sheetObjects.length; i++) {
	 					sheetObjects[i].RemoveAll();
	 				}	 				
	 				formObj.f_cmd.value=SEARCH01;
	 				var sXml=sheetObj.GetSearchData("ESM_PRI_0057_13GS.do" , FormQueryString(formObj));
	 				sheetObjects[0].LoadSearchData(sXml,{Sync:0} );
	 				break;
	 			case IBSEARCHAPPEND: // Retrieving
	 				ComOpenWait(true); //->waiting->start
	 				formObj.f_cmd.value=SEARCH02;
	 				sheetObj.DoSearch("ESM_PRI_0057_13GS.do", FormQueryString(formObj) );
	 				break;
	          }        	 
         } catch (e) {
           	if (e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }finally{
         	ComOpenWait(false); //->waiting->End
         }
     }
    /**
    * Changing color by source code of DETAIL<br>
    * 
    * <br><b>Example :</b>
    * <pre>
    * manageMasterColor(sheetM, sheetD);
    * </pre>
    * @param {object} IBSheet  
    * @param {object} IBSheet
    * @return void
    * @author 
    * @version 2009.06.10
    */ 	
    function manageMasterColor(sheetM, sheetD) {
    	//SHEET ROW COUNT
		var row_count=sheetD.RowCount();
    	var formObj=document.form;
		// Amendment Assign
		var amend_check=false;
		//ALL AMEND DELETE
		var amend_delete_check=false;
		try {
  			if(row_count > 0){
  				amend_delete_check=true;
	  			for(var i=1 ; i <= row_count; i++){
	  				if(sheetD.GetCellValue(i,"amdt_seq") == amdt_seq && amdt_seq != "0") {
	  					if(sheetD.GetCellValue(i,"src_info_cd") !="AD") {
  							amend_delete_check=false;
	  	  				}
	  					if(sheetD.GetCellValue(i, "n1st_cmnc_amdt_seq") == amdt_seq) {
	  	  					amend_check=true;
	  	  				}
  					}
	  			}
	  			if(amdt_seq == "0"){
	  				amend_delete_check=false;
	  			}
	  			if(amend_delete_check) {
	  				sheetM.SetCellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),1);
	  				sheetM.SetCellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),"#FF0000");
	  			} else if(amend_check){
	  				sheetM.SetCellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),0);
	  				sheetM.SetCellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),"#FF0000");
	  			} else {
	  				sheetM.SetCellFont("FontStrike", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),0);
	  				sheetM.SetCellFont("FontColor", sheetM.selectRow, "chk", sheetM.selectRow, sheetM.LastCol(),"#000000");
	  			}
  			}
		}catch(e) {}
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
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		}
	}
	 /**
	  * Calling function in case of clicking tabl on parent screen <br>
	  * It shows screen and process retrieve <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * tabLoadSheet("HAM090001","1","ACE", "1","Y");
	  * </pre>
	  * @param {string} sPropNo Mandatory prop_no 
	  * @param {string} sAmdtSeq Mandatory amdt_seq 
	  * @param {string} sSvcScpCd Mandatory svc_scp_cd 
	  * @param {string} sConChk Mandatory Conversion check 
	  * @param {string} sLgcyIfFlg Mandatory lgcy_if_flg value	  
	  * @return void
	  * @author 
	  * @version 2009.05.21
	  */ 
	  function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk, sLgcyIfFlg) {	  
	 	var formObject=document.form;
	 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	 		formObject.prop_no.value=sPropNo;
	 		formObject.amdt_seq.value=sAmdtSeq;
	 		formObject.svc_scp_cd.value=sSvcScpCd;
	 		formObject.lgcy_if_flg.value=sLgcyIfFlg;
	 		//formObject.con_chk.value = sConChk;
	 		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
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
    * @version 2009.05.20
    */ 
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
	var enableFlag=true;
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
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
	}
	var loadSts=false;
	/**
	* Function to check whether Tab screen of Parent is loaded from Frame or not<br>
	* <br><b>Example :</b>
	* <pre>
	* 		loadFinishCheck()
	* </pre>
	* @param  void
	* @return bool  loadSts  <br>
	*               true  : load completed
	*               false : load not completed
	* @author 
	* @version 2009.05.20
	*/ 	
	function loadFinishCheck(){
	    return loadSts;
	} 	    