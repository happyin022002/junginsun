/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0505.js
*@FileTitle  : B/L Inquiry(Add & Edit B/L) Customer Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
//public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	//var sheetObject4=sheetObjects[3];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_New":
			//form initialization
			resetForm(formObject);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject2,document.form,IBSAVE);
			break;
		case "btn_BLBKGNoASSGN":
			doActionIBSheet(sheetObject1,document.form,COMMAND01);
			break;
		case "btn_t1RowAdd":
			sheetObject1.DataInsert(-1);
			var prefix="kc_";
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix+"pck_tp_cd","",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix+"cntr_wgt","0",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix+"pck_qty","0",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix+"meas_qty","0",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix+"cntr_tpsz_cd","",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix+"full_mty_cd","",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), prefix+"full_mty_cd","",0);
			break;
		case "btn_t1Delete":
			doActionIBSheet(sheetObject1,document.form,IBDELETE);
			break;
		case "btn_t1LoadExcel":
			sheetObject1.RenderSheet(0);
			var columns="4=>kc_cntr_no|5=>kc_full_mty_cd|6=>kc_cntr_seal_no1|7=>kc_cntr_seal_no2|8=>kc_cntr_tpsz_cd|9=>kc_pck_qty|10=>kc_pck_tp_cd|11=>kc_cntr_wgt|12=>kc_wgt_ut_cd|13=>kc_meas_qty|14=>kc_meas_ut_cd|15=>kc_chk_empty";
			var oldCnt=sheetObject1.RowCount();
			var cnt=0;
			sheetObject1.LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:true,ColumnMapping:"columns"});
			ComOpenWait(true);
			for(var i=oldCnt+1; i <= sheetObject1.RowCount(); i++) {
				// 12 times the column of Excel data loaded from the P or E to E if the set MTY_CD
				if (sheetObject1.GetCellValue(i, "kc_chk_empty")=="P" || sheetObject1.GetCellValue(i, "kc_chk_empty")=="E" ) {
					sheetObject1.SetCellValue(i, "kc_full_mty_cd","E");
				}
				// Check CNTR_NO greater than or equal to 97 and the first character to delete processing is less than or equal to 122
				if (sheetObject1.GetCellValue(i, "kc_cntr_no").length > 0 ) {
					var charCode=sheetObject1.GetCellValue(i, "kc_cntr_no").charCodeAt(0);
					if (97 <= charCode && charCode <= 122 ) sheetObject1.RowDelete(i, false);
				}
			}
			// Remove redundant container
			for(var i=1; i <= sheetObject1.RowCount(); i++) {
				for(var j=1; j <= sheetObject1.RowCount();j++) {
					if (i==j) continue;
					if (sheetObject1.GetCellValue(i,"kc_cntr_no")==sheetObject1.GetCellValue(j, "kc_cntr_no")) {
						sheetObject1.RowDelete(j, false);
					}
				}
			}
			ComOpenWait(false);
			sheetObject1.RenderSheet(1);
			cnt=sheetObject1.RowCount()- oldCnt;
			ComShowCodeMessage("BKG95021", cnt);
			break;
		case "btn_t3RowAdd":
			sheetObject3.DataInsert(-1);
			sheetObject3.SetCellValue(sheetObject3.GetSelectRow(), "ke_pck_tp_cd","",0);
			sheetObject3.SetCellValue(sheetObject3.GetSelectRow(), "ke_divd_pck_ut_cd","",0);
			sheetObject3.SetCellValue(sheetObject3.GetSelectRow(), "ke_wgt_ut_cd","",0);
			sheetObject3.SetCellValue(sheetObject3.GetSelectRow(), "ke_prt_lodg_flg","",0);
			sheetObject3.SetCellValue(sheetObject3.GetSelectRow(), "ke_kr_xpt_pck_id","",0);
			break;
		case "btn_t3Delete":
			doActionIBSheet(sheetObject3,document.form,IBDELETE);
			break;
		case "btn_t3LoadExcel":
			sheetObject3.LoadExcel();
			break;
		} // end switch
	}catch(e) {
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
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	//axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	ComBtnDisable('btn_Retrieve');


	if (formObj.mode.value=='ADD') {
		ComBtnEnable('btn_BLBKGNoASSGN');
		ComBtnDisable('btn_Retrieve');
		comboObjects[0].SetSelectCode("");
	}else {
		ComBtnDisable('btn_BLBKGNoASSGN');
		ComBtnEnable('btn_Retrieve');
		form.bl_no.className="input2";
		form.bl_no.readOnly=true;
	}
	// Data retrieve and Combo mapping
	doActionIBSheet(sheetObjects[0], formObj, COMMAND09);
	// In case of EDIT, auto retrieve
	if (form.mode.value=='EDIT') {
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}
	// TRANS TP
	form.old_cstms_decl_tp_cd.value=form.cstms_decl_tp_cd.value;
	getTaxCode();
}
/**
 * process after loading T1Sheet1
 * @param sheetObj
 * @return
 */
