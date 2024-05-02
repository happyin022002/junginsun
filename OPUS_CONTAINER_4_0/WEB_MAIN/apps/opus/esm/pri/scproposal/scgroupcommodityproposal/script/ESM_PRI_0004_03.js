/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_03.js
*@FileTitle  : S/C Proposal Commodity Group - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
    var askOnce=true;
    var isGrpDel=false;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	/**
     * Event handler processing by button name  <br>
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
				      var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|grp_cmdt_seq|Group Code|Description|src_info_cd|prc_prog_sts_cd";
				      var headCount=ComCountHeadTitle(HeadTitle);
		
				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
				      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
				             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
				             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_grp_cmdt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_cmdt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd" },
				             {Type:"Text",      Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd" } ];
				       
				      InitColumns(cols);
		
				      SetEditable(0);
				      SetWaitImageVisible(0);
		            //SetShowButtonImage(2);
				      resizeSheet(); //SetSheetHeight(310);
		      }
		      break;

			case "sheet2":
			    with(sheetObj){
			      var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|grp_cmdt_seq|grp_cmdt_dtl_seq|Code|Description|prc_cmdt_tp_cd" +
			      "|EFF Date|EFF Seq|EXP Date|Source|Status|Accept Staff/Team|Accept Date";
			      var headCount=ComCountHeadTitle(HeadTitle);
	
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prop_no" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"amdt_seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"grp_cmdt_dtl_seq" },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_def_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:"cmdt_def_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"prc_cmdt_tp_cd" },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       
			      InitColumns(cols);
	
			      SetEditable(0);
			      SetColProperty("src_info_cd", {ComboText:srcInfoCdComboText, ComboCode:srcInfoCdComboValue} );
			      SetColProperty("prc_prog_sts_cd", {ComboText:prcProgStsCdComboText, ComboCode:prcProgStsCdComboValue} );
			      SetWaitImageVisible(0);
		          //SetShowButtonImage(2);
			      resizeSheet(); //SetSheetHeight(310);
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
    * when selecting sheet's Row, setting hilighting this Row<br>
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
					formObj.f_cmd.value=SEARCH01;
  					sheetObj.DoSearch("ESM_PRI_0004_03GS.do", FormQueryString(formObj) );

					break;
				case IBSEARCHAPPEND: // retrieve
					formObj.f_cmd.value=SEARCH02;
  					sheetObj.DoSearch("ESM_PRI_0004_03GS.do", FormQueryString(formObj) );
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
	
	function sheet2_OnSearchEnd(sheetObj , code , msg){
		ComOpenWait(false);
	}
    /**
     * checking validation process of inputed form data <br>
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCHAPPEND: // retrieve
			if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "" ) {
				return false;
			} else {
				return true;
			}
			break;
		case IBSEARCH_ASYNC01: // retrieve
			return true;
			break;			
		}
	}
	 /**
	  * calling function when clicking parent's screen tab <br>
	  * showing retrieved data<br>
	  */ 
	 function tabLoadSheet(sPropNo, sAmdtSeq, sSvcScpCd, sConChk) {
	 	var formObject=document.form;
	 	if (formObject.prop_no.value != sPropNo || formObject.amdt_seq.value != sAmdtSeq || formObject.svc_scp_cd.value != sSvcScpCd) {
	 		formObject.prop_no.value=sPropNo;
	 		formObject.amdt_seq.value=sAmdtSeq;
	 		formObject.svc_scp_cd.value=sSvcScpCd;
	 		formObject.con_chk.value=sConChk;
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
	