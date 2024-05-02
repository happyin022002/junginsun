/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2048.js
*@FileTitle  : RFA Guideline Creation - Arbitrary[Load Excel]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/12
=========================================================*/
/****************************************************************************************
 Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_PRI_2048 : Business Script for ESM_PRI_2048
 */
function ESM_PRI_2048() {
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
var errFlg=false; 
// Event handler processing by button click event */
document.onclick=processButtonClick;
/**
 * Event handler processing by button name  <br>
 * <br>
 * <b>Example :</b>
 * 
 * <pre>
 * processButtonClick();
 * </pre>
 * 
 * @return void
 * @author 
 * @version 2009.07.30
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
		case "btn_save":
			if (validateForm(sheetObject1, formObject, IBSAVE)) {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			}
			break;
		case "btn_check":
			if (validateForm(sheetObject1, formObject, IBSEARCH)) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btn_file":
			sheetObjects[0].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
			break;
		case "btn_Template":
		    downform.submit();
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
 * @version 2009.05.20
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
	
	if (!opener) opener = window.dialogArguments;
	if (!opener) opener = window.opener;
	if (!opener) opener = parent;
	
	for (i=0; i < sheetObjects.length; i++) {
		//Modify Environment Setting Function's name
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// Add Environment Setting Function 
		ComEndConfigSheet(sheetObjects[i]);
	}
	buttonControl("INIT");
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
 * @version 2009.05.17
 */
function initSheet(sheetObj, sheetNo) {
	var formOrg=document.form;
	var cnt=0;
	switch (sheetNo) {
    
	case 1: //sheet1 init
		with(sheetObj){
  
	         var HeadTitle="|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton <=)|Weight\n(<Ton )|Base Port|Per|Cargo Type|Cur.|Rate";
	         HeadTitle += "|1|2|3|4|5";
	         var headCount=ComCountHeadTitle(HeadTitle);

	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:HeadTitle, Align:"Center"} ];
	         InitHeaders(headers, info);

	         var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"arb_seq" },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_def_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"rout_pnt_loc_def_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:40 },
	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"prc_trsp_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rcv_de_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_def_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" },
	             {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
	             {Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"bse_port_tp_cd" } ];
	          
	         InitColumns(cols);
	         SetColProperty("rcv_de_term_cd", {ComboText:rcvDeTermCdComboText, ComboCode:rcvDeTermCdComboValue} );
	         SetColProperty("prc_trsp_mod_cd", {ComboText:prcTrspModCdComboText, ComboCode:prcTrspModCdComboValue} );
	         SetColProperty("rat_ut_cd", {ComboText:ratUtCdComboText, ComboCode:ratUtCdComboValue} );
	         SetColProperty("prc_cgo_tp_cd", {ComboText:prcCgoTpCdComboText, ComboCode:prcCgoTpCdComboValue} );
	         SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
	         SetEditable(1);
	         SetWaitImageVisible(0);
	         //conversion of function[check again]CLT 			InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOnly);
	         //conversion of function[check again]CLT 			InitDataValid(0, "bse_port_def_cd", vtEngUpOther, "1234567890");
	         SetColProperty(0 ,"rout_pnt_loc_def_cd" , {AcceptKeys:"E|[0123456789]", InputCaseSensitive:1});
	         SetColProperty(0 ,"bse_port_def_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
	         
	         SetShowButtonImage(2);
	         resizeSheet(); //SetSheetHeight(300);
	         }
	         break;

    	case 2: //Column VALIDATION - Use it for Database Query
    		with(sheetObj){
			
			var HeadTitle="|Seq.|Point|Description|Trans Mode|Term|Weight\n(Ton <=)|Weight\n(<Ton )|Base Port|Per|Cargo Type|Cur.|Rate";
			HeadTitle += "|1|2|3|4|5";
			var headCount=ComCountHeadTitle(HeadTitle);
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );
			
			var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"arb_seq" },
			{Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rout_pnt_loc_def_cd" },
			{Type:"Text",      Hidden:1, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"rout_pnt_loc_def_desc" },
			{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"prc_trsp_mod_cd" },
			{Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"rcv_de_term_cd" },
			{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"min_cgo_wgt" },
			{Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"max_cgo_wgt" },
			{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_port_def_cd" },
			{Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rat_ut_cd" },
			{Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"prc_cgo_tp_cd" },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd" },
			{Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt" },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"gline_seq" },
			{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"org_dest_tp_cd" },
			{Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"rout_pnt_loc_tp_cd" },
			{Type:"Text",      Hidden:1, Width:86,   Align:"Right",   ColMerge:0,   SaveName:"bse_port_tp_cd" } ];
			
			InitColumns(cols);
			
			SetEditable(0);
			SetWaitImageVisible(0);
			SetSheetHeight(160);
			SetVisible(0);
    		}
    		break;

	}
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
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
	var colname=sheetObj.ColSaveName(Col);
	var formObj=document.form
	switch (colname) {
	case "rout_pnt_loc_def_cd":
		if (Value.length == 5) {
			formObj.f_cmd.value=SEARCH05;
			formObj.cd.value=sheetObj.GetCellValue(Row, Col);
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do",
					FormQueryString(formObj));
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_desc",arrData[0][1],0);
				sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","L",0);
			} else {
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_desc","",0);
				sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
				sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
				sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
			}
		} else {
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_desc","",0);
			sheetObj.SetCellValue(Row, "rout_pnt_loc_def_cd","",0);
			sheetObj.SetCellValue(Row, "rout_pnt_loc_tp_cd","",0);
			sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
		}
		break;
	case "bse_port_def_cd":		
		if (Value.length == 5) {
			if(Value == sheetObj.GetCellValue(Row, "rout_pnt_loc_def_cd") && sheetObj.GetCellValue(Row, "rcv_de_term_cd") != "D") {
				ComShowCodeMessage('PRI01020');
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
				break;
			}
			formObj.f_cmd.value=SEARCH05;
			formObj.cd.value=Value;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do",FormQueryString(formObj));
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","L",0);
			} else {
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
		} else if(Value.length == 4) {
			formObj.f_cmd.value=COMMAND24;
			formObj.cd.value=Value;
			var sParam=FormQueryString(formObj);
			sParam += "&etc1="+PRI_RG;
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","G",0);
			} else {
				sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
		} else {
			sheetObj.SetCellValue(Row, "bse_port_def_cd","",0);
			sheetObj.SetCellValue(Row, "bse_port_tp_cd","",0);
			sheetObj.SelectCell(Row, "bse_port_def_cd");
		}
		break;
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
 * @version 2009.05.17
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH: 			
  				ComOpenWait(true);	
				formObj.f_cmd.value=MULTI02;
				var sParam=FormQueryString(formObj);
				var sParamSheet=sheetObj.GetSaveString();
				if (sParamSheet != "") {
  					sParam=ComPriSetPrifix(sParamSheet, "") + "&" + sParam;
  				}
 				var sXml=sheetObj.GetSearchData("ESM_PRI_2048GS.do", sParam);
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				// Error Data makes Red
				checkValidationAllData(sheetObjects[1]);
				break;
			case IBSAVE: // Save
				if(errFlg) {
					buttonControl("FAIL");
					return false;
				}
				if((ComShowCodeConfirm("PRI00001")) ) {
	  				ComOpenWait(true);
					formObj.f_cmd.value=MULTI;
					sheetObj.DoSave("ESM_PRI_2048GS.do", FormQueryString(formObj), -1, false);
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
	case IBSEARCH: // Check
		if (!sheetObjects[0].IsDataModified()) {
			ComShowCodeMessage("PRI00312");
			return false;
		}
		break;
	case IBSAVE: // Saving
		if(ComGetBtnDisable("btn_save")) return false;
		if (sheetObjects[0].IsDataModified()) {
			//checking of duplicate with existing data
			sheetObjects[1].RemoveAll();
			var sXml=ComPriSheet2Xml(sheetObjects[0])
			sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
			formObj.f_cmd.value=SEARCH;
 			sXml=sheetObj.GetSearchData("ESM_PRI_2001_03GS.do", FormQueryString(formObj));
			sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:1} );
			var rowM = sheetObjects[1].ColValueDupRows("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|" +
					"bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|min_cgo_wgt|max_cgo_wgt", false, true);
			if (rowM != "") {
				var rowDup=rowM.split("|");
				ComShowCodeMessage("PRI00303", "Sheet", rowDup[0]);
				// Process to modifying duplication data
				sheetObj.SetEditable(1);
				buttonControl("FAIL");
				return false;
			}
		}
		break;
	}
	return true;
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
 * @version 2009.05.17
 */
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var psheetObj=opener.sheetObjects[0];
	var pformObj=opener.document.form;
	opener.parent.setTabStyle();
	opener.doActionIBSheet(psheetObj, pformObj, IBSEARCH);
	ComClosePopup(); 
}
/**
 * calling function when occurring LoadExcel event <br> 
 * @author 
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @return void
 * @author 
 * @version 2009.06.25
 */
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return;
	var formObj=document.form;
	if (sheetObj.RowCount()> 0) {
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			//Mandatory Code Data Set
			sheetObj.SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value,0);
			sheetObj.SetCellValue(i, "gline_seq",formObj.gline_seq.value,0);
			sheetObj.SetCellValue(i, "org_dest_tp_cd",formObj.org_dest_tp_cd.value,0);
		}
	}
	buttonControl("LOAD");
}
 /**
  * The function calls after Check button event. When Error Data exists, make BGColor of Sheet red.<br>
  * <br><b>Example :</b>
  * <pre>
  * 
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @return void
  * @author 
  * @version 2009.05.20
  */
 function checkValidationAllData(sheetObj) {
		var check=0;
		// Setting color to Error Cell
		var color="#FF0000"; // RED
		// Initialize Color - White
		for ( var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
			sheetObjects[0].SetRowBackColor(i,0);
		}
		//Validation Check
		check += validateSheetData(sheetObjects[0], color);
		// Validation check on DB
		check += checkDBCodeExist(sheetObj, color);
		if (check > 0) {
			errFlg=true;
			buttonControl("FAIL");
		} else {
			errFlg=false;
			//Process All Cell make Read-Only
			sheetObjects[0].SetEditable(0);
			buttonControl("SUCCEED");
		}
 }
 /**
  * calling Event when keyboard press data cell <br> 
  * <br><b>Example :</b>
  * <pre>
  * 
  * </pre>
  * @param {ibsheet} sheetObj mandatory IBSheet Object
  * @param {Long} Row mandatory , Row Index of cell that event triggered
  * @param {Long} Col mandatory , Column Index of cell that event triggered
  * @param   {Integer} KeyCode Mandatory ASCII code value
  * @param {Integer} Shift Mandatory , 1:Shift, 2:Ctrl, 0 :other
  * @return void
  * @author 
  * @version 2009.05.20
  */ 
  function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
      if (errFlg && KeyCode == 9) {
          while (true) {
              if (Col > sheetObj.LastCol()) {
                  Row++;
                  Col=1;
              }
              if (Row > sheetObj.LastRow()) {
                  Row=sheetObj.HeaderRows();
              }
              if (sheetObj.GetCellBackColor(Row, Col) == "#FF0000" ) {
                  sheetObj.SelectCell(Row, Col, false);
                  break;
              }
              Col++;
          }
      }
  }
