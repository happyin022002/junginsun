/*========================================================= 
* * 1.0 Creation
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2001_01.js
*@FileTitle  : Guideline Creation - Location Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
 =========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class Guideline Creation :business script for Guideline Creation 
	 *
	 */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
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
				case "btn_loadexcel":
					doActionIBSheet(sheetObjects[0],document.form,IBLOADEXCEL);
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
    * @version 2009.05.22
    */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1": // Location Group 1st sheet
			    with(sheetObj){
				      var HeadTitle="|Sel.aa|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Ori/Dst|Group\nCode|Description";
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4, AcceptKeys:"E", InputCaseSensitive:1  },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetWaitImageVisible(0);
				      SetColProperty("org_dest_tp_cd", {ComboText:orgDestTpCdComboText, ComboCode:orgDestTpCdComboValue} );
				      SetShowButtonImage(2);
				      resizeSheet(); //SetSheetHeight(380);
		      }
				break;
			case "sheet2": // Location Group 2nd sheet
			    with(sheetObj){
				      var HeadTitle="|Sel.bb|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Location\nCode|Description|Subcontinent Code|Subcontinent";
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
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
				      SetWaitImageVisible(0);
				      SetShowButtonImage(2);
				      resizeSheet(); //SetSheetHeight(380);
		      }
				break;
			case "sheet3":
			    with(sheetObj){
					      var HeadTitle="Seq.cc|Ori/Dst|Group Code|Description|Location Code|Description|Subcontinent Code|Subcontinent";
					      var headCount=ComCountHeadTitle(HeadTitle);
					      (headCount, 0, 0, true);
			
					      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			
					      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					      var headers = [ { Text:HeadTitle, Align:"Center"} ];
					      InitHeaders(headers, info);
			
					      var cols = [ {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
					             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"org_dest_tp_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					       
					      InitColumns(cols);
			
					      SetEditable(1);
					      //SetVisible(false);
					      SetWaitImageVisible(0);
					      SetSheetHeight(270);
		      }
				break;
			case "sheet4":  // To Process Message
			    with(sheetObj){
				      var HeadTitle="|Sel.dd|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Location\nCode|Description|Subcontinent Code|Subcontinent";
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
		
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
		
				      SetEditable(1);
				      SetShowButtonImage(2);
				      SetSheetHeight(321);
		      }
				break;
		}
	}
	
	function resizeSheet() {
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
			//sheet2.RemoveAll();
		}		
		
	}
   /**
    * Calling Function in case of OnChange event <br>
    * showing Description<br>
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
		var formObj=document.form;
		var sName=sheetObj.ColSaveName(Col);
		if (sName == "prc_grp_loc_cd") {
			if (Value.length != 4) {
				sheetObj.SetCellValue(Row, "prc_grp_loc_cd","",0);
				sheetObj.SelectCell(Row, "prc_grp_loc_cd", false);
				return false;
			}
			// When Group Code modifying, it is not available to edit if it used in "Rate" or "Arbitrary"
			formObj.f_cmd.value=SEARCH10;
			var sParam=FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObj.CellSearchValue(Row, "prc_grp_loc_cd");
			var sXml=sheetObj.GetSearchData("ESM_PRI_2001_01GS.do", sParam);
			var arrTemp=ComPriXml2Array(sXml, "etc1");
			if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
				var cntRateInUse=parseInt(arrTemp[0][0]);
				var cntArbInUse=parseInt(arrTemp[1][0]);
				if (cntRateInUse > 0) {
					sheetObj.SetCellValue(Row, "prc_grp_loc_cd",sheetObj.CellSearchValue(Row, "prc_grp_loc_cd"),0);
					ComShowCodeMessage("PRI01022", "[Rate]");
					return false;
				}
				if (cntArbInUse > 0) {
					sheetObj.SetCellValue(Row, "prc_grp_loc_cd",sheetObj.CellSearchValue(Row, "prc_grp_loc_cd"),0);
					ComShowCodeMessage("PRI01022", "[Arbitrary]");
					return false;
				}
			}			
		}		
	}
   /**
    * Calling Function in case of OnChange event <br>
    * showing Description<br>
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
		if (sName == "loc_cd") {
			if (Value.length == 5) {		
				formObj.f_cmd.value=COMMAND31;
				formObj.cd.value=Value;
				var sParam=FormQueryString(formObj);
				sParam += "&etc1="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd");
				var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
				var arrDesc=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
				if (arrDesc != null && arrDesc.length > 0) {
					sheetObjects[1].SetCellValue(Row, "loc_nm",arrDesc[0][1],0);
					sheetObjects[1].SetCellValue(Row, "sconti_cd",arrDesc[0][2],0);
					sheetObjects[1].SetCellValue(Row, "sconti_nm",arrDesc[0][3],0);
				} else {
					ComShowCodeMessage("PRI01099", Value, sheetObjects[0].GetCellText(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd"));
					sheetObj.SetCellValue(Row, "loc_cd","",0);
					sheetObj.SetCellValue(Row, "loc_nm","",0);
					sheetObj.SetCellValue(Row, "sconti_cd","",0);
					sheetObj.SetCellValue(Row, "sconti_nm","",0);
					sheetObj.SelectCell(Row, "loc_cd", false);
					return false;
				}
			} else {
				sheetObj.SetCellValue(Row, "loc_cd","",0);
				sheetObj.SetCellValue(Row, "loc_nm","",0);
				sheetObj.SetCellValue(Row, "sconti_cd","",0);
				sheetObj.SetCellValue(Row, "sconti_nm","",0);
				sheetObj.SelectCell(Row, "loc_cd", false);
				return false;
			}
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
	function sheet2_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "loc_cd") {
			var sUrl="/opuscntr/ESM_PRI_4026.do?";
			sUrl += "group_cmd=" + PRI_SG ;
			sUrl += "&location_cmd=L";
			sUrl += "&svc_scp_cd=" + formObj.svc_scp_cd.value;
			sUrl += "&gline_seq=" + formObj.gline_seq.value;
			sUrl += "&org_dest_cd="+ sheetObjects[0].GetCellValue(Row, "org_dest_tp_cd");
			ComOpenPopup(sUrl, 700, 310, "findLocationCd", "1,0", true);
		}
	}
	
	function findLocationCd(rtnVal){
		var formObj = document.form;
		var sheetObj=sheetObjects[1];
		
		if (rtnVal != null){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol() + 1,rtnVal.nm,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sconti_nm",rtnVal.sconti_nm,0);
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),rtnVal.cd,0);// Execute ONCHANGE
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
					// When master data modified, first of all, save it. (For ori/dst)
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
					if (validateForm(sheetObj,document.form,sAction)) {						
		  				ComOpenWait(true);
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						formObj.f_cmd.value=SEARCH01;
						sheetObj.DoSearch("ESM_PRI_2001_01GS.do", FormQueryString(formObj), {Sync:2});
					}
					break;
				case IBSEARCHAPPEND: // Retrieving
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH02;
						sheetObj.DoSearch("ESM_PRI_2001_01GS.do", FormQueryString(formObj), {Sync:2});
					}
					break;
				case IBSAVE: // Saving
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
					var sParamSheet2=sheetObjects[1].GetSaveString(true);
					if (sParamSheet2 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}
					var sXml=sheetObj.GetSaveData("ESM_PRI_2001_01GS.do", sParam);
					sheetObjects[1].LoadSaveData(sXml, true);
					sXml=ComDeleteMsg(sXml);
					sheetObjects[0].LoadSaveData(sXml, true);
					if (sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()) {
						return false;
					} else {
						if (getValidRowCount(sheetObjects[1]) <= 0) {
							doRowChange(sheetObjects[0], sheetObjects[1], -1, sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol(), sheetObjects[0].GetSelectCol, false);
						}
						parent.setTabStyle();
						return true;
					}					
					break;
				case IBSEARCH_ASYNC01: // ORI/DEST Code VALIDATION 
					if (!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					formObj.f_cmd.value=MULTI02;
					var sParam=FormQueryString(formObj);					
			 		var sParamSheet=sheetObjects[1].GetSaveString(true);
					if (sParamSheet != "") {
						sParam=ComPriSetPrifix(sParamSheet, "sheet1_loc_check_") + "&" + sParam;
						sParam=sParam + "&sheet1_loc_check_org_dest_tp_cd="+sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd");
				 		sParam=sParam + "&sheet1_loc_check_org_dest_tp_nm="+sheetObjects[0].GetCellText(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd");
					}
					var sXml=sheetObj.GetSaveData("ESM_PRI_2001_01GS.do", sParam);
					var sValue=ComGetEtcData(sXml, "ORI_DST_CHECK");
					if(sValue != ""){
						ComShowCodeMessage("PRI01099", sValue, sheetObjects[0].GetCellText(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd"));
						return false;
					} else {
						return true;
					}
					break;		
				case IBLOADEXCEL:      //upload excel
		        	if(!validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					var svcScpCd=formObj.svc_scp_cd.value;
					var glineSeq=formObj.gline_seq.value;
					var sParam="svc_scp_cd="+svcScpCd+"&gline_seq="+glineSeq;		
					ComOpenPopup("ESM_PRI_2052.do?"+sParam, 950, 485, "findLocationCd", "1,0", false);
					break;
				case IBDOWNEXCEL:
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH03;
						//var opt = {Sync : 0, Append : 1 };
						sheetObj.DoSearch("ESM_PRI_2001_01GS.do", FormQueryString(formObj) );
						//sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), KeyFieldMark:0 });
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case IBINSERT: // Row Add
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (sheetObj.id == "sheet1") {
						var idx=doRowChange(sheetObj, sheetObjects[1], -2, sheetObj.GetSelectRow(), sheetObj.GetSelectCol(), sheetObj.GetSelectCol, true);
						if (idx < 0) {
							return false;
						}
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value,0);
						sheetObjects[1].RemoveAll();
						sheetObj.SetCellValue(idx, "grp_loc_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_seq")) + 1,0);
						sheetObj.SetCellValue(idx, "org_dest_tp_cd","",0);
						sheetObj.SelectCell(idx, "org_dest_tp_cd", false);
					}
					if (sheetObj.id == "sheet2") {
						var idx=sheetObj.DataInsert();
						sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value,0);
						sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value,0);
						var grp_loc_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
						sheetObj.SetCellValue(idx, "grp_loc_seq",grp_loc_seq,0);
						sheetObj.SetCellValue(idx, "grp_loc_dtl_seq",parseInt(ComPriGetMax(sheetObj, "grp_loc_dtl_seq")) + 1,0);
						sheetObj.SelectCell(idx, "loc_cd", false);
					}
					break;
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1",0);
		        	}
					if (sheetObj.id == "sheet1") {
						if(!checkUseDataExist(sheetObj, formObj)) {
							return false;
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
					if (sheetObj.id == "sheet2" && getValidRowCount(sheetObj) < 1 ) {
						if(ComShowCodeConfirm('PRI00021')){
			  				ComOpenWait(true);
			  				//Unckecking checked data on MASTER
							sheetObjects[0].CheckAll("chk",0,1);
							// Check whether it used in ARB, RATE. If it used, retrieve again.
							if(!checkUseDataExist(sheetObjects[0], formObj)) {
								formObj.grp_loc_seq.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "grp_loc_seq");
								doActionIBSheet(sheetObjects[1],document.form,IBSEARCHAPPEND);
								return false;
							} else {								
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
    * When you try to delete Group Code that used in Rate or Arbitrary. Return False. <br>
    * <br><b>Example :</b>
    * <pre>
    *     checkUseDataExist(sheetObj, formObj);
    * </pre>
    * @param {ibsheet} sheetObj mandatory IBSheet Object
    * @param {form} formObj mandatory html form object
    * @return boolean
    * @author 
    * @version 2010.02.16
    */
	function checkUseDataExist(sheetObj, formObj) {
		if (sheetObjects[0].CheckedRows("chk") <= 0) {
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "chk","1",0);
    	}
		var arrChecked=sheetObj.FindCheckedRow("chk").split("|");
		for (var i=0; i < arrChecked.length; i++) {
			if (arrChecked[i] == null || arrChecked[i] == "" || arrChecked == undefined) {
				continue;
			}
			formObj.f_cmd.value=SEARCH10;
			var sParam=FormQueryString(formObj) + "&prc_grp_loc_cd=" + sheetObj.GetCellValue(arrChecked[i], "prc_grp_loc_cd");
			var sXml=sheetObj.GetSearchData("ESM_PRI_2001_01GS.do", sParam);
			var arrTemp=ComPriXml2Array(sXml, "etc1");
			if (arrTemp != null && arrTemp[0] != null && arrTemp[0][0] != null) {
				var cntRateInUse=parseInt(arrTemp[0][0]);
				var cntArbInUse=parseInt(arrTemp[1][0]);
				if (cntRateInUse > 0) {
					ComShowCodeMessage("PRI01022", "[Rate]");
					return false;
				}
				if (cntArbInUse > 0) {
					ComShowCodeMessage("PRI01022", "[Arbitrary]");
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
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
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				ComShowCodeMessage('PRI08001');
				return false;
			}
			if(sheetObjects[0].IsDataModified()|| sheetObjects[1].IsDataModified()){
				if ( ComShowCodeConfirm("PRI00010") ) {
            		return true;
				}            	
	            return false;       
            }
			break;
		case IBSEARCH_ASYNC01:
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
			break;
		case IBSEARCHAPPEND: // Retrieving
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
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
			if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "org_dest_tp_cd") == ""){
				ComShowCodeMessage("PRI01098");
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
			break;
		case IBLOADEXCEL: // Excel Load
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
			break;
		case IBDOWNEXCEL: //
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
			break;
		case IBINSERT: // Row Add
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
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
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			}
			if (getValidRowCount(sheetObj) == 0) {
				return false;					
			}
			break;
		}
		return true;
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
			ComBtnDisable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_downexcel");
			ComBtnDisable("btn_loadexcel");
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_delete2");
			break;
		case "INIT":
			ComBtnEnable("btn_retrieve");
			ComBtnEnable("btn_save");
			ComBtnEnable("btn_downexcel");
			ComBtnEnable("btn_loadexcel");
			ComBtnEnable("btn_rowadd1");
			ComBtnEnable("btn_rowadd2");
			ComBtnEnable("btn_delete1");
			ComBtnEnable("btn_delete2");
			break;
		case "READONLY":
			ComBtnEnable("btn_retrieve");
			ComBtnDisable("btn_save");
			ComBtnEnable("btn_downexcel");
			ComBtnDisable("btn_loadexcel");
			ComBtnDisable("btn_rowadd1");
			ComBtnDisable("btn_rowadd2");
			ComBtnDisable("btn_delete1");
			ComBtnDisable("btn_delete2");
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
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;
			doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
			if(enableFlag && (isAproUsr == "true" || isAproUsr)) {
				toggleButtons("INIT");
			} else {
				enableFlag=false;
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
    * @version 2009.05.20
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
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}
	
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,KeyFieldMark:0 });
	}    


	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
	     sheetObj.ReNumberSeq();    
	}
	
	function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
	     sheetObj.ReNumberSeq();    
	}