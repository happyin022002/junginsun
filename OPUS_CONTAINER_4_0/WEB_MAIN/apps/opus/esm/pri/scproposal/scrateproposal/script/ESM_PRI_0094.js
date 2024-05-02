/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0094.js
*@FileTitle  : Direct Call Amend Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
     * @class Commodity Group :business script for Commodity Group 
     */
    function ESM_PRI_0094() {
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
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
//다음의 화면들에서 호출됨
//ESM_PRI_0003_08
	
	/**
	 * Event handler processing by button name  <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return void
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
				} else {
					//ComClosePopup(); 
					ComPopUpReturnValue("X");
				}
				break;
			case "btn_close":
				if (formObject.prc_prop_sts_cd.value == "Q") {
					doActionIBSheet(sheetObject1, document.form, IBSAVE);
				} else {
					//ComClosePopup(); 
					ComPopUpReturnValue("X");
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
	 * @version 2009.05.01
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
	 * @version 2009.05.01
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
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
    	} else {
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
	 * @version 2009.05.01
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){

		      var HeadTitle="|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|Direct Call|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User";
		      var headCount=ComCountHeadTitle(HeadTitle);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dir_call_flg",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetColProperty("dir_call_flg", {ComboText:"Y|N/A", ComboCode:"Y|N"} );		        
		      SetEditable(1);
		      SetShowButtonImage(2);
		      SetSheetHeight(120);
		      }
			break;
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
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	changeSelectBackColor4Rate(sheetObj);
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
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
        case IBSEARCH_ASYNC11: // Amend
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
        	var idx=opener.doRowAmend(sheetObj, "AM");
        	// When Amendment, Modify the flag to opposite status, fixed it Readonly. 2009-07-02.
        	sheetObj.SetCellValue(idx, "dir_call_flg",sheetObj.GetCellValue(idx, "dir_call_flg") == "Y" ? "N" : "Y");
        	setSheetStyle(sheetObj, idx - 1);
        	setSheetStyle(sheetObj, idx);
            break;
        case IBSEARCH_ASYNC12: // Amend Cancel
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
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
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd","A");
        	sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_nm","Accepted");
            formObj.f_cmd.value=MODIFY01;
            var sParam=FormQueryString(formObj);
    		var sSheetParam=sheetObj.GetSaveString();
            if (sSheetParam == "") {
                return false;
            }
            sParam += "&" + sSheetParam;
             var sXml=sheetObj.GetSaveData("ESM_PRI_0094GS.do", sParam);
             sheetObj.LoadSaveData(sXml);
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
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd","I");
    		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_nm","Initial");
            formObj.f_cmd.value=MODIFY02;
            var sParam=FormQueryString(formObj);
    		var sSheetParam=sheetObj.GetSaveString();
            if (sSheetParam == "") {
                return false;
            }
            sParam += "&" + sSheetParam;
            var sXml=sheetObj.GetSaveData("ESM_PRI_0094GS.do", sParam);
            sheetObj.LoadSaveData(sXml);
            setSheetStyle(sheetObj, -1);
            exTransaction=true;
            opener.updateSummary();
            ComShowCodeMessage("PRI00109");
            break;
        case IBSAVE: // OK
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
        	sheetObj.ColumnSort("amdt_seq", "ASC", "ASC", true);
			var sXml=ComPriSheet2Xml(sheetObj);
			opener.setSheetXml(sXml, 10);
            ComPopUpReturnValue("O");
			if (exTransaction) {
				opener.restylingPagePostTr();
			}
            break; 
		case IBSEARCH: 
            if (!validateForm(sheetObj,document.form,sAction)) {
                return false;
            }
			var sXml=opener.getSheetXml(10);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			sheetObj.ColumnSort("amdt_seq", "ASC", "ASC", true);
			setSheetStyle(sheetObj, -1);
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
	 * @version 2009.05.01
	 */
    function validateForm(sheetObj, formObj, sAction) {
        try {
//            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//                ComOpenWait(true);
//            }
	        switch (sAction) {
	        case IBSEARCH_ASYNC11: // Amend
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount() <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	if (opener.isRouteGroupDeleted()) {
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") == formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI01011");
	        		return false;
	        	}
	            return true;
	            break;
	        case IBSEARCH_ASYNC12: // Amend Cancel
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount() <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "I") {
	        		return false;
	        	}
	        	if (opener.isRouteGroupDeleted()) {
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd") != "AM" && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "src_info_cd") != "AD") {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI01012");
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") != "I") {
	        		ComShowCodeMessage("PRI01037");
	        		return false;
	        	}
	            return true;
	            break;
	        case IBSEARCH_ASYNC13: // Accept
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount() <= 0) {
	        		return false;
	        	}
	        	if (formObj.prc_prop_sts_cd.value != "Q") {
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") == "A") {
					ComShowCodeMessage("PRI01037");
					return false;
	    		}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
	        		ComShowCodeMessage("PRI00313");
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
	            return true;
	            break;
	        case IBSEARCH_ASYNC14: // Accept Cancel
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            }
	        	if (sheetObj.RowCount() <= 0) {
	        		return false;
	        	}
	        	if (!bIsAproUsr || formObj.prc_prop_sts_cd.value != "Q") {
	        		return false;
	        	}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "prc_prog_sts_cd") != "A") {
					ComShowCodeMessage("PRI01038");
					return false;
	    		}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value){
					ComShowCodeMessage("PRI00313");
					return false;
				}
	        	if (sheetObj.GetCellValue(sheetObj.GetSelectRow(), "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
					ComShowCodeMessage("PRI00313");
					return false;
				}
	            return true;
	            break;
	        case IBSEARCH: // retrieving
	        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
	                return false;
	            } else {
	                return true;
	            }
	            break;
	        case IBSAVE: // Saving
	            if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
	                return false;
	            }
	            return true;
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
	 * SEtting style after retrieving<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} idx selection ,handling selected row.If not selected, handling all data
	 * @author 
	 * @version 2009.05.01
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
	 * Enable/Diable to each column or all row's column after retrieving<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {ibsheet} sheetObj mandatory IBSheet Object
	 * @param {int} idx selection ,handling selected row.If not selected, handling all data
	 * @author 
	 * @version 2009.05.01
	 */
    function setLineEnable(sheetObj, idx) {
    	if (idx <= 0) {
    		return false;
    	}
    	if (sheetObj.GetCellValue(idx, "n1st_cmnc_amdt_seq") == document.form.amdt_seq.value
    		&& document.form.prc_prop_sts_cd.value == "I"
    			&& sheetObj.GetCellValue(idx, "prc_prog_sts_cd") == "I"
    				&& sheetObj.GetCellValue(idx, "src_info_cd") != "AM"
    					&& sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
    		// When Amendment, Modify the flag to opposite status, fixed it Readonly. 2009-07-02.
    		sheetObj.SetCellEditable(idx, "dir_call_flg",1);
		} else {
        	sheetObj.SetCellEditable(idx, "dir_call_flg",0);
		}
    }
