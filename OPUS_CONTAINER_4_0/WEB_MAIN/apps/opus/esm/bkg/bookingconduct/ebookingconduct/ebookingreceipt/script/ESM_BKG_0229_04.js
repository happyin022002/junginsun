﻿/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0229_04.js
*@FileTitle  : e-Booking & SI Process Detail(M&D)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================
*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var isCopy="false";
	var div1sheet1=null;
	var div2sheet1=null;
	var div3sheet1=null;
	var div3sheet2=null;
	var div3sheet3=null;
	var div4sheet1=null;
	var div4sheet2=null;
	var sheetObject1=null;
	var shipIdSheet2=null;
	var shipIdSheet1=null;
	var innerPackageSheet=null;
	var cntrTpSzDesc=null;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
		/*******************************************************/
		var formObject=document.form;
		var sheetIdx=0;
	    div1sheet1=sheetObjects[sheetIdx++];
	    div2sheet1=sheetObjects[sheetIdx++];
	    innerPackageSheet=sheetObjects[sheetIdx++];
	    div3sheet1=sheetObjects[sheetIdx++];
	    div3sheet2=sheetObjects[sheetIdx++];
	    div3sheet3=sheetObjects[sheetIdx++];
	    div4sheet1=sheetObjects[sheetIdx++];
	    div4sheet2=sheetObjects[sheetIdx++];
	    shipIdSheet2=sheetObjects[sheetIdx++];
	    shipIdSheet1=sheetObjects[sheetIdx++];
	    sheetObject1=sheetObjects[sheetIdx++];
	    
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
				case "btn_cancelcopydata":
					parent.document.form.mndTabCancel.value="Y";
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
					isCopy="false";
					top.isCopyAllRequested=false;
					break;
				case "btn_datacopytoopus":
				 	if (isCopy == "false") {
						dataCopy();
				 	}
					break;
				case "btn_datacopyfromcm":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC03);
					break;
				case "btn_upload":
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
				case "btn_find_package":
					//comBkgCallPop0696("callbackPckTp", formObject.pck_tp_cd.value);
					comBkgCallModal0696("callbackPckTp", formObject.pck_tp_cd.value);
					break;
				case "btn_copy":
					doActionIBSheet(sheetObject1, formObject, IBCOPYROW);
					break;
				case "btn_ExportInfo"://	
					showXptLicNo();
					break;
				case "btn_POOtherNo":
					showPoOther();
					break;
				case "btn_ExportInfo2":
					showXptLicNo2();
					break;
				case "btn_POOtherNo2":
					showPoOther2();
					break;
				case "btn_MiscInfo2":
					showMiscDesc();
					break;
				case "btn_InnerPackage2":
					showInnerPackage();
					break;
				case "btn_Calendar": 
					var cal=new ComCalendar();
					cal.select(formObject.lcdt, 'yyyy-MM-dd');
					break;
				case "btn_krRowAdd":
					var newRow=div1sheet1.DataInsert(-1);
					div1sheet1.SetCellValue(newRow, "bkg_no",formObject.bkg_no.value);
					div1sheet1.SetCellValue(newRow, "io_bnd_cd","O");
					div1sheet1.SetCellValue(newRow, "xpt_imp_seq","");
					div1sheet1.SetCellValue(newRow, "cnt_cd","KR");
					div1sheet1.SetCellValue(newRow, "wgt_ut_cd","KGS");
					div1sheet1.SetCellValue(div1sheet1.LastRow(), 1,"",0);
					div1sheet1.SetCellValue(div1sheet1.LastRow(), "ts_ref_no","TOTAL",0);
					div1sheet1.SetCellAlign(div1sheet1.LastRow(), "ts_ref_no","Center");
					div1sheet1.SelectCell(newRow, "xpt_imp_no")
					break; 
				case "btn_krRowDelete":
					if (!ComShowCodeConfirm("COM12188")) return;
					var rCnt=div1sheet1.RowCount()+1;
				    var chkCnt=0
					for(i=1;i<rCnt;i++){
						if(div1sheet1.GetCellValue(i, "check") == 1){
							chkCnt++	
						}
					}
				    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
					for(i=rCnt;i>0;i--){
						if(div1sheet1.GetCellValue(i, "check") == 1){
							div1sheet1.RowDelete(i, false);
						}
					}
					break;
				case "btn_Po_Add":
					var newRow=div3sheet2.DataInsert(-1);
					div3sheet2.SetCellValue(newRow, "bkg_no",formObject.bkg_no.value);
					break;            
				case "btn_Po_Delete":
					if (!ComShowCodeConfirm("COM12188")) return;
					var rCnt=div3sheet2.Rowcount+1;
				    var chkCnt=0
					for(i=1;i<rCnt;i++){
						if(div3sheet2.GetCellValue(i, "check") == 1){
							chkCnt++	
						}
					}
				    if(chkCnt==0) {ComShowMessage("Nothing selected"); return;}
					ComRowHideDelete(div3sheet2, "check");
					break;
				case "btn_shipId2":
					showShipId2();
					break;
				case "btn_shipId1":
					showShipId1();
					break;
				case "btn2_Row_Add":
					var Row = shipIdSheet1.DataInsert(-1);
					break;
				case "btn2_Row_Delete":
					ComRowHideDelete(shipIdSheet1, "del_chk");
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
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			//khlee- Preferences change the name of the function to start
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			//khlee- The final configuration functions added
			ComEndConfigSheet(sheetObjects[i]);
		}
		var sheetIdx=0;
	    div1sheet1=sheetObjects[sheetIdx++];
	    div2sheet1=sheetObjects[sheetIdx++];
	    innerPackageSheet=sheetObjects[sheetIdx++];
	    div3sheet1=sheetObjects[sheetIdx++];
	    div3sheet2=sheetObjects[sheetIdx++];
	    div3sheet3=sheetObjects[sheetIdx++];
	    div4sheet1=sheetObjects[sheetIdx++];
	    div4sheet2=sheetObjects[sheetIdx++];
	    shipIdSheet2=sheetObjects[sheetIdx++];
	    shipIdSheet1=sheetObjects[sheetIdx++];
	    sheetObject1=sheetObjects[sheetIdx++];
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k+1);           
	    }    
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);
		initControl();	
	}
	function initControl() {
		var formObject=document.form;
		// Axon Event Processing 1. Events catch (developers change)
		//	axon_event.addListenerFormat("keypress", "obj_KeyPress", formObject);
		//	axon_event.addListenerForm("blur", "form1_onBlur", formObject);
		axon_event.addListenerForm("change", "form1_onChange", formObject);
	    axon_event.addListenerFormat('beforeactivate', 'obj_activate', formObject);
		axon_event.addListenerForm('deactivate', 'form1_blur', document.form);
		applyShortcut();
	}
	/**
	 * The initial setting combo
	 * 
	 * @param {IBMultiCombo}
	 *            comboObj comboObj
	 */
	function initCombo(comboObj) {
	    switch(comboObj.id) {
	    	case "ndr_ref_id": 
	    		var i=0;	            
	    		comboObj.InsertItem(i++, "NDR1|Goods exported for consumption in the United States.|NDR1",            "NDR1");
	            comboObj.InsertItem(i++, "NDR2|Commercial goods having a value of less than CAN$2,000|NDR2",          "NDR2");
	            comboObj.InsertItem(i++, "NDR3|Personal and household effects, other than those of an emigrant, that are not for resale or|NDR3 ",           "NDR3");
	            comboObj.InsertItem(i++, "|commercial use|NDR3",           "NDR3");
	            comboObj.InsertItem(i++, "NDR4|Conveyances that would, if they were imported, be classified at the time of importation under |NDR4", "NDR4");
	            comboObj.InsertItem(i++, "|any of tariff item Nos. 9801.10.00, 9801.20.00 or 9801.30.00 in the List of Tariff Provisions set|NDR4", "NDR4");
	            comboObj.InsertItem(i++, "|out in the schedule to the Customs Tariff|NDR4", "NDR4");
	            comboObj.InsertItem(i++, "NDR5|Cargo containers that would, if they were imported, be classified at the time of importation|NDR5",        "NDR5");
	            comboObj.InsertItem(i++, "|under tariff item No. 980l.10.00 in the List of Tariff Provisions set out in the schedule to the|NDR5",        "NDR5");
	            comboObj.InsertItem(i++, "|to the Customs Tariff|NDR5",        "NDR5");
	            comboObj.InsertItem(i++, "NDR6|Reusable skids, drums, pallets, straps and similar goods used by a carrier in the international|NDR6",       "NDR6");
	            comboObj.InsertItem(i++, "|commercial transportation of goods|NDR6",       "NDR6");
	            comboObj.InsertItem(i++, "NDR7|Goods exported by diplomatic embassy or mission personnel for their personal or official use|NDR7",         "NDR7");
	            comboObj.InsertItem(i++, "NDR8|Personal gifts and donations of goods, excluding conveyances|NDR8",         "NDR8");
	            comboObj.InsertItem(i++, "NDR9|Goods that were imported into Canada and are exported from Canada after being transported|NDR9",         "NDR9");
	            comboObj.InsertItem(i++, "|in transit through Canada en route to a non-Canadian destination|NDR9",         "NDR9");
	            comboObj.InsertItem(i++, "NDR10|Goods that were manufactured or produced in Canada and that are exported from Canada for|NDR10",         "NDR10");
	            comboObj.InsertItem(i++, "|the purpose of being transshipped through another country to another Canadian destination|NDR10",         "NDR10");
	            comboObj.InsertItem(i++, "NDR11|Goods exported for repair or warranty repair that will be returned to Canada|NDR11",         "NDR11");
	            comboObj.InsertItem(i++, "NDR12|Goods for use as ships' stores by a Canadian carrier|NDR12",         "NDR12");
	            comboObj.InsertItem(i++, "NDR13|Goods manufactured or produced outside Canada and removed for export from a bonded|NDR13",         "NDR13");
	            comboObj.InsertItem(i++, "|warehouse or sufferance warehouse|NDR13",         "NDR13");
	            comboObj.InsertItem(i++, "NDR14|Goods, other than goods exported for further processing, that will be returned to Canada within|NDR14",         "NDR14");
	            comboObj.InsertItem(i++, "|12 months after the date of exportation|NDR14",         "NDR14");
	            comboObj.InsertItem(i++, "NDR15|Goods being exported on behalf of Department of National Defense or due to an emergency|NDR15",         "NDR15");
	            comboObj.InsertItem(i++, "|will report orally according to section 15 of the export regulations|NDR15",         "NDR15");
	            comboObj.InsertItem(i++, "NDR16|Goods reported on a Form E15 Certificate of Destruction/Exportation for temporary export|NDR16",         "NDR16");
	            comboObj.SetSelectCode("");
	            comboObj.SetColWidth(0, "50");
	            comboObj.SetColWidth(1, "550");
	            comboObj.SetColWidth(2, "0");
	            comboObj.SetDropHeight(350);
	            comboObj.SetColBackColor(0,"#eeeeee");
	        break; 
		    default:
		    	comboObj.SetMultiSelect(0);
				comboObj.SetColAlign(0, "left");
				comboObj.SetColAlign(1, "left");
				comboObj.SetMultiSeparator("|");
		    	break;
	    }
	}
	/**
	 * registering IBCombo Object as list
	 * @param {IBMultiCombo}
	 * combo_obj IBMultiCombo Object
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "div1sheet1":      //OPUS korea export licens no
		    with(sheetObj){
			      var HeadTitle="|||||||Export License Number|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"CheckBox",  Hidden:0, Width:25,   Align:"Center",  ColMerge:0,   SaveName:"check",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"xpt_lic_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
			             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"ts_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",        KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mf_wgt",         KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"divd_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"sam_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetColProperty("xpt_lic_no", {Format:"###-##-##-#######-#"} );
			      SetColProperty("wgt_ut_cd", {ComboText:"|KGS|LGB", ComboCode:"|KGS|LGB"} );
			      SetColProperty("divd_seq", {ComboText:"|1|2|3|4", ComboCode:"|1|2|3|4"} );
			      SetColProperty("sam_pck_id", {ComboText:"|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z", ComboCode:"|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z"} );
			      SetShowButtonImage(2);
			      SetSheetHeight(150);
			      sheetObj.SetVisible(0);
	      		}
			break;
			
		case "div2sheet1":      //esvc korea export licens no
		    with(sheetObj){
			      var HeadTitle="||||||Export License Number|Other Reference No.|Package|Package|Weight|Weight|DIV|SMP|SMP Package|SMP Package";
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag2" },
			             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq2" },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no2",         KeyField:1 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd2",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq2",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"xpt_lic_no2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:0,   SaveName:"ts_ref_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty2",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"mf_wgt2",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"divd_seq2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_id2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"sam_pck_qty2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_tp_cd2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetSheetHeight(140);
			      sheetObj.SetVisible(0);
	            }
			break;
			
		case "sheet1":
		    with(sheetObj){
			      var HeadTitle="ib_flg|seq|bkg_no|io_bnd_cd|xpt_imp_seq|cnt_cd|Export License Number|Other Reference No.|pck_qty|pck_tp_cd|wgt|wgt_ut_cd"
			      +	"|sam_pck_id|sam_pck_qty|sam_pck_tp_cd|divd_flg|divd_seq|divd_pck_qty|divd_pck_tp_cd|divd_wgt|divd_wgt_ut_cd"
			      +	"|aes_tp_cd|aes_inlnd_trns_no|aes_pta_no1|aes_pta_no2|aes_pta_dt|aes_ptu_no|aes_ptu_dt|aes_dwn_no|aes_dwn_dt|aes_expt_id|aes_expt_ctnt"
			      +	"|caed_tp_cd|caed_ctnt|g7_edi_ctnt|b13a_xpt_ctnt|mf_smry_rpt_no|cgo_ctrl_no|ndr_ref_id|ndr_ref_ctnt"
			      + "|mx_shpr_tax_id|mx_cnee_tax_id|mx_ntfy_tax_id"
			      // 
			      + "|tr_shpr_tax_id|tr_cnee_tax_id|tr_ntfy_tax_id"
			      + "|il_shpr_tax_id|il_cnee_tax_id|il_ntfy_tax_id"
			      + "|lb_shpr_tax_id|lb_cnee_tax_id|lb_ntfy_tax_id"
			      + "|br_shpr_tax_id|br_cnee_tax_id|br_ntfy_tax_id|brz_decl_no|shpr_tax_cpy_desc_flg|cnee_tax_cpy_desc_flg|ntfy_tax_cpy_desc_flg|brz_decl_cpy_desc_flg";			      
			      var headCount=ComCountHeadTitle(HeadTitle);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",             KeyField:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"xpt_imp_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"xpt_lic_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",      Hidden:0,  Width:145,  Align:"Center",  ColMerge:0,   SaveName:"ts_ref_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"mf_wgt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_qty",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"sam_pck_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"divd_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"divd_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"divd_pck_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"divd_pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"divd_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"divd_wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_inlnd_trns_no",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_no1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_no2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_pta_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_ptu_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_ptu_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_dwn_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_dwn_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_expt_id",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"aes_expt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"caed_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"caed_ctnt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"g7_edi_ctnt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"b13a_xpt_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mf_smry_rpt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cgo_ctrl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ndr_ref_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ndr_ref_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mx_shpr_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mx_cnee_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"mx_ntfy_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }, 
			             //
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tr_shpr_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tr_cnee_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"tr_ntfy_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"il_shpr_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"il_cnee_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"il_ntfy_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lb_shpr_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lb_cnee_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lb_ntfy_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"br_shpr_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"br_cnee_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"br_ntfy_tax_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"brz_decl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"shpr_tax_cpy_desc_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cnee_tax_cpy_desc_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"brz_decl_cpy_desc_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }
			             ];
			      
			      InitColumns(cols);
			      SetEditable(1);
			      sheetObj.SetVisible(0);
	            }
			break;
			
	 	case "sheet2": // sheet2 init //inner package
	 	    with(sheetObj){
			      var HeadTitle="ibflag|Seq|No|PKG|Level|PKG CD|PKG DESC";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mk_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"mk_sub_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ttl_pck_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ttl_pck_lvl",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ttl_pck_tp_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ttl_pck_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(108);
			      SetSheetWidth(300);
			      sheetObj.SetVisible(0);
	            }
			break;	
			
		case "div3sheet1":      //OPUS po other no1
            with(sheetObj){
			      var HeadTitle1="|Container No.|P/O No.(CNTR)";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"c_cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cust_ref_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
							 {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ref_seq" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_no" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"pck_qty" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_mf_wgt" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"meas_qty" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(0);
			      SetSheetHeight(142);
                }
            
			break;
		case "div3sheet2":      //OPUS po other no2
            with(sheetObj){
			      var HeadTitle1="||P/O No.(byItem)|Item No.|Description|Package|Package|Weight|Weight|Measure|Measure";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:1,   SaveName:"check" },
							 {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							 {Type:"Text",      Hidden:0,  Width:99,   Align:"Left",    ColMerge:1,   SaveName:"po_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
							 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"itm_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:15 },
							 {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"itm_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
							 {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
							 {Type:"PopupEdit", Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
							 {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
							 {Type:"Combo",     Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							 {Type:"Float",     Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
							 {Type:"Combo",     Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
							 {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ref_seq" },
							 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_no" } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetDataAutoTrim(1);
			      SetColProperty("wgt_ut_cd", {ComboText:"|KGS|LGB", ComboCode:"|KGS|LGB"} );
			      SetColProperty("meas_ut_cd", {ComboText:"|KGS|LGB", ComboCode:"|KGS|LGB"} );
			      SetDataLinkMouse("pck_tp_cd",1);
			      SetDataLinkMouse("wgt_ut_cd",1);
			      SetDataLinkMouse("meas_ut_cd",1);
			      SetSheetHeight(142);
			      sheetObj.SetVisible(0);
				}
			break;
			
		case "div3sheet3":      //OPUS po other no3
		    with(sheetObj){
			      var HeadTitle1="|bkg_no|ref_seq|bl_no|bl_tp|bkg_ref_tp_cd|cust_ref_no_ctnt";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ref_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bl_no_tp",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_ref_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cust_ref_no_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      sheetObj.SetVisible(0);
	            }
			break;
			
		case "div4sheet1":      //esvc po other no1
            with(sheetObj){
			      var HeadTitle1="|Container No.|P/O No.(CNTR)";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"po_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
							 {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetSheetHeight(165);
			      sheetObj.SetVisible(0);
				}
			break;
			
		case "div4sheet2":      //esvc po other no2
		    with(sheetObj){
			      var HeadTitle1="|P/O No.(byItem)|Item No.|Description|Package|Package|Weight|Weight|Measure|Measure";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Seq",       Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:0,  Width:99,   Align:"Left",    ColMerge:1,   SaveName:"po_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"itm_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"itm_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"pck_qty",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"PopupEdit", Hidden:0, Width:20,   Align:"Right",   ColMerge:0,   SaveName:"pck_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"wgt_ut_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"meas_qty",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ref_seq" },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_no" } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetDataAutoTrim(1);
			      SetSheetHeight(165);
			      sheetObj.SetVisible(0);
	            }
				break;
				
			case "shipIdSheet1": //t1sheet2 init
			    with(sheetObj){
				      var HeadTitle1="|Ship ID (Delivery No.)|Part No.|Copy to Description";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ 
				                   {Type:"CheckBox",  Hidden:0, 	Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				                   {Type:"Text",      Hidden:0,  	Width:280,  Align:"Left",    ColMerge:1,   SaveName:"de_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				                   {Type:"Text",      Hidden:0,  	Width:250,  Align:"Left",    ColMerge:1,   SaveName:"prt_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				                   {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"check",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                   {Type:"Status",    Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				                   {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no" },
				                   {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no_split" },
				                   {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ref_seq" },
				                   {Type:"Text",      Hidden:1, 	Width:0,    Align:"Center",  ColMerge:1,   SaveName:"cntr_no" } ];
				     InitColumns(cols);
				     SetEditable(1);
				     SetCountPosition(0);
			         SetSheetHeight(170);
			         sheetObj.SetVisible(0);
				}
			    break;
			    
			case "shipIdSheet2": //t1sheet2 init
			    with(sheetObj){
				      var HeadTitle1="Ship ID (Delivery No.)|Part No.";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ 
				             {Type:"Text",      Hidden:0,  	Width:280,  Align:"Left",    ColMerge:1,   SaveName:"ref_no",	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
				             {Type:"Text",      Hidden:0,  	Width:250,  Align:"Left",    ColMerge:1,   SaveName:"prt_no",  	KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 }
				             ];
				     InitColumns(cols);
				     SetEditable(1);
				     SetCountPosition(0);
			         SetSheetHeight(170);
			         sheetObj.SetVisible(0);
				}
			    break;
		}

	}
	
	// Sheet handling process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSAVE:
			if(validateForm(sheetObj, formObj, sAction)==false){
				return false;
			}
			var params=getSaveStringForUpload();
			var sXml=sheetObj.GetSaveData("ESM_BKG_0229_04GS.do", params);
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") != "S") {
				sheetObj.LoadSaveData(sXml);
			}
			break;
			
		case IBSEARCH_ASYNC01: //Retrieve
			with(formObj){
				mk_desc.value="";
	            pck_qty.value="";
				pck_tp_cd.value="";
				pck_nm.value="";
				act_wgt.value="";
				meas_qty.value="";
				wgt_ut_cd.selectedIndex="-1";
				meas_ut_cd.selectedIndex="-1"; 
				pck_cmdt_desc.value="";
				cntr_cmdt_desc.value="";
				dg_cmdt_desc.value="";
				cstms_desc.value="";
			}
			formObj.f_cmd.value=SEARCH;
			formObj.method="post";
			formObj.target="_self";
			formObj.action="/opuscntr/ESM_BKG_0229_04.do";
			formObj.submit();
			break;

		case IBSEARCH: //Retrieve	
			var frtXml=parent.frames["t1frame"].document.form.sXml.value;	
			var frtArrXml=frtXml.split("|$$|");
			
			if (frtArrXml.length > 2) ComBkgXml2ComboItem(frtArrXml[2], frt_term_cd, "val", "name");
			//alert(frt_term_cd.GetText(1, 1));
			var sXml=formObj.sXml.value;
			var arrXml=sXml.split("|$$|");
			var arrCnt=0;
			if (arrXml.length > arrCnt) {
//				div2sheet1.RenderSheet(0);
				div2sheet1.LoadSearchData(arrXml[arrCnt],{Sync:1} );
//				div2sheet1.RenderSheet(1);
			}
			arrCnt++;
			if (arrXml.length > arrCnt) { // esvc cntr po no
//				div4sheet1.RenderSheet(0);
				div4sheet1.LoadSearchData(arrXml[arrCnt],{Sync:1} );
//				div4sheet1.RenderSheet(1);
			}
			arrCnt++;
			if (arrXml.length > arrCnt) { // esvc cntr po no detail
//				div4sheet2.RenderSheet(0);
				div4sheet2.LoadSearchData(arrXml[arrCnt],{Sync:1} );
//				div4sheet2.RenderSheet(1);
			}
			arrCnt++;
			if (arrXml.length > arrCnt) { // Inner Package
				innerPackageSheet.LoadSearchData(arrXml[arrCnt],{Sync:1} );
			}
			
			arrCnt++;
			if (arrXml.length > arrCnt) { // OPUS export licens no
				shipIdSheet2.LoadSearchData(arrXml[arrCnt],{Sync:1} );
			}
			
			arrCnt++;
			if (arrXml.length > arrCnt) { // OPUS export licens no
				sheetObject1.LoadSearchData(arrXml[arrCnt],{Sync:1} );
			}
			arrCnt++;
			if (arrXml.length > arrCnt) { // OPUS bkg po no
//				div3sheet3.RenderSheet(0);
				div3sheet3.LoadSearchData(arrXml[arrCnt],{Sync:1} );
//				div3sheet3.RenderSheet(1);
				getPoOtherNoToForm();
			}
			arrCnt++;
			if (arrXml.length > arrCnt) { // OPUS cntr po no
//				div3sheet1.RenderSheet(0);
				div3sheet1.LoadSearchData(arrXml[arrCnt],{Sync:1} );
//				div3sheet1.RenderSheet(1);
			}
			arrCnt++;
			if (arrXml.length > arrCnt) { // OPUS cm po no
//				div3sheet2.RenderSheet(0);
				div3sheet2.LoadSearchData(arrXml[arrCnt],{Sync:1} );
//				div3sheet2.RenderSheet(1);
				div3sheet1_OnClick(div3sheet1, 1, 1, "");
			}	
			arrCnt++;
			if (arrXml.length > arrCnt) { // aes exception
				ComXml2ComboItem(arrXml[arrCnt], comboObjects[0], "val", "name");
			}
			arrCnt++;
			if (arrXml.length > arrCnt) { // cntr_tp_sz_desc
				var codeCol="attr_ctnt1";
				var textCol="attr_ctnt2";
				var xmlDoc = ComGetXmlDoc(arrXml[arrCnt]);
				if (xmlDoc == null) return;
				var xmlRoot = xmlDoc.documentElement;
				if (xmlRoot == null) return;
				
				var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
				var col=dataNode.getAttribute("COLORDER");
				var sep=dataNode.getAttribute("COLSEPARATOR");
				var colArr=col.split("|");
				var dataChildNodes=dataNode.childNodes;
				var colListIdx=Array();
				var arrText=textCol.split("|");
				for (var i=0; i < colArr.length; i++) {
					if (colArr[i] == codeCol) {
						colListIdx[0]=i;
					}
					for (var j=0; j < arrText.length; j++) {
						if (colArr[i] == arrText[j]) {
							colListIdx[j+1]=i;
						}
					}
				}
				cntrTpSzDesc=new Array();
				for (var i=0; i < dataChildNodes.length; i++) {
					if (dataChildNodes[i].nodeType != 1) continue;
					var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
					cntrTpSzDesc[i]=new Array();
					for (var j=0; j < colListIdx.length; j++) {
						cntrTpSzDesc[i][j]=arrData[colListIdx[j]];
					}
				}
			}
			arrCnt++;
			if (arrXml.length > arrCnt) {
				shipIdSheet1.LoadSearchData(arrXml[arrCnt],{Sync:1} );
			}	
			/* value -> true :Change the color of the button   */
			if(sheetObject1.GetTotalRows() > 0)
				document.getElementById("btn_ExportInfo").style.cssText = "color:blue !important;;font-weight:bold;";
			else
				document.getElementById("btn_ExportInfo").style.cssText = "color:#737373";
			
			getBtnObject("btn_ExportInfo2").style.color=(formObj.xpt_imp2.value=="Y")  ?"blue":"#737373";
			getBtnObject("btn_MiscInfo2").style.color=(formObj.misc2.value   =="Y")  ?"blue":"#737373";
			getBtnObject("btn_InnerPackage2").style.color=(innerPackageSheet.GetTotalRows()>0)?"blue":"#737373";
			var cntrPo=false;
			for(var i=1;i<div3sheet1.RowCount()+ 1;i++){
				if(div3sheet1.GetCellValue(i, "cust_ref_no_ctnt").length>1 && ComTrim(div3sheet1.GetCellValue(i, "cust_ref_no_ctnt"))!=null){
					cntrPo=true;
					break;
				}
			}
			if(cntrPo == true||div3sheet2.RowCount()>0
				||((formObj.bkpo.value+formObj.hinv.value+formObj.hpdp.value+formObj.lcno.value+formObj.lcdt.value+formObj.othr.value).lenght>1)){
				getBtnObject("btn_POOtherNo").style.color="blue";
			} else {
				getBtnObject("btn_POOtherNo").style.color="#737373";
			}
			if((formObj.po_no2.value  =="Y")||div4sheet1.RowCount()>0||div4sheet1.RowCount()>0){
				getBtnObject("btn_POOtherNo2").style.color="blue";
			} else {
				getBtnObject("btn_POOtherNo2").style.color="#737373";
			}
			if(formObj.act_wgt_prn_flg.value=="Y"){
				formObj.act_wgt_prn_flg.value="Y";
				formObj.act_wgt_prn_flg.checked=true;			
			} else {
				formObj.act_wgt_prn_flg.value="N";
				formObj.act_wgt_prn_flg.checked=false;			
			}
			if(parent.frames["t1frame"].document.form.doc_tp_cd.value =="S"){
				// Weight QTY
				formObj.act_wgt.value=parent.frames["t1frame"].document.form.estm_wgt2.value;
			}
			formObj.pck_qty2.value=ComAddComma3(formObj.pck_qty2.value, "#,###");			
			formObj.act_wgt2.value=ComAddComma3(formObj.act_wgt2.value, "#,###.000");
			formObj.meas_qty2.value=ComAddComma3(formObj.meas_qty2.value,"#,###.000");
			formObj.pck_qty.value=ComAddComma3(formObj.pck_qty.value,  "#,###");
			formObj.act_wgt.value=ComAddComma3(formObj.act_wgt.value,  "#,###.000");
			formObj.meas_qty.value=ComAddComma3(formObj.meas_qty.value, "#,###.000");
			// Freight Term: PREPAID OR COLLECT 
			frt_term_cd.SetSelectCode(parent.frames["t1frame"].frt_term_cd.GetSelectCode());
			formObj.frt_term_cd2.value=parent.frames["t1frame"].document.form.frt_term_cd2.value; 
			if (formObj.frt_term_cd2.value == "P" ||
				formObj.frt_term_cd2.value == "PREPAID") {
				//ComSetObjValue(document.form.frt_term_cd, "P");
				frt_term_cd.SetSelectCode("P");
			}
			else if (formObj.frt_term_cd2.value == "C" ||
				formObj.frt_term_cd2.value == "COLLECT") {
				//ComSetObjValue(document.form.frt_term_cd, "C");
				frt_term_cd.SetSelectCode("P");
			}
			if (!ComIsEmpty(frt_term_cd.GetSelectText()) && frt_term_cd.GetSelectText().substring(0,1) != formObj.frt_term_cd2.value.substring(0,1)){
				frt_term_cd.SetFontColor("Red");
				formObj.frt_term_cd2.style.color="Red";
			} else {
				frt_term_cd.SetFontColor("#606060");
				formObj.frt_term_cd2.style.color="#606060";		
			}
			//Export Info form 
			getExportInfoToForm();
			compareItem();
			if(parent.document.form.mndTabCancel.value=="Y"){
				//ComBtnColor("btn_cancelcopydata", "blue");
				//ComBtnColor("btn_datacopytoopus", "#737373");
				
				
				document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;;font-weight:bold;";
				document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;;font-weight:normal;";
				
				parent.frames["t1frame"].document.form.act_wgt.value=parent.frames["t1frame"].document.form.act_wgt_old.value;
				form.act_wgt.value=parent.frames["t1frame"].document.form.act_wgt.value;
				parent.document.form.mndTabCancel.value="N";
			}
			if(top.document.form.tabload4.value == "COPY"){
				dataCopy();
			}
			top.document.form.tabload4.value="LOAD";
			if (div1sheet1.RowCount()> 0) {
				div1sheet1.SetCellValue(div1sheet1.LastRow(), 1,"",0);
				div1sheet1.SetCellValue(div1sheet1.LastRow(), "ts_ref_no","TOTAL",0);
				div1sheet1.SetCellAlign(div1sheet1.LastRow(), "ts_ref_no","Center");
			}
			
			if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_04');
			break;
		case IBSEARCH_ASYNC02: //Data Copy
			if (formObj.mk_desc.value != null && formObj.mk_desc2.value != '')
				formObj.mk_desc.value=formObj.mk_desc2.value;
			if (formObj.dg_cmdt_desc2.value != null && formObj.dg_cmdt_desc2.value != ''){
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc2.value;
				if (parent.frames["t1frame"].document.form.sender_id.value == "SEANACCS") {
					formObj.cstms_desc.value=formObj.dg_cmdt_desc.value.substring(0,(formObj.dg_cmdt_desc.value).indexOf("\r\n"));
				}
			}
			formObj.act_wgt_prn_flg.value="Y";
			formObj.act_wgt_prn_flg.checked=true;	
			copyPckWgtMeas();
			if (formObj.frt_term_cd2.value == "P" ||
				formObj.frt_term_cd2.value == "PREPAID") {
				comboObjects[2].SetSelectCode("P");
			}
			else if (formObj.frt_term_cd2.value == "C" ||
				formObj.frt_term_cd2.value == "COLLECT") {
				comboObjects[2].SetSelectCode("C");
			}
			if (parent.frames["t1frame"].document.form) {
				//ComSetObjValue(parent.frames["t1frame"].frt_term_cd, comboObjects[2].GetSelectCode());
				parent.frames["t1frame"].frt_term_cd.SetSelectCode(comboObjects[2].GetSelectCode(),false);
			}
			getBtnObject("btn_ExportInfo").style.color="#737373";
			if(!ComIsNull(formObj.aes_inlnd_trns_no2.value)){
				formObj.aes_inlnd_trns_no.value=formObj.aes_inlnd_trns_no2.value;			
				formObj.aes_tp_cd[0].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_pta_no12.value)){
				formObj.aes_pta_no1.value=formObj.aes_pta_no12.value;			
				formObj.aes_tp_cd[1].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_pta_no22.value)){
				formObj.aes_pta_no2.value=formObj.aes_pta_no22.value;		
				formObj.aes_tp_cd[1].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_pta_dt2.value)){
				formObj.aes_pta_dt.value=formObj.aes_pta_dt2.value;		
				formObj.aes_tp_cd[2].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_ptu_no2.value)){
				formObj.aes_ptu_no.value=formObj.aes_ptu_no2.value;		
				formObj.aes_tp_cd[2].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_ptu_dt2.value)){
				formObj.aes_ptu_dt.value=formObj.aes_ptu_dt2.value;		
				formObj.aes_tp_cd[2].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_dwn_no2.value)){
				formObj.aes_dwn_no.value=formObj.aes_dwn_no2.value;		
				formObj.aes_tp_cd[3].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_dwn_dt2.value)){
				formObj.aes_dwn_dt.value=formObj.aes_dwn_dt2.value;		
				formObj.aes_tp_cd[3].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.aes_expt_id2.value)){
				formObj.aes_expt_ctnt.value=formObj.aes_expt_id2.value;		
				formObj.aes_tp_cd[4].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			//mexico
			if(!ComIsNull(formObj.mx_shpr_tax_id2.value)){
				formObj.mx_shpr_tax_id.value=formObj.mx_shpr_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.mx_cnee_tax_id2.value)){
				formObj.mx_cnee_tax_id.value=formObj.mx_cnee_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.mx_ntfy_tax_id2.value)){
				formObj.mx_ntfy_tax_id.value=formObj.mx_ntfy_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			//turkey
			if(!ComIsNull(formObj.tr_shpr_tax_id2.value)){
				formObj.tr_shpr_tax_id.value=formObj.tr_shpr_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.tr_cnee_tax_id2.value)){
				formObj.tr_cnee_tax_id.value=formObj.tr_cnee_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.tr_ntfy_tax_id2.value)){
				formObj.tr_ntfy_tax_id.value=formObj.tr_ntfy_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			//Israel
			if(!ComIsNull(formObj.il_shpr_tax_id2.value)){
				formObj.il_shpr_tax_id.value=formObj.il_shpr_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.il_cnee_tax_id2.value)){
				formObj.il_cnee_tax_id.value=formObj.il_cnee_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.il_ntfy_tax_id2.value)){
				formObj.il_ntfy_tax_id.value=formObj.il_ntfy_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			//Lebanon
			if(!ComIsNull(formObj.lb_shpr_tax_id2.value)){
				formObj.lb_shpr_tax_id.value=formObj.lb_shpr_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.lb_cnee_tax_id2.value)){
				formObj.lb_cnee_tax_id.value=formObj.lb_cnee_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.lb_ntfy_tax_id2.value)){
				formObj.lb_ntfy_tax_id.value=formObj.lb_ntfy_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			//Brazil
			if(!ComIsNull(formObj.br_shpr_tax_id2.value)){
				formObj.br_shpr_tax_id.value=formObj.br_shpr_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.br_cnee_tax_id2.value)){
				formObj.br_cnee_tax_id.value=formObj.br_cnee_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.br_ntfy_tax_id2.value)){
				formObj.br_ntfy_tax_id.value=formObj.br_ntfy_tax_id2.value;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			
			if(!ComIsNull(formObj.caed_ctnt2.value)){
				formObj.caed_ctnt.value=formObj.caed_ctnt2.value;
				formObj.caed_tp_cd[0].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.g7_edi_no2.value)){
				formObj.g7_edi_ctnt.value=formObj.g7_edi_no2.value;
				formObj.caed_tp_cd[1].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.mf_smry_rpt_ctnt2.value)){
				formObj.mf_smry_rpt_no.value=formObj.mf_smry_rpt_ctnt2.value;
				formObj.caed_tp_cd[2].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.b13a_xpt_ctnt2.value)){
				formObj.b13a_xpt_ctnt.value=formObj.b13a_xpt_ctnt2.value;
				formObj.caed_tp_cd[3].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.cgo_ctrl_no2.value)){
				formObj.cgo_ctrl_no.value=formObj.cgo_ctrl_no2.value;
				formObj.caed_tp_cd[4].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.ndr_ref_id2.value)){
				formObj.ndr_ref_id.value=formObj.ndr_ref_id2.value;
				formObj.caed_tp_cd[5].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(!ComIsNull(formObj.ndr_ref_ctnt2.value)){
				formObj.ndr_ref_ctnt.value=formObj.ndr_ref_ctnt2.value;	
				formObj.caed_tp_cd[5].checked=true;
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			if(div2sheet1.GetTotalRows()>0){
				for(var i=1;i<div2sheet1.GetTotalRows()+ 1;i++){
					var isInsert="true";
					for(var j=1;j<div1sheet1.GetTotalRows()+ 1;j++){
						if(div1sheet1.GetCellValue(j, "xpt_lic_no")==div2sheet1.GetCellValue(i, "xpt_lic_no2")){
							div1sheet1.SetRowStatus(j,"U");
							div1sheet1.SetCellValue(j, "bkg_no",formObj.bkg_no.value,0);
							div1sheet1.SetCellValue(j, "io_bnd_cd",div2sheet1.GetCellValue(i, "io_bnd_cd2"),0);
							div1sheet1.SetCellValue(j, "cnt_cd",div2sheet1.GetCellValue(i, "cnt_cd2"),0);
							div1sheet1.SetCellValue(j, "ts_ref_no",div2sheet1.GetCellValue(i, "ts_ref_no2"),0);
							div1sheet1.SetCellValue(j, "pck_qty",div2sheet1.GetCellValue(i, "pck_qty2"),0);
							div1sheet1.SetCellValue(j, "pck_tp_cd",div2sheet1.GetCellValue(i, "pck_tp_cd2"),0);
							div1sheet1.SetCellValue(j, "mf_wgt",div2sheet1.GetCellValue(i, "mf_wgt2"),0);
							div1sheet1.SetCellValue(j, "wgt_ut_cd",div2sheet1.GetCellValue(i, "wgt_ut_cd2"),0);
							div1sheet1.SetCellValue(j, "divd_seq",div2sheet1.GetCellValue(i, "divd_seq2"),0);
							div1sheet1.SetCellValue(j, "sam_pck_id",div2sheet1.GetCellValue(i, "sam_pck_id2"),0);
							div1sheet1.SetCellValue(j, "sam_pck_qty",div2sheet1.GetCellValue(i, "sam_pck_qty2"),0);
							div1sheet1.SetCellValue(j, "sam_pck_tp_cd",div2sheet1.GetCellValue(i, "sam_pck_tp_cd2"),0);
							isInsert="false"
							break;
						} else {
							isInsert="true";
						}
					}
					if(isInsert=="true"){
						var newRow=div1sheet1.DataInsert(-1);
						div1sheet1.SetRowStatus(newRow,"U");
						div1sheet1.SetCellValue(newRow, "bkg_no",formObj.bkg_no.value,0);
						div1sheet1.SetCellValue(newRow, "io_bnd_cd",div2sheet1.GetCellValue(i, "io_bnd_cd2"),0);
						div1sheet1.SetCellValue(newRow, "cnt_cd",div2sheet1.GetCellValue(i, "cnt_cd2"),0);
						div1sheet1.SetCellValue(newRow, "xpt_lic_no",div2sheet1.GetCellValue(i, "xpt_lic_no2"),0);
						div1sheet1.SetCellValue(newRow, "ts_ref_no",div2sheet1.GetCellValue(i, "ts_ref_no2"),0);
						div1sheet1.SetCellValue(newRow, "pck_qty",div2sheet1.GetCellValue(i, "pck_qty2"),0);
						div1sheet1.SetCellValue(newRow, "pck_tp_cd",div2sheet1.GetCellValue(i, "pck_tp_cd2"),0);
						div1sheet1.SetCellValue(newRow, "mf_wgt",div2sheet1.GetCellValue(i, "mf_wgt2"),0);
						div1sheet1.SetCellValue(newRow, "wgt_ut_cd",div2sheet1.GetCellValue(i, "wgt_ut_cd2"),0);
						div1sheet1.SetCellValue(newRow, "divd_seq",div2sheet1.GetCellValue(i, "divd_seq2"),0);
						div1sheet1.SetCellValue(newRow, "sam_pck_id",div2sheet1.GetCellValue(i, "sam_pck_id2"),0);
						div1sheet1.SetCellValue(newRow, "sam_pck_qty",div2sheet1.GetCellValue(i, "sam_pck_qty2"),0);
						div1sheet1.SetCellValue(newRow, "sam_pck_tp_cd",div2sheet1.GetCellValue(i, "sam_pck_tp_cd2"),0);
					}
				}
			}
			if(sheetObject1.GetTotalRows()>0){
				getBtnObject("btn_ExportInfo").style.color="blue";
			}
			setExportInfoToSheet();
			if(!ComIsNull(formObj.bkpo2.value)) 	formObj.bkpo.value=formObj.bkpo2.value;
			if(!ComIsNull(formObj.lcno2.value)) 	formObj.lcno.value=formObj.lcno2.value;
			if(!ComIsNull(formObj.hinv2.value)) 	formObj.hinv.value=formObj.hinv2.value;
			if(!ComIsNull(formObj.lcdt2.value)) 	formObj.lcdt.value=formObj.lcdt2.value;
			if(!ComIsNull(formObj.hpdp2.value)) 	formObj.hpdp.value=formObj.hpdp2.value;
			if(!ComIsNull(formObj.othr2.value)) 	formObj.othr.value=formObj.othr2.value;
			if(div4sheet1.GetTotalRows()>0){
				for(var i=1;i<div4sheet1.GetTotalRows()+ 1;i++){
					var isInsert="true";
					for(var j=1;j<div3sheet1.GetTotalRows()+ 1;j++){
						if(div3sheet1.GetCellValue(j, "c_cntr_no")==div4sheet1.GetCellValue(i, "cntr_no")){
							div3sheet1.SetRowStatus(j,"U");
							div3sheet1.SetCellValue(j, "cust_ref_no_ctnt",div4sheet1.GetCellValue(i, "po_no"),0);
							if("D"==div3sheet1.GetRowStatus(j)){
								isInsert="true"
								break;
							}						
							isInsert="false"
							break;
						} else {
							isInsert="true";
						}
					}
					if(isInsert=="true"){
						var newRow=div3sheet1.DataInsert(-1);
						div3sheet1.SetRowStatus(newRow,"I");
						div3sheet1.SetCellValue(newRow, "c_cntr_no",div4sheet1.GetCellValue(i, "cntr_no"),0);
						div3sheet1.SetCellValue(newRow, "cust_ref_no_ctnt",div4sheet1.GetCellValue(i, "po_no"),0);
					}
				}
			}
			if(div4sheet2.GetTotalRows()>0){
				for(var i=1;i<div4sheet2.GetTotalRows()+ 1;i++){
					var isInsert="true";
					for(var j=1;j<div3sheet2.GetTotalRows()+ 1;j++){
						if(div3sheet2.GetCellValue(j, "cntr_no")==div4sheet2.GetCellValue(i, "cntr_no") && div3sheet2.GetCellValue(j, "po_no")==div4sheet2.GetCellValue(i, "po_no") && div3sheet2.GetCellValue(j, "seq")==div4sheet2.GetCellValue(i, "seq")){
							if("D"==div3sheet2.GetRowStatus(j)){
								isInsert="true"
								break;
							}						
							div3sheet2.SetRowStatus(j,"U");
							div3sheet2.SetCellValue(j, "cntr_no",div4sheet2.GetCellValue(i, "cntr_no"),0);
							div3sheet2.SetCellValue(j, "po_no",div4sheet2.GetCellValue(i, "po_no"),0);
							div3sheet2.SetCellValue(j, "itm_no",div4sheet2.GetCellValue(i, "itm_no"),0);
							div3sheet2.SetCellValue(j, "itm_desc",div4sheet2.GetCellValue(i, "itm_desc"),0);
							div3sheet2.SetCellValue(j, "pck_qty",div4sheet2.GetCellValue(i, "pck_qty"),0);
							div3sheet2.SetCellValue(j, "pck_tp_cd",div4sheet2.GetCellValue(i, "pck_tp_cd"),0);
							div3sheet2.SetCellValue(j, "cntr_wgt",div4sheet2.GetCellValue(i, "cntr_wgt"),0);
							div3sheet2.SetCellValue(j, "wgt_ut_cd",div4sheet2.GetCellValue(i, "wgt_ut_cd"),0);
							div3sheet2.SetCellValue(j, "meas_qty",div4sheet2.GetCellValue(i, "meas_qty"),0);
							div3sheet2.SetCellValue(j, "meas_ut_cd",div4sheet2.GetCellValue(i, "meas_ut_cd"),0);
							isInsert="false"
							break;
						} else {
							isInsert="true";
						}
					}
					if(isInsert=="true"){
						var newRow=div3sheet2.DataInsert(-1);
						div3sheet2.SetRowStatus(newRow,"I");
						div3sheet2.SetCellValue(newRow, "cntr_no",div4sheet2.GetCellValue(i, "cntr_no"),0);
						div3sheet2.SetCellValue(newRow, "po_no",div4sheet2.GetCellValue(i, "po_no"),0);
						div3sheet2.SetCellValue(newRow, "itm_no",div4sheet2.GetCellValue(i, "itm_no"),0);
						div3sheet2.SetCellValue(newRow, "itm_desc",div4sheet2.GetCellValue(i, "itm_desc"),0);
						div3sheet2.SetCellValue(newRow, "pck_qty",div4sheet2.GetCellValue(i, "pck_qty"),0);
						div3sheet2.SetCellValue(newRow, "pck_tp_cd",div4sheet2.GetCellValue(i, "pck_tp_cd"),0);
						div3sheet2.SetCellValue(newRow, "cntr_wgt",div4sheet2.GetCellValue(i, "cntr_wgt"),0);
						div3sheet2.SetCellValue(newRow, "wgt_ut_cd",div4sheet2.GetCellValue(i, "wgt_ut_cd"),0);
						div3sheet2.SetCellValue(newRow, "meas_qty",div4sheet2.GetCellValue(i, "meas_qty"),0);
						div3sheet2.SetCellValue(newRow, "meas_ut_cd",div4sheet2.GetCellValue(i, "meas_ut_cd"),0);
					}
				}			
			}
			div3sheet1_OnClick(div3sheet1, 1, 1, "");
			var cntrPo=false;
			for(var i=1;i<div3sheet1.RowCount()+ 1;i++){
				if(div3sheet1.GetCellValue(i, "cust_ref_no_ctnt").length>1 && ComTrim(div3sheet1.GetCellValue(i, "cust_ref_no_ctnt"))!=null){
					cntrPo=true;
					break;
				}
			}
			if(cntrPo == true||div3sheet2.RowCount() > 0 ||((formObj.bkpo.value+formObj.hinv.value+formObj.hpdp.value+formObj.lcno.value+formObj.lcdt.value+formObj.othr.value).lenght>1)){
				getBtnObject("btn_POOtherNo").style.color="blue";
			} else {
				getBtnObject("btn_POOtherNo").style.color="#737373";
			}
			compareItem();
			isCopy="true";
			if (div1sheet1.RowCount() > 0) {
				div1sheet1.SetCellValue(div1sheet1.LastRow(), 1,"",0);
				div1sheet1.SetCellValue(div1sheet1.LastRow(), "ts_ref_no","TOTAL",0);
				div1sheet1.SetCellAlign(div1sheet1.LastRow(), "ts_ref_no","Center");
			}
			
			if (parent.frames["t1frame"].document.form) {
				if (formObj.wgt_ut_cd.value != null && formObj.wgt_ut_cd.value != "") {
					parent.frames["t1frame"].wgt_ut_cd.SetSelectCode(formObj.wgt_ut_cd.value);
				}				
			}
			for (var i = shipIdSheet2.HeaderRows(); i <= shipIdSheet2.RowCount(); i++) {
				var refNo = shipIdSheet2.GetCellValue(i, "ref_no");
				var check = true;
				for (var j = shipIdSheet1.HeaderRows(); j <= shipIdSheet1.RowCount(); j++) {
					var deNo = shipIdSheet1.GetCellValue(j, "de_no");
					if(deNo == refNo){
						check = false;
						break;
					}
				}
				if(check){
					var newRow = shipIdSheet1.DataInsert(-1);
					shipIdSheet1.SetRowStatus(newRow, "I");
					shipIdSheet1.SetCellValue(newRow, "de_no", refNo,0);
				}
			}
			
			
			break;
		case IBSEARCH_ASYNC03: //Data Copy From CM
			if (!parent.frames["t5frame"].document.form) {
				ComShowCodeMessage("BKG00068", "C/M data");
				return;
			}
			var cmSheet=parent.frames["t5frame"].sheetObjects[0];
			var seq=0;
			var pck_qty=0;
			var act_wgt=0;
			var meas_qty=0;
			var desc_all="";
			var mns_all="";
			var pck_tp_cd=formObj.pck_tp_cd.value;
			var samePckCd=true;
			var wgt_ut_cd=formObj.wgt_ut_cd.value;
			var sameWgtCd=true;
			var meas_ut_cd=formObj.meas_ut_cd.value;
			var sameMeasCd=true;
			if (cmSheet.GetTotalRows()> 0) {
				for ( var i=0; i < cmSheet.GetTotalRows(); i++) {
					if (pck_tp_cd == cmSheet.GetCellValue(parseInt(seq + 5), "pck_tp_cd")) {
						pck_qty += parseInt(cmSheet.GetCellValue(parseInt(seq + 5), "pck_qty"));
					} else {
						samePckCd=false;
					}
					if (wgt_ut_cd == cmSheet.GetCellValue(parseInt(seq + 5), "wgt_ut_cd")) {
						act_wgt += parseFloat(cmSheet.GetCellValue(parseInt(seq + 5), "cntr_mf_wgt"));
					} else {
						sameWgtCd=false;
					}
					if (meas_ut_cd == cmSheet.GetCellValue(parseInt(seq + 5), "meas_ut_cd")) {
						meas_qty += parseFloat(cmSheet.GetCellValue(parseInt(seq + 5), "meas_qty"));
					} else {
						sameMeasCd=false;
					}
					desc_all += cmSheet.GetCellValue(parseInt(seq + 7), "cntr_mf_dtl_desc1") + "\r\n";
					mns_all += cmSheet.GetCellValue(parseInt(seq + 9), "cntr_mf_mk_desc1") + "\r\n";
					seq += 5;
				}
				if (samePckCd){
					formObj.pck_qty.value=pck_qty;
				} else {
					formObj.pck_qty.value=ComAddComma(parseInt(cmSheet.GetCellValue(5, "pck_qty")), "#,###");
				}
				if (sameWgtCd) {
					formObj.act_wgt.value=act_wgt;
				} else {
					formObj.act_wgt.value=ComAddComma(parseFloat(cmSheet.GetCellValue(5, "cntr_mf_wgt")), "#,###.000");
				}
				if (sameMeasCd){
					formObj.meas_qty.value=meas_qty;
				} else {
					formObj.meas_qty.value=ComAddComma(parseFloat(cmSheet.GetCellValue(5, "meas_ut_cd")), "#,###.000");
				}
				formObj.dg_cmdt_desc.value=desc_all;
				formObj.mk_desc.value=mns_all;
			}
			compareItem();
			break;
		case IBCOPYROW:      // copy 
			if(ComGetObjValue(parent.frames["t1frame"].document.form.rcv_term_cd) !="S"){
				var var_cntr_cmdt_desc="";
				var qtySheet=parent.frames["t1frame"].sheetObjects[0];
				var only1cntr=true;
				for(var qtyIdx=1; qtyIdx<qtySheet.LastRow()+1; qtyIdx++){
					for(var i=0; i<cntrTpSzDesc.length; i++) {
						if((cntrTpSzDesc[i]!=undefined))
						{
							if (qtySheet.GetCellValue(qtyIdx, "cntr_tpsz_cd") == (cntrTpSzDesc[i][0])) {
								var tpszDesc=qtySheet.GetCellValue(qtyIdx, "op_cntr_qty") + "X" + cntrTpSzDesc[i][1];
								if(parseInt(qtySheet.GetCellValue(qtyIdx, "op_cntr_qty"))>1) only1cntr=false;
								if(var_cntr_cmdt_desc==""){
									var_cntr_cmdt_desc=tpszDesc;
								} else {
									var_cntr_cmdt_desc=var_cntr_cmdt_desc + ", " + tpszDesc;
								}
							}
						}	
					}
				}
				if(var_cntr_cmdt_desc!=""){
					if(only1cntr){
						formObj.cntr_cmdt_desc.value=var_cntr_cmdt_desc + " CONTAINER SAID TO CONTAIN:";
					} else {
						formObj.cntr_cmdt_desc.value=var_cntr_cmdt_desc + " CONTAINER(S) SAID TO CONTAIN:";	
					}
				}
			}
			getPckDesc();
			formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\r\n" + formObj.cstms_desc.value;
			break;
		} // end of switch
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if(parent.frames["t1frame"].document.form.doc_tp_cd.value =="S"){
			if (ComIsEmpty(formObj.pck_qty.value) || formObj.pck_qty.value == '0') {
				ComShowMessage(ComGetMsg('BKG00505'));
				ComSetFocus(formObj.pck_qty);
				return false;
			}
			if (ComIsEmpty(formObj.pck_tp_cd.value)) {
				ComShowMessage(ComGetMsg('BKG00504'));
				ComSetFocus(formObj.pck_tp_cd);
				return false;
			}
			if(ComTrim(formObj.cstms_desc.value)==""||formObj.cstms_desc.value==null){
				ComShowMessage(ComGetMsg('BKG00767', "[Customs Description]"));  
				ComSetFocus(formObj.cstms_desc);
				return false;
			}		
		}
		if (ComIsEmpty(formObj.act_wgt.value)||formObj.act_wgt.value == "0" ||formObj.act_wgt.value=="0.000") {
			formObj.act_wgt.value=parent.frames["t1frame"].document.form.act_wgt.value;
		}
		if (parent.frames["t1frame"].form.doc_tp_cd.value == "S" &&
			parent.frames["t2frame"].form &&
			parent.frames["t2frame"].form.kr_cstms_cust_tp_cd.value== "S"){
			if(formObj.act_wgt.value.replace(/,/g, "") != formObj.act_wgt2.value.replace(/,/g, "") || formObj.pck_qty.value.replace(/,/g, "") != formObj.pck_qty2.value.replace(/,/g, "") ){
				var msg="There is one more discrepancy of quantity OPUS and E-SVC.\n";
				msg=msg + "[OPUS] PKG : " + formObj.pck_qty.value + " " + formObj.pck_tp_cd.value + " / " +
						       	   "WGT : " + formObj.act_wgt.value + " " + ComGetObjValue(formObj.wgt_ut_cd) + "\n" +
							"[E-SVC] PKG : " + formObj.pck_qty2.value + " " + formObj.pck_tp_cd2.value + " / " +
							       "WGT : " + formObj.act_wgt2.value + " " + ComGetObjValue(formObj.wgt_ut_cd2);
				if (!ComShowConfirm(msg)) {
					return false;
				}
			}
		}
		var size=formObj.aes_tp_cd.length;
		for(var i=0; i < size; i++) {
			if(formObj.aes_tp_cd[i].checked) {
				var objs=document.all.item("showXptLicNo");
				if (formObj.aes_tp_cd[i].value=="EX" && ComGetObjValue(formObj.aes_expt_id)!="" && formObj.aes_expt_ctnt.value!=""){
	        		document.all.showXptLicNo.style.visibility='visible';
	        		div1sheet1.SetVisible(1);
		         	ComAlertFocus(formObj.aes_expt_id, ComGetMsg("BKG00198"));
					return false;
				}		
				switch(formObj.aes_tp_cd[i].value) {
			        case "AE":     
			        	if(formObj.aes_inlnd_trns_no.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		div1sheet1.SetVisible(1);
			        		ComAlertFocus(formObj.aes_inlnd_trns_no, ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	if(!ComIsAesNo(formObj.aes_inlnd_trns_no.value)){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_inlnd_trns_no, ComGetMsg("COM12128","a valid format : ANNNNNNNNNNNNN"));		        		
			        		return false;
			        	}else{
			        		var re=new RegExp('([A-Z][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
			        		formObj.aes_inlnd_trns_no.value=formObj.aes_inlnd_trns_no.value.replace(re,'$1').toUpperCase();
			        	}
			        	break;
			        case "PA": 
			        	if(formObj.aes_pta_no1.value==''||formObj.aes_pta_no1.value.length<9){
			        		document.all.showXptLicNo.style.visibility='visible';
			             	ComAlertFocus(formObj.aes_pta_no1,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	if(formObj.aes_pta_no2.value==''||formObj.aes_pta_no2.value.length<9){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_pta_no2,  ComGetMsg("COM12114"));
			        		return false; 
			        	}
			        	if(formObj.aes_pta_dt.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_pta_dt,  ComGetMsg("COM12114"));
			        		return false;
			        	}	
		        	 	var sVal=ComTrimAll(formObj.aes_pta_dt.value, "-", "/", ".");
		                if (!ComIsDateMod(formObj.aes_pta_dt.value)){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_pta_dt,  ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
			        		return false;
		                } else {
		                	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                	formObj.aes_pta_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                }		                    
		                break;
			        case "PU":
			        	if(formObj.aes_ptu_no.value==''||formObj.aes_ptu_no.value.length<9){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_ptu_no,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	if(formObj.aes_ptu_dt.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_ptu_dt,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	var sVal=ComTrimAll(formObj.aes_ptu_dt.value, "-", "/", ".");
		                if (!ComIsDateMod(formObj.aes_ptu_dt.value)){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_ptu_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
			        		return false;
		                }else{
		                	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                	formObj.aes_ptu_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                }		
			        	break;
			        case "DN":				        	 
			        	if(formObj.aes_dwn_no.value==''||formObj.aes_dwn_no.value.length<9){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_dwn_no,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	if(formObj.aes_dwn_dt.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_dwn_dt,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	var sVal=ComTrimAll(formObj.aes_dwn_dt.value, "-", "/", ".");
		                if (!ComIsDateMod(formObj.aes_dwn_dt.value)){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_dwn_dt, ComGetMsg("COM12187","MM-DD-YYYY"));				        		 
			        		return false;
		                } else {
		                	var re=new RegExp('([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9])');
		                	formObj.aes_dwn_dt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
		                }		
			        	break;
			        case "EX":
			        	if(aes_expt_id.GetSelectCode()==''&&formObj.aes_expt_ctnt.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.aes_expt_id,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	break;
			 	}
		  	}
		}
		size=formObj.caed_tp_cd.length;	
		for(var i=0; i < size; i++) {
			if(formObj.caed_tp_cd[i].checked) {
				var objs=document.all.item("showXptLicNo");
				switch(formObj.caed_tp_cd[i].value) {
			        case "CE":     
			        	if(formObj.caed_ctnt.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.caed_ctnt, ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	var sVal=ComTrimAll(formObj.caed_ctnt.value, "-", "/", ".");
			        	if (!ComIsCaedNo(sVal)){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.caed_ctnt, ComGetMsg("COM12128","a valid format : NNANNN(6) - AANNNN(6) - NNNNNNNNNNN(11)"));				        		 
			        		return false;
			        	}else{
			        		var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
			        		formObj.caed_ctnt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3').toUpperCase();
			        	}
			        	break;
			        case "G7": 
			        	if(formObj.g7_edi_ctnt.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			             	ComAlertFocus(formObj.g7_edi_ctnt, ComGetMsg("COM12114"));
			        		return false;
			        	}	        	 
		        	 	var sVal=ComTrimAll(formObj.g7_edi_ctnt.value, "-", "/", ".");
		                if (!ComIsG7EdiNo(sVal)){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.g7_edi_ctnt, ComGetMsg("COM12128","a valid format : NNANNN(6) - NNNNNNNNNNN(11)"));				        		 
			        		return false;
		                }else{
		                	var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
		                	formObj.g7_edi_ctnt.value=sVal.replace(re,'$1' + "-" + '$2');
		                }		                    
		                break;
			        case "SM":
			        	if(formObj.mf_smry_rpt_no.value==''){
			        		document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.mf_smry_rpt_no,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	 if(formObj.mf_smry_rpt_no.value.length<4){
				        	document.all.showXptLicNo.style.visibility='visible';
			        		ComAlertFocus(formObj.mf_smry_rpt_no,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	 if(formObj.mf_smry_rpt_no.value.length>4){
					        	document.all.showXptLicNo.style.visibility='visible';
				        		ComAlertFocus(formObj.mf_smry_rpt_no,  ComGetMsg("COM12114"));
				        		return false;
				        	}
			        	break;
			        case "EX":				        	 
			        	if(formObj.b13a_xpt_ctnt.value==''){	
			        		document.all.showXptLicNo.style.visibility='visible';		
			        		ComAlertFocus(formObj.b13a_xpt_ctnt,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	var sVal=ComTrimAll(formObj.b13a_xpt_ctnt.value, "-", "/", " ",":");
//		                if (!ComIsB13aXptNo(sVal)){
//			        		document.all.showXptLicNo.style.visibility='visible';		
//			        		ComAlertFocus(formObj.b13a_xpt_ctnt, ComGetMsg("COM12128","a valid format : YYYY/MM/DD HH:MI  NNN(3) - NNNNNN (6)"));				        		 
//			        		return false;
//		                } else { 
//		                	var re=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
//		                	formObj.b13a_xpt_ctnt.value=sVal.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
//		                }		
			        	break;
			        case "IT":
			        	if(formObj.cgo_ctrl_no.value==''){	
			        		document.all.showXptLicNo.style.visibility='visible';		
			        		ComAlertFocus(formObj.cgo_ctrl_no,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	break;
			        case "ND":
			        	if(comboObjects[1].GetSelectCode()==''){
			        		document.all.showXptLicNo.style.visibility='visible';		
			        		ComAlertFocus(formObj.ndr_ref_id,  ComGetMsg("COM12114"));
			        		return false;
			        	}
			        	break;
			 	}
		  	}
		}
		//Korea
	    var Value=Value2="";
	    var pkg=sumQty=0;
		var wgt=0.000;
		var T=Number("1e"+1);
		for (var j=1; j<div1sheet1.RowCount()+1; j++) {
			ibflag=div1sheet1.GetCellValue(j,"ibflag");
			Value=div1sheet1.GetCellValue(j,"xpt_lic_no");
			Value2=div1sheet1.GetCellValue(j,"ts_ref_no");
			if ("D"!=ibflag) {
				pkg += parseInt(div1sheet1.GetCellValue(j,"pck_qty"));
				wgt += parseFloat(div1sheet1.GetCellValue(j,"mf_wgt"));
			}
			sumQty=Math.round((pkg + wgt) * T) / T;;
			if ("I"==ibflag || "U"==ibflag) {
				if (""==Value && ""==Value2) {
	             	ComShowCodeMessage("COM12138","Export License Number","Other Reference No.");
	             	div1sheet1.SelectCell(j,"xpt_lic_no");
					return false;
				}
				if (0<Value.length && 14>Value.length) {
					ComShowCodeMessage("BKG00257");
					div1sheet1.SelectCell(j,"xpt_lic_no");
					return false;
				} else if (14<Value.length) {
					var total=0;
					for (var i=1; i<15; i++) {
						switch (i%3) {
							case 1:
								total += parseInt(((Value.substring(i-1,i)*7)%10));
								break;	
							case 2:
								total += parseInt(((Value.substring(i-1,i)*3)%10));
								break;
							case 0:
								total += parseInt((Value.substring(i-1,i)*1));
								break;
						}
					}
					chkDigit = (10-(total%10))%10;
					if (15==Value.length) {
			 			if (chkDigit != Value.substring(14,15)) {
			             	ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
			             	div1sheet1.SetCellValue(j,"xpt_lic_no",Value.substring(0,14));
			             	div1sheet1.SelectCell(j,"xpt_lic_no");
			 				return false;
			 			}
			 		} else {
			 			div1sheet1.SetCellValue(j,"xpt_lic_no",Value+chkDigit,0);
			 		}
				}
			}
		}
		//  E-BKG & SI Validation 
		if (div1sheet1.RowCount()> 0) {
			var bkg_pck_qty=formObj.pck_qty.value.replace(",", "");
			var bkg_act_wgt=formObj.act_wgt.value.replace(",", "");
			var exp_pck_qty=div1sheet1.ComputeSum("|9|");
			var exp_mf_wgt=div1sheet1.ComputeSum("|11|");
			if (bkg_pck_qty != exp_pck_qty || bkg_act_wgt != exp_mf_wgt) {
				var mText=new Array(bkg_pck_qty, bkg_act_wgt, exp_pck_qty, exp_mf_wgt.toFixed(3));
				if (!ComShowCodeConfirm2("BKG00199", mText)) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * CLICK the Upload button call 
	 */
	function validateForUpload() {
		var formObj=document.form;
		if(validateForm(sheetObject1, formObj, IBSAVE)==false){
			return false;
		}
		return true;
	}
	/**
	 * CLICK the Upload button call 
	 */
	function getSaveStringForUpload() {
		var formObj=document.form;
		var sXml=formObj.sXml.value;
		formObj.sXml.value="";
		formObj.f_cmd.value=MULTI;
		ComClearSeparator(formObj.pck_qty);
		ComClearSeparator(formObj.act_wgt);
		ComClearSeparator(formObj.meas_qty);
		setExportInfoToSheet();
		setPoOtherNoToSheet();
		
		ComSetObjValue(formObj.mk_desc, chekcSpecialValue(ComGetObjValue(formObj.mk_desc)));
		ComSetObjValue(formObj.cstms_desc, chekcSpecialValue(ComGetObjValue(formObj.cstms_desc)));
		ComSetObjValue(formObj.dg_cmdt_desc, chekcSpecialValue(ComGetObjValue(formObj.dg_cmdt_desc)));
		
		var params=FormQueryString(formObj);
		params=params + "&" + ComSetPrifix(sheetObject1.GetSaveString(true), "sheet1_");
		params=params + "&" + ComSetPrifix(div3sheet3.GetSaveString(true), "sheet2_");
		params=params + "&" + ComSetPrifix(div3sheet1.GetSaveString(true), "sheet3_");
		params=params + "&" + ComSetPrifix(div3sheet2.GetSaveString(true), "sheet4_");
		params=params + "&" + ComSetPrifix(shipIdSheet1.GetSaveString(true), "sheet5_");
		// M&D Rout need
		params=params + "&" + "por_cd=" + parent.frames["t1frame"].document.form.bkg_por_cd.value;
		params=params + "&" + "pol_cd=" + parent.frames["t1frame"].document.form.bkg_pol_cd.value;
		params=params + "&" + "pod_cd=" + parent.frames["t1frame"].document.form.bkg_pod_cd.value;
		params=params + "&" + "del_cd=" + parent.frames["t1frame"].document.form.bkg_del_cd.value;
		formObj.sXml.value=sXml;
		return (params);
	} 
	function compareItem() {
		var formObj=document.form;
		setDiffCheckColor(formObj.mk_desc.value,   	formObj.mk_desc2.value,   "mk_desc2");
		setDiffCheckColor(formObj.pck_qty.value,   	formObj.pck_qty2.value,   "pck_qty2");
		setDiffCheckColor(formObj.pck_tp_cd.value, 	formObj.pck_tp_cd2.value, "pck_tp_cd2");
		setDiffCheckColor(formObj.act_wgt.value,   	formObj.act_wgt2.value,   "act_wgt2");
		setDiffCheckColor(formObj.wgt_ut_cd.value, 	formObj.wgt_ut_cd2.value, "wgt_ut_cd2");
		setDiffCheckColor(formObj.meas_qty.value,  	formObj.meas_qty2.value,  "meas_qty2");
		setDiffCheckColor(formObj.meas_ut_cd.value, formObj.meas_ut_cd2.value,  "meas_ut_cd2");
		setDiffCheckColor(formObj.dg_cmdt_desc.value, formObj.dg_cmdt_desc2.value, "dg_cmdt_desc2");
	}
	function dataCopy() {
	 	doActionIBSheet(sheetObject1, document.form, IBSEARCH_ASYNC02);
		//ComBtnColor("btn_cancelcopydata", "#737373");
		//ComBtnColor("btn_datacopytoopus", "blue");	
		
		document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;;font-weight:bold;";
		document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;;font-weight:normal;";
	}
	function getExportInfoToForm(){
		var formObj=document.form;
		for(var i=1; i<=sheetObject1.LastRow(); i++){	
			if(sheetObject1.GetCellValue(i, "cnt_cd")=="KR"){
				var newRow=div1sheet1.DataInsert(-1);
				div1sheet1.SetRowStatus(newRow,"U");
				div1sheet1.SetCellValue(newRow, "Check",sheetObject1.GetCellValue(i, "Check"),0);
				div1sheet1.SetCellValue(newRow, "bkg_no",sheetObject1.GetCellValue(i, "bkg_no"),0);
				div1sheet1.SetCellValue(newRow, "io_bnd_cd",sheetObject1.GetCellValue(i, "io_bnd_cd"),0);
				div1sheet1.SetCellValue(newRow, "xpt_imp_seq",sheetObject1.GetCellValue(i, "xpt_imp_seq"),0);
				div1sheet1.SetCellValue(newRow, "cnt_cd",sheetObject1.GetCellValue(i, "cnt_cd"),0);
				div1sheet1.SetCellValue(newRow, "xpt_lic_no",sheetObject1.GetCellValue(i, "xpt_lic_no"),0);
				div1sheet1.SetCellValue(newRow, "ts_ref_no",sheetObject1.GetCellValue(i, "ts_ref_no"),0);
				div1sheet1.SetCellValue(newRow, "pck_qty",sheetObject1.GetCellValue(i, "pck_qty"),0);
				div1sheet1.SetCellValue(newRow, "pck_tp_cd",sheetObject1.GetCellValue(i, "pck_tp_cd"),0);
				div1sheet1.SetCellValue(newRow, "mf_wgt",sheetObject1.GetCellValue(i, "mf_wgt"),0);
				div1sheet1.SetCellValue(newRow, "wgt_ut_cd",sheetObject1.GetCellValue(i, "wgt_ut_cd"),0);
				div1sheet1.SetCellValue(newRow, "divd_seq",sheetObject1.GetCellValue(i, "divd_seq"),0);
				div1sheet1.SetCellValue(newRow, "sam_pck_id",sheetObject1.GetCellValue(i, "sam_pck_id"),0);
				div1sheet1.SetCellValue(newRow, "sam_pck_qty",sheetObject1.GetCellValue(i, "sam_pck_qty"),0);
				div1sheet1.SetCellValue(newRow, "sam_pck_tp_cd",sheetObject1.GetCellValue(i, "sam_pck_tp_cd"),0);
			} else if(sheetObject1.GetCellValue(i, "cnt_cd")=="US"){
				if(sheetObject1.GetCellValue(i, "aes_tp_cd") == "AE"){
					formObj.aes_tp_cd[0].checked=true;
					formObj.aes_inlnd_trns_no.value=sheetObject1.GetCellValue(i, "aes_inlnd_trns_no");
				} else if(sheetObject1.GetCellValue(i, "aes_tp_cd") == "PA"){
					formObj.aes_tp_cd[1].checked=true;
					formObj.aes_pta_no1.value=sheetObject1.GetCellValue(i, "aes_pta_no1");
					formObj.aes_pta_no2.value=sheetObject1.GetCellValue(i, "aes_pta_no2");
					formObj.aes_pta_dt.value=sheetObject1.GetCellValue(i, "aes_pta_dt");
				} else if(sheetObject1.GetCellValue(i, "aes_tp_cd") == "PU"){
					formObj.aes_tp_cd[2].checked=true;
					formObj.aes_ptu_no.value=sheetObject1.GetCellValue(i, "aes_ptu_no");
					formObj.aes_ptu_dt.value=sheetObject1.GetCellValue(i, "aes_ptu_dt");
				} else if(sheetObject1.GetCellValue(i, "aes_tp_cd") == "DN"){
					formObj.aes_tp_cd[3].checked=true;
					formObj.aes_dwn_no.value=sheetObject1.GetCellValue(i, "aes_dwn_no");
					formObj.aes_dwn_dt.value=sheetObject1.GetCellValue(i, "aes_dwn_dt");
				} else if(sheetObject1.GetCellValue(i, "aes_tp_cd") == "EX"){
					formObj.aes_tp_cd[4].checked=true;
					comboObjects[0].SetSelectCode(sheetObject1.GetCellValue(i, "aes_expt_id"));
				}
				formObj.aes_expt_ctnt.value=sheetObject1.GetCellValue(i, "aes_expt_ctnt");
			} else if(sheetObject1.GetCellValue(i, "cnt_cd")=="MX"){
				formObj.mx_shpr_tax_id.value=sheetObject1.GetCellValue(i, "mx_shpr_tax_id");
				formObj.mx_cnee_tax_id.value=sheetObject1.GetCellValue(i, "mx_cnee_tax_id");
				formObj.mx_ntfy_tax_id.value=sheetObject1.GetCellValue(i, "mx_ntfy_tax_id");
			//
			} else if(sheetObject1.GetCellValue(i, "cnt_cd")=="TR"){
				formObj.tr_shpr_tax_id.value=sheetObject1.GetCellValue(i, "tr_shpr_tax_id");
				formObj.tr_cnee_tax_id.value=sheetObject1.GetCellValue(i, "tr_cnee_tax_id");
				formObj.tr_ntfy_tax_id.value=sheetObject1.GetCellValue(i, "tr_ntfy_tax_id");
			} else if(sheetObject1.GetCellValue(i, "cnt_cd")=="IL"){
				formObj.il_shpr_tax_id.value=sheetObject1.GetCellValue(i, "il_shpr_tax_id");
				formObj.il_cnee_tax_id.value=sheetObject1.GetCellValue(i, "il_cnee_tax_id");
				formObj.il_ntfy_tax_id.value=sheetObject1.GetCellValue(i, "il_ntfy_tax_id");
			} else if(sheetObject1.GetCellValue(i, "cnt_cd")=="LB"){
				formObj.lb_shpr_tax_id.value=sheetObject1.GetCellValue(i, "lb_shpr_tax_id");
				formObj.lb_cnee_tax_id.value=sheetObject1.GetCellValue(i, "lb_cnee_tax_id");
				formObj.lb_ntfy_tax_id.value=sheetObject1.GetCellValue(i, "lb_ntfy_tax_id");
			} else if(sheetObject1.GetCellValue(i, "cnt_cd")=="BR"){
				formObj.br_shpr_tax_id.value=sheetObject1.GetCellValue(i, "br_shpr_tax_id");
				formObj.br_cnee_tax_id.value=sheetObject1.GetCellValue(i, "br_cnee_tax_id");
				formObj.br_ntfy_tax_id.value=sheetObject1.GetCellValue(i, "br_ntfy_tax_id");
				formObj.brz_decl_no.value    	= sheetObject1.GetCellValue(i, "brz_decl_no");
				formObj.brz_decl_cpy_desc_flg.value = sheetObject1.GetCellValue(i, "brz_decl_cpy_desc_flg");
				formObj.shpr_tax_cpy_desc_flg.value	= sheetObject1.GetCellValue(i, "shpr_tax_cpy_desc_flg");
				formObj.cnee_tax_cpy_desc_flg.value	= sheetObject1.GetCellValue(i, "cnee_tax_cpy_desc_flg");	
				formObj.ntfy_tax_cpy_desc_flg.value	= sheetObject1.GetCellValue(i, "ntfy_tax_cpy_desc_flg");
				
			} else if(sheetObject1.GetCellValue(i, "cnt_cd")=="CA"){
				
				if(sheetObject1.GetCellValue(i, "caed_tp_cd")=="CE"){
					formObj.caed_tp_cd[0].checked=true;
				} else if(sheetObject1.GetCellValue(i, "caed_tp_cd")=="G7"){
					formObj.caed_tp_cd[1].checked=true;
				} else if(sheetObject1.GetCellValue(i, "caed_tp_cd")=="SM"){
					formObj.caed_tp_cd[2].checked=true;
				} else if(sheetObject1.GetCellValue(i, "caed_tp_cd")=="EX"){
					formObj.caed_tp_cd[3].checked=true;
				} else if(sheetObject1.GetCellValue(i, "caed_tp_cd")=="IT"){
					formObj.caed_tp_cd[4].checked=true;
				} else if(sheetObject1.GetCellValue(i, "caed_tp_cd")=="ND"){
					formObj.caed_tp_cd[5].checked=true;	
				}
				formObj.caed_ctnt.value=sheetObject1.GetCellValue(i, "caed_ctnt");
				formObj.g7_edi_ctnt.value=sheetObject1.GetCellValue(i, "g7_edi_ctnt");
				formObj.b13a_xpt_ctnt.value=sheetObject1.GetCellValue(i, "b13a_xpt_ctnt");
				formObj.mf_smry_rpt_no.value=sheetObject1.GetCellValue(i, "mf_smry_rpt_no");
				formObj.cgo_ctrl_no.value=sheetObject1.GetCellValue(i, "cgo_ctrl_no");
				comboObjects[1].SetSelectCode(sheetObject1.GetCellValue(i, "ndr_ref_id"));
				formObj.ndr_ref_ctnt.value=sheetObject1.GetCellValue(i, "ndr_ref_ctnt");
			}
		}
	}
	function setExportInfoToSheet(){
		var formObj=document.form;
		var newRow=0;
		sheetObject1.RemoveAll();
		var usaExportData=formObj.aes_inlnd_trns_no.value  + formObj.aes_pta_no1.value + formObj.aes_pta_no2.value + formObj.aes_pta_dt.value + formObj.aes_ptu_no.value + formObj.aes_ptu_dt.value + formObj.aes_dwn_no.value + formObj.aes_dwn_dt.value + comboObjects[0].GetSelectText() + formObj.aes_expt_ctnt.value;
		if (usaExportData.length>0){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","US",0);
			if(formObj.aes_tp_cd[0].checked == true){
				sheetObject1.SetCellValue(newRow, "aes_tp_cd","AE",0);
			} else if(formObj.aes_tp_cd[1].checked == true){
				sheetObject1.SetCellValue(newRow, "aes_tp_cd","PA",0);
			} else if(formObj.aes_tp_cd[2].checked == true){
				sheetObject1.SetCellValue(newRow, "aes_tp_cd","PU",0);
			} else if(formObj.aes_tp_cd[3].checked == true){
				sheetObject1.SetCellValue(newRow, "aes_tp_cd","DN",0);
			} else if(formObj.aes_tp_cd[4].checked == true){
				sheetObject1.SetCellValue(newRow, "aes_tp_cd","EX",0);
			}
			sheetObject1.SetCellValue(newRow, "aes_inlnd_trns_no",formObj.aes_inlnd_trns_no.value,0);
			sheetObject1.SetCellValue(newRow, "aes_pta_no1",formObj.aes_pta_no1.value,0);
			sheetObject1.SetCellValue(newRow, "aes_pta_no2",formObj.aes_pta_no2.value,0);
			sheetObject1.SetCellValue(newRow, "aes_pta_dt",formObj.aes_pta_dt.value,0);
			sheetObject1.SetCellValue(newRow, "aes_ptu_no",formObj.aes_ptu_no.value,0);
			sheetObject1.SetCellValue(newRow, "aes_ptu_dt",formObj.aes_ptu_dt.value,0);
			sheetObject1.SetCellValue(newRow, "aes_dwn_no",formObj.aes_dwn_no.value,0);
			sheetObject1.SetCellValue(newRow, "aes_dwn_dt",formObj.aes_dwn_dt.value,0);
			sheetObject1.SetCellValue(newRow, "aes_expt_id",comboObjects[0].GetSelectCode(),0);
			sheetObject1.SetCellValue(newRow, "aes_expt_ctnt",formObj.aes_expt_ctnt.value,0);
		}
		var mexicoExportData=formObj.mx_shpr_tax_id.value  + formObj.mx_cnee_tax_id.value + formObj.mx_ntfy_tax_id.value;
		if(mexicoExportData.length>0){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","MX",0);
			sheetObject1.SetCellValue(newRow, "mx_shpr_tax_id",formObj.mx_shpr_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "mx_cnee_tax_id",formObj.mx_cnee_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "mx_ntfy_tax_id",formObj.mx_ntfy_tax_id.value,0);
		}
		//
		var turkeyExportData=formObj.tr_shpr_tax_id.value  + formObj.tr_cnee_tax_id.value + formObj.tr_ntfy_tax_id.value;
		if(turkeyExportData.length>0){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","TR",0);
			sheetObject1.SetCellValue(newRow, "tr_shpr_tax_id",formObj.tr_shpr_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "tr_cnee_tax_id",formObj.tr_cnee_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "tr_ntfy_tax_id",formObj.tr_ntfy_tax_id.value,0);
		}
		var israelExportData=formObj.il_shpr_tax_id.value  + formObj.il_cnee_tax_id.value + formObj.il_ntfy_tax_id.value;
		if(israelExportData.length>0){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","IL",0);
			sheetObject1.SetCellValue(newRow, "il_shpr_tax_id",formObj.il_shpr_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "il_cnee_tax_id",formObj.il_cnee_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "il_ntfy_tax_id",formObj.il_ntfy_tax_id.value,0);
		}
		var lebanonExportData=formObj.lb_shpr_tax_id.value  + formObj.lb_cnee_tax_id.value + formObj.lb_ntfy_tax_id.value;
		if(lebanonExportData.length>0){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","LB",0);
			sheetObject1.SetCellValue(newRow, "lb_shpr_tax_id",formObj.lb_shpr_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "lb_cnee_tax_id",formObj.lb_cnee_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "lb_ntfy_tax_id",formObj.lb_ntfy_tax_id.value,0);
		}
		var brazilExportData=formObj.br_shpr_tax_id.value  + formObj.br_cnee_tax_id.value + formObj.br_ntfy_tax_id.value;
		if(brazilExportData.length>0){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","BR",0);
			sheetObject1.SetCellValue(newRow, "br_shpr_tax_id",formObj.br_shpr_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "br_cnee_tax_id",formObj.br_cnee_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "br_ntfy_tax_id",formObj.br_ntfy_tax_id.value,0);
			sheetObject1.SetCellValue(newRow, "brz_decl_no",formObj.brz_decl_no.value,0);
			sheetObject1.SetCellValue(newRow, "brz_decl_cpy_desc_flg",formObj.brz_decl_cpy_desc_flg.value,0);
			sheetObject1.SetCellValue(newRow, "shpr_tax_cpy_desc_flg",formObj.shpr_tax_cpy_desc_flg.value,0);
			sheetObject1.SetCellValue(newRow, "cnee_tax_cpy_desc_flg",formObj.cnee_tax_cpy_desc_flg.value,0);
			sheetObject1.SetCellValue(newRow, "ntfy_tax_cpy_desc_flg",formObj.ntfy_tax_cpy_desc_flg.value,0);
		}
		
		var canadaExportData=formObj.caed_ctnt.value
							+ formObj.g7_edi_ctnt.value
							+ formObj.mf_smry_rpt_no.value
							+ formObj.b13a_xpt_ctnt.value
							+ formObj.cgo_ctrl_no.value
							+ comboObjects[1].GetSelectText()
							+ formObj.ndr_ref_ctnt.value;
		if(canadaExportData.length>0){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","CA",0);
			if(formObj.caed_tp_cd[0].checked == true){
				sheetObject1.SetCellValue(newRow, "caed_tp_cd","CE",0);
			} else if(formObj.caed_tp_cd[1].checked == true){
				sheetObject1.SetCellValue(newRow, "caed_tp_cd","G7",0);
			} else if(formObj.caed_tp_cd[2].checked == true){
				sheetObject1.SetCellValue(newRow, "caed_tp_cd","SM",0);
			} else if(formObj.caed_tp_cd[3].checked == true){
				sheetObject1.SetCellValue(newRow, "caed_tp_cd","EX",0);
			} else if(formObj.caed_tp_cd[4].checked == true){
				sheetObject1.SetCellValue(newRow, "caed_tp_cd","IT",0);
			} else if(formObj.caed_tp_cd[5].checked == true){
				sheetObject1.SetCellValue(newRow, "caed_tp_cd","ND",0);
			}
			sheetObject1.SetCellValue(newRow, "caed_ctnt",formObj.caed_ctnt.value,0);
			sheetObject1.SetCellValue(newRow, "g7_edi_ctnt",formObj.g7_edi_ctnt.value,0);
			sheetObject1.SetCellValue(newRow, "mf_smry_rpt_no",formObj.mf_smry_rpt_no.value,0);
			sheetObject1.SetCellValue(newRow, "b13a_xpt_ctnt",formObj.b13a_xpt_ctnt.value,0);
			sheetObject1.SetCellValue(newRow, "cgo_ctrl_no",formObj.cgo_ctrl_no.value,0);
			sheetObject1.SetCellValue(newRow, "ndr_ref_id",comboObjects[1].GetSelectCode(),0);
			sheetObject1.SetCellValue(newRow, "ndr_ref_ctnt",formObj.ndr_ref_ctnt.value,0);
		}
		if(div1sheet1.LastRow()>0){
		for(var j=1;j<div1sheet1.LastRow()-1;j++){
			newRow=sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(newRow, "cnt_cd","KR",0);
			sheetObject1.SetCellValue(newRow, "xpt_lic_no",div1sheet1.GetCellValue(j, "xpt_lic_no"),0);
			sheetObject1.SetCellValue(newRow, "ts_ref_no",div1sheet1.GetCellValue(j, "ts_ref_no"),0);
			sheetObject1.SetCellValue(newRow, "pck_qty",div1sheet1.GetCellValue(j, "pck_qty"),0);
			sheetObject1.SetCellValue(newRow, "pck_tp_cd",div1sheet1.GetCellValue(j, "pck_tp_cd"),0);
			sheetObject1.SetCellValue(newRow, "mf_wgt",div1sheet1.GetCellValue(j, "mf_wgt"),0);
			sheetObject1.SetCellValue(newRow, "wgt_ut_cd",div1sheet1.GetCellValue(j, "wgt_ut_cd"),0);
			sheetObject1.SetCellValue(newRow, "divd_seq",div1sheet1.GetCellValue(j, "divd_seq"),0);
			sheetObject1.SetCellValue(newRow, "sam_pck_id",div1sheet1.GetCellValue(j, "sam_pck_id"),0);
			sheetObject1.SetCellValue(newRow, "sam_pck_qty",div1sheet1.GetCellValue(j, "sam_pck_qty"),0);
			sheetObject1.SetCellValue(newRow, "sam_pck_tp_cd",div1sheet1.GetCellValue(j, "sam_pck_tp_cd"),0);
			}		
		}
		for(var j=1;j<sheetObject1.LastRow();j++){
			sheetObject1.SetRowStatus(newRow,"U");
			sheetObject1.SetCellValue(j, "bkg_no",formObj.bkg_no.value,0);
			sheetObject1.SetCellValue(j, "io_bnd_cd","O",0);
		}
	}
	function getPoOtherNoToForm(){
		var formObj=document.form;
		var sObject=div3sheet3;
		var c_row=sObject.LastRow();
		for ( var row=1; row <= c_row; row++) {
			if (sObject.GetCellValue(row, "bkg_ref_tp_cd") == 'BKPO') {
				formObj.bkpo.value=sObject.GetCellValue(row, "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, "bkg_ref_tp_cd") == 'LCNO') {
				formObj.lcno.value=sObject.GetCellValue(row, "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, "bkg_ref_tp_cd") == 'HINV') {
				formObj.hinv.value=sObject.GetCellValue(row, "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, "bkg_ref_tp_cd") == 'LCDT') { // YYYY-MM-DD
				formObj.lcdt.value=sObject.GetCellValue(row, "cust_ref_no_ctnt");//.getDataString();
				if(formObj.lcdt.value.length > 7){
					ComAddSeparator(formObj.lcdt);
				}
			}
			if (sObject.GetCellValue(row, "bkg_ref_tp_cd") == 'HPDP') {
				formObj.hpdp.value=sObject.GetCellValue(row, "cust_ref_no_ctnt");
			}
			if (sObject.GetCellValue(row, "bkg_ref_tp_cd") == 'OTHR') {
				formObj.othr.value=sObject.GetCellValue(row, "cust_ref_no_ctnt");
			}
		}
	}
	function setPoOtherNoToSheet(){
		var formObj=document.form;
		var sObject=div3sheet3;
		sObject.RemoveAll();
		var row=sObject.DataInsert(-1);
		sObject.SetCellValue(row, "bkg_no",formObj.bkg_no.value);
		sObject.SetCellValue(row, "bkg_ref_tp_cd","BKPO");
		sObject.SetCellValue(row, "cust_ref_no_ctnt",formObj.bkpo.value);
		row=sObject.DataInsert(-1);
		sObject.SetCellValue(row, "bkg_no",formObj.bkg_no.value);
		sObject.SetCellValue(row, "bkg_ref_tp_cd","LCNO");
		sObject.SetCellValue(row, "cust_ref_no_ctnt",formObj.lcno.value);
		row=sObject.DataInsert(-1);
		sObject.SetCellValue(row, "bkg_no",formObj.bkg_no.value);
		sObject.SetCellValue(row, "bkg_ref_tp_cd","HINV");
		sObject.SetCellValue(row, "cust_ref_no_ctnt",formObj.hinv.value);
		row=sObject.DataInsert(-1);
		sObject.SetCellValue(row, "bkg_no",formObj.bkg_no.value);
		sObject.SetCellValue(row, "bkg_ref_tp_cd","LCDT");
		sObject.SetCellValue(row, "cust_ref_no_ctnt",formObj.lcdt.value.split('-').join(""));
		row=sObject.DataInsert(-1);
		sObject.SetCellValue(row, "bkg_no",formObj.bkg_no.value);
		sObject.SetCellValue(row, "bkg_ref_tp_cd","HPDP");
		sObject.SetCellValue(row, "cust_ref_no_ctnt",formObj.hpdp.value);
		row=sObject.DataInsert(-1);
		sObject.SetCellValue(row, "bkg_no",formObj.bkg_no.value);
		sObject.SetCellValue(row, "bkg_ref_tp_cd","OTHR");
		sObject.SetCellValue(row, "cust_ref_no_ctnt",formObj.othr.value);
	}
	
	function copyPckWgtMeas(){
		var formObj=document.form;
		if(formObj.pck_qty2.value != '0' && formObj.pck_qty2.value != ''){
			formObj.pck_qty.value=formObj.pck_qty2.value;
			if (formObj.pck_tp_cd2.value != null && formObj.pck_tp_cd2.value != ''){
				formObj.pck_tp_cd.value=formObj.pck_tp_cd2.value;
			}
		}
		
		if(parseInt((formObj.act_wgt2.value==".000")?"0":ComClearSeparator(formObj.act_wgt2.value))<=0){
			if(parseInt((formObj.act_wgt2.value==".000")?"0":ComClearSeparator(formObj.act_wgt.value))<=0){
				formObj.act_wgt.value=parent.frames["t1frame"].document.form.act_wgt.value;
			}
		} else {
			formObj.act_wgt.value=formObj.act_wgt2.value;
		}
		if(formObj.wgt_ut_cd2.value==null){
			ComSetObjValue(formObj.wgt_ut_cd, "KGS");
		} else if(formObj.wgt_ut_cd2.value.substring(0,1)=="K"){
			ComSetObjValue(formObj.wgt_ut_cd, "KGS");	
		} else if(formObj.wgt_ut_cd2.value.substring(0,1)=="L"){
			ComSetObjValue(formObj.wgt_ut_cd, "LBS");
		}
		if(formObj.wgt_ut_cd.value==null){
			formObj.wgt_ut_cd.value=parent.frames["t1frame"].document.form.wgt_ut_cd.value;
		}
		formObj.meas_qty.value=formObj.meas_qty2.value;
		if(formObj.meas_ut_cd2.value==null){
			formObj.meas_ut_cd.value="CBM";
		} else if(formObj.meas_ut_cd2.value.substring(0,1)=="X"){
			formObj.meas_ut_cd.value="CBM";
		} else if(formObj.meas_ut_cd2.value.substring(0,1)=="E"){
			formObj.meas_ut_cd.value="CBF";
		} else {
			formObj.meas_ut_cd.value=formObj.meas_ut_cd2.value; 
		}
	}
	function showMiscDesc() {
		if (document.all.showMisc.style.visibility == 'hidden') {
			document.all.showMisc.style.visibility='visible';
			document.all.showMisc.style.zIndex='2';
			document.all.showMisc.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 303)+"px";
			document.all.showMisc.style.left=(document.getElementById("div_right").offsetLeft - 770)+"px";
		} else {
			document.all.showMisc.style.visibility='hidden';
			document.all.showMisc.style.zIndex='1';
		}
		document.all.innerPackage.style.visibility='hidden';	
		document.all.innerPackage.style.zIndex='1';	
		sheet2.SetVisible(0);
		document.all.showXptLicNo.style.visibility='hidden';	
		document.all.showXptLicNo.style.zIndex='1';	
		div1sheet1.SetVisible(0);
		document.all.showXptLicNo2.style.visibility='hidden';	
		document.all.showXptLicNo2.style.zIndex='1';	
		div2sheet1.SetVisible(0);
		document.all.poOther.style.visibility='hidden';	
		document.all.poOther.style.zIndex='1';			
		sheetObjects[3].SetVisible(0);
		sheetObjects[4].SetVisible(0);
		document.all.poOther2.style.visibility='hidden';
		document.all.poOther2.style.zIndex='1';
		div4sheet1.SetVisible(0);
		div4sheet2.SetVisible(0);
		
		document.all.shipIdPop1.style.visibility='hidden';	
		document.all.shipIdPop1.style.zIndex = '1';	
		document.all.shipIdPop2.style.visibility='hidden';
		document.all.shipIdPop2.style.zIndex = '1';	
	}
	function showInnerPackage() {
		if (document.all.innerPackage.style.visibility == 'hidden')
		{
			document.all.innerPackage.style.visibility='visible';
			document.all.innerPackage.style.zIndex='2';
			document.all.innerPackage.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 296)+"px";
			document.all.innerPackage.style.left=(document.getElementById("div_right").offsetLeft-770)+"px";
			sheet2.SetVisible(1);
		}
		else
		{
			document.all.innerPackage.style.visibility='hidden';	
			document.all.innerPackage.style.zIndex='1';	
			sheet2.SetVisible(0);
		}
		document.all.showXptLicNo.style.visibility='hidden';	
		document.all.showXptLicNo.style.zIndex='1';	
		div1sheet1.SetVisible(0);
		document.all.showXptLicNo2.style.visibility='hidden';	
		document.all.showXptLicNo2.style.zIndex='1';	
		div2sheet1.SetVisible(0);
		document.all.poOther.style.visibility='hidden';
		document.all.poOther.style.zIndex='1';
		document.all.poOther2.style.visibility='hidden';
		div4sheet1.SetVisible(0);
		div4sheet2.SetVisible(0);
		document.all.poOther2.style.visibility='1';
		document.all.showMisc.style.visibility='hidden';
		document.all.showMisc.style.zIndex='1';
		
		document.all.shipIdPop1.style.visibility='hidden';	
		document.all.shipIdPop1.style.zIndex = '1';	
		document.all.shipIdPop2.style.visibility='hidden';
		document.all.shipIdPop2.style.zIndex = '1';	
	}
	function showXptLicNo(){
		if (document.all.showXptLicNo.style.visibility == 'hidden')
		{
			document.all.showXptLicNo.style.visibility='visible';
			document.all.showXptLicNo.style.zIndex='2';
			document.all.showXptLicNo.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 307)+"px";
			document.all.showXptLicNo.style.left=(document.getElementById("btn_ExportInfo").offsetLeft - 2)+"px";
			div1sheet1.SetVisible(1);
		}
		else
		{
			document.all.showXptLicNo.style.visibility='hidden';	
			div1sheet1.SetVisible(0);
			document.all.showXptLicNo.style.zIndex='1';	
		}
		document.all.showXptLicNo2.style.visibility='hidden';	
		div2sheet1.SetVisible(0);
		document.all.poOther.style.visibility='hidden';
		document.all.poOther2.style.visibility='hidden';
		div4sheet1.SetVisible(0);
		div4sheet2.SetVisible(0);
		document.all.innerPackage.style.visibility='hidden';
		sheet2.SetVisible(0);
		
		document.all.showXptLicNo2.style.zIndex='1';	
		document.all.poOther.style.zIndex='1';
		document.all.poOther2.style.zIndex='1';
		document.all.innerPackage.style.zIndex='1';	
		document.all.showMisc.style.visibility='hidden';
		document.all.showMisc.style.zIndex='1';
		
		document.all.shipIdPop1.style.visibility='hidden';	
		document.all.shipIdPop1.style.zIndex = '1';	
		document.all.shipIdPop2.style.visibility='hidden';
		document.all.shipIdPop2.style.zIndex = '1';	
	}
	function showXptLicNo2(){
		if (document.all.showXptLicNo2.style.visibility == 'hidden')
		{
			document.all.showXptLicNo2.style.visibility='visible';
			document.all.showXptLicNo2.style.zIndex='2';
			document.all.showXptLicNo2.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 297)+"px";
			document.all.showXptLicNo2.style.left=(document.getElementById("div_right").offsetLeft - 610)+"px";
			div2sheet1.SetVisible(1);
		}else
		{
			document.all.showXptLicNo2.style.visibility='hidden';	
			document.all.showXptLicNo2.style.zIndex='1';	
			div2sheet1.SetVisible(0);
		}
		document.all.showXptLicNo.style.visibility='hidden';
		div1sheet1.SetVisible(0);
		document.all.poOther.style.visibility='hidden';
		document.all.poOther2.style.visibility='hidden';
		div4sheet1.SetVisible(0);
		div4sheet2.SetVisible(0);
		document.all.innerPackage.style.visibility='hidden';	
		sheet2.SetVisible(0);
		
		document.all.showXptLicNo.style.zIndex='1';	
		document.all.poOther.style.zIndex='1';
		document.all.poOther2.style.zIndex='1';
		document.all.innerPackage.style.zIndex='1';	
		document.all.showMisc.style.visibility='hidden';
		document.all.showMisc.style.zIndex='1';
		
		document.all.shipIdPop1.style.visibility='hidden';	
		document.all.shipIdPop1.style.zIndex = '1';	
		document.all.shipIdPop2.style.visibility='hidden';
		document.all.shipIdPop2.style.zIndex = '1';	
	}
	function showPoOther(){
		if (document.all.poOther.style.visibility == 'hidden')
		{
			document.all.poOther.style.visibility='visible';
			document.all.poOther.style.zIndex='2';
			document.all.poOther.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 307)+"px";
			document.all.poOther.style.left=(document.getElementById("btn_ExportInfo").offsetLeft - 2)+"px";			
			sheetObjects[3].SetVisible(1);
			sheetObjects[4].SetVisible(1);
		}
		else
		{
			document.all.poOther.style.visibility='hidden';	
			document.all.poOther.style.zIndex='1';	
			
			sheetObjects[3].SetVisible(0);
			sheetObjects[4].SetVisible(0);
		}
		document.all.showXptLicNo.style.visibility='hidden';
		div1sheet1.SetVisible(0);
		document.all.showXptLicNo2.style.visibility='hidden';	
		document.all.poOther2.style.visibility='hidden';
		document.all.innerPackage.style.visibility='hidden';
		sheet2.SetVisible(0);
		
		document.all.showXptLicNo.style.zIndex='1';	
		document.all.showXptLicNo2.style.zIndex='1';	
		document.all.poOther2.style.zIndex='1';
		document.all.innerPackage.style.zIndex='1';	
		document.all.showMisc.style.visibility='hidden';
		document.all.showMisc.style.zIndex='1';
		
		document.all.shipIdPop1.style.visibility='hidden';	
		document.all.shipIdPop1.style.zIndex = '1';	
		document.all.shipIdPop2.style.visibility='hidden';
		document.all.shipIdPop2.style.zIndex = '1';	
	}
	function showPoOther2(){
		if (document.all.poOther2.style.visibility == 'hidden')
		{
			document.all.poOther2.style.visibility='visible';
			document.all.poOther2.style.zIndex='2';
			document.all.poOther2.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 297)+"px";
			document.all.poOther2.style.left=(document.getElementById("div_right").offsetLeft - 530)+"px";
			div4sheet1.SetVisible(1);
			div4sheet2.SetVisible(1);
		}
		else
		{
			document.all.poOther2.style.visibility='hidden';
			document.all.poOther2.style.zIndex='1';
			div4sheet1.SetVisible(0);
			div4sheet2.SetVisible(0);
		}
		document.all.showXptLicNo.style.visibility='hidden';	
		div1sheet1.SetVisible(0);
		document.all.showXptLicNo2.style.visibility='hidden';	
		div2sheet1.SetVisible(0);
		document.all.poOther.style.visibility='hidden';
		document.all.innerPackage.style.visibility='hidden';	
		sheet2.SetVisible(0);
		
		document.all.showXptLicNo.style.zIndex='1';	
		document.all.showXptLicNo2.style.zIndex='1';	
		document.all.poOther.style.zIndex='1';
		document.all.innerPackage.style.zIndex='1';	
		document.all.showMisc.style.visibility='hidden';
		document.all.showMisc.style.zIndex='1';
		
		document.all.shipIdPop1.style.visibility='hidden';	
		document.all.shipIdPop1.style.zIndex = '1';	
		document.all.shipIdPop2.style.visibility='hidden';
		document.all.shipIdPop2.style.zIndex = '1';	
	}
	
	function showShipId1() {
		if(document.all.shipIdPop1.style.visibility == 'hidden'){
			document.all.shipIdPop1.style.visibility = 'visible';
			document.all.shipIdPop1.style.zIndex = '2';
			document.all.shipIdPop1.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 307)+"px";
			document.all.shipIdPop1.style.left=(document.getElementById("btn_ExportInfo").offsetLeft - 2)+"px";	
			shipIdSheet1.SetVisible(1);
		}else{
			document.all.shipIdPop1.style.visibility = 'hidden';
			document.all.shipIdPop1.style.zIndex = '1';	
			shipIdSheet1.SetVisible(1);
		}
		
		document.all.showXptLicNo.style.visibility='hidden';	
		div1sheet1.SetVisible(0);
		document.all.showXptLicNo2.style.visibility='hidden';	
		div2sheet1.SetVisible(0);
		document.all.poOther.style.visibility='hidden';
		document.all.poOther2.style.visibility='hidden';
		div4sheet1.SetVisible(0);
		div4sheet2.SetVisible(0);
		document.all.innerPackage.style.visibility='hidden';	
		sheet2.SetVisible(0);
		document.all.shipIdPop2.style.visibility='hidden';	
		
		document.all.showXptLicNo.style.zIndex='1';	
		document.all.showXptLicNo2.style.zIndex='1';	
		document.all.poOther.style.zIndex='1';
		document.all.poOther2.style.zIndex='1';
		document.all.innerPackage.style.zIndex='1';	
		document.all.showMisc.style.visibility='hidden';
		document.all.showMisc.style.zIndex='1';
		document.all.shipIdPop2.style.zIndex = '1';	
	}
	
	function showShipId2() {
		if(document.all.shipIdPop2.style.visibility == 'hidden'){
			document.all.shipIdPop2.style.visibility = 'visible';
			document.all.shipIdPop2.style.zIndex = '2';
			document.all.shipIdPop2.style.top=(document.getElementById("btn_ExportInfo").offsetTop - 297)+"px";
			document.all.shipIdPop2.style.left=(document.getElementById("div_right").offsetLeft - 530)+"px";
			shipIdSheet2.SetVisible(1);
		}else{
			document.all.shipIdPop2.style.visibility = 'hidden';
			document.all.shipIdPop2.style.zIndex = '1';	
			shipIdSheet2.SetVisible(0);
		}
		
		document.all.showXptLicNo.style.visibility='hidden';	
		div1sheet1.SetVisible(0);
		document.all.showXptLicNo2.style.visibility='hidden';	
		div2sheet1.SetVisible(0);
		document.all.poOther.style.visibility='hidden';
		document.all.poOther2.style.visibility='hidden';
		div4sheet1.SetVisible(0);
		div4sheet2.SetVisible(0);
		document.all.innerPackage.style.visibility='hidden';	
		sheet2.SetVisible(0);
		document.all.shipIdPop1.style.visibility='hidden';	
		
		document.all.showXptLicNo.style.zIndex='1';	
		document.all.showXptLicNo2.style.zIndex='1';	
		document.all.poOther.style.zIndex='1';
		document.all.poOther2.style.zIndex='1';
		document.all.innerPackage.style.zIndex='1';	
		document.all.showMisc.style.visibility='hidden';
		document.all.showMisc.style.zIndex='1';
		document.all.shipIdPop1.style.zIndex = '1';	

	}
	
	function getPckDesc(){
		var formObj=document.form;
		var pckNm="";
		if(!ComIsNull(formObj.pck_tp_cd.value)){
			var rXml=sheetObject1.GetSearchData("ESM_BKG_0079_06GS.do", "f_cmd="+SEARCH03+"&pck_tp_cd="+formObj.pck_tp_cd.value);
			pckNm=ComGetEtcData(rXml, "pck_nm");
		}
		if(pckNm == undefined || pckNm == ""){
			ComShowCodeMessage("BKG00530");
			ComSetFocus(formObj.pck_tp_cd);
			return "";
		}
		formObj.pck_nm.value=pckNm;
		changePackageDesc();
	}
	function changePackageDesc() {	
		var formObj=document.form;
		var pckDesc="";
		var pckQty=(formObj.pck_qty.value=='') ? 0 : BkgParseInt(ComTrimAll(formObj.pck_qty.value, ','));
		if(pckQty > 1){
			pckDesc=pckQty + " " + formObj.pck_nm.value + ("BOX"==formObj.pck_nm.value ? "E":"") + "S IN TOTAL";
		}else if(pckQty == 1){
			pckDesc=pckQty + " " + formObj.pck_nm.value + " IN TOTAL";
		}else{
			pckDesc="";
		}
		formObj.pck_cmdt_desc.value=pckDesc;
		if(ComGetObjValue(parent.frames["t1frame"].document.form.rcv_term_cd)=="S"){
			formObj.ttl_pck_desc.value=pckDesc;
		}
	}
	
	function radioBtnSet(obj){
		var formObj=document.form;
		if(obj.name=='aes_tp_cd'&& obj.checked==true){ 
			var obj2=document.getElementsByName("aes_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked=false;
		        }
		    }
	    	switch(obj.value) {
		        case "AE":
		        	 ComSetFocus(formObj.aes_inlnd_trns_no);
		        	 formObj.aes_inlnd_trns_no.readOnly=false;
		             formObj.aes_pta_no1.value='';
		             formObj.aes_pta_no1.readOnly=true;
		             formObj.aes_pta_no2.value='';
		             formObj.aes_pta_no2.readOnly=true;
		             formObj.aes_pta_dt.value='';
		             formObj.aes_pta_dt.readOnly=true;
		             formObj.aes_ptu_no.value='';
		             formObj.aes_ptu_no.readOnly=true;
		             formObj.aes_ptu_dt.value='';
		             formObj.aes_ptu_dt.readOnly=true;
		             formObj.aes_dwn_no.value='';
		             formObj.aes_dwn_no.readOnly=true;
		             formObj.aes_dwn_dt.value='';
		             formObj.aes_dwn_dt.readOnly=true;
		             aes_expt_id.SetSelectCode('');
		             formObj.aes_expt_id.SetEnable(0);
		             formObj.aes_expt_ctnt.value='';
		             formObj.aes_expt_ctnt.readOnly=true;
		             break;
		        case "PA": 
		             formObj.aes_pta_no1.readOnly=false;
		             formObj.aes_pta_no2.readOnly=false;
		             formObj.aes_pta_dt.readOnly=false;
		             formObj.aes_inlnd_trns_no.value='';
		        	 formObj.aes_inlnd_trns_no.readOnly=true;
		             formObj.aes_ptu_no.value='';
		             formObj.aes_ptu_no.readOnly=true;
		             formObj.aes_ptu_dt.value='';
		             formObj.aes_ptu_dt.readOnly=true;
		             formObj.aes_dwn_no.value='';
		             formObj.aes_dwn_no.readOnly=true;
		             formObj.aes_dwn_dt.value='';
		             formObj.aes_dwn_dt.readOnly=true;
		             aes_expt_id.SetSelectCode('');
		             formObj.aes_expt_id.SetEnable(0);
		             formObj.aes_expt_ctnt.value='';
		             formObj.aes_expt_ctnt.readOnly=true;
		             break;
		        case "PU":
		             formObj.aes_ptu_no.readOnly=false;
		             formObj.aes_ptu_dt.readOnly=false;
		             formObj.aes_inlnd_trns_no.value='';
		        	 formObj.aes_inlnd_trns_no.readOnly=true;
		             formObj.aes_pta_no1.value='';
		             formObj.aes_pta_no1.readOnly=true;
		             formObj.aes_pta_no2.value='';
		             formObj.aes_pta_no2.readOnly=true;
		             formObj.aes_pta_dt.value='';
		             formObj.aes_pta_dt.readOnly=true;
		             formObj.aes_dwn_no.value='';
		             formObj.aes_dwn_no.readOnly=true;
		             formObj.aes_dwn_dt.value='';
		             formObj.aes_dwn_dt.readOnly=true;
		             aes_expt_id.SetSelectCode('');
		             formObj.aes_expt_id.SetEnable(0);
		             formObj.aes_expt_ctnt.value='';	
		             formObj.aes_expt_ctnt.readOnly=true;
		             break;
		        case "DN":
		             formObj.aes_dwn_no.readOnly=false;
		             formObj.aes_dwn_dt.readOnly=false;
		             formObj.aes_inlnd_trns_no.value='';
		        	 formObj.aes_inlnd_trns_no.readOnly=true;
		             formObj.aes_pta_no1.value='';
		             formObj.aes_pta_no1.readOnly=true;
		             formObj.aes_pta_no2.value='';
		             formObj.aes_pta_no2.readOnly=true;
		             formObj.aes_pta_dt.value='';
		             formObj.aes_pta_dt.readOnly=true;
		             formObj.aes_ptu_no.value='';
		             formObj.aes_ptu_no.readOnly=true;
		             formObj.aes_ptu_dt.value='';
		             formObj.aes_ptu_dt.readOnly=true;
		             aes_expt_id.SetSelectCode('');
		             formObj.aes_expt_id.SetEnable(0);
		             formObj.aes_expt_ctnt.value='';
		             formObj.aes_expt_ctnt.readOnly=true;
		             break;
		        case "EX":
		        	 formObj.aes_expt_id.SetEnable(1);
		             formObj.aes_expt_ctnt.readOnly=false;
		             formObj.aes_inlnd_trns_no.value='';
		        	 formObj.aes_inlnd_trns_no.readOnly=true;
		             formObj.aes_pta_no1.value='';
		             formObj.aes_pta_no1.readOnly=true;
		             formObj.aes_pta_no2.value='';
		             formObj.aes_pta_no2.readOnly=true;
		             formObj.aes_pta_dt.value='';
		             formObj.aes_pta_dt.readOnly=true;
		             formObj.aes_ptu_no.value='';
		             formObj.aes_ptu_no.readOnly=true;
		             formObj.aes_ptu_dt.value='';
		             formObj.aes_ptu_dt.readOnly=true;
		             formObj.aes_dwn_no.value='';
		             formObj.aes_dwn_no.readOnly=true;
		             formObj.aes_dwn_dt.value='';
		             formObj.aes_dwn_dt.readOnly=true;
		             break;
	    	}
		} 
		if(obj.name=='aes_tp_cd'&& obj.checked==false){ 
			var obj2=document.getElementsByName("aes_tp_cd");
			var chkcnt=0
			for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
			if(chkcnt==0){
				 formObj.aes_inlnd_trns_no.value='';
	        	 formObj.aes_inlnd_trns_no.readOnly=true;
	             formObj.aes_pta_no1.value='';
	             formObj.aes_pta_no1.readOnly=true;
	             formObj.aes_pta_no2.value='';
	             formObj.aes_pta_no2.readOnly=true;
	             formObj.aes_pta_dt.value='';
	             formObj.aes_pta_dt.readOnly=true;
	             formObj.aes_ptu_no.value='';
	             formObj.aes_ptu_no.readOnly=true;
	             formObj.aes_ptu_dt.value='';
	             formObj.aes_ptu_dt.readOnly=true;
	             formObj.aes_dwn_no.value='';
	             formObj.aes_dwn_no.readOnly=true;
	             formObj.aes_dwn_dt.value='';
	             formObj.aes_dwn_dt.readOnly=true;
	             aes_expt_id.SetSelectCode('');
	             formObj.aes_expt_id.SetEnable(0);
	             formObj.aes_expt_ctnt.value='';
	             formObj.aes_expt_ctnt.readOnly=true;
			}
		}	 
		if(obj.name=='caed_tp_cd'&& obj.checked==true){   
			var obj2=document.getElementsByName("caed_tp_cd");
		    for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){
		            obj2[i].checked=false;
		        }
		    }
			switch(obj.value) {
		        case "CE":  
		        	 formObj.caed_ctnt.readOnly=false;
		             formObj.g7_edi_ctnt.value='';
		             formObj.g7_edi_ctnt.readOnly=true;
		             formObj.mf_smry_rpt_no.value='';
		             formObj.mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_ctnt.value='';
		             formObj.b13a_xpt_ctnt.readOnly=true;
		             formObj.cgo_ctrl_no.value='';
		             formObj.cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].SetEnable(0);
		             break;
		        case "G7": 
		        	 formObj.caed_ctnt.value='';
		        	 formObj.caed_ctnt.readOnly=true;
		             formObj.g7_edi_ctnt.readOnly=false;
		             formObj.mf_smry_rpt_no.value='';
		             formObj.mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_ctnt.value='';
		             formObj.b13a_xpt_ctnt.readOnly=true;
		             formObj.cgo_ctrl_no.value='';
		             formObj.cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].SetEnable(0);
		             break;
		        case "SM":
		        	 formObj.caed_ctnt.value='';
		        	 formObj.caed_ctnt.readOnly=true;
		             formObj.g7_edi_ctnt.value='';
		             formObj.g7_edi_ctnt.readOnly=true;
		             formObj.mf_smry_rpt_no.readOnly=false;
		             formObj.b13a_xpt_ctnt.value='';
		             formObj.b13a_xpt_ctnt.readOnly=true;
		             formObj.cgo_ctrl_no.value='';
		             formObj.cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].SetEnable(0);
		             break;
		        case "EX":
		        	 formObj.caed_ctnt.value='';
		        	 formObj.caed_ctnt.readOnly=true;
		             formObj.g7_edi_ctnt.value='';
		             formObj.g7_edi_ctnt.readOnly=true;
		             formObj.mf_smry_rpt_no.value='';
		             formObj.mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_ctnt.readOnly=false;
		             formObj.cgo_ctrl_no.value='';
		             formObj.cgo_ctrl_no.readOnly=true;
		             comboObjects[0].index='';
		             comboObjects[0].SetEnable(0);
		             break;
		        case "IT":
		        	 formObj.caed_ctnt.value='';
		        	 formObj.caed_ctnt.readOnly=true;
		             formObj.g7_edi_ctnt.value='';
		             formObj.g7_edi_ctnt.readOnly=true;
		             formObj.mf_smry_rpt_no.value='';
		             formObj.mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_ctnt.value='';
		             formObj.b13a_xpt_ctnt.readOnly=true;
		             formObj.cgo_ctrl_no.readOnly=false;
		             comboObjects[0].index='';
		             comboObjects[0].SetEnable(0);
		             break;
		        case "ND":
		        	 formObj.caed_ctnt.value='';
		        	 formObj.caed_ctnt.readOnly=true;
		             formObj.g7_edi_ctnt.value='';
		             formObj.g7_edi_ctnt.readOnly=true;
		             formObj.mf_smry_rpt_no.value='';
		             formObj.mf_smry_rpt_no.readOnly=true;
		             formObj.b13a_xpt_ctnt.value='';
		             formObj.b13a_xpt_ctnt.readOnly=true;
		             formObj.cgo_ctrl_no.value=''
		             formObj.cgo_ctrl_no.readOnly=true;
		             comboObjects[0].SetEnable(1);
		        	 break;
			}
		}
		if(obj.name=='caed_tp_cd'&& obj.checked==false){   		 
			var obj2=document.getElementsByName("caed_tp_cd");
			var chkcnt=0
			for(var i=0; i<obj2.length; i++){
		        if(obj2[i] != obj){		            
		        	if(obj2[i].checked == true){
		            	chkcnt++ ;
		            }
		        }
		    }
			if(chkcnt==0){
				 formObj.caed_ctnt.value='';
	        	 formObj.caed_ctnt.readOnly=true;
	             formObj.g7_edi_ctnt.value='';
	             formObj.g7_edi_ctnt.readOnly=true;
	             formObj.mf_smry_rpt_no.value='';
	             formObj.mf_smry_rpt_no.readOnly=true;
	             formObj.b13a_xpt_ctnt.value='';
	             formObj.b13a_xpt_ctnt.readOnly=true;
	             formObj.cgo_ctrl_no.value=''
	             formObj.cgo_ctrl_no.readOnly=true;
	             comboObjects[0].index='';
	             comboObjects[0].SetEnable(0);
	             formObj.ndr_ref_ctnt.value='';
			}
		}
	}
	function copyToDesc(chkObj){
		var formObj=document.form; 
	    if (chkObj.checked) {
			if(chkObj.name=="shpr_tax_cpy_desc_flg"){
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n Shipper CPF/CPNJ "+formObj.shpr_tax_no.value;	
			}
			if(chkObj.name=="cnee_tax_cpy_desc_flg"){
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n Consignee CPF/CPNJ "+formObj.cnee_tax_no.value;	
			}
			if(chkObj.name=="ntfy_tax_cpy_desc_flg"){
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n Notify CPF/CPNJ "+formObj.ntfy_tax_no.value;	
			}
			if (chkObj.name == "check_bkpo") {
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n P/O No:" + form.bkpo.value;			
			}
			if (chkObj.name == "check_lcno") {
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n L/C No:" + form.lcno.value;
			}
			if (chkObj.name == "check_hinv") {
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n Invoice No:" + form.hinv.value;
			}
			if (chkObj.name == "check_lcdt") {
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n L/C Date:" + form.lcdt.value;
			}
			if (chkObj.name == "check_hpdp") {
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n Department No:" + form.hpdp.value;
			}
			if (chkObj.name == "check_othr") {
				formObj.dg_cmdt_desc.value=formObj.dg_cmdt_desc.value + "\n Other Ref. No:" + form.othr.value;
			}	
	    }
	}
	function makeComma2(obj) {
		var val=makeComma(obj.value);
		obj.value=val;
	}
	function makeComma(srcValue) {
		var arrVal=srcValue.split(".");
		if (arrVal.length > 1) {
			srcValue=makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
		} else {
			srcValue=makeCommaRun(arrVal[0]) + ".000";
		}
		return srcValue;
	}
	function makeCommaRun(srcValue) {
		srcValue=srcValue.replace(/\D/g, "");
		if (srcValue.length > 9) {
			srcValue=srcValue.substring(0, 9);
		}
		l=srcValue.length - 3;
		while (l > 0) {
			srcValue=srcValue.substr(0, l) + "," + srcValue.substr(l);
			l -= 3;
		}
		return srcValue;
	}
	function ComClearSeparatorMod(obj,sFormat,sDelim){
	    try{
	        if (typeof(obj) != "object" ) return;
	        obj.value=ComTrimAll(obj.value, "-", "/", ":"," ");        
	        if (obj.type == 'text' && obj.value.length >=1 && obj.onfocus==null) obj.onfocus=new Function("this.select()");
			event.returnValue=true;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ComIsDateMod(obj, sFlag) {
	    try {
	        var sVal=getArgValue(obj);
	        sVal=sVal.replace(/\/|\-|\./g,"");
	        if (!ComIsNumber(sVal)) return false;
	        if (sFlag==undefined || sFlag==null) sFlag="mdy";
	        var year, month, day, week;
	            if (sVal.length != 8) return false;
	            year=sVal.substring(4,8);
	            month=sVal.substring(0,2);
	            day=sVal.substring(2,4);
	            if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)) return false;
	        return true;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ComIsAesNo(obj, sFlag) {
	    try {
	        var sVal=getArgValue(obj);
	        sVal=sVal.replace(/\/|\-|\./g,"");
	        if (sVal.length != 15) return false;
	        if (!ComIsNumber(sVal.substring(1,15))) return false;
	        if (!isAlpha(sVal.substring(0,1))) return false;      
	        return true;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ComIsCaedNo(obj, sFlag) {
	    try {
	        var sVal=getArgValue(obj);
	        sVal=sVal.replace(/\/|\-|\./g,"");
	        if (sVal.length != 23) return false;
	        if (!ComIsNumber(sVal.substring(0,2))) return false;
	        if (!isAlpha(sVal.substring(2,3))) return false;      
	        if (!ComIsNumber(sVal.substring(3,6))) return false;
	        if (!isAlpha(sVal.substring(6,8))) return false;  
	        if (!ComIsNumber(sVal.substring(8,23))) return false;
	        return true;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ComIsG7EdiNo(obj, sFlag) {
	    try {
	        var sVal=getArgValue(obj);
	        sVal=sVal.replace(/\/|\-|\./g,"");
	        if (sVal.length != 17) return false;
	        if (!ComIsNumber(sVal.substring(0,2))) return false;
	        if (!isAlpha(sVal.substring(2,3))) return false;      
	        if (!ComIsNumber(sVal.substring(3,17))) return false;
	        return true;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ComIsB13aXptNo(obj, sFlag) {
	    try {
	        var sVal=getArgValue(obj);
	        sVal=sVal.replace(/\/|\-|\./g," ");
	        if (sVal.length != 21) return false;
	        if (!ComIsNumber(sVal)) return false;
	        var year, month, day, week;
	        year=sVal.substring(0,4);
	        month=sVal.substring(4,6);
	        day=sVal.substring(6,8);
	        hm=sVal.substring(8,12);
	        if((ComParseInt(year) < 1900)  || !ComIsMonth( month ) || !ComIsDay( year,month ,day)|| !ComIsTime(hm, "hm")) return false;
	        return true;
	    } catch(err) { ComFuncErrMsg(err.message); }
	}
	
	function ChkComIsCaedNo(obj){
		var size=0;
		var sVal="";
		if(obj.form.name=='form'){
	    	size=document.form.caed_tp_cd.length;	
	    	j=0;
			for(var i=0; i < size; i++) {
				if(document.form.caed_tp_cd[i].checked) {
					if(document.form.caed_tp_cd[i].value!='CE') return false;
					j++
				}				
			}
	    	if(j<1) return false;
		} else{		
			size=document.form2.imp_caed_tp_cd.length;	
			j=0;
			for(var i=0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='CE') return false;
					j++
				}				
			}
			if(j<1) return false;
		}
		if (!ComIsCaedNo(obj.value)){
			 if(obj.form.name=='form'){
				 //
			 }else{
				 //
			 }
			 return false;
	   	} else{
	   		var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([A-Z][A-Z][0-9][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	   		sVal=obj.value.toUpperCase()
	   		if(obj.form.name=='form'){
	   			document.form.caed_ctnt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	   		}else{
	   			document.form2.caed_ctnt.value=sVal.replace(re,'$1' + "-" + '$2' + "-" + '$3');
	   		}
	   	}
	}
	function ChkComIsG7EdiNo(obj){
		var size=0;
		var sVal="";
		if(obj.form.name=='form'){
	    	size=document.form.caed_tp_cd.length;	
	    	j=0
			for(var i=0; i < size; i++) {
				if(document.form.caed_tp_cd[i].checked) {
					if(document.form.caed_tp_cd[i].value!='G7') return false;
					j++
				}				
			}
	    	if(j<1) return false;
		} else{		
			size=document.form2.imp_caed_tp_cd.length;	
			j=0
			for(var i=0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='G7') return false;
					j++
				}				
			}
			if(j<1) return false;
		}
		if (!ComIsG7EdiNo(obj.value)){
			 if(obj.form.name=='form'){
				 //
			 }else{
				 //
			 }
	   	} else{
	   		var re=new RegExp('([0-9][0-9][A-Z][0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])');
	   		sVal=obj.value.toUpperCase()
	   		if(obj.form.name=='form'){
	   			document.form.g7_edi_ctnt.value=sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
	   		}else{
	   			document.form2.g7_edi_ctnt.value=sVal.replace(re,'$1' + "-" + '$2').toUpperCase();
	   		}
	   	}
	}
	
	function ChkComIsB13aXptNo(obj){
		var size=0;
		var sVal="";
		if (obj.form.name=='form'){
	    	size=document.form.caed_tp_cd.length;	
	    	j=0
			for(var i=0; i < size; i++) {				
				if(document.form.caed_tp_cd[i].checked) {
					if(document.form.caed_tp_cd[i].value!='EX') return false;
					j++
				}
			}
	    	if(j<1) return false;
		} else{		
			size=document.form2.imp_caed_tp_cd.length;	
			j=0
			for(var i=0; i < size; i++) {
				if(document.form2.imp_caed_tp_cd[i].checked) {
					if(document.form2.imp_caed_tp_cd[i].value!='EX') return false;
					j++
				}				
			}
			if(j<1) return false;
		}
		if (!ComIsB13aXptNo(obj.value)){
			 if(obj.form.name=='form'){
				 //
			 }else{
				 //
			 }
	   	} else{
	   		var re=new RegExp('([0-9][0-9][0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])([0-9][0-9][0-9][0-9][0-9][0-9])');
	    	if (obj.form.name=='form'){
	   			document.form.b13a_xpt_ctnt.value=obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
	   		} else{
	   			document.form2.b13a_xpt_ctnt.value=obj.value.replace(re,'$1' + "/" + '$2' + "/" + '$3'+ ' ' +'$4'+ ':'+ '$5'+ ' ' +'$6'+'-'+'$7');
	   		}
	   	}
	}
	
	function isAlpha(str) {
	    var pattern=/^[a-zA-Z]+$/;
	    return (pattern.test(str)) ? true : false;
	}
	
	function obj_activate(){
		switch (event.srcElement.name) {
			case "caed_ctnt":
			case "g7_edi_ctnt":
			case "mf_smry_rpt_no":
			case "b13a_xpt_ctnt":
			case "cgo_ctrl_no":
			case "aes_pta_dt":
			case "aes_ptu_dt":
			case "aes_dwn_dt":
		    	ComClearSeparatorMod(event.srcElement);
	    	break;
		}
	}
	
	function form1_onBlur() {
	}
	
	function form1_onChange() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName){
			case "pck_tp_cd":
				var cVal=event.srcElement.value;
				if(cVal==''){
					return false;
				} else {			
					getPckDesc();
				}
				break;
			case "cstms_desc":
				var cVal = event.srcElement.value;
				if(cVal != ''){
					ComSetObjValue(formObj.cstms_desc, chekcSpecialValue(ComGetObjValue(formObj.cstms_desc)));
				}
				break;
		}
		compareItem();
		isCopy="false";
	}
	
	function wgt_ut_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, value, text) {
		if (parent.frames["t1frame"].document.form) {
			ComSetObjValue(parent.frames["t1frame"].document.form.wgt_ut_cd, value);
		}
	}
	
	function frt_term_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, value, text) {
		var formObj=document.form;
		if (parent.tabObjects[0].GetSelectedIndex()== 3) {
			if (parent.frames["t1frame"].document.form.is_rated_flg.value == "Y") {
				ComShowCodeMessage("BKG02065");
			}
		}
		if (!ComIsEmpty(frt_term_cd.GetSelectText()) && frt_term_cd.GetSelectText().substring(0,1) != formObj.frt_term_cd2.value.substring(0,1)){
			frt_term_cd.SetFontColor("Red");
			formObj.frt_term_cd2.style.color="Red";
		} else {
			frt_term_cd.SetFontColor("#606060");
			formObj.frt_term_cd2.style.color="#606060";		
		}
		if (parent.frames["t1frame"].document.form) {
//			ComSetObjValue(parent.frames["t1frame"].document.form.frt_term_cd, value);
			
			var frtTermCdOfTab1 = parent.frames["t1frame"].window.frt_term_cd;
			frtTermCdOfTab1.SetSelectCode(newCode, false);
		}
	}
	
	function div1sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj=document.form;
		var srcName=sheetObj.ColSaveName(Col);
		if ("xpt_lic_no"==srcName) {
			if (""!=Value && 14>Value.length) {
				ComShowCodeMessage("BKG00257");
				sheetObj.SelectCell(Row, Col);
			} else {
				var total=0;
				for (var i=1; i<15; i++) {
					switch (i%3) {
						case 1:
							total += parseInt(((Value.substring(i-1,i)*7)%10));
							break;	
						case 2:
							total += parseInt(((Value.substring(i-1,i)*3)%10));
							break;
						case 0:
							total += parseInt((Value.substring(i-1,i)*1));
							break;
					}
				}     	
				chkDigit=(10-(total%10))%10;
				if (15==Value.length) {
	    			if (chkDigit!=Value.substring(14,15)) {
	    				ComShowCodeMessage("BKG00200",chkDigit,Value.substring(14,15));
	    				sheetObj.SetCellValue(Row, Col,Value.substring(0,14));
	    				sheetObj.SelectCell(Row, Col);
	    			}
	    		} else if (14==Value.length) {
	    			sheetObj.SetCellValue(Row, Col,Value+chkDigit,0);
	    		}
			}
		} else if ("pck_tp_cd"==srcName || "sam_pck_tp_cd"==srcName) {
			sheetObj.SetCellValue(Row,srcName,Value.toUpperCase(),0);
		}
	}
	
	function div1sheet1_OnPopupClick(sheetObj,Row,Col){
		comBkgCallPop0696("setSheetCallBack0696",sheetObj.GetCellValue(Row, Col));
	}
	
	
	function div3sheet2_OnPopupClick(sheetObj,Row,Col){
		comBkgCallPop0696("setSheetCallBack06962",sheetObj.GetCellValue(Row, Col));
	}
	/**
	 * Sheet onClick Action Event 
	 */
	function div3sheet1_OnClick(sheetObject, Row, Col, Value) {
		var target_cntr=sheetObject.GetCellValue(Row, "c_cntr_no");
		var cnt=div3sheet2.RowCount();
		sheetObject.SetSelectRow(Row);
		for (var ix=1; ix <= cnt; ix++) {
			div3sheet2.SetRowHidden(ix,1);
			if (div3sheet2.GetRowStatus(ix) == 'D') {
			} else if (div3sheet2.GetCellValue(ix, "cntr_no") == target_cntr) {
				div3sheet2.SetRowHidden(ix,0);
			} else {
				div3sheet2.CheckAll("check",0,1);
				div3sheet2.SetRowHidden(ix,1);
			}
		}
	}
	function setSheetCallBack0696(aryPopupData) {
		var sheetObj=sheetObjects[0];
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),aryPopupData.cd);		
	}
	function setSheetCallBack06962(aryPopupData) {
		var sheetObj=sheetObjects[4];
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), sheetObj.GetSelectCol(),aryPopupData.cd);		
	}
	function comBkgCallPop0369(cd) {
		var formObj=document.form;
		var param="?bkg_no=" + formObj.bkg_no.value + "&ridr_tp_cd=" + cd;
		ComOpenWindow("/opuscntr/ESM_BKG_0369.do" + param, "PopupEsmBkg0369", "width=380,height=370", false);
	}
	function setCallBack0696(aryPopupData) {
		var formObj=document.form;
		formObj.pck_tp_cd.value=aryPopupData.cd;
	}
	function callbackPckTp(returnVal){
		document.form.pck_tp_cd.value=returnVal.cd;
		document.form.pck_nm.value=returnVal.nm;
		changePackageDesc();
	}
	/**
	* Search and post processing
	* @param sheetObj Sheet
	* @param ErrMsg Error Message
	*/
	function div2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (sheetObj.RowCount()> 0) {
			sheetObj.SetCellValue(sheetObj.LastRow(), 1,"",0);
			sheetObj.SetCellValue(sheetObj.LastRow(), "ts_ref_no2","TOTAL",0);
			sheetObj.SetCellAlign(sheetObj.LastRow(), "ts_ref_no2","Center");
		}
	}
	function form1_blur(){
		var obj=event.srcElement;
		if (obj && ("pck_qty"==obj.name || "act_wgt"==obj.name || "meas_qty"==obj.name)) {
			ComAddSeparator(obj);
		}
	}