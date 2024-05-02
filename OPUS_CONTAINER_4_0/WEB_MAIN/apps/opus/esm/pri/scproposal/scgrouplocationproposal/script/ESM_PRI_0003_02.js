/*=========================================================
* * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_02.js
*@FileTitle  :  S/C Location Group Creation
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
     * @extends 
     * @class ESM_PRI_0003_02 : Business Script for ESM_PRI_0003_02
     */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
    var askOnce=true;
    var isGrpDel = false;
    var isGrpAdd = false;
    var gCode = "";
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event Handler : Branching the process using Button Name.
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
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
					if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02) &&
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC05)){
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
					doActionIBSheet(sheetObjects[1],document.form,MODIFY03);
					applyMasterStyle(sheetObjects[1]);										
					break;	
				case "btn_acceptcancel":
					doActionIBSheet(sheetObjects[1],document.form,MODIFY04);
					applyMasterStyle(sheetObjects[1]);										
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
	 * registering IBSheet Object as list. Afterward, when other items should be process in batch, you could add process putting in array. the array defined at the top of this page
	 *  
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Initialize Sheet and default setting. Implement onload event handler of body tag. After loading page on browser, add the functions that should be pre-processed
	 *  
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
		doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
        buttonControl();		
        parent.loadTabPage();
	}
	/**
	 * setting sheet initial values and header <br>
	 * adding case as numbers of counting sheets <br>
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":
			    with(sheetObj){
				        
				      if (location.hostname != "")
				      var HeadTitle="|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Code|Description|prc_prog_sts_cd|src_info_cd|n1st_cmnc_amdt_seq";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"E", InputCaseSensitive:1},
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 } ];				       
				      InitColumns(cols);		
				      SetEditable(1);
				      SetShowButtonImage(2);
				      resizeSheet(); //SetSheetHeight(280);
		      }
				break;
			case "sheet2":
			    with(sheetObj){
				        
				      if (location.hostname != "")
				      var HeadTitle="|Sel.|Seq.|Proposal No.|Amend Seq.|Service Scope|Group Location Seq.|Group Location Detail Seq.|Location Code|Description|EFF Date|EFF SEQ|EXP Date|Source|Status";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      (headCount, 0, 0, true);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,  Align:"Center",  ColMerge:0,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:150, Align:"Left",    ColMerge:0,   SaveName:"loc_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Date",      Hidden:0,  Width:100, Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);	
				      
				      SetColProperty(0 ,"loc_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
				      
				      SetEditable(1);
				      SetShowButtonImage(2);
				      resizeSheet(); //SetSheetHeight(280);
		      }
				break;
		}
	}
	
	function resizeSheet() {
  	   	ComResizeSheet(sheetObjects[0]);
  		ComResizeSheet(sheetObjects[1]);
  	}
	
	function sheet1_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		var sts=document.form.prop_sts_cd.value;
		var val=sheetObj.GetCellValue(Row, Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 0, Row, Col);
		}
	}
    /**
     * Calling function when specified cell selected on Sheet. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) ;
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.17
     */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol, isDelete)  {
//		var tmp = sheetObjects[0].GetCellValue(NewRow,"prc_grp_loc_cd");
//		if(tmp != undefined && tmp != ""){
//			gCode = sheetObjects[0].GetCellValue(NewRow,"prc_grp_loc_cd");
//		}
    	doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);

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
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(NewRow, "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
         }
     }       
    /**
    * Calling function when data value changed event triggered on specified cell of sheet. <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet2_OnChange(sheetObj, Row, Col, Value);
    * </pre>
    * @return void
    * @author 
    * @version 2009.05.17
    */	
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		var amdt_seq=formObj.amdt_seq.value;
		var sts=sheetObj.GetCellValue(Row, "src_info_cd");
		if (sName == "loc_cd") {
			
			//2015.05.14
			//Check
			var sOriDesGbCd="B";
			var sSvcScpCd = formObj.svc_scp_cd.value;
			var sParam="f_cmd="+COMMAND31+"&svc_scp_cd="+sSvcScpCd+"&cd="+Value+"&etc1="+sOriDesGbCd;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");		  			
			if (arrData == undefined || arrData == null || arrData.length == 0) {
				ComShowCodeMessage("PRI01137");
				sheetObj.SetCellValue(Row,"loc_nm","",0);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col,true);
				return;	
			}	
			
			//Namming
			formObj.f_cmd.value=SEARCH05;
			var sParam=FormQueryString(formObj) + "&" + "cd=" + Value;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if(arrDesc==null){
				ComShowCodeMessage("PRI01137");
				sheetObj.SetCellValue(Row,"loc_nm","",0);
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col,true);
				return;				
			}
			sheetObj.SetCellValue(Row, "loc_nm",arrDesc[0][1],0);
			if(sts=="PC"){
				sheetObj.SetCellValue(Row, "src_info_cd","PM",0);
			}else if(sts=="GC"){
				sheetObj.SetCellValue(Row, "src_info_cd","GM",0);
			}
		}
	}
	var isFiredNested=false;
	var supressConfirm=false;
	var isSaveForRowadd=false;
	var isEventCnt = 0;
    /**
	    * Calling fucntion when row focus changed event triggered on specifed cell of Sheet. <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
	    * </pre>
	    * @return void
	    * @author 
	    * @version 2009.05.17
	    */		
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if(gCode != ""){
			isEventCnt++;
			if(isEventCnt == sheetM.RowCount()){
				var rowIdxAfterRow = getGroupCodeRowIndex(sheetObjects[0], gCode);
				adjNewRow = getGroupCodeRowIndex(sheetObjects[0], gCode);
				gCode = "";
			}
		}
		if (!isFiredNested && (OldRow != NewRow)) {
			if (sheetM.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				
				//Run at sheet event Except of RowHidden(when delete button event is fired)
				if(ComGetEvent("name")!="btn_delete1") {
					if (validateForm(sheetM,document.form,IBSAVE)) {
						isFiredNested=true;
						sheetM.SelectCell(NewRow, NewCol, false);
						isFiredNested=false;
					} else {
						isFiredNested=true;
						isSaveForRowadd = true;
						sheetM.SelectCell(OldRow, OldCol, false);
						isFiredNested=false;
						return -1;
					}
				} 
				
			}
			if (sheetD.IsDataModified()) {
				isFiredNested=true;
				sheetM.SelectCell(OldRow, OldCol, false);
				isFiredNested=false;
				var rslt=false;
				if (ComShowCodeConfirm("PRI00006")) {
					supressConfirm=true;
					isSaveForRowadd = true;
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
			if (appendRow && !isSaveForRowadd) {
				isFiredNested=true;
				var idx=sheetM.DataInsert();
				isFiredNested=false;
				return idx;
			} else {
				if(sheetM.GetRowStatus(adjNewRow) != "D") {
					formObj.grp_loc_seq.value=sheetM.GetCellValue(adjNewRow, "grp_loc_seq");
					doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
				}
				
			}
		}
	}

	// Execute process related to Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			if (window.event == null || ComGetEvent() == null /*|| ComGetEvent("suppressWait") != "Y"*/) {
				ComOpenWait(true);
			}			
			sheetObj.ShowDebugMsg(false);
			sheetObj.SetWaitImageVisible(0);

			switch (sAction) {
				case IBSEARCH: // retrieving
	//				if ((sheetObjects[0].IsDataModified||sheetObjects[1].IsDataModified)&&ComShowCodeConfirm("PRI00006")) {
	//					supressConfirm = true;
	//					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	//					supressConfirm = false;
	//				}
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_PRI_0003_02GS.do", FormQueryString(formObj), {Sync:2} );
					break;
					
				case IBSEARCHAPPEND: // Retrieving
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value=SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0003_02GS.do", FormQueryString(formObj) );
					}
					break;
				case IBSEARCH_ASYNC01: // Retrieving
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//common Source
						formObj.f_cmd.value=SEARCH19;
						var sParam=FormQueryString(formObj)+"&cd=CD02064";	
						sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
						setIBCombo(sheetObj,sXml,"src_info_cd", false, 0, "NW");
						// Common Status
						formObj.f_cmd.value=SEARCH19;
						sParam=FormQueryString(formObj)+"&cd=CD01719";	
						sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
						setIBCombo(sheetObj,sXml,"prc_prog_sts_cd", false, 0, "I");
						var arrData=ComPriXml2ComboString(sXml, "cd", "nm");	
					}
				break;				
				case IBSEARCH_ASYNC02: // Retrieving - When Group code deleted, check whether used in rate 
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//common Source
						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr.length == 0){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
						}						
						var sParam="f_cmd="+SEARCH03+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml=sheetObj.GetSearchData("ESM_PRI_0003_02GS.do", sParam);
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
				case IBSEARCH_ASYNC05: // Retrieve - When Group deleted, check detail Accepted
					if (validateForm(sheetObj,document.form,sAction)) {
				    	//common Source
						var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1");
						if(chkArr.length == 0){
							sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
						}						
						var sParam="f_cmd="+SEARCH04+"&" + sheetObj.GetSaveString(false, false, "chk");
						var sXml=sheetObj.GetSearchData("ESM_PRI_0003_02GS.do", sParam);
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
						ComShowCodeMessage("PRI01132", txt);	
						return false;
					}
					return true;
					break;						
				case IBSEARCH_ASYNC03: // Saving - Diable to delete group in use
					if (validateForm(sheetObj,document.form,sAction)) {
			   			var amdt_seq=formObj.amdt_seq.value;
			   			var eff_dt=formObj.eff_dt.value;
						var rowCnt=sheetObjects[1].RowCount()- ComPriSheetFilterRows(sheetObjects[1], "n1st_cmnc_amdt_seq", amdt_seq).length;
						var newCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
						var ndlCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
						var delCnt=ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;	
			   			if (rowCnt + newCnt - ndlCnt - delCnt == 0) {
							var sParam="f_cmd="+SEARCH03+"&ibflag=R"
							+"&prop_no="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"prop_no")
							+"&amdt_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")
							+"&svc_scp_cd="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"svc_scp_cd")
							+"&grp_loc_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"grp_loc_seq");
							var sXml=sheetObj.GetSearchData("ESM_PRI_0003_02GS.do", sParam);
							var arrDesc=ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
							var rsltCnt=ComPriGetRowCountFromXML(sXml);
							var txt="";
							var desc="";
							if(rsltCnt <= 0){
								return false;
							}
							for(i=0;i<arrDesc.length;i++){
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
//              case IBSEARCH_ASYNC06: // Save - When Group Deleting check whether accepted data exists in detail Accepted.
//					if (validateForm(sheetObj,document.form,sAction)) {
//			   			var amdt_seq = formObj.amdt_seq.value;
//			   			var eff_dt = formObj.eff_dt.value;
//		   	
//						var rowCnt = sheetObjects[1].RowCount - ComPriSheetFilterRows(sheetObjects[1], "n1st_cmnc_amdt_seq", amdt_seq).length;
//						var newCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
//						var ndlCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
//									 ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
//						var delCnt = ComPriSheetFilterRows(sheetObjects[1], "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;	
//						
//			   			if (rowCnt + newCnt - ndlCnt - delCnt == 0) {
//							var sParam = "f_cmd="+SEARCH04+"&ibflag=R"
//														+"&prop_no="+sheetObjects[0].CellValue(sheetObj.SelectRow,"prop_no")
//														+"&amdt_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"amdt_seq")
//														+"&svc_scp_cd="+sheetObjects[0].CellValue(sheetObj.SelectRow,"svc_scp_cd")
//														+"&grp_loc_seq="+sheetObjects[0].CellValue(sheetObj.SelectRow,"grp_loc_seq");
//												
//							var sXml = sheetObj.GetSearchXml("ESM_PRI_0003_02GS.do", sParam);
//							var arrDesc = ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
//							var rsltCnt = ComPriGetRowCountFromXML(sXml);
//							
//							var txt = "";
//							var desc = "";
//							
//							if(rsltCnt <= 0){
//								return false;
//							}
//							for(i=0;i<arrDesc.length;i++){
//								if(desc!=arrDesc[i][0]){
//									txt += "\n["+arrDesc[i][0]+"] : \n   ";
//								}
//								txt += "-" + arrDesc[i][1]+" ";
//								desc = arrDesc[i][0];
//							}
//	
//							ComShowCodeMessage("PRI01132", txt);	
//							return true;						
//							
//						}	
//					}
//					return false;
//					break;	
//					
				case IBSEARCH_ASYNC04: // When Group Code modified, Validation check ( If it's used, cannot modify )
					if (validateForm(sheetObj,document.form,sAction)) {
			   			var amdt_seq=formObj.amdt_seq.value;
			   			var eff_dt=formObj.eff_dt.value;
						var sParam="f_cmd="+SEARCH03+"&ibflag=R"
						+"&prop_no="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"prop_no")
						+"&amdt_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")
						+"&svc_scp_cd="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"svc_scp_cd")
						+"&grp_loc_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"grp_loc_seq");
						var sXml=sheetObj.GetSearchData("ESM_PRI_0003_02GS.do", sParam);
						var arrDesc=ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
						var rsltCnt=ComPriGetRowCountFromXML(sXml);
						var txt="";
						var desc="";
						if(rsltCnt <= 0){
							return "OK";
						}else{
							txt += "\n["+arrDesc[0][0]+"] : \n-" + arrDesc[0][1]+" ";
							ComShowCodeMessage("PRI08019", txt);							
							return arrDesc[0][1];
						}
					}
				case IBSEARCH_ASYNC07: // When Group Code modified, check whether accepted data is on detail
				if (validateForm(sheetObj,document.form,sAction)) {
		   			var amdt_seq=formObj.amdt_seq.value;
		   			var eff_dt=formObj.eff_dt.value;
					var sParam="f_cmd="+SEARCH04+"&ibflag=R"
					+"&prop_no="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"prop_no")
					+"&amdt_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"amdt_seq")
					+"&svc_scp_cd="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"svc_scp_cd")
					+"&grp_loc_seq="+sheetObjects[0].GetCellValue(sheetObj.GetSelectRow(),"grp_loc_seq");
					var sXml=sheetObj.GetSearchData("ESM_PRI_0003_02GS.do", sParam);
					var arrDesc=ComPriXml2Array(sXml, "prc_grp_loc_desc|prc_grp_loc_cd");
					var rsltCnt=ComPriGetRowCountFromXML(sXml);
					var txt="";
					var desc="";
					if(rsltCnt <= 0){
						return "OK";
					}else{
						txt += "\n["+arrDesc[0][0]+"] : \n-" + arrDesc[0][1]+" ";
						ComShowCodeMessage("PRI01132", txt);							
						return arrDesc[0][1];
					}
				}
				case IBSAVE: // Saving
					isFiredNested=false;
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					gCode = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"prc_grp_loc_cd");
//					comChangeValue(sheetObjects[1], "ibflag", "R", "amdt_seq", formObj.pre_amdt_seq.value);
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
					var sXml=sheetObj.GetSaveData("ESM_PRI_0003_02GS.do", sParam );
					isFiredNested=true;
					sheetObjects[0].LoadSaveData(sXml);
					sheetObjects[1].LoadSaveData(sXml);
					isFiredNested=false;
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
					if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
						return false;
					} else {
						ComPriSaveCompleted();
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					}
					isGrpAdd = false;
					return true;				
					break;
					
				case IBINSERT: // Row Add
					var prop_no = formObj.prop_no.value;
					var amdt_seq = formObj.amdt_seq.value; 
					var svc_scp_cd = formObj.svc_scp_cd.value;
					var eff_dt = formObj.eff_dt.value;
					var exp_dt = formObj.exp_dt.value;
					isGrpAdd = true;
					isSaveForRowadd = false;

					if (enableFlag && validateForm(sheetObj, document.form, sAction)) {
						if (sheetObj.id == "sheet1") {
							var idx = doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol, true);
							if (idx < 0) {
								return false;
							}
							sheetObj.SetCellValue(idx, "prop_no",prop_no,0);
							sheetObj.SetCellValue(idx, "amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "svc_scp_cd",svc_scp_cd,0);
							sheetObj.SetCellValue(idx, "grp_loc_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1,0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
							sheetObjects[1].RemoveAll();
							sheetObj.SelectCell(idx, "prc_grp_loc_cd");

						}else if (sheetObj.id == "sheet2") {
							if(sheetObjects[0].RowCount()==0||sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"ibflag")=="D"){
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
							sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",amdt_seq,0);
							sheetObj.SetCellValue(idx, "eff_dt",eff_dt,0);
							sheetObj.SetCellValue(idx, "exp_dt",exp_dt,0);
							sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I", 0);
							sheetObj.SetCellValue(idx, "src_info_cd","NW",0);
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), amdt_seq);
							var grp_loc_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
							sheetObj.SetCellValue(idx, "grp_loc_seq",grp_loc_seq,0);
							sheetObj.SetCellValue(idx, "grp_loc_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1,0);
			    			sheetObj.SelectCell(idx, "loc_cd");
						}
						if(amdt_seq != 0){
							sheetObj.SetCellFont("FontColor", idx, 1, idx, sheetObj.LastCol(),"#FF0000");
						}
					}
					break;
				case IBDELETE : // Delete
					var amdt_seq = formObj.amdt_seq.value;
					var chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					if (chkArr.length == 0) {
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk", "1", 0);
					}
					chkArr = ComPriSheetFilterRows(sheetObj, "chk", "1");
					if (amdt_seq == "0") {
						if (enableFlag && validateForm(sheetObj, document.form, sAction)) {
							if (sheetObj.id == "sheet1") {
								isGrpDel = true;
								sheetObjects[1].RemoveAll();
							} else {
								for(i=0; i<chkArr.length; i++) {
									if (sheetObj.GetCellValue(chkArr[i], "prc_prog_sts_cd") != "I") {
										ComShowCodeMessage("PRI01002");
										return;
									}
								}
							}
							deleteRowCheck(sheetObj, "chk");
							gCode = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"prc_grp_loc_cd");
							
							//after rowhidden, there is no operation to search detail, work only here
							if (sheetObj.id == "sheet1") {
								var tRowCnt = getValidRowCount(sheetObj);
								if(tRowCnt > 0) {
									var obj = getValidFirstGroupCode(sheetObj);
									if(obj != undefined && obj != null) {
										if(obj.ROW_IDX == sheetObj.HeaderRows()){
											sheetObj.SelectCell(-2, -2, false);
										}
										sheetObj.SelectCell(obj.ROW_IDX, 2, false);
										formObj.grp_loc_seq.value=obj.GRP_LOC_SEQ;
										doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
									}
									
								}
							}
						}
					}else{
						var eff_dt=formObj.eff_dt.value;
						var amdt_seq=formObj.amdt_seq.value;
						if (sheetObj.id == "sheet1") {
							isGrpDel=true;
							for(j=0;j < chkArr.length;j++){
								sheetObj.SetCellFont("FontStrike", chkArr[j], 1, chkArr[j], sheetObj.LastCol(), true);
								sheetObj.SetCellFont("FontColor", chkArr[j], 1, chkArr[j], sheetObj.LastCol(),"#FF0000");
								if(sheetObj.GetCellValue(chkArr[j],"src_info_cd")!="NW"&&sheetObj.GetCellValue(chkArr[j],"ibflag")!="I"){
									sheetObj.SetRowStatus(chkArr[j],"D");
									sheetObj.SetCellValue(chkArr[j],"chk","0");
									sheetObj.SetCellValue(chkArr[j],"n1st_cmnc_amdt_seq",amdt_seq);
								}
							}
							deleteRowCheck(sheetObj, "chk");
							gCode = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"prc_grp_loc_cd");
//no support[implemented common]CLT changeSelectBackColor(sheetObj, sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq"), amdt_seq);
							if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"ibflag")=="D"){
								var row=0;
								sheetObjects[1].CheckAll("chk","1",1);
								var chkArrDtl=ComPriSheetFilterRows(sheetObjects[1], "chk", "1");
							    for(i=0;i<chkArrDtl.length;i++){
							    	if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].GetCellValue(chkArrDtl[i],"ibflag")!="I"){
		   								comSheetAmendCancelRow(sheetObjects[1],formObj,chkArrDtl[i],"A", "loc_cd");
							    	}else if(sheetObjects[1].GetCellValue(chkArrDtl[i],"n1st_cmnc_amdt_seq")==amdt_seq&&sheetObjects[1].GetCellValue(chkArrDtl[i],"ibflag")=="I"){
										sheetObjects[1].SetRowStatus(chkArr[i],"D");
										sheetObjects[1].SetRowEditable(chkArr[i],0);
										sheetObjects[1].SetRowHidden(chkArr[i],1);
		  							}
							    }
							    sheetObjects[1].CheckAll("chk","1",1);
							    comChangeValue(sheetObjects[1], "chk", "0", "n1st_cmnc_amdt_seq|prc_prog_sts_cd", formObj.amdt_seq.value+"|"+"A");							    
								if(sheetObjects[1].RowCount()>0){
								    doActionIBSheet(sheetObjects[1],document.form,IBDELETE);							
								}								
							}
						}else{
							for(i=0;i < chkArr.length;i++){
								if(sheetObj.GetCellValue(chkArr[i],"amdt_seq")!=amdt_seq||(sheetObj.GetCellValue(chkArr[i],"n1st_cmnc_amdt_seq")==amdt_seq&&
										(sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AM" || sheetObj.GetCellValue(chkArr[i],"src_info_cd")=="AD" || sheetObj.GetCellValue(chkArr[i],"prc_prog_sts_cd")!="I"))){
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
							gCode = sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"prc_grp_loc_cd");
						}				
					}
					if(!isGrpDel && getValidRowCount(sheetObjects[1])==0 && ComShowCodeConfirm('PRI00021')){
						if(sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow())!="I"){
							sheetObjects[0].SetRowStatus(sheetObjects[0].GetSelectRow(),"D");
							//sheetObjects[0].SetRowHidden(sheetObjects[0].GetSelectRow(), true);
							//do not manage rowhidden, after delete all rows, do save operation
							if (ComShowCodeConfirm("PRI00006")) {
								supressConfirm=true;
								adjNewRow = sheetObjects[0].HeaderRows();
								var rslt=doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
								supressConfirm=false;
							}
						}
						isGrpDel=true;
					}	
					break;
				case IBCOPYROW: // Guideline Copy
					formObj.f_cmd.value=MULTI06;
					var sParam=FormQueryString(formObj);
					if (!supressConfirm && !ComShowCodeConfirm("PRI01006")) {
						return false;
					}
					var sXml=sheetObj.GetSaveData("ESM_PRI_0003_02GS.do", sParam);
					formObj.f_cmd.value=SEARCH02;
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		    		if (sheetObjects[0].RowCount()<= 0) {
		    			ComShowCodeMessage("PRI01016");
		    		} else {
		    			ComShowCodeMessage("PRI01017");
		    		}
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);					    		
					break;	
				case MODIFY01: // Accept All
					if (!supressConfirm && !ComShowCodeConfirm('PRI01015')) {
						return false;
					}	
					formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_PRI_0003_02GS.do", sParam);
					if(ComGetEtcData(sXml,"result")!="OK"){
						ComShowCodeMessage("PRI00329");
						return;
					}
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
					ComShowCodeMessage("PRI00108");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case MODIFY02: // Cancel All
					if (!supressConfirm && !ComShowCodeConfirm('PRI01010')) {
						return false;
					}			
					formObj.f_cmd.value=MULTI03;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_PRI_0003_02GS.do", sParam);
					if(ComGetEtcData(sXml,"result")!="OK"){
						ComShowCodeMessage("PRI00330");
						return;
					}
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
					ComShowCodeMessage("PRI00109");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;			
				case MODIFY03: // Accept
					if (!supressConfirm && !ComShowCodeConfirm('PRI00008')) {
						return false;
					}			
					formObj.f_cmd.value=MULTI04;
					var rtn=comSheetAcceptCheckedRows(sheetObj,formObj,"ESM_PRI_0003_02GS.do");
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);
					if(rtn){
						ComShowCodeMessage("PRI00108");
					}
					break;	
				case MODIFY04: // Accept Cancel
					if (!supressConfirm && !ComShowCodeConfirm('PRI00009')) {
						return false;
					}						
					formObj.f_cmd.value=MULTI05;
					var rtn=comSheetAcceptCancelCheckedRows(sheetObj,formObj,"ESM_PRI_0003_02GS.do");
					parent.comUpdateProposalStatusSummary("13",formObj.svc_scp_cd.value);				
					if(rtn){
						ComShowCodeMessage("PRI00109");
					}				
					break;			
				case COMMAND01: // Amend
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendRow(sheetObj,formObj,chkArr[0],"M","loc_cd");						
						}
					}else{ 
						comSheetAmendRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M","loc_cd");
					}
					break;		
				case COMMAND02: // Amend Cancel
					var chkArr=ComPriSheetFilterRows(sheetObj, "chk", "1")
					if(chkArr.length > 0){
						if(chkArr.length > 1){					
							ComShowCodeMessage("PRI00310");
						}else{
							comSheetAmendCancelRow(sheetObj,formObj,chkArr[0],"M", "loc_cd");						
						}
					}else{ 
						comSheetAmendCancelRow(sheetObj,formObj,sheetObj.GetSelectRow(),"M", "loc_cd");
					}
					break;		
			}
	    } catch (e) {
	        if (e == "[object Error]") {
	            ComShowMessage(OBJECT_ERROR);
	        } else {
	            ComShowMessage(e.message);
	        }
	    } finally {
	    	ComOpenWait(false);
	    	sheetObj.SetWaitImageVisible(1);
	    }
	}
	
	/** 
	 * get Row Index of Location Group Code
	 * @param (Object) IBSheet Object
	 * @param (String) prc_grp_loc_cd
	 * @return {int} 
	 */
	function getGroupCodeRowIndex(sheetObj, gCode){
		var resultIdx = sheetObj.HeaderRows();
		
		var sIdx = sheetObj.HeaderRows();
		var eIdx = sheetObj.LastRow();
		for(var i = sIdx; i <= eIdx; i++ ){
			var tmp = sheetObj.GetCellValue(i, "prc_grp_loc_cd");
			if(gCode == tmp){
				resultIdx = i;
				break;
			}
		}
		
		return resultIdx;
	}
	
 /**
    * Get First Group Location Code in rows except the deleted status of Rows
    * . <br>
    * @param object (IBSheet Object)
    * @return Object (Group Location Code, rowIdx)
    */
	function getValidFirstGroupCode(sheetObj) {
		var fstRowIdx = sheetObj.HeaderRows();
		var rowCnt = sheetObj.RowCount();
		var obj = null;
		for(var i = fstRowIdx; i <= rowCnt; i++){
			var rowSts = sheetObj.GetRowStatus(i);
			if(rowSts != "D"){
				obj = new Object;
				obj.GRP_LOC_CD = sheetObj.GetCellValue(i, "prc_grp_loc_cd");
				obj.GRP_LOC_SEQ = sheetObj.GetCellValue(i, "grp_loc_seq");
				obj.ROW_IDX = i;
				break;
			}
		}
		return obj;
	}
	
	
    /**
    * Calling function when popup event on designated cell of Sheet
    * . <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet2_OnPopupClick(sheetObj, Row, Col);
    * </pre>
    * @return void
    * @author 
    * @version 2009.05.17
    */	 	
	var popupRow = 0;
 	function sheet2_OnPopupClick(sheetObj, Row, Col) {
 		var colName=sheetObj.ColSaveName(Col);
 		var formObj=document.form;
 		popupRow=Row;
 		var sts=formObj.prop_sts_cd.value;
       	switch(colName) {
   	    	case "loc_cd":
   	    		var locationCmd="L";
 	  	  		var sUrl="ESM_PRI_4026.do?location_cmd=" + locationCmd;
 	  	  		ComOpenPopup(sUrl, 700, 310, "sheet2_returnVal", "1,0", true);
   	    		break;
       	}
 	} 
 	
 	function sheet2_returnVal(rtnVal) {
 		
 		var loc_cd=sheet2.GetCellValue(popupRow, "loc_cd");
   		var sts=sheet2.GetCellValue(popupRow, "src_info_cd");
   		
 		if (rtnVal != null && loc_cd != rtnVal.cd){
 			//2015.05.14 <Caution> don't change the order
 			//after loc_cd is binded with value, go to sheet_OnChange and check validation for value
 			//if you change this order, don't init for loc_nm
 			sheet2.SetCellValue(popupRow, "loc_nm", rtnVal.nm, 1);
 			sheet2.SetCellValue(popupRow, "loc_cd", rtnVal.cd, 1);
			
			if(sts=="PC"){
				sheet2.SetCellValue(popupRow, "src_info_cd","PM", 1);
			}else if(sts=="GC"){
				sheet2.SetCellValue(popupRow, "src_info_cd","GM", 1);
			}
		}
 	}
	/**
	 * Check the validation rules on value of objects in windows
	 */
	function validateForm(sheetObj, formObj, sAction) {
		var amdt_seq=formObj.amdt_seq.value;		 
		switch (sAction) {
		case IBSEARCH: // retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCH_ASYNC01: // Retrieving
			return true;
			break;
		case IBSEARCH_ASYNC02: // Retrieving
			return true;
			break;		
		case IBSEARCH_ASYNC03: // Retrieving
			return true;
			break;		
		case IBSEARCH_ASYNC04: // Retrieve
			return true;
			break;		
		case IBSEARCH_ASYNC05: // Retrieve
			return true;
			break;		
//      case IBSEARCH_ASYNC06: // Retrieve
//			return true;
//			break;		
		case IBSEARCH_ASYNC07: // Retrieve
			return true;
			break;				
		case IBSAVE: // Saving
			if (!sheetObjects[0].IsDataModified()&& !sheetObjects[1].IsDataModified()) {
				ComShowCodeMessage("PRI00301");
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
//			if(doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC06)){
//				return false;				
//			}			
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			var rowM=ComPriAmendDupCheck(sheetObjects[0], "prc_grp_loc_cd", amdt_seq);
//			var rowM = sheetObjects[0].ColValueDup("prc_grp_loc_cd",false);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}
			var rowD=ComPriAmendDupCheck(sheetObjects[1], "amdt_seq|grp_loc_seq|loc_cd", amdt_seq);
//			var rowD = sheetObjects[1].ColValueDup("amdt_seq|grp_loc_seq|loc_cd",false);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			return true;
			break;
		case IBINSERT: // Row Add
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBDELETE: // Delete
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		}
	}
	    /**
	    * When the page opens defines the initialize value, Receive variables from parent.
	    * . <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sPreAmdtSeq, sPropStsCd, sEffDt, sExpDt, sPreExpDt, sIsReqUsr, sIsAproUsr, sDurDupFlg);
	    * </pre>
	    * @return void
	    * @author 
	    * @version 2009.05.17
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
			formObject.lgcy_if_flg.value=sLgcyIfFlg ;
	        askOnce=true;
			buttonControl();
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
		}
	}
    /**
	    * Initialize variables and sheet in page
	    * . <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     tabClearSheet();
	    * </pre>
	    * @return void
	    * @author 
	    * @version 2009.05.17
	    */		
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
        askOnce=true;
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
	var enableFlag=true;
    /**
	    * Modifying property of sheet in page
	    * . <br>
	    * <br><b>Example :</b>
	    * <pre>
	    *     tabEnableSheet(flag);
	    * </pre>
	    * @return void
	    * @author 
	    * @version 2009.05.17
	    */		
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
	}
    /**
    * Execute this After sheet retrieve finished 
    * . <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet2_OnSearchEnd(sheetObj, errMsg);
    * </pre>
    * @return void
    * @author 
    * @version 2009.05.17
    */	
	function sheet2_OnSearchEnd(sheetObj, errMsg){
		var amdt_seq=document.form.amdt_seq.value;
		var eff_dt=document.form.eff_dt.value;
		var sts=document.form.prop_sts_cd.value;
		if(sts=="I"){
			if(amdt_seq==0){
				sheetObj.InitCellProperty(0, "loc_cd", { Type:"PopupEdit", UpdateEdit:1, InsertEdit:1,  EditLen:5});
			}else{
				sheetObj.InitCellProperty(0, "loc_cd", { Type:"PopupEdit", UpdateEdit:0, InsertEdit:1,  EditLen:5});				
			}
		}else{
			sheetObj.InitCellProperty(0, "loc_cd", { Type:"PopupEdit", UpdateEdit:0, InsertEdit:0,  EditLen:5});			
		}
		var amdt_seq=document.form.amdt_seq.value;
		var pre_exp_dt=document.form.pre_exp_dt.value;
		var lgcy_if_flg=document.form.lgcy_if_flg.value;
		
		if(amdt_seq != 0 && lgcy_if_flg != "Y"){
			for(i=1 ; i < sheetObj.RowCount()+1 ; i++) {
				if(sheetObj.GetCellValue(i,"amdt_seq") != amdt_seq){
					sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(), true);
					sheetObj.SetRowEditable(i,0);
				} else if(sheetObj.GetCellValue(i,"n1st_cmnc_amdt_seq") == amdt_seq) {
					sheetObj.SetCellFont("FontColor", i, 1, i, sheetObj.LastCol(),"#FF0000");
					if(sts == "I" && sheetObj.GetCellValue(i,"src_info_cd")!="AD" && sheetObj.GetCellValue(i,"prc_prog_sts_cd")=="I") {
						sheetObj.SetCellEditable(i,"loc_cd",1);
					}
				}
			}
		}
		buttonControl();
	}
    /**
    * Execute this After sheet retrieve finished 
    * . <br>
    * <br><b>Example :</b>
    * <pre>
    *     sheet1_OnSearchEnd(sheetObj, errMsg);
    * </pre>
    * @return void
    * @author 
    * @version 2009.05.17
    */		
	function sheet1_OnSearchEnd(sheetObj, errMsg){
		var rCnt=sheetObj.RowCount();
		var formObj=document.form;				
		var amdt_seq=formObj.amdt_seq.value;
		var lgcy_if_flg=formObj.lgcy_if_flg.value;		
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;		
		var sts=document.form.prop_sts_cd.value;
		if(sts == "I" && rCnt < 1 && (req_usr_flg=="true"||apro_usr_flg=="true")) {
			if(askOnce&&ComShowCodeConfirm('PRI01006')) {
		        askOnce=false;
				supressConfirm=true;
				doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
				supressConfirm=false;
			}
	        askOnce=false;
		}
		for(i=1;i<=rCnt;i++){
			if(amdt_seq!=0 && lgcy_if_flg != "Y"){
				if(sheetObj.GetCellValue(i,"src_info_cd")=="AD"){
					sheetObj.SetCellFont("FontStrike", i, 1, i, sheetObj.LastCol(), true);
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
		
		if(!ComIsNull(gCode)){
			var rowIdxAfterRow = getGroupCodeRowIndex(sheetObjects[0], gCode);
			if(rowIdxAfterRow != undefined){
				sheetObjects[0].SetSelectRow(rowIdxAfterRow, 1);
			}
		}

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
		var eff_dt=formObj.eff_dt.value;
		var amdCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length;
		var rowCnt=sheetObj.RowCount()- ComPriSheetFilterRows(sheetObj, "n1st_cmnc_amdt_seq", amdt_seq).length;
		var newCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq", amdt_seq+"|"+amdt_seq).length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AM").length;
		var ndlCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|ibflag", amdt_seq+"|"+amdt_seq+"|D").length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AD|D").length -
				 	 ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd|ibflag", amdt_seq+"|"+amdt_seq+"|AM|D").length;		
		var delCnt=ComPriSheetFilterRows(sheetObj, "amdt_seq|n1st_cmnc_amdt_seq|src_info_cd", amdt_seq+"|"+amdt_seq+"|AD").length;
		var grp_sts=amdCnt > 0 ? true : false;
		var grp_flg=rowCnt + newCnt - ndlCnt - delCnt == 0 ? true : false;
		if(delCnt.length==0) grp_flg=false;
		sheetObjects[0].GetCellFont("FontColor", sheetObjects[0].SetSelectRow, 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(),("#000000"));
		if(amdt_seq !=0 ){
			sheetObjects[0].GetCellFont("FontColor", sheetObjects[0].SetSelectRow, 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(),grp_sts, ("#FF00000000"));
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "n1st_cmnc_amdt_seq",grp_sts ? document.form.amdt_seq.value : document.form.pre_amdt_seq.value,1);
//no support[implemented common]CLT changeSelectBackColor(sheetObjects[0], sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "n1st_cmnc_amdt_seq"), document.form.amdt_seq.value);
			if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "src_info_cd")!="NW"){
				sheetObjects[0].SetCellFont("FontStrike", sheetObjects[0].GetSelectRow(), 1, sheetObjects[0].GetSelectRow(), sheetObjects[0].LastCol(), grp_flg);
			}
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "ibflag",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "ibflag")== "I" ? "I" : "R", 1);
		}
	}
	/**
	* Depend on Status, control button activate/deactivate
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     buttonControl();
	* </pre>
	* @return void
	* @author 
	* @version 2009.05.17
	*/				
	function buttonControl(){
		var formObj=document.form;
		var req_usr_flg=formObj.req_usr_flg.value;
		var apro_usr_flg=formObj.apro_usr_flg.value;
		var amdt_seq=formObj.amdt_seq.value;
		var sts=formObj.prop_sts_cd.value;
		var row_cnt=sheetObjects[0].RowCount();
		try{
			sheetObjects[0].SetEditable(0);
			sheetObjects[1].SetEditable(0);
			enableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_acceptall");
			disableButton("btn_cancelall");
			disableButton("btn_glinecopy");
			disableButton("btn_rowadd1");
			disableButton("btn_delete1");
			disableButton("btn_rowadd2");
			disableButton("btn_delete2");
			disableButton("btn_amend");
			disableButton("btn_amendcancel");
			disableButton("btn_accept");
			disableButton("btn_acceptcancel");
			showButton("btn_amendcancel");
			showButton("btn_amend");
			if(amdt_seq==0){
				hiddenButton("btn_amendcancel");
				hiddenButton("btn_amend");
			}
			sheetObjects[0].InitCellProperty(0, 7, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, false, 4, true);
			sheetObjects[0].InitCellProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, false, 200);
//			sheetObjects[1].InitCellProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, false, 5, true);							
			sheetObjects[1].InitCellProperty(0, "loc_cd", { Type:"PopupEdit", UpdateEdit:0, InsertEdit:0,  EditLen:5});
			switch(sts) {
				case 'I':   // Initial
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						sheetObjects[0].SetEditable(1);
						sheetObjects[1].SetEditable(1);
						if(amdt_seq==0){
							sheetObjects[0].InitCellProperty(0, 7, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, true, true, 4, true);
							sheetObjects[0].InitCellProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, true, true, 200);
//							sheetObjects[1].InitCellProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, true, true, 5, true);	
							sheetObjects[1].InitCellProperty(0, "loc_cd", { Type:"PopupEdit", UpdateEdit:1, InsertEdit:1,  EditLen:5});
						}else{
							sheetObjects[0].InitCellProperty(0, 7, dtData, 100, daCenter, false, "prc_grp_loc_cd", true, "", dfEngUpKey, 0, false, true, 4, true);
							sheetObjects[0].InitCellProperty(0, 8, dtData, 120, daLeft, false, "prc_grp_loc_desc", true, "", dfEngKey, 0, false, true, 200);							
//							sheetObjects[1].InitCellProperty(0, 8, dtPopupEdit, 120, daCenter, false, "loc_cd", true, "", dfEngUpKey, 0, false, true, 5, true);
							sheetObjects[1].InitCellProperty(0, "loc_cd", { Type:"PopupEdit", UpdateEdit:0, InsertEdit:1,  EditLen:5});
						}
						enableButton("btn_save");					
						enableButton("btn_rowadd1");
						enableButton("btn_delete1");
						enableButton("btn_rowadd2");
						enableButton("btn_delete2");
						enableButton("btn_amend");
						enableButton("btn_amendcancel");	
						if(row_cnt==0){
							enableButton("btn_glinecopy");
						}else{
							disableButton("btn_glinecopy");
						}						
					}
					break;
				case 'Q':   // Requested
					if(apro_usr_flg=="true"){
						enableButton("btn_acceptall");
						enableButton("btn_cancelall");
						enableButton("btn_accept");
						enableButton("btn_acceptcancel");
					}
					break;
				case 'R':   // Returned
					if(req_usr_flg=="true"||apro_usr_flg=="true"){
						enableButton("btn_accept");
						enableButton("btn_acceptcancel");
					}				
					break;
				case 'P':   // Approved
				case 'F':   // Filed
				case 'C':   // Cancled
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
	* It calls when value of cell on sheet is changed.
	* . <br>
	* <br><b>Example :</b>
	* <pre>
	*     sheet1_OnChange(sheetObj, Row, Col, Value) ;
	* </pre>
	* @return void
	* @author 
	* @version 2009.05.17
	*/		
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	var colname=sheetObj.ColSaveName(Col);
    	var formObj=document.form;
    	switch(colname)
    	{
	    	case "prc_grp_loc_cd":	    	
	    		var code=doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC04);
	    		var code2=doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC07);
	    		if(code!="OK" && code2!="OK"){
		    		sheetObj.SetCellValue(Row,"prc_grp_loc_cd",code,0);
	    			sheetObj.SelectCell(Row, Col);
	    			return;
	    		}	    		
	    		if (Value.length==4){
	    			sheetObj.SelectCell(Row, Col+1);
	    		}else{	   
	    			sheetObj.SetCellValue(Row,"prc_grp_loc_cd","",0);
  					sheetObj.SetCellValue(Row, "prc_grp_loc_desc","",0);
  					sheetObj.SelectCell(Row, "prc_grp_loc_cd")
	    		}
	    		break;
    	}
	}		
