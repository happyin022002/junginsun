/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_02.js
*@FileTitle  : RFA Proposal Creation - Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 /**
 * @extends 
 * @class ESM_PRI_2003_02 : Business Script for ESM_PRI_2003_02
 */
	// common global variables
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
					applyMasterStyle(sheetObjects[1]);										
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
						break;
					}
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
    * @param {ibsheet} sheet_obj mandatory IBSheet Object
    * @return void
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
    * @return void
    * @author 
    * @version 2009.05.17
    */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			// Modify Enviroment Setting Function's name
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// Add Environment Setting Function 
			ComEndConfigSheet(sheetObjects[i]);
		}
		resizeSheet();
		buttonControl(null, null);
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
    * @version 2009.05.22
    */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Ori/Dst|Group Code|Description|prc_prog_sts_cd|src_info_cd";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:100 },
			             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"prc_prog_sts_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"src_info_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetWaitImageVisible(0);
			      SetColProperty("org_dest_tp_cd", {ComboText:orgDestTpCdComboText, ComboCode:orgDestTpCdComboValue} );
			      SetColProperty(0 ,"prc_grp_loc_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			      SetShowButtonImage(2);
			      resizeSheet(); 
		      }
			break;
			
			case "sheet2":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Location Detail Seq.|" +
			      "Location Code|Description|EFF Date|EXP Date|Source|Status|n1st_cmnc_amdt_seq";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetWaitImageVisible(0);
			      SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
			      SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
			      SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});	
			      SetShowButtonImage(2);
			      resizeSheet(); 
		      }
			break;
			
			case "sheet3":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Location Detail Seq.|" +
			      "Location Code|Description|EFF Date|EXP Date|Source|Status|n1st_cmnc_amdt_seq";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});		
			      SetWaitImageVisible(0);
	              SetShowButtonImage(2);
	              SetSheetHeight(300);
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
     * for all check of sheet1<br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @return void
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
      * for all check of sheet2<br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
      * @param {int} Row mandatory Onclick ,Cell's Row Index
      * @param {int} Col mandatory Onclick ,Cell's Column Index
      * @return void
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
    * @param {int} Row mandatory Onclick ,Cell's Row Index
    * @param {int} Col mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory Value
    * @return void
    * @author 
    * @version 2009.05.19
    */		
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol, flag)  {

		if(flag == undefined){
			doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
		}
		
	}
    
   /**
    * Calling Function in case of OnChange event <br>
    * Displaying Code from Server in case of code is not exist in combo <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row mandatory Onclick ,Cell's Row Index
    * @param {int} Col mandatory Onclick ,Cell's Column Index
    * @param {string} Value Mandatory Value
    * @return void
    * @author 
    * @version 2009.04.17
    */  
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form
		if (colname == "prc_grp_loc_cd") {
    		if (Value.length != 4){
    			sheetObj.SetCellValue(Row, "prc_grp_loc_cd","",0);
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				return false;
    		}
    		formObj.f_cmd.value=SEARCH03;
    		var sParam=FormQueryString(formObj);
    		sParam += "&prc_grp_loc_cd=" + sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
    		sParam += "&ibflag=U";
    		var sXml=sheetObj.GetSearchData("ESM_PRI_2003_02GS.do", sParam);
			var arrDesc=ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
			var rsltCnt=ComPriGetRowCountFromXML(sXml);
			if(rsltCnt > 0){
				var txt="";
				var desc="";				
				for(var i=0;i<arrDesc.length;i++){
					if(desc!=arrDesc[i][0]){
						txt += "\n["+arrDesc[i][0]+"] : \n   ";
					}
					txt += "-" + arrDesc[i][1]+" ";
					desc=arrDesc[i][0];
				}
				sheetObj.SetCellValue(Row, "prc_grp_loc_cd",sheetObj.CellSearchValue(Row, "prc_grp_loc_cd"),0);
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				ComShowCodeMessage("PRI08019", txt);	
				return false;
			}
			sheetObj.SelectCell(Row, Col+1);
    	}
	}
    /**
     * Calling Function in case of OnChange event <br>
     * Displaying Code from Server in case of code is not exist in combo <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @param {string} Value Mandatory Value
     * @return void
     * @author 
     * @version 2009.04.17
     */  	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var amdt_seq=formObj.amdt_seq.value;
		var sts=sheetObj.GetCellValue(Row, "src_info_cd");
		if (sName == "loc_cd") {
			if (Value.length == 5) {		
				formObj.f_cmd.value=COMMAND31;
				var sParam=FormQueryString(formObj);
				sParam += "&cd="+Value;
				sParam += "&etc1="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd");
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObjects[1].SetCellValue(Row, "loc_nm",arrDesc[0][1],0);
					if(sts=="PC"){
						sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
					}else if(sts=="GC"){
						sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
					}
				} else {
					ComShowCodeMessage("PRI01099", Value, sheetObjects[0].GetCellText(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd"));
					sheetObj.SetCellValue(Row, "loc_cd","",0);
					sheetObj.SetCellValue(Row, "loc_nm","",0);
					sheetObj.SelectCell(Row, "loc_cd");
					return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "loc_cd","",0);
				sheetObj.SetCellValue(Row, "loc_nm","",0);
				sheetObj.SelectCell(Row, "loc_cd");
				return false;
			}
		}		
	}
	var isFiredNested=false;
	var supressConfirm=false;
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
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				if (validateForm(sheetM,document.form,IBSAVE)) {
					if(sheetM.GetRowStatus(OldRow) == "U") {
						var rslt=false;
						if (ComShowCodeConfirm("PRI00006")) {
							supressConfirm=true;
							rslt=doActionIBSheet(sheetM,document.form,IBSAVE);
							supressConfirm=false;
						}
						if (rslt) {
							isFiredNested=true;
							sheetM.SelectCell(NewRow, NewCol, false);
							isFiredNested=false;
						} else {
							isFiredNested=true;
							sheetM.SelectCell(OldRow, OldCol, false);
							isFiredNested=false;
							return -1;
						}
					} else {
						isFiredNested=true;
						sheetM.SelectCell(NewRow, NewCol, false);
						isFiredNested=false;
					}
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
				formObj.grp_loc_seq.value=sheetM.GetCellValue(adjNewRow, "grp_loc_seq");
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
    * @version 2009.05.22
    */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
				case IBSEARCH: // retrieving
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
	  				ComOpenWait(true);
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2003_02GS.do", FormQueryString(formObj) );

					break;
					
				case IBSEARCHAPPEND: // Retrieving
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH02;
						sheetObj.DoSearch("ESM_PRI_2003_02GS.do", FormQueryString(formObj) );
					}
					break;
					
				case IBSEARCH_ASYNC01: // ORI/DEST Code VALIDATION 
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					formObj.f_cmd.value=MULTI07;
					var sParam=FormQueryString(formObj);					
			 		var sParamSheet=sheetObjects[1].GetSaveString(true);
					if (sParamSheet != "") {
						sParam=ComPriSetPrifix(sParamSheet, "sheet1_loc_check_") + "&" + sParam;
						sParam=sParam + "&sheet1_loc_check_org_dest_tp_cd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd");
				 		sParam=sParam + "&sheet1_loc_check_org_dest_tp_nm="+sheetObjects[0].GetCellText(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd");
					}
					var sXml=sheetObj.GetSaveData("ESM_PRI_2003_02GS.do", sParam);
					var sValue=ComGetEtcData(sXml, "ORI_DST_CHECK");
					if(sValue != ""){
						ComShowCodeMessage("PRI01099", sValue, sheetObjects[0].GetCellText(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd"));
						return false;
					} else {
						return true;
					}
					break;		
					
				case IBSEARCH_ASYNC02: // Retrieving - When Group code deleted, check whether used in rate 
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//common Source
						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr.length == 0){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
						}	
						chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						for(var i=0; i < chkArr.length; i++){
							if(sheetObj.GetRowStatus(chkArr[i]) == "I") {
								sheetObj.SetCellValue(chkArr[i], "chk","0",0);
							}	
						}
						chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr == "" || chkArr == null){
							return true;
						}
						var sParam="f_cmd="+SEARCH03+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml=sheetObj.GetSearchData("ESM_PRI_2003_02GS.do", sParam);
						var arrDesc=ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
						var rsltCnt=ComPriGetRowCountFromXML(sXml);
						var txt="";
						var desc="";
						if(rsltCnt <= 0){
							return true;
						}
						for(i=0;i<arrDesc.length;i++){
							if(desc!=arrDesc[i][0]){
								txt += "\n["+arrDesc[i][0]+"] : \n   ";
							}
							txt += "-" + arrDesc[i][1]+" ";
							desc=arrDesc[i][0];						
						}
						ComShowCodeMessage("PRI08019", txt);	
						return false;
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
							+"&grp_loc_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"grp_loc_seq");
							var sXml=sheetObj.GetSearchData("ESM_PRI_2003_02GS.do", sParam);
							var arrDesc=ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
							var rsltCnt=ComPriGetRowCountFromXML(sXml);
							var txt="";
							var desc="";
							if(rsltCnt <= 0){
								return false;
							}
							for(var i=0; i<arrDesc.length; i++){
								if(desc!=arrDesc[i][0]){
									txt += "\n["+arrDesc[i][0]+"] : \n   ";
								}
								txt += "-" + arrDesc[i][1]+" ";
								desc=arrDesc[i][0];
							}
							ComShowCodeMessage("PRI08019", txt);	
							return true;						
						}	
					}
					return false;
					break;		
					
				case IBSAVE: // Saving
					isFiredNested=false;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					// Check ORI/DEST
					if(!doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01)) {
						return false;
					}
					if (!supressConfirm && !ComPriConfirmSave()) {
						return false;
					}
	  				ComOpenWait(true);
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
					var sXml=sheetObj.GetSaveData("ESM_PRI_2003_02GS.do", sParam);
					isFiredNested=true;
					sheetObjects[0].LoadSaveData(sXml);
					sXml=ComDeleteMsg(sXml);
					sheetObjects[1].LoadSaveData(sXml);
					isFiredNested=false;
					if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
						return false;
					} else {
						if(isGrpDel){
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						}
					}

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
							sheetObjects[1].RemoveAll();
							sheetObj.SetCellValue(idx, "grp_loc_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1,0);
							sheetObj.SetCellValue(idx, "org_dest_tp_cd","",0);
							sheetObj.SelectCell(idx, "org_dest_tp_cd", false);
							formObj.grp_loc_seq.value=parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1;
							
							sheetObj.SetCellEditable(idx,"org_dest_tp_cd",1);
			 				sheetObj.SetCellEditable(idx,"prc_grp_loc_cd",1);
			 				sheetObj.SetCellEditable(idx,"prc_grp_loc_desc",1);	
			 				
						} else if (sheetObj.id == "sheet2") {
							if(sheetObjects[0].RowCount()==0){
								ComShowCodeMessage("PRI01004");
								return;							
							}
							var amdt_seq=formObj.amdt_seq.value;
							// Prevent row add between Amend Pair while insert Amend process							
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
							var grp_loc_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
							sheetObj.SetCellValue(idx, "grp_loc_seq",grp_loc_seq,0);
							sheetObj.SetCellValue(idx, "grp_loc_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1,0);
			    			sheetObj.SelectCell(idx, "loc_cd");
			    			
			    			sheetObj.SetCellEditable(idx,"loc_cd",1);		

						}
						if(amdt_seq != 0){
							sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
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
								if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
									sheetObjects[1].RemoveAll();
								}
					        	var delCnt=deleteRowCheck(sheetObj, "chk");
					        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
									sheetObjects[1].RemoveAll();
								}
							}
							deleteRowCheck(sheetObj, "chk");
						}
					} else{
						if (sheetObj.id == "sheet1") {
							isGrpDel=true;
							for(j=0;j < chkArr.length;j++){							
								sheetObj.SetCellFont("FontStrike", chkArr[j], 1, chkArr[j], sheetObj.LastCol(),1);
								sheetObj.SetCellFont("FontColor", chkArr[j], 1, chkArr[j], sheetObj.LastCol(),"#FF0000");
								if(sheetObj.GetCellValue(chkArr[j],"src_info_cd")!= "NW"){
									sheetObj.SetRowStatus(chkArr[j],"D");
									sheetObj.SetCellValue(chkArr[j],"chk","0",0);
								}							
							}
							var row=0;
							sheetObjects[1].CheckAll("chk","1",0);
							var chkArrDtl=ComPriSheetFilterRows(sheetObjects[1], "chk", "1");
						    for(i=0;i<chkArrDtl.length;i++){
						    	if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].GetRowStatus(chkArrDtl[i])!="I"){
	   								comSheetAmendCancelRow(sheetObjects[1],formObj,chkArrDtl[i],"A", "loc_cd");
						    	} else if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].GetRowStatus(chkArrDtl[i])=="I"){
									sheetObjects[1].SetRowStatus(chkArr[i],"D");
									sheetObjects[1].SetRowEditable(chkArr[i],0);
									sheetObjects[1].SetRowHidden(chkArr[i],1);
	  							}
						    }

							if(sheetObjects[1].RowCount()>0){
							    doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
							}
							if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
								sheetObjects[1].RemoveAll();
							}
				        	var delCnt=deleteRowCheck(sheetObj, "chk");
				        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
								sheetObjects[1].RemoveAll();
							}
						} else{
							for(i=0; i < chkArr.length; i++){
								if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq && (sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="NW"&&sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="GC"&&sheetObj.GetCellValue(chkArr[i],"src_info_cd")!="GM"))){
									ComShowCodeMessage("PRI01002");
									return;
								}
							}
							var sRow=0;
							for(j=0;j < chkArr.length;j++){
								if(sheetObj.GetCellValue(chkArr[j]+sRow,"n1st_cmnc_amdt_seq")!=amdt_seq){
									comSheetAmendRow(sheetObj,formObj,chkArr[j]+sRow,"D","loc_cd");		
									sRow++;								
								}
							}
							deleteRowCheck(sheetObj, "chk");	
						}
					}
					//checking in case of deleting all rows of DETAIL
					if (!isGrpDel && sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00021')){
			  				ComOpenWait(true);
			  				//Unckecking checked data on MASTER
							sheetObjects[0].CheckAll("chk",0,0);
							// Check whether it used in ARB, RATE. If it used, retrieve again.
							if(!doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02)){
								formObj.grp_loc_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
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
					break;
					
				case IBCOPYROW: // Guideline Copy
					formObj.f_cmd.value=MULTI06;
					var sParam=FormQueryString(formObj);
					if (!supressConfirm && !ComShowCodeConfirm("PRI03006")) {
						return false;
					}
	  				ComOpenWait(true);
	  				var sXml=sheetObj.GetSaveData("ESM_PRI_2003_02GS.do", sParam);
					formObj.f_cmd.value=SEARCH02;				
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					sheetObjects[1].LoadSaveData(sXml);
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
					var sXml=sheetObj.GetSaveData("ESM_PRI_2003_02GS.do", sParam);
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
					var sXml=sheetObj.GetSaveData("ESM_PRI_2003_02GS.do", sParam);
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
					comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_2003_02GS.do");
					break;
					
				case MODIFY04: // Accept Cancel
					if (!supressConfirm && !ComShowCodeConfirm('PRI00009')) {
						return false;
					}						
					formObj.f_cmd.value=MULTI05;
					comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_2003_02GS.do");
					break;	
					
				case COMMAND01: // Amend
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						} else{
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","loc_cd");						
						}
					} else{ 
						comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M","loc_cd");
					}
					sheetObj.SelectCell(sheetObj.GetSelectRow(), "loc_cd");
					break;	
					
				case COMMAND02: // Amend Cancel
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "loc_cd");						
						}
					} else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "loc_cd");
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
    * Calling function in case of OnPopupClick event<br>
    * Calling Location PopUp <br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {int} Row Mandatory OnPopupClick ,Cell's Row Index
    * @param {int} Col Mandatory OnPopupClick 'Cell's Column Index
    * @return void
    * @author 
    * @version 2009.05.07
    */ 	 	 
 	function sheet2_OnPopupClick(sheetObj, Row, Col)
 	{
 		var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		var sts=formObj.prop_sts_cd.value;
       	switch(colName)
       	{
   	    	case "loc_cd":
   	    		var sUrl="/opuscntr/ESM_PRI_4026.do?";
   	 			sUrl += "group_cmd=" + PRI_RP_SCP ;
   	 			sUrl += "&location_cmd=L";
   	 			sUrl += "&svc_scp_cd=" + formObj.svc_scp_cd.value;
   	 			sUrl += "&prop_no=" + formObj.prop_no.value;
   	 			sUrl += "&amdt_seq=" + formObj.amdt_seq.value;
   	 			sUrl += "&org_dest_cd="+ sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd");
   	 			ComOpenPopup(sUrl, 700, 310, "findCommodity", "1,0,1,1,1,1,1", true);
       	}
 	}   
 	
  	function findCommodity(rtnVal) {
  		var formObj = document.form;
  		var sheetObj=sheetObjects[1];
  		var sts=formObj.prop_sts_cd.value;
  		if (rtnVal != null){
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol() + 1,rtnVal.nm,0);
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
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			if ( sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
            	if ( ComShowCodeConfirm("PRI00010") ) {
            		return true;
            	}else {
            		return false;
            	}				
			}
			return true;
			break;
			
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
		case IBSEARCH_ASYNC01: // Retrieving
			break;
		case IBSEARCH_ASYNC02: // Retrieving
			break;		
		case IBSEARCH_ASYNC03: // Retrieving
			break;		
		case IBSAVE: // Saving
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage("PRI00301");
				return false;
			}
			if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd") == ""){
				ComShowCodeMessage("PRI01098");
				return false;
			}
			if (!isGrpDel&&sheetObjects[1].RowCount()<= 0) {
   				ComShowCodeMessage("PRI00319", "Location Group");
				return false;
			}		
			if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"
				&& getValidRowCount(sheetObjects[1]) <= 0) {
   				ComShowCodeMessage("PRI00319", "Location Group");
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
			var rowM=ComPriAmendDupCheck(sheetObjects[0], "prc_grp_loc_cd", formObj.amdt_seq.value);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}
			var rowD=ComPriAmendDupCheck(sheetObjects[1], "amdt_seq|grp_loc_seq|loc_cd", formObj.amdt_seq.value);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			break;
			
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			if (sheetObj.id == "sheet2") {				
				if (getValidRowCount(sheetObjects[0]) == 0) {
					ComShowCodeMessage("PRI01004");
					return false;					
				}
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd") == ""){
					ComShowCodeMessage("PRI01098");
					return false;
				}
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
    * Calling function in case of clicking tabl on parent screen <br>
    * It shows screen and process retrieve <br>
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
    * @return void
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
			formObject.req_usr_flg.value=sIsReqUsr;
			formObject.apro_usr_flg.value=sIsAproUsr ;	
