/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3002.js
*@FileTitle  : TRI Creation &amp; Amendment - Note Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
/****************************************************************************************
Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_PRI_3002 : business script for ESM_PRI_3002   
 */
var sheetObjects=new Array();
var sheetCnt=0;
var sChgCdVisiable="";
// Note Conversion type Code
var NOTE_CONV_TP_CD="R";	//TRI RATE NOTE
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
		case "btn_copy":
			if (validateForm(sheetObject1, formObject, COMMAND01)) {
				doActionIBSheet(sheetObject1, formObject, COMMAND01);
			}
			break;
		case "btn_paste":
			if (validateForm(sheetObject1, formObject, COMMAND02)) {
				doActionIBSheet(sheetObject1, formObject, COMMAND02);
			}
			break;
		case "btn_rowadd":
			if (validateForm(sheetObject1, formObject, IBINSERT)) {
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
			}
			break;
		case "btn_rowcopy":
			if (validateForm(sheetObject1, formObject, IBCOPYROW)) {
				doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
			}
			break;
		case "btn_delete":
			if (validateForm(sheetObject1, formObject, IBDELETE)) {
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
			}
			break;
		case "btn_retrieve":
			if (validateForm(sheetObject1, formObject, IBSEARCH)) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;
		case "btn_ok":
			if (validateForm(sheetObject1, formObject, IBSAVE)) {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			}
			break;
		case "btn_close":	
			ComClosePopup(); 
			/*
			if (sheetObject1.IsDataModified()&& ComShowCodeConfirm('PRI00006')) {
				if (validateForm(sheetObject1, formObject, IBSAVE)) {
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				}
			} else {
  			ComClosePopup(); 
			}	
			*/		
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
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj=document.form;
	toggleButtons(formObj.is_editable.value);
	//toggleButtons("N");
	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
		      var HeadTitle="|Sel.|Code|Application\nEffective|Application\nExpires|Application|Cur.|Cal.|Amount|Per|Cargo\nType|IMDG\nClass" +
		      "|Pay Term|Weight\n(Ton <=)|Weight\n( > Ton)|SOC|T/S\nPort|Direct\nCall|Bar Type|S/I" +
		      "|1|2|3|4|5|6|7|8|9|10|11|12";
		      var headCount=ComCountHeadTitle(HeadTitle);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:6, DataRowMerge:1, ComboMaxHeight:150 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
		             {Type:"Combo", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_rule_def_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eff_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_dt",              KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rt_appl_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"rt_op_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"frt_rt_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_rat_ut_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_prc_cgo_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_imdg_clss_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pay_term_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_min_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Float",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"bkg_max_cgo_wgt",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bkg_soc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ts_port_def_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bkg_dir_call_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bkg_hngr_bar_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bkg_esvc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_mapg_id" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_pfx_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"amdt_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"tri_prop_no" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"trf_no" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"chg_rule_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_chg_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_rule_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_hdr_seq" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"note_conv_tp_cd" },
		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:0,   SaveName:"bkg_ts_port_tp_cd" } ];
		       
		      	InitColumns(cols);
		      	SetSheetHeight(220);
		      	SetEditable(1);
		      	SetImageList(0,"img/btns_calendar.gif");
		      	SetWaitImageVisible(0);
		      	sChgCdVisiable=chargeRuleCdComboText;
		      	SetColProperty(0 ,"chg_rule_def_cd" , {AcceptKeys:"E"});
		      	SetColProperty(0 ,"bkg_imdg_clss_cd" , {AcceptKeys:"N|[other]"});
		      	SetShowButtonImage(2);// showing pop-up image when editable
		      	SetColProperty("bkg_soc_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
				SetColProperty("bkg_dir_call_flg", {ComboText:"|Yes|No", ComboCode:"|Y|N"} );
				SetColProperty("rt_appl_tp_cd", {ComboText:rtApplTpCdComboText, ComboCode:rtApplTpCdComboValue} );
				SetColProperty("bkg_prc_cgo_tp_cd", {ComboText:bkgPrcCgoTpCdComboText, ComboCode:bkgPrcCgoTpCdComboValue} );
				SetColProperty("rt_op_cd", {ComboText:rtOpCdComboText, ComboCode:rtOpCdComboValue} );
				SetColProperty("pay_term_cd", {ComboText:payTermCdComboText, ComboCode:payTermCdComboValue} );
				SetColProperty("bkg_hngr_bar_tp_cd", {ComboText:bkgHngrBarTpCdComboText, ComboCode:bkgHngrBarTpCdComboValue} );
				SetColProperty("bkg_rat_ut_cd", {ComboText:bkgRatUtCdComboText, ComboCode:bkgRatUtCdComboValue} );
				SetColProperty("curr_cd", {ComboText:currCdComboText, ComboCode:currCdComboValue} );
				SetColProperty("chg_rule_def_cd", {ComboText:chargeRuleCdComboText, ComboCode:chargeRuleCdComboValue} );
				SetColProperty("bkg_esvc_tp_cd", {ComboText:bkgEsvcTpCdComboText, ComboCode:bkgEsvcTpCdComboValue} );
		      }
		break;
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
				// NOTE CONVERSION RULE
				var sCd=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
				var sNm=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
				// //////////////////////////////////////////////////////////////////////////////
				//formObj.f_cmd.value = SEARCH01;
				//var sXml = sheetObj.GetSearchXml("ESM_PRI_3002GS.do", FormQueryString(formObj));
				var sXml=opener.getSheetXml(6);
				var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");
				if (arrData != null && arrData.length > 0) {
					for ( var i=0; i < arrData.length; i++) {
						if (sCd.indexOf(arrData[i][0]) < 0) {
							sCd += "|" + arrData[i][0];
							sNm += "|" + arrData[i][0];
						}
					}
					sheetObj.SetColProperty(2, {ComboText:sNm , ComboCode: sCd} );
				}
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				break;
			case IBSAVE: // save    
				//formObj.f_cmd.value = MULTI01;
				//sheetObj.DoAllSave("ESM_PRI_3002GS.do", FormQueryString(formObj));
				var sXml=ComPriSheet2Xml(sheetObj);
				opener.setSheetXml(sXml, 6);		
				var obj=new Object();
				var sNoteCtnt=formObj.note_ctnt.value;
				obj.note_ctnt=(sNoteCtnt);				
				ComPopUpReturnValue(obj);
				break;
			case IBINSERT: // Row Add
				var idx=sheetObj.DataInsert();
				sheetObj.SetCellValue(idx, "exp_dt",formObj.exp_dt.value,0);
				sheetObj.SetCellValue(idx, "eff_dt",formObj.eff_dt.value,0);
				sheetObj.SetCellValue(idx, "trf_pfx_cd",formObj.trf_pfx_cd.value,0);
				sheetObj.SetCellValue(idx, "tri_prop_no",formObj.tri_prop_no.value,0);
				sheetObj.SetCellValue(idx, "trf_no",formObj.trf_no.value,0);
				sheetObj.SetCellValue(idx, "amdt_seq",formObj.amdt_seq.value,0);
				sheetObj.SetCellValue(idx, "note_conv_mapg_id",formObj.note_conv_mapg_id.value,0);
				sheetObj.SetCellValue(idx, "note_conv_tp_cd",NOTE_CONV_TP_CD,0);
				sheetObj.SetCellValue(idx, "note_conv_seq",parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1,0);
				sheetObj.SelectCell(idx, "chg_rule_def_cd", false);
				// applying when code's default value exist
				defaultColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
				// setting Editable
				disableColumnValidation(sheetObj, idx, 2, sheetObj.GetCellValue(idx, "chg_rule_def_cd"));
				break;
			case IBDELETE: // Delete
				var iCheckRow=sheetObj.FindCheckedRow("chk");
				if (iCheckRow == "") {
					sheetObj.SetCellValue(sheetObj.GetSelectRow(), "chk","1",0);
				}
				iCheckRow=sheetObj.FindCheckedRow("chk");
				if (iCheckRow != "") {
					deleteRowCheck(sheetObj, "chk");
				}
				break;
			case IBCOPYROW:
				copySheetData(sheetObj);
				break;
			case COMMAND01: //COPY
				var iCheckRow=sheetObj.FindCheckedRow("chk");
				if ((ComShowCodeConfirm("PRI00012"))) {
					if (iCheckRow != "") {
						comChangeValue(sheetObj, "ibflag", "I", "chk", "1");
					}
	  				ComOpenWait(true);
					formObj.f_cmd.value=MULTI02;
					sheetObj.DoSave("ESM_PRI_3002GS.do", FormQueryString(formObj), -1, false);
				}
				break;
			case COMMAND02: //PASTE
				if ((ComShowCodeConfirm("PRI00016"))) {
	  				ComOpenWait(true);
					// NOTE CONVERSION RULE
					var sCd=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
					var sNm=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
					// ////////////////////////////////////////////////////////////
					formObj.f_cmd.value=SEARCH02;
					var sXml=sheetObj.GetSearchData("ESM_PRI_3002GS.do", FormQueryString(formObj));
					var arrData=ComPriXml2Array(sXml, "chg_rule_def_cd");
					if (arrData != null && arrData.length > 0) {
						for ( var i=0; i < arrData.length; i++) {
							if (sCd.indexOf(arrData[i][0]) < 0) {
								sCd += "|" + arrData[i][0];
								sNm += "|" + arrData[i][0];
							}
						}
						sheetObj.SetColProperty(2, {ComboText:sNm , ComboCode:sCd} );
						// ////////////////////////////////////
						sheetObj.LoadSearchData(sXml,{Append:1 , Sync:1} );
						// setting default value after sheet loading
						var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;
						var arrRow=ComPriSheetFilterRows(sheetObj, "note_conv_seq", "0");
						if (arrRow != null && arrRow.length > 0) {
							for ( var i=0; i < arrRow.length; i++) {
								sheetObj.SetRowStatus(arrRow[i],"I");
								sheetObj.SetCellValue(arrRow[i], "note_conv_seq",maxSeq + i,0);
								sheetObj.SetCellValue(arrRow[i], "note_conv_mapg_id",formObj.note_conv_mapg_id.value,0);
								sheetObj.SetCellValue(arrRow[i], "trf_pfx_cd",formObj.trf_pfx_cd.value,0);
								sheetObj.SetCellValue(arrRow[i], "tri_prop_no",formObj.tri_prop_no.value,0);
								sheetObj.SetCellValue(arrRow[i], "trf_no",formObj.trf_no.value,0);
								sheetObj.SetCellValue(arrRow[i], "amdt_seq",formObj.amdt_seq.value,0);
								sheetObj.SetCellValue(arrRow[i], "note_conv_tp_cd",NOTE_CONV_TP_CD,0);
							}
						}
					} else {
						ComShowCodeMessage("PRI00328");
					}
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
 * checking validation process of inputed form data <br>
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSAVE:
		if(ComTrim(formObj.note_ctnt.value).length < 1) {
			ComShowCodeMessage("PRI00316", "Note");
			formObj.note_ctnt.focus();
			return false;
		}
		if (sheetObj.IsDataModified()&& sheetObj.GetSaveString() == "") {
			return false;
		}
		if (!checkDuration(sheetObj)) {
			return false;
		}
		for(var i = sheetObj.HeaderRows(); getValidRowCount(sheetObj) > 0 && i <= sheetObj.LastRow(); i++) {
			if(sheetObj.GetRowStatus(i) == "D") {
  	 			continue;
  	 		}
			if(!checkMandatoryValidation(sheetObj, i)) {
				return false;
			}
			
			var minCgoWgt = sheetObj.GetCellValue(i, "bkg_min_cgo_wgt");
			var maxCgoWgt = sheetObj.GetCellValue(i, "bkg_max_cgo_wgt");
			if(sheetObj.GetRowStatus(i) != "D" && minCgoWgt != "" && minCgoWgt > 999.999) {
				ComShowCodeMessage("PRI00336", 'Weight(Ton<=)', '999.999');
				sheetObj.SelectCell(i, "bkg_min_cgo_wgt");
				return false;
			}
			if(sheetObj.GetRowStatus(i) != "D" && maxCgoWgt != "" && maxCgoWgt > 999.999) {

				ComShowCodeMessage("PRI00336", 'Weight(<Ton)', '999.999');
				sheetObj.SelectCell(i, "bkg_max_cgo_wgt");
				return false;
			}

		}
		if (sheetObj.IsDataModified()) {
			if (!validateDupCheck(sheetObj)) {
				return false;
			}
		}
		break;
	case IBCOPYROW:
		if (!checkDuration(sheetObj)) {
			return false;
		}
		if (sheetObj.RowCount()> 0) {
			//mandatory check
			if (!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
				return false;
			}
		}
		break;
	case IBINSERT:
		if (sheetObj.RowCount()> 0) {
			//mandatory check
			if (!checkMandatoryValidation(sheetObj, sheetObj.GetSelectRow())) {
				return false;
			}
		}
		break;
	case COMMAND01:
		var iCheckRow=sheetObj.FindCheckedRow("chk");
		if (iCheckRow == "") {
			ComShowCodeMessage("PRI00327");
			return false;
		}
		break;
	case COMMAND02:
		break;
	}
	return true;
}
/**
 * checking sheet's row duplication <br>
 * in case of EFF_DT = EXP_DT only<br>
 */
