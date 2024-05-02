/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0031.js
*@FileTitle  : Manifest Amendment Transmission To Korean Customs
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
//Common global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
// OLD value
var oldData="";
// NEW value
var newData="";
var pkgOldData="";
//Event handler processing by button name */
function processButtonClick(){
	/* */
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		/** TAB [Container Info] (S) **/
		case "btn_t1RowAdd":
			sheetObject1.DataInsert(-1);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "pck_qty","0",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "pck_qty","0",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "cntr_wgt","0",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "meas_qty","0",0);
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "pck_tp_cd","",0);
			//  setting Correction with I in case of Correction = D (HEAD part)
			if (comboObjects[2].GetSelectCode()=="D") {
				sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "kr_cstms_corr_id","I");
			} else if (comboObjects[2].GetSelectCode()=="F") {
				// setting Correction with D in case of Correction = F (HEAD part)
				sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "kr_cstms_corr_id","D",0);
			} else {
				sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "kr_cstms_corr_id","A");
			}
			sheetObject1.SetCellValue(sheetObject1.GetSelectRow(), "full_mty_cd","F");
			break;
		case "btn_t1SelectAll":
			sheetObject1.CheckAll(1,2);
			if (sheetObject1.CheckedRows(1) < 1) {
				document.getElementById("btn_t1SelectAll").innerHTML="Select All";
			}else {
				document.getElementById("btn_t1SelectAll").innerHTML="Deselect All";
			}
			break;
		case "btn_t3SelectAll":
			sheetObject2.CheckAll(1,2);
			if (sheetObject2.CheckedRows(1) < 1) {
				document.getElementById("btn_t3SelectAll").innerHTML="Select All";
			}else {
				document.getElementById("btn_t3SelectAll").innerHTML="Deselect All";
			}
			break;
		case "btn_t4SelectAll":
			sheetObject3.CheckAll(1,2);
			if (sheetObject3.CheckedRows(1) < 1) {
				document.getElementById("btn_t4SelectAll").innerHTML="Select All";
			}else {
				document.getElementById("btn_t4SelectAll").innerHTML="Deselect All";
			}
			break;
		case "btn_t1Delete":
			doActionIBSheet(sheetObject1,document.form,IBDELETE);
			break;
		case "btn_t1LoadExcel":
			sheetObject1.RenderSheet(0);
			ComOpenWait(true);
			var columns="4=>cntr_no|5=>pre_cntr_no|6=>cntr_tpsz_cd|7=>cntr_seal_no1|8=>cntr_seal_no2|9=>pck_qty|10=>pck_tp_cd|11=>cntr_wgt|12=>wgt_ut_cd|13=>meas_qty|14=>meas_ut_cd|20=>full_mty_cd|21=>chk_empty";
			var oldCnt=sheetObject1.RowCount();
			var cnt=0;
			sheetObject1.LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:true,ColumnMapping:"columns"});
			sheetObject1.RenderSheet(1);
			for(var i=oldCnt+1; i <= sheetObject1.RowCount(); i++) {
				// changing Correction Code
				// setting Correction with I in case of Correction = D (HEAD part)
				if (comboObjects[2].GetSelectCode()=="D") {
					sheetObject1.SetCellValue(i, "kr_cstms_corr_id","I");
				} else if (comboObjects[2].GetSelectCode()=="F") {
					// setting Correction with D in case of Correction = F (HEAD part)
					sheetObject1.SetCellValue(i, "kr_cstms_corr_id","D",0);
				} else {
					sheetObject1.SetCellValue(i, "kr_cstms_corr_id","A");
				}
				// setting MTY_CD with E in case of 12th column of loaded excel = (P or E)
				if (sheetObject1.GetCellValue(i, "chk_empty")=="P" || sheetObject1.GetCellValue(i, "chk_empty")=="E" ) {
					sheetObject1.SetCellValue(i, "full_mty_cd","E");
				}else {
					sheetObject1.SetCellValue(i, "full_mty_cd","F");
				}
				// deleting when first characters of CNTR_NO >= 97 and <=122
				if (sheetObject1.GetCellValue(i, "cntr_no").length > 0 ) {
					var charCode=sheetObject1.GetCellValue(i, "cntr_no").charCodeAt(0);
					if (97 <= charCode && charCode <= 122 ) sheetObject1.RowDelete(i, false);
				}
			}
			// deleting duplicated container
			for(var i=1; i <= sheetObject1.RowCount(); i++) {
				for(var j=1; j <= sheetObject1.RowCount();j++) {
					if (i==j) continue;
					if (sheetObject1.GetCellValue(i,"cntr_no")==sheetObject1.GetCellValue(j, "cntr_no")) {
						sheetObject1.RowDelete(j, false);
					}
				}
			}
			ComOpenWait(false);
			cnt=sheetObject1.RowCount()- oldCnt;
			ComShowCodeMessage("BKG95021", cnt);
			break;
		case "btn_t3RowAdd":
			sheetObject2.DataInsert(-1);
			sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "divd_pck_ut_cd","",0);
			sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "pck_tp_cd","",0);
			sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "kr_cstms_corr_id","",0);
			sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "wgt_ut_cd","",0);
			sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "prt_lodg_flg","",0);
			sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "kr_xpt_pck_id","",0);
			sheetObject2.SetCellValue(sheetObject2.GetSelectRow(), "kr_xpt_pck_id","",0);
			break;
		case "btn_t3Delete":
			doActionIBSheet(sheetObject2,document.form,IBDELETE);
			break;
		case "btn_t3LoadExcel":
			alert(srcName);
			break;
		case "btn_t4RowAdd":
			sheetObject3.DataInsert(-1);
			break;
		case "btn_t4Delete":
			doActionIBSheet(sheetObject3,document.form,IBDELETE);
			break;
		case "btn_t4LoadExcel":
			alert(srcName);
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
			break;
		case "btn_New":
			resetForm();
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject4, document.form, IBSAVE);
			break;
		case "btn_CorrectionListClear":
			// clearing all Correction List
			// Container TAB
			for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
				sheetObjects[0].SetCellValue(i, "kr_cstms_corr_id","");
				sheetObjects[0].SetCellValue(i, "kr_cstms_corr_id2","");
				sheetObjects[0].SetCellValue(i, "corr_rsn","");
				sheetObjects[0].SetCellValue(i, "pre_dat_ctnt","");
				sheetObjects[0].SetCellValue(i, "crnt_dat_ctnt","");
			}
			// Export License TAB
			for(var i=1; i <= sheetObjects[1].RowCount(); i++) {
				sheetObjects[1].SetCellValue(i, "kr_cstms_corr_id","");
				sheetObjects[1].SetCellValue(i, "corr_rsn","");
			}
			// VVD BL Corr TAB
			sheetObjects[2].RemoveAll();
			break;
		case "btn_TransAmendment":
			doActionIBSheet(sheetObject4, document.form, MODIFY01);
			break;
		case "btn_TransDischAmend":
			doActionIBSheet(sheetObject4, document.form, MODIFY02);
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	// inputting Key
	//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	// retrieving code data
	doActionIBSheet(sheetObjects[0], document.form, COMMAND09);
	// in case of Edit Mode
	if (document.form.mode.value=="EDIT") {
		// B/L and Trans Check
		if (document.form.cstms_decl_tp_cd.value.length < 1) {
			ComShowCodeMessage('BKG95018', "Trans");
			ComClosePopup();
		}
		if (document.form.bl_no.value.length < 1) {
			ComShowCodeMessage('BKG00686');
			ComClosePopup();
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		document.form.bkg_no.className="input2";
		document.form.bkg_no.readOnly=true;
	}else {
		document.form.bkg_no.className="input";
		ComBtnDisable('btn_Retrieve');
	}
	// deactivating MSN in case of OUT BOUND
	if (document.form.io_bnd_cd.value=="O") {
		document.form.msn_no.disabled=true;
		document.form.msn_no.className="input2";
		form.cstms_fwrd_id.style.display='none';
	}else {
		form.cstms_fwrd_id.style.display='inlincboReceivere';
	}
	// cstms_decl_tp_cd
	comboObjects[1].SetSelectCode(document.form.cstms_decl_tp_cd.value,false);
	ComBtnDisable("btn_TransAmendment");
	ComBtnDisable("btn_TransDischAmend");
	document.form.bkg_cgo_tp_cd.remove(0);
	cboReceiver.SetSelectIndex(0);
	 cboCorrection.SetSelectIndex(0);
}
/**
* handling event after loading
* @param sheetObj
* @return
*/
//no support[check again]CLT function t1sheet1_OnLoadFinish(sheetObj) {
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
	case "t1sheet1":
		with (sheetObj) {
			var HeadTitle1="|Sel|Seq.|Container No.|Pre-CNTR No.|TP|Seal No1.|Seal No2.|Package|Package|Weight|Weight|Measure|Measure|Correction|Correction Code2|Correct Reason|Old|New|||";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				   {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
				   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
				   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pre_cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
				   {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_seal_no2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
				   {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_qty",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Combo",     Hidden:0, Width:120,  Align:"Left",    ColMerge:1,   SaveName:"kr_cstms_corr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"kr_cstms_corr_id2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"corr_rsn",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pre_dat_ctnt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"crnt_dat_ctnt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"full_mty_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"chk_empty",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"org_bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			if (document.form.io_bnd_cd.value=="O") {
				SetColHidden("kr_cstms_corr_id2",1);
				SetColHidden("pre_dat_ctnt",1);
				SetColHidden("crnt_dat_ctnt",1);
				SetCellValue(0,"kr_cstms_corr_id","Correction");
				SetColWidth("kr_cstms_corr_id",170);
			} else {
				SetCellValue(0,"kr_cstms_corr_id","Correction Code1");
				SetColWidth("kr_cstms_corr_id",170);
			}
			InitColumns(cols);
			SetEditable(1);
			SetColProperty("cntr_tpsz_cd", {ComboText:"D2|D4|D5|D7|R5", ComboCode:"D2|D4|D5|D7|R5"} );
			SetColProperty("pck_tp_cd", {ComboText:"AE|AR|PK", ComboCode:"AE|AR|PK"} );
			SetColProperty("wgt_ut_cd", {ComboText:"KGS|LBS", ComboCode:"KGS|LBS"} );
			SetColProperty("meas_ut_cd", {ComboText:"CBM|CBF", ComboCode:"CBM|CBF"} );
			SetColProperty("kr_cstms_corr_id", {ComboText:"\t|I\tMB/L추가|A\tCNTR추가|U\tContainerNo이외정정|D\tCNTR삭제|X\tContainerNo및내용정정" ,ComboCode:"|I|A|U|D|X"} );
			SetShowButtonImage(2);
			SetSheetHeight(147);
		}
		break;
	case "t3sheet1":
		with (sheetObj) {
			var HeadTitle1="|Sel|Seq.|Export No.|Pre-Export No.|Package|Package|Weight|Weight|Divide|Ship|동시포장|동시포장 Package|동시포장 Package|Correction Code|Correct Reason";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				   {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
				   {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"xpt_lic_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"pre_xpt_lic_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				   {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",           KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
				   {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
				   {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prt_lodg_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"prt_lodg_seq",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"kr_xpt_pck_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Int",       Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"divd_pck_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0 },
				   {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"divd_pck_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Combo",     Hidden:0, Width:170,  Align:"Left",    ColMerge:1,   SaveName:"kr_cstms_corr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
				   {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"corr_rsn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
			InitColumns(cols);
			SetEditable(1);
			SetSheetHeight(147);
			SetColProperty("pck_tp_cd", {ComboText:"AE|AR|PK", ComboCode:"AE|AR|PK"} );
			SetColProperty("wgt_ut_cd", {ComboText:"KGS|LBS|", ComboCode:"KGS|LBS|"} );
			SetColProperty("prt_lodg_flg", {ComboText:"Y|N|", ComboCode:"Y|N|"} );
			SetColProperty("kr_xpt_pck_id", {ComboText:"A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|", ComboCode:"A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|"} );
			SetColProperty("divd_pck_ut_cd", {ComboText:"|AE|AR|AT|BA|BB|BC", ComboCode:"|AE|AR|AT|BA|BB|BC"} );
			SetColProperty("kr_cstms_corr_id", {ComboText:"\t|I\tMB/L추가|A\tE/L추가|U\tE/LNo이외정정|D\tE/L삭제|X\tE/LNo및내용정정" ,ComboCode:"|I|A|U|D|X"} );
			SetShowButtonImage(2);
		}
		break;
	case "t4sheet1":
		with (sheetObj) {
			var HeadTitle1="|Sel|Seq.|Corr. CD|Correct Reason|Old 1|New 1|Old 2|New 2";
			var headCount=ComCountHeadTitle(HeadTitle1);
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				   {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Sel" },
				   {Type:"Seq",       Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"kr_cstms_corr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			if (document.form.io_bnd_cd.value=="I") {
				cols.push({Type:"Combo",     Hidden:0, Width:360,  Align:"Left",    ColMerge:1,   SaveName:"corr_rsn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 });

			} else {
				cols.push({Type:"Text",      Hidden:0,  Width:360,  Align:"Left",    ColMerge:1,   SaveName:"corr_rsn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 });
			}
			cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pre_ctnt1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_ctnt1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pre_ctnt2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"crnt_ctnt2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			InitColumns(cols);
			SetEditable(1);
			SetShowButtonImage(2);
			SetSheetHeight(147);
			var corr_rsn_data=" |01 적하목록작성자의 단순 기재오류에 기인한 경우|02 적하목록에 등재되지 않은 무적화물(오착화물, 선착화물등)|03 Shipper측 사무착오(화물선적되지않음), 다른곳에 화물적재|04 항행/운송중 사고로 화물이 도난,유실,파손된 경우|05 Shipper측의 사무착오로 B/L(AWB)정보가 이중으로 기재된 경우|06 적하목록상 양륙항이 아닌 다른 항구/공항에 잘못 하역한 경우|07 하역해야 할 화물이 선박(항공기)에 계속하여 남아있는 경우|08 양륙항이 당해 항구(공항)가 아닌 화물을 잘못 하역한 경우|09 하역시 이상없는 화물이 CY/CFS에 장치중 이상 생긴 경우|10 혼재화물 적하목록을 기한내 제출하지 않은 물품 추후에 보완|11 컨테이너 개장결과 과부족발생 경우,세관장이 봉인이상없음 확인|12 B/L(AWB)번호의 상이(B/L분할 또는 단순 기재오류인 경우)|13 B/L(AWB)양수도로 인하여 수하인의 주소,성명이 변경된 경우|14 통과(T/S)화물을 수입화물로 잘못기재한 경우|15 수입화물을 통과(T/S)화물로 잘못 기재한 경우|16 기타사유로 물품의 과부족등 적하목록에 이상이 있는 경우|17 일괄구매물품 B/L분할정정|18 벌크 환적화물 컨테이너 정정";
			var corr_rsn_key="|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18";
			SetColProperty("corr_rsn", {ComboText:corr_rsn_data, ComboCode:corr_rsn_key} );
		}
		break;
	case "t4sheet2":
		with (sheetObj) {
		var HeadTitle1="|Sel";
		var headCount=ComCountHeadTitle(HeadTitle1);
		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		InitHeaders(headers, info);
		var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Sel" } ];
		InitColumns(cols);
		SetEditable(1);
		SetVisible(false);
		}
		break;
	}
}
/**
 * initializing Combo
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	 var cnt=0;
	 switch(comboObj.options.id) {
	 case "cboReceiver":
		 with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "140");
			 SetDropHeight(400);
//no support[check again]CLT 			 ShowCol=0;
			 SetTitle("Code|Description");
			 SetMultiSelect(0);
			 SetMaxSelect(1 );
			 InsertItem(cnt ++, "A|관세청 & 해양수산부", "A");
			 InsertItem(cnt ++, "C|관세청", "C");
			 InsertItem(cnt ++, "P|해양수산부", "P");
			 Code="A";
			 document.form.amdt_rcvr_flg.value=Code;

		 }
		 break;
	 case "cboTrans":
		 with (comboObj) {
				SetColAlign(0, "left");
				SetColWidth(0, "90");
			 SetDropHeight(400);
//no support[check again]CLT 			 ShowCol=0;
			 SetMultiSelect(0);
			 SetMaxSelect(1 );
			 if (document.form.io_bnd_cd.value=="O") {
				 InsertItem(cnt ++, "Export", "E");
				 InsertItem(cnt ++, "T/S Export", "R");
			 }else {
				 InsertItem(cnt ++, "Import", "I");
				 InsertItem(cnt ++, "T/S Import", "T");
			 }
		 }
		 break;
	 case "cboCorrection":
		 with (comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "140");
			 SetDropHeight(400);
//no support[check again]CLT 			 ShowCol=0;
			 SetTitle("Code|Description");
			 SetMultiSelect(0);
			 SetMaxSelect(1 );
			 InsertItem(cnt ++, "A|운항정보 정정", "A");
			 InsertItem(cnt ++, "B|Master B/L 정정", "B");
			 InsertItem(cnt ++, "D|Master B/L 추가", "D");
			 InsertItem(cnt ++, "F|Master B/L 삭제", "F");
			 Code="A";
		 }
		 break;
	 case "cboCargoSpec":
		 with(comboObj) {
			 SetDropHeight(300);
			 SetMultiSelect(0);
			 SetMaxSelect(0);
			 comboObj.InsertItem( cnt ++, " ",     				 " ");
			 comboObj.InsertItem( cnt ++, "1. 국내개항간 외항선 운송" ,     				 "1");
			 comboObj.InsertItem( cnt ++, "2. 수출화물로써 국내개항에 일시 양륙하는 화물" ,  "2");
		 }
		 break;
	 case "cboWhTpCd":
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
	 case "cboBizNo":
		 with(comboObj) {
			 SetDropHeight(300);
			 SetMultiSelect(0);
			 SetMaxSelect(0);
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "100");
			SetColWidth(1, "130");
//			 alert("p_cbo_bizno_temp_Code : " + p_cbo_bizno_temp_Code + "\np_cbo_bizno_temp_Text : "+ p_cbo_bizno_temp_Text);
//			 var comboCode=p_cbo_bizno_temp_Code.split("|");
//			 var comboText=p_cbo_bizno_temp_Text.split("|");
//			 var formatBizNo="";
//			 for(i=0; i < comboCode.length; i++) {
//				 formatBizNo=comboCode[i].substr(0, 3) + "-" + comboCode[i].substr(3, 2) + "-" + comboCode[i].substr(5);
//				 comboObj.InsertItem( i, formatBizNo+"|"+comboText[i], comboCode[i]);
//			 }
		 }
		 break;
	 case "cboPackage":
		 with(comboObj) {
			 SetDropHeight(300);
			 SetMultiSelect(0);
			 SetMaxSelect(1);
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "60");
			SetColWidth(1, "200");
			 SetTitle("Code|Description");
		 }
		 break;
	 case "cboMeaUnit":
		 with(comboObj) {
			SetColAlign(0, "center");
			SetColAlign(1, "left");
			SetColWidth(0, "50");
			SetColWidth(1, "140");
			 SetDropHeight(400);
//no support[check again]CLT 			 ShowCol=0;
			 SetTitle("Code|Description");
			 SetMultiSelect(0);
			 SetMaxSelect(1 );
			 InsertItem(cnt ++, "M|Measurement Ton", "M");
			 InsertItem(cnt ++, "B|Barrel", "B");
			 Code="M";
		 }
		 break;
	 case "cboGoods":
		 break;
	 }
	 cboReceiver.SetSelectIndex(0);
	 cboCorrection.SetSelectIndex(0);
}
/**
 * handling in case of changing Receiver
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboReceiver_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var form=document.form;
	form.amdt_rcvr_flg.newCode=newCode;
}
/**
 * HS CODE focus in
 * @param comboObj
 * @return
 */
function cboGoods_OnFocus(comboObj) {
	oldData=comboObj.GetSelectCode();
}
/**
 * handling in case of changing HS CODE
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboGoods_OnChange(comboObj, value, text) {
	var form=document.form;
	form.cmdt_cd.value=value;
	newData=value;
}
/**
 * HS CODE focus out
 * @param comboObj
 * @return
 */
function cboGoods_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form=document.form;
		// changing Receiver
		comboObjects[0].SetSelectCode("A");
		// adding history
		// IN BOUND
		if (form.io_bnd_cd.value=="I") {
			addCorrList("BF", "", oldData, newData);
		}else {
			addCorrList("BF", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData="";
		newData="";
	}
}
/**
 * Trans focus in
 * @param comboObj
 * @return
 */
function cboTrans_OnFocus(comboObj) {
	oldData=comboObj.GetSelectCode();
}
/**
 * in case of changing Trans
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboTrans_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var form=document.form;
	form.cstms_decl_tp_cd.newCode=newCode;
	newData=value;
}
/**
 * Trans focus out
 * @param comboObj
 * @return
 */
function cboTrans_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form=document.form;
		// changing Receiver
		comboObjects[0].SetSelectCode("A");
		// adding history
		// IN BOUND
		if (form.io_bnd_cd.value=="I") {
			addCorrList("BM", "", oldData, newData);
		}else {
			addCorrList("BM", "화주 요청에 의한 정정", oldData, newData);
		}
		newData="";
		oldData="";
	}
}
/**
 * in case of changing Correction
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCorrection_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var form=document.form;
	form.kr_cstms_corr_id.newCode=newCode;
	if ( newCode=="D" ) {
		form.corr_rsn.newCode="오류로 인한 Master B/L 추가";
	}else if ( newCode=="F" ) {
		form.corr_rsn.newCode="선적취소로 인한 Master B/L 삭제";
	}else {
		form.corr_rsn.newCode="";
	}
	// initializing Correction of Container Info TAB and Export License TAB in case of changing COMBO value
	switch(newCode) {
	case "A":
		for(var i=1; i <= sheetObjects[0].RowCount(); i++ ) {
			sheetObjects[0].SetCellValue(i, "kr_cstms_corr_id","");
		}
		for(var i=1; i <= sheetObjects[1].RowCount(); i++ ) {
			sheetObjects[1].SetCellValue(i, "kr_cstms_corr_id","");
		}
		break;
	case "B":
		for(var i=1; i <= sheetObjects[0].RowCount(); i++ ) {
			sheetObjects[0].SetCellValue(i, "kr_cstms_corr_id","");
		}
		for(var i=1; i <= sheetObjects[1].RowCount(); i++ ) {
			sheetObjects[1].SetCellValue(i, "kr_cstms_corr_id","");
		}
		break;
	case "D":
		for(var i=1; i <= sheetObjects[0].RowCount(); i++ ) {
			sheetObjects[0].SetCellValue(i, "kr_cstms_corr_id","I");
		}
		for(var i=1; i <= sheetObjects[1].RowCount(); i++ ) {
			sheetObjects[1].SetCellValue(i, "kr_cstms_corr_id","I");
		}
		break;
	case "F":
		for(var i=1; i <= sheetObjects[0].RowCount(); i++ ) {
			sheetObjects[0].SetCellValue(i, "kr_cstms_corr_id","D");
		}
		for(var i=1; i <= sheetObjects[1].RowCount(); i++ ) {
			sheetObjects[1].SetCellValue(i, "kr_cstms_corr_id","D");
		}
		break;
	}
}
// Cargo Spec focus in
function cboCargoSpec_OnFocus(comboObj) {
	if (comboObj.GetSelectCode()=="1") {
		oldData="1";
	}else if (comboObj.GetSelectCode()=="2") {
		oldData="2";
	}else {
		oldData="";
	}
}
/**
 * in case of changing Cargo Spec
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboCargoSpec_OnChange(comboObj,value,text) {
	var form=document.form;
	form.cgo_spec.value=value;
	if (value=="1") {
		newData="1";
	}else if (value=="2") {
		newData="2";
	}else {
		newData="";
		form.cgo_spec.value="";
	}
}
// Cargo Spec focus out
function cboCargoSpec_OnBlur(comboObj) {
	var form=document.form;
	if (oldData != newData) {
		if (form.io_bnd_cd.value=="I") {
			addCorrList("EL", "", oldData, newData);
		} else {
			addCorrList("EL", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData="";
		newData="";
	}
}
/**
 * in case of changing Warehouse Type
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboWhTpCd_OnChange(comboObj,value,text) {
	var form=document.form;
	form.kr_cstms_wh_tp_cd.value=value;
}
/**
 * BIZ NO focus in
 * @param comboObj
 * @return
 */
function cboBizNo_OnFocus(comboObj) {
	oldData=comboObj.GetSelectCode();
}
/**
 * in case of changing BIZ NO
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboBizNo_OnChange(comboObj,value,text) {
	var form=document.form;
	var bizNo=value;
	if (bizNo.length < 1 ) bizNo=text;
	var index=comboObj.FindItem(ComGetMaskedValue(bizNo, "saupja"),0);
	if (index < 0 ) {
		comboObj.insertItem(-1, ComGetMaskedValue(bizNo, "saupja")+"|", bizNo);
	}
	form.biz_no.value=bizNo;
	newData=bizNo;
}
/**
 * BIZ NO focus out
 * @param comboObj
 * @return
 */
function cboBizNo_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form=document.form;
		// changing Receiver
		comboObjects[0].SetSelectCode("P");
		// adding history
		// IN BOUND
		if (form.io_bnd_cd.value=="I") {
			addCorrList("ZA6", "", oldData, newData);
		}else {
			addCorrList("ZA6", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData="";
		newData="";
	}
}
/**
 * package code focus in
 * @param comboObj
 * @return
 */
function cboPackage_OnFocus(comboObj) {
	oldData=comboObj.GetSelectCode();
}
/**
 * package code change event
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboPackage_OnChange(comboObj,value,text) {
	var form=document.form;
	form.pck_tp_cd.value=value;
	newData=value;
}
function sleep(milliseconds) {
	var start=new Date().getTime();
	for(var i=0; i < 1e7; i++) {
		if ( (new Date().getTime() - start )  > milliseconds ) {
			break;
		}
	}
}
/**
 * package code focus out
 * @param comboObj
 * @return
 */
function cboPackage_OnBlur(comboObj) {
	if (newData=="") return;
	if (oldData != newData) {
		var form=document.form;
		// changing Receiver
		comboObjects[0].SetSelectCode("A");
		// adding history
		// IN BOUND
		if (form.io_bnd_cd.value=="I") {
			addCorrList("BG", "", oldData, newData);
		}else {
			addCorrList("BG", "화주 요청에 의한 정정", oldData, newData);
		}
		oldData="";
		newData="";
	}
}
/**
 * Mea Unit change event
 * @param comboObj
 * @param value
 * @param text
 * @return
 */
function cboMeaUnit_OnChange(comboObj,value,text) {
	var form=document.form;
	form.kr_meas_ut_cd.value=value;
}
// initializing COMBO, Grid and Form
function resetForm()
{
	var form=document.form;
	form.reset();
	// initializing COMBO
	comboObjects[0].SetSelectCode("A");
	comboObjects[1].SetSelectCode(document.form.cstms_decl_tp_cd.value);
	comboObjects[2].SetSelectCode("A");
	comboObjects[3].SetSelectCode("");
	comboObjects[4].SetSelectCode("");
	comboObjects[5].SetSelectCode("");
	comboObjects[6].SetSelectCode("");
	comboObjects[7].SetSelectCode("");
	comboObjects[8].SetSelectCode("M");
	// initializing Grid
	sheetObjects[0].RemoveAll();
	sheetObjects[1].RemoveAll();
	sheetObjects[2].RemoveAll();
}
// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
	case IBSEARCH:      //retrieve
		if(validateForm(sheetObj,formObj,sAction)) {
			formObj.f_cmd.value=SEARCH;
			// saving portCd
			var portCd=formObj.port_cd.value;
			var cstmsDeclTpCd=formObj.cstms_decl_tp_cd.value;
			sheetObj.RenderSheet(0);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0031GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			ComEtcDataToForm(formObj, sheetObj);
			// recovering PortCd
			formObj.port_cd.value=portCd;
			formObj.cstms_decl_tp_cd.value=cstmsDeclTpCd;
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
			// Multi Combo
			// RECEIVER
			if (formObj.amdt_rcvr_flg.value.length > 0) {
				comboObjects[0].SetSelectCode(formObj.amdt_rcvr_flg.value,false);
			}else {
				formObj.amdt_rcvr_flg.value=comboObjects[0].GetSelectCode();
			}
			// Correction
			comboObjects[2].SetSelectCode(formObj.kr_cstms_corr_id.value,false);
			if (comboObjects[2].GetSelectCode()== "D" || comboObjects[2].GetSelectCode()== "F") {
				comboObjects[0].SetSelectCode("A");
			}
			// Cargo Spec
			comboObjects[3].SetSelectCode(formObj.cgo_spec.value,false);
			if (formObj.cgo_spec_clear.value=="Y") comboObjects[3].SetSelectCode("");
			// HS CODE
			comboObjects[4].SetSelectCode(formObj.cmdt_cd.value,false);
			// PACKAGE
			comboObjects[5].SetSelectCode(formObj.pck_tp_cd.value,false);
			// BIZ NO
			var bizNo=ComGetMaskedValue(formObj.biz_rgst_no.value,  "saupja");
			var itemIndex=comboObjects[6].FindItem(bizNo,0);
			if (itemIndex==-1) {
				comboObjects[6].InsertItem(-1, bizNo+"| ", formObj.biz_rgst_no.value);
				comboObjects[6].SetSelectCode(formObj.biz_rgst_no.value,false);
			}else {
				comboObjects[6].SetSelectCode(itemIndex,false);
			}
			// Warehouse
			comboObjects[7].SetSelectCode(formObj.kr_cstms_wh_tp_cd.value,false);
			// MEA UNIT
			comboObjects[8].SetSelectCode(formObj.kr_meas_ut_cd.value,false);
			// handling length of FORM value
			formObj.cstms_ofc_cty_cd.value=ComLpad(formObj.cstms_ofc_cty_cd.value, 3, "0");
			formObj.kr_cstms_dept_cd.value=ComLpad(formObj.kr_cstms_dept_cd.value,2,"0");
			formObj.kr_port_auth_cd.value=ComLpad(formObj.kr_port_auth_cd.value,3,"0");
			formObj.call_knt.value=ComLpad(formObj.call_knt.value,3,"0");
			sheetObj.RenderSheet(1);
			// adding comma
			formObj.cntr_ttl_wgt.value=ComAddComma2(formObj.cntr_ttl_wgt.value, 	"#,###.0");
			formObj.meas_qty.value=ComAddComma3(formObj.meas_qty.value,		"#,###.000");
			ComOpenWait(false);
		}
		break;
	case MODIFY01:      // TRANSMIT
		if(ComShowCodeConfirm('BKG95003', 'Transmit')){   // Do you want to ...?
			ComOpenWait(true);
			// SAVE
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetRowStatus(1,"U");
			formObj.f_cmd.value=MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_TransAmendment");
			ComBtnDisable("btn_TransDischAmend");
			tabObjects[0].SetSelectedIndex(0);
			var params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");
			sheetObjects[3].GetSearchData("ESM_BKG_0031GS.do", params);
			// Receiver back up
			var rcv=comboObjects[0].GetSelectCode();
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			// recovering Receiver
			comboObjects[0].SetSelectCode(rcv);
			// Transmit
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetRowStatus(1,"U");
			formObj.f_cmd.value=MODIFY01;
			params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");
			params=params + "&trans_dmr=N";
			sheetObjects[3].DoSave("ESM_BKG_0031GS.do", params, -1, false);
			changeTextToNumberFormat(formObj);
			ComBtnEnable("btn_TransAmendment");
			// deactivating in case of InBound
			if (formObj.io_bnd_cd.value=="I") {
				ComBtnEnable("btn_TransDischAmend");
			} else {
				ComBtnDisable("btn_TransDischAmend");
			}
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			ComBtnEnable("btn_Save");
			// recovering Receiver
			comboObjects[0].SetSelectCode(rcv);
			ComOpenWait(false);
		}
		break;
	case MODIFY02:      // TRANSMIT DISCH
		if(ComShowCodeConfirm('BKG95003', 'Transmit')){   // Do you want to ...?
			ComOpenWait(true);
			// SAVE
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetRowStatus(1,"U");
			formObj.f_cmd.value=MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_TransAmendment");
			ComBtnDisable("btn_TransDischAmend");
			tabObjects[0].SetSelectedIndex(0);
			var params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");
			sheetObjects[3].GetSearchData("ESM_BKG_0031GS.do", params);
			// Receiver back up
			var rcv=comboObjects[0].GetSelectCode();
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			// recovering Receiver
			comboObjects[0].SetSelectCode(rcv);
			// Transmit
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetRowStatus(1,"U");
			formObj.f_cmd.value=MODIFY01;
			params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");
			params=params + "&trans_dmr=Y";
			sheetObjects[3].DoSave("ESM_BKG_0031GS.do", params, -1, false);
			changeTextToNumberFormat(formObj);
			ComBtnEnable("btn_TransAmendment");
			ComBtnEnable("btn_TransDischAmend");
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
			ComBtnEnable("btn_Save");
			// recovering Receiver
			comboObjects[0].SetSelectCode(rcv);
			ComOpenWait(false);
		}
		break;
	case COMMAND09: 	// 코드 데이터 조회
		// 패키지 정보 조회 후 콤보들에 적용
		formObj.f_cmd.value=COMMAND09;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0505GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		ComXml2ComboItem(arrXml[1], comboObjects[4], "cmdt_cd", "rep_cmdt_cd|cmdt_cd");
		ComXml2ComboItem(arrXml[0], comboObjects[5],  "pck_cd",			"pck_cd|pck_nm");
		var comboXML=ComXml2ComboString2(arrXml[0], "pck_cd", 		"pck_nm");
		var comboXML2=ComXml2ComboString (arrXml[2], "cntr_tpsz_cd", 	"cntr_tpsz_cd");
		sheetObjects[0].SetColProperty("pck_tp_cd", {ComboText:comboXML[0]+"|", ComboCode:comboXML[1]+"|"} );
		sheetObjects[0].SetColProperty("cntr_tpsz_cd", {ComboText:comboXML2[0]+"|", ComboCode:comboXML2[1]+"|"} );
		sheetObjects[1].SetColProperty("pck_tp_cd", {ComboText:comboXML[0]+"|", ComboCode:comboXML[1]+"|"} );
		break;
	case IBDELETE:		// ROW DELETE
		ComRowHideDelete(sheetObj,"Sel");
		break;
	case IBSAVE:
		if(ComShowCodeConfirm('BKG95003', 'save')){   // Do you want to ...?
			ComOpenWait(true);
			sheetObjects[3].RemoveAll();
			sheetObjects[3].DataInsert(-1);
			sheetObjects[3].SetRowStatus(1,"U");
			formObj.f_cmd.value=MULTI;
			changeNumberToTextFormat(formObj);
			ComBtnDisable("btn_Save");
			var params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(ComGetSaveString(sheetObjects[0], true, true), "sheet1_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[1], true, true), "sheet2_")
							+ "&" + ComSetPrifix(ComGetSaveString(sheetObjects[2], true, true), "sheet3_");


			sheetObjects[3].DoSave("ESM_BKG_0031GS.do", {Param:params,Quest:false});

			/*if (sheetObjects[3].DoSave("ESM_BKG_0031GS.do", {Param:params, Sync:1})) {
				// Receiver back up
				var rcv=comboObjects[0].GetSelectCode();
				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
				ComBtnEnable("btn_TransAmendment");
				// deactivating button in case of InBound
				if (formObj.io_bnd_cd.value=="I") {
					ComBtnEnable("btn_TransDischAmend");
				} else {
					ComBtnDisable("btn_TransDischAmend");
				}
				// recovering Receiver
				comboObjects[0].SetSelectCode(rcv);
			}*/
			changeTextToNumberFormat(formObj);
			ComBtnEnable("btn_Save");
			ComOpenWait(false);
		}
		break;
	}
}



function t4sheet2_OnSaveEnd(sheetObj, Code, Msg) {
	// Receiver back up
	var rcv=comboObjects[0].GetSelectCode();
	var formObj=document.form;
	doActionIBSheet(sheetObj, formObj, IBSEARCH);
	ComBtnEnable("btn_TransAmendment");
	// deactivating button in case of InBound
	if (formObj.io_bnd_cd.value=="I") {
		ComBtnEnable("btn_TransDischAmend");
	} else {
		ComBtnDisable("btn_TransDischAmend");
	}
	// recovering Receiver
	comboObjects[0].SetSelectCode(rcv);

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
			InsertItem( "Export No." , "");
			InsertItem( "VVD-B/L Cor List" , "");
			tabObj.SetSelectedIndex(0);
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
//	var objs=document.all.item("tabLayer");
//	objs[nItem].style.display="Inline";
//	objs[beforetab].style.display="none";
//	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
//	beforetab=nItem;

	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="inline";
	for(var i = 0; i<objs.length; i++){
		if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		}
	}
	beforetab=nItem;
}
//registering IBCombo Object as list
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
	}
	return true;
}
 /**
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
		 var xmlDoc = ComGetXmlDoc(xmlStr);
		 if (xmlDoc == null) return;
		 var xmlRoot = xmlDoc.documentElement;
		 if (xmlRoot==null) return;
//		 var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
//		 xmlDoc.loadXML(xmlStr);
//		 var xmlRoot=xmlDoc.documentElement;
//		 if (xmlRoot == null) {
//			 return;
//		 }
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
 * adding ','
 * @param formObj
 * @return
 */
function changeTextToNumberFormat(formObj) {
	formObj.pck_qty.value=ComGetMaskedValue(formObj.pck_qty.value, 			"int");
	formObj.cntr_ttl_wgt.value=ComGetMaskedValue(formObj.cntr_ttl_wgt.value, 	"float");
	formObj.meas_qty.value=ComGetMaskedValue(formObj.meas_qty.value,			"float");
	formObj.bb_cgo_meas_qty.value=ComGetMaskedValue(formObj.bb_cgo_meas_qty.value, 	"float");
}
/**
 * deleting ','
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
// before editing Sheet1 Container
function t1sheet1_OnBeforeEdit(sheetObj, Row, Col) {
	// 수정시에만 적용
	if (sheetObj.GetCellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.SetCellValue(Row, "pre_cntr_no") == "") sheetObj.GetCellValue(Row, "pre_cntr_no",sheetObj.GetCellValue(Row, Col));
		}else{
			oldData=sheetObj.GetCellValue(Row, Col);
		}
	}
}
// after editing Sheet1 Container
function t1sheet1_OnAfterEdit(sheetObj, Row, Col) {
	if (sheetObj.GetCellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.GetCellValue(Row, "cntr_no")==sheetObj.GetCellValue(Row, "pre_cntr_no"))
				sheetObj.SetCellValue(Row, "pre_cntr_no","");
		}
	}
}
/**
 * Tab1 Sheet1 change event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t1sheet1_OnChange(sheetObj, Row, Col) {
	// Container change
	if (Col==3) {
		var formObj=document.form;
		if (Col==3) {
			formObj.f_cmd.value=COMMAND02;
			var sXml=sheetObj.GetSearchData("ESM_BKG_0031GS.do?cntr_no="+sheetObj.GetCellValue(Row,Col)+"&f_cmd="+formObj.f_cmd.value);
			if (ComGetEtcData(sXml, "tpsz_cd")!=null && ComGetEtcData(sXml, "tpsz_cd").length > 1) {
				sheetObj.SetCellValue(Row, "cntr_tpsz_cd",ComGetEtcData(sXml, "tpsz_cd"));
			}
		}
	}
	if (sheetObj.GetCellValue(Row, "ibflag")!="I") {
		// Container No change
		if (Col==3) {
			if (sheetObj.GetCellValue(Row, "cntr_no")==sheetObj.GetCellValue(Row, "pre_cntr_no"))
				sheetObj.SetCellValue(Row, "pre_cntr_no","");
			if (sheetObj.GetCellValue(Row, "pre_cntr_no") !="") {
				sheetObj.SetCellValue(Row, "kr_cstms_corr_id","X");
				sheetObj.SetCellValue(Row, "kr_cstms_corr_id2","EH");
				sheetObj.SetCellValue(Row, "pre_dat_ctnt",sheetObj.GetCellValue(Row, "pre_cntr_no"));
				sheetObj.SetCellValue(Row, "crnt_dat_ctnt",sheetObj.GetCellValue(Row, "cntr_no"));
			}
		}else if (Col==5) {
			// TP change
			sheetObj.SetCellValue(Row, "pre_dat_ctnt",oldData);
			sheetObj.SetCellValue(Row, "crnt_dat_ctnt",sheetObj.GetCellValue(Row, "cntr_tpsz_cd"));
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id","U");
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id2","EA");
			oldData="";
		}else if (Col==6) {
			// Seal No1 change
			sheetObj.SetCellValue(Row, "pre_dat_ctnt",oldData);
			sheetObj.SetCellValue(Row, "crnt_dat_ctnt",sheetObj.GetCellValue(Row, "cntr_seal_no1"));
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id","U");
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id2","EB");
			oldData="";
		}else if (Col==7) {
			// Seal No2 change
			sheetObj.SetCellValue(Row, "pre_dat_ctnt",oldData);
			sheetObj.SetCellValue(Row, "crnt_dat_ctnt",sheetObj.GetCellValue(Row, "cntr_seal_no2"));
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id","U");
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id2","EB");
			oldData="";
		}else if (Col==8) {
			// Package change
			sheetObj.SetCellValue(Row, "pre_dat_ctnt",oldData);
			sheetObj.SetCellValue(Row, "crnt_dat_ctnt",sheetObj.GetCellValue(Row, "pck_qty"));
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id","U");
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id2","EJ");
			oldData="";
		}else if (Col==9) {
			// Package Code change
			sheetObj.SetCellValue(Row, "pre_dat_ctnt",oldData);
			sheetObj.SetCellValue(Row, "crnt_dat_ctnt",sheetObj.GetCellValue(Row, "pck_tp_cd"));
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id","U");
			sheetObj.SetCellValue(Row, "kr_cstms_corr_id2","EK");
			oldData="";
		}
	}
	// in case of modifying Correction
	if (Col==14) {
		switch(sheetObj.GetCellValue(Row, Col)) {
		case "A":
			sheetObj.SetCellValue(Row, "corr_rsn","CNTR 추가");
			break;
		case "U":
			sheetObj.SetCellValue(Row, "corr_rsn","Container No 이외의 정정");
			break;
		case "D":
			sheetObj.SetCellValue(Row, "corr_rsn","CNTR 삭제");
			break;
		case "X":
			sheetObj.SetCellValue(Row, "corr_rsn","Container No 및 내용정정");
			break;
		default:
			sheetObj.SetCellValue(Row, "corr_rsn","");
		break
		}
	}
}
/**
 * before editing Tab3 Export No Sheet
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t3sheet1_OnBeforeEdit(sheetObj, Row, Col) {
	// in case of updating
	if (sheetObj.GetCellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.SetCellValue(Row, "pre_xpt_lic_no") == "") sheetObj.GetCellValue(Row, "pre_xpt_lic_no",sheetObj.GetCellValue(Row, Col));
		}else{
			oldData=sheetObj.GetCellValue(Row, Col);
		}
	}
}
/**
 * after editing Tab3 Export No Sheet
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t3sheet1_OnAfterEdit(sheetObj, Row, Col) {
	if (sheetObj.GetCellValue(Row, "ibflag")!="I") {
		if (Col==3) {
			if (sheetObj.GetCellValue(Row, "xpt_lic_no")==sheetObj.GetCellValue(Row, "pre_xpt_lic_no"))
				sheetObj.SetCellValue(Row, "pre_xpt_lic_no","");
		}
	}
}
/**
 * Tab3 Export No Sheet change event
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function t3sheet1_OnChange(sheetObj, Row, Col) {
	if (sheetObj.GetCellValue(Row, "ibflag")!="I") {
		// Container No change
		if (Col==3) {
			if (sheetObj.SetCellValue(Row, "xpt_lic_no")==sheetObj.GetCellValue(Row, "pre_xpt_lic_no")) sheetObj.GetCellValue(Row, "pre_xpt_lic_no","");
			if (sheetObj.SetCellValue(Row, "pre_xpt_lic_no") !="") sheetObj.GetCellValue(Row, "kr_cstms_corr_id","X");
		}
	}
}
// POD change
function pod_onChange()
{
	var form=document.form;
	comboObjects[0].SetSelectCode("A");
	// adding history
	if (form.io_bnd_cd.value=="I") {
		addCorrList("BA", "", oldData, form.pod_cd.value);
	}else {
		addCorrList("BA", "화주 요청에 의한 정정", oldData, form.pod_cd.value);
	}
	oldData="";
	form.vsl_call_sgn_cd.focus();
}
// POL change
function pol_onChange()
{
	var form=document.form;
	comboObjects[0].SetSelectCode("A");
	// adding history
	if (form.io_bnd_cd.value=="I") {
		addCorrList("AE", "", oldData, form.pol_cd.value);
	}else {
		addCorrList("AE", "화주 요청에 의한 정정", oldData, form.pol_cd.value);
	}
	oldData="";
	form.pod_cd.focus();
}
// Bond Area Code change
function bdAreaCd_onChange()
{
	// Receiver : A
	comboObjects[0].SetSelectCode("A");
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BT", "", oldData, document.form.bd_area_cd.value);
	}else {
		addCorrList("BN", "화주 요청에 의한 정정", oldData, document.form.bd_area_cd.value);
	}
	oldData="";
	form.kr_wh_cd.focus();
}
// Weight change
function cntrTtlWgt_onChange()
{
	// Receiver : A
	comboObjects[0].SetSelectCode("A");
	// 콤마 추가
	document.form.cntr_ttl_wgt.value=ComAddComma3(document.form.cntr_ttl_wgt.value, "#,###.0");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("CB", "", oldData, document.form.cntr_ttl_wgt.value);
	}else {
		addCorrList("BH", "화주 요청에 의한 정정", oldData, document.form.cntr_ttl_wgt.value);
	}
	oldData="";
	form.wgt_ut_cd.focus();
}
// MEAS change
function measQty_onChange()
{
	// Receiver : A
	comboObjects[0].SetSelectCode("A");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("CC", "", oldData, document.form.meas_qty.value);
	}else {
		addCorrList("BJ", "화주 요청에 의한 정정", oldData, document.form.meas_qty.value);
	}
	oldData="";
	form.meas_ut_cd.focus();
}
// Package change
function pckQty_onChange()
{
	// Receiver : A
	comboObjects[0].SetSelectCode("A");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("CA", "", pkgOldData, document.form.pck_qty.value);
	}else {
		addCorrList("BK", "화주 요청에 의한 정정", pkgOldData, document.form.pck_qty.value);
	}
	pkgOldData="";
}
function setPckOldData(val) {
	pkgOldData=val;
}
// VSL NAME change
function vslNm_onChange()
{
	// Receiver : A
	comboObjects[0].SetSelectCode("A");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AA", "", oldData, document.form.vsl_nm.value);
	}else {
		addCorrList("AA", "화주 요청에 의한 정정", oldData, document.form.vsl_nm.value);
	}
	oldData="";
	form.vsl_cnt_cd.focus();
}
// VVD change
function vvd_onChange()
{
	// Receiver : A
	comboObjects[0].SetSelectCode("A");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AB", "", oldData, document.form.vvd.value);
	}else {
		addCorrList("AB", "화주 요청에 의한 정정", oldData, document.form.vvd.value);
	}
	oldData="";
	form.pol_cd.focus();
}
// Call Sign change
function vslCallSgnCd_onChange()
{
	// Receiver : C
	comboObjects[0].SetSelectCode("C");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AC", "", oldData, document.form.vsl_call_sgn_cd.value);
	}else {
		addCorrList("AC", "화주 요청에 의한 정정", oldData, document.form.vsl_call_sgn_cd.value);
	}
	oldData="";
	form.eta_dt.focus();
}
// Flag change
function vslCntCd_onChange()
{
	// Receiver : A
	comboObjects[0].SetSelectCode("A");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("AD", "", oldData, document.form.vsl_cnt_cd.value);
	}else {
		addCorrList("AD", "화주 요청에 의한 정정", oldData, document.form.vsl_cnt_cd.value);
	}
	oldData="";
	form.imdg_clss_cd.focus();
}
// QUAY change
function ioTmlLocCd_onChange()
{
	// Receiver : P
	comboObjects[0].SetSelectCode("P");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA2", "", oldData, document.form.io_tml_loc_cd.value);
	}else {
		addCorrList("ZA2", "화주 요청에 의한 정정", oldData, document.form.io_tml_loc_cd.value);
	}
	oldData="";
	form.dchg_mzd_cd.focus();
}
// MEAS UT change
function measUtCd_onChange()
{
	// Receiver : P
	comboObjects[0].SetSelectCode("P");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA4", "", oldData, document.form.meas_ut_cd.value);
	}else {
		addCorrList("ZA4", "화주 요청에 의한 정정", oldData, document.form.meas_ut_cd.value);
	}
	oldData="";
	form.dchg_mzd_cd.focus();
}
// Bulk Weight change
function bbCgoWgt_onChange()
{
	// Receiver : P
	comboObjects[0].SetSelectCode("P");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA7", "", oldData, document.form.bb_cgo_wgt.value);
	}else {
		addCorrList("ZA7", "화주 요청에 의한 정정", oldData, document.form.bb_cgo_wgt.value);
	}
	oldData="";
	form.bb_cgo_meas_qty.focus();
}
// Bulk Mea change
function bbCgoMeasQty_onChange()
{
	// Receiver : P
	comboObjects[0].SetSelectCode("P");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA8", "", oldData, document.form.bb_cgo_meas_qty.value);
	}else {
		addCorrList("ZA8", "화주 요청에 의한 정정", oldData, document.form.bb_cgo_meas_qty.value);
	}
	oldData="";
	form.io_tml_loc_cd.focus();
}
// BL Type change
function krCstmsBlTpCd_onChange()
{
	// Receiver : P
	comboObjects[0].SetSelectCode("P");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BO", "", oldData, document.form.kr_cstms_bl_tp_cd.value);
	}else {
		addCorrList("BO", "화주 요청에 의한 정정", oldData, document.form.kr_cstms_bl_tp_cd.value);
	}
	oldData="";
	form.vvd.focus();
}
// Forward focus in
function cstmsFwrdId_OnFocus()
{
	var form=document.form;
	oldData=form.cstms_fwrd_id.value;
}
// Forward change
function cstmsFwrdId_OnChange()
{
	var form=document.form;
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BO", "", oldData, form.cstms_fwrd_id.value);
	}else {
		addCorrList("BO", "화주 요청에 의한 정정", oldData, form.cstms_fwrd_id.value);
	}
	oldData="";
	newData="";
}
// in case of changing the way of unloading
function dchgMzdCd_onChange()
{
	// Receiver : P
	comboObjects[0].SetSelectCode("P");
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("ZA1", "", oldData, document.form.dchg_mzd_cd.value);
	}else {
		addCorrList("ZA1", "화주 요청에 의한 정정", oldData, document.form.dchg_mzd_cd.value);
	}
	oldData="";
	form.cgo_desc1.focus();
}
// IMDG1 change event
function imdgClssCd_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		comboObjects[0].SetSelectCode("A");
		addCorrList("BP", "", oldData, document.form.imdg_clss_cd.value);
	}else {
		comboObjects[0].SetSelectCode("P");
		addCorrList("BP", "화주 요청에 의한 정정", oldData, document.form.imdg_clss_cd.value);
	}
	oldData="";
	form.n2nd_imdg_clss_cd.focus();
}
// IMDG2 change event
function n2ndImdgClssCd_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		comboObjects[0].SetSelectCode("C");
		addCorrList("BQ", "", oldData, document.form.n2nd_imdg_clss_cd.value);
	}else {
		comboObjects[0].SetSelectCode("P");
		addCorrList("BQ", "화주 요청에 의한 정정", oldData, document.form.n2nd_imdg_clss_cd.value);
	}
	oldData="";
	form.n3rd_imdg_clss_cd.focus();
}
// IMDG3 change event
function n3rdImdgClssCd_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		comboObjects[0].SetSelectCode("C");
		addCorrList("BR", "", oldData, document.form.n3rd_imdg_clss_cd.value);
	}else {
		comboObjects[0].SetSelectCode("P");
		addCorrList("BR", "화주 요청에 의한 정정", oldData, document.form.n3rd_imdg_clss_cd.value);
	}
	oldData="";
	form.pck_qty.focus();
}
// Shipper Name change event
function sCustNm_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BC", "", oldData, document.form.s_cust_nm.value);
	}else {
		addCorrList("BC", "화주 요청에 의한 정정", oldData, document.form.s_cust_nm.value);
	}
	oldData="";
	form.s_cust_addr.focus();
}
// Shipper Addr change event
function sCustAddr_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BC", "", oldData, document.form.s_cust_addr.value);
	}else {
		addCorrList("BC1", "화주 요청에 의한 정정", oldData, document.form.s_cust_addr.value);
	}
	oldData="";
	form.c_cust_nm.focus();
}
// Cosignee Name change event
function cCustNm_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BD", "", oldData, document.form.c_cust_nm.value);
	}else {
		addCorrList("BD", "화주 요청에 의한 정정", oldData, document.form.c_cust_nm.value);
	}
	oldData="";
	form.c_cust_addr.focus();
}
// Cosignee Addr change event
function cCustAddr_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BD1", "", oldData, document.form.c_cust_addr.value);
	}else {
		addCorrList("BD1", "화주 요청에 의한 정정", oldData, document.form.c_cust_addr.value);
	}
	oldData="";
	form.n_cust_nm.focus();
}
// Notify Name change event
function nCustNm_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BE", "", oldData, document.form.n_cust_nm.value);
	}else {
		addCorrList("BE", "화주 요청에 의한 정정", oldData, document.form.n_cust_nm.value);
	}
	oldData="";
	form.n_cust_addr.focus();
}
// Notify Addr change event
function nCustAddr_onChange()
{
	// IN BOUND
	if (document.form.io_bnd_cd.value=="I") {
		addCorrList("BE1", "", oldData, document.form.n_cust_addr.value);
	}else {
		addCorrList("BE1", "화주 요청에 의한 정정", oldData, document.form.n_cust_addr.value);
	}
	oldData="";
}
// setting old data
function setOldData(val) {
	oldData=val;
}
// adding history at VVD-B/L Cor List grid
function addCorrList(corr_id, corr_rsn, old1, new1)
{
	var canUpdate=false;
	// updating in case of existing same corr_id and old2, new2 is null
	for (var i=1; i <= sheetObjects[2].RowCount(); i++ ) {
if (sheetObjects[2].GetCellValue(i, "pre_ctnt2")!="" || sheetObjects[2].GetCellValue(i, "pre_ctnt2")!="") continue;
if (sheetObjects[2].GetCellValue(i, "kr_cstms_corr_id")!=corr_id) continue;
		canUpdate=true;
		sheetObjects[2].SetCellValue(i, "pre_ctnt2",old1);
		sheetObjects[2].SetCellValue(i, "crnt_ctnt2",new1);
		break;
	}
	if (canUpdate==false) {
		sheetObjects[2].DataInsert(-1);
		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "pre_ctnt1",old1);
		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "crnt_ctnt1",new1);
		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "kr_cstms_corr_id",corr_id);
		sheetObjects[2].SetCellValue(sheetObjects[2].GetSelectRow(), "corr_rsn",corr_rsn);
	}
}
/**
 * adding ','
 * @param obj
 * @param sFormat
 * @return
 */
function ComAddComma3(obj,sFormat)
{
	try {
		//in case of 'obj' = HTML Tag Object
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
