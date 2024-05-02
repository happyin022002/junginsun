/*=========================================================
_B*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0034.js
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
				OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// Common global variable
	var trnkBdrFlg="";
	var ofcCode="";
	var tabObjects=new Array();
	var tabCnt=0;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var open_flg=true;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");

			if (!ComIsBtnEnable(srcName)) return;

			switch (srcName) {
			case "btn_edit":
				setEditable();
				break;
			case "btn_retrieve":
				tabObjects[0].SetSelectedIndex(0);
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_del":
				doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
				break;
			case "btn_reactivate":
				doActionIBSheet(sheetObjects[0], formObject, IBRESET);
				break;
			case "btn_print":
				rdOpen();
				break;
			case "btn_container":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
				break;
			case "btn_cm":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
				break;
			case "btn_blcharge":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
				break;
			case "btn_view":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC05);
				break;
			case "btn_transmit":
				if (ComShowCodeConfirm("BKG01023", "AI", "US Customs")) { // checking whether AI is transmitted
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
	//			doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC06);
				break;
			case "btn_trans_ptt":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC07);
				break;
			case "btn_trans_isf":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC08);
				break;
			case "btn_customer":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC09);
				break;
			case "btn_div":
				doActionIBSheet(sheetObjects[0], formObject, MULTI03);
				break;
			case "btn_Close":
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
	 * registering Combo Object as list
	 * @param combo_obj
	 * @return
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * initializing Combo Object
	 * @param comboObj
	 * @param comNo
	 * @return
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
		case "combo_c_cd":
			var i=0;
			with (comboObj) {
				SetColBackColor(0,"#CCFFFD");
				SetDropHeight(600);
				SetMultiSelect(0);
				SetMaxSelect(0);
			}
			break;
		case "combo_t_cd":
			var i=0;
			with (comboObj) {
				SetDropHeight(300);
				SetMultiSelect(0);
				SetMaxSelect(0);
				// Enable = false;
			}
			break;
		}
	}
	/**
	 * combo Change event
	 */
