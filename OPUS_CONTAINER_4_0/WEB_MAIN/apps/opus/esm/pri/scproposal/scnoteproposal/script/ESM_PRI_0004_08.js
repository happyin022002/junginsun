/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : ESM_PRI_0004_08.js
*@FileTitle  : S/C Proposal Standard Note - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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
	// Event handler processing by button click event */
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
		/*****using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
    * <br><b>Example :</b>
    * <pre>
    *     setSheetObject(sheetObj);
    * </pre>
    * @param {ibsheet} sheet_obj mandatory IBSheet Object
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
     * @version 2009.05.17
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
		resizeSheet();
        parent.loadTabPage();
	}
   /**
    * setting sheet initial values and header
    *  param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    * @version 2009.05.22
    */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":
			    with(sheetObj){
			      var HeadTitle="|Seq.|dp_seq|note_seq|Title";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",   Sort:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
			             {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:"note_tit_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetWaitImageVisible(0);
		            SetAutoRowHeight(0);
			        SetSheetHeight(120);
		      }
				break;
			case "sheet2":
			    with(sheetObj){
			      var HeadTitle="|Seq.|dp_seq|note_seq|Content|EFF Date|EXP Date|Source|Status|Accept Staff/Team|Accept Date|n1st_cmnc_amdt_seq";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",   Sort:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq" },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_seq" },
			             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:340,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:10,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
			      SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
			      SetWaitImageVisible(0);
	              //SetAutoRowHeight(0);
	              resizeSheet(); //SetSheetHeight(140);
			}
			 break;
		}
	}
	
	function resizeSheet() {
		ComResizeSheet(sheetObjects[1]);
	}
	
	
	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
	     sheetObj.ReNumberSeq();    
	}
	
	function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
	     sheetObj.ReNumberSeq();    
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
	    			    sParam += "&prc_cust_tp_cd="+parent.getCustTypeCode();
 	    			    var sXml=sheetObj.GetSearchData("ESM_PRI_0004_08GS.do", sParam);
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
	    				formObj.note_tp_cd.value="T";
 	    				sheetObj.DoSearch("ESM_PRI_0004_08GS.do", FormQueryString(formObj) );
	      				ComOpenWait(false);
	    				break;
	    			case IBSEARCHAPPEND: 
	      				ComOpenWait(true);
	    				formObj.f_cmd.value=SEARCH03;
 	    				sheetObj.DoSearch("ESM_PRI_0004_08GS.do", FormQueryString(formObj) );
	      				ComOpenWait(false);
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
	      *  Event which is called when object instance is completed <br>
	      * <br><b>Example :</b>
	      * <pre>
	      *
	      * </pre>
	      * @param {ibsheet} sheetObj mandatory IBSheet Object
	      * @return 
	      * @author 
	      * @version 2009.08.04
	      */
	      function sheet2_OnLoadFinish_backup(sheetObj) {   
	          doActionIBSheet(sheetObjects[1],document.form,IBCLEAR);
	      }
	   /**
	    *  OnClick  function <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *	
	    * </pre>
	    * @param {ibsheet} sheetObj mandatory HTML tag (Object) 
	    * @param {int} Row mandatory Onclick - Row Index
	    * @param {int} Col mandatory Onclick - Column Index
	    * @param {string} Value mandatory cell 값
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
	     * handling the Row highlighted when the Row of sheet is clicked <br>
	     * <br><b>Example :</b>
	     * <pre>
	     *
	     * </pre>
	     * @param {ibsheet} sheetObj mandatory HTML (Object) 
	     * @param {int} OldRow mandatory Onclick - Row Index of cell which is called event
	     * @param {int} OldCol mandatory Onclick - Column Index of cell which is called event
	     * @param {int} NewRow mandatory Onclick - Row Index of cell which is called event
	     * @param {int} NewCol mandatory Onclick - Column Index of cell which is called event
	     * @return 
	     * @author 
	     * @version 2009.05.19
	     */	
		function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, false);
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
		    //showing MemoPad when Desc Cell is cliceked(MemoPad editable)
		    var colname=sheetObj.ColSaveName(Col);
		    var amdtSeq=document.form.amdt_seq.value;
		    var eff_dt=document.form.eff_dt.value;
	     	switch(colname)
	     	{
	 	    	case "note_ctnt":
	 	    		sheetObj.SetCellEditable(Row,"note_ctnt",0);
	    			ComShowMemoPad(sheetObj, Row, Col, true, 400); 	
	 	    		break;
	     	}    	 
	    }     
	     /**
	      * handling process for input validation
	      */
		function validateForm(sheetObj, formObj, sAction) {
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
	  	function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg) {
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
	  			copyFlg=true;
	  			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	  		}
	  	}
	 	/**
	      * function which clears the control of tab from parent <br>
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
	  		copyFlg=true;
	  		sheetObjects[0].RemoveAll();
	  		sheetObjects[1].RemoveAll();
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
	  		var formObject=document.form;
	  		enableFlag=flag;
	  	}
