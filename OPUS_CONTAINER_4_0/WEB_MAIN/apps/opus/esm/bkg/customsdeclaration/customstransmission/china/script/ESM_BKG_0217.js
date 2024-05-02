/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0217
*@FileTitle  : B/L Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){

	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObjects[0], formObject, IBRESET);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_Mark":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC01);
				break;
			case "btn_Transmit":
				doActionIBSheet(sheetObjects[0], formObject, MULTI01);
				break;
			case "btn_Close":
				ComClosePopup();
				break;
			case "btn_RowAdd":
				doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
				break;
			case "btn_RowAdd_3":
				doActionIBSheet(sheetObjects[2],formObject,IBINSERT);
				break;
			case "btn_RowDel":
				doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
				break;
			case "btn_RowDel_3":
				doActionIBSheet(sheetObjects[2],formObject,IBDELETE);
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
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
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 *  registering Combo Object as list
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}


/**
 * Register as array  to IBTab Object
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}


function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0 ;
				InsertItem( "Container Info." , "");
				InsertItem( "Customer Info." , "");
				InsertItem( "Danger Info." , "");
			}
			break;
	}
	tabObj.SetSelectedIndex(0);
}


/**
 * initializing Tab
 * setting Tab items
 */
function tab1_OnChange(tabObj , tabIndex) {
	var objs=document.all.item("tabLayer");
	objs[tabIndex].style.display="inline";
	for (var i = 0; i < objs.length; i ++) {
		if (i != tabIndex) {
			objs[i].style.display = "none";
			objs[i].style.zIndex=objs[tabIndex].style.zIndex -1 ;
		}
	}
}