function validateDupCheck(sheetObj) {
	var rowM = sheetObj.ColValueDupRows("chg_rule_def_cd|bkg_rat_ut_cd|bkg_prc_cgo_tp_cd|bkg_imdg_clss_cd"
			+ "|bkg_soc_flg|bkg_dir_call_flg|bkg_ts_port_def_cd|bkg_min_cgo_wgt" 
			+ "|bkg_max_cgo_wgt|bkg_hngr_bar_tp_cd|bkg_esvc_tp_cd", false, true);
	if (rowM != "") {
		var rowDup=rowM.replace("|", ",");
		var rowArr=rowDup.split(",");
		var dupValue="";
		var temValue="";
		var firstEffDt="";
		var firstExpDt="";
		var SecondEffDt="";
		var SecondExpDt="";
		var hrows=sheetObj.HeaderRows();
		for ( var i=0; i < rowArr.length; i++) {
			dupValue=sheetObj.GetCellValue(rowArr[i], "chg_rule_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_rat_ut_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_prc_cgo_tp_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_imdg_clss_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_soc_flg");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_dir_call_flg");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_ts_port_def_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_min_cgo_wgt");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_max_cgo_wgt");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_hngr_bar_tp_cd");
			dupValue += sheetObj.GetCellValue(rowArr[i], "bkg_esvc_tp_cd");
			for ( var j=0; j < rowArr.length; j++) {
				temValue=sheetObj.GetCellValue(rowArr[j], "chg_rule_def_cd");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_rat_ut_cd");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_prc_cgo_tp_cd");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_imdg_clss_cd");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_soc_flg");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_dir_call_flg");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_ts_port_def_cd");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_min_cgo_wgt");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_max_cgo_wgt");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_hngr_bar_tp_cd");
				temValue += sheetObj.GetCellValue(rowArr[j], "bkg_esvc_tp_cd");
				if (i != j) {
					if (dupValue == temValue) {
						firstEffDt=sheetObj.GetCellValue(rowArr[i], "eff_dt");
						firstExpDt=sheetObj.GetCellValue(rowArr[i], "exp_dt");
						SecondEffDt=sheetObj.GetCellValue(rowArr[j], "eff_dt");
						SecondExpDt=sheetObj.GetCellValue(rowArr[j], "exp_dt");
						if (firstEffDt >= SecondEffDt && firstEffDt <= SecondExpDt) {
							ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j]) + 1 - hrows);
							return false;
						}
						if (firstExpDt >= SecondEffDt && firstExpDt <= SecondExpDt) {
							ComShowCodeMessage("PRI00303", "Sheet", Number(rowArr[j]) + 1 - hrows);
							return false;
						}
					} //if
				} //if
			} //for
		} //for
	} //if
	return true;
}
/**
 * calling function when occurring OnSearchEnd Event <br>
 */
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		disableColumnValidation(sheetObj, i, 2, sheetObj.GetCellValue(i, "chg_rule_def_cd"));
	}
}
/**
 * calling function when occurring OnChange Event <br>
 * when selecting multi comboBox, showing description <br>
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colName=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	switch (colName) {
	case "chg_rule_def_cd":
		if (Value != null && Value != "" && Value.length == 3) {
			//setting default data
			defaultColumnValidation(sheetObj, Row, Col, Value);
			// setting column disable
			disableColumnValidation(sheetObj, Row, Col, Value);
			var sCode=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Code");
			var sText=sheetObj.GetComboInfo(0, "chg_rule_def_cd", "Text");
			if (sCode.indexOf(Value) < 0) {
				formObj.f_cmd.value=COMMAND09;
				sXml=sheetObjects[0].GetSearchData("PRICommonGS.do", FormQueryString(formObj) + "&etc1=" + Value);
				var arrData=ComPriXml2Array(sXml, "cd|nm");
				if (arrData != null && arrData.length > 0) {
					sCode += "|" + Value;
					sText += "|" + Value;
					sheetObj.SetColProperty("chg_rule_def_cd", {ComboText:sText , ComboCode:sCode} );
					//ComShowCodeMessage("PRI01110", formObj.svc_scp_cd.value);
				} else {
					sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
				}
			}
			insertChargeRuleType(sheetObj, Row);
		} else {
			sheetObj.SetCellValue(Row, "chg_rule_def_cd","",0);
		}
		// Rule & Charge Code color classification
		//setChargeRuleColor(sheetObj, Row);
		break;
	case "eff_dt":
		var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
		var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
		if (sheetObj.GetCellValue(Row, "eff_dt") < effDt) {
			ComShowCodeMessage("PRI08016");
			sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
			sheetObj.SelectCell(Row, "eff_dt");
		}
		if (sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt")) {
			ComShowCodeMessage("PRI00306");
			sheetObj.SetCellValue(Row, "eff_dt",effDt,0);
			sheetObj.SelectCell(Row, "eff_dt");
		}
		break;
	case "exp_dt":
		var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
		var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
		if (sheetObj.GetCellValue(Row, "exp_dt") > expDt) {
			ComShowCodeMessage("PRI08016");
			sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
			sheetObj.SelectCell(Row, "exp_dt");
		}
		if (sheetObj.GetCellValue(Row, "eff_dt") > sheetObj.GetCellValue(Row, "exp_dt")) {
			ComShowCodeMessage("PRI00306");
			sheetObj.SetCellValue(Row, "exp_dt",expDt,0);
			sheetObj.SelectCell(Row, "exp_dt");
		}
		break;
	case "bkg_prc_cgo_tp_cd": 	
		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
		if(chgRuleDefCd == "APP"){
			if(Value != "DG") {
				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
				sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
			}
		}
		if(Value == "DG") {
			sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
		} else {
			sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
			sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
		}
		break;	
	case "rt_appl_tp_cd":
		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
		var rtOpCd=sheetObj.GetCellValue(Row, "rt_op_cd");
		if(Value == "A" || Value == "F") {
			sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
			sheetObj.SetCellValue(Row, "curr_cd","USD",0);
			sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
			sheetObj.SetCellEditable(Row, "rt_op_cd",1);
			sheetObj.SetCellEditable(Row, "curr_cd",1);
			sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
			} else {
				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
				sheetObj.SetCellValue(Row, "curr_cd","",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
			}
			if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
				&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
				&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
				&& chgRuleDefCd != "RAC" ) {
				if( Value == "F") {
					sheetObj.SetCellValue(Row, "rt_op_cd","",0);
					sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				}
				if( Value == "A") {
					sheetObj.SetCellValue(Row, "curr_cd","",0);
					sheetObj.SetCellEditable(Row, "curr_cd",0);
				}
 		} else if(chgRuleDefCd == "ADD" || chgRuleDefCd == "ARB") {
 			if (Value == "I" || Value == "A"){ 	   
 				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 			} else if (Value == "S" || Value == "N"){
				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
				sheetObj.SetCellValue(Row, "curr_cd","",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
				} else {
				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",1);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
				sheetObj.SetCellValue(Row, "curr_cd","USD",0);
				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
				}
 		} else if(chgRuleDefCd == "NOT") {
 			if (Value != "I" && Value != "N"){ 	   
 				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
				sheetObj.SetCellValue(Row, "curr_cd","",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 			}
 		} else if(chgRuleDefCd == "APP") {
 			if (Value != "S" && Value != "N"){ 	   
 				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","",0);
				sheetObj.SetCellValue(Row, "curr_cd","",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
 				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
 			}
 		} else if(chgRuleDefCd == "TYP") {
 			if (Value == "A"){ 	    	    				
 				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
 			} else if (Value == "N"){ 	    	    				
 				sheetObj.SetCellEditable(Row, "rt_op_cd",0);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
				sheetObj.SetCellValue(Row, "curr_cd","",0);
 			} else {
 				ComShowCodeMessage("PRI00333", sheetObj.GetCellText(Row, Col));
 				sheetObj.SetCellEditable(Row, "rt_op_cd",1);
				sheetObj.SetCellEditable(Row, "curr_cd",0);
				sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
 				sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
 				sheetObj.SetCellValue(Row, "curr_cd","",0);
 				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
				sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
 			}
 		}
		break;
	case "rt_op_cd":
		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
		var rtApplTpCd=sheetObj.GetCellValue(Row, "rt_appl_tp_cd");
		if (chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR"
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
			if (rtApplTpCd == "F") {
				if (Value == ">" || Value == "<") {
					ComShowCodeMessage("PRI00326");
					sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
					sheetObj.SelectCell(Row, "rt_op_cd");
				}
			}
		} else if (chgRuleDefCd == "RAR") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		} else if (chgRuleDefCd == "RAP") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		} else if (chgRuleDefCd == "DOR") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		} else if (chgRuleDefCd == "TYP") {
			if (Value == ">" || Value == "<") {
				ComShowCodeMessage("PRI00326");
				sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
				sheetObj.SelectCell(Row, "rt_op_cd");
			}
		}
		break;
	case "bkg_ts_port_def_cd":
		if (Value.length == 5) {
			formObj.f_cmd.value=COMMAND24;
			formObj.cd.value=Value;
			var sParam=FormQueryString(formObj);
			sParam += "&etc1=" + PRI_RP_SCP;
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd",arrData[0],0);
				sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","L",0);
				sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
			} else {
				sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
				sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
				sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");
				sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
			}
		} else {
			sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
			sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
			sheetObj.SelectCell(Row, "bkg_ts_port_def_cd");
			sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
		}
		//sheetObj.SetCellBackColor(Row, "bkg_ts_port_def_cd", 0);
		break;
	case "bkg_dir_call_flg":
		if (Value == "Y") {
			sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
			sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
		} else {
			sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
		}
		break;
	case "bkg_imdg_clss_cd":
		if (Value.length > 0) {
			formObj.f_cmd.value=COMMAND30;
			formObj.cd.value=Value;
			var sParam=FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd",arrData[0],0);
			} else {
				sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
				sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");
			}
		} else {
			sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
			sheetObj.SelectCell(Row, "bkg_imdg_clss_cd");
		}
		break;
	case "curr_cd":
		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
		if (chgRuleDefCd == "ARB" || chgRuleDefCd == "ADD") {
			if (Value != "USD" && Value != "EUR" && Value != "GBP" && Value != "INR" && Value != "NOK") {
				ComShowCodeMessage("PRI01074", "USD, EUR, GBP, INR, NOK");
				sheetObj.SetCellValue(Row, "curr_cd","USD",0);
				sheetObj.SelectCell(Row, "curr_cd");
			}
		}
		break;
	}
}

function SheetObject(sheet, row, col, rtnVal){
	this.sheet = sheet;
	this.row = row;
	this.col = col;
	this.rtnVal = rtnVal;
}
var _tmp_sheetObject;

/**
 * calling function when occurring OnClick Event <br>
 * calling calendar DIV <br>
 */
