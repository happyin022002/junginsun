/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0047.js
*@FileTitle  : S/C Proposal Boiler Plate Inquiry
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
     * @
     * @author 
     */
    /**
     * @extends 
     * @class ESM_PRI_0047 : Business Script for ESM_PRI_0047
     */
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
  * @version 2009. 04.17
  */
     function processButtonClick(){
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_Retrieve":
 					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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

         var formObj=document.form;
		 formObj.hdr_eff_dt.focus();
		 formObj.hdr_exp_dt.focus();
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
     * @version 2009.04.17
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
 		 var amdt_seq=document.form.amdt_seq.value;
         switch(sheetID) {         	
             case "sheet1":
                 with (sheetObj) {
	                 var HeadTitle="|Seq.|propno|amdtseq|blplseq|Title|Effective Date|Effective Date|Source|Source|Status|Status|dpseq|acpt_usr_id|acpt_ofc_cd|Accept Staff/Team|Accept Date|";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	
	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"blpl_tit_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
				                  {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                  
	                 InitColumns(cols);
	
	                 SetEditable(0);
	                 SetWaitImageVisible(0);
	                 //SetAutoRowHeight(0);
	                 SetSheetHeight(132);  
                }
                 break;
             case "sheet2":
                 with (sheetObj) {
	                 var HeadTitle="|Seq.|propno|amdtseq|blplseq|blplctntseq|Content|Effective Date|Effective Date|Source|Source|Status|Status|usr_id|ofc_cd|Accept Staff/Team|Accept Date|dp_seq|n1st_amdt_seq";
	                 var headCount=ComCountHeadTitle(HeadTitle);
	
	                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                 var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                 InitHeaders(headers, info);
	
	                 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",              Wrap:1 },
				                  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                 Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:0,  Width:350,  Align:"Left",    ColMerge:0,   SaveName:"blpl_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_dtl",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_dtl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Date",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
				                  {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
	                  
	                 InitColumns(cols);
	
	                 SetEditable(0);
	                 SetWaitImageVisible(0);
	                 //SetAutoRowHeight(0);
	                 resizeSheet();
 			   	}			
                 break;
         }
     }
     
     function resizeSheet(){
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
 		var formObj=document.form;
         if (errMsg == "") {         	
         	setHeader();
         }
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
	    // When desc cell is clicked, Display MemoPad.
	    var colname=sheetObj.ColSaveName(Col);
     	switch(colname)
     	{
 	    	case "blpl_ctnt":
 	    		ComShowMemoPad(sheetObj, Row, Col, true, 430, 110);
 	    	break;
     	}    	 
    }     
     /**
     * calling function in case of OnSelectCell event <br>
     * <br><b>Example :</b>
     * <pre>
     *		sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol);
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
  		var formObj=document.form;
  		formObj.blpl_seq.value=sheetObj.GetCellValue(NewRow, "blpl_seq");
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
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
 				sheetObjects[1].SetColProperty("src_info_cd", {ComboText:srcInfoCdText, ComboCode:srcInfoCdValue} );
 				//status
 				sheetObj.SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
 				sheetObjects[1].SetColProperty("prc_prog_sts_cd", {ComboText:stsCdText, ComboCode:stsCdValue} );
 				break;	              
 			 case IBSEARCH: // retrieving
 			 	ComOpenWait(true); //->waiting->start
 				for (var i=0; i < sheetObjects.length; i++) {
 					sheetObjects[i].RemoveAll();
 				}				
 				formObj.blpl_nm.value="";
 				formObj.blpl_ref_yr.value="";
 				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0047GS.do" , FormQueryString(formObj));
 				sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
 				if (ComGetEtcData(sXml,"blpl_nm") != undefined){
 					formObj.blpl_nm.value=ComGetEtcData(sXml,"blpl_nm");
 				}
 				if (ComGetEtcData(sXml,"blpl_ref_yr") != undefined){
 					formObj.blpl_ref_yr.value=ComGetEtcData(sXml,"blpl_ref_yr");
 				}
 				if (ComGetEtcData(sXml,"blpl_hdr_seq") != undefined){
 					formObj.blpl_hdr_seq.value=ComGetEtcData(sXml,"blpl_hdr_seq");
 				}
 				ComOpenWait(false); //->waiting->End
 				break;
 			 case IBSEARCHAPPEND: // Retrieving
 			 	ComOpenWait(true); //->waiting->start
 			 	formObj.f_cmd.value=SEARCH02;
 			 	sheetObj.DoSearch("ESM_PRI_0047GS.do", FormQueryString(formObj) );
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
          	if (sAction == IBSEARCH_ASYNC01) {
          		return;
          	}
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
    	var amdt_seq=formObj.amdt_seq.value;
    	var eff_dt=formObj.eff_dt.value;
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
		case IBSEARCH_ASYNC01: // Retrieving
			return true;
			break;
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
         		formObj.blpl_ref_yr.value=formObj.hdr_eff_dt.value.substr(0,4);
         	}
         	if (formObj.blpl_nm.value == ""){
         		formObj.blpl_nm.value=formObj.hdr_eff_dt.value.substr(0,4)+ " Boiler Plate";
         	}
     	}else{
     		formObj.blpl_ref_yr.value="";
     		formObj.blpl_nm.value="";
     		formObj.blpl_hdr_seq.value="";
     	}
    }