function t1sheet1_OnLoadFinish(sheetObj) {
	var form=document.form;
	if (form.mode.value=='ADD') {
		ComBtnEnable('btn_BLBKGNoASSGN');
		ComBtnDisable('btn_Retrieve');
		comboObjects[0].SetSelectCode("");
	}else {
		ComBtnDisable('btn_BLBKGNoASSGN');
		ComBtnEnable('btn_Retrieve');
		form.bl_no.className="input2";
		form.bl_no.readOnly=true;
	}
	// Data retrieve and Combo mapping
	doActionIBSheet(sheetObjects[0], form, COMMAND09);
	// In case of EDIT, auto retrieve
	if (form.mode.value=='EDIT') {
		doActionIBSheet(sheetObjects[0], form, IBSEARCH);
	}
	// TRANS TP
	form.old_cstms_decl_tp_cd.value=form.cstms_decl_tp_cd.value;
	getTaxCode();
}
/**
 * setting sheet initial values and header
 *
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "t1sheet1":
		with(sheetObj){
			  var HeadTitle1="|Sel|Seq.|Container No.|Load/Empty|Seal No1.|Seal No2.|Type|Package|Package|Weight|Weight|Measure|Measure|";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  (headCount, 0, 0, true);
			  var prefix="kc_";
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Status",       Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
							 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
							 {Type:"Seq",        Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
							 {Type:"Text",       Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",       Format:"",        Edit:1 },
							 {Type:"Combo",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"full_mty_cd",   Format:"",        Edit:1 },
							 {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_seal_no1", Format:"",        Edit:1 },
							 {Type:"Text",       Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_seal_no2", Format:"",        Edit:1 },
							 {Type:"Combo",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",  Format:"",        Edit:1 },
							 {Type:"Int",        Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pck_qty",       Format:"Integer", Edit:1 },
							 {Type:"Combo",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",     Format:"",        Edit:1 },
							 {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_wgt",      Format:"Float",   Edit:1,   PointCount:1 },
							 {Type:"Combo",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd",     Format:"",        Edit:1 },
							 {Type:"Float",      Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"meas_qty",      Format:"Float",   Edit:1 },
							 {Type:"Combo",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_ut_cd",    Format:"",        Edit:1 },
							 {Type:"Text",       Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_empty",     Format:"",        Edit:1 } ];

			  InitColumns(cols);
			  SetEditable(1);
			  SetColProperty(prefix+"full_mty_cd", {ComboText:"F\tLoad|E\tEmpty", ComboCode:"F|E"} );
			  SetColProperty(prefix+"cntr_tpsz_cd", {ComboText:"D2|D4|D5|D7|R5", ComboCode:"D2|D4|D5|D7|R5"} );
			  SetColProperty(prefix+"pck_tp_cd", {ComboText:"AE\tAEROSOL", ComboCode:"AE"} );
			  SetColProperty(prefix+"wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
			  SetColProperty(prefix+"meas_ut_cd", {ComboText:"CBM|CBF", ComboCode:"CBM|CBF"} );

			  SetColProperty(prefix+"cntr_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			  SetColProperty(prefix+"cntr_seal_no1", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			  SetColProperty(prefix+"cntr_seal_no2", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			  SetColProperty(prefix+"chk_empty", {AcceptKeys : "E|N", InputCaseSensitive :1} );

			  SetShowButtonImage(2);
			  SetSheetHeight(180);
	  }
		break;
	case "t2sheet1":
		with(sheetObj){
			  var HeadTitle1="|Sel|Seq.|Data";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  (headCount, 0, 0, true);
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hd_ibflag" },
						   {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"hd_Sel" },
						   {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"hd_Seq" },
						   {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:1,   SaveName:"hd_data", Edit:1 } ];
			  InitColumns(cols);
			  SetEditable(1);
			  SetVisible(false);
			}
		break;
	case "t3sheet1":
		with(sheetObj){
			  var HeadTitle1="|Sel|Seq.|Export License No.|Package|Package|Weight|Weight|Divide|Ship|Same Pack. Ind.|Same Packing Details|Same Packing Details";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  (headCount, 0, 0, true);
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols = [ {Type:"Status",     Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						   {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
						   {Type:"Seq",        Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"ke_Seq" },
						   {Type:"Text",       Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"ke_xpt_lic_no",     Format:"",            Edit:1 },
						   {Type:"Int",        Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ke_pck_qty",        Format:"Integer",     Edit:1 },
						   {Type:"Combo",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"ke_pck_tp_cd",      Format:"",            Edit:1 },
						   {Type:"Float",      Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ke_cntr_wgt",       Format:"Float",       Edit:1,   PointCount:1},
						   {Type:"Combo",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ke_wgt_ut_cd",      Format:"",            Edit:1 },
						   {Type:"Combo",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ke_prt_lodg_flg",   Format:"",            Edit:1 },
						   {Type:"Text",       Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"ke_prt_lodg_seq",   Format:"",            Edit:1 },
						   {Type:"Combo",      Hidden:0, Width:118,  Align:"Center",  ColMerge:1,   SaveName:"ke_kr_xpt_pck_id",  Format:"",            Edit:1 },
						   {Type:"Int",        Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"ke_divd_pck_qty",   Format:"Integer",     Edit:1 },
						   {Type:"Combo",      Hidden:0, Width:160,  Align:"Center",  ColMerge:1,   SaveName:"ke_divd_pck_ut_cd", Format:"",            Edit:1 } ];

			  InitColumns(cols);
			  SetEditable(1);
			  SetColProperty("ke_pck_tp_cd", {ComboText:"AE|AR|PK|BG|", ComboCode:"AE|AR|PK|BG|"} );
			  SetColProperty("ke_wgt_ut_cd", {ComboText:"KGS|LBS|", ComboCode:"KGS|LBS|"} );
			  SetColProperty("ke_prt_lodg_flg", {ComboText:"Y|N|", ComboCode:"Y|N|"} );
			  SetColProperty("ke_kr_xpt_pck_id", {ComboText:"A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|", ComboCode:"A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|"} );
			  SetColProperty("ke_divd_pck_ut_cd", {ComboText:"AE|AR|AT|BA|BB|BC|", ComboCode:"AE|AR|AT|BA|BB|BC|"} );


			  SetColProperty("ke_xpt_lic_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			  SetColProperty("ke_prt_lodg_seq", {AcceptKeys : "E|N", InputCaseSensitive :1} );
			  SetSheetHeight(180);
	  }
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	var formObj1=document.form;
	switch(sAction) {
	case IBSEARCH:      // retrieve
		formObj.f_cmd.value=SEARCH;
		if(validateForm(sheetObj,formObj,sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObj.RemoveAll();
			var sXml=sheetObj.GetSearchData("ESM_BKG_0505GS.do", FormQueryString(formObj) );
			var arrXml=sXml.split("|$$|");
			// GRID UPDATE
			if(arrXml[0] !=null){
				//sheetObjects[0].RenderSheet(0);
				sheetObjects[0].SetWaitImageVisible(0);
				sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				//sheetObjects[0].RenderSheet(1);
			}


			if(arrXml[1] != null) {
				//sheetObjects[2].RenderSheet(0);
				sheetObjects[2].SetWaitImageVisible(0);
				sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
				//sheetObjects[2].RenderSheet(1);

			}
			// making CUSTOMER INFO tab using ETC DATA
			// mode restore
			var mode=formObj.mode.value;
			ComEtcDataToForm(formObj ,sheetObj);
			formObj.mode.value=mode;
			formObj.vvd.value=formObj.vvd_1.value;
			// CARGO TYPE setting
			comboObjects[1].SetSelectCode(formObj.bkg_cgo_tp_cd.value,false);
			// CARGO SPEC setting
			if (sheetObjects[0].GetEtcData("cargo_spec")=="1") {
				comboObjects[2].SetSelectCode("1");
			}else if (sheetObjects[0].GetEtcData("cargo_spec")=="2") {
				comboObjects[2].SetSelectCode("2");
			}else {
				comboObjects[2].SetSelectCode("");
			}
			if (formObj.cgo_spec_clear.value=="Y") comboObjects[2].SetSelectCode("");
			// PACKAGE setting
			comboObjects[3].SetSelectCode(formObj.pck_tp_cd.value,false);
			// WAREHOUSE setting
			comboObjects[4].SetSelectCode(formObj.kr_cstms_wh_tp_cd.value,false);
			// Item Code setting
			comboObjects[5].SetSelectCode(formObj.cmdt_cd.value,false);
			// Results of the Trans code storage
			formObj.old_cstms_decl_tp_cd.value=formObj.cstms_decl_tp_cd.value;
			// BizNo setting
			// If you specify a value, and if not, check that ADD
			var bizNo=ComGetMaskedValue(formObj.biz_rgst_no.value,  "saupja");
			var itemIndex=comboObjects[6].FindItem(bizNo,0);
			if (itemIndex==-1) {
				comboObjects[6].InsertItem(-1, bizNo+"|", formObj.biz_rgst_no.value);
				comboObjects[6].SetSelectCode(formObj.biz_rgst_no.value,false);
			}else {
				comboObjects[6].SetSelectIndex(itemIndex,false);
			}
			// Processing of form data in numerical form
			changeTextToNumberFormat(formObj);
			formObj.tax_code1.value=ComLpad(formObj.tax_code1.value, 3, "0");
			formObj.tax_code2.value=ComLpad(formObj.tax_code2.value, 2, "0");
			getTaxCode();
			ComOpenWait(false);
		}
		break;
	case IBSAVE:	// Add / modify / delete
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			sheetObjects[1].SetWaitImageVisible(0);
			ComOpenWait(true);
			sheetObjects[1].RemoveAll();
			sheetObjects[1].DataInsert(-1);
			sheetObjects[1].SetRowStatus(1,"U");
			formObj.f_cmd.value=MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			var params=ComGetSaveString(sheetObjects, true, true)+"&"+FormQueryString(formObj);
			sheetObjects[1].DoSave("ESM_BKG_0505GS.do", params, -1, false);
			if (formObj.mode.value=='EDIT') {
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			tabObjects[0].SetSelectedIndex(0);
			ComBtnEnable("btn_Save");
			ComOpenWait(false);
		}
		break;
	case COMMAND01:      // Bkg, Bl NO Assign
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=COMMAND01;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0505GS.do", FormQueryString(formObj), -1, false);
		sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
		var blNo=sheetObjects[1].GetEtcData('bl_no');
		var bkgNo=sheetObjects[1].GetEtcData('bkg_no');
		formObj.bl_no.value=blNo;
		formObj.bkg_no.value=bkgNo;
		ComOpenWait(false);
		break;
	case IBDELETE:		// ROW DELETE
		ComRowHideDelete(sheetObj,"Sel");
		break;
	case COMMAND09: 	// code data retrieve
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		formObj.f_cmd.value=COMMAND09;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0505GS.do", FormQueryString(formObj), -1, false);
		var arrXml=sXml.split("|$$|");
		ComXml2ComboItem(arrXml[0], comboObjects[3],  "pck_cd",			"pck_cd|pck_nm");
		var comboXML=ComXml2ComboString(arrXml[0], "pck_cd", 		"pck_nm");
		//var comboXML=ComXml2ComboString2(arrXml[0], "pck_cd", 		"pck_nm");
		var comboXML2=ComXml2ComboString (arrXml[2], "cntr_tpsz_cd", 	"cntr_tpsz_cd");
		var prefix1="kc_";

		var comboPackNm = "";

		var arrPackNm = comboXML[1].split("|");
		var arrPackCd = comboXML[0].split("|");

		for(var i = 0; i < arrPackNm.length; i++){
			comboPackNm += arrPackCd[i]+"\t"+arrPackNm[i]+"|";
		}
		//alert(comboText[1]);


		sheetObjects[0].SetColProperty(prefix1+"pck_tp_cd", {ComboText:comboPackNm, ComboCode:comboXML[0]+"|"} );
		sheetObjects[2].SetColProperty("ke_pck_tp_cd", {ComboText:comboPackNm, ComboCode:comboXML[0]+"|"} );
		sheetObjects[2].SetColProperty("ke_divd_pck_ut_cd", {ComboText:comboPackNm, ComboCode:comboXML[0]+"|"} );
//		sheetObjects[2].SetColProperty("ke_divd_pck_ut_cd", {ComboText:comboXML[1]+"	"+comboXML[1]+"|", ComboCode:comboXML[0]+"|"} );
		ComXml2ComboItem(arrXml[1], comboObjects[5], "cmdt_cd", "rep_cmdt_cd|cmdt_cd");
		sheetObjects[0].SetColProperty(prefix1+"cntr_tpsz_cd", {ComboText:comboXML2[0], ComboCode:comboXML2[1]} );
		ComOpenWait(false);
		break;
	}
}
/**
 * Commas in numeric form addition
 * @param formObj
 * @return
 */