function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	var colname=sheetObj.ColSaveName(Col);
	var formObj=document.form;
	var pinkColor="#FFC0CB";
	switch (colname) {
	case "eff_dt":
		cal=new ComCalendarGrid();
		cal.select(sheetObj, Row, "eff_dt", 'yyyy-MM-dd');
		break;
	case "exp_dt":
		cal=new ComCalendarGrid();
		cal.select(sheetObj, Row, "exp_dt", 'yyyy-MM-dd');
		break;
	case "bkg_ts_port_def_cd":
		var sUrl="/opuscntr/ESM_PRI_4026.do?";
		var sParam="&location_cmd=L";
		ComOpenPopup(sUrl + sParam, 700, 310, "callback4026", "1,0", false);
		_tmp_sheetObject = new SheetObject(sheetObj, Row, Col);
	}
}

function callback4026(rtnVal){
	var sheetObj = sheetObjects[0];
	var Row = _tmp_sheetObject.row;
	var Col = _tmp_sheetObject.col;	
	if (rtnVal != null) {
		sheetObj.SetCellValue(Row, Col,rtnVal.cd,0);
		sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd",rtnVal.tp,0);
	}
}

/**
 * Duration's Validation function <br>
 */
function checkDuration(sheetObj) {
	var formObj=document.form;
	var rowCount = getValidRowCount(sheetObj);
	var effDt=ComGetDateAdd(formObj.eff_dt.value, "D", 0, "");
	var expDt=ComGetDateAdd(formObj.exp_dt.value, "D", 0, "");
	if (rowCount > 0) {
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			if (sheetObj.GetRowStatus(i) == "D") {
				continue;
			}
			if(sheetObj.GetCellValue(i, "chg_rule_def_cd") == "APP") {
				continue;
			}
			if (sheetObj.GetCellValue(i, "eff_dt") < effDt) {
				ComShowCodeMessage("PRI08016");
				sheetObj.SetCellValue(i, "eff_dt",effDt,0);
				sheetObj.SelectCell(i, "eff_dt");
				return false;
			}
			if (sheetObj.GetCellValue(i, "eff_dt") > sheetObj.GetCellValue(i, "exp_dt")) {
				ComShowCodeMessage("PRI00306");
				sheetObj.SetCellValue(i, "eff_dt",effDt,0);
				sheetObj.SetCellValue(i, "exp_dt",expDt,0);
				sheetObj.SelectCell(i, "eff_dt");
				return false;
			}
			if (sheetObj.GetCellValue(i, "exp_dt") > expDt) {
				ComShowCodeMessage("PRI08016");
				sheetObj.SetCellValue(i, "exp_dt",expDt,0);
				sheetObj.SelectCell(i, "exp_dt");
				return false;
			}
		}
	}
	return true;
}
/**
 * checking function when selecting code item <br>
 */