//			formObject.dur_dup_flg.value = sDurDupFlg ;
			formObject.dur_dup_flg.value="Y" ;	
	        askOnce=true;

			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			doActionIBSheet(sheetObjects[1], document.form,IBSEARCH);
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
		buttonControl(null, "CLEAR");
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
	function sheet2_OnSearchEnd(sheetObj, Code, errMsg){
		var amdt_seq=document.form.amdt_seq.value;
		var pre_exp_dt=document.form.pre_exp_dt.value;
		var sts=document.form.prop_sts_cd.value;
		var rCnt=sheetObj.RowCount();
		if(sts=="I"){
			if(amdt_seq==0){
				sheetObj.SetColEditable("loc_cd", 1);
			}else{
				sheetObj.SetColEditable("loc_cd", 1);
			}
		}else{
			sheetObj.SetColEditable("loc_cd", 0);
		}
		for(i=1;i<=rCnt;i++){
			if(amdt_seq!=0){
				if(sheetObj.GetCellValue(i,"amdt_seq") != amdt_seq){
					sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(),1);
						sheetObj.SetRowEditable(i,0);
					}
				else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq){
					sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
					if(sts == "I"&&sheetObj.GetCellValue(i,"src_info_cd")!="AD"){
							sheetObj.SetCellEditable(i,"loc_cd",1);
					}
				}
			}
		}
		buttonControl(sheetObj,null);  //new add
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
	function sheet1_OnSearchEnd(sheetObj, Code, errMsg){
		var formObj=document.form;
		var rCnt=sheetObj.RowCount();
		var amdt_seq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		for(i=1;i<=rCnt;i++){
			if(amdt_seq!=0){
				if(sheetObj.GetCellValue(i,"src_info_cd")=="AD"){
					sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(),1);
				}
				if(sheetObj.GetCellValue(i,"src_info_cd")=="AM"||sheetObj.GetCellValue(i,"src_info_cd")=="AD"||sheetObj.GetCellValue(i,"src_info_cd")=="NW"){
					sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
				}
				if(sheetObj.GetCellValue(i,"src_info_cd")=="NW"){
					sheetObj.SetCellEditable(i,"prc_grp_loc_cd",1);
					sheetObj.SetCellEditable(i,"prc_grp_loc_desc",1);
				}				
			}
		}
		
		isGrpDel=false;
		isFiredNested=false;
		buttonControl(sheetObj, null);  //new add
	}	
	/**
	* Setting master's style
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     applyMasterStyle(sheetObj);
	* </pre>
	* @return void
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
			sheetObjects[0].GetCellFont("FontColor", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(), "#FF0000");//)(grp_sts ? "#FF00000000");
			sheetObjects[0].GetCellFont("FontStrike", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(), grp_flg); //(grp_flg);
		}

	}

   /**
    * calling function when occurring OnSaveEnd event <br>
    * Showing saving confirmation message <br>
    * <br><b>Example :</b>
    * <pre>
    * 
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {string} ErrMsg mandatory from server
    * @return void
    * @author 
    * @version 2009.06.22
    */ 		
  	function sheet2_OnSaveEnd(sheetObj, ErrMsg)  {
  		var formObj=document.form;
   	 	parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
	}

  
 	
 	/**
     * Controlling button's authority<br>
     * controlling buttons <br>
     * <br><b>Example :</b>
     * <pre>
     * buttonControl(sheetObj, mode)
     * </pre>
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {string} mode Mandatory,user mode or authority
     * @return void
     * @author 
     * @version 2015.08.04
     */		
 	function buttonControl(sheetObj, mode){
 		var formObj=document.form;
 		var req_usr_flg=formObj.req_usr_flg.value;
 		var apro_usr_flg=formObj.apro_usr_flg.value;
 		var amdt_seq=formObj.amdt_seq.value;
 		var sts=formObj.prop_sts_cd.value;
 		var row_cnt=sheetObjects[0].RowCount();
 		try{
 			
 			if(sheetObj == undefined || sheetObj == null) {
 				sheetObjects[0].SetEditable(0);
 	 			sheetObjects[1].SetEditable(0);
 			} else {
 				sheetObj.SetEditable(0);
 			}

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
 			
 			if(sheetObj != undefined && sheetObj != null) {
 				if (sheetObj.id == "sheet1") { 			 			
 	 				for (var i=1; i <= sheetObj.RowCount();i++){
 	 					sheetObj.SetCellEditable(i,"org_dest_tp_cd",1);
 	 					sheetObj.SetCellEditable(i,"prc_grp_loc_cd",0);
 	 					sheetObj.SetCellEditable(i,"prc_grp_loc_desc",0);				
 	 	 			}	
 	 			} else if (sheetObj.id == "sheet2"){
 	 				for (var i=1; i <= sheetObj.RowCount();i++){
 	 					sheetObj.SetCellEditable(i,"loc_cd",0);				
 	 	 			}
 	 			}
 			}

 			if( (sheetObj == undefined || sheetObj == null) && (mode != undefined && mode != null && mode == "CLEAR") ) {
 				return;
 			}
 			
 			switch(sts) {
 				case 'I':   // Initial
 					ComBtnEnable("btn_retrieve");
 					if(req_usr_flg=="true"||apro_usr_flg=="true"){
 						
 						if(sheetObj == undefined || sheetObj == null) {
 			 				sheetObjects[0].SetEditable(1);
 			 	 			sheetObjects[1].SetEditable(1);
 			 			} else {
 			 				sheetObj.SetEditable(1);
 			 			}
 						
 						if(sheetObj != undefined && sheetObj != null) {
	 						if(amdt_seq==0){
	 							if (sheetObj.id == "sheet1") { 			 			
	 				 				for (var i=1; i <= sheetObj.RowCount();i++){
	 				 					sheetObj.SetCellEditable(i,"org_dest_tp_cd",1);
	 				 					sheetObj.SetCellEditable(i,"prc_grp_loc_cd",1);
	 				 					sheetObj.SetCellEditable(i,"prc_grp_loc_desc",1);				
	 				 	 			}	
	 				 			} else if (sheetObj.id == "sheet2"){
	 				 				for (var i=1; i <= sheetObj.RowCount();i++){
	 				 					sheetObj.SetCellEditable(i,"loc_cd",1);				
	 				 	 			}
	 				 			}
	 						}else{
	
	 							if (sheetObj.id == "sheet1") { 			 			
	 				 				for (var i=1; i <= sheetObj.RowCount();i++){
	 				 					sheetObj.SetCellEditable(i,"org_dest_tp_cd",1);
	 				 					sheetObj.SetCellEditable(i,"prc_grp_loc_cd",1);
	 				 					sheetObj.SetCellEditable(i,"prc_grp_loc_desc",1);				
	 				 	 			}	
	 				 			} else if (sheetObj.id == "sheet2"){
	 				 				for (var i=1; i <= sheetObj.RowCount();i++){
	 				 					sheetObj.SetCellEditable(i,"loc_cd",1);				
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
 					if(apro_usr_flg=="true"){
 						
 						
 						if(sheetObj == undefined || sheetObj == null) {
 			 				sheetObjects[0].SetEditable(1);
 			 	 			sheetObjects[1].SetEditable(1);
 			 			} else {
 			 				sheetObj.SetEditable(1);
 			 			}
 						
 						ComBtnEnable("btn_acceptall");
 						ComBtnEnable("btn_cancelall");
 						ComBtnEnable("btn_accept");
 						ComBtnEnable("btn_acceptcancel");
 					}
 					break;
 				case 'R':   // Returned
 					ComBtnEnable("btn_retrieve");
 					if(req_usr_flg=="true"||apro_usr_flg=="true"){
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
 	
 	
  	
