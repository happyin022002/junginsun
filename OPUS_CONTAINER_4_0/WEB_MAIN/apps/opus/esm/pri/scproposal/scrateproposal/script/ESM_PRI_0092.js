/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0092.js
*@FileTitle  : S/C Proposal General/Special Rate - Commodity Note Inquiry
*@author     : CLT
*@version    : 1.0
=========================================================*/
/****************************************************************************************
  Event code: [Initial]INIT=0; [ADD]ADD=1; [SEARCH]SEARCH=2; [SEARCHLIST]SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					Other extra variable  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Commodity Group :business script for Commodity Group 
     */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var sChgCdVisiable="";
    var opener;
    
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	
//다음의 화면들에서 호출됨
//ESM_PRI_0004_09
	
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
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
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
	       
	      var HeadTitle="|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|cmdt_note_seq|Item|Surcharge|Content|Conversion|Conversion|Conversion|note_chg_tp_cd|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept Staff/Team|Accept Date|Accept User|ord";
	      var headCount=ComCountHeadTitle(HeadTitle);
	      (headCount, 0, 0, true);

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_note_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo", 	Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
	             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_pop",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
		      InitColumns(cols);
	
		      SetEditable(1);
		      SetShowButtonImage(2);
		      //SetAutoRowHeight(0);
		      resizeSheet(); //SetSheetHeight(124);
	      }
			break;
		}
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
	
	/**
	 * Calling function in case of Onclick event <br>
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
	function sheet1_OnClick(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "note_ctnt") {
			//ComShowMemoPad(sheetObj, Row, Col, true, sheetObj.GetColWidth(Col), parseInt(sheetObj.GetDataRowHeight()) * 4);
			var memoColWidth =	sheetObj.GetColWidth("note_ctnt") +
								sheetObj.GetColWidth("note_ctnt_pop") +
								sheetObj.GetColWidth("note_conv_mapg_id_chk") +
								sheetObj.GetColWidth("note_conv_mapg_id_pop") +
								sheetObj.GetColWidth("eff_dt") +
								sheetObj.GetColWidth("exp_dt") +
								sheetObj.GetColWidth("src_info_nm") +
								sheetObj.GetColWidth("prc_prog_sts_nm") +
								sheetObj.GetColWidth("acpt_dt");
			ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 6);
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
	 * @version 2009.05.01
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || ComGetEvent() == null || $(ComGetEvent()).attr('suppressWait') != "Y") {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg(false);
			switch (sAction) { 
			case IBCLEAR: // Retrieving when loading
	            // Item
	            formObj.f_cmd.value=SEARCH19;
 	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01711");
	            setIBCombo(sheetObj, sXml, "note_clss_cd", true, 0);
				break;
			case IBSEARCH: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
//	            opener = window.dialogArguments;
//	            if (!opener) opener = parent;
	            // Inputting manually in case of not existing surcharge in Scope
	            var arrSurcharge=opener.getSurchargeList(5);
				var sCd=" |";
				var sNm=" |";
				formObj.f_cmd.value=COMMAND12;
 				sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
				var arrData=ComPriXml2ComboString(sXml, "cd", "cd");
				if (arrData != null && arrData.length > 1) {
					sCd += arrData[0];
					sNm += arrData[1];
				}
				sChgCdVisiable=sNm;
				for (var i=0; arrSurcharge != null && i < arrSurcharge.length; i++) {
					if (sCd.indexOf(arrSurcharge[i]) < 0) {
						sCd += " |" + arrSurcharge[i];
						sNm += " |" + arrSurcharge[i];
					}
				}
				sheetObj.InitDataCombo(0, "chg_cd", sNm, sCd, "", "", 0, "", "", sChgCdVisiable);
				//sheetObj.SetColProperty("chg_cd", {ComboText:sNm ,sCd, ComboCode:"",""} );
//				 opener = window.dialogArguments;
//				 if (!opener) opener = parent;
				var sXml=opener.getSheetXml(5);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				//sheetObj.ColumnSort("n1st_ord_ref|amdt_seq", "ASC", "ASC|ASC", true);
				//setSheetStyle(sheetObj, -1);
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
        switch (sAction) {
        case IBSEARCH: // retrieving
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
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
            }
        } else {
        	opener.setLineStyle(sheetObj, idx);
        }
    }
	/**
	 * Getting Sheet Data as XML format<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {int} sheetNo sheet no
	 * @author 
	 * @version 2009.05.01
	 */
    function getSheetXml(sheetNo) {
    	var sArr=new Array;
    	sArr[0]=opener.getSheetXml(0);
    	sArr[1]=ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sArr;
    }
    
    function tmp_object(sheet, row, col){
		this.sheet = sheet;
		this.row = row;
		this.col = col;
	}
	var G_TMP_OBJECT;
	
	/**
	 * Calling function in case of OnPopupClick event<br>
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
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		G_TMP_OBJECT = new tmp_object(sheetObj, Row, Col);
		if (colName == "note_conv_mapg_id_pop") {	
			if(!ComIsNull(sheetObj.GetCellValue(Row, "note_conv_mapg_id")))	{
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "D") {
					//var sUrl = "/opuscntr/EES_DMT_2001.do?" + FormQueryString(document.form);
		            //sUrl += "&note_clss_cd=" + sheetObj.CellValue(Row, "note_clss_cd");
		            //var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_2001", 1010, 700, true);
		            var sUrl="/opuscntr/EES_DMT_2001.do?" + FormQueryString(document.form);
		            sUrl += "&note_clss_cd=" + sheetObj.GetCellValue(Row, "note_clss_cd") + "&caller=2007";
		            ComOpenPopup(sUrl, 1280, 800, "findCustomer", "1,0,1,1,1,1,1", false);
				} else {
					var sParam="";
					sParam += "svc_scp_cd=" + formObj.svc_scp_cd.value;
					sParam += "&prop_no=" + formObj.prop_no.value;
					sParam += "&amdt_seq=" + formObj.amdt_seq.value;
					sParam += "&note_conv_mapg_id=" + encodeURIComponent(sheetObj.GetCellValue(Row, "note_conv_mapg_id"));
					sParam += "&cmdt_hdr_seq=" + sheetObj.GetCellValue( Row, "cmdt_hdr_seq");
					sParam += "&cmdt_note_seq=" + sheetObj.GetCellValue( Row, "cmdt_note_seq");
					sParam += "&gen_spcl_rt_tp_cd=" + sheetObj.GetCellValue( Row, "gen_spcl_rt_tp_cd");
					sParam += "&eff_dt=" + sheetObj.GetCellValue( Row, "eff_dt");
					sParam += "&exp_dt=" + sheetObj.GetCellValue( Row, "exp_dt");
					sParam += "&master_seq=" + opener.sheetObjects[0].GetSelectRow();
					sParam += "&detail_seq=" + sheetObjects[0].GetSelectRow();
					var sUrl="/opuscntr/ESM_PRI_0054.do?"+sParam;			
					ComOpenPopup(sUrl, 1000, 675, "note_conv_mapg_id_pop_returnVal", "1,0", false);
					
				}
			} else {
				ComShowCodeMessage("PRI08015");
			}
		}
	}
	
	function note_conv_mapg_id_pop_returnVal(rtnVal) {
		if (rtnVal != null) {
			//Using "for" because possible to modify the selected row on CONVERSION scrreen
			for(var i=G_TMP_OBJECT.sheet.HeaderRows(); i <= G_TMP_OBJECT.sheet.LastRow(); i++) {
				if(G_TMP_OBJECT.sheet.GetCellValue(i, "cmdt_hdr_seq") == rtnVal.master_seq
						&& G_TMP_OBJECT.sheet.GetCellValue(i, "cmdt_note_seq") == rtnVal.detail_seq
						&& G_TMP_OBJECT.sheet.GetCellValue(i, "amdt_seq") == rtnVal.amdt_seq ) {
					G_TMP_OBJECT.sheet.SetCellValue(i, "note_conv_mapg_id_chk",rtnVal.note_conv_flg,0);
					G_TMP_OBJECT.sheet.SetCellValue(i, "note_chg_tp_cd",rtnVal.note_chg_tp_cd,0);
				}
			}
		}
	}