function disableColumnValidation(sheetObj, Row, Col, Value) {
	initColumnEditable(sheetObj, Row, Col, Value);
	switch (Value) {
	case "APP":
		sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",0);
		//sheetObj.CellEditable(Row, "bkg_prc_cgo_tp_cd") = false;
		sheetObj.SetCellEditable(Row, "rt_op_cd",0);
		sheetObj.SetCellEditable(Row, "curr_cd",0);
		sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		break;
	case "NOT":
		sheetObj.SetCellEditable(Row, "rt_op_cd",0);
		sheetObj.SetCellEditable(Row, "curr_cd",0);
		sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		break;
	case "RAS":
		sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
		sheetObj.SetCellEditable(Row, "curr_cd",0);
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		break;
	case "ARB":
		//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "S" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "I"
			|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "N") {
			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
		} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
		} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
			sheetObj.SetCellEditable(Row, "curr_cd",0);
		}
		break;
	case "ADD":
		//sheetObj.CellEditable(Row, "rt_op_cd") 					= false;
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "S" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "I"
			|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "N") {
			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
		} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
		} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
			sheetObj.SetCellEditable(Row, "curr_cd",0);
		}
		break;
	case "TYP":
		//sheetObj.CellEditable(Row, "rt_appl_tp_cd") 			= false;
		sheetObj.SetCellEditable(Row, "curr_cd",0);
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		break;
	case "RAR":
		sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
		sheetObj.SetCellEditable(Row, "curr_cd",0);
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		break;
	case "RAP":
		sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
		sheetObj.SetCellEditable(Row, "curr_cd",0);
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		break;
	case "DOR":
		sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",0);
		sheetObj.SetCellEditable(Row, "curr_cd",0);
		sheetObj.SetCellEditable(Row, "pay_term_cd",0);
		break;
	default: //SURCHARGE 												
		if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "S"
			|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "I"
				|| sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "N") {
			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
			sheetObj.SetCellEditable(Row, "curr_cd",0);
			sheetObj.SetCellEditable(Row, "frt_rt_amt",0);
		} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="F" ) {
			sheetObj.SetCellEditable(Row, "rt_op_cd",0);
		} else if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd")=="A" ) {
			sheetObj.SetCellEditable(Row, "curr_cd",0);
		}
		break;
	}
}
/**
 * initializing sheet's editable or not <br>
 */
