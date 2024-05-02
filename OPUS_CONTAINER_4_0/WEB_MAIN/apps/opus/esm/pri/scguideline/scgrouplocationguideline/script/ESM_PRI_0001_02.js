/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_02.js
*@FileTitle  : Location Group Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var enableFlag=true;	
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	/**
	 * Event handler processing by button name  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
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
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
					break;
				case "btn_rowadd1":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
				case "btn_rowadd2":
					doActionIBSheet(sheetObjects[1],document.form,IBINSERT);
					break;
				case "btn_delete1":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;
				case "btn_delete2":
					doActionIBSheet(sheetObjects[1],document.form,IBDELETE);
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
	 * @param {ibsheet} sheet_obj mandatory IBSheet Object
	 * @return void
	 * @author 
	 * @version 2009.05.01
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
	 * @version 2009.05.01
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].SetWaitImageVisible(0);
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
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Code|Description";
	
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"E", InputCaseSensitive:1 },
							     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 } ];
	
					InitColumns(cols);
					SetEditable(1);
					SetShowButtonImage(2);
					 resizeSheet(); //SetSheetHeight(380);
				}
				break;
			case "sheet2":
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Code|Description|Subcontinent Code|Subcontinent";
	
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							     {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
							     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
					InitColumns(cols);
					SetColProperty(0 ,"loc_cd" 	, {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});					
					SetEditable(1);
					SetShowButtonImage(2);
					resizeSheet(); //SetSheetHeight(380);

				}
				break;
			case "sheet3":
				with(sheetObj){
					var HeadTitle="Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Group Code|Description|Location Code|Description|Subcontinent Code|Subcontinent";
	
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
							     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
							     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
							     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	
					InitColumns(cols);
					SetEditable(1);
					SetVisible(0);
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
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
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
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet2_OnBeforeCheck(sheetObj, Row, Col)  {
		var colName=sheetObj.ColSaveName(Col);
		if (colName == "chk") {
			ComPriCheckWithPnS(sheetObjects.slice(0, 2), 1, Row, Col);
		}
	}
	/**
	 * calling function in case of OnSelectCell event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}

	
	/**
	 * Calling Function in case of OnChange event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory Onclick 
	 * @param {int} text Mandatory 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		if (sName == "prc_grp_loc_cd") {
			sheetObj.SetCellValue(Row, "prc_grp_loc_cd", Value.toUpperCase());
			if (Value != sheetObj.CellSearchValue(Row, "prc_grp_loc_cd")) {
				formObj.f_cmd.value=SEARCH10;
				var sParam=FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
 				var sXml=sheetObj.GetSearchData("ESM_PRI_0001_02GS.do", sParam);
				var arrTemp=ComPriXml2Array(sXml, "etc1");
				if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
					var cntRateInUse=parseInt(arrTemp[0][0]);
					var cntArbInUse=parseInt(arrTemp[1][0]);
					if (cntRateInUse > 0) {
						sheetObj.SetCellValue(Row, "prc_grp_loc_cd",sheetObj.CellSearchValue(Row, "prc_grp_loc_cd"),0);
						ComShowCodeMessage("PRI01126", "Rate");
						return false;
					}
					if (cntArbInUse > 0) {
						sheetObj.SetCellValue(Row, "prc_grp_loc_cd",sheetObj.CellSearchValue(Row, "prc_grp_loc_cd"),0);
						ComShowCodeMessage("PRI01126", "[Arbitrary]");
						return false;
					}
				}
			}
			if (Value.length != 4) {
				sheetObj.SetCellValue(Row, "prc_grp_loc_cd","",0);
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				return false;
			}
		}
	}
	/**
	 * Calling Function in case of OnChange event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory Onclick 
	 * @param {int} text Mandatory 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet2_OnChange(sheetObj, Row, Col, Value) {
		
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		if (sName == "loc_cd") {
			sheetObj.SetCellValue(Row, "loc_cd", Value.toUpperCase());
			if (Value.length == 5) {		
				formObj.f_cmd.value=SEARCH05;
				var sParam=FormQueryString(formObj) + "&" + "cd=" + Value.toUpperCase();
 				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObjects[1].SetCellValue(Row, "loc_nm",arrDesc[0][1],0);
					sheetObjects[1].SetCellValue(Row, "sconti_cd",arrDesc[0][2],0);
					sheetObjects[1].SetCellValue(Row, "sconti_nm",arrDesc[0][3],0);
				} else {
					sheetObj.SetCellValue(Row, "loc_cd","",0);
					sheetObj.SetCellValue(Row, "loc_nm","",0);
					sheetObj.SetCellValue(Row, "sconti_cd","",0);
					sheetObj.SetCellValue(Row, "sconti_nm","",0);
					sheetObj.SelectCell(Row, "loc_cd", false);
					//ComShowCodeMessage("PRI00315");
					return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "loc_cd","",0);
				sheetObj.SetCellValue(Row, "loc_nm","",0);
				sheetObj.SetCellValue(Row, "sconti_cd","",0);
				sheetObj.SetCellValue(Row, "sconti_nm","",0);
				sheetObj.SelectCell(Row, "loc_cd", false);
				//ComShowCodeMessage("PRI00318");
				return false;
			}
		}
	}
	/**
	 * Calling function in case of OnPopupClick event<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} Row mandatory Onclick ,Cell's Row Index
	 * @param {int} Col mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	var popupRow = 0;
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		popupRow = Row;
		var formObj=document.form;
		if (colName == "loc_cd") {
			var sUrl="ESM_PRI_4026.do?group_cmd=" + PRI_SG + "&location_cmd=L&svc_scp_cd=" + formObj.svc_scp_cd.value + "&gline_seq=" + formObj.gline_seq.value;
			ComOpenPopup(sUrl, 700, 310, "setLocation", "1,0", true);
		}
	}
	
	function setLocation(rtnVal) {
		if (rtnVal != null){
			var sheetObj=sheetObjects[1];
			sheetObj.SetCellValue(popupRow, "loc_cd", rtnVal.cd, 0);
			sheetObj.SetCellValue(popupRow, "loc_nm", rtnVal.nm, 0);
			sheetObj.SetCellValue(popupRow, "sconti_cd", rtnVal.sconti_cd, 0);
			sheetObj.SetCellValue(popupRow, "sconti_nm", rtnVal.sconti_nm, 0);
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
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
 			sheetObj.Down2Excel({ HiddenColumn: 1,Merge: 1, KeyFieldMark:0});
		}
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
				var idx=sheetM.DataInsert(-1);
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
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
        	if (window.event == null || ComGetEvent() == undefined || ComGetEvent() == null) {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
				case IBSEARCH: // retrieving
					
					if (validateForm(sheetObj,document.form,sAction)) {
												
						for (var i=0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}						
						formObj.f_cmd.value=SEARCH01;						
						var sXml=sheetObj.GetSaveData("ESM_PRI_0001_02GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(sXml);
											
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case IBSEARCHAPPEND: // Retrieving
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value=SEARCH02;
 						//sheetObj.DoSearch("ESM_PRI_0001_02GS.do", FormQueryString(formObj) );
 						var sXml=sheetObj.GetSaveData("ESM_PRI_0001_02GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(sXml);
					}
					break;
				case IBSAVE: // Saving
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
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
 					var sXml=sheetObj.GetSaveData("ESM_PRI_0001_02GS.do", sParam);
 					sheetObjects[1].LoadSaveData(sXml);
 					sheetObjects[0].LoadSaveData(sXml);
					if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
						return false;
					} else {
						if (getValidRowCount(sheetObjects[1]) <= 0) {
							doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol(), false);
						}
						parent.setTabStyle();
						ComPriSaveCompleted();
						return true;
					}
					break;
				case IBDOWNEXCEL:
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value=SEARCH03;
 						sheetObj.DoSearch("ESM_PRI_0001_02GS.do", FormQueryString(formObj) );
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case IBINSERT: // Row Add
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (sheetObj.id == "sheet1") {
						var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol(), true);
						if (idx < 0) {
							return false;
						}
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
						sheetObjects[1].RemoveAll();
						sheetObj.SetCellValue(idx, "grp_loc_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1);
						sheetObj.SelectCell(idx, "prc_grp_loc_cd", false);
					}
					if (sheetObj.id == "sheet2") {
						var idx=sheetObj.DataInsert(-1);
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
						var grp_loc_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
						sheetObj.SetCellValue(idx, "grp_loc_seq",grp_loc_seq);
						sheetObj.SetCellValue(idx, "grp_loc_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1);
						sheetObj.SelectCell(idx, "loc_cd", false);
					}
					break;
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
		        	}
					if (sheetObj.id == "sheet1") {
						var arrChecked=sheetObj.FindCheckedRow("chk").split("|");
						for (var i=0; i < arrChecked.length; i++) {
							if (arrChecked[i] == null || arrChecked[i] == "" || arrChecked == undefined) {
								continue;
							}
							formObj.f_cmd.value=SEARCH10;
							var sParam=FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObj.GetCellValue(arrChecked[i], "prc_grp_loc_cd");
 							var sXml=sheetObj.GetSearchData("ESM_PRI_0001_02GS.do", sParam);
							var arrTemp=ComPriXml2Array(sXml, "etc1");
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntRateInUse=parseInt(arrTemp[0][0]);
								var cntArbInUse=parseInt(arrTemp[1][0]);
								if (cntRateInUse > 0) {
									ComShowCodeMessage("PRI01126", "Rate");
									return false;
								}
								if (cntArbInUse > 0) {
									ComShowCodeMessage("PRI01126", "Arbitrary");
									return false;
								}
							} else {
								return false;
							}
						}
					}
					if (sheetObj.id == "sheet1" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "chk") == "1") {
						sheetObjects[1].RemoveAll();
					}
		        	var delCnt=deleteRowCheck(sheetObj, "chk");
		        	if (delCnt > 0 && sheetObj.id == "sheet1" && sheetObj.GetRowStatus(sheetObj.GetSelectRow()) == "D") {
						sheetObjects[1].RemoveAll();
					}
					//checking in case of deleting all rows of DETAIL
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) <= 0) {
						if (ComShowCodeConfirm("PRI00021")){
			  				//Unckecking checked data on MASTER
							sheetObjects[0].CheckAll("chk",0,1);
							// Check whether it used in ARB, RATE. If it used, retrieve again.
							formObj.f_cmd.value=SEARCH10;
							var sParam=FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "prc_grp_loc_cd");
 							var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0001_02GS.do", sParam);
							var arrTemp=ComPriXml2Array(sXml, "etc1");
							if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
								var cntRateInUse=parseInt(arrTemp[0][0]);
								var cntArbInUse=parseInt(arrTemp[1][0]);
								if (cntRateInUse > 0) {
									ComShowCodeMessage("PRI01126", "Rate");
									formObj.grp_loc_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
									doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
									return false;
								} else if (cntArbInUse > 0) {
									ComShowCodeMessage("PRI01126", "Arbitrary");
									formObj.grp_loc_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
									doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
									return false;
								} else {
									sheetObjects[1].RemoveAll();
									sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "chk","1");
									deleteRowCheck(sheetObjects[0], "chk");
								}
							}
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
        } finally {
        	ComOpenWait(false);
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
	 * @version 2009.05.01
	 */
	function validateForm(sheetObj, formObj, sAction) {
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
			if (sheetObjects[0].IsDataModified()&& sheetObjects[0].GetSaveString() == "") {
				return false;
			}
			if (sheetObjects[1].IsDataModified()&& sheetObjects[1].GetSaveString() == "") {
				return false;
			}
			var rowM=sheetObjects[0].ColValueDup("svc_scp_cd|gline_seq|prc_grp_loc_cd", false);
			if (rowM >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet1", rowM);
				return false;
			}
			var rowD=sheetObjects[1].ColValueDup("svc_scp_cd|gline_seq|grp_loc_seq|loc_cd", false);
			if (rowD >= 0) {
				ComShowCodeMessage("PRI00303", "Sheet2", rowD);
				return false;
			}
			return true;
			break;
		case IBDOWNEXCEL: //
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		case IBINSERT: // Row Add
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
			if (sheetObj.id == "sheet2") {
				if (sheetObjects[0].RowCount()<= 0 || sheetObjects[0].GetSelectRow()<= 0) {
					return false;
				}
			}
			return true;
			break;
		case IBDELETE: // Delete
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		}
	}
	/**
	 * Controlling all buttons as enable/Disable<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode Mandatory,user mode or authority
	 * @author 
	 * @version 2009.05.01
	 */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_downexcel");
			disableButton("btn_rowadd1");
			disableButton("btn_rowadd2");
			disableButton("btn_delete1");
			disableButton("btn_delete2");
			sheetObjects[0].SetEditable(0);
			sheetObjects[1].SetEditable(0);
			break;
		case "INIT":
			enableButton("btn_retrieve");
			enableButton("btn_save");
			enableButton("btn_downexcel");
			enableButton("btn_rowadd1");
			enableButton("btn_rowadd2");
			enableButton("btn_delete1");
			enableButton("btn_delete2");
			sheetObjects[0].SetEditable(1);
			sheetObjects[1].SetEditable(1);
			break;
		case "READONLY":
			enableButton("btn_retrieve");
			disableButton("btn_save");
			enableButton("btn_downexcel");
			disableButton("btn_rowadd1");
			disableButton("btn_rowadd2");
			disableButton("btn_delete1");
			disableButton("btn_delete2");
			sheetObjects[0].SetEditable(0);
			sheetObjects[1].SetEditable(0);
			break;
		}
	}
	/**
	 * Setting default and retrieving. Calling function from parent when loading a screen on tab<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
           			
			if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag=true;
            } else {
            	enableFlag=false;
            }
			
			if (enableFlag && isAproUsr) {
				toggleButtons("INIT");
			} else {
				toggleButtons("READONLY");
			}
			
		}
	}
	/**
	 * Initializing all data of a screen, calling from parent frame<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		formObject.grp_loc_seq.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
	}
	
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		sheetObjects[1].SetEditable(flag);
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}
