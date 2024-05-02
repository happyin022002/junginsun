/*=========================================================
** 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_09.js
*@FileTitle  :  S/C Proposal Standard Note Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04

=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_PRI_0003_09 :  business script for  ESM_PRI_0003_09 
     */

	// global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	 // checking G/L COPY 
	 var copyFlg=true;
	//  Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 
     * @author 
     * @version 2009.10.28
     */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_glinecopy":
					if(validateForm(sheetObject1,formObject,IBCOPYROW)) {
						doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					}
					break;
				case "btn_delete":
					if(validateForm(sheetObject1,formObject,IBDELETE)) {
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
					}
					break;
				case "btn_deletecancel":
					if(validateForm(sheetObject1,formObject,COMMAND02)) {
						doActionIBSheet(sheetObject1,formObject,COMMAND02);
					}
					break;
			}
		}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	   /**
	    * registering IBSheet Object as list
	    * adding process for list in case of needing batch processing with other items 
	    * defining list on the top of source
	    * @param sheet_obj IBSheet Object
	    * <br><b>Example :</b>
	    * <pre>
	    *     setSheetObject(sheetObj);
	    * </pre>
	    * @param {ibsheet} sheet_obj  IBSheet Object
	    * @return 
	    * @author 
	    * @version 2009.10.28
	    */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
   /**
    * initializing sheet
    * implementing onLoad event handler in body tag
    * adding first-served functions after loading screen.
    * <br><b>Example :</b>
    * <pre>
    *     loadPage();
    * </pre>
    * @return 
    * @author 
    * @version 
    */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
        buttonControl();
        parent.loadTabPage();
	}
   /**
     * setting sheet initial values and header
     *  param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj 
    * @param {int} sheetNo 
    * @return
    * @author 
    * @version 
    */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
				        
				      var HeadTitle="|Seq.|Title|1|2|3|4|5|6|7|8|9|10";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dp_fix_flg" } ];
				       
				      InitColumns(cols);
		
				      SetEditable(0);
				      SetWaitImageVisible(0);
				      SetAutoRowHeight(0);
				      SetSheetHeight(120);
		      }


				break;
			case "sheet2":
			    with(sheetObj){
				        
				      var HeadTitle="|Seq.|Content|EFF Date|EXP Date|Source|Status|1|2|3|4|5|6|7|8";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:0,  Width:550,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
				             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_ctnt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"note_tp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" } ];
				       
				      InitColumns(cols);
		
				      SetEditable(0);
				      SetWaitImageVisible(0);
				      SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
				      SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
				      //SetAutoRowHeight(0);
				      resizeSheet(); //SetSheetHeight(155);
		      }
				break;
			}
		}
	
	 function resizeSheet() {
	 	ComResizeSheet(sheetObjects[1]);
	 }
    /**
    * handling sheet process
    * @param sheetObj Sheet
    * @param formObj form Object
    * @param sAction
    */
    	function doActionIBSheet(sheetObj, formObj, sAction) {
    		try {
    			sheetObj.ShowDebugMsg(false);
	    		switch (sAction) {
	    			case IBSEARCH: 
	      				ComOpenWait(true);
	    				formObj.f_cmd.value=SEARCH01;    			    
	    			    var sParam=FormQueryString(formObj);
	    			    var sXml=sheetObj.GetSearchData("ESM_PRI_0003_09GS.do", sParam);
	    				var arrData=ComPriXml2Array(sXml, "note_ref_yr|note_nm|cust_tp_desc");
	 					if (arrData != null){
	 						formObj.note_ref_yr.value=arrData[0][0];
	 						formObj.note_nm.value=arrData[0][1];
	 						formObj.cust_tp_desc.value=arrData[0][2]; 						
	 					} else {
	 						formObj.note_ref_yr.value="";
	 						formObj.note_nm.value="";
	 						formObj.cust_tp_desc.value="";
	 					}
	    				formObj.f_cmd.value=SEARCH02;
	    				sheetObj.DoSearch("ESM_PRI_0003_09GS.do", FormQueryString(formObj) );
	    				if(arrData == null || arrData == undefined){
	    					doRowChange(sheetObjects[0], sheetObjects[1], -1, 1, 1, false);
	    				}
	    				break;
	    			case IBSEARCHAPPEND: 
	      				ComOpenWait(true);
	    				formObj.f_cmd.value=SEARCH03;
	    				sheetObj.DoSearch("ESM_PRI_0003_09GS.do", FormQueryString(formObj) );
	    				break;
	    			case IBDELETE: // Delete
	    				var amdtSeq=formObj.amdt_seq.value;
	    				if(!ComShowCodeConfirm('PRI00005')){
	    					return false;
	    				}
	      				ComOpenWait(true);
	      				//  setting in case of none existing data after deleting
	    				copyFlg=false;
		  				formObj.f_cmd.value=REMOVELIST;
		  				var sParam=FormQueryString(formObj);	
		  				//  AMEND DELETING ALL
		  				sParam += "&src_info_cd=AD";
		  				sParam += "&prc_prog_sts_cd=I";
		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_09GS.do", sParam);
		  				sheetObj.LoadSaveData(sXml);
	  		    		formObj.note_ref_yr.value="";
	  		    		formObj.note_nm.value="";
	  		    		formObj.cust_tp_desc.value=""; 		    		
		  				// retrieving after saving
	  		    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	  		    		//sheetObj.LoadSaveData(sXml);
	    				break;
	      			case COMMAND02: // Amend Cancel
	    				if(!ComShowCodeConfirm('PRI01046')){
	    					return false;
	    				}
	    				ComOpenWait(true);
		  				formObj.f_cmd.value=MODIFY02;
		  				var sParam=FormQueryString(formObj);
		  				//AMEND DELETE CANCEL  				
		  				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_09GS.do", sParam);
		  				//retrieving after saving
	    				formObj.f_cmd.value=SEARCH02;
	    				sheetObj.DoSearch("ESM_PRI_0003_09GS.do", FormQueryString(formObj) );
	    				sheetObj.LoadSaveData(sXml);
	      				break;
	    			case IBCOPYROW: // Guideline Copy
	    				copyFlg=false;    			
						if (ComShowCodeConfirm("PRI01006")) {  //inserting copied contents
		      				ComOpenWait(true);
	        				formObj.f_cmd.value=MULTI;
	        				var sParam=FormQueryString(formObj);
	        				sParam += "&prc_cust_tp_cd="+parent.comboObjects[2].GetSelectCode();
	        				var sXml=sheetObj.GetSaveData("ESM_PRI_0003_09GS.do", sParam);
	        				formObj.f_cmd.value=SEARCH01;
							doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
							sheetObj.LoadSaveData(sXml);
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
     *  calling function which is clicked Row of sheet <br>
     * searching sheet of corresponding Row which is selected<br>
     * <br><b>Example :</b>
     * <pre>
     *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
     * </pre>
     * @param {ibsheet} sheetM mandatory HTML tag(Object) 
     * @param {ibsheet} sheetD mandatory HTML tag(Object) 
     * @param {int} OldRow mandatory Onclick - Row Index of cell which is called event
     * @param {int} NewRow mandatory Onclick - Row Index of cell which is called event
     * @param {int} OldCol mandatory Onclick - Column Index of cell which is called event
     * @param {int} NewCol mandatory Onclick - Column Index of cell which is called event
     * @param {string} appendRow mandatory SHEET Row 
     * @return 
     * @author 
     * @version 2009.05.19
     */
    	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, appendRow) {
    		var formObj=document.form;
    		if (OldRow != NewRow) {    			
    			formObj.note_seq.value=sheetM.GetCellValue(NewRow, "note_seq");
				doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
    		}
    	}
        /**
        * OnClick  function <br>
        *  handling the Row highlighted when the Row of sheet is clicked   <br>
        * <br><b>Example :</b>
        * <pre>
        *
        * </pre>
        * @param {ibsheet} sheetObj mandatory HTML(Object)
        * @param {int} Row mandatory : Row Index of Cell which is called Onclick event
        * @param {int} Col mandatory : Column Index  of Cell which is called Onclick event
        * @param {String} Value mandatory Cell 
        * @return 
        * @author 
        * @version 2009.05.19
        */	
		function sheet1_OnClick(sheetObj, Row, Col, Value)  {
			var colName=sheetObj.ColSaveName(Col);
	     	switch(colName)
	     	{
	 	    	case "note_tit_nm":
	    			ComShowMemoPad(sheetObj, Row, Col, true, 915); 	
	 	    		break;
	     	} 
		}
	   /**
	    * OnClick   function <br>
	    * handling the Row highlighted when the Row of sheet is clicked  <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *
	    * </pre>
	    * @param {ibsheet} sheetObj mandatory HTML(Object) 
	    * @param {int} OldRow mandatory :  Row Index of Cell which is called Onclick event
	    * @param {int} OldCol mandatory :  Column Index of Cell which is called Onclick event
	    * @param {int} NewRow mandatory :  Row Index of Cell which is called Onclick event
	    * @param {int} NewCol mandatory :  Column Index of Cell which is called Onclick event
	    * @return 
	    * @author 
	    * @version 2009.05.19
	    */	
		function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, false);
		}
	    /**
	     * OnSelectCell  function <br>
	     * showing the Highlight color of Amend Row differently<br>
	     * <br><b>Example :</b>
	     * <pre>
	     * 
	     * </pre>
	     * @param {ibsheet} sheetObj mandatory, IBSheet Object
	     * @param {int} OldRow mandatory,  Row Index of cell which is selected before
	     * @param {int} OldCol mandatory, Column Index of cell which is selected before
	     * @param {int} NewRow mandatory,  Row Index of cell which is selected now
	     * @param {int} NewCol mandatory,  Column Index of cell which is selected now
	     * @return 
	     * @author 
	     * @version 2009.04.17
	     */         
	    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
	        if (OldRow != NewRow) {
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
	        }
	    }
	    /**
	     * OnClick  function <br>
	     *  showing memo on screen <br>
	     * <br><b>Example :</b>
	     * <pre>
	     *
	     * </pre>
	     * @param {ibsheet} sheetObj mandatory IBSheet Object
	     * @param {int} Row mandatory :  Row Index
	     * @param {int} Col mandatory :  Column Index 
	     * @param {str} Value mandatory Format is not applied  
	     * @return 
	     * @author 
	     * @version 2009.06.18
	     */  	           
	     function sheet2_OnClick(sheetObj, Row, Col, Value) {
		    // showing MemoPad when Desc Cell is cliceked(MemoPad editable)
		    var colname=sheetObj.ColSaveName(Col);
		    var amdtSeq=document.form.amdt_seq.value;
		    var eff_dt=document.form.eff_dt.value;
	     	switch(colname)
	     	{
	 	    	case "note_ctnt":
	 	    		sheetObj.SetCellEditable(Row,"note_ctnt",0);
	    			ComShowMemoPad(sheetObj, Row, Col, true, 550); 	
	 	    		break;
	     	}    	 
	    }     
     /**
      * handling process for input validation
      */
		function validateForm(sheetObj, formObj, sAction) {
			switch (sAction) {
	  		case IBCOPYROW: //g/l copy
		  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
					return false;
				} 
	  			if(sheetObjects[0].RowCount()> 0) {
	  				return false;
	  			}
	  			break;
	  		case IBDELETE:
		  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
					return false;
				} 
		  		for(var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
		  			if(sheetObj.GetCellFontStrike( i, "seq") == 1) {
		  				return false;
		  			}
		  		}
	  			break;
	  		case COMMAND02: //DELETE CANCEL
		  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
					return false;
				} 
		  		for(var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
		  			if(sheetObj.GetCellFontStrike( i, "seq") != 1) {
		  				//ComShowCodeMessage("PRI00352");
		  				return false;
		  			}
		  		}
	  			break;
			}
	  		return true;
	  	}
	 	/**
	     *  function which is called when tab from parent screen is clicked <br>
	     * searching <br>
	     * <br><b>Example :</b>
	     * <pre>
	     * tabLoadSheet("ACE", "1")
	     * </pre>
	     * @param {string} sPropNo mandatory prop_no
	     * @param {string} sAmdtSeq mandatory amdt_seq 
	     * @param {string} sSvcScpCd mandatory svc_scp_cd 
	     * @param {string} sPreAmdtSeq mandatory pre_amdt_seq 
	     * @param {string} sPropStsCd mandatory pro_sts_cd 
	     * @param {string} sEffDt mandatory eff_dt 
	     * @param {string} sExpDt mandatory exp_dt 
	     * @param {string} sPreExpDt mandatory pre_exp_dt 
	     * @return 
	     * @author 
	     * @version 2009.05.21
	     */ 
	  	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg, sLgcyIfFlg) {
	  		var formObject=document.form;
	  		if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd || formObject.pre_amdt_seq.value != sPreAmdtSeq ||
	  			formObject.prop_sts_cd.value != sPropStsCd || formObject.eff_dt.value != sEffDt || formObject.pre_exp_dt.value != sPreExpDt || formObject.exp_dt.value != sExpDt) {
	  			formObject.prop_no.value=sPropNo;
	  			formObject.amdt_seq.value=sAmdtSeq;
	  			formObject.svc_scp_cd.value=sSvcScpCd;
	  			formObject.pre_amdt_seq.value=sPreAmdtSeq; 
	  			formObject.prop_sts_cd.value=sPropStsCd; 
	  			formObject.eff_dt.value=sEffDt;
	  			formObject.exp_dt.value=sExpDt;			
	  			formObject.pre_exp_dt.value=sPreExpDt ;
	  			formObject.req_usr_flg.value=sIsReqUsr ;
	  			formObject.apro_usr_flg.value=sIsAproUsr ;	
	 			formObject.dur_dup_flg.value=sDurDupFlg ;
	 			formObject.lgcy_if_flg .value=sLgcyIfFlg ;
	  			copyFlg=true;
	  			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	  			buttonControl();
	  		}
	  	}
	 	/**
	      *  function which clears the control of tab from parent <br>
	      * <br><b>Example :</b>
	      * <pre>
	      * tabClearSheet()
	      * </pre>
	      * @param 
	      * @return 
	      * @author 
	      * @version 2009.05.20
	      */ 
	  	function tabClearSheet() {
	  		var formObject=document.form;
 			formObject.prop_no.value="";
			formObject.amdt_seq.value="";
			formObject.svc_scp_cd.value="";
			formObject.pre_amdt_seq.value="";
			formObject.prop_sts_cd.value="";
			formObject.eff_dt.value="";
			formObject.exp_dt.value="";
			formObject.pre_exp_dt.value="";
			formObject.req_usr_flg.value="";
			formObject.apro_usr_flg.value="";
 			formObject.lgcy_if_flg .value="";
 			formObject.dur_dup_flg.value="";
	  		formObject.note_ref_yr.value="";
	  		formObject.note_nm.value="";
	  		formObject.cust_tp_desc.value="";
	  		copyFlg=true;
	  		sheetObjects[0].RemoveAll();
	  		sheetObjects[1].RemoveAll();
 			buttonControl("CLEAR");	  		
	  	}
	  	var enableFlag=true;
		/**
	     *  function which is called from main<br>
	     * in case Confirmation= YES, it is disable to insert, delete, modify. <br>
	     * <br><b>Example :</b>
	     * <pre>
	     * tabEnableSheet(flag)
	     * </pre>
	     * @param {boolean} flag mandatory 
	     * @return 
	     * @author 
	     * @version 2009.04.17
	     */	  	
	  	function tabEnableSheet(flag) {
	  		enableFlag=flag;
	  	}
   	/**
   	 * OnSearchEnd  function <br>
   	 * <br><b>Example :</b>
   	 * <pre>
   	 * 
   	 * </pre>
   	 * @param {ibsheet} sheetObj mandatory IBSheet Object
   	 * @param {string} ErrMsg mandatory message from server
   	 * @return 
   	 * @author 
   	 * @version 2009.05.20
   	 */ 
   	function sheet1_OnSearchEnd(sheetObj, errMsg){
  		var formObj=document.form;
  		var req_usr_flg=formObj.req_usr_flg.value;
  		var apro_usr_flg=formObj.apro_usr_flg.value;
		var sts=formObj.prop_sts_cd.value;
		var row_count=sheetObj.RowCount();
   	 	var sLgcyIfFlg=formObj.lgcy_if_flg.value;
   		if (errMsg == "") {
   			// GUIDELINE COPY
			if(copyFlg  && sts == "I" && row_count < 1 && (apro_usr_flg=="true" || req_usr_flg=="true" )) {
				doActionIBSheet(sheetObj,formObj,IBCOPYROW);
			} else {
				for(var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
					if(sheetObj.GetCellValue(i,"amdt_seq") > 0 && sLgcyIfFlg != "Y") {
						if(sheetObj.GetCellValue(i,"src_info_cd") == 'AD') {
							sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(), true);
							sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
						} else if(sheetObj.GetCellValue(i,"src_info_cd") == 'AM' || sheetObj.GetCellValue(i,"src_info_cd") == 'NW') {
							sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
						}
					}			
				}
				//highlight
//no support[implemented common]CLT 				changeSelectBackColor4Master(sheetObj, formObj);
			}
   		}
   		buttonControl();
   	}
	/**
	 * OnSearchEnd 이function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {string} ErrMsg mandatory message from server
	 * @return 
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		 manageGetCellEditable(sheetObj);
	 }
    /**
     * OnSaveEnd  function <br>
     * showing the message if it is success to save<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} ErrMsg mandatory message from server
     * @return 
     * @author 
     * @version 2009.06.22
     */ 		
   	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	var formObj=document.form;    	
		//function which is related with Amendment Summary of Main
		parent.comUpdateProposalStatusSummary("31", formObj.svc_scp_cd.value);
	}
	/**
     *  function which control the authority of modifying CELL of sheet<br>
     * 
     * <br><b>Example :</b>
     * <pre>
     * 	manageCellEditable (sheetObj);
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @return 
     * @author 
     * @version 2009.04.17
     */
     function manageGetCellEditable(sheetObj) {
    	 var formObj=document.form;
    	 var amdtSeq=formObj.amdt_seq.value;
    	 var sLgcyIfFlg=formObj.lgcy_if_flg.value;
    	 for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
    		  // in case AMDT_SEQ is different, DISABLE
    		 if(sheetObj.GetCellValue(i,"amdt_seq") != amdtSeq){
    			 sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(), true);
    		  }
    		 if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdtSeq && amdtSeq > 0 && sLgcyIfFlg != "Y"){
    			 sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
    		  }
    	 }
     }
	/**
      *  function of controlling button authority <br>
      * controlling button <br>
      * <br><b>Example :</b>
      * <pre>
      * buttonControl(mode)
      * </pre>
      * @param  {string} mode  
      * @return 
      * @author 
      * @version 2009.04.17
      */
      function buttonControl(mode){ 
    	  	var formObj=document.form;
    	  	var sts=formObj.prop_sts_cd.value;
			var row_cnt=sheetObjects[0].RowCount();
			var req_usr_flg=formObj.req_usr_flg.value;
	 		var apro_usr_flg=formObj.apro_usr_flg.value;
	 		var amdt_seq=formObj.amdt_seq.value;
 			try{
 				ComBtnDisable("btn_glinecopy");
 				ComBtnDisable("btn_delete");
 				hiddenButton("btn_deletecancel");
				if(amdt_seq > 0){
					showButton("btn_deletecancel");
					ComBtnDisable("btn_deletecancel");
				}
				if(mode == "CLEAR") {
					return;
				}
 				switch(sts) { 				
 					case 'I':   // Initial	
 						if(req_usr_flg=="true"||apro_usr_flg=="true"){
							if(row_cnt==0){
								ComBtnEnable("btn_glinecopy");
								ComBtnDisable("btn_delete");
								ComBtnDisable("btn_deletecancel");
							} else {
								ComBtnDisable("btn_glinecopy");
								ComBtnEnable("btn_delete");
								ComBtnEnable("btn_deletecancel");
							}
 						}
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
