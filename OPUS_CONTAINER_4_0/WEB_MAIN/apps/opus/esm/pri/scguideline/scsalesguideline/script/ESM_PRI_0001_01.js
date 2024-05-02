/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : esm_pri_0001_01.js
*@FileTitle  : Sales Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	/**
	 * Event handler processing by button name  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return N/A
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
				case "btn_rowadd":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
				case "btn_rowcopy":
					doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
					break;
				case "btn_delete":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
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
	 * @param {ibsheet} sheet_obj mandatory IBSheet Object
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
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
		axon_event.addListener ('click', 'ref_ctnt_click', 'ref_ctnt');
		axon_event.addListener ('blur', 'ref_ctnt_blur', 'ref_ctnt');
		toggleButtons("CLEAR");
		parent.loadTabPage();
	}
	
	/**
	 * Handling Onbeforedeactivate  event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     obj_deactivate()
	 * </pre>
	 * @param N/A
	 * @return N/A
	 * @author 
	 * @version 2009.04.17
	 */
	
	function ref_ctnt_click() {
		$("#ref_ctnt").focus();
	}
	
	function ref_ctnt_blur() {
		var ref_ctnt_val = document.form.ref_ctnt.value;
		var row = sheetObjects[0].GetSelectRow();
		sheetObjects[0].SetCellValue(row, "ref_ctnt", ref_ctnt_val);
	}
	
	/**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,1);
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} sheetNo mandatory IBSheet Object Serial No
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|Service Scope|Gline Seq.|Ref Seq.|Title|Content";
	
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    	Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							     {Type:"DummyCheck", 	Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							     {Type:"Seq",       	Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							     {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",  KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",   KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ref_seq",     KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      	Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ref_tit_nm",  KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
							     {Type:"Text",      	Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ref_ctnt",    KeyField:1,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 } ];
	
					InitColumns(cols);
	
					SetEditable(1);
					resizeSheet(); //SetSheetHeight(237);
				}
				break;
		}
	}
	
	function resizeSheet() {
		ComResizeSheet(sheetObjects[0], 140);
	}

	
	/**
	 * calling function in case of OnSaveEnd event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {string} ErrMsg mandatory from server
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
		if (ErrMsg == "") {
			parent.setTabStyle();
			ComPriSaveCompleted();
			
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if (OldRow != NewRow) {
			formObj.ref_ctnt.value=sheetObj.GetCellValue(NewRow, "ref_ctnt");
		}
	}
	/**
	 * Handling sheet process <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {form} formObj mandatory html form object
	 * @param {int} sAction mandatory,Constant Variable
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
        	 sheetObj.ShowDebugMsg(false);       	
			switch (sAction) {
				case IBSEARCH:										
					if (validateForm(sheetObj,document.form,sAction)) {
						formObj.f_cmd.value=SEARCH01;						
 						var sXml=sheetObj.GetSaveData("ESM_PRI_0001_01GS.do", FormQueryString(formObj)); 						
						sheetObj.LoadSaveData(sXml);
 						
					} else {
						ComShowCodeMessage('PRI08001');
					}
					break;
				case IBSAVE:
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					if (!ComPriConfirmSave()) {
						return false;
					}
					formObj.f_cmd.value=MULTI01;
					sheetObj.DoSave("ESM_PRI_0001_01GS.do", FormQueryString(formObj), -1, false);
					break;
				case IBINSERT: // Row Add
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					var idx=sheetObj.DataInsert();
					sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
					sheetObj.SetCellValue(idx, "gline_seq",formObj.gline_seq.value);
					sheetObj.SetCellValue(idx, "ref_seq",parseInt(ComPriGetMax(sheetObj, "ref_seq")) + 1);
					sheetObj.SelectCell(idx, "ref_tit_nm", false);
					break;
				case IBCOPYROW: // Row Copy
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
					var idx=sheetObj.DataCopy();
					sheetObj.SetCellValue(idx, "ref_seq",parseInt(ComPriGetMax(sheetObj, "ref_seq")) + 1);
					break;
				case IBDELETE: // Delete
					if (!enableFlag || !validateForm(sheetObj,document.form,sAction)) {
						return false;
					}
		        	if (sheetObj.CheckedRows("chk") <= 0) {
		        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
		        	}
		        	
		        	document.form.ref_ctnt.value="";
					deleteRowCheck(sheetObj, "chk");
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
	 *  handling process for input validation <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     if (validateForm(sheetObj,document.form,IBSAVE)) {
	 *        handling logic
	 *     }
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {form} formObj mandatory html form object
	 * @param {int} sAction mandatory ,Process contant variable
	 * @returns bool <br>
	 *          true  : Valid<br>
	 *          false : inValid
	 * @author 
	 * @version 2009.05.01
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
			case IBSAVE: // 
				var returnVal=true;
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					returnVal=false;
				}
				
				for(var i=1; i<=sheetObj.RowCount(); i++) {
					var ref_ctntVal = sheetObj.GetCellValue(i,"ref_ctnt");
					if(ComIsNull(ref_ctntVal)) {
						ComShowMessage("[Content] of ("+i+") is Required.");
						returnVal=false;
						break;
					}
				}
				return returnVal;
				break;
			case IBINSERT: // Row Add
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				} else {
					return true;
				}
				break;
			case IBCOPYROW: // Row Copy
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "" || sheetObj.GetSelectRow()< 0) {
					return false;
				} else {
					return true;
				}
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
	 * Functino to set all button of an screen to be Enable/Disable <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode mandatory ,user mode
	 * @author 
	 * @version 2009.05.01
	 */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_rowadd");
			disableButton("btn_rowcopy");
			disableButton("btn_delete");
			sheetObjects[0].SetEditable(0);
			break;
		case "INIT":
			enableButton("btn_retrieve");
			enableButton("btn_save");
			enableButton("btn_rowadd");
			enableButton("btn_rowcopy");
			enableButton("btn_delete");
			sheetObjects[0].SetEditable(1);
			break;
		case "READONLY":
			enableButton("btn_retrieve");
			disableButton("btn_save");
			disableButton("btn_rowadd");
			disableButton("btn_rowcopy");
			disableButton("btn_delete");
			sheetObjects[0].SetEditable(0);
			break;
		}
	}
	/**
	 * Calling function from parent in case of loading a screen in tab.Setting default value<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr) {
		var formObject=document.form;
		
		if (formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			
			formObject.svc_scp_cd.value=sSvcScpCd;
			formObject.gline_seq.value=sGlineSeq;						
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);	
			
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
	 * Function to initialize all contents of an screen<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param 
	 * @return N/A
	 * @author 
	 * @version 2009.05.01
	 */
	function tabClearSheet() {
		var formObject=document.form;
		formObject.svc_scp_cd.value="";
		formObject.gline_seq.value="";
		sheetObjects[0].RemoveAll();
		formObject.ref_ctnt.value="";
		toggleButtons("CLEAR");
	}
	var enableFlag=true;
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
		formObject.ref_ctnt.disabled=!flag;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}