/**
 * Check the validation rules on objects in windows <br>
 * Return the check value when violate the validation rule. <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {object} color Mandatory IBSheet RgbColor
 * @return check
 * @author 
 * @version 2009.06.25
 */
function validateSheetData(sheetObj, color) {
	var check=0;
	var baseColor="#FFFFFF";
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		if (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd").length != 5) {
			sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "prc_trsp_mod_cd") == ""
				&& ComTrim(sheetObj.GetCellText(i, "prc_trsp_mod_cd")) != "") {
			sheetObj.SetCellBackColor(i, "prc_trsp_mod_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "prc_trsp_mod_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "rcv_de_term_cd") == "") {
			sheetObj.SetCellBackColor(i, "rcv_de_term_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "rcv_de_term_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "min_cgo_wgt") != "" && sheetObj.GetCellValue(i, "min_cgo_wgt") > 99.99) {
			sheetObj.SetCellBackColor(i, "min_cgo_wgt", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "min_cgo_wgt", baseColor);
		}
		if (sheetObj.GetCellValue(i, "max_cgo_wgt") != "" && sheetObj.GetCellValue(i, "max_cgo_wgt") > 99.99) {
			sheetObj.SetCellBackColor(i, "max_cgo_wgt", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "max_cgo_wgt", baseColor);
		}
		if (sheetObj.GetCellValue(i, "bse_port_def_cd") == "") {
			sheetObj.SetCellBackColor(i, "bse_port_def_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "bse_port_def_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "rat_ut_cd") == "") {
			sheetObj.SetCellBackColor(i, "rat_ut_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "rat_ut_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "prc_cgo_tp_cd") == ""
				&& ComTrim(sheetObj.GetCellText(i, "prc_cgo_tp_cd")) != "") {
			sheetObj.SetCellBackColor(i, "prc_cgo_tp_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "prc_cgo_tp_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "curr_cd") == "") {
			sheetObj.SetCellBackColor(i, "curr_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "curr_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "frt_rt_amt").length > 10) {
			sheetObj.SetCellBackColor(i, "frt_rt_amt", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "frt_rt_amt", baseColor);
		}
		// When Term is not  Door, b.port and point is the same code.  It needs validation check.
		if (sheetObj.GetCellValue(i, "rcv_de_term_cd") != "D"
			&& (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == sheetObj.GetCellValue(i, "bse_port_def_cd"))) {
			sheetObj.SetCellBackColor(i, "rcv_de_term_cd", color);
			sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd", color);
			sheetObj.SetCellBackColor(i, "bse_port_def_cd", color);
			check++;
		}else{
			sheetObj.SetCellBackColor(i, "rcv_de_term_cd", baseColor);
			sheetObj.SetCellBackColor(i, "rout_pnt_loc_def_cd", baseColor);
			sheetObj.SetCellBackColor(i, "bse_port_def_cd", baseColor);
		}
	}
	return check;
}
/**
 * validation function of excel file loading <br>
 * existing error data, changed color <br>
 * <br><b>Example :</b>
 * <pre>
 * 		checkDBCodeExist(sheetObj, formObj);
 * </pre>
 * @param {ibsheet} sheetObj mandatory IBSheet Object
 * @param {object} color Mandatory IBSheet RgbColor
 * @return check
 * @author 
 * @version 2009.05.17
 */
