/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_PRI_0002_02.js
*@FileTitle  : Sales Guideline Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
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
	 * @class Guideline Creation :business script for Guideline Creation 
	 *
	 */
	function ESM_PRI_0002_02() {
		this.processButtonClick=tprocessButtonClick; 
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
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
		axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
		toggleButtons("CLEAR");
		parent.loadTabPage();
	}
    /**
     * Call deactivate event function <br>
     * <br><b>Example :</b>
     * <pre>
     *     
     * </pre>
     * @return void
     * @author 
     * @version 2009.05.17
     */
	function obj_deactivate(){
		if (ComChkObjValid(ComGetEvent())) {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			    case "ref_ctnt":
			        sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "ref_ctnt",document.form.ref_ctnt.value);
			        break;
			}
			return true;
		} else {
			return false;
		}
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
				with (sheetObj) {
					                    
                    var HeadTitle="|Sel.|Seq.|Service Scope|Gline Seq.|Ref Seq.|Title|Content";
                	
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
	
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
							     {Type:"DummyCheck", Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
							     {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",   Sort:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"svc_scp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"gline_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ref_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ref_tit_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							     {Type:"Text",      Hidden:1,  Width:90,   Align:"Left",    ColMerge:0,   SaveName:"ref_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 } ];
	
					InitColumns(cols);
	
					SetEditable(1);
					resizeSheet(); //SetSheetHeight(310);

				}
				break;
		}
	}
	
	function resizeSheet() {
		ComResizeSheet(sheetObjects[0], 140);
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
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		var formObj=document.form;
		if (OldRow != NewRow) {
			formObj.ref_ctnt.value=sheetObj.GetCellValue(NewRow, "ref_ctnt");
		}
	}
	
	function sheet1_OnSort(sheetObj ,Col, SortArrow){
		sheet1.ReNumberSeq();   
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
						formObj.f_cmd.value=SEARCH01;
						sheetObj.DoSearch("ESM_PRI_0002_02GS.do", FormQueryString(formObj) );
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
				return false;
			} else {
				return true;
			}
			break;
		}
	}
    /**
    * controlling buttons <br>
    * <br><b>Example :</b>
    * <pre>
    *     toggleButtons(mode)
    * </pre>
    * @param {string} mode Mandatory MODE Setting Value
    * @return void
    * @author 
    * @version 2009.05.22
    */
	function toggleButtons(mode) {
		switch (mode) {
		case "CLEAR":
			disableButton("btn_retrieve");
			break;
		case "INIT":
			enableButton("btn_retrieve");
			break;
		case "READONLY":
			enableButton("btn_retrieve");
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
		sheetObjects[0].RemoveAll();
		formObject.ref_ctnt.value="";
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
		formObject.ref_ctnt.disabled=true;
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}
	}