function initColumnEditable(sheetObj, Row, Col, Value) {
	sheetObj.SetCellEditable(Row, "rt_appl_tp_cd",1);
	sheetObj.SetCellEditable(Row, "bkg_rat_ut_cd",1);
	sheetObj.SetCellEditable(Row, "bkg_prc_cgo_tp_cd",1);
	if (sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "DG") {
		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",1);
	} else {
		sheetObj.SetCellEditable(Row, "bkg_imdg_clss_cd",0);
	}
	sheetObj.SetCellEditable(Row, "rt_op_cd",1);
	sheetObj.SetCellEditable(Row, "curr_cd",1);
	sheetObj.SetCellEditable(Row, "frt_rt_amt",1);
	sheetObj.SetCellEditable(Row, "pay_term_cd",1);
	sheetObj.SetCellEditable(Row, "bkg_soc_flg",1);
	sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
	sheetObj.SetCellEditable(Row, "bkg_esvc_tp_cd",1);
	if (sheetObj.GetCellValue(Row, "bkg_ts_port_def_cd") != "") {
		sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",0);
	} else {
		sheetObj.SetCellEditable(Row, "bkg_dir_call_flg",1);
	}
	if (sheetObj.GetCellValue(Row, "bkg_dir_call_flg") == "Y") {
		sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",0);
	} else {
		sheetObj.SetCellEditable(Row, "bkg_ts_port_def_cd",1);
	}
}
/**
 * checking mandatory column when selection CODE <br>
 */
