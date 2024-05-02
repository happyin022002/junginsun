/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESM_PRI_0097.js
 *@FileTitle: Route Note Creation
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/25/08
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
//    function ESM_PRI_0097() {
//    	this.processButtonClick=tprocessButtonClick;
//    	this.setSheetObject=setSheetObject;
//    	this.loadPage=loadPage;
//    	this.initSheet=initSheet;
//    	this.initControl=initControl;
//    	this.doActionIBSheet=doActionIBSheet;
//    	this.setTabObject=setTabObject;
//    	this.validateForm=validateForm;
//    }
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var sChgCdVisiable="";
    var amendSaveFlag=false;
    var isCnoteModify=false; //2015.06.25
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
			case "btn_add":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
			case "btn_rowcopy":
				doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
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

				} else {
					ComClosePopup(); 
				}

				break;
			case "btn_close":
// 2015-03-30 CHLOE : close 버튼에 왜 로직을 넣어놨는지 미스테리임							
//				if (formObject.prc_prop_sts_cd.value == "Q") {
//					doActionIBSheet(sheetObject1, document.form, IBSAVE);
//				} else {
//					ComClosePopup(); 
//				}
				
				//2015.6.25
	            if(sheetObj.IsDataModified() && isCnoteModify) {
					if (!ComShowCodeMessage("PRI01140")) {
		            	return false;
		            }
				}
				
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
        	enableButton("btn_rowcopy");
        	enableButton("btn_delete");
        	enableButton("btn_amend");
        	enableButton("btn_amendcancel");
    	} else {
    		disableButton("btn_add");
    		disableButton("btn_rowcopy");
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
			with (sheetObj) {
            
	            if (location.hostname != "")
	            var HeadTitle="|Sel.|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|rout_note_seq|Item|Surcharge|Content|Content|Conversion|Conversion|Conversion|note_chg_tp_cd|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept User|ord|prev_note_conv_mapg_id";
	            var headCount=ComCountHeadTitle(HeadTitle);
	//            (headCount, 0, 0, true);
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, ComboMaxHeight:100 } );
	
	            var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
	            var headers = [ { Text:HeadTitle, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prop_no",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"amdt_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"gen_spcl_rt_tp_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cmdt_hdr_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Combo", 	Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:255,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"note_ctnt_pop",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"CheckBox",  Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, HeaderCheck:0,   EditLen:-1 },
	             {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_pop",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prev_note_conv_mapg_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	             
	            InitColumns(cols);
	            SetEditable(1);
//	            SetSheetHeight(124);
	            SetShowButtonImage(2);
	            //SetAutoRowHeight(0);
	            resizeSheet();
			}
			break;
		}
	}
	
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
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
    //no support[implemented common]CLT 	changeSelectBackColor4Rate(sheetObj);
    }
	/**
	 * Calling Function in case of OnChange event <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj Mandatory IBSheet Combo Object
	 * @param {int} code Mandatory Onclick 
	 * @param {int} text Mandatory 
	 * @return void
	 * @author 
	 * @version 2009.05.01
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		if (colName == "note_clss_cd") {
			if (Value == "S") {
				sheetObj.SetCellEditable(Row, "chg_cd",1);
			} else {
				sheetObj.SetCellEditable(Row, "chg_cd",0);
				sheetObj.SetCellValue(Row, "chg_cd","",0);
			}
		} else if (colName == "chg_cd") {
			if (Value != null && Value != "" && Value.length == 3) {
				var sCode=sheetObj.GetComboInfo(0, "chg_cd", "Code");
				var sText=sheetObj.GetComboInfo(0, "chg_cd", "Code");
				if (sCode.indexOf(Value) < 0) {
					formObj.f_cmd.value=COMMAND09;
 					sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
					var arrData=ComPriXml2Array(sXml, "cd|nm");
					if (arrData != null && arrData.length > 0) {
						sCode += "|" + Value;
						sText += "|" + Value;
//						sheetObj.SetColProperty(0,"chg_cd", {ComboText:sText ,sCode, ComboCode:"",""} );
						sheetObj.InitDataCombo(0, "chg_cd", sText, sCode, "", "", 0, "", "", sChgCdVisiable);
						ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
					} else {
						sheetObj.SetCellValue(Row, "chg_cd","",0);
					}
				}
			} else {
				sheetObj.SetCellValue(Row, "chg_cd","",0);
			}
		}
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
			var memoColWidth =	sheetObj.GetColWidth("note_ctnt") +
								sheetObj.GetColWidth("note_ctnt_pop") +
								sheetObj.GetColWidth("note_conv_mapg_id_chk") +
								sheetObj.GetColWidth("note_conv_mapg_id_pop") +
								sheetObj.GetColWidth("eff_dt") +
								sheetObj.GetColWidth("exp_dt") +
								sheetObj.GetColWidth("src_info_nm");
			if (sheetObj.GetCellEditable(Row, "note_clss_cd")) {
                ComShowMemoPad(sheetObj, Row, Col, false, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 6);
			} else {
				ComShowMemoPad(sheetObj, Row, Col, true, memoColWidth, parseInt(sheetObj.GetDataRowHeight()) * 6);
			}
		} else if (colName == "note_conv_mapg_id_pop") {
			if (!sheetObj.GetEditable()) {
				sheet1_OnPopupClick(sheetObj, Row, Col);
			}
		}
	}
	
	function tmp_object(sheet, row){
		this.row = row;
		this.sheet = sheet;
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
	var popupColName = "";
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		popupColName=colName;
		G_TMP_OBJECT = new tmp_object(sheetObj, Row);
		if (colName == "note_ctnt_pop") {
			if (sheetObj.GetCellValue(Row, "note_clss_cd") == "") {
				return false;
			}
			if (sheetObj.GetCellEditable(Row, "note_clss_cd")) {
	            var sUrl="ESM_PRI_0089.do?" + FormQueryString(document.form);
	            sUrl += "&note_clss_cd=" + sheetObj.GetCellValue(Row, "note_clss_cd");
	            sUrl += "&chg_cd=" + sheetObj.GetCellValue(Row, "chg_cd");
	            ComOpenPopup(sUrl, 600, 430, "sheet1_returnValue", "1,0,1,1,1,1,1", false);
			}
		}
		if (colName == "note_conv_mapg_id_pop") {	
			var sXml=opener.getSheetXml(11);
		    var arrData=ComPriXml2Array(sXml, "ibflag");
		    if (arrData != null && arrData.length > 0) {
		    	for(var i=0; i<arrData.length; i++){
					if(arrData[i][0] != "R" && formObj.amdt_seq.value != "0") {
						return false
					}
				}
		    }
			if((amendSaveFlag && sheetObj.IsDataModified())) {
				return false;
			}
			if(!ComIsNull(sheetObj.GetCellValue(Row, "note_conv_mapg_id")))	{
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "D") {
		            ComOpenPopup("EES_DMT_2001.do?prop_no=" + formObj.prop_no.value + "&caller=0097",  1280, 800,  'sheet1_returnValue', '1,0', false);
				} else {
					var sParam="";
					sParam += "svc_scp_cd=" + formObj.svc_scp_cd.value;
					sParam += "&prop_no=" + formObj.prop_no.value;
					sParam += "&amdt_seq=" + formObj.amdt_seq.value;
					sParam += "&note_conv_mapg_id=" + encodeURIComponent(sheetObj.GetCellValue(Row, "note_conv_mapg_id"));
					sParam += "&rout_seq=" + sheetObj.GetCellValue( Row, "rout_seq");
					sParam += "&rout_note_seq=" + sheetObj.GetCellValue( Row, "rout_note_seq");
					sParam += "&note_tp_cd=" + sheetObj.GetCellValue( Row, "gen_spcl_rt_tp_cd");
					sParam += "&eff_dt=" + sheetObj.GetCellValue( Row, "eff_dt");
					sParam += "&exp_dt=" + sheetObj.GetCellValue( Row, "exp_dt");
					sParam += "&master_seq=" + sheetObjects[0].GetSelectRow();
					sParam += "&prop_sts_cd=" +  formObj.prc_prop_sts_cd.value;
					var sUrl="ESM_PRI_0033.do?"+sParam;			
					ComOpenPopup(sUrl, 900, 570, 'sheet1_returnValue', '0,1,1,1,1,1,1', false);
				}
			} else {
				ComShowCodeMessage("PRI08015");
			}
		}
	}
	
	function sheet1_returnValue(rtnVal) {
		var sheetObj = G_TMP_OBJECT.sheet;
		if (popupColName == "note_ctnt_pop") {
			 if (rtnVal != null) {
	         	if (rtnVal.ctnt != null && rtnVal.ctnt != "" && rtnVal.ctnt != undefined) {
	         		sheetObj.SetCellValue(G_TMP_OBJECT.row, "note_ctnt",rtnVal.ctnt,0);
	         	}
	         	if (rtnVal.chgcd != null && rtnVal.chgcd != "" && rtnVal.chgcd != undefined) {
	         		sheetObj.SetCellValue(G_TMP_OBJECT.row, "chg_cd",rtnVal.chgcd,0);
	         	}
	         }
		}
		if (popupColName == "note_conv_mapg_id_pop") {
			if(rtnVal != null && rtnVal.length > 0) {
				for(var i=0; i < rtnVal.length; i++) {
					for(var j=sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
						if(sheetObj.GetCellValue(j, "rout_seq") == rtnVal[i].master_seq
								&& sheetObj.GetCellValue(j, "rout_note_seq") == rtnVal[i].detail_seq
								&& sheetObj.GetCellValue(j, "amdt_seq") == rtnVal[i].amdt_seq ) {
							//sheet1.GetRowStatus(j) : status는 그대로 가져가야 한다
							sheetObj.SetCellValue(j, "note_conv_mapg_id_chk",rtnVal[i].note_conv_flg,1);
							sheetObj.SetCellValue(j, "note_chg_tp_cd",rtnVal[i].note_chg_tp_cd,1);
							sheetObj.SetCellValue(j, "note_ctnt",rtnVal[i].cnote,1);

						}
					}
				}
				isCnoteModify = true;

			}
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
//	        if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
	    	if(window.event == null || ComGetEvent()==null || $(ComGetEvent()).attr('suppressWait') != "Y")
	    		{
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
	        	sheetObj.SetCellValue(idx - 1, "note_conv_mapg_id",sheetObj.GetCellValue(idx - 1, "prev_note_conv_mapg_id"),0);
	        	sheetObj.SetRowStatus(idx - 1,"R");
	        	setSheetStyle(sheetObj, idx - 1);
	        	setSheetStyle(sheetObj, idx);
	        	amendSaveFlag=true;     
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
	        	amendSaveFlag=true;
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
 	            var sXml=sheetObj.GetSaveData("ESM_PRI_0097GS.do", sParam);
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
 	            var sXml=sheetObj.GetSaveData("ESM_PRI_0097GS.do", sParam);
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
	            
	        	/*
	            for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
						if (sheetObj.GetCellValue(i, "n1st_ord_ref") == "") {
	            		var n1stOrdRef;
						if (sheetObj.GetCellValue(i, "note_clss_cd") == "G") {
	            			n1stOrdRef=1;
						} else if (sheetObj.GetCellValue(i, "note_clss_cd") == "S") {
	            			n1stOrdRef=2;
						} else if (sheetObj.GetCellValue(i, "note_clss_cd") == "D") {
	            			n1stOrdRef=3;
						} else if (sheetObj.GetCellValue(i, "note_clss_cd") == "O") {
	            			n1stOrdRef=4;
	            		} else {
	            			n1stOrdRef=99;
	            		}
	                	sheetObj.SetCellValue(i, "n1st_ord_ref",n1stOrdRef,0);
	            	}
	            }
	            sheetObj.ColumnSort("amdt_seq|n1st_ord_ref|amdt_seq", "ASC", "DESC|ASC|ASC", true);
	            */
	            
	            //2015.06.25
	            var isModify = sheetObj.IsDataModified();
	            sheetObj.ColumnSort("rout_note_seq|amdt_seq", "ASC", "ASC|ASC", true);
				var sXml=ComPriSheet2Xml(sheetObj);
				opener.setSheetXml(sXml, 11);
				ComPopUpReturnValue("O");
				if (exTransaction) {
					opener.restylingPagePostTr();
				}
				
				//2015.06.22
				if(isModify) {
					opener.doSaveRouteNote();
				}
				
	            break; 
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
	            // Inputting manually in case of not existing surcharge in Scope
	            var arrSurcharge=opener.getSurchargeList(11);
	            
				var sCd=" |";
				var sNm=" |";
				formObj.f_cmd.value=COMMAND12;
 				sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + formObj.svc_scp_cd.value);
				var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
				if (arrData != null) {
				    var arrCode=arrData[0].split("|");
				    var arrName=arrData[1].split("|");
				    var conData="";
				    for (var i=0; i < arrName.length; i++) {
				        if (i == 0) {
				            arrName[i]=arrCode[i] + "\t" + arrName[i];
				        } else {
				            arrName[i]="|" + arrCode[i] + "\t" + arrName[i];
				        }
				        conData=conData.concat(arrName[i]);
				    }
				    arrData[1]=conData;
				}
				if (arrData != null && arrData.length > 1) {
					sCd += arrData[0];
					sNm += arrData[1];
				}
				sChgCdVisiable=sNm;
				for (var i=0; arrSurcharge != null && i < arrSurcharge.length; i++) {
					if (sCd.indexOf(arrSurcharge[i]) < 0) {
						sCd += "|" + arrSurcharge[i];
						sNm += "|" + arrSurcharge[i];
					}
				}