//	function combo_t_cd_OnChange() {
//		var formObj=document.form;
//		var t_cd=  comboObjects[0].GetSelectCode();
//	}
	function combo_t_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode)
	{
		form.combo_t_cd_text.value = comboObj.GetText(parseInt(newindex), 0);
	 }
	function combo_t_cd_OnBlur() {
		if (combo_t_cd.GetText(parseInt(combo_t_cd.GetSelectIndex()), 0) != undefined)
			document.form.combo_t_cd_text.value = combo_t_cd.GetText(parseInt(combo_t_cd.GetSelectIndex()), 0);
	}
	/**
	 * combo Change event
	 */
	function combo_c_cd_OnChange() {
		comboObjects[1].SetSelectCode(document.form.cstms_clr_cd.value);
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		var formObj=document.form;
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for (k=0; k < tabObjects.length; k++) {
			initTab(tabObjects[k], k + 1);
			// tabObjects[k].SetSelectedIndex(0);
		}
		for (i=0; i < comboObjects.length; i++) {
			initCombo(comboObjects[i], i + 1);
		}
		comboObjects[0].InsertItem(0, "LOCAL", "L");
		comboObjects[0].InsertItem(1, "P/MIB", "I");
//		comboObjects[0].InsertItem(2, "NVOCC", "N");
		comboObjects[0].InsertItem(2, "FROB", "F");
//		comboObjects[0].InsertItem(4, "FROB(V)", "V");

		comboObjects[1].InsertItem(0, "D | Partial NYK In-bond", "D");
		comboObjects[1].InsertItem(1, "E | I. E. Closed", "E");
		comboObjects[1].InsertItem(2, "H | US Government Hold", "H");
		comboObjects[1].InsertItem(3, "I | Broker In-bond after NYK In-Bond", "I");
		comboObjects[1].InsertItem(4, "J | In-Bond Authorization", "J");
		comboObjects[1].InsertItem(5, "N | No Customs", "N");
		comboObjects[1].InsertItem(6, "P | Partial Customs Entry", "P");
		comboObjects[1].InsertItem(7, "T | T&E Closed", "T");
		comboObjects[1].InsertItem(8, "V | Broker In-Bond", "V");
		comboObjects[1].InsertItem(9, "W | Permit to Transfer", "W");
		comboObjects[1].InsertItem(10, "Y | Customs Clearance", "Y");

		comboObjects[2].InsertItem(0, "Y", "Y");
		comboObjects[2].InsertItem(1, "N", "N");

		comboObjects[3].InsertItem(0, "KGS", "KGS");
		comboObjects[3].InsertItem(1, "LBS", "LBS");

		var formObj=document.form;

		if (formObj.open_tab.value != "") {
			tabObjects[0].SetSelectedIndex(formObj.open_tab.value);
		}

		axon_event.addListenerForm("click", "obj_click", formObj);
		//axon_event.addListenerForm("KeyUp", "obj_KeyUp", formObj);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');

		loadTabPage(1);

//		loadTabPage(0);
//		setTimeout( function () {
//			  doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
//			  doActionIBSheet(sheetObjects[0], formObj, COMMAND11);
//		}, 1500);

		document.getElementById("t1frame").onload = function() {
		  doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
		  doActionIBSheet(sheetObjects[0], formObj, COMMAND11);
		};


/*//		setTimeout( function () {
//			doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
////			doActionIBSheet(sheetObjects[0], formObj, SEARCH05);
//			// SETTING WGT UNIT CODE
//			doActionIBSheet(sheetObjects[0], formObj, COMMAND11);
//
//		}, 2200);
*/
		formObj.bl_nos.focus();

	}
	function callSearchBlInfo(sheetObj) {
		var formObj=document.form;
		// retrieving B/L No. info.
		var blNo=formObj.bl_no.value;

		//추가
		formObj.bl_vvd.value=sheetObj.GetEtcData("bl_vvd");
		formObj.bl_pod.value=sheetObj.GetEtcData("bl_pod");
		formObj.bl_del.value=sheetObj.GetEtcData("bl_del");
		formObj.bl_hub.value=sheetObj.GetEtcData("bl_hub");
		formObj.bl_cstms.value=sheetObj.GetEtcData("bl_cstms");
		formObj.bl_fpo.value=sheetObj.GetEtcData("bl_fpo");
		formObj.bl_mib.value=sheetObj.GetEtcData("bl_mib");
		formObj.bl_ptt.value=sheetObj.GetEtcData("bl_ptt");
		formObj.bl_ftz.value=sheetObj.GetEtcData("bl_ftz");
		formObj.bl_div.value=sheetObj.GetEtcData("bl_div");

		if (blNo != "") {
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
		} else {
			if (formObj.vvd.value != "") {
				doActionIBSheet(sheetObj, formObj, IBCREATE);
			}
		}

		ofcCode=formObj.office.value;
		setButton();
		// initializing button
		ComBtnDisable("btn_view");
	//	ComBtnDisable("btn_trans_isf");
	}

	/**
	 * when inputting search condition
	 */
	function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=ComGetEvent("maxlength");
		var srcValue=ComGetEvent("value");
		if ((srcName == "vvd" || srcName == "pod_cd" || srcName == "del_cd" || srcName == "hub_loc_cd" || srcName == "cstms_loc_cd" || srcName == "ibd_trsp_no" || srcName == "usa_lst_loc_cd")
				&& ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
		if (srcName == "bl_nos") {
			if (ComChkLen(srcValue, 12) == "0") { // Toyota B/L ComChkLen(srcValue, 12) == "0"가 되려면 srcValue의 길이가 12를 초과해야 한다.
				formObject.bl_nos.value=srcValue.substr(0, srcValue.length - 1);
				ComSetNextFocus();
			}
			else if (ComChkLen(srcValue, 11) == "2"){ // B/L ComChkLen(srcValue, 11) == "2"가 되려면 srcValue의 길이가 딱 11이여야 한다.
				formObject.bl_nos.value=srcValue.substr(0, srcValue.length - 1);
				ComSetNextFocus();
			}
			else{
				formObject.bl_nos.value=srcValue;
				ComSetNextFocus();
			}
		}
		if (srcName == "pck_qty") {
			AddComma(formObject.pck_qty, "#,###");
		}
		if (srcName == "cgo_wgt") {
			AddComma(formObject.cgo_wgt, "#,###.###");
		}
	}
	/**
	 * Click event
	 */
	function obj_click() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=ComGetEvent("maxlength");
		var srcValue=ComGetEvent("value");
		if (srcName == "full_mty_chk") {
			if (formObject.full_mty_chk.checked) {
				formObject.full_mty_cd.value='M';
			} else {
				formObject.full_mty_cd.value='F';
			}
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
		case 1:
			with (sheetObj) {
			if (location.hostname != "")
			var HeadTitle="|bl_no|cstms_file_tp_cd|mf_sts_cd|entry type|full_mty_cd|cstms_mf_tp_cd|F|O|C|mbl_no|pre_mf_no|vvd|pol|pod|vps_eta_dt|del|cstms_loc_cd|hub|usa_lst|pck_qty||cgo_wgt||p/mib no.|type|R|D|trnk_bdr_flg|bl_tp_cd|cstms_loc_cd|FTZ";
			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bl_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cstms_file_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mf_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"locl_trns_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cstms_mf_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"frt_clt_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"obl_rdem_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cstms_clr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"mbl_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pre_mf_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vvd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"vps_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"del_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cstms_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"usa_lst_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ams_pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cgo_wgt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ibd_trsp_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ibd_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"de_term_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"trnk_bdr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"bl_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cstms_loc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"free_trd_zn_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ptt_frm_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
			InitColumns(cols);
			SetEditable(1);
			SetVisible(0);
			}
			break;
		} // switch end
	}
	/**
	 * setting StringBuffer
	 */
	var StringBuffer=function() {
		this.buffer=new Array();
	}
	StringBuffer.prototype.append=function(obj) {
		this.buffer.push(obj);
	}
	StringBuffer.prototype.toString=function() {
		return this.buffer.join("");
	}
	var objTabWin;
	/**
	 * handling process for Sheet
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.SetWaitImageVisible(0);
		switch (sAction) {
		case COMMAND11: // setting wgt unit code
			formObj.f_cmd.value = COMMAND01;
			var sXml = sheetObj.GetSearchData("ESM_BKG_0034GS.do", FormQueryString(formObj));
			ComXml2ComboItem(sXml, formObj.wgt_ut_cd, "val", "name");
			wgt_ut_cd.InsertItem(0, "", "");
			break;

		case IBCLEAR: // retrieving authority of button
			formObj.f_cmd.value=SEARCH;
//	 		sheetObj.DoSearch("ESM_BKG_0034GS.do", FormQueryString(formObj) );
			var sXml=sheetObj.GetSearchData("ESM_BKG_0034GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );

			break;
//		case SEARCH05:
//			formObj.f_cmd.value=SEARCH05;
//		 	var sXml=sheetObj.GetSearchData("ESM_BKG_0034GS.do", FormQueryString(formObj));
//			formObj.div_cd.value=ComGetEtcData(sXml, "divCd");
//			// AMS 媛��꾨땲��ACE �쇰븣留�DIV 踰꾪듉 �쒖꽦��
//			if(formObj.div_cd.value != 'ACE'){
//				ComSetDisplay("btn_div_dp", false);
//			}else {
//				ComSetDisplay("btn_div_dp", true);
//			}
//			// initialize button & FTZ Combo
//			ComBtnDisable("btn_del");
//			ComBtnDisable("btn_div");
//			comboObjects[2].SetEnable(0);

		break;
		case IBCREATE: // creating Dummy B/L No.
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0034GS.do", FormQueryString(formObj));
			if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1} );
			IBS_EtcDataToForm(formObj, sheetObj);
			formObj.bl_nos.value=sheetObj.GetEtcData("dummy_bl_no");
			formObj.bl_no.value=sheetObj.GetEtcData("dummy_bl_no");
			formObj.bak_bl_no.value=sheetObj.GetEtcData("dummy_bl_no");
			ComBtnDisable("btn_del");
			ComBtnDisable("btn_reactivate");
			formObj.full_mty_chk.disabled=false;
			formObj.pol_cd.readOnly=false;
			formObj.pol_cd.className='input';
			formObj.del_cd.readOnly=false;
			formObj.del_cd.className='input';
//			loadTabPage(1);
			sheetObj.DataInsert();
			sheetObj.SetCellValue(1, "bl_no",formObj.bl_no.value,0);
			sheetObj.SetCellValue(1, "full_mty_cd","M",0);
			formObj.full_mty_chk.checked=true;
			break;
		case IBSEARCH: // Retrieve
			if (!validateForm(sheetObj, formObj, sAction))
				return false;
			initInputData();
			clearAllTabPages();
	//		ComOpenWait(true);
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0034GS.do", FormQueryString(formObj));
			if (sXml != "") sheetObj.LoadSearchData(sXml,{Sync:1});
			var tabObj=tabObjects[0];
			if (sheetObj.RowCount()<= 0) {
				ComShowCodeMessage('BKG00889'); // No Data Found.
			} else {
				IBS_EtcDataToForm(formObj, sheetObj);
				trnkBdrFlg=sheetObj.GetEtcData("trnk_bdr_flg");
				setButton();
				formObj.bl_nos.value=sheetObj.GetEtcData("bl_no") + sheetObj.GetEtcData("bl_tp_cd");
				formObj.bkg_no.value=sheetObj.GetEtcData("bkg_no");
				var hblCnt=parseInt(sheetObj.GetEtcData("hbl_cnt"));
				if (formObj.mbl_no.value != "") { // deactivating tab in case of H.B/L
					tabObj.SetTabDisable(5 , true);
				} else {
					if (hblCnt == 0) { // deactivating tab in case of M.B/L which has not H.B/L
						tabObj.SetTabDisable(5 , true);
					} else {
						tabObj.SetTabDisable(5 , false);
					}
				}
				if (formObj.full_mty_cd.value == "M") {
					tabObj.SetTabDisable(1 , true);
				} else {
					tabObj.SetTabDisable(1 , false);
				}
				var blCnt=parseInt(sheetObj.GetEtcData("bl_cnt"));
				if (blCnt == 0) { // deactivating tab if it is not Multi B/L
					tabObj.SetTabDisable(6 , true);
				} else {
					tabObj.SetTabDisable(6 , false);
				}
				AddComma(formObj.pck_qty, "#,###");
				AddComma(formObj.cgo_wgt, "#,###.###");
				if (sheetObj.GetEtcData("cstms_file_tp_cd") != "") {
					formObj.cstms_file_tp_cd.value="0" + sheetObj.GetEtcData("cstms_file_tp_cd");
				}
				var stsCd=sheetObj.GetEtcData("mf_sts_cd");
				if (stsCd == "A") {
					document.getElementById("mf_sts_cd").innerHTML="Active";
					document.getElementById("mf_sts_cd").style.color="blue";
					formObj.mf_sts_code.value="A";
				} else if (stsCd == "D") {
					document.getElementById("mf_sts_cd").innerHTML="Deleted";
					document.getElementById("mf_sts_cd").style.color="red";
					formObj.mf_sts_code.value="D";
				}
				/*
				 * showing whether data of inbound(cstms_clr_cd) is manual
				 */
				var cgorTeamCd=sheetObj.GetEtcData("cgor_team_cd");
				if (cgorTeamCd == "M") {
					document.getElementById("cgor_team_cd").innerHTML="M";
					document.getElementById("cgor_team_cd").style.color="red";
				} else {
					document.getElementById("cgor_team_cd").innerHTML="";
					document.getElementById("cgor_team_cd").style.color="";
				}
				comboObjects[0].SetSelectCode(sheetObj.GetEtcData("locl_trns_cd"));
				formObj.locl_trns_cd.value=sheetObj.GetEtcData("locl_trns_cd");
				comboObjects[1].SetSelectCode(sheetObj.GetEtcData("cstms_clr_cd"));
				formObj.cstms_clr_cd.value=sheetObj.GetEtcData("cstms_clr_cd");

				comboObjects[2].SetSelectCode(sheetObj.GetEtcData("free_trd_zn_flg"));
				comboObjects[3].SetSelectCode(sheetObj.GetEtcData("wgt_ut_cd"));

				formObj.bak_bl_no.value=sheetObj.GetEtcData("bl_no");
				var fullMtyCd=sheetObj.GetEtcData("full_mty_cd");
				if (fullMtyCd == 'M') {
					formObj.full_mty_chk.checked=true;
				}
				if (formObj.open_tab.value == "") {
					loadTabPage(0);
//					if (fullMtyCd == 'F') loadTabPage(1);
				}
				setUnEditable();
				tabObj.SetSelectedIndex(0);