function changeTextToNumberFormat(formObj) {
	formObj.pck_qty.value=ComGetMaskedValue(formObj.pck_qty.value, 			"int");
	formObj.cntr_ttl_wgt.value=ComAddComma2(formObj.cntr_ttl_wgt.value, 	"#,###.0");
	formObj.meas_qty.value=ComAddComma3(formObj.meas_qty.value,		"#,###.000");
	formObj.bb_cgo_meas_qty.value=ComGetMaskedValue(formObj.bb_cgo_meas_qty.value, 	"float");
}
/**
 * Commas in numeric form remove
 * @param formObj
 * @return
 */
function changeNumberToTextFormat(formObj) {
	formObj.pck_qty.value=ComGetUnMaskedValue(formObj.pck_qty.value, 		"int");
	formObj.cntr_ttl_wgt.value=ComGetUnMaskedValue(formObj.cntr_ttl_wgt.value, 	"float");
	formObj.meas_qty.value=ComGetUnMaskedValue(formObj.meas_qty.value, 		"float");
	formObj.meas_qty.value=ComGetUnMaskedValue(formObj.meas_qty.value, 		"float");
	formObj.bb_cgo_meas_qty.value=ComGetUnMaskedValue(formObj.bb_cgo_meas_qty.value,"float");
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0 ;
			InsertItem( "Container Info." , "");
			InsertItem( "Customer Info." , "");
			InsertItem( "Export License Info." , "");
		}
		break;
	}
}
/**
 * Event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj , nItem)
{
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	for(var i = 0; i<objs.length; i++){
		   if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		   }
		  }
	beforetab=nItem;
}
/**
 * Combo Object initialization
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	var formObj=document.form;
	switch(comboObj.options.id) {
	case "cboTrans":
		var i=0;
		with(comboObj) {
			SetColBackColor(0,"#CCFFFD");
			SetMultiSelect(0);
			SetMaxSelect(0);
			// IN BOUND
			if (formObj.io_bnd_cd.value=='I') {
				comboObj.InsertItem( i++, "Import" , 	  "I");
				comboObj.InsertItem( i++, "T/S Import" , "T");
				if (formObj.cstms_decl_tp_cd.value.length > 0)
					comboObj.SetSelectCode(formObj.cstms_decl_tp_cd.value,false);
				else
					comboObj.SetSelectCode("I");
			} else {
				comboObj.InsertItem( i++, "Export" , 	  "E");
				comboObj.InsertItem( i++, "T/S Export" , "R");
				if (formObj.cstms_decl_tp_cd.value.length > 0)
					comboObj.SetSelectCode(formObj.cstms_decl_tp_cd.value,false);
				else
					comboObj.SetSelectCode("E");
			}
		}
		break;
	case "cboCargoType":
		var i=0;
		with(comboObj) {
			SetDropHeight(300);
			SetMultiSelect(0);
			SetMaxSelect(0);
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "60");
			SetColWidth(1, "120");
			SetTitle("Type|Description");
//no support[check again]CLT 			ShowCol=1;
			comboObj.InsertItem( i++, "F|Full Cargo" ,      "F");
			comboObj.InsertItem( i++, "P|Empty Reposition", "P");
			comboObj.InsertItem( i++, "R|Revenue Empty" ,   "R");
			comboObj.InsertItem( i++, "B|Break Bulk" ,      "B");
		}
		break;
	case "cboCargoSpec":
		var i=0;
		with(comboObj) {
			SetDropHeight(260);
			SetMultiSelect(0);
			SetMaxSelect(0);
			comboObj.InsertItem( i++, "" ,     				 "");
			comboObj.InsertItem( i++, "1. 국내개항간 외항선 운송" ,     				 "1");
			comboObj.InsertItem( i++, "2. 수출화물로써 국내개항에 일시 양륙하는 화물" ,  "2");
		}
		break;
	case "cboPackage":
		var i=0;
		with(comboObj) {
			SetDropHeight(300);
			SetMultiSelect(0);
			SetMaxSelect(0);
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "60");
			SetColWidth(1, "200");
			SetTitle("Code|Description");
			var arrayKind=[ 'AE', 'AR', 'PK', 'LT' ];
			var arrayBondedType=[ 'AEROSOL', 'ARTICLES', 'PACKAGE', 'LT???' ];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			}
		}
		break;
	case "cboWarehouse":
		var i=0;
		with(comboObj) {
			SetDropHeight(300);
			SetMultiSelect(0);
			SetMaxSelect(0);
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "60");
			SetColWidth(1, "200");
			SetTitle("Code|Description");
			var arrayKind=[ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R' ];
			var arrayBondedType=[ '입항전 사전 수입신고', '차상반출', '부두 직통관', '부두 보운', '해상 간이 운송',
									'부두 경유 간이 보운', '보세운송', '의왕ICD', 'CY경유 간이 보운', '내장 통관',
									'CFS 경유 간이 보운', 'CFS', '자가 보세장치장', 'T/S', '내품  T/S',
									'자선', '타소 장치', 'Empty 컨테이너' ];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			}
		}
		break;
	case "cboGoods":
		var i=0;
		with(comboObj) {
			SetDropHeight(300);
			SetMultiSelect(0);
			SetMaxSelect(0);
//no support[check again]CLT 			ShowCol=1;
//			ShowCol=1;
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "60");
			SetColWidth(1, "80");
			var arrayKind=[ '00', '99' ];
			var arrayBondedType=[ '630700', '530620' ];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKind[i]);
			}
		}
		break;
	case "cboBizNo":
		var i=0;
		with(comboObj) {
			SetDropHeight(300);
			SetMultiSelect(0);
			SetMaxSelect(0);
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "100");
			SetColWidth(1, "130");
			var arrayKind=[ '401-85-08615', '105-81-59519', '137-85-00522', '416-85-06244', '506-85-03346' ];
			var arrayKindVal=[ '4018508615', '1058159519', '1378500522', '4168506244', '5068503346' ];
			var arrayBondedType=[ '대우자동차', '효성', '동부제강', '현대하이스코', '동국제강㈜ '];
			for(i=0; i < arrayKind.length; i++) {
				comboObj.InsertItem( i, arrayKind[i]+"|"+arrayBondedType[i], arrayKindVal[i]);
			}
		}
		break;
	}
}
/**
 * Trans Type combo event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboTrans_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
{
	document.form.cstms_decl_tp_cd.value=newCode;
}
/**
 * Cargo Type combo event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCargoType_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var formObj=document.form;
	formObj.bkg_cgo_tp_cd.value=newCode;
	if (value=='P') {
		comboObjects[3].SetSelectCode('CN');
		formObj.kr_cstms_bl_tp_cd.value='E';
		formObj.cgo_desc1.value='EMPTY';
	}
}
/**
 * Cargo Spec combo event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCargoSpec_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	document.form.cgo_trsp_cd.value=newCode;
}
/**
 * item combo event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboGoods_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	document.form.cmdt_cd.value=newCode;
}
/**
 * BizNo combo event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboBizNo_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	var biz=newCode;
	if (biz=='') biz=text;
	var bizNo=ComGetUnMaskedValue(biz,  "saupja");
	var bizNo2=ComGetMaskedValue  (biz,  "saupja");
	if (ComIsSaupjaNo(bizNo2)) {
		// If there is no input to add value
		var itemIndex=comboObj.FindItem(bizNo2,0);
		if (itemIndex==-1) {
			comboObj.InsertItem(-1, bizNo2+"|", bizNo);
			comboObj.SetSelectCode(bizNo,false);
		}else {
			comboObj.SetSelectIndex(itemIndex,false);
		}
		document.form.biz_rgst_no.value=comboObj.GetSelectCode();
	}else {
		ComShowCodeMessage('BKG40001');
		comboObj.SetSelectText('',false);
	}
}
/**
 * package combo event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboPackage_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	document.form.pck_tp_cd.value=newCode;
}
/**
 * Wharehouse combo event handling
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboWarehouse_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
	document.form.kr_cstms_wh_tp_cd.value=newCode;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if (formObj.bl_no.value.length < 1) {
			ComShowCodeMessage('BKG00266');
			formObj.bl_no.focus();
			return false;
		}
	}
	return true;
}
/**
 * Sheet Comobo when applied to the XML code and the value of the modified function to be applied to two columns
 * @param xmlStr
 * @param codeCol
 * @param textCol
 * @return
 */
