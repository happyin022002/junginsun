/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4014.js
*@FileTitle  : Customer Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/* Examples) 
 ==========================================================================================
 (1) Select Constant proper to current window
 	 PRI_RG=0;  // RFA Guideline
 	 PRI_RP_SCP=1;  // RFA Proposal
 	 PRI_SG=2;  // S/C Guideline
 	 PRI_SP_SCP=3;  // S/C Proposal
 	 PRI_CMPB=5;  // CMPB Guideline
 	 PRI_SQ=6;  // SQ Guideline
 	 PRI_RQ=7;  // RQ Guideline
 (2) Select LOCATION TYPE ( Multi-select )
	 L:Location
	 G:Group Location
	 T:State
	 C:Country
	 R:Region
 (3) To Show proper windows to location type you select. 
     ( Default value When data is not exists : the screen of first type on (2) )
 (4) Use it for RFA (LOCATION CODE) - from main window
 (5) TRI GRI Use only 
 ==========================================================================================
*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	
//다음의 화면들에서 호출됨
//ESM_PRI_0003_07
//ESM_PRI_0081
//ESM_PRI_0070
//ESM_PRI_0031
//ESM_PRI_0032
//ESM_PRI_0033
//ESM_PRI_0100
//ESM_PRI_0101
//ESM_PRI_0102
	
	/**
     * Event handler processing by button name  <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return void
     * @author 
     * @version 2009.04.29
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
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_ok":
					buttonOkClick(sheetObject1);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
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
     * @version 2009.04.29
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
     * @version 2009.04.29
     */
	function loadPage() {
		
		 if (!opener) opener = window.dialogArguments;
    	 if (!opener) opener = window.opener;
    	 if (!opener) opener = parent;
    	 
		for (i=0; i < sheetObjects.length; i++) {
			// Modify Enviroment Setting Function's name
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// Add Environment Setting Function 
			ComEndConfigSheet(sheetObjects[i]);
		}
		pageOnLoadFinish();
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
     * @version 2009.04.29
     */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		 	case "sheet1":
		 	    with(sheetObj){
		        
		      var HeadTitle="Customer Code|Customer Name|Address|Type|S.OFC|S.REP|Segment|||";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"cust_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:"bzet_addr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_cust_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"srep_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vbs_clss_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_cnt_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cust_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetEditable(0);
		      SetWaitImageVisible(0);
		      SetAutoRowHeight(0);
		      resizeSheet();
	      }
		break;
		}
	}
	
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
    }
	/**
	 * Loading HTML control's event on page dynamically<br>
	 * <br><b>Example :</b>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.04.29
	 **/
	function initControl() {
		//** Date delimiter **/
		DATE_SEPARATOR="/";
		// Process Axon Event No.1, Event Catch 
		axon_event.addListenerForm  ('blur',    'obj_blur',     form    );  //- Execute OnBeforeDeactivate(blur) event code of all controls in form
		axon_event.addListener		('keydown', 'ComKeyEnter', 'form'	);
	}
	/**
	 * Check validataion on onBlur event of HTML Control. <br>
	 * 
	 * <br><b>Example :</b>
     * <pre>
     *     obj_blur();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.04.29
	 **/ 
	function obj_blur(){
		if(event.srcElement.name == "cust_seq") {
			if(!ComIsNull(event.srcElement) && ComGetLenByByte(event.srcElement) < 6) {
				event.srcElement.value=ComLpad(event.srcElement, 6, '0');
				return;
			}
		} 
	}
	/**
	 * Only Numeric characters could input on onkeypress event of HTML Control. <br>
	 * 
	 * <br><b>Example :</b>
     * <pre>
     *     obj_keypress();
     * </pre>
	 * @return void
     * @author 
     * @version 2009.04.29
	 **/ 
	/*function obj_keypress(){
		switch(eventsrcElement..dataformat) {
			case "int":
		        // Nurmeric Only
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        // Numeric and Decimal Point (.) Only
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			case "eng":
		        // Uppercase only
	            ComKeyOnlyAlphabet("uppernum");
	            break;
			default:
		        // Nurmeric Only
		        ComKeyOnlyNumber(event.srcElement);
		}
	}*/
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
     * @version 2009.04.29
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: // retrieving
				ComOpenWait(true);
				if (!validateForm(sheetObj, formObj, sAction)) {
					ComOpenWait(false);
					return false;
				}
				formObj.f_cmd.value=SEARCH01;
				if(formObj.is_popup.value == "true") {
					sheetObj.DoSearch("ESM_PRI_4014GS.do", FormQueryString(formObj) );
				} else {
					sheetObj.DoSearch("ESM_PRI_4030GS.do", FormQueryString(formObj) );
				}
				//ComOpenWait(false);
				break;
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
     * @version 2009.04.29
     */
	function validateForm(sheetObj, formObj, sAction) {
		with (formObj) {
			if(ComIsNull(formObj.cust_cnt_cd) && ComIsNull(formObj.cust_seq) &&ComIsNull(formObj.cust_lgl_eng_nm)) {
				ComShowCodeMessage("PRI04005","Customer Code","Customer Name");
				return false;
			}
			
			if(!ComIsNull(formObj.cust_cnt_cd) && ComGetLenByByte(formObj.cust_cnt_cd) < 2) {
				ComShowCodeMessage("PRI04003","Country code","2");
				return false;
			}else{
				if (ComIsNull(formObj.cust_seq) && ComGetLenByByte(formObj.cust_lgl_eng_nm) < 3){
					ComShowCodeMessage("PRI04004","Customer Name","3","100");
					return false;
				}
			}
			
			if(ComIsNull(formObj.cust_cnt_cd) && ComGetLenByByte(formObj.cust_lgl_eng_nm) < 5) {
				ComShowCodeMessage("PRI04004","Customer Name","5","100");
				return false;
			}
		}
		return true;
	}
	/**
     * calling function in case of OnDbClick event <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @param {int} Row mandatory Onclick ,Cell's Row Index
     * @param {int} Col mandatory Onclick ,Cell's Column Index
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
	function sheet1_OnDblClick(sheetObj, Row, Col) {
	    try{
	    	buttonOkClick(sheetObjects[0]);
	    	return false;
	    }catch(e){}
	}
    /**
     * Running funciton when loading page<br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns void
     * @author 
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	initControl();
		if(!ComIsNull(document.form.cust_cnt_cd.value) || !ComIsNull(document.form.cust_seq.value) || !ComIsNull(document.form.cust_lgl_eng_nm.value)) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
    }
	/**
     * calling function in case of Click Event in OK button <br>
     * <br><b>Example :</b>
     * <pre>
     *    buttonOkClick(sheetObj)
     * </pre>
     * @param {ibsheet} sheetObj Mandatory HTMLtag(Object) Object
     * @returns void
     * @author 
     * @version 2009.04.29
     */
	function buttonOkClick(sheetObj) {
		
//		if(  document.form.is_popup.value=="" )
//			return;
				
		var rtnObject=new Object(); 
		var Row=sheetObj.GetSelectRow();
		if(Row < 1) {
			ComShowCodeMessage("PRI04006");
			return;
		}
		rtnObject.custCd=sheetObj.GetCellValue(Row, "cust_cd");				//Customer Number
		rtnObject.custNm=sheetObj.GetCellValue(Row, "cust_lgl_eng_nm");		//Customer English Name
		rtnObject.custTpCd=sheetObj.GetCellValue(Row, "rvis_cntr_cust_tp_cd");
		rtnObject.LocCd=sheetObj.GetCellValue(Row, "loc_cd");
		rtnObject.Addr=sheetObj.GetCellValue(Row, "bzet_addr");
		rtnObject.custCntCd=sheetObj.GetCellValue(Row, "cust_cnt_cd");
		rtnObject.custSeq=sheetObj.GetCellValue(Row, "cust_seq");
		
		ComPopUpReturnValue(rtnObject);
	}
	
	function sheet1_OnSearchEnd(sheetObj, Code, Msg) { 
		//sheetObj.FitColWidth();
	    ComOpenWait(false);
	}