function checkDBCodeExist(sheetObj, color) {
	var check=0;
	var arbSeq=0;
	var baseColor="#FFFFFF";
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		arbSeq=sheetObjects[0].GetCellValue(i, "arb_seq");
		// When CHECK buttn clicked, separate it using '0', '1'. When Save button clicked, pass it.
		if (sheetObj.GetCellValue(i, "rout_pnt_loc_def_cd") == "0") {
			sheetObjects[0].SetCellBackColor(arbSeq, "rout_pnt_loc_def_cd", color);
			check++;
		} else {
			sheetObjects[0].SetCellValue(arbSeq, "rout_pnt_loc_tp_cd","L",0);
			sheetObjects[0].SetCellBackColor(arbSeq, "rout_pnt_loc_def_cd", baseColor);
		}
		if (sheetObj.GetCellValue(i, "bse_port_def_cd") == "0") {
			sheetObjects[0].SetCellBackColor(arbSeq, "bse_port_def_cd", color);
			check++;
		} else {
			if (sheetObjects[0].GetCellValue(arbSeq, "bse_port_def_cd").length == 4) {
				sheetObjects[0].SetCellValue(arbSeq, "bse_port_tp_cd","G",0);
			} else if (sheetObjects[0].GetCellValue(arbSeq, "bse_port_def_cd").length == 5) {
				sheetObjects[0].SetCellValue(arbSeq, "bse_port_tp_cd","L",0);
			}
			sheetObjects[0].SetCellBackColor(arbSeq, "bse_port_def_cd", baseColor);
		}
	}
	return check;
}
/**
  * Controlling button's authority<br>
  * controlling buttons <br>
  * <br><b>Example :</b>
  * <pre>
  * buttonControl()
  * </pre>
  * @param  void
  * @return void
  * @author 
  * @version 2009.07.31
  */
function buttonControl(valChck){
	var formObj=document.form;
	var rowCount=sheetObjects[0].RowCount();
	try{
		ComBtnDisable("btn_file");
		ComBtnDisable("btn_check");
		ComBtnDisable("btn_save");
		ComBtnEnable("btn_close");
		switch(valChck) {
			case "SUCCEED":
				//ComBtnEnable("btn_file");
				//ComBtnEnable("btn_check");
				ComBtnEnable("btn_save");
				break;
			case "FAIL":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
			case "LOAD":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
			case "INIT":
				ComBtnEnable("btn_file");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				break;
		}	
	} catch (e) {}
}