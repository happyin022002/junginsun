/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_03.js 
*@FileTitle  : RFA Proposal Inquiry - Commodity Group 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ESM_PRI_2019_03 : business script for ESM_PRI_2019_03 
 */
    function ESM_PRI_2019_03() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name  <br>
     */
	function processButtonClick() {
	}
    /**
    * registering IBSheet Object as list <br>
    * adding process for list in case of needing batch processing with other items  <br>
    * defining list on the top of source <br>
    */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
    * Initializing and setting Sheet basics <br>
    * Setting body tag's onLoad event handler <br>
    * Adding pre-handling function after loading screen on the browser  <br>
    */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		resizeSheet();
        loadSts=true;
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
				      var HeadTitle1="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|grp_cmdt_seq|Group Code|Description|src_info_cd|prc_prog_sts_cd";
				      var HeadTitle2="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|grp_cmdt_seq|Group Code|Description|src_info_cd|prc_prog_sts_cd";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"},
				                      { Text:HeadTitle2, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prop_no" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"prc_grp_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"prc_grp_cmdt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd" },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd" } ];
				      InitColumns(cols);
				      SetEditable(0);
				      SetWaitImageVisible(0);
			          SetShowButtonImage(2);
			          resizeSheet(); //SetSheetHeight(355);
				}
			break;
			
			case "sheet2":
			    with(sheetObj){
			      var HeadTitle1="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|CMDT Type|CMDT Code|Description|EFF Date|EXP Date" +
			      "|Source|Status|Accepted|Accepted|grp_cmdt_seq|grp_cmdt_dtl_seq|n1st_cmnc_amdt_seq";
			      var HeadTitle2="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|CMDT Type|CMDT Code|Description|EFF Date|EXP Date" +
			      "|Source|Status|By|On|grp_cmdt_seq|grp_cmdt_dtl_seq|n1st_cmnc_amdt_seq";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"},
			                      { Text:HeadTitle2, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"prop_no" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"amdt_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"svc_scp_cd" },
			             {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"prc_cmdt_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prc_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:"prc_cmdt_def_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"grp_cmdt_dtl_seq" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"n1st_cmnc_amdt_seq" } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetWaitImageVisible(0);
	              SetColProperty("prc_cmdt_tp_cd", {ComboText:COMODITY_TYPE2[1], ComboCode: COMODITY_TYPE2[0]});
			      SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
			      SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
			    //  SetShowButtonImage(2);
			      resizeSheet(); //SetSheetHeight(355);
		      }
			break;
		}
	}
	
	function resizeSheet() {
	    ComResizeSheet(sheetObjects[0]);
	    ComResizeSheet(sheetObjects[1]);
	}
     /**
      * calling function when occurring OnClick Event <br>
      */		
	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol)  {
		doRowChange(sheetObjects[0], sheetObjects[1], OldRow, NewRow, OldCol, NewCol, false);
	}
   /**
    * calling function when clicking sheet row <br>
    */		
	function doRowChange(sheetM, sheetD, OldRow, NewRow, OldCol, NewCol, appendRow) {
		var formObj=document.form;
		var adjNewRow=NewRow;
		if (OldRow != NewRow) {			
			formObj.grp_cmdt_seq.value=sheetM.GetCellValue(adjNewRow, "grp_cmdt_seq");
			doActionIBSheet(sheetD,document.form,IBSEARCHAPPEND);
		}
	}
    /**
    * Handling sheet process <br>
    */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
				case IBSEARCH: // retrieve
	  				ComOpenWait(true);
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
					formObj.f_cmd.value=SEARCH01;
					sheetObj.DoSearch("ESM_PRI_2019_03GS.do", FormQueryString(formObj) );
					break;
					
				case IBSEARCHAPPEND: // retrieve
					if (validateForm(sheetObj,document.form,sAction)) {
		  				ComOpenWait(true);
						formObj.f_cmd.value=SEARCH02;
						sheetObj.DoSearch("ESM_PRI_2019_03GS.do", FormQueryString(formObj) );
					}
					break;
			}
		} catch(e){
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
    * checking validation process of inputed form data <br>
    */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;
			
		case IBSEARCHAPPEND: // retrieve
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			}
			break;			
		}
		return true;
	}
	 /**
	  * calling function when clicking parent's screen tab <br>
	  * showing retrieved data<br>
	  */ 
	 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd) {
	 	var formObject=document.form;
	 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	 		formObject.prop_no.value=sPropNo;
	 		formObject.amdt_seq.value=sAmdtSeq;
	 		formObject.svc_scp_cd.value=sSvcScpCd;
	 		doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
	 	}
	 }
	/**
    * initializing parent's screen tab control <br>
    */		
	function tabClearSheet() {
		var formObject=document.form;
		formObject.prop_no.value="";
		formObject.amdt_seq.value="";
		formObject.svc_scp_cd.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
	}
	var enableFlag=true;
	/**
     * calling function from main screen <br>
     * prohibiting insert, update, delete in case or Confirmation = YES  <br>
     */		
	function tabEnableSheet(flag) {
		enableFlag=flag;
	}
	var loadSts=false;
    /**
     * calling function from main screen <br>
     */
	function loadFinishCheck(){
	    return loadSts;
	} 	
	
    /**
	 * Calling function in case of Onclick event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj Mandatory IBSheet Object
	 * @param {int} Row Mandatory Onclick ,Cell's Row Index
	 * @param {int} Col Mandatory Onclick ,Cell's Column Index
	 * @return N/A
	 * @author 
	 * @version 2015.12.08
	 */
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var memoColWidth =	sheetObj.GetColWidth("prc_grp_cmdt_desc");
		if (colName == "prc_grp_cmdt_desc") {
			ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 7, 1000, "X");
		} 
	}
	