//				tabObj.SetTabDisable(0 , false);
			}
			break;
		case IBSAVE: // Save
			if (!validateForm(sheetObj, formObj, sAction))
				return false;
			if (formObj.full_mty_chk.checked) {
				formObj.full_mty_cd.value='M';
			} else {
				formObj.full_mty_cd.value='F';
			}
			var sParam=new StringBuffer();
			formObj.f_cmd.value=MULTI;
			var temp=new StringBuffer();
			var eta=formObj.vps_eta_dt2.value;
			temp.append(eta.substr(0, 10).replace(/-/gi, '').trim());
			temp.append(eta.substr(11, 8).replace(/:/gi, '').trim());
			formObj.vps_eta_dt.value=temp.toString();
			if (comboObjects[0].GetSelectCode()!= formObj.locl_trns_cd.value) {
				formObj.locl_trns_cd.value=comboObjects[0].GetSelectCode();
			}
			sParam.append(FormQueryString(document.form) + "&");
			var newParam=ComSetPrifix(FormQueryString(document.form), "t0_new_");
			var oldParam=ComSetPrifix(sheetObjects[0].GetSaveString(true), "t0_old_");
			sParam.append(newParam + "&" + oldParam);
			var sParamTab1=document.getElementById("t1frame").contentWindow.getSaveString();
			if (sParamTab1 != "") {
				sParam.append("&" + sParamTab1);
			}
			var sParamTab2=document.getElementById("t2frame").contentWindow.getSaveString();
			if (sParamTab2 != "") {
				sParam.append("&" + sParamTab2);
			}
			objTabWin=document.getElementById("t4frame").contentWindow;
			if (objTabWin.location.href != "about:blank") {
				var sParamTab4=document.getElementById("t4frame").contentWindow.getSaveString();
				if (sParamTab4 != "") {
					sParam.append("&" + sParamTab4);
				}
			} else {
				sParam.append("&t4_diff_rmk=" + document.form.diff_rmk.value);
				sParam.append("&t4_bak_diff_rmk=" + document.form.diff_rmk.value);
			}
			if (formObj.bak_bl_no.value != formObj.bl_no.value) {
				ComShowCodeMessage('BKG00439'); // different B/L No.
				return;
			}
			if (formObj.pol_cd.value == ''){
				ComShowCodeMessage("BKG00104", "POL");
				return false;
			}
			if (formObj.del_cd.value == ''){
				ComShowCodeMessage("BKG00104", "DEL");
				return false;
			}
			if (formObj.cstms_loc_cd.value == ''){
				ComShowCodeMessage("BKG00104", "Customs Loc");
				return false;
			}
			if (formObj.hub_loc_cd.value == ''){
				ComShowCodeMessage("BKG00104", "HUB");
				return false;
			}
			if (ComShowCodeConfirm('BKG00498')) { // confirm saving
				ComOpenWait(true);
				sheetObj.SetRowStatus(sheetObj.LastRow(),"U");
				var sXml=sheetObj.GetSaveData("ESM_BKG_0034GS.do", sParam);
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
			}
			break;
		case IBRESET: // Reactive
			if (ComShowCodeConfirm('BKG00498')) { // confirm saving
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH02;
				var sXml=sheetObj.GetSaveData("ESM_BKG_0034GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				try {
					var vPrefix=sXml.substring(1, 6);
					if (vPrefix != "ERROR") {
						document.getElementById("mf_sts_cd").innerHTML="Active";
						document.getElementById("mf_sts_cd").style.color="blue";
						formObj.mf_sts_code.value="A";
						ComBtnDisable("btn_reactivate");
						ComBtnEnable("btn_del");
						ComShowCodeMessage('BKG95004', 'Reativated'); // Data Reativated Successfully
						if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // checking whether AI is transmitted
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
						}
					}
				} catch (err) {
					ComFuncErrMsg(err.message);
				}
			}
			break;
		case IBDELETE: // Delete
			if (ComShowCodeConfirm('BKG00498')) { // confirm saving
				formObj.f_cmd.value=SEARCH03;
				var sXml=sheetObj.GetSaveData("ESM_BKG_0034GS.do", FormQueryString(formObj));
				try {
					var vPrefix=sXml.substring(1, 6);
					if (vPrefix != "ERROR") {
						document.getElementById("mf_sts_cd").innerHTML="Deleted";
						document.getElementById("mf_sts_cd").style.color="red";
						formObj.mf_sts_code.value="D";
						ComBtnDisable("btn_del");
						ComBtnEnable("btn_reactivate");
						ComShowCodeMessage('BKG00593'); // Data Deleted Successfully
						if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // checking whether AI is transmitted
							doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
						}
					}
				} catch (err) {
					ComFuncErrMsg(err.message);
				}
			}
			break;
		case IBSEARCH_ASYNC01: // Print
			formObj.f_cmd.value='';
			formObj.pagerows.value='';
			ComOpenWindow("ESM_BKG_5013.do?" + FormQueryString(formObj), "ESM_BKG_5013", 1042, 730);
			break;
		case IBSEARCH_ASYNC02: // Container
			if (!validateForm(sheetObj, formObj, IBSEARCH))
				return false;
			formObj.f_cmd.value='';
			formObj.pagerows.value='';
			ComOpenWindowCenter("ESM_BKG_0037.do?bl_no=" + formObj.bl_no.value + "&trnk_bdr_flg=" + trnkBdrFlg, "ESM_BKG_0037", 617, 465, true);
			break;
		case IBSEARCH_ASYNC03: // C/M
			if (!validateForm(sheetObj, formObj, IBSEARCH))
				return false;
			formObj.f_cmd.value='';
			formObj.pagerows.value='';
			ComOpenWindowCenter("ESM_BKG_0036.do?" + FormQueryString(formObj), "ESM_BKG_0036", 850, 670, true);
			break;
		case IBSEARCH_ASYNC04: // B/L Charge
			if (!validateForm(sheetObj, formObj, IBSEARCH))
				return false;
			formObj.f_cmd.value='';
			formObj.pagerows.value='';
	//		alert(formObj.bkg_no.value);
	//		comBkgCallPopBkgCharge(formObj.bkg_no.value);
			var param="pgmNo=ESM_BKG_0079&openTab=B9&bkg_no=" + formObj.bkg_no.value;
	//		201004.10 모달작업
			ComOpenWindowCenter("ESM_BKG_0079_Q_POP.do?" + param, "ESM_BKG_0079", 1280, 700, false);
			break;
		case IBSEARCH_ASYNC05: // View Receive File
			formObj.f_cmd.value='';
			formObj.pagerows.value='';
			var params=document.getElementById("t3frame").contentWindow.getSaveString();
			if (params == "")
				return false;
			ComOpenWindowCenter("ESM_BKG_0429.do?" + params, "ESM_BKG_0429", 500, 540);
			break;
		case IBSEARCH_ASYNC06: // Transmit AI
			formObj.f_cmd.value=MODIFY11;
			ComOpenWait(true);
			var params=FormQueryString(formObj) + "&pol=" + formObj.pol_cd.value + "&pod=" + formObj.pod_cd.value
					+ "&transmit_cd=AI"
			var sXml=sheetObj.GetSaveData("ESM_BKG_0034GS.do", params);
			ComOpenWait(false);
			sheetObj.LoadSaveData(sXml);
			break;
		case IBSEARCH_ASYNC07: // Transmit PTT
			if (!validateForm(sheetObj, formObj, IBSEARCH_ASYNC07))
				return false;
			if (ComShowCodeConfirm('BKG01023', 'PTT', 'US Customs')) {
				formObj.f_cmd.value=MODIFY11;
				ComOpenWait(true);
				var params=FormQueryString(formObj) + "&pol=" + formObj.pol_cd.value + "&pod=" + formObj.pod_cd.value
						+ "&transmit_cd=TI"
				var sXml=sheetObj.GetSaveData("ESM_BKG_0034GS.do", params);
				ComOpenWait(false);
				sheetObj.LoadSaveData(sXml);
			}
			break;
		case IBSEARCH_ASYNC08: // Transmit ISF
			if (ComShowCodeConfirm('BKG01023', 'ISF', 'US Customs')) {
				formObj.f_cmd.value=MODIFY12;
				ComOpenWait(true);
				var params=FormQueryString(formObj) + "&pol=" + formObj.pol_cd.value + "&pod=" + formObj.pod_cd.value
						+ "&transmit_cd=AI"
				var sXml=sheetObj.GetSaveData("ESM_BKG_0034GS.do", params);
				ComOpenWait(false);
				if (ComBkgErrMessage(sheetObj, sXml)) {
					sheetObj.LoadSaveData(sXml);
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
				}
			}
			break;
		case IBSEARCH_ASYNC09: // Customer Master
			formObj.f_cmd.value='';
			formObj.pagerows.value='';
			ComOpenWindowCenter("ESM_BKG_0240_POP.do?pgmNo=ESM_BKG_0240", "ESM_BKG_0240", 1024, 640);
			break;
		case MULTI03: // DIV
			var sParam="";
			var sParamSheet=sheetObj.GetSaveString();
			if (sParamSheet != "") {
				sParam += "&" + sParamSheet;
			}
			formObj.f_cmd.value=MULTI03;
			sParam += "&" + FormQueryString(formObj);
		//	alert("sParam : " + sParam);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true,true);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0034_11GS.do", sParam)
			var key=ComGetEtcData(sXml, "KEY");
			intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
			break;
		}// end switch
	}
	/**
	 * handling event after retrieving
	 */
	function t0sheet1_OnSearchEnd(sheetObj, Code, ErrMsg) {
		ComOpenWait(false);
		var formObj=document.form;
		if (ErrMsg == "") {
			var f_cmd=document.form.f_cmd.value;
			if (f_cmd == SEARCH) {
				callSearchBlInfo(sheetObj);
				free_trd_zn_flg.SetEnable(0);
	//			if (ofcCode == "Origin") {
	//				formObj.free_trd_zn_flg.Enable = false;
	//			}
			}
			if (f_cmd == SEARCH02 || f_cmd == SEARCH03) {
				if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // checking whether AI is transmitted
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
				}
			}
		}
	}
	/**
	 * handling event after saving
	 */
	function t0sheet1_OnSaveEnd(sheetObj, Code, ErrMsg) {
		ComOpenWait(false);
		if (ErrMsg == "") {
			var f_cmd=document.form.f_cmd.value;
			if (f_cmd == MULTI) {
				setUnEditable();
				ComShowCodeMessage('BKG00166'); // Data Saved Successfully
				if (tabObjects[0].GetSelectedIndex()== 0) {
					if (ComShowCodeConfirm('BKG01023', 'AI', 'US Customs')) { // checking whether AI is transmitted
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC06);
					} else {
						doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
					}
				} else {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
				}
//				opener.document.form.vvd.focus();
			} else if (f_cmd == MODIFY11) {
				ComShowCodeMessage('BKG00101'); // EDI was transmitted successfully.
			}
		}
	}
	/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj) {
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * initializing Tab
	 * setting Tab items
	 */
	function initTab(tabObj, tabNo) {
		switch (tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0;
				InsertItem( "Customer", "");
				InsertItem( "Customer 2", "");
				InsertItem( "Customs Result", "");
				InsertItem( "Remark(s)", "");
				InsertItem( "History", "");
				InsertItem( "H.B/L List", "");
				InsertItem( "Multi B/L List", "");
			}
			break;
		}
		tabObj.SetSelectedIndex(0);
	}
	/**
	 * Event when clicking Tab
	 * activating selected tab items
	 */
	function tab1_OnChange(tabObj, tabIndex) {

		var objs=document.all.item("tabLayer");
		objs[tabIndex].style.display="inline";
		 for(var i = 0; i<objs.length; i++){
			   if(i != tabIndex){
				objs[i].style.display="none";
				objs[beforetab].style.zIndex=objs[tabIndex].style.zIndex - 1 ;
			   }
			  }

		beforetab=tabIndex;
		if (document.form.open_tab.value == "") {
			loadTabPage(tabIndex);
		} else {
			if (!open_flg) {
				loadTabPage(tabIndex);
			}
		}
		open_flg=false;
	}
	/**
	 * activating selected tab items
	 */
	function loadTabPage(tabIndex) {
		var formObj=document.form;
		var strBlNo=formObj.bl_no.value;
		var strDiffRmk=formObj.diff_rmk.value;
		var strVvd=formObj.vvd.value;
		var objTabWindow=document.getElementById("t" + (tabIndex + 1) + "frame").contentWindow;
		if (objTabWindow.location.href == "about:blank" || objTabWindow.location.href == "") {
			objTabWindow.location.href="ESM_BKG_0034_0" + (tabIndex + 1) + ".do";
			return true;
		}
		if (objTabWindow.document.readyState == "complete") {
			if (tabIndex == 3) {
				objTabWindow.tabLoadSheet(strBlNo, strDiffRmk);
			} else if (tabIndex == 5) {
				objTabWindow.tabLoadSheet(strBlNo, strVvd);
			} else {
				objTabWindow.tabLoadSheet(strBlNo);
			}
			var tabObj=tabObjects[0];
			// activating tab in case of existing H.B/L
			if (formObj.hbl_cnt.value != "0") {
				//tabObj.SetTabDisable(5 , false);
			}
			if (formObj.bl_cnt.value != "0") {
				//tabObj.SetTabDisable(6 , false);
			}
			if (tabIndex != 2) {
				ComBtnDisable("btn_view");
			} else {
				ComBtnEnable("btn_view");
			}
		}
	}
	/**
	 * initializing all tabs
	 */
	function clearAllTabPages() {
		for ( var i=0; i < tabObjects[0].GetCount(); i++) {
			objTabWin=document.getElementById("t" + (i + 1) + "frame").contentWindow;
			if (objTabWin.location.href != "about:blank") {
				if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet) {
					document.getElementById("t" + (i + 1) + "frame").contentWindow.tabClearSheet();
				}
			}
		}
	}
	/**
	 * activating all tabs
	 */
	function enableAllTabPages(flag) {
		if (flag == null || flag == "") {
			if (document.form.bl_no.value != "") {
				flag=true;
			} else {
				flag=false;
			}
		}
		for ( var i=0; i < tabObjects[0].GetCount(); i++) {
			objTabWin=document.getElementById("t" + (i + 1) + "frame").contentWindow;
			if (objTabWin.location.href != "about:blank") {
				if (document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet) {
					document.getElementById("t" + (i + 1) + "frame").contentWindow.tabEnableSheet(flag);
				}
			}
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH:
			if (!ComChkObjValid(formObj.bl_nos))
				return false;
			var blNos=formObj.bl_nos.value;
			if (blNos.length > 12) { // Toyota B/L
				formObj.bl_no.value=blNos.substr(0, 12); //B/L No.가 12자리
			}
			else if (blNos.length == 11){
				formObj.bl_no.value=blNos.substr(0, 10); //B/L No.가 10자리
			}
			else {
				formObj.bl_no.value=blNos;
			}
			break;
		case IBSAVE:
			if (!ComChkValid(formObj))
				return false;
			break;
		case IBSEARCH_ASYNC07: // Transmit PTT
			if (ComIsNull(formObj.ptt_frm_cd))
			{
				ComShowCodeMessage('BKG00388', 'Firms Code');
				formObj.ptt_frm_cd.focus();
				return false;
			}
			break;
		}
		return true;
	}
	/**
	 * initializing input form in case of not existing data retrieved
	 */
	function initInputData() {
		var frmChild=document.getElementsByTagName("input");
		for ( var i=0; i < frmChild.length; i++) {
			if (frmChild[i].type == "text" && frmChild[i].name != "bl_nos") {
				frmChild[i].value="";
			}
			if (frmChild[i].type == "checkbox") {
				frmChild[i].checked=false;
			}
		}
		comboObjects[0].SetSelectCode(-1,false);
		comboObjects[1].SetSelectCode(-1,false);
		document.getElementById("mf_sts_cd").innerHTML="";
		document.getElementById("cgor_team_cd").innerHTML="";
	}
	/**
	 * activating in case of clicking Edit button
	 */
	function setEditable() {
		var formObj=document.form;

		if (formObj.bl_vvd.value == "1") {
			formObj.vvd.className="input";
			formObj.vvd.readOnly=false;
		}
		if (formObj.bl_pod.value == "1") {
			formObj.pod_cd.className="input";
			formObj.pod_cd.readOnly=false;
		}
		if (formObj.bl_del.value == "1") {
			formObj.del_cd.className="input";
			formObj.del_cd.readOnly=false;
		}
		if (formObj.bl_cstms.value == "1") {
			formObj.cstms_loc_cd.className="input";
			formObj.cstms_loc_cd.readOnly=false;
		}
		if (formObj.bl_hub.value == "1") {
			formObj.hub_loc_cd.className="input";
			formObj.hub_loc_cd.readOnly=false;
			formObj.ibd_tp_cd.className="input";
			formObj.ibd_tp_cd.readOnly=false;
		}
		if (formObj.bl_fpo.value == "1") {
			formObj.f_pod.className="input";
			formObj.f_pod.readOnly=false;
		}
		if (formObj.bl_mib.value == "1") {
			formObj.ibd_trsp_no.className="input";
			formObj.ibd_trsp_no.readOnly=false;
		}
		if (ofcCode != "Origin" && formObj.bl_ftz.value == "1") {
			free_trd_zn_flg.SetEnable(1);
		}
	}
	/**
	 * deactivating after saving
	 */
	function setUnEditable() {
		var formObj=document.form;
		if (formObj.bl_vvd.value == "1") {
			formObj.vvd.className="input2";
			formObj.vvd.readOnly=true;
		}
		if (formObj.bl_pod.value == "1") {
			formObj.pod_cd.className="input2";
			formObj.pod_cd.readOnly=true;
		}
		if (formObj.bl_del.value == "1") {
			formObj.del_cd.className="input2";
			formObj.del_cd.readOnly=true;
		}
		if (formObj.bl_cstms.value == "1") {
			formObj.cstms_loc_cd.className="input2";
			formObj.cstms_loc_cd.readOnly=true;
		}
		if (formObj.bl_hub.value == "1") {
			formObj.hub_loc_cd.className="input2";
			formObj.hub_loc_cd.readOnly=true;
			formObj.ibd_tp_cd.className="input2";
			formObj.ibd_tp_cd.readOnly=true;
		}
		if (formObj.bl_fpo.value == "1") {
			formObj.f_pod.className="input2";
			formObj.f_pod.readOnly=true;
		}
		if (formObj.bl_mib.value == "1") {
			formObj.ibd_trsp_no.className="input2";
			formObj.ibd_trsp_no.readOnly=true;
		}
		if (formObj.bl_ftz.value == "1") {
			free_trd_zn_flg.SetEnable(0);
		}
	}
	/**
	 * activating button
	 */
	function setButton() {
		if (ofcCode == "Origin" && trnkBdrFlg == "Y") {
			ComBtnDisable("btn_edit");
			ComBtnDisable("btn_save");
			ComBtnDisable("btn_del");
			ComBtnDisable("btn_reactivate");
			ComBtnDisable("btn_transmit");
			ComBtnDisable("btn_trans_ptt");
			ComBtnDisable("btn_trans_isf");
		} else {
			ComBtnEnable("btn_edit");
			ComBtnEnable("btn_save");
			if (sheetObjects[0].GetCellValue(1,"mf_sts_cd") == 'A') {
				ComBtnEnable("btn_del");
				ComBtnDisable("btn_reactivate");
			} else {
				ComBtnDisable("btn_del");
				ComBtnEnable("btn_reactivate");
			}
			ComBtnEnable("btn_transmit");
			if (document.form.bl_ptt.value == "1") {
				ComBtnEnable("btn_trans_ptt");
			}
			// deactivating Transmit ISF button in case of M.B/L and Filer = '01'
			if (document.form.mbl_no.value == "" && document.form.cstms_file_tp_cd.value == "01") {
				ComBtnDisable("btn_trans_isf");
			} else {
				ComBtnEnable("btn_trans_isf");
			}
		}
		if(document.form.div_ind.value == "DIV" && document.form.bl_div.value == "1"){
			ComBtnEnable("btn_div");
		}else{
			ComBtnDisable("btn_div");
		}
	}
	/**
	 * returning formatted string
	 */
	function AddComma(obj, sFormat) {
		try {
			var sVal=obj.value.replace(/\,/g, "");
			switch (sFormat) {
			case "#,###":
				obj.value=ComAddComma(sVal);
				break;
			case "#,###.###":
				if (sVal == ".")
					sVal="0.";
				p=sVal.split(".");
				p[0]=ComAddComma(p[0]);
				if (p.length <= 1)
					obj.value=p[0];
				else if (p.length == 2)
					obj.value=p[0] + "." + p[1].substr(0, 3);
				else if (p.length > 2)
					obj.value=p[0] + "." + p[1].substr(0, 3);
				else
					sVal="";
				break;
			}
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	}
	/**
	 * opening and printing RD
	 */
	function rdOpen() {
		loadTabPage(2); // loading Customs Result Tab
		var formObject=document.form;
		var blNo=formObject.bl_no.value;
		var pMib=formObject.ibd_trsp_no.value;
		var type=formObject.ibd_tp_cd.value;
		var vvd=formObject.vvd.value + "(" + formObject.vsl_eng_nm.value + ")";
		var pod=formObject.pod_cd.value;
		var eta=formObject.vps_eta_dt2.value;
		var pol=formObject.pol_cd.value;
		var del=formObject.del_cd.value;
		var hub=formObject.hub_loc_cd.value;
		var usa=formObject.usa_lst_loc_cd.value;
		var qty=formObject.pck_qty.value + " " + formObject.ams_pck_tp_cd.value;
		var wgt=formObject.cgo_wgt.value + " " + formObject.wgt_ut_cd.value;
		var f=formObject.frt_clt_flg.value;
		var o=formObject.obl_rdem_flg.value;
		var c=formObject.cstms_clr_cd.value;
		var shpr_nm=document.getElementById("t1frame").contentWindow.getFormString("shpr_cust_nm");
		var shpr_addr=document.getElementById("t1frame").contentWindow.getFormString("shpr_cust_addr");
		var cnee_nm=document.getElementById("t1frame").contentWindow.getFormString("cnee_cust_nm");
		var cnee_addr=document.getElementById("t1frame").contentWindow.getFormString("cnee_cust_addr");
		var ntfy_nm=document.getElementById("t1frame").contentWindow.getFormString("ntfy_cust_nm");
		var ntfy_addr=document.getElementById("t1frame").contentWindow.getFormString("ntfy_cust_addr");
		var antf_nm=document.getElementById("t2frame").contentWindow.getFormString("antf_cust_nm");
		var antf_addr=document.getElementById("t2frame").contentWindow.getFormString("antf_cust_addr");
		var param="/rp [" + blNo + "][" + pMib + "][" + type + "][" + vvd + "][" + pod + "][" + eta + "][" + pol + "][" + del
				+ "][" + hub + "][" + usa + "][" + qty + "][" + wgt + "][" + f + "][" + o + "][" + c + "][" + shpr_nm + "]["
				+ shpr_addr + "][" + cnee_nm + "][" + cnee_addr + "][" + ntfy_nm + "][" + ntfy_addr + "][" + antf_nm + "]["
				+ antf_addr + "]";
		var rdParam=param + " /riprnmargin /rwait";
		var strPath=RD_path + "apps/opus/esm/bkg/customsdeclaration/manifestlistdownload/usa/report/ESM_BKG_5013.mrd";
//		viewer.openFile(strPath, RDServer + rdParam,{timeout:1800});
//		viewer.print({isServerSide:true});
		directReportDownload([{mrdPath:strPath, mrdParam:RDServer+rdParam}]);
	}
	 /**
	 * BackEndJob
	 */
	 function doActionValidationResult(sheetObj, sKey) {
		var sXml=sheetObj.GetSearchData("ESM_BKG_0034_11GS.do?f_cmd=" + SEARCH03
				+ "&key=" + sKey);
		var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			ComShowCodeMessage('BKG00101');
			doActionIBSheet(sheetObj, document.form, IBSEARCH);
			return;
		} else if (sJbStsFlg == "FAIL") {
			clearInterval(intervalId);
			ComOpenWait(false);
			ComShowMessage(ComResultMessage(sXml));
		}
	 }