function ComXml2ComboString2(xmlStr, codeCol, textCol) {
	var rtnArr=new Array();
	if (xmlStr == null || xmlStr == "") {
		return;
	}
	if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
		return;
	}
	try {
		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);
		var xmlRoot=xmlDoc.documentElement;
		if (xmlRoot == null) {
			return;
		}
		var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return;
		}
		var col=dataNode.getAttribute("COLORDER");
		var colArr=col.split("|");
		var sep=dataNode.getAttribute("COLSEPARATOR");
		var total=dataNode.getAttribute("TOTAL");
		var dataChildNodes=dataNode.childNodes;
		if (dataChildNodes == null) {
			return;
		}
		var colListIdx=Array();
		for ( var i=0; i < colArr.length; i++) {
			if (colArr[i] == codeCol) {
				colListIdx[0]=i;
			}
			if (colArr[i] == textCol) {
				colListIdx[1]=i;
			}
		}
		var sCode="";
		var sText="";
		for ( var i=0; i < dataChildNodes.length; i++) {
			if (dataChildNodes[i].nodeType != 1) {
				continue;
			}
			var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
			sCode += arrData[colListIdx[0]];
			sText += arrData[colListIdx[0]]+"\t"+arrData[colListIdx[1]];
			if (i != dataChildNodes.length - 1) {
				sCode += "|";
				sText += "|";
			}
		}
		rtnArr.push(sText);
		rtnArr.push(sCode);
	} catch (err) {
		ComFuncErrMsg(err.message);
	}
	return rtnArr;
}
/**
 * form initialization
 * @param formObj
 * @return
 */
