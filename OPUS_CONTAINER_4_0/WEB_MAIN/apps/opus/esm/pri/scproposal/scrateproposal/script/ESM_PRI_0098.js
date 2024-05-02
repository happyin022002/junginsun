/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0098.js
*@FileTitle  : S/C Proposal General/Special Rate - Route Note Inquiry
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
     * @class Commodity Group : business script for Commodity Group 
     */
	// global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
    var bIsReqUsr=false;
    var bIsAproUsr=false;
    var exTransaction=false;
    var sChgCdVisiable="";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	
//다음의 화면들에서 호출됨
//ESM_PRI_0004_09
	
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
	 * adding case as numbers of counting sheets <br>
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
		        var HeadTitle="|Seq.|prop_no|amdt_seq|svc_scp_cd|gen_spcl_rt_tp_cd|cmdt_hdr_seq|rout_seq|rout_note_seq|Item|Surcharge|Content|Conversion|Conversion|Conversion|note_chg_tp_cd|EFF Date|EXP Date|Source Code|Source|Status Code|Status|n1st_cmnc_amdt_seq|Accept Staff/Team|Accept Date|Accept User|ord";
		        var headCount=ComCountHeadTitle(HeadTitle);
	
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
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"rout_note_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"note_clss_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Combo", 	  Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:"chg_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:240,  Align:"Left",    ColMerge:0,   SaveName:"note_ctnt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"CheckBox",  Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_chk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
			               {Type:"Popup",     Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"note_conv_mapg_id_pop",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"note_chg_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"src_info_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"src_info_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"prc_prog_sts_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"n1st_cmnc_amdt_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"acpt_usr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"acpt_dt",                KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"acpt_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			               {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"n1st_ord_ref",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		        InitColumns(cols);
		        SetEditable(1);
		        SetShowButtonImage(2);
		        //SetAutoRowHeight(0);
		        resizeSheet(); //SetSheetHeight(450);
			}
			break;
		}
	}
	
	function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
	
	/**
	 * calling function when occurring OnClick Event <br>
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
	 * Handling sheet process <br>
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
        try {
            if (window.event == null || ComGetEvent() == null || $(ComGetEvent()).attr('suppressWait') != "Y") {
                ComOpenWait(true);
            }
			sheetObj.ShowDebugMsg(false);
			switch (sAction) {
			case IBCLEAR: 
	            // Item
	            formObj.f_cmd.value=SEARCH19;
	            sXml=sheetObj.GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD01711");
	            setIBCombo(sheetObj, sXml, "note_clss_cd", true, 0);
				break;
			case IBSEARCH: // retrieving from parent sheet 
	            if (!validateForm(sheetObj,document.form,sAction)) {
	                return false;
	            }
	            // inputting manually in case of surcharge code not in scope
	            var arrSurcharge=opener.getSurchargeList(11);
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
						sCd += "|" + arrSurcharge[i];
						sNm += "|" + arrSurcharge[i];
					}
				}
//				sheetObj.SetColProperty("chg_cd", {ComboText:sNm ,sCd, ComboCode:""} );
				sheetObj.InitDataCombo(0, "chg_cd", sNm, sCd, "", "", 0, "", "", sChgCdVisiable);
				var sXml=opener.getSheetXml(11);
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
	 * checking validation process of inputed form data <br>
	 */
    function validateForm(sheetObj, formObj, sAction) {
        switch (sAction) {
        case IBSEARCH: // retrieve
        	if (formObj.prop_no.value == "" || formObj.amdt_seq.value == "" || formObj.svc_scp_cd.value == "") {
                return false;
            } else {
                return true;
            }
            break;
        }
    }
	/**
	 * setting style function, after retrieving<br>
	 */
    function setSheetStyle(sheetObj, idx) {
    	opener = window.dialogArguments;
    	if (!opener) opener = parent;
        if (idx == null || idx < 0) {
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
            	opener.setLineStyle(sheetObj, i);
            }
        } else {
        	opener.setLineStyle(sheetObj, idx);
        }
    }
	/**
	 * getting Sheet Data in XML type <br>
	 */
    function getSheetXml(sheetNo) {
    	var sXml=ComPriSheet2Xml(sheetObjects[sheetNo]);
        return sXml;
    }
    
    function SheetObject(sheet, row, col){
 		this.sheet = sheet;
 		this.row = row;
 		this.col = col;
 	}
 	var _tmp_sheetObject;
 	
	/**
	 * calling function when occurring OnPopupClick Event <br>
	 */
	function sheet1_OnPopupClick(sheetObj, Row, Col) {
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		 _tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
		if (colName == "note_conv_mapg_id_pop") {	
			if(!ComIsNull(sheetObj.GetCellValue(Row, "note_conv_mapg_id")))	{
				if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "note_clss_cd") == "D") {
					//var sUrl = "/opuscntr/EES_DMT_2001.do?" + FormQueryString(document.form);
		            //sUrl += "&note_clss_cd=" + sheetObj.CellValue(Row, "note_clss_cd");
		            //var rtnVal = ComOpenWindowCenter(sUrl, "ESM_PRI_2001", 1010, 700, true);
		            var sUrl="/opuscntr/EES_DMT_2001.do?" + FormQueryString(document.form);
		            sUrl += "&note_clss_cd=" + sheetObj.GetCellValue(Row, "note_clss_cd") + "&caller=2007";
		            ComOpenPopup(sUrl, 1280, 800, "findCustomer", "1,0,1,1,1,1,1", true);
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
					var sUrl="/opuscntr/ESM_PRI_0052.do?"+sParam;			
					ComOpenPopup(sUrl, 1050, 590, "ESM_PRI_0052_returnVal", "1,0", false);
					
				}
			} else {
				ComShowCodeMessage("PRI08015");
			}
		}
	}

	function ESM_PRI_0052_returnVal(rtnVal) {
		if (rtnVal != null) {
			// using FOR because selected row can change on conversion screen
			for(var i=_tmp_sheetObject.sheet.HeaderRows(); i <= _tmp_sheetObject.sheet.LastRow(); i++) {
				if(_tmp_sheetObject.sheet.GetCellValue(i, "rout_seq") == rtnVal.master_seq
						&& _tmp_sheetObject.sheet.GetCellValue(i, "rout_note_seq") == rtnVal.detail_seq
						&& _tmp_sheetObject.sheet.GetCellValue(i, "amdt_seq") == rtnVal.amdt_seq ) {
					
					_tmp_sheetObject.sheet.SetCellValue(i, "note_conv_mapg_id_chk", rtnVal.note_conv_flg);
					_tmp_sheetObject.sheet.SetCellValue(i, "note_chg_tp_cd", rtnVal.note_chg_tp_cd);
					
				}
			}
		}
	}