/**
 * Combo Object Initialization
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
		case "trsp_mod_id":
			var i=0;
			with(comboObj) {
				SetColBackColor(0,"#FFFFFF");
				SetDropHeight(200);
				SetMultiSelect(0);
				SetMaxSelect(1);
			}
			break;
		case "seal_pty_tp_cd":
			with(comboObj) {
				SetColBackColor(0,"#CCFFFD");
				SetDropHeight(200);
				SetMultiSelect(0);
				SetMaxSelect(1);
			}
			break;
		case "wgt_ut_cd":
			var i=0;
			with(comboObj) {
				SetColBackColor(0,"#FFFFFF");
				SetDropHeight(200);
				SetMultiSelect(0);
				SetMaxSelect(1);
			}
			break;
		case "meas_ut_cd":
			var i=0;
			with(comboObj) {
				SetColBackColor(0,"#FFFFFF");
				SetDropHeight(200);
				SetMultiSelect(0);
				SetMaxSelect(1);
			}
			break;
		case "msg_type":
			var i=0;
			with(comboObj) {
				SetColBackColor(0,"#CCFFFD");
				SetDropHeight(200);
				SetMultiSelect(0);
				SetMaxSelect(1);
			}
			break;
	}
}


function loadPage() {
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
	}
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
		sheetObjects[i].SetWaitImageVisible(0);
	}
	for(i=0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}

	axon_event.addListenerForm("focus","obj_FocusIn", document.form);
	axon_event.addListenerForm("blur","obj_FocusOut", document.form);
	// axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	// axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	var formObj = document.form;
	var t1sheet1 = sheetObjects[0];
	var arrXml = formObj.code_list.value.split("|$$|");
	var arrCombo;

	ComXml2ComboItem(arrXml[0], trsp_mod_id, "val", "desc");
	ComXml2ComboItem(arrXml[2], seal_pty_tp_cd, "val", "desc");
	seal_pty_tp_cd.InsertItem(0, ' ', ' ');

	ComXml2ComboItem(arrXml[3], wgt_ut_cd, "val", "desc");
	ComXml2ComboItem(arrXml[4], meas_ut_cd, "val", "desc");

	ComXml2ComboItem(arrXml[5], msg_type, "attr_ctnt1", "attr_ctnt2");

	wgt_ut_cd.SetSelectCode("KGS");
	meas_ut_cd.SetSelectCode("CBM");

	arrCombo = ComXml2ComboString(arrXml[1], "desc", "val");
	t1sheet1.SetColProperty("seal_knd_cd", {ComboText:"|" + arrCombo[0], ComboCode:"|" + arrCombo[1]} );
	arrCombo = ComXml2ComboString(arrXml[2], "desc", "val");
	t1sheet1.SetColProperty("seal_pty_tp_cd", {ComboText:"|" + arrCombo[0], ComboCode:"|" + arrCombo[1]} );
	arrCombo = ComXml2ComboString(arrXml[3], "desc", "val");
	t1sheet1.SetColProperty("wgt_ut_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
	arrCombo = ComXml2ComboString(arrXml[4], "desc", "val");
	t1sheet1.SetColProperty("meas_ut_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );

	if (formObj.bl_no.value != "") {
		doActionIBSheet(t1sheet1, formObj, IBSEARCH);
	} else {
		SetButtonStatus();    // Button Disabled
		// formObj.bl_no.focus();
	}
}


function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "t1sheet1":
			with(sheetObj){

				  var HeadTitle1="|Sel.|Seq.|trans_mode|bl_no|Container No.|Tp.|full_mty_cd|Seal No.|Seal Kind|Sealer|Sealer|Weight|Weight|Measure|Measure|pck|pck|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right|Over Front / Back / Height / Left / Right";
				  var headCount=ComCountHeadTitle(HeadTitle1);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
						 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chn_mf_snd_ind_cd",  KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",            KeyField:1,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14, AcceptKeys:"E|N" , InputCaseSensitive:1  },
						 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",       KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"full_mty_cd",        KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"seal_no",            KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20, AcceptKeys:"E|N" , InputCaseSensitive:1  },
						 {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:"seal_knd_cd",        KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Combo",     Hidden:0, Width:105,  Align:"Left",    ColMerge:0,   SaveName:"seal_pty_tp_cd",     KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"seal_pty_nm",        KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",     Hidden:0, Width:135,  Align:"Right",   ColMerge:0,   SaveName:"cntr_wgt",           KeyField:0,   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
						 {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"wgt_ut_cd",          KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",     Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"cntr_meas_qty",      KeyField:0,   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1,   EditLen:12 },
						 {Type:"Combo",     Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"meas_ut_cd",         KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pck_qty",            KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"pck_tp_cd",          KeyField:0,   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Float",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dim_fnt_len",    KeyField:0,   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
						 {Type:"Float",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dim_rear_len",   KeyField:0,   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
						 {Type:"Float",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_hgt",            KeyField:0,   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
						 {Type:"Float",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dim_lf_len",     KeyField:0,   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
						 {Type:"Float",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ovr_dim_rt_len",     KeyField:0,   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 } ];

				  InitColumns(cols);

				  SetEditable(1);
				  SetCountPosition(0);
				  SetSheetHeight(220);
				}



		break;
		case "t2sheet1":
			with(sheetObj){
					 var HeadTitle1="|Seq.|trans_mode|bl_no|BKG_CUST_TP_CD|CUST_NM|CUST_ADDR";
					 var headCount=ComCountHeadTitle(HeadTitle1);

					 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					 InitHeaders(headers, info);

					 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Seq",  Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
						 {Type:"Text", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chn_mf_snd_ind_cd",  Edit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text", Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",              Edit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cust_tp_cd",     Edit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text", Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cust_nm",            Edit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text", Hidden:0, Width:300,  Align:"Center",  ColMerge:1,   SaveName:"cust_addr",          Edit:1, AcceptKeys:"E|N" , InputCaseSensitive:1 } ];

					 InitColumns(cols);

					 SetEditable(1);
					 SetCountPosition(0);
					 SetVisible(false);
				  }


		break;
		case "t3sheet1":
			with(sheetObj){

					 var HeadTitle1="|Sel.|Seq.|trans_mode|bl_no|Container No.|Class|UN DGNO|Label||";
					 var headCount=ComCountHeadTitle(HeadTitle1);

					 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					 var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					 var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					 InitHeaders(headers, info);

					 var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"CheckBox", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Chk" },
						 {Type:"Seq",      Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
						 {Type:"Text",     Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"chn_mf_snd_ind_cd",     KeyField:0,   Edit:1 },
						 {Type:"Text",     Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",                 KeyField:0,   Edit:1 },
						 {Type:"Text",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",               KeyField:1,   Edit:1,   EditLen:14, AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",          KeyField:0,   Edit:1,   EditLen:3,  AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text",     Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",            KeyField:0,   Edit:1,   EditLen:4,  AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text",     Hidden:0, Width:500,  Align:"Center",  ColMerge:1,   SaveName:"imdg_subs_rsk_lbl_cd",  KeyField:0,   Edit:1,   EditLen:3,  AcceptKeys:"E|N" , InputCaseSensitive:1 },
						 {Type:"Text",     Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_nm",          KeyField:0,   Edit:1 },
						 {Type:"Text",     Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntc_pson_telcm_no",    KeyField:0,   Edit:1 } ];

					 InitColumns(cols);

					 SetEditable(1);
					 SetCountPosition(0);
					 SetSheetHeight(220);
				  }
		break;
	}
}


function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if (!validateForm(sheetObj,formObj,sAction)) return false;
			initFormData();
			ComOpenWait(true);
			var transMode = formObj.trans_mode.value;
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0217GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			var State=ComGetEtcData(arrXml[0],ComWebKey.Trans_Result_Key);
			if (State == "S") {
				//sheetObj.RenderSheet(0);
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
				ComEtcDataXmlToForm(arrXml[0], formObj);
				formObj.vvd_pod_cd.value=formObj.bkg_pod_cd.value;
				//sheetObj.RenderSheet(1);
				if (ComGetEtcData(arrXml[0],"bl_no") == undefined &&
					 ComGetEtcData(arrXml[0],"shpr_nm") == undefined &&
					 sheetObjects[0].GetTotalRows()== 0 &&
					 sheetObjects[2].GetTotalRows()== 0 ) {
						ComShowCodeMessage("BKG00889"); // No Data Found
				} else {
					trsp_mod_id.SetSelectCode(ComGetEtcData(arrXml[0],"trsp_mod_id"));
					wgt_ut_cd.SetSelectCode(ComGetEtcData(arrXml[0],"wgt_ut_cd") == "" ? 'KGS' : ComGetEtcData(arrXml[0],"wgt_ut_cd"));
					meas_ut_cd.SetSelectCode(ComGetEtcData(arrXml[0],"meas_ut_cd") == "" ? 'CBM' : ComGetEtcData(arrXml[0],"meas_ut_cd"));
					if(document.form.pck_qty.value != "") AddComma( document.form.pck_qty, "#,###.#" );
					if(document.form.act_wgt.value != "") AddComma( document.form.act_wgt, "#,###.#" );
					if(document.form.meas_qty.value != "") AddComma( document.form.meas_qty, "#,###.#" );
					if(document.form.temp.value != "") AddComma( document.form.temp, "#,###.#" );
					SetButtonStatus();	// Button GetEnable()d
				}
			} else {
				ComShowMessage(ComResultMessage(sXml));
			}

			if (transMode.value == "D") {
				msg_type.SetSelectCode("0", true);
			} else {
				msg_type.SetSelectCode("9", true );
			}
			ComOpenWait(false);
		break;

		case IBROWSEARCH: // 그리드에서 Container No. 입력시 조회
			if(!validateForm(sheetObj,formObj,IBSEARCH)) return false;
			formObj.f_cmd.value=SEARCH01;
			sheetObj.SetWaitImageVisible(0);
			var Row=sheetObj.GetSelectRow();
			var params=FormQueryString(formObj)+"&cntr_no="+sheetObj.GetCellValue(Row, "cntr_no");
			var sXml=sheetObj.GetSearchData("ESM_BKG_0217GS.do", params);
			var cntr_no=ComGetEtcData(sXml, "cntr_no");
			var cntr_tpsz_cd=ComGetEtcData(sXml, "cntr_tpsz_cd");

			if(cntr_no == undefined || cntr_no == ""){
				ComShowCodeMessage("BKG06012", sheetObj.GetCellText(Row, "cntr_no"));
				sheetObj.SetCellValue(Row, "cntr_no","",0);
				sheetObj.SelectCell(Row, "cntr_no");
				if(sheetObj.id == "t1sheet1"){
					sheetObj.SetCellValue(Row, "cntr_tpsz_cd","",0);
				}
			}else{
				sheetObj.SetCellValue(Row, "cntr_no",cntr_no,0);
				if(sheetObj.id == "t1sheet1"){
					sheetObj.SetCellValue(Row, "cntr_tpsz_cd",cntr_tpsz_cd,0);
				}
			}
		break;

		case IBRESET:        //New
			formObj.reset();
			wgt_ut_cd.SetSelectCode("KGS");
			meas_ut_cd.SetSelectCode("CBM");
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[2].RemoveAll();
			SetButtonStatus();	// Button Disabled
			document.form.bl_no.focus();
		break;

		case IBSAVE:         //Save
			if(!validateForm(sheetObj,formObj,IBSAVE)) return false;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sheet2=sheetObjects[1];
			sheet2.RemoveAll();
			var row;
			row=GetAddRowIndex(sheet2);
			sheet2.SetCellValue(row, "bkg_cust_tp_cd",'S',0);
			sheet2.SetCellValue(row, "cust_nm",formObj.shpr_nm.value,0);
			sheet2.SetCellValue(row, "cust_addr",formObj.shpr_addr.value,0);
			row=GetAddRowIndex(sheet2);
			sheet2.SetCellValue(row, "bkg_cust_tp_cd",'C',0);
			sheet2.SetCellValue(row, "cust_nm",formObj.cnee_nm.value,0);
			sheet2.SetCellValue(row, "cust_addr",formObj.cnee_addr.value,0);
			row=GetAddRowIndex(sheet2);
			sheet2.SetCellValue(row, "bkg_cust_tp_cd",'N',0);
			sheet2.SetCellValue(row, "cust_nm",formObj.ntfy_nm.value,0);
			sheet2.SetCellValue(row, "cust_addr",formObj.ntfy_addr.value,0);
			var params=FormQueryString(formObj) + "&";
			var params1=ComSetPrifix(ComGetSaveString(sheetObjects[0], false, true), "t1_") + "&";
			var params2=ComSetPrifix(ComGetSaveString(sheetObjects[1], false, true), "t2_") + "&";
			var params3=ComSetPrifix(ComGetSaveString(sheetObjects[2], false, true), "t3_");
			var sXml=sheetObj.GetSaveData("ESM_BKG_0217GS.do", params+params1+params2+params3);
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State == "S"){
				//sheetObj.RenderSheet(0);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				//sheetObj.RenderSheet(1);
				ComOpenWait(false);
				ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			}else{
				ComOpenWait(false);
				ComShowMessage(ComResultMessage(sXml));
			}
		break;

		case IBINSERT:       //Row Add
			var row=GetAddRowIndex(sheetObj);
		break;

		case IBDELETE:		 //Row Del
			if(ComShowCodeConfirm('BKG03037')){
				ComRowHideDelete(sheetObj,"Chk");
			}
		break;

		case IBSEARCH_ASYNC01:	//Mark
//			ComOpenWindowCenter("ESM_BKG_1036.do?pgmNo=ESM_BKG_1036&bl_mk_desc="+formObj.bl_mk_desc.value, "ESM_BKG_1036", 330, 248);

			var url="ESM_BKG_1036.do?pgmNo=ESM_BKG_1036&bl_mk_desc="+formObj.bl_mk_desc.value;
			ComOpenWindowCenter(url, "ESM_BKG_1036", 360, 300, true);

		break;

		case MULTI01: // Transmit Manifest
			if(!validateForm(sheetObj,formObj,MULTI01))	return false;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			var sXml=sheetObj.GetSaveData("ESM_BKG_0217GS.do", FormQueryString(formObj));
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			ComShowMessage(ComResultMessage(sXml));

			ComOpenWait(false);

			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		break;
	}
}


function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH: // Retrieve
			if(!ComChkRequired(formObj)) return false;
			return true;
			break;
		case IBSAVE: // Save
			for(var i=1; i<sheetObj.RowCount()+1; i++){
				if(sheetObj.GetCellValue(i, "cntr_no") == "") {
					ComShowCodeMessage('BKG00104','Container Info.');
					tabObjects[0].SetSelectedIndex(0);
					sheetObj.SelectCell(i, "cntr_no");
					return false;
				}
			}
			var sheetObj3=sheetObjects[2];
			for(var i=1; i<sheetObj3.RowCount()+1; i++){
				if(sheetObj3.GetCellValue(i, "cntr_no") == "") {
					ComShowCodeMessage('BKG00104','Danger Info.');
					tabObjects[0].SetSelectedIndex(2);
					sheetObj3.SelectCell(i, "cntr_no");
					return false;
				}
			}
			return true;
			break;
		case MULTI01: // transmit
			var sheetObject1=sheetObjects[0]; // Container Info
			var sheetObject3=sheetObjects[2]; // Danger Info
			var formObject=document.form;

			if(formObject.bkg_cgo_tp_cd.value=="F"){
				// form & tab2

				if( ComTrim(formObject.pck_qty.value) <= 0 || ComTrim(formObject.pck_tp_cd.value) == "") {
					ComShowCodeMessage("BKG06155", "Package");
					return false;
				} else if( ComTrim(formObject.act_wgt.value) <= 0 || ComTrim(wgt_ut_cd.GetSelectCode()) == ""){
					ComShowCodeMessage("BKG06155", "Weight");
					return false;
				}
				else if( ComTrim(formObj.rcv_term_cd.value) == "" || ComTrim(formObj.de_term_cd.value) == ""){
					ComShowCodeMessage("BKG06155", "R/D Term");
					return false;
				} else if( ComTrim(formObj.frt_term_cd.value) == ""){
					ComShowCodeMessage("BKG06155", "Freight");
					return false;
				} else if( ComTrim(formObj.shpr_nm.value) == ""
						|| ComTrim(formObj.shpr_addr.value) == ""
						|| ComTrim(formObj.cnee_nm.value) == ""
						|| ComTrim(formObj.cnee_addr.value) == ""
						|| ComTrim(formObj.ntfy_nm.value) == ""
						|| ComTrim(formObj.ntfy_addr.value) == ""){
					ComShowCodeMessage("BKG06155", "Customer Info.");
					return false;
				}

				for( var i=1; i <= sheetObject1.RowCount(); i++ ) {
					if( ComTrim(sheetObject1.GetCellValue(i, "seal_no")) == ""){
						ComShowCodeMessage("BKG06155", "Seal No.");
						return false;
					} else if( ComTrim(sheetObject1.GetCellText(i, "seal_knd_cd")) == "" ){
						ComShowCodeMessage("BKG06155", "Seal Kind");
						return false;
					} else if( ComTrim(sheetObject1.GetCellText(i, "seal_pty_tp_cd")) == "" ){
						ComShowCodeMessage("BKG06155", "Sealer");
						return false;
					}
				}//end for

				for( var i=1; i <= sheetObject3.RowCount(); i++ ) {
					var psonNm=ComTrim(sheetObject3.GetCellValue(i, "cntc_pson_nm"));
					var psonTel=ComTrim(sheetObject3.GetCellValue(i, "cntc_pson_telcm_no"));
					if(psonNm == ""){
						ComShowCodeMessage("BKG06155", "DG Contact Person");
						return false;
					}else if (psonTel== ""){
						ComShowCodeMessage("BKG06155", "DG Emergency Contact");
						return false;
					}
				}//end for
			}
			return true;
			break;
	}
}


function t1sheet1_OnChange(sheetObj, row, col, val){
	if(sheetObj.ColSaveName(col) == "seal_pty_tp_cd") {
		document.form.seal_pty_tp_cd.SetSelectCode(val);
		sheetObj.SetCellValue(row, "seal_pty_nm",document.form.seal_pty_tp_cd.GetSelectText(),0);

	} else if (sheetObj.ColSaveName(col) == "cntr_no" && sheetObj.GetCellValue(row, "cntr_no") != "") {
		for(var i=1; i<=sheetObj.LastRow(); i++){
			if(i == row) continue;
			if(sheetObj.GetCellValue(i, "cntr_no") == sheetObj.GetCellValue(row, "cntr_no")) {
				ComShowCodeMessage("BKG00965", sheetObj.GetCellValue(row, "cntr_no"));
				sheetObj.SetCellValue(row, "cntr_no","",0);
				sheetObj.SelectCell(row, "cntr_no");
				return;
			}
		}
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH);
	}
}


function t3sheet1_OnChange(sheetObj, row, col, val) {
	if (sheetObj.ColSaveName(col) == "cntr_no" && sheetObj.GetCellValue(row, "cntr_no") != ""){
		doActionIBSheet(sheetObj,document.form,IBROWSEARCH);
	}
}


function obj_FocusIn(){
	var srcObj=window.event.srcElement;
	var srcName=ComGetEvent("name");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "pck_qty" || srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign="left";
		if(srcValue.substr(srcValue.length-4) == ".000"){
			srcObj.value=srcValue.substr(0, srcValue.length-4);
		}
	}
	if (srcName == "temp") {
		srcObj.style.textAlign="left";
		if(srcValue == "0.0"){
			srcObj.value="";
		}
	}
}


function obj_FocusOut(){
	var srcObj=window.event.srcElement;
	var srcName=ComGetEvent("name");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "pck_qty" || srcName == "act_wgt" || srcName == "meas_qty") {
		srcObj.style.textAlign="right";
		AddComma(srcObj,"#,###.#");
	}
	if (srcName == "temp") {
		srcObj.style.textAlign="right";
		if(srcValue == ""){
			srcObj.value="0.0";
		}else{
			AddComma(srcObj,"#,###.#");
		}
	}
}


function obj_KeyUp() {
	var srcObj=window.event.srcElement;
	var srcName=ComGetEvent("name");
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	if (srcName == "pck_qty" || srcName == "act_wgt" || srcName == "meas_qty") {
		AddComma(srcObj,"#,###.###",srcMaxLength);
	}
	if (srcName == "temp") {
		AddComma(srcObj,"#,###.##",srcMaxLength);
	}
}


function initFormData() {
	var frmChild = document.getElementsByTagName("input");
	for(var i=0; i<frmChild.length; i++){
		if(frmChild[i].type == "text") {
			if(frmChild[i].name != "trans_mode" && frmChild[i].name != "bl_no" && frmChild[i].name != "msg_type") {
				frmChild[i].value="";
			}
		}

		if(frmChild[i].type == "hidden"){
			if( frmChild[i].name == "bl_mk_desc" ||
				frmChild[i].name == "bkg_pol_cd" ||
				frmChild[i].name == "bkg_pod_cd" ||
				frmChild[i].name == "chn_mf_snd_ind_cd" ) {
				frmChild[i].value = "";
			}
		}
		if(frmChild[i].type == "checkbox") {
			frmChild[i].checked=false;
		}
	}
	wgt_ut_cd.SetSelectCode("KGS");
	meas_ut_cd.SetSelectCode("CBM");

	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}


function AddComma(obj, sFormat, len){
	try {
		var sVal=obj.value.replace(/\,/g,"");
		switch(sFormat){
			case "#,###":
				obj.value=ComAddComma(sVal);
				break;
			case "#,###.#":
				if(sVal == ".") sVal="0.";
				p=sVal.split(".");
				p[0]=ComAddComma(p[0]);
				if      (p.length <= 1) obj.value=p[0]+".000";
				else if (p.length == 2) obj.value=p[0]+"."+p[1].substr(0,3);
				else if (p.length > 2) 	obj.value=p[0]+"."+p[1].substr(0,3);
				else sVal="";
				break;
			case "#,###.##":
				if(sVal == ".") sVal="0.";
				p=sVal.split(".");
				p[0]=ComAddComma(p[0]);
				if (p.length <= 1) {
					if(p[0].length > len-3) {
						sVal=p[0].substr(0, len-3).replace(/\,/g,"");
						p[0]=ComAddComma(sVal);
					}
					obj.value=p[0];
				}
				else if (p.length == 2) obj.value=p[0]+"."+p[1].substr(0,2);
				else if (p.length > 2) obj.value=p[0]+"."+p[1].substr(0,2);
				else sVal="";
				break;
			case "#,###.###":
				if(sVal == ".") sVal="0.";
				p=sVal.split(".");
				p[0]=ComAddComma(p[0]);
				if (p.length <= 1) {
					if(p[0].length > len-4) {
						sVal=p[0].substr(0, len-3).replace(/\,/g,"");
						p[0]=ComAddComma(sVal);
					}
					obj.value=p[0];
				}
				else if (p.length == 2) obj.value=p[0]+"."+p[1].substr(0,3);
				else if (p.length > 2) obj.value=p[0]+"."+p[1].substr(0,3);
				else sVal="";
				break;
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}


function GetAddRowIndex(sheetObj){
	var row=sheetObj.DataInsert(-1);
	sheetObj.SetCellValue(row, "chn_mf_snd_ind_cd",document.form.trans_mode.value,0);
	sheetObj.SetCellValue(row, "bl_no",document.form.bl_no.value,0);
	return row;
}


function SetButtonStatus() {
	if (document.form.bl_no.value == "") {
		ComBtnDisable("btn_RowAdd");
		ComBtnDisable("btn_RowDel");
		ComBtnDisable("btn_RowAdd_3");
		ComBtnDisable("btn_RowDel_3");
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Transmit");
		ComBtnDisable("btn_Mark");
	} else{
		 ComBtnEnable("btn_RowAdd");
		 ComBtnEnable("btn_RowDel");
		 ComBtnEnable("btn_RowAdd_3");
		 ComBtnEnable("btn_RowDel_3");
		 ComBtnEnable("btn_Save");
		 ComBtnEnable("btn_Transmit");
		 ComBtnEnable("btn_Mark");
	}
}
