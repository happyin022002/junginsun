/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   UI_PRI_0002_01.js
*@FileTitle  : Location Group Guideline Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class Guideline Creation : business script for Guideline Creation 
	 */
	function ESM_PRI_0002_01() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	// Event handler processing by button click event*/
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name <br>
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
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			
			switch (srcName) {
				case "btn_downexcel":
					if(sheetObjects[1].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
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
     * registering IBSheet Object as list</b>
     * adding process for list in case of needing batch processing with other items </b>
     * defining list on the top of source</b>
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
     * initializing sheet</b>
     * implementing onLoad event handler in body tag</b>
     * adding first-served functions after loading screen.</b>
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
		toggleButtons("CLEAR");
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

				with (sheetObj) {
				var HeadTitle="|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Code|Description";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						     {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
						     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",   Sort:0 },
						     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4, AcceptKeys:"E", InputCaseSensitive:1 },
						     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:200 } ];

				InitColumns(cols);

				SetEditable(0);
				SetShowButtonImage(2);
				resizeSheet(); //SetSheetHeight(410);
				}
				break;
			case "sheet2":

				with (sheetObj) {
				var HeadTitle="|Sel.|Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Code|Description|Subcontinent Code|Subcontinent";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						     {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
						     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",	Sort:0 },
						     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text", Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5,   EditLen:4, AcceptKeys:"E", InputCaseSensitive:1 },
						     {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				InitColumns(cols);

				SetEditable(0);
				SetShowButtonImage(2);
				resizeSheet(); //SetSheetHeight(410);
				}
				break;
			case "sheet3":

				with (sheetObj) {
				var HeadTitle="Seq.|Service Scope|Gline Seq.|Group Location Seq.|Group Location Detail Seq.|Group Code|Description|Location Code|Description|Subcontinent Code|Subcontinent";
				
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Seq",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
						     {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:1,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:120,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:140,   Align:"Left",    ColMerge:0,   SaveName:"grp_loc_dtl_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
						     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
						     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"sconti_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				InitColumns(cols);
				SetEditable(1);
				SetVisible(0);

				}
				break;
		}
	}
	
	 function resizeSheet() {
	   	ComResizeSheet(sheetObjects[0]);
		ComResizeSheet(sheetObjects[1]);
	  }
	 
	
	function sheet1_OnSort(sheetObj ,Col, SortArrow){
		  sheet1.ReNumberSeq();   
		 }
	
	function sheet2_OnSort(sheetObj ,Col, SortArrow){
		  sheet2.ReNumberSeq();   
		 }
    /**
    * calling function in case of OnClick event <br>
    * Highlighting selected row<br>
    * <br><b>Example :</b>
    * <pre>
    *
    * </pre>
    * @param {ibsheet} sheetObj Mandatory HTML tag(Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @return N/A
    * @author 
    * @version 2009.05.19
    */	
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}	
   /**
    * calling function in case of clicking row<br>
    * Retrieving child-sheet by selected row<br>
    * <br><b>Example :</b>
    * <pre>
    *	doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow);
    * </pre>
    * @param {ibsheet} sheetM Mandatory HTML tag(Object) Object
    * @param {ibsheet} sheetD Mandatory HTMLtag (Object) Object
    * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
    * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
    * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
    * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
    * @param {string} appendRow Mandatory SHEET Row addable
    * @return N/A
    * @author 
    * @version 2009.05.19
    */
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (OldRow != NewRow) {
			formObj.grp_loc_seq.value=sheetM.GetCellValue(adjNewRow, "grp_loc_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}
	}
    /**
    * Handling sheet process <br>
    * <br><b>Example :</b>
    * <pre>
    *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
    * </pre>
    * @param {ibsheet} sheetObj Mandatory IBSheet Object
    * @param {form} formObj Mandatory html form object
    * @param {int} sAction Mandatory ,process constant variable
    * @return N/A
    * @author 
    * @version 2009.05.22
    */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
				case IBSEARCH: // 
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						for (var i=0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}
						formObj.f_cmd.value=SEARCH01;
						sheetObj.DoSearch("ESM_PRI_0002_01GS.do", FormQueryString(formObj) );
						ComOpenWait(false);
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case IBSEARCHAPPEND: // 
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH02;
						sheetObj.DoSearch("ESM_PRI_0002_01GS.do", FormQueryString(formObj) );
						ComOpenWait(false);
					}
					break;
				case IBDOWNEXCEL:
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH03;
						var sXml=sheetObj.GetSearchData("ESM_PRI_0002_01GS.do", FormQueryString(formObj) );
						if(sXml.length>0){
							sheetObj.LoadSearchData(sXml,{Sync:1} );
							sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:-1 });
						}
						ComOpenWait(false);
					} else {
						ComShowCodeMessage('PRI08001');
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
     *  handling process for input validation <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *     }
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {form} formObj Mandatory html form object
     * @param {int} sAction Mandatory Process flag contact
     * @returns bool <br>
     *          true  : valid<br>
     *          false : invalid
     * @author 
     * @version 2009.04.17
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCHAPPEND: // 
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		case IBDOWNEXCEL: //
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				return false;
			} else {
				return true;
			}
			break;		
		}
	}
     /**
      * Function to control button<br>
      * <br><b>Example :</b>
      * <pre>
      *     toggleButtons(mode)
      * </pre>
      * @param {string} mode 
      * @return N/A
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
			enableButton("btn_downexcel");
			break;
		}
	}
	 /**
     * calling function in case of clicking tab of parent screen<br>
     * <br><b>Example :</b>
     * <pre>
     * tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sPropNo Mandatory prop_no 
     * @param {string} sAmdtSeq Mandatory amdt_seq 
     * @param {string} sSvcScpCd Mandatory svc_scp_cd 
     * @param {string} sConChk Mandatory Conversion check 
     * @return N/A
     * @author 
     * @version 2009.05.21
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
    * calling function in case of clearing tab's control<br>
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
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		formObject.grp_loc_seq.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		toggleButtons("CLEAR");
	}
	var enableFlag=true;
	/**
     * Calling funciton from main<br>
     * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
     * <br><b>Example :</b>
     * <pre>
     * tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag Mandatory from Main screen
     * @return N/A
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