function resetForm(formObj) {
	// combo initialization
	comboObjects[1].SetSelectCode('');
	comboObjects[2].SetSelectCode('');
	comboObjects[3].SetSelectCode('');
	comboObjects[4].SetSelectCode('');
	comboObjects[5].SetSelectCode('');
	comboObjects[6].SetSelectCode('',false);
	// Sheet initialization
	sheetObjects[0].RemoveAll();
	sheetObjects[2].RemoveAll();
	tabObjects[0].SetSelectedIndex(0);
	// INPUT 값 initialization
	with(formObj) {
		reset();
		bl_no.className="input1";
		bl_no.readOnly=false;
		bl_no.focus();
	}
}
/**
 * In case of Container NO modifying, TYPE retrieve
 * @param sheetOb
 * @param Row
 * @param Col
 * @param Val
 * @return
 */
function t1sheet1_OnChange(sheetObj, Row, Col, Val)
{
	var formObj=document.form;
	if (Col==3 && Val == "IN BULK" && comboObjects[1].GetSelectCode()=="B") {
		// SKIP
	} else if (Col==3) {
		// data retrieve
		formObj.f_cmd.value=COMMAND02;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0505GS.do?cntr_no="+Val+"&f_cmd="+formObj.f_cmd.value);
		if (ComGetEtcData(sXml, "tpsz_cd")!=null && ComGetEtcData(sXml, "tpsz_cd").length > 1) {
			sheetObj.SetCellValue(Row, "kc_cntr_tpsz_cd",ComGetEtcData(sXml, "tpsz_cd"));
		}else {
			ComShowCodeMessage('BKG01028');
		}
	}
}
/**
 *  function tha can add comma in numeric form
 * @param obj
 * @param sFormat
 * @return
 */
