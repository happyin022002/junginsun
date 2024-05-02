/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0070.js
*@FileTitle  : Actual Customer Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/25/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group : business script for ESM_PRI_0070
     */
    // global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
  //Event handler processing by button click event */
	document.onclick=processButtonClick;
	
//다음의 화면들에서 호출됨
//ESM_PRI_0003_08
	
	/**
	  * Event handler processing by button name 
	  */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_add":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
			case "btn_amend":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC11);
				break;
			case "btn_amendcancel":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC12);
				break;
			case "btn_accept":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC13);
				break;
			case "btn_acceptcancel":
				doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC14);
				break;
			case "btn_ok":
				if (formObject.prc_prop_sts_cd.value == "I" || formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
					ComPopUpReturnValue("O");
				} else {
					ComClosePopup(); 
				}
				break;
			case "btn_close":
				ComClosePopup(); 
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
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
     * Initializing and setting Sheet basics<br> 
     * Setting body tag's onLoad event handler<br>
     * Adding pre-handling function after loading screen on the browser <br>
     */
	function loadPage() {
		
		if (!opener) opener = window.dialogArguments;
		if (!opener) opener = window.opener;
		if (!opener) opener = parent;
		
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			sheetObjects[i].SetWaitImageVisible(0);
			ComEndConfigSheet(sheetObjects[i]);
		}
		bIsReqUsr=document.form.is_req_usr.value.toLowerCase() == "true" ? true : false;
		bIsAproUsr=document.form.is_apro_usr.value.toLowerCase() == "true" ? true : false;
        if (document.form.amdt_seq.value == "0") {
        	hiddenButton("btn_amend");
        	hiddenButton("btn_amendcancel");
        } else {
        	showButton("btn_amend");
        	showButton("btn_amendcancel");
        }
    	if ((bIsReqUsr || bIsAproUsr) && document.form.prc_prop_sts_cd.value == "I") {
        	enableButton("btn_add");
        	enableButton("btn_delete");
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
    	} else {
    		disableButton("btn_add");
    		disableButton("btn_delete");
    		disableButton("btn_amend");
    		disableButton("btn_amendcancel");
    	}
    	if (bIsAproUsr && document.form.prc_prop_sts_cd.value == "Q") {
        	enableButton("btn_accept");
        	enableButton("btn_acceptcancel");
    	} else {
            disableButton("btn_accept");
            disableButton("btn_acceptcancel");
    	}
    	if ((!bIsReqUsr && !bIsAproUsr) || opener.isCMDTGroupDeleted()) {
    		for (i=0; i < sheetObjects.length; i++) {
    			sheetObjects[i].SetEditable(0);
    		}
    	}
		//doActionIBSheet(sheetObjects[0], document.form, IBCLEAR); 
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	function obj_keydown(){
	       //Proposal No,S/C No.,Retrieving by enter key
	       //var eleName=event.srcElement.name;
	       var eleName=ComGetEvent("name");
	       alert( eleName );
	       if (eleName == "cust_cnt_cd"){
		       var keyValue=null;
		       if(event == undefined || event == null) {
		    	   keyValue=13;
		       }else{
		    	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		       }
//		       if (keyValue == 13){
//		    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
//		       }
	       }
	   }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
	            var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|act_cust_seq|Customer Code|Customer Code|Actual Customer Name|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User";
	            var headCount=ComCountHeadTitle(HeadTitle);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			                {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
			                {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"act_cust_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cust_cnt_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
			                {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cust_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"cust_lgl_eng_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             
	            InitColumns(cols);
	
	            SetEditable(1);
	            //conversion of function[check again]CLT 				InitDataValid(0, "cust_cnt_cd", vtEngUpOnly);
	            SetColProperty(0 ,"cust_cnt_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	            //conversion of function[check again]CLT 				InitDataValid(0, "cust_seq", vtNumericOnly);
	            SetColProperty(0 ,"cust_seq" , {AcceptKeys:"N"});
	            SetShowButtonImage(2);
//	            SetSheetHeight(102);
	            resizeSheet();

			}
			break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
	
    /**
    * handling event in case of specific cell on the sheet selected <br>
    */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	 /**
	* calling function when occurring OnChange Event <br> 
	*/
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "cust_cnt_cd" || colName == "cust_seq") {
			if (sheetObj.GetCellValue(Row, "cust_cnt_cd") == ""|| sheetObj.GetCellValue(Row, "cust_seq") == "") {
				return false;
			}
			formObj.f_cmd.value=COMMAND07;
			var param="&etc1=" + sheetObj.GetCellValue(Row, "cust_cnt_cd") + "&etc2=" + sheetObj.GetCellValue(Row, "cust_seq")+"&etc3=Y";
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + param);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0 && arrData[1] != "") {
				if (sheetObj.GetCellValue(Row, "cust_seq").length > 0 && sheetObj.GetCellValue(Row, "cust_seq").length < 6){
					sheetObj.SetCellValue(Row, "cust_seq",ComLpad(sheetObj.GetCellValue(Row, "cust_seq"), 6, "0"),0);
	 	    	}
				sheetObj.SetCellValue(Row, "cust_lgl_eng_nm",arrData[1],0);
			} else {
				sheetObj.SetCellValue(Row, "cust_lgl_eng_nm","",0);
	    		sheetObj.SetCellValue(Row, "cust_cnt_cd","",0);
	    		sheetObj.SetCellValue(Row, "cust_seq","",0);
	    		sheetObj.SelectCell(Row, "cust_seq", false);
	    		//ComShowCodeMessage("PRI00315");
	    		return false;
			}
		}
	}
	/**
	  * sheet1 OnPopupClick event function <br>
	 */
	var rtnRow;
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "cust_seq") {
			if (sheetObj.GetCellEditable(Row, "cust_seq")) {
				var sUrl="ESM_PRI_4014_POP.do?" + FormQueryString(document.form);
	            sUrl += "&is_popup=true&nmd_cust_flg=Y&cust_cnt_cd="+sheetObj.GetCellValue(Row, "cust_cnt_cd")+"&cust_seq="+sheetObj.GetCellValue(Row, "cust_seq");
	            rtnRow = Row;
	            ComOpenPopup(sUrl, 640, 465, "cust_seq_returnVal", "none", false);
			}
		}
	}
	
	
	function cust_seq_returnVal(rtnVal){
		if (rtnVal != null){
			var Row = rtnRow;
			sheetObj.SetCellValue(Row, "cust_cnt_cd",rtnVal.custCntCd,0);
			sheetObj.SetCellValue(Row, "cust_seq",ComLpad(rtnVal.custSeq, 6, "0"),0);
			sheetObj.SetCellValue(Row, "cust_lgl_eng_nm",rtnVal.custNm,0);
		}
	}
	  /**
	   * Handling sheet process<br>
	   */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		try {
			if (window.event == null || ComGetEvent() == null || $(ComGetEvent()).attr('suppressWait') != "Y") {
				ComOpenWait(true);
			}
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
	        case IBSEARCH_ASYNC11: // Amend
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var checkedCnt=sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SetSelectRow(curRow);
	        		sheetObj.SetCellValue(curRow, "chk","0",0);
	        	}
	        	var idx=opener.doRowAmend(sheetObj, "AM");
	        	setSheetStyle(sheetObj, idx - 1);
	        	setSheetStyle(sheetObj, idx);
	            break;
	        case IBSEARCH_ASYNC12: // Amend Cancel
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            var checkedCnt=sheetObj.CheckedRows("chk");
	        	if (checkedCnt == 1) {
	        		var curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
	        		sheetObj.SetSelectRow(curRow);
	        		sheetObj.SetCellValue(curRow, "chk","0",0);
	        	}
	        	var idx=opener.doRowAmendCancel(sheetObj);
	        	setSheetStyle(sheetObj, idx);
	            break;
	        case IBSEARCH_ASYNC13: // Accept
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00008")) {
	            	return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","A");
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Accepted");
	        	}
	            formObj.f_cmd.value=MODIFY01;
	            var sParam=FormQueryString(formObj);
	    		var sSheetParam=sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + sSheetParam;
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0070GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            sheetObj.CheckAll("chk",0,1);
	            setSheetStyle(sheetObj, -1);
	            exTransaction=true;
	            opener.updateSummary();
	            ComShowCodeMessage("PRI00108");
	            break;
	        case IBSEARCH_ASYNC14: // Accept Cancel
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            if (!ComShowCodeConfirm("PRI00009")) {
	            	return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	            var sCheckedRows=sheetObj.FindCheckedRow("chk");
	            var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_cd","I");
	        		sheetObj.SetCellValue(arrCheckedRows[i], "prc_prog_sts_nm","Initial");
	        	}
	            formObj.f_cmd.value=MODIFY02;
	            var sParam=FormQueryString(formObj);
	    		var sSheetParam=sheetObj.GetSaveString(false, false, "chk");
	            if (sSheetParam == "") {
	                return false;
	            }
	            sParam += "&" + sSheetParam;
	            var sXml=sheetObj.GetSaveData("ESM_PRI_0070GS.do", sParam);
	            sheetObj.LoadSaveData(sXml, false, "chk");
	            sheetObj.CheckAll("chk",0,1);
	            setSheetStyle(sheetObj, -1);
	            exTransaction=true;
	            opener.updateSummary();
	            ComShowCodeMessage("PRI00109");
	            break;
	        case IBSAVE: // OK
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	        	sheetObj.ColumnSort("act_cust_seq|amdt_seq", "ASC", "ASC|ASC", true);
				var sXml=ComPriSheet2Xml(sheetObj);
				opener.setSheetXml(sXml, 4);
				if (exTransaction) {
					opener.restylingPagePostTr();
				}
	            break; 
			case IBSEARCH: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
				var sXml=opener.getSheetXml(4);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.ColumnSort("act_cust_seq|amdt_seq", "ASC", "ASC|ASC", true);
				setSheetStyle(sheetObj, -1);
	         	break; 	
			case IBINSERT: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
		        var idx=sheetObj.DataInsert();
	            sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	            sheetObj.SetCellValue(idx, "gen_spcl_rt_tp_cd",formObj.gen_spcl_rt_tp_cd.value);
	            sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
	            sheetObj.SetCellValue(idx, "act_cust_seq",parseInt(ComPriGetMax(sheetObj, "act_cust_seq"))+ 1);
	            sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	            sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	            sheetObj.SetCellValue(idx, "src_info_cd","NW");
	            sheetObj.SetCellValue(idx, "src_info_nm","New");
	            sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	            sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	            setSheetStyle(sheetObj, idx);
	            sheetObj.SelectCell(idx, "cust_cnt_cd", false);
				break;
			case IBDELETE: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	        	if (sheetObj.CheckedRows("chk") <= 0) {
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1");
	        	}
	        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
	        	var arrCheckedRows=sCheckedRows.split("|");
	        	for (var i=0; i < arrCheckedRows.length; i++) {
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SetSelectRow(arrCheckedRows[i]);
	               		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","0",0);
	               		var idx=opener.doRowAmend(sheetObj, "AD");
	                	setSheetStyle(sheetObj, idx - 1);
	                	setSheetStyle(sheetObj, idx);
	            	}
	        	}
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
	* checking validation process of inputted form data <br>
	*/
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH_ASYNC11: // Amend
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var checkedCnt=sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow=-1;
        	if (checkedCnt == 1) {
        		 curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow=sheetObj.GetSelectRow();
        	}
        	if (sheetObj.GetCellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01011");
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC12: // Amend Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var checkedCnt=sheetObj.CheckedRows("chk");
        	if (checkedCnt > 1) {
        		ComShowCodeMessage("PRI00310");
        		return false;
        	}
        	var curRow=-1;
        	if (checkedCnt == 1) {
        		 curRow=parseInt(sheetObj.FindCheckedRow("chk").replace(/|/g, ""));
        	} else if (checkedCnt == 0) {
        		curRow=sheetObj.GetSelectRow();
        	}
        	if (sheetObj.GetCellValue(curRow, "src_info_cd") != "AM" && sheetObj.GetCellValue(curRow, "src_info_cd") != "AD") {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI01012");
        		return false;
        	}
        	if (sheetObj.GetCellValue(curRow, "prc_prog_sts_cd") != "I") {
        		ComShowCodeMessage("PRI01037");
        		return false;
        	}
            return true;
            break;
        case IBSEARCH_ASYNC13: // Accept
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "Q") {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
        		}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
            return true;
            break;
        case IBSEARCH_ASYNC14: // Accept Cancel
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.substr(0, sCheckedRows.length - 1).split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "A") {
					ComShowCodeMessage("PRI01038");
					return false;
        		}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
        	}
            return true;
            break;
        case IBSEARCH:
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        case IBSAVE: 
            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
                return false;
            }
        	var dupRow=ComPriAmendDupCheck(sheetObj, "cust_cnt_cd|cust_seq", formObj.amdt_seq.value);
        	if (dupRow >= 0) {
        		sheetObj.SetSelectRow(dupRow);
				ComShowCodeMessage("PRI00302");
				return false;
        	}
            return true;
            break;
        case IBINSERT: // Row Add
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	if (sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
            return true;
            break;
        case IBDELETE: // Delete
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (sheetObj.RowCount()<= 0) {
        		return false;
        	}
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isCMDTGroupDeleted()) {
        		return false;
        	}
        	var sCheckedRows=sheetObj.FindCheckedRow("chk");
        	var arrCheckedRows=new Array();
        	if (sCheckedRows== "") {
        		arrCheckedRows.push(sheetObj.GetSelectRow());
        	} else { 
        		arrCheckedRows=sCheckedRows.split("|");
        	}
        	for (var i=0; i < arrCheckedRows.length; i++) {
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "amdt_seq") != formObj.amdt_seq.value) {
            		ComShowCodeMessage("PRI00313");
            		return false;
            	}
        		if (sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "NW"&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GC"
        			&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GM"
        				&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PC"
        					&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "PM"
        						&& sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
        		if (formObj.amdt_seq.value == sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") && sheetObj.GetCellValue(arrCheckedRows[i], "prc_prog_sts_cd") != "I") {
	        		ComShowCodeMessage("PRI01037");
	        		return false;
	        	}
        	}
        	return true;
            break;
        }
    }
	/**
	 * setting color, Strike etc after retrieving on sheet <br>
	 */
    function setSheetStyle(sheetObj, idx) {
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	opener.setLineStyle(sheetObj, i);
            	setLineEnable(sheetObj, i);
            }
        } else {
        	opener.setLineStyle(sheetObj, idx);
        	setLineEnable(sheetObj, idx);
        }
    }
	/**
	 * setting editable or not all rows, column by row after retrieving on sheet <br>
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.prc_prop_sts_cd.value == "I"
    			&& sheetObj.GetCellValue(idx, "prc_prog_sts_cd") == "I"
    				&& sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
	        	sheetObj.SetCellEditable(idx, "cust_cnt_cd",1);
	        	sheetObj.SetCellEditable(idx, "cust_seq",1);
		} else {
        	sheetObj.SetCellEditable(idx, "cust_cnt_cd",0);
        	sheetObj.SetCellEditable(idx, "cust_seq",0);
		}
    }