function checkMandatoryValidation(sheetObj, Row) {
	var rowCount =sheetObj.RowCount();
	var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
	if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
			&& chgRuleDefCd != "RAC" ) {
		if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
		} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
		} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
		} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001 && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
	 			ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
		} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
			if (sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "F" || sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A"){
					ComShowCodeMessage("PRI00316","Per");
	 				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
	 				return false;
				}
			}
		} else if (chgRuleDefCd == "APP") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} 
		} else if (chgRuleDefCd == "NOT") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			}  			
		} else if (chgRuleDefCd == "RAS") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") < 0.001) {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} 
		} else if (chgRuleDefCd == "ARB") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			}
		} else if (chgRuleDefCd == "ADD") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} 
		} else if (chgRuleDefCd == "TYP") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Application");
				sheetObj.SelectCell(Row, "rt_appl_tp_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "" && sheetObj.GetCellValue(Row, "rt_appl_tp_cd") == "A") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_rat_ut_cd") == "") {
				ComShowCodeMessage("PRI00316","Per");
				sheetObj.SelectCell(Row, "bkg_rat_ut_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rule_appl_chg_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Type");
				sheetObj.SelectCell(Row, "rule_appl_chg_tp_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "conv_rat_ut_cd") == "") {
				ComShowCodeMessage("PRI00316","Per (in S/C)"); 
				sheetObj.SelectCell(Row, "conv_rat_ut_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAR") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_por_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_pol_def_cd") == ""
				&& sheetObj.GetCellValue(Row, "bkg_pod_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_del_def_cd") == "") {
				ComShowCodeMessage("PRI01052","POR, POL, POD, DEL");
				sheetObj.SelectCell(Row, "bkg_por_def_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "conv_org_loc_def_cd") == "" && sheetObj.GetCellValue(Row, "conv_org_via_loc_def_cd") == ""
				&& sheetObj.GetCellValue(Row, "conv_dest_via_loc_def_cd") == "" && sheetObj.GetCellValue(Row, "conv_dest_loc_def_cd") == "") {
				ComShowCodeMessage("PRI01052","Origin, Origin Via, Dest Via, Dest");
				sheetObj.SelectCell(Row, "conv_org_loc_def_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAP") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_cmdt_def_cd") == "" && sheetObj.GetCellValue(Row, "bkg_scg_grp_cmdt_cd") == "") {
				ComShowCodeMessage("PRI00334","Commodity","GRI Commodity");
				sheetObj.SelectCell(Row, "bkg_cmdt_def_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "conv_cmdt_def_cd") == "") {
				ComShowCodeMessage("PRI00316","Commodity (in S/C)");
				sheetObj.SelectCell(Row, "conv_cmdt_def_cd");
				return false;
			}
		} else if (chgRuleDefCd == "DOR") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_rcv_term_cd") == "" && sheetObj.GetCellValue(Row, "bkg_de_term_cd") == "") {
				ComShowCodeMessage("PRI00334","Receiving Term","Delivery Term");
				sheetObj.SelectCell(Row, "bkg_rcv_term_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "conv_prc_rcv_term_cd") == "" && sheetObj.GetCellValue(Row, "conv_prc_de_term_cd") == "") {
				ComShowCodeMessage("PRI00334","Receiving Term (in S/C)","Delivery Term (in S/C)");
				sheetObj.SelectCell(Row, "conv_prc_rcv_term_cd");
				return false;
			}
		} else if (chgRuleDefCd == "RAC") {
			if(sheetObj.GetCellValue(Row, "eff_dt") == "") {
				ComShowCodeMessage("PRI00316","Effective Date");
				sheetObj.SelectCell(Row, "eff_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "exp_dt") == "") {
				ComShowCodeMessage("PRI00316","Expiration Date");
				sheetObj.SelectCell(Row, "exp_dt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "bkg_prc_cgo_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Cargo Type");
				sheetObj.SelectCell(Row, "bkg_prc_cgo_tp_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "rt_op_cd") == "") {
				ComShowCodeMessage("PRI00316","Cal.");
				sheetObj.SelectCell(Row, "rt_op_cd");
				return false;
			} else if(sheetObj.GetCellValue(Row, "frt_rt_amt") == "") {
				ComShowCodeMessage("PRI00316","Amount");
				sheetObj.SelectCell(Row, "frt_rt_amt");
				return false;
			} else if(sheetObj.GetCellValue(Row, "conv_prc_cgo_tp_cd") == "") {
				ComShowCodeMessage("PRI00316","Cargo Type (in S/C)"); 
				sheetObj.SelectCell(Row, "conv_prc_cgo_tp_cd");
				return false;
			}
		}
	return true;
	}
/**
 * setting column default when selecting code <br>
 */
function defaultColumnValidation(sheetObj, Row, Col, Value) {
	initColumnValue(sheetObj, Row);
	switch (Value) {
	case "TYP":
		sheetObj.SetCellValue(Row, "curr_cd","",0);
		sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","D4",0);
		sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
		sheetObj.SetCellValue(Row, "rt_appl_tp_cd","A",0);
		break;
	case "NOT":
		sheetObj.SetCellValue(Row, "rt_appl_tp_cd","I",0);
		break;
	case "RAS":
		sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
		break;
	case "RAR":
		sheetObj.SetCellValue(Row, "curr_cd","",0);
		sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
		break;
	case "RAP":
		sheetObj.SetCellValue(Row, "curr_cd","",0);
		sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
		break;
	case "DOR":
		sheetObj.SetCellValue(Row, "curr_cd","",0);
		sheetObj.SetCellValue(Row, "rt_op_cd","+",0);
		sheetObj.SetCellValue(Row, "frt_rt_amt","0",0);
		break;
	case "ARB":
		sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
		// sheetObj.CellValue2(Row, "curr_cd") = "USD";
		// sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		// sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		break;
	case "ADD":
		sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
		// sheetObj.CellValue2(Row, "curr_cd") = "USD";
		// sheetObj.CellValue2(Row, "rt_op_cd") = "+";
		// sheetObj.CellValue2(Row, "frt_rt_amt") = "0";
		break;
	default:
		sheetObj.SetCellValue(Row, "rt_appl_tp_cd","S",0);
		break;
	}
}
/**
 * initializing data function <br>
 */
function initColumnValue(sheetObj, Row) {
	sheetObj.SetCellValue(Row, "rt_appl_tp_cd","",0);
	sheetObj.SetCellValue(Row, "rt_op_cd","",0);
	sheetObj.SetCellValue(Row, "curr_cd","",0);
	sheetObj.SetCellValue(Row, "frt_rt_amt","",0);
	sheetObj.SetCellValue(Row, "pay_term_cd","",0);
	sheetObj.SetCellValue(Row, "bkg_rat_ut_cd","",0);
	sheetObj.SetCellValue(Row, "bkg_prc_cgo_tp_cd","",0);
	sheetObj.SetCellValue(Row, "bkg_imdg_clss_cd","",0);
	sheetObj.SetCellValue(Row, "bkg_soc_flg","",0);
	sheetObj.SetCellValue(Row, "bkg_ts_port_tp_cd","",0);
	sheetObj.SetCellValue(Row, "bkg_ts_port_def_cd","",0);
	sheetObj.SetCellValue(Row, "bkg_dir_call_flg","",0);
	sheetObj.SetCellValue(Row, "bkg_esvc_tp_cd","",0);
	//sheetObj.CellValue2(Row, "bkg_vvd_cd") = "";
}
/**
 * mutiple copying sheet's row <br>
 */	
function copySheetData(sheetObj) {
	//setting default value after sheet loading
	var maxSeq=parseInt(ComPriGetMax(sheetObj, "note_conv_seq")) + 1;  
	var sCheckRow=sheetObj.FindCheckedRow("chk");
	if(sCheckRow == ""){
		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"chk","1",0);
	}
	sCheckRow=sheetObj.FindCheckedRow("chk");
	var aCheckArr=ComRtrim(sCheckRow, '|').split("|");
	if(aCheckArr != null && aCheckArr.length > 0) {
		for(var i=aCheckArr.length-1; i>=0; i--) {
			sheetObj.SetSelectRow(aCheckArr[i]);
			var idx=sheetObj.DataCopy();
			sheetObj.SetCellValue(idx, "note_conv_seq",maxSeq,0);
			sheetObj.SetCellValue(idx, "chk",0,0);
  			// Rule & Charge Code color classification
  			//setChargeRuleColor(sheetObj, idx);
			maxSeq++;
		}
	}
}
/**
 * setting data by CHARGE RULE TYPE when selecting CODE COMBO <br>
 * when selecting RULE code, CHG_RULE_TP_CD:C and register NOTE_CONV_RULE_CD code value   <br>
 * when selecting CHARGE code, CHG_RULE_TP_CD:R and register NOTE_CONV_CHG_CD  <br>
 */
function insertChargeRuleType(sheetObj, Row) {
	var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
	if (chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
		&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
		&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT") {
		//CHARGE
		sheetObj.SetCellValue(Row, "chg_rule_tp_cd","C",0);
		sheetObj.SetCellValue(Row, "note_conv_chg_cd",chgRuleDefCd,0);
		sheetObj.SetCellValue(Row, "note_conv_rule_cd","",0);
	} else {
		//RULE
		sheetObj.SetCellValue(Row, "chg_rule_tp_cd","R",0);
		sheetObj.SetCellValue(Row, "note_conv_rule_cd",chgRuleDefCd,0);
		sheetObj.SetCellValue(Row, "note_conv_chg_cd","",0);
	}
}
	/**
	 * setting color function in case of Code is Rule code <br>
	 */ 
	function setChargeRuleColor(sheetObj, Row) {
		// Rule & Charge Code color classification
		var sCodeColor="#FFC8C8";
		var chgRuleDefCd=sheetObj.GetCellValue(Row, "chg_rule_def_cd");
		if(    chgRuleDefCd != "APP" && chgRuleDefCd != "RAS" && chgRuleDefCd != "TYP" 
			&& chgRuleDefCd != "RAR" && chgRuleDefCd != "RAP" && chgRuleDefCd != "DOR" 
			&& chgRuleDefCd != "ARB" && chgRuleDefCd != "ADD" && chgRuleDefCd != "NOT"
			&& chgRuleDefCd != "RAC" ) {
			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",0);
		} else {
			sheetObj.SetCellBackColor(Row,"chg_rule_def_cd",sCodeColor);
		} 
	}
	/**
	 * handling all buttons Enalbe/Disable <br> <br>
	 */
 function toggleButtons(mode) {
 	var formObj=document.form;
     switch (mode) {
	     case "Y":	    	
	    	 ComBtnEnable("btn_copy");
	    	 ComBtnEnable("btn_paste");
	    	 ComBtnEnable("btn_rowadd");
	    	 ComBtnEnable("btn_rowcopy");
	    	 ComBtnEnable("btn_delete");
	    	 ComBtnEnable("btn_ok");
	    	 ComBtnEnable("btn_close");
	    	 sheetObjects[0].SetEditable(1);
	    	 formObj.note_ctnt.readOnly=false;
	         break;
	     case "N":
	    	 ComBtnDisable("btn_copy");
	    	 ComBtnDisable("btn_paste");
	    	 ComBtnDisable("btn_rowadd");
	    	 ComBtnDisable("btn_rowcopy");
	    	 ComBtnDisable("btn_delete");
	    	 ComBtnDisable("btn_ok");
	    	 ComBtnEnable("btn_close");
	    	 sheetObjects[0].SetEditable(0);
	    	 formObj.note_ctnt.readOnly=true;
	         break;
	     case "M":
	    	 ComBtnDisable("btn_copy");
	    	 ComBtnDisable("btn_paste");
	    	 ComBtnDisable("btn_rowadd");
	    	 ComBtnDisable("btn_rowcopy");
	    	 ComBtnDisable("btn_delete");
	    	 ComBtnEnable("btn_ok");
	    	 ComBtnEnable("btn_close");
	    	 sheetObjects[0].SetEditable(0);
	    	 formObj.note_ctnt.readOnly=false;
	         break;
     }
 }