function ComAddComma3(obj,sFormat)
{
	try {
		//The first argument is a string or HTML tags (Object) if the processing
		var sVal=getArgValue(obj);
		switch(sFormat)
		{
		case "#,###" :
			return ComAddComma(sVal);
		case "#,###.0" :
			p=sVal.split(".");
			p[0]=ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".0";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		case "#,###.00" :
			p=sVal.split(".");
			p[0]=ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".00";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		case "#,###.000" :
			p=sVal.split(".");
			p[0]=ComAddComma(p[0]);
			if      (p.length == 1) return p[0]+".000";
			else if (p.length == 2) return p[0]+"."+p[1];
			else return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * Customs Code Manual Setting
 * @return
 */
function getTaxCode(){
	var form=document.form;
	if(form.pod_cd.value == "KRGIN" || form.pod_cd.value == "KRINC" ){
		form.tax_code1.value="020";
		form.tax_code2.value="10";
	}else if (form.pol_cd.value  == "KRGIN" || form.pod_cd.value == "KRINC"){
		form.tax_code1.value="020";
		form.tax_code2.value="10";
	}else if (form.por_cd.value  == "KRGIN" || form.por_cd.value == "KRINC"){
		form.tax_code1.value="020";
		form.tax_code2.value="10";
	}else if (form.del_cd.value  == "KRGIN" || form.del_cd.value == "KRINC"){
		form.tax_code1.value="020";
		form.tax_code2.value="10";
	}
	//[CHM-201219636-01 ]세관 코드 오류 및 AN송부시 VESSEL명 오류에 대한 정정 요청 POD가 평택이면 016/10
	if(form.pod_cd.value == "KRPTK"){
		form.tax_code1.value="016";
		form.tax_code2.value="10";
	}
}