//				sheetObj.SetColProperty("chg_cd", {ComboText:sNm ,sCd, ComboCode:"",""} );
				sheetObj.InitDataCombo(0, "chg_cd", sNm, sCd, "", "", 0, "", "", sChgCdVisiable);
				var sXml=opener.getSheetXml(11);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				//sheetObj.ColumnSort("n1st_ord_ref|rout_note_seq|amdt_seq", "ASC", "ASC|ASC|ASC", true);
				sheetObj.ColumnSort("rout_note_seq|amdt_seq", "ASC", "ASC|ASC", true);
				setSheetStyle(sheetObj, -1);
	         	break; 	
			case IBINSERT:
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=COMMAND38;
 	            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	            if (sysGuid == null || sysGuid.length < 16) {
	            	return false;
	            }
	        	var rowCnt = sheetObj.RowCount();
				var idx=sheetObj.DataInsert(rowCnt+1);
	            sheetObj.SetCellValue(idx, "prop_no",formObj.prop_no.value);
	            sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "svc_scp_cd",formObj.svc_scp_cd.value);
	            sheetObj.SetCellValue(idx, "gen_spcl_rt_tp_cd",formObj.gen_spcl_rt_tp_cd.value);
	            sheetObj.SetCellValue(idx, "cmdt_hdr_seq",formObj.cmdt_hdr_seq.value);
	            sheetObj.SetCellValue(idx, "rout_seq",formObj.rout_seq.value);
	            sheetObj.SetCellValue(idx, "rout_note_seq",parseInt(ComPriGetMax(sheetObj, "rout_note_seq"))+ 1);
	            sheetObj.SetCellValue(idx, "note_conv_mapg_id",sysGuid);
	            sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	            sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	            sheetObj.SetCellValue(idx, "src_info_cd","NW");
	            sheetObj.SetCellValue(idx, "src_info_nm","New");
	            sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	            sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	            sheetObj.SelectCell(idx, "note_clss_cd", false);
	            setSheetStyle(sheetObj, idx);
				break;
			case IBCOPYROW: 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            formObj.f_cmd.value=COMMAND38;
	            var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
	            var sysGuid=ComGetEtcData(sXml, "SYS_GUID");
	            if (sysGuid == null || sysGuid.length < 16) {
	            	return false;
	            }
		        var idx=sheetObj.DataCopy();
	            sheetObj.SetCellValue(idx, "rout_note_seq",parseInt(ComPriGetMax(sheetObj, "rout_note_seq"))+ 1);
	            sheetObj.SetCellValue(idx, "note_conv_mapg_id",sysGuid);
	            sheetObj.SetCellValue(idx, "prc_prog_sts_cd","I");
	            sheetObj.SetCellValue(idx, "prc_prog_sts_nm","Initial");
	            sheetObj.SetCellValue(idx, "src_info_cd","NW");
	            sheetObj.SetCellValue(idx, "src_info_nm","New");
	            sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value);
	            sheetObj.SetCellValue(idx, "n1st_cmnc_amdt_seq",formObj.amdt_seq.value);
	            sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value);
	            setSheetStyle(sheetObj, idx);
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
	        	for (var i=arrCheckedRows.length - 1; i >= 0; i--) {
	        		if (sheetObj.GetCellValue(arrCheckedRows[i], "n1st_cmnc_amdt_seq") != formObj.amdt_seq.value) {
	            		sheetObj.SetSelectRow(arrCheckedRows[i]);
	               		sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","0",0);
	               		var idx=opener.doRowAmend(sheetObj, "AD");
	                	setSheetStyle(sheetObj, idx - 1);
	                	setSheetStyle(sheetObj, idx);
	                	amendSaveFlag=true;
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
        	if (opener.isRouteGroupDeleted()) {
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
        	if (opener.isRouteGroupDeleted()) {
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
        		arrCheckedRows=sCheckedRows.split("|");
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
        		arrCheckedRows=sCheckedRows.split("|");
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
            var checkDMT=false;
            for (var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
            	if (sheetObj.GetRowStatus(i) == "D" || sheetObj.GetCellValue(i, "src_info_cd") == "AD"
            		|| sheetObj.GetCellValue(i, "amdt_seq") != formObj.amdt_seq.value) {
            		continue;
            	}
            	if (sheetObj.GetCellValue(i, "note_clss_cd") == "S" && sheetObj.GetCellValue(i, "chg_cd") == "") {
    				ComShowCodeMessage("PRI00316", "Surcharge");
    				sheetObj.SelectCell(i, "chg_cd");
    				return false;
            	}
            	if (sheetObj.GetCellValue(i, "note_clss_cd") == "D") {
            		checkDMT=true;
            	}
            }
            if (checkDMT) {
                formObj.f_cmd.value=COMMAND39;
                 var sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj));
                var propNoCount=ComGetEtcData(sXml, "PROP_NO_COUNT");
                if (parseInt(propNoCount) <= 0) {
    				ComShowCodeMessage("PRI01090");
    				return false;
                }
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
        	if (opener.isRouteGroupDeleted()) {
        		return false;
        	}
        	if (sheetObj.RowCount()> 0 && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "amdt_seq") != formObj.amdt_seq.value) {
        		ComShowCodeMessage("PRI00313");
        		return false;
        	}
            return true;
            break;
        case IBCOPYROW: // Row Copy
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            }
        	if (formObj.prc_prop_sts_cd.value != "I") {
        		return false;
        	}
        	if (opener.isRouteGroupDeleted()) {
        		return false;
        	}
        	if (sheetObj.RowCount()<= 0 || sheetObj.GetSelectRow()<= 0) {
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
        	if (opener.isRouteGroupDeleted()) {
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
				if (sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "NW"
					&& sheetObj.GetCellValue(arrCheckedRows[i], "src_info_cd") != "GC"
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
    				&& sheetObj.GetCellValue(idx, "src_info_cd") != "AD") {
	        	sheetObj.SetCellEditable(idx, "note_clss_cd",1);
	        	if (sheetObj.GetCellValue(idx, "note_clss_cd") == "S") {
	        		sheetObj.SetCellEditable(idx, "chg_cd",1);
	        	} else {
	        		sheetObj.SetCellEditable(idx, "chg_cd",0);
	        	}
	        	sheetObj.SetCellEditable(idx, "note_conv_mapg_id",1);
	        	//sheetObj.CellEditable(idx, "note_conv_mapg_id_pop") = true;
	        	sheetObj.SetCellEditable(idx, "note_chg_tp_cd",1);
	        	sheetObj.SetColBackColor("note_ctnt",sheetObj.GetEditableColor());
		} else {
        	sheetObj.SetCellEditable(idx, "note_clss_cd",0);
        	sheetObj.SetCellEditable(idx, "chg_cd",0);
        	sheetObj.SetCellEditable(idx, "note_conv_mapg_id",0);
        	//sheetObj.CellEditable(idx, "note_conv_mapg_id_pop") = false;
        	sheetObj.SetCellEditable(idx, "note_chg_tp_cd",0);
        //no support[check again]CLT 	sheetObj.ColBackColor("note_ctnt")=sheetObj.UnEditableColor;
		}
//    	if (sheetObj.CellValue(idx, "amdt_seq") == document.form.amdt_seq.value) {
//    		sheetObj.CellEditable(idx, "note_conv_mapg_id_pop") = true;
//    	} else {
//    		sheetObj.CellEditable(idx, "note_conv_mapg_id_pop") = false;
//    	}
    	sheetObj.SetCellEditable(idx, "note_conv_mapg_id_pop",1);
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
    	var sXml=ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sXml;
    }
