/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_03.js
*@FileTitle  : Proposal & Amendment Creation - Commodity Group 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_PRI_2003_03 :business script for ESM_PRI_2003_03 
 */
	// Common Global Variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
    var askOnce=true;
    var isGrpDel=false;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return N/A
     * @author 
     * @version 2009.10.28
     */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);						
					break;
				case "btn_acceptall":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY01);
					break;
				case "btn_cancelall":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY02);
					break;
				case "btn_glinecopy":
					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
					break;
				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
//					applyMasterStyle(sheetObjects[1]);							
					break;
				case "btn_delete1":
					if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)){
						doActionIBSheet(sheetObjects[0],document.form,IBDELETE);						
					}
					break;
				case "btn_delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
					applyMasterStyle(sheetObjects[1]);					
					break;
				case "btn_amend":
					doActionIBSheet(sheetObjects[1],document.form,COMMAND01);
					applyMasterStyle(sheetObjects[1]);					
					break;
				case "btn_amendcancel":
					doActionIBSheet(sheetObjects[1],document.form,COMMAND02);
					applyMasterStyle(sheetObjects[1]);										
					break;
				case "btn_accept":
					if(validateForm(sheetObject2,formObject,MODIFY03)) {
						doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
						applyMasterStyle(sheetObjects[1]);	
					}
					break;	
				case "btn_acceptcancel":
					if(validateForm(sheetObject2,formObject,MODIFY04)) {
						doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
						applyMasterStyle(sheetObjects[1]);
					}
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
    * @param {ibsheet} sheet_obj Mandatory IBSheet Object
    * @return N/A
    * @author 
    * @version 2009.10.28
    */
	function setSheetObject(sheet_obj) {
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
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		resizeSheet();
		buttonControl();
        parent.loadTabPage();
	}
	     
   /**
    * setting sheet initial values and header <br>
    * adding case as numbers of counting sheets  <br>
    * <br><b>Example :</b>
    * <pre>
    *     initSheet(sheetObj,1);
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} sheetNo Mandatory IBSheet Object ,Serial no for Tag's ID
    * @return N/A
    * @author 
    * @version 2009.05.22
    */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|grp_cmdt_seq|Group Code|Description|prc_grp_cmdt_desc_ori|src_info_cd|prc_prog_sts_cd";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",    KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",  KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0, EditLen:100, ExceptKeys:"[/]" },
			             {Type:"Text",      Hidden:1,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc_ori",  UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
			             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetWaitImageVisible(0);
	              SetShowButtonImage(2);
	              resizeSheet(); //SetSheetHeight(300);
		      }
			  break;
			  
			case "sheet2":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|CMDT Type|CMDT Code|Description|EFF Date|EXP Date" +
			      "|Source|Status|grp_cmdt_seq|grp_cmdt_dtl_seq|n1st_cmnc_amdt_seq";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"prc_cmdt_def_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_dtl_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetWaitImageVisible(0);
			      SetColProperty("prc_cmdt_tp_cd", {ComboText:COMODITY_TYPE2[1], ComboCode:COMODITY_TYPE2[0]} );
			      SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
			      SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
			      SetShowButtonImage(2);
			      resizeSheet(); //SetSheetHeight(300);
			      }
			break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	    ComResizeSheet(sheetObjects[1]);
	}
	
  /**
   * Calling Function in case of OnBeforeCheck event <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
   * @param {int} Row Mandatory Onclick ,Cell's Row Index
   * @param {int} Col Mandatory Onclick ,Cell's Column Index
   * @return N/A
   * @author 
   * @version 2009.05.19
   */		
  	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
  		var colName=sheetObj.ColSaveName(Col);
  		if (colName == "chk") {
  			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
  		}
  	}
   /**
    * Calling Function in case of OnBeforeCheck event <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.19
    */		
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}
    /**
    * Calling function in case of Onclick event <br>
    * Highlighting selected row<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory ,Cell's Value
    * @return N/A
    * @author 
    * @version 2009.05.19
    */		
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		if (OldRow != NewRow) {
			//Highlighting
		}
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
    /**
     * Calling Function in case of OnSelectCell event <br>
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
     * @return N/A
     * @author 
     * @version 2009.04.17
     */         
    function sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
        if (OldRow != NewRow) {
        	//Highlighting
        }
    } 
   /**
    * Calling Function in case of OnChange event of sheet2 <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory Onclick ,Cell's Row Index
    * @param {int} Col Mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory ,Cell's Value
    * @return N/A
    * @author 
    * @version 2009.04.17
    */  	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form
    	var sts=sheetObj.GetCellValue(Row, "src_info_cd");
    	switch(colname)
    	{
    		case "prc_cmdt_tp_cd":
    			sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
    			break;
    		
	    	case "prc_cmdt_def_cd":	    		
	    		if (Value.length==6){
	    			formObj.f_cmd.value=SEARCH08;
	    			var sParam=FormQueryString(formObj)+"&cd="+Value;
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"prc_cmdt_def_nm",arrData[1],0);
  						sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","C",0);
  						if(sts=="PC"){
  							sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
  						}else if(sts=="GC"){
  							sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
  						}
  					}else{
  						sheetObj.SetCellValue(Row,"prc_cmdt_def_nm","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
  					}	  				
	    		} else if (Value.length==4){
	    			formObj.f_cmd.value=COMMAND29;
	    			var sParam=FormQueryString(formObj)+"&cd="+Value;
	    			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
	  				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
  					if (arrData[1] != ""){
  						sheetObj.SetCellValue(Row,"prc_cmdt_def_nm",arrData[1],0);
  						sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","R",0);
  						if(sts=="PC"){
  							sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
  						}else if(sts=="GC"){
  							sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
  						}
  					}else{
  						sheetObj.SetCellValue(Row,"prc_cmdt_def_nm","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
	  					sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","",0);
	  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
  					}	  				
	    		} else {	  
	    			sheetObj.SetCellValue(Row,"prc_cmdt_def_nm","",0);
  					sheetObj.SetCellValue(Row,"prc_cmdt_def_cd","",0);
  					sheetObj.SetCellValue(Row,"prc_cmdt_tp_cd","",0);
  					sheetObj.SelectCell(Row,"prc_cmdt_def_cd")
	    		}
	    	break;
    	}
	}
	var isFiredNested=false;
	var supressConfirm=false;
   /**
    * Calling function in case of clicking sheet's row<br>
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
    * @param {string} appendRow Mandatory 
    * @return N/A
    * @author 
    * @version 2009.05.19
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
			
			if (sheetD.IsDataModified() || sheetM.IsDataModified()) {
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
				formObj.grp_cmdt_seq.value=sheetM.GetCellValue(adjNewRow, "grp_cmdt_seq");
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
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,Process Flag constant variable
    * @return N/A
    * @author 
    * @version 2009.05.22
    */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
				case IBSEARCH: // Retrieving
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	  				ComOpenWait(true);
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2003_03GS.do", FormQueryString(formObj), {Sync:2} );
					break;
				case IBSEARCHAPPEND: // Retrieving
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH02;
						sheetObj.DoSearch("ESM_PRI_2003_03GS.do", FormQueryString(formObj), {Sync:2});
					}
					break;
				case IBSEARCH_ASYNC02: // Retrieving - checking wheter rate is in use or not when deleting Group
					if (validateForm(sheetObj,document.form,sAction)) {
						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr.length == 0){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
						}						
						var sParam="f_cmd="+SEARCH03+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml=sheetObj.GetSearchData("ESM_PRI_2003_03GS.do", sParam);
						var rsltCnt=ComPriGetRowCountFromXML(sXml);
						if(rsltCnt>0){
							ComShowCodeMessage("PRI08017");	
							return false;
						}
					}
					return true;
				break;
				
				case IBSEARCH_ASYNC03: // Saving - Diable to delete group in use
					if (validateForm(sheetObj,document.form,sAction)) {
			   			var amdt_seq=formObj.amdt_seq.value;
						var rowCnt=sheetObjects[1].RowCount()- ComPriSheetFilterRows(sheetObjects[1], "n1st_cmnc_amdt_seq", amdt_seq).length;
						var newCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length - ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length - ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
						var ndlCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length - ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length - ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
						var delCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;	   		
						if (rowCnt + newCnt - ndlCnt - delCnt == 0) {
			   				var sParam="f_cmd="+SEARCH03+"&ibflag=R"
			   				+"&prop_no="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"prop_no")
			   				+"&amdt_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")
			   				+"&svc_scp_cd="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"svc_scp_cd")
			   				+"&grp_cmdt_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"grp_cmdt_seq");
			   				var sXml=sheetObj.GetSearchData("ESM_PRI_2003_03GS.do", sParam);
							var rsltCnt=ComPriGetRowCountFromXML(sXml);
							if(rsltCnt>=0){
								ComShowCodeMessage("PRI08017");	
								return true;
							}
						}	
					}
					return false;
				break;
				
				case IBSAVE: // Saving
					isFiredNested=false;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (!supressConfirm && !ComPriConfirmSave()) {
						return false;
					}
					findDescChanged();
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
	  				ComOpenWait(true);
	  				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_03GS.do", sParam);
					isFiredNested=true;
					sheetObjects[1].LoadSaveData(sXml);
					sXml=ComDeleteMsg(sXml);
					sheetObjects[0].LoadSaveData(sXml);
					isFiredNested=false;
					if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
						return false;
					} else {
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					return true;
					break;
					
				case IBINSERT: // Row Add
					var prop_no=formObj.prop_no.value;
					var amdt_seq=formObj.amdt_seq.value; 
					var svc_scp_cd=formObj.svc_scp_cd.value;
					var eff_dt=formObj.eff_dt.value;
					var exp_dt=formObj.exp_dt.value;
					if (enableFlag && validateForm(sheetObj,document.form,sAction)) {
						if (sheetObj.id == "sheet1") {
							var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
							if (idx < 0) {
								return false;
							}
							sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
							sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
							sheetObj.SetCellValue(idx, "grp_cmdt_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_seq")) + 1,0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
	  						maxCode=groupCodeGetMax(sheetObj, "prc_grp_cmdt_cd") + 1;
	  						sheetObj.SetCellValue(idx,"prc_grp_cmdt_desc","Group "+ maxCode,0);
	  						maxCode=ComLpad(maxCode,   4, "0");
							sheetObj.SetCellValue(idx,"prc_grp_cmdt_cd","G"+ maxCode,0);
							sheetObjects[1].RemoveAll();
						} else if (sheetObj.id == "sheet2") {
							if(sheetObjects[0].RowCount()==0||sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"ibflag")=="D"||
							   sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"src_info_cd")=="AD"){
								ComShowCodeMessage("PRI01004");
								return;							
							}
							var amdt_seq=formObj.amdt_seq.value;
							if(sheetObj.SearchRows()!=0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")!= amdt_seq ){
								ComShowCodeMessage("PRI01002");		
							 	return;
							}							
							var idx=sheetObj.DataInsert();
							sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
							sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
							sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
							sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I",0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "prc_cmdt_tp_cd","C",0);
							var grp_cmdt_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_cmdt_seq");
							sheetObj.SetCellValue(idx, "grp_cmdt_seq",grp_cmdt_seq,0);
							sheetObj.SetCellValue(idx, "grp_cmdt_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_cmdt_dtl_seq")) + 1,0);
							sheetObj.SelectCell(idx, "prc_cmdt_def_cd");
							
							sheetObj.SetCellEditable(idx,"prc_cmdt_tp_cd",1);		
		 					sheetObj.SetCellEditable(idx,"prc_cmdt_def_cd",1);	
						}
						if(amdt_seq != 0){
							sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
						}
						if (sheetObj.id == "sheet2") {
							applyMasterStyle(sheetObj);
						}
					}
					break;
				case IBDELETE: // Delete
					if(!validateForm(sheetObj, formObj, IBDELETE)) {
						return false;
					}
					var amdt_seq=formObj.amdt_seq.value;
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(chkArr.length == 0){
						sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
					}	
					chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
					if(amdt_seq=="0"){
						if (enableFlag && validateForm(sheetObj,document.form,sAction)) {
							if (sheetObj.id == "sheet1") {
								isGrpDel=true;
								if(sheetObj.RowCount()==sheetObj.CheckedRows("chk")){
									isFiredNested=true;
									sheetObj.SetSelectRow(1)
									isFiredNested=false;
								}					
								var checkRow=sheetObj.FindCheckedRow("chk");	
								if(sheetObj.RowCount()==sheetObj.CheckedRows("chk") || (("|" + checkRow).indexOf("|" + sheetObj.GetSelectRow()) >= 0)){
									sheetObjects[1].RemoveAll();
								}
							}
							deleteRowCheck(sheetObj, "chk");
						}
					} else{
						var amdt_seq=formObj.amdt_seq.value;
						if (sheetObj.id == "sheet1") {
							isGrpDel=true;
							for(j=0;j < chkArr.length;j++){
								sheetObj.SetCellFont("FontStrike", chkArr[j], 1, chkArr[j], sheetObj.LastCol(), true);
								sheetObj.SetCellFont("FontColor", chkArr[j], 1, chkArr[j], sheetObj.LastCol(),"#FF0000");
								if(sheetObj.GetCellValue(chkArr[j],"src_info_cd") != "NW" && sheetObj.GetCellValue(chkArr[j],"ibflag") != "I"){
									sheetObj.SetRowStatus(chkArr[j],"D");
									sheetObj.SetCellValue(chkArr[j],"chk","0");
									sheetObj.SetCellValue(chkArr[j],"n1st_cmnc_amdt_seq",amdt_seq);
								}
							}
							deleteRowCheck(sheetObj, "chk");
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), amdt_seq);
							if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"ibflag") == "D"){
								var row=0;
								sheetObjects[1].CheckAll("chk","1",1);
								var chkArrDtl=ComPriSheetFilterRows(sheetObjects[1], "chk", "1");
							    for(i=0;i<chkArrDtl.length;i++){
							    	if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq && sheetObjects[1].GetCellValue(chkArrDtl[i],"ibflag")!="I"){
		   								comSheetAmendCancelRow(sheetObjects[1],formObj,chkArrDtl[i],"A", "prc_cmdt_def_cd");
							    	}else if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq") == amdt_seq && sheetObjects[1].GetCellValue(chkArrDtl[i],"ibflag") == "I"){
										sheetObjects[1].SetRowStatus(chkArr[i],"D");
										sheetObjects[1].SetRowEditable(chkArr[i],false);
										sheetObjects[1].SetRowHidden(chkArr[i], true);
		  							}
							    }
							    sheetObjects[1].CheckAll("chk","1",1);
								if(sheetObjects[1].RowCount()>0){
								    doActionIBSheet(sheetObjects[1],document.form,IBDELETE);							
								}
							}
						} else{
							for(i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq && 
										(sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"))){
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
							var sRow=0;
							for(j=0;j < chkArr.length;j++){
								if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","prc_cmdt_def_cd");		
									sRow++;								
								}
							}
							deleteRowCheck(sheetObj, "chk");			
						}
					}
					if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
						sheetObjects[1].RemoveAll();
					}
		        	var delCnt=deleteRowCheck(sheetObj, "chk");
		        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
						sheetObjects[1].RemoveAll();
					}
					//Checking in case of deleting all rows of DETAIL
					if (!isGrpDel && sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00021')){
			  				ComOpenWait(true);
			  				//Unckecking checked data on MASTER
							sheetObjects[0].CheckAll("chk",0,1);
							if(!doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)){
								formObj.grp_cmdt_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_cmdt_seq");
								doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
								return false;
							} else {
								isGrpDel=true;
								if (sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "chk") == "1") {
									sheetObjects[1].RemoveAll();
								}
								var delCnt=deleteRowCheck(sheetObjects[0], "chk");
								if (delCnt > 0 && sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) == "D") {
									sheetObjects[1].RemoveAll();
								}
							}
						}
					}
					isFiredNested=false;
					break;
					
				case IBCOPYROW: // Guideline Copy
					if (!supressConfirm && !ComShowCodeConfirm("PRI03006")) {
						return false;
					}else{				
		  				ComOpenWait(true);
						formObj.f_cmd.value=MULTI06;
						var sParam=FormQueryString(formObj);
						var sXml=sheetObj.GetSaveData("ESM_PRI_2003_03GS.do", sParam+"&prc_cust_tp_cd="+parent.comboObjects[2].GetSelectCode());
						formObj.f_cmd.value=SEARCH02;					
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						sheetObjects[1].LoadSaveData(sXml);
					}
					break;	
					
				case MODIFY01: // Accept All
					if(!validateForm(sheetObj, formObj, MODIFY01)) {
						return false;
					}
					if (!supressConfirm && !ComShowCodeConfirm('PRI01015')) {
						return false;
					}	
	  				ComOpenWait(true);
					formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_PRI_2003_03GS.do", sParam);
					sheetObj.LoadSaveData(sXml);
					if(ComGetEtcData(sXml,"result")!="OK"){
						return;
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
					
				case MODIFY02: // Cancel All
					if(!validateForm(sheetObj, formObj, MODIFY01)) {
						return false;
					}
					if (!supressConfirm && !ComShowCodeConfirm('PRI01010')) {
						return false;
					}			
	  				ComOpenWait(true);
					formObj.f_cmd.value=MULTI03;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_PRI_2003_03GS.do", sParam);
					sheetObj.LoadSaveData(sXml);
					if(ComGetEtcData(sXml,"result")!="OK"){
						return;
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;		
					
				case MODIFY03: // Accept
					if (!supressConfirm && !ComShowCodeConfirm('PRI00008')) {
						return false;
					}			
					formObj.f_cmd.value=MULTI04;
					comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_03GS.do");
					break;
					
				case MODIFY04: // Accept Cancel
					if (!supressConfirm && !ComShowCodeConfirm('PRI00009')) {
						return false;
					}						
					formObj.f_cmd.value=MULTI05;
					comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_03GS.do");
					break;	
					
				case COMMAND01: // Amend
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","prc_cmdt_tp_cd|prc_cmdt_def_cd");						
						}
					} else{ 
						comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M","prc_cmdt_tp_cd|prc_cmdt_def_cd");
					}
					sheetObj.SelectCell(sheetObj.GetSelectRow(), "prc_cmdt_def_cd");
					break;		
					
				case COMMAND02: // Amend Cancel
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "prc_cmdt_tp_cd|prc_cmdt_def_cd");						
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "prc_cmdt_tp_cd|prc_cmdt_def_cd");
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
    * Calling Function in case of OnPopupClick event <br>
    * Calling Location PopUp <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.07
    */ 	 
 	function sheet2_OnPopupClick(sheetObj, Row, Col)
 	{
 		var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		var sts=formObj.prop_sts_cd.value;
 		var tpCd="C";
 		var prcCmdtTpCd=sheetObj.GetCellValue(Row,"prc_cmdt_tp_cd");
       	switch(colName)
       	{
   	    	case "prc_cmdt_def_cd":
   	    		var commodityCmd="C";
   	    		var prc_cmdt_def_cd=sheetObj.GetCellValue(Row, Col);
   	    		var sts=sheetObj.GetCellValue(Row, "src_info_cd");
   	    		var sUrl="/opuscntr/ESM_PRI_4027.do?prc_cmdt_tp_cd="+ prcCmdtTpCd + "&commodity_cmd=CR&grp_cd="+PRI_RP_SCP;
   	    		ComOpenPopup(sUrl, 700, 345, "findCommodity", "1,0,1,1,1,1,1", true);
       	}       	
 	}   
 	
  	function findCommodity(rtnVal) {
  		var formObj = document.form;
  		var sheetObj=sheetObjects[1];
  		var sts=formObj.prop_sts_cd.value;
  		if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol() + 1,rtnVal.nm,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_cmdt_tp_cd",rtnVal.tp,0);
				if(sts=="PC"){
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "src_info_cd","PM",0);
				}else if(sts=="GC"){
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "src_info_cd","GM",0);
				}
			}   		
   }		
    /**
     * handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         handling logic;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory ,Process Flag constant variable
     * @returns bool <br>
     *          true  : valid<br>
     *          false : invalid
     * @author 
     * @version 2009.04.17
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
				if ( ComShowCodeConfirm("PRI00010") ) {
            		return true;
				}            		            	
	            return false;       
            }
			break;
			
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
			
		case IBSEARCH_ASYNC02: // Retrieving
			return true;
			break;		
			
		case IBSEARCH_ASYNC03: // Retrieving
			return true;
			break;
			
		case IBSAVE: // Saving
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			if (!isGrpDel&&sheetObjects[1].RowCount()<= 0) {
   				ComShowCodeMessage("PRI00319", "Commodity Group");
				return false;
			}		
			if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
   				ComShowCodeMessage("PRI00319", "Commodity Group");
				return false;
			}	
   			if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03)){
				return false;				
			}
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			var rowM=ComPriAmendDupCheck(sheetObjects[0], "prc_grp_cmdt_cd", formObj.amdt_seq.value);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}
			var rowD=ComPriAmendDupCheck(sheetObjects[1], "amdt_seq|grp_cmdt_seq|prc_cmdt_tp_cd|prc_cmdt_def_cd", formObj.amdt_seq.value);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			break;
			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} 
			if (sheetObj.id == "sheet2" && getValidRowCount(sheetObjects[0]) == 0) {
				ComShowCodeMessage("PRI01004");
				return false;					
			}
			break;
			
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			if (getValidRowCount(sheetObj) == 0) {
				return false;					
			}
			break;
			
		case IBCOPYROW: // Guideline Copy
			if(sheetObjects[0].RowCount()> 0) {
				return false;
			}
			break;
			
		case MODIFY01: // Accept All
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;
			
  		case MODIFY02: // Cancel
	  		if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
  			if (getValidRowCount(sheetObj) <= 0) {
	            return false;
			}
			break;	
			
		case MODIFY03: // Accept
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
				}
			}
			break;
			
		case MODIFY04: // Accept cancel
			var chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			if(chkArr.length == 0){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
			}	
			chkArr=ComPriSheetCheckedRows(sheetObj, "chk");
			for(var i=0;i < chkArr.length;i++){
				if(formObj.amdt_seq.value != sheetObj.GetCellValue(chkArr[i], "n1st_cmnc_amdt_seq")) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
				if(sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") == "I") {
					ComShowCodeMessage("PRI01038");
					return false;
				}
			}
			break;	
		}
		return true;
	}
 	/**
    * Calling function in case of clicking tab on parent screen<br>
    * <br><b>Example :</b>
    * <pre>
    * tabLoadSheet("ACE", "1")
    * </pre>
    * @param {string} sPropNo Mandatory prop_no 
    * @param {string} sAmdtSeq Mandatory amdt_seq 
    * @param {string} sSvcScpCd Mandatory svc_scp_cd 
    * @param {string} sPreAmdtSeq Mandatory pre_amdt_seq 
    * @param {string} sPropStsCd Mandatory pro_sts_cd 
    * @param {string} sEffDt Mandatory eff_dt 
    * @param {string} sExpDt Mandatory exp_dt 
    * @param {string} sPreExpDt Mandatory pre_exp_dt 
    * @return N/A
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
			formObject.dur_dup_flg.value="Y" ;
	        askOnce=true;
			//buttonControl();  //close
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}	
	/**
    * Clearing controls of tab screen on parent screen<br>
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
		formObject.pre_amdt_seq.value="";
		formObject.prop_sts_cd.value="";
		formObject.eff_dt.value="";
		formObject.exp_dt.value="";			
		formObject.pre_exp_dt.value="";
		formObject.req_usr_flg.value="";
		formObject.apro_usr_flg.value="";
		formObject.dur_dup_flg.value="";
        askOnce=true;
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		buttonControl("CLEAR");
	}
	var enableFlag=true;
	/**
     * Calling function from main<br>
     * if Confirmation= YES,diable to add,delete,modify<br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory ,from main
     * @return N/A
     * @author 
     * @version 2009.04.17
     */	
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
	}
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		buttonControl_1(sheetObj,"");
	}
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {string} ErrMsg Mandatory ,message from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.20
	 */ 	
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var formObj=document.form;
		isGrpDel=false;
		isFiredNested=false;
		buttonControl_1(sheetObj,"");
		doActionIBSheet(sheetObjects[1],formObj,IBSEARCHAPPEND);
	}
    /**
     * Calling function in case of OnSaveEnd event <br>
     * showing message  in case of sucessful saving <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {string} ErrMsg Mandatory ,message from server
     * @return N/A
     * @author 
     * @version 2009.06.22
     */ 		
   	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
    	 var formObj=document.form;
    	 //Main 의 Amendment Summary 관련 function
    	 parent.comUpdateProposalStatusSummary("14", formObj.svc_scp_cd.value);
    	 buttonControl_1(sheetObj,"");
	}
	/**
	* Setting master's style
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     applyMasterStyle(sheetObj);
	* </pre>
	* @return N/A
	* @author 
	* @version 2009.05.17
	*/		
	function applyMasterStyle(sheetObj){
		var formObj=document.form;
		var amdt_seq=formObj.amdt_seq.value;
		var rowCnt=ComPriSheetFilterRows(sheetObj, "prc_prog_sts_cd", "A");
		var newCnt=ComPriSheetFilterRows(sheetObj, "src_info_cd|n1st_cmnc_amdt_seq", "NW|"+amdt_seq);
		var ndlCnt=ComPriSheetFilterRows(sheetObj, "src_info_cd|ibflag", "NW|D");
		var amdCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq);
		var delCnt=ComPriSheetFilterRows(sheetObj, "src_info_cd|amdt_seq", "AD|"+amdt_seq);
		var actCnt=ComPriSheetFilterRows(sheetObj, "n1st_cmnc_amdt_seq|prc_prog_sts_cd", amdt_seq+"|A");
		var grp_sts=amdCnt.length == ndlCnt.length ? false : true;
		var grp_flg=rowCnt.length + newCnt.length - ndlCnt.length == delCnt.length ? true : false;
		var grp_act=amdCnt.length == actCnt.length ? true : false ;
		if(delCnt.length==0) grp_flg=false;
		sheetObjects[0].GetCellFont("FontColor", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(),"#000000" );
		if(amdt_seq!=0){
			sheetObjects[0].SetCellFont("FontColor", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(),"#FF0000");//(grp_sts ? "#FF00000000");
			sheetObjects[0].SetCellFont("FontStrike", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(), grp_flg);//(grp_flg);
		}
	}
	/**
    * Controlling button's authority<br>
    * <br><b>Example :</b>
    * <pre>
    * buttonControl(mode)
    * </pre>
    * @param {string} mode Mandatory,user mode or authority
    * @return N/A
    * @author 
    * @version 2009.04.17
    */	
	function buttonControl(mode){
		var formObj=document.form;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var amdt_seq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		var row_cnt=sheetObjects[0].RowCount();
		try {
			sheetObjects[0].SetEditable(0);
			sheetObjects[1].SetEditable(0);
			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_acceptall");
			ComBtnDisable("btn_cancelall");
			ComBtnDisable("btn_glinecopy");
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_delete2");
			ComBtnDisable("btn_amend");
			ComBtnDisable("btn_amendcancel");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
			showButton("btn_amendcancel");
			showButton("btn_amend");
			if(amdt_seq==0){
				hiddenButton("btn_amendcancel");
				hiddenButton("btn_amend");
			}
			if(mode == "CLEAR") {
				return;
			}
			switch(sts) {
				case 'I':   // Initial
					ComBtnEnable("btn_retrieve");
					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
						sheetObjects[0].SetEditable(1);
						sheetObjects[1].SetEditable(1);
						if(amdt_seq==0){
//							sheetObjects[0].InitDataProperty(0, 7, dtData, 90, daCenter, false, "prc_grp_cmdt_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
//							sheetObjects[0].InitDataProperty(0, 8, dtData, 150, daLeft, false, "prc_grp_cmdt_desc", true, "", dfEngKey, 0, true, true, 100);
//							sheetObjects[1].InitDataProperty(0, 6, dtCombo,    85, daCenter, false, "prc_cmdt_tp_cd",  true, "", dfNone, 0, true, true);
//							sheetObjects[1].InitDataProperty(0, 7, dtPopupEdit, 85, daCenter, false,"prc_cmdt_def_cd", 	true, "", dfNone, 	0, true, true, 6);							
						}else{
//							sheetObjects[0].InitDataProperty(0, 7, dtData, 90, daCenter, false, "prc_grp_cmdt_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
//							sheetObjects[0].InitDataProperty(0, 8, dtData, 150, daLeft, false, "prc_grp_cmdt_desc", true, "", dfEngKey, 0, true, true, 100);
//							sheetObjects[1].InitDataProperty(0, 6, dtCombo,    85, daCenter, false, "prc_cmdt_tp_cd",  true, "", dfNone, 0, false, true);
//							sheetObjects[1].InitDataProperty(0, 7, dtPopupEdit, 85, daCenter, false,"prc_cmdt_def_cd", 	true, "", dfNone, 	0, false, true, 6);														
						}
						ComBtnEnable("btn_save");					
						ComBtnEnable("btn_rowadd1");
						ComBtnEnable("btn_delete1");
						ComBtnEnable("btn_rowadd2");
						ComBtnEnable("btn_delete2");
						ComBtnEnable("btn_amend");
						ComBtnEnable("btn_amendcancel");	
						if(row_cnt==0){
							ComBtnEnable("btn_glinecopy");
						}else{
							ComBtnDisable("btn_glinecopy");
						}						
					}
					break;
				case 'Q':   // Requested
					ComBtnEnable("btn_retrieve");
					if(apro_usr_flg == "true"){						
						sheetObjects[0].SetEditable(1);
						sheetObjects[1].SetEditable(1);
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_cancelall");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					}
					break;
				case 'R':   // Returned
					ComBtnEnable("btn_retrieve");
					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					}				
					break;
				case 'A':   // Approved
					ComBtnEnable("btn_retrieve");
				case 'F':   // Filed
					ComBtnEnable("btn_retrieve");
				case 'C':   // Cancled
					ComBtnEnable("btn_retrieve");
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
	/**
	* Getting max sequence of sheet's column
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     groupCodeGetMax(sheetObj, sCol);
	* </pre>
	* @return Integer
	* @author 
	* @version 2009.05.17
	*/		
   function groupCodeGetMax(sheetObj, sCol) {
       var max=0;
       for (var i=0; i <= sheetObj.LastRow(); i++) {
    	   if (parseInt(sheetObj.GetCellValue(i, sCol).substr(1,4),10) > max) {
    		   max=parseInt(sheetObj.GetCellValue(i, sCol).substr(1,4), 10 );
           }
       }
       return max;
   }	

	function buttonControl_1(sheetObj, mode){ 
		var formObj=document.form;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var amdt_seq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		var row_cnt=sheetObjects[0].RowCount();
		try {
			sheetObj.SetEditable(0);
			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_acceptall");
			ComBtnDisable("btn_cancelall");
			ComBtnDisable("btn_glinecopy");
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_delete2");
			ComBtnDisable("btn_amend");
			ComBtnDisable("btn_amendcancel");
			ComBtnDisable("btn_accept");
			ComBtnDisable("btn_acceptcancel");
			showButton("btn_amendcancel");
			showButton("btn_amend");
			if(amdt_seq==0){
				hiddenButton("btn_amendcancel");
				hiddenButton("btn_amend");
			}
			if (sheetObj.id == "sheet1") {
 				for (var i=1; i <= sheetObj.RowCount();i++){
 					sheetObj.SetCellEditable(i,"prc_grp_cmdt_cd",0);
 	 			}	
 			} else if (sheetObj.id == "sheet2"){
 				for (var i=1; i <= sheetObj.RowCount();i++){
 					sheetObj.SetCellEditable(i,"prc_cmdt_tp_cd",0);
 					sheetObj.SetCellEditable(i,"prc_cmdt_def_cd",0);
 	 			}
 			}
			for(i=1;i<=sheetObjects[0].RowCount();i++){
				if(amdt_seq!=0){
					if(sheetObjects[0].GetCellValue(i,"src_info_cd")=="AD"){
						sheetObjects[0].SetCellFont("FontStrike", i, 1, i, sheetObjects[0].LastCol(), true);
					}
					if(sheetObjects[0].GetCellValue(i,"src_info_cd")=="AM"||sheetObjects[0].GetCellValue(i,"src_info_cd")=="AD"||sheetObjects[0].GetCellValue(i,"src_info_cd")=="NW"){
						sheetObjects[0].SetCellFont("FontColor", i, 1, i, sheetObjects[0].LastCol(),"#FF0000");
					}
				}
			}
			for(i=1;i<=sheetObjects[1].RowCount();i++){
				if(amdt_seq!=0){
					if(sheetObjects[1].GetCellValue(i,"amdt_seq") != amdt_seq){
						sheetObjects[1].SetCellFont("FontStrike", i, 1, i, sheetObjects[1].LastCol(), true);
					}
					else if(sheetObjects[1].GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
						sheetObjects[1].SetCellFont("FontColor", i, 1, i, sheetObjects[1].LastCol(),"#FF0000");
					}
				}
			}
			if(mode == "CLEAR") {
				return;
			}
			switch(sts) {
				case 'I':   // Initial
					ComBtnEnable("btn_retrieve");
					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
						sheetObj.SetEditable(1);
						if(amdt_seq==0){
							if (sheetObj.id == "sheet1") { 			 			
				 				for (var i=1; i <= sheetObj.RowCount();i++){
				 					sheetObj.SetCellEditable(i,"prc_grp_cmdt_cd",1);
				 	 			}	
				 			} else if (sheetObj.id == "sheet2"){
				 				for (var i=1; i <= sheetObj.RowCount();i++){
				 					sheetObj.SetCellEditable(i,"prc_cmdt_tp_cd",1);		
				 					sheetObj.SetCellEditable(i,"prc_cmdt_def_cd",1);				
				 	 			}
				 			}							
						}else{
							if (sheetObj.id == "sheet1") {
				 				for (var i=1; i <= sheetObj.RowCount();i++){
				 					sheetObj.SetCellEditable(i,"prc_grp_cmdt_cd",0);
				 	 			}	
				 			} else if (sheetObj.id == "sheet2"){
				 				for (var i=1; i <= sheetObj.RowCount();i++){
				 					if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
					 					sheetObj.SetCellEditable(i,"prc_cmdt_tp_cd",1);		
					 					sheetObj.SetCellEditable(i,"prc_cmdt_def_cd",1);
				 					}
			 					}
				 			}			
						}
						ComBtnEnable("btn_save");					
						ComBtnEnable("btn_rowadd1");
						ComBtnEnable("btn_delete1");
						ComBtnEnable("btn_rowadd2");
						ComBtnEnable("btn_delete2");
						ComBtnEnable("btn_amend");
						ComBtnEnable("btn_amendcancel");	
						if(row_cnt==0){
							ComBtnEnable("btn_glinecopy");
						}else{
							ComBtnDisable("btn_glinecopy");
						}						
					}
					break;
				case 'Q':   // Requested
					ComBtnEnable("btn_retrieve");
					if(apro_usr_flg == "true"){						
						sheetObj.SetEditable(1);
						ComBtnEnable("btn_acceptall");
						ComBtnEnable("btn_cancelall");
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					}
					break;
				case 'R':   // Returned
					ComBtnEnable("btn_retrieve");
					if(apro_usr_flg == "true" || req_usr_flg == "true" ){
						ComBtnEnable("btn_accept");
						ComBtnEnable("btn_acceptcancel");
					}				
					break;
				case 'A':   // Approved
					ComBtnEnable("btn_retrieve");
				case 'F':   // Filed
					ComBtnEnable("btn_retrieve");
				case 'C':   // Cancled
					ComBtnEnable("btn_retrieve");
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

	/**
	 * Calling function in case of Onclick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2015.06.24 
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		var amdtSeq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		if(sheetObj.GetSelectRow() != Row){
			return;
		}
		var memoColWidth =	sheetObj.GetColWidth("prc_grp_cmdt_desc");
		if (colName == "prc_grp_cmdt_desc") {
			if(req_usr_flg=="true"||apro_usr_flg=="true"){
				if (sts=="I" && sheetObj.GetCellValue(Row, "src_info_cd" )!="AD") {
					ComShowMemoPad(sheetObj, Row, Col, false, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
				} else {
					ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
				}
			
				$("#"+MEMO_TEXT_NAME).blur(function(event){
					$(this).val($(this).val().replace(/\//gi, ""));
					$("#"+MEMO_TEXT_NAME).unbind();
				});
			}else{
				ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
			}
		}
	}

	function findDescChanged(){
		var formObj = document.form;
		var selectRow = sheetObjects[0].GetSelectRow();
		var amdCnt = 0;
		var newDesc = sheetObjects[0].GetCellValue(selectRow, "prc_grp_cmdt_desc").replace(/\s/gi, '');
		var oldDesc = sheetObjects[0].GetCellValue(selectRow, "prc_grp_cmdt_desc_ori").replace(/\s/gi, '');
		if(newDesc != oldDesc){
			for(var i=1; i<=sheetObjects[1].RowCount(); i++){
				if(sheetObjects[1].GetRowHidden(i) == 1){
					continue;
				}
				if(sheetObjects[1].GetCellValue(i, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
					amdCnt ++;
				}
			}
			if(amdCnt == 0){
				if(sheetObjects[1].GetRowHidden(1) == 1){
					comSheetAmendRow(sheetObjects[1],formObj,2,"M","prc_cmdt_def_cd");
				}else{
					comSheetAmendRow(sheetObjects[1],formObj,1,"M","prc_cmdt_def_cd");
				}
				applyMasterStyle(sheetObjects[1]);
			}
		}
	}
	
	