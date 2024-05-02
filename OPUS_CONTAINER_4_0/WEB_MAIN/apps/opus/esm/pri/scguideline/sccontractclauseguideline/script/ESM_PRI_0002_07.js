/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_0002_07.js
 *@FileTitle : SC Guideline Contract Clause Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.01 
 * 1.0 Creation
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
	 * @class ESM_PRI_0002_07 : Business Script for ESM_PRI_0002_07
	 */
	function ESM_PRI_0002_07() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
	}
	
	 
	
	// common global variables
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var enableFlg = true;
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	
	function processButtonClick(){
	}
	 
	
	/**
	 * registering IBSheet Object as list <br>
	 * adding process for list in case of needing batch processing with other items<br>
	 * defining list on the top of source <br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * setSheetObject(sheetObj);
	 * </pre>
	 * 
	 * @param {ibsheet} sheet_obj mandatory IBSheet Object
	 * @return void
	 * @author 
	 * @version 2009.10.28
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	
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
	
		for (i = 0; i < sheetObjects.length; i++) {
	
			//Modify Environment Setting Function's name
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
	  function initSheet(sheetObj,sheetNo) {
          var cnt=0;
  		var sheetID=sheetObj.id;
          switch(sheetID) {
          case "sheet1":
              with(sheetObj){
            
           var HeadTitle="|Sel.|Del Check.|Seq.|Item|svc_scp_cd|gline_seq|ctrt_cluz_seq";
           var headCount=ComCountHeadTitle(HeadTitle);
           SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

           var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
           var headers = [ { Text:HeadTitle, Align:"Center"} ];
           InitHeaders(headers, info);

           var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
               {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
               {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
               {Type:"Seq",       Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"Seq",   Sort:0 },
               {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            
           InitColumns(cols);
           resizeSheet(); //SetSheetHeight(450);
           SetEditable(1);
           SetWaitImageVisible(0);
           SetColHidden("del_chk",1);
           SetColProperty("note_clss_cd", {ComboText:noteClssCdComboText, ComboCode:noteClssCdComboValue} );
           }


              break;
          case "sheet2":
              with(sheetObj){
             
            var HeadTitle="|Sel.|Del Check.|Seq.|Surcharge|Clause|svc_scp_cd|gline_seq|note_clss_cd|ctrt_cluz_dtl_seq";
            var headCount=ComCountHeadTitle(HeadTitle);
            (headCount, 0, 0, true);

            SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                   {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Seq",       Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:"Seq",   Sort:0 },
                   {Type:"Combo", Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"chg_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_ctnt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ctrt_cluz_dtl_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);
            resizeSheet(); //SetSheetHeight(450);
            SetEditable(1);
            SetWaitImageVisible(0);
            SetColHidden("del_chk",1);
            //SetAutoRowHeight(0);
            SetColProperty("chg_cd", {ComboText:chgCdComboText, ComboCode:chgCdComboValue} );
            }


              break;
          }
      }
	  
	  function resizeSheet() {
		  ComResizeSheet(sheetObjects[0]);
		  ComResizeSheet(sheetObjects[1]);
	  }
	  
	  
	  function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		     sheetObj.ReNumberSeq();    
		}
	  
	  function sheet2_OnSort(sheetObj, Col, SortArrow  ) {
		     sheetObj.ReNumberSeq();    
		}
	/**
	 * Calling function in case of Onclick event <br>
	 * Highlighting selected row<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
	 * @param {int} OldRow Mandatory Onclick ,Cell's Row Index
	 * @param {int} OldCol Mandatory Onclick ,Cell's Column Index
	 * @param {int} NewRow Mandatory Onclick ,Cell's Row Index
	 * @param {int} NewCol Mandatory Onclick ,Cell's Column Index
	 * @return void
	 * @author 
	 * @version 2009.05.19
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
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
		var formObj = document.form;
		var adjNewRow = NewRow;
	
		if (OldRow != NewRow) {
	
			formObj.f_cmd.value = SEARCH02;
			//formObj.ctrt_cluz_seq.value = sheetM.CellValue(adjNewRow, "ctrt_cluz_seq");
			formObj.ctrt_cluz_seq.value = sheetM.GetCellValue(adjNewRow, "ctrt_cluz_seq");
			if (formObj.ctrt_cluz_seq.value == "undefined" || ComIsEmpty(formObj.ctrt_cluz_seq.value)) {
				//formObj.ctrt_cluz_seq.value = sheetM.CellValue(sheetM.SelectRow, "ctrt_cluz_seq");
				formObj.ctrt_cluz_seq.value = sheetM.GetCellValue(sheetM.SelectRow, "ctrt_cluz_seq");
			}
			sheetD.DoSearch("ESM_PRI_0002_07GS.do", FormQueryString(formObj));
		}
	}
	
	/**
	 * When item is selected, Modify it to surcharge combobox <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *	setSurchargeCombo();
	 * </pre>
	 * @return void
	 * @author 
	 * @version 2009.05.19
	 */
	function setSurchargeCombo() {
		////////////// When Item selected, change it to surcharge ComboBox////////////////////////////
		var formObj = document.form;
		//var note_clss_cd = sheetObjects[0]. (sheetObjects[0].SelectRow, "note_clss_cd");
		var note_clss_cd = sheetObjects[0].GetCellValue(sheetObjects[0].SelectRow, "note_clss_cd");
	
		// When SURCHARGE is selected on master, show surcharge column
		if (note_clss_cd == "S") {
			//sheetObjects[1].ColHidden("chg_cd") = false;
			sheetObjects[1].SetColHidden("chg_cd",0);
	
		} else {
			//sheetObjects[1].ColHidden("chg_cd") = true;
			sheetObjects[1].SetColHidden("chg_cd",1);
		}
		//////////////////////////////////////////////////////////////////////////		
	
	}
	
	/**
	 * Calling Function in case of OnSearchEnd event <br>
	 *  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {string} errMsg Mandatory Message
	 * @return void
	 * @author 
	 * @version 2009.05.19
	 */
	function sheet2_OnSearchEnd(ErrMsg) {
		setSurchargeCombo();
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
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
			case IBSEARCH: 	
				if (validateForm(sheetObj, document.form, sAction)) {
					if (sheetObj.id == "sheet1") {
		  				ComOpenWait(true);
						for ( var i = 0; i < sheetObjects.length; i++) {
							sheetObjects[i].RemoveAll();
						}		
						formObj.f_cmd.value = SEARCH01;						
						var sXml=sheetObjects[0].GetSearchData("ESM_PRI_0002_07GS.do" , FormQueryString(formObj));	
						sheetObjects[0].LoadSaveData(sXml,{Sync:0} );						
						ComOpenWait(false);
					}
				}
				break;
			}
		}catch(e){
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}finally {
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
	 * @version 2009.04.17
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieving
	
			if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
				ComShowCodeMessage('PRI08001');
				return false;
			}
			return true;
			break;
		}
	
		return true;
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
		var colname = sheetObj.ColSaveName(Col);
	
		switch (colname) {
		case "ctrt_cluz_ctnt":
			ComShowMemoPad(sheetObj, Row, Col, true, 678, 200);
			break;
		}
	
	}
	
	/**
	 * controlling buttons <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {string} mode Mandatory mode Setting Value 
	 * @return void
	 * @author 
	 * @version 2009.06.03
	 */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_Retrieve");
			break;
		case "INIT":
			enableButton("btn_Retrieve");
			break;
		case "READONLY":
			enableButton("btn_Retrieve");
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
	 * @param {string} sConChk Mandatory Conversion check 
	 * @return void
	 * @author 
	 * @version 2009.05.21
	 */
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject = document.form;
	
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
	
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
			if (enableFlag && isAproUsr) {
				toggleButtons("INIT");
			} else {
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
		var formObject = document.form;
	
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
	
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	
		toggleButtons("CLEAR");
	}
	
	var enableFlag = true;
	/**
	 * Calling function from main<br>
	 * Prohibiting from adding,modifying,deleting in case of Confirmation=YES<br>
	 * <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * tabEnableSheet(flag)
	 * </pre>
	 * 
	 * @param {boolean} flag Mandatory from Main screen
	 * @return void
	 * @author 
	 * @version 2009.04.17
	 */
	function tabEnableSheet(flag) {
		var formObject = document.form;
	
		enableFlag = flag;
	
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}

 