/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034_03.js
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class business script for ESM_BKG_0034_03 
	 */
	function ESM_BKG_0034_03() {
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.doActionIBSheet=doActionIBSheet;
		this.validateForm=validateForm;
	}
	/* developer job	*/
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items 
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		if (document.form.bl_no.value != "") {
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		if (parent.loadTabPage != undefined)
			parent.loadTabPage(2);
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:
			with (sheetObj) {
		    var HeadTitle="Seq.|C|Code|Q'ty|Entry Type & No.|Entry Type & No.|Receive Date/Time|Customs|VVD|Remark|SCAC|AMS File No.|Batch||||||||";
		    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle, Align:"Center"} ];
		    InitHeaders(headers, info);
		    var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dspo_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"entr_tp_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"entr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"rcv_date",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"rcv_loc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"cstms_rmk",     MultiLineText:1, KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"scac_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ibd_ref_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cstms_bat_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rcv_msg_tp_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rcv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 },
		              {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"rjct_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   Wrap:1 } ];
		    InitColumns(cols);
//		    SetSheetHeight(280);
		    ComResizeSheet(sheetObj);
		    SetEditable(0);
	        SetColProperty("rcv_date", {Format:"####-##-## ##:##:##"} );
		    SetCountFormat("[SELECTDATAROW / TOTALROWS]");
			}
			break;
		case 2:
			with (sheetObj) {
			    var HeadTitle="Seq|Code|Desc";
			    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			    var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			    var headers = [ { Text:HeadTitle, Align:"Center"} ];
			    InitHeaders(headers, info);
	
			    var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			              {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cstms_dspo_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			              {Type:"Text",      Hidden:0,  Width:45,   Align:"Left",    ColMerge:0,   SaveName:"cstms_dspo_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			    InitColumns(cols);
			    SetVisible(0);
			    SetEditable(0);
			}
			break;
		}
	}
	/**
	 * Post-processing data inquiry sheet - SCAC data set according to the text color
	 * Red: MR / AR if it contains on the Rejection Message
	 */
	function t3sheet1_OnSearchEnd(sheetObj,ErrMsg)
	{   
	    for(i=1; i<sheetObj.RowCount()+1; i++){
    		if (sheetObj.GetCellValue(i, "rjct_flg") == "Y") {
	       		sheetObj.SetRowFontColor(i,"#FF0000");//red
	       	}
    		if (sheetObj.GetCellValue(i, "scac_cd") != "NYKS") {
	       		sheetObj.SetRowFontColor(i,"#0000FF");//blue
	       	}
	    }
	}
	/**
	 * Data set to hidden tags when you click sheet
	 */
	function t3sheet1_OnClick(sheetObj, Row, Col) {
		var formObj=document.form;
		formObj.cnt_cd.value=sheetObj.GetCellValue(Row, "cnt_cd");
		formObj.io_bnd_cd.value=sheetObj.GetCellValue(Row, "io_bnd_cd");
		formObj.rcv_date.value=sheetObj.GetCellValue(Row, "rcv_date");
		formObj.rcv_seq.value=sheetObj.GetCellValue(Row, "rcv_seq");
	}
	/**
	 * Mouse over tooltips show above sheet
	 */
	function t3sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
		//Get the value from the column and row position of the mouse
	    var Row=sheetObj.MouseRow();
	    var Col=sheetObj.MouseCol();
	    var sText;
	    var sheetObj2=sheetObjects[1];
	    if(sheetObj.ColSaveName(Col) == "dspo_cd") {
	    	for(var i=1; i<sheetObj2.RowCount(); i++){
	    		if(sheetObj.GetCellText(Row, Col) == "AR") continue;
	    		if(sheetObj.GetCellText(Row, Col) == sheetObj2.GetCellText(i,"cstms_dspo_cd")){
	    			sText=sheetObj2.GetCellText(i,"cstms_dspo_nm");
	    			break;
	    		}
	    	}
	    	sheetObj.SetToolTipText(Row,"dspo_cd",sText);
	    }
	}
	// handling of Sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
		switch (sAction) {
			case IBSEARCH: // retrieve
				if (validateForm(sheetObj,formObj,sAction)) {
//					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH01;
 					sheetObj.DoSearch("ESM_BKG_0034_03GS.do", FormQueryString(formObj) );
 					formObj.cnt_cd.value=sheetObj.GetCellValue(1, "cnt_cd");
 					formObj.io_bnd_cd.value=sheetObj.GetCellValue(1, "io_bnd_cd");
 					formObj.rcv_date.value=sheetObj.GetCellValue(1, "rcv_date");
 					formObj.rcv_seq.value=sheetObj.GetCellValue(1, "rcv_seq");
					var formP=parent.document.form;
					if (formP.pod_cd.value.substr(0,2) != 'US' && formP.del_cd.value.substr(0,2) == 'US')
					{
						sheetObj.SetColBackColor("cstms_clr_cd","#EFF0F3");
					}
//					ComOpenWait(false);
				}
				break;
			case IBSEARCH_ASYNC01: 
				formObj.f_cmd.value=SEARCH04;
				formObj.cnt_cd.value='US';
 				sheetObj.DoSearch("ESM_BKG_0034_03GS.do", FormQueryString(formObj) );
				break;
		}
	}
    /**
     * handling process for input validation
     */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // retrieve
			if (formObj.bl_no.value == "") {
				return false;
			} else {
				return true;
			}
			break;
		}
	}
    /**
     * handling process for tab event
     */
	function tabLoadSheet(strBlNo) {
		var formObject=document.form;
		if (formObject.bl_no.value != strBlNo) {
			formObject.bl_no.value=strBlNo;
			doActionIBSheet(sheetObjects[1], formObject, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
			if(sheetObjects[0].RowCount()> 0){
				ComBtnEnable("btn_view");
			}
		}
	}
	/**
	 * Tab data initialization
	 */
	function tabClearSheet() {
		document.form.bl_no.value="";
		sheetObjects[0].RemoveAll();
	}
	/**
	 * enable tab
	 */
	var enableFlag=true;
	function tabEnableSheet(flag) {
		var formObject=document.form;
		enableFlag=flag;
		sheetObjects[0].SetEditable(flag);
	}
	/**
	 * Sheet data as a string return
	 */
	function getSaveString() {
		var sheetObj=sheetObjects[0];
		if(sheetObj.GetTotalRows()> 0){
			var params;
			var rcv_date=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rcv_date");
			var rcv_seq=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "rcv_seq");
			var bl_no=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "bl_no");
		 	params="&cnt_cd=US&io_bnd_cd=I&rcv_date="+rcv_date+"&rcv_seq="+rcv_seq+"&blNo="+ bl_no;
			return params;
		}
		else{
			return "";
		}
	}
	 /* developers